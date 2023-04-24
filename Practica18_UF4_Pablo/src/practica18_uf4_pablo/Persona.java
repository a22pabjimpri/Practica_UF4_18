/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica18_uf4_pablo;

import UtilsExamenUF3.UtilsExamenUF3;
import static practica18_uf4_pablo.Practica18_UF4_Pablo.docents;
import static practica18_uf4_pablo.Practica18_UF4_Pablo.estudiants;
import static practica18_uf4_pablo.Practica18_UF4_Pablo.personal;
import static practica18_uf4_pablo.Practica18_UF4_Pablo.scan;
import utils.Utils;

/**
 *
 * @author Pablo Jiménez
 */
public class Persona {

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

    public void enviarMail() {
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
                    cc = alumne.getEmailCentre() + ", " + correuTutor[1] + ", " + correuTutor[0];
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

    public void enviarComunicat() {
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
                    missatge = scan.next();
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

    public void imprimirEtiquetesNadal() {
        boolean encontrado = false;
        String nom = "";
        String adreca = "";
        int antiguitat;

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
                nom = p.getNom();
                antiguitat = p.getAnyInici();
                System.out.print("Introdueix una adreça");
                adreca = scan.next();
                UtilsExamenUF3.ImprimirEtiqueta(nom, antiguitat, adreca);
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
                nom = d.getNom();
                antiguitat = d.getAnyInici();
                System.out.print("Introdueix una adreça");
                adreca = scan.next();
                UtilsExamenUF3.ImprimirEtiqueta(nom, antiguitat, adreca);
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
                    String adrecaTutor[] = ((AlumneMenor) alumne).adrecapostalTutor;
                    if (!adrecaTutor[0].equals(adrecaTutor[1])) {
                        /*Si les adreces entre els dos tutors son diferents, primer enviara la etiqueta
                        al primer tutor y després al segon
                         */
                        nom = alumne.getNom();
                        antiguitat = alumne.getAnyMatricula();
                        adreca = adrecaTutor[0];
                        UtilsExamenUF3.ImprimirEtiqueta(nom, antiguitat, adreca);

                        nom = alumne.getNom();
                        antiguitat = alumne.getAnyMatricula();
                        adreca = adrecaTutor[1];
                        UtilsExamenUF3.ImprimirEtiqueta(nom, antiguitat, adreca);
                    } else {
                        nom = alumne.getNom();
                        antiguitat = alumne.getAnyMatricula();
                        adreca = adrecaTutor[0];
                        UtilsExamenUF3.ImprimirEtiqueta(nom, antiguitat, adreca);
                    }

                } else if (alumne instanceof AlumneMajor) {
                    nom = alumne.getNom();
                    antiguitat = alumne.getAnyMatricula();
                    System.out.print("Introdueix una adreça");
                    adreca = scan.next();
                    UtilsExamenUF3.ImprimirEtiqueta(nom, antiguitat, adreca);
                }

            } else {
                System.out.println("No s'ha trobat cap alumne amb aquest DNI");
            }

        }

    }

}
