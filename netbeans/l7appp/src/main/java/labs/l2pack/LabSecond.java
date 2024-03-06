package labs.l2pack;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
public class LabSecond {
    public static String doLab() {
        String s = "";
        StringBuilder bS = new StringBuilder(s);
        try {
            Method[] m = Box.class.getDeclaredMethods();
            for (int i = 0;i<m.length;i++){
                Method a = m[i];
                if(a.isAnnotationPresent(MyAnno.class)){
                    a.setAccessible(true);
                    MyAnno anno = (MyAnno)a.getAnnotation(MyAnno.class);
                    for(int j=0;j< anno.value();j++){
                        if(a.getParameterCount()==1){
                            bS.insert(bS.length(),a.invoke((Box) null, j).toString()+'\n');
                        } else if (a.getParameterCount()==2) {
                            bS.insert(bS.length(),a.invoke((Box)null, j, j+1).toString()+'\n');
                        } else if (a.getParameterCount()==0) {
                            bS.insert(bS.length(),a.invoke((Box) null).toString()+'\n');
                        }
                    }

                }
            }
        } catch (InvocationTargetException | IllegalAccessException var4) {
            bS.insert(bS.length(),"Метод не найден."+'\n');
        }
        return bS.toString();
    }
}