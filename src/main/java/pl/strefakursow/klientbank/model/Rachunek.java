package pl.strefakursow.klientbank.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Rachunek {
    private String numerRachunku;
    private String nazwa;
    private BigDecimal saldo;
    private String oprocentowanie;
    private List<Operacja> historiaOperacji;
}
