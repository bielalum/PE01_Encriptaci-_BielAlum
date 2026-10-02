package XifratPropi;
public class ClasseCriptografica {

                                //String missatge: Frase sencera a xifrar
    public static String encripta(String missatge, String clau){

        //Declaro les variables per a cada dígit de la clau i els hi assigno una posició
        int digit1 = Character.getNumericValue(clau.charAt(0));
        int digit2 = Character.getNumericValue(clau.charAt(1));


        int posicioLletra = 1; //Comptador per saber en quina posició estan les lletres
        String resultat = "";
        boolean esLletra = true;

        //Bucle for per recórrer cada caràcter del missatge
        for(int i = 0; i < missatge.length(); i++){

            //Creo un char per a la lletra i li assigno el número corresponent a la posició en el missatge
            char lletraOriginal = missatge.charAt(i);  //H -> 1


            //Abans de tot, comprovem si el caràcter és una lletra o no, i ho diem al boolean
            if (Character.isLetter(lletraOriginal)) {
                esLletra = true;

                int digitClau;


                //Si la posició de la lletra és imparella, li assignem el dígit 1, si és parella el dígit 2

                //Si el residu de dividir entre 2 no és 0...
                if (posicioLletra % 2 != 0) {
                    digitClau = digit1;
                }
                else{
                    digitClau = digit2;
                }


                //Creo un char per assignar la primera lletra de l'abecedari en majúscula o en minúscula (A o a), en funció de si la lletra del missatge a xifrar és majúscula o minúscula
                char lletraInicialAbecedari;
                
                if (Character.isUpperCase(lletraOriginal)){
                    
                    lletraInicialAbecedari = 'A';
                }
                else{
                    lletraInicialAbecedari = 'a';
                }
                
                //Això ens servirà per saber la posició de la lletra en l'abecedari. Restarem el codi ASCII d'aquesta lletra (canvia si és H (72) o h (104)) a la posició ASCII de la A (65) o la a (97)


                //XIFRAT:

                //Creo un nou int al qual se li assignarà la posició de la lletra (resultat de restar els codis ASCII de la lletra original amb l'inici de l'abecedari A/a, així obtindrem una posició de 0 a 25 en l'abecedari)
                int posicioOriginalLletra = lletraOriginal - lletraInicialAbecedari;


                int posicionsADesplacar = digitClau + posicioLletra;


                //Ara que tenim la posició tenim que desplaçar-la a la dreta un número X de posicions 
                int posicioLletraXifrada = (posicioOriginalLletra + posicionsADesplacar) % 26; //El %26 és perquè torni a començar si en desplaçar s'acaba l'abecedari


                //Ara sabem la posició final en la qual està la lletra xifrada, ara cal passar-la a codi ASCII
                int posicioASCIIFinal = lletraInicialAbecedari + posicioLletraXifrada;


                //Finalment transformem el codi ASCII a la lletra xifrada corresponent
                char lletraXifrada = (char) posicioASCIIFinal;




                //El resultat és el que ja portem xifrat + la nova lletra, així tindrem el missatge SENCER lletra per lletra
                resultat = resultat + lletraXifrada;



                //Sumem un per passar a la següent posició
                posicioLletra++;


            }
            else{
                //Si no és una lletra, no ho xifrem i ho posem al final de resultat
                resultat = resultat + lletraOriginal;
                esLletra = false;
            }

        }


        //Una vegada acaba el bucle for i s'han recorregut/xifrat totes les lletres retornem el missatge final sencer
        return resultat;

    }
        
    public static String desencripta(String missatge, String clau){

        //Declaro les variables per a cada dígit de la clau i els assigno una posició
        int digit1 = Character.getNumericValue(clau.charAt(0));
        int digit2 = Character.getNumericValue(clau.charAt(1));


        int posicioLletra = 1; //Comptador per saber en quina posició estan les lletres
        String resultat = "";
        boolean esLletra = true;

        for(int i = 0; i < missatge.length(); i++){

            //Creo un char per a la lletra xifrada i li assigno el número corresponent a la posició en el missatge
            char lletraXifrada = missatge.charAt(i);  //H -> 1


            //Comprovem si el caràcter és una lletra o no, i ho diem al boolean
            if (Character.isLetter(lletraXifrada)) {
                esLletra = true;

                int digitClau;


                //Si la posició de la lletra és imparella, li assignem el dígit 1, si és parella el dígit 2

                //Si el residu de dividir entre 2 no és 0...
                if (posicioLletra % 2 != 0) {
                    digitClau = digit1;
                }
                else{
                    digitClau = digit2;
                }


                //Cream un char per assignar la primera lletra de l'abecedari en majúscula o en minúscula (A o a), en funció de si la lletra del missatge a xifrar és majúscula o minúscula
                char lletraInicialAbecedari;
                
                if (Character.isUpperCase(lletraXifrada)){
                    
                    lletraInicialAbecedari = 'A';
                }
                else{
                    lletraInicialAbecedari = 'a';
                }
                
                //Això ens servirà per saber la posició de la lletra en l'abecedari. Restarem el codi ASCII d'aquesta lletra (canvia si és H (72) o h (104)) a la posició ASCII de la A (65) o la a (97)


                //DESXIFRAT:

                //Creo un nou int al qual se li assignarà la posició de la lletra (resultat de restar els codis ASCII de la lletra original amb l'inici de l'abecedari A/a, així obtindrem una posició de 0 a 25 en l'abecedari)
                int posicioLletraXifrada = lletraXifrada - lletraInicialAbecedari;


                int posicionsADesplacar = digitClau + posicioLletra;


                //Ara que tenim la posició tenim que desplaçar-la a l'esquerra un número X de posicions, per això ara restem en comptes de sumar
                int posicioOriginalLletra = (posicioLletraXifrada - posicionsADesplacar) % 26; //El %26 és perquè torni a començar si en desplaçar s'acaba l'abecedari


                //Si el resultat dona negatiu, li sumem 26 perquè doni la volta a l'abecedari
                if (posicioOriginalLletra < 0) {
                    posicioOriginalLletra = posicioOriginalLletra + 26;
                }




                //Ara sabem la posició final en la qual està la lletra desxifrada, ara cal passar-la a codi ASCII
                int posicioASCIIFinal = lletraInicialAbecedari + posicioOriginalLletra;


                //Finalment transformem el codi ASCII a la lletra xifrada corresponent
                char lletraDesxifrada = (char) posicioASCIIFinal;



                //El resultat és el que ja portem desxifrat + la nova lletra, així tindrem el missatge SENCER lletra per lletra
                resultat = resultat + lletraDesxifrada;


                //Sumem un per passar a la següent posició
                posicioLletra++;


            }
            else{
                //Si no és una lletra, no ho xifrem i ho posem al final de resultat
                resultat = resultat + lletraXifrada;
                esLletra = false;
            }

        }


        //Una vegada acaba el bucle for i s'han recorregut/xifrat totes les lletres retornem el missatge final sencer
        return resultat;

    }   
}