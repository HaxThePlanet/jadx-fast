package kotlinx.coroutines;

import _COROUTINE.ArtificialStackFrames;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.internal.SystemPropsKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000(\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000e\n\u0002\u0008\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a\u0017\u0010\u0014\u001a\u00020\u00152\u000c\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u0017H\u0081\u0008\u001a\u0008\u0010\u0018\u001a\u00020\u0015H\u0000\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007\"\u0014\u0010\u0008\u001a\u00020\u0001X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\u0003\"\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000c\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000\"\u001c\u0010\u000f\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0010\u0010\u0011\u001a\u0004\u0008\u0012\u0010\u0003\"\u000e\u0010\u0013\u001a\u00020\u000bX\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0019", d2 = {"ASSERTIONS_ENABLED", "", "getASSERTIONS_ENABLED", "()Z", "COROUTINE_ID", "Ljava/util/concurrent/atomic/AtomicLong;", "getCOROUTINE_ID", "()Ljava/util/concurrent/atomic/AtomicLong;", "DEBUG", "getDEBUG", "DEBUG_PROPERTY_NAME", "", "DEBUG_PROPERTY_VALUE_AUTO", "DEBUG_PROPERTY_VALUE_OFF", "DEBUG_PROPERTY_VALUE_ON", "RECOVER_STACK_TRACES", "getRECOVER_STACK_TRACES$annotations", "()V", "getRECOVER_STACK_TRACES", "STACKTRACE_RECOVERY_PROPERTY_NAME", "assert", "", "value", "Lkotlin/Function0;", "resetCoroutineId", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DebugKt {

    private static final boolean ASSERTIONS_ENABLED = false;
    private static final AtomicLong COROUTINE_ID = null;
    private static final boolean DEBUG = false;
    public static final String DEBUG_PROPERTY_NAME = "kotlinx.coroutines.debug";
    public static final String DEBUG_PROPERTY_VALUE_AUTO = "auto";
    public static final String DEBUG_PROPERTY_VALUE_OFF = "off";
    public static final String DEBUG_PROPERTY_VALUE_ON = "on";
    private static final boolean RECOVER_STACK_TRACES = false;
    public static final String STACKTRACE_RECOVERY_PROPERTY_NAME = "kotlinx.coroutines.stacktrace.recovery";
    static {
        int i;
        boolean systemProp;
        int equals;
        int aSSERTIONS_ENABLED;
        Class<kotlinx.coroutines.CoroutineId> obj = CoroutineId.class;
        i = 0;
        DebugKt.ASSERTIONS_ENABLED = i;
        String systemProp2 = SystemPropsKt.systemProp("kotlinx.coroutines.debug");
        int i5 = 1;
        if (systemProp2 != null) {
            switch (systemProp2) {
                case "":
                    aSSERTIONS_ENABLED = i5;
                    DebugKt.DEBUG = aSSERTIONS_ENABLED;
                    i = i5;
                    DebugKt.RECOVER_STACK_TRACES = i;
                    AtomicLong atomicLong = new AtomicLong(0, 0);
                    DebugKt.COROUTINE_ID = atomicLong;
                case "on":
                    aSSERTIONS_ENABLED = i5;
                    DebugKt.DEBUG = aSSERTIONS_ENABLED;
                    i = i5;
                    DebugKt.RECOVER_STACK_TRACES = i;
                    atomicLong = new AtomicLong(0, i4);
                    DebugKt.COROUTINE_ID = atomicLong;
                case "off":
                    aSSERTIONS_ENABLED = i;
                    DebugKt.DEBUG = aSSERTIONS_ENABLED;
                    i = i5;
                    DebugKt.RECOVER_STACK_TRACES = i;
                    atomicLong = new AtomicLong(0, i4);
                    DebugKt.COROUTINE_ID = atomicLong;
                case "auto":
                    aSSERTIONS_ENABLED = DebugKt.ASSERTIONS_ENABLED;
                    DebugKt.DEBUG = aSSERTIONS_ENABLED;
                    i = i5;
                    DebugKt.RECOVER_STACK_TRACES = i;
                    atomicLong = new AtomicLong(0, i4);
                    DebugKt.COROUTINE_ID = atomicLong;
                default:
            }
            StringBuilder stringBuilder = new StringBuilder();
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.append("System property 'kotlinx.coroutines.debug' has unrecognized value '").append(systemProp2).append('\'').toString().toString());
            throw illegalStateException;
        }
    }

    private static final void assert(Function0<Boolean> value) {
        boolean aSSERTIONS_ENABLED;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(Boolean)value.invoke().booleanValue()) {
            } else {
            }
            AssertionError assertionError = new AssertionError();
            throw assertionError;
        }
    }

    public static final boolean getASSERTIONS_ENABLED() {
        return DebugKt.ASSERTIONS_ENABLED;
    }

    public static final AtomicLong getCOROUTINE_ID() {
        return DebugKt.COROUTINE_ID;
    }

    public static final boolean getDEBUG() {
        return DebugKt.DEBUG;
    }

    public static final boolean getRECOVER_STACK_TRACES() {
        return DebugKt.RECOVER_STACK_TRACES;
    }

    public static void getRECOVER_STACK_TRACES$annotations() {
    }

    public static final void resetCoroutineId() {
        DebugKt.COROUTINE_ID.set(0);
    }
}
