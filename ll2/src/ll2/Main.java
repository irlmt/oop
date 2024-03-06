package ll2;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
public class Main {
    public static void main(String[] args) {
        try {
            Method[] m = Box.class.getDeclaredMethods();
            for (int i = 0;i<m.length;i++){
                Method a = m[i];
                if(a.isAnnotationPresent(MyAnno.class)){
                    a.setAccessible(true);
                    MyAnno anno = (MyAnno)a.getAnnotation(MyAnno.class);
                    for(int j=0;j< anno.value();j++){
                        if(a.getParameterCount()==1){
                            a.invoke((Box) null, j);
                        } else if (a.getParameterCount()==2) {
                            a.invoke((Box)null, j, j+1);
                        } else if (a.getParameterCount()==0) {
                            a.invoke((Box) null);
                        }
                    }

                }
            }
        } catch (InvocationTargetException | IllegalAccessException var4) {
            System.out.println("Метод не найден.");
        }
            /*Method m1 = Box.class.getDeclaredMethod("getWidthMul", double.class);
            MyAnno anno = (MyAnno)m1.getAnnotation(MyAnno.class);
            for(int i = 0; i < anno.value(); i++){
                m1.invoke((Box) null, i);
            }

            Method m2 = Box.class.getDeclaredMethod("getVolumeSum", double.class, double.class);
            anno = (MyAnno)m2.getAnnotation(MyAnno.class);
            for(int i = 0; i < anno.value(); i++){
                m2.invoke((Box)null, i, i+1);
            }
            Method m3 = Box.class.getDeclaredMethod("checkWidth");
            m3.setAccessible(true);
            anno = (MyAnno)m3.getAnnotation(MyAnno.class);
            for(int i = 0; i < anno.value(); i++){
                m3.invoke((Box) null);
            }*/

    }
}