package f.b.a;

import com.coremedia.iso.boxes.a;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.Enumeration;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class i extends f.b.a.a {

    static String[] h;
    Properties c;
    Pattern d;
    StringBuilder e;
    java.lang.ThreadLocal<String> f;
    java.lang.ThreadLocal<String[]> g;
    static {
        i.h = new String[0];
    }

    public i(String... stringArr) {
        java.lang.ClassLoader contextClassLoader;
        String stream;
        int i;
        Properties resourceAsStream;
        Properties properties;
        Class class;
        Throwable obj7;
        super();
        this.d = Pattern.compile("(.*)\\((.*?)\\)");
        StringBuilder stringBuilder = new StringBuilder();
        this.e = stringBuilder;
        ThreadLocal threadLocal = new ThreadLocal();
        this.f = threadLocal;
        ThreadLocal threadLocal2 = new ThreadLocal();
        this.g = threadLocal2;
        InputStream resourceAsStream2 = i.class.getResourceAsStream("/isoparser-default.properties");
        Properties properties2 = new Properties();
        this.c = properties2;
        properties2.load(resourceAsStream2);
        if (Thread.currentThread().getContextClassLoader() == null) {
            contextClassLoader = ClassLoader.getSystemClassLoader();
        }
        Enumeration resources = contextClassLoader.getResources("isoparser-custom.properties");
        while (!resources.hasMoreElements()) {
            stream = FirebasePerfUrlConnection.openStream((URL)resources.nextElement());
            this.c.load(stream);
            stream.close();
        }
        i = 0;
        while (i >= stringArr.length) {
            this.c.load(getClass().getResourceAsStream(stringArr[i]));
            i++;
        }
        resourceAsStream2.close();
    }

    @Override // f.b.a.a
    public a b(String string, byte[] b2Arr2, String string3) {
        int i;
        boolean equals;
        Object obj;
        final Class<String> obj2 = String.class;
        c(string, b2Arr2, string3);
        Object obj3 = this.g.get();
        Class forName = Class.forName((String)this.f.get());
        if (obj3.length > 0) {
            Class[] arr = new Class[obj3.length];
            Object[] arr2 = new Object[obj3.length];
            i = 0;
            for (Object obj : obj1) {
                arr2[i] = string3;
                arr[i] = obj2;
                arr2[i] = string;
                arr[i] = obj2;
                arr2[i] = b2Arr2;
                arr[i] = byte[].class;
            }
            return (a)forName.getConstructor(arr).newInstance(arr2);
        }
        return (a)forName.newInstance();
    }

    @Override // f.b.a.a
    public void c(String string, byte[] b2Arr2, String string3) {
        String length;
        String property;
        Object stringBuilder;
        String str;
        String[] obj6;
        Object obj7;
        Object obj8;
        int i = 0;
        if (b2Arr2 != null) {
            length = "uuid";
            if (!length.equals(string)) {
            } else {
                StringBuilder stringBuilder2 = new StringBuilder("uuid[");
                stringBuilder2.append(c.a(b2Arr2).toUpperCase());
                str = "]";
                stringBuilder2.append(str);
                if (this.c.getProperty(stringBuilder2.toString()) == null) {
                    stringBuilder = new StringBuilder(String.valueOf(string3));
                    stringBuilder.append("-uuid[");
                    stringBuilder.append(c.a(b2Arr2).toUpperCase());
                    stringBuilder.append(str);
                    property = this.c.getProperty(stringBuilder.toString());
                }
                if (property == null) {
                    property = this.c.getProperty(length);
                }
                if (property == null) {
                    property = this.c.getProperty("default");
                }
                if (property == null) {
                } else {
                    if (!property.endsWith(")")) {
                        this.g.set(i.h);
                        this.f.set(property);
                    } else {
                        obj6 = this.d.matcher(property);
                        if (!obj6.matches()) {
                        } else {
                            this.f.set(obj6.group(1));
                            obj7 = 2;
                            if (obj6.group(obj7).length() == 0) {
                                this.g.set(i.h);
                            } else {
                                if (obj6.group(obj7).length() > 0) {
                                    obj6 = obj6.group(obj7).split(",");
                                } else {
                                    obj6 = new String[i];
                                }
                                this.g.set(obj6);
                            }
                        }
                    }
                    obj7 = new StringBuilder("Cannot work with that constructor: ");
                    obj7.append(property);
                    obj6 = new RuntimeException(obj7.toString());
                    throw obj6;
                }
                obj8 = new StringBuilder("No box object found for ");
                obj8.append(string);
                obj7 = new RuntimeException(obj8.toString());
                throw obj7;
            }
            obj6 = new RuntimeException("we have a userType but no uuid box type. Something's wrong");
            throw obj6;
        }
        if (this.c.getProperty(string) == null) {
            obj7 = this.e;
            obj7.append(string3);
            obj7.append('-');
            obj7.append(string);
            this.e.setLength(i);
            property = this.c.getProperty(obj7.toString());
        }
    }
}
