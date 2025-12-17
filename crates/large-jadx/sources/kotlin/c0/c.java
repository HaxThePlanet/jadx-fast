package kotlin.c0;

import kotlin.Metadata;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000\u0012\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0002\u0008\u0006\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0002\u001a \u0010\u0000\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a \u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0008\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0001H\u0001\u001a \u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0008\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0001\u001a\u0018\u0010\n\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0002\u001a\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0005H\u0002¨\u0006\u000b", d2 = {"differenceModulo", "", "a", "b", "c", "", "getProgressionLastElement", "start", "end", "step", "mod", "kotlin-stdlib"}, k = 2, mv = {1, 5, 1})
public final class c {
    private static final int a(int i, int i2, int i3) {
        return c.c(obj0 -= obj1, i3);
    }

    public static final int b(int i, int i2, int i3) {
        int obj0;
        int obj1;
        int obj2;
        if (i3 > 0) {
            if (i >= i2) {
            } else {
                i2 -= obj0;
            }
            return obj1;
        } else {
            if (i3 >= 0) {
            } else {
                if (i <= i2) {
                } else {
                    i2 += obj0;
                }
            }
        }
        obj0 = new IllegalArgumentException("Step is zero.");
        throw obj0;
    }

    private static final int c(int i, int i2) {
        int obj0;
        i %= i2;
        if (obj0 >= 0) {
        } else {
            obj0 += i2;
        }
        return obj0;
    }
}
