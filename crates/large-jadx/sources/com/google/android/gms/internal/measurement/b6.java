package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class b6 {
    public static double a(double d) {
        int i;
        boolean infinite;
        final int i3 = 0;
        if (Double.isNaN(d)) {
            return i3;
        }
        infinite = Double.compare(d, i3);
        if (!Double.isInfinite(d) && infinite != 0) {
            infinite = Double.compare(d, i3);
            if (infinite != 0) {
                if (infinite == 0) {
                } else {
                    i = infinite > 0 ? 1 : -1;
                }
                return d2 *= obj3;
            }
        }
        return d;
    }

    public static int b(double d) {
        int i;
        boolean naN;
        if (!Double.isNaN(d) && !Double.isInfinite(d)) {
            if (!Double.isInfinite(d)) {
                naN = Double.compare(d, i2);
                if (naN == 0) {
                } else {
                    i = naN > 0 ? 1 : -1;
                }
                return (int)obj2;
            }
        }
        return 0;
    }

    public static int c(com.google.android.gms.internal.measurement.b5 b5) {
        String str = "runtime.counter";
        int i2 = b6.b(doubleValue += l);
        if (i2 > 1000000) {
        } else {
            i iVar = new i(Double.valueOf((double)i2));
            b5.g(str, iVar);
            return i2;
        }
        IllegalStateException obj5 = new IllegalStateException("Instructions allowed exceeded");
        throw obj5;
    }

    public static long d(double d) {
        return obj2 &= l;
    }

    public static com.google.android.gms.internal.measurement.n0 e(String string) {
        int i;
        boolean empty;
        i = 0;
        if (string != null && !string.isEmpty()) {
            if (!string.isEmpty()) {
                i = n0.zza(Integer.parseInt(string));
            }
        }
        if (i == 0) {
        } else {
            return i;
        }
        Object[] arr = new Object[1];
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Unsupported commandId %s", string));
        throw illegalArgumentException;
    }

    public static Object f(com.google.android.gms.internal.measurement.q q) {
        Object obj;
        if (q.i.equals(q)) {
            return null;
        }
        if (q.h.equals(q)) {
            return "";
        }
        if (q instanceof n) {
            return b6.g((n)q);
        }
        if (q instanceof f) {
            ArrayList arrayList = new ArrayList();
            Iterator obj2 = (f)q.iterator();
            while (obj2.hasNext()) {
                obj = b6.f((q)obj2.next());
                if (obj != null) {
                }
                arrayList.add(obj);
            }
            return arrayList;
        }
        if (!q.zzh().isNaN()) {
            return q.zzh();
        }
        return q.zzi();
    }

    public static Map<String, Object> g(com.google.android.gms.internal.measurement.n n) {
        Object next;
        Object obj;
        HashMap hashMap = new HashMap();
        Iterator iterator = n.a().iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            obj = b6.f(n.l((String)next));
            if (obj != null) {
            }
            hashMap.put(next, obj);
        }
        return hashMap;
    }

    public static void h(String string, int i2, List<com.google.android.gms.internal.measurement.q> list3) {
        if (list3.size() != i2) {
        } else {
        }
        Object[] arr = new Object[3];
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("%s operation requires %s parameters found %s", string, Integer.valueOf(i2), Integer.valueOf(list3.size())));
        throw illegalArgumentException;
    }

    public static void i(String string, int i2, List<com.google.android.gms.internal.measurement.q> list3) {
        if (list3.size() < i2) {
        } else {
        }
        Object[] arr = new Object[3];
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("%s operation requires at least %s parameters found %s", string, Integer.valueOf(i2), Integer.valueOf(list3.size())));
        throw illegalArgumentException;
    }

    public static void j(String string, int i2, List<com.google.android.gms.internal.measurement.q> list3) {
        if (list3.size() > i2) {
        } else {
        }
        Object[] arr = new Object[3];
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("%s operation requires at most %s parameters found %s", string, Integer.valueOf(i2), Integer.valueOf(list3.size())));
        throw illegalArgumentException;
    }

    public static boolean k(com.google.android.gms.internal.measurement.q q) {
        boolean valueOf;
        int i;
        Double obj5;
        final int i2 = 0;
        if (q == null) {
            return i2;
        }
        obj5 = q.zzh();
        if (!obj5.isNaN() && Double.compare(doubleValue, i) >= 0 && obj5.equals(Double.valueOf(Math.floor(obj5.doubleValue())))) {
            if (Double.compare(doubleValue, i) >= 0) {
                if (obj5.equals(Double.valueOf(Math.floor(obj5.doubleValue())))) {
                    return 1;
                }
            }
        }
        return i2;
    }

    public static boolean l(com.google.android.gms.internal.measurement.q q, com.google.android.gms.internal.measurement.q q2) {
        boolean naN;
        boolean z;
        double doubleValue;
        int i = 0;
        if (!q.getClass().equals(q2.getClass())) {
            return i;
        }
        int i2 = 1;
        if (!q instanceof v) {
            if (q instanceof o) {
            } else {
                if (q instanceof i && !Double.isNaN(q.zzh().doubleValue()) && Double.isNaN(q2.zzh().doubleValue())) {
                    if (!Double.isNaN(q.zzh().doubleValue())) {
                        if (Double.isNaN(q2.zzh().doubleValue())) {
                        }
                        return q.zzh().equals(q2.zzh());
                    }
                    return i;
                }
                if (q instanceof u) {
                    return q.zzi().equals(q2.zzi());
                }
                if (q instanceof g) {
                    return q.d().equals(q2.d());
                }
                if (q == q2) {
                    return i2;
                }
            }
            return i;
        }
        return i2;
    }
}
