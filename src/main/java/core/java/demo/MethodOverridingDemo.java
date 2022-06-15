package core.java.demo;
//UnComment the code to understand the overriding rules
//Parent Class
class Parent
{
    void display() throws RuntimeException
    {
        System.out.println("Inside display() method of Parent class");
    }
}
//Child class1
class Child1 extends Parent
{
    @Override
        // no issue while throwing same exception
    void display() throws RuntimeException

    {
        System.out.println("Inside display() method of Child1 class");
    }
}

class Child2 extends Parent
{
    @Override
        //no issue while throwing subclass exception
    void display() throws ArithmeticException
    {
        System.out.println("Inside display() method of Child2 class");
    }
}
class Child3 extends Parent
{
    @Override
        //no issue while not throwing any exception
    void display()
    {
        System.out.println("Inside display() method of Child3 class");
    }
}
/*class Child4 extends Parent
{
    @Override
        //compile-time error
        //issue while throwing parent exception
    void display() throws Exception
    {
        System.out.println("Inside display() method of Child4 class");
    }
}*/
//Driver class
public class MethodOverridingDemo
{
    public static void main(String args[])
    {
        Parent obj = new Child1();
        obj.display();

        obj = new Child2();
        obj.display();

        obj = new Child3();
        obj.display();

        /*obj = new Child4();
        obj.display();*/
    }
}