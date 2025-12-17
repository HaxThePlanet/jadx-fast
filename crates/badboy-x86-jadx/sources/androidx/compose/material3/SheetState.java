package androidx.compose.material3;

import androidx.compose.material3.internal.AnchoredDraggableKt;
import androidx.compose.material3.internal.AnchoredDraggableState;
import androidx.compose.material3.internal.DraggableAnchors;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u000e\n\u0002\u0010\u0007\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0002\u0008\u0011\u0008\u0007\u0018\u0000 42\u00020\u0001:\u00014B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0014\u0008\u0002\u0010\u0008\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\t\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\"\u0010#\u001a\u00020$2\u0006\u0010!\u001a\u00020\u00072\u0008\u0008\u0002\u0010%\u001a\u00020\u001cH\u0080@¢\u0006\u0004\u0008&\u0010'J\u000e\u0010(\u001a\u00020$H\u0086@¢\u0006\u0002\u0010)J\u000e\u0010*\u001a\u00020$H\u0086@¢\u0006\u0002\u0010)J\u000e\u0010+\u001a\u00020$H\u0086@¢\u0006\u0002\u0010)J\u0006\u0010,\u001a\u00020\u001cJ\u0018\u0010-\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001cH\u0080@¢\u0006\u0004\u0008.\u0010/J\u000e\u00100\u001a\u00020$H\u0086@¢\u0006\u0002\u0010)J\u0018\u00101\u001a\u00020$2\u0006\u0010!\u001a\u00020\u0007H\u0080@¢\u0006\u0004\u00082\u00103R \u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u00070\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000e\u0010\u000f\"\u0004\u0008\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0019\u0010\u0017R\u0011\u0010\u001a\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u001a\u0010\u0017R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u001c8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u001d\u0010\u001eR\u0014\u0010\n\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010\u0017R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010\u0017R\u0011\u0010!\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\u0008\"\u0010\u0014¨\u00065", d2 = {"Landroidx/compose/material3/SheetState;", "", "skipPartiallyExpanded", "", "density", "Landroidx/compose/ui/unit/Density;", "initialValue", "Landroidx/compose/material3/SheetValue;", "confirmValueChange", "Lkotlin/Function1;", "skipHiddenState", "(ZLandroidx/compose/ui/unit/Density;Landroidx/compose/material3/SheetValue;Lkotlin/jvm/functions/Function1;Z)V", "anchoredDraggableState", "Landroidx/compose/material3/internal/AnchoredDraggableState;", "getAnchoredDraggableState$material3_release", "()Landroidx/compose/material3/internal/AnchoredDraggableState;", "setAnchoredDraggableState$material3_release", "(Landroidx/compose/material3/internal/AnchoredDraggableState;)V", "currentValue", "getCurrentValue", "()Landroidx/compose/material3/SheetValue;", "hasExpandedState", "getHasExpandedState", "()Z", "hasPartiallyExpandedState", "getHasPartiallyExpandedState", "isVisible", "offset", "", "getOffset$material3_release", "()Ljava/lang/Float;", "getSkipHiddenState$material3_release", "getSkipPartiallyExpanded$material3_release", "targetValue", "getTargetValue", "animateTo", "", "velocity", "animateTo$material3_release", "(Landroidx/compose/material3/SheetValue;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expand", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hide", "partialExpand", "requireOffset", "settle", "settle$material3_release", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "show", "snapTo", "snapTo$material3_release", "(Landroidx/compose/material3/SheetValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SheetState {

    public static final int $stable;
    public static final androidx.compose.material3.SheetState.Companion Companion;
    private AnchoredDraggableState<androidx.compose.material3.SheetValue> anchoredDraggableState;
    private final boolean skipHiddenState;
    private final boolean skipPartiallyExpanded;

    @Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J>\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0007\u001a\u00020\u00082\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00080\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u0008¨\u0006\u000e", d2 = {"Landroidx/compose/material3/SheetState$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/SheetState;", "Landroidx/compose/material3/SheetValue;", "skipPartiallyExpanded", "", "confirmValueChange", "Lkotlin/Function1;", "density", "Landroidx/compose/ui/unit/Density;", "skipHiddenState", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final Saver<androidx.compose.material3.SheetState, androidx.compose.material3.SheetValue> Saver(boolean skipPartiallyExpanded, Function1<? super androidx.compose.material3.SheetValue, Boolean> confirmValueChange, Density density, boolean skipHiddenState) {
            SheetState.Companion.Saver.2 anon = new SheetState.Companion.Saver.2(skipPartiallyExpanded, density, confirmValueChange, skipHiddenState);
            return SaverKt.Saver((Function2)SheetState.Companion.Saver.1.INSTANCE, (Function1)anon);
        }
    }
    static {
        SheetState.Companion companion = new SheetState.Companion(0);
        SheetState.Companion = companion;
    }

    public SheetState(boolean skipPartiallyExpanded, Density density, androidx.compose.material3.SheetValue initialValue, Function1<? super androidx.compose.material3.SheetValue, Boolean> confirmValueChange, boolean skipHiddenState) {
        int skipPartiallyExpanded2;
        boolean skipHiddenState2;
        int i;
        super();
        this.skipPartiallyExpanded = skipPartiallyExpanded;
        this.skipHiddenState = skipHiddenState;
        int i4 = 0;
        if (this.skipPartiallyExpanded) {
            skipPartiallyExpanded2 = initialValue != SheetValue.PartiallyExpanded ? i : i4;
            if (skipPartiallyExpanded2 == 0) {
            } else {
            }
            int i2 = 0;
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("The initial value must not be set to PartiallyExpanded if skipPartiallyExpanded is set to true.".toString());
            throw illegalArgumentException;
        }
        if (this.skipHiddenState) {
            if (initialValue != SheetValue.Hidden) {
            } else {
                i = i4;
            }
            if (i == 0) {
            } else {
            }
            int i3 = 0;
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("The initial value must not be set to Hidden if skipHiddenState is set to true.".toString());
            throw illegalArgumentException2;
        }
        SheetState.anchoredDraggableState.1 anon = new SheetState.anchoredDraggableState.1(density);
        SheetState.anchoredDraggableState.2 anon2 = new SheetState.anchoredDraggableState.2(density);
        AnchoredDraggableState anchoredDraggableState = new AnchoredDraggableState(initialValue, (Function1)anon, (Function0)anon2, SheetDefaultsKt.access$getBottomSheetAnimationSpec$p(), confirmValueChange);
        this.anchoredDraggableState = anchoredDraggableState;
    }

    public SheetState(boolean z, Density density2, androidx.compose.material3.SheetValue sheetValue3, Function1 function14, boolean z5, int i6, DefaultConstructorMarker defaultConstructorMarker7) {
        androidx.compose.material3.SheetValue sheetValue;
        androidx.compose.material3.SheetState.1 anon;
        int i;
        androidx.compose.material3.SheetValue obj9;
        androidx.compose.material3.SheetState.1 obj10;
        int obj11;
        sheetValue = i6 & 4 != 0 ? obj9 : sheetValue3;
        if (i6 & 8 != 0) {
            anon = obj10;
        } else {
            anon = function14;
        }
        i = i6 & 16 != 0 ? obj11 : z5;
        super(z, density2, sheetValue, anon, i);
    }

    public static Object animateTo$material3_release$default(androidx.compose.material3.SheetState sheetState, androidx.compose.material3.SheetValue sheetValue2, float f3, Continuation continuation4, int i5, Object object6) {
        float obj2;
        if (i5 &= 2 != 0) {
            obj2 = sheetState.anchoredDraggableState.getLastVelocity();
        }
        return sheetState.animateTo$material3_release(sheetValue2, obj2, continuation4);
    }

    public final Object animateTo$material3_release(androidx.compose.material3.SheetValue targetValue, float velocity, Continuation<? super Unit> $completion) {
        Object animateTo = AnchoredDraggableKt.animateTo(this.anchoredDraggableState, targetValue, velocity, $completion);
        if (animateTo == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return animateTo;
        }
        return Unit.INSTANCE;
    }

    public final Object expand(Continuation<? super Unit> $completion) {
        Object obj7 = AnchoredDraggableKt.animateTo$default(this.anchoredDraggableState, SheetValue.Expanded, 0, $completion, 2, 0);
        if (obj7 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return obj7;
        }
        return Unit.INSTANCE;
    }

    public final AnchoredDraggableState<androidx.compose.material3.SheetValue> getAnchoredDraggableState$material3_release() {
        return this.anchoredDraggableState;
    }

    public final androidx.compose.material3.SheetValue getCurrentValue() {
        return (SheetValue)this.anchoredDraggableState.getCurrentValue();
    }

    public final boolean getHasExpandedState() {
        return this.anchoredDraggableState.getAnchors().hasAnchorFor(SheetValue.Expanded);
    }

    public final boolean getHasPartiallyExpandedState() {
        return this.anchoredDraggableState.getAnchors().hasAnchorFor(SheetValue.PartiallyExpanded);
    }

    public final Float getOffset$material3_release() {
        return Float.valueOf(this.anchoredDraggableState.getOffset());
    }

    public final boolean getSkipHiddenState$material3_release() {
        return this.skipHiddenState;
    }

    public final boolean getSkipPartiallyExpanded$material3_release() {
        return this.skipPartiallyExpanded;
    }

    public final androidx.compose.material3.SheetValue getTargetValue() {
        return (SheetValue)this.anchoredDraggableState.getTargetValue();
    }

    public final Object hide(Continuation<? super Unit> $completion) {
        if (this.skipHiddenState) {
        } else {
            Object obj8 = SheetState.animateTo$material3_release$default(this, SheetValue.Hidden, 0, $completion, 2, 0);
            if (obj8 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return obj8;
            }
            return Unit.INSTANCE;
        }
        Continuation $completion2 = $completion;
        obj8 = 0;
        obj8 = new IllegalStateException("Attempted to animate to hidden when skipHiddenState was enabled. Set skipHiddenState to false to use this function.".toString());
        throw obj8;
    }

    public final boolean isVisible() {
        int i;
        i = this.anchoredDraggableState.getCurrentValue() != SheetValue.Hidden ? 1 : 0;
        return i;
    }

    public final Object partialExpand(Continuation<? super Unit> $completion) {
        if (this.skipPartiallyExpanded) {
        } else {
            Object obj8 = SheetState.animateTo$material3_release$default(this, SheetValue.PartiallyExpanded, 0, $completion, 2, 0);
            if (obj8 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return obj8;
            }
            return Unit.INSTANCE;
        }
        Continuation $completion2 = $completion;
        obj8 = 0;
        obj8 = new IllegalStateException("Attempted to animate to partial expanded when skipPartiallyExpanded was enabled. Set skipPartiallyExpanded to false to use this function.".toString());
        throw obj8;
    }

    public final float requireOffset() {
        return this.anchoredDraggableState.requireOffset();
    }

    public final void setAnchoredDraggableState$material3_release(AnchoredDraggableState<androidx.compose.material3.SheetValue> <set-?>) {
        this.anchoredDraggableState = <set-?>;
    }

    public final Object settle$material3_release(float velocity, Continuation<? super Unit> $completion) {
        Object obj = this.anchoredDraggableState.settle(velocity, $completion);
        if (obj == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return obj;
        }
        return Unit.INSTANCE;
    }

    public final Object show(Continuation<? super Unit> $completion) {
        androidx.compose.material3.SheetValue partiallyExpanded;
        partiallyExpanded = getHasPartiallyExpandedState() ? SheetValue.PartiallyExpanded : SheetValue.Expanded;
        Object obj8 = SheetState.animateTo$material3_release$default(this, partiallyExpanded, 0, $completion, 2, 0);
        if (obj8 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return obj8;
        }
        return Unit.INSTANCE;
    }

    public final Object snapTo$material3_release(androidx.compose.material3.SheetValue targetValue, Continuation<? super Unit> $completion) {
        Object snapTo = AnchoredDraggableKt.snapTo(this.anchoredDraggableState, targetValue, $completion);
        if (snapTo == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return snapTo;
        }
        return Unit.INSTANCE;
    }
}
