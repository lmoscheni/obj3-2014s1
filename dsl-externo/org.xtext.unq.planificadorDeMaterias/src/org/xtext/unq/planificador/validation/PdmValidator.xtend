/*
 * generated by Xtext
 */
package org.xtext.unq.planificador.validation

import org.eclipse.xtext.validation.Check
import org.xtext.unq.planificador.planificadorDeMateriasDsl.Horario
import org.xtext.unq.planificador.planificadorDeMateriasDsl.Horarios
import org.xtext.unq.planificador.planificadorDeMateriasDsl.Planificacion
import org.xtext.unq.planificador.planificadorDeMateriasDsl.PlanificadorDeMateriasDslPackage
import org.xtext.unq.planificador.planificadorDeMateriasDsl.Profesor
import org.xtext.unq.planificador.planificadorDeMateriasDsl.Materia

//import org.eclipse.xtext.validation.Check
/**
 * Custom validation rules. 
 *
 * see http://www.eclipse.org/Xtext/documentation.html#validation
 */
class PdmValidator extends AbstractPdmValidator {

	//  public static val INVALID_NAME = 'invalidName'
	//
	//	@Check
	//	def checkGreetingStartsWithCapital(Greeting greeting) {
	//		if (!Character.isUpperCase(greeting.name.charAt(0))) {
	//			warning('Name should start with a capital', 
	//					MyDslPackage.Literals.GREETING__NAME,
	//					INVALID_NAME)
	//		}
	//	}
	//}
	@Check
	def validateMateriasAsignadas(Planificacion p){
		var exist = true;
		for(Materia m : p.materias){
			exist = exist && estaAsignado(m,p)
		}
		if(!exist){
			error("Falta asignar una materia", p, PlanificadorDeMateriasDslPackage.Literals.PLANIFICACION__HORARIO)
		}
	}
	
	def estaAsignado(Materia m, Planificacion p) {
		p.horario.horarios.exists[ h | (h.materia.name.equals(m.name))]
	}
	
	@Check
	def validateDedicacion(Profesor p){
		println(p.dedicacion)
		if((p.dedicacion.eClass.name.equals("EXCLUSIVA")) && (p.materias.size < 2 || p.materias.size > 5)){
			error('''Tiene «p.materias.size» y necesita de 2 hasta 5 materias''', p, PlanificadorDeMateriasDslPackage.Literals.PROFESOR__DEDICACION )
		}
		if((p.dedicacion.eClass.name.equals("SEMI")) && (p.materias.size != 2)){
			error('''Tiene «p.materias.size» y necesita de 2 materias''', p, PlanificadorDeMateriasDslPackage.Literals.PROFESOR__DEDICACION )
		}
		if(p.dedicacion.eClass.name.equals("SIMPLE") && (p.materias.size != 1)){
			error('''Tiene «p.materias.size» y necesita de 1 materia''', p, PlanificadorDeMateriasDslPackage.Literals.PROFESOR__DEDICACION )
		}
		
	}
	
	@Check
	def validateDayNotRepeated(Planificacion p) {
		if (p.tieneMateriasRepetidas)
			error("Tiene materias repetidas", p, PlanificadorDeMateriasDslPackage.Literals.PLANIFICACION__MATERIAS)
	}
	
	def tieneMateriasRepetidas(Planificacion p) {
		p.materias.toSet.size < p.materias.size
	}

	@Check
	def validateDayNotRepeateasd(Horario h) {
		val horarios = h.eContainer as Horarios
	}
}
