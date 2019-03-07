
package probandoficheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class fichero {
    
    private File fich = null;
    private PrintWriter f = null;
    Scanner sc;

    public fichero() {
        fich = new File("/home/local/DANIELCASTELAO/igonzaleziglesias/Escritorio/puntuaciones.txt");
    }

    public void añadirPuntuacion(int puntuacion) {
        try {
            f = new PrintWriter(new FileWriter("/home/local/DANIELCASTELAO/igonzaleziglesias/Escritorio/puntuaciones.txt", true));
            Usuario jugador = new Usuario("Nick Name", puntuacion);
            f.println(jugador);
        } catch (IOException ex) {
            System.out.println("error1 " + ex.getMessage());
        } finally {
            f.close();
        }
    }

    public void leerFichero() {
        try {
            sc = new Scanner(fich);
            while (sc.hasNext()) {
                System.out.println(sc.nextLine());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("error2" + ex.getMessage());
        } finally {
            sc.close();
        }
    }
}
