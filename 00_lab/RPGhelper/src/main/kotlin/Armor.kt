class Armor(paramItemType: String, paramItemName: String, paramItemDescription: String):
    Item(paramItemType, paramItemName, paramItemDescription){
    var isEquipped = false;

    override fun showInfo() {
        println("Przedmiot: $itemName");
        println("Opis: $itemDescription");
        println("Typ przedmiotu: $itemType");
        println("Wytrzymalosc: $itemDurability/$maxItemDurability| Ilosc uzyc: $itemUseCount")
        if (isEquipped){
            println("Zbroja: $itemName jest zalozona!")
        }
        else{
            println("Zbroja: $itemName jest zdjeta!")
        }
    }

    override fun doSomethingSpecial(){
        if (isEquipped){
            println("Zdejmujesz zbroje: $itemName!")
            itemDurability -= itemDurabilityLoss;
        }
        else{
            println("Zakladasz zbroje: $itemName!")
            itemUseCount+=1;
        }
        isEquipped = !isEquipped;
    }

    override fun useItem() {
        if (itemUseCount > 10){
            println("Zbroja: $itemName jest dziurawa!")
        }
        else if (itemUseCount > 5){
            println("Zbroja: $itemName zaczyna smierdziec!")
        }
        if (itemDurability <=0){
            println("Zbroja: $itemName jest zniszczona!")
        }
        else{
            doSomethingSpecial();
        }
    }

    override fun destroyItem() {
        println("Niszczysz zbroje: $itemName");
    }

}