package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u001a;\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2!\u0010\u000c\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\u000c\u0008\u000e\u0012\u0008\u0008\u000f\u0012\u0004\u0008\u0008(\u0010\u0012\u0004\u0012\u00020\u00110\rH\u0000\u001aA\u0010\u0012\u001a\u00020\t2\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00142\u0014\u0008\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00140\r2\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u00162\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u0014H\u0001¢\u0006\u0002\u0010\u0019\"\u0014\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006\u001a", d2 = {"BottomSheetAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "DragHandleVerticalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "sheetState", "Landroidx/compose/material3/SheetState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "onFling", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "velocity", "", "rememberSheetState", "skipPartiallyExpanded", "", "confirmValueChange", "Landroidx/compose/material3/SheetValue;", "initialValue", "skipHiddenState", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/material3/SheetValue;ZLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SheetState;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SheetDefaultsKt {

    private static final AnimationSpec<Float> BottomSheetAnimationSpec;
    private static final float DragHandleVerticalPadding;
    static {
        int i2 = 0;
        SheetDefaultsKt.DragHandleVerticalPadding = Dp.constructor-impl((float)i);
        SheetDefaultsKt.BottomSheetAnimationSpec = (AnimationSpec)AnimationSpecKt.tween$default(300, 0, EasingKt.getFastOutSlowInEasing(), 2, 0);
    }

    public static final NestedScrollConnection ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(androidx.compose.material3.SheetState sheetState, Orientation orientation, Function1<? super Float, Unit> onFling) {
        SheetDefaultsKt.ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection.1 anon = new SheetDefaultsKt.ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection.1(sheetState, onFling, orientation);
        return (NestedScrollConnection)anon;
    }

    public static final AnimationSpec access$getBottomSheetAnimationSpec$p() {
        return SheetDefaultsKt.BottomSheetAnimationSpec;
    }

    public static final float access$getDragHandleVerticalPadding$p() {
        return SheetDefaultsKt.DragHandleVerticalPadding;
    }

    public static final androidx.compose.material3.SheetState rememberSheetState(boolean skipPartiallyExpanded, Function1<? super androidx.compose.material3.SheetValue, Boolean> confirmValueChange, androidx.compose.material3.SheetValue initialValue, boolean skipHiddenState, Composer $composer, int $changed, int i7) {
        int i10;
        int iNSTANCE;
        int hidden;
        int i9;
        boolean traceInProgress;
        String str;
        boolean changed;
        int i;
        int changed4;
        int i2;
        boolean changed2;
        int i8;
        int changed3;
        int i5;
        int empty;
        Object anon;
        int i4;
        androidx.compose.material3.SheetValue sheetValue;
        androidx.compose.material3.SheetDefaultsKt.rememberSheetState.1 anon2;
        int i3;
        int i6;
        final Composer composer2 = $composer;
        final int i30 = $changed;
        int i11 = 1032784200;
        ComposerKt.sourceInformationMarkerStart(composer2, i11, "C(rememberSheetState)P(3)408@15981L7,420@16374L180,409@16000L554:SheetDefaults.kt#uh7d8r");
        i4 = i7 & 1 != 0 ? i10 : skipPartiallyExpanded;
        if (i7 & 2 != 0) {
            anon2 = iNSTANCE;
        } else {
            anon2 = confirmValueChange;
        }
        sheetValue = i7 & 4 != 0 ? hidden : initialValue;
        i3 = i7 & 8 != 0 ? i9 : skipHiddenState;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i11, i30, -1, "androidx.compose.material3.rememberSheetState (SheetDefaults.kt:407)");
        }
        int i12 = 0;
        int i13 = 0;
        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        ComposerKt.sourceInformationMarkerEnd(composer2);
        final Object obj = consume;
        ComposerKt.sourceInformationMarkerStart(composer2, -349419818, "CC(remember):SheetDefaults.kt#9igjgp");
        int i22 = 4;
        i5 = 0;
        int i28 = 1;
        if (i15 ^= 6 > i22) {
            if (!composer2.changed(i4)) {
                i = i30 & 6 == i22 ? i28 : i5;
            } else {
            }
        } else {
        }
        int i31 = 256;
        if (i23 ^= 384 > i31) {
            if (!composer2.changed(sheetValue)) {
                i2 = i30 & 384 == i31 ? i28 : i5;
            } else {
            }
        } else {
        }
        int i32 = 32;
        if (i24 ^= 48 > i32) {
            if (!composer2.changed(anon2)) {
                i8 = i30 & 48 == i32 ? i28 : i5;
            } else {
            }
        } else {
        }
        empty = 2048;
        if (i25 ^= 3072 > empty) {
            if (!composer2.changed(i3)) {
                if (i30 & 3072 == empty) {
                    i5 = i28;
                }
            } else {
            }
        } else {
        }
        Composer composer = $composer;
        int i26 = 0;
        Object rememberedValue = composer.rememberedValue();
        final int i33 = 0;
        if (i18 |= i5 == 0) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                i6 = 0;
                anon = new SheetDefaultsKt.rememberSheetState.2.1(i4, obj, sheetValue, anon2, i3);
                composer.updateRememberedValue((Function0)anon);
            } else {
                anon = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (SheetState)RememberSaveableKt.rememberSaveable(/* result */, SheetState.Companion.Saver(i4, anon2, (Density)obj, i3), 0, (Function0)anon, composer2, 0, 4);
    }
}
