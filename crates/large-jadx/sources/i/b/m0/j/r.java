package i.b.m0.j;

import i.b.j0.b;
import i.b.m0.c.i;
import i.b.m0.c.j;
import i.b.m0.f.b;
import i.b.m0.f.c;
import i.b.y;
import m.c.c;

/* loaded from: classes3.dex */
public final class r {
    public static <T, U> boolean a(boolean z, boolean z2, y<?> y3, boolean z4, j<?> j5, b b6, i.b.m0.j.o<T, U> o7) {
        Throwable obj2;
        final int i = 1;
        if (o7.a()) {
            j5.clear();
            b6.dispose();
            return i;
        }
        if (z != null) {
            if (z4) {
                if (z2 && b6 != null) {
                    if (b6 != null) {
                        b6.dispose();
                    }
                    obj2 = o7.l();
                    if (obj2 != null) {
                        y3.onError(obj2);
                    } else {
                        y3.onComplete();
                    }
                    return i;
                }
            } else {
                obj2 = o7.l();
                j5.clear();
                if (obj2 != null && b6 != null) {
                    j5.clear();
                    if (b6 != null) {
                        b6.dispose();
                    }
                    y3.onError(obj2);
                    return i;
                }
                if (z2 && b6 != null) {
                    if (b6 != null) {
                        b6.dispose();
                    }
                    y3.onComplete();
                    return i;
                }
            }
        }
        return 0;
    }

    public static <T> j<T> b(int i) {
        if (i < 0) {
            c cVar = new c(-i);
            return cVar;
        }
        b bVar = new b(i);
        return bVar;
    }

    public static <T, U> void c(i<T> i, y<? super U> y2, boolean z3, b b4, i.b.m0.j.o<T, U> o5) {
        int i3;
        boolean poll;
        boolean empty;
        y yVar;
        boolean z;
        j jVar;
        b bVar;
        i.b.m0.j.o oVar;
        i.b.m0.j.o oVar2;
        int i2;
        final int i4 = 1;
        i3 = i4;
        while (r.a(o5.done(), i.isEmpty(), y2, z3, i, b4, o5)) {
            poll = i.poll();
            while (!poll) {
                i2 = i4;
                o5.b(y2, poll);
                poll = i.poll();
                i2 = yVar;
            }
            i2 = yVar;
            o5.b(y2, poll);
            i2 = i4;
        }
    }

    public static void d(c c, int i2) {
        long l;
        l = i2 < 0 ? 9223372036854775807L : (long)i2;
        c.request(l);
    }
}
