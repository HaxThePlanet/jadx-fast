package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Element;
import kotlin.coroutines.CoroutineContext.Key;
import kotlin.jvm.functions.Function2;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008g\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002J\u000e\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0000H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\u0008", d2 = {"Lkotlinx/coroutines/CopyableThreadContextElement;", "S", "Lkotlinx/coroutines/ThreadContextElement;", "copyForChild", "mergeForChild", "Lkotlin/coroutines/CoroutineContext;", "overwritingElement", "Lkotlin/coroutines/CoroutineContext$Element;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface CopyableThreadContextElement<S>  extends kotlinx.coroutines.ThreadContextElement<S> {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static <S, R> R fold(kotlinx.coroutines.CopyableThreadContextElement<S> $this, R initial, Function2<? super R, ? super CoroutineContext.Element, ? extends R> operation) {
            return ThreadContextElement.DefaultImpls.fold((ThreadContextElement)$this, initial, operation);
        }

        public static <S, E extends CoroutineContext.Element> E get(kotlinx.coroutines.CopyableThreadContextElement<S> $this, CoroutineContext.Key<E> key) {
            return ThreadContextElement.DefaultImpls.get((ThreadContextElement)$this, key);
        }

        public static <S> CoroutineContext minusKey(kotlinx.coroutines.CopyableThreadContextElement<S> $this, CoroutineContext.Key<?> key) {
            return ThreadContextElement.DefaultImpls.minusKey((ThreadContextElement)$this, key);
        }

        public static <S> CoroutineContext plus(kotlinx.coroutines.CopyableThreadContextElement<S> $this, CoroutineContext context) {
            return ThreadContextElement.DefaultImpls.plus((ThreadContextElement)$this, context);
        }
    }
    public abstract kotlinx.coroutines.CopyableThreadContextElement<S> copyForChild();

    @Override // kotlinx.coroutines.ThreadContextElement
    public abstract CoroutineContext mergeForChild(CoroutineContext.Element coroutineContext$Element);
}
