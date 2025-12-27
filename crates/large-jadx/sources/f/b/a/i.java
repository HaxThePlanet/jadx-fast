package f.b.a;

import com.coremedia.iso.boxes.a;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: PropertyBoxParserImpl.java */
/* loaded from: classes.dex */
public class i extends a {

    static String[] h;
    Properties c = new Properties();
    Pattern d;
    StringBuilder e = new StringBuilder();
    java.lang.ThreadLocal<String> f = new ThreadLocal<>();
    java.lang.ThreadLocal<String[]> g = new ThreadLocal<>();
    static {
        i.h = new String[0];
    }

    public i(String... strArr) {
        java.lang.ClassLoader contextClassLoader;
        int i = 0;
        Properties properties;
        super();
        this.d = Pattern.compile("(.*)\\((.*?)\\)");
        StringBuilder stringBuilder = new StringBuilder();
        java.lang.ThreadLocal threadLocal = new ThreadLocal();
        java.lang.ThreadLocal threadLocal2 = new ThreadLocal();
        InputStream resourceAsStream = i.class.getResourceAsStream("/isoparser-default.properties");
        try {
        } catch (java.io.IOException ioException) {
        } catch (Throwable th1) {
        }
        try {
            new Properties().load(resourceAsStream);
            if (Thread.currentThread().getContextClassLoader() == null) {
                contextClassLoader = ClassLoader.getSystemClassLoader();
            }
            str = "isoparser-custom.properties";
            Enumeration resources = contextClassLoader.getResources(str);
        } catch (java.io.IOException ioException) {
            ioException.printStackTrace();
        }
        Object stream = FirebasePerfUrlConnection.openStream((URL)resources.nextElement());
        try {
            this.c.load(stream);
        } catch (Throwable unused) {
        }
        try {
            stream.close();
            obj2.close();
            throw th1;
        } catch (java.io.IOException ioException) {
            ioException.printStackTrace();
        }
    }

    @Override // f.b.a.a
    public a b(String str, byte[] bArr, String str2) {
        int i = 0;
        Class<byte[]> obj;
        Object obj2;
        final Class<String> obj3 = String.class;
        c(str, bArr, str2);
        Object obj4 = this.g.get();
        try {
            Class cls = Class.forName((String)this.f.get());
            if (obj4.length > 0) {
                Class[] arr = new Class[obj4.length];
                Object[] arr2 = new Object[obj4.length];
                i = 0;
                for (Object obj2 : obj4) {
                }
                return (a)cls.getConstructor(arr).newInstance(arr2);
            }
        } catch (java.lang.NoSuchMethodException noSuchMethod) {
            bArr = new RuntimeException(noSuchMethod);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) bArr;
        } catch (java.lang.reflect.InvocationTargetException invocationTarget1) {
            bArr = new RuntimeException(invocationTarget1);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) bArr;
        } catch (java.lang.IllegalAccessException illegalAccess2) {
            bArr = new RuntimeException(illegalAccess2);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) bArr;
        } catch (java.lang.InstantiationException instantiation3) {
            bArr = new RuntimeException(instantiation3);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) bArr;
        } catch (java.lang.ClassNotFoundException classNotFound4) {
            bArr = new RuntimeException(classNotFound4);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) bArr;
        }
        return (a)cls.newInstance();
    }

    @Override // f.b.a.a
    public void c(String str, byte[] bArr, String str2) {
        String property;
        String str4;
        String[] strArr;
        String str6;
        String str7;
        String str8;
        int i = 0;
        if (bArr != null) {
            str2 = "uuid";
            if (!str2.equals(str)) {
                throw new RuntimeException("we have a userType but no uuid box type. Something's wrong");
            } else {
                String str10 = "uuid[";
                StringBuilder stringBuilder = new StringBuilder(str10);
                String str12 = c.a(bArr).toUpperCase();
                str5 = "]";
                str4 = str10 + str12 + str5;
                if (this.c.getProperty(str4) == null) {
                    String str18 = String.valueOf(str2);
                    StringBuilder stringBuilder2 = new StringBuilder(str18);
                    str8 = "-uuid[";
                    String str16 = c.a(bArr).toUpperCase();
                    str6 = str18 + str8 + str16 + str5;
                    property = this.c.getProperty(str6);
                }
                if (this.c == null) {
                    property = this.c.getProperty(str2);
                }
                if (this.c == null) {
                    str8 = "default";
                    property = this.c.getProperty(str8);
                }
                if (this.c == null) {
                    String str9 = "No box object found for ";
                    str = str9 + str;
                    throw new RuntimeException(str);
                } else {
                    if (!property.endsWith(")")) {
                        this.g.set(i.h);
                        this.f.set(property);
                        return;
                    } else {
                        Matcher matcher = this.d.matcher(property);
                        if (matcher.matches()) {
                            this.f.set(matcher.group(1));
                            int i2 = 2;
                            if (matcher.group(i2).length() == 0) {
                                this.g.set(i.h);
                            } else {
                                if (matcher.group(i2).length() > 0) {
                                    str7 = ",";
                                    strArr = matcher.group(i2).split(str7);
                                } else {
                                    strArr = new String[i];
                                }
                                this.g.set(strArr);
                            }
                        }
                    }
                    String str17 = "Cannot work with that constructor: ";
                    bArr = str17 + property;
                    throw new RuntimeException(bArr);
                }
            }
        }
        if (this.c.getProperty(str) == null) {
            str6 = str2 + 45 + str;
            this.e.setLength(i);
            property = this.c.getProperty(str6);
        }
    }
}
