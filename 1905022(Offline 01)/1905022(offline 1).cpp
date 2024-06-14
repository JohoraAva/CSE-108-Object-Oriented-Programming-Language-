#include<iostream>
#include<cmath>


using namespace std;

class Point
{
    int x,y;//x y coordinate
public:
    Point()
    {
        x=0;
        y=0;
    }
    Point(int a,int b)
    {
        x=a;
        y=b;
    }
    ///set get
    void setx(int a)
    {
        x=a;
    }
    void sety(int a)
    {
        y=a;
    }
    int getx()
    {
        return x;
    }

    int gety()
    {
        return y;
    }
    void print()
    {
        cout<<"Coordinate: "<<x<<", "<<y<<endl;
    }

};

class Circle
{
    Point p;
    int radius;
public:
    Circle(int a,int b,int r)
    {
        radius=r;

        p.setx(a);
        p.sety(b);
    }
    void print()
    {
        cout<< "Center ";
        p.print();
        cout<<"Radius: "<<radius<<endl;
    }

     void update(int a,int b)
    {
        p.setx(p.getx()+a);
        p.sety(p.gety()+b);
    }
    void update(int a)
    {
       radius+=a;
    }
    void update(int a,int b,int c)
    {
        p.setx(p.getx()+a);
        p.sety(p.gety()+b);
        radius= radius+c;
    }
};


class Line
{
    Point p1,p2;
public:
    Line(int a1,int b1,int a2,int b2)
    {
       p1.setx(a1);
       p1.sety(b1);

       p2.setx(a2);
       p2.sety(b2);
    }

    double len()
    {
        ///length
        return sqrt((p1.getx()-p2.getx())*(p1.getx()-p2.getx())+(p1.gety()-p2.gety())*(p1.gety()-p2.gety()));
    }
};
int main()
{
    Point p(5,5);
    Circle c(2,3,5);

    cout<<endl<<"Point Display"<<endl;
    p.print();

    cout<<endl<<"Circle Display"<<endl;
    c.print();
    cout<<endl;


    //First update
    cout<<"First Update"<<endl;
    c.update(5,5);
    c.print();
    cout<<endl;

    //Second update
    cout<<"Second Update"<<endl;
    c.update(6);
    c.print();
    cout<<endl;


    //Third update
    cout<<"Third Update"<<endl;
    c.update(2,2,2);
    c.print();
    cout<<endl;

    ///determining length of a line

    Line l(1,1,4,4);
    cout<<"Line Display:"<<endl<<"Length of the line: "<<l.len()<<endl;

    return 0;
}
