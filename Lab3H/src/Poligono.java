import java.awt.*;
import java.util.Arrays;

/**
 * Classe que tem como argumentos um array de pontos que formam um poligno.
 * @author (Rafael Lourenço 79771)
 * @version (1.0.0 - 25/02/2024)
 * @inv Poligono:vi quando dois segmentos de reta se intercetam
 */
public class Poligono {

    private final Ponto[] poligonos;
    private final SegmentoReta[] segmentoPol;


    /**
     * Construtor que recebe um array de segmentos de reta e o numero de segmentos do poligno
     * @param p Array de Pontos
     */
    public Poligono(Ponto[] p) {

        if(p.length <= 2 ) {
            System.out.println("Poligono:vi");
            System.exit(0);
        }
        Reta reta =  new Reta(p,p.length);
        SegmentoReta[] s = new SegmentoReta[p.length];
        for(int i = 0; i < p.length; i++){
            s[i] = new SegmentoReta(reta.getRetas()[i], reta.getRetas()[(i+1)%p.length]);
        }

        for(int i = 2; i < p.length; i++){
            if(reta.onSegment(p[i])) // %n serve para os ultimos pontos poderem ligar aos primeiros no fim do fora
            {
                System.out.println("Poligono:vi");
                System.exit(0);
            }
        }

        for (int i = 0; i < p.length; i++) { // Verifica se 1 aresta do poligono se interceta com qualquer outra
            for (int j = i + 1; j < p.length ; j++) {
                if (s[i].intersects(s[j])) {
                    System.out.println("Poligono:vi");
                    System.exit(0);
                }

            }
        }
        this.segmentoPol = s;
        Ponto[] mediano = new Ponto[p.length]; // Array de transição
        int index = 0;
        for (int i = 0; i < p.length - 1; i++) { // Cria os próprios pontos a partir dos segmentos
            if (i == 0) {
                mediano[index] = s[i].getA();
                index++;
                mediano[index] = s[i].getB();
                index++;

            } else {
                mediano[index] = s[i].getB(); // a partir do primeiro segmento basta apenas adicionar o ponto final pois o inicial já foi adiciionado pelo anterior
                if (index != p.length - 1) index++;

            }

        }

        this.poligonos = mediano;
    }


    /**
     * @param p Poligono
     * @return true se os poligonos intercetpam false se não
     */
    public boolean Poligonosintersect(Poligono p){
        for (int pontoIndex = 0; pontoIndex < this.poligonos.length; pontoIndex++) { // for que itera para cada segmento da reta
            for (int poliIndex = 0; poliIndex < p.getPoligonos().length; poliIndex++) { // for que itera para cada segmento do obstaculo
                if (this.getSegmentoPol()[pontoIndex].intersects(p.getSegmentoPol()[poliIndex])) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * @return String formatada do poligono
     */
    public String toString() {
        return "Poligono de " + this.getPoligonos().length+
                " vertices: "
                + Arrays.toString(poligonos);

    }

    /**
     * @param other Poligono
     * @return true se um poligono interceptam com o other poligono, false se não
     */
    public boolean samePoints(Poligono other) {
        if (other == null) {
            return false;
        }
        Ponto[] otherPontos = other.getPoligonos();
        if (poligonos.length != otherPontos.length) {
            return false;
        }
        int mesmosPontos = 0;
        for (int i = 0; i < poligonos.length; i++) {
            for(int j = 0; j < otherPontos.length; j++){
                if (poligonos[i].getX() == otherPontos[j].getX() && poligonos[i].getY() == otherPontos[j].getY()) {
                    mesmosPontos++;
                }
            }
        }
        if(mesmosPontos == poligonos.length) return true;
        return false;
    }

    public Ponto[] getPoligonos() {
        return poligonos;
    }

    public SegmentoReta[] getSegmentoPol() {
        return segmentoPol;
    }

}



/*
Poligono 3 7 1 9 1 9 3
Poligono 3 9 3 7 1 9 1
  */


