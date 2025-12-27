package io.grpc.k1.r;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;
import java.security.AccessController;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import l.f;

/* compiled from: Platform.java */
/* loaded from: classes3.dex */
public class f {

    public static final Logger b;
    private static final String[] c;
    private static final f d;
    private final Provider a;

    class a implements PrivilegedExceptionAction<Method> {
        a() {
            super();
        }

        public Method a() throws java.lang.NoSuchMethodException {
            return SSLEngine.class.getMethod("getApplicationProtocol", new Class[0]);
        }
    }

    class b implements PrivilegedExceptionAction<Method> {
        b() {
            super();
        }

        public Method a() throws java.lang.NoSuchMethodException {
            Class[] arr = new Class[1];
            return SSLParameters.class.getMethod("setApplicationProtocols", new Class[] { String[].class });
        }
    }

    class c implements PrivilegedExceptionAction<Method> {
        c() {
            super();
        }

        public Method a() throws java.lang.NoSuchMethodException {
            return SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]);
        }
    }

    private static class g implements InvocationHandler {

        private final List<String> a;
        private boolean b;
        private String c;
        public g(List<String> list) {
            super();
            this.a = list;
        }

        static /* synthetic */ boolean a(f.g gVar) {
            return gVar.b;
        }

        static /* synthetic */ String b(f.g gVar) {
            return gVar.c;
        }

        public Object invoke(Object object, Method method, Object[] objectArr) throws java.lang.IllegalAccessException, InvocationTargetException {
            boolean equals;
            String[] strArr;
            int i;
            String name = method.getName();
            Class returnType = method.getReturnType();
            if (objectArr == null) {
                strArr = i.a;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return Boolean.TRUE;
            }
            final int i2 = 0;
            final boolean z = true;
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.b = z;
                return null;
            }
            if (name.equals("protocols")) {
                if (strArr.length == 0) {
                    return this.a;
                }
            }
            i = 0;
            if (!name.equals("selectProtocol")) {
                if (name.equals("select") && Void.TYPE == returnType && strArr.length == z && strArr[i] instanceof ist) {
                    String str10 = strArr[i];
                    while (i < str10.size()) {
                        if (this.a.contains(str10.get(i))) {
                            Object item2 = str10.get(i);
                            this.c = item2;
                            return item2;
                        }
                    }
                    Object item3 = this.a.get(i);
                    this.c = item3;
                    return item3;
                }
            }
            if (!name.equals("protocolSelected")) {
                str = "selected";
                if (name.equals(str)) {
                    if (strArr.length == z) {
                        this.c = (String)strArr[i];
                        return i2;
                    }
                }
            }
            return method.invoke(this, strArr);
        }
    }

    public enum h {

        ALPN_AND_NPN,
        NONE,
        NPN;
    }

    private static class d extends f {

        private final e<Socket> e;
        private final e<Socket> f;
        private final e<Socket> g;
        private final e<Socket> h;
        private final f.h i;
        public d(e<Socket> eVar, e<Socket> eVar2, Method method, Method method2, e<Socket> eVar3, e<Socket> eVar4, Provider provider, f.h hVar) {
            super(provider);
            this.e = eVar;
            this.f = eVar2;
            this.g = eVar3;
            this.h = eVar4;
            this.i = hVar;
        }

        @Override // io.grpc.k1.r.f
        public void c(SSLSocket sSLSocket, String str, List<g> list) {
            final int i = 0;
            final int i2 = 1;
            if (str != null) {
                Object[] arr2 = new Object[i2];
                this.e.e(sSLSocket, Boolean.TRUE);
                Object[] arr = new Object[i2];
                this.f.e(sSLSocket, str);
            }
            if (this.h.g(sSLSocket)) {
                Object[] arr3 = new Object[i2];
                this.h.f(sSLSocket, f.b(list));
            }
        }

        @Override // io.grpc.k1.r.f
        public String h(SSLSocket sSLSocket) throws java.io.UnsupportedEncodingException {
            int i = 0;
            i = 0;
            if (!this.g.g(sSLSocket)) {
                return null;
            }
            final Object obj = this.g.f(sSLSocket, new Object[0]);
            if (obj != null) {
                String string = new String(obj, i.b);
            }
            return i;
        }

        @Override // io.grpc.k1.r.f
        public f.h i() {
            return this.i;
        }
    }

    private static class e extends f {

        private final Method e;
        private final Method f;
        /* synthetic */ e(Provider provider, Method method, Method method2, f.a aVar) {
            this(provider, method, method2);
        }

        @Override // io.grpc.k1.r.f
        public void c(SSLSocket sSLSocket, String str, List<g> list) {
            final javax.net.ssl.SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            ArrayList arrayList = new ArrayList(list.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Object item = it.next();
            }
            try {
                Object[] arr = new Object[1];
                this.e.invoke(sSLParameters, new Object[] { arrayList.toArray(new String[arrayList.size()]) });
            } catch (java.lang.reflect.InvocationTargetException invocationTarget) {
                str = new RuntimeException(invocationTarget);
                throw str;
            } catch (java.lang.IllegalAccessException illegalAccess1) {
                str = new RuntimeException(illegalAccess1);
                throw str;
            }
            illegalAccess1.setSSLParameters(sSLParameters);
        }

        @Override // io.grpc.k1.r.f
        public String h(SSLSocket sSLSocket) {
            try {
            } catch (java.lang.reflect.InvocationTargetException invocationTarget) {
                RuntimeException runtimeException = new RuntimeException(invocationTarget);
                throw runtimeException;
            } catch (java.lang.IllegalAccessException illegalAccess1) {
                runtimeException = new RuntimeException(illegalAccess1);
                throw runtimeException;
            }
            return (String)this.f.invoke(sSLSocket, new Object[0]);
        }

        @Override // io.grpc.k1.r.f
        public f.h i() {
            return f.h.ALPN_AND_NPN;
        }

        private e(Provider provider, Method method, Method method2) {
            super(provider);
            this.e = method;
            this.f = method2;
        }
    }

    private static class f extends f {

        private final Method e;
        private final Method f;
        private final Method g;
        private final Class<?> h;
        private final Class<?> i;
        public f(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2, Provider provider) {
            super(provider);
            this.e = method;
            this.f = method2;
            this.g = method3;
            this.h = cls;
            this.i = cls2;
        }

        @Override // io.grpc.k1.r.f
        public void a(SSLSocket sSLSocket) {
            try {
                Object obj = null;
                Object[] arr = new Object[1];
                this.g.invoke(obj, new Object[] { sSLSocket });
            } catch (java.lang.reflect.InvocationTargetException invocationTarget) {
                f.b.log(Level.FINE, "Failed to remove SSLSocket from Jetty ALPN", invocationTarget);
            } catch (java.lang.IllegalAccessException unused) {
                invocationTarget = new AssertionError();
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) invocationTarget;
            }
        }

        @Override // io.grpc.k1.r.f
        public void c(SSLSocket sSLSocket, String str, List<g> list) {
            int i;
            Object item;
            ArrayList arrayList = new ArrayList(list.size());
            i = 0;
            while (i < list.size()) {
                item = list.get(i);
                i = i + 1;
            }
            try {
                int i2 = 2;
                Class[] arr2 = new Class[i2];
                arr2[i] = this.h;
                int i4 = 1;
                arr2[i4] = this.i;
                Object[] arr = new Object[i2];
                arr[i] = sSLSocket;
                arr[i4] = Proxy.newProxyInstance(f.class.getClassLoader(), arr2, new f.g(arrayList));
                this.e.invoke(null, arr);
            } catch (java.lang.IllegalAccessException illegalAccess) {
                str = new AssertionError(illegalAccess);
                throw str;
            } catch (java.lang.reflect.InvocationTargetException invocationTarget1) {
                str = new AssertionError(invocationTarget1);
                throw str;
            }
        }

        @Override // io.grpc.k1.r.f
        public String h(SSLSocket sSLSocket) {
            String str = null;
            try {
                Object[] arr = new Object[1];
                Object obj = null;
                InvocationHandler invocationHandler = Proxy.getInvocationHandler(this.f.invoke(obj, new Object[] { sSLSocket }));
                if (!invocationHandler.b && f.g.b(invocationHandler) == null) {
                    f.b.log(Level.INFO, "ALPN callback dropped: SPDY and HTTP/2 are disabled. Is alpn-boot on the boot class path?");
                    return obj;
                }
                if (!(invocationHandler.b)) {
                    str = invocationHandler.c;
                }
            } catch (java.lang.IllegalAccessException unused) {
                sSLSocket = new AssertionError();
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) sSLSocket;
            } catch (java.lang.reflect.InvocationTargetException unused) {
                sSLSocket = new AssertionError();
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) sSLSocket;
            }
            return str;
        }

        @Override // io.grpc.k1.r.f
        public f.h i() {
            return f.h.ALPN_AND_NPN;
        }
    }
    static {
        f.b = Logger.getLogger(f.class.getName());
        f.c = new String[] { "com.google.android.gms.org.conscrypt.OpenSSLProvider", "org.conscrypt.OpenSSLProvider", "com.android.org.conscrypt.OpenSSLProvider", "org.apache.harmony.xnet.provider.jsse.OpenSSLProvider", "com.google.android.libraries.stitch.sslguard.SslGuardProvider" };
        f.d = f.d();
    }

    public f(Provider provider) {
        super();
        this.a = provider;
    }

    public static byte[] b(List<g> list) {
        int i = 0;
        Object item;
        io.grpc.k1.r.g gVar;
        final f fVar = new f();
        i = 0;
        while (i < list.size()) {
            item = list.get(i);
            i = i + 1;
        }
        return fVar.X();
    }

    private static f d() {
        Method method;
        io.grpc.k1.r.f.h aLPN_AND_NPN2;
        String str2;
        Class<byte[]> obj = byte[].class;
        final Provider provider3 = f.f();
        int i = 1;
        Class cls2 = null;
        int i3 = 0;
        if (provider3 != null) {
            Class[] arr2 = new Class[i];
            Class[] arr3 = new Class[i];
            Class[] arr6 = new Class[i];
            try {
                Class cls = Class.forName("android.net.TrafficStats");
                Class[] arr7 = new Class[i];
            } catch (java.lang.ClassNotFoundException | java.lang.NoSuchMethodException unused) {
                Provider provider = str;
            }
            try {
                Class[] arr = new Class[i];
                method = cls.getMethod("untagSocket", new Class[] { Socket.class });
            } catch (java.lang.ClassNotFoundException | java.lang.NoSuchMethodException unused) {
                provider = str;
            }
            str2 = "GmsCore_OpenSSL";
            if (!provider3.getName().equals(str2)) {
                str2 = "Conscrypt";
                if (!provider3.getName().equals(str2)) {
                    str2 = "Ssl_Guard";
                    if (provider3.getName().equals(str2)) {
                        aLPN_AND_NPN2 = f.h.ALPN_AND_NPN;
                    } else {
                        if (f.k()) {
                            aLPN_AND_NPN2 = f.h.ALPN_AND_NPN;
                        } else {
                            int runtimeException = f.j() ? f.h.NPN : f.h.NONE;
                        }
                    }
                }
            }
            runtimeException = new f.d(new e(cls2, "setUseSessionTickets", arr2), new e(cls2, "setHostname", arr3), cls.getMethod("tagSocket", new Class[] { Socket.class }), method, new e(obj, "getAlpnSelectedProtocol", new Class[i3]), new e(cls2, "setAlpnProtocols", arr6), provider3, (f.j() ? f.h.NPN : f.h.NONE));
            return dVar;
        }
        try {
            Provider provider2 = SSLContext.getDefault().getProvider();
        } catch (java.security.NoSuchAlgorithmException noSuchAlgorithm) {
            runtimeException = new RuntimeException(noSuchAlgorithm);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) runtimeException;
        }
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS", provider2);
            sSLContext.init(cls2, cls2, cls2);
            (Method)AccessController.doPrivileged(new f.a()).invoke(sSLContext.createSSLEngine(), new Object[i3]);
        } catch (java.security.NoSuchAlgorithmException | java.security.KeyManagementException | java.security.PrivilegedActionException | java.lang.IllegalAccessException | java.lang.reflect.InvocationTargetException unused) {
        }
        return new f.e(provider2, (Method)AccessController.doPrivileged(new f.b()), (Method)AccessController.doPrivileged(new f.c()), cls2);
    }

    public static f e() {
        return f.d;
    }

    private static Provider f() {
        int i;
        Object obj;
        boolean equals;
        Provider[] providers = Security.getProviders();
        i = 0;
        for (Provider provider : providers) {
            strArr = f.c;
            length = strArr.length;
            for (String str3 : strArr) {
                if (str3.equals(provider.getClass().getName())) {
                    f.b.log(Level.FINE, "Found registered provider {0}", str3);
                    return provider;
                }
            }
            String str3 = strArr[i];
            if (str3.equals(provider.getClass().getName())) {
                f.b.log(Level.FINE, "Found registered provider {0}", str3);
                return provider;
            }
        }
        f.b.log(Level.WARNING, "Unable to find Conscrypt");
        return null;
    }

    private static boolean j() {
        try {
            f.class.getClassLoader().loadClass("android.app.ActivityOptions");
        } catch (java.lang.ClassNotFoundException classNotFound) {
            f.b.log(Level.FINE, "Can't find class", classNotFound);
            Throwable classNotFound2 = null;
            return classNotFound2;
        }
        return true;
    }

    private static boolean k() {
        try {
            f.class.getClassLoader().loadClass("android.net.Network");
        } catch (java.lang.ClassNotFoundException classNotFound) {
            f.b.log(Level.FINE, "Can't find class", classNotFound);
            Throwable classNotFound2 = null;
            return classNotFound2;
        }
        return true;
    }

    public Provider g() {
        return this.a;
    }

    public f.h i() {
        return f.h.NONE;
    }

    public void a(SSLSocket sSLSocket) {
    }

    public void c(SSLSocket sSLSocket, String str, List<g> list) {
    }

    public String h(SSLSocket sSLSocket) {
        return null;
    }
}
