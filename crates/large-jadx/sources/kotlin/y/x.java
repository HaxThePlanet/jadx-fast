package kotlin.y;

import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.h0.f;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000\u0018\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010!\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0005\u001a\u001c\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\u001a#\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007¢\u0006\u0002\u0008\u0004\u001a\u001d\u0010\u0005\u001a\u00020\u0006*\u0006\u0012\u0002\u0008\u00030\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0008\u0008\u001a\u001d\u0010\t\u001a\u00020\u0006*\u0006\u0012\u0002\u0008\u00030\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0008\n¨\u0006\u000b", d2 = {"asReversed", "", "T", "", "asReversedMutable", "reverseElementIndex", "", "index", "reverseElementIndex$CollectionsKt__ReversedViewsKt", "reversePositionIndex", "reversePositionIndex$CollectionsKt__ReversedViewsKt", "kotlin-stdlib"}, k = 5, mv = {1, 5, 1}, xi = 1, xs = "kotlin/collections/CollectionsKt")
class x extends kotlin.y.w {
    public static final int C(List list, int i2) {
        return x.G(list, i2);
    }

    public static final int D(List list, int i2) {
        return x.H(list, i2);
    }

    public static <T> List<T> E(List<? extends T> list) {
        n.f(list, "$this$asReversed");
        p0 p0Var = new p0(list);
        return p0Var;
    }

    public static <T> List<T> F(List<T> list) {
        n.f(list, "$this$asReversed");
        o0 o0Var = new o0(list);
        return o0Var;
    }

    private static final int G(List<?> list, int i2) {
        if (i2 < 0) {
        } else {
            if (p.i(list) < i2) {
            } else {
                return obj3 -= i2;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Element index ");
        stringBuilder.append(i2);
        stringBuilder.append(" must be in range [");
        f fVar = new f(0, p.i(list));
        stringBuilder.append(fVar);
        stringBuilder.append("].");
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(stringBuilder.toString());
        throw indexOutOfBoundsException;
    }

    private static final int H(List<?> list, int i2) {
        if (i2 < 0) {
        } else {
            if (list.size() < i2) {
            } else {
                return obj3 -= i2;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Position index ");
        stringBuilder.append(i2);
        stringBuilder.append(" must be in range [");
        f fVar = new f(0, list.size());
        stringBuilder.append(fVar);
        stringBuilder.append("].");
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(stringBuilder.toString());
        throw indexOutOfBoundsException;
    }
}
