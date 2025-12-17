package androidx.compose.animation;

import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u00087\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007\u0008\u0004¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0007\u001a\u00020\u00082\u0008\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0008\u0010\n\u001a\u00020\u000bH\u0016J\u0011\u0010\u000c\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0000H\u0087\u0002J\u0008\u0010\u000e\u001a\u00020\u000fH\u0016R\u0012\u0010\u0003\u001a\u00020\u0004X \u0004¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006\u0082\u0001\u0001\u0011¨\u0006\u0012", d2 = {"Landroidx/compose/animation/ExitTransition;", "", "()V", "data", "Landroidx/compose/animation/TransitionData;", "getData$animation_release", "()Landroidx/compose/animation/TransitionData;", "equals", "", "other", "hashCode", "", "plus", "exit", "toString", "", "Companion", "Landroidx/compose/animation/ExitTransitionImpl;", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class ExitTransition {

    public static final int $stable;
    public static final androidx.compose.animation.ExitTransition.Companion Companion;
    private static final androidx.compose.animation.ExitTransition KeepUntilTransitionsFinished;
    private static final androidx.compose.animation.ExitTransition None;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0006¨\u0006\t", d2 = {"Landroidx/compose/animation/ExitTransition$Companion;", "", "()V", "KeepUntilTransitionsFinished", "Landroidx/compose/animation/ExitTransition;", "getKeepUntilTransitionsFinished$animation_release", "()Landroidx/compose/animation/ExitTransition;", "None", "getNone", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final androidx.compose.animation.ExitTransition getKeepUntilTransitionsFinished$animation_release() {
            return ExitTransition.access$getKeepUntilTransitionsFinished$cp();
        }

        public final androidx.compose.animation.ExitTransition getNone() {
            return ExitTransition.access$getNone$cp();
        }
    }
    static {
        ExitTransition.Companion companion = new ExitTransition.Companion(0);
        ExitTransition.Companion = companion;
        final int i11 = 0;
        final int i2 = 0;
        final int i3 = 0;
        final int i4 = 0;
        final int i5 = 0;
        final int i8 = 0;
        TransitionData transitionData = new TransitionData(i2, i3, i4, i5, 0, i8, 63, i11);
        ExitTransitionImpl exitTransitionImpl = new ExitTransitionImpl(transitionData);
        ExitTransition.None = (ExitTransition)exitTransitionImpl;
        TransitionData transitionData2 = new TransitionData(i2, i3, i4, i5, 1, i8, 47, i11);
        ExitTransitionImpl exitTransitionImpl2 = new ExitTransitionImpl(transitionData2);
        ExitTransition.KeepUntilTransitionsFinished = (ExitTransition)exitTransitionImpl2;
    }

    public ExitTransition(DefaultConstructorMarker defaultConstructorMarker) {
        super();
    }

    public static final androidx.compose.animation.ExitTransition access$getKeepUntilTransitionsFinished$cp() {
        return ExitTransition.KeepUntilTransitionsFinished;
    }

    public static final androidx.compose.animation.ExitTransition access$getNone$cp() {
        return ExitTransition.None;
    }

    public boolean equals(Object other) {
        boolean equal;
        int i;
        androidx.compose.animation.TransitionData data$animation_release;
        if (other instanceof ExitTransition && Intrinsics.areEqual((ExitTransition)other.getData$animation_release(), getData$animation_release())) {
            i = Intrinsics.areEqual((ExitTransition)other.getData$animation_release(), getData$animation_release()) ? 1 : 0;
        } else {
        }
        return i;
    }

    public abstract androidx.compose.animation.TransitionData getData$animation_release();

    public int hashCode() {
        return getData$animation_release().hashCode();
    }

    public final androidx.compose.animation.ExitTransition plus(androidx.compose.animation.ExitTransition exit) {
        androidx.compose.animation.Fade fade;
        androidx.compose.animation.Slide slide;
        androidx.compose.animation.ChangeSize changeSize;
        androidx.compose.animation.Scale scale;
        int i;
        boolean hold;
        if (exit.getData$animation_release().getFade() == null) {
            fade = getData$animation_release().getFade();
        }
        if (exit.getData$animation_release().getSlide() == null) {
            slide = getData$animation_release().getSlide();
        }
        if (exit.getData$animation_release().getChangeSize() == null) {
            changeSize = getData$animation_release().getChangeSize();
        }
        if (exit.getData$animation_release().getScale() == null) {
            scale = getData$animation_release().getScale();
        }
        if (!exit.getData$animation_release().getHold()) {
            if (getData$animation_release().getHold()) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        TransitionData transitionData = new TransitionData(fade, slide, changeSize, scale, i, MapsKt.plus(getData$animation_release().getEffectsMap(), exit.getData$animation_release().getEffectsMap()));
        ExitTransitionImpl exitTransitionImpl = new ExitTransitionImpl(transitionData);
        return (ExitTransition)exitTransitionImpl;
    }

    public String toString() {
        String $this$toString_u24lambda_u240;
        int i;
        StringBuilder append;
        int string3;
        int string4;
        String string2;
        boolean hold;
        int string;
        if (Intrinsics.areEqual(this, ExitTransition.None)) {
            $this$toString_u24lambda_u240 = "ExitTransition.None";
        } else {
            if (Intrinsics.areEqual(this, ExitTransition.KeepUntilTransitionsFinished)) {
                $this$toString_u24lambda_u240 = "ExitTransition.KeepUntilTransitionsFinished";
            } else {
                androidx.compose.animation.TransitionData data$animation_release = getData$animation_release();
                i = 0;
                StringBuilder stringBuilder = new StringBuilder();
                androidx.compose.animation.Fade fade = data$animation_release.getFade();
                string = 0;
                if (fade != null) {
                    string3 = fade.toString();
                } else {
                    string3 = string;
                }
                androidx.compose.animation.Slide slide = data$animation_release.getSlide();
                if (slide != null) {
                    string4 = slide.toString();
                } else {
                    string4 = string;
                }
                androidx.compose.animation.ChangeSize changeSize = data$animation_release.getChangeSize();
                if (changeSize != null) {
                    string2 = changeSize.toString();
                } else {
                    string2 = string;
                }
                androidx.compose.animation.Scale scale = data$animation_release.getScale();
                if (scale != null) {
                    string = scale.toString();
                }
                $this$toString_u24lambda_u240 = stringBuilder.append("ExitTransition: \nFade - ").append(string3).append(",\nSlide - ").append(string4).append(",\nShrink - ").append(string2).append(",\nScale - ").append(string).append(",\nKeepUntilTransitionsFinished - ").append(data$animation_release.getHold()).toString();
            }
        }
        return $this$toString_u24lambda_u240;
    }
}
