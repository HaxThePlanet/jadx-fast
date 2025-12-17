package kotlin.j0;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.y.i;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0006\n\u0002\u0010\u0011\n\u0002\u0008\u0005\n\u0002\u0010\u001c\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\u001a.\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u0014\u0008\u0004\u0010\u0003\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\u00050\u0004H\u0087\u0008ø\u0001\u0000\u001a\u0012\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002\u001ab\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u0002H\u00080\u0001\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\t\"\u0004\u0008\u0002\u0010\u00082\u000c\u0010\n\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u00012\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\t0\u000c2\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u0002H\t\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00080\u00050\u000eH\u0000\u001a&\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0008\u0008\u0000\u0010\u0002*\u00020\u00102\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0004\u001a<\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0008\u0008\u0000\u0010\u0002*\u00020\u00102\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u00042\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u000e\u001a=\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0008\u0008\u0000\u0010\u0002*\u00020\u00102\u0008\u0010\u0013\u001a\u0004\u0018\u0001H\u00022\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u000eH\u0007¢\u0006\u0002\u0010\u0014\u001a+\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u0012\u0010\u0016\u001a\n\u0012\u0006\u0008\u0001\u0012\u0002H\u00020\u0017\"\u0002H\u0002¢\u0006\u0002\u0010\u0018\u001a\u001c\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u0005\u001a\u001c\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\u001aC\u0010\u001b\u001a\u0008\u0012\u0004\u0012\u0002H\u00080\u0001\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0008*\u0008\u0012\u0004\u0012\u0002H\u00020\u00012\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00080\u00050\u000eH\u0002¢\u0006\u0002\u0008\u001c\u001a)\u0010\u001b\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\u001d0\u0001H\u0007¢\u0006\u0002\u0008\u001e\u001a\"\u0010\u001b\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\u00010\u0001\u001a2\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010 \u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\u00010\u0004H\u0007\u001a!\u0010!\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001H\u0087\u0008\u001a\u001e\u0010\"\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u0001H\u0007\u001a&\u0010\"\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010#\u001a\u00020$H\u0007\u001a@\u0010%\u001a\u001a\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020'\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00080'0&\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0008*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00080&0\u0001\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006(", d2 = {"Sequence", "Lkotlin/sequences/Sequence;", "T", "iterator", "Lkotlin/Function0;", "", "emptySequence", "flatMapIndexed", "R", "C", "source", "transform", "Lkotlin/Function2;", "", "Lkotlin/Function1;", "generateSequence", "", "nextFunction", "seedFunction", "seed", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;", "sequenceOf", "elements", "", "([Ljava/lang/Object;)Lkotlin/sequences/Sequence;", "asSequence", "constrainOnce", "flatten", "flatten$SequencesKt__SequencesKt", "", "flattenSequenceOfIterable", "ifEmpty", "defaultValue", "orEmpty", "shuffled", "random", "Lkotlin/random/Random;", "unzip", "Lkotlin/Pair;", "", "kotlin-stdlib"}, k = 5, mv = {1, 5, 1}, xi = 1, xs = "kotlin/sequences/SequencesKt")
class l extends kotlin.j0.k {

    @Metadata(d1 = "\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0003H\u0096\u0002¨\u0006\u0004¸\u0006\u0000", d2 = {"kotlin/sequences/SequencesKt__SequencesKt$Sequence$1", "Lkotlin/sequences/Sequence;", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public static final class a implements kotlin.j0.h<T> {

        final Iterator a;
        public a(Iterator iterator) {
            this.a = iterator;
            super();
        }

        public Iterator<T> iterator() {
            return this.a;
        }
    }

    @Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0010(\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0004H\n¢\u0006\u0002\u0008\u0005", d2 = {"<anonymous>", "", "T", "it", "Lkotlin/sequences/Sequence;", "invoke"}, k = 3, mv = {1, 5, 1})
    static final class b extends p implements l<kotlin.j0.h<? extends T>, Iterator<? extends T>> {

        public static final kotlin.j0.l.b a;
        static {
            l.b bVar = new l.b();
            l.b.a = bVar;
        }

        b() {
            super(1);
        }

        public final Iterator<T> a(kotlin.j0.h<? extends T> h) {
            n.f(h, "it");
            return h.iterator();
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((h)object);
        }
    }

    @Metadata(d1 = "\u0000\u0004\n\u0002\u0008\u0006\u0010\u0000\u001a\u0002H\u0001\"\u0004\u0008\u0000\u0010\u0001\"\u0004\u0008\u0001\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0001H\n¢\u0006\u0004\u0008\u0004\u0010\u0005", d2 = {"<anonymous>", "T", "R", "it", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 5, 1})
    static final class c extends p implements l<T, T> {

        public static final kotlin.j0.l.c a;
        static {
            l.c cVar = new l.c();
            l.c.a = cVar;
        }

        c() {
            super(1);
        }

        public final T invoke(T t) {
            return t;
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0008\u0008\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u0002H\u0001H\n¢\u0006\u0004\u0008\u0004\u0010\u0005", d2 = {"<anonymous>", "T", "", "it", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 5, 1})
    static final class d extends p implements l<T, T> {

        final a $nextFunction;
        d(a a) {
            this.$nextFunction = a;
            super(1);
        }

        public final T invoke(T t) {
            n.f(t, "it");
            return this.$nextFunction.invoke();
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0008\u0008\u0000\u0010\u0001*\u00020\u0002H\n¢\u0006\u0004\u0008\u0003\u0010\u0004", d2 = {"<anonymous>", "T", "", "invoke", "()Ljava/lang/Object;"}, k = 3, mv = {1, 5, 1})
    static final class e extends p implements a<T> {

        final Object $seed;
        e(Object object) {
            this.$seed = object;
            super(0);
        }

        public final T invoke() {
            return this.$seed;
        }
    }
    public static <T> kotlin.j0.h<T> a(Iterator<? extends T> iterator) {
        n.f(iterator, "$this$asSequence");
        l.a aVar = new l.a(iterator);
        return l.b(aVar);
    }

    public static final <T> kotlin.j0.h<T> b(kotlin.j0.h<? extends T> h) {
        boolean aVar;
        Object obj1;
        n.f(h, "$this$constrainOnce");
        if (h instanceof a) {
        } else {
            aVar = new a(h);
            obj1 = aVar;
        }
        return obj1;
    }

    public static <T> kotlin.j0.h<T> c() {
        return d.a;
    }

    public static final <T> kotlin.j0.h<T> d(kotlin.j0.h<? extends kotlin.j0.h<? extends T>> h) {
        n.f(h, "$this$flatten");
        return l.e(h, l.b.a);
    }

    private static final <T, R> kotlin.j0.h<R> e(kotlin.j0.h<? extends T> h, l<? super T, ? extends Iterator<? extends R>> l2) {
        if (h instanceof p) {
            return (p)h.d(l2);
        }
        f fVar = new f(h, l.c.a, l2);
        return fVar;
    }

    public static <T> kotlin.j0.h<T> f(T t, l<? super T, ? extends T> l2) {
        Object gVar;
        kotlin.j0.l.e eVar;
        Object obj2;
        n.f(l2, "nextFunction");
        if (t == null) {
            obj2 = d.a;
        } else {
            eVar = new l.e(t);
            gVar = new g(eVar, l2);
            obj2 = gVar;
        }
        return obj2;
    }

    public static <T> kotlin.j0.h<T> g(a<? extends T> a) {
        n.f(a, "nextFunction");
        l.d dVar = new l.d(a);
        g gVar = new g(a, dVar);
        return l.b(gVar);
    }

    public static final <T> kotlin.j0.h<T> h(T... tArr) {
        int i;
        kotlin.j0.h obj1;
        n.f(tArr, "elements");
        i = tArr.length == 0 ? 1 : 0;
        if (i != 0) {
            obj1 = i.c();
        } else {
            obj1 = i.r(tArr);
        }
        return obj1;
    }
}
