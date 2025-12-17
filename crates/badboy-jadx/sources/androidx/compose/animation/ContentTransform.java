package androidx.compose.animation;

import androidx.compose.runtime.FloatState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0011\u0008\u0007\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR(\u0010\u0008\u001a\u0004\u0018\u00010\t2\u0008\u0010\r\u001a\u0004\u0018\u00010\t@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000e\u0010\u000f\"\u0004\u0008\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R+\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u0018\u0010\u0019\u001a\u0004\u0008\u0014\u0010\u0015\"\u0004\u0008\u0016\u0010\u0017¨\u0006\u001a", d2 = {"Landroidx/compose/animation/ContentTransform;", "", "targetContentEnter", "Landroidx/compose/animation/EnterTransition;", "initialContentExit", "Landroidx/compose/animation/ExitTransition;", "targetContentZIndex", "", "sizeTransform", "Landroidx/compose/animation/SizeTransform;", "(Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;FLandroidx/compose/animation/SizeTransform;)V", "getInitialContentExit", "()Landroidx/compose/animation/ExitTransition;", "<set-?>", "getSizeTransform", "()Landroidx/compose/animation/SizeTransform;", "setSizeTransform$animation_release", "(Landroidx/compose/animation/SizeTransform;)V", "getTargetContentEnter", "()Landroidx/compose/animation/EnterTransition;", "getTargetContentZIndex", "()F", "setTargetContentZIndex", "(F)V", "targetContentZIndex$delegate", "Landroidx/compose/runtime/MutableFloatState;", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ContentTransform {

    public static final int $stable = 8;
    private final androidx.compose.animation.ExitTransition initialContentExit;
    private androidx.compose.animation.SizeTransform sizeTransform;
    private final androidx.compose.animation.EnterTransition targetContentEnter;
    private final MutableFloatState targetContentZIndex$delegate;
    static {
        final int i = 8;
    }

    public ContentTransform(androidx.compose.animation.EnterTransition targetContentEnter, androidx.compose.animation.ExitTransition initialContentExit, float targetContentZIndex, androidx.compose.animation.SizeTransform sizeTransform) {
        super();
        this.targetContentEnter = targetContentEnter;
        this.initialContentExit = initialContentExit;
        this.targetContentZIndex$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(targetContentZIndex);
        this.sizeTransform = sizeTransform;
    }

    public ContentTransform(androidx.compose.animation.EnterTransition enterTransition, androidx.compose.animation.ExitTransition exitTransition2, float f3, androidx.compose.animation.SizeTransform sizeTransform4, int i5, DefaultConstructorMarker defaultConstructorMarker6) {
        int obj3;
        androidx.compose.animation.SizeTransform obj4;
        int obj5;
        int obj6;
        obj3 = i5 & 4 != 0 ? 0 : obj3;
        if (i5 &= 8 != 0) {
            obj6 = 0;
            obj4 = AnimatedContentKt.SizeTransform$default(false, obj6, 3, obj6);
        }
        super(enterTransition, exitTransition2, obj3, obj4);
    }

    public final androidx.compose.animation.ExitTransition getInitialContentExit() {
        return this.initialContentExit;
    }

    public final androidx.compose.animation.SizeTransform getSizeTransform() {
        return this.sizeTransform;
    }

    public final androidx.compose.animation.EnterTransition getTargetContentEnter() {
        return this.targetContentEnter;
    }

    public final float getTargetContentZIndex() {
        final int i = 0;
        final int i2 = 0;
        return (FloatState)this.targetContentZIndex$delegate.getFloatValue();
    }

    public final void setSizeTransform$animation_release(androidx.compose.animation.SizeTransform <set-?>) {
        this.sizeTransform = <set-?>;
    }

    public final void setTargetContentZIndex(float <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.targetContentZIndex$delegate.setFloatValue(<set-?>);
    }
}
