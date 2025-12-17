package com.google.firebase.firestore.local;

import android.database.sqlite.SQLiteStatement;
import com.google.firebase.firestore.util.Consumer;

/* loaded from: classes2.dex */
public final class r1 implements Consumer {

    public final boolean[] a;
    public final SQLiteStatement b;
    public final long c;
    public r1(boolean[] zArr, SQLiteStatement sQLiteStatement2, long l3) {
        super();
        this.a = zArr;
        this.b = sQLiteStatement2;
        this.c = l3;
    }

    @Override // com.google.firebase.firestore.util.Consumer
    public final void accept(Object object) {
        SQLiteSchema.u(this.a, this.b, this.c, obj3);
    }
}
