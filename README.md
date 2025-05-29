1. Representasi Graph
Graph direpresentasikan sebagai directed graph dengan 5 kota (A, B, C, D, E) dan 6 rute pengiriman sebagai edge.

Notasi Graph:
G = (V, E)
V = {A, B, C, D, E}
E = {(A, B), (A, C), (B, D), (C, D), (C, E), (D, E)}

2. Visualisasi Graph dan Adjacency Matrix
      A B C D E
A [0 1 1 0 0]  
B [0 0 0 1 0]  
C [0 0 0 1 1]  
D [0 0 0 0 1]  
E [0 0 0 0 0]

3. Output Traversal
   
BFS dari A:
A → B → C → D → E

DFS dari A:
A → B → D → E → C

4. Penjelasan
BFS menggunakan queue dan menelusuri node secara melebar (level-by-level).

DFS menggunakan rekursi (stack) dan menelusuri node secara mendalam terlebih dahulu.

Output traversal memperlihatkan jalur eksplorasi dari node awal A menuju node lainnya.
