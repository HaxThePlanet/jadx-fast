package androidx.room;

import android.content.ContentValues;
import d.b.a.c.a;

/* loaded from: classes.dex */
public final class b implements a {

    public final String a;
    public final int b;
    public final ContentValues c;
    public final String d;
    public final Object[] e;
    public b(String string, int i2, ContentValues contentValues3, String string4, Object[] object5Arr5) {
        super();
        this.a = string;
        this.b = i2;
        this.c = contentValues3;
        this.d = string4;
        this.e = object5Arr5;
    }

    @Override // d.b.a.c.a
    public final Object apply(Object object) {
        return a0.a.j(this.a, this.b, this.c, this.d, this.e, (g)object);
    }
}
