package pl.strefakursow.klientbank.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Portfel {
    private List<Rachunek> rachunki;
    private List<Kredyt> kredyty;
    private List<KartaKredytowa> kartyKredytowe;

}
