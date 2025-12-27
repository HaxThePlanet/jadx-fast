package i.b.i0.b;

import android.os.Handler;
import android.os.Looper;
import i.b.i0.a.a;
import i.b.z;
import java.util.concurrent.Callable;

/* compiled from: AndroidSchedulers.java */
/* loaded from: classes3.dex */
public final class a {

    private static final z a;

    static class a implements Callable<z> {
        a() {
            super();
        }

        public z a() {
            return a.b.a;
        }
    }

    private static final class b {

        static final z a = new b();
        static {
            final Handler handler = new Handler(Looper.getMainLooper());
        }
    }
    static {
        a.a = a.d(new a.a());
    }

    public static z a() {
        return a.e(a.a);
    }
}
