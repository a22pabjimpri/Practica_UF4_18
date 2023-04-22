/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica18_uf4_pablo;

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

    

}
