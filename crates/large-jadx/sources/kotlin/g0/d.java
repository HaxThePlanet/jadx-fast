package kotlin.g0;

import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.h0.d;
import kotlin.h0.f;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0006\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0004H\u0007\u001a\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u0008H\u0000\u001a\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u000c2\u0006\u0010\t\u001a\u00020\u000cH\u0000\u001a\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003H\u0000\u001a\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0000\u001a\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0000\u001a\u0014\u0010\u000f\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0011H\u0007\u001a\u0014\u0010\u0012\u001a\u00020\u0004*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0013H\u0007\u001a\u0014\u0010\u0014\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003H\u0000¨\u0006\u0016", d2 = {"Random", "Lkotlin/random/Random;", "seed", "", "", "boundsErrorMessage", "", "from", "", "until", "checkRangeBounds", "", "", "fastLog2", "value", "nextInt", "range", "Lkotlin/ranges/IntRange;", "nextLong", "Lkotlin/ranges/LongRange;", "takeUpperBits", "bitCount", "kotlin-stdlib"}, k = 2, mv = {1, 5, 1})
public final class d {
    public static final String a(Object object, Object object2) {
        n.f(object, "from");
        n.f(object2, "until");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Random range is empty: [");
        stringBuilder.append(object);
        stringBuilder.append(", ");
        stringBuilder.append(object2);
        stringBuilder.append(").");
        return stringBuilder.toString();
    }

    public static final void b(int i, int i2) {
        int i3;
        i3 = i2 > i ? 1 : 0;
        if (i3 == 0) {
        } else {
        }
        IllegalArgumentException obj2 = new IllegalArgumentException(d.a(Integer.valueOf(i), Integer.valueOf(i2)).toString());
        throw obj2;
    }

    public static final int c(int i) {
        return obj0 - 31;
    }

    public static final int d(kotlin.g0.c c, f f2) {
        int i2;
        int i;
        int obj2;
        Object obj3;
        n.f(c, "$this$nextInt");
        n.f(f2, "range");
        if (f2.isEmpty()) {
        } else {
            if (f2.g() < Integer.MAX_VALUE) {
                obj2 = c.f(f2.d(), obj3++);
            } else {
                if (f2.d() > Integer.MIN_VALUE) {
                    obj2++;
                } else {
                    obj2 = c.d();
                }
            }
            return obj2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot get random in empty range: ");
        stringBuilder.append(f2);
        obj2 = new IllegalArgumentException(stringBuilder.toString());
        throw obj2;
    }

    public static final int e(int i, int i2) {
        return obj1 &= obj2;
    }
}
