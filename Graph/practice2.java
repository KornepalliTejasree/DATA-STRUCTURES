package Graph;
import java.util.*;
public class practice2 {
    static class Edge{
        int src;
        int dest;
        int dis;
        Edge(int s,int dest,int distance){
            this.src=s;
            this.dest=dest;
            this.dis=distance;
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
    public static void BFS(ArrayList<Edge> graph[],boolean vis[],int src){
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        while(!q.isEmpty()){
            int curr=q.remove();
            if(vis[curr])continue;
            if(vis[curr]==false)vis[curr]=true;
            System.out.print(curr);
            for(int i=0;i<graph[curr].size();i++){
                Edge e=graph[curr].get(i);
                if(vis[e.dest])continue;
                q.add(e.dest);
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
    public static void AllPathsFromSourceToTarget(ArrayList<Edge> graph[],int curr,boolean vis[],String path,int target){
        if(curr==target){
            System.out.println(path);
            return;
        }
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(vis[e.dest]==false){
            AllPathsFromSourceToTarget(graph, e.dest, vis, path+e.dest, target);
            }
        }
        vis[curr]=false;
    }
    public static boolean cycleDetection(ArrayList<Edge> graph[],boolean vis[],boolean recStack[],int curr){
        vis[curr]=true;
        recStack[curr]=true;
        for(int i=0;i<graph[curr].size();i++ ){
            Edge e=graph[curr].get(i);
            if(vis[e.dest]==false){
                if(cycleDetection(graph, vis, recStack, e.dest)){
                    return true;
                }
            }
        }
        recStack[curr]=false;
        return false;
    }
    public static void topologicalSort(ArrayList<Edge> graph[],Stack<Integer> st,boolean vis[],int curr){
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(vis[e.dest]==false){
                topologicalSort(graph, st, vis, e.dest);
            }
        }
        st.push(curr);
    }
    public static boolean cycleDetectionUndirected(ArrayList<Edge> graph[],boolean vis[],int curr,int parent){
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(vis[e.dest]==true && parent!=e.dest){
                return true;
            }
            else if(vis[e.dest]==false){
                if(cycleDetectionUndirected(graph, vis, e.dest, curr)){
                    return true;
                }
            }
        }
        return false;
    }
    static class Pair implements Comparable<Pair>{
        int src;
        int dist;
        Pair(int src,int dist){
            this.src=src;
            this.dist=dist;
        }
        @Override
        public int compareTo(Pair p2){
            return this.dist-p2.dist;
        }
    }
    public static void dijkistra(ArrayList<Edge> graph[],boolean vis[],int curr,int V){
        PriorityQueue<Pair> q=new PriorityQueue<>();
        int dp[]=new int[V];
        for(int i=0;i<V;i++){
            if(curr!=i){
                dp[i]=Integer.MAX_VALUE;
            }
        }
        q.add(new Pair(curr, 0));
        while(!q.isEmpty()){
            Pair p=q.remove();
            if(vis[p.src]) continue;
            vis[p.src]=true;
            for(int i=0;i<graph[p.src].size();i++){
                Edge e=graph[p.src].get(i);
                int u=e.src;
                int v=e.dest;
                int wt=e.dis;
                if(dp[u]+wt<dp[v]){
                    dp[v]=dp[u]+wt;
                    q.add(new Pair(v, dp[v]));
                }
            }
        }
        System.out.println("Dijkistra");
        for(int i=0;i<dp.length;i++){
            System.out.print(dp[i]+" ");
        }
        System.out.println();
    }
    public static void bellmanFord(ArrayList<Edge> graph[],int v,int src){
        int dp[]=new int[v];
        for(int i=0;i<v;i++){
            if(i!=src){
                dp[i]=Integer.MAX_VALUE;
            }
        }
        for(int i=0;i<v-1;i++){
            for(int j=0;j<v;j++){
                for(int k=0;k<graph[j].size();k++){
                    Edge e=graph[j].get(k);
                    int u=e.src;
                    int v1=e.dest;
                    int wt=e.dis;
                    if(dp[u]+wt<dp[v1] && dp[u]!=Integer.MAX_VALUE){
                        dp[v1]=dp[u]+wt;
                    }
                }
            }
        }
        System.out.println("BellmanFord");
        for(int i=0;i<dp.length;i++){
            System.out.println(dp[i]+" ");
        }
    }
    public static void PrimsAlgo(ArrayList<Edge> graph[],int src,int v){
        PriorityQueue<Pair> q=new PriorityQueue<>();
        q.add(new Pair(src, 0));
        int cost=0;
        boolean vis[]=new boolean[v];
        while(!q.isEmpty()){
            Pair curr=q.remove();
            if(vis[curr.src]==true)continue;
            vis[curr.src]=true;
            cost+=curr.dist;
            for(int i=0;i<graph[curr.src].size();i++){
                Edge e=graph[curr.src].get(i);
                if(vis[e.dest]==false){
                    q.add(new Pair(e.dest, e.dis));
                }
            }
        }
        System.out.println("PrimsAlgorithm mst shortest path "+cost);
    }
    public static void KosarajusAlgo(ArrayList<Edge> graph[],int v){
        //Step:1 perform the topologiacl sort
        Stack<Integer> st=new Stack<>();
        boolean vis[]=new boolean[v];
        for(int i=0;i<v;i++){
            if(!vis[i]){
                topologicalSort(graph, st, vis, i);
            }
        }
        //step:2 transpose the graph
        ArrayList<Edge> transposeGraph[]=new ArrayList[v];
        for(int i=0;i<v;i++){
            transposeGraph[i]=new ArrayList<>();
        }
        for(int i=0;i<v;i++){
            for(int j=0;j<graph[i].size();j++){
                Edge e=graph[i].get(j);
                transposeGraph[e.dest].add(new Edge(e.dest, e.src, e.dis));
            }
        }
        //Do dfs accrding to the stack nodes on the transpose graph
        vis=new boolean[v];
        while(!st.isEmpty()){
            int curr=st.pop();
            if(!vis[curr]){
                DFS(transposeGraph, vis, curr);
                System.out.println();
            }
        }
    }
    public static void main(String[] args) {
        int v=6;
        ArrayList<Edge> graph[]=new ArrayList[v];
        buildTree(graph, v);
        BFS(graph, new boolean[v], 0);
        DFS(graph, new boolean[v], 0);
        AllPathsFromSourceToTarget(graph, 0, new boolean[v], "0", 5);
        boolean vis[]=new boolean[v];
        for(int i=0;i<v;i++){
            if(vis[i]==false){
               if( cycleDetection(graph, vis, new boolean[v], i)){
                System.out.println(true);
                break;
               }
            }
        }
         vis=new boolean[v];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<v;i++){
            if(vis[i]==false){
                topologicalSort(graph, st, vis, i);
            }
        }
        while(!st.isEmpty()){
            System.out.println(st.pop());
        }
        dijkistra(graph, new boolean[v], 0, 6);
        bellmanFord(graph, v,0);
        PrimsAlgo(graph, 0, 6);
        System.out.println("Kosaraju");
        KosarajusAlgo(graph, v);
    }
}
