package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008f\u0018\u00002\u00020\u0001JA\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082'\u0010\t\u001a#\u0008\u0001\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00060\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n¢\u0006\u0002\u0008\rH¦@¢\u0006\u0002\u0010\u000eR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0002\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u000fÀ\u0006\u0003", d2 = {"Landroidx/compose/foundation/gestures/TransformableState;", "", "isTransformInProgress", "", "()Z", "transform", "", "transformPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/TransformScope;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface TransformableState {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static Object transform$default(androidx.compose.foundation.gestures.TransformableState transformableState, MutatePriority mutatePriority2, Function2 function23, Continuation continuation4, int i5, Object object6) {
            return TransformableState.transform$default(transformableState, mutatePriority2, function23, continuation4, i5, object6);
        }
    }
    public static Object transform$default(androidx.compose.foundation.gestures.TransformableState transformableState, MutatePriority mutatePriority2, Function2 function23, Continuation continuation4, int i5, Object object6) {
        MutatePriority obj1;
        if (object6 != null) {
        } else {
            if (i5 &= 1 != 0) {
                obj1 = MutatePriority.Default;
            }
            return transformableState.transform(obj1, function23, continuation4);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: transform");
        throw obj0;
    }

    public abstract boolean isTransformInProgress();

    public abstract Object transform(MutatePriority mutatePriority, Function2<? super androidx.compose.foundation.gestures.TransformScope, ? super Continuation<? super Unit>, ? extends Object> function22, Continuation<? super Unit> continuation3);
}
