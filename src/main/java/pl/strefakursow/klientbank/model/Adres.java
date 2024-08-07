package pl.strefakursow.klientbank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Adres {
    @JsonProperty("city")
    private String miejscowosc;
    @JsonProperty("street")
    private String ulica;
    @JsonProperty("building_nr")
    private String nrBudynku;
    @JsonProperty("apartment_nr")
    private String nrLokalu;
    @JsonProperty("post_code")
    private String kodPocztowy;
}
