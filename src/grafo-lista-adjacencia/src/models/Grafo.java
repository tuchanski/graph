package models;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// Crie uma representação de grafo direcionado, ponderado e rotulado baseada em LISTAS DE ADJACÊNCIAS.
//Implemente as seguintes operações sobre esta representação:
//void cria_adjacencia(i, j, P) // cria uma adjacência entre i e j com custo P no grafo;
//void remove_adjacencia(i, j) // remove a adjacência entre i e j no grafo;
//void imprime_adjacencias() // imprime a matriz de adjacências do grafo
//void seta_informacao(i, String V) // atualiza a informação do nó i com o valor V (que deve ser uma string) no grafo
//int adjacentes(i, adj) // retorna o número de adjacentes ao vértice i no grafo e os armazena no vetor adj

public class Grafo {

    private int numeroVertices;
    private List<Vertice> vertices;
    private List<LinkedList<Aresta>> adjacencias;

    public Grafo(int numeroVertices) {
        this.numeroVertices = numeroVertices;
        this.vertices = new ArrayList<Vertice>();
        this.adjacencias = new ArrayList<>(numeroVertices);
        populaListas();
    }

    public void criaAdjacencia(int origem, int destino, int p) {
        Vertice vDestino = vertices.get(destino);
        Aresta aresta = new Aresta(vDestino, p);
        adjacencias.get(origem).add(aresta);
    }

    public int adjacentes(int indiceVertice, Aresta[] adj) {
        int contador = 0;

        LinkedList<Aresta> lista = adjacencias.get(indiceVertice);

        for (Aresta a : lista) {
            adj[contador] = a;
            contador++;
        }

        return contador;
    }

    public void removeAdjacencia(int origem, int destino) {

        LinkedList<Aresta> lista = adjacencias.get(origem);
        Aresta aRemover = null;

        for (Aresta aresta : lista) {
            if (vertices.get(destino).equals(aresta.destino)) {
                aRemover = aresta;
            }
         }
        
         if (aRemover != null) {
            lista.remove(aRemover);
         }

    }

    public void imprimeAdjacencias() {
        int contador = 0;
        for (LinkedList<Aresta> arestas : adjacencias) {
            System.out.print(vertices.get(contador) + " - ");
            for (Aresta aresta : arestas) {
                System.out.print(aresta);
            }
            contador++;
            System.out.println();
        }
    }

    public void setaInformacao(int indice, String label) {
        vertices.get(indice).setLabel(label);
    }

    private void populaListas() {
        for (int i = 0; i < numeroVertices; i++) {
            vertices.add(new Vertice(""));
            adjacencias.add(new LinkedList<>());
        }
    }

}
