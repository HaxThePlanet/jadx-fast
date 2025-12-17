package androidx.compose.ui.platform;

import androidx.compose.runtime.FloatState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.ui.MotionDurationScale;
import androidx.compose.ui.MotionDurationScale.DefaultImpls;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Element;
import kotlin.coroutines.CoroutineContext.Key;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0008\u0008\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R+\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\u0008\n\u0010\u000b\u001a\u0004\u0008\u0006\u0010\u0007\"\u0004\u0008\u0008\u0010\t¨\u0006\u000c", d2 = {"Landroidx/compose/ui/platform/MotionDurationScaleImpl;", "Landroidx/compose/ui/MotionDurationScale;", "()V", "<set-?>", "", "scaleFactor", "getScaleFactor", "()F", "setScaleFactor", "(F)V", "scaleFactor$delegate", "Landroidx/compose/runtime/MutableFloatState;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class MotionDurationScaleImpl implements MotionDurationScale {

    private final MutableFloatState scaleFactor$delegate;
    public MotionDurationScaleImpl() {
        super();
        this.scaleFactor$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(1065353216);
    }

    public <R> R fold(R initial, Function2<? super R, ? super CoroutineContext.Element, ? extends R> operation) {
        return MotionDurationScale.DefaultImpls.fold(this, initial, operation);
    }

    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        return MotionDurationScale.DefaultImpls.get(this, key);
    }

    @Override // androidx.compose.ui.MotionDurationScale
    public float getScaleFactor() {
        final int i = 0;
        final int i2 = 0;
        return (FloatState)this.scaleFactor$delegate.getFloatValue();
    }

    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        return MotionDurationScale.DefaultImpls.minusKey(this, key);
    }

    @Override // androidx.compose.ui.MotionDurationScale
    public CoroutineContext plus(CoroutineContext context) {
        return MotionDurationScale.DefaultImpls.plus(this, context);
    }

    @Override // androidx.compose.ui.MotionDurationScale
    public void setScaleFactor(float <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.scaleFactor$delegate.setFloatValue(<set-?>);
    }
}
