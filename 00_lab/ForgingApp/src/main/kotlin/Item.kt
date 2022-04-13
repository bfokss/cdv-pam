class Item(itemType: String,  itemDescription: String, itemName: String) {
    var type = itemType;
    var description = itemDescription;
    var name = itemName;
    var durability = 100;
    var useCount = 0;

    fun showItemInfo() {
        println("Przedmiot: $name");
        println("Opis: $description");
        println("Typ przedmiotu: $type");
        println("Wytrzymałość: $durability/$durability | Ilość użyć: $useCount")
    }

    fun useItem(){
        println("Używasz przedmiotu!")
        durability = durability - 10;
        if (durability == 0){
            println("Przedniot: $name uległ zniszczeniu!")
        }
    }

}