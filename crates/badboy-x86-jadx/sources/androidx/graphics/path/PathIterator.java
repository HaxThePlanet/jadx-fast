package androidx.graphics.path;

import android.graphics.Path;
import android.os.Build.VERSION;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\u0008\u0004\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\tJ\u0010\u0010\u0012\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u0015J\t\u0010\u0016\u001a\u00020\u0015H\u0096\u0002J\t\u0010\u0017\u001a\u00020\u0002H\u0096\u0002J\u001a\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u0013H\u0007J\u0006\u0010\u001c\u001a\u00020\u0018R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011¨\u0006\u001e", d2 = {"Landroidx/graphics/path/PathIterator;", "", "Landroidx/graphics/path/PathSegment;", "path", "Landroid/graphics/Path;", "conicEvaluation", "Landroidx/graphics/path/PathIterator$ConicEvaluation;", "tolerance", "", "(Landroid/graphics/Path;Landroidx/graphics/path/PathIterator$ConicEvaluation;F)V", "getConicEvaluation", "()Landroidx/graphics/path/PathIterator$ConicEvaluation;", "implementation", "Landroidx/graphics/path/PathIteratorImpl;", "getPath", "()Landroid/graphics/Path;", "getTolerance", "()F", "calculateSize", "", "includeConvertedConics", "", "hasNext", "next", "Landroidx/graphics/path/PathSegment$Type;", "points", "", "offset", "peek", "ConicEvaluation", "graphics-path_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PathIterator implements Iterator<androidx.graphics.path.PathSegment>, KMappedMarker {

    private final androidx.graphics.path.PathIterator.ConicEvaluation conicEvaluation;
    private final androidx.graphics.path.PathIteratorImpl implementation;
    private final Path path;
    private final float tolerance;

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0004\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004¨\u0006\u0005", d2 = {"Landroidx/graphics/path/PathIterator$ConicEvaluation;", "", "(Ljava/lang/String;I)V", "AsConic", "AsQuadratics", "graphics-path_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static enum ConicEvaluation {

        AsConic,
        AsConic,
        AsConic;
        private static final androidx.graphics.path.PathIterator.ConicEvaluation[] $values() {
            return /* result */;
        }
    }
    public PathIterator(Path path, androidx.graphics.path.PathIterator.ConicEvaluation conicEvaluation, float tolerance) {
        androidx.graphics.path.PathIteratorImpl pathIteratorApi34Impl;
        Path path2;
        androidx.graphics.path.PathIterator.ConicEvaluation conicEvaluation2;
        float tolerance2;
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(conicEvaluation, "conicEvaluation");
        super();
        this.path = path;
        this.conicEvaluation = conicEvaluation;
        this.tolerance = tolerance;
        if (Build.VERSION.SDK_INT >= 34) {
            pathIteratorApi34Impl = new PathIteratorApi34Impl(this.path, this.conicEvaluation, this.tolerance);
        } else {
            pathIteratorApi34Impl = new PathIteratorPreApi34Impl(this.path, this.conicEvaluation, this.tolerance);
        }
        this.implementation = pathIteratorApi34Impl;
    }

    public PathIterator(Path path, androidx.graphics.path.PathIterator.ConicEvaluation pathIterator$ConicEvaluation2, float f3, int i4, DefaultConstructorMarker defaultConstructorMarker5) {
        androidx.graphics.path.PathIterator.ConicEvaluation obj2;
        int obj3;
        obj2 = i4 & 2 != 0 ? PathIterator.ConicEvaluation.AsQuadratics : obj2;
        obj3 = i4 &= 4 != 0 ? 1048576000 : obj3;
        super(path, obj2, obj3);
    }

    public static int calculateSize$default(androidx.graphics.path.PathIterator pathIterator, boolean z2, int i3, Object object4) {
        int obj1;
        final int obj3 = 1;
        if (i3 &= obj3 != 0) {
            obj1 = obj3;
        }
        return pathIterator.calculateSize(obj1);
    }

    public static androidx.graphics.path.PathSegment.Type next$default(androidx.graphics.path.PathIterator pathIterator, float[] f2Arr2, int i3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        return pathIterator.next(f2Arr2, obj2);
    }

    @Override // java.util.Iterator
    public final int calculateSize(boolean includeConvertedConics) {
        return this.implementation.calculateSize(includeConvertedConics);
    }

    @Override // java.util.Iterator
    public final androidx.graphics.path.PathIterator.ConicEvaluation getConicEvaluation() {
        return this.conicEvaluation;
    }

    @Override // java.util.Iterator
    public final Path getPath() {
        return this.path;
    }

    @Override // java.util.Iterator
    public final float getTolerance() {
        return this.tolerance;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.implementation.hasNext();
    }

    @Override // java.util.Iterator
    public final androidx.graphics.path.PathSegment.Type next(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "points");
        return PathIterator.next$default(this, fArr, 0, 2, 0);
    }

    @Override // java.util.Iterator
    public final androidx.graphics.path.PathSegment.Type next(float[] points, int offset) {
        Intrinsics.checkNotNullParameter(points, "points");
        return this.implementation.next(points, offset);
    }

    @Override // java.util.Iterator
    public androidx.graphics.path.PathSegment next() {
        return this.implementation.next();
    }

    @Override // java.util.Iterator
    public Object next() {
        return next();
    }

    @Override // java.util.Iterator
    public final androidx.graphics.path.PathSegment.Type peek() {
        return this.implementation.peek();
    }

    @Override // java.util.Iterator
    public void remove() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }
}
