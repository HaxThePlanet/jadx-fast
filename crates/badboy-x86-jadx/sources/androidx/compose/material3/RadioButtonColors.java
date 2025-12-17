package androidx.compose.material3;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000e\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J8\u0010\u000e\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\u0008\u000f\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0008\u0010\u0014\u001a\u00020\u0015H\u0016J%\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u00172\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0012H\u0001¢\u0006\u0004\u0008\u001a\u0010\u001bR\u0019\u0010\u0005\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\n\u001a\u0004\u0008\u0008\u0010\tR\u0019\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\n\u001a\u0004\u0008\u000b\u0010\tR\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\n\u001a\u0004\u0008\u000c\u0010\tR\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\n\u001a\u0004\u0008\r\u0010\t\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u001c", d2 = {"Landroidx/compose/material3/RadioButtonColors;", "", "selectedColor", "Landroidx/compose/ui/graphics/Color;", "unselectedColor", "disabledSelectedColor", "disabledUnselectedColor", "(JJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getDisabledSelectedColor-0d7_KjU", "()J", "J", "getDisabledUnselectedColor-0d7_KjU", "getSelectedColor-0d7_KjU", "getUnselectedColor-0d7_KjU", "copy", "copy-jRlVdoo", "(JJJJ)Landroidx/compose/material3/RadioButtonColors;", "equals", "", "other", "hashCode", "", "radioColor", "Landroidx/compose/runtime/State;", "enabled", "selected", "radioColor$material3_release", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RadioButtonColors {

    public static final int $stable;
    private final long disabledSelectedColor;
    private final long disabledUnselectedColor;
    private final long selectedColor;
    private final long unselectedColor;
    static {
    }

    private RadioButtonColors(long selectedColor, long unselectedColor, long disabledSelectedColor, long disabledUnselectedColor) {
        super();
        this.selectedColor = selectedColor;
        this.unselectedColor = disabledSelectedColor;
        this.disabledSelectedColor = obj5;
        this.disabledUnselectedColor = obj7;
    }

    public RadioButtonColors(long l, long l2, long l3, long l4, DefaultConstructorMarker defaultConstructorMarker5) {
        super(l, l2, l3, l4, defaultConstructorMarker5, obj6, obj7, obj8);
    }

    public static androidx.compose.material3.RadioButtonColors copy-jRlVdoo$default(androidx.compose.material3.RadioButtonColors radioButtonColors, long l2, long l3, long l4, long l5, int i6, Object object7) {
        long l6;
        long l8;
        long l7;
        long l;
        long obj10;
        long obj12;
        long obj14;
        l6 = obj18 & 1 != 0 ? obj10 : l2;
        l8 = obj18 & 2 != 0 ? obj12 : l4;
        l7 = obj18 & 4 != 0 ? obj14 : i6;
        l = obj18 & 8 != 0 ? obj10 : obj16;
        return radioButtonColors.copy-jRlVdoo(l6, obj2, l8, obj4);
    }

    public final androidx.compose.material3.RadioButtonColors copy-jRlVdoo(long selectedColor, long unselectedColor, long disabledSelectedColor, long disabledUnselectedColor) {
        int $i$a$TakeOrElseDxMtmZcRadioButtonColors$copy$1;
        int $i$a$TakeOrElseDxMtmZcRadioButtonColors$copy$2;
        int $this$isSpecified$iv$iv;
        int $i$a$TakeOrElseDxMtmZcRadioButtonColors$copy$4;
        int i;
        long l;
        long l3;
        long l2;
        long i2;
        final Object obj = this;
        int i3 = selectedColor;
        int i4 = 0;
        int i15 = 0;
        int i19 = 16;
        i = 1;
        final int i20 = 0;
        $i$a$TakeOrElseDxMtmZcRadioButtonColors$copy$1 = Long.compare(i8, i19) != 0 ? i : i20;
        if ($i$a$TakeOrElseDxMtmZcRadioButtonColors$copy$1 != 0) {
            l = i3;
        } else {
            int i14 = 0;
            l = $i$a$TakeOrElseDxMtmZcRadioButtonColors$copy$1;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv = disabledSelectedColor;
        int i5 = 0;
        int i16 = 0;
        $i$a$TakeOrElseDxMtmZcRadioButtonColors$copy$2 = Long.compare(i9, i19) != 0 ? i : i20;
        if ($i$a$TakeOrElseDxMtmZcRadioButtonColors$copy$2 != 0) {
            l3 = $this$takeOrElse_u2dDxMtmZc$iv;
        } else {
            int i10 = 0;
            l3 = $i$a$TakeOrElseDxMtmZcRadioButtonColors$copy$2;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv2 = obj27;
        int i6 = 0;
        int i17 = 0;
        $this$isSpecified$iv$iv = Long.compare(i11, i19) != 0 ? i : i20;
        if ($this$isSpecified$iv$iv != 0) {
            l2 = $this$takeOrElse_u2dDxMtmZc$iv2;
        } else {
            int i12 = 0;
            l2 = $this$isSpecified$iv$iv;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv3 = obj29;
        int i7 = 0;
        int i18 = 0;
        if (Long.compare($i$a$TakeOrElseDxMtmZcRadioButtonColors$copy$4, i19) != 0) {
        } else {
            i = i20;
        }
        if (i != 0) {
            i2 = $this$takeOrElse_u2dDxMtmZc$iv3;
        } else {
            int i13 = 0;
            i2 = $i$a$TakeOrElseDxMtmZcRadioButtonColors$copy$4;
        }
        RadioButtonColors radioButtonColors = new RadioButtonColors(l, obj14, l3, obj16, l2, obj18, i2, obj20, 0);
        return radioButtonColors;
    }

    public boolean equals(Object other) {
        boolean z;
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (other != null) {
            if (!other instanceof RadioButtonColors) {
            } else {
                if (!Color.equals-impl0(this.selectedColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.unselectedColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.disabledSelectedColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.disabledUnselectedColor, obj3)) {
                    return i2;
                }
            }
            return i;
        }
        return i2;
    }

    public final long getDisabledSelectedColor-0d7_KjU() {
        return this.disabledSelectedColor;
    }

    public final long getDisabledUnselectedColor-0d7_KjU() {
        return this.disabledUnselectedColor;
    }

    public final long getSelectedColor-0d7_KjU() {
        return this.selectedColor;
    }

    public final long getUnselectedColor-0d7_KjU() {
        return this.unselectedColor;
    }

    public int hashCode() {
        return result2 += i8;
    }

    public final State<Color> radioColor$material3_release(boolean enabled, boolean selected, Composer $composer, int $changed) {
        long disabledUnselectedColor;
        int tween$default;
        boolean traceInProgress;
        String str;
        androidx.compose.animation.core.TweenSpec tweenSpec;
        int i4;
        int i;
        Composer $composer2;
        int i3;
        int i2;
        State obj13;
        int i5 = -1840145292;
        ComposerKt.sourceInformationMarkerStart($composer, i5, "C(radioColor):RadioButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i5, $changed, -1, "androidx.compose.material3.RadioButtonColors.radioColor (RadioButton.kt:228)");
        }
        if (enabled && selected) {
            if (selected) {
                disabledUnselectedColor = this.selectedColor;
            } else {
                if (enabled && !selected) {
                    if (!selected) {
                        disabledUnselectedColor = this.unselectedColor;
                    } else {
                        if (!enabled && selected) {
                            disabledUnselectedColor = selected ? this.disabledSelectedColor : this.disabledUnselectedColor;
                        } else {
                        }
                    }
                } else {
                }
            }
        } else {
        }
        long l = disabledUnselectedColor;
        tween$default = 0;
        if (enabled) {
            $composer.startReplaceGroup(350067971);
            ComposerKt.sourceInformation($composer, "240@10272L75");
            i4 = 0;
            $composer2 = $composer;
            obj13 = SingleValueAnimationKt.animateColorAsState-euL9pac(l, obj3, (AnimationSpec)AnimationSpecKt.tween$default(100, tween$default, i4, 6, i4), i4, 0, $composer2, 48);
            $composer2.endReplaceGroup();
        } else {
            $composer2 = $composer;
            $composer2.startReplaceGroup(350170674);
            ComposerKt.sourceInformation($composer2, "242@10377L28");
            obj13 = SnapshotStateKt.rememberUpdatedState(Color.box-impl(l), $composer2, tween$default);
            $composer2.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer2);
        return obj13;
    }
}
