package okhttp3.internal.http2;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\u0008\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008\u0003\u0010\u0004¨\u0006\u0007", d2 = {"Lokhttp3/internal/http2/StreamResetException;", "Ljava/io/IOException;", "Lokhttp3/internal/http2/ErrorCode;", "errorCode", "Lokhttp3/internal/http2/ErrorCode;", "<init>", "(Lokhttp3/internal/http2/ErrorCode;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class StreamResetException extends IOException {

    public final okhttp3.internal.http2.ErrorCode errorCode;
    public StreamResetException(okhttp3.internal.http2.ErrorCode errorCode) {
        n.f(errorCode, "errorCode");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("stream was reset: ");
        stringBuilder.append(errorCode);
        super(stringBuilder.toString());
        this.errorCode = errorCode;
    }
}
