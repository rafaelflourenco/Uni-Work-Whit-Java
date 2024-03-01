import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double ax, ay, bx, by;

        ax = scanner.nextDouble();
        ay = scanner.nextDouble();
        bx = scanner.nextDouble();
        by = scanner.nextDouble();

        Ponto a = new Ponto(ax,ay);
        Ponto b = new Ponto(bx,by);

        int distance = (int) a.dist(b);

        System.out.println(distance);
        scanner.close();

    }
}