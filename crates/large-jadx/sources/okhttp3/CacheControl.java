package okhttp3;

import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.k0.l;
import okhttp3.internal.Util;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0008\u0011\n\u0002\u0010\u000e\n\u0002\u0008\r\u0018\u0000 %2\u00020\u0001:\u0002&%Bs\u0008\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0008\u0012\u0006\u0010\r\u001a\u00020\u0008\u0012\u0006\u0010\"\u001a\u00020\u0002\u0012\u0006\u0010!\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0008\u0012\u0006\u0010\u0013\u001a\u00020\u0008\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0008\u0010\u001f\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\u0008#\u0010$J\u000f\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\u0008\u0003\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0007¢\u0006\u0004\u0008\u0006\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0008H\u0007¢\u0006\u0004\u0008\t\u0010\nJ\u000f\u0010\r\u001a\u00020\u0008H\u0007¢\u0006\u0004\u0008\u000c\u0010\nJ\u000f\u0010\u000f\u001a\u00020\u0002H\u0007¢\u0006\u0004\u0008\u000e\u0010\u0004J\u000f\u0010\u0011\u001a\u00020\u0008H\u0007¢\u0006\u0004\u0008\u0010\u0010\nJ\u000f\u0010\u0013\u001a\u00020\u0008H\u0007¢\u0006\u0004\u0008\u0012\u0010\nJ\u000f\u0010\u0015\u001a\u00020\u0002H\u0007¢\u0006\u0004\u0008\u0014\u0010\u0004J\u000f\u0010\u0017\u001a\u00020\u0002H\u0007¢\u0006\u0004\u0008\u0016\u0010\u0004J\u000f\u0010\u0019\u001a\u00020\u0002H\u0007¢\u0006\u0004\u0008\u0018\u0010\u0004J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\u0008\u001b\u0010\u001cR\u0019\u0010\r\u001a\u00020\u00088\u0007@\u0006¢\u0006\u000c\n\u0004\u0008\r\u0010\u001d\u001a\u0004\u0008\r\u0010\nR\u0019\u0010\u0005\u001a\u00020\u00028\u0007@\u0006¢\u0006\u000c\n\u0004\u0008\u0005\u0010\u001e\u001a\u0004\u0008\u0005\u0010\u0004R\u0019\u0010\u0013\u001a\u00020\u00088\u0007@\u0006¢\u0006\u000c\n\u0004\u0008\u0013\u0010\u001d\u001a\u0004\u0008\u0013\u0010\nR\u0019\u0010\u0015\u001a\u00020\u00028\u0007@\u0006¢\u0006\u000c\n\u0004\u0008\u0015\u0010\u001e\u001a\u0004\u0008\u0015\u0010\u0004R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\u001f\u0010 R\u0019\u0010\u0007\u001a\u00020\u00028\u0007@\u0006¢\u0006\u000c\n\u0004\u0008\u0007\u0010\u001e\u001a\u0004\u0008\u0007\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00088\u0007@\u0006¢\u0006\u000c\n\u0004\u0008\u000b\u0010\u001d\u001a\u0004\u0008\u000b\u0010\nR\u0019\u0010!\u001a\u00020\u00028\u0006@\u0006¢\u0006\u000c\n\u0004\u0008!\u0010\u001e\u001a\u0004\u0008!\u0010\u0004R\u0019\u0010\u0017\u001a\u00020\u00028\u0007@\u0006¢\u0006\u000c\n\u0004\u0008\u0017\u0010\u001e\u001a\u0004\u0008\u0017\u0010\u0004R\u0019\u0010\u0019\u001a\u00020\u00028\u0007@\u0006¢\u0006\u000c\n\u0004\u0008\u0019\u0010\u001e\u001a\u0004\u0008\u0019\u0010\u0004R\u0019\u0010\"\u001a\u00020\u00028\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\"\u0010\u001e\u001a\u0004\u0008\"\u0010\u0004R\u0019\u0010\u0011\u001a\u00020\u00088\u0007@\u0006¢\u0006\u000c\n\u0004\u0008\u0011\u0010\u001d\u001a\u0004\u0008\u0011\u0010\nR\u0019\u0010\u000f\u001a\u00020\u00028\u0007@\u0006¢\u0006\u000c\n\u0004\u0008\u000f\u0010\u001e\u001a\u0004\u0008\u000f\u0010\u0004¨\u0006'", d2 = {"Lokhttp3/CacheControl;", "", "", "-deprecated_noCache", "()Z", "noCache", "-deprecated_noStore", "noStore", "", "-deprecated_maxAgeSeconds", "()I", "maxAgeSeconds", "-deprecated_sMaxAgeSeconds", "sMaxAgeSeconds", "-deprecated_mustRevalidate", "mustRevalidate", "-deprecated_maxStaleSeconds", "maxStaleSeconds", "-deprecated_minFreshSeconds", "minFreshSeconds", "-deprecated_onlyIfCached", "onlyIfCached", "-deprecated_noTransform", "noTransform", "-deprecated_immutable", "immutable", "", "toString", "()Ljava/lang/String;", "I", "Z", "headerValue", "Ljava/lang/String;", "isPublic", "isPrivate", "<init>", "(ZZIIZZZIIZZZLjava/lang/String;)V", "Companion", "Builder", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class CacheControl {

    public static final okhttp3.CacheControl.Companion Companion;
    public static final okhttp3.CacheControl FORCE_CACHE;
    public static final okhttp3.CacheControl FORCE_NETWORK;
    private String headerValue;
    private final boolean immutable;
    private final boolean isPrivate;
    private final boolean isPublic;
    private final int maxAgeSeconds;
    private final int maxStaleSeconds;
    private final int minFreshSeconds;
    private final boolean mustRevalidate;
    private final boolean noCache;
    private final boolean noStore;
    private final boolean noTransform;
    private final boolean onlyIfCached;
    private final int sMaxAgeSeconds;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0008\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\u0008\u001b\u0010\u001cJ\u0013\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002¢\u0006\u0004\u0008\u0004\u0010\u0005J\r\u0010\u0006\u001a\u00020\u0000¢\u0006\u0004\u0008\u0006\u0010\u0007J\r\u0010\u0008\u001a\u00020\u0000¢\u0006\u0004\u0008\u0008\u0010\u0007J\u001d\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\u0008\t\u0010\u000cJ\u001d\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\u0008\r\u0010\u000cJ\u001d\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\u0008\u000e\u0010\u000cJ\r\u0010\u000f\u001a\u00020\u0000¢\u0006\u0004\u0008\u000f\u0010\u0007J\r\u0010\u0010\u001a\u00020\u0000¢\u0006\u0004\u0008\u0010\u0010\u0007J\r\u0010\u0011\u001a\u00020\u0000¢\u0006\u0004\u0008\u0011\u0010\u0007J\r\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\u0008\u0013\u0010\u0014R\u0016\u0010\u0010\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\u0010\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\u0017\u0010\u0018R\u0016\u0010\u0011\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\u0011\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\u0019\u0010\u0018R\u0016\u0010\u0006\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\u0006\u0010\u0016R\u0016\u0010\u000f\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\u000f\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\u001a\u0010\u0018R\u0016\u0010\u0008\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\u0008\u0010\u0016¨\u0006\u001d", d2 = {"Lokhttp3/CacheControl$Builder;", "", "", "", "clampToInt", "(J)I", "noCache", "()Lokhttp3/CacheControl$Builder;", "noStore", "maxAge", "Ljava/util/concurrent/TimeUnit;", "timeUnit", "(ILjava/util/concurrent/TimeUnit;)Lokhttp3/CacheControl$Builder;", "maxStale", "minFresh", "onlyIfCached", "noTransform", "immutable", "Lokhttp3/CacheControl;", "build", "()Lokhttp3/CacheControl;", "", "Z", "maxAgeSeconds", "I", "minFreshSeconds", "maxStaleSeconds", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Builder {

        private boolean immutable;
        private int maxAgeSeconds = -1;
        private int maxStaleSeconds = -1;
        private int minFreshSeconds = -1;
        private boolean noCache;
        private boolean noStore;
        private boolean noTransform;
        private boolean onlyIfCached;
        public Builder() {
            super();
            final int i = -1;
        }

        private final int clampToInt(long l) {
            int i;
            if (Long.compare(l, l2) > 0) {
            } else {
                i = (int)l;
            }
            return i;
        }

        public final okhttp3.CacheControl build() {
            final Object obj = this;
            super(obj.noCache, obj.noStore, obj.maxAgeSeconds, -1, 0, 0, 0, obj.maxStaleSeconds, obj.minFreshSeconds, obj.onlyIfCached, obj.noTransform, obj.immutable, 0, 0);
            return cacheControl2;
        }

        public final okhttp3.CacheControl.Builder immutable() {
            this.immutable = true;
            return this;
        }

        public final okhttp3.CacheControl.Builder maxAge(int i, TimeUnit timeUnit2) {
            int i2;
            n.f(timeUnit2, "timeUnit");
            i2 = i >= 0 ? 1 : 0;
            if (i2 == 0) {
            } else {
                this.maxAgeSeconds = clampToInt(timeUnit2.toSeconds((long)i));
                return this;
            }
            StringBuilder obj4 = new StringBuilder();
            obj4.append("maxAge < 0: ");
            obj4.append(i);
            obj4 = new IllegalArgumentException(obj4.toString().toString());
            throw obj4;
        }

        public final okhttp3.CacheControl.Builder maxStale(int i, TimeUnit timeUnit2) {
            int i2;
            n.f(timeUnit2, "timeUnit");
            i2 = i >= 0 ? 1 : 0;
            if (i2 == 0) {
            } else {
                this.maxStaleSeconds = clampToInt(timeUnit2.toSeconds((long)i));
                return this;
            }
            StringBuilder obj4 = new StringBuilder();
            obj4.append("maxStale < 0: ");
            obj4.append(i);
            obj4 = new IllegalArgumentException(obj4.toString().toString());
            throw obj4;
        }

        public final okhttp3.CacheControl.Builder minFresh(int i, TimeUnit timeUnit2) {
            int i2;
            n.f(timeUnit2, "timeUnit");
            i2 = i >= 0 ? 1 : 0;
            if (i2 == 0) {
            } else {
                this.minFreshSeconds = clampToInt(timeUnit2.toSeconds((long)i));
                return this;
            }
            StringBuilder obj4 = new StringBuilder();
            obj4.append("minFresh < 0: ");
            obj4.append(i);
            obj4 = new IllegalArgumentException(obj4.toString().toString());
            throw obj4;
        }

        public final okhttp3.CacheControl.Builder noCache() {
            this.noCache = true;
            return this;
        }

        public final okhttp3.CacheControl.Builder noStore() {
            this.noStore = true;
            return this;
        }

        public final okhttp3.CacheControl.Builder noTransform() {
            this.noTransform = true;
            return this;
        }

        public final okhttp3.CacheControl.Builder onlyIfCached() {
            this.onlyIfCached = true;
            return this;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0010\u0010\u0011J%\u0010\u0006\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\u0008\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0008H\u0007¢\u0006\u0004\u0008\u000b\u0010\u000cR\u0016\u0010\r\u001a\u00020\n8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\n8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008\u000f\u0010\u000e¨\u0006\u0012", d2 = {"Lokhttp3/CacheControl$Companion;", "", "", "characters", "", "startIndex", "indexOfElement", "(Ljava/lang/String;Ljava/lang/String;I)I", "Lokhttp3/Headers;", "headers", "Lokhttp3/CacheControl;", "parse", "(Lokhttp3/Headers;)Lokhttp3/CacheControl;", "FORCE_CACHE", "Lokhttp3/CacheControl;", "FORCE_NETWORK", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion(g g) {
            super();
        }

        private final int indexOfElement(String string, String string2, int i3) {
            boolean z;
            int i;
            int i2;
            int i4;
            int obj8;
            while (obj8 < string.length()) {
                obj8++;
            }
            return string.length();
        }

        static int indexOfElement$default(okhttp3.CacheControl.Companion cacheControl$Companion, String string2, String string3, int i4, int i5, Object object6) {
            int obj3;
            if (i5 &= 2 != 0) {
                obj3 = 0;
            }
            return companion.indexOfElement(string2, string3, obj3);
        }

        public final okhttp3.CacheControl parse(okhttp3.Headers headers) {
            Object obj;
            int str3;
            boolean z;
            int i7;
            int size;
            int i6;
            boolean name;
            String string;
            String substring;
            String value;
            int i20;
            int i14;
            int i17;
            int indexOfElement;
            int i15;
            int i21;
            int i4;
            int nonNegativeInt4;
            int nonNegativeInt;
            int i5;
            int i;
            int i22;
            int nonNegativeInt3;
            int nonNegativeInt2;
            int i11;
            int i3;
            int i9;
            int i12;
            String str;
            int i16;
            int i18;
            int i19;
            int i10;
            int i8;
            int i13;
            int i2;
            String str2;
            final Object obj2 = this;
            n.f(headers, "headers");
            size = headers.size();
            i17 = i20;
            i14 = 0;
            i15 = 0;
            i21 = 0;
            i4 = 0;
            nonNegativeInt4 = -1;
            nonNegativeInt = -1;
            i5 = 0;
            i = 0;
            i22 = 0;
            nonNegativeInt3 = -1;
            nonNegativeInt2 = -1;
            i11 = 0;
            i3 = 0;
            i9 = 0;
            while (i14 < size) {
                name = obj.name(i14);
                value = obj.value(i14);
                if (l.x(name, "Cache-Control", i20)) {
                } else {
                }
                if (l.x(name, "Pragma", i20)) {
                } else {
                }
                i13 = size;
                int i23 = -1;
                i14++;
                obj = headers;
                size = i13;
                i17 = 0;
                name = 0;
                while (name < value.length()) {
                    int indexOfElement2 = obj2.indexOfElement(value, "=,;", name);
                    String str18 = "null cannot be cast to non-null type java.lang.String";
                    Objects.requireNonNull(value, str18);
                    String substring2 = value.substring(name, indexOfElement2);
                    str3 = "(this as java.lang.Strin…ing(startIndex, endIndex)";
                    n.e(substring2, str3);
                    String str13 = "null cannot be cast to non-null type kotlin.CharSequence";
                    Objects.requireNonNull(substring2, str13);
                    string = l.a1(substring2).toString();
                    if (indexOfElement2 != value.length()) {
                    } else {
                    }
                    str2 = i15;
                    i6 = i27;
                    substring = 0;
                    i20 = 1;
                    if (l.x("no-cache", string, i20)) {
                    } else {
                    }
                    if (l.x("no-store", string, i20)) {
                    } else {
                    }
                    if (l.x("max-age", string, i20)) {
                    } else {
                    }
                    if (l.x("s-maxage", string, i20) != 0) {
                    } else {
                    }
                    if (l.x("private", string, i20)) {
                    } else {
                    }
                    if (l.x("public", string, i20)) {
                    } else {
                    }
                    if (l.x("must-revalidate", string, i20)) {
                    } else {
                    }
                    if (l.x("max-stale", string, i20)) {
                    } else {
                    }
                    if (l.x("min-fresh", string, i20)) {
                    } else {
                    }
                    i7 = -1;
                    if (l.x("only-if-cached", string, i20)) {
                    } else {
                    }
                    if (l.x("no-transform", string, i20)) {
                    } else {
                    }
                    if (l.x("immutable", string, i20)) {
                    }
                    obj = headers;
                    name = i6;
                    size = i13;
                    i17 = i2;
                    i15 = str2;
                    i9 = i20;
                    i3 = i20;
                    i11 = i20;
                    nonNegativeInt2 = Util.toNonNegativeInt(substring, -1);
                    nonNegativeInt3 = Util.toNonNegativeInt(substring, true);
                    i7 = -1;
                    i22 = i20;
                    i = i20;
                    i5 = i20;
                    nonNegativeInt = Util.toNonNegativeInt(substring, -1);
                    nonNegativeInt4 = Util.toNonNegativeInt(substring, -1);
                    i4 = i20;
                    i21 = i20;
                    str2 = i15;
                    if (value.charAt(indexOfElement2) != 44) {
                    } else {
                    }
                    if (value.charAt(indexOfElement2) == 59) {
                    } else {
                    }
                    int indexOfNonWhitespace = Util.indexOfNonWhitespace(value, indexOfElement2++);
                    if (indexOfNonWhitespace < value.length() && value.charAt(indexOfNonWhitespace) == 34) {
                    } else {
                    }
                    indexOfElement = obj2.indexOfElement(value, ",;", indexOfNonWhitespace);
                    Objects.requireNonNull(value, str18);
                    String substring3 = value.substring(indexOfNonWhitespace, indexOfElement);
                    n.e(substring3, str3);
                    Objects.requireNonNull(substring3, str13);
                    substring = l.a1(substring3).toString();
                    i6 = indexOfElement;
                    if (value.charAt(indexOfNonWhitespace) == 34) {
                    } else {
                    }
                    indexOfNonWhitespace++;
                    int i24 = l.d0(value, '"', i26, false, 4, 0);
                    Objects.requireNonNull(value, str18);
                    n.e(value.substring(i26, i24), str3);
                    i24 += str3;
                }
                i13 = size;
                i2 = i17;
                str2 = i15;
                indexOfElement2 = obj2.indexOfElement(value, "=,;", name);
                str18 = "null cannot be cast to non-null type java.lang.String";
                Objects.requireNonNull(value, str18);
                substring2 = value.substring(name, indexOfElement2);
                str3 = "(this as java.lang.Strin…ing(startIndex, endIndex)";
                n.e(substring2, str3);
                str13 = "null cannot be cast to non-null type kotlin.CharSequence";
                Objects.requireNonNull(substring2, str13);
                string = l.a1(substring2).toString();
                if (indexOfElement2 != value.length()) {
                } else {
                }
                str2 = i15;
                i6 = i27;
                substring = 0;
                i20 = 1;
                if (l.x("no-cache", string, i20)) {
                } else {
                }
                if (l.x("no-store", string, i20)) {
                } else {
                }
                if (l.x("max-age", string, i20)) {
                } else {
                }
                if (l.x("s-maxage", string, i20) != 0) {
                } else {
                }
                if (l.x("private", string, i20)) {
                } else {
                }
                if (l.x("public", string, i20)) {
                } else {
                }
                if (l.x("must-revalidate", string, i20)) {
                } else {
                }
                if (l.x("max-stale", string, i20)) {
                } else {
                }
                if (l.x("min-fresh", string, i20)) {
                } else {
                }
                i7 = -1;
                if (l.x("only-if-cached", string, i20)) {
                } else {
                }
                if (l.x("no-transform", string, i20)) {
                } else {
                }
                if (l.x("immutable", string, i20)) {
                }
                obj = headers;
                name = i6;
                size = i13;
                i17 = i2;
                i15 = str2;
                i9 = i20;
                i3 = i20;
                i11 = i20;
                nonNegativeInt2 = Util.toNonNegativeInt(substring, -1);
                nonNegativeInt3 = Util.toNonNegativeInt(substring, true);
                i7 = -1;
                i22 = i20;
                i = i20;
                i5 = i20;
                nonNegativeInt = Util.toNonNegativeInt(substring, -1);
                nonNegativeInt4 = Util.toNonNegativeInt(substring, -1);
                i4 = i20;
                i21 = i20;
                str2 = i15;
                if (value.charAt(indexOfElement2) != 44) {
                } else {
                }
                if (value.charAt(indexOfElement2) == 59) {
                } else {
                }
                indexOfNonWhitespace = Util.indexOfNonWhitespace(value, indexOfElement2++);
                if (indexOfNonWhitespace < value.length() && value.charAt(indexOfNonWhitespace) == 34) {
                } else {
                }
                indexOfElement = obj2.indexOfElement(value, ",;", indexOfNonWhitespace);
                Objects.requireNonNull(value, str18);
                substring3 = value.substring(indexOfNonWhitespace, indexOfElement);
                n.e(substring3, str3);
                Objects.requireNonNull(substring3, str13);
                substring = l.a1(substring3).toString();
                i6 = indexOfElement;
                if (value.charAt(indexOfNonWhitespace) == 34) {
                } else {
                }
                indexOfNonWhitespace++;
                i24 = l.d0(value, '"', i26, false, 4, 0);
                Objects.requireNonNull(value, str18);
                n.e(value.substring(i26, i24), str3);
                i24 += str3;
                if (i15 != 0) {
                } else {
                }
                i15 = value;
            }
            i12 = i17 == 0 ? 0 : i15;
            super(i21, i4, nonNegativeInt4, nonNegativeInt, i5, i, i22, nonNegativeInt3, nonNegativeInt2, i11, i3, i9, i12, 0);
            return cacheControl;
        }
    }
    static {
        CacheControl.Companion companion = new CacheControl.Companion(0);
        CacheControl.Companion = companion;
        CacheControl.Builder builder = new CacheControl.Builder();
        CacheControl.FORCE_NETWORK = builder.noCache().build();
        CacheControl.Builder builder2 = new CacheControl.Builder();
        CacheControl.FORCE_CACHE = builder2.onlyIfCached().maxStale(Integer.MAX_VALUE, TimeUnit.SECONDS).build();
    }

    private CacheControl(boolean z, boolean z2, int i3, int i4, boolean z5, boolean z6, boolean z7, int i8, int i9, boolean z10, boolean z11, boolean z12, String string13) {
        super();
        this.noCache = z;
        this.noStore = z2;
        this.maxAgeSeconds = i3;
        this.sMaxAgeSeconds = i4;
        this.isPrivate = z5;
        this.isPublic = z6;
        this.mustRevalidate = z7;
        this.maxStaleSeconds = i8;
        this.minFreshSeconds = i9;
        this.onlyIfCached = z10;
        this.noTransform = z11;
        this.immutable = z12;
        this.headerValue = string13;
    }

    public CacheControl(boolean z, boolean z2, int i3, int i4, boolean z5, boolean z6, boolean z7, int i8, int i9, boolean z10, boolean z11, boolean z12, String string13, g g14) {
        super(z, z2, i3, i4, z5, z6, z7, i8, i9, z10, z11, z12, string13);
    }

    public static final okhttp3.CacheControl parse(okhttp3.Headers headers) {
        return CacheControl.Companion.parse(headers);
    }

    public final boolean -deprecated_immutable() {
        return this.immutable;
    }

    public final int -deprecated_maxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    public final int -deprecated_maxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    public final int -deprecated_minFreshSeconds() {
        return this.minFreshSeconds;
    }

    public final boolean -deprecated_mustRevalidate() {
        return this.mustRevalidate;
    }

    public final boolean -deprecated_noCache() {
        return this.noCache;
    }

    public final boolean -deprecated_noStore() {
        return this.noStore;
    }

    public final boolean -deprecated_noTransform() {
        return this.noTransform;
    }

    public final boolean -deprecated_onlyIfCached() {
        return this.onlyIfCached;
    }

    public final int -deprecated_sMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }

    public final boolean immutable() {
        return this.immutable;
    }

    public final boolean isPrivate() {
        return this.isPrivate;
    }

    public final boolean isPublic() {
        return this.isPublic;
    }

    public final int maxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    public final int maxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    public final int minFreshSeconds() {
        return this.minFreshSeconds;
    }

    public final boolean mustRevalidate() {
        return this.mustRevalidate;
    }

    public final boolean noCache() {
        return this.noCache;
    }

    public final boolean noStore() {
        return this.noStore;
    }

    public final boolean noTransform() {
        return this.noTransform;
    }

    public final boolean onlyIfCached() {
        return this.onlyIfCached;
    }

    public final int sMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }

    public String toString() {
        String headerValue;
        String str;
        boolean noCache;
        boolean noStore;
        int maxAgeSeconds;
        int sMaxAgeSeconds;
        boolean isPrivate;
        boolean isPublic;
        boolean mustRevalidate;
        int maxStaleSeconds;
        int minFreshSeconds;
        boolean onlyIfCached;
        boolean noTransform;
        boolean immutable;
        int i2;
        int length;
        int i;
        StringBuilder stringBuilder = new StringBuilder();
        if (this.headerValue == null && this.noCache) {
            stringBuilder = new StringBuilder();
            if (this.noCache) {
                stringBuilder.append("no-cache, ");
            }
            if (this.noStore) {
                stringBuilder.append("no-store, ");
            }
            String str7 = ", ";
            i = -1;
            if (this.maxAgeSeconds != i) {
                stringBuilder.append("max-age=");
                stringBuilder.append(this.maxAgeSeconds);
                stringBuilder.append(str7);
            }
            if (this.sMaxAgeSeconds != i) {
                stringBuilder.append("s-maxage=");
                stringBuilder.append(this.sMaxAgeSeconds);
                stringBuilder.append(str7);
            }
            if (this.isPrivate) {
                stringBuilder.append("private, ");
            }
            if (this.isPublic) {
                stringBuilder.append("public, ");
            }
            if (this.mustRevalidate) {
                stringBuilder.append("must-revalidate, ");
            }
            if (this.maxStaleSeconds != i) {
                stringBuilder.append("max-stale=");
                stringBuilder.append(this.maxStaleSeconds);
                stringBuilder.append(str7);
            }
            if (this.minFreshSeconds != i) {
                stringBuilder.append("min-fresh=");
                stringBuilder.append(this.minFreshSeconds);
                stringBuilder.append(str7);
            }
            if (this.onlyIfCached) {
                stringBuilder.append("only-if-cached, ");
            }
            if (this.noTransform) {
                stringBuilder.append("no-transform, ");
            }
            if (this.immutable) {
                stringBuilder.append("immutable, ");
            }
            i2 = stringBuilder.length() == 0 ? 1 : 0;
            if (i2 != 0) {
                return "";
            }
            stringBuilder.delete(length3 += -2, stringBuilder.length());
            headerValue = stringBuilder.toString();
            n.e(headerValue, "StringBuilder().apply(builderAction).toString()");
            this.headerValue = headerValue;
        }
        return headerValue;
    }
}
