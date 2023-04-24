/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica18_uf4_pablo;

/**
 *
 * @author Pablo Jiménez
 */
public class AlumneMajor extends Estudiant {
    private boolean autoritzacioTutors;

    public AlumneMajor(boolean autoritzacioTutors, int anyMatricula, String cicle, String emailCentre, String nom, String dni, String emailPersonal) {
        super(anyMatricula, cicle, emailCentre, nom, dni, emailPersonal);
        this.autoritzacioTutors = autoritzacioTutors;
    }

    public boolean isAutoritzacioTutors() {
        return autoritzacioTutors;
    }

    public void setAutoritzacioTutors(boolean autoritzacioTutors) {
        this.autoritzacioTutors = autoritzacioTutors;
    }
    
    
    
}