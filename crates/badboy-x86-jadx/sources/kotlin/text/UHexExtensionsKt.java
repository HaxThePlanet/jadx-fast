package kotlin.text;

import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0008\u000c\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\u0008¢\u0006\u0002\u0010\u0005\u001a\u001c\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\u0008¢\u0006\u0002\u0010\u0008\u001a\u001c\u0010\t\u001a\u00020\n*\u00020\u00022\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\u0008¢\u0006\u0002\u0010\u000b\u001a\u001c\u0010\u000c\u001a\u00020\r*\u00020\u00022\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\u0008¢\u0006\u0002\u0010\u000e\u001a\u001c\u0010\u000f\u001a\u00020\u0010*\u00020\u00022\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\u0008¢\u0006\u0002\u0010\u0011\u001a\u001e\u0010\u0012\u001a\u00020\u0002*\u00020\u00012\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\u0008¢\u0006\u0004\u0008\u0013\u0010\u0014\u001a2\u0010\u0012\u001a\u00020\u0002*\u00020\u00072\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u00162\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u00162\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\u0008¢\u0006\u0004\u0008\u0018\u0010\u0019\u001a\u001e\u0010\u0012\u001a\u00020\u0002*\u00020\u00072\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\u0008¢\u0006\u0004\u0008\u001a\u0010\u001b\u001a\u001e\u0010\u0012\u001a\u00020\u0002*\u00020\n2\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\u0008¢\u0006\u0004\u0008\u001c\u0010\u001d\u001a\u001e\u0010\u0012\u001a\u00020\u0002*\u00020\r2\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\u0008¢\u0006\u0004\u0008\u001e\u0010\u001f\u001a\u001e\u0010\u0012\u001a\u00020\u0002*\u00020\u00102\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\u0008¢\u0006\u0004\u0008 \u0010!¨\u0006\"", d2 = {"hexToUByte", "Lkotlin/UByte;", "", "format", "Lkotlin/text/HexFormat;", "(Ljava/lang/String;Lkotlin/text/HexFormat;)B", "hexToUByteArray", "Lkotlin/UByteArray;", "(Ljava/lang/String;Lkotlin/text/HexFormat;)[B", "hexToUInt", "Lkotlin/UInt;", "(Ljava/lang/String;Lkotlin/text/HexFormat;)I", "hexToULong", "Lkotlin/ULong;", "(Ljava/lang/String;Lkotlin/text/HexFormat;)J", "hexToUShort", "Lkotlin/UShort;", "(Ljava/lang/String;Lkotlin/text/HexFormat;)S", "toHexString", "toHexString-ZQbaR00", "(BLkotlin/text/HexFormat;)Ljava/lang/String;", "startIndex", "", "endIndex", "toHexString-lZCiFrA", "([BIILkotlin/text/HexFormat;)Ljava/lang/String;", "toHexString-zHuV2wU", "([BLkotlin/text/HexFormat;)Ljava/lang/String;", "toHexString-8M7LxHw", "(ILkotlin/text/HexFormat;)Ljava/lang/String;", "toHexString-8UJCm-I", "(JLkotlin/text/HexFormat;)Ljava/lang/String;", "toHexString-r3ox_E0", "(SLkotlin/text/HexFormat;)Ljava/lang/String;", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class UHexExtensionsKt {
    private static final byte hexToUByte(String $this$hexToUByte, kotlin.text.HexFormat format) {
        Intrinsics.checkNotNullParameter($this$hexToUByte, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return UByte.constructor-impl(HexExtensionsKt.hexToByte($this$hexToUByte, format));
    }

    static byte hexToUByte$default(String $this$hexToUByte_u24default, kotlin.text.HexFormat format, int i3, Object object4) {
        kotlin.text.HexFormat obj1;
        int obj2;
        if (i3 &= 1 != 0) {
            obj1 = HexFormat.Companion.getDefault();
        }
        Intrinsics.checkNotNullParameter($this$hexToUByte_u24default, "<this>");
        Intrinsics.checkNotNullParameter(obj1, "format");
        return UByte.constructor-impl(HexExtensionsKt.hexToByte($this$hexToUByte_u24default, obj1));
    }

    private static final byte[] hexToUByteArray(String $this$hexToUByteArray, kotlin.text.HexFormat format) {
        Intrinsics.checkNotNullParameter($this$hexToUByteArray, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return UByteArray.constructor-impl(HexExtensionsKt.hexToByteArray($this$hexToUByteArray, format));
    }

    static byte[] hexToUByteArray$default(String $this$hexToUByteArray_u24default, kotlin.text.HexFormat format, int i3, Object object4) {
        kotlin.text.HexFormat obj1;
        int obj2;
        if (i3 &= 1 != 0) {
            obj1 = HexFormat.Companion.getDefault();
        }
        Intrinsics.checkNotNullParameter($this$hexToUByteArray_u24default, "<this>");
        Intrinsics.checkNotNullParameter(obj1, "format");
        return UByteArray.constructor-impl(HexExtensionsKt.hexToByteArray($this$hexToUByteArray_u24default, obj1));
    }

    private static final int hexToUInt(String $this$hexToUInt, kotlin.text.HexFormat format) {
        Intrinsics.checkNotNullParameter($this$hexToUInt, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return UInt.constructor-impl(HexExtensionsKt.hexToInt($this$hexToUInt, format));
    }

    static int hexToUInt$default(String $this$hexToUInt_u24default, kotlin.text.HexFormat format, int i3, Object object4) {
        kotlin.text.HexFormat obj1;
        int obj2;
        if (i3 &= 1 != 0) {
            obj1 = HexFormat.Companion.getDefault();
        }
        Intrinsics.checkNotNullParameter($this$hexToUInt_u24default, "<this>");
        Intrinsics.checkNotNullParameter(obj1, "format");
        return UInt.constructor-impl(HexExtensionsKt.hexToInt($this$hexToUInt_u24default, obj1));
    }

    private static final long hexToULong(String $this$hexToULong, kotlin.text.HexFormat format) {
        Intrinsics.checkNotNullParameter($this$hexToULong, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return ULong.constructor-impl(HexExtensionsKt.hexToLong($this$hexToULong, format));
    }

    static long hexToULong$default(String $this$hexToULong_u24default, kotlin.text.HexFormat format, int i3, Object object4) {
        kotlin.text.HexFormat obj1;
        int obj2;
        if (i3 &= 1 != 0) {
            obj1 = HexFormat.Companion.getDefault();
        }
        Intrinsics.checkNotNullParameter($this$hexToULong_u24default, "<this>");
        Intrinsics.checkNotNullParameter(obj1, "format");
        return ULong.constructor-impl(HexExtensionsKt.hexToLong($this$hexToULong_u24default, obj1));
    }

    private static final short hexToUShort(String $this$hexToUShort, kotlin.text.HexFormat format) {
        Intrinsics.checkNotNullParameter($this$hexToUShort, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return UShort.constructor-impl(HexExtensionsKt.hexToShort($this$hexToUShort, format));
    }

    static short hexToUShort$default(String $this$hexToUShort_u24default, kotlin.text.HexFormat format, int i3, Object object4) {
        kotlin.text.HexFormat obj1;
        int obj2;
        if (i3 &= 1 != 0) {
            obj1 = HexFormat.Companion.getDefault();
        }
        Intrinsics.checkNotNullParameter($this$hexToUShort_u24default, "<this>");
        Intrinsics.checkNotNullParameter(obj1, "format");
        return UShort.constructor-impl(HexExtensionsKt.hexToShort($this$hexToUShort_u24default, obj1));
    }

    private static final String toHexString-8M7LxHw(int $this$toHexString_u2d8M7LxHw, kotlin.text.HexFormat format) {
        Intrinsics.checkNotNullParameter(format, "format");
        return HexExtensionsKt.toHexString($this$toHexString_u2d8M7LxHw, format);
    }

    static String toHexString-8M7LxHw$default(int $this$toHexString_u2d8M7LxHw_u24default, kotlin.text.HexFormat format, int i3, Object object4) {
        kotlin.text.HexFormat obj1;
        int obj2;
        if (i3 &= 1 != 0) {
            obj1 = HexFormat.Companion.getDefault();
        }
        Intrinsics.checkNotNullParameter(obj1, "format");
        return HexExtensionsKt.toHexString($this$toHexString_u2d8M7LxHw_u24default, obj1);
    }

    private static final String toHexString-8UJCm-I(long $this$toHexString_u2d8UJCm_u2dI, kotlin.text.HexFormat format) {
        Intrinsics.checkNotNullParameter(obj3, "format");
        return HexExtensionsKt.toHexString($this$toHexString_u2d8UJCm_u2dI, format);
    }

    static String toHexString-8UJCm-I$default(long $this$toHexString_u2d8UJCm_u2dI_u24default, kotlin.text.HexFormat format, int i3, Object object4) {
        kotlin.text.HexFormat obj2;
        int obj3;
        if (object4 &= 1 != 0) {
            obj2 = HexFormat.Companion.getDefault();
        }
        Intrinsics.checkNotNullParameter(obj2, "format");
        return HexExtensionsKt.toHexString($this$toHexString_u2d8UJCm_u2dI_u24default, format);
    }

    private static final String toHexString-ZQbaR00(byte $this$toHexString_u2dZQbaR00, kotlin.text.HexFormat format) {
        Intrinsics.checkNotNullParameter(format, "format");
        return HexExtensionsKt.toHexString($this$toHexString_u2dZQbaR00, format);
    }

    static String toHexString-ZQbaR00$default(byte $this$toHexString_u2dZQbaR00_u24default, kotlin.text.HexFormat format, int i3, Object object4) {
        kotlin.text.HexFormat obj1;
        int obj2;
        if (i3 &= 1 != 0) {
            obj1 = HexFormat.Companion.getDefault();
        }
        Intrinsics.checkNotNullParameter(obj1, "format");
        return HexExtensionsKt.toHexString($this$toHexString_u2dZQbaR00_u24default, obj1);
    }

    private static final String toHexString-lZCiFrA(byte[] $this$toHexString_u2dlZCiFrA, int startIndex, int endIndex, kotlin.text.HexFormat format) {
        Intrinsics.checkNotNullParameter($this$toHexString_u2dlZCiFrA, "$this$toHexString");
        Intrinsics.checkNotNullParameter(format, "format");
        return HexExtensionsKt.toHexString($this$toHexString_u2dlZCiFrA, startIndex, endIndex, format);
    }

    static String toHexString-lZCiFrA$default(byte[] $this$toHexString_u2dlZCiFrA_u24default, int startIndex, int endIndex, kotlin.text.HexFormat format, int i5, Object object6) {
        int obj1;
        int obj2;
        kotlin.text.HexFormat obj3;
        int obj4;
        if (i5 & 1 != 0) {
            obj1 = 0;
        }
        if (i5 & 2 != 0) {
            obj2 = UByteArray.getSize-impl($this$toHexString_u2dlZCiFrA_u24default);
        }
        if (i5 &= 4 != 0) {
            obj3 = HexFormat.Companion.getDefault();
        }
        Intrinsics.checkNotNullParameter($this$toHexString_u2dlZCiFrA_u24default, "$this$toHexString");
        Intrinsics.checkNotNullParameter(obj3, "format");
        return HexExtensionsKt.toHexString($this$toHexString_u2dlZCiFrA_u24default, obj1, obj2, obj3);
    }

    private static final String toHexString-r3ox_E0(short $this$toHexString_u2dr3ox_E0, kotlin.text.HexFormat format) {
        Intrinsics.checkNotNullParameter(format, "format");
        return HexExtensionsKt.toHexString($this$toHexString_u2dr3ox_E0, format);
    }

    static String toHexString-r3ox_E0$default(short $this$toHexString_u2dr3ox_E0_u24default, kotlin.text.HexFormat format, int i3, Object object4) {
        kotlin.text.HexFormat obj1;
        int obj2;
        if (i3 &= 1 != 0) {
            obj1 = HexFormat.Companion.getDefault();
        }
        Intrinsics.checkNotNullParameter(obj1, "format");
        return HexExtensionsKt.toHexString($this$toHexString_u2dr3ox_E0_u24default, obj1);
    }

    private static final String toHexString-zHuV2wU(byte[] $this$toHexString_u2dzHuV2wU, kotlin.text.HexFormat format) {
        Intrinsics.checkNotNullParameter($this$toHexString_u2dzHuV2wU, "$this$toHexString");
        Intrinsics.checkNotNullParameter(format, "format");
        return HexExtensionsKt.toHexString($this$toHexString_u2dzHuV2wU, format);
    }

    static String toHexString-zHuV2wU$default(byte[] $this$toHexString_u2dzHuV2wU_u24default, kotlin.text.HexFormat format, int i3, Object object4) {
        kotlin.text.HexFormat obj1;
        int obj2;
        if (i3 &= 1 != 0) {
            obj1 = HexFormat.Companion.getDefault();
        }
        Intrinsics.checkNotNullParameter($this$toHexString_u2dzHuV2wU_u24default, "$this$toHexString");
        Intrinsics.checkNotNullParameter(obj1, "format");
        return HexExtensionsKt.toHexString($this$toHexString_u2dzHuV2wU_u24default, obj1);
    }
}
