class Equipment(paramItemsList: MutableList<Item>):IError {

    var equipment = paramItemsList;
    var itemek = Sword("Miecz", "Mieczorski","Mieczaczek");
    var lol = 0;

    var equipmentOption = 0;
    var equipmentOptions = listOf<Int>(1,2);
    var itemOption = 0;
    var itemOptions = listOf<Int>(1,2,7,3);

    fun showItems(){
        if (lol == 0){
            equipment.add(itemek);
            lol += 1;
        }
        if (equipment.isEmpty()){
            println("Ekwipunek jest pusty!");
            println("Aby dodac cos do ekwipunku udaj sie do Kuzni!");
        }
        else{
            println("Lista przedmiotow:");
            for (item in equipment){
                println("[${equipment.indexOf(item)+1}]. ${item.itemType} - ${item.itemName}");
            }
        }
    }

    fun showItem(paramItemIndex: Int){
        equipment[paramItemIndex].showInfo();
    }

    fun deleteItem(paramItemIndex: Int){
        equipment[paramItemIndex].destroyItem();
        equipment.removeAt(paramItemIndex);
    }

    fun pressButtonBackpack(){
        println("________________________________");
        println("Nacisnij dowolny przycisk zeby powrocic do Plecaka...");
        readln();
    }

    fun pressButtonItem(){
        println("________________________________");
        println("Nacisnij dowolny przycisk zeby powrocic do opcji przedmiotu...");
        readln();
    }

    fun equipmentHello(){
        println("================================");
        println("============ Plecak ============");
        println("================================");
    }

    fun equipmentGoodbye(){
        println("================================");
        println("======= Wracam do menu...=======");
        println("================================");
    }

    fun equipmentOptions(){
        showItems();
        if (equipment.isEmpty()){
            println("________________________________");
            println("Opcje: ")
            println("2. Cofnij")
            println("________________________________");
        }
        else{
            println("________________________________");
            println("Opcje: ")
            println("1. Wybierz przedmiot")
            println("2. Cofnij")
            println("________________________________");
        }
    }

    fun equipmentGetOption(){
        while (true){
            try {
                print("Opcja: ")
                equipmentOption = readln().toInt();
                println("________________________________");
                if (equipment.isEmpty()){
                    if (equipmentOption == 2){
                        break;
                    }
                    else{
                        optionError();
                        equipmentOptions();
                    }
                }
                else{
                    if (equipmentOption in equipmentOptions){
                        break;
                    }
                    else{
                        optionError();
                        equipmentOptions();
                    }
                }
            }
            catch (e: Exception){
                valueError();
                equipmentOptions();
            }
        }
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
                    itemIndexError();
                    showItems();
                }

            }
            catch (e: Exception){
                valueError();
                showItems();
            }
        }
        return itemIndex;
    }

    fun itemOptions(){
        println("________________________________");
        println("Opcje: ")
        println("1. Pokaz informacje o przedmiocie")
        println("2. Uzyj przedmiotu")
        println("7. Usun przedmiot")
        println("3. Cofnij")
        println("________________________________");
    }

    fun itemGetOption(){
        while (true){
            try {
                print("Opcja: ")
                itemOption = readln().toInt();
                println("________________________________");
                if (itemOption in itemOptions){
                    break;
                }
                else{
                    optionError();
                    itemOptions();
                }
            }
            catch (e: Exception){
                valueError();
                itemOptions();
            }
        }
    }

    fun itemAction(paramItemIndex: Int){
        itemOptions();
        itemGetOption();
        when(itemOption){
            1->{
                showItem(paramItemIndex);
                pressButtonItem();
                itemAction(paramItemIndex);
            };
            2->{
                equipment[paramItemIndex].useItem();
                pressButtonItem();
                itemAction(paramItemIndex);
            };
            7->{
                deleteItem(paramItemIndex);
                pressButtonBackpack();
                menu();
            }
            3->{
                menu();
            }
        }
    }

    fun equipmentAction(paramEquipmentOption: Int){
        when (paramEquipmentOption) {
            1 -> {
                var itemIndex = getItemIndex();
                itemAction(itemIndex);
            }
            2 -> {
                equipmentGoodbye();
            }
        }
    }

    fun menu(){
        equipmentHello();
        equipmentOptions();
        equipmentGetOption();
        equipmentAction(equipmentOption);
    }
}