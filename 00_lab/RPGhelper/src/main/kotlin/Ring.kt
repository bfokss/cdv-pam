import kotlin.random.Random

class Ring(paramItemType: String, paramItemName: String, paramItemDescription: String):
    Item(paramItemType, paramItemName, paramItemDescription){
    var isEquipped = false;
    val stats = listOf<String>("Inteligencji", "Sily", "Zrecznosci", "Witalnosci");
    val stats2 = listOf<String>("Inteligencja", "Sila", "Zrecznosc", "Witalnosc");
    var ringRandomStat = Random.nextInt(0,4);
    var ringMaxStatValue = Random.nextInt(9,50);
    var ringStatValue = ringMaxStatValue;
    val ringStat = stats[ringRandomStat];
    val ringStat2 = stats2[ringRandomStat];
    override var itemName = "$paramItemName $ringStat";

    override fun showInfo() {
        println("Przedmiot: $itemName");
        println("Opis: $itemDescription");
        println("Typ przedmiotu: $itemType");
        println("Wytrzymalosc: $itemDurability/$maxItemDurability| Ilosc uzyc: $itemUseCount");
        println("$ringStat2: $ringStatValue");
        if (isEquipped){
            println("Pierscien: $itemName jest zalozony!")
        }
        else{
            println("Pierscien: $itemName jest zdjety!")
        }
    }

    override fun doSomethingSpecial(){
        if (isEquipped){
            println("Zdejmujesz pierscien: $itemName!")
            itemDurability -= itemDurabilityLoss;
        }
        else{
            println("Zakladasz pierscien: $itemName!")
            itemUseCount+=1;
        }
        isEquipped = !isEquipped;
    }

    override fun useItem() {
        if (itemUseCount > 10){
            println("Pierscien: $itemName jest zardzewialy!")
            ringStatValue = ringMaxStatValue/5;
        }
        else if (itemUseCount > 5){
            println("Pierscien: $itemName jest lekko uszkodzony!")
            ringStatValue = ringMaxStatValue/2;
        }
        if (itemDurability <=0){
            println("Pierscien: $itemName jest zniszczony!")
        }
        else{
            doSomethingSpecial();
        }
    }

    override fun destroyItem() {
        println("Niszczysz pierscien: $itemName");
    }
}