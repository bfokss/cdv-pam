package com.example.findvacation

import android.text.Editable

private val place1 = arrayOf("Beleriand", "Beleriand – północno-zachodnia część Śródziemia istniejąca do końca Pierwszej Ery. Pierwotnie nazwy używano tylko na rejon przybrzeżny.")

private val vacationPlaces = listOf<String>(
    "Beleriand",
    "Eriador",
    "Rhovanion",
    "Khand",
    "Rhûn",
    "Harad Bliski",
    "Harad Daleki",
    "Palisor"
)

private val vacationPlacesDescriptions = listOf<String>(
    "Beleriand – północno-zachodnia część Śródziemia istniejąca do końca Pierwszej Ery. Pierwotnie nazwy używano tylko na rejon przybrzeżny.",
    "Eriador – kraina w Śródziemiu między Górami Mglistymi i Ered Luin, na południu sięgająca rzek Gwathló i Glanduiny, a na północy – krainy Forodwaith",
    "Rhovanion – rozległa kraina leżąca na wschód od Wielkiej Rzeki Anduiny, zwanej też Wielką Rzeką Dzikich Krajów.",
    "Khand – stepowa, gorąca kraina, położona w południowo-wschodnim Śródziemiu. Od północnego-zachodu graniczył z Mordorem, od północy z Rhûnem, a od zachodu z Haradem Bliskim.",
    "Rhûn (sin. Wschód)– wschodni rejon Śródziemia położony na wschód od Rhovanionu oraz Gondoru i na północny-wschód od Mordoru.",
    "Harad Bliski – kraina geograficzna, część Haradu, wraz z Haradem Dalekim. Była położona w Śródziemiu i charakteryzowała się klimatem zwrotnikowym, co sprzyjało występowaniu pustyń.",
    "Harad Daleki – wysunięta daleko na południe kraina geograficzna w Śródziemiu, część Haradu, wraz z Haradem Bliskim.",
    "Palisor – nazwa rozległego obszaru śródlądowego Ardy. Otoczony był Górami Żelaznymi z północy, Górami Mglistymi z zachodu, górami Orocarni ze wschodu i gorącymi krainami z południa. W środku leżało Morze Helcar."
)


private fun getRandomNumber(min: Int = 0, max: Int, nameLength: Int) = ((min..max).random())-nameLength/10

fun getVacationPlace(paramUserName: Editable): List<String> {
    val nameLength = paramUserName.length
    val maxIndex = vacationPlaces.size - 1
    var index = getRandomNumber(max = maxIndex, nameLength = nameLength)
    if (index < 0){
        index = (0..maxIndex).random()
    }
    val place = vacationPlaces[index]
    val placeDescription = vacationPlacesDescriptions[index]
    var vacationPlace = listOf<String>(place, placeDescription)

    return vacationPlace
}