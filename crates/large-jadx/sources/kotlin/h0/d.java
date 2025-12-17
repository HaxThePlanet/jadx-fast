package kotlin.h0;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.c0.c;
import kotlin.d0.d.g;
import kotlin.d0.d.j0.a;
import kotlin.y.h0;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\u0008\n\u0002\u0008\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008\u0016\u0018\u0000 \u00172\u0008\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u001f\u0008\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\u0013\u0010\r\u001a\u00020\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\u0008\u0010\u0011\u001a\u00020\u0002H\u0016J\u0008\u0010\u0012\u001a\u00020\u000eH\u0016J\t\u0010\u0013\u001a\u00020\u0014H\u0096\u0002J\u0008\u0010\u0015\u001a\u00020\u0016H\u0016R\u0011\u0010\u0007\u001a\u00020\u0002¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\n\u001a\u00020\u0002¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0002¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\t¨\u0006\u0018", d2 = {"Lkotlin/ranges/IntProgression;", "", "", "start", "endInclusive", "step", "(III)V", "first", "getFirst", "()I", "last", "getLast", "getStep", "equals", "", "other", "", "hashCode", "isEmpty", "iterator", "Lkotlin/collections/IntIterator;", "toString", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
public class d implements Iterable<Integer>, a {

    public static final kotlin.h0.d.a v;
    private final int a;
    private final int b;
    private final int c;

    @Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0008\u001a\u00020\u0006¨\u0006\t", d2 = {"Lkotlin/ranges/IntProgression$Companion;", "", "()V", "fromClosedRange", "Lkotlin/ranges/IntProgression;", "rangeStart", "", "rangeEnd", "step", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public static final class a {
        public a(g g) {
            super();
        }

        public final kotlin.h0.d a(int i, int i2, int i3) {
            d dVar = new d(i, i2, i3);
            return dVar;
        }
    }
    static {
        d.a aVar = new d.a(0);
        d.v = aVar;
    }

    public d(int i, int i2, int i3) {
        super();
        if (i3 == 0) {
        } else {
            if (i3 == Integer.MIN_VALUE) {
            } else {
                this.a = i;
                this.b = c.b(i, i2, i3);
                this.c = i3;
            }
            IllegalArgumentException obj2 = new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
            throw obj2;
        }
        obj2 = new IllegalArgumentException("Step must be non-zero.");
        throw obj2;
    }

    @Override // java.lang.Iterable
    public final int d() {
        return this.a;
    }

    @Override // java.lang.Iterable
    public boolean equals(Object object) {
        boolean empty;
        int i;
        Object obj3;
        if (object instanceof d) {
            if (isEmpty()) {
                if (!(d)object.isEmpty()) {
                    if (this.a == object.a && this.b == object.b && this.c == object.c) {
                        if (this.b == object.b) {
                            obj3 = this.c == object.c ? 1 : 0;
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return obj3;
    }

    @Override // java.lang.Iterable
    public final int g() {
        return this.b;
    }

    @Override // java.lang.Iterable
    public final int h() {
        return this.c;
    }

    @Override // java.lang.Iterable
    public int hashCode() {
        int i2;
        int i;
        if (isEmpty()) {
            i2 = -1;
        } else {
            i6 += i;
        }
        return i2;
    }

    @Override // java.lang.Iterable
    public h0 i() {
        e eVar = new e(this.a, this.b, this.c);
        return eVar;
    }

    @Override // java.lang.Iterable
    public boolean isEmpty() {
        int i2;
        int i3;
        int i;
        i3 = 1;
        if (this.c > 0) {
            if (this.a > this.b) {
            } else {
                i3 = i5;
            }
        } else {
            if (this.a < this.b) {
            } else {
            }
        }
        return i3;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return i();
    }

    @Override // java.lang.Iterable
    public String toString() {
        StringBuilder stringBuilder;
        int i;
        int i2;
        String str = " step ";
        if (this.c > 0) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(this.a);
            stringBuilder.append("..");
            stringBuilder.append(this.b);
            stringBuilder.append(str);
            i = this.c;
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(this.a);
            stringBuilder.append(" downTo ");
            stringBuilder.append(this.b);
            stringBuilder.append(str);
            i = -i4;
        }
        stringBuilder.append(i);
        return stringBuilder.toString();
    }
}
