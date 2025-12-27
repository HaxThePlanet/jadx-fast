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

/* compiled from: ResourceLoader.java */
/* loaded from: classes3.dex */
public abstract class d {

    private static final boolean a = false;
    private static final d b;
    private static final boolean c = false;

    private static class a extends d {
        a() {
            super();
            if (d.a) {
                throw new IllegalStateException("The module time4j-android is not active. Check your configuration.");
            }
        }

        @Override // net.time4j.f1.d
        public InputStream e(URI uri, boolean z) throws java.net.MalformedURLException {
            return null;
        }

        @Override // net.time4j.f1.d
        public URI f(String str, Class<?> cls, String str2) {
            CodeSource codeSource;
            String externalForm;
            final int str4 = 0;
            try {
                ProtectionDomain protectionDomain = cls.getProtectionDomain();
                if (protectionDomain == null) {
                } else {
                    codeSource = protectionDomain.getCodeSource();
                }
                externalForm = codeSource.getLocation().toExternalForm();
            } catch (java.net.URISyntaxException unused) {
                str2 = System.err;
                StringBuilder stringBuilder = new StringBuilder();
                String str6 = "Warning: malformed resource path = ";
                cls = str6 + cls;
                str2.println(cls);
            } catch (java.lang.SecurityException unused) {
                return str4;
            }
            try {
                if (externalForm.endsWith(".jar")) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    String str7 = "jar:";
                    str2 = "!/";
                    externalForm = str7 + externalForm + str2;
                }
                StringBuilder stringBuilder3 = new StringBuilder();
                cls = externalForm + str2;
            } catch (java.net.URISyntaxException unused) {
                str2 = System.err;
                stringBuilder = new StringBuilder();
                str6 = "Warning: malformed resource path = ";
                cls = str6 + cls;
                str2.println(cls);
            } catch (java.lang.SecurityException unused) {
                return str4;
            }
            return new URI(cls);
        }

        @Override // net.time4j.f1.d
        public <S> Iterable<S> g(Class<S> cls) {
            return ServiceLoader.load(cls, cls.getClassLoader());
        }
    }
    static {
        boolean equalsIgnoreCase = "Dalvik".equalsIgnoreCase(System.getProperty("java.vm.name"));
        d.a = equalsIgnoreCase;
        if (!equalsIgnoreCase) {
            Throwable message = Boolean.getBoolean("net.time4j.base.useClassloaderOnly") ? 1 : 0;
        }
    }

    protected d() {
        super();
    }

    static /* synthetic */ boolean a() {
        return d.a;
    }

    static /* synthetic */ boolean b() {
        return d.c;
    }

    public static d c() {
        return d.b;
    }

    public final InputStream d(Class<?> cls, String str, boolean z) throws IOException, FileNotFoundException {
        if (d.a) {
            throw new FileNotFoundException(str);
        } else {
            URL resource = cls.getClassLoader().getResource(str);
            if (resource == null) {
                throw new FileNotFoundException(str);
            } else {
                if (z) {
                    Object instrument = FirebasePerfUrlConnection.instrument(resource.openConnection());
                    instrument.setUseCaches(false);
                    instrument.connect();
                    return instrument.getInputStream();
                }
                return FirebasePerfUrlConnection.openStream(resource);
            }
        }
    }

    public abstract InputStream e(URI uri, boolean z);

    public abstract URI f(String str, Class<?> cls, String str2);

    public abstract <S> Iterable<S> g(Class<S> cls);
}
