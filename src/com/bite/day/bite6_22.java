package com.bite.day;

import java.time.Period;
import java.util.*;

/**
 * @Author tjy
 * @Date 2020/6/22 13:19
 */

public class bite6_22 {

    public boolean[] chkSubStr(String[] p, int n, String s) {
        // write code here
        boolean[] b =new boolean[n];
        for (int i = 0; i < n; i++) {
            b[i] = s.contains(p[i]);
        }
        return b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            PriorityQueue<Person> people = null;
            int n = sc.nextInt();
            int option = sc.nextInt();
            if (option == 0){
                people = new PriorityQueue<>((o1, o2) -> o2.target - o1.target);

            }else if(option == 1){
                people = new PriorityQueue<>(Comparator.comparingInt(o -> o.target));
            }
            for (int i = 0; i < n; i++) {
                people.offer(new Person(sc.next(),sc.nextInt()));
            }

            for (int i = 0; i < n; i++) {
                System.out.println(people.poll());
            }
        }
    }
    static class Person{
        String name;
        int target;

        public Person(String name, int target) {
            this.name = name;
            this.target = target;
        }

        @Override
        public String toString() {
            return name + " " + target;
        }
    }
}

 class Main
{
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext())
        {
            int numPeople=scanner.nextInt();
            int option=scanner.nextInt();

            List<Student> stuList=new ArrayList<Student>();
            for(int i=0;i<numPeople;i++)
            {
                stuList.add(new Student(scanner.next(), scanner.nextInt()));
            }

            //降序
            if(option==0)
            {
                Collections.sort(stuList, new Comparator<Student>()
                {
                    public int compare(Student o1,Student o2)
                    {
                        return o2.score-o1.score;
                    }
                });
            }
            else if(option==1)//升序
            {
                Collections.sort(stuList, new Comparator<Student>()
                {
                    public int compare(Student o1,Student o2)
                    {
                        return o1.score-o2.score;
                    }
                });
            }
            for(int i=0;i<stuList.size();i++)
            {
                System.out.println(stuList.get(i).name+" "+stuList.get(i).score);
            }
        }
    }
}

class Student
{
    public String name;
    public int score;
    public Student(String name,int score)
    {
        this.name=name;
        this.score=score;
    }
}
