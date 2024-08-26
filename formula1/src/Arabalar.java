import java.util.ArrayList;

public class Arabalar extends GrandPrix {
    double Motorgucu;
    int ERS_oran;

    @Override
    ArrayList<String> bilgiGetir(){
        ArrayList<String> arabaIsimleri=new ArrayList<>();
        arabaIsimleri.add("700");
        arabaIsimleri.add("160");
        return arabaIsimleri;
    }


}
