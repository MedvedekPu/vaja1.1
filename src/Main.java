


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

public class  Main {

    public static void main(String[] args) {

        long[]  EAN1= {2,1,1,0,0,3,3,0,2,0,0,8,0};
        long[]  EAN2 ={2,2,1,1,2,3,2,1,2,3,2,2,3};
        long[]  EAN3 ={2,3,1,1,2,3,2,1,2,3,1,5,2};


        int vsota = 0;
        int m = 0;
        double DDV = 0.22;
        int DDVvsota = 0;




        UUID uuid = UUID.randomUUID();
        String randUUIDString = uuid.toString();
       List<Artikel> seznam = new ArrayList<>();

        seznam.add(new Artikel(250, "jabolka", 1,randUUIDString,EAN1,0));
        seznam.add(new Artikel(300, "p", 2,randUUIDString,EAN2,13));
        seznam.add(new Artikel(100, "kruh beli", 2,randUUIDString,EAN3,0));

        for (Artikel pr : seznam) {
            vsota += pr.getCena() * pr.getKolicina();
            DDVvsota += (vsota * 100) / DDV;
            m = (vsota + DDVvsota) / 1000;

        }
        Artikel t1 = new Artikel(300, "pepsi", 1,randUUIDString,EAN2,0);





        Artikli test1 = new Artikli(seznam);
        test1.dodaj(seznam.get(0));
        test1.dodaj(seznam.get(1));
        test1.dodaj(seznam.get(2));


        Artikli test3 = new Artikli();
        test3.dodaj(t1);



        List<Artikel> s = new ArrayList<>();
        s.add(new Artikel(2,"ss0",1,"123435454534",EAN2,0));
        Artikli t2 = new Artikli(s);
        //System.out.println("IZPIS_testni: "+ s);

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



        System.out.println("Skupna cena__: " + vsota + " KONCNA z ddv: " + m); // skupna cena z DDV-jem


        System.out.println("IZPIS CE JE ENUM VELJAVEN: " +t1.checkDigit(t1.getEAN()) +"\n"); // check digit preizkus
        System.out.println("NAJDENO ALI NE" + t1.search("pepsi") ); // search metoda preizkus
        System.out.println("NAJDENO ALI NE  test1:  " + test1.search("kruh beli") ); // search metoda preizkus




        Racun noviRacun2 = new Racun(randUUIDString,test1,  new Date(), p1,53215465);


        System.out.println("PRIMER IZPISA ARTIKLOV IZ JSONA");
        Artikli test2 = new Artikli();
        test1.toJson();
        test2.fromJson("C:\\Users\\aleks\\Desktop\\test.json");


        Companies comp1 = new Companies();
        comp1.dodaj_tab(p1);
        System.out.println("PRIMER IZPISA PODJETJA IZ JSONA");
        comp1.toJson();
        comp1.fromJson("C:\\Users\\aleks\\Desktop\\test_c.json");

        Invoices inv1 = new Invoices();
        inv1.dodaj_tab(noviRacun);

        System.out.println("PRIMER IZPISA RACUNA IZ JSONA");
        inv1.toJson();
        inv1.fromJson("C:\\Users\\aleks\\Desktop\\test2.json");







      /*  seznam.remove(0);
        seznam.remove(1);
*/


    }

}
