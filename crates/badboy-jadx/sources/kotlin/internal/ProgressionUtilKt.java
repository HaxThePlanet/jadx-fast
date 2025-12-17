package kotlin.internal;

import kotlin.Metadata;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0012\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0002\u0008\u0006\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0002\u001a \u0010\u0000\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a \u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0008\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0001H\u0001\u001a \u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0008\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0001\u001a\u0018\u0010\n\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0002\u001a\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0005H\u0002¨\u0006\u000b", d2 = {"differenceModulo", "", "a", "b", "c", "", "getProgressionLastElement", "start", "end", "step", "mod", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class ProgressionUtilKt {
    private static final int differenceModulo(int a, int b, int c) {
        return ProgressionUtilKt.mod(i -= i4, c);
    }

    private static final long differenceModulo(long a, long b, long c) {
        return ProgressionUtilKt.mod(l -= l3, obj1);
    }

    public static final int getProgressionLastElement(int start, int end, int step) {
        int i;
        if (step > 0) {
            if (start >= end) {
                i = end;
            } else {
                i = end - differenceModulo;
            }
            return i;
        } else {
            if (step >= 0) {
            } else {
                if (start <= end) {
                } else {
                    differenceModulo2 += end;
                }
            }
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Step is zero.");
        throw illegalArgumentException;
    }

    public static final long getProgressionLastElement(long start, long end, long step) {
        int differenceModulo;
        int step2;
        long l;
        long obj6;
        long obj8;
        int obj10;
        differenceModulo = 0;
        if (Long.compare(obj10, differenceModulo) > 0) {
            if (Long.compare(start, step) >= 0) {
                step2 = obj10;
                obj10 = step;
            } else {
                obj8 = start;
                obj6 = l;
                obj6 = l2;
                step2 = obj10;
                obj10 = obj8 - differenceModulo;
            }
            return obj10;
        } else {
            step2 = obj10;
            if (Long.compare(step2, differenceModulo) >= 0) {
            } else {
                if (Long.compare(start, step) <= 0) {
                } else {
                    obj10 += step;
                }
            }
        }
        obj10 = new IllegalArgumentException("Step is zero.");
        throw obj10;
    }

    private static final int mod(int a, int b) {
        int i;
        final int i2 = a % b;
        i = i2 >= 0 ? i2 : i2 + b;
        return i;
    }

    private static final long mod(long a, long b) {
        int i;
        final int i2 = a % obj6;
        i = Long.compare(i2, i3) >= 0 ? i2 : i2 + obj6;
        return i;
    }
}
