package androidx.compose.material3;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.state.ToggleableState;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u001b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0010\u0008\n\u0000\u0008\u0007\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\u0008\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\u000c\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003¢\u0006\u0002\u0010\u000fJ%\u0010\u001e\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0001¢\u0006\u0004\u0008$\u0010%J%\u0010&\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0001¢\u0006\u0004\u0008'\u0010%J\u001d\u0010(\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u001f2\u0006\u0010\"\u001a\u00020#H\u0001¢\u0006\u0004\u0008)\u0010*J\u0088\u0001\u0010+\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00032\u0008\u0008\u0002\u0010\t\u001a\u00020\u00032\u0008\u0008\u0002\u0010\n\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u00032\u0008\u0008\u0002\u0010\r\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\u0008,\u0010-J\u0013\u0010.\u001a\u00020!2\u0008\u0010/\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0008\u00100\u001a\u000201H\u0016R\u0019\u0010\n\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\u0008\u0010\u0010\u0011R\u0019\u0010\u0005\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\u0008\u0013\u0010\u0011R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\u0008\u0014\u0010\u0011R\u0019\u0010\u000c\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\u0008\u0015\u0010\u0011R\u0019\u0010\u0007\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\u0008\u0016\u0010\u0011R\u0019\u0010\u000e\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\u0008\u0017\u0010\u0011R\u0019\u0010\t\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\u0008\u0018\u0010\u0011R\u0019\u0010\r\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\u0008\u0019\u0010\u0011R\u0019\u0010\u0008\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\u0008\u001a\u0010\u0011R\u0019\u0010\u000b\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\u0008\u001b\u0010\u0011R\u0019\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\u0008\u001c\u0010\u0011R\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\u0008\u001d\u0010\u0011\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u00062", d2 = {"Landroidx/compose/material3/CheckboxColors;", "", "checkedCheckmarkColor", "Landroidx/compose/ui/graphics/Color;", "uncheckedCheckmarkColor", "checkedBoxColor", "uncheckedBoxColor", "disabledCheckedBoxColor", "disabledUncheckedBoxColor", "disabledIndeterminateBoxColor", "checkedBorderColor", "uncheckedBorderColor", "disabledBorderColor", "disabledUncheckedBorderColor", "disabledIndeterminateBorderColor", "(JJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCheckedBorderColor-0d7_KjU", "()J", "J", "getCheckedBoxColor-0d7_KjU", "getCheckedCheckmarkColor-0d7_KjU", "getDisabledBorderColor-0d7_KjU", "getDisabledCheckedBoxColor-0d7_KjU", "getDisabledIndeterminateBorderColor-0d7_KjU", "getDisabledIndeterminateBoxColor-0d7_KjU", "getDisabledUncheckedBorderColor-0d7_KjU", "getDisabledUncheckedBoxColor-0d7_KjU", "getUncheckedBorderColor-0d7_KjU", "getUncheckedBoxColor-0d7_KjU", "getUncheckedCheckmarkColor-0d7_KjU", "borderColor", "Landroidx/compose/runtime/State;", "enabled", "", "state", "Landroidx/compose/ui/state/ToggleableState;", "borderColor$material3_release", "(ZLandroidx/compose/ui/state/ToggleableState;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "boxColor", "boxColor$material3_release", "checkmarkColor", "checkmarkColor$material3_release", "(Landroidx/compose/ui/state/ToggleableState;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "copy", "copy-2qZNXz8", "(JJJJJJJJJJJJ)Landroidx/compose/material3/CheckboxColors;", "equals", "other", "hashCode", "", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CheckboxColors {

    public static final int $stable;
    private final long checkedBorderColor;
    private final long checkedBoxColor;
    private final long checkedCheckmarkColor;
    private final long disabledBorderColor;
    private final long disabledCheckedBoxColor;
    private final long disabledIndeterminateBorderColor;
    private final long disabledIndeterminateBoxColor;
    private final long disabledUncheckedBorderColor;
    private final long disabledUncheckedBoxColor;
    private final long uncheckedBorderColor;
    private final long uncheckedBoxColor;
    private final long uncheckedCheckmarkColor;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int ordinal3;
            int ordinal;
            int ordinal2;
            int[] iArr = new int[values.length];
            iArr[ToggleableState.On.ordinal()] = 1;
            iArr[ToggleableState.Indeterminate.ordinal()] = 2;
            iArr[ToggleableState.Off.ordinal()] = 3;
            CheckboxColors.WhenMappings.$EnumSwitchMapping$0 = iArr;
        }
    }
    static {
    }

    private CheckboxColors(long checkedCheckmarkColor, long uncheckedCheckmarkColor, long checkedBoxColor, long uncheckedBoxColor, long disabledCheckedBoxColor, long disabledUncheckedBoxColor, long disabledIndeterminateBoxColor, long checkedBorderColor, long uncheckedBorderColor, long disabledBorderColor, long disabledUncheckedBorderColor, long disabledIndeterminateBorderColor) {
        super();
        this.checkedCheckmarkColor = checkedCheckmarkColor;
        this.uncheckedCheckmarkColor = checkedBoxColor;
        this.checkedBoxColor = disabledCheckedBoxColor;
        this.uncheckedBoxColor = disabledIndeterminateBoxColor;
        this.disabledCheckedBoxColor = uncheckedBorderColor;
        this.disabledUncheckedBoxColor = disabledUncheckedBorderColor;
        this.disabledIndeterminateBoxColor = obj27;
        this.checkedBorderColor = obj29;
        this.uncheckedBorderColor = obj31;
        this.disabledBorderColor = obj33;
        this.disabledUncheckedBorderColor = obj35;
        this.disabledIndeterminateBorderColor = obj37;
    }

    public CheckboxColors(long l, long l2, long l3, long l4, long l5, long l6, long l7, long l8, long l9, long l10, long l11, long l12, DefaultConstructorMarker defaultConstructorMarker13) {
        super(l, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, defaultConstructorMarker13, obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21, obj22, obj23, obj24);
    }

    public static androidx.compose.material3.CheckboxColors copy-2qZNXz8$default(androidx.compose.material3.CheckboxColors checkboxColors, long l2, long l3, long l4, long l5, long l6, long l7, long l8, long l9, long l10, long l11, long l12, long l13, int i14, Object object15) {
        long disabledIndeterminateBorderColor;
        long checkedCheckmarkColor;
        long checkedBorderColor;
        long uncheckedBorderColor;
        long disabledBorderColor;
        long disabledUncheckedBorderColor;
        long uncheckedCheckmarkColor;
        long checkedBoxColor;
        long uncheckedBoxColor;
        long disabledCheckedBoxColor;
        long disabledUncheckedBoxColor;
        long disabledIndeterminateBoxColor;
        long obj25;
        Object obj = checkboxColors;
        int i = obj43;
        checkedCheckmarkColor = i & 1 != 0 ? obj.checkedCheckmarkColor : l2;
        uncheckedCheckmarkColor = i & 2 != 0 ? obj.uncheckedCheckmarkColor : l4;
        checkedBoxColor = i & 4 != 0 ? obj.checkedBoxColor : l6;
        uncheckedBoxColor = i & 8 != 0 ? obj.uncheckedBoxColor : l8;
        disabledCheckedBoxColor = i & 16 != 0 ? obj.disabledCheckedBoxColor : l10;
        disabledUncheckedBoxColor = i & 32 != 0 ? obj.disabledUncheckedBoxColor : l12;
        disabledIndeterminateBoxColor = i & 64 != 0 ? obj.disabledIndeterminateBoxColor : i14;
        checkedBorderColor = i & 128 != 0 ? obj.checkedBorderColor : obj33;
        uncheckedBorderColor = i & 256 != 0 ? obj.uncheckedBorderColor : obj35;
        final long obj21 = uncheckedBorderColor;
        disabledBorderColor = i & 512 != 0 ? obj.disabledBorderColor : obj37;
        final long obj23 = disabledBorderColor;
        disabledUncheckedBorderColor = i & 1024 != 0 ? obj.disabledUncheckedBorderColor : obj39;
        disabledIndeterminateBorderColor = i &= 2048 != 0 ? obj.disabledIndeterminateBorderColor : obj41;
        return obj.copy-2qZNXz8(checkedCheckmarkColor, obj21, uncheckedCheckmarkColor, obj23, checkedBoxColor, obj25, uncheckedBoxColor, l10, disabledCheckedBoxColor, l12, disabledUncheckedBoxColor, i14);
    }

    public final State<Color> borderColor$material3_release(boolean enabled, ToggleableState state, Composer $composer, int $changed) {
        long uncheckedBorderColor;
        int tween$default;
        boolean traceInProgress;
        int ordinal;
        String str;
        androidx.compose.animation.core.TweenSpec tweenSpec;
        int i2;
        int i3;
        Composer $composer2;
        int i4;
        int i;
        State obj13;
        int i5 = 1009643462;
        ComposerKt.sourceInformationMarkerStart($composer, i5, "C(borderColor):Checkbox.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i5, $changed, -1, "androidx.compose.material3.CheckboxColors.borderColor (Checkbox.kt:534)");
        }
        if (enabled) {
            switch (i6) {
                case 1:
                    uncheckedBorderColor = this.checkedBorderColor;
                    break;
                case 2:
                    uncheckedBorderColor = this.uncheckedBorderColor;
                    break;
                default:
                    NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                    throw noWhenBranchMatchedException;
            }
            long l = uncheckedBorderColor;
            tween$default = 0;
            if (enabled) {
                $composer.startReplaceGroup(-1725816497);
                ComposerKt.sourceInformation($composer, "554@24267L61");
                ordinal = state == ToggleableState.Off ? 100 : 50;
                i2 = 0;
                $composer2 = $composer;
                obj13 = SingleValueAnimationKt.animateColorAsState-euL9pac(l, obj3, (AnimationSpec)AnimationSpecKt.tween$default(ordinal, tween$default, i2, 6, i2), i2, 0, $composer2, 0);
                $composer2.endReplaceGroup();
            } else {
                $composer2 = $composer;
                $composer2.startReplaceGroup(-1725635953);
                ComposerKt.sourceInformation($composer2, "556@24358L28");
                obj13 = SnapshotStateKt.rememberUpdatedState(Color.box-impl(l), $composer2, tween$default);
                $composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            return obj13;
        }
        switch (i7) {
            case 1:
                uncheckedBorderColor = this.disabledBorderColor;
                break;
            case 2:
                uncheckedBorderColor = this.disabledIndeterminateBorderColor;
                break;
            case 3:
                uncheckedBorderColor = this.disabledUncheckedBorderColor;
                break;
            default:
                Composer composer = $composer;
                obj13 = new NoWhenBranchMatchedException();
                throw obj13;
        }
    }

    public final State<Color> boxColor$material3_release(boolean enabled, ToggleableState state, Composer $composer, int $changed) {
        long disabledCheckedBoxColor;
        int tween$default;
        boolean traceInProgress;
        int ordinal;
        String str;
        androidx.compose.animation.core.TweenSpec tweenSpec;
        int i2;
        int i3;
        Composer $composer2;
        int i4;
        int i;
        State obj13;
        int i5 = 360729865;
        ComposerKt.sourceInformationMarkerStart($composer, i5, "C(boxColor):Checkbox.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i5, $changed, -1, "androidx.compose.material3.CheckboxColors.boxColor (Checkbox.kt:501)");
        }
        if (enabled) {
            switch (i6) {
                case 1:
                    disabledCheckedBoxColor = this.checkedBoxColor;
                    break;
                case 2:
                    disabledCheckedBoxColor = this.uncheckedBoxColor;
                    break;
                default:
                    NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                    throw noWhenBranchMatchedException;
            }
            long l = disabledCheckedBoxColor;
            tween$default = 0;
            if (enabled) {
                $composer.startReplaceGroup(-392211906);
                ComposerKt.sourceInformation($composer, "521@22941L61");
                ordinal = state == ToggleableState.Off ? 100 : 50;
                i2 = 0;
                $composer2 = $composer;
                obj13 = SingleValueAnimationKt.animateColorAsState-euL9pac(l, obj3, (AnimationSpec)AnimationSpecKt.tween$default(ordinal, tween$default, i2, 6, i2), i2, 0, $composer2, 0);
                $composer2.endReplaceGroup();
            } else {
                $composer2 = $composer;
                $composer2.startReplaceGroup(-392031362);
                ComposerKt.sourceInformation($composer2, "523@23032L28");
                obj13 = SnapshotStateKt.rememberUpdatedState(Color.box-impl(l), $composer2, tween$default);
                $composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            return obj13;
        }
        switch (i7) {
            case 1:
                disabledCheckedBoxColor = this.disabledCheckedBoxColor;
                break;
            case 2:
                disabledCheckedBoxColor = this.disabledIndeterminateBoxColor;
                break;
            case 3:
                disabledCheckedBoxColor = this.disabledUncheckedBoxColor;
                break;
            default:
                Composer composer = $composer;
                obj13 = new NoWhenBranchMatchedException();
                throw obj13;
        }
    }

    public final State<Color> checkmarkColor$material3_release(ToggleableState state, Composer $composer, int $changed) {
        long uncheckedCheckmarkColor;
        int i;
        boolean traceInProgress;
        String str;
        int i2 = -507585681;
        ComposerKt.sourceInformationMarkerStart($composer, i2, "C(checkmarkColor)490@21677L61:Checkbox.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i2, $changed, -1, "androidx.compose.material3.CheckboxColors.checkmarkColor (Checkbox.kt:481)");
        }
        uncheckedCheckmarkColor = state == ToggleableState.Off ? this.uncheckedCheckmarkColor : this.checkedCheckmarkColor;
        i = state == ToggleableState.Off ? 100 : 50;
        final int i5 = 0;
        final Composer composer = $composer;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return SingleValueAnimationKt.animateColorAsState-euL9pac(uncheckedCheckmarkColor, obj3, (AnimationSpec)AnimationSpecKt.tween$default(i, 0, i5, 6, i5), i5, 0, composer, 0);
    }

    public final androidx.compose.material3.CheckboxColors copy-2qZNXz8(long checkedCheckmarkColor, long uncheckedCheckmarkColor, long checkedBoxColor, long uncheckedBoxColor, long disabledCheckedBoxColor, long disabledUncheckedBoxColor, long disabledIndeterminateBoxColor, long checkedBorderColor, long uncheckedBorderColor, long disabledBorderColor, long disabledUncheckedBorderColor, long disabledIndeterminateBorderColor) {
        int $i$a$TakeOrElseDxMtmZcCheckboxColors$copy$1;
        int $i$a$TakeOrElseDxMtmZcCheckboxColors$copy$2;
        int $i$a$TakeOrElseDxMtmZcCheckboxColors$copy$3;
        int $i$a$TakeOrElseDxMtmZcCheckboxColors$copy$4;
        int $this$isSpecified$iv$iv;
        int $this$isSpecified$iv$iv4;
        int $this$isSpecified$iv$iv6;
        int $this$isSpecified$iv$iv5;
        int $this$isSpecified$iv$iv3;
        int $this$isSpecified$iv$iv2;
        int $this$isSpecified$iv$iv7;
        long $i$a$TakeOrElseDxMtmZcCheckboxColors$copy$12;
        int i;
        long l10;
        long l11;
        long l2;
        long l6;
        long l12;
        long l7;
        long l3;
        long l;
        long l4;
        long l5;
        long l8;
        long l9;
        final Object obj = this;
        int i2 = checkedCheckmarkColor;
        int i3 = 0;
        int i38 = 0;
        int i50 = 16;
        i = 1;
        final int i51 = 0;
        $i$a$TakeOrElseDxMtmZcCheckboxColors$copy$1 = Long.compare(i15, i50) != 0 ? i : i51;
        if ($i$a$TakeOrElseDxMtmZcCheckboxColors$copy$1 != 0) {
            l10 = i2;
        } else {
            int i37 = 0;
            l10 = $i$a$TakeOrElseDxMtmZcCheckboxColors$copy$1;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv = checkedBoxColor;
        int i4 = 0;
        int i39 = 0;
        $i$a$TakeOrElseDxMtmZcCheckboxColors$copy$2 = Long.compare(i16, i50) != 0 ? i : i51;
        if ($i$a$TakeOrElseDxMtmZcCheckboxColors$copy$2 != 0) {
            l11 = $this$takeOrElse_u2dDxMtmZc$iv;
        } else {
            int i36 = 0;
            l11 = $i$a$TakeOrElseDxMtmZcCheckboxColors$copy$2;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv2 = disabledCheckedBoxColor;
        int i5 = 0;
        int i40 = 0;
        $i$a$TakeOrElseDxMtmZcCheckboxColors$copy$3 = Long.compare(i17, i50) != 0 ? i : i51;
        if ($i$a$TakeOrElseDxMtmZcCheckboxColors$copy$3 != 0) {
            l2 = $this$takeOrElse_u2dDxMtmZc$iv2;
        } else {
            int i35 = 0;
            l2 = $i$a$TakeOrElseDxMtmZcCheckboxColors$copy$3;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv3 = disabledIndeterminateBoxColor;
        int i6 = 0;
        int i41 = 0;
        $i$a$TakeOrElseDxMtmZcCheckboxColors$copy$4 = Long.compare(i18, i50) != 0 ? i : i51;
        if ($i$a$TakeOrElseDxMtmZcCheckboxColors$copy$4 != 0) {
            l6 = $this$takeOrElse_u2dDxMtmZc$iv3;
        } else {
            int i34 = 0;
            l6 = $i$a$TakeOrElseDxMtmZcCheckboxColors$copy$4;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv4 = uncheckedBorderColor;
        int i7 = 0;
        int i42 = 0;
        $this$isSpecified$iv$iv = Long.compare(i19, i50) != 0 ? i : i51;
        if ($this$isSpecified$iv$iv != 0) {
            l12 = $this$takeOrElse_u2dDxMtmZc$iv4;
        } else {
            int i33 = 0;
            l12 = $this$isSpecified$iv$iv;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv5 = disabledUncheckedBorderColor;
        int i8 = 0;
        int i43 = 0;
        $this$isSpecified$iv$iv4 = Long.compare(i20, i50) != 0 ? i : i51;
        if ($this$isSpecified$iv$iv4 != 0) {
            l7 = $this$takeOrElse_u2dDxMtmZc$iv5;
        } else {
            int i32 = 0;
            l7 = $this$isSpecified$iv$iv4;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv6 = obj51;
        int i9 = 0;
        int i44 = 0;
        $this$isSpecified$iv$iv6 = Long.compare(i21, i50) != 0 ? i : i51;
        if ($this$isSpecified$iv$iv6 != 0) {
            l3 = $this$takeOrElse_u2dDxMtmZc$iv6;
        } else {
            int i31 = 0;
            l3 = $this$isSpecified$iv$iv6;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv7 = obj53;
        int i10 = 0;
        int i45 = 0;
        $this$isSpecified$iv$iv5 = Long.compare(i22, i50) != 0 ? i : i51;
        if ($this$isSpecified$iv$iv5 != 0) {
            l = $this$takeOrElse_u2dDxMtmZc$iv7;
        } else {
            int i30 = 0;
            l = $this$isSpecified$iv$iv5;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv8 = obj55;
        int i11 = 0;
        int i46 = 0;
        $this$isSpecified$iv$iv3 = Long.compare(i23, i50) != 0 ? i : i51;
        if ($this$isSpecified$iv$iv3 != 0) {
            l4 = $this$takeOrElse_u2dDxMtmZc$iv8;
        } else {
            int i29 = 0;
            l4 = $this$isSpecified$iv$iv3;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv9 = obj57;
        int i12 = 0;
        int i47 = 0;
        $this$isSpecified$iv$iv2 = Long.compare(i24, i50) != 0 ? i : i51;
        if ($this$isSpecified$iv$iv2 != 0) {
            l5 = $this$takeOrElse_u2dDxMtmZc$iv9;
        } else {
            int i28 = 0;
            l5 = $this$isSpecified$iv$iv2;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv10 = obj59;
        int i13 = 0;
        int i48 = 0;
        $this$isSpecified$iv$iv7 = Long.compare(i25, i50) != 0 ? i : i51;
        if ($this$isSpecified$iv$iv7 != 0) {
            l8 = $this$takeOrElse_u2dDxMtmZc$iv10;
        } else {
            int i27 = 0;
            l8 = $this$isSpecified$iv$iv7;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv11 = obj61;
        int i14 = 0;
        int i49 = 0;
        if (Long.compare($i$a$TakeOrElseDxMtmZcCheckboxColors$copy$12, i50) != 0) {
        } else {
            i = i51;
        }
        if (i != 0) {
            l9 = $this$takeOrElse_u2dDxMtmZc$iv11;
        } else {
            int i26 = 0;
            l9 = $i$a$TakeOrElseDxMtmZcCheckboxColors$copy$12;
        }
        CheckboxColors checkboxColors = new CheckboxColors(l10, obj14, l11, obj16, l2, obj18, l6, obj20, l12, obj22, l7, obj24, l3, obj26, l, obj28, l4, obj30, l5, obj32, l8, obj34, l9, obj36, 0);
        return checkboxColors;
    }

    public boolean equals(Object other) {
        boolean z;
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (other != null) {
            if (!other instanceof CheckboxColors) {
            } else {
                if (!Color.equals-impl0(this.checkedCheckmarkColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.uncheckedCheckmarkColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.checkedBoxColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.uncheckedBoxColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.disabledCheckedBoxColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.disabledUncheckedBoxColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.disabledIndeterminateBoxColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.checkedBorderColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.uncheckedBorderColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.disabledBorderColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.disabledUncheckedBorderColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.disabledIndeterminateBorderColor, obj3)) {
                    return i2;
                }
            }
            return i;
        }
        return i2;
    }

    public final long getCheckedBorderColor-0d7_KjU() {
        return this.checkedBorderColor;
    }

    public final long getCheckedBoxColor-0d7_KjU() {
        return this.checkedBoxColor;
    }

    public final long getCheckedCheckmarkColor-0d7_KjU() {
        return this.checkedCheckmarkColor;
    }

    public final long getDisabledBorderColor-0d7_KjU() {
        return this.disabledBorderColor;
    }

    public final long getDisabledCheckedBoxColor-0d7_KjU() {
        return this.disabledCheckedBoxColor;
    }

    public final long getDisabledIndeterminateBorderColor-0d7_KjU() {
        return this.disabledIndeterminateBorderColor;
    }

    public final long getDisabledIndeterminateBoxColor-0d7_KjU() {
        return this.disabledIndeterminateBoxColor;
    }

    public final long getDisabledUncheckedBorderColor-0d7_KjU() {
        return this.disabledUncheckedBorderColor;
    }

    public final long getDisabledUncheckedBoxColor-0d7_KjU() {
        return this.disabledUncheckedBoxColor;
    }

    public final long getUncheckedBorderColor-0d7_KjU() {
        return this.uncheckedBorderColor;
    }

    public final long getUncheckedBoxColor-0d7_KjU() {
        return this.uncheckedBoxColor;
    }

    public final long getUncheckedCheckmarkColor-0d7_KjU() {
        return this.uncheckedCheckmarkColor;
    }

    public int hashCode() {
        return result10 += i24;
    }
}
