import java.awt.*;
import java.lang.reflect.Constructor;
import java.util.Scanner;
/**
 * Classe usada pelo user para dar input
 * @author (Rafael Lourenço - 79771)
 * @version (1.0.0 - 25/02/2024)
 */
public class Cliente {
    public static String capital(String s) {
        if (s == null || s.isEmpty())
            return s;
        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Constructor<?> constructor;
        Class<?> cl;
        Poligono p;
        int countPoligono = 0;
        Poligono[] conjuntoPoligonos = new Poligono[100];
        String s;
        String[] aos;
        while (sc.hasNextLine()) {
            s = sc.nextLine();
            if (s.isEmpty())
                break;
            aos = s.split(" ", 2);
            try {
                cl = Class.forName(capital(aos[0]));
                constructor = cl.getConstructor(Ponto[].class);
                String[] coordinates = aos[1].split(" ");
                Ponto[] pontos= new Ponto[coordinates.length/2];
                int count = aos[0].equals("Poligono") ? 1 : 0;
                for(int i = 0; i < pontos.length; i++){
                    int x = Integer.parseInt(coordinates[count]);
                    int y = Integer.parseInt(coordinates[count+1]);
                    count = count + 2;
                    pontos[i] = new Ponto(x,y);
                }
                p = (Poligono) constructor.newInstance((Object) pontos);
                conjuntoPoligonos[countPoligono] = p;
                countPoligono++;
            }
            catch (ClassNotFoundException cnfe) {
                System.out.println("Não foi encontrada a classe: " + cnfe.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        for(int i = 0; i < countPoligono; i++){
            for(int j = i+1; j < countPoligono; j++) {
                if (conjuntoPoligonos[i].samePoints(conjuntoPoligonos[j])) {
                    System.out.println("Duplicado");
                    System.exit(0);
                }
            }
        }

        for(int i = 0; i < countPoligono; i++){
            String output = conjuntoPoligonos[i].toString();
            System.out.println(output);
        }

        sc.close();
    }

}