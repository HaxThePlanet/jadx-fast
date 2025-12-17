package net.time4j.f1;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import java.util.ServiceLoader;

/* loaded from: classes3.dex */
public abstract class d {

    private static final boolean a;
    private static final net.time4j.f1.d b;
    private static final boolean c = false;

    private static class a extends net.time4j.f1.d {
        a() {
            super();
            if (d.a()) {
            } else {
            }
            IllegalStateException illegalStateException = new IllegalStateException("The module time4j-android is not active. Check your configuration.");
            throw illegalStateException;
        }

        @Override // net.time4j.f1.d
        public InputStream e(URI uRI, boolean z2) {
            String err;
            String stringBuilder;
            String str;
            Object obj5;
            Throwable obj6;
            if (uRI != null) {
                if (d.b()) {
                } else {
                    URL uRL = uRI.toURL();
                    if (z2 != null) {
                        obj6 = FirebasePerfUrlConnection.instrument(uRL.openConnection());
                        (URLConnection)obj6.setUseCaches(false);
                        obj6.connect();
                        return obj6.getInputStream();
                    }
                }
                return FirebasePerfUrlConnection.openStream(uRL);
            }
            return null;
        }

        public URI f(String string, Class<?> class2, String string3) {
            StringBuilder stringBuilder;
            boolean stringBuilder2;
            String str;
            CodeSource obj4;
            String obj5;
            final int obj3 = 0;
            obj4 = class2.getProtectionDomain();
            if (obj4 == null) {
                try {
                    obj4 = obj3;
                    obj4 = obj4.getCodeSource();
                    obj4 = obj4.getLocation().toExternalForm();
                    if (obj4 != null && obj4.endsWith(".jar")) {
                    }
                    obj4 = obj4.getLocation().toExternalForm();
                    if (obj4.endsWith(".jar")) {
                    }
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("jar:");
                    stringBuilder2.append(obj4);
                    stringBuilder2.append("!/");
                    obj4 = stringBuilder2.toString();
                    StringBuilder stringBuilder3 = new StringBuilder();
                    stringBuilder3.append(obj4);
                    stringBuilder3.append(string3);
                    obj5 = new URI(stringBuilder3.toString());
                    return obj5;
                    class2 = string;
                    string3 = System.err;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Warning: malformed resource path = ");
                    stringBuilder.append(class2);
                    class2 = stringBuilder.toString();
                    string3.println(class2);
                    return obj3;
                } catch (java.lang.SecurityException se) {
                } catch (java.net.URISyntaxException uRISyntax1) {
                }
            } else {
            }
        }

        public <S> Iterable<S> g(Class<S> class) {
            return ServiceLoader.load(class, class.getClassLoader());
        }
    }
    static {
        boolean equalsIgnoreCase;
        Object aVar;
        equalsIgnoreCase = "Dalvik".equalsIgnoreCase(System.getProperty("java.vm.name"));
        d.a = equalsIgnoreCase;
        if (!equalsIgnoreCase && Boolean.getBoolean("net.time4j.base.useClassloaderOnly")) {
            if (Boolean.getBoolean("net.time4j.base.useClassloaderOnly")) {
                int i2 = 1;
            }
        }
        int i = 0;
        String property2 = System.getProperty("net.time4j.base.ResourceLoader");
        if (property2 == null) {
            aVar = new d.a();
            d.b = aVar;
        } else {
            d.b = (d)Class.forName(property2).newInstance();
        }
    }

    static boolean a() {
        return d.a;
    }

    static boolean b() {
        return d.c;
    }

    public static net.time4j.f1.d c() {
        return d.b;
    }

    public final InputStream d(Class<?> class, String string2, boolean z3) {
        if (d.a) {
        } else {
            URL obj2 = class.getClassLoader().getResource(string2);
            if (obj2 == null) {
            } else {
                if (z3) {
                    obj2 = FirebasePerfUrlConnection.instrument(obj2.openConnection());
                    (URLConnection)obj2.setUseCaches(false);
                    obj2.connect();
                    return obj2.getInputStream();
                }
                return FirebasePerfUrlConnection.openStream(obj2);
            }
            obj2 = new FileNotFoundException(string2);
            throw obj2;
        }
        obj2 = new FileNotFoundException(string2);
        throw obj2;
    }

    public abstract InputStream e(URI uRI, boolean z2);

    public abstract URI f(String string, Class<?> class2, String string3);

    public abstract <S> Iterable<S> g(Class<S> class);
}
