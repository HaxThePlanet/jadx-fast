package androidx.compose.ui.graphics;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0002\u0010\u0003\"\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0003¨\u0006\u0006", d2 = {"CloseSegment", "Landroidx/compose/ui/graphics/PathSegment;", "getCloseSegment", "()Landroidx/compose/ui/graphics/PathSegment;", "DoneSegment", "getDoneSegment", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PathSegmentKt {

    private static final androidx.compose.ui.graphics.PathSegment CloseSegment;
    private static final androidx.compose.ui.graphics.PathSegment DoneSegment;
    static {
        int i = 0;
        final int i2 = 0;
        PathSegment pathSegment = new PathSegment(PathSegment.Type.Done, new float[i], i2);
        PathSegmentKt.DoneSegment = pathSegment;
        PathSegment pathSegment2 = new PathSegment(PathSegment.Type.Close, new float[i], i2);
        PathSegmentKt.CloseSegment = pathSegment2;
    }

    public static final androidx.compose.ui.graphics.PathSegment getCloseSegment() {
        return PathSegmentKt.CloseSegment;
    }

    public static final androidx.compose.ui.graphics.PathSegment getDoneSegment() {
        return PathSegmentKt.DoneSegment;
    }
}
