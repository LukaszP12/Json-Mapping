package pl.strefakursow.klientbank.model;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Builder
public class KartaKredytowa {
    private String numerRachunkuDoSplaty;
    private String nazwa;
    private BigDecimal kwotaDoSplaty;
    private BigDecimal przyznanyLimit;
    private String oprocentowanie;
    private List<Operacja> historiaOperacji;
}
