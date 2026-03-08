package Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgo {
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
     graph[0].add(new Edge(0, 1, 10));
     graph[0].add(new Edge(0, 2, 15));
     graph[0].add(new Edge(0, 3, 30));
     graph[1].add(new Edge(1, 0, 10));
     graph[1].add(new Edge(1, 3, 40));
     graph[2].add(new Edge(2, 0, 15));
     graph[2].add(new Edge(2, 3, 50));
     graph[3].add(new Edge(3, 0, 30));
     graph[3].add(new Edge(3, 1, 40));
     graph[3].add(new Edge(3, 2, 50));

    }
    static class Pair implements Comparable<Pair>{
        int node;
        int dist;
        Pair(int s,int d){
            this.node=s;
            this.dist=d;
        }
        @Override
        public int compareTo(Pair o) {
           return this.dist-o.dist;
        }

    }
    public static void primsAlgoithm(ArrayList<Edge> graph[],int src,int V){
        boolean vis[]=new boolean[V];
        PriorityQueue<Pair> q=new PriorityQueue<>();
        q.add(new Pair(src, 0));
        int cost=0;
        while(!q.isEmpty()){
            Pair curr=q.remove();
            if(vis[curr.node]==false){
                vis[curr.node]=true;
                cost+=curr.dist;
                for(int i=0;i<graph[curr.node].size();i++){
                    Edge e=graph[curr.node].get(i);
                    if(vis[e.dest]==false){
                        q.add(new Pair(e.dest, e.wt));
                    }
                }
            }
        }
        System.out.println(cost);
    }
    public static void main(String[] args) {
        int V=4;
        ArrayList<Edge> graph[]=new ArrayList[V];
        buildTree(graph, V);
        primsAlgoithm(graph, 0, V);
    }
}
