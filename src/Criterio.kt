class Criterio (mes: Int, edad: Int, madreSoltera:Boolean, descuento:Double  ) {
    var mes=mes
    var edad=edad
    var madreSoltera=madreSoltera
    var descuento= descuento

    fun cumple(): Boolean {
        return true
    }
}




interface ICriterioEdad{
 fun matchEdad(edad: Int): Boolean {
    return (edad>=70)
 }
}


interface ICriterioMadreSoltera{
    fun matchMadreSoltera(madreSoltera: Boolean): Boolean {
        return (madreSoltera==true)

    }
}

interface ICriterioMes{
    fun matchMes(mes: Int):Boolean
}

class MiCriterio1 (edad:Int) :ICriterioEdad, ICriterioMadreSoltera, ICriterioMes{
    var edad=edad
    var madreSoltera=true
    fun aplicaDescuento(): Boolean {
        return matchEdad(edad)&&matchMadreSoltera(madreSoltera)&&matchMes(3)
    }
    override fun matchEdad(edad: Int): Boolean {
        return super.matchEdad(edad)
    }

    override fun matchMadreSoltera(madreSoltera: Boolean): Boolean {
        return super.matchMadreSoltera(madreSoltera)
    }

    override fun matchMes(mes: Int): Boolean {
        var matched= arrayOf(1,2).contains(mes)
        return (matched)
    }
}

fun main(){
    var objmiCriterio= MiCriterio1(15)
    var objmiCriterio2= MiCriterio1(27)
    var objmiCriterio4= MiCriterio1(69)
    var objmiCriterio5= MiCriterio1(88)

    var arrayCriterios= arrayOf(objmiCriterio, objmiCriterio2, objmiCriterio4, objmiCriterio5)
    arrayCriterios.forEach { criterio ->
       if ( criterio.aplicaDescuento())
       {
           println("AAAAAA")
       }else    {
           println("No")
       }
    }
}
