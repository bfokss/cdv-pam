class EquipmentScreen(equipment: Equipment):MenuScreen() {
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
            mainScreen();
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
            mainScreen();
        }
    }

    override fun whichOption(optionParam: Int){
        when(optionParam){
            1 -> {
                var itemId = getItemId();
                ekwipunek.show(itemId);
                mainScreen();
            }
            2 -> {
                var menu = MenuScreen();
                menu.mainScreen();
            };
            9 -> {
                println("Bywaj!");
            };
        }
    }


}