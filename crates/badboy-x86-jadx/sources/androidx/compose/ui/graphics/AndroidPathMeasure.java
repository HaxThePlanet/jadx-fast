package androidx.compose.ui.graphics;

import android.graphics.PathMeasure;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset.Companion;
import androidx.compose.ui.geometry.OffsetKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0010\u0014\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001B\u000f\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001d\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\u000f\u0010\u0010J(\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0012H\u0016J\u001d\u0010\u0018\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\u0019\u0010\u0010J\u001a\u0010\u001a\u001a\u00020\u001b2\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001d\u001a\u00020\u0012H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\u0008!\n\u0005\u0008¡\u001e0\u0001¨\u0006\u001e", d2 = {"Landroidx/compose/ui/graphics/AndroidPathMeasure;", "Landroidx/compose/ui/graphics/PathMeasure;", "internalPathMeasure", "Landroid/graphics/PathMeasure;", "(Landroid/graphics/PathMeasure;)V", "length", "", "getLength", "()F", "positionArray", "", "tangentArray", "getPosition", "Landroidx/compose/ui/geometry/Offset;", "distance", "getPosition-tuRUvjQ", "(F)J", "getSegment", "", "startDistance", "stopDistance", "destination", "Landroidx/compose/ui/graphics/Path;", "startWithMoveTo", "getTangent", "getTangent-tuRUvjQ", "setPath", "", "path", "forceClosed", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AndroidPathMeasure implements androidx.compose.ui.graphics.PathMeasure {

    private final PathMeasure internalPathMeasure;
    private float[] positionArray;
    private float[] tangentArray;
    public AndroidPathMeasure(PathMeasure internalPathMeasure) {
        super();
        this.internalPathMeasure = internalPathMeasure;
    }

    @Override // androidx.compose.ui.graphics.PathMeasure
    public float getLength() {
        return this.internalPathMeasure.getLength();
    }

    @Override // androidx.compose.ui.graphics.PathMeasure
    public long getPosition-tuRUvjQ(float distance) {
        float[] positionArray;
        float[] tangentArray2;
        long unspecified-F1C5BW0;
        float[] tangentArray;
        int i;
        int i2 = 2;
        if (this.positionArray == null) {
            this.positionArray = new float[i2];
        }
        if (this.tangentArray == null) {
            this.tangentArray = new float[i2];
        }
        if (this.internalPathMeasure.getPosTan(distance, this.positionArray, this.tangentArray)) {
            float[] positionArray3 = this.positionArray;
            Intrinsics.checkNotNull(positionArray3);
            float[] positionArray4 = this.positionArray;
            Intrinsics.checkNotNull(positionArray4);
            unspecified-F1C5BW0 = OffsetKt.Offset(positionArray3[0], positionArray4[1]);
        } else {
            unspecified-F1C5BW0 = Offset.Companion.getUnspecified-F1C5BW0();
        }
        return unspecified-F1C5BW0;
    }

    @Override // androidx.compose.ui.graphics.PathMeasure
    public boolean getSegment(float startDistance, float stopDistance, androidx.compose.ui.graphics.Path destination, boolean startWithMoveTo) {
        final Object obj = destination;
        final int i = 0;
        if (obj instanceof AndroidPath == null) {
        } else {
            return this.internalPathMeasure.getSegment(startDistance, stopDistance, (AndroidPath)obj.getInternalPath(), startWithMoveTo);
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        throw unsupportedOperationException;
    }

    @Override // androidx.compose.ui.graphics.PathMeasure
    public long getTangent-tuRUvjQ(float distance) {
        float[] positionArray;
        float[] tangentArray2;
        long unspecified-F1C5BW0;
        float[] tangentArray;
        int i;
        int i2 = 2;
        if (this.positionArray == null) {
            this.positionArray = new float[i2];
        }
        if (this.tangentArray == null) {
            this.tangentArray = new float[i2];
        }
        if (this.internalPathMeasure.getPosTan(distance, this.positionArray, this.tangentArray)) {
            float[] tangentArray3 = this.tangentArray;
            Intrinsics.checkNotNull(tangentArray3);
            float[] tangentArray4 = this.tangentArray;
            Intrinsics.checkNotNull(tangentArray4);
            unspecified-F1C5BW0 = OffsetKt.Offset(tangentArray3[0], tangentArray4[1]);
        } else {
            unspecified-F1C5BW0 = Offset.Companion.getUnspecified-F1C5BW0();
        }
        return unspecified-F1C5BW0;
    }

    @Override // androidx.compose.ui.graphics.PathMeasure
    public void setPath(androidx.compose.ui.graphics.Path path, boolean forceClosed) {
        Object obj;
        int i;
        android.graphics.Path internalPath;
        if (path != null) {
            obj = path;
            i = 0;
            if (obj instanceof AndroidPath == null) {
            } else {
                internalPath = (AndroidPath)obj.getInternalPath();
                this.internalPathMeasure.setPath(internalPath, forceClosed);
            }
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Unable to obtain android.graphics.Path");
            throw unsupportedOperationException;
        }
        internalPath = 0;
    }
}
