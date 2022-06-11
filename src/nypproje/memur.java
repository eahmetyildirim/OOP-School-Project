
package nypproje;

public class memur extends calisan{
    
    public memur(String SGK_ID, String isim, String soyisim,okul Okul) {
        super(SGK_ID, isim, soyisim,Okul);
    }
      @Override
    public String Tanit() {
        return super.Tanit()+" memurum."+"SGK ID'im "+getSGK_ID();
    }
    @Override
    public String toString() {
        return "" + "uniqueID=" + uniqueID + " isim=" + isim + " soyisim=" + soyisim + " SGKID=" + SGKID + ',';
    }
}
