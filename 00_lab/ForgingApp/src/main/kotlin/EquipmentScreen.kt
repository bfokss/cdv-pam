class EquipmentScreen():MainScreen() {

    fun getItemId(): Int{
        var itemId = 0;
        try {
            println("Podaj numer przedmiotu: ")
            itemId = readln().toInt();
            if (ekwipunek.items.getOrNull(itemId) == null){
                println("Nie ma przedmiotu o numerze: $itemId!");
            }
        }
        catch (e: Exception){
            println("Nie ma takiego przedmiotu!");
            println("Wybierz poprawny numer przedmiotu!\n");
            getScreen();
        }
        return itemId;
    }

    override fun getOption(){
        println("Ekwipunek:")
        ekwipunek.showAll();
        println("Wybierz jedna z opcji")
        println("1. Wybierz przedmiot z ekwipunku");
        println("2. Cofnij");
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

    override fun whichOption(optionParam: Int){
        when(optionParam){
            1 -> {
                var itemId = getItemId();
                ekwipunek.show(itemId);
                getScreen();
            }
            2 -> {
                var menu = MainScreen();
                menu.getScreen();
            };
            9 -> {
                println("Bywaj!");
            };
        }
    }


}