package kotlin.uuid;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.HexExtensionsKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\n\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001\u001a\u0019\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0002¢\u0006\u0002\u0008\t\u001a)\u0010\n\u001a\u00020\u0005*\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00082\u0006\u0010\u000e\u001a\u00020\u0008H\u0002¢\u0006\u0002\u0008\u000f\u001a!\u0010\u0010\u001a\u00020\u0005*\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0008H\u0002¢\u0006\u0002\u0008\u0011\u001a\u0019\u0010\u0012\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0008H\u0002¢\u0006\u0002\u0008\u0014¨\u0006\u0015", d2 = {"uuidFromRandomBytes", "Lkotlin/uuid/Uuid;", "randomBytes", "", "checkHyphenAt", "", "", "index", "", "checkHyphenAt$UuidKt__UuidKt", "formatBytesInto", "", "dst", "dstOffset", "count", "formatBytesInto$UuidKt__UuidKt", "toByteArray", "toByteArray$UuidKt__UuidKt", "toLong", "startIndex", "toLong$UuidKt__UuidKt", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/uuid/UuidKt")
class UuidKt__UuidKt extends kotlin.uuid.UuidKt__UuidJVMKt {
    public static final void access$checkHyphenAt(String $receiver, int index) {
        UuidKt__UuidKt.checkHyphenAt$UuidKt__UuidKt($receiver, index);
    }

    public static final void access$formatBytesInto(long $receiver, byte[] dst, int dstOffset, int count) {
        UuidKt__UuidKt.formatBytesInto$UuidKt__UuidKt($receiver, dst, dstOffset, count);
    }

    public static final void access$toByteArray(long $receiver, byte[] dst, int dstOffset) {
        UuidKt__UuidKt.toByteArray$UuidKt__UuidKt($receiver, dst, dstOffset);
    }

    public static final long access$toLong(byte[] $receiver, int startIndex) {
        return UuidKt__UuidKt.toLong$UuidKt__UuidKt($receiver, startIndex);
    }

    private static final void checkHyphenAt$UuidKt__UuidKt(String $this$checkHyphenAt, int index) {
        int i;
        i = $this$checkHyphenAt.charAt(index) == 45 ? 1 : 0;
        if (i == 0) {
        } else {
        }
        int i2 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Expected '-' (hyphen) at index 8, but was ").append($this$checkHyphenAt.charAt(index)).toString().toString());
        throw illegalArgumentException;
    }

    private static final void formatBytesInto$UuidKt__UuidKt(long $this$formatBytesInto, byte[] dst, int dstOffset, int count) {
        int _long;
        int dstIndex;
        int dstIndex2;
        int i4;
        int i2;
        int i5;
        int i3;
        int i;
        int i6 = 0;
        _long = $this$formatBytesInto;
        int i7 = 0;
        i8 += count;
        dstIndex = 0;
        while (dstIndex < obj13) {
            i4 = dstIndex;
            i2 = 0;
            i3 = HexExtensionsKt.getBYTE_TO_LOWER_CASE_HEX_DIGITS()[(int)i10];
            dstIndex2--;
            dstOffset[dstIndex3] = (byte)i3;
            dstOffset[dstIndex3--] = (byte)i11;
            _long >>= i;
            dstIndex++;
        }
    }

    private static final void toByteArray$UuidKt__UuidKt(long $this$toByteArray, byte[] dst, int dstOffset) {
        int index;
        int i2;
        int i;
        byte b;
        index = 0;
        int i3 = 8;
        while (index < i3) {
            dstOffset[obj8 + index] = (byte)i6;
            index++;
            i3 = 8;
        }
    }

    private static final long toLong$UuidKt__UuidKt(byte[] $this$toLong, int startIndex) {
        int i11 = 255;
        return i9 |= i12;
    }

    public static final kotlin.uuid.Uuid uuidFromRandomBytes(byte[] randomBytes) {
        Intrinsics.checkNotNullParameter(randomBytes, "randomBytes");
        int i = 6;
        randomBytes[i] = (byte)i3;
        randomBytes[i] = (byte)i4;
        int i2 = 8;
        randomBytes[i2] = (byte)i5;
        randomBytes[i2] = (byte)i6;
        return Uuid.Companion.fromByteArray(randomBytes);
    }
}
