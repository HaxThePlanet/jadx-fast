package kotlin.coroutines;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0008g\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fJ(\u0010\u0002\u001a\u0004\u0018\u0001H\u0003\"\u0008\u0008\u0000\u0010\u0003*\u00020\u00012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u0002H\u00030\u0005H\u0096\u0002¢\u0006\u0002\u0010\u0006J\"\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u0002H\t0\u0008\"\u0004\u0008\u0000\u0010\t2\u000c\u0010\n\u001a\u0008\u0012\u0004\u0012\u0002H\t0\u0008H&J\u0014\u0010\u000b\u001a\u00020\u000c2\n\u0010\u0004\u001a\u0006\u0012\u0002\u0008\u00030\u0005H\u0016J\u0014\u0010\r\u001a\u00020\u000e2\n\u0010\n\u001a\u0006\u0012\u0002\u0008\u00030\u0008H\u0016¨\u0006\u0010", d2 = {"Lkotlin/coroutines/ContinuationInterceptor;", "Lkotlin/coroutines/CoroutineContext$Element;", "get", "E", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "interceptContinuation", "Lkotlin/coroutines/Continuation;", "T", "continuation", "minusKey", "Lkotlin/coroutines/CoroutineContext;", "releaseInterceptedContinuation", "", "Key", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface ContinuationInterceptor extends kotlin.coroutines.CoroutineContext.Element {

    public static final kotlin.coroutines.ContinuationInterceptor.Key Key;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static <R> R fold(kotlin.coroutines.ContinuationInterceptor $this, R initial, Function2<? super R, ? super kotlin.coroutines.CoroutineContext.Element, ? extends R> operation) {
            Intrinsics.checkNotNullParameter(operation, "operation");
            return CoroutineContext.Element.DefaultImpls.fold((CoroutineContext.Element)$this, initial, operation);
        }

        public static <E extends kotlin.coroutines.CoroutineContext.Element> E get(kotlin.coroutines.ContinuationInterceptor $this, kotlin.coroutines.CoroutineContext.Key<E> key) {
            Object key2;
            boolean subKey$kotlin_stdlib;
            int i;
            kotlin.coroutines.CoroutineContext.Key key3;
            Intrinsics.checkNotNullParameter(key, "key");
            i = 0;
            subKey$kotlin_stdlib = (AbstractCoroutineContextKey)key.tryCast$kotlin_stdlib((CoroutineContext.Element)$this);
            if (key instanceof AbstractCoroutineContextKey && (AbstractCoroutineContextKey)key.isSubKey$kotlin_stdlib($this.getKey()) && subKey$kotlin_stdlib instanceof CoroutineContext.Element) {
                if ((AbstractCoroutineContextKey)key.isSubKey$kotlin_stdlib($this.getKey())) {
                    subKey$kotlin_stdlib = (AbstractCoroutineContextKey)key.tryCast$kotlin_stdlib((CoroutineContext.Element)$this);
                    if (subKey$kotlin_stdlib instanceof CoroutineContext.Element) {
                        i = subKey$kotlin_stdlib;
                    }
                }
                return i;
            }
            if (ContinuationInterceptor.Key == key) {
                Intrinsics.checkNotNull($this, "null cannot be cast to non-null type E of kotlin.coroutines.ContinuationInterceptor.get");
                i = $this;
            }
            return i;
        }

        public static kotlin.coroutines.CoroutineContext minusKey(kotlin.coroutines.ContinuationInterceptor $this, kotlin.coroutines.CoroutineContext.Key<?> key) {
            kotlin.coroutines.EmptyCoroutineContext iNSTANCE;
            kotlin.coroutines.EmptyCoroutineContext iNSTANCE2;
            boolean subKey$kotlin_stdlib;
            Object key2;
            Intrinsics.checkNotNullParameter(key, "key");
            if (key instanceof AbstractCoroutineContextKey) {
                if ((AbstractCoroutineContextKey)key.isSubKey$kotlin_stdlib($this.getKey()) && (AbstractCoroutineContextKey)key.tryCast$kotlin_stdlib((CoroutineContext.Element)$this) != null) {
                    if ((AbstractCoroutineContextKey)key.tryCast$kotlin_stdlib((CoroutineContext.Element)$this) != null) {
                        iNSTANCE2 = EmptyCoroutineContext.INSTANCE;
                    } else {
                        iNSTANCE2 = $this;
                    }
                } else {
                }
                return iNSTANCE2;
            }
            if (ContinuationInterceptor.Key == key) {
                iNSTANCE = EmptyCoroutineContext.INSTANCE;
            } else {
                iNSTANCE = $this;
            }
            return iNSTANCE;
        }

        public static kotlin.coroutines.CoroutineContext plus(kotlin.coroutines.ContinuationInterceptor $this, kotlin.coroutines.CoroutineContext context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return CoroutineContext.Element.DefaultImpls.plus((CoroutineContext.Element)$this, context);
        }

        public static void releaseInterceptedContinuation(kotlin.coroutines.ContinuationInterceptor $this, kotlin.coroutines.Continuation<?> continuation) {
            Intrinsics.checkNotNullParameter(continuation, "continuation");
        }
    }

    @Metadata(d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004", d2 = {"Lkotlin/coroutines/ContinuationInterceptor$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlin/coroutines/ContinuationInterceptor;", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Key implements kotlin.coroutines.CoroutineContext.Key<kotlin.coroutines.ContinuationInterceptor> {

        static final kotlin.coroutines.ContinuationInterceptor.Key $$INSTANCE;
        static {
            ContinuationInterceptor.Key key = new ContinuationInterceptor.Key();
            ContinuationInterceptor.Key.$$INSTANCE = key;
        }
    }
    static {
        ContinuationInterceptor.Key = ContinuationInterceptor.Key.$$INSTANCE;
    }

    public abstract <E extends kotlin.coroutines.CoroutineContext.Element> E get(kotlin.coroutines.CoroutineContext.Key<E> coroutineContext$Key);

    public abstract <T> kotlin.coroutines.Continuation<T> interceptContinuation(kotlin.coroutines.Continuation<? super T> continuation);

    public abstract kotlin.coroutines.CoroutineContext minusKey(kotlin.coroutines.CoroutineContext.Key<?> coroutineContext$Key);

    public abstract void releaseInterceptedContinuation(kotlin.coroutines.Continuation<?> continuation);
}
