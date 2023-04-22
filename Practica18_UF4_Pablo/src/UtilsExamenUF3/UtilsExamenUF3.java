package UtilsExamenUF3;

import java.time.LocalDate;

public class UtilsExamenUF3 {

    /**
     * Envia un email
     * @param to: Llista d'usuaris a enviar el correu (separats per coma)
     * @param cc: Llista d'usuaris a enviar en còpia (separats per coma)
     * @param subject: Títol del missatge
     * @param message: Contingut del missatge
     */
    public static void EnviarEmail(String to, String cc, String subject, String message)
    {
        System.out.println("Enviant correu a " + to);
        if (cc.equals("")) System.out.println(" amb còpia a: " + cc);

        System.out.println(" - Assumpte: " + subject);
        System.out.println(" - Cos del missatge: " + message);
    }
        
    /**
     * Imprimeix una etiqueta
     * @param nom: Nom de la persona
     * @param anyAntiguitat: Any de primera vinculació amb el centre
     * @param adreca: Adreça de correu postal
     */   
    public static void ImprimirEtiqueta(String nom, int anyAntiguitat, String adreca)
    {
        System.out.println("Imprimint etiqueta per " + nom);
        System.out.println("Gràcies per compartir " + (LocalDate.now().getYear() - anyAntiguitat + 1) + " anys amb nosaltres!!!" );
        System.out.println("Adreça: " + adreca);
        System.out.println("");
    }
}