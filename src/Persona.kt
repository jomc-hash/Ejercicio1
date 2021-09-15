class Persona (nombre:String) {

}
interface IZona{
    fun calcularCosto(extension: Double) :Double
}

class zonaMarginada():IZona{
    override fun calcularCosto(extension:Double): Double {
        return extension*2.00
    }
}


class zonaRural():IZona{
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
    fun calcularDescuento(){

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
        calcularDescuento()
        calcularTotal()
    }
}

fun main(){
    var propietario = Persona("Jose Manuel")
   var propiedadesJose = Propiedades(propietario)
    propiedadesJose.agregarPropiedad(Predio(zonaRural(),400.0))
    propiedadesJose.agregarPropiedad(Predio(zonaRural(),100.0))
    propiedadesJose.agregarPropiedad(Predio(zonaRural(),600.0))
    propiedadesJose.agregarPropiedad(Predio(zonaRural(),200.0))

    println("Total antes de descuento : "+propiedadesJose.calcularTotal())
    propiedadesJose.calcularPago()
}