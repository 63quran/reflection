import com.sun.org.apache.xpath.internal.SourceTree;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

//测试反射获取类信息
public class Test03 {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class user = Class.forName("User");

        //获取类名称
        System.out.println(user.getName());//包名+类名
        System.out.println(user.getSimpleName());//类名

        //获取类的属性
        user.getFields();//只能获得public属性
        for (Field declaredField : user.getDeclaredFields()) {
            System.out.println(declaredField);
        }

        //获取属性的值
        System.out.println("========================================");
        System.out.println(user.getDeclaredField("name"));

        //获取类的方法
        System.out.println("========================================");
        for (Method method : user.getMethods()) {//获得本类以及父类的所有public方法
            System.out.println(method);
        }

        for (Method declaredMethod : user.getDeclaredMethods()) {
            System.out.println(declaredMethod);//获取本类的所有方法
        }


        //获取指定方法
        //第二个参数的必要性：如果有重载的方法，只用方法名找不到，有歧义
        System.out.println("========================================");
        System.out.println(user.getMethod("getName", null));
        System.out.println(user.getMethod("setName", String.class));

        //获得指定的构造器
        System.out.println("========================================");
        Constructor[] constructors = user.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("*" + constructor);
        }

        Constructor[] declaredConstructors = user.getDeclaredConstructors();
        for (Constructor declaredConstructor : declaredConstructors) {
            System.out.println("#" + declaredConstructor);
        }

        //获得指定的构造器
        Constructor declaredConstructor = user.getDeclaredConstructor(String.class, int.class, int.class);
        System.out.println(declaredConstructor);


    }
}
