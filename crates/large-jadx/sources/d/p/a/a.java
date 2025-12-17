package d.p.a;

import android.os.Bundle;
import androidx.lifecycle.j0;
import d.p.b.b;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public abstract class a {

    public interface a {
        public abstract void a(b<D> b, D d2);

        public abstract b<D> b(int i, Bundle bundle2);

        public abstract void c(b<D> b);
    }
    public static <T extends androidx.lifecycle.q & j0> d.p.a.a b(T t) {
        b bVar = new b(t, (j0)t.getViewModelStore());
        return bVar;
    }

    @Deprecated
    public abstract void a(String string, FileDescriptor fileDescriptor2, PrintWriter printWriter3, String[] string4Arr4);

    public abstract <D> b<D> c(int i, Bundle bundle2, d.p.a.a.a<D> a$a3);

    public abstract void d();
}
