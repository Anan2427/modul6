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

    public static void main(String[] args) {
        GraphTraversal graph = new GraphTraversal();

        // Tambahkan vertex
        for (char c = 'A'; c <= 'H'; c++) {
            graph.addVertex(String.valueOf(c));
        }

        // Tambahkan edge (contoh 10 rute)
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "D");
        graph.addEdge("C", "D");
        graph.addEdge("C", "E");
        graph.addEdge("D", "F");
        graph.addEdge("E", "F");
        graph.addEdge("F", "G");
        graph.addEdge("G", "H");
        graph.addEdge("H", "A");

        // Jalankan traversal
        graph.bfs("A");
        graph.dfs("A");
    }
}
