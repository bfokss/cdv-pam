class Equipment {

    var itemek = Item("Miecz", "GIGA Mieczor", "Mieczor potegi");

    var items = mutableListOf<Item>(itemek);

    fun showAll(){
        if (items.isEmpty()){
            println("Ekwipunek jest pusty!");
        }
        else {
            for (item in items ){
                println("[ ${items.indexOf(item)} ]. ${item.name}")
            }
        }
    }

    fun show(itemIndex: Int){
        items[itemIndex].showItemInfo();
    }

    fun use(itemIndex: Int){
        items[itemIndex].useItem();
    }

    fun add(item: Item){
        items.add(items.size, item);
    }

    fun destroy(itemIndex: Int){
        items[itemIndex].destroyItem();
        items.removeAt(itemIndex);
    }
}