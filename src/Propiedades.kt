import java.time.LocalDate

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
    fun calcularPago(): Double {
        var mes= LocalDate.now().month.value
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
        return (totalSinDescuento - (totalSinDescuento * porcentajeDescuento))
    }

}