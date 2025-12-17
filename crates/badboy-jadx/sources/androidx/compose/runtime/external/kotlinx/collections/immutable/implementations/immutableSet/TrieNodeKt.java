package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet;

import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0007\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0005\u001a\u0018\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0000\u001a7\u0010\u0008\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t\"\u0004\u0008\u0000\u0010\u000b*\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u000c\u001a\u0002H\u000bH\u0002¢\u0006\u0002\u0010\r\u001aL\u0010\u000e\u001a\u00020\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00012\u0016\u0008\u0002\u0010\u0011\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u00130\u0012H\u0082\u0008¢\u0006\u0002\u0010\u0014\u001a)\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t*\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\u0006\u0010\u0016\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010\u0017\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0018", d2 = {"LOG_MAX_BRANCHING_FACTOR", "", "MAX_BRANCHING_FACTOR", "MAX_BRANCHING_FACTOR_MINUS_ONE", "MAX_SHIFT", "indexSegment", "index", "shift", "addElementAtIndex", "", "", "E", "element", "([Ljava/lang/Object;ILjava/lang/Object;)[Ljava/lang/Object;", "filterTo", "newArray", "newArrayOffset", "predicate", "Lkotlin/Function1;", "", "([Ljava/lang/Object;[Ljava/lang/Object;ILkotlin/jvm/functions/Function1;)I", "removeCellAtIndex", "cellIndex", "([Ljava/lang/Object;I)[Ljava/lang/Object;", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TrieNodeKt {

    public static final int LOG_MAX_BRANCHING_FACTOR = 5;
    public static final int MAX_BRANCHING_FACTOR = 32;
    public static final int MAX_BRANCHING_FACTOR_MINUS_ONE = 31;
    public static final int MAX_SHIFT = 30;
    public static final Object[] access$addElementAtIndex(Object[] $receiver, int index, Object element) {
        return TrieNodeKt.addElementAtIndex($receiver, index, element);
    }

    public static final Object[] access$removeCellAtIndex(Object[] $receiver, int cellIndex) {
        return TrieNodeKt.removeCellAtIndex($receiver, cellIndex);
    }

    private static final <E> Object[] addElementAtIndex(Object[] $this$addElementAtIndex, int index, E element) {
        final Object[] arr = new Object[length++];
        final Object[] objArr = $this$addElementAtIndex;
        final int i4 = index;
        ArraysKt.copyInto$default(objArr, arr, 0, 0, i4, 6, 0);
        ArraysKt.copyInto(objArr, arr, i4 + 1, i4, objArr.length);
        arr[i4] = element;
        return arr;
    }

    private static final int filterTo(Object[] $this$filterTo, Object[] newArray, int newArrayOffset, Function1<Object, Boolean> predicate) {
        int i4;
        int j;
        int i3;
        int i;
        Object obj;
        int i2;
        boolean booleanValue;
        int length;
        final int i5 = 0;
        i4 = 0;
        j = 0;
        while (i4 < $this$filterTo.length) {
            i = 1;
            if (j <= i4) {
            } else {
            }
            i2 = i3;
            CommonFunctionsKt.assert(i2);
            newArray[newArrayOffset + j] = $this$filterTo[i4];
            if ((Boolean)predicate.invoke($this$filterTo[i4]).booleanValue() && newArrayOffset + j <= newArray.length) {
            }
            i4++;
            newArray[newArrayOffset + j] = $this$filterTo[i4];
            if (newArrayOffset + j <= newArray.length) {
            }
            CommonFunctionsKt.assert(i3);
            i3 = i;
            i2 = i;
        }
        return j;
    }

    static int filterTo$default(Object[] $this$filterTo_u24default, Object[] newArray, int newArrayOffset, Function1 predicate, int i5, Object object6) {
        int j;
        int i2;
        int i;
        Object obj;
        int i3;
        boolean booleanValue;
        int length;
        int obj8;
        androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNodeKt.filterTo.1 obj9;
        int obj10;
        int obj11;
        if (i5 & 2 != 0) {
            obj8 = 0;
        }
        if (i5 &= 4 != 0) {
            obj9 = obj10;
        }
        obj10 = 0;
        obj11 = 0;
        j = 0;
        while (obj11 < $this$filterTo_u24default.length) {
            i = 1;
            if (j <= obj11) {
            } else {
            }
            i3 = i2;
            CommonFunctionsKt.assert(i3);
            newArray[obj8 + j] = $this$filterTo_u24default[obj11];
            if ((Boolean)obj9.invoke($this$filterTo_u24default[obj11]).booleanValue() && obj8 + j <= newArray.length) {
            }
            obj11++;
            newArray[obj8 + j] = $this$filterTo_u24default[obj11];
            if (obj8 + j <= newArray.length) {
            }
            CommonFunctionsKt.assert(i2);
            i2 = i;
            i3 = i;
        }
        return j;
    }

    public static final int indexSegment(int index, int shift) {
        return i &= 31;
    }

    private static final Object[] removeCellAtIndex(Object[] $this$removeCellAtIndex, int cellIndex) {
        final Object[] arr = new Object[length--];
        final Object[] objArr = $this$removeCellAtIndex;
        final int i4 = cellIndex;
        ArraysKt.copyInto$default(objArr, arr, 0, 0, i4, 6, 0);
        ArraysKt.copyInto(objArr, arr, i4, i4 + 1, objArr.length);
        return arr;
    }
}
