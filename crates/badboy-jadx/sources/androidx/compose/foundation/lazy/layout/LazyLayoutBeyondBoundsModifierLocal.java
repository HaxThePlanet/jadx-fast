package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.layout.BeyondBoundsLayout;
import androidx.compose.ui.layout.BeyondBoundsLayout.BeyondBoundsScope;
import androidx.compose.ui.layout.BeyondBoundsLayout.LayoutDirection;
import androidx.compose.ui.layout.BeyondBoundsLayout.LayoutDirection.Companion;
import androidx.compose.ui.layout.BeyondBoundsLayoutKt;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref.ObjectRef;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000c\u0008\u0000\u0018\u0000 ,2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u00020\u0002:\u0001,B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u000c¢\u0006\u0002\u0010\rJ\"\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u001a\u0010\u001bJ=\u0010\u001c\u001a\u0004\u0018\u0001H\u001d\"\u0004\u0008\u0000\u0010\u001d2\u0006\u0010\u0018\u001a\u00020\u00192\u0019\u0010\u001e\u001a\u0015\u0012\u0004\u0012\u00020 \u0012\u0006\u0012\u0004\u0018\u0001H\u001d0\u001f¢\u0006\u0002\u0008!H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\"\u0010#J\u001e\u0010$\u001a\u00020\u0008*\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0002ø\u0001\u0000¢\u0006\u0004\u0008%\u0010&J\u0016\u0010'\u001a\u00020\u0008*\u00020\u0019H\u0002ø\u0001\u0000¢\u0006\u0004\u0008(\u0010)J\u0016\u0010*\u001a\u00020\u0008*\u00020\u0019H\u0002ø\u0001\u0000¢\u0006\u0004\u0008+\u0010)R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u0011R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u0014\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006-", d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsModifierLocal;", "Landroidx/compose/ui/modifier/ModifierLocalProvider;", "Landroidx/compose/ui/layout/BeyondBoundsLayout;", "state", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsState;", "beyondBoundsInfo", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "reverseLayout", "", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsState;Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;ZLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/foundation/gestures/Orientation;)V", "key", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "getKey", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "value", "getValue", "()Landroidx/compose/ui/layout/BeyondBoundsLayout;", "addNextInterval", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo$Interval;", "currentInterval", "direction", "Landroidx/compose/ui/layout/BeyondBoundsLayout$LayoutDirection;", "addNextInterval-FR3nfPY", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo$Interval;I)Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo$Interval;", "layout", "T", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/BeyondBoundsLayout$BeyondBoundsScope;", "Lkotlin/ExtensionFunctionType;", "layout-o7g1Pn8", "(ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "hasMoreContent", "hasMoreContent-FR3nfPY", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo$Interval;I)Z", "isForward", "isForward-4vf7U8o", "(I)Z", "isOppositeToOrientation", "isOppositeToOrientation-4vf7U8o", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LazyLayoutBeyondBoundsModifierLocal implements ModifierLocalProvider<BeyondBoundsLayout>, BeyondBoundsLayout {

    public static final int $stable;
    public static final androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierLocal.Companion Companion;
    private static final androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierLocal.Companion.emptyBeyondBoundsScope.1 emptyBeyondBoundsScope;
    private final androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo beyondBoundsInfo;
    private final LayoutDirection layoutDirection;
    private final Orientation orientation;
    private final boolean reverseLayout;
    private final androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsState state;

    @Metadata(d1 = "\u0000\u0013\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0008\u0003*\u0001\u0004\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006\u0006", d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsModifierLocal$Companion;", "", "()V", "emptyBeyondBoundsScope", "androidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsModifierLocal$Companion$emptyBeyondBoundsScope$1", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsModifierLocal$Companion$emptyBeyondBoundsScope$1;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int ordinal2;
            int ordinal;
            int[] iArr = new int[values.length];
            iArr[LayoutDirection.Ltr.ordinal()] = 1;
            iArr[LayoutDirection.Rtl.ordinal()] = 2;
            LazyLayoutBeyondBoundsModifierLocal.WhenMappings.$EnumSwitchMapping$0 = iArr;
        }
    }
    static {
        LazyLayoutBeyondBoundsModifierLocal.Companion companion = new LazyLayoutBeyondBoundsModifierLocal.Companion(0);
        LazyLayoutBeyondBoundsModifierLocal.Companion = companion;
        LazyLayoutBeyondBoundsModifierLocal.Companion.emptyBeyondBoundsScope.1 anon = new LazyLayoutBeyondBoundsModifierLocal.Companion.emptyBeyondBoundsScope.1();
        LazyLayoutBeyondBoundsModifierLocal.emptyBeyondBoundsScope = anon;
    }

    public LazyLayoutBeyondBoundsModifierLocal(androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsState state, androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo beyondBoundsInfo, boolean reverseLayout, LayoutDirection layoutDirection, Orientation orientation) {
        super();
        this.state = state;
        this.beyondBoundsInfo = beyondBoundsInfo;
        this.reverseLayout = reverseLayout;
        this.layoutDirection = layoutDirection;
        this.orientation = orientation;
    }

    public static final boolean access$hasMoreContent-FR3nfPY(androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierLocal $this, androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo.Interval $receiver, int direction) {
        return $this.hasMoreContent-FR3nfPY($receiver, direction);
    }

    private final androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo.Interval addNextInterval-FR3nfPY(androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo.Interval currentInterval, int direction) {
        int start;
        int end;
        if (isForward-4vf7U8o(direction)) {
            end++;
        } else {
            start--;
        }
        return this.beyondBoundsInfo.addInterval(start, end);
    }

    private final boolean hasMoreContent-FR3nfPY(androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo.Interval $this$hasMoreContent_u2dFR3nfPY, int direction) {
        int start;
        int i;
        int i2;
        if (isOppositeToOrientation-4vf7U8o(direction)) {
            return 0;
        }
        final int i3 = 1;
        if (isForward-4vf7U8o(direction)) {
            if ($this$hasMoreContent_u2dFR3nfPY.getEnd() < itemCount -= i3) {
                i = i3;
            }
        } else {
            if ($this$hasMoreContent_u2dFR3nfPY.getStart() > 0) {
            }
        }
        return i;
    }

    private final boolean isForward-4vf7U8o(int $this$isForward_u2d4vf7U8o) {
        boolean reverseLayout2;
        int reverseLayout;
        int i;
        int[] $EnumSwitchMapping$0;
        reverseLayout = 0;
        if (BeyondBoundsLayout.LayoutDirection.equals-impl0($this$isForward_u2d4vf7U8o, BeyondBoundsLayout.LayoutDirection.Companion.getBefore-hoxUOeE())) {
            return reverseLayout;
        } else {
            i = 1;
            if (BeyondBoundsLayout.LayoutDirection.equals-impl0($this$isForward_u2d4vf7U8o, BeyondBoundsLayout.LayoutDirection.Companion.getAfter-hoxUOeE())) {
                reverseLayout = i;
            } else {
                if (BeyondBoundsLayout.LayoutDirection.equals-impl0($this$isForward_u2d4vf7U8o, BeyondBoundsLayout.LayoutDirection.Companion.getAbove-hoxUOeE())) {
                    reverseLayout = this.reverseLayout;
                } else {
                    if (BeyondBoundsLayout.LayoutDirection.equals-impl0($this$isForward_u2d4vf7U8o, BeyondBoundsLayout.LayoutDirection.Companion.getBelow-hoxUOeE())) {
                        if (!this.reverseLayout) {
                            reverseLayout = i;
                        }
                    } else {
                        if (BeyondBoundsLayout.LayoutDirection.equals-impl0($this$isForward_u2d4vf7U8o, BeyondBoundsLayout.LayoutDirection.Companion.getLeft-hoxUOeE())) {
                            switch (reverseLayout2) {
                                case 1:
                                    reverseLayout = this.reverseLayout;
                                    break;
                                case 2:
                                    reverseLayout = i;
                                    break;
                                default:
                                    NoWhenBranchMatchedException noWhenBranchMatchedException2 = new NoWhenBranchMatchedException();
                                    throw noWhenBranchMatchedException2;
                            }
                        }
                        if (!BeyondBoundsLayout.LayoutDirection.equals-impl0($this$isForward_u2d4vf7U8o, BeyondBoundsLayout.LayoutDirection.Companion.getRight-hoxUOeE())) {
                        } else {
                            switch (reverseLayout2) {
                                case 1:
                                    reverseLayout = i;
                                    break;
                                case 2:
                                    reverseLayout = this.reverseLayout;
                                    break;
                                default:
                                    NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                                    throw noWhenBranchMatchedException;
                            }
                        }
                    }
                }
            }
        }
        LazyLayoutBeyondBoundsModifierLocalKt.access$unsupportedDirection();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    private final boolean isOppositeToOrientation-4vf7U8o(int $this$isOppositeToOrientation_u2d4vf7U8o) {
        int equals-impl0;
        boolean equals-impl02;
        boolean after-hoxUOeE;
        int equals-impl03;
        Orientation horizontal;
        equals-impl03 = 1;
        if (BeyondBoundsLayout.LayoutDirection.equals-impl0($this$isOppositeToOrientation_u2d4vf7U8o, BeyondBoundsLayout.LayoutDirection.Companion.getAbove-hoxUOeE())) {
            equals-impl0 = equals-impl03;
        } else {
            equals-impl0 = BeyondBoundsLayout.LayoutDirection.equals-impl0($this$isOppositeToOrientation_u2d4vf7U8o, BeyondBoundsLayout.LayoutDirection.Companion.getBelow-hoxUOeE());
        }
        final int i = 0;
        if (equals-impl0 != 0) {
            if (this.orientation == Orientation.Horizontal) {
            } else {
                equals-impl03 = i;
            }
            return equals-impl03;
        } else {
            if (BeyondBoundsLayout.LayoutDirection.equals-impl0($this$isOppositeToOrientation_u2d4vf7U8o, BeyondBoundsLayout.LayoutDirection.Companion.getLeft-hoxUOeE())) {
                equals-impl02 = equals-impl03;
            } else {
                equals-impl02 = BeyondBoundsLayout.LayoutDirection.equals-impl0($this$isOppositeToOrientation_u2d4vf7U8o, BeyondBoundsLayout.LayoutDirection.Companion.getRight-hoxUOeE());
            }
            if (equals-impl02) {
                if (this.orientation == Orientation.Vertical) {
                } else {
                    equals-impl03 = i;
                }
            } else {
                if (BeyondBoundsLayout.LayoutDirection.equals-impl0($this$isOppositeToOrientation_u2d4vf7U8o, BeyondBoundsLayout.LayoutDirection.Companion.getBefore-hoxUOeE())) {
                } else {
                    equals-impl03 = BeyondBoundsLayout.LayoutDirection.equals-impl0($this$isOppositeToOrientation_u2d4vf7U8o, BeyondBoundsLayout.LayoutDirection.Companion.getAfter-hoxUOeE());
                }
                if (equals-impl03 == 0) {
                } else {
                    equals-impl03 = i;
                }
            }
        }
        LazyLayoutBeyondBoundsModifierLocalKt.access$unsupportedDirection();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    public ProvidableModifierLocal<BeyondBoundsLayout> getKey() {
        return BeyondBoundsLayoutKt.getModifierLocalBeyondBoundsLayout();
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalProvider
    public BeyondBoundsLayout getValue() {
        return (BeyondBoundsLayout)this;
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalProvider
    public Object getValue() {
        return getValue();
    }

    public <T> T layout-o7g1Pn8(int direction, Function1<? super BeyondBoundsLayout.BeyondBoundsScope, ? extends T> block) {
        int hasVisibleItems;
        int firstPlacedIndex;
        int found;
        androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierLocal.layout.2 moreContent-FR3nfPY;
        androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo.Interval interval;
        int i;
        androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo beyondBoundsInfo;
        Object element;
        if (this.state.getItemCount() > 0) {
            if (!this.state.getHasVisibleItems()) {
            } else {
                if (isForward-4vf7U8o(direction)) {
                    firstPlacedIndex = this.state.getLastPlacedIndex();
                } else {
                    firstPlacedIndex = this.state.getFirstPlacedIndex();
                }
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                objectRef.element = this.beyondBoundsInfo.addInterval(firstPlacedIndex, firstPlacedIndex);
                found = 0;
                while (found == 0) {
                    if (hasMoreContent-FR3nfPY((LazyLayoutBeyondBoundsInfo.Interval)objectRef.element, direction)) {
                    }
                    androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo.Interval nextInterval-FR3nfPY = addNextInterval-FR3nfPY((LazyLayoutBeyondBoundsInfo.Interval)objectRef.element, direction);
                    interval = nextInterval-FR3nfPY;
                    i = 0;
                    this.beyondBoundsInfo.removeInterval((LazyLayoutBeyondBoundsInfo.Interval)objectRef.element);
                    objectRef.element = nextInterval-FR3nfPY;
                    this.state.remeasure();
                    moreContent-FR3nfPY = new LazyLayoutBeyondBoundsModifierLocal.layout.2(this, objectRef, direction);
                    found = block.invoke(moreContent-FR3nfPY);
                }
            }
            this.beyondBoundsInfo.removeInterval((LazyLayoutBeyondBoundsInfo.Interval)objectRef.element);
            this.state.remeasure();
            return found;
        }
        return block.invoke(LazyLayoutBeyondBoundsModifierLocal.emptyBeyondBoundsScope);
    }
}
