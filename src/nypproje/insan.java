
package nypproje;

import java.util.UUID;


public class insan {
        String uniqueID;
    String isim,soyisim;
    okul Okul ;
    public insan(String isim, String soyisim,okul Okul) {
        this.isim = isim;
        this.soyisim = soyisim;
        this.Okul=Okul;
            this.uniqueID=UUID.randomUUID().toString();
    }

    public String getIsim() {
        return isim;
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(String uniqueID) {
        this.uniqueID = uniqueID;
    }
    
    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSoyisim() {
        return soyisim;
    }

    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }

    public okul getOkul() {
        return Okul;
    }

    public void setOkul(okul Okul) {
        this.Okul = Okul;
    }
    
    public  String Tanit(){
        return "Adım "+isim+" "+soyisim;
    }

    @Override
    public String toString() {
        return "{" + "uniqueID=" + uniqueID + ", isim=" + isim + ", soyisim=" + soyisim + '}';
    }
    
}
