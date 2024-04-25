package Functionalnterface;

public class A extends JavaInheritance{
    int sum=200;
    void m1(){
        System.out.println("m1 A");
    }
    void m2(){
        System.out.println("m2 A");
    }

    int subt(int a , int b) {
        return a-b;
    }
    public static void main(String[] args){
        JavaInheritance e = new A();
        System.out.println(e.add(1,2));
        A a  = new A();
        System.out.println(a.add(1,2));

        e.m2();
        System.out.println(e.sum);
    }
}
