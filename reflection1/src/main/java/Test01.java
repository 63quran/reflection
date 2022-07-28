public class Test01 {

    static {
        System.out.println("main被加载");
    }

    public static void main(String[] args) {
        Son son = new Son();
    }
}


class Father{

    static int b = 2;

    static {
        System.out.println("父类被加载");
    }
}

class Son extends Father{

    static {
        System.out.println("子类被加载");
        m = 300;
    }

    static int m = 100;
    static final int M =1;

}