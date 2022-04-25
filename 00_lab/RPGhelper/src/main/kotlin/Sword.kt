import kotlin.random.Random

class Sword(paramItemType: String, paramItemName: String, paramItemDescription: String):
    Item(paramItemType, paramItemName, paramItemDescription){


    var swordDamage = 0;


    override fun showInfo() {
        println("Przedmiot: $itemName");
        println("Opis: $itemDescription");
        println("Typ przedmiotu: $itemType");
        println("Wytrzymalosc: $itemDurability/$maxItemDurability| Ilosc uzyc: $itemUseCount")
    }

    override fun doSomethingSpecial() {
        println("Bierzesz potezny zamach mieczem i zadajesz $swordDamage obrazen!")
        itemDurability -= itemDurabilityLoss;
        itemUseCount += 1;
        println("Zmniejszono wytrzymalosc przedmiotu o $itemDurabilityLoss");
    }

    override fun useItem() {
        swordDamage = Random.nextInt(9,50);

        if (itemUseCount > 10){
            println("Miecz: $itemName jest powaznie uszkodzony!")
        }
        else if (itemUseCount > 5){
            println("Miecz: $itemName jest zuzyty!")
        }
        if (itemDurability <=0){
            println("Miecz: $itemName jest zniszczony!")
        }
        else{
            doSomethingSpecial();
        }
    }

    override fun destroyItem() {
        println("Niszczysz miecz: $itemName");
    }
}