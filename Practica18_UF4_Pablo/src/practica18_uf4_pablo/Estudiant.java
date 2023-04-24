/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica18_uf4_pablo;

import java.time.LocalDate;

import static practica18_uf4_pablo.Practica18_UF4_Pablo.estudiants;
import static practica18_uf4_pablo.Practica18_UF4_Pablo.scan;
import utils.Utils;

/**
 *
 * @author Pablo Jiménez
 */
public class Estudiant extends Persona {

    final int MAX_TUTORS = 2;
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
    
    public void altaEstudiant() {
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
            String[] mailTutor = new String[MAX_TUTORS];
            String[] adrecaTutor = new String[MAX_TUTORS];

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

    
}