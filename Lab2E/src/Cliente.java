import java.util.Scanner;
/**
 * Classe usada pelo user para dar input
 * @author (Rafael Lourenço - 79771)
 * @version (1.0.0 - 25/02/2024)
 */
public class Cliente {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = scanner.nextInt(); // ler o numero de pontos
        Ponto[] pontos = new Ponto[lines];
        for(int i = 0 ; i < lines; i++){  // Criar os pontos consoante o 1 numero introduzido no input (lines)
            int cordenadax = scanner.nextInt(); // ler as cordenadas do ponto
            int cordenaday = scanner.nextInt();
            pontos[i] = new Ponto(cordenadax,cordenaday);

        }


        int numeroObstaculos = scanner.nextInt();
        Poligono[] poligonosObst = new Poligono[numeroObstaculos];
        for(int i = 0; i < numeroObstaculos; i++)
        {
            int n = scanner.nextInt(); // número de pontos do obstáculo
            Ponto[] pontosObst = new Ponto[n];
            for(int j = 0; j < n; j++){
                int cordenadax = scanner.nextInt(); // ler as cordenadas do ponto
                int cordenaday = scanner.nextInt();
                pontosObst[j] = new Ponto(cordenadax,cordenaday);
            }
            Poligono polObst = new Poligono(pontosObst,n);
            poligonosObst[i] = polObst;

        }
        Trajetoria t = new Trajetoria(pontos);
        if(t.TrajetoriaIntercetPoligono(poligonosObst)) System.out.println(1);
        else System.out.println(0);

        scanner.close();
    }
}