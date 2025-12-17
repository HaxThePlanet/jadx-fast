package androidx.compose.ui.graphics;

import android.graphics.RenderEffect;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0008\u0010\u0007\u001a\u00020\u0008H\u0015J\u0013\u0010\t\u001a\u00020\n2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000cH\u0096\u0002J\u0008\u0010\r\u001a\u00020\u000eH\u0016J\u0008\u0010\u000f\u001a\u00020\u0010H\u0016R\u0016\u0010\u0003\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0011", d2 = {"Landroidx/compose/ui/graphics/OffsetEffect;", "Landroidx/compose/ui/graphics/RenderEffect;", "renderEffect", "offset", "Landroidx/compose/ui/geometry/Offset;", "(Landroidx/compose/ui/graphics/RenderEffect;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "createRenderEffect", "Landroid/graphics/RenderEffect;", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class OffsetEffect extends androidx.compose.ui.graphics.RenderEffect {

    private final long offset;
    private final androidx.compose.ui.graphics.RenderEffect renderEffect;
    private OffsetEffect(androidx.compose.ui.graphics.RenderEffect renderEffect, long offset) {
        super(0);
        this.renderEffect = renderEffect;
        this.offset = offset;
    }

    public OffsetEffect(androidx.compose.ui.graphics.RenderEffect renderEffect, long l2, DefaultConstructorMarker defaultConstructorMarker3) {
        super(renderEffect, l2, defaultConstructorMarker3);
    }

    @Override // androidx.compose.ui.graphics.RenderEffect
    protected RenderEffect createRenderEffect() {
        return RenderEffectVerificationHelper.INSTANCE.createOffsetEffect-Uv8p0NA(this.renderEffect, this.offset);
    }

    @Override // androidx.compose.ui.graphics.RenderEffect
    public boolean equals(Object other) {
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (!other instanceof OffsetEffect) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.renderEffect, obj2.renderEffect)) {
            return i2;
        }
        if (!Offset.equals-impl0(this.offset, obj4)) {
            return i2;
        }
        return i;
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
        return i2 += i4;
    }

    @Override // androidx.compose.ui.graphics.RenderEffect
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("OffsetEffect(renderEffect=").append(this.renderEffect).append(", offset=").append(Offset.toString-impl(this.offset)).append(')').toString();
    }
}
