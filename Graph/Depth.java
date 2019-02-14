import java.util.*;
class Depth
{
    ArrayList<Integer> adj[];
    int v;
    int depth[];
    Depth(int v)
    {
        adj = new ArrayList[v];
        this.v = v;
        for(int i=0;i<v;i++)
        {
            adj[i] = new ArrayList();
        }
        depth = new int[v];
    }
    private void addEdge(int src,int dest)
    {
        adj[src].add(dest);
        adj[dest].add(src);
    }
    void findDepthUtil(int src,boolean visited[])
    {
        visited[src] = true;
        for(int i=0;i<adj[src].size();i++)
        {
            int d = adj[src].get(i);
            if(!visited[d])
            {
                depth[d] = depth[src]+1;
                findDepthUtil(d,visited);
            }
        }
    }
    void findDepth()
    {
        boolean visited[] = new boolean[v];
        for(int i=0;i<adj.length;i++)
        {
            if(!visited[i])
                findDepthUtil(i,visited);
        }
        for(int i=0;i<depth.length;i++)
            System.out.println(i + " " + depth[i]);
    }
    public static void main(String args[])
    {
        Depth graph = new Depth(8);
        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(2,5);
        graph.addEdge(3,4);
        graph.addEdge(5,6);
        graph.addEdge(5,4);
        graph.addEdge(4,7);
        graph.findDepth();
    }
}