package kotlinx.coroutines.debug.internal;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0001\u0018\u00002\u00020\u0001B#\u0008\u0000\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u000e\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\u0013\u0010%\u001a\u0008\u0012\u0004\u0012\u00020\u00150\u0014H\u0000¢\u0006\u0002\u0008&J\u0008\u0010'\u001a\u00020\u000eH\u0016J)\u0010(\u001a\u00020)2\u0006\u0010 \u001a\u00020\u000e2\n\u0010*\u001a\u0006\u0012\u0002\u0008\u00030+2\u0006\u0010,\u001a\u00020-H\u0000¢\u0006\u0002\u0008.J%\u0010/\u001a\u00020)*\u0008\u0012\u0004\u0012\u00020\u0015002\u0008\u0010*\u001a\u0004\u0018\u00010\u000cH\u0082Pø\u0001\u0000¢\u0006\u0002\u00101R\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u000c\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\u0008\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u0017\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u00150\u00148F¢\u0006\u0006\u001a\u0004\u0008\u0016\u0010\u0017R(\u0010\u0019\u001a\u0004\u0018\u00010\u000c2\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u000c8@@@X\u0080\u000e¢\u0006\u000c\u001a\u0004\u0008\u001a\u0010\u001b\"\u0004\u0008\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\u00020\u000e8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008!\u0010\"R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u00062", d2 = {"Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", "", "context", "Lkotlin/coroutines/CoroutineContext;", "creationStackBottom", "Lkotlinx/coroutines/debug/internal/StackTraceFrame;", "sequenceNumber", "", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/debug/internal/StackTraceFrame;J)V", "_context", "Ljava/lang/ref/WeakReference;", "_lastObservedFrame", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "_state", "", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "getCreationStackBottom$kotlinx_coroutines_core", "()Lkotlinx/coroutines/debug/internal/StackTraceFrame;", "creationStackTrace", "", "Ljava/lang/StackTraceElement;", "getCreationStackTrace", "()Ljava/util/List;", "value", "lastObservedFrame", "getLastObservedFrame$kotlinx_coroutines_core", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "setLastObservedFrame$kotlinx_coroutines_core", "(Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)V", "lastObservedThread", "Ljava/lang/Thread;", "state", "getState$kotlinx_coroutines_core", "()Ljava/lang/String;", "unmatchedResume", "", "lastObservedStackTrace", "lastObservedStackTrace$kotlinx_coroutines_core", "toString", "updateState", "", "frame", "Lkotlin/coroutines/Continuation;", "shouldBeMatched", "", "updateState$kotlinx_coroutines_core", "yieldFrames", "Lkotlin/sequences/SequenceScope;", "(Lkotlin/sequences/SequenceScope;Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DebugCoroutineInfoImpl {

    private final WeakReference<CoroutineContext> _context;
    public volatile WeakReference<CoroutineStackFrame> _lastObservedFrame;
    public volatile String _state;
    private final kotlinx.coroutines.debug.internal.StackTraceFrame creationStackBottom;
    public volatile Thread lastObservedThread;
    public final long sequenceNumber;
    private int unmatchedResume;
    public DebugCoroutineInfoImpl(CoroutineContext context, kotlinx.coroutines.debug.internal.StackTraceFrame creationStackBottom, long sequenceNumber) {
        super();
        this.creationStackBottom = creationStackBottom;
        this.sequenceNumber = sequenceNumber;
        WeakReference weakReference = new WeakReference(context);
        this._context = weakReference;
        this._state = "CREATED";
    }

    public static final Object access$yieldFrames(kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl $this, SequenceScope $receiver, CoroutineStackFrame frame, Continuation $completion) {
        return $this.yieldFrames($receiver, frame, $completion);
    }

    private final List<java.lang.StackTraceElement> creationStackTrace() {
        kotlinx.coroutines.debug.internal.StackTraceFrame creationStackBottom = this.creationStackBottom;
        if (creationStackBottom == null) {
            return CollectionsKt.emptyList();
        }
        DebugCoroutineInfoImpl.creationStackTrace.1 anon = new DebugCoroutineInfoImpl.creationStackTrace.1(this, creationStackBottom, 0);
        return SequencesKt.toList(SequencesKt.sequence((Function2)anon));
    }

    private final Object yieldFrames(SequenceScope<? super java.lang.StackTraceElement> sequenceScope, CoroutineStackFrame coroutineStackFrame2, Continuation<? super Unit> continuation3) {
        boolean anon;
        int i2;
        int i;
        Object _this;
        Object l$0;
        int i3;
        int i4;
        int obj7;
        Object obj8;
        Object obj9;
        anon = continuation3;
        i = Integer.MIN_VALUE;
        if (continuation3 instanceof DebugCoroutineInfoImpl.yieldFrames.1 && label &= i != 0) {
            anon = continuation3;
            i = Integer.MIN_VALUE;
            if (label &= i != 0) {
                anon.label = obj9 -= i;
            } else {
                anon = new DebugCoroutineInfoImpl.yieldFrames.1(this, continuation3);
            }
        } else {
        }
        obj9 = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label2) {
            case 0:
                ResultKt.throwOnFailure(obj9);
                l$0 = debugCoroutineInfoImpl;
                _this = sequenceScope;
                break;
            case 1:
                obj7 = 0;
                obj8 = anon.L$2;
                _this = anon.L$1;
                l$0 = anon.L$0;
                ResultKt.throwOnFailure(obj9);
                obj7 = obj8.getCallerFrame();
                obj8 = obj7;
                return Unit.INSTANCE;
            default:
                obj7 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj7;
        }
        if (obj8 == null) {
            return Unit.INSTANCE;
        } else {
            obj7 = obj8.getStackTraceElement();
            if (obj7 != null) {
            } else {
            }
        }
    }

    public final CoroutineContext getContext() {
        return (CoroutineContext)this._context.get();
    }

    public final kotlinx.coroutines.debug.internal.StackTraceFrame getCreationStackBottom$kotlinx_coroutines_core() {
        return this.creationStackBottom;
    }

    public final List<java.lang.StackTraceElement> getCreationStackTrace() {
        return creationStackTrace();
    }

    public final CoroutineStackFrame getLastObservedFrame$kotlinx_coroutines_core() {
        Object obj;
        WeakReference _lastObservedFrame = this._lastObservedFrame;
        if (_lastObservedFrame != null) {
            obj = _lastObservedFrame.get();
        } else {
            obj = 0;
        }
        return obj;
    }

    public final String getState$kotlinx_coroutines_core() {
        return this._state;
    }

    public final List<java.lang.StackTraceElement> lastObservedStackTrace$kotlinx_coroutines_core() {
        CoroutineStackFrame frame;
        java.lang.StackTraceElement stackTraceElement;
        int i;
        if (getLastObservedFrame$kotlinx_coroutines_core() == null) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        while (frame != null) {
            stackTraceElement = frame.getStackTraceElement();
            if (stackTraceElement != null) {
            }
            frame = frame.getCallerFrame();
            i = 0;
            arrayList.add(stackTraceElement);
        }
        return (List)arrayList;
    }

    public final void setLastObservedFrame$kotlinx_coroutines_core(CoroutineStackFrame value) {
        Object obj;
        int i;
        WeakReference weakReference;
        if (value != null) {
            i = 0;
            weakReference = new WeakReference(value);
        } else {
            weakReference = 0;
        }
        this._lastObservedFrame = weakReference;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("DebugCoroutineInfo(state=").append(getState$kotlinx_coroutines_core()).append(",context=").append(getContext()).append(')').toString();
    }

    public final void updateState$kotlinx_coroutines_core(String state, Continuation<?> frame, boolean shouldBeMatched) {
        boolean equal;
        int unmatchedResume;
        boolean lastObservedFrame$kotlinx_coroutines_core;
        Object obj;
        Thread currentThread;
        synchronized (this) {
            try {
                if (Intrinsics.areEqual(state, "RUNNING")) {
                } else {
                }
                if (shouldBeMatched) {
                } else {
                }
                this.unmatchedResume = unmatchedResume2++;
                if (this.unmatchedResume > 0 && Intrinsics.areEqual(state, "SUSPENDED")) {
                }
                if (Intrinsics.areEqual(state, "SUSPENDED")) {
                }
                this.unmatchedResume = unmatchedResume3--;
                if (Intrinsics.areEqual(this._state, state) && Intrinsics.areEqual(state, "SUSPENDED") && getLastObservedFrame$kotlinx_coroutines_core() != null) {
                }
                if (Intrinsics.areEqual(state, "SUSPENDED")) {
                }
                if (getLastObservedFrame$kotlinx_coroutines_core() != null) {
                }
                this._state = state;
                if (frame instanceof CoroutineStackFrame) {
                } else {
                }
                obj = frame;
                obj = currentThread;
                setLastObservedFrame$kotlinx_coroutines_core(obj);
                if (Intrinsics.areEqual(state, "RUNNING")) {
                } else {
                }
                currentThread = Thread.currentThread();
                this.lastObservedThread = currentThread;
                throw state;
            }
        }
    }
}
