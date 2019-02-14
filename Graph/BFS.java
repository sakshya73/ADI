import java.util.*;
class BFS
{
    int V;
    LinkedList<Integer> list[];
    BFS(int n)
    {
        V=n;
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
    void BFStrav(int s)
    {
        boolean visited[] = new boolean[V];
        visited[s] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        while(!q.isEmpty())
        {
            int n = q.poll();
            System.out.println(n+" ");
            Iterator<Integer> it = list[n].listIterator();
            while(it.hasNext())
            {
                int k = it.next();
                if(!visited[k])
                {
                    visited[k] = true;
                    q.add(k);
                }
            }
        }
    }
    public static void main(String args[])
    {
        BFS graph = new BFS(5);
        graph.addEdge(1, 3);
        graph.addEdge(3,2);
        graph.addEdge(3,3);
        graph.addEdge(3,1);
        graph.addEdge(2,3);
        graph.addEdge(2,4);
        graph.BFStrav(1);
    }
}