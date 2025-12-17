package kotlin.random;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.LongRange;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0006\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0004H\u0007\u001a\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u0008H\u0000\u001a\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u000c2\u0006\u0010\t\u001a\u00020\u000cH\u0000\u001a\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003H\u0000\u001a\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0000\u001a\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0000\u001a\u0014\u0010\u000f\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0011H\u0007\u001a\u0014\u0010\u0012\u001a\u00020\u0004*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0013H\u0007\u001a\u0014\u0010\u0014\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003H\u0000¨\u0006\u0016", d2 = {"Random", "Lkotlin/random/Random;", "seed", "", "", "boundsErrorMessage", "", "from", "", "until", "checkRangeBounds", "", "", "fastLog2", "value", "nextInt", "range", "Lkotlin/ranges/IntRange;", "nextLong", "Lkotlin/ranges/LongRange;", "takeUpperBits", "bitCount", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class RandomKt {
    public static final kotlin.random.Random Random(int seed) {
        XorWowRandom xorWowRandom = new XorWowRandom(seed, seed >> 31);
        return (Random)xorWowRandom;
    }

    public static final kotlin.random.Random Random(long seed) {
        XorWowRandom xorWowRandom = new XorWowRandom((int)seed, (int)i3);
        return (Random)xorWowRandom;
    }

    public static final String boundsErrorMessage(Object from, Object until) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(until, "until");
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("Random range is empty: [").append(from).append(", ").append(until).append(").").toString();
    }

    public static final void checkRangeBounds(double from, double until) {
        int i;
        i = Double.compare(obj5, from) > 0 ? 1 : 0;
        if (i == 0) {
        } else {
        }
        int i2 = 0;
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(RandomKt.boundsErrorMessage(Double.valueOf(from), Double.valueOf(obj5)).toString());
        throw illegalArgumentException;
    }

    public static final void checkRangeBounds(int from, int until) {
        int i;
        i = until > from ? 1 : 0;
        if (i == 0) {
        } else {
        }
        int i2 = 0;
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(RandomKt.boundsErrorMessage(Integer.valueOf(from), Integer.valueOf(until)).toString());
        throw illegalArgumentException;
    }

    public static final void checkRangeBounds(long from, long until) {
        int i;
        i = Long.compare(obj5, from) > 0 ? 1 : 0;
        if (i == 0) {
        } else {
        }
        int i2 = 0;
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(RandomKt.boundsErrorMessage(Long.valueOf(from), Long.valueOf(obj5)).toString());
        throw illegalArgumentException;
    }

    public static final int fastLog2(int value) {
        return numberOfLeadingZeros - 31;
    }

    public static final int nextInt(kotlin.random.Random $this$nextInt, IntRange range) {
        int nextInt;
        int last;
        Intrinsics.checkNotNullParameter($this$nextInt, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        if (range.isEmpty()) {
        } else {
            if (range.getLast() < Integer.MAX_VALUE) {
                nextInt = $this$nextInt.nextInt(range.getFirst(), last3++);
            } else {
                if (range.getFirst() > Integer.MIN_VALUE) {
                    nextInt2++;
                } else {
                    nextInt = $this$nextInt.nextInt();
                }
            }
            return nextInt;
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Cannot get random in empty range: ").append(range).toString());
        throw illegalArgumentException;
    }

    public static final long nextLong(kotlin.random.Random $this$nextLong, LongRange range) {
        long nextLong2;
        long nextLong;
        long last;
        Intrinsics.checkNotNullParameter($this$nextLong, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        if (range.isEmpty()) {
        } else {
            int i = 1;
            if (Long.compare(last2, l) < 0) {
                nextLong2 = $this$nextLong.nextLong(range.getFirst(), obj4);
            } else {
                if (Long.compare(nextLong, last) > 0) {
                    nextLong2 = nextLong + i;
                } else {
                    nextLong2 = $this$nextLong.nextLong();
                }
            }
            return nextLong2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Cannot get random in empty range: ").append(range).toString());
        throw illegalArgumentException;
    }

    public static final int takeUpperBits(int $this$takeUpperBits, int bitCount) {
        return i2 &= i5;
    }
}
