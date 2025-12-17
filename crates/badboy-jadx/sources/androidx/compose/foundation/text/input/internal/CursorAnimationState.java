package androidx.compose.foundation.text.input.internal;

import androidx.compose.runtime.FloatState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.Job.DefaultImpls;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0008\n\u0002\u0010\u0002\n\u0002\u0008\u0003\u0008\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010\u0013R\"\u0010\u0003\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0005`\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\t\u001a\u00020\u00082\u0006\u0010\u0007\u001a\u00020\u00088F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\n\u0010\u000b\"\u0004\u0008\u000c\u0010\r¨\u0006\u0014", d2 = {"Landroidx/compose/foundation/text/input/internal/CursorAnimationState;", "", "()V", "animationJob", "Ljava/util/concurrent/atomic/AtomicReference;", "Lkotlinx/coroutines/Job;", "Landroidx/compose/foundation/AtomicReference;", "<set-?>", "", "cursorAlpha", "getCursorAlpha", "()F", "setCursorAlpha", "(F)V", "cursorAlpha$delegate", "Landroidx/compose/runtime/MutableFloatState;", "cancelAndHide", "", "snapToVisibleAndAnimate", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CursorAnimationState {

    public static final int $stable = 8;
    private AtomicReference<Job> animationJob;
    private final MutableFloatState cursorAlpha$delegate;
    static {
        final int i = 8;
    }

    public CursorAnimationState() {
        super();
        AtomicReference atomicReference = new AtomicReference(0);
        this.animationJob = atomicReference;
        this.cursorAlpha$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(0);
    }

    public static final AtomicReference access$getAnimationJob$p(androidx.compose.foundation.text.input.internal.CursorAnimationState $this) {
        return $this.animationJob;
    }

    public static final void access$setCursorAlpha(androidx.compose.foundation.text.input.internal.CursorAnimationState $this, float <set-?>) {
        $this.setCursorAlpha(<set-?>);
    }

    private final void setCursorAlpha(float <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.cursorAlpha$delegate.setFloatValue(<set-?>);
    }

    public final void cancelAndHide() {
        int i;
        final int i2 = 0;
        Object andSet = this.animationJob.getAndSet(i2);
        if ((Job)andSet != null) {
            Job.DefaultImpls.cancel$default((Job)andSet, i2, 1, i2);
        }
    }

    public final float getCursorAlpha() {
        final int i = 0;
        final int i2 = 0;
        return (FloatState)this.cursorAlpha$delegate.getFloatValue();
    }

    public final Object snapToVisibleAndAnimate(Continuation<? super Unit> $completion) {
        CursorAnimationState.snapToVisibleAndAnimate.2 anon = new CursorAnimationState.snapToVisibleAndAnimate.2(this, 0);
        Object coroutineScope = CoroutineScopeKt.coroutineScope((Function2)anon, $completion);
        if (coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return coroutineScope;
        }
        return Unit.INSTANCE;
    }
}
