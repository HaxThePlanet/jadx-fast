package androidx.compose.ui.graphics;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0003\u0008f\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\u0003H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\t\u0010\nJ*\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u000cH&J\u001d\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\u0003H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\u0013\u0010\nJ\u001a\u0010\u0014\u001a\u00020\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0017\u001a\u00020\u000cH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005ø\u0001\u0002\u0082\u0002\u0011\n\u0002\u0008!\n\u0005\u0008¡\u001e0\u0001\n\u0004\u0008!0\u0001¨\u0006\u0018À\u0006\u0003", d2 = {"Landroidx/compose/ui/graphics/PathMeasure;", "", "length", "", "getLength", "()F", "getPosition", "Landroidx/compose/ui/geometry/Offset;", "distance", "getPosition-tuRUvjQ", "(F)J", "getSegment", "", "startDistance", "stopDistance", "destination", "Landroidx/compose/ui/graphics/Path;", "startWithMoveTo", "getTangent", "getTangent-tuRUvjQ", "setPath", "", "path", "forceClosed", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface PathMeasure {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static boolean getSegment$default(androidx.compose.ui.graphics.PathMeasure pathMeasure, float f2, float f3, androidx.compose.ui.graphics.Path path4, boolean z5, int i6, Object object7) {
            return PathMeasure.getSegment$default(pathMeasure, f2, f3, path4, z5, i6, object7);
        }
    }
    public static boolean getSegment$default(androidx.compose.ui.graphics.PathMeasure pathMeasure, float f2, float f3, androidx.compose.ui.graphics.Path path4, boolean z5, int i6, Object object7) {
        int obj4;
        if (object7 != null) {
        } else {
            if (i6 &= 8 != 0) {
                obj4 = 1;
            }
            return pathMeasure.getSegment(f2, f3, path4, obj4);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getSegment");
        throw obj0;
    }

    public abstract float getLength();

    public abstract long getPosition-tuRUvjQ(float f);

    public abstract boolean getSegment(float f, float f2, androidx.compose.ui.graphics.Path path3, boolean z4);

    public abstract long getTangent-tuRUvjQ(float f);

    public abstract void setPath(androidx.compose.ui.graphics.Path path, boolean z2);
}
