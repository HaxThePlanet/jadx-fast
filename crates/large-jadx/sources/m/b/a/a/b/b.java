package m.b.a.a.b;

import java.util.Hashtable;
import java.util.StringTokenizer;
import org.mp4parser.aspectj.lang.a.a;

/* compiled from: Factory.java */
/* loaded from: classes3.dex */
public final class b {

    static Hashtable e;
    private static Object[] f;
    static /* synthetic */ Class g;
    Class a;
    java.lang.ClassLoader b;
    String c;
    int d = 0;
    static {
        Hashtable hashtable = new Hashtable();
        b.e = hashtable;
        hashtable.put("void", Void.TYPE);
        b.e.put("boolean", Boolean.TYPE);
        b.e.put("byte", Byte.TYPE);
        b.e.put("char", Character.TYPE);
        b.e.put("short", Short.TYPE);
        b.e.put("int", Integer.TYPE);
        b.e.put("long", Long.TYPE);
        b.e.put("float", Float.TYPE);
        b.e.put("double", Double.TYPE);
        b.f = new Object[0];
    }

    public b(String str, Class cls) {
        super();
        this.c = str;
        this.a = cls;
        this.b = cls.getClassLoader();
    }

    static /* synthetic */ Class a(String str) {
        try {
        } catch (java.lang.ClassNotFoundException classNotFound) {
            classNotFound = classNotFound.getMessage();
            throw new NoClassDefFoundError(classNotFound);
        }
        return Class.forName(str);
    }

    static Class b(String str, java.lang.ClassLoader classLoader) {
        if (str.equals("*")) {
            return null;
        }
        Object obj = b.e.get(str);
        if (obj != null) {
            return obj;
        }
        if (classLoader == null) {
            try {
                return Class.forName(str);
            } catch (java.lang.ClassNotFoundException unused) {
                str = b.g;
            }
            return cls;
        }
    }

    public static org.mp4parser.aspectj.lang.a c(a.a aVar, Object object, Object object2) {
        return new c(aVar, object, object2, b.f);
    }

    public static org.mp4parser.aspectj.lang.a d(a.a aVar, Object object, Object object2, Object object3) {
        Object[] arr = new Object[1];
        return new c(aVar, object, object2, arr);
    }

    public static org.mp4parser.aspectj.lang.a e(a.a aVar, Object object, Object object2, Object object3, Object object4) {
        Object[] arr = new Object[2];
        return new c(aVar, object, object2, arr);
    }

    public static org.mp4parser.aspectj.lang.a f(a.a aVar, Object object, Object object2, Object[] objectArr) {
        return new c(aVar, object, object2, objectArr);
    }

    public org.mp4parser.aspectj.lang.reflect.a g(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        int i = 0;
        java.lang.ClassLoader classLoader;
        final Object str8 = this;
        String str9 = ":";
        StringTokenizer stringTokenizer = new StringTokenizer(str4, str9);
        int countTokens2 = stringTokenizer.countTokens();
        final Class[] arr2 = new Class[countTokens2];
        i = 0;
        while (i < countTokens2) {
            arr2[i] = b.b(stringTokenizer.nextToken(), str8.b);
            i = i + 1;
        }
        StringTokenizer stringTokenizer2 = new StringTokenizer(str5, str9);
        int countTokens3 = stringTokenizer2.countTokens();
        String[] strArr = new String[countTokens3];
        while (i < countTokens3) {
            strArr[i] = stringTokenizer2.nextToken();
            i = i + 1;
        }
        StringTokenizer stringTokenizer3 = new StringTokenizer(str6, str9);
        int countTokens = stringTokenizer3.countTokens();
        Class[] arr = new Class[countTokens];
        while (i < countTokens) {
            arr[i] = b.b(stringTokenizer3.nextToken(), str8.b);
            i = i + 1;
        }
        e eVar = new e(Integer.parseInt(str, 16), str2, b.b(str3, str8.b), arr2, strArr, arr, cls);
        return eVar;
    }

    public a.a h(String str, org.mp4parser.aspectj.lang.b bVar, int i) {
        this.d++;
        return new c.a(i, str, bVar, i(i, -1));
    }

    public org.mp4parser.aspectj.lang.reflect.b i(int i, int i2) {
        return new g(this.a, this.c, i);
    }
}
