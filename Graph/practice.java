package Graph;
import java.util.*;
public class practice {
    static class Edge{
        int src;
        int dest;
        Edge(int s,int d){
            this.src=s;
            this.dest=d;
        }
    }
    public static void buildTree(ArrayList<Edge> graph[],int v){
        for(int i=0;i<v;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));

        graph[6].add(new Edge(6, 5));
    }
    public static void BFS(ArrayList<Edge> graph[],boolean vis[]){
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        while(!q.isEmpty()){
        int curr=q.remove();
        if(vis[curr]==false){
            System.out.println(curr);
            vis[curr]=true;
            for(int i=0;i<graph[curr].size();i++){
                Edge e=graph[curr].get(i);
                if(!vis[e.dest]){
                q.add(e.dest);
                }
            }
        }
    }
    }
    public static void DFS(ArrayList<Edge> graph[],boolean vis[],int curr){
        vis[curr]=true;
        System.out.print(curr+" ");
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(vis[e.dest]==false){
            DFS(graph, vis, e.dest);
            }
        }
    }
    public static void AllPathsFromSourceToTarget(ArrayList<Edge> graph[],int src,int target,String path,boolean vis[]){
        if(src==target){
            System.out.println(path);
            return;
        }
        vis[src]=true;
        for(int i=0;i<graph[src].size();i++){
            Edge e=graph[src].get(i);
            if(vis[e.dest]==false){
                AllPathsFromSourceToTarget(graph, e.dest, target, path+e.dest, vis);
            }
        }
        vis[src]=false;
    }
    public static boolean cycleDetection(ArrayList<Edge> graph[],boolean vis[],boolean recStack[],int curr){
        vis[curr]=true;
        recStack[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(recStack[e.dest]){
                return true;
            }
            else if(!vis[e.dest]){
                if(cycleDetection(graph, vis, recStack, e.dest)){
                    return true;
                }
            }
        }
        return false;
    }
    public static void topologicalSort(ArrayList<Edge> graph[],Stack<Integer> stack,boolean vis[],int curr){
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(vis[e.dest]==false){
                topologicalSort(graph, stack, vis, e.dest);
            }
        }
        stack.push(curr);
    }
    public static boolean cycleDetUndirected(ArrayList<Edge> graph[],boolean vis[],int curr,int parent){
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(vis[e.dest]==true && parent!=e.dest){
                return true;
            }
            else if(!vis[e.dest]){
                if(cycleDetUndirected(graph, vis, e.dest, curr)){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int v=7;
        ArrayList<Edge> graph[]=new ArrayList[v];
        buildTree(graph, v);
        BFS(graph,new boolean[v]);
        DFS(graph, new boolean[v], 0);
        AllPathsFromSourceToTarget(graph, 0, 5, "0", new boolean[v]);
       
        Stack<Integer> st=new Stack<>();
         topologicalSort(graph,st, new boolean[v], 0);
         while(!st.empty()){
            System.out.print(st.pop()+" ");
         }
         System.out.println(cycleDetUndirected(graph,new boolean[v], 0, -1));
    }
}
