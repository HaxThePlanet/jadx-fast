package com.facebook.e0.v;

import android.content.Context;
import android.util.Base64;
import android.util.Log;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.d0.d.b0;
import kotlin.d0.d.n;
import kotlin.io.b;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\u0008À\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000b\u001a\u00020\u00062\u0008\u0010\u000c\u001a\u0004\u0018\u00010\u0006H\u0007J!\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0015H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\u00060\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u0016", d2 = {"Lcom/facebook/appevents/internal/HashUtils;", "", "()V", "BUFFER_SIZE", "", "MD5", "", "TAG", "TRUSTED_CERTS", "", "[Ljava/lang/String;", "computeChecksum", "path", "computeChecksumWithPackageManager", "context", "Landroid/content/Context;", "nanosTimeout", "", "(Landroid/content/Context;Ljava/lang/Long;)Ljava/lang/String;", "computeFileMd5", "file", "Ljava/io/File;", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class g {

    private static final String a;
    private static final String[] b;
    public static final com.facebook.e0.v.g c;

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0008\u0002*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0008H\u0096\u0002¢\u0006\u0002\u0010\t¨\u0006\n", d2 = {"com/facebook/appevents/internal/HashUtils$computeChecksumWithPackageManager$listener$1", "Ljava/lang/reflect/InvocationHandler;", "invoke", "", "o", "method", "Ljava/lang/reflect/Method;", "objects", "", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class a implements InvocationHandler {

        final Object a;
        final b0 b;
        final ReentrantLock c;
        final Condition d;
        a(Object object, b0 b02, ReentrantLock reentrantLock3, Condition condition4) {
            this.a = object;
            this.b = b02;
            this.c = reentrantLock3;
            this.d = condition4;
            super();
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object object, Method method2, Object[] object3Arr3) {
            String str;
            boolean next;
            Object invoke;
            Object method;
            Object[] arr;
            Class[] arr2;
            boolean obj8;
            Object obj9;
            n.f(method2, "method");
            n.f(object3Arr3, "objects");
            int obj7 = 0;
            str = 1;
            obj8 = 0;
            if (n.b(method2.getName(), "onChecksumsReady") && object3Arr3.length == str && obj instanceof List != null) {
                str = 1;
                if (object3Arr3.length == str) {
                    obj8 = 0;
                    if (obj instanceof List != null) {
                        obj9 = object3Arr3[obj8];
                        if (obj9 == null) {
                        } else {
                            obj9 = (List)obj9.iterator();
                            for (Object next : obj9) {
                                Method method3 = next.getClass().getMethod("getSplitName", new Class[obj8]);
                                n.e(method3, "c.javaClass.getMethod(\"getSplitName\")");
                                method = next.getClass().getMethod("getType", new Class[obj8]);
                                n.e(method, "c.javaClass.getMethod(\"getType\")");
                            }
                        }
                        obj8 = new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<*>");
                        throw obj8;
                    }
                }
            }
            return obj7;
        }
    }
    static {
        g gVar = new g();
        g.c = gVar;
        String simpleName = g.class.getSimpleName();
        n.e(simpleName, "HashUtils::class.java.simpleName");
        g.a = simpleName;
        g.b = /* result */;
    }

    public static final String a(com.facebook.e0.v.g g) {
        return g.a;
    }

    public static final String b(String string) {
        File file = new File(string);
        return g.c.d(file);
    }

    public static final String c(Context context, Long long2) {
        long longValue;
        int i;
        java.security.cert.Certificate certificate;
        ByteArrayInputStream byteArrayInputStream;
        n.f(context, "context");
        String[] strArr = g.b;
        ArrayList arrayList = new ArrayList(strArr.length);
        final int i3 = 0;
        i = i3;
        while (i < strArr.length) {
            byteArrayInputStream = new ByteArrayInputStream(Base64.decode(strArr[i], i3));
            arrayList.add(CertificateFactory.getInstance("X.509").generateCertificate(byteArrayInputStream));
            i++;
        }
        b0 b0Var = new b0();
        int i2 = 0;
        b0Var.element = i2;
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();
        reentrantLock.lock();
        Class forName = Class.forName("android.content.pm.Checksum");
        n.e(forName, "Class.forName(\"android.content.pm.Checksum\")");
        Field field = forName.getField("TYPE_WHOLE_MD5");
        n.e(field, "checksumClass.getField(\"TYPE_WHOLE_MD5\")");
        Object obj2 = field.get(i2);
        Class forName2 = Class.forName("android.content.pm.PackageManager$OnChecksumsReadyListener");
        n.e(forName2, "Class.forName(\"android.c…nChecksumsReadyListener\")");
        final int i4 = 1;
        Class[] arr = new Class[i4];
        arr[i3] = forName2;
        g.a aVar = new g.a(obj2, b0Var, reentrantLock, condition);
        Object proxyInstance = Proxy.newProxyInstance(g.class.getClassLoader(), arr, aVar);
        n.e(proxyInstance, "Proxy.newProxyInstance(\n…       }\n              })");
        final int i5 = 5;
        final Class[] arr3 = new Class[i5];
        arr3[i3] = String.class;
        arr3[i4] = Boolean.TYPE;
        final int i7 = 2;
        arr3[i7] = Integer.TYPE;
        final int i8 = 3;
        arr3[i8] = List.class;
        int i6 = 4;
        arr3[i6] = forName2;
        Method method = PackageManager.class.getMethod("requestChecksums", arr3);
        n.e(method, "PackageManager::class.ja…ecksumReadyListenerClass)");
        Object[] arr2 = new Object[i5];
        arr2[i3] = context.getPackageName();
        Boolean fALSE = Boolean.FALSE;
        arr2[i4] = fALSE;
        arr2[i7] = obj2;
        arr2[i8] = p.N0(p.N0(arrayList));
        arr2[i6] = proxyInstance;
        method.invoke(context.getPackageManager(), arr2);
        if (long2 == null) {
            condition.await();
        } else {
            condition.awaitNanos(long2.longValue());
        }
        reentrantLock.unlock();
        return (String)b0Var.element;
    }

    private final String d(File file) {
        int read;
        int i;
        FileInputStream fileInputStream = new FileInputStream(file);
        int obj5 = 1024;
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream, obj5);
        MessageDigest instance = MessageDigest.getInstance("MD5");
        obj5 = new byte[obj5];
        read = bufferedInputStream.read(obj5);
        do {
            read = bufferedInputStream.read(obj5);
            if (read != -1) {
            }
            instance.update(obj5, 0, read);
        } while (read > 0);
        obj5 = new BigInteger(1, instance.digest());
        obj5 = obj5.toString(16);
        n.e(obj5, "BigInteger(1, md.digest()).toString(16)");
        b.a(bufferedInputStream, 0);
        return obj5;
    }
}
