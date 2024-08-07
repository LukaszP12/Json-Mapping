package pl.strefakursow.klientbank.model;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class OdczytJson {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        Klient klient = null;
        try {
            klient = objectMapper.readValue(new File("klient_banku.json"), Klient.class);
            System.out.println("klient: ");
            System.out.println(klient);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
