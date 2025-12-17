package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScopeKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0016J?\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2'\u0010\u001d\u001a#\u0008\u0001\u0012\u0004\u0012\u00020\u0016\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001a0\u001f\u0012\u0006\u0012\u0004\u0018\u00010 0\u001e¢\u0006\u0002\u0008!H\u0096@¢\u0006\u0002\u0010\"R\u0014\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u00088VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000bR\u0014\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u00088VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\u00088VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u000bR\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#", d2 = {"Landroidx/compose/foundation/gestures/DefaultScrollableState;", "Landroidx/compose/foundation/gestures/ScrollableState;", "onDelta", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "isLastScrollBackwardState", "Landroidx/compose/runtime/MutableState;", "", "isLastScrollForwardState", "isScrollInProgress", "()Z", "isScrollingState", "lastScrolledBackward", "getLastScrolledBackward", "lastScrolledForward", "getLastScrolledForward", "getOnDelta", "()Lkotlin/jvm/functions/Function1;", "scrollMutex", "Landroidx/compose/foundation/MutatorMutex;", "scrollScope", "Landroidx/compose/foundation/gestures/ScrollScope;", "dispatchRawDelta", "delta", "scroll", "", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class DefaultScrollableState implements androidx.compose.foundation.gestures.ScrollableState {

    private final MutableState<Boolean> isLastScrollBackwardState;
    private final MutableState<Boolean> isLastScrollForwardState;
    private final MutableState<Boolean> isScrollingState;
    private final Function1<Float, Float> onDelta;
    private final MutatorMutex scrollMutex;
    private final androidx.compose.foundation.gestures.ScrollScope scrollScope;
    public DefaultScrollableState(Function1<? super Float, Float> onDelta) {
        super();
        this.onDelta = onDelta;
        DefaultScrollableState.scrollScope.1 anon = new DefaultScrollableState.scrollScope.1(this);
        this.scrollScope = (ScrollScope)anon;
        MutatorMutex mutatorMutex = new MutatorMutex();
        this.scrollMutex = mutatorMutex;
        Boolean valueOf = false;
        final int i2 = 0;
        final int i3 = 2;
        this.isScrollingState = SnapshotStateKt.mutableStateOf$default(valueOf, i2, i3, i2);
        this.isLastScrollForwardState = SnapshotStateKt.mutableStateOf$default(valueOf, i2, i3, i2);
        this.isLastScrollBackwardState = SnapshotStateKt.mutableStateOf$default(valueOf, i2, i3, i2);
    }

    public static final MutatorMutex access$getScrollMutex$p(androidx.compose.foundation.gestures.DefaultScrollableState $this) {
        return $this.scrollMutex;
    }

    public static final androidx.compose.foundation.gestures.ScrollScope access$getScrollScope$p(androidx.compose.foundation.gestures.DefaultScrollableState $this) {
        return $this.scrollScope;
    }

    public static final MutableState access$isLastScrollBackwardState$p(androidx.compose.foundation.gestures.DefaultScrollableState $this) {
        return $this.isLastScrollBackwardState;
    }

    public static final MutableState access$isLastScrollForwardState$p(androidx.compose.foundation.gestures.DefaultScrollableState $this) {
        return $this.isLastScrollForwardState;
    }

    public static final MutableState access$isScrollingState$p(androidx.compose.foundation.gestures.DefaultScrollableState $this) {
        return $this.isScrollingState;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public float dispatchRawDelta(float delta) {
        return (Number)this.onDelta.invoke(Float.valueOf(delta)).floatValue();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean getLastScrolledBackward() {
        return (Boolean)this.isLastScrollBackwardState.getValue().booleanValue();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean getLastScrolledForward() {
        return (Boolean)this.isLastScrollForwardState.getValue().booleanValue();
    }

    public final Function1<Float, Float> getOnDelta() {
        return this.onDelta;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean isScrollInProgress() {
        return (Boolean)this.isScrollingState.getValue().booleanValue();
    }

    public Object scroll(MutatePriority scrollPriority, Function2<? super androidx.compose.foundation.gestures.ScrollScope, ? super Continuation<? super Unit>, ? extends Object> block, Continuation<? super Unit> $completion) {
        DefaultScrollableState.scroll.2 anon = new DefaultScrollableState.scroll.2(this, scrollPriority, block, 0);
        Object coroutineScope = CoroutineScopeKt.coroutineScope((Function2)anon, $completion);
        if (coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return coroutineScope;
        }
        return Unit.INSTANCE;
    }
}
