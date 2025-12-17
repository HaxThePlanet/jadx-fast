package kotlin.b0;

import kotlin.Metadata;
import kotlin.b0.j.b;
import kotlin.d0.c.l;
import kotlin.d0.c.p;
import kotlin.d0.d.n;
import kotlin.p;
import kotlin.w;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0003\n\u0002\u0008\u0004\u001a?\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u0002H\u00080\u0007\"\u0004\u0008\u0000\u0010\u00082\u0006\u0010\t\u001a\u00020\u00012\u001a\u0008\u0004\u0010\n\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00080\u000c\u0012\u0004\u0012\u00020\r0\u000bH\u0087\u0008ø\u0001\u0000ø\u0001\u0001\u001a@\u0010\u000e\u001a\u0002H\u0008\"\u0004\u0008\u0000\u0010\u00082\u001a\u0008\u0004\u0010\u000f\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00080\u0007\u0012\u0004\u0012\u00020\r0\u000bH\u0087Hø\u0001\u0000\u0082\u0002\n\n\u0008\u0008\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0010\u001aD\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\r0\u0007\"\u0004\u0008\u0000\u0010\u0008*\u0018\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00080\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000b2\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u0002H\u00080\u0007H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0014\u001a]\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\r0\u0007\"\u0004\u0008\u0000\u0010\u0015\"\u0004\u0008\u0001\u0010\u0008*#\u0008\u0001\u0012\u0004\u0012\u0002H\u0015\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00080\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0016¢\u0006\u0002\u0008\u00172\u0006\u0010\u0018\u001a\u0002H\u00152\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u0002H\u00080\u0007H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0019\u001a&\u0010\u001a\u001a\u00020\r\"\u0004\u0008\u0000\u0010\u0008*\u0008\u0012\u0004\u0012\u0002H\u00080\u00072\u0006\u0010\u001b\u001a\u0002H\u0008H\u0087\u0008¢\u0006\u0002\u0010\u001c\u001a!\u0010\u001d\u001a\u00020\r\"\u0004\u0008\u0000\u0010\u0008*\u0008\u0012\u0004\u0012\u0002H\u00080\u00072\u0006\u0010\u001e\u001a\u00020\u001fH\u0087\u0008\u001a>\u0010 \u001a\u00020\r\"\u0004\u0008\u0000\u0010\u0008*\u0018\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00080\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000b2\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u0002H\u00080\u0007H\u0007ø\u0001\u0000¢\u0006\u0002\u0010!\u001aW\u0010 \u001a\u00020\r\"\u0004\u0008\u0000\u0010\u0015\"\u0004\u0008\u0001\u0010\u0008*#\u0008\u0001\u0012\u0004\u0012\u0002H\u0015\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00080\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0016¢\u0006\u0002\u0008\u00172\u0006\u0010\u0018\u001a\u0002H\u00152\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u0002H\u00080\u0007H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\"\"\u001b\u0010\u0000\u001a\u00020\u00018Æ\u0002X\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0002\u0010\u0003\u001a\u0004\u0008\u0004\u0010\u0005\u0082\u0002\u000b\n\u0002\u0008\u0019\n\u0005\u0008\u009920\u0001¨\u0006#", d2 = {"coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext$annotations", "()V", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "Continuation", "Lkotlin/coroutines/Continuation;", "T", "context", "resumeWith", "Lkotlin/Function1;", "Lkotlin/Result;", "", "suspendCoroutine", "block", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createCoroutine", "", "completion", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "R", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "resume", "value", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)V", "resumeWithException", "exception", "", "startCoroutine", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "kotlin-stdlib"}, k = 2, mv = {1, 5, 1})
public final class f {
    public static final <T> void a(l<? super kotlin.b0.d<? super T>, ? extends Object> l, kotlin.b0.d<? super T> d2) {
        n.f(l, "$this$startCoroutine");
        n.f(d2, "completion");
        final w obj2 = w.a;
        kotlin.p.a aVar = p.a;
        p.a(obj2);
        b.c(b.a(l, d2)).resumeWith(obj2);
    }

    public static final <R, T> void b(p<? super R, ? super kotlin.b0.d<? super T>, ? extends Object> p, R r2, kotlin.b0.d<? super T> d3) {
        n.f(p, "$this$startCoroutine");
        n.f(d3, "completion");
        final w obj2 = w.a;
        final kotlin.p.a obj3 = p.a;
        p.a(obj2);
        b.c(b.b(p, r2, d3)).resumeWith(obj2);
    }
}
