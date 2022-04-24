interface IError {
    fun optionError(){
        println("----------------------------------------");
        println("------ BLAD: Nie ma takiej opcji! ------");
        println("----------------------------------------");
    }

    fun valueError(){
        println("----------------------------------------");
        println("------ BLAD : Podano zla wartosc! ------");
        println("----------------------------------------");
    }

    fun itemIndexError(){
        println("----------------------------------------");
        println("BLAD: Nie ma przedmiotu o takim numerze!");
        println("----------------------------------------");
    }
}