
import java.lang.*;

public class Artikel implements Searchable {
    private int Ce;
    private int Cena;
    private int Kolicina;
    private String Ime;
    int[] EAN = new int[13];///= {0,0,0,0,0,0,0,0,0,0,0,0,0};
    private String id;
    private int ddv;
    private String drzava;

    public int[] getEAN() {
        return EAN;
    }

    public void setEAN(int[] EAN) {
        this.EAN = EAN;
    }

    public String getDrzava() {
        return drzava;
    }

    public void setDrzava(String drzava) {

        this.drzava = drzava;

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


    public Artikel(int Cena, String ime, int Kolicina,String id, int[] EAN) {

        this.id=id;
        this.Cena = Cena;
        this.Ime = ime;
        this.Kolicina = Kolicina;
        this.EAN =EAN;

    }

    @Override
    public String toString() {
        return "\n" + "Artikel{" +
                "Cena=" + Cena +
                ", Kolicina=" + Kolicina +
                ", Ime='" + Ime + '\'' + "EAN= "+converrt(EAN) + " " + najdi_d(drzava,EAN) +
                '}';
    }

    public  String converrt(int EAN[]){
    String strArray = new String();
        for(int i=0; i<EAN.length;i++) {
        strArray +=String.valueOf(EAN[i]);

    }
        return strArray;

}

public String najdi_d(String drzava,int[] x){
   if (x[0] == 3 && x[1] == 8 && x[2] == 3) {
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

    else if (x[0] == 3 && x[1] == 8 && x[2] == 5){
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

    @Override
    public boolean search(String n) {
        if (getIme().contains("sok"))
            return true;

        return false;
    }

     public boolean compare(){
        if(this.getIme()== this.getIme()){
            this.setKolicina(1);
        return true;
        }

    return false;
    }


    public  boolean checkDigit(int x[]) {

        int sodo = 0;
        int liho = 0;
        int skupajSUM = 0;
        int checksum_digit = 0;
        int lastItem = x[x.length - 1];

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
        else

            return true;

    }









}

