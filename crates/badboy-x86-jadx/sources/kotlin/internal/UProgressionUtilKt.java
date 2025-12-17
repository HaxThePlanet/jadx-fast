package kotlin.internal;

import kotlin.Metadata;
import kotlin.UInt;
import kotlin.ULong;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0002\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0002¢\u0006\u0004\u0008\u0005\u0010\u0006\u001a'\u0010\u0000\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0007H\u0002¢\u0006\u0004\u0008\u0008\u0010\t\u001a'\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u000c\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000eH\u0001¢\u0006\u0004\u0008\u000f\u0010\u0006\u001a'\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u000c\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0010H\u0001¢\u0006\u0004\u0008\u0011\u0010\t¨\u0006\u0012", d2 = {"differenceModulo", "Lkotlin/UInt;", "a", "b", "c", "differenceModulo-WZ9TVnA", "(III)I", "Lkotlin/ULong;", "differenceModulo-sambcqE", "(JJJ)J", "getProgressionLastElement", "start", "end", "step", "", "getProgressionLastElement-Nkh28Cs", "", "getProgressionLastElement-7ftBX0g", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class UProgressionUtilKt {
    private static final int differenceModulo-WZ9TVnA(int a, int b, int c) {
        int i;
        final int remainderUnsigned = Integer.remainderUnsigned(a, c);
        final int remainderUnsigned2 = Integer.remainderUnsigned(b, c);
        if (Integer.compareUnsigned(remainderUnsigned, remainderUnsigned2) >= 0) {
            i = remainderUnsigned - remainderUnsigned2;
        } else {
            constructor-impl2 += c;
        }
        return UInt.constructor-impl(i);
    }

    private static final long differenceModulo-sambcqE(long a, long b, long c) {
        int i;
        final long remainderUnsigned = Long.remainderUnsigned(a, b);
        final long remainderUnsigned2 = Long.remainderUnsigned(c, obj9);
        if (Long.compareUnsigned(remainderUnsigned, obj1) >= 0) {
            i = remainderUnsigned - remainderUnsigned2;
        } else {
            constructor-impl2 += obj10;
        }
        return ULong.constructor-impl(i);
    }

    public static final long getProgressionLastElement-7ftBX0g(long start, long end, long step) {
        int compareUnsigned;
        long l2;
        int cmp;
        long start2;
        long l;
        long constructor-impl;
        int obj7;
        compareUnsigned = 0;
        cmp = Long.compare(obj11, compareUnsigned);
        if (cmp > 0) {
            if (Long.compareUnsigned(start, end) >= 0) {
                start2 = start;
                obj7 = step;
            } else {
                obj7 = ULong.constructor-impl(step - obj7);
            }
            return obj7;
        } else {
            start2 = start;
            if (Long.compare(obj11, compareUnsigned) >= 0) {
            } else {
                if (Long.compareUnsigned(start2, obj4) <= 0) {
                } else {
                    compareUnsigned = start2;
                    start2 = compareUnsigned;
                    obj7 = ULong.constructor-impl(obj7 += step);
                }
            }
        }
        obj7 = new IllegalArgumentException("Step is zero.");
        throw obj7;
    }

    public static final int getProgressionLastElement-Nkh28Cs(int start, int end, int step) {
        int compareUnsigned;
        int constructor-impl;
        if (step > 0) {
            if (Integer.compareUnsigned(start, end) >= 0) {
                constructor-impl = end;
            } else {
                constructor-impl = UInt.constructor-impl(end - differenceModulo-WZ9TVnA);
            }
            return constructor-impl;
        } else {
            if (step >= 0) {
            } else {
                if (Integer.compareUnsigned(start, end) <= 0) {
                } else {
                    constructor-impl = UInt.constructor-impl(differenceModulo-WZ9TVnA2 += end);
                }
            }
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Step is zero.");
        throw illegalArgumentException;
    }
}
