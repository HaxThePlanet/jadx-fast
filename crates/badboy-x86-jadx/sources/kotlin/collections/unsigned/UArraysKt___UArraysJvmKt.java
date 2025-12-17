package kotlin.collections.unsigned;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.UnsignedKt;
import kotlin.collections.AbstractList;
import kotlin.collections.AbstractList.Companion;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000h\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008 \n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0018\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\u001a\u0019\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0007¢\u0006\u0004\u0008\u0004\u0010\u0005\u001a\u0019\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0001*\u00020\u0007H\u0007¢\u0006\u0004\u0008\u0008\u0010\t\u001a\u0019\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\n0\u0001*\u00020\u000bH\u0007¢\u0006\u0004\u0008\u000c\u0010\r\u001a\u0019\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\u0001*\u00020\u000fH\u0007¢\u0006\u0004\u0008\u0010\u0010\u0011\u001a/\u0010\u0012\u001a\u00020\u0013*\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00022\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u0013H\u0007¢\u0006\u0004\u0008\u0017\u0010\u0018\u001a/\u0010\u0012\u001a\u00020\u0013*\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u0013H\u0007¢\u0006\u0004\u0008\u0019\u0010\u001a\u001a/\u0010\u0012\u001a\u00020\u0013*\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\n2\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u0013H\u0007¢\u0006\u0004\u0008\u001b\u0010\u001c\u001a/\u0010\u0012\u001a\u00020\u0013*\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u0013H\u0007¢\u0006\u0004\u0008\u001d\u0010\u001e\u001a\u001c\u0010\u001f\u001a\u00020\u0002*\u00020\u00032\u0006\u0010 \u001a\u00020\u0013H\u0087\u0008¢\u0006\u0004\u0008!\u0010\"\u001a\u001c\u0010\u001f\u001a\u00020\u0006*\u00020\u00072\u0006\u0010 \u001a\u00020\u0013H\u0087\u0008¢\u0006\u0004\u0008#\u0010$\u001a\u001c\u0010\u001f\u001a\u00020\n*\u00020\u000b2\u0006\u0010 \u001a\u00020\u0013H\u0087\u0008¢\u0006\u0004\u0008%\u0010&\u001a\u001c\u0010\u001f\u001a\u00020\u000e*\u00020\u000f2\u0006\u0010 \u001a\u00020\u0013H\u0087\u0008¢\u0006\u0004\u0008'\u0010(\u001a\u0015\u0010)\u001a\u0004\u0018\u00010\u0002*\u00020\u0003H\u0007¢\u0006\u0004\u0008*\u0010+\u001a\u0015\u0010)\u001a\u0004\u0018\u00010\u0006*\u00020\u0007H\u0007¢\u0006\u0004\u0008,\u0010-\u001a\u0015\u0010)\u001a\u0004\u0018\u00010\n*\u00020\u000bH\u0007¢\u0006\u0004\u0008.\u0010/\u001a\u0015\u0010)\u001a\u0004\u0018\u00010\u000e*\u00020\u000fH\u0007¢\u0006\u0004\u00080\u00101\u001a=\u00102\u001a\u0004\u0018\u00010\u0002\"\u000e\u0008\u0000\u00103*\u0008\u0012\u0004\u0012\u0002H304*\u00020\u00032\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H306H\u0087\u0008ø\u0001\u0000¢\u0006\u0004\u00087\u00108\u001a=\u00102\u001a\u0004\u0018\u00010\u0006\"\u000e\u0008\u0000\u00103*\u0008\u0012\u0004\u0012\u0002H304*\u00020\u00072\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H306H\u0087\u0008ø\u0001\u0000¢\u0006\u0004\u00089\u0010:\u001a=\u00102\u001a\u0004\u0018\u00010\n\"\u000e\u0008\u0000\u00103*\u0008\u0012\u0004\u0012\u0002H304*\u00020\u000b2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002H306H\u0087\u0008ø\u0001\u0000¢\u0006\u0004\u0008;\u0010<\u001a=\u00102\u001a\u0004\u0018\u00010\u000e\"\u000e\u0008\u0000\u00103*\u0008\u0012\u0004\u0012\u0002H304*\u00020\u000f2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u0002H306H\u0087\u0008ø\u0001\u0000¢\u0006\u0004\u0008=\u0010>\u001a1\u0010?\u001a\u0004\u0018\u00010\u0002*\u00020\u00032\u001a\u0010@\u001a\u0016\u0012\u0006\u0008\u0000\u0012\u00020\u00020Aj\n\u0012\u0006\u0008\u0000\u0012\u00020\u0002`BH\u0007¢\u0006\u0004\u0008C\u0010D\u001a1\u0010?\u001a\u0004\u0018\u00010\u0006*\u00020\u00072\u001a\u0010@\u001a\u0016\u0012\u0006\u0008\u0000\u0012\u00020\u00060Aj\n\u0012\u0006\u0008\u0000\u0012\u00020\u0006`BH\u0007¢\u0006\u0004\u0008E\u0010F\u001a1\u0010?\u001a\u0004\u0018\u00010\n*\u00020\u000b2\u001a\u0010@\u001a\u0016\u0012\u0006\u0008\u0000\u0012\u00020\n0Aj\n\u0012\u0006\u0008\u0000\u0012\u00020\n`BH\u0007¢\u0006\u0004\u0008G\u0010H\u001a1\u0010?\u001a\u0004\u0018\u00010\u000e*\u00020\u000f2\u001a\u0010@\u001a\u0016\u0012\u0006\u0008\u0000\u0012\u00020\u000e0Aj\n\u0012\u0006\u0008\u0000\u0012\u00020\u000e`BH\u0007¢\u0006\u0004\u0008I\u0010J\u001a\u0015\u0010K\u001a\u0004\u0018\u00010\u0002*\u00020\u0003H\u0007¢\u0006\u0004\u0008L\u0010+\u001a\u0015\u0010K\u001a\u0004\u0018\u00010\u0006*\u00020\u0007H\u0007¢\u0006\u0004\u0008M\u0010-\u001a\u0015\u0010K\u001a\u0004\u0018\u00010\n*\u00020\u000bH\u0007¢\u0006\u0004\u0008N\u0010/\u001a\u0015\u0010K\u001a\u0004\u0018\u00010\u000e*\u00020\u000fH\u0007¢\u0006\u0004\u0008O\u00101\u001a=\u0010P\u001a\u0004\u0018\u00010\u0002\"\u000e\u0008\u0000\u00103*\u0008\u0012\u0004\u0012\u0002H304*\u00020\u00032\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H306H\u0087\u0008ø\u0001\u0000¢\u0006\u0004\u0008Q\u00108\u001a=\u0010P\u001a\u0004\u0018\u00010\u0006\"\u000e\u0008\u0000\u00103*\u0008\u0012\u0004\u0012\u0002H304*\u00020\u00072\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H306H\u0087\u0008ø\u0001\u0000¢\u0006\u0004\u0008R\u0010:\u001a=\u0010P\u001a\u0004\u0018\u00010\n\"\u000e\u0008\u0000\u00103*\u0008\u0012\u0004\u0012\u0002H304*\u00020\u000b2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002H306H\u0087\u0008ø\u0001\u0000¢\u0006\u0004\u0008S\u0010<\u001a=\u0010P\u001a\u0004\u0018\u00010\u000e\"\u000e\u0008\u0000\u00103*\u0008\u0012\u0004\u0012\u0002H304*\u00020\u000f2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u0002H306H\u0087\u0008ø\u0001\u0000¢\u0006\u0004\u0008T\u0010>\u001a1\u0010U\u001a\u0004\u0018\u00010\u0002*\u00020\u00032\u001a\u0010@\u001a\u0016\u0012\u0006\u0008\u0000\u0012\u00020\u00020Aj\n\u0012\u0006\u0008\u0000\u0012\u00020\u0002`BH\u0007¢\u0006\u0004\u0008V\u0010D\u001a1\u0010U\u001a\u0004\u0018\u00010\u0006*\u00020\u00072\u001a\u0010@\u001a\u0016\u0012\u0006\u0008\u0000\u0012\u00020\u00060Aj\n\u0012\u0006\u0008\u0000\u0012\u00020\u0006`BH\u0007¢\u0006\u0004\u0008W\u0010F\u001a1\u0010U\u001a\u0004\u0018\u00010\n*\u00020\u000b2\u001a\u0010@\u001a\u0016\u0012\u0006\u0008\u0000\u0012\u00020\n0Aj\n\u0012\u0006\u0008\u0000\u0012\u00020\n`BH\u0007¢\u0006\u0004\u0008X\u0010H\u001a1\u0010U\u001a\u0004\u0018\u00010\u000e*\u00020\u000f2\u001a\u0010@\u001a\u0016\u0012\u0006\u0008\u0000\u0012\u00020\u000e0Aj\n\u0012\u0006\u0008\u0000\u0012\u00020\u000e`BH\u0007¢\u0006\u0004\u0008Y\u0010J\u001a+\u0010Z\u001a\u00020[*\u00020\u00032\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020[06H\u0087\u0008ø\u0001\u0000¢\u0006\u0004\u0008\\\u0010]\u001a+\u0010Z\u001a\u00020^*\u00020\u00032\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020^06H\u0087\u0008ø\u0001\u0000¢\u0006\u0004\u0008_\u0010`\u001a+\u0010Z\u001a\u00020[*\u00020\u00072\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020[06H\u0087\u0008ø\u0001\u0000¢\u0006\u0004\u0008\\\u0010a\u001a+\u0010Z\u001a\u00020^*\u00020\u00072\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020^06H\u0087\u0008ø\u0001\u0000¢\u0006\u0004\u0008_\u0010b\u001a+\u0010Z\u001a\u00020[*\u00020\u000b2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020[06H\u0087\u0008ø\u0001\u0000¢\u0006\u0004\u0008\\\u0010c\u001a+\u0010Z\u001a\u00020^*\u00020\u000b2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020^06H\u0087\u0008ø\u0001\u0000¢\u0006\u0004\u0008_\u0010d\u001a+\u0010Z\u001a\u00020[*\u00020\u000f2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020[06H\u0087\u0008ø\u0001\u0000¢\u0006\u0004\u0008\\\u0010e\u001a+\u0010Z\u001a\u00020^*\u00020\u000f2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020^06H\u0087\u0008ø\u0001\u0000¢\u0006\u0004\u0008_\u0010f\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006g", d2 = {"asList", "", "Lkotlin/UByte;", "Lkotlin/UByteArray;", "asList-GBYM_sE", "([B)Ljava/util/List;", "Lkotlin/UInt;", "Lkotlin/UIntArray;", "asList--ajY-9A", "([I)Ljava/util/List;", "Lkotlin/ULong;", "Lkotlin/ULongArray;", "asList-QwZRm1k", "([J)Ljava/util/List;", "Lkotlin/UShort;", "Lkotlin/UShortArray;", "asList-rL5Bavg", "([S)Ljava/util/List;", "binarySearch", "", "element", "fromIndex", "toIndex", "binarySearch-WpHrYlw", "([BBII)I", "binarySearch-2fe2U9s", "([IIII)I", "binarySearch-K6DWlUc", "([JJII)I", "binarySearch-EtDCXyQ", "([SSII)I", "elementAt", "index", "elementAt-PpDY95g", "([BI)B", "elementAt-qFRl0hI", "([II)I", "elementAt-r7IrZao", "([JI)J", "elementAt-nggk6HY", "([SI)S", "max", "max-GBYM_sE", "([B)Lkotlin/UByte;", "max--ajY-9A", "([I)Lkotlin/UInt;", "max-QwZRm1k", "([J)Lkotlin/ULong;", "max-rL5Bavg", "([S)Lkotlin/UShort;", "maxBy", "R", "", "selector", "Lkotlin/Function1;", "maxBy-JOV_ifY", "([BLkotlin/jvm/functions/Function1;)Lkotlin/UByte;", "maxBy-jgv0xPQ", "([ILkotlin/jvm/functions/Function1;)Lkotlin/UInt;", "maxBy-MShoTSo", "([JLkotlin/jvm/functions/Function1;)Lkotlin/ULong;", "maxBy-xTcfx_M", "([SLkotlin/jvm/functions/Function1;)Lkotlin/UShort;", "maxWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "maxWith-XMRcp5o", "([BLjava/util/Comparator;)Lkotlin/UByte;", "maxWith-YmdZ_VM", "([ILjava/util/Comparator;)Lkotlin/UInt;", "maxWith-zrEWJaI", "([JLjava/util/Comparator;)Lkotlin/ULong;", "maxWith-eOHTfZs", "([SLjava/util/Comparator;)Lkotlin/UShort;", "min", "min-GBYM_sE", "min--ajY-9A", "min-QwZRm1k", "min-rL5Bavg", "minBy", "minBy-JOV_ifY", "minBy-jgv0xPQ", "minBy-MShoTSo", "minBy-xTcfx_M", "minWith", "minWith-XMRcp5o", "minWith-YmdZ_VM", "minWith-zrEWJaI", "minWith-eOHTfZs", "sumOf", "Ljava/math/BigDecimal;", "sumOfBigDecimal", "([BLkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "Ljava/math/BigInteger;", "sumOfBigInteger", "([BLkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "([ILkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "([ILkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "([JLkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "([JLkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "([SLkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "([SLkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, pn = "kotlin.collections", xi = 49, xs = "kotlin/collections/unsigned/UArraysKt")
class UArraysKt___UArraysJvmKt {
    public static final List<UInt> asList--ajY-9A(int[] $this$asList_u2d_u2dajY_u2d9A) {
        Intrinsics.checkNotNullParameter($this$asList_u2d_u2dajY_u2d9A, "$this$asList");
        UArraysKt___UArraysJvmKt.asList.1 anon = new UArraysKt___UArraysJvmKt.asList.1($this$asList_u2d_u2dajY_u2d9A);
        return (List)anon;
    }

    public static final List<UByte> asList-GBYM_sE(byte[] $this$asList_u2dGBYM_sE) {
        Intrinsics.checkNotNullParameter($this$asList_u2dGBYM_sE, "$this$asList");
        UArraysKt___UArraysJvmKt.asList.3 anon = new UArraysKt___UArraysJvmKt.asList.3($this$asList_u2dGBYM_sE);
        return (List)anon;
    }

    public static final List<ULong> asList-QwZRm1k(long[] $this$asList_u2dQwZRm1k) {
        Intrinsics.checkNotNullParameter($this$asList_u2dQwZRm1k, "$this$asList");
        UArraysKt___UArraysJvmKt.asList.2 anon = new UArraysKt___UArraysJvmKt.asList.2($this$asList_u2dQwZRm1k);
        return (List)anon;
    }

    public static final List<UShort> asList-rL5Bavg(short[] $this$asList_u2drL5Bavg) {
        Intrinsics.checkNotNullParameter($this$asList_u2drL5Bavg, "$this$asList");
        UArraysKt___UArraysJvmKt.asList.4 anon = new UArraysKt___UArraysJvmKt.asList.4($this$asList_u2drL5Bavg);
        return (List)anon;
    }

    public static final int binarySearch-2fe2U9s(int[] $this$binarySearch_u2d2fe2U9s, int element, int fromIndex, int toIndex) {
        int low;
        int high;
        int i;
        int i2;
        int uintCompare;
        Intrinsics.checkNotNullParameter($this$binarySearch_u2d2fe2U9s, "$this$binarySearch");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(fromIndex, toIndex, UIntArray.getSize-impl($this$binarySearch_u2d2fe2U9s));
        low = fromIndex;
        high = toIndex + -1;
        while (low <= high) {
            i5 >>>= 1;
            uintCompare = UnsignedKt.uintCompare($this$binarySearch_u2d2fe2U9s[i], element);
            high = i + -1;
            low = i + 1;
        }
        return -mid;
    }

    public static int binarySearch-2fe2U9s$default(int[] iArr, int i2, int i3, int i4, int i5, Object object6) {
        int obj2;
        int obj3;
        if (i5 & 2 != 0) {
            obj2 = 0;
        }
        if (i5 &= 4 != 0) {
            obj3 = UIntArray.getSize-impl(iArr);
        }
        return UArraysKt.binarySearch-2fe2U9s(iArr, i2, obj2, obj3);
    }

    public static final int binarySearch-EtDCXyQ(short[] $this$binarySearch_u2dEtDCXyQ, short element, int fromIndex, int toIndex) {
        int low;
        int high;
        int i;
        short s;
        int uintCompare;
        Intrinsics.checkNotNullParameter($this$binarySearch_u2dEtDCXyQ, "$this$binarySearch");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(fromIndex, toIndex, UShortArray.getSize-impl($this$binarySearch_u2dEtDCXyQ));
        low = fromIndex;
        high = toIndex + -1;
        while (low <= high) {
            i5 >>>= 1;
            uintCompare = UnsignedKt.uintCompare($this$binarySearch_u2dEtDCXyQ[i], i2 &= element);
            high = i + -1;
            low = i + 1;
        }
        return -mid;
    }

    public static int binarySearch-EtDCXyQ$default(short[] sArr, short s2, int i3, int i4, int i5, Object object6) {
        int obj2;
        int obj3;
        if (i5 & 2 != 0) {
            obj2 = 0;
        }
        if (i5 &= 4 != 0) {
            obj3 = UShortArray.getSize-impl(sArr);
        }
        return UArraysKt.binarySearch-EtDCXyQ(sArr, s2, obj2, obj3);
    }

    public static final int binarySearch-K6DWlUc(long[] $this$binarySearch_u2dK6DWlUc, long element, int fromIndex, int toIndex) {
        int low;
        int high;
        int i;
        long l;
        int ulongCompare;
        Intrinsics.checkNotNullParameter($this$binarySearch_u2dK6DWlUc, "$this$binarySearch");
        final int size-impl = ULongArray.getSize-impl($this$binarySearch_u2dK6DWlUc);
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(toIndex, obj12, size-impl);
        low = toIndex;
        high = obj12 + -1;
        while (low <= high) {
            i3 >>>= 1;
            ulongCompare = UnsignedKt.ulongCompare($this$binarySearch_u2dK6DWlUc[i], obj6);
            high = i + -1;
            low = i + 1;
        }
        return -mid;
    }

    public static int binarySearch-K6DWlUc$default(long[] lArr, long l2, int i3, int i4, int i5, Object object6) {
        int obj3;
        int obj4;
        if (object6 & 2 != 0) {
            obj3 = 0;
        }
        if (object6 &= 4 != 0) {
            obj4 = ULongArray.getSize-impl(lArr);
        }
        return UArraysKt.binarySearch-K6DWlUc(lArr, l2, i3, obj3);
    }

    public static final int binarySearch-WpHrYlw(byte[] $this$binarySearch_u2dWpHrYlw, byte element, int fromIndex, int toIndex) {
        int low;
        int high;
        int i;
        byte b;
        int uintCompare;
        Intrinsics.checkNotNullParameter($this$binarySearch_u2dWpHrYlw, "$this$binarySearch");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(fromIndex, toIndex, UByteArray.getSize-impl($this$binarySearch_u2dWpHrYlw));
        low = fromIndex;
        high = toIndex + -1;
        while (low <= high) {
            i4 >>>= 1;
            uintCompare = UnsignedKt.uintCompare($this$binarySearch_u2dWpHrYlw[i], element & 255);
            high = i + -1;
            low = i + 1;
        }
        return -mid;
    }

    public static int binarySearch-WpHrYlw$default(byte[] bArr, byte b2, int i3, int i4, int i5, Object object6) {
        int obj2;
        int obj3;
        if (i5 & 2 != 0) {
            obj2 = 0;
        }
        if (i5 &= 4 != 0) {
            obj3 = UByteArray.getSize-impl(bArr);
        }
        return UArraysKt.binarySearch-WpHrYlw(bArr, b2, obj2, obj3);
    }

    private static final byte elementAt-PpDY95g(byte[] $this$elementAt_u2dPpDY95g, int index) {
        Intrinsics.checkNotNullParameter($this$elementAt_u2dPpDY95g, "$this$elementAt");
        return UByteArray.get-w2LRezQ($this$elementAt_u2dPpDY95g, index);
    }

    private static final short elementAt-nggk6HY(short[] $this$elementAt_u2dnggk6HY, int index) {
        Intrinsics.checkNotNullParameter($this$elementAt_u2dnggk6HY, "$this$elementAt");
        return UShortArray.get-Mh2AYeg($this$elementAt_u2dnggk6HY, index);
    }

    private static final int elementAt-qFRl0hI(int[] $this$elementAt_u2dqFRl0hI, int index) {
        Intrinsics.checkNotNullParameter($this$elementAt_u2dqFRl0hI, "$this$elementAt");
        return UIntArray.get-pVg5ArA($this$elementAt_u2dqFRl0hI, index);
    }

    private static final long elementAt-r7IrZao(long[] $this$elementAt_u2dr7IrZao, int index) {
        Intrinsics.checkNotNullParameter($this$elementAt_u2dr7IrZao, "$this$elementAt");
        return ULongArray.get-s-VKNKU($this$elementAt_u2dr7IrZao, index);
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final UInt max--ajY-9A(int[] $this$max_u2d_u2dajY_u2d9A) {
        Intrinsics.checkNotNullParameter($this$max_u2d_u2dajY_u2d9A, "$this$max");
        return UArraysKt.maxOrNull--ajY-9A($this$max_u2d_u2dajY_u2d9A);
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final UByte max-GBYM_sE(byte[] $this$max_u2dGBYM_sE) {
        Intrinsics.checkNotNullParameter($this$max_u2dGBYM_sE, "$this$max");
        return UArraysKt.maxOrNull-GBYM_sE($this$max_u2dGBYM_sE);
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final ULong max-QwZRm1k(long[] $this$max_u2dQwZRm1k) {
        Intrinsics.checkNotNullParameter($this$max_u2dQwZRm1k, "$this$max");
        return UArraysKt.maxOrNull-QwZRm1k($this$max_u2dQwZRm1k);
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final UShort max-rL5Bavg(short[] $this$max_u2drL5Bavg) {
        Intrinsics.checkNotNullParameter($this$max_u2drL5Bavg, "$this$max");
        return UArraysKt.maxOrNull-rL5Bavg($this$max_u2drL5Bavg);
    }

    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    private static final <R extends Comparable<? super R>> UByte maxBy-JOV_ifY(byte[] $this$maxBy_u2dJOV_ifY, Function1<? super UByte, ? extends R> selector) {
        byte b;
        UByte box-impl;
        int lastIndex;
        Object invoke;
        int i;
        byte b2;
        Object invoke2;
        int compareTo;
        Intrinsics.checkNotNullParameter($this$maxBy_u2dJOV_ifY, "$this$maxBy");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UByteArray.isEmpty-impl($this$maxBy_u2dJOV_ifY)) {
            box-impl = 0;
        } else {
            lastIndex = ArraysKt.getLastIndex($this$maxBy_u2dJOV_ifY);
            invoke = selector.invoke(UByte.box-impl(UByteArray.get-w2LRezQ($this$maxBy_u2dJOV_ifY, 0)));
            if (lastIndex == 0 && 1 <= lastIndex) {
                invoke = selector.invoke(UByte.box-impl(b));
                if (1 <= lastIndex) {
                }
            }
            box-impl = UByte.box-impl(b);
        }
        return box-impl;
    }

    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    private static final <R extends Comparable<? super R>> ULong maxBy-MShoTSo(long[] $this$maxBy_u2dMShoTSo, Function1<? super ULong, ? extends R> selector) {
        long l2;
        ULong box-impl;
        int lastIndex;
        Object invoke;
        int i;
        long l;
        Object invoke2;
        int compareTo;
        Intrinsics.checkNotNullParameter($this$maxBy_u2dMShoTSo, "$this$maxBy");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (ULongArray.isEmpty-impl($this$maxBy_u2dMShoTSo)) {
            box-impl = 0;
        } else {
            lastIndex = ArraysKt.getLastIndex($this$maxBy_u2dMShoTSo);
            invoke = selector.invoke(ULong.box-impl(ULongArray.get-s-VKNKU($this$maxBy_u2dMShoTSo, 0)));
            if (lastIndex == 0 && 1 <= lastIndex) {
                invoke = selector.invoke(ULong.box-impl(l2));
                if (1 <= lastIndex) {
                }
            }
            box-impl = ULong.box-impl(l2);
        }
        return box-impl;
    }

    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    private static final <R extends Comparable<? super R>> UInt maxBy-jgv0xPQ(int[] $this$maxBy_u2djgv0xPQ, Function1<? super UInt, ? extends R> selector) {
        int i;
        UInt box-impl;
        int lastIndex;
        Object invoke;
        int i3;
        int i2;
        Object invoke2;
        int compareTo;
        Intrinsics.checkNotNullParameter($this$maxBy_u2djgv0xPQ, "$this$maxBy");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UIntArray.isEmpty-impl($this$maxBy_u2djgv0xPQ)) {
            box-impl = 0;
        } else {
            lastIndex = ArraysKt.getLastIndex($this$maxBy_u2djgv0xPQ);
            invoke = selector.invoke(UInt.box-impl(UIntArray.get-pVg5ArA($this$maxBy_u2djgv0xPQ, 0)));
            if (lastIndex == 0 && 1 <= lastIndex) {
                invoke = selector.invoke(UInt.box-impl(i));
                if (1 <= lastIndex) {
                }
            }
            box-impl = UInt.box-impl(i);
        }
        return box-impl;
    }

    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    private static final <R extends Comparable<? super R>> UShort maxBy-xTcfx_M(short[] $this$maxBy_u2dxTcfx_M, Function1<? super UShort, ? extends R> selector) {
        short s2;
        UShort box-impl;
        int lastIndex;
        Object invoke;
        int i;
        short s;
        Object invoke2;
        int compareTo;
        Intrinsics.checkNotNullParameter($this$maxBy_u2dxTcfx_M, "$this$maxBy");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UShortArray.isEmpty-impl($this$maxBy_u2dxTcfx_M)) {
            box-impl = 0;
        } else {
            lastIndex = ArraysKt.getLastIndex($this$maxBy_u2dxTcfx_M);
            invoke = selector.invoke(UShort.box-impl(UShortArray.get-Mh2AYeg($this$maxBy_u2dxTcfx_M, 0)));
            if (lastIndex == 0 && 1 <= lastIndex) {
                invoke = selector.invoke(UShort.box-impl(s2));
                if (1 <= lastIndex) {
                }
            }
            box-impl = UShort.box-impl(s2);
        }
        return box-impl;
    }

    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final UByte maxWith-XMRcp5o(byte[] $this$maxWith_u2dXMRcp5o, Comparator comparator) {
        Intrinsics.checkNotNullParameter($this$maxWith_u2dXMRcp5o, "$this$maxWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return UArraysKt.maxWithOrNull-XMRcp5o($this$maxWith_u2dXMRcp5o, comparator);
    }

    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final UInt maxWith-YmdZ_VM(int[] $this$maxWith_u2dYmdZ_VM, Comparator comparator) {
        Intrinsics.checkNotNullParameter($this$maxWith_u2dYmdZ_VM, "$this$maxWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return UArraysKt.maxWithOrNull-YmdZ_VM($this$maxWith_u2dYmdZ_VM, comparator);
    }

    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final UShort maxWith-eOHTfZs(short[] $this$maxWith_u2deOHTfZs, Comparator comparator) {
        Intrinsics.checkNotNullParameter($this$maxWith_u2deOHTfZs, "$this$maxWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return UArraysKt.maxWithOrNull-eOHTfZs($this$maxWith_u2deOHTfZs, comparator);
    }

    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final ULong maxWith-zrEWJaI(long[] $this$maxWith_u2dzrEWJaI, Comparator comparator) {
        Intrinsics.checkNotNullParameter($this$maxWith_u2dzrEWJaI, "$this$maxWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return UArraysKt.maxWithOrNull-zrEWJaI($this$maxWith_u2dzrEWJaI, comparator);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final UInt min--ajY-9A(int[] $this$min_u2d_u2dajY_u2d9A) {
        Intrinsics.checkNotNullParameter($this$min_u2d_u2dajY_u2d9A, "$this$min");
        return UArraysKt.minOrNull--ajY-9A($this$min_u2d_u2dajY_u2d9A);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final UByte min-GBYM_sE(byte[] $this$min_u2dGBYM_sE) {
        Intrinsics.checkNotNullParameter($this$min_u2dGBYM_sE, "$this$min");
        return UArraysKt.minOrNull-GBYM_sE($this$min_u2dGBYM_sE);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final ULong min-QwZRm1k(long[] $this$min_u2dQwZRm1k) {
        Intrinsics.checkNotNullParameter($this$min_u2dQwZRm1k, "$this$min");
        return UArraysKt.minOrNull-QwZRm1k($this$min_u2dQwZRm1k);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final UShort min-rL5Bavg(short[] $this$min_u2drL5Bavg) {
        Intrinsics.checkNotNullParameter($this$min_u2drL5Bavg, "$this$min");
        return UArraysKt.minOrNull-rL5Bavg($this$min_u2drL5Bavg);
    }

    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    private static final <R extends Comparable<? super R>> UByte minBy-JOV_ifY(byte[] $this$minBy_u2dJOV_ifY, Function1<? super UByte, ? extends R> selector) {
        byte b;
        UByte box-impl;
        int lastIndex;
        Object invoke;
        int i;
        byte b2;
        Object invoke2;
        int compareTo;
        Intrinsics.checkNotNullParameter($this$minBy_u2dJOV_ifY, "$this$minBy");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UByteArray.isEmpty-impl($this$minBy_u2dJOV_ifY)) {
            box-impl = 0;
        } else {
            lastIndex = ArraysKt.getLastIndex($this$minBy_u2dJOV_ifY);
            invoke = selector.invoke(UByte.box-impl(UByteArray.get-w2LRezQ($this$minBy_u2dJOV_ifY, 0)));
            if (lastIndex == 0 && 1 <= lastIndex) {
                invoke = selector.invoke(UByte.box-impl(b));
                if (1 <= lastIndex) {
                }
            }
            box-impl = UByte.box-impl(b);
        }
        return box-impl;
    }

    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    private static final <R extends Comparable<? super R>> ULong minBy-MShoTSo(long[] $this$minBy_u2dMShoTSo, Function1<? super ULong, ? extends R> selector) {
        long l2;
        ULong box-impl;
        int lastIndex;
        Object invoke2;
        int i;
        long l;
        Object invoke;
        int compareTo;
        Intrinsics.checkNotNullParameter($this$minBy_u2dMShoTSo, "$this$minBy");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (ULongArray.isEmpty-impl($this$minBy_u2dMShoTSo)) {
            box-impl = 0;
        } else {
            lastIndex = ArraysKt.getLastIndex($this$minBy_u2dMShoTSo);
            invoke2 = selector.invoke(ULong.box-impl(ULongArray.get-s-VKNKU($this$minBy_u2dMShoTSo, 0)));
            if (lastIndex == 0 && 1 <= lastIndex) {
                invoke2 = selector.invoke(ULong.box-impl(l2));
                if (1 <= lastIndex) {
                }
            }
            box-impl = ULong.box-impl(l2);
        }
        return box-impl;
    }

    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    private static final <R extends Comparable<? super R>> UInt minBy-jgv0xPQ(int[] $this$minBy_u2djgv0xPQ, Function1<? super UInt, ? extends R> selector) {
        int i3;
        UInt box-impl;
        int lastIndex;
        Object invoke;
        int i;
        int i2;
        Object invoke2;
        int compareTo;
        Intrinsics.checkNotNullParameter($this$minBy_u2djgv0xPQ, "$this$minBy");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UIntArray.isEmpty-impl($this$minBy_u2djgv0xPQ)) {
            box-impl = 0;
        } else {
            lastIndex = ArraysKt.getLastIndex($this$minBy_u2djgv0xPQ);
            invoke = selector.invoke(UInt.box-impl(UIntArray.get-pVg5ArA($this$minBy_u2djgv0xPQ, 0)));
            if (lastIndex == 0 && 1 <= lastIndex) {
                invoke = selector.invoke(UInt.box-impl(i3));
                if (1 <= lastIndex) {
                }
            }
            box-impl = UInt.box-impl(i3);
        }
        return box-impl;
    }

    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    private static final <R extends Comparable<? super R>> UShort minBy-xTcfx_M(short[] $this$minBy_u2dxTcfx_M, Function1<? super UShort, ? extends R> selector) {
        short s;
        UShort box-impl;
        int lastIndex;
        Object invoke2;
        int i;
        short s2;
        Object invoke;
        int compareTo;
        Intrinsics.checkNotNullParameter($this$minBy_u2dxTcfx_M, "$this$minBy");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UShortArray.isEmpty-impl($this$minBy_u2dxTcfx_M)) {
            box-impl = 0;
        } else {
            lastIndex = ArraysKt.getLastIndex($this$minBy_u2dxTcfx_M);
            invoke2 = selector.invoke(UShort.box-impl(UShortArray.get-Mh2AYeg($this$minBy_u2dxTcfx_M, 0)));
            if (lastIndex == 0 && 1 <= lastIndex) {
                invoke2 = selector.invoke(UShort.box-impl(s));
                if (1 <= lastIndex) {
                }
            }
            box-impl = UShort.box-impl(s);
        }
        return box-impl;
    }

    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final UByte minWith-XMRcp5o(byte[] $this$minWith_u2dXMRcp5o, Comparator comparator) {
        Intrinsics.checkNotNullParameter($this$minWith_u2dXMRcp5o, "$this$minWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return UArraysKt.minWithOrNull-XMRcp5o($this$minWith_u2dXMRcp5o, comparator);
    }

    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final UInt minWith-YmdZ_VM(int[] $this$minWith_u2dYmdZ_VM, Comparator comparator) {
        Intrinsics.checkNotNullParameter($this$minWith_u2dYmdZ_VM, "$this$minWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return UArraysKt.minWithOrNull-YmdZ_VM($this$minWith_u2dYmdZ_VM, comparator);
    }

    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final UShort minWith-eOHTfZs(short[] $this$minWith_u2deOHTfZs, Comparator comparator) {
        Intrinsics.checkNotNullParameter($this$minWith_u2deOHTfZs, "$this$minWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return UArraysKt.minWithOrNull-eOHTfZs($this$minWith_u2deOHTfZs, comparator);
    }

    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final ULong minWith-zrEWJaI(long[] $this$minWith_u2dzrEWJaI, Comparator comparator) {
        Intrinsics.checkNotNullParameter($this$minWith_u2dzrEWJaI, "$this$minWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return UArraysKt.minWithOrNull-zrEWJaI($this$minWith_u2dzrEWJaI, comparator);
    }

    private static final BigDecimal sumOfBigDecimal(byte[] $this$sumOf_u2dJOV_ifY, Function1<? super UByte, ? extends BigDecimal> selector) {
        BigDecimal sum;
        int i;
        byte b;
        BigDecimal num;
        String str;
        Intrinsics.checkNotNullParameter($this$sumOf_u2dJOV_ifY, "$this$sumOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Intrinsics.checkNotNullExpressionValue(BigDecimal.valueOf(0), "valueOf(...)");
        i = 0;
        while (i < UByteArray.getSize-impl($this$sumOf_u2dJOV_ifY)) {
            num = sum.add((BigDecimal)selector.invoke(UByte.box-impl(UByteArray.get-w2LRezQ($this$sumOf_u2dJOV_ifY, i))));
            Intrinsics.checkNotNullExpressionValue(num, "add(...)");
            sum = num;
            i++;
        }
        return sum;
    }

    private static final BigDecimal sumOfBigDecimal(int[] $this$sumOf_u2djgv0xPQ, Function1<? super UInt, ? extends BigDecimal> selector) {
        BigDecimal sum;
        int i2;
        int i;
        BigDecimal num;
        String str;
        Intrinsics.checkNotNullParameter($this$sumOf_u2djgv0xPQ, "$this$sumOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Intrinsics.checkNotNullExpressionValue(BigDecimal.valueOf(0), "valueOf(...)");
        i2 = 0;
        while (i2 < UIntArray.getSize-impl($this$sumOf_u2djgv0xPQ)) {
            num = sum.add((BigDecimal)selector.invoke(UInt.box-impl(UIntArray.get-pVg5ArA($this$sumOf_u2djgv0xPQ, i2))));
            Intrinsics.checkNotNullExpressionValue(num, "add(...)");
            sum = num;
            i2++;
        }
        return sum;
    }

    private static final BigDecimal sumOfBigDecimal(long[] $this$sumOf_u2dMShoTSo, Function1<? super ULong, ? extends BigDecimal> selector) {
        BigDecimal sum;
        int i;
        long l;
        BigDecimal num;
        String str;
        Intrinsics.checkNotNullParameter($this$sumOf_u2dMShoTSo, "$this$sumOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Intrinsics.checkNotNullExpressionValue(BigDecimal.valueOf(0), "valueOf(...)");
        i = 0;
        while (i < ULongArray.getSize-impl($this$sumOf_u2dMShoTSo)) {
            num = sum.add((BigDecimal)selector.invoke(ULong.box-impl(ULongArray.get-s-VKNKU($this$sumOf_u2dMShoTSo, i))));
            Intrinsics.checkNotNullExpressionValue(num, "add(...)");
            sum = num;
            i++;
        }
        return sum;
    }

    private static final BigDecimal sumOfBigDecimal(short[] $this$sumOf_u2dxTcfx_M, Function1<? super UShort, ? extends BigDecimal> selector) {
        BigDecimal sum;
        int i;
        short s;
        BigDecimal num;
        String str;
        Intrinsics.checkNotNullParameter($this$sumOf_u2dxTcfx_M, "$this$sumOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Intrinsics.checkNotNullExpressionValue(BigDecimal.valueOf(0), "valueOf(...)");
        i = 0;
        while (i < UShortArray.getSize-impl($this$sumOf_u2dxTcfx_M)) {
            num = sum.add((BigDecimal)selector.invoke(UShort.box-impl(UShortArray.get-Mh2AYeg($this$sumOf_u2dxTcfx_M, i))));
            Intrinsics.checkNotNullExpressionValue(num, "add(...)");
            sum = num;
            i++;
        }
        return sum;
    }

    private static final BigInteger sumOfBigInteger(byte[] $this$sumOf_u2dJOV_ifY, Function1<? super UByte, ? extends BigInteger> selector) {
        BigInteger sum;
        int i;
        byte b;
        BigInteger num;
        String str;
        Intrinsics.checkNotNullParameter($this$sumOf_u2dJOV_ifY, "$this$sumOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Intrinsics.checkNotNullExpressionValue(BigInteger.valueOf(0), "valueOf(...)");
        i = 0;
        while (i < UByteArray.getSize-impl($this$sumOf_u2dJOV_ifY)) {
            num = sum.add((BigInteger)selector.invoke(UByte.box-impl(UByteArray.get-w2LRezQ($this$sumOf_u2dJOV_ifY, i))));
            Intrinsics.checkNotNullExpressionValue(num, "add(...)");
            sum = num;
            i++;
        }
        return sum;
    }

    private static final BigInteger sumOfBigInteger(int[] $this$sumOf_u2djgv0xPQ, Function1<? super UInt, ? extends BigInteger> selector) {
        BigInteger sum;
        int i2;
        int i;
        BigInteger num;
        String str;
        Intrinsics.checkNotNullParameter($this$sumOf_u2djgv0xPQ, "$this$sumOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Intrinsics.checkNotNullExpressionValue(BigInteger.valueOf(0), "valueOf(...)");
        i2 = 0;
        while (i2 < UIntArray.getSize-impl($this$sumOf_u2djgv0xPQ)) {
            num = sum.add((BigInteger)selector.invoke(UInt.box-impl(UIntArray.get-pVg5ArA($this$sumOf_u2djgv0xPQ, i2))));
            Intrinsics.checkNotNullExpressionValue(num, "add(...)");
            sum = num;
            i2++;
        }
        return sum;
    }

    private static final BigInteger sumOfBigInteger(long[] $this$sumOf_u2dMShoTSo, Function1<? super ULong, ? extends BigInteger> selector) {
        BigInteger sum;
        int i;
        long l;
        BigInteger num;
        String str;
        Intrinsics.checkNotNullParameter($this$sumOf_u2dMShoTSo, "$this$sumOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Intrinsics.checkNotNullExpressionValue(BigInteger.valueOf(0), "valueOf(...)");
        i = 0;
        while (i < ULongArray.getSize-impl($this$sumOf_u2dMShoTSo)) {
            num = sum.add((BigInteger)selector.invoke(ULong.box-impl(ULongArray.get-s-VKNKU($this$sumOf_u2dMShoTSo, i))));
            Intrinsics.checkNotNullExpressionValue(num, "add(...)");
            sum = num;
            i++;
        }
        return sum;
    }

    private static final BigInteger sumOfBigInteger(short[] $this$sumOf_u2dxTcfx_M, Function1<? super UShort, ? extends BigInteger> selector) {
        BigInteger sum;
        int i;
        short s;
        BigInteger num;
        String str;
        Intrinsics.checkNotNullParameter($this$sumOf_u2dxTcfx_M, "$this$sumOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Intrinsics.checkNotNullExpressionValue(BigInteger.valueOf(0), "valueOf(...)");
        i = 0;
        while (i < UShortArray.getSize-impl($this$sumOf_u2dxTcfx_M)) {
            num = sum.add((BigInteger)selector.invoke(UShort.box-impl(UShortArray.get-Mh2AYeg($this$sumOf_u2dxTcfx_M, i))));
            Intrinsics.checkNotNullExpressionValue(num, "add(...)");
            sum = num;
            i++;
        }
        return sum;
    }
}
