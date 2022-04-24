class Forge(equipment: MutableList<Item>) {
    var menuOption = 0;
    var menuOptions = listOf<Int>(1,2)

    var typeIndex = 0;
    var createdItemType = "";
    var createdItemName = "";
    var itemType = "";
    var createdItemDescription = "";
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
                typeIndex = readln().toInt()
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

    fun getItemInfo(){
        when(typeIndex){
            1 -> {
                createdItemType = itemType;
                println("Nazwij miecz: ");
                print("Nazwa: ");
                createdItemName = getStringParam();
                println("Opisz miecz: ");
                print("Opis: ")
                createdItemDescription = getStringParam();


            }
            else -> {
                createdItemType = itemType;
                println("Nazwij miecz: ");
                print("Nazwa: ");
                createdItemName = getStringParam();
                println("Opisz miecz: ");
                print("Opis: ")
                createdItemDescription = getStringParam();

            }
        }

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
                        //TWORZENIE PRZEDMIOTU
                        getType();
                        if (itemType in itemTypes){
                            when(typeIndex){
                                1->{
                                    getItemInfo();
                                    var createdItem = Sword(createdItemType, createdItemName, createdItemDescription)
                                    println("================================");
                                    println(" Pomyslnie utworzono przedmiot! ");
                                    println("================================");
                                    createdItem.showItemInfo();
                                    equipment.add(createdItem);
                                    println("Nacisnij dowolny przycisk zeby powrocic do Kuzni...");
                                    readln();
                                    forgeMenu();
                                }
                            }

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