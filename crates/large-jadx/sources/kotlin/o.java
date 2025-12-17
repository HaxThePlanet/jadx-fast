package kotlin;

import java.io.Serializable;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0008\u0018\u0000*\u0006\u0008\u0000\u0010\u0001 \u0001*\u0006\u0008\u0001\u0010\u0002 \u00012\u00060\u0003j\u0002`\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\u0006\u0010\u0006\u001a\u00028\u0001¢\u0006\u0002\u0010\u0007J\u000e\u0010\u000c\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\tJ\u000e\u0010\r\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\tJ.\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0008\u0008\u0002\u0010\u0005\u001a\u00028\u00002\u0008\u0008\u0002\u0010\u0006\u001a\u00028\u0001HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0008\u0010\u0016\u001a\u00020\u0017H\u0016R\u0013\u0010\u0005\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\n\u001a\u0004\u0008\u0008\u0010\tR\u0013\u0010\u0006\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\n\u001a\u0004\u0008\u000b\u0010\t¨\u0006\u0018", d2 = {"Lkotlin/Pair;", "A", "B", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "first", "second", "(Ljava/lang/Object;Ljava/lang/Object;)V", "getFirst", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getSecond", "component1", "component2", "copy", "(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
public final class o<A, B>  implements Serializable {

    private final A first;
    private final B second;
    public o(A a, B b2) {
        super();
        this.first = a;
        this.second = b2;
    }

    public final A a() {
        return this.first;
    }

    public final B b() {
        return this.second;
    }

    public final A c() {
        return this.first;
    }

    public final B d() {
        return this.second;
    }

    @Override // java.io.Serializable
    public boolean equals(Object object) {
        boolean second;
        Object first;
        Object obj3;
        if (this != (o)object && object instanceof o && n.b(this.first, object.first) && n.b(this.second, object.second)) {
            if (object instanceof o) {
                if (n.b(this.first, object.first)) {
                    if (n.b(this.second, object.second)) {
                    }
                }
            }
            return 0;
        }
        return 1;
    }

    @Override // java.io.Serializable
    public int hashCode() {
        int i2;
        int i;
        Object first = this.first;
        if (first != null) {
            i2 = first.hashCode();
        } else {
            i2 = i;
        }
        final Object second = this.second;
        if (second != null) {
            i = second.hashCode();
        }
        return i3 += i;
    }

    @Override // java.io.Serializable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('(');
        stringBuilder.append(this.first);
        stringBuilder.append(", ");
        stringBuilder.append(this.second);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
