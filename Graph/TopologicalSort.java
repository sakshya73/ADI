import java.util.*;
class TopologicalSort
{
    int v;
    Stack<Integer> stk;
    ArrayList<Integer> adj[];
    TopologicalSort(int v)
    {
        stk = new Stack<>();
        this.v = v;
        adj = new ArrayList[v];
        for(int i=0;i<v;i++)
        {
            adj[i]= new ArrayList();
        }
    }
    private void addEdge(int src,int dest)
    {
        adj[src].add(dest);
    }
    void sortUtil(int src,boolean[] visited)
    {
        visited[src] = true;
        for(int i=0;i<adj[src].size();i++)
        {
            int d = adj[src].get(i);
            if(!visited[d])
                sortUtil(d,visited);
        }
        stk.push(src);
    }
    void sort()
    {
        boolean visited[] = new boolean[v];
        for(int i=0;i<adj.length;i++)
        {
            if(!visited[i])
                sortUtil(i,visited);
        }
        while(!stk.isEmpty())
        {
            System.out.print(stk.pop() + " ");
        }
    }
    public static void main(String args[])
    {
        TopologicalSort graph = new TopologicalSort(6);
        graph.addEdge(5,2);
        graph.addEdge(5,0);
        graph.addEdge(4,0);
        graph.addEdge(4,1);
        graph.addEdge(2,3);
        graph.addEdge(3,1);
        graph.sort();
        
    }
}