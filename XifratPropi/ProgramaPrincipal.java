package XifratPropi;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ProgramaPrincipal {

    public static void main(String[] args) {
        ProgramaPrincipal p = new ProgramaPrincipal();
        p.principal();
    }

    public void principal(){
        Scanner esc = new Scanner(System.in);


        int opcio = 0;

        do{
            try{
                opcio = menu(esc);

                if (opcio == 1) {
                    xifrar(esc);
                }
                else if (opcio == 2){
                    desxifrar(esc);
                }
                else if (opcio == 3) {
                    System.out.println("\nSortint del programa...");
                }
                else{
                    System.out.println("ERROR: Introdueix un número del 1 al 3");
                }
            }catch(InputMismatchException e){
                System.out.println("ERROR: S'ha d'introduïr un número");
                esc.nextLine();
            }

        } while(opcio != 3);
        
        esc.close();
    }

        public int menu(Scanner esc){
            System.out.println("\n---- SISTEMA D'ENCRIPTACIÓ DDP ----");
            System.out.println("1. Xifrar");
            System.out.println("2. Desxifrar");
            System.out.println("3. Sortir");
            System.out.print("Què vols fer? ");
            int triarAccio = esc.nextInt();
            esc.nextLine();

            return triarAccio;
        }


        public void xifrar(Scanner esc){

            String clau = demanarClau(esc);

            String missatge = demanarMissatge(esc);

            missatge = ClasseCriptografica.encripta(missatge, clau);

            System.out.println("Xifrant missatge...\n");
            System.out.println("Missatge xifrat: " + missatge);

        }

        public void desxifrar(Scanner esc){

            String clau = demanarClau(esc);

            String missatge = demanarMissatge(esc);


            missatge = ClasseCriptografica.desencripta(missatge, clau);

            System.out.println("Desxifrant missatge...\n");
            System.out.println("Missatge desxifrat: " + missatge);

        }


    public String demanarClau(Scanner esc){

        String clau = "";  //La clau és String per poder fer servir el charAt correctament
        boolean clauCorrecte = false;


        do{
            System.out.print("\nIntrodueix la clau (nº de 2 dígits): ");
            clau = esc.nextLine(); 
                
            if (clau.length() == 2) {
                try{
                    Integer.parseInt(clau); //Intenta convertir l'String a número, si no dona error és que només són números (correcte)
                    clauCorrecte = true;
                }catch(NumberFormatException e){
                    System.out.println("ERROR: La clau ha d'estar formada per números");
                }
            }
            else{
                System.out.println("ERROR: La clau ha de tenir 2 dígits");
            }

        }while(clauCorrecte == false);   
        
        return clau;
    }

    public String demanarMissatge(Scanner esc){

        String missatge = "";

        do{
            System.out.print("\nIntrodueix el missatge: ");
            missatge = esc.nextLine();
            
            if (missatge.trim().isEmpty()) {
                System.out.println("ERROR: No has escrit cap missatge");
            }

        }while(missatge.trim().isEmpty());

        return missatge;
    }
}