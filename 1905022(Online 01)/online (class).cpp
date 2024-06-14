#include<bits/stdc++.h>
#include<cstdlib>

using namespace std;

class Matrix
{
    int row,col;
    int **mat;
public:

    Matrix(int a,int b)
    {
        row=a;
        col=b;

        int i,j;

        mat=new int*[row];
        for(i=0;i<row;i++)
            mat[i]=new int[col];

       // mat=(int**)malloc(row*sizeof(int*));
            //mat[i]=(int*)malloc(col*sizeof(int));
    }
    ~Matrix()
    {
        for(int i=0;i<row;i++)
            delete mat[i];
            //free(mat[i]);
        delete mat;
       // free(mat);
    }

    void print()
    {
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                cout<<mat[i][j]<<" ";
            }
            cout<<endl;
        }
    }
    void set(int r,int c,int v)
    {
        mat[r][c]=v;
    }

    int  get(int r,int c)
    {
        return mat[r][c];
    }

    void add(int n)
    {
        int i,j;
        for(i=0;i<row;i++)
        {
            for(j=0;j<col;j++)
                mat[i][j]+=n;
        }

    }

    int add()
    {
        int s=0,i,j;
        for(i=0;i<row;i++)
        {
            for(j=0;j<col;j++)
                s+=mat[i][j];
        }

        return s;

    }

};
int main()
{

    cout<<"Hello World"<<'\n';
    Matrix m(3,3);

    for(int i=0;i<3;i++)
        for(int j=0;j<3;j++)
            m.set(i,j,i+j);

    m.print();

    cout<<m.get(0,0)<<'\n';
    m.set(0,0,100);

    cout<<m.get(0,0)<<'\n';

    m.add(100);
    m.print();

    cout<<m.add()<<'\n';


    return 0;
}
