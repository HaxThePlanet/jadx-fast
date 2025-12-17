package androidx.core.graphics;

import android.graphics.Path;
import android.graphics.Path.Op;
import kotlin.Metadata;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0005\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\u000c\u001a\u001c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004*\u00020\u00012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007H\u0007\u001a\u0015\u0010\u0008\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\n\u001a\u0015\u0010\t\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\u000c\u001a\u0015\u0010\n\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\n\u001a\u0015\u0010\u000b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\u000c¨\u0006\u000c", d2 = {"and", "Landroid/graphics/Path;", "p", "flatten", "", "Landroidx/core/graphics/PathSegment;", "error", "", "minus", "or", "plus", "xor", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PathKt {
    public static final Path and(Path $this$and, Path p) {
        final int i = 0;
        Path path = new Path();
        final int i2 = 0;
        path.op($this$and, p, Path.Op.INTERSECT);
        return path;
    }

    public static final Iterable<androidx.core.graphics.PathSegment> flatten(Path $this$flatten, float error) {
        return (Iterable)PathUtils.flatten($this$flatten, error);
    }

    public static Iterable flatten$default(Path path, float f2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = 1056964608;
        }
        return PathKt.flatten(path, obj1);
    }

    public static final Path minus(Path $this$minus, Path p) {
        final int i = 0;
        Path path = new Path($this$minus);
        final int i2 = 0;
        path.op(p, Path.Op.DIFFERENCE);
        return path;
    }

    public static final Path or(Path $this$or, Path p) {
        final int i = 0;
        final int i2 = 0;
        Path path2 = new Path($this$or);
        final int i3 = 0;
        path2.op(p, Path.Op.UNION);
        return path2;
    }

    public static final Path plus(Path $this$plus, Path p) {
        final int i = 0;
        Path path = new Path($this$plus);
        final int i2 = 0;
        path.op(p, Path.Op.UNION);
        return path;
    }

    public static final Path xor(Path $this$xor, Path p) {
        final int i = 0;
        Path path = new Path($this$xor);
        final int i2 = 0;
        path.op(p, Path.Op.XOR);
        return path;
    }
}
