package androidx.compose.runtime.internal;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0011\n\u0002\u0008\u0004\n\u0002\u0010\t\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0000\u0008\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007¢\u0006\u0002\u0010\u0008J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u000cH\u0002J\u0010\u0010\r\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000b\u001a\u00020\u000cJ\u0018\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u000c2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0001J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u000c2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0001R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u0012", d2 = {"Landroidx/compose/runtime/internal/ThreadMap;", "", "size", "", "keys", "", "values", "", "(I[J[Ljava/lang/Object;)V", "[Ljava/lang/Object;", "find", "key", "", "get", "newWith", "value", "trySet", "", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ThreadMap {

    public static final int $stable = 8;
    private final long[] keys;
    private final int size;
    private final Object[] values;
    static {
        final int i = 8;
    }

    public ThreadMap(int size, long[] keys, Object[] values) {
        super();
        this.size = size;
        this.keys = keys;
        this.values = values;
    }

    private final int find(long key) {
        int high;
        int low;
        int i;
        int i2;
        int cmp2;
        long l;
        int i3;
        int cmp;
        int cmp3;
        switch (high) {
            case -1:
                return -1;
            case 0:
                int i6 = 0;
                i = i6;
                i = -2;
                return i;
            default:
                low = 0;
                i5 >>>= 1;
                i3 = l - key;
                cmp = 0;
                low = i2 + 1;
                high = i2 + -1;
                return i2;
                return -mid;
        }
    }

    public final Object get(long key) {
        Object obj;
        final int find = find(key);
        obj = find >= 0 ? values[find] : 0;
        return obj;
    }

    public final androidx.compose.runtime.internal.ThreadMap newWith(long key, Object value) {
        int count$iv;
        int dest;
        int source;
        int i;
        int i3;
        Object obj;
        int cmp;
        int i2;
        final int size = this.size;
        Object[] values = this.values;
        int i4 = 0;
        count$iv = 0;
        source = 0;
        i = source;
        i3 = 1;
        while (i < values.length) {
            i2 = 0;
            if (values[i] != null) {
            } else {
            }
            i3 = source;
            if (i3 != 0) {
            }
            i++;
            i3 = 1;
            count$iv++;
        }
        count$iv += i3;
        long[] lArr = new long[count$iv2];
        Object[] arr = new Object[count$iv2];
        if (count$iv2 > i3) {
            dest = 0;
            source = 0;
            while (dest < count$iv2) {
                if (source < size) {
                    break;
                }
                i = this.keys[source];
                obj = this.values[source];
                if (Long.compare(i, key) > 0) {
                    break;
                } else {
                }
                if (obj != null) {
                }
                source++;
                lArr[dest] = i;
                arr[dest] = obj;
                dest++;
            }
            if (source == size) {
                lArr[count$iv2 + -1] = key;
                arr[count$iv2 + -1] = obj14;
            }
        } else {
            lArr[source] = key;
            arr[source] = obj14;
        }
        ThreadMap threadMap = new ThreadMap(count$iv2, lArr, arr);
        return threadMap;
    }

    public final boolean trySet(long key, Object value) {
        final int find = find(key);
        if (find < 0) {
            return 0;
        }
        this.values[find] = obj5;
        return 1;
    }
}
