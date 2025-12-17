package kotlin;

import java.io.Serializable;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0008\u0018\u0000*\u0006\u0008\u0000\u0010\u0001 \u0001*\u0006\u0008\u0001\u0010\u0002 \u0001*\u0006\u0008\u0002\u0010\u0003 \u00012\u00060\u0004j\u0002`\u0005B\u001d\u0012\u0006\u0010\u0006\u001a\u00028\u0000\u0012\u0006\u0010\u0007\u001a\u00028\u0001\u0012\u0006\u0010\u0008\u001a\u00028\u0002¢\u0006\u0002\u0010\tJ\u000e\u0010\u000f\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u0010\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u0011\u001a\u00028\u0002HÆ\u0003¢\u0006\u0002\u0010\u000bJ>\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00002\u0008\u0008\u0002\u0010\u0006\u001a\u00028\u00002\u0008\u0008\u0002\u0010\u0007\u001a\u00028\u00012\u0008\u0008\u0002\u0010\u0008\u001a\u00028\u0002HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0008\u0010\u001a\u001a\u00020\u001bH\u0016R\u0013\u0010\u0006\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u000c\u001a\u0004\u0008\n\u0010\u000bR\u0013\u0010\u0007\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\u000c\u001a\u0004\u0008\r\u0010\u000bR\u0013\u0010\u0008\u001a\u00028\u0002¢\u0006\n\n\u0002\u0010\u000c\u001a\u0004\u0008\u000e\u0010\u000b¨\u0006\u001c", d2 = {"Lkotlin/Triple;", "A", "B", "C", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "first", "second", "third", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "getFirst", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getSecond", "getThird", "component1", "component2", "component3", "copy", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Triple;", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
public final class t<A, B, C>  implements Serializable {

    private final A first;
    private final B second;
    private final C third;
    public t(A a, B b2, C c3) {
        super();
        this.first = a;
        this.second = b2;
        this.third = c3;
    }

    public final A a() {
        return this.first;
    }

    public final B b() {
        return this.second;
    }

    public final C c() {
        return this.third;
    }

    public final C d() {
        return this.third;
    }

    @Override // java.io.Serializable
    public boolean equals(Object object) {
        Object third;
        Object second;
        Object obj3;
        if (this != (t)object && object instanceof t && n.b(this.first, object.first) && n.b(this.second, object.second) && n.b(this.third, object.third)) {
            if (object instanceof t) {
                if (n.b(this.first, object.first)) {
                    if (n.b(this.second, object.second)) {
                        if (n.b(this.third, object.third)) {
                        }
                    }
                }
            }
            return 0;
        }
        return 1;
    }

    @Override // java.io.Serializable
    public int hashCode() {
        int i;
        int i2;
        int i3;
        Object first = this.first;
        i2 = 0;
        if (first != null) {
            i = first.hashCode();
        } else {
            i = i2;
        }
        Object second = this.second;
        if (second != null) {
            i3 = second.hashCode();
        } else {
            i3 = i2;
        }
        Object third = this.third;
        if (third != null) {
            i2 = third.hashCode();
        }
        return i6 += i2;
    }

    @Override // java.io.Serializable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('(');
        stringBuilder.append(this.first);
        String str = ", ";
        stringBuilder.append(str);
        stringBuilder.append(this.second);
        stringBuilder.append(str);
        stringBuilder.append(this.third);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
