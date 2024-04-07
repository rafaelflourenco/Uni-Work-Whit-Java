import java.util.Scanner;
/**
 * Classe usada pelo user para dar input
 * @author (Rafael Lourenço - 79771)
 * @version (1.0.0 - 25/02/2024)
 */
public class Cliente {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Poligono[] poligonos = new Poligono[2];
        Retangulo[] retangulos = new Retangulo[2];
        for(int i = 0; i < 2; i++) {
            int xGrande = Integer.MIN_VALUE;
            int xPequeno = Integer.MAX_VALUE;
            int yGrande = Integer.MIN_VALUE;
            int yPequeno = Integer.MAX_VALUE;
            int verticesPol = scanner.nextInt();
            Ponto[] pontos = new Ponto[verticesPol];
            for (int count = 0; count < verticesPol; count++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                if (x > xGrande) xGrande = x;
                if (x < xPequeno) xPequeno = x;
                if (y > yGrande) yGrande = y;
                if (y < yPequeno) yPequeno = y;
                pontos[count] = new Ponto(x, y);
            }
            retangulos[i] = new Retangulo(xGrande,xPequeno,yGrande,yPequeno,pontos);
        }
        if(retangulos[0].intercptaRetangulo(retangulos[1])){
            poligonos[0] = new Poligono(retangulos[0].getPontosRetangulo(),retangulos[0].getPontosRetangulo().length);
            poligonos[1] = new Poligono(retangulos[1].getPontosRetangulo(),retangulos[1].getPontosRetangulo().length);
        }
        else{
            System.out.println("false");
            System.exit(0);
        }
        if(poligonos[0].Poligonosintersect(poligonos[1])) System.out.println("true");
        else System.out.println("false");
        scanner.close();
    }
}