import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = scanner.nextInt(); // ler o numero de pontos
        Ponto[] pontos = new Ponto[lines];
        double distance = 0;
        for(int i = 0 ; i < lines; i++){  // Criar os pontos consoante o 1 numero introduzido no input (lines)
            double cordenadax = scanner.nextDouble(); // ler as cordenadas do ponto
            double cordenaday = scanner.nextDouble();
            pontos[i] = new Ponto(cordenadax,cordenaday);
        }

        Path caminho = new Path(pontos,lines);



        System.out.println(String.format("%.2f", caminho.distance()));
        scanner.close();

    }
}