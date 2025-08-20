import models.Grafo;
import models.Aresta;

public class Main {
    public static void main(String[] args) {
        // Criando grafo com 4 vértices
        Grafo g = new Grafo(4);

        // Setando rótulos
        g.setaInformacao(0, "A");
        g.setaInformacao(1, "B");
        g.setaInformacao(2, "C");
        g.setaInformacao(3, "D");

        System.out.println("=== Grafo inicial (sem arestas) ===");
        g.imprimeAdjacencias();

        // Criando adjacências
        g.criaAdjacencia(0, 1, 5);
        g.criaAdjacencia(0, 2, 3);
        g.criaAdjacencia(1, 3, 2);
        g.criaAdjacencia(2, 3, 4);

        System.out.println("\n=== Grafo após criação de adjacências ===");
        g.imprimeAdjacencias();

        // Testando método adjacentes
        Aresta[] adj = new Aresta[10]; // array grande o suficiente
        int qtdAdj = g.adjacentes(0, adj);
        System.out.println("\nAdjacentes do vértice A:");
        for (int i = 0; i < qtdAdj; i++) {
            System.out.println(adj[i]);
        }

        // Removendo uma adjacência
        g.removeAdjacencia(0, 2);

        System.out.println("\n=== Grafo após remover adjacência A -> C ===");
        g.imprimeAdjacencias();
    }
}
