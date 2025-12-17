package kotlin.j0;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.d0.d.j0.a;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010(\n\u0002\u0008\u0002\u0008\u0000\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\u0008\u0012\u0004\u0012\u0002H\u00010\u0003B\u001b\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u000f\u0010\n\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u000bH\u0096\u0002J\u0016\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\t\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r", d2 = {"Lkotlin/sequences/DropSequence;", "T", "Lkotlin/sequences/Sequence;", "Lkotlin/sequences/DropTakeSequence;", "sequence", "count", "", "(Lkotlin/sequences/Sequence;I)V", "drop", "n", "iterator", "", "take", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
public final class b<T>  implements kotlin.j0.h<T>, kotlin.j0.c<T> {

    private final kotlin.j0.h<T> a;
    private final int b;

    @Metadata(d1 = "\u0000#\n\u0000\n\u0002\u0010(\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00028\u00000\u0001J\u0008\u0010\u000b\u001a\u00020\u000cH\u0002J\t\u0010\r\u001a\u00020\u000eH\u0096\u0002J\u000e\u0010\u000f\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0010R\u0017\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0003\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008\"\u0004\u0008\t\u0010\n¨\u0006\u0011", d2 = {"kotlin/sequences/DropSequence$iterator$1", "", "iterator", "getIterator", "()Ljava/util/Iterator;", "left", "", "getLeft", "()I", "setLeft", "(I)V", "drop", "", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public static final class a implements Iterator<T>, a {

        private final Iterator<T> a;
        private int b;
        a(kotlin.j0.b b) {
            super();
            this.a = b.c(b).iterator();
            this.b = b.b(b);
        }

        private final void c() {
            int next;
            while (this.b > 0) {
                if (this.a.hasNext()) {
                }
                this.a.next();
                this.b = i--;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            c();
            return this.a.hasNext();
        }

        public T next() {
            c();
            return this.a.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
            throw unsupportedOperationException;
        }
    }
    public b(kotlin.j0.h<? extends T> h, int i2) {
        int obj2;
        n.f(h, "sequence");
        super();
        this.a = h;
        this.b = i2;
        obj2 = i2 >= 0 ? 1 : 0;
        if (obj2 == null) {
        } else {
        }
        obj2 = new StringBuilder();
        obj2.append("count must be non-negative, but was ");
        obj2.append(i2);
        obj2.append('.');
        IllegalArgumentException obj3 = new IllegalArgumentException(obj2.toString().toString());
        throw obj3;
    }

    public static final int b(kotlin.j0.b b) {
        return b.b;
    }

    public static final kotlin.j0.h c(kotlin.j0.b b) {
        return b.a;
    }

    public kotlin.j0.h<T> a(int i) {
        kotlin.j0.b bVar;
        kotlin.j0.h hVar;
        int obj3;
        i2 += i;
        if (i3 < 0) {
            bVar = new b(this, i);
        } else {
            obj3 = new b(this.a, i3);
            bVar = obj3;
        }
        return bVar;
    }

    public Iterator<T> iterator() {
        b.a aVar = new b.a(this);
        return aVar;
    }
}
