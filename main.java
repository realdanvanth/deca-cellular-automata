import java.util.Random;
import java.util.*;
import java.util.*;
import java.util.Random;
import javax.swing.*;
import java.awt.*;
class test
{
    private Scanner sc=new Scanner(System.in);
    public int a[][]=new int[128*4][128*4];
    int b[][]=new int[128*4][128*4];
    public void fillarray()
    {
        Random random = new Random();
        for(int i = 0; i < a.length; i++)
        {
            
            
            for(int j = 0; j < a[0].length; j++)
            {

                
              int randomNum = random.nextInt(10);
                a[i][j]=randomNum;
            }
        }

        
    }

    public void main()
    {

        //try {
        // Thread.sleep(100);
        // } catch (InterruptedException e) {
        //  e.printStackTrace();
        //}
        // display(a);

        //a[0][0]=1;
        //int n=0;
        //while(n!=999)
        //{

        //  a=iter();
        //  display(a);
        //   try {
        //       Thread.sleep(1);
        //   } catch (InterruptedException e) {
        //       e.printStackTrace();
        //  }

        // }

        int n[][][]=new int [1700][a.length][a[0].length];
        fillarray();

        Random random=new Random();
        for(int i=1;i<1700;i++)
        {

            a=iter();
            n[i]=a;
            
        }

        SwingUtilities.invokeLater(() -> new a1(n));
    }

    public int[][] iter()
    {
        int a1[][]=new int[a.length][a[0].length];
        Random random = new Random();

        for(int i=0;i<a.length;i++)
        {
            for(int j=0;j<a[0].length;j++)
            {
                int hn=random.nextInt(10);
                int gn=random.nextInt();

                
                int p[][];
                if(neighbours(i,j)==1)
                {
                    a1=explode(i,j,a,hn);
                }
                else
                {if(a[i][j]==3)//top right green
                    {
                        if(a[neg(i,0)][pos(j,1)]==0&&a1[neg(i,0)][pos(j,1)]==0)
                        {
                            a1[neg(i,0)][pos(j,1)]=3;
                            a1[i][j]=1;
                        }
                        //else if(a[neg(i,0)][pos(j,1)]==4&&a1[neg(i,0)][pos(j,1)]==0)
                        //{
                        //   p=findzero(i,j,a1);
                        //   a1[p.length-1][p[0].length-1]=3;//smth wrone here ;)
                        //}
                        else if(a[neg(i,0)][pos(j,1)]==0&&gn==1)
                        {
                            a1[neg(i,0)][pos(j,1)]=4;
                        }
                    }

                    if(a[i][j]==4)//down left yellow
                    {
                        if(a[pos(i,0)][neg(j,1)]==0&&a1[pos(i,0)][neg(j,1)]==0)
                        {

                            a1[pos(i,0)][neg(j,1)]=4;
                            a1[i][j]=1;
                        }

                        else if(a[pos(i,0)][neg(j,1)]==0&&gn==1)
                        {
                            a1[pos(i,0)][neg(j,1)]=3;
                        }
                    }

                    if(a[i][j]==5)//top left blue
                    {

                        if(a[neg(i,0)][neg(j,1)]==0&&a1[neg(i,0)][neg(j,1)]==0)
                        {
                            a1[neg(i,0)][neg(j,1)]=5;
                            a1[i][j]=1;//made 0 to 1
                        }

                        else if(a[pos(i,0)][pos(j,1)]==0&&gn==1)//ur here
                        {
                            a1[neg(i,0)][neg(j,1)]=2;
                        }
                    }

                    if(a[i][j]==6)//top orange
                    {
                        if(a[i][neg(j,1)]==0&&a1[i][neg(j,1)]==0)
                        {
                            a1[i][neg(j,1)]=6;
                            a1[i][j]=1;
                        }
                        else if(a[i][neg(j,1)]==0&&gn==1)
                        {
                            a1[i][neg(j,1)]=7;

                        }
                    }

                    if(a[i][j]==7)// down cyan
                    {
                        if(a[i][pos(j,1)]==0&&a1[i][pos(j,1)]==0)
                        {
                            a1[i][pos(j,1)]=7;
                            a1[i][j]=1;//make it 6 here to get cool stuff
                        }
                        else if(a[i][pos(j,1)]==0&&gn==1)
                        {
                            a1[i][pos(j,1)]=6;
                        }
                    }

                    if(a[i][j]==8)//right magenta ig this left
                    {
                        if(a[neg(i,0)][j]==0&&a1[neg(i,0)][j]==0)
                        {
                            a1[neg(i,0)][j]=8;
                            a1[i][j]=1;///made change here
                        }

                        else if(a[neg(i,0)][j]==0&&gn==1)//ur here
                        {
                            a1[neg(i,0)][j]=9;
                        }
                    }
                    if(a[i][j]==2)//down right red
                    {
                        if(a[pos(i,0)][pos(j,1)]==0&&a1[pos(i,0)][pos(j,1)]==0)
                        {
                            a1[pos(i,0)][pos(j,1)]=2;
                            a1[i][j]=1;
                        }
                        else if(a[pos(i,0)][pos(j,1)]==0&&gn==1)
                        {
                            a1[pos(i,0)][pos(j,1)]=5;
                        }
                    }
                    if(a[i][j]==9)//right pink
                    {
                        if(a[pos(i,0)][j]==0&&a1[pos(i,0)][j]==0)
                        {
                            a1[pos(i,0)][j]=9;
                            a1[i][j]=1;
                        }
                        else if(a[pos(i,0)][j]==0&&gn==1)
                        {
                            a1[pos(i,0)][j]=8;
                        }
                    }
                    if(a[i][j]==1&&a1[i][j]==0)
                    {
                        if(a[neg(i,0)][j]==8)
                        {
                            a1[i][j]=8;
                        }

                        else if(a[pos(i,0)][j]==9)
                        {
                            a1[i][j]=9;
                        }

                        else if(a[neg(i,0)][neg(j,1)]==5)
                        {
                            a1[i][j]=5;
                        }

                        else if(a[pos(i,0)][neg(j,1)]==4)
                        {
                            a1[i][j]=4;
                        }

                        else if(a[i][neg(j,1)]==6)
                        {
                            a1[i][j]=6;
                        }

                        else if(a[i][pos(j,1)]==7)
                        {
                            a1[i][j]=7;
                        }

                        else if(a[pos(i,0)][pos(j,1)]==2)
                        {
                            a1[i][j]=2;
                        }

                        else if(a[neg(i,0)][pos(j,1)]==3)
                        {
                            a1[i][j]=3;
                        } 

                        else{
                            a[i][j]=1;
                        }
                    }

                    else if(a[i][j]==1)
                    {
                        int rn=random.nextInt(2);
                        if(a[neg(i,0)][j]==8&&rn==1)
                        {
                            a1[i][j]=8;
                        }

                        else if(a[pos(i,0)][j]==9&&rn==1)
                        {
                            a1[i][j]=9;
                        }

                        else if(a[neg(i,0)][neg(j,1)]==5&&rn==1)
                        {
                            a1[i][j]=5;
                        }

                        else if(a[pos(i,0)][neg(j,1)]==4&&rn==1)
                        {
                            a1[i][j]=4;
                        }

                        else if(a[i][neg(j,1)]==6&&rn==1)
                        {
                            a1[i][j]=6;
                        }

                        else if(a[i][pos(j,1)]==7&&rn==1)
                        {
                            a1[i][j]=7;
                        }

                        else if(a[pos(i,0)][pos(j,1)]==2&&rn==1)
                        {
                            a1[i][j]=2;
                        }

                        else if(a[neg(i,0)][pos(j,1)]==3&&rn==1)
                        {
                            a1[i][j]=3;
                        } 

                        else{
                            a1[i][j]=1;
                        }
                    }
                }
                //if(a1[i][j]==a[i][j])
                //{
                //    for(int k=0;k<a.length;k++)
                //    {
                //        for(int l=0;l<a[0].length;l++)
                //        {
                //           if(a1[k][l]==0&&a[k][l]==0)
                //            {
                //               a1[k][l]=a[i][j];
                //               break;
                //        }
                //    }
                // }
                //                 } 

            }
        }

        return a1;
    }

