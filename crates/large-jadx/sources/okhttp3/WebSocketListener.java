package okhttp3;

import kotlin.Metadata;
import kotlin.d0.d.n;
import l.i;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u0003\n\u0002\u0008\u0006\u0008&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\u0008\u001a\u0010\u001bJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\u0008\u0007\u0010\u0008J\u001f\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\u0008\u000b\u0010\u000cJ\u001f\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\u0008\u000b\u0010\u000fJ'\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\tH\u0016¢\u0006\u0004\u0008\u0013\u0010\u0014J'\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\tH\u0016¢\u0006\u0004\u0008\u0015\u0010\u0014J)\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\u0008\u0018\u0010\u0019¨\u0006\u001c", d2 = {"Lokhttp3/WebSocketListener;", "", "Lokhttp3/WebSocket;", "webSocket", "Lokhttp3/Response;", "response", "Lkotlin/w;", "onOpen", "(Lokhttp3/WebSocket;Lokhttp3/Response;)V", "", "text", "onMessage", "(Lokhttp3/WebSocket;Ljava/lang/String;)V", "Ll/i;", "bytes", "(Lokhttp3/WebSocket;Ll/i;)V", "", "code", "reason", "onClosing", "(Lokhttp3/WebSocket;ILjava/lang/String;)V", "onClosed", "", "t", "onFailure", "(Lokhttp3/WebSocket;Ljava/lang/Throwable;Lokhttp3/Response;)V", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
public abstract class WebSocketListener {
    public void onClosed(okhttp3.WebSocket webSocket, int i2, String string3) {
        n.f(webSocket, "webSocket");
        n.f(string3, "reason");
    }

    public void onClosing(okhttp3.WebSocket webSocket, int i2, String string3) {
        n.f(webSocket, "webSocket");
        n.f(string3, "reason");
    }

    public void onFailure(okhttp3.WebSocket webSocket, Throwable throwable2, okhttp3.Response response3) {
        n.f(webSocket, "webSocket");
        n.f(throwable2, "t");
    }

    public void onMessage(okhttp3.WebSocket webSocket, String string2) {
        n.f(webSocket, "webSocket");
        n.f(string2, "text");
    }

    public void onMessage(okhttp3.WebSocket webSocket, i i2) {
        n.f(webSocket, "webSocket");
        n.f(i2, "bytes");
    }

    public void onOpen(okhttp3.WebSocket webSocket, okhttp3.Response response2) {
        n.f(webSocket, "webSocket");
        n.f(response2, "response");
    }
}
