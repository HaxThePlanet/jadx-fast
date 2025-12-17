package com.google.android.gms.internal.firebase-auth-api;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

/* loaded from: classes2.dex */
final class qr<T extends com.google.android.gms.internal.firebase-auth-api.pr<T>>  {

    private static final com.google.android.gms.internal.firebase-auth-api.qr d;
    final com.google.android.gms.internal.firebase-auth-api.v0<T, Object> a;
    private boolean b;
    private boolean c;
    static {
        qr qrVar = new qr(1);
        qr.d = qrVar;
    }

    private qr() {
        super();
        o0 o0Var = new o0(16);
        this.a = o0Var;
    }

    private qr(boolean z) {
        o0 obj2 = new o0(0);
        super();
        this.a = obj2;
        b();
        b();
    }

    public static <T extends com.google.android.gms.internal.firebase-auth-api.pr<T>> com.google.android.gms.internal.firebase-auth-api.qr<T> a() {
        throw 0;
    }

    private static final void d(T t, Object object2) {
        boolean ordinal;
        e.e(object2);
        com.google.android.gms.internal.firebase-auth-api.p1 zza = p1.zza;
        com.google.android.gms.internal.firebase-auth-api.q1 zza2 = q1.zza;
        switch (ordinal) {
            case 0:
                ordinal = object2 instanceof Integer;
                break;
            case 1:
                ordinal = object2 instanceof Long;
                break;
            case 2:
                ordinal = object2 instanceof Float;
                break;
            case 3:
                ordinal = object2 instanceof Double;
                break;
            case 4:
                ordinal = object2 instanceof Boolean;
                break;
            case 5:
                ordinal = object2 instanceof String;
                break;
            case 6:
                Object[] arr = new Object[3];
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(t.zza()), t.zzb().zza(), object2.getClass().getName()));
                throw illegalArgumentException;
            case 7:
                arr = new Object[3];
                illegalArgumentException = new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(t.zza()), t.zzb().zza(), object2.getClass().getName()));
                throw illegalArgumentException;
            case 8:
                arr = new Object[3];
                illegalArgumentException = new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(t.zza()), t.zzb().zza(), object2.getClass().getName()));
                throw illegalArgumentException;
            default:
                arr = new Object[3];
                illegalArgumentException = new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(t.zza()), t.zzb().zza(), object2.getClass().getName()));
                throw illegalArgumentException;
        }
        if (!ordinal) {
        } else {
        }
    }

    public final void b() {
        if (this.b) {
        }
        this.a.a();
        this.b = true;
    }

    public final void c(T t, Object object2) {
        boolean arrayList;
        int i;
        Object obj;
        Object obj5;
        if (t.zzc()) {
            if (object2 instanceof List == null) {
            } else {
                arrayList = new ArrayList();
                arrayList.addAll((List)object2);
                i = 0;
                while (i < arrayList.size()) {
                    qr.d(t, arrayList.get(i));
                    i++;
                }
                obj5 = arrayList;
                this.a.f(t, obj5);
            }
            IllegalArgumentException obj4 = new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            throw obj4;
        }
        qr.d(t, object2);
    }

    public final Object clone() {
        int i;
        Object value;
        int value2;
        Object key;
        qr qrVar = new qr();
        i = 0;
        while (i < this.a.c()) {
            Map.Entry map = this.a.h(i);
            qrVar.c((pr)map.getKey(), map.getValue());
            i++;
        }
        Iterator iterator = this.a.d().iterator();
        for (Map.Entry next2 : iterator) {
            qrVar.c((pr)next2.getKey(), next2.getValue());
        }
        qrVar.c = this.c;
        return qrVar;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return 1;
        }
        if (!object instanceof qr) {
            return 0;
        }
        return this.a.equals(object.a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }
}
