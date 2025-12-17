package androidx.collection;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0008\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003H\u0086\nJ\t\u0010\n\u001a\u00020\u0003H\u0086\nJ\u0013\u0010\u000b\u001a\u00020\u000c2\u0008\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0008\u0010\u000e\u001a\u00020\u000fH\u0016J\u0008\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0007¨\u0006\u0012", d2 = {"Landroidx/collection/LongLongPair;", "", "first", "", "second", "(JJ)V", "getFirst", "()J", "getSecond", "component1", "component2", "equals", "", "other", "hashCode", "", "toString", "", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LongLongPair {

    private final long first;
    private final long second;
    public LongLongPair(long first, long second) {
        super();
        this.first = first;
        this.second = obj3;
    }

    public final long component1() {
        final int i = 0;
        return getFirst();
    }

    public final long component2() {
        final int i = 0;
        return getSecond();
    }

    public boolean equals(Object other) {
        int cmp;
        int i;
        long second;
        long second2;
        if (!other instanceof LongLongPair) {
            return 0;
        }
        if (Long.compare(second, second2) == 0 && Long.compare(second, second2) == 0) {
            if (Long.compare(second, second2) == 0) {
                i = 1;
            }
        }
        return i;
    }

    public final long getFirst() {
        return this.first;
    }

    public final long getSecond() {
        return this.second;
    }

    public int hashCode() {
        return i ^= i3;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append('(').append(this.first).append(", ").append(this.second).append(')').toString();
    }
}
