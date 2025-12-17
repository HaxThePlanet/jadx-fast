package okhttp3;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import l.f;
import l.g;
import okhttp3.internal.Util;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0008\u0008\u0018\u0000 \"2\u00020\u0001:\u0002#\"B%\u0008\u0000\u0012\u000c\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\u001c\u0012\u000c\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\u001c¢\u0006\u0004\u0008 \u0010!J!\u0010\u0007\u001a\u00020\u00062\u0008\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\u0008\u0007\u0010\u0008J\u000f\u0010\u000c\u001a\u00020\tH\u0007¢\u0006\u0004\u0008\n\u0010\u000bJ\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\t¢\u0006\u0004\u0008\u000f\u0010\u0010J\u0015\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\t¢\u0006\u0004\u0008\u0011\u0010\u0010J\u0015\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\t¢\u0006\u0004\u0008\u0012\u0010\u0010J\u0015\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\t¢\u0006\u0004\u0008\u0013\u0010\u0010J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\u0008\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0006H\u0016¢\u0006\u0004\u0008\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\u0008\u001a\u0010\u001bR\u001c\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\u001c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u001d\u0010\u001eR\u0013\u0010\u000c\u001a\u00020\t8G@\u0006¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\u000bR\u001c\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\u001c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u001f\u0010\u001e¨\u0006$", d2 = {"Lokhttp3/FormBody;", "Lokhttp3/RequestBody;", "Ll/g;", "sink", "", "countBytes", "", "writeOrCountBytes", "(Ll/g;Z)J", "", "-deprecated_size", "()I", "size", "index", "", "encodedName", "(I)Ljava/lang/String;", "name", "encodedValue", "value", "Lokhttp3/MediaType;", "contentType", "()Lokhttp3/MediaType;", "contentLength", "()J", "Lkotlin/w;", "writeTo", "(Ll/g;)V", "", "encodedValues", "Ljava/util/List;", "encodedNames", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "Companion", "Builder", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class FormBody extends okhttp3.RequestBody {

    private static final okhttp3.MediaType CONTENT_TYPE;
    public static final okhttp3.FormBody.Companion Companion;
    private final List<String> encodedNames;
    private final List<String> encodedValues;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010!\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0018\u00002\u00020\u0001B\u0015\u0008\u0007\u0012\n\u0008\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\u0008\u0012\u0010\u0013J\u001d\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\u0008\u0005\u0010\u0006J\u001d\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\u0008\u0007\u0010\u0006J\r\u0010\t\u001a\u00020\u0008¢\u0006\u0004\u0008\t\u0010\nR\u001c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u000c\u0010\rR\u001c\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u000e\u0010\rR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0010\u0010\u0011¨\u0006\u0014", d2 = {"Lokhttp3/FormBody$Builder;", "", "", "name", "value", "add", "(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/FormBody$Builder;", "addEncoded", "Lokhttp3/FormBody;", "build", "()Lokhttp3/FormBody;", "", "values", "Ljava/util/List;", "names", "Ljava/nio/charset/Charset;", "charset", "Ljava/nio/charset/Charset;", "<init>", "(Ljava/nio/charset/Charset;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Builder {

        private final Charset charset;
        private final List<String> names;
        private final List<String> values;
        public Builder() {
            final int i = 0;
            super(i, 1, i);
        }

        public Builder(Charset charset) {
            super();
            this.charset = charset;
            ArrayList obj1 = new ArrayList();
            this.names = obj1;
            obj1 = new ArrayList();
            this.values = obj1;
        }

        public Builder(Charset charset, int i2, g g3) {
            int obj1;
            obj1 = i2 &= 1 != 0 ? 0 : obj1;
            super(obj1);
        }

        public final okhttp3.FormBody.Builder add(String string, String string2) {
            final Object obj = this;
            Object obj2 = string;
            n.f(obj2, "name");
            n.f(string2, "value");
            final okhttp3.HttpUrl.Companion companion3 = HttpUrl.Companion;
            final int i = 0;
            final int i2 = 0;
            final int i3 = 0;
            final int i4 = 0;
            final int i5 = 1;
            final int i6 = 0;
            final int i7 = 91;
            final int i8 = 0;
            obj.names.add(HttpUrl.Companion.canonicalize$okhttp$default(companion3, obj2, i, i2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", i3, i4, i5, i6, obj.charset, i7, i8));
            obj.values.add(HttpUrl.Companion.canonicalize$okhttp$default(companion3, string2, i, i2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", i3, i4, i5, i6, obj.charset, i7, i8));
            return obj;
        }

        public final okhttp3.FormBody.Builder addEncoded(String string, String string2) {
            final Object obj = this;
            Object obj2 = string;
            n.f(obj2, "name");
            n.f(string2, "value");
            final okhttp3.HttpUrl.Companion companion3 = HttpUrl.Companion;
            final int i = 0;
            final int i2 = 0;
            final int i3 = 1;
            final int i4 = 0;
            final int i5 = 1;
            final int i6 = 0;
            final int i7 = 83;
            final int i8 = 0;
            obj.names.add(HttpUrl.Companion.canonicalize$okhttp$default(companion3, obj2, i, i2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", i3, i4, i5, i6, obj.charset, i7, i8));
            obj.values.add(HttpUrl.Companion.canonicalize$okhttp$default(companion3, string2, i, i2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", i3, i4, i5, i6, obj.charset, i7, i8));
            return obj;
        }

        public final okhttp3.FormBody build() {
            FormBody formBody = new FormBody(this.names, this.values);
            return formBody;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0003\u0010\u0004¨\u0006\u0007", d2 = {"Lokhttp3/FormBody$Companion;", "", "Lokhttp3/MediaType;", "CONTENT_TYPE", "Lokhttp3/MediaType;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion(g g) {
            super();
        }
    }
    static {
        FormBody.Companion companion = new FormBody.Companion(0);
        FormBody.Companion = companion;
        FormBody.CONTENT_TYPE = MediaType.Companion.get("application/x-www-form-urlencoded");
    }

    public FormBody(List<String> list, List<String> list2) {
        n.f(list, "encodedNames");
        n.f(list2, "encodedValues");
        super();
        this.encodedNames = Util.toImmutableList(list);
        this.encodedValues = Util.toImmutableList(list2);
    }

    private final long writeOrCountBytes(g g, boolean z2) {
        int i;
        int size;
        Object obj;
        f obj4;
        if (z2) {
            obj4 = new f();
        } else {
            n.d(g);
            obj4 = g.h();
        }
        i = 0;
        while (i < this.encodedNames.size()) {
            if (i > 0) {
            }
            obj4.b1((String)this.encodedNames.get(i));
            obj4.z0(61);
            obj4.b1((String)this.encodedValues.get(i));
            i++;
            obj4.z0(38);
        }
        if (z2) {
            size = obj4.size();
            obj4.a();
        } else {
            size = 0;
        }
        return size;
    }

    @Override // okhttp3.RequestBody
    public final int -deprecated_size() {
        return size();
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        return writeOrCountBytes(0, true);
    }

    @Override // okhttp3.RequestBody
    public okhttp3.MediaType contentType() {
        return FormBody.CONTENT_TYPE;
    }

    @Override // okhttp3.RequestBody
    public final String encodedName(int i) {
        return (String)this.encodedNames.get(i);
    }

    @Override // okhttp3.RequestBody
    public final String encodedValue(int i) {
        return (String)this.encodedValues.get(i);
    }

    @Override // okhttp3.RequestBody
    public final String name(int i) {
        return HttpUrl.Companion.percentDecode$okhttp$default(HttpUrl.Companion, encodedName(i), 0, 0, true, 3, 0);
    }

    @Override // okhttp3.RequestBody
    public final int size() {
        return this.encodedNames.size();
    }

    @Override // okhttp3.RequestBody
    public final String value(int i) {
        return HttpUrl.Companion.percentDecode$okhttp$default(HttpUrl.Companion, encodedValue(i), 0, 0, true, 3, 0);
    }

    @Override // okhttp3.RequestBody
    public void writeTo(g g) {
        n.f(g, "sink");
        writeOrCountBytes(g, false);
    }
}
