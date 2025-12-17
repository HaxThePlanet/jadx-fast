package androidx.room;

import android.content.ContentValues;
import d.b.a.c.a;

/* loaded from: classes.dex */
public final class d implements a {

    public final String a;
    public final int b;
    public final ContentValues c;
    public d(String string, int i2, ContentValues contentValues3) {
        super();
        this.a = string;
        this.b = i2;
        this.c = contentValues3;
    }

    @Override // d.b.a.c.a
    public final Object apply(Object object) {
        return a0.a.c(this.a, this.b, this.c, (g)object);
    }
}
