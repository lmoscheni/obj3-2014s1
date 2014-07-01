/*
 * generated by Xtext
 */
package org.xtext.unq.planificador.validation

import java.util.List
import org.eclipse.xtext.validation.Check
import org.xtext.unq.planificador.planificadorDeMateriasDsl.Asignacion
import org.xtext.unq.planificador.planificadorDeMateriasDsl.Materia
import org.xtext.unq.planificador.planificadorDeMateriasDsl.Model
import org.xtext.unq.planificador.planificadorDeMateriasDsl.Planificacion
import org.xtext.unq.planificador.planificadorDeMateriasDsl.PlanificadorDeMateriasDslPackage
import org.xtext.unq.planificador.planificadorDeMateriasDsl.Profesor
import org.xtext.unq.planificador.planificadorDeMateriasDsl.Recurso

//import org.eclipse.xtext.validation.Check
/**
 * Custom validation rules. 
 *
 * see http://www.eclipse.org/Xtext/documentation.html#validation
 */
class PdmValidator extends AbstractPdmValidator {


	@Check
	def validateMateriasAsignadas(Planificacion p){
		var model = p.eContainer as Model
		for(Materia m : model.elementosPrimarios.filter(Materia)){
			p.estaAsignado(m)
		}
	}
	
	def estaAsignado(Planificacion p,Materia m) {
		if(!p.asignaciones.exists[ a | a.materia.name.equals(m.name)]){
			error("Falta asignar una materia", m, PlanificadorDeMateriasDslPackage.Literals.MATERIA__NAME)
		}
	}
	
	@Check
	def validateMateriasRepetidas(Model m){
		val materias = m.elementosPrimarios.filter(Materia)
		materias.forEach[ materia | estaRepetido(materia,materias)]
	}
	
	def estaRepetido(Materia materia, Iterable<Materia> m){
		var count = 0
		for(Materia mat : m){
			if(mat.name.equals(materia.name)){
				count = count + 1
			}
		}
		if(count >= 2){
			error("Materia repetida", materia, PlanificadorDeMateriasDslPackage.Literals.MATERIA__NAME)
		}
	}	
	
	@Check
	def validateTieneLosRecursosNecesarios(Planificacion p){
		var model = p.eContainer as Model
		for(Materia m : model.elementosPrimarios.filter(Materia)){
			if(m.tieneRecursos){
				m.verificarRecursosEnMateria(p.asignaciones)
			}
		}
	}
	
	def verificarRecursosEnMateria(Materia m, List<Asignacion> asignaciones){
		asignaciones.forEach[ a | 
			if(a.materia.name.equals(m.name)){
				a.aulaHorarios.forEach[ aulaHorario |
					m.tieneLosRecursosNecesarios(aulaHorario.aula.recursos)
				]
			}
		]
	}
	
	def tieneLosRecursosNecesarios(Materia m, List<Recurso> recursos){
		recursos.forEach[ r |
			if(!m.recursos.exists[rec | rec.name.equals(r.name)]){
				error("La materia esta siendo asignada sin los recursos necesarios", m,
					PlanificadorDeMateriasDslPackage.Literals.MATERIA__NAME)
			}
		]
	}
	
	def tieneRecursos(Materia m){
		m.recursos.size > 0
	}
	
//	@Check
//	def validateMateriasAsignadas(Planificacion p){
//		var exist = true;
//		for(Materia m : p.materias){
//			exist = exist && estaAsignado(m,p)
//		}
//		if(!exist){
//			error("Falta asignar una materia", p, PlanificadorDeMateriasDslPackage.Literals.PLANIFICACION__HORARIO)
//		}
//	}
//	
//	def estaAsignado(Materia m, Planificacion p) {
//		p.horario.horarios.exists[ h | (h.materia.name.equals(m.name))]
//	}
//	

	@Check
	def validateDedicacion(Profesor p){
		p.materiasQueDicta(p.eContainer as Model)
	}
	
	def validarDedicacion(Profesor p, int materiasQueDicta, Planificacion pl){
		if ((p.dedicacion.eClass.name.equals("EXCLUSIVA")) && (materiasQueDicta < 2 || materiasQueDicta > 5)) {
			error('''Tiene «materiasQueDicta» materia asignada y necesita de 2 hasta 5 materias''', p,
				PlanificadorDeMateriasDslPackage.Literals.PROFESOR__NAME)
			error('''Tiene «materiasQueDicta» materia asignada y necesita de 2 hasta 5 materias''', pl,
				PlanificadorDeMateriasDslPackage.Literals.PLANIFICACION__ASIGNACIONES)
		}
		if ((p.dedicacion.eClass.name.equals("SEMI")) && (materiasQueDicta != 2)) {
			error('''Tiene «materiasQueDicta» materia asignada y necesita de 2 materias''', p,
				PlanificadorDeMateriasDslPackage.Literals.PROFESOR__NAME)
			error('''Tiene «materiasQueDicta» materia asignada y necesita de 2 materias''', pl,
				PlanificadorDeMateriasDslPackage.Literals.PLANIFICACION__ASIGNACIONES)
		}
		if (p.dedicacion.eClass.name.equals("SIMPLE") && (materiasQueDicta != 1)) {
			error('''Tiene «materiasQueDicta» materia asignada y necesita de 1 materia''', p,
				PlanificadorDeMateriasDslPackage.Literals.PROFESOR__NAME)
			error('''Tiene «materiasQueDicta» materia asignada y necesita de 1 materia''', pl,
				PlanificadorDeMateriasDslPackage.Literals.PLANIFICACION__ASIGNACIONES)
		}
	}
	
	def materiasQueDicta(Profesor p , Model model) {
		var planificaciones = model.planificacion
		var count = 0
		for (Planificacion planificacion : planificaciones) {
			for (Asignacion a : planificacion.asignaciones) {
				if (a.profesores.exists[profe|profe.name.equals(p.name)]) {
					count = count + 1
				}
			}
			p.validarDedicacion(count, planificacion)
			count = 0
		}
	}
//	@Check
//	def validateMateriasRepetidas(Planificacion m){
//		for(Materia materia : m.materias){
//			if(estaRepetido(materia, m.materias)){
//				error("Materias repetidas", m, PlanificadorDeMateriasDslPackage.Literals.PLANIFICACION__MATERIAS)
//			} 
//		}
//	}
//	
//	@Check
//	def validateDayNotRepeated(Planificacion p) {
//		if (p.tieneMateriasRepetidas)
//			error("Tiene materias repetidas", p, PlanificadorDeMateriasDslPackage.Literals.PLANIFICACION__MATERIAS)
//	}
//	
//	def tieneMateriasRepetidas(Planificacion p) {
//		p.materias.toSet.size < p.materias.size
//	}
//
//	@Check
//	def validateDayNotRepeateasd(Horario h) {
//		val horarios = h.eContainer as Horarios
//	}
}
