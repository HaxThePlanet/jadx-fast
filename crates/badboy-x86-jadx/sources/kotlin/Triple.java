package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0008\u0018\u0000*\u0006\u0008\u0000\u0010\u0001 \u0001*\u0006\u0008\u0001\u0010\u0002 \u0001*\u0006\u0008\u0002\u0010\u0003 \u00012\u00060\u0004j\u0002`\u0005B\u001d\u0012\u0006\u0010\u0006\u001a\u00028\u0000\u0012\u0006\u0010\u0007\u001a\u00028\u0001\u0012\u0006\u0010\u0008\u001a\u00028\u0002¢\u0006\u0002\u0010\tJ\u000e\u0010\u000f\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u0010\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u0011\u001a\u00028\u0002HÆ\u0003¢\u0006\u0002\u0010\u000bJ>\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00002\u0008\u0008\u0002\u0010\u0006\u001a\u00028\u00002\u0008\u0008\u0002\u0010\u0007\u001a\u00028\u00012\u0008\u0008\u0002\u0010\u0008\u001a\u00028\u0002HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0008\u0010\u001a\u001a\u00020\u001bH\u0016R\u0013\u0010\u0006\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u000c\u001a\u0004\u0008\n\u0010\u000bR\u0013\u0010\u0007\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\u000c\u001a\u0004\u0008\r\u0010\u000bR\u0013\u0010\u0008\u001a\u00028\u0002¢\u0006\n\n\u0002\u0010\u000c\u001a\u0004\u0008\u000e\u0010\u000b¨\u0006\u001c", d2 = {"Lkotlin/Triple;", "A", "B", "C", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "first", "second", "third", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "getFirst", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getSecond", "getThird", "component1", "component2", "component3", "copy", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Triple;", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class Triple<A, B, C>  implements Serializable {

    private final A first;
    private final B second;
    private final C third;
    public Triple(A first, B second, C third) {
        super();
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public static kotlin.Triple copy$default(kotlin.Triple triple, Object object2, Object object3, Object object4, int i5, Object object6) {
        Object obj1;
        Object obj2;
        Object obj3;
        if (i5 & 1 != 0) {
            obj1 = triple.first;
        }
        if (i5 & 2 != 0) {
            obj2 = triple.second;
        }
        if (i5 &= 4 != 0) {
            obj3 = triple.third;
        }
        return triple.copy(obj1, obj2, obj3);
    }

    public final A component1() {
        return this.first;
    }

    public final B component2() {
        return this.second;
    }

    public final C component3() {
        return this.third;
    }

    public final kotlin.Triple<A, B, C> copy(A a, B b2, C c3) {
        Triple triple = new Triple(a, b2, c3);
        return triple;
    }

    @Override // java.io.Serializable
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof Triple) {
            return i2;
        }
        Object obj = object;
        if (!Intrinsics.areEqual(this.first, obj.first)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.second, obj.second)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.third, obj.third)) {
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

    public final C getThird() {
        return this.third;
    }

    @Override // java.io.Serializable
    public int hashCode() {
        int i2;
        int i3;
        int i;
        i3 = 0;
        if (this.first == null) {
            i2 = i3;
        } else {
            i2 = this.first.hashCode();
        }
        if (this.second == null) {
            i = i3;
        } else {
            i = this.second.hashCode();
        }
        if (this.third == null) {
        } else {
            i3 = this.third.hashCode();
        }
        return i4 += i3;
    }

    @Override // java.io.Serializable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str = ", ";
        return stringBuilder.append('(').append(this.first).append(str).append(this.second).append(str).append(this.third).append(')').toString();
    }
}
