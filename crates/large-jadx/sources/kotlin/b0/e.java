package kotlin.b0;

import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0008g\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fJ(\u0010\u0002\u001a\u0004\u0018\u0001H\u0003\"\u0008\u0008\u0000\u0010\u0003*\u00020\u00012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u0002H\u00030\u0005H\u0096\u0002¢\u0006\u0002\u0010\u0006J\"\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u0002H\t0\u0008\"\u0004\u0008\u0000\u0010\t2\u000c\u0010\n\u001a\u0008\u0012\u0004\u0012\u0002H\t0\u0008H&J\u0014\u0010\u000b\u001a\u00020\u000c2\n\u0010\u0004\u001a\u0006\u0012\u0002\u0008\u00030\u0005H\u0016J\u0014\u0010\r\u001a\u00020\u000e2\n\u0010\n\u001a\u0006\u0012\u0002\u0008\u00030\u0008H\u0016¨\u0006\u0010", d2 = {"Lkotlin/coroutines/ContinuationInterceptor;", "Lkotlin/coroutines/CoroutineContext$Element;", "get", "E", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "interceptContinuation", "Lkotlin/coroutines/Continuation;", "T", "continuation", "minusKey", "Lkotlin/coroutines/CoroutineContext;", "releaseInterceptedContinuation", "", "Key", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
public interface e extends kotlin.b0.g.b {

    public static final kotlin.b0.e.b p;

    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
        public static <E extends kotlin.b0.g.b> E a(kotlin.b0.e e, kotlin.b0.g.c<E> g$c2) {
            int i;
            kotlin.b0.g.b obj2;
            Object obj3;
            n.f(c2, "key");
            if (c2 instanceof b && (b)c2.a(e.getKey())) {
                if ((b)c2.a(e.getKey())) {
                    obj2 = c2.b(e);
                    if (!obj2 instanceof g.b) {
                    } else {
                        i = obj2;
                    }
                }
                return i;
            }
            if (e.p == c2) {
                Objects.requireNonNull(e, "null cannot be cast to non-null type E");
            } else {
                obj2 = i;
            }
            return obj2;
        }

        public static kotlin.b0.g b(kotlin.b0.e e, kotlin.b0.g.c<?> g$c2) {
            Object obj1;
            Object obj2;
            n.f(c2, "key");
            if (c2 instanceof b && (b)c2.a(e.getKey()) && c2.b(e) != null) {
                if ((b)c2.a(e.getKey())) {
                    if (c2.b(e) != null) {
                        obj1 = h.a;
                    }
                }
                return obj1;
            }
            if (e.p == c2) {
                obj1 = h.a;
            }
            return obj1;
        }
    }

    @Metadata(d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004", d2 = {"Lkotlin/coroutines/ContinuationInterceptor$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlin/coroutines/ContinuationInterceptor;", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public static final class b implements kotlin.b0.g.c<kotlin.b0.e> {

        static final kotlin.b0.e.b a;
        static {
            e.b bVar = new e.b();
            e.b.a = bVar;
        }
    }
    static {
        e.p = e.b.a;
    }

    public abstract void e(kotlin.b0.d<?> d);

    public abstract <T> kotlin.b0.d<T> i(kotlin.b0.d<? super T> d);
}
