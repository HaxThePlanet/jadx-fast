package androidx.graphics.path;

import kotlin.Metadata;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0002\u0010\u0003\"\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0003¨\u0006\u0006", d2 = {"CloseSegment", "Landroidx/graphics/path/PathSegment;", "getCloseSegment", "()Landroidx/graphics/path/PathSegment;", "DoneSegment", "getDoneSegment", "graphics-path_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PathSegmentUtilities {

    private static final androidx.graphics.path.PathSegment CloseSegment;
    private static final androidx.graphics.path.PathSegment DoneSegment;
    static {
        int i = 0;
        final int i3 = 0;
        final int i4 = 0;
        PathSegment pathSegment = new PathSegment(PathSegment.Type.Done, new PointF[i3], i4);
        PathSegmentUtilities.DoneSegment = pathSegment;
        int i2 = 0;
        PathSegment pathSegment2 = new PathSegment(PathSegment.Type.Close, new PointF[i3], i4);
        PathSegmentUtilities.CloseSegment = pathSegment2;
    }

    public static final androidx.graphics.path.PathSegment getCloseSegment() {
        return PathSegmentUtilities.CloseSegment;
    }

    public static final androidx.graphics.path.PathSegment getDoneSegment() {
        return PathSegmentUtilities.DoneSegment;
    }
}
