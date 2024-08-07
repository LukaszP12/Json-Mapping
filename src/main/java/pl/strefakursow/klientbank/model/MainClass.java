package pl.strefakursow.klientbank.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.math.NumberUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainClass {
    public static void main(String[] args) throws JsonProcessingException {
        Klient klient = utworzKlienta();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        try {
            String json = objectMapper.writeValueAsString(klient);
            System.out.println("json klienta : " + json);

            klient.builder()
                    .portfel(Portfel.builder().kredyty(new ArrayList<>()).build())
                    .build();

            klient.getPortfel().getKredyty().add(Kredyt.builder()
                    .nazwa("Dodany w aplikacji")
                    .numerRachunkuDoSplaty("PL302044332211010203")
                    .kwotaDoSplaty(NumberUtils.createBigDecimal("66.00"))
                    .oprocentowanie("5.00%")
                    .build());

            String json_output = objectMapper.writeValueAsString(klient);
            System.out.println(json_output);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    private static Klient utworzKlienta() {
        return Klient.builder()
                .imie("Lukasz")
                .nazwisko("Piwowarski")
                .pesel("12390102030")
                .adresZamieszkania(Adres.builder()
                        .miejscowosc("Sanok")
                        .kodPocztowy("38-500")
                        .ulica("Jagiellońska")
                        .nrBudynku("22")
                        .nrLokalu("12a")
                        .build())
                .dokument(Dokument.builder()
                        .numerDowodu("ABDB12")
                        .dataWystawienia(LocalDate.of(2000, 01, 28))
                        .dataWaznosci(LocalDate.of(2020, 03, 30))
                        .organWydajacy("Mayor of Warsaw")
                        .build())
                .portfel(Portfel.builder()
                        .rachunki(null)
                        .kredyty(null)
                        .kartyKredytowe(null)
                        .build())
                .plec(Plec.MEZCZYZNA)
                .build();
    }

    private static List<KartaKredytowa> utworzKartyKredytowe() {
        List<KartaKredytowa> KartyKredytowe = new ArrayList<>();
        KartyKredytowe.add(KartaKredytowa.builder()
                .nazwa("Kredyt konsumencki")
                .numerRachunkuDoSplaty("PL1540302010")
                .kwotaDoSplaty(NumberUtils.createBigDecimal("2300.05"))
                .przyznanyLimit(NumberUtils.createBigDecimal("10000.00"))
                .oprocentowanie("4.00%")
                .historiaOperacji(utworzHistorie(5))
                .build());
        KartyKredytowe.add(KartaKredytowa.builder()
                .nazwa("Kredyt samochodowy")
                .numerRachunkuDoSplaty("PL54103044")
                .kwotaDoSplaty(NumberUtils.createBigDecimal("300.05"))
                .przyznanyLimit(NumberUtils.createBigDecimal("10000.00"))
                .oprocentowanie("7.05%")
                .historiaOperacji(utworzHistorie(2))
                .build());
        return KartyKredytowe;
    }

    private static List<Kredyt> utworzKredyty() {
        List<Kredyt> kredyty = new ArrayList<>();
        kredyty.add(Kredyt.builder()
                .nazwa("Kredyt konsumencki")
                .numerRachunkuDoSplaty("PL1540302010")
                .kwotaDoSplaty(NumberUtils.createBigDecimal("2300.05"))
                .oprocentowanie("4.00%")
                .historiaOperacji(utworzHistorie(5))
                .build());
        kredyty.add(Kredyt.builder()
                .nazwa("Kredyt samochodowy")
                .numerRachunkuDoSplaty("PL54103044")
                .kwotaDoSplaty(NumberUtils.createBigDecimal("300.05"))
                .oprocentowanie("7.05%")
                .historiaOperacji(utworzHistorie(2))
                .build());
        return kredyty;
    }

    private static List<Rachunek> utworzRachunki() {
        List<Rachunek> rachunki = new ArrayList<>();
        rachunki.add(Rachunek.builder()
                .nazwa("Konto osobiste")
                .numerRachunku("PL1540302010")
                .saldo(NumberUtils.createBigDecimal("2300.05"))
                .oprocentowanie("0.00%")
                .historiaOperacji(utworzHistorie(5))
                .build());
        rachunki.add(Rachunek.builder()
                .nazwa("Konto oszczędnościowe")
                .numerRachunku("PL54103044")
                .saldo(NumberUtils.createBigDecimal("300.05"))
                .oprocentowanie("0.05%")
                .historiaOperacji(utworzHistorie(2))
                .build());
        return rachunki;
    }

    private static List<Operacja> utworzHistorie(int iloscOperacji) {
        List<Operacja> operacje = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < operacje.size(); i++) {
            operacje.add(Operacja.builder()
                    .dataOperacji(LocalDate.of(2000, 2, random.nextInt(28) + 1))
                    .kwota(NumberUtils.createBigDecimal("12.20"))
                    .tytul("Operacja nr " + (i + 1))
                    .build());
        }
        return operacje;
    }

}
