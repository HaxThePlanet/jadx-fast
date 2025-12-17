package kotlin.text;

import java.util.Arrays;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.collections.AbstractList;
import kotlin.collections.AbstractList.Companion;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000v\n\u0000\n\u0002\u0010\u0015\n\u0002\u0008\u0007\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0013\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0012\n\u0002\u0008\u0002\n\u0002\u0010\u0019\n\u0002\u0008\u0004\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\n\n\u0002\u0008\u0005\n\u0002\u0010\u0001\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u001a \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0002\u001a\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u000eH\u0002\u001a(\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0011H\u0002\u001a@\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0011H\u0000\u001a@\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0011H\u0000\u001a \u0010\u001f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002\u001a5\u0010 \u001a\u00020\u0011*\u00020\u000b2\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u000bH\u0082\u0008\u001a\u001c\u0010'\u001a\u00020\u0011*\u00020\u000b2\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0011H\u0002\u001a$\u0010(\u001a\u00020)*\u00020\u000b2\u0006\u0010*\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u00112\u0006\u0010+\u001a\u00020\u0011H\u0002\u001a<\u0010,\u001a\u00020)*\u00020\u000b2\u0006\u0010*\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u00112\u0006\u0010-\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020%2\u0006\u0010+\u001a\u00020\u0011H\u0002\u001a\u001c\u0010/\u001a\u00020)*\u00020\u000b2\u0006\u0010*\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0011H\u0002\u001a\u0015\u00100\u001a\u00020\u0011*\u00020\u000b2\u0006\u0010!\u001a\u00020\u0011H\u0082\u0008\u001a,\u00101\u001a\u00020\u0011*\u0002022\u0006\u0010!\u001a\u00020\u00112\u0006\u00103\u001a\u00020\u00012\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u0011H\u0002\u001a<\u00101\u001a\u00020\u0011*\u0002022\u0006\u0010!\u001a\u00020\u00112\u0006\u00107\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\u000b2\u0006\u00103\u001a\u00020\u00012\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u0011H\u0002\u001a*\u00109\u001a\u00020:*\u00020\u000b2\u0008\u0008\u0002\u0010*\u001a\u00020\u00112\u0008\u0008\u0002\u0010\"\u001a\u00020\u00112\u0008\u0008\u0002\u0010;\u001a\u00020<H\u0003\u001a\u0016\u00109\u001a\u00020:*\u00020\u000b2\u0008\u0008\u0002\u0010;\u001a\u00020<H\u0007\u001a*\u0010=\u001a\u000202*\u00020\u000b2\u0008\u0008\u0002\u0010*\u001a\u00020\u00112\u0008\u0008\u0002\u0010\"\u001a\u00020\u00112\u0008\u0008\u0002\u0010;\u001a\u00020<H\u0003\u001a\u0016\u0010=\u001a\u000202*\u00020\u000b2\u0008\u0008\u0002\u0010;\u001a\u00020<H\u0007\u001a&\u0010>\u001a\u0004\u0018\u000102*\u00020\u000b2\u0006\u0010*\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u00112\u0006\u0010?\u001a\u00020@H\u0003\u001a&\u0010A\u001a\u0004\u0018\u000102*\u00020\u000b2\u0006\u0010*\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u00112\u0006\u0010?\u001a\u00020@H\u0003\u001a&\u0010B\u001a\u0004\u0018\u000102*\u00020\u000b2\u0006\u0010*\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u00112\u0006\u0010?\u001a\u00020@H\u0003\u001a$\u0010C\u001a\u000202*\u00020\u000b2\u0006\u0010*\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u00112\u0006\u0010?\u001a\u00020@H\u0003\u001a*\u0010D\u001a\u00020\u0011*\u00020\u000b2\u0008\u0008\u0002\u0010*\u001a\u00020\u00112\u0008\u0008\u0002\u0010\"\u001a\u00020\u00112\u0008\u0008\u0002\u0010;\u001a\u00020<H\u0003\u001a\u0016\u0010D\u001a\u00020\u0011*\u00020\u000b2\u0008\u0008\u0002\u0010;\u001a\u00020<H\u0007\u001a,\u0010E\u001a\u00020\u0011*\u00020\u000b2\u0006\u0010*\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u00112\u0006\u0010;\u001a\u00020<2\u0006\u0010+\u001a\u00020\u0011H\u0003\u001a*\u0010F\u001a\u00020\u000e*\u00020\u000b2\u0008\u0008\u0002\u0010*\u001a\u00020\u00112\u0008\u0008\u0002\u0010\"\u001a\u00020\u00112\u0008\u0008\u0002\u0010;\u001a\u00020<H\u0001\u001a\u0016\u0010F\u001a\u00020\u000e*\u00020\u000b2\u0008\u0008\u0002\u0010;\u001a\u00020<H\u0007\u001a,\u0010G\u001a\u00020\u000e*\u00020\u000b2\u0006\u0010*\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u00112\u0006\u0010;\u001a\u00020<2\u0006\u0010+\u001a\u00020\u0011H\u0003\u001a*\u0010H\u001a\u00020I*\u00020\u000b2\u0008\u0008\u0002\u0010*\u001a\u00020\u00112\u0008\u0008\u0002\u0010\"\u001a\u00020\u00112\u0008\u0008\u0002\u0010;\u001a\u00020<H\u0003\u001a\u0016\u0010H\u001a\u00020I*\u00020\u000b2\u0008\u0008\u0002\u0010;\u001a\u00020<H\u0007\u001a\u0015\u0010J\u001a\u00020\u000e*\u00020\u000b2\u0006\u0010!\u001a\u00020\u0011H\u0082\u0008\u001a\u0014\u0010K\u001a\u00020:*\u00020\u000b2\u0006\u0010!\u001a\u00020\u0011H\u0002\u001a\u001c\u0010L\u001a\u00020\u0011*\u00020\u000b2\u0006\u0010*\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0011H\u0002\u001a\u001c\u0010M\u001a\u00020\u000e*\u00020\u000b2\u0006\u0010*\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0011H\u0002\u001a\u0014\u0010N\u001a\u00020O*\u00020\u000b2\u0006\u0010!\u001a\u00020\u0011H\u0002\u001a,\u0010P\u001a\u00020)*\u00020\u000b2\u0006\u0010*\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u00112\u0006\u0010Q\u001a\u00020\u000b2\u0006\u0010R\u001a\u00020\u0011H\u0002\u001a,\u0010S\u001a\u00020)*\u00020\u000b2\u0006\u0010*\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u00112\u0006\u0010-\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u000bH\u0002\u001a,\u0010T\u001a\u00020)*\u00020\u000b2\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u000bH\u0002\u001a\u001c\u0010U\u001a\u00020\u0011*\u00020\u000b2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u0011H\u0002\u001a\u0016\u0010V\u001a\u00020\u000b*\u00020:2\u0008\u0008\u0002\u0010;\u001a\u00020<H\u0007\u001a*\u0010V\u001a\u00020\u000b*\u0002022\u0008\u0008\u0002\u0010*\u001a\u00020\u00112\u0008\u0008\u0002\u0010\"\u001a\u00020\u00112\u0008\u0008\u0002\u0010;\u001a\u00020<H\u0007\u001a\u0016\u0010V\u001a\u00020\u000b*\u0002022\u0008\u0008\u0002\u0010;\u001a\u00020<H\u0007\u001a\u0016\u0010V\u001a\u00020\u000b*\u00020\u00112\u0008\u0008\u0002\u0010;\u001a\u00020<H\u0007\u001a\u0016\u0010V\u001a\u00020\u000b*\u00020\u000e2\u0008\u0008\u0002\u0010;\u001a\u00020<H\u0007\u001a\u0016\u0010V\u001a\u00020\u000b*\u00020I2\u0008\u0008\u0002\u0010;\u001a\u00020<H\u0007\u001a$\u0010W\u001a\u00020\u000b*\u00020\u000e2\u0006\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020\u000b2\u0006\u0010[\u001a\u00020\u0011H\u0003\u001a,\u0010\\\u001a\u00020\u000b*\u0002022\u0006\u0010*\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u00112\u0006\u0010?\u001a\u00020@2\u0006\u00103\u001a\u00020\u0001H\u0003\u001a,\u0010]\u001a\u00020\u000b*\u0002022\u0006\u0010*\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u00112\u0006\u0010?\u001a\u00020@2\u0006\u00103\u001a\u00020\u0001H\u0003\u001a,\u0010^\u001a\u00020\u000b*\u0002022\u0006\u0010*\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u00112\u0006\u0010?\u001a\u00020@2\u0006\u00103\u001a\u00020\u0001H\u0003\u001a,\u0010_\u001a\u00020\u000b*\u0002022\u0006\u0010*\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u00112\u0006\u0010?\u001a\u00020@2\u0006\u00103\u001a\u00020\u0001H\u0003\"\u001c\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0002\u0010\u0003\u001a\u0004\u0008\u0004\u0010\u0005\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000c\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000¨\u0006`", d2 = {"BYTE_TO_LOWER_CASE_HEX_DIGITS", "", "getBYTE_TO_LOWER_CASE_HEX_DIGITS$annotations", "()V", "getBYTE_TO_LOWER_CASE_HEX_DIGITS", "()[I", "BYTE_TO_UPPER_CASE_HEX_DIGITS", "HEX_DIGITS_TO_DECIMAL", "HEX_DIGITS_TO_LONG_DECIMAL", "", "LOWER_CASE_HEX_DIGITS", "", "UPPER_CASE_HEX_DIGITS", "charsPerSet", "", "charsPerElement", "elementsPerSet", "", "elementSeparatorLength", "checkFormatLength", "formatLength", "formattedStringLength", "numberOfBytes", "byteSeparatorLength", "bytePrefixLength", "byteSuffixLength", "bytesPerLine", "bytesPerGroup", "groupSeparatorLength", "parsedByteArrayMaxSize", "stringLength", "wholeElementsPerSet", "checkContainsAt", "index", "endIndex", "part", "ignoreCase", "", "partName", "checkNewLineAt", "checkNumberOfDigits", "", "startIndex", "typeHexLength", "checkPrefixSuffixNumberOfDigits", "prefix", "suffix", "checkZeroDigits", "decimalFromHexDigitAt", "formatByteAt", "", "byteToDigits", "destination", "", "destinationOffset", "bytePrefix", "byteSuffix", "hexToByte", "", "format", "Lkotlin/text/HexFormat;", "hexToByteArray", "hexToByteArrayNoLineAndGroupSeparator", "bytesFormat", "Lkotlin/text/HexFormat$BytesHexFormat;", "hexToByteArrayNoLineAndGroupSeparatorSlowPath", "hexToByteArrayShortByteSeparatorNoPrefixAndSuffix", "hexToByteArraySlowPath", "hexToInt", "hexToIntImpl", "hexToLong", "hexToLongImpl", "hexToShort", "", "longDecimalFromHexDigitAt", "parseByteAt", "parseInt", "parseLong", "throwInvalidDigitAt", "", "throwInvalidNumberOfDigits", "specifier", "expected", "throwInvalidPrefixSuffix", "throwNotContainedAt", "toCharArrayIfNotEmpty", "toHexString", "toHexStringImpl", "numberFormat", "Lkotlin/text/HexFormat$NumberHexFormat;", "digits", "bits", "toHexStringNoLineAndGroupSeparator", "toHexStringNoLineAndGroupSeparatorSlowPath", "toHexStringShortByteSeparatorNoPrefixAndSuffix", "toHexStringSlowPath", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class HexExtensionsKt {

    private static final int[] BYTE_TO_LOWER_CASE_HEX_DIGITS = null;
    private static final int[] BYTE_TO_UPPER_CASE_HEX_DIGITS = null;
    private static final int[] HEX_DIGITS_TO_DECIMAL = null;
    private static final long[] HEX_DIGITS_TO_LONG_DECIMAL = null;
    private static final String LOWER_CASE_HEX_DIGITS = "0123456789abcdef";
    private static final String UPPER_CASE_HEX_DIGITS = "0123456789ABCDEF";
    static {
        int i7;
        int i2;
        int i3;
        int i10;
        int i12;
        int i8;
        int i13;
        int i;
        int i9;
        int i14;
        int i16;
        int charAt;
        int i15;
        int i6;
        int charAt2;
        int length;
        int i4;
        int i5;
        char charAt4;
        int charAt3;
        int length2;
        int i11;
        char c;
        int i17;
        int i18 = 256;
        int[] iArr = new int[i18];
        i7 = 0;
        i2 = i7;
        String str = "0123456789abcdef";
        while (i2 < i18) {
            iArr[i2] = charAt5 |= i13;
            i2++;
            str = "0123456789abcdef";
        }
        HexExtensionsKt.BYTE_TO_LOWER_CASE_HEX_DIGITS = iArr;
        int[] iArr2 = new int[i18];
        i3 = i7;
        String str2 = "0123456789ABCDEF";
        while (i3 < i18) {
            iArr2[i3] = charAt6 |= i;
            i3++;
            str2 = "0123456789ABCDEF";
        }
        HexExtensionsKt.BYTE_TO_UPPER_CASE_HEX_DIGITS = iArr2;
        int[] iArr3 = new int[i18];
        i10 = i7;
        while (i10 < i18) {
            iArr3[i10] = -1;
            i10++;
        }
        int[] iArr4 = iArr3;
        i9 = 0;
        String str3 = str;
        int i24 = 0;
        i6 = 0;
        i4 = i7;
        while (i4 < (CharSequence)str3.length()) {
            i17 = 0;
            iArr4[str3.charAt(i4)] = i6;
            i4++;
            i6 = i11;
        }
        String $this$forEachIndexed$iv2 = str2;
        int i25 = 0;
        charAt2 = 0;
        i5 = i7;
        while (i5 < (CharSequence)$this$forEachIndexed$iv2.length()) {
            i17 = 0;
            iArr4[$this$forEachIndexed$iv2.charAt(i5)] = charAt2;
            i5++;
            charAt2 = i11;
        }
        HexExtensionsKt.HEX_DIGITS_TO_DECIMAL = iArr3;
        long[] lArr2 = new long[i18];
        i12 = i7;
        while (i12 < i18) {
            lArr2[i12] = -1;
            i12++;
        }
        long[] lArr = lArr2;
        int i19 = 0;
        int i22 = 0;
        charAt = 0;
        i15 = i7;
        while (i15 < (CharSequence)str.length()) {
            i11 = 0;
            lArr[str.charAt(i15)] = (long)charAt;
            i15++;
            charAt = i5;
        }
        String $this$forEachIndexed$iv = str2;
        int i20 = 0;
        i14 = 0;
        while (i7 < (CharSequence)$this$forEachIndexed$iv.length()) {
            i5 = 0;
            lArr[$this$forEachIndexed$iv.charAt(i7)] = (long)i14;
            i7++;
            i14 = i15;
        }
        HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL = lArr2;
    }

    private static final long charsPerSet(long charsPerElement, int elementsPerSet, int elementSeparatorLength) {
        int i;
        i = elementSeparatorLength > 0 ? 1 : 0;
        if (i == 0) {
        } else {
            return i2 += i4;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Failed requirement.".toString());
        throw illegalArgumentException;
    }

    private static final int checkContainsAt(String $this$checkContainsAt, int index, int endIndex, String part, boolean ignoreCase, String partName) {
        int i2;
        int i;
        boolean equals;
        char charAt;
        final int i3 = 0;
        i2 = (CharSequence)part.length() == 0 ? 1 : 0;
        if (i2 != 0) {
            return index;
        }
        i = 0;
        while (i < (CharSequence)part.length()) {
            if (!CharsKt.equals(part.charAt(i), $this$checkContainsAt.charAt(index + i), ignoreCase)) {
            }
            i++;
            HexExtensionsKt.throwNotContainedAt($this$checkContainsAt, index, endIndex, part, partName);
        }
        return length2 += index;
    }

    private static final int checkFormatLength(long formatLength) {
        int cmp;
        int i;
        int i2;
        i = 0;
        if (Long.compare(i3, formatLength) <= 0 && Long.compare(formatLength, i2) <= 0) {
            if (Long.compare(formatLength, i2) <= 0) {
                i = 1;
            }
        }
        if (i == 0) {
        } else {
            return (int)formatLength;
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("The resulting string length is too big: ").append(ULong.toString-impl(ULong.constructor-impl(formatLength))).toString());
        throw illegalArgumentException;
    }

    private static final int checkNewLineAt(String $this$checkNewLineAt, int index, int endIndex) {
        int i;
        int charAt;
        int i4 = 10;
        if ($this$checkNewLineAt.charAt(index) == 13) {
            if (index + 1 < endIndex && $this$checkNewLineAt.charAt(index + 1) == i4) {
                i = $this$checkNewLineAt.charAt(index + 1) == i4 ? index + 2 : index + 1;
            } else {
            }
            return i;
        } else {
            if ($this$checkNewLineAt.charAt(index) != i4) {
            } else {
                i = index + 1;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        NumberFormatException numberFormatException = new NumberFormatException(stringBuilder.append("Expected a new line at index ").append(index).append(", but was ").append($this$checkNewLineAt.charAt(index)).toString());
        throw numberFormatException;
    }

    private static final void checkNumberOfDigits(String $this$checkNumberOfDigits, int startIndex, int endIndex, int typeHexLength) {
        int i;
        String str;
        final int i2 = endIndex - startIndex;
        i = 1;
        if (i2 < i) {
            HexExtensionsKt.throwInvalidNumberOfDigits($this$checkNumberOfDigits, startIndex, endIndex, "at least", i);
        } else {
            if (i2 > typeHexLength) {
                HexExtensionsKt.checkZeroDigits($this$checkNumberOfDigits, startIndex, i3 -= typeHexLength);
            }
        }
    }

    private static final void checkPrefixSuffixNumberOfDigits(String $this$checkPrefixSuffixNumberOfDigits, int startIndex, int endIndex, String prefix, String suffix, boolean ignoreCase, int typeHexLength) {
        int i2;
        int i$iv;
        int i;
        int i$iv2;
        int length;
        int length2;
        boolean equals;
        int length3;
        char charAt;
        if (i3 -= length5 <= suffix.length()) {
            HexExtensionsKt.throwInvalidPrefixSuffix($this$checkPrefixSuffixNumberOfDigits, startIndex, endIndex, prefix, suffix);
        }
        String str2 = $this$checkPrefixSuffixNumberOfDigits;
        int i6 = 0;
        length = 1;
        i2 = (CharSequence)prefix.length() == 0 ? length : i$iv2;
        if (i2 != 0) {
            i = startIndex;
        } else {
            i$iv = 0;
            while (i$iv < (CharSequence)prefix.length()) {
                if (!CharsKt.equals(prefix.charAt(i$iv), str2.charAt(startIndex + i$iv), ignoreCase)) {
                }
                i$iv++;
                HexExtensionsKt.throwNotContainedAt(str2, startIndex, endIndex, prefix, "prefix");
            }
            length8 += startIndex;
        }
        int i5 = endIndex - length4;
        String str4 = $this$checkPrefixSuffixNumberOfDigits;
        int i7 = 0;
        if ((CharSequence)suffix.length() == 0) {
            i$iv2 = length;
        }
        if (i$iv2 == 0) {
            i$iv2 = 0;
            while (i$iv2 < (CharSequence)suffix.length()) {
                if (CharsKt.equals(suffix.charAt(i$iv2), str4.charAt(i5 + i$iv2), ignoreCase) == 0) {
                }
                i$iv2++;
                HexExtensionsKt.throwNotContainedAt(str4, i5, endIndex, suffix, "suffix");
            }
            suffix.length();
        }
        HexExtensionsKt.checkNumberOfDigits($this$checkPrefixSuffixNumberOfDigits, i, i5, typeHexLength);
    }

    private static final void checkZeroDigits(String $this$checkZeroDigits, int startIndex, int endIndex) {
        int index;
        char charAt;
        int i;
        index = startIndex;
        while (index < endIndex) {
            index++;
        }
    }

    private static final int decimalFromHexDigitAt(String $this$decimalFromHexDigitAt, int index) {
        int i;
        final int i2 = 0;
        final char charAt = $this$decimalFromHexDigitAt.charAt(index);
        if (charAt >>> 8 != 0) {
        } else {
            if (HexExtensionsKt.HEX_DIGITS_TO_DECIMAL[charAt] < 0) {
            } else {
                return HexExtensionsKt.HEX_DIGITS_TO_DECIMAL[charAt];
            }
        }
        HexExtensionsKt.throwInvalidDigitAt($this$decimalFromHexDigitAt, index);
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    private static final int formatByteAt(byte[] $this$formatByteAt, int index, String bytePrefix, String byteSuffix, int[] byteToDigits, char[] destination, int destinationOffset) {
        return HexExtensionsKt.toCharArrayIfNotEmpty(byteSuffix, destination, HexExtensionsKt.formatByteAt($this$formatByteAt, index, byteToDigits, destination, HexExtensionsKt.toCharArrayIfNotEmpty(bytePrefix, destination, destinationOffset)));
    }

    private static final int formatByteAt(byte[] $this$formatByteAt, int index, int[] byteToDigits, char[] destination, int destinationOffset) {
        final int i2 = byteToDigits[b &= 255];
        destination[destinationOffset] = (char)i3;
        destination[destinationOffset + 1] = (char)i6;
        return destinationOffset + 2;
    }

    private static final int formattedStringLength(int numberOfBytes, int byteSeparatorLength, int bytePrefixLength, int byteSuffixLength) {
        int i;
        i = numberOfBytes > 0 ? 1 : 0;
        if (i == 0) {
        } else {
            return HexExtensionsKt.checkFormatLength(i3 -= l5);
        }
        IllegalArgumentException formatLength = new IllegalArgumentException("Failed requirement.".toString());
        throw formatLength;
    }

    public static final int formattedStringLength(int numberOfBytes, int bytesPerLine, int bytesPerGroup, int groupSeparatorLength, int byteSeparatorLength, int bytePrefixLength, int byteSuffixLength) {
        int i;
        int it;
        final int i2 = numberOfBytes;
        i = i2 > 0 ? 1 : 0;
        if (i == 0) {
        } else {
            i3 /= bytesPerLine;
            int i5 = 0;
            int i14 = 0;
            if (i2 % bytesPerLine == 0) {
                it = bytesPerLine;
            }
            i16 += i15;
            return HexExtensionsKt.checkFormatLength(i12 += i20);
        }
        Object obj = groupSeparatorLength;
        Object obj3 = byteSeparatorLength;
        Object obj5 = bytePrefixLength;
        Object obj7 = byteSuffixLength;
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Failed requirement.".toString());
        throw illegalArgumentException;
    }

    public static final int[] getBYTE_TO_LOWER_CASE_HEX_DIGITS() {
        return HexExtensionsKt.BYTE_TO_LOWER_CASE_HEX_DIGITS;
    }

    public static void getBYTE_TO_LOWER_CASE_HEX_DIGITS$annotations() {
    }

    private static final byte hexToByte(String $this$hexToByte, int startIndex, int endIndex, kotlin.text.HexFormat format) {
        return (byte)hexToIntImpl;
    }

    public static final byte hexToByte(String $this$hexToByte, kotlin.text.HexFormat format) {
        Intrinsics.checkNotNullParameter($this$hexToByte, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return HexExtensionsKt.hexToByte($this$hexToByte, 0, $this$hexToByte.length(), format);
    }

    static byte hexToByte$default(String string, int i2, int i3, kotlin.text.HexFormat hexFormat4, int i5, Object object6) {
        int obj1;
        int obj2;
        kotlin.text.HexFormat obj3;
        if (i5 & 1 != 0) {
            obj1 = 0;
        }
        if (i5 & 2 != 0) {
            obj2 = string.length();
        }
        if (i5 &= 4 != 0) {
            obj3 = HexFormat.Companion.getDefault();
        }
        return HexExtensionsKt.hexToByte(string, obj1, obj2, obj3);
    }

    public static byte hexToByte$default(String string, kotlin.text.HexFormat hexFormat2, int i3, Object object4) {
        kotlin.text.HexFormat obj1;
        if (i3 &= 1 != 0) {
            obj1 = HexFormat.Companion.getDefault();
        }
        return HexExtensionsKt.hexToByte(string, obj1);
    }

    private static final byte[] hexToByteArray(String $this$hexToByteArray, int startIndex, int endIndex, kotlin.text.HexFormat format) {
        boolean noLineAndGroupSeparator$kotlin_stdlib;
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(startIndex, endIndex, $this$hexToByteArray.length());
        if (startIndex == endIndex) {
            return new byte[0];
        }
        kotlin.text.HexFormat.BytesHexFormat bytes = format.getBytes();
        noLineAndGroupSeparator$kotlin_stdlib = HexExtensionsKt.hexToByteArrayNoLineAndGroupSeparator($this$hexToByteArray, startIndex, endIndex, bytes);
        if (bytes.getNoLineAndGroupSeparator$kotlin_stdlib() && noLineAndGroupSeparator$kotlin_stdlib != null) {
            noLineAndGroupSeparator$kotlin_stdlib = HexExtensionsKt.hexToByteArrayNoLineAndGroupSeparator($this$hexToByteArray, startIndex, endIndex, bytes);
            if (noLineAndGroupSeparator$kotlin_stdlib != null) {
                final int i2 = 0;
                return noLineAndGroupSeparator$kotlin_stdlib;
            }
        }
        return HexExtensionsKt.hexToByteArraySlowPath($this$hexToByteArray, startIndex, endIndex, bytes);
    }

    public static final byte[] hexToByteArray(String $this$hexToByteArray, kotlin.text.HexFormat format) {
        Intrinsics.checkNotNullParameter($this$hexToByteArray, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return HexExtensionsKt.hexToByteArray($this$hexToByteArray, 0, $this$hexToByteArray.length(), format);
    }

    static byte[] hexToByteArray$default(String string, int i2, int i3, kotlin.text.HexFormat hexFormat4, int i5, Object object6) {
        int obj1;
        int obj2;
        kotlin.text.HexFormat obj3;
        if (i5 & 1 != 0) {
            obj1 = 0;
        }
        if (i5 & 2 != 0) {
            obj2 = string.length();
        }
        if (i5 &= 4 != 0) {
            obj3 = HexFormat.Companion.getDefault();
        }
        return HexExtensionsKt.hexToByteArray(string, obj1, obj2, obj3);
    }

    public static byte[] hexToByteArray$default(String string, kotlin.text.HexFormat hexFormat2, int i3, Object object4) {
        kotlin.text.HexFormat obj1;
        if (i3 &= 1 != 0) {
            obj1 = HexFormat.Companion.getDefault();
        }
        return HexExtensionsKt.hexToByteArray(string, obj1);
    }

    private static final byte[] hexToByteArrayNoLineAndGroupSeparator(String $this$hexToByteArrayNoLineAndGroupSeparator, int startIndex, int endIndex, kotlin.text.HexFormat.BytesHexFormat bytesFormat) {
        if (bytesFormat.getShortByteSeparatorNoPrefixAndSuffix$kotlin_stdlib()) {
            return HexExtensionsKt.hexToByteArrayShortByteSeparatorNoPrefixAndSuffix($this$hexToByteArrayNoLineAndGroupSeparator, startIndex, endIndex, bytesFormat);
        }
        return HexExtensionsKt.hexToByteArrayNoLineAndGroupSeparatorSlowPath($this$hexToByteArrayNoLineAndGroupSeparator, startIndex, endIndex, bytesFormat);
    }

    private static final byte[] hexToByteArrayNoLineAndGroupSeparatorSlowPath(String $this$hexToByteArrayNoLineAndGroupSeparatorSlowPath, int startIndex, int endIndex, kotlin.text.HexFormat.BytesHexFormat bytesFormat) {
        String str3;
        String bytePrefix;
        int length3;
        String byteSeparator;
        int length2;
        int byteSeparatorLength;
        int charsPerByte;
        char charAt;
        int $this$checkContainsAt$iv;
        String index$iv;
        int i$iv;
        String length;
        int i7;
        int charIndex;
        int i5;
        int i3;
        String str;
        int i4;
        int i6;
        String str2;
        String str4;
        int i2;
        int i;
        str3 = $this$hexToByteArrayNoLineAndGroupSeparatorSlowPath;
        final int i8 = endIndex;
        bytePrefix = bytesFormat.getBytePrefix();
        final String byteSuffix = bytesFormat.getByteSuffix();
        byteSeparator = bytesFormat.getByteSeparator();
        int length5 = byteSeparator.length();
        i12 += l3;
        long l4 = (long)i14;
        int i17 = (int)i16;
        if (Long.compare(i19, l4) != 0) {
            return null;
        }
        boolean ignoreCase$kotlin_stdlib = bytesFormat.getIgnoreCase$kotlin_stdlib();
        final byte[] bArr = new byte[i17];
        int i21 = startIndex;
        length = $this$hexToByteArrayNoLineAndGroupSeparatorSlowPath;
        i7 = 0;
        i3 = 0;
        final int i24 = 1;
        i5 = (CharSequence)bytePrefix.length() == 0 ? i24 : i3;
        if (i5 != 0) {
            i4 = length5;
            i6 = charsPerByte;
            byteSeparatorLength = i21;
        } else {
            i4 = length5;
            length2 = (CharSequence)bytePrefix.length();
            i6 = charsPerByte;
            charsPerByte = i5;
            while (charsPerByte < length2) {
                if (!CharsKt.equals(bytePrefix.charAt(charsPerByte), length.charAt(i21 + charsPerByte), ignoreCase$kotlin_stdlib)) {
                }
                charsPerByte++;
                length2 = i5;
                HexExtensionsKt.throwNotContainedAt(length, i21, i8, bytePrefix, "byte prefix");
            }
            length6 += i21;
        }
        StringBuilder stringBuilder = new StringBuilder();
        String string = stringBuilder.append(byteSuffix).append(byteSeparator).append(bytePrefix).toString();
        $this$checkContainsAt$iv = 0;
        while ($this$checkContainsAt$iv < i17 + -1) {
            bArr[$this$checkContainsAt$iv] = HexExtensionsKt.parseByteAt(str3, byteSeparatorLength);
            index$iv = byteSeparatorLength + 2;
            i7 = $this$hexToByteArrayNoLineAndGroupSeparatorSlowPath;
            i5 = 0;
            if ((CharSequence)string.length() == 0) {
            } else {
            }
            str = i3;
            if (str != null) {
            } else {
            }
            str4 = bytePrefix;
            length3 = (CharSequence)string.length();
            str2 = byteSeparator;
            byteSeparator = str;
            while (byteSeparator < length3) {
                i2 = byteSeparator;
                String byteIndex = i7;
                if (!CharsKt.equals(string.charAt(byteSeparator), byteIndex.charAt(index$iv + i2), ignoreCase$kotlin_stdlib)) {
                }
                byteSeparator = i2 + 1;
                i7 = byteIndex;
                length3 = str;
                $this$checkContainsAt$iv = i;
                HexExtensionsKt.throwNotContainedAt(byteIndex, index$iv, i8, string, "byte suffix + byte separator + byte prefix");
            }
            i2 = byteSeparator;
            i = $this$checkContainsAt$iv;
            $this$checkContainsAt$iv = i7;
            index$iv = bytePrefix;
            byteSeparatorLength = index$iv;
            $this$checkContainsAt$iv = i + 1;
            byteSeparator = str2;
            bytePrefix = str4;
            i2 = byteSeparator;
            byteIndex = i7;
            if (!CharsKt.equals(string.charAt(byteSeparator), byteIndex.charAt(index$iv + i2), ignoreCase$kotlin_stdlib)) {
            }
            byteSeparator = i2 + 1;
            i7 = byteIndex;
            length3 = str;
            $this$checkContainsAt$iv = i;
            HexExtensionsKt.throwNotContainedAt(byteIndex, index$iv, i8, string, length);
            str4 = bytePrefix;
            str2 = byteSeparator;
            i = $this$checkContainsAt$iv;
            str = i24;
        }
        String bytePrefix3 = bytePrefix;
        String str12 = byteSeparator;
        int i25 = $this$checkContainsAt$iv;
        bArr[i17 + -1] = HexExtensionsKt.parseByteAt(str3, byteSeparatorLength);
        int i9 = byteSeparatorLength + 2;
        String str6 = $this$hexToByteArrayNoLineAndGroupSeparatorSlowPath;
        int i23 = 0;
        if ((CharSequence)byteSuffix.length() == 0) {
            i3 = i24;
        }
        if (i3 == 0) {
            i$iv = 0;
            while (i$iv < (CharSequence)byteSuffix.length()) {
                if (!CharsKt.equals(byteSuffix.charAt(i$iv), str6.charAt(i9 + i$iv), ignoreCase$kotlin_stdlib)) {
                }
                i$iv++;
                str3 = $this$hexToByteArrayNoLineAndGroupSeparatorSlowPath;
                byteSeparatorLength = i7;
                HexExtensionsKt.throwNotContainedAt(str6, i9, i8, byteSuffix, "byte suffix");
            }
            charIndex = byteSeparatorLength;
            byteSuffix.length();
        } else {
            charIndex = byteSeparatorLength;
        }
        return bArr;
    }

    private static final byte[] hexToByteArrayShortByteSeparatorNoPrefixAndSuffix(String $this$hexToByteArrayShortByteSeparatorNoPrefixAndSuffix, int startIndex, int endIndex, kotlin.text.HexFormat.BytesHexFormat bytesFormat) {
        int length2;
        int length;
        int i$iv;
        int i4;
        int charIndex;
        int charIndex2;
        int byteIndex;
        byte byteAt;
        int byteIndex2;
        byte byteSeparator;
        boolean ignoreCase$kotlin_stdlib;
        String str3;
        String str2;
        int i5;
        int byteSeparatorLength;
        int i2;
        int i3;
        String str;
        int i;
        final String str4 = $this$hexToByteArrayShortByteSeparatorNoPrefixAndSuffix;
        final int i6 = endIndex;
        length2 = bytesFormat.getByteSeparator().length();
        length = 0;
        i$iv = 1;
        i4 = length2 <= i$iv ? i$iv : length;
        if (i4 == 0) {
        } else {
            int i10 = i6 - startIndex;
            charIndex = 0;
            int i11 = 0;
            if (length2 == 0 && i10 & 1 != 0) {
                if (i10 & 1 != 0) {
                    return i11;
                }
                int i8 = i10 >> 1;
                byte[] bArr = new byte[i8];
                byteIndex = 0;
                while (byteIndex < i8) {
                    bArr[byteIndex] = HexExtensionsKt.parseByteAt(str4, charIndex);
                    charIndex += 2;
                    byteIndex++;
                }
                return bArr;
            }
            int i15 = 2;
            if (i10 % 3 != i15) {
                return i11;
            }
            i12 += i$iv;
            byte[] bArr2 = new byte[i13];
            bArr2[length] = HexExtensionsKt.parseByteAt(str4, charIndex);
            charIndex += i15;
            byteIndex2 = 1;
            while (byteIndex2 < i13) {
                if (str4.charAt(charIndex2) != bytesFormat.getByteSeparator().charAt(length)) {
                } else {
                }
                byteSeparatorLength = length2;
                bArr2[byteIndex2] = HexExtensionsKt.parseByteAt(str4, charIndex2 + 1);
                charIndex2 += 3;
                byteIndex2++;
                length2 = byteSeparatorLength;
                length = 0;
                i$iv = 1;
                byteSeparator = bytesFormat.getByteSeparator();
                str2 = $this$hexToByteArrayShortByteSeparatorNoPrefixAndSuffix;
                i5 = 0;
                if ((CharSequence)byteSeparator.length() == 0) {
                } else {
                }
                i2 = length;
                if (i2 == 0) {
                } else {
                }
                byteSeparatorLength = length2;
                length = (CharSequence)byteSeparator.length();
                i$iv = i3;
                while (i$iv < length) {
                    if (!CharsKt.equals(byteSeparator.charAt(i$iv), str2.charAt(charIndex2 + i$iv), bytesFormat.getIgnoreCase$kotlin_stdlib())) {
                    }
                    i$iv++;
                    length2 = i3;
                    length = i;
                    HexExtensionsKt.throwNotContainedAt(str2, charIndex2, i6, byteSeparator, "byte separator");
                }
                byteSeparatorLength = length2;
                byteSeparator.length();
                if (!CharsKt.equals(byteSeparator.charAt(i$iv), str2.charAt(charIndex2 + i$iv), ignoreCase$kotlin_stdlib)) {
                }
                i$iv++;
                length2 = i3;
                length = i;
                HexExtensionsKt.throwNotContainedAt(str2, charIndex2, i6, byteSeparator, str3);
                i2 = i$iv;
            }
            return bArr2;
        }
        int i16 = length2;
        IllegalArgumentException byteSeparatorLength2 = new IllegalArgumentException("Failed requirement.".toString());
        throw byteSeparatorLength2;
    }

    private static final byte[] hexToByteArraySlowPath(String $this$hexToByteArraySlowPath, int startIndex, int endIndex, kotlin.text.HexFormat.BytesHexFormat bytesFormat) {
        String str2;
        int length3;
        byte[] copyOf;
        int i$iv3;
        int parseMaxSize2;
        String partName$iv2;
        int str4;
        int i7;
        int bytesPerLine;
        String str3;
        int index$iv;
        int $i$f$checkContainsAt2;
        int length2;
        int length;
        int $i$f$checkContainsAt;
        int charIndex;
        int i3;
        int indexInLine;
        int indexInLine2;
        int indexInGroup;
        int i$iv;
        int i$iv2;
        String str;
        String partName$iv;
        int i4;
        int indexInLine3;
        int i6;
        int i5;
        int i2;
        int parseMaxSize;
        int i;
        int i8;
        str2 = $this$hexToByteArraySlowPath;
        final int i9 = endIndex;
        final String bytePrefix = bytesFormat.getBytePrefix();
        final String byteSuffix = bytesFormat.getByteSuffix();
        final String byteSeparator = bytesFormat.getByteSeparator();
        final String groupSeparator = bytesFormat.getGroupSeparator();
        final boolean ignoreCase$kotlin_stdlib = bytesFormat.getIgnoreCase$kotlin_stdlib();
        byte[] bArr = new byte[HexExtensionsKt.parsedByteArrayMaxSize(i9 - startIndex, bytesFormat.getBytesPerLine(), bytesFormat.getBytesPerGroup(), groupSeparator.length(), byteSeparator.length(), bytePrefix.length(), byteSuffix.length())];
        charIndex = startIndex;
        i3 = 0;
        indexInLine = 0;
        indexInGroup = 0;
        while (charIndex < i9) {
            str = 1;
            if (indexInLine == bytesPerLine) {
            } else {
            }
            if (indexInGroup == $i$f$checkContainsAt2) {
            } else {
            }
            parseMaxSize = i$iv3;
            i6 = bytesPerLine;
            i8 = $i$f$checkContainsAt2;
            if (indexInGroup != 0) {
            } else {
            }
            indexInLine3 = indexInLine;
            indexInGroup++;
            str3 = $this$hexToByteArraySlowPath;
            if ((CharSequence)bytePrefix.length() == 0) {
            } else {
            }
            i$iv2 = 0;
            if (i$iv2 != 0) {
            } else {
            }
            i$iv2 = 0;
            i4 = i13;
            length = (CharSequence)bytePrefix.length();
            while (i$iv2 < length) {
                if (!CharsKt.equals(bytePrefix.charAt(i$iv2), str3.charAt(charIndex + i$iv2), ignoreCase$kotlin_stdlib)) {
                }
                i$iv2++;
                length = partName$iv;
                indexInLine2 = indexInLine3;
                HexExtensionsKt.throwNotContainedAt(str3, charIndex, i9, bytePrefix, "byte prefix");
            }
            indexInLine3 = indexInLine2;
            length8 += charIndex;
            if (i9 + -2 < $i$f$checkContainsAt) {
            }
            bArr[i3] = HexExtensionsKt.parseByteAt(str2, $i$f$checkContainsAt);
            index$iv = $i$f$checkContainsAt + 2;
            String str7 = $this$hexToByteArraySlowPath;
            int i14 = 0;
            if ((CharSequence)byteSuffix.length() == 0) {
            } else {
            }
            i$iv = 0;
            if (i$iv != 0) {
            } else {
            }
            i$iv = 0;
            length3 = (CharSequence)byteSuffix.length();
            while (i$iv < length3) {
                if (!CharsKt.equals(byteSuffix.charAt(i$iv), str7.charAt(index$iv + i$iv), ignoreCase$kotlin_stdlib)) {
                }
                i$iv++;
                length3 = str;
                i7 = partName$iv;
                HexExtensionsKt.throwNotContainedAt(str7, index$iv, i9, byteSuffix, "byte suffix");
            }
            partName$iv = i7;
            index$iv = str2;
            charIndex = index$iv;
            str2 = $this$hexToByteArraySlowPath;
            i3 = partName$iv;
            indexInLine = indexInLine3;
            bytesPerLine = i6;
            i$iv3 = parseMaxSize;
            $i$f$checkContainsAt2 = i8;
            if (!CharsKt.equals(byteSuffix.charAt(i$iv), str7.charAt(index$iv + i$iv), ignoreCase$kotlin_stdlib)) {
            }
            i$iv++;
            length3 = str;
            i7 = partName$iv;
            HexExtensionsKt.throwNotContainedAt(str7, index$iv, i9, byteSuffix, str6);
            partName$iv = i7;
            i$iv = str;
            HexExtensionsKt.throwInvalidNumberOfDigits(str2, $i$f$checkContainsAt, i9, "exactly", 2);
            if (!CharsKt.equals(bytePrefix.charAt(i$iv2), str3.charAt(charIndex + i$iv2), ignoreCase$kotlin_stdlib)) {
            }
            i$iv2++;
            length = partName$iv;
            indexInLine2 = indexInLine3;
            HexExtensionsKt.throwNotContainedAt(str3, charIndex, i9, bytePrefix, str5);
            $i$f$checkContainsAt = charIndex;
            indexInLine3 = indexInLine2;
            i$iv2 = str;
            bytesPerLine = $this$hexToByteArraySlowPath;
            if ((CharSequence)byteSeparator.length() == 0) {
            } else {
            }
            i$iv = 0;
            if (i$iv != 0) {
            } else {
            }
            i$iv = 0;
            i4 = i12;
            length2 = (CharSequence)byteSeparator.length();
            while (i$iv < length2) {
                if (!CharsKt.equals(byteSeparator.charAt(i$iv), bytesPerLine.charAt(charIndex + i$iv), ignoreCase$kotlin_stdlib)) {
                }
                i$iv++;
                length2 = partName$iv;
                indexInLine = indexInLine3;
                HexExtensionsKt.throwNotContainedAt(bytesPerLine, charIndex, i9, byteSeparator, "byte separator");
            }
            indexInLine3 = indexInLine;
            length7 += charIndex;
            charIndex = $i$f$checkContainsAt2;
            indexInLine = indexInLine3;
            if (!CharsKt.equals(byteSeparator.charAt(i$iv), bytesPerLine.charAt(charIndex + i$iv), ignoreCase$kotlin_stdlib)) {
            }
            i$iv++;
            length2 = partName$iv;
            indexInLine = indexInLine3;
            HexExtensionsKt.throwNotContainedAt(bytesPerLine, charIndex, i9, byteSeparator, i$iv3);
            $i$f$checkContainsAt2 = charIndex;
            indexInLine3 = indexInLine;
            i$iv = str;
            i4 = $this$hexToByteArraySlowPath;
            indexInLine3 = str11;
            partName$iv = 0;
            if ((CharSequence)groupSeparator.length() == 0) {
            } else {
            }
            i5 = 0;
            if (i5 != 0) {
            } else {
            }
            parseMaxSize = i$iv3;
            parseMaxSize2 = i2;
            while (parseMaxSize2 < (CharSequence)groupSeparator.length()) {
                i = parseMaxSize2;
                String bytesPerGroup = i4;
                if (!CharsKt.equals(groupSeparator.charAt(parseMaxSize2), bytesPerGroup.charAt(charIndex + i), ignoreCase$kotlin_stdlib)) {
                } else {
                }
                partName$iv2 = indexInLine3;
                indexInLine3 = partName$iv2;
                parseMaxSize2 = i11;
                i4 = bytesPerGroup;
                bytesPerLine = i2;
                $i$f$checkContainsAt2 = i8;
                HexExtensionsKt.throwNotContainedAt(bytesPerGroup, charIndex, i9, groupSeparator, indexInLine3);
            }
            i = parseMaxSize2;
            i6 = bytesPerLine;
            i8 = $i$f$checkContainsAt2;
            $i$f$checkContainsAt2 = i4;
            i$iv3 = indexInLine3;
            length6 += charIndex;
            charIndex = bytesPerLine;
            indexInGroup = 0;
            i = parseMaxSize2;
            bytesPerGroup = i4;
            if (!CharsKt.equals(groupSeparator.charAt(parseMaxSize2), bytesPerGroup.charAt(charIndex + i), ignoreCase$kotlin_stdlib)) {
            } else {
            }
            partName$iv2 = indexInLine3;
            indexInLine3 = partName$iv2;
            parseMaxSize2 = i11;
            i4 = bytesPerGroup;
            bytesPerLine = i2;
            $i$f$checkContainsAt2 = i8;
            HexExtensionsKt.throwNotContainedAt(bytesPerGroup, charIndex, i9, groupSeparator, indexInLine3);
            parseMaxSize = i$iv3;
            i6 = bytesPerLine;
            i8 = $i$f$checkContainsAt2;
            bytesPerLine = charIndex;
            i5 = str;
            charIndex = HexExtensionsKt.checkNewLineAt(str2, charIndex, i9);
            indexInLine = 0;
            indexInGroup = 0;
            parseMaxSize = i$iv3;
            i6 = bytesPerLine;
            i8 = $i$f$checkContainsAt2;
        }
        int parseMaxSize3 = i$iv3;
        int i16 = bytesPerLine;
        int i17 = $i$f$checkContainsAt2;
        int i15 = indexInLine;
        if (i3 == bArr.length) {
            copyOf = bArr;
        } else {
            Intrinsics.checkNotNullExpressionValue(Arrays.copyOf(bArr, i3), "copyOf(...)");
        }
        return copyOf;
    }

    private static final int hexToInt(String $this$hexToInt, int startIndex, int endIndex, kotlin.text.HexFormat format) {
        return HexExtensionsKt.hexToIntImpl($this$hexToInt, startIndex, endIndex, format, 8);
    }

    public static final int hexToInt(String $this$hexToInt, kotlin.text.HexFormat format) {
        Intrinsics.checkNotNullParameter($this$hexToInt, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return HexExtensionsKt.hexToInt($this$hexToInt, 0, $this$hexToInt.length(), format);
    }

    static int hexToInt$default(String string, int i2, int i3, kotlin.text.HexFormat hexFormat4, int i5, Object object6) {
        int obj1;
        int obj2;
        kotlin.text.HexFormat obj3;
        if (i5 & 1 != 0) {
            obj1 = 0;
        }
        if (i5 & 2 != 0) {
            obj2 = string.length();
        }
        if (i5 &= 4 != 0) {
            obj3 = HexFormat.Companion.getDefault();
        }
        return HexExtensionsKt.hexToInt(string, obj1, obj2, obj3);
    }

    public static int hexToInt$default(String string, kotlin.text.HexFormat hexFormat2, int i3, Object object4) {
        kotlin.text.HexFormat obj1;
        if (i3 &= 1 != 0) {
            obj1 = HexFormat.Companion.getDefault();
        }
        return HexExtensionsKt.hexToInt(string, obj1);
    }

    private static final int hexToIntImpl(String $this$hexToIntImpl, int startIndex, int endIndex, kotlin.text.HexFormat format, int typeHexLength) {
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(startIndex, endIndex, $this$hexToIntImpl.length());
        kotlin.text.HexFormat.NumberHexFormat number = format.getNumber();
        if (number.isDigitsOnly$kotlin_stdlib()) {
            HexExtensionsKt.checkNumberOfDigits($this$hexToIntImpl, startIndex, endIndex, typeHexLength);
            return HexExtensionsKt.parseInt($this$hexToIntImpl, startIndex, endIndex);
        }
        final String prefix = number.getPrefix();
        final String suffix = number.getSuffix();
        final String str = $this$hexToIntImpl;
        final int i = startIndex;
        final int i2 = endIndex;
        HexExtensionsKt.checkPrefixSuffixNumberOfDigits(str, i, i2, prefix, suffix, number.getIgnoreCase$kotlin_stdlib(), typeHexLength);
        return HexExtensionsKt.parseInt(str, i + obj9, i2 - obj9);
    }

    public static final long hexToLong(String $this$hexToLong, int startIndex, int endIndex, kotlin.text.HexFormat format) {
        Intrinsics.checkNotNullParameter($this$hexToLong, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return HexExtensionsKt.hexToLongImpl($this$hexToLong, startIndex, endIndex, format, 16);
    }

    public static final long hexToLong(String $this$hexToLong, kotlin.text.HexFormat format) {
        Intrinsics.checkNotNullParameter($this$hexToLong, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return HexExtensionsKt.hexToLong($this$hexToLong, 0, $this$hexToLong.length(), format);
    }

    public static long hexToLong$default(String string, int i2, int i3, kotlin.text.HexFormat hexFormat4, int i5, Object object6) {
        int obj1;
        int obj2;
        kotlin.text.HexFormat obj3;
        if (i5 & 1 != 0) {
            obj1 = 0;
        }
        if (i5 & 2 != 0) {
            obj2 = string.length();
        }
        if (i5 &= 4 != 0) {
            obj3 = HexFormat.Companion.getDefault();
        }
        return HexExtensionsKt.hexToLong(string, obj1, obj2, obj3);
    }

    public static long hexToLong$default(String string, kotlin.text.HexFormat hexFormat2, int i3, Object object4) {
        kotlin.text.HexFormat obj1;
        if (i3 &= 1 != 0) {
            obj1 = HexFormat.Companion.getDefault();
        }
        return HexExtensionsKt.hexToLong(string, obj1);
    }

    private static final long hexToLongImpl(String $this$hexToLongImpl, int startIndex, int endIndex, kotlin.text.HexFormat format, int typeHexLength) {
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(startIndex, endIndex, $this$hexToLongImpl.length());
        kotlin.text.HexFormat.NumberHexFormat number = format.getNumber();
        if (number.isDigitsOnly$kotlin_stdlib()) {
            HexExtensionsKt.checkNumberOfDigits($this$hexToLongImpl, startIndex, endIndex, typeHexLength);
            return HexExtensionsKt.parseLong($this$hexToLongImpl, startIndex, endIndex);
        }
        final String prefix = number.getPrefix();
        final String suffix = number.getSuffix();
        final String str = $this$hexToLongImpl;
        final int i = startIndex;
        final int i2 = endIndex;
        HexExtensionsKt.checkPrefixSuffixNumberOfDigits(str, i, i2, prefix, suffix, number.getIgnoreCase$kotlin_stdlib(), typeHexLength);
        return HexExtensionsKt.parseLong(str, i + obj10, i2 - obj10);
    }

    private static final short hexToShort(String $this$hexToShort, int startIndex, int endIndex, kotlin.text.HexFormat format) {
        return (short)hexToIntImpl;
    }

    public static final short hexToShort(String $this$hexToShort, kotlin.text.HexFormat format) {
        Intrinsics.checkNotNullParameter($this$hexToShort, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return HexExtensionsKt.hexToShort($this$hexToShort, 0, $this$hexToShort.length(), format);
    }

    static short hexToShort$default(String string, int i2, int i3, kotlin.text.HexFormat hexFormat4, int i5, Object object6) {
        int obj1;
        int obj2;
        kotlin.text.HexFormat obj3;
        if (i5 & 1 != 0) {
            obj1 = 0;
        }
        if (i5 & 2 != 0) {
            obj2 = string.length();
        }
        if (i5 &= 4 != 0) {
            obj3 = HexFormat.Companion.getDefault();
        }
        return HexExtensionsKt.hexToShort(string, obj1, obj2, obj3);
    }

    public static short hexToShort$default(String string, kotlin.text.HexFormat hexFormat2, int i3, Object object4) {
        kotlin.text.HexFormat obj1;
        if (i3 &= 1 != 0) {
            obj1 = HexFormat.Companion.getDefault();
        }
        return HexExtensionsKt.hexToShort(string, obj1);
    }

    private static final long longDecimalFromHexDigitAt(String $this$longDecimalFromHexDigitAt, int index) {
        int cmp;
        int i;
        final int i2 = 0;
        final char charAt = $this$longDecimalFromHexDigitAt.charAt(index);
        if (charAt >>> 8 != 0) {
        } else {
            if (Long.compare(l, i) < 0) {
            } else {
                return HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[charAt];
            }
        }
        HexExtensionsKt.throwInvalidDigitAt($this$longDecimalFromHexDigitAt, index);
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    private static final byte parseByteAt(String $this$parseByteAt, int index) {
        int i2;
        int i;
        String str = $this$parseByteAt;
        int i6 = 0;
        char charAt = str.charAt(index);
        if (charAt >>> 8 != 0) {
        } else {
            if (HexExtensionsKt.HEX_DIGITS_TO_DECIMAL[charAt] < 0) {
            } else {
                int i3 = index + 1;
                String str2 = $this$parseByteAt;
                int i7 = 0;
                final char charAt2 = str2.charAt(i3);
                if (charAt2 >>> 8 != 0) {
                } else {
                    if (HexExtensionsKt.HEX_DIGITS_TO_DECIMAL[charAt2] < 0) {
                    } else {
                        return (byte)i5;
                    }
                }
                HexExtensionsKt.throwInvalidDigitAt(str2, i3);
                KotlinNothingValueException kotlinNothingValueException2 = new KotlinNothingValueException();
                throw kotlinNothingValueException2;
            }
        }
        HexExtensionsKt.throwInvalidDigitAt(str, index);
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    private static final int parseInt(String $this$parseInt, int startIndex, int endIndex) {
        int result;
        int i2;
        int i;
        String str;
        int i3;
        char charAt;
        int i5;
        int i4;
        result = 0;
        i2 = startIndex;
        while (i2 < endIndex) {
            str = $this$parseInt;
            i3 = 0;
            charAt = str.charAt(i2);
            result = i | i5;
            i2++;
        }
        return result;
    }

    private static final long parseLong(String $this$parseLong, int startIndex, int endIndex) {
        int result;
        int i3;
        int i4;
        String str;
        int i2;
        char charAt;
        long l;
        int cmp;
        int i;
        result = 0;
        i3 = startIndex;
        while (i3 < endIndex) {
            str = $this$parseLong;
            i2 = 0;
            charAt = str.charAt(i3);
            result = i4 | l;
            i3++;
        }
        return result;
    }

    public static final int parsedByteArrayMaxSize(int stringLength, int bytesPerLine, int bytesPerGroup, int groupSeparatorLength, int byteSeparatorLength, int bytePrefixLength, int byteSuffixLength) {
        int i;
        long charsPerSet;
        int i3;
        long groupsPerLine;
        long result;
        int i2;
        int i4 = stringLength;
        int i7 = bytesPerLine;
        final int i8 = bytesPerGroup;
        final int i9 = groupSeparatorLength;
        final int i10 = byteSeparatorLength;
        i3 = i4 > 0 ? 1 : 0;
        if (i3 == 0) {
        } else {
            i15 += l9;
            long charsPerSet2 = HexExtensionsKt.charsPerSet(i16, obj9, i8);
            if (i7 <= i8) {
                groupsPerLine = HexExtensionsKt.charsPerSet(i16, obj9, i7);
            } else {
                i = i7 % i8;
                if (i != 0) {
                    result2 += charsPerSet;
                }
                groupsPerLine = result;
            }
            long l3 = (long)i4;
            final long wholeElementsPerSet = HexExtensionsKt.wholeElementsPerSet(l3, charsPerSet, groupsPerLine);
            l3 -= i28;
            long wholeElementsPerSet2 = HexExtensionsKt.wholeElementsPerSet(numberOfChars, charsPerSet, charsPerSet2);
            numberOfChars -= i13;
            int i14 = i29;
            long wholeElementsPerSet3 = HexExtensionsKt.wholeElementsPerSet(numberOfChars2, charsPerSet, i14);
            i2 = Long.compare(numberOfChars3, i19) > 0 ? 1 : 0;
            return (int)i23;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Failed requirement.".toString());
        throw illegalArgumentException;
    }

    private static final Void throwInvalidDigitAt(String $this$throwInvalidDigitAt, int index) {
        StringBuilder stringBuilder = new StringBuilder();
        NumberFormatException numberFormatException = new NumberFormatException(stringBuilder.append("Expected a hexadecimal digit at index ").append(index).append(", but was ").append($this$throwInvalidDigitAt.charAt(index)).toString());
        throw numberFormatException;
    }

    private static final void throwInvalidNumberOfDigits(String $this$throwInvalidNumberOfDigits, int startIndex, int endIndex, String specifier, int expected) {
        Intrinsics.checkNotNull($this$throwInvalidNumberOfDigits, "null cannot be cast to non-null type java.lang.String");
        String substring = $this$throwInvalidNumberOfDigits.substring(startIndex, endIndex);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        StringBuilder stringBuilder = new StringBuilder();
        NumberFormatException numberFormatException = new NumberFormatException(stringBuilder.append("Expected ").append(specifier).append(' ').append(expected).append(" hexadecimal digits at index ").append(startIndex).append(", but was \"").append(substring).append("\" of length ").append(endIndex - startIndex).toString());
        throw numberFormatException;
    }

    private static final void throwInvalidPrefixSuffix(String $this$throwInvalidPrefixSuffix, int startIndex, int endIndex, String prefix, String suffix) {
        Intrinsics.checkNotNull($this$throwInvalidPrefixSuffix, "null cannot be cast to non-null type java.lang.String");
        String substring = $this$throwInvalidPrefixSuffix.substring(startIndex, endIndex);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        StringBuilder stringBuilder = new StringBuilder();
        NumberFormatException numberFormatException = new NumberFormatException(stringBuilder.append("Expected a hexadecimal number with prefix \"").append(prefix).append("\" and suffix \"").append(suffix).append("\", but was ").append(substring).toString());
        throw numberFormatException;
    }

    private static final void throwNotContainedAt(String $this$throwNotContainedAt, int index, int endIndex, String part, String partName) {
        Intrinsics.checkNotNull($this$throwNotContainedAt, "null cannot be cast to non-null type java.lang.String");
        String substring = $this$throwNotContainedAt.substring(index, RangesKt.coerceAtMost(length += index, endIndex));
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        StringBuilder stringBuilder = new StringBuilder();
        NumberFormatException numberFormatException = new NumberFormatException(stringBuilder.append("Expected ").append(partName).append(" \"").append(part).append("\" at index ").append(index).append(", but was ").append(substring).toString());
        throw numberFormatException;
    }

    private static final int toCharArrayIfNotEmpty(String $this$toCharArrayIfNotEmpty, char[] destination, int destinationOffset) {
        int charAt;
        String str;
        final int i3 = 0;
        switch (charAt) {
            case 1:
                destination[destinationOffset] = $this$toCharArrayIfNotEmpty.charAt(i3);
                break;
            default:
                Intrinsics.checkNotNull($this$toCharArrayIfNotEmpty, "null cannot be cast to non-null type java.lang.String");
                $this$toCharArrayIfNotEmpty.getChars(i3, $this$toCharArrayIfNotEmpty.length(), destination, destinationOffset);
        }
        return length += destinationOffset;
    }

    public static final String toHexString(byte $this$toHexString, kotlin.text.HexFormat format) {
        String str;
        String concatToString$default;
        boolean removeLeadingZeros;
        int i;
        Intrinsics.checkNotNullParameter(format, "format");
        str = format.getUpperCase() ? "0123456789ABCDEF" : "0123456789abcdef";
        final kotlin.text.HexFormat.NumberHexFormat number = format.getNumber();
        if (number.isDigitsOnlyAndNoPadding$kotlin_stdlib()) {
            int i2 = 2;
            final char[] cArr = new char[i2];
            int i4 = $this$toHexString;
            final int i11 = 0;
            cArr[i11] = str.charAt(i5 &= 15);
            i = 1;
            cArr[i] = str.charAt(i4 & 15);
            if (number.getRemoveLeadingZeros()) {
                concatToString$default = StringsKt.concatToString$default(cArr, RangesKt.coerceAtMost(i9 >>= i2, i), i11, i2, 0);
            } else {
                concatToString$default = StringsKt.concatToString(cArr);
            }
            return concatToString$default;
        }
        return HexExtensionsKt.toHexStringImpl((long)$this$toHexString, obj3, number, str);
    }

    public static final String toHexString(int $this$toHexString, kotlin.text.HexFormat format) {
        String str;
        String concatToString$default;
        int i;
        Intrinsics.checkNotNullParameter(format, "format");
        str = format.getUpperCase() ? "0123456789ABCDEF" : "0123456789abcdef";
        final kotlin.text.HexFormat.NumberHexFormat number = format.getNumber();
        if (number.isDigitsOnlyAndNoPadding$kotlin_stdlib()) {
            char[] cArr = new char[8];
            final int i3 = $this$toHexString;
            final int i21 = 0;
            cArr[i21] = str.charAt(i5 &= 15);
            cArr[1] = str.charAt(i7 &= 15);
            int i23 = 2;
            cArr[i23] = str.charAt(i9 &= 15);
            cArr[3] = str.charAt(i11 &= 15);
            cArr[4] = str.charAt(i13 &= 15);
            cArr[5] = str.charAt(i15 &= 15);
            cArr[6] = str.charAt(i17 &= 15);
            i = 7;
            cArr[i] = str.charAt(i3 & 15);
            if (number.getRemoveLeadingZeros()) {
                concatToString$default = StringsKt.concatToString$default(cArr, RangesKt.coerceAtMost(numberOfLeadingZeros >>= i23, i), i21, i23, 0);
            } else {
                concatToString$default = StringsKt.concatToString(cArr);
            }
            return concatToString$default;
        }
        return HexExtensionsKt.toHexStringImpl((long)$this$toHexString, obj3, number, str);
    }

    public static final String toHexString(long $this$toHexString, kotlin.text.HexFormat format) {
        String str;
        String concatToString$default;
        int i;
        final Object obj = obj18;
        Intrinsics.checkNotNullParameter(obj, "format");
        str = obj.getUpperCase() ? "0123456789ABCDEF" : "0123456789abcdef";
        final kotlin.text.HexFormat.NumberHexFormat number = obj.getNumber();
        if (number.isDigitsOnlyAndNoPadding$kotlin_stdlib()) {
            int i3 = 16;
            char[] cArr = new char[i3];
            final int i11 = $this$toHexString;
            int i41 = 15;
            final int i40 = 0;
            cArr[i40] = str.charAt((int)i14);
            cArr[1] = str.charAt((int)i44);
            int i48 = 2;
            cArr[i48] = str.charAt((int)i47);
            cArr[3] = str.charAt((int)i50);
            int i54 = 4;
            cArr[i54] = str.charAt((int)i53);
            cArr[5] = str.charAt((int)i58);
            cArr[6] = str.charAt((int)i61);
            cArr[7] = str.charAt((int)i64);
            int i68 = 8;
            cArr[i68] = str.charAt((int)i67);
            cArr[9] = str.charAt((int)i72);
            cArr[10] = str.charAt((int)i75);
            cArr[11] = str.charAt((int)i78);
            int i5 = 12;
            cArr[i5] = str.charAt((int)i80);
            cArr[13] = str.charAt((int)i70);
            cArr[14] = str.charAt((int)i56);
            i = 15;
            cArr[i] = str.charAt((int)i42);
            if (number.getRemoveLeadingZeros()) {
                concatToString$default = StringsKt.concatToString$default(cArr, RangesKt.coerceAtMost(numberOfLeadingZeros >>= i48, i), i40, i48, 0);
            } else {
                concatToString$default = StringsKt.concatToString(cArr);
            }
            return concatToString$default;
        }
        return HexExtensionsKt.toHexStringImpl($this$toHexString, obj5, number, str);
    }

    public static final String toHexString(short $this$toHexString, kotlin.text.HexFormat format) {
        String str;
        String concatToString$default;
        boolean removeLeadingZeros;
        Intrinsics.checkNotNullParameter(format, "format");
        str = format.getUpperCase() ? "0123456789ABCDEF" : "0123456789abcdef";
        final kotlin.text.HexFormat.NumberHexFormat number = format.getNumber();
        int i2 = 16;
        if (number.isDigitsOnlyAndNoPadding$kotlin_stdlib()) {
            char[] cArr = new char[4];
            int i4 = $this$toHexString;
            final int i15 = 0;
            cArr[i15] = str.charAt(i5 &= 15);
            cArr[1] = str.charAt(i7 &= 15);
            int i17 = 2;
            cArr[i17] = str.charAt(i9 &= 15);
            final int i18 = 3;
            cArr[i18] = str.charAt(i4 & 15);
            if (number.getRemoveLeadingZeros()) {
                concatToString$default = StringsKt.concatToString$default(cArr, RangesKt.coerceAtMost(i14 >> 2, i18), i15, i17, 0);
            } else {
                concatToString$default = StringsKt.concatToString(cArr);
            }
            return concatToString$default;
        }
        return HexExtensionsKt.toHexStringImpl((long)$this$toHexString, obj5, number, str);
    }

    public static final String toHexString(byte[] $this$toHexString, int startIndex, int endIndex, kotlin.text.HexFormat format) {
        int[] bYTE_TO_UPPER_CASE_HEX_DIGITS;
        Intrinsics.checkNotNullParameter($this$toHexString, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(startIndex, endIndex, $this$toHexString.length);
        if (startIndex == endIndex) {
            return "";
        }
        bYTE_TO_UPPER_CASE_HEX_DIGITS = format.getUpperCase() ? HexExtensionsKt.BYTE_TO_UPPER_CASE_HEX_DIGITS : HexExtensionsKt.BYTE_TO_LOWER_CASE_HEX_DIGITS;
        kotlin.text.HexFormat.BytesHexFormat bytes = format.getBytes();
        if (bytes.getNoLineAndGroupSeparator$kotlin_stdlib()) {
            return HexExtensionsKt.toHexStringNoLineAndGroupSeparator($this$toHexString, startIndex, endIndex, bytes, bYTE_TO_UPPER_CASE_HEX_DIGITS);
        }
        return HexExtensionsKt.toHexStringSlowPath($this$toHexString, startIndex, endIndex, bytes, bYTE_TO_UPPER_CASE_HEX_DIGITS);
    }

    public static final String toHexString(byte[] $this$toHexString, kotlin.text.HexFormat format) {
        Intrinsics.checkNotNullParameter($this$toHexString, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return HexExtensionsKt.toHexString($this$toHexString, 0, $this$toHexString.length, format);
    }

    public static String toHexString$default(byte b, kotlin.text.HexFormat hexFormat2, int i3, Object object4) {
        kotlin.text.HexFormat obj1;
        if (i3 &= 1 != 0) {
            obj1 = HexFormat.Companion.getDefault();
        }
        return HexExtensionsKt.toHexString(b, obj1);
    }

    public static String toHexString$default(int i, kotlin.text.HexFormat hexFormat2, int i3, Object object4) {
        kotlin.text.HexFormat obj1;
        if (i3 &= 1 != 0) {
            obj1 = HexFormat.Companion.getDefault();
        }
        return HexExtensionsKt.toHexString(i, obj1);
    }

    public static String toHexString$default(long l, kotlin.text.HexFormat hexFormat2, int i3, Object object4) {
        kotlin.text.HexFormat obj2;
        if (object4 &= 1 != 0) {
            obj2 = HexFormat.Companion.getDefault();
        }
        return HexExtensionsKt.toHexString(l, hexFormat2);
    }

    public static String toHexString$default(short s, kotlin.text.HexFormat hexFormat2, int i3, Object object4) {
        kotlin.text.HexFormat obj1;
        if (i3 &= 1 != 0) {
            obj1 = HexFormat.Companion.getDefault();
        }
        return HexExtensionsKt.toHexString(s, obj1);
    }

    public static String toHexString$default(byte[] bArr, int i2, int i3, kotlin.text.HexFormat hexFormat4, int i5, Object object6) {
        int obj1;
        int obj2;
        kotlin.text.HexFormat obj3;
        if (i5 & 1 != 0) {
            obj1 = 0;
        }
        if (i5 & 2 != 0) {
            obj2 = bArr.length;
        }
        if (i5 &= 4 != 0) {
            obj3 = HexFormat.Companion.getDefault();
        }
        return HexExtensionsKt.toHexString(bArr, obj1, obj2, obj3);
    }

    public static String toHexString$default(byte[] bArr, kotlin.text.HexFormat hexFormat2, int i3, Object object4) {
        kotlin.text.HexFormat obj1;
        if (i3 &= 1 != 0) {
            obj1 = HexFormat.Companion.getDefault();
        }
        return HexExtensionsKt.toHexString(bArr, obj1);
    }

    private static final String toHexStringImpl(long $this$toHexStringImpl, kotlin.text.HexFormat.NumberHexFormat numberFormat, String digits, int bits) {
        int i11;
        int i6;
        int shift;
        int i5;
        int i2;
        String concatToString$default;
        int i7;
        char charAt2;
        boolean removeZeros;
        int charIndex;
        char charAt;
        int i;
        int i9;
        int i3;
        int i8;
        int i4;
        int i10;
        final Object obj = bits;
        i5 = 0;
        i11 = obj28 & 3 == 0 ? 1 : i5;
        if (i11 == 0) {
        } else {
            i2 = $this$toHexStringImpl;
            int i13 = obj28 >> 2;
            final int minLength = digits.getMinLength();
            int coerceAtLeast = RangesKt.coerceAtLeast(minLength - i13, i5);
            final String prefix = digits.getPrefix();
            final String suffix = digits.getSuffix();
            int i19 = 0;
            removeZeros = digits.getRemoveLeadingZeros();
            char[] cArr = new char[HexExtensionsKt.checkFormatLength(i21 += l4)];
            int i23 = 0;
            charIndex = HexExtensionsKt.toCharArrayIfNotEmpty(prefix, cArr, i5);
            if (coerceAtLeast > 0) {
                ArraysKt.fill(cArr, obj.charAt(i5), charIndex, charIndex + coerceAtLeast);
                charIndex += coerceAtLeast;
            }
            int i14 = 0;
            shift = obj28;
            i = i5;
            while (i < i13) {
                i9 = i;
                i3 = 0;
                shift += -4;
                int i16 = (int)i15;
                if (removeZeros && i16 == 0 && shift >> 2 >= minLength) {
                } else {
                }
                i7 = 0;
                if (!i7) {
                }
                i++;
                i2 = i10;
                i5 = 0;
                cArr[charIndex] = obj.charAt(i16);
                charIndex = i7;
                if (i16 == 0) {
                } else {
                }
                if (shift >> 2 >= minLength) {
                } else {
                }
                i7 = 1;
            }
            int value = i2;
            int charArrayIfNotEmpty = HexExtensionsKt.toCharArrayIfNotEmpty(suffix, cArr, charIndex);
            if (charArrayIfNotEmpty == cArr.length) {
                concatToString$default = StringsKt.concatToString(cArr);
            } else {
                concatToString$default = StringsKt.concatToString$default(cArr, 0, charArrayIfNotEmpty, 1, 0);
            }
            return concatToString$default;
        }
        IllegalArgumentException typeHexLength = new IllegalArgumentException("Failed requirement.".toString());
        throw typeHexLength;
    }

    private static final String toHexStringNoLineAndGroupSeparator(byte[] $this$toHexStringNoLineAndGroupSeparator, int startIndex, int endIndex, kotlin.text.HexFormat.BytesHexFormat bytesFormat, int[] byteToDigits) {
        if (bytesFormat.getShortByteSeparatorNoPrefixAndSuffix$kotlin_stdlib()) {
            return HexExtensionsKt.toHexStringShortByteSeparatorNoPrefixAndSuffix($this$toHexStringNoLineAndGroupSeparator, startIndex, endIndex, bytesFormat, byteToDigits);
        }
        return HexExtensionsKt.toHexStringNoLineAndGroupSeparatorSlowPath($this$toHexStringNoLineAndGroupSeparator, startIndex, endIndex, bytesFormat, byteToDigits);
    }

    private static final String toHexStringNoLineAndGroupSeparatorSlowPath(byte[] $this$toHexStringNoLineAndGroupSeparatorSlowPath, int startIndex, int endIndex, kotlin.text.HexFormat.BytesHexFormat bytesFormat, int[] byteToDigits) {
        int byteIndex;
        int charArrayIfNotEmpty;
        int obj9;
        final String bytePrefix = bytesFormat.getBytePrefix();
        final String byteSuffix = bytesFormat.getByteSuffix();
        final String byteSeparator = bytesFormat.getByteSeparator();
        char[] cArr = new char[HexExtensionsKt.formattedStringLength(endIndex - startIndex, byteSeparator.length(), bytePrefix.length(), byteSuffix.length())];
        byte[] bArr = $this$toHexStringNoLineAndGroupSeparatorSlowPath;
        int[] iArr = byteToDigits;
        obj9 = HexExtensionsKt.formatByteAt(bArr, startIndex, bytePrefix, byteSuffix, iArr, cArr, 0);
        byteIndex = obj13;
        while (byteIndex < endIndex) {
            obj9 = HexExtensionsKt.formatByteAt(bArr, byteIndex, bytePrefix, byteSuffix, iArr, cArr, HexExtensionsKt.toCharArrayIfNotEmpty(byteSeparator, cArr, obj9));
            byteIndex++;
        }
        return StringsKt.concatToString(cArr);
    }

    private static final String toHexStringShortByteSeparatorNoPrefixAndSuffix(byte[] $this$toHexStringShortByteSeparatorNoPrefixAndSuffix, int startIndex, int endIndex, kotlin.text.HexFormat.BytesHexFormat bytesFormat, int[] byteToDigits) {
        int i2;
        int charIndex;
        int charIndex2;
        int byteIndex2;
        int byteIndex;
        int i;
        int length = bytesFormat.getByteSeparator().length();
        int i3 = 0;
        if (length <= 1) {
        } else {
            i2 = i3;
        }
        if (i2 == 0) {
        } else {
            int i4 = endIndex - startIndex;
            if (length == 0) {
                char[] cArr = new char[HexExtensionsKt.checkFormatLength(l2 *= i7)];
                byteIndex2 = startIndex;
                while (byteIndex2 < endIndex) {
                    charIndex2 = HexExtensionsKt.formatByteAt($this$toHexStringShortByteSeparatorNoPrefixAndSuffix, byteIndex2, byteToDigits, cArr, charIndex2);
                    byteIndex2++;
                }
                return StringsKt.concatToString(cArr);
            }
            char[] cArr2 = new char[HexExtensionsKt.checkFormatLength(i8 -= i6)];
            charIndex = HexExtensionsKt.formatByteAt($this$toHexStringShortByteSeparatorNoPrefixAndSuffix, startIndex, byteToDigits, cArr2, 0);
            byteIndex = startIndex + 1;
            while (byteIndex < endIndex) {
                cArr2[charIndex] = bytesFormat.getByteSeparator().charAt(i3);
                charIndex = HexExtensionsKt.formatByteAt($this$toHexStringShortByteSeparatorNoPrefixAndSuffix, byteIndex, byteToDigits, cArr2, charIndex + 1);
                byteIndex++;
            }
            return StringsKt.concatToString(cArr2);
        }
        IllegalArgumentException byteSeparatorChar = new IllegalArgumentException("Failed requirement.".toString());
        throw byteSeparatorChar;
    }

    private static final String toHexStringSlowPath(byte[] $this$toHexStringSlowPath, int startIndex, int endIndex, kotlin.text.HexFormat.BytesHexFormat bytesFormat, int[] byteToDigits) {
        int charIndex2;
        int indexInLine;
        int indexInGroup;
        String bytePrefix;
        String byteSuffix;
        int charIndex3;
        int i3;
        int charIndex;
        int i2;
        int i;
        String str;
        final int i4 = endIndex;
        final int bytesPerLine = bytesFormat.getBytesPerLine();
        final int bytesPerGroup = bytesFormat.getBytesPerGroup();
        String byteSuffix4 = bytesFormat.getByteSuffix();
        final String byteSeparator = bytesFormat.getByteSeparator();
        final String groupSeparator = bytesFormat.getGroupSeparator();
        int formattedStringLength = HexExtensionsKt.formattedStringLength(i4 - startIndex, bytesPerLine, bytesPerGroup, groupSeparator.length(), byteSeparator.length(), bytesFormat.getBytePrefix().length(), byteSuffix4.length());
        bytePrefix = byteSuffix4;
        char[] byteSuffix5 = new char[formattedStringLength];
        charIndex2 = 0;
        indexInLine = 0;
        indexInGroup = 0;
        charIndex3 = startIndex;
        i3 = 1;
        while (charIndex3 < i4) {
            if (indexInLine == bytesPerLine) {
            } else {
            }
            if (indexInGroup == bytesPerGroup) {
            } else {
            }
            charIndex = indexInLine;
            i2 = indexInGroup;
            if (i2 != 0) {
            }
            String str2 = byteSuffix;
            int i7 = charIndex3;
            indexInGroup = i2 + 1;
            indexInLine = charIndex + 1;
            charIndex3 = i6;
            charIndex2 = i11;
            byteSuffix = byteSuffix3;
            bytePrefix = str;
            i3 = 1;
            charIndex2 = HexExtensionsKt.toCharArrayIfNotEmpty(byteSeparator, byteSuffix5, charIndex2);
            charIndex2 = HexExtensionsKt.toCharArrayIfNotEmpty(groupSeparator, byteSuffix5, charIndex2);
            charIndex = indexInLine;
            i2 = indexInGroup;
            byteSuffix5[charIndex2] = 10;
            i2 = indexInGroup;
            charIndex2 = i8;
            charIndex = indexInLine;
        }
        String bytePrefix2 = bytePrefix;
        String byteSuffix2 = str5;
        int i10 = charIndex3;
        if (charIndex2 == formattedStringLength) {
        } else {
            i3 = 0;
        }
        if (i3 == 0) {
        } else {
            return StringsKt.concatToString(byteSuffix5);
        }
        IllegalStateException illegalStateException = new IllegalStateException("Check failed.".toString());
        throw illegalStateException;
    }

    private static final long wholeElementsPerSet(long charsPerSet, long charsPerElement, int elementSeparatorLength) {
        int i;
        int cmp;
        i = 0;
        if (Long.compare(charsPerSet, i) > 0) {
            if (Long.compare(elementSeparatorLength, i) <= 0) {
            } else {
                i2 /= cmp;
            }
        }
        return i;
    }
}
