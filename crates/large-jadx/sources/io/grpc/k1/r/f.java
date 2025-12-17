package io.grpc.k1.r;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;
import java.security.AccessController;
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

/* loaded from: classes3.dex */
public class f {

    public static final Logger b;
    private static final String[] c;
    private static final io.grpc.k1.r.f d;
    private final Provider a;

    class a implements PrivilegedExceptionAction<Method> {
        @Override // java.security.PrivilegedExceptionAction
        public Method a() {
            return SSLEngine.class.getMethod("getApplicationProtocol", new Class[0]);
        }

        @Override // java.security.PrivilegedExceptionAction
        public Object run() {
            return a();
        }
    }

    class b implements PrivilegedExceptionAction<Method> {
        @Override // java.security.PrivilegedExceptionAction
        public Method a() {
            Class[] arr = new Class[1];
            return SSLParameters.class.getMethod("setApplicationProtocols", String[].class);
        }

        @Override // java.security.PrivilegedExceptionAction
        public Object run() {
            return a();
        }
    }

    class c implements PrivilegedExceptionAction<Method> {
        @Override // java.security.PrivilegedExceptionAction
        public Method a() {
            return SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]);
        }

        @Override // java.security.PrivilegedExceptionAction
        public Object run() {
            return a();
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

        static boolean a(io.grpc.k1.r.f.g f$g) {
            return g.b;
        }

        static String b(io.grpc.k1.r.f.g f$g) {
            return g.c;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object object, Method method2, Object[] object3Arr3) {
            Class returnType;
            String equals3;
            boolean tYPE2;
            boolean tYPE;
            boolean equals;
            boolean equals2;
            boolean obj6;
            String[] obj8;
            obj6 = method2.getName();
            returnType = method2.getReturnType();
            if (object3Arr3 == null) {
                obj8 = i.a;
            }
            if (obj6.equals("supports") && Boolean.TYPE == returnType) {
                if (Boolean.TYPE == returnType) {
                    return Boolean.TRUE;
                }
            }
            final int i = 0;
            final int i2 = 1;
            if (obj6.equals("unsupported") && Void.TYPE == returnType) {
                if (Void.TYPE == returnType) {
                    this.b = i2;
                    return i;
                }
            }
            if (obj6.equals("protocols") && obj8.length == 0) {
                if (obj8.length == 0) {
                    return this.a;
                }
            }
            final int i3 = 0;
            if (!obj6.equals("selectProtocol")) {
                if (obj6.equals("select") && String.class == returnType && obj8.length == i2 && str2 instanceof List != null) {
                    if (String.class == returnType) {
                        if (obj8.length == i2) {
                            if (str2 instanceof List != null) {
                                obj6 = obj8[i3];
                                obj8 = i3;
                                while (obj8 < (List)obj6.size()) {
                                    obj8++;
                                }
                                obj6 = this.a.get(i3);
                                this.c = (String)obj6;
                                return obj6;
                            }
                        }
                    }
                }
            } else {
            }
            if (!obj6.equals("protocolSelected")) {
                if (obj6.equals("selected") && obj8.length == i2) {
                    if (obj8.length == i2) {
                        this.c = (String)obj8[i3];
                        return i;
                    }
                }
            } else {
            }
            return method2.invoke(this, obj8);
        }
    }

    public static enum h {

        ALPN_AND_NPN,
        NPN,
        NONE;
    }

    private static class d extends io.grpc.k1.r.f {

        private final io.grpc.k1.r.e<Socket> e;
        private final io.grpc.k1.r.e<Socket> f;
        private final io.grpc.k1.r.e<Socket> g;
        private final io.grpc.k1.r.e<Socket> h;
        private final io.grpc.k1.r.f.h i;
        public d(io.grpc.k1.r.e<Socket> e, io.grpc.k1.r.e<Socket> e2, Method method3, Method method4, io.grpc.k1.r.e<Socket> e5, io.grpc.k1.r.e<Socket> e6, Provider provider7, io.grpc.k1.r.f.h f$h8) {
            super(provider7);
            this.e = e;
            this.f = e2;
            this.g = e5;
            this.h = e6;
            this.i = h8;
        }

        public void c(SSLSocket sSLSocket, String string2, List<io.grpc.k1.r.g> list3) {
            io.grpc.k1.r.e eVar;
            Object[] arr;
            Boolean tRUE;
            boolean obj7;
            Object obj8;
            final int i = 0;
            final int i2 = 1;
            if (string2 != null) {
                Object[] arr2 = new Object[i2];
                arr2[i] = Boolean.TRUE;
                this.e.e(sSLSocket, arr2);
                arr = new Object[i2];
                arr[i] = string2;
                this.f.e(sSLSocket, arr);
            }
            if (this.h.g(sSLSocket)) {
                obj7 = new Object[i2];
                obj7[i] = f.b(list3);
                this.h.f(sSLSocket, obj7);
            }
        }

        @Override // io.grpc.k1.r.f
        public String h(SSLSocket sSLSocket) {
            Object eVar;
            int string;
            if (!this.g.g(sSLSocket)) {
                return null;
            }
            final Object obj4 = this.g.f(sSLSocket, new Object[0]);
            if ((byte[])obj4 != null) {
                string = new String((byte[])obj4, i.b);
            }
            return string;
        }

        @Override // io.grpc.k1.r.f
        public io.grpc.k1.r.f.h i() {
            return this.i;
        }
    }

    private static class e extends io.grpc.k1.r.f {

        private final Method e;
        private final Method f;
        private e(Provider provider, Method method2, Method method3) {
            super(provider);
            this.e = method2;
            this.f = method3;
        }

        e(Provider provider, Method method2, Method method3, io.grpc.k1.r.f.a f$a4) {
            super(provider, method2, method3);
        }

        public void c(SSLSocket sSLSocket, String string2, List<io.grpc.k1.r.g> list3) {
            int string;
            io.grpc.k1.r.g hTTP_1_0;
            final javax.net.ssl.SSLParameters obj6 = sSLSocket.getSSLParameters();
            ArrayList arrayList = new ArrayList(list3.size());
            Iterator obj7 = list3.iterator();
            while (obj7.hasNext()) {
                string = obj7.next();
                if ((g)string == g.HTTP_1_0) {
                } else {
                }
                arrayList.add((g)string.toString());
            }
            Object[] arr = new Object[1];
            this.e.invoke(obj6, arrayList.toArray(new String[arrayList.size()]));
            sSLSocket.setSSLParameters(obj6);
        }

        @Override // io.grpc.k1.r.f
        public String h(SSLSocket sSLSocket) {
            try {
                return (String)this.f.invoke(sSLSocket, new Object[0]);
                RuntimeException runtimeException = new RuntimeException(sSLSocket);
                throw runtimeException;
                runtimeException = new RuntimeException(sSLSocket);
                throw runtimeException;
            }
        }

        @Override // io.grpc.k1.r.f
        public io.grpc.k1.r.f.h i() {
            return f.h.ALPN_AND_NPN;
        }
    }

    private static class f extends io.grpc.k1.r.f {

        private final Method e;
        private final Method f;
        private final Method g;
        private final Class<?> h;
        private final Class<?> i;
        public f(Method method, Method method2, Method method3, Class<?> class4, Class<?> class5, Provider provider6) {
            super(provider6);
            this.e = method;
            this.f = method2;
            this.g = method3;
            this.h = class4;
            this.i = class5;
        }

        @Override // io.grpc.k1.r.f
        public void a(SSLSocket sSLSocket) {
            Method method;
            int i;
            Object[] arr;
            Object obj5;
            try {
                arr = new Object[1];
                this.g.invoke(0, sSLSocket);
                f.b.log(Level.FINE, "Failed to remove SSLSocket from Jetty ALPN", sSLSocket);
                sSLSocket = new AssertionError();
                throw sSLSocket;
            }
        }

        public void c(SSLSocket sSLSocket, String string2, List<io.grpc.k1.r.g> list3) {
            int i;
            Object string;
            io.grpc.k1.r.g hTTP_1_0;
            ArrayList obj7 = new ArrayList(list3.size());
            final int i3 = 0;
            i = i3;
            while (i < list3.size()) {
                string = list3.get(i);
                if ((g)string == g.HTTP_1_0) {
                } else {
                }
                obj7.add((g)string.toString());
                i++;
            }
            int i2 = 2;
            Class[] arr2 = new Class[i2];
            arr2[i3] = this.h;
            int i5 = 1;
            arr2[i5] = this.i;
            f.g gVar = new f.g(obj7);
            Object[] arr = new Object[i2];
            arr[i3] = sSLSocket;
            arr[i5] = Proxy.newProxyInstance(f.class.getClassLoader(), arr2, gVar);
            this.e.invoke(0, arr);
        }

        @Override // io.grpc.k1.r.f
        public String h(SSLSocket sSLSocket) {
            boolean z;
            String obj4;
            try {
                Object[] arr = new Object[1];
                obj4 = 0;
                InvocationHandler invocationHandler = Proxy.getInvocationHandler(this.f.invoke(obj4, sSLSocket));
                if (!f.g.a((f.g)invocationHandler) && f.g.b(invocationHandler) == null) {
                }
                if (f.g.b(invocationHandler) == null) {
                }
                f.b.log(Level.INFO, "ALPN callback dropped: SPDY and HTTP/2 are disabled. Is alpn-boot on the boot class path?");
                return obj4;
                if (f.g.a(invocationHandler)) {
                } else {
                }
                obj4 = f.g.b(invocationHandler);
                return obj4;
                sSLSocket = new AssertionError();
                throw sSLSocket;
                sSLSocket = new AssertionError();
                throw sSLSocket;
            }
        }

        @Override // io.grpc.k1.r.f
        public io.grpc.k1.r.f.h i() {
            return f.h.ALPN_AND_NPN;
        }
    }
    static {
        f.b = Logger.getLogger(f.class.getName());
        f.c = /* result */;
        f.d = f.d();
    }

    public f(Provider provider) {
        super();
        this.a = provider;
    }

    public static byte[] b(List<io.grpc.k1.r.g> list) {
        int i;
        Object string;
        io.grpc.k1.r.g length;
        f fVar = new f();
        i = 0;
        while (i < list.size()) {
            string = list.get(i);
            if ((g)string == g.HTTP_1_0) {
            } else {
            }
            fVar.z0((g)string.toString().length());
            fVar.b1(string.toString());
            i++;
        }
        return fVar.X();
    }

    private static io.grpc.k1.r.f d() {
        Method method2;
        io.grpc.k1.r.f.h aLPN_AND_NPN;
        boolean equals;
        String str;
        Method method;
        Class<byte[]> obj = byte[].class;
        final Provider provider3 = f.f();
        int i = 1;
        int i2 = 0;
        int i3 = 0;
        if (provider3 != null) {
            Class[] arr2 = new Class[i];
            arr2[i3] = Boolean.TYPE;
            e eVar3 = new e(i2, "setUseSessionTickets", arr2);
            Class[] arr4 = new Class[i];
            arr4[i3] = String.class;
            e eVar4 = new e(i2, "setHostname", arr4);
            e eVar6 = new e(obj, "getAlpnSelectedProtocol", new Class[i3]);
            Class[] arr6 = new Class[i];
            arr6[i3] = obj;
            e eVar7 = new e(i2, "setAlpnProtocols", arr6);
            Class forName = Class.forName("android.net.TrafficStats");
            Class[] arr7 = new Class[i];
            arr7[i3] = Socket.class;
            method = forName.getMethod("tagSocket", arr7);
            Class[] arr = new Class[i];
            arr[i3] = Socket.class;
            method2 = forName.getMethod("untagSocket", arr);
            if (!provider3.getName().equals("GmsCore_OpenSSL") && !provider3.getName().equals("Conscrypt")) {
                if (!provider3.getName().equals("Conscrypt")) {
                    if (provider3.getName().equals("Ssl_Guard")) {
                        aLPN_AND_NPN = f.h.ALPN_AND_NPN;
                    } else {
                        aLPN_AND_NPN = f.k() ? f.h.ALPN_AND_NPN : z2 ? f.h.NPN : f.h.NONE;
                    }
                } else {
                }
            } else {
            }
            super(eVar3, eVar4, method, method2, eVar6, eVar7, provider3, aLPN_AND_NPN);
            return dVar2;
        }
        Provider provider2 = SSLContext.getDefault().getProvider();
        SSLContext instance = SSLContext.getInstance("TLS", provider2);
        instance.init(i2, i2, i2);
        f.a aVar = new f.a();
        (Method)AccessController.doPrivileged(aVar).invoke(instance.createSSLEngine(), new Object[i3]);
        f.b bVar = new f.b();
        f.c cVar = new f.c();
        f.e eVar5 = new f.e(provider2, (Method)AccessController.doPrivileged(bVar), (Method)AccessController.doPrivileged(cVar), i2);
        return eVar5;
    }

    public static io.grpc.k1.r.f e() {
        return f.d;
    }

    private static Provider f() {
        int i2;
        Provider provider;
        String[] strArr;
        int length;
        int i;
        String str;
        boolean equals;
        Provider[] providers = Security.getProviders();
        int i4 = 0;
        i2 = i4;
        while (i2 < providers.length) {
            provider = providers[i2];
            strArr = f.c;
            i = i4;
            while (i < strArr.length) {
                str = strArr[i];
                i++;
            }
            i2++;
            str = strArr[i];
            i++;
        }
        f.b.log(Level.WARNING, "Unable to find Conscrypt");
        return null;
    }

    private static boolean j() {
        try {
            f.class.getClassLoader().loadClass("android.app.ActivityOptions");
            return 1;
            f.b.log(Level.FINE, "Can't find class", th);
            Throwable th = null;
            return th;
        }
    }

    private static boolean k() {
        try {
            f.class.getClassLoader().loadClass("android.net.Network");
            return 1;
            f.b.log(Level.FINE, "Can't find class", th);
            Throwable th = null;
            return th;
        }
    }

    public void a(SSLSocket sSLSocket) {
    }

    public void c(SSLSocket sSLSocket, String string2, List<io.grpc.k1.r.g> list3) {
    }

    public Provider g() {
        return this.a;
    }

    public String h(SSLSocket sSLSocket) {
        return null;
    }

    public io.grpc.k1.r.f.h i() {
        return f.h.NONE;
    }
}
