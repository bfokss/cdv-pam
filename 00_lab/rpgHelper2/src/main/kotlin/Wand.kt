import kotlin.random.Random

class Wand(paramItemType: String, paramItemName: String, paramItemDescription: String):
    Item(paramItemType, paramItemName, paramItemDescription), ISpecial {

    val elements = listOf<String>("Ognia", "Ziemi", "Wody", "Powietrza", "Blyskawicy");
    var randomElement = Random.nextInt(0,5);
    var wandElement = elements[randomElement];
    var wandDamage = 0;
    override var itemName = "$paramItemName $wandElement";

    override fun showInfo() {
        println("Przedmiot: $itemName");
        println("Opis: $itemDescription");
        println("Typ przedmiotu: $itemType");
        println("Zywiol: $wandElement");
        println("Wytrzymalosc: $itemDurability/$maxItemDurability| Ilosc uzyc: $itemUseCount")
    }

    override fun doSomethingSpecial(){
        println("Uzywajac mocy $wandElement zadajesz $wandDamage obrazen!")
        itemDurability -= itemDurabilityLoss;
        itemUseCount += 1;
        println("Zmniejszono wytrzymalosc przedmiotu o $itemDurabilityLoss");
    }

    override fun useItem() {
        wandDamage = Random.nextInt(9,50);

        if (itemUseCount > 10){
            println("Rozdzce: $itemName brakuje mocy $wandElement!")
        }
        else if (itemUseCount > 5){
            println("Rozdzka: $itemName jest zuzyta!")
        }
        if (itemDurability <=0){
            println("Rozdzka: $itemName jest zniszczona!")
        }
        else{
            doSomethingSpecial();
        }
    }

    override fun destroyItem() {
        println("Niszczysz rozdzke: $itemName");
    }
}