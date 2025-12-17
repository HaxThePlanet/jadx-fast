package kotlin.coroutines;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0018\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u001a+\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0008\u0008\u0000\u0010\u0001*\u00020\u0002*\u00020\u00022\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u0002H\u00010\u0004H\u0007¢\u0006\u0002\u0010\u0005\u001a\u0018\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\n\u0010\u0003\u001a\u0006\u0012\u0002\u0008\u00030\u0004H\u0007¨\u0006\u0008", d2 = {"getPolymorphicElement", "E", "Lkotlin/coroutines/CoroutineContext$Element;", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Element;Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "minusPolymorphicKey", "Lkotlin/coroutines/CoroutineContext;", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class CoroutineContextImplKt {
    public static final <E extends kotlin.coroutines.CoroutineContext.Element> E getPolymorphicElement(kotlin.coroutines.CoroutineContext.Element $this$getPolymorphicElement, kotlin.coroutines.CoroutineContext.Key<E> key) {
        boolean subKey$kotlin_stdlib;
        int i;
        kotlin.coroutines.CoroutineContext.Key key2;
        Intrinsics.checkNotNullParameter($this$getPolymorphicElement, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        i = 0;
        subKey$kotlin_stdlib = (AbstractCoroutineContextKey)key.tryCast$kotlin_stdlib($this$getPolymorphicElement);
        if (key instanceof AbstractCoroutineContextKey && (AbstractCoroutineContextKey)key.isSubKey$kotlin_stdlib($this$getPolymorphicElement.getKey()) && subKey$kotlin_stdlib instanceof CoroutineContext.Element) {
            if ((AbstractCoroutineContextKey)key.isSubKey$kotlin_stdlib($this$getPolymorphicElement.getKey())) {
                subKey$kotlin_stdlib = (AbstractCoroutineContextKey)key.tryCast$kotlin_stdlib($this$getPolymorphicElement);
                if (subKey$kotlin_stdlib instanceof CoroutineContext.Element) {
                    i = subKey$kotlin_stdlib;
                }
            }
            return i;
        }
        if ($this$getPolymorphicElement.getKey() == key) {
            i = $this$getPolymorphicElement;
        }
        return i;
    }

    public static final kotlin.coroutines.CoroutineContext minusPolymorphicKey(kotlin.coroutines.CoroutineContext.Element $this$minusPolymorphicKey, kotlin.coroutines.CoroutineContext.Key<?> key) {
        Object iNSTANCE;
        Object iNSTANCE2;
        boolean subKey$kotlin_stdlib;
        Intrinsics.checkNotNullParameter($this$minusPolymorphicKey, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (key instanceof AbstractCoroutineContextKey) {
            if ((AbstractCoroutineContextKey)key.isSubKey$kotlin_stdlib($this$minusPolymorphicKey.getKey()) && (AbstractCoroutineContextKey)key.tryCast$kotlin_stdlib($this$minusPolymorphicKey) != null) {
                if ((AbstractCoroutineContextKey)key.tryCast$kotlin_stdlib($this$minusPolymorphicKey) != null) {
                    iNSTANCE2 = EmptyCoroutineContext.INSTANCE;
                } else {
                    iNSTANCE2 = $this$minusPolymorphicKey;
                }
            } else {
            }
            return iNSTANCE2;
        }
        if ($this$minusPolymorphicKey.getKey() == key) {
            iNSTANCE = EmptyCoroutineContext.INSTANCE;
        } else {
            iNSTANCE = $this$minusPolymorphicKey;
        }
        return iNSTANCE;
    }
}
