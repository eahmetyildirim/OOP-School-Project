
package nypproje;


public class calisan extends insan{
    String SGKID;


    public calisan(String SGK_ID, String isim, String soyisim,okul Okul) {
        super(isim, soyisim,Okul);
        this.SGKID = SGK_ID;
    }

    public String getSGK_ID() {
        return SGKID;
    }

    public void setSGK_ID(String SGK_ID) {
        this.SGKID = SGK_ID;
    }

    @Override
    public String Tanit() {
        return super.Tanit()+","+getOkul().getOkul_ismi()+" okulunda "; 
    }

    @Override
    public String toString() {
        return "{" + "uniqueID=" + uniqueID + " isim=" + isim + " soyisim=" + soyisim + " SGKID=" + SGKID + '}';
    }
    
}
