package br.com.zeroth.tujava.transacao;

import br.com.zeroth.tujava.transcacao.Cliente;
import br.com.zeroth.tujava.transcacao.TipoTransacao;
import br.com.zeroth.tujava.transcacao.Transacao;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TransacaoTest {

    static class ClienteConverter extends SimpleArgumentConverter{

        @Override
        protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
            String[] data = source.toString().split(",");
            return new Cliente(data[0], Integer.parseInt((data[1])));
        }
    }

    @ParameterizedTest
    @CsvSource({
            "'tx1', 100.0, '2023-10-10', 'DEBITO', true",
            "'tx2', -50.0, '2023-10-20', 'CREDITO', false",
            "'tx3', 200.0, '2023-11-20', 'TRASNFERENCIA', true",
            "'tx4', 150.0, '2023-12-20', '', false",
    })
    public void deveValidarTransacao(String id, double valor, String data, String tipo, boolean resultadoEsperado){

        TipoTransacao tipoTransacao = tipo.isEmpty() ? null : TipoTransacao.valueOf(tipo);
        Transacao transacao = new Transacao(id, valor, LocalDate.parse(data), tipoTransacao);

        System.out.println(valor);
        System.out.println(transacao.validar());

        assertEquals(resultadoEsperado, transacao.validar());

    }

    @ParameterizedTest
    @EnumSource(TipoTransacao.class)
    public void deveValidarTipoTransacao(TipoTransacao tipo) {
        Transacao transacao = new Transacao("TX", 100.0, LocalDate.now(), tipo);
        assertTrue(transacao.validar());
    }


    @ParameterizedTest
    @MethodSource("forneceDadosParaValidarTransacao")
    void deveValidarTranscacaoComMetSo(String id, double valor, LocalDate data, TipoTransacao tipo, boolean resultadoEsperado) {
        Transacao transacao = new Transacao(id, valor, data, tipo);

        assertEquals(resultadoEsperado, transacao.validar());
    }

    static Stream<Arguments> forneceDadosParaValidarTransacao(){
        return Stream.of(
                Arguments.of("tx1", 100.0, LocalDate.of(2023, 1, 10), TipoTransacao.DEBITO, true),
                Arguments.of("tx2", -50.0, LocalDate.of(2023, 10, 10), TipoTransacao.CREDITO, false),
                Arguments.of("tx3", 200.0, LocalDate.of(2023, 11, 10), TipoTransacao.TRASNFERENCIA, true),
                Arguments.of("tx4", 150.0, LocalDate.of(2023, 12, 10), null, false)
        );
    }


    @ParameterizedTest
    @CsvSource({
            "'Joao,25', 25",
            "'Maria,30', 30",
    })
    public void deveValidarConstrucaoObjetoClienteEValidarIdade(@ConvertWith(ClienteConverter.class) Cliente cliente, int idadeEsperada) {
        assertEquals(idadeEsperada, cliente.getIdade());
    }


    @Test
    void name() {

        String nome = "JUnit";
        //Assertions.assertThat(nome).isEqualTo("JUnit").startsWith("J").endsWith("t").contains("Unit");

        Cliente cliente = new Cliente("Maria", 30);

        Assertions.assertThat(cliente)
                .isNotNull()
                .isInstanceOf(Cliente.class);
    }
}
