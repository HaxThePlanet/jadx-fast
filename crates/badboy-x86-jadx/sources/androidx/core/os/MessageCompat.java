package androidx.core.os;

import android.os.Message;

/* loaded from: classes5.dex */
public final class MessageCompat {

    private static boolean sTryIsAsynchronous;
    private static boolean sTrySetAsynchronous;

    static class Api22Impl {
        static boolean isAsynchronous(Message message) {
            return message.isAsynchronous();
        }

        static void setAsynchronous(Message message, boolean async) {
            message.setAsynchronous(async);
        }
    }
    static {
        final int i = 1;
        MessageCompat.sTrySetAsynchronous = i;
        MessageCompat.sTryIsAsynchronous = i;
    }

    public static boolean isAsynchronous(Message message) {
        return MessageCompat.Api22Impl.isAsynchronous(message);
    }

    public static void setAsynchronous(Message message, boolean async) {
        MessageCompat.Api22Impl.setAsynchronous(message, async);
    }
}
