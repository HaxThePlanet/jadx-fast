package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import java.io.File;

/* loaded from: classes2.dex */
final class i3 extends SQLiteOpenHelper {

    final com.google.android.gms.measurement.internal.j3 a;
    i3(com.google.android.gms.measurement.internal.j3 j3, Context context2, String string3) {
        this.a = j3;
        super(context2, "google_app_measurement_local.db", 0, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final SQLiteDatabase getWritableDatabase() {
        String str;
        String str2;
        try {
            return super.getWritableDatabase();
            com.google.android.gms.measurement.internal.j3 j3Var = this.a;
            j3Var = j3Var.a;
            j3Var = j3Var.b();
            j3Var = j3Var.r();
            str = "Opening the local database failed, dropping and recreating it";
            j3Var.a(str);
            j3Var = this.a;
            j3Var = j3Var.a;
            j3Var.z();
            j3Var = "google_app_measurement_local.db";
            str = this.a;
            str = str.a;
            str = str.f();
            str = str.getDatabasePath(j3Var);
            str = str.delete();
            if (str == null) {
            }
            str = this.a;
            str = str.a;
            str = str.b();
            str = str.r();
            str2 = "Failed to delete corrupted local db file";
            str.b(str2, j3Var);
            j3Var = super.getWritableDatabase();
            return j3Var;
        } catch (android.database.sqlite.SQLiteException sQLite) {
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        l.b(j3Var.a.b(), sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        l.a(j3Var.a.b(), sQLiteDatabase, "messages", "create table if not exists messages ( type INTEGER NOT NULL, entry BLOB NOT NULL)", "type,entry", 0);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
    }
}
