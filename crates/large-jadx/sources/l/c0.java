package l;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
final class c0 extends l.d {

    private final Socket a;
    public c0(Socket socket) {
        n.f(socket, "socket");
        super();
        this.a = socket;
    }

    @Override // l.d
    protected IOException newTimeoutException(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }

    @Override // l.d
    protected void timedOut() {
        String str;
        Socket socket;
        boolean z;
        Level wARNING;
        StringBuilder stringBuilder;
        str = "Failed to close timed out socket ";
        this.a.close();
    }
}
