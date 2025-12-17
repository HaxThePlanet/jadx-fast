package kotlin.io.encoding;

import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.collections.AbstractList.Companion;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\u0008\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\r\u0008\u0017\u0018\u0000 <2\u00020\u0001:\u0002<=B\u001f\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0015\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0000¢\u0006\u0002\u0008\u0011J%\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0000¢\u0006\u0002\u0008\u0017J \u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u0015H\u0002J\u0010\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u0015H\u0002J%\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0000¢\u0006\u0002\u0008!J\"\u0010\"\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00152\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u0015J\"\u0010\"\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00152\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u0015J0\u0010#\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J4\u0010%\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u00152\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00152\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u0015J4\u0010%\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u00152\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00152\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u0015J%\u0010&\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0000¢\u0006\u0002\u0008'J\"\u0010(\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00152\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u0015J4\u0010)\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u00152\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00152\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u0015J5\u0010*\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0000¢\u0006\u0002\u0008+J\u0015\u0010,\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u0015H\u0000¢\u0006\u0002\u0008-J=\u0010.\u001a\u0002H/\"\u000c\u0008\u0000\u0010/*\u000600j\u0002`12\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010$\u001a\u0002H/2\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00152\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0002\u00102J\"\u00103\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00152\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u0015J%\u00104\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0000¢\u0006\u0002\u00085J(\u00106\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u00107\u001a\u00020\u0015H\u0002J\u0008\u00108\u001a\u00020\u0003H\u0002J \u00109\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010:\u001a\u00020\u00002\u0006\u0010;\u001a\u00020\u0006H\u0007R\u0014\u0010\u0004\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0006X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006>", d2 = {"Lkotlin/io/encoding/Base64;", "", "isUrlSafe", "", "isMimeScheme", "paddingOption", "Lkotlin/io/encoding/Base64$PaddingOption;", "(ZZLkotlin/io/encoding/Base64$PaddingOption;)V", "isMimeScheme$kotlin_stdlib", "()Z", "isUrlSafe$kotlin_stdlib", "getPaddingOption$kotlin_stdlib", "()Lkotlin/io/encoding/Base64$PaddingOption;", "bytesToStringImpl", "", "source", "", "bytesToStringImpl$kotlin_stdlib", "charsToBytesImpl", "", "startIndex", "", "endIndex", "charsToBytesImpl$kotlin_stdlib", "checkDestinationBounds", "", "destinationSize", "destinationOffset", "capacityNeeded", "checkPaddingIsAllowed", "padIndex", "checkSourceBounds", "sourceSize", "checkSourceBounds$kotlin_stdlib", "decode", "decodeImpl", "destination", "decodeIntoByteArray", "decodeSize", "decodeSize$kotlin_stdlib", "encode", "encodeIntoByteArray", "encodeIntoByteArrayImpl", "encodeIntoByteArrayImpl$kotlin_stdlib", "encodeSize", "encodeSize$kotlin_stdlib", "encodeToAppendable", "A", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "([BLjava/lang/Appendable;II)Ljava/lang/Appendable;", "encodeToByteArray", "encodeToByteArrayImpl", "encodeToByteArrayImpl$kotlin_stdlib", "handlePaddingSymbol", "byteStart", "shouldPadOnEncode", "skipIllegalSymbolsIfMime", "withPadding", "option", "Default", "PaddingOption", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class Base64 {

    public static final kotlin.io.encoding.Base64.Default Default = null;
    private static final kotlin.io.encoding.Base64 Mime = null;
    private static final kotlin.io.encoding.Base64 UrlSafe = null;
    private static final int bitsPerByte = 8;
    private static final int bitsPerSymbol = 6;
    public static final int bytesPerGroup = 3;
    private static final int mimeGroupsPerLine = 19;
    public static final int mimeLineLength = 76;
    private static final byte[] mimeLineSeparatorSymbols = null;
    public static final byte padSymbol = (byte) 61;
    public static final int symbolsPerGroup = 4;
    private final boolean isMimeScheme;
    private final boolean isUrlSafe;
    private final kotlin.io.encoding.Base64.PaddingOption paddingOption;

    @Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u0012\n\u0002\u0008\u0003\n\u0002\u0010\u0005\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0005R\u000e\u0010\u0008\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0080T¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000fX\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0015", d2 = {"Lkotlin/io/encoding/Base64$Default;", "Lkotlin/io/encoding/Base64;", "()V", "Mime", "getMime", "()Lkotlin/io/encoding/Base64;", "UrlSafe", "getUrlSafe", "bitsPerByte", "", "bitsPerSymbol", "bytesPerGroup", "mimeGroupsPerLine", "mimeLineLength", "mimeLineSeparatorSymbols", "", "getMimeLineSeparatorSymbols$kotlin_stdlib", "()[B", "padSymbol", "", "symbolsPerGroup", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Default extends kotlin.io.encoding.Base64 {
        private Default() {
            final int i2 = 0;
            super(i2, i2, Base64.PaddingOption.PRESENT, 0);
        }

        public Default(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        @Override // kotlin.io.encoding.Base64
        public final kotlin.io.encoding.Base64 getMime() {
            return Base64.access$getMime$cp();
        }

        @Override // kotlin.io.encoding.Base64
        public final byte[] getMimeLineSeparatorSymbols$kotlin_stdlib() {
            return Base64.access$getMimeLineSeparatorSymbols$cp();
        }

        @Override // kotlin.io.encoding.Base64
        public final kotlin.io.encoding.Base64 getUrlSafe() {
            return Base64.access$getUrlSafe$cp();
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0006\u0008\u0087\u0081\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004j\u0002\u0008\u0005j\u0002\u0008\u0006¨\u0006\u0007", d2 = {"Lkotlin/io/encoding/Base64$PaddingOption;", "", "(Ljava/lang/String;I)V", "PRESENT", "ABSENT", "PRESENT_OPTIONAL", "ABSENT_OPTIONAL", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static enum PaddingOption {

        PRESENT,
        PRESENT,
        PRESENT,
        PRESENT,
        PRESENT,
        PRESENT;
        private static final kotlin.io.encoding.Base64.PaddingOption[] $values() {
            return /* result */;
        }

        public static EnumEntries<kotlin.io.encoding.Base64.PaddingOption> getEntries() {
            return Base64.PaddingOption.$ENTRIES;
        }
    }
    static {
        Base64.Default obj2 = new Base64.Default(0);
        Base64.Default = obj2;
        byte[] bArr = new byte[2];
        bArr = new byte[]{13, 10};
        Base64.mimeLineSeparatorSymbols = bArr;
        final int i3 = 1;
        final int i4 = 0;
        Base64 base64 = new Base64(i3, i4, Base64.PaddingOption.PRESENT);
        Base64.UrlSafe = base64;
        Base64 base642 = new Base64(i4, i3, Base64.PaddingOption.PRESENT);
        Base64.Mime = base642;
    }

    private Base64(boolean isUrlSafe, boolean isMimeScheme, kotlin.io.encoding.Base64.PaddingOption paddingOption) {
        int i;
        boolean isMimeScheme2;
        super();
        this.isUrlSafe = isUrlSafe;
        this.isMimeScheme = isMimeScheme;
        this.paddingOption = paddingOption;
        if (this.isUrlSafe) {
            if (!this.isMimeScheme) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        if (i == 0) {
        } else {
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Failed requirement.".toString());
        throw illegalArgumentException;
    }

    public Base64(boolean z, boolean z2, kotlin.io.encoding.Base64.PaddingOption base64$PaddingOption3, DefaultConstructorMarker defaultConstructorMarker4) {
        super(z, z2, paddingOption3);
    }

    public static final kotlin.io.encoding.Base64 access$getMime$cp() {
        return Base64.Mime;
    }

    public static final byte[] access$getMimeLineSeparatorSymbols$cp() {
        return Base64.mimeLineSeparatorSymbols;
    }

    public static final kotlin.io.encoding.Base64 access$getUrlSafe$cp() {
        return Base64.UrlSafe;
    }

    private final void checkDestinationBounds(int destinationSize, int destinationOffset, int capacityNeeded) {
        String str = ", destination size: ";
        if (destinationOffset < 0) {
        } else {
            if (destinationOffset > destinationSize) {
            } else {
                int i = destinationOffset + capacityNeeded;
                if (i < 0) {
                } else {
                    if (i > destinationSize) {
                    } else {
                    }
                }
                StringBuilder stringBuilder2 = new StringBuilder();
                IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(stringBuilder2.append("The destination array does not have enough capacity, destination offset: ").append(destinationOffset).append(str).append(destinationSize).append(", capacity needed: ").append(capacityNeeded).toString());
                throw indexOutOfBoundsException;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        IndexOutOfBoundsException destinationEndIndex = new IndexOutOfBoundsException(stringBuilder.append("destination offset: ").append(destinationOffset).append(str).append(destinationSize).toString());
        throw destinationEndIndex;
    }

    private final void checkPaddingIsAllowed(int padIndex) {
        if (this.paddingOption == Base64.PaddingOption.ABSENT) {
        } else {
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("The padding option is set to ABSENT, but the input has a pad character at index ").append(padIndex).toString());
        throw illegalArgumentException;
    }

    public static byte[] decode$default(kotlin.io.encoding.Base64 base64, java.lang.CharSequence charSequence2, int i3, int i4, int i5, Object object6) {
        int obj2;
        int obj3;
        if (object6 != null) {
        } else {
            if (i5 & 2 != 0) {
                obj2 = 0;
            }
            if (i5 &= 4 != 0) {
                obj3 = charSequence2.length();
            }
            return base64.decode(charSequence2, obj2, obj3);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decode");
        throw obj0;
    }

    public static byte[] decode$default(kotlin.io.encoding.Base64 base64, byte[] b2Arr2, int i3, int i4, int i5, Object object6) {
        int obj2;
        int obj3;
        if (object6 != null) {
        } else {
            if (i5 & 2 != 0) {
                obj2 = 0;
            }
            if (i5 &= 4 != 0) {
                obj3 = b2Arr2.length;
            }
            return base64.decode(b2Arr2, obj2, obj3);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decode");
        throw obj0;
    }

    private final int decodeImpl(byte[] source, byte[] destination, int destinationOffset, int startIndex, int endIndex) {
        int[] destinationIndex;
        int paddingOption;
        int payload;
        int byteStart;
        int symbol1;
        int i4;
        int hasPadding;
        int str3;
        byte str;
        String str2;
        int pRESENT;
        int i6;
        int isMimeScheme;
        int i3;
        int sourceIndex;
        int[] decodeMap;
        int i5;
        int i;
        int i2;
        final Object obj = this;
        final byte[] bArr = source;
        final int i7 = endIndex;
        if (obj.isUrlSafe) {
            destinationIndex = Base64Kt.access$getBase64UrlDecodeMap$p();
        } else {
            destinationIndex = Base64Kt.access$getBase64DecodeMap$p();
        }
        payload = 0;
        byteStart = -8;
        symbol1 = startIndex;
        i4 = destinationOffset;
        hasPadding = 0;
        str3 = ") at index ";
        str = "toString(...)";
        str2 = "'(";
        while (symbol1 < i7) {
            i = 8;
            b5 &= 255;
            i6 = destinationIndex[pRESENT];
            sourceIndex = destinationIndex;
            symbol1++;
            payload = i8 | i6;
            byteStart += 6;
            if (byteStart >= 0) {
            } else {
            }
            destinationIndex = sourceIndex;
            str3 = ") at index ";
            str = "toString(...)";
            str2 = "'(";
            destination[i4] = (byte)i17;
            int i15 = 1;
            payload &= str3;
            byteStart += -8;
            i4 = i9;
            destinationIndex = sourceIndex;
            symbol1++;
            int i25 = symbol1 + 1;
            int i27 = i25 + 1;
            int i28 = i27 + 1;
            i = 8;
            sourceIndex = i28 + 1;
            pRESENT = i5 | isMimeScheme;
            symbol1 = sourceIndex;
            int i16 = i4 + 1;
            destination[i4] = (byte)i20;
            int i14 = i16 + 1;
            destination[i16] = (byte)i21;
            destination[i14] = (byte)pRESENT;
            i4 = str3;
            symbol1 = sourceIndex;
        }
        decodeMap = destinationIndex;
        i = 8;
        if (byteStart == -2) {
        } else {
            if (byteStart != -8 && hasPadding == 0) {
                if (hasPadding == 0) {
                    if (obj.paddingOption == Base64.PaddingOption.PRESENT) {
                    } else {
                    }
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("The padding option is set to PRESENT, but the input is not properly padded");
                    throw illegalArgumentException;
                }
            }
            if (payload != 0) {
            } else {
                int skipIllegalSymbolsIfMime = obj.skipIllegalSymbolsIfMime(bArr, symbol1, i7);
                if (skipIllegalSymbolsIfMime < i7) {
                } else {
                    return i4 - destinationOffset;
                }
                b &= 255;
                StringBuilder stringBuilder = new StringBuilder();
                String string4 = Integer.toString(i10, CharsKt.checkRadix(i));
                Intrinsics.checkNotNullExpressionValue(string4, str);
                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(stringBuilder.append("Symbol '").append((char)i10).append(str2).append(string4).append(str3).append(skipIllegalSymbolsIfMime + -1).append(" is prohibited after the pad character").toString());
                throw illegalArgumentException3;
            }
            IllegalArgumentException sourceIndex2 = new IllegalArgumentException("The pad bits must be zeros");
            throw sourceIndex2;
        }
        IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("The last unit of input does not have enough bits");
        throw illegalArgumentException2;
    }

    public static int decodeIntoByteArray$default(kotlin.io.encoding.Base64 base64, java.lang.CharSequence charSequence2, byte[] b3Arr3, int i4, int i5, int i6, int i7, Object object8) {
        int obj4;
        int obj5;
        int obj6;
        if (object8 != null) {
        } else {
            final int i = 0;
            if (i7 & 4 != 0) {
                obj4 = i;
            }
            if (i7 & 8 != 0) {
                obj5 = i;
            }
            if (i7 &= 16 != 0) {
                obj6 = charSequence2.length();
            }
            return base64.decodeIntoByteArray(charSequence2, b3Arr3, obj4, obj5, obj6);
        }
        UnsupportedOperationException obj1 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeIntoByteArray");
        throw obj1;
    }

    public static int decodeIntoByteArray$default(kotlin.io.encoding.Base64 base64, byte[] b2Arr2, byte[] b3Arr3, int i4, int i5, int i6, int i7, Object object8) {
        int obj4;
        int obj5;
        int obj6;
        if (object8 != null) {
        } else {
            final int i = 0;
            if (i7 & 4 != 0) {
                obj4 = i;
            }
            if (i7 & 8 != 0) {
                obj5 = i;
            }
            if (i7 &= 16 != 0) {
                obj6 = b2Arr2.length;
            }
            return base64.decodeIntoByteArray(b2Arr2, b3Arr3, obj4, obj5, obj6);
        }
        UnsupportedOperationException obj1 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeIntoByteArray");
        throw obj1;
    }

    public static String encode$default(kotlin.io.encoding.Base64 base64, byte[] b2Arr2, int i3, int i4, int i5, Object object6) {
        int obj2;
        int obj3;
        if (object6 != null) {
        } else {
            if (i5 & 2 != 0) {
                obj2 = 0;
            }
            if (i5 &= 4 != 0) {
                obj3 = b2Arr2.length;
            }
            return base64.encode(b2Arr2, obj2, obj3);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encode");
        throw obj0;
    }

    public static int encodeIntoByteArray$default(kotlin.io.encoding.Base64 base64, byte[] b2Arr2, byte[] b3Arr3, int i4, int i5, int i6, int i7, Object object8) {
        int obj4;
        int obj5;
        int obj6;
        if (object8 != null) {
        } else {
            final int i = 0;
            if (i7 & 4 != 0) {
                obj4 = i;
            }
            if (i7 & 8 != 0) {
                obj5 = i;
            }
            if (i7 &= 16 != 0) {
                obj6 = b2Arr2.length;
            }
            return base64.encodeIntoByteArray(b2Arr2, b3Arr3, obj4, obj5, obj6);
        }
        UnsupportedOperationException obj1 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encodeIntoByteArray");
        throw obj1;
    }

    public static java.lang.Appendable encodeToAppendable$default(kotlin.io.encoding.Base64 base64, byte[] b2Arr2, java.lang.Appendable appendable3, int i4, int i5, int i6, Object object7) {
        int obj3;
        int obj4;
        if (object7 != null) {
        } else {
            if (i6 & 4 != 0) {
                obj3 = 0;
            }
            if (i6 &= 8 != 0) {
                obj4 = b2Arr2.length;
            }
            return base64.encodeToAppendable(b2Arr2, appendable3, obj3, obj4);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encodeToAppendable");
        throw obj0;
    }

    public static byte[] encodeToByteArray$default(kotlin.io.encoding.Base64 base64, byte[] b2Arr2, int i3, int i4, int i5, Object object6) {
        int obj2;
        int obj3;
        if (object6 != null) {
        } else {
            if (i5 & 2 != 0) {
                obj2 = 0;
            }
            if (i5 &= 4 != 0) {
                obj3 = b2Arr2.length;
            }
            return base64.encodeToByteArray(b2Arr2, obj2, obj3);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encodeToByteArray");
        throw obj0;
    }

    private final int handlePaddingSymbol(byte[] source, int padIndex, int endIndex, int byteStart) {
        int secondPadIndex;
        byte b;
        int i;
        switch (byteStart) {
            case -8:
                StringBuilder stringBuilder = new StringBuilder();
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Redundant pad character at index ").append(padIndex).toString());
                throw illegalArgumentException;
            case -7:
                IllegalStateException illegalStateException = new IllegalStateException("Unreachable".toString());
                throw illegalStateException;
            case -6:
                checkPaddingIsAllowed(padIndex);
                secondPadIndex = padIndex + 1;
                break;
            case -5:
                checkPaddingIsAllowed(padIndex);
                int skipIllegalSymbolsIfMime = skipIllegalSymbolsIfMime(source, padIndex + 1, endIndex);
                skipIllegalSymbolsIfMime++;
                StringBuilder stringBuilder2 = new StringBuilder();
                IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(stringBuilder2.append("Missing one pad character at index ").append(skipIllegalSymbolsIfMime).toString());
                throw illegalArgumentException2;
            default:
                secondPadIndex = padIndex + 1;
        }
        return secondPadIndex;
    }

    private final boolean shouldPadOnEncode() {
        int i;
        kotlin.io.encoding.Base64.PaddingOption paddingOption;
        kotlin.io.encoding.Base64.PaddingOption pRESENT_OPTIONAL;
        if (this.paddingOption != Base64.PaddingOption.PRESENT) {
            if (this.paddingOption == Base64.PaddingOption.PRESENT_OPTIONAL) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    private final int skipIllegalSymbolsIfMime(byte[] source, int startIndex, int endIndex) {
        int sourceIndex;
        int i2;
        int i3;
        int i;
        if (!this.isMimeScheme) {
            return startIndex;
        }
        sourceIndex = startIndex;
        while (sourceIndex < endIndex) {
            sourceIndex++;
        }
        return sourceIndex;
    }

    public final String bytesToStringImpl$kotlin_stdlib(byte[] source) {
        int i;
        byte b;
        char c;
        Intrinsics.checkNotNullParameter(source, "source");
        StringBuilder stringBuilder = new StringBuilder(source.length);
        i = 0;
        while (i < source.length) {
            stringBuilder.append((char)b);
            i++;
        }
        String string = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public final byte[] charsToBytesImpl$kotlin_stdlib(java.lang.CharSequence source, int startIndex, int endIndex) {
        int i;
        int index;
        char charAt;
        int length;
        byte b;
        Intrinsics.checkNotNullParameter(source, "source");
        checkSourceBounds$kotlin_stdlib(source.length(), startIndex, endIndex);
        byte[] bArr = new byte[endIndex - startIndex];
        i = 0;
        index = startIndex;
        while (index < endIndex) {
            charAt = source.charAt(index);
            if (charAt <= 255) {
            } else {
            }
            bArr[i] = 63;
            i = length;
            index++;
            bArr[i] = (byte)charAt;
            i = length;
        }
        return bArr;
    }

    public final void checkSourceBounds$kotlin_stdlib(int sourceSize, int startIndex, int endIndex) {
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(startIndex, endIndex, sourceSize);
    }

    public final byte[] decode(java.lang.CharSequence source, int startIndex, int endIndex) {
        byte[] charsToBytesImpl$kotlin_stdlib;
        String str2;
        String str;
        Intrinsics.checkNotNullParameter(source, "source");
        if (source instanceof String != null) {
            checkSourceBounds$kotlin_stdlib(source.length(), startIndex, endIndex);
            String substring = (String)source.substring(startIndex, endIndex);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            Intrinsics.checkNotNull(substring, "null cannot be cast to non-null type java.lang.String");
            Intrinsics.checkNotNullExpressionValue(substring.getBytes(Charsets.ISO_8859_1), "getBytes(...)");
        } else {
            charsToBytesImpl$kotlin_stdlib = charsToBytesImpl$kotlin_stdlib(source, startIndex, endIndex);
        }
        return Base64.decode$default(this, charsToBytesImpl$kotlin_stdlib, 0, 0, 6, 0);
    }

    public final byte[] decode(byte[] source, int startIndex, int endIndex) {
        int obj9;
        Intrinsics.checkNotNullParameter(source, "source");
        checkSourceBounds$kotlin_stdlib(source.length, startIndex, endIndex);
        final byte[] bArr = new byte[decodeSize$kotlin_stdlib(source, startIndex, endIndex)];
        obj9 = this.decodeImpl(source, bArr, 0, startIndex, endIndex) == bArr.length ? 1 : 0;
        if (obj9 == null) {
        } else {
            return bArr;
        }
        obj9 = new IllegalStateException("Check failed.".toString());
        throw obj9;
    }

    public final int decodeIntoByteArray(java.lang.CharSequence source, byte[] destination, int destinationOffset, int startIndex, int endIndex) {
        byte[] charsToBytesImpl$kotlin_stdlib;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (source instanceof String != null) {
            checkSourceBounds$kotlin_stdlib(source.length(), startIndex, endIndex);
            String substring = (String)source.substring(startIndex, endIndex);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            Intrinsics.checkNotNull(substring, "null cannot be cast to non-null type java.lang.String");
            Intrinsics.checkNotNullExpressionValue(substring.getBytes(Charsets.ISO_8859_1), "getBytes(...)");
        } else {
            charsToBytesImpl$kotlin_stdlib = charsToBytesImpl$kotlin_stdlib(source, startIndex, endIndex);
        }
        return Base64.decodeIntoByteArray$default(this, charsToBytesImpl$kotlin_stdlib, destination, destinationOffset, 0, 0, 24, 0);
    }

    public final int decodeIntoByteArray(byte[] source, byte[] destination, int destinationOffset, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(destination, "destination");
        checkSourceBounds$kotlin_stdlib(source.length, startIndex, endIndex);
        checkDestinationBounds(destination.length, destinationOffset, decodeSize$kotlin_stdlib(source, startIndex, endIndex));
        return decodeImpl(source, destination, destinationOffset, startIndex, endIndex);
    }

    public final int decodeSize$kotlin_stdlib(byte[] source, int startIndex, int endIndex) {
        int symbols;
        byte index;
        int i2;
        int i3;
        int i;
        Intrinsics.checkNotNullParameter(source, "source");
        symbols = endIndex - startIndex;
        if (symbols == 0) {
            return 0;
        }
        if (symbols == 1) {
        } else {
            if (this.isMimeScheme) {
                index = startIndex;
                while (index < endIndex) {
                    i3 = Base64Kt.access$getBase64DecodeMap$p()[b &= 255];
                    if (i3 < 0) {
                        break;
                    } else {
                    }
                    index++;
                    if (i3 == -2) {
                        break;
                    } else {
                    }
                    symbols--;
                }
            } else {
                i2 = 61;
                if (source[endIndex + -1] == i2 && source[endIndex + -2] == i2) {
                    if (source[endIndex + -2] == i2) {
                        symbols--;
                    }
                }
            }
            return (int)i8;
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Input should have at least 2 symbols for Base64 decoding, startIndex: ").append(startIndex).append(", endIndex: ").append(endIndex).toString());
        throw illegalArgumentException;
    }

    public final String encode(byte[] source, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter(source, "source");
        String string = new String(encodeToByteArrayImpl$kotlin_stdlib(source, startIndex, endIndex), Charsets.ISO_8859_1);
        return string;
    }

    public final int encodeIntoByteArray(byte[] source, byte[] destination, int destinationOffset, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(destination, "destination");
        return encodeIntoByteArrayImpl$kotlin_stdlib(source, destination, destinationOffset, startIndex, endIndex);
    }

    public final int encodeIntoByteArrayImpl$kotlin_stdlib(byte[] source, byte[] destination, int destinationOffset, int startIndex, int endIndex) {
        byte[] bArr;
        int byte1;
        int i4;
        int i7;
        int i6;
        int byte2;
        int i2;
        int i3;
        int i8;
        byte[] mimeLineSeparatorSymbols;
        int padOnEncode;
        int i;
        byte b2;
        int i5;
        byte b;
        final Object obj2 = this;
        final Object obj3 = source;
        final Object obj4 = destination;
        final int i9 = destinationOffset;
        final int i10 = startIndex;
        final int i11 = endIndex;
        Intrinsics.checkNotNullParameter(obj3, "source");
        Intrinsics.checkNotNullParameter(obj4, "destination");
        obj2.checkSourceBounds$kotlin_stdlib(obj3.length, i10, i11);
        obj2.checkDestinationBounds(obj4.length, i9, obj2.encodeSize$kotlin_stdlib(i11 - i10));
        if (obj2.isUrlSafe) {
            bArr = Base64Kt.access$getBase64UrlEncodeMap$p();
        } else {
            bArr = Base64Kt.access$getBase64EncodeMap$p();
        }
        byte1 = startIndex;
        i4 = destinationOffset;
        i7 = obj2.isMimeScheme ? 19 : 0x7fffffff /* Unknown resource */;
        i3 = 1;
        while (byte1 + 2 < i11) {
            i6 = Math.min(i19 /= 3, i7);
            i8 = 0;
            while (i8 < i6) {
                int i24 = byte1 + 1;
                int i25 = i24 + 1;
                i33 |= padOnEncode;
                int i39 = i4 + 1;
                obj4[i4] = bArr[b2 >>> 18];
                int i16 = i39 + 1;
                obj4[i39] = bArr[i41 &= 63];
                i5 = i16 + 1;
                obj4[i16] = bArr[i43 &= 63];
                i4 = i5 + 1;
                obj4[i5] = bArr[b2 & 63];
                i8++;
                byte1 = i;
            }
            if (i6 == i7 && byte1 != i11) {
            }
            i3 = 1;
            if (byte1 != i11) {
            }
            i8 = i4 + 1;
            obj4[i4] = Base64.mimeLineSeparatorSymbols[0];
            i4 = i8 + 1;
            obj4[i8] = Base64.mimeLineSeparatorSymbols[i3];
            i24 = byte1 + 1;
            i25 = i24 + 1;
            i33 |= padOnEncode;
            i39 = i4 + 1;
            obj4[i4] = bArr[b2 >>> 18];
            i16 = i39 + 1;
            obj4[i39] = bArr[i41 &= 63];
            i5 = i16 + 1;
            obj4[i16] = bArr[i43 &= 63];
            i4 = i5 + 1;
            obj4[i5] = bArr[b2 & 63];
            i8++;
            byte1 = i;
        }
        int i23 = 61;
        switch (byte2) {
            case 1:
                byte2 = byte1 + 1;
                mimeLineSeparatorSymbols = i15 << 4;
                int i27 = i4 + 1;
                obj4[i4] = bArr[mimeLineSeparatorSymbols >>> 6];
                i4 = i27 + 1;
                obj4[i27] = bArr[mimeLineSeparatorSymbols & 63];
                padOnEncode = i4 + 1;
                obj4[i4] = i23;
                i4 = padOnEncode + 1;
                obj4[padOnEncode] = i23;
                byte1 = byte2;
                byte1 = byte2;
                break;
            case 2:
                int i21 = byte1 + 1;
                mimeLineSeparatorSymbols = i21 + 1;
                i26 |= i28;
                int i29 = i4 + 1;
                obj4[i4] = bArr[padOnEncode >>> 12];
                int i17 = i29 + 1;
                obj4[i29] = bArr[i35 &= 63];
                i = i17 + 1;
                obj4[i17] = bArr[padOnEncode & 63];
                i4 = i + 1;
                obj4[i] = i23;
                byte1 = mimeLineSeparatorSymbols;
                byte1 = mimeLineSeparatorSymbols;
                i4 = i;
                break;
            default:
        }
        if (byte1 == i11) {
            i2 = i3;
        }
        if (i2 == 0) {
        } else {
            return i4 - i9;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Check failed.".toString());
        throw illegalStateException;
    }

    public final int encodeSize$kotlin_stdlib(int sourceSize) {
        int size;
        int i;
        boolean isMimeScheme;
        final int i3 = sourceSize % 3;
        if (i3 != 0) {
            i = shouldPadOnEncode() ? 4 : i3 + 1;
            size += i;
        }
        if (this.isMimeScheme) {
            size += isMimeScheme;
        }
        if (size < 0) {
        } else {
            return size;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Input is too big");
        throw illegalArgumentException;
    }

    public final <A extends java.lang.Appendable> A encodeToAppendable(byte[] source, A destination, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(destination, "destination");
        String string = new String(encodeToByteArrayImpl$kotlin_stdlib(source, startIndex, endIndex), Charsets.ISO_8859_1);
        destination.append((CharSequence)string);
        return destination;
    }

    public final byte[] encodeToByteArray(byte[] source, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter(source, "source");
        return encodeToByteArrayImpl$kotlin_stdlib(source, startIndex, endIndex);
    }

    public final byte[] encodeToByteArrayImpl$kotlin_stdlib(byte[] source, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter(source, "source");
        checkSourceBounds$kotlin_stdlib(source.length, startIndex, endIndex);
        final byte[] bArr = new byte[encodeSize$kotlin_stdlib(endIndex - startIndex)];
        this.encodeIntoByteArrayImpl$kotlin_stdlib(source, bArr, 0, startIndex, endIndex);
        return bArr;
    }

    public final kotlin.io.encoding.Base64.PaddingOption getPaddingOption$kotlin_stdlib() {
        return this.paddingOption;
    }

    public final boolean isMimeScheme$kotlin_stdlib() {
        return this.isMimeScheme;
    }

    public final boolean isUrlSafe$kotlin_stdlib() {
        return this.isUrlSafe;
    }

    public final kotlin.io.encoding.Base64 withPadding(kotlin.io.encoding.Base64.PaddingOption option) {
        Object obj;
        boolean isUrlSafe;
        boolean isMimeScheme;
        Intrinsics.checkNotNullParameter(option, "option");
        if (this.paddingOption == option) {
            obj = this;
        } else {
            obj = new Base64(this.isUrlSafe, this.isMimeScheme, option);
        }
        return obj;
    }
}
