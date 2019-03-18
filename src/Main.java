


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {



        int vsota = 0;
        int m = 0;
        double DDV = 0.22;
        int DDVvsota = 0;
        int ean = 0;



      /*  bar.setCodeToEncode("123456789933");
        bar.setSymbology(IBarCode.EAN13);
        bar.setX(2);
        bar.setY(50);
        bar.setRightMargin(0);
        bar.setLeftMargin(0);
        bar.setTopMargin(0);
        bar.setBottomMargin(0);

        try
        {

            bar.draw("C:\\Fax\\Prog_jeziki_2019\\ean13.gif");

        }
        catch (Exception e) {
            e.printStackTrace();
        }*/


        UUID uuid = UUID.randomUUID();
        String randUUIDString = uuid.toString();
        List<Artikel> seznam = new ArrayList<>();
        seznam.add(new Artikel(250, "pepsi", 1,randUUIDString));
        seznam.add(new Artikel(300, "fanta", 2,randUUIDString));
        seznam.add(new Artikel(100, "sprite", 3,randUUIDString));
        seznam.add(new Artikel(100, "sok", 2,randUUIDString));
        seznam.add(new Artikel(100, "sok", 1,randUUIDString));

        for (Artikel pr : seznam) {
            vsota += pr.getCena() * pr.getKolicina();
            DDVvsota += (vsota * 100) / DDV;
            m = (vsota + DDVvsota) / 1000;

        }


        Artikli test1 = new Artikli(seznam);
        test1.dodaj(new Artikel(2, "pivo", 1,randUUIDString));

        //Racun test = new Racun(randUUIDString,test1,datum,);
        System.out.println(seznam);

        System.out.println("Skupna cena: " + vsota + " KONCNA: " + m);

        //System.out.println(test);
        //System.out.println(test);
        System.out.println("uuid" + randUUIDString);


        //2naloga

        Podjetje p1 = new Podjetje("Henkel", 58665765, 6261752000L, true);
        Podjetje p2 = new Podjetje("Energija Plus", 88157598, 3991008000L, true);
        Podjetje p3 = new Podjetje("Snaga", 30543517, 5015545000L, false);
        System.out.println(p1);


        Racun noviRacun = new Racun(randUUIDString, test1,  new Date(), p1);
        System.out.println(noviRacun);

        seznam.remove(0);
        seznam.remove(1);


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
