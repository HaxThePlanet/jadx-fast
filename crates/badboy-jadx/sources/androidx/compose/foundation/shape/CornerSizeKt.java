package androidx.compose.foundation.shape;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0008\n\u0000\u001a\u001a\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0008H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\t\u0010\n\u001a\u0010\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u000bH\u0007\u001a\u0012\u0010\u0006\u001a\u00020\u00012\u0008\u0008\u0001\u0010\u000c\u001a\u00020\rH\u0007\"\u001c\u0010\u0000\u001a\u00020\u00018\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0002\u0010\u0003\u001a\u0004\u0008\u0004\u0010\u0005\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u000e", d2 = {"ZeroCornerSize", "Landroidx/compose/foundation/shape/CornerSize;", "getZeroCornerSize$annotations", "()V", "getZeroCornerSize", "()Landroidx/compose/foundation/shape/CornerSize;", "CornerSize", "size", "Landroidx/compose/ui/unit/Dp;", "CornerSize-0680j_4", "(F)Landroidx/compose/foundation/shape/CornerSize;", "", "percent", "", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CornerSizeKt {

    private static final androidx.compose.foundation.shape.CornerSize ZeroCornerSize;
    static {
        CornerSizeKt.ZeroCornerSize.1 anon = new CornerSizeKt.ZeroCornerSize.1();
        CornerSizeKt.ZeroCornerSize = (CornerSize)anon;
    }

    public static final androidx.compose.foundation.shape.CornerSize CornerSize(float size) {
        PxCornerSize pxCornerSize = new PxCornerSize(size);
        return (CornerSize)pxCornerSize;
    }

    public static final androidx.compose.foundation.shape.CornerSize CornerSize(int percent) {
        PercentCornerSize percentCornerSize = new PercentCornerSize((float)percent);
        return (CornerSize)percentCornerSize;
    }

    public static final androidx.compose.foundation.shape.CornerSize CornerSize-0680j_4(float size) {
        DpCornerSize dpCornerSize = new DpCornerSize(size, 0);
        return (CornerSize)dpCornerSize;
    }

    public static final androidx.compose.foundation.shape.CornerSize getZeroCornerSize() {
        return CornerSizeKt.ZeroCornerSize;
    }

    public static void getZeroCornerSize$annotations() {
    }
}
