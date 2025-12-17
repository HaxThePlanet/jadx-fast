package kotlinx.coroutines.android;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.NonDisposableHandle;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0008\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\u0008\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001c\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015H\u0002J\u001c\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015H\u0016J\u0013\u0010\u0017\u001a\u00020\t2\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0096\u0002J\u0008\u0010\u001a\u001a\u00020\u001bH\u0016J$\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u00152\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010 \u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001e\u0010!\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001f2\u000c\u0010\"\u001a\u0008\u0012\u0004\u0012\u00020\u00100#H\u0016J\u0008\u0010$\u001a\u00020\u0006H\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000c\u001a\u00020\u0000X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%", d2 = {"Lkotlinx/coroutines/android/HandlerContext;", "Lkotlinx/coroutines/android/HandlerDispatcher;", "Lkotlinx/coroutines/Delay;", "handler", "Landroid/os/Handler;", "name", "", "(Landroid/os/Handler;Ljava/lang/String;)V", "invokeImmediately", "", "(Landroid/os/Handler;Ljava/lang/String;Z)V", "_immediate", "immediate", "getImmediate", "()Lkotlinx/coroutines/android/HandlerContext;", "cancelOnRejection", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dispatch", "equals", "other", "", "hashCode", "", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "", "isDispatchNeeded", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "toString", "kotlinx-coroutines-android"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HandlerContext extends kotlinx.coroutines.android.HandlerDispatcher implements Delay {

    private volatile kotlinx.coroutines.android.HandlerContext _immediate;
    private final Handler handler;
    private final kotlinx.coroutines.android.HandlerContext immediate;
    private final boolean invokeImmediately;
    private final String name;
    public static void $r8$lambda$AXU9Ipeju1KWZ01G6KHwtONG4Wk(kotlinx.coroutines.android.HandlerContext handlerContext, Runnable runnable2) {
        HandlerContext.invokeOnTimeout$lambda$3(handlerContext, runnable2);
    }

    public HandlerContext(Handler handler, String name) {
        super(handler, name, 0);
    }

    public HandlerContext(Handler handler, String string2, int i3, DefaultConstructorMarker defaultConstructorMarker4) {
        int obj2;
        obj2 = i3 &= 2 != 0 ? 0 : obj2;
        super(handler, obj2);
    }

    private HandlerContext(Handler handler, String name, boolean invokeImmediately) {
        int i;
        kotlinx.coroutines.android.HandlerContext handlerContext;
        boolean invokeImmediately2;
        int i3;
        int i2;
        super(0);
        this.handler = handler;
        this.name = name;
        this.invokeImmediately = invokeImmediately;
        i = this.invokeImmediately ? this : i;
        this._immediate = i;
        if (this._immediate == null) {
            handlerContext = new HandlerContext(this.handler, this.name, 1);
            i3 = 0;
            this._immediate = handlerContext;
        }
        this.immediate = handlerContext;
    }

    public static final Handler access$getHandler$p(kotlinx.coroutines.android.HandlerContext $this) {
        return $this.handler;
    }

    private final void cancelOnRejection(CoroutineContext context, Runnable block) {
        StringBuilder stringBuilder = new StringBuilder();
        CancellationException cancellationException = new CancellationException(stringBuilder.append("The task was rejected, the handler underlying the dispatcher '").append(this).append("' was closed").toString());
        JobKt.cancel(context, cancellationException);
        Dispatchers.getIO().dispatch(context, block);
    }

    private static final void invokeOnTimeout$lambda$3(kotlinx.coroutines.android.HandlerContext this$0, Runnable $block) {
        this$0.handler.removeCallbacks($block);
    }

    @Override // kotlinx.coroutines.android.HandlerDispatcher
    public void dispatch(CoroutineContext context, Runnable block) {
        if (!this.handler.post(block)) {
            cancelOnRejection(context, block);
        }
    }

    @Override // kotlinx.coroutines.android.HandlerDispatcher
    public boolean equals(Object other) {
        boolean handler2;
        int i;
        Handler handler;
        if (other instanceof HandlerContext != null && obj.handler == this.handler) {
            i = obj.handler == this.handler ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // kotlinx.coroutines.android.HandlerDispatcher
    public MainCoroutineDispatcher getImmediate() {
        return (MainCoroutineDispatcher)getImmediate();
    }

    @Override // kotlinx.coroutines.android.HandlerDispatcher
    public kotlinx.coroutines.android.HandlerContext getImmediate() {
        return this.immediate;
    }

    @Override // kotlinx.coroutines.android.HandlerDispatcher
    public kotlinx.coroutines.android.HandlerDispatcher getImmediate() {
        return (HandlerDispatcher)getImmediate();
    }

    @Override // kotlinx.coroutines.android.HandlerDispatcher
    public int hashCode() {
        return System.identityHashCode(this.handler);
    }

    @Override // kotlinx.coroutines.android.HandlerDispatcher
    public DisposableHandle invokeOnTimeout(long timeMillis, Runnable block, CoroutineContext context) {
        if (this.handler.postDelayed(context, RangesKt.coerceAtMost(timeMillis, block))) {
            HandlerContext$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new HandlerContext$$ExternalSyntheticLambda0(this, context);
            return externalSyntheticLambda0;
        }
        cancelOnRejection(obj7, context);
        return (DisposableHandle)NonDisposableHandle.INSTANCE;
    }

    @Override // kotlinx.coroutines.android.HandlerDispatcher
    public boolean isDispatchNeeded(CoroutineContext context) {
        int i;
        boolean invokeImmediately;
        Looper looper;
        if (this.invokeImmediately) {
            if (!Intrinsics.areEqual(Looper.myLooper(), this.handler.getLooper())) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    public void scheduleResumeAfterDelay(long timeMillis, CancellableContinuation<? super Unit> continuation) {
        Object context;
        int i = 0;
        HandlerContext.scheduleResumeAfterDelay$$inlined.Runnable.1 anon = new HandlerContext.scheduleResumeAfterDelay$$inlined.Runnable.1(obj7, this);
        if (this.handler.postDelayed((Runnable)anon, RangesKt.coerceAtMost(timeMillis, continuation))) {
            context = new HandlerContext.scheduleResumeAfterDelay.1(this, anon);
            obj7.invokeOnCancellation((Function1)context);
        } else {
            cancelOnRejection(obj7.getContext(), anon);
        }
    }

    @Override // kotlinx.coroutines.android.HandlerDispatcher
    public String toString() {
        String $this$toString_u24lambda_u244;
        int i;
        String string;
        boolean invokeImmediately;
        String str;
        Object obj = this;
        i = 0;
        if (toStringInternalImpl() == null && obj.name == null) {
            obj = this;
            i = 0;
            if (obj.name == null) {
                string = obj.handler.toString();
            }
            if (obj.invokeImmediately) {
                StringBuilder stringBuilder = new StringBuilder();
                $this$toString_u24lambda_u244 = invokeImmediately;
            } else {
                $this$toString_u24lambda_u244 = string;
            }
        }
        return $this$toString_u24lambda_u244;
    }
}
