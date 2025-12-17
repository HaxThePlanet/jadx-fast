package kotlinx.coroutines.debug.internal;

import _COROUTINE.ArtificialStackFrames;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.concurrent.ThreadsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineId;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.JobSupport;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0017\n\u0002\u0010\u0003\n\u0002\u0008\n\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0008Á\u0002\u0018\u00002\u00020\u0001:\u0001}B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J,\u00101\u001a\u0008\u0012\u0004\u0012\u0002H302\"\u0004\u0008\u0000\u001032\u000c\u00104\u001a\u0008\u0012\u0004\u0012\u0002H3022\u0008\u00105\u001a\u0004\u0018\u000106H\u0002J\u0010\u00107\u001a\u00020\u00142\u0006\u00108\u001a\u000209H\u0001J\u000c\u0010:\u001a\u0008\u0012\u0004\u0012\u00020<0;J\u0011\u0010=\u001a\u0008\u0012\u0004\u0012\u00020\u00010>¢\u0006\u0002\u0010?J9\u0010@\u001a\u0008\u0012\u0004\u0012\u0002HA0;\"\u0008\u0008\u0000\u0010A*\u00020\u00012\u001e\u0008\u0004\u0010B\u001a\u0018\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u000b\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u0002HA0CH\u0082\u0008J\u0010\u0010E\u001a\u00020\u00142\u0006\u00108\u001a\u000209H\u0002J\u000c\u0010F\u001a\u0008\u0012\u0004\u0012\u00020G0;J\"\u0010H\u001a\u0008\u0012\u0004\u0012\u00020\u00040;2\u0006\u0010I\u001a\u00020<2\u000c\u0010J\u001a\u0008\u0012\u0004\u0012\u00020\u00040;J\u000e\u0010K\u001a\u00020)2\u0006\u0010I\u001a\u00020<J.\u0010L\u001a\u0008\u0012\u0004\u0012\u00020\u00040;2\u0006\u0010M\u001a\u00020)2\u0008\u0010N\u001a\u0004\u0018\u00010'2\u000c\u0010J\u001a\u0008\u0012\u0004\u0012\u00020\u00040;H\u0002J=\u0010O\u001a\u000e\u0012\u0004\u0012\u00020Q\u0012\u0004\u0012\u00020Q0P2\u0006\u0010R\u001a\u00020Q2\u000c\u0010S\u001a\u0008\u0012\u0004\u0012\u00020\u00040>2\u000c\u0010J\u001a\u0008\u0012\u0004\u0012\u00020\u00040;H\u0002¢\u0006\u0002\u0010TJ1\u0010U\u001a\u00020Q2\u0006\u0010V\u001a\u00020Q2\u000c\u0010S\u001a\u0008\u0012\u0004\u0012\u00020\u00040>2\u000c\u0010J\u001a\u0008\u0012\u0004\u0012\u00020\u00040;H\u0002¢\u0006\u0002\u0010WJ\u0016\u0010X\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013H\u0002J\u0015\u0010Y\u001a\u00020)2\u0006\u0010Z\u001a\u00020*H\u0000¢\u0006\u0002\u0008[J\r\u0010\\\u001a\u00020\u0014H\u0000¢\u0006\u0002\u0008]J\u001e\u0010^\u001a\u00020\u00142\u0006\u00108\u001a\u0002092\u000c\u0010_\u001a\u0008\u0012\u0004\u0012\u00020\u00040;H\u0002J\u0014\u0010`\u001a\u00020\u00142\n\u0010a\u001a\u0006\u0012\u0002\u0008\u00030\u000bH\u0002J'\u0010b\u001a\u0008\u0012\u0004\u0012\u0002H302\"\u0004\u0008\u0000\u001032\u000c\u00104\u001a\u0008\u0012\u0004\u0012\u0002H302H\u0000¢\u0006\u0002\u0008cJ\u0019\u0010d\u001a\u00020\u00142\n\u00105\u001a\u0006\u0012\u0002\u0008\u000302H\u0000¢\u0006\u0002\u0008eJ\u0019\u0010f\u001a\u00020\u00142\n\u00105\u001a\u0006\u0012\u0002\u0008\u000302H\u0000¢\u0006\u0002\u0008gJ%\u0010h\u001a\u0008\u0012\u0004\u0012\u00020\u00040;\"\u0008\u0008\u0000\u00103*\u00020i2\u0006\u0010j\u001a\u0002H3H\u0002¢\u0006\u0002\u0010kJ\u0008\u0010l\u001a\u00020\u0014H\u0002J\u0008\u0010m\u001a\u00020\u0014H\u0002J\r\u0010n\u001a\u00020\u0014H\u0000¢\u0006\u0002\u0008oJ\u0018\u0010p\u001a\u00020\u00142\u0006\u00105\u001a\u00020\u00072\u0006\u0010M\u001a\u00020)H\u0002J\u001c\u0010q\u001a\u00020\u00142\n\u00105\u001a\u0006\u0012\u0002\u0008\u0003022\u0006\u0010M\u001a\u00020)H\u0002J(\u0010q\u001a\u00020\u00142\n\u0010a\u001a\u0006\u0012\u0002\u0008\u00030\u000b2\n\u00105\u001a\u0006\u0012\u0002\u0008\u0003022\u0006\u0010M\u001a\u00020)H\u0002J4\u0010r\u001a\u00020\u0014*\u00020*2\u0012\u0010s\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u00080t2\n\u0010u\u001a\u00060vj\u0002`w2\u0006\u0010x\u001a\u00020)H\u0002J\u0010\u0010y\u001a\u00020\u000f*\u0006\u0012\u0002\u0008\u00030\u000bH\u0002J\u0016\u0010a\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u000b*\u0006\u0012\u0002\u0008\u000302H\u0002J\u0013\u0010a\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u000b*\u00020\u0007H\u0082\u0010J\u000f\u0010z\u001a\u0004\u0018\u00010\u0007*\u00020\u0007H\u0082\u0010J\u0012\u0010{\u001a\u000206*\u0008\u0012\u0004\u0012\u00020\u00040;H\u0002J\u000c\u0010|\u001a\u00020)*\u00020\u0001H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00080\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u000b0\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\rR\u001e\u0010\u000e\u001a\u0012\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u000b\u0012\u0004\u0012\u00020\u000f0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u000fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0016\u0010\u0017\"\u0004\u0008\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001b\u0010\u0017\"\u0004\u0008\u001c\u0010\u0019R\t\u0010\u001d\u001a\u00020\u001eX\u0082\u0004R\u0011\u0010\u001f\u001a\u00020\u000f8G¢\u0006\u0006\u001a\u0004\u0008 \u0010\u0017R\u001a\u0010!\u001a\u00020\u000fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\"\u0010\u0017\"\u0004\u0008#\u0010\u0019R\t\u0010$\u001a\u00020%X\u0082\u0004R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010(\u001a\u00020)*\u00020*8BX\u0082\u0004¢\u0006\u000c\u0012\u0004\u0008+\u0010,\u001a\u0004\u0008-\u0010.R\u0018\u0010/\u001a\u00020\u000f*\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008/\u00100¨\u0006~", d2 = {"Lkotlinx/coroutines/debug/internal/DebugProbesImpl;", "", "()V", "ARTIFICIAL_FRAME", "Ljava/lang/StackTraceElement;", "callerInfoCache", "Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", "capturedCoroutines", "", "Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;", "getCapturedCoroutines", "()Ljava/util/Set;", "capturedCoroutinesMap", "", "dateFormat", "Ljava/text/SimpleDateFormat;", "dynamicAttach", "Lkotlin/Function1;", "", "enableCreationStackTraces", "getEnableCreationStackTraces$kotlinx_coroutines_core", "()Z", "setEnableCreationStackTraces$kotlinx_coroutines_core", "(Z)V", "ignoreCoroutinesWithEmptyContext", "getIgnoreCoroutinesWithEmptyContext", "setIgnoreCoroutinesWithEmptyContext", "installations", "Lkotlinx/atomicfu/AtomicInt;", "isInstalled", "isInstalled$kotlinx_coroutines_debug", "sanitizeStackTraces", "getSanitizeStackTraces$kotlinx_coroutines_core", "setSanitizeStackTraces$kotlinx_coroutines_core", "sequenceNumber", "Lkotlinx/atomicfu/AtomicLong;", "weakRefCleanerThread", "Ljava/lang/Thread;", "debugString", "", "Lkotlinx/coroutines/Job;", "getDebugString$annotations", "(Lkotlinx/coroutines/Job;)V", "getDebugString", "(Lkotlinx/coroutines/Job;)Ljava/lang/String;", "isInternalMethod", "(Ljava/lang/StackTraceElement;)Z", "createOwner", "Lkotlin/coroutines/Continuation;", "T", "completion", "frame", "Lkotlinx/coroutines/debug/internal/StackTraceFrame;", "dumpCoroutines", "out", "Ljava/io/PrintStream;", "dumpCoroutinesInfo", "", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfo;", "dumpCoroutinesInfoAsJsonAndReferences", "", "()[Ljava/lang/Object;", "dumpCoroutinesInfoImpl", "R", "create", "Lkotlin/Function2;", "Lkotlin/coroutines/CoroutineContext;", "dumpCoroutinesSynchronized", "dumpDebuggerInfo", "Lkotlinx/coroutines/debug/internal/DebuggerInfo;", "enhanceStackTraceWithThreadDump", "info", "coroutineTrace", "enhanceStackTraceWithThreadDumpAsJson", "enhanceStackTraceWithThreadDumpImpl", "state", "thread", "findContinuationStartIndex", "Lkotlin/Pair;", "", "indexOfResumeWith", "actualTrace", "(I[Ljava/lang/StackTraceElement;Ljava/util/List;)Lkotlin/Pair;", "findIndexOfFrame", "frameIndex", "(I[Ljava/lang/StackTraceElement;Ljava/util/List;)I", "getDynamicAttach", "hierarchyToString", "job", "hierarchyToString$kotlinx_coroutines_core", "install", "install$kotlinx_coroutines_core", "printStackTrace", "frames", "probeCoroutineCompleted", "owner", "probeCoroutineCreated", "probeCoroutineCreated$kotlinx_coroutines_core", "probeCoroutineResumed", "probeCoroutineResumed$kotlinx_coroutines_core", "probeCoroutineSuspended", "probeCoroutineSuspended$kotlinx_coroutines_core", "sanitizeStackTrace", "", "throwable", "(Ljava/lang/Throwable;)Ljava/util/List;", "startWeakRefCleanerThread", "stopWeakRefCleanerThread", "uninstall", "uninstall$kotlinx_coroutines_core", "updateRunningState", "updateState", "build", "map", "", "builder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "indent", "isFinished", "realCaller", "toStackTraceFrame", "toStringRepr", "CoroutineOwner", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DebugProbesImpl {

    private static final java.lang.StackTraceElement ARTIFICIAL_FRAME;
    public static final kotlinx.coroutines.debug.internal.DebugProbesImpl INSTANCE;
    private static final kotlinx.coroutines.debug.internal.ConcurrentWeakMap<CoroutineStackFrame, kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl> callerInfoCache;
    private static final kotlinx.coroutines.debug.internal.ConcurrentWeakMap<kotlinx.coroutines.debug.internal.DebugProbesImpl.CoroutineOwner<?>, Boolean> capturedCoroutinesMap;
    private static final SimpleDateFormat dateFormat;
    private static final Function1<Boolean, Unit> dynamicAttach;
    private static boolean enableCreationStackTraces;
    private static boolean ignoreCoroutinesWithEmptyContext;
    private static final kotlinx.coroutines.debug.internal.DebugProbesImpl.Installations.kotlinx.VolatileWrapper installations$kotlinx$VolatileWrapper;
    private static boolean sanitizeStackTraces;
    private static final kotlinx.coroutines.debug.internal.DebugProbesImpl.SequenceNumber.kotlinx.VolatileWrapper sequenceNumber$kotlinx$VolatileWrapper;
    private static Thread weakRefCleanerThread;

    @Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003B\u001d\u0008\u0000\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u001e\u0010\u0015\u001a\u00020\u00162\u000c\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0018H\u0016ø\u0001\u0000¢\u0006\u0002\u0010\u0019J\u0008\u0010\u001a\u001a\u00020\u001bH\u0016R\u0016\u0010\u0008\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\u000cX\u0096\u0005¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000eR\u0016\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00028\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u0012R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u001c", d2 = {"Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;", "T", "Lkotlin/coroutines/Continuation;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "delegate", "info", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", "(Lkotlin/coroutines/Continuation;Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;)V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "frame", "Lkotlinx/coroutines/debug/internal/StackTraceFrame;", "getFrame", "()Lkotlinx/coroutines/debug/internal/StackTraceFrame;", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "resumeWith", "", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class CoroutineOwner implements Continuation<T>, CoroutineStackFrame {

        public final Continuation<T> delegate;
        public final kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl info;
        public CoroutineOwner(Continuation<? super T> delegate, kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl info) {
            super();
            this.delegate = delegate;
            this.info = info;
        }

        private final kotlinx.coroutines.debug.internal.StackTraceFrame getFrame() {
            return this.info.getCreationStackBottom$kotlinx_coroutines_core();
        }

        @Override // kotlin.coroutines.Continuation
        public CoroutineStackFrame getCallerFrame() {
            CoroutineStackFrame callerFrame;
            kotlinx.coroutines.debug.internal.StackTraceFrame frame = getFrame();
            if (frame != null) {
                callerFrame = frame.getCallerFrame();
            } else {
                callerFrame = 0;
            }
            return callerFrame;
        }

        @Override // kotlin.coroutines.Continuation
        public CoroutineContext getContext() {
            return this.delegate.getContext();
        }

        @Override // kotlin.coroutines.Continuation
        public java.lang.StackTraceElement getStackTraceElement() {
            java.lang.StackTraceElement stackTraceElement;
            kotlinx.coroutines.debug.internal.StackTraceFrame frame = getFrame();
            if (frame != null) {
                stackTraceElement = frame.getStackTraceElement();
            } else {
                stackTraceElement = 0;
            }
            return stackTraceElement;
        }

        @Override // kotlin.coroutines.Continuation
        public void resumeWith(Object result) {
            DebugProbesImpl.access$probeCoroutineCompleted(DebugProbesImpl.INSTANCE, this);
            this.delegate.resumeWith(result);
        }

        @Override // kotlin.coroutines.Continuation
        public String toString() {
            return this.delegate.toString();
        }
    }
    static {
        DebugProbesImpl debugProbesImpl = new DebugProbesImpl();
        DebugProbesImpl.INSTANCE = debugProbesImpl;
        ArtificialStackFrames artificialStackFrames = new ArtificialStackFrames();
        DebugProbesImpl.ARTIFICIAL_FRAME = artificialStackFrames.coroutineCreation();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        DebugProbesImpl.dateFormat = simpleDateFormat;
        final int i2 = 1;
        final int i3 = 0;
        ConcurrentWeakMap concurrentWeakMap = new ConcurrentWeakMap(0, i2, i3);
        DebugProbesImpl.capturedCoroutinesMap = concurrentWeakMap;
        DebugProbesImpl.sanitizeStackTraces = i2;
        DebugProbesImpl.enableCreationStackTraces = i2;
        DebugProbesImpl.ignoreCoroutinesWithEmptyContext = i2;
        DebugProbesImpl.dynamicAttach = DebugProbesImpl.INSTANCE.getDynamicAttach();
        ConcurrentWeakMap concurrentWeakMap2 = new ConcurrentWeakMap(i2);
        DebugProbesImpl.callerInfoCache = concurrentWeakMap2;
        DebugProbesImpl.Installations.kotlinx.VolatileWrapper volatileWrapper = new DebugProbesImpl.Installations.kotlinx.VolatileWrapper(i3);
        DebugProbesImpl.installations$kotlinx$VolatileWrapper = volatileWrapper;
        DebugProbesImpl.SequenceNumber.kotlinx.VolatileWrapper volatileWrapper2 = new DebugProbesImpl.SequenceNumber.kotlinx.VolatileWrapper(i3);
        DebugProbesImpl.sequenceNumber$kotlinx$VolatileWrapper = volatileWrapper2;
    }

    public static final kotlinx.coroutines.debug.internal.ConcurrentWeakMap access$getCallerInfoCache$p() {
        return DebugProbesImpl.callerInfoCache;
    }

    public static final boolean access$isFinished(kotlinx.coroutines.debug.internal.DebugProbesImpl $this, kotlinx.coroutines.debug.internal.DebugProbesImpl.CoroutineOwner $receiver) {
        return $this.isFinished($receiver);
    }

    public static final void access$probeCoroutineCompleted(kotlinx.coroutines.debug.internal.DebugProbesImpl $this, kotlinx.coroutines.debug.internal.DebugProbesImpl.CoroutineOwner owner) {
        $this.probeCoroutineCompleted(owner);
    }

    private final void build(Job $this$build, Map<Job, kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl> map, StringBuilder builder, String indent) {
        String newIndent;
        int append2;
        int append;
        boolean firstOrNull;
        String state$kotlinx_coroutines_core;
        StringBuilder append3;
        String str;
        final Object obj = map.get($this$build);
        int i = 0;
        append2 = 9;
        append = 10;
        if ((DebugCoroutineInfoImpl)obj == null) {
            if (!$this$build instanceof ScopeCoroutine) {
                StringBuilder stringBuilder3 = new StringBuilder();
                builder.append(stringBuilder3.append(indent).append(getDebugString($this$build)).append(append).toString());
                StringBuilder stringBuilder = new StringBuilder();
                newIndent = stringBuilder.append(indent).append(append2).toString();
            } else {
                newIndent = indent;
            }
        } else {
            StringBuilder stringBuilder4 = new StringBuilder();
            builder.append(stringBuilder4.append(indent).append(getDebugString($this$build)).append(", continuation is ").append(obj.getState$kotlinx_coroutines_core()).append(" at line ").append((StackTraceElement)CollectionsKt.firstOrNull((DebugCoroutineInfoImpl)obj.lastObservedStackTrace$kotlinx_coroutines_core())).append(append).toString());
            StringBuilder stringBuilder2 = new StringBuilder();
            newIndent = stringBuilder2.append(indent).append(append2).toString();
        }
        Iterator iterator = $this$build.getChildren().iterator();
        for (Job append : iterator) {
            build(append, map, builder, newIndent);
        }
    }

    private final <T> Continuation<T> createOwner(Continuation<? super T> completion, kotlinx.coroutines.debug.internal.StackTraceFrame frame) {
        boolean capturedCoroutinesMap;
        if (!isInstalled$kotlinx_coroutines_debug()) {
            return completion;
        }
        kotlinx.coroutines.debug.internal.DebugProbesImpl.SequenceNumber.kotlinx.VolatileWrapper sequenceNumber$kotlinx$VolatileWrapper = DebugProbesImpl.sequenceNumber$kotlinx$VolatileWrapper;
        DebugCoroutineInfoImpl debugCoroutineInfoImpl = new DebugCoroutineInfoImpl(completion.getContext(), frame, DebugProbesImpl.SequenceNumber.kotlinx.VolatileWrapper.access$getSequenceNumber$FU$p().incrementAndGet(sequenceNumber$kotlinx$VolatileWrapper), sequenceNumber$kotlinx$VolatileWrapper);
        DebugProbesImpl.CoroutineOwner coroutineOwner = new DebugProbesImpl.CoroutineOwner(completion, debugCoroutineInfoImpl);
        (Map)DebugProbesImpl.capturedCoroutinesMap.put(coroutineOwner, true);
        if (!isInstalled$kotlinx_coroutines_debug()) {
            DebugProbesImpl.capturedCoroutinesMap.clear();
        }
        return (Continuation)coroutineOwner;
    }

    private final <R> List<R> dumpCoroutinesInfoImpl(Function2<? super kotlinx.coroutines.debug.internal.DebugProbesImpl.CoroutineOwner<?>, ? super CoroutineContext, ? extends R> create) {
        final int i = 0;
        if (!isInstalled$kotlinx_coroutines_debug()) {
        } else {
            int i3 = 0;
            DebugProbesImpl.dumpCoroutinesInfoImpl$$inlined.sortedBy.1 anon = new DebugProbesImpl.dumpCoroutinesInfoImpl$$inlined.sortedBy.1();
            DebugProbesImpl.dumpCoroutinesInfoImpl.3 $i$f$sortedBy = new DebugProbesImpl.dumpCoroutinesInfoImpl.3(create);
            return SequencesKt.toList(SequencesKt.mapNotNull(SequencesKt.sortedWith(CollectionsKt.asSequence((Iterable)getCapturedCoroutines()), (Comparator)anon), (Function1)$i$f$sortedBy));
        }
        int i2 = 0;
        IllegalStateException $i$a$CheckDebugProbesImpl$dumpCoroutinesInfoImpl$1 = new IllegalStateException("Debug probes are not installed".toString());
        throw $i$a$CheckDebugProbesImpl$dumpCoroutinesInfoImpl$1;
    }

    private final void dumpCoroutinesSynchronized(PrintStream out) {
        long next;
        long l;
        int i;
        kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl info;
        List lastObservedStackTrace$kotlinx_coroutines_core;
        List enhanceStackTraceWithThreadDumpImpl;
        String state$kotlinx_coroutines_core;
        kotlinx.coroutines.debug.internal.DebugProbesImpl iNSTANCE;
        String str;
        String creationStackTrace;
        if (!isInstalled$kotlinx_coroutines_debug()) {
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            out.print(stringBuilder.append("Coroutines dump ").append(DebugProbesImpl.dateFormat.format(Long.valueOf(System.currentTimeMillis()))).toString());
            int i3 = 0;
            DebugProbesImpl.dumpCoroutinesSynchronized$$inlined.sortedBy.1 anon = new DebugProbesImpl.dumpCoroutinesSynchronized$$inlined.sortedBy.1();
            int i4 = 0;
            Iterator iterator = SequencesKt.sortedWith(SequencesKt.filter(CollectionsKt.asSequence((Iterable)getCapturedCoroutines()), (Function1)DebugProbesImpl.dumpCoroutinesSynchronized.2.INSTANCE), (Comparator)anon).iterator();
            while (iterator.hasNext()) {
                l = next;
                i = 0;
                info = l.info;
                lastObservedStackTrace$kotlinx_coroutines_core = info.lastObservedStackTrace$kotlinx_coroutines_core();
                enhanceStackTraceWithThreadDumpImpl = DebugProbesImpl.INSTANCE.enhanceStackTraceWithThreadDumpImpl(info.getState$kotlinx_coroutines_core(), info.lastObservedThread, lastObservedStackTrace$kotlinx_coroutines_core);
                if (Intrinsics.areEqual(info.getState$kotlinx_coroutines_core(), "RUNNING") && enhanceStackTraceWithThreadDumpImpl == lastObservedStackTrace$kotlinx_coroutines_core) {
                } else {
                }
                state$kotlinx_coroutines_core = info.getState$kotlinx_coroutines_core();
                StringBuilder stringBuilder3 = new StringBuilder();
                out.print(stringBuilder3.append("\n\nCoroutine ").append(l.delegate).append(", state: ").append(state$kotlinx_coroutines_core).toString());
                if (lastObservedStackTrace$kotlinx_coroutines_core.isEmpty()) {
                } else {
                }
                DebugProbesImpl.INSTANCE.printStackTrace(out, enhanceStackTraceWithThreadDumpImpl);
                StringBuilder stringBuilder4 = new StringBuilder();
                out.print(stringBuilder4.append("\n\tat ").append(DebugProbesImpl.ARTIFICIAL_FRAME).toString());
                DebugProbesImpl.INSTANCE.printStackTrace(out, info.getCreationStackTrace());
                if (enhanceStackTraceWithThreadDumpImpl == lastObservedStackTrace$kotlinx_coroutines_core) {
                } else {
                }
                StringBuilder stringBuilder2 = new StringBuilder();
                state$kotlinx_coroutines_core = stringBuilder2.append(info.getState$kotlinx_coroutines_core()).append(" (Last suspension stacktrace, not an actual stacktrace)").toString();
            }
        }
        int i2 = 0;
        IllegalStateException $i$a$CheckDebugProbesImpl$dumpCoroutinesSynchronized$1 = new IllegalStateException("Debug probes are not installed".toString());
        throw $i$a$CheckDebugProbesImpl$dumpCoroutinesSynchronized$1;
    }

    private final List<java.lang.StackTraceElement> enhanceStackTraceWithThreadDumpImpl(String state, Thread thread, List<java.lang.StackTraceElement> coroutineTrace) {
        Object constructor-impl;
        int i3;
        int index$iv;
        int i2;
        int i5;
        int index;
        int index2;
        Object obj;
        int i;
        int i4;
        boolean equal;
        String str;
        if (Intrinsics.areEqual(state, "RUNNING")) {
            if (thread == null) {
            } else {
                kotlin.Result.Companion companion = Result.Companion;
                kotlinx.coroutines.debug.internal.DebugProbesImpl debugProbesImpl = this;
                i3 = 0;
                constructor-impl = Result.constructor-impl(thread.getStackTrace());
                if (Result.isFailure-impl(constructor-impl)) {
                    constructor-impl = 0;
                }
                if ((StackTraceElement[])constructor-impl == null) {
                    return coroutineTrace;
                }
                Object obj2 = constructor-impl;
                int i6 = 0;
                index$iv = 0;
                i2 = -1;
                i5 = 1;
                while (index$iv < obj2.length) {
                    obj = obj2[index$iv];
                    i = 0;
                    if (Intrinsics.areEqual(obj.getClassName(), "kotlin.coroutines.jvm.internal.BaseContinuationImpl") && Intrinsics.areEqual(obj.getMethodName(), "resumeWith") && Intrinsics.areEqual(obj.getFileName(), "ContinuationImpl.kt") != null) {
                    } else {
                    }
                    i4 = 0;
                    index$iv++;
                    i2 = -1;
                    i5 = 1;
                    if (Intrinsics.areEqual(obj.getMethodName(), "resumeWith")) {
                    } else {
                    }
                    if (Intrinsics.areEqual(obj.getFileName(), "ContinuationImpl.kt") != null) {
                    } else {
                    }
                    i4 = i5;
                }
                index$iv = i2;
                Pair continuationStartIndex = findContinuationStartIndex(index$iv, (StackTraceElement[])constructor-impl, coroutineTrace);
                int intValue2 = (Number)continuationStartIndex.component1().intValue();
                int intValue = (Number)continuationStartIndex.component2().intValue();
                if (intValue2 == i2) {
                    return coroutineTrace;
                }
                ArrayList arrayList = new ArrayList(i9 -= intValue);
                index = 0;
                while (index < index$iv - intValue) {
                    (Collection)arrayList.add(constructor-impl[index]);
                    index++;
                }
                index2 = intValue2 + 1;
                while (index2 < coroutineTrace.size()) {
                    (Collection)arrayList.add(coroutineTrace.get(index2));
                    index2++;
                }
            }
            return (List)arrayList;
        }
        return coroutineTrace;
    }

    private final Pair<Integer, Integer> findContinuationStartIndex(int indexOfResumeWith, java.lang.StackTraceElement[] actualTrace, List<java.lang.StackTraceElement> coroutineTrace) {
        int i;
        int i3;
        int i2;
        int i4;
        int indexOfFrame;
        int i5;
        int i6 = 0;
        i = i6;
        i3 = -1;
        while (i < 3) {
            i2 = i;
            i4 = 0;
            indexOfFrame = DebugProbesImpl.INSTANCE.findIndexOfFrame(i8 -= i2, actualTrace, coroutineTrace);
            i++;
            i3 = -1;
        }
        return TuplesKt.to(Integer.valueOf(i3), Integer.valueOf(i6));
    }

    private final int findIndexOfFrame(int frameIndex, java.lang.StackTraceElement[] actualTrace, List<java.lang.StackTraceElement> coroutineTrace) {
        int i3;
        int index$iv;
        Object next;
        Object obj;
        int i;
        int i2;
        boolean equal;
        String methodName;
        final Object orNull = ArraysKt.getOrNull(actualTrace, frameIndex);
        if ((StackTraceElement)orNull == null) {
            return -1;
        }
        final int i4 = 0;
        index$iv = 0;
        final Iterator iterator = coroutineTrace.iterator();
        while (iterator.hasNext()) {
            obj = next;
            i = 0;
            if (Intrinsics.areEqual((StackTraceElement)obj.getFileName(), (StackTraceElement)orNull.getFileName()) != null && Intrinsics.areEqual(obj.getClassName(), orNull.getClassName()) && Intrinsics.areEqual(obj.getMethodName(), orNull.getMethodName())) {
            } else {
            }
            i2 = 0;
            index$iv++;
            if (Intrinsics.areEqual(obj.getClassName(), orNull.getClassName())) {
            } else {
            }
            if (Intrinsics.areEqual(obj.getMethodName(), orNull.getMethodName())) {
            } else {
            }
            i2 = 1;
        }
        return i3;
    }

    private final Set<kotlinx.coroutines.debug.internal.DebugProbesImpl.CoroutineOwner<?>> getCapturedCoroutines() {
        return DebugProbesImpl.capturedCoroutinesMap.keySet();
    }

    private final String getDebugString(Job $this$debugString) {
        String debugString;
        if ($this$debugString instanceof JobSupport) {
            debugString = (JobSupport)$this$debugString.toDebugString();
        } else {
            debugString = $this$debugString.toString();
        }
        return debugString;
    }

    private static void getDebugString$annotations(Job job) {
    }

    private final Function1<Boolean, Unit> getDynamicAttach() {
        Object constructor-impl;
        int i;
        try {
            kotlin.Result.Companion companion = Result.Companion;
            kotlinx.coroutines.debug.internal.DebugProbesImpl debugProbesImpl = this;
            i = 0;
            int i2 = 0;
            Object instance = Class.forName("kotlinx.coroutines.debug.internal.ByteBuddyDynamicAttach").getConstructors()[i2].newInstance(new Object[i2]);
            Intrinsics.checkNotNull(instance, "null cannot be cast to non-null type kotlin.Function1<kotlin.Boolean, kotlin.Unit>");
            constructor-impl = Result.constructor-impl((Function1)TypeIntrinsics.beforeCheckcastToFunctionOfArity(instance, 1));
            kotlin.Result.Companion companion2 = Result.Companion;
            Throwable constructor-impl2 = ResultKt.createFailure(constructor-impl2);
            constructor-impl2 = Result.constructor-impl(constructor-impl2);
            if (Result.isFailure-impl(constructor-impl)) {
            }
            constructor-impl = 0;
            return (Function1)constructor-impl;
        }
    }

    private final boolean isFinished(kotlinx.coroutines.debug.internal.DebugProbesImpl.CoroutineOwner<?> $this$isFinished) {
        CoroutineContext context;
        kotlinx.coroutines.Job.Key key;
        context = $this$isFinished.info.getContext();
        int i = 0;
        if (context != null) {
            context = context.get((CoroutineContext.Key)Job.Key);
            if ((Job)context == null) {
            } else {
                if (!(Job)context.isCompleted()) {
                    return i;
                }
            }
            DebugProbesImpl.capturedCoroutinesMap.remove($this$isFinished);
            return 1;
        }
        return i;
    }

    private final boolean isInternalMethod(java.lang.StackTraceElement $this$isInternalMethod) {
        return StringsKt.startsWith$default($this$isInternalMethod.getClassName(), "kotlinx.coroutines", false, 2, 0);
    }

    private final kotlinx.coroutines.debug.internal.DebugProbesImpl.CoroutineOwner<?> owner(Continuation<?> $this$owner) {
        Object obj;
        int owner;
        if ($this$owner instanceof CoroutineStackFrame) {
            obj = $this$owner;
        } else {
            obj = owner;
        }
        if (obj != null) {
            owner = owner(obj);
        }
        return owner;
    }

    private final kotlinx.coroutines.debug.internal.DebugProbesImpl.CoroutineOwner<?> owner(CoroutineStackFrame $this$owner) {
        CoroutineStackFrame callerFrame;
        int i;
        Object obj2;
        while (obj2 instanceof DebugProbesImpl.CoroutineOwner) {
            callerFrame = obj2.getCallerFrame();
            obj2 = callerFrame;
        }
        i = obj2;
        return i;
    }

    private final void printStackTrace(PrintStream out, List<java.lang.StackTraceElement> frames) {
        Object next;
        Object obj;
        int i;
        String string;
        String str;
        final int i2 = 0;
        final Iterator iterator = (Iterable)frames.iterator();
        for (Object next : iterator) {
            i = 0;
            StringBuilder stringBuilder = new StringBuilder();
            out.print(stringBuilder.append("\n\tat ").append((StackTraceElement)next).toString());
        }
    }

    private final void probeCoroutineCompleted(kotlinx.coroutines.debug.internal.DebugProbesImpl.CoroutineOwner<?> owner) {
        CoroutineStackFrame lastObservedFrame$kotlinx_coroutines_core;
        DebugProbesImpl.capturedCoroutinesMap.remove(owner);
        lastObservedFrame$kotlinx_coroutines_core = owner.info.getLastObservedFrame$kotlinx_coroutines_core();
        lastObservedFrame$kotlinx_coroutines_core = realCaller(lastObservedFrame$kotlinx_coroutines_core);
        if (lastObservedFrame$kotlinx_coroutines_core != null && lastObservedFrame$kotlinx_coroutines_core == null) {
            lastObservedFrame$kotlinx_coroutines_core = realCaller(lastObservedFrame$kotlinx_coroutines_core);
            if (lastObservedFrame$kotlinx_coroutines_core == null) {
            }
            DebugProbesImpl.callerInfoCache.remove(lastObservedFrame$kotlinx_coroutines_core);
        }
    }

    private final CoroutineStackFrame realCaller(CoroutineStackFrame $this$realCaller) {
        CoroutineStackFrame callerFrame;
        java.lang.StackTraceElement stackTraceElement;
        CoroutineStackFrame obj3;
        callerFrame = obj3.getCallerFrame();
        while (callerFrame == null) {
            obj3 = callerFrame;
            callerFrame = obj3.getCallerFrame();
        }
        return null;
    }

    private final <T extends Throwable> List<java.lang.StackTraceElement> sanitizeStackTrace(T throwable) {
        int i4;
        int i;
        int i5;
        int j;
        int i2;
        int it2;
        java.lang.StackTraceElement internalMethod;
        boolean it;
        int i3;
        String className;
        String str;
        final java.lang.StackTraceElement[] stackTrace = throwable.getStackTrace();
        final int length = stackTrace.length;
        java.lang.StackTraceElement[] objArr = stackTrace;
        int i7 = 0;
        i2 = -1;
        if (length2 += i2 >= 0) {
        } else {
        }
        int $this$indexOfLast$iv = 1;
        i2 += $this$indexOfLast$iv;
        if (!DebugProbesImpl.sanitizeStackTraces) {
            int i6 = length - i9;
            ArrayList arrayList = new ArrayList(i6);
            i5 = 0;
            while (i5 < i6) {
                it = false;
                arrayList.add(stackTrace[i10 + i9]);
                i5++;
            }
            return (List)arrayList;
        }
        ArrayList arrayList2 = new ArrayList(i8 += $this$indexOfLast$iv);
        i4 = i9;
        while (i4 < length) {
            if (isInternalMethod(stackTrace[i4])) {
            } else {
            }
            (Collection)arrayList2.add(stackTrace[i4]);
            i4++;
            (Collection)arrayList2.add(stackTrace[i4]);
            j = i4 + 1;
            while (j < length) {
                if (isInternalMethod(stackTrace[j]) != null) {
                }
                j++;
            }
            it2 = j + -1;
            while (it2 > i4) {
                if (stackTrace[it2].getFileName() == null) {
                }
                it2--;
            }
            if (it2 > i4 && it2 < j + -1) {
            }
            (Collection)arrayList2.add(stackTrace[j + -1]);
            i4 = j;
            if (it2 < j + -1) {
            }
            (Collection)arrayList2.add(stackTrace[it2]);
            if (stackTrace[it2].getFileName() == null) {
            }
            it2--;
            if (isInternalMethod(stackTrace[j]) != null) {
            }
            j++;
        }
        return (List)arrayList2;
    }

    private final void startWeakRefCleanerThread() {
        DebugProbesImpl.weakRefCleanerThread = ThreadsKt.thread$default(false, true, 0, "Coroutines Debugger Cleaner", 0, (Function0)DebugProbesImpl.startWeakRefCleanerThread.1.INSTANCE, 21, 0);
    }

    private final void stopWeakRefCleanerThread() {
        final Thread weakRefCleanerThread = DebugProbesImpl.weakRefCleanerThread;
        if (weakRefCleanerThread == null) {
        }
        DebugProbesImpl.weakRefCleanerThread = 0;
        weakRefCleanerThread.interrupt();
        weakRefCleanerThread.join();
    }

    private final kotlinx.coroutines.debug.internal.StackTraceFrame toStackTraceFrame(List<java.lang.StackTraceElement> $this$toStackTraceFrame) {
        int accumulator$iv;
        boolean listIterator;
        Object previous;
        int i;
        int i2;
        kotlinx.coroutines.debug.internal.StackTraceFrame stackTraceFrame;
        int i3;
        Object obj = $this$toStackTraceFrame;
        int i5 = 0;
        accumulator$iv = i4;
        if (!obj.isEmpty()) {
            listIterator = obj.listIterator(obj.size());
            while (listIterator.hasPrevious()) {
                i2 = 0;
                stackTraceFrame = new StackTraceFrame((CoroutineStackFrame)accumulator$iv, (StackTraceElement)listIterator.previous());
                accumulator$iv = stackTraceFrame;
            }
        }
        StackTraceFrame stackTraceFrame2 = new StackTraceFrame((CoroutineStackFrame)accumulator$iv, DebugProbesImpl.ARTIFICIAL_FRAME);
        return stackTraceFrame2;
    }

    private final String toStringRepr(Object $this$toStringRepr) {
        return DebugProbesImplKt.access$repr($this$toStringRepr.toString());
    }

    private final void updateRunningState(CoroutineStackFrame frame, String state) {
        Object info;
        int shouldBeMatchedWithProbeSuspended;
        int realCaller;
        Object owner;
        kotlinx.coroutines.debug.internal.ConcurrentWeakMap callerInfoCache;
        if (!isInstalled$kotlinx_coroutines_debug()) {
        }
        int i = 0;
        Object remove = DebugProbesImpl.callerInfoCache.remove(frame);
        int i2 = 0;
        if ((DebugCoroutineInfoImpl)remove != null) {
            info = remove;
            shouldBeMatchedWithProbeSuspended = 0;
            Intrinsics.checkNotNull(frame, "null cannot be cast to non-null type kotlin.coroutines.Continuation<*>");
            info.updateState$kotlinx_coroutines_core(state, (Continuation)frame, shouldBeMatchedWithProbeSuspended);
            CoroutineStackFrame realCaller3 = realCaller(frame);
            if (realCaller3 == null) {
            }
            (Map)DebugProbesImpl.callerInfoCache.put(realCaller3, info);
        } else {
            owner = owner(frame);
            if (owner != null) {
                owner = owner.info;
                if (owner == null) {
                } else {
                    shouldBeMatchedWithProbeSuspended = 1;
                    CoroutineStackFrame lastObservedFrame$kotlinx_coroutines_core = owner.getLastObservedFrame$kotlinx_coroutines_core();
                    if (lastObservedFrame$kotlinx_coroutines_core != null) {
                        realCaller = realCaller(lastObservedFrame$kotlinx_coroutines_core);
                    } else {
                        realCaller = 0;
                    }
                    if (realCaller != 0) {
                        DebugProbesImpl.callerInfoCache.remove(realCaller);
                    }
                }
            }
        }
    }

    private final void updateState(Continuation<?> frame, String state) {
        boolean ignoreCoroutinesWithEmptyContext;
        Object obj;
        EmptyCoroutineContext iNSTANCE;
        if (!isInstalled$kotlinx_coroutines_debug()) {
        }
        if (DebugProbesImpl.ignoreCoroutinesWithEmptyContext != null && frame.getContext() == EmptyCoroutineContext.INSTANCE) {
            if (frame.getContext() == EmptyCoroutineContext.INSTANCE) {
            }
        }
        if (Intrinsics.areEqual(state, "RUNNING")) {
            if (frame instanceof CoroutineStackFrame) {
                obj = frame;
            } else {
                obj = 0;
            }
            if (obj == null) {
            }
            updateRunningState(obj, state);
        }
        kotlinx.coroutines.debug.internal.DebugProbesImpl.CoroutineOwner owner = owner(frame);
        if (owner == null) {
        }
        updateState(owner, frame, state);
    }

    private final void updateState(kotlinx.coroutines.debug.internal.DebugProbesImpl.CoroutineOwner<?> owner, Continuation<?> frame, String state) {
        if (!isInstalled$kotlinx_coroutines_debug()) {
        }
        owner.info.updateState$kotlinx_coroutines_core(state, frame, true);
    }

    public final void dumpCoroutines(PrintStream out) {
        int i = 0;
        DebugProbesImpl.INSTANCE.dumpCoroutinesSynchronized(out);
        Unit $i$a$SynchronizedDebugProbesImpl$dumpCoroutines$1 = Unit.INSTANCE;
        return;
        synchronized (out) {
            i = 0;
            DebugProbesImpl.INSTANCE.dumpCoroutinesSynchronized(out);
            $i$a$SynchronizedDebugProbesImpl$dumpCoroutines$1 = Unit.INSTANCE;
        }
    }

    public final List<kotlinx.coroutines.debug.internal.DebugCoroutineInfo> dumpCoroutinesInfo() {
        final Object obj = this;
        final int i = 0;
        if (!obj.isInstalled$kotlinx_coroutines_debug()) {
        } else {
            int i3 = 0;
            DebugProbesImpl.dumpCoroutinesInfoImpl$$inlined.sortedBy.1 anon = new DebugProbesImpl.dumpCoroutinesInfoImpl$$inlined.sortedBy.1();
            DebugProbesImpl.dumpCoroutinesInfo$$inlined.dumpCoroutinesInfoImpl.1 $i$f$sortedBy = new DebugProbesImpl.dumpCoroutinesInfo$$inlined.dumpCoroutinesInfoImpl.1();
            return SequencesKt.toList(SequencesKt.mapNotNull(SequencesKt.sortedWith(CollectionsKt.asSequence((Iterable)obj.getCapturedCoroutines()), (Comparator)anon), (Function1)$i$f$sortedBy));
        }
        int i2 = 0;
        IllegalStateException $i$a$CheckDebugProbesImpl$dumpCoroutinesInfoImpl$1$iv = new IllegalStateException("Debug probes are not installed".toString());
        throw $i$a$CheckDebugProbesImpl$dumpCoroutinesInfoImpl$1$iv;
    }

    public final Object[] dumpCoroutinesInfoAsJsonAndReferences() {
        Object next;
        CoroutineContext context2;
        String stringRepr;
        Object name;
        Thread lastObservedThread;
        int valueOf;
        String stringRepr2;
        String str;
        kotlin.coroutines.CoroutineContext.Element context;
        final List dumpCoroutinesInfo = dumpCoroutinesInfo();
        final int size = dumpCoroutinesInfo.size();
        ArrayList arrayList = new ArrayList(size);
        ArrayList arrayList2 = new ArrayList(size);
        ArrayList arrayList3 = new ArrayList(size);
        Iterator iterator = dumpCoroutinesInfo.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            context2 = (DebugCoroutineInfo)next.getContext();
            name = context2.get((CoroutineContext.Key)CoroutineName.Key);
            valueOf = 0;
            name = (CoroutineName)name.getName();
            if (name != null && name != null) {
            } else {
            }
            stringRepr = valueOf;
            kotlin.coroutines.CoroutineContext.Element context3 = context2.get((CoroutineContext.Key)CoroutineDispatcher.Key);
            if ((CoroutineDispatcher)context3 != null) {
            } else {
            }
            stringRepr2 = valueOf;
            StringBuilder stringBuilder2 = new StringBuilder();
            context = context2.get((CoroutineContext.Key)CoroutineId.Key);
            if ((CoroutineId)context != null) {
            }
            arrayList3.add(StringsKt.trimIndent(stringBuilder2.append("\n                {\n                    \"name\": ").append(stringRepr).append(",\n                    \"id\": ").append(valueOf).append(",\n                    \"dispatcher\": ").append(stringRepr2).append(",\n                    \"sequenceNumber\": ").append(next.getSequenceNumber()).append(",\n                    \"state\": \"").append(next.getState()).append("\"\n                } \n                ").toString()));
            arrayList2.add(next.getLastObservedFrame());
            arrayList.add(next.getLastObservedThread());
            valueOf = Long.valueOf((CoroutineId)context.getId());
            stringRepr2 = toStringRepr((CoroutineDispatcher)context3);
            name = name.getName();
            if (name != null) {
            } else {
            }
            stringRepr = toStringRepr(name);
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i4 = 0;
        int i8 = 0;
        int i6 = 0;
        int i10 = 0;
        return /* result */;
    }

    public final List<kotlinx.coroutines.debug.internal.DebuggerInfo> dumpDebuggerInfo() {
        final Object obj = this;
        final int i = 0;
        if (!obj.isInstalled$kotlinx_coroutines_debug()) {
        } else {
            int i3 = 0;
            DebugProbesImpl.dumpCoroutinesInfoImpl$$inlined.sortedBy.1 anon = new DebugProbesImpl.dumpCoroutinesInfoImpl$$inlined.sortedBy.1();
            DebugProbesImpl.dumpDebuggerInfo$$inlined.dumpCoroutinesInfoImpl.1 $i$f$sortedBy = new DebugProbesImpl.dumpDebuggerInfo$$inlined.dumpCoroutinesInfoImpl.1();
            return SequencesKt.toList(SequencesKt.mapNotNull(SequencesKt.sortedWith(CollectionsKt.asSequence((Iterable)obj.getCapturedCoroutines()), (Comparator)anon), (Function1)$i$f$sortedBy));
        }
        int i2 = 0;
        IllegalStateException $i$a$CheckDebugProbesImpl$dumpCoroutinesInfoImpl$1$iv = new IllegalStateException("Debug probes are not installed".toString());
        throw $i$a$CheckDebugProbesImpl$dumpCoroutinesInfoImpl$1$iv;
    }

    public final List<java.lang.StackTraceElement> enhanceStackTraceWithThreadDump(kotlinx.coroutines.debug.internal.DebugCoroutineInfo info, List<java.lang.StackTraceElement> coroutineTrace) {
        return enhanceStackTraceWithThreadDumpImpl(info.getState(), info.getLastObservedThread(), coroutineTrace);
    }

    public final String enhanceStackTraceWithThreadDumpAsJson(kotlinx.coroutines.debug.internal.DebugCoroutineInfo info) {
        Object next;
        String trimIndent;
        String str;
        String stringRepr;
        ArrayList arrayList = new ArrayList();
        Iterator iterator = enhanceStackTraceWithThreadDump(info, info.lastObservedStackTrace()).iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            StringBuilder stringBuilder2 = new StringBuilder();
            String fileName = next.getFileName();
            if (fileName != null) {
            } else {
            }
            stringRepr = 0;
            (List)arrayList.add(StringsKt.trimIndent(stringBuilder2.append("\n                {\n                    \"declaringClass\": \"").append((StackTraceElement)next.getClassName()).append("\",\n                    \"methodName\": \"").append(next.getMethodName()).append("\",\n                    \"fileName\": ").append(stringRepr).append(",\n                    \"lineNumber\": ").append(next.getLineNumber()).append("\n                }\n                ").toString()));
            stringRepr = toStringRepr(fileName);
        }
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append('[').append(CollectionsKt.joinToString$default((Iterable)arrayList, 0, 0, 0, 0, 0, 0, 63, 0)).append(']').toString();
    }

    public final boolean getEnableCreationStackTraces$kotlinx_coroutines_core() {
        return DebugProbesImpl.enableCreationStackTraces;
    }

    public final boolean getIgnoreCoroutinesWithEmptyContext() {
        return DebugProbesImpl.ignoreCoroutinesWithEmptyContext;
    }

    public final boolean getSanitizeStackTraces$kotlinx_coroutines_core() {
        return DebugProbesImpl.sanitizeStackTraces;
    }

    public final String hierarchyToString$kotlinx_coroutines_core(Job job) {
        Object next;
        Object next2;
        int it;
        int it2;
        kotlinx.coroutines.Job.Key key;
        if (!isInstalled$kotlinx_coroutines_debug()) {
        } else {
            int i3 = 0;
            ArrayList arrayList = new ArrayList();
            int i7 = 0;
            Iterator iterator = (Iterable)getCapturedCoroutines().iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                it = 0;
                if (next2.delegate.getContext().get((CoroutineContext.Key)Job.Key) != null) {
                } else {
                }
                it2 = 0;
                if (it2 != 0) {
                }
                (Collection)arrayList.add(next);
                it2 = 1;
            }
            int i = 0;
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault((Iterable)(List)arrayList, 10)), 16));
            int i8 = 0;
            Iterator iterator2 = arrayList.iterator();
            for (Object next2 : iterator2) {
                int i9 = 0;
                key = 0;
                (Map)linkedHashMap.put(JobKt.getJob(obj.delegate.getContext()), $i$a$AssociateByDebugProbesImpl$hierarchyToString$jobToStack$2.info);
            }
            StringBuilder stringBuilder = new StringBuilder();
            int i5 = 0;
            DebugProbesImpl.INSTANCE.build(job, linkedHashMap, stringBuilder, "");
            String string = stringBuilder.toString();
            Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
            return string;
        }
        int i2 = 0;
        IllegalStateException $i$a$CheckDebugProbesImpl$hierarchyToString$1 = new IllegalStateException("Debug probes are not installed".toString());
        throw $i$a$CheckDebugProbesImpl$hierarchyToString$1;
    }

    public final void install$kotlinx_coroutines_core() {
        int valueOf;
        valueOf = 1;
        if (DebugProbesImpl.Installations.kotlinx.VolatileWrapper.access$getInstallations$FU$p().incrementAndGet(DebugProbesImpl.installations$kotlinx$VolatileWrapper) > valueOf) {
        }
        startWeakRefCleanerThread();
        if (AgentInstallationType.INSTANCE.isInstalledStatically$kotlinx_coroutines_core()) {
        }
        Function1 dynamicAttach = DebugProbesImpl.dynamicAttach;
        if (dynamicAttach != null) {
            dynamicAttach.invoke(Boolean.valueOf(valueOf));
        }
    }

    public final boolean isInstalled$kotlinx_coroutines_debug() {
        int i;
        i = DebugProbesImpl.Installations.kotlinx.VolatileWrapper.access$getInstallations$FU$p().get(DebugProbesImpl.installations$kotlinx$VolatileWrapper) > 0 ? 1 : 0;
        return i;
    }

    public final <T> Continuation<T> probeCoroutineCreated$kotlinx_coroutines_core(Continuation<? super T> completion) {
        boolean ignoreCoroutinesWithEmptyContext;
        EmptyCoroutineContext iNSTANCE;
        int stackTraceFrame;
        if (!isInstalled$kotlinx_coroutines_debug()) {
            return completion;
        }
        if (DebugProbesImpl.ignoreCoroutinesWithEmptyContext != null && completion.getContext() == EmptyCoroutineContext.INSTANCE) {
            if (completion.getContext() == EmptyCoroutineContext.INSTANCE) {
                return completion;
            }
        }
        if (owner(completion) != null) {
            return completion;
        }
        if (DebugProbesImpl.enableCreationStackTraces) {
            Exception exception = new Exception();
            stackTraceFrame = toStackTraceFrame(sanitizeStackTrace((Throwable)exception));
        } else {
            stackTraceFrame = 0;
        }
        return createOwner(completion, stackTraceFrame);
    }

    public final void probeCoroutineResumed$kotlinx_coroutines_core(Continuation<?> frame) {
        updateState(frame, "RUNNING");
    }

    public final void probeCoroutineSuspended$kotlinx_coroutines_core(Continuation<?> frame) {
        updateState(frame, "SUSPENDED");
    }

    public final void setEnableCreationStackTraces$kotlinx_coroutines_core(boolean <set-?>) {
        DebugProbesImpl.enableCreationStackTraces = <set-?>;
    }

    public final void setIgnoreCoroutinesWithEmptyContext(boolean <set-?>) {
        DebugProbesImpl.ignoreCoroutinesWithEmptyContext = <set-?>;
    }

    public final void setSanitizeStackTraces$kotlinx_coroutines_core(boolean <set-?>) {
        DebugProbesImpl.sanitizeStackTraces = <set-?>;
    }

    public final void uninstall$kotlinx_coroutines_core() {
        Object installations$kotlinx$VolatileWrapper;
        if (!isInstalled$kotlinx_coroutines_debug()) {
        } else {
            if (DebugProbesImpl.Installations.kotlinx.VolatileWrapper.access$getInstallations$FU$p().decrementAndGet(DebugProbesImpl.installations$kotlinx$VolatileWrapper) != 0) {
            }
            stopWeakRefCleanerThread();
            DebugProbesImpl.capturedCoroutinesMap.clear();
            DebugProbesImpl.callerInfoCache.clear();
            if (AgentInstallationType.INSTANCE.isInstalledStatically$kotlinx_coroutines_core()) {
            }
            Function1 dynamicAttach = DebugProbesImpl.dynamicAttach;
            if (dynamicAttach != null) {
                dynamicAttach.invoke(false);
            }
        }
        int i = 0;
        IllegalStateException $i$a$CheckDebugProbesImpl$uninstall$1 = new IllegalStateException("Agent was not installed".toString());
        throw $i$a$CheckDebugProbesImpl$uninstall$1;
    }
}
