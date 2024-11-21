class PizzaMurmansk(
    neapolitanPizzaPrice: Double,
    romanPizzaPrice: Double,
    sicilianPizzaPrice: Double,
    tyroleanPizzaPrice: Double
) : PizzaCity(
    neapolitanPizzaPrice,
    romanPizzaPrice,
    sicilianPizzaPrice,
    tyroleanPizzaPrice
), CheckPhoto, Drink, Sauce {

    override var checkCount = 0
    override val checkDiscount = 40.0
    override var coffeeCount = 0
    override val coffeePrice = 180.0
    override var neapolitanPizzaCountCoffee = 0
    override var romanPizzaCountCoffee = 0
    override var sicilianPizzaCountCoffee = 0
    override var tyroleanPizzaCountCoffee = 0
    override var sauceCount = 0
    override val saucePrice = 50.0
    override var Tsauce = "Томатный"
    override var Ssauce = "Сырный"
    override var Sauce1 = 0
    override var Sauce2 = 0

    override fun showCheckPhoto() {
        println("У вас есть фотография чека?")
        println("1. Да\n2. Нет")
        if (readln() == "1") {
            checkCount++
            println("Вам будет скидка $checkDiscount руб. с покупки")
        } else {
            println("Вы не показали чек.")
        }
    }

    override fun drinkSale() {
        println("Вы будете кофе?")
        println("1. Да\n2. Нет")
        if (readln() == "1") {
            coffeeCount++
            updateCoffeeCountForPizza()
            println("С вас $coffeePrice руб.")
        }
    }

    override fun sauceSale() {
        println("Выберите соус:")
        println("1. Томатный\n2. Сырный")
        when (readln()) {
            "1" -> {
                Sauce1++
                println("Вы выбрали томатный соус. С вас $saucePrice руб.")
            }
            "2" -> {
                Sauce2++
                println("Вы выбрали сырный соус. С вас $saucePrice руб.")
            }
        }
        sauceCount++
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
        println("Спасибо за покупку неаполитанской пиццы в Мурманске")
        offerAdditionalServices()
    }

    override fun romanPizzaSale() {
        romanPizzaCount++
        println("Спасибо за покупку римской пиццы в Мурманске")
        offerAdditionalServices()
    }

    override fun sicilianPizzaSale() {
        sicilianPizzaCount++
        println("Спасибо за покупку сицилийской пиццы в Мурманске")
        offerAdditionalServices()
    }

    override fun tyroleanPizzaSale() {
        tyroleanPizzaCount++
        println("Спасибо за покупку тирольской пиццы в Мурманске")
        offerAdditionalServices()
    }

    private fun offerAdditionalServices() {
        sauceSale()
        drinkSale()
    }

    override fun showStatistics() {
        super.showStatistics()
        val totalEarnings = calculateTotalEarnings() - (checkCount * checkDiscount) + (coffeeCount * coffeePrice) + (sauceCount * saucePrice)
        println("Всего заработано денег: $totalEarnings")
        println("Продано кофе: $coffeeCount, Заработано на кофе: ${coffeeCount * coffeePrice}")
        println("Продано соусов: $sauceCount, Заработано на соусах: ${sauceCount * saucePrice}")
        println("Томатных соусов: $Sauce1, Сырных соусов: $Sauce2")
        println("Показано чеков: $checkCount, Общая сумма скидок: ${checkCount * checkDiscount}")
        showCheckStatistics()
        showCoffeeStatistics()
    }

    private fun showCheckStatistics() {
        val checkPercentage = (checkCount.toDouble() / totalPizzaSales()) * 100
        println("Процент людей, показавших чек: ${String.format("%.2f", checkPercentage)}%")
        println("Процент людей, не показавших чек: ${String.format("%.2f", 100 - checkPercentage)}%")
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