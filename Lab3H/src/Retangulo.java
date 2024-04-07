import java.rmi.server.RemoteRef;
import java.util.Arrays;
/**
 * Classe que extende do Poligono  e forma um Retangulo
 * @author (Rafael Lourenço - 79771)
 * @version (1.0.0 - 25/02/2024)
 */
public class Retangulo extends Poligono {
    private final Ponto[] pontosRetangulo;
    public Retangulo(Ponto[] pontos){
        super(pontos);
        if(!isRetangulo(pontos)){
            System.out.println("Retangulo:vi");
            System.exit(0);
        }
        this.pontosRetangulo = pontos;
    }

    /**
     * @param pontos array de pontos
     * @return true se o conjunto de pontos formar um retangulo, false se não
     */
    public boolean isRetangulo(Ponto[] pontos){
        if(pontos.length != 4){
            return false;
        }
        SegmentoReta[] segmentoRetangulo = new SegmentoReta[4];
        for(int i = 0; i < 4; i++){
            segmentoRetangulo[i] = new SegmentoReta(pontos[i], pontos[(i+1)%4]);
        }

        for(int i = 0; i < 4; i++){
            if(segmentoRetangulo[i].angleBetweenSegments(segmentoRetangulo[(i+1)%4]) != 90){
                return false;
            }
        }

        if(pontos[0].dist(pontos[1]) != pontos[2].dist(pontos[3]) || pontos[1].dist(pontos[2]) != pontos[3].dist(pontos[0])) return false;

        return true;

    }

    /**
     * @return String formatada do Retangulo
     */
    @Override
    public String toString() {
        return "Retangulo: " + Arrays.toString(pontosRetangulo);
    }

    public Ponto[] getPontosRetangulo() {
        return pontosRetangulo;
    }
}
