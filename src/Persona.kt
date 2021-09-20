import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter

class Persona (nombre:String, var fechaNacimiento:String, var madreSoltera:Boolean=false) {
    fun edad(): Int {
        val fechaActual = LocalDate.now()
        var fecha = LocalDate.parse(fechaNacimiento, DateTimeFormatter.ofPattern("dd-MM-yyyy"))
        var edadActual= Period.between(
            fecha,
            fechaActual
        ).years
        return edadActual
    }
}
