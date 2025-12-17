package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.internal.measurement.e5;
import com.google.android.gms.internal.measurement.f5;
import com.google.android.gms.internal.measurement.h5;
import com.google.android.gms.internal.measurement.j5;
import com.google.android.gms.internal.measurement.k7;
import com.google.android.gms.internal.measurement.l3;
import com.google.android.gms.internal.measurement.l4;
import com.google.android.gms.internal.measurement.n4;
import com.google.android.gms.internal.measurement.p4;
import com.google.android.gms.internal.measurement.t3;
import com.google.android.gms.internal.measurement.t8;
import com.google.android.gms.internal.measurement.w8;
import com.google.android.gms.internal.measurement.yc;
import d.e.a;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
final class xa extends com.google.android.gms.measurement.internal.r9 {

    private String d;
    private Set<Integer> e;
    private Map<Integer, com.google.android.gms.measurement.internal.ra> f;
    private Long g;
    private Long h;
    xa(com.google.android.gms.measurement.internal.ba ba) {
        super(ba);
    }

    private final com.google.android.gms.measurement.internal.ra n(Integer integer) {
        if (this.f.containsKey(integer)) {
            return (ra)this.f.get(integer);
        }
        ra raVar = new ra(this, this.d, 0);
        this.f.put(integer, raVar);
        return raVar;
    }

    private final boolean o(int i, int i2) {
        Object obj2 = this.f.get(Integer.valueOf(i));
        if ((ra)obj2 == null) {
            return 0;
        }
        return ra.b((ra)obj2).get(i2);
    }

    @Override // com.google.android.gms.measurement.internal.r9
    protected final boolean l() {
        return 0;
    }

