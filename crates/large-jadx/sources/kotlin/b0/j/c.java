package kotlin.b0.j;

import java.util.Objects;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.g;
import kotlin.b0.h;
import kotlin.b0.k.a.a;
import kotlin.b0.k.a.d;
import kotlin.b0.k.a.h;
import kotlin.b0.k.a.j;
import kotlin.d0.c.l;
import kotlin.d0.c.p;
import kotlin.d0.d.g0;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.w;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001aF\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\u0008\u0000\u0010\u00032\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u0002H\u00030\u00012\u001c\u0008\u0004\u0010\u0005\u001a\u0016\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0083\u0008¢\u0006\u0002\u0008\u0008\u001aD\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\u0008\u0000\u0010\u0003*\u0018\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u0002H\u00030\u0001H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a]\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\u0008\u0000\u0010\u000b\"\u0004\u0008\u0001\u0010\u0003*#\u0008\u0001\u0012\u0004\u0012\u0002H\u000b\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000c¢\u0006\u0002\u0008\r2\u0006\u0010\u000e\u001a\u0002H\u000b2\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u0002H\u00030\u0001H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a\u001e\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\u0008\u0000\u0010\u0003*\u0008\u0012\u0004\u0012\u0002H\u00030\u0001H\u0007\u001aA\u0010\u0011\u001a\u0004\u0018\u00010\u0007\"\u0004\u0008\u0000\u0010\u0003*\u0018\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u0002H\u00030\u0001H\u0087\u0008ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001aZ\u0010\u0011\u001a\u0004\u0018\u00010\u0007\"\u0004\u0008\u0000\u0010\u000b\"\u0004\u0008\u0001\u0010\u0003*#\u0008\u0001\u0012\u0004\u0012\u0002H\u000b\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000c¢\u0006\u0002\u0008\r2\u0006\u0010\u000e\u001a\u0002H\u000b2\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u0002H\u00030\u0001H\u0087\u0008ø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001an\u0010\u0011\u001a\u0004\u0018\u00010\u0007\"\u0004\u0008\u0000\u0010\u000b\"\u0004\u0008\u0001\u0010\u0014\"\u0004\u0008\u0002\u0010\u0003*)\u0008\u0001\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u0002H\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0015¢\u0006\u0002\u0008\r2\u0006\u0010\u000e\u001a\u0002H\u000b2\u0006\u0010\u0016\u001a\u0002H\u00142\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u0002H\u00030\u0001H\u0081\u0008ø\u0001\u0000¢\u0006\u0002\u0010\u0017\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u0018", d2 = {"createCoroutineFromSuspendFunction", "Lkotlin/coroutines/Continuation;", "", "T", "completion", "block", "Lkotlin/Function1;", "", "createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt", "createCoroutineUnintercepted", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "R", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "intercepted", "startCoroutineUninterceptedOrReturn", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "P", "Lkotlin/Function3;", "param", "(Lkotlin/jvm/functions/Function3;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 5, mv = {1, 5, 1}, xi = 1, xs = "kotlin/coroutines/intrinsics/IntrinsicsKt")
class c {

    @Metadata(d1 = "\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\"\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0007H\u0014ø\u0001\u0000¢\u0006\u0002\u0010\u0008R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\t¸\u0006\u0000", d2 = {"kotlin/coroutines/intrinsics/IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$1", "Lkotlin/coroutines/jvm/internal/RestrictedContinuationImpl;", "label", "", "invokeSuspend", "", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public static final class a extends j {

        final d $completion;
        final l $this_createCoroutineUnintercepted$inlined;
        private int label;
        public a(d d, d d2, l l3) {
            this.$completion = d;
            this.$this_createCoroutineUnintercepted$inlined = l3;
            super(d2);
        }

        @Override // kotlin.b0.k.a.j
        protected Object invokeSuspend(Object object) {
            int str;
            Object obj3;
            int label = this.label;
            final int i = 1;
            if (label != 0) {
                if (label != i) {
                } else {
                    this.label = 2;
                    q.b(object);
                    return obj3;
                }
                obj3 = new IllegalStateException("This coroutine had already completed".toString());
                throw obj3;
            }
            this.label = i;
            q.b(object);
            obj3 = this.$this_createCoroutineUnintercepted$inlined;
            Objects.requireNonNull(obj3, "null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
            g0.e(obj3, i);
            obj3 = (l)obj3.invoke(this);
        }
    }

    @Metadata(d1 = "\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\"\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0007H\u0014ø\u0001\u0000¢\u0006\u0002\u0010\u0008R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\t¸\u0006\u0000", d2 = {"kotlin/coroutines/intrinsics/IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$2", "Lkotlin/coroutines/jvm/internal/ContinuationImpl;", "label", "", "invokeSuspend", "", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public static final class b extends d {

        final d $completion;
        final g $context;
        final l $this_createCoroutineUnintercepted$inlined;
        private int label;
        public b(d d, g g2, d d3, g g4, l l5) {
            this.$completion = d;
            this.$context = g2;
            this.$this_createCoroutineUnintercepted$inlined = l5;
            super(d3, g4);
        }

        @Override // kotlin.b0.k.a.d
        protected Object invokeSuspend(Object object) {
            int str;
            Object obj3;
            int label = this.label;
            final int i = 1;
            if (label != 0) {
                if (label != i) {
                } else {
                    this.label = 2;
                    q.b(object);
                    return obj3;
                }
                obj3 = new IllegalStateException("This coroutine had already completed".toString());
                throw obj3;
            }
            this.label = i;
            q.b(object);
            obj3 = this.$this_createCoroutineUnintercepted$inlined;
            Objects.requireNonNull(obj3, "null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
            g0.e(obj3, i);
            obj3 = (l)obj3.invoke(this);
        }
    }

    @Metadata(d1 = "\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\"\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0007H\u0014ø\u0001\u0000¢\u0006\u0002\u0010\u0008R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\t¸\u0006\u0000", d2 = {"kotlin/coroutines/intrinsics/IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$1", "Lkotlin/coroutines/jvm/internal/RestrictedContinuationImpl;", "label", "", "invokeSuspend", "", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public static final class c extends j {

        final d $completion;
        final Object $receiver$inlined;
        final p $this_createCoroutineUnintercepted$inlined;
        private int label;
        public c(d d, d d2, p p3, Object object4) {
            this.$completion = d;
            this.$this_createCoroutineUnintercepted$inlined = p3;
            this.$receiver$inlined = object4;
            super(d2);
        }

        @Override // kotlin.b0.k.a.j
        protected Object invokeSuspend(Object object) {
            int $receiver$inlined;
            Object obj4;
            $receiver$inlined = this.label;
            final int i = 2;
            final int i2 = 1;
            if ($receiver$inlined != 0) {
                if ($receiver$inlined != i2) {
                } else {
                    this.label = i;
                    q.b(object);
                    return obj4;
                }
                obj4 = new IllegalStateException("This coroutine had already completed".toString());
                throw obj4;
            }
            this.label = i2;
            q.b(object);
            obj4 = this.$this_createCoroutineUnintercepted$inlined;
            Objects.requireNonNull(obj4, "null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
            g0.e(obj4, i);
            obj4 = (p)obj4.invoke(this.$receiver$inlined, this);
        }
    }

    @Metadata(d1 = "\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\"\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0007H\u0014ø\u0001\u0000¢\u0006\u0002\u0010\u0008R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\t¸\u0006\u0000", d2 = {"kotlin/coroutines/intrinsics/IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$2", "Lkotlin/coroutines/jvm/internal/ContinuationImpl;", "label", "", "invokeSuspend", "", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public static final class d extends d {

        final d $completion;
        final g $context;
        final Object $receiver$inlined;
        final p $this_createCoroutineUnintercepted$inlined;
        private int label;
        public d(d d, g g2, d d3, g g4, p p5, Object object6) {
            this.$completion = d;
            this.$context = g2;
            this.$this_createCoroutineUnintercepted$inlined = p5;
            this.$receiver$inlined = object6;
            super(d3, g4);
        }

        @Override // kotlin.b0.k.a.d
        protected Object invokeSuspend(Object object) {
            int $receiver$inlined;
            Object obj4;
            $receiver$inlined = this.label;
            final int i = 2;
            final int i2 = 1;
            if ($receiver$inlined != 0) {
                if ($receiver$inlined != i2) {
                } else {
                    this.label = i;
                    q.b(object);
                    return obj4;
                }
                obj4 = new IllegalStateException("This coroutine had already completed".toString());
                throw obj4;
            }
            this.label = i2;
            q.b(object);
            obj4 = this.$this_createCoroutineUnintercepted$inlined;
            Objects.requireNonNull(obj4, "null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
            g0.e(obj4, i);
            obj4 = (p)obj4.invoke(this.$receiver$inlined, this);
        }
    }
    public static <T> d<w> a(l<? super d<? super T>, ? extends Object> l, d<? super T> d2) {
        boolean aVar;
        Object str;
        g gVar;
        Object obj2;
        g context;
        Object obj;
        kotlin.b0.j.c.b bVar;
        d obj7;
        n.f(l, "$this$createCoroutineUnintercepted");
        n.f(d2, "completion");
        h.a(d2);
        if (l instanceof a) {
            obj7 = (a)l.create(d2);
        } else {
            context = d2.getContext();
            str = "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>";
            if (context == h.a) {
                Objects.requireNonNull(d2, str);
                aVar = new c.a(d2, d2, l);
                obj7 = aVar;
            } else {
                Objects.requireNonNull(d2, str);
                super(d2, context, d2, context, l);
                obj7 = bVar;
            }
        }
        return obj7;
    }

    public static <R, T> d<w> b(p<? super R, ? super d<? super T>, ? extends Object> p, R r2, d<? super T> d3) {
        boolean cVar;
        Object str;
        g gVar;
        Object obj3;
        g context;
        Object obj2;
        Object obj;
        kotlin.b0.j.c.d dVar;
        d obj8;
        n.f(p, "$this$createCoroutineUnintercepted");
        n.f(d3, "completion");
        h.a(d3);
        if (p instanceof a) {
            obj8 = (a)p.create(r2, d3);
        } else {
            context = d3.getContext();
            str = "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>";
            if (context == h.a) {
                Objects.requireNonNull(d3, str);
                cVar = new c.c(d3, d3, p, r2);
                obj8 = cVar;
            } else {
                Objects.requireNonNull(d3, str);
                super(d3, context, d3, context, p, r2);
                obj8 = dVar;
            }
        }
        return obj8;
    }

    public static <T> d<T> c(d<? super T> d) {
        int intercepted;
        Object obj1;
        n.f(d, "$this$intercepted");
        intercepted = !d instanceof d ? 0 : d;
        intercepted = (d)intercepted.intercepted();
        if (intercepted != 0 && intercepted != null) {
            intercepted = intercepted.intercepted();
            if (intercepted != null) {
                obj1 = intercepted;
            }
        }
        return obj1;
    }
}
