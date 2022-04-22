fun clearScreen(){
    var i = 0
    while (i < 10){
        println();
        i = i+1;
    }
}

fun appHello(){
    println("================================");
    println("====== Witaj w RPG Helper ======");
    println("================================");
}

fun menuOptions(){
    println("--------------------------------");
    println("Opcje:")
    println("1. Kuznia");
    println("2. Plecak");
    println("9. Wyjscie");
    println("--------------------------------");
}

fun menuGetOption(): Int{
    var menuOption = 0;
    val menuOptions = listOf<Int>(1,2,9);
    while (true){
        try {
            print("Opcja: ")
            menuOption = readln().toInt();
            println("--------------------------------");
            if (menuOption in menuOptions){
                break;
            }
            else{
                println("--------------------------");
                println("BLAD: Nie ma takiej opcji!");
                println("--------------------------");
            }
        }
        catch (e: Exception){
            println("-------------------------");
            println("BLAD: Podano zla wartosc!");
            println("-------------------------");
        }
    }
    return menuOption;
}


fun mainMenu(){
    clearScreen();
    appHello();
    menuOptions();
}


fun main() {

    var items = mutableListOf<Item>();

    val kuznia = Forge(items);
    val ekwipunek = Equipment(items);

    while (true){
    mainMenu();
    var menuOption = menuGetOption();
        when(menuOption){
            1-> {
                clearScreen();
                kuznia.forgeMenu()
            };
            2-> {
                clearScreen();
                ekwipunek.equipmentMenu();
            };
            9-> {
                clearScreen();
                println("--------------------------------");
                println("------------ Bywaj! ------------");
                println("--------------------------------");
                break;
            };
    }

    }







}