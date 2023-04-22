/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica18_uf4_pablo;

/**
 *
 * @author Pablo Jiménez
 */
public abstract class Persona {

    private String nom;
    private String dni;
    private String emailPersonal;

    public Persona(String nom, String dni, String emailPersonal) {
        this.nom = nom;
        this.dni = dni;
        this.emailPersonal = emailPersonal;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmailPersonal() {
        return emailPersonal;
    }

    public void setEmailPersonal(String emailPersonal) {
        this.emailPersonal = emailPersonal;
    }
    

}
