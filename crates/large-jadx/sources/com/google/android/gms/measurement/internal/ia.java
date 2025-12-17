package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.f;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.o.b;
import com.google.android.gms.common.o.c;
import com.google.android.gms.common.util.e;
import com.google.android.gms.common.util.f;
import com.google.android.gms.internal.measurement.i1;
import com.google.android.gms.internal.measurement.kd;
import java.io.ByteArrayInputStream;
import java.net.URL;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicLong;
import javax.security.auth.x500.X500Principal;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* loaded from: classes2.dex */
public final class ia extends com.google.android.gms.measurement.internal.w5 {

    private static final String[] g;
    private static final String[] h;
    public static final int i;
    private SecureRandom c;
    private final AtomicLong d;
    private int e;
    private Integer f = null;
    static {
        ia.g = /* result */;
        ia.h = /* result */;
    }

    ia(com.google.android.gms.measurement.internal.b5 b5) {
        super(b5);
        int obj3 = 0;
        obj3 = new AtomicLong(0, obj1);
        this.d = obj3;
    }

    static boolean V(String string) {
        boolean empty;
        java.lang.CharSequence obj1;
        if (!TextUtils.isEmpty(string) && string.startsWith("_")) {
            if (string.startsWith("_")) {
                return 1;
            }
        }
        return 0;
    }

    static boolean W(String string) {
        char charAt;
        String obj3;
        r.f(string);
        final int i = 0;
        if (string.charAt(i) == 95 && string.equals("_ep")) {
            if (string.equals("_ep")) {
            }
            return i;
        }
        return 1;
    }

