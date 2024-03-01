import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Ponto a = new Ponto();
        Ponto b = new Ponto();

        a.x = scanner.nextDouble();
        a.y = scanner.nextDouble();
        b.x = scanner.nextDouble();
        b.y = scanner.nextDouble();

        int distance = (int) a.dist(b);

        System.out.println(distance);
        scanner.close();

    }
}