package Graph;
import java.util.*;
public class ApnaDijkstra {
    static class Edge{
        int src;
        int dest;
        int wt;
        Edge(int s,int d,int w){
            this.dest=d;
            this.src=s;
            this.wt=w;
        }
    }
    public static class Pair implements Comparable<Pair>{
        int node;
        int dist;
        Pair(int n,int d){
            this.node=n;
            this.dist=d;
        }
        @Override
        public int compareTo(Pair p1){
            return this.dist-p1.dist;
        }
    }
    public static void buildTree(ArrayList<Edge> graph[],int v){
        for(int i=0;i<v;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));
        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));
        graph[2].add(new Edge(2, 4, 3));
        graph[3].add(new Edge(3, 5, 1));
        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }
    public static void dijkistra(ArrayList<Edge> graph[],int src,int[] distance,boolean vis[]){
        PriorityQueue<Pair> q=new PriorityQueue<>();
        q.add(new Pair(0, 0));
        for(int i=0;i<graph.length;i++){
            if(i!=src){
                distance[i]=Integer.MAX_VALUE;
            }
        }
        while(!q.isEmpty()){
            Pair curr=q.remove();
            if(vis[curr.node]==false){
                vis[curr.node]=true;
                for(int i=0;i<graph[curr.node].size();i++){
                    Edge e=graph[curr.node].get(i);
                    int u=e.src;
                    int v=e.dest;
                    if(distance[u]+e.wt<distance[v]){
                        distance[v]=distance[u]+e.wt;
                    }
                    q.add(new Pair(v, distance[v]));
                }
            }
        }
        for(int i=0;i<graph.length;i++){
            System.out.print(distance[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int v=6;
        ArrayList<Edge> graph[]=new ArrayList[v];
        buildTree(graph, v);
        dijkistra(graph, 0, new int[v], new boolean[v]);
    }
}
