/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica18_uf4_pablo;

/**
 *
 * @author Pablo Jiménez
 */
public class Estudiant extends Persona {

    private int anyMatricula;
    private String cicle;
    private String emailCentre;

    public Estudiant(int anyMatricula, String cicle, String emailCentre, String nom, String dni, String emailPersonal) {
        super(nom, dni, emailPersonal);
        this.anyMatricula = anyMatricula;
        this.cicle = cicle;
        this.emailCentre = emailCentre;
    }

    public int getAnyMatricula() {
        return anyMatricula;
    }

    public void setAnyMatricula(int anyMatricula) {
        this.anyMatricula = anyMatricula;
    }

    public String getCicle() {
        return cicle;
    }

    public void setCicle(String cicle) {
        this.cicle = cicle;
    }

    public String getEmailCentre() {
        return emailCentre;
    }

    public void setEmailCentre(String emailCentre) {
        this.emailCentre = emailCentre;
    }

    
}
