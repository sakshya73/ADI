import java.util.*;
class DFS
{
    int V;
    LinkedList<Integer> list[];
    DFS(int n)
    {
        V = n;
        list = new LinkedList[n];
        for(int i=0;i<n;i++)
        {
            list[i] = new LinkedList();
        }
    }
    void addEdge(int src,int dest)
    {
        list[src].add(dest);
    }
    void DFSutil(int s,boolean visited[])
    {
        System.out.println(s + " ");
        visited[s] = true;
        Iterator<Integer> it = list[s].listIterator();
        while(it.hasNext())
        {
            int k = it.next();
            if(!visited[k])
            {
                visited[k] = true;
                DFSutil(k,visited);
            }
        }
    }
    void DFStrav(int s)
    {
        boolean visited[] = new boolean[V];
        for(int i=0;i<V;i++)
        {
            if(visited[i] == false)
                DFSutil(i,visited);
        }
    }
    public static void main(String args[])
    {
        DFS graph = new DFS(5);
        graph.addEdge(1, 1);
        graph.addEdge(2, 4);
        graph.addEdge(2, 1);
        graph.addEdge(4, 3);
        graph.DFStrav(1);
        
    }
}