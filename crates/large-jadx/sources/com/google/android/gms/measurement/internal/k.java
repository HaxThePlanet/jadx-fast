package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.util.e;
import com.google.android.gms.internal.measurement.i3;
import com.google.android.gms.internal.measurement.j3;
import com.google.android.gms.internal.measurement.k3;
import com.google.android.gms.internal.measurement.k7;
import com.google.android.gms.internal.measurement.kd;
import com.google.android.gms.internal.measurement.l3;
import com.google.android.gms.internal.measurement.m3;
import com.google.android.gms.internal.measurement.n3;
import com.google.android.gms.internal.measurement.o4;
import com.google.android.gms.internal.measurement.p4;
import com.google.android.gms.internal.measurement.s3;
import com.google.android.gms.internal.measurement.t3;
import com.google.android.gms.internal.measurement.t4;
import com.google.android.gms.internal.measurement.t8;
import com.google.android.gms.internal.measurement.w8;
import com.google.android.gms.internal.measurement.z4;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
final class k extends com.google.android.gms.measurement.internal.r9 {

    private static final String[] f;
    private static final String[] g;
    private static final String[] h;
    private static final String[] i;
    private static final String[] j;
    private static final String[] k;
    private static final String[] l;
    private static final String[] m;
    private final com.google.android.gms.measurement.internal.j d;
    private final com.google.android.gms.measurement.internal.n9 e;
    static {
        k.f = /* result */;
        k.g = /* result */;
        k.h = /* result */;
        k.i = /* result */;
        k.j = /* result */;
        String str5 = "session_scoped";
        k.k = /* result */;
        k.l = /* result */;
        k.m = /* result */;
    }

    k(com.google.android.gms.measurement.internal.ba ba) {
        super(ba);
        n9 obj3 = new n9(this.a.c());
        this.e = obj3;
        this.a.z();
        obj3 = new j(this, this.a.f(), "google_app_measurement.db");
        this.d = obj3;
    }

    static String[] A() {
        return k.m;
    }

    static String[] B() {
        return k.h;
    }

    static String[] C() {
        return k.f;
    }

    static String[] D() {
        return k.k;
    }

    static String[] E() {
        return k.l;
    }

    static String[] F() {
        return k.j;
    }

    static String[] G() {
        return k.i;
    }

    static String[] H() {
        return k.g;
    }

    static final void J(ContentValues contentValues, String string2, Object object3) {
        String obj2 = "value";
        r.f(obj2);
        r.j(object3);
        if (object3 instanceof String != null) {
            contentValues.put(obj2, (String)object3);
        }
        if (object3 instanceof Long) {
            contentValues.put(obj2, (Long)object3);
        }
        if (!object3 instanceof Double) {
        } else {
            contentValues.put(obj2, (Double)object3);
        }
        IllegalArgumentException obj1 = new IllegalArgumentException("Invalid value type");
        throw obj1;
    }

    private final long L(String string, String[] string2Arr2) {
        int i = 0;
        Cursor rawQuery = R().rawQuery(string, string2Arr2);
        if (!rawQuery.moveToFirst()) {
        } else {
            if (rawQuery != null) {
                rawQuery.close();
            }
            return rawQuery.getLong(0);
        }
        SQLiteException obj5 = new SQLiteException("Database returned empty set");
        throw obj5;
    }

    private final long M(String string, String[] string2Arr2, long l3) {
        int i = 0;
        Cursor rawQuery = R().rawQuery(string, string2Arr2);
        if (rawQuery.moveToFirst() && rawQuery != null) {
            if (rawQuery != null) {
                rawQuery.close();
            }
            return rawQuery.getLong(0);
        }
        if (rawQuery != null) {
            try {
                rawQuery.close();
                return l3;
                l3 = this.a;
                l3 = l3.b();
                l3 = l3.r();
                obj6 = "Database error";
                l3.c(obj6, string, string2Arr2);
                throw string2Arr2;
                if (obj1 == null) {
                } else {
                }
                obj1.close();
                throw string;
            } catch (Throwable th) {
            }
        }
    }

    static com.google.android.gms.measurement.internal.n9 Y(com.google.android.gms.measurement.internal.k k) {
        return k.e;
    }

    @Override // com.google.android.gms.measurement.internal.r9
    public final void I(String string, long l2, long l3, com.google.android.gms.measurement.internal.aa aa4) {
        boolean moveToFirst;
        boolean z;
        com.google.android.gms.measurement.internal.b5 b5Var;
        Object obj;
        String str3;
        int string3;
        String str;
        Cursor rawQuery;
        String str8;
        Cursor query;
        com.google.android.gms.measurement.internal.b5 str6;
        String string2;
        boolean moveToNext;
        int strArr;
        String long2;
        String str4;
        String[] strArr3;
        void strArr5;
        String[] valueOf3;
        String[] strArr4;
        StringBuilder stringBuilder;
        Object str5;
        String str2;
        Object valueOf;
        String valueOf2;
        String[] strArr2;
        int long;
        int i;
        String str7;
        Cursor cursor;
        final Object obj2 = this;
        obj = obj26;
        r.j(obj26);
        h();
        i();
        string3 = 0;
        SQLiteDatabase sQLiteDatabase = R();
        str4 = "";
        int i12 = -1;
        int i14 = 2;
        int i10 = 1;
        int i9 = 0;
        if (TextUtils.isEmpty(string3)) {
            int cmp3 = Long.compare(aa4, i12);
            if (cmp3 != 0) {
                strArr3 = new String[i14];
                strArr3[i9] = String.valueOf(aa4);
                strArr3[i10] = String.valueOf(l2);
            } else {
                new String[i10][i9] = String.valueOf(l2);
            }
            if (cmp3 != 0) {
                str4 = "rowid <= ? and ";
            }
            stringBuilder = new StringBuilder(length2 += 148);
            stringBuilder.append("select app_id, metadata_fingerprint from raw_events where ");
            stringBuilder.append(str4);
            stringBuilder.append("app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;");
            rawQuery = sQLiteDatabase.rawQuery(stringBuilder.toString(), strArr3);
            if (!rawQuery.moveToFirst() && rawQuery != null) {
                if (rawQuery != null) {
                    rawQuery.close();
                }
            }
            string3 = rawQuery.getString(i9);
            string2 = rawQuery.getString(i10);
            rawQuery.close();
        } else {
            int cmp2 = Long.compare(aa4, i12);
            if (cmp2 != 0) {
                strArr3 = new String[i14];
                strArr3[i9] = string3;
                strArr3[i10] = String.valueOf(aa4);
            } else {
                try {
                    strArr3 = /* result */;
                    if (cmp2 != 0) {
                    }
                    str4 = " and rowid <= ?";
                    stringBuilder = new StringBuilder(length += 84);
                    stringBuilder.append("select metadata_fingerprint from raw_events where app_id = ?");
                    stringBuilder.append(str4);
                    stringBuilder.append(" order by rowid limit 1;");
                    rawQuery = sQLiteDatabase.rawQuery(stringBuilder.toString(), strArr3);
                    if (!rawQuery.moveToFirst() && rawQuery != null) {
                    }
                    if (rawQuery != null) {
                    }
                    rawQuery.close();
                    string2 = rawQuery.getString(i9);
                    rawQuery.close();
                } catch (android.database.sqlite.SQLiteException sQLite) {
                } catch (Throwable th1) {
                }
            }
        }
        Cursor cursor2 = rawQuery;
        String str25 = string2;
        String[] strArr6 = new String[i14];
        strArr6[i9] = string3;
        strArr6[i10] = str25;
        int i15 = i9;
        Cursor query2 = sQLiteDatabase.query("raw_events_metadata", /* result */, "app_id = ? and metadata_fingerprint = ?", strArr6, 0, 0, "rowid", "2");
        obj2.a.b().r().b("Raw event metadata record is missing. appId", q3.z(string3));
        if (!query2.moveToFirst() && query2 != null) {
            obj2.a.b().r().b("Raw event metadata record is missing. appId", q3.z(string3));
            if (query2 != null) {
                query2.close();
            }
        }
        com.google.android.gms.internal.measurement.y4 y4Var = z4.G1();
        da.D(y4Var, query2.getBlob(i15));
        w8 w8Var2 = (y4)y4Var.l();
        if (query2.moveToNext()) {
            obj2.a.b().w().b("Get multiple raw event metadata records, expected one. appId", q3.z(string3));
        }
        query2.close();
        r.j((z4)w8Var2);
        obj.a = w8Var2;
        int i13 = 3;
        if (Long.compare(aa4, i12) != 0) {
            strArr = new String[i13];
            strArr[i15] = string3;
            strArr[1] = str25;
            strArr[2] = String.valueOf(aa4);
            str2 = str8;
            strArr2 = strArr;
        } else {
            valueOf3 = new String[2];
            valueOf3[i15] = string3;
            valueOf3[1] = str25;
            str2 = str8;
            strArr2 = valueOf3;
        }
        int i8 = 0;
        cursor = query2;
        query = sQLiteDatabase.query("raw_events", /* result */, str2, strArr2, 0, i8, "rowid", 0);
        if (query.moveToFirst()) {
        }
        obj2.a.b().w().b("Raw event data disappeared while in transaction. appId", q3.z(string3));
        if (query != null) {
            query.close();
        }
    }

