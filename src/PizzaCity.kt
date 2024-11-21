abstract class PizzaCity(
    protected val neapolitanPizzaPrice: Double,
    protected val romanPizzaPrice: Double,
    protected val sicilianPizzaPrice: Double,
    protected val tyroleanPizzaPrice: Double
) {
    var neapolitanPizzaCount = 0
    var romanPizzaCount = 0
    var sicilianPizzaCount = 0
    var tyroleanPizzaCount = 0

    abstract fun neapolitanPizzaSale()
    abstract fun romanPizzaSale()
    abstract fun sicilianPizzaSale()
    abstract fun tyroleanPizzaSale()

    open fun showStatistics() {
        println("Продано неаполитанской пиццы: $neapolitanPizzaCount")
        println("Продано римской пиццы: $romanPizzaCount")
        println("Продано сицилийской пиццы: $sicilianPizzaCount")
        println("Продано тирольской пиццы: $tyroleanPizzaCount")
    }

    open fun calculateTotalEarnings(): Double {
        return (neapolitanPizzaCount * neapolitanPizzaPrice) +
                (romanPizzaCount * romanPizzaPrice) +
                (sicilianPizzaCount * sicilianPizzaPrice) +
                (tyroleanPizzaCount * tyroleanPizzaPrice)
    }
}