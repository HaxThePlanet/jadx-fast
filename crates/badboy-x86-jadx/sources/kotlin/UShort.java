package kotlin;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.UIntRange;
import kotlin.ranges.URangesKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\n\n\u0002\u0008\t\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\u0008!\n\u0002\u0018\u0002\n\u0002\u0008\u000f\n\u0002\u0010\u0005\n\u0002\u0008\u0003\n\u0002\u0010\u0006\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0002\u0008\u0005\n\u0002\u0010\t\n\u0002\u0008\u0005\n\u0002\u0010\u000e\n\u0002\u0008\u000e\u0008\u0087@\u0018\u0000 v2\u0008\u0012\u0004\u0012\u00020\u00000\u0001:\u0001vB\u0011\u0008\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u0018\u0010\u0008\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\u000c¢\u0006\u0004\u0008\n\u0010\u000bJ\u0018\u0010\u000c\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u000eH\u0087\n¢\u0006\u0004\u0008\u000f\u0010\u0010J\u0018\u0010\u000c\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\u0008\u0012\u0010\u0013J\u0018\u0010\u000c\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0014H\u0087\n¢\u0006\u0004\u0008\u0015\u0010\u0016J\u0018\u0010\u000c\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0000H\u0097\n¢\u0006\u0004\u0008\u0017\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\u0008\u001a\u0010\u0005J\u0018\u0010\u001b\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\n¢\u0006\u0004\u0008\u001c\u0010\u0010J\u0018\u0010\u001b\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\u0008\u001d\u0010\u0013J\u0018\u0010\u001b\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\n¢\u0006\u0004\u0008\u001e\u0010\u001fJ\u0018\u0010\u001b\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\u0008 \u0010\u0018J\u001a\u0010!\u001a\u00020\"2\u0008\u0010\t\u001a\u0004\u0018\u00010#HÖ\u0003¢\u0006\u0004\u0008$\u0010%J\u0018\u0010&\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\u0008¢\u0006\u0004\u0008'\u0010\u0010J\u0018\u0010&\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\u0008¢\u0006\u0004\u0008(\u0010\u0013J\u0018\u0010&\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\u0008¢\u0006\u0004\u0008)\u0010\u001fJ\u0018\u0010&\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\u0008¢\u0006\u0004\u0008*\u0010\u0018J\u0010\u0010+\u001a\u00020\rHÖ\u0001¢\u0006\u0004\u0008,\u0010-J\u0013\u0010.\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\u0008/\u0010\u0005J\u0013\u00100\u001a\u00020\u0000H\u0087\u0008ø\u0001\u0000¢\u0006\u0004\u00081\u0010\u0005J\u0018\u00102\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\n¢\u0006\u0004\u00083\u0010\u0010J\u0018\u00102\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\u00084\u0010\u0013J\u0018\u00102\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\n¢\u0006\u0004\u00085\u0010\u001fJ\u0018\u00102\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\u00086\u0010\u0018J\u0018\u00107\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u000eH\u0087\u0008¢\u0006\u0004\u00088\u00109J\u0018\u00107\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\u0008¢\u0006\u0004\u0008:\u0010\u0013J\u0018\u00107\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\u0008¢\u0006\u0004\u0008;\u0010\u001fJ\u0018\u00107\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\u0008¢\u0006\u0004\u0008<\u0010\u000bJ\u0018\u0010=\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\u000c¢\u0006\u0004\u0008>\u0010\u000bJ\u0018\u0010?\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\n¢\u0006\u0004\u0008@\u0010\u0010J\u0018\u0010?\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\u0008A\u0010\u0013J\u0018\u0010?\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\n¢\u0006\u0004\u0008B\u0010\u001fJ\u0018\u0010?\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\u0008C\u0010\u0018J\u0018\u0010D\u001a\u00020E2\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\u0008F\u0010GJ\u0018\u0010H\u001a\u00020E2\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\u0008I\u0010GJ\u0018\u0010J\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\n¢\u0006\u0004\u0008K\u0010\u0010J\u0018\u0010J\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\u0008L\u0010\u0013J\u0018\u0010J\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\n¢\u0006\u0004\u0008M\u0010\u001fJ\u0018\u0010J\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\u0008N\u0010\u0018J\u0018\u0010O\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\n¢\u0006\u0004\u0008P\u0010\u0010J\u0018\u0010O\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\u0008Q\u0010\u0013J\u0018\u0010O\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\n¢\u0006\u0004\u0008R\u0010\u001fJ\u0018\u0010O\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\u0008S\u0010\u0018J\u0010\u0010T\u001a\u00020UH\u0087\u0008¢\u0006\u0004\u0008V\u0010WJ\u0010\u0010X\u001a\u00020YH\u0087\u0008¢\u0006\u0004\u0008Z\u0010[J\u0010\u0010\\\u001a\u00020]H\u0087\u0008¢\u0006\u0004\u0008^\u0010_J\u0010\u0010`\u001a\u00020\rH\u0087\u0008¢\u0006\u0004\u0008a\u0010-J\u0010\u0010b\u001a\u00020cH\u0087\u0008¢\u0006\u0004\u0008d\u0010eJ\u0010\u0010f\u001a\u00020\u0003H\u0087\u0008¢\u0006\u0004\u0008g\u0010\u0005J\u000f\u0010h\u001a\u00020iH\u0016¢\u0006\u0004\u0008j\u0010kJ\u0013\u0010l\u001a\u00020\u000eH\u0087\u0008ø\u0001\u0000¢\u0006\u0004\u0008m\u0010WJ\u0013\u0010n\u001a\u00020\u0011H\u0087\u0008ø\u0001\u0000¢\u0006\u0004\u0008o\u0010-J\u0013\u0010p\u001a\u00020\u0014H\u0087\u0008ø\u0001\u0000¢\u0006\u0004\u0008q\u0010eJ\u0013\u0010r\u001a\u00020\u0000H\u0087\u0008ø\u0001\u0000¢\u0006\u0004\u0008s\u0010\u0005J\u0018\u0010t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\u000c¢\u0006\u0004\u0008u\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0006\u0010\u0007\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u0082\u0002\u0004\n\u0002\u0008!¨\u0006w", d2 = {"Lkotlin/UShort;", "", "data", "", "constructor-impl", "(S)S", "getData$annotations", "()V", "and", "other", "and-xj2QHRw", "(SS)S", "compareTo", "", "Lkotlin/UByte;", "compareTo-7apg3OU", "(SB)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(SI)I", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(SJ)I", "compareTo-xj2QHRw", "(SS)I", "dec", "dec-Mh2AYeg", "div", "div-7apg3OU", "div-WZ4Q5Ns", "div-VKZWuLQ", "(SJ)J", "div-xj2QHRw", "equals", "", "", "equals-impl", "(SLjava/lang/Object;)Z", "floorDiv", "floorDiv-7apg3OU", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "floorDiv-xj2QHRw", "hashCode", "hashCode-impl", "(S)I", "inc", "inc-Mh2AYeg", "inv", "inv-Mh2AYeg", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "mod", "mod-7apg3OU", "(SB)B", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "mod-xj2QHRw", "or", "or-xj2QHRw", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-xj2QHRw", "(SS)Lkotlin/ranges/UIntRange;", "rangeUntil", "rangeUntil-xj2QHRw", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "times", "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "", "toByte-impl", "(S)B", "toDouble", "", "toDouble-impl", "(S)D", "toFloat", "", "toFloat-impl", "(S)F", "toInt", "toInt-impl", "toLong", "", "toLong-impl", "(S)J", "toShort", "toShort-impl", "toString", "", "toString-impl", "(S)Ljava/lang/String;", "toUByte", "toUByte-w2LRezQ", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toUShort", "toUShort-Mh2AYeg", "xor", "xor-xj2QHRw", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
@JvmInline
public final class UShort implements Comparable<kotlin.UShort> {

    public static final kotlin.UShort.Companion Companion = null;
    public static final short MAX_VALUE = (short) -1;
    public static final short MIN_VALUE = (short) 0;
    public static final int SIZE_BITS = 16;
    public static final int SIZE_BYTES = 2;
    private final short data;

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001a\u00020\u0004X\u0086Tø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005R\u0013\u0010\u0006\u001a\u00020\u0004X\u0086Tø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0007\u001a\u00020\u0008X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0008X\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008!¨\u0006\n", d2 = {"Lkotlin/UShort$Companion;", "", "()V", "MAX_VALUE", "Lkotlin/UShort;", "S", "MIN_VALUE", "SIZE_BITS", "", "SIZE_BYTES", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }
    }
    static {
        UShort.Companion companion = new UShort.Companion(0);
        UShort.Companion = companion;
    }

    private UShort(short data) {
        super();
        this.data = data;
    }

    private static final short and-xj2QHRw(short arg0, short other) {
        return UShort.constructor-impl((short)i);
    }

    public static final kotlin.UShort box-impl(short s) {
        UShort uShort = new UShort(s);
        return uShort;
    }

    private static final int compareTo-7apg3OU(short arg0, byte other) {
        return Intrinsics.compare(i &= arg0, other & 255);
    }

    private static final int compareTo-VKZWuLQ(short arg0, long other) {
        return Long.compareUnsigned(ULong.constructor-impl(l &= i2), obj1);
    }

    private static final int compareTo-WZ4Q5Ns(short arg0, int other) {
        return Integer.compareUnsigned(UInt.constructor-impl(i &= arg0), other);
    }

    private int compareTo-xj2QHRw(short other) {
        int i2 = 65535;
        return Intrinsics.compare(unbox-impl &= i2, i2 &= other);
    }

    private static int compareTo-xj2QHRw(short arg0, short other) {
        int i = 65535;
        return Intrinsics.compare(arg0 & i, i &= other);
    }

    public static short constructor-impl(short s) {
        return s;
    }

    private static final short dec-Mh2AYeg(short arg0) {
        return UShort.constructor-impl((short)i);
    }

    private static final int div-7apg3OU(short arg0, byte other) {
        return Integer.divideUnsigned(UInt.constructor-impl(i &= arg0), UInt.constructor-impl(other & 255));
    }

    private static final long div-VKZWuLQ(short arg0, long other) {
        return Long.divideUnsigned(ULong.constructor-impl(l &= i2), obj1);
    }

    private static final int div-WZ4Q5Ns(short arg0, int other) {
        return Integer.divideUnsigned(UInt.constructor-impl(i &= arg0), other);
    }

    private static final int div-xj2QHRw(short arg0, short other) {
        int i = 65535;
        return Integer.divideUnsigned(UInt.constructor-impl(arg0 & i), UInt.constructor-impl(i &= other));
    }

    public static boolean equals-impl(short s, Object object2) {
        final int i2 = 0;
        if (!object2 instanceof UShort) {
            return i2;
        }
        if (s != (UShort)object2.unbox-impl()) {
            return i2;
        }
        return 1;
    }

    public static final boolean equals-impl0(short s, short s2) {
        int i;
        i = s == s2 ? 1 : 0;
        return i;
    }

    private static final int floorDiv-7apg3OU(short arg0, byte other) {
        return Integer.divideUnsigned(UInt.constructor-impl(i &= arg0), UInt.constructor-impl(other & 255));
    }

    private static final long floorDiv-VKZWuLQ(short arg0, long other) {
        return Long.divideUnsigned(ULong.constructor-impl(l &= i2), obj1);
    }

    private static final int floorDiv-WZ4Q5Ns(short arg0, int other) {
        return Integer.divideUnsigned(UInt.constructor-impl(i &= arg0), other);
    }

    private static final int floorDiv-xj2QHRw(short arg0, short other) {
        int i = 65535;
        return Integer.divideUnsigned(UInt.constructor-impl(arg0 & i), UInt.constructor-impl(i &= other));
    }

    public static void getData$annotations() {
    }

    public static int hashCode-impl(short s) {
        return Short.hashCode(s);
    }

    private static final short inc-Mh2AYeg(short arg0) {
        return UShort.constructor-impl((short)i);
    }

    private static final short inv-Mh2AYeg(short arg0) {
        return UShort.constructor-impl((short)i);
    }

    private static final int minus-7apg3OU(short arg0, byte other) {
        return UInt.constructor-impl(constructor-impl -= constructor-impl3);
    }

    private static final long minus-VKZWuLQ(short arg0, long other) {
        return ULong.constructor-impl(constructor-impl -= other);
    }

    private static final int minus-WZ4Q5Ns(short arg0, int other) {
        return UInt.constructor-impl(constructor-impl -= other);
    }

    private static final int minus-xj2QHRw(short arg0, short other) {
        int i = 65535;
        return UInt.constructor-impl(constructor-impl3 -= constructor-impl);
    }

    private static final byte mod-7apg3OU(short arg0, byte other) {
        return UByte.constructor-impl((byte)remainderUnsigned);
    }

    private static final long mod-VKZWuLQ(short arg0, long other) {
        return Long.remainderUnsigned(ULong.constructor-impl(l &= i2), obj1);
    }

    private static final int mod-WZ4Q5Ns(short arg0, int other) {
        return Integer.remainderUnsigned(UInt.constructor-impl(i &= arg0), other);
    }

    private static final short mod-xj2QHRw(short arg0, short other) {
        int i = 65535;
        return UShort.constructor-impl((short)remainderUnsigned);
    }

    private static final short or-xj2QHRw(short arg0, short other) {
        return UShort.constructor-impl((short)i);
    }

    private static final int plus-7apg3OU(short arg0, byte other) {
        return UInt.constructor-impl(constructor-impl += constructor-impl3);
    }

    private static final long plus-VKZWuLQ(short arg0, long other) {
        return ULong.constructor-impl(constructor-impl += other);
    }

    private static final int plus-WZ4Q5Ns(short arg0, int other) {
        return UInt.constructor-impl(constructor-impl += other);
    }

    private static final int plus-xj2QHRw(short arg0, short other) {
        int i = 65535;
        return UInt.constructor-impl(constructor-impl3 += constructor-impl);
    }

    private static final UIntRange rangeTo-xj2QHRw(short arg0, short other) {
        int i = 65535;
        UIntRange uIntRange = new UIntRange(UInt.constructor-impl(arg0 & i), UInt.constructor-impl(i &= other), 0);
        return uIntRange;
    }

    private static final UIntRange rangeUntil-xj2QHRw(short arg0, short other) {
        int i = 65535;
        return URangesKt.until-J1ME1BU(UInt.constructor-impl(arg0 & i), UInt.constructor-impl(i &= other));
    }

    private static final int rem-7apg3OU(short arg0, byte other) {
        return Integer.remainderUnsigned(UInt.constructor-impl(i &= arg0), UInt.constructor-impl(other & 255));
    }

    private static final long rem-VKZWuLQ(short arg0, long other) {
        return Long.remainderUnsigned(ULong.constructor-impl(l &= i2), obj1);
    }

    private static final int rem-WZ4Q5Ns(short arg0, int other) {
        return Integer.remainderUnsigned(UInt.constructor-impl(i &= arg0), other);
    }

    private static final int rem-xj2QHRw(short arg0, short other) {
        int i = 65535;
        return Integer.remainderUnsigned(UInt.constructor-impl(arg0 & i), UInt.constructor-impl(i &= other));
    }

    private static final int times-7apg3OU(short arg0, byte other) {
        return UInt.constructor-impl(constructor-impl *= constructor-impl3);
    }

    private static final long times-VKZWuLQ(short arg0, long other) {
        return ULong.constructor-impl(constructor-impl *= other);
    }

    private static final int times-WZ4Q5Ns(short arg0, int other) {
        return UInt.constructor-impl(constructor-impl *= other);
    }

    private static final int times-xj2QHRw(short arg0, short other) {
        int i = 65535;
        return UInt.constructor-impl(constructor-impl3 *= constructor-impl);
    }

    private static final byte toByte-impl(short arg0) {
        return (byte)arg0;
    }

    private static final double toDouble-impl(short arg0) {
        return UnsignedKt.uintToDouble(i &= arg0);
    }

    private static final float toFloat-impl(short arg0) {
        return (float)uintToDouble;
    }

    private static final int toInt-impl(short arg0) {
        return i &= arg0;
    }

    private static final long toLong-impl(short arg0) {
        return l &= i2;
    }

    private static final short toShort-impl(short arg0) {
        return arg0;
    }

    public static String toString-impl(short arg0) {
        return String.valueOf(i &= arg0);
    }

    private static final byte toUByte-w2LRezQ(short arg0) {
        return UByte.constructor-impl((byte)arg0);
    }

    private static final int toUInt-pVg5ArA(short arg0) {
        return UInt.constructor-impl(i &= arg0);
    }

    private static final long toULong-s-VKNKU(short arg0) {
        return ULong.constructor-impl(l &= i2);
    }

    private static final short toUShort-Mh2AYeg(short arg0) {
        return arg0;
    }

    private static final short xor-xj2QHRw(short arg0, short other) {
        return UShort.constructor-impl((short)i);
    }

    @Override // java.lang.Comparable
    public int compareTo(Object other) {
        final int i3 = 65535;
        return Intrinsics.compare(unbox-impl2 &= i3, unbox-impl &= i3);
    }

    @Override // java.lang.Comparable
    public boolean equals(Object object) {
        return UShort.equals-impl(this.data, object);
    }

    @Override // java.lang.Comparable
    public int hashCode() {
        return UShort.hashCode-impl(this.data);
    }

    @Override // java.lang.Comparable
    public String toString() {
        return UShort.toString-impl(this.data);
    }

    @Override // java.lang.Comparable
    public final short unbox-impl() {
        return this.data;
    }
}
