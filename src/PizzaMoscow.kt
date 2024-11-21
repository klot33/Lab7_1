class PizzaMoscow(
    neapolitanPizzaPrice: Double,
    romanPizzaPrice: Double,
    sicilianPizzaPrice: Double,
    tyroleanPizzaPrice: Double
) : PizzaCity(
    neapolitanPizzaPrice, romanPizzaPrice,
    sicilianPizzaPrice, tyroleanPizzaPrice
), CheckPhoto {

    override var checkCount = 0
    override val checkDiscount = 50.0

    override fun showCheckPhoto() {
        println("У вас есть фотография чека?")
        println("1. Да\n2. Нет")
        if (readln() == "1") {
            checkCount++
            println("Вы показали чек, вам будет скидка $checkDiscount руб. с покупки.")
        } else {
            println("Вы не показали чек.")
        }
    }

    override fun neapolitanPizzaSale() {
        neapolitanPizzaCount++
        println("Спасибо за покупку неаполитанской пиццы в Москве")
    }

    override fun romanPizzaSale() {
        romanPizzaCount++
        println("Спасибо за покупку римской пиццы в Москве")
    }

    override fun sicilianPizzaSale() {
        sicilianPizzaCount++
        println("Спасибо за покупку сицилийской пиццы в Москве")
    }

    override fun tyroleanPizzaSale() {
        tyroleanPizzaCount++
        println("Спасибо за покупку тирольской пиццы в Москве")
    }

    override fun showStatistics() {
        super.showStatistics()
        val totalEarnings = calculateTotalEarnings() - (checkCount * checkDiscount)
        println("Всего заработано денег: $totalEarnings")
        println("Показано чеков: $checkCount")
        println("Общая сумма скидок: ${checkCount * checkDiscount}")
        showCheckStatistics()
    }

    private fun showCheckStatistics() {
        val checkPercentage = (checkCount.toDouble() / totalPizzaSales()) * 100
        println("Процент людей, показавших чек: ${String.format("%.2f", checkPercentage)}%")
        val noCheckPercentage = 100 - checkPercentage
        println("Процент людей, не показавших чек: ${String.format("%.2f", noCheckPercentage)}%")
    }

    private fun totalPizzaSales(): Int {
        return neapolitanPizzaCount + romanPizzaCount + sicilianPizzaCount + tyroleanPizzaCount
    }
}