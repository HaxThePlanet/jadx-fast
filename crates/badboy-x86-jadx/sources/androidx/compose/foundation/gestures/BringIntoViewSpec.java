package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0008\u0008g\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bJ \u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0016R\u001a\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u000cÀ\u0006\u0001", d2 = {"Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "", "scrollAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "getScrollAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "calculateScrollDistance", "offset", "size", "containerSize", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface BringIntoViewSpec {

    public static final androidx.compose.foundation.gestures.BringIntoViewSpec.Companion Companion;

    @Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0008\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u000c\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0000¢\u0006\u0002\u0008\u0010R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000b¨\u0006\u0011", d2 = {"Landroidx/compose/foundation/gestures/BringIntoViewSpec$Companion;", "", "()V", "DefaultBringIntoViewSpec", "Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "getDefaultBringIntoViewSpec$foundation_release", "()Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "DefaultScrollAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "getDefaultScrollAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "defaultCalculateScrollDistance", "offset", "size", "containerSize", "defaultCalculateScrollDistance$foundation_release", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {

        static final androidx.compose.foundation.gestures.BringIntoViewSpec.Companion $$INSTANCE;
        private static final androidx.compose.foundation.gestures.BringIntoViewSpec DefaultBringIntoViewSpec;
        private static final AnimationSpec<Float> DefaultScrollAnimationSpec;
        static {
            BringIntoViewSpec.Companion companion = new BringIntoViewSpec.Companion();
            BringIntoViewSpec.Companion.$$INSTANCE = companion;
            int i = 0;
            final int i3 = 0;
            BringIntoViewSpec.Companion.DefaultScrollAnimationSpec = (AnimationSpec)AnimationSpecKt.spring$default(i3, i3, i, 7, i);
            BringIntoViewSpec.Companion.DefaultBringIntoViewSpec.1 anon = new BringIntoViewSpec.Companion.DefaultBringIntoViewSpec.1();
            BringIntoViewSpec.Companion.DefaultBringIntoViewSpec = (BringIntoViewSpec)anon;
        }

        public final float defaultCalculateScrollDistance$foundation_release(float offset, float size, float containerSize) {
            int i;
            int cmp;
            final int i2 = offset + size;
            final int i3 = offset;
            i = 0;
            if (Float.compare(i3, i) >= 0 && Float.compare(i2, containerSize) <= 0) {
                if (Float.compare(i2, containerSize) <= 0) {
                } else {
                    if (Float.compare(i3, i) < 0 && Float.compare(i2, containerSize) > 0) {
                        if (Float.compare(i2, containerSize) > 0) {
                        } else {
                            i = Float.compare(f, cmp) < 0 ? i3 : i2 - containerSize;
                        }
                    } else {
                    }
                }
            } else {
            }
            return i;
        }

        public final androidx.compose.foundation.gestures.BringIntoViewSpec getDefaultBringIntoViewSpec$foundation_release() {
            return BringIntoViewSpec.Companion.DefaultBringIntoViewSpec;
        }

        public final AnimationSpec<Float> getDefaultScrollAnimationSpec() {
            return BringIntoViewSpec.Companion.DefaultScrollAnimationSpec;
        }
    }
    static {
        BringIntoViewSpec.Companion = BringIntoViewSpec.Companion.$$INSTANCE;
    }

    public float calculateScrollDistance(float offset, float size, float containerSize) {
        return BringIntoViewSpec.Companion.defaultCalculateScrollDistance$foundation_release(offset, size, containerSize);
    }

    public AnimationSpec<Float> getScrollAnimationSpec() {
        return BringIntoViewSpec.Companion.getDefaultScrollAnimationSpec();
    }
}
