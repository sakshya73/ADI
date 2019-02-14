import java.util.*;
class ConnectedComponents
{
    ArrayList<Integer> adj[];
    int V;
    ArrayList<Integer> res[];
    ConnectedComponents(int v)
    {
        V = v;
        adj = new ArrayList[v];
        res = new ArrayList[v];
        for(int i=0;i<v;i++)
        {
            res[i] = new ArrayList();
            adj[i] = new ArrayList();
        }
    }
    private void addEdge(int src,int dest)
    {
        adj[src].add(dest);
        adj[dest].add(src);
    }
    void connectedUtil(int src,boolean[] visited,int val)
    {
        visited[src] = true;
        res[val].add(src);
        for(int i=0;i<adj[src].size();i++)
        {
            int n = adj[src].get(i);
            if(!visited[n])
                connectedUtil(n,visited,val);
        }
        
    }
    private void connected()
    {
        int val=0;
        boolean visited[] = new boolean[V];
        for(int i=0;i<V;i++)
        {
            if(!visited[i])
            {
                connectedUtil(i,visited,val);
                val++;
            }
        }
    }
    void display()
    {
        for(int i=0;i<res.length;i++)
        {
            for(int j=0;j<res[i].size();j++)
            {
                System.out.print(res[i].get(j) + " ");
            }
            System.out.println();
        }
    }
    public static void main(String args[])
    {
        ConnectedComponents graph = new ConnectedComponents(5);
        graph.addEdge(1, 0); 
        graph.addEdge(2, 3); 
        graph.addEdge(3, 4); 
        graph.connected();
        graph.display();
    }
}