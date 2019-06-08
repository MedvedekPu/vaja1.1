package Drugo;

import java.util.Date;

public class Racun implements Searchable {

    String id; // unikatna
    protected Date datum;
    Artikli art;
    Podjetje izdajatelj; // 2.1
    int davcna; //davcna st. kupca




    public Racun(String id, Artikli art, Date datum, Podjetje izdajatelj, int davcna) {
        this.id = id; // web unique key
        this.datum = datum;
        this.art=art;
        this.davcna=davcna;
        this.izdajatelj = izdajatelj;
    }

    public int getDavcna() {
        return davcna;
    }

    public void setDavcna(int davcna) {
        this.davcna = davcna;
    }
    public Artikli getArt() {
        return art;
    }

    public void setArt(Artikli art) {
        this.art = art;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId() {
        return id;
    }
    public void setIzdajatelj(Podjetje izdajatelj)
    {
        this.izdajatelj = izdajatelj;
    }

    public Podjetje getIzdajatelj() {
        return izdajatelj;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    @Override
    public String toString() {
        return "Drugo.Racun: " +
                "id='" + id + "\n"+ "davcna st:" + davcna + "\n" +
                "-----------------------------------------------"+"\n"+
                "izdajatelj: " + izdajatelj + "\n"+
                "datum: " + datum + "\n"+
                 art +
                "\n"+ "----------------------------------------------------------";
    }

    public String neorg(){
        return "Drugo.Racun: " +
                "id='" + id + "\n"+ "davcna st:" + davcna + "\n" +
                "datum: " + datum + "\n"+
                art +
                "\n"+ "----------------------------------------------------------";

    }



    @Override
    public boolean search(String n) {
        if(id.contains(n)||String.valueOf(datum).contains(n)||String.valueOf(davcna).contains(n)||izdajatelj.search(n))
            return true;

        return false;
    }
}