    @Override // com.google.android.gms.measurement.internal.r9
    public final int K(String string, String string2) {
        r.f(string);
        r.f(string2);
        h();
        i();
        String[] strArr = new String[2];
        return R().delete("conditional_properties", "app_id=? and name=?", string, string2);
    }

    @Override // com.google.android.gms.measurement.internal.r9
    protected final long N(String string, String string2) {
        Throwable th2;
        int cmp;
        com.google.android.gms.measurement.internal.b5 b5Var;
        Throwable str;
        int cmp2;
        long l;
        Throwable th;
        long l2;
        int i;
        String obj14;
        r.f(string);
        final String obj15 = "first_open_count";
        r.f(obj15);
        h();
        i();
        final SQLiteDatabase sQLiteDatabase = R();
        sQLiteDatabase.beginTransaction();
        int i2 = 0;
        StringBuilder stringBuilder = new StringBuilder(48);
        stringBuilder.append("select ");
        stringBuilder.append(obj15);
        stringBuilder.append(" from app2 where app_id=?");
        int i4 = 1;
        String[] strArr2 = new String[i4];
        int i5 = 0;
        strArr2[i5] = string;
        final int i6 = -1;
        String str6 = "app2";
        String str9 = "app_id";
        ContentValues contentValues = new ContentValues();
        contentValues.put(str9, string);
        Integer valueOf = Integer.valueOf(i5);
        contentValues.put(obj15, valueOf);
        contentValues.put("previous_install_count", valueOf);
        if (Long.compare(l2, i6) == 0 && Long.compare(withOnConflict, i6) == 0) {
            contentValues = new ContentValues();
            contentValues.put(str9, string);
            valueOf = Integer.valueOf(i5);
            contentValues.put(obj15, valueOf);
            contentValues.put("previous_install_count", valueOf);
            if (Long.compare(withOnConflict, i6) == 0) {
                this.a.b().r().c("Failed to insert column (got -1). appId", q3.z(string), obj15);
                sQLiteDatabase.endTransaction();
                return i6;
            }
            l2 = i2;
        }
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put(str9, string);
        contentValues2.put(obj15, Long.valueOf(i8 += l2));
        String[] strArr = new String[i4];
        strArr[i5] = string;
        if (Long.compare(l, i2) == 0) {
            this.a.b().r().c("Failed to update column (got 0). appId", q3.z(string), obj15);
            sQLiteDatabase.endTransaction();
            return i6;
        }
        sQLiteDatabase.setTransactionSuccessful();
        sQLiteDatabase.endTransaction();
        return l2;
    }

    @Override // com.google.android.gms.measurement.internal.r9
    public final long O() {
        return M("select max(bundle_end_timestamp) from queue", 0, 0);
    }

    @Override // com.google.android.gms.measurement.internal.r9
    public final long P() {
        return M("select max(timestamp) from raw_events", 0, 0);
    }

    @Override // com.google.android.gms.measurement.internal.r9
    public final long Q(String string) {
        r.f(string);
        String[] strArr = new String[1];
        return M("select count(1) from events where app_id=? and name not like '!_%' escape '!'", strArr, 0);
    }

    @Override // com.google.android.gms.measurement.internal.r9
    final SQLiteDatabase R() {
        h();
        return this.d.getWritableDatabase();
    }

    @Override // com.google.android.gms.measurement.internal.r9
    public final Bundle S(String string) {
        Object obj2;
        Throwable th;
        com.google.android.gms.measurement.internal.b5 str;
        o4 next;
        String str3;
        String str2;
        double d;
        h();
        i();
        String[] strArr = new String[1];
        int i3 = 0;
        strArr[i3] = string;
        Cursor rawQuery = R().rawQuery("select parameters from default_event_params where app_id=?", strArr);
        this.a.b().v().a("Default event parameters not found");
        if (!rawQuery.moveToFirst() && rawQuery != null) {
            this.a.b().v().a("Default event parameters not found");
            if (rawQuery != null) {
                rawQuery.close();
            }
            return null;
        }
        next = p4.A();
        da.D(next, rawQuery.getBlob(i3));
        this.b.e0();
        Bundle bundle = new Bundle();
        Iterator obj8 = (p4)(o4)next.l().E().iterator();
        while (obj8.hasNext()) {
            next = obj8.next();
            str2 = (t4)next.C();
            if (next.P()) {
            } else {
            }
            if (next.Q()) {
            } else {
            }
            if (next.T()) {
            } else {
            }
            if (next.R()) {
            }
            bundle.putLong(str2, next.z());
            bundle.putString(str2, next.D());
            bundle.putFloat(str2, next.x());
            bundle.putDouble(str2, next.w());
        }
        if (rawQuery != null) {
            rawQuery.close();
        }
        return bundle;
    }

