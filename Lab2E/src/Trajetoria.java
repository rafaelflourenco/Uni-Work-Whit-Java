/**
 * Classe que tem como argumento o resultado da trajetória (1 se a reta interceta os osbstáculos, 0 se não)
 * @author (Rafael Lourenço 79771)
 * @version (1.0.0 - 25/02/2024)
 */
public class Trajetoria {
    Ponto[] pontosTrajetoria;
    SegmentoReta[] segmentosTrajetoria;
    Trajetoria(Ponto[] pontos) {
        if(pontos != null) {
            Reta reta =  new Reta(pontos, pontos.length);
            SegmentoReta[] s = new SegmentoReta[pontos.length-1];
            for(int i = 0; i < pontos.length - 1; i++){
                s[i] = new SegmentoReta(reta.getRetas()[i], reta.getRetas()[(i+1)]); // A diferença para o exercicio D é que o ultimo segmento não liga ao ultimo

            }
            this.pontosTrajetoria = pontos;
            this.segmentosTrajetoria = s;
        }
        else{
            System.out.println("ArrayVazio:iv");
            System.exit(0);
        }
    }
    boolean TrajetoriaIntercetPoligono(Poligono[] p){

        for(int i = 0 ; i < p.length; i++) { // for que itera para cada objetos
            for(int pontoIndex = 0; pontoIndex < this.segmentosTrajetoria.length; pontoIndex++){ // for que itera para cada segmento da reta
                for(int poliIndex = 0; poliIndex < p[i].getPoligonos().length; poliIndex++){ // for que itera para cada segmento do obstaculo
                    if(this.segmentosTrajetoria[pontoIndex].intersects(p[i].getSegmentoPol()[poliIndex])){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
