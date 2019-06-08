package Drugo;


import Baza.MySqlArticle;
import Baza.MySqlCompany;
import Baza.MySqlnternalArticle;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class  Main {




    public static void main(String[] args)throws SQLException
    {

       // Vaja05_3();
        DBHelper.comit();


    }

    private static void Vaja05_3()
    {
        try
        {
            MySqlArticle sqlArticle = new MySqlArticle();
            MySqlnternalArticle sqlInternalArticle = new MySqlnternalArticle();
            MySqlCompany sqlCompany = new MySqlCompany();

            UUID uuid = UUID.randomUUID();
            String randUUIDString = uuid.toString();
            List<Artikel> seznam = new ArrayList<>();

           // Podjetje p6 = new Podjetje(UUID.fromString("2552c81f-d251-4519-ab15-9fa0edabed95"),"BigBang d.o.o.", 18918557, 3936066000L, "041801035", true ,"asdsad");

          /*  Podjetje p1 = new Podjetje(UUID.fromString("b511aafd-88b5-4dd3-8ff3-2e164840a0dl"),"Kinezika d.o.o.", 18918557, 3936066000L, "asdsa", true ,"asdsad");
            Podjetje p2 = new Podjetje(UUID.fromString("580eedaa-9e85-4f88-a3f7-e3d67a34c699"),"Kinezika1 d.o.o.", 18918557, 3936066000L, "asdsa", true ,"asdsad");
            Podjetje p3 = new Podjetje(UUID.fromString("9f74e0c5-9470-4f25-9340-43a96f062271"),"Kinezika2 d.o.o.", 18918557, 3936066000L, "asdsa", true ,"asdsad");
            Podjetje p4 = new Podjetje(UUID.fromString("c1965b21-905d-4df9-9ca0-9affd5eaa01f"),"Kinezika3 d.o.o.", 18918557, 3936066000L, "asdsa", true ,"asdsad");*/
            //Podjetje p5 = new Podjetje(UUID.fromString("2552c81f-d251-4519-ab15-9fa0edabed95"),"BigBang d.o.o.", 18918557, 3936066000L, "041801035", true ,"asdsad");

            /*sqlCompany.insert(p1);
            sqlCompany.insert(p2);
            sqlCompany.insert(p3);
            sqlCompany.insert(p4);*/
            //sqlCompany.insert(p6);
            long[]  EAN1= {2,1,1,0,0,3,3,0,2,0,0,8,0};
            long[]  EAN2 ={2,2,1,1,2,3,2,1,2,3,2,2,3};
            long[]  EAN3 ={2,3,1,1,2,3,2,1,2,3,1,5,6};
            long[]  EAN4 ={2,2,1,1,2,3,2,1,2,3,2,2,7};
            long[]  EAN5 ={2,3,1,1,2,3,2,1,2,3,1,5,2};
            Artikel a1 = new Artikel(UUID.fromString("a7ad848e-2cf6-4b2c-866a-3e0d18a107f0"),EAN1,"Prah",2500, 22.0, 1);
            Artikel a2 = new Artikel(UUID.fromString("36b676db-a92b-47bd-9c24-03924dfede9d"),EAN2,"Sok",1000, 22.0, 5);
            Artikel a3 = new Artikel(UUID.fromString("1e6b765d-f9bc-49fb-a84f-a3b1abb36dfa"),EAN3,"Kruh",1000, 22.0, 2);
            Artikel a4 = new Artikel(UUID.fromString("f7f582a1-3e73-49f4-a400-5a2729866b91"),EAN4,"Mleko",1, 22.0,  500);
            Artikel a5 = new Artikel(UUID.fromString("9b0b8e6f-c057-41bd-a6d2-a98bb1d4429f"),EAN5,"Banane",1, 22.0, 132);
            sqlInternalArticle.insert(a1);
            sqlInternalArticle.insert(a2);
            sqlInternalArticle.insert(a3);
            sqlInternalArticle.insert(a4);
            sqlInternalArticle.insert(a5);
            sqlInternalArticle.update(a5);

          /*  Artikli ars1 = new Artikli();
            ars1.add(new Artikel(a1.getId(), 8));
            ars1.add(new Artikel(a2.getId(), 3));
            ars1.add(new Artikel(a4.getId(), 7));
            Racun r1 = new Racun(UUID.fromString("0a54a574-5790-41d8-9bb7-d438e7abab1c"), ars1, "Simon Vajs");
            Articles ars2 = new Articles();
            ars2.add(new Artikel(a3.getId(), 2));
            ars2.add(new Artikel(a5.getId(), 2));
            Racun r2 = new Racun(UUID.fromString("53a19d10-ec08-4634-8ab9-a2715357f7fa"), ars2, "Primoz Vajs");

            create_invoice(r1);
            create_invoice(r2);*/
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage()+"asd asd");
        }
    }




      /*  long[]  EAN1= {2,1,1,0,0,3,3,0,2,0,0,8,0};
        long[]  EAN2 ={2,2,1,1,2,3,2,1,2,3,2,2,3};
        long[]  EAN3 ={2,3,1,1,2,3,2,1,2,3,1,5,2};


        int vsota = 0;
        int m = 0;
        double DDV = 0.22;
        int DDVvsota = 0;




        UUID uuid = UUID.randomUUID();
        String randUUIDString = uuid.toString();
        List<Drugo.Artikel> seznam = new ArrayList<>();

        seznam.add(new Drugo.Artikel(250, "jabolka", 1,randUUIDString,EAN1,0));
        seznam.add(new Drugo.Artikel(300, "p", 2,randUUIDString,EAN2,13));
        seznam.add(new Drugo.Artikel(100, "kruh beli", 2,randUUIDString,EAN3,0));

        for (Drugo.Artikel pr : seznam) {
            vsota += pr.getCena() * pr.getKolicina();
            DDVvsota += (vsota * 100) / DDV;
            m = (vsota + DDVvsota) / 1000;

        }
        Drugo.Artikel t1 = new Drugo.Artikel(300, "pepsi", 1,randUUIDString,EAN2,0);





        Drugo.Artikli test1 = new Drugo.Artikli(seznam);
        test1.dodaj(seznam.get(0));
        test1.dodaj(seznam.get(1));
        test1.dodaj(seznam.get(2));


        Drugo.Artikli test3 = new Drugo.Artikli();
        test3.dodaj(t1);



        List<Drugo.Artikel> s = new ArrayList<>();
        s.add(new Drugo.Artikel(2,"ss0",1,"123435454534",EAN2,0));
        Drugo.Artikli t2 = new Drugo.Artikli(s);
        //System.out.println("IZPIS_testni: "+ s);

        //2naloga

        Drugo.Podjetje p1 = new Drugo.Podjetje("Henkel", 58665765, 6261752000L, true);
        Drugo.Podjetje p2 = new Drugo.Podjetje("Energija Plus", 88157598, 3991008000L, true);
        Drugo.Podjetje p3 = new Drugo.Podjetje("Snaga", 30543517, 5015545000L, true);
        // System.out.println(p1);



        ////////IZPIS RACUNA JE TU!!!!

        Drugo.Racun noviRacun = new Drugo.Racun(randUUIDString,test1,  new Date(), p1,53215465);
        //Drugo.Racun n2 = new Drugo.Racun(randUUIDString,seznam,new Date(),p2);
        System.out.println(noviRacun);

        for (Drugo.Artikel pr : seznam) {
            vsota += pr.getCena() * pr.getKolicina();
            DDVvsota += (vsota * 100) / DDV;
            m = (vsota + DDVvsota) / 1000;

        }



        System.out.println("Skupna cena__: " + vsota + " KONCNA z ddv: " + m); // skupna cena z DDV-jem


        System.out.println("IZPIS CE JE ENUM VELJAVEN: " +t1.checkDigit(t1.getEAN()) +"\n"); // check digit preizkus
        System.out.println("NAJDENO ALI NE" + t1.search("pepsi") ); // search metoda preizkus
        System.out.println("NAJDENO ALI NE  test1:  " + test1.search("kruh beli") ); // search metoda preizkus




        Drugo.Racun noviRacun2 = new Drugo.Racun(randUUIDString,test1,  new Date(), p1,53215465);


        System.out.println("PRIMER IZPISA ARTIKLOV IZ JSONA");
        Drugo.Artikli test2 = new Drugo.Artikli();
        test1.toJson();
        test2.fromJson("C:\\Users\\aleks\\Desktop\\test.json");


        Drugo.Companies comp1 = new Drugo.Companies();
        comp1.dodaj_tab(p1);
        System.out.println("PRIMER IZPISA PODJETJA IZ JSONA");
        comp1.toJson();
        comp1.fromJson("C:\\Users\\aleks\\Desktop\\test_c.json");

        Drugo.Invoices inv1 = new Drugo.Invoices();
        inv1.dodaj_tab(noviRacun);

        System.out.println("PRIMER IZPISA RACUNA IZ JSONA");
        inv1.toJson();
        inv1.fromJson("C:\\Users\\aleks\\Desktop\\test2.json");
*/












      /*  seznam.remove(0);
        seznam.remove(1);
*/


    }


