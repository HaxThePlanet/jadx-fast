package kotlin.random;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.internal.PlatformImplementations;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\u0008\u0005\n\u0002\u0010\u0006\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0002\u0008'\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0008\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J$\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u0004H\u0016J\u0010\u0010\u0008\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0004H\u0016J\u0008\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0008\u0010\u0012\u001a\u00020\u0013H\u0016J\u0008\u0010\u0014\u001a\u00020\u0004H\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J\u0008\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u0016H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u0016H\u0016¨\u0006\u0018", d2 = {"Lkotlin/random/Random;", "", "()V", "nextBits", "", "bitCount", "nextBoolean", "", "nextBytes", "", "array", "fromIndex", "toIndex", "size", "nextDouble", "", "until", "from", "nextFloat", "", "nextInt", "nextLong", "", "Default", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class Random {

    public static final kotlin.random.Random.Default Default;
    private static final kotlin.random.Random defaultRandom;

    @Metadata(d1 = "\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\u0008\u0005\n\u0002\u0010\u0006\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0001\u001cB\u0007\u0008\u0002¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\u0007H\u0016J\u0008\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000cH\u0016J \u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000c2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J\u0008\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0008\u0010\u0015\u001a\u00020\u0016H\u0016J\u0008\u0010\u0017\u001a\u00020\u0007H\u0016J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0016J\u0018\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0016J\u0008\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u0019H\u0016J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u0019H\u0016J\u0008\u0010\u001a\u001a\u00020\u001bH\u0002R\u000e\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d", d2 = {"Lkotlin/random/Random$Default;", "Lkotlin/random/Random;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "()V", "defaultRandom", "nextBits", "", "bitCount", "nextBoolean", "", "nextBytes", "", "array", "fromIndex", "toIndex", "size", "nextDouble", "", "until", "from", "nextFloat", "", "nextInt", "nextLong", "", "writeReplace", "", "Serialized", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Default extends kotlin.random.Random implements Serializable {
        public Default(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        private final Object writeReplace() {
            return Random.Default.Serialized.INSTANCE;
        }

        @Override // kotlin.random.Random
        public int nextBits(int bitCount) {
            return Random.access$getDefaultRandom$cp().nextBits(bitCount);
        }

        @Override // kotlin.random.Random
        public boolean nextBoolean() {
            return Random.access$getDefaultRandom$cp().nextBoolean();
        }

        @Override // kotlin.random.Random
        public byte[] nextBytes(int size) {
            return Random.access$getDefaultRandom$cp().nextBytes(size);
        }

        @Override // kotlin.random.Random
        public byte[] nextBytes(byte[] array) {
            Intrinsics.checkNotNullParameter(array, "array");
            return Random.access$getDefaultRandom$cp().nextBytes(array);
        }

        @Override // kotlin.random.Random
        public byte[] nextBytes(byte[] array, int fromIndex, int toIndex) {
            Intrinsics.checkNotNullParameter(array, "array");
            return Random.access$getDefaultRandom$cp().nextBytes(array, fromIndex, toIndex);
        }

        @Override // kotlin.random.Random
        public double nextDouble() {
            return Random.access$getDefaultRandom$cp().nextDouble();
        }

        @Override // kotlin.random.Random
        public double nextDouble(double until) {
            return Random.access$getDefaultRandom$cp().nextDouble(until);
        }

        @Override // kotlin.random.Random
        public double nextDouble(double from, double until) {
            return Random.access$getDefaultRandom$cp().nextDouble(from, until);
        }

        @Override // kotlin.random.Random
        public float nextFloat() {
            return Random.access$getDefaultRandom$cp().nextFloat();
        }

        @Override // kotlin.random.Random
        public int nextInt() {
            return Random.access$getDefaultRandom$cp().nextInt();
        }

        @Override // kotlin.random.Random
        public int nextInt(int until) {
            return Random.access$getDefaultRandom$cp().nextInt(until);
        }

        @Override // kotlin.random.Random
        public int nextInt(int from, int until) {
            return Random.access$getDefaultRandom$cp().nextInt(from, until);
        }

        @Override // kotlin.random.Random
        public long nextLong() {
            return Random.access$getDefaultRandom$cp().nextLong();
        }

        @Override // kotlin.random.Random
        public long nextLong(long until) {
            return Random.access$getDefaultRandom$cp().nextLong(until);
        }

        @Override // kotlin.random.Random
        public long nextLong(long from, long until) {
            return Random.access$getDefaultRandom$cp().nextLong(from, until);
        }
    }
    static {
        Random.Default obj = new Random.Default(0);
        Random.Default = obj;
        Random.defaultRandom = PlatformImplementationsKt.IMPLEMENTATIONS.defaultPlatformRandom();
    }

    public static final kotlin.random.Random access$getDefaultRandom$cp() {
        return Random.defaultRandom;
    }

    public static byte[] nextBytes$default(kotlin.random.Random random, byte[] b2Arr2, int i3, int i4, int i5, Object object6) {
        int obj2;
        int obj3;
        if (object6 != null) {
        } else {
            if (i5 & 2 != 0) {
                obj2 = 0;
            }
            if (i5 &= 4 != 0) {
                obj3 = b2Arr2.length;
            }
            return random.nextBytes(b2Arr2, obj2, obj3);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: nextBytes");
        throw obj0;
    }

    public abstract int nextBits(int i);

    public boolean nextBoolean() {
        int i;
        if (nextBits(1) != 0) {
        } else {
            i = 0;
        }
        return i;
    }

    public byte[] nextBytes(int size) {
        return nextBytes(new byte[size]);
    }

    public byte[] nextBytes(byte[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return nextBytes(array, 0, array.length);
    }

    public byte[] nextBytes(byte[] array, int fromIndex, int toIndex) {
        int i4;
        int i2;
        int length;
        int length2;
        int i;
        int position;
        String str;
        int i6;
        int i3;
        int nextInt;
        int i5;
        byte b;
        Intrinsics.checkNotNullParameter(array, "array");
        i4 = 1;
        i2 = 0;
        if (fromIndex >= 0 && fromIndex <= array.length) {
            length2 = fromIndex <= array.length ? i4 : i2;
        } else {
        }
        if (length2 != 0) {
            if (toIndex >= 0 && toIndex <= array.length) {
                length2 = toIndex <= array.length ? i4 : i2;
            } else {
            }
            i = length2 != 0 ? i4 : i2;
        } else {
        }
        str = "fromIndex (";
        if (i == 0) {
        } else {
            if (fromIndex <= toIndex) {
            } else {
                i4 = i2;
            }
            if (i4 == 0) {
            } else {
                int i12 = 0;
                position = fromIndex;
                while (i2 < i8 /= 4) {
                    str = i2;
                    i6 = 0;
                    nextInt = nextInt();
                    array[position] = (byte)nextInt;
                    array[position + 1] = (byte)i18;
                    array[position + 2] = (byte)i19;
                    array[position + 3] = (byte)i20;
                    position += 4;
                    i2++;
                }
                int i10 = toIndex - position;
                i3 = 0;
                while (i3 < i10) {
                    array[position + i3] = (byte)i15;
                    i3++;
                }
                return array;
            }
            int steps = 0;
            StringBuilder stringBuilder2 = new StringBuilder();
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(stringBuilder2.append(str).append(fromIndex).append(") must be not greater than toIndex (").append(toIndex).append(").").toString().toString());
            throw illegalArgumentException2;
        }
        int i7 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append(str).append(fromIndex).append(") or toIndex (").append(toIndex).append(") are out of range: 0..").append(array.length).append('.').toString().toString());
        throw illegalArgumentException;
    }

    public double nextDouble() {
        return PlatformRandomKt.doubleFromParts(nextBits(26), nextBits(27));
    }

    public double nextDouble(double until) {
        return nextDouble(0, obj1);
    }

    public double nextDouble(double from, double until) {
        boolean infinite;
        int infinite2;
        int i2;
        double nextAfter;
        int i;
        int i3;
        int i4;
        int i5;
        RandomKt.checkRangeBounds(from, until);
        final int i6 = obj11 - from;
        if (Double.isInfinite(i6)) {
            i3 = 0;
            if (!Double.isInfinite(from) && !Double.isNaN(from)) {
                infinite2 = !Double.isNaN(from) ? i : i3;
            } else {
            }
            if (infinite2 != 0) {
                if (!Double.isInfinite(obj11) && !Double.isNaN(obj11)) {
                    if (!Double.isNaN(obj11)) {
                    } else {
                        i = i3;
                    }
                } else {
                }
                if (i != 0) {
                    double d = (double)i7;
                    nextDouble *= i5;
                    i9 += i2;
                } else {
                    i4 = from + i2;
                }
            } else {
            }
        } else {
        }
        if (Double.compare(i4, obj11) >= 0) {
            nextAfter = Math.nextAfter(obj11, obj12);
        } else {
            nextAfter = i4;
        }
        return nextAfter;
    }

    public float nextFloat() {
        return f /= i3;
    }

    public int nextInt() {
        return nextBits(32);
    }

    public int nextInt(int until) {
        return nextInt(0, until);
    }

    public int nextInt(int from, int until) {
        int bitCount;
        int nextInt;
        int v;
        int i;
        int i2;
        int i3;
        RandomKt.checkRangeBounds(from, until);
        final int i4 = until - from;
        int i5 = 1;
        if (i4 <= 0 && i4 == Integer.MIN_VALUE) {
            if (i4 == Integer.MIN_VALUE) {
            }
            return nextInt;
        }
        if (rnd &= i4 == i4) {
            bitCount = nextBits(RandomKt.fastLog2(i4));
        } else {
            v = 0;
            nextInt2 >>>= i5;
            v = i % i4;
            while (i7 += i3 >= 0) {
                nextInt2 >>>= i5;
                v = i % i4;
            }
            bitCount = v;
        }
        return from + bitCount;
    }

    public long nextLong() {
        return i += l2;
    }

    public long nextLong(long until) {
        return nextLong(0, obj1);
    }

    public long nextLong(long from, long until) {
        int nextLong;
        int i3;
        int nextInt;
        int cmp;
        int cmp2;
        int nextBits;
        int i;
        int rnd;
        long l2;
        long l;
        int i2;
        final Object obj = this;
        RandomKt.checkRangeBounds(from, until);
        final int i4 = obj20 - from;
        nextLong = 0;
        nextBits = 1;
        if (Long.compare(i4, nextLong) > 0) {
            int i7 = 0;
            if (Long.compare(i9, i4) == 0) {
                i3 = (int)i4;
                int i6 = 32;
                cmp2 = (int)i10;
                long l3 = 4294967295L;
                if (i3 != 0) {
                    l3 &= l2;
                } else {
                    if (cmp2 == nextBits) {
                        l3 &= l2;
                    } else {
                        i11 += l2;
                    }
                }
            } else {
                rnd = 0;
                nextLong2 >>>= nextBits;
                rnd = l2 % i4;
                while (Long.compare(l, nextLong) >= 0) {
                    nextLong2 >>>= nextBits;
                    rnd = l2 % i4;
                }
                i3 = rnd;
            }
            return from + rnd;
        }
        nextLong = obj.nextLong();
        i = 0;
        do {
            nextLong = obj.nextLong();
            i = 0;
            if (i == 0) {
            }
            if (Long.compare(nextLong, obj20) < 0) {
            }
            i = nextBits;
        } while (Long.compare(from, nextLong) <= 0);
        return nextLong;
    }
}
