package com.bite;

/**
 * @Author tjy
 * @Date 2020/5/1 17:30
 */

public class bite5_1 {

    static class a{

    }
    static class b extends a{

    }
    static class c extends b{

    }

//    public static void main(String[] args) {
//        a a = new a();
//        a a1 = new b();
//        a a2 = new c();
//    }
    static class Base {

        Base() {

            System.out.print("Base");

        }

    }
    /**
     * 默认构造构造方法为super（）；调用父类的方法
     *
     */
    public static class Alpha extends Base {

        public static void main( String[] args ) {

            new Alpha();

            //调用父类无参的构造方法

            new Base();

        }

    }

    static class Base1{

        public Base1(String s){

            System.out.print("B");

        }

    }

    /**
     * 父类构造函数带有参数时就要自己调用父类构造，并将参数传入，否则编译出错
     */
    public static class Derived extends Base1{

        public Derived (String s) {
            super(s);

            System.out.print("D");

        }

        public static void main(String[] args){

            new Derived("C");

        }

    }

    /**
     * 在new一个类的对象时，先将类中的属性全部实例化，在执行构造方法；
     */
    static class X{
        Y y=new Y();
        public X(){
            System.out.print("X");
        }
        Y y1 = new Y();
    }
    static class Y{
        public Y(){
            System.out.print("Y");
        }
    }
    public static class Z extends X{
        Y y=new Y();
        public Z(){
            System.out.print("Z");
        }
        public static void main(String[] args) {
            new Z();
        }
    }

    /**
     *父类只能调用子类重写的方法，不能调用子类独有的方法。
     */
    static class B {
        public int Func() {
            System.out.print("B");
            return 0;
        }
    }
    static class D extends B {
        @Override
        public int Func() {
            System.out.print("D");
            return 0;
        }
    }
    public static class Test {
        public static void main(String[] args) {
            B a = new B();
            B b = new D();
            a.Func();
            b.Func();
        }
    }

    /**
     * 接口不可以被设置为私有，否则不能被不同的类实现,接口只能被abstr修饰
     * 接口的变量默认为常量 被public static final 修饰。
     */
    abstract interface g{
        public  static final String name = null;
        void a();
    }

    class x implements g{

        @Override
        public void a() {

        }
    }

}

//class e implements bite5_1.g {
//
//    @Override
//    public void a() {
//
//    }
//}