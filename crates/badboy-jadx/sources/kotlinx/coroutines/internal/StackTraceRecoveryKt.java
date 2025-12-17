package kotlinx.coroutines.internal;

import _COROUTINE.ArtificialStackFrames;
import _COROUTINE.CoroutineDebuggingKt;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.DebugKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0010\u0003\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0008\u0002\n\u0002\u0010\u0001\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0008\u001a9\u0010\u0008\u001a\u0002H\t\"\u0008\u0008\u0000\u0010\t*\u00020\n2\u0006\u0010\u000b\u001a\u0002H\t2\u0006\u0010\u000c\u001a\u0002H\t2\u0010\u0010\r\u001a\u000c\u0012\u0008\u0012\u00060\u0001j\u0002`\u000f0\u000eH\u0002¢\u0006\u0002\u0010\u0010\u001a\u001e\u0010\u0011\u001a\u000c\u0012\u0008\u0012\u00060\u0001j\u0002`\u000f0\u000e2\n\u0010\u0012\u001a\u00060\u0013j\u0002`\u0014H\u0002\u001a1\u0010\u0015\u001a\u00020\u00162\u0010\u0010\u0017\u001a\u000c\u0012\u0008\u0012\u00060\u0001j\u0002`\u000f0\u00182\u0010\u0010\u000c\u001a\u000c\u0012\u0008\u0012\u00060\u0001j\u0002`\u000f0\u000eH\u0002¢\u0006\u0002\u0010\u0019\u001a\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\nH\u0080Hø\u0001\u0000¢\u0006\u0002\u0010\u001d\u001a+\u0010\u001e\u001a\u0002H\t\"\u0008\u0008\u0000\u0010\t*\u00020\n2\u0006\u0010\u001c\u001a\u0002H\t2\n\u0010\u0012\u001a\u00060\u0013j\u0002`\u0014H\u0002¢\u0006\u0002\u0010\u001f\u001a\u001f\u0010 \u001a\u0002H\t\"\u0008\u0008\u0000\u0010\t*\u00020\n2\u0006\u0010\u001c\u001a\u0002H\tH\u0000¢\u0006\u0002\u0010!\u001a,\u0010 \u001a\u0002H\t\"\u0008\u0008\u0000\u0010\t*\u00020\n2\u0006\u0010\u001c\u001a\u0002H\t2\n\u0010\u0012\u001a\u0006\u0012\u0002\u0008\u00030\"H\u0080\u0008¢\u0006\u0002\u0010#\u001a \u0010$\u001a\u0002H\t\"\u0008\u0008\u0000\u0010\t*\u00020\n2\u0006\u0010\u001c\u001a\u0002H\tH\u0081\u0008¢\u0006\u0002\u0010!\u001a\u001f\u0010%\u001a\u0002H\t\"\u0008\u0008\u0000\u0010\t*\u00020\n2\u0006\u0010\u001c\u001a\u0002H\tH\u0001¢\u0006\u0002\u0010!\u001a1\u0010&\u001a\u0018\u0012\u0004\u0012\u0002H\t\u0012\u000e\u0012\u000c\u0012\u0008\u0012\u00060\u0001j\u0002`\u000f0\u00180'\"\u0008\u0008\u0000\u0010\t*\u00020\n*\u0002H\tH\u0002¢\u0006\u0002\u0010(\u001a\u001c\u0010)\u001a\u00020**\u00060\u0001j\u0002`\u000f2\n\u0010+\u001a\u00060\u0001j\u0002`\u000fH\u0002\u001a#\u0010,\u001a\u00020-*\u000c\u0012\u0008\u0012\u00060\u0001j\u0002`\u000f0\u00182\u0006\u0010.\u001a\u00020\u0003H\u0002¢\u0006\u0002\u0010/\u001a\u0014\u00100\u001a\u00020\u0016*\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0000\u001a\u0010\u00101\u001a\u00020**\u00060\u0001j\u0002`\u000fH\u0000\u001a\u001b\u00102\u001a\u0002H\t\"\u0008\u0008\u0000\u0010\t*\u00020\n*\u0002H\tH\u0002¢\u0006\u0002\u0010!\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0004\u001a\n \u0005*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0007\u001a\n \u0005*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000*\u000c\u0008\u0000\u00103\"\u00020\u00132\u00020\u0013*\u000c\u0008\u0000\u00104\"\u00020\u00012\u00020\u0001\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u00065", d2 = {"ARTIFICIAL_FRAME", "Ljava/lang/StackTraceElement;", "baseContinuationImplClass", "", "baseContinuationImplClassName", "kotlin.jvm.PlatformType", "stackTraceRecoveryClass", "stackTraceRecoveryClassName", "createFinalException", "E", "", "cause", "result", "resultStackTrace", "Ljava/util/ArrayDeque;", "Lkotlinx/coroutines/internal/StackTraceElement;", "(Ljava/lang/Throwable;Ljava/lang/Throwable;Ljava/util/ArrayDeque;)Ljava/lang/Throwable;", "createStackTrace", "continuation", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "mergeRecoveredTraces", "", "recoveredStacktrace", "", "([Ljava/lang/StackTraceElement;Ljava/util/ArrayDeque;)V", "recoverAndThrow", "", "exception", "(Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recoverFromStackFrame", "(Ljava/lang/Throwable;Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)Ljava/lang/Throwable;", "recoverStackTrace", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "Lkotlin/coroutines/Continuation;", "(Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Throwable;", "unwrap", "unwrapImpl", "causeAndStacktrace", "Lkotlin/Pair;", "(Ljava/lang/Throwable;)Lkotlin/Pair;", "elementWiseEquals", "", "e", "firstFrameIndex", "", "methodName", "([Ljava/lang/StackTraceElement;Ljava/lang/String;)I", "initCause", "isArtificial", "sanitizeStackTrace", "CoroutineStackFrame", "StackTraceElement", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class StackTraceRecoveryKt {

    private static final java.lang.StackTraceElement ARTIFICIAL_FRAME = null;
    private static final String baseContinuationImplClass = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
    private static final String baseContinuationImplClassName = null;
    private static final String stackTraceRecoveryClass = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
    private static final String stackTraceRecoveryClassName;
    static {
        Object str2;
        Object str;
        Object constructor-impl;
        Object constructor-impl2;
        String canonicalName;
        String canonicalName2;
        ArtificialStackFrames artificialStackFrames = new ArtificialStackFrames();
        StackTraceRecoveryKt.ARTIFICIAL_FRAME = artificialStackFrames.coroutineBoundary();
        kotlin.Result.Companion companion3 = Result.Companion;
        int i2 = 0;
        constructor-impl2 = Result.constructor-impl(Class.forName("kotlin.coroutines.jvm.internal.BaseContinuationImpl").getCanonicalName());
        if (Result.exceptionOrNull-impl(constructor-impl2) == null) {
            str = constructor-impl2;
        } else {
            constructor-impl2 = 0;
        }
        StackTraceRecoveryKt.baseContinuationImplClassName = (String)str;
        kotlin.Result.Companion companion = Result.Companion;
        int i = 0;
        constructor-impl = Result.constructor-impl(Class.forName("kotlinx.coroutines.internal.StackTraceRecoveryKt").getCanonicalName());
        if (Result.exceptionOrNull-impl(constructor-impl) == null) {
            str2 = constructor-impl;
        } else {
            constructor-impl = 0;
        }
        StackTraceRecoveryKt.stackTraceRecoveryClassName = (String)str2;
    }

    public static void CoroutineStackFrame$annotations() {
    }

    public static void StackTraceElement$annotations() {
    }

    public static final Throwable access$recoverFromStackFrame(Throwable exception, CoroutineStackFrame continuation) {
        return StackTraceRecoveryKt.recoverFromStackFrame(exception, continuation);
    }

    private static final <E extends Throwable> Pair<E, java.lang.StackTraceElement[]> causeAndStacktrace(E $this$causeAndStacktrace) {
        Pair pair;
        boolean equal;
        int stackTrace;
        Class class;
        int i;
        int i3;
        int i2;
        java.lang.StackTraceElement stack;
        boolean it;
        int i4;
        final Throwable cause = $this$causeAndStacktrace.getCause();
        int i5 = 0;
        if (cause != null && Intrinsics.areEqual(cause.getClass(), $this$causeAndStacktrace.getClass())) {
            if (Intrinsics.areEqual(cause.getClass(), $this$causeAndStacktrace.getClass())) {
                stackTrace = $this$causeAndStacktrace.getStackTrace();
                class = stackTrace;
                i = 0;
                i2 = i5;
                while (i2 < class.length) {
                    i4 = 0;
                    i2++;
                }
                i3 = i5;
                if (i3 != 0) {
                    pair = TuplesKt.to(cause, stackTrace);
                } else {
                    class = 0;
                    pair = TuplesKt.to($this$causeAndStacktrace, new StackTraceElement[i5]);
                }
            } else {
                stackTrace = 0;
                pair = TuplesKt.to($this$causeAndStacktrace, new StackTraceElement[i5]);
            }
        } else {
        }
        return pair;
    }

    private static final <E extends Throwable> E createFinalException(E cause, E result, ArrayDeque<java.lang.StackTraceElement> resultStackTrace) {
        int i;
        int i2;
        java.lang.StackTraceElement stack;
        Object next;
        int i3;
        resultStackTrace.addFirst(StackTraceRecoveryKt.ARTIFICIAL_FRAME);
        java.lang.StackTraceElement[] stackTrace = cause.getStackTrace();
        int firstFrameIndex = StackTraceRecoveryKt.firstFrameIndex(stackTrace, StackTraceRecoveryKt.baseContinuationImplClassName);
        if (firstFrameIndex == -1) {
            int i6 = 0;
            result.setStackTrace((StackTraceElement[])(Collection)resultStackTrace.toArray(new StackTraceElement[0]));
            return result;
        }
        java.lang.StackTraceElement[] arr = new StackTraceElement[size += firstFrameIndex];
        i2 = 0;
        while (i2 < firstFrameIndex) {
            arr[i2] = stackTrace[i2];
            i2++;
        }
        Iterator iterator = resultStackTrace.iterator();
        for (StackTraceElement next : iterator) {
            i++;
            arr[firstFrameIndex + stack] = next;
        }
        result.setStackTrace(arr);
        return result;
    }

    private static final ArrayDeque<java.lang.StackTraceElement> createStackTrace(CoroutineStackFrame continuation) {
        Object it;
        int stackTraceElement;
        int callerFrame;
        int i;
        ArrayDeque arrayDeque = new ArrayDeque();
        java.lang.StackTraceElement stackTraceElement2 = continuation.getStackTraceElement();
        if (stackTraceElement2 != null) {
            stackTraceElement = 0;
            arrayDeque.add(stackTraceElement2);
        }
        it = continuation;
        while (it instanceof CoroutineStackFrame) {
            callerFrame = it;
            if (callerFrame != 0) {
                break;
            }
            callerFrame = callerFrame.getCallerFrame();
            if (callerFrame == null) {
                break;
            } else {
            }
            stackTraceElement = callerFrame.getStackTraceElement();
            if (stackTraceElement != 0) {
            }
            callerFrame = 0;
            i = 0;
            arrayDeque.add(stackTraceElement);
        }
        return arrayDeque;
    }

    private static final boolean elementWiseEquals(java.lang.StackTraceElement $this$elementWiseEquals, java.lang.StackTraceElement e) {
        int lineNumber;
        int i;
        int lineNumber2;
        if ($this$elementWiseEquals.getLineNumber() == e.getLineNumber() && Intrinsics.areEqual($this$elementWiseEquals.getMethodName(), e.getMethodName()) && Intrinsics.areEqual($this$elementWiseEquals.getFileName(), e.getFileName()) != null && Intrinsics.areEqual($this$elementWiseEquals.getClassName(), e.getClassName())) {
            if (Intrinsics.areEqual($this$elementWiseEquals.getMethodName(), e.getMethodName())) {
                if (Intrinsics.areEqual($this$elementWiseEquals.getFileName(), e.getFileName()) != null) {
                    i = Intrinsics.areEqual($this$elementWiseEquals.getClassName(), e.getClassName()) ? 1 : 0;
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    private static final int firstFrameIndex(java.lang.StackTraceElement[] $this$firstFrameIndex, String methodName) {
        int index$iv;
        boolean it;
        int i;
        String className;
        final Object[] objArr = $this$firstFrameIndex;
        final int i2 = 0;
        index$iv = 0;
        while (index$iv < objArr.length) {
            i = 0;
            index$iv++;
        }
        index$iv = -1;
        return index$iv;
    }

    public static final void initCause(Throwable $this$initCause, Throwable cause) {
        $this$initCause.initCause(cause);
    }

    public static final boolean isArtificial(java.lang.StackTraceElement $this$isArtificial) {
        return StringsKt.startsWith$default($this$isArtificial.getClassName(), CoroutineDebuggingKt.getARTIFICIAL_FRAME_PACKAGE_NAME(), false, 2, 0);
    }

    private static final void mergeRecoveredTraces(java.lang.StackTraceElement[] recoveredStacktrace, ArrayDeque<java.lang.StackTraceElement> result) {
        int i;
        int index$iv;
        int length;
        boolean it;
        int i2;
        int[] iArr = recoveredStacktrace;
        int i4 = 0;
        index$iv = 0;
        while (index$iv < iArr.length) {
            i2 = 0;
            index$iv++;
        }
        index$iv = -1;
        index$iv++;
        if (i5 <= length2--) {
        }
    }

    public static final Object recoverAndThrow(Throwable exception, Continuation<?> $completion) {
        final int i = 0;
        if (!DebugKt.getRECOVER_STACK_TRACES()) {
        } else {
            Object obj = $completion;
            final int i2 = 0;
            if (!obj instanceof CoroutineStackFrame) {
                throw exception;
            }
            throw StackTraceRecoveryKt.access$recoverFromStackFrame(exception, (CoroutineStackFrame)obj);
        }
        throw exception;
    }

    private static final Object recoverAndThrow$$forInline(Throwable exception, Continuation<?> $completion) {
        final int i = 0;
        if (!DebugKt.getRECOVER_STACK_TRACES()) {
        } else {
            Object obj = $completion;
            final int i2 = 0;
            if (!obj instanceof CoroutineStackFrame) {
                throw exception;
            }
            throw StackTraceRecoveryKt.access$recoverFromStackFrame(exception, (CoroutineStackFrame)(Continuation)obj);
        }
        throw exception;
    }

    private static final <E extends Throwable> E recoverFromStackFrame(E exception, CoroutineStackFrame continuation) {
        Pair causeAndStacktrace = StackTraceRecoveryKt.causeAndStacktrace(exception);
        final Object component1 = causeAndStacktrace.component1();
        final Throwable tryCopyException = ExceptionsConstructorKt.tryCopyException((Throwable)component1);
        if (tryCopyException == null) {
            return exception;
        }
        final ArrayDeque stackTrace = StackTraceRecoveryKt.createStackTrace(continuation);
        if (stackTrace.isEmpty()) {
            return exception;
        }
        if (component1 != exception) {
            StackTraceRecoveryKt.mergeRecoveredTraces((StackTraceElement[])causeAndStacktrace.component2(), stackTrace);
        }
        return StackTraceRecoveryKt.createFinalException(component1, tryCopyException, stackTrace);
    }

    public static final <E extends Throwable> E recoverStackTrace(E exception) {
        if (!DebugKt.getRECOVER_STACK_TRACES()) {
            return exception;
        }
        Throwable tryCopyException = ExceptionsConstructorKt.tryCopyException(exception);
        if (tryCopyException == null) {
            return exception;
        }
        return StackTraceRecoveryKt.sanitizeStackTrace(tryCopyException);
    }

    public static final <E extends Throwable> E recoverStackTrace(E exception, Continuation<?> continuation) {
        boolean rECOVER_STACK_TRACES;
        final int i = 0;
        if (DebugKt.getRECOVER_STACK_TRACES() && !continuation instanceof CoroutineStackFrame) {
            if (!continuation instanceof CoroutineStackFrame) {
            }
            return StackTraceRecoveryKt.access$recoverFromStackFrame(exception, (CoroutineStackFrame)continuation);
        }
        return exception;
    }

    private static final <E extends Throwable> E sanitizeStackTrace(E $this$sanitizeStackTrace) {
        int i2;
        int i4;
        int i;
        int index$iv;
        boolean it;
        int i3;
        String stackTraceRecoveryClassName;
        String className;
        final java.lang.StackTraceElement[] stackTrace = $this$sanitizeStackTrace.getStackTrace();
        final int length = stackTrace.length;
        java.lang.StackTraceElement[] objArr = stackTrace;
        int i6 = 0;
        int i7 = -1;
        if (length2 += i7 >= 0) {
        } else {
            index$iv = i7;
        }
        int firstFrameIndex = StackTraceRecoveryKt.firstFrameIndex(stackTrace, StackTraceRecoveryKt.baseContinuationImplClassName);
        i = firstFrameIndex == i7 ? i4 : length - firstFrameIndex;
        i8 -= i;
        java.lang.StackTraceElement[] arr = new StackTraceElement[i9];
        while (i4 < i9) {
            if (i4 == 0) {
            } else {
            }
            stackTraceRecoveryClassName = stackTrace[i10--];
            arr[i4] = stackTraceRecoveryClassName;
            i4++;
            stackTraceRecoveryClassName = StackTraceRecoveryKt.ARTIFICIAL_FRAME;
        }
        $this$sanitizeStackTrace.setStackTrace(arr);
        return $this$sanitizeStackTrace;
    }

    public static final <E extends Throwable> E unwrap(E exception) {
        Throwable unwrapImpl;
        final int i = 0;
        if (!DebugKt.getRECOVER_STACK_TRACES()) {
            unwrapImpl = exception;
        } else {
            unwrapImpl = StackTraceRecoveryKt.unwrapImpl(exception);
        }
        return unwrapImpl;
    }

    public static final <E extends Throwable> E unwrapImpl(E exception) {
        boolean equal;
        Class class;
        int i2;
        int i3;
        java.lang.StackTraceElement stack;
        boolean it;
        int i;
        final Throwable cause = exception.getCause();
        if (cause != null) {
            if (!Intrinsics.areEqual(cause.getClass(), exception.getClass())) {
            } else {
                java.lang.StackTraceElement[] stackTrace = exception.getStackTrace();
                int i4 = 0;
                i3 = i2;
                while (i3 < stackTrace.length) {
                    i = 0;
                    i3++;
                }
                if (i2 != 0) {
                    return cause;
                }
            }
            return exception;
        }
        return exception;
    }
}
