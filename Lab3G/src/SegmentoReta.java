import java.awt.*;

/**
 * Classe que tem como argumentos 2 pontos, tem um método boolean que verifica se 2 segmentos de reta se intercetam
 * @author (Rafael Lourenço)
 * @version (1.0.0 - 25/02/2024)
 * @inv  Segmento:vi Quando dois pontos nao formam um segmento de reta
 */
public class SegmentoReta{
        private final Ponto a;
        private final Ponto b;
        SegmentoReta(Ponto x, Ponto y)
        {
                if(x.getX() == y.getX() && x.getY() == y.getY()){ // Descobrir se 2 pontos estão sobrepostos
                        System.out.println("Segmento:vi");
                        System.exit(0);
                }

                this.a = x;
                this.b = y;


        }



        /**
         * Método que usa a função ccw do ponto para verificar a orientação e concluir se 2 segmentos de reta se intercetam
         * @param b Segmento de reta
         * @return true or false se intercetam ou não
         */
        public boolean intersects(SegmentoReta b) {
                SegmentoReta a = this;
                if (Ponto.ccw(a.a, a.b, b.a) * Ponto.ccw(a.a, a.b, b.b) >= 0) return false; // Usei o >= 0 pois quando testava arestas adjacetenes o facto de um ponto tocar  no ponto de outro segmento estava a retornar que os segmentos se intercetavam
                if (Ponto.ccw(b.a, b.b, a.a) * Ponto.ccw(b.a, b.b, a.b) >= 0) return false; // Se tiverem os 2 a mesma orientaçao vai dar sempre positivo ou seja não se intercetam

                return true;
        }


        public Ponto getA() {
                return a;
        }

        public Ponto getB() {
                return b;
        }
}

