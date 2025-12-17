package com.google.android.gms.measurement.internal;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import java.io.File;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes2.dex */
public final class l {
    static void a(com.google.android.gms.measurement.internal.q3 q3, SQLiteDatabase sQLiteDatabase2, String string3, String string4, String string5, String[] string6Arr6) {
        boolean moveToFirst;
        Object hashSet;
        com.google.android.gms.measurement.internal.o3 o3Var;
        Object query;
        String[] length;
        boolean empty;
        String str;
        int length2;
        String[] strArr2;
        int str2;
        String str3;
        String[] strArr;
        int i;
        com.google.android.gms.measurement.internal.o3 o3Var2;
        final Object obj4 = sQLiteDatabase2;
        final String str13 = string3;
        final Object[] objArr = string6Arr6;
        if (q3 == null) {
        } else {
            i = 0;
            strArr = new String[1];
            strArr[i] = str13;
            query = sQLiteDatabase2.query("SQLITE_MASTER", /* result */, "name=?", strArr, 0, 0, 0);
            if (query != null) {
                query.close();
            }
            if (!query.moveToFirst()) {
                sQLiteDatabase2.execSQL(string4);
            }
            hashSet = new HashSet();
            StringBuilder stringBuilder = new StringBuilder(length3 += 22);
            stringBuilder.append("SELECT * FROM ");
            stringBuilder.append(str13);
            stringBuilder.append(" LIMIT 0");
            Cursor rawQuery = sQLiteDatabase2.rawQuery(stringBuilder.toString(), 0);
            Collections.addAll(hashSet, rawQuery.getColumnNames());
            rawQuery.close();
            length = string5.split(",");
            str2 = i;
            while (str2 < length.length) {
                str3 = length[str2];
                str2++;
            }
            if (objArr != null) {
            }
            if (!hashSet.isEmpty()) {
                q3.w().c("Table has extra columns. table, columns", str13, TextUtils.join(", ", hashSet));
            }
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Monitor must not be null");
        throw illegalArgumentException;
    }

    static void b(com.google.android.gms.measurement.internal.q3 q3, SQLiteDatabase sQLiteDatabase2) {
        boolean readable;
        boolean readable2;
        String str;
        com.google.android.gms.measurement.internal.o3 obj3;
        boolean obj4;
        if (q3 == null) {
        } else {
            File file = new File(sQLiteDatabase2.getPath());
            obj4 = 0;
            if (file.setReadable(obj4, obj4) == null) {
                q3.w().a("Failed to turn off database read permission");
            }
            if (file.setWritable(obj4, obj4) == null) {
                q3.w().a("Failed to turn off database write permission");
            }
            obj4 = 1;
            if (file.setReadable(obj4, obj4) == null) {
                q3.w().a("Failed to turn on database read permission for owner");
            }
            if (file.setWritable(obj4, obj4) == null) {
                q3.w().a("Failed to turn on database write permission for owner");
            }
        }
        obj3 = new IllegalArgumentException("Monitor must not be null");
        throw obj3;
    }
}
