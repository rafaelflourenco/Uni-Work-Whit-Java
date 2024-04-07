import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RetanguloTest {

    @Test
    public void testIsRetanguki() // Testa a função de verificação de pontos para a possibilidade de serem retanguis
    {
        Ponto pontos[] = new Ponto[4];
        pontos[0] = new Ponto(0,1);
        pontos[1] = new Ponto(2,1);
        pontos[2] = new Ponto(2,3);
        pontos[3] = new Ponto(0,3);

        Retangulo r = new Retangulo(pontos);

        assertTrue(r.isRetangulo(pontos));
    }

    @Test
    public void TestRetanguloParaString(){ //Teste para verificar a função paraString do Retangulo
        Ponto[] pontos = new Ponto[4];
        pontos[0] = new Ponto(1,0);
        pontos[1] = new Ponto(3,0);
        pontos[2] = new Ponto(3,2);
        pontos[3] = new Ponto(1,2);
        Retangulo p1 = new Retangulo(pontos);
        assertEquals("Retangulo: [(1,0), (3,0), (3,2), (1,2)]",p1.toString());
        // Expected: Retangulo: [(1,0), (3,0), (3,2), (1,2)]


        // Expected: Quadrado: [(1,0), (3,0), (3,2), (1,2)]
    }
}