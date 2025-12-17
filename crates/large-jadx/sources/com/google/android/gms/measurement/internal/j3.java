package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import com.google.android.gms.common.internal.safeparcel.a;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class j3 extends com.google.android.gms.measurement.internal.f4 {

    private final com.google.android.gms.measurement.internal.i3 c;
    private boolean d;
    j3(com.google.android.gms.measurement.internal.b5 b5) {
        super(b5);
        this.a.z();
        i3 obj3 = new i3(this, this.a.f(), "google_app_measurement_local.db");
        this.c = obj3;
    }

    private final boolean x(int i, byte[] b2Arr2) {
        com.google.android.gms.measurement.internal.b5 b5Var;
        String moveToFirst;
        int cmp;
        boolean z;
        int valueOf2;
        String str2;
        int str;
        int i4;
        int i3;
        int i2;
        int valueOf3;
        long l;
        long l2;
        long l3;
        int valueOf;
        int i5;
        final Object obj = this;
        h();
        valueOf2 = 0;
        if (obj.d) {
            return valueOf2;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("type", Integer.valueOf(i));
        contentValues.put("entry", b2Arr2);
        obj.a.z();
        i4 = valueOf2;
        i2 = str;
        valueOf3 = 1;
        int i9 = 0;
        SQLiteDatabase sQLiteDatabase = o();
        if (i4 < str && sQLiteDatabase == null) {
            valueOf3 = 1;
            i9 = 0;
            sQLiteDatabase = o();
            if (sQLiteDatabase == null) {
                obj.d = valueOf3;
                return valueOf2;
            }
            sQLiteDatabase.beginTransaction();
            Cursor rawQuery = sQLiteDatabase.rawQuery("select count(1) from messages", i9);
            valueOf = 0;
            if (rawQuery != null && rawQuery.moveToFirst()) {
                if (rawQuery.moveToFirst()) {
                    valueOf = rawQuery.getLong(valueOf2);
                }
            }
            i5 = 100000;
            final String str7 = "messages";
            obj.a.b().r().a("Data loss, local db full");
            i11 += i10;
            String[] strArr = new String[valueOf3];
            strArr[valueOf2] = Long.toString(i5);
            valueOf = (long)delete;
            if (Long.compare(valueOf, i5) >= 0 && Long.compare(valueOf, i5) != 0) {
                obj.a.b().r().a("Data loss, local db full");
                i11 += i10;
                strArr = new String[valueOf3];
                strArr[valueOf2] = Long.toString(i5);
                valueOf = (long)delete;
                if (Long.compare(valueOf, i5) != 0) {
                    obj.a.b().r().d("Different delete count than expected in local db. expected, received, difference", Long.valueOf(i5), Long.valueOf(valueOf), Long.valueOf(i5 -= valueOf));
                }
            }
            sQLiteDatabase.insertOrThrow(str7, i9, contentValues);
            sQLiteDatabase.setTransactionSuccessful();
            sQLiteDatabase.endTransaction();
            if (rawQuery != null) {
                rawQuery.close();
            }
            sQLiteDatabase.close();
            return 1;
        }
        obj.a.b().v().a("Failed to write entry to local database");
        return 0;
    }

    @Override // com.google.android.gms.measurement.internal.f4
    protected final boolean n() {
        return 0;
    }

    @Override // com.google.android.gms.measurement.internal.f4
    final SQLiteDatabase o() {
        final int i2 = 0;
        if (this.d) {
            return i2;
        }
        SQLiteDatabase writableDatabase = this.c.getWritableDatabase();
        if (writableDatabase == null) {
            this.d = true;
            return i2;
        }
        return writableDatabase;
    }

    public final List<a> p(int i) {
        boolean z;
        String cmp;
        int fromParcel;
        int delete;
        Throwable th3;
        int i4;
        int i3;
        int i2;
        Throwable th5;
        String[] strArr;
        boolean z2;
        long valueOf;
        String obtain;
        int size;
        String[] strArr3;
        Throwable th4;
        String str;
        Throwable th;
        String[] strArr2;
        int long;
        final Object obj = this;
        String str4 = "rowid";
        final String str6 = "Error reading entries from local database";
        h();
        final int i5 = 0;
        if (obj.d) {
            return i5;
        }
        ArrayList arrayList = new ArrayList();
        if (s()) {
            final int i6 = 5;
            final int i7 = 0;
            i2 = i6;
            i4 = i7;
            final int i9 = 1;
            SQLiteDatabase sQLiteDatabase4 = o();
            if (i4 < i6 && sQLiteDatabase4 == null) {
                i9 = 1;
                sQLiteDatabase4 = o();
                if (sQLiteDatabase4 == null) {
                    obj.d = i9;
                    return i5;
                }
                sQLiteDatabase4.beginTransaction();
                void strArr6 = /* result */;
                final SQLiteDatabase obj23 = sQLiteDatabase4;
                strArr = sQLiteDatabase4.query("messages", strArr6, "type=?", /* result */, 0, 0, "rowid desc", "1");
                long = -1;
                if (strArr.moveToFirst()) {
                    valueOf = strArr.getLong(i7);
                    if (strArr != null) {
                        strArr.close();
                    }
                } else {
                    if (strArr != null) {
                        strArr.close();
                    }
                    valueOf = long;
                }
                if (Long.compare(valueOf, long) != 0) {
                    strArr = new String[i9];
                    strArr[i7] = String.valueOf(valueOf);
                    str = cmp;
                    strArr2 = strArr;
                } else {
                    strArr2 = str;
                }
                Cursor query = obj23.query("messages", /* result */, str, strArr2, 0, 0, "rowid asc", Integer.toString(100));
                while (query.moveToNext()) {
                    long = query.getLong(i7);
                    int int = query.getInt(i9);
                    int i10 = 2;
                    strArr3 = query.getBlob(i10);
                    if (int == 0) {
                    } else {
                    }
                    if (int == i9) {
                    } else {
                    }
                    if (int == i10) {
                    } else {
                    }
                    if (int == 3) {
                    } else {
                    }
                    obj.a.b().r().a("Unknown record type in local database");
                    obj.a.b().w().a("Skipping app launch break");
                    obtain = Parcel.obtain();
                    obtain.unmarshall(strArr3, i7, strArr3.length);
                    obtain.setDataPosition(i7);
                    fromParcel = c.CREATOR.createFromParcel(obtain);
                    obtain.recycle();
                    if (fromParcel != 0) {
                    }
                    arrayList.add(fromParcel);
                    obtain = Parcel.obtain();
                    obtain.unmarshall(strArr3, i7, strArr3.length);
                    obtain.setDataPosition(i7);
                    fromParcel = ea.CREATOR.createFromParcel(obtain);
                    obtain.recycle();
                    if (fromParcel != 0) {
                    }
                    arrayList.add(fromParcel);
                    obtain = Parcel.obtain();
                    obtain.unmarshall(strArr3, i7, strArr3.length);
                    obtain.setDataPosition(i7);
                    fromParcel = u.CREATOR.createFromParcel(obtain);
                    obtain.recycle();
                    if ((u)fromParcel != 0) {
                    }
                    arrayList.add((u)fromParcel);
                    Throwable th2 = obj1.a;
                    th2 = th2.b();
                    th2 = th2.r();
                    String str10 = "Failed to load user property from local database";
                    th2.a(str10);
                    z2.recycle();
                    th2 = th3;
                    th2 = obj1.a;
                    th2 = th2.b();
                    th2 = th2.r();
                    str10 = "Failed to load conditional user property from local database";
                    th2.a(str10);
                    z2.recycle();
                    th2 = th3;
                }
                String[] strArr5 = new String[i9];
                strArr5[i7] = Long.toString(long);
                SQLiteDatabase sQLiteDatabase3 = obj23;
                if (sQLiteDatabase3.delete("messages", "rowid <= ?", strArr5) < arrayList.size()) {
                    obj.a.b().r().a("Fewer entries removed from local database than expected");
                }
                try {
                    sQLiteDatabase3.setTransactionSuccessful();
                    sQLiteDatabase3.endTransaction();
                    if (query != null) {
                    }
                    query.close();
                    sQLiteDatabase3.close();
                    return arrayList;
                    th4 = i;
                    th3 = th5;
                    th4 = i;
                    th4 = i;
                    th4 = i;
                    th4 = i;
                    th4 = i;
                    th4 = th;
                    th5 = th3;
                    if (th5 == null) {
                    } else {
                    }
                    th5.close();
                    throw th2;
                }
                th = th4;
                z2 = th.inTransaction();
                if (th != null && z2) {
                    z2 = th.inTransaction();
                    if (z2) {
                        th.endTransaction();
                    }
                }
                z2 = obj1.a;
                z2 = z2.b();
                z2 = z2.r();
                z2.b(obj3, th2);
                obj1.d = obj10;
                if (th5 != null) {
                    th5.close();
                }
                if (th != null) {
                    th.close();
                }
            }
            obj.a.b().w().a("Failed to read events from database in reasonable time");
            return i5;
        }
        return arrayList;
    }

    @Override // com.google.android.gms.measurement.internal.f4
    public final void q() {
        SQLiteDatabase valueOf;
        Object str;
        int str2;
        h();
        valueOf = o();
        str2 = 0;
        valueOf = valueOf.delete("messages", str2, str2);
        if (valueOf != null && valueOf > 0) {
            str2 = 0;
            valueOf = valueOf.delete("messages", str2, str2);
            if (valueOf > 0) {
                this.a.b().v().b("Reset local analytics data. records", Integer.valueOf(valueOf));
            }
        }
        try {
            str = this.a;
            str = str.b();
            str = str.r();
            str.b("Error resetting local analytics data. error", th);
        }
    }

    @Override // com.google.android.gms.measurement.internal.f4
    public final boolean r() {
        return x(3, new byte[0]);
    }

    @Override // com.google.android.gms.measurement.internal.f4
    final boolean s() {
        this.a.z();
        return this.a.f().getDatabasePath("google_app_measurement_local.db").exists();
    }

    @Override // com.google.android.gms.measurement.internal.f4
    public final boolean t() {
        Object str2;
        boolean str;
        int i2;
        int i;
        boolean z2;
        boolean z;
        str2 = "Error deleting app launch break from local database";
        h();
        final int i4 = 0;
        if (this.d) {
            return i4;
        }
        if (s()) {
            int i3 = 5;
            i = i3;
            i2 = i4;
            int i5 = 0;
            int i6 = 1;
            SQLiteDatabase sQLiteDatabase = o();
            if (i2 < i3 && sQLiteDatabase == null) {
                i5 = 0;
                i6 = 1;
                sQLiteDatabase = o();
                if (sQLiteDatabase == null) {
                    this.d = i6;
                    return i4;
                }
                sQLiteDatabase.beginTransaction();
                final String[] strArr = new String[i6];
                strArr[i4] = Integer.toString(3);
                sQLiteDatabase.delete("messages", "type == ?", strArr);
                sQLiteDatabase.setTransactionSuccessful();
                sQLiteDatabase.endTransaction();
                sQLiteDatabase.close();
                return i6;
            }
            try {
                this.a.b().w().a("Error deleting app launch break from local database in reasonable time");
                return i4;
            } catch (Throwable th) {
            }
        }
    }

    @Override // com.google.android.gms.measurement.internal.f4
    public final boolean u(com.google.android.gms.measurement.internal.c c) {
        byte[] obj3 = this.a.N().c0(c);
        if (obj3.length > 131072) {
            this.a.b().t().a("Conditional user property too long for local database. Sending directly to service");
            return 0;
        }
        return x(2, obj3);
    }

    @Override // com.google.android.gms.measurement.internal.f4
    public final boolean v(com.google.android.gms.measurement.internal.u u) {
        Parcel obtain = Parcel.obtain();
        final int i = 0;
        v.a(u, obtain, i);
        byte[] obj4 = obtain.marshall();
        obtain.recycle();
        if (obj4.length > 131072) {
            this.a.b().t().a("Event is too long for local database. Sending event directly to service");
            return i;
        }
        return x(i, obj4);
    }

    @Override // com.google.android.gms.measurement.internal.f4
    public final boolean w(com.google.android.gms.measurement.internal.ea ea) {
        Parcel obtain = Parcel.obtain();
        final int i2 = 0;
        fa.a(ea, obtain, i2);
        byte[] obj4 = obtain.marshall();
        obtain.recycle();
        if (obj4.length > 131072) {
            this.a.b().t().a("User property too long for local database. Sending directly to service");
            return i2;
        }
        return x(1, obj4);
    }
}
