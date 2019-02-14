import java.util.*;
class NoOfIslands
{
    int Rows;
    int Cols;
    NoOfIslands(int r,int c)
    {
        Rows = r;
        Cols = c;
    }
    boolean isSafe(int r,int c,boolean [][]visited,int[][] mat)
    {
        return (r>=0) && (r<mat.length) && (c>=0) && (c<mat[0].length) && (!visited[r][c] && mat[r][c]==1);
    }
    void countNoOfIslandsUtil(int r,int c,int[][] mat,boolean[][] visited)
    {
        int rows[] = new int[]{-1,-1,-1,0,0,1,1,1};
        int cols[] = new int[]{-1,0,1,-1,1,-1,0,1};
        visited[r][c] = true;
        for(int i=0;i<8;i++)
        {
            if(isSafe(r+rows[i],c+cols[i],visited,mat))
                countNoOfIslandsUtil(r+rows[i],c+cols[i],mat,visited);
        }
    }
    int countNoOfIslands(int[][] mat)
    {
        int count = 0;
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        for(int i=0;i<mat.length;i++)
        {
            for(int j=0;j<mat[0].length;j++)
            {
                if(mat[i][j]==1 && !visited[i][j])
                {
                    countNoOfIslandsUtil(i,j,mat,visited);
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String args[])
    {
        int M[][] = new int[][]{{1, 1, 0, 0, 0}, 
                                 {0, 1, 0, 0, 1}, 
                                 {1, 0, 0, 1, 1}, 
                                 {0, 0, 0, 0, 0}, 
                                 {1, 0, 1, 0, 1} 
                                }; 
        NoOfIslands I = new NoOfIslands(5,5);
        System.out.println(I.countNoOfIslands(M));
    }
}