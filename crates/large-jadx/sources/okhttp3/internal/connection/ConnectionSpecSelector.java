package okhttp3.internal.connection;

import java.io.IOException;
import java.net.UnknownServiceException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.Metadata;
import kotlin.d0.d.n;
import okhttp3.ConnectionSpec;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0005\u0008\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u000f¢\u0006\u0004\u0008\u0017\u0010\u0018J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00082\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\u0008\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00042\u0006\u0010\u000c\u001a\u00020\u000b¢\u0006\u0004\u0008\r\u0010\u000eR\u001c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\u0015\u0010\u0016R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\u0005\u0010\u0013¨\u0006\u0019", d2 = {"Lokhttp3/internal/connection/ConnectionSpecSelector;", "", "Ljavax/net/ssl/SSLSocket;", "socket", "", "isFallbackPossible", "(Ljavax/net/ssl/SSLSocket;)Z", "sslSocket", "Lokhttp3/ConnectionSpec;", "configureSecureSocket", "(Ljavax/net/ssl/SSLSocket;)Lokhttp3/ConnectionSpec;", "Ljava/io/IOException;", "e", "connectionFailed", "(Ljava/io/IOException;)Z", "", "connectionSpecs", "Ljava/util/List;", "isFallback", "Z", "", "nextModeIndex", "I", "<init>", "(Ljava/util/List;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class ConnectionSpecSelector {

    private final List<ConnectionSpec> connectionSpecs;
    private boolean isFallback;
    private boolean isFallbackPossible;
    private int nextModeIndex;
    public ConnectionSpecSelector(List<ConnectionSpec> list) {
        n.f(list, "connectionSpecs");
        super();
        this.connectionSpecs = list;
    }

    private final boolean isFallbackPossible(SSLSocket sSLSocket) {
        int nextModeIndex;
        boolean compatible;
        nextModeIndex = this.nextModeIndex;
        while (nextModeIndex < this.connectionSpecs.size()) {
            nextModeIndex++;
        }
        return 0;
    }

    public final ConnectionSpec configureSecureSocket(SSLSocket sSLSocket) {
        int nextModeIndex;
        Object obj;
        boolean compatible;
        n.f(sSLSocket, "sslSocket");
        nextModeIndex = this.nextModeIndex;
        while (nextModeIndex < this.connectionSpecs.size()) {
            nextModeIndex++;
        }
        obj = 0;
        if (obj == null) {
        } else {
            this.isFallbackPossible = isFallbackPossible(sSLSocket);
            obj.apply$okhttp(sSLSocket, this.isFallback);
            return obj;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unable to find acceptable protocols. isFallback=");
        stringBuilder.append(this.isFallback);
        int i = 44;
        stringBuilder.append(i);
        stringBuilder.append(" modes=");
        stringBuilder.append(this.connectionSpecs);
        stringBuilder.append(i);
        stringBuilder.append(" supported protocols=");
        String[] obj5 = sSLSocket.getEnabledProtocols();
        n.d(obj5);
        obj5 = Arrays.toString(obj5);
        n.e(obj5, "java.util.Arrays.toString(this)");
        stringBuilder.append(obj5);
        UnknownServiceException unknownServiceException = new UnknownServiceException(stringBuilder.toString());
        throw unknownServiceException;
    }

    public final boolean connectionFailed(IOException iOException) {
        int i;
        boolean isFallbackPossible;
        Object obj4;
        n.f(iOException, "e");
        this.isFallback = true;
        if (!this.isFallbackPossible) {
            i = i2;
        } else {
        }
        return i;
    }
}
