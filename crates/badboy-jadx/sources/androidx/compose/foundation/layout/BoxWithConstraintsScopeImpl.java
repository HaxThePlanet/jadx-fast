package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.Dp.Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0082\u0008\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u0015\u001a\u00020\u0004HÂ\u0003J\u0016\u0010\u0016\u001a\u00020\u0006HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u0017\u0010\tJ'\u0010\u0018\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u0019\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001J\u0015\u0010#\u001a\u00020$*\u00020$2\u0006\u0010%\u001a\u00020&H\u0097\u0001J\r\u0010'\u001a\u00020$*\u00020$H\u0097\u0001R\u001c\u0010\u0005\u001a\u00020\u0006X\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\n\u001a\u0004\u0008\u0008\u0010\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\u000c8VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u000c8VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u000eR\u001a\u0010\u0011\u001a\u00020\u000c8VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0012\u0010\u000eR\u001a\u0010\u0013\u001a\u00020\u000c8VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0014\u0010\u000e\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006(", d2 = {"Landroidx/compose/foundation/layout/BoxWithConstraintsScopeImpl;", "Landroidx/compose/foundation/layout/BoxWithConstraintsScope;", "Landroidx/compose/foundation/layout/BoxScope;", "density", "Landroidx/compose/ui/unit/Density;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "(Landroidx/compose/ui/unit/Density;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getConstraints-msEJaDk", "()J", "J", "maxHeight", "Landroidx/compose/ui/unit/Dp;", "getMaxHeight-D9Ej5fM", "()F", "maxWidth", "getMaxWidth-D9Ej5fM", "minHeight", "getMinHeight-D9Ej5fM", "minWidth", "getMinWidth-D9Ej5fM", "component1", "component2", "component2-msEJaDk", "copy", "copy-0kLqBqw", "(Landroidx/compose/ui/unit/Density;J)Landroidx/compose/foundation/layout/BoxWithConstraintsScopeImpl;", "equals", "", "other", "", "hashCode", "", "toString", "", "align", "Landroidx/compose/ui/Modifier;", "alignment", "Landroidx/compose/ui/Alignment;", "matchParentSize", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class BoxWithConstraintsScopeImpl implements androidx.compose.foundation.layout.BoxWithConstraintsScope, androidx.compose.foundation.layout.BoxScope {

    private final androidx.compose.foundation.layout.BoxScopeInstance $$delegate_0;
    private final long constraints;
    private final Density density;
    private BoxWithConstraintsScopeImpl(Density density, long constraints) {
        super();
        this.density = density;
        this.constraints = constraints;
        this.$$delegate_0 = BoxScopeInstance.INSTANCE;
    }

    public BoxWithConstraintsScopeImpl(Density density, long l2, DefaultConstructorMarker defaultConstructorMarker3) {
        super(density, l2, defaultConstructorMarker3);
    }

    private final Density component1() {
        return this.density;
    }

    public static androidx.compose.foundation.layout.BoxWithConstraintsScopeImpl copy-0kLqBqw$default(androidx.compose.foundation.layout.BoxWithConstraintsScopeImpl boxWithConstraintsScopeImpl, Density density2, long l3, int i4, Object object5) {
        Density obj1;
        long obj2;
        if (object5 & 1 != 0) {
            obj1 = boxWithConstraintsScopeImpl.density;
        }
        if (object5 &= 2 != 0) {
            obj2 = boxWithConstraintsScopeImpl.constraints;
        }
        return boxWithConstraintsScopeImpl.copy-0kLqBqw(obj1, obj2);
    }

    @Override // androidx.compose.foundation.layout.BoxWithConstraintsScope
    public Modifier align(Modifier modifier, Alignment alignment2) {
        return this.$$delegate_0.align(modifier, alignment2);
    }

    @Override // androidx.compose.foundation.layout.BoxWithConstraintsScope
    public final long component2-msEJaDk() {
        return this.constraints;
    }

    @Override // androidx.compose.foundation.layout.BoxWithConstraintsScope
    public final androidx.compose.foundation.layout.BoxWithConstraintsScopeImpl copy-0kLqBqw(Density density, long l2) {
        BoxWithConstraintsScopeImpl boxWithConstraintsScopeImpl = new BoxWithConstraintsScopeImpl(density, l2, obj5, 0);
        return boxWithConstraintsScopeImpl;
    }

    @Override // androidx.compose.foundation.layout.BoxWithConstraintsScope
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof BoxWithConstraintsScopeImpl) {
            return i2;
        }
        Object obj = object;
        final Density density2 = obj.density;
        if (!Intrinsics.areEqual(this.density, density2)) {
            return i2;
        }
        if (!Constraints.equals-impl0(this.constraints, density2)) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.foundation.layout.BoxWithConstraintsScope
    public long getConstraints-msEJaDk() {
        return this.constraints;
    }

    @Override // androidx.compose.foundation.layout.BoxWithConstraintsScope
    public float getMaxHeight-D9Ej5fM() {
        float infinity-D9Ej5fM;
        final int i = 0;
        if (Constraints.getHasBoundedHeight-impl(getConstraints-msEJaDk())) {
            infinity-D9Ej5fM = this.density.toDp-u2uoSUM(Constraints.getMaxHeight-impl(getConstraints-msEJaDk()));
        } else {
            infinity-D9Ej5fM = Dp.Companion.getInfinity-D9Ej5fM();
        }
        return infinity-D9Ej5fM;
    }

    @Override // androidx.compose.foundation.layout.BoxWithConstraintsScope
    public float getMaxWidth-D9Ej5fM() {
        float infinity-D9Ej5fM;
        final int i = 0;
        if (Constraints.getHasBoundedWidth-impl(getConstraints-msEJaDk())) {
            infinity-D9Ej5fM = this.density.toDp-u2uoSUM(Constraints.getMaxWidth-impl(getConstraints-msEJaDk()));
        } else {
            infinity-D9Ej5fM = Dp.Companion.getInfinity-D9Ej5fM();
        }
        return infinity-D9Ej5fM;
    }

    @Override // androidx.compose.foundation.layout.BoxWithConstraintsScope
    public float getMinHeight-D9Ej5fM() {
        final int i = 0;
        return this.density.toDp-u2uoSUM(Constraints.getMinHeight-impl(getConstraints-msEJaDk()));
    }

    @Override // androidx.compose.foundation.layout.BoxWithConstraintsScope
    public float getMinWidth-D9Ej5fM() {
        final int i = 0;
        return this.density.toDp-u2uoSUM(Constraints.getMinWidth-impl(getConstraints-msEJaDk()));
    }

    @Override // androidx.compose.foundation.layout.BoxWithConstraintsScope
    public int hashCode() {
        return i2 += i4;
    }

    @Override // androidx.compose.foundation.layout.BoxWithConstraintsScope
    public Modifier matchParentSize(Modifier modifier) {
        return this.$$delegate_0.matchParentSize(modifier);
    }

    @Override // androidx.compose.foundation.layout.BoxWithConstraintsScope
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("BoxWithConstraintsScopeImpl(density=").append(this.density).append(", constraints=").append(Constraints.toString-impl(this.constraints)).append(')').toString();
    }
}
