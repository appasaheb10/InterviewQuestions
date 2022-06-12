package core.java;

public class Parent {
    public void run(){
        System.out.println("Parent run method");
        this.walk();
    }

    public void walk(){
        System.out.println("Parent walk method");
    }
}
