import java.util.*;
class CountAllPaths
{
    LinkedList<Integer> adj[];
    int V;
    CountAllPaths(int v)
    {
        V=v;
        adj = new LinkedList[v];
        for(int i=0;i<v;i++)
        {
            adj[i] = new LinkedList();
        }
    }
    private void addEdge(int src,int dest)
    {
        adj[src].add(dest);
    }
    private int countPathsUtil(int src,int dest,boolean visited[],int paths)
    {
        visited[src] = true;
        if(src == dest)
            paths++;
        Iterator<Integer> it = adj[src].listIterator();
        while(it.hasNext())
        {
            int n = it.next();
            if(!visited[n])
            {
                visited[n] = true;
                paths = countPathsUtil(n,dest,visited,paths);
            }
        }
        visited[src] = false;
        return paths;
    }
    private int countPaths(int s,int d)
    {
        int paths = 0;
        boolean visited[] = new boolean[V];
        return countPathsUtil(s,d,visited,paths);
    }
    public static void main(String args[])
    {
        CountAllPaths graph = new CountAllPaths(6);
        graph.addEdge(1,2);
        graph.addEdge(2,5);
        graph.addEdge(1,5);
        graph.addEdge(3,5);
        graph.addEdge(1,3);
        graph.addEdge(4,3);
        graph.addEdge(2,4);
        System.out.println(graph.countPaths(1,5));
    }
}