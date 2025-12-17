package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.g;
import kotlin.b0.j.b;
import kotlin.b0.k.a.e;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.w;
import kotlinx.coroutines.internal.g;
import kotlinx.coroutines.internal.y;
import kotlinx.coroutines.internal.z;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000¶\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0001\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0011\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0010\u000e\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0008\u0011\u0018\u0000*\u0006\u0008\u0000\u0010\u0001 \u00002\t\u0012\u0004\u0012\u00028\u00000\u008a\u00012\t\u0012\u0004\u0012\u00028\u00000\u008b\u00012\u00060tj\u0002`uB\u001d\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\u0008\u0006\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\n2\u0008\u0010\t\u001a\u0004\u0018\u00010\u0008H\u0002¢\u0006\u0004\u0008\u000b\u0010\u000cJ\u001f\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\u0008\u0012\u0010\u0013JB\u0010\u0012\u001a\u00020\u00112'\u0010\u000e\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\u000c\u0008\u0015\u0012\u0008\u0008\u0016\u0012\u0004\u0008\u0008(\u0010\u0012\u0004\u0012\u00020\u00110\u0014j\u0002`\u00172\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\u0008\u0012\u0010\u0018J\u001e\u0010\u001b\u001a\u00020\u00112\u000c\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u0019H\u0082\u0008¢\u0006\u0004\u0008\u001b\u0010\u001cJ8\u0010\u001e\u001a\u00020\u00112!\u0010\u001d\u001a\u001d\u0012\u0013\u0012\u00110\u000f¢\u0006\u000c\u0008\u0015\u0012\u0008\u0008\u0016\u0012\u0004\u0008\u0008(\u0010\u0012\u0004\u0012\u00020\u00110\u00142\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\u0008\u001e\u0010\u0018J\u0019\u0010 \u001a\u00020\u001f2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\u0008 \u0010!J!\u0010%\u001a\u00020\u00112\u0008\u0010\"\u001a\u0004\u0018\u00010\u00082\u0006\u0010\u0010\u001a\u00020\u000fH\u0010¢\u0006\u0004\u0008#\u0010$J\u0017\u0010&\u001a\u00020\u001f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\u0008&\u0010!J\u0017\u0010(\u001a\u00020\u00112\u0006\u0010'\u001a\u00020\u0008H\u0016¢\u0006\u0004\u0008(\u0010)J\u000f\u0010,\u001a\u00020\u0011H\u0000¢\u0006\u0004\u0008*\u0010+J\u000f\u0010-\u001a\u00020\u0011H\u0002¢\u0006\u0004\u0008-\u0010+J\u0017\u0010/\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u0004H\u0002¢\u0006\u0004\u0008/\u00100J\u0017\u00103\u001a\u00020\u000f2\u0006\u00102\u001a\u000201H\u0016¢\u0006\u0004\u00083\u00104J\u001b\u00108\u001a\u0004\u0018\u00010\u000f2\u0008\u00105\u001a\u0004\u0018\u00010\u0008H\u0010¢\u0006\u0004\u00086\u00107J\u0011\u00109\u001a\u0004\u0018\u00010\u0008H\u0001¢\u0006\u0004\u00089\u0010:J\u0017\u0010=\u001a\n\u0018\u00010;j\u0004\u0018\u0001`<H\u0016¢\u0006\u0004\u0008=\u0010>J\u001f\u0010A\u001a\u00028\u0001\"\u0004\u0008\u0001\u0010\u00012\u0008\u00105\u001a\u0004\u0018\u00010\u0008H\u0010¢\u0006\u0004\u0008?\u0010@J\u000f\u0010B\u001a\u00020\u0011H\u0016¢\u0006\u0004\u0008B\u0010+J\u0011\u0010D\u001a\u0004\u0018\u00010CH\u0002¢\u0006\u0004\u0008D\u0010EJ8\u0010F\u001a\u00020\u00112'\u0010\u000e\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\u000c\u0008\u0015\u0012\u0008\u0008\u0016\u0012\u0004\u0008\u0008(\u0010\u0012\u0004\u0012\u00020\u00110\u0014j\u0002`\u0017H\u0016¢\u0006\u0004\u0008F\u0010GJ\u000f\u0010H\u001a\u00020\u001fH\u0002¢\u0006\u0004\u0008H\u0010IJ8\u0010J\u001a\u00020\r2'\u0010\u000e\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\u000c\u0008\u0015\u0012\u0008\u0008\u0016\u0012\u0004\u0008\u0008(\u0010\u0012\u0004\u0012\u00020\u00110\u0014j\u0002`\u0017H\u0002¢\u0006\u0004\u0008J\u0010KJB\u0010L\u001a\u00020\u00112'\u0010\u000e\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\u000c\u0008\u0015\u0012\u0008\u0008\u0016\u0012\u0004\u0008\u0008(\u0010\u0012\u0004\u0012\u00020\u00110\u0014j\u0002`\u00172\u0008\u00105\u001a\u0004\u0018\u00010\u0008H\u0002¢\u0006\u0004\u0008L\u0010MJ\u000f\u0010O\u001a\u00020NH\u0014¢\u0006\u0004\u0008O\u0010PJ\u0017\u0010S\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0000¢\u0006\u0004\u0008Q\u0010RJ\u000f\u0010T\u001a\u00020\u0011H\u0002¢\u0006\u0004\u0008T\u0010+J\u000f\u0010U\u001a\u00020\u001fH\u0001¢\u0006\u0004\u0008U\u0010IJ<\u0010W\u001a\u00020\u00112\u0006\u0010V\u001a\u00028\u00002#\u0010\u001d\u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\u000c\u0008\u0015\u0012\u0008\u0008\u0016\u0012\u0004\u0008\u0008(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0014H\u0016¢\u0006\u0004\u0008W\u0010XJH\u0010Y\u001a\u00020\u00112\u0008\u0010\t\u001a\u0004\u0018\u00010\u00082\u0006\u0010\u0005\u001a\u00020\u00042%\u0008\u0002\u0010\u001d\u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\u000c\u0008\u0015\u0012\u0008\u0008\u0016\u0012\u0004\u0008\u0008(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0014H\u0002¢\u0006\u0004\u0008Y\u0010ZJ \u0010]\u001a\u00020\u00112\u000c\u0010\\\u001a\u0008\u0012\u0004\u0012\u00028\u00000[H\u0016ø\u0001\u0000¢\u0006\u0004\u0008]\u0010)JZ\u0010`\u001a\u0004\u0018\u00010\u00082\u0006\u00105\u001a\u00020^2\u0008\u0010\t\u001a\u0004\u0018\u00010\u00082\u0006\u0010\u0005\u001a\u00020\u00042#\u0010\u001d\u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\u000c\u0008\u0015\u0012\u0008\u0008\u0016\u0012\u0004\u0008\u0008(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00142\u0008\u0010_\u001a\u0004\u0018\u00010\u0008H\u0002¢\u0006\u0004\u0008`\u0010aJ\u0011\u0010c\u001a\u0004\u0018\u00010\u0008H\u0010¢\u0006\u0004\u0008b\u0010:J\u000f\u0010d\u001a\u00020NH\u0016¢\u0006\u0004\u0008d\u0010PJ\u000f\u0010e\u001a\u00020\u001fH\u0002¢\u0006\u0004\u0008e\u0010IJ#\u0010e\u001a\u0004\u0018\u00010\u00082\u0006\u0010V\u001a\u00028\u00002\u0008\u0010_\u001a\u0004\u0018\u00010\u0008H\u0016¢\u0006\u0004\u0008e\u0010fJH\u0010e\u001a\u0004\u0018\u00010\u00082\u0006\u0010V\u001a\u00028\u00002\u0008\u0010_\u001a\u0004\u0018\u00010\u00082#\u0010\u001d\u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\u000c\u0008\u0015\u0012\u0008\u0008\u0016\u0012\u0004\u0008\u0008(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0014H\u0016¢\u0006\u0004\u0008e\u0010gJJ\u0010i\u001a\u0004\u0018\u00010h2\u0008\u0010\t\u001a\u0004\u0018\u00010\u00082\u0008\u0010_\u001a\u0004\u0018\u00010\u00082#\u0010\u001d\u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\u000c\u0008\u0015\u0012\u0008\u0008\u0016\u0012\u0004\u0008\u0008(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0014H\u0002¢\u0006\u0004\u0008i\u0010jJ\u0019\u0010l\u001a\u0004\u0018\u00010\u00082\u0006\u0010k\u001a\u00020\u000fH\u0016¢\u0006\u0004\u0008l\u0010mJ\u000f\u0010n\u001a\u00020\u001fH\u0002¢\u0006\u0004\u0008n\u0010IJ\u001b\u0010p\u001a\u00020\u0011*\u00020o2\u0006\u0010V\u001a\u00028\u0000H\u0016¢\u0006\u0004\u0008p\u0010qJ\u001b\u0010r\u001a\u00020\u0011*\u00020o2\u0006\u0010k\u001a\u00020\u000fH\u0016¢\u0006\u0004\u0008r\u0010sR\u001c\u0010x\u001a\n\u0018\u00010tj\u0004\u0018\u0001`u8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008v\u0010wR\u001a\u0010z\u001a\u00020y8\u0016X\u0096\u0004¢\u0006\u000c\n\u0004\u0008z\u0010{\u001a\u0004\u0008|\u0010}R!\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00028\u0000X\u0080\u0004¢\u0006\r\n\u0004\u0008\u0003\u0010~\u001a\u0005\u0008\u007f\u0010\u0080\u0001R\u0016\u0010\u0081\u0001\u001a\u00020\u001f8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\u0008\u0081\u0001\u0010IR\u0016\u0010\u0082\u0001\u001a\u00020\u001f8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\u0008\u0082\u0001\u0010IR\u0016\u0010\u0083\u0001\u001a\u00020\u001f8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\u0008\u0083\u0001\u0010IR\u001b\u0010\u0084\u0001\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e¢\u0006\u0008\n\u0006\u0008\u0084\u0001\u0010\u0085\u0001R\u0017\u00105\u001a\u0004\u0018\u00010\u00088@X\u0080\u0004¢\u0006\u0007\u001a\u0005\u0008\u0086\u0001\u0010:R\u0016\u0010\u0088\u0001\u001a\u00020N8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\u0008\u0087\u0001\u0010P\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u0089\u0001", d2 = {"Lkotlinx/coroutines/CancellableContinuationImpl;", "T", "Lkotlin/coroutines/Continuation;", "delegate", "", "resumeMode", "<init>", "(Lkotlin/coroutines/Continuation;I)V", "", "proposedUpdate", "", "alreadyResumedError", "(Ljava/lang/Object;)Ljava/lang/Void;", "Lkotlinx/coroutines/CancelHandler;", "handler", "", "cause", "", "callCancelHandler", "(Lkotlinx/coroutines/CancelHandler;Ljava/lang/Throwable;)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Throwable;)V", "Lkotlin/Function0;", "block", "callCancelHandlerSafely", "(Lkotlin/jvm/functions/Function0;)V", "onCancellation", "callOnCancellation", "", "cancel", "(Ljava/lang/Throwable;)Z", "takenState", "cancelCompletedResult$kotlinx_coroutines_core", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "cancelCompletedResult", "cancelLater", "token", "completeResume", "(Ljava/lang/Object;)V", "detachChild$kotlinx_coroutines_core", "()V", "detachChild", "detachChildIfNonResuable", "mode", "dispatchResume", "(I)V", "Lkotlinx/coroutines/Job;", "parent", "getContinuationCancellationCause", "(Lkotlinx/coroutines/Job;)Ljava/lang/Throwable;", "state", "getExceptionalResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "getExceptionalResult", "getResult", "()Ljava/lang/Object;", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "getSuccessfulResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Object;", "getSuccessfulResult", "initCancellability", "Lkotlinx/coroutines/DisposableHandle;", "installParentHandle", "()Lkotlinx/coroutines/DisposableHandle;", "invokeOnCancellation", "(Lkotlin/jvm/functions/Function1;)V", "isReusable", "()Z", "makeCancelHandler", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/CancelHandler;", "multipleHandlersError", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)V", "", "nameString", "()Ljava/lang/String;", "parentCancelled$kotlinx_coroutines_core", "(Ljava/lang/Throwable;)V", "parentCancelled", "releaseClaimedReusableContinuation", "resetStateReusable", "value", "resume", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "resumeImpl", "(Ljava/lang/Object;ILkotlin/jvm/functions/Function1;)V", "Lkotlin/Result;", "result", "resumeWith", "Lkotlinx/coroutines/NotCompleted;", "idempotent", "resumedState", "(Lkotlinx/coroutines/NotCompleted;Ljava/lang/Object;ILkotlin/jvm/functions/Function1;Ljava/lang/Object;)Ljava/lang/Object;", "takeState$kotlinx_coroutines_core", "takeState", "toString", "tryResume", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/Symbol;", "tryResumeImpl", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/internal/Symbol;", "exception", "tryResumeWithException", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "trySuspend", "Lkotlinx/coroutines/CoroutineDispatcher;", "resumeUndispatched", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Object;)V", "resumeUndispatchedWithException", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Throwable;)V", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "callerFrame", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "Lkotlin/coroutines/Continuation;", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "isActive", "isCancelled", "isCompleted", "parentHandle", "Lkotlinx/coroutines/DisposableHandle;", "getState$kotlinx_coroutines_core", "getStateDebugRepresentation", "stateDebugRepresentation", "kotlinx-coroutines-core", "Lkotlinx/coroutines/DispatchedTask;", "Lkotlinx/coroutines/CancellableContinuation;"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class q<T>  extends kotlinx.coroutines.z0<T> implements kotlinx.coroutines.p<T>, e {

    private static final AtomicIntegerFieldUpdater y;
    private static final AtomicReferenceFieldUpdater z;
    private volatile int _decision = 0;
    private volatile Object _state;
    private final d<T> v;
    private final g w;
    private kotlinx.coroutines.e1 x;
    static {
        q.y = AtomicIntegerFieldUpdater.newUpdater(q.class, "_decision");
        q.z = AtomicReferenceFieldUpdater.newUpdater(q.class, Object.class, "_state");
    }

    public q(d<? super T> d, int i2) {
        boolean z;
        int obj4;
        super(i2);
        this.v = d;
        if (q0.a()) {
            obj4 = i2 != -1 ? 1 : i;
            if (obj4 == null) {
            } else {
            }
            AssertionError obj3 = new AssertionError();
            throw obj3;
        }
        this.w = d.getContext();
        this._state = f.a;
    }

    private final String A() {
        String str;
        Object obj = z();
        str = obj instanceof m2 ? "Active" : z ? "Cancelled" : "Completed";
        return str;
    }

    private final kotlinx.coroutines.e1 C() {
        kotlin.b0.g.b bVar3 = bVar;
        if ((y1)bVar3 == null) {
            return null;
        }
        u uVar = new u(this);
        kotlinx.coroutines.e1 e1Var = y1.a.d((y1)bVar3, true, false, uVar, 2, 0);
        this.x = e1Var;
        return e1Var;
    }

    private final boolean D() {
        boolean z;
        int i;
        if (a1.c(this.c) && (g)this.v.q()) {
            i = (g)this.v.q() ? 1 : 0;
        } else {
        }
        return i;
    }

    private final kotlinx.coroutines.n E(l<? super Throwable, w> l) {
        boolean v1Var;
        Object obj2;
        if (l instanceof n) {
        } else {
            v1Var = new v1((n)l);
            obj2 = v1Var;
        }
        return obj2;
    }

    private final void F(l<? super Throwable, w> l, Object object2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("It's prohibited to register multiple handlers, tried to register ");
        stringBuilder.append(l);
        stringBuilder.append(", already has ");
        stringBuilder.append(object2);
        IllegalStateException obj4 = new IllegalStateException(stringBuilder.toString().toString());
        throw obj4;
    }

    private final void I() {
        int dVar;
        Throwable i;
        if (dVar instanceof g) {
        } else {
            dVar = i;
        }
        if (dVar == 0) {
        } else {
            i = dVar.u(this);
        }
        if (i == null) {
        }
        s();
        p(i);
    }

    private final void K(Object object, int i2, l<? super Throwable, w> l3) {
        Object obj9;
        boolean obj10;
        Object _state = this._state;
        while (_state instanceof m2) {
            _state = this._state;
        }
        if (!_state instanceof t) {
        } else {
            if (!(t)_state.c()) {
            } else {
                if (l3 == null) {
                } else {
                    q(l3, _state.a);
                }
            }
        }
        m(object);
        throw 0;
    }

    static void L(kotlinx.coroutines.q q, Object object2, int i3, l l4, int i5, Object object6) {
        int obj3;
        if (object6 != null) {
        } else {
            if (i5 &= 4 != 0) {
                obj3 = 0;
            }
            q.K(object2, i3, obj3);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
        throw obj0;
    }

    private final Object M(kotlinx.coroutines.m2 m2, Object object2, int i3, l<? super Throwable, w> l4, Object object5) {
        int i2;
        Object obj2;
        Object obj;
        l lVar;
        Object obj3;
        int i4;
        int i5;
        int i;
        int obj9;
        Object obj10;
        int obj11;
        if (object2 instanceof b0) {
            i2 = 0;
            if (q0.a()) {
                obj9 = object5 == null ? obj11 : i2;
                if (obj9 == null) {
                } else {
                }
                obj9 = new AssertionError();
                throw obj9;
            }
            if (q0.a()) {
                if (l4 == null) {
                } else {
                    obj11 = i2;
                }
                if (obj11 == null) {
                } else {
                }
                obj9 = new AssertionError();
                throw obj9;
            }
        } else {
            if (!a1.b(i3) && object5 == null) {
                if (object5 == null) {
                } else {
                    if (l4 == null) {
                        if (m2 instanceof n) {
                            if (m2 instanceof i) {
                                if (object5 != null) {
                                    if (m2 instanceof n) {
                                    } else {
                                        obj9 = 0;
                                    }
                                    super(object2, obj9, l4, object5, 0, 16, 0);
                                    obj10 = obj11;
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                }
            } else {
            }
        }
        return obj10;
    }

    private final boolean N() {
        int _decision = this._decision;
        int i = 0;
        final int i2 = 1;
        while (_decision != 0) {
            _decision = this._decision;
            i = 0;
            i2 = 1;
        }
        if (_decision != i2) {
        } else {
            return i;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Already resumed".toString());
        throw illegalStateException;
    }

    private final z O(Object object, Object object2, l<? super Throwable, w> l3) {
        int i;
        Object obj9;
        boolean obj10;
        boolean obj11;
        Object _state = this._state;
        while (_state instanceof m2) {
            _state = this._state;
        }
        i = 0;
        if (_state instanceof a0 && object2 != null && _state.d == object2 && q0.a()) {
            if (object2 != null) {
                if (_state.d == object2) {
                    if (q0.a()) {
                        if (!n.b(_state.a, object)) {
                        } else {
                        }
                        obj9 = new AssertionError();
                        throw obj9;
                    }
                    i = r.a;
                }
            }
        }
        return i;
    }

    private final boolean P() {
        int _decision = this._decision;
        int i = 0;
        while (_decision != 0) {
            int i3 = 1;
            _decision = this._decision;
            i = 0;
        }
        if (_decision != 2) {
        } else {
            return i;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Already suspended".toString());
        throw illegalStateException;
    }

    private final Void m(Object object) {
        IllegalStateException illegalStateException = new IllegalStateException(n.o("Already resumed, but proposed with update ", object).toString());
        throw illegalStateException;
    }

    private final void n(l<? super Throwable, w> l, Throwable throwable2) {
        kotlinx.coroutines.CompletionHandlerException completionHandlerException;
        String str;
        Throwable obj3;
        Object obj4;
        try {
            l.invoke(throwable2);
            throwable2 = getContext();
            str = "Exception in invokeOnCancellation handler for ";
            str = n.o(str, this);
            completionHandlerException = new CompletionHandlerException(str, l);
            j0.a(throwable2, completionHandlerException);
        }
    }

    private final boolean r(Throwable throwable) {
        if (!D()) {
            return 0;
        }
        return (g)this.v.r(throwable);
    }

    private final void u() {
        if (!D()) {
            s();
        }
    }

    private final void v(int i) {
        if (N()) {
        }
        a1.a(this, i);
    }

    @Override // kotlinx.coroutines.z0
    public void B() {
        kotlinx.coroutines.e1 e1Var;
        e1Var = C();
        if (e1Var == null) {
        }
        if (t()) {
            e1Var.dispose();
            this.x = l2.a;
        }
    }

    @Override // kotlinx.coroutines.z0
    protected String G() {
        return "CancellableContinuation";
    }

    @Override // kotlinx.coroutines.z0
    public final void H(Throwable throwable) {
        if (r(throwable)) {
        }
        p(throwable);
        u();
    }

    @Override // kotlinx.coroutines.z0
    public final boolean J() {
        int z3;
        boolean z;
        Object _state;
        int i;
        boolean z2;
        final int i3 = 1;
        final int i4 = 0;
        if (q0.a()) {
            z3 = this.c == 2 ? i3 : i4;
            if (z3 == 0) {
            } else {
            }
            AssertionError assertionError = new AssertionError();
            throw assertionError;
        }
        if (q0.a()) {
            z = this.x != l2.a ? i3 : i4;
            if (z == 0) {
            } else {
            }
            AssertionError assertionError3 = new AssertionError();
            throw assertionError3;
        }
        _state = this._state;
        if (q0.a()) {
            if (z4 ^= i3 == 0) {
            } else {
            }
            AssertionError assertionError2 = new AssertionError();
            throw assertionError2;
        }
        if (_state instanceof a0 && _state.d != null) {
            if (_state.d != null) {
                s();
                return i4;
            }
        }
        this._decision = i4;
        this._state = f.a;
        return i3;
    }

    @Override // kotlinx.coroutines.z0
    public boolean a() {
        return obj instanceof m2;
    }

    @Override // kotlinx.coroutines.z0
    public void b(Object object, Throwable throwable2) {
        Object obj2;
        Object obj;
        int i4;
        int i3;
        int i5;
        Throwable th;
        int i;
        int i2;
        AtomicReferenceFieldUpdater field;
        kotlinx.coroutines.a0 a0Var;
        boolean obj11;
        obj11 = this._state;
        while (!obj11 instanceof m2) {
            super(obj11, 0, 0, 0, throwable2, 14, 0);
            obj11 = this._state;
            obj2 = obj11;
        }
        obj11 = new IllegalStateException("Not completed".toString());
        throw obj11;
    }

    public final d<T> c() {
        return this.v;
    }

    @Override // kotlinx.coroutines.z0
    public Throwable d(Object object) {
        d dVar;
        boolean z;
        int obj3;
        obj3 = super.d(object);
        if (obj3 == null) {
            obj3 = 0;
        } else {
            dVar = c();
            if (q0.d()) {
                if (!dVar instanceof e) {
                } else {
                    obj3 = y.a(obj3, (e)dVar);
                }
            }
        }
        return obj3;
    }

    public <T> T e(Object object) {
        Object obj2;
        if (object instanceof a0) {
            obj2 = object.a;
        }
        return obj2;
    }

    public void g(l<? super Throwable, w> l) {
        boolean compareAndSet;
        Object obj;
        int i;
        kotlinx.coroutines.n nVar;
        Object obj2;
        int i5;
        int i3;
        int i2;
        int i4;
        int i6;
        Object _state;
        kotlinx.coroutines.a0 a0Var;
        final kotlinx.coroutines.n nVar3 = E(l);
        _state = this._state;
        while (_state instanceof f) {
            _state = this._state;
            i = 0;
            boolean z3 = _state instanceof b0;
            super(_state, nVar3, 0, 0, 0, 28, 0);
            Object obj3 = _state;
        }
    }

    @Override // kotlinx.coroutines.z0
    public e getCallerFrame() {
        d dVar;
        if (dVar instanceof e) {
        } else {
            dVar = 0;
        }
        return dVar;
    }

    @Override // kotlinx.coroutines.z0
    public g getContext() {
        return this.w;
    }

    @Override // kotlinx.coroutines.z0
    public java.lang.StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlinx.coroutines.z0
    public Object h(Throwable throwable) {
        final int i3 = 0;
        b0 b0Var = new b0(throwable, 0, 2, i3);
        return O(b0Var, i3, i3);
    }

    @Override // kotlinx.coroutines.z0
    public Object i() {
        return z();
    }

    public Object j(T t, Object object2, l<? super Throwable, w> l3) {
        return O(t, object2, l3);
    }

    public void k(kotlinx.coroutines.h0 h0, T t2) {
        int dVar;
        kotlinx.coroutines.h0 i;
        int obj7;
        if (dVar instanceof g) {
        } else {
            dVar = i;
        }
        if (dVar == 0) {
        } else {
            i = dVar.v;
        }
        obj7 = i == h0 ? 4 : this.c;
        q.L(this, t2, obj7, 0, 4, 0);
    }

    public void l(T t, l<? super Throwable, w> l2) {
        K(t, this.c, l2);
    }

    @Override // kotlinx.coroutines.z0
    public final void o(kotlinx.coroutines.n n, Throwable throwable2) {
        kotlinx.coroutines.CompletionHandlerException completionHandlerException;
        String str;
        Throwable obj3;
        Throwable obj4;
        try {
            n.a(throwable2);
            throwable2 = getContext();
            str = "Exception in invokeOnCancellation handler for ";
            str = n.o(str, this);
            completionHandlerException = new CompletionHandlerException(str, n);
            j0.a(throwable2, completionHandlerException);
        }
    }

    @Override // kotlinx.coroutines.z0
    public boolean p(Throwable throwable) {
        int _state;
        _state = this._state;
        while (!_state instanceof m2) {
            final boolean z2 = _state instanceof n;
            t tVar = new t(this, throwable, z2);
            _state = this._state;
        }
        return 0;
    }

    public final void q(l<? super Throwable, w> l, Throwable throwable2) {
        kotlinx.coroutines.CompletionHandlerException completionHandlerException;
        String str;
        Throwable obj3;
        Object obj4;
        try {
            l.invoke(throwable2);
            throwable2 = getContext();
            str = "Exception in resume onCancellation handler for ";
            str = n.o(str, this);
            completionHandlerException = new CompletionHandlerException(str, l);
            j0.a(throwable2, completionHandlerException);
        }
    }

    @Override // kotlinx.coroutines.z0
    public void resumeWith(Object object) {
        q.L(this, e0.c(object, this), this.c, 0, 4, 0);
    }

    @Override // kotlinx.coroutines.z0
    public final void s() {
        kotlinx.coroutines.e1 e1Var = this.x;
        if (e1Var == null) {
        }
        e1Var.dispose();
        this.x = l2.a;
    }

    @Override // kotlinx.coroutines.z0
    public boolean t() {
        return z ^= 1;
    }

    @Override // kotlinx.coroutines.z0
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(G());
        stringBuilder.append('(');
        stringBuilder.append(r0.c(this.v));
        stringBuilder.append("){");
        stringBuilder.append(A());
        stringBuilder.append("}@");
        stringBuilder.append(r0.b(this));
        return stringBuilder.toString();
    }

    @Override // kotlinx.coroutines.z0
    public Throwable w(kotlinx.coroutines.y1 y1) {
        return y1.n();
    }

    @Override // kotlinx.coroutines.z0
    public void x(Object object) {
        boolean z;
        z obj2;
        if (q0.a()) {
            obj2 = object == r.a ? 1 : 0;
            if (obj2 == null) {
            } else {
            }
            obj2 = new AssertionError();
            throw obj2;
        }
        v(this.c);
    }

    @Override // kotlinx.coroutines.z0
    public final Object y() {
        Throwable th;
        boolean z;
        Object exc;
        kotlinx.coroutines.y1.b bVar;
        boolean z2 = D();
        if (P() && this.x == null) {
            if (this.x == null) {
                C();
            }
            if (z2) {
                I();
            }
            return b.d();
        }
        if (z2) {
            I();
        }
        Object obj = z();
        if (obj instanceof b0) {
            if (!q0.d()) {
            } else {
                th = y.a(obj.a, this);
            }
            throw th;
        }
        z = getContext().get(y1.s);
        if (a1.b(this.c) && z != null && !(y1)z.a()) {
            z = getContext().get(y1.s);
            if ((y1)z != null) {
                if (!(y1)z.a()) {
                    exc = z.n();
                    b((b0)obj, exc);
                    if (!q0.d()) {
                    } else {
                        exc = y.a(exc, this);
                    }
                    throw exc;
                }
            }
        }
        return e(obj);
    }

    @Override // kotlinx.coroutines.z0
    public final Object z() {
        return this._state;
    }
}
