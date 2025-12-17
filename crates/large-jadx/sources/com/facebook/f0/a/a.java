package com.facebook.f0.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdManager.RegistrationListener;
import android.net.nsd.NsdServiceInfo;
import android.os.Build;
import android.os.Build.VERSION;
import com.facebook.internal.a0;
import com.facebook.internal.b0;
import com.facebook.internal.g0.i.a;
import com.facebook.internal.p;
import com.facebook.internal.q;
import com.facebook.o;
import com.google.zxing.WriterException;
import com.google.zxing.a;
import com.google.zxing.c;
import com.google.zxing.d;
import com.google.zxing.g.b;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a {

    private static final String a = "com.facebook.f0.a.a";
    private static HashMap<String, NsdManager.RegistrationListener> b;

    static class a implements NsdManager.RegistrationListener {

        final String a;
        final String b;
        a(String string, String string2) {
            this.a = string;
            this.b = string2;
            super();
        }

        @Override // android.net.nsd.NsdManager$RegistrationListener
        public void onRegistrationFailed(NsdServiceInfo nsdServiceInfo, int i2) {
            a.a(this.b);
        }

        @Override // android.net.nsd.NsdManager$RegistrationListener
        public void onServiceRegistered(NsdServiceInfo nsdServiceInfo) {
            boolean obj2;
            if (!this.a.equals(nsdServiceInfo.getServiceName())) {
                a.a(this.b);
            }
        }

        @Override // android.net.nsd.NsdManager$RegistrationListener
        public void onServiceUnregistered(NsdServiceInfo nsdServiceInfo) {
        }

        @Override // android.net.nsd.NsdManager$RegistrationListener
        public void onUnregistrationFailed(NsdServiceInfo nsdServiceInfo, int i2) {
        }
    }
    static {
        HashMap hashMap = new HashMap();
        a.b = hashMap;
    }

    public static void a(String string) {
        if (a.d(a.class)) {
        }
        a.b(string);
    }

    private static void b(String string) {
        Object obj;
        Object systemService;
        String str;
        if (a.d(a.class)) {
        }
        obj = a.b.get(string);
        if ((NsdManager.RegistrationListener)obj != null) {
            (NsdManager)o.f().getSystemService("servicediscovery").unregisterService((NsdManager.RegistrationListener)obj);
            a.b.remove(string);
        }
    }

    public static Bitmap c(String string) {
        int i;
        int i2;
        a qR_CODE;
        int i3;
        int i4;
        EnumMap enumMap;
        Bitmap obj11;
        if (a.d(a.class)) {
            return null;
        }
        enumMap = new EnumMap(c.class);
        enumMap.put(c.MARGIN, 2);
        d dVar = new d();
        obj11 = dVar.a(string, a.QR_CODE, 200, 200, enumMap);
        final int i13 = obj11.e();
        final int i12 = obj11.f();
        int[] iArr = new int[i13 * i12];
        int i6 = 0;
        i2 = i6;
        while (i2 < i13) {
            i3 = i6;
            while (i3 < i12) {
                if (obj11.d(i3, i2)) {
                } else {
                }
                enumMap = -1;
                iArr[qR_CODE + i3] = enumMap;
                i3++;
                enumMap = -16777216;
            }
            i2++;
            if (obj11.d(i3, i2)) {
            } else {
            }
            enumMap = -1;
            iArr[qR_CODE + i3] = enumMap;
            i3++;
            enumMap = -16777216;
        }
        Bitmap.createBitmap(i12, i13, Bitmap.Config.ARGB_8888).setPixels(iArr, 0, i12, 0, 0, i12, i13);
        return obj11;
    }

    public static String d() {
        final int i = 0;
        if (a.d(a.class)) {
            return i;
        }
        return a.e(i);
    }

    public static String e(Map<String, String> map) {
        Object obj4;
        if (a.d(a.class)) {
            return null;
        }
        if (map == null) {
            obj4 = new HashMap();
        }
        obj4.put("device", Build.DEVICE);
        obj4.put("model", Build.MODEL);
        JSONObject jSONObject = new JSONObject(obj4);
        return jSONObject.toString();
    }

    public static boolean f() {
        Class<com.facebook.f0.a.a> contains;
        Object pVar;
        int i;
        int sDK_INT;
        if (a.d(a.class)) {
            return 0;
        }
        pVar = q.j(o.g());
        if (Build.VERSION.SDK_INT >= 16 && pVar != null && pVar.j().contains(a0.Enabled)) {
            if (pVar != null) {
                if (pVar.j().contains(a0.Enabled)) {
                    i = 1;
                }
            }
        }
        return i;
    }

    public static boolean g(String string) {
        final int i = 0;
        if (a.d(a.class)) {
            return i;
        }
        if (a.f()) {
            return a.h(string);
        }
        return i;
    }

    private static boolean h(String string) {
        final int i = 0;
        if (a.d(a.class)) {
            return i;
        }
        final int i2 = 1;
        if (a.b.containsKey(string)) {
            return i2;
        }
        Object[] arr = new Object[3];
        arr[i] = "fbsdk";
        final int i7 = 2;
        final Object[] arr2 = new Object[i7];
        arr2[i] = "android";
        arr2[i2] = o.u().replace('.', '|');
        arr[i2] = String.format("%s-%s", arr2);
        arr[i7] = string;
        String format2 = String.format("%s_%s_%s", arr);
        NsdServiceInfo nsdServiceInfo = new NsdServiceInfo();
        nsdServiceInfo.setServiceType("_fb._tcp.");
        nsdServiceInfo.setServiceName(format2);
        nsdServiceInfo.setPort(80);
        a.a aVar = new a.a(format2, string);
        a.b.put(string, aVar);
        (NsdManager)o.f().getSystemService("servicediscovery").registerService(nsdServiceInfo, i2, aVar);
        return i2;
    }
}
