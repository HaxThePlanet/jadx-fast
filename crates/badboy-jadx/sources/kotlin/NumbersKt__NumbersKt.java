package kotlin;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0012\n\u0000\n\u0002\u0010\u0008\n\u0002\u0010\u0005\n\u0002\u0010\n\n\u0002\u0008\u0008\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\u0008\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0003H\u0087\u0008\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\u0002H\u0087\u0008\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\u0003H\u0087\u0008\u001a\r\u0010\u0005\u001a\u00020\u0001*\u00020\u0002H\u0087\u0008\u001a\r\u0010\u0005\u001a\u00020\u0001*\u00020\u0003H\u0087\u0008\u001a\u0014\u0010\u0006\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\u0007\u001a\u0014\u0010\u0006\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0001H\u0007\u001a\u0014\u0010\u0008\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\u0007\u001a\u0014\u0010\u0008\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0001H\u0007\u001a\r\u0010\t\u001a\u00020\u0002*\u00020\u0002H\u0087\u0008\u001a\r\u0010\t\u001a\u00020\u0003*\u00020\u0003H\u0087\u0008\u001a\r\u0010\n\u001a\u00020\u0002*\u00020\u0002H\u0087\u0008\u001a\r\u0010\n\u001a\u00020\u0003*\u00020\u0003H\u0087\u0008¨\u0006\u000b", d2 = {"countLeadingZeroBits", "", "", "", "countOneBits", "countTrailingZeroBits", "rotateLeft", "bitCount", "rotateRight", "takeHighestOneBit", "takeLowestOneBit", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/NumbersKt")
class NumbersKt__NumbersKt extends kotlin.NumbersKt__NumbersJVMKt {
    private static final int countLeadingZeroBits(byte $this$countLeadingZeroBits) {
        return numberOfLeadingZeros += -24;
    }

    private static final int countLeadingZeroBits(short $this$countLeadingZeroBits) {
        return numberOfLeadingZeros += -16;
    }

    private static final int countOneBits(byte $this$countOneBits) {
        return Integer.bitCount($this$countOneBits & 255);
    }

    private static final int countOneBits(short $this$countOneBits) {
        return Integer.bitCount(i &= $this$countOneBits);
    }

    private static final int countTrailingZeroBits(byte $this$countTrailingZeroBits) {
        return Integer.numberOfTrailingZeros($this$countTrailingZeroBits | 256);
    }

    private static final int countTrailingZeroBits(short $this$countTrailingZeroBits) {
        return Integer.numberOfTrailingZeros(i |= $this$countTrailingZeroBits);
    }

    public static final byte rotateLeft(byte $this$rotateLeft, int bitCount) {
        return (byte)i3;
    }

    public static final short rotateLeft(short $this$rotateLeft, int bitCount) {
        return (short)i3;
    }

    public static final byte rotateRight(byte $this$rotateRight, int bitCount) {
        return (byte)i4;
    }

    public static final short rotateRight(short $this$rotateRight, int bitCount) {
        return (short)i4;
    }

    private static final byte takeHighestOneBit(byte $this$takeHighestOneBit) {
        return (byte)highestOneBit;
    }

    private static final short takeHighestOneBit(short $this$takeHighestOneBit) {
        return (short)highestOneBit;
    }

    private static final byte takeLowestOneBit(byte $this$takeLowestOneBit) {
        return (byte)lowestOneBit;
    }

    private static final short takeLowestOneBit(short $this$takeLowestOneBit) {
        return (short)lowestOneBit;
    }
}
