import java.util.ArrayList;
import java.util.Scanner;
import java.math.*;

abstract class GrandPrix {

    abstract ArrayList<String> bilgiGetir();
    public static Takimlar takim=new Takimlar();
    public static TeknikEkip teknik=new TeknikEkip();
    public static Pilotlar pilot=new Pilotlar();
    private static int sans;
    public static int getSans() {
        return sans;
    }

    public static void setSans (int sans1) {
        sans = sans1;
    }
    public static void takimGetir(int takimSirasi){
        int teknikSayac=0;
        int pilotSayac=0;
        for (int i = 0 ; i<takim.bilgiGetir().size(); i++){
            if (i==(takimSirasi-1)){
                System.out.println("----------"+takim.bilgiGetir().get(i)+"----------"+
                        "\nTakım Şefi = "+teknik.bilgiGetir().get(teknikSayac)+
                        "\nTeknik Şef = "+teknik.bilgiGetir().get(teknikSayac+1)+
                        "\nTakım Giriş Yılı = "+teknik.bilgiGetir().get(teknikSayac+2)+
                        "\nTakım Şampiyonluk Sayısı = "+teknik.bilgiGetir().get(teknikSayac+3)+
                        "\n1.Takım Pilotu = "+pilot.bilgiGetir().get(pilotSayac)+
                        "\n1.Takım Pilotu Ülkesi = "+pilot.bilgiGetir().get(pilotSayac+1)+
                        "\n1.Takım Pilotu Şampiyonluk Sayısı = "+pilot.bilgiGetir().get(pilotSayac+2)+
                        "\n1.Takım Pilotu Yarış Sayısı = "+pilot.bilgiGetir().get(pilotSayac+3)+
                        "\n2.Takım Pilotu = "+pilot.bilgiGetir().get(pilotSayac+4)+
                        "\n2.Takım Pilotu Ülkesi = "+pilot.bilgiGetir().get(pilotSayac+5)+
                        "\n2.Takım Pilotu Şampiyonluk Sayısı = "+pilot.bilgiGetir().get(pilotSayac+6)+
                        "\n2.Takım Pilotu Yarış Sayısı = "+pilot.bilgiGetir().get(pilotSayac+7)+
                        "\nArabanın Motor Gücü = 160\nArabanın ERS oranı = 700\n");
            }
            teknikSayac=teknikSayac+4;
            pilotSayac=pilotSayac+8;
        }
    }
    public static void yaris(){
        String siralama []=new String[20];
        Integer puanlama []=new Integer[20];
        int teknikSayac=3;
        int siraSayac=0;
        int geciciPuanlama;
        String geciciSiralama;
        for (int i=0;i<pilot.bilgiGetir().size();i+=4){//burda siralama ve puanları sırayla diziye atadım
            siralama[siraSayac]=pilot.bilgiGetir().get(i);
            setSans((int)(Math.random()*(((Integer.parseInt(pilot.bilgiGetir().get(i+2))*10)+Integer.parseInt(pilot.bilgiGetir().get(i+3))+Integer.parseInt(teknik.bilgiGetir().get(teknikSayac)))/10)));
            puanlama[siraSayac]=getSans();
            siraSayac++;
            if (siraSayac%2==0){
                teknikSayac=teknikSayac+4;
            }
        }
        teknikSayac=0;
        siraSayac=0;
        for (int a = 1; a<=40;a++){//burda 40 tur olacak şekilde puanları üst üste eklettim
            int siraSayaci=0;
            int teknikSayaci=3;
            for(int c = 0;c<pilot.bilgiGetir().size();c+=4){
                setSans((int)(Math.random()*(((Integer.parseInt(pilot.bilgiGetir().get(c+2))*10)+Integer.parseInt(pilot.bilgiGetir().get(c+3))+Integer.parseInt(teknik.bilgiGetir().get(teknikSayaci)))/10)));
                puanlama[siraSayaci]=puanlama[siraSayaci]+getSans();
                siraSayaci++;
                if (siraSayaci%2==0){
                    teknikSayaci=teknikSayaci+4;
                }
            }
            siraSayaci=0;
            teknikSayaci=0;
            for(int b = 0; b < 19; b++)//burda sıralattım
            {
                for(int j = b+1; j < 20; j++)
                {
                    if(puanlama[j] < puanlama[b]) {
                        geciciPuanlama = puanlama[b];
                        puanlama[b] = puanlama[j];
                        puanlama[j] = geciciPuanlama;
                        geciciSiralama = siralama[b];
                        siralama[b] = siralama[j];
                        siralama[j] = geciciSiralama;
                    }
                }
            }
            if (a<11 || a==40) {//10 turu gösterttim
                System.out.println("---------- " + a + ". Tur ----------");
                for (int k = 0; k < siralama.length; k++) {
                    System.out.println((k+1) + ". " + siralama[k]);
                }
            }
            if (a==40){//son turu gösterttim
                int teknikS=0;
                int pilotS=0;
                for (int d = 0;d<3;d++){//burda ise sırayla 3 yarışmacının bilgilerini gösterttim
                    for (int i = 0 ; i<takim.bilgiGetir().size(); i++){
                        if (pilot.bilgiGetir().get(pilotS)==siralama[d]) {
                            System.out.println("---------- {"+(d+1)+"} ----------" +
                                    "\nTakım = " + takim.bilgiGetir().get(i) +
                                    "\nTakım Şefi = " + teknik.bilgiGetir().get(teknikS) +
                                    "\nTeknik Şef = " + teknik.bilgiGetir().get(teknikS + 1) +
                                    "\nTakım Pilotu = " + pilot.bilgiGetir().get(pilotS) +
                                    "\nTakım Pilotu Ülkesi = " + pilot.bilgiGetir().get(pilotS + 1));
                        }
                        else if(pilot.bilgiGetir().get(pilotS+4)==siralama[d]){
                            System.out.println("---------- {"+(d+1)+"} ----------" +
                                    "\nTakım = " + takim.bilgiGetir().get(i) +
                                    "\nTakım Şefi = " + teknik.bilgiGetir().get(teknikS) +
                                    "\nTeknik Şef = " + teknik.bilgiGetir().get(teknikS + 1) +
                                    "\nTakım Pilotu = " + pilot.bilgiGetir().get(pilotS+4) +
                                    "\nTakım Pilotu Ülkesi = " + pilot.bilgiGetir().get(pilotS + 5));
                        }
                        teknikS=teknikS+4;
                        pilotS=pilotS+8;
                    }
                    teknikS=0;
                    pilotS=0;
                }

            }
        }

    }
    public static void arayuz(){
        int secenek=0;
        int takimDetay=0;
        System.out.println("1- Takımları Göster\n2- Yarışı başlat\n\n0- Çıkış");
        Scanner secim=new Scanner(System.in);
        secenek=secim.nextInt();
        if (secenek==1){

            for (int i =0;i<takim.bilgiGetir().size();i++){
                System.out.println((i+1)+" - "+takim.bilgiGetir().get(i));
            }
            System.out.println("\n0 - Çıkış");
            takimDetay=secim.nextInt();
            while (0!=takimDetay){
                takimGetir(takimDetay);
                takimDetay=secim.nextInt();
            }
            arayuz();
        }
        else if (secenek==2){
            yaris();
        }
        else {
            System.exit(0);
        }
    }


    public static void main(String[] args) {
        arayuz();
    }
}