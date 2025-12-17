package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0000\u0008\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\u000b\u001a\u00020\u000c2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0008\u0010\u0018\u001a\u00020\u0010H\u0016J\u0008\u0010\u0019\u001a\u00020\u001aH\u0016R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\n\u001a\u0004\u0008\u0008\u0010\t\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u001b", d2 = {"Landroidx/compose/foundation/layout/LimitInsets;", "Landroidx/compose/foundation/layout/WindowInsets;", "insets", "sides", "Landroidx/compose/foundation/layout/WindowInsetsSides;", "(Landroidx/compose/foundation/layout/WindowInsets;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getInsets", "()Landroidx/compose/foundation/layout/WindowInsets;", "getSides-JoeWqyM", "()I", "I", "equals", "", "other", "", "getBottom", "", "density", "Landroidx/compose/ui/unit/Density;", "getLeft", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getRight", "getTop", "hashCode", "toString", "", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class LimitInsets implements androidx.compose.foundation.layout.WindowInsets {

    private final androidx.compose.foundation.layout.WindowInsets insets;
    private final int sides;
    private LimitInsets(androidx.compose.foundation.layout.WindowInsets insets, int sides) {
        super();
        this.insets = insets;
        this.sides = sides;
    }

    public LimitInsets(androidx.compose.foundation.layout.WindowInsets windowInsets, int i2, DefaultConstructorMarker defaultConstructorMarker3) {
        super(windowInsets, i2);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public boolean equals(Object other) {
        int i;
        boolean equal;
        androidx.compose.foundation.layout.WindowInsets insets;
        if (this == other) {
            return 1;
        }
        final int i2 = 0;
        if (!other instanceof LimitInsets) {
            return i2;
        }
        if (Intrinsics.areEqual(this.insets, obj.insets) && WindowInsetsSides.equals-impl0(this.sides, obj2.sides)) {
            if (WindowInsetsSides.equals-impl0(this.sides, obj2.sides)) {
            } else {
                i = i2;
            }
        } else {
        }
        return i;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getBottom(Density density) {
        int bottom;
        if (WindowInsetsSides.hasAny-bkgdKaI$foundation_layout_release(this.sides, WindowInsetsSides.Companion.getBottom-JoeWqyM())) {
            bottom = this.insets.getBottom(density);
        } else {
            bottom = 0;
        }
        return bottom;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public final androidx.compose.foundation.layout.WindowInsets getInsets() {
        return this.insets;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getLeft(Density density, LayoutDirection layoutDirection) {
        int allowLeftInLtr-JoeWqyM$foundation_layout_release;
        int left;
        if (layoutDirection == LayoutDirection.Ltr) {
            allowLeftInLtr-JoeWqyM$foundation_layout_release = WindowInsetsSides.Companion.getAllowLeftInLtr-JoeWqyM$foundation_layout_release();
        } else {
            allowLeftInLtr-JoeWqyM$foundation_layout_release = WindowInsetsSides.Companion.getAllowLeftInRtl-JoeWqyM$foundation_layout_release();
        }
        if (WindowInsetsSides.hasAny-bkgdKaI$foundation_layout_release(this.sides, allowLeftInLtr-JoeWqyM$foundation_layout_release)) {
            left = this.insets.getLeft(density, layoutDirection);
        } else {
            left = 0;
        }
        return left;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getRight(Density density, LayoutDirection layoutDirection) {
        int allowRightInLtr-JoeWqyM$foundation_layout_release;
        int right;
        if (layoutDirection == LayoutDirection.Ltr) {
            allowRightInLtr-JoeWqyM$foundation_layout_release = WindowInsetsSides.Companion.getAllowRightInLtr-JoeWqyM$foundation_layout_release();
        } else {
            allowRightInLtr-JoeWqyM$foundation_layout_release = WindowInsetsSides.Companion.getAllowRightInRtl-JoeWqyM$foundation_layout_release();
        }
        if (WindowInsetsSides.hasAny-bkgdKaI$foundation_layout_release(this.sides, allowRightInLtr-JoeWqyM$foundation_layout_release)) {
            right = this.insets.getRight(density, layoutDirection);
        } else {
            right = 0;
        }
        return right;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public final int getSides-JoeWqyM() {
        return this.sides;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getTop(Density density) {
        int top;
        if (WindowInsetsSides.hasAny-bkgdKaI$foundation_layout_release(this.sides, WindowInsetsSides.Companion.getTop-JoeWqyM())) {
            top = this.insets.getTop(density);
        } else {
            top = 0;
        }
        return top;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int hashCode() {
        return i2 += i4;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append('(').append(this.insets).append(" only ").append(WindowInsetsSides.toString-impl(this.sides)).append(')').toString();
    }
}
