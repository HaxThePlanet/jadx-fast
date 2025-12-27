package f.c.a.b.i;

import android.content.Context;
import f.c.a.b.i.a0.j.i0;
import java.io.Closeable;

/* compiled from: TransportRuntimeComponent.java */
/* loaded from: classes.dex */
abstract class u implements Closeable {

    interface a {
        u.a a(Context context);

        u build();
    }
    u() {
        super();
    }

    @Override // java.io.Closeable
    public void close() throws java.io.IOException {
        a().close();
    }

    abstract i0 a();

    abstract t c();
}
