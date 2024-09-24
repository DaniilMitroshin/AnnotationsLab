package lab2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Random;
import java.security.InvalidParameterException;


class InvokeMethodHandler {
    public void invokeAnnotatedMethods(Object object) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        Class<?> sampleClass = object.getClass();
        Method[] methods = sampleClass.getDeclaredMethods();

        for (Method method: methods) {
            if (method.isAnnotationPresent(InvokeMethod.class)) {
                if (Modifier.isPublic(method.getModifiers())) {
                    continue;
                }
                method.setAccessible(true);
                for (int i = 0; i < method.getAnnotation(InvokeMethod.class).numberInvoking(); i++) {
                    Object[] parameters = getParameters(method);
                    method.invoke(object, parameters);
                }
                method.setAccessible(false);
            }
        }
    }

    private Object[] getParameters(Method method) throws InstantiationException, IllegalAccessException {
        Object[] parameters = new Object[method.getParameterCount()];
        Random random = new Random();

        for (int i = 0; i < parameters.length; ++i) {
            if (method.getParameters()[i].getType().equals(int.class)) {
                parameters[i] = random.nextInt(0,500);
            }
            else if (method.getParameters()[i].getType().equals(String.class)) {
                parameters[i] = "Gatchina";
            }
            else if (method.getParameters()[i].getType().equals(CustomClass.class)) {

                try {
                    Constructor<?> constructor = method.getParameterTypes()[i].getConstructor(String.class);
                    parameters[i] = constructor.newInstance("\nmy string parametr");
                } catch (Exception e) {
                    e.printStackTrace();
                }



            } else  {
                //System.out.println("Another type of arg!");
                throw new InvalidParameterException();
            }
        }
        return parameters;
    }
}

//parameters[i] = method.getParameterTypes()[i].class.getConstructor(String.class);
//parameters[i] = method.getParameterTypes()[i].getDeclaredConstructors()[0];
//parameters[i] = new CustomClass("a");
//parameters[i] = paramTypes[i].getConstructor().newInstance();
//method.getParameters()[i].getType().getConstructor()
//Class<? extends CustomClass> constructor() default CustomClass.class
//Object first = method.getParameterTypes()[i];
//Class b = first.getClass();
//Constructor cons = b.getConstructor(String.class);
//CustomClass a = new CustomClass("12345678");
//parameters[i] = a;
