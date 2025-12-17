package kotlin.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShortArray;
import kotlin.collections.unsigned.UArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000H\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a5\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u000c\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0018\u00010\u00032\u0010\u0010\u0004\u001a\u000c\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0018\u00010\u0003H\u0001¢\u0006\u0004\u0008\u0005\u0010\u0006\u001a#\u0010\u0007\u001a\u00020\u0008\"\u0004\u0008\u0000\u0010\u0002*\u000c\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0018\u00010\u0003H\u0001¢\u0006\u0004\u0008\t\u0010\n\u001a?\u0010\u000b\u001a\u00020\u000c\"\u0004\u0008\u0000\u0010\u0002*\n\u0012\u0006\u0008\u0001\u0012\u0002H\u00020\u00032\n\u0010\r\u001a\u00060\u000ej\u0002`\u000f2\u0010\u0010\u0010\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00030\u0011H\u0002¢\u0006\u0004\u0008\u0012\u0010\u0013\u001a+\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0015\"\u0004\u0008\u0000\u0010\u0002*\u0012\u0012\u000e\u0008\u0001\u0012\n\u0012\u0006\u0008\u0001\u0012\u0002H\u00020\u00030\u0003¢\u0006\u0002\u0010\u0016\u001aH\u0010\u0017\u001a\u0002H\u0018\"\u0010\u0008\u0000\u0010\u0019*\u0006\u0012\u0002\u0008\u00030\u0003*\u0002H\u0018\"\u0004\u0008\u0001\u0010\u0018*\u0002H\u00192\u000c\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u0002H\u00180\u001bH\u0087\u0008ø\u0001\u0000\u0082\u0002\n\n\u0008\u0008\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010\u001c\u001a)\u0010\u001d\u001a\u00020\u0001*\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u0003H\u0087\u0008\u0082\u0002\u000e\n\u000c\u0008\u0000\u0012\u0002\u0018\u0001\u001a\u0004\u0008\u0003\u0010\u0000¢\u0006\u0002\u0010\u001e\u001aG\u0010\u001f\u001a\u001a\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\u0015\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00180\u00150 \"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0018*\u0016\u0012\u0012\u0008\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00180 0\u0003¢\u0006\u0002\u0010!\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006\"", d2 = {"contentDeepEqualsImpl", "", "T", "", "other", "contentDeepEquals", "([Ljava/lang/Object;[Ljava/lang/Object;)Z", "contentDeepToStringImpl", "", "contentDeepToString", "([Ljava/lang/Object;)Ljava/lang/String;", "contentDeepToStringInternal", "", "result", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "processed", "", "contentDeepToStringInternal$ArraysKt__ArraysKt", "([Ljava/lang/Object;Ljava/lang/StringBuilder;Ljava/util/List;)V", "flatten", "", "([[Ljava/lang/Object;)Ljava/util/List;", "ifEmpty", "R", "C", "defaultValue", "Lkotlin/Function0;", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isNullOrEmpty", "([Ljava/lang/Object;)Z", "unzip", "Lkotlin/Pair;", "([Lkotlin/Pair;)Lkotlin/Pair;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/collections/ArraysKt")
class ArraysKt__ArraysKt extends kotlin.collections.ArraysKt__ArraysJVMKt {
    public static final <T> boolean contentDeepEquals(T[] $this$contentDeepEqualsImpl, T[] other) {
        int i;
        int length;
        int length2;
        Object obj2;
        Object obj;
        boolean contentEquals-kV0jMPg;
        boolean z10;
        boolean z4;
        boolean z8;
        boolean z5;
        boolean z7;
        boolean z;
        boolean z9;
        boolean z6;
        boolean z3;
        boolean z12;
        boolean z2;
        boolean z11;
        boolean z13;
        Object unbox-impl;
        final int i2 = 1;
        if ($this$contentDeepEqualsImpl == other) {
            return i2;
        }
        final int i3 = 0;
        if ($this$contentDeepEqualsImpl != null && other != null) {
            if (other != null) {
                if ($this$contentDeepEqualsImpl.length != other.length) {
                } else {
                    i = 0;
                    while (i < $this$contentDeepEqualsImpl.length) {
                        obj2 = $this$contentDeepEqualsImpl[i];
                        obj = other[i];
                        i++;
                    }
                }
                return i2;
            }
        }
        return i3;
    }

