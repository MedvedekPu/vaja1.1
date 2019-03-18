import com.keepautomation.barcode.BarCode;

import java.lang.*;
import java.util.UUID;


public class Artikel implements Searchable {
    private int Cena;
    private int Kolicina;
    private String Ime;
    private int EAN;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

//arCode barcode; // ean koda


    private int ddv;

    public int getDdv() {
        return ddv;
    }

    public void setDdv(int ddv) {
        this.ddv = ddv;
    }


    public String getIme() {
        return Ime;
    }

    public void setIme(String ime) {
        Ime = ime;
    }

    public int getCena() {
        return Cena;
    }

    public void setCena(int Cena) {

        Cena = Cena;
    }

    /*public void setBarcode(BarCode barcode) {

        this.barcode = barcode;
    }*/

    public int getKolicina() {
        return Kolicina;
    }

    public void setKolicina(int Kolicina) {
        Kolicina = Kolicina;
    }


    public Artikel(int Cena, String ime, int Kolicina,String id) {

        this.id=id;
        this.Cena = Cena;
        this.Ime = ime;
        this.Kolicina = Kolicina;


    }

    @Override
    public String toString() {
        return "\n" + "Artikel{" +
                "Cena=" + Cena +
                ", Kolicina=" + Kolicina +
                ", Ime='" + Ime + '\'' + "EAN= " + random() +
                '}';
    }

    @Override
    public boolean search(String n) {
        if (n == getIme())
            return false;

        return false;
    }

    private int random() {

        return (int) Math.floor(Math.random() * (99999999 - 10000000 + 1)) + 10000000;
    }

    public boolean compare(){
        if(this.getIme()== this.getIme()){
            this.setKolicina(1);
        return true;
        }

    return false;
    }


    final boolean checkDigit() {

        // izracun napisemo sem

        return true;
    }

}

