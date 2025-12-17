package androidx.compose.material3;

import androidx.compose.material3.internal.MenuPosition;
import androidx.compose.material3.internal.MenuPosition.Horizontal;
import androidx.compose.material3.internal.MenuPosition.Vertical;
import androidx.compose.runtime.State;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntRectKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0001\u0018\u00002\u00020\u0001Bk\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0010\u0008\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0008\u0018\u00010\u0007\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\u0005\u00128\u0008\u0002\u0010\n\u001a2\u0012\u0013\u0012\u00110\u000c¢\u0006\u000c\u0008\r\u0012\u0008\u0008\u000e\u0012\u0004\u0008\u0008(\u000f\u0012\u0013\u0012\u00110\u000c¢\u0006\u000c\u0008\r\u0012\u0008\u0008\u000e\u0012\u0004\u0008\u0008(\u0010\u0012\u0004\u0012\u00020\u00080\u000b¢\u0006\u0002\u0010\u0011J2\u0010%\u001a\u00020&2\u0006\u0010\u000f\u001a\u00020\u000c2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020(H\u0016ø\u0001\u0000¢\u0006\u0004\u0008,\u0010-R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0008\u0018\u00010\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000RA\u0010\n\u001a2\u0012\u0013\u0012\u00110\u000c¢\u0006\u000c\u0008\r\u0012\u0008\u0008\u000e\u0012\u0004\u0008\u0008(\u000f\u0012\u0013\u0012\u00110\u000c¢\u0006\u000c\u0008\r\u0012\u0008\u0008\u000e\u0012\u0004\u0008\u0008(\u0010\u0012\u0004\u0012\u00020\u00080\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\"\u0010#R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008$\u0010#\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006.", d2 = {"Landroidx/compose/material3/ExposedDropdownMenuPositionProvider;", "Landroidx/compose/ui/window/PopupPositionProvider;", "density", "Landroidx/compose/ui/unit/Density;", "topWindowInsets", "", "keyboardSignalState", "Landroidx/compose/runtime/State;", "", "verticalMargin", "onPositionCalculated", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/IntRect;", "Lkotlin/ParameterName;", "name", "anchorBounds", "menuBounds", "(Landroidx/compose/ui/unit/Density;ILandroidx/compose/runtime/State;ILkotlin/jvm/functions/Function2;)V", "bottomToAnchorTop", "Landroidx/compose/material3/internal/MenuPosition$Vertical;", "bottomToWindowBottom", "getDensity", "()Landroidx/compose/ui/unit/Density;", "endToAnchorEnd", "Landroidx/compose/material3/internal/MenuPosition$Horizontal;", "getKeyboardSignalState", "()Landroidx/compose/runtime/State;", "leftToWindowLeft", "getOnPositionCalculated", "()Lkotlin/jvm/functions/Function2;", "rightToWindowRight", "startToAnchorStart", "topToAnchorBottom", "topToWindowTop", "getTopWindowInsets", "()I", "getVerticalMargin", "calculatePosition", "Landroidx/compose/ui/unit/IntOffset;", "windowSize", "Landroidx/compose/ui/unit/IntSize;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "popupContentSize", "calculatePosition-llwVHH4", "(Landroidx/compose/ui/unit/IntRect;JLandroidx/compose/ui/unit/LayoutDirection;J)J", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ExposedDropdownMenuPositionProvider implements PopupPositionProvider {

    public static final int $stable;
    private final MenuPosition.Vertical bottomToAnchorTop;
    private final MenuPosition.Vertical bottomToWindowBottom;
    private final Density density;
    private final MenuPosition.Horizontal endToAnchorEnd;
    private final State<Unit> keyboardSignalState;
    private final MenuPosition.Horizontal leftToWindowLeft;
    private final Function2<IntRect, IntRect, Unit> onPositionCalculated;
    private final MenuPosition.Horizontal rightToWindowRight;
    private final MenuPosition.Horizontal startToAnchorStart;
    private final MenuPosition.Vertical topToAnchorBottom;
    private final MenuPosition.Vertical topToWindowTop;
    private final int topWindowInsets;
    private final int verticalMargin;
    static {
    }

    public ExposedDropdownMenuPositionProvider(Density density, int topWindowInsets, State<Unit> keyboardSignalState, int verticalMargin, Function2<? super IntRect, ? super IntRect, Unit> onPositionCalculated) {
        super();
        this.density = density;
        this.topWindowInsets = topWindowInsets;
        this.keyboardSignalState = keyboardSignalState;
        this.verticalMargin = verticalMargin;
        this.onPositionCalculated = onPositionCalculated;
        int i = 0;
        final int i2 = 1;
        final int i3 = 0;
        this.startToAnchorStart = MenuPosition.startToAnchorStart$default(MenuPosition.INSTANCE, i, i2, i3);
        this.endToAnchorEnd = MenuPosition.endToAnchorEnd$default(MenuPosition.INSTANCE, i, i2, i3);
        this.leftToWindowLeft = MenuPosition.leftToWindowLeft$default(MenuPosition.INSTANCE, i, i2, i3);
        this.rightToWindowRight = MenuPosition.rightToWindowRight$default(MenuPosition.INSTANCE, i, i2, i3);
        this.topToAnchorBottom = MenuPosition.topToAnchorBottom$default(MenuPosition.INSTANCE, i, i2, i3);
        this.bottomToAnchorTop = MenuPosition.bottomToAnchorTop$default(MenuPosition.INSTANCE, i, i2, i3);
        this.topToWindowTop = MenuPosition.INSTANCE.topToWindowTop(this.verticalMargin);
        this.bottomToWindowBottom = MenuPosition.INSTANCE.bottomToWindowBottom(this.verticalMargin);
    }

    public ExposedDropdownMenuPositionProvider(Density density, int i2, State state3, int i4, Function2 function25, int i6, DefaultConstructorMarker defaultConstructorMarker7) {
        int i;
        int i3;
        androidx.compose.material3.ExposedDropdownMenuPositionProvider.2 anon;
        int obj9;
        int obj10;
        androidx.compose.material3.ExposedDropdownMenuPositionProvider.2 obj11;
        int obj13;
        i = i6 & 4 != 0 ? obj9 : state3;
        if (i6 & 8 != 0) {
            obj10 = 0;
            i3 = obj10;
        } else {
            i3 = i4;
        }
        if (i6 & 16 != 0) {
            anon = obj11;
        } else {
            anon = function25;
        }
        super(density, i2, i, i3, anon);
    }

    @Override // androidx.compose.ui.window.PopupPositionProvider
    public long calculatePosition-llwVHH4(IntRect anchorBounds, long windowSize, LayoutDirection layoutDirection, long popupContentSize) {
        MenuPosition.Horizontal rightToWindowRight;
        int position-95KtPRI;
        MenuPosition.Vertical bottomToWindowBottom;
        int y;
        int i;
        int lastIndex2;
        int index2;
        int width-impl;
        int position-JVtK1S4;
        int lastIndex;
        int height-impl;
        int x;
        int index;
        State keyboardSignalState = this.keyboardSignalState;
        if (keyboardSignalState != null) {
            keyboardSignalState.getValue();
        }
        final long l = IntSizeKt.IntSize(IntSize.getWidth-impl(windowSize), height-impl2 += topWindowInsets);
        int i2 = 3;
        MenuPosition.Horizontal[] arr2 = new MenuPosition.Horizontal[i2];
        position-JVtK1S4 = 0;
        arr2[position-JVtK1S4] = this.startToAnchorStart;
        lastIndex = 1;
        arr2[lastIndex] = this.endToAnchorEnd;
        height-impl = 2;
        rightToWindowRight = IntOffset.getX-impl(anchorBounds.getCenter-nOcc-ac()) < width-impl3 /= height-impl ? this.leftToWindowLeft : this.rightToWindowRight;
        arr2[height-impl] = rightToWindowRight;
        List listOf2 = CollectionsKt.listOf(arr2);
        x = 0;
        index = position-95KtPRI;
        while (index < listOf2.size()) {
            position-95KtPRI = (MenuPosition.Horizontal)listOf2.get(index).position-95KtPRI(anchorBounds, l, obj5, IntSize.getWidth-impl(obj19));
            index++;
        }
        MenuPosition.Vertical[] arr = new MenuPosition.Vertical[i2];
        arr[position-JVtK1S4] = this.topToAnchorBottom;
        arr[lastIndex] = this.bottomToAnchorTop;
        bottomToWindowBottom = IntOffset.getY-impl(anchorBounds.getCenter-nOcc-ac()) < height-impl3 /= height-impl ? this.topToWindowTop : this.bottomToWindowBottom;
        arr[height-impl] = bottomToWindowBottom;
        List listOf = CollectionsKt.listOf(arr);
        y = 0;
        index2 = 0;
        int size = listOf.size();
        while (index2 < size) {
            position-JVtK1S4 = (MenuPosition.Vertical)listOf.get(index2).position-JVtK1S4(anchorBounds, l, obj5);
            index2++;
        }
        long l2 = IntOffsetKt.IntOffset(x, y);
        this.onPositionCalculated.invoke(anchorBounds, IntRectKt.IntRect-VbeCjmY(l2, size));
        return l2;
    }

    @Override // androidx.compose.ui.window.PopupPositionProvider
    public final Density getDensity() {
        return this.density;
    }

    public final State<Unit> getKeyboardSignalState() {
        return this.keyboardSignalState;
    }

    public final Function2<IntRect, IntRect, Unit> getOnPositionCalculated() {
        return this.onPositionCalculated;
    }

    @Override // androidx.compose.ui.window.PopupPositionProvider
    public final int getTopWindowInsets() {
        return this.topWindowInsets;
    }

    @Override // androidx.compose.ui.window.PopupPositionProvider
    public final int getVerticalMargin() {
        return this.verticalMargin;
    }
}
