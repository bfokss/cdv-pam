open class MainScreen() {
    var option = 0;
    open var options: List<Int> = listOf(1,2,9);

    var ekwipunek = Equipment();


    open fun getOption(){
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
            getScreen();
        }
    }

    open fun whichOption(optionParam: Int){
        when(optionParam){
            1 -> println("Wykuwanie przedmiotu");
            2 -> {
                println("Ekwipunek");
                var ekranEkwipunku = EquipmentScreen();
                ekranEkwipunku.getScreen()
            };
            9 -> {
                println("Bywaj!");
            };
        }
    }

    fun getScreen(){
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