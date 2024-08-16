package br.com.zeroth.tujava.moc;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class BrincandoComMocksTest {
    @Test
    void name() {
        List<String> listaMockada = mock(List.class);

        when(listaMockada.get(anyInt())).thenAnswer( invocation -> {
           int index = invocation.getArgument(0);
           return "intem na posicao " + index;
        });

        System.out.println(listaMockada.get(0));
        System.out.println(listaMockada.get(1));
        System.out.println(listaMockada.get(2));

    }

    @Test
    void deveRetornarRespostasDiferentesEmChamadasSubsequentes() {

        List<String> mockedList = mock(List.class);

        when(mockedList.size()).thenReturn(1, 2, 3);

        System.out.println(mockedList.size());
        System.out.println(mockedList.size());
        System.out.println(mockedList.size());
        System.out.println(mockedList.size());
    }

    @Test
    void deveCriarUmStubbingDeExceptions() {
        List<String> mockedList = mock(List.class);

        //simulaçao de exception

        when(mockedList.get(anyInt())).thenThrow(new RuntimeException("Exception de negocios"));

        try{
            mockedList.get(0);
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }

    }

    @Test
    void deveRealizarUmaVerificacaoSimples() {
        List<String> mockedList = mock(List.class);

        mockedList.add("1");
        mockedList.clear();

        //verifica se o metodo add foi chamado com o argumento 1
        verify(mockedList).add("1");

        verify(mockedList).clear();
    }


    @Test
    void deveVerificarNumeroDeIteracoes() {

        List<String> mockedList = mock(List.class);
        mockedList.add("1");
        mockedList.add("1");

        mockedList.clear();

        verify(mockedList, times(2)).add("1");
        verify(mockedList, never()).add("2");
        verify(mockedList, atLeastOnce()).clear();

    }

    @Test
    void deveCriarUmSpy() {
        List<String> spyList = spy(new ArrayList<>());

        spyList.add("1");
        spyList.add("2");

        verify(spyList).add("1");
        verify(spyList).add("2");

        assertThat(spyList.size()).isEqualTo(2);

    }



  @Test
    public void deveVerificarDeFormaOrdenada(){
        List<String> mockedList = mock(List.class);
      mockedList.add("1");
      mockedList.clear();

      InOrder inOrder = inOrder(mockedList);


      inOrder.verify(mockedList).add("1");
      inOrder.verify(mockedList).clear();

  }


    @Test
    void deveVerificarNumeroDeIteracoesDoMetodo() {
        List<String> mockedList = mock(List.class);
        mockedList.add("1");
        mockedList.add("1");

        mockedList.clear();
        

        verify(mockedList, times(2)).add("1");
        verify(mockedList, never()).add("2");
        verify(mockedList, atLeastOnce()).clear();
    }



























}


