package okhttp3;

import kotlin.Metadata;
import l.e0;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008f\u0018\u00002\u00020\u0001:\u0001\u0018J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\u0008\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\u0008\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0008H&¢\u0006\u0004\u0008\u000b\u0010\u000cJ\u000f\u0010\r\u001a\u00020\nH&¢\u0006\u0004\u0008\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\u0008\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000fH&¢\u0006\u0004\u0008\u0012\u0010\u0011J\u000f\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\u0008\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0000H&¢\u0006\u0004\u0008\u0016\u0010\u0017¨\u0006\u0019", d2 = {"Lokhttp3/Call;", "", "Lokhttp3/Request;", "request", "()Lokhttp3/Request;", "Lokhttp3/Response;", "execute", "()Lokhttp3/Response;", "Lokhttp3/Callback;", "responseCallback", "Lkotlin/w;", "enqueue", "(Lokhttp3/Callback;)V", "cancel", "()V", "", "isExecuted", "()Z", "isCanceled", "Ll/e0;", "timeout", "()Ll/e0;", "clone", "()Lokhttp3/Call;", "Factory", "okhttp"}, k = 1, mv = {1, 4, 0})
public interface Call extends java.lang.Cloneable {

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008æ\u0080\u0001\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lokhttp3/Call$Factory;", "", "Lokhttp3/Request;", "request", "Lokhttp3/Call;", "newCall", "(Lokhttp3/Request;)Lokhttp3/Call;", "okhttp"}, k = 1, mv = {1, 4, 0})
    public interface Factory {
        public abstract okhttp3.Call newCall(okhttp3.Request request);
    }
    @Override // java.lang.Cloneable
    public abstract void cancel();

    @Override // java.lang.Cloneable
    public abstract okhttp3.Call clone();

    @Override // java.lang.Cloneable
    public abstract void enqueue(okhttp3.Callback callback);

    @Override // java.lang.Cloneable
    public abstract okhttp3.Response execute();

    @Override // java.lang.Cloneable
    public abstract boolean isCanceled();

    @Override // java.lang.Cloneable
    public abstract boolean isExecuted();

    @Override // java.lang.Cloneable
    public abstract okhttp3.Request request();

    @Override // java.lang.Cloneable
    public abstract e0 timeout();
}
