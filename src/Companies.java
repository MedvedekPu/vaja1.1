import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.ArrayList;
public class Companies  implements JsonSupport{

    private ArrayList<Podjetje> tabela_companies;

public void dodaj_tab(Podjetje g){

    tabela_companies.add(g);
}

    public Companies() {
        this.tabela_companies=new ArrayList<>();
    }
    public Companies(List<Podjetje> tabela_companies) {

        this.tabela_companies = new ArrayList<>();

    }
    public ArrayList<Podjetje> getTabela() {
        return tabela_companies;
    }
    public void setTabela(ArrayList<Podjetje> tabela_companies) {
        this.tabela_companies = tabela_companies;
    }


    @Override
    public String toString() {
        return "Artikli: " +
                tabela_companies +
                "\n"+
                "_________________________________________________________________" +
                '}';
    }

    public boolean search(String n) {

        for(int i=0;i<tabela_companies.size();i++){

            if(tabela_companies.get(i).search(n)){
                return true;
            }
        }


        return false;
    }

    @Override
    public void toJson() {
        Gson gson = new Gson();
        String json = gson.toJson(this);
        System.out.println(json);

        //2. Convert object to JSON string and save into a file directly
        try (FileWriter writer = new FileWriter("C:\\Users\\aleks\\Desktop\\test_c.json")) {

            gson.toJson(this, writer);

        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    @Override
    public void fromJson() {
        Gson gson = new Gson();

        try (Reader reader = new FileReader("C:\\Users\\aleks\\Desktop\\test_c.json")) {

            // Convert JSON to Java Object
            Companies obj = gson.fromJson(reader, Companies.class);
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
