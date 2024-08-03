package br.com.zeroth.tujava.transcacao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transacao {
    private String id;
    private double valor;
    private LocalDate data;
    private TipoTransacao tipo;

    public boolean validar() {
        if(valor <=0) return false;
        if(data.isAfter(LocalDate.now())) return false;
        return tipo != null;
    }
}
