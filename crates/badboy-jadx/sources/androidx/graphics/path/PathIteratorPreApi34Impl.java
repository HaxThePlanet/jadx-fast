package androidx.graphics.path;

import android.graphics.Path;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0014\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0010\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000eH\u0016J!\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000c2\u0006\u0010\u0006\u001a\u00020\u0007H\u0082 J\u0011\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\nH\u0082 J\u0008\u0010\u0012\u001a\u00020\u0011H\u0004J\u0008\u0010\u0013\u001a\u00020\u000eH\u0016J\u0011\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nH\u0083 J!\u0010\u0015\u001a\u00020\u000c2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000cH\u0083 J\u0011\u0010\u0019\u001a\u00020\u000c2\u0006\u0010\t\u001a\u00020\nH\u0083 J\u0011\u0010\u001a\u001a\u00020\u000c2\u0006\u0010\t\u001a\u00020\nH\u0083 J\u0011\u0010\u001b\u001a\u00020\u000c2\u0006\u0010\t\u001a\u00020\nH\u0083 J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000cH\u0016J\u0008\u0010\u001e\u001a\u00020\u001dH\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f", d2 = {"Landroidx/graphics/path/PathIteratorPreApi34Impl;", "Landroidx/graphics/path/PathIteratorImpl;", "path", "Landroid/graphics/Path;", "conicEvaluation", "Landroidx/graphics/path/PathIterator$ConicEvaluation;", "tolerance", "", "(Landroid/graphics/Path;Landroidx/graphics/path/PathIterator$ConicEvaluation;F)V", "internalPathIterator", "", "calculateSize", "", "includeConvertedConics", "", "createInternalPathIterator", "destroyInternalPathIterator", "", "finalize", "hasNext", "internalPathIteratorHasNext", "internalPathIteratorNext", "points", "", "offset", "internalPathIteratorPeek", "internalPathIteratorRawSize", "internalPathIteratorSize", "next", "Landroidx/graphics/path/PathSegment$Type;", "peek", "graphics-path_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PathIteratorPreApi34Impl extends androidx.graphics.path.PathIteratorImpl {

    private final long internalPathIterator;
    public PathIteratorPreApi34Impl(Path path, androidx.graphics.path.PathIterator.ConicEvaluation conicEvaluation, float tolerance) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(conicEvaluation, "conicEvaluation");
        super(path, conicEvaluation, tolerance);
        this.internalPathIterator = createInternalPathIterator(path, conicEvaluation.ordinal(), tolerance);
    }

    public PathIteratorPreApi34Impl(Path path, androidx.graphics.path.PathIterator.ConicEvaluation pathIterator$ConicEvaluation2, float f3, int i4, DefaultConstructorMarker defaultConstructorMarker5) {
        androidx.graphics.path.PathIterator.ConicEvaluation obj2;
        int obj3;
        obj2 = i4 & 2 != 0 ? PathIterator.ConicEvaluation.AsQuadratics : obj2;
        obj3 = i4 &= 4 != 0 ? 1048576000 : obj3;
        super(path, obj2, obj3);
    }

    private final native long createInternalPathIterator(Path path, int i2, float f3);

    private final native void destroyInternalPathIterator(long l);

    private final native boolean internalPathIteratorHasNext(long l);

    private final native int internalPathIteratorNext(long l, float[] f2Arr2, int i3);

    private final native int internalPathIteratorPeek(long l);

    private final native int internalPathIteratorRawSize(long l);

    private final native int internalPathIteratorSize(long l);

    @Override // androidx.graphics.path.PathIteratorImpl
    public int calculateSize(boolean includeConvertedConics) {
        int internalPathIteratorSize;
        androidx.graphics.path.PathIterator.ConicEvaluation conicEvaluation;
        androidx.graphics.path.PathIterator.ConicEvaluation asConic;
        if (includeConvertedConics) {
            asConic = PathIterator.ConicEvaluation.AsConic;
            if (getConicEvaluation() == asConic) {
                internalPathIteratorSize = internalPathIteratorRawSize(this.internalPathIterator);
            } else {
                internalPathIteratorSize = internalPathIteratorSize(this.internalPathIterator);
            }
        } else {
        }
        return internalPathIteratorSize;
    }

    @Override // androidx.graphics.path.PathIteratorImpl
    protected final void finalize() {
        destroyInternalPathIterator(this.internalPathIterator);
    }

    @Override // androidx.graphics.path.PathIteratorImpl
    public boolean hasNext() {
        return internalPathIteratorHasNext(this.internalPathIterator);
    }

    @Override // androidx.graphics.path.PathIteratorImpl
    public androidx.graphics.path.PathSegment.Type next(float[] points, int offset) {
        Intrinsics.checkNotNullParameter(points, "points");
        return PathIteratorImplKt.access$getPathSegmentTypes$p()[internalPathIteratorNext(this.internalPathIterator, obj2, points)];
    }

    @Override // androidx.graphics.path.PathIteratorImpl
    public androidx.graphics.path.PathSegment.Type peek() {
        return PathIteratorImplKt.access$getPathSegmentTypes$p()[internalPathIteratorPeek(this.internalPathIterator)];
    }
}
