package okhttp3.internal.http2;

import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import l.h;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008f\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018J%\u0010\u0008\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004H&¢\u0006\u0004\u0008\u0008\u0010\tJ-\u0010\u000c\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u000c\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u000b\u001a\u00020\u0007H&¢\u0006\u0004\u0008\u000c\u0010\rJ/\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0007H&¢\u0006\u0004\u0008\u0011\u0010\u0012J\u001f\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\u0008\u0016\u0010\u0017¨\u0006\u0019", d2 = {"Lokhttp3/internal/http2/PushObserver;", "", "", "streamId", "", "Lokhttp3/internal/http2/Header;", "requestHeaders", "", "onRequest", "(ILjava/util/List;)Z", "responseHeaders", "last", "onHeaders", "(ILjava/util/List;Z)Z", "Ll/h;", "source", "byteCount", "onData", "(ILl/h;IZ)Z", "Lokhttp3/internal/http2/ErrorCode;", "errorCode", "Lkotlin/w;", "onReset", "(ILokhttp3/internal/http2/ErrorCode;)V", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
public interface PushObserver {

    public static final okhttp3.internal.http2.PushObserver CANCEL;
    public static final okhttp3.internal.http2.PushObserver.Companion Companion;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0007B\t\u0008\u0002¢\u0006\u0004\u0008\u0005\u0010\u0006R\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\u0008\u0003\u0010\u0004¨\u0006\u0001\u0082\u0002\u0007\n\u0005\u0008\u0091F0\u0001¨\u0006\u0008", d2 = {"Lokhttp3/internal/http2/PushObserver$Companion;", "", "Lokhttp3/internal/http2/PushObserver;", "CANCEL", "Lokhttp3/internal/http2/PushObserver;", "<init>", "()V", "PushObserverCancel", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {

        static final okhttp3.internal.http2.PushObserver.Companion $$INSTANCE;
        public Companion(g g) {
            super();
        }
    }
    static {
        PushObserver.Companion companion = new PushObserver.Companion(0);
        PushObserver.Companion = companion;
        PushObserver.Companion.PushObserverCancel pushObserverCancel = new PushObserver.Companion.PushObserverCancel();
        PushObserver.CANCEL = pushObserverCancel;
    }

    public abstract boolean onData(int i, h h2, int i3, boolean z4);

    public abstract boolean onHeaders(int i, List<okhttp3.internal.http2.Header> list2, boolean z3);

    public abstract boolean onRequest(int i, List<okhttp3.internal.http2.Header> list2);

    public abstract void onReset(int i, okhttp3.internal.http2.ErrorCode errorCode2);
}
