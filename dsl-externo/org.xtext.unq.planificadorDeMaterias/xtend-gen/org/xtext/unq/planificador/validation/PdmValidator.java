/**
 * generated by Xtext
 */
package org.xtext.unq.planificador.validation;

import com.google.common.collect.Iterables;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.xtext.unq.planificador.planificadorDeMateriasDsl.Asignacion;
import org.xtext.unq.planificador.planificadorDeMateriasDsl.Dedicacion;
import org.xtext.unq.planificador.planificadorDeMateriasDsl.ElementosPrimarios;
import org.xtext.unq.planificador.planificadorDeMateriasDsl.Materia;
import org.xtext.unq.planificador.planificadorDeMateriasDsl.Model;
import org.xtext.unq.planificador.planificadorDeMateriasDsl.Planificacion;
import org.xtext.unq.planificador.planificadorDeMateriasDsl.PlanificadorDeMateriasDslPackage;
import org.xtext.unq.planificador.planificadorDeMateriasDsl.Profesor;
import org.xtext.unq.planificador.validation.AbstractPdmValidator;

/**
 * Custom validation rules.
 * 
 * see http://www.eclipse.org/Xtext/documentation.html#validation
 */
@SuppressWarnings("all")
public class PdmValidator extends AbstractPdmValidator {
  @Check
  public void validateMateriasRepetidas(final Model m) {
    EList<ElementosPrimarios> _elementosPrimarios = m.getElementosPrimarios();
    Iterable<Materia> _filter = Iterables.<Materia>filter(_elementosPrimarios, Materia.class);
    for (final Materia materia : _filter) {
      EList<ElementosPrimarios> _elementosPrimarios_1 = m.getElementosPrimarios();
      Iterable<Materia> _filter_1 = Iterables.<Materia>filter(_elementosPrimarios_1, Materia.class);
      this.estaRepetido(materia, _filter_1);
    }
  }
  
  public void estaRepetido(final Materia materia, final Iterable<Materia> m) {
    int count = 0;
    boolean ret = false;
    for (final Materia mat : m) {
      String _name = mat.getName();
      String _name_1 = materia.getName();
      boolean _equals = _name.equals(_name_1);
      if (_equals) {
        count = (count + 1);
      }
    }
    if ((count >= 2)) {
      this.error("Materia repetida", materia, PlanificadorDeMateriasDslPackage.Literals.MATERIA__NAME);
    }
  }
  
  @Check
  public void validateDedicacion(final Profesor p) {
    EObject _eContainer = p.eContainer();
    this.materiasQueDicta(p, ((Model) _eContainer));
  }
  
  public void validarDedicacion(final Profesor p, final Planificacion planificacion, final int materiasQueDicta) {
    boolean _and = false;
    Dedicacion _dedicacion = p.getDedicacion();
    EClass _eClass = _dedicacion.eClass();
    String _name = _eClass.getName();
    boolean _equals = _name.equals("EXCLUSIVA");
    if (!_equals) {
      _and = false;
    } else {
      _and = ((materiasQueDicta < 2) || (materiasQueDicta > 5));
    }
    if (_and) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Tiene ");
      _builder.append(materiasQueDicta, "");
      _builder.append(" y necesita de 2 hasta 5 materias");
      this.error(_builder.toString(), planificacion, 
        PlanificadorDeMateriasDslPackage.Literals.PLANIFICACION__ASIGNACIONES);
    }
    boolean _and_1 = false;
    Dedicacion _dedicacion_1 = p.getDedicacion();
    EClass _eClass_1 = _dedicacion_1.eClass();
    String _name_1 = _eClass_1.getName();
    boolean _equals_1 = _name_1.equals("SEMI");
    if (!_equals_1) {
      _and_1 = false;
    } else {
      _and_1 = (materiasQueDicta != 2);
    }
    if (_and_1) {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Tiene ");
      _builder_1.append(materiasQueDicta, "");
      _builder_1.append(" y necesita de 2 materias");
      this.error(_builder_1.toString(), planificacion, 
        PlanificadorDeMateriasDslPackage.Literals.PLANIFICACION__ASIGNACIONES);
    }
    boolean _and_2 = false;
    Dedicacion _dedicacion_2 = p.getDedicacion();
    EClass _eClass_2 = _dedicacion_2.eClass();
    String _name_2 = _eClass_2.getName();
    boolean _equals_2 = _name_2.equals("SIMPLE");
    if (!_equals_2) {
      _and_2 = false;
    } else {
      _and_2 = (materiasQueDicta != 1);
    }
    if (_and_2) {
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("Tiene ");
      _builder_2.append(materiasQueDicta, "");
      _builder_2.append(" y necesita de 1 materia");
      this.error(_builder_2.toString(), planificacion, 
        PlanificadorDeMateriasDslPackage.Literals.PLANIFICACION__ASIGNACIONES);
    }
  }
  
  public void materiasQueDicta(final Profesor p, final Model model) {
    EList<Planificacion> planificaciones = model.getPlanificacion();
    int count = 0;
    for (final Planificacion planificacion : planificaciones) {
      {
        EList<Asignacion> _asignaciones = planificacion.getAsignaciones();
        for (final Asignacion a : _asignaciones) {
          EList<Profesor> _profesores = a.getProfesores();
          final Function1<Profesor, Boolean> _function = new Function1<Profesor, Boolean>() {
            public Boolean apply(final Profesor profe) {
              String _name = profe.getName();
              String _name_1 = p.getName();
              return Boolean.valueOf(_name.equals(_name_1));
            }
          };
          boolean _exists = IterableExtensions.<Profesor>exists(_profesores, _function);
          if (_exists) {
            count = (count + 1);
          }
        }
        this.validarDedicacion(p, planificacion, count);
      }
    }
  }
}
