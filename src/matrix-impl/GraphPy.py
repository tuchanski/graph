# void cria_adjacencia( i, j, P)  // cria uma adjacência entre i e j com custo P no grafo G;
# void remove_adjacencia( i, j)  // remove a adjacência entre i e j no grafo G;
# void imprime_adjacencias()  // imprime a matriz de adjacências do grafo G
# void seta_informacao( i, String V)  // atualiza a informação do nó i com o valor V (que deve ser uma string) no grafo 
# int adjacentes(i, adj)  // retorna o número de adjacentes ao vértice i no grafo G e os armazena no vetor adj

import math

def cria_adjacencia(origem, destino, peso, matriz):
    matriz[origem][destino] = peso

def remove_adjacencia(origem, destino, matriz):
    if matriz[origem][destino] != VAZIO:
        matriz[origem][destino] = VAZIO

def imprime_adjacencias(matriz):
    for i in range(len(matriz)):
        for j in range(len(matriz)):
            if matriz[i][j] == VAZIO:
                print("INF", end=" ")
            else:
                print(matriz[i][j], " ", end=" ")
        print()

def seta_informacao(indice, label, vertices):
    vertices[indice] = label

def adjacentes(indice, adj, matriz):
    for j in range(len(matriz)):
        if matriz[indice][j] != VAZIO:
            adj.append(j) # Armazena o vértice J
    return len(adj)

def inicializa_matriz(numero_vertices):
    matriz = []
    for i in range(numero_vertices):
        linha = []
        for j in range(numero_vertices):
            linha.append(VAZIO)
        matriz.append(linha)
    return matriz

def inicializa_vertices(numero_vertices):
    vertices = []
    for i in range(numero_vertices):
        vertices.append("")
    return vertices

VAZIO = math.inf # Constante do infinito para representar o vazio
numero_vertices = 4 # Troque manualmente
matriz = inicializa_matriz(numero_vertices=numero_vertices)
vertices = inicializa_vertices(numero_vertices=numero_vertices)

cria_adjacencia(0, 0, 3, matriz=matriz)
cria_adjacencia(2, 1, 6, matriz=matriz)
cria_adjacencia(1, 3, 9, matriz=matriz)
cria_adjacencia(0, 1, 6, matriz=matriz)
cria_adjacencia(2, 0, 10, matriz=matriz)

#print(adjacentes(0, [], matriz))
imprime_adjacencias(matriz=matriz)
