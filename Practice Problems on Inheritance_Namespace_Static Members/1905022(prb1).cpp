#include <iostream>
#include <stdio.h>
#include<string.h>
using namespace std;

namespace infrastructure
{
    class pool
    {
    int height, width, depth;
    char painted_color[10];
    public:
    void set_properties(int h, int w, int d, char *pc)
    {
        height=h;
        width=w;
        depth=d;
        strcpy(painted_color,pc);
    }
    void show()
    {
        cout<<"Dimensions: "<<height<<"X"<<width<<"X"<<depth<<"X"<<endl;
        cout<<"painting Color: "<<painted_color<<endl;
    }
    };
}

namespace sports
{
    class pool
    {
        char table_ingredient[20];
        char table_color[10];
        public:
        void set_properties(char *ti, char* tc)
        {
            strcpy(table_ingredient,ti);
            strcpy(table_color,tc);
        }
        void show()
        {
            cout<<"Table Ingredient: "<<table_ingredient<<endl;
            cout<<"Table Color: "<<table_color<<endl;
        }
    };
}

int main()
{

    using namespace infrastructure;//::pool ob1;
    pool ob1;
    ob1.set_properties(10,12,20,"Blue");
    ob1.show();
    using sports::pool ;//
    pool ob2;
    ob2.set_properties("Wood","Red");
    ob2.show();
    return 0;
}
