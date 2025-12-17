package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.g;
import kotlin.d0.d.l;
import kotlin.d0.d.n;
import kotlin.io.b;
import kotlin.k0.d;
import l.d0;
import l.f;
import l.h;
import l.i;
import okhttp3.internal.Util;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0012\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0008&\u0018\u0000 +2\u00020\u0001:\u0002,+B\u0007¢\u0006\u0004\u0008*\u0010'JB\u0010\t\u001a\u00028\u0000\"\u0008\u0008\u0000\u0010\u0003*\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u00042\u0012\u0010\u0008\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0004H\u0082\u0008¢\u0006\u0004\u0008\t\u0010\nJ\u000f\u0010\u000c\u001a\u00020\u000bH\u0002¢\u0006\u0004\u0008\u000c\u0010\rJ\u0011\u0010\u000f\u001a\u0004\u0018\u00010\u000eH&¢\u0006\u0004\u0008\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\u0008\u0012\u0010\u0013J\r\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\u0008\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0005H&¢\u0006\u0004\u0008\u0017\u0010\u0018J\r\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\u0008\u001a\u0010\u001bJ\r\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\u0008\u001d\u0010\u001eJ\r\u0010 \u001a\u00020\u001f¢\u0006\u0004\u0008 \u0010!J\r\u0010#\u001a\u00020\"¢\u0006\u0004\u0008#\u0010$J\u000f\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\u0008&\u0010'R\u0018\u0010(\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008(\u0010)¨\u0006-", d2 = {"Lokhttp3/ResponseBody;", "Ljava/io/Closeable;", "", "T", "Lkotlin/Function1;", "Ll/h;", "consumer", "", "sizeMapper", "consumeSource", "(Lkotlin/d0/c/l;Lkotlin/d0/c/l;)Ljava/lang/Object;", "Ljava/nio/charset/Charset;", "charset", "()Ljava/nio/charset/Charset;", "Lokhttp3/MediaType;", "contentType", "()Lokhttp3/MediaType;", "", "contentLength", "()J", "Ljava/io/InputStream;", "byteStream", "()Ljava/io/InputStream;", "source", "()Ll/h;", "", "bytes", "()[B", "Ll/i;", "byteString", "()Ll/i;", "Ljava/io/Reader;", "charStream", "()Ljava/io/Reader;", "", "string", "()Ljava/lang/String;", "Lkotlin/w;", "close", "()V", "reader", "Ljava/io/Reader;", "<init>", "Companion", "BomAwareReader", "okhttp"}, k = 1, mv = {1, 4, 0})
public abstract class ResponseBody implements Closeable {

    public static final okhttp3.ResponseBody.Companion Companion;
    private Reader reader;

    @Metadata(bv = {1, 0, 3}, d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0005\u0008\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\u0008\u0017\u0010\u0018J'\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\u0008\u0007\u0010\u0008J\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\u0008\n\u0010\u000bR\u0018\u0010\u000c\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\u000c\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\u0015\u0010\u0016¨\u0006\u0019", d2 = {"Lokhttp3/ResponseBody$BomAwareReader;", "Ljava/io/Reader;", "", "cbuf", "", "off", "len", "read", "([CII)I", "Lkotlin/w;", "close", "()V", "delegate", "Ljava/io/Reader;", "Ljava/nio/charset/Charset;", "charset", "Ljava/nio/charset/Charset;", "Ll/h;", "source", "Ll/h;", "", "closed", "Z", "<init>", "(Ll/h;Ljava/nio/charset/Charset;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class BomAwareReader extends Reader {

        private final Charset charset;
        private boolean closed;
        private Reader delegate;
        private final h source;
        public BomAwareReader(h h, Charset charset2) {
            n.f(h, "source");
            n.f(charset2, "charset");
            super();
            this.source = h;
            this.charset = charset2;
        }

        @Override // java.io.Reader
        public void close() {
            Object delegate;
            this.closed = true;
            delegate = this.delegate;
            if (delegate != null) {
                delegate.close();
            } else {
                this.source.close();
            }
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i2, int i3) {
            Object inputStreamReader;
            InputStream inputStream;
            Charset bomAsCharset;
            Charset charset;
            n.f(cArr, "cbuf");
            if (this.closed) {
            } else {
                if (this.delegate != null) {
                } else {
                    inputStreamReader = new InputStreamReader(this.source.g2(), Util.readBomAsCharset(this.source, this.charset));
                    this.delegate = inputStreamReader;
                }
                return inputStreamReader.read(cArr, i2, i3);
            }
            IOException obj5 = new IOException("Stream closed");
            throw obj5;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0008\u000b\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0017\u0010\u0018J\u001f\u0010\u0008\u001a\u00020\u0005*\u00020\u00022\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\u0008\u0006\u0010\u0007J\u001f\u0010\u0008\u001a\u00020\u0005*\u00020\t2\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\u0008\u0006\u0010\nJ\u001f\u0010\u0008\u001a\u00020\u0005*\u00020\u000b2\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\u0008\u0006\u0010\u000cJ)\u0010\u0011\u001a\u00020\u0005*\u00020\r2\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\u0008\u0006\u0010\u0010J!\u0010\u0006\u001a\u00020\u00052\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0012\u001a\u00020\u0002H\u0007¢\u0006\u0004\u0008\u0006\u0010\u0013J!\u0010\u0006\u001a\u00020\u00052\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0012\u001a\u00020\tH\u0007¢\u0006\u0004\u0008\u0006\u0010\u0014J!\u0010\u0006\u001a\u00020\u00052\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0012\u001a\u00020\u000bH\u0007¢\u0006\u0004\u0008\u0006\u0010\u0015J)\u0010\u0006\u001a\u00020\u00052\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\rH\u0007¢\u0006\u0004\u0008\u0006\u0010\u0016¨\u0006\u0019", d2 = {"Lokhttp3/ResponseBody$Companion;", "", "", "Lokhttp3/MediaType;", "contentType", "Lokhttp3/ResponseBody;", "create", "(Ljava/lang/String;Lokhttp3/MediaType;)Lokhttp3/ResponseBody;", "toResponseBody", "", "([BLokhttp3/MediaType;)Lokhttp3/ResponseBody;", "Ll/i;", "(Ll/i;Lokhttp3/MediaType;)Lokhttp3/ResponseBody;", "Ll/h;", "", "contentLength", "(Ll/h;Lokhttp3/MediaType;J)Lokhttp3/ResponseBody;", "asResponseBody", "content", "(Lokhttp3/MediaType;Ljava/lang/String;)Lokhttp3/ResponseBody;", "(Lokhttp3/MediaType;[B)Lokhttp3/ResponseBody;", "(Lokhttp3/MediaType;Ll/i;)Lokhttp3/ResponseBody;", "(Lokhttp3/MediaType;JLl/h;)Lokhttp3/ResponseBody;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion(g g) {
            super();
        }

        public static okhttp3.ResponseBody create$default(okhttp3.ResponseBody.Companion responseBody$Companion, String string2, okhttp3.MediaType mediaType3, int i4, Object object5) {
            int obj2;
            if (i4 &= 1 != 0) {
                obj2 = 0;
            }
            return companion.create(string2, obj2);
        }

        public static okhttp3.ResponseBody create$default(okhttp3.ResponseBody.Companion responseBody$Companion, h h2, okhttp3.MediaType mediaType3, long l4, int i5, Object object6) {
            int obj2;
            int obj3;
            if (object6 & 1 != 0) {
                obj2 = 0;
            }
            if (object6 &= 2 != 0) {
                obj3 = -1;
            }
            return companion.create(h2, obj2, obj3);
        }

        public static okhttp3.ResponseBody create$default(okhttp3.ResponseBody.Companion responseBody$Companion, i i2, okhttp3.MediaType mediaType3, int i4, Object object5) {
            int obj2;
            if (i4 &= 1 != 0) {
                obj2 = 0;
            }
            return companion.create(i2, obj2);
        }

        public static okhttp3.ResponseBody create$default(okhttp3.ResponseBody.Companion responseBody$Companion, byte[] b2Arr2, okhttp3.MediaType mediaType3, int i4, Object object5) {
            int obj2;
            if (i4 &= 1 != 0) {
                obj2 = 0;
            }
            return companion.create(b2Arr2, obj2);
        }

        public final okhttp3.ResponseBody create(String string, okhttp3.MediaType mediaType2) {
            Charset charset;
            Object charset$default;
            int stringBuilder;
            okhttp3.MediaType obj6;
            n.f(string, "$this$toResponseBody");
            charset = d.a;
            if (mediaType2 != null) {
                stringBuilder = 0;
                charset$default = MediaType.charset$default(mediaType2, stringBuilder, 1, stringBuilder);
                if (charset$default == null) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(mediaType2);
                    stringBuilder.append("; charset=utf-8");
                    obj6 = MediaType.Companion.parse(stringBuilder.toString());
                } else {
                    charset = charset$default;
                }
            }
            f fVar = new f();
            fVar.V0(string, charset);
            return create(fVar, obj6, fVar.size());
        }

        public final okhttp3.ResponseBody create(h h, okhttp3.MediaType mediaType2, long l3) {
            n.f(h, "$this$asResponseBody");
            ResponseBody.Companion.asResponseBody.1 anon = new ResponseBody.Companion.asResponseBody.1(h, mediaType2, l3, obj5);
            return anon;
        }

        public final okhttp3.ResponseBody create(i i, okhttp3.MediaType mediaType2) {
            n.f(i, "$this$toResponseBody");
            f fVar = new f();
            fVar.e0(i);
            return create(fVar, mediaType2, (long)obj4);
        }

        public final okhttp3.ResponseBody create(okhttp3.MediaType mediaType, long l2, h h3) {
            n.f(obj5, "content");
            return create(obj5, mediaType, l2);
        }

        public final okhttp3.ResponseBody create(okhttp3.MediaType mediaType, String string2) {
            n.f(string2, "content");
            return create(string2, mediaType);
        }

        public final okhttp3.ResponseBody create(okhttp3.MediaType mediaType, i i2) {
            n.f(i2, "content");
            return create(i2, mediaType);
        }

        public final okhttp3.ResponseBody create(okhttp3.MediaType mediaType, byte[] b2Arr2) {
            n.f(b2Arr2, "content");
            return create(b2Arr2, mediaType);
        }

        public final okhttp3.ResponseBody create(byte[] bArr, okhttp3.MediaType mediaType2) {
            n.f(bArr, "$this$toResponseBody");
            f fVar = new f();
            fVar.m0(bArr);
            return create(fVar, mediaType2, (long)obj4);
        }
    }
    static {
        ResponseBody.Companion companion = new ResponseBody.Companion(0);
        ResponseBody.Companion = companion;
    }

    private final Charset charset() {
        Object contentType;
        Charset charset;
        contentType = contentType();
        if (contentType != null && contentType.charset(d.a) != null) {
            if (contentType.charset(d.a) != null) {
            } else {
                contentType = d.a;
            }
        } else {
        }
        return contentType;
    }

    private final <T> T consumeSource(l<? super h, ? extends T> l, l<? super T, Integer> l2) {
        int cmp;
        long contentLength = contentLength();
        if (Long.compare(contentLength, l3) > 0) {
        } else {
            h source = source();
            final int i4 = 1;
            Object obj6 = l.invoke(source);
            l.b(i4);
            b.a(source, 0);
            l.a(i4);
            int obj7 = (Number)l2.invoke(obj6).intValue();
            if (Long.compare(contentLength, i2) != 0) {
                if (Long.compare(contentLength, l4) != 0) {
                } else {
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Content-Length (");
                stringBuilder.append(contentLength);
                stringBuilder.append(") and stream length (");
                stringBuilder.append(obj7);
                stringBuilder.append(") disagree");
                obj6 = new IOException(stringBuilder.toString());
                throw obj6;
            }
            return obj6;
        }
        obj7 = new StringBuilder();
        obj7.append("Cannot buffer entire body for content length: ");
        obj7.append(contentLength);
        obj6 = new IOException(obj7.toString());
        throw obj6;
    }

    public static final okhttp3.ResponseBody create(String string, okhttp3.MediaType mediaType2) {
        return ResponseBody.Companion.create(string, mediaType2);
    }

    public static final okhttp3.ResponseBody create(h h, okhttp3.MediaType mediaType2, long l3) {
        return ResponseBody.Companion.create(h, mediaType2, l3);
    }

    public static final okhttp3.ResponseBody create(i i, okhttp3.MediaType mediaType2) {
        return ResponseBody.Companion.create(i, mediaType2);
    }

    public static final okhttp3.ResponseBody create(okhttp3.MediaType mediaType, long l2, h h3) {
        return ResponseBody.Companion.create(mediaType, l2, h3);
    }

    public static final okhttp3.ResponseBody create(okhttp3.MediaType mediaType, String string2) {
        return ResponseBody.Companion.create(mediaType, string2);
    }

    public static final okhttp3.ResponseBody create(okhttp3.MediaType mediaType, i i2) {
        return ResponseBody.Companion.create(mediaType, i2);
    }

    public static final okhttp3.ResponseBody create(okhttp3.MediaType mediaType, byte[] b2Arr2) {
        return ResponseBody.Companion.create(mediaType, b2Arr2);
    }

    public static final okhttp3.ResponseBody create(byte[] bArr, okhttp3.MediaType mediaType2) {
        return ResponseBody.Companion.create(bArr, mediaType2);
    }

    @Override // java.io.Closeable
    public final InputStream byteStream() {
        return source().g2();
    }

    @Override // java.io.Closeable
    public final i byteString() {
        int cmp;
        int i;
        long contentLength = contentLength();
        if (Long.compare(contentLength, l) > 0) {
        } else {
            h source = source();
            i iVar = source.Y0();
            b.a(source, 0);
            int i3 = iVar.A();
            if (Long.compare(contentLength, i) != 0) {
                if (Long.compare(contentLength, i) != 0) {
                } else {
                }
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Content-Length (");
                stringBuilder2.append(contentLength);
                stringBuilder2.append(") and stream length (");
                stringBuilder2.append(i3);
                stringBuilder2.append(") disagree");
                IOException iOException2 = new IOException(stringBuilder2.toString());
                throw iOException2;
            }
            return iVar;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot buffer entire body for content length: ");
        stringBuilder.append(contentLength);
        IOException iOException = new IOException(stringBuilder.toString());
        throw iOException;
    }

    @Override // java.io.Closeable
    public final byte[] bytes() {
        int cmp;
        int i;
        long contentLength = contentLength();
        if (Long.compare(contentLength, l) > 0) {
        } else {
            h source = source();
            byte[] bArr = source.X();
            b.a(source, 0);
            int length = bArr.length;
            if (Long.compare(contentLength, i) != 0) {
                if (Long.compare(contentLength, i) != 0) {
                } else {
                }
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Content-Length (");
                stringBuilder2.append(contentLength);
                stringBuilder2.append(") and stream length (");
                stringBuilder2.append(length);
                stringBuilder2.append(") disagree");
                IOException iOException2 = new IOException(stringBuilder2.toString());
                throw iOException2;
            }
            return bArr;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot buffer entire body for content length: ");
        stringBuilder.append(contentLength);
        IOException iOException = new IOException(stringBuilder.toString());
        throw iOException;
    }

    @Override // java.io.Closeable
    public final Reader charStream() {
        Reader bomAwareReader;
        h source;
        Charset charset;
        if (this.reader != null) {
        } else {
            bomAwareReader = new ResponseBody.BomAwareReader(source(), charset());
            this.reader = bomAwareReader;
        }
        return bomAwareReader;
    }

    @Override // java.io.Closeable
    public void close() {
        Util.closeQuietly(source());
    }

    @Override // java.io.Closeable
    public abstract long contentLength();

    @Override // java.io.Closeable
    public abstract okhttp3.MediaType contentType();

    @Override // java.io.Closeable
    public abstract h source();

    @Override // java.io.Closeable
    public final String string() {
        final h source = source();
        b.a(source, 0);
        return source.M0(Util.readBomAsCharset(source, charset()));
    }
}
