#include <iostream>
#include <stdio.h>
#include<string.h>

using namespace std;

class personalInfo
{
    protected:
        char    name[30];
        int     employeeId;
        char    gender;
    public:
        personalInfo(char *pName, int eId, char g)
        {
            strcpy(name, pName);
            employeeId = eId;
            gender = g;
        }
        void showPersonalInfo(void)
        {
            cout<<"==Showing details information of employee: "<<name<<"=="<<endl;
            cout<<"Showing personalInformation: "<<endl;
            cout << "Name: "<< name<<endl;
            cout << "Employee Id: "<<employeeId<<endl;
            cout << "Gender: "<<gender<<endl;
        }
};


class departmentInfo
{

    protected:
        char    deptName[30];
        char    assignedWork[30];
    public:
        departmentInfo(char *dName, char* aw)
        {
            strcpy(deptName, dName);
            strcpy(assignedWork, aw);
        }
        void showDepartmentalInfo(void)
        {
            cout<<"Showing Departmental Information: "<<endl;
            cout << "Department Name: "<<deptName<<endl;
            cout << "Assigned work: "<<assignedWork<<endl;
        }
};

///employee class definition
/* Copy the definition of employee class from the previous problem*/
class employee: public personalInfo, public departmentInfo
{
    int year;
public:

    employee(char *name,int id,char g,char *depname,char *aw,int year): personalInfo(name, id, g),departmentInfo(depname,aw)
    {
        this->year=year;
    }

     void showEmployeeInfo()
    {
        showPersonalInfo();
        showDepartmentalInfo();
    }
};
///Write an employee class that inherits employee class
///Additionally, it keeps the information about per hour salary (integer)
/* Write Code Here */

class serverMaintenanceOfficer:public employee
{
    int salary;
public:

    serverMaintenanceOfficer(char *name,int id,char gen,char *depname, char *aw,int year,int salary):employee(name,id, gen, depname,  aw, year)
    {
        this->salary=salary;
    }
    void showEmployeeInfo()
    {
        showPersonalInfo();
        showDepartmentalInfo();
        cout<<"Per hour salary: "<<salary<<endl;

    }
};

int main()
{
    employee emp1("A",1,'m',"CSE","Office Cleaning", 1995); //name, employeeId, gender, department name, assigned work, and joining year
    employee emp2("B",2,'f',"EEE","Typing", 1997); //name, employeeId, gender, department name, assigned work, and joining year

    emp1.showEmployeeInfo();
    emp2.showEmployeeInfo();

    serverMaintenanceOfficer smo1("C",11,'m',"ME","Office Hour Maintenance", 2015, 1200); //name, employeeId, gender, department name, assigned work, joining year, and per hour salary
    serverMaintenanceOfficer smo2("D",12,'f',"CE","Off Hour Maintenance", 2012, 1250); //name, employeeId, gender, department name, assigned work, and joining year, and per hour salary

    smo1.showEmployeeInfo();
    smo2.showEmployeeInfo();
    return 0;
}
