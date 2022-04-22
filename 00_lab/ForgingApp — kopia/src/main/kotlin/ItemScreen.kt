class ItemScreen(equipmentScreen: EquipmentScreen) : MenuScreen() {
    override var options: List<Int> = listOf(1,2,3,4,9);

    override fun getOption(){
        println("Wybierz jedna z opcji")
        println("1. Wyświetl informacje o przedmiocie");
        println("2. Użyj przedmiotu");
        println("3. Usuń przedmiot");
        println("4. Cofnij");
        println("9. Wyjdz");
        println("Twoj wybor: ");
        try {
            option = readln().toInt();

        }
        catch (e: Exception){
            println("Podano zla opcje!");
            println("Wybierz poprawna opcje!\n");
            mainScreen();
        }
    }

    override fun whichOption(optionParam: Int){
        when(optionParam){
            1 -> println("");
            2 -> {
                ekranEkwipunku.mainScreen();
            };
            9 -> {
                println("Bywaj!");
            };
        }
    }
}