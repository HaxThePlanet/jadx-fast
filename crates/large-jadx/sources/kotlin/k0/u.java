package kotlin.k0;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.d.f0;
import kotlin.d0.d.n;
import kotlin.h0.g;
import kotlin.y.h0;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000~\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u0015\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\r\n\u0002\u0008\n\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\u0008\n\n\u0002\u0010\u000c\n\u0002\u0008\u0011\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000e\u001a\u0011\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0008\u001a\u00020\tH\u0087\u0008\u001a\u0011\u0010\u0007\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0087\u0008\u001a\u0011\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u000c\u001a\u00020\rH\u0087\u0008\u001a\u0019\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0087\u0008\u001a!\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0087\u0008\u001a)\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fH\u0087\u0008\u001a\u0011\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0087\u0008\u001a!\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0087\u0008\u001a!\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0087\u0008\u001a\u000c\u0010\u0017\u001a\u00020\u0002*\u00020\u0002H\u0007\u001a\u0014\u0010\u0017\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0007\u001a\u0015\u0010\u001a\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0011H\u0087\u0008\u001a\u0015\u0010\u001c\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0011H\u0087\u0008\u001a\u001d\u0010\u001d\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u0011H\u0087\u0008\u001a\u001c\u0010 \u001a\u00020\u0011*\u00020\u00022\u0006\u0010!\u001a\u00020\u00022\u0008\u0008\u0002\u0010\"\u001a\u00020#\u001a\u000c\u0010$\u001a\u00020\u0002*\u00020\u0014H\u0007\u001a \u0010$\u001a\u00020\u0002*\u00020\u00142\u0008\u0008\u0002\u0010%\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u0011H\u0007\u001a\u0019\u0010&\u001a\u00020#*\u0004\u0018\u00010'2\u0008\u0010!\u001a\u0004\u0018\u00010'H\u0087\u0004\u001a \u0010&\u001a\u00020#*\u0004\u0018\u00010'2\u0008\u0010!\u001a\u0004\u0018\u00010'2\u0006\u0010\"\u001a\u00020#H\u0007\u001a\u0015\u0010&\u001a\u00020#*\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0087\u0008\u001a\u0015\u0010&\u001a\u00020#*\u00020\u00022\u0006\u0010(\u001a\u00020'H\u0087\u0008\u001a\u000c\u0010)\u001a\u00020\u0002*\u00020\u0002H\u0007\u001a\u0014\u0010)\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0007\u001a\u000c\u0010*\u001a\u00020\u0002*\u00020\rH\u0007\u001a*\u0010*\u001a\u00020\u0002*\u00020\r2\u0008\u0008\u0002\u0010%\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u00112\u0008\u0008\u0002\u0010+\u001a\u00020#H\u0007\u001a\u000c\u0010,\u001a\u00020\r*\u00020\u0002H\u0007\u001a*\u0010,\u001a\u00020\r*\u00020\u00022\u0008\u0008\u0002\u0010%\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u00112\u0008\u0008\u0002\u0010+\u001a\u00020#H\u0007\u001a\u001c\u0010-\u001a\u00020#*\u00020\u00022\u0006\u0010.\u001a\u00020\u00022\u0008\u0008\u0002\u0010\"\u001a\u00020#\u001a \u0010/\u001a\u00020#*\u0004\u0018\u00010\u00022\u0008\u0010!\u001a\u0004\u0018\u00010\u00022\u0008\u0008\u0002\u0010\"\u001a\u00020#\u001a2\u00100\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0016\u00101\u001a\u000c\u0012\u0008\u0008\u0001\u0012\u0004\u0018\u00010302\"\u0004\u0018\u000103H\u0087\u0008¢\u0006\u0002\u00104\u001a6\u00100\u001a\u00020\u0002*\u00020\u00022\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0016\u00101\u001a\u000c\u0012\u0008\u0008\u0001\u0012\u0004\u0018\u00010302\"\u0004\u0018\u000103H\u0087\u0008¢\u0006\u0004\u00085\u00104\u001a*\u00100\u001a\u00020\u0002*\u00020\u00022\u0016\u00101\u001a\u000c\u0012\u0008\u0008\u0001\u0012\u0004\u0018\u00010302\"\u0004\u0018\u000103H\u0087\u0008¢\u0006\u0002\u00106\u001a:\u00100\u001a\u00020\u0002*\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u00100\u001a\u00020\u00022\u0016\u00101\u001a\u000c\u0012\u0008\u0008\u0001\u0012\u0004\u0018\u00010302\"\u0004\u0018\u000103H\u0087\u0008¢\u0006\u0002\u00107\u001a>\u00100\u001a\u00020\u0002*\u00020\u00042\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u00100\u001a\u00020\u00022\u0016\u00101\u001a\u000c\u0012\u0008\u0008\u0001\u0012\u0004\u0018\u00010302\"\u0004\u0018\u000103H\u0087\u0008¢\u0006\u0004\u00085\u00107\u001a2\u00100\u001a\u00020\u0002*\u00020\u00042\u0006\u00100\u001a\u00020\u00022\u0016\u00101\u001a\u000c\u0012\u0008\u0008\u0001\u0012\u0004\u0018\u00010302\"\u0004\u0018\u000103H\u0087\u0008¢\u0006\u0002\u00108\u001a\r\u00109\u001a\u00020\u0002*\u00020\u0002H\u0087\u0008\u001a\n\u0010:\u001a\u00020#*\u00020'\u001a\r\u0010;\u001a\u00020\u0002*\u00020\u0002H\u0087\u0008\u001a\u0015\u0010;\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0087\u0008\u001a\u001d\u0010<\u001a\u00020\u0011*\u00020\u00022\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u0011H\u0081\u0008\u001a\u001d\u0010<\u001a\u00020\u0011*\u00020\u00022\u0006\u0010@\u001a\u00020\u00022\u0006\u0010?\u001a\u00020\u0011H\u0081\u0008\u001a\u001d\u0010A\u001a\u00020\u0011*\u00020\u00022\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u0011H\u0081\u0008\u001a\u001d\u0010A\u001a\u00020\u0011*\u00020\u00022\u0006\u0010@\u001a\u00020\u00022\u0006\u0010?\u001a\u00020\u0011H\u0081\u0008\u001a\u001d\u0010B\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010C\u001a\u00020\u0011H\u0087\u0008\u001a4\u0010D\u001a\u00020#*\u00020'2\u0006\u0010E\u001a\u00020\u00112\u0006\u0010!\u001a\u00020'2\u0006\u0010F\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0008\u0008\u0002\u0010\"\u001a\u00020#\u001a4\u0010D\u001a\u00020#*\u00020\u00022\u0006\u0010E\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u00022\u0006\u0010F\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0008\u0008\u0002\u0010\"\u001a\u00020#\u001a\u0012\u0010G\u001a\u00020\u0002*\u00020'2\u0006\u0010H\u001a\u00020\u0011\u001a$\u0010I\u001a\u00020\u0002*\u00020\u00022\u0006\u0010J\u001a\u00020>2\u0006\u0010K\u001a\u00020>2\u0008\u0008\u0002\u0010\"\u001a\u00020#\u001a$\u0010I\u001a\u00020\u0002*\u00020\u00022\u0006\u0010L\u001a\u00020\u00022\u0006\u0010M\u001a\u00020\u00022\u0008\u0008\u0002\u0010\"\u001a\u00020#\u001a$\u0010N\u001a\u00020\u0002*\u00020\u00022\u0006\u0010J\u001a\u00020>2\u0006\u0010K\u001a\u00020>2\u0008\u0008\u0002\u0010\"\u001a\u00020#\u001a$\u0010N\u001a\u00020\u0002*\u00020\u00022\u0006\u0010L\u001a\u00020\u00022\u0006\u0010M\u001a\u00020\u00022\u0008\u0008\u0002\u0010\"\u001a\u00020#\u001a\"\u0010O\u001a\u0008\u0012\u0004\u0012\u00020\u00020P*\u00020'2\u0006\u0010Q\u001a\u00020R2\u0008\u0008\u0002\u0010S\u001a\u00020\u0011\u001a\u001c\u0010T\u001a\u00020#*\u00020\u00022\u0006\u0010U\u001a\u00020\u00022\u0008\u0008\u0002\u0010\"\u001a\u00020#\u001a$\u0010T\u001a\u00020#*\u00020\u00022\u0006\u0010U\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u00112\u0008\u0008\u0002\u0010\"\u001a\u00020#\u001a\u0015\u0010V\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u0011H\u0087\u0008\u001a\u001d\u0010V\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u0011H\u0087\u0008\u001a\u0017\u0010W\u001a\u00020\r*\u00020\u00022\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000fH\u0087\u0008\u001a\r\u0010X\u001a\u00020\u0014*\u00020\u0002H\u0087\u0008\u001a3\u0010X\u001a\u00020\u0014*\u00020\u00022\u0006\u0010Y\u001a\u00020\u00142\u0008\u0008\u0002\u0010Z\u001a\u00020\u00112\u0008\u0008\u0002\u0010%\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u0011H\u0087\u0008\u001a \u0010X\u001a\u00020\u0014*\u00020\u00022\u0008\u0008\u0002\u0010%\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u0011H\u0007\u001a\r\u0010[\u001a\u00020\u0002*\u00020\u0002H\u0087\u0008\u001a\u0015\u0010[\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0087\u0008\u001a\u0017\u0010\\\u001a\u00020R*\u00020\u00022\u0008\u0008\u0002\u0010]\u001a\u00020\u0011H\u0087\u0008\u001a\r\u0010^\u001a\u00020\u0002*\u00020\u0002H\u0087\u0008\u001a\u0015\u0010^\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0087\u0008\u001a\r\u0010_\u001a\u00020\u0002*\u00020\u0002H\u0087\u0008\u001a\u0015\u0010_\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0087\u0008\"%\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\u0008\u0012\u0004\u0012\u00020\u0002`\u0003*\u00020\u00048F¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006`", d2 = {"CASE_INSENSITIVE_ORDER", "Ljava/util/Comparator;", "", "Lkotlin/Comparator;", "Lkotlin/String$Companion;", "getCASE_INSENSITIVE_ORDER", "(Lkotlin/jvm/internal/StringCompanionObject;)Ljava/util/Comparator;", "String", "stringBuffer", "Ljava/lang/StringBuffer;", "stringBuilder", "Ljava/lang/StringBuilder;", "bytes", "", "charset", "Ljava/nio/charset/Charset;", "offset", "", "length", "chars", "", "codePoints", "", "capitalize", "locale", "Ljava/util/Locale;", "codePointAt", "index", "codePointBefore", "codePointCount", "beginIndex", "endIndex", "compareTo", "other", "ignoreCase", "", "concatToString", "startIndex", "contentEquals", "", "charSequence", "decapitalize", "decodeToString", "throwOnInvalidSequence", "encodeToByteArray", "endsWith", "suffix", "equals", "format", "args", "", "", "(Ljava/lang/String;Ljava/util/Locale;[Ljava/lang/Object;)Ljava/lang/String;", "formatNullable", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "(Lkotlin/jvm/internal/StringCompanionObject;Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "(Lkotlin/jvm/internal/StringCompanionObject;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "intern", "isBlank", "lowercase", "nativeIndexOf", "ch", "", "fromIndex", "str", "nativeLastIndexOf", "offsetByCodePoints", "codePointOffset", "regionMatches", "thisOffset", "otherOffset", "repeat", "n", "replace", "oldChar", "newChar", "oldValue", "newValue", "replaceFirst", "split", "", "regex", "Ljava/util/regex/Pattern;", "limit", "startsWith", "prefix", "substring", "toByteArray", "toCharArray", "destination", "destinationOffset", "toLowerCase", "toPattern", "flags", "toUpperCase", "uppercase", "kotlin-stdlib"}, k = 5, mv = {1, 5, 1}, xi = 1, xs = "kotlin/text/StringsKt")
class u extends kotlin.k0.t {
    public static final boolean A(String string, int i2, String string3, int i4, int i5, boolean z6) {
        Object str;
        boolean z;
        int i6;
        Object obj;
        int i;
        int i3;
        boolean obj6;
        n.f(string, "$this$regionMatches");
        n.f(string3, "other");
        if (!z6) {
            obj6 = string.regionMatches(i2, string3, i4, i5);
        } else {
            obj6 = string.regionMatches(z6, i2, string3, i4, i5);
        }
        return obj6;
    }

