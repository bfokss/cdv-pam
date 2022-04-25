class Menu :IError{
    var userItems = mutableListOf<Item>();

    val backpack = Equipment(userItems);
    val forge = Forge(userItems);



    var menuQuit = true;

    var menuOption = 0;
    var menuOptions = listOf<Int>(1,2,9)


    fun menuHello(){
        println("================================");
        println("====== Witaj w RPG Helper ======");
        println("================================");
    }

    fun menuGoodbye(){
        println("================================");
        println("============ Bywaj! ============");
        println("================================");
    }

    fun menuOptions(){
        println("________________________________");
        println("Opcje:")
        println("1. Kuznia");
        println("2. Plecak");
        println("9. Wyjscie");
        println("________________________________");
    }

    fun menuGetOption(){
        while (true){
            try {
                print("Opcja: ")
                menuOption = readln().toInt();
                println("________________________________");
                if (menuOption in menuOptions){
                    menuQuit = menuAction(menuOption);
                    break;
                }
                else{
                    optionError();
                }
            }
            catch (e: Exception){
                valueError();
            }
        }
    }

    fun menuAction(paramMenuOption: Int): Boolean{
        when (paramMenuOption) {
            1 -> {
                forge.menu();
                return true;
            }
            2 -> {
                backpack.menu();
                return true;
            }
            9 -> {
                menuGoodbye();
                return false;
            }
            else -> {
                return false
            }
        }
    }

    fun menu(){
        menuHello();
        menuOptions();
        menuGetOption();
    }
}