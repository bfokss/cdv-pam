open class MenuScreen() {
    val ekwipunek = Equipment();
    val ekranEkwipunku = EquipmentScreen(ekwipunek);
    val ekranPrzedmiotu = ItemScreen(ekranEkwipunku);

    var option = 0;
    var options: List<Int> = listOf(1,2,9);


    fun getOption(){
        println("Wybierz jedna z opcji")
        println("1. Wykuj przedmiot");
        println("2. Pokaz ekwipunek");
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

    fun whichOption(optionParam: Int){
        when(optionParam){
            1 -> println("Wykuwanie przedmiotu");
            2 -> {
                ekranEkwipunku.mainScreen();
            };
            9 -> {
                println("Bywaj!");
            };
        }
    }

    fun mainScreen(){
        getOption();
        if(option in options){
            whichOption(option);
        }
        else{
            println("Nie ma takiej opcji!")
            println("Wybierz opcję ponownie!")
            getOption();
        }


    }
}