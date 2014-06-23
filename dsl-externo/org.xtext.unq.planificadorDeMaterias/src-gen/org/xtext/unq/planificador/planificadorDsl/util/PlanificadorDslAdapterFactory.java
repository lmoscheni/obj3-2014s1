/**
 */
package org.xtext.unq.planificador.planificadorDsl.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.xtext.unq.planificador.planificadorDsl.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.xtext.unq.planificador.planificadorDsl.PlanificadorDslPackage
 * @generated
 */
public class PlanificadorDslAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static PlanificadorDslPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PlanificadorDslAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = PlanificadorDslPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PlanificadorDslSwitch<Adapter> modelSwitch =
    new PlanificadorDslSwitch<Adapter>()
    {
      @Override
      public Adapter caseModel(Model object)
      {
        return createModelAdapter();
      }
      @Override
      public Adapter caseProfesor(Profesor object)
      {
        return createProfesorAdapter();
      }
      @Override
      public Adapter caseHora(Hora object)
      {
        return createHoraAdapter();
      }
      @Override
      public Adapter caseMateria(Materia object)
      {
        return createMateriaAdapter();
      }
      @Override
      public Adapter caseAula(Aula object)
      {
        return createAulaAdapter();
      }
      @Override
      public Adapter caseCargaHoraria(CargaHoraria object)
      {
        return createCargaHorariaAdapter();
      }
      @Override
      public Adapter caseCargaHorariaDocente(CargaHorariaDocente object)
      {
        return createCargaHorariaDocenteAdapter();
      }
      @Override
      public Adapter caseHorario(Horario object)
      {
        return createHorarioAdapter();
      }
      @Override
      public Adapter caseSemestre(Semestre object)
      {
        return createSemestreAdapter();
      }
      @Override
      public Adapter caseDia(Dia object)
      {
        return createDiaAdapter();
      }
      @Override
      public Adapter caseHorarios(Horarios object)
      {
        return createHorariosAdapter();
      }
      @Override
      public Adapter casePlanificacion(Planificacion object)
      {
        return createPlanificacionAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link org.xtext.unq.planificador.planificadorDsl.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.xtext.unq.planificador.planificadorDsl.Model
   * @generated
   */
  public Adapter createModelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.xtext.unq.planificador.planificadorDsl.Profesor <em>Profesor</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.xtext.unq.planificador.planificadorDsl.Profesor
   * @generated
   */
  public Adapter createProfesorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.xtext.unq.planificador.planificadorDsl.Hora <em>Hora</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.xtext.unq.planificador.planificadorDsl.Hora
   * @generated
   */
  public Adapter createHoraAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.xtext.unq.planificador.planificadorDsl.Materia <em>Materia</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.xtext.unq.planificador.planificadorDsl.Materia
   * @generated
   */
  public Adapter createMateriaAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.xtext.unq.planificador.planificadorDsl.Aula <em>Aula</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.xtext.unq.planificador.planificadorDsl.Aula
   * @generated
   */
  public Adapter createAulaAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.xtext.unq.planificador.planificadorDsl.CargaHoraria <em>Carga Horaria</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.xtext.unq.planificador.planificadorDsl.CargaHoraria
   * @generated
   */
  public Adapter createCargaHorariaAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.xtext.unq.planificador.planificadorDsl.CargaHorariaDocente <em>Carga Horaria Docente</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.xtext.unq.planificador.planificadorDsl.CargaHorariaDocente
   * @generated
   */
  public Adapter createCargaHorariaDocenteAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.xtext.unq.planificador.planificadorDsl.Horario <em>Horario</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.xtext.unq.planificador.planificadorDsl.Horario
   * @generated
   */
  public Adapter createHorarioAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.xtext.unq.planificador.planificadorDsl.Semestre <em>Semestre</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.xtext.unq.planificador.planificadorDsl.Semestre
   * @generated
   */
  public Adapter createSemestreAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.xtext.unq.planificador.planificadorDsl.Dia <em>Dia</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.xtext.unq.planificador.planificadorDsl.Dia
   * @generated
   */
  public Adapter createDiaAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.xtext.unq.planificador.planificadorDsl.Horarios <em>Horarios</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.xtext.unq.planificador.planificadorDsl.Horarios
   * @generated
   */
  public Adapter createHorariosAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.xtext.unq.planificador.planificadorDsl.Planificacion <em>Planificacion</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.xtext.unq.planificador.planificadorDsl.Planificacion
   * @generated
   */
  public Adapter createPlanificacionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //PlanificadorDslAdapterFactory
