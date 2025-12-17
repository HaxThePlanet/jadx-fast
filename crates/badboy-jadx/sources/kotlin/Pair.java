package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0008\u0018\u0000*\u0006\u0008\u0000\u0010\u0001 \u0001*\u0006\u0008\u0001\u0010\u0002 \u00012\u00060\u0003j\u0002`\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\u0006\u0010\u0006\u001a\u00028\u0001¢\u0006\u0002\u0010\u0007J\u000e\u0010\u000c\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\tJ\u000e\u0010\r\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\tJ.\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0008\u0008\u0002\u0010\u0005\u001a\u00028\u00002\u0008\u0008\u0002\u0010\u0006\u001a\u00028\u0001HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0008\u0010\u0016\u001a\u00020\u0017H\u0016R\u0013\u0010\u0005\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\n\u001a\u0004\u0008\u0008\u0010\tR\u0013\u0010\u0006\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\n\u001a\u0004\u0008\u000b\u0010\t¨\u0006\u0018", d2 = {"Lkotlin/Pair;", "A", "B", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "first", "second", "(Ljava/lang/Object;Ljava/lang/Object;)V", "getFirst", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getSecond", "component1", "component2", "copy", "(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class Pair<A, B>  implements Serializable {

    private final A first;
    private final B second;
    public Pair(A first, B second) {
        super();
        this.first = first;
        this.second = second;
    }

    public static kotlin.Pair copy$default(kotlin.Pair pair, Object object2, Object object3, int i4, Object object5) {
        Object obj1;
        Object obj2;
        if (i4 & 1 != 0) {
            obj1 = pair.first;
        }
        if (i4 &= 2 != 0) {
            obj2 = pair.second;
        }
        return pair.copy(obj1, obj2);
    }

    public final A component1() {
        return this.first;
    }

    public final B component2() {
        return this.second;
    }

    public final kotlin.Pair<A, B> copy(A a, B b2) {
        Pair pair = new Pair(a, b2);
        return pair;
    }

    @Override // java.io.Serializable
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof Pair) {
            return i2;
        }
        Object obj = object;
        if (!Intrinsics.areEqual(this.first, obj.first)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.second, obj.second)) {
            return i2;
        }
        return i;
    }

    public final A getFirst() {
        return this.first;
    }

    public final B getSecond() {
        return this.second;
    }

    @Override // java.io.Serializable
    public int hashCode() {
        int i;
        int i2;
        if (this.first == null) {
            i = i2;
        } else {
            i = this.first.hashCode();
        }
        if (this.second == null) {
        } else {
            i2 = this.second.hashCode();
        }
        return i3 += i2;
    }

    @Override // java.io.Serializable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append('(').append(this.first).append(", ").append(this.second).append(')').toString();
    }
}
