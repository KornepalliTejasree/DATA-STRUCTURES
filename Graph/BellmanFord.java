package Graph;
import java.util.*;
public class BellmanFord {
    static class Edge{
        int src;
        int dest;
        int wt;
        Edge(int s,int d,int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
    }
    public static void buildTree(ArrayList<Edge> graph[],int V){
     for(int i=0;i<V;i++){
        graph[i]=new ArrayList<>();
     }
     graph[0].add(new Edge(0, 1, 2));
     graph[0].add(new Edge(0, 2, 4));
     graph[1].add(new Edge(1, 2, -10));
     graph[2].add(new Edge(2, 3, 2));
     graph[3].add(new Edge(3, 4, 4));
     graph[4].add(new Edge(4, 1, -1));
    }
    public static void bellmanFordAlgorithm(ArrayList<Edge> graph[],int V,int src){
        int dis[]=new int[V];
        for(int i=0;i<V;i++){
            if(i!=src){
                dis[i]=Integer.MAX_VALUE;
            }
        }
        for(int i=0;i<V-1;i++){
            for(int j=0;j<V;j++){
                for(int k=0;k<graph[j].size();k++){
                    Edge e=graph[j].get(k);
                    int u=e.src;
                    int v=e.dest;
                    int wt=e.wt;
                    if(dis[u]!=Integer.MAX_VALUE && dis[u]+wt<dis[v]){
                        dis[v]=dis[u]+wt;
                    }
                }
            }
        }
        //Detecting negative cycle
        for(int i=0;i<V-1;i++){
            for(int j=0;j<V;j++){
                for(int k=0;k<graph[j].size();k++){
                    Edge e=graph[j].get(k);
                    int u=e.src;
                    int v=e.dest;
                    int wt=e.wt;
                    if(dis[u]+wt<dis[v]){
                        System.out.println("Detected a negative cycle");
                        break;
                    }
                }
            }
        }
        for(int i=0;i<V;i++){
            System.out.print(dis[i]+" ");
        }
    }
    public static void main(String[] args) {
        int V=5;
        ArrayList<Edge> graph[]=new ArrayList[V];
        buildTree(graph, V);
        bellmanFordAlgorithm(graph, V, 0);
    }
}