    public static boolean B(String string, int i2, String string3, int i4, int i5, boolean z6, int i7, Object object8) {
        int obj11;
        if (i7 &= 16 != 0) {
            obj11 = 0;
        }
        return u.A(string, i2, string3, i4, i5, obj11);
    }

    public static String C(java.lang.CharSequence charSequence, int i2) {
        int stringBuilder;
        int cArr;
        int i;
        String string;
        int length;
        Object obj4;
        n.f(charSequence, "$this$repeat");
        stringBuilder = 0;
        cArr = 1;
        i = i2 >= 0 ? cArr : stringBuilder;
        if (i == 0) {
        } else {
            string = "";
            if (i2 != 0) {
                if (i2 != cArr) {
                    length = charSequence.length();
                    if (length != 0) {
                        if (length != cArr) {
                            stringBuilder = new StringBuilder(length2 *= i2);
                            if (cArr <= i2) {
                            }
                            n.e(stringBuilder.toString(), "sb.toString()");
                        } else {
                            cArr = new char[i2];
                            while (stringBuilder < i2) {
                                cArr[stringBuilder] = charSequence.charAt(stringBuilder);
                                stringBuilder++;
                            }
                            string = new String(cArr);
                        }
                    }
                } else {
                    string = charSequence.toString();
                }
            }
            return string;
        }
        obj4 = new StringBuilder();
        obj4.append("Count 'n' must be non-negative, but was ");
        obj4.append(i2);
        obj4.append('.');
        IllegalArgumentException obj5 = new IllegalArgumentException(obj4.toString().toString());
        throw obj5;
    }

