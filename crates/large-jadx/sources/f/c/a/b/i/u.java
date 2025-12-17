package f.c.a.b.i;

import android.content.Context;
import f.c.a.b.i.a0.j.i0;
import java.io.Closeable;

/* loaded from: classes.dex */
abstract class u implements Closeable {

    interface a {
        public abstract f.c.a.b.i.u.a a(Context context);

        public abstract f.c.a.b.i.u build();
    }
    @Override // java.io.Closeable
    abstract i0 a();

    @Override // java.io.Closeable
    abstract f.c.a.b.i.t c();

    @Override // java.io.Closeable
    public void close() {
        a().close();
    }
}
