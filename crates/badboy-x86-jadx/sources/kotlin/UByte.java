package kotlin;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.UIntRange;
import kotlin.ranges.URangesKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0005\n\u0002\u0008\t\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\u0008!\n\u0002\u0018\u0002\n\u0002\u0008\u0011\n\u0002\u0010\u0006\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0002\u0008\u0005\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0010\n\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u000e\u0008\u0087@\u0018\u0000 v2\u0008\u0012\u0004\u0012\u00020\u00000\u0001:\u0001vB\u0011\u0008\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u0018\u0010\u0008\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\u000c¢\u0006\u0004\u0008\n\u0010\u000bJ\u0018\u0010\u000c\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0000H\u0097\n¢\u0006\u0004\u0008\u000e\u0010\u000fJ\u0018\u0010\u000c\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0010H\u0087\n¢\u0006\u0004\u0008\u0011\u0010\u0012J\u0018\u0010\u000c\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0013H\u0087\n¢\u0006\u0004\u0008\u0014\u0010\u0015J\u0018\u0010\u000c\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0016H\u0087\n¢\u0006\u0004\u0008\u0017\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\u0008\u001a\u0010\u0005J\u0018\u0010\u001b\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\u0008\u001c\u0010\u000fJ\u0018\u0010\u001b\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\n¢\u0006\u0004\u0008\u001d\u0010\u0012J\u0018\u0010\u001b\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\n¢\u0006\u0004\u0008\u001e\u0010\u001fJ\u0018\u0010\u001b\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\u0087\n¢\u0006\u0004\u0008 \u0010\u0018J\u001a\u0010!\u001a\u00020\"2\u0008\u0010\t\u001a\u0004\u0018\u00010#HÖ\u0003¢\u0006\u0004\u0008$\u0010%J\u0018\u0010&\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\u0087\u0008¢\u0006\u0004\u0008'\u0010\u000fJ\u0018\u0010&\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\u0008¢\u0006\u0004\u0008(\u0010\u0012J\u0018\u0010&\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\u0008¢\u0006\u0004\u0008)\u0010\u001fJ\u0018\u0010&\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\u0087\u0008¢\u0006\u0004\u0008*\u0010\u0018J\u0010\u0010+\u001a\u00020\rHÖ\u0001¢\u0006\u0004\u0008,\u0010-J\u0013\u0010.\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\u0008/\u0010\u0005J\u0013\u00100\u001a\u00020\u0000H\u0087\u0008ø\u0001\u0000¢\u0006\u0004\u00081\u0010\u0005J\u0018\u00102\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\u00083\u0010\u000fJ\u0018\u00102\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\n¢\u0006\u0004\u00084\u0010\u0012J\u0018\u00102\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\n¢\u0006\u0004\u00085\u0010\u001fJ\u0018\u00102\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\u0087\n¢\u0006\u0004\u00086\u0010\u0018J\u0018\u00107\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\u0008¢\u0006\u0004\u00088\u0010\u000bJ\u0018\u00107\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\u0008¢\u0006\u0004\u00089\u0010\u0012J\u0018\u00107\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\u0008¢\u0006\u0004\u0008:\u0010\u001fJ\u0018\u00107\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u0016H\u0087\u0008¢\u0006\u0004\u0008;\u0010<J\u0018\u0010=\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\u000c¢\u0006\u0004\u0008>\u0010\u000bJ\u0018\u0010?\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\u0008@\u0010\u000fJ\u0018\u0010?\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\n¢\u0006\u0004\u0008A\u0010\u0012J\u0018\u0010?\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\n¢\u0006\u0004\u0008B\u0010\u001fJ\u0018\u0010?\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\u0087\n¢\u0006\u0004\u0008C\u0010\u0018J\u0018\u0010D\u001a\u00020E2\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\u0008F\u0010GJ\u0018\u0010H\u001a\u00020E2\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\u0008I\u0010GJ\u0018\u0010J\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\u0008K\u0010\u000fJ\u0018\u0010J\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\n¢\u0006\u0004\u0008L\u0010\u0012J\u0018\u0010J\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\n¢\u0006\u0004\u0008M\u0010\u001fJ\u0018\u0010J\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\u0087\n¢\u0006\u0004\u0008N\u0010\u0018J\u0018\u0010O\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\u0008P\u0010\u000fJ\u0018\u0010O\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\n¢\u0006\u0004\u0008Q\u0010\u0012J\u0018\u0010O\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\n¢\u0006\u0004\u0008R\u0010\u001fJ\u0018\u0010O\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\u0087\n¢\u0006\u0004\u0008S\u0010\u0018J\u0010\u0010T\u001a\u00020\u0003H\u0087\u0008¢\u0006\u0004\u0008U\u0010\u0005J\u0010\u0010V\u001a\u00020WH\u0087\u0008¢\u0006\u0004\u0008X\u0010YJ\u0010\u0010Z\u001a\u00020[H\u0087\u0008¢\u0006\u0004\u0008\\\u0010]J\u0010\u0010^\u001a\u00020\rH\u0087\u0008¢\u0006\u0004\u0008_\u0010-J\u0010\u0010`\u001a\u00020aH\u0087\u0008¢\u0006\u0004\u0008b\u0010cJ\u0010\u0010d\u001a\u00020eH\u0087\u0008¢\u0006\u0004\u0008f\u0010gJ\u000f\u0010h\u001a\u00020iH\u0016¢\u0006\u0004\u0008j\u0010kJ\u0013\u0010l\u001a\u00020\u0000H\u0087\u0008ø\u0001\u0000¢\u0006\u0004\u0008m\u0010\u0005J\u0013\u0010n\u001a\u00020\u0010H\u0087\u0008ø\u0001\u0000¢\u0006\u0004\u0008o\u0010-J\u0013\u0010p\u001a\u00020\u0013H\u0087\u0008ø\u0001\u0000¢\u0006\u0004\u0008q\u0010cJ\u0013\u0010r\u001a\u00020\u0016H\u0087\u0008ø\u0001\u0000¢\u0006\u0004\u0008s\u0010gJ\u0018\u0010t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\u000c¢\u0006\u0004\u0008u\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0006\u0010\u0007\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u0082\u0002\u0004\n\u0002\u0008!¨\u0006w", d2 = {"Lkotlin/UByte;", "", "data", "", "constructor-impl", "(B)B", "getData$annotations", "()V", "and", "other", "and-7apg3OU", "(BB)B", "compareTo", "", "compareTo-7apg3OU", "(BB)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(BI)I", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(BJ)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(BS)I", "dec", "dec-w2LRezQ", "div", "div-7apg3OU", "div-WZ4Q5Ns", "div-VKZWuLQ", "(BJ)J", "div-xj2QHRw", "equals", "", "", "equals-impl", "(BLjava/lang/Object;)Z", "floorDiv", "floorDiv-7apg3OU", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "floorDiv-xj2QHRw", "hashCode", "hashCode-impl", "(B)I", "inc", "inc-w2LRezQ", "inv", "inv-w2LRezQ", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "mod", "mod-7apg3OU", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "mod-xj2QHRw", "(BS)S", "or", "or-7apg3OU", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-7apg3OU", "(BB)Lkotlin/ranges/UIntRange;", "rangeUntil", "rangeUntil-7apg3OU", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "times", "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "toByte-impl", "toDouble", "", "toDouble-impl", "(B)D", "toFloat", "", "toFloat-impl", "(B)F", "toInt", "toInt-impl", "toLong", "", "toLong-impl", "(B)J", "toShort", "", "toShort-impl", "(B)S", "toString", "", "toString-impl", "(B)Ljava/lang/String;", "toUByte", "toUByte-w2LRezQ", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toUShort", "toUShort-Mh2AYeg", "xor", "xor-7apg3OU", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
@JvmInline
public final class UByte implements Comparable<kotlin.UByte> {

    public static final kotlin.UByte.Companion Companion = null;
    public static final byte MAX_VALUE = (byte) -1;
    public static final byte MIN_VALUE = (byte) 0;
    public static final int SIZE_BITS = 8;
    public static final int SIZE_BYTES = 1;
    private final byte data;

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001a\u00020\u0004X\u0086Tø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005R\u0013\u0010\u0006\u001a\u00020\u0004X\u0086Tø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0007\u001a\u00020\u0008X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0008X\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008!¨\u0006\n", d2 = {"Lkotlin/UByte$Companion;", "", "()V", "MAX_VALUE", "Lkotlin/UByte;", "B", "MIN_VALUE", "SIZE_BITS", "", "SIZE_BYTES", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }
    }
    static {
        UByte.Companion companion = new UByte.Companion(0);
        UByte.Companion = companion;
    }

    private UByte(byte data) {
        super();
        this.data = data;
    }

    private static final byte and-7apg3OU(byte arg0, byte other) {
        return UByte.constructor-impl((byte)i);
    }

    public static final kotlin.UByte box-impl(byte b) {
        UByte uByte = new UByte(b);
        return uByte;
    }

    private int compareTo-7apg3OU(byte other) {
        return Intrinsics.compare(unbox-impl &= 255, other & 255);
    }

    private static int compareTo-7apg3OU(byte arg0, byte other) {
        return Intrinsics.compare(arg0 & 255, other & 255);
    }

    private static final int compareTo-VKZWuLQ(byte arg0, long other) {
        return Long.compareUnsigned(ULong.constructor-impl(l &= i2), obj1);
    }

    private static final int compareTo-WZ4Q5Ns(byte arg0, int other) {
        return Integer.compareUnsigned(UInt.constructor-impl(arg0 & 255), other);
    }

    private static final int compareTo-xj2QHRw(byte arg0, short other) {
        return Intrinsics.compare(arg0 & 255, i2 &= other);
    }

    public static byte constructor-impl(byte b) {
        return b;
    }

    private static final byte dec-w2LRezQ(byte arg0) {
        return UByte.constructor-impl((byte)i);
    }

    private static final int div-7apg3OU(byte arg0, byte other) {
        return Integer.divideUnsigned(UInt.constructor-impl(arg0 & 255), UInt.constructor-impl(other & 255));
    }

    private static final long div-VKZWuLQ(byte arg0, long other) {
        return Long.divideUnsigned(ULong.constructor-impl(l &= i2), obj1);
    }

    private static final int div-WZ4Q5Ns(byte arg0, int other) {
        return Integer.divideUnsigned(UInt.constructor-impl(arg0 & 255), other);
    }

    private static final int div-xj2QHRw(byte arg0, short other) {
        return Integer.divideUnsigned(UInt.constructor-impl(arg0 & 255), UInt.constructor-impl(i2 &= other));
    }

    public static boolean equals-impl(byte b, Object object2) {
        final int i2 = 0;
        if (!object2 instanceof UByte) {
            return i2;
        }
        if (b != (UByte)object2.unbox-impl()) {
            return i2;
        }
        return 1;
    }

    public static final boolean equals-impl0(byte b, byte b2) {
        int i;
        i = b == b2 ? 1 : 0;
        return i;
    }

    private static final int floorDiv-7apg3OU(byte arg0, byte other) {
        return Integer.divideUnsigned(UInt.constructor-impl(arg0 & 255), UInt.constructor-impl(other & 255));
    }

    private static final long floorDiv-VKZWuLQ(byte arg0, long other) {
        return Long.divideUnsigned(ULong.constructor-impl(l &= i2), obj1);
    }

    private static final int floorDiv-WZ4Q5Ns(byte arg0, int other) {
        return Integer.divideUnsigned(UInt.constructor-impl(arg0 & 255), other);
    }

    private static final int floorDiv-xj2QHRw(byte arg0, short other) {
        return Integer.divideUnsigned(UInt.constructor-impl(arg0 & 255), UInt.constructor-impl(i2 &= other));
    }

    public static void getData$annotations() {
    }

    public static int hashCode-impl(byte b) {
        return Byte.hashCode(b);
    }

    private static final byte inc-w2LRezQ(byte arg0) {
        return UByte.constructor-impl((byte)i);
    }

    private static final byte inv-w2LRezQ(byte arg0) {
        return UByte.constructor-impl((byte)i);
    }

    private static final int minus-7apg3OU(byte arg0, byte other) {
        return UInt.constructor-impl(constructor-impl -= constructor-impl3);
    }

    private static final long minus-VKZWuLQ(byte arg0, long other) {
        return ULong.constructor-impl(constructor-impl -= other);
    }

    private static final int minus-WZ4Q5Ns(byte arg0, int other) {
        return UInt.constructor-impl(constructor-impl -= other);
    }

    private static final int minus-xj2QHRw(byte arg0, short other) {
        return UInt.constructor-impl(constructor-impl -= constructor-impl3);
    }

    private static final byte mod-7apg3OU(byte arg0, byte other) {
        return UByte.constructor-impl((byte)remainderUnsigned);
    }

    private static final long mod-VKZWuLQ(byte arg0, long other) {
        return Long.remainderUnsigned(ULong.constructor-impl(l &= i2), obj1);
    }

    private static final int mod-WZ4Q5Ns(byte arg0, int other) {
        return Integer.remainderUnsigned(UInt.constructor-impl(arg0 & 255), other);
    }

    private static final short mod-xj2QHRw(byte arg0, short other) {
        return UShort.constructor-impl((short)remainderUnsigned);
    }

    private static final byte or-7apg3OU(byte arg0, byte other) {
        return UByte.constructor-impl((byte)i);
    }

    private static final int plus-7apg3OU(byte arg0, byte other) {
        return UInt.constructor-impl(constructor-impl += constructor-impl3);
    }

    private static final long plus-VKZWuLQ(byte arg0, long other) {
        return ULong.constructor-impl(constructor-impl += other);
    }

    private static final int plus-WZ4Q5Ns(byte arg0, int other) {
        return UInt.constructor-impl(constructor-impl += other);
    }

    private static final int plus-xj2QHRw(byte arg0, short other) {
        return UInt.constructor-impl(constructor-impl += constructor-impl3);
    }

    private static final UIntRange rangeTo-7apg3OU(byte arg0, byte other) {
        UIntRange uIntRange = new UIntRange(UInt.constructor-impl(arg0 & 255), UInt.constructor-impl(other & 255), 0);
        return uIntRange;
    }

    private static final UIntRange rangeUntil-7apg3OU(byte arg0, byte other) {
        return URangesKt.until-J1ME1BU(UInt.constructor-impl(arg0 & 255), UInt.constructor-impl(other & 255));
    }

    private static final int rem-7apg3OU(byte arg0, byte other) {
        return Integer.remainderUnsigned(UInt.constructor-impl(arg0 & 255), UInt.constructor-impl(other & 255));
    }

    private static final long rem-VKZWuLQ(byte arg0, long other) {
        return Long.remainderUnsigned(ULong.constructor-impl(l &= i2), obj1);
    }

    private static final int rem-WZ4Q5Ns(byte arg0, int other) {
        return Integer.remainderUnsigned(UInt.constructor-impl(arg0 & 255), other);
    }

    private static final int rem-xj2QHRw(byte arg0, short other) {
        return Integer.remainderUnsigned(UInt.constructor-impl(arg0 & 255), UInt.constructor-impl(i2 &= other));
    }

    private static final int times-7apg3OU(byte arg0, byte other) {
        return UInt.constructor-impl(constructor-impl *= constructor-impl3);
    }

    private static final long times-VKZWuLQ(byte arg0, long other) {
        return ULong.constructor-impl(constructor-impl *= other);
    }

    private static final int times-WZ4Q5Ns(byte arg0, int other) {
        return UInt.constructor-impl(constructor-impl *= other);
    }

    private static final int times-xj2QHRw(byte arg0, short other) {
        return UInt.constructor-impl(constructor-impl *= constructor-impl3);
    }

    private static final byte toByte-impl(byte arg0) {
        return arg0;
    }

    private static final double toDouble-impl(byte arg0) {
        return UnsignedKt.uintToDouble(arg0 & 255);
    }

    private static final float toFloat-impl(byte arg0) {
        return (float)uintToDouble;
    }

    private static final int toInt-impl(byte arg0) {
        return arg0 & 255;
    }

    private static final long toLong-impl(byte arg0) {
        return l &= i2;
    }

    private static final short toShort-impl(byte arg0) {
        return (short)i;
    }

    public static String toString-impl(byte arg0) {
        return String.valueOf(arg0 & 255);
    }

    private static final byte toUByte-w2LRezQ(byte arg0) {
        return arg0;
    }

    private static final int toUInt-pVg5ArA(byte arg0) {
        return UInt.constructor-impl(arg0 & 255);
    }

    private static final long toULong-s-VKNKU(byte arg0) {
        return ULong.constructor-impl(l &= i2);
    }

    private static final short toUShort-Mh2AYeg(byte arg0) {
        return UShort.constructor-impl((short)i);
    }

    private static final byte xor-7apg3OU(byte arg0, byte other) {
        return UByte.constructor-impl((byte)i);
    }

    @Override // java.lang.Comparable
    public int compareTo(Object other) {
        return Intrinsics.compare(unbox-impl2 &= 255, unbox-impl &= 255);
    }

    @Override // java.lang.Comparable
    public boolean equals(Object object) {
        return UByte.equals-impl(this.data, object);
    }

    @Override // java.lang.Comparable
    public int hashCode() {
        return UByte.hashCode-impl(this.data);
    }

    @Override // java.lang.Comparable
    public String toString() {
        return UByte.toString-impl(this.data);
    }

    @Override // java.lang.Comparable
    public final byte unbox-impl() {
        return this.data;
    }
}
