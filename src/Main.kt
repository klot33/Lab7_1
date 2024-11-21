import kotlin.system.exitProcess

fun main() {
    val pizzaMoscow = PizzaMoscow(
        neapolitanPizzaPrice = 215.0,
        romanPizzaPrice = 250.0,
        sicilianPizzaPrice = 180.5,
        tyroleanPizzaPrice = 240.0
    )

    val pizzaPeter = PizzaPeter(
        neapolitanPizzaPrice = 200.0,
        romanPizzaPrice = 241.5,
        sicilianPizzaPrice = 167.5,
        tyroleanPizzaPrice = 215.0
    )

    val pizzaKazan = PizzaMurmansk(
        neapolitanPizzaPrice = 180.0,
        romanPizzaPrice = 230.0,
        sicilianPizzaPrice = 150.0,
        tyroleanPizzaPrice = 200.0
    )

    var currentPizzaCity: PizzaCity? = null

    while (true) {
        println("Добрый день! Выберите город")
        println("1. Москва\n2. Санкт-Петербург\n3. Мурманск\n0. Выход")

        currentPizzaCity = when (readln()) {
            "1" -> pizzaMoscow
            "2" -> pizzaPeter
            "3" -> pizzaKazan
            "0" -> exitProcess(0)
            else -> {
                println("ERROR: Неверный выбор города.")
                continue
            }
        }

        println("Выберите пиццу:")
        println("1. Неаполитанская пицца\n2. Римская пицца\n3. Сицилийская пицца\n4. Тирольская пицца\n0. Статистика")

        selectPizza(currentPizzaCity)
    }
}

private fun selectPizza(currentPizzaCity: PizzaCity) {
    when (readln()) {
        "1" -> {
            currentPizzaCity.neapolitanPizzaSale()
            selectAddService(currentPizzaCity)
        }

        "2" -> {
            currentPizzaCity.romanPizzaSale()
            selectAddService(currentPizzaCity)
        }

        "3" -> {
            currentPizzaCity.sicilianPizzaSale()
            selectAddService(currentPizzaCity)
        }

        "4" -> {
            currentPizzaCity.tyroleanPizzaSale()
            selectAddService(currentPizzaCity)
        }

        "0" -> currentPizzaCity.showStatistics()
        else -> {
            println("ERROR: Неверный выбор пиццы.")
        }
    }
}

fun selectAddService(currentPizzaCity: PizzaCity) {
    when (currentPizzaCity) {
        is CheckPhoto -> currentPizzaCity.showCheckPhoto()
        is Drink -> currentPizzaCity.drinkSale()
        is Sauce -> currentPizzaCity.sauceSale()
    }
}