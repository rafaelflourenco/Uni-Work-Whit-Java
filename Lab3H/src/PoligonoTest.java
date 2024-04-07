import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class PoligonoTest {
    @Test
    public void testPoligono1(){ // Teste para verificar se a funçao da false quando os polignos não se tocam


        Ponto[] pontos = new Ponto[4];
        pontos[0] = new Ponto(4,5);
        pontos[1] = new Ponto(8,5);
        pontos[2] = new Ponto(8,7);
        pontos[3] = new Ponto(5,7);
        Poligono p1 = new Poligono(pontos);

        Ponto[] pontos2 = new Ponto[4];
        pontos2[0] = new Ponto(7,1);
        pontos2[1] = new Ponto(9,1);
        pontos2[2] = new Ponto(9,3);
        pontos2[3] = new Ponto(7,3);
        Poligono p2 = new Poligono(pontos2);

        assertFalse(p1.Poligonosintersect(p2));

    }
    @Test
    public void testPoligono2(){ // Teste para verificar se a função de interseptar 2 poligonos está correta


        Ponto[] pontos = new Ponto[4];
        pontos[0] = new Ponto(5,5);
        pontos[1] = new Ponto(8,5);
        pontos[2] = new Ponto(8,7);
        pontos[3] = new Ponto(5,7);
        Poligono p1 = new Poligono(pontos);

        Ponto[] pontos2 = new Ponto[4];
        pontos2[0] = new Ponto(7,4);
        pontos2[1] = new Ponto(9,4);
        pontos2[2] = new Ponto(9,6);
        pontos2[3] = new Ponto(7,6);
        Poligono p2 = new Poligono(pontos2);

        assertTrue(p1.Poligonosintersect(p2));

    }

    @Test
    public void testPoligono3(){ // Teste para verificar se a funçao da false quando os polignos não se tocam


        Ponto[] pontos = new Ponto[4];
        pontos[0] = new Ponto(1,1);
        pontos[1] = new Ponto(4,2);
        pontos[2] = new Ponto(4,5);
        pontos[3] = new Ponto(2,3);
        Poligono p1 = new Poligono(pontos);

        Ponto[] pontos2 = new Ponto[3];
        pontos2[0] = new Ponto(6,4);
        pontos2[1] = new Ponto(7,2);
        pontos2[2] = new Ponto(9,4);
        Poligono p2 = new Poligono(pontos2);

        assertFalse(p1.Poligonosintersect(p2));
    }
    @Test
    public void testPoligono4(){ //Teste para verificar se a função de interseptar 2 poligonos está correta
        Ponto[] pontos = new Ponto[4];
        pontos[0] = new Ponto(1,1);
        pontos[1] = new Ponto(4,2);
        pontos[2] = new Ponto(4,5);
        pontos[3] = new Ponto(2,3);
        Poligono p1 = new Poligono(pontos);

        Ponto[] pontos2 = new Ponto[3];
        pontos2[0] = new Ponto(3,3);
        pontos2[1] = new Ponto(7,2);
        pontos2[2] = new Ponto(9,4);
        Poligono p2 = new Poligono(pontos2);

        assertTrue(p1.Poligonosintersect(p2));
    }

    @Test
    public void testPoligono5(){ //Teste para verificar o erro da colinearidade
        Ponto[] pontos = new Ponto[3];
        pontos[0] = new Ponto(10,10);
        pontos[1] = new Ponto(20,10);
        pontos[2] = new Ponto(30,10);
        Poligono p1 = new Poligono(pontos);

        assertEquals("Poligono:vi", p1.toString());
    }


    @Test
    public void testPoligono6(){ //Teste para verificar a função to string do Poligono
        Ponto[] pontos = new Ponto[4];
        pontos[0] = new Ponto(5,5);
        pontos[1] = new Ponto(8,6);
        pontos[2] = new Ponto(8,7);
        pontos[3] = new Ponto(5,7);
        Poligono p1 = new Poligono(pontos);
        assertEquals("Poligono de 4 vertices: [(5,5), (8,6), (8,7), (5,7)]",p1.toString());


        // Expected: Poligono de 4 vertices: [(5,5), (8,6), (8,7), (5,7)]
    }


}
