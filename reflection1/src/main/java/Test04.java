import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//通过反射获取对象及操作对象中的属性和方法
public class Test04 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        //获得一个Class对象
        Class c1 = Class.forName("User");

        //构造一个对象
        User user = (User) c1.newInstance();//本质调用类的无参构造器
        System.out.println(user);

        //通过构造器创建对象
        Constructor constructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
        User user1 = (User) constructor.newInstance("李文豪", 19, 180);
        System.out.println(user1);

        //通过反射调用普通方法
        User user2 = (User) c1.newInstance();

        //通过反射获取一个方法
        Method setName = c1.getDeclaredMethod("setName", String.class);
        //这里只能获取public方法的权限，私有方法需要先setAccessible(true),设置权限才能调用
        //invoke:激活的意思
        //方法.invoke（对象，“方法的值”）
        setName.invoke(user2,"lwh");
        System.out.println(user2.getName());

        //通过反射操作属性
        User user3 = (User) c1.newInstance();
        Field name = c1.getDeclaredField("name");

        //和方法同理，不能直接操作私有属性，需要关闭安全监测将setAccessible(true)
        name.setAccessible(true);
        name.set(user3,"lwh2");
        System.out.println(user3.getName());


    }
}
