


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

public class  Main {

    public static void main(String[] args) {



        int vsota = 0;
        int m = 0;
        double DDV = 0.22;
        int DDVvsota = 0;
        int ean = 0;

        UUID uuid = UUID.randomUUID();
        String randUUIDString = uuid.toString();
       List<Artikel> seznam = new ArrayList<>();
        seznam.add(new Artikel(250, "pepsi", 1,randUUIDString));
        seznam.add(new Artikel(300, "fanta", 2,randUUIDString));
        seznam.add(new Artikel(100, "sprite", 3,randUUIDString));
        seznam.add(new Artikel(100, "sok", 2,randUUIDString));

        for (Artikel pr : seznam) {
            vsota += pr.getCena() * pr.getKolicina();
            DDVvsota += (vsota * 100) / DDV;
            m = (vsota + DDVvsota) / 1000;

        }


        Artikli test1 = new Artikli(seznam);
        test1.dodaj(seznam.get(0));

        List<Artikel> s = new ArrayList<>();
        s.add(new Artikel(2,"ss0",1,randUUIDString));
        Artikli t2 = new Artikli(s);
        System.out.println("IZPIS_testni: "+ s);


        //Racun test = new Racun(randUUIDString,test1,datum,);
        System.out.println(seznam.toString());

        System.out.println("Skupna cena: " + vsota + " KONCNA: " + m);

        //System.out.println(test);
        //System.out.println(test);
        //System.out.println("uuid" + randUUIDString);


        //2naloga

        Podjetje p1 = new Podjetje("Henkel", 58665765, 6261752000L, true);
        Podjetje p2 = new Podjetje("Energija Plus", 88157598, 3991008000L, true);
        Podjetje p3 = new Podjetje("Snaga", 30543517, 5015545000L, false);
        System.out.println(p1);


        Racun noviRacun = new Racun(randUUIDString,test1,  new Date(), p1);
        //Racun n2 = new Racun(randUUIDString,seznam,new Date(),p2);
        System.out.println(noviRacun);





        seznam.remove(0);
        seznam.remove(1);



        /*String[] locales = Locale.getISOCountries();

        for (String countryCode : locales) {

            Locale obj = new Locale("", countryCode);

            System.out.println("Country Code = " + obj.getCountry()
                    + ", Country Name = " + obj.getDisplayCountry());

        }*/



    }


    /**
     *
     * Ali za znesek uporabiti int ali double?
     * int
     * Kaj je ID? kako ga implementirati?
     *
     * Kaj je EAN koda?
     * Ali je primerna za primarni ključ? Da
     *
     */
}
