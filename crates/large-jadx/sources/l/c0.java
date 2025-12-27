package l;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.d0.d.n;

/* compiled from: JvmOkio.kt */
/* loaded from: classes3.dex */
final class c0 extends d {

    private final Socket a;
    public c0(Socket socket) {
        n.f(socket, "socket");
        super();
        this.a = socket;
    }

    @Override // l.d
    protected IOException newTimeoutException(IOException exc) {
        final SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (exc != null) {
            socketTimeoutException.initCause(exc);
        }
        return socketTimeoutException;
    }

    @Override // l.d
    protected void timedOut() throws IOException {
        str = "Failed to close timed out socket ";
        try {
            this.a.close();
        } catch (java.lang.AssertionError e) {
            boolean z = q.e(e);
        } catch (Exception e1) {
            z = r.a;
            Level wARNING2 = Level.WARNING;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str2);
            stringBuilder.append(this.a);
            String str2 = stringBuilder.toString();
            z.log(wARNING2, this.a, e1);
        }
    }
}
