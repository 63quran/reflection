import java.lang.annotation.*;
import java.lang.reflect.Field;

//通过反射获取注解信息
public class Test07 {

    public static void main(String[] args) throws ClassNotFoundException {
        Class c1 = Class.forName("Student2");
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        //获得注解的值
        Tablelwh annotation = (Tablelwh)c1.getAnnotation(Tablelwh.class);
        String value = annotation.tableNme();
        System.out.println(value);

        Field[] fields = c1.getDeclaredFields();
        for (Field field : fields) {
            Fieldlwh fieldlwh = field.getAnnotation(Fieldlwh.class);
            System.out.println(fieldlwh.columnName());
            System.out.println(fieldlwh.length());
            System.out.println(fieldlwh.type());
            System.out.println("#############################");
        }
    }
}

@Tablelwh(tableNme = "db_test")
class Student2{
    @Fieldlwh(columnName = "db_id",type = "int",length = 10)
    private int id;
    @Fieldlwh(columnName = "db_age",type = "int",length = 5)
    private int age;
    @Fieldlwh(columnName = "db_name",type = "String",length = 20)
    private String name;

    public Student2() {
    }

    public Student2(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student2{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

//表注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Tablelwh{
    String tableNme();
}

//属性注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Fieldlwh{
    String columnName();
    String type();
    int length();
}
