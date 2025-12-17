package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.OnGloballyPositionedModifier;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0008\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J\u000e\u0010\u000b\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u000cR\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r", d2 = {"Landroidx/compose/foundation/lazy/layout/AwaitFirstLayoutModifier;", "Landroidx/compose/ui/layout/OnGloballyPositionedModifier;", "()V", "continuation", "Lkotlin/coroutines/Continuation;", "", "wasPositioned", "", "onGloballyPositioned", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "waitForFirstLayout", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AwaitFirstLayoutModifier implements OnGloballyPositionedModifier {

    public static final int $stable;
    private Continuation<? super Unit> continuation;
    private boolean wasPositioned;
    static {
    }

    @Override // androidx.compose.ui.layout.OnGloballyPositionedModifier
    public void onGloballyPositioned(LayoutCoordinates coordinates) {
        boolean wasPositioned;
        Object constructor-impl;
        this.wasPositioned = true;
        Continuation continuation = this.continuation;
        if (!this.wasPositioned && continuation != null) {
            this.wasPositioned = true;
            continuation = this.continuation;
            if (continuation != null) {
                kotlin.Result.Companion companion = Result.Companion;
                continuation.resumeWith(Result.constructor-impl(Unit.INSTANCE));
            }
            this.continuation = 0;
        }
    }

    public final Object waitForFirstLayout(Continuation<? super Unit> continuation) {
        boolean anon;
        int i;
        Object cOROUTINE_SUSPENDED;
        int i2;
        Object constructor-impl;
        boolean wasPositioned;
        Object cOROUTINE_SUSPENDED2;
        SafeContinuation safeContinuation;
        int i3;
        Object obj8;
        anon = continuation;
        i2 = Integer.MIN_VALUE;
        if (continuation instanceof AwaitFirstLayoutModifier.waitForFirstLayout.1 && label &= i2 != 0) {
            anon = continuation;
            i2 = Integer.MIN_VALUE;
            if (label &= i2 != 0) {
                anon.label = obj8 -= i2;
            } else {
                anon = new AwaitFirstLayoutModifier.waitForFirstLayout.1(this, continuation);
            }
        } else {
        }
        obj8 = anon.result;
        cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label2) {
            case 0:
                ResultKt.throwOnFailure(obj8);
                constructor-impl = this;
                wasPositioned = constructor-impl.continuation;
                anon.L$0 = constructor-impl;
                anon.L$1 = wasPositioned;
                anon.label = 1;
                safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted((Continuation)anon));
                i3 = 0;
                constructor-impl.continuation = (Continuation)safeContinuation;
                constructor-impl = safeContinuation.getOrThrow();
                DebugProbesKt.probeCoroutineSuspended((Continuation)anon);
                return cOROUTINE_SUSPENDED;
                cOROUTINE_SUSPENDED = wasPositioned;
                return Unit.INSTANCE;
            case 1:
                cOROUTINE_SUSPENDED = anon.L$1;
                constructor-impl = anon.L$0;
                ResultKt.throwOnFailure(obj8);
                break;
            default:
                obj8 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj8;
        }
        if (cOROUTINE_SUSPENDED != null) {
            kotlin.Result.Companion companion = Result.Companion;
            cOROUTINE_SUSPENDED.resumeWith(Result.constructor-impl(Unit.INSTANCE));
        }
    }
}
