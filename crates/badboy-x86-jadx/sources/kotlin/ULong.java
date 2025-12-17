package kotlin;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.ULongRange;
import kotlin.ranges.URangesKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\t\n\u0002\u0008\t\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\u0008\"\n\u0002\u0018\u0002\n\u0002\u0008\u0014\n\u0002\u0010\u0005\n\u0002\u0008\u0003\n\u0002\u0010\u0006\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0002\u0008\u0007\n\u0002\u0010\n\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u000e\u0008\u0087@\u0018\u0000 ~2\u0008\u0012\u0004\u0012\u00020\u00000\u0001:\u0001~B\u0011\u0008\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u0018\u0010\u0008\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\u000c¢\u0006\u0004\u0008\n\u0010\u000bJ\u0018\u0010\u000c\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u000eH\u0087\n¢\u0006\u0004\u0008\u000f\u0010\u0010J\u0018\u0010\u000c\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\u0008\u0012\u0010\u0013J\u0018\u0010\u000c\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0000H\u0097\n¢\u0006\u0004\u0008\u0014\u0010\u0015J\u0018\u0010\u000c\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0016H\u0087\n¢\u0006\u0004\u0008\u0017\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\u0008\u001a\u0010\u0005J\u0018\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\n¢\u0006\u0004\u0008\u001c\u0010\u001dJ\u0018\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\u0008\u001e\u0010\u001fJ\u0018\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\u0008 \u0010\u000bJ\u0018\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\n¢\u0006\u0004\u0008!\u0010\"J\u001a\u0010#\u001a\u00020$2\u0008\u0010\t\u001a\u0004\u0018\u00010%HÖ\u0003¢\u0006\u0004\u0008&\u0010'J\u0018\u0010(\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\u0008¢\u0006\u0004\u0008)\u0010\u001dJ\u0018\u0010(\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\u0008¢\u0006\u0004\u0008*\u0010\u001fJ\u0018\u0010(\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\u0008¢\u0006\u0004\u0008+\u0010\u000bJ\u0018\u0010(\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\u0008¢\u0006\u0004\u0008,\u0010\"J\u0010\u0010-\u001a\u00020\rHÖ\u0001¢\u0006\u0004\u0008.\u0010/J\u0013\u00100\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\u00081\u0010\u0005J\u0013\u00102\u001a\u00020\u0000H\u0087\u0008ø\u0001\u0000¢\u0006\u0004\u00083\u0010\u0005J\u0018\u00104\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\n¢\u0006\u0004\u00085\u0010\u001dJ\u0018\u00104\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\u00086\u0010\u001fJ\u0018\u00104\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\u00087\u0010\u000bJ\u0018\u00104\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\n¢\u0006\u0004\u00088\u0010\"J\u0018\u00109\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u000eH\u0087\u0008¢\u0006\u0004\u0008:\u0010;J\u0018\u00109\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\u0008¢\u0006\u0004\u0008<\u0010\u0013J\u0018\u00109\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\u0008¢\u0006\u0004\u0008=\u0010\u000bJ\u0018\u00109\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u0016H\u0087\u0008¢\u0006\u0004\u0008>\u0010?J\u0018\u0010@\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\u000c¢\u0006\u0004\u0008A\u0010\u000bJ\u0018\u0010B\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\n¢\u0006\u0004\u0008C\u0010\u001dJ\u0018\u0010B\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\u0008D\u0010\u001fJ\u0018\u0010B\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\u0008E\u0010\u000bJ\u0018\u0010B\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\n¢\u0006\u0004\u0008F\u0010\"J\u0018\u0010G\u001a\u00020H2\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\u0008I\u0010JJ\u0018\u0010K\u001a\u00020H2\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\u0008L\u0010JJ\u0018\u0010M\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\n¢\u0006\u0004\u0008N\u0010\u001dJ\u0018\u0010M\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\u0008O\u0010\u001fJ\u0018\u0010M\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\u0008P\u0010\u000bJ\u0018\u0010M\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\n¢\u0006\u0004\u0008Q\u0010\"J\u001b\u0010R\u001a\u00020\u00002\u0006\u0010S\u001a\u00020\rH\u0087\u000cø\u0001\u0000¢\u0006\u0004\u0008T\u0010\u001fJ\u001b\u0010U\u001a\u00020\u00002\u0006\u0010S\u001a\u00020\rH\u0087\u000cø\u0001\u0000¢\u0006\u0004\u0008V\u0010\u001fJ\u0018\u0010W\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\n¢\u0006\u0004\u0008X\u0010\u001dJ\u0018\u0010W\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\u0008Y\u0010\u001fJ\u0018\u0010W\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\u0008Z\u0010\u000bJ\u0018\u0010W\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\n¢\u0006\u0004\u0008[\u0010\"J\u0010\u0010\\\u001a\u00020]H\u0087\u0008¢\u0006\u0004\u0008^\u0010_J\u0010\u0010`\u001a\u00020aH\u0087\u0008¢\u0006\u0004\u0008b\u0010cJ\u0010\u0010d\u001a\u00020eH\u0087\u0008¢\u0006\u0004\u0008f\u0010gJ\u0010\u0010h\u001a\u00020\rH\u0087\u0008¢\u0006\u0004\u0008i\u0010/J\u0010\u0010j\u001a\u00020\u0003H\u0087\u0008¢\u0006\u0004\u0008k\u0010\u0005J\u0010\u0010l\u001a\u00020mH\u0087\u0008¢\u0006\u0004\u0008n\u0010oJ\u000f\u0010p\u001a\u00020qH\u0016¢\u0006\u0004\u0008r\u0010sJ\u0013\u0010t\u001a\u00020\u000eH\u0087\u0008ø\u0001\u0000¢\u0006\u0004\u0008u\u0010_J\u0013\u0010v\u001a\u00020\u0011H\u0087\u0008ø\u0001\u0000¢\u0006\u0004\u0008w\u0010/J\u0013\u0010x\u001a\u00020\u0000H\u0087\u0008ø\u0001\u0000¢\u0006\u0004\u0008y\u0010\u0005J\u0013\u0010z\u001a\u00020\u0016H\u0087\u0008ø\u0001\u0000¢\u0006\u0004\u0008{\u0010oJ\u0018\u0010|\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\u000c¢\u0006\u0004\u0008}\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0006\u0010\u0007\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u0082\u0002\u0004\n\u0002\u0008!¨\u0006\u007f", d2 = {"Lkotlin/ULong;", "", "data", "", "constructor-impl", "(J)J", "getData$annotations", "()V", "and", "other", "and-VKZWuLQ", "(JJ)J", "compareTo", "", "Lkotlin/UByte;", "compareTo-7apg3OU", "(JB)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(JI)I", "compareTo-VKZWuLQ", "(JJ)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(JS)I", "dec", "dec-s-VKNKU", "div", "div-7apg3OU", "(JB)J", "div-WZ4Q5Ns", "(JI)J", "div-VKZWuLQ", "div-xj2QHRw", "(JS)J", "equals", "", "", "equals-impl", "(JLjava/lang/Object;)Z", "floorDiv", "floorDiv-7apg3OU", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "floorDiv-xj2QHRw", "hashCode", "hashCode-impl", "(J)I", "inc", "inc-s-VKNKU", "inv", "inv-s-VKNKU", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "mod", "mod-7apg3OU", "(JB)B", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "mod-xj2QHRw", "(JS)S", "or", "or-VKZWuLQ", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/ULongRange;", "rangeTo-VKZWuLQ", "(JJ)Lkotlin/ranges/ULongRange;", "rangeUntil", "rangeUntil-VKZWuLQ", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "shl", "bitCount", "shl-s-VKNKU", "shr", "shr-s-VKNKU", "times", "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "", "toByte-impl", "(J)B", "toDouble", "", "toDouble-impl", "(J)D", "toFloat", "", "toFloat-impl", "(J)F", "toInt", "toInt-impl", "toLong", "toLong-impl", "toShort", "", "toShort-impl", "(J)S", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "toUByte", "toUByte-w2LRezQ", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toUShort", "toUShort-Mh2AYeg", "xor", "xor-VKZWuLQ", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
@JvmInline
public final class ULong implements Comparable<kotlin.ULong> {

    public static final kotlin.ULong.Companion Companion = null;
    public static final long MAX_VALUE = -1L;
    public static final long MIN_VALUE = 0L;
    public static final int SIZE_BITS = 64;
    public static final int SIZE_BYTES = 8;
    private final long data;

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001a\u00020\u0004X\u0086Tø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005R\u0013\u0010\u0006\u001a\u00020\u0004X\u0086Tø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0007\u001a\u00020\u0008X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0008X\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008!¨\u0006\n", d2 = {"Lkotlin/ULong$Companion;", "", "()V", "MAX_VALUE", "Lkotlin/ULong;", "J", "MIN_VALUE", "SIZE_BITS", "", "SIZE_BYTES", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }
    }
    static {
        ULong.Companion companion = new ULong.Companion(0);
        ULong.Companion = companion;
    }

    private ULong(long data) {
        super();
        this.data = data;
    }

    private static final long and-VKZWuLQ(long arg0, long other) {
        return ULong.constructor-impl(arg0 & obj4);
    }

    public static final kotlin.ULong box-impl(long l) {
        ULong uLong = new ULong(l, obj2);
        return uLong;
    }

    private static final int compareTo-7apg3OU(long arg0, byte other) {
        return Long.compareUnsigned(arg0, other);
    }

    private int compareTo-VKZWuLQ(long other) {
        return UnsignedKt.ulongCompare(unbox-impl(), obj1);
    }

    private static int compareTo-VKZWuLQ(long arg0, long other) {
        return UnsignedKt.ulongCompare(arg0, other);
    }

    private static final int compareTo-WZ4Q5Ns(long arg0, int other) {
        return Long.compareUnsigned(arg0, other);
    }

    private static final int compareTo-xj2QHRw(long arg0, short other) {
        return Long.compareUnsigned(arg0, other);
    }

    public static long constructor-impl(long l) {
        return l;
    }

    private static final long dec-s-VKNKU(long arg0) {
        return ULong.constructor-impl(i += arg0);
    }

    private static final long div-7apg3OU(long arg0, byte other) {
        return Long.divideUnsigned(arg0, other);
    }

    private static final long div-VKZWuLQ(long arg0, long other) {
        return UnsignedKt.ulongDivide-eb3DHEI(arg0, other);
    }

    private static final long div-WZ4Q5Ns(long arg0, int other) {
        return Long.divideUnsigned(arg0, other);
    }

    private static final long div-xj2QHRw(long arg0, short other) {
        return Long.divideUnsigned(arg0, other);
    }

    public static boolean equals-impl(long l, Object object2) {
        final int i2 = 0;
        if (!obj6 instanceof ULong) {
            return i2;
        }
        if (Long.compare(l, unbox-impl) != 0) {
            return i2;
        }
        return 1;
    }

    public static final boolean equals-impl0(long l, long l2) {
        int i;
        i = Long.compare(l, obj3) == 0 ? 1 : 0;
        return i;
    }

    private static final long floorDiv-7apg3OU(long arg0, byte other) {
        return Long.divideUnsigned(arg0, other);
    }

    private static final long floorDiv-VKZWuLQ(long arg0, long other) {
        return Long.divideUnsigned(arg0, other);
    }

    private static final long floorDiv-WZ4Q5Ns(long arg0, int other) {
        return Long.divideUnsigned(arg0, other);
    }

    private static final long floorDiv-xj2QHRw(long arg0, short other) {
        return Long.divideUnsigned(arg0, other);
    }

    public static void getData$annotations() {
    }

    public static int hashCode-impl(long l) {
        return Long.hashCode(l);
    }

    private static final long inc-s-VKNKU(long arg0) {
        return ULong.constructor-impl(i += arg0);
    }

    private static final long inv-s-VKNKU(long arg0) {
        return ULong.constructor-impl(~arg0);
    }

    private static final long minus-7apg3OU(long arg0, byte other) {
        return ULong.constructor-impl(arg0 - constructor-impl);
    }

    private static final long minus-VKZWuLQ(long arg0, long other) {
        return ULong.constructor-impl(arg0 - obj4);
    }

    private static final long minus-WZ4Q5Ns(long arg0, int other) {
        return ULong.constructor-impl(arg0 - constructor-impl);
    }

    private static final long minus-xj2QHRw(long arg0, short other) {
        return ULong.constructor-impl(arg0 - constructor-impl);
    }

    private static final byte mod-7apg3OU(long arg0, byte other) {
        return UByte.constructor-impl((byte)i2);
    }

    private static final long mod-VKZWuLQ(long arg0, long other) {
        return Long.remainderUnsigned(arg0, other);
    }

    private static final int mod-WZ4Q5Ns(long arg0, int other) {
        return UInt.constructor-impl((int)remainderUnsigned);
    }

    private static final short mod-xj2QHRw(long arg0, short other) {
        return UShort.constructor-impl((short)i2);
    }

    private static final long or-VKZWuLQ(long arg0, long other) {
        return ULong.constructor-impl(arg0 | obj4);
    }

    private static final long plus-7apg3OU(long arg0, byte other) {
        return ULong.constructor-impl(constructor-impl += arg0);
    }

    private static final long plus-VKZWuLQ(long arg0, long other) {
        return ULong.constructor-impl(arg0 + obj4);
    }

    private static final long plus-WZ4Q5Ns(long arg0, int other) {
        return ULong.constructor-impl(constructor-impl += arg0);
    }

    private static final long plus-xj2QHRw(long arg0, short other) {
        return ULong.constructor-impl(constructor-impl += arg0);
    }

    private static final ULongRange rangeTo-VKZWuLQ(long arg0, long other) {
        ULongRange uLongRange = new ULongRange(arg0, obj2, obj8, obj4, 0);
        return uLongRange;
    }

    private static final ULongRange rangeUntil-VKZWuLQ(long arg0, long other) {
        return URangesKt.until-eb3DHEI(arg0, other);
    }

    private static final long rem-7apg3OU(long arg0, byte other) {
        return Long.remainderUnsigned(arg0, other);
    }

    private static final long rem-VKZWuLQ(long arg0, long other) {
        return UnsignedKt.ulongRemainder-eb3DHEI(arg0, other);
    }

    private static final long rem-WZ4Q5Ns(long arg0, int other) {
        return Long.remainderUnsigned(arg0, other);
    }

    private static final long rem-xj2QHRw(long arg0, short other) {
        return Long.remainderUnsigned(arg0, other);
    }

    private static final long shl-s-VKNKU(long arg0, int bitCount) {
        return ULong.constructor-impl(arg0 << obj4);
    }

    private static final long shr-s-VKNKU(long arg0, int bitCount) {
        return ULong.constructor-impl(arg0 >>> obj4);
    }

    private static final long times-7apg3OU(long arg0, byte other) {
        return ULong.constructor-impl(constructor-impl *= arg0);
    }

    private static final long times-VKZWuLQ(long arg0, long other) {
        return ULong.constructor-impl(arg0 * obj4);
    }

    private static final long times-WZ4Q5Ns(long arg0, int other) {
        return ULong.constructor-impl(constructor-impl *= arg0);
    }

    private static final long times-xj2QHRw(long arg0, short other) {
        return ULong.constructor-impl(constructor-impl *= arg0);
    }

    private static final byte toByte-impl(long arg0) {
        return (byte)i;
    }

    private static final double toDouble-impl(long arg0) {
        return UnsignedKt.ulongToDouble(arg0);
    }

    private static final float toFloat-impl(long arg0) {
        return (float)ulongToDouble;
    }

    private static final int toInt-impl(long arg0) {
        return (int)arg0;
    }

    private static final long toLong-impl(long arg0) {
        return arg0;
    }

    private static final short toShort-impl(long arg0) {
        return (short)i;
    }

    public static String toString-impl(long arg0) {
        return UnsignedKt.ulongToString(arg0, obj2);
    }

    private static final byte toUByte-w2LRezQ(long arg0) {
        return UByte.constructor-impl((byte)i);
    }

    private static final int toUInt-pVg5ArA(long arg0) {
        return UInt.constructor-impl((int)arg0);
    }

    private static final long toULong-s-VKNKU(long arg0) {
        return arg0;
    }

    private static final short toUShort-Mh2AYeg(long arg0) {
        return UShort.constructor-impl((short)i);
    }

    private static final long xor-VKZWuLQ(long arg0, long other) {
        return ULong.constructor-impl(arg0 ^ obj4);
    }

    @Override // java.lang.Comparable
    public int compareTo(Object other) {
        return UnsignedKt.ulongCompare(unbox-impl(), obj3);
    }

    @Override // java.lang.Comparable
    public boolean equals(Object object) {
        return ULong.equals-impl(this.data, obj1);
    }

    @Override // java.lang.Comparable
    public int hashCode() {
        return ULong.hashCode-impl(this.data);
    }

    @Override // java.lang.Comparable
    public String toString() {
        return ULong.toString-impl(this.data);
    }

    @Override // java.lang.Comparable
    public final long unbox-impl() {
        return this.data;
    }
}
