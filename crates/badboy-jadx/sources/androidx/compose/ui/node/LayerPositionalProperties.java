package androidx.compose.ui.node;

import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.graphics.TransformOrigin.Companion;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\u0008\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0000J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\u00020\u000bX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000cR\u000e\u0010\r\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0016", d2 = {"Landroidx/compose/ui/node/LayerPositionalProperties;", "", "()V", "cameraDistance", "", "rotationX", "rotationY", "rotationZ", "scaleX", "scaleY", "transformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "J", "translationX", "translationY", "copyFrom", "", "scope", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "other", "hasSameValuesAs", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class LayerPositionalProperties {

    private float cameraDistance = 8f;
    private float rotationX;
    private float rotationY;
    private float rotationZ;
    private float scaleX = 1f;
    private float scaleY = 1f;
    private long transformOrigin;
    private float translationX;
    private float translationY;
    public LayerPositionalProperties() {
        super();
        int i = 1065353216;
        int i2 = 1090519040;
        this.transformOrigin = TransformOrigin.Companion.getCenter-SzJe1aQ();
    }

    public final void copyFrom(GraphicsLayerScope scope) {
        this.scaleX = scope.getScaleX();
        this.scaleY = scope.getScaleY();
        this.translationX = scope.getTranslationX();
        this.translationY = scope.getTranslationY();
        this.rotationX = scope.getRotationX();
        this.rotationY = scope.getRotationY();
        this.rotationZ = scope.getRotationZ();
        this.cameraDistance = scope.getCameraDistance();
        this.transformOrigin = scope.getTransformOrigin-SzJe1aQ();
    }

    public final void copyFrom(androidx.compose.ui.node.LayerPositionalProperties other) {
        this.scaleX = other.scaleX;
        this.scaleY = other.scaleY;
        this.translationX = other.translationX;
        this.translationY = other.translationY;
        this.rotationX = other.rotationX;
        this.rotationY = other.rotationY;
        this.rotationZ = other.rotationZ;
        this.cameraDistance = other.cameraDistance;
        this.transformOrigin = other.transformOrigin;
    }

    public final boolean hasSameValuesAs(androidx.compose.ui.node.LayerPositionalProperties other) {
        int equals-impl0;
        int i;
        float transformOrigin;
        long transformOrigin2;
        i = 1;
        final int i2 = 0;
        equals-impl0 = Float.compare(scaleX, scaleX2) == 0 ? i : i2;
        if (equals-impl0 != 0) {
            equals-impl0 = Float.compare(scaleY, transformOrigin) == 0 ? i : i2;
            if (equals-impl0 != 0) {
                equals-impl0 = Float.compare(translationX, transformOrigin) == 0 ? i : i2;
                if (equals-impl0 != 0) {
                    equals-impl0 = Float.compare(translationY, transformOrigin) == 0 ? i : i2;
                    if (equals-impl0 != 0) {
                        equals-impl0 = Float.compare(rotationX, transformOrigin) == 0 ? i : i2;
                        if (equals-impl0 != 0) {
                            equals-impl0 = Float.compare(rotationY, transformOrigin) == 0 ? i : i2;
                            if (equals-impl0 != 0) {
                                equals-impl0 = Float.compare(rotationZ, transformOrigin) == 0 ? i : i2;
                                if (equals-impl0 != 0) {
                                    equals-impl0 = Float.compare(cameraDistance, transformOrigin) == 0 ? i : i2;
                                    if (equals-impl0 != 0 && TransformOrigin.equals-impl0(this.transformOrigin, obj4)) {
                                        if (TransformOrigin.equals-impl0(this.transformOrigin, obj4)) {
                                        } else {
                                            i = i2;
                                        }
                                    } else {
                                    }
                                } else {
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }
}
