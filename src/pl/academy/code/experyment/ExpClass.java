package pl.academy.code.experyment;

import pl.academy.code.exceptions.InnyException;

public class ExpClass {
    public static void a() {
        System.out.println("A");
        ExpClass.b();
    }

    public static void b() {
        System.out.println("B");
        ExpClass.c();
    }

    public static void c() {
        System.out.println("C");
        ExpClass.d();
    }

    public static void d() {
        throw new InnyException();
        //System.out.println("D");
    }

    public static int strong(int a) {
        if(a == 1) {
            return 1;
        }
        return a * ExpClass.strong(a-1);
    }
}
