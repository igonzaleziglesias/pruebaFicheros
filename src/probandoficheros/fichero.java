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
            while (sc.hasNextLine()) {
                String[] nicks = sc.nextLine().split(" ");
                Usuario user = new Usuario(nicks[0], (Integer.parseInt(nicks[1])));
                lista.add(user);
            }
            Collections.sort(lista);
//            for (Usuario ele : lista) {
//                System.out.println(ele);
//            }
//            System.out.println("5 mejores puntuaciones:");
//            for (int i = 0; i < 5; i++) {
//                System.out.println(lista.get(i).getNick()+" "+lista.get(i).getPuntuacion());
//            }
            
            JOptionPane.showMessageDialog(null,"5 mejores puntuaciones:\n"+
                    "-"+lista.get(0).getNick()+" "+lista.get(0).getPuntuacion()+"\n"+
                    "-"+lista.get(1).getNick()+" "+lista.get(1).getPuntuacion()+"\n"+
                    "-"+lista.get(2).getNick()+" "+lista.get(2).getPuntuacion()+"\n"+
                    "-"+lista.get(3).getNick()+" "+lista.get(3).getPuntuacion()+"\n"+
                    "-"+lista.get(4).getNick()+" "+lista.get(4).getPuntuacion()+"\n");
        } catch (FileNotFoundException ex) {
            System.out.println("");
        } finally {
            sc.close();
        }
    }
}
