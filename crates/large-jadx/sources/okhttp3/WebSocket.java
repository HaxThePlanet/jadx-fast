package okhttp3;

import kotlin.Metadata;
import l.i;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008f\u0018\u00002\u00020\u0001:\u0001\u0018J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\u0008\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\u0008\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0008H&¢\u0006\u0004\u0008\u000b\u0010\u000cJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\u0008\u000b\u0010\u000fJ!\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00102\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0008H&¢\u0006\u0004\u0008\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\u0008\u0016\u0010\u0017¨\u0006\u0019", d2 = {"Lokhttp3/WebSocket;", "", "Lokhttp3/Request;", "request", "()Lokhttp3/Request;", "", "queueSize", "()J", "", "text", "", "send", "(Ljava/lang/String;)Z", "Ll/i;", "bytes", "(Ll/i;)Z", "", "code", "reason", "close", "(ILjava/lang/String;)Z", "Lkotlin/w;", "cancel", "()V", "Factory", "okhttp"}, k = 1, mv = {1, 4, 0})
public interface WebSocket {

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008æ\u0080\u0001\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\u0008\u0007\u0010\u0008¨\u0006\t", d2 = {"Lokhttp3/WebSocket$Factory;", "", "Lokhttp3/Request;", "request", "Lokhttp3/WebSocketListener;", "listener", "Lokhttp3/WebSocket;", "newWebSocket", "(Lokhttp3/Request;Lokhttp3/WebSocketListener;)Lokhttp3/WebSocket;", "okhttp"}, k = 1, mv = {1, 4, 0})
    public interface Factory {
        public abstract okhttp3.WebSocket newWebSocket(okhttp3.Request request, okhttp3.WebSocketListener webSocketListener2);
    }
    public abstract void cancel();

    public abstract boolean close(int i, String string2);

    public abstract long queueSize();

    public abstract okhttp3.Request request();

    public abstract boolean send(String string);

    public abstract boolean send(i i);
}
