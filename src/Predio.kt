class  Predio( zona: IZona, extension: Double){

    var extension = extension
    var zona= zona
    fun calcularCosto(): Double {
        return        zona.calcularCosto(extension)
    }

}