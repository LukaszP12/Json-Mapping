package pl.strefakursow.klientbank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Klient {
    @JsonProperty("last_name")
    private String nazwisko;
    @JsonProperty("first_name")
    private String imie;
    @JsonProperty("citizen_id")
    private String pesel;
    @JsonProperty("gender")
    private Plec plec;
    @JsonProperty("residential_address")
    private Adres adresZamieszkania;
    @JsonProperty("document")
    private Dokument dokument;
    @JsonProperty("wallet")
    private Portfel portfel;

}
