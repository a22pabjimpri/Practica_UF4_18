/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica18_uf4_pablo;
import java.time.LocalDate;
/**
 *
 * @author Pablo Jiménez
 */
public class AlumneMenor extends Estudiant {

     LocalDate dataNaix;
    //Cada uno tiene un tamaño de 2 ya que es el maximo de tutores
     String correuTutor[] = new String[2];
     String adrecapostalTutor[] = new String[2];

    public AlumneMenor(LocalDate dataNaix, int anyMatricula, String cicle, String emailCentre, String nom, String dni, String emailPersonal, String[] correuTutor, String[] adrecapostalTutor) {
        super(anyMatricula, cicle, emailCentre, nom, dni, emailPersonal);
        this.dataNaix = dataNaix;
        this.correuTutor = correuTutor;
        this.adrecapostalTutor = adrecapostalTutor;
    }

    public LocalDate getDataNaix() {
        return dataNaix;
    }

    public void setDataNaix(LocalDate dataNaix) {
        this.dataNaix = dataNaix;
    }

    public String[] getCorreuTutor() {
        return correuTutor;
    }

    public void setCorreuTutor(String[] correuTutor) {
        this.correuTutor = correuTutor;
    }

    public String[] getAdrecapostalTutor() {
        return adrecapostalTutor;
    }

    public void setAdrecapostalTutor(String[] adrecapostalTutor) {
        this.adrecapostalTutor = adrecapostalTutor;
    }
    
    

}
