package m.b.a.a.b;

import java.util.Hashtable;
import java.util.StringTokenizer;
import org.mp4parser.aspectj.lang.a;
import org.mp4parser.aspectj.lang.a.a;
import org.mp4parser.aspectj.lang.b;
import org.mp4parser.aspectj.lang.reflect.a;
import org.mp4parser.aspectj.lang.reflect.b;

/* loaded from: classes3.dex */
public final class b {

    static Hashtable e;
    private static Object[] f;
    static Class g;
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

    public b(String string, Class class2) {
        super();
        this.c = string;
        this.a = class2;
        int obj1 = 0;
        this.b = class2.getClassLoader();
    }

    static Class a(String string) {
        try {
            return Class.forName(string);
            string = string.getMessage();
            NoClassDefFoundError noClassDefFoundError = new NoClassDefFoundError(string);
            throw noClassDefFoundError;
        }
    }

    static Class b(String string, java.lang.ClassLoader classLoader2) {
        if (string.equals("*")) {
            return null;
        }
        Object obj = b.e.get(string);
        if ((Class)obj != null) {
            return (Class)obj;
        }
        if (classLoader2 == null) {
            return Class.forName(string);
        }
        return Class.forName(string, false, classLoader2);
    }

    public static a c(a.a a$a, Object object2, Object object3) {
        c cVar = new c(a, object2, object3, b.f);
        return cVar;
    }

    public static a d(a.a a$a, Object object2, Object object3, Object object4) {
        Object[] arr = new Object[1];
        c cVar = new c(a, object2, object3, arr);
        return cVar;
    }

    public static a e(a.a a$a, Object object2, Object object3, Object object4, Object object5) {
        Object[] arr = new Object[2];
        c cVar = new c(a, object2, object3, arr);
        return cVar;
    }

    public static a f(a.a a$a, Object object2, Object object3, Object[] object4Arr4) {
        c cVar = new c(a, object2, object3, object4Arr4);
        return cVar;
    }

    public a g(String string, String string2, String string3, String string4, String string5, String string6, String string7) {
        String str;
        int i3;
        int i;
        Class cls;
        int i2;
        java.lang.ClassLoader nextToken;
        final Object obj = this;
        String str2 = string;
        String str3 = string3;
        String str4 = ":";
        String str6 = string4;
        StringTokenizer stringTokenizer = new StringTokenizer(string4, str4);
        int countTokens2 = stringTokenizer.countTokens();
        final Class[] arr = new Class[countTokens2];
        i3 = 0;
        i = i3;
        while (i < countTokens2) {
            arr[i] = b.b(stringTokenizer.nextToken(), obj.b);
            i++;
        }
        StringTokenizer stringTokenizer2 = new StringTokenizer(string5, str4);
        int countTokens3 = stringTokenizer2.countTokens();
        String[] strArr2 = new String[countTokens3];
        i2 = i3;
        while (i2 < countTokens3) {
            strArr2[i2] = stringTokenizer2.nextToken();
            i2++;
        }
        StringTokenizer stringTokenizer3 = new StringTokenizer(string6, str4);
        int countTokens = stringTokenizer3.countTokens();
        Class[] arr2 = new Class[countTokens];
        while (i3 < countTokens) {
            arr2[i3] = b.b(stringTokenizer3.nextToken(), obj.b);
            i3++;
        }
        super(Integer.parseInt(string, 16), string2, b.b(string3, obj.b), arr, strArr2, arr2, b.b(string7, obj.b));
        return eVar2;
    }

    public a.a h(String string, b b2, int i3) {
        final int i = this.d;
        this.d = i + 1;
        c.a aVar = new c.a(i, string, b2, i(i3, -1));
        return aVar;
    }

    public b i(int i, int i2) {
        g obj4 = new g(this.a, this.c, i);
        return obj4;
    }
}
