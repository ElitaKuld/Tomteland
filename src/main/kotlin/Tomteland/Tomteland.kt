package Tomteland

class Tomteland {
    // skapa en datastruktur för att lagra tomtarna och deras relationer i
    private val tomtarOchHierarki = mapOf(
        "Tomten" to listOf("Glader", "Butter"),
        "Glader" to listOf("Tröger", "Trötter", "Blyger"),
        "Butter" to listOf("Rådjuret", "Nyckelpigan", "Haren", "Räven"),
        "Trötter" to listOf("Skumtomten"),
        "Skumtomten" to listOf("Dammråttan"),
        "Räven" to listOf("Gråsuggan", "Myran"),
        "Myran" to listOf("Bladlusen")
    )

    // current namn är den tomte vars underlydande vi vill ta fram, resultat är listan som håller alla underlydande
    fun getUnderlings(currentName: String, resultat: MutableList<String>): List<String> {
        if (tomtarOchHierarki.keys.contains(currentName)) {
            for (i in tomtarOchHierarki.getValue(currentName).indices) {
                resultat.add(tomtarOchHierarki.getValue(currentName)[i])
                getUnderlings(tomtarOchHierarki.getValue(currentName)[i], resultat)
            }
        } else return resultat
        return resultat
    }

}
fun main() {

    val tomteland = Tomteland()

    val listOfChefer = listOf("Tomten", "Glader", "Butter", "Trötter", "Skumtomten", "Räven", "Myran")

    for (i in listOfChefer.indices){
        val lista: MutableList<String> = mutableListOf()
        println(listOfChefer[i] + "s underlydande: " + tomteland.getUnderlings(listOfChefer[i], lista))
    }
}