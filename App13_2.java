
//filename��App13_2.java
// ��Ҫ��javac -parameters App13_2.java ����
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
class Person
{
  private String name;
  private int age;
  public Person(String name,int age)
  {
    this.name=name;
    this.age=age;
  }
  public void info(String prof,int score)
  {
    System.out.println("�ҵ�רҵ��"+prof+"����ѧ�ɼ���"+score);
  }
  @Override
  public String toString()
  {
    return "������"+this.name+",���䣺"+this.age;
  }
}
public class App13_2
{
  public static void main(String[] args)   //������
  {
    Class<Person> pc=Person.class;
    try
    {
      Constructor con=pc.getConstructor(String.class,int.class);
      System.out.print("���췽������"+con.getName());
      Class[] pt=con.getParameterTypes();
      for(int i=0;i<pt.length;i++)
        System.out.print("��������"+pt[i].getName());
    }
    catch(NoSuchMethodException e)
    { e.printStackTrace(); }
    Field[] fls=pc.getDeclaredFields();
    for(Field f:fls)
    {
      int mod=f.getModifiers();
      System.out.print("\n��Ա�������η���"+Modifier.toString(mod));
      Class type=f.getType();
      System.out.print("�����ƣ�"+f.getName());
      System.out.print("�����ͣ�"+type.getName());
    }
    System.out.println(" ");
    Method[] mds=pc.getMethods();
    for(Method m:mds)
    {
      System.out.print("������"+m.getName());
      System.out.println(" ����������"+m.getParameterCount());
      Parameter[] pars=m.getParameters();
      int index=1;
      for(Parameter p:pars)
      {
        if(p.isNamePresent())
        {
          System.out.println("----��"+(index++)+"����������Ϣ----");
          System.out.println("��������"+p.getName());
          System.out.println("�������ͣ�"+p.getType());
          System.out.println("�������ͣ�"+p.getParameterizedType());
          System.out.println("----------------------------------------");
        }
      }
    }
  }
}
