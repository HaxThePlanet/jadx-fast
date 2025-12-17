package okhttp3;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.h0.d;
import kotlin.h0.g;
import kotlin.k0.l;
import kotlin.y.i;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\n\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0011\n\u0002\u0008\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB/\u0008\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0006\u0012\u0006\u0010\u000c\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u000c\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0018¢\u0006\u0004\u0008\u001c\u0010\u001dJ\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\u0008\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\u0008\u0004\u0010\u0005J\u0017\u0010\u0008\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\u0008\u0008\u0010\tJ\u000f\u0010\u000c\u001a\u00020\u0006H\u0007¢\u0006\u0004\u0008\n\u0010\u000bJ\u000f\u0010\u000e\u001a\u00020\u0006H\u0007¢\u0006\u0004\u0008\r\u0010\u000bJ\u000f\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\u0008\u000f\u0010\u000bJ\u001a\u0010\u0012\u001a\u00020\u00112\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\u0008\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\u0008\u0015\u0010\u0016R\u0019\u0010\u000c\u001a\u00020\u00068\u0007@\u0006¢\u0006\u000c\n\u0004\u0008\u000c\u0010\u0017\u001a\u0004\u0008\u000c\u0010\u000bR\u0019\u0010\u000e\u001a\u00020\u00068\u0007@\u0006¢\u0006\u000c\n\u0004\u0008\u000e\u0010\u0017\u001a\u0004\u0008\u000e\u0010\u000bR\u001c\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u00020\u00068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u001b\u0010\u0017¨\u0006\u001f", d2 = {"Lokhttp3/MediaType;", "", "Ljava/nio/charset/Charset;", "defaultValue", "charset", "(Ljava/nio/charset/Charset;)Ljava/nio/charset/Charset;", "", "name", "parameter", "(Ljava/lang/String;)Ljava/lang/String;", "-deprecated_type", "()Ljava/lang/String;", "type", "-deprecated_subtype", "subtype", "toString", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Ljava/lang/String;", "", "parameterNamesAndValues", "[Ljava/lang/String;", "mediaType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class MediaType {

    public static final okhttp3.MediaType.Companion Companion = null;
    private static final Pattern PARAMETER = null;
    private static final String QUOTED = "\"([^\"]*)\"";
    private static final String TOKEN = "([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)";
    private static final Pattern TYPE_SUBTYPE;
    private final String mediaType;
    private final String[] parameterNamesAndValues;
    private final String subtype;
    private final String type;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\n\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0014\u0010\u0015J\u0013\u0010\u0006\u001a\u00020\u0003*\u00020\u0002H\u0007¢\u0006\u0004\u0008\u0004\u0010\u0005J\u0015\u0010\u0008\u001a\u0004\u0018\u00010\u0003*\u00020\u0002H\u0007¢\u0006\u0004\u0008\u0007\u0010\u0005J\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0007¢\u0006\u0004\u0008\n\u0010\u0005J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0007¢\u0006\u0004\u0008\u000b\u0010\u0005R\u001e\u0010\u000e\u001a\n \r*\u0004\u0018\u00010\u000c0\u000c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\u0008\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\u0008\u0012\u0010\u0011R\u001e\u0010\u0013\u001a\n \r*\u0004\u0018\u00010\u000c0\u000c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0013\u0010\u000f¨\u0006\u0016", d2 = {"Lokhttp3/MediaType$Companion;", "", "", "Lokhttp3/MediaType;", "get", "(Ljava/lang/String;)Lokhttp3/MediaType;", "toMediaType", "parse", "toMediaTypeOrNull", "mediaType", "-deprecated_get", "-deprecated_parse", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "PARAMETER", "Ljava/util/regex/Pattern;", "QUOTED", "Ljava/lang/String;", "TOKEN", "TYPE_SUBTYPE", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion(g g) {
            super();
        }

        public final okhttp3.MediaType -deprecated_get(String string) {
            n.f(string, "mediaType");
            return get(string);
        }

        public final okhttp3.MediaType -deprecated_parse(String string) {
            n.f(string, "mediaType");
            return parse(string);
        }

        public final okhttp3.MediaType get(String string) {
            int i;
            String lookingAt;
            String length;
            String group;
            int i2;
            boolean z;
            n.f(string, "$this$toMediaType");
            Matcher matcher = MediaType.access$getTYPE_SUBTYPE$cp().matcher(string);
            int i4 = 34;
            if (!matcher.lookingAt()) {
            } else {
                int i3 = 1;
                String group3 = matcher.group(i3);
                n.e(group3, "typeSubtype.group(1)");
                Locale uS = Locale.US;
                lookingAt = "Locale.US";
                n.e(uS, lookingAt);
                length = "null cannot be cast to non-null type java.lang.String";
                Objects.requireNonNull(group3, length);
                final String lowerCase = group3.toLowerCase(uS);
                String str5 = "(this as java.lang.String).toLowerCase(locale)";
                n.e(lowerCase, str5);
                int i7 = 2;
                group = matcher.group(i7);
                n.e(group, "typeSubtype.group(2)");
                n.e(uS, lookingAt);
                Objects.requireNonNull(group, length);
                String lowerCase2 = group.toLowerCase(uS);
                n.e(lowerCase2, str5);
                ArrayList arrayList = new ArrayList();
                Matcher matcher2 = MediaType.access$getPARAMETER$cp().matcher(string);
                i = matcher.end();
                length = null;
                while (i < string.length()) {
                    matcher2.region(i, string.length());
                    String group2 = matcher2.group(i3);
                    if (group2 == null) {
                    } else {
                    }
                    lookingAt = matcher2.group(i7);
                    if (lookingAt == null) {
                    } else {
                    }
                    group = "'";
                    i2 = 0;
                    if (l.M(lookingAt, group, length, i7, i2) && l.w(lookingAt, group, length, i7, i2) && lookingAt.length() > i7) {
                    }
                    arrayList.add(group2);
                    arrayList.add(lookingAt);
                    i = matcher2.end();
                    length = null;
                    if (l.w(lookingAt, group, length, i7, i2)) {
                    }
                    if (lookingAt.length() > i7) {
                    }
                    n.e(lookingAt.substring(i3, length4 -= i3), "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    lookingAt = matcher2.group(3);
                    i = matcher2.end();
                }
                Object[] array = arrayList.toArray(new String[length]);
                Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                super(string, lowerCase, lowerCase2, (String[])array, 0);
                return mediaType;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("No subtype found for: \"");
            stringBuilder.append(string);
            stringBuilder.append(i4);
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(stringBuilder.toString().toString());
            throw illegalArgumentException2;
        }

        public final okhttp3.MediaType parse(String string) {
            okhttp3.MediaType obj2;
            n.f(string, "$this$toMediaTypeOrNull");
            obj2 = get(string);
            return obj2;
        }
    }
    static {
        MediaType.Companion companion = new MediaType.Companion(0);
        MediaType.Companion = companion;
        MediaType.TYPE_SUBTYPE = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
        MediaType.PARAMETER = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
    }

    private MediaType(String string, String string2, String string3, String[] string4Arr4) {
        super();
        this.mediaType = string;
        this.type = string2;
        this.subtype = string3;
        this.parameterNamesAndValues = string4Arr4;
    }

    public MediaType(String string, String string2, String string3, String[] string4Arr4, g g5) {
        super(string, string2, string3, string4Arr4);
    }

    public static final Pattern access$getPARAMETER$cp() {
        return MediaType.PARAMETER;
    }

    public static final Pattern access$getTYPE_SUBTYPE$cp() {
        return MediaType.TYPE_SUBTYPE;
    }

    public static Charset charset$default(okhttp3.MediaType mediaType, Charset charset2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = 0;
        }
        return mediaType.charset(obj1);
    }

    public static final okhttp3.MediaType get(String string) {
        return MediaType.Companion.get(string);
    }

    public static final okhttp3.MediaType parse(String string) {
        return MediaType.Companion.parse(string);
    }

    public final String -deprecated_subtype() {
        return this.subtype;
    }

    public final String -deprecated_type() {
        return this.type;
    }

    public final Charset charset() {
        int i = 0;
        return MediaType.charset$default(this, i, 1, i);
    }

    public final Charset charset(Charset charset) {
        Charset obj2;
        String parameter = parameter("charset");
        if (parameter != null) {
            obj2 = Charset.forName(parameter);
        }
        return obj2;
    }

    public boolean equals(Object object) {
        boolean mediaType;
        Object obj2;
        if (object instanceof MediaType && n.b(object.mediaType, this.mediaType)) {
            obj2 = n.b(object.mediaType, this.mediaType) ? 1 : 0;
        } else {
        }
        return obj2;
    }

    public int hashCode() {
        return this.mediaType.hashCode();
    }

    public final String parameter(String string) {
        int i2;
        boolean z;
        int i;
        n.f(string, "name");
        d dVar = g.k(i.z(this.parameterNamesAndValues), 2);
        i2 = dVar.d();
        final int i6 = dVar.g();
        int i3 = dVar.h();
        if (i3 >= 0) {
            if (i2 <= i6) {
                i = 1;
                while (l.x(this.parameterNamesAndValues[i2], string, i)) {
                    i2 += i3;
                    i = 1;
                }
                return this.parameterNamesAndValues[i2 += i];
            }
        } else {
            if (i2 >= i6) {
            }
        }
        return null;
    }

    public final String subtype() {
        return this.subtype;
    }

    public String toString() {
        return this.mediaType;
    }

    public final String type() {
        return this.type;
    }
}
