package core.java;

public class Child extends Parent {
    public void run(){
        System.out.println("Child run method");
        walk();
        super.run();
    }

    public void walk() {
        System.out.println("Child walk method");
    }

    public static void main(String[] args) {
        Child child = new Child();
        child.run();
    }
}
