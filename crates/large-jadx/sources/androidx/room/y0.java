package androidx.room;

import i.b.a0;
import i.b.c0;
import i.b.e0;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public class y0 {

    class a implements e0<T> {

        final Callable a;
        a(Callable callable) {
            this.a = callable;
            super();
        }

        public void a(c0<T> c0) {
            Object call;
            try {
                c0.onSuccess(this.a.call());
                c0.a(th);
            }
        }
    }
    static {
    }

    public static <T> a0<T> a(Callable<T> callable) {
        y0.a aVar = new y0.a(callable);
        return a0.create(aVar);
    }
}
