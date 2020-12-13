package testdemo;

/**
 * Creat by wuhui on 2020/10/28
 */
public class Test001
{
    public static void main(String[] args)
    {
        String a = "qwe";
        String b = "qwe1";
        String c = "qweqwe1";
        System.out.println(a+"1" == b);
        System.out.println((a+b) == c);
        System.out.println(c.equals(a+b));
    }
}
