import kotlin.random.Random

class Pants(paramItemType: String, paramItemName: String, paramItemDescription: String):
    Item(paramItemType, paramItemName, paramItemDescription){
    var isEquipped = false;
    val elements = listOf<String>("Ognia", "Ziemi", "Wody", "Powietrza", "Blyskawicy");
    val elements2 = listOf<String>("Ognien", "Ziemie", "Wode", "Powietrze", "Blyskawice");
    var pantsResistanceRandomType = Random.nextInt(0,5);
    var pantsResistanceType = elements[pantsResistanceRandomType];
    var pantsResistanceType2 = elements2[pantsResistanceRandomType];
    var pantsMaxResistance = Random.nextInt(0,20);
    var pantsResistance = pantsMaxResistance;
    override var itemName = "$paramItemName $pantsResistanceType";

    override fun showInfo() {
        println("Przedmiot: $itemName");
        println("Opis: $itemDescription");
        println("Typ przedmiotu: $itemType");
        println("Wytrzymalosc: $itemDurability/$maxItemDurability| Ilosc uzyc: $itemUseCount");
        println("Odpornosc na $pantsResistanceType2: $pantsResistance");
        if (isEquipped){
            println("Spodnie: $itemName sa zalozone!")
        }
        else{
            println("Spodnie: $itemName sa zdjete!")
        }
    }

    override fun doSomethingSpecial(){
        if (isEquipped){
            println("Zdejmujesz spodnie: $itemName!")
            itemDurability -= itemDurabilityLoss;
        }
        else{
            println("Zakladasz spodnie: $itemName!")
            itemUseCount+=1;
        }
        isEquipped = !isEquipped;
    }

    override fun useItem() {
        if (itemUseCount > 10){
            println("Spodnie: $itemName sa dziurawe!")
            pantsResistance = pantsMaxResistance/5;
        }
        else if (itemUseCount > 5){
            println("Spodnie: $itemName sa zuzyte!")
            pantsResistance = pantsMaxResistance/2;
        }
        if (itemDurability <=0){
            println("Spodnie: $itemName sa zniszczone!")
        }
        else{
            doSomethingSpecial();
        }
    }

    override fun destroyItem() {
        println("Niszczysz spodnie: $itemName");
    }
}