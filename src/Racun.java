import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Racun implements Searchable {

    String id; // unikatna
    protected Date datum;
    Artikli art;
    Podjetje izdajatelj; // 2.1




    public Racun(String id, Artikli art, Date datum, Podjetje izdajatelj) {
        this.id = id; // web unique key
        this.datum = datum;
        this.art=art;
        this.izdajatelj = izdajatelj;
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
        return "Racun{" +
                "id='" + id + '\'' +
                ", izdajatelj=" + izdajatelj +
                ", datum=" + datum + "\n"+
                ", artikli=" + art +
                '}';
    }




    @Override
    public boolean search(String n) {
        if(n==getIzdajatelj().getIme())
            return true;

        return false;
    }
}
