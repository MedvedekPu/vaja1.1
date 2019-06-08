package Drugo;

import java.util.UUID;

public class Podjetje  implements Searchable{
     String Ime;
     int davcna;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    UUID id;
     long maticna;
     boolean zavezanec;
     String naslov,telefon;

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public Podjetje(UUID id, String ime, int davcna, long maticna, String telefon, boolean zavezanec, String naslov) {
        Ime = ime;
        if(id == null)
        {
            this.id = UUID.randomUUID();
        }
        else
        {
            this.id = id;
        }
        this.davcna = davcna;
        this.maticna = maticna;
        this.zavezanec = zavezanec;
        this.naslov = naslov;
        this.telefon = telefon;
    }

    public String getIme() {
        return Ime;
    }

    public void setIme(String ime) {
        Ime = ime;
    }

    public int getDavcna() {
        return davcna;
    }

    public void setDavcna(int davcna) {
        this.davcna = davcna;
    }

    public long getMaticna() {
        return maticna;
    }

    public void setMaticna(long maticna) {
        this.maticna = maticna;
    }

    public boolean isZavezanec() {
        return zavezanec;
    }

    public void setZavezanec(boolean zavezanec) {
        this.zavezanec = zavezanec;
    }


    @Override
    public String toString() {
        return "Drugo.Podjetje{" +
                "Ime='" + Ime + '\'' +
                ", davcna=" + davcna +
                ", maticna=" + maticna +
                ", zavezanec=" + zavezanec +
                '}';
    }

    @Override
    public boolean search(String n) {
        if(Ime.contains(n)||String.valueOf(davcna).contains(n)||String.valueOf(maticna).contains(n))
            return true;

        return false;
    }
}
