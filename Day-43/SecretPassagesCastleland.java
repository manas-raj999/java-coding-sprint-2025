import java.util.*;

public class SecretPassagesCastleland {
    public static List<Integer> dfsTraversal(int n, List<List<Integer>> adj) {
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[n];

        dfs(0, adj, visited, result);

        return result;
    }

    private static void dfs(int current, List<List<Integer>> adj, boolean[] visited, List<Integer> result) {
        visited[current] = true;
        result.add(current);

        for (int neighbor : adj.get(current)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited, result);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        String input = sc.nextLine();
        input = input.replace("[[", "").replace("]]", "");
        String[] parts = input.split("\\], \\[");

        for (int i = 0; i < parts.length; i++) {
            String part = parts[i].replace("[", "").replace("]", "");
            if (!part.trim().isEmpty()) {
                String[] neighbors = part.split(", ");
                for (String neighbor : neighbors) {
                    adj.get(i).add(Integer.parseInt(neighbor.trim()));
                }
            }
        }

        List<Integer> result = dfsTraversal(n, adj);
        System.out.println(result);
        sc.close();
    }
}
