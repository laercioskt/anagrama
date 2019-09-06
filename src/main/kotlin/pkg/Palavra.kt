package pkg

class Palavra(private val palavra: String) {

    fun anagramas(): Set<String> {
        return geraAnagramas("", palavra, HashSet())
    }

    private fun geraAnagramas(prefixo: String, palavra: String, anagramas: HashSet<String>): HashSet<String> {
        if (palavra.length <= 1) {
            anagramas.add(prefixo + palavra)
        } else {
            for (i in palavra.indices) {
                val letraAtual = palavra.substring(i, i + 1)
                val parteAnterior = palavra.substring(0, i)
                val partePosterior = palavra.substring(i + 1)
                geraAnagramas(prefixo + letraAtual, parteAnterior + partePosterior, anagramas)
            }
        }
        return anagramas
    }

}
