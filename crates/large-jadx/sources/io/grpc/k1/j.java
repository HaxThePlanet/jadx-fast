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

/* loaded from: classes3.dex */
class j {

    private static final Logger b;
    private static final f c;
    private static io.grpc.k1.j d;
    protected final f a;

    static final class a extends io.grpc.k1.j {

        private static final e<Socket> e;
        private static final e<Socket> f;
        private static final e<Socket> g;
        private static final e<Socket> h;
        private static final e<Socket> i;
        private static final e<Socket> j;
        private static final Method k = null;
        private static final Method l = null;
        private static final Method m = null;
        private static final Method n = null;
        private static final Method o = null;
        private static final Method p;
        private static final Constructor<?> q;
        static {
            String str2;
            Class cls;
            String str;
            Class[] fINER;
            Class<List> obj;
            Throwable th;
            String constructor;
            Logger logger;
            Level fINER2;
            String str3;
            final String str4 = "Failed to find Android 7.0+ APIs";
            String str5 = "Failed to find Android 10.0+ APIs";
            Class<byte[]> obj3 = byte[].class;
            final int i = 1;
            Class[] arr = new Class[i];
            final Class tYPE = Boolean.TYPE;
            final int i2 = 0;
            arr[i2] = tYPE;
            final int i3 = 0;
            final String str9 = "setUseSessionTickets";
            e eVar = new e(i3, str9, arr);
            j.a.e = eVar;
            Class[] arr2 = new Class[i];
            arr2[i2] = String.class;
            e eVar2 = new e(i3, "setHostname", arr2);
            j.a.f = eVar2;
            e eVar3 = new e(obj3, "getAlpnSelectedProtocol", new Class[i2]);
            j.a.g = eVar3;
            Class[] arr4 = new Class[i];
            arr4[i2] = obj3;
            e eVar4 = new e(i3, "setAlpnProtocols", arr4);
            j.a.h = eVar4;
            e eVar5 = new e(obj3, "getNpnSelectedProtocol", new Class[i2]);
            j.a.i = eVar5;
            Class[] arr6 = new Class[i];
            arr6[i2] = obj3;
            e eVar6 = new e(i3, "setNpnProtocols", arr6);
            j.a.j = eVar6;
            Class<javax.net.ssl.SSLParameters> obj4 = SSLParameters.class;
            Class[] arr7 = new Class[i];
            arr7[i2] = String[].class;
            Method method3 = obj4.getMethod("setApplicationProtocols", arr7);
            Method method2 = obj4.getMethod("getApplicationProtocols", new Class[i2]);
            Method method4 = SSLSocket.class.getMethod("getApplicationProtocol", new Class[i2]);
            Class forName = Class.forName("android.net.ssl.SSLSockets");
            Class[] arr10 = new Class[i];
            arr10[i2] = SSLSocket.class;
            Method method5 = forName.getMethod("isSupportedSocket", arr10);
            Class[] arr11 = new Class[2];
            arr11[i2] = SSLSocket.class;
            arr11[i] = tYPE;
            Method method = forName.getMethod(str9, arr11);
        }

        a(f f) {
            super(f);
        }

        protected void c(SSLSocket sSLSocket, String string2, List<g> list3) {
            javax.net.ssl.SSLParameters sSLParameters;
            Object method;
            Method booleanValue;
            boolean fINER;
            Object[] str;
            int tRUE;
            Boolean tRUE2;
            Object obj10;
            Object obj11;
            String[] strArr = j.b(list3);
            sSLParameters = sSLSocket.getSSLParameters();
            final int i = 1;
            final int i2 = 0;
            if (string2 != null && j.g(string2)) {
                if (j.g(string2)) {
                    booleanValue = j.a.k;
                    str = new Object[i];
                    str[i2] = sSLSocket;
                    tRUE = 0;
                    if (booleanValue != null && (Boolean)booleanValue.invoke(tRUE, str).booleanValue()) {
                        str = new Object[i];
                        str[i2] = sSLSocket;
                        tRUE = 0;
                        if ((Boolean)booleanValue.invoke(tRUE, str).booleanValue()) {
                            str = new Object[2];
                            str[i2] = sSLSocket;
                            str[i] = Boolean.TRUE;
                            j.a.l.invoke(tRUE, str);
                        } else {
                            str = new Object[i];
                            str[i2] = Boolean.TRUE;
                            j.a.e.e(sSLSocket, str);
                        }
                    } else {
                    }
                    fINER = j.a.p;
                    str = j.a.q;
                    if (fINER != null && str != null) {
                        str = j.a.q;
                        if (str != null) {
                            tRUE = new Object[i];
                            tRUE2 = new Object[i];
                            tRUE2[i2] = string2;
                            tRUE[i2] = Collections.singletonList(str.newInstance(tRUE2));
                            fINER.invoke(sSLParameters, tRUE);
                        } else {
                            str = new Object[i];
                            str[i2] = string2;
                            j.a.f.e(sSLSocket, str);
                        }
                    } else {
                    }
                }
            }
            obj10 = j.a.o;
            if (obj10 != null) {
                obj10.invoke(sSLSocket, new Object[i2]);
                fINER = new Object[i];
                fINER[i2] = strArr;
                j.a.m.invoke(sSLParameters, fINER);
                obj10 = i;
            } else {
                obj10 = i2;
            }
            sSLSocket.setSSLParameters(sSLParameters);
            obj10 = j.a.n;
            if (obj10 != null && obj10 != null && Arrays.equals(strArr, (String[])obj10.invoke(sSLSocket.getSSLParameters(), new Object[i2]))) {
                obj10 = j.a.n;
                if (obj10 != null) {
                    if (Arrays.equals(strArr, (String[])obj10.invoke(sSLSocket.getSSLParameters(), new Object[i2]))) {
                    }
                }
            }
            obj10 = new Object[i];
            obj10[i2] = f.b(list3);
            if (this.a.i() == f.h.ALPN_AND_NPN) {
                j.a.h.f(sSLSocket, obj10);
            }
            if (this.a.i() == f.h.NONE) {
            } else {
                j.a.j.f(sSLSocket, obj10);
            }
            RuntimeException obj9 = new RuntimeException("We can not do TLS handshake on this Android version, please install the Google Play Services Dynamic Security Provider to use TLS");
            throw obj9;
        }

