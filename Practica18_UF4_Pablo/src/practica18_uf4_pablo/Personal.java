/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica18_uf4_pablo;

import static practica18_uf4_pablo.Practica18_UF4_Pablo.personal;
import static practica18_uf4_pablo.Practica18_UF4_Pablo.scan;
import utils.Utils;

/**
 *
 * @author Pablo Jiménez
 */
public class Personal extends Persona {


    private int anyInici;

    public Personal(int anyInici, String nom, String dni, String emailPersonal) {
        super(nom, dni, emailPersonal);
        this.anyInici = anyInici;
    }

    public int getAnyInici() {
        return anyInici;
    }

    public void setAnyInici(int anyInici) {
        this.anyInici = anyInici;
    }
    
    public void altaPersonal() {
        String nom, dni, emailPersonal;
        int anyInici;

        System.out.print("Nom d'aquest empleat: ");
        nom = scan.nextLine();

        System.out.print("Dni de l'empleat: ");
        dni = scan.next();

        System.out.print("E-mail personal: ");
        emailPersonal = scan.next();

        anyInici = Utils.LlegirInt("Any d'inici: ");

        Personal p = new Personal(anyInici, nom, dni, emailPersonal);
        personal.add(p);

    }

    

}