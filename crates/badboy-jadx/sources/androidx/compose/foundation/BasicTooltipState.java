package androidx.compose.foundation;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008g\u0018\u00002\u00020\u0001J\u0008\u0010\u0006\u001a\u00020\u0007H&J\u0008\u0010\u0008\u001a\u00020\u0007H&J\u0018\u0010\t\u001a\u00020\u00072\u0008\u0008\u0002\u0010\n\u001a\u00020\u000bH¦@¢\u0006\u0002\u0010\u000cR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0002\u0010\u0004R\u0012\u0010\u0005\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\rÀ\u0006\u0001", d2 = {"Landroidx/compose/foundation/BasicTooltipState;", "", "isPersistent", "", "()Z", "isVisible", "dismiss", "", "onDispose", "show", "mutatePriority", "Landroidx/compose/foundation/MutatePriority;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface BasicTooltipState {
    public static Object show$default(androidx.compose.foundation.BasicTooltipState basicTooltipState, androidx.compose.foundation.MutatePriority mutatePriority2, Continuation continuation3, int i4, Object object5) {
        androidx.compose.foundation.MutatePriority obj1;
        if (object5 != null) {
        } else {
            if (i4 &= 1 != 0) {
                obj1 = MutatePriority.Default;
            }
            return basicTooltipState.show(obj1, continuation3);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: show");
        throw obj0;
    }

    public abstract void dismiss();

    public abstract boolean isPersistent();

    public abstract boolean isVisible();

    public abstract void onDispose();

    public abstract Object show(androidx.compose.foundation.MutatePriority mutatePriority, Continuation<? super Unit> continuation2);
}
