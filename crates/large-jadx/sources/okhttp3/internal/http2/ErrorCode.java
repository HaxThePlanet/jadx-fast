package okhttp3.internal.http2;

import kotlin.Metadata;
import kotlin.d0.d.g;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u0008\n\u0002\u0008\u0016\u0008\u0086\u0001\u0018\u0000 \t2\u0008\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\u0008\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\u0008\u0007\u0010\u0008R\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u0003\u0010\u0004\u001a\u0004\u0008\u0005\u0010\u0006j\u0002\u0008\nj\u0002\u0008\u000bj\u0002\u0008\u000cj\u0002\u0008\rj\u0002\u0008\u000ej\u0002\u0008\u000fj\u0002\u0008\u0010j\u0002\u0008\u0011j\u0002\u0008\u0012j\u0002\u0008\u0013j\u0002\u0008\u0014j\u0002\u0008\u0015j\u0002\u0008\u0016j\u0002\u0008\u0017¨\u0006\u0018", d2 = {"Lokhttp3/internal/http2/ErrorCode;", "", "", "httpCode", "I", "getHttpCode", "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "NO_ERROR", "PROTOCOL_ERROR", "INTERNAL_ERROR", "FLOW_CONTROL_ERROR", "SETTINGS_TIMEOUT", "STREAM_CLOSED", "FRAME_SIZE_ERROR", "REFUSED_STREAM", "CANCEL", "COMPRESSION_ERROR", "CONNECT_ERROR", "ENHANCE_YOUR_CALM", "INADEQUATE_SECURITY", "HTTP_1_1_REQUIRED", "okhttp"}, k = 1, mv = {1, 4, 0})
public enum ErrorCode {

    NO_ERROR(false),
    PROTOCOL_ERROR(false),
    INTERNAL_ERROR(false),
    FLOW_CONTROL_ERROR(false),
    SETTINGS_TIMEOUT(false),
    STREAM_CLOSED(false),
    FRAME_SIZE_ERROR(false),
    REFUSED_STREAM(false),
    CANCEL(false),
    COMPRESSION_ERROR(false),
    CONNECT_ERROR(false),
    ENHANCE_YOUR_CALM(false),
    INADEQUATE_SECURITY(false),
    HTTP_1_1_REQUIRED(false);

    private final int httpCode;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0007\u0010\u0008J\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\u0008\u0005\u0010\u0006¨\u0006\t", d2 = {"Lokhttp3/internal/http2/ErrorCode$Companion;", "", "", "code", "Lokhttp3/internal/http2/ErrorCode;", "fromHttp2", "(I)Lokhttp3/internal/http2/ErrorCode;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion(g g) {
            super();
        }

        public final okhttp3.internal.http2.ErrorCode fromHttp2(int i) {
            int i3;
            okhttp3.internal.http2.ErrorCode th;
            int i2;
            final okhttp3.internal.http2.ErrorCode[] values = ErrorCode.values();
            final int i4 = 0;
            i3 = i4;
            while (i3 < values.length) {
                if (values[i3].getHttpCode() == i) {
                } else {
                }
                i2 = i4;
                i3++;
                i2 = 1;
            }
            th = 0;
            return th;
        }
    }
    @Override // java.lang.Enum
    public final int getHttpCode() {
        return this.httpCode;
    }
}