    @Override // com.google.android.gms.measurement.internal.r9
    public final com.google.android.gms.measurement.internal.g5 T(String string) {
        int i2;
        int list;
        boolean string2;
        boolean moveToNext;
        Object obj;
        Object obj3;
        Object obj4;
        com.google.android.gms.measurement.internal.b5 b5Var;
        String str;
        int i;
        long l;
        boolean z;
        int int2;
        boolean null;
        Object str2;
        int int;
        int long;
        int long2;
        final Object obj2 = this;
        final String str3 = string;
        r.f(string);
        h();
        i();
        final int i6 = 0;
        i2 = 1;
        String[] strArr2 = new String[i2];
        int i28 = 0;
        strArr2[i28] = str3;
        String str8 = "app_id=?";
        int i26 = 0;
        Cursor query = R().query("apps", /* result */, str8, strArr2, 0, i26, 0);
        if (!query.moveToFirst() && query != null) {
            if (query != null) {
                query.close();
            }
            return i6;
        }
        g5 g5Var = new g5(obj2.b.a0(), str3);
        g5Var.i(query.getString(i28));
        g5Var.y(query.getString(i2));
        g5Var.H(query.getString(2));
        g5Var.D(query.getLong(3));
        g5Var.E(query.getLong(4));
        g5Var.C(query.getLong(5));
        g5Var.k(query.getString(6));
        g5Var.j(query.getString(7));
        g5Var.z(query.getLong(8));
        g5Var.t(query.getLong(9));
        int = 10;
        boolean null3 = query.isNull(int);
        if (!null3) {
            if (query.getInt(int) != 0) {
                i = i2;
            } else {
                i = i28;
            }
        } else {
        }
        g5Var.F(i);
        g5Var.s(query.getLong(11));
        g5Var.q(query.getLong(12));
        g5Var.p(query.getLong(13));
        g5Var.n(query.getLong(14));
        g5Var.m(query.getLong(15));
        g5Var.v(query.getLong(16));
        int i21 = 17;
        boolean null4 = query.isNull(i21);
        if (null4) {
            l = Integer.MIN_VALUE;
        } else {
            l = (long)int3;
        }
        g5Var.l(l);
        g5Var.w(query.getString(18));
        g5Var.o(query.getLong(19));
        g5Var.r(query.getLong(20));
        g5Var.B(query.getString(21));
        if (!obj2.a.z().B(i6, c3.m0)) {
            z = 22;
            if (query.isNull(z)) {
                try {
                    long2 = long;
                    long2 = query.getLong(z);
                    g5Var.h(long2);
                    int2 = 23;
                    if (!query.isNull(int2)) {
                    }
                    if (query.getInt(int2) != 0) {
                    } else {
                    }
                    i2 = i28;
                    g5Var.g(i2);
                    g5Var.f(query.getString(24));
                    int i4 = 25;
                    if (query.isNull(i4)) {
                    } else {
                    }
                    long = query.getLong(i4);
                    g5Var.u(long);
                    list = 26;
                    if (!query.isNull(list)) {
                    }
                    g5Var.I(Arrays.asList(query.getString(list).split(",", -1)));
                    kd.b();
                    if (obj2.a.z().B(str3, c3.d0)) {
                    }
                    g5Var.x(query.getString(27));
                    g5Var.d();
                    if (query.moveToNext()) {
                    }
                    obj2.a.b().r().b("Got multiple records for app, expected one. appId", q3.z(string));
                    if (query != null) {
                    }
                    query.close();
                    return g5Var;
                    obj4 = obj3;
                    b5Var = obj1.a;
                    b5Var = b5Var.b();
                    b5Var = b5Var.r();
                    b5Var.c("Error querying app. appId", q3.z(string), th);
                    if (obj4 != null) {
                    }
                    obj4.close();
                    return obj3;
                    obj3 = obj4;
                    if (obj3 == null) {
                    } else {
                    }
                    obj3.close();
                    throw th;
                } catch (android.database.sqlite.SQLiteException sQLite) {
                } catch (Throwable th1) {
                }
            } else {
            }
        }
    }

    @Override // com.google.android.gms.measurement.internal.r9
    public final com.google.android.gms.measurement.internal.c U(String string, String string2) {
        com.google.android.gms.measurement.internal.b5 b5Var;
        boolean moveToNext;
        String str2;
        String str;
        Object obj;
        String string3;
        long long;
        Object obj2;
        Object obj5;
        Object obj6;
        int i;
        final Object obj3 = this;
        final String str4 = string2;
        r.f(string);
        r.f(string2);
        h();
        i();
        final String str18 = "time_to_live";
        int i2 = 2;
        String[] strArr2 = new String[i2];
        int i8 = 0;
        strArr2[i8] = string;
        int i12 = 1;
        strArr2[i12] = str4;
        Cursor query = R().query("conditional_properties", /* result */, "app_id=? and name=?", strArr2, 0, 0, 0);
        if (!query.moveToFirst() && query != null) {
            if (query != null) {
                query.close();
            }
            return null;
        }
        if (query.getString(i8) == null) {
            string3 = "";
        }
        String str15 = string3;
        i = query.getInt(i2) != 0 ? i12 : i8;
        android.os.Parcelable.Creator cREATOR = u.CREATOR;
        super(string2, query.getLong(8), obj2, obj3.a0(query, i12), str15);
        super(string, str15, eaVar2, query.getLong(6), str18, i, query.getString(3), (u)obj3.b.e0().A(query.getBlob(5), cREATOR), query.getLong(4), obj25, (u)obj3.b.e0().A(query.getBlob(7), cREATOR), query.getLong(9), obj28, (u)obj3.b.e0().A(query.getBlob(10), cREATOR));
        if (query.moveToNext()) {
            obj3.a.b().r().c("Got multiple records for conditional property, expected one", q3.z(string), obj3.a.D().f(str4));
        }
        if (query != null) {
            query.close();
        }
        return cVar;
    }

    @Override // com.google.android.gms.measurement.internal.r9
    public final com.google.android.gms.measurement.internal.i V(long l, String string2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        return this.W(l, obj2, z3, true, obj5, false, false, z6);
    }

