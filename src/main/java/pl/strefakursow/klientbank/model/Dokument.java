package pl.strefakursow.klientbank.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Dokument {
    @JsonProperty("documentId")
    private String numerDowodu;
    @JsonProperty("date_of_issue")
    private LocalDate dataWystawienia;
    @JsonProperty("date_of_validity")
    private LocalDate dataWaznosci;
    @JsonProperty("issuer")
    private String organWydajacy;
}
