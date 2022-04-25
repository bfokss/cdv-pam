import kotlin.random.Random

class Helmet(paramItemType: String, paramItemName: String, paramItemDescription: String):
    Item(paramItemType, paramItemName, paramItemDescription){

    var isEquipped = false;

    override fun showInfo() {
        println("Przedmiot: $itemName");
        println("Opis: $itemDescription");
        println("Typ przedmiotu: $itemType");
        println("Wytrzymalosc: $itemDurability/$maxItemDurability| Ilosc uzyc: $itemUseCount")
        if (isEquipped){
            println("Helm: $itemName jest zalozony!")
        }
        else{
            println("Helm: $itemName jest zdjety!")
        }
    }

    override fun doSomethingSpecial(){
        if (isEquipped){
            println("Zdejmujesz helm: $itemName!")
            itemDurability -= itemDurabilityLoss;
        }
        else{
            println("Zakladasz helm: $itemName!")
            itemUseCount+=1;
        }
        isEquipped = !isEquipped;
    }

    override fun useItem() {
        if (itemUseCount > 10){
            println("Helm: $itemName jest bardzo mocno zuzyty i smierdzi!")
        }
        else if (itemUseCount > 5){
            println("Helm: $itemName zaczyna rdzewiec!")
        }
        if (itemDurability <=0){
            println("Helm: $itemName jest zniszczony!")
        }
        else{
            doSomethingSpecial();
        }
    }

    override fun destroyItem() {
        println("Niszczysz helm: $itemName");
    }
}