    public static final String D(String string, char c2, char c3, boolean z4) {
        int i;
        char charAt;
        boolean z;
        n.f(string, "$this$replace");
        if (!z4) {
            String obj4 = string.replace(c2, c3);
            n.e(obj4, "(this as java.lang.Strin…replace(oldChar, newChar)");
            return obj4;
        }
        StringBuilder stringBuilder = new StringBuilder(string.length());
        i = 0;
        while (i < string.length()) {
            if (c.e(string.charAt(i), c2, z4)) {
            }
            stringBuilder.append(charAt);
            i++;
            charAt = c3;
        }
        obj4 = stringBuilder.toString();
        n.e(obj4, "StringBuilder(capacity).…builderAction).toString()");
        return obj4;
    }

    public static final String E(String string, String string2, String string3, boolean z4) {
        int i;
        int i2;
        int length;
        n.f(string, "$this$replace");
        n.f(string2, "oldValue");
        n.f(string3, "newValue");
        if (v.a0(string, string2, 0, z4) < 0) {
            return string;
        }
        final int length2 = string2.length();
        i6 += length4;
        if (length < 0) {
        } else {
            StringBuilder stringBuilder = new StringBuilder(length);
            stringBuilder.append(string, i, i2);
            stringBuilder.append(string3);
            while (i2 >= string.length()) {
                if (v.a0(string, string2, i2 += i5, z4) > 0) {
                    break;
                }
                stringBuilder.append(string, i, i2);
                stringBuilder.append(string3);
            }
            stringBuilder.append(string, i2 + length2, string.length());
            String obj6 = stringBuilder.toString();
            n.e(obj6, "stringBuilder.append(this, i, length).toString()");
            return obj6;
        }
        obj6 = new OutOfMemoryError();
        throw obj6;
    }

