package i.b.m0.j;

import i.b.m0.c.i;
import i.b.m0.c.j;
import i.b.y;

/* compiled from: QueueDrainHelper.java */
/* loaded from: classes3.dex */
public final class r {
    public static <T, U> boolean a(boolean z, boolean z2, y<?> yVar, boolean z3, j<?> jVar, i.b.j0.b bVar, o<T, U> oVar) {
        final boolean z5 = true;
        if (oVar.a()) {
            jVar.clear();
            bVar.dispose();
            return true;
        }
        if (z && z3 && z2 && bVar != null) {
            bVar.dispose();
            Throwable th2 = oVar.l();
            if (th2 != null) {
                yVar.onError(th2);
            } else {
                yVar.onComplete();
            }
            return true;
        }
        return false;
    }

    public static <T> j<T> b(int i) {
        if (i < 0) {
            return new c(-i);
        }
        return new b(i);
    }

    public static <T, U> void c(i<T> iVar, y<? super U> yVar, boolean z, i.b.j0.b bVar, o<T, U> oVar) {
        int i;
        y yVar22;
        i.b.m0.j.o oVar52;
        i = 1;
        while (r.a(oVar.done(), iVar.isEmpty(), yVar, z, iVar, bVar, oVar)) {
            Object poll = iVar.poll();
            while (poll == null) {
                if (i != 0) {
                }
                i = 0;
            }
            i = 0;
            if (i != 0) {
            }
        }
    }

    public static void d(m.c.c cVar, int i) {
        long l = 9223372036854775807L;
        int r0 = i < 0 ? 9223372036854775807L : (long)i;
        cVar.request((i < 0 ? 9223372036854775807L : (long)i));
    }
}
