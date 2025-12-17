package app.dogo.android.network;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.d0.d.g;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u00086\u0018\u00002\u00020\u0001:\u0001\u0007B\u001f\u0008\u0004\u0012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006\u0082\u0001\u0001\u0008¨\u0006\t", d2 = {"Lapp/dogo/android/network/NetworkExceptions;", "Ljava/io/IOException;", "message", "", "cause", "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "BlankTokenException", "Lapp/dogo/android/network/NetworkExceptions$BlankTokenException;", "network_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class NetworkExceptions extends IOException {

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/android/network/NetworkExceptions$BlankTokenException;", "Lapp/dogo/android/network/NetworkExceptions;", "message", "", "cause", "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "network_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class BlankTokenException extends app.dogo.android.network.NetworkExceptions {
        public BlankTokenException() {
            final int i = 0;
            super(i, i, 3, i);
        }

        public BlankTokenException(String string, Throwable throwable2) {
            super(string, throwable2, 0);
        }

        public BlankTokenException(String string, Throwable throwable2, int i3, g g4) {
            int obj2;
            int obj3;
            final int i = 0;
            obj2 = i3 & 1 != 0 ? i : obj2;
            obj3 = i3 &= 2 != 0 ? i : obj3;
            super(obj2, obj3);
        }
    }
    private NetworkExceptions(String string, Throwable throwable2) {
        super(string, throwable2);
    }

    public NetworkExceptions(String string, Throwable throwable2, g g3) {
        super(string, throwable2);
    }
}
