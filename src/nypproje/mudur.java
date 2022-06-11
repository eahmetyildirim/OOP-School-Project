
package nypproje;

public class mudur extends calisan{
    
    public mudur(String SGK_ID, String isim, String soyisim,okul Okul) {
        super(SGK_ID, isim, soyisim,Okul);
    }
    
      @Override
    public String Tanit() {
        return super.Tanit()+" müdürüm."+"SGK ID'im "+getSGK_ID();
                
    }
    @Override
    public String toString() {
        return "uniqueID=" + uniqueID + " isim=" + isim + " soyisim=" + soyisim + " SGKID=" + SGKID ;
    }
}
