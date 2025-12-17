package okhttp3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import l.f;
import l.g;
import l.i;
import l.i.a;
import okhttp3.internal.Util;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0010 \n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\n\u0018\u0000 +2\u00020\u0001:\u0003,+-B'\u0008\u0000\u0012\u0006\u0010%\u001a\u00020$\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u0012\u000c\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\u001a¢\u0006\u0004\u0008)\u0010*J!\u0010\u0007\u001a\u00020\u00062\u0008\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\u0008\u0007\u0010\u0008J\u0015\u0010\u000c\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\u0008\u000c\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\u0008\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u000eH\u0007¢\u0006\u0004\u0008\u0011\u0010\u0010J\u000f\u0010\u0016\u001a\u00020\u0013H\u0007¢\u0006\u0004\u0008\u0014\u0010\u0015J\u000f\u0010\u0019\u001a\u00020\tH\u0007¢\u0006\u0004\u0008\u0017\u0010\u0018J\u0015\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\u001aH\u0007¢\u0006\u0004\u0008\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u0006H\u0016¢\u0006\u0004\u0008\u001e\u0010\u001fJ\u0017\u0010!\u001a\u00020 2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\u0008!\u0010\"R\u0019\u0010\u0012\u001a\u00020\u000e8\u0007@\u0006¢\u0006\u000c\n\u0004\u0008\u0012\u0010#\u001a\u0004\u0008\u0012\u0010\u0010R\u0016\u0010%\u001a\u00020$8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008%\u0010&R\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u000f\u0010#R\u001f\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\u001a8\u0007@\u0006¢\u0006\u000c\n\u0004\u0008\u001d\u0010'\u001a\u0004\u0008\u001d\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\u001e\u0010(R\u0013\u0010\u0019\u001a\u00020\t8G@\u0006¢\u0006\u0006\u001a\u0004\u0008\u0019\u0010\u0018R\u0013\u0010\u0016\u001a\u00020\u00138G@\u0006¢\u0006\u0006\u001a\u0004\u0008\u0016\u0010\u0015¨\u0006.", d2 = {"Lokhttp3/MultipartBody;", "Lokhttp3/RequestBody;", "Ll/g;", "sink", "", "countBytes", "", "writeOrCountBytes", "(Ll/g;Z)J", "", "index", "Lokhttp3/MultipartBody$Part;", "part", "(I)Lokhttp3/MultipartBody$Part;", "Lokhttp3/MediaType;", "contentType", "()Lokhttp3/MediaType;", "-deprecated_type", "type", "", "-deprecated_boundary", "()Ljava/lang/String;", "boundary", "-deprecated_size", "()I", "size", "", "-deprecated_parts", "()Ljava/util/List;", "parts", "contentLength", "()J", "Lkotlin/w;", "writeTo", "(Ll/g;)V", "Lokhttp3/MediaType;", "Ll/i;", "boundaryByteString", "Ll/i;", "Ljava/util/List;", "J", "<init>", "(Ll/i;Lokhttp3/MediaType;Ljava/util/List;)V", "Companion", "Builder", "Part", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class MultipartBody extends okhttp3.RequestBody {

    public static final okhttp3.MediaType ALTERNATIVE;
    private static final byte[] COLONSPACE;
    private static final byte[] CRLF;
    public static final okhttp3.MultipartBody.Companion Companion;
    private static final byte[] DASHDASH;
    public static final okhttp3.MediaType DIGEST;
    public static final okhttp3.MediaType FORM;
    public static final okhttp3.MediaType MIXED;
    public static final okhttp3.MediaType PARALLEL;
    private final i boundaryByteString;
    private long contentLength = -1;
    private final okhttp3.MediaType contentType;
    private final List<okhttp3.MultipartBody.Part> parts;
    private final okhttp3.MediaType type;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010!\n\u0002\u0008\u0005\u0018\u00002\u00020\u0001B\u0013\u0008\u0007\u0012\u0008\u0008\u0002\u0010\u001c\u001a\u00020\r¢\u0006\u0004\u0008!\u0010\"J\u0015\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\u0008\u0004\u0010\u0005J\u0015\u0010\u0008\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\u0008\u0008\u0010\tJ\u001f\u0010\u0008\u001a\u00020\u00002\u0008\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\u0008\u0008\u0010\u000cJ\u001d\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r¢\u0006\u0004\u0008\u0010\u0010\u0011J'\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0008\u0010\u0012\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\u0008\u0010\u0010\u0013J\u0015\u0010\u0008\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\u0008\u0008\u0010\u0016J\r\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\u0008\u0018\u0010\u0019R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\u0003\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u001c\u0010\u001dR\u001c\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u00020\u00140\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u001f\u0010 ¨\u0006#", d2 = {"Lokhttp3/MultipartBody$Builder;", "", "Lokhttp3/MediaType;", "type", "setType", "(Lokhttp3/MediaType;)Lokhttp3/MultipartBody$Builder;", "Lokhttp3/RequestBody;", "body", "addPart", "(Lokhttp3/RequestBody;)Lokhttp3/MultipartBody$Builder;", "Lokhttp3/Headers;", "headers", "(Lokhttp3/Headers;Lokhttp3/RequestBody;)Lokhttp3/MultipartBody$Builder;", "", "name", "value", "addFormDataPart", "(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/MultipartBody$Builder;", "filename", "(Ljava/lang/String;Ljava/lang/String;Lokhttp3/RequestBody;)Lokhttp3/MultipartBody$Builder;", "Lokhttp3/MultipartBody$Part;", "part", "(Lokhttp3/MultipartBody$Part;)Lokhttp3/MultipartBody$Builder;", "Lokhttp3/MultipartBody;", "build", "()Lokhttp3/MultipartBody;", "Lokhttp3/MediaType;", "Ll/i;", "boundary", "Ll/i;", "", "parts", "Ljava/util/List;", "<init>", "(Ljava/lang/String;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Builder {

        private final i boundary;
        private final List<okhttp3.MultipartBody.Part> parts;
        private okhttp3.MediaType type;
        public Builder() {
            final int i = 0;
            super(i, 1, i);
        }

        public Builder(String string) {
            n.f(string, "boundary");
            super();
            this.boundary = i.v.d(string);
            this.type = MultipartBody.MIXED;
            ArrayList obj2 = new ArrayList();
            this.parts = obj2;
        }

        public Builder(String string, int i2, g g3) {
            String obj1;
            int obj2;
            if (i2 &= 1 != 0) {
                n.e(UUID.randomUUID().toString(), "UUID.randomUUID().toString()");
            }
            super(obj1);
        }

        public final okhttp3.MultipartBody.Builder addFormDataPart(String string, String string2) {
            n.f(string, "name");
            n.f(string2, "value");
            addPart(MultipartBody.Part.Companion.createFormData(string, string2));
            return this;
        }

        public final okhttp3.MultipartBody.Builder addFormDataPart(String string, String string2, okhttp3.RequestBody requestBody3) {
            n.f(string, "name");
            n.f(requestBody3, "body");
            addPart(MultipartBody.Part.Companion.createFormData(string, string2, requestBody3));
            return this;
        }

        public final okhttp3.MultipartBody.Builder addPart(okhttp3.Headers headers, okhttp3.RequestBody requestBody2) {
            n.f(requestBody2, "body");
            addPart(MultipartBody.Part.Companion.create(headers, requestBody2));
            return this;
        }

        public final okhttp3.MultipartBody.Builder addPart(okhttp3.MultipartBody.Part multipartBody$Part) {
            n.f(part, "part");
            this.parts.add(part);
            return this;
        }

        public final okhttp3.MultipartBody.Builder addPart(okhttp3.RequestBody requestBody) {
            n.f(requestBody, "body");
            addPart(MultipartBody.Part.Companion.create(requestBody));
            return this;
        }

        public final okhttp3.MultipartBody build() {
            if (empty ^= 1 == 0) {
            } else {
                MultipartBody multipartBody = new MultipartBody(this.boundary, this.type, Util.toImmutableList(this.parts));
                return multipartBody;
            }
            IllegalStateException illegalStateException = new IllegalStateException("Multipart body must have at least one part.".toString());
            throw illegalStateException;
        }

        public final okhttp3.MultipartBody.Builder setType(okhttp3.MediaType mediaType) {
            n.f(mediaType, "type");
            if (!n.b(mediaType.type(), "multipart")) {
            } else {
                this.type = mediaType;
                return this;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("multipart != ");
            stringBuilder.append(mediaType);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString().toString());
            throw illegalArgumentException;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0012\n\u0002\u0008\u000b\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0016\u0010\u0017J\u001f\u0010\t\u001a\u00020\u0006*\u00060\u0002j\u0002`\u00032\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\u0008\u0007\u0010\u0008R\u0016\u0010\u000b\u001a\u00020\n8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008\u000b\u0010\u000cR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0010\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0011\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\n8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008\u0012\u0010\u000cR\u0016\u0010\u0013\u001a\u00020\n8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008\u0013\u0010\u000cR\u0016\u0010\u0014\u001a\u00020\n8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008\u0014\u0010\u000cR\u0016\u0010\u0015\u001a\u00020\n8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008\u0015\u0010\u000c¨\u0006\u0018", d2 = {"Lokhttp3/MultipartBody$Companion;", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "", "key", "Lkotlin/w;", "appendQuotedString$okhttp", "(Ljava/lang/StringBuilder;Ljava/lang/String;)V", "appendQuotedString", "Lokhttp3/MediaType;", "ALTERNATIVE", "Lokhttp3/MediaType;", "", "COLONSPACE", "[B", "CRLF", "DASHDASH", "DIGEST", "FORM", "MIXED", "PARALLEL", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion(g g) {
            super();
        }

        public final void appendQuotedString$okhttp(StringBuilder stringBuilder, String string2) {
            int i2;
            String charAt;
            int i;
            n.f(stringBuilder, "$this$appendQuotedString");
            n.f(string2, "key");
            int i3 = 34;
            stringBuilder.append(i3);
            i2 = 0;
            while (i2 < string2.length()) {
                charAt = string2.charAt(i2);
                if (charAt != 10) {
                } else {
                }
                stringBuilder.append("%0A");
                i2++;
                if (charAt != 13) {
                } else {
                }
                stringBuilder.append("%0D");
                if (charAt != i3) {
                } else {
                }
                stringBuilder.append("%22");
                stringBuilder.append(charAt);
            }
            stringBuilder.append(i3);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\t\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u001b\u0008\u0002\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\u0008\u000c\u0010\rJ\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\u0008\u0003\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0006H\u0007¢\u0006\u0004\u0008\u0007\u0010\u0008R\u0019\u0010\t\u001a\u00020\u00068\u0007@\u0006¢\u0006\u000c\n\u0004\u0008\t\u0010\n\u001a\u0004\u0008\t\u0010\u0008R\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0007@\u0006¢\u0006\u000c\n\u0004\u0008\u0005\u0010\u000b\u001a\u0004\u0008\u0005\u0010\u0004¨\u0006\u000f", d2 = {"Lokhttp3/MultipartBody$Part;", "", "Lokhttp3/Headers;", "-deprecated_headers", "()Lokhttp3/Headers;", "headers", "Lokhttp3/RequestBody;", "-deprecated_body", "()Lokhttp3/RequestBody;", "body", "Lokhttp3/RequestBody;", "Lokhttp3/Headers;", "<init>", "(Lokhttp3/Headers;Lokhttp3/RequestBody;)V", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Part {

        public static final okhttp3.MultipartBody.Part.Companion Companion;
        private final okhttp3.RequestBody body;
        private final okhttp3.Headers headers;
        static {
            MultipartBody.Part.Companion companion = new MultipartBody.Part.Companion(0);
            MultipartBody.Part.Companion = companion;
        }

        private Part(okhttp3.Headers headers, okhttp3.RequestBody requestBody2) {
            super();
            this.headers = headers;
            this.body = requestBody2;
        }

        public Part(okhttp3.Headers headers, okhttp3.RequestBody requestBody2, g g3) {
            super(headers, requestBody2);
        }

        public static final okhttp3.MultipartBody.Part create(okhttp3.Headers headers, okhttp3.RequestBody requestBody2) {
            return MultipartBody.Part.Companion.create(headers, requestBody2);
        }

        public static final okhttp3.MultipartBody.Part create(okhttp3.RequestBody requestBody) {
            return MultipartBody.Part.Companion.create(requestBody);
        }

        public static final okhttp3.MultipartBody.Part createFormData(String string, String string2) {
            return MultipartBody.Part.Companion.createFormData(string, string2);
        }

        public static final okhttp3.MultipartBody.Part createFormData(String string, String string2, okhttp3.RequestBody requestBody3) {
            return MultipartBody.Part.Companion.createFormData(string, string2, requestBody3);
        }

        public final okhttp3.RequestBody -deprecated_body() {
            return this.body;
        }

        public final okhttp3.Headers -deprecated_headers() {
            return this.headers;
        }

        public final okhttp3.RequestBody body() {
            return this.body;
        }

        public final okhttp3.Headers headers() {
            return this.headers;
        }
    }
    static {
        MultipartBody.Companion companion = new MultipartBody.Companion(0);
        MultipartBody.Companion = companion;
        okhttp3.MediaType.Companion companion2 = MediaType.Companion;
        MultipartBody.MIXED = companion2.get("multipart/mixed");
        MultipartBody.ALTERNATIVE = companion2.get("multipart/alternative");
        MultipartBody.DIGEST = companion2.get("multipart/digest");
        MultipartBody.PARALLEL = companion2.get("multipart/parallel");
        MultipartBody.FORM = companion2.get("multipart/form-data");
        int i = 2;
        byte[] bArr2 = new byte[i];
        final int i8 = 0;
        bArr2[i8] = (byte)i4;
        final int i9 = 1;
        bArr2[i9] = (byte)i5;
        MultipartBody.COLONSPACE = bArr2;
        byte[] bArr3 = new byte[i];
        bArr3[i8] = (byte)i6;
        bArr3[i9] = (byte)i7;
        MultipartBody.CRLF = bArr3;
        byte[] bArr = new byte[i];
        byte b = (byte)i3;
        bArr[i8] = b;
        bArr[i9] = b;
        MultipartBody.DASHDASH = bArr;
    }

    public MultipartBody(i i, okhttp3.MediaType mediaType2, List<okhttp3.MultipartBody.Part> list3) {
        n.f(i, "boundaryByteString");
        n.f(mediaType2, "type");
        n.f(list3, "parts");
        super();
        this.boundaryByteString = i;
        this.type = mediaType2;
        this.parts = list3;
        StringBuilder obj4 = new StringBuilder();
        obj4.append(mediaType2);
        obj4.append("; boundary=");
        obj4.append(boundary());
        this.contentType = MediaType.Companion.get(obj4.toString());
        int obj2 = -1;
    }

    private final long writeOrCountBytes(g g, boolean z2) {
        f fVar;
        int i2;
        int i3;
        okhttp3.RequestBody body;
        long contentLength;
        Object contentType;
        byte[] cRLF4;
        byte[] cRLF2;
        g i;
        byte[] cRLF3;
        int cRLF;
        f obj13;
        if (z2) {
            obj13 = new f();
            fVar = obj13;
        } else {
            fVar = 0;
        }
        int i4 = 0;
        i2 = 0;
        i3 = i4;
        while (i3 < this.parts.size()) {
            Object obj = this.parts.get(i3);
            okhttp3.Headers headers = (MultipartBody.Part)obj.headers();
            body = obj.body();
            n.d(obj13);
            obj13.w1(MultipartBody.DASHDASH);
            obj13.y1(this.boundaryByteString);
            obj13.w1(MultipartBody.CRLF);
            if (headers != null) {
            }
            contentType = body.contentType();
            if (contentType != null) {
            }
            contentLength = body.contentLength();
            i = -1;
            cRLF2 = MultipartBody.CRLF;
            obj13.w1(cRLF2);
            if (z2) {
            } else {
            }
            body.writeTo(obj13);
            obj13.w1(cRLF2);
            i3++;
            i2 += contentLength;
            obj13.E0("Content-Length: ").Y1(contentLength).w1(MultipartBody.CRLF);
            obj13.E0("Content-Type: ").E0(contentType.toString()).w1(MultipartBody.CRLF);
            cRLF2 = i4;
            while (cRLF2 < headers.size()) {
                obj13.E0(headers.name(cRLF2)).w1(MultipartBody.COLONSPACE).E0(headers.value(cRLF2)).w1(MultipartBody.CRLF);
                cRLF2++;
            }
            obj13.E0(headers.name(cRLF2)).w1(MultipartBody.COLONSPACE).E0(headers.value(cRLF2)).w1(MultipartBody.CRLF);
            cRLF2++;
        }
        n.d(obj13);
        byte[] dASHDASH = MultipartBody.DASHDASH;
        obj13.w1(dASHDASH);
        obj13.y1(this.boundaryByteString);
        obj13.w1(dASHDASH);
        obj13.w1(MultipartBody.CRLF);
        if (z2) {
            n.d(fVar);
            i2 += obj13;
            fVar.a();
        }
        return i2;
    }

    @Override // okhttp3.RequestBody
    public final String -deprecated_boundary() {
        return boundary();
    }

    public final List<okhttp3.MultipartBody.Part> -deprecated_parts() {
        return this.parts;
    }

    @Override // okhttp3.RequestBody
    public final int -deprecated_size() {
        return size();
    }

    @Override // okhttp3.RequestBody
    public final okhttp3.MediaType -deprecated_type() {
        return this.type;
    }

    @Override // okhttp3.RequestBody
    public final String boundary() {
        return this.boundaryByteString.E();
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        long contentLength;
        int i;
        if (Long.compare(contentLength, i3) == 0) {
            this.contentLength = writeOrCountBytes(0, true);
        }
        return contentLength;
    }

    @Override // okhttp3.RequestBody
    public okhttp3.MediaType contentType() {
        return this.contentType;
    }

    @Override // okhttp3.RequestBody
    public final okhttp3.MultipartBody.Part part(int i) {
        return (MultipartBody.Part)this.parts.get(i);
    }

    public final List<okhttp3.MultipartBody.Part> parts() {
        return this.parts;
    }

    @Override // okhttp3.RequestBody
    public final int size() {
        return this.parts.size();
    }

    @Override // okhttp3.RequestBody
    public final okhttp3.MediaType type() {
        return this.type;
    }

    @Override // okhttp3.RequestBody
    public void writeTo(g g) {
        n.f(g, "sink");
        writeOrCountBytes(g, false);
    }
}
