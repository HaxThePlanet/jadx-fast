package androidx.compose.material3.internal;

import androidx.compose.material3.MenuKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntRectKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0008\u0081\u0008\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007\u00128\u0008\u0002\u0010\u0008\u001a2\u0012\u0013\u0012\u00110\n¢\u0006\u000c\u0008\u000b\u0012\u0008\u0008\u000c\u0012\u0004\u0008\u0008(\r\u0012\u0013\u0012\u00110\n¢\u0006\u000c\u0008\u000b\u0012\u0008\u0008\u000c\u0012\u0004\u0008\u0008(\u000e\u0012\u0004\u0012\u00020\u000f0\t¢\u0006\u0002\u0010\u0010J2\u0010%\u001a\u00020&2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020(H\u0016ø\u0001\u0000¢\u0006\u0004\u0008,\u0010-J\u0016\u0010.\u001a\u00020\u0003HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008/\u0010\u0016J\t\u00100\u001a\u00020\u0005HÆ\u0003J\t\u00101\u001a\u00020\u0007HÆ\u0003J9\u00102\u001a2\u0012\u0013\u0012\u00110\n¢\u0006\u000c\u0008\u000b\u0012\u0008\u0008\u000c\u0012\u0004\u0008\u0008(\r\u0012\u0013\u0012\u00110\n¢\u0006\u000c\u0008\u000b\u0012\u0008\u0008\u000c\u0012\u0004\u0008\u0008(\u000e\u0012\u0004\u0012\u00020\u000f0\tHÆ\u0003Jk\u00103\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u000728\u0008\u0002\u0010\u0008\u001a2\u0012\u0013\u0012\u00110\n¢\u0006\u000c\u0008\u000b\u0012\u0008\u0008\u000c\u0012\u0004\u0008\u0008(\r\u0012\u0013\u0012\u00110\n¢\u0006\u000c\u0008\u000b\u0012\u0008\u0008\u000c\u0012\u0004\u0008\u0008(\u000e\u0012\u0004\u0012\u00020\u000f0\tHÆ\u0001ø\u0001\u0000¢\u0006\u0004\u00084\u00105J\u0013\u00106\u001a\u0002072\u0008\u00108\u001a\u0004\u0018\u000109HÖ\u0003J\t\u0010:\u001a\u00020\u0007HÖ\u0001J\t\u0010;\u001a\u00020<HÖ\u0001R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\u0008\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000RA\u0010\u0008\u001a2\u0012\u0013\u0012\u00110\n¢\u0006\u000c\u0008\u000b\u0012\u0008\u0008\u000c\u0012\u0004\u0008\u0008(\r\u0012\u0013\u0012\u00110\n¢\u0006\u000c\u0008\u000b\u0012\u0008\u0008\u000c\u0012\u0004\u0008\u0008(\u000e\u0012\u0004\u0012\u00020\u000f0\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008#\u0010$\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006=", d2 = {"Landroidx/compose/material3/internal/DropdownMenuPositionProvider;", "Landroidx/compose/ui/window/PopupPositionProvider;", "contentOffset", "Landroidx/compose/ui/unit/DpOffset;", "density", "Landroidx/compose/ui/unit/Density;", "verticalMargin", "", "onPositionCalculated", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/IntRect;", "Lkotlin/ParameterName;", "name", "anchorBounds", "menuBounds", "", "(JLandroidx/compose/ui/unit/Density;ILkotlin/jvm/functions/Function2;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "bottomToAnchorTop", "Landroidx/compose/material3/internal/MenuPosition$Vertical;", "bottomToWindowBottom", "centerToAnchorTop", "getContentOffset-RKDOV3M", "()J", "J", "getDensity", "()Landroidx/compose/ui/unit/Density;", "endToAnchorEnd", "Landroidx/compose/material3/internal/MenuPosition$Horizontal;", "leftToWindowLeft", "getOnPositionCalculated", "()Lkotlin/jvm/functions/Function2;", "rightToWindowRight", "startToAnchorStart", "topToAnchorBottom", "topToWindowTop", "getVerticalMargin", "()I", "calculatePosition", "Landroidx/compose/ui/unit/IntOffset;", "windowSize", "Landroidx/compose/ui/unit/IntSize;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "popupContentSize", "calculatePosition-llwVHH4", "(Landroidx/compose/ui/unit/IntRect;JLandroidx/compose/ui/unit/LayoutDirection;J)J", "component1", "component1-RKDOV3M", "component2", "component3", "component4", "copy", "copy-uVxBXkw", "(JLandroidx/compose/ui/unit/Density;ILkotlin/jvm/functions/Function2;)Landroidx/compose/material3/internal/DropdownMenuPositionProvider;", "equals", "", "other", "", "hashCode", "toString", "", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DropdownMenuPositionProvider implements PopupPositionProvider {

    public static final int $stable;
    private final androidx.compose.material3.internal.MenuPosition.Vertical bottomToAnchorTop;
    private final androidx.compose.material3.internal.MenuPosition.Vertical bottomToWindowBottom;
    private final androidx.compose.material3.internal.MenuPosition.Vertical centerToAnchorTop;
    private final long contentOffset;
    private final Density density;
    private final androidx.compose.material3.internal.MenuPosition.Horizontal endToAnchorEnd;
    private final androidx.compose.material3.internal.MenuPosition.Horizontal leftToWindowLeft;
    private final Function2<IntRect, IntRect, Unit> onPositionCalculated;
    private final androidx.compose.material3.internal.MenuPosition.Horizontal rightToWindowRight;
    private final androidx.compose.material3.internal.MenuPosition.Horizontal startToAnchorStart;
    private final androidx.compose.material3.internal.MenuPosition.Vertical topToAnchorBottom;
    private final androidx.compose.material3.internal.MenuPosition.Vertical topToWindowTop;
    private final int verticalMargin;
    static {
    }

    private DropdownMenuPositionProvider(long contentOffset, Density density, int verticalMargin, Function2<? super IntRect, ? super IntRect, Unit> onPositionCalculated) {
        super();
        this.contentOffset = contentOffset;
        this.density = verticalMargin;
        this.verticalMargin = onPositionCalculated;
        this.onPositionCalculated = obj10;
        int i = 0;
        int $this$_init__u24lambda_u241 = this.density.roundToPx-0680j_4(DpOffset.getX-D9Ej5fM(this.contentOffset));
        this.startToAnchorStart = MenuPosition.INSTANCE.startToAnchorStart($this$_init__u24lambda_u241);
        this.endToAnchorEnd = MenuPosition.INSTANCE.endToAnchorEnd($this$_init__u24lambda_u241);
        int i2 = 0;
        this.leftToWindowLeft = MenuPosition.INSTANCE.leftToWindowLeft(i2);
        this.rightToWindowRight = MenuPosition.INSTANCE.rightToWindowRight(i2);
        int i3 = 0;
        int $this$_init__u24lambda_u242 = this.density.roundToPx-0680j_4(DpOffset.getY-D9Ej5fM(this.contentOffset));
        this.topToAnchorBottom = MenuPosition.INSTANCE.topToAnchorBottom($this$_init__u24lambda_u242);
        this.bottomToAnchorTop = MenuPosition.INSTANCE.bottomToAnchorTop($this$_init__u24lambda_u242);
        this.centerToAnchorTop = MenuPosition.INSTANCE.centerToAnchorTop($this$_init__u24lambda_u242);
        this.topToWindowTop = MenuPosition.INSTANCE.topToWindowTop(this.verticalMargin);
        this.bottomToWindowBottom = MenuPosition.INSTANCE.bottomToWindowBottom(this.verticalMargin);
    }

    public DropdownMenuPositionProvider(long l, Density density2, int i3, Function2 function24, int i5, DefaultConstructorMarker defaultConstructorMarker6) {
        float menuVerticalMargin;
        int i;
        androidx.compose.material3.internal.DropdownMenuPositionProvider.2 anon;
        int obj11;
        androidx.compose.material3.internal.DropdownMenuPositionProvider.2 obj12;
        int obj14;
        if (defaultConstructorMarker6 & 4 != 0) {
            obj14 = 0;
            i = obj11;
        } else {
            i = function24;
        }
        if (defaultConstructorMarker6 & 8 != 0) {
            anon = obj12;
        } else {
            anon = i5;
        }
        super(l, obj2, i3, i, anon, 0);
    }

    public DropdownMenuPositionProvider(long l, Density density2, int i3, Function2 function24, DefaultConstructorMarker defaultConstructorMarker5) {
        super(l, density2, i3, function24, defaultConstructorMarker5);
    }

    public static androidx.compose.material3.internal.DropdownMenuPositionProvider copy-uVxBXkw$default(androidx.compose.material3.internal.DropdownMenuPositionProvider dropdownMenuPositionProvider, long l2, Density density3, int i4, Function2 function25, int i6, Object object7) {
        long obj7;
        Density obj9;
        int obj10;
        Function2 obj11;
        if (object7 & 1 != 0) {
            obj7 = dropdownMenuPositionProvider.contentOffset;
        }
        if (object7 & 2 != 0) {
            obj9 = dropdownMenuPositionProvider.density;
        }
        if (object7 & 4 != 0) {
            obj10 = dropdownMenuPositionProvider.verticalMargin;
        }
        if (object7 & 8 != 0) {
            obj11 = dropdownMenuPositionProvider.onPositionCalculated;
        }
        return dropdownMenuPositionProvider.copy-uVxBXkw(obj7, obj2, obj9, obj10);
    }

    @Override // androidx.compose.ui.window.PopupPositionProvider
    public long calculatePosition-llwVHH4(IntRect anchorBounds, long windowSize, LayoutDirection layoutDirection, long popupContentSize) {
        int position-95KtPRI;
        androidx.compose.material3.internal.MenuPosition.Horizontal rightToWindowRight;
        int lastIndex;
        androidx.compose.material3.internal.MenuPosition.Vertical bottomToWindowBottom;
        int y;
        int width-impl2;
        int index2;
        int width-impl;
        int position-JVtK1S4;
        int verticalMargin2;
        int i2;
        int i;
        int x;
        int verticalMargin;
        int index;
        verticalMargin2 = 3;
        androidx.compose.material3.internal.MenuPosition.Horizontal[] arr = new MenuPosition.Horizontal[verticalMargin2];
        i2 = 0;
        arr[i2] = this.startToAnchorStart;
        final int i5 = 1;
        arr[i5] = this.endToAnchorEnd;
        i = 2;
        rightToWindowRight = IntOffset.getX-impl(anchorBounds.getCenter-nOcc-ac()) < width-impl3 /= i ? this.leftToWindowLeft : this.rightToWindowRight;
        arr[i] = rightToWindowRight;
        final List list = listOf;
        x = 0;
        index = position-95KtPRI;
        while (index < list.size()) {
            position-95KtPRI = (MenuPosition.Horizontal)list.get(index).position-95KtPRI(anchorBounds, windowSize, width-impl2, IntSize.getWidth-impl(obj19));
            index++;
        }
        rightToWindowRight = anchorBounds;
        androidx.compose.material3.internal.MenuPosition.Vertical[] arr2 = new MenuPosition.Vertical[4];
        arr2[i2] = this.topToAnchorBottom;
        arr2[i5] = this.bottomToAnchorTop;
        arr2[i] = this.centerToAnchorTop;
        bottomToWindowBottom = IntOffset.getY-impl(anchorBounds.getCenter-nOcc-ac()) < height-impl /= i ? this.topToWindowTop : this.bottomToWindowBottom;
        arr2[verticalMargin2] = bottomToWindowBottom;
        List listOf2 = CollectionsKt.listOf(arr2);
        y = 0;
        index2 = 0;
        int size = listOf2.size();
        while (index2 < size) {
            i2 = windowSize;
            position-JVtK1S4 = (MenuPosition.Vertical)listOf2.get(index2).position-JVtK1S4(anchorBounds, i2, i5);
            index2++;
        }
        i2 = windowSize;
        long l2 = IntOffsetKt.IntOffset(x, y);
        this.onPositionCalculated.invoke(anchorBounds, IntRectKt.IntRect-VbeCjmY(l2, size));
        return l2;
    }

    @Override // androidx.compose.ui.window.PopupPositionProvider
    public final long component1-RKDOV3M() {
        return this.contentOffset;
    }

    @Override // androidx.compose.ui.window.PopupPositionProvider
    public final Density component2() {
        return this.density;
    }

    @Override // androidx.compose.ui.window.PopupPositionProvider
    public final int component3() {
        return this.verticalMargin;
    }

    public final Function2<IntRect, IntRect, Unit> component4() {
        return this.onPositionCalculated;
    }

    public final androidx.compose.material3.internal.DropdownMenuPositionProvider copy-uVxBXkw(long l, Density density2, int i3, Function2<? super IntRect, ? super IntRect, Unit> function24) {
        DropdownMenuPositionProvider dropdownMenuPositionProvider = new DropdownMenuPositionProvider(l, obj2, i3, function24, obj12, 0);
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
        if (this.verticalMargin != obj.verticalMargin) {
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
    public final int getVerticalMargin() {
        return this.verticalMargin;
    }

    @Override // androidx.compose.ui.window.PopupPositionProvider
    public int hashCode() {
        return i6 += i10;
    }

    @Override // androidx.compose.ui.window.PopupPositionProvider
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("DropdownMenuPositionProvider(contentOffset=").append(DpOffset.toString-impl(this.contentOffset)).append(", density=").append(this.density).append(", verticalMargin=").append(this.verticalMargin).append(", onPositionCalculated=").append(this.onPositionCalculated).append(')').toString();
    }
}
