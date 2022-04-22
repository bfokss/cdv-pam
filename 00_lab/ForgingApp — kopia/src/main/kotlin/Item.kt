import kotlin.random.Random

class Item(itemType: String, itemDescription: String, itemName: String) {
    var type = itemType;
    var description = itemDescription;
    var name = itemName;
    var durability = (10..150).random();
    var durabilityLoss = 10;
    var useCount = 0;

    fun showItemInfo() {
        println("Przedmiot: $name");
        println("Opis: $description");
        println("Typ przedmiotu: $type");
        println("Wytrzymalosc: $durability/$durability | Ilosc uzyc: $useCount")
    }

    fun useItem(){
        println("Uzywasz przedmiotu!")

        if (durability == 0){
            println("Przedniot: $name ulegl zniszczeniu!")

        }
        else {
            durability = durability - durabilityLoss;
            useCount = useCount +1;
            println("Zmniejszono wytrzymalosc przedmiotu o $durabilityLoss");
        }
    }

    fun destroyItem(){
        println("Usunieto przedmiot.")
    }

}