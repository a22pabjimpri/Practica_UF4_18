/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica18_uf4_pablo;

import java.util.ArrayList;
import utils.Utils;
import UtilsExamenUF3.UtilsExamenUF3;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author Pablo Jiménez
 */
public class Practica18_UF4_Pablo {

    public static ArrayList<Docent> docents = new ArrayList<Docent>();
    public static ArrayList<Personal> personal = new ArrayList<Personal>();
    public static ArrayList<Estudiant> estudiants = new ArrayList<Estudiant>();

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        Persona p = new Persona("Pablo", "46485422L", "Pablo@pablo.com");
        Personal pe = new Personal(2014, "pepe", "4646485o", "pepe@pepe.com");
        Docent d = new Docent("DAM", "Ingenieria Informatica", 2020, "paco@pedralbes", "paco", "46598752M", "paco@paco.com");
        Estudiant e = new Estudiant(2022, "DAM", "maria@pedralbes.com", "Maria", "4623335L", "maria@maria.com");
        
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
                    pe.altaPersonal();
                }
                case 2 -> {
                    d.altaDocent();                
                }
                case 3 -> {
                    e.altaEstudiant();
                }
                case 4 -> {
                    p.enviarMail();
                }
                case 5 -> {
                    p.enviarComunicat();
                }
                case 6 -> {
                    mostrarEstadistiques();
                }
                case 7 -> {
                    p.imprimirEtiquetesNadal();
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

    private static void mostrarEstadistiques() {
        int numPersones = 0;
        int numPersonal = 0;
        int numAlumnes = 0;
        int numDocents = 0;

        for (int i = 0; i < docents.size(); i++) {
            numPersones++;
            numDocents++;
        }
        for (int i = 0; i < personal.size(); i++) {
            numPersones++;
            numPersonal++;
        }
        for (int i = 0; i < estudiants.size(); i++) {
            numPersones++;
            numAlumnes++;
        }

        System.out.println("Hi han " + numPersones + " persones al centre");
        System.out.println(numPersonal + " son de personal");
        System.out.println(numDocents + " son docents");
        System.out.println(numAlumnes + " son alumnes");
    }

   
}