package androidx.compose.foundation.relocation;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.geometry.Rect;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0008\u001a\u00020\t2\u0008\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096@¢\u0006\u0002\u0010\u000cR\u0017\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\r", d2 = {"Landroidx/compose/foundation/relocation/BringIntoViewRequesterImpl;", "Landroidx/compose/foundation/relocation/BringIntoViewRequester;", "()V", "modifiers", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/foundation/relocation/BringIntoViewRequesterNode;", "getModifiers", "()Landroidx/compose/runtime/collection/MutableVector;", "bringIntoView", "", "rect", "Landroidx/compose/ui/geometry/Rect;", "(Landroidx/compose/ui/geometry/Rect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class BringIntoViewRequesterImpl implements androidx.compose.foundation.relocation.BringIntoViewRequester {

    private final MutableVector<androidx.compose.foundation.relocation.BringIntoViewRequesterNode> modifiers;
    public BringIntoViewRequesterImpl() {
        super();
        final int i = 0;
        final int i3 = 0;
        MutableVector mutableVector = new MutableVector(new BringIntoViewRequesterNode[16], 0);
        this.modifiers = mutableVector;
    }

    public Object bringIntoView(Rect rect, Continuation<? super Unit> continuation2) {
        boolean anon;
        int i2;
        int i3;
        int modifiers;
        int i$iv2;
        int i$iv;
        int size;
        Object i$iv3;
        Object l$0;
        int i;
        Object obj;
        Object[] objArr;
        int obj12;
        Object obj13;
        anon = continuation2;
        i3 = Integer.MIN_VALUE;
        if (continuation2 instanceof BringIntoViewRequesterImpl.bringIntoView.1 && label &= i3 != 0) {
            anon = continuation2;
            i3 = Integer.MIN_VALUE;
            if (label &= i3 != 0) {
                anon.label = obj13 -= i3;
            } else {
                anon = new BringIntoViewRequesterImpl.bringIntoView.1(this, continuation2);
            }
        } else {
        }
        obj13 = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        final int i4 = 1;
        switch (label2) {
            case 0:
                ResultKt.throwOnFailure(obj13);
                modifiers = view.modifiers;
                l$0 = rect;
                obj12 = i$iv2;
                i$iv = i5;
                i$iv3 = objArr;
                return Unit.INSTANCE;
            case 1:
                obj12 = 0;
                modifiers = 0;
                i$iv = anon.I$1;
                size = anon.I$0;
                i$iv3 = anon.L$1;
                l$0 = anon.L$0;
                ResultKt.throwOnFailure(obj13);
                i$iv2 = obj12;
                return Unit.INSTANCE;
            default:
                obj12 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj12;
        }
        anon.L$0 = l$0;
        anon.L$1 = i$iv3;
        anon.I$0 = size;
        anon.I$1 = i$iv;
        anon.label = i4;
        if (ScrollIntoView.scrollIntoView((DelegatableNode)(BringIntoViewRequesterNode)i$iv3[i$iv], l$0, anon) != cOROUTINE_SUSPENDED) {
            modifiers = i;
        }
        return cOROUTINE_SUSPENDED;
    }

    public final MutableVector<androidx.compose.foundation.relocation.BringIntoViewRequesterNode> getModifiers() {
        return this.modifiers;
    }
}
