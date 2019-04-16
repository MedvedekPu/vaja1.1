
import java.lang.*;

public class Artikel implements Searchable {
    private int Cena;
    private int teza;
    private String oddelek;
    private int Kolicina;
    private String Ime;
    long[] EAN;// = new int[13];///= {0,0,0,0,0,0,0,0,0,0,0,0,0};
    private String id;
    private int ddv;
    private String drzava;


    public int getTeza() {
        return teza;
    }

    public void setTeza(int teza) {
        this.teza = teza;
    }

    public long[] getEAN() {
        return EAN;
    }

    public void setEAN(long[] EAN) {
        this.EAN = EAN;
    }

    public String getDrzava() {
        return drzava;
    }

    public void setDrzava(String drzava) {

        this.drzava = drzava;

    }

    public String getOddelek() {
        return oddelek;
    }

    public void setOddelek(String oddelek) {
        this.oddelek = oddelek;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public int getKolicina() {
        return Kolicina;
    }

    public void setKolicina(int Kolicina) {
        Kolicina = Kolicina;
    }


    public Artikel(int Cena, String ime, int Kolicina,String id, long[] EAN, int teza) {

        this.id=id;
        this.Cena = Cena;
        this.Ime = ime;
        this.Kolicina = Kolicina;
        this.EAN =EAN;

        this.teza=teza;

    }

    @Override
    public String toString() {
        return "\n" + "Artikel{" +
                "Cena=" + Cena +
                ", Kolicina=" + Kolicina +
                ", Ime='" + Ime + '\'' + "EAN= "+converrt(EAN) + " " + najdi_d(drzava,EAN)  +" "+ pregled_teze(EAN) +"g"+
                '}';
    }

    public  String converrt(long EAN[]){
       posodobljen(EAN);
    String strArray = new String();
        for(int i=0; i<EAN.length;i++) {
        strArray +=String.valueOf(EAN[i]);

    }
        return strArray;

}


public  long[] posodobljen(long [] x ){
        if(teza!=0) {
            long tmp1 = 0;
            tmp1 = teza;
            long[] tt = new long[4];

                tt[0]= teza / 1000;
                teza = teza % 1000;
                tt[1] = teza /100;
                teza = teza % 100;
                tt[2] = teza /10;
                teza = teza %10;
                tt[3] = teza;

            x[8] = tt[0];
            x[9] = tt[1];
            x[10] = tt[2];
            x[11] = tt[3];
        }else {
            return x;
        }
    return x;
}


public int pregled_teze(long[] x){

     // if(teza==0) {
          long tmp = 0;
          tmp = x[8] * 1000;
          teza = (int) tmp;
          tmp = x[9] * 100;
          teza += tmp;
          tmp = x[10] * 10;
          teza += tmp;
          tmp = x[11] * 1;
          teza += tmp;

    return teza;
}
public int vrni_tezo(){
    int t=0;
        long[] x= new long[13];
            t = pregled_teze(x);
        return  t;
}


public String najdi_d(String drzava,long[] x){

    if (x[0] == 2 && x[1] == 1 && x[2] == 1) {
        drzava="oddelek Sadja";

    }
    else if(x[0] == 2 && x[1] == 2 && x[2] == 1){
        drzava = "oddelek mesa";
    }
    else if(x[0] == 2 && x[1] == 3 && x[2] == 1){
        drzava ="oddelek kruha";
    }
    else if(x[0] == 2 && x[3] == 1 && x[1] == 1){
        drzava ="Oddelek zelenjave";
    }

   else if (x[0] == 3 && x[1] == 8 && x[2] == 3) {
           drzava="Slovenija";
        }
   else  if (x[0] == 3 && x[1] == 8 && x[2] == 0) {
        drzava="bulgarija";
    }

   else if (x[0] == 3 && x[1] == 0 ){
        drzava="Francija";
    }
   else if (x[0] == 3 && x[1] == 8 && x[2] == 5){
        drzava="Hrvaska";
    }
    else if (x[0] == 3 && x[1] == 8 && x[2] == 7){
        drzava="Montenegro";
    }
    else if (x[0] == 4 && x[1] == 0){
        drzava="Nemcija";
    }
    else if (x[0] == 4 && x[1] == 6){
        drzava="Rusija";
    }

    else if (x[0] == 4 && x[1] == 7 && x[2] == 4){
        drzava="Estonija";
    }

    else if (x[0] == 4 && x[1] == 7 && x[2] == 5){
        drzava="Latvija";
    }

    else if (x[0] == 4 && x[1] == 7 && x[2] == 7){
        drzava="Litva";
    }

    else if (x[0] == 4 && x[1] == 8 && x[2] == 1){
        drzava="Belorusija";
    }

    else if (x[0] == 4 && x[1] == 8 && x[2] == 2){
        drzava="Ukrajina";
    }

    else if (x[0] == 5 && x[1] == 0){
        drzava="UK";
    }

    else if (x[0] == 5 && x[1] == 2 && x[2] == 0){
        drzava="Grcija";
    }

    else if (x[0] == 5 && x[1] == 2 && x[2] == 9){
        drzava="Ciper";
    }

    else if (x[0] == 5 && x[1] == 3 && x[2] == 5){
        drzava="Malta";
    }

    else if (x[0] == 5 && x[1] == 3 && x[2] == 0){
        drzava="Albanija";
    }

    else if (x[0] == 5 && x[1] == 3 && x[2] == 1){
        drzava="Makedonija";
    }

    else if (x[0] == 5 && x[1] == 8 && x[2] == 5){
        drzava="Irska";
    }
    else if (x[0] == 5 && x[1] == 4 ){
        drzava="Belgija in Luxemburg";
    }
    else if (x[0] == 5 && x[1] == 6 && x[2] == 0){
        drzava="Portugalska";
    }
    else if (x[0] == 5 && x[1] == 6 && x[2] == 9){
        drzava="Islandija";
    }
    else if (x[0] == 5 && x[1] == 7 && x[2] == 0){
        drzava="Danska";
    }
    else if (x[0] == 5 && x[1] == 9 && x[2] == 0){
        drzava="Poljska";
    }
    else if (x[0] == 5 && x[1] == 9 && x[2] == 4){
        drzava="Romunija";
    }
    else if (x[0] == 5 && x[1] == 9 && x[2] == 9){
        drzava="Madzarska";
    }
    else if (x[0] == 6 && x[1] == 4){
        drzava="Finska";
    }
    else if (x[0] == 7 && x[1] == 0){
        drzava="Norveska";
    }
    else if (x[0] == 7 && x[1] == 3){
        drzava="Svedska";
    }
    else if (x[0] == 7 && x[1] == 6){
        drzava="Svica in Lihnstajn";
    }
    else if (x[0] == 8 && x[1] == 0){
        drzava="Italija";
    }
    else if (x[0] == 8 && x[1] == 4){
        drzava="Spanija";
    }
    else if (x[0] == 8 && x[1] == 5 && x[2] == 8){
        drzava="Slovaska";
    }
    else if (x[0] == 8 && x[1] == 5 && x[2] == 9){
        drzava="Ceska";
    }
    else if (x[0] == 8 && x[1] == 6 && x[2] == 0){
        drzava="Srbija";
    }
    else if (x[0] == 8 && x[1] == 6 && x[2] == 8||x[2] == 9){
        drzava="Turcija";
    }
    else if (x[0] == 8 && x[1] == 7){
        drzava="Nizozemska";
    }
    else if (x[0] == 9 && x[1] == 0 ||x[1] == 1  ){
        drzava="Austrija";
    }

    return  drzava;

}


    public boolean search(String n) {
        if (Ime.contains(n) || drzava.contains(n) || String.valueOf(Cena).contains(n) || String.valueOf(EAN).contains(n) || String.valueOf(Kolicina).contains(n)) {
                return true;

            }

        return false;




    }




    public  boolean checkDigit(long x[]) {

        int sodo = 0;
        int liho = 0;
        int skupajSUM = 0;
        int checksum_digit = 0;
        long lastItem = x[x.length - 1];


        for (int i = 0; i <= x.length - 1; i++) {

            if (i % 2 == 0)//sodo
            {

                liho += x[i];// * 3; korak 1
            } else {
                sodo += x[i];// * 1; // korak 3
            }

        }
        //korak 2
        sodo=sodo*3;
      /*  System.out.println(sodo);
        System.out.println(liho);*/
        skupajSUM = sodo + liho; //korak4
        checksum_digit = 10 - (skupajSUM % 10); // korak 5

        System.out.println(checksum_digit);
        if (checksum_digit == 10) {
            checksum_digit = 0;
        }
        if (checksum_digit == lastItem)
            return false;
        else{

            return true;}

    }









}

