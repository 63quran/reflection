public class Test02 {

    public static void main(String[] args) throws ClassNotFoundException {
        //获取系统类加载器
        ClassLoader cl  = ClassLoader.getSystemClassLoader();
        System.out.println(cl);

        //获取系统类加载器的父类加载器-->扩展类加载器
        ClassLoader parent = cl.getParent();
        System.out.println(parent);

        //获取扩展类加载器的父类加载器-->跟加载器(c/c++)
        ClassLoader classLoader = Class.forName("Test02").getClassLoader();
        System.out.println(classLoader);

        //测试JDK内置的类是谁加载的
        classLoader = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(classLoader);

        //如何获得系统类加载器可以加载的路径
        System.out.println(System.getProperty("java.class.path"));

    }
}
