package io.grpc.k1;

import com.google.common.base.n;
import io.grpc.j1.r0;
import io.grpc.k1.r.e;
import io.grpc.k1.r.f;
import io.grpc.k1.r.f.h;
import io.grpc.k1.r.g;
import io.grpc.k1.r.i;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;

/* compiled from: OkHttpProtocolNegotiator.java */
/* loaded from: classes3.dex */
class j {

    private static final Logger b;
    private static final f c;
    private static j d;
    protected final f a;

    static final class a extends j {

        private static final e<Socket> e = new e<>();
        private static final e<Socket> f = new e<>();
        private static final e<Socket> g = new e<>();
        private static final e<Socket> h = new e<>();
        private static final e<Socket> i = new e<>();
        private static final e<Socket> j = new e<>();
        private static final Method k = null;
        private static final Method l = null;
        private static final Method m = null;
        private static final Method n = null;
        private static final Method o = null;
        private static final Method p;
        private static final Constructor<?> q;
        static {
            String str3;
            Class cls;
            Object obj2;
            Class[] fINER2;
            Constructor constructor;
            Throwable th;
            Logger logger;
            Level fINER22;
            Class<byte[]> obj3 = byte[].class;
            final int i2 = 1;
            final Class tYPE2 = Boolean.TYPE;
            final int i4 = 0;
            new Class[i2][i4] = tYPE2;
            new Class[i2][i4] = String.class;
            
            new Class[i2][i4] = obj3;
            
            new Class[i2][i4] = obj3;
            try {
                Class<javax.net.ssl.SSLParameters> obj4 = SSLParameters.class;
                Class[] arr7 = new Class[i2];
                arr7[i4] = String[].class;
            } catch (java.lang.NoSuchMethodException noSuchMethod) {
                obj2 = constructor;
            } catch (java.lang.ClassNotFoundException classNotFound1) {
                obj2 = constructor;
            }
            try {
            } catch (java.lang.NoSuchMethodException noSuchMethod) {
                obj2 = constructor;
            } catch (java.lang.ClassNotFoundException classNotFound1) {
                obj2 = constructor;
            }
            try {
            } catch (java.lang.NoSuchMethodException noSuchMethod) {
            } catch (java.lang.ClassNotFoundException classNotFound1) {
            }
            try {
                Class cls2 = Class.forName("android.net.ssl.SSLSockets");
                Class[] arr10 = new Class[i2];
                arr10[i4] = SSLSocket.class;
            } catch (java.lang.NoSuchMethodException noSuchMethod) {
            } catch (java.lang.ClassNotFoundException classNotFound1) {
            }
            try {
                Class[] arr11 = new Class[2];
                arr11[i4] = SSLSocket.class;
                arr11[i2] = tYPE2;
            } catch (java.lang.NoSuchMethodException noSuchMethod) {
            } catch (java.lang.ClassNotFoundException classNotFound1) {
            }
        }

        a(f fVar) {
            super(fVar);
        }

