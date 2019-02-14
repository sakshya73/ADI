import java.util.*;
class Size
{
    int v;
    int size[];
    ArrayList<Integer> adj[];
    boolean visited[];
    Size(int s)
    {
        v = s;
        visited = new boolean[v];
        adj = new ArrayList[s];
        for(int i=0;i<s;i++)
        {
            adj[i] = new ArrayList();
        }
        size = new int[s];
    }
    private void addEdge(int src,int dest)
    {
        adj[src].add(dest);
        //adj[dest].add(src);
    }
    void findSizeUtil(int src)
    {
        visited[src] = true;
        for(int i=0;i<adj[src].size();i++)
        {
            int d = adj[src].get(i);
            if(!visited[d])
            {
                findSizeUtil(d);
                size[src] = size[src] + size[d]; 
            }
        }
    }
    void set()
    {
        for(int i=0;i<size.length;i++)
        {
            size[i] = 1;
            visited[i] = false;
        }
    }
    private void findSize()
    {
        for(int i=0;i<adj.length;i++)
        {
            set();
            findSizeUtil(i);
            System.out.println(i + " "+size[i]);
        }
    }
    
    public static void main(String args[])
    {
        Size graph = new Size(8);
        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(2,5);
        graph.addEdge(3,4);
        graph.addEdge(5,6);
        graph.addEdge(5,4);
        graph.addEdge(4,7);
        graph.findSize();
    }
}