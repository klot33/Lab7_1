class PizzaPeter(
    neapolitanPizzaPrice: Double,
    romanPizzaPrice: Double,
    sicilianPizzaPrice: Double,
    tyroleanPizzaPrice: Double
) : PizzaCity(
    neapolitanPizzaPrice, romanPizzaPrice,
    sicilianPizzaPrice, tyroleanPizzaPrice
), Drink {

    override var coffeeCount = 0
    override val coffeePrice = 200.0

    override var neapolitanPizzaCountCoffee = 0
    override var romanPizzaCountCoffee = 0
    override var sicilianPizzaCountCoffee = 0
    override var tyroleanPizzaCountCoffee = 0

    override fun drinkSale() {
        println("Вы будете кофе?")
        println("1. Да\n2. Нет")
        if (readln() == "1") {
            coffeeCount++
            updateCoffeeCountForPizza()
            println("С вас $coffeePrice руб.")
        }
    }

    private fun updateCoffeeCountForPizza() {
        when {
            neapolitanPizzaCount > neapolitanPizzaCountCoffee -> neapolitanPizzaCountCoffee++
            romanPizzaCount > romanPizzaCountCoffee -> romanPizzaCountCoffee++
            sicilianPizzaCount > sicilianPizzaCountCoffee -> sicilianPizzaCountCoffee++
            tyroleanPizzaCount > tyroleanPizzaCountCoffee -> tyroleanPizzaCountCoffee++
        }
    }

    override fun neapolitanPizzaSale() {
        neapolitanPizzaCount++
        println("Спасибо за покупку неаполитанской пиццы в Санкт-Петербурге")
    }

    override fun romanPizzaSale() {
        romanPizzaCount++
        println("Спасибо за покупку римской пиццы в Санкт-Петербурге")
    }

    override fun sicilianPizzaSale() {
        sicilianPizzaCount++
        println("Спасибо за покупку сицилийской пиццы в Санкт-Петербурге")
    }

    override fun tyroleanPizzaSale() {
        tyroleanPizzaCount++
        println("Спасибо за покупку тирольской пиццы в Санкт-Петербурге")
    }

    override fun showStatistics() {
        super.showStatistics()
        val totalEarnings = calculateTotalEarnings() + (coffeeCount * coffeePrice)
        println("Всего заработано денег: $totalEarnings")
        println("Продано кофе: $coffeeCount")
        println("Заработано на кофе: ${coffeeCount * coffeePrice}")
        showCoffeeStatistics()
    }

    private fun showCoffeeStatistics() {
        println("Неаполитанская пицца с кофе: $neapolitanPizzaCountCoffee (${calculatePercentage(neapolitanPizzaCountCoffee)}%)")
        println("Римская пицца с кофе: $romanPizzaCountCoffee (${calculatePercentage(romanPizzaCountCoffee)}%)")
        println("Сицилийская пицца с кофе: $sicilianPizzaCountCoffee (${calculatePercentage(sicilianPizzaCountCoffee)}%)")
        println("Тирольская пицца с кофе: $tyroleanPizzaCountCoffee (${calculatePercentage(tyroleanPizzaCountCoffee)}%)")

        val coffeePercentage = (coffeeCount.toDouble() / totalPizzaSales()) * 100
        println("Процент людей, купивших кофе: ${String.format("%.2f", coffeePercentage)}%")
        val noCoffeePercentage = 100 - coffeePercentage
        println("Процент людей, отказавшихся от кофе: ${String.format("%.2f", noCoffeePercentage)}%")
    }

    private fun calculatePercentage(count: Int): String {
        return if (coffeeCount == 0) "0.00" else String.format("%.2f", (count.toDouble() / coffeeCount) * 100)
    }

    private fun totalPizzaSales(): Int {
        return neapolitanPizzaCount + romanPizzaCount + sicilianPizzaCount + tyroleanPizzaCount
    }
}