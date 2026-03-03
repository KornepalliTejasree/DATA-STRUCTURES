package Graph;

import java.lang.reflect.Array;
import java.util.*;

public class Dijkstra {
    static class Edge{
        int src;
        int dest;
        int wt;
        Edge(int src,int dest,int wt){
            this.dest=dest;
            this.src=src;
            this.wt=wt;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
    graph[0].add(new Edge(0, 1, 2));
    graph[0].add(new Edge(0, 2, 4));

    graph[1].add(new Edge(1, 2, 1));
    graph[1].add(new Edge(1, 3, 7));

    graph[2].add(new Edge(2, 4, 3));

    graph[3].add(new Edge(3, 4, 1));
    }
    public static void dijkstra(ArrayList<Edge> graph[],int src,int curr,int arr[],int v,boolean vis[]){
        for(int i=0;i<v;i++){
           int min=AllPathsMin(graph,src,i,new boolean[v],0);
           if(min==Integer.MAX_VALUE)
           {
            arr[i]=-1;
           }
           else{
            arr[i]=min;
           }
        }
       // System.out.println(Arrays.toString(arr));
    }
    public static int AllPathsMin(ArrayList<Edge> graph[],int curr,int target,boolean vis[],int sum){
        if(curr==target){
            return sum;
        }
        vis[curr]=true;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(vis[e.dest]==false){
          int result=AllPathsMin(graph, e.dest, target, vis, sum+e.wt);
          if(result!=Integer.MAX_VALUE){
            min=Math.min(min, result);
          }
            }
        }
        vis[curr]=false;
        return min;
    }
    public static void main(String[] args) {
        int v=5;
        ArrayList<Edge> graph[]=new ArrayList[v];
        createGraph(graph);
        int arr[]=new int[5];
        dijkstra(graph, 0, 0,  arr, v, new boolean[v]);
        System.out.println(Arrays.toString(arr));
    }
}
