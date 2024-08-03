package br.com.zeroth.tujava.collections;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class CollectionsTest {

    @Test
    void deveValidarUsandoList() {

        List<String> nomes  = Arrays.asList("Maria", "Paula", "Erica");

        Assertions.assertThat(nomes)
                .hasSize(3)
                .contains("Erica")
                .containsExactly("Maria", "Paula", "Erica")
                .doesNotContain("Joana")
                .containsSequence("Paula", "Erica");
    }

    @Test
    void deveTestarUsandoSet() {

        Set<String> frutas = new HashSet<>(Arrays.asList("Banana", "Melancia", "Coco"));

        Assertions.assertThat(frutas)
                .hasSize(3)
                .contains("Banana")
                .doesNotContain("Caqui"
                ).containsOnly("Banana", "Melancia", "Coco");
    }

    @Test
    void deveValidarMaps() {

        Map<String, Integer> idades = new HashMap<>();
        idades.put("Erica", 30);
        idades.put("Julia", 19);

        Assertions.assertThat(idades)
                .hasSize(2)
                .containsKeys("Erica", "Julia")
                .containsValues(30, 19)
                .doesNotContainEntry("Paula", 45);
    }

    @Test
    void deveValidarQueues() {
        Queue<String> queue = new LinkedList<>(Arrays.asList("Erica", "Paula", "Telma"));

        Assertions.assertThat(queue).hasSize(3).contains("Erica");
    }


    @Test
    void deveValidarException() {
        Assertions.assertThatThrownBy(() -> {
            throw new IllegalArgumentException("Invalid argument");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid argument")
                .hasMessageContaining("Invalid")
                .hasNoCause();
    }
}
