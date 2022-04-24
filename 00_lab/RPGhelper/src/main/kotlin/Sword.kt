import kotlin.random.Random

class Sword(itemType: String, itemName: String, itemDescription: String): Item(itemType, itemName, itemDescription) {

    var damage = 0;
    override fun useItem(){
        damage = Random.nextInt(9,50);
        println("Bierzesz potezny zamach mieczem i zadajesz $damage obrazen!")

        if (durability <= 0){
            println("Miecz: $name ulegl zniszczeniu!")
        }
        else if(durability > 50){
            println("Miecz jest uszkodzony!")
        }
        else {
            durability -= durabilityLoss;
            useCount += 1;
            println("Zmniejszono wytrzymalosc przedmiotu o $durabilityLoss");
        }
    }
}