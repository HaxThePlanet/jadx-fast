package androidx.compose.animation;

import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u00087\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007\u0008\u0004¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0007\u001a\u00020\u00082\u0008\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0008\u0010\n\u001a\u00020\u000bH\u0016J\u0011\u0010\u000c\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0000H\u0087\u0002J\u0008\u0010\u000e\u001a\u00020\u000fH\u0016R\u0012\u0010\u0003\u001a\u00020\u0004X \u0004¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006\u0082\u0001\u0001\u0011¨\u0006\u0012", d2 = {"Landroidx/compose/animation/EnterTransition;", "", "()V", "data", "Landroidx/compose/animation/TransitionData;", "getData$animation_release", "()Landroidx/compose/animation/TransitionData;", "equals", "", "other", "hashCode", "", "plus", "enter", "toString", "", "Companion", "Landroidx/compose/animation/EnterTransitionImpl;", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class EnterTransition {

    public static final int $stable;
    public static final androidx.compose.animation.EnterTransition.Companion Companion;
    private static final androidx.compose.animation.EnterTransition None;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Landroidx/compose/animation/EnterTransition$Companion;", "", "()V", "None", "Landroidx/compose/animation/EnterTransition;", "getNone", "()Landroidx/compose/animation/EnterTransition;", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final androidx.compose.animation.EnterTransition getNone() {
            return EnterTransition.access$getNone$cp();
        }
    }
    static {
        EnterTransition.Companion companion = new EnterTransition.Companion(0);
        EnterTransition.Companion = companion;
        TransitionData transitionData = new TransitionData(0, 0, 0, 0, 0, 0, 63, 0);
        EnterTransitionImpl enterTransitionImpl = new EnterTransitionImpl(transitionData);
        EnterTransition.None = (EnterTransition)enterTransitionImpl;
    }

    public EnterTransition(DefaultConstructorMarker defaultConstructorMarker) {
        super();
    }

    public static final androidx.compose.animation.EnterTransition access$getNone$cp() {
        return EnterTransition.None;
    }

    public boolean equals(Object other) {
        boolean equal;
        int i;
        androidx.compose.animation.TransitionData data$animation_release;
        if (other instanceof EnterTransition && Intrinsics.areEqual((EnterTransition)other.getData$animation_release(), getData$animation_release())) {
            i = Intrinsics.areEqual((EnterTransition)other.getData$animation_release(), getData$animation_release()) ? 1 : 0;
        } else {
        }
        return i;
    }

    public abstract androidx.compose.animation.TransitionData getData$animation_release();

    public int hashCode() {
        return getData$animation_release().hashCode();
    }

    public final androidx.compose.animation.EnterTransition plus(androidx.compose.animation.EnterTransition enter) {
        androidx.compose.animation.Fade fade;
        androidx.compose.animation.Slide slide;
        androidx.compose.animation.ChangeSize changeSize;
        androidx.compose.animation.Scale scale;
        if (enter.getData$animation_release().getFade() == null) {
            fade = getData$animation_release().getFade();
        }
        if (enter.getData$animation_release().getSlide() == null) {
            slide = getData$animation_release().getSlide();
        }
        if (enter.getData$animation_release().getChangeSize() == null) {
            changeSize = getData$animation_release().getChangeSize();
        }
        if (enter.getData$animation_release().getScale() == null) {
            scale = getData$animation_release().getScale();
        }
        TransitionData transitionData = new TransitionData(fade, slide, changeSize, scale, 0, MapsKt.plus(getData$animation_release().getEffectsMap(), enter.getData$animation_release().getEffectsMap()), 16, 0);
        EnterTransitionImpl enterTransitionImpl = new EnterTransitionImpl(transitionData);
        return (EnterTransition)enterTransitionImpl;
    }

    public String toString() {
        String $this$toString_u24lambda_u240;
        int i;
        StringBuilder append;
        androidx.compose.animation.Scale scale;
        String string2;
        String string3;
        String string4;
        int string;
        if (Intrinsics.areEqual(this, EnterTransition.None)) {
            $this$toString_u24lambda_u240 = "EnterTransition.None";
        } else {
            androidx.compose.animation.TransitionData data$animation_release = getData$animation_release();
            i = 0;
            StringBuilder stringBuilder = new StringBuilder();
            androidx.compose.animation.Fade fade = data$animation_release.getFade();
            string = 0;
            if (fade != null) {
                string2 = fade.toString();
            } else {
                string2 = string;
            }
            androidx.compose.animation.Slide slide = data$animation_release.getSlide();
            if (slide != null) {
                string3 = slide.toString();
            } else {
                string3 = string;
            }
            androidx.compose.animation.ChangeSize changeSize = data$animation_release.getChangeSize();
            if (changeSize != null) {
                string4 = changeSize.toString();
            } else {
                string4 = string;
            }
            scale = data$animation_release.getScale();
            if (scale != null) {
                string = scale.toString();
            }
            $this$toString_u24lambda_u240 = stringBuilder.append("EnterTransition: \nFade - ").append(string2).append(",\nSlide - ").append(string3).append(",\nShrink - ").append(string4).append(",\nScale - ").append(string).toString();
        }
        return $this$toString_u24lambda_u240;
    }
}
