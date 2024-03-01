class Path {

    private Ponto[] pontoPath;

    Path(Ponto[] pontos, int n) {
        if(pontos != null || n >= 0) this.pontoPath = pontos;
        else{
            System.out.println("iv");
            System.exit(0);
        }
    }


    public double distance() {
        double caminho = 0;
        for (int i = 0; i < this.pontoPath.length - 1; i++) { // for loop para somar as distancias de todos os pontos
            caminho = caminho + this.pontoPath[i].dist(this.pontoPath[i + 1]);
        }
        return caminho;
    }
}
