package nypproje;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;



public class NYPProje {

   public static ArrayList<okul> Okullar=new ArrayList<>();
public static void AnaMenu(){
    Scanner scanner=new Scanner(System.in);
    int secim;
    while(true){
    System.out.println("Lütfen aşağıdaki seçeneklerden birini seçiniz!");
        System.out.println("1- Sistemi Yükle");
        System.out.println("2- Okul Seç");
        System.out.println("3- Okul Ekle");
        System.out.println("4- Sistemi Kaydet");
        System.out.println("5- Çıkış Yap");
        secim=scanner.nextInt();
        
        switch(secim){
        
            case 1:
                SistemiYukle();
                break;
            case 2:
                OkulSec();
                break;
            case 3:
                OkulEkle();
                break;
            case 4:
                SistemiKaydet();
                break;
            case 5:
                return;
            default:
                System.out.println("Lütfen geçerli bir seçim yapınız!");
        
        }
        
    }
    


}
public static void OkulEkle(){

    Scanner scanner =new Scanner(System.in);
    String okul_adi,adres;
    System.out.println("Okul Adı:");
    okul_adi=scanner.nextLine();
    System.out.println("Adresi:");
    adres=scanner.nextLine();
    okul Okul =new okul(okul_adi, adres);
    
    System.out.println("Müdürn Adı");
    String mudur_adi=scanner.nextLine();
    System.out.println("Müdürün Soyadı");
    String mudur_soyadi=scanner.nextLine();
    System.out.println("Müdür SGK ID:");
    String mudur_SGKID=scanner.nextLine();
    mudur Mudur=new mudur(mudur_SGKID, mudur_adi, mudur_soyadi, Okul);
    Okul.setMudur(Mudur);
    Okullar.add(Okul);
    System.out.println("Okul eklendi \n");

}
public static void OkulSec(){
    Scanner scanner =new Scanner(System.in);
    int secim=0;
    int j=0;
    System.out.println("Lütfen okul seçiniz:");
    for(okul i:Okullar){
        j++;
        System.out.println(j+"- Okul Adı:"+i.getOkul_ismi()+" Adresi:"+i.getOkul_adresi());
         
    }
    secim=scanner.nextInt();
    secim--;
    if(Okullar.get(secim)!=null){
           okul secilenOkul=Okullar.get(secim);
           System.out.println(Okullar.get(secim).getMudur().Tanit());
           for(memur i:Okullar.get(secim).getMemurlar()){
               System.out.println(i.Tanit());
           }
           while(true){
           secim=0;  
           System.out.println("Yapmak istediğiniz işlemi seçiniz:");
           System.out.println("1-Öğretmen Ekle");
           System.out.println("2-Sınıf Ekle");
           System.out.println("3-Sınıflar");
           System.out.println("4-Memur Ekle");
           System.out.println("5-Memurlar");
           System.out.println("6-Öğretmenler");
           System.out.println("7-Sınıfa öğretmen atama");
           System.out.println("8-Geri Dön");
           secim=scanner.nextInt();
           scanner=new Scanner(System.in);
           if(secim==1){
               System.out.println("Öğretmenin adı:");
               String ogretmen_adi=scanner.nextLine();
               System.out.println("Öğretmenin Soyadı:");
               String ogretmen_Soyadi=scanner.nextLine();
               System.out.println("Öğretmenin SGK ID'si:");
               String ogretmen_SGKID=scanner.nextLine();
               ogretmen Ogretmen=new ogretmen(ogretmen_SGKID, ogretmen_adi, ogretmen_Soyadi, secilenOkul);
               secilenOkul.Ogretmenler.add(Ogretmen);
           }else if(secim==2){
               System.out.println("Kaçıncı Sınıf:");
               String SinifNumara=scanner.nextLine();
               System.out.println("Sınıf Harfi:");
               String SinifHarf=scanner.nextLine();
               String Sinif_Adi=SinifNumara+"/"+SinifHarf;
               sinif Sinif=new sinif(Sinif_Adi, secilenOkul);
               secilenOkul.Siniflar.add(Sinif);
           }else if(secim==3){
               int z=0;
               System.out.println("SINIFLAR:");
               for(sinif i:secilenOkul.Siniflar){
                   z++;
                   System.out.print(z+"-"+i.getSinif_adi());
                   if(i.getOgretmen()!=null){
                       System.out.println(" Öğretmen:"+i.getOgretmen().getIsim()+" "+i.getOgretmen().getSoyisim());
                   }
                   System.out.println("");
               }// SINIF SEÇİMİ YAPLACAK
               System.out.println("Sınıf Seçiniz:");
               int secilenSinif=scanner.nextInt();
               secilenSinif--;
               if(secilenOkul.Siniflar.size()>secilenSinif){
               sinif SecilenSinif=secilenOkul.Siniflar.get(secilenSinif);
                   SinifSec(SecilenSinif);
               }
           }else if(secim==4){
                System.out.println("Memur adı:");
               String memur_adi=scanner.nextLine();
               System.out.println("Memur Soyadı:");
               String memur_Soyadi=scanner.nextLine();
               System.out.println("Memur SGK ID'si:");
               String memur_SGKID=scanner.nextLine();
               memur Memur=new memur(memur_SGKID, memur_adi, memur_Soyadi, secilenOkul);
               secilenOkul.Memurlar.add(Memur);
           }else if(secim==5){
                System.out.println("MEMURLAR:");
               for(memur i:secilenOkul.Memurlar){
                   System.out.println("id:"+i.getUniqueID()+" "+i.getIsim()+" "+i.getSoyisim());
               }
           }else if(secim==6){
               System.out.println("ÖĞRETMENLER:");
               for(ogretmen i:secilenOkul.Ogretmenler){
                   System.out.println("id:"+i.getUniqueID()+" "+i.getIsim()+" "+i.getSoyisim());
               }
           }else if(secim==7){
               
               System.out.println("Sınıf Seçiniz:");
               int k=0;
               int sinifSecimi=0;
               scanner=new Scanner(System.in);
               for(sinif i:secilenOkul.Siniflar){
                   k++;
                   System.out.println(k+"- "+i.getSinif_adi());                 
               }
               sinifSecimi=scanner.nextInt();
               sinifSecimi--;
               k=0;
               int ogretmenSecimi=0;
               System.out.println("Öğretmen Seçiniz:");
               for(ogretmen i:secilenOkul.Ogretmenler){
                   k++;
                   System.out.println(k+"-"+i.getIsim()+" "+i.getSoyisim());
               }
               ogretmenSecimi=scanner.nextInt();
               ogretmenSecimi--;
               secilenOkul.Siniflar.get(sinifSecimi).Ogretmen=secilenOkul.Ogretmenler.get(ogretmenSecimi);
               secilenOkul.Ogretmenler.get(ogretmenSecimi).Sinif=secilenOkul.Siniflar.get(sinifSecimi);
               
               
           }else if(secim==8){
           break;
           }else{
               System.out.println("Seçtiğiniz işlem geçersiz! Ana menüye yönlendiriliyorsunuz!");
           }
        }
        
    }else{
        System.out.println("Seçtiğiniz okul mevcut değildir.");
    }


}
public static void SinifSec(sinif Sinif){
    Scanner scanner=new Scanner(System.in);
    while(true){
    System.out.println("1-Öğrenci Ekle");
    System.out.println("2-Sınıfı Ziyaret Et");
    System.out.println("3-Geri Dön");
    System.out.println("Yapacağınız işlemi seçiniz");
    int secim=scanner.nextInt();
    scanner=new Scanner(System.in);
       if(secim==1){
            System.out.println("Öğrenci Adı");
            String adi=scanner.nextLine();
            System.out.println("Öğrenci Soyadı");
            String soyadi=scanner.nextLine();
             System.out.println("Öğrenci Numara");
            int numara =scanner.nextInt();
            ogrenci Ogrenci=new ogrenci(numara, adi, soyadi, Sinif.Okul, Sinif);
             Sinif.ogrenciler.add(Ogrenci);
       }else if(secim==2){
           if(Sinif.Ogretmen!=null)
           System.out.println(Sinif.Ogretmen.Tanit());
  
               for(ogrenci i:Sinif.ogrenciler){
                   System.out.println(i.Tanit());
               }
       }else if(secim==3){
       break;
       }else{
       
       
       }
    }

}
public static void SistemiYukle(){  // ' * _ 
 Okullar=new ArrayList<>();
    File dosya = new File("sistem.txt");
if(dosya.exists()) {
            try {
                Scanner result = new Scanner(dosya);
                while(result.hasNextLine()){
                	
                           String[] Parca=result.nextLine().split("'");

    

   
  
     String[] okulBilgileri=Parca[0].split(",");
     String[] uniqueID=okulBilgileri[0].split("=");
     String[] okul_ismi=okulBilgileri[1].split("=");
     String[] okul_adresi=okulBilgileri[2].split("=");
     String[] mudur=okulBilgileri[3].split("_");
     okul Okul=new okul(okul_ismi[1], okul_adresi[1]);
     Okul.setUniqueID(uniqueID[1]);
  

     String[] mudurBilgileri=mudur[1].split(" ");
     String[] mudur_uniqueID=mudurBilgileri[0].split("=");
     String[] mudur_ismi=mudurBilgileri[1].split("=");
     String[] mudur_soyadi=mudurBilgileri[2].split("=");
     String[] mudur_SGKID=mudurBilgileri[3].split("=");
     mudur Mudur =new mudur(mudur_SGKID[1], mudur_ismi[1], mudur_soyadi[1], Okul);
     Mudur.setUniqueID(mudur_uniqueID[1]);
     Okul.setMudur(Mudur);
        // OKUL BİLGİLERİ SONU
        
        // MEMURLAR BAŞI
             String[] MemurBilgileri=Parca[1].split(":");
             for(int i=0;i<MemurBilgileri.length;i++){
                     String[] Bilgiler=MemurBilgileri[1].split(" ");
                     String[] memur_uniqueID=Bilgiler[0].split("=");
                     String[] memur_ismi=Bilgiler[1].split("=");
                     String[] memur_soyadi=Bilgiler[2].split("=");
                     String[] memur_SGKID=Bilgiler[3].split("=");
                     memur Memur =new memur(memur_SGKID[1], mudur_ismi[1], mudur_soyadi[1], Okul);
                     Memur.setUniqueID(memur_uniqueID[1]);
                     Okul.Memurlar.add(Memur);
             }
             
        // ÖĞRETMENLER BAŞI
             String[] OgretmenBilgileri=Parca[2].split(":");
             for(int i=0;i<MemurBilgileri.length;i++){
                     String[] Bilgiler=OgretmenBilgileri[1].split(" ");
                     String[] ogretmen_uniqueID=Bilgiler[0].split("=");
                     String[] ogretmen_ismi=Bilgiler[1].split("=");
                     String[] ogretmen_soyadi=Bilgiler[2].split("=");
                     String[] ogretmen_SGKID=Bilgiler[3].split("=");
                     ogretmen Ogretmen =new ogretmen(ogretmen_SGKID[1], ogretmen_ismi[1], ogretmen_soyadi[1], Okul);
                     Ogretmen.setUniqueID(ogretmen_uniqueID[1]);
                     Okul.Ogretmenler.add(Ogretmen);
             }
             
            // SINIF EKLEME BAŞI
            String[] SinifBilgileri=Parca[3].split(":");
            for(int i=1;i<SinifBilgileri.length;i++){
                
                String[] SinifParca=SinifBilgileri[i].split(";");
                String sinif_uniqueID=SinifParca[0].split("=")[1];
                String sinif_adi=SinifParca[1].split("=")[1];
             
               sinif Sinif=new sinif(sinif_adi, Okul);
               Sinif.setUniqueID(sinif_uniqueID);
               if(SinifParca.length==4){
                   String[] ogrenciler=SinifParca[3].split("_");
                   for(int j=0;j<ogrenciler.length;j++){
                   
             
                       String[] OgrenciParca=ogrenciler[j].split(",");
                       String ogrenci_isim=OgrenciParca[0].split("=")[1];
                       String ogrenci_soyisim=OgrenciParca[1].split("=")[1];
                       int ogrenci_num=Integer.valueOf(OgrenciParca[2].split("=")[1]);
                       ogrenci Ogrenci=new ogrenci(ogrenci_num, ogrenci_isim, ogrenci_soyisim, Okul, Sinif);
                       Sinif.ogrenciler.add(Ogrenci);
                   }
               }
               Okul.Siniflar.add(Sinif);
            }
            
            // SINIF ÖĞRETMEN EŞLEŞTİRME
             
            String[] EslemeBilgileri=Parca[4].split(":")[1].split(",");
            for(int i=0;i<EslemeBilgileri.length;i++){
              
               String[] Eslemeler=EslemeBilgileri[i].split(" ");
        
                  String Sinif_ID=Eslemeler[0];
                  String Ogretmen_ID=Eslemeler[1];
                 
                   sinif Esleme_Sinif=null;
                   ogretmen Esleme_Ogretmen=null;
                   for(sinif z:Okul.Siniflar){
                       
                       if(z.uniqueID.equals(Sinif_ID)){
                   
                            for(ogretmen k:Okul.Ogretmenler){
                                
                               if(k.uniqueID.equals(Ogretmen_ID)){
                                     z.setOgretmen(k);
                                     k.setSinif(z);
                                     }
                               break;
                                 }
                       break;
                       }     
                   }
                  
                
                   
               
            }
            
                 Okullar.add(Okul);
                }
                System.out.println("Başarılı bir şekilde okundu");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(NYPProje.class.getName()).log(Level.SEVERE, null, ex);
            }
} else {
	System.out.println("Dosya yok!");
}
    


}
public static void SistemiKaydet(){
    
    String str = ""; 
    for(okul i:Okullar){
    System.out.println(i.toString());
    str+=i.toString()+"\n";
}
    File file = new File("sistem.txt");

        //if file doesn't exists , then create it
        if (!file.exists())
            try {
                file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }

        try {
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(str);
            bw.close();
            System.out.println("Başarılı bir şekilde eklendi..");
        } catch (Exception e) {
            e.printStackTrace();
        }  

    
    

}
    public static void main(String[] args) {
  
      /*  Okullar.add(new okul("Alparslan İlkokulu","İstanbul"));
        mudur Müdür =new mudur("123456","veli","yılmaz",Okullar.get(0));
        Okullar.get(0).setMudur(Müdür);
        Okullar.get(0).Memurlar.add(new memur("123", "ali", "Yılmaz", Okullar.get(0)));
               Okullar.get(0).Memurlar.add(new memur("123", "ali", "Yılmaz", Okullar.get(0)));
        Okullar.get(0).Ogretmenler.add(new ogretmen("1234", "Aliye", "Yılmaz", Okullar.get(0)));
                Okullar.get(0).Ogretmenler.add(new ogretmen("1234", "Aliye", "Yılmaz", Okullar.get(0)));
        Okullar.get(0).Siniflar.add(new sinif("1/A", Okullar.get(0)));
        Okullar.get(0).Siniflar.get(0).Ogretmen=Okullar.get(0).Ogretmenler.get(0);
        Okullar.get(0).Siniflar.add(new sinif("1/B", Okullar.get(0)));
         Okullar.get(0).Siniflar.get(1).Ogretmen=Okullar.get(0).Ogretmenler.get(0);
        
        
        Okullar.get(0).Siniflar.get(0).ogrenciler.add(new ogrenci(123, "Mehmet", "CanKesen",  Okullar.get(0), Okullar.get(0).Siniflar.get(0)));
         Okullar.get(0).Siniflar.get(0).ogrenciler.add(new ogrenci(123, "Mehmet", "Can Kesen",  Okullar.get(0), Okullar.get(0).Siniflar.get(0)));
       */
        /*sinif Sinif=new sinif("1/A");
        
        ogretmen Ogretmen=new ogretmen("12345", "mehmet","yılmaz",Okul,Sinif);
          System.out.println(Ogretmen.Tanit());
        memur Memur =new memur("123456","ali","yılmaz",Okul);
        System.out.println(Memur.Tanit());
        

        System.out.println(Müdür.Tanit());
        ogrenci Ogrenci=new ogrenci(1234, "Öğrenci Adi","Soyadı",Okul,Sinif);

        System.out.println(Ogrenci.Tanit());*/
       AnaMenu();

        
        


    }
    
}
