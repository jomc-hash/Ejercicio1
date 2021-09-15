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
interface IZona{
    var clave:String
    var descripcion:String
    fun calcularCosto(extension: Double) :Double
}

class zonaMarginada():IZona{
    override var clave: String= "MAR"
    override var descripcion ="Marginada"
    override fun calcularCosto(extension:Double): Double {
        return extension*2.00
    }
}


class zonaRural():IZona{
    override var clave: String= "RUR"
    override var descripcion ="Rural"
    override fun calcularCosto(extension:Double): Double {
        return extension*8.00
    }
}

class zonaUrbana():IZona{
    override var clave: String= "URB"
    override var descripcion ="Urbana"
    override fun calcularCosto(extension:Double): Double {
        return extension*8.00
    }
}

class zonaResidencial():IZona{
    override var clave: String= "RES"
    override var descripcion ="Residencial"
    override fun calcularCosto(extension:Double): Double {
        return extension*8.00
    }
}


class  Predio( zona: IZona, extension: Double){

    var extension = extension
    var zona= zona
    fun calcularCosto(): Double {
    return        zona.calcularCosto(extension)
    }

}


class Propiedades(persona: Persona){
    var persona=persona
    var arrayPredios = arrayListOf<Predio>()
    fun agregarPropiedad(predio:Predio){
        arrayPredios.add(predio)
    }

    fun calcularTotal() :Double{
        var sumaPredios=0.0
        arrayPredios.forEach {
                predio->sumaPredios+=predio.calcularCosto()
        }
        return sumaPredios
    }
    fun calcularDescuento(){
        println(persona)
    }

    fun calcularPago(){
        fun calcularDescuento(): Double {
            var mes=LocalDate.now().month.value
            var porcentajeDescuento=0.0
            if (mes<=2 ){
                if((persona.edad()>=70 || persona.madreSoltera)){
                    porcentajeDescuento= 0.7
                }
                else {
                    porcentajeDescuento= 0.4
                }
            }
            else if (persona.edad()>=70 || persona.madreSoltera){
                porcentajeDescuento= 0.5
            }
            var  totalSinDescuento= calcularTotal()
            return totalSinDescuento - (totalSinDescuento * porcentajeDescuento)
        }

    }
}

fun main(){
    println(LocalDate.now().month.value)

    var propietario = Persona("Jose Manuel", "12-02-1998")
   var propiedadesJose = Propiedades(propietario)
    propiedadesJose.agregarPropiedad(Predio(zonaRural(),400.0))
    propiedadesJose.agregarPropiedad(Predio(zonaRural(),100.0))
    propiedadesJose.agregarPropiedad(Predio(zonaRural(),600.0))
    propiedadesJose.agregarPropiedad(Predio(zonaRural(),200.0))

    println("Total antes de descuento : "+propiedadesJose.calcularTotal())
    propiedadesJose.calcularPago()
}