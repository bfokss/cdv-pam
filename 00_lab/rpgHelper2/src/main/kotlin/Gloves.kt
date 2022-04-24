import kotlin.random.Random

class Gloves(paramItemType: String, paramItemName: String, paramItemDescription: String):
    Item(paramItemType, paramItemName, paramItemDescription), ISpecial{
    var isEquipped = false;
    var gloveMaxAttackSpeed = Random.nextInt(0,10);
    var gloveAttackSpeed = gloveMaxAttackSpeed;

    override fun showInfo() {
        println("Przedmiot: $itemName");
        println("Opis: $itemDescription");
        println("Typ przedmiotu: $itemType");
        println("Wytrzymalosc: $itemDurability/$maxItemDurability| Ilosc uzyc: $itemUseCount");
        println("Bonus do szybkosci ataku: $gloveAttackSpeed");
        if (isEquipped){
            println("Rekawice: $itemName sa zalozone!")
        }
        else{
            println("Rekawice: $itemName sa zdjete!")
        }
    }

    override fun doSomethingSpecial(){
        if (isEquipped){
            println("Zdejmujesz rekawice: $itemName!")
            itemDurability -= itemDurabilityLoss;
        }
        else{
            println("Zakladasz rekawice: $itemName!")
            itemUseCount+=1;
        }
        isEquipped = !isEquipped;
    }

    override fun useItem() {
        if (itemUseCount > 10){
            println("Rekawice: $itemName sa dziurawe!")
            gloveAttackSpeed = gloveMaxAttackSpeed/5;
        }
        else if (itemUseCount > 5){
            println("Rekawice: $itemName sa zuzyte!")
            gloveAttackSpeed = gloveMaxAttackSpeed/2;
        }
        if (itemDurability <=0){
            println("Rekawice: $itemName sa zniszczone!")
        }
        else{
            doSomethingSpecial();
        }
    }

    override fun destroyItem() {
        println("Niszczysz rekawice: $itemName");
    }
}