package okhttp3;

import java.net.Socket;
import kotlin.Metadata;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008f\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\u0008\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\u0008\u0006\u0010\u0007J\u0011\u0010\t\u001a\u0004\u0018\u00010\u0008H&¢\u0006\u0004\u0008\t\u0010\nJ\u000f\u0010\u000c\u001a\u00020\u000bH&¢\u0006\u0004\u0008\u000c\u0010\r¨\u0006\u000e", d2 = {"Lokhttp3/Connection;", "", "Lokhttp3/Route;", "route", "()Lokhttp3/Route;", "Ljava/net/Socket;", "socket", "()Ljava/net/Socket;", "Lokhttp3/Handshake;", "handshake", "()Lokhttp3/Handshake;", "Lokhttp3/Protocol;", "protocol", "()Lokhttp3/Protocol;", "okhttp"}, k = 1, mv = {1, 4, 0})
public interface Connection {
    public abstract okhttp3.Handshake handshake();

    public abstract okhttp3.Protocol protocol();

    public abstract okhttp3.Route route();

    public abstract Socket socket();
}
