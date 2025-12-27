package f.c.c.b;

import com.google.common.base.n;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: Ints.java */
/* loaded from: classes2.dex */
public final class b extends c {

    private static class a extends AbstractList<Integer> implements RandomAccess, Serializable {

        private static final long serialVersionUID = 0L;
        final int[] array;
        final int end;
        final int start;
        a(int[] iArr, int i, int i2) {
            super();
            this.array = iArr;
            this.start = i;
            this.end = i2;
        }

        @Override // java.util.AbstractList
        public Integer b(int i) {
            n.m(i, size());
            return Integer.valueOf(this.array[this.start + i]);
        }

        @Override // java.util.AbstractList
        public boolean contains(Object object) {
            boolean z;
            int start2;
            int end2;
            boolean z2 = false;
            z = object instanceof Integer;
            if (object instanceof Integer) {
                object = b.h(this.array, object.intValue(), this.start, this.end) != -1 ? 1 : 0;
            }
            return (b.h(this.array, object.intValue(), this.start, this.end) != -1 ? 1 : 0);
        }

        @Override // java.util.AbstractList
        public Integer d(int i, Integer integer) {
            n.m(i, size());
            n.o(integer);
            this.array[start2 + i] = integer.intValue();
            return Integer.valueOf(array2[start2 + i]);
        }

        @Override // java.util.AbstractList
        public boolean equals(Object object) {
            int i;
            final boolean z = true;
            if (object == this) {
                return true;
            }
            if (object instanceof b.a) {
                int size = size();
                i = 0;
                if (object.size() != size) {
                    return false;
                }
                while (i < size) {
                    i4 = object.start + i;
                    if (this.array[this.start + i] != object.array[i4]) {
                        return false;
                    }
                }
                return true;
            }
            return super.equals(object);
        }

        @Override // java.util.AbstractList
        int[] g() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractList
        public int hashCode() {
            int start2;
            int i = 1;
            i = 1;
            while (this.start < this.end) {
                int i2 = this.array[start2];
                b.f(i2);
                i = (i * 31) + i2;
                start2 = start2 + 1;
            }
            return i;
        }

        @Override // java.util.AbstractList
        public int indexOf(Object object) {
            z = object instanceof Integer;
            if (object instanceof Integer) {
                int i = b.h(this.array, object.intValue(), this.start, this.end);
                if (i >= 0) {
                    return i - this.start;
                }
            }
            return -1;
        }

        @Override // java.util.AbstractList
        public int lastIndexOf(Object object) {
            z = object instanceof Integer;
            if (object instanceof Integer) {
                int i = b.i(this.array, object.intValue(), this.start, this.end);
                if (i >= 0) {
                    return i - this.start;
                }
            }
            return -1;
        }

        @Override // java.util.AbstractList
        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.AbstractList
        public List<Integer> subList(int i, int i2) {
            n.t(i, i2, size());
            if (i == i2) {
                return Collections.emptyList();
            }
            return new b.a(this.array, i + start2, start2 + i2);
        }

        @Override // java.util.AbstractList
        public String toString() {
            int start2;
            StringBuilder stringBuilder = new StringBuilder(size() * 5);
            stringBuilder.append('[');
            stringBuilder.append(this.array[this.start]);
            start2 = start2 + 1;
            while (this.array[this.start] < this.end) {
                stringBuilder.append(", ");
                stringBuilder.append(this.array[start2]);
                start2 = start2 + 1;
            }
            stringBuilder.append(']');
            return stringBuilder.toString();
        }

        @Override // java.util.AbstractList
        public boolean isEmpty() {
            return false;
        }
    }
    static /* synthetic */ int a(int[] iArr, int i, int i2, int i3) {
        return b.h(iArr, i, i2, i3);
    }

    static /* synthetic */ int b(int[] iArr, int i, int i2, int i3) {
        return b.i(iArr, i, i2, i3);
    }

    public static int c(long j) {
        int i = 1;
        long j2 = j;
        int r1 = j2 == j ? 1 : 0;
        n.j((j2 == j ? 1 : 0), "Out of range: %s", j);
        return (int)j;
    }

    public static int e(int i, int i2, int i3) {
        boolean z = true;
        int r0 = i2 <= i3 ? 1 : 0;
        n.i((i2 <= i3 ? 1 : 0), "min (%s) must be less than or equal to max (%s)", i2, i3);
        return Math.min(Math.max(i, i2), i3);
    }

    public static int g(int[] iArr, int i) {
        return b.h(iArr, i, 0, iArr.length);
    }

    private static int h(int[] iArr, int i, int i2, int i3) {
        while (i2 < i3) {
            if (iArr[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    private static int i(int[] iArr, int i, int i2, int i3) {
        int i5;
        i5 = i3 - 1;
        while (i5 >= i2) {
            if (iArr[i5] == i) {
                return i5;
            }
        }
        return -1;
    }

    public static int[] k(Collection<? extends Number> collection) {
        int i = 0;
        if (collection instanceof b.a) {
            return collection.g();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        final int[] iArr = new int[length];
        i = 0;
        while (i < collection instanceof b.a) {
            Object obj = array[i];
            n.o(obj);
            iArr[i] = obj.intValue();
            i = i + 1;
        }
        return iArr;
    }

    public static int d(int i, int i2) {
        int i3 = -1;
        if (i < i2) {
            i3 = -1;
        } else {
            i = i > i2 ? 1 : 0;
        }
        return (i > i2 ? 1 : 0);
    }

    public static int f(int i) {
        return i;
    }

    public static int j(long j) {
        if (j > 0x7fffffff /* Unknown resource */) {
            return 0x7fffffff /* Unknown resource */;
        }
        if (j < -2147483648) {
            return -2147483648;
        }
        return (int)j;
    }
}
