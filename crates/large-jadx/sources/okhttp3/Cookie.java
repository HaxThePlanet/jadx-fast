package okhttp3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.k0.h;
import kotlin.k0.l;
import kotlin.y.p;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase.Companion;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\t\n\u0002\u0010\t\n\u0002\u0008\u0018\u0018\u0000 -2\u00020\u0001:\u0002.-BQ\u0008\u0002\u0012\u0006\u0010\u0011\u001a\u00020\r\u0012\u0006\u0010\u0013\u001a\u00020\r\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u0010\u001e\u001a\u00020\r\u0012\u0006\u0010 \u001a\u00020\r\u0012\u0006\u0010$\u001a\u00020\u0004\u0012\u0006\u0010\"\u001a\u00020\u0004\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u0012\u0006\u0010\u001c\u001a\u00020\u0004¢\u0006\u0004\u0008+\u0010,J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\u0008\u0005\u0010\u0006J\u001a\u0010\u0008\u001a\u00020\u00042\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\u0008\u0008\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0017¢\u0006\u0004\u0008\u000b\u0010\u000cJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\u0008\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\rH\u0007¢\u0006\u0004\u0008\u0010\u0010\u000fJ\u000f\u0010\u0013\u001a\u00020\rH\u0007¢\u0006\u0004\u0008\u0012\u0010\u000fJ\u000f\u0010\u0016\u001a\u00020\u0004H\u0007¢\u0006\u0004\u0008\u0014\u0010\u0015J\u000f\u0010\u001a\u001a\u00020\u0017H\u0007¢\u0006\u0004\u0008\u0018\u0010\u0019J\u000f\u0010\u001c\u001a\u00020\u0004H\u0007¢\u0006\u0004\u0008\u001b\u0010\u0015J\u000f\u0010\u001e\u001a\u00020\rH\u0007¢\u0006\u0004\u0008\u001d\u0010\u000fJ\u000f\u0010 \u001a\u00020\rH\u0007¢\u0006\u0004\u0008\u001f\u0010\u000fJ\u000f\u0010\"\u001a\u00020\u0004H\u0007¢\u0006\u0004\u0008!\u0010\u0015J\u000f\u0010$\u001a\u00020\u0004H\u0007¢\u0006\u0004\u0008#\u0010\u0015J\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010%\u001a\u00020\u0004H\u0000¢\u0006\u0004\u0008&\u0010'R\u0019\u0010\u001c\u001a\u00020\u00048\u0007@\u0006¢\u0006\u000c\n\u0004\u0008\u001c\u0010(\u001a\u0004\u0008\u001c\u0010\u0015R\u0019\u0010\"\u001a\u00020\u00048\u0007@\u0006¢\u0006\u000c\n\u0004\u0008\"\u0010(\u001a\u0004\u0008\"\u0010\u0015R\u0019\u0010\u001e\u001a\u00020\r8\u0007@\u0006¢\u0006\u000c\n\u0004\u0008\u001e\u0010)\u001a\u0004\u0008\u001e\u0010\u000fR\u0019\u0010$\u001a\u00020\u00048\u0007@\u0006¢\u0006\u000c\n\u0004\u0008$\u0010(\u001a\u0004\u0008$\u0010\u0015R\u0019\u0010\u0013\u001a\u00020\r8\u0007@\u0006¢\u0006\u000c\n\u0004\u0008\u0013\u0010)\u001a\u0004\u0008\u0013\u0010\u000fR\u0019\u0010\u0011\u001a\u00020\r8\u0007@\u0006¢\u0006\u000c\n\u0004\u0008\u0011\u0010)\u001a\u0004\u0008\u0011\u0010\u000fR\u0019\u0010\u0016\u001a\u00020\u00048\u0007@\u0006¢\u0006\u000c\n\u0004\u0008\u0016\u0010(\u001a\u0004\u0008\u0016\u0010\u0015R\u0019\u0010\u001a\u001a\u00020\u00178\u0007@\u0006¢\u0006\u000c\n\u0004\u0008\u001a\u0010*\u001a\u0004\u0008\u001a\u0010\u0019R\u0019\u0010 \u001a\u00020\r8\u0007@\u0006¢\u0006\u000c\n\u0004\u0008 \u0010)\u001a\u0004\u0008 \u0010\u000f¨\u0006/", d2 = {"Lokhttp3/Cookie;", "", "Lokhttp3/HttpUrl;", "url", "", "matches", "(Lokhttp3/HttpUrl;)Z", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "-deprecated_name", "name", "-deprecated_value", "value", "-deprecated_persistent", "()Z", "persistent", "", "-deprecated_expiresAt", "()J", "expiresAt", "-deprecated_hostOnly", "hostOnly", "-deprecated_domain", "domain", "-deprecated_path", "path", "-deprecated_httpOnly", "httpOnly", "-deprecated_secure", "secure", "forObsoleteRfc2965", "toString$okhttp", "(Z)Ljava/lang/String;", "Z", "Ljava/lang/String;", "J", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;ZZZZ)V", "Companion", "Builder", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class Cookie {

    public static final okhttp3.Cookie.Companion Companion;
    private static final Pattern DAY_OF_MONTH_PATTERN;
    private static final Pattern MONTH_PATTERN;
    private static final Pattern TIME_PATTERN;
    private static final Pattern YEAR_PATTERN;
    private final String domain;
    private final long expiresAt;
    private final boolean hostOnly;
    private final boolean httpOnly;
    private final String name;
    private final String path;
    private final boolean persistent;
    private final boolean secure;
    private final String value;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0010\t\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\u0008\u0019\u0010\u001aJ\u001f\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\u0008\u0003\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\u0008\u0007\u0010\u0008J\u0015\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\u0008\t\u0010\u0008J\u0015\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\u0008\u000b\u0010\u000cJ\u0015\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\u0008\u0003\u0010\u0008J\u0015\u0010\r\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\u0008\r\u0010\u0008J\u0015\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\u0008\u000e\u0010\u0008J\r\u0010\u000f\u001a\u00020\u0000¢\u0006\u0004\u0008\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u0000¢\u0006\u0004\u0008\u0011\u0010\u0010J\r\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\u0008\u0013\u0010\u0014R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\u0007\u0010\u0015R\u0016\u0010\u0011\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\u0011\u0010\u0016R\u0016\u0010\u000f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\u000f\u0010\u0016R\u0016\u0010\u000e\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\u000e\u0010\u0015R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\t\u0010\u0015R\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\u000b\u0010\u0017R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\u0005\u0010\u0016R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\u0003\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\u0018\u0010\u0016¨\u0006\u001b", d2 = {"Lokhttp3/Cookie$Builder;", "", "", "domain", "", "hostOnly", "(Ljava/lang/String;Z)Lokhttp3/Cookie$Builder;", "name", "(Ljava/lang/String;)Lokhttp3/Cookie$Builder;", "value", "", "expiresAt", "(J)Lokhttp3/Cookie$Builder;", "hostOnlyDomain", "path", "secure", "()Lokhttp3/Cookie$Builder;", "httpOnly", "Lokhttp3/Cookie;", "build", "()Lokhttp3/Cookie;", "Ljava/lang/String;", "Z", "J", "persistent", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Builder {

        private String domain;
        private long expiresAt = 253402300799999L;
        private boolean hostOnly;
        private boolean httpOnly;
        private String name;
        private String path;
        private boolean persistent;
        private boolean secure;
        private String value;
        public Builder() {
            super();
            long l = 253402300799999L;
            this.path = "/";
        }

        private final okhttp3.Cookie.Builder domain(String string, boolean z2) {
            String canonicalHost = HostnamesKt.toCanonicalHost(string);
            if (canonicalHost == null) {
            } else {
                this.domain = canonicalHost;
                this.hostOnly = z2;
                return this;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("unexpected domain: ");
            stringBuilder.append(string);
            IllegalArgumentException obj4 = new IllegalArgumentException(stringBuilder.toString());
            throw obj4;
        }

        public final okhttp3.Cookie build() {
            final String name = this.name;
            Objects.requireNonNull(name, "builder.name == null");
            final String value = this.value;
            Objects.requireNonNull(value, "builder.value == null");
            final String domain = this.domain;
            Objects.requireNonNull(domain, "builder.domain == null");
            super(name, value, this.expiresAt, obj4, domain, this.path, this.secure, this.httpOnly, this.persistent, this.hostOnly, 0);
            return cookie2;
        }

        public final okhttp3.Cookie.Builder domain(String string) {
            n.f(string, "domain");
            return domain(string, false);
        }

        public final okhttp3.Cookie.Builder expiresAt(long l) {
            int obj4;
            if (Long.compare(l, i) <= 0) {
                obj4 = Long.MIN_VALUE;
            }
            long l2 = 253402300799999L;
            if (Long.compare(obj4, l2) > 0) {
                obj4 = l2;
            }
            this.expiresAt = obj4;
            this.persistent = true;
            return this;
        }

        public final okhttp3.Cookie.Builder hostOnlyDomain(String string) {
            n.f(string, "domain");
            return domain(string, true);
        }

        public final okhttp3.Cookie.Builder httpOnly() {
            this.httpOnly = true;
            return this;
        }

        public final okhttp3.Cookie.Builder name(String string) {
            n.f(string, "name");
            if (!n.b(l.a1(string).toString(), string)) {
            } else {
                this.name = string;
                return this;
            }
            IllegalArgumentException obj2 = new IllegalArgumentException("name is not trimmed".toString());
            throw obj2;
        }

        public final okhttp3.Cookie.Builder path(String string) {
            n.f(string, "path");
            if (!l.M(string, "/", false, 2, 0)) {
            } else {
                this.path = string;
                return this;
            }
            IllegalArgumentException obj5 = new IllegalArgumentException("path must start with '/'".toString());
            throw obj5;
        }

        public final okhttp3.Cookie.Builder secure() {
            this.secure = true;
            return this;
        }

        public final okhttp3.Cookie.Builder value(String string) {
            n.f(string, "value");
            if (!n.b(l.a1(string).toString(), string)) {
            } else {
                this.value = string;
                return this;
            }
            IllegalArgumentException obj2 = new IllegalArgumentException("value is not trimmed".toString());
            throw obj2;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008/\u00100J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008\u0006\u0010\u0007J\u001f\u0010\u000b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00082\u0006\u0010\n\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008\u000b\u0010\u000cJ'\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0002¢\u0006\u0004\u0008\u0012\u0010\u0013J/\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0005H\u0002¢\u0006\u0004\u0008\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008\u001a\u0010\u001bJ!\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\t\u001a\u00020\u00082\u0006\u0010\u001c\u001a\u00020\u0002H\u0007¢\u0006\u0004\u0008\u001e\u0010\u001fJ)\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010 \u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u00082\u0006\u0010\u001c\u001a\u00020\u0002H\u0000¢\u0006\u0004\u0008!\u0010\"J%\u0010&\u001a\u0008\u0012\u0004\u0012\u00020\u001d0%2\u0006\u0010\t\u001a\u00020\u00082\u0006\u0010$\u001a\u00020#H\u0007¢\u0006\u0004\u0008&\u0010'R\u001e\u0010*\u001a\n )*\u0004\u0018\u00010(0(8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008*\u0010+R\u001e\u0010,\u001a\n )*\u0004\u0018\u00010(0(8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008,\u0010+R\u001e\u0010-\u001a\n )*\u0004\u0018\u00010(0(8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008-\u0010+R\u001e\u0010.\u001a\n )*\u0004\u0018\u00010(0(8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008.\u0010+¨\u00061", d2 = {"Lokhttp3/Cookie$Companion;", "", "", "urlHost", "domain", "", "domainMatch", "(Ljava/lang/String;Ljava/lang/String;)Z", "Lokhttp3/HttpUrl;", "url", "path", "pathMatch", "(Lokhttp3/HttpUrl;Ljava/lang/String;)Z", "s", "", "pos", "limit", "", "parseExpires", "(Ljava/lang/String;II)J", "input", "invert", "dateCharacterOffset", "(Ljava/lang/String;IIZ)I", "parseMaxAge", "(Ljava/lang/String;)J", "parseDomain", "(Ljava/lang/String;)Ljava/lang/String;", "setCookie", "Lokhttp3/Cookie;", "parse", "(Lokhttp3/HttpUrl;Ljava/lang/String;)Lokhttp3/Cookie;", "currentTimeMillis", "parse$okhttp", "(JLokhttp3/HttpUrl;Ljava/lang/String;)Lokhttp3/Cookie;", "Lokhttp3/Headers;", "headers", "", "parseAll", "(Lokhttp3/HttpUrl;Lokhttp3/Headers;)Ljava/util/List;", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "DAY_OF_MONTH_PATTERN", "Ljava/util/regex/Pattern;", "MONTH_PATTERN", "TIME_PATTERN", "YEAR_PATTERN", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion(g g) {
            super();
        }

        public static final boolean access$domainMatch(okhttp3.Cookie.Companion cookie$Companion, String string2, String string3) {
            return companion.domainMatch(string2, string3);
        }

        public static final boolean access$pathMatch(okhttp3.Cookie.Companion cookie$Companion, okhttp3.HttpUrl httpUrl2, String string3) {
            return companion.pathMatch(httpUrl2, string3);
        }

        private final int dateCharacterOffset(String string, int i2, int i3, boolean z4) {
            int i5;
            int i;
            int i4;
            while (i2 < i3) {
                char charAt = string.charAt(i2);
                if (charAt < 32) {
                } else {
                }
                if (charAt < 127) {
                } else {
                }
                i5 = i7;
                i2++;
                if (48 <= charAt) {
                } else {
                }
                if (97 <= charAt) {
                } else {
                }
                if (65 <= charAt) {
                } else {
                }
                if (charAt == 58) {
                } else {
                }
                i5 = 0;
                if (90 < charAt) {
                } else {
                }
                if (122 < charAt) {
                } else {
                }
                if (57 < charAt) {
                } else {
                }
                if (charAt == 9 && charAt < 127) {
                } else {
                }
            }
            return i3;
        }

        private final boolean domainMatch(String string, String string2) {
            int z;
            int i;
            boolean obj5;
            char obj6;
            i = 1;
            if (n.b(string, string2)) {
                return i;
            }
            final int i6 = 0;
            if (l.w(string, string2, i6, 2, 0) && string.charAt(i3 -= i) == 46 && !Util.canParseAsIpAddress(string)) {
                if (string.charAt(i3 -= i) == 46) {
                    if (!Util.canParseAsIpAddress(string)) {
                    } else {
                        i = i6;
                    }
                } else {
                }
            } else {
            }
            return i;
        }

        private final String parseDomain(String string) {
            String str = ".";
            if (z ^= 1 == 0) {
            } else {
                String obj5 = HostnamesKt.toCanonicalHost(l.u0(string, str));
                if (obj5 == null) {
                } else {
                    return obj5;
                }
                obj5 = new IllegalArgumentException();
                throw obj5;
            }
            obj5 = new IllegalArgumentException("Failed requirement.".toString());
            throw obj5;
        }

        private final long parseExpires(String string, int i2, int i3) {
            int i10;
            int i12;
            int i7;
            int i4;
            int i8;
            int matches;
            int i15;
            int dateCharacterOffset;
            String pattern;
            int int;
            int int2;
            int int3;
            int i11;
            int int4;
            int int5;
            int i13;
            int i9;
            int i16;
            String str;
            String str2;
            int i5;
            int i14;
            int i;
            int i6;
            final Object obj = this;
            String str3 = string;
            int i23 = i3;
            dateCharacterOffset = obj.dateCharacterOffset(str3, i2, i23, false);
            Matcher matcher = Cookie.access$getTIME_PATTERN$cp().matcher(str3);
            final int i34 = -1;
            int5 = int4;
            i13 = 2;
            i9 = 1;
            while (dateCharacterOffset < i23) {
                int dateCharacterOffset2 = obj.dateCharacterOffset(str3, dateCharacterOffset + 1, i23, i9);
                matcher.region(dateCharacterOffset, dateCharacterOffset2);
                pattern = "matcher.group(1)";
                if (int2 == i34 && matcher.usePattern(Cookie.access$getTIME_PATTERN$cp()).matches()) {
                } else {
                }
                if (int3 == i34 && matcher.usePattern(Cookie.access$getDAY_OF_MONTH_PATTERN$cp()).matches()) {
                } else {
                }
                if (i11 == i34 && matcher.usePattern(Cookie.access$getMONTH_PATTERN$cp()).matches()) {
                } else {
                }
                if (int == i34 && matcher.usePattern(Cookie.access$getYEAR_PATTERN$cp()).matches()) {
                }
                dateCharacterOffset = obj.dateCharacterOffset(str3, dateCharacterOffset2++, i23, false);
                i13 = 2;
                i9 = 1;
                if (matcher.usePattern(Cookie.access$getYEAR_PATTERN$cp()).matches()) {
                }
                matches = matcher.group(i9);
                n.e(matches, pattern);
                int = Integer.parseInt(matches);
                if (matcher.usePattern(Cookie.access$getMONTH_PATTERN$cp()).matches()) {
                } else {
                }
                String group = matcher.group(i9);
                n.e(group, pattern);
                Locale uS = Locale.US;
                n.e(uS, "Locale.US");
                Objects.requireNonNull(group, "null cannot be cast to non-null type java.lang.String");
                String lowerCase = group.toLowerCase(uS);
                n.e(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                pattern = Cookie.access$getMONTH_PATTERN$cp().pattern();
                n.e(pattern, "MONTH_PATTERN.pattern()");
                i11 = matches / 4;
                if (matcher.usePattern(Cookie.access$getDAY_OF_MONTH_PATTERN$cp()).matches()) {
                } else {
                }
                matches = matcher.group(i9);
                n.e(matches, pattern);
                int3 = Integer.parseInt(matches);
                if (matcher.usePattern(Cookie.access$getTIME_PATTERN$cp()).matches()) {
                } else {
                }
                String group2 = matcher.group(i9);
                n.e(group2, pattern);
                int2 = Integer.parseInt(group2);
                String group3 = matcher.group(i13);
                n.e(group3, "matcher.group(2)");
                int4 = Integer.parseInt(group3);
                matches = matcher.group(3);
                n.e(matches, "matcher.group(3)");
                int5 = Integer.parseInt(matches);
            }
            if (70 > int) {
            } else {
                if (99 >= int) {
                    int += 1900;
                }
            }
            if (int < 0) {
            } else {
                if (69 >= int) {
                    int += 2000;
                }
            }
            i10 = int >= 1601 ? i9 : 0;
            String str4 = "Failed requirement.";
            if (i10 == 0) {
            } else {
                i12 = i11 != i34 ? i9 : 0;
                if (i12 == 0) {
                } else {
                    if (i9 > int3) {
                        i7 = 0;
                    } else {
                        if (31 >= int3) {
                            i7 = i9;
                        } else {
                        }
                    }
                    if (i7 == 0) {
                    } else {
                        if (int2 < 0) {
                            i4 = 0;
                        } else {
                            if (23 >= int2) {
                                i4 = i9;
                            } else {
                            }
                        }
                        if (i4 == 0) {
                        } else {
                            int i22 = 59;
                            if (int4 < 0) {
                                i15 = 0;
                            } else {
                                if (i22 >= int4) {
                                    i15 = i9;
                                } else {
                                }
                            }
                            if (i15 == 0) {
                            } else {
                                if (int5 < 0) {
                                    i8 = 0;
                                } else {
                                    if (i22 >= int5) {
                                        i8 = i9;
                                    } else {
                                    }
                                }
                                if (i8 == 0) {
                                } else {
                                    GregorianCalendar gregorianCalendar = new GregorianCalendar(Util.UTC);
                                    gregorianCalendar.setLenient(false);
                                    gregorianCalendar.set(i9, int);
                                    gregorianCalendar.set(i13, i11 -= i9);
                                    gregorianCalendar.set(5, int3);
                                    gregorianCalendar.set(11, int2);
                                    gregorianCalendar.set(12, int4);
                                    gregorianCalendar.set(13, int5);
                                    gregorianCalendar.set(14, 0);
                                    return gregorianCalendar.getTimeInMillis();
                                }
                                IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(str4.toString());
                                throw illegalArgumentException2;
                            }
                            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(str4.toString());
                            throw illegalArgumentException3;
                        }
                        IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException(str4.toString());
                        throw illegalArgumentException4;
                    }
                    IllegalArgumentException illegalArgumentException5 = new IllegalArgumentException(str4.toString());
                    throw illegalArgumentException5;
                }
                IllegalArgumentException illegalArgumentException6 = new IllegalArgumentException(str4.toString());
                throw illegalArgumentException6;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(str4.toString());
            throw illegalArgumentException;
        }

        private final long parseMaxAge(String string) {
            long l2;
            l2 = Long.MIN_VALUE;
            final long long = Long.parseLong(string);
            if (Long.compare(long, i) <= 0) {
            } else {
                try {
                    l2 = long;
                    return l2;
                    String str = "-?\\d+";
                    h hVar = new h(str);
                    hVar = hVar.d(string);
                    Throwable th = null;
                    hVar = 2;
                    str = null;
                    string = l.M(string, "-", th, hVar, str);
                }
                throw th;
            }
        }

        private final boolean pathMatch(okhttp3.HttpUrl httpUrl, String string2) {
            int i;
            boolean str;
            String obj6;
            Object obj7;
            obj6 = httpUrl.encodedPath();
            final int i3 = 1;
            if (n.b(obj6, string2)) {
                return i3;
            }
            int i2 = 0;
            i = 2;
            final int i4 = 0;
            if (l.M(obj6, string2, i2, i, i4) && l.w(string2, "/", i2, i, i4)) {
                if (l.w(string2, "/", i2, i, i4)) {
                    return i3;
                }
                if (obj6.charAt(string2.length()) == 47) {
                    return i3;
                }
            }
            return i2;
        }

        public final okhttp3.Cookie parse(okhttp3.HttpUrl httpUrl, String string2) {
            n.f(httpUrl, "url");
            n.f(string2, "setCookie");
            return parse$okhttp(System.currentTimeMillis(), obj1, httpUrl);
        }

        public final okhttp3.Cookie parse$okhttp(long l, okhttp3.HttpUrl httpUrl2, String string3) {
            int cmp;
            long cmp4;
            int effectiveTldPlusOne;
            String substring;
            int i3;
            int encodedPath;
            int cmp3;
            int i2;
            int indexOfControlOrNonAscii;
            int i4;
            int cmp2;
            Object obj;
            Object obj2;
            int i;
            String trimSubstring;
            int domain;
            boolean trimSubstring2;
            long l2;
            String str;
            int maxAge;
            int i5;
            int i6;
            int i7;
            int i8;
            int i9;
            int i10;
            int i11;
            long expires;
            final Object obj3 = this;
            obj = obj29;
            n.f(string3, "url");
            n.f(obj, "setCookie");
            int i19 = 0;
            cmp2 = 0;
            String str4 = obj29;
            int delimiterOffset$default2 = Util.delimiterOffset$default(str4, ';', i19, 0, 6, cmp2);
            int delimiterOffset$default = Util.delimiterOffset$default(str4, '=', i19, delimiterOffset$default2, 2, cmp2);
            i3 = 0;
            if (delimiterOffset$default == delimiterOffset$default2) {
                return i3;
            }
            int i20 = 0;
            int i23 = 1;
            final String trimSubstring$default = Util.trimSubstring$default(obj, i20, delimiterOffset$default, i23, i3);
            indexOfControlOrNonAscii = trimSubstring$default.length() == 0 ? i23 : i20;
            if (indexOfControlOrNonAscii == 0) {
                cmp2 = -1;
                if (Util.indexOfControlOrNonAscii(trimSubstring$default) != cmp2) {
                } else {
                    final String trimSubstring3 = Util.trimSubstring(obj, delimiterOffset$default += i23, delimiterOffset$default2);
                    if (Util.indexOfControlOrNonAscii(trimSubstring3) != cmp2) {
                        return i3;
                    }
                    delimiterOffset$default2 += i23;
                    int length = obj29.length();
                    i4 = -1;
                    i11 = domain;
                    i9 = i8;
                    i10 = i23;
                    maxAge = i4;
                    expires = 253402300799999L;
                    while (i < length) {
                        int delimiterOffset = Util.delimiterOffset(obj, ';', i, length);
                        int delimiterOffset2 = Util.delimiterOffset(obj, '=', i, delimiterOffset);
                        trimSubstring = Util.trimSubstring(obj, i, delimiterOffset2);
                        if (delimiterOffset2 < delimiterOffset) {
                        } else {
                        }
                        trimSubstring2 = "";
                        if (l.x(trimSubstring, "expires", i23)) {
                        } else {
                        }
                        if (l.x(trimSubstring, "max-age", i23)) {
                        } else {
                        }
                        if (l.x(trimSubstring, "domain", i23)) {
                        } else {
                        }
                        if (l.x(trimSubstring, "path", i23)) {
                        } else {
                        }
                        if (l.x(trimSubstring, "secure", i23)) {
                        } else {
                        }
                        if (l.x(trimSubstring, "httponly", i23)) {
                        }
                        i = delimiterOffset + 1;
                        i3 = 0;
                        i8 = i23;
                        i7 = i23;
                        i11 = trimSubstring2;
                        domain = obj3.parseDomain(trimSubstring2);
                        i10 = i20;
                        maxAge = obj3.parseMaxAge(trimSubstring2);
                        i9 = i23;
                        expires = obj3.parseExpires(trimSubstring2, i20, trimSubstring2.length());
                        trimSubstring2 = Util.trimSubstring(obj, delimiterOffset2++, delimiterOffset);
                    }
                    if (Long.compare(maxAge, cmp4) == 0) {
                        l2 = cmp4;
                    } else {
                    }
                    String host = string3.host();
                    if (domain == 0) {
                        i5 = host;
                        encodedPath = 0;
                    } else {
                        if (!obj3.domainMatch(host, domain)) {
                            return null;
                        }
                        encodedPath = 0;
                        i5 = domain;
                    }
                    if (host.length() != i5.length() && PublicSuffixDatabase.Companion.get().getEffectiveTldPlusOne(i5) == null) {
                        if (PublicSuffixDatabase.Companion.get().getEffectiveTldPlusOne(i5) == null) {
                            return encodedPath;
                        }
                    }
                    i2 = i11;
                    if (i2 != 0) {
                        if (!l.M(i2, "/", i20, 2, encodedPath)) {
                            encodedPath = string3.encodedPath();
                            i2 = l.i0(encodedPath, '/', 0, false, 6, 0);
                            if (i2 != 0) {
                                Objects.requireNonNull(encodedPath, "null cannot be cast to non-null type java.lang.String");
                                n.e(encodedPath.substring(i20, i2), "(this as java.lang.Strin…ing(startIndex, endIndex)");
                            }
                            i6 = substring;
                        } else {
                            i6 = i2;
                        }
                    } else {
                    }
                }
                super(trimSubstring$default, trimSubstring3, l2, str, i5, i6, i7, i8, i9, i10, 0);
                return cookie;
            }
            return i3;
        }

        public final List<okhttp3.Cookie> parseAll(okhttp3.HttpUrl httpUrl, okhttp3.Headers headers2) {
            int arrayList;
            int i;
            okhttp3.Cookie parse;
            List obj5;
            Object obj6;
            n.f(httpUrl, "url");
            n.f(headers2, "headers");
            obj6 = headers2.values("Set-Cookie");
            arrayList = 0;
            i = 0;
            while (i < obj6.size()) {
                parse = parse(httpUrl, (String)obj6.get(i));
                if (parse != null && arrayList == null) {
                }
                i++;
                if (arrayList == null) {
                }
                arrayList.add(parse);
                arrayList = new ArrayList();
            }
            if (arrayList != null) {
                n.e(Collections.unmodifiableList(arrayList), "Collections.unmodifiableList(cookies)");
            } else {
                obj5 = p.g();
            }
            return obj5;
        }
    }
    static {
        Cookie.Companion companion = new Cookie.Companion(0);
        Cookie.Companion = companion;
        Cookie.YEAR_PATTERN = Pattern.compile("(\\d{2,4})[^\\d]*");
        Cookie.MONTH_PATTERN = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
        Cookie.DAY_OF_MONTH_PATTERN = Pattern.compile("(\\d{1,2})[^\\d]*");
        Cookie.TIME_PATTERN = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
    }

    private Cookie(String string, String string2, long l3, String string4, String string5, boolean z6, boolean z7, boolean z8, boolean z9) {
        super();
        this.name = string;
        this.value = string2;
        this.expiresAt = l3;
        this.domain = string5;
        this.path = z6;
        this.secure = z7;
        this.httpOnly = z8;
        this.persistent = z9;
        this.hostOnly = obj10;
    }

    public Cookie(String string, String string2, long l3, String string4, String string5, boolean z6, boolean z7, boolean z8, boolean z9, g g10) {
        super(string, string2, l3, string4, string5, z6, z7, z8, z9, g10);
    }

    public static final Pattern access$getDAY_OF_MONTH_PATTERN$cp() {
        return Cookie.DAY_OF_MONTH_PATTERN;
    }

    public static final Pattern access$getMONTH_PATTERN$cp() {
        return Cookie.MONTH_PATTERN;
    }

    public static final Pattern access$getTIME_PATTERN$cp() {
        return Cookie.TIME_PATTERN;
    }

    public static final Pattern access$getYEAR_PATTERN$cp() {
        return Cookie.YEAR_PATTERN;
    }

    public static final okhttp3.Cookie parse(okhttp3.HttpUrl httpUrl, String string2) {
        return Cookie.Companion.parse(httpUrl, string2);
    }

    public static final List<okhttp3.Cookie> parseAll(okhttp3.HttpUrl httpUrl, okhttp3.Headers headers2) {
        return Cookie.Companion.parseAll(httpUrl, headers2);
    }

    public final String -deprecated_domain() {
        return this.domain;
    }

    public final long -deprecated_expiresAt() {
        return this.expiresAt;
    }

    public final boolean -deprecated_hostOnly() {
        return this.hostOnly;
    }

    public final boolean -deprecated_httpOnly() {
        return this.httpOnly;
    }

    public final String -deprecated_name() {
        return this.name;
    }

    public final String -deprecated_path() {
        return this.path;
    }

    public final boolean -deprecated_persistent() {
        return this.persistent;
    }

    public final boolean -deprecated_secure() {
        return this.secure;
    }

    public final String -deprecated_value() {
        return this.value;
    }

    public final String domain() {
        return this.domain;
    }

    public boolean equals(Object object) {
        boolean httpOnly;
        String httpOnly2;
        long expiresAt;
        Object obj5;
        if (object instanceof Cookie && n.b(object.name, this.name) && n.b(object.value, this.value) && Long.compare(expiresAt2, expiresAt) == 0 && n.b(object.domain, this.domain) && n.b(object.path, this.path) && object.secure == this.secure && object.httpOnly == this.httpOnly && object.persistent == this.persistent && object.hostOnly == this.hostOnly) {
            if (n.b(object.name, this.name)) {
                if (n.b(object.value, this.value)) {
                    if (Long.compare(expiresAt2, expiresAt) == 0) {
                        if (n.b(object.domain, this.domain)) {
                            if (n.b(object.path, this.path)) {
                                if (object.secure == this.secure) {
                                    if (object.httpOnly == this.httpOnly) {
                                        if (object.persistent == this.persistent) {
                                            obj5 = object.hostOnly == this.hostOnly ? 1 : 0;
                                        } else {
                                        }
                                    } else {
                                    }
                                } else {
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return obj5;
    }

    public final long expiresAt() {
        return this.expiresAt;
    }

    public int hashCode() {
        return i26 += i9;
    }

    public final boolean hostOnly() {
        return this.hostOnly;
    }

    public final boolean httpOnly() {
        return this.httpOnly;
    }

    public final boolean matches(okhttp3.HttpUrl httpUrl) {
        boolean z;
        String domain2;
        int i;
        String domain;
        Object obj4;
        n.f(httpUrl, "url");
        if (this.hostOnly) {
            z = n.b(httpUrl.host(), this.domain);
        } else {
            z = Cookie.Companion.access$domainMatch(Cookie.Companion, httpUrl.host(), this.domain);
        }
        i = 0;
        if (!z) {
            return i;
        }
        if (!Cookie.Companion.access$pathMatch(Cookie.Companion, httpUrl, this.path)) {
            return i;
        }
        if (this.secure) {
            if (httpUrl.isHttps()) {
                i = 1;
            }
        } else {
        }
        return i;
    }

    public final String name() {
        return this.name;
    }

    public final String path() {
        return this.path;
    }

    public final boolean persistent() {
        return this.persistent;
    }

    public final boolean secure() {
        return this.secure;
    }

    public String toString() {
        return toString$okhttp(false);
    }

    public final String toString$okhttp(boolean z) {
        boolean httpDateString;
        boolean hostOnly;
        long expiresAt;
        long l;
        String obj6;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.name);
        stringBuilder.append('=');
        stringBuilder.append(this.value);
        if (this.persistent) {
            l = Long.MIN_VALUE;
            if (Long.compare(expiresAt2, l) == 0) {
                stringBuilder.append("; max-age=0");
            } else {
                stringBuilder.append("; expires=");
                Date date = new Date(this.expiresAt, l);
                stringBuilder.append(DatesKt.toHttpDateString(date));
            }
        }
        stringBuilder.append("; domain=");
        if (!this.hostOnly && z != null) {
            stringBuilder.append("; domain=");
            if (z != null) {
                stringBuilder.append(".");
            }
            stringBuilder.append(this.domain);
        }
        stringBuilder.append("; path=");
        stringBuilder.append(this.path);
        if (this.secure) {
            stringBuilder.append("; secure");
        }
        if (this.httpOnly) {
            stringBuilder.append("; httponly");
        }
        obj6 = stringBuilder.toString();
        n.e(obj6, "toString()");
        return obj6;
    }

    public final String value() {
        return this.value;
    }
}
