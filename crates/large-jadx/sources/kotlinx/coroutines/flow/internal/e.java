package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.g;
import kotlin.b0.g.b;
import kotlin.b0.h;
import kotlin.b0.j.b;
import kotlin.b0.k.a.d;
import kotlin.b0.k.a.e;
import kotlin.b0.k.a.h;
import kotlin.d0.c.p;
import kotlin.d0.c.q;
import kotlin.d0.d.p;
import kotlin.k0.l;
import kotlin.p;
import kotlin.w;
import kotlinx.coroutines.b2;
import kotlinx.coroutines.b3.e;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u000b\n\u0002\u0010\u0000\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0000\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u00032\u00020\u0004B\u001b\u0012\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J'\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00072\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0018\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0019J\u0019\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ%\u0010\u001a\u001a\u0004\u0018\u00010\u001c2\u000c\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0018\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001eJ\u001a\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020!2\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u001cH\u0002J\n\u0010\"\u001a\u0004\u0018\u00010#H\u0016J \u0010$\u001a\u00020\u001c2\u000e\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0&H\u0016ø\u0001\u0000¢\u0006\u0002\u0010'J\u0008\u0010(\u001a\u00020\u0010H\u0016R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000bR\u0010\u0010\u0006\u001a\u00020\u00078\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000c\u001a\u00020\r8\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00028\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006)", d2 = {"Lkotlinx/coroutines/flow/internal/SafeCollector;", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/coroutines/jvm/internal/ContinuationImpl;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "collector", "collectContext", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/CoroutineContext;)V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "collectContextSize", "", "completion", "Lkotlin/coroutines/Continuation;", "", "context", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "lastEmissionContext", "checkContext", "currentContext", "previousContext", "value", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)V", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "uCont", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)Ljava/lang/Object;", "exceptionTransparencyViolated", "exception", "Lkotlinx/coroutines/flow/internal/DownstreamExceptionElement;", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "invokeSuspend", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)Ljava/lang/Object;", "releaseIntercepted", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class e<T>  extends d implements e<T>, e {

    public final g collectContext;
    public final int collectContextSize;
    public final e<T> collector;
    private d<? super w> completion;
    private g lastEmissionContext;

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\n", d2 = {"<anonymous>", "", "T", "count", "<anonymous parameter 1>", "Lkotlin/coroutines/CoroutineContext$Element;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements p<Integer, g.b, Integer> {

        public static final kotlinx.coroutines.flow.internal.e.a a;
        static {
            e.a aVar = new e.a();
            e.a.a = aVar;
        }

        a() {
            super(2);
        }

        @Override // kotlin.d0.d.p
        public final Integer a(int i, g.b g$b2) {
            return Integer.valueOf(i++);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object, Object object2) {
            return a((Number)object.intValue(), (g.b)object2);
        }
    }
    public e(e<? super T> e, g g2) {
        super(c.a, h.a);
        this.collector = e;
        this.collectContext = g2;
        this.collectContextSize = (Number)g2.fold(0, e.a.a).intValue();
    }

    private final void c(g g, g g2, T t3) {
        if (g2 instanceof b) {
        } else {
            g.a(this, g);
            this.lastEmissionContext = g;
        }
        f((b)g2, t3);
        throw 0;
    }

    private final Object e(d<? super w> d, T t2) {
        g context = d.getContext();
        b2.g(context);
        final g lastEmissionContext = this.lastEmissionContext;
        if (lastEmissionContext != context) {
            c(context, lastEmissionContext, t2);
        }
        this.completion = d;
        return f.a().invoke(this.collector, t2, this);
    }

    private final void f(kotlinx.coroutines.flow.internal.b b, Object object2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception ");
        stringBuilder.append(b.a);
        stringBuilder.append(", but then emission attempt of value '");
        stringBuilder.append(object2);
        stringBuilder.append("' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ");
        IllegalStateException obj4 = new IllegalStateException(l.f(stringBuilder.toString()).toString());
        throw obj4;
    }

    public Object b(T t, d<? super w> d2) {
        try {
            Object obj2 = e(d2, t);
            if (obj2 == b.d()) {
            }
            h.c(d2);
            if (obj2 == b.d()) {
            }
            return obj2;
        }
        return w.a;
    }

    @Override // kotlin.b0.k.a.d
    public e getCallerFrame() {
        d completion;
        if (completion instanceof e) {
        } else {
            completion = 0;
        }
        return completion;
    }

    @Override // kotlin.b0.k.a.d
    public g getContext() {
        int context;
        d completion = this.completion;
        if (completion == null) {
            context = 0;
        } else {
            context = completion.getContext();
        }
        if (context == null) {
            context = h.a;
        }
        return context;
    }

    @Override // kotlin.b0.k.a.d
    public java.lang.StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlin.b0.k.a.d
    public Object invokeSuspend(Object object) {
        kotlinx.coroutines.flow.internal.b bVar;
        Throwable th = p.c(object);
        if (th != null) {
            bVar = new b(th);
            this.lastEmissionContext = bVar;
        }
        d completion = this.completion;
        if (completion == null) {
        } else {
            completion.resumeWith(object);
        }
        return b.d();
    }

    @Override // kotlin.b0.k.a.d
    public void releaseIntercepted() {
        super.releaseIntercepted();
    }
}
