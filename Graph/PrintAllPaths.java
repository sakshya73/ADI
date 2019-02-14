import java.util.*;
class PrintAllPaths
{
    LinkedList<Integer> adj[];
    int V;
    int index;
    PrintAllPaths(int V)
    {
        this.V=V;
        adj = new LinkedList[V];
        for(int i=0;i<V;i++)
        {
            adj[i] = new LinkedList();
        }
    }
    private void addEdge(int src,int dest)
    {
        adj[src].add(dest);
    }
    private void printPathsUtil(int src,int dest,boolean visited[],int paths[])
    {
        visited[src] = true;
        paths[index] = src;
        index++;
        if(src == dest)
        {
            for(int i=0;i<index;i++)
            {
                System.out.print(paths[i] + " ");
            }
            System.out.println();
        }
        for(int i=0;i<adj[src].size();i++)
        {
            int s = adj[src].get(i);
            if(!visited[s])
                printPathsUtil(s,dest,visited,paths);
        }
        visited[src] = false;
        index--;
    }
    private void printPaths(int src,int dest)
    {
        boolean visited[] = new boolean[V];
        int paths[] = new int[adj.length];
        printPathsUtil(src,dest,visited,paths);
    }
    public static void main(String args[])
    {
        PrintAllPaths graph = new PrintAllPaths(6);
        graph.addEdge(1,2);
        graph.addEdge(2,5);
        graph.addEdge(1,5);
        graph.addEdge(3,5);
        graph.addEdge(1,3);
        graph.addEdge(4,3);
        graph.addEdge(2,4);
        graph.printPaths(1, 5);
    }
}