package androidx.compose.foundation;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.gestures.ScrollExtensionsKt;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.gestures.ScrollableStateKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.IntState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.Snapshot.Companion;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0018\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0007\u0018\u0000 B2\u00020\u0001:\u0001BB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J&\u0010/\u001a\u0002002\u0006\u0010&\u001a\u00020\u00032\u000e\u0008\u0002\u00101\u001a\u0008\u0012\u0004\u0012\u00020\u000802H\u0086@¢\u0006\u0002\u00103J\u0010\u00104\u001a\u00020\u00082\u0006\u00105\u001a\u00020\u0008H\u0016J?\u00106\u001a\u0002002\u0006\u00107\u001a\u0002082'\u00109\u001a#\u0008\u0001\u0012\u0004\u0012\u00020;\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002000<\u0012\u0006\u0012\u0004\u0018\u00010=0:¢\u0006\u0002\u0008>H\u0096@¢\u0006\u0002\u0010?J\u0016\u0010@\u001a\u00020\u00082\u0006\u0010&\u001a\u00020\u0003H\u0086@¢\u0006\u0002\u0010AR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\u000c\n\u0004\u0008\r\u0010\u000e\u001a\u0004\u0008\u000b\u0010\u000cR\u001b\u0010\u000f\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0011\u0010\u000e\u001a\u0004\u0008\u0010\u0010\u000cR\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\u0008\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u0017X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u001a\u0010\u000cR\u0014\u0010\u001b\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u001c\u0010\u000cR\u0014\u0010\u001d\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u001e\u0010\u000cR$\u0010 \u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u00038F@@X\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008!\u0010\"\"\u0004\u0008#\u0010\u0004R\u000e\u0010$\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010&\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u00038F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008)\u0010*\u001a\u0004\u0008'\u0010\"\"\u0004\u0008(\u0010\u0004R+\u0010+\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u00038F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008.\u0010*\u001a\u0004\u0008,\u0010\"\"\u0004\u0008-\u0010\u0004¨\u0006C", d2 = {"Landroidx/compose/foundation/ScrollState;", "Landroidx/compose/foundation/gestures/ScrollableState;", "initial", "", "(I)V", "_maxValueState", "Landroidx/compose/runtime/MutableIntState;", "accumulator", "", "canScrollBackward", "", "getCanScrollBackward", "()Z", "canScrollBackward$delegate", "Landroidx/compose/runtime/State;", "canScrollForward", "getCanScrollForward", "canScrollForward$delegate", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "getInteractionSource", "()Landroidx/compose/foundation/interaction/InteractionSource;", "internalInteractionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "getInternalInteractionSource$foundation_release", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "isScrollInProgress", "lastScrolledBackward", "getLastScrolledBackward", "lastScrolledForward", "getLastScrolledForward", "newMax", "maxValue", "getMaxValue", "()I", "setMaxValue$foundation_release", "scrollableState", "<set-?>", "value", "getValue", "setValue", "value$delegate", "Landroidx/compose/runtime/MutableIntState;", "viewportSize", "getViewportSize", "setViewportSize$foundation_release", "viewportSize$delegate", "animateScrollTo", "", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "(ILandroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchRawDelta", "delta", "scroll", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/ScrollScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scrollTo", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ScrollState implements ScrollableState {

    public static final int $stable;
    public static final androidx.compose.foundation.ScrollState.Companion Companion;
    private static final Saver<androidx.compose.foundation.ScrollState, ?> Saver;
    private MutableIntState _maxValueState;
    private float accumulator;
    private final State canScrollBackward$delegate;
    private final State canScrollForward$delegate;
    private final MutableInteractionSource internalInteractionSource;
    private final ScrollableState scrollableState;
    private final MutableIntState value$delegate;
    private final MutableIntState viewportSize$delegate;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u000c\u0012\u0004\u0012\u00020\u0005\u0012\u0002\u0008\u00030\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"Landroidx/compose/foundation/ScrollState$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/ScrollState;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final Saver<androidx.compose.foundation.ScrollState, ?> getSaver() {
            return ScrollState.access$getSaver$cp();
        }
    }
    static {
        ScrollState.Companion companion = new ScrollState.Companion(0);
        ScrollState.Companion = companion;
        ScrollState.Saver = SaverKt.Saver((Function2)ScrollState.Companion.Saver.1.INSTANCE, (Function1)ScrollState.Companion.Saver.2.INSTANCE);
    }

    public ScrollState(int initial) {
        super();
        this.value$delegate = SnapshotIntStateKt.mutableIntStateOf(initial);
        this.viewportSize$delegate = SnapshotIntStateKt.mutableIntStateOf(0);
        this.internalInteractionSource = InteractionSourceKt.MutableInteractionSource();
        this._maxValueState = SnapshotIntStateKt.mutableIntStateOf(Integer.MAX_VALUE);
        ScrollState.scrollableState.1 anon = new ScrollState.scrollableState.1(this);
        this.scrollableState = ScrollableStateKt.ScrollableState((Function1)anon);
        ScrollState.canScrollForward.2 anon2 = new ScrollState.canScrollForward.2(this);
        this.canScrollForward$delegate = SnapshotStateKt.derivedStateOf((Function0)anon2);
        ScrollState.canScrollBackward.2 anon3 = new ScrollState.canScrollBackward.2(this);
        this.canScrollBackward$delegate = SnapshotStateKt.derivedStateOf((Function0)anon3);
    }

    public static final float access$getAccumulator$p(androidx.compose.foundation.ScrollState $this) {
        return $this.accumulator;
    }

    public static final Saver access$getSaver$cp() {
        return ScrollState.Saver;
    }

    public static final void access$setAccumulator$p(androidx.compose.foundation.ScrollState $this, float <set-?>) {
        $this.accumulator = <set-?>;
    }

    public static final void access$setValue(androidx.compose.foundation.ScrollState $this, int <set-?>) {
        $this.setValue(<set-?>);
    }

    public static Object animateScrollTo$default(androidx.compose.foundation.ScrollState scrollState, int i2, AnimationSpec animationSpec3, Continuation continuation4, int i5, Object object6) {
        SpringSpec springSpec;
        int i3;
        int i4;
        int i6;
        int i;
        int i7;
        SpringSpec obj8;
        if (i5 &= 2 != 0) {
            springSpec = new SpringSpec(0, 0, 0, 7, 0);
            obj8 = springSpec;
        }
        return scrollState.animateScrollTo(i2, obj8, continuation4);
    }

    private final void setValue(int <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.value$delegate.setIntValue(<set-?>);
    }

    public final Object animateScrollTo(int value, AnimationSpec<Float> animationSpec, Continuation<? super Unit> $completion) {
        Object animateScrollBy = ScrollExtensionsKt.animateScrollBy((ScrollableState)this, (float)i, animationSpec, $completion);
        if (animateScrollBy == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return animateScrollBy;
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public float dispatchRawDelta(float delta) {
        return this.scrollableState.dispatchRawDelta(delta);
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean getCanScrollBackward() {
        final int i = 0;
        final int i2 = 0;
        return (Boolean)this.canScrollBackward$delegate.getValue().booleanValue();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean getCanScrollForward() {
        final int i = 0;
        final int i2 = 0;
        return (Boolean)this.canScrollForward$delegate.getValue().booleanValue();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final InteractionSource getInteractionSource() {
        return (InteractionSource)this.internalInteractionSource;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final MutableInteractionSource getInternalInteractionSource$foundation_release() {
        return this.internalInteractionSource;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean getLastScrolledBackward() {
        return this.scrollableState.getLastScrolledBackward();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean getLastScrolledForward() {
        return this.scrollableState.getLastScrolledForward();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final int getMaxValue() {
        return this._maxValueState.getIntValue();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final int getValue() {
        final int i = 0;
        final int i2 = 0;
        return (IntState)this.value$delegate.getIntValue();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final int getViewportSize() {
        final int i = 0;
        final int i2 = 0;
        return (IntState)this.viewportSize$delegate.getIntValue();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean isScrollInProgress() {
        return this.scrollableState.isScrollInProgress();
    }

    public Object scroll(androidx.compose.foundation.MutatePriority scrollPriority, Function2<? super ScrollScope, ? super Continuation<? super Unit>, ? extends Object> block, Continuation<? super Unit> $completion) {
        Object scroll = this.scrollableState.scroll(scrollPriority, block, $completion);
        if (scroll == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return scroll;
        }
        return Unit.INSTANCE;
    }

    public final Object scrollTo(int value, Continuation<? super Float> $completion) {
        return ScrollExtensionsKt.scrollBy((ScrollableState)this, (float)i, $completion);
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final void setMaxValue$foundation_release(int newMax) {
        kotlin.jvm.functions.Function1 readObserver;
        this._maxValueState.setIntValue(newMax);
        Snapshot.Companion companion = Snapshot.Companion;
        final int i = 0;
        final Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        if (currentThreadSnapshot != null) {
            readObserver = currentThreadSnapshot.getReadObserver();
        } else {
            readObserver = 0;
        }
        int i2 = 0;
        if (getValue() > newMax) {
            setValue(newMax);
        }
        Unit $i$a$WithoutReadObservationScrollState$maxValue$1 = Unit.INSTANCE;
        companion.restoreNonObservable(currentThreadSnapshot, companion.makeCurrentNonObservable(currentThreadSnapshot), readObserver);
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final void setViewportSize$foundation_release(int <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.viewportSize$delegate.setIntValue(<set-?>);
    }
}
