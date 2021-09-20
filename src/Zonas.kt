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
