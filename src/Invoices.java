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

    @Override
    public void toJson() {
        Gson gson = new Gson();
        String json = gson.toJson(this);
        //System.out.println(json);

        //2. Convert object to JSON string and save into a file directly
        try (FileWriter writer = new FileWriter("C:\\Users\\aleks\\Desktop\\test2.json")) {

            gson.toJson(this, writer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void fromJson() {
        Gson gson = new Gson();

        try (Reader reader = new FileReader("C:\\Users\\aleks\\Desktop\\test2.json")) {

            // Convert JSON to Java Object
            Invoices obj = gson.fromJson(reader, Invoices.class);
            System.out.println(obj);

            // Convert JSON to JsonElement, and later to String
            /*JsonElement json = gson.fromJson(reader, JsonElement.class);
            String jsonInString = gson.toJson(json);
            System.out.println(jsonInString);*/

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
