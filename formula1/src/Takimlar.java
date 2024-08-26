import java.sql.SQLOutput;
import java.util.ArrayList;

public class Takimlar extends GrandPrix{
    @Override
    ArrayList<String> bilgiGetir(){
        ArrayList<String> takimIsimleri=new ArrayList<>();
        takimIsimleri.add("Ferrari");
        takimIsimleri.add("AstonMartin");
        takimIsimleri.add("AlfaRomeo");
        takimIsimleri.add("Redbull");
        takimIsimleri.add("Mercedes");
        takimIsimleri.add("Alpine");
        takimIsimleri.add("McLaren");
        takimIsimleri.add("Haasf1team");
        takimIsimleri.add("AlphaTauri");
        takimIsimleri.add("Williams");
        return takimIsimleri;
    }
}