        @Override // io.grpc.k1.j
        public String f(SSLSocket sSLSocket) {
            Method method;
            Object hVar2;
            Object hVar;
            int arr;
            Throwable str;
            f.h aLPN_AND_NPN;
            f.h nONE;
            String fINE;
            String str2;
            Object obj6;
            method = j.a.o;
            arr = 0;
            if (method != null) {
                return (String)method.invoke(sSLSocket, new Object[arr]);
            }
            hVar2 = j.a.g.f(sSLSocket, new Object[arr]);
            if (this.a.i() == f.h.ALPN_AND_NPN && (byte[])hVar2 != null) {
                hVar2 = j.a.g.f(sSLSocket, new Object[arr]);
                if ((byte[])(byte[])hVar2 != null) {
                    String string2 = new String((byte[])(byte[])hVar2, i.b);
                    return string2;
                }
            }
            obj6 = j.a.i.f(sSLSocket, new Object[arr]);
            if (this.a.i() != f.h.NONE && (byte[])obj6 != null) {
                obj6 = j.a.i.f(sSLSocket, new Object[arr]);
                if ((byte[])(byte[])obj6 != null) {
                    String string = new String((byte[])(byte[])obj6, i.b);
                    return string;
                }
            }
            return null;
        }

        public String h(SSLSocket sSLSocket, String string2, List<g> list3) {
            String str;
            if (f(sSLSocket) == null) {
                str = super.h(sSLSocket, string2, list3);
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

    j(f f) {
        super();
        n.p(f, "platform");
        this.a = (f)f;
    }

    static Logger a() {
        return j.b;
    }

    static String[] b(List list) {
        return j.i(list);
    }

    static io.grpc.k1.j d(java.lang.ClassLoader classLoader) {
        String str2;
        f fVar;
        Logger fINE;
        Level str;
        String str3;
        int obj4;
        try {
            classLoader.loadClass("com.android.org.conscrypt.OpenSSLSocketImpl");
            fINE = j.b;
            str = Level.FINE;
            fINE.log(str, "Unable to find Conscrypt. Skipping", th);
            Throwable th = "org.apache.harmony.xnet.provider.jsse.OpenSSLSocketImpl";
            classLoader.loadClass(th);
            obj4 = 1;
            th = j.b;
            fINE = Level.FINE;
            str = "Unable to find any OpenSSLSocketImpl. Skipping";
            th.log(fINE, str, classLoader);
            classLoader = null;
        } catch (java.lang.ClassNotFoundException classNotFound) {
        }
        obj4 = new j.a(j.c);
        return obj4;
    }

    public static io.grpc.k1.j e() {
        return j.d;
    }

    static boolean g(String string) {
        if (string.contains("_")) {
            return 0;
        }
        r0.c(string);
        return 1;
    }

    private static String[] i(List<g> list) {
        String string;
        ArrayList arrayList = new ArrayList();
        Iterator obj2 = list.iterator();
        for (g next2 : obj2) {
            arrayList.add(next2.toString());
        }
        return (String[])arrayList.toArray(new String[0]);
    }

    protected void c(SSLSocket sSLSocket, String string2, List<g> list3) {
        this.a.c(sSLSocket, string2, list3);
    }

    public String f(SSLSocket sSLSocket) {
        return this.a.h(sSLSocket);
    }

    public String h(SSLSocket sSLSocket, String string2, List<g> list3) {
        if (list3 != null) {
            c(sSLSocket, string2, list3);
        }
        sSLSocket.startHandshake();
        String obj4 = f(sSLSocket);
        if (obj4 == null) {
        } else {
            this.a.a(sSLSocket);
            return obj4;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TLS ALPN negotiation failed with protocols: ");
        stringBuilder.append(list3);
        obj4 = new RuntimeException(stringBuilder.toString());
        throw obj4;
    }
}
