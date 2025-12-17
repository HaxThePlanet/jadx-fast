package kotlin.j0;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.j0.a;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\u0008\u0002\u0008\u0000\u0018\u0000*\u0004\u0008\u0000\u0010\u0001*\u0004\u0008\u0001\u0010\u0002*\u0004\u0008\u0002\u0010\u00032\u0008\u0012\u0004\u0012\u0002H\u00030\u0004BA\u0012\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0018\u0010\u0008\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00020\t0\u0007¢\u0006\u0002\u0010\nJ\u000f\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00028\u00020\tH\u0096\u0002R \u0010\u0008\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b", d2 = {"Lkotlin/sequences/FlatteningSequence;", "T", "R", "E", "Lkotlin/sequences/Sequence;", "sequence", "transformer", "Lkotlin/Function1;", "iterator", "", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
public final class f<T, R, E>  implements kotlin.j0.h<E> {

    private final kotlin.j0.h<T> a;
    private final l<T, R> b;
    private final l<R, Iterator<E>> c;

    @Metadata(d1 = "\u0000\u0015\n\u0000\n\u0002\u0010(\n\u0002\u0008\u0008\n\u0002\u0010\u000b\n\u0002\u0008\u0004*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00028\u00000\u0001J\u0008\u0010\t\u001a\u00020\nH\u0002J\t\u0010\u000b\u001a\u00020\nH\u0096\u0002J\u000e\u0010\u000c\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\rR\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0003\u0010\u0004\"\u0004\u0008\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0004¨\u0006\u000e", d2 = {"kotlin/sequences/FlatteningSequence$iterator$1", "", "itemIterator", "getItemIterator", "()Ljava/util/Iterator;", "setItemIterator", "(Ljava/util/Iterator;)V", "iterator", "getIterator", "ensureItemIterator", "", "hasNext", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public static final class a implements Iterator<E>, a {

        private final Iterator<T> a;
        private Iterator<? extends E> b;
        final kotlin.j0.f c;
        a(kotlin.j0.f f) {
            this.c = f;
            super();
            this.a = f.c(f).iterator();
        }

        private final boolean c() {
            Iterator invoke;
            int i;
            boolean next;
            l lVar;
            invoke = this.b;
            if (invoke != null && !invoke.hasNext()) {
                if (!invoke.hasNext()) {
                    this.b = 0;
                }
            }
            while (this.b == null) {
                invoke = f.b(this.c).invoke(f.d(this.c).invoke(this.a.next()));
            }
            return 1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return c();
        }

        public E next() {
            if (!c()) {
            } else {
                Iterator it = this.b;
                n.d(it);
                return it.next();
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
    public f(kotlin.j0.h<? extends T> h, l<? super T, ? extends R> l2, l<? super R, ? extends Iterator<? extends E>> l3) {
        n.f(h, "sequence");
        n.f(l2, "transformer");
        n.f(l3, "iterator");
        super();
        this.a = h;
        this.b = l2;
        this.c = l3;
    }

    public static final l b(kotlin.j0.f f) {
        return f.c;
    }

    public static final kotlin.j0.h c(kotlin.j0.f f) {
        return f.a;
    }

    public static final l d(kotlin.j0.f f) {
        return f.b;
    }

    public Iterator<E> iterator() {
        f.a aVar = new f.a(this);
        return aVar;
    }
}
