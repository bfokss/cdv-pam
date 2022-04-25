import kotlin.random.Random

class Necklace(paramItemType: String, paramItemName: String, paramItemDescription: String):
    Item(paramItemType, paramItemName, paramItemDescription), ISpecial {
    var isEquipped = false;
    var necklaceRandomStat = Random.nextInt(0,4);
    var necklaceMaxStatValue = Random.nextInt(9,50);
    var necklaceStatValue = necklaceMaxStatValue;
    val stats = listOf<String>("Inteligencji", "Sily", "Zrecznosci", "Witalnosci");
    val stats2 = listOf<String>("Inteligencja", "Sila", "Zrecznosc", "Witalnosc");
    val necklaceStat = stats[necklaceRandomStat];
    val necklaceStat2 = stats2[necklaceRandomStat];
    override var itemName = "$paramItemName $necklaceStat";

    override fun showInfo() {
        println("Przedmiot: $itemName");
        println("Opis: $itemDescription");
        println("Typ przedmiotu: $itemType");
        println("Wytrzymalosc: $itemDurability/$maxItemDurability| Ilosc uzyc: $itemUseCount");
        println("$necklaceStat2: $necklaceStatValue");
        if (isEquipped){
            println("Naszyjnik: $itemName jest zalozony!")
        }
        else{
            println("Naszyjnik: $itemName jest zdjety!")
        }
    }

    override fun doSomethingSpecial(){
        if (isEquipped){
            println("Zdejmujesz naszyjnik: $itemName!")
            itemDurability -= itemDurabilityLoss;
        }
        else{
            println("Zakladasz naszyjnik: $itemName!")
            itemUseCount+=1;
        }
        isEquipped = !isEquipped;
    }

    override fun useItem() {
        if (itemUseCount > 10){
            println("Naszyjnik: $itemName jest zardzewialy!")
            necklaceStatValue = necklaceMaxStatValue/5;
        }
        else if (itemUseCount > 5){
            println("Naszyjnik: $itemName jest lekko uszkodzony!")
            necklaceStatValue = necklaceMaxStatValue/2;
        }
        if (itemDurability <=0){
            println("Naszyjnik: $itemName jest zniszczony!")
        }
        else{
            doSomethingSpecial();
        }
    }

    override fun destroyItem() {
        println("Niszczysz naszyjnik: $itemName");
    }
}