package kotlin.j0;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.j0.a;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010(\n\u0000\u0008\u0000\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B'\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u000f\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00028\u00000\tH\u0096\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n", d2 = {"Lkotlin/sequences/TakeWhileSequence;", "T", "Lkotlin/sequences/Sequence;", "sequence", "predicate", "Lkotlin/Function1;", "", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)V", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
public final class o<T>  implements kotlin.j0.h<T> {

    private final kotlin.j0.h<T> a;
    private final l<T, Boolean> b;

    @Metadata(d1 = "\u0000#\n\u0000\n\u0002\u0010(\n\u0002\u0008\n\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00028\u00000\u0001J\u0008\u0010\u0011\u001a\u00020\u0012H\u0002J\t\u0010\u0013\u001a\u00020\u0014H\u0096\u0002J\u000e\u0010\u0015\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0007R\u0017\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0003\u0010\u0004R\u001e\u0010\u0005\u001a\u0004\u0018\u00018\u0000X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\u0008\u0006\u0010\u0007\"\u0004\u0008\u0008\u0010\tR\u001a\u0010\u000b\u001a\u00020\u000cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\r\u0010\u000e\"\u0004\u0008\u000f\u0010\u0010¨\u0006\u0016", d2 = {"kotlin/sequences/TakeWhileSequence$iterator$1", "", "iterator", "getIterator", "()Ljava/util/Iterator;", "nextItem", "getNextItem", "()Ljava/lang/Object;", "setNextItem", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "nextState", "", "getNextState", "()I", "setNextState", "(I)V", "calcNext", "", "hasNext", "", "next", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public static final class a implements Iterator<T>, a {

        private final Iterator<T> a;
        private int b = -1;
        private T c;
        final kotlin.j0.o v;
        a(kotlin.j0.o o) {
            this.v = o;
            super();
            this.a = o.c(o).iterator();
            int obj1 = -1;
        }

        private final void c() {
            boolean next;
            boolean booleanValue;
            next = this.a.next();
            if (this.a.hasNext() && (Boolean)o.b(this.v).invoke(next).booleanValue()) {
                next = this.a.next();
                if ((Boolean)o.b(this.v).invoke(next).booleanValue()) {
                    this.b = 1;
                    this.c = next;
                }
            }
            this.b = 0;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i;
            if (this.b == -1) {
                c();
            }
            if (this.b == 1) {
            } else {
                i = 0;
            }
            return i;
        }

        public T next() {
            final int i3 = -1;
            if (this.b == i3) {
                c();
            }
            if (this.b == 0) {
            } else {
                this.c = 0;
                this.b = i3;
                return this.c;
            }
            NoSuchElementException noSuchElementException = new NoSuchElementException();
            throw noSuchElementException;
        }

        @Override // java.util.Iterator
        public void remove() {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
            throw unsupportedOperationException;
        }
    }
    public o(kotlin.j0.h<? extends T> h, l<? super T, Boolean> l2) {
        n.f(h, "sequence");
        n.f(l2, "predicate");
        super();
        this.a = h;
        this.b = l2;
    }

    public static final l b(kotlin.j0.o o) {
        return o.b;
    }

    public static final kotlin.j0.h c(kotlin.j0.o o) {
        return o.a;
    }

    public Iterator<T> iterator() {
        o.a aVar = new o.a(this);
        return aVar;
    }
}
