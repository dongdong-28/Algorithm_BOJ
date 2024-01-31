import java.util.*;

class Node implements Comparable<Node> {
    int vex;
    int cost;
    
    public Node(int vex,int cost) {
        this.vex = vex;
        this.cost = cost;
    }
    
    @Override
    public int compareTo(Node no) {
        return this.cost - no.cost;
    }
}


// 11 ~ 15 시간초과남
class Solution {
    static ArrayList<ArrayList<Node>> gragh;
    static int[] dist;
    static boolean[] check;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        

        gragh = new ArrayList<>();
        for(int i =0;i<=n;i++) gragh.add(new ArrayList<>());
        
        for(int j = 0;j<roads.length;j++) {
            int a = roads[j][0];
            int b = roads[j][1];
            gragh.get(a).add(new Node(b,Integer.MAX_VALUE));
            gragh.get(b).add(new Node(a,Integer.MAX_VALUE));
        }
        
    
            dist = new int[n+1];
            Arrays.fill(dist,Integer.MAX_VALUE);
            check = new boolean[n+1];
            sol(n,roads,destination);
           
        
        int idx = 0;
        for(int source : sources) {
        if(dist[source] != Integer.MAX_VALUE) answer[idx] = dist[source];
        else
            answer[idx] = -1;
            
        idx++;
        }
        
        return answer;
    }
    
    
    static void sol(int n, int[][] roads,int destination) {
        
        Queue<Integer> q = new LinkedList<>();
        q.add(destination);
        dist[destination] = 0;
        
        while(!q.isEmpty()){
            int v = q.poll();
            if(check[v]) continue;
            check[v] = true;

            for(Node next : gragh.get(v)) {
                if(dist[next.vex] > dist[v] + 1) {
                    dist[next.vex] = dist[v] +1;
                    q.add(next.vex);
                }
                
            }
            
            
        } 
        
        
    }
    
    
}