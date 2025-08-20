package models;
public class Aresta {
    Vertice destino;
    int peso;

    public Aresta(Vertice destino, int peso) {
        this.destino = destino;
        this.peso = peso;
    }

    @Override
    public String toString() {
        return destino + " -> ";
    }

    
}
