/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica18_uf4_pablo;

import java.util.ArrayList;
import utils.Utils;

/**
 *
 * @author Pablo Jiménez
 */
public class Practica18_UF4_Pablo {

    private static ArrayList<Docent> docents = new ArrayList<Docent>();
    private static ArrayList<Personal> personal = new ArrayList<Personal>();
    private static ArrayList<Estudiant> estudiants = new ArrayList<Estudiant>();

    public static void main(String[] args) {

        boolean sortir = false;

        do {
            System.out.println("""
                               1. Alta de Personal
                               2. Alta de Docents
                               3. Alta d'Estudiants
                               4. Enviar Email
                               5. Enviar Comunicat
                               6. Mostrar Estadistiques
                               7. Imprimir Etiquetes Nadal
                               8. Sortir""");

            int opcio = Utils.LlegirInt("Selecciona una opcio: ");

            switch (opcio) {
                case 1 -> {

                }
                case 2 -> {

                }
                case 3 -> {

                }
                case 4 -> {

                }
                case 5 -> {

                }
                case 6 -> {

                }
                case 7 -> {

                }
                case 8 -> {
                    sortir = true;
                }
                default -> {
                    System.out.println("Opcio no valida");
                }

            }

        } while (!sortir);
    }

}
