package Graph;
import java.util.*;
//  3/3/26
class CycleDetection{
    static class Edge{
        int src;
        int dest;
        Edge(int s,int d){
            this.src=s;
            this.dest=d;
        }
    }
    public static void buildGraph(ArrayList<Edge> graph[],int v){
        for(int i=0;i<v;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,4));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));
       // graph[1].add(new Edge(1, 4));

        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 2));

        graph[4].add(new Edge(4, 0));
       // graph[4].add(new Edge(4, 1));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 4));
        //graph[3].add(new Edge(3, 0));

    }
 public static void topologicalSort(ArrayList<Edge> graph[],boolean vis[],Stack<Integer> stack,int curr){
    vis[curr]=true;
    for(int i=0;i<graph[curr].size();i++){
        Edge e=graph[curr].get(i);
        if(vis[e.dest]==false){
            topologicalSort(graph, vis, stack, e.dest);
        }
    }
    stack.push(curr);
 }
 //Undirected graph
 public static boolean cycleUndirected(ArrayList<Edge> graph[],boolean vis[],int parent,int curr){
   vis[curr]=true;
   for(int i=0;i<graph[curr].size();i++){
    Edge e=graph[curr].get(i);
    if(vis[e.dest] && parent!=e.dest){
        return true;
    }
    else if(vis[e.dest]==false){
       if( cycleUndirected(graph, vis, curr, e.dest)){
        return true;
       }
    }
   }
   return false;
 }
 public static boolean cycleDetection(ArrayList<Edge> graph[],boolean vis[],int curr,boolean recStack[]){
   vis[curr]=true;
   recStack[curr]=true;
    for(int i=0;i<graph[curr].size();i++){
        Edge e=graph[curr].get(i);
        if(recStack[e.dest]){
            return true;
        }
        else{
         if(cycleDetection(graph, vis, e.dest, recStack)){
            return true;
         }
        }
        recStack[curr]=false;
        return false;
    }
    vis[curr]=false;
    return false;
 }
    public static void main(String[] args) {
        int v=6;
        ArrayList<Edge> graph[]=new ArrayList[v];
        buildGraph(graph, v);
        if(cycleDetection(graph, new boolean[v], 0, new boolean[v])){
            System.out.println("It is a cyclic graph");
        }
        else{
            System.out.println("No, It is not a cyclic graph");
        }
        Stack<Integer> stack=new Stack<>();
        boolean vis[]=new boolean[v];
        for(int i=0;i<v;i++){
            if(vis[i]==false){
                 topologicalSort(graph, vis, stack, i);
            }
           
        }
       while(!stack.isEmpty()){
        System.out.println(stack.pop()+" ");
       }
      System.out.println(cycleUndirected(graph, new boolean[v], -1, 0)); 
    }
}