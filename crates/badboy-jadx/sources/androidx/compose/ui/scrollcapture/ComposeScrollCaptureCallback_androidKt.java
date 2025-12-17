package androidx.compose.ui.scrollcapture;

import android.os.CancellationSignal;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.Job.DefaultImpls;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001aB\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082'\u0010\t\u001a#\u0008\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000c0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r0\n¢\u0006\u0002\u0008\u000eH\u0002¢\u0006\u0002\u0010\u000f\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010", d2 = {"DEBUG", "", "TAG", "", "launchWithCancellationSignal", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CoroutineScope;", "signal", "Landroid/os/CancellationSignal;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/CoroutineScope;Landroid/os/CancellationSignal;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ComposeScrollCaptureCallback_androidKt {

    private static final boolean DEBUG = false;
    private static final String TAG = "ScrollCapture";
    public static void $r8$lambda$D0mBs1SNEZATJcjSNqO_xrqgagQ(Job job) {
        ComposeScrollCaptureCallback_androidKt.launchWithCancellationSignal$lambda$0(job);
    }

    public static final Job access$launchWithCancellationSignal(CoroutineScope $receiver, CancellationSignal signal, Function2 block) {
        return ComposeScrollCaptureCallback_androidKt.launchWithCancellationSignal($receiver, signal, block);
    }

    private static final Job launchWithCancellationSignal(CoroutineScope $this$launchWithCancellationSignal, CancellationSignal signal, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> block) {
        final Job obj6 = BuildersKt.launch$default($this$launchWithCancellationSignal, 0, 0, block, 3, 0);
        ComposeScrollCaptureCallback_androidKt.launchWithCancellationSignal.1 obj8 = new ComposeScrollCaptureCallback_androidKt.launchWithCancellationSignal.1(signal);
        obj6.invokeOnCompletion((Function1)obj8);
        obj8 = new ComposeScrollCaptureCallback_androidKt$$ExternalSyntheticLambda0(obj6);
        signal.setOnCancelListener(obj8);
        return obj6;
    }

    private static final void launchWithCancellationSignal$lambda$0(Job $job) {
        final int i = 0;
        Job.DefaultImpls.cancel$default($job, i, 1, i);
    }
}
