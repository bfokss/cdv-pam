fun main(args: Array<String>) {


    println("Wybierz jedna z opcji")
    println("1. Wykuj przedmiot");
    println("2. Pokaz ekwipunek");
    println("3. Wyjdz");
    println("Twoj wybor: ");


    var option = try {
        readln().toInt();
    }
    catch (e: Exception){
        println("Podano zla opcje!")
        3
    }


    when (option){
        1 -> println("Kuznia");
        2 -> println("Ekwipunek");
        3 -> println("Bywaj!");
        else -> {
            println("Nie ma takiej opcji!");
        }
    }

    val itemek = Item("Miecz", "Potężny mieczor", "Mieczor potęgi")

    itemek.showItemInfo();

}