    @Override // com.google.android.gms.measurement.internal.r9
    public final com.google.android.gms.measurement.internal.i W(long l, String string2, long l3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8) {
        int i;
        com.google.android.gms.measurement.internal.b5 b5Var;
        String str;
        Object obj;
        long long;
        r.f(l3);
        h();
        i();
        i = 1;
        String[] strArr = new String[i];
        int i5 = 0;
        strArr[i5] = l3;
        i iVar = new i();
        int i6 = 0;
        final SQLiteDatabase sQLiteDatabase2 = R();
        String[] strArr3 = new String[i];
        strArr3[i5] = l3;
        String str13 = "apps";
        Cursor query = sQLiteDatabase2.query(str13, /* result */, "app_id=?", strArr3, 0, 0, 0);
        obj2.a.b().w().b("Not updating daily counts, app is not known. appId", q3.z(l3));
        if (!query.moveToFirst() && query != null) {
            obj2.a.b().w().b("Not updating daily counts, app is not known. appId", q3.z(l3));
            if (query != null) {
                query.close();
            }
            return iVar;
        }
        if (Long.compare(long, l) == 0) {
            iVar.b = query.getLong(i);
            iVar.a = query.getLong(2);
            iVar.c = query.getLong(3);
            iVar.d = query.getLong(4);
            iVar.e = query.getLong(5);
        }
        if (z6) {
            iVar.b = l2 += z4;
        }
        if (z7) {
            iVar.a = l4 += z4;
        }
        if (z8) {
            iVar.c = l5 += z4;
        }
        if (obj24 != null) {
            iVar.d = l12 += z4;
        }
        if (obj25 != null) {
            iVar.e = l6 += z4;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("day", Long.valueOf(l));
        contentValues.put("daily_public_events_count", Long.valueOf(iVar.a));
        contentValues.put("daily_events_count", Long.valueOf(iVar.b));
        contentValues.put("daily_conversions_count", Long.valueOf(iVar.c));
        contentValues.put("daily_error_events_count", Long.valueOf(iVar.d));
        contentValues.put("daily_realtime_events_count", Long.valueOf(iVar.e));
        sQLiteDatabase2.update("apps", contentValues, "app_id=?", strArr);
        if (query != null) {
            query.close();
        }
        return iVar;
    }

    @Override // com.google.android.gms.measurement.internal.r9
    public final com.google.android.gms.measurement.internal.q X(String string, String string2) {
        Long valueOf3;
        boolean moveToNext;
        com.google.android.gms.measurement.internal.b5 b5Var2;
        Long valueOf4;
        Long valueOf2;
        Boolean valueOf;
        int long2;
        Object str;
        String str3;
        Object str4;
        Object obj;
        com.google.android.gms.measurement.internal.b5 b5Var;
        String str2;
        int i5;
        int i3;
        int i4;
        Long num;
        int i2;
        long long;
        long long3;
        Long num2;
        Boolean bool;
        int i;
        r.f(string);
        r.f(string2);
        h();
        i();
        ArrayList arrayList = new ArrayList(Arrays.asList(/* result */));
        final int i14 = 0;
        i3 = 0;
        int i6 = 2;
        String[] strArr3 = new String[i6];
        strArr3[i3] = string;
        int i13 = 1;
        strArr3[i13] = string2;
        int i11 = 0;
        Cursor query = R().query("events", (String[])arrayList.toArray(new String[i3]), "app_id=? and name=?", strArr3, 0, i11, 0);
        if (!query.moveToFirst() && query != null) {
            if (query != null) {
                query.close();
            }
            return i14;
        }
        int i7 = 3;
        int i9 = 0;
        if (query.isNull(i7)) {
            long = i9;
        } else {
            long = query.getLong(i7);
        }
        int i8 = 4;
        if (query.isNull(i8)) {
            valueOf3 = i14;
        } else {
            valueOf3 = Long.valueOf(query.getLong(i8));
        }
        valueOf4 = 5;
        if (query.isNull(valueOf4)) {
            num = i14;
        } else {
            num = valueOf4;
        }
        valueOf2 = 6;
        if (query.isNull(valueOf2)) {
            num2 = i14;
        } else {
            num2 = valueOf2;
        }
        valueOf = 7;
        if (!query.isNull(valueOf)) {
            if (Long.compare(long8, i) == 0) {
                i3 = i13;
            }
            bool = valueOf;
        } else {
            bool = i14;
        }
        long2 = 8;
        if (query.isNull(long2)) {
            i5 = i9;
        } else {
            i5 = long2;
        }
        Cursor cursor = query;
        super(string, string2, query.getLong(i3), strArr3, query.getLong(i13), i11, i5, i3, query.getLong(i6), obj12, long, obj14, valueOf3, num, num2, bool);
        if (cursor.moveToNext()) {
            obj2.a.b().r().b("Got multiple records for event aggregates, expected one. appId", q3.z(string));
        }
        if (cursor != null) {
            cursor.close();
        }
        return qVar;
    }

    @Override // com.google.android.gms.measurement.internal.r9
    public final com.google.android.gms.measurement.internal.ga Z(String string, String string2) {
        com.google.android.gms.measurement.internal.b5 b5Var;
        boolean moveToNext;
        String str2;
        String str;
        Object obj;
        Object string3;
        com.google.android.gms.measurement.internal.b5 b5Var2;
        Object obj4;
        Object obj5;
        final Object obj2 = this;
        r.f(string);
        r.f(string2);
        h();
        i();
        final int i4 = 0;
        int i = 2;
        final String[] strArr2 = new String[i];
        int i2 = 0;
        strArr2[i2] = string;
        int i3 = 1;
        strArr2[i3] = string2;
        Cursor query = R().query("user_attributes", /* result */, "app_id=? and name=?", strArr2, 0, 0, 0);
        if (!query.moveToFirst() && query != null) {
            if (query != null) {
                query.close();
            }
            return i4;
        }
        final Object obj3 = obj2.a0(query, i3);
        if (obj3 == null && query != null) {
            if (query != null) {
                query.close();
            }
            return i4;
        }
        super(string, query.getString(i), string2, query.getLong(i2), obj7, obj3);
        if (query.moveToNext()) {
            obj2.a.b().r().b("Got multiple records for user property, expected one. appId", q3.z(string));
        }
        if (query != null) {
            query.close();
        }
        return gaVar;
    }

    @Override // com.google.android.gms.measurement.internal.r9
    final Object a0(Cursor cursor, int i2) {
        int type = cursor.getType(i2);
        final int i = 0;
        if (type != null && type != 1 && type != 2 && type != 3 && type != 4) {
            if (type != 1) {
                if (type != 2) {
                    if (type != 3) {
                        if (type != 4) {
                            this.a.b().r().b("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
                            return i;
                        }
                        this.a.b().r().a("Loaded invalid blob type value, ignoring it");
                        return i;
                    }
                    return cursor.getString(i2);
                }
                return Double.valueOf(cursor.getDouble(i2));
            }
            return Long.valueOf(cursor.getLong(i2));
        }
        this.a.b().r().a("Loaded invalid null value from database");
        return i;
    }

    @Override // com.google.android.gms.measurement.internal.r9
    public final String b0() {
        Throwable th4;
        Throwable th;
        com.google.android.gms.measurement.internal.b5 b5Var;
        String str;
        Throwable th2;
        int i = 0;
        Cursor rawQuery = R().rawQuery("select app_id from queue order by has_realtime desc, rowid asc limit 1;", i);
        if (rawQuery.moveToFirst() && rawQuery != null) {
            if (rawQuery != null) {
                rawQuery.close();
            }
            return rawQuery.getString(0);
        }
        if (rawQuery != null) {
            try {
                rawQuery.close();
                return i;
                Throwable th3 = th4;
                b5Var = this.a;
                b5Var = b5Var.b();
                b5Var = b5Var.r();
                b5Var.b("Database error getting next bundle app id", th3);
            } catch (android.database.sqlite.SQLiteException sQLite) {
            } catch (Throwable th1) {
            }
            if (th4 == null) {
            } else {
                th4.close();
            }
            throw th3;
        }
    }

    public final List<com.google.android.gms.measurement.internal.c> c0(String string, String string2, String string3) {
        Object obj4;
        Object obj5;
        r.f(string);
        h();
        i();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(string);
        StringBuilder obj3 = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(string2)) {
            arrayList.add(string2);
            obj3.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(string3)) {
            arrayList.add(String.valueOf(string3).concat("*"));
            obj3.append(" and name glob ?");
        }
        return d0(obj3.toString(), (String[])arrayList.toArray(new String[arrayList.size()]));
    }

    public final List<com.google.android.gms.measurement.internal.c> d0(String string, String[] string2Arr2) {
        com.google.android.gms.measurement.internal.b5 b5Var;
        boolean moveToFirst;
        String str5;
        String valueOf;
        String[] strArr;
        String string5;
        String[] long3;
        int i;
        String str4;
        String str3;
        String string3;
        String string4;
        String eaVar;
        String long4;
        String str;
        String string2;
        String str2;
        String long2;
        String str6;
        String long;
        android.os.Parcelable parcelable;
        final Object obj = this;
        h();
        i();
        ArrayList arrayList = new ArrayList();
        int i17 = 0;
        final String str8 = "trigger_event_name";
        final String str9 = "triggered_timestamp";
        obj.a.z();
        final int i16 = 0;
        Cursor query = R().query("conditional_properties", /* result */, string, string2Arr2, i16, 0, "rowid", "1001");
        if (query.moveToFirst()) {
        }
        if (query != null) {
            query.close();
        }
        return arrayList;
    }

    public final List<com.google.android.gms.measurement.internal.ga> e0(String string) {
        com.google.android.gms.measurement.internal.b5 b5Var;
        boolean moveToFirst;
        String string2;
        Object gaVar;
        String str4;
        String str;
        String[] strArr;
        String str3;
        String[] strArr2;
        int long;
        String str2;
        r.f(string);
        h();
        i();
        ArrayList arrayList = new ArrayList();
        int i4 = 0;
        final int i5 = 1;
        strArr2 = new String[i5];
        final int i6 = 0;
        strArr2[i6] = string;
        this.a.z();
        final int i3 = 0;
        Cursor query = R().query("user_attributes", /* result */, "app_id=?", strArr2, 0, i3, "rowid", "1000");
        if (query.moveToFirst()) {
        }
        if (query != null) {
            query.close();
        }
        return arrayList;
    }

    public final List<com.google.android.gms.measurement.internal.ga> f0(String string, String string2, String string3) {
        com.google.android.gms.measurement.internal.b5 b5Var;
        boolean moveToFirst;
        Object gaVar;
        String str4;
        String valueOf;
        Object obj;
        String empty2;
        boolean empty;
        String[] str7;
        String str6;
        String str2;
        Object[] string5;
        int long;
        String str5;
        String str;
        String str3;
        java.lang.CharSequence charSequence;
        java.lang.CharSequence string4;
        final Object obj2 = this;
        r.f(string);
        h();
        i();
        ArrayList arrayList = new ArrayList();
        int i7 = 0;
        final int i8 = 3;
        ArrayList arrayList2 = new ArrayList(i8);
        arrayList2.add(string);
        StringBuilder stringBuilder = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(string2)) {
            arrayList2.add(string2);
            stringBuilder.append(" and origin=?");
        } else {
            string4 = string2;
        }
        if (!TextUtils.isEmpty(string3)) {
            arrayList2.add(String.valueOf(string3).concat("*"));
            stringBuilder.append(" and name glob ?");
        }
        obj2.a.z();
        int i6 = i9;
        Cursor query = R().query("user_attributes", /* result */, stringBuilder.toString(), (String[])arrayList2.toArray(new String[arrayList2.size()]), 0, i6, "rowid", "1001");
        if (!query.moveToFirst() && query != null) {
            if (query != null) {
                query.close();
            }
            return arrayList;
        }
        obj2.a.z();
        int i4 = 1000;
        while (arrayList.size() >= i4) {
            str5 = obj2.a0(query, 2);
            string4 = query.getString(i8);
            if (str5 == null) {
            } else {
            }
            str = string3;
            super(string, string4, query.getString(0), query.getLong(1), i6, str5);
            arrayList.add(gaVar);
            if (query.moveToNext()) {
                break;
            }
            obj2.a.z();
            i4 = 1000;
            obj2.a.b().r().d("(2)Read invalid user property value, ignoring it", q3.z(string), string4, string3);
        }
        obj2.a.z();
        obj2.a.b().r().b("Read more than the max allowed user properties, ignoring excess", Integer.valueOf(i4));
        if (query != null) {
            query.close();
        }
        return arrayList;
    }