        @Override // io.grpc.k1.j
        protected void c(SSLSocket sSLSocket, String str, List<g> list) {
            boolean z;
            Object[] arr;
            Object[] arr3;
            Object[] arr4;
            Object obj = null;
            Boolean tRUE2;
            int i;
            String[] strArr = j.i(list);
            javax.net.ssl.SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            i = 1;
            i = 0;
            if (str != null && j.g(str)) {
                method = j.a.k;
                if (j.a.k != null) {
                    Object[] arr2 = new Object[i];
                    obj = null;
                    if ((Boolean)j.a.k.invoke(obj, new Object[] { sSLSocket }).booleanValue()) {
                        arr3 = new Object[2];
                        j.a.l.invoke(obj, new Object[] { sSLSocket, Boolean.TRUE });
                    } else {
                        arr3 = new Object[i];
                        j.a.e.e(sSLSocket, Boolean.TRUE);
                    }
                }
                Method method4 = j.a.p;
                if (j.a.p == null || j.a.q == null) {
                    arr4 = new Object[i];
                    j.a.f.e(sSLSocket, str);
                } else {
                    Object[] arr6 = new Object[i];
                    Object[] arr7 = new Object[i];
                    j.a.p.invoke(sSLParameters, new Object[] { Collections.singletonList(j.a.q.newInstance(new Object[] { str })) });
                }
            }
            method3 = j.a.o;
            if (method3 != null) {
                try {
                    method3.invoke(sSLSocket, new Object[i]);
                    arr = new Object[i];
                    j.a.m.invoke(sSLParameters, new Object[] { strArr });
                } catch (java.lang.reflect.InvocationTargetException invocationTarget) {
                } catch (java.lang.InstantiationException instantiation1) {
                    invocationTarget = new RuntimeException(instantiation1);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) invocationTarget;
                } catch (java.lang.IllegalAccessException illegalAccess2) {
                    invocationTarget = new RuntimeException(illegalAccess2);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) invocationTarget;
                }
            } else {
            }
            illegalAccess2.setSSLParameters(sSLParameters);
            if (j.a.n != 0 && j.a.n != null) {
                if (Arrays.equals(strArr, (String[])j.a.n.invoke(illegalAccess2.getSSLParameters(), new Object[i]))) {
                    return;
                }
            }
            Object[] arr8 = new Object[i];
            if (this.a.i() == f.h.ALPN_AND_NPN) {
                j.a.h.f(illegalAccess2, f.b(list));
            }
            if (this.a.i() == f.h.NONE) {
                throw new RuntimeException("We can not do TLS handshake on this Android version, please install the Google Play Services Dynamic Security Provider to use TLS");
            } else {
                j.a.j.f(illegalAccess2, arr8);
                return;
            }
        }

        @Override // io.grpc.k1.j
        public String f(SSLSocket sSLSocket) throws InvocationTargetException, java.lang.IllegalAccessException, java.io.UnsupportedEncodingException {
            String obj5;
            method = j.a.o;
            int i = 0;
            if (j.a.o != null) {
                try {
                } catch (Exception e) {
                    Throwable str = j.b;
                    String fINE22 = Level.FINE;
                    str.log(fINE22, "Failed calling getAlpnSelectedProtocol()", e);
                }
                return (String)j.a.o.invoke(sSLSocket, new Object[i]);
            }
            if (this.a.i() == f.h.ALPN_AND_NPN) {
                try {
                    Object obj2 = j.a.g.f(sSLSocket, new Object[i]);
                } catch (Exception e) {
                    str = j.b;
                    fINE22 = Level.FINE;
                    str.log(fINE22, "Failed calling getAlpnSelectedProtocol()", e);
                }
            }
            if (this.a.i() != f.h.NONE) {
                try {
                    Object obj = j.a.i.f(sSLSocket, new Object[i]);
                } catch (Exception e) {
                    Throwable e2 = j.b;
                    str = "Failed calling getNpnSelectedProtocol()";
                    e2.log(Level.FINE, str, e);
                }
            }
            return null;
        }

        @Override // io.grpc.k1.j
        public String h(SSLSocket sSLSocket, String str, List<g> list) {
            if (f(sSLSocket) == null) {
                str = j.super.h(sSLSocket, str, list);
            }
            return str;
        }
    }
    static {
        Class<io.grpc.k1.j> obj = j.class;
        j.b = Logger.getLogger(obj.getName());
        j.c = f.e();
        j.d = j.d(obj.getClassLoader());
    }

    j(f fVar) {
        super();
        n.p(fVar, "platform");
        this.a = fVar;
    }

    static /* synthetic */ Logger a() {
        return j.b;
    }

    static /* synthetic */ String[] b(List list) {
        return j.i(list);
    }

    static j d(java.lang.ClassLoader classLoader) {
        String str;
        int i = 1;
        io.grpc.k1.j.a aVar;
        try {
            str = "com.android.org.conscrypt.OpenSSLSocketImpl";
            classLoader.loadClass(str);
        } catch (java.lang.ClassNotFoundException classNotFound) {
            Throwable th = j.b;
            Logger fINE2 = Level.FINE;
            Level str2 = "Unable to find any OpenSSLSocketImpl. Skipping";
            th.log(fINE2, str2, classNotFound);
            classNotFound = null;
        }
        i = 1;
        if (i != 0) {
            aVar = new j.a(j.c);
        } else {
            io.grpc.k1.j jVar = new j(j.c);
        }
        return aVar;
    }

    public static j e() {
        return j.d;
    }

    static boolean g(String str) {
        if (str.contains("_")) {
            return false;
        }
        try {
            r0.c(str);
        } catch (java.lang.IllegalArgumentException unused) {
            return z;
        }
        return true;
    }

    private static String[] i(List<g> list) {
        final ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((g)it.next().toString());
        }
        return (String[])arrayList.toArray(new String[0]);
    }

    protected void c(SSLSocket sSLSocket, String str, List<g> list) {
        this.a.c(sSLSocket, str, list);
    }

    public String f(SSLSocket sSLSocket) {
        return this.a.h(sSLSocket);
    }

    public String h(SSLSocket sSLSocket, String str, List<g> list) {
        if (list != null) {
            c(sSLSocket, str, list);
        }
        try {
            sSLSocket.startHandshake();
            String str3 = f(sSLSocket);
        } finally {
            this.a.a(sSLSocket);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) str;
        }
        if (str3 != null) {
            this.a.a(sSLSocket);
            return str3;
        } else {
            try {
                final StringBuilder stringBuilder = new StringBuilder();
                str = "TLS ALPN negotiation failed with protocols: ";
                list = str + this.a;
                throw new RuntimeException(list);
            } finally {
                this.a.a(sSLSocket);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) str;
            }
        }
    }
}
