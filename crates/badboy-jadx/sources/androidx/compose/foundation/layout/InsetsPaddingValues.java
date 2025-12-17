package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0015\u0010\t\u001a\u00020\nH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\u000b\u0010\u000cJ\u001d\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\u0010\u0010\u0011J\u001d\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\u0013\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\nH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\u0015\u0010\u000cJ\u0013\u0010\u0016\u001a\u00020\u00172\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0096\u0002J\u0008\u0010\u001a\u001a\u00020\u001bH\u0016J\u0008\u0010\u001c\u001a\u00020\u001dH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008\u0082\u0002\u000b\n\u0002\u0008!\n\u0005\u0008¡\u001e0\u0001¨\u0006\u001e", d2 = {"Landroidx/compose/foundation/layout/InsetsPaddingValues;", "Landroidx/compose/foundation/layout/PaddingValues;", "insets", "Landroidx/compose/foundation/layout/WindowInsets;", "density", "Landroidx/compose/ui/unit/Density;", "(Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/ui/unit/Density;)V", "getInsets", "()Landroidx/compose/foundation/layout/WindowInsets;", "calculateBottomPadding", "Landroidx/compose/ui/unit/Dp;", "calculateBottomPadding-D9Ej5fM", "()F", "calculateLeftPadding", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "calculateLeftPadding-u2uoSUM", "(Landroidx/compose/ui/unit/LayoutDirection;)F", "calculateRightPadding", "calculateRightPadding-u2uoSUM", "calculateTopPadding", "calculateTopPadding-D9Ej5fM", "equals", "", "other", "", "hashCode", "", "toString", "", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class InsetsPaddingValues implements androidx.compose.foundation.layout.PaddingValues {

    private final Density density;
    private final androidx.compose.foundation.layout.WindowInsets insets;
    public InsetsPaddingValues(androidx.compose.foundation.layout.WindowInsets insets, Density density) {
        super();
        this.insets = insets;
        this.density = density;
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    public float calculateBottomPadding-D9Ej5fM() {
        Density density = this.density;
        final int i = 0;
        return density.toDp-u2uoSUM(this.insets.getBottom(density));
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    public float calculateLeftPadding-u2uoSUM(LayoutDirection layoutDirection) {
        Density density = this.density;
        final int i = 0;
        return density.toDp-u2uoSUM(this.insets.getLeft(density, layoutDirection));
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    public float calculateRightPadding-u2uoSUM(LayoutDirection layoutDirection) {
        Density density = this.density;
        final int i = 0;
        return density.toDp-u2uoSUM(this.insets.getRight(density, layoutDirection));
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    public float calculateTopPadding-D9Ej5fM() {
        Density density = this.density;
        final int i = 0;
        return density.toDp-u2uoSUM(this.insets.getTop(density));
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    public boolean equals(Object other) {
        int i;
        boolean equal;
        Object density;
        if (this == other) {
            return 1;
        }
        final int i2 = 0;
        if (!other instanceof InsetsPaddingValues) {
            return i2;
        }
        if (Intrinsics.areEqual(this.insets, obj.insets) && Intrinsics.areEqual(this.density, obj2.density)) {
            if (Intrinsics.areEqual(this.density, obj2.density)) {
            } else {
                i = i2;
            }
        } else {
        }
        return i;
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    public final androidx.compose.foundation.layout.WindowInsets getInsets() {
        return this.insets;
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    public int hashCode() {
        return i2 += i4;
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("InsetsPaddingValues(insets=").append(this.insets).append(", density=").append(this.density).append(')').toString();
    }
}
