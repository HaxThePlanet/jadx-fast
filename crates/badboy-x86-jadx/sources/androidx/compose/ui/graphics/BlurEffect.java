package androidx.compose.ui.graphics;

import android.graphics.RenderEffect;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0007\u0018\u00002\u00020\u0001B+\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0008\u0010\n\u001a\u00020\u000bH\u0015J\u0013\u0010\u000c\u001a\u00020\r2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\u0008\u0010\u0010\u001a\u00020\u0011H\u0016J\u0008\u0010\u0012\u001a\u00020\u0013H\u0016R\u0016\u0010\u0006\u001a\u00020\u0007X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0014", d2 = {"Landroidx/compose/ui/graphics/BlurEffect;", "Landroidx/compose/ui/graphics/RenderEffect;", "renderEffect", "radiusX", "", "radiusY", "edgeTreatment", "Landroidx/compose/ui/graphics/TileMode;", "(Landroidx/compose/ui/graphics/RenderEffect;FFILkotlin/jvm/internal/DefaultConstructorMarker;)V", "I", "createRenderEffect", "Landroid/graphics/RenderEffect;", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BlurEffect extends androidx.compose.ui.graphics.RenderEffect {

    private final int edgeTreatment;
    private final float radiusX;
    private final float radiusY;
    private final androidx.compose.ui.graphics.RenderEffect renderEffect;
    private BlurEffect(androidx.compose.ui.graphics.RenderEffect renderEffect, float radiusX, float radiusY, int edgeTreatment) {
        super(0);
        this.renderEffect = renderEffect;
        this.radiusX = radiusX;
        this.radiusY = radiusY;
        this.edgeTreatment = edgeTreatment;
    }

    public BlurEffect(androidx.compose.ui.graphics.RenderEffect renderEffect, float f2, float f3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker6) {
        float f;
        int i;
        int obj9;
        int obj10;
        f = i5 & 4 != 0 ? f2 : f3;
        if (i5 & 8 != 0) {
            i = obj10;
        } else {
            i = i4;
        }
        super(renderEffect, f2, f, i, 0);
    }

    public BlurEffect(androidx.compose.ui.graphics.RenderEffect renderEffect, float f2, float f3, int i4, DefaultConstructorMarker defaultConstructorMarker5) {
        super(renderEffect, f2, f3, i4);
    }

    @Override // androidx.compose.ui.graphics.RenderEffect
    protected RenderEffect createRenderEffect() {
        return RenderEffectVerificationHelper.INSTANCE.createBlurEffect-8A-3gB4(this.renderEffect, this.radiusX, this.radiusY, this.edgeTreatment);
    }

    @Override // androidx.compose.ui.graphics.RenderEffect
    public boolean equals(Object other) {
        int i;
        int i2;
        final int i3 = 1;
        if (this == other) {
            return i3;
        }
        final int i4 = 0;
        if (!other instanceof BlurEffect) {
            return i4;
        }
        i = Float.compare(radiusX, radiusX2) == 0 ? i3 : i4;
        if (i == 0) {
            return i4;
        }
        i2 = Float.compare(radiusY, radiusY2) == 0 ? i3 : i4;
        if (i2 == 0) {
            return i4;
        }
        if (!TileMode.equals-impl0(this.edgeTreatment, obj3.edgeTreatment)) {
            return i4;
        }
        if (!Intrinsics.areEqual(this.renderEffect, obj4.renderEffect)) {
            return i4;
        }
        return i3;
    }

    @Override // androidx.compose.ui.graphics.RenderEffect
    public int hashCode() {
        int i;
        androidx.compose.ui.graphics.RenderEffect renderEffect = this.renderEffect;
        if (renderEffect != null) {
            i = renderEffect.hashCode();
        } else {
            i = 0;
        }
        return result2 += i8;
    }

    @Override // androidx.compose.ui.graphics.RenderEffect
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("BlurEffect(renderEffect=").append(this.renderEffect).append(", radiusX=").append(this.radiusX).append(", radiusY=").append(this.radiusY).append(", edgeTreatment=").append(TileMode.toString-impl(this.edgeTreatment)).append(')').toString();
    }
}
