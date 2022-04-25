class Forge(paramItemsList: MutableList<Item>):IError {

    var equipment = paramItemsList;

    var forgeOption = 0;
    var forgeOptions = listOf<Int>(1,2);

    var itemTypeIndex = 0;

    var itemTypes = listOf<String>("Miecz", "Rozdzka", "Helm", "Zbroja", "Naramienniki", "Rekawice", "Spodnie", "Buty", "Pierscien", "Naszyjnik" );

    fun getStringParam(): String{
        var stringParam = "";
        try {
            stringParam = readln().toString();
        }
        catch (e: Exception){
            valueError();
        }
        return stringParam;
    }

    fun pressButtonForge(){
        println("________________________________");
        println("Nacisnij dowolny przycisk zeby powrocic do Kuzni...");
        readln();
    }


    fun forgeHello(){
        println("================================");
        println("============ Kuznia ============");
        println("================================");
    }

    fun forgeGoodbye(){
        println("================================");
        println("======= Wracam do menu...=======");
        println("================================");
    }

    fun forgeOptions(){
        println("________________________________");
        println("Opcje: ")
        println("1. Wytworz przedmiot")
        println("2. Cofnij")
        println("________________________________");
    }

    fun forgeGetOption(){
        while (true){
            try {
                print("Opcja: ")
                forgeOption = readln().toInt();
                println("________________________________");
                if (forgeOption in forgeOptions){
                    break;
                }
                else{
                    optionError();
                    forgeOptions();
                }

            }
            catch (e: Exception){
                valueError();
                forgeOptions();
            }
        }
    }

    fun getItemType(){
        while (true) {
            println("Lista przedmiotow do wytworzenia:")
            for (type in itemTypes) {
                println("[${itemTypes.indexOf(type) + 1}]. $type")
            }
            println("Wybierz typ przedmiotu z listy powyzej: ");
            print("Typ: ");
            try {
                itemTypeIndex = readln().toInt()
                itemTypeIndex = itemTypeIndex - 1;
                break;
            } catch (e: Exception) {
                valueError();
                getItemType();
            }
        }
    }

    fun getItemInfo(): MutableList<String>{
        var itemInfoList = mutableListOf<String>()
        var createdItemType = itemTypes[itemTypeIndex];
        itemInfoList.add(createdItemType);
        println("Wybrany typ przedmiotu to: $createdItemType");
        println("Nazwij przedmiot: ");
        print("Nazwa: ");
        var createdItemName = getStringParam();
        itemInfoList.add(createdItemName);
        println("Opisz przedmiot: ");
        print("Opis: ");
        var createdItemDescription = getStringParam();
        itemInfoList.add(createdItemDescription);
        return itemInfoList;
    }

    fun createItem(){
        println("________________________________");
        println("____ Wytwarzanie przedmiotu ____");
        println("________________________________");
        //itemInfo[0] -- Item type
        //itemInfo[1] -- Item name
        //itemInfo[2] -- Item description
        getItemType();
        when(itemTypeIndex){
            0->{
                var itemInfo = getItemInfo();
                var createdItem = Sword(itemInfo[0],itemInfo[1],itemInfo[2]);
                equipment.add(createdItem);
                createdItem.showInfo();
                pressButtonForge();
                menu();
            };
            1->{
                var itemInfo = getItemInfo();
                var createdItem = Wand(itemInfo[0],itemInfo[1],itemInfo[2]);
                equipment.add(createdItem);
                createdItem.showInfo();
                pressButtonForge();
                menu();
            };
            2->{
                var itemInfo = getItemInfo();
                var createdItem = Helmet(itemInfo[0],itemInfo[1],itemInfo[2]);
                equipment.add(createdItem);
                createdItem.showInfo();
                pressButtonForge();
                menu();
            };
            3->{
                var itemInfo = getItemInfo();
                var createdItem = Armor(itemInfo[0],itemInfo[1],itemInfo[2]);
                equipment.add(createdItem);
                createdItem.showInfo();
                pressButtonForge();
                menu();
            };
            4->{
                var itemInfo = getItemInfo();
                var createdItem = ShoulderPads(itemInfo[0],itemInfo[1],itemInfo[2]);
                equipment.add(createdItem);
                createdItem.showInfo();
                pressButtonForge();
                menu();
            };
            5->{
                var itemInfo = getItemInfo();
                var createdItem = Gloves(itemInfo[0],itemInfo[1],itemInfo[2]);
                equipment.add(createdItem);
                createdItem.showInfo();
                pressButtonForge();
                menu();
            };
            6->{
                var itemInfo = getItemInfo();
                var createdItem = Pants(itemInfo[0],itemInfo[1],itemInfo[2]);
                equipment.add(createdItem);
                createdItem.showInfo();
                pressButtonForge();
                menu();
            };
            7->{
                var itemInfo = getItemInfo();
                var createdItem = Boots(itemInfo[0],itemInfo[1],itemInfo[2]);
                equipment.add(createdItem);
                createdItem.showInfo();
                pressButtonForge();
                menu();
            };
            8->{
                var itemInfo = getItemInfo();
                var createdItem = Ring(itemInfo[0],itemInfo[1],itemInfo[2]);
                equipment.add(createdItem);
                createdItem.showInfo();
                pressButtonForge();
                menu();
            };
            9->{
                var itemInfo = getItemInfo();
                var createdItem = Necklace(itemInfo[0],itemInfo[1],itemInfo[2]);
                equipment.add(createdItem);
                createdItem.showInfo();
                pressButtonForge();
                menu();
            };
            else->{
                var itemInfo = getItemInfo();
                var createdItem = Item(itemInfo[0],itemInfo[1],itemInfo[2]);
                equipment.add(createdItem);
                createdItem.showInfo();
                pressButtonForge();
                menu();
            };
        }
    }

    fun forgeAction(paramForgeOption: Int){
        when (paramForgeOption) {
            1 -> {
                createItem();
            }
            2 -> {
                forgeGoodbye();
            }
        }
    }


    fun menu(){
        forgeHello();
        forgeOptions();
        forgeGetOption();
        forgeAction(forgeOption);
    }
}