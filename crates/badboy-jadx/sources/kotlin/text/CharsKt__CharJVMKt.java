package kotlin.text;

import java.util.Locale;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000c\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\u001a\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0001\u001a\u0018\u0010\u000c\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0000\u001a\r\u0010\u000e\u001a\u00020\u000f*\u00020\u0002H\u0087\u0008\u001a\r\u0010\u0010\u001a\u00020\u000f*\u00020\u0002H\u0087\u0008\u001a\r\u0010\u0011\u001a\u00020\u000f*\u00020\u0002H\u0087\u0008\u001a\r\u0010\u0012\u001a\u00020\u000f*\u00020\u0002H\u0087\u0008\u001a\r\u0010\u0013\u001a\u00020\u000f*\u00020\u0002H\u0087\u0008\u001a\r\u0010\u0014\u001a\u00020\u000f*\u00020\u0002H\u0087\u0008\u001a\r\u0010\u0015\u001a\u00020\u000f*\u00020\u0002H\u0087\u0008\u001a\r\u0010\u0016\u001a\u00020\u000f*\u00020\u0002H\u0087\u0008\u001a\r\u0010\u0017\u001a\u00020\u000f*\u00020\u0002H\u0087\u0008\u001a\r\u0010\u0018\u001a\u00020\u000f*\u00020\u0002H\u0087\u0008\u001a\r\u0010\u0019\u001a\u00020\u000f*\u00020\u0002H\u0087\u0008\u001a\r\u0010\u001a\u001a\u00020\u000f*\u00020\u0002H\u0087\u0008\u001a\r\u0010\u001b\u001a\u00020\u000f*\u00020\u0002H\u0087\u0008\u001a\n\u0010\u001c\u001a\u00020\u000f*\u00020\u0002\u001a\r\u0010\u001d\u001a\u00020\u001e*\u00020\u0002H\u0087\u0008\u001a\u0014\u0010\u001d\u001a\u00020\u001e*\u00020\u00022\u0006\u0010\u001f\u001a\u00020 H\u0007\u001a\r\u0010!\u001a\u00020\u0002*\u00020\u0002H\u0087\u0008\u001a\u0014\u0010\"\u001a\u00020\u001e*\u00020\u00022\u0006\u0010\u001f\u001a\u00020 H\u0007\u001a\r\u0010#\u001a\u00020\u0002*\u00020\u0002H\u0087\u0008\u001a\r\u0010$\u001a\u00020\u0002*\u00020\u0002H\u0087\u0008\u001a\r\u0010%\u001a\u00020\u0002*\u00020\u0002H\u0087\u0008\u001a\r\u0010&\u001a\u00020\u0002*\u00020\u0002H\u0087\u0008\u001a\r\u0010'\u001a\u00020\u001e*\u00020\u0002H\u0087\u0008\u001a\u0014\u0010'\u001a\u00020\u001e*\u00020\u00022\u0006\u0010\u001f\u001a\u00020 H\u0007\u001a\r\u0010(\u001a\u00020\u0002*\u00020\u0002H\u0087\u0008\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\u0008\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006)", d2 = {"category", "Lkotlin/text/CharCategory;", "", "getCategory", "(C)Lkotlin/text/CharCategory;", "directionality", "Lkotlin/text/CharDirectionality;", "getDirectionality", "(C)Lkotlin/text/CharDirectionality;", "checkRadix", "", "radix", "digitOf", "char", "isDefined", "", "isDigit", "isHighSurrogate", "isISOControl", "isIdentifierIgnorable", "isJavaIdentifierPart", "isJavaIdentifierStart", "isLetter", "isLetterOrDigit", "isLowSurrogate", "isLowerCase", "isTitleCase", "isUpperCase", "isWhitespace", "lowercase", "", "locale", "Ljava/util/Locale;", "lowercaseChar", "titlecase", "titlecaseChar", "toLowerCase", "toTitleCase", "toUpperCase", "uppercase", "uppercaseChar", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/text/CharsKt")
class CharsKt__CharJVMKt {
    public static final int checkRadix(int radix) {
        int i;
        int i2;
        i = 0;
        int i3 = 2;
        if (i3 <= radix && radix < 37) {
            if (radix < 37) {
                i = 1;
            }
        }
        if (i == 0) {
        } else {
            return radix;
        }
        StringBuilder stringBuilder = new StringBuilder();
        IntRange intRange = new IntRange(i3, 36);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("radix ").append(radix).append(" was not in valid range ").append(intRange).toString());
        throw illegalArgumentException;
    }

    public static final int digitOf(char char, int radix) {
        return Character.digit(char, radix);
    }

    public static final kotlin.text.CharCategory getCategory(char $this$category) {
        return CharCategory.Companion.valueOf(Character.getType($this$category));
    }

    public static final kotlin.text.CharDirectionality getDirectionality(char $this$directionality) {
        return CharDirectionality.Companion.valueOf(Character.getDirectionality($this$directionality));
    }

    private static final boolean isDefined(char $this$isDefined) {
        return Character.isDefined($this$isDefined);
    }

    private static final boolean isDigit(char $this$isDigit) {
        return Character.isDigit($this$isDigit);
    }

    private static final boolean isHighSurrogate(char $this$isHighSurrogate) {
        return Character.isHighSurrogate($this$isHighSurrogate);
    }

    private static final boolean isISOControl(char $this$isISOControl) {
        return Character.isISOControl($this$isISOControl);
    }

    private static final boolean isIdentifierIgnorable(char $this$isIdentifierIgnorable) {
        return Character.isIdentifierIgnorable($this$isIdentifierIgnorable);
    }

    private static final boolean isJavaIdentifierPart(char $this$isJavaIdentifierPart) {
        return Character.isJavaIdentifierPart($this$isJavaIdentifierPart);
    }

    private static final boolean isJavaIdentifierStart(char $this$isJavaIdentifierStart) {
        return Character.isJavaIdentifierStart($this$isJavaIdentifierStart);
    }

    private static final boolean isLetter(char $this$isLetter) {
        return Character.isLetter($this$isLetter);
    }

    private static final boolean isLetterOrDigit(char $this$isLetterOrDigit) {
        return Character.isLetterOrDigit($this$isLetterOrDigit);
    }

    private static final boolean isLowSurrogate(char $this$isLowSurrogate) {
        return Character.isLowSurrogate($this$isLowSurrogate);
    }

    private static final boolean isLowerCase(char $this$isLowerCase) {
        return Character.isLowerCase($this$isLowerCase);
    }

    private static final boolean isTitleCase(char $this$isTitleCase) {
        return Character.isTitleCase($this$isTitleCase);
    }

    private static final boolean isUpperCase(char $this$isUpperCase) {
        return Character.isUpperCase($this$isUpperCase);
    }

    public static final boolean isWhitespace(char $this$isWhitespace) {
        int i;
        boolean spaceChar;
        if (!Character.isWhitespace($this$isWhitespace)) {
            if (Character.isSpaceChar($this$isWhitespace)) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    private static final String lowercase(char $this$lowercase) {
        String valueOf = String.valueOf($this$lowercase);
        Intrinsics.checkNotNull(valueOf, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = valueOf.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    public static final String lowercase(char $this$lowercase, Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        String valueOf = String.valueOf($this$lowercase);
        Intrinsics.checkNotNull(valueOf, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = valueOf.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    private static final char lowercaseChar(char $this$lowercaseChar) {
        return Character.toLowerCase($this$lowercaseChar);
    }

    public static final String titlecase(char $this$titlecase, Locale locale) {
        String string;
        String lowerCase;
        StringBuilder stringBuilder;
        String str;
        Intrinsics.checkNotNullParameter(locale, "locale");
        String uppercase = CharsKt.uppercase($this$titlecase, locale);
        lowerCase = "null cannot be cast to non-null type java.lang.String";
        stringBuilder = 1;
        if (uppercase.length() > stringBuilder) {
            if ($this$titlecase == 329) {
                string = uppercase;
            } else {
                Intrinsics.checkNotNull(uppercase, lowerCase);
                String substring = uppercase.substring(stringBuilder);
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                Intrinsics.checkNotNull(substring, lowerCase);
                lowerCase = substring.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                stringBuilder = new StringBuilder();
                string = stringBuilder.append(uppercase.charAt(0)).append(lowerCase).toString();
            }
            return string;
        }
        String valueOf = String.valueOf($this$titlecase);
        Intrinsics.checkNotNull(valueOf, lowerCase);
        String upperCase = valueOf.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        if (!Intrinsics.areEqual(uppercase, upperCase)) {
            return uppercase;
        }
        return String.valueOf(Character.toTitleCase($this$titlecase));
    }

    private static final char titlecaseChar(char $this$titlecaseChar) {
        return Character.toTitleCase($this$titlecaseChar);
    }

    @Deprecated(message = "Use lowercaseChar() instead.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    private static final char toLowerCase(char $this$toLowerCase) {
        return Character.toLowerCase($this$toLowerCase);
    }

    @Deprecated(message = "Use titlecaseChar() instead.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    private static final char toTitleCase(char $this$toTitleCase) {
        return Character.toTitleCase($this$toTitleCase);
    }

    @Deprecated(message = "Use uppercaseChar() instead.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    private static final char toUpperCase(char $this$toUpperCase) {
        return Character.toUpperCase($this$toUpperCase);
    }

    private static final String uppercase(char $this$uppercase) {
        String valueOf = String.valueOf($this$uppercase);
        Intrinsics.checkNotNull(valueOf, "null cannot be cast to non-null type java.lang.String");
        String upperCase = valueOf.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        return upperCase;
    }

    public static final String uppercase(char $this$uppercase, Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        String valueOf = String.valueOf($this$uppercase);
        Intrinsics.checkNotNull(valueOf, "null cannot be cast to non-null type java.lang.String");
        String upperCase = valueOf.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        return upperCase;
    }

    private static final char uppercaseChar(char $this$uppercaseChar) {
        return Character.toUpperCase($this$uppercaseChar);
    }
}
