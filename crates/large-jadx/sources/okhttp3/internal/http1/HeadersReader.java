package okhttp3.internal.http1;

import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import l.h;
import okhttp3.Headers;
import okhttp3.Headers.Builder;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u000c\u001a\u00020\u000b¢\u0006\u0004\u0008\u0010\u0010\u0011J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\u0008\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\u0008\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\u00088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\t\u0010\nR\u0019\u0010\u000c\u001a\u00020\u000b8\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u000c\u0010\r\u001a\u0004\u0008\u000e\u0010\u000f¨\u0006\u0013", d2 = {"Lokhttp3/internal/http1/HeadersReader;", "", "", "readLine", "()Ljava/lang/String;", "Lokhttp3/Headers;", "readHeaders", "()Lokhttp3/Headers;", "", "headerLimit", "J", "Ll/h;", "source", "Ll/h;", "getSource", "()Ll/h;", "<init>", "(Ll/h;)V", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class HeadersReader {

    public static final okhttp3.internal.http1.HeadersReader.Companion Companion = null;
    private static final int HEADER_LIMIT = 262144;
    private long headerLimit;
    private final h source;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\u0008\u0003\u0010\u0004¨\u0006\u0007", d2 = {"Lokhttp3/internal/http1/HeadersReader$Companion;", "", "", "HEADER_LIMIT", "I", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion(g g) {
            super();
        }
    }
    static {
        HeadersReader.Companion companion = new HeadersReader.Companion(0);
        HeadersReader.Companion = companion;
    }

    public HeadersReader(h h) {
        n.f(h, "source");
        super();
        this.source = h;
        this.headerLimit = (long)obj3;
    }

    public final h getSource() {
        return this.source;
    }

    public final Headers readHeaders() {
        String line;
        int i;
        Headers.Builder builder = new Headers.Builder();
        line = readLine();
        while (line.length() == 0) {
            i = 1;
            if (i == 0) {
            }
            builder.addLenient$okhttp(line);
            line = readLine();
            i = 0;
        }
        return builder.build();
    }

    public final String readLine() {
        String str = this.source.r0(this.headerLimit);
        this.headerLimit = headerLimit2 -= l;
        return str;
    }
}
