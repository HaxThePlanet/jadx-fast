package kotlin;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.UIntRange;
import kotlin.ranges.URangesKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\u0008!\n\u0002\u0018\u0002\n\u0002\u0008\u0014\n\u0002\u0010\u0005\n\u0002\u0008\u0003\n\u0002\u0010\u0006\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0002\u0008\u0005\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0010\n\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u000e\u0008\u0087@\u0018\u0000 {2\u0008\u0012\u0004\u0012\u00020\u00000\u0001:\u0001{B\u0011\u0008\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u0018\u0010\u0008\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\u000c¢\u0006\u0004\u0008\n\u0010\u000bJ\u0018\u0010\u000c\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\rH\u0087\n¢\u0006\u0004\u0008\u000e\u0010\u000fJ\u0018\u0010\u000c\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0000H\u0097\n¢\u0006\u0004\u0008\u0010\u0010\u000bJ\u0018\u0010\u000c\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\u0008\u0012\u0010\u0013J\u0018\u0010\u000c\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0014H\u0087\n¢\u0006\u0004\u0008\u0015\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\u0008\u0018\u0010\u0005J\u0018\u0010\u0019\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\n¢\u0006\u0004\u0008\u001a\u0010\u000fJ\u0018\u0010\u0019\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\u0008\u001b\u0010\u000bJ\u0018\u0010\u0019\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\u0008\u001c\u0010\u001dJ\u0018\u0010\u0019\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\n¢\u0006\u0004\u0008\u001e\u0010\u0016J\u001a\u0010\u001f\u001a\u00020 2\u0008\u0010\t\u001a\u0004\u0018\u00010!HÖ\u0003¢\u0006\u0004\u0008\"\u0010#J\u0018\u0010$\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\u0008¢\u0006\u0004\u0008%\u0010\u000fJ\u0018\u0010$\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\u0008¢\u0006\u0004\u0008&\u0010\u000bJ\u0018\u0010$\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\u0008¢\u0006\u0004\u0008'\u0010\u001dJ\u0018\u0010$\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\u0008¢\u0006\u0004\u0008(\u0010\u0016J\u0010\u0010)\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\u0008*\u0010\u0005J\u0013\u0010+\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\u0008,\u0010\u0005J\u0013\u0010-\u001a\u00020\u0000H\u0087\u0008ø\u0001\u0000¢\u0006\u0004\u0008.\u0010\u0005J\u0018\u0010/\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\n¢\u0006\u0004\u00080\u0010\u000fJ\u0018\u0010/\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\u00081\u0010\u000bJ\u0018\u0010/\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\u00082\u0010\u001dJ\u0018\u0010/\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\n¢\u0006\u0004\u00083\u0010\u0016J\u0018\u00104\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\rH\u0087\u0008¢\u0006\u0004\u00085\u00106J\u0018\u00104\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\u0008¢\u0006\u0004\u00087\u0010\u000bJ\u0018\u00104\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\u0008¢\u0006\u0004\u00088\u0010\u001dJ\u0018\u00104\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\u0008¢\u0006\u0004\u00089\u0010:J\u0018\u0010;\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\u000c¢\u0006\u0004\u0008<\u0010\u000bJ\u0018\u0010=\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\n¢\u0006\u0004\u0008>\u0010\u000fJ\u0018\u0010=\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\u0008?\u0010\u000bJ\u0018\u0010=\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\u0008@\u0010\u001dJ\u0018\u0010=\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\n¢\u0006\u0004\u0008A\u0010\u0016J\u0018\u0010B\u001a\u00020C2\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\u0008D\u0010EJ\u0018\u0010F\u001a\u00020C2\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\u0008G\u0010EJ\u0018\u0010H\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\n¢\u0006\u0004\u0008I\u0010\u000fJ\u0018\u0010H\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\u0008J\u0010\u000bJ\u0018\u0010H\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\u0008K\u0010\u001dJ\u0018\u0010H\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\n¢\u0006\u0004\u0008L\u0010\u0016J\u001b\u0010M\u001a\u00020\u00002\u0006\u0010N\u001a\u00020\u0003H\u0087\u000cø\u0001\u0000¢\u0006\u0004\u0008O\u0010\u000bJ\u001b\u0010P\u001a\u00020\u00002\u0006\u0010N\u001a\u00020\u0003H\u0087\u000cø\u0001\u0000¢\u0006\u0004\u0008Q\u0010\u000bJ\u0018\u0010R\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\n¢\u0006\u0004\u0008S\u0010\u000fJ\u0018\u0010R\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\u0008T\u0010\u000bJ\u0018\u0010R\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\u0008U\u0010\u001dJ\u0018\u0010R\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\n¢\u0006\u0004\u0008V\u0010\u0016J\u0010\u0010W\u001a\u00020XH\u0087\u0008¢\u0006\u0004\u0008Y\u0010ZJ\u0010\u0010[\u001a\u00020\\H\u0087\u0008¢\u0006\u0004\u0008]\u0010^J\u0010\u0010_\u001a\u00020`H\u0087\u0008¢\u0006\u0004\u0008a\u0010bJ\u0010\u0010c\u001a\u00020\u0003H\u0087\u0008¢\u0006\u0004\u0008d\u0010\u0005J\u0010\u0010e\u001a\u00020fH\u0087\u0008¢\u0006\u0004\u0008g\u0010hJ\u0010\u0010i\u001a\u00020jH\u0087\u0008¢\u0006\u0004\u0008k\u0010lJ\u000f\u0010m\u001a\u00020nH\u0016¢\u0006\u0004\u0008o\u0010pJ\u0013\u0010q\u001a\u00020\rH\u0087\u0008ø\u0001\u0000¢\u0006\u0004\u0008r\u0010ZJ\u0013\u0010s\u001a\u00020\u0000H\u0087\u0008ø\u0001\u0000¢\u0006\u0004\u0008t\u0010\u0005J\u0013\u0010u\u001a\u00020\u0011H\u0087\u0008ø\u0001\u0000¢\u0006\u0004\u0008v\u0010hJ\u0013\u0010w\u001a\u00020\u0014H\u0087\u0008ø\u0001\u0000¢\u0006\u0004\u0008x\u0010lJ\u0018\u0010y\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\u000c¢\u0006\u0004\u0008z\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0006\u0010\u0007\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u0082\u0002\u0004\n\u0002\u0008!¨\u0006|", d2 = {"Lkotlin/UInt;", "", "data", "", "constructor-impl", "(I)I", "getData$annotations", "()V", "and", "other", "and-WZ4Q5Ns", "(II)I", "compareTo", "Lkotlin/UByte;", "compareTo-7apg3OU", "(IB)I", "compareTo-WZ4Q5Ns", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(IJ)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(IS)I", "dec", "dec-pVg5ArA", "div", "div-7apg3OU", "div-WZ4Q5Ns", "div-VKZWuLQ", "(IJ)J", "div-xj2QHRw", "equals", "", "", "equals-impl", "(ILjava/lang/Object;)Z", "floorDiv", "floorDiv-7apg3OU", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "floorDiv-xj2QHRw", "hashCode", "hashCode-impl", "inc", "inc-pVg5ArA", "inv", "inv-pVg5ArA", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "mod", "mod-7apg3OU", "(IB)B", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "mod-xj2QHRw", "(IS)S", "or", "or-WZ4Q5Ns", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-WZ4Q5Ns", "(II)Lkotlin/ranges/UIntRange;", "rangeUntil", "rangeUntil-WZ4Q5Ns", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "shl", "bitCount", "shl-pVg5ArA", "shr", "shr-pVg5ArA", "times", "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "", "toByte-impl", "(I)B", "toDouble", "", "toDouble-impl", "(I)D", "toFloat", "", "toFloat-impl", "(I)F", "toInt", "toInt-impl", "toLong", "", "toLong-impl", "(I)J", "toShort", "", "toShort-impl", "(I)S", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "toUByte", "toUByte-w2LRezQ", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toUShort", "toUShort-Mh2AYeg", "xor", "xor-WZ4Q5Ns", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
@JvmInline
public final class UInt implements Comparable<kotlin.UInt> {

    public static final kotlin.UInt.Companion Companion = null;
    public static final int MAX_VALUE = -1;
    public static final int MIN_VALUE = 0;
    public static final int SIZE_BITS = 32;
    public static final int SIZE_BYTES = 4;
    private final int data;

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001a\u00020\u0004X\u0086Tø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005R\u0013\u0010\u0006\u001a\u00020\u0004X\u0086Tø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0007\u001a\u00020\u0008X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0008X\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008!¨\u0006\n", d2 = {"Lkotlin/UInt$Companion;", "", "()V", "MAX_VALUE", "Lkotlin/UInt;", "I", "MIN_VALUE", "SIZE_BITS", "", "SIZE_BYTES", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }
    }
    static {
        UInt.Companion companion = new UInt.Companion(0);
        UInt.Companion = companion;
    }

    private UInt(int data) {
        super();
        this.data = data;
    }

    private static final int and-WZ4Q5Ns(int arg0, int other) {
        return UInt.constructor-impl(arg0 & other);
    }

    public static final kotlin.UInt box-impl(int i) {
        UInt uInt = new UInt(i);
        return uInt;
    }

    private static final int compareTo-7apg3OU(int arg0, byte other) {
        return Integer.compareUnsigned(arg0, UInt.constructor-impl(other & 255));
    }

    private static final int compareTo-VKZWuLQ(int arg0, long other) {
        return Long.compareUnsigned(ULong.constructor-impl(l &= l2), obj1);
    }

    private int compareTo-WZ4Q5Ns(int other) {
        return UnsignedKt.uintCompare(unbox-impl(), other);
    }

    private static int compareTo-WZ4Q5Ns(int arg0, int other) {
        return UnsignedKt.uintCompare(arg0, other);
    }

    private static final int compareTo-xj2QHRw(int arg0, short other) {
        return Integer.compareUnsigned(arg0, UInt.constructor-impl(i &= other));
    }

    public static int constructor-impl(int i) {
        return i;
    }

    private static final int dec-pVg5ArA(int arg0) {
        return UInt.constructor-impl(arg0 + -1);
    }

    private static final int div-7apg3OU(int arg0, byte other) {
        return Integer.divideUnsigned(arg0, UInt.constructor-impl(other & 255));
    }

    private static final long div-VKZWuLQ(int arg0, long other) {
        return Long.divideUnsigned(ULong.constructor-impl(l &= l2), obj1);
    }

    private static final int div-WZ4Q5Ns(int arg0, int other) {
        return UnsignedKt.uintDivide-J1ME1BU(arg0, other);
    }

    private static final int div-xj2QHRw(int arg0, short other) {
        return Integer.divideUnsigned(arg0, UInt.constructor-impl(i &= other));
    }

    public static boolean equals-impl(int i, Object object2) {
        final int i3 = 0;
        if (!object2 instanceof UInt) {
            return i3;
        }
        if (i != (UInt)object2.unbox-impl()) {
            return i3;
        }
        return 1;
    }

    public static final boolean equals-impl0(int i, int i2) {
        int i3;
        i3 = i == i2 ? 1 : 0;
        return i3;
    }

    private static final int floorDiv-7apg3OU(int arg0, byte other) {
        return Integer.divideUnsigned(arg0, UInt.constructor-impl(other & 255));
    }

    private static final long floorDiv-VKZWuLQ(int arg0, long other) {
        return Long.divideUnsigned(ULong.constructor-impl(l &= l2), obj1);
    }

    private static final int floorDiv-WZ4Q5Ns(int arg0, int other) {
        return Integer.divideUnsigned(arg0, other);
    }

    private static final int floorDiv-xj2QHRw(int arg0, short other) {
        return Integer.divideUnsigned(arg0, UInt.constructor-impl(i &= other));
    }

    public static void getData$annotations() {
    }

    public static int hashCode-impl(int i) {
        return Integer.hashCode(i);
    }

    private static final int inc-pVg5ArA(int arg0) {
        return UInt.constructor-impl(arg0 + 1);
    }

    private static final int inv-pVg5ArA(int arg0) {
        return UInt.constructor-impl(~arg0);
    }

    private static final int minus-7apg3OU(int arg0, byte other) {
        return UInt.constructor-impl(arg0 - constructor-impl);
    }

    private static final long minus-VKZWuLQ(int arg0, long other) {
        return ULong.constructor-impl(constructor-impl -= other);
    }

    private static final int minus-WZ4Q5Ns(int arg0, int other) {
        return UInt.constructor-impl(arg0 - other);
    }

    private static final int minus-xj2QHRw(int arg0, short other) {
        return UInt.constructor-impl(arg0 - constructor-impl);
    }

    private static final byte mod-7apg3OU(int arg0, byte other) {
        return UByte.constructor-impl((byte)remainderUnsigned);
    }

    private static final long mod-VKZWuLQ(int arg0, long other) {
        return Long.remainderUnsigned(ULong.constructor-impl(l &= l2), obj1);
    }

    private static final int mod-WZ4Q5Ns(int arg0, int other) {
        return Integer.remainderUnsigned(arg0, other);
    }

    private static final short mod-xj2QHRw(int arg0, short other) {
        return UShort.constructor-impl((short)remainderUnsigned);
    }

    private static final int or-WZ4Q5Ns(int arg0, int other) {
        return UInt.constructor-impl(arg0 | other);
    }

    private static final int plus-7apg3OU(int arg0, byte other) {
        return UInt.constructor-impl(constructor-impl += arg0);
    }

    private static final long plus-VKZWuLQ(int arg0, long other) {
        return ULong.constructor-impl(constructor-impl += other);
    }

    private static final int plus-WZ4Q5Ns(int arg0, int other) {
        return UInt.constructor-impl(arg0 + other);
    }

    private static final int plus-xj2QHRw(int arg0, short other) {
        return UInt.constructor-impl(constructor-impl += arg0);
    }

    private static final UIntRange rangeTo-WZ4Q5Ns(int arg0, int other) {
        UIntRange uIntRange = new UIntRange(arg0, other, 0);
        return uIntRange;
    }

    private static final UIntRange rangeUntil-WZ4Q5Ns(int arg0, int other) {
        return URangesKt.until-J1ME1BU(arg0, other);
    }

    private static final int rem-7apg3OU(int arg0, byte other) {
        return Integer.remainderUnsigned(arg0, UInt.constructor-impl(other & 255));
    }

    private static final long rem-VKZWuLQ(int arg0, long other) {
        return Long.remainderUnsigned(ULong.constructor-impl(l &= l2), obj1);
    }

    private static final int rem-WZ4Q5Ns(int arg0, int other) {
        return UnsignedKt.uintRemainder-J1ME1BU(arg0, other);
    }

    private static final int rem-xj2QHRw(int arg0, short other) {
        return Integer.remainderUnsigned(arg0, UInt.constructor-impl(i &= other));
    }

    private static final int shl-pVg5ArA(int arg0, int bitCount) {
        return UInt.constructor-impl(arg0 << bitCount);
    }

    private static final int shr-pVg5ArA(int arg0, int bitCount) {
        return UInt.constructor-impl(arg0 >>> bitCount);
    }

    private static final int times-7apg3OU(int arg0, byte other) {
        return UInt.constructor-impl(constructor-impl *= arg0);
    }

    private static final long times-VKZWuLQ(int arg0, long other) {
        return ULong.constructor-impl(constructor-impl *= other);
    }

    private static final int times-WZ4Q5Ns(int arg0, int other) {
        return UInt.constructor-impl(arg0 * other);
    }

    private static final int times-xj2QHRw(int arg0, short other) {
        return UInt.constructor-impl(constructor-impl *= arg0);
    }

    private static final byte toByte-impl(int arg0) {
        return (byte)arg0;
    }

    private static final double toDouble-impl(int arg0) {
        return UnsignedKt.uintToDouble(arg0);
    }

    private static final float toFloat-impl(int arg0) {
        return (float)uintToDouble;
    }

    private static final int toInt-impl(int arg0) {
        return arg0;
    }

    private static final long toLong-impl(int arg0) {
        return l &= l2;
    }

    private static final short toShort-impl(int arg0) {
        return (short)arg0;
    }

    public static String toString-impl(int arg0) {
        return String.valueOf(l &= l2);
    }

    private static final byte toUByte-w2LRezQ(int arg0) {
        return UByte.constructor-impl((byte)arg0);
    }

    private static final int toUInt-pVg5ArA(int arg0) {
        return arg0;
    }

    private static final long toULong-s-VKNKU(int arg0) {
        return ULong.constructor-impl(l &= l2);
    }

    private static final short toUShort-Mh2AYeg(int arg0) {
        return UShort.constructor-impl((short)arg0);
    }

    private static final int xor-WZ4Q5Ns(int arg0, int other) {
        return UInt.constructor-impl(arg0 ^ other);
    }

    @Override // java.lang.Comparable
    public int compareTo(Object other) {
        return UnsignedKt.uintCompare(unbox-impl(), (UInt)other.unbox-impl());
    }

    @Override // java.lang.Comparable
    public boolean equals(Object object) {
        return UInt.equals-impl(this.data, object);
    }

    @Override // java.lang.Comparable
    public int hashCode() {
        return UInt.hashCode-impl(this.data);
    }

    @Override // java.lang.Comparable
    public String toString() {
        return UInt.toString-impl(this.data);
    }

    @Override // java.lang.Comparable
    public final int unbox-impl() {
        return this.data;
    }
}
