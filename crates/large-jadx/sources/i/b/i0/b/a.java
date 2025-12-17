package i.b.i0.b;

import android.os.Handler;
import android.os.Looper;
import i.b.i0.a.a;
import i.b.z;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
public final class a {

    private static final z a;

    static class a implements Callable<z> {
        @Override // java.util.concurrent.Callable
        public z a() {
            return a.b.a;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    private static final class b {

        static final z a;
        static {
            Handler handler = new Handler(Looper.getMainLooper());
            b bVar = new b(handler, 0);
            a.b.a = bVar;
        }
    }
    static {
        a.a aVar = new a.a();
        a.a = a.d(aVar);
    }

    public static z a() {
        return a.e(a.a);
    }
}
