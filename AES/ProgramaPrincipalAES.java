package AES;

public class ProgramaPrincipalAES {
    
    public static void main(String[] args) {
        ProgramaPrincipalAES p = new ProgramaPrincipalAES();
        p.principal();
    }

    public void principal(){
        String missatgeOriginal = "Aquest és un missatge secret.";
        String clau = "1234567890";

        System.out.println("Missatge original: " + missatgeOriginal);
    
        String missatgeAXifrar = ClasseAES.encripta(missatgeOriginal, clau);
        System.out.println("Missatge xifrat amb AES: " + missatgeAXifrar);
    
        String missatgeADesxifrar = ClasseAES.desencripta(missatgeAXifrar, clau);
        System.out.println("Missatge desxifrat amb AES: " + missatgeADesxifrar);
    
    }
}