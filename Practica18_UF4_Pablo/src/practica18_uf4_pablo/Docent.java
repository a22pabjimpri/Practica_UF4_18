/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica18_uf4_pablo;

import static practica18_uf4_pablo.Practica18_UF4_Pablo.docents;
import static practica18_uf4_pablo.Practica18_UF4_Pablo.scan;
import utils.Utils;

/**
 *
 * @author Pablo Jiménez
 */
public class Docent extends Persona {

    private String especialitat;
    private String titulacio;
    private int anyInici;
    private String emailCentre;

    public Docent(String especialitat, String titulacio, int anyInici, String emailCentre, String nom, String dni, String emailPersonal) {
        super(nom, dni, emailPersonal);
        this.especialitat = especialitat;
        this.titulacio = titulacio;
        this.anyInici = anyInici;
        this.emailCentre = emailCentre;
    }

    public String getEspecialitat() {
        return especialitat;
    }

    public void setEspecialitat(String especialitat) {
        this.especialitat = especialitat;
    }

    public String getTitulacio() {
        return titulacio;
    }

    public void setTitulacio(String titulacio) {
        this.titulacio = titulacio;
    }

    public int getAnyInici() {
        return anyInici;
    }

    public void setAnyInici(int anyInici) {
        this.anyInici = anyInici;
    }

    public String getEmailCentre() {
        return emailCentre;
    }

    public void setEmailCentre(String emailCentre) {
        this.emailCentre = emailCentre;
    }
    
    public void altaDocent() {
        String nom, dni, emailPersonal, emailCentre, especialitat, titulacio;
        int anyInici;

        System.out.print("Nom: ");
        nom = scan.next();

        System.out.print("Dni: ");
        dni = scan.next();

        System.out.print("E-mail personal: ");
        emailPersonal = scan.next();

        System.out.print("Especialitat del docent: ");
        especialitat = scan.next();

        System.out.print("Titulacio del docent: ");
        titulacio = scan.next();

        System.out.print("E-mail del centre: ");
        emailCentre = scan.next();

        anyInici = Utils.LlegirInt("Any d'inici: ");

        Docent d = new Docent(especialitat, titulacio, anyInici, emailCentre, nom, dni, emailPersonal);
        docents.add(d);
    }
    
    
}