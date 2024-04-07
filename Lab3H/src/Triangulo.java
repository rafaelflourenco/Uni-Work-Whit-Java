import java.util.Arrays;
/**
 * Classe que extende do Poligono  e forma um Triangulo
 * @author (Rafael Lourenço - 79771)
 * @version (1.0.0 - 25/02/2024)
 */
public class Triangulo extends Poligono{
    private final Ponto[] pontosTriangulo;
    public Triangulo(Ponto[] pontos){
        super(pontos);
        if(!isTriangulo(pontos)){
            System.out.println("Triangulo:vi");
            System.exit(0);
        }
        this.pontosTriangulo = pontos;


    }
    /**
     * @param pontos array de pontos
     * @return true se o conjunto de pontos formar um triangulo, false se não
     */
    public boolean isTriangulo(Ponto[] pontos){
        if(pontos.length != 3) return false;
        if((pontos[0].dist(pontos[1]) + pontos[1].dist(pontos[2])) < pontos[2].dist(pontos[0]) || (pontos[0].dist(pontos[1]) + pontos[2].dist(pontos[0])) < pontos[1].dist(pontos[2]) || (pontos[1].dist(pontos[2]) + pontos[2].dist(pontos[0])) < pontos[0].dist(pontos[1])) return false;
        return true;
    }

    /**
     * @return String formatada do Triangulo
     */
    @Override
    public String toString() {
        return "Triangulo: " + Arrays.toString(pontosTriangulo);
    }

    public Ponto[] getPontosTriangulo() {
        return pontosTriangulo;
    }
}