    @Override // com.google.android.gms.measurement.internal.r9
    public final void g0() {
        i();
        R().beginTransaction();
    }

    public final void h0(List<Long> list) {
        int valueOf;
        int i;
        int size;
        long longValue;
        int size2;
        int str;
        Object obj5;
        r.j(list);
        h();
        i();
        StringBuilder stringBuilder = new StringBuilder("rowid in (");
        i = 0;
        while (i < list.size()) {
            if (i != 0) {
            }
            stringBuilder.append((Long)list.get(i).longValue());
            i++;
            stringBuilder.append(",");
        }
        stringBuilder.append(")");
        valueOf = R().delete("raw_events", stringBuilder.toString(), 0);
        if (valueOf != list.size()) {
            this.a.b().r().c("Deleted fewer rows from raw events table than expected", Integer.valueOf(valueOf), Integer.valueOf(list.size()));
        }
    }

    @Override // com.google.android.gms.measurement.internal.r9
    public final void i0() {
        i();
        R().endTransaction();
    }

    final void j0(List<Long> list) {
        int cmp;
        int str;
        h();
        i();
        r.j(list);
        r.l(list.size());
        if (!w()) {
        }
        String obj6 = TextUtils.join(",", list);
        StringBuilder stringBuilder = new StringBuilder(length += 2);
        stringBuilder.append("(");
        stringBuilder.append(obj6);
        obj6 = ")";
        stringBuilder.append(obj6);
        String string = stringBuilder.toString();
        StringBuilder stringBuilder2 = new StringBuilder(length2 += 80);
        stringBuilder2.append("SELECT COUNT(1) FROM queue WHERE rowid IN ");
        stringBuilder2.append(string);
        stringBuilder2.append(" AND retry_count =  2147483647 LIMIT 1");
        if (Long.compare(l, i5) > 0) {
            this.a.b().w().a("The number of upload retries exceeds the limit. Will remain unchanged.");
        }
        StringBuilder stringBuilder3 = new StringBuilder(length3 += 127);
        stringBuilder3.append("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN ");
        stringBuilder3.append(string);
        stringBuilder3.append(" AND (retry_count IS NULL OR retry_count < ");
        stringBuilder3.append(Integer.MAX_VALUE);
        stringBuilder3.append(obj6);
        R().execSQL(stringBuilder3.toString());
    }

    @Override // com.google.android.gms.measurement.internal.r9
    protected final boolean l() {
        return 0;
    }

    @Override // com.google.android.gms.measurement.internal.r9
    final void m() {
        boolean valueOf;
        long strArr;
        long str2;
        String str;
        long longValue;
        int i;
        h();
        i();
        str2 = this.a.c().a();
        this.a.z();
        longValue = (Long)c3.y.a(0).longValue();
        if (w() && Long.compare(l2, longValue) > 0) {
            str2 = this.a.c().a();
            this.a.z();
            longValue = (Long)c3.y.a(0).longValue();
            if (Long.compare(l2, longValue) > 0) {
                x8Var2.g.b(str2);
                h();
                i();
                if (!w()) {
                } else {
                    strArr = new String[2];
                    this.a.z();
                    valueOf = R().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", String.valueOf(this.a.c().currentTimeMillis()), String.valueOf(g.i()));
                    if (valueOf > 0) {
                        this.a.b().v().b("Deleted stale rows. rowsDeleted", Integer.valueOf(valueOf));
                    }
                }
            }
        }
    }

    @Override // com.google.android.gms.measurement.internal.r9
    public final void n(String string, String string2) {
        r.f(string);
        r.f(string2);
        h();
        i();
        String[] strArr = new String[2];
        R().delete("user_attributes", "app_id=? and name=?", string, string2);
    }

