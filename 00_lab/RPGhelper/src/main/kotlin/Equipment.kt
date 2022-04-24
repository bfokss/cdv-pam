class Equipment(ekwipunek: MutableList<Item>) {

    var menuOption = 0;
    var menuOptions = listOf<Int>(1,2)
    var itemMenuOption = 0;
    var itemMenuOptions = listOf<Int>(1,2,7,3)

    var equipment = ekwipunek;


    // EQUIPMENT FUNCTIONS
    fun showItems(){
        if (equipment.isEmpty()){
            println("Ekwipunek jest pusty!");
            println("Aby dodac cos do ekwipunku udaj sie do Kuzni!");
        }
        else{
            for (item in equipment){
                println("[${equipment.indexOf(item)+1}]. ${item.type} - ${item.name}");
            }
        }
    }

    fun deleteItem(itemIndex: Int){
        println("Przedmiot o nazwie '${equipment[itemIndex].name}' zostal usuniety!")
        equipment.removeAt(itemIndex);
    }

    fun getItemIndex(): Int{
        var itemIndex = 0;
        while (true){
            print("Numer przedmiotu: ");
            try {
                itemIndex = readln().toInt()
                itemIndex = itemIndex - 1;
                if (itemIndex in equipment.indices){
                    break;
                }
                else{
                    println("----------------------------------------");
                    println("BLAD: Nie ma przedmiotu o takim numerze!");
                    println("----------------------------------------");
                }

            }
            catch (e: Exception){
                println("-------------------------");
                println("BLAD: Podano zla wartosc!");
                println("-------------------------");
            }
        }
        return itemIndex;
    }
    // EQUIPMENT FUNCTIONS


    // EQUIPMENT SCREEN FUNCTIONS
    fun equipmentOptions(){
        showItems();
        if (equipment.isEmpty()){
            println("--------------------------------");
            println("Opcje: ")
            println("2. Cofnij")
            println("--------------------------------");
        }
        else{
            println("--------------------------------");
            println("Opcje: ")
            println("1. Wybierz przedmiot")
            println("2. Cofnij")
            println("--------------------------------");
        }

    }

    fun equipmentGetOption(){
        while (true){
            try {
                print("Opcja: ")
                menuOption = readln().toInt();
                println("--------------------------------");
                if (equipment.isEmpty()){
                    if (menuOption == 2){
                        break;
                    }
                    else{
                        println("--------------------------");
                        println("BLAD: Nie ma takiej opcji!");
                        println("--------------------------");
                    }
                }
                else{
                    if (menuOption in menuOptions){
                        break;
                    }
                    else{
                        println("--------------------------");
                        println("BLAD: Nie ma takiej opcji!");
                        println("--------------------------");
                    }
                }

            }
            catch (e: Exception){
                println("-------------------------");
                println("BLAD: Podano zla wartosc!");
                println("-------------------------");
            }
        }
    }

    fun equipmentMenu(){
        println("================================");
        println("============ Plecak ============");
        println("================================");
        equipmentOptions();
        equipmentGetOption();
        when(menuOption){
            1-> {
                var itemIndex = getItemIndex();
                itemActionMenu(itemIndex);
            };
            2-> {
                println("----- Wracam do menu -----")
            };
        }
    }
    // EQUIPMENT SCREEN FUNCTIONS


    // ITEM SCREEN FUNCTIONS
    fun itemOptions(){
        println("--------------------------------");
        println("Opcje: ")
        println("1. Pokaz informacje o przedmiocie")
        println("2. Uzyj przedmiotu")
        println("7. Usun przedmiot")
        println("3. Cofnij")
        println("--------------------------------");
    }
    fun itemGetOption(){
        while (true){
            try {
                print("Opcja: ")
                itemMenuOption = readln().toInt();
                println("--------------------------------");
                if (itemMenuOption in itemMenuOptions){
                    break;
                }
                else{
                    println("--------------------------");
                    println("BLAD: Nie ma takiej opcji!");
                    println("--------------------------");
                }
            }
            catch (e: Exception){
                println("-------------------------");
                println("BLAD: Podano zla wartosc!");
                println("-------------------------");
            }
        }
    }


    fun itemActionMenu(itemIndex: Int){

        itemOptions();
        itemGetOption();

        when(itemMenuOption){
            1->{
                equipment[itemIndex].showItemInfo();
                println("--------------------------------");
                println("Nacisnij dowolny przycisk zeby powrocic do opcji przedmiotu...");
                readln();
                itemActionMenu(itemIndex);
            };
            2->{
                if (equipment[itemIndex].durability > 0){
                    equipment[itemIndex].useItem();
                    println(equipment[itemIndex]);
                    println("--------------------------------");
                    println("Nacisnij dowolny przycisk zeby powrocic do opcji przedmiotu...");
                    readln();
                    itemActionMenu(itemIndex);
                }
                else{
                    equipment[itemIndex].useItem();
                    println("--------------------------------");
                    println("Nacisnij dowolny przycisk zeby powrocic do Plecaka...");
                    deleteItem(itemIndex);
                    readln();
                    equipmentMenu();
                }

            }
            7->{
                deleteItem(itemIndex);
                println("--------------------------------");
                println("Nacisnij dowolny przycisk zeby powrocic do Plecaka...");
                readln();
                equipmentMenu();
            };
            3->{
                println("-----------------------------");
                println("----- Wracam do plecaka -----");
                println("-----------------------------");
                equipmentMenu();
            }
        }
    }

    // ITEM SCREEN FUNCTIONS
}