package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.b;
import kotlin.b0.g;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.w;
import kotlinx.coroutines.j0;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u001aI\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001\"\u0004\u0008\u0000\u0010\u0004*\u0018\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u00020\u00030\u0001j\u0008\u0012\u0004\u0012\u0002H\u0004`\u00052\u0006\u0010\u0006\u001a\u0002H\u00042\u0006\u0010\u0007\u001a\u00020\u0008H\u0000¢\u0006\u0002\u0010\t\u001a=\u0010\n\u001a\u00020\u0003\"\u0004\u0008\u0000\u0010\u0004*\u0018\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u00020\u00030\u0001j\u0008\u0012\u0004\u0012\u0002H\u0004`\u00052\u0006\u0010\u0006\u001a\u0002H\u00042\u0006\u0010\u0007\u001a\u00020\u0008H\u0000¢\u0006\u0002\u0010\u000b\u001aC\u0010\u000c\u001a\u0004\u0018\u00010\r\"\u0004\u0008\u0000\u0010\u0004*\u0018\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u00020\u00030\u0001j\u0008\u0012\u0004\u0012\u0002H\u0004`\u00052\u0006\u0010\u0006\u001a\u0002H\u00042\n\u0008\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0000¢\u0006\u0002\u0010\u000f**\u0008\u0000\u0010\u0010\u001a\u0004\u0008\u0000\u0010\u0004\"\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u00020\u00030\u00012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u00020\u00030\u0001¨\u0006\u0011", d2 = {"bindCancellationFun", "Lkotlin/Function1;", "", "", "E", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "element", "context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;)Lkotlin/jvm/functions/Function1;", "callUndeliveredElement", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;)V", "callUndeliveredElementCatchingException", "Lkotlinx/coroutines/internal/UndeliveredElementException;", "undeliveredElementException", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Lkotlinx/coroutines/internal/UndeliveredElementException;)Lkotlinx/coroutines/internal/UndeliveredElementException;", "OnUndeliveredElement", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class u {

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n", d2 = {"<anonymous>", "", "E", "<anonymous parameter 0>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements l<Throwable, w> {

        final g $context;
        final E $element;
        final l<E, w> $this_bindCancellationFun;
        a(l<? super E, w> l, E e2, g g3) {
            this.$this_bindCancellationFun = l;
            this.$element = e2;
            this.$context = g3;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            invoke((Throwable)object);
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke(Throwable throwable) {
            u.b(this.$this_bindCancellationFun, this.$element, this.$context);
        }
    }
    public static final <E> l<Throwable, w> a(l<? super E, w> l, E e2, g g3) {
        u.a aVar = new u.a(l, e2, g3);
        return aVar;
    }

    public static final <E> void b(l<? super E, w> l, E e2, g g3) {
        final kotlinx.coroutines.internal.UndeliveredElementException obj1 = u.c(l, e2, 0);
        if (obj1 == null) {
        } else {
            j0.a(g3, obj1);
        }
    }

    public static final <E> kotlinx.coroutines.internal.UndeliveredElementException c(l<? super E, w> l, E e2, kotlinx.coroutines.internal.UndeliveredElementException undeliveredElementException3) {
        try {
            l.invoke(e2);
            Throwable str = undeliveredElementException3.getCause();
        }
        return undeliveredElementException3;
    }

    public static kotlinx.coroutines.internal.UndeliveredElementException d(l l, Object object2, kotlinx.coroutines.internal.UndeliveredElementException undeliveredElementException3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        return u.c(l, object2, obj2);
    }
}
