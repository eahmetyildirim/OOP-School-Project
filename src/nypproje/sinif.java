
package nypproje;

import java.util.ArrayList;
import java.util.UUID;


public class sinif {
    String uniqueID;
    String sinif_adi;
    okul Okul;
    ogretmen Ogretmen;
    String ResultString;
    ArrayList<ogrenci> ogrenciler=new ArrayList<>();
    public sinif(String sinif_adi,okul Okul) {
        this.sinif_adi = sinif_adi;
        this.Okul=Okul;
        this.uniqueID=UUID.randomUUID().toString();
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public ogretmen getOgretmen() {
        return Ogretmen;
    }

    public void setOgretmen(ogretmen Ogretmen) {
        this.Ogretmen = Ogretmen;
    }
    
    public void setUniqueID(String uniqueID) {
        this.uniqueID = uniqueID;
    }

    public okul getOkul() {
        return Okul;
    }

    public void setOkul(okul Okul) {
        this.Okul = Okul;
    }
    
    public String getSinif_adi() {
        return sinif_adi;
    }

    public void setSinif_adi(String sinif_adi) {
        this.sinif_adi = sinif_adi;
    }

    @Override
    public String toString() {
        ResultString="";
        ResultString+="" + "uniqueID=" + uniqueID + ";sinif_adi=" + sinif_adi  + ";ogrenciler;";
        for(ogrenci i:ogrenciler){
            ResultString+=i.toString();
          
        }  
        ResultString+="";
        
        return ResultString;
    }
    
    
}
