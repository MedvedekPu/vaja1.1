import java.util.ArrayList;
import java.util.List;

public class Artikli {


    private ArrayList<Artikel> tabela;

    public Artikli(List<Artikel> tabela) {

        this.tabela = new ArrayList<>();

    }

    public void dodaj(Artikel l) {

  /*      for(int i=1;i <= tabela.size();i++) {
            if (this.tabela.get(i).compare()) {

               }*/
            tabela.add(l);
//        }

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
                tabela +
                '}';
    }


}
