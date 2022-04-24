class ShoulderPads(paramItemType: String, paramItemName: String, paramItemDescription: String):
    Item(paramItemType, paramItemName, paramItemDescription), ISpecial {
    var isEquipped = false;

    override fun showInfo() {
        println("Przedmiot: $itemName");
        println("Opis: $itemDescription");
        println("Typ przedmiotu: $itemType");
        println("Wytrzymalosc: $itemDurability/$maxItemDurability| Ilosc uzyc: $itemUseCount")
        if (isEquipped){
            println("Naramienniki: $itemName sa zalozone!")
        }
        else{
            println("Naramienniki: $itemName sa zdjete!")
        }
    }

    override fun doSomethingSpecial(){
        if (isEquipped){
            println("Zdejmujesz naramienniki: $itemName!")
            itemDurability -= itemDurabilityLoss;
        }
        else{
            println("Zakladasz naramienniki: $itemName!")
            itemUseCount+=1;
        }
        isEquipped = !isEquipped;
    }

    override fun useItem() {
        if (itemUseCount > 10){
            println("Naramienniki: $itemName sa mocno zuzyte i spadaja z ramion!")
        }
        else if (itemUseCount > 5){
            println("Naramienniki: $itemName sa zuzyte!")
        }
        if (itemDurability <=0){
            println("Naramienniki: $itemName jest zniszczona!")
        }
        else{
            doSomethingSpecial();
        }
    }

    override fun destroyItem() {
        println("Niszczysz naramienniki: $itemName");
    }

}