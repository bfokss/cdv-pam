import kotlin.random.Random

class Boots(paramItemType: String, paramItemName: String, paramItemDescription: String):
    Item(paramItemType, paramItemName, paramItemDescription), ISpecial {
    var isEquipped = false;
    var bootsMaxMovementSpeed = Random.nextInt(0,10);
    var bootsMovementSpeed = bootsMaxMovementSpeed;

    override fun showInfo() {
        println("Przedmiot: $itemName");
        println("Opis: $itemDescription");
        println("Typ przedmiotu: $itemType");
        println("Wytrzymalosc: $itemDurability/$maxItemDurability| Ilosc uzyc: $itemUseCount");
        println("Bonus do szybkosci ruchu: $bootsMaxMovementSpeed");
        if (isEquipped){
            println("Buty: $itemName sa zalozone!")
        }
        else{
            println("Buty: $itemName sa zdjete!")
        }
    }

    override fun doSomethingSpecial(){
        if (isEquipped){
            println("Zdejmujesz buty: $itemName!")
            itemDurability -= itemDurabilityLoss;
        }
        else{
            println("Zakladasz buty: $itemName!")
            itemUseCount+=1;
        }
        isEquipped = !isEquipped;
    }

    override fun useItem() {
        if (itemUseCount > 10){
            println("Buty: $itemName sa sparciale!")
            bootsMovementSpeed = bootsMaxMovementSpeed/5;
        }
        else if (itemUseCount > 5){
            println("Buty: $itemName lekko smierdza!")
            bootsMovementSpeed = bootsMaxMovementSpeed/2;
        }
        if (itemDurability <=0){
            println("Buty: $itemName sa zniszczone!")
        }
        else{
            doSomethingSpecial();
        }
    }

    override fun destroyItem() {
        println("Niszczysz buty: $itemName");
    }
}