    public static final <T> String contentDeepToString(T[] $this$contentDeepToStringImpl) {
        if ($this$contentDeepToStringImpl == null) {
            return "null";
        }
        StringBuilder stringBuilder = new StringBuilder(i += 2);
        final int i4 = 0;
        ArrayList arrayList = new ArrayList();
        ArraysKt__ArraysKt.contentDeepToStringInternal$ArraysKt__ArraysKt($this$contentDeepToStringImpl, stringBuilder, (List)arrayList);
        String string = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    private static final <T> void contentDeepToStringInternal$ArraysKt__ArraysKt(T[] $this$contentDeepToStringInternal, StringBuilder result, List<Object[]> processed) {
        int i;
        Object str;
        Object contentToString-2csIQuQ;
        String unbox-impl;
        if (processed.contains($this$contentDeepToStringInternal)) {
            result.append("[...]");
        }
        processed.add($this$contentDeepToStringInternal);
        result.append('[');
        i = 0;
        while (i < $this$contentDeepToStringInternal.length) {
            if (i != 0) {
            }
            str = $this$contentDeepToStringInternal[i];
            if (str == null) {
            } else {
            }
            if (str instanceof Object[]) {
            } else {
            }
            unbox-impl = "toString(...)";
            if (str instanceof byte[]) {
            } else {
            }
            if (str instanceof short[]) {
            } else {
            }
            if (str instanceof int[]) {
            } else {
            }
            if (str instanceof long[]) {
            } else {
            }
            if (str instanceof float[]) {
            } else {
            }
            if (str instanceof double[]) {
            } else {
            }
            if (str instanceof char[]) {
            } else {
            }
            if (str instanceof boolean[]) {
            } else {
            }
            unbox-impl = 0;
            if (str instanceof UByteArray != null) {
            } else {
            }
            if (str instanceof UShortArray != null) {
            } else {
            }
            if (str instanceof UIntArray != null) {
            } else {
            }
            if (str instanceof ULongArray != null) {
            } else {
            }
            result.append(str.toString());
            i++;
            Object obj6 = str;
            if ((ULongArray)obj6 != null) {
            }
            result.append(UArraysKt.contentToString-uLth9ew(unbox-impl));
            unbox-impl = (ULongArray)obj6.unbox-impl();
            Object obj5 = str;
            if ((UIntArray)obj5 != null) {
            }
            result.append(UArraysKt.contentToString-XUkPCBk(unbox-impl));
            unbox-impl = (UIntArray)obj5.unbox-impl();
            Object obj4 = str;
            if ((UShortArray)obj4 != null) {
            }
            result.append(UArraysKt.contentToString-d-6D3K8(unbox-impl));
            unbox-impl = (UShortArray)obj4.unbox-impl();
            Object obj3 = str;
            if ((UByteArray)obj3 != null) {
            }
            result.append(UArraysKt.contentToString-2csIQuQ(unbox-impl));
            unbox-impl = (UByteArray)obj3.unbox-impl();
            contentToString-2csIQuQ = Arrays.toString((boolean[])str);
            Intrinsics.checkNotNullExpressionValue(contentToString-2csIQuQ, unbox-impl);
            result.append(contentToString-2csIQuQ);
            contentToString-2csIQuQ = Arrays.toString((char[])str);
            Intrinsics.checkNotNullExpressionValue(contentToString-2csIQuQ, unbox-impl);
            result.append(contentToString-2csIQuQ);
            contentToString-2csIQuQ = Arrays.toString((double[])str);
            Intrinsics.checkNotNullExpressionValue(contentToString-2csIQuQ, unbox-impl);
            result.append(contentToString-2csIQuQ);
            contentToString-2csIQuQ = Arrays.toString((float[])str);
            Intrinsics.checkNotNullExpressionValue(contentToString-2csIQuQ, unbox-impl);
            result.append(contentToString-2csIQuQ);
            contentToString-2csIQuQ = Arrays.toString((long[])str);
            Intrinsics.checkNotNullExpressionValue(contentToString-2csIQuQ, unbox-impl);
            result.append(contentToString-2csIQuQ);
            contentToString-2csIQuQ = Arrays.toString((int[])str);
            Intrinsics.checkNotNullExpressionValue(contentToString-2csIQuQ, unbox-impl);
            result.append(contentToString-2csIQuQ);
            contentToString-2csIQuQ = Arrays.toString((short[])str);
            Intrinsics.checkNotNullExpressionValue(contentToString-2csIQuQ, unbox-impl);
            result.append(contentToString-2csIQuQ);
            contentToString-2csIQuQ = Arrays.toString((byte[])str);
            Intrinsics.checkNotNullExpressionValue(contentToString-2csIQuQ, unbox-impl);
            result.append(contentToString-2csIQuQ);
            ArraysKt__ArraysKt.contentDeepToStringInternal$ArraysKt__ArraysKt((Object[])str, result, processed);
            result.append("null");
            result.append(", ");
        }
        result.append(']');
        processed.remove(CollectionsKt.getLastIndex(processed));
    }

    public static final <T> List<T> flatten(T[][] $this$flatten) {
        int i;
        int i3;
        int i2;
        int it;
        int i4;
        Intrinsics.checkNotNullParameter($this$flatten, "<this>");
        Object obj = $this$flatten;
        i2 = i3;
        while (i3 < obj.length) {
            i4 = 0;
            i2 += it;
            i3++;
        }
        ArrayList arrayList = new ArrayList(i2);
        while (i < obj2.length) {
            CollectionsKt.addAll((Collection)arrayList, $this$flatten[i]);
            i++;
        }
        return (List)arrayList;
    }

    private static final <C extends Object[] & R, R> R ifEmpty(C $this$ifEmpty, Function0<? extends R> defaultValue) {
        int i;
        Object invoke;
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        i = $this$ifEmpty.length == 0 ? 1 : 0;
        if (i != 0) {
            invoke = defaultValue.invoke();
        } else {
            invoke = $this$ifEmpty;
        }
        return invoke;
    }

    private static final boolean isNullOrEmpty(Object[] $this$isNullOrEmpty) {
        int i2;
        int i3;
        int i;
        if ($this$isNullOrEmpty != null) {
            i = 0;
            i3 = $this$isNullOrEmpty.length == 0 ? i2 : i;
            if (i3 != 0) {
            } else {
                i2 = i;
            }
        }
        return i2;
    }

    public static final <T, R> Pair<List<T>, List<R>> unzip(Pair<? extends T, ? extends R>[] $this$unzip) {
        int i;
        Object obj;
        Object second;
        Intrinsics.checkNotNullParameter($this$unzip, "<this>");
        ArrayList arrayList = new ArrayList($this$unzip.length);
        ArrayList arrayList2 = new ArrayList($this$unzip.length);
        i = 0;
        while (i < $this$unzip.length) {
            obj = $this$unzip[i];
            arrayList.add(obj.getFirst());
            arrayList2.add(obj.getSecond());
            i++;
        }
        return TuplesKt.to(arrayList, arrayList2);
    }
}
