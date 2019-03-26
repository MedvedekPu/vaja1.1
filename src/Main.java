


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

public class  Main {

    public static void main(String[] args) {

        int[]  EAN1= {9,1,3,0,0,3,3,5,1,2,2,8,0};
        int[]  EAN2 ={3,8,3,1,2,3,2,1,2,3,2,2,0};
        int[]  EAN3 ={4,0,2,1,2,3,2,1,2,3,1,5,0};

        int vsota = 0;
        int m = 0;
        double DDV = 0.22;
        int DDVvsota = 0;




        UUID uuid = UUID.randomUUID();
        String randUUIDString = uuid.toString();
       List<Artikel> seznam = new ArrayList<>();

        seznam.add(new Artikel(250, "pepsi", 1,randUUIDString,EAN1));
        seznam.add(new Artikel(300, "fanta", 2,randUUIDString,EAN2));
        seznam.add(new Artikel(100, "sprite", 3,randUUIDString,EAN2));
        seznam.add(new Artikel(100, "sok", 2,randUUIDString,EAN3));

        for (Artikel pr : seznam) {
            vsota += pr.getCena() * pr.getKolicina();
            DDVvsota += (vsota * 100) / DDV;
            m = (vsota + DDVvsota) / 1000;

        }
        Artikel t1 = new Artikel(300, "pepsi", 1,randUUIDString,EAN2);





        Artikli test1 = new Artikli(seznam);
        test1.dodaj(seznam.get(0));
        test1.dodaj(seznam.get(1));
        test1.dodaj(seznam.get(2));
        test1.dodaj(seznam.get(3));
       // test1.dodaj(seznam.get(1));


        List<Artikel> s = new ArrayList<>();
        s.add(new Artikel(2,"ss0",1,"123435454534",EAN2));
        Artikli t2 = new Artikli(s);
        //System.out.println("IZPIS_testni: "+ s);


        //Racun test = new Racun(randUUIDString,test1,datum,);
       // System.out.println(seznam.toString());


        //System.out.println(test);
        //System.out.println(test);
        //System.out.println("uuid" + randUUIDString);


        //2naloga

        Podjetje p1 = new Podjetje("Henkel", 58665765, 6261752000L, true);
        Podjetje p2 = new Podjetje("Energija Plus", 88157598, 3991008000L, true);
        Podjetje p3 = new Podjetje("Snaga", 30543517, 5015545000L, true);
       // System.out.println(p1);



        ////////IZPIS RACUNA JE TU!!!!

        Racun noviRacun = new Racun(randUUIDString,test1,  new Date(), p1,53215465);
        //Racun n2 = new Racun(randUUIDString,seznam,new Date(),p2);
        System.out.println(noviRacun);

        for (Artikel pr : seznam) {
            vsota += pr.getCena() * pr.getKolicina();
            DDVvsota += (vsota * 100) / DDV;
            m = (vsota + DDVvsota) / 1000;

        }



        System.out.println("Skupna cena__: " + vsota + " KONCNA: " + m);





        seznam.remove(0);
        seznam.remove(1);



       /* String[] locales = Locale.getISOCountries();

        for (String countryCode : locales) {

            Locale obj = new Locale("", countryCode);

            System.out.println("Country Code = " + obj.getCountry()
                    + ", Country Name = " + obj.getDisplayCountry());

        }*/

        System.out.println("IZPIS CE JE ENUM VELJAVEN: " +t1.checkDigit(t1.getEAN()));




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
