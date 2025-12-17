package kotlin.j0;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.j0.a;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010(\n\u0002\u0008\u0002\u0008\u0000\u0018\u0000*\u0004\u0008\u0000\u0010\u0001*\u0004\u0008\u0001\u0010\u00022\u0008\u0012\u0004\u0012\u0002H\u00020\u0003B'\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0002\u0010\u0007J3\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u0002H\t0\u0003\"\u0004\u0008\u0002\u0010\t2\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\t0\u000b0\u0006H\u0000¢\u0006\u0002\u0008\u000cJ\u000f\u0010\n\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u000bH\u0096\u0002R\u0014\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r", d2 = {"Lkotlin/sequences/TransformingSequence;", "T", "R", "Lkotlin/sequences/Sequence;", "sequence", "transformer", "Lkotlin/Function1;", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)V", "flatten", "E", "iterator", "", "flatten$kotlin_stdlib", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
public final class p<T, R>  implements kotlin.j0.h<R> {

    private final kotlin.j0.h<T> a;
    private final l<T, R> b;

    @Metadata(d1 = "\u0000\u0015\n\u0000\n\u0002\u0010(\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0003*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00028\u00000\u0001J\t\u0010\u0005\u001a\u00020\u0006H\u0096\u0002J\u000e\u0010\u0007\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0008R\u0017\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0003\u0010\u0004¨\u0006\t", d2 = {"kotlin/sequences/TransformingSequence$iterator$1", "", "iterator", "getIterator", "()Ljava/util/Iterator;", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public static final class a implements Iterator<R>, a {

        private final Iterator<T> a;
        final kotlin.j0.p b;
        a(kotlin.j0.p p) {
            this.b = p;
            super();
            this.a = p.b(p).iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a.hasNext();
        }

        public R next() {
            return p.c(this.b).invoke(this.a.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
            throw unsupportedOperationException;
        }
    }
    public p(kotlin.j0.h<? extends T> h, l<? super T, ? extends R> l2) {
        n.f(h, "sequence");
        n.f(l2, "transformer");
        super();
        this.a = h;
        this.b = l2;
    }

    public static final kotlin.j0.h b(kotlin.j0.p p) {
        return p.a;
    }

    public static final l c(kotlin.j0.p p) {
        return p.b;
    }

    public final <E> kotlin.j0.h<E> d(l<? super R, ? extends Iterator<? extends E>> l) {
        n.f(l, "iterator");
        f fVar = new f(this.a, this.b, l);
        return fVar;
    }

    public Iterator<R> iterator() {
        p.a aVar = new p.a(this);
        return aVar;
    }
}