    public static String F(String string, char c2, char c3, boolean z4, int i5, Object object6) {
        int obj3;
        if (i5 &= 4 != 0) {
            obj3 = 0;
        }
        return u.D(string, c2, c3, obj3);
    }

    public static String G(String string, String string2, String string3, boolean z4, int i5, Object object6) {
        int obj3;
        if (i5 &= 4 != 0) {
            obj3 = 0;
        }
        return u.E(string, string2, string3, obj3);
    }

    public static final String H(String string, String string2, String string3, boolean z4) {
        Object obj7;
        Object obj8;
        n.f(string, "$this$replaceFirst");
        n.f(string2, "oldValue");
        n.f(string3, "newValue");
        final int obj10 = l.e0(string, string2, 0, z4, 2, 0);
        if (obj10 < 0) {
        } else {
            obj7 = v.y0(string, obj10, obj8 += obj10, string3).toString();
        }
        return obj7;
    }

    public static String I(String string, String string2, String string3, boolean z4, int i5, Object object6) {
        int obj3;
        if (i5 &= 4 != 0) {
            obj3 = 0;
        }
        return u.H(string, string2, string3, obj3);
    }

    public static boolean J(String string, String string2, int i3, boolean z4) {
        n.f(string, "$this$startsWith");
        n.f(string2, "prefix");
        if (!z4) {
            return string.startsWith(string2, i3);
        }
        return u.A(string, i3, string2, 0, string2.length(), z4);
    }

    public static boolean K(String string, String string2, boolean z3) {
        n.f(string, "$this$startsWith");
        n.f(string2, "prefix");
        if (!z3) {
            return string.startsWith(string2);
        }
        return u.A(string, 0, string2, 0, string2.length(), z3);
    }

    public static boolean L(String string, String string2, int i3, boolean z4, int i5, Object object6) {
        int obj3;
        if (i5 &= 4 != 0) {
            obj3 = 0;
        }
        return l.J(string, string2, i3, obj3);
    }

    public static boolean M(String string, String string2, boolean z3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        return l.K(string, string2, obj2);
    }

