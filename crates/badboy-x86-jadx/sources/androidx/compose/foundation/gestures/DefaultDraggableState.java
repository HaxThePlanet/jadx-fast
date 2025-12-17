package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScopeKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0004H\u0016J?\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112'\u0010\u0012\u001a#\u0008\u0001\u0012\u0004\u0012\u00020\u0008\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00050\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0013¢\u0006\u0002\u0008\u0016H\u0096@¢\u0006\u0002\u0010\u0017R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\u000cX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018", d2 = {"Landroidx/compose/foundation/gestures/DefaultDraggableState;", "Landroidx/compose/foundation/gestures/DraggableState;", "onDelta", "Lkotlin/Function1;", "", "", "(Lkotlin/jvm/functions/Function1;)V", "dragScope", "Landroidx/compose/foundation/gestures/DragScope;", "getOnDelta", "()Lkotlin/jvm/functions/Function1;", "scrollMutex", "Landroidx/compose/foundation/MutatorMutex;", "dispatchRawDelta", "delta", "drag", "dragPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class DefaultDraggableState implements androidx.compose.foundation.gestures.DraggableState {

    private final androidx.compose.foundation.gestures.DragScope dragScope;
    private final Function1<Float, Unit> onDelta;
    private final MutatorMutex scrollMutex;
    public DefaultDraggableState(Function1<? super Float, Unit> onDelta) {
        super();
        this.onDelta = onDelta;
        DefaultDraggableState.dragScope.1 anon = new DefaultDraggableState.dragScope.1(this);
        this.dragScope = (DragScope)anon;
        MutatorMutex mutatorMutex = new MutatorMutex();
        this.scrollMutex = mutatorMutex;
    }

    public static final androidx.compose.foundation.gestures.DragScope access$getDragScope$p(androidx.compose.foundation.gestures.DefaultDraggableState $this) {
        return $this.dragScope;
    }

    public static final MutatorMutex access$getScrollMutex$p(androidx.compose.foundation.gestures.DefaultDraggableState $this) {
        return $this.scrollMutex;
    }

    @Override // androidx.compose.foundation.gestures.DraggableState
    public void dispatchRawDelta(float delta) {
        this.onDelta.invoke(Float.valueOf(delta));
    }

    public Object drag(MutatePriority dragPriority, Function2<? super androidx.compose.foundation.gestures.DragScope, ? super Continuation<? super Unit>, ? extends Object> block, Continuation<? super Unit> $completion) {
        DefaultDraggableState.drag.2 anon = new DefaultDraggableState.drag.2(this, dragPriority, block, 0);
        Object coroutineScope = CoroutineScopeKt.coroutineScope((Function2)anon, $completion);
        if (coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return coroutineScope;
        }
        return Unit.INSTANCE;
    }

    public final Function1<Float, Unit> getOnDelta() {
        return this.onDelta;
    }
}
