
package nypproje;


public class ogrenci extends insan{
    sinif Sinif;
    int numara ;

    public ogrenci(int numara, String isim, String soyisim,okul Okul,sinif Sinif) {
        super(isim, soyisim,Okul);
        this.numara = numara;
        this.Sinif=Sinif;
    }
    
    public sinif getSinif() {
        return Sinif;
    }

    public void setSinif(sinif Sinif) {
        this.Sinif = Sinif;
    }

    public int getNumara() {
        return numara;
    }

    public void setNumara(int numara) {
        this.numara = numara;
    }
    
      @Override
    public String Tanit() {
        return super.Tanit()+" "+getOkul().getOkul_ismi()+" okulunda öğrenciyim."+getSinif().getSinif_adi()+" sınıfındayım.Numaram "+getNumara();
    }

    @Override
    public String toString() {
        return "isim=" + isim + ",soyisim=" + soyisim + ",numara=" + numara + "_";
    }
    
}