    public int[][] explode(int i,int j,int n[][],int d)
    {
        n[i][j]=0;
        n[neg(i,0)][j]=d;
        n[pos(i,0)][j]=d;
        n[i][neg(j,1)]=d;
        n[i][pos(j,1)]=d;
        n[neg(i,0)][neg(j,1)]=d;
        n[pos(i,0)][neg(j,1)]=d;
        n[neg(i,0)][pos(j,1)]=d;
        n[pos(i,0)][pos(j,1)]=d;
        return n;
    }

    public int neg(int x,int y)
    {
        if(x==0)
        {
            if(y==0)
                return a.length-1;
            if(y==1)
                return a[0].length-1;
        }
        return x-1;
    }

    public int pos(int x,int y)
    {
        if(y==0&&x==a.length-1)
        {
            return 0;
        }
        if(y==1&&x==a[0].length-1)
        {
            return 0;
        }
        return x+1;
    }

    public int neighbours(int x,int y)
    { 
        int tc=a[neg(x,0)][y];
        int dc=a[pos(x,0)][y];
        int lc=a[x][neg(y,1)];
        int rc=a[x][pos(y,1)];
        int tlc=a[neg(x,0)][neg(y,1)];
        int dlc=a[pos(x,0)][neg(y,1)];
        int trc=a[neg(x,0)][pos(y,1)];
        int drc=a[pos(x,0)][pos(y,1)];
        int c=tc+dc+lc+rc+tlc+dlc+trc+drc;
        if(tc>1&&dc>1&&lc>1&&rc>1&&tlc>1&&dlc>1&&trc>1&&drc>1)
            return 1;
        return 0;
    }

    public int[][] findzero(int i,int j,int a1[][])
    {
        for(int k=i;k<a.length;i++)
        {
            for(int l=j;j<a[0].length;l++)
            {
                if(a[k][l]==0&&a1[k][l]==0)
                {
                    int n[][]=new int [k][l];
                    return n;
                }
            }
        }
        int n1[][]=new int [0][0];
        return n1;
    }
}
