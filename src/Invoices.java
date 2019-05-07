import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.ArrayList;
public class Invoices implements JsonSupport {
    private ArrayList<Racun> tabela_invoices;

    public Invoices(List<Racun> tabela_invoices) {

        this.tabela_invoices = new ArrayList<>();

    }
    public void dodaj_tab(Racun g){

        tabela_invoices.add(g);
    }

    public Invoices() {
        this.tabela_invoices=new ArrayList<>();
    }

    public ArrayList<Racun> getTabela() {
        return tabela_invoices;
    }

    public void setTabela(ArrayList<Racun> tabela_companies) {
        this.tabela_invoices = tabela_companies;
    }

    @Override
    public String toString() {
        return "Artikli: " +
                tabela_invoices +"\n"+
                "_________________________________________________________________" +
                '}';
    }

    public boolean search(String n) {

        for (int i = 0; i < tabela_invoices.size(); i++) {

            if (tabela_invoices.get(i).search(n)) {
                return true;
            }
        }


        return false;
    }


    public String  toJson() {
        Gson gson = new Gson();
        String json = gson.toJson(this);
        Helper.WritetoFile("C:\\Users\\aleks\\Desktop\\test2.json",json);
        return json;
    }



    @Override
    public void fromJson(String json) {
        Gson gson = new Gson();
        Invoices obj = gson.fromJson(Helper.ReadFromFile(json), Invoices.class);
        tabela_invoices = obj.tabela_invoices;
    }
}