    static boolean X(Context context) {
        android.content.pm.ActivityInfo obj4;
        r.j(context);
        final int i = 0;
        final PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return i;
        }
        ComponentName componentName = new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementReceiver");
        obj4 = packageManager.getReceiverInfo(componentName, i);
        if (obj4 != null && obj4.enabled) {
            if (obj4.enabled) {
                try {
                    return 1;
                    return i;
                }
            }
        }
    }

    static boolean Y(Context context, boolean z2) {
        r.j(context);
        if (Build.VERSION.SDK_INT >= 24) {
            return ia.i0(context, "com.google.android.gms.measurement.AppMeasurementJobService");
        }
        return ia.i0(context, "com.google.android.gms.measurement.AppMeasurementService");
    }

    static boolean Z(String string, String string2) {
        if (string == null && string2 != null) {
            if (string2 != null) {
            }
            return 1;
        }
        if (string == null) {
            return 0;
        }
        return string.equals(string2);
    }

    public static boolean a0(String string) {
        final int i = 0;
        if (ia.h[i].equals(string)) {
            return i;
        }
        return 1;
    }

    static final boolean d0(Bundle bundle, int i2) {
        final String str = "_err";
        if (Long.compare(long, i) == 0) {
            bundle.putLong(str, (long)i2);
            return 1;
        }
        return 0;
    }

    static final boolean e0(String string) {
        r.j(string);
        return string.matches("^(1:\\d+:android:[a-f0-9]+|ca-app-pub-.*)$");
    }

    private final int f0(String string) {
        boolean str;
        Object obj4;
        if ("_ldl".equals(string)) {
            this.a.z();
            return 2048;
        }
        if (!"_id".equals(string) && this.a.z().B(0, c3.c0) && "_lgclid".equals(string)) {
            if (this.a.z().B(0, c3.c0)) {
                if ("_lgclid".equals(string)) {
                    this.a.z();
                    return 100;
                }
            }
            this.a.z();
            return 36;
        }
        this.a.z();
        return 256;
    }

    private final Object g0(int i, Object object2, boolean z3, boolean z4) {
        int i2;
        boolean empty;
        boolean z;
        int obj3;
        int obj6;
        i2 = 0;
        if (object2 == null) {
            return i2;
        }
        if (!object2 instanceof Long) {
            if (object2 instanceof Double) {
            } else {
                if (object2 instanceof Integer) {
                    return Long.valueOf((long)obj3);
                }
                if (object2 instanceof Byte) {
                    return Long.valueOf((long)obj3);
                }
                if (object2 instanceof Short) {
                    return Long.valueOf((long)obj3);
                }
                if (object2 instanceof Boolean) {
                    int obj4 = 1;
                    obj3 = obj4 != (Boolean)object2.booleanValue() ? 0 : 1;
                    return Long.valueOf(obj3);
                }
                if (object2 instanceof Float) {
                    return Double.valueOf((Float)object2.doubleValue());
                }
                if (object2 instanceof String == null && !object2 instanceof Character) {
                    if (!object2 instanceof Character) {
                        if (object2 instanceof CharSequence) {
                        } else {
                            if (z4) {
                                if (!object2 instanceof Bundle[]) {
                                    if (object2 instanceof Parcelable[]) {
                                        obj3 = new ArrayList();
                                        obj6 = 0;
                                        while (obj6 < object2.length) {
                                            i2 = (Parcelable[])object2[obj6];
                                            i2 = u0((Bundle)i2);
                                            if (i2 instanceof Bundle != null && !i2.isEmpty()) {
                                            }
                                            obj6++;
                                            i2 = u0((Bundle)i2);
                                            if (!i2.isEmpty()) {
                                            }
                                            obj3.add(i2);
                                        }
                                    }
                                } else {
                                }
                                return obj3.toArray(new Bundle[obj3.size()]);
                            }
                        }
                        return i2;
                    }
                }
            }
            return q(object2.toString(), i, z3);
        }
        return object2;
    }

    private static boolean h0(String string, String[] string2Arr2) {
        int i;
        boolean z;
        r.j(string2Arr2);
        final int i2 = 0;
        i = i2;
        while (i < string2Arr2.length) {
            i++;
        }
        return i2;
    }

    private static boolean i0(Context context, String string2) {
        android.content.pm.ServiceInfo obj3;
        final int i = 0;
        final PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            try {
                return i;
                ComponentName componentName = new ComponentName(context, string2);
                obj3 = packageManager.getServiceInfo(componentName, i);
                if (obj3 != null && obj3.enabled) {
                }
                if (obj3.enabled) {
                }
                return 1;
                return i;
            }
        }
    }

    static long q0(byte[] bArr) {
        int i2;
        int i4;
        int i3;
        int i5;
        int i6;
        int i;
        r.j(bArr);
        int length = bArr.length;
        i3 = length > 0 ? 1 : i4;
        r.m(i3);
        length--;
        i5 = 0;
        while (i2 >= 0) {
            if (i2 >= length2 += -8) {
            }
            i5 += i6;
            i4 += 8;
            i2--;
        }
        return i5;
    }

    static MessageDigest s() {
        int i;
        MessageDigest instance;
        i = 0;
        while (i < 2) {
            instance = MessageDigest.getInstance("MD5");
            i++;
        }
        return null;
    }

    public static ArrayList<Bundle> u(List<com.google.android.gms.measurement.internal.c> list) {
        int size;
        Bundle bundle;
        long str;
        Object uVar;
        Object uVar2;
        String str5;
        String str4;
        String str3;
        String str2;
        if (list == null) {
            ArrayList obj6 = new ArrayList(0);
            return obj6;
        }
        ArrayList arrayList = new ArrayList(list.size());
        obj6 = list.iterator();
        while (obj6.hasNext()) {
            Object next2 = obj6.next();
            bundle = new Bundle();
            bundle.putString("app_id", next2.a);
            String str11 = "origin";
            bundle.putString(str11, next2.b);
            bundle.putLong("creation_timestamp", next2.v);
            bundle.putString("name", eaVar.b);
            Object obj = next2.c.j2();
            r.j(obj);
            y5.b(bundle, obj);
            bundle.putBoolean("active", next2.w);
            String str9 = next2.x;
            if (str9 != null) {
            }
            uVar = next2.y;
            bundle.putString("timed_out_event_name", uVar.a);
            uVar = uVar.b;
            if (uVar != null && uVar != null) {
            }
            bundle.putLong("trigger_timeout", next2.z);
            uVar2 = next2.A;
            bundle.putString("triggered_event_name", uVar2.a);
            uVar2 = uVar2.b;
            if (uVar2 != null && uVar2 != null) {
            }
            bundle.putLong("triggered_timestamp", eaVar3.c);
            bundle.putLong("time_to_live", next2.B);
            size = next2.C;
            bundle.putString("expired_event_name", size.a);
            size = size.b;
            if (size != null && size != null) {
            }
            arrayList.add(bundle);
            bundle.putString("expired_event_name", size.a);
            size = size.b;
            if (size != null) {
            }
            bundle.putBundle("expired_event_params", size.k2());
            bundle.putString("triggered_event_name", uVar2.a);
            uVar2 = uVar2.b;
            if (uVar2 != null) {
            }
            bundle.putBundle("triggered_event_params", uVar2.k2());
            bundle.putString("timed_out_event_name", uVar.a);
            uVar = uVar.b;
            if (uVar != null) {
            }
            bundle.putBundle("timed_out_event_params", uVar.k2());
            bundle.putString("trigger_event_name", str9);
        }
        return arrayList;
    }

    public static void x(com.google.android.gms.measurement.internal.p7 p7, Bundle bundle2, boolean z3) {
        boolean key;
        int obj6;
        final String str = "_si";
        String str2 = "_sn";
        final String str3 = "_sc";
        if (bundle2 != null && p7 != null) {
            if (p7 != null) {
                if (bundle2.containsKey(str3)) {
                    if (z3 != 0) {
                        obj6 = p7.a;
                        if (obj6 != null) {
                            bundle2.putString(str2, obj6);
                        } else {
                            bundle2.remove(str2);
                        }
                        obj6 = p7.b;
                        if (obj6 != null) {
                            bundle2.putString(str3, obj6);
                        } else {
                            bundle2.remove(str3);
                        }
                    }
                    obj6 = 0;
                } else {
                }
                bundle2.putLong(str, p7.c);
            }
        }
        if (bundle2 != null && p7 == null && obj6 != null) {
            if (p7 == null) {
                if (obj6 != null) {
                    bundle2.remove(str2);
                    bundle2.remove(str3);
                    bundle2.remove(str);
                }
            }
        }
    }

    @Override // com.google.android.gms.measurement.internal.w5
    final void A(com.google.android.gms.measurement.internal.ha ha, String string2, int i3, String string4, String string5, int i6) {
        boolean empty;
        long obj5;
        int obj6;
        Object obj7;
        Bundle bundle = new Bundle();
        ia.d0(bundle, i3);
        if (!TextUtils.isEmpty(string4) && !TextUtils.isEmpty(string5)) {
            if (!TextUtils.isEmpty(string5)) {
                bundle.putString(string4, string5);
            }
        }
        if (i3 != 6 && i3 != 7) {
            if (i3 != 7) {
                if (i3 == 2) {
                    bundle.putLong("_el", (long)i6);
                }
            } else {
            }
        } else {
        }
        ha.a(string2, "_err", bundle);
    }

    @Override // com.google.android.gms.measurement.internal.w5
    final void B(Bundle bundle, String string2, Object object3) {
        boolean str;
        String obj3;
        String obj4;
        Object obj5;
        if (bundle == null) {
        }
        if (object3 instanceof Long) {
            bundle.putLong(string2, (Long)object3.longValue());
        }
        if (object3 instanceof String != null) {
            bundle.putString(string2, String.valueOf(object3));
        }
        if (object3 instanceof Double) {
            bundle.putDouble(string2, (Double)object3.doubleValue());
        }
        if (object3 instanceof Bundle[]) {
            bundle.putParcelableArray(string2, (Bundle[])object3);
        }
        if (string2 != null) {
            if (object3 != null) {
                obj3 = object3.getClass().getSimpleName();
            } else {
                obj3 = 0;
            }
            this.a.b().x().c("Not putting event parameter. Invalid value type. name, type", this.a.D().e(string2), obj3);
        }
    }

    @Override // com.google.android.gms.measurement.internal.w5
    public final void C(i1 i1, boolean z2) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("r", z2);
        i1.c(bundle);
    }

    public final void D(i1 i1, ArrayList<Bundle> arrayList2) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("r", arrayList2);
        i1.c(bundle);
    }

    @Override // com.google.android.gms.measurement.internal.w5
    public final void E(i1 i1, Bundle bundle2) {
        try {
            i1.c(bundle2);
            bundle2 = this.a;
            bundle2 = bundle2.b();
            bundle2 = bundle2.w();
            bundle2.b("Error returning bundle value to wrapper", i1);
        }
    }

    @Override // com.google.android.gms.measurement.internal.w5
    public final void F(i1 i1, byte[] b2Arr2) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("r", b2Arr2);
        i1.c(bundle);
    }

    @Override // com.google.android.gms.measurement.internal.w5
    public final void G(i1 i1, int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt("r", i2);
        i1.c(bundle);
    }

    @Override // com.google.android.gms.measurement.internal.w5
    public final void H(i1 i1, long l2) {
        Bundle bundle = new Bundle();
        bundle.putLong("r", l2);
        i1.c(bundle);
    }

    @Override // com.google.android.gms.measurement.internal.w5
    public final void I(i1 i1, String string2) {
        Bundle bundle = new Bundle();
        bundle.putString("r", string2);
        i1.c(bundle);
    }

    final void J(String string, String string2, String string3, Bundle bundle4, List<String> list5, boolean z6) {
        TreeSet treeSet;
        Object contains;
        int i2;
        int equals;
        Set keySet;
        int i;
        Object str;
        Object obj3;
        Set set;
        List list;
        boolean z;
        Object obj;
        Object obj2;
        int i3;
        int i4;
        final Object obj6 = this;
        final Object obj7 = string2;
        final Bundle bundle = bundle4;
        final List list2 = list5;
        if (bundle == null) {
        }
        obj6.a.z();
        treeSet = new TreeSet(bundle4.keySet());
        final Iterator iterator = treeSet.iterator();
        i3 = 0;
        while (iterator.hasNext()) {
            obj = contains;
            if (list2 != null) {
            } else {
            }
            if (!z6) {
            } else {
            }
            contains = 0;
            if (contains == 0) {
            }
            i = contains;
            if (i != 0) {
            } else {
            }
            if (obj6.T(bundle.get((String)obj))) {
            } else {
            }
            Object obj5 = string3;
            obj2 = obj;
            i = equals;
            if (i != 0 && !"_ev".equals(obj2)) {
            } else {
            }
            if (ia.W(obj2) != null && ia.h0(obj2, a6.d) == null && i3++ > 0) {
            }
            if (ia.h0(obj2, a6.d) == null) {
            }
            if (i3++ > 0) {
            }
            obj6.a.b().s().c("Item cannot contain custom parameters", obj6.a.D().d(obj7), obj6.a.D().b(bundle));
            ia.d0(bundle, 23);
            bundle.remove(obj2);
            if (!"_ev".equals(obj2)) {
            } else {
            }
            this.w(bundle4, i, obj2, obj2, bundle.get(obj2));
            bundle.remove(obj2);
            obj6.a.b().x().d("Nested Bundle parameters are not allowed; discarded. event name, param name, child param name", obj7, string3, obj);
            i = equals;
            obj2 = obj;
            if (i == 3) {
            } else {
            }
            set = i2;
            this.w(bundle4, i, obj, obj, set);
            bundle.remove(obj);
            set = obj;
            contains = obj6.l0(obj);
            contains = obj6.m0(obj);
            if (!list2.contains(obj)) {
            } else {
            }
            i = 0;
        }
    }

    @Override // com.google.android.gms.measurement.internal.w5
    final boolean K(String string, String string2, String string3) {
        int empty;
        com.google.android.gms.measurement.internal.b3 b3Var;
        boolean obj4;
        java.lang.CharSequence obj5;
        Object obj6;
        final int i = 0;
        if (!TextUtils.isEmpty(string)) {
            if (!ia.e0(string) && this.a.q()) {
                if (this.a.q()) {
                    this.a.b().s().b("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", q3.z(string));
                }
                return i;
            }
            return 1;
        } else {
            kd.b();
            if (this.a.z().B(0, c3.d0)) {
                if (TextUtils.isEmpty(string3) && !TextUtils.isEmpty(string2) && !ia.e0(string2)) {
                    if (!TextUtils.isEmpty(string2)) {
                        if (!ia.e0(string2)) {
                            this.a.b().s().b("Invalid admob_app_id. Analytics disabled.", q3.z(string2));
                            return i;
                        }
                    }
                }
            } else {
            }
        }
        if (this.a.q()) {
            this.a.b().s().a("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
        }
        return i;
    }

    @Override // com.google.android.gms.measurement.internal.w5
    final boolean L(String string, int i2, String string3) {
        final int i = 0;
        if (string3 == null) {
            this.a.b().s().b("Name is required and can't be null. Type", string);
            return i;
        }
        if (string3.codePointCount(i, string3.length()) > i2) {
            this.a.b().s().d("Name is too long. Type, maximum supported length, name", string, Integer.valueOf(i2), string3);
            return i;
        }
        return 1;
    }

    @Override // com.google.android.gms.measurement.internal.w5
    final boolean M(String string, String[] string2Arr2, String[] string3Arr3, String string4) {
        int i;
        boolean startsWith;
        String[] obj6;
        final int i2 = 0;
        if (string4 == null) {
            this.a.b().s().b("Name is required and can't be null. Type", string);
            return i2;
        }
        r.j(string4);
        i = i2;
        while (i < 3) {
            i++;
        }
        if (string2Arr2 != null && ia.h0(string4, string2Arr2) && string3Arr3 != null && !ia.h0(string4, string3Arr3)) {
            if (ia.h0(string4, string2Arr2)) {
                if (string3Arr3 != null) {
                    if (!ia.h0(string4, string3Arr3)) {
                    }
                }
                this.a.b().s().c("Name is reserved. Type, name", string, string4);
                return i2;
            }
        }
        return 1;
    }

    @Override // com.google.android.gms.measurement.internal.w5
    final boolean N(String string, String string2, int i3, Object object4) {
        boolean z;
        boolean codePointCount;
        int i;
        Object obj7;
        int i2 = 1;
        if (object4 == null) {
            return i2;
        }
        if (!object4 instanceof Long && !object4 instanceof Float && !object4 instanceof Integer && !object4 instanceof Byte && !object4 instanceof Short && !object4 instanceof Boolean) {
            if (!object4 instanceof Float) {
                if (!object4 instanceof Integer) {
                    if (!object4 instanceof Byte) {
                        if (!object4 instanceof Short) {
                            if (!object4 instanceof Boolean) {
                                if (object4 instanceof Double) {
                                } else {
                                    i = 0;
                                    if (object4 instanceof String == null && !object4 instanceof Character && object4 instanceof CharSequence) {
                                        if (!object4 instanceof Character) {
                                            if (object4 instanceof CharSequence) {
                                            }
                                            return i;
                                        }
                                    }
                                    obj7 = object4.toString();
                                    if (obj7.codePointCount(i, obj7.length()) > i3) {
                                        this.a.b().x().d("Value is too long; discarded. Value kind, name, value length", string, string2, Integer.valueOf(obj7.length()));
                                        return i;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return i2;
    }

    final int O(String string, String string2, String string3, Object object4, Bundle bundle5, List<String> list6, boolean z7, boolean z8) {
        Object class;
        boolean z2;
        int i6;
        String z;
        boolean subList;
        Object str3;
        int w8Var;
        String str;
        Object i2;
        List i3;
        int arrayList;
        int z3;
        int i5;
        int i;
        com.google.android.gms.measurement.internal.o3 o3Var;
        String str2;
        int length;
        int i4;
        final Object obj6 = this;
        final String str4 = string3;
        class = object4;
        Object obj3 = bundle5;
        h();
        str = "param";
        i3 = 0;
        if (T(class) && z8 && !ia.h0(str4, a6.c)) {
            if (z8) {
                if (!ia.h0(str4, a6.c)) {
                    return 20;
                }
                w8Var = obj6.a.L();
                w8Var.h();
                w8Var.i();
                if (!w8Var.B()) {
                } else {
                    if (w8Var.a.N().o0() < 200900) {
                        return 25;
                    }
                }
                obj6.a.z();
                subList = class instanceof Parcelable[];
                if (subList != null) {
                    arrayList = obj4.length;
                    i = 200;
                    if (arrayList > i) {
                        obj6.a.b().x().d("Parameter array is too long; discarded. Value kind, name, array length", str, str4, Integer.valueOf(arrayList));
                        obj6.a.z();
                        if (subList != null) {
                            subList = class;
                            if (subList.length > i) {
                                obj3.putParcelableArray(str4, (Parcelable[])Arrays.copyOf((Parcelable[])subList, i));
                            }
                        } else {
                            subList = class;
                            if (class instanceof ArrayList != null && (ArrayList)subList.size() > i) {
                                subList = class;
                                if ((ArrayList)subList.size() > i) {
                                    arrayList = new ArrayList(subList.subList(i3, i));
                                    obj3.putParcelableArrayList(str4, arrayList);
                                }
                            }
                        }
                        i5 = i2;
                    } else {
                    }
                } else {
                    if (class instanceof ArrayList != null) {
                        arrayList = (ArrayList)class.size();
                    } else {
                    }
                }
                String str5 = string;
                if (obj6.a.z().B(string, c3.S)) {
                    if (!ia.V(string2)) {
                        if (ia.V(string3)) {
                            obj6.a.z();
                            i6 = 256;
                        } else {
                            obj6.a.z();
                            i6 = 100;
                        }
                    } else {
                    }
                } else {
                }
                if (N(str, str4, i6, class)) {
                    return i5;
                }
                if (z8) {
                    if (class instanceof Bundle != null) {
                        this.J(string, string2, string3, (Bundle)class, list6, z7);
                        return i5;
                    } else {
                        if (class instanceof Parcelable[]) {
                            str2 = class;
                            i4 = i3;
                            while (i4 < str2.length) {
                                Object obj = (Parcelable[])str2[i4];
                                this.J(string, string2, string3, (Bundle)obj, list6, z7);
                                i4++;
                            }
                        } else {
                            if (class instanceof ArrayList != null) {
                                str2 = class;
                                i4 = i3;
                                while (i4 < (ArrayList)str2.size()) {
                                    Object obj2 = str2.get(i4);
                                    this.J(string, string2, string3, (Bundle)obj2, list6, z7);
                                    i4++;
                                }
                            }
                        }
                    }
                }
                return 4;
            }
            return 21;
        }
        i5 = i3;
    }

    @Override // com.google.android.gms.measurement.internal.w5
    final boolean P(String string, String string2) {
        int codePointAt;
        int charCount2;
        int charCount;
        boolean letterOrDigit;
        final int i = 0;
        if (string2 == null) {
            this.a.b().s().b("Name is required and can't be null. Type", string);
            return i;
        }
        if (string2.length() == 0) {
            this.a.b().s().b("Name is required and can't be empty. Type", string);
            return i;
        }
        codePointAt = string2.codePointAt(i);
        final int i2 = 95;
        if (!Character.isLetter(codePointAt) && codePointAt == i2) {
            if (codePointAt == i2) {
                codePointAt = i2;
            }
            this.a.b().s().c("Name must start with a letter or _ (underscore). Type, name", string, string2);
            return i;
        }
        charCount2 = Character.charCount(codePointAt);
        while (charCount2 < string2.length()) {
            int codePointAt2 = string2.codePointAt(charCount2);
            charCount2 += charCount;
        }
        return 1;
    }

    @Override // com.google.android.gms.measurement.internal.w5
    final boolean Q(String string, String string2) {
        int charCount;
        int charCount2;
        int letterOrDigit;
        final int i = 0;
        if (string2 == null) {
            this.a.b().s().b("Name is required and can't be null. Type", string);
            return i;
        }
        if (string2.length() == 0) {
            this.a.b().s().b("Name is required and can't be empty. Type", string);
            return i;
        }
        int codePointAt = string2.codePointAt(i);
        if (!Character.isLetter(codePointAt)) {
            this.a.b().s().c("Name must start with a letter. Type, name", string, string2);
            return i;
        }
        charCount = Character.charCount(codePointAt);
        while (charCount < string2.length()) {
            int codePointAt2 = string2.codePointAt(charCount);
            charCount += charCount2;
        }
        return 1;
    }

    @Override // com.google.android.gms.measurement.internal.w5
    final boolean R(String string) {
        h();
        if (c.a(this.a.f()).a(string) == 0) {
            return 1;
        }
        this.a.b().q().b("Permission not granted", string);
        return 0;
    }

    @Override // com.google.android.gms.measurement.internal.w5
    final boolean S(String string) {
        if (TextUtils.isEmpty(string)) {
            return 0;
        }
        this.a.d();
        return this.a.z().u().equals(string);
    }

    @Override // com.google.android.gms.measurement.internal.w5
    final boolean T(Object object) {
        boolean z;
        Object obj2;
        if (!object instanceof Parcelable[] && object instanceof ArrayList == null && object instanceof Bundle != null) {
            if (object instanceof ArrayList == null) {
                if (object instanceof Bundle != null) {
                }
                return 0;
            }
        }
        return 1;
    }

    @Override // com.google.android.gms.measurement.internal.w5
    final boolean U(Context context, String string2) {
        X500Principal x500Principal;
        android.content.pm.PackageInfo obj3;
        String obj4;
        x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        obj3 = c.a(context).e(string2, 64);
        obj3 = obj3.signatures;
        if (obj3 != null && obj3 != null && obj3.length > 0) {
            obj3 = obj3.signatures;
            if (obj3 != null) {
                if (obj3.length > 0) {
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(obj3[0].toByteArray());
                    return (X509Certificate)CertificateFactory.getInstance("X.509").generateCertificate(byteArrayInputStream).getSubjectX500Principal().equals(x500Principal);
                }
            }
        }
        return 1;
    }

    @Override // com.google.android.gms.measurement.internal.w5
    final boolean b0(String string, String string2, String string3, String string4) {
        boolean obj5;
        final boolean empty = TextUtils.isEmpty(string);
        final boolean empty2 = TextUtils.isEmpty(string2);
        final int i = 1;
        final int i2 = 0;
        r.j(string);
        if (!empty && !empty2 && !string.equals(string2)) {
            if (!empty2) {
                r.j(string);
                if (!string.equals(string2)) {
                    return i;
                }
                return i2;
            }
        }
        if (empty && empty2 && !TextUtils.isEmpty(string3) && !TextUtils.isEmpty(string4) && !string3.equals(string4)) {
            if (empty2) {
                if (!TextUtils.isEmpty(string3)) {
                    if (!TextUtils.isEmpty(string4)) {
                        if (!string3.equals(string4)) {
                            return i;
                        }
                        return i2;
                    }
                }
                if (!TextUtils.isEmpty(string4)) {
                    return i;
                }
                return i2;
            }
        }
        if (!empty && TextUtils.isEmpty(string4)) {
            if (TextUtils.isEmpty(string4)) {
                return i2;
            }
            if (!TextUtils.isEmpty(string3) && !string3.equals(string4)) {
                if (!string3.equals(string4)) {
                }
                return i2;
            }
            return i;
        }
        if (!TextUtils.isEmpty(string3) && !string3.equals(string4)) {
            if (!string3.equals(string4)) {
            }
            return i2;
        }
        return i;
    }

    @Override // com.google.android.gms.measurement.internal.w5
    final byte[] c0(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        final Parcel obtain = Parcel.obtain();
        parcelable.writeToParcel(obtain, 0);
        obtain.recycle();
        return obtain.marshall();
    }

    @Override // com.google.android.gms.measurement.internal.w5
    protected final void i() {
        SecureRandom secureRandom;
        long nextLong;
        int str;
        h();
        secureRandom = new SecureRandom();
        str = 0;
        if (Long.compare(nextLong, str) == 0 && Long.compare(nextLong, str) == 0) {
            if (Long.compare(nextLong, str) == 0) {
                this.a.b().w().a("Utils falling back to Random for random id");
            }
        }
        this.d.set(nextLong);
    }

    @Override // com.google.android.gms.measurement.internal.w5
    protected final boolean j() {
        return 1;
    }

    @Override // com.google.android.gms.measurement.internal.w5
    final int j0(String string, Object object2) {
        int i;
        String str;
        boolean obj3;
        if ("_ldl".equals(string)) {
            obj3 = N("user property referrer", string, f0(string), object2);
        } else {
            obj3 = N("user property", string, f0(string), object2);
        }
        if (obj3 != null) {
            return 0;
        }
        return 7;
    }

    @Override // com.google.android.gms.measurement.internal.w5
    final int k0(String string) {
        final String str = "event";
        final int i2 = 2;
        if (!P(str, string)) {
            return i2;
        }
        if (!M(str, z5.a, z5.b, string)) {
            return 13;
        }
        this.a.z();
        if (!L(str, 40, string)) {
            return i2;
        }
        return 0;
    }

    @Override // com.google.android.gms.measurement.internal.w5
    final int l0(String string) {
        final String str = "event param";
        final int i3 = 3;
        if (!P(str, string)) {
            return i3;
        }
        int i = 0;
        if (!M(str, i, i, string)) {
            return 14;
        }
        this.a.z();
        if (!L(str, 40, string)) {
            return i3;
        }
        return 0;
    }

    @Override // com.google.android.gms.measurement.internal.w5
    final int m0(String string) {
        final String str = "event param";
        final int i3 = 3;
        if (!Q(str, string)) {
            return i3;
        }
        int i = 0;
        if (!M(str, i, i, string)) {
            return 14;
        }
        this.a.z();
        if (!L(str, 40, string)) {
            return i3;
        }
        return 0;
    }

    @Override // com.google.android.gms.measurement.internal.w5
    final int n0(String string) {
        final String str = "user property";
        final int i2 = 6;
        if (!P(str, string)) {
            return i2;
        }
        if (!M(str, b6.a, 0, string)) {
            return 15;
        }
        this.a.z();
        if (!L(str, 24, string)) {
            return i2;
        }
        return 0;
    }

    @Override // com.google.android.gms.measurement.internal.w5
    final Object o(String string, Object object2) {
        int i;
        com.google.android.gms.measurement.internal.b5 obj4;
        final int i2 = 1;
        if ("_ev".equals(string)) {
            this.a.z();
            return g0(256, object2, i2, i2);
        }
        if (ia.V(string)) {
            this.a.z();
        } else {
            this.a.z();
            i = 100;
        }
        return g0(i, object2, false, i2);
    }

    @EnsuresNonNull("this.apkVersion")
    public final int o0() {
        Integer valueOf;
        Context context;
        if (this.f == null) {
            this.f = Integer.valueOf(i /= 1000);
        }
        return this.f.intValue();
    }

    @Override // com.google.android.gms.measurement.internal.w5
    final Object p(String string, Object object2) {
        final int i2 = 0;
        if ("_ldl".equals(string)) {
            return g0(f0(string), object2, true, i2);
        }
        return g0(f0(string), object2, i2, i2);
    }

    @Override // com.google.android.gms.measurement.internal.w5
    public final int p0(int i) {
        return f.f().h(this.a.f(), 12451000);
    }

    @Override // com.google.android.gms.measurement.internal.w5
    public final String q(String string, int i2, boolean z3) {
        final int i = 0;
        if (string == null) {
            return i;
        }
        final int i3 = 0;
        if (string.codePointCount(i3, string.length()) > i2 && z3) {
            if (z3) {
                return String.valueOf(string.substring(i3, string.offsetByCodePoints(i3, i2))).concat("...");
            }
            return i;
        }
        return string;
    }

    @Override // com.google.android.gms.measurement.internal.w5
    public final URL r(long l, String string2, String string3, long l4) {
        String obj5;
        boolean obj6;
        try {
            r.f(l4);
            r.f(string3);
            obj5 = new Object[4];
            obj6 = 2;
            Object[] arr = new Object[obj6];
            final int i3 = 0;
            arr[i3] = Long.valueOf(46000);
            final int i4 = 1;
            arr[i4] = Integer.valueOf(o0());
            obj5[i3] = String.format("v%s.%s", arr);
            obj5[i4] = l4;
            obj5[obj6] = string3;
            obj5[3] = Long.valueOf(obj9);
            if (string3.equals(this.a.z().v())) {
            }
            obj5 = String.format("https://www.googleadservices.com/pagead/conversion/app/deeplink?id_type=adid&sdk_version=%s&rdid=%s&bundleid=%s&retry=%s", obj5).concat("&ddl_test=1");
            obj6 = new URL(obj5);
            return obj6;
            string2 = this.a;
            string2 = string2.b();
            string2 = string2.r();
            l = l.getMessage();
            string3 = "Failed to create BOW URL for Deferred Deep Link. exception";
            string2.b(string3, l);
            l = null;
            return l;
        }
    }

    @Override // com.google.android.gms.measurement.internal.w5
    public final long r0() {
        if (Long.compare(l, i2) == 0) {
            AtomicLong num3 = this.d;
            Random random = new Random(nanoTime ^= currentTimeMillis, obj3);
            i5++;
            this.e = i6;
            return nextLong += l2;
            synchronized (num3) {
                num3 = this.d;
                random = new Random(nanoTime ^= currentTimeMillis, obj3);
                i5++;
                this.e = i6;
                return nextLong += l2;
            }
        }
        AtomicLong num2 = this.d;
        this.d.compareAndSet(-1, obj3);
        return this.d.getAndIncrement();
        synchronized (num2) {
            num2 = this.d;
            this.d.compareAndSet(-1, obj3);
            return this.d.getAndIncrement();
        }
    }

    @Override // com.google.android.gms.measurement.internal.w5
    public final long s0(long l, long l2) {
        return obj3 /= obj5;
    }

    @EnsuresNonNull("this.secureRandom")
    final SecureRandom t() {
        SecureRandom secureRandom;
        h();
        if (this.c == null) {
            secureRandom = new SecureRandom();
            this.c = secureRandom;
        }
        return this.c;
    }

    @Override // com.google.android.gms.measurement.internal.w5
    final Bundle t0(Uri uri) {
        com.google.android.gms.measurement.internal.b5 b5Var;
        int queryParameter4;
        boolean empty6;
        boolean empty;
        String str;
        boolean empty2;
        boolean empty3;
        int queryParameter;
        int queryParameter2;
        int queryParameter3;
        boolean empty4;
        boolean empty5;
        Throwable obj8;
        int i = 0;
        if (uri != null) {
            String str8 = "gclid";
            if (uri.isHierarchical()) {
                queryParameter4 = uri.getQueryParameter("utm_campaign");
                queryParameter = uri.getQueryParameter("utm_source");
                queryParameter2 = uri.getQueryParameter("utm_medium");
                queryParameter3 = uri.getQueryParameter(str8);
            } else {
                try {
                    queryParameter3 = queryParameter2;
                }
                Bundle bundle = new Bundle();
                if (!TextUtils.isEmpty(queryParameter4)) {
                    try {
                        bundle.putString("campaign", queryParameter4);
                        if (!TextUtils.isEmpty(queryParameter)) {
                        }
                        bundle.putString("source", queryParameter);
                        if (!TextUtils.isEmpty(queryParameter2)) {
                        }
                        bundle.putString("medium", queryParameter2);
                        if (!TextUtils.isEmpty(queryParameter3)) {
                        }
                        bundle.putString(str8, queryParameter3);
                        String queryParameter5 = uri.getQueryParameter("utm_term");
                        if (!TextUtils.isEmpty(queryParameter5)) {
                        }
                        bundle.putString("term", queryParameter5);
                        String queryParameter6 = uri.getQueryParameter("utm_content");
                        if (!TextUtils.isEmpty(queryParameter6)) {
                        }
                        bundle.putString("content", queryParameter6);
                        String str5 = "aclid";
                        String queryParameter7 = uri.getQueryParameter(str5);
                        if (!TextUtils.isEmpty(queryParameter7)) {
                        }
                        bundle.putString(str5, queryParameter7);
                        String str6 = "cp1";
                        String queryParameter8 = uri.getQueryParameter(str6);
                        if (!TextUtils.isEmpty(queryParameter8)) {
                        }
                        bundle.putString(str6, queryParameter8);
                        String str7 = "anid";
                        obj8 = uri.getQueryParameter(str7);
                        if (!TextUtils.isEmpty(obj8)) {
                        }
                        bundle.putString(str7, obj8);
                        return bundle;
                        b5Var = this.a;
                        b5Var = b5Var.b();
                        b5Var = b5Var.w();
                        b5Var.b("Install referrer url isn't a hierarchical URI", uri);
                        return i;
                    }
                }
            }
        }
    }

    @Override // com.google.android.gms.measurement.internal.w5
    final Bundle u0(Bundle bundle) {
        Iterator iterator;
        Object next;
        Object obj;
        String str;
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            iterator = bundle.keySet().iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                obj = o(next, bundle.get((String)next));
                if (obj == null) {
                } else {
                }
                B(bundle2, next, obj);
                this.a.b().x().b("Param value can't be null", this.a.D().e(next));
            }
        }
        return bundle2;
    }

    @Override // com.google.android.gms.measurement.internal.w5
    final void v(Bundle bundle, long l2) {
        long long;
        com.google.android.gms.measurement.internal.o3 i;
        Long valueOf;
        String cmp;
        final String str = "_et";
        long = bundle.getLong(str);
        i = 0;
        if (Long.compare(long, i) != 0) {
            this.a.b().w().b("Params already contained engagement", Long.valueOf(long));
        } else {
            long = i;
        }
        bundle.putLong(str, l2 += long);
    }

    final Bundle v0(String string, String string2, Bundle bundle3, List<String> list4, boolean z5) {
        String[] next;
        TreeSet treeSet;
        Object contains;
        boolean equals;
        Set keySet;
        int i5;
        Object obj2;
        Object obj3;
        Bundle fALSE;
        Object obj4;
        boolean z;
        int i6;
        int i3;
        int i2;
        Bundle bundle;
        Iterator iterator;
        int i4;
        int i;
        Object obj;
        final Object obj6 = this;
        final String str5 = string2;
        final Bundle bundle2 = bundle3;
        final List list2 = list4;
        if (bundle2 != null) {
            bundle = new Bundle(bundle2);
            i6 = obj6.a.z().m();
            treeSet = new TreeSet(bundle3.keySet());
            iterator = treeSet.iterator();
            i4 = 0;
            i = i4;
            while (iterator.hasNext()) {
                z = contains;
                if (list2 != null) {
                } else {
                }
                if (!z5) {
                } else {
                }
                contains = i4;
                if (contains == 0) {
                }
                i5 = contains;
                if (i5 != 0) {
                } else {
                }
                obj = z;
                i2 = i6;
                i5 = this.O(string, string2, z, bundle2.get((String)z), bundle, list4, z5, ia.h0(str5, z5.d));
                if (i5 == 17) {
                } else {
                }
                if (i5 != 0) {
                } else {
                }
                obj4 = obj;
                treeSet = i + 1;
                if (ia.W(obj4) && treeSet > i2) {
                }
                i6 = i2;
                treeSet = i + 1;
                if (treeSet > i2) {
                }
                i = treeSet;
                StringBuilder stringBuilder = new StringBuilder(48);
                stringBuilder.append("Event can't contain more than ");
                stringBuilder.append(i2);
                stringBuilder.append(" params");
                obj6.a.b().s().c(stringBuilder.toString(), obj6.a.D().d(str5), obj6.a.D().b(bundle2));
                ia.d0(bundle, 5);
                bundle.remove(obj4);
                obj4 = obj;
                if (!"_ev".equals(obj4)) {
                } else {
                }
                if (i5 == 21) {
                } else {
                }
                obj2 = obj4;
                this.w(bundle, i5, obj2, obj4, bundle2.get(obj4));
                bundle.remove(obj4);
                obj2 = str5;
                this.w(bundle, 17, obj, obj, Boolean.FALSE);
                if (i5 == 3) {
                } else {
                }
                fALSE = 0;
                this.w(bundle, i5, z, z, fALSE);
                bundle.remove(z);
                i2 = i6;
                fALSE = z;
                contains = obj6.l0(z);
                contains = obj6.m0(z);
                if (!list2.contains(z)) {
                } else {
                }
                i5 = i4;
            }
            i3 = bundle;
        } else {
            i3 = 0;
        }
        return i3;
    }

    @Override // com.google.android.gms.measurement.internal.w5
    final void w(Bundle bundle, int i2, String string3, String string4, Object object5) {
        boolean obj2;
        String obj3;
        int obj4;
        this.a.z();
        obj3 = "_ev";
        bundle.putString(obj3, q(string3, 40, true));
        if (ia.d0(bundle, i2) && object5 != null) {
            this.a.z();
            obj3 = "_ev";
            bundle.putString(obj3, q(string3, 40, true));
            if (object5 != null) {
                r.j(bundle);
                if (object5 instanceof String == null) {
                    if (object5 instanceof CharSequence) {
                        bundle.putLong("_el", (long)obj2);
                    }
                } else {
                }
            }
        }
    }

    @Override // com.google.android.gms.measurement.internal.w5
    final com.google.android.gms.measurement.internal.u w0(String string, String string2, Bundle bundle3, String string4, long l5, boolean z6, boolean z7) {
        Bundle obj7;
        Bundle obj14;
        if (TextUtils.isEmpty(string2)) {
            return null;
        }
        if (k0(string2) != 0) {
        } else {
            if (bundle3 != null) {
                obj14 = new Bundle(bundle3);
            } else {
                obj14 = new Bundle();
            }
            Bundle bundle = obj14;
            String obj9 = "_o";
            bundle.putString(obj9, string4);
            final int i = 1;
            if (z7) {
                obj7 = u0(this.v0(string, string2, bundle, f.b(obj9), i));
            }
            r.j(obj7);
            s sVar = new s(obj7);
            super(string2, sVar, string4, l5, i);
            return obj9;
        }
        this.a.b().r().b("Invalid conditional property event name", this.a.D().f(string2));
        obj7 = new IllegalArgumentException();
        throw obj7;
    }

    @Override // com.google.android.gms.measurement.internal.w5
    final void y(Bundle bundle, Bundle bundle2) {
        Object next;
        boolean key;
        Object obj;
        if (bundle2 == null) {
        }
        Iterator iterator = bundle2.keySet().iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (!bundle.containsKey((String)next)) {
            }
            this.a.N().B(bundle, next, bundle2.get(next));
        }
    }

    @Override // com.google.android.gms.measurement.internal.w5
    final void z(com.google.android.gms.measurement.internal.r3 r3, int i2) {
        int i3;
        Object next;
        boolean z;
        int i;
        String str;
        String str2;
        Bundle bundle;
        TreeSet treeSet = new TreeSet(r3.d.keySet());
        Iterator iterator = treeSet.iterator();
        i3 = 0;
        while (iterator.hasNext()) {
            next = iterator.next();
            if (ia.W((String)next) && i3++ > i2) {
            }
            if (i3++ > i2) {
            }
            StringBuilder stringBuilder = new StringBuilder(48);
            stringBuilder.append("Event can't contain more than ");
            stringBuilder.append(i2);
            stringBuilder.append(" params");
            this.a.b().s().c(stringBuilder.toString(), this.a.D().d(r3.a), this.a.D().b(r3.d));
            ia.d0(r3.d, 5);
            r3.d.remove(next);
        }
    }
}
