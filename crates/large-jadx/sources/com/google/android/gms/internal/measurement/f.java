package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* loaded from: classes2.dex */
public final class f implements Iterable<com.google.android.gms.internal.measurement.q>, com.google.android.gms.internal.measurement.q, com.google.android.gms.internal.measurement.m {

    final SortedMap<Integer, com.google.android.gms.internal.measurement.q> a;
    final Map<String, com.google.android.gms.internal.measurement.q> b;
    public f() {
        super();
        TreeMap treeMap = new TreeMap();
        this.a = treeMap;
        TreeMap treeMap2 = new TreeMap();
        this.b = treeMap2;
    }

    public f(List<com.google.android.gms.internal.measurement.q> list) {
        int i;
        Object size;
        super();
        if (list != null) {
            i = 0;
            while (i < list.size()) {
                A(i, (q)list.get(i));
                i++;
            }
        }
    }

    @RequiresNonNull("elements")
    public final void A(int i, com.google.android.gms.internal.measurement.q q2) {
        if (i > 32468) {
        } else {
            if (i < 0) {
            } else {
                if (q2 == null) {
                    this.a.remove(Integer.valueOf(i));
                }
                this.a.put(Integer.valueOf(i), q2);
            }
            StringBuilder stringBuilder = new StringBuilder(32);
            stringBuilder.append("Out of bounds index: ");
            stringBuilder.append(i);
            IndexOutOfBoundsException obj4 = new IndexOutOfBoundsException(stringBuilder.toString());
            throw obj4;
        }
        IllegalStateException obj3 = new IllegalStateException("Array too large");
        throw obj3;
    }

    @Override // java.lang.Iterable
    public final boolean B(int i) {
        int intValue;
        if (i < 0) {
        } else {
            if (i > (Integer)this.a.lastKey().intValue()) {
            } else {
                return this.a.containsKey(Integer.valueOf(i));
            }
        }
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append("Out of bounds index: ");
        stringBuilder.append(i);
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(stringBuilder.toString());
        throw indexOutOfBoundsException;
    }

    @Override // java.lang.Iterable
    public final com.google.android.gms.internal.measurement.q b() {
        Object value;
        SortedMap map;
        Object key;
        f fVar = new f();
        Iterator iterator = this.a.entrySet().iterator();
        while (iterator.hasNext()) {
            Object next2 = iterator.next();
            if (value3 instanceof m) {
            } else {
            }
            fVar.a.put((Integer)next2.getKey(), (q)next2.getValue().b());
            fVar.a.put((Integer)next2.getKey(), (q)next2.getValue());
        }
        return fVar;
    }

    @Override // java.lang.Iterable
    public final Boolean d() {
        return Boolean.TRUE;
    }

    @Override // java.lang.Iterable
    public final boolean equals(Object object) {
        int intValue;
        int equals;
        com.google.android.gms.internal.measurement.q qVar;
        final int i = 1;
        if (object == this) {
            return i;
        }
        final int i3 = 0;
        if (!object instanceof f) {
            return i3;
        }
        if (q() != (f)object.q()) {
            return i3;
        }
        if (this.a.isEmpty()) {
            return object.a.isEmpty();
        }
        intValue = (Integer)this.a.firstKey().intValue();
        while (intValue <= (Integer)this.a.lastKey().intValue()) {
            intValue++;
        }
        return i;
    }

    @Override // java.lang.Iterable
    public final boolean g(String string) {
        boolean equals;
        Object obj2;
        if (!"length".equals(string) && this.b.containsKey(string)) {
            if (this.b.containsKey(string)) {
            }
            return 0;
        }
        return 1;
    }

    public final Iterator<com.google.android.gms.internal.measurement.q> h() {
        d dVar = new d(this, this.a.keySet().iterator(), this.b.keySet().iterator());
        return dVar;
    }

    @Override // java.lang.Iterable
    public final int hashCode() {
        return i *= 31;
    }

    @Override // java.lang.Iterable
    public final void i(String string, com.google.android.gms.internal.measurement.q q2) {
        if (q2 == null) {
            this.b.remove(string);
        }
        this.b.put(string, q2);
    }

    public final Iterator<com.google.android.gms.internal.measurement.q> iterator() {
        e eVar = new e(this);
        return eVar;
    }

    @Override // java.lang.Iterable
    public final com.google.android.gms.internal.measurement.q l(String string) {
        boolean z;
        Object obj3;
        if ("length".equals(string)) {
            obj3 = new i(Double.valueOf((double)i));
            return obj3;
        }
        obj3 = this.b.get(string);
        if (g(string) && (q)obj3 != null) {
            obj3 = this.b.get(string);
            if ((q)(q)obj3 != null) {
                return (q)(q)obj3;
            }
        }
        return q.h;
    }

