package d.p.a;

import android.os.Bundle;
import androidx.lifecycle.j0;
import androidx.lifecycle.q;
import d.p.b.b;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: LoaderManager.java */
/* loaded from: classes.dex */
public abstract class a {

    public interface a<D> {
        void a(b<D> bVar, D d);

        b<D> b(int i, Bundle bundle);

        void c(b<D> bVar);
    }
    public static <T extends q & j0> a b(T t) {
        return new b(t, (j0)t.getViewModelStore());
    }

    @Deprecated
    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract <D> b<D> c(int i, Bundle bundle, a.a<D> aVar);

    public abstract void d();
}
