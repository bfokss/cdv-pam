class Forge(equipment: MutableList<Item>) {
    var menuOption = 0;
    var menuOptions = listOf<Int>(1,2)

    var itemType = "";
    var itemTypes = listOf<String>("Miecz", "Rozdzka", "Helm", "Zbroja", "Naramienniki", "Rekawica", "Spodnie", "Buty", "Pierscien", "Naszyjnik" )

    var equipment = equipment;

    fun getStringParam(): String{
        var stringParam = "";
        try {
            stringParam = readln().toString();
        }
        catch (e: Exception){
            println("-------------------------");
            println("BLAD: Podano zla wartosc!");
            println("-------------------------");
        }
        return stringParam;
    }

    fun getType(){
        while (true){
            println("Lista przedmiotow do wytworzenia:")
            for (type in itemTypes){
                println("[${itemTypes.indexOf(type)+1}]. $type")
            }
            println("Wybierz typ przedmiotu z listy powyzej: ");
            print("Typ: ");
            try {
                var typeIndex = readln().toInt()
                typeIndex = typeIndex - 1;
                itemType = itemTypes[typeIndex];
                break;
            }
            catch (e: Exception){
                println("-------------------------");
                println("BLAD: Podano zla wartosc!");
                println("-------------------------");
            }
        }
    }

    fun createItem(itemType: String): Item{
        var createdItemType = itemType;
        println("Nazwij przedmiot: ");
        print("Nazwa: ");
        var createdItemName = getStringParam();
        println("Opisz przedmiot: ");
        print("Opis: ")
        var createdItemDescription = getStringParam();
        var createdItem = Item(createdItemType, createdItemName, createdItemDescription)
        return createdItem;
    }

    fun forgeOptions(){
        println("--------------------------------");
        println("Opcje: ")
        println("1. Wytworz przedmiot")
        println("2. Cofnij")
        println("--------------------------------");
    }

    fun forgeGetOption(){
        while (true){
            try {
                print("Opcja: ")
                menuOption = readln().toInt();
                println("--------------------------------");
                forgeCheckOption(menuOption);
                break;
            }
            catch (e: Exception){
                println("-------------------------");
                println("BLAD: Podano zla wartosc!");
                println("-------------------------");
            }
        }
    }

    fun forgeCheckOption(userOption: Int){
            if (userOption in menuOptions){
                when(userOption){
                    1 -> {
                        getType();
                        if (itemType in itemTypes){
                            var craftedItem = createItem(itemType);
                            println("================================");
                            println(" Pomyslnie utworzono przedmiot! ");
                            println("================================");
                            craftedItem.showItemInfo();
                            equipment.add(craftedItem);
                            println("Nacisnij dowolny przycisk zeby powrocic do Kuzni...");
                            readln();
                            forgeMenu();
                        }
                        else{
                            println("-------------------------------------");
                            println("BLAD: Nie ma takiego typu przedmiotu!");
                            println("-------------------------------------");
                            getType();
                        }
                    };
                    2 -> {
                        println("----- Wracam do menu -----")
                    };
                }
            }
            else{
                println("-------------------------");
                println("BLAD: Nie ma takiej opcji!");
                println("-------------------------");
                forgeGetOption();
            }
    }


    fun forgeMenu(){
        println("================================");
        println("============ Kuznia ============");
        println("================================");
        forgeOptions();
        forgeGetOption();



    }
}