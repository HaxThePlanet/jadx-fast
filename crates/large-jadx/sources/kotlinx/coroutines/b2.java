package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.b0.g;

/* loaded from: classes3.dex */
@Metadata(d1 = {"kotlinx/coroutines/JobKt__FutureKt", "kotlinx/coroutines/JobKt__JobKt"}, k = 4, mv = {1, 5, 1}, xi = 48)
public final class b2 {
    public static final kotlinx.coroutines.z a(kotlinx.coroutines.y1 y1) {
        return d2.a(y1);
    }

    public static kotlinx.coroutines.z b(kotlinx.coroutines.y1 y1, int i2, Object object3) {
        return d2.b(y1, i2, object3);
    }

    public static final void c(g g, CancellationException cancellationException2) {
        d2.c(g, cancellationException2);
    }

    public static void d(g g, CancellationException cancellationException2, int i3, Object object4) {
        d2.d(g, cancellationException2, i3, object4);
    }

    public static final void e(kotlinx.coroutines.p<?> p, Future<?> future2) {
        c2.a(p, future2);
    }

    public static final kotlinx.coroutines.e1 f(kotlinx.coroutines.y1 y1, kotlinx.coroutines.e1 e12) {
        return d2.e(y1, e12);
    }

    public static final void g(g g) {
        d2.f(g);
    }

    public static final void h(kotlinx.coroutines.y1 y1) {
        d2.g(y1);
    }
}
