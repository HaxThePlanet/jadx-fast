package okhttp3;

import java.io.File;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.k0.d;
import l.g;
import l.i;
import okhttp3.internal.Util;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0007\u0008&\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\u0008\u0011\u0010\u0012J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\u0008\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\u0008\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0008H&¢\u0006\u0004\u0008\u000b\u0010\u000cJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\u0008\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0016¢\u0006\u0004\u0008\u0010\u0010\u000f¨\u0006\u0014", d2 = {"Lokhttp3/RequestBody;", "", "Lokhttp3/MediaType;", "contentType", "()Lokhttp3/MediaType;", "", "contentLength", "()J", "Ll/g;", "sink", "Lkotlin/w;", "writeTo", "(Ll/g;)V", "", "isDuplex", "()Z", "isOneShot", "<init>", "()V", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
public abstract class RequestBody {

    public static final okhttp3.RequestBody.Companion Companion;

    @Metadata(bv = {1, 0, 3}, d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u000b\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0019\u0010\u001aJ\u001f\u0010\u0008\u001a\u00020\u0005*\u00020\u00022\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\u0008\u0006\u0010\u0007J\u001f\u0010\u0008\u001a\u00020\u0005*\u00020\t2\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\u0008\u0006\u0010\nJ3\u0010\u0008\u001a\u00020\u0005*\u00020\u000b2\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0008\u0008\u0002\u0010\r\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000cH\u0007¢\u0006\u0004\u0008\u0006\u0010\u000fJ\u001f\u0010\u0012\u001a\u00020\u0005*\u00020\u00102\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\u0008\u0006\u0010\u0011J!\u0010\u0006\u001a\u00020\u00052\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0013\u001a\u00020\u0002H\u0007¢\u0006\u0004\u0008\u0006\u0010\u0014J!\u0010\u0006\u001a\u00020\u00052\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0013\u001a\u00020\tH\u0007¢\u0006\u0004\u0008\u0006\u0010\u0015J5\u0010\u0006\u001a\u00020\u00052\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0013\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000cH\u0007¢\u0006\u0004\u0008\u0006\u0010\u0016J!\u0010\u0006\u001a\u00020\u00052\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0017\u001a\u00020\u0010H\u0007¢\u0006\u0004\u0008\u0006\u0010\u0018¨\u0006\u001b", d2 = {"Lokhttp3/RequestBody$Companion;", "", "", "Lokhttp3/MediaType;", "contentType", "Lokhttp3/RequestBody;", "create", "(Ljava/lang/String;Lokhttp3/MediaType;)Lokhttp3/RequestBody;", "toRequestBody", "Ll/i;", "(Ll/i;Lokhttp3/MediaType;)Lokhttp3/RequestBody;", "", "", "offset", "byteCount", "([BLokhttp3/MediaType;II)Lokhttp3/RequestBody;", "Ljava/io/File;", "(Ljava/io/File;Lokhttp3/MediaType;)Lokhttp3/RequestBody;", "asRequestBody", "content", "(Lokhttp3/MediaType;Ljava/lang/String;)Lokhttp3/RequestBody;", "(Lokhttp3/MediaType;Ll/i;)Lokhttp3/RequestBody;", "(Lokhttp3/MediaType;[BII)Lokhttp3/RequestBody;", "file", "(Lokhttp3/MediaType;Ljava/io/File;)Lokhttp3/RequestBody;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion(g g) {
            super();
        }

        public static okhttp3.RequestBody create$default(okhttp3.RequestBody.Companion requestBody$Companion, File file2, okhttp3.MediaType mediaType3, int i4, Object object5) {
            int obj2;
            if (i4 &= 1 != 0) {
                obj2 = 0;
            }
            return companion.create(file2, obj2);
        }

        public static okhttp3.RequestBody create$default(okhttp3.RequestBody.Companion requestBody$Companion, String string2, okhttp3.MediaType mediaType3, int i4, Object object5) {
            int obj2;
            if (i4 &= 1 != 0) {
                obj2 = 0;
            }
            return companion.create(string2, obj2);
        }

        public static okhttp3.RequestBody create$default(okhttp3.RequestBody.Companion requestBody$Companion, i i2, okhttp3.MediaType mediaType3, int i4, Object object5) {
            int obj2;
            if (i4 &= 1 != 0) {
                obj2 = 0;
            }
            return companion.create(i2, obj2);
        }

        public static okhttp3.RequestBody create$default(okhttp3.RequestBody.Companion requestBody$Companion, okhttp3.MediaType mediaType2, byte[] b3Arr3, int i4, int i5, int i6, Object object7) {
            int obj3;
            int obj4;
            if (i6 & 4 != 0) {
                obj3 = 0;
            }
            if (i6 &= 8 != 0) {
                obj4 = b3Arr3.length;
            }
            return companion.create(mediaType2, b3Arr3, obj3, obj4);
        }

        public static okhttp3.RequestBody create$default(okhttp3.RequestBody.Companion requestBody$Companion, byte[] b2Arr2, okhttp3.MediaType mediaType3, int i4, int i5, int i6, Object object7) {
            int obj2;
            int obj3;
            int obj4;
            if (i6 & 1 != 0) {
                obj2 = 0;
            }
            if (i6 & 2 != 0) {
                obj3 = 0;
            }
            if (i6 &= 4 != 0) {
                obj4 = b2Arr2.length;
            }
            return companion.create(b2Arr2, obj2, obj3, obj4);
        }

        public final okhttp3.RequestBody create(File file, okhttp3.MediaType mediaType2) {
            n.f(file, "$this$asRequestBody");
            RequestBody.Companion.asRequestBody.1 anon = new RequestBody.Companion.asRequestBody.1(file, mediaType2);
            return anon;
        }

        public final okhttp3.RequestBody create(String string, okhttp3.MediaType mediaType2) {
            java.nio.charset.Charset charset;
            Object charset$default;
            int stringBuilder;
            okhttp3.MediaType obj5;
            n.f(string, "$this$toRequestBody");
            charset = d.a;
            if (mediaType2 != null) {
                stringBuilder = 0;
                charset$default = MediaType.charset$default(mediaType2, stringBuilder, 1, stringBuilder);
                if (charset$default == null) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(mediaType2);
                    stringBuilder.append("; charset=utf-8");
                    obj5 = MediaType.Companion.parse(stringBuilder.toString());
                } else {
                    charset = charset$default;
                }
            }
            byte[] obj4 = string.getBytes(charset);
            n.e(obj4, "(this as java.lang.String).getBytes(charset)");
            return create(obj4, obj5, 0, obj4.length);
        }

        public final okhttp3.RequestBody create(i i, okhttp3.MediaType mediaType2) {
            n.f(i, "$this$toRequestBody");
            RequestBody.Companion.toRequestBody.1 anon = new RequestBody.Companion.toRequestBody.1(i, mediaType2);
            return anon;
        }

        public final okhttp3.RequestBody create(okhttp3.MediaType mediaType, File file2) {
            n.f(file2, "file");
            return create(file2, mediaType);
        }

        public final okhttp3.RequestBody create(okhttp3.MediaType mediaType, String string2) {
            n.f(string2, "content");
            return create(string2, mediaType);
        }

        public final okhttp3.RequestBody create(okhttp3.MediaType mediaType, i i2) {
            n.f(i2, "content");
            return create(i2, mediaType);
        }

        public final okhttp3.RequestBody create(okhttp3.MediaType mediaType, byte[] b2Arr2) {
            return RequestBody.Companion.create$default(this, mediaType, b2Arr2, 0, 0, 12, 0);
        }

        public final okhttp3.RequestBody create(okhttp3.MediaType mediaType, byte[] b2Arr2, int i3) {
            return RequestBody.Companion.create$default(this, mediaType, b2Arr2, i3, 0, 8, 0);
        }

        public final okhttp3.RequestBody create(okhttp3.MediaType mediaType, byte[] b2Arr2, int i3, int i4) {
            n.f(b2Arr2, "content");
            return create(b2Arr2, mediaType, i3, i4);
        }

        public final okhttp3.RequestBody create(byte[] bArr) {
            return RequestBody.Companion.create$default(this, bArr, 0, 0, 0, 7, 0);
        }

        public final okhttp3.RequestBody create(byte[] bArr, okhttp3.MediaType mediaType2) {
            return RequestBody.Companion.create$default(this, bArr, mediaType2, 0, 0, 6, 0);
        }

        public final okhttp3.RequestBody create(byte[] bArr, okhttp3.MediaType mediaType2, int i3) {
            return RequestBody.Companion.create$default(this, bArr, mediaType2, i3, 0, 4, 0);
        }

        public final okhttp3.RequestBody create(byte[] bArr, okhttp3.MediaType mediaType2, int i3, int i4) {
            n.f(bArr, "$this$toRequestBody");
            Util.checkOffsetAndCount((long)length, obj2, (long)i3);
            RequestBody.Companion.toRequestBody.2 anon = new RequestBody.Companion.toRequestBody.2(bArr, mediaType2, i4, i3);
            return anon;
        }
    }
    static {
        RequestBody.Companion companion = new RequestBody.Companion(0);
        RequestBody.Companion = companion;
    }

    public static final okhttp3.RequestBody create(File file, okhttp3.MediaType mediaType2) {
        return RequestBody.Companion.create(file, mediaType2);
    }

    public static final okhttp3.RequestBody create(String string, okhttp3.MediaType mediaType2) {
        return RequestBody.Companion.create(string, mediaType2);
    }

    public static final okhttp3.RequestBody create(i i, okhttp3.MediaType mediaType2) {
        return RequestBody.Companion.create(i, mediaType2);
    }

    public static final okhttp3.RequestBody create(okhttp3.MediaType mediaType, File file2) {
        return RequestBody.Companion.create(mediaType, file2);
    }

    public static final okhttp3.RequestBody create(okhttp3.MediaType mediaType, String string2) {
        return RequestBody.Companion.create(mediaType, string2);
    }

    public static final okhttp3.RequestBody create(okhttp3.MediaType mediaType, i i2) {
        return RequestBody.Companion.create(mediaType, i2);
    }

    public static final okhttp3.RequestBody create(okhttp3.MediaType mediaType, byte[] b2Arr2) {
        return RequestBody.Companion.create$default(RequestBody.Companion, mediaType, b2Arr2, 0, 0, 12, 0);
    }

    public static final okhttp3.RequestBody create(okhttp3.MediaType mediaType, byte[] b2Arr2, int i3) {
        return RequestBody.Companion.create$default(RequestBody.Companion, mediaType, b2Arr2, i3, 0, 8, 0);
    }

    public static final okhttp3.RequestBody create(okhttp3.MediaType mediaType, byte[] b2Arr2, int i3, int i4) {
        return RequestBody.Companion.create(mediaType, b2Arr2, i3, i4);
    }

    public static final okhttp3.RequestBody create(byte[] bArr) {
        return RequestBody.Companion.create$default(RequestBody.Companion, bArr, 0, 0, 0, 7, 0);
    }

    public static final okhttp3.RequestBody create(byte[] bArr, okhttp3.MediaType mediaType2) {
        return RequestBody.Companion.create$default(RequestBody.Companion, bArr, mediaType2, 0, 0, 6, 0);
    }

    public static final okhttp3.RequestBody create(byte[] bArr, okhttp3.MediaType mediaType2, int i3) {
        return RequestBody.Companion.create$default(RequestBody.Companion, bArr, mediaType2, i3, 0, 4, 0);
    }

    public static final okhttp3.RequestBody create(byte[] bArr, okhttp3.MediaType mediaType2, int i3, int i4) {
        return RequestBody.Companion.create(bArr, mediaType2, i3, i4);
    }

    public long contentLength() {
        return -1;
    }

    public abstract okhttp3.MediaType contentType();

    public boolean isDuplex() {
        return 0;
    }

    public boolean isOneShot() {
        return 0;
    }

    public abstract void writeTo(g g);
}
