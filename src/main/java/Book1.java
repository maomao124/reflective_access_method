import org.jetbrains.annotations.NotNull;

/**
 * Project name(项目名称)：反射访问方法
 * Package(包名): PACKAGE_NAME
 * Class(类名): Book1
 * Author(作者）: mao
 * Author QQ：1296193245
 * Date(创建日期)： 2021/10/26
 * Time(创建时间)： 22:11
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Book1
{
    // static 作用域方法
    static void staticMethod()
    {
        System.out.println("执行staticMethod()方法");
    }

    // public 作用域方法
    public int publicMethod(int i)
    {
        System.out.println("执行publicMethod()方法");
        return 100 + i;
    }

    // protected 作用域方法
    protected int protectedMethod(String s, int i) throws NumberFormatException
    {
        System.out.println("执行protectedMethod()方法");
        return Integer.parseInt(s) + i;
    }

    // private 作用域方法
    private  String privateMethod(String... strings)
    {
        System.out.println("执行privateMethod()方法");
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < sb.length(); i++)
        {
            sb.append(strings[i]);
        }
        return sb.toString();
    }
}
