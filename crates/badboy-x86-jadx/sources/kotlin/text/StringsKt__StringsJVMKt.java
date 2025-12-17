package kotlin.text;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.AbstractList;
import kotlin.collections.AbstractList.Companion;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000~\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u0015\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\r\n\u0002\u0008\n\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\u0008\u0008\n\u0002\u0010\u000c\n\u0002\u0008\u0011\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000e\u001a\u0011\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0008\u001a\u00020\tH\u0087\u0008\u001a\u0011\u0010\u0007\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0087\u0008\u001a\u0011\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u000c\u001a\u00020\rH\u0087\u0008\u001a\u0019\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0087\u0008\u001a!\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0087\u0008\u001a)\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fH\u0087\u0008\u001a\u0011\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0087\u0008\u001a!\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0087\u0008\u001a!\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0087\u0008\u001a\u000c\u0010\u0017\u001a\u00020\u0002*\u00020\u0002H\u0007\u001a\u0014\u0010\u0017\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0007\u001a\u0015\u0010\u001a\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0011H\u0087\u0008\u001a\u0015\u0010\u001c\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0011H\u0087\u0008\u001a\u001d\u0010\u001d\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u0011H\u0087\u0008\u001a\u001c\u0010 \u001a\u00020\u0011*\u00020\u00022\u0006\u0010!\u001a\u00020\u00022\u0008\u0008\u0002\u0010\"\u001a\u00020#\u001a\u000c\u0010$\u001a\u00020\u0002*\u00020\u0014H\u0007\u001a \u0010$\u001a\u00020\u0002*\u00020\u00142\u0008\u0008\u0002\u0010%\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u0011H\u0007\u001a\u0019\u0010&\u001a\u00020#*\u0004\u0018\u00010'2\u0008\u0010!\u001a\u0004\u0018\u00010'H\u0087\u0004\u001a \u0010&\u001a\u00020#*\u0004\u0018\u00010'2\u0008\u0010!\u001a\u0004\u0018\u00010'2\u0006\u0010\"\u001a\u00020#H\u0007\u001a\u0015\u0010&\u001a\u00020#*\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0087\u0008\u001a\u0015\u0010&\u001a\u00020#*\u00020\u00022\u0006\u0010(\u001a\u00020'H\u0087\u0008\u001a\u000c\u0010)\u001a\u00020\u0002*\u00020\u0002H\u0007\u001a\u0014\u0010)\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0007\u001a\u000c\u0010*\u001a\u00020\u0002*\u00020\rH\u0007\u001a*\u0010*\u001a\u00020\u0002*\u00020\r2\u0008\u0008\u0002\u0010%\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u00112\u0008\u0008\u0002\u0010+\u001a\u00020#H\u0007\u001a\u000c\u0010,\u001a\u00020\r*\u00020\u0002H\u0007\u001a*\u0010,\u001a\u00020\r*\u00020\u00022\u0008\u0008\u0002\u0010%\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u00112\u0008\u0008\u0002\u0010+\u001a\u00020#H\u0007\u001a\u001c\u0010-\u001a\u00020#*\u00020\u00022\u0006\u0010.\u001a\u00020\u00022\u0008\u0008\u0002\u0010\"\u001a\u00020#\u001a \u0010/\u001a\u00020#*\u0004\u0018\u00010\u00022\u0008\u0010!\u001a\u0004\u0018\u00010\u00022\u0008\u0008\u0002\u0010\"\u001a\u00020#\u001a4\u00100\u001a\u00020\u0002*\u00020\u00022\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0016\u00101\u001a\u000c\u0012\u0008\u0008\u0001\u0012\u0004\u0018\u00010302\"\u0004\u0018\u000103H\u0087\u0008¢\u0006\u0002\u00104\u001a*\u00100\u001a\u00020\u0002*\u00020\u00022\u0016\u00101\u001a\u000c\u0012\u0008\u0008\u0001\u0012\u0004\u0018\u00010302\"\u0004\u0018\u000103H\u0087\u0008¢\u0006\u0002\u00105\u001a<\u00100\u001a\u00020\u0002*\u00020\u00042\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u00100\u001a\u00020\u00022\u0016\u00101\u001a\u000c\u0012\u0008\u0008\u0001\u0012\u0004\u0018\u00010302\"\u0004\u0018\u000103H\u0087\u0008¢\u0006\u0002\u00106\u001a2\u00100\u001a\u00020\u0002*\u00020\u00042\u0006\u00100\u001a\u00020\u00022\u0016\u00101\u001a\u000c\u0012\u0008\u0008\u0001\u0012\u0004\u0018\u00010302\"\u0004\u0018\u000103H\u0087\u0008¢\u0006\u0002\u00107\u001a\r\u00108\u001a\u00020\u0002*\u00020\u0002H\u0087\u0008\u001a\r\u00109\u001a\u00020\u0002*\u00020\u0002H\u0087\u0008\u001a\u0015\u00109\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0087\u0008\u001a\u001d\u0010:\u001a\u00020\u0011*\u00020\u00022\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u0011H\u0081\u0008\u001a\u001d\u0010:\u001a\u00020\u0011*\u00020\u00022\u0006\u0010>\u001a\u00020\u00022\u0006\u0010=\u001a\u00020\u0011H\u0081\u0008\u001a\u001d\u0010?\u001a\u00020\u0011*\u00020\u00022\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u0011H\u0081\u0008\u001a\u001d\u0010?\u001a\u00020\u0011*\u00020\u00022\u0006\u0010>\u001a\u00020\u00022\u0006\u0010=\u001a\u00020\u0011H\u0081\u0008\u001a\u001d\u0010@\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010A\u001a\u00020\u0011H\u0087\u0008\u001a4\u0010B\u001a\u00020#*\u00020'2\u0006\u0010C\u001a\u00020\u00112\u0006\u0010!\u001a\u00020'2\u0006\u0010D\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0008\u0008\u0002\u0010\"\u001a\u00020#\u001a4\u0010B\u001a\u00020#*\u00020\u00022\u0006\u0010C\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u00022\u0006\u0010D\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0008\u0008\u0002\u0010\"\u001a\u00020#\u001a\u0012\u0010E\u001a\u00020\u0002*\u00020'2\u0006\u0010F\u001a\u00020\u0011\u001a$\u0010G\u001a\u00020\u0002*\u00020\u00022\u0006\u0010H\u001a\u00020<2\u0006\u0010I\u001a\u00020<2\u0008\u0008\u0002\u0010\"\u001a\u00020#\u001a$\u0010G\u001a\u00020\u0002*\u00020\u00022\u0006\u0010J\u001a\u00020\u00022\u0006\u0010K\u001a\u00020\u00022\u0008\u0008\u0002\u0010\"\u001a\u00020#\u001a$\u0010L\u001a\u00020\u0002*\u00020\u00022\u0006\u0010H\u001a\u00020<2\u0006\u0010I\u001a\u00020<2\u0008\u0008\u0002\u0010\"\u001a\u00020#\u001a$\u0010L\u001a\u00020\u0002*\u00020\u00022\u0006\u0010J\u001a\u00020\u00022\u0006\u0010K\u001a\u00020\u00022\u0008\u0008\u0002\u0010\"\u001a\u00020#\u001a\"\u0010M\u001a\u0008\u0012\u0004\u0012\u00020\u00020N*\u00020'2\u0006\u0010O\u001a\u00020P2\u0008\u0008\u0002\u0010Q\u001a\u00020\u0011\u001a\u001c\u0010R\u001a\u00020#*\u00020\u00022\u0006\u0010S\u001a\u00020\u00022\u0008\u0008\u0002\u0010\"\u001a\u00020#\u001a$\u0010R\u001a\u00020#*\u00020\u00022\u0006\u0010S\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u00112\u0008\u0008\u0002\u0010\"\u001a\u00020#\u001a\u0015\u0010T\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u0011H\u0087\u0008\u001a\u001d\u0010T\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u0011H\u0087\u0008\u001a\u0017\u0010U\u001a\u00020\r*\u00020\u00022\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000fH\u0087\u0008\u001a\r\u0010V\u001a\u00020\u0014*\u00020\u0002H\u0087\u0008\u001a3\u0010V\u001a\u00020\u0014*\u00020\u00022\u0006\u0010W\u001a\u00020\u00142\u0008\u0008\u0002\u0010X\u001a\u00020\u00112\u0008\u0008\u0002\u0010%\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u0011H\u0087\u0008\u001a \u0010V\u001a\u00020\u0014*\u00020\u00022\u0008\u0008\u0002\u0010%\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u0011H\u0007\u001a\r\u0010Y\u001a\u00020\u0002*\u00020\u0002H\u0087\u0008\u001a\u0015\u0010Y\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0087\u0008\u001a\u0017\u0010Z\u001a\u00020P*\u00020\u00022\u0008\u0008\u0002\u0010[\u001a\u00020\u0011H\u0087\u0008\u001a\r\u0010\\\u001a\u00020\u0002*\u00020\u0002H\u0087\u0008\u001a\u0015\u0010\\\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0087\u0008\u001a\r\u0010]\u001a\u00020\u0002*\u00020\u0002H\u0087\u0008\u001a\u0015\u0010]\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0087\u0008\"%\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\u0008\u0012\u0004\u0012\u00020\u0002`\u0003*\u00020\u00048F¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006^", d2 = {"CASE_INSENSITIVE_ORDER", "Ljava/util/Comparator;", "", "Lkotlin/Comparator;", "Lkotlin/String$Companion;", "getCASE_INSENSITIVE_ORDER", "(Lkotlin/jvm/internal/StringCompanionObject;)Ljava/util/Comparator;", "String", "stringBuffer", "Ljava/lang/StringBuffer;", "stringBuilder", "Ljava/lang/StringBuilder;", "bytes", "", "charset", "Ljava/nio/charset/Charset;", "offset", "", "length", "chars", "", "codePoints", "", "capitalize", "locale", "Ljava/util/Locale;", "codePointAt", "index", "codePointBefore", "codePointCount", "beginIndex", "endIndex", "compareTo", "other", "ignoreCase", "", "concatToString", "startIndex", "contentEquals", "", "charSequence", "decapitalize", "decodeToString", "throwOnInvalidSequence", "encodeToByteArray", "endsWith", "suffix", "equals", "format", "args", "", "", "(Ljava/lang/String;Ljava/util/Locale;[Ljava/lang/Object;)Ljava/lang/String;", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "(Lkotlin/jvm/internal/StringCompanionObject;Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "(Lkotlin/jvm/internal/StringCompanionObject;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "intern", "lowercase", "nativeIndexOf", "ch", "", "fromIndex", "str", "nativeLastIndexOf", "offsetByCodePoints", "codePointOffset", "regionMatches", "thisOffset", "otherOffset", "repeat", "n", "replace", "oldChar", "newChar", "oldValue", "newValue", "replaceFirst", "split", "", "regex", "Ljava/util/regex/Pattern;", "limit", "startsWith", "prefix", "substring", "toByteArray", "toCharArray", "destination", "destinationOffset", "toLowerCase", "toPattern", "flags", "toUpperCase", "uppercase", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/text/StringsKt")
class StringsKt__StringsJVMKt extends kotlin.text.StringsKt__StringNumberConversionsKt {
    private static final String String(StringBuffer stringBuffer) {
        Intrinsics.checkNotNullParameter(stringBuffer, "stringBuffer");
        String string = new String(stringBuffer);
        return string;
    }

    private static final String String(StringBuilder stringBuilder) {
        Intrinsics.checkNotNullParameter(stringBuilder, "stringBuilder");
        String string = new String(stringBuilder);
        return string;
    }

    private static final String String(byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        String string = new String(bytes, Charsets.UTF_8);
        return string;
    }

    private static final String String(byte[] bytes, int offset, int length) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        String string = new String(bytes, offset, length, Charsets.UTF_8);
        return string;
    }

    private static final String String(byte[] bytes, int offset, int length, Charset charset) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Intrinsics.checkNotNullParameter(charset, "charset");
        String string = new String(bytes, offset, length, charset);
        return string;
    }

    private static final String String(byte[] bytes, Charset charset) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Intrinsics.checkNotNullParameter(charset, "charset");
        String string = new String(bytes, charset);
        return string;
    }

    private static final String String(char[] chars) {
        Intrinsics.checkNotNullParameter(chars, "chars");
        String string = new String(chars);
        return string;
    }

    private static final String String(char[] chars, int offset, int length) {
        Intrinsics.checkNotNullParameter(chars, "chars");
        String string = new String(chars, offset, length);
        return string;
    }

    private static final String String(int[] codePoints, int offset, int length) {
        Intrinsics.checkNotNullParameter(codePoints, "codePoints");
        String string = new String(codePoints, offset, length);
        return string;
    }

    @Deprecated(message = "Use replaceFirstChar instead.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final String capitalize(String $this$capitalize) {
        Intrinsics.checkNotNullParameter($this$capitalize, "<this>");
        Locale default = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(default, "getDefault(...)");
        return StringsKt.capitalize($this$capitalize, default);
    }

    @Deprecated(message = "Use replaceFirstChar instead.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final String capitalize(String $this$capitalize, Locale locale) {
        int charAt;
        String upperCase2;
        boolean lowerCase;
        String upperCase;
        Intrinsics.checkNotNullParameter($this$capitalize, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        int i = 1;
        upperCase2 = 0;
        charAt = (CharSequence)$this$capitalize.length() > 0 ? i : upperCase2;
        charAt = $this$capitalize.charAt(upperCase2);
        if (charAt != 0 && Character.isLowerCase(charAt)) {
            charAt = $this$capitalize.charAt(upperCase2);
            if (Character.isLowerCase(charAt)) {
                StringBuilder stringBuilder = new StringBuilder();
                final StringBuilder sb = stringBuilder;
                final int i2 = 0;
                final char titleCase = Character.toTitleCase(charAt);
                final String str5 = "substring(...)";
                if (titleCase != Character.toUpperCase(charAt)) {
                    sb.append(titleCase);
                } else {
                    String substring2 = $this$capitalize.substring(upperCase2, i);
                    Intrinsics.checkNotNullExpressionValue(substring2, str5);
                    Intrinsics.checkNotNull(substring2, "null cannot be cast to non-null type java.lang.String");
                    upperCase2 = substring2.toUpperCase(locale);
                    Intrinsics.checkNotNullExpressionValue(upperCase2, "toUpperCase(...)");
                    sb.append(upperCase2);
                }
                String substring = $this$capitalize.substring(i);
                Intrinsics.checkNotNullExpressionValue(substring, str5);
                sb.append(substring);
                String string = stringBuilder.toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                return string;
            }
        }
        return $this$capitalize;
    }

    private static final int codePointAt(String $this$codePointAt, int index) {
        Intrinsics.checkNotNullParameter($this$codePointAt, "<this>");
        return $this$codePointAt.codePointAt(index);
    }

    private static final int codePointBefore(String $this$codePointBefore, int index) {
        Intrinsics.checkNotNullParameter($this$codePointBefore, "<this>");
        return $this$codePointBefore.codePointBefore(index);
    }

    private static final int codePointCount(String $this$codePointCount, int beginIndex, int endIndex) {
        Intrinsics.checkNotNullParameter($this$codePointCount, "<this>");
        return $this$codePointCount.codePointCount(beginIndex, endIndex);
    }

    public static final int compareTo(String $this$compareTo, String other, boolean ignoreCase) {
        Intrinsics.checkNotNullParameter($this$compareTo, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (ignoreCase) {
            return $this$compareTo.compareToIgnoreCase(other);
        }
        return $this$compareTo.compareTo(other);
    }

    public static int compareTo$default(String string, String string2, boolean z3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        return StringsKt.compareTo(string, string2, obj2);
    }

    public static final String concatToString(char[] $this$concatToString) {
        Intrinsics.checkNotNullParameter($this$concatToString, "<this>");
        String string = new String($this$concatToString);
        return string;
    }

    public static final String concatToString(char[] $this$concatToString, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter($this$concatToString, "<this>");
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(startIndex, endIndex, $this$concatToString.length);
        String string = new String($this$concatToString, startIndex, endIndex - startIndex);
        return string;
    }

    public static String concatToString$default(char[] cArr, int i2, int i3, int i4, Object object5) {
        int obj1;
        int obj2;
        if (i4 & 1 != 0) {
            obj1 = 0;
        }
        if (i4 &= 2 != 0) {
            obj2 = cArr.length;
        }
        return StringsKt.concatToString(cArr, obj1, obj2);
    }

    public static final boolean contentEquals(java.lang.CharSequence $this$contentEquals, java.lang.CharSequence other) {
        boolean contentEqualsImpl;
        if ($this$contentEquals instanceof String != null && other != null) {
            if (other != null) {
                contentEqualsImpl = (String)$this$contentEquals.contentEquals(other);
            } else {
                contentEqualsImpl = StringsKt.contentEqualsImpl($this$contentEquals, other);
            }
        } else {
        }
        return contentEqualsImpl;
    }

    public static final boolean contentEquals(java.lang.CharSequence $this$contentEquals, java.lang.CharSequence other, boolean ignoreCase) {
        boolean contentEqualsIgnoreCaseImpl;
        if (ignoreCase) {
            contentEqualsIgnoreCaseImpl = StringsKt.contentEqualsIgnoreCaseImpl($this$contentEquals, other);
        } else {
            contentEqualsIgnoreCaseImpl = StringsKt.contentEquals($this$contentEquals, other);
        }
        return contentEqualsIgnoreCaseImpl;
    }

    private static final boolean contentEquals(String $this$contentEquals, java.lang.CharSequence charSequence) {
        Intrinsics.checkNotNullParameter($this$contentEquals, "<this>");
        Intrinsics.checkNotNullParameter(charSequence, "charSequence");
        return $this$contentEquals.contentEquals(charSequence);
    }

    private static final boolean contentEquals(String $this$contentEquals, StringBuffer stringBuilder) {
        Intrinsics.checkNotNullParameter($this$contentEquals, "<this>");
        Intrinsics.checkNotNullParameter(stringBuilder, "stringBuilder");
        return $this$contentEquals.contentEquals(stringBuilder);
    }

    @Deprecated(message = "Use replaceFirstChar instead.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final String decapitalize(String $this$decapitalize) {
        int lowerCase;
        Object string;
        int substring;
        int lowerCase2;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter($this$decapitalize, "<this>");
        substring = 1;
        lowerCase2 = 0;
        lowerCase = (CharSequence)$this$decapitalize.length() > 0 ? substring : lowerCase2;
        if (lowerCase != 0 && !Character.isLowerCase($this$decapitalize.charAt(lowerCase2))) {
            if (!Character.isLowerCase($this$decapitalize.charAt(lowerCase2))) {
                StringBuilder stringBuilder = new StringBuilder();
                String substring2 = $this$decapitalize.substring(lowerCase2, substring);
                str = "substring(...)";
                Intrinsics.checkNotNullExpressionValue(substring2, str);
                Intrinsics.checkNotNull(substring2, "null cannot be cast to non-null type java.lang.String");
                lowerCase2 = substring2.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                substring = $this$decapitalize.substring(substring);
                Intrinsics.checkNotNullExpressionValue(substring, str);
                string = stringBuilder.append(lowerCase2).append(substring).toString();
            } else {
                string = $this$decapitalize;
            }
        } else {
        }
        return string;
    }

    @Deprecated(message = "Use replaceFirstChar instead.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final String decapitalize(String $this$decapitalize, Locale locale) {
        int lowerCase;
        Object string;
        int substring;
        int lowerCase2;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter($this$decapitalize, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        substring = 1;
        lowerCase2 = 0;
        lowerCase = (CharSequence)$this$decapitalize.length() > 0 ? substring : lowerCase2;
        if (lowerCase != 0 && !Character.isLowerCase($this$decapitalize.charAt(lowerCase2))) {
            if (!Character.isLowerCase($this$decapitalize.charAt(lowerCase2))) {
                StringBuilder stringBuilder = new StringBuilder();
                String substring2 = $this$decapitalize.substring(lowerCase2, substring);
                str = "substring(...)";
                Intrinsics.checkNotNullExpressionValue(substring2, str);
                Intrinsics.checkNotNull(substring2, "null cannot be cast to non-null type java.lang.String");
                lowerCase2 = substring2.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                substring = $this$decapitalize.substring(substring);
                Intrinsics.checkNotNullExpressionValue(substring, str);
                string = stringBuilder.append(lowerCase2).append(substring).toString();
            } else {
                string = $this$decapitalize;
            }
        } else {
        }
        return string;
    }

    public static final String decodeToString(byte[] $this$decodeToString) {
        Intrinsics.checkNotNullParameter($this$decodeToString, "<this>");
        String string = new String($this$decodeToString, Charsets.UTF_8);
        return string;
    }

    public static final String decodeToString(byte[] $this$decodeToString, int startIndex, int endIndex, boolean throwOnInvalidSequence) {
        Intrinsics.checkNotNullParameter($this$decodeToString, "<this>");
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(startIndex, endIndex, $this$decodeToString.length);
        if (!throwOnInvalidSequence) {
            String string = new String($this$decodeToString, startIndex, endIndex - startIndex, Charsets.UTF_8);
            return string;
        }
        String string2 = Charsets.UTF_8.newDecoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).decode(ByteBuffer.wrap($this$decodeToString, startIndex, endIndex - startIndex)).toString();
        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
        return string2;
    }

    public static String decodeToString$default(byte[] bArr, int i2, int i3, boolean z4, int i5, Object object6) {
        int obj2;
        int obj3;
        int obj4;
        final int i = 0;
        if (i5 & 1 != 0) {
            obj2 = i;
        }
        if (i5 & 2 != 0) {
            obj3 = bArr.length;
        }
        if (i5 &= 4 != 0) {
            obj4 = i;
        }
        return StringsKt.decodeToString(bArr, obj2, obj3, obj4);
    }

    public static final byte[] encodeToByteArray(String $this$encodeToByteArray) {
        Intrinsics.checkNotNullParameter($this$encodeToByteArray, "<this>");
        byte[] bytes = $this$encodeToByteArray.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return bytes;
    }

    public static final byte[] encodeToByteArray(String $this$encodeToByteArray, int startIndex, int endIndex, boolean throwOnInvalidSequence) {
        byte[] bArr;
        boolean arrayOffset;
        int length;
        int i;
        Intrinsics.checkNotNullParameter($this$encodeToByteArray, "<this>");
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(startIndex, endIndex, $this$encodeToByteArray.length());
        if (!throwOnInvalidSequence) {
            String substring = $this$encodeToByteArray.substring(startIndex, endIndex);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            Intrinsics.checkNotNull(substring, "null cannot be cast to non-null type java.lang.String");
            byte[] bytes = substring.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            return bytes;
        }
        ByteBuffer encode = Charsets.UTF_8.newEncoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).encode(CharBuffer.wrap((CharSequence)$this$encodeToByteArray, startIndex, endIndex));
        byte[] array = encode.array();
        Intrinsics.checkNotNull(array);
        if (encode.hasArray() && encode.arrayOffset() == 0 && encode.remaining() == array.length) {
            if (encode.arrayOffset() == 0) {
                array = encode.array();
                Intrinsics.checkNotNull(array);
                if (encode.remaining() == array.length) {
                    Intrinsics.checkNotNull(encode.array());
                } else {
                    i = 0;
                    encode.get(new byte[encode.remaining()]);
                }
            } else {
            }
        } else {
        }
        return bArr;
    }

    public static byte[] encodeToByteArray$default(String string, int i2, int i3, boolean z4, int i5, Object object6) {
        int obj2;
        int obj3;
        int obj4;
        final int i = 0;
        if (i5 & 1 != 0) {
            obj2 = i;
        }
        if (i5 & 2 != 0) {
            obj3 = string.length();
        }
        if (i5 &= 4 != 0) {
            obj4 = i;
        }
        return StringsKt.encodeToByteArray(string, obj2, obj3, obj4);
    }

    public static final boolean endsWith(String $this$endsWith, String suffix, boolean ignoreCase) {
        Intrinsics.checkNotNullParameter($this$endsWith, "<this>");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        if (!ignoreCase) {
            return $this$endsWith.endsWith(suffix);
        }
        return StringsKt.regionMatches($this$endsWith, length - length2, suffix, 0, suffix.length(), true);
    }

    public static boolean endsWith$default(String string, String string2, boolean z3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        return StringsKt.endsWith(string, string2, obj2);
    }

    public static final boolean equals(String $this$equals, String other, boolean ignoreCase) {
        boolean equalsIgnoreCase;
        int i;
        if ($this$equals == null) {
            i = other == null ? 1 : 0;
            return i;
        }
        if (!ignoreCase) {
            equalsIgnoreCase = $this$equals.equals(other);
        } else {
            equalsIgnoreCase = $this$equals.equalsIgnoreCase(other);
        }
        return equalsIgnoreCase;
    }

    public static boolean equals$default(String string, String string2, boolean z3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        return StringsKt.equals(string, string2, obj2);
    }

    private static final String format(String $this$format, Locale locale, Object... args) {
        Intrinsics.checkNotNullParameter($this$format, "<this>");
        Intrinsics.checkNotNullParameter(args, "args");
        String format = String.format(locale, $this$format, Arrays.copyOf(args, args.length));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    private static final String format(String $this$format, Object... args) {
        Intrinsics.checkNotNullParameter($this$format, "<this>");
        Intrinsics.checkNotNullParameter(args, "args");
        String format = String.format($this$format, Arrays.copyOf(args, args.length));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    private static final String format(StringCompanionObject $this$format, String format, Object... args) {
        Intrinsics.checkNotNullParameter($this$format, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        Intrinsics.checkNotNullParameter(args, "args");
        String format2 = String.format(format, Arrays.copyOf(args, args.length));
        Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
        return format2;
    }

    private static final String format(StringCompanionObject $this$format, Locale locale, String format, Object... args) {
        Intrinsics.checkNotNullParameter($this$format, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        Intrinsics.checkNotNullParameter(args, "args");
        String format2 = String.format(locale, format, Arrays.copyOf(args, args.length));
        Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
        return format2;
    }

    public static final Comparator<String> getCASE_INSENSITIVE_ORDER(StringCompanionObject $this$CASE_INSENSITIVE_ORDER) {
        Intrinsics.checkNotNullParameter($this$CASE_INSENSITIVE_ORDER, "<this>");
        Comparator cASE_INSENSITIVE_ORDER = String.CASE_INSENSITIVE_ORDER;
        Intrinsics.checkNotNullExpressionValue(cASE_INSENSITIVE_ORDER, "CASE_INSENSITIVE_ORDER");
        return cASE_INSENSITIVE_ORDER;
    }

    private static final String intern(String $this$intern) {
        Intrinsics.checkNotNullParameter($this$intern, "<this>");
        String intern = $this$intern.intern();
        Intrinsics.checkNotNullExpressionValue(intern, "intern(...)");
        return intern;
    }

    private static final String lowercase(String $this$lowercase) {
        Intrinsics.checkNotNullParameter($this$lowercase, "<this>");
        String lowerCase = $this$lowercase.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    private static final String lowercase(String $this$lowercase, Locale locale) {
        Intrinsics.checkNotNullParameter($this$lowercase, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        String lowerCase = $this$lowercase.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    private static final int nativeIndexOf(String $this$nativeIndexOf, char ch, int fromIndex) {
        Intrinsics.checkNotNullParameter($this$nativeIndexOf, "<this>");
        return $this$nativeIndexOf.indexOf(ch, fromIndex);
    }

    private static final int nativeIndexOf(String $this$nativeIndexOf, String str, int fromIndex) {
        Intrinsics.checkNotNullParameter($this$nativeIndexOf, "<this>");
        Intrinsics.checkNotNullParameter(str, "str");
        return $this$nativeIndexOf.indexOf(str, fromIndex);
    }

    private static final int nativeLastIndexOf(String $this$nativeLastIndexOf, char ch, int fromIndex) {
        Intrinsics.checkNotNullParameter($this$nativeLastIndexOf, "<this>");
        return $this$nativeLastIndexOf.lastIndexOf(ch, fromIndex);
    }

    private static final int nativeLastIndexOf(String $this$nativeLastIndexOf, String str, int fromIndex) {
        Intrinsics.checkNotNullParameter($this$nativeLastIndexOf, "<this>");
        Intrinsics.checkNotNullParameter(str, "str");
        return $this$nativeLastIndexOf.lastIndexOf(str, fromIndex);
    }

    private static final int offsetByCodePoints(String $this$offsetByCodePoints, int index, int codePointOffset) {
        Intrinsics.checkNotNullParameter($this$offsetByCodePoints, "<this>");
        return $this$offsetByCodePoints.offsetByCodePoints(index, codePointOffset);
    }

    public static final boolean regionMatches(java.lang.CharSequence $this$regionMatches, int thisOffset, java.lang.CharSequence other, int otherOffset, int length, boolean ignoreCase) {
        boolean z;
        Intrinsics.checkNotNullParameter($this$regionMatches, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if ($this$regionMatches instanceof String != null && other instanceof String != null) {
            if (other instanceof String != null) {
                int i2 = thisOffset;
                int i6 = otherOffset;
                int i7 = length;
                final boolean z3 = ignoreCase;
                int i = i2;
                int i4 = i6;
                int otherOffset2 = i7;
                boolean length2 = z3;
                return StringsKt.regionMatches((String)$this$regionMatches, i2, (String)other, i6, i7, z3);
            }
        }
        return StringsKt.regionMatchesImpl($this$regionMatches, thisOffset, other, otherOffset, length, ignoreCase);
    }

    public static final boolean regionMatches(String $this$regionMatches, int thisOffset, String other, int otherOffset, int length, boolean ignoreCase) {
        boolean regionMatches;
        Object obj;
        boolean obj3;
        int obj4;
        Object obj5;
        int obj6;
        int obj7;
        Intrinsics.checkNotNullParameter($this$regionMatches, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (!ignoreCase) {
            regionMatches = $this$regionMatches.regionMatches(thisOffset, other, otherOffset, length);
            obj4 = thisOffset;
            obj3 = ignoreCase;
            obj7 = length;
            obj6 = otherOffset;
            obj5 = obj;
        } else {
            regionMatches = $this$regionMatches.regionMatches(ignoreCase, thisOffset, other, otherOffset, length);
        }
        return regionMatches;
    }

    public static boolean regionMatches$default(java.lang.CharSequence charSequence, int i2, java.lang.CharSequence charSequence3, int i4, int i5, boolean z6, int i7, Object object8) {
        int obj11;
        if (i7 &= 16 != 0) {
            obj11 = 0;
        }
        return StringsKt.regionMatches(charSequence, i2, charSequence3, i4, i5, obj11);
    }

    public static boolean regionMatches$default(String string, int i2, String string3, int i4, int i5, boolean z6, int i7, Object object8) {
        int obj11;
        if (i7 &= 16 != 0) {
            obj11 = 0;
        }
        return StringsKt.regionMatches(string, i2, string3, i4, i5, obj11);
    }

    public static final String repeat(java.lang.CharSequence $this$repeat, int n) {
        int stringBuilder;
        int i2;
        String string;
        int i;
        int length;
        char[] cArr;
        Intrinsics.checkNotNullParameter($this$repeat, "<this>");
        stringBuilder = 0;
        i2 = n >= 0 ? 1 : stringBuilder;
        if (i2 == 0) {
        } else {
            string = "";
            switch (n) {
                case 0:
                    break;
                case 1:
                    string = $this$repeat.toString();
                    break;
                default:
                    stringBuilder = new StringBuilder(length2 *= n);
                    length = 0;
                    cArr = new char[n];
                    cArr[stringBuilder] = $this$repeat.charAt(stringBuilder);
                    stringBuilder++;
                    stringBuilder = new String(cArr);
                    string = stringBuilder;
                    stringBuilder.append($this$repeat);
                    i++;
                    Intrinsics.checkNotNull(stringBuilder.toString());
            }
            return string;
        }
        int i3 = 0;
        StringBuilder stringBuilder2 = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder2.append("Count 'n' must be non-negative, but was ").append(n).append('.').toString().toString());
        throw illegalArgumentException;
    }

    public static final String replace(String $this$replace, char oldChar, char newChar, boolean ignoreCase) {
        int i;
        char charAt;
        char c;
        int i2;
        char c2;
        Intrinsics.checkNotNullParameter($this$replace, "<this>");
        if (!ignoreCase) {
            String replace = $this$replace.replace(oldChar, newChar);
            Intrinsics.checkNotNullExpressionValue(replace, "replace(...)");
            return replace;
        }
        StringBuilder stringBuilder = new StringBuilder($this$replace.length());
        final int i3 = 0;
        final Object obj = $this$replace;
        final int i4 = 0;
        i = 0;
        while (i < (CharSequence)obj.length()) {
            c = charAt;
            i2 = 0;
            if (CharsKt.equals(c, oldChar, ignoreCase)) {
            } else {
            }
            c2 = c;
            stringBuilder.append(c2);
            i++;
            c2 = newChar;
        }
        String string = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public static final String replace(String $this$replace, String oldValue, String newValue, boolean ignoreCase) {
        int occurrenceIndex;
        int i2;
        Object length;
        int i;
        Intrinsics.checkNotNullParameter($this$replace, "<this>");
        Intrinsics.checkNotNullParameter(oldValue, "oldValue");
        Intrinsics.checkNotNullParameter(newValue, "newValue");
        Object obj = $this$replace;
        final int i3 = 0;
        if (StringsKt.indexOf((CharSequence)obj, oldValue, 0, ignoreCase) < 0) {
            return obj;
        }
        int length2 = oldValue.length();
        i6 += length4;
        if (i7 < 0) {
        } else {
            StringBuilder stringBuilder2 = new StringBuilder(i7);
            i2 = 0;
            stringBuilder2.append((CharSequence)obj, i2, occurrenceIndex).append(newValue);
            while (occurrenceIndex < obj.length()) {
                if (StringsKt.indexOf((CharSequence)obj, oldValue, occurrenceIndex + coerceAtLeast, ignoreCase) > 0) {
                }
                stringBuilder2.append((CharSequence)obj, i2, occurrenceIndex).append(newValue);
            }
            String string = stringBuilder2.append((CharSequence)obj, occurrenceIndex + length2, obj.length()).toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }
        OutOfMemoryError stringBuilder = new OutOfMemoryError();
        throw stringBuilder;
    }

    public static String replace$default(String string, char c2, char c3, boolean z4, int i5, Object object6) {
        int obj3;
        if (i5 &= 4 != 0) {
            obj3 = 0;
        }
        return StringsKt.replace(string, c2, c3, obj3);
    }

    public static String replace$default(String string, String string2, String string3, boolean z4, int i5, Object object6) {
        int obj3;
        if (i5 &= 4 != 0) {
            obj3 = 0;
        }
        return StringsKt.replace(string, string2, string3, obj3);
    }

    public static final String replaceFirst(String $this$replaceFirst, char oldChar, char newChar, boolean ignoreCase) {
        String valueOf;
        Object obj;
        Object obj10;
        Intrinsics.checkNotNullParameter($this$replaceFirst, "<this>");
        final int obj8 = StringsKt.indexOf$default((CharSequence)$this$replaceFirst, oldChar, 0, ignoreCase, 2, 0);
        if (obj8 < 0) {
            obj10 = $this$replaceFirst;
        } else {
            obj10 = StringsKt.replaceRange((CharSequence)$this$replaceFirst, obj8, obj8 + 1, (CharSequence)String.valueOf(newChar)).toString();
        }
        return obj10;
    }

    public static final String replaceFirst(String $this$replaceFirst, String oldValue, String newValue, boolean ignoreCase) {
        Object str;
        Object obj;
        Object obj10;
        Intrinsics.checkNotNullParameter($this$replaceFirst, "<this>");
        Intrinsics.checkNotNullParameter(oldValue, "oldValue");
        Intrinsics.checkNotNullParameter(newValue, "newValue");
        final Object obj2 = oldValue;
        final int obj8 = StringsKt.indexOf$default((CharSequence)$this$replaceFirst, obj2, 0, ignoreCase, 2, 0);
        if (obj8 < 0) {
            obj10 = $this$replaceFirst;
        } else {
            obj10 = StringsKt.replaceRange((CharSequence)$this$replaceFirst, obj8, obj10 += obj8, (CharSequence)newValue).toString();
        }
        return obj10;
    }

    public static String replaceFirst$default(String string, char c2, char c3, boolean z4, int i5, Object object6) {
        int obj3;
        if (i5 &= 4 != 0) {
            obj3 = 0;
        }
        return StringsKt.replaceFirst(string, c2, c3, obj3);
    }

    public static String replaceFirst$default(String string, String string2, String string3, boolean z4, int i5, Object object6) {
        int obj3;
        if (i5 &= 4 != 0) {
            obj3 = 0;
        }
        return StringsKt.replaceFirst(string, string2, string3, obj3);
    }

    public static final List<String> split(java.lang.CharSequence $this$split, Pattern regex, int limit) {
        int i;
        Intrinsics.checkNotNullParameter($this$split, "<this>");
        Intrinsics.checkNotNullParameter(regex, "regex");
        StringsKt.requireNonNegativeLimit(limit);
        i = limit == 0 ? -1 : limit;
        String[] split = regex.split($this$split, i);
        Intrinsics.checkNotNullExpressionValue(split, "split(...)");
        return ArraysKt.asList((Object[])split);
    }

    public static List split$default(java.lang.CharSequence charSequence, Pattern pattern2, int i3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        return StringsKt.split(charSequence, pattern2, obj2);
    }

    public static final boolean startsWith(String $this$startsWith, String prefix, int startIndex, boolean ignoreCase) {
        Intrinsics.checkNotNullParameter($this$startsWith, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        if (!ignoreCase) {
            return $this$startsWith.startsWith(prefix, startIndex);
        }
        return StringsKt.regionMatches($this$startsWith, startIndex, prefix, 0, prefix.length(), ignoreCase);
    }

    public static final boolean startsWith(String $this$startsWith, String prefix, boolean ignoreCase) {
        Intrinsics.checkNotNullParameter($this$startsWith, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        if (!ignoreCase) {
            return $this$startsWith.startsWith(prefix);
        }
        return StringsKt.regionMatches($this$startsWith, 0, prefix, 0, prefix.length(), ignoreCase);
    }

    public static boolean startsWith$default(String string, String string2, int i3, boolean z4, int i5, Object object6) {
        int obj3;
        if (i5 &= 4 != 0) {
            obj3 = 0;
        }
        return StringsKt.startsWith(string, string2, i3, obj3);
    }

    public static boolean startsWith$default(String string, String string2, boolean z3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        return StringsKt.startsWith(string, string2, obj2);
    }

    private static final String substring(String $this$substring, int startIndex) {
        Intrinsics.checkNotNullParameter($this$substring, "<this>");
        String substring = $this$substring.substring(startIndex);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return substring;
    }

    private static final String substring(String $this$substring, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter($this$substring, "<this>");
        String substring = $this$substring.substring(startIndex, endIndex);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return substring;
    }

    private static final byte[] toByteArray(String $this$toByteArray, Charset charset) {
        Intrinsics.checkNotNullParameter($this$toByteArray, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        byte[] bytes = $this$toByteArray.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return bytes;
    }

    static byte[] toByteArray$default(String $this$toByteArray_u24default, Charset charset, int i3, Object object4) {
        Charset obj1;
        if (i3 &= 1 != 0) {
            obj1 = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter($this$toByteArray_u24default, "<this>");
        Intrinsics.checkNotNullParameter(obj1, "charset");
        byte[] obj2 = $this$toByteArray_u24default.getBytes(obj1);
        Intrinsics.checkNotNullExpressionValue(obj2, "getBytes(...)");
        return obj2;
    }

    private static final char[] toCharArray(String $this$toCharArray) {
        Intrinsics.checkNotNullParameter($this$toCharArray, "<this>");
        char[] charArray = $this$toCharArray.toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "toCharArray(...)");
        return charArray;
    }

    public static final char[] toCharArray(String $this$toCharArray, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter($this$toCharArray, "<this>");
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(startIndex, endIndex, $this$toCharArray.length());
        char[] cArr = new char[endIndex - startIndex];
        $this$toCharArray.getChars(startIndex, endIndex, cArr, 0);
        return cArr;
    }

    private static final char[] toCharArray(String $this$toCharArray, char[] destination, int destinationOffset, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter($this$toCharArray, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        $this$toCharArray.getChars(startIndex, endIndex, destination, destinationOffset);
        return destination;
    }

    public static char[] toCharArray$default(String string, int i2, int i3, int i4, Object object5) {
        int obj1;
        int obj2;
        if (i4 & 1 != 0) {
            obj1 = 0;
        }
        if (i4 &= 2 != 0) {
            obj2 = string.length();
        }
        return StringsKt.toCharArray(string, obj1, obj2);
    }

    static char[] toCharArray$default(String $this$toCharArray_u24default, char[] destination, int destinationOffset, int startIndex, int endIndex, int i6, Object object7) {
        int obj2;
        int obj3;
        int obj4;
        if (i6 & 2 != 0) {
            obj2 = 0;
        }
        if (i6 & 4 != 0) {
            obj3 = 0;
        }
        if (i6 &= 8 != 0) {
            obj4 = $this$toCharArray_u24default.length();
        }
        Intrinsics.checkNotNullParameter($this$toCharArray_u24default, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        $this$toCharArray_u24default.getChars(obj3, obj4, destination, obj2);
        return destination;
    }

    @Deprecated(message = "Use lowercase() instead.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    private static final String toLowerCase(String $this$toLowerCase) {
        Intrinsics.checkNotNullParameter($this$toLowerCase, "<this>");
        String lowerCase = $this$toLowerCase.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    @Deprecated(message = "Use lowercase() instead.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    private static final String toLowerCase(String $this$toLowerCase, Locale locale) {
        Intrinsics.checkNotNullParameter($this$toLowerCase, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        String lowerCase = $this$toLowerCase.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    private static final Pattern toPattern(String $this$toPattern, int flags) {
        Intrinsics.checkNotNullParameter($this$toPattern, "<this>");
        Pattern compile = Pattern.compile($this$toPattern, flags);
        Intrinsics.checkNotNullExpressionValue(compile, "compile(...)");
        return compile;
    }

    static Pattern toPattern$default(String $this$toPattern_u24default, int flags, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = 0;
        }
        Intrinsics.checkNotNullParameter($this$toPattern_u24default, "<this>");
        Pattern obj2 = Pattern.compile($this$toPattern_u24default, obj1);
        Intrinsics.checkNotNullExpressionValue(obj2, "compile(...)");
        return obj2;
    }

    @Deprecated(message = "Use uppercase() instead.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    private static final String toUpperCase(String $this$toUpperCase) {
        Intrinsics.checkNotNullParameter($this$toUpperCase, "<this>");
        String upperCase = $this$toUpperCase.toUpperCase();
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        return upperCase;
    }

    @Deprecated(message = "Use uppercase() instead.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    private static final String toUpperCase(String $this$toUpperCase, Locale locale) {
        Intrinsics.checkNotNullParameter($this$toUpperCase, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        String upperCase = $this$toUpperCase.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        return upperCase;
    }

    private static final String uppercase(String $this$uppercase) {
        Intrinsics.checkNotNullParameter($this$uppercase, "<this>");
        String upperCase = $this$uppercase.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        return upperCase;
    }

    private static final String uppercase(String $this$uppercase, Locale locale) {
        Intrinsics.checkNotNullParameter($this$uppercase, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        String upperCase = $this$uppercase.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        return upperCase;
    }
}
