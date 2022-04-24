import kotlin.random.Random

open class Item(paramItemType: String, paramItemName: String, paramItemDescription: String) {
    var itemType = paramItemType;
    open var itemName = paramItemName;
    var itemDescription = paramItemDescription;
    var maxItemDurability = Random.nextInt(9,150);
    var itemDurability = maxItemDurability;
    var itemDurabilityLoss = 10;
    var itemUseCount = 0;


    open fun showInfo(){
    }

    open fun useItem(){
    }

    open fun destroyItem(){
    }
}