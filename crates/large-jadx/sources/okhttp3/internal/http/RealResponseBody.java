package okhttp3.internal.http;

import kotlin.Metadata;
import kotlin.d0.d.n;
import l.h;
import okhttp3.MediaType;
import okhttp3.MediaType.Companion;
import okhttp3.ResponseBody;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0007\u0018\u00002\u00020\u0001B!\u0012\u0008\u0010\u000c\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0008¢\u0006\u0004\u0008\u0010\u0010\u0011J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\u0008\u0003\u0010\u0004J\u0011\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\u0008\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\u0008H\u0016¢\u0006\u0004\u0008\t\u0010\nR\u0018\u0010\u000c\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u000c\u0010\rR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0003\u0010\u000eR\u0016\u0010\t\u001a\u00020\u00088\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\t\u0010\u000f¨\u0006\u0012", d2 = {"Lokhttp3/internal/http/RealResponseBody;", "Lokhttp3/ResponseBody;", "", "contentLength", "()J", "Lokhttp3/MediaType;", "contentType", "()Lokhttp3/MediaType;", "Ll/h;", "source", "()Ll/h;", "", "contentTypeString", "Ljava/lang/String;", "J", "Ll/h;", "<init>", "(Ljava/lang/String;JLl/h;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class RealResponseBody extends ResponseBody {

    private final long contentLength;
    private final String contentTypeString;
    private final h source;
    public RealResponseBody(String string, long l2, h h3) {
        n.f(obj5, "source");
        super();
        this.contentTypeString = string;
        this.contentLength = l2;
        this.source = obj5;
    }

    @Override // okhttp3.ResponseBody
    public long contentLength() {
        return this.contentLength;
    }

    @Override // okhttp3.ResponseBody
    public MediaType contentType() {
        MediaType parse;
        MediaType.Companion companion;
        String contentTypeString = this.contentTypeString;
        if (contentTypeString != null) {
            parse = MediaType.Companion.parse(contentTypeString);
        } else {
            parse = 0;
        }
        return parse;
    }

    @Override // okhttp3.ResponseBody
    public h source() {
        return this.source;
    }
}
