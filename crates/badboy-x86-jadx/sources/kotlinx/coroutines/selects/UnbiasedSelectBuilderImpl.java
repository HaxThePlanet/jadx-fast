package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0000\n\u0000\u0008\u0001\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0001J\n\u0010\u000c\u001a\u0004\u0018\u00010\rH\u0001R\u0014\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e", d2 = {"Lkotlinx/coroutines/selects/UnbiasedSelectBuilderImpl;", "R", "Lkotlinx/coroutines/selects/UnbiasedSelectImplementation;", "uCont", "Lkotlin/coroutines/Continuation;", "(Lkotlin/coroutines/Continuation;)V", "cont", "Lkotlinx/coroutines/CancellableContinuationImpl;", "handleBuilderException", "", "e", "", "initSelectResult", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class UnbiasedSelectBuilderImpl<R>  extends kotlinx.coroutines.selects.UnbiasedSelectImplementation<R> {

    private final CancellableContinuationImpl<R> cont;
    public UnbiasedSelectBuilderImpl(Continuation<? super R> uCont) {
        super(uCont.getContext());
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(uCont), 1);
        this.cont = cancellableContinuationImpl;
    }

    public static final CancellableContinuationImpl access$getCont$p(kotlinx.coroutines.selects.UnbiasedSelectBuilderImpl $this) {
        return $this.cont;
    }

    @Override // kotlinx.coroutines.selects.UnbiasedSelectImplementation
    public final void handleBuilderException(Throwable e) {
        kotlin.Result.Companion companion = Result.Companion;
        (Continuation)this.cont.resumeWith(Result.constructor-impl(ResultKt.createFailure(e)));
    }

    @Override // kotlinx.coroutines.selects.UnbiasedSelectImplementation
    public final Object initSelectResult() {
        if (this.cont.isCompleted()) {
            return this.cont.getResult();
        }
        final int i = 0;
        UnbiasedSelectBuilderImpl.initSelectResult.1 anon = new UnbiasedSelectBuilderImpl.initSelectResult.1(this, i);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(getContext()), i, CoroutineStart.UNDISPATCHED, (Function2)anon, 1, 0);
        return this.cont.getResult();
    }
}
