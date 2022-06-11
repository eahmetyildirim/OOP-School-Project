
package nypproje;


public class ogretmen extends calisan{
    sinif Sinif;

    public ogretmen(String SGK_ID, String isim, String soyisim, okul Okul) {
        super(SGK_ID, isim, soyisim, Okul);
    }
    
    public ogretmen(String SGK_ID, String isim, String soyisim,okul Okul,sinif Sinif) {
        super(SGK_ID, isim, soyisim,Okul);
        this.Sinif=Sinif;
    }
   

    public sinif getSinif() {
        return Sinif;
    }

    public void setSinif(sinif Sinif) {
        this.Sinif = Sinif;
    }

    @Override
    public String Tanit() {
        return super.Tanit()+" öğretmenim."+"SGK ID'im "+getSGK_ID()+"."+getSinif().getSinif_adi()+" sınıf öğretmeniyim."; //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public String toString() {
        return "" + "uniqueID=" + uniqueID + " isim=" + isim + " soyisim=" + soyisim + " SGKID=" + SGKID;
    }
}
