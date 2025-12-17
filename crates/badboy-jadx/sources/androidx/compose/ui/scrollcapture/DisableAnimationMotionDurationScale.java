package androidx.compose.ui.scrollcapture;

import androidx.compose.ui.MotionDurationScale;
import androidx.compose.ui.MotionDurationScale.DefaultImpls;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Element;
import kotlin.coroutines.CoroutineContext.Key;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0003\u0008Â\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Landroidx/compose/ui/scrollcapture/DisableAnimationMotionDurationScale;", "Landroidx/compose/ui/MotionDurationScale;", "()V", "scaleFactor", "", "getScaleFactor", "()F", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class DisableAnimationMotionDurationScale implements MotionDurationScale {

    public static final androidx.compose.ui.scrollcapture.DisableAnimationMotionDurationScale INSTANCE;
    static {
        DisableAnimationMotionDurationScale disableAnimationMotionDurationScale = new DisableAnimationMotionDurationScale();
        DisableAnimationMotionDurationScale.INSTANCE = disableAnimationMotionDurationScale;
    }

    public <R> R fold(R initial, Function2<? super R, ? super CoroutineContext.Element, ? extends R> operation) {
        return MotionDurationScale.DefaultImpls.fold(this, initial, operation);
    }

    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        return MotionDurationScale.DefaultImpls.get(this, key);
    }

    @Override // androidx.compose.ui.MotionDurationScale
    public float getScaleFactor() {
        return 0;
    }

    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        return MotionDurationScale.DefaultImpls.minusKey(this, key);
    }

    @Override // androidx.compose.ui.MotionDurationScale
    public CoroutineContext plus(CoroutineContext context) {
        return MotionDurationScale.DefaultImpls.plus(this, context);
    }
}
