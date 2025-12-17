package androidx.compose.material;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0081\u0008\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u001a\u0008\u0002\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\u0010\nJ2\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00082\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0016H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u001a\u0010\u001bJ\u0016\u0010\u001c\u001a\u00020\u0003HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u001d\u0010\u000cJ\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\u001b\u0010\u001f\u001a\u0014\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\t0\u0007HÆ\u0003JC\u0010 \u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u001a\u0008\u0002\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\t0\u0007HÆ\u0001ø\u0001\u0000¢\u0006\u0004\u0008!\u0010\"J\u0013\u0010#\u001a\u00020$2\u0008\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020*HÖ\u0001R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\r\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR#\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006+", d2 = {"Landroidx/compose/material/DropdownMenuPositionProvider;", "Landroidx/compose/ui/window/PopupPositionProvider;", "contentOffset", "Landroidx/compose/ui/unit/DpOffset;", "density", "Landroidx/compose/ui/unit/Density;", "onPositionCalculated", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/IntRect;", "", "(JLandroidx/compose/ui/unit/Density;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getContentOffset-RKDOV3M", "()J", "J", "getDensity", "()Landroidx/compose/ui/unit/Density;", "getOnPositionCalculated", "()Lkotlin/jvm/functions/Function2;", "calculatePosition", "Landroidx/compose/ui/unit/IntOffset;", "anchorBounds", "windowSize", "Landroidx/compose/ui/unit/IntSize;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "popupContentSize", "calculatePosition-llwVHH4", "(Landroidx/compose/ui/unit/IntRect;JLandroidx/compose/ui/unit/LayoutDirection;J)J", "component1", "component1-RKDOV3M", "component2", "component3", "copy", "copy-rOJDEFc", "(JLandroidx/compose/ui/unit/Density;Lkotlin/jvm/functions/Function2;)Landroidx/compose/material/DropdownMenuPositionProvider;", "equals", "", "other", "", "hashCode", "", "toString", "", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DropdownMenuPositionProvider implements PopupPositionProvider {

    public static final int $stable;
    private final long contentOffset;
    private final Density density;
    private final Function2<IntRect, IntRect, Unit> onPositionCalculated;
    static {
    }

    private DropdownMenuPositionProvider(long contentOffset, Density density, Function2<? super IntRect, ? super IntRect, Unit> onPositionCalculated) {
        super();
        this.contentOffset = contentOffset;
        this.density = onPositionCalculated;
        this.onPositionCalculated = obj4;
    }

    public DropdownMenuPositionProvider(long l, Density density2, Function2 function23, int i4, DefaultConstructorMarker defaultConstructorMarker5) {
        androidx.compose.material.DropdownMenuPositionProvider.1 anon;
        androidx.compose.material.DropdownMenuPositionProvider.1 obj10;
        if (defaultConstructorMarker5 &= 4 != 0) {
            anon = obj10;
        } else {
            anon = i4;
        }
        super(l, obj2, function23, anon, 0);
    }

    public DropdownMenuPositionProvider(long l, Density density2, Function2 function23, DefaultConstructorMarker defaultConstructorMarker4) {
        super(l, density2, function23, defaultConstructorMarker4);
    }

    public static androidx.compose.material.DropdownMenuPositionProvider copy-rOJDEFc$default(androidx.compose.material.DropdownMenuPositionProvider dropdownMenuPositionProvider, long l2, Density density3, Function2 function24, int i5, Object object6) {
        long obj1;
        Density obj3;
        Function2 obj4;
        if (object6 & 1 != 0) {
            obj1 = dropdownMenuPositionProvider.contentOffset;
        }
        if (object6 & 2 != 0) {
            obj3 = dropdownMenuPositionProvider.density;
        }
        if (object6 &= 4 != 0) {
            obj4 = dropdownMenuPositionProvider.onPositionCalculated;
        }
        return dropdownMenuPositionProvider.copy-rOJDEFc(obj1, density3, obj3);
    }

    @Override // androidx.compose.ui.window.PopupPositionProvider
    public long calculatePosition-llwVHH4(IntRect anchorBounds, long windowSize, LayoutDirection layoutDirection, long popupContentSize) {
        LayoutDirection layoutDirection2;
        int intValue4;
        int $this$calculatePosition_llwVHH4_u24lambda_u240;
        int i5;
        int i2;
        int intValue3;
        Sequence sequenceOf;
        int width-impl2;
        int intValue2;
        Integer valueOf;
        int i3;
        int i6;
        int width-impl;
        Object next;
        int i4;
        int intValue;
        int next2;
        int i;
        int i7;
        int height-impl;
        int verticalMargin;
        Object obj = this;
        layoutDirection2 = popupContentSize;
        int i9 = 0;
        $this$calculatePosition_llwVHH4_u24lambda_u240 = obj.density.roundToPx-0680j_4(MenuKt.getMenuVerticalMargin());
        int i10 = 0;
        i2 = 1;
        i5 = layoutDirection2 == LayoutDirection.Ltr ? i2 : -1;
        roundToPx-0680j_4 *= i5;
        int i11 = 0;
        int $this$calculatePosition_llwVHH4_u24lambda_u242 = obj.density.roundToPx-0680j_4(DpOffset.getY-D9Ej5fM(obj.contentOffset));
        left += i13;
        i14 += i13;
        width-impl4 -= width-impl5;
        int i17 = 0;
        width-impl2 = 3;
        int i22 = 2;
        intValue2 = 0;
        if (layoutDirection2 == LayoutDirection.Ltr) {
            Integer[] arr2 = new Integer[width-impl2];
            arr2[intValue2] = Integer.valueOf(i12);
            arr2[i2] = Integer.valueOf(i15);
            i6 = anchorBounds.getLeft() >= 0 ? i16 : i17;
            arr2[i22] = Integer.valueOf(i6);
            sequenceOf = SequencesKt.sequenceOf(arr2);
        } else {
            Integer[] arr = new Integer[width-impl2];
            arr[intValue2] = Integer.valueOf(i15);
            arr[i2] = Integer.valueOf(i12);
            i3 = anchorBounds.getRight() <= IntSize.getWidth-impl(windowSize) ? i17 : i16;
            arr[i22] = Integer.valueOf(i3);
            sequenceOf = SequencesKt.sequenceOf(arr);
        }
        int i25 = 0;
        Iterator iterator = sequenceOf.iterator();
        while (iterator.hasNext()) {
            intValue = (Number)iterator.next().intValue();
            next2 = 0;
            if (intValue >= 0) {
            } else {
            }
            i7 = i2;
            i = width-impl2;
            i2 = intValue2;
            width-impl2 = i;
            i2 = i7;
            i = width-impl2;
            if (intValue + width-impl7 <= IntSize.getWidth-impl(windowSize)) {
            } else {
            }
            i2 = i7;
        }
        i7 = i2;
        i = width-impl2;
        next = i4;
        if ((Integer)next != 0) {
            intValue3 = (Integer)next.intValue();
        } else {
            intValue3 = i15;
        }
        i20 += $this$calculatePosition_llwVHH4_u24lambda_u242;
        Integer[] arr3 = new Integer[4];
        arr3[intValue2] = Integer.valueOf(Math.max(bottom += $this$calculatePosition_llwVHH4_u24lambda_u242, $this$calculatePosition_llwVHH4_u24lambda_u240));
        arr3[i7] = Integer.valueOf(i21);
        arr3[i22] = Integer.valueOf(i26 += $this$calculatePosition_llwVHH4_u24lambda_u242);
        arr3[i] = Integer.valueOf(i29 -= $this$calculatePosition_llwVHH4_u24lambda_u240);
        int i32 = 0;
        Iterator iterator2 = SequencesKt.sequenceOf(arr3).iterator();
        while (iterator2.hasNext()) {
            next2 = iterator2.next();
            intValue2 = (Number)next2.intValue();
            i = 0;
            if (intValue2 >= $this$calculatePosition_llwVHH4_u24lambda_u240) {
            } else {
            }
            verticalMargin = $this$calculatePosition_llwVHH4_u24lambda_u240;
            layoutDirection2 = 0;
            layoutDirection2 = popupContentSize;
            $this$calculatePosition_llwVHH4_u24lambda_u240 = verticalMargin;
            intValue2 = 0;
            if (intValue2 + height-impl7 <= height-impl - verticalMargin) {
            } else {
            }
            layoutDirection2 = i7;
        }
        verticalMargin = $this$calculatePosition_llwVHH4_u24lambda_u240;
        if ((Integer)i4 != 0) {
            intValue4 = (Integer)i4.intValue();
        } else {
            intValue4 = i21;
        }
        IntRect intRect = new IntRect(intValue3, intValue4, width-impl6 += intValue3, intValue4 + height-impl6);
        obj.onPositionCalculated.invoke(anchorBounds, intRect);
        return IntOffsetKt.IntOffset(intValue3, intValue4);
    }

    @Override // androidx.compose.ui.window.PopupPositionProvider
    public final long component1-RKDOV3M() {
        return this.contentOffset;
    }

    @Override // androidx.compose.ui.window.PopupPositionProvider
    public final Density component2() {
        return this.density;
    }

    public final Function2<IntRect, IntRect, Unit> component3() {
        return this.onPositionCalculated;
    }

    public final androidx.compose.material.DropdownMenuPositionProvider copy-rOJDEFc(long l, Density density2, Function2<? super IntRect, ? super IntRect, Unit> function23) {
        DropdownMenuPositionProvider dropdownMenuPositionProvider = new DropdownMenuPositionProvider(l, obj2, function23, obj10, 0);
        return dropdownMenuPositionProvider;
    }

    @Override // androidx.compose.ui.window.PopupPositionProvider
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (object instanceof DropdownMenuPositionProvider == null) {
            return i2;
        }
        Object obj = object;
        if (!DpOffset.equals-impl0(this.contentOffset, obj4)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.density, obj.density)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.onPositionCalculated, obj.onPositionCalculated)) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.ui.window.PopupPositionProvider
    public final long getContentOffset-RKDOV3M() {
        return this.contentOffset;
    }

    @Override // androidx.compose.ui.window.PopupPositionProvider
    public final Density getDensity() {
        return this.density;
    }

    public final Function2<IntRect, IntRect, Unit> getOnPositionCalculated() {
        return this.onPositionCalculated;
    }

    @Override // androidx.compose.ui.window.PopupPositionProvider
    public int hashCode() {
        return i2 += i7;
    }

    @Override // androidx.compose.ui.window.PopupPositionProvider
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("DropdownMenuPositionProvider(contentOffset=").append(DpOffset.toString-impl(this.contentOffset)).append(", density=").append(this.density).append(", onPositionCalculated=").append(this.onPositionCalculated).append(')').toString();
    }
}
