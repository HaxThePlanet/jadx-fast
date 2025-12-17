package androidx.compose.material3;

import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.material3.internal.AnchoredDraggableKt;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.NavigationDrawerTokens;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.FloatState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Alignment.Companion;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.R.string;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode.Companion;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0084\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0012\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u001at\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00152\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\t0\u0017¢\u0006\u0002\u0008\u0019¢\u0006\u0002\u0008\u001aH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u001b\u0010\u001c\u001al\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00152\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\t0\u0017¢\u0006\u0002\u0008\u0019¢\u0006\u0002\u0008\u001aH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u001d\u0010\u001e\u001aQ\u0010\u001f\u001a\u00020\t2\u0011\u0010 \u001a\r\u0012\u0004\u0012\u00020\t0!¢\u0006\u0002\u0008\u00192\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\"\u001a\u00020#2\u0011\u0010\u0016\u001a\r\u0012\u0004\u0012\u00020\t0!¢\u0006\u0002\u0008\u0019H\u0007¢\u0006\u0002\u0010$\u001at\u0010%\u001a\u00020\t2\u0008\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010\u0014\u001a\u00020\u00152\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00052\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\t0\u0017¢\u0006\u0002\u0008\u0019¢\u0006\u0002\u0008\u001aH\u0001ø\u0001\u0000¢\u0006\u0004\u0008(\u0010)\u001at\u0010*\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00152\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\t0\u0017¢\u0006\u0002\u0008\u0019¢\u0006\u0002\u0008\u001aH\u0007ø\u0001\u0000¢\u0006\u0004\u0008+\u0010\u001c\u001al\u0010*\u001a\u00020\t2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00152\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\t0\u0017¢\u0006\u0002\u0008\u0019¢\u0006\u0002\u0008\u001aH\u0007ø\u0001\u0000¢\u0006\u0004\u0008,\u0010\u001e\u001a`\u0010-\u001a\u00020\t2\u0011\u0010 \u001a\r\u0012\u0004\u0012\u00020\t0!¢\u0006\u0002\u0008\u00192\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\"\u001a\u00020#2\u0008\u0008\u0002\u0010.\u001a\u00020\u00112\u0011\u0010\u0016\u001a\r\u0012\u0004\u0012\u00020\t0!¢\u0006\u0002\u0008\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\u0008/\u00100\u001a\u008e\u0001\u00101\u001a\u00020\t2\u0011\u00102\u001a\r\u0012\u0004\u0012\u00020\t0!¢\u0006\u0002\u0008\u00192\u0006\u00103\u001a\u00020#2\u000c\u00104\u001a\u0008\u0012\u0004\u0012\u00020\t0!2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u0015\u0008\u0002\u00105\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010!¢\u0006\u0002\u0008\u00192\u0015\u0008\u0002\u00106\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010!¢\u0006\u0002\u0008\u00192\u0008\u0008\u0002\u00107\u001a\u00020\u000f2\u0008\u0008\u0002\u00108\u001a\u0002092\n\u0008\u0002\u0010:\u001a\u0004\u0018\u00010;H\u0007¢\u0006\u0002\u0010<\u001al\u0010=\u001a\u00020\t2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00152\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\t0\u0017¢\u0006\u0002\u0008\u0019¢\u0006\u0002\u0008\u001aH\u0007ø\u0001\u0000¢\u0006\u0004\u0008>\u0010\u001e\u001a=\u0010?\u001a\u00020\t2\u0011\u0010 \u001a\r\u0012\u0004\u0012\u00020\t0!¢\u0006\u0002\u0008\u00192\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u0011\u0010\u0016\u001a\r\u0012\u0004\u0012\u00020\t0!¢\u0006\u0002\u0008\u0019H\u0007¢\u0006\u0002\u0010@\u001a>\u0010A\u001a\u00020\t2\u0006\u0010B\u001a\u00020#2\u000c\u0010C\u001a\u0008\u0012\u0004\u0012\u00020\t0!2\u000c\u0010D\u001a\u0008\u0012\u0004\u0012\u00020\u00020!2\u0006\u0010E\u001a\u00020\u0011H\u0003ø\u0001\u0000¢\u0006\u0004\u0008F\u0010G\u001a \u0010H\u001a\u00020\u00022\u0006\u0010I\u001a\u00020\u00022\u0006\u0010J\u001a\u00020\u00022\u0006\u0010K\u001a\u00020\u0002H\u0002\u001a+\u0010L\u001a\u00020\u000b2\u0006\u0010M\u001a\u00020N2\u0014\u0008\u0002\u0010O\u001a\u000e\u0012\u0004\u0012\u00020N\u0012\u0004\u0012\u00020#0\u0017H\u0007¢\u0006\u0002\u0010P\u001a\u0014\u0010Q\u001a\u00020\u0002*\u00020R2\u0006\u0010&\u001a\u00020'H\u0002\u001a\u0014\u0010S\u001a\u00020\u0002*\u00020R2\u0006\u0010&\u001a\u00020'H\u0002\u001a\u001c\u0010T\u001a\u00020\r*\u00020\r2\u0006\u0010&\u001a\u00020'2\u0006\u0010U\u001a\u00020#H\u0002\u001a\u001c\u0010V\u001a\u00020\r*\u00020\r2\u0006\u0010&\u001a\u00020'2\u0006\u0010U\u001a\u00020#H\u0002\"\u0014\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0002X\u0082D¢\u0006\u0002\n\u0000\"\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u0010\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006W²\u0006\n\u0010X\u001a\u00020#X\u008a\u008e\u0002²\u0006\n\u0010Y\u001a\u00020\u0002X\u008a\u008e\u0002²\u0006\n\u0010X\u001a\u00020#X\u008a\u008e\u0002", d2 = {"AnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "", "DrawerPositionalThreshold", "DrawerVelocityThreshold", "Landroidx/compose/ui/unit/Dp;", "F", "MinimumDrawerWidth", "DismissibleDrawerSheet", "", "drawerState", "Landroidx/compose/material3/DrawerState;", "modifier", "Landroidx/compose/ui/Modifier;", "drawerShape", "Landroidx/compose/ui/graphics/Shape;", "drawerContainerColor", "Landroidx/compose/ui/graphics/Color;", "drawerContentColor", "drawerTonalElevation", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "DismissibleDrawerSheet-Snr_uVM", "(Landroidx/compose/material3/DrawerState;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJFLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DismissibleDrawerSheet-afqeVBk", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJFLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DismissibleNavigationDrawer", "drawerContent", "Lkotlin/Function0;", "gesturesEnabled", "", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/DrawerState;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "DrawerSheet", "drawerPredictiveBackState", "Landroidx/compose/material3/DrawerPredictiveBackState;", "DrawerSheet-7zSek6w", "(Landroidx/compose/material3/DrawerPredictiveBackState;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJFLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ModalDrawerSheet", "ModalDrawerSheet-Snr_uVM", "ModalDrawerSheet-afqeVBk", "ModalNavigationDrawer", "scrimColor", "ModalNavigationDrawer-FHprtrg", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/DrawerState;ZJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "NavigationDrawerItem", "label", "selected", "onClick", "icon", "badge", "shape", "colors", "Landroidx/compose/material3/NavigationDrawerItemColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/NavigationDrawerItemColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "PermanentDrawerSheet", "PermanentDrawerSheet-afqeVBk", "PermanentNavigationDrawer", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Scrim", "open", "onClose", "fraction", "color", "Scrim-Bx497Mc", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;JLandroidx/compose/runtime/Composer;I)V", "calculateFraction", "a", "b", "pos", "rememberDrawerState", "initialValue", "Landroidx/compose/material3/DrawerValue;", "confirmStateChange", "(Landroidx/compose/material3/DrawerValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/DrawerState;", "calculatePredictiveBackScaleX", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "calculatePredictiveBackScaleY", "predictiveBackDrawerChild", "isRtl", "predictiveBackDrawerContainer", "material3_release", "anchorsInitialized", "minValue"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class NavigationDrawerKt {

    private static final TweenSpec<Float> AnimationSpec;
    private static final float DrawerPositionalThreshold = 0.5f;
    private static final float DrawerVelocityThreshold;
    private static final float MinimumDrawerWidth;
    static {
        int i = 1056964608;
        int i4 = 0;
        NavigationDrawerKt.DrawerVelocityThreshold = Dp.constructor-impl((float)i2);
        int i5 = 0;
        NavigationDrawerKt.MinimumDrawerWidth = Dp.constructor-impl((float)i3);
        TweenSpec tweenSpec = new TweenSpec(256, 0, 0, 6, 0);
        NavigationDrawerKt.AnimationSpec = tweenSpec;
    }

    public static final void DismissibleDrawerSheet-Snr_uVM(androidx.compose.material3.DrawerState drawerState, Modifier modifier, Shape drawerShape, long drawerContainerColor, long drawerContentColor, float drawerTonalElevation, WindowInsets windowInsets, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i11) {
        Object obj9;
        Object obj3;
        int traceInProgress;
        int windowInsets3;
        boolean traceInProgress2;
        int defaultsInvalid;
        int iNSTANCE;
        int dismissibleDrawerElevation-D9Ej5fM;
        int $dirty2;
        Object $dirty;
        int i6;
        int str;
        Object obj6;
        Object obj5;
        long l3;
        int i8;
        int i5;
        Object obj7;
        long l4;
        int i3;
        long standardContainerColor;
        float f3;
        int changed2;
        long contentColorFor-ek8zF_U;
        WindowInsets windowInsets2;
        int i7;
        int changed3;
        int i4;
        float f;
        int i;
        int i9;
        int changed;
        int i2;
        androidx.compose.material3.NavigationDrawerKt.DismissibleDrawerSheet.2 anon;
        Object obj4;
        Object obj2;
        Object obj;
        long l;
        long l2;
        float f2;
        Object obj8;
        final Object obj10 = drawerState;
        final int i29 = obj38;
        final int i30 = obj39;
        final Composer restartGroup = i11.startRestartGroup(1473549901);
        ComposerKt.sourceInformation(restartGroup, "C(DismissibleDrawerSheet)P(4,6,3,1:c#ui.graphics.Color,2:c#ui.graphics.Color,5:c#ui.unit.Dp,7)694@28867L22,695@28923L37,697@29084L12,700@29195L299,700@29154L340:NavigationDrawer.kt#uh7d8r");
        $dirty2 = obj38;
        if (i30 & 1 != 0) {
            $dirty2 |= 6;
        } else {
            if (i29 & 6 == 0) {
                i6 = restartGroup.changed(obj10) ? 4 : 2;
                $dirty2 |= i6;
            }
        }
        int i17 = i30 & 2;
        if (i17 != 0) {
            $dirty2 |= 48;
            obj5 = modifier;
        } else {
            if (i29 & 48 == 0) {
                i8 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i8;
            } else {
                obj5 = modifier;
            }
        }
        i5 = i30 & 4;
        if (i5 != 0) {
            $dirty2 |= 384;
            obj7 = drawerShape;
        } else {
            if (i29 & 384 == 0) {
                i3 = restartGroup.changed(drawerShape) ? 256 : 128;
                $dirty2 |= i3;
            } else {
                obj7 = drawerShape;
            }
        }
        if (i29 & 3072 == 0) {
            if (i30 & 8 == 0) {
                changed2 = restartGroup.changed(drawerContainerColor) ? 2048 : 1024;
            } else {
                standardContainerColor = drawerContainerColor;
            }
            $dirty2 |= changed2;
        } else {
            standardContainerColor = drawerContainerColor;
        }
        if (i29 & 24576 == 0) {
            if (i30 & 16 == 0) {
                changed3 = restartGroup.changed(drawerTonalElevation) ? 16384 : 8192;
            } else {
                contentColorFor-ek8zF_U = drawerTonalElevation;
            }
            $dirty2 |= changed3;
        } else {
            contentColorFor-ek8zF_U = drawerTonalElevation;
        }
        int i31 = i30 & 32;
        int i32 = 196608;
        if (i31 != 0) {
            $dirty2 |= i32;
            f = content;
        } else {
            if (i32 &= i29 == 0) {
                i = restartGroup.changed(content) ? 131072 : 65536;
                $dirty2 |= i;
            } else {
                f = content;
            }
        }
        if (i29 & i34 == 0) {
            if (i30 & 64 == 0) {
                changed = restartGroup.changed($composer) ? 1048576 : 524288;
            } else {
                obj9 = $composer;
            }
            $dirty2 |= changed;
        } else {
            obj9 = $composer;
        }
        i2 = 12582912;
        if (i30 & 128 != 0) {
            $dirty2 |= i2;
            obj3 = $changed;
        } else {
            if (i29 & i2 == 0) {
                i2 = restartGroup.changedInstance($changed) ? 8388608 : 4194304;
                $dirty2 |= i2;
            } else {
                obj3 = $changed;
            }
        }
        if ($dirty2 & anon == 4793490) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                str = -3670017;
                int i35 = -57345;
                if (i29 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i17 != 0) {
                            obj5 = defaultsInvalid;
                        }
                        if (i5 != 0) {
                            obj7 = defaultsInvalid;
                        }
                        i5 = 6;
                        if (i30 & 8 != 0) {
                            standardContainerColor = DrawerDefaults.INSTANCE.getStandardContainerColor(restartGroup, i5);
                            $dirty2 &= -7169;
                        }
                        if (i30 & 16 != 0) {
                            contentColorFor-ek8zF_U = ColorSchemeKt.contentColorFor-ek8zF_U(standardContainerColor, obj8, restartGroup);
                            $dirty2 &= i35;
                        }
                        if (i31 != 0) {
                            f = dismissibleDrawerElevation-D9Ej5fM;
                        }
                        if (i30 & 64 != 0) {
                            $dirty2 &= str;
                            obj4 = windowInsets3;
                            obj2 = obj5;
                            obj = obj7;
                            l = standardContainerColor;
                            l2 = contentColorFor-ek8zF_U;
                            f2 = f;
                        } else {
                            obj4 = $composer;
                            obj2 = obj5;
                            obj = obj7;
                            l = standardContainerColor;
                            l2 = contentColorFor-ek8zF_U;
                            f2 = f;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i30 & 8 != 0) {
                            $dirty2 &= -7169;
                        }
                        if (i30 & 16 != 0) {
                            $dirty2 &= i35;
                        }
                        if (i30 & 64 != 0) {
                            obj4 = $composer;
                            $dirty2 = windowInsets3;
                            obj2 = obj5;
                            obj = obj7;
                            l = standardContainerColor;
                            l2 = contentColorFor-ek8zF_U;
                            f2 = f;
                        } else {
                            obj4 = $composer;
                            obj2 = obj5;
                            obj = obj7;
                            l = standardContainerColor;
                            l2 = contentColorFor-ek8zF_U;
                            f2 = f;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1473549901, $dirty2, -1, "androidx.compose.material3.DismissibleDrawerSheet (NavigationDrawer.kt:699)");
                }
                anon = new NavigationDrawerKt.DismissibleDrawerSheet.2(obj4, obj2, obj, l, obj22, l2, obj24, f2, $changed);
                NavigationDrawer_androidKt.DrawerPredictiveBackHandler(obj10, (Function3)ComposableLambdaKt.rememberComposableLambda(-807955710, true, anon, restartGroup, 54), restartGroup, i20 |= 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i4 = $dirty2;
                windowInsets2 = obj4;
                $dirty = obj2;
                obj6 = obj;
                l3 = l;
                l4 = l2;
                f3 = f2;
            } else {
                restartGroup.skipToGroupEnd();
                i4 = $dirty2;
                $dirty = obj5;
                obj6 = obj7;
                l3 = standardContainerColor;
                l4 = contentColorFor-ek8zF_U;
                f3 = f;
                windowInsets2 = $composer;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new NavigationDrawerKt.DismissibleDrawerSheet.3(obj10, $dirty, obj6, l3, i5, l4, standardContainerColor, f3, windowInsets2, $changed, i29, i30);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void DismissibleDrawerSheet-afqeVBk(Modifier modifier, Shape drawerShape, long drawerContainerColor, long drawerContentColor, float drawerTonalElevation, WindowInsets windowInsets, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i10) {
        boolean traceInProgress;
        int windowInsets2;
        int defaultsInvalid;
        int iNSTANCE;
        int dismissibleDrawerElevation-D9Ej5fM;
        Object $composer2;
        int $dirty;
        Object $dirty2;
        long l2;
        Object obj4;
        boolean traceInProgress2;
        int i5;
        long l;
        int str;
        Object obj6;
        int i3;
        long standardContainerColor;
        float f2;
        Object obj3;
        int changed;
        int i6;
        int changed2;
        int i4;
        long contentColorFor-ek8zF_U;
        int windowInsets3;
        Object obj;
        float drawerTonalElevation2;
        int i;
        Object obj5;
        int changed3;
        Object obj2;
        int i9;
        int i7;
        long l3;
        float f;
        Composer composer;
        Composer composer2;
        int i2;
        int i8;
        long l4;
        final int i48 = obj36;
        Composer restartGroup = i10.startRestartGroup(-588600583);
        ComposerKt.sourceInformation(restartGroup, "C(DismissibleDrawerSheet)P(5,3,1:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.unit.Dp,6)650@26887L22,651@26943L37,653@27104L12,656@27174L225:NavigationDrawer.kt#uh7d8r");
        $dirty = obj36;
        int i26 = obj37 & 1;
        if (i26 != 0) {
            $dirty |= 6;
            obj4 = modifier;
        } else {
            if (i48 & 6 == 0) {
                i5 = restartGroup.changed(modifier) ? 4 : 2;
                $dirty |= i5;
            } else {
                obj4 = modifier;
            }
        }
        str = obj37 & 2;
        if (str != null) {
            $dirty |= 48;
            obj6 = drawerShape;
        } else {
            if (i48 & 48 == 0) {
                i3 = restartGroup.changed(drawerShape) ? 32 : 16;
                $dirty |= i3;
            } else {
                obj6 = drawerShape;
            }
        }
        if (i48 & 384 == 0) {
            if (obj37 & 4 == 0) {
                changed = restartGroup.changed(drawerContainerColor) ? 256 : 128;
            } else {
                standardContainerColor = drawerContainerColor;
            }
            $dirty |= changed;
        } else {
            standardContainerColor = drawerContainerColor;
        }
        if (i48 & 3072 == 0) {
            if (obj37 & 8 == 0) {
                i6 = restartGroup.changed(drawerTonalElevation) ? 2048 : 1024;
            } else {
                contentColorFor-ek8zF_U = drawerTonalElevation;
            }
            $dirty |= i6;
        } else {
            contentColorFor-ek8zF_U = drawerTonalElevation;
        }
        i4 = obj37 & 16;
        if (i4 != 0) {
            $dirty |= 24576;
            drawerTonalElevation2 = content;
        } else {
            if (i48 & 24576 == 0) {
                i = restartGroup.changed(content) ? 16384 : 8192;
                $dirty |= i;
            } else {
                drawerTonalElevation2 = content;
            }
        }
        if (i50 &= i48 == 0) {
            if (obj37 & 32 == 0) {
                changed3 = restartGroup.changed($composer) ? 131072 : 65536;
            } else {
                obj5 = $composer;
            }
            $dirty |= changed3;
        } else {
            obj5 = $composer;
        }
        i9 = 1572864;
        if (obj37 & 64 != 0) {
            $dirty |= i9;
            obj2 = $changed;
        } else {
            if (i48 & i9 == 0) {
                i9 = restartGroup.changedInstance($changed) ? 1048576 : 524288;
                $dirty |= i9;
            } else {
                obj2 = $changed;
            }
        }
        if ($dirty & i7 == 599186) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                i7 = -458753;
                int i28 = 6;
                if (i48 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i26 != 0) {
                            obj4 = defaultsInvalid;
                        }
                        if (str != null) {
                            obj6 = defaultsInvalid;
                        }
                        if (obj37 & 4 != 0) {
                            standardContainerColor = DrawerDefaults.INSTANCE.getStandardContainerColor(restartGroup, i28);
                            $dirty &= -897;
                        }
                        if (obj37 & 8 != 0) {
                            contentColorFor-ek8zF_U = ColorSchemeKt.contentColorFor-ek8zF_U(standardContainerColor, obj8, restartGroup);
                            $dirty &= -7169;
                        }
                        if (i4 != 0) {
                            drawerTonalElevation2 = dismissibleDrawerElevation-D9Ej5fM;
                        }
                        if (obj37 & 32 != 0) {
                            $dirty &= i7;
                            obj5 = obj6;
                            obj2 = standardContainerColor;
                            l3 = contentColorFor-ek8zF_U;
                            f = drawerTonalElevation2;
                            obj = windowInsets4;
                            drawerTonalElevation2 = obj4;
                            windowInsets2 = -588600583;
                        } else {
                            obj2 = standardContainerColor;
                            l3 = contentColorFor-ek8zF_U;
                            f = drawerTonalElevation2;
                            obj = obj5;
                            windowInsets2 = -588600583;
                            drawerTonalElevation2 = obj4;
                            obj5 = obj6;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (obj37 & 4 != 0) {
                            $dirty &= -897;
                        }
                        if (obj37 & 8 != 0) {
                            $dirty &= -7169;
                        }
                        if (obj37 & 32 != 0) {
                            $dirty = i15;
                            obj2 = standardContainerColor;
                            l3 = contentColorFor-ek8zF_U;
                            f = drawerTonalElevation2;
                            obj = obj5;
                            windowInsets2 = -588600583;
                            drawerTonalElevation2 = obj4;
                            obj5 = obj6;
                        } else {
                            obj2 = standardContainerColor;
                            l3 = contentColorFor-ek8zF_U;
                            f = drawerTonalElevation2;
                            obj = obj5;
                            windowInsets2 = -588600583;
                            drawerTonalElevation2 = obj4;
                            obj5 = obj6;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(windowInsets2, $dirty, -1, "androidx.compose.material3.DismissibleDrawerSheet (NavigationDrawer.kt:655)");
                }
                NavigationDrawerKt.DrawerSheet-7zSek6w(0, obj, drawerTonalElevation2, obj5, obj2, i7, l3, obj18, f, $changed, restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj3 = obj;
                $composer2 = drawerTonalElevation2;
                l2 = obj2;
                l = l3;
                f2 = f;
                windowInsets3 = $dirty;
                $dirty2 = obj5;
            } else {
                restartGroup.skipToGroupEnd();
                windowInsets3 = $dirty;
                $dirty2 = obj6;
                l = l4;
                composer2 = restartGroup;
                $composer2 = obj4;
                l2 = standardContainerColor;
                f2 = drawerTonalElevation2;
                obj3 = obj5;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new NavigationDrawerKt.DismissibleDrawerSheet.1($composer2, $dirty2, l2, obj4, l, obj6, f2, obj3, $changed, i48, obj37);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void DismissibleNavigationDrawer(Function2<? super Composer, ? super Integer, Unit> drawerContent, Modifier modifier, androidx.compose.material3.DrawerState drawerState, boolean gesturesEnabled, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i8) {
        boolean traceInProgress2;
        Integer currentCompositionLocalMap;
        Function0 factory$iv$iv$iv2;
        Object obj6;
        Function0 factory$iv$iv$iv3;
        int $dirty;
        Object $dirty2;
        Object it$iv2;
        Integer maybeCachedBoxMeasurePolicy2;
        boolean valueOf3;
        int i9;
        Object obj2;
        Object modifier4;
        boolean traceInProgress;
        int changed;
        int i27;
        int invalid$iv2;
        Composer composer;
        Composer composer8;
        Object valueOf;
        Object currentCompositionLocalMap3;
        boolean z;
        Object mutableStateOf$default;
        Object compositionCoroutineScope;
        Object iNSTANCE;
        int i14;
        Object compositionScopedCoroutineScopeCanceller;
        Object rememberDrawerState;
        int i42;
        Function0 factory$iv$iv$iv;
        int i19;
        Object it$iv;
        Composer composer9;
        int changed2;
        boolean changed4;
        int i40;
        Object obj4;
        int valueOf2;
        int empty2;
        Integer currentCompositionLocalMap4;
        int changed3;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap2;
        int i29;
        boolean maybeCachedBoxMeasurePolicy;
        Composer composer5;
        int i25;
        Function0 factory$iv$iv;
        int i4;
        Object maybeCachedBoxMeasurePolicy3;
        int i22;
        int i18;
        int skipping;
        int defaultsInvalid;
        Modifier materializeModifier;
        Object anon2;
        int materialized$iv$iv;
        int i23;
        Object empty;
        Object obj5;
        int i11;
        Composer.Companion companion3;
        int i7;
        Object $i$a$RememberCoroutineScopeEffectsKt$rememberCoroutineScope$1;
        boolean z2;
        int i16;
        int i12;
        int i39;
        int i41;
        int i35;
        int i;
        int i13;
        int currentCompositeKeyHash2;
        Alignment alignment;
        int i37;
        Modifier modifier2;
        Function0 function03;
        int i15;
        int i17;
        Modifier modifier3;
        int i26;
        BoxScopeInstance iNSTANCE2;
        int i33;
        int i2;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy;
        int i36;
        int i31;
        Composer composer4;
        int i20;
        Object obj;
        int currentCompositeKeyHash;
        int companion;
        Object obj7;
        Modifier materialized$iv$iv2;
        int i28;
        androidx.compose.ui.Modifier.Companion companion2;
        Composer composer6;
        int i24;
        int i32;
        int i38;
        Function0 function02;
        int i30;
        Function0 function04;
        Object obj3;
        int companion5;
        androidx.compose.runtime.CompositionLocalMap localMap$iv;
        androidx.compose.material3.NavigationDrawerKt.DismissibleNavigationDrawer.2.2.1 anon;
        Composer composer2;
        int invalid$iv;
        int i34;
        int $i$f$Box;
        androidx.compose.ui.Modifier.Companion companion4;
        Function0 function0;
        int i10;
        int i5;
        Composer composer3;
        kotlinx.coroutines.CoroutineScope coroutineScope;
        int i6;
        int i21;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy$iv;
        androidx.compose.runtime.CompositionLocalMap map;
        Composer composer7;
        int i3;
        int obj76;
        String obj77;
        Object obj78;
        Composer obj80;
        Object obj8 = drawerContent;
        iNSTANCE = content;
        i14 = $changed;
        traceInProgress2 = 398812198;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(DismissibleNavigationDrawer)P(1,4,2,3)434@17575L39,438@17723L34,439@17789L7,440@17812L33,440@17801L44,442@17863L24,443@17913L33,445@17985L7,446@18020L2358:NavigationDrawer.kt#uh7d8r");
        $dirty = $changed;
        int i69 = 2;
        if (i8 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (i14 & 6 == 0) {
                i9 = restartGroup.changedInstance(obj8) ? 4 : i69;
                $dirty |= i9;
            }
        }
        int i62 = i8 & 2;
        if (i62 != 0) {
            $dirty |= 48;
            rememberDrawerState = modifier;
        } else {
            if (i14 & 48 == 0) {
                i40 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i40;
            } else {
                rememberDrawerState = modifier;
            }
        }
        if (i14 & 384 == 0) {
            if (i8 & 4 == 0) {
                changed3 = restartGroup.changed(drawerState) ? 256 : 128;
            } else {
                obj4 = drawerState;
            }
            $dirty |= changed3;
        } else {
            obj4 = drawerState;
        }
        currentCompositionLocalMap2 = i8 & 8;
        if (currentCompositionLocalMap2 != 0) {
            $dirty |= 3072;
            maybeCachedBoxMeasurePolicy = gesturesEnabled;
        } else {
            if (i14 & 3072 == 0) {
                i22 = restartGroup.changed(gesturesEnabled) ? 2048 : 1024;
                $dirty |= i22;
            } else {
                maybeCachedBoxMeasurePolicy = gesturesEnabled;
            }
        }
        if (i8 & 16 != 0) {
            $dirty |= 24576;
        } else {
            if (i14 & 24576 == 0) {
                i18 = restartGroup.changedInstance(iNSTANCE) ? 16384 : 8192;
                $dirty |= i18;
            }
        }
        if ($dirty & 9363 == 9362) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i120 = 0;
                int i123 = 6;
                if (i14 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i62 != 0) {
                            modifier4 = Modifier.Companion;
                        } else {
                            modifier4 = rememberDrawerState;
                        }
                        if (i8 & 4 != 0) {
                            $dirty &= -897;
                            obj4 = rememberDrawerState;
                        }
                        if (currentCompositionLocalMap2 != 0) {
                            obj5 = modifier4;
                            z2 = rememberDrawerState;
                        } else {
                            obj5 = modifier4;
                            z2 = maybeCachedBoxMeasurePolicy;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i8 & 4 != 0) {
                            $dirty &= -897;
                        }
                        obj5 = rememberDrawerState;
                        z2 = maybeCachedBoxMeasurePolicy;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty, -1, "androidx.compose.material3.DismissibleNavigationDrawer (NavigationDrawer.kt:437)");
                }
                String str2 = "CC(remember):NavigationDrawer.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, 1034571360, str2);
                int i44 = 0;
                Composer composer13 = restartGroup;
                int i96 = 0;
                Object rememberedValue5 = composer13.rememberedValue();
                int i118 = 0;
                obj80 = i123;
                if (rememberedValue5 == Composer.Companion.getEmpty()) {
                    empty = 0;
                    composer13.updateRememberedValue(SnapshotStateKt.mutableStateOf$default(false, i120, i69, i120));
                } else {
                    obj76 = 0;
                    mutableStateOf$default = rememberedValue5;
                }
                Object invalid$iv3 = mutableStateOf$default;
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                int i77 = 0;
                empty2 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                Object this_$iv = consume;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 1034574207, str2);
                if (i79 ^= 384 > 256) {
                    if (!restartGroup.changed(obj4)) {
                        i42 = $dirty & 384 == 256 ? 1 : obj76;
                    } else {
                    }
                } else {
                }
                Composer composer15 = restartGroup;
                int i102 = 0;
                Object rememberedValue6 = composer15.rememberedValue();
                int i124 = 0;
                if (i42 |= changed7 == 0) {
                    if (rememberedValue6 == Composer.Companion.getEmpty()) {
                        empty2 = 0;
                        anon2 = new NavigationDrawerKt.DismissibleNavigationDrawer.1.1(obj4, this_$iv);
                        composer15.updateRememberedValue((Function0)anon2);
                    } else {
                        anon2 = rememberedValue6;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                int i81 = obj76;
                EffectsKt.SideEffect((Function0)anon2, restartGroup, i81);
                int i90 = i81;
                int i82 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(restartGroup, -954363344, "CC(remember):Effects.kt#9igjgp");
                int i104 = 0;
                Composer composer19 = restartGroup;
                int i121 = 0;
                Object rememberedValue7 = composer19.rememberedValue();
                int i129 = 0;
                obj78 = this_$iv;
                if (rememberedValue7 == Composer.Companion.getEmpty()) {
                    int i131 = 0;
                    i16 = i72;
                    compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope((CoroutineContext)EmptyCoroutineContext.INSTANCE, restartGroup));
                    composer19.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                } else {
                    compositionScopedCoroutineScopeCanceller = rememberedValue7;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                kotlinx.coroutines.CoroutineScope coroutineScope2 = (CompositionScopedCoroutineScopeCanceller)compositionScopedCoroutineScopeCanceller.getCoroutineScope();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                androidx.compose.material3.internal.Strings.Companion companion11 = Strings.Companion;
                int i83 = 0;
                String string-2EP1pXo = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(R.string.navigation_menu), restartGroup, 0);
                int i91 = 0;
                int i99 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                i16 = restartGroup.consume((CompositionLocal)CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl ? 1 : 0;
                Modifier anchoredDraggable$default = AnchoredDraggableKt.anchoredDraggable$default(obj5, obj4.getAnchoredDraggableState$material3_release(), Orientation.Horizontal, z2, i16, 0, 16, 0);
                int i100 = i92;
                String str7 = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo";
                ComposerKt.sourceInformationMarkerStart(restartGroup, 733328855, str7);
                Alignment topStart3 = Alignment.Companion.getTopStart();
                int i125 = 0;
                maybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(topStart3, i125);
                i12 = 0;
                i39 = i93;
                String $changed$iv5 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, $changed$iv5);
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, 0);
                currentCompositionLocalMap4 = restartGroup.getCurrentCompositionLocalMap();
                alignment = topStart3;
                materialized$iv$iv = ComposedModifierKt.materializeModifier(restartGroup, anchoredDraggable$default);
                modifier2 = anchoredDraggable$default;
                Function0 function06 = constructor2;
                i37 = 0;
                i17 = i125;
                String propagateMinConstraints$iv2 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, propagateMinConstraints$iv2);
                if (!applier3 instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                restartGroup.startReusableNode();
                if (restartGroup.getInserting()) {
                    restartGroup.createNode(function06);
                } else {
                    factory$iv$iv$iv = function06;
                    restartGroup.useNode();
                }
                function03 = factory$iv$iv$iv;
                Composer constructor-impl2 = Updater.constructor-impl(restartGroup);
                int i141 = 0;
                Updater.set-impl(constructor-impl2, maybeCachedBoxMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl2, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i142 = 0;
                Composer composer20 = constructor-impl2;
                int i145 = 0;
                if (!composer20.getInserting()) {
                    localMap$iv$iv = currentCompositionLocalMap4;
                    measurePolicy = maybeCachedBoxMeasurePolicy3;
                    if (!Intrinsics.areEqual(composer20.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        composer20.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        constructor-impl2.apply(Integer.valueOf(currentCompositeKeyHash2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer5 = composer20;
                    }
                } else {
                    localMap$iv$iv = currentCompositionLocalMap4;
                    measurePolicy = maybeCachedBoxMeasurePolicy3;
                }
                Updater.set-impl(constructor-impl2, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                Composer composer14 = restartGroup;
                i26 = i74;
                String $changed$iv4 = "C73@3429L9:Box.kt#2w3rfo";
                ComposerKt.sourceInformationMarkerStart(composer14, -2146769399, $changed$iv4);
                iNSTANCE2 = BoxScopeInstance.INSTANCE;
                i144 |= 6;
                i36 = 0;
                i20 = i95;
                Composer $i$a$LayoutBoxKt$Box$1$iv2 = composer21;
                ComposerKt.sourceInformationMarkerStart($i$a$LayoutBoxKt$Box$1$iv2, -1218087217, "C477@19117L1255,454@18269L2103:NavigationDrawer.kt#uh7d8r");
                ComposerKt.sourceInformationMarkerStart($i$a$LayoutBoxKt$Box$1$iv2, 99280484, str2);
                if (i87 ^= 384 > 256) {
                    if (!restartGroup.changed(obj4)) {
                        i19 = $dirty & 384 == 256 ? 1 : 0;
                    } else {
                    }
                } else {
                }
                Composer composer17 = $i$a$LayoutBoxKt$Box$1$iv2;
                int i146 = 0;
                it$iv = composer17.rememberedValue();
                int i148 = 0;
                if (i19 == 0) {
                    materialized$iv$iv2 = materialized$iv$iv;
                    if (it$iv == Composer.Companion.getEmpty()) {
                        materialized$iv$iv = 0;
                        obj7 = it$iv;
                        it$iv = new NavigationDrawerKt.DismissibleNavigationDrawer.2.2.1(obj4, (MutableState)invalid$iv3);
                        composer17.updateRememberedValue((MeasurePolicy)it$iv);
                    } else {
                        obj7 = it$iv;
                    }
                } else {
                    materialized$iv$iv2 = materialized$iv$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($i$a$LayoutBoxKt$Box$1$iv2);
                i2 = 0;
                ComposerKt.sourceInformationMarkerStart($i$a$LayoutBoxKt$Box$1$iv2, -1323940314, $changed$iv5);
                androidx.compose.ui.Modifier.Companion companion18 = Modifier.Companion;
                obj = invalid$iv3;
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($i$a$LayoutBoxKt$Box$1$iv2, 0);
                currentCompositionLocalMap = $i$a$LayoutBoxKt$Box$1$iv2.getCurrentCompositionLocalMap();
                companion2 = companion18;
                Function0 function07 = constructor3;
                i28 = 0;
                ComposerKt.sourceInformationMarkerStart($i$a$LayoutBoxKt$Box$1$iv2, -692256719, propagateMinConstraints$iv2);
                if (!applier4 instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                $i$a$LayoutBoxKt$Box$1$iv2.startReusableNode();
                if ($i$a$LayoutBoxKt$Box$1$iv2.getInserting()) {
                    $i$a$LayoutBoxKt$Box$1$iv2.createNode(function07);
                } else {
                    factory$iv$iv = function07;
                    $i$a$LayoutBoxKt$Box$1$iv2.useNode();
                }
                composer6 = $i$a$LayoutBoxKt$Box$1$iv2;
                Composer constructor-impl3 = Updater.constructor-impl(composer6);
                int i149 = 0;
                function02 = factory$iv$iv;
                Updater.set-impl(constructor-impl3, (MeasurePolicy)it$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl3, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i150 = 0;
                Composer composer22 = constructor-impl3;
                companion5 = 0;
                if (!composer22.getInserting()) {
                    localMap$iv = currentCompositionLocalMap;
                    anon = it$iv;
                    if (!Intrinsics.areEqual(composer22.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer22.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl3.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer9 = composer22;
                    }
                } else {
                    localMap$iv = currentCompositionLocalMap;
                    anon = it$iv;
                }
                Updater.set-impl(constructor-impl3, ComposedModifierKt.materializeModifier($i$a$LayoutBoxKt$Box$1$iv2, (Modifier)companion18), ComposeUiNode.Companion.getSetModifier());
                rememberDrawerState = composer6;
                valueOf2 = 0;
                i32 = i46;
                ComposerKt.sourceInformationMarkerStart(rememberDrawerState, 285475168, "C457@18361L623,456@18317L741,475@19075L17:NavigationDrawer.kt#uh7d8r");
                ComposerKt.sourceInformationMarkerStart(rememberDrawerState, -1376263189, str2);
                if (i115 ^= 384 > 256) {
                    if (!restartGroup.changed(obj4)) {
                        i27 = $dirty & 384 == 256 ? 1 : 0;
                    } else {
                    }
                } else {
                }
                i63 |= changedInstance2;
                Composer composer18 = rememberDrawerState;
                int i135 = 0;
                i38 = $dirty;
                it$iv2 = composer18.rememberedValue();
                int i151 = 0;
                if (invalid$iv2 == 0) {
                    invalid$iv = invalid$iv2;
                    if (it$iv2 == Composer.Companion.getEmpty()) {
                        invalid$iv2 = 0;
                        obj3 = it$iv2;
                        it$iv2 = new NavigationDrawerKt.DismissibleNavigationDrawer.2.1.1.1(string-2EP1pXo, obj4, coroutineScope2);
                        composer18.updateRememberedValue((Function1)it$iv2);
                    } else {
                        obj3 = it$iv2;
                    }
                } else {
                    invalid$iv = invalid$iv2;
                }
                ComposerKt.sourceInformationMarkerEnd(rememberDrawerState);
                obj77 = string-2EP1pXo;
                int i116 = 0;
                Modifier semantics$default = SemanticsModifierKt.semantics$default((Modifier)Modifier.Companion, i116, (Function1)it$iv2, 1, 0);
                ComposerKt.sourceInformationMarkerStart(rememberDrawerState, 733328855, str7);
                Alignment topStart = Alignment.Companion.getTopStart();
                int i136 = i61;
                maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(topStart, false);
                int i152 = 0;
                int i153 = i65;
                ComposerKt.sourceInformationMarkerStart(rememberDrawerState, -1323940314, $changed$iv5);
                int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(rememberDrawerState, 0);
                currentCompositionLocalMap3 = rememberDrawerState.getCurrentCompositionLocalMap();
                Alignment alignment2 = topStart;
                Modifier modifier5 = semantics$default;
                Function0 function08 = constructor4;
                int i154 = 0;
                ComposerKt.sourceInformationMarkerStart(rememberDrawerState, -692256719, propagateMinConstraints$iv2);
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                rememberDrawerState.startReusableNode();
                if (rememberDrawerState.getInserting()) {
                    rememberDrawerState.createNode(function08);
                } else {
                    factory$iv$iv$iv2 = function08;
                    rememberDrawerState.useNode();
                }
                function0 = factory$iv$iv$iv2;
                Composer constructor-impl = Updater.constructor-impl(rememberDrawerState);
                int i155 = 0;
                coroutineScope = coroutineScope2;
                Updater.set-impl(constructor-impl, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i158 = 0;
                Composer composer24 = constructor-impl;
                int i159 = 0;
                if (!composer24.getInserting()) {
                    measurePolicy$iv = maybeCachedBoxMeasurePolicy2;
                    map = currentCompositionLocalMap3;
                    if (!Intrinsics.areEqual(composer24.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                        composer24.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer = composer24;
                    }
                } else {
                    measurePolicy$iv = maybeCachedBoxMeasurePolicy2;
                    map = currentCompositionLocalMap3;
                }
                Updater.set-impl(constructor-impl, ComposedModifierKt.materializeModifier(rememberDrawerState, semantics$default), ComposeUiNode.Companion.getSetModifier());
                Composer composer11 = rememberDrawerState;
                ComposerKt.sourceInformationMarkerStart(composer11, -2146769399, $changed$iv4);
                BoxScopeInstance iNSTANCE3 = BoxScopeInstance.INSTANCE;
                i157 |= 6;
                i6 = 0;
                i21 = i50;
                i3 = i67;
                Composer $i$a$LayoutBoxKt$Box$1$iv = composer3;
                ComposerKt.sourceInformationMarkerStart($i$a$LayoutBoxKt$Box$1$iv, 590398649, "C473@19025L15:NavigationDrawer.kt#uh7d8r");
                obj8.invoke($i$a$LayoutBoxKt$Box$1$iv, Integer.valueOf(i38 & 14));
                ComposerKt.sourceInformationMarkerEnd($i$a$LayoutBoxKt$Box$1$iv);
                ComposerKt.sourceInformationMarkerEnd(composer11);
                rememberDrawerState.endNode();
                ComposerKt.sourceInformationMarkerEnd(rememberDrawerState);
                ComposerKt.sourceInformationMarkerEnd(rememberDrawerState);
                ComposerKt.sourceInformationMarkerEnd(rememberDrawerState);
                int i52 = propagateMinConstraints$iv;
                valueOf3 = 0;
                ComposerKt.sourceInformationMarkerStart(rememberDrawerState, 733328855, str7);
                valueOf = Modifier.Companion;
                i11 = 0;
                ComposerKt.sourceInformationMarkerStart(rememberDrawerState, -1323940314, $changed$iv5);
                obj76 = currentCompositeKeyHash3;
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(rememberDrawerState, (Modifier)valueOf);
                Function0 function05 = constructor;
                i = 0;
                ComposerKt.sourceInformationMarkerStart(rememberDrawerState, -692256719, propagateMinConstraints$iv2);
                if (!applier2 instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                rememberDrawerState.startReusableNode();
                if (rememberDrawerState.getInserting()) {
                    rememberDrawerState.createNode(function05);
                } else {
                    factory$iv$iv$iv3 = function05;
                    rememberDrawerState.useNode();
                }
                Composer constructor-impl4 = Updater.constructor-impl(rememberDrawerState);
                int i139 = 0;
                function04 = factory$iv$iv$iv3;
                Updater.set-impl(constructor-impl4, BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false), ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl4, rememberDrawerState.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i140 = 0;
                Composer composer23 = constructor-impl4;
                i34 = 0;
                if (!composer23.getInserting()) {
                    $i$f$Box = valueOf3;
                    companion4 = valueOf;
                    if (!Intrinsics.areEqual(composer23.rememberedValue(), Integer.valueOf(obj76))) {
                        composer23.updateRememberedValue(Integer.valueOf(obj76));
                        constructor-impl4.apply(Integer.valueOf(obj76), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer8 = composer23;
                    }
                } else {
                    $i$f$Box = valueOf3;
                    companion4 = valueOf;
                }
                Updater.set-impl(constructor-impl4, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                Composer composer12 = rememberDrawerState;
                int i68 = 0;
                ComposerKt.sourceInformationMarkerStart(composer12, -2146769399, $changed$iv4);
                iNSTANCE = BoxScopeInstance.INSTANCE;
                i128 |= 6;
                obj80 = composer12;
                i13 = 0;
                modifier3 = materializeModifier2;
                i31 = i60;
                ComposerKt.sourceInformationMarkerStart(composer12, 590454015, "C475@19081L9:NavigationDrawer.kt#uh7d8r");
                content.invoke(composer12, Integer.valueOf(i54 &= 14));
                ComposerKt.sourceInformationMarkerEnd(composer12);
                ComposerKt.sourceInformationMarkerEnd(composer12);
                rememberDrawerState.endNode();
                ComposerKt.sourceInformationMarkerEnd(rememberDrawerState);
                ComposerKt.sourceInformationMarkerEnd(rememberDrawerState);
                ComposerKt.sourceInformationMarkerEnd(rememberDrawerState);
                ComposerKt.sourceInformationMarkerEnd(rememberDrawerState);
                composer6.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer6);
                ComposerKt.sourceInformationMarkerEnd(composer6);
                ComposerKt.sourceInformationMarkerEnd(composer6);
                ComposerKt.sourceInformationMarkerEnd(composer14);
                restartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $dirty2 = obj5;
                z = z2;
                obj2 = obj4;
            } else {
                restartGroup.skipToGroupEnd();
                i38 = $dirty;
                obj6 = iNSTANCE;
                $dirty2 = rememberDrawerState;
                z = maybeCachedBoxMeasurePolicy;
                obj2 = obj4;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new NavigationDrawerKt.DismissibleNavigationDrawer.3(drawerContent, $dirty2, obj2, z, obj6, $changed, i8);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    private static final boolean DismissibleNavigationDrawer$lambda$16(MutableState<Boolean> $anchorsInitialized$delegate) {
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (Boolean)(State)$anchorsInitialized$delegate.getValue().booleanValue();
    }

    private static final void DismissibleNavigationDrawer$lambda$17(MutableState<Boolean> $anchorsInitialized$delegate, boolean value) {
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        $anchorsInitialized$delegate.setValue(Boolean.valueOf(value));
    }

    public static final void DrawerSheet-7zSek6w(androidx.compose.material3.DrawerPredictiveBackState drawerPredictiveBackState, WindowInsets windowInsets, Modifier modifier, Shape drawerShape, long drawerContainerColor, long drawerContentColor, float drawerTonalElevation, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i11) {
        long l;
        int i5;
        int traceInProgress;
        int defaultsInvalid;
        int iNSTANCE;
        int i8;
        int i3;
        boolean traceInProgress2;
        int i2;
        int i15;
        Object $composer2;
        int $dirty;
        Object $dirty2;
        int i17;
        int i4;
        int str;
        long l2;
        Object obj3;
        int i6;
        Modifier predictiveBackDrawerContainer;
        long l3;
        Object obj2;
        int i16;
        int i18;
        int changed2;
        int i12;
        float modifier2;
        long standardContainerColor;
        int i19;
        Object obj;
        int changed;
        long i13;
        int i9;
        long drawerContentColor2;
        float f;
        int i10;
        int i;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        Composer composer;
        int i14;
        int i7;
        int obj28;
        int obj29;
        int obj30;
        float obj31;
        int obj32;
        int obj33;
        int obj34;
        Object obj4 = drawerPredictiveBackState;
        final Object obj5 = windowInsets;
        final Object obj8 = $changed;
        final int i48 = obj37;
        final int i49 = obj38;
        Composer restartGroup = i11.startRestartGroup(-151557245);
        ComposerKt.sourceInformation(restartGroup, "C(DrawerSheet)P(3,7,6,4,1:c#ui.graphics.Color,2:c#ui.graphics.Color,5:c#ui.unit.Dp)759@31534L22,760@31590L37,764@31790L7,779@32434L545,769@32027L952:NavigationDrawer.kt#uh7d8r");
        $dirty = obj37;
        if (i49 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (i48 & 6 == 0) {
                i17 = restartGroup.changed(obj4) ? 4 : 2;
                $dirty |= i17;
            }
        }
        if (i49 & 2 != 0) {
            $dirty |= 48;
        } else {
            if (i48 & 48 == 0) {
                i4 = restartGroup.changed(obj5) ? 32 : 16;
                $dirty |= i4;
            }
        }
        str = i49 & 4;
        if (str != null) {
            $dirty |= 384;
            obj3 = modifier;
        } else {
            if (i48 & 384 == 0) {
                i6 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty |= i6;
            } else {
                obj3 = modifier;
            }
        }
        int i43 = i49 & 8;
        if (i43 != 0) {
            $dirty |= 3072;
            obj2 = drawerShape;
        } else {
            if (i48 & 3072 == 0) {
                i16 = restartGroup.changed(drawerShape) ? 2048 : 1024;
                $dirty |= i16;
            } else {
                obj2 = drawerShape;
            }
        }
        if (i48 & 24576 == 0) {
            if (i49 & 16 == 0) {
                i18 = restartGroup.changed(drawerContainerColor) ? 16384 : 8192;
            } else {
                standardContainerColor = drawerContainerColor;
            }
            $dirty |= i18;
        } else {
            standardContainerColor = drawerContainerColor;
        }
        if (i47 &= i48 == 0) {
            if (i49 & 32 == 0) {
                changed = restartGroup.changed(drawerTonalElevation) ? 131072 : 65536;
            } else {
                l = drawerTonalElevation;
            }
            $dirty |= changed;
        } else {
            l = drawerTonalElevation;
        }
        i13 = i49 & 64;
        i9 = 1572864;
        if (i13 != 0) {
            $dirty |= i9;
            modifier2 = $composer;
        } else {
            if (i48 & i9 == 0) {
                i9 = restartGroup.changed($composer) ? 1048576 : 524288;
                $dirty |= i9;
            } else {
                modifier2 = $composer;
            }
        }
        int i32 = 12582912;
        if (i49 & 128 != 0) {
            $dirty |= i32;
        } else {
            if (i48 & i32 == 0) {
                i5 = restartGroup.changedInstance(obj8) ? 8388608 : 4194304;
                $dirty |= i5;
            }
        }
        int i51 = i32;
        if (i21 &= $dirty == 4793490) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i33 = -458753;
                int i52 = -57345;
                if (i48 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (str != null) {
                            obj3 = defaultsInvalid;
                        }
                        if (i43 != 0) {
                            obj2 = defaultsInvalid;
                        }
                        if (i49 & 16 != 0) {
                            standardContainerColor = DrawerDefaults.INSTANCE.getStandardContainerColor(restartGroup, 6);
                            $dirty &= i52;
                        }
                        if (i49 & 32 != 0) {
                            drawerContentColor2 = ColorSchemeKt.contentColorFor-ek8zF_U(standardContainerColor, obj14, restartGroup);
                            $dirty &= i33;
                        } else {
                            drawerContentColor2 = drawerTonalElevation;
                        }
                        if (i13 != 0) {
                            f = permanentDrawerElevation-D9Ej5fM;
                            i3 = i51;
                            i13 = standardContainerColor;
                            obj = obj2;
                        } else {
                            f = modifier2;
                            i3 = i51;
                            i13 = standardContainerColor;
                            obj = obj2;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i49 & 16 != 0) {
                            $dirty &= i52;
                        }
                        if (i49 & 32 != 0) {
                            drawerContentColor2 = drawerTonalElevation;
                            $dirty = i31;
                            f = modifier2;
                            i3 = i51;
                            i13 = standardContainerColor;
                            obj = obj2;
                        } else {
                            drawerContentColor2 = drawerTonalElevation;
                            f = modifier2;
                            i3 = i51;
                            i13 = standardContainerColor;
                            obj = obj2;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-151557245, $dirty, -1, "androidx.compose.material3.DrawerSheet (NavigationDrawer.kt:763)");
                }
                int i39 = 0;
                int i44 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                int i40 = 1;
                i2 = restartGroup.consume((CompositionLocal)CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl ? i40 : 0;
                if (drawerPredictiveBackState != null) {
                    predictiveBackDrawerContainer = NavigationDrawerKt.predictiveBackDrawerContainer((Modifier)Modifier.Companion, drawerPredictiveBackState, i2);
                } else {
                    obj2 = drawerPredictiveBackState;
                    predictiveBackDrawerContainer = Modifier.Companion;
                }
                i = 0;
                obj28 = obj3;
                NavigationDrawerKt.DrawerSheet.1 anon = new NavigationDrawerKt.DrawerSheet.1(obj2, i2, obj5, obj8);
                obj29 = i2;
                SurfaceKt.Surface-T9BRK9s(SizeKt.fillMaxHeight$default(SizeKt.sizeIn-qDBjuR0$default(obj28, NavigationDrawerKt.MinimumDrawerWidth, 0, DrawerDefaults.INSTANCE.getMaximumDrawerWidth-D9Ej5fM(), 0, 10, i).then(predictiveBackDrawerContainer), 0, i40, 0), obj, i13, i51, drawerContentColor2, obj18, f, 0, i, (Function2)ComposableLambdaKt.rememberComposableLambda(669057502, i40, anon, restartGroup, 54), restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i19 = $dirty;
                $composer2 = obj7;
                $dirty2 = obj;
                l2 = i13;
                l3 = drawerContentColor2;
                modifier2 = f;
            } else {
                restartGroup.skipToGroupEnd();
                composer = restartGroup;
                $composer2 = obj3;
                l2 = standardContainerColor;
                i19 = $dirty;
                $dirty2 = obj2;
                l3 = drawerTonalElevation;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new NavigationDrawerKt.DrawerSheet.2(drawerPredictiveBackState, obj5, $composer2, $dirty2, l2, obj3, l3, obj2, modifier2, obj8, i48, i49);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void ModalDrawerSheet-Snr_uVM(androidx.compose.material3.DrawerState drawerState, Modifier modifier, Shape drawerShape, long drawerContainerColor, long drawerContentColor, float drawerTonalElevation, WindowInsets windowInsets, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i11) {
        Object obj4;
        int traceInProgress;
        int windowInsets2;
        boolean traceInProgress2;
        int defaultsInvalid;
        int shape;
        int drawerShape2;
        int modalDrawerElevation-D9Ej5fM;
        int $dirty;
        Object $dirty2;
        int i6;
        int str;
        Object obj;
        Object obj10;
        long l4;
        int i2;
        Object obj7;
        int changed;
        long modalContainerColor;
        long l;
        int changed2;
        long contentColorFor-ek8zF_U;
        float f2;
        Object obj5;
        int changed4;
        int i4;
        float f;
        int i;
        int i5;
        Object obj8;
        int changed3;
        int i3;
        androidx.compose.material3.NavigationDrawerKt.ModalDrawerSheet.2 anon;
        Object obj6;
        Object obj2;
        Object obj9;
        long l2;
        long l3;
        float f3;
        Object obj3;
        float f4;
        int obj38;
        final Object obj11 = drawerState;
        final int i28 = obj39;
        final int i29 = obj40;
        final Composer restartGroup = i11.startRestartGroup(1513027356);
        ComposerKt.sourceInformation(restartGroup, "C(ModalDrawerSheet)P(4,6,3,1:c#ui.graphics.Color,2:c#ui.graphics.Color,5:c#ui.unit.Dp,7)605@24793L5,606@24849L19,607@24902L37,609@25057L12,612@25168L299,612@25127L340:NavigationDrawer.kt#uh7d8r");
        $dirty = obj39;
        if (i29 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (i28 & 6 == 0) {
                i6 = restartGroup.changed(obj11) ? 4 : 2;
                $dirty |= i6;
            }
        }
        int i15 = i29 & 2;
        if (i15 != 0) {
            $dirty |= 48;
            obj10 = modifier;
        } else {
            if (i28 & 48 == 0) {
                i2 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i2;
            } else {
                obj10 = modifier;
            }
        }
        if (i28 & 384 == 0) {
            if (i29 & 4 == 0) {
                changed = restartGroup.changed(drawerShape) ? 256 : 128;
            } else {
                obj7 = drawerShape;
            }
            $dirty |= changed;
        } else {
            obj7 = drawerShape;
        }
        if (i28 & 3072 == 0) {
            if (i29 & 8 == 0) {
                changed2 = restartGroup.changed(drawerContainerColor) ? 2048 : 1024;
            } else {
                modalContainerColor = drawerContainerColor;
            }
            $dirty |= changed2;
        } else {
            modalContainerColor = drawerContainerColor;
        }
        if (i28 & 24576 == 0) {
            if (i29 & 16 == 0) {
                changed4 = restartGroup.changed(drawerTonalElevation) ? 16384 : 8192;
            } else {
                contentColorFor-ek8zF_U = drawerTonalElevation;
            }
            $dirty |= changed4;
        } else {
            contentColorFor-ek8zF_U = drawerTonalElevation;
        }
        i4 = i29 & 32;
        int i30 = 196608;
        if (i4 != 0) {
            $dirty |= i30;
            f = content;
        } else {
            if (i30 &= i28 == 0) {
                i5 = restartGroup.changed(content) ? 131072 : 65536;
                $dirty |= i5;
            } else {
                f = content;
            }
        }
        if (i32 &= i28 == 0) {
            if (i29 & 64 == 0) {
                changed3 = restartGroup.changed($composer) ? 1048576 : 524288;
            } else {
                obj8 = $composer;
            }
            $dirty |= changed3;
        } else {
            obj8 = $composer;
        }
        i3 = 12582912;
        if (i29 & 128 != 0) {
            $dirty |= i3;
            obj4 = $changed;
        } else {
            if (i28 & i3 == 0) {
                i3 = restartGroup.changedInstance($changed) ? 8388608 : 4194304;
                $dirty |= i3;
            } else {
                obj4 = $changed;
            }
        }
        if ($dirty & anon == 4793490) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                str = -3670017;
                int i35 = -57345;
                if (i28 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i15 != 0) {
                            obj10 = defaultsInvalid;
                        }
                        str = 6;
                        if (i29 & 4 != 0) {
                            $dirty &= -897;
                            obj7 = shape;
                        }
                        if (i29 & 8 != 0) {
                            modalContainerColor = DrawerDefaults.INSTANCE.getModalContainerColor(restartGroup, str);
                            $dirty &= -7169;
                        }
                        if (i29 & 16 != 0) {
                            contentColorFor-ek8zF_U = ColorSchemeKt.contentColorFor-ek8zF_U(modalContainerColor, obj7, restartGroup);
                            $dirty &= i35;
                        }
                        if (i4 != 0) {
                            f = modalDrawerElevation-D9Ej5fM;
                        }
                        if (i29 & 64 != 0) {
                            $dirty &= obj38;
                            obj6 = windowInsets2;
                            obj2 = obj10;
                            obj9 = obj7;
                            l2 = modalContainerColor;
                            l3 = contentColorFor-ek8zF_U;
                            f3 = f;
                        } else {
                            obj2 = obj10;
                            obj9 = obj7;
                            l2 = modalContainerColor;
                            l3 = contentColorFor-ek8zF_U;
                            f3 = f;
                            obj6 = obj8;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i29 & 4 != 0) {
                            $dirty &= -897;
                        }
                        if (i29 & 8 != 0) {
                            $dirty &= -7169;
                        }
                        if (i29 & 16 != 0) {
                            $dirty &= i35;
                        }
                        if (i29 & 64 != 0) {
                            $dirty = windowInsets2;
                            obj2 = obj10;
                            obj9 = obj7;
                            l2 = modalContainerColor;
                            l3 = contentColorFor-ek8zF_U;
                            f3 = f;
                            obj6 = obj8;
                        } else {
                            obj2 = obj10;
                            obj9 = obj7;
                            l2 = modalContainerColor;
                            l3 = contentColorFor-ek8zF_U;
                            f3 = f;
                            obj6 = obj8;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1513027356, $dirty, -1, "androidx.compose.material3.ModalDrawerSheet (NavigationDrawer.kt:611)");
                }
                anon = new NavigationDrawerKt.ModalDrawerSheet.2(obj6, obj2, obj9, l2, obj22, l3, obj24, f3, $changed);
                NavigationDrawer_androidKt.DrawerPredictiveBackHandler(obj11, (Function3)ComposableLambdaKt.rememberComposableLambda(1552342929, true, anon, restartGroup, 54), restartGroup, i18 |= 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i = $dirty;
                obj5 = obj6;
                $dirty2 = obj2;
                obj = obj9;
                l4 = l2;
                l = l3;
                f2 = f3;
            } else {
                restartGroup.skipToGroupEnd();
                obj = obj7;
                i = $dirty;
                $dirty2 = obj10;
                l4 = modalContainerColor;
                l = contentColorFor-ek8zF_U;
                f2 = f4;
                obj5 = obj8;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new NavigationDrawerKt.ModalDrawerSheet.3(obj11, $dirty2, obj, l4, obj7, l, obj7, f2, obj5, $changed, i28, i29);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void ModalDrawerSheet-afqeVBk(Modifier modifier, Shape drawerShape, long drawerContainerColor, long drawerContentColor, float drawerTonalElevation, WindowInsets windowInsets, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i10) {
        int traceInProgress;
        int windowInsets3;
        int defaultsInvalid;
        int shape;
        int drawerShape2;
        int modalDrawerElevation-D9Ej5fM;
        Object $composer2;
        int $dirty;
        Object $dirty2;
        int i6;
        long l2;
        Object obj3;
        boolean traceInProgress2;
        int i2;
        Object str;
        long l3;
        int changed3;
        long modalContainerColor;
        float f;
        int changed2;
        long contentColorFor-ek8zF_U;
        Object obj2;
        int i3;
        int changed;
        int i7;
        float f3;
        Object drawerTonalElevation2;
        int windowInsets2;
        int i5;
        Object obj;
        int changed4;
        Object obj4;
        int i9;
        long i;
        long l;
        float f2;
        Composer composer2;
        Composer composer;
        int i4;
        int i8;
        int obj33;
        final int i51 = obj34;
        Composer restartGroup = i10.startRestartGroup(1001163336);
        ComposerKt.sourceInformation(restartGroup, "C(ModalDrawerSheet)P(5,3,1:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.unit.Dp,6)561@22840L5,562@22896L19,563@22949L37,565@23104L12,568@23174L225:NavigationDrawer.kt#uh7d8r");
        $dirty = obj34;
        int i26 = obj35 & 1;
        if (i26 != 0) {
            $dirty |= 6;
            obj3 = modifier;
        } else {
            if (i51 & 6 == 0) {
                i2 = restartGroup.changed(modifier) ? 4 : 2;
                $dirty |= i2;
            } else {
                obj3 = modifier;
            }
        }
        if (i51 & 48 == 0) {
            if (obj35 & 2 == 0) {
                changed3 = restartGroup.changed(drawerShape) ? 32 : 16;
            } else {
                str = drawerShape;
            }
            $dirty |= changed3;
        } else {
            str = drawerShape;
        }
        if (i51 & 384 == 0) {
            if (obj35 & 4 == 0) {
                changed2 = restartGroup.changed(drawerContainerColor) ? 256 : 128;
            } else {
                modalContainerColor = drawerContainerColor;
            }
            $dirty |= changed2;
        } else {
            modalContainerColor = drawerContainerColor;
        }
        if (i51 & 3072 == 0) {
            if (obj35 & 8 == 0) {
                changed = restartGroup.changed(drawerTonalElevation) ? 2048 : 1024;
            } else {
                contentColorFor-ek8zF_U = drawerTonalElevation;
            }
            $dirty |= changed;
        } else {
            contentColorFor-ek8zF_U = drawerTonalElevation;
        }
        i7 = obj35 & 16;
        if (i7 != 0) {
            $dirty |= 24576;
            f3 = content;
        } else {
            if (i51 & 24576 == 0) {
                i5 = restartGroup.changed(content) ? 16384 : 8192;
                $dirty |= i5;
            } else {
                f3 = content;
            }
        }
        if (i53 &= i51 == 0) {
            if (obj35 & 32 == 0) {
                changed4 = restartGroup.changed($composer) ? 131072 : 65536;
            } else {
                obj = $composer;
            }
            $dirty |= changed4;
        } else {
            obj = $composer;
        }
        i9 = 1572864;
        if (obj35 & 64 != 0) {
            $dirty |= i9;
            obj4 = $changed;
        } else {
            if (i51 & i9 == 0) {
                i9 = restartGroup.changedInstance($changed) ? 1048576 : 524288;
                $dirty |= i9;
            } else {
                obj4 = $changed;
            }
        }
        if (i58 &= $dirty == 599186) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                obj33 = -458753;
                int i59 = 6;
                if (i51 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i26 != 0) {
                            obj3 = defaultsInvalid;
                        }
                        if (obj35 & 2 != 0) {
                            $dirty &= -113;
                            str = shape;
                        }
                        if (obj35 & 4 != 0) {
                            modalContainerColor = DrawerDefaults.INSTANCE.getModalContainerColor(restartGroup, i59);
                            $dirty &= -897;
                        }
                        if (obj35 & 8 != 0) {
                            contentColorFor-ek8zF_U = ColorSchemeKt.contentColorFor-ek8zF_U(modalContainerColor, obj7, restartGroup);
                            $dirty &= -7169;
                        }
                        if (i7 != 0) {
                            f3 = modalDrawerElevation-D9Ej5fM;
                        }
                        if (obj35 & 32 != 0) {
                            $dirty &= obj33;
                            obj = obj3;
                            obj4 = str;
                            l = contentColorFor-ek8zF_U;
                            f2 = f3;
                            i6 = 1001163336;
                            drawerTonalElevation2 = windowInsets4;
                            windowInsets3 = i59;
                            i = modalContainerColor;
                        } else {
                            obj4 = str;
                            l = contentColorFor-ek8zF_U;
                            f2 = f3;
                            drawerTonalElevation2 = obj;
                            windowInsets3 = i59;
                            i6 = 1001163336;
                            obj = obj3;
                            i = modalContainerColor;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (obj35 & 2 != 0) {
                            $dirty &= -113;
                        }
                        if (obj35 & 4 != 0) {
                            $dirty &= -897;
                        }
                        if (obj35 & 8 != 0) {
                            $dirty &= -7169;
                        }
                        if (obj35 & 32 != 0) {
                            $dirty = i16;
                            obj4 = str;
                            l = contentColorFor-ek8zF_U;
                            f2 = f3;
                            drawerTonalElevation2 = obj;
                            windowInsets3 = i59;
                            i6 = 1001163336;
                            obj = obj3;
                            i = modalContainerColor;
                        } else {
                            obj4 = str;
                            l = contentColorFor-ek8zF_U;
                            f2 = f3;
                            drawerTonalElevation2 = obj;
                            windowInsets3 = i59;
                            i6 = 1001163336;
                            obj = obj3;
                            i = modalContainerColor;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i6, $dirty, -1, "androidx.compose.material3.ModalDrawerSheet (NavigationDrawer.kt:567)");
                }
                NavigationDrawerKt.DrawerSheet-7zSek6w(0, drawerTonalElevation2, obj, obj4, i, obj16, l, obj18, f2, $changed, restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj2 = drawerTonalElevation2;
                $composer2 = obj;
                l2 = i;
                l3 = l;
                f = f2;
                windowInsets2 = $dirty;
                $dirty2 = obj4;
            } else {
                restartGroup.skipToGroupEnd();
                composer = restartGroup;
                $composer2 = obj3;
                l2 = modalContainerColor;
                f = f3;
                windowInsets2 = $dirty;
                $dirty2 = str;
                l3 = contentColorFor-ek8zF_U;
                obj2 = obj;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new NavigationDrawerKt.ModalDrawerSheet.1($composer2, $dirty2, l2, obj3, l3, modalContainerColor, f, obj2, $changed, i51, obj35);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void ModalNavigationDrawer-FHprtrg(Function2<? super Composer, ? super Integer, Unit> drawerContent, Modifier modifier, androidx.compose.material3.DrawerState drawerState, boolean gesturesEnabled, long scrimColor, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i9) {
        Object composer$iv;
        Function0 factory$iv$iv$iv;
        int i31;
        Object $i$a$CacheNavigationDrawerKt$ModalNavigationDrawer$2$2;
        Object $i$a$CacheNavigationDrawerKt$ModalNavigationDrawer$2$3;
        Object $i$a$CacheNavigationDrawerKt$ModalNavigationDrawer$2$6;
        Object semantics$default;
        Object empty;
        int empty2;
        boolean traceInProgress2;
        boolean currentCompositionLocalMap2;
        int changed;
        int i20;
        int i23;
        int empty3;
        Object $i$a$CacheNavigationDrawerKt$ModalNavigationDrawer$2$4;
        Object navigationMenu;
        Function0 factory$iv$iv;
        int changed3;
        int changed2;
        Object obj6;
        int $dirty;
        Object $dirty2;
        int i36;
        Object modifier5;
        Integer currentCompositionLocalMap;
        Object obj2;
        int compositionCoroutineScope;
        Composer composer6;
        Object coroutineScope2;
        boolean z2;
        Object obj5;
        int rememberDrawerState;
        boolean traceInProgress;
        Object empty6;
        Function0 factory$iv$iv$iv2;
        Object it$iv;
        int i37;
        int changed7;
        long l3;
        int i12;
        Object obj4;
        Object empty4;
        int i34;
        Object mutableStateOf$default;
        int i30;
        int changed6;
        int i15;
        int $i$a$CacheNavigationDrawerKt$ModalNavigationDrawer$minValue$2;
        int defaultsInvalid;
        Object $i$a$CacheNavigationDrawerKt$ModalNavigationDrawer$anchorsInitialized$2;
        boolean changed8;
        int changed9;
        int currentCompositeKeyHash;
        boolean obj;
        int i6;
        long scrimColor2;
        int i7;
        Object $i$a$CacheNavigationDrawerKt$ModalNavigationDrawer$1;
        Object empty5;
        int changed5;
        boolean z3;
        int changed4;
        int i21;
        int i14;
        Composer composer5;
        Composer composer2;
        int i28;
        int i25;
        int i32;
        int i22;
        Object maybeCachedBoxMeasurePolicy2;
        Object maybeCachedBoxMeasurePolicy;
        Modifier materializeModifier;
        int i18;
        int companion2;
        Object obj7;
        Composer.Companion companion6;
        int i3;
        boolean z;
        int i11;
        Object $i$a$RememberCoroutineScopeEffectsKt$rememberCoroutineScope$1;
        int i4;
        int companion3;
        int i13;
        int companion5;
        Composer.Companion companion;
        int i2;
        int invalid$iv2;
        int invalid$iv;
        Object obj8;
        int i26;
        int invalid$iv3;
        long l2;
        long l;
        Function0 function02;
        int i10;
        kotlinx.coroutines.CoroutineScope coroutineScope;
        Alignment alignment;
        int i29;
        int currentCompositeKeyHash2;
        Modifier modifier3;
        Function0 function0;
        int i5;
        int i35;
        Object obj3;
        String str;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv2;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy;
        int i17;
        int i16;
        BoxScopeInstance boxScopeInstance2;
        Modifier modifier4;
        Composer composer;
        int i8;
        int i24;
        int currentCompositeKeyHash3;
        int i;
        int i38;
        androidx.compose.ui.Modifier.Companion companion4;
        Function0 function03;
        int i27;
        int i33;
        Composer composer3;
        String str2;
        int i19;
        BoxScopeInstance boxScopeInstance;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy2;
        Composer composer4;
        Modifier modifier2;
        Composer obj63;
        int obj64;
        Composer obj65;
        int obj66;
        int obj67;
        int obj69;
        empty4 = $composer;
        i15 = i9;
        final Composer restartGroup = $changed.startRestartGroup(-1169303680);
        ComposerKt.sourceInformation(restartGroup, "C(ModalNavigationDrawer)P(1,4,2,3,5:c#ui.graphics.Color)316@12708L39,318@12825L10,321@12893L24,322@12943L33,323@13008L7,324@13046L34,325@13101L45,328@13185L33,328@13174L44,330@13257L7,331@13292L3053:NavigationDrawer.kt#uh7d8r");
        $dirty = i9;
        int i74 = 2;
        if (obj71 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (i15 & 6 == 0) {
                i36 = restartGroup.changedInstance(drawerContent) ? 4 : i74;
                $dirty |= i36;
            }
        }
        int i69 = obj71 & 2;
        if (i69 != 0) {
            $dirty |= 48;
            obj5 = modifier;
        } else {
            if (i15 & 48 == 0) {
                i12 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i12;
            } else {
                obj5 = modifier;
            }
        }
        if (i15 & 384 == 0) {
            if (obj71 & 4 == 0) {
                changed9 = restartGroup.changed(drawerState) ? 256 : 128;
            } else {
                obj4 = drawerState;
            }
            $dirty |= changed9;
        } else {
            obj4 = drawerState;
        }
        currentCompositeKeyHash = obj71 & 8;
        if (currentCompositeKeyHash != 0) {
            $dirty |= 3072;
            obj = gesturesEnabled;
        } else {
            if (i15 & 3072 == 0) {
                i6 = restartGroup.changed(gesturesEnabled) ? 2048 : 1024;
                $dirty |= i6;
            } else {
                obj = gesturesEnabled;
            }
        }
        if (i15 & 24576 == 0) {
            if (obj71 & 16 == 0) {
                changed4 = restartGroup.changed(scrimColor) ? 16384 : 8192;
            } else {
                scrimColor2 = scrimColor;
            }
            $dirty |= changed4;
        } else {
            scrimColor2 = scrimColor;
        }
        if (obj71 & 32 != 0) {
            i21 = 196608;
            $dirty |= i21;
        } else {
        }
        if (i124 &= $dirty == 74898) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i39 = 6;
                if (i15 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i69 != 0) {
                            modifier5 = Modifier.Companion;
                        } else {
                            modifier5 = obj5;
                        }
                        if (obj71 & 4 != 0) {
                            $dirty &= -897;
                            obj4 = rememberDrawerState;
                        }
                        if (currentCompositeKeyHash != 0) {
                            obj = rememberDrawerState;
                        }
                        if (obj71 & 16 != 0) {
                            scrimColor2 = DrawerDefaults.INSTANCE.getScrimColor(restartGroup, i39);
                            $dirty &= obj5;
                            z = obj;
                        } else {
                            z = obj;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (obj71 & 4 != 0) {
                            $dirty &= -897;
                        }
                        if (obj71 & 16 != 0) {
                            $dirty &= i73;
                            modifier5 = obj5;
                            z = obj;
                        } else {
                            modifier5 = obj5;
                            z = obj;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1169303680, $dirty, -1, "androidx.compose.material3.ModalNavigationDrawer (NavigationDrawer.kt:320)");
                }
                int i98 = i76;
                int i104 = 0;
                int i144 = i39;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                Composer composer7 = restartGroup;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -954363344, "CC(remember):Effects.kt#9igjgp");
                compositionCoroutineScope = 0;
                Composer composer15 = restartGroup;
                int i146 = 0;
                Object rememberedValue9 = composer15.rememberedValue();
                int i149 = 0;
                if (rememberedValue9 == Composer.Companion.getEmpty()) {
                    empty6 = 0;
                    int i155 = 0;
                    obj64 = compositionCoroutineScope;
                    obj65 = composer7;
                    composer$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope((CoroutineContext)EmptyCoroutineContext.INSTANCE, composer7));
                    composer15.updateRememberedValue(composer$iv);
                } else {
                    obj65 = composer7;
                    obj64 = compositionCoroutineScope;
                    composer$iv = rememberedValue9;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                coroutineScope2 = (CompositionScopedCoroutineScopeCanceller)composer$iv.getCoroutineScope();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                androidx.compose.material3.internal.Strings.Companion companion7 = Strings.Companion;
                int i77 = 0;
                int i99 = 0;
                int i105 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                Object this_$iv2 = consume2;
                String str7 = "CC(remember):NavigationDrawer.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -2145781231, str7);
                Composer composer16 = restartGroup;
                int i126 = 0;
                mutableStateOf$default = composer16.rememberedValue();
                int i147 = 0;
                obj64 = i101;
                if (mutableStateOf$default == Composer.Companion.getEmpty()) {
                    obj65 = mutableStateOf$default;
                    obj66 = i102;
                    l = scrimColor2;
                    scrimColor2 = 0;
                    composer16.updateRememberedValue(SnapshotStateKt.mutableStateOf$default(false, scrimColor2, 2, scrimColor2));
                } else {
                    obj65 = mutableStateOf$default;
                    l = scrimColor2;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerStart(restartGroup, -2145779460, str7);
                changed8 = restartGroup.changed((Density)this_$iv2);
                Composer composer17 = restartGroup;
                int i114 = 0;
                Object rememberedValue7 = composer17.rememberedValue();
                int i127 = 0;
                if (!changed8) {
                    obj64 = changed8;
                    if (rememberedValue7 == Composer.Companion.getEmpty()) {
                        int invalid$iv7 = 0;
                        composer17.updateRememberedValue(PrimitiveSnapshotStateKt.mutableFloatStateOf(0));
                    } else {
                        $i$a$CacheNavigationDrawerKt$ModalNavigationDrawer$minValue$2 = rememberedValue7;
                    }
                } else {
                    obj64 = changed8;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                obj = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -2145776784, str7);
                if (i116 ^= 384 > 256) {
                    if (!restartGroup.changed(obj4)) {
                        i7 = $dirty & 384 == 256 ? 1 : 0;
                    } else {
                    }
                } else {
                }
                i7 |= changed15;
                Composer composer18 = restartGroup;
                int i145 = 0;
                Object rememberedValue8 = composer18.rememberedValue();
                int i148 = 0;
                if (empty5 == 0) {
                    obj65 = empty5;
                    if (rememberedValue8 == Composer.Companion.getEmpty()) {
                        obj66 = invalid$iv8;
                        $i$a$CacheNavigationDrawerKt$ModalNavigationDrawer$1 = new NavigationDrawerKt.ModalNavigationDrawer.1.1(obj4, this_$iv2);
                        composer18.updateRememberedValue((Function0)$i$a$CacheNavigationDrawerKt$ModalNavigationDrawer$1);
                    } else {
                        $i$a$CacheNavigationDrawerKt$ModalNavigationDrawer$1 = rememberedValue8;
                    }
                } else {
                    obj65 = empty5;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                EffectsKt.SideEffect((Function0)$i$a$CacheNavigationDrawerKt$ModalNavigationDrawer$1, restartGroup, 0);
                int i128 = 0;
                obj65 = this_$iv2;
                obj66 = i121;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                i4 = restartGroup.consume((CompositionLocal)CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl ? 1 : 0;
                Modifier anchoredDraggable$default = AnchoredDraggableKt.anchoredDraggable$default(SizeKt.fillMaxSize$default(modifier5, 0, 1, 0), obj4.getAnchoredDraggableState$material3_release(), Orientation.Horizontal, z, i4, 0, 16, 0);
                z3 = z;
                companion2 = 0;
                obj66 = i118;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                Alignment topStart2 = Alignment.Companion.getTopStart();
                int i119 = 0;
                obj67 = i129;
                maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(topStart2, i119);
                i11 = 0;
                alignment = topStart2;
                i29 = i119;
                String propagateMinConstraints$iv = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, propagateMinConstraints$iv);
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, 0);
                currentCompositionLocalMap = restartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(restartGroup, anchoredDraggable$default);
                modifier3 = anchoredDraggable$default;
                Function0 function04 = constructor;
                i5 = 0;
                Object obj10 = mutableStateOf$default;
                String anchorsInitialized$delegate2 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, anchorsInitialized$delegate2);
                if (!applier3 instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                restartGroup.startReusableNode();
                if (restartGroup.getInserting()) {
                    restartGroup.createNode(function04);
                } else {
                    factory$iv$iv$iv2 = function04;
                    restartGroup.useNode();
                }
                function0 = factory$iv$iv$iv2;
                Composer constructor-impl3 = Updater.constructor-impl(restartGroup);
                int i152 = 0;
                Updater.set-impl(constructor-impl3, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl3, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i157 = 0;
                Composer composer20 = constructor-impl3;
                int i163 = 0;
                if (!composer20.getInserting()) {
                    localMap$iv$iv2 = currentCompositionLocalMap;
                    measurePolicy = maybeCachedBoxMeasurePolicy;
                    if (!Intrinsics.areEqual(composer20.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        composer20.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        constructor-impl3.apply(Integer.valueOf(currentCompositeKeyHash2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer5 = composer20;
                    }
                } else {
                    localMap$iv$iv2 = currentCompositionLocalMap;
                    measurePolicy = maybeCachedBoxMeasurePolicy;
                }
                Updater.set-impl(constructor-impl3, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                Composer composer11 = restartGroup;
                i17 = i41;
                ComposerKt.sourceInformationMarkerStart(composer11, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                Composer composer19 = composer11;
                i16 = 0;
                boxScopeInstance2 = iNSTANCE;
                modifier4 = materializeModifier2;
                ComposerKt.sourceInformationMarkerStart(composer11, -1884917117, "C341@13601L17,344@13695L268,352@13988L70,342@13627L473,358@14209L245,364@14486L623,379@15121L1218,355@14109L2230:NavigationDrawer.kt#uh7d8r");
                int i153 = i42;
                companion5 = i58;
                ComposerKt.sourceInformationMarkerStart(composer11, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                androidx.compose.ui.Modifier.Companion companion10 = Modifier.Companion;
                Alignment topStart = Alignment.Companion.getTopStart();
                i8 = i81;
                int $i$a$LayoutBoxKt$Box$1$iv = 0;
                i24 = i133;
                maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(topStart, $i$a$LayoutBoxKt$Box$1$iv);
                int i164 = 0;
                Alignment alignment2 = topStart;
                ComposerKt.sourceInformationMarkerStart(composer11, -1323940314, propagateMinConstraints$iv);
                currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer11, 0);
                currentCompositionLocalMap2 = composer11.getCurrentCompositionLocalMap();
                i = $i$a$LayoutBoxKt$Box$1$iv;
                Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer11, (Modifier)companion10);
                companion4 = companion10;
                Function0 function05 = constructor3;
                i38 = 0;
                ComposerKt.sourceInformationMarkerStart(composer11, -692256719, anchorsInitialized$delegate2);
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                composer11.startReusableNode();
                if (composer11.getInserting()) {
                    composer11.createNode(function05);
                } else {
                    factory$iv$iv$iv = function05;
                    composer11.useNode();
                }
                function03 = factory$iv$iv$iv;
                Composer constructor-impl = Updater.constructor-impl(composer11);
                int i166 = 0;
                Updater.set-impl(constructor-impl, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i167 = 0;
                Composer composer22 = constructor-impl;
                int i168 = 0;
                if (!composer22.getInserting()) {
                    localMap$iv$iv = currentCompositionLocalMap2;
                    measurePolicy2 = maybeCachedBoxMeasurePolicy2;
                    if (!Intrinsics.areEqual(composer22.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                        composer22.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer2 = composer22;
                    }
                } else {
                    localMap$iv$iv = currentCompositionLocalMap2;
                    measurePolicy2 = maybeCachedBoxMeasurePolicy2;
                }
                Updater.set-impl(constructor-impl, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                Composer composer8 = composer11;
                int i93 = 0;
                i33 = i46;
                ComposerKt.sourceInformationMarkerStart(composer8, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                i136 |= 6;
                i19 = 0;
                boxScopeInstance = iNSTANCE2;
                modifier2 = materializeModifier3;
                Composer materialized$iv$iv2 = composer3;
                ComposerKt.sourceInformationMarkerStart(materialized$iv$iv2, 2020094509, "C341@13607L9:NavigationDrawer.kt#uh7d8r");
                empty4.invoke(materialized$iv$iv2, Integer.valueOf(i47 &= 14));
                ComposerKt.sourceInformationMarkerEnd(materialized$iv$iv2);
                ComposerKt.sourceInformationMarkerEnd(composer8);
                composer11.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer11);
                ComposerKt.sourceInformationMarkerEnd(composer11);
                ComposerKt.sourceInformationMarkerEnd(composer11);
                ComposerKt.sourceInformationMarkerStart(composer11, -2139013222, str7);
                i31 = $dirty & 7168 == 2048 ? 1 : 0;
                if (i61 ^= 384 > 256) {
                    if (!restartGroup.changed(obj4)) {
                        i20 = $dirty & 384 == 256 ? 1 : 0;
                    } else {
                    }
                } else {
                }
                i51 |= changedInstance;
                Composer composer9 = composer11;
                int i82 = 0;
                Object rememberedValue4 = composer9.rememberedValue();
                int i138 = 0;
                if (empty2 == 0) {
                    invalid$iv2 = empty2;
                    if (rememberedValue4 == Composer.Companion.getEmpty()) {
                        companion5 = invalid$iv5;
                        $i$a$CacheNavigationDrawerKt$ModalNavigationDrawer$2$2 = new NavigationDrawerKt.ModalNavigationDrawer.2.2.1(z3, obj4, coroutineScope2);
                        composer9.updateRememberedValue((Function0)$i$a$CacheNavigationDrawerKt$ModalNavigationDrawer$2$2);
                    } else {
                        $i$a$CacheNavigationDrawerKt$ModalNavigationDrawer$2$2 = rememberedValue4;
                    }
                } else {
                    invalid$iv2 = empty2;
                }
                ComposerKt.sourceInformationMarkerEnd(composer11);
                ComposerKt.sourceInformationMarkerStart(composer11, -2139004044, str7);
                if (i62 ^= 384 > 256) {
                    if (!restartGroup.changed(obj4)) {
                        i23 = $dirty & 384 == 256 ? 1 : 0;
                    } else {
                    }
                } else {
                }
                changed10 |= i23;
                Composer composer10 = composer11;
                int i83 = 0;
                Object rememberedValue5 = composer10.rememberedValue();
                int i139 = 0;
                if (empty == 0) {
                    invalid$iv3 = empty;
                    if (rememberedValue5 == Composer.Companion.getEmpty()) {
                        invalid$iv2 = invalid$iv4;
                        $i$a$CacheNavigationDrawerKt$ModalNavigationDrawer$2$3 = new NavigationDrawerKt.ModalNavigationDrawer.2.3.1(obj, obj4, $i$a$CacheNavigationDrawerKt$ModalNavigationDrawer$minValue$2);
                        composer10.updateRememberedValue((Function0)$i$a$CacheNavigationDrawerKt$ModalNavigationDrawer$2$3);
                    } else {
                        $i$a$CacheNavigationDrawerKt$ModalNavigationDrawer$2$3 = rememberedValue5;
                    }
                } else {
                    invalid$iv3 = empty;
                }
                ComposerKt.sourceInformationMarkerEnd(composer11);
                l2 = l;
                NavigationDrawerKt.Scrim-Bx497Mc(obj4.isOpen(), (Function0)$i$a$CacheNavigationDrawerKt$ModalNavigationDrawer$2$2, (Function0)$i$a$CacheNavigationDrawerKt$ModalNavigationDrawer$2$3, l2, l, composer11);
                ComposerKt.sourceInformationMarkerStart(composer11, -2138996797, str7);
                if (i64 ^= 384 > 256) {
                    if (!restartGroup.changed(obj4)) {
                        empty3 = $dirty & 384 == 256 ? 1 : 0;
                    } else {
                    }
                } else {
                }
                Composer composer12 = composer11;
                int i94 = 0;
                Object rememberedValue10 = composer12.rememberedValue();
                int i154 = 0;
                if (empty3 == 0) {
                    invalid$iv = empty3;
                    if (rememberedValue10 == Composer.Companion.getEmpty()) {
                        companion = invalid$iv6;
                        $i$a$CacheNavigationDrawerKt$ModalNavigationDrawer$2$4 = new NavigationDrawerKt.ModalNavigationDrawer.2.4.1(obj4);
                        composer12.updateRememberedValue((Function1)$i$a$CacheNavigationDrawerKt$ModalNavigationDrawer$2$4);
                    } else {
                        $i$a$CacheNavigationDrawerKt$ModalNavigationDrawer$2$4 = rememberedValue10;
                    }
                } else {
                    invalid$iv = empty3;
                }
                ComposerKt.sourceInformationMarkerEnd(composer11);
                ComposerKt.sourceInformationMarkerStart(composer11, -2138987555, str7);
                String str4 = str9;
                if (i95 ^= 384 > 256) {
                    if (!restartGroup.changed(obj4)) {
                        i30 = $dirty & 384 == 256 ? 1 : 0;
                    } else {
                    }
                } else {
                }
                Composer composer14 = composer11;
                int i140 = 0;
                it$iv = composer14.rememberedValue();
                int i158 = 0;
                if (i84 |= changedInstance3 == 0) {
                    if (it$iv == Composer.Companion.getEmpty()) {
                        empty4 = 0;
                        obj8 = it$iv;
                        it$iv = new NavigationDrawerKt.ModalNavigationDrawer.2.5.1(str4, obj4, coroutineScope2);
                        composer14.updateRememberedValue((Function1)it$iv);
                    } else {
                        obj8 = it$iv;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(composer11);
                int i141 = 1;
                semantics$default = SemanticsModifierKt.semantics$default(OffsetKt.offset((Modifier)Modifier.Companion, (Function1)$i$a$CacheNavigationDrawerKt$ModalNavigationDrawer$2$4), false, (Function1)it$iv, i141, 0);
                ComposerKt.sourceInformationMarkerStart(composer11, -2138966640, str7);
                if (i87 ^= 384 > 256) {
                    if (!restartGroup.changed(obj4)) {
                        i37 = $dirty & 384 == 256 ? i141 : 0;
                    } else {
                    }
                } else {
                }
                Composer composer13 = composer11;
                int i97 = 0;
                Object rememberedValue6 = composer13.rememberedValue();
                int i142 = 0;
                if (i37 |= changed13 == 0) {
                    obj64 = semantics$default;
                    if (rememberedValue6 == Composer.Companion.getEmpty()) {
                        obj69 = i57;
                        str = str4;
                        $i$a$CacheNavigationDrawerKt$ModalNavigationDrawer$2$6 = new NavigationDrawerKt.ModalNavigationDrawer.2.6.1(obj4, obj10, $i$a$CacheNavigationDrawerKt$ModalNavigationDrawer$minValue$2, obj);
                        composer13.updateRememberedValue((MeasurePolicy)$i$a$CacheNavigationDrawerKt$ModalNavigationDrawer$2$6);
                    } else {
                        str = str4;
                        $i$a$CacheNavigationDrawerKt$ModalNavigationDrawer$2$6 = rememberedValue6;
                        navigationMenu = obj10;
                    }
                } else {
                    obj64 = semantics$default;
                }
                ComposerKt.sourceInformationMarkerEnd(composer11);
                i15 = 0;
                ComposerKt.sourceInformationMarkerStart(composer11, -1323940314, propagateMinConstraints$iv);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer11, 0);
                obj3 = navigationMenu;
                obj63 = constructor2;
                i18 = 0;
                i13 = $dirty;
                ComposerKt.sourceInformationMarkerStart(composer11, -692256719, anchorsInitialized$delegate2);
                if (!applier2 instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                composer11.startReusableNode();
                if (composer11.getInserting()) {
                    composer11.createNode(obj63);
                } else {
                    factory$iv$iv = obj63;
                    composer11.useNode();
                }
                Composer constructor-impl2 = Updater.constructor-impl(composer11);
                i2 = 0;
                function02 = factory$iv$iv;
                Updater.set-impl(constructor-impl2, (MeasurePolicy)$i$a$CacheNavigationDrawerKt$ModalNavigationDrawer$2$6, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl2, composer11.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                i26 = 0;
                obj63 = constructor-impl2;
                i10 = 0;
                if (!obj63.getInserting()) {
                    obj69 = $i$a$CacheNavigationDrawerKt$ModalNavigationDrawer$2$6;
                    coroutineScope = coroutineScope2;
                    if (!Intrinsics.areEqual(obj63.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        obj63.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl2.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer6 = obj63;
                    }
                } else {
                    obj69 = $i$a$CacheNavigationDrawerKt$ModalNavigationDrawer$2$6;
                    coroutineScope = coroutineScope2;
                }
                Updater.set-impl(constructor-impl2, ComposedModifierKt.materializeModifier(composer11, obj64), ComposeUiNode.Companion.getSetModifier());
                drawerContent.invoke(composer11, Integer.valueOf(i55 &= 14));
                composer11.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer11);
                ComposerKt.sourceInformationMarkerEnd(composer11);
                ComposerKt.sourceInformationMarkerEnd(composer11);
                ComposerKt.sourceInformationMarkerEnd(composer11);
                restartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj2 = obj4;
                z2 = z3;
                $dirty2 = obj7;
                l3 = l2;
            } else {
                restartGroup.skipToGroupEnd();
                i13 = $dirty;
                $dirty2 = obj5;
                obj2 = obj4;
                z2 = obj;
                l3 = scrimColor2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new NavigationDrawerKt.ModalNavigationDrawer.3(obj6, $dirty2, obj2, z2, l3, obj4, $composer, i9, obj71);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    private static final boolean ModalNavigationDrawer_FHprtrg$lambda$2(MutableState<Boolean> $anchorsInitialized$delegate) {
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (Boolean)(State)$anchorsInitialized$delegate.getValue().booleanValue();
    }

    private static final void ModalNavigationDrawer_FHprtrg$lambda$3(MutableState<Boolean> $anchorsInitialized$delegate, boolean value) {
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        $anchorsInitialized$delegate.setValue(Boolean.valueOf(value));
    }

    private static final float ModalNavigationDrawer_FHprtrg$lambda$5(MutableFloatState $minValue$delegate) {
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (FloatState)$minValue$delegate.getFloatValue();
    }

    private static final void ModalNavigationDrawer_FHprtrg$lambda$6(MutableFloatState $minValue$delegate, float value) {
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        $minValue$delegate.setFloatValue(value);
    }

    public static final void NavigationDrawerItem(Function2<? super Composer, ? super Integer, Unit> label, boolean selected, Function0<Unit> onClick, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> icon, Function2<? super Composer, ? super Integer, Unit> badge, Shape shape, androidx.compose.material3.NavigationDrawerItemColors colors, MutableInteractionSource interactionSource, Composer $composer, int $changed, int i12) {
        boolean traceInProgress2;
        int modifier2;
        int defaultsInvalid;
        Object modifier3;
        Modifier i6;
        int i15;
        int i7;
        int $dirty2;
        Object obj4;
        Object colors2;
        Object shape2;
        Object obj12;
        Object obj14;
        int i11;
        Object obj8;
        Object obj3;
        Object obj10;
        int i4;
        int i10;
        Object obj5;
        boolean traceInProgress;
        Object obj6;
        int i14;
        int value;
        Object navigationDrawerItemColors;
        Object anon;
        int i9;
        int i21;
        int i3;
        Object obj7;
        int i16;
        int i2;
        Object obj13;
        Composer restartGroup;
        int i8;
        Object obj2;
        int changed2;
        int changed;
        int i20;
        int i19;
        int i5;
        androidx.compose.material3.NavigationDrawerItemColors navigationDrawerItemColors2;
        int i13;
        Composer composer2;
        Composer composer;
        int i;
        int i17;
        Object obj;
        Object obj9;
        Object obj11;
        int $dirty;
        int i18;
        androidx.compose.material3.NavigationDrawerKt.NavigationDrawerItem.2 obj32;
        Object obj33;
        androidx.compose.material3.NavigationDrawerItemColors obj34;
        boolean obj35;
        Object obj36;
        Function2 obj37;
        int obj38;
        traceInProgress2 = selected;
        int i27 = $changed;
        i6 = i12;
        restartGroup = $composer.startRestartGroup(-1304626543);
        ComposerKt.sourceInformation(restartGroup, "C(NavigationDrawerItem)P(4,7,6,5,2!1,8)925@38341L5,926@38418L8,938@38801L24,940@38886L884,929@38492L1278:NavigationDrawer.kt#uh7d8r");
        $dirty2 = $changed;
        if (i6 & 1 != 0) {
            $dirty2 |= 6;
            obj12 = label;
        } else {
            if (i27 & 6 == 0) {
                i4 = restartGroup.changedInstance(label) ? 4 : 2;
                $dirty2 |= i4;
            } else {
                obj12 = label;
            }
        }
        if (i6 & 2 != 0) {
            $dirty2 |= 48;
        } else {
            if (i27 & 48 == 0) {
                i10 = restartGroup.changed(traceInProgress2) ? 32 : 16;
                $dirty2 |= i10;
            }
        }
        if (i6 & 4 != 0) {
            $dirty2 |= 384;
            obj5 = onClick;
        } else {
            if (i27 & 384 == 0) {
                i14 = restartGroup.changedInstance(onClick) ? 256 : 128;
                $dirty2 |= i14;
            } else {
                obj5 = onClick;
            }
        }
        value = i6 & 8;
        if (value != null) {
            $dirty2 |= 3072;
            anon = modifier;
        } else {
            if (i27 & 3072 == 0) {
                i21 = restartGroup.changed(modifier) ? 2048 : 1024;
                $dirty2 |= i21;
            } else {
                anon = modifier;
            }
        }
        i3 = i6 & 16;
        if (i3 != 0) {
            $dirty2 |= 24576;
            obj7 = icon;
        } else {
            if (i27 & 24576 == 0) {
                i16 = restartGroup.changedInstance(icon) ? 16384 : 8192;
                $dirty2 |= i16;
            } else {
                obj7 = icon;
            }
        }
        i2 = i6 & 32;
        int i61 = 196608;
        if (i2 != 0) {
            $dirty2 |= i61;
            obj13 = badge;
        } else {
            if (i61 &= i27 == 0) {
                i8 = restartGroup.changedInstance(badge) ? 131072 : 65536;
                $dirty2 |= i8;
            } else {
                obj13 = badge;
            }
        }
        if (i63 &= i27 == 0) {
            if (i6 & 64 == 0) {
                changed2 = restartGroup.changed(shape) ? 1048576 : 524288;
            } else {
                obj2 = shape;
            }
            $dirty2 |= changed2;
        } else {
            obj2 = shape;
        }
        if (i27 & i66 == 0) {
            if (i6 & 128 == 0) {
                changed = restartGroup.changed(colors) ? 8388608 : 4194304;
            } else {
                obj3 = colors;
            }
            $dirty2 |= changed;
        } else {
            obj3 = colors;
        }
        int i32 = i6 & 256;
        i20 = 100663296;
        if (i32 != 0) {
            $dirty2 |= i20;
            obj14 = interactionSource;
        } else {
            if (i27 & i20 == 0) {
                i20 = restartGroup.changed(interactionSource) ? 67108864 : 33554432;
                $dirty2 |= i20;
            } else {
                obj14 = interactionSource;
            }
        }
        if ($dirty2 & i19 == 38347922) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i33 = -29360129;
                int i67 = -3670017;
                if ($changed & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (value != null) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = anon;
                        }
                        obj = i3 != 0 ? value : obj7;
                        obj9 = i2 != 0 ? value : obj13;
                        if (i6 & 64 != 0) {
                            obj11 = value;
                            $dirty = $dirty2;
                        } else {
                            obj11 = obj2;
                            $dirty = $dirty2;
                        }
                        if (i6 & 128 != 0) {
                            composer2 = restartGroup;
                            i15 = 2;
                            obj4 = NavigationDrawerItemDefaults.INSTANCE.colors-oq7We08(0, obj3, 0, value, 0, i3, 0, i2, 0, restartGroup, 0);
                            restartGroup = composer2;
                            $dirty &= obj38;
                        } else {
                            i15 = 2;
                            obj4 = colors;
                        }
                        if (i32 != 0) {
                            obj3 = obj4;
                            i2 = i37;
                            colors2 = obj11;
                            i11 = $dirty;
                        } else {
                            i2 = interactionSource;
                            obj3 = obj4;
                            colors2 = obj11;
                            i11 = $dirty;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i6 & 64 != 0) {
                            $dirty2 &= i67;
                        }
                        if (i6 & 128 != 0) {
                            i2 = obj14;
                            obj = obj7;
                            obj9 = obj13;
                            colors2 = obj2;
                            i15 = 2;
                            i11 = i30;
                            modifier3 = anon;
                        } else {
                            i2 = obj14;
                            modifier3 = anon;
                            obj = obj7;
                            obj9 = obj13;
                            i15 = 2;
                            i11 = $dirty2;
                            colors2 = obj2;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1304626543, i11, -1, "androidx.compose.material3.NavigationDrawerItem (NavigationDrawer.kt:928)");
                }
                int i54 = 1;
                int i57 = 0;
                int i60 = 0;
                i51 &= 112;
                obj34 = obj3;
                obj32 = anon3;
                super(obj, obj34, traceInProgress2, obj9, label);
                i42 &= i55;
                i18 = i11;
                SurfaceKt.Surface-d85dljk(selected, onClick, SizeKt.fillMaxWidth$default(SizeKt.heightIn-VpY3zN4$default(SemanticsModifierKt.semantics$default(modifier3, false, (Function1)NavigationDrawerKt.NavigationDrawerItem.1.INSTANCE, i54, i57), NavigationDrawerTokens.INSTANCE.getActiveIndicatorHeight-D9Ej5fM(), i60, i15, i57), i60, i54, i57), false, colors2, (Color)obj3.containerColor(traceInProgress2, restartGroup, i47 |= i52).getValue().unbox-impl(), i43, 0, i52, 0, 0, 0, i2, (Function2)ComposableLambdaKt.rememberComposableLambda(191488423, i54, obj32, restartGroup, 54), restartGroup, i24 | i43);
                composer = restartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj6 = colors2;
                i9 = i2;
                navigationDrawerItemColors = navigationDrawerItemColors2;
                shape2 = i13;
                obj8 = obj;
                obj10 = obj9;
            } else {
                restartGroup.skipToGroupEnd();
                i18 = $dirty2;
                navigationDrawerItemColors = obj3;
                shape2 = anon;
                obj10 = obj13;
                composer = restartGroup;
                obj6 = obj2;
                i9 = obj14;
                obj8 = obj7;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new NavigationDrawerKt.NavigationDrawerItem.3(label, selected, onClick, shape2, obj8, obj10, obj6, navigationDrawerItemColors, i9, $changed, i12);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void PermanentDrawerSheet-afqeVBk(Modifier modifier, Shape drawerShape, long drawerContainerColor, long drawerContentColor, float drawerTonalElevation, WindowInsets windowInsets, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i10) {
        String string-2EP1pXo;
        int windowInsets3;
        int defaultsInvalid;
        int iNSTANCE;
        int permanentDrawerElevation-D9Ej5fM;
        Object $composer2;
        int $dirty;
        Object $dirty2;
        long l;
        Object anon;
        Object obj;
        int i4;
        long l3;
        boolean traceInProgress;
        Object str;
        int i2;
        long standardContainerColor;
        float f;
        Object obj4;
        int changed;
        int i5;
        int changed3;
        Object rememberedValue;
        long contentColorFor-ek8zF_U;
        int windowInsets2;
        Object obj2;
        float semantics$default;
        int i6;
        Object obj5;
        int changed2;
        Object obj3;
        int i7;
        int i;
        long l4;
        float f2;
        Composer composer2;
        Composer composer;
        int i3;
        int i8;
        long l2;
        int obj35;
        final int i50 = obj36;
        Composer restartGroup = i10.startRestartGroup(-1733353241);
        ComposerKt.sourceInformation(restartGroup, "C(PermanentDrawerSheet)P(5,3,1:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.unit.Dp,6)734@30666L22,735@30722L37,737@30881L12,740@30972L33,744@31114L30,741@31010L266:NavigationDrawer.kt#uh7d8r");
        $dirty = obj36;
        int i17 = obj37 & 1;
        if (i17 != 0) {
            $dirty |= 6;
            obj = modifier;
        } else {
            if (i50 & 6 == 0) {
                i4 = restartGroup.changed(modifier) ? 4 : 2;
                $dirty |= i4;
            } else {
                obj = modifier;
            }
        }
        int i28 = obj37 & 2;
        if (i28 != 0) {
            $dirty |= 48;
            str = drawerShape;
        } else {
            if (i50 & 48 == 0) {
                i2 = restartGroup.changed(drawerShape) ? 32 : 16;
                $dirty |= i2;
            } else {
                str = drawerShape;
            }
        }
        if (i50 & 384 == 0) {
            if (obj37 & 4 == 0) {
                changed = restartGroup.changed(drawerContainerColor) ? 256 : 128;
            } else {
                standardContainerColor = drawerContainerColor;
            }
            $dirty |= changed;
        } else {
            standardContainerColor = drawerContainerColor;
        }
        if (i50 & 3072 == 0) {
            if (obj37 & 8 == 0) {
                i5 = restartGroup.changed(drawerTonalElevation) ? 2048 : 1024;
            } else {
                contentColorFor-ek8zF_U = drawerTonalElevation;
            }
            $dirty |= i5;
        } else {
            contentColorFor-ek8zF_U = drawerTonalElevation;
        }
        rememberedValue = obj37 & 16;
        if (rememberedValue != 0) {
            $dirty |= 24576;
            semantics$default = content;
        } else {
            if (i50 & 24576 == 0) {
                i6 = restartGroup.changed(content) ? 16384 : 8192;
                $dirty |= i6;
            } else {
                semantics$default = content;
            }
        }
        if (i53 &= i50 == 0) {
            if (obj37 & 32 == 0) {
                changed2 = restartGroup.changed($composer) ? 131072 : 65536;
            } else {
                obj5 = $composer;
            }
            $dirty |= changed2;
        } else {
            obj5 = $composer;
        }
        i7 = 1572864;
        if (obj37 & 64 != 0) {
            $dirty |= i7;
            obj3 = $changed;
        } else {
            if (i50 & i7 == 0) {
                i7 = restartGroup.changedInstance($changed) ? 1048576 : 524288;
                $dirty |= i7;
            } else {
                obj3 = $changed;
            }
        }
        if ($dirty & i == 599186) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                i = -458753;
                int i19 = 6;
                if (i50 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i17 != 0) {
                            obj = defaultsInvalid;
                        }
                        if (i28 != 0) {
                            str = defaultsInvalid;
                        }
                        if (obj37 & 4 != 0) {
                            standardContainerColor = DrawerDefaults.INSTANCE.getStandardContainerColor(restartGroup, i19);
                            $dirty &= -897;
                        }
                        if (obj37 & 8 != 0) {
                            contentColorFor-ek8zF_U = ColorSchemeKt.contentColorFor-ek8zF_U(standardContainerColor, obj8, restartGroup);
                            $dirty &= -7169;
                        }
                        if (rememberedValue != 0) {
                            semantics$default = permanentDrawerElevation-D9Ej5fM;
                        }
                        if (obj37 & 32 != 0) {
                            $dirty &= i;
                            obj5 = str;
                            obj3 = standardContainerColor;
                            l4 = contentColorFor-ek8zF_U;
                            f2 = semantics$default;
                            obj2 = windowInsets4;
                            windowInsets3 = -1733353241;
                        } else {
                            obj3 = standardContainerColor;
                            l4 = contentColorFor-ek8zF_U;
                            f2 = semantics$default;
                            obj2 = obj5;
                            windowInsets3 = -1733353241;
                            obj5 = str;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (obj37 & 4 != 0) {
                            $dirty &= -897;
                        }
                        if (obj37 & 8 != 0) {
                            $dirty &= -7169;
                        }
                        if (obj37 & 32 != 0) {
                            $dirty = i14;
                            obj3 = standardContainerColor;
                            l4 = contentColorFor-ek8zF_U;
                            f2 = semantics$default;
                            obj2 = obj5;
                            windowInsets3 = -1733353241;
                            obj5 = str;
                        } else {
                            obj3 = standardContainerColor;
                            l4 = contentColorFor-ek8zF_U;
                            f2 = semantics$default;
                            obj2 = obj5;
                            windowInsets3 = -1733353241;
                            obj5 = str;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(windowInsets3, $dirty, -1, "androidx.compose.material3.PermanentDrawerSheet (NavigationDrawer.kt:739)");
                }
                androidx.compose.material3.internal.Strings.Companion companion = Strings.Companion;
                int i29 = 0;
                int $i$f$getNavigationMenu8iCLdWM = 0;
                string-2EP1pXo = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(R.string.navigation_menu), restartGroup, $i$f$getNavigationMenu8iCLdWM);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 391082081, "CC(remember):NavigationDrawer.kt#9igjgp");
                Composer composer3 = restartGroup;
                int i49 = 0;
                rememberedValue = composer3.rememberedValue();
                int i51 = 0;
                if (!restartGroup.changed(string-2EP1pXo)) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        semantics$default = 0;
                        obj35 = i19;
                        anon = new NavigationDrawerKt.PermanentDrawerSheet.1.1(string-2EP1pXo);
                        composer3.updateRememberedValue((Function1)anon);
                    } else {
                        obj35 = i19;
                        anon = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                NavigationDrawerKt.DrawerSheet-7zSek6w(0, obj2, SemanticsModifierKt.semantics$default(obj, $i$f$getNavigationMenu8iCLdWM, (Function1)anon, 1, 0), obj5, obj3, i, l4, obj18, f2, $changed, restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer2 = obj;
                obj4 = obj2;
                l = obj3;
                l3 = l4;
                f = f2;
                windowInsets2 = $dirty;
                $dirty2 = obj5;
            } else {
                restartGroup.skipToGroupEnd();
                windowInsets2 = $dirty;
                $dirty2 = str;
                l3 = l2;
                composer = restartGroup;
                $composer2 = obj;
                l = standardContainerColor;
                f = semantics$default;
                obj4 = obj5;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            string-2EP1pXo = new NavigationDrawerKt.PermanentDrawerSheet.2($composer2, $dirty2, l, obj, l3, str, f, obj4, $changed, i50, obj37);
            endRestartGroup.updateScope((Function2)string-2EP1pXo);
        }
    }

    public static final void PermanentNavigationDrawer(Function2<? super Composer, ? super Integer, Unit> drawerContent, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i6) {
        int traceInProgress2;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv;
        Object materialized$iv$iv;
        int $dirty2;
        Object obj;
        int $dirty;
        Object modifier5;
        boolean $i$f$Box;
        int i7;
        int i;
        int i22;
        boolean traceInProgress;
        Composer composer4;
        Object valueOf2;
        Object maybeCachedBoxMeasurePolicy;
        Object str;
        Composer composer6;
        Integer valueOf;
        int i12;
        int i17;
        int start;
        androidx.compose.ui.Alignment.Vertical top;
        androidx.compose.ui.layout.MeasurePolicy rowMeasurePolicy;
        int i10;
        int i8;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap2;
        int currentCompositeKeyHash;
        Object obj2;
        int i18;
        Modifier modifier2;
        Function0 function02;
        int i9;
        int i3;
        int i19;
        int i23;
        int i20;
        int i15;
        RowScopeInstance rowScopeInstance;
        Composer $composer2;
        int i13;
        Modifier modifier4;
        Composer composer3;
        int i11;
        int i4;
        int i16;
        int i2;
        Alignment alignment;
        int i14;
        Composer composer2;
        int i21;
        Function0 function0;
        int i5;
        BoxScopeInstance boxScopeInstance;
        int propagateMinConstraints$iv;
        Composer composer;
        Modifier modifier3;
        Composer composer5;
        int obj48;
        androidx.compose.ui.Modifier.Companion obj50;
        materialized$iv$iv = drawerContent;
        final Object obj3 = content;
        i7 = $changed;
        traceInProgress2 = -276843608;
        maybeCachedBoxMeasurePolicy = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(maybeCachedBoxMeasurePolicy, "C(PermanentNavigationDrawer)P(1,2)532@21415L85:NavigationDrawer.kt#uh7d8r");
        $dirty2 = $changed;
        if (i6 & 1 != 0) {
            $dirty2 |= 6;
        } else {
            if (i7 & 6 == 0) {
                i = maybeCachedBoxMeasurePolicy.changedInstance(materialized$iv$iv) ? 4 : 2;
                $dirty2 |= i;
            }
        }
        i22 = i6 & 2;
        if (i22 != 0) {
            $dirty2 |= 48;
            str = modifier;
        } else {
            if (i7 & 48 == 0) {
                i12 = maybeCachedBoxMeasurePolicy.changed(modifier) ? 32 : 16;
                $dirty2 |= i12;
            } else {
                str = modifier;
            }
        }
        if (i6 & 4 != 0) {
            $dirty2 |= 384;
        } else {
            if (i7 & 384 == 0) {
                i17 = maybeCachedBoxMeasurePolicy.changedInstance(obj3) ? 256 : 128;
                $dirty2 |= i17;
            }
        }
        int i50 = $dirty2;
        if (i50 & 147 == 146) {
            if (!maybeCachedBoxMeasurePolicy.getSkipping()) {
                if (i22 != 0) {
                    modifier5 = Modifier.Companion;
                } else {
                    modifier5 = str;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, i50, -1, "androidx.compose.material3.PermanentNavigationDrawer (NavigationDrawer.kt:531)");
                }
                Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(modifier5, 0, 1, 0);
                int i40 = 0;
                valueOf = 0;
                ComposerKt.sourceInformationMarkerStart(maybeCachedBoxMeasurePolicy, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                i8 = 0;
                String str6 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                ComposerKt.sourceInformationMarkerStart(maybeCachedBoxMeasurePolicy, -1323940314, str6);
                int i59 = 0;
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(maybeCachedBoxMeasurePolicy, i59);
                obj50 = i59;
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(maybeCachedBoxMeasurePolicy, fillMaxSize$default);
                modifier2 = fillMaxSize$default;
                Function0 function03 = constructor;
                i18 = 0;
                String str4 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(maybeCachedBoxMeasurePolicy, -692256719, str4);
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                maybeCachedBoxMeasurePolicy.startReusableNode();
                if (maybeCachedBoxMeasurePolicy.getInserting()) {
                    maybeCachedBoxMeasurePolicy.createNode(function03);
                } else {
                    factory$iv$iv$iv2 = function03;
                    maybeCachedBoxMeasurePolicy.useNode();
                }
                function02 = factory$iv$iv$iv2;
                Composer constructor-impl = Updater.constructor-impl(maybeCachedBoxMeasurePolicy);
                int i61 = 0;
                Updater.set-impl(constructor-impl, RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), maybeCachedBoxMeasurePolicy, i53 |= i56), ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, maybeCachedBoxMeasurePolicy.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i62 = 0;
                Composer composer9 = constructor-impl;
                int i63 = 0;
                if (!composer9.getInserting()) {
                    $composer2 = maybeCachedBoxMeasurePolicy;
                    i13 = valueOf;
                    if (!Intrinsics.areEqual(composer9.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer9.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer6 = composer9;
                    }
                } else {
                    $composer2 = maybeCachedBoxMeasurePolicy;
                    i13 = valueOf;
                }
                Updater.set-impl(constructor-impl, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                valueOf2 = $composer2;
                i19 = i28;
                ComposerKt.sourceInformationMarkerStart(valueOf2, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                i49 |= 6;
                Composer composer8 = valueOf2;
                i15 = 0;
                rowScopeInstance = iNSTANCE;
                modifier4 = materializeModifier2;
                ComposerKt.sourceInformationMarkerStart(valueOf2, -882916661, "C533@21453L15,534@21477L17:NavigationDrawer.kt#uh7d8r");
                materialized$iv$iv.invoke(valueOf2, Integer.valueOf(i50 & 14));
                i23 = i30;
                ComposerKt.sourceInformationMarkerStart(valueOf2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                androidx.compose.ui.Modifier.Companion companion = Modifier.Companion;
                Alignment topStart = Alignment.Companion.getTopStart();
                i11 = i38;
                $i$f$Box = 0;
                i4 = i44;
                i2 = 0;
                alignment = topStart;
                ComposerKt.sourceInformationMarkerStart(valueOf2, -1323940314, str6);
                obj48 = currentCompositeKeyHash2;
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(valueOf2, (Modifier)companion);
                obj50 = companion;
                Function0 function04 = constructor2;
                i14 = 0;
                ComposerKt.sourceInformationMarkerStart(valueOf2, -692256719, str4);
                if (!applier2 instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                valueOf2.startReusableNode();
                if (valueOf2.getInserting()) {
                    valueOf2.createNode(function04);
                } else {
                    factory$iv$iv$iv = function04;
                    valueOf2.useNode();
                }
                Composer constructor-impl2 = Updater.constructor-impl(valueOf2);
                int i60 = 0;
                function0 = factory$iv$iv$iv;
                Updater.set-impl(constructor-impl2, BoxKt.maybeCachedBoxMeasurePolicy(topStart, $i$f$Box), ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl2, valueOf2.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i65 = 0;
                Composer composer10 = constructor-impl2;
                int i66 = 0;
                if (!composer10.getInserting()) {
                    propagateMinConstraints$iv = $i$f$Box;
                    composer = valueOf2;
                    if (!Intrinsics.areEqual(composer10.rememberedValue(), Integer.valueOf(obj48))) {
                        composer10.updateRememberedValue(Integer.valueOf(obj48));
                        constructor-impl2.apply(Integer.valueOf(obj48), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer4 = composer10;
                    }
                } else {
                    propagateMinConstraints$iv = $i$f$Box;
                    composer = valueOf2;
                }
                Updater.set-impl(constructor-impl2, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                Composer composer7 = composer;
                i7 = 0;
                i3 = i34;
                ComposerKt.sourceInformationMarkerStart(composer7, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                i43 |= 6;
                composer2 = composer7;
                i5 = 0;
                boxScopeInstance = iNSTANCE2;
                modifier3 = materializeModifier;
                ComposerKt.sourceInformationMarkerStart(composer7, -1559720052, "C534@21483L9:NavigationDrawer.kt#uh7d8r");
                obj3.invoke(composer7, Integer.valueOf(i35 &= 14));
                ComposerKt.sourceInformationMarkerEnd(composer7);
                ComposerKt.sourceInformationMarkerEnd(composer7);
                composer.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(valueOf2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj = obj2;
            } else {
                maybeCachedBoxMeasurePolicy.skipToGroupEnd();
                $composer2 = maybeCachedBoxMeasurePolicy;
                obj = str;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new NavigationDrawerKt.PermanentNavigationDrawer.2(drawerContent, obj, obj3, $changed, i6);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    private static final void Scrim-Bx497Mc(boolean open, Function0<Unit> onClose, Function0<Float> fraction, long color, Composer $composer, int $changed) {
        Object closeDrawer;
        boolean traceInProgress;
        Object anon;
        Modifier companion2;
        int $dirty;
        int i2;
        int i4;
        int i12;
        int i10;
        int skipping;
        boolean traceInProgress2;
        int $i$f$getCloseDrawer8iCLdWM;
        Object anon2;
        int i11;
        int i5;
        int i3;
        int i6;
        Composer composer;
        int i7;
        int rememberedValue;
        int empty;
        int i8;
        Composer composer2;
        Object rememberedValue2;
        Object companion;
        int i;
        int companion4;
        int i9;
        Composer.Companion companion3;
        companion2 = open;
        final Object obj = onClose;
        final Object obj2 = fraction;
        final long l = color;
        final int i13 = obj27;
        traceInProgress = 2106487387;
        Composer restartGroup = $changed.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(Scrim)P(3,2,1,0:c#ui.graphics.Color)1136@46594L30,1151@47092L39,1151@47041L90:NavigationDrawer.kt#uh7d8r");
        if (i13 & 6 == 0) {
            i2 = restartGroup.changed(companion2) ? 4 : 2;
            $dirty |= i2;
        }
        i11 = 32;
        if (i13 & 48 == 0) {
            i4 = restartGroup.changedInstance(obj) ? i11 : 16;
            $dirty |= i4;
        }
        if (i13 & 384 == 0) {
            i12 = restartGroup.changedInstance(obj2) ? 256 : 128;
            $dirty |= i12;
        }
        if (i13 & 3072 == 0) {
            i10 = restartGroup.changed(l) ? 2048 : 1024;
            $dirty |= i10;
        }
        if ($dirty & 1171 == 1170) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty, -1, "androidx.compose.material3.Scrim (NavigationDrawer.kt:1135)");
                }
                androidx.compose.material3.internal.Strings.Companion companion5 = Strings.Companion;
                int i14 = 0;
                String string-2EP1pXo = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(R.string.close_drawer), restartGroup, 0);
                restartGroup.startReplaceGroup(-1784754787);
                ComposerKt.sourceInformation(restartGroup, "1139@46712L35,1140@46800L187");
                String str3 = "CC(remember):NavigationDrawer.kt#9igjgp";
                if (companion2) {
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1784753370, str3);
                    i3 = $dirty & 112 == i11 ? 1 : 0;
                    Composer composer3 = restartGroup;
                    companion4 = 0;
                    Object rememberedValue3 = composer3.rememberedValue();
                    i9 = 0;
                    if (i3 == 0) {
                        if (rememberedValue3 == Composer.Companion.getEmpty()) {
                            int i31 = 0;
                            anon2 = new NavigationDrawerKt.Scrim.dismissDrawer.1.1(obj, 0);
                            composer3.updateRememberedValue((Function2)anon2);
                        } else {
                            anon2 = rememberedValue3;
                            composer2 = composer3;
                        }
                    } else {
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1784750402, str3);
                    i6 = $dirty & 112 == 32 ? 1 : 0;
                    composer = restartGroup;
                    i7 = 0;
                    rememberedValue2 = composer.rememberedValue();
                    i = 0;
                    if (changed3 |= i6 == 0) {
                        if (rememberedValue2 == Composer.Companion.getEmpty()) {
                            empty = 0;
                            anon = new NavigationDrawerKt.Scrim.dismissDrawer.2.1(string-2EP1pXo, obj);
                            composer.updateRememberedValue((Function1)anon);
                        } else {
                            anon = rememberedValue2;
                        }
                    } else {
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    companion2 = SemanticsModifierKt.semantics(SuspendingPointerInputFilterKt.pointerInput((Modifier)Modifier.Companion, obj, (Function2)anon2), true, (Function1)anon);
                } else {
                    companion2 = Modifier.Companion;
                }
                restartGroup.endReplaceGroup();
                int i24 = 1;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1784741206, str3);
                i5 = $dirty & 7168 == 2048 ? i24 : 0;
                rememberedValue2 = $dirty & 896 == 256 ? i24 : 0;
                composer = restartGroup;
                i7 = 0;
                rememberedValue = composer.rememberedValue();
                i8 = 0;
                if (i5 |= rememberedValue2 == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        rememberedValue2 = 0;
                        companion = string-2EP1pXo;
                        closeDrawer = new NavigationDrawerKt.Scrim.1.1(l, obj5, obj2);
                        composer.updateRememberedValue((Function1)closeDrawer);
                    } else {
                        companion = string-2EP1pXo;
                        closeDrawer = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                CanvasKt.Canvas(SizeKt.fillMaxSize$default((Modifier)Modifier.Companion, 0, i24, 0).then(companion2), (Function1)closeDrawer, restartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new NavigationDrawerKt.Scrim.2(open, obj, obj2, l, obj5, i13);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final boolean access$DismissibleNavigationDrawer$lambda$16(MutableState $anchorsInitialized$delegate) {
        return NavigationDrawerKt.DismissibleNavigationDrawer$lambda$16($anchorsInitialized$delegate);
    }

    public static final void access$DismissibleNavigationDrawer$lambda$17(MutableState $anchorsInitialized$delegate, boolean value) {
        NavigationDrawerKt.DismissibleNavigationDrawer$lambda$17($anchorsInitialized$delegate, value);
    }

    public static final boolean access$ModalNavigationDrawer_FHprtrg$lambda$2(MutableState $anchorsInitialized$delegate) {
        return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$2($anchorsInitialized$delegate);
    }

    public static final void access$ModalNavigationDrawer_FHprtrg$lambda$3(MutableState $anchorsInitialized$delegate, boolean value) {
        NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$3($anchorsInitialized$delegate, value);
    }

    public static final float access$ModalNavigationDrawer_FHprtrg$lambda$5(MutableFloatState $minValue$delegate) {
        return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$5($minValue$delegate);
    }

    public static final void access$ModalNavigationDrawer_FHprtrg$lambda$6(MutableFloatState $minValue$delegate, float value) {
        NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$6($minValue$delegate, value);
    }

    public static final void access$Scrim-Bx497Mc(boolean open, Function0 onClose, Function0 fraction, long color, Composer $composer, int $changed) {
        NavigationDrawerKt.Scrim-Bx497Mc(open, onClose, fraction, color, $composer, $changed);
    }

    public static final float access$calculateFraction(float a, float b, float pos) {
        return NavigationDrawerKt.calculateFraction(a, b, pos);
    }

    public static final float access$calculatePredictiveBackScaleX(GraphicsLayerScope $receiver, androidx.compose.material3.DrawerPredictiveBackState drawerPredictiveBackState) {
        return NavigationDrawerKt.calculatePredictiveBackScaleX($receiver, drawerPredictiveBackState);
    }

    public static final float access$calculatePredictiveBackScaleY(GraphicsLayerScope $receiver, androidx.compose.material3.DrawerPredictiveBackState drawerPredictiveBackState) {
        return NavigationDrawerKt.calculatePredictiveBackScaleY($receiver, drawerPredictiveBackState);
    }

    public static final TweenSpec access$getAnimationSpec$p() {
        return NavigationDrawerKt.AnimationSpec;
    }

    public static final float access$getDrawerPositionalThreshold$p() {
        return NavigationDrawerKt.DrawerPositionalThreshold;
    }

    public static final float access$getDrawerVelocityThreshold$p() {
        return NavigationDrawerKt.DrawerVelocityThreshold;
    }

    public static final float access$getMinimumDrawerWidth$p() {
        return NavigationDrawerKt.MinimumDrawerWidth;
    }

    public static final Modifier access$predictiveBackDrawerChild(Modifier $receiver, androidx.compose.material3.DrawerPredictiveBackState drawerPredictiveBackState, boolean isRtl) {
        return NavigationDrawerKt.predictiveBackDrawerChild($receiver, drawerPredictiveBackState, isRtl);
    }

    private static final float calculateFraction(float a, float b, float pos) {
        return RangesKt.coerceIn(i /= i3, 0, 1065353216);
    }

    private static final float calculatePredictiveBackScaleX(GraphicsLayerScope $this$calculatePredictiveBackScaleX, androidx.compose.material3.DrawerPredictiveBackState drawerPredictiveBackState) {
        boolean naN;
        int i;
        int i2;
        float f;
        float width-impl = Size.getWidth-impl($this$calculatePredictiveBackScaleX.getSize-NH-jbRc());
        if (!Float.isNaN(width-impl)) {
            naN = Float.compare(width-impl, i3) == 0 ? i2 : 0;
            if (naN != 0) {
            } else {
                if (drawerPredictiveBackState.getSwipeEdgeMatchesDrawer()) {
                } else {
                    i2 = -1;
                }
                i += naN;
            }
        } else {
        }
        return i;
    }

    private static final float calculatePredictiveBackScaleY(GraphicsLayerScope $this$calculatePredictiveBackScaleY, androidx.compose.material3.DrawerPredictiveBackState drawerPredictiveBackState) {
        boolean naN;
        int i;
        float height-impl = Size.getHeight-impl($this$calculatePredictiveBackScaleY.getSize-NH-jbRc());
        if (!Float.isNaN(height-impl)) {
            naN = Float.compare(height-impl, i2) == 0 ? 1 : 0;
            if (naN != 0) {
            } else {
                i -= naN;
            }
        } else {
        }
        return i;
    }

    private static final Modifier predictiveBackDrawerChild(Modifier $this$predictiveBackDrawerChild, androidx.compose.material3.DrawerPredictiveBackState drawerPredictiveBackState, boolean isRtl) {
        NavigationDrawerKt.predictiveBackDrawerChild.1 anon = new NavigationDrawerKt.predictiveBackDrawerChild.1(drawerPredictiveBackState, isRtl);
        return GraphicsLayerModifierKt.graphicsLayer($this$predictiveBackDrawerChild, (Function1)anon);
    }

    private static final Modifier predictiveBackDrawerContainer(Modifier $this$predictiveBackDrawerContainer, androidx.compose.material3.DrawerPredictiveBackState drawerPredictiveBackState, boolean isRtl) {
        NavigationDrawerKt.predictiveBackDrawerContainer.1 anon = new NavigationDrawerKt.predictiveBackDrawerContainer.1(drawerPredictiveBackState, isRtl);
        return GraphicsLayerModifierKt.graphicsLayer($this$predictiveBackDrawerContainer, (Function1)anon);
    }

    public static final androidx.compose.material3.DrawerState rememberDrawerState(androidx.compose.material3.DrawerValue initialValue, Function1<? super androidx.compose.material3.DrawerValue, Boolean> confirmStateChange, Composer $composer, int $changed, int i5) {
        String str;
        int changed2;
        int i;
        int changed;
        Object empty;
        Object anon;
        androidx.compose.material3.NavigationDrawerKt.rememberDrawerState.1 obj9;
        int obj12;
        int i2 = 2098699222;
        ComposerKt.sourceInformationMarkerStart($composer, i2, "C(rememberDrawerState)P(1)286@11488L61,286@11424L125:NavigationDrawer.kt#uh7d8r");
        if (i5 &= 2 != 0) {
            obj9 = obj12;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i2, $changed, -1, "androidx.compose.material3.rememberDrawerState (NavigationDrawer.kt:285)");
        }
        obj12 = 0;
        ComposerKt.sourceInformationMarkerStart($composer, -666801427, "CC(remember):NavigationDrawer.kt#9igjgp");
        int i7 = 1;
        int i9 = 4;
        if (i4 ^= 6 > i9) {
            if (!$composer.changed(initialValue)) {
                i = $changed & 6 == i9 ? i7 : obj12;
            } else {
            }
        } else {
        }
        int i11 = 32;
        if (i10 ^= 48 > i11) {
            if (!$composer.changed(obj9)) {
                if ($changed & 48 == i11) {
                    obj12 = i7;
                }
            } else {
            }
        } else {
        }
        Composer composer = $composer;
        int i8 = 0;
        Object rememberedValue = composer.rememberedValue();
        int i12 = 0;
        if (obj12 |= i == 0) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                empty = 0;
                anon = new NavigationDrawerKt.rememberDrawerState.2.1(initialValue, obj9);
                composer.updateRememberedValue((Function0)anon);
            } else {
                anon = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        Composer composer2 = $composer;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return (DrawerState)RememberSaveableKt.rememberSaveable(new Object[obj12], DrawerState.Companion.Saver(obj9), 0, (Function0)anon, composer2, 0, 4);
    }
}