    public static String r(String string) {
        n.f(string, "$this$capitalize");
        Locale default = Locale.getDefault();
        n.e(default, "Locale.getDefault()");
        return u.s(string, default);
    }

    public static final String s(String string, Locale locale2) {
        int upperCase;
        int str;
        boolean stringBuilder;
        char titleCase;
        Object obj5;
        Object obj6;
        n.f(string, "$this$capitalize");
        n.f(locale2, "locale");
        final int i = 1;
        str = 0;
        upperCase = string.length() > 0 ? i : str;
        upperCase = string.charAt(str);
        if (upperCase != 0 && Character.isLowerCase(upperCase)) {
            upperCase = string.charAt(str);
            if (Character.isLowerCase(upperCase)) {
                stringBuilder = new StringBuilder();
                titleCase = Character.toTitleCase(upperCase);
                if (titleCase != Character.toUpperCase(upperCase)) {
                    stringBuilder.append(titleCase);
                } else {
                    String substring = string.substring(str, i);
                    n.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    Objects.requireNonNull(substring, "null cannot be cast to non-null type java.lang.String");
                    obj6 = substring.toUpperCase(locale2);
                    n.e(obj6, "(this as java.lang.String).toUpperCase(locale)");
                    stringBuilder.append(obj6);
                }
                obj5 = string.substring(i);
                n.e(obj5, "(this as java.lang.String).substring(startIndex)");
                stringBuilder.append(obj5);
                n.e(stringBuilder.toString(), "StringBuilder().apply(builderAction).toString()");
            }
        }
        return obj5;
    }

    public static int t(String string, String string2, boolean z3) {
        n.f(string, "$this$compareTo");
        n.f(string2, "other");
        if (z3) {
            return string.compareToIgnoreCase(string2);
        }
        return string.compareTo(string2);
    }

    public static String u(String string) {
        int stringBuilder;
        int str2;
        int lowerCase;
        String str;
        Object obj4;
        n.f(string, "$this$decapitalize");
        str2 = 1;
        lowerCase = 0;
        stringBuilder = string.length() > 0 ? str2 : lowerCase;
        if (stringBuilder != null && !Character.isLowerCase(string.charAt(lowerCase))) {
            if (!Character.isLowerCase(string.charAt(lowerCase))) {
                stringBuilder = new StringBuilder();
                String substring = string.substring(lowerCase, str2);
                n.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                Objects.requireNonNull(substring, "null cannot be cast to non-null type java.lang.String");
                lowerCase = substring.toLowerCase();
                n.e(lowerCase, "(this as java.lang.String).toLowerCase()");
                stringBuilder.append(lowerCase);
                obj4 = string.substring(str2);
                n.e(obj4, "(this as java.lang.String).substring(startIndex)");
                stringBuilder.append(obj4);
                obj4 = stringBuilder.toString();
            }
        }
        return obj4;
    }

    public static final boolean v(String string, String string2, boolean z3) {
        n.f(string, "$this$endsWith");
        n.f(string2, "suffix");
        if (!z3) {
            return string.endsWith(string2);
        }
        return u.A(string, obj9 - length, string2, 0, string2.length(), true);
    }

    public static boolean w(String string, String string2, boolean z3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        return u.v(string, string2, obj2);
    }

    public static boolean x(String string, String string2, boolean z3) {
        boolean obj0;
        if (string == null) {
            obj0 = string2 == null ? 1 : 0;
            return obj0;
        }
        if (!z3) {
            obj0 = string.equals(string2);
        } else {
            obj0 = string.equalsIgnoreCase(string2);
        }
        return obj0;
    }

    public static Comparator<String> y(f0 f0) {
        n.f(f0, "$this$CASE_INSENSITIVE_ORDER");
        final Comparator obj1 = String.CASE_INSENSITIVE_ORDER;
        n.e(obj1, "java.lang.String.CASE_INSENSITIVE_ORDER");
        return obj1;
    }

    public static boolean z(java.lang.CharSequence charSequence) {
        int iterator;
        int i;
        boolean empty;
        Object obj4;
        n.f(charSequence, "$this$isBlank");
        final int i2 = 1;
        if (charSequence.length() != 0) {
            iterator = l.X(charSequence);
            if (iterator instanceof Collection != null && (Collection)iterator.isEmpty()) {
                if ((Collection)iterator.isEmpty()) {
                    obj4 = i2;
                } else {
                    iterator = iterator.iterator();
                    while (iterator.hasNext()) {
                    }
                }
            } else {
            }
            if (obj4 != null) {
                i = i2;
            }
        } else {
        }
        return i;
    }
}
