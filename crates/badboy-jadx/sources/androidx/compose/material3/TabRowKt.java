package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Alignment.Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000`\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0016\u001a\u0094\u0001\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00012\u001e\u0008\u0002\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00080\u0014¢\u0006\u0002\u0008\u0016¢\u0006\u0002\u0008\u00172\u0013\u0008\u0002\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00080\u0019¢\u0006\u0002\u0008\u00162\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00080\u0019¢\u0006\u0002\u0008\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u001b\u0010\u001c\u001a\u0080\u0001\u0010\u001d\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00102\u001e\u0008\u0002\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00080\u0014¢\u0006\u0002\u0008\u0016¢\u0006\u0002\u0008\u00172\u0013\u0008\u0002\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00080\u0019¢\u0006\u0002\u0008\u00162\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00080\u0019¢\u0006\u0002\u0008\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u001e\u0010\u001f\u001a\u009a\u0001\u0010 \u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00012.\u0008\u0002\u0010\u0013\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\"0!¢\u0006\u000c\u0008#\u0012\u0008\u0008$\u0012\u0004\u0008\u0008(%\u0012\u0004\u0012\u00020\u00080\u0014¢\u0006\u0002\u0008\u00162\u0013\u0008\u0002\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00080\u0019¢\u0006\u0002\u0008\u00162\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00080\u0019¢\u0006\u0002\u0008\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\u0008&\u0010'\u001a\u0086\u0001\u0010(\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00080\u0014¢\u0006\u0002\u0008\u0016¢\u0006\u0002\u0008\u00172\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00080\u0019¢\u0006\u0002\u0008\u00162\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00080\u0019¢\u0006\u0002\u0008\u0016H\u0003ø\u0001\u0000¢\u0006\u0004\u0008)\u0010*\u001a \u0001\u0010+\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2,\u0010\u0013\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\"0!¢\u0006\u000c\u0008#\u0012\u0008\u0008$\u0012\u0004\u0008\u0008(%\u0012\u0004\u0012\u00020\u00080\u0014¢\u0006\u0002\u0008\u00162\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00012\u0013\u0008\u0002\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00080\u0019¢\u0006\u0002\u0008\u00162\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00080\u0019¢\u0006\u0002\u0008\u00162\u0006\u0010\r\u001a\u00020\u000eH\u0003ø\u0001\u0000¢\u0006\u0004\u0008,\u0010-\u001a\u0094\u0001\u0010.\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00012\u001e\u0008\u0002\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00080\u0014¢\u0006\u0002\u0008\u0016¢\u0006\u0002\u0008\u00172\u0013\u0008\u0002\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00080\u0019¢\u0006\u0002\u0008\u00162\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00080\u0019¢\u0006\u0002\u0008\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\u0008/\u0010\u001c\u001a\u0080\u0001\u00100\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00102\u001e\u0008\u0002\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00080\u0014¢\u0006\u0002\u0008\u0016¢\u0006\u0002\u0008\u00172\u0013\u0008\u0002\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00080\u0019¢\u0006\u0002\u0008\u00162\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00080\u0019¢\u0006\u0002\u0008\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\u00081\u0010\u001f\u001a\u0090\u0001\u00102\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00102.\u0008\u0002\u0010\u0013\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\"0!¢\u0006\u000c\u0008#\u0012\u0008\u0008$\u0012\u0004\u0008\u0008(%\u0012\u0004\u0012\u00020\u00080\u0014¢\u0006\u0002\u0008\u00162\u0013\u0008\u0002\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00080\u0019¢\u0006\u0002\u0008\u00162\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00080\u0019¢\u0006\u0002\u0008\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\u00083\u0010\u001f\u001an\u00104\u001a\u00020\u00082\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00080\u0014¢\u0006\u0002\u0008\u0016¢\u0006\u0002\u0008\u00172\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00080\u0019¢\u0006\u0002\u0008\u00162\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00080\u0019¢\u0006\u0002\u0008\u0016H\u0003ø\u0001\u0000¢\u0006\u0004\u00085\u00106\u001a~\u00107\u001a\u00020\u00082\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102,\u0010\u0013\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\"0!¢\u0006\u000c\u0008#\u0012\u0008\u0008$\u0012\u0004\u0008\u0008(%\u0012\u0004\u0012\u00020\u00080\u0014¢\u0006\u0002\u0008\u00162\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00080\u0019¢\u0006\u0002\u0008\u00162\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00080\u0019¢\u0006\u0002\u0008\u0016H\u0003ø\u0001\u0000¢\u0006\u0004\u00088\u00106\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0014\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u00069", d2 = {"ScrollableTabRowMinimumTabWidth", "Landroidx/compose/ui/unit/Dp;", "F", "ScrollableTabRowScrollSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "TabRowIndicatorSpec", "PrimaryScrollableTabRow", "", "selectedTabIndex", "", "modifier", "Landroidx/compose/ui/Modifier;", "scrollState", "Landroidx/compose/foundation/ScrollState;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "edgePadding", "indicator", "Lkotlin/Function1;", "Landroidx/compose/material3/TabIndicatorScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "divider", "Lkotlin/Function0;", "tabs", "PrimaryScrollableTabRow-qhFBPw4", "(ILandroidx/compose/ui/Modifier;Landroidx/compose/foundation/ScrollState;JJFLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "PrimaryTabRow", "PrimaryTabRow-pAZo6Ak", "(ILandroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ScrollableTabRow", "", "Landroidx/compose/material3/TabPosition;", "Lkotlin/ParameterName;", "name", "tabPositions", "ScrollableTabRow-sKfQg0A", "(ILandroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ScrollableTabRowImpl", "ScrollableTabRowImpl-sKfQg0A", "(ILandroidx/compose/ui/Modifier;JJFLandroidx/compose/foundation/ScrollState;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "ScrollableTabRowWithSubcomposeImpl", "ScrollableTabRowWithSubcomposeImpl-qhFBPw4", "(ILkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/ScrollState;Landroidx/compose/runtime/Composer;II)V", "SecondaryScrollableTabRow", "SecondaryScrollableTabRow-qhFBPw4", "SecondaryTabRow", "SecondaryTabRow-pAZo6Ak", "TabRow", "TabRow-pAZo6Ak", "TabRowImpl", "TabRowImpl-DTcfvLk", "(Landroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "TabRowWithSubcomposeImpl", "TabRowWithSubcomposeImpl-DTcfvLk", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TabRowKt {

    private static final float ScrollableTabRowMinimumTabWidth;
    private static final AnimationSpec<Float> ScrollableTabRowScrollSpec;
    private static final AnimationSpec<Dp> TabRowIndicatorSpec;
    static {
        int i2 = 0;
        TabRowKt.ScrollableTabRowMinimumTabWidth = Dp.constructor-impl((float)i);
        int i3 = 250;
        int i4 = 0;
        final int i5 = 2;
        final int i6 = 0;
        TabRowKt.ScrollableTabRowScrollSpec = (AnimationSpec)AnimationSpecKt.tween$default(i3, i4, EasingKt.getFastOutSlowInEasing(), i5, i6);
        TabRowKt.TabRowIndicatorSpec = (AnimationSpec)AnimationSpecKt.tween$default(i3, i4, EasingKt.getFastOutSlowInEasing(), i5, i6);
    }

    public static final void PrimaryScrollableTabRow-qhFBPw4(int selectedTabIndex, Modifier modifier, ScrollState scrollState, long containerColor, long contentColor, float edgePadding, Function3<? super androidx.compose.material3.TabIndicatorScope, ? super Composer, ? super Integer, Unit> indicator, Function2<? super Composer, ? super Integer, Unit> divider, Function2<? super Composer, ? super Integer, Unit> tabs, Composer $composer, int $changed, int i12) {
        int traceInProgress2;
        Object endRestartGroup;
        Object obj4;
        Object obj3;
        Object obj8;
        int indicator2;
        int defaultsInvalid;
        int rememberScrollState;
        int scrollState2;
        int scrollableTabRowEdgeStartPadding-D9Ej5fM;
        Object indicator4;
        int $dirty2;
        long $dirty;
        Object containerColor2;
        int i6;
        int lambda-4$material3_release;
        Object obj6;
        Object obj;
        long modifier2;
        long contentColor3;
        int i4;
        Object obj7;
        int changed3;
        long primaryContainerColor;
        float containerColor3;
        long edgePadding2;
        Object obj2;
        int changed;
        long primaryContentColor;
        androidx.compose.runtime.internal.ComposableLambda contentColor2;
        float indicator3;
        Object obj5;
        androidx.compose.runtime.internal.ComposableLambda divider2;
        int changed2;
        int i11;
        boolean traceInProgress;
        Function2 function2;
        Composer restartGroup;
        float str;
        int i13;
        int i9;
        int i10;
        int i2;
        int i8;
        int i14;
        Composer composer;
        int i;
        int i7;
        int i5;
        int i3;
        long l;
        int obj32;
        traceInProgress2 = selectedTabIndex;
        i13 = obj33;
        i9 = obj34;
        restartGroup = i12.startRestartGroup(-1763241113);
        ComposerKt.sourceInformation(restartGroup, "C(PrimaryScrollableTabRow)P(7,5,6,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3:c#ui.unit.Dp,4)357@18289L21,358@18355L21,359@18419L19,362@18589L198,371@18905L328:TabRow.kt#uh7d8r");
        $dirty2 = obj33;
        if (i9 & 1 != 0) {
            $dirty2 |= 6;
        } else {
            if (i13 & 6 == 0) {
                i6 = restartGroup.changed(traceInProgress2) ? 4 : 2;
                $dirty2 |= i6;
            }
        }
        int i33 = i9 & 2;
        if (i33 != 0) {
            $dirty2 |= 48;
            obj = modifier;
        } else {
            if (i13 & 48 == 0) {
                i4 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i4;
            } else {
                obj = modifier;
            }
        }
        if (i13 & 384 == 0) {
            if (i9 & 4 == 0) {
                changed3 = restartGroup.changed(scrollState) ? 256 : 128;
            } else {
                obj7 = scrollState;
            }
            $dirty2 |= changed3;
        } else {
            obj7 = scrollState;
        }
        if (i13 & 3072 == 0) {
            if (i9 & 8 == 0) {
                changed = restartGroup.changed(containerColor) ? 2048 : 1024;
            } else {
                primaryContainerColor = containerColor;
            }
            $dirty2 |= changed;
        } else {
            primaryContainerColor = containerColor;
        }
        if (i13 & 24576 == 0) {
            if (i9 & 16 == 0) {
                changed2 = restartGroup.changed(edgePadding) ? 16384 : 8192;
            } else {
                primaryContentColor = edgePadding;
            }
            $dirty2 |= changed2;
        } else {
            primaryContentColor = edgePadding;
        }
        i11 = i9 & 32;
        int i58 = 196608;
        if (i11 != 0) {
            $dirty2 |= i58;
            str = divider;
        } else {
            if (i58 &= i13 == 0) {
                i10 = restartGroup.changed(divider) ? 131072 : 65536;
                $dirty2 |= i10;
            } else {
                str = divider;
            }
        }
        i2 = i9 & 64;
        i14 = 1572864;
        if (i2 != 0) {
            $dirty2 |= i14;
            obj4 = tabs;
        } else {
            if (i13 & i14 == 0) {
                i = restartGroup.changedInstance(tabs) ? 1048576 : 524288;
                $dirty2 |= i;
            } else {
                obj4 = tabs;
            }
        }
        int i25 = i9 & 128;
        int i62 = 12582912;
        if (i25 != 0) {
            $dirty2 |= i62;
            i7 = i25;
            obj3 = $composer;
        } else {
            if (i13 & i62 == 0) {
                i7 = i25;
                i5 = restartGroup.changedInstance($composer) ? 8388608 : 4194304;
                $dirty2 |= i5;
            } else {
                i7 = i25;
                obj3 = $composer;
            }
        }
        i3 = 100663296;
        if (i9 & 256 != 0) {
            $dirty2 |= i3;
            obj8 = $changed;
        } else {
            if (i13 & i3 == 0) {
                i3 = restartGroup.changedInstance($changed) ? 67108864 : 33554432;
                $dirty2 |= i3;
            } else {
                obj8 = $changed;
            }
        }
        if ($dirty2 & i64 == 38347922) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                lambda-4$material3_release = -57345;
                if (i13 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i33 != 0) {
                            obj = defaultsInvalid;
                        }
                        if (i9 & 4 != 0) {
                            int i28 = 0;
                            $dirty2 &= -897;
                            obj7 = rememberScrollState;
                        }
                        lambda-4$material3_release = 6;
                        if (i9 & 8 != 0) {
                            primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(restartGroup, lambda-4$material3_release);
                            $dirty2 &= -7169;
                        }
                        if (i9 & 16 != 0) {
                            primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(restartGroup, lambda-4$material3_release);
                            $dirty2 &= obj32;
                        }
                        if (i11 != 0) {
                            str = scrollableTabRowEdgeStartPadding-D9Ej5fM;
                        }
                        if (i2 != 0) {
                            TabRowKt.PrimaryScrollableTabRow.1 anon = new TabRowKt.PrimaryScrollableTabRow.1(traceInProgress2);
                            indicator4 = ComposableLambdaKt.rememberComposableLambda(1601820568, true, anon, restartGroup, 54);
                        } else {
                            indicator4 = tabs;
                        }
                        if (i7 != 0) {
                            i8 = $dirty2;
                            contentColor2 = indicator4;
                            obj5 = lambda-4$material3_release;
                            indicator2 = obj;
                            $dirty = primaryContainerColor;
                            containerColor3 = str;
                            obj2 = obj7;
                            modifier2 = l;
                        } else {
                            i8 = $dirty2;
                            $dirty = primaryContainerColor;
                            containerColor3 = str;
                            obj2 = obj7;
                            obj5 = $composer;
                            contentColor2 = indicator4;
                            indicator2 = obj;
                            modifier2 = l;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i9 & 4 != 0) {
                            $dirty2 &= -897;
                        }
                        if (i9 & 8 != 0) {
                            $dirty2 &= -7169;
                        }
                        if (i9 & 16 != 0) {
                            i8 = i32;
                            indicator2 = obj;
                            $dirty = primaryContainerColor;
                            containerColor3 = str;
                            obj2 = obj7;
                            modifier2 = primaryContentColor;
                            contentColor2 = tabs;
                            obj5 = $composer;
                        } else {
                            i8 = $dirty2;
                            indicator2 = obj;
                            $dirty = primaryContainerColor;
                            containerColor3 = str;
                            obj2 = obj7;
                            modifier2 = primaryContentColor;
                            contentColor2 = tabs;
                            obj5 = $composer;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1763241113, i8, -1, "androidx.compose.material3.PrimaryScrollableTabRow (TabRow.kt:370)");
                }
                TabRowKt.ScrollableTabRowImpl-sKfQg0A(selectedTabIndex, indicator2, $dirty, lambda-4$material3_release, modifier2, obj7, containerColor3, obj2, contentColor2, obj5, $changed);
                composer = restartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function2 = obj5;
                divider2 = contentColor2;
                indicator3 = containerColor3;
                containerColor2 = indicator2;
                obj6 = obj2;
                edgePadding2 = modifier2;
                contentColor3 = l;
            } else {
                restartGroup.skipToGroupEnd();
                function2 = $composer;
                i8 = $dirty2;
                containerColor2 = obj;
                obj6 = obj7;
                contentColor3 = primaryContainerColor;
                edgePadding2 = primaryContentColor;
                composer = restartGroup;
                indicator3 = str;
                divider2 = tabs;
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new TabRowKt.PrimaryScrollableTabRow.2(selectedTabIndex, containerColor2, obj6, contentColor3, obj7, edgePadding2, obj2, indicator3, divider2, function2, $changed, i13, i9);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    public static final void PrimaryTabRow-pAZo6Ak(int selectedTabIndex, Modifier modifier, long containerColor, long contentColor, Function3<? super androidx.compose.material3.TabIndicatorScope, ? super Composer, ? super Integer, Unit> indicator, Function2<? super Composer, ? super Integer, Unit> divider, Function2<? super Composer, ? super Integer, Unit> tabs, Composer $composer, int $changed, int i10) {
        int traceInProgress2;
        int defaultsInvalid;
        int iNSTANCE;
        int rememberComposableLambda;
        int i6;
        int i9;
        boolean traceInProgress;
        Object $composer2;
        int $dirty2;
        long $dirty;
        int i12;
        int str;
        Object obj2;
        long l;
        int i2;
        long primaryContainerColor;
        Object obj5;
        int changed;
        long primaryContentColor;
        Object obj3;
        int i5;
        int changed2;
        int i;
        Object obj6;
        long indicator2;
        int containerColor2;
        int i3;
        Object obj7;
        int i4;
        Object obj;
        int i11;
        Object i7;
        Object obj4;
        Composer composer;
        Composer composer2;
        int i8;
        i9 = selectedTabIndex;
        final int i39 = obj31;
        Composer restartGroup = i10.startRestartGroup(-1884787284);
        ComposerKt.sourceInformation(restartGroup, "C(PrimaryTabRow)P(5,4,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3)154@7555L21,155@7619L19,156@7698L189,165@8005L76:TabRow.kt#uh7d8r");
        $dirty2 = obj31;
        if (obj32 & 1 != 0) {
            $dirty2 |= 6;
        } else {
            if (i39 & 6 == 0) {
                i12 = restartGroup.changed(i9) ? 4 : 2;
                $dirty2 |= i12;
            }
        }
        int i32 = obj32 & 2;
        if (i32 != 0) {
            $dirty2 |= 48;
            obj2 = modifier;
        } else {
            if (i39 & 48 == 0) {
                i2 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i2;
            } else {
                obj2 = modifier;
            }
        }
        if (i39 & 384 == 0) {
            if (obj32 & 4 == 0) {
                changed = restartGroup.changed(containerColor) ? 256 : 128;
            } else {
                primaryContainerColor = containerColor;
            }
            $dirty2 |= changed;
        } else {
            primaryContainerColor = containerColor;
        }
        if (i39 & 3072 == 0) {
            if (obj32 & 8 == 0) {
                changed2 = restartGroup.changed(indicator) ? 2048 : 1024;
            } else {
                primaryContentColor = indicator;
            }
            $dirty2 |= changed2;
        } else {
            primaryContentColor = indicator;
        }
        i = obj32 & 16;
        if (i != 0) {
            $dirty2 |= 24576;
            obj6 = tabs;
        } else {
            if (i39 & 24576 == 0) {
                i3 = restartGroup.changedInstance(tabs) ? 16384 : 8192;
                $dirty2 |= i3;
            } else {
                obj6 = tabs;
            }
        }
        int i41 = obj32 & 32;
        int i42 = 196608;
        if (i41 != 0) {
            $dirty2 |= i42;
            obj7 = $composer;
        } else {
            if (i42 &= i39 == 0) {
                i4 = restartGroup.changedInstance($composer) ? 131072 : 65536;
                $dirty2 |= i4;
            } else {
                obj7 = $composer;
            }
        }
        i11 = 1572864;
        if (obj32 & 64 != 0) {
            $dirty2 |= i11;
            obj = $changed;
        } else {
            if (i39 & i11 == 0) {
                i11 = restartGroup.changedInstance($changed) ? 1048576 : 524288;
                $dirty2 |= i11;
            } else {
                obj = $changed;
            }
        }
        if ($dirty2 & i7 == 599186) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                if (i39 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i32 != 0) {
                            obj2 = defaultsInvalid;
                        }
                        str = 6;
                        if (obj32 & 4 != 0) {
                            primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(restartGroup, str);
                            $dirty2 &= -897;
                        }
                        if (obj32 & 8 != 0) {
                            primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(restartGroup, str);
                            $dirty2 &= -7169;
                        }
                        if (i != 0) {
                            TabRowKt.PrimaryTabRow.1 anon = new TabRowKt.PrimaryTabRow.1(i9);
                            obj6 = rememberComposableLambda;
                        }
                        if (i41 != 0) {
                            obj4 = lambda-1$material3_release;
                            i = obj2;
                            obj7 = primaryContentColor;
                            i7 = obj6;
                            i6 = -1884787284;
                            indicator2 = primaryContainerColor;
                        } else {
                            i = obj2;
                            i7 = obj6;
                            obj4 = obj7;
                            i6 = -1884787284;
                            indicator2 = primaryContainerColor;
                            obj7 = primaryContentColor;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (obj32 & 4 != 0) {
                            $dirty2 &= -897;
                        }
                        if (obj32 & 8 != 0) {
                            $dirty2 = i16;
                            i = obj2;
                            i7 = obj6;
                            obj4 = obj7;
                            i6 = -1884787284;
                            indicator2 = primaryContainerColor;
                            obj7 = primaryContentColor;
                        } else {
                            i = obj2;
                            i7 = obj6;
                            obj4 = obj7;
                            i6 = -1884787284;
                            indicator2 = primaryContainerColor;
                            obj7 = primaryContentColor;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i6, $dirty2, -1, "androidx.compose.material3.PrimaryTabRow (TabRow.kt:164)");
                }
                TabRowKt.TabRowImpl-DTcfvLk(i, indicator2, i41, obj7, obj, i7, obj4, $changed);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                containerColor2 = $dirty2;
                $dirty = l2;
                $composer2 = i;
                l = obj7;
                obj5 = i7;
                obj3 = obj4;
            } else {
                restartGroup.skipToGroupEnd();
                containerColor2 = $dirty2;
                $dirty = primaryContainerColor;
                obj5 = obj9;
                composer2 = restartGroup;
                $composer2 = obj2;
                l = primaryContentColor;
                obj3 = obj7;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new TabRowKt.PrimaryTabRow.2(selectedTabIndex, $composer2, $dirty, str, l, primaryContainerColor, obj5, obj3, $changed, i39, obj32);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void ScrollableTabRow-sKfQg0A(int selectedTabIndex, Modifier modifier, long containerColor, long contentColor, float edgePadding, Function3<? super List<androidx.compose.material3.TabPosition>, ? super Composer, ? super Integer, Unit> indicator, Function2<? super Composer, ? super Integer, Unit> divider, Function2<? super Composer, ? super Integer, Unit> tabs, Composer $composer, int $changed, int i11) {
        boolean traceInProgress;
        Object endRestartGroup;
        Object obj3;
        Object obj5;
        Object skipping;
        int defaultsInvalid;
        int iNSTANCE;
        int rememberComposableLambda;
        int $dirty2;
        Object $dirty;
        int i10;
        long l;
        int i2;
        Object obj4;
        int i;
        long primaryContainerColor;
        long containerColor2;
        int changed2;
        long primaryContentColor;
        float contentColor2;
        Object divider2;
        Object obj2;
        int changed;
        Function2 function2;
        int i4;
        int i3;
        float rememberScrollState;
        boolean traceInProgress2;
        Composer restartGroup;
        int i12;
        int str;
        Object obj;
        Composer composer;
        int i5;
        int i6;
        int i7;
        int i13;
        int i8;
        int i9;
        traceInProgress = selectedTabIndex;
        i5 = obj30;
        final int i54 = obj31;
        restartGroup = i11.startRestartGroup(-497821003);
        ComposerKt.sourceInformation(restartGroup, "C(ScrollableTabRow)P(6,5,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3:c#ui.unit.Dp,4)495@25349L21,496@25413L19,499@25596L164,516@26202L21,507@25878L351:TabRow.kt#uh7d8r");
        $dirty2 = obj30;
        if (i54 & 1 != 0) {
            $dirty2 |= 6;
        } else {
            if (i5 & 6 == 0) {
                i10 = restartGroup.changed(traceInProgress) ? 4 : 2;
                $dirty2 |= i10;
            }
        }
        int i20 = i54 & 2;
        if (i20 != 0) {
            $dirty2 |= 48;
            obj4 = modifier;
        } else {
            if (i5 & 48 == 0) {
                i = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i;
            } else {
                obj4 = modifier;
            }
        }
        if (i5 & 384 == 0) {
            if (i54 & 4 == 0) {
                changed2 = restartGroup.changed(containerColor) ? 256 : 128;
            } else {
                primaryContainerColor = containerColor;
            }
            $dirty2 |= changed2;
        } else {
            primaryContainerColor = containerColor;
        }
        if (i5 & 3072 == 0) {
            if (i54 & 8 == 0) {
                changed = restartGroup.changed(edgePadding) ? 2048 : 1024;
            } else {
                primaryContentColor = edgePadding;
            }
            $dirty2 |= changed;
        } else {
            primaryContentColor = edgePadding;
        }
        i3 = i54 & 16;
        if (i3 != 0) {
            $dirty2 |= 24576;
            rememberScrollState = divider;
        } else {
            if (i5 & 24576 == 0) {
                i12 = restartGroup.changed(divider) ? 16384 : 8192;
                $dirty2 |= i12;
            } else {
                rememberScrollState = divider;
            }
        }
        str = i54 & 32;
        int i37 = 196608;
        if (str != null) {
            $dirty2 |= i37;
            obj = tabs;
        } else {
            if (i37 &= i5 == 0) {
                i6 = restartGroup.changedInstance(tabs) ? 131072 : 65536;
                $dirty2 |= i6;
            } else {
                obj = tabs;
            }
        }
        int i55 = i54 & 64;
        i13 = 1572864;
        if (i55 != 0) {
            $dirty2 |= i13;
            obj3 = $composer;
        } else {
            if (i5 & i13 == 0) {
                i8 = restartGroup.changedInstance($composer) ? 1048576 : 524288;
                $dirty2 |= i8;
            } else {
                obj3 = $composer;
            }
        }
        i9 = 12582912;
        if (i54 & 128 != 0) {
            $dirty2 |= i9;
            obj5 = $changed;
        } else {
            if (i5 & i9 == 0) {
                i9 = restartGroup.changedInstance($changed) ? 8388608 : 4194304;
                $dirty2 |= i9;
            } else {
                obj5 = $changed;
            }
        }
        if ($dirty2 & i58 == 4793490) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                if (i5 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i20 != 0) {
                            obj4 = defaultsInvalid;
                        }
                        i2 = 6;
                        if (i54 & 4 != 0) {
                            primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(restartGroup, i2);
                            $dirty2 &= -897;
                        }
                        if (i54 & 8 != 0) {
                            primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(restartGroup, i2);
                            $dirty2 &= -7169;
                        }
                        if (i3 != 0) {
                            rememberScrollState = rememberComposableLambda;
                        }
                        if (str != null) {
                            TabRowKt.ScrollableTabRow.1 anon = new TabRowKt.ScrollableTabRow.1(traceInProgress);
                            obj = rememberComposableLambda;
                        }
                        if (i55 != 0) {
                            i4 = $dirty2;
                            $dirty = obj4;
                            l = primaryContainerColor;
                            containerColor2 = primaryContentColor;
                            contentColor2 = rememberScrollState;
                            obj2 = lambda-6$material3_release;
                            skipping = obj;
                        } else {
                            i4 = $dirty2;
                            $dirty = obj4;
                            l = primaryContainerColor;
                            containerColor2 = primaryContentColor;
                            contentColor2 = rememberScrollState;
                            skipping = obj;
                            obj2 = $composer;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i54 & 4 != 0) {
                            $dirty2 &= -897;
                        }
                        if (i54 & 8 != 0) {
                            i4 = i19;
                            $dirty = obj4;
                            l = primaryContainerColor;
                            containerColor2 = primaryContentColor;
                            contentColor2 = rememberScrollState;
                            skipping = obj;
                            obj2 = $composer;
                        } else {
                            i4 = $dirty2;
                            $dirty = obj4;
                            l = primaryContainerColor;
                            containerColor2 = primaryContentColor;
                            contentColor2 = rememberScrollState;
                            skipping = obj;
                            obj2 = $composer;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-497821003, i4, -1, "androidx.compose.material3.ScrollableTabRow (TabRow.kt:506)");
                }
                int i28 = 0;
                i7 = i4;
                TabRowKt.ScrollableTabRowWithSubcomposeImpl-qhFBPw4(traceInProgress, skipping, $dirty, l, obj4, containerColor2, obj6, contentColor2, obj2, $changed, ScrollKt.rememberScrollState(i28, restartGroup, i28, 1), restartGroup);
                composer = restartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function2 = obj2;
                divider2 = skipping;
            } else {
                restartGroup.skipToGroupEnd();
                function2 = $composer;
                i7 = $dirty2;
                $dirty = obj4;
                l = primaryContainerColor;
                containerColor2 = primaryContentColor;
                contentColor2 = rememberScrollState;
                divider2 = obj;
                composer = restartGroup;
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new TabRowKt.ScrollableTabRow.2(selectedTabIndex, $dirty, l, obj4, containerColor2, obj6, contentColor2, divider2, function2, $changed, i5, i54);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    private static final void ScrollableTabRowImpl-sKfQg0A(int selectedTabIndex, Modifier modifier, long containerColor, long contentColor, float edgePadding, ScrollState scrollState, Function3<? super androidx.compose.material3.TabIndicatorScope, ? super Composer, ? super Integer, Unit> indicator, Function2<? super Composer, ? super Integer, Unit> divider, Function2<? super Composer, ? super Integer, Unit> tabs, Composer $composer, int $changed) {
        boolean traceInProgress;
        boolean traceInProgress2;
        int restartGroup;
        Object obj2;
        int $dirty2;
        int i;
        int str;
        int i8;
        int i14;
        long l;
        Function3 function3;
        int i5;
        long l2;
        Function2 function2;
        int i7;
        float f;
        int i17;
        int i6;
        Object obj4;
        int i15;
        Object obj;
        Object obj3;
        int $dirty;
        int i9;
        Object obj5;
        int i10;
        int i12;
        long l3;
        int i2;
        int i13;
        int i16;
        int i11;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        Composer composer;
        int i4;
        int i3;
        obj2 = modifier;
        final int i33 = obj38;
        restartGroup = obj37.startRestartGroup(-1594140035);
        ComposerKt.sourceInformation(restartGroup, "C(ScrollableTabRowImpl)P(7,5,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3:c#ui.unit.Dp,6,4)709@32727L5081,699@32393L5415:TabRow.kt#uh7d8r");
        if (i33 & 6 == 0) {
            i8 = restartGroup.changed(selectedTabIndex) ? 4 : 2;
            $dirty2 |= i8;
        } else {
            i = selectedTabIndex;
        }
        if (i33 & 48 == 0) {
            i14 = restartGroup.changed(obj2) ? 32 : 16;
            $dirty2 |= i14;
        }
        if (i33 & 384 == 0) {
            i5 = restartGroup.changed(containerColor) ? 256 : 128;
            $dirty2 |= i5;
        } else {
            l = containerColor;
        }
        if (i33 & 3072 == 0) {
            i7 = restartGroup.changed(edgePadding) ? 2048 : 1024;
            $dirty2 |= i7;
        } else {
            l2 = edgePadding;
        }
        if (i33 & 24576 == 0) {
            i17 = restartGroup.changed(indicator) ? 16384 : 8192;
            $dirty2 |= i17;
        } else {
            f = indicator;
        }
        if (i30 &= i33 == 0) {
            i6 = restartGroup.changed(divider) ? 131072 : 65536;
            $dirty2 |= i6;
        } else {
            obj3 = divider;
        }
        if (i31 &= i33 == 0) {
            i15 = restartGroup.changedInstance(tabs) ? 1048576 : 524288;
            $dirty2 |= i15;
        } else {
            obj4 = tabs;
        }
        i16 = 12582912;
        if (i33 & i16 == 0) {
            i9 = restartGroup.changedInstance($composer) ? 8388608 : 4194304;
            $dirty2 |= i9;
        } else {
            obj = $composer;
        }
        if (i35 &= i33 == 0) {
            i10 = restartGroup.changedInstance($changed) ? 67108864 : 33554432;
            $dirty2 |= i10;
        } else {
            obj5 = $changed;
        }
        if ($dirty2 & i12 == 38347922) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1594140035, $dirty2, -1, "androidx.compose.material3.ScrollableTabRowImpl (TabRow.kt:698)");
                }
                int i26 = 0;
                i2 = selectedTabIndex;
                i12 = $composer;
                TabRowKt.ScrollableTabRowImpl.1 anon = new TabRowKt.ScrollableTabRowImpl.1(divider, $changed, i12, f, i2, obj4);
                SurfaceKt.Surface-T9BRK9s(ClipKt.clipToBounds(SelectableGroupKt.selectableGroup(ScrollKt.horizontalScroll$default(SizeKt.wrapContentSize$default(SizeKt.fillMaxWidth$default(obj2, 0, 1, i26), Alignment.Companion.getCenterStart(), false, 2, i26), obj3, false, 0, false, 14, 0))), 0, containerColor, i12, l2, i2, 0, 0, 0, (Function2)ComposableLambdaKt.rememberComposableLambda(1556158104, true, anon, restartGroup, 54), restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
                composer = restartGroup;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty = $dirty2;
            traceInProgress = new TabRowKt.ScrollableTabRowImpl.2(selectedTabIndex, modifier, containerColor, i, edgePadding, l, indicator, divider, tabs, $composer, $changed, i33);
            endRestartGroup.updateScope((Function2)traceInProgress);
        } else {
            $dirty = $dirty2;
        }
    }

    private static final void ScrollableTabRowWithSubcomposeImpl-qhFBPw4(int selectedTabIndex, Function3<? super List<androidx.compose.material3.TabPosition>, ? super Composer, ? super Integer, Unit> indicator, Modifier modifier, long containerColor, long contentColor, float edgePadding, Function2<? super Composer, ? super Integer, Unit> divider, Function2<? super Composer, ? super Integer, Unit> tabs, ScrollState scrollState, Composer $composer, int $changed, int i12) {
        Object obj5;
        Object obj;
        Object obj6;
        boolean traceInProgress2;
        int defaultsInvalid;
        int iNSTANCE;
        int scrollableTabRowEdgeStartPadding-D9Ej5fM;
        float f2;
        Composer restartGroup;
        int $dirty3;
        Object $dirty;
        int i2;
        Object $dirty2;
        int i15;
        int i8;
        Object obj4;
        long divider2;
        int i;
        int i9;
        int i18;
        Object obj3;
        long l;
        int modifier2;
        int i11;
        long primaryContainerColor;
        boolean traceInProgress;
        float f3;
        String str;
        int changed;
        long primaryContentColor;
        Object obj2;
        int i6;
        int changed2;
        int i19;
        float f;
        int modifier3;
        Object edgePadding2;
        int i21;
        int i3;
        int i13;
        int i7;
        int i22;
        int i4;
        int i10;
        int i14;
        int i16;
        int i20;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        Composer composer;
        int i17;
        int i5;
        Object obj29;
        ScrollState obj30;
        float obj31;
        Function2 obj32;
        Function2 obj33;
        Object obj34;
        int obj35;
        final int i53 = obj39;
        final int i54 = obj40;
        restartGroup = i12.startRestartGroup(-955409947);
        ComposerKt.sourceInformation(restartGroup, "C(ScrollableTabRowWithSubcomposeImpl)P(7,4,5,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3:c#ui.unit.Dp!1,8)1008@43780L21,1009@43844L19,1015@44165L3880,1015@44083L3962:TabRow.kt#uh7d8r");
        $dirty3 = obj39;
        if (i54 & 1 != 0) {
            $dirty3 |= 6;
            i2 = selectedTabIndex;
        } else {
            if (i53 & 6 == 0) {
                i8 = restartGroup.changed(selectedTabIndex) ? 4 : 2;
                $dirty3 |= i8;
            } else {
                i2 = selectedTabIndex;
            }
        }
        if (i54 & 2 != 0) {
            $dirty3 |= 48;
            obj4 = indicator;
        } else {
            if (i53 & 48 == 0) {
                i = restartGroup.changedInstance(indicator) ? 32 : 16;
                $dirty3 |= i;
            } else {
                obj4 = indicator;
            }
        }
        i9 = i54 & 4;
        if (i9 != 0) {
            $dirty3 |= 384;
            obj3 = modifier;
        } else {
            if (i53 & 384 == 0) {
                i11 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty3 |= i11;
            } else {
                obj3 = modifier;
            }
        }
        if (i53 & 3072 == 0) {
            if (i54 & 8 == 0) {
                changed = restartGroup.changed(containerColor) ? 2048 : 1024;
            } else {
                primaryContainerColor = containerColor;
            }
            $dirty3 |= changed;
        } else {
            primaryContainerColor = containerColor;
        }
        if (i53 & 24576 == 0) {
            if (i54 & 16 == 0) {
                changed2 = restartGroup.changed(edgePadding) ? 16384 : 8192;
            } else {
                primaryContentColor = edgePadding;
            }
            $dirty3 |= changed2;
        } else {
            primaryContentColor = edgePadding;
        }
        i19 = i54 & 32;
        int i55 = 196608;
        if (i19 != 0) {
            $dirty3 |= i55;
            f = tabs;
        } else {
            if (i55 &= i53 == 0) {
                i21 = restartGroup.changed(tabs) ? 131072 : 65536;
                $dirty3 |= i21;
            } else {
                f = tabs;
            }
        }
        i3 = i54 & 64;
        i13 = 1572864;
        if (i3 != 0) {
            $dirty3 |= i13;
            obj5 = scrollState;
        } else {
            if (i53 & i13 == 0) {
                i7 = restartGroup.changedInstance(scrollState) ? 1048576 : 524288;
                $dirty3 |= i7;
            } else {
                obj5 = scrollState;
            }
        }
        int i57 = 12582912;
        if (i54 & 128 != 0) {
            $dirty3 |= i57;
            obj = $composer;
        } else {
            if (i53 & i57 == 0) {
                i22 = restartGroup.changedInstance($composer) ? 8388608 : 4194304;
                $dirty3 |= i22;
            } else {
                obj = $composer;
            }
        }
        i4 = 100663296;
        if (i54 & 256 != 0) {
            $dirty3 |= i4;
            obj6 = $changed;
        } else {
            if (i53 & i4 == 0) {
                i4 = restartGroup.changed($changed) ? 67108864 : 33554432;
                $dirty3 |= i4;
            } else {
                obj6 = $changed;
            }
        }
        if ($dirty3 & i10 == 38347922) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i38 = -57345;
                if (i53 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i9 != 0) {
                            obj3 = defaultsInvalid;
                        }
                        int i41 = 6;
                        if (i54 & 8 != 0) {
                            primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(restartGroup, i41);
                            $dirty3 &= -7169;
                        }
                        if (i54 & 16 != 0) {
                            primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(restartGroup, i41);
                            $dirty3 &= i38;
                        }
                        if (i19 != 0) {
                            f = scrollableTabRowEdgeStartPadding-D9Ej5fM;
                        }
                        if (i3 != 0) {
                            i15 = $dirty3;
                            i10 = primaryContentColor;
                            i18 = i57;
                            $dirty = lambda-7$material3_release;
                            i13 = primaryContainerColor;
                            f2 = f;
                            edgePadding2 = obj3;
                            modifier2 = -955409947;
                        } else {
                            i15 = $dirty3;
                            i10 = primaryContentColor;
                            f2 = f;
                            i18 = i57;
                            $dirty = scrollState;
                            edgePadding2 = obj3;
                            i13 = primaryContainerColor;
                            modifier2 = -955409947;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i54 & 8 != 0) {
                            $dirty3 &= -7169;
                        }
                        if (i54 & 16 != 0) {
                            $dirty = scrollState;
                            i15 = i30;
                            i10 = primaryContentColor;
                            f2 = f;
                            i18 = i57;
                            edgePadding2 = obj3;
                            i13 = primaryContainerColor;
                            modifier2 = -955409947;
                        } else {
                            i15 = $dirty3;
                            i10 = primaryContentColor;
                            f2 = f;
                            i18 = i57;
                            $dirty = scrollState;
                            edgePadding2 = obj3;
                            i13 = primaryContainerColor;
                            modifier2 = -955409947;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(modifier2, i15, -1, "androidx.compose.material3.ScrollableTabRowWithSubcomposeImpl (TabRow.kt:1014)");
                }
                obj31 = f2;
                obj33 = $dirty;
                obj29 = anon2;
                super($changed, obj31, $composer, obj33, obj4, selectedTabIndex);
                SurfaceKt.Surface-T9BRK9s(edgePadding2, 0, i13, i57, i10, obj19, 0, 0, 0, (Function2)ComposableLambdaKt.rememberComposableLambda(-1572959552, true, obj29, restartGroup, 54), restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = i15;
                $dirty2 = i9;
                f3 = $dirty3;
                obj2 = function2;
                divider2 = i13;
                l = i10;
            } else {
                restartGroup.skipToGroupEnd();
                composer = restartGroup;
                $dirty2 = obj3;
                divider2 = primaryContainerColor;
                l = primaryContentColor;
                f3 = f;
                obj2 = scrollState;
                modifier3 = $dirty3;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new TabRowKt.ScrollableTabRowWithSubcomposeImpl.2(selectedTabIndex, indicator, $dirty2, divider2, i9, l, primaryContainerColor, f3, obj2, $composer, $changed, i53, i54);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void SecondaryScrollableTabRow-qhFBPw4(int selectedTabIndex, Modifier modifier, ScrollState scrollState, long containerColor, long contentColor, float edgePadding, Function3<? super androidx.compose.material3.TabIndicatorScope, ? super Composer, ? super Integer, Unit> indicator, Function2<? super Composer, ? super Integer, Unit> divider, Function2<? super Composer, ? super Integer, Unit> tabs, Composer $composer, int $changed, int i12) {
        int traceInProgress2;
        Object endRestartGroup;
        Object obj5;
        Object obj;
        Object obj3;
        int indicator4;
        int defaultsInvalid;
        int rememberScrollState;
        int scrollState2;
        int scrollableTabRowEdgeStartPadding-D9Ej5fM;
        Object indicator2;
        int $dirty2;
        long $dirty;
        Object containerColor2;
        int i;
        int lambda-5$material3_release;
        Object obj7;
        Object obj8;
        long modifier2;
        long contentColor3;
        int i4;
        Object obj6;
        int changed3;
        long secondaryContainerColor;
        float containerColor3;
        long edgePadding2;
        Object obj2;
        int changed2;
        long secondaryContentColor;
        androidx.compose.runtime.internal.ComposableLambda contentColor2;
        float indicator3;
        Object obj4;
        androidx.compose.runtime.internal.ComposableLambda divider2;
        int changed;
        int i13;
        boolean traceInProgress;
        Function2 function2;
        Composer restartGroup;
        float str;
        int i3;
        int i6;
        int i8;
        int i7;
        int i2;
        int i9;
        Composer composer;
        int i14;
        int i10;
        int i5;
        int i11;
        long l;
        int obj32;
        traceInProgress2 = selectedTabIndex;
        i3 = obj33;
        i6 = obj34;
        restartGroup = i12.startRestartGroup(1821940917);
        ComposerKt.sourceInformation(restartGroup, "C(SecondaryScrollableTabRow)P(7,5,6,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3:c#ui.unit.Dp,4)427@21884L21,428@21950L23,429@22016L21,432@22188L160,440@22466L327:TabRow.kt#uh7d8r");
        $dirty2 = obj33;
        if (i6 & 1 != 0) {
            $dirty2 |= 6;
        } else {
            if (i3 & 6 == 0) {
                i = restartGroup.changed(traceInProgress2) ? 4 : 2;
                $dirty2 |= i;
            }
        }
        int i33 = i6 & 2;
        if (i33 != 0) {
            $dirty2 |= 48;
            obj8 = modifier;
        } else {
            if (i3 & 48 == 0) {
                i4 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i4;
            } else {
                obj8 = modifier;
            }
        }
        if (i3 & 384 == 0) {
            if (i6 & 4 == 0) {
                changed3 = restartGroup.changed(scrollState) ? 256 : 128;
            } else {
                obj6 = scrollState;
            }
            $dirty2 |= changed3;
        } else {
            obj6 = scrollState;
        }
        if (i3 & 3072 == 0) {
            if (i6 & 8 == 0) {
                changed2 = restartGroup.changed(containerColor) ? 2048 : 1024;
            } else {
                secondaryContainerColor = containerColor;
            }
            $dirty2 |= changed2;
        } else {
            secondaryContainerColor = containerColor;
        }
        if (i3 & 24576 == 0) {
            if (i6 & 16 == 0) {
                changed = restartGroup.changed(edgePadding) ? 16384 : 8192;
            } else {
                secondaryContentColor = edgePadding;
            }
            $dirty2 |= changed;
        } else {
            secondaryContentColor = edgePadding;
        }
        i13 = i6 & 32;
        int i58 = 196608;
        if (i13 != 0) {
            $dirty2 |= i58;
            str = divider;
        } else {
            if (i58 &= i3 == 0) {
                i8 = restartGroup.changed(divider) ? 131072 : 65536;
                $dirty2 |= i8;
            } else {
                str = divider;
            }
        }
        i7 = i6 & 64;
        i9 = 1572864;
        if (i7 != 0) {
            $dirty2 |= i9;
            obj5 = tabs;
        } else {
            if (i3 & i9 == 0) {
                i14 = restartGroup.changedInstance(tabs) ? 1048576 : 524288;
                $dirty2 |= i14;
            } else {
                obj5 = tabs;
            }
        }
        int i25 = i6 & 128;
        int i62 = 12582912;
        if (i25 != 0) {
            $dirty2 |= i62;
            i10 = i25;
            obj = $composer;
        } else {
            if (i3 & i62 == 0) {
                i10 = i25;
                i5 = restartGroup.changedInstance($composer) ? 8388608 : 4194304;
                $dirty2 |= i5;
            } else {
                i10 = i25;
                obj = $composer;
            }
        }
        i11 = 100663296;
        if (i6 & 256 != 0) {
            $dirty2 |= i11;
            obj3 = $changed;
        } else {
            if (i3 & i11 == 0) {
                i11 = restartGroup.changedInstance($changed) ? 67108864 : 33554432;
                $dirty2 |= i11;
            } else {
                obj3 = $changed;
            }
        }
        if ($dirty2 & i64 == 38347922) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                lambda-5$material3_release = -57345;
                if (i3 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i33 != 0) {
                            obj8 = defaultsInvalid;
                        }
                        if (i6 & 4 != 0) {
                            int i28 = 0;
                            $dirty2 &= -897;
                            obj6 = rememberScrollState;
                        }
                        lambda-5$material3_release = 6;
                        if (i6 & 8 != 0) {
                            secondaryContainerColor = TabRowDefaults.INSTANCE.getSecondaryContainerColor(restartGroup, lambda-5$material3_release);
                            $dirty2 &= -7169;
                        }
                        if (i6 & 16 != 0) {
                            secondaryContentColor = TabRowDefaults.INSTANCE.getSecondaryContentColor(restartGroup, lambda-5$material3_release);
                            $dirty2 &= obj32;
                        }
                        if (i13 != 0) {
                            str = scrollableTabRowEdgeStartPadding-D9Ej5fM;
                        }
                        if (i7 != 0) {
                            TabRowKt.SecondaryScrollableTabRow.1 anon = new TabRowKt.SecondaryScrollableTabRow.1(traceInProgress2);
                            indicator2 = ComposableLambdaKt.rememberComposableLambda(1535842470, true, anon, restartGroup, 54);
                        } else {
                            indicator2 = tabs;
                        }
                        if (i10 != 0) {
                            i2 = $dirty2;
                            contentColor2 = indicator2;
                            obj4 = lambda-5$material3_release;
                            indicator4 = obj8;
                            $dirty = secondaryContainerColor;
                            containerColor3 = str;
                            obj2 = obj6;
                            modifier2 = l;
                        } else {
                            i2 = $dirty2;
                            $dirty = secondaryContainerColor;
                            containerColor3 = str;
                            obj2 = obj6;
                            obj4 = $composer;
                            contentColor2 = indicator2;
                            indicator4 = obj8;
                            modifier2 = l;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i6 & 4 != 0) {
                            $dirty2 &= -897;
                        }
                        if (i6 & 8 != 0) {
                            $dirty2 &= -7169;
                        }
                        if (i6 & 16 != 0) {
                            i2 = i32;
                            indicator4 = obj8;
                            $dirty = secondaryContainerColor;
                            containerColor3 = str;
                            obj2 = obj6;
                            modifier2 = secondaryContentColor;
                            contentColor2 = tabs;
                            obj4 = $composer;
                        } else {
                            i2 = $dirty2;
                            indicator4 = obj8;
                            $dirty = secondaryContainerColor;
                            containerColor3 = str;
                            obj2 = obj6;
                            modifier2 = secondaryContentColor;
                            contentColor2 = tabs;
                            obj4 = $composer;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1821940917, i2, -1, "androidx.compose.material3.SecondaryScrollableTabRow (TabRow.kt:439)");
                }
                TabRowKt.ScrollableTabRowImpl-sKfQg0A(selectedTabIndex, indicator4, $dirty, lambda-5$material3_release, modifier2, obj6, containerColor3, obj2, contentColor2, obj4, $changed);
                composer = restartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function2 = obj4;
                divider2 = contentColor2;
                indicator3 = containerColor3;
                containerColor2 = indicator4;
                obj7 = obj2;
                edgePadding2 = modifier2;
                contentColor3 = l;
            } else {
                restartGroup.skipToGroupEnd();
                function2 = $composer;
                i2 = $dirty2;
                containerColor2 = obj8;
                obj7 = obj6;
                contentColor3 = secondaryContainerColor;
                edgePadding2 = secondaryContentColor;
                composer = restartGroup;
                indicator3 = str;
                divider2 = tabs;
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new TabRowKt.SecondaryScrollableTabRow.2(selectedTabIndex, containerColor2, obj7, contentColor3, obj6, edgePadding2, obj2, indicator3, divider2, function2, $changed, i3, i6);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    public static final void SecondaryTabRow-pAZo6Ak(int selectedTabIndex, Modifier modifier, long containerColor, long contentColor, Function3<? super androidx.compose.material3.TabIndicatorScope, ? super Composer, ? super Integer, Unit> indicator, Function2<? super Composer, ? super Integer, Unit> divider, Function2<? super Composer, ? super Integer, Unit> tabs, Composer $composer, int $changed, int i10) {
        int traceInProgress2;
        int defaultsInvalid;
        int iNSTANCE;
        int rememberComposableLambda;
        int i8;
        int i7;
        boolean traceInProgress;
        Object $composer2;
        int $dirty2;
        long $dirty;
        int i4;
        int str;
        Object obj;
        long l;
        int i12;
        long secondaryContainerColor;
        Object obj7;
        int changed;
        long secondaryContentColor;
        Object obj2;
        int i;
        int changed2;
        int i5;
        Object obj4;
        long indicator2;
        int containerColor2;
        int i3;
        Object obj5;
        int i11;
        Object obj6;
        int i9;
        Object i2;
        Object obj3;
        Composer composer2;
        Composer composer;
        int i6;
        i7 = selectedTabIndex;
        final int i39 = obj31;
        Composer restartGroup = i10.startRestartGroup(-1909540706);
        ComposerKt.sourceInformation(restartGroup, "C(SecondaryTabRow)P(5,4,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3)208@10501L23,209@10567L21,211@10668L160,219@10946L76:TabRow.kt#uh7d8r");
        $dirty2 = obj31;
        if (obj32 & 1 != 0) {
            $dirty2 |= 6;
        } else {
            if (i39 & 6 == 0) {
                i4 = restartGroup.changed(i7) ? 4 : 2;
                $dirty2 |= i4;
            }
        }
        int i32 = obj32 & 2;
        if (i32 != 0) {
            $dirty2 |= 48;
            obj = modifier;
        } else {
            if (i39 & 48 == 0) {
                i12 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i12;
            } else {
                obj = modifier;
            }
        }
        if (i39 & 384 == 0) {
            if (obj32 & 4 == 0) {
                changed = restartGroup.changed(containerColor) ? 256 : 128;
            } else {
                secondaryContainerColor = containerColor;
            }
            $dirty2 |= changed;
        } else {
            secondaryContainerColor = containerColor;
        }
        if (i39 & 3072 == 0) {
            if (obj32 & 8 == 0) {
                changed2 = restartGroup.changed(indicator) ? 2048 : 1024;
            } else {
                secondaryContentColor = indicator;
            }
            $dirty2 |= changed2;
        } else {
            secondaryContentColor = indicator;
        }
        i5 = obj32 & 16;
        if (i5 != 0) {
            $dirty2 |= 24576;
            obj4 = tabs;
        } else {
            if (i39 & 24576 == 0) {
                i3 = restartGroup.changedInstance(tabs) ? 16384 : 8192;
                $dirty2 |= i3;
            } else {
                obj4 = tabs;
            }
        }
        int i41 = obj32 & 32;
        int i42 = 196608;
        if (i41 != 0) {
            $dirty2 |= i42;
            obj5 = $composer;
        } else {
            if (i42 &= i39 == 0) {
                i11 = restartGroup.changedInstance($composer) ? 131072 : 65536;
                $dirty2 |= i11;
            } else {
                obj5 = $composer;
            }
        }
        i9 = 1572864;
        if (obj32 & 64 != 0) {
            $dirty2 |= i9;
            obj6 = $changed;
        } else {
            if (i39 & i9 == 0) {
                i9 = restartGroup.changedInstance($changed) ? 1048576 : 524288;
                $dirty2 |= i9;
            } else {
                obj6 = $changed;
            }
        }
        if ($dirty2 & i2 == 599186) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                if (i39 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i32 != 0) {
                            obj = defaultsInvalid;
                        }
                        str = 6;
                        if (obj32 & 4 != 0) {
                            secondaryContainerColor = TabRowDefaults.INSTANCE.getSecondaryContainerColor(restartGroup, str);
                            $dirty2 &= -897;
                        }
                        if (obj32 & 8 != 0) {
                            secondaryContentColor = TabRowDefaults.INSTANCE.getSecondaryContentColor(restartGroup, str);
                            $dirty2 &= -7169;
                        }
                        if (i5 != 0) {
                            TabRowKt.SecondaryTabRow.1 anon = new TabRowKt.SecondaryTabRow.1(i7);
                            obj4 = rememberComposableLambda;
                        }
                        if (i41 != 0) {
                            obj3 = lambda-2$material3_release;
                            i5 = obj;
                            obj5 = secondaryContentColor;
                            i2 = obj4;
                            i8 = -1909540706;
                            indicator2 = secondaryContainerColor;
                        } else {
                            i5 = obj;
                            i2 = obj4;
                            obj3 = obj5;
                            i8 = -1909540706;
                            indicator2 = secondaryContainerColor;
                            obj5 = secondaryContentColor;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (obj32 & 4 != 0) {
                            $dirty2 &= -897;
                        }
                        if (obj32 & 8 != 0) {
                            $dirty2 = i16;
                            i5 = obj;
                            i2 = obj4;
                            obj3 = obj5;
                            i8 = -1909540706;
                            indicator2 = secondaryContainerColor;
                            obj5 = secondaryContentColor;
                        } else {
                            i5 = obj;
                            i2 = obj4;
                            obj3 = obj5;
                            i8 = -1909540706;
                            indicator2 = secondaryContainerColor;
                            obj5 = secondaryContentColor;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i8, $dirty2, -1, "androidx.compose.material3.SecondaryTabRow (TabRow.kt:218)");
                }
                TabRowKt.TabRowImpl-DTcfvLk(i5, indicator2, i41, obj5, obj6, i2, obj3, $changed);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                containerColor2 = $dirty2;
                $dirty = l2;
                $composer2 = i5;
                l = obj5;
                obj7 = i2;
                obj2 = obj3;
            } else {
                restartGroup.skipToGroupEnd();
                containerColor2 = $dirty2;
                $dirty = secondaryContainerColor;
                obj7 = obj9;
                composer = restartGroup;
                $composer2 = obj;
                l = secondaryContentColor;
                obj2 = obj5;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new TabRowKt.SecondaryTabRow.2(selectedTabIndex, $composer2, $dirty, str, l, secondaryContainerColor, obj7, obj2, $changed, i39, obj32);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void TabRow-pAZo6Ak(int selectedTabIndex, Modifier modifier, long containerColor, long contentColor, Function3<? super List<androidx.compose.material3.TabPosition>, ? super Composer, ? super Integer, Unit> indicator, Function2<? super Composer, ? super Integer, Unit> divider, Function2<? super Composer, ? super Integer, Unit> tabs, Composer $composer, int $changed, int i10) {
        int traceInProgress2;
        int defaultsInvalid;
        int iNSTANCE;
        int rememberComposableLambda;
        int i7;
        int i2;
        boolean traceInProgress;
        Object $composer2;
        int $dirty;
        long $dirty2;
        int i5;
        int str;
        Object obj5;
        long l;
        int i6;
        long primaryContainerColor;
        Object obj4;
        int changed2;
        long primaryContentColor;
        Object obj2;
        int i3;
        int changed;
        int i4;
        Object obj;
        long indicator2;
        int containerColor2;
        int i11;
        Object obj7;
        int i12;
        Object obj6;
        int i9;
        Object i;
        Object obj3;
        Composer composer2;
        Composer composer;
        int i8;
        i2 = selectedTabIndex;
        final int i39 = obj31;
        Composer restartGroup = i10.startRestartGroup(-1199178586);
        ComposerKt.sourceInformation(restartGroup, "C(TabRow)P(5,4,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3)302@15283L21,303@15347L19,305@15459L246,315@15823L90:TabRow.kt#uh7d8r");
        $dirty = obj31;
        if (obj32 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (i39 & 6 == 0) {
                i5 = restartGroup.changed(i2) ? 4 : 2;
                $dirty |= i5;
            }
        }
        int i32 = obj32 & 2;
        if (i32 != 0) {
            $dirty |= 48;
            obj5 = modifier;
        } else {
            if (i39 & 48 == 0) {
                i6 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i6;
            } else {
                obj5 = modifier;
            }
        }
        if (i39 & 384 == 0) {
            if (obj32 & 4 == 0) {
                changed2 = restartGroup.changed(containerColor) ? 256 : 128;
            } else {
                primaryContainerColor = containerColor;
            }
            $dirty |= changed2;
        } else {
            primaryContainerColor = containerColor;
        }
        if (i39 & 3072 == 0) {
            if (obj32 & 8 == 0) {
                changed = restartGroup.changed(indicator) ? 2048 : 1024;
            } else {
                primaryContentColor = indicator;
            }
            $dirty |= changed;
        } else {
            primaryContentColor = indicator;
        }
        i4 = obj32 & 16;
        if (i4 != 0) {
            $dirty |= 24576;
            obj = tabs;
        } else {
            if (i39 & 24576 == 0) {
                i11 = restartGroup.changedInstance(tabs) ? 16384 : 8192;
                $dirty |= i11;
            } else {
                obj = tabs;
            }
        }
        int i41 = obj32 & 32;
        int i42 = 196608;
        if (i41 != 0) {
            $dirty |= i42;
            obj7 = $composer;
        } else {
            if (i42 &= i39 == 0) {
                i12 = restartGroup.changedInstance($composer) ? 131072 : 65536;
                $dirty |= i12;
            } else {
                obj7 = $composer;
            }
        }
        i9 = 1572864;
        if (obj32 & 64 != 0) {
            $dirty |= i9;
            obj6 = $changed;
        } else {
            if (i39 & i9 == 0) {
                i9 = restartGroup.changedInstance($changed) ? 1048576 : 524288;
                $dirty |= i9;
            } else {
                obj6 = $changed;
            }
        }
        if ($dirty & i == 599186) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                if (i39 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i32 != 0) {
                            obj5 = defaultsInvalid;
                        }
                        str = 6;
                        if (obj32 & 4 != 0) {
                            primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(restartGroup, str);
                            $dirty &= -897;
                        }
                        if (obj32 & 8 != 0) {
                            primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(restartGroup, str);
                            $dirty &= -7169;
                        }
                        if (i4 != 0) {
                            TabRowKt.TabRow.1 anon = new TabRowKt.TabRow.1(i2);
                            obj = rememberComposableLambda;
                        }
                        if (i41 != 0) {
                            obj3 = lambda-3$material3_release;
                            i4 = obj5;
                            obj7 = primaryContentColor;
                            i = obj;
                            i7 = -1199178586;
                            indicator2 = primaryContainerColor;
                        } else {
                            i4 = obj5;
                            i = obj;
                            obj3 = obj7;
                            i7 = -1199178586;
                            indicator2 = primaryContainerColor;
                            obj7 = primaryContentColor;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (obj32 & 4 != 0) {
                            $dirty &= -897;
                        }
                        if (obj32 & 8 != 0) {
                            $dirty = i16;
                            i4 = obj5;
                            i = obj;
                            obj3 = obj7;
                            i7 = -1199178586;
                            indicator2 = primaryContainerColor;
                            obj7 = primaryContentColor;
                        } else {
                            i4 = obj5;
                            i = obj;
                            obj3 = obj7;
                            i7 = -1199178586;
                            indicator2 = primaryContainerColor;
                            obj7 = primaryContentColor;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i7, $dirty, -1, "androidx.compose.material3.TabRow (TabRow.kt:314)");
                }
                TabRowKt.TabRowWithSubcomposeImpl-DTcfvLk(i4, indicator2, i41, obj7, obj6, i, obj3, $changed);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                containerColor2 = $dirty;
                $dirty2 = l2;
                $composer2 = i4;
                l = obj7;
                obj4 = i;
                obj2 = obj3;
            } else {
                restartGroup.skipToGroupEnd();
                containerColor2 = $dirty;
                $dirty2 = primaryContainerColor;
                obj4 = obj9;
                composer = restartGroup;
                $composer2 = obj5;
                l = primaryContentColor;
                obj2 = obj7;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new TabRowKt.TabRow.2(selectedTabIndex, $composer2, $dirty2, str, l, primaryContainerColor, obj4, obj2, $changed, i39, obj32);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    private static final void TabRowImpl-DTcfvLk(Modifier modifier, long containerColor, long contentColor, Function3<? super androidx.compose.material3.TabIndicatorScope, ? super Composer, ? super Integer, Unit> indicator, Function2<? super Composer, ? super Integer, Unit> divider, Function2<? super Composer, ? super Integer, Unit> tabs, Composer $composer, int $changed) {
        int traceInProgress2;
        Object restartGroup;
        int $dirty;
        Object obj;
        int i6;
        int i;
        int i7;
        int i8;
        int i2;
        int i9;
        int skipping;
        boolean traceInProgress;
        int str;
        Modifier selectableGroup;
        int i12;
        int $dirty2;
        long l;
        long l2;
        int i11;
        int i3;
        int i10;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        Composer composer;
        int i5;
        int i4;
        final Object obj3 = tabs;
        final Object obj4 = $composer;
        final Object obj5 = $changed;
        final int i22 = obj32;
        traceInProgress2 = 1757425411;
        restartGroup = obj31.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(TabRowImpl)P(4,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3)575@27973L4041,571@27843L4171:TabRow.kt#uh7d8r");
        if (i22 & 6 == 0) {
            i6 = restartGroup.changed(modifier) ? 4 : 2;
            $dirty |= i6;
        } else {
            obj = modifier;
        }
        if (i22 & 48 == 0) {
            i = restartGroup.changed(containerColor) ? 32 : 16;
            $dirty |= i;
        } else {
            l = containerColor;
        }
        if (i22 & 384 == 0) {
            i7 = restartGroup.changed(indicator) ? 256 : 128;
            $dirty |= i7;
        } else {
            l2 = indicator;
        }
        if (i22 & 3072 == 0) {
            i8 = restartGroup.changedInstance(obj3) ? 2048 : 1024;
            $dirty |= i8;
        }
        if (i22 & 24576 == 0) {
            i2 = restartGroup.changedInstance(obj4) ? 16384 : 8192;
            $dirty |= i2;
        }
        if (i17 &= i22 == 0) {
            i9 = restartGroup.changedInstance(obj5) ? 131072 : 65536;
            $dirty |= i9;
        }
        if (i18 &= $dirty == 74898) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty, -1, "androidx.compose.material3.TabRowImpl (TabRow.kt:570)");
                }
                TabRowKt.TabRowImpl.1 anon = new TabRowKt.TabRowImpl.1(obj5, obj4, obj3);
                SurfaceKt.Surface-T9BRK9s(SelectableGroupKt.selectableGroup(obj), 0, l, obj13, l2, obj15, 0, 0, 0, (Function2)ComposableLambdaKt.rememberComposableLambda(-65106680, true, anon, restartGroup, 54), restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
                composer = restartGroup;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty2 = $dirty;
            traceInProgress2 = new TabRowKt.TabRowImpl.2(obj, containerColor, obj, indicator, str, obj3, obj4, obj5, i22);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        } else {
            $dirty2 = $dirty;
        }
    }

    private static final void TabRowWithSubcomposeImpl-DTcfvLk(Modifier modifier, long containerColor, long contentColor, Function3<? super List<androidx.compose.material3.TabPosition>, ? super Composer, ? super Integer, Unit> indicator, Function2<? super Composer, ? super Integer, Unit> divider, Function2<? super Composer, ? super Integer, Unit> tabs, Composer $composer, int $changed) {
        int traceInProgress2;
        Object restartGroup;
        int $dirty2;
        Object obj;
        int i;
        int i7;
        int i10;
        int i3;
        int i2;
        int i9;
        int skipping;
        boolean traceInProgress;
        int str;
        Modifier selectableGroup;
        int i4;
        int $dirty;
        long l2;
        long l;
        int i5;
        int i6;
        int i8;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        Composer composer;
        int i12;
        int i11;
        final Object obj3 = tabs;
        final Object obj4 = $composer;
        final Object obj5 = $changed;
        final int i22 = obj32;
        traceInProgress2 = -160898917;
        restartGroup = obj31.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(TabRowWithSubcomposeImpl)P(4,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3)947@41323L2218,943@41193L2348:TabRow.kt#uh7d8r");
        if (i22 & 6 == 0) {
            i = restartGroup.changed(modifier) ? 4 : 2;
            $dirty2 |= i;
        } else {
            obj = modifier;
        }
        if (i22 & 48 == 0) {
            i7 = restartGroup.changed(containerColor) ? 32 : 16;
            $dirty2 |= i7;
        } else {
            l2 = containerColor;
        }
        if (i22 & 384 == 0) {
            i10 = restartGroup.changed(indicator) ? 256 : 128;
            $dirty2 |= i10;
        } else {
            l = indicator;
        }
        if (i22 & 3072 == 0) {
            i3 = restartGroup.changedInstance(obj3) ? 2048 : 1024;
            $dirty2 |= i3;
        }
        if (i22 & 24576 == 0) {
            i2 = restartGroup.changedInstance(obj4) ? 16384 : 8192;
            $dirty2 |= i2;
        }
        if (i17 &= i22 == 0) {
            i9 = restartGroup.changedInstance(obj5) ? 131072 : 65536;
            $dirty2 |= i9;
        }
        if (i18 &= $dirty2 == 74898) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty2, -1, "androidx.compose.material3.TabRowWithSubcomposeImpl (TabRow.kt:942)");
                }
                TabRowKt.TabRowWithSubcomposeImpl.1 anon = new TabRowKt.TabRowWithSubcomposeImpl.1(obj5, obj4, obj3);
                SurfaceKt.Surface-T9BRK9s(SelectableGroupKt.selectableGroup(obj), 0, l2, obj13, l, obj15, 0, 0, 0, (Function2)ComposableLambdaKt.rememberComposableLambda(-1617702432, true, anon, restartGroup, 54), restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
                composer = restartGroup;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty = $dirty2;
            traceInProgress2 = new TabRowKt.TabRowWithSubcomposeImpl.2(obj, containerColor, obj, indicator, str, obj3, obj4, obj5, i22);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        } else {
            $dirty = $dirty2;
        }
    }

    public static final void access$ScrollableTabRowImpl-sKfQg0A(int selectedTabIndex, Modifier modifier, long containerColor, long contentColor, float edgePadding, ScrollState scrollState, Function3 indicator, Function2 divider, Function2 tabs, Composer $composer, int $changed) {
        TabRowKt.ScrollableTabRowImpl-sKfQg0A(selectedTabIndex, modifier, containerColor, contentColor, edgePadding, scrollState, indicator, divider, tabs, $composer, $changed);
    }

    public static final void access$ScrollableTabRowWithSubcomposeImpl-qhFBPw4(int selectedTabIndex, Function3 indicator, Modifier modifier, long containerColor, long contentColor, float edgePadding, Function2 divider, Function2 tabs, ScrollState scrollState, Composer $composer, int $changed, int $default) {
        TabRowKt.ScrollableTabRowWithSubcomposeImpl-qhFBPw4(selectedTabIndex, indicator, modifier, containerColor, contentColor, edgePadding, divider, tabs, scrollState, $composer, $changed, $default);
    }

    public static final void access$TabRowImpl-DTcfvLk(Modifier modifier, long containerColor, long contentColor, Function3 indicator, Function2 divider, Function2 tabs, Composer $composer, int $changed) {
        TabRowKt.TabRowImpl-DTcfvLk(modifier, containerColor, contentColor, indicator, divider, tabs, $composer, $changed);
    }

    public static final void access$TabRowWithSubcomposeImpl-DTcfvLk(Modifier modifier, long containerColor, long contentColor, Function3 indicator, Function2 divider, Function2 tabs, Composer $composer, int $changed) {
        TabRowKt.TabRowWithSubcomposeImpl-DTcfvLk(modifier, containerColor, contentColor, indicator, divider, tabs, $composer, $changed);
    }

    public static final float access$getScrollableTabRowMinimumTabWidth$p() {
        return TabRowKt.ScrollableTabRowMinimumTabWidth;
    }

    public static final AnimationSpec access$getScrollableTabRowScrollSpec$p() {
        return TabRowKt.ScrollableTabRowScrollSpec;
    }

    public static final AnimationSpec access$getTabRowIndicatorSpec$p() {
        return TabRowKt.TabRowIndicatorSpec;
    }
}