    final List<l4> m(String string, List<p4> list2, List<j5> list3, Long long4, Long long5) {
        Object contentValues;
        boolean moveToFirst;
        Map moveToFirst4;
        Object empty;
        Object valueOf9;
        a emptyMap2;
        int i4;
        int i8;
        boolean emptyMap;
        boolean moveToFirst2;
        w8 w8Var;
        boolean emptyMap3;
        Set keySet;
        boolean moveToFirst3;
        w8 w8Var4;
        boolean z2;
        w8 w8Var2;
        w8 w8Var3;
        String equals;
        int iterator;
        Object valueOf;
        boolean z;
        List contains3;
        int contains;
        Object str9;
        Object str19;
        com.google.android.gms.measurement.internal.k hashSet;
        boolean valueOf6;
        Iterator valueOf11;
        String str8;
        Object b3Var;
        String valueOf3;
        String aVar2;
        Cursor arrayList2;
        com.google.android.gms.measurement.internal.k intValue;
        int rawQuery;
        Object str5;
        String withOnConflict;
        Object valueOf2;
        String str12;
        int arrayList;
        long str20;
        int valueOf8;
        String valueOf10;
        String loggable;
        String str7;
        String contains2;
        Object qVar;
        long l4;
        String valueOf5;
        com.google.android.gms.measurement.internal.b5 arrayList4;
        Object obj2;
        String str13;
        Object valueOf4;
        Object map;
        int query;
        a aVar3;
        boolean valueOf7;
        boolean arrayList3;
        Object i21;
        SQLiteDatabase str18;
        String str16;
        String iterator2;
        Object strArr3;
        String strArr;
        Integer str21;
        String str6;
        String[] strArr2;
        String[] intValue2;
        int i19;
        int i5;
        int i13;
        int i20;
        int i15;
        int i7;
        a aVar;
        long l5;
        String str11;
        int i6;
        String str17;
        String str10;
        Object obj;
        String str;
        Object obj3;
        String str14;
        com.google.android.gms.measurement.internal.q qVar2;
        String str2;
        String str4;
        int i14;
        int i;
        int i10;
        long l;
        int i16;
        int i2;
        int i12;
        int i9;
        int i11;
        com.google.android.gms.measurement.internal.q qVar3;
        String str3;
        String str15;
        int i17;
        int i3;
        int i18;
        long l2;
        long l3;
        Long num3;
        Long num2;
        Long num;
        Boolean bool;
        String obj66;
        Object obj67;
        Object obj68;
        final Object obj9 = this;
        r.f(string);
        r.j(list2);
        r.j(list3);
        obj9.d = string;
        HashSet hashSet2 = new HashSet();
        obj9.e = hashSet2;
        a aVar4 = new a();
        obj9.f = aVar4;
        obj9.g = long4;
        obj9.h = long5;
        Iterator iterator3 = list2.iterator();
        arrayList4 = 0;
        valueOf4 = 1;
        for (p4 next7 : iterator3) {
            arrayList4 = 0;
            valueOf4 = 1;
        }
        iterator = arrayList4;
        yc.b();
        valueOf7 = obj9.a.z().B(obj9.d, c3.Z);
        yc.b();
        arrayList3 = obj9.a.z().B(obj9.d, c3.Y);
        if (iterator != null) {
            str19 = obj9.b.U();
            b3Var = obj9.d;
            str19.i();
            str19.h();
            r.f(b3Var);
            contentValues = new ContentValues();
            contentValues.put("current_session_count", Integer.valueOf(arrayList4));
            rawQuery = new String[valueOf4];
            rawQuery[arrayList4] = b3Var;
            str19.R().update("events", contentValues, "app_id = ?", rawQuery);
        }
        moveToFirst = Collections.emptyMap();
        contains2 = "Failed to merge filter. appId";
        valueOf10 = "Database error querying filters. appId";
        str12 = "data";
        withOnConflict = "audience_id";
        if (arrayList3 != null && valueOf7) {
            if (valueOf7) {
                b3Var = obj9.d;
                r.f(b3Var);
                aVar2 = new a();
                String[] strArr7 = new String[valueOf4];
                strArr7[arrayList4] = b3Var;
                rawQuery = obj9.b.U().R().query("event_filters", /* result */, "app_id=?", strArr7, 0, 0, 0);
                if (rawQuery.moveToFirst()) {
                } else {
                    moveToFirst = Collections.emptyMap();
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    obj2 = moveToFirst;
                }
            } else {
            }
        } else {
        }
        hashSet = obj9.b.U();
        valueOf3 = obj9.d;
        hashSet.i();
        hashSet.h();
        r.f(valueOf3);
        String[] strArr4 = new String[1];
        arrayList2 = hashSet.R().query("audience_filter_values", /* result */, "app_id=?", strArr4, 0, 0, 0);
        if (!arrayList2.moveToFirst()) {
            if (arrayList2 != null) {
                arrayList2.close();
            }
            map = moveToFirst4;
            strArr = withOnConflict;
            str6 = str12;
        } else {
            rawQuery = new a();
            while (/* condition */) {
                if (arrayList2.moveToNext()) {
                }
                rawQuery = iterator2;
                withOnConflict = strArr;
                str12 = str6;
                e5 e5Var = f5.B();
                da.D(e5Var, arrayList2.getBlob(1));
                rawQuery.put(Integer.valueOf(arrayList2.getInt(0)), (f5)(e5)e5Var.l());
                iterator2 = rawQuery;
                strArr = withOnConflict;
                str6 = str12;
                valueOf4 = str9.a;
                valueOf4 = valueOf4.b();
                valueOf4 = valueOf4.r();
                str16 = rawQuery;
                rawQuery = "Failed to merge filter results. appId, audienceId, error";
                strArr3 = str5;
                str5 = q3.z(str8);
                str21 = valueOf2;
                valueOf2 = Integer.valueOf(i21);
                valueOf4.d(rawQuery, str5, valueOf2, th);
            }
            if (arrayList2 != null) {
                arrayList2.close();
            }
            map = iterator2;
        }
        if (!map.isEmpty()) {
            hashSet = new HashSet(map.keySet());
            if (iterator != null) {
                iterator = obj9.d;
                r.f(iterator);
                r.j(map);
                valueOf3 = new a();
                if (map.isEmpty()) {
                } else {
                    intValue = obj9.b.U();
                    intValue.i();
                    intValue.h();
                    r.f(iterator);
                    emptyMap2 = new a();
                    String[] strArr8 = new String[2];
                    rawQuery = intValue.R().rawQuery("select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;", iterator, iterator);
                    if (rawQuery.moveToFirst()) {
                    } else {
                        rawQuery.close();
                    }
                    iterator = map.keySet().iterator();
                    while (iterator.hasNext()) {
                        intValue = (Integer)iterator.next().intValue();
                        rawQuery = Integer.valueOf(intValue);
                        withOnConflict = map.get(rawQuery);
                        arrayList = emptyMap2.get(rawQuery);
                        if ((List)arrayList != null) {
                        } else {
                        }
                        iterator2 = emptyMap2;
                        intValue2 = iterator;
                        valueOf3.put(rawQuery, (f5)withOnConflict);
                        emptyMap2 = iterator2;
                        iterator = intValue2;
                        if ((List)arrayList.isEmpty()) {
                        } else {
                        }
                        List list4 = obj9.b.e0().I(withOnConflict.G(), arrayList);
                        if (list4.isEmpty() == null) {
                        } else {
                        }
                        emptyMap2 = iterator2;
                        rawQuery = withOnConflict.q();
                        (e5)rawQuery.w();
                        rawQuery.t(list4);
                        intValue2 = iterator;
                        rawQuery.x();
                        rawQuery.v(obj9.b.e0().I(withOnConflict.I(), arrayList));
                        i4 = 0;
                        while (i4 < withOnConflict.w()) {
                            if (arrayList.contains(Integer.valueOf(withOnConflict.A(i4).w())) != null) {
                            }
                            i4++;
                            rawQuery.y(i4);
                        }
                        i8 = 0;
                        while (i8 < withOnConflict.y()) {
                            if (arrayList.contains(Integer.valueOf(withOnConflict.E(i8).x())) != 0) {
                            }
                            i8++;
                            rawQuery.z(i8);
                        }
                        valueOf3.put(Integer.valueOf(intValue), (f5)rawQuery.l());
                        if (arrayList.contains(Integer.valueOf(withOnConflict.E(i8).x())) != 0) {
                        }
                        i8++;
                        rawQuery.z(i8);
                        if (arrayList.contains(Integer.valueOf(withOnConflict.A(i4).w())) != null) {
                        }
                        i4++;
                        rawQuery.y(i4);
                    }
                }
                empty = valueOf3;
            } else {
                empty = map;
            }
            iterator2 = hashSet.iterator();
            while (iterator2.hasNext() != 0) {
                intValue2 = (Integer)iterator2.next().intValue();
                Object obj4 = empty.get(Integer.valueOf(intValue2));
                rawQuery = new BitSet();
                withOnConflict = new BitSet();
                arrayList = new a();
                if ((f5)obj4 != null) {
                }
                a aVar5 = new a();
                if ((f5)obj4 != null) {
                }
                if ((f5)obj4 != null) {
                }
                valueOf9 = Integer.valueOf(intValue2);
                valueOf9 = obj2.get(valueOf9);
                if (arrayList3 != null && valueOf7 && (List)valueOf9 != null && obj9.h != null) {
                }
                str17 = strArr;
                obj = str6;
                int i42 = i37;
                super(this, obj9.d, (f5)map.get(valueOf9), rawQuery, withOnConflict, arrayList, aVar5, 0);
                obj9.f.put(Integer.valueOf(intValue2), raVar);
                map = obj66;
                valueOf10 = i41;
                obj2 = str18;
                empty = i20;
                contains2 = obj3;
                if (valueOf7) {
                }
                valueOf9 = obj2.get(valueOf9);
                if ((List)(List)valueOf9 != null) {
                }
                if (obj9.h != null) {
                }
                if (obj9.g == null) {
                } else {
                }
                valueOf9 = (List)(List)valueOf9.iterator();
                while (valueOf9.hasNext()) {
                    Object next6 = valueOf9.next();
                    i6 = 1000;
                    longValue /= i6;
                    if (next6.H()) {
                    }
                    valueOf = Integer.valueOf((l3)next6.x());
                    if (arrayList.containsKey(valueOf)) {
                    }
                    if (aVar5.containsKey(valueOf) != null) {
                    }
                    aVar5.put(valueOf, Long.valueOf(aVar));
                    arrayList.put(valueOf, Long.valueOf(aVar));
                    longValue2 /= i6;
                }
                next6 = valueOf9.next();
                i6 = 1000;
                longValue /= i6;
                if (next6.H()) {
                }
                valueOf = Integer.valueOf((l3)next6.x());
                if (arrayList.containsKey(valueOf)) {
                }
                if (aVar5.containsKey(valueOf) != null) {
                }
                aVar5.put(valueOf, Long.valueOf(aVar));
                arrayList.put(valueOf, Long.valueOf(aVar));
                longValue2 /= i6;
                empty = 0;
                while (empty < i26 *= 64) {
                    if (da.N(obj4.I(), empty)) {
                    } else {
                    }
                    i5 = valueOf10;
                    i7 = contains2;
                    arrayList.remove(Integer.valueOf(empty));
                    empty++;
                    valueOf10 = i5;
                    contains2 = i7;
                    i5 = valueOf10;
                    i7 = contains2;
                    obj9.a.b().v().c("Filter already evaluated. audience ID, filter ID", Integer.valueOf(intValue2), Integer.valueOf(empty));
                    withOnConflict.set(empty);
                    if (da.N(obj4.G(), empty)) {
                    } else {
                    }
                    rawQuery.set(empty);
                }
                if (da.N(obj4.I(), empty)) {
                } else {
                }
                i5 = valueOf10;
                i7 = contains2;
                arrayList.remove(Integer.valueOf(empty));
                empty++;
                valueOf10 = i5;
                contains2 = i7;
                i5 = valueOf10;
                i7 = contains2;
                obj9.a.b().v().c("Filter already evaluated. audience ID, filter ID", Integer.valueOf(intValue2), Integer.valueOf(empty));
                withOnConflict.set(empty);
                if (da.N(obj4.G(), empty)) {
                } else {
                }
                rawQuery.set(empty);
                if (obj4.y() == 0) {
                } else {
                }
                hashSet = obj4.H().iterator();
                while (hashSet.hasNext()) {
                    valueOf3 = hashSet.next();
                    if ((h5)valueOf3.E() != 0 && valueOf3.w() > 0) {
                    }
                    if (valueOf3.w() > 0) {
                    }
                    aVar5.put(Integer.valueOf(valueOf3.x()), Long.valueOf(valueOf3.y(i5 + -1)));
                    empty = i20;
                    hashSet = i7;
                }
                valueOf3 = hashSet.next();
                if ((h5)valueOf3.E() != 0 && valueOf3.w() > 0) {
                }
                if (valueOf3.w() > 0) {
                }
                aVar5.put(Integer.valueOf(valueOf3.x()), Long.valueOf(valueOf3.y(i5 + -1)));
                empty = i20;
                hashSet = i7;
                if (obj4.w() == 0) {
                } else {
                }
                hashSet = obj4.F().iterator();
                while (hashSet.hasNext()) {
                    valueOf3 = hashSet.next();
                    if ((n4)valueOf3.D() != null) {
                    }
                    if (valueOf3.C()) {
                    } else {
                    }
                    valueOf3 = 0;
                    arrayList.put(Integer.valueOf(valueOf3.w()), valueOf3);
                    valueOf3 = Long.valueOf(valueOf3.x());
                }
                valueOf3 = hashSet.next();
                if ((n4)valueOf3.D() != null) {
                }
                if (valueOf3.C()) {
                } else {
                }
                valueOf3 = 0;
                arrayList.put(Integer.valueOf(valueOf3.w()), valueOf3);
                valueOf3 = Long.valueOf(valueOf3.x());
            }
        }
        str13 = valueOf10;
        str14 = contains2;
        str10 = strArr;
        str = str6;
        String str27 = "Skipping failed audience ID";
        if (!list2.isEmpty()) {
            hashSet = new ta(obj9, 0);
            valueOf3 = new a();
            arrayList2 = list2.iterator();
            while (arrayList2.hasNext()) {
                emptyMap = arrayList2.next();
                rawQuery = hashSet.a(obj9.d, (p4)emptyMap);
                if (rawQuery != null) {
                }
                query = 0;
                com.google.android.gms.measurement.internal.k kVar2 = obj9.b.U();
                str20 = obj9.d;
                qVar = kVar2.X(str20, emptyMap.D());
                if (qVar == null) {
                } else {
                }
                valueOf7 = 1;
                super(qVar.a, qVar.b, l7 + valueOf7, obj52, l8 + valueOf7, obj54, l9 + valueOf7, obj56, qVar.f, obj58, qVar.g, obj60, qVar.h, qVar.i, qVar.j, qVar.k);
                obj9.b.U().r(withOnConflict);
                contains2 = rawQuery.D();
                if ((Map)valueOf3.get(contains2) == null) {
                } else {
                }
                aVar = hashSet;
                obj67 = arrayList2;
                l5 = valueOf5;
                query = str14;
                valueOf11 = emptyMap.keySet().iterator();
                while (valueOf11.hasNext()) {
                    arrayList2 = (Integer)valueOf11.next().intValue();
                    valueOf5 = Integer.valueOf(arrayList2);
                    if (obj9.e.contains(valueOf5) != null) {
                    } else {
                    }
                    contains2 = (List)emptyMap.get(valueOf5).iterator();
                    valueOf5 = 1;
                    for (l3 next13 : contains2) {
                        ua uaVar2 = new ua(obj9, obj9.d, arrayList2, next13);
                        obj9.n(Integer.valueOf(arrayList2)).c(uaVar2);
                        emptyMap = i20;
                        valueOf11 = i7;
                    }
                    i20 = emptyMap;
                    i7 = valueOf11;
                    if (valueOf5 == null) {
                    }
                    emptyMap = i20;
                    valueOf11 = i7;
                    obj9.e.add(Integer.valueOf(arrayList2));
                    Object next13 = contains2.next();
                    uaVar2 = new ua(obj9, obj9.d, arrayList2, (l3)next13);
                    if (uaVar2.k(obj9.g, obj9.h, rawQuery, arrayList, str6, withOnConflict) != 0) {
                    } else {
                    }
                    obj9.e.add(Integer.valueOf(arrayList2));
                    obj9.n(Integer.valueOf(arrayList2)).c(uaVar2);
                    emptyMap = i20;
                    valueOf11 = i7;
                    obj9.a.b().v().b(str27, valueOf5);
                }
                arrayList2 = obj67;
                str14 = query;
                hashSet = aVar;
                valueOf5 = l5;
                arrayList2 = (Integer)valueOf11.next().intValue();
                valueOf5 = Integer.valueOf(arrayList2);
                if (obj9.e.contains(valueOf5) != null) {
                } else {
                }
                contains2 = (List)emptyMap.get(valueOf5).iterator();
                valueOf5 = 1;
                for (l3 next13 : contains2) {
                    uaVar2 = new ua(obj9, obj9.d, arrayList2, next13);
                    obj9.n(Integer.valueOf(arrayList2)).c(uaVar2);
                    emptyMap = i20;
                    valueOf11 = i7;
                }
                i20 = emptyMap;
                i7 = valueOf11;
                if (valueOf5 == null) {
                }
                emptyMap = i20;
                valueOf11 = i7;
                obj9.e.add(Integer.valueOf(arrayList2));
                next13 = contains2.next();
                uaVar2 = new ua(obj9, obj9.d, arrayList2, (l3)next13);
                if (uaVar2.k(obj9.g, obj9.h, rawQuery, arrayList, str6, withOnConflict) != 0) {
                } else {
                }
                obj9.e.add(Integer.valueOf(arrayList2));
                obj9.n(Integer.valueOf(arrayList2)).c(uaVar2);
                emptyMap = i20;
                valueOf11 = i7;
                obj9.a.b().v().b(str27, valueOf5);
                valueOf7 = obj9.b.U();
                arrayList3 = obj9.d;
                valueOf7.i();
                valueOf7.h();
                r.f(arrayList3);
                r.f(contains2);
                aVar3 = new a();
                aVar = hashSet;
                obj67 = arrayList2;
                arrayList2 = str10;
                hashSet = str;
                l5 = valueOf5;
                String[] strArr5 = new String[2];
                valueOf5 = valueOf7.R().query("event_filters", /* result */, "app_id=? AND event_name=?", strArr5, 0, 0, 0);
                if (valueOf5.moveToFirst()) {
                } else {
                }
                str = hashSet;
                str10 = arrayList2;
                query = str14;
                emptyMap = Collections.emptyMap();
                if (valueOf5 != null) {
                }
                valueOf3.put(contains2, emptyMap);
                valueOf5.close();
                str = hashSet;
                com.google.android.gms.internal.measurement.k3 k3Var = l3.y();
                da.D(k3Var, valueOf5.getBlob(1));
                hashSet = Integer.valueOf(valueOf5.getInt(0));
                Object obj11 = aVar3.get(hashSet);
                while ((List)obj11 == null) {
                    str10 = arrayList2;
                    arrayList2 = new ArrayList();
                    aVar3.put(hashSet, arrayList2);
                    arrayList2.add((l3)(k3)k3Var.l());
                    str18 = aVar3;
                    query = str14;
                    if (valueOf5.moveToNext()) {
                    }
                    str14 = query;
                    aVar3 = str18;
                    arrayList2 = str10;
                    k3Var = l3.y();
                    da.D(k3Var, valueOf5.getBlob(1));
                    hashSet = Integer.valueOf(valueOf5.getInt(0));
                    obj11 = aVar3.get(hashSet);
                    str10 = arrayList2;
                    arrayList2 = obj11;
                    str17 = aVar2;
                    str9 = obj10.a;
                    str9 = str9.b();
                    str9 = str9.r();
                    aVar2 = q3.z(str41);
                    valueOf4 = obj30;
                    str9.c(valueOf4, aVar2, th);
                }
                str10 = arrayList2;
                arrayList2 = obj11;
                arrayList2.add((l3)(k3)k3Var.l());
                str18 = aVar3;
                query = str14;
                if (valueOf5.moveToNext()) {
                }
                str14 = query;
                aVar3 = str18;
                arrayList2 = str10;
                if (valueOf5 != null) {
                }
                emptyMap = str18;
                valueOf5.close();
                str10 = arrayList2;
                arrayList2 = new ArrayList();
                aVar3.put(hashSet, arrayList2);
                kVar2.a.b().w().c("Event aggregate wasn't created during raw event logging. appId, event", q3.z(str20), kVar2.a.D().d(rawQuery.D()));
                super(str20, emptyMap.D(), 1, obj35, 1, obj37, 1, obj39, emptyMap.z(), obj41, 0, obj43, 0, 0, 0, 0);
                str17 = aVar2;
                str9 = obj10.a;
                str9 = str9.b();
                str9 = str9.r();
                aVar2 = q3.z(str41);
                valueOf4 = obj30;
                str9.c(valueOf4, aVar2, th);
                obj = str9;
                str17 = aVar2;
                valueOf4 = obj30;
                obj = str9;
                str17 = aVar2;
                obj = str9;
                str17 = aVar2;
                l5 = l4;
                valueOf4 = obj30;
                l4 = 0L;
                str9 = obj10.a;
                str9 = str9.b();
                str9 = str9.r();
                aVar2 = q3.z(str41);
                str9.c(arrayList4, aVar2, th);
                Throwable th = Collections.emptyMap();
                if (l4 != 0) {
                }
            }
        }
        str11 = valueOf5;
        if (!list3.isEmpty()) {
            hashSet = new a();
            valueOf3 = list3.iterator();
            while (valueOf3.hasNext()) {
                arrayList2 = next3;
                rawQuery = (j5)arrayList2.B();
                if ((Map)hashSet.get(rawQuery) == null) {
                } else {
                }
                obj67 = valueOf3;
                valueOf5 = str10;
                contains2 = str;
                Iterator iterator5 = emptyMap3.keySet().iterator();
                while (iterator5.hasNext()) {
                    rawQuery = (Integer)iterator5.next().intValue();
                    arrayList = Integer.valueOf(rawQuery);
                    if (obj9.e.contains(arrayList)) {
                        break loop_231;
                    } else {
                    }
                    withOnConflict = (List)emptyMap3.get(arrayList).iterator();
                    arrayList = 1;
                    while (withOnConflict.hasNext()) {
                        Object next12 = withOnConflict.next();
                        if (Log.isLoggable(obj9.a.b().C(), 2)) {
                        } else {
                        }
                        obj68 = emptyMap3;
                        wa waVar = new wa(obj9, obj9.d, rawQuery, next12);
                        obj9.n(Integer.valueOf(rawQuery)).c(waVar);
                        emptyMap3 = obj68;
                        if (next12.F()) {
                        } else {
                        }
                        arrayList3 = 0;
                        obj68 = emptyMap3;
                        obj9.a.b().v().d("Evaluating filter. audience, filter, property", Integer.valueOf(rawQuery), arrayList3, obj9.a.D().f(next12.A()));
                        obj9.a.b().v().b("Filter definition", obj9.b.e0().G(next12));
                        arrayList3 = Integer.valueOf(next12.w());
                    }
                    obj68 = emptyMap3;
                    if (arrayList == null) {
                    }
                    emptyMap3 = obj68;
                    obj9.e.add(Integer.valueOf(rawQuery));
                    next12 = withOnConflict.next();
                    if (Log.isLoggable(obj9.a.b().C(), 2)) {
                    } else {
                    }
                    obj68 = emptyMap3;
                    if ((t3)next12.F()) {
                    } else {
                    }
                    if (next12.F()) {
                    } else {
                    }
                    valueOf8 = 0;
                    obj9.a.b().w().c("Invalid property filter ID. appId, id", q3.z(obj9.d), String.valueOf(valueOf8));
                    valueOf8 = Integer.valueOf(next12.w());
                    if (next12.w() > 256) {
                    } else {
                    }
                    waVar = new wa(obj9, obj9.d, rawQuery, next12);
                    if (waVar.k(obj9.g, obj9.h, arrayList2, obj9.o(rawQuery, next12.w())) != 0) {
                    } else {
                    }
                    obj9.e.add(Integer.valueOf(rawQuery));
                    obj9.n(Integer.valueOf(rawQuery)).c(waVar);
                    emptyMap3 = obj68;
                    if (next12.F()) {
                    } else {
                    }
                    arrayList3 = 0;
                    obj68 = emptyMap3;
                    obj9.a.b().v().d("Evaluating filter. audience, filter, property", Integer.valueOf(rawQuery), arrayList3, obj9.a.D().f(next12.A()));
                    obj9.a.b().v().b("Filter definition", obj9.b.e0().G(next12));
                    arrayList3 = Integer.valueOf(next12.w());
                }
                valueOf3 = obj67;
                str = contains2;
                str10 = valueOf5;
                rawQuery = (Integer)iterator5.next().intValue();
                arrayList = Integer.valueOf(rawQuery);
                if (obj9.e.contains(arrayList)) {
                } else {
                }
                withOnConflict = (List)emptyMap3.get(arrayList).iterator();
                arrayList = 1;
                while (withOnConflict.hasNext()) {
                    next12 = withOnConflict.next();
                    if (Log.isLoggable(obj9.a.b().C(), 2)) {
                    } else {
                    }
                    obj68 = emptyMap3;
                    waVar = new wa(obj9, obj9.d, rawQuery, next12);
                    obj9.n(Integer.valueOf(rawQuery)).c(waVar);
                    emptyMap3 = obj68;
                    if (next12.F()) {
                    } else {
                    }
                    arrayList3 = 0;
                    obj68 = emptyMap3;
                    obj9.a.b().v().d("Evaluating filter. audience, filter, property", Integer.valueOf(rawQuery), arrayList3, obj9.a.D().f(next12.A()));
                    obj9.a.b().v().b("Filter definition", obj9.b.e0().G(next12));
                    arrayList3 = Integer.valueOf(next12.w());
                }
                obj68 = emptyMap3;
                if (arrayList == null) {
                }
                emptyMap3 = obj68;
                obj9.e.add(Integer.valueOf(rawQuery));
                next12 = withOnConflict.next();
                if (Log.isLoggable(obj9.a.b().C(), 2)) {
                } else {
                }
                obj68 = emptyMap3;
                if ((t3)next12.F()) {
                } else {
                }
                if (next12.F()) {
                } else {
                }
                valueOf8 = 0;
                obj9.a.b().w().c("Invalid property filter ID. appId, id", q3.z(obj9.d), String.valueOf(valueOf8));
                valueOf8 = Integer.valueOf(next12.w());
                if (next12.w() > 256) {
                } else {
                }
                waVar = new wa(obj9, obj9.d, rawQuery, next12);
                if (waVar.k(obj9.g, obj9.h, arrayList2, obj9.o(rawQuery, next12.w())) != 0) {
                } else {
                }
                obj9.e.add(Integer.valueOf(rawQuery));
                obj9.n(Integer.valueOf(rawQuery)).c(waVar);
                emptyMap3 = obj68;
                if (next12.F()) {
                } else {
                }
                arrayList3 = 0;
                obj68 = emptyMap3;
                obj9.a.b().v().d("Evaluating filter. audience, filter, property", Integer.valueOf(rawQuery), arrayList3, obj9.a.D().f(next12.A()));
                obj9.a.b().v().b("Filter definition", obj9.b.e0().G(next12));
                arrayList3 = Integer.valueOf(next12.w());
                obj9.a.b().v().b(str27, arrayList);
                withOnConflict = obj9.b.U();
                arrayList = obj9.d;
                withOnConflict.i();
                withOnConflict.h();
                r.f(arrayList);
                r.f(rawQuery);
                valueOf10 = new a();
                String[] strArr6 = new String[2];
                query = withOnConflict.R().query("property_filters", /* result */, "app_id=? AND property_name=?", strArr6, 0, 0, 0);
                if (query.moveToFirst()) {
                } else {
                }
                obj67 = valueOf3;
                emptyMap3 = Collections.emptyMap();
                if (query != null) {
                }
                hashSet.put(rawQuery, emptyMap3);
                query.close();
                com.google.android.gms.internal.measurement.s3 s3Var = t3.y();
                da.D(s3Var, query.getBlob(1));
                valueOf7 = Integer.valueOf(query.getInt(0));
                str18 = valueOf10.get(valueOf7);
                while ((List)str18 == null) {
                    arrayList3 = new ArrayList();
                    valueOf10.put(valueOf7, arrayList3);
                    arrayList3.add((t3)(s3)s3Var.l());
                    obj67 = valueOf3;
                    if (query.moveToNext()) {
                    }
                    valueOf3 = obj67;
                    s3Var = t3.y();
                    da.D(s3Var, query.getBlob(1));
                    valueOf7 = Integer.valueOf(query.getInt(0));
                    str18 = valueOf10.get(valueOf7);
                    arrayList3 = str18;
                    Object obj10 = str5.a;
                    obj10 = obj10.b();
                    obj10 = obj10.r();
                    String str41 = "Failed to merge filter";
                    list2 = str8;
                    str8 = q3.z(valueOf2);
                    obj10.c(str41, str8, th);
                }
                arrayList3 = str18;
                arrayList3.add((t3)(s3)s3Var.l());
                obj67 = valueOf3;
                if (query.moveToNext()) {
                }
                valueOf3 = obj67;
                if (query != null) {
                }
                emptyMap3 = valueOf10;
                query.close();
                arrayList3 = new ArrayList();
                valueOf10.put(valueOf7, arrayList3);
                obj10 = str5.a;
                obj10 = obj10.b();
                obj10 = obj10.r();
                str41 = "Failed to merge filter";
                list2 = str8;
                str8 = q3.z(valueOf2);
                obj10.c(str41, str8, th);
                list2 = str8;
                list2 = str8;
                valueOf4 = null;
                str8 = str5.a;
                str8 = str8.b();
                str8 = str8.r();
                str5 = q3.z(valueOf2);
                str8.c(arrayList4, str5, th);
                th = Collections.emptyMap();
                if (valueOf4 != null) {
                }
            }
        }
        ArrayList arrayList5 = new ArrayList();
        keySet = obj9.f.keySet();
        keySet.removeAll(obj9.e);
        Iterator iterator4 = keySet.iterator();
        while (iterator4.hasNext()) {
            int intValue3 = (Integer)iterator4.next().intValue();
            Integer valueOf18 = Integer.valueOf(intValue3);
            Object obj5 = obj9.f.get(valueOf18);
            r.j((ra)obj5);
            l4 l4Var = obj5.a(intValue3);
            arrayList5.add(l4Var);
            valueOf3 = obj9.b.U();
            rawQuery = obj9.d;
            f5 f5Var = l4Var.z();
            valueOf3.i();
            valueOf3.h();
            r.f(rawQuery);
            r.j(f5Var);
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("app_id", rawQuery);
            contentValues2.put(str10, valueOf18);
            arrayList2 = str11;
            contentValues2.put(arrayList2, f5Var.j());
            if (Long.compare(withOnConflict, str13) == 0) {
            }
            str11 = arrayList2;
            valueOf3.a.b().r().b("Failed to insert filter results (got -1). appId", q3.z(rawQuery));
            str8 = str8.a;
            str8 = str8.b();
            str8 = str8.r();
            rawQuery = q3.z(rawQuery);
            str5 = "Error storing filter results. appId";
            str8.c(str5, rawQuery, th);
        }
        return arrayList5;
    }
}
