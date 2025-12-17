package androidx.graphics.path;

import android.graphics.Path;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0086\u0002\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007", d2 = {"iterator", "Landroidx/graphics/path/PathIterator;", "Landroid/graphics/Path;", "conicEvaluation", "Landroidx/graphics/path/PathIterator$ConicEvaluation;", "tolerance", "", "graphics-path_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PathUtilities {
    public static final androidx.graphics.path.PathIterator iterator(Path $this$iterator) {
        Intrinsics.checkNotNullParameter($this$iterator, "<this>");
        PathIterator pathIterator = new PathIterator($this$iterator, 0, 0, 6, 0);
        return pathIterator;
    }

    public static final androidx.graphics.path.PathIterator iterator(Path $this$iterator, androidx.graphics.path.PathIterator.ConicEvaluation conicEvaluation, float tolerance) {
        Intrinsics.checkNotNullParameter($this$iterator, "<this>");
        Intrinsics.checkNotNullParameter(conicEvaluation, "conicEvaluation");
        PathIterator pathIterator = new PathIterator($this$iterator, conicEvaluation, tolerance);
        return pathIterator;
    }

    public static androidx.graphics.path.PathIterator iterator$default(Path path, androidx.graphics.path.PathIterator.ConicEvaluation pathIterator$ConicEvaluation2, float f3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 1048576000;
        }
        return PathUtilities.iterator(path, conicEvaluation2, obj2);
    }
}
