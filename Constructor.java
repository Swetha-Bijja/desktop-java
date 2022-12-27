package pack1.Ex;

import java.util.*;

import pack.srcpack.pack1.Ex;

public class Constructor {
    static String a;
    int id;
    String name, sub;
    {
        System.out.println(id + name + sub);
    }

    Constructor() {
        System.out.println(id + name);
    }

    Constructor(int id) {
        this.id = id;
        System.out.println(id);
    }

    Constructor(String name, String sub) {
        this.name = name;
        this.sub = sub;
        System.out.println(id + " " + name);
    }

    Constructor(int id, String name, String sub) {
        this(id);
        this.id = id;
        this.name = name;
        this.sub = sub;
        System.out.println(id + " " + name + " " + sub);
    }

    public static void main(String args[]) {
        System.out.println(a);
        Ex e = new Ex();
        System.out.println(e.c);
        Constructor s = new Constructor();
        Constructor s1 = new Constructor(1, "Sai", "Math");
    }
}
