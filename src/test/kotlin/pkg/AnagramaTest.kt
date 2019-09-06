package pkg

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS

@TestInstance(PER_CLASS)
class AnagramaTest {

    @Test
    fun `gera anagrama de A e verifica que e A`() {
        assertThat(Palavra("A").anagramas())
                .containsExactly("A")
    }

    @Test
    fun `gera anagrama de B e verifica que e B`() {
        assertThat(Palavra("B").anagramas())
                .containsExactly("B")
    }

    @Test
    fun `gera anagrama de AB e verifica que e AB,BA`() {
        assertThat(Palavra("AB").anagramas())
                .containsExactly("AB", "BA")
    }

    @Test
    fun `gera anagrama de AA e verifica que e AA`() {
        assertThat(Palavra("AA").anagramas())
                .containsExactly("AA")
    }

    @Test
    fun `gera anagrama de ABC e verifica que e ABC,ACB,BAC,BCA,CAB,CBA`() {
        assertThat(Palavra("ABC").anagramas())
                .containsExactlyInAnyOrder("ABC", "ACB", "BAC", "BCA", "CAB", "CBA")
    }

    @Test
    fun `verifica anagramas da palavra biro`() {
        assertThat(Palavra("biro").anagramas())
                .containsExactlyInAnyOrder("biro", "bior", "brio", "broi", "boir", "bori", "ibro", "ibor", "irbo",
                        "irob", "iobr", "iorb", "rbio", "rboi", "ribo", "riob", "roib", "robi", "obir", "obri", "oibr", "oirb", "orbi", "orib")
    }

}