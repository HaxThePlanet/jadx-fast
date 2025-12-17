package androidx.activity;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\u001a0\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u001c\u0010\u0003\u001a\u0018\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004H\u0086H¢\u0006\u0002\u0010\u0007¨\u0006\u0008", d2 = {"reportWhenComplete", "", "Landroidx/activity/FullyDrawnReporter;", "reporter", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Landroidx/activity/FullyDrawnReporter;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "activity_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FullyDrawnReporterKt {
    public static final Object reportWhenComplete(androidx.activity.FullyDrawnReporter fullyDrawnReporter, Function1<? super Continuation<? super Unit>, ? extends Object> function12, Continuation<? super Unit> $completion) {
        boolean anon;
        int i;
        Throwable th;
        int label;
        Object invoke;
        int obj5;
        Object obj6;
        anon = $completion;
        th = Integer.MIN_VALUE;
        if ($completion instanceof FullyDrawnReporterKt.reportWhenComplete.1 && label2 &= th != 0) {
            anon = $completion;
            th = Integer.MIN_VALUE;
            if (label2 &= th != 0) {
                anon.label = label3 -= th;
            } else {
                anon = new FullyDrawnReporterKt.reportWhenComplete.1($completion);
            }
        } else {
        }
        Object result = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label) {
            case 0:
                ResultKt.throwOnFailure(result);
                fullyDrawnReporter.addReporter();
                return Unit.INSTANCE;
                anon.L$0 = fullyDrawnReporter;
                anon.label = 1;
                return cOROUTINE_SUSPENDED;
                obj6 = fullyDrawnReporter;
                obj5 = label;
                break;
            case 1:
                obj5 = 0;
                obj6 = anon.L$0;
                ResultKt.throwOnFailure(result);
                break;
            default:
                obj5 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj5;
        }
        obj6.removeReporter();
        return Unit.INSTANCE;
    }

    private static final Object reportWhenComplete$$forInline(androidx.activity.FullyDrawnReporter $this$reportWhenComplete, Function1<? super Continuation<? super Unit>, ? extends Object> reporter, Continuation<? super Unit> $completion) {
        final int i = 0;
        $this$reportWhenComplete.addReporter();
        if ($this$reportWhenComplete.isFullyDrawnReported()) {
            return Unit.INSTANCE;
        }
        reporter.invoke($completion);
        $this$reportWhenComplete.removeReporter();
        return Unit.INSTANCE;
    }
}
