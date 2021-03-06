package dsl;

import ExtensionMethods.ExtensionMethods;
import dominio.Agenda;
import dominio.Evento;
import dominio.Hora;
import dominio.MockAgendaListener;
import dominio.RecordatorioEMAIL;
import java.util.ArrayList;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class AgendaDSL {
  @Extension
  private ExtensionMethods _extensionMethods = new ExtensionMethods();
  
  public static void main(final String[] args) {
    AgendaDSL _agendaDSL = new AgendaDSL();
    _agendaDSL.run();
  }
  
  public void run() {
    Hora _hs = this._extensionMethods.hs(14);
    Evento _mappedTo = this._extensionMethods.operator_mappedTo(_hs, "Inicia objectos 3");
    Hora _divide = this._extensionMethods.operator_divide(18, 25);
    Hora _hs_1 = this._extensionMethods.hs(_divide);
    Evento _mappedTo_1 = this._extensionMethods.operator_mappedTo(_hs_1, "Termina objectos 3");
    final Procedure1<Evento> _function = new Procedure1<Evento>() {
      public void apply(final Evento it) {
        Evento _remainMe = AgendaDSL.this._extensionMethods.remainMe(it);
        String _via = AgendaDSL.this._extensionMethods.via("Escribir bitacora");
        RecordatorioEMAIL _EMAIL = AgendaDSL.this._extensionMethods.EMAIL(_via);
        final Procedure1<RecordatorioEMAIL> _function = new Procedure1<RecordatorioEMAIL>() {
          public void apply(final RecordatorioEMAIL it) {
            it.setTarget("skalic.julian@gmail.com");
            it.setSubject("Tarea");
          }
        };
        RecordatorioEMAIL _doubleArrow = ObjectExtensions.<RecordatorioEMAIL>operator_doubleArrow(_EMAIL, _function);
        AgendaDSL.this._extensionMethods.operator_greaterThan(_remainMe, _doubleArrow);
        InputOutput.<String>println("Coorre");
        Evento _remainMe_1 = AgendaDSL.this._extensionMethods.remainMe(it);
        String _via_1 = AgendaDSL.this._extensionMethods.via("Escribir ejemplos de la clase");
        RecordatorioEMAIL _EMAIL_1 = AgendaDSL.this._extensionMethods.EMAIL(_via_1);
        AgendaDSL.this._extensionMethods.operator_greaterThan(_remainMe_1, _EMAIL_1);
        Evento _remainMe_2 = AgendaDSL.this._extensionMethods.remainMe(it);
        final Function1<Object, String> _function_1 = new Function1<Object, String>() {
          public String apply(final Object it) {
            String _xblockexpression = null;
            {
              InputOutput.<String>println("Hola mundo!");
              _xblockexpression = InputOutput.<String>println("Funciona :D");
            }
            return _xblockexpression;
          }
        };
        AgendaDSL.this._extensionMethods.operator_doubleGreaterThan(_remainMe_2, _function_1);
      }
    };
    Evento _doubleArrow = ObjectExtensions.<Evento>operator_doubleArrow(_mappedTo_1, _function);
    final Agenda agenda = this._extensionMethods.agenda(_mappedTo, _doubleArrow);
    final MockAgendaListener listener = this._extensionMethods.crearListener();
    Hora _hs_2 = this._extensionMethods.hs(13);
    Hora _hs_3 = this._extensionMethods.hs(20);
    ArrayList<Hora> _doubleGreaterThan = this._extensionMethods.operator_doubleGreaterThan(_hs_2, _hs_3);
    final Procedure1<Hora> _function_1 = new Procedure1<Hora>() {
      public void apply(final Hora hora) {
        agenda.tick(hora, listener);
      }
    };
    IterableExtensions.<Hora>forEach(_doubleGreaterThan, _function_1);
  }
}
