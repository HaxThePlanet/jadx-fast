package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlinx.coroutines.internal.a0;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000(\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000e\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a\u0017\u0010\u0012\u001a\u00020\u00132\u000c\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u0015H\u0081\u0008\u001a\u0008\u0010\u0016\u001a\u00020\u0013H\u0000\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007\"\u0014\u0010\u0008\u001a\u00020\u0001X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\u0003\"\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000c\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000\"\u0014\u0010\u000f\u001a\u00020\u0001X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0003\"\u000e\u0010\u0011\u001a\u00020\u000bX\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0017", d2 = {"ASSERTIONS_ENABLED", "", "getASSERTIONS_ENABLED", "()Z", "COROUTINE_ID", "Ljava/util/concurrent/atomic/AtomicLong;", "getCOROUTINE_ID", "()Ljava/util/concurrent/atomic/AtomicLong;", "DEBUG", "getDEBUG", "DEBUG_PROPERTY_NAME", "", "DEBUG_PROPERTY_VALUE_AUTO", "DEBUG_PROPERTY_VALUE_OFF", "DEBUG_PROPERTY_VALUE_ON", "RECOVER_STACK_TRACES", "getRECOVER_STACK_TRACES", "STACKTRACE_RECOVERY_PROPERTY_NAME", "assert", "", "value", "Lkotlin/Function0;", "resetCoroutineId", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class q0 {

    private static final boolean a = false;
    private static final boolean b;
    private static final boolean c;
    private static final AtomicLong d;
    static {
        boolean z;
        int i;
        boolean equals;
        int i2;
        String str2 = a0.d("kotlinx.coroutines.debug");
        int i5 = 1;
        if (str2 != null) {
            equals = str2.hashCode();
            if (equals != 0) {
                if (equals != 3551) {
                    if (equals != 109935) {
                        if (equals != 3005871) {
                        } else {
                            if (!str2.equals("auto")) {
                            } else {
                            }
                        }
                    } else {
                        if (!str2.equals("off")) {
                        } else {
                            z = i;
                            q0.b = z;
                            if (z && a0.e("kotlinx.coroutines.stacktrace.recovery", i5)) {
                                if (a0.e("kotlinx.coroutines.stacktrace.recovery", i5)) {
                                    i = i5;
                                }
                            }
                            q0.c = i;
                            AtomicLong atomicLong = new AtomicLong(0, i5);
                            q0.d = atomicLong;
                        }
                    }
                } else {
                    if (!str2.equals("on")) {
                    } else {
                        z = i5;
                    }
                }
            } else {
                if (!str2.equals("")) {
                } else {
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("System property 'kotlinx.coroutines.debug' has unrecognized value '");
            stringBuilder.append(str2);
            stringBuilder.append('\'');
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString().toString());
            throw illegalStateException;
        }
        z = q0.a();
    }

    public static final boolean a() {
        return q0.a;
    }

    public static final AtomicLong b() {
        return q0.d;
    }

    public static final boolean c() {
        return q0.b;
    }

    public static final boolean d() {
        return q0.c;
    }
}
