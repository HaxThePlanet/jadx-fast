package androidx.compose.ui;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Element;
import kotlin.coroutines.CoroutineContext.Element.DefaultImpls;
import kotlin.coroutines.CoroutineContext.Key;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0002\u0008\u0004\u0008g\u0018\u0000 \n2\u00020\u0001:\u0001\nR\u0018\u0010\u0002\u001a\u0006\u0012\u0002\u0008\u00030\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u000bÀ\u0006\u0001", d2 = {"Landroidx/compose/ui/MotionDurationScale;", "Lkotlin/coroutines/CoroutineContext$Element;", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "scaleFactor", "", "getScaleFactor", "()F", "Key", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface MotionDurationScale extends CoroutineContext.Element {

    public static final androidx.compose.ui.MotionDurationScale.Key Key;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static <R> R fold(androidx.compose.ui.MotionDurationScale $this, R initial, Function2<? super R, ? super CoroutineContext.Element, ? extends R> operation) {
            return CoroutineContext.Element.DefaultImpls.fold((CoroutineContext.Element)$this, initial, operation);
        }

        public static <E extends CoroutineContext.Element> E get(androidx.compose.ui.MotionDurationScale $this, CoroutineContext.Key<E> key) {
            return CoroutineContext.Element.DefaultImpls.get((CoroutineContext.Element)$this, key);
        }

        public static CoroutineContext minusKey(androidx.compose.ui.MotionDurationScale $this, CoroutineContext.Key<?> key) {
            return CoroutineContext.Element.DefaultImpls.minusKey((CoroutineContext.Element)$this, key);
        }

        public static CoroutineContext plus(androidx.compose.ui.MotionDurationScale $this, CoroutineContext context) {
            return CoroutineContext.Element.DefaultImpls.plus((CoroutineContext.Element)$this, context);
        }
    }

    @Metadata(d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004", d2 = {"Landroidx/compose/ui/MotionDurationScale$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Landroidx/compose/ui/MotionDurationScale;", "()V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Key implements CoroutineContext.Key<androidx.compose.ui.MotionDurationScale> {

        static final androidx.compose.ui.MotionDurationScale.Key $$INSTANCE;
        static {
            MotionDurationScale.Key key = new MotionDurationScale.Key();
            MotionDurationScale.Key.$$INSTANCE = key;
        }
    }
    static {
        MotionDurationScale.Key = MotionDurationScale.Key.$$INSTANCE;
    }

    public CoroutineContext.Key<?> getKey() {
        return (CoroutineContext.Key)MotionDurationScale.Key;
    }

    @Override // kotlin.coroutines.CoroutineContext$Element
    public abstract float getScaleFactor();
}
