import kotlin.random.Random

open class Item(itemType: String, itemName: String, itemDescription: String) {

    var type = itemType;
    var description = itemDescription;
    var name = itemName;
    var maxDurability = Random.nextInt(9,150);
    var durability = maxDurability;
    var durabilityLoss = 10;
    var useCount = 0;

    fun showItemInfo() {
        println("Przedmiot: $name");
        println("Opis: $description");
        println("Typ przedmiotu: $type");
        println("Wytrzymalosc: $durability/$maxDurability| Ilosc uzyc: $useCount")
    }

    open fun useItem(){
        println("Uzywasz przedmiotu!")

        if (durability <= 0){
            println("Przedniot: $name ulegl zniszczeniu!")

        }
        else {
            durability -= durabilityLoss;
            useCount += 1;
            println("Zmniejszono wytrzymalosc przedmiotu o $durabilityLoss");
        }
    }
}