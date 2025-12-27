package app.dogo.android.network;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.d0.d.g;

/* compiled from: NetworkExceptions.kt */
@Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u00086\u0018\u00002\u00020\u0001:\u0001\u0007B\u001f\u0008\u0004\u0012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006\u0082\u0001\u0001\u0008¨\u0006\t", d2 = {"Lapp/dogo/android/network/NetworkExceptions;", "Ljava/io/IOException;", "message", "", "cause", "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "BlankTokenException", "Lapp/dogo/android/network/NetworkExceptions$BlankTokenException;", "network_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public abstract /* sealed */ class NetworkExceptions extends IOException {

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/android/network/NetworkExceptions$BlankTokenException;", "Lapp/dogo/android/network/NetworkExceptions;", "message", "", "cause", "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "network_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class BlankTokenException extends NetworkExceptions {
        public BlankTokenException(String str, Throwable th) {
            super(str, th, null);
        }

        public /* synthetic */ BlankTokenException(String str, Throwable th, int i, g gVar) {
            String str2;
            i = 0;
            i = i & 1 != 0 ? i : i;
            i = i & 2 != 0 ? i : i;
            this(str2, th);
        }

        public BlankTokenException() {
            final String str = null;
            this(str, str, 3, str);
        }
    }
    private NetworkExceptions(String str, Throwable th) {
        super(str, th);
    }

    public /* synthetic */ NetworkExceptions(String str, Throwable th, g gVar) {
        this(str, th);
    }
}
