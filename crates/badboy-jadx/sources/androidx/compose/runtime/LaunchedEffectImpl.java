package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008\u0000\u0018\u00002\u00020\u0001B6\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012'\u0010\u0004\u001a#\u0008\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00080\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0005¢\u0006\u0002\u0008\n¢\u0006\u0002\u0010\u000bJ\u0008\u0010\u0010\u001a\u00020\u0008H\u0016J\u0008\u0010\u0011\u001a\u00020\u0008H\u0016J\u0008\u0010\u0012\u001a\u00020\u0008H\u0016R\u0010\u0010\u000c\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R1\u0010\u0004\u001a#\u0008\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00080\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0005¢\u0006\u0002\u0008\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000f¨\u0006\u0013", d2 = {"Landroidx/compose/runtime/LaunchedEffectImpl;", "Landroidx/compose/runtime/RememberObserver;", "parentCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "task", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)V", "job", "Lkotlinx/coroutines/Job;", "scope", "Lkotlin/jvm/functions/Function2;", "onAbandoned", "onForgotten", "onRemembered", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LaunchedEffectImpl implements androidx.compose.runtime.RememberObserver {

    public static final int $stable = 8;
    private Job job;
    private final CoroutineScope scope;
    private final Function2<CoroutineScope, Continuation<? super Unit>, Object> task;
    static {
        final int i = 8;
    }

    public LaunchedEffectImpl(CoroutineContext parentCoroutineContext, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> task) {
        super();
        this.task = task;
        this.scope = CoroutineScopeKt.CoroutineScope(parentCoroutineContext);
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onAbandoned() {
        androidx.compose.runtime.LeftCompositionCancellationException leftCompositionCancellationException;
        Job job = this.job;
        if (job != null) {
            leftCompositionCancellationException = new LeftCompositionCancellationException();
            job.cancel((CancellationException)leftCompositionCancellationException);
        }
        this.job = 0;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onForgotten() {
        androidx.compose.runtime.LeftCompositionCancellationException leftCompositionCancellationException;
        Job job = this.job;
        if (job != null) {
            leftCompositionCancellationException = new LeftCompositionCancellationException();
            job.cancel((CancellationException)leftCompositionCancellationException);
        }
        this.job = 0;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onRemembered() {
        String str;
        int i;
        int i2;
        Job job = this.job;
        if (job != null) {
            i2 = 0;
            JobKt.cancel$default(job, "Old job was still running!", i2, 2, i2);
        }
        this.job = BuildersKt.launch$default(this.scope, 0, 0, this.task, 3, 0);
    }
}
