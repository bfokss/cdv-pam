
fun showMainMenu(){
    println("Wybierz jedna z opcji")
    println("1. Wykuj przedmiot");
    println("2. Pokaz ekwipunek");
    println("9. Wyjdz");
    println("Twoj wybor: ");
}

fun getOption():Int{
    showMainMenu();
    var option = 0;
    try {
        option = readln().toInt();
        return option;
    }
    catch (e: Exception){
        println("Podano zla opcje!");
        println("Wybierz poprawna opcje!\n");
        return getOption();
    }
}

fun whichOption(optionParam: Int){
    when(optionParam){
        1 -> println("Wykuwanie przedmiotu");
        2 -> println("Ekwipunek");
        9 -> {
            println("Bywaj!");
        };
    }
}

fun main(args: Array<String>) {
    println("Witaj w RPG Helperze!")

    var userOption = 0;
    val options: List<Int> = listOf(1,2,9);

    val ekwipunek = Equipment();

    userOption = getOption();


    if(userOption in options){
        whichOption(userOption);
    }
    else{
        getOption();
    }
}