package testDominio

import dominio.Agenda
import dominio.Evento
import dominio.Hora
import dominio.MockAgendaListener
import dominio.Recordatorio
import dominio.RecordatorioSMS
import org.junit.Before
import org.junit.Test

import static org.junit.Assert.*

class testAgenda {
	
	var Agenda agenda 
	var Evento evento 
	var Hora hora
	var Recordatorio recordatorio
	var MockAgendaListener mock
	var String mensaje
	
	@Before
	def void setUp(){
		
		this.mensaje="Inicia OBJ3"
		this.agenda = new Agenda
		this.hora = new Hora(14)
		this.evento = new Evento(this.hora, this.mensaje)
		this.recordatorio = new RecordatorioSMS("Escribir bitacora")
		this.evento.agregarRecordatorio(this.recordatorio)
		this.agenda.agregarEvento(this.evento)
		this.mock = new MockAgendaListener
	}
	
	@Test
	def void testNotificarEvento(){
		this.agenda.tick(this.hora, this.mock)
		assertEquals(this.evento, this.mock.evento)
	}
	
	@Test
	def void testNotificarRecordatorioSMS(){
		this.agenda.tick(new Hora(13), this.mock)
		assertEquals("Escribir bitacora", this.mock.recordatorioSMS)
	}
}