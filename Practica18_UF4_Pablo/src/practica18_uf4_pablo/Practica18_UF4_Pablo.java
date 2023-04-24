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

    private static ArrayList<Docent> docents = new ArrayList<>();
    private static ArrayList<Personal> personal = new ArrayList<>();
    private static ArrayList<Estudiant> estudiants = new ArrayList<>();
    public static Scanner scan = new Scanner(System.in);

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
                    altaPersonal();
                }
                case 2 -> {
                    altaDocent();
                }
                case 3 -> {
                    altaEstudiant();
                }
                case 4 -> {
                    enviarMail();
                }
                case 5 -> {
                    enviarComunicat();
                }
                case 6 -> {
                    mostrarEstadistiques();
                }
                case 7 -> {
                    imprimirEtiquetesNadal();
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

    private static void altaPersonal() {
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

    private static void altaDocent() {
        String nom, dni, emailPersonal, emailCentre, especialitat, titulacio;
        int anyInici;

        System.out.print("Nom: ");
        nom = scan.next();

        System.out.println("Dni: ");
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

    private static void altaEstudiant() {
        String nom, dni, emailPersonal, cicle, emailCentre;
        int anyInici, dia, mes, any, anyActual, edat;
        LocalDate dataNaix;

        System.out.print("Nom d'aquest alumne: ");
        nom = scan.next();

        System.out.print("Dni de l'alumne: ");
        dni = scan.next();

        System.out.print("E-mail personal: ");
        emailPersonal = scan.next();

        System.out.print("E-mail del centre del alumne: ");
        emailCentre = scan.next();

        System.out.print("Cicle que cursa l'alumne: ");
        cicle = scan.next();

        anyInici = Utils.LlegirInt("Any de la matricula: ");

        System.out.println("Data de naixement: ");
        any = Utils.LlegirInt("Any: ");
        mes = Utils.LlegirInt("Mes: ");
        dia = Utils.LlegirInt("Dia: ");
        dataNaix = LocalDate.of(any, mes, dia);
        LocalDate dataActual = LocalDate.now();
        anyActual = dataActual.getYear();
        edat = anyActual - any;
        if (edat < 18) {         
            String[] mailTutor = new String[2];
            String[] adrecaTutor = new String[2];

            for (int i = 0; i < mailTutor.length; i++) {
                System.out.print("Correu del tutor " + i + ": ");
                mailTutor[i] = scan.next();
            }
            for (int i = 0; i < adrecaTutor.length; i++) {
                System.out.print("Adreça del tutor " + i + ": ");
                adrecaTutor[i] = scan.next();
            }
            AlumneMenor alumne = new AlumneMenor(dataNaix, anyInici, cicle, emailCentre, nom, dni, emailPersonal, mailTutor, adrecaTutor);
            estudiants.add(alumne);
        } else {
            AlumneMajor alumne = null;
            boolean autoritzacio = false;
            System.out.println("Dona autoritzacio als pares per enviar correu? ");
            int opcio = Utils.LlegirInt("1. Si\n2. No");
            if (opcio == 1) {
                autoritzacio = true;
            }
            alumne = new AlumneMajor(autoritzacio, anyInici, cicle, emailCentre, nom, dni, emailPersonal);
            estudiants.add(alumne);
        }
    }

    private static void enviarMail() {
        boolean encontrado = false;
        String correu = "";
        String cc = "";
        String subject = "";
        String missatge = "";

        System.out.println("Per a qui vols enviar un mail?");
        int opcio = Utils.LlegirInt("1.Personal \n2.Docent \n3.Estudiant\n");

        System.out.print("Quin DNI: ");
        String dni = scan.next();

        if (opcio == 1) {
            Personal p = null;
            for (int i = 0; i < personal.size(); i++) {
                if (personal.get(i).getDni().equals(dni)) {
                    p = personal.get(i);
                    encontrado = true;
                }
            }
            if (encontrado) {
                correu = p.getEmailPersonal();
                cc = "";
                System.out.print("Concepte del mail: ");
                subject = scan.next();

                System.out.print("Missatge del mail: ");
                missatge = scan.next();
                UtilsExamenUF3.EnviarEmail(correu, cc, subject, missatge);
            } else {
                System.out.print("No s'ha trobat cap empleat de personal amb aquest DNI ");
            }

        } else if (opcio == 2) {
            Docent d = null;
            for (int i = 0; i < docents.size(); i++) {
                if (docents.get(i).getDni().equals(dni)) {
                    d = docents.get(i);
                    encontrado = true;
                }
            }
            if (encontrado) {
                correu = d.getEmailCentre();
                cc = d.getEmailPersonal();
                System.out.print("Concepte del mail: ");
                subject = scan.next();

                System.out.print("Missatge del mail: ");
                missatge = scan.next();

                UtilsExamenUF3.EnviarEmail(correu, cc, subject, missatge);
            } else {
                System.out.print("No s'ha trobat cap docent amb aquest DNI ");
            }

        } else {
            Estudiant alumne = null;
            for (int i = 0; i < estudiants.size(); i++) {
                if (estudiants.get(i).getDni().equals(dni)) {
                    if (alumne instanceof AlumneMenor) {
                        alumne = estudiants.get(i);
                    } else {
                        alumne = estudiants.get(i);
                    }
                    encontrado = true;
                }
            }
            if (encontrado) {
                if (alumne instanceof AlumneMenor) {
                    String correuTutor[] = ((AlumneMenor) alumne).correuTutor;
                    correu = alumne.getEmailPersonal();
                    cc = alumne.getEmailCentre() + ", "+ correuTutor[1] + ", " + correuTutor[0];
                    System.out.print("Concepte del mail: ");
                    subject = scan.next();

                    System.out.print("Missatge del mail: ");
                    missatge = scan.next();

                } else if (alumne instanceof AlumneMajor) {
                    boolean autoritzacio = ((AlumneMajor) alumne).isAutoritzacioTutors();
                    if (!autoritzacio) {
                        correu = alumne.getEmailCentre();
                        cc = alumne.getEmailPersonal();
                        System.out.print("Concepte del mail: ");
                        subject = scan.next();

                        System.out.print("Missatge del mail: ");
                        missatge = scan.nextLine();
                    } else {
                        correu = alumne.getEmailPersonal();
                        System.out.print("Introdueix el mail d'un tutor: ");
                        cc = scan.next();
                        System.out.print("Concepte del mail: ");
                        subject = scan.next();
                        System.out.print("Missatge del mail: ");
                        missatge = scan.next();
                    }
                }
                UtilsExamenUF3.EnviarEmail(correu, cc, subject, missatge);
            } else {
                System.out.println("No s'ha trobat cap alumne amb aquest DNI");
            }

        }

    }

    private static void enviarComunicat() {
        String dni = "";
        String correu = "";
        String cc = "";
        String subject = "COMUNICAT";
        String missatge = "";
        boolean encontrado = false;
        System.out.print("DNI de l'alumne: ");
        dni = scan.next();

        Estudiant alumne = null;
        for (int i = 0; i < estudiants.size(); i++) {
            if (estudiants.get(i).getDni().equals(dni)) {
                if (alumne instanceof AlumneMenor) {
                    alumne = estudiants.get(i);
                } else {
                    alumne = estudiants.get(i);
                }
                encontrado = true;
            }
        }

        if (encontrado) {
                if (alumne instanceof AlumneMenor) {
                    String correuTutor[] = ((AlumneMenor) alumne).correuTutor;
                    correu = alumne.getEmailCentre();
                    cc = correuTutor[1] + ", " + correuTutor[0];
                    

                    System.out.print("Missatge del mail: ");
                    missatge = scan.next();

                } else if (alumne instanceof AlumneMajor) {
                    boolean autoritzacio = ((AlumneMajor) alumne).isAutoritzacioTutors();
                    if (!autoritzacio) {
                        correu = alumne.getEmailCentre();
                        cc = alumne.getEmailPersonal();
                        System.out.print("Missatge del mail: ");
                        missatge = scan.nextLine();
                    } else {
                        correu = alumne.getEmailPersonal();
                        System.out.print("Introdueix el mail d'un tutor: ");
                        cc = scan.next();
                        System.out.print("Missatge del mail: ");
                        missatge = scan.next();
                    }
                }
                UtilsExamenUF3.EnviarEmail(correu, cc, subject, missatge);
            } else {
                System.out.println("No s'ha trobat cap alumne amb aquest DNI");
            }
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

    private static void imprimirEtiquetesNadal() {

    }

}
