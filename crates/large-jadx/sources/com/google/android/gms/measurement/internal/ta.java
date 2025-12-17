package com.google.android.gms.measurement.internal;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.internal.measurement.o4;
import com.google.android.gms.internal.measurement.p4;
import com.google.android.gms.internal.measurement.t4;
import com.google.android.gms.internal.measurement.t8;
import com.google.android.gms.internal.measurement.w8;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
final class ta {

    private p4 a;
    private Long b;
    private long c;
    final com.google.android.gms.measurement.internal.xa d;
    ta(com.google.android.gms.measurement.internal.xa xa, com.google.android.gms.measurement.internal.sa sa2) {
        this.d = xa;
        super();
    }

    final p4 a(String string, p4 p42) {
        Object str;
        int cmp;
        Object baVar;
        Object arrayList;
        int create;
        String empty;
        com.google.android.gms.measurement.internal.k kVar;
        Object valueOf;
        String next;
        String next2;
        Object strArr;
        com.google.android.gms.measurement.internal.b5 b5Var;
        int first;
        int i;
        p4 p4Var;
        Object list;
        Object longValue2;
        int i2;
        Object str2;
        int longValue;
        Object longValue3;
        int rawQuery;
        String longValue4;
        final Object obj2 = this;
        next = string;
        final p4 p4Var4 = p42;
        str = p42.D();
        xaVar9.b.e0();
        empty = "_eid";
        strArr = da.p(p4Var4, empty);
        i = 0;
        r.j((Long)strArr);
        xaVar.b.e0();
        longValue2 = obj;
        first = 0;
        if (strArr != null && str.equals("_ep") && TextUtils.isEmpty((String)longValue2)) {
            i = 0;
            if (str.equals("_ep")) {
                r.j(strArr);
                xaVar.b.e0();
                longValue2 = obj;
                first = 0;
                if (TextUtils.isEmpty((String)longValue2)) {
                    xaVar2.a.b().t().b("Extra parameter without an event name. eventId", strArr);
                    return first;
                }
                i2 = 1;
                longValue = 0;
                if (obj2.a != null && obj2.b != null) {
                    if (obj2.b != null) {
                        if (Long.compare(longValue3, longValue4) != 0) {
                            longValue3 = xaVar6.b.U();
                            longValue3.h();
                            longValue3.i();
                            String[] strArr2 = new String[2];
                            strArr2[longValue] = next;
                            strArr2[i2] = strArr.toString();
                            rawQuery = longValue3.R().rawQuery("select main_event, children_to_process from main_event_params where app_id=? and event_id=?", strArr2);
                            if (!rawQuery.moveToFirst()) {
                                longValue3.a.b().v().a("Main event not found");
                                if (rawQuery != null) {
                                    rawQuery.close();
                                }
                                create = first;
                            } else {
                                first = p4.A();
                                da.D(first, rawQuery.getBlob(longValue));
                                create = Pair.create((p4)(o4)first.l(), Long.valueOf(rawQuery.getLong(i2)));
                                if (rawQuery != null) {
                                    rawQuery.close();
                                }
                            }
                            first = create.first;
                            if (create != 0 && first == null) {
                                first = create.first;
                                if (first == null) {
                                }
                                obj2.a = (p4)first;
                                obj2.c = (Long)create.second.longValue();
                                xaVar7.b.e0();
                                obj2.b = (Long)da.p(obj2.a, empty);
                            }
                        }
                        l += rawQuery;
                        obj2.c = str2;
                        if (Long.compare(str2, i) <= 0) {
                            kVar = xaVar4.b.U();
                            kVar.h();
                            kVar.a.b().v().b("Clearing complex main event info. appId", next);
                            strArr = new String[i2];
                            strArr[0] = next;
                            kVar.R().execSQL("delete from main_event_params where app_id=?", strArr);
                        } else {
                            xaVar3.b.U().x(string, strArr, obj2.c, i);
                        }
                        arrayList = new ArrayList();
                        Iterator iterator = obj2.a.E().iterator();
                        while (iterator.hasNext()) {
                            next2 = iterator.next();
                            xaVar13.b.e0();
                            if (da.o(p4Var4, (t4)next2.C()) == null) {
                            }
                            arrayList.add(next2);
                        }
                        if (!arrayList.isEmpty()) {
                            arrayList.addAll(p42.E());
                            list = arrayList;
                        } else {
                            xaVar5.a.b().t().b("No unique parameters in main event. eventName", longValue2);
                        }
                        str = longValue2;
                    } else {
                    }
                } else {
                }
                xaVar8.a.b().t().c("Extra parameter without existing main event. eventName, eventId", longValue2, strArr);
                return null;
            }
            obj2.b = strArr;
            obj2.a = p4Var4;
            xaVar10.b.e0();
            valueOf = Long.valueOf(i);
            b5Var = da.p(p4Var4, "_epc");
            if (b5Var != null) {
                valueOf = b5Var;
            }
            longValue2 = (Long)valueOf.longValue();
            obj2.c = longValue2;
            if (Long.compare(longValue2, i) <= 0) {
                xaVar12.a.b().t().b("Complex event with zero extra param count. eventName", str);
            } else {
                r.j(strArr);
                xaVar11.b.U().x(string, (Long)strArr, obj2.c, i);
            }
        }
        t8 t8Var = p42.q();
        (o4)t8Var.A(str);
        t8Var.y();
        t8Var.v(list);
        return (p4)t8Var.l();
    }
}
