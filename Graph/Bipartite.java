import java.util.*;
class Bipartite
{
    ArrayList<Integer> adj[];
    int V;
    boolean visited[];
    boolean color[];
    Bipartite(int v)
    {
        V = v;
        visited = new boolean[v];
        adj = new ArrayList[v];
        color = new boolean[v];
        for(int i=0;i<v;i++)
        {
            adj[i] = new ArrayList();
        }
    }
    void addEdge(int src,int dest)
    {
        adj[src].add(dest);
    }
    boolean BPGraphUtil(int src,boolean clr)
    {
        visited[src] = true;
        color[src] = clr;
        for(int i=0;i<adj[src].size();i++)
        {
            int n = adj[src].get(i);
            if(visited[n])
            {
                if(color[n] == color[src])
                    return false;
            }
            else
                BPGraphUtil(n,!clr);
        }
        return true;
    }
    boolean BPGraph()
    {
        boolean res = BPGraphUtil(0,false);
        for(int i=0;i<V;i++)
        {
            if(!visited[i])
                return false;
        }
        return res;
    }
    public static void main(String args[])
    {
        Bipartite obj = new Bipartite(4);
        obj.addEdge(0, 1);
        obj.addEdge(0, 3);
        obj.addEdge(1, 0);
        obj.addEdge(1, 2);
        obj.addEdge(2, 1);
        obj.addEdge(2, 3);
        obj.addEdge(3, 0);
        obj.addEdge(3, 2);
        boolean res = obj.BPGraph();
        System.out.println(res);
    }
}