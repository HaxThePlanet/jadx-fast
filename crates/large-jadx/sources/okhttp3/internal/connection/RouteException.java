package okhttp3.internal.connection;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.b;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000b\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0011\u0008\u0000\u0012\u0006\u0010\u0008\u001a\u00020\u0003¢\u0006\u0004\u0008\u000f\u0010\u0007J\u0015\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\u0008\u0006\u0010\u0007R\u0019\u0010\u0008\u001a\u00020\u00038\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u0008\u0010\t\u001a\u0004\u0008\n\u0010\u000bR$\u0010\r\u001a\u00020\u00032\u0006\u0010\u000c\u001a\u00020\u00038\u0006@BX\u0086\u000e¢\u0006\u000c\n\u0004\u0008\r\u0010\t\u001a\u0004\u0008\u000e\u0010\u000b¨\u0006\u0010", d2 = {"Lokhttp3/internal/connection/RouteException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "Ljava/io/IOException;", "e", "Lkotlin/w;", "addConnectException", "(Ljava/io/IOException;)V", "firstConnectException", "Ljava/io/IOException;", "getFirstConnectException", "()Ljava/io/IOException;", "<set-?>", "lastConnectException", "getLastConnectException", "<init>", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class RouteException extends RuntimeException {

    private final IOException firstConnectException;
    private IOException lastConnectException;
    public RouteException(IOException iOException) {
        n.f(iOException, "firstConnectException");
        super(iOException);
        this.firstConnectException = iOException;
        this.lastConnectException = iOException;
    }

    @Override // java.lang.RuntimeException
    public final void addConnectException(IOException iOException) {
        n.f(iOException, "e");
        b.a(this.firstConnectException, iOException);
        this.lastConnectException = iOException;
    }

    @Override // java.lang.RuntimeException
    public final IOException getFirstConnectException() {
        return this.firstConnectException;
    }

    @Override // java.lang.RuntimeException
    public final IOException getLastConnectException() {
        return this.lastConnectException;
    }
}
