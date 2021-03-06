package Clases

import org.joda.time.DateTime
import scala.collection.mutable.ArrayBuffer
import Excepciones.NoTieneIluminacion
import Excepciones.YaEstaReservada
import Excepciones.UsadaParaTorneo

abstract class Cancha() {
	val reservas = new ArrayBuffer[Reserva]


	/*
	 * Operaciones de Negocio
	 */
	def reservar(dia : DateTime , inicio : Double , fin : Double){
	  this.chequearSiPuedeReservar(dia, inicio, fin)
	  this.reservas+= new Reserva(this,dia,inicio,fin)
	  println(this.precioFinal(dia, inicio, fin))
	}
	
	/*
	 * Operaciones Internas 
	 */
	protected def chequearSiPuedeReservar(dia : DateTime, inicio : Double, fin : Double){
	  if(this.hayReserva(dia,inicio,fin)){
	      throw new YaEstaReservada()
	  }
	  if(this.esDeNoche(inicio) & ! this.tieneIluminacion){
	      throw new NoTieneIluminacion
	  }
	}

    def hayReserva(dia : DateTime, inicio : Double, fin : Double) : Boolean ={
		val existeReserva = reservas.exists{ r => this.sonElMismoDia(r.dia, dia) & this.seSuperponenHorarios(r.inicio, r.fin, inicio, fin) }
		return(existeReserva)
    }
	
	private def seSuperponenHorarios(inicio1 : Double, fin1 : Double, inicio2 : Double, fin2 : Double) : Boolean = {
	  val seSuperpone = ((inicio1 < inicio2 & inicio2 < fin1) | (inicio1 < fin2 & fin2 < fin1) | (inicio1 == inicio2 & fin1 == fin2))
	  return(seSuperpone)
	}
	
	private def esDeNoche(horaInicio : Double) = (horaInicio >= 18)
	
	protected def esFinDeSemana(dia : DateTime) = (dia.dayOfWeek().getAsText() == "sábado" | dia.dayOfWeek().getAsText() == "domingo")
	
	private def tienenElMismoAño(d1 : DateTime, d2 : DateTime) : Boolean = d1.year().equals(d2.year())
	
	private def tienenElMismoMes(d1 : DateTime, d2 : DateTime) : Boolean = d1.monthOfYear().equals(d2.monthOfYear())
	
	private def tienenElMismoDia(d1 : DateTime, d2 : DateTime) : Boolean = d1.dayOfMonth().equals(d2.dayOfMonth())
	
	private def sonElMismoDia(d1 : DateTime , d2 : DateTime) : Boolean ={
	  (this.tienenElMismoAño(d1, d2) & this.tienenElMismoMes(d1, d2) & this.tienenElMismoDia(d1, d2))
	}
	
	/*
	 * Operaciones de Dominio
	 */
  
	def tieneIluminacion() = false

	def precioBase() : Double 
	
	def precioFinal(dia : DateTime, inicio : Double, fin : Double) : Double ={
	  this.precioBase() + this.calcularExtra(dia, inicio, fin, this.precioBase)
	}

	def calcularExtra(dia : DateTime, inicio : Double, fin : Double, pb : Double) : Double = 0
	
	 /*
	 * Operaciones de estadistica
	 */
    def obtenerReservasPara(dia: DateTime) = {
	  this.reservas.filter { r => sonElMismoDia(dia, r.dia) }
	}
	
	def cantidadDeReservas(): Int = {
	  this.reservas.length
	}
	
	def facturacionTotal(): Double = {
	  var total: Double = 0
	  this.reservas.foreach { r => total += this.precioFinal(r.dia, r.inicio, r.fin) }
	  total
	}
	
	def tieneReserva(dia: DateTime): Boolean = {
	  this.reservas.exists { r => sonElMismoDia(dia, r.dia) }
	}
}
	
