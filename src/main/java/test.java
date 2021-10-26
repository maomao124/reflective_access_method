import java.lang.reflect.Method;

/**
 * Project name(项目名称)：反射访问方法
 * Package(包名): PACKAGE_NAME
 * Class(类名): test
 * Author(作者）: mao
 * Author QQ：1296193245
 * Date(创建日期)： 2021/10/26
 * Time(创建时间)： 22:14
 * Version(版本): 1.0
 * Description(描述)：
 * 静态方法名称	说明
 * getName()	获取该方法的名称
 * getParameterType()	按照声明顺序以 Class 数组的形式返回该方法各个参数的类型
 * getReturnType()	以 Class 对象的形式获得该方法的返回值类型
 * getExceptionTypes()	以 Class 数组的形式获得该方法可能抛出的异常类型
 * invoke(Object obj,Object...args)	利用 args 参数执行指定对象 obj 中的该方法，返回值为 Object 类型
 * isVarArgs()	查看该方法是否允许带有可变数量的参数，如果允许返回 true，否则返回 false
 * getModifiers()	获得可以解析出该方法所采用修饰符的整数
 */

public class test
{
    public static void main(String[] args)
    {
        //------------------------------------------------------
        long startTime = System.nanoTime();   //获取开始时间
        //------------------------------------------------------
        // 获取动态类Book1
        Book1 book = new Book1();
        Class class1 = book.getClass();
        // 获取Book1类的所有方法
        Method[] declaredMethods = class1.getDeclaredMethods();
        for (int i = 0; i < declaredMethods.length; i++)
        {
            Method method = declaredMethods[i];
            System.out.println("方法名称为：" + method.getName());
            System.out.println("方法是否带有可变数量的参数：" + method.isVarArgs());
            System.out.println("方法的参数类型依次为：");
            // 获取所有参数类型
            Class[] methodType = method.getParameterTypes();
            for (int j = 0; j < methodType.length; j++)
            {
                System.out.println(" " + methodType[j]);
            }
            // 获取返回值类型
            System.out.println("方法的返回值类型为：" + method.getReturnType());
            System.out.println("方法可能抛出的异常类型有：");
            // 获取所有可能抛出的异常
            Class[] methodExceptions = method.getExceptionTypes();
            for (int j = 0; j < methodExceptions.length; j++)
            {
                System.out.println(" " + methodExceptions[j]);
            }
            boolean isTurn = true;
            while (isTurn)
            {
                try
                { // 如果该成员变量的访问权限为private，则抛出异常
                    isTurn = false;
                    if (method.getName().equals("staticMethod"))
                    { // 调用没有参数的方法
                        method.invoke(book);
                    }
                    else if (method.getName().equals("publicMethod"))
                    { // 调用一个参数的方法
                        System.out.println("publicMethod(10)的返回值为：" + method.invoke(book, 10));
                    }
                    else if (method.getName().equals("protectedMethod"))
                    { // 调用两个参数的方法
                        System.out.println("protectedMethod(\"10\",15)的返回值为：" + method.invoke(book, "10", 15));
                    }
                    else if (method.getName().equals("privateMethod"))
                    { // 调用可变数量参数的方法
                        Object[] parameters = new Object[]{new String[]{"1", "2", "3", "4"}};
                        System.out.println("privateMethod()的返回值为：" + method.invoke(book, parameters));
                    }
                }
                catch (Exception e)
                {
                    System.out.println("在设置成员变量值时抛出异常，下面执行setAccessible()方法");
                    method.setAccessible(true); // 设置为允许访问private方法
                    isTurn = true;
                }
            }
            System.out.println("=============================\n");
        }
        //------------------------------------------------------
        long endTime = System.nanoTime(); //获取结束时间
        if ((endTime - startTime) < 1000000)
        {
            double final_runtime;
            final_runtime = (endTime - startTime);
            final_runtime = final_runtime / 1000;
            System.out.println("算法运行时间： " + final_runtime + "微秒");
        }
        else if ((endTime - startTime) >= 1000000 && (endTime - startTime) < 10000000000L)
        {
            double final_runtime;
            final_runtime = (endTime - startTime) / 1000;
            final_runtime = final_runtime / 1000;
            System.out.println("算法运行时间： " + final_runtime + "毫秒");
        }
        else
        {
            double final_runtime;
            final_runtime = (endTime - startTime) / 10000;
            final_runtime = final_runtime / 100000;
            System.out.println("算法运行时间： " + final_runtime + "秒");
        }
        Runtime r = Runtime.getRuntime();
        float memory;
        memory = r.totalMemory();
        memory = memory / 1024 / 1024;
        System.out.printf("JVM总内存：%.3fMB\n", memory);
        memory = r.freeMemory();
        memory = memory / 1024 / 1024;
        System.out.printf(" 空闲内存：%.3fMB\n", memory);
        memory = r.totalMemory() - r.freeMemory();
        memory = memory / 1024 / 1024;
        System.out.printf("已使用的内存：%.4fMB\n", memory);
        //------------------------------------------------------
    }
}
