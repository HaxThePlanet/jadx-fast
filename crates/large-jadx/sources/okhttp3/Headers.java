package okhttp3;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.d0.d.b;
import kotlin.d0.d.f0;
import kotlin.d0.d.g;
import kotlin.d0.d.j0.a;
import kotlin.d0.d.n;
import kotlin.h0.d;
import kotlin.h0.g;
import kotlin.k0.l;
import kotlin.o;
import kotlin.u;
import kotlin.y.i;
import kotlin.y.p;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0010\"\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0010(\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0010$\n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0002\u0008\u0007\u0018\u0000 32\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u000243B\u0017\u0008\u0002\u0012\u000c\u0010/\u001a\u0008\u0012\u0004\u0012\u00020\u00030.¢\u0006\u0004\u00081\u00102J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0086\u0002¢\u0006\u0004\u0008\u0005\u0010\u0006J\u0017\u0010\u0008\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\u0008\u0008\u0010\tJ\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\u0008\u000b\u0010\u000cJ\u000f\u0010\u0010\u001a\u00020\rH\u0007¢\u0006\u0004\u0008\u000e\u0010\u000fJ\u0015\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\r¢\u0006\u0004\u0008\u0004\u0010\u0012J\u0015\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\r¢\u0006\u0004\u0008\u0013\u0010\u0012J\u0013\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0014¢\u0006\u0004\u0008\u0015\u0010\u0016J\u001b\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u00172\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\u0008\u0018\u0010\u0019J\r\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\u0008\u001b\u0010\u001cJ\"\u0010\u001e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u001dH\u0096\u0002¢\u0006\u0004\u0008\u001e\u0010\u001fJ\r\u0010!\u001a\u00020 ¢\u0006\u0004\u0008!\u0010\"J\u001a\u0010&\u001a\u00020%2\u0008\u0010$\u001a\u0004\u0018\u00010#H\u0096\u0002¢\u0006\u0004\u0008&\u0010'J\u000f\u0010(\u001a\u00020\rH\u0016¢\u0006\u0004\u0008(\u0010\u000fJ\u000f\u0010)\u001a\u00020\u0003H\u0016¢\u0006\u0004\u0008)\u0010*J\u001f\u0010,\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00030\u00170+¢\u0006\u0004\u0008,\u0010-R\u001c\u0010/\u001a\u0008\u0012\u0004\u0012\u00020\u00030.8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008/\u00100R\u0013\u0010\u0010\u001a\u00020\r8G@\u0006¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u000f¨\u00065", d2 = {"Lokhttp3/Headers;", "", "Lkotlin/o;", "", "name", "get", "(Ljava/lang/String;)Ljava/lang/String;", "Ljava/util/Date;", "getDate", "(Ljava/lang/String;)Ljava/util/Date;", "Ljava/time/Instant;", "getInstant", "(Ljava/lang/String;)Ljava/time/Instant;", "", "-deprecated_size", "()I", "size", "index", "(I)Ljava/lang/String;", "value", "", "names", "()Ljava/util/Set;", "", "values", "(Ljava/lang/String;)Ljava/util/List;", "", "byteCount", "()J", "", "iterator", "()Ljava/util/Iterator;", "Lokhttp3/Headers$Builder;", "newBuilder", "()Lokhttp3/Headers$Builder;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "()Ljava/lang/String;", "", "toMultimap", "()Ljava/util/Map;", "", "namesAndValues", "[Ljava/lang/String;", "<init>", "([Ljava/lang/String;)V", "Companion", "Builder", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class Headers implements Iterable<o<? extends String, ? extends String>>, a {

    public static final okhttp3.Headers.Companion Companion;
    private final String[] namesAndValues;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010!\n\u0002\u0008\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\u0008\u001f\u0010 J\u0017\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\u0008\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\u0008\u0007\u0010\u0005J\u001d\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0008\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\u0008\u0007\u0010\nJ\u001d\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0008\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\u0008\u000b\u0010\nJ\u0015\u0010\u000e\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000c¢\u0006\u0004\u0008\u000e\u0010\u000fJ\u001d\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0008\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0010¢\u0006\u0004\u0008\u0007\u0010\u0011J\u001f\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0008\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0012H\u0007¢\u0006\u0004\u0008\u0007\u0010\u0013J \u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0008\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0010H\u0086\u0002¢\u0006\u0004\u0008\u0014\u0010\u0011J \u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0008\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0012H\u0087\u0002¢\u0006\u0004\u0008\u0014\u0010\u0013J\u001f\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0008\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0000¢\u0006\u0004\u0008\u0004\u0010\nJ\u0015\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0008\u001a\u00020\u0002¢\u0006\u0004\u0008\u0015\u0010\u0005J \u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0008\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0086\u0002¢\u0006\u0004\u0008\u0014\u0010\nJ\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0008\u001a\u00020\u0002H\u0086\u0002¢\u0006\u0004\u0008\u0016\u0010\u0017J\r\u0010\u0018\u001a\u00020\u000c¢\u0006\u0004\u0008\u0018\u0010\u0019R\"\u0010\u001b\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u001a8\u0000@\u0000X\u0080\u0004¢\u0006\u000c\n\u0004\u0008\u001b\u0010\u001c\u001a\u0004\u0008\u001d\u0010\u001e¨\u0006!", d2 = {"Lokhttp3/Headers$Builder;", "", "", "line", "addLenient$okhttp", "(Ljava/lang/String;)Lokhttp3/Headers$Builder;", "addLenient", "add", "name", "value", "(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Headers$Builder;", "addUnsafeNonAscii", "Lokhttp3/Headers;", "headers", "addAll", "(Lokhttp3/Headers;)Lokhttp3/Headers$Builder;", "Ljava/util/Date;", "(Ljava/lang/String;Ljava/util/Date;)Lokhttp3/Headers$Builder;", "Ljava/time/Instant;", "(Ljava/lang/String;Ljava/time/Instant;)Lokhttp3/Headers$Builder;", "set", "removeAll", "get", "(Ljava/lang/String;)Ljava/lang/String;", "build", "()Lokhttp3/Headers;", "", "namesAndValues", "Ljava/util/List;", "getNamesAndValues$okhttp", "()Ljava/util/List;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Builder {

        private final List<String> namesAndValues;
        public Builder() {
            super();
            ArrayList arrayList = new ArrayList(20);
            this.namesAndValues = arrayList;
        }

        public final okhttp3.Headers.Builder add(String string) {
            int i;
            n.f(string, "line");
            int i2 = l.d0(string, ':', 0, false, 6, 0);
            int i4 = 1;
            int i6 = 0;
            i = i2 != -1 ? i4 : i6;
            if (i == 0) {
            } else {
                String substring = string.substring(i6, i2);
                n.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                Objects.requireNonNull(substring, "null cannot be cast to non-null type kotlin.CharSequence");
                String obj8 = string.substring(i2 += i4);
                n.e(obj8, "(this as java.lang.String).substring(startIndex)");
                add(l.a1(substring).toString(), obj8);
                return this;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unexpected header: ");
            stringBuilder.append(string);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString().toString());
            throw illegalArgumentException;
        }

        public final okhttp3.Headers.Builder add(String string, String string2) {
            n.f(string, "name");
            n.f(string2, "value");
            okhttp3.Headers.Companion companion = Headers.Companion;
            Headers.Companion.access$checkName(companion, string);
            Headers.Companion.access$checkValue(companion, string2, string);
            addLenient$okhttp(string, string2);
            return this;
        }

        public final okhttp3.Headers.Builder add(String string, Instant instant2) {
            n.f(string, "name");
            n.f(instant2, "value");
            Date date = new Date(instant2.toEpochMilli(), obj2);
            add(string, date);
            return this;
        }

        public final okhttp3.Headers.Builder add(String string, Date date2) {
            n.f(string, "name");
            n.f(date2, "value");
            add(string, DatesKt.toHttpDateString(date2));
            return this;
        }

        public final okhttp3.Headers.Builder addAll(okhttp3.Headers headers) {
            int i;
            String name;
            String value;
            n.f(headers, "headers");
            i = 0;
            while (i < headers.size()) {
                addLenient$okhttp(headers.name(i), headers.value(i));
                i++;
            }
            return this;
        }

        public final okhttp3.Headers.Builder addLenient$okhttp(String string) {
            int charAt;
            String substring;
            String str;
            Object obj8;
            n.f(string, "line");
            int i = l.d0(string, ':', 1, false, 4, 0);
            String str3 = "(this as java.lang.String).substring(startIndex)";
            int i3 = 1;
            int i5 = 0;
            if (i != -1) {
                substring = string.substring(i5, i);
                n.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                obj8 = string.substring(i += i3);
                n.e(obj8, str3);
                addLenient$okhttp(substring, obj8);
            } else {
                str = "";
                if (string.charAt(i5) == 58) {
                    obj8 = string.substring(i3);
                    n.e(obj8, str3);
                    addLenient$okhttp(str, obj8);
                } else {
                    addLenient$okhttp(str, string);
                }
            }
            return this;
        }

        public final okhttp3.Headers.Builder addLenient$okhttp(String string, String string2) {
            n.f(string, "name");
            n.f(string2, "value");
            this.namesAndValues.add(string);
            this.namesAndValues.add(l.a1(string2).toString());
            return this;
        }

        public final okhttp3.Headers.Builder addUnsafeNonAscii(String string, String string2) {
            n.f(string, "name");
            n.f(string2, "value");
            Headers.Companion.access$checkName(Headers.Companion, string);
            addLenient$okhttp(string, string2);
            return this;
        }

        public final okhttp3.Headers build() {
            Object[] array = this.namesAndValues.toArray(new String[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            Headers headers = new Headers((String[])array, 0);
            return headers;
        }

        public final String get(String string) {
            int i2;
            boolean z;
            int i;
            n.f(string, "name");
            int i5 = 2;
            d dVar2 = g.k(g.i(size -= i5, 0), i5);
            i2 = dVar2.d();
            int i8 = dVar2.g();
            int i4 = dVar2.h();
            if (i4 >= 0) {
                if (i2 <= i8) {
                    i = 1;
                    while (l.x(string, (String)this.namesAndValues.get(i2), i)) {
                        i2 += i4;
                        i = 1;
                    }
                    return (String)this.namesAndValues.get(i2 += i);
                }
            } else {
                if (i2 >= i8) {
                }
            }
            return null;
        }

        public final List<String> getNamesAndValues$okhttp() {
            return this.namesAndValues;
        }

        public final okhttp3.Headers.Builder removeAll(String string) {
            int i2;
            boolean namesAndValues;
            int i;
            n.f(string, "name");
            i2 = 0;
            while (i2 < this.namesAndValues.size()) {
                if (l.x(string, (String)this.namesAndValues.get(i2), true)) {
                }
                i2 += 2;
                this.namesAndValues.remove(i2);
                this.namesAndValues.remove(i2);
                i2 += -2;
            }
            return this;
        }

        public final okhttp3.Headers.Builder set(String string, String string2) {
            n.f(string, "name");
            n.f(string2, "value");
            okhttp3.Headers.Companion companion = Headers.Companion;
            Headers.Companion.access$checkName(companion, string);
            Headers.Companion.access$checkValue(companion, string2, string);
            removeAll(string);
            addLenient$okhttp(string, string2);
            return this;
        }

        public final okhttp3.Headers.Builder set(String string, Instant instant2) {
            n.f(string, "name");
            n.f(instant2, "value");
            Date date = new Date(instant2.toEpochMilli(), obj2);
            return set(string, date);
        }

        public final okhttp3.Headers.Builder set(String string, Date date2) {
            n.f(string, "name");
            n.f(date2, "value");
            set(string, DatesKt.toHttpDateString(date2));
            return this;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010$\n\u0002\u0008\u0006\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0017\u0010\u0018J'\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u0002¢\u0006\u0004\u0008\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00082\u0006\u0010\u0005\u001a\u00020\u0003H\u0002¢\u0006\u0004\u0008\t\u0010\nJ\u001f\u0010\u000c\u001a\u00020\u00082\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0002¢\u0006\u0004\u0008\u000c\u0010\rJ#\u0010\u0011\u001a\u00020\u000e2\u0012\u0010\u0004\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00030\u0002\"\u00020\u0003H\u0007¢\u0006\u0004\u0008\u000f\u0010\u0010J#\u0010\u000f\u001a\u00020\u000e2\u0012\u0010\u0004\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00030\u0002\"\u00020\u0003H\u0007¢\u0006\u0004\u0008\u0012\u0010\u0010J\u001f\u0010\u0015\u001a\u00020\u000e*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0013H\u0007¢\u0006\u0004\u0008\u000f\u0010\u0014J#\u0010\u000f\u001a\u00020\u000e2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0013H\u0007¢\u0006\u0004\u0008\u0012\u0010\u0014¨\u0006\u0019", d2 = {"Lokhttp3/Headers$Companion;", "", "", "", "namesAndValues", "name", "get", "([Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "Lkotlin/w;", "checkName", "(Ljava/lang/String;)V", "value", "checkValue", "(Ljava/lang/String;Ljava/lang/String;)V", "Lokhttp3/Headers;", "of", "([Ljava/lang/String;)Lokhttp3/Headers;", "headersOf", "-deprecated_of", "", "(Ljava/util/Map;)Lokhttp3/Headers;", "toHeaders", "headers", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion(g g) {
            super();
        }

        public static final void access$checkName(okhttp3.Headers.Companion headers$Companion, String string2) {
            companion.checkName(string2);
        }

        public static final void access$checkValue(okhttp3.Headers.Companion headers$Companion, String string2, String string3) {
            companion.checkValue(string2, string3);
        }

        public static final String access$get(okhttp3.Headers.Companion headers$Companion, String[] string2Arr2, String string3) {
            return companion.get(string2Arr2, string3);
        }

        private final void checkName(String string) {
            int i;
            int i2;
            char charAt;
            int i3;
            int i4;
            int i6 = 1;
            int i8 = 0;
            i = string.length() > 0 ? i6 : i8;
            if (i == 0) {
            } else {
                i2 = i8;
                while (i2 < string.length()) {
                    charAt = string.charAt(i2);
                    if (33 > charAt) {
                    } else {
                    }
                    if (126 >= charAt) {
                    } else {
                    }
                    i3 = i8;
                    i2++;
                    i3 = i6;
                }
            }
            IllegalArgumentException obj8 = new IllegalArgumentException("name is empty".toString());
            throw obj8;
        }

        private final void checkValue(String string, String string2) {
            String format;
            int i5;
            char charAt;
            int i2;
            int i;
            int i3;
            int i4;
            String obj8;
            boolean obj9;
            int i6 = 0;
            i5 = i6;
            while (i5 < string.length()) {
                charAt = string.charAt(i5);
                i3 = 1;
                if (charAt != 9) {
                } else {
                }
                i2 = i3;
                i5++;
                if (32 > charAt) {
                } else {
                }
                if (126 >= charAt) {
                } else {
                }
                i2 = i6;
            }
        }

        private final String get(String[] stringArr, String string2) {
            int i2;
            boolean z;
            int i;
            int i5 = 2;
            d dVar2 = g.k(g.i(length -= i5, 0), i5);
            i2 = dVar2.d();
            int i8 = dVar2.g();
            int i4 = dVar2.h();
            if (i4 >= 0) {
                if (i2 <= i8) {
                    i = 1;
                    while (l.x(string2, stringArr[i2], i)) {
                        i2 += i4;
                        i = 1;
                    }
                    return stringArr[i2 += i];
                }
            } else {
                if (i2 >= i8) {
                }
            }
            return null;
        }

        public final okhttp3.Headers -deprecated_of(Map<String, String> map) {
            n.f(map, "headers");
            return of(map);
        }

        public final okhttp3.Headers -deprecated_of(String... stringArr) {
            n.f(stringArr, "namesAndValues");
            return of((String[])Arrays.copyOf(stringArr, stringArr.length));
        }

        public final okhttp3.Headers of(Map<String, String> map) {
            int i;
            String string;
            int i2;
            String str;
            n.f(map, "$this$toHeaders");
            String[] strArr = new String[size *= 2];
            Iterator obj6 = map.entrySet().iterator();
            i = 0;
            for (Map.Entry next2 : obj6) {
                Object key = next2.getKey();
                Object value = next2.getValue();
                str = "null cannot be cast to non-null type kotlin.CharSequence";
                Objects.requireNonNull((String)key, str);
                String string2 = l.a1(key).toString();
                Objects.requireNonNull((String)value, str);
                string = l.a1(value).toString();
                checkName(string2);
                checkValue(string, string2);
                strArr[i] = string2;
                strArr[i + 1] = string;
                i += 2;
            }
            obj6 = new Headers(strArr, 0);
            return obj6;
        }

        public final okhttp3.Headers of(String... stringArr) {
            int i3;
            int i2;
            int i4;
            int i5;
            String string;
            int i;
            String str;
            n.f(stringArr, "namesAndValues");
            int i8 = 2;
            int i10 = 0;
            i4 = 1;
            i3 = length %= i8 == 0 ? i4 : i10;
            if (i3 == 0) {
            } else {
                Object obj8 = stringArr.clone();
                Objects.requireNonNull(obj8, "null cannot be cast to non-null type kotlin.Array<kotlin.String>");
                i5 = i10;
                while (i5 < obj8.length) {
                    if ((String[])obj8[i5] != null) {
                    } else {
                    }
                    i = i10;
                    Object obj2 = obj8[i5];
                    Objects.requireNonNull(obj2, "null cannot be cast to non-null type kotlin.CharSequence");
                    obj8[i5] = l.a1(obj2).toString();
                    i5++;
                    i = i4;
                }
                d dVar = g.k(i.z(obj8), i8);
                i2 = dVar.d();
                int i11 = dVar.g();
                int i7 = dVar.h();
                if (i7 >= 0) {
                    if (i2 <= i11) {
                        i4 = obj8[i2];
                        checkName(i4);
                        checkValue(obj8[i2 + 1], i4);
                        while (i2 != i11) {
                            i2 += i7;
                            i4 = obj8[i2];
                            checkName(i4);
                            checkValue(obj8[i2 + 1], i4);
                        }
                    }
                } else {
                    if (i2 >= i11) {
                    }
                }
                Headers headers = new Headers(obj8, 0);
                return headers;
            }
            obj8 = new IllegalArgumentException("Expected alternating header names and values".toString());
            throw obj8;
        }
    }
    static {
        Headers.Companion companion = new Headers.Companion(0);
        Headers.Companion = companion;
    }

    private Headers(String[] stringArr) {
        super();
        this.namesAndValues = stringArr;
    }

    public Headers(String[] stringArr, g g2) {
        super(stringArr);
    }

    public static final okhttp3.Headers of(Map<String, String> map) {
        return Headers.Companion.of(map);
    }

    public static final okhttp3.Headers of(String... stringArr) {
        return Headers.Companion.of(stringArr);
    }

    @Override // java.lang.Iterable
    public final int -deprecated_size() {
        return size();
    }

    @Override // java.lang.Iterable
    public final long byteCount() {
        long l2;
        int i;
        long l;
        String[] namesAndValues = this.namesAndValues;
        l2 = (long)i2;
        i = 0;
        while (i < namesAndValues.length) {
            l2 += l;
            i++;
        }
        return l2;
    }

    @Override // java.lang.Iterable
    public boolean equals(Object object) {
        boolean namesAndValues;
        Object obj2;
        if (object instanceof Headers && Arrays.equals(this.namesAndValues, object.namesAndValues)) {
            obj2 = Arrays.equals(this.namesAndValues, object.namesAndValues) ? 1 : 0;
        } else {
        }
        return obj2;
    }

    @Override // java.lang.Iterable
    public final String get(String string) {
        n.f(string, "name");
        return Headers.Companion.access$get(Headers.Companion, this.namesAndValues, string);
    }

    @Override // java.lang.Iterable
    public final Date getDate(String string) {
        Date obj2;
        n.f(string, "name");
        obj2 = get(string);
        if (obj2 != null) {
            obj2 = DatesKt.toHttpDateOrNull(obj2);
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // java.lang.Iterable
    public final Instant getInstant(String string) {
        Instant obj2;
        n.f(string, "name");
        obj2 = getDate(string);
        if (obj2 != null) {
            obj2 = obj2.toInstant();
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // java.lang.Iterable
    public int hashCode() {
        return Arrays.hashCode(this.namesAndValues);
    }

    public Iterator<o<String, String>> iterator() {
        int i;
        o oVar;
        String value;
        int size = size();
        final o[] arr = new o[size];
        i = 0;
        while (i < size) {
            arr[i] = u.a(name(i), value(i));
            i++;
        }
        return b.a(arr);
    }

    @Override // java.lang.Iterable
    public final String name(int i) {
        return this.namesAndValues[i *= 2];
    }

    public final Set<String> names() {
        int i;
        String name;
        TreeSet treeSet = new TreeSet(l.y(f0.a));
        i = 0;
        while (i < size()) {
            treeSet.add(name(i));
            i++;
        }
        Set unmodifiableSet = Collections.unmodifiableSet(treeSet);
        n.e(unmodifiableSet, "Collections.unmodifiableSet(result)");
        return unmodifiableSet;
    }

    @Override // java.lang.Iterable
    public final okhttp3.Headers.Builder newBuilder() {
        Headers.Builder builder = new Headers.Builder();
        p.z(builder.getNamesAndValues$okhttp(), this.namesAndValues);
        return builder;
    }

    @Override // java.lang.Iterable
    public final int size() {
        return length /= 2;
    }

    public final Map<String, List<String>> toMultimap() {
        int i;
        String value;
        Object arrayList;
        String str;
        TreeMap treeMap = new TreeMap(l.y(f0.a));
        i = 0;
        while (i < size()) {
            String name = name(i);
            Locale uS = Locale.US;
            n.e(uS, "Locale.US");
            Objects.requireNonNull(name, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = name.toLowerCase(uS);
            n.e(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            if ((List)treeMap.get(lowerCase) == null) {
            }
            arrayList.add(value(i));
            i++;
            arrayList = new ArrayList(2);
            treeMap.put(lowerCase, arrayList);
        }
        return treeMap;
    }

    @Override // java.lang.Iterable
    public String toString() {
        int i;
        String str2;
        String value;
        String str;
        StringBuilder stringBuilder = new StringBuilder();
        i = 0;
        while (i < size()) {
            String name = name(i);
            value = value(i);
            stringBuilder.append(name);
            stringBuilder.append(": ");
            if (Util.isSensitiveHeader(name)) {
            }
            stringBuilder.append(value);
            stringBuilder.append("\n");
            i++;
            value = "██";
        }
        String string = stringBuilder.toString();
        n.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    @Override // java.lang.Iterable
    public final String value(int i) {
        return this.namesAndValues[obj2++];
    }

    public final List<String> values(String string) {
        int size;
        int arrayList;
        int i2;
        boolean value;
        int i;
        List obj6;
        n.f(string, "name");
        arrayList = 0;
        i2 = 0;
        while (i2 < size()) {
            if (l.x(string, name(i2), true) && arrayList == null) {
            }
            i2++;
            if (arrayList == null) {
            }
            arrayList.add(value(i2));
            arrayList = new ArrayList(2);
        }
        if (arrayList != null) {
            n.e(Collections.unmodifiableList(arrayList), "Collections.unmodifiableList(result)");
        } else {
            obj6 = p.g();
        }
        return obj6;
    }
}
