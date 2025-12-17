package io.jsonwebtoken.lang;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public final class Classes {

    private static final io.jsonwebtoken.lang.Classes.ClassLoaderAccessor CLASS_CL_ACCESSOR;
    private static final io.jsonwebtoken.lang.Classes.ClassLoaderAccessor SYSTEM_CL_ACCESSOR;
    private static final io.jsonwebtoken.lang.Classes.ClassLoaderAccessor THREAD_CL_ACCESSOR;

    private interface ClassLoaderAccessor {
        public abstract InputStream getResourceStream(String string);

        public abstract Class loadClass(String string);
    }

    private static abstract class ExceptionIgnoringAccessor implements io.jsonwebtoken.lang.Classes.ClassLoaderAccessor {
        ExceptionIgnoringAccessor(io.jsonwebtoken.lang.Classes.1 classes$1) {
            super();
        }

        @Override // io.jsonwebtoken.lang.Classes$ClassLoaderAccessor
        protected abstract java.lang.ClassLoader doGetClassLoader();

        @Override // io.jsonwebtoken.lang.Classes$ClassLoaderAccessor
        protected final java.lang.ClassLoader getClassLoader() {
            try {
                return doGetClassLoader();
                return null;
            }
        }

        @Override // io.jsonwebtoken.lang.Classes$ClassLoaderAccessor
        public InputStream getResourceStream(String string) {
            InputStream obj2;
            final java.lang.ClassLoader classLoader = getClassLoader();
            if (classLoader != null) {
                obj2 = classLoader.getResourceAsStream(string);
            } else {
                obj2 = 0;
            }
            return obj2;
        }

        @Override // io.jsonwebtoken.lang.Classes$ClassLoaderAccessor
        public Class loadClass(String string) {
            Class obj2;
            final java.lang.ClassLoader classLoader = getClassLoader();
            if (classLoader != null) {
                obj2 = classLoader.loadClass(string);
            } else {
                obj2 = 0;
            }
            return obj2;
        }
    }
    static {
        Classes.1 anon = new Classes.1();
        Classes.THREAD_CL_ACCESSOR = anon;
        Classes.2 anon2 = new Classes.2();
        Classes.CLASS_CL_ACCESSOR = anon2;
        Classes.3 anon3 = new Classes.3();
        Classes.SYSTEM_CL_ACCESSOR = anon3;
    }

    public static <T> Class<T> forName(String string) {
        Class class;
        String string2;
        String str;
        String obj2;
        if (Classes.THREAD_CL_ACCESSOR.loadClass(string) == null) {
            class = Classes.CLASS_CL_ACCESSOR.loadClass(string);
        }
        if (class == null) {
            class = Classes.SYSTEM_CL_ACCESSOR.loadClass(string);
        }
        if (class == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to load class named [");
            stringBuilder.append(string);
            stringBuilder.append("] from the thread context, current, or ");
            stringBuilder.append("system/application ClassLoaders.  All heuristics have been exhausted.  Class could not be found.");
            if (string == null) {
            } else {
                if (!string.startsWith("io.jsonwebtoken.impl")) {
                } else {
                    obj2 = new StringBuilder();
                    obj2.append(stringBuilder.toString());
                    obj2.append("  Have you remembered to include the jjwt-impl.jar in your runtime classpath?");
                    string2 = obj2.toString();
                }
            }
            obj2 = new UnknownClassException(string2);
            throw obj2;
        }
        return class;
    }

    public static <T> Constructor<T> getConstructor(Class<T> class, Class... class2Arr2) {
        try {
            return class.getConstructor(class2Arr2);
            class2Arr2 = new IllegalStateException(class);
            throw class2Arr2;
        }
    }

    public static InputStream getResourceAsStream(String string) {
        InputStream resourceStream;
        if (Classes.THREAD_CL_ACCESSOR.getResourceStream(string) == null) {
            resourceStream = Classes.CLASS_CL_ACCESSOR.getResourceStream(string);
        }
        if (resourceStream == null) {
            resourceStream = Classes.SYSTEM_CL_ACCESSOR.getResourceStream(string);
        }
        return resourceStream;
    }

    public static <T> T instantiate(Constructor<T> constructor, Object... object2Arr2) {
        try {
            return constructor.newInstance(object2Arr2);
            StringBuilder instantiationException = new StringBuilder();
            instantiationException.append("Unable to instantiate instance with constructor [");
            instantiationException.append(constructor);
            constructor = "]";
            instantiationException.append(constructor);
            constructor = instantiationException.toString();
            instantiationException = new InstantiationException(constructor, object2Arr2);
            throw instantiationException;
        }
    }

    public static <T> T invokeStatic(String string, String string2, Class[] class3Arr3, Object... object4Arr4) {
        try {
            final Method obj3 = Classes.forName(string).getDeclaredMethod(string2, class3Arr3);
            obj3.setAccessible(true);
            return obj3.invoke(0, object4Arr4);
            object4Arr4 = new StringBuilder();
            object4Arr4.append("Unable to invoke class method ");
            object4Arr4.append(string);
            string = "#";
            object4Arr4.append(string);
            object4Arr4.append(string2);
            string = ".  Ensure the necessary ";
            object4Arr4.append(string);
            string = "implementation is in the runtime classpath.";
            object4Arr4.append(string);
            string = object4Arr4.toString();
            string2 = new IllegalStateException(string, class3Arr3);
            throw string2;
        }
    }

    public static boolean isAvailable(String string) {
        try {
            Classes.forName(string);
            return 1;
            string = null;
            return string;
        }
    }

    public static <T> T newInstance(Class<T> class) {
        if (class == null) {
        } else {
            return class.newInstance();
        }
        IllegalArgumentException obj4 = new IllegalArgumentException("Class method parameter cannot be null.");
        throw obj4;
    }

    public static <T> T newInstance(Class<T> class, Object... object2Arr2) {
        int i;
        Class class2;
        Class[] arr = new Class[object2Arr2.length];
        i = 0;
        for (Object obj : object2Arr2) {
            arr[i] = obj.getClass();
        }
        return Classes.instantiate(Classes.getConstructor(class, arr), object2Arr2);
    }

    public static <T> T newInstance(String string) {
        return Classes.newInstance(Classes.forName(string));
    }

    public static <T> T newInstance(String string, Class[] class2Arr2, Object... object3Arr3) {
        return Classes.instantiate(Classes.getConstructor(Classes.forName(string), class2Arr2), object3Arr3);
    }

    public static <T> T newInstance(String string, Object... object2Arr2) {
        return Classes.newInstance(Classes.forName(string), object2Arr2);
    }
}
