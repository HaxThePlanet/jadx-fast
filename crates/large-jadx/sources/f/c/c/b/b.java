package f.c.c.b;

import com.google.common.base.n;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
public final class b extends f.c.c.b.c {

    private static class a extends AbstractList<Integer> implements RandomAccess, Serializable {

        private static final long serialVersionUID;
        final int[] array;
        final int end;
        final int start;
        a(int[] iArr, int i2, int i3) {
            super();
            this.array = iArr;
            this.start = i2;
            this.end = i3;
        }

        @Override // java.util.AbstractList
        public Integer b(int i) {
            n.m(i, size());
            return Integer.valueOf(this.array[start += i]);
        }

        @Override // java.util.AbstractList
        public boolean contains(Object object) {
            boolean z;
            int start;
            int end;
            Object obj4;
            if (object instanceof Integer && b.a(this.array, (Integer)object.intValue(), this.start, this.end) != -1) {
                obj4 = b.a(this.array, (Integer)object.intValue(), this.start, this.end) != -1 ? 1 : 0;
            } else {
            }
            return obj4;
        }

        @Override // java.util.AbstractList
        public Integer d(int i, Integer integer2) {
            n.m(i, size());
            int[] array = this.array;
            int start = this.start;
            n.o(integer2);
            array[start += i] = (Integer)integer2.intValue();
            return Integer.valueOf(array[start + i]);
        }

        @Override // java.util.AbstractList
        public boolean equals(Object object) {
            int i3;
            int i;
            int i2;
            int i4;
            final int i5 = 1;
            if (object == this) {
                return i5;
            }
            int size = size();
            final int i6 = 0;
            if (object instanceof b.a && (b.a)object.size() != size) {
                size = size();
                i6 = 0;
                if ((b.a)object.size() != size) {
                    return i6;
                }
                i3 = i6;
                while (i3 < size) {
                    i3++;
                }
                return i5;
            }
            return super.equals(object);
        }

        @Override // java.util.AbstractList
        int[] g() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractList
        public Object get(int i) {
            return b(i);
        }

        @Override // java.util.AbstractList
        public int hashCode() {
            int start;
            int i2;
            int i;
            start = this.start;
            i2 = 1;
            while (start < this.end) {
                i = this.array[start];
                b.f(i);
                i3 += i;
                start++;
            }
            return i2;
        }

        @Override // java.util.AbstractList
        public int indexOf(Object object) {
            boolean array;
            int start;
            int end;
            Object obj4;
            obj4 = b.a(this.array, (Integer)object.intValue(), this.start, this.end);
            if (object instanceof Integer && obj4 >= 0) {
                obj4 = b.a(this.array, (Integer)object.intValue(), this.start, this.end);
                if (obj4 >= 0) {
                    return obj4 -= start2;
                }
            }
            return -1;
        }

        @Override // java.util.AbstractList
        public boolean isEmpty() {
            return 0;
        }

        @Override // java.util.AbstractList
        public int lastIndexOf(Object object) {
            boolean array;
            int start;
            int end;
            Object obj4;
            obj4 = b.b(this.array, (Integer)object.intValue(), this.start, this.end);
            if (object instanceof Integer && obj4 >= 0) {
                obj4 = b.b(this.array, (Integer)object.intValue(), this.start, this.end);
                if (obj4 >= 0) {
                    return obj4 -= start2;
                }
            }
            return -1;
        }

        @Override // java.util.AbstractList
        public Object set(int i, Object object2) {
            return d(i, (Integer)object2);
        }

        @Override // java.util.AbstractList
        public int size() {
            return end -= start;
        }

        public List<Integer> subList(int i, int i2) {
            n.t(i, i2, size());
            if (i == i2) {
                return Collections.emptyList();
            }
            int start = this.start;
            b.a aVar = new b.a(this.array, i += start, start += i2);
            return aVar;
        }

        @Override // java.util.AbstractList
        public String toString() {
            int start2;
            int start;
            StringBuilder stringBuilder = new StringBuilder(size *= 5);
            stringBuilder.append('[');
            stringBuilder.append(this.array[this.start]);
            start2 = this.start;
            start2++;
            while (start2 < this.end) {
                stringBuilder.append(", ");
                stringBuilder.append(this.array[start2]);
                start2++;
            }
            stringBuilder.append(']');
            return stringBuilder.toString();
        }
    }
    static int a(int[] iArr, int i2, int i3, int i4) {
        return b.h(iArr, i2, i3, i4);
    }

    static int b(int[] iArr, int i2, int i3, int i4) {
        return b.i(iArr, i2, i3, i4);
    }

    public static int c(long l) {
        int i;
        final int i2 = (int)l;
        i = Long.compare(l2, l) == 0 ? 1 : 0;
        n.j(i, "Out of range: %s", l);
        return i2;
    }

    public static int d(int i, int i2) {
        int obj0;
        obj0 = i < i2 ? -1 : i > i2 ? 1 : 0;
        return obj0;
    }

    public static int e(int i, int i2, int i3) {
        int i4;
        i4 = i2 <= i3 ? 1 : 0;
        n.i(i4, "min (%s) must be less than or equal to max (%s)", i2, i3);
        return Math.min(Math.max(i, i2), i3);
    }

    public static int f(int i) {
        return i;
    }

    public static int g(int[] iArr, int i2) {
        return b.h(iArr, i2, 0, iArr.length);
    }

    private static int h(int[] iArr, int i2, int i3, int i4) {
        while (i3 < i4) {
            i3++;
        }
        return -1;
    }

    private static int i(int[] iArr, int i2, int i3, int i4) {
        int i;
        int obj4;
        i4--;
        while (obj4 >= i3) {
            obj4--;
        }
        return -1;
    }

    public static int j(long l) {
        if (Long.compare(l, i) > 0) {
            return Integer.MAX_VALUE;
        }
        if (Long.compare(l, i2) < 0) {
            return Integer.MIN_VALUE;
        }
        return (int)l;
    }

    public static int[] k(Collection<? extends Number> collection) {
        int i;
        int intValue;
        if (collection instanceof b.a) {
            return (b.a)collection.g();
        }
        Object[] obj4 = collection.toArray();
        int length = obj4.length;
        final int[] iArr = new int[length];
        i = 0;
        while (i < length) {
            Object obj = obj4[i];
            n.o(obj);
            iArr[i] = (Number)obj.intValue();
            i++;
        }
        return iArr;
    }
}
