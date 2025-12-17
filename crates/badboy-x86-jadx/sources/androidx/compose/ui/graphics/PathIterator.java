package androidx.compose.ui.graphics;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\u0008\u0003\u0008f\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019J\u0012\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u0012H&J\t\u0010\u0013\u001a\u00020\u0012H¦\u0002J\t\u0010\u0014\u001a\u00020\u0002H¦\u0002J\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u0010H&R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\u0008X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\u000cX¦\u0004¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000eø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u001aÀ\u0006\u0001", d2 = {"Landroidx/compose/ui/graphics/PathIterator;", "", "Landroidx/compose/ui/graphics/PathSegment;", "conicEvaluation", "Landroidx/compose/ui/graphics/PathIterator$ConicEvaluation;", "getConicEvaluation", "()Landroidx/compose/ui/graphics/PathIterator$ConicEvaluation;", "path", "Landroidx/compose/ui/graphics/Path;", "getPath", "()Landroidx/compose/ui/graphics/Path;", "tolerance", "", "getTolerance", "()F", "calculateSize", "", "includeConvertedConics", "", "hasNext", "next", "Landroidx/compose/ui/graphics/PathSegment$Type;", "outPoints", "", "offset", "ConicEvaluation", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface PathIterator extends Iterator<androidx.compose.ui.graphics.PathSegment>, KMappedMarker {

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0004\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004¨\u0006\u0005", d2 = {"Landroidx/compose/ui/graphics/PathIterator$ConicEvaluation;", "", "(Ljava/lang/String;I)V", "AsConic", "AsQuadratics", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static enum ConicEvaluation {

        AsConic,
        AsConic,
        AsConic;
        private static final androidx.compose.ui.graphics.PathIterator.ConicEvaluation[] $values() {
            return /* result */;
        }
    }
    public static int calculateSize$default(androidx.compose.ui.graphics.PathIterator pathIterator, boolean z2, int i3, Object object4) {
        int obj1;
        if (object4 != null) {
        } else {
            final int obj3 = 1;
            if (i3 &= obj3 != 0) {
                obj1 = obj3;
            }
            return pathIterator.calculateSize(obj1);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: calculateSize");
        throw obj0;
    }

    public static androidx.compose.ui.graphics.PathSegment.Type next$default(androidx.compose.ui.graphics.PathIterator pathIterator, float[] f2Arr2, int i3, int i4, Object object5) {
        int obj2;
        if (object5 != null) {
        } else {
            if (i4 &= 2 != 0) {
                obj2 = 0;
            }
            return pathIterator.next(f2Arr2, obj2);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: next");
        throw obj0;
    }

    @Override // java.util.Iterator
    public abstract int calculateSize(boolean z);

    @Override // java.util.Iterator
    public abstract androidx.compose.ui.graphics.PathIterator.ConicEvaluation getConicEvaluation();

    @Override // java.util.Iterator
    public abstract androidx.compose.ui.graphics.Path getPath();

    @Override // java.util.Iterator
    public abstract float getTolerance();

    @Override // java.util.Iterator
    public abstract boolean hasNext();

    @Override // java.util.Iterator
    public abstract androidx.compose.ui.graphics.PathSegment.Type next(float[] fArr, int i2);

    @Override // java.util.Iterator
    public abstract androidx.compose.ui.graphics.PathSegment next();
}
