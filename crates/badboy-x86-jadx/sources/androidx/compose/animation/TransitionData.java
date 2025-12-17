package androidx.compose.animation;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0017\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0081\u0008\u0018\u00002\u00020\u0001BY\u0012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\t\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b\u0012\u0018\u0008\u0002\u0010\u000c\u001a\u0012\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010!\u001a\u00020\u000bHÆ\u0003J\u0019\u0010\"\u001a\u0012\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u000e\u0012\u0004\u0012\u00020\u000f0\rHÆ\u0003J]\u0010#\u001a\u00020\u00002\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0018\u0008\u0002\u0010\u000c\u001a\u0012\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u000e\u0012\u0004\u0012\u00020\u000f0\rHÆ\u0001J\u0013\u0010$\u001a\u00020\u000b2\u0008\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020)HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R!\u0010\u000c\u001a\u0012\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018R\u0013\u0010\u0008\u001a\u0004\u0018\u00010\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u001aR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u001c¨\u0006*", d2 = {"Landroidx/compose/animation/TransitionData;", "", "fade", "Landroidx/compose/animation/Fade;", "slide", "Landroidx/compose/animation/Slide;", "changeSize", "Landroidx/compose/animation/ChangeSize;", "scale", "Landroidx/compose/animation/Scale;", "hold", "", "effectsMap", "", "Landroidx/compose/animation/TransitionEffectKey;", "Landroidx/compose/animation/TransitionEffect;", "(Landroidx/compose/animation/Fade;Landroidx/compose/animation/Slide;Landroidx/compose/animation/ChangeSize;Landroidx/compose/animation/Scale;ZLjava/util/Map;)V", "getChangeSize", "()Landroidx/compose/animation/ChangeSize;", "getEffectsMap", "()Ljava/util/Map;", "getFade", "()Landroidx/compose/animation/Fade;", "getHold", "()Z", "getScale", "()Landroidx/compose/animation/Scale;", "getSlide", "()Landroidx/compose/animation/Slide;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TransitionData {

    public static final int $stable;
    private final androidx.compose.animation.ChangeSize changeSize;
    private final Map<androidx.compose.animation.TransitionEffectKey<?>, androidx.compose.animation.TransitionEffect> effectsMap;
    private final androidx.compose.animation.Fade fade;
    private final boolean hold;
    private final androidx.compose.animation.Scale scale;
    private final androidx.compose.animation.Slide slide;
    static {
    }

    public TransitionData() {
        super(0, 0, 0, 0, 0, 0, 63, 0);
    }

    public TransitionData(androidx.compose.animation.Fade fade, androidx.compose.animation.Slide slide, androidx.compose.animation.ChangeSize changeSize, androidx.compose.animation.Scale scale, boolean hold, Map<androidx.compose.animation.TransitionEffectKey<?>, ? extends androidx.compose.animation.TransitionEffect> effectsMap) {
        super();
        this.fade = fade;
        this.slide = slide;
        this.changeSize = changeSize;
        this.scale = scale;
        this.hold = hold;
        this.effectsMap = effectsMap;
    }

    public TransitionData(androidx.compose.animation.Fade fade, androidx.compose.animation.Slide slide2, androidx.compose.animation.ChangeSize changeSize3, androidx.compose.animation.Scale scale4, boolean z5, Map map6, int i7, DefaultConstructorMarker defaultConstructorMarker8) {
        int obj2;
        int obj3;
        int obj4;
        int obj5;
        int obj6;
        Map obj7;
        Map obj8;
        final int i = 0;
        obj2 = i7 & 1 != 0 ? i : obj2;
        obj3 = i7 & 2 != 0 ? i : obj3;
        obj4 = i7 & 4 != 0 ? i : obj4;
        obj5 = i7 & 8 != 0 ? i : obj5;
        obj6 = i7 & 16 != 0 ? 0 : obj6;
        if (i7 &= 32 != 0) {
            obj8 = obj7;
        } else {
            obj8 = map6;
        }
        super(obj2, obj3, obj4, obj5, obj6, obj8);
    }

    public static androidx.compose.animation.TransitionData copy$default(androidx.compose.animation.TransitionData transitionData, androidx.compose.animation.Fade fade2, androidx.compose.animation.Slide slide3, androidx.compose.animation.ChangeSize changeSize4, androidx.compose.animation.Scale scale5, boolean z6, Map map7, int i8, Object object9) {
        androidx.compose.animation.Fade obj1;
        androidx.compose.animation.Slide obj2;
        androidx.compose.animation.ChangeSize obj3;
        androidx.compose.animation.Scale obj4;
        boolean obj5;
        Map obj6;
        if (i8 & 1 != 0) {
            obj1 = transitionData.fade;
        }
        if (i8 & 2 != 0) {
            obj2 = transitionData.slide;
        }
        if (i8 & 4 != 0) {
            obj3 = transitionData.changeSize;
        }
        if (i8 & 8 != 0) {
            obj4 = transitionData.scale;
        }
        if (i8 & 16 != 0) {
            obj5 = transitionData.hold;
        }
        if (i8 &= 32 != 0) {
            obj6 = transitionData.effectsMap;
        }
        return transitionData.copy(obj1, obj2, obj3, obj4, obj5, obj6);
    }

    public final androidx.compose.animation.Fade component1() {
        return this.fade;
    }

    public final androidx.compose.animation.Slide component2() {
        return this.slide;
    }

    public final androidx.compose.animation.ChangeSize component3() {
        return this.changeSize;
    }

    public final androidx.compose.animation.Scale component4() {
        return this.scale;
    }

    public final boolean component5() {
        return this.hold;
    }

    public final Map<androidx.compose.animation.TransitionEffectKey<?>, androidx.compose.animation.TransitionEffect> component6() {
        return this.effectsMap;
    }

    public final androidx.compose.animation.TransitionData copy(androidx.compose.animation.Fade fade, androidx.compose.animation.Slide slide2, androidx.compose.animation.ChangeSize changeSize3, androidx.compose.animation.Scale scale4, boolean z5, Map<androidx.compose.animation.TransitionEffectKey<?>, ? extends androidx.compose.animation.TransitionEffect> map6) {
        TransitionData transitionData = new TransitionData(fade, slide2, changeSize3, scale4, z5, map6);
        return transitionData;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (object instanceof TransitionData == null) {
            return i2;
        }
        Object obj = object;
        if (!Intrinsics.areEqual(this.fade, obj.fade)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.slide, obj.slide)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.changeSize, obj.changeSize)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.scale, obj.scale)) {
            return i2;
        }
        if (this.hold != obj.hold) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.effectsMap, obj.effectsMap)) {
            return i2;
        }
        return i;
    }

    public final androidx.compose.animation.ChangeSize getChangeSize() {
        return this.changeSize;
    }

    public final Map<androidx.compose.animation.TransitionEffectKey<?>, androidx.compose.animation.TransitionEffect> getEffectsMap() {
        return this.effectsMap;
    }

    public final androidx.compose.animation.Fade getFade() {
        return this.fade;
    }

    public final boolean getHold() {
        return this.hold;
    }

    public final androidx.compose.animation.Scale getScale() {
        return this.scale;
    }

    public final androidx.compose.animation.Slide getSlide() {
        return this.slide;
    }

    public int hashCode() {
        int i;
        int i3;
        int i4;
        int i2;
        i3 = 0;
        if (this.fade == null) {
            i = i3;
        } else {
            i = this.fade.hashCode();
        }
        if (this.slide == null) {
            i4 = i3;
        } else {
            i4 = this.slide.hashCode();
        }
        if (this.changeSize == null) {
            i2 = i3;
        } else {
            i2 = this.changeSize.hashCode();
        }
        if (this.scale == null) {
        } else {
            i3 = this.scale.hashCode();
        }
        return i10 += i16;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("TransitionData(fade=").append(this.fade).append(", slide=").append(this.slide).append(", changeSize=").append(this.changeSize).append(", scale=").append(this.scale).append(", hold=").append(this.hold).append(", effectsMap=").append(this.effectsMap).append(')').toString();
    }
}
