package Graph;
import java.util.*;
public class BrokenGraph {
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
    public static void BFS(ArrayList<Edge> graph[],int v,boolean vis[],int start){
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        vis[start]=true;
            while(!q.isEmpty()){
                int curr=q.remove();
                //vis[curr]=true;
                System.out.print(curr);
                for(int i=0;i<graph[curr].size();i++){
                    Edge e=graph[curr].get(i);
                    //q.add(e.dest);
                    if(vis[e.dest]==false){
                        q.add(e.dest);
                        vis[e.dest]=true;
                    }
                
            }
            
        }
    }
    public static void DFS(ArrayList<Edge> graph[],int curr,boolean vis[]){
        System.out.print(curr+" ");
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(vis[e.dest]==false){
                DFS(graph, e.dest, vis);
            }
        }
    }
    
    public static void AllPathsFromSourceToTarget(ArrayList<Edge> graph[],String path,int curr,int target,boolean vis[]){
         if(curr==target){
            System.out.println(path);
            return;
         }
         for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(vis[e.dest]==false){
                vis[curr]=true;
                AllPathsFromSourceToTarget(graph, path+e.dest, e.dest, target,vis);
                vis[curr]=false;
            }
         }
    }
    public static void main(String[] args) {
        int v=7;
        ArrayList<Edge> graph[]=new ArrayList[v];
        boolean vis[]=new boolean[v];
        buildTree(graph,v);
        for(int i=0;i<v;i++){
            if(vis[i]==false){
                DFS(graph, 0, vis);
            }
        }
        Arrays.fill(vis,false);
        // DFS(graph, 0, vis);
        vis[0]=true;
        AllPathsFromSourceToTarget(graph, "0", 0, 5, vis);
    }
}
