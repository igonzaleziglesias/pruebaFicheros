
package probandoficheros;

public class ProbandoFicheros {

    public static void main(String[] args) {
       fichero fich = new fichero();
       fich.añadirPuntuacion(1);
       fich.añadirPuntuacion(4);
       fich.leerFichero();
       fich.primerasCincoPuntuaciones();
    }
    
}
