// void cria_adjacencia( i, j, P)  // cria uma adjacência entre i e j com custo P no grafo G;
// void remove_adjacencia( i, j)  // remove a adjacência entre i e j no grafo G;
// void imprime_adjacencias()  // imprime a matriz de adjacências do grafo G
// void seta_informacao( i, String V)  // atualiza a informação do nó i com o valor V (que deve ser uma string) no grafo 
// int adjacentes(i, adj)  // retorna o número de adjacentes ao vértice i no grafo G e os armazena no vetor adj

import vertex.Vertice;

public class Graph {

    public final Double VAZIO = Double.POSITIVE_INFINITY;

    private double[][] matriz;
    private int numeroVertices;
    private Vertice[] vertices;

    public Graph(int numeroVertices) {

        this.numeroVertices = numeroVertices;
        
        // Passamos o número de vértices
        // A matriz será nVertices x nVertices, matriz quadrada

        this.matriz = new double[numeroVertices][numeroVertices];

        // Inicializamos também o array de vértices
        this.vertices = new Vertice[numeroVertices]; 

        // Populando matriz
        populaMatriz();

        // Populando o array de vértices
        populaVertice();

    }

    private void populaMatriz() {
        // Quando inicializamos uma matriz de objeto X, ela está populada por objetos NULL
        // Precisamos estabelecer um valor para representar o VAZIO
        // o 0 pode representar peso, portanto utilizarei uma abordagem diferente
        for (int i = 0; i < numeroVertices; i++) {
            for (int j = 0; j < numeroVertices; j++) {
                matriz[i][j] = VAZIO;
            }
        }
    }

    private void populaVertice() {
        // Criando as vértices, no momento sem LABEL
        for (int i = 0; i < numeroVertices; i++) {
            vertices[i] = new Vertice(""); // Label genérico
        }

    }

    public void criaAdjacencia(int origem, int destino, double peso) {
        // Simplesmente criar a conexão
        matriz[origem][destino] = peso; // Recebe o peso
    }

    public void removeAdjacencia(int origem, int destino) {

        if (matriz[origem][destino] != VAZIO) {
            // Adjacência encontrada
            matriz[origem][destino] = VAZIO;
        }

    }

    public void imprimeAdjacencias() {

        // Percorrendo a matriz
        for (int i = 0; i < numeroVertices; i++) {
            for (int j = 0; j < numeroVertices; j++) {

                if (matriz[i][j] == VAZIO) {
                    System.out.print("INF ");
                } else {
                    System.out.print(matriz[i][j] + " ");
                }

            }
            System.out.println();
        }
    }

    public void setaInformacao(int indice, String label) {
        vertices[indice].setLabel(label);
    }

    public int adjacentes(int i, int[] adj) {
        int contador = 0;

        for (int j = 0; j < numeroVertices; j++) {
            if (matriz[i][j] != VAZIO) {
                adj[contador++] = j;
            }
        }

        return contador;
    }

    public static void main(String[] args) {

        Graph grafo = new Graph(5);

        grafo.setaInformacao(0, "A");
        grafo.setaInformacao(1, "B");
        grafo.setaInformacao(2, "C");
        grafo.setaInformacao(3, "D");

        grafo.criaAdjacencia(0, 0, 2);
        grafo.criaAdjacencia(2, 0, 30);
        grafo.criaAdjacencia(0, 2, 5);
        grafo.criaAdjacencia(3, 1, 9);
        grafo.imprimeAdjacencias();

    }

}