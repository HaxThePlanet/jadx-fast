package kotlin;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000&\n\u0000\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008)\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\u0008¢\u0006\u0004\u0008\u0003\u0010\u0004\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u0005H\u0087\u0008¢\u0006\u0004\u0008\u0006\u0010\u0007\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u0008H\u0087\u0008¢\u0006\u0004\u0008\t\u0010\n\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u000bH\u0087\u0008¢\u0006\u0004\u0008\u000c\u0010\r\u001a\u0014\u0010\u000e\u001a\u00020\u0001*\u00020\u0002H\u0087\u0008¢\u0006\u0004\u0008\u000f\u0010\u0004\u001a\u0014\u0010\u000e\u001a\u00020\u0001*\u00020\u0005H\u0087\u0008¢\u0006\u0004\u0008\u0010\u0010\u0007\u001a\u0014\u0010\u000e\u001a\u00020\u0001*\u00020\u0008H\u0087\u0008¢\u0006\u0004\u0008\u0011\u0010\n\u001a\u0014\u0010\u000e\u001a\u00020\u0001*\u00020\u000bH\u0087\u0008¢\u0006\u0004\u0008\u0012\u0010\r\u001a\u0014\u0010\u0013\u001a\u00020\u0001*\u00020\u0002H\u0087\u0008¢\u0006\u0004\u0008\u0014\u0010\u0004\u001a\u0014\u0010\u0013\u001a\u00020\u0001*\u00020\u0005H\u0087\u0008¢\u0006\u0004\u0008\u0015\u0010\u0007\u001a\u0014\u0010\u0013\u001a\u00020\u0001*\u00020\u0008H\u0087\u0008¢\u0006\u0004\u0008\u0016\u0010\n\u001a\u0014\u0010\u0013\u001a\u00020\u0001*\u00020\u000bH\u0087\u0008¢\u0006\u0004\u0008\u0017\u0010\r\u001a\u001c\u0010\u0018\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0001H\u0087\u0008¢\u0006\u0004\u0008\u001a\u0010\u001b\u001a\u001c\u0010\u0018\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0001H\u0087\u0008¢\u0006\u0004\u0008\u001c\u0010\u001d\u001a\u001c\u0010\u0018\u001a\u00020\u0008*\u00020\u00082\u0006\u0010\u0019\u001a\u00020\u0001H\u0087\u0008¢\u0006\u0004\u0008\u001e\u0010\u001f\u001a\u001c\u0010\u0018\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0001H\u0087\u0008¢\u0006\u0004\u0008 \u0010!\u001a\u001c\u0010\"\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0001H\u0087\u0008¢\u0006\u0004\u0008#\u0010\u001b\u001a\u001c\u0010\"\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0001H\u0087\u0008¢\u0006\u0004\u0008$\u0010\u001d\u001a\u001c\u0010\"\u001a\u00020\u0008*\u00020\u00082\u0006\u0010\u0019\u001a\u00020\u0001H\u0087\u0008¢\u0006\u0004\u0008%\u0010\u001f\u001a\u001c\u0010\"\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0001H\u0087\u0008¢\u0006\u0004\u0008&\u0010!\u001a\u0014\u0010'\u001a\u00020\u0002*\u00020\u0002H\u0087\u0008¢\u0006\u0004\u0008(\u0010)\u001a\u0014\u0010'\u001a\u00020\u0005*\u00020\u0005H\u0087\u0008¢\u0006\u0004\u0008*\u0010\u0007\u001a\u0014\u0010'\u001a\u00020\u0008*\u00020\u0008H\u0087\u0008¢\u0006\u0004\u0008+\u0010,\u001a\u0014\u0010'\u001a\u00020\u000b*\u00020\u000bH\u0087\u0008¢\u0006\u0004\u0008-\u0010.\u001a\u0014\u0010/\u001a\u00020\u0002*\u00020\u0002H\u0087\u0008¢\u0006\u0004\u00080\u0010)\u001a\u0014\u0010/\u001a\u00020\u0005*\u00020\u0005H\u0087\u0008¢\u0006\u0004\u00081\u0010\u0007\u001a\u0014\u0010/\u001a\u00020\u0008*\u00020\u0008H\u0087\u0008¢\u0006\u0004\u00082\u0010,\u001a\u0014\u0010/\u001a\u00020\u000b*\u00020\u000bH\u0087\u0008¢\u0006\u0004\u00083\u0010.¨\u00064", d2 = {"countLeadingZeroBits", "", "Lkotlin/UByte;", "countLeadingZeroBits-7apg3OU", "(B)I", "Lkotlin/UInt;", "countLeadingZeroBits-WZ4Q5Ns", "(I)I", "Lkotlin/ULong;", "countLeadingZeroBits-VKZWuLQ", "(J)I", "Lkotlin/UShort;", "countLeadingZeroBits-xj2QHRw", "(S)I", "countOneBits", "countOneBits-7apg3OU", "countOneBits-WZ4Q5Ns", "countOneBits-VKZWuLQ", "countOneBits-xj2QHRw", "countTrailingZeroBits", "countTrailingZeroBits-7apg3OU", "countTrailingZeroBits-WZ4Q5Ns", "countTrailingZeroBits-VKZWuLQ", "countTrailingZeroBits-xj2QHRw", "rotateLeft", "bitCount", "rotateLeft-LxnNnR4", "(BI)B", "rotateLeft-V7xB4Y4", "(II)I", "rotateLeft-JSWoG40", "(JI)J", "rotateLeft-olVBNx4", "(SI)S", "rotateRight", "rotateRight-LxnNnR4", "rotateRight-V7xB4Y4", "rotateRight-JSWoG40", "rotateRight-olVBNx4", "takeHighestOneBit", "takeHighestOneBit-7apg3OU", "(B)B", "takeHighestOneBit-WZ4Q5Ns", "takeHighestOneBit-VKZWuLQ", "(J)J", "takeHighestOneBit-xj2QHRw", "(S)S", "takeLowestOneBit", "takeLowestOneBit-7apg3OU", "takeLowestOneBit-WZ4Q5Ns", "takeLowestOneBit-VKZWuLQ", "takeLowestOneBit-xj2QHRw", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class UNumbersKt {
    private static final int countLeadingZeroBits-7apg3OU(byte $this$countLeadingZeroBits_u2d7apg3OU) {
        return numberOfLeadingZeros += -24;
    }

    private static final int countLeadingZeroBits-VKZWuLQ(long $this$countLeadingZeroBits_u2dVKZWuLQ) {
        return Long.numberOfLeadingZeros($this$countLeadingZeroBits_u2dVKZWuLQ);
    }

    private static final int countLeadingZeroBits-WZ4Q5Ns(int $this$countLeadingZeroBits_u2dWZ4Q5Ns) {
        return Integer.numberOfLeadingZeros($this$countLeadingZeroBits_u2dWZ4Q5Ns);
    }

    private static final int countLeadingZeroBits-xj2QHRw(short $this$countLeadingZeroBits_u2dxj2QHRw) {
        return numberOfLeadingZeros += -16;
    }

    private static final int countOneBits-7apg3OU(byte $this$countOneBits_u2d7apg3OU) {
        return Integer.bitCount(UInt.constructor-impl($this$countOneBits_u2d7apg3OU & 255));
    }

    private static final int countOneBits-VKZWuLQ(long $this$countOneBits_u2dVKZWuLQ) {
        return Long.bitCount($this$countOneBits_u2dVKZWuLQ);
    }

    private static final int countOneBits-WZ4Q5Ns(int $this$countOneBits_u2dWZ4Q5Ns) {
        return Integer.bitCount($this$countOneBits_u2dWZ4Q5Ns);
    }

    private static final int countOneBits-xj2QHRw(short $this$countOneBits_u2dxj2QHRw) {
        return Integer.bitCount(UInt.constructor-impl(i &= $this$countOneBits_u2dxj2QHRw));
    }

    private static final int countTrailingZeroBits-7apg3OU(byte $this$countTrailingZeroBits_u2d7apg3OU) {
        return Integer.numberOfTrailingZeros($this$countTrailingZeroBits_u2d7apg3OU | 256);
    }

    private static final int countTrailingZeroBits-VKZWuLQ(long $this$countTrailingZeroBits_u2dVKZWuLQ) {
        return Long.numberOfTrailingZeros($this$countTrailingZeroBits_u2dVKZWuLQ);
    }

    private static final int countTrailingZeroBits-WZ4Q5Ns(int $this$countTrailingZeroBits_u2dWZ4Q5Ns) {
        return Integer.numberOfTrailingZeros($this$countTrailingZeroBits_u2dWZ4Q5Ns);
    }

    private static final int countTrailingZeroBits-xj2QHRw(short $this$countTrailingZeroBits_u2dxj2QHRw) {
        return Integer.numberOfTrailingZeros(i |= $this$countTrailingZeroBits_u2dxj2QHRw);
    }

    private static final long rotateLeft-JSWoG40(long $this$rotateLeft_u2dJSWoG40, int bitCount) {
        return ULong.constructor-impl(Long.rotateLeft($this$rotateLeft_u2dJSWoG40, bitCount));
    }

    private static final byte rotateLeft-LxnNnR4(byte $this$rotateLeft_u2dLxnNnR4, int bitCount) {
        return UByte.constructor-impl(NumbersKt.rotateLeft($this$rotateLeft_u2dLxnNnR4, bitCount));
    }

    private static final int rotateLeft-V7xB4Y4(int $this$rotateLeft_u2dV7xB4Y4, int bitCount) {
        return UInt.constructor-impl(Integer.rotateLeft($this$rotateLeft_u2dV7xB4Y4, bitCount));
    }

    private static final short rotateLeft-olVBNx4(short $this$rotateLeft_u2dolVBNx4, int bitCount) {
        return UShort.constructor-impl(NumbersKt.rotateLeft($this$rotateLeft_u2dolVBNx4, bitCount));
    }

    private static final long rotateRight-JSWoG40(long $this$rotateRight_u2dJSWoG40, int bitCount) {
        return ULong.constructor-impl(Long.rotateRight($this$rotateRight_u2dJSWoG40, bitCount));
    }

    private static final byte rotateRight-LxnNnR4(byte $this$rotateRight_u2dLxnNnR4, int bitCount) {
        return UByte.constructor-impl(NumbersKt.rotateRight($this$rotateRight_u2dLxnNnR4, bitCount));
    }

    private static final int rotateRight-V7xB4Y4(int $this$rotateRight_u2dV7xB4Y4, int bitCount) {
        return UInt.constructor-impl(Integer.rotateRight($this$rotateRight_u2dV7xB4Y4, bitCount));
    }

    private static final short rotateRight-olVBNx4(short $this$rotateRight_u2dolVBNx4, int bitCount) {
        return UShort.constructor-impl(NumbersKt.rotateRight($this$rotateRight_u2dolVBNx4, bitCount));
    }

    private static final byte takeHighestOneBit-7apg3OU(byte $this$takeHighestOneBit_u2d7apg3OU) {
        return UByte.constructor-impl((byte)highestOneBit);
    }

    private static final long takeHighestOneBit-VKZWuLQ(long $this$takeHighestOneBit_u2dVKZWuLQ) {
        return ULong.constructor-impl(Long.highestOneBit($this$takeHighestOneBit_u2dVKZWuLQ));
    }

    private static final int takeHighestOneBit-WZ4Q5Ns(int $this$takeHighestOneBit_u2dWZ4Q5Ns) {
        return UInt.constructor-impl(Integer.highestOneBit($this$takeHighestOneBit_u2dWZ4Q5Ns));
    }

    private static final short takeHighestOneBit-xj2QHRw(short $this$takeHighestOneBit_u2dxj2QHRw) {
        return UShort.constructor-impl((short)highestOneBit);
    }

    private static final byte takeLowestOneBit-7apg3OU(byte $this$takeLowestOneBit_u2d7apg3OU) {
        return UByte.constructor-impl((byte)lowestOneBit);
    }

    private static final long takeLowestOneBit-VKZWuLQ(long $this$takeLowestOneBit_u2dVKZWuLQ) {
        return ULong.constructor-impl(Long.lowestOneBit($this$takeLowestOneBit_u2dVKZWuLQ));
    }

    private static final int takeLowestOneBit-WZ4Q5Ns(int $this$takeLowestOneBit_u2dWZ4Q5Ns) {
        return UInt.constructor-impl(Integer.lowestOneBit($this$takeLowestOneBit_u2dWZ4Q5Ns));
    }

    private static final short takeLowestOneBit-xj2QHRw(short $this$takeLowestOneBit_u2dxj2QHRw) {
        return UShort.constructor-impl((short)lowestOneBit);
    }
}
