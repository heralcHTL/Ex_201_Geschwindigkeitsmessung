
import java.time.LocalDate;
import java.time.LocalTime;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Richard Hofmeister
 */
public class Measurement {
    private LocalDate datum;
    private LocalTime uhrzeit;
    private String kennzeichen;
    private int gemessen;
    private int erlaubt;

    public Measurement(LocalDate datum, LocalTime uhrzeit, String kennzeichen, int gemessen, int erlaubt) {
        this.datum = datum;
        this.uhrzeit = uhrzeit;
        this.kennzeichen = kennzeichen;
        this.gemessen = gemessen;
        this.erlaubt = erlaubt;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
}
