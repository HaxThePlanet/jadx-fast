package kotlinx.coroutines.debug.internal;

import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineId;
import kotlinx.coroutines.CoroutineName;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u000e\u0008\u0001\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0008¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008\t\u0010\nR\u0013\u0010\u000c\u001a\u0004\u0018\u00010\r¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\r¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u000fR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\r¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u000fR\u0013\u0010\u0019\u001a\u0004\u0018\u00010\r¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u000fR\u0011\u0010\u001b\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\r¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010\u000f¨\u0006 ", d2 = {"Lkotlinx/coroutines/debug/internal/DebuggerInfo;", "Ljava/io/Serializable;", "source", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", "context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;Lkotlin/coroutines/CoroutineContext;)V", "coroutineId", "", "getCoroutineId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "dispatcher", "", "getDispatcher", "()Ljava/lang/String;", "lastObservedStackTrace", "", "Ljava/lang/StackTraceElement;", "getLastObservedStackTrace", "()Ljava/util/List;", "lastObservedThreadName", "getLastObservedThreadName", "lastObservedThreadState", "getLastObservedThreadState", "name", "getName", "sequenceNumber", "getSequenceNumber", "()J", "state", "getState", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DebuggerInfo implements Serializable {

    private final Long coroutineId = null;
    private final String dispatcher = null;
    private final List<java.lang.StackTraceElement> lastObservedStackTrace;
    private final String lastObservedThreadName;
    private final String lastObservedThreadState = null;
    private final String name = null;
    private final long sequenceNumber;
    private final String state;
    public DebuggerInfo(kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl source, CoroutineContext context) {
        Object lastObservedThread;
        int name;
        super();
        kotlin.coroutines.CoroutineContext.Element context2 = context.get((CoroutineContext.Key)CoroutineId.Key);
        name = 0;
        if ((CoroutineId)context2 != null) {
            Long valueOf = Long.valueOf((CoroutineId)context2.getId());
        }
        int i = name;
        kotlin.coroutines.CoroutineContext.Element context3 = context.get((CoroutineContext.Key)ContinuationInterceptor.Key);
        if ((ContinuationInterceptor)context3 != null) {
            String string = (ContinuationInterceptor)context3.toString();
        }
        int i2 = name;
        kotlin.coroutines.CoroutineContext.Element context4 = context.get((CoroutineContext.Key)CoroutineName.Key);
        if ((CoroutineName)context4 != null) {
            String name2 = (CoroutineName)context4.getName();
        }
        int i3 = name;
        this.state = source.getState$kotlinx_coroutines_core();
        lastObservedThread = source.lastObservedThread;
        lastObservedThread = lastObservedThread.getState();
        if (lastObservedThread != null && lastObservedThread != null) {
            lastObservedThread = lastObservedThread.getState();
            if (lastObservedThread != null) {
                String string2 = lastObservedThread.toString();
            }
        }
        int i4 = name;
        Thread lastObservedThread2 = source.lastObservedThread;
        if (lastObservedThread2 != null) {
            name = lastObservedThread2.getName();
        }
        this.lastObservedThreadName = name;
        this.lastObservedStackTrace = source.lastObservedStackTrace$kotlinx_coroutines_core();
        this.sequenceNumber = source.sequenceNumber;
    }

    @Override // java.io.Serializable
    public final Long getCoroutineId() {
        return this.coroutineId;
    }

    @Override // java.io.Serializable
    public final String getDispatcher() {
        return this.dispatcher;
    }

    public final List<java.lang.StackTraceElement> getLastObservedStackTrace() {
        return this.lastObservedStackTrace;
    }

    @Override // java.io.Serializable
    public final String getLastObservedThreadName() {
        return this.lastObservedThreadName;
    }

    @Override // java.io.Serializable
    public final String getLastObservedThreadState() {
        return this.lastObservedThreadState;
    }

    @Override // java.io.Serializable
    public final String getName() {
        return this.name;
    }

    @Override // java.io.Serializable
    public final long getSequenceNumber() {
        return this.sequenceNumber;
    }

    @Override // java.io.Serializable
    public final String getState() {
        return this.state;
    }
}
