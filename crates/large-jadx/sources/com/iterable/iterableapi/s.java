package com.iterable.iterableapi;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* loaded from: classes2.dex */
class s extends SQLiteOpenHelper {
    s(Context context) {
        super(context, "iterable_sdk.db", 0, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS OfflineTask (task_id TEXT PRIMARY KEY,name TEXT,version INTEGER,created BIGINT,modified BIGINT,last_attempt BIGINT,scheduled BIGINT,requested BIGINT,processing BOOLEAN,failed BOOLEAN,blocking BOOLEAN,data TEXT,error TEXT,type TEXT,attempts INTEGER)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
    }
}