    final void o(String string, List<j3> list2) {
        String iterator2;
        String[] arrayList;
        int valueOf2;
        com.google.android.gms.measurement.internal.o3 o3Var;
        int i4;
        int i;
        Object str7;
        String string2;
        Object valueOf7;
        SQLiteDatabase sQLiteDatabase;
        int valueOf4;
        int cmp;
        String str5;
        Iterator iterator;
        String arrayList2;
        Object contentValues;
        String[] strArr;
        String next;
        int strArr2;
        String str6;
        Object obj2;
        int valueOf3;
        long stringBuilder;
        int i6;
        String[] valueOf5;
        int valueOf8;
        int valueOf;
        Object obj;
        int i2;
        int valueOf6;
        int withOnConflict;
        t8 valueOf11;
        boolean valueOf12;
        Integer valueOf10;
        int str2;
        t8 str;
        int valueOf9;
        t8 t8Var;
        String str8;
        String str4;
        int i5;
        int i3;
        Iterator it;
        String str3;
        i4 = this;
        string2 = string;
        valueOf7 = list2;
        str5 = "app_id=? and audience_id=?";
        iterator2 = "app_id=?";
        next = "event_filters";
        str6 = "property_filters";
        r.j(list2);
        i6 = 0;
        while (i6 < list2.size()) {
            obj = (j3)valueOf7.get(i6).q();
            if ((i3)obj.s() != 0) {
            } else {
            }
            str8 = str5;
            valueOf11 = obj;
            if (valueOf11.t() != 0) {
            }
            i6++;
            i4 = this;
            str5 = str8;
            i = 0;
            while (i < valueOf11.t()) {
                str5 = valueOf11.x(i);
                obj2 = o7.b(str5.A(), b6.a, b6.b);
                if (obj2 != null) {
                }
                i++;
                t8 t8Var2 = str5.q();
                (s3)t8Var2.s(obj2);
                valueOf11.v(i, t8Var2);
                valueOf7.set(i6, (j3)obj.l());
                valueOf11 = obj;
            }
            str5 = valueOf11.x(i);
            obj2 = o7.b(str5.A(), b6.a, b6.b);
            if (obj2 != null) {
            }
            i++;
            t8Var2 = str5.q();
            (s3)t8Var2.s(obj2);
            valueOf11.v(i, t8Var2);
            valueOf7.set(i6, (j3)obj.l());
            valueOf11 = obj;
            valueOf11 = obj;
            withOnConflict = 0;
            while (withOnConflict < valueOf11.s()) {
                str2 = valueOf11.w(withOnConflict).q();
                str = (k3)str2.o();
                String str23 = z5.b(str2.w());
                if (str23 != null) {
                } else {
                }
                valueOf9 = 0;
                obj2 = 0;
                while (obj2 < str2.s()) {
                    valueOf6 = str2.v(obj2);
                    str7 = o7.b(valueOf6.A(), a6.a, a6.b);
                    if (str7 != null) {
                    }
                    obj2++;
                    i4 = this;
                    str2 = t8Var;
                    str5 = str8;
                    strArr = valueOf6.q();
                    (m3)strArr.s(str7);
                    (k3)str.u(obj2, (n3)strArr.l());
                    valueOf9 = 1;
                }
                if (valueOf9 != 0) {
                }
                withOnConflict++;
                i4 = this;
                str5 = str8;
                valueOf11.u(withOnConflict, str);
                valueOf7.set(i6, (j3)obj.l());
                valueOf11 = obj;
                valueOf6 = str2.v(obj2);
                str7 = o7.b(valueOf6.A(), a6.a, a6.b);
                if (str7 != null) {
                }
                obj2++;
                i4 = this;
                str2 = t8Var;
                str5 = str8;
                strArr = valueOf6.q();
                (m3)strArr.s(str7);
                str.u(obj2, (n3)strArr.l());
                valueOf9 = 1;
                str.t(str23);
                valueOf9 = 1;
            }
            str8 = str5;
            str2 = valueOf11.w(withOnConflict).q();
            str = (k3)str2.o();
            str23 = z5.b(str2.w());
            if (str23 != null) {
            } else {
            }
            valueOf9 = 0;
            obj2 = 0;
            while (obj2 < str2.s()) {
                valueOf6 = str2.v(obj2);
                str7 = o7.b(valueOf6.A(), a6.a, a6.b);
                if (str7 != null) {
                }
                obj2++;
                i4 = this;
                str2 = t8Var;
                str5 = str8;
                strArr = valueOf6.q();
                (m3)strArr.s(str7);
                (k3)str.u(obj2, (n3)strArr.l());
                valueOf9 = 1;
            }
            if (valueOf9 != 0) {
            }
            withOnConflict++;
            i4 = this;
            str5 = str8;
            valueOf11.u(withOnConflict, str);
            valueOf7.set(i6, (j3)obj.l());
            valueOf11 = obj;
            valueOf6 = str2.v(obj2);
            str7 = o7.b(valueOf6.A(), a6.a, a6.b);
            if (str7 != null) {
            }
            obj2++;
            i4 = this;
            str2 = t8Var;
            str5 = str8;
            strArr = valueOf6.q();
            (m3)strArr.s(str7);
            str.u(obj2, (n3)strArr.l());
            valueOf9 = 1;
            str.t(str23);
            valueOf9 = 1;
        }
        str4 = str5;
        i();
        h();
        r.f(string);
        r.j(list2);
        SQLiteDatabase sQLiteDatabase3 = R();
        sQLiteDatabase3.beginTransaction();
        i();
        h();
        r.f(string);
        SQLiteDatabase sQLiteDatabase5 = R();
        valueOf3 = 1;
        String[] strArr6 = new String[valueOf3];
        i2 = 0;
        strArr6[i2] = string2;
        sQLiteDatabase5.delete(str6, iterator2, strArr6);
        valueOf5 = new String[valueOf3];
        valueOf5[i2] = string2;
        sQLiteDatabase5.delete(next, iterator2, valueOf5);
        iterator = list2.iterator();
        while (iterator.hasNext()) {
            Object next3 = iterator.next();
            i();
            h();
            r.f(string);
            r.j((j3)next3);
            if (!next3.G()) {
            } else {
            }
            i2 = this;
            valueOf6 = next3.w();
            withOnConflict = next3.C().iterator();
            for (l3 next7 : withOnConflict) {
            }
            withOnConflict = next3.D().iterator();
            for (t3 next8 : withOnConflict) {
            }
            withOnConflict = next3.C().iterator();
            valueOf3 = "data";
            str2 = "session_scoped";
            str = "filter_id";
            valueOf5 = "audience_id";
            valueOf9 = "app_id";
            for (l3 valueOf12 : withOnConflict) {
                i();
                h();
                r.f(string);
                r.j(valueOf12);
                contentValues = new ContentValues();
                contentValues.put(valueOf9, string2);
                contentValues.put(valueOf5, Integer.valueOf(valueOf6));
                if (valueOf12.K()) {
                } else {
                }
                valueOf8 = 0;
                contentValues.put(str, valueOf8);
                contentValues.put("event_name", valueOf12.C());
                if (valueOf12.L()) {
                } else {
                }
                valueOf = 0;
                contentValues.put(str2, valueOf);
                contentValues.put(valueOf3, valueOf12.j());
                if (Long.compare(withOnConflict2, valueOf3) == 0) {
                }
                valueOf7 = list2;
                iterator = it;
                valueOf3 = "data";
                str2 = "session_scoped";
                str = "filter_id";
                valueOf5 = "audience_id";
                valueOf9 = "app_id";
                i2.a.b().r().b("Failed to insert event filter (got -1). appId", q3.z(string));
                valueOf = Boolean.valueOf(valueOf12.I());
                valueOf8 = Integer.valueOf(valueOf12.x());
            }
            iterator2 = next3.D().iterator();
            for (t3 next5 : iterator2) {
                i();
                h();
                r.f(string);
                r.j(next5);
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put(valueOf9, string2);
                contentValues2.put(valueOf5, Integer.valueOf(valueOf6));
                if (next5.F()) {
                } else {
                }
                valueOf10 = 0;
                contentValues2.put(str, valueOf10);
                contentValues2.put("property_name", next5.A());
                if (next5.G()) {
                } else {
                }
                valueOf2 = 0;
                contentValues2.put(str2, valueOf2);
                contentValues2.put(valueOf3, next5.j());
                iterator2 = str3;
                valueOf2 = Boolean.valueOf(next5.E());
                valueOf10 = Integer.valueOf(next5.w());
            }
            valueOf7 = list2;
            iterator = it;
            Object next5 = iterator2.next();
            i();
            h();
            r.f(string);
            r.j((t3)next5);
            if (TextUtils.isEmpty(next5.A())) {
            } else {
            }
            contentValues2 = new ContentValues();
            contentValues2.put(valueOf9, string2);
            contentValues2.put(valueOf5, Integer.valueOf(valueOf6));
            if (next5.F()) {
            } else {
            }
            valueOf10 = 0;
            contentValues2.put(str, valueOf10);
            contentValues2.put("property_name", next5.A());
            if (next5.G()) {
            } else {
            }
            valueOf2 = 0;
            contentValues2.put(str2, valueOf2);
            contentValues2.put(valueOf3, next5.j());
            if (Long.compare(withOnConflict, i5) == 0) {
            } else {
            }
            iterator2 = str3;
            i2.a.b().r().b("Failed to insert property filter (got -1). appId", q3.z(string));
            i();
            h();
            r.f(string);
            iterator2 = R();
            String[] strArr4 = new String[2];
            String str13 = str4;
            iterator2.delete(str6, str13, string2, String.valueOf(valueOf6));
            String[] strArr5 = new String[2];
            iterator2.delete(next, str13, string2, String.valueOf(valueOf6));
            str4 = str13;
            iterator = it;
            valueOf7 = list2;
            valueOf2 = Boolean.valueOf(next5.E());
            valueOf10 = Integer.valueOf(next5.w());
            if (next5.F()) {
            } else {
            }
            valueOf4 = 0;
            i2.a.b().w().d("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", q3.z(string), Integer.valueOf(valueOf6), String.valueOf(valueOf4));
            valueOf4 = Integer.valueOf(next5.w());
            valueOf12 = withOnConflict.next();
            i();
            h();
            r.f(string);
            r.j((l3)valueOf12);
            if (TextUtils.isEmpty(valueOf12.C())) {
            } else {
            }
            contentValues = new ContentValues();
            contentValues.put(valueOf9, string2);
            contentValues.put(valueOf5, Integer.valueOf(valueOf6));
            if (valueOf12.K()) {
            } else {
            }
            valueOf8 = 0;
            contentValues.put(str, valueOf8);
            contentValues.put("event_name", valueOf12.C());
            if (valueOf12.L()) {
            } else {
            }
            valueOf = 0;
            contentValues.put(str2, valueOf);
            contentValues.put(valueOf3, valueOf12.j());
            if (Long.compare(withOnConflict2, valueOf3) == 0) {
            }
            valueOf7 = list2;
            iterator = it;
            i2.a.b().r().b("Failed to insert event filter (got -1). appId", q3.z(string));
            valueOf = Boolean.valueOf(valueOf12.I());
            valueOf8 = Integer.valueOf(valueOf12.x());
            if (valueOf12.K()) {
            } else {
            }
            i3 = 0;
            i2.a.b().w().d("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", q3.z(string), Integer.valueOf(valueOf6), String.valueOf(i3));
            it = iterator;
            i3 = valueOf12;
            if (!(t3)withOnConflict.next().F()) {
            } else {
            }
            i2.a.b().w().c("Property filter with no ID. Audience definition ignored. appId, audienceId", q3.z(string), Integer.valueOf(valueOf6));
            if (!(l3)withOnConflict.next().K()) {
            } else {
            }
            i2.a.b().w().c("Event filter with no ID. Audience definition ignored. appId, audienceId", q3.z(string), Integer.valueOf(valueOf6));
            i2.a.b().w().b("Audience with no ID. appId", q3.z(string));
            com.google.android.gms.measurement.internal.b5 b5Var7 = obj.a;
            b5Var7 = b5Var7.b();
            b5Var7 = b5Var7.r();
            String str14 = "Error storing event filter. appId";
            obj2 = q3.z(string);
            b5Var7.c(str14, obj2, th);
            b5Var7 = obj.a;
            b5Var7 = b5Var7.b();
            b5Var7 = b5Var7.r();
            str14 = "Error storing property filter. appId";
            obj2 = q3.z(string);
            b5Var7.c(str14, obj2, th);
        }
        int i28 = this;
        arrayList = new ArrayList();
        Iterator iterator3 = list2.iterator();
        while (iterator3.hasNext()) {
            next = iterator3.next();
            if ((j3)next.G() != null) {
            } else {
            }
            valueOf5 = i7;
            arrayList.add(valueOf5);
            valueOf5 = Integer.valueOf(next.w());
        }
        r.f(string);
        i();
        h();
        strArr2 = new String[1];
        int i21 = Math.max(0, Math.min(2000, i28.a.z().o(string2, c3.F)));
        if (Long.compare(l, stringBuilder) <= 0) {
        } else {
            arrayList2 = new ArrayList();
            strArr2 = 0;
            while (strArr2 < arrayList.size()) {
                stringBuilder = arrayList.get(strArr2);
                if ((Integer)stringBuilder != null) {
                    break;
                }
                arrayList2.add(Integer.toString((Integer)stringBuilder.intValue()));
                strArr2++;
            }
            String join = TextUtils.join(",", arrayList2);
            StringBuilder stringBuilder2 = new StringBuilder(length += i15);
            stringBuilder2.append("(");
            stringBuilder2.append(join);
            stringBuilder2.append(")");
            String string3 = stringBuilder2.toString();
            stringBuilder = new StringBuilder(length2 += 140);
            stringBuilder.append("audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ");
            stringBuilder.append(string3);
            stringBuilder.append(" order by rowid desc limit -1 offset ?)");
            arrayList = new String[2];
            R().delete("audience_filter_values", stringBuilder.toString(), string2, Integer.toString(i21));
        }
        sQLiteDatabase3.setTransactionSuccessful();
        sQLiteDatabase3.endTransaction();
    }

