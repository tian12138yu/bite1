package com.bite;



import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.*;

/**
 * @Author tjy
 * @Date 2020/6/1 15:45
 */

class Person{
    private int id;

    public Person(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return id == person.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
public class test {

    public static void main1(String[] args) {
//        MyHashMap myHashMap = new MyHashMap();
//        for (int i = 0; i < 7; i++) {
//            myHashMap.put(new Person(i),i);
//        }
//        myHashMap.put(new Person(11),11);
//        int o = (int) myHashMap.get(new Person(3));
//        System.out.println(o);
//        HashMap<Person, Integer> map = new HashMap<>();
//        for (int i = 0; i < 7; i++) {
//            map.put(new Person(i),i);
//        }
//        Integer integer = map.get(new Person(3));
//        System.out.println(integer);
//        StringBuilder a = new StringBuilder("a");
//        a.insert(1,"b");
//        System.out.println(a.toString());
        Person person = new Person(122);
        Integer[] a = {2,5,6,32,4,2};
        List<Integer> ints = Arrays.asList(a);
        /**
         * Arrays.aslist使用：数组必须为包装类
         * 如果是基本数据类型则返回值的泛型为基本数据数组类型不是基本数据类型。
         */
        String[] userid = {"aa","bb","cc"};
        List<String> userList = Arrays.asList(userid);
    }

    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc. nextInt();
        int count1 = 1;
        int count2 = 1;
        while (count1 + count2 <= n){
            int temp = count1;
            count1 = count2;
            count2 = temp + count2;
        }
        if (count1 + count2 == n){
            System.out.println(0);
        }
        System.out.println(Math.min(n - count2, count1 + count2 - n));
    }

    public static void main3(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (sc.hasNext()){
            sb.append(sc.nextLine()+ " ");
        }
        String[] s = sb.toString().split(" ");
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < s.length; i++) {
            set.add(s[i]);
        }
        System.out.println(set.size());
    }

    public static void main4(String[] args) {
        BigDecimal bigDecimal = new BigDecimal(5);
        System.out.println(bigDecimal.toString());
    }

    public static void main5(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1,1);
        System.out.println(map.get(2));
    }

    public static void main6(String[] args) {
//        String s1 = "计算机" + "软件";
//        String s5 = new StringBuilder("计算机").append("软件").toString();
        String s5 = new StringBuilder("计算机").append("aa").toString();
        String s = "计算机";
        System.out.println(s5 == s5.intern());
        System.out.println(s == s.intern());

//        System.out.println(s1.intern() == s1);
//        String s = "ja" + "va";
//        System.out.println(s.intern() == s);
////        String s2 = "aa";
////        String s3 = "bb";
//        String s4 = "aabb";
//        System.out.println("aa" + "bb" == s4);
    }

    public static void main7(String[] args) {
        char c = 'A';
        char a = (char) (c -5);
        System.out.println(a);
    }

    public static void main8(String[] args) {
        /*String s = "";
        String[] split1 = s.split(":////");
        String xieyi = split1[0];
        for (int i = 0; i < split1[0].length(); i++) {

        }*/
//        int a = 96;
//        char c = (char) a;
//        System.out.println(c);
//        new ConcurrentHashMap<>();
//        char c = '1';
//        int x = c -'0';
//        System.out.println(x);
        PriorityQueue<Integer> integers = new PriorityQueue<>();
        integers.offer(1);
        integers.offer(5);
        integers.offer(9);
        integers.remove(5);
        for (int x : integers){
            System.out.println(x);
        }
    }

    public static void main9(String[] args) {
        StringBuilder sb = new StringBuilder("dadada");
        StringBuilder y = sb.insert(5, "y");
        StringBuilder x = sb.insert(0, "x");
        System.out.println(y.toString() + " " + x.toString());
    }

    public static void main10(String[] args) {
        FutureTask<Integer> integerFutureTask = new FutureTask<>(new a());
        Thread thread = new Thread(integerFutureTask);
        thread.start();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.execute(() -> {});
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
    }

    static class a implements Callable<Integer>{

        @Override
        public Integer call() throws Exception {
            System.out.println("我是callable");
            return 111;
        }
    }

    public static void main11(String[] args) {
        char c = '5';
        System.out.println(c + 1);
    }

    static class A  implements Runnable{
        Object a;
        Object b;

        public A(Object a, Object b) {
            this.a = a;
            this.b = b;
        }
        @Override
        public void run() {
            synchronized (a){
                System.out.println(Thread.currentThread().getName());
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (b){
                    System.out.println(Thread.currentThread().getName());
                }
            }
        }
    }

    public static void main12(String[] args) {
        Object a = new Object();
        Object b = new Object();

        new Thread(new A(a,b)).start();
        new Thread(new A(b,a)).start();

    }

    public static void main456(String[] args) {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 2,
                TimeUnit.SECONDS, new LinkedBlockingQueue<>(5));
        threadPoolExecutor.execute(() -> System.out.println("aaa"));
        System.out.println(5 & 4);

    }

    public static void main31232(String[] args) {
        Person[] ps = new Person[2];
        Person person1 = new Person(2);
        ps[0] = person1;
        Person p2 = new Person(3);
        ps[1] = p2;
        Person[] people = Arrays.copyOf(ps, 2);
        p2.setId(10);
        System.out.println(people[1].getId());
    }

    public static void main312(String[] args) {
        System.out.println(Integer.MAX_VALUE);

        double v = Math.pow(2, 31) - 1;
        System.out.println(v);
        int x = 2147483647;
        int count = 0;
        while (x != 0){

            x = x >>>1;
            count++;
        }

        System.out.println(count);

    }

    public static void main321(String[] args) {
        Set<String> set = new HashSet<>();
        String a = new String("a");
        String a1 = new String("a");
        set.add(a);
        set.add(a1);
        for (String s : set){
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        String s1 = "hello";
        s1 += "world";//string 的 + 操作返回的是一个新的对象
        String s2 = "helloworld";
        System.out.println(s1 == s2);
    }

}

















