package m.a.c.m;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.d.n;
import kotlin.l0.b;
import kotlin.l0.f;
import kotlin.l0.g;
import kotlin.l0.g.b;
import kotlin.l0.h;
import kotlin.o;
import kotlin.w;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000\u001a\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u00012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003\u001a&\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u00020\u00010\u0006\"\u0004\u0008\u0000\u0010\u00072\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\u0003¨\u0006\u0008", d2 = {"measureDuration", "", "code", "Lkotlin/Function0;", "", "measureDurationForResult", "Lkotlin/Pair;", "T", "koin-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class a {
    public static final double a(a<w> a) {
        n.f(a, "code");
        a.invoke();
        return b.B(g.b.b.a().a(), obj1);
    }

    public static final <T> o<T, Double> b(a<? extends T> a) {
        n.f(a, "code");
        final long l2 = g.b.b.a().a();
        h hVar = new h(a.invoke(), l2, obj3, 0);
        o obj4 = new o(hVar.b(), Double.valueOf(b.B(hVar.a(), l2)));
        return obj4;
    }
}
