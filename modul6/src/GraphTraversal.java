import java.util.*;

public class GraphTraversal {
    private Map<String, List<String>> adjList = new HashMap<>();

    public void addVertex(String label) {
        adjList.putIfAbsent(label, new ArrayList<>());
    }

    public void addEdge(String from, String to) {
        adjList.get(from).add(to); // directed graph
    }

    public void bfs(String start) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);

        System.out.print("BFS traversal: ");
        while (!queue.isEmpty()) {
            String vertex = queue.poll();
            System.out.print(vertex + " ");
            for (String neighbor : adjList.get(vertex)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    public void dfs(String start) {
        Set<String> visited = new HashSet<>();
        System.out.print("DFS traversal: ");
        dfsHelper(start, visited);
        System.out.println();
    }

    private void dfsHelper(String vertex, Set<String> visited) {
        visited.add(vertex);
        System.out.print(vertex + " ");
        for (String neighbor : adjList.get(vertex)) {
            if (!visited.contains(neighbor)) {
                dfsHelper(neighbor, visited);
            }
        }
    }

    public void printAdjacencyMatrix() {
        List<String> vertices = new ArrayList<>(adjList.keySet());
        Collections.sort(vertices);
        int size = vertices.size();

        int[][] matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            String from = vertices.get(i);
            for (String to : adjList.get(from)) {
                int j = vertices.indexOf(to);
                matrix[i][j] = 1;
            }
        }

        System.out.println("Adjacency Matrix:");
        System.out.print("   ");
        for (String v : vertices) {
            System.out.print(v + " ");
        }
        System.out.println();

        for (int i = 0; i < size; i++) {
            System.out.print(vertices.get(i) + "  ");
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        GraphTraversal graph = new GraphTraversal();

        // Tambahkan vertex A sampai E
        for (char c = 'A'; c <= 'E'; c++) {
            graph.addVertex(String.valueOf(c));
        }

        // Tambahkan edge
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "D");
        graph.addEdge("C", "D");
        graph.addEdge("C", "E");
        graph.addEdge("D", "E");

        // Jalankan traversal dan tampilkan adjacency matrix
        graph.bfs("A");
        graph.dfs("A");
        graph.printAdjacencyMatrix();
    }
}