    public final com.google.android.gms.internal.measurement.q m(String string, com.google.android.gms.internal.measurement.b5 b52, List<com.google.android.gms.internal.measurement.q> list3) {
        boolean equals;
        if (!"concat".equals(string) && !"every".equals(string) && !"filter".equals(string) && !"forEach".equals(string) && !"indexOf".equals(string) && !"join".equals(string) && !"lastIndexOf".equals(string) && !"map".equals(string) && !"pop".equals(string) && !"push".equals(string) && !"reduce".equals(string) && !"reduceRight".equals(string) && !"reverse".equals(string) && !"shift".equals(string) && !"slice".equals(string) && !"some".equals(string) && !"sort".equals(string) && !"splice".equals(string) && !"toString".equals(string) && "unshift".equals(string)) {
            if (!"every".equals(string)) {
                if (!"filter".equals(string)) {
                    if (!"forEach".equals(string)) {
                        if (!"indexOf".equals(string)) {
                            if (!"join".equals(string)) {
                                if (!"lastIndexOf".equals(string)) {
                                    if (!"map".equals(string)) {
                                        if (!"pop".equals(string)) {
                                            if (!"push".equals(string)) {
                                                if (!"reduce".equals(string)) {
                                                    if (!"reduceRight".equals(string)) {
                                                        if (!"reverse".equals(string)) {
                                                            if (!"shift".equals(string)) {
                                                                if (!"slice".equals(string)) {
                                                                    if (!"some".equals(string)) {
                                                                        if (!"sort".equals(string)) {
                                                                            if (!"splice".equals(string)) {
                                                                                if (!"toString".equals(string)) {
                                                                                    if ("unshift".equals(string)) {
                                                                                    }
                                                                                    u uVar = new u(string);
                                                                                    return k.a(this, uVar, b52, list3);
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return d0.a(string, this, b52, list3);
    }

    @Override // java.lang.Iterable
    public final int p() {
        return this.a.size();
    }

    @Override // java.lang.Iterable
    public final int q() {
        if (this.a.isEmpty()) {
            return 0;
        }
        return intValue++;
    }

    @Override // java.lang.Iterable
    public final com.google.android.gms.internal.measurement.q s(int i) {
        boolean z;
        int obj2;
        if (i >= q()) {
        } else {
            obj2 = this.a.get(Integer.valueOf(i));
            if (B(i) && (q)obj2 != null) {
                obj2 = this.a.get(Integer.valueOf(i));
                if ((q)(q)obj2 != null) {
                    return (q)(q)obj2;
                }
            }
            return q.h;
        }
        obj2 = new IndexOutOfBoundsException("Attempting to get element outside of current array");
        throw obj2;
    }

    @Override // java.lang.Iterable
    public final String t(String string) {
        boolean empty;
        int i;
        com.google.android.gms.internal.measurement.q qVar;
        boolean z;
        String obj6;
        if (string == null) {
            obj6 = "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (!this.a.isEmpty()) {
            empty = 0;
            i = empty;
            while (i < q()) {
                qVar = s(i);
                stringBuilder.append(obj6);
                if (!qVar instanceof v && !qVar instanceof o) {
                }
                i++;
                if (!qVar instanceof o) {
                }
                stringBuilder.append(qVar.zzi());
            }
            stringBuilder.delete(empty, obj6.length());
        }
        return stringBuilder.toString();
    }

    @Override // java.lang.Iterable
    public final String toString() {
        return t(",");
    }

    public final Iterator<Integer> u() {
        return this.a.keySet().iterator();
    }

    public final List<com.google.android.gms.internal.measurement.q> v() {
        int i;
        com.google.android.gms.internal.measurement.q qVar;
        ArrayList arrayList = new ArrayList(q());
        i = 0;
        while (i < q()) {
            arrayList.add(s(i));
            i++;
        }
        return arrayList;
    }

    @Override // java.lang.Iterable
    public final void w() {
        this.a.clear();
    }

    @Override // java.lang.Iterable
    public final void y(int i, com.google.android.gms.internal.measurement.q q2) {
        int intValue;
        Object obj;
        Integer valueOf;
        int i2;
        if (i < 0) {
        } else {
            if (i >= q()) {
                A(i, q2);
            }
            intValue = (Integer)this.a.lastKey().intValue();
            while (intValue >= i) {
                valueOf = Integer.valueOf(intValue);
                obj = this.a.get(valueOf);
                if ((q)obj != null) {
                }
                intValue--;
                A(intValue + 1, (q)obj);
                this.a.remove(valueOf);
            }
            A(i, q2);
        }
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append("Invalid value index: ");
        stringBuilder.append(i);
        IllegalArgumentException obj6 = new IllegalArgumentException(stringBuilder.toString());
        throw obj6;
    }

    @Override // java.lang.Iterable
    public final void z(int i) {
        int intValue;
        boolean key;
        SortedMap valueOf;
        Integer valueOf3;
        Integer valueOf2;
        int obj5;
        intValue = (Integer)this.a.lastKey().intValue();
        if (i <= intValue) {
            if (i < 0) {
            } else {
                this.a.remove(Integer.valueOf(i));
                i--;
                Integer valueOf4 = Integer.valueOf(obj5);
                if (i == intValue && !this.a.containsKey(valueOf4) && obj5 >= 0) {
                    i--;
                    valueOf4 = Integer.valueOf(obj5);
                    if (!this.a.containsKey(valueOf4)) {
                        if (obj5 >= 0) {
                            this.a.put(valueOf4, q.h);
                        }
                    }
                }
                obj5++;
                while (obj5 <= (Integer)this.a.lastKey().intValue()) {
                    valueOf = Integer.valueOf(obj5);
                    intValue = this.a.get(valueOf);
                    if ((q)intValue != 0) {
                    }
                    obj5++;
                    this.a.put(Integer.valueOf(obj5 + -1), (q)intValue);
                    this.a.remove(valueOf);
                }
            }
        }
    }

    @Override // java.lang.Iterable
    public final Double zzh() {
        final int i3 = 1;
        if (this.a.size() == i3) {
            return s(0).zzh();
        }
        if (this.a.size() <= 0) {
            return Double.valueOf(0);
        }
        return Double.valueOf(9221120237041090560L);
    }

    @Override // java.lang.Iterable
    public final String zzi() {
        return t(",");
    }
}
