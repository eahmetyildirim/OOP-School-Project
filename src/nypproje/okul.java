
package nypproje;

import java.util.ArrayList;
import java.util.UUID;


public class okul {
    String uniqueID;
    String okul_ismi;
    String okul_adresi;
    mudur Mudur;
    ArrayList<memur> Memurlar=new ArrayList<memur>();
    ArrayList<ogretmen> Ogretmenler=new ArrayList<>();
    ArrayList<sinif> Siniflar =new ArrayList<>();
    String ResultString;
    public okul(String okul_ismi, String okul_adresi) {
        this.okul_ismi = okul_ismi;
        this.okul_adresi = okul_adresi;
        this.uniqueID=UUID.randomUUID().toString();
    }

    public String getUniqueID() {
        return uniqueID;
    }
     
    public void setUniqueID(String uniqueID) {
        this.uniqueID = uniqueID;
    }

    public String getOkul_ismi() {
        return okul_ismi;
    }

    public void setOkul_ismi(String okul_ismi) {
        this.okul_ismi = okul_ismi;
    }

    public String getOkul_adresi() {
        return okul_adresi;
    }

    public void setOkul_adresi(String okul_adresi) {
        this.okul_adresi = okul_adresi;
    }

    public mudur getMudur() {
        return Mudur;
    }

    public void setMudur(mudur Mudur) {
        this.Mudur = Mudur;
    }

    public ArrayList<memur> getMemurlar() {
        return Memurlar;
    }

    public void setMemurlar(ArrayList<memur> Memurlar) {
        this.Memurlar = Memurlar;
    }

    public ArrayList<ogretmen> getOgretmenler() {
        return Ogretmenler;
    }

    public void setOgretmenler(ArrayList<ogretmen> Ogretmenler) {
        this.Ogretmenler = Ogretmenler;
    }
    public String SistemKaydet(){
    ResultString="";
            ResultString= "uniqueID=" + uniqueID + ", okul_ismi=" + okul_ismi + ", okul_adresi=" + okul_adresi + ", Mudur_" + Mudur.toString();
            //+ ", Memurlar=" + Memurlar + ", Ogretmenler=" + Ogretmenler + ", Siniflar=" + Siniflar + '}';
            ResultString+="'Memurlar:";
            for(memur i:Memurlar){
                ResultString+=i.toString();
            }

             ResultString+="'Ogretmenler:";
            for(ogretmen i:Ogretmenler){
                ResultString+=i.toString()+",";
            }
 
             ResultString+="'Siniflar:";
            for(sinif i:Siniflar){
                ResultString+=i.toString()+":";
            }

            // SINIFLARA ÖĞRETMEN ATAMA
                 ResultString+="'Sinif_Ogretmen:";
                for(sinif i:Siniflar){
                    if(i.Ogretmen!=null)
                    ResultString+=i.uniqueID+" "+i.Ogretmen.uniqueID+",";
                }

            

    
    return ResultString;
    }
    @Override
    public String toString() {
        return SistemKaydet();
    }
    
}   
