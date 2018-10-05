package BL;

import java.awt.Color;
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
    private Color background;

    public Measurement(LocalDate datum, LocalTime uhrzeit, String kennzeichen, int gemessen, int erlaubt) {
        this.datum = datum;
        this.uhrzeit = uhrzeit;
        this.kennzeichen = kennzeichen;
        this.gemessen = gemessen;
        this.erlaubt = erlaubt;
    }

    public void getBackgroundColor()
    {
        if(gemessen-erlaubt <= 10)
        {
            background = Color.BLUE;
        }
        if(gemessen-erlaubt <= 20)
        {
            background = Color.YELLOW;
        }
        if(gemessen-erlaubt <= 30)
        {
            background = Color.ORANGE;
        }
        else
        {
            background = Color.RED;
        }
    }

    public Color getBackground() {
        return background;
    }
    
    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    public LocalDate getDatum() {
        return datum;
    }

    public LocalTime getUhrzeit() {
        return uhrzeit;
    }

    public String getKennzeichen() {
        return kennzeichen;
    }

    public int getGemessen() {
        return gemessen;
    }

    public int getErlaubt() {
        return erlaubt;
    }
    
    
}
