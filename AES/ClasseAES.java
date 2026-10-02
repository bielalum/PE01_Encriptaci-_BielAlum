package AES;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.crypto.Cipher; //Classe que conté la lògica i les formules per xifrar i desxifrar
import javax.crypto.spec.SecretKeySpec;

public class ClasseAES {
    public static String encripta(String missatge, String clau){
        try{

            //Creo un array de bytes UTF-8 (format amb el que treballa AES) i li assigno l'String clau (clau del missatge a xifrar)
            byte[] clauBytes = clau.getBytes(StandardCharsets.UTF_8);
            
            
            //Preparo els bytes de la clau i indico a Java que són una clau secreta oficial per a AES
            SecretKeySpec clauSecreta = new SecretKeySpec(clauBytes, "AES");

            //Demano a Java la màquina de xifrat configurada amb AES
            Cipher cipher = Cipher.getInstance("AES");
            
            //Inicialitzo el motor en mode xifrat (ENCRYPT_MODE) i li passo la clau
            cipher.init(Cipher.ENCRYPT_MODE, clauSecreta);

            //Converteixo el text del missatge original que vull xifrar a un array format per bytes
            byte[] missatgeBytes = missatge.getBytes(StandardCharsets.UTF_8);
    

            //Executo el xifrat real sobre els bytes del missatge, i retorna un array de bytes ja xifrats
            byte[] bytesXifrats = cipher.doFinal(missatgeBytes);


            //Converteixo els bytes xifrats a un String en format Base64, perquè sigui text llegible i el retorno
            return Base64.getEncoder().encodeToString(bytesXifrats);
        
        }catch(Exception e){
            System.out.println("ERROR: No s'ha pogut encriptar en AES");
            return null;
        }
    }


    public static String desencripta(String missatgeXifrat, String clau){
        try{

            //Creo un array de bytes UTF-8 (format amb el que treballa AES) i li assigno l'String clau (clau del missatge a xifrar)
            byte[] clauBytes = clau.getBytes(StandardCharsets.UTF_8);

            //Agafo l’array de bytes de la clau i el converteixo en un objecte de clau secreta, fent-lo vàlid per AES
            SecretKeySpec clauSecreta = new SecretKeySpec(clauBytes, "AES");

            //Demano a Java la màquina de xifrat configurada amb AES
            Cipher cipher = Cipher.getInstance("AES");

            //Inicialitzo el motor en mode desxifrat (DECRYPT_MODE) i li passo la clau
            cipher.init(Cipher.DECRYPT_MODE, clauSecreta);

            //Desfaig la codificació Base64 del text rebut per recuperar l'array de bytes xifrats original
            byte[] bytesXifrats = Base64.getDecoder().decode(missatgeXifrat);

            //Executo el desxifrat real sobre els bytes xifrats per recuperar els bytes originals
            byte[] bytesDesxifrats = cipher.doFinal(bytesXifrats);

            //Retorno l'array de bytes desxifrats amb un text llegible
            return new String(bytesDesxifrats, StandardCharsets.UTF_8);
        }catch(Exception e){
            System.out.println("ERROR: No s'ha pogut desencriptar en AES");
            return null;
        }
    }
}