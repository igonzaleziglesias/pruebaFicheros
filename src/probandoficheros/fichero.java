package probandoficheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class fichero {

    private File fich = null;
    private PrintWriter f = null;
    Scanner sc;

    public fichero() {
//        fich = new File("/home/local/DANIELCASTELAO/igonzaleziglesias/Escritorio/puntuaciones.txt");
        fich = new File("C:\\Users\\Usuario\\Desktop\\puntuaciones.txt");
    }

    public void añadirPuntuacion(int puntuacion) {
        try {
//            f = new PrintWriter(new FileWriter("/home/local/DANIELCASTELAO/igonzaleziglesias/Escritorio/puntuaciones.txt", true));
            f = new PrintWriter(new FileWriter("C:\\Users\\Usuario\\Desktop\\puntuaciones.txt", true));
            Usuario jugador = new Usuario(JOptionPane.showInputDialog("Nick: "), puntuacion);
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
            System.out.println("puntuaciones:");
            while (sc.hasNext()) {
                System.out.println(sc.nextLine());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("error2" + ex.getMessage());
        } finally {
            sc.close();
        }
    }

    public void primerasCincoPuntuaciones() {
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
        try {
            sc = new Scanner(fich);
            System.out.println("puntuaciones:");
            while (sc.hasNextLine()) {
                String[] nicks = sc.nextLine().split(" ");
                Usuario user = new Usuario(nicks[0], (Integer.parseInt(nicks[1])));
                lista.add(user);
            }
            Collections.sort(lista);
            for (Usuario ele : lista) {
                System.out.println(ele);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("");
        } finally {
            sc.close();
        }
    }
}
