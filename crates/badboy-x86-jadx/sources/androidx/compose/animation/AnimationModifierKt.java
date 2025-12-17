package androidx.compose.animation;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Alignment.Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aV\u0010\t\u001a\u00020\n*\u00020\n2\u000e\u0008\u0002\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u000c2:\u0008\u0002\u0010\r\u001a4\u0012\u0013\u0012\u00110\u0001¢\u0006\u000c\u0008\u000f\u0012\u0008\u0008\u0010\u0012\u0004\u0008\u0008(\u0011\u0012\u0013\u0012\u00110\u0001¢\u0006\u000c\u0008\u000f\u0012\u0008\u0008\u0010\u0012\u0004\u0008\u0008(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000e\u001a`\u0010\t\u001a\u00020\n*\u00020\n2\u000e\u0008\u0002\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u000c2\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00152:\u0008\u0002\u0010\r\u001a4\u0012\u0013\u0012\u00110\u0001¢\u0006\u000c\u0008\u000f\u0012\u0008\u0008\u0010\u0012\u0004\u0008\u0008(\u0011\u0012\u0013\u0012\u00110\u0001¢\u0006\u000c\u0008\u000f\u0012\u0008\u0008\u0010\u0012\u0004\u0008\u0008(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000e\"\u0016\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\u0008\u0002\u0010\u0003\"\u0018\u0010\u0005\u001a\u00020\u0006*\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\u0016", d2 = {"InvalidSize", "Landroidx/compose/ui/unit/IntSize;", "getInvalidSize", "()J", "J", "isValid", "", "isValid-ozmzZPI", "(J)Z", "animateContentSize", "Landroidx/compose/ui/Modifier;", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "finishedListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "initialValue", "targetValue", "", "alignment", "Landroidx/compose/ui/Alignment;", "animation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AnimationModifierKt {

    private static final long InvalidSize;
    static {
        int i = Integer.MIN_VALUE;
        AnimationModifierKt.InvalidSize = IntSizeKt.IntSize(i, i);
    }

    public static final Modifier animateContentSize(Modifier $this$animateContentSize, FiniteAnimationSpec<IntSize> animationSpec, Alignment alignment, Function2<? super IntSize, ? super IntSize, Unit> finishedListener) {
        SizeAnimationModifierElement sizeAnimationModifierElement = new SizeAnimationModifierElement(animationSpec, alignment, finishedListener);
        return ClipKt.clipToBounds($this$animateContentSize).then((Modifier)sizeAnimationModifierElement);
    }

    public static final Modifier animateContentSize(Modifier $this$animateContentSize, FiniteAnimationSpec<IntSize> animationSpec, Function2<? super IntSize, ? super IntSize, Unit> finishedListener) {
        SizeAnimationModifierElement sizeAnimationModifierElement = new SizeAnimationModifierElement(animationSpec, Alignment.Companion.getTopStart(), finishedListener);
        return ClipKt.clipToBounds($this$animateContentSize).then((Modifier)sizeAnimationModifierElement);
    }

    public static Modifier animateContentSize$default(Modifier modifier, FiniteAnimationSpec finiteAnimationSpec2, Alignment alignment3, Function2 function24, int i5, Object object6) {
        int i2;
        long i;
        androidx.compose.animation.core.SpringSpec obj4;
        Alignment obj5;
        int obj6;
        int obj8;
        final int i3 = 0;
        if (i5 & 1 != 0) {
            obj4 = AnimationSpecKt.spring$default(0, 1137180672, IntSize.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, i3);
        }
        if (i5 & 2 != 0) {
            obj5 = Alignment.Companion.getTopStart();
        }
        if (i5 &= 4 != 0) {
            obj6 = i3;
        }
        return AnimationModifierKt.animateContentSize(modifier, obj4, obj5, obj6);
    }

    public static Modifier animateContentSize$default(Modifier modifier, FiniteAnimationSpec finiteAnimationSpec2, Function2 function23, int i4, Object object5) {
        int i;
        long i2;
        androidx.compose.animation.core.SpringSpec obj4;
        int obj5;
        int obj7;
        final int i3 = 0;
        if (i4 & 1 != 0) {
            obj4 = AnimationSpecKt.spring$default(0, 1137180672, IntSize.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, i3);
        }
        if (i4 &= 2 != 0) {
            obj5 = i3;
        }
        return AnimationModifierKt.animateContentSize(modifier, obj4, obj5);
    }

    public static final long getInvalidSize() {
        return AnimationModifierKt.InvalidSize;
    }

    public static final boolean isValid-ozmzZPI(long $this$isValid) {
        return equals-impl0 ^= 1;
    }
}
