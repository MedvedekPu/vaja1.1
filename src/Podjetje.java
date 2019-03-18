public class Podjetje  implements Searchable{
     String Ime;
     int davcna;
    long maticna;
     boolean zavezanec;

    public Podjetje(String ime, int davcna, long maticna, boolean zavezanec) {
        Ime = ime;
        this.davcna = davcna;
        this.maticna = maticna;
        this.zavezanec = zavezanec;
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
        return "Podjetje{" +
                "Ime='" + Ime + '\'' +
                ", davcna=" + davcna +
                ", maticna=" + maticna +
                ", zavezanec=" + zavezanec +
                '}';
    }

    @Override
    public boolean search(String n) {
        if(n==getIme())
            return true;

        return false;
    }
}
