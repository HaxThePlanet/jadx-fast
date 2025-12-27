package io.jsonwebtoken.lang;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/* compiled from: Classes.java */
/* loaded from: classes3.dex */
public final class Classes {

    private static final Classes.ClassLoaderAccessor CLASS_CL_ACCESSOR = new Classes$2();
    private static final Classes.ClassLoaderAccessor SYSTEM_CL_ACCESSOR = new Classes$3();
    private static final Classes.ClassLoaderAccessor THREAD_CL_ACCESSOR = new Classes$1();

    private interface ClassLoaderAccessor {
        InputStream getResourceStream(String str);

        Class loadClass(String str);
    }

    private static abstract class ExceptionIgnoringAccessor implements Classes.ClassLoaderAccessor {
        private ExceptionIgnoringAccessor() {
            super();
        }

        protected final java.lang.ClassLoader getClassLoader() {
            try {
            } catch (Throwable unused) {
                return null;
            }
            return doGetClassLoader();
        }

        public InputStream getResourceStream(String str) {
            InputStream resourceAsStream = null;
            final java.lang.ClassLoader classLoader = getClassLoader();
            if (classLoader != null) {
                resourceAsStream = classLoader.getResourceAsStream(str);
            } else {
                int i = 0;
            }
            return resourceAsStream;
        }

        public Class loadClass(String str) {
            int i = 0;
            final java.lang.ClassLoader classLoader = getClassLoader();
            if (classLoader != null) {
                try {
                    Class _class = classLoader.loadClass(str);
                } catch (java.lang.ClassNotFoundException unused) {
                    i = 0;
                }
            }
            return i;
        }

        /* synthetic */ ExceptionIgnoringAccessor() {
            this();
        }

        protected abstract java.lang.ClassLoader doGetClassLoader();
    }

    private Classes() {
        super();
    }

    public static <T> Class<T> forName(String str) throws UnknownClassException {
        Class _class;
        String str2;
        if (Classes.THREAD_CL_ACCESSOR.loadClass(str) == null) {
            _class = Classes.CLASS_CL_ACCESSOR.loadClass(str);
        }
        if (Classes.CLASS_CL_ACCESSOR == null) {
            _class = Classes.SYSTEM_CL_ACCESSOR.loadClass(str);
        }
        if (Classes.SYSTEM_CL_ACCESSOR == null) {
            StringBuilder stringBuilder = new StringBuilder();
            String str5 = "Unable to load class named [";
            String str6 = "] from the thread context, current, or ";
            str3 = "system/application ClassLoaders.  All heuristics have been exhausted.  Class could not be found.";
            str2 = str5 + str + str6 + str3;
            if (str == null) {
                throw new UnknownClassException(str2);
            } else {
                str3 = "io.jsonwebtoken.impl";
                if (str.startsWith(str3)) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    String str4 = "  Have you remembered to include the jjwt-impl.jar in your runtime classpath?";
                    str2 = str2 + str4;
                }
            }
        }
        return _class;
    }

    public static <T> Constructor<T> getConstructor(Class<T> cls, Class... clsArr) {
        try {
        } catch (java.lang.NoSuchMethodException noSuchMethod) {
            clsArr = new IllegalStateException(noSuchMethod);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) clsArr;
        }
        return cls.getConstructor(clsArr);
    }

    public static InputStream getResourceAsStream(String str) {
        InputStream resourceStream;
        if (Classes.THREAD_CL_ACCESSOR.getResourceStream(str) == null) {
            resourceStream = Classes.CLASS_CL_ACCESSOR.getResourceStream(str);
        }
        if (Classes.THREAD_CL_ACCESSOR == null) {
            resourceStream = Classes.SYSTEM_CL_ACCESSOR.getResourceStream(str);
        }
        return resourceStream;
    }

    public static <T> T instantiate(Constructor<T> constructor, Object... objectArr) throws java.lang.InstantiationException, java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException, InstantiationException {
        try {
        } catch (Exception e) {
            StringBuilder instantiationException = new InstantiationException();
            String str = "Unable to instantiate instance with constructor [";
            constructor = "]";
            constructor = str + constructor + constructor;
            instantiationException = new InstantiationException(constructor, e);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) instantiationException;
        }
        return constructor.newInstance(objectArr);
    }

    public static <T> T invokeStatic(String str, String str2, Class[] clsArr, Object... objectArr) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.reflect.InvocationTargetException {
        try {
            final Method declaredMethod = Classes.forName(str).getDeclaredMethod(str2, clsArr);
            declaredMethod.setAccessible(true);
        } catch (Exception e) {
            objectArr = new StringBuilder();
            objectArr.append("Unable to invoke class method ");
            objectArr.append(str);
            str = "#";
            objectArr.append(str);
            objectArr.append(str2);
            str = ".  Ensure the necessary ";
            objectArr.append(str);
            str = "implementation is in the runtime classpath.";
            objectArr.append(str);
            str = objectArr.toString();
            str2 = new IllegalStateException(str, e);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) str2;
        }
        return declaredMethod.invoke(null, objectArr);
    }

    public static boolean isAvailable(String str) {
        try {
            Classes.forName(str);
        } catch (io.jsonwebtoken.lang.UnknownClassException unused) {
            str = null;
            return str;
        }
        return true;
    }

    public static <T> T newInstance(String str) {
        return Classes.newInstance(Classes.forName(str));
    }

    public static <T> T newInstance(String str, Class[] clsArr, Object... objectArr) {
        return Classes.instantiate(Classes.getConstructor(Classes.forName(str), clsArr), objectArr);
    }

    public static <T> T newInstance(String str, Object... objectArr) {
        return Classes.newInstance(Classes.forName(str), objectArr);
    }

    public static <T> T newInstance(Class<T> cls) throws java.lang.InstantiationException, InstantiationException, java.lang.IllegalAccessException {
        if (cls == null) {
            throw new IllegalArgumentException("Class method parameter cannot be null.");
        } else {
            try {
            } catch (Exception e) {
                StringBuilder stringBuilder = new StringBuilder();
                String str2 = "Unable to instantiate class [";
                cls = cls.getName();
                cls = "]";
                cls = str2 + cls + cls;
                throw new InstantiationException(cls, e);
            }
            return cls.newInstance();
        }
    }

    public static <T> T newInstance(Class<T> cls, Object... objectArr) {
        int i = 0;
        Class[] arr = new Class[objectArr.length];
        i = 0;
        while (i < objectArr.length) {
            arr[i] = objectArr[i].getClass();
            i = i + 1;
        }
        return Classes.instantiate(Classes.getConstructor(cls, arr), objectArr);
    }
}
