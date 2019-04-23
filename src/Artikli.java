import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class Artikli implements JsonSupport{

    private ArrayList<Artikel> tabela;

    public Artikli() {
        this.tabela=new ArrayList<>();
    }
    public Artikli(List<Artikel> tabela) {

        this.tabela = new ArrayList<>();

    }
    public void dodaj(Artikel l) {

            tabela.add(l);

    }
    public ArrayList<Artikel> getTabela() {
        return tabela;
    }

    public void setTabela(ArrayList<Artikel> tabela) {
        this.tabela = tabela;
    }

    @Override
    public String toString() {
        return "Artikli: " +
                tabela + "\n"+
                "_________________________________________________________________"+
                '}';
    }

    public boolean search(String n) {

        for(int i=0;i<= tabela.size();i++){

            if(tabela.get(i).getIme().contains(n)){
                return true;

            }

        }


        return false;
    }


    public String toJson() {
        Gson gson = new Gson();
        String json = gson.toJson(this);
       // System.out.println(json);

        //2. Convert object to JSON string and save into a file directly
        Helper.WritetoFile("C:\\Users\\aleks\\Desktop\\test.json",json);

    return json;
    }

    @Override
    public void fromJson(String json) {
        Gson gson = new Gson();

        Artikli obj = gson.fromJson(Helper.ReadFromFile(json), Artikli.class);
        System.out.println(obj);

    }
}