    @Override // com.google.android.gms.measurement.internal.r9
    public final void p() {
        i();
        R().setTransactionSuccessful();
    }

    @Override // com.google.android.gms.measurement.internal.r9
    public final void q(com.google.android.gms.measurement.internal.g5 g5) {
        String str2;
        ContentValues withOnConflict;
        Object join;
        boolean str4;
        int cmp;
        String str;
        String str3;
        Object obj8;
        str2 = "apps";
        r.j(g5);
        h();
        i();
        final String str6 = g5.e0();
        r.j(str6);
        withOnConflict = new ContentValues();
        withOnConflict.put("app_id", str6);
        withOnConflict.put("app_instance_id", g5.f0());
        withOnConflict.put("gmp_app_id", g5.k0());
        String str19 = "resettable_device_id_hash";
        withOnConflict.put(str19, g5.b());
        String str20 = "last_bundle_index";
        withOnConflict.put(str20, Long.valueOf(g5.Z()));
        String str21 = "last_bundle_start_timestamp";
        withOnConflict.put(str21, Long.valueOf(g5.a0()));
        withOnConflict.put("last_bundle_end_timestamp", Long.valueOf(g5.Y()));
        withOnConflict.put("app_version", g5.h0());
        String str24 = "app_store";
        withOnConflict.put(str24, g5.g0());
        String str25 = "gmp_version";
        withOnConflict.put(str25, Long.valueOf(g5.X()));
        withOnConflict.put("dev_cert_hash", Long.valueOf(g5.U()));
        String str27 = "measurement_enabled";
        withOnConflict.put(str27, Boolean.valueOf(g5.K()));
        String str28 = "day";
        withOnConflict.put(str28, Long.valueOf(g5.T()));
        String str29 = "daily_public_events_count";
        withOnConflict.put(str29, Long.valueOf(g5.R()));
        String str30 = "daily_events_count";
        withOnConflict.put(str30, Long.valueOf(g5.Q()));
        String str31 = "daily_conversions_count";
        withOnConflict.put(str31, Long.valueOf(g5.O()));
        String str32 = "config_fetched_time";
        withOnConflict.put(str32, Long.valueOf(g5.N()));
        String str33 = "failed_config_fetch_time";
        withOnConflict.put(str33, Long.valueOf(g5.W()));
        withOnConflict.put("app_version_int", Long.valueOf(g5.M()));
        String str35 = "firebase_instance_id";
        withOnConflict.put(str35, g5.i0());
        String str36 = "daily_error_events_count";
        withOnConflict.put(str36, Long.valueOf(g5.P()));
        withOnConflict.put("daily_realtime_events_count", Long.valueOf(g5.S()));
        String str38 = "health_monitor_sample";
        withOnConflict.put(str38, g5.a());
        withOnConflict.put("android_id", Long.valueOf(g5.A()));
        withOnConflict.put("adid_reporting_enabled", Boolean.valueOf(g5.J()));
        String str41 = "admob_app_id";
        withOnConflict.put(str41, g5.c0());
        withOnConflict.put("dynamite_version", Long.valueOf(g5.V()));
        join = g5.c();
        if (join != null) {
            if (join.size() == 0) {
                this.a.b().w().b("Safelisted events should not be an empty list. appId", str6);
            } else {
                withOnConflict.put("safelisted_events", TextUtils.join(",", join));
            }
        }
        kd.b();
        if (this.a.z().B(str6, c3.d0)) {
            withOnConflict.put("ga_app_id", g5.j0());
        }
        obj8 = R();
        String[] strArr = new String[1];
        if (Long.compare(l17, i4) == 0 && Long.compare(withOnConflict, str3) == 0) {
            if (Long.compare(withOnConflict, str3) == 0) {
                this.a.b().r().b("Failed to insert/update app (got -1). appId", q3.z(str6));
            }
        }
    }

