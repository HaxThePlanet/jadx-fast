package _COROUTINE;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0008\u0002\u001a\u0014\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0001H\u0002\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080D¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0002\u0010\u0003¨\u0006\u0008", d2 = {"ARTIFICIAL_FRAME_PACKAGE_NAME", "", "getARTIFICIAL_FRAME_PACKAGE_NAME", "()Ljava/lang/String;", "artificialFrame", "Ljava/lang/StackTraceElement;", "", "name", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CoroutineDebuggingKt {

    private static final String ARTIFICIAL_FRAME_PACKAGE_NAME;
    static {
        CoroutineDebuggingKt.ARTIFICIAL_FRAME_PACKAGE_NAME = "_COROUTINE";
    }

    public static final java.lang.StackTraceElement access$artificialFrame(Throwable $receiver, String name) {
        return CoroutineDebuggingKt.artificialFrame($receiver, name);
    }

    private static final java.lang.StackTraceElement artificialFrame(Throwable $this$artificialFrame, String name) {
        java.lang.StackTraceElement stack = $this$artificialFrame.getStackTrace()[0];
        int i2 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        StackTraceElement stackTraceElement = new StackTraceElement(stringBuilder.append(CoroutineDebuggingKt.ARTIFICIAL_FRAME_PACKAGE_NAME).append('.').append(name).toString(), "_", stack.getFileName(), stack.getLineNumber());
        return stackTraceElement;
    }

    public static final String getARTIFICIAL_FRAME_PACKAGE_NAME() {
        return CoroutineDebuggingKt.ARTIFICIAL_FRAME_PACKAGE_NAME;
    }
}
