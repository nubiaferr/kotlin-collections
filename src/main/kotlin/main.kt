import kotlin.math.roundToInt

fun main() {
    val data = listaDeDados()

    println("Tenho dados? ${if (data.any()) "Sim" else "Não"}")
    println("Tenho ${data.count()} elementos")
    println("Todas as receitas: ${data.map { it.nome }}")
    println("Primeira receita: ${data.first().nome}")
    println("Última receita: ${data.last().nome}")
    println("Total de calorias: ${data.sumOf { it.calorias }}")
    println("Receitas de baixa caloria: ${data.count { it.calorias < 500 }} receitas abaixo de 500 kcal")
    println("Lista de receitas de baixa caloria:")
    data.filter { it.calorias < 500 }.forEach { println(it.nome) }
    println("Receita mais calórica: ${data.maxBy { it.calorias }.nome} - ${data.maxOf { it.calorias }} calorias ")
    println("Receita menos calórica: ${data.minBy { it.calorias }.nome} - ${data.minOf { it.calorias }} calorias ")
    println("Duas primeiras receitas: ${data.map { it.nome }.take(2)}")
    println("Duas últimas receitas: ${data.map { it.nome }.takeLast(2)}")
    println("Média de calorias: " + data.map { it.calorias }.average().roundToInt())

    val lst = listOf(1, 4, 3, 3, 2, 6, 4, 1, 8, 8, 9)
    println(lst.distinct())
    println(lst.sorted())
    println(lst.sortedDescending())
    println(lst.reversed())

}


fun listaDeDados(): List<Receita> {
    return listOf(
        Receita(
            "Lasanha", 1200,
            listOf(
                Ingrediente("Presunto", 5),
                Ingrediente("Queijo", 10),
                Ingrediente("Molho de tomate", 2),
                Ingrediente("Manjerição", 3)
            )
        ),
        Receita("Panqueca", 500),
        Receita("Omelete", 200),
        Receita("Parmegiana", 700),
        Receita("Sopa de feijão", 300),
        Receita(
            "Hamburguer", 2000,
            listOf(
                Ingrediente("Pão", 1),
                Ingrediente("Hamburguer", 3),
                Ingrediente("Queijo", 1),
                Ingrediente("Catupiry", 1),
                Ingrediente("Bacon", 3),
                Ingrediente("Alface", 1),
                Ingrediente("Tomate", 1)
            )
        )
    )
}

data class Receita(val nome: String, val calorias: Int, val ingredientes: List<Ingrediente> = listOf())
data class Ingrediente(val nome: String, val quantidade: Int)