    @Override // com.google.android.gms.measurement.internal.r9
    public final void r(com.google.android.gms.measurement.internal.q q) {
        int cmp;
        Boolean booleanValue;
        int valueOf;
        Object str;
        int i;
        int i2;
        r.j(q);
        h();
        i();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", q.a);
        String str6 = "name";
        contentValues.put(str6, q.b);
        String str7 = "lifetime_count";
        contentValues.put(str7, Long.valueOf(q.c));
        String str8 = "current_bundle_count";
        contentValues.put(str8, Long.valueOf(q.d));
        String str9 = "last_fire_timestamp";
        contentValues.put(str9, Long.valueOf(q.f));
        contentValues.put("last_bundled_timestamp", Long.valueOf(q.g));
        contentValues.put("last_bundled_day", q.h);
        contentValues.put("last_sampled_complex_event_id", q.i);
        String str13 = "last_sampling_rate";
        contentValues.put(str13, q.j);
        contentValues.put("current_session_count", Long.valueOf(q.e));
        booleanValue = q.k;
        int i3 = 0;
        if (booleanValue != null && booleanValue.booleanValue()) {
            if (booleanValue.booleanValue()) {
                valueOf = Long.valueOf(1);
            } else {
                valueOf = i3;
            }
        } else {
        }
        contentValues.put("last_exempt_from_sampling", valueOf);
        if (Long.compare(withOnConflict, i) == 0) {
            this.a.b().r().b("Failed to insert/update event aggregates (got -1). appId", q3.z(q.a));
        }
    }

    @Override // com.google.android.gms.measurement.internal.r9
    public final void s(String string, byte[] b2Arr2, String string3) {
        int i;
        int obj5;
        String[] obj6;
        r.f(string);
        h();
        i();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", b2Arr2);
        contentValues.put("config_last_modified_time", string3);
        obj6 = new String[1];
        if (Long.compare(obj5, i) == 0) {
            this.a.b().r().b("Failed to update remote config (got 0). appId", q3.z(string));
        }
    }

    @Override // com.google.android.gms.measurement.internal.r9
    public final boolean t() {
        if (Long.compare(l, i4) != 0) {
            return 1;
        }
        return 0;
    }

    @Override // com.google.android.gms.measurement.internal.r9
    public final boolean u() {
        if (Long.compare(l, i4) != 0) {
            return 1;
        }
        return 0;
    }

    @Override // com.google.android.gms.measurement.internal.r9
    public final boolean v() {
        if (Long.compare(l, i4) != 0) {
            return 1;
        }
        return 0;
    }

    @Override // com.google.android.gms.measurement.internal.r9
    protected final boolean w() {
        this.a.z();
        return this.a.f().getDatabasePath("google_app_measurement.db").exists();
    }

    @Override // com.google.android.gms.measurement.internal.r9
    public final boolean x(String string, Long long2, long l3, p4 p44) {
        h();
        i();
        r.j(obj9);
        r.f(string);
        r.j(long2);
        byte[] obj9 = obj9.j();
        this.a.b().v().c("Saving complex main event, appId, data size", this.a.D().d(string), Integer.valueOf(obj9.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", string);
        contentValues.put("event_id", long2);
        contentValues.put("children_to_process", Long.valueOf(l3));
        contentValues.put("main_event", obj9);
        if (Long.compare(obj7, i) == 0) {
            this.a.b().r().b("Failed to insert complex main event (got -1). appId", q3.z(string));
            return 0;
        }
        return 1;
    }

    @Override // com.google.android.gms.measurement.internal.r9
    public final boolean y(com.google.android.gms.measurement.internal.c c) {
        String str2;
        com.google.android.gms.measurement.internal.ga cmp;
        Object contentValues;
        int str;
        long withOnConflict;
        long l;
        int i;
        int obj9;
        r.j(c);
        h();
        i();
        str2 = c.a;
        r.j(str2);
        final int i2 = 1;
        String[] strArr = new String[i2];
        str = 0;
        strArr[str] = str2;
        this.a.z();
        if (Z(str2, eaVar.b) == null && Long.compare(l, i) < 0) {
            strArr = new String[i2];
            str = 0;
            strArr[str] = str2;
            this.a.z();
            if (Long.compare(l, i) < 0) {
            }
            return str;
        }
        contentValues = new ContentValues();
        contentValues.put("app_id", str2);
        contentValues.put("origin", c.b);
        contentValues.put("name", eaVar2.b);
        Object obj = c.c.j2();
        r.j(obj);
        k.J(contentValues, "value", obj);
        contentValues.put("active", Boolean.valueOf(c.w));
        String str16 = "trigger_event_name";
        contentValues.put(str16, c.x);
        contentValues.put("trigger_timeout", Long.valueOf(c.z));
        String str18 = "timed_out_event";
        contentValues.put(str18, this.a.N().c0(c.y));
        contentValues.put("creation_timestamp", Long.valueOf(c.v));
        String str20 = "triggered_event";
        contentValues.put(str20, this.a.N().c0(c.A));
        String str21 = "triggered_timestamp";
        contentValues.put(str21, Long.valueOf(eaVar4.c));
        contentValues.put("time_to_live", Long.valueOf(c.B));
        contentValues.put("expired_event", this.a.N().c0(c.C));
        if (Long.compare(withOnConflict, i5) == 0) {
            this.a.b().r().b("Failed to insert/update conditional user property (got -1)", q3.z(str2));
        }
        return i2;
    }

    @Override // com.google.android.gms.measurement.internal.r9
    public final boolean z(com.google.android.gms.measurement.internal.ga ga) {
        com.google.android.gms.measurement.internal.ga equals;
        int cmp;
        int b5Var;
        long withOnConflict;
        long str;
        Object str2;
        long i;
        com.google.android.gms.measurement.internal.b3 b3Var;
        int i2;
        int i3;
        Object obj10;
        r.j(ga);
        h();
        i();
        int i6 = 1;
        b5Var = 0;
        String[] strArr = new String[i6];
        strArr[b5Var] = ga.a;
        if (Z(ga.a, ga.c) == null && ia.W(ga.c) && Long.compare(str, i) < 0) {
            b5Var = 0;
            if (ia.W(ga.c)) {
                strArr = new String[i6];
                strArr[b5Var] = ga.a;
                if (Long.compare(str, i) < 0) {
                }
                return b5Var;
            }
            String[] strArr2 = new String[2];
            strArr2[b5Var] = ga.a;
            strArr2[i6] = ga.b;
            this.a.z();
            if (!"_npa".equals(ga.c) && Long.compare(str, i) >= 0) {
                strArr2 = new String[2];
                strArr2[b5Var] = ga.a;
                strArr2[i6] = ga.b;
                this.a.z();
                if (Long.compare(str, i) >= 0) {
                    return b5Var;
                }
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", ga.a);
        contentValues.put("origin", ga.b);
        String str17 = "name";
        contentValues.put(str17, ga.c);
        contentValues.put("set_timestamp", Long.valueOf(ga.d));
        k.J(contentValues, "value", ga.e);
        if (Long.compare(withOnConflict, i8) == 0) {
            this.a.b().r().b("Failed to insert/update user property (got -1). appId", q3.z(ga.a));
        }
        return i6;
    }
}
