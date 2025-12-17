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
        Object obj3;
        Object obj9;
        int traceInProgress;
        int windowInsets3;
        boolean traceInProgress2;
        int defaultsInvalid;
        int iNSTANCE;
        int dismissibleDrawerElevation-D9Ej5fM;
        int $dirty2;
        Object $dirty;
        int i2;
        int str;
        Object obj4;
        Object obj5;
        long l2;
        int i5;
        int i6;
        Object obj6;
        long l4;
        int i;
        long standardContainerColor;
        float f;
        int changed;
        long contentColorFor-ek8zF_U;
        WindowInsets windowInsets2;
        int i3;
        int changed2;
        int i8;
        float f3;
        int i4;
        int i7;
        int changed3;
        int i9;
        androidx.compose.material3.NavigationDrawerKt.DismissibleDrawerSheet.2 anon;
        Object obj7;
        Object obj8;
        Object obj2;
        long l3;
        long l;
        float f2;
        Object obj;
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
                i2 = restartGroup.changed(obj10) ? 4 : 2;
                $dirty2 |= i2;
            }
        }
        int i17 = i30 & 2;
        if (i17 != 0) {
            $dirty2 |= 48;
            obj5 = modifier;
        } else {
            if (i29 & 48 == 0) {
                i5 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i5;
            } else {
                obj5 = modifier;
            }
        }
        i6 = i30 & 4;
        if (i6 != 0) {
            $dirty2 |= 384;
            obj6 = drawerShape;
        } else {
            if (i29 & 384 == 0) {
                i = restartGroup.changed(drawerShape) ? 256 : 128;
                $dirty2 |= i;
            } else {
                obj6 = drawerShape;
            }
        }
        if (i29 & 3072 == 0) {
            if (i30 & 8 == 0) {
                changed = restartGroup.changed(drawerContainerColor) ? 2048 : 1024;
            } else {
                standardContainerColor = drawerContainerColor;
            }
            $dirty2 |= changed;
        } else {
            standardContainerColor = drawerContainerColor;
        }
        if (i29 & 24576 == 0) {
            if (i30 & 16 == 0) {
                changed2 = restartGroup.changed(drawerTonalElevation) ? 16384 : 8192;
            } else {
                contentColorFor-ek8zF_U = drawerTonalElevation;
            }
            $dirty2 |= changed2;
        } else {
            contentColorFor-ek8zF_U = drawerTonalElevation;
        }
        int i31 = i30 & 32;
        int i32 = 196608;
        if (i31 != 0) {
            $dirty2 |= i32;
            f3 = content;
        } else {
            if (i32 &= i29 == 0) {
                i4 = restartGroup.changed(content) ? 131072 : 65536;
                $dirty2 |= i4;
            } else {
                f3 = content;
            }
        }
        if (i29 & i34 == 0) {
            if (i30 & 64 == 0) {
                changed3 = restartGroup.changed($composer) ? 1048576 : 524288;
            } else {
                obj3 = $composer;
            }
            $dirty2 |= changed3;
        } else {
            obj3 = $composer;
        }
        i9 = 12582912;
        if (i30 & 128 != 0) {
            $dirty2 |= i9;
            obj9 = $changed;
        } else {
            if (i29 & i9 == 0) {
                i9 = restartGroup.changedInstance($changed) ? 8388608 : 4194304;
                $dirty2 |= i9;
            } else {
                obj9 = $changed;
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
                        if (i6 != 0) {
                            obj6 = defaultsInvalid;
                        }
                        i6 = 6;
                        if (i30 & 8 != 0) {
                            standardContainerColor = DrawerDefaults.INSTANCE.getStandardContainerColor(restartGroup, i6);
                            $dirty2 &= -7169;
                        }
                        if (i30 & 16 != 0) {
                            contentColorFor-ek8zF_U = ColorSchemeKt.contentColorFor-ek8zF_U(standardContainerColor, obj8, restartGroup);
                            $dirty2 &= i35;
                        }
                        if (i31 != 0) {
                            f3 = dismissibleDrawerElevation-D9Ej5fM;
                        }
                        if (i30 & 64 != 0) {
                            $dirty2 &= str;
                            obj7 = windowInsets3;
                            obj8 = obj5;
                            obj2 = obj6;
                            l3 = standardContainerColor;
                            l = contentColorFor-ek8zF_U;
                            f2 = f3;
                        } else {
                            obj7 = $composer;
                            obj8 = obj5;
                            obj2 = obj6;
                            l3 = standardContainerColor;
                            l = contentColorFor-ek8zF_U;
                            f2 = f3;
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
                            obj7 = $composer;
                            $dirty2 = windowInsets3;
                            obj8 = obj5;
                            obj2 = obj6;
                            l3 = standardContainerColor;
                            l = contentColorFor-ek8zF_U;
                            f2 = f3;
                        } else {
                            obj7 = $composer;
                            obj8 = obj5;
                            obj2 = obj6;
                            l3 = standardContainerColor;
                            l = contentColorFor-ek8zF_U;
                            f2 = f3;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1473549901, $dirty2, -1, "androidx.compose.material3.DismissibleDrawerSheet (NavigationDrawer.kt:699)");
                }
                anon = new NavigationDrawerKt.DismissibleDrawerSheet.2(obj7, obj8, obj2, l3, obj22, l, obj24, f2, $changed);
                NavigationDrawer_androidKt.DrawerPredictiveBackHandler(obj10, (Function3)ComposableLambdaKt.rememberComposableLambda(-807955710, true, anon, restartGroup, 54), restartGroup, i20 |= 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i8 = $dirty2;
                windowInsets2 = obj7;
                $dirty = obj8;
                obj4 = obj2;
                l2 = l3;
                l4 = l;
                f = f2;
            } else {
                restartGroup.skipToGroupEnd();
                i8 = $dirty2;
                $dirty = obj5;
                obj4 = obj6;
                l2 = standardContainerColor;
                l4 = contentColorFor-ek8zF_U;
                f = f3;
                windowInsets2 = $composer;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new NavigationDrawerKt.DismissibleDrawerSheet.3(obj10, $dirty, obj4, l2, i6, l4, standardContainerColor, f, windowInsets2, $changed, i29, i30);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void DismissibleDrawerSheet-afqeVBk(Modifier modifier, Shape drawerShape, long drawerContainerColor, long drawerContentColor, float drawerTonalElevation, WindowInsets windowInsets, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i10) {
        boolean traceInProgress2;
        int windowInsets2;
        int defaultsInvalid;
        int iNSTANCE;
        int dismissibleDrawerElevation-D9Ej5fM;
        Object $composer2;
        int $dirty;
        Object $dirty2;
        long l3;
        Object obj5;
        boolean traceInProgress;
        int i9;
        long l;
        int str;
        Object obj2;
        int i2;
        long standardContainerColor;
        float f;
        Object obj6;
        int changed;
        int i6;
        int changed3;
        int i4;
        long contentColorFor-ek8zF_U;
        int windowInsets3;
        Object obj3;
        float drawerTonalElevation2;
        int i8;
        Object obj4;
        int changed2;
        Object obj;
        int i7;
        int i;
        long l4;
        float f2;
        Composer composer;
        Composer composer2;
        int i3;
        int i5;
        long l2;
        final int i48 = obj36;
        Composer restartGroup = i10.startRestartGroup(-588600583);
        ComposerKt.sourceInformation(restartGroup, "C(DismissibleDrawerSheet)P(5,3,1:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.unit.Dp,6)650@26887L22,651@26943L37,653@27104L12,656@27174L225:NavigationDrawer.kt#uh7d8r");
        $dirty = obj36;
        int i26 = obj37 & 1;
        if (i26 != 0) {
            $dirty |= 6;
            obj5 = modifier;
        } else {
            if (i48 & 6 == 0) {
                i9 = restartGroup.changed(modifier) ? 4 : 2;
                $dirty |= i9;
            } else {
                obj5 = modifier;
            }
        }
        str = obj37 & 2;
        if (str != null) {
            $dirty |= 48;
            obj2 = drawerShape;
        } else {
            if (i48 & 48 == 0) {
                i2 = restartGroup.changed(drawerShape) ? 32 : 16;
                $dirty |= i2;
            } else {
                obj2 = drawerShape;
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
                i8 = restartGroup.changed(content) ? 16384 : 8192;
                $dirty |= i8;
            } else {
                drawerTonalElevation2 = content;
            }
        }
        if (i50 &= i48 == 0) {
            if (obj37 & 32 == 0) {
                changed2 = restartGroup.changed($composer) ? 131072 : 65536;
            } else {
                obj4 = $composer;
            }
            $dirty |= changed2;
        } else {
            obj4 = $composer;
        }
        i7 = 1572864;
        if (obj37 & 64 != 0) {
            $dirty |= i7;
            obj = $changed;
        } else {
            if (i48 & i7 == 0) {
                i7 = restartGroup.changedInstance($changed) ? 1048576 : 524288;
                $dirty |= i7;
            } else {
                obj = $changed;
            }
        }
        if ($dirty & i == 599186) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                i = -458753;
                int i28 = 6;
                if (i48 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i26 != 0) {
                            obj5 = defaultsInvalid;
                        }
                        if (str != null) {
                            obj2 = defaultsInvalid;
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
                            $dirty &= i;
                            obj4 = obj2;
                            obj = standardContainerColor;
                            l4 = contentColorFor-ek8zF_U;
                            f2 = drawerTonalElevation2;
                            obj3 = windowInsets4;
                            drawerTonalElevation2 = obj5;
                            windowInsets2 = -588600583;
                        } else {
                            obj = standardContainerColor;
                            l4 = contentColorFor-ek8zF_U;
                            f2 = drawerTonalElevation2;
                            obj3 = obj4;
                            windowInsets2 = -588600583;
                            drawerTonalElevation2 = obj5;
                            obj4 = obj2;
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
                            obj = standardContainerColor;
                            l4 = contentColorFor-ek8zF_U;
                            f2 = drawerTonalElevation2;
                            obj3 = obj4;
                            windowInsets2 = -588600583;
                            drawerTonalElevation2 = obj5;
                            obj4 = obj2;
                        } else {
                            obj = standardContainerColor;
                            l4 = contentColorFor-ek8zF_U;
                            f2 = drawerTonalElevation2;
                            obj3 = obj4;
                            windowInsets2 = -588600583;
                            drawerTonalElevation2 = obj5;
                            obj4 = obj2;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(windowInsets2, $dirty, -1, "androidx.compose.material3.DismissibleDrawerSheet (NavigationDrawer.kt:655)");
                }
                NavigationDrawerKt.DrawerSheet-7zSek6w(0, obj3, drawerTonalElevation2, obj4, obj, i, l4, obj18, f2, $changed, restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj6 = obj3;
                $composer2 = drawerTonalElevation2;
                l3 = obj;
                l = l4;
                f = f2;
                windowInsets3 = $dirty;
                $dirty2 = obj4;
            } else {
                restartGroup.skipToGroupEnd();
                windowInsets3 = $dirty;
                $dirty2 = obj2;
                l = l2;
                composer2 = restartGroup;
                $composer2 = obj5;
                l3 = standardContainerColor;
                f = drawerTonalElevation2;
                obj6 = obj4;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new NavigationDrawerKt.DismissibleDrawerSheet.1($composer2, $dirty2, l3, obj5, l, obj2, f, obj6, $changed, i48, obj37);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void DismissibleNavigationDrawer(Function2<? super Composer, ? super Integer, Unit> drawerContent, Modifier modifier, androidx.compose.material3.DrawerState drawerState, boolean gesturesEnabled, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i8) {
        boolean traceInProgress2;
        Integer currentCompositionLocalMap3;
        Function0 factory$iv$iv$iv;
        Object obj4;
        Function0 factory$iv$iv$iv3;
        int $dirty2;
        Object $dirty;
        Object it$iv2;
        Integer maybeCachedBoxMeasurePolicy;
        boolean valueOf3;
        int i25;
        Object obj6;
        Object modifier2;
        boolean traceInProgress;
        int changed;
        int i20;
        int invalid$iv;
        Composer composer4;
        Composer composer3;
        Object valueOf2;
        Object currentCompositionLocalMap2;
        boolean z2;
        Object mutableStateOf$default;
        Object compositionCoroutineScope;
        Object iNSTANCE2;
        int i37;
        Object compositionScopedCoroutineScopeCanceller;
        Object rememberDrawerState;
        int i22;
        Function0 factory$iv$iv$iv2;
        int i36;
        Object it$iv;
        Composer composer9;
        int changed4;
        boolean changed3;
        int i17;
        Object obj;
        int valueOf;
        int empty;
        Integer currentCompositionLocalMap;
        int changed2;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap4;
        int i38;
        boolean maybeCachedBoxMeasurePolicy3;
        Composer composer2;
        int i13;
        Function0 factory$iv$iv;
        int i40;
        Object maybeCachedBoxMeasurePolicy2;
        int i7;
        int i3;
        int skipping;
        int defaultsInvalid;
        Modifier materializeModifier;
        Object anon2;
        int materialized$iv$iv;
        int i10;
        Object empty2;
        Object obj2;
        int i39;
        Composer.Companion companion;
        int i29;
        Object iNSTANCE3;
        boolean z;
        int i18;
        int i42;
        int i12;
        int i19;
        int i15;
        int i33;
        int i4;
        int currentCompositeKeyHash2;
        Alignment alignment;
        int i14;
        Modifier modifier4;
        Function0 function03;
        int i11;
        int i41;
        Modifier modifier3;
        int i2;
        BoxScopeInstance iNSTANCE;
        int i16;
        int i26;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy;
        int i23;
        int i24;
        Composer composer8;
        int i35;
        Object obj5;
        int currentCompositeKeyHash;
        int companion2;
        Object obj7;
        Modifier materialized$iv$iv2;
        int i;
        androidx.compose.ui.Modifier.Companion companion3;
        Composer composer6;
        int i5;
        int i27;
        int i6;
        Function0 function0;
        int i21;
        Function0 function04;
        Object obj3;
        int companion5;
        androidx.compose.runtime.CompositionLocalMap localMap$iv;
        androidx.compose.material3.NavigationDrawerKt.DismissibleNavigationDrawer.2.2.1 anon;
        Composer composer;
        int invalid$iv2;
        int i31;
        int $i$f$Box;
        androidx.compose.ui.Modifier.Companion companion4;
        Function0 function02;
        int i34;
        int i28;
        Composer composer5;
        kotlinx.coroutines.CoroutineScope coroutineScope;
        int i9;
        int i32;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy$iv;
        androidx.compose.runtime.CompositionLocalMap map;
        Composer composer7;
        int i30;
        int obj76;
        String obj77;
        Object obj78;
        Composer obj80;
        Object obj8 = drawerContent;
        iNSTANCE2 = content;
        i37 = $changed;
        traceInProgress2 = 398812198;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(DismissibleNavigationDrawer)P(1,4,2,3)434@17575L39,438@17723L34,439@17789L7,440@17812L33,440@17801L44,442@17863L24,443@17913L33,445@17985L7,446@18020L2358:NavigationDrawer.kt#uh7d8r");
        $dirty2 = $changed;
        int i69 = 2;
        if (i8 & 1 != 0) {
            $dirty2 |= 6;
        } else {
            if (i37 & 6 == 0) {
                i25 = restartGroup.changedInstance(obj8) ? 4 : i69;
                $dirty2 |= i25;
            }
        }
        int i62 = i8 & 2;
        if (i62 != 0) {
            $dirty2 |= 48;
            rememberDrawerState = modifier;
        } else {
            if (i37 & 48 == 0) {
                i17 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i17;
            } else {
                rememberDrawerState = modifier;
            }
        }
        if (i37 & 384 == 0) {
            if (i8 & 4 == 0) {
                changed2 = restartGroup.changed(drawerState) ? 256 : 128;
            } else {
                obj = drawerState;
            }
            $dirty2 |= changed2;
        } else {
            obj = drawerState;
        }
        currentCompositionLocalMap4 = i8 & 8;
        if (currentCompositionLocalMap4 != 0) {
            $dirty2 |= 3072;
            maybeCachedBoxMeasurePolicy3 = gesturesEnabled;
        } else {
            if (i37 & 3072 == 0) {
                i7 = restartGroup.changed(gesturesEnabled) ? 2048 : 1024;
                $dirty2 |= i7;
            } else {
                maybeCachedBoxMeasurePolicy3 = gesturesEnabled;
            }
        }
        if (i8 & 16 != 0) {
            $dirty2 |= 24576;
        } else {
            if (i37 & 24576 == 0) {
                i3 = restartGroup.changedInstance(iNSTANCE2) ? 16384 : 8192;
                $dirty2 |= i3;
            }
        }
        if ($dirty2 & 9363 == 9362) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i121 = 0;
                int i124 = 6;
                if (i37 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i62 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = rememberDrawerState;
                        }
                        if (i8 & 4 != 0) {
                            $dirty2 &= -897;
                            obj = rememberDrawerState;
                        }
                        if (currentCompositionLocalMap4 != 0) {
                            obj2 = modifier2;
                            z = rememberDrawerState;
                        } else {
                            obj2 = modifier2;
                            z = maybeCachedBoxMeasurePolicy3;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i8 & 4 != 0) {
                            $dirty2 &= -897;
                        }
                        obj2 = rememberDrawerState;
                        z = maybeCachedBoxMeasurePolicy3;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty2, -1, "androidx.compose.material3.DismissibleNavigationDrawer (NavigationDrawer.kt:437)");
                }
                String str2 = "CC(remember):NavigationDrawer.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, 1034571360, str2);
                int i44 = 0;
                Composer composer14 = restartGroup;
                int i97 = 0;
                Object rememberedValue5 = composer14.rememberedValue();
                int i119 = 0;
                obj80 = i124;
                if (rememberedValue5 == Composer.Companion.getEmpty()) {
                    empty2 = 0;
                    composer14.updateRememberedValue(SnapshotStateKt.mutableStateOf$default(false, i121, i69, i121));
                } else {
                    obj76 = 0;
                    mutableStateOf$default = rememberedValue5;
                }
                Object invalid$iv3 = mutableStateOf$default;
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                int i77 = 0;
                empty = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                Object this_$iv = consume;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 1034574207, str2);
                if (i79 ^= 384 > 256) {
                    if (!restartGroup.changed(obj)) {
                        i22 = $dirty2 & 384 == 256 ? 1 : obj76;
                    } else {
                    }
                } else {
                }
                Composer composer17 = restartGroup;
                int i103 = 0;
                Object rememberedValue6 = composer17.rememberedValue();
                int i125 = 0;
                if (i22 |= changed7 == 0) {
                    if (rememberedValue6 == Composer.Companion.getEmpty()) {
                        empty = 0;
                        anon2 = new NavigationDrawerKt.DismissibleNavigationDrawer.1.1(obj, this_$iv);
                        composer17.updateRememberedValue((Function0)anon2);
                    } else {
                        anon2 = rememberedValue6;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                int i81 = obj76;
                EffectsKt.SideEffect((Function0)anon2, restartGroup, i81);
                int i91 = i81;
                int i82 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(restartGroup, -954363344, "CC(remember):Effects.kt#9igjgp");
                int i105 = 0;
                Composer composer21 = restartGroup;
                int i122 = 0;
                Object rememberedValue7 = composer21.rememberedValue();
                int i130 = 0;
                obj78 = this_$iv;
                if (rememberedValue7 == Composer.Companion.getEmpty()) {
                    int i132 = 0;
                    i18 = i72;
                    compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope((CoroutineContext)EmptyCoroutineContext.INSTANCE, restartGroup));
                    composer21.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                } else {
                    compositionScopedCoroutineScopeCanceller = rememberedValue7;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                kotlinx.coroutines.CoroutineScope coroutineScope2 = (CompositionScopedCoroutineScopeCanceller)compositionScopedCoroutineScopeCanceller.getCoroutineScope();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                androidx.compose.material3.internal.Strings.Companion companion11 = Strings.Companion;
                int i83 = 0;
                String string-2EP1pXo = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(R.string.navigation_menu), restartGroup, 0);
                int i92 = 0;
                int i100 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                i18 = restartGroup.consume((CompositionLocal)CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl ? 1 : 0;
                Modifier anchoredDraggable$default = AnchoredDraggableKt.anchoredDraggable$default(obj2, obj.getAnchoredDraggableState$material3_release(), Orientation.Horizontal, z, i18, 0, 16, 0);
                int i101 = i93;
                String str7 = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo";
                ComposerKt.sourceInformationMarkerStart(restartGroup, 733328855, str7);
                Alignment topStart3 = Alignment.Companion.getTopStart();
                int i126 = 0;
                maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(topStart3, i126);
                i42 = 0;
                i12 = i94;
                String $changed$iv5 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, $changed$iv5);
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, 0);
                currentCompositionLocalMap = restartGroup.getCurrentCompositionLocalMap();
                alignment = topStart3;
                materialized$iv$iv = ComposedModifierKt.materializeModifier(restartGroup, anchoredDraggable$default);
                modifier4 = anchoredDraggable$default;
                Function0 function06 = constructor2;
                i14 = 0;
                i41 = i126;
                String propagateMinConstraints$iv2 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, propagateMinConstraints$iv2);
                if (!applier3 instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                restartGroup.startReusableNode();
                if (restartGroup.getInserting()) {
                    restartGroup.createNode(function06);
                } else {
                    factory$iv$iv$iv2 = function06;
                    restartGroup.useNode();
                }
                function03 = factory$iv$iv$iv2;
                Composer constructor-impl2 = Updater.constructor-impl(restartGroup);
                int i142 = 0;
                Updater.set-impl(constructor-impl2, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i143 = 0;
                Composer composer22 = constructor-impl2;
                int i146 = 0;
                if (!composer22.getInserting()) {
                    localMap$iv$iv = currentCompositionLocalMap;
                    measurePolicy = maybeCachedBoxMeasurePolicy2;
                    if (!Intrinsics.areEqual(composer22.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        composer22.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        constructor-impl2.apply(Integer.valueOf(currentCompositeKeyHash2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer2 = composer22;
                    }
                } else {
                    localMap$iv$iv = currentCompositionLocalMap;
                    measurePolicy = maybeCachedBoxMeasurePolicy2;
                }
                Updater.set-impl(constructor-impl2, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                Composer composer15 = restartGroup;
                i2 = i74;
                String $changed$iv4 = "C73@3429L9:Box.kt#2w3rfo";
                ComposerKt.sourceInformationMarkerStart(composer15, -2146769399, $changed$iv4);
                iNSTANCE = BoxScopeInstance.INSTANCE;
                i145 |= 6;
                i23 = 0;
                i35 = i96;
                Composer composer16 = composer23;
                ComposerKt.sourceInformationMarkerStart(composer16, -1218087217, "C477@19117L1255,454@18269L2103:NavigationDrawer.kt#uh7d8r");
                ComposerKt.sourceInformationMarkerStart(composer16, 99280484, str2);
                if (i88 ^= 384 > 256) {
                    if (!restartGroup.changed(obj)) {
                        i36 = $dirty2 & 384 == 256 ? 1 : 0;
                    } else {
                    }
                } else {
                }
                Composer composer19 = composer16;
                int i147 = 0;
                it$iv = composer19.rememberedValue();
                int i149 = 0;
                if (i36 == 0) {
                    materialized$iv$iv2 = materialized$iv$iv;
                    if (it$iv == Composer.Companion.getEmpty()) {
                        materialized$iv$iv = 0;
                        obj7 = it$iv;
                        it$iv = new NavigationDrawerKt.DismissibleNavigationDrawer.2.2.1(obj, (MutableState)invalid$iv3);
                        composer19.updateRememberedValue((MeasurePolicy)it$iv);
                    } else {
                        obj7 = it$iv;
                    }
                } else {
                    materialized$iv$iv2 = materialized$iv$iv;
                }
                ComposerKt.sourceInformationMarkerEnd(composer16);
                i26 = 0;
                ComposerKt.sourceInformationMarkerStart(composer16, -1323940314, $changed$iv5);
                androidx.compose.ui.Modifier.Companion companion18 = Modifier.Companion;
                obj5 = invalid$iv3;
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer16, 0);
                currentCompositionLocalMap3 = composer16.getCurrentCompositionLocalMap();
                companion3 = companion18;
                Function0 function07 = constructor3;
                i = 0;
                ComposerKt.sourceInformationMarkerStart(composer16, -692256719, propagateMinConstraints$iv2);
                if (!applier4 instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                composer16.startReusableNode();
                if (composer16.getInserting()) {
                    composer16.createNode(function07);
                } else {
                    factory$iv$iv = function07;
                    composer16.useNode();
                }
                composer6 = composer16;
                Composer constructor-impl3 = Updater.constructor-impl(composer6);
                int i150 = 0;
                function0 = factory$iv$iv;
                Updater.set-impl(constructor-impl3, (MeasurePolicy)it$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl3, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i151 = 0;
                Composer composer24 = constructor-impl3;
                companion5 = 0;
                if (!composer24.getInserting()) {
                    localMap$iv = currentCompositionLocalMap3;
                    anon = it$iv;
                    if (!Intrinsics.areEqual(composer24.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer24.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl3.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer9 = composer24;
                    }
                } else {
                    localMap$iv = currentCompositionLocalMap3;
                    anon = it$iv;
                }
                Updater.set-impl(constructor-impl3, ComposedModifierKt.materializeModifier(composer16, (Modifier)companion18), ComposeUiNode.Companion.getSetModifier());
                rememberDrawerState = composer6;
                valueOf = 0;
                i27 = i46;
                ComposerKt.sourceInformationMarkerStart(rememberDrawerState, 285475168, "C457@18361L623,456@18317L741,475@19075L17:NavigationDrawer.kt#uh7d8r");
                ComposerKt.sourceInformationMarkerStart(rememberDrawerState, -1376263189, str2);
                if (i116 ^= 384 > 256) {
                    if (!restartGroup.changed(obj)) {
                        i20 = $dirty2 & 384 == 256 ? 1 : 0;
                    } else {
                    }
                } else {
                }
                i63 |= changedInstance2;
                Composer composer20 = rememberDrawerState;
                int i136 = 0;
                i6 = $dirty2;
                it$iv2 = composer20.rememberedValue();
                int i152 = 0;
                if (invalid$iv == 0) {
                    invalid$iv2 = invalid$iv;
                    if (it$iv2 == Composer.Companion.getEmpty()) {
                        invalid$iv = 0;
                        obj3 = it$iv2;
                        it$iv2 = new NavigationDrawerKt.DismissibleNavigationDrawer.2.1.1.1(string-2EP1pXo, obj, coroutineScope2);
                        composer20.updateRememberedValue((Function1)it$iv2);
                    } else {
                        obj3 = it$iv2;
                    }
                } else {
                    invalid$iv2 = invalid$iv;
                }
                ComposerKt.sourceInformationMarkerEnd(rememberDrawerState);
                obj77 = string-2EP1pXo;
                int i117 = 0;
                Modifier semantics$default = SemanticsModifierKt.semantics$default((Modifier)Modifier.Companion, i117, (Function1)it$iv2, 1, 0);
                ComposerKt.sourceInformationMarkerStart(rememberDrawerState, 733328855, str7);
                Alignment topStart = Alignment.Companion.getTopStart();
                int i137 = i61;
                maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(topStart, false);
                int i153 = 0;
                int i154 = i65;
                ComposerKt.sourceInformationMarkerStart(rememberDrawerState, -1323940314, $changed$iv5);
                int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(rememberDrawerState, 0);
                currentCompositionLocalMap2 = rememberDrawerState.getCurrentCompositionLocalMap();
                Alignment alignment2 = topStart;
                Modifier modifier5 = semantics$default;
                Function0 function08 = constructor4;
                int i155 = 0;
                ComposerKt.sourceInformationMarkerStart(rememberDrawerState, -692256719, propagateMinConstraints$iv2);
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                rememberDrawerState.startReusableNode();
                if (rememberDrawerState.getInserting()) {
                    rememberDrawerState.createNode(function08);
                } else {
                    factory$iv$iv$iv = function08;
                    rememberDrawerState.useNode();
                }
                function02 = factory$iv$iv$iv;
                Composer constructor-impl = Updater.constructor-impl(rememberDrawerState);
                int i156 = 0;
                coroutineScope = coroutineScope2;
                Updater.set-impl(constructor-impl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i159 = 0;
                Composer composer26 = constructor-impl;
                int i160 = 0;
                if (!composer26.getInserting()) {
                    measurePolicy$iv = maybeCachedBoxMeasurePolicy;
                    map = currentCompositionLocalMap2;
                    if (!Intrinsics.areEqual(composer26.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                        composer26.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer4 = composer26;
                    }
                } else {
                    measurePolicy$iv = maybeCachedBoxMeasurePolicy;
                    map = currentCompositionLocalMap2;
                }
                Updater.set-impl(constructor-impl, ComposedModifierKt.materializeModifier(rememberDrawerState, semantics$default), ComposeUiNode.Companion.getSetModifier());
                Composer composer11 = rememberDrawerState;
                ComposerKt.sourceInformationMarkerStart(composer11, -2146769399, $changed$iv4);
                BoxScopeInstance iNSTANCE4 = BoxScopeInstance.INSTANCE;
                i158 |= 6;
                i9 = 0;
                i32 = i50;
                i30 = i67;
                Composer composer13 = composer5;
                ComposerKt.sourceInformationMarkerStart(composer13, 590398649, "C473@19025L15:NavigationDrawer.kt#uh7d8r");
                obj8.invoke(composer13, Integer.valueOf(i6 & 14));
                ComposerKt.sourceInformationMarkerEnd(composer13);
                ComposerKt.sourceInformationMarkerEnd(composer11);
                rememberDrawerState.endNode();
                ComposerKt.sourceInformationMarkerEnd(rememberDrawerState);
                ComposerKt.sourceInformationMarkerEnd(rememberDrawerState);
                ComposerKt.sourceInformationMarkerEnd(rememberDrawerState);
                int i52 = propagateMinConstraints$iv;
                valueOf3 = 0;
                ComposerKt.sourceInformationMarkerStart(rememberDrawerState, 733328855, str7);
                valueOf2 = Modifier.Companion;
                i39 = 0;
                ComposerKt.sourceInformationMarkerStart(rememberDrawerState, -1323940314, $changed$iv5);
                obj76 = currentCompositeKeyHash3;
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(rememberDrawerState, (Modifier)valueOf2);
                Function0 function05 = constructor;
                i33 = 0;
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
                int i140 = 0;
                function04 = factory$iv$iv$iv3;
                Updater.set-impl(constructor-impl4, BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false), ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl4, rememberDrawerState.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i141 = 0;
                Composer composer25 = constructor-impl4;
                i31 = 0;
                if (!composer25.getInserting()) {
                    $i$f$Box = valueOf3;
                    companion4 = valueOf2;
                    if (!Intrinsics.areEqual(composer25.rememberedValue(), Integer.valueOf(obj76))) {
                        composer25.updateRememberedValue(Integer.valueOf(obj76));
                        constructor-impl4.apply(Integer.valueOf(obj76), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer3 = composer25;
                    }
                } else {
                    $i$f$Box = valueOf3;
                    companion4 = valueOf2;
                }
                Updater.set-impl(constructor-impl4, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                Composer composer12 = rememberDrawerState;
                int i68 = 0;
                ComposerKt.sourceInformationMarkerStart(composer12, -2146769399, $changed$iv4);
                iNSTANCE2 = BoxScopeInstance.INSTANCE;
                i129 |= 6;
                obj80 = composer12;
                i4 = 0;
                modifier3 = materializeModifier2;
                i24 = i60;
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
                ComposerKt.sourceInformationMarkerEnd(composer15);
                restartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $dirty = obj2;
                z2 = z;
                obj6 = obj;
            } else {
                restartGroup.skipToGroupEnd();
                i6 = $dirty2;
                obj4 = iNSTANCE2;
                $dirty = rememberDrawerState;
                z2 = maybeCachedBoxMeasurePolicy3;
                obj6 = obj;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new NavigationDrawerKt.DismissibleNavigationDrawer.3(drawerContent, $dirty, obj6, z2, obj4, $changed, i8);
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
        int i9;
        int traceInProgress2;
        int defaultsInvalid;
        int iNSTANCE;
        int i4;
        int i;
        boolean traceInProgress;
        int i17;
        int i5;
        Object $composer2;
        int $dirty;
        Object $dirty2;
        int i13;
        int i19;
        int str;
        long l3;
        Object obj;
        int i14;
        Modifier predictiveBackDrawerContainer;
        long l2;
        Object obj3;
        int i6;
        int i7;
        int changed;
        int i8;
        float modifier2;
        long standardContainerColor;
        int i12;
        Object obj2;
        int changed2;
        long i16;
        int i2;
        long drawerContentColor2;
        float f;
        int i18;
        int i10;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        Composer composer;
        int i3;
        int i15;
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
                i13 = restartGroup.changed(obj4) ? 4 : 2;
                $dirty |= i13;
            }
        }
        if (i49 & 2 != 0) {
            $dirty |= 48;
        } else {
            if (i48 & 48 == 0) {
                i19 = restartGroup.changed(obj5) ? 32 : 16;
                $dirty |= i19;
            }
        }
        str = i49 & 4;
        if (str != null) {
            $dirty |= 384;
            obj = modifier;
        } else {
            if (i48 & 384 == 0) {
                i14 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty |= i14;
            } else {
                obj = modifier;
            }
        }
        int i43 = i49 & 8;
        if (i43 != 0) {
            $dirty |= 3072;
            obj3 = drawerShape;
        } else {
            if (i48 & 3072 == 0) {
                i6 = restartGroup.changed(drawerShape) ? 2048 : 1024;
                $dirty |= i6;
            } else {
                obj3 = drawerShape;
            }
        }
        if (i48 & 24576 == 0) {
            if (i49 & 16 == 0) {
                i7 = restartGroup.changed(drawerContainerColor) ? 16384 : 8192;
            } else {
                standardContainerColor = drawerContainerColor;
            }
            $dirty |= i7;
        } else {
            standardContainerColor = drawerContainerColor;
        }
        if (i47 &= i48 == 0) {
            if (i49 & 32 == 0) {
                changed2 = restartGroup.changed(drawerTonalElevation) ? 131072 : 65536;
            } else {
                l = drawerTonalElevation;
            }
            $dirty |= changed2;
        } else {
            l = drawerTonalElevation;
        }
        i16 = i49 & 64;
        i2 = 1572864;
        if (i16 != 0) {
            $dirty |= i2;
            modifier2 = $composer;
        } else {
            if (i48 & i2 == 0) {
                i2 = restartGroup.changed($composer) ? 1048576 : 524288;
                $dirty |= i2;
            } else {
                modifier2 = $composer;
            }
        }
        int i32 = 12582912;
        if (i49 & 128 != 0) {
            $dirty |= i32;
        } else {
            if (i48 & i32 == 0) {
                i9 = restartGroup.changedInstance(obj8) ? 8388608 : 4194304;
                $dirty |= i9;
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
                            obj = defaultsInvalid;
                        }
                        if (i43 != 0) {
                            obj3 = defaultsInvalid;
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
                        if (i16 != 0) {
                            f = permanentDrawerElevation-D9Ej5fM;
                            i = i51;
                            i16 = standardContainerColor;
                            obj2 = obj3;
                        } else {
                            f = modifier2;
                            i = i51;
                            i16 = standardContainerColor;
                            obj2 = obj3;
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
                            i = i51;
                            i16 = standardContainerColor;
                            obj2 = obj3;
                        } else {
                            drawerContentColor2 = drawerTonalElevation;
                            f = modifier2;
                            i = i51;
                            i16 = standardContainerColor;
                            obj2 = obj3;
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
                i17 = restartGroup.consume((CompositionLocal)CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl ? i40 : 0;
                if (drawerPredictiveBackState != null) {
                    predictiveBackDrawerContainer = NavigationDrawerKt.predictiveBackDrawerContainer((Modifier)Modifier.Companion, drawerPredictiveBackState, i17);
                } else {
                    obj3 = drawerPredictiveBackState;
                    predictiveBackDrawerContainer = Modifier.Companion;
                }
                i10 = 0;
                obj28 = obj;
                NavigationDrawerKt.DrawerSheet.1 anon = new NavigationDrawerKt.DrawerSheet.1(obj3, i17, obj5, obj8);
                obj29 = i17;
                SurfaceKt.Surface-T9BRK9s(SizeKt.fillMaxHeight$default(SizeKt.sizeIn-qDBjuR0$default(obj28, NavigationDrawerKt.MinimumDrawerWidth, 0, DrawerDefaults.INSTANCE.getMaximumDrawerWidth-D9Ej5fM(), 0, 10, i10).then(predictiveBackDrawerContainer), 0, i40, 0), obj2, i16, i51, drawerContentColor2, obj18, f, 0, i10, (Function2)ComposableLambdaKt.rememberComposableLambda(669057502, i40, anon, restartGroup, 54), restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i12 = $dirty;
                $composer2 = obj7;
                $dirty2 = obj2;
                l3 = i16;
                l2 = drawerContentColor2;
                modifier2 = f;
            } else {
                restartGroup.skipToGroupEnd();
                composer = restartGroup;
                $composer2 = obj;
                l3 = standardContainerColor;
                i12 = $dirty;
                $dirty2 = obj3;
                l2 = drawerTonalElevation;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new NavigationDrawerKt.DrawerSheet.2(drawerPredictiveBackState, obj5, $composer2, $dirty2, l3, obj, l2, obj3, modifier2, obj8, i48, i49);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void ModalDrawerSheet-Snr_uVM(androidx.compose.material3.DrawerState drawerState, Modifier modifier, Shape drawerShape, long drawerContainerColor, long drawerContentColor, float drawerTonalElevation, WindowInsets windowInsets, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i11) {
        Object obj6;
        int traceInProgress2;
        int windowInsets2;
        boolean traceInProgress;
        int defaultsInvalid;
        int shape;
        int drawerShape2;
        int modalDrawerElevation-D9Ej5fM;
        int $dirty;
        Object $dirty2;
        int i;
        int str;
        Object obj2;
        Object obj9;
        long l;
        int i2;
        Object obj7;
        int changed2;
        long modalContainerColor;
        long l2;
        int changed;
        long contentColorFor-ek8zF_U;
        float f2;
        Object obj3;
        int changed3;
        int i3;
        float f3;
        int i4;
        int i5;
        Object obj4;
        int changed4;
        int i6;
        androidx.compose.material3.NavigationDrawerKt.ModalDrawerSheet.2 anon;
        Object obj5;
        Object obj;
        Object obj8;
        long l3;
        long l4;
        float f;
        Object obj10;
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
                i = restartGroup.changed(obj11) ? 4 : 2;
                $dirty |= i;
            }
        }
        int i15 = i29 & 2;
        if (i15 != 0) {
            $dirty |= 48;
            obj9 = modifier;
        } else {
            if (i28 & 48 == 0) {
                i2 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i2;
            } else {
                obj9 = modifier;
            }
        }
        if (i28 & 384 == 0) {
            if (i29 & 4 == 0) {
                changed2 = restartGroup.changed(drawerShape) ? 256 : 128;
            } else {
                obj7 = drawerShape;
            }
            $dirty |= changed2;
        } else {
            obj7 = drawerShape;
        }
        if (i28 & 3072 == 0) {
            if (i29 & 8 == 0) {
                changed = restartGroup.changed(drawerContainerColor) ? 2048 : 1024;
            } else {
                modalContainerColor = drawerContainerColor;
            }
            $dirty |= changed;
        } else {
            modalContainerColor = drawerContainerColor;
        }
        if (i28 & 24576 == 0) {
            if (i29 & 16 == 0) {
                changed3 = restartGroup.changed(drawerTonalElevation) ? 16384 : 8192;
            } else {
                contentColorFor-ek8zF_U = drawerTonalElevation;
            }
            $dirty |= changed3;
        } else {
            contentColorFor-ek8zF_U = drawerTonalElevation;
        }
        i3 = i29 & 32;
        int i30 = 196608;
        if (i3 != 0) {
            $dirty |= i30;
            f3 = content;
        } else {
            if (i30 &= i28 == 0) {
                i5 = restartGroup.changed(content) ? 131072 : 65536;
                $dirty |= i5;
            } else {
                f3 = content;
            }
        }
        if (i32 &= i28 == 0) {
            if (i29 & 64 == 0) {
                changed4 = restartGroup.changed($composer) ? 1048576 : 524288;
            } else {
                obj4 = $composer;
            }
            $dirty |= changed4;
        } else {
            obj4 = $composer;
        }
        i6 = 12582912;
        if (i29 & 128 != 0) {
            $dirty |= i6;
            obj6 = $changed;
        } else {
            if (i28 & i6 == 0) {
                i6 = restartGroup.changedInstance($changed) ? 8388608 : 4194304;
                $dirty |= i6;
            } else {
                obj6 = $changed;
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
                            obj9 = defaultsInvalid;
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
                        if (i3 != 0) {
                            f3 = modalDrawerElevation-D9Ej5fM;
                        }
                        if (i29 & 64 != 0) {
                            $dirty &= obj38;
                            obj5 = windowInsets2;
                            obj = obj9;
                            obj8 = obj7;
                            l3 = modalContainerColor;
                            l4 = contentColorFor-ek8zF_U;
                            f = f3;
                        } else {
                            obj = obj9;
                            obj8 = obj7;
                            l3 = modalContainerColor;
                            l4 = contentColorFor-ek8zF_U;
                            f = f3;
                            obj5 = obj4;
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
                            obj = obj9;
                            obj8 = obj7;
                            l3 = modalContainerColor;
                            l4 = contentColorFor-ek8zF_U;
                            f = f3;
                            obj5 = obj4;
                        } else {
                            obj = obj9;
                            obj8 = obj7;
                            l3 = modalContainerColor;
                            l4 = contentColorFor-ek8zF_U;
                            f = f3;
                            obj5 = obj4;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1513027356, $dirty, -1, "androidx.compose.material3.ModalDrawerSheet (NavigationDrawer.kt:611)");
                }
                anon = new NavigationDrawerKt.ModalDrawerSheet.2(obj5, obj, obj8, l3, obj22, l4, obj24, f, $changed);
                NavigationDrawer_androidKt.DrawerPredictiveBackHandler(obj11, (Function3)ComposableLambdaKt.rememberComposableLambda(1552342929, true, anon, restartGroup, 54), restartGroup, i18 |= 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i4 = $dirty;
                obj3 = obj5;
                $dirty2 = obj;
                obj2 = obj8;
                l = l3;
                l2 = l4;
                f2 = f;
            } else {
                restartGroup.skipToGroupEnd();
                obj2 = obj7;
                i4 = $dirty;
                $dirty2 = obj9;
                l = modalContainerColor;
                l2 = contentColorFor-ek8zF_U;
                f2 = f4;
                obj3 = obj4;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new NavigationDrawerKt.ModalDrawerSheet.3(obj11, $dirty2, obj2, l, obj7, l2, obj7, f2, obj3, $changed, i28, i29);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void ModalDrawerSheet-afqeVBk(Modifier modifier, Shape drawerShape, long drawerContainerColor, long drawerContentColor, float drawerTonalElevation, WindowInsets windowInsets, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i10) {
        int traceInProgress2;
        int windowInsets3;
        int defaultsInvalid;
        int shape;
        int drawerShape2;
        int modalDrawerElevation-D9Ej5fM;
        Object $composer2;
        int $dirty;
        Object $dirty2;
        int i7;
        long l;
        Object obj3;
        boolean traceInProgress;
        int i4;
        Object str;
        long l2;
        int changed3;
        long modalContainerColor;
        float f2;
        int changed4;
        long contentColorFor-ek8zF_U;
        Object obj4;
        int i6;
        int changed;
        int i9;
        float f3;
        Object drawerTonalElevation2;
        int windowInsets2;
        int i2;
        Object obj;
        int changed2;
        Object obj2;
        int i3;
        long i5;
        long l3;
        float f;
        Composer composer;
        Composer composer2;
        int i8;
        int i;
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
                i4 = restartGroup.changed(modifier) ? 4 : 2;
                $dirty |= i4;
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
                changed4 = restartGroup.changed(drawerContainerColor) ? 256 : 128;
            } else {
                modalContainerColor = drawerContainerColor;
            }
            $dirty |= changed4;
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
        i9 = obj35 & 16;
        if (i9 != 0) {
            $dirty |= 24576;
            f3 = content;
        } else {
            if (i51 & 24576 == 0) {
                i2 = restartGroup.changed(content) ? 16384 : 8192;
                $dirty |= i2;
            } else {
                f3 = content;
            }
        }
        if (i53 &= i51 == 0) {
            if (obj35 & 32 == 0) {
                changed2 = restartGroup.changed($composer) ? 131072 : 65536;
            } else {
                obj = $composer;
            }
            $dirty |= changed2;
        } else {
            obj = $composer;
        }
        i3 = 1572864;
        if (obj35 & 64 != 0) {
            $dirty |= i3;
            obj2 = $changed;
        } else {
            if (i51 & i3 == 0) {
                i3 = restartGroup.changedInstance($changed) ? 1048576 : 524288;
                $dirty |= i3;
            } else {
                obj2 = $changed;
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
                        if (i9 != 0) {
                            f3 = modalDrawerElevation-D9Ej5fM;
                        }
                        if (obj35 & 32 != 0) {
                            $dirty &= obj33;
                            obj = obj3;
                            obj2 = str;
                            l3 = contentColorFor-ek8zF_U;
                            f = f3;
                            i7 = 1001163336;
                            drawerTonalElevation2 = windowInsets4;
                            windowInsets3 = i59;
                            i5 = modalContainerColor;
                        } else {
                            obj2 = str;
                            l3 = contentColorFor-ek8zF_U;
                            f = f3;
                            drawerTonalElevation2 = obj;
                            windowInsets3 = i59;
                            i7 = 1001163336;
                            obj = obj3;
                            i5 = modalContainerColor;
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
                            obj2 = str;
                            l3 = contentColorFor-ek8zF_U;
                            f = f3;
                            drawerTonalElevation2 = obj;
                            windowInsets3 = i59;
                            i7 = 1001163336;
                            obj = obj3;
                            i5 = modalContainerColor;
                        } else {
                            obj2 = str;
                            l3 = contentColorFor-ek8zF_U;
                            f = f3;
                            drawerTonalElevation2 = obj;
                            windowInsets3 = i59;
                            i7 = 1001163336;
                            obj = obj3;
                            i5 = modalContainerColor;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i7, $dirty, -1, "androidx.compose.material3.ModalDrawerSheet (NavigationDrawer.kt:567)");
                }
                NavigationDrawerKt.DrawerSheet-7zSek6w(0, drawerTonalElevation2, obj, obj2, i5, obj16, l3, obj18, f, $changed, restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj4 = drawerTonalElevation2;
                $composer2 = obj;
                l = i5;
                l2 = l3;
                f2 = f;
                windowInsets2 = $dirty;
                $dirty2 = obj2;
            } else {
                restartGroup.skipToGroupEnd();
                composer2 = restartGroup;
                $composer2 = obj3;
                l = modalContainerColor;
                f2 = f3;
                windowInsets2 = $dirty;
                $dirty2 = str;
                l2 = contentColorFor-ek8zF_U;
                obj4 = obj;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new NavigationDrawerKt.ModalDrawerSheet.1($composer2, $dirty2, l, obj3, l2, modalContainerColor, f2, obj4, $changed, i51, obj35);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void ModalNavigationDrawer-FHprtrg(Function2<? super Composer, ? super Integer, Unit> drawerContent, Modifier modifier, androidx.compose.material3.DrawerState drawerState, boolean gesturesEnabled, long scrimColor, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i9) {
        Object composer$iv;
        Function0 factory$iv$iv$iv2;
        int i37;
        Object anon3;
        Object anon2;
        Object valueOf;
        Object semantics$default;
        Object empty;
        int empty4;
        boolean traceInProgress;
        boolean currentCompositionLocalMap;
        int changed9;
        int i7;
        int i8;
        int empty2;
        Object anon4;
        Object navigationMenu;
        Function0 factory$iv$iv;
        int changed6;
        int changed3;
        Object obj8;
        int $dirty;
        Object $dirty2;
        int i4;
        Object modifier5;
        Integer currentCompositionLocalMap2;
        Object obj7;
        int compositionCoroutineScope;
        Composer composer2;
        Object coroutineScope2;
        boolean z;
        Object obj;
        int rememberDrawerState;
        boolean traceInProgress2;
        Object empty6;
        Function0 factory$iv$iv$iv;
        Object it$iv;
        int i24;
        int changed7;
        long l2;
        int i36;
        Object obj5;
        Object empty3;
        int i33;
        Object mutableStateOf$default;
        int i6;
        int changed8;
        int i20;
        int mutableFloatStateOf;
        int defaultsInvalid;
        Object empty5;
        boolean changed5;
        int changed;
        int currentCompositeKeyHash3;
        boolean obj2;
        int i29;
        long scrimColor2;
        int i19;
        Object anon;
        Object empty7;
        int changed4;
        boolean z2;
        int changed2;
        int i12;
        int i10;
        Composer composer;
        Composer composer3;
        int i34;
        int i22;
        int i3;
        int i13;
        Object maybeCachedBoxMeasurePolicy;
        Object maybeCachedBoxMeasurePolicy2;
        Modifier materializeModifier;
        int i26;
        int companion6;
        Object obj4;
        Composer.Companion companion2;
        int i32;
        boolean z3;
        int i23;
        Object iNSTANCE;
        int i;
        int companion3;
        int i14;
        int companion5;
        Composer.Companion companion;
        int i31;
        int invalid$iv;
        int invalid$iv2;
        Object obj6;
        int i30;
        int invalid$iv3;
        long l3;
        long l;
        Function0 function02;
        int i27;
        kotlinx.coroutines.CoroutineScope coroutineScope;
        Alignment alignment;
        int i38;
        int currentCompositeKeyHash2;
        Modifier modifier4;
        Function0 function0;
        int i18;
        int i35;
        Object obj3;
        String str;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv2;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy;
        int i5;
        int i15;
        BoxScopeInstance boxScopeInstance;
        Modifier modifier2;
        Composer composer6;
        int i16;
        int i11;
        int currentCompositeKeyHash;
        int i25;
        int i21;
        androidx.compose.ui.Modifier.Companion companion4;
        Function0 function03;
        int i2;
        int i17;
        Composer composer5;
        String str2;
        int i28;
        BoxScopeInstance boxScopeInstance2;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy2;
        Composer composer4;
        Modifier modifier3;
        Composer obj63;
        int obj64;
        Composer obj65;
        int obj66;
        int obj67;
        int obj69;
        empty3 = $composer;
        i20 = i9;
        final Composer restartGroup = $changed.startRestartGroup(-1169303680);
        ComposerKt.sourceInformation(restartGroup, "C(ModalNavigationDrawer)P(1,4,2,3,5:c#ui.graphics.Color)316@12708L39,318@12825L10,321@12893L24,322@12943L33,323@13008L7,324@13046L34,325@13101L45,328@13185L33,328@13174L44,330@13257L7,331@13292L3053:NavigationDrawer.kt#uh7d8r");
        $dirty = i9;
        int i74 = 2;
        if (obj71 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (i20 & 6 == 0) {
                i4 = restartGroup.changedInstance(drawerContent) ? 4 : i74;
                $dirty |= i4;
            }
        }
        int i69 = obj71 & 2;
        if (i69 != 0) {
            $dirty |= 48;
            obj = modifier;
        } else {
            if (i20 & 48 == 0) {
                i36 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i36;
            } else {
                obj = modifier;
            }
        }
        if (i20 & 384 == 0) {
            if (obj71 & 4 == 0) {
                changed = restartGroup.changed(drawerState) ? 256 : 128;
            } else {
                obj5 = drawerState;
            }
            $dirty |= changed;
        } else {
            obj5 = drawerState;
        }
        currentCompositeKeyHash3 = obj71 & 8;
        if (currentCompositeKeyHash3 != 0) {
            $dirty |= 3072;
            obj2 = gesturesEnabled;
        } else {
            if (i20 & 3072 == 0) {
                i29 = restartGroup.changed(gesturesEnabled) ? 2048 : 1024;
                $dirty |= i29;
            } else {
                obj2 = gesturesEnabled;
            }
        }
        if (i20 & 24576 == 0) {
            if (obj71 & 16 == 0) {
                changed2 = restartGroup.changed(scrimColor) ? 16384 : 8192;
            } else {
                scrimColor2 = scrimColor;
            }
            $dirty |= changed2;
        } else {
            scrimColor2 = scrimColor;
        }
        if (obj71 & 32 != 0) {
            i12 = 196608;
            $dirty |= i12;
        } else {
        }
        if (i126 &= $dirty == 74898) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i39 = 6;
                if (i20 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i69 != 0) {
                            modifier5 = Modifier.Companion;
                        } else {
                            modifier5 = obj;
                        }
                        if (obj71 & 4 != 0) {
                            $dirty &= -897;
                            obj5 = rememberDrawerState;
                        }
                        if (currentCompositeKeyHash3 != 0) {
                            obj2 = rememberDrawerState;
                        }
                        if (obj71 & 16 != 0) {
                            scrimColor2 = DrawerDefaults.INSTANCE.getScrimColor(restartGroup, i39);
                            $dirty &= obj;
                            z3 = obj2;
                        } else {
                            z3 = obj2;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (obj71 & 4 != 0) {
                            $dirty &= -897;
                        }
                        if (obj71 & 16 != 0) {
                            $dirty &= i73;
                            modifier5 = obj;
                            z3 = obj2;
                        } else {
                            modifier5 = obj;
                            z3 = obj2;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1169303680, $dirty, -1, "androidx.compose.material3.ModalNavigationDrawer (NavigationDrawer.kt:320)");
                }
                int i100 = i76;
                int i106 = 0;
                int i146 = i39;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                Composer composer7 = restartGroup;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -954363344, "CC(remember):Effects.kt#9igjgp");
                compositionCoroutineScope = 0;
                Composer composer15 = restartGroup;
                int i148 = 0;
                Object rememberedValue9 = composer15.rememberedValue();
                int i151 = 0;
                if (rememberedValue9 == Composer.Companion.getEmpty()) {
                    empty6 = 0;
                    int i157 = 0;
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
                int i101 = 0;
                int i107 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                Object this_$iv2 = consume2;
                String str7 = "CC(remember):NavigationDrawer.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -2145781231, str7);
                Composer composer16 = restartGroup;
                int i128 = 0;
                mutableStateOf$default = composer16.rememberedValue();
                int i149 = 0;
                obj64 = i103;
                if (mutableStateOf$default == Composer.Companion.getEmpty()) {
                    obj65 = mutableStateOf$default;
                    obj66 = i104;
                    l = scrimColor2;
                    scrimColor2 = 0;
                    composer16.updateRememberedValue(SnapshotStateKt.mutableStateOf$default(false, scrimColor2, 2, scrimColor2));
                } else {
                    obj65 = mutableStateOf$default;
                    l = scrimColor2;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerStart(restartGroup, -2145779460, str7);
                changed5 = restartGroup.changed((Density)this_$iv2);
                Composer composer17 = restartGroup;
                int i116 = 0;
                Object rememberedValue7 = composer17.rememberedValue();
                int i129 = 0;
                if (!changed5) {
                    obj64 = changed5;
                    if (rememberedValue7 == Composer.Companion.getEmpty()) {
                        int invalid$iv7 = 0;
                        composer17.updateRememberedValue(PrimitiveSnapshotStateKt.mutableFloatStateOf(0));
                    } else {
                        mutableFloatStateOf = rememberedValue7;
                    }
                } else {
                    obj64 = changed5;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                obj2 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -2145776784, str7);
                if (i118 ^= 384 > 256) {
                    if (!restartGroup.changed(obj5)) {
                        i19 = $dirty & 384 == 256 ? 1 : 0;
                    } else {
                    }
                } else {
                }
                i19 |= changed15;
                Composer composer18 = restartGroup;
                int i147 = 0;
                Object rememberedValue8 = composer18.rememberedValue();
                int i150 = 0;
                if (empty7 == 0) {
                    obj65 = empty7;
                    if (rememberedValue8 == Composer.Companion.getEmpty()) {
                        obj66 = invalid$iv8;
                        anon = new NavigationDrawerKt.ModalNavigationDrawer.1.1(obj5, this_$iv2);
                        composer18.updateRememberedValue((Function0)anon);
                    } else {
                        anon = rememberedValue8;
                    }
                } else {
                    obj65 = empty7;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                EffectsKt.SideEffect((Function0)anon, restartGroup, 0);
                int i130 = 0;
                obj65 = this_$iv2;
                obj66 = i123;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                i = restartGroup.consume((CompositionLocal)CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl ? 1 : 0;
                Modifier anchoredDraggable$default = AnchoredDraggableKt.anchoredDraggable$default(SizeKt.fillMaxSize$default(modifier5, 0, 1, 0), obj5.getAnchoredDraggableState$material3_release(), Orientation.Horizontal, z3, i, 0, 16, 0);
                z2 = z3;
                companion6 = 0;
                obj66 = i120;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                Alignment topStart2 = Alignment.Companion.getTopStart();
                int i121 = 0;
                obj67 = i131;
                maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(topStart2, i121);
                i23 = 0;
                alignment = topStart2;
                i38 = i121;
                String propagateMinConstraints$iv = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, propagateMinConstraints$iv);
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, 0);
                currentCompositionLocalMap2 = restartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(restartGroup, anchoredDraggable$default);
                modifier4 = anchoredDraggable$default;
                Function0 function04 = constructor;
                i18 = 0;
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
                    factory$iv$iv$iv = function04;
                    restartGroup.useNode();
                }
                function0 = factory$iv$iv$iv;
                Composer constructor-impl3 = Updater.constructor-impl(restartGroup);
                int i154 = 0;
                Updater.set-impl(constructor-impl3, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl3, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i159 = 0;
                Composer composer20 = constructor-impl3;
                int i165 = 0;
                if (!composer20.getInserting()) {
                    localMap$iv$iv2 = currentCompositionLocalMap2;
                    measurePolicy = maybeCachedBoxMeasurePolicy2;
                    if (!Intrinsics.areEqual(composer20.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        composer20.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        constructor-impl3.apply(Integer.valueOf(currentCompositeKeyHash2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer = composer20;
                    }
                } else {
                    localMap$iv$iv2 = currentCompositionLocalMap2;
                    measurePolicy = maybeCachedBoxMeasurePolicy2;
                }
                Updater.set-impl(constructor-impl3, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                Composer composer11 = restartGroup;
                i5 = i41;
                ComposerKt.sourceInformationMarkerStart(composer11, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                Composer composer19 = composer11;
                i15 = 0;
                boxScopeInstance = iNSTANCE2;
                modifier2 = materializeModifier2;
                ComposerKt.sourceInformationMarkerStart(composer11, -1884917117, "C341@13601L17,344@13695L268,352@13988L70,342@13627L473,358@14209L245,364@14486L623,379@15121L1218,355@14109L2230:NavigationDrawer.kt#uh7d8r");
                int i155 = i42;
                companion5 = i58;
                ComposerKt.sourceInformationMarkerStart(composer11, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                androidx.compose.ui.Modifier.Companion companion10 = Modifier.Companion;
                Alignment topStart = Alignment.Companion.getTopStart();
                i16 = i82;
                int i83 = 0;
                i11 = i135;
                maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(topStart, i83);
                int i166 = 0;
                Alignment alignment2 = topStart;
                ComposerKt.sourceInformationMarkerStart(composer11, -1323940314, propagateMinConstraints$iv);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer11, 0);
                currentCompositionLocalMap = composer11.getCurrentCompositionLocalMap();
                i25 = i83;
                Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer11, (Modifier)companion10);
                companion4 = companion10;
                Function0 function05 = constructor3;
                i21 = 0;
                ComposerKt.sourceInformationMarkerStart(composer11, -692256719, anchorsInitialized$delegate2);
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                composer11.startReusableNode();
                if (composer11.getInserting()) {
                    composer11.createNode(function05);
                } else {
                    factory$iv$iv$iv2 = function05;
                    composer11.useNode();
                }
                function03 = factory$iv$iv$iv2;
                Composer constructor-impl = Updater.constructor-impl(composer11);
                int i168 = 0;
                Updater.set-impl(constructor-impl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i169 = 0;
                Composer composer22 = constructor-impl;
                int i170 = 0;
                if (!composer22.getInserting()) {
                    localMap$iv$iv = currentCompositionLocalMap;
                    measurePolicy2 = maybeCachedBoxMeasurePolicy;
                    if (!Intrinsics.areEqual(composer22.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer22.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer3 = composer22;
                    }
                } else {
                    localMap$iv$iv = currentCompositionLocalMap;
                    measurePolicy2 = maybeCachedBoxMeasurePolicy;
                }
                Updater.set-impl(constructor-impl, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                Composer composer8 = composer11;
                int i95 = 0;
                i17 = i46;
                ComposerKt.sourceInformationMarkerStart(composer8, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                i138 |= 6;
                i28 = 0;
                boxScopeInstance2 = iNSTANCE3;
                modifier3 = materializeModifier3;
                Composer materialized$iv$iv2 = composer5;
                ComposerKt.sourceInformationMarkerStart(materialized$iv$iv2, 2020094509, "C341@13607L9:NavigationDrawer.kt#uh7d8r");
                empty3.invoke(materialized$iv$iv2, Integer.valueOf(i47 &= 14));
                ComposerKt.sourceInformationMarkerEnd(materialized$iv$iv2);
                ComposerKt.sourceInformationMarkerEnd(composer8);
                composer11.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer11);
                ComposerKt.sourceInformationMarkerEnd(composer11);
                ComposerKt.sourceInformationMarkerEnd(composer11);
                ComposerKt.sourceInformationMarkerStart(composer11, -2139013222, str7);
                i37 = $dirty & 7168 == 2048 ? 1 : 0;
                if (i61 ^= 384 > 256) {
                    if (!restartGroup.changed(obj5)) {
                        i7 = $dirty & 384 == 256 ? 1 : 0;
                    } else {
                    }
                } else {
                }
                i51 |= changedInstance;
                Composer composer9 = composer11;
                int i84 = 0;
                Object rememberedValue4 = composer9.rememberedValue();
                int i140 = 0;
                if (empty4 == 0) {
                    invalid$iv = empty4;
                    if (rememberedValue4 == Composer.Companion.getEmpty()) {
                        companion5 = invalid$iv5;
                        anon3 = new NavigationDrawerKt.ModalNavigationDrawer.2.2.1(z2, obj5, coroutineScope2);
                        composer9.updateRememberedValue((Function0)anon3);
                    } else {
                        anon3 = rememberedValue4;
                    }
                } else {
                    invalid$iv = empty4;
                }
                ComposerKt.sourceInformationMarkerEnd(composer11);
                ComposerKt.sourceInformationMarkerStart(composer11, -2139004044, str7);
                if (i62 ^= 384 > 256) {
                    if (!restartGroup.changed(obj5)) {
                        i8 = $dirty & 384 == 256 ? 1 : 0;
                    } else {
                    }
                } else {
                }
                changed10 |= i8;
                Composer composer10 = composer11;
                int i85 = 0;
                Object rememberedValue5 = composer10.rememberedValue();
                int i141 = 0;
                if (empty == 0) {
                    invalid$iv3 = empty;
                    if (rememberedValue5 == Composer.Companion.getEmpty()) {
                        invalid$iv = invalid$iv4;
                        anon2 = new NavigationDrawerKt.ModalNavigationDrawer.2.3.1(obj2, obj5, mutableFloatStateOf);
                        composer10.updateRememberedValue((Function0)anon2);
                    } else {
                        anon2 = rememberedValue5;
                    }
                } else {
                    invalid$iv3 = empty;
                }
                ComposerKt.sourceInformationMarkerEnd(composer11);
                l3 = l;
                NavigationDrawerKt.Scrim-Bx497Mc(obj5.isOpen(), (Function0)anon3, (Function0)anon2, l3, l, composer11);
                ComposerKt.sourceInformationMarkerStart(composer11, -2138996797, str7);
                if (i64 ^= 384 > 256) {
                    if (!restartGroup.changed(obj5)) {
                        empty2 = $dirty & 384 == 256 ? 1 : 0;
                    } else {
                    }
                } else {
                }
                Composer composer12 = composer11;
                int i96 = 0;
                Object rememberedValue10 = composer12.rememberedValue();
                int i156 = 0;
                if (empty2 == 0) {
                    invalid$iv2 = empty2;
                    if (rememberedValue10 == Composer.Companion.getEmpty()) {
                        companion = invalid$iv6;
                        anon4 = new NavigationDrawerKt.ModalNavigationDrawer.2.4.1(obj5);
                        composer12.updateRememberedValue((Function1)anon4);
                    } else {
                        anon4 = rememberedValue10;
                    }
                } else {
                    invalid$iv2 = empty2;
                }
                ComposerKt.sourceInformationMarkerEnd(composer11);
                ComposerKt.sourceInformationMarkerStart(composer11, -2138987555, str7);
                String str4 = str9;
                if (i97 ^= 384 > 256) {
                    if (!restartGroup.changed(obj5)) {
                        i6 = $dirty & 384 == 256 ? 1 : 0;
                    } else {
                    }
                } else {
                }
                Composer composer14 = composer11;
                int i142 = 0;
                it$iv = composer14.rememberedValue();
                int i160 = 0;
                if (i86 |= changedInstance3 == 0) {
                    if (it$iv == Composer.Companion.getEmpty()) {
                        empty3 = 0;
                        obj6 = it$iv;
                        it$iv = new NavigationDrawerKt.ModalNavigationDrawer.2.5.1(str4, obj5, coroutineScope2);
                        composer14.updateRememberedValue((Function1)it$iv);
                    } else {
                        obj6 = it$iv;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(composer11);
                int i143 = 1;
                semantics$default = SemanticsModifierKt.semantics$default(OffsetKt.offset((Modifier)Modifier.Companion, (Function1)anon4), false, (Function1)it$iv, i143, 0);
                ComposerKt.sourceInformationMarkerStart(composer11, -2138966640, str7);
                if (i89 ^= 384 > 256) {
                    if (!restartGroup.changed(obj5)) {
                        i24 = $dirty & 384 == 256 ? i143 : 0;
                    } else {
                    }
                } else {
                }
                Composer composer13 = composer11;
                int i99 = 0;
                Object rememberedValue6 = composer13.rememberedValue();
                int i144 = 0;
                if (i24 |= changed13 == 0) {
                    obj64 = semantics$default;
                    if (rememberedValue6 == Composer.Companion.getEmpty()) {
                        obj69 = i57;
                        str = str4;
                        valueOf = new NavigationDrawerKt.ModalNavigationDrawer.2.6.1(obj5, obj10, mutableFloatStateOf, obj2);
                        composer13.updateRememberedValue((MeasurePolicy)valueOf);
                    } else {
                        str = str4;
                        valueOf = rememberedValue6;
                        navigationMenu = obj10;
                    }
                } else {
                    obj64 = semantics$default;
                }
                ComposerKt.sourceInformationMarkerEnd(composer11);
                i20 = 0;
                ComposerKt.sourceInformationMarkerStart(composer11, -1323940314, propagateMinConstraints$iv);
                currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer11, 0);
                obj3 = navigationMenu;
                obj63 = constructor2;
                i26 = 0;
                i14 = $dirty;
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
                i31 = 0;
                function02 = factory$iv$iv;
                Updater.set-impl(constructor-impl2, (MeasurePolicy)valueOf, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl2, composer11.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                i30 = 0;
                obj63 = constructor-impl2;
                i27 = 0;
                if (!obj63.getInserting()) {
                    obj69 = valueOf;
                    coroutineScope = coroutineScope2;
                    if (!Intrinsics.areEqual(obj63.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                        obj63.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        constructor-impl2.apply(Integer.valueOf(currentCompositeKeyHash3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer2 = obj63;
                    }
                } else {
                    obj69 = valueOf;
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
                obj7 = obj5;
                z = z2;
                $dirty2 = obj4;
                l2 = l3;
            } else {
                restartGroup.skipToGroupEnd();
                i14 = $dirty;
                $dirty2 = obj;
                obj7 = obj5;
                z = obj2;
                l2 = scrimColor2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new NavigationDrawerKt.ModalNavigationDrawer.3(obj8, $dirty2, obj7, z, l2, obj5, $composer, i9, obj71);
            endRestartGroup.updateScope((Function2)traceInProgress);
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
        boolean traceInProgress;
        int modifier3;
        int defaultsInvalid;
        Object modifier2;
        Modifier i11;
        int i6;
        int i;
        int $dirty;
        Object obj12;
        Object colors2;
        Object shape2;
        Object obj2;
        Object obj;
        int i8;
        Object obj14;
        Object obj9;
        Object obj5;
        int i2;
        int i7;
        Object obj4;
        boolean traceInProgress2;
        Object obj13;
        int i14;
        int value;
        Object navigationDrawerItemColors2;
        Object anon;
        int i19;
        int i3;
        int i5;
        Object obj6;
        int i13;
        int i9;
        Object obj8;
        Composer restartGroup;
        int i4;
        Object obj10;
        int changed;
        int changed2;
        int i15;
        int i10;
        int i16;
        androidx.compose.material3.NavigationDrawerItemColors navigationDrawerItemColors;
        int i17;
        Composer composer2;
        Composer composer;
        int i18;
        int i20;
        Object obj11;
        Object obj7;
        Object obj3;
        int $dirty2;
        int i21;
        androidx.compose.material3.NavigationDrawerKt.NavigationDrawerItem.2 obj32;
        Object obj33;
        androidx.compose.material3.NavigationDrawerItemColors obj34;
        boolean obj35;
        Object obj36;
        Function2 obj37;
        int obj38;
        traceInProgress = selected;
        int i27 = $changed;
        i11 = i12;
        restartGroup = $composer.startRestartGroup(-1304626543);
        ComposerKt.sourceInformation(restartGroup, "C(NavigationDrawerItem)P(4,7,6,5,2!1,8)925@38341L5,926@38418L8,938@38801L24,940@38886L884,929@38492L1278:NavigationDrawer.kt#uh7d8r");
        $dirty = $changed;
        if (i11 & 1 != 0) {
            $dirty |= 6;
            obj2 = label;
        } else {
            if (i27 & 6 == 0) {
                i2 = restartGroup.changedInstance(label) ? 4 : 2;
                $dirty |= i2;
            } else {
                obj2 = label;
            }
        }
        if (i11 & 2 != 0) {
            $dirty |= 48;
        } else {
            if (i27 & 48 == 0) {
                i7 = restartGroup.changed(traceInProgress) ? 32 : 16;
                $dirty |= i7;
            }
        }
        if (i11 & 4 != 0) {
            $dirty |= 384;
            obj4 = onClick;
        } else {
            if (i27 & 384 == 0) {
                i14 = restartGroup.changedInstance(onClick) ? 256 : 128;
                $dirty |= i14;
            } else {
                obj4 = onClick;
            }
        }
        value = i11 & 8;
        if (value != null) {
            $dirty |= 3072;
            anon = modifier;
        } else {
            if (i27 & 3072 == 0) {
                i3 = restartGroup.changed(modifier) ? 2048 : 1024;
                $dirty |= i3;
            } else {
                anon = modifier;
            }
        }
        i5 = i11 & 16;
        if (i5 != 0) {
            $dirty |= 24576;
            obj6 = icon;
        } else {
            if (i27 & 24576 == 0) {
                i13 = restartGroup.changedInstance(icon) ? 16384 : 8192;
                $dirty |= i13;
            } else {
                obj6 = icon;
            }
        }
        i9 = i11 & 32;
        int i61 = 196608;
        if (i9 != 0) {
            $dirty |= i61;
            obj8 = badge;
        } else {
            if (i61 &= i27 == 0) {
                i4 = restartGroup.changedInstance(badge) ? 131072 : 65536;
                $dirty |= i4;
            } else {
                obj8 = badge;
            }
        }
        if (i63 &= i27 == 0) {
            if (i11 & 64 == 0) {
                changed = restartGroup.changed(shape) ? 1048576 : 524288;
            } else {
                obj10 = shape;
            }
            $dirty |= changed;
        } else {
            obj10 = shape;
        }
        if (i27 & i66 == 0) {
            if (i11 & 128 == 0) {
                changed2 = restartGroup.changed(colors) ? 8388608 : 4194304;
            } else {
                obj9 = colors;
            }
            $dirty |= changed2;
        } else {
            obj9 = colors;
        }
        int i32 = i11 & 256;
        i15 = 100663296;
        if (i32 != 0) {
            $dirty |= i15;
            obj = interactionSource;
        } else {
            if (i27 & i15 == 0) {
                i15 = restartGroup.changed(interactionSource) ? 67108864 : 33554432;
                $dirty |= i15;
            } else {
                obj = interactionSource;
            }
        }
        if ($dirty & i10 == 38347922) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i33 = -29360129;
                int i67 = -3670017;
                if ($changed & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (value != null) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = anon;
                        }
                        obj11 = i5 != 0 ? value : obj6;
                        obj7 = i9 != 0 ? value : obj8;
                        if (i11 & 64 != 0) {
                            obj3 = value;
                            $dirty2 = $dirty;
                        } else {
                            obj3 = obj10;
                            $dirty2 = $dirty;
                        }
                        if (i11 & 128 != 0) {
                            composer2 = restartGroup;
                            i6 = 2;
                            obj12 = NavigationDrawerItemDefaults.INSTANCE.colors-oq7We08(0, obj9, 0, value, 0, i5, 0, i9, 0, restartGroup, 0);
                            restartGroup = composer2;
                            $dirty2 &= obj38;
                        } else {
                            i6 = 2;
                            obj12 = colors;
                        }
                        if (i32 != 0) {
                            obj9 = obj12;
                            i9 = i37;
                            colors2 = obj3;
                            i8 = $dirty2;
                        } else {
                            i9 = interactionSource;
                            obj9 = obj12;
                            colors2 = obj3;
                            i8 = $dirty2;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i11 & 64 != 0) {
                            $dirty &= i67;
                        }
                        if (i11 & 128 != 0) {
                            i9 = obj;
                            obj11 = obj6;
                            obj7 = obj8;
                            colors2 = obj10;
                            i6 = 2;
                            i8 = i30;
                            modifier2 = anon;
                        } else {
                            i9 = obj;
                            modifier2 = anon;
                            obj11 = obj6;
                            obj7 = obj8;
                            i6 = 2;
                            i8 = $dirty;
                            colors2 = obj10;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1304626543, i8, -1, "androidx.compose.material3.NavigationDrawerItem (NavigationDrawer.kt:928)");
                }
                int i54 = 1;
                int i57 = 0;
                int i60 = 0;
                i51 &= 112;
                obj34 = obj9;
                obj32 = anon3;
                super(obj11, obj34, traceInProgress, obj7, label);
                i42 &= i55;
                i21 = i8;
                SurfaceKt.Surface-d85dljk(selected, onClick, SizeKt.fillMaxWidth$default(SizeKt.heightIn-VpY3zN4$default(SemanticsModifierKt.semantics$default(modifier2, false, (Function1)NavigationDrawerKt.NavigationDrawerItem.1.INSTANCE, i54, i57), NavigationDrawerTokens.INSTANCE.getActiveIndicatorHeight-D9Ej5fM(), i60, i6, i57), i60, i54, i57), false, colors2, (Color)obj9.containerColor(traceInProgress, restartGroup, i47 |= i52).getValue().unbox-impl(), i43, 0, i52, 0, 0, 0, i9, (Function2)ComposableLambdaKt.rememberComposableLambda(191488423, i54, obj32, restartGroup, 54), restartGroup, i24 | i43);
                composer = restartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj13 = colors2;
                i19 = i9;
                navigationDrawerItemColors2 = navigationDrawerItemColors;
                shape2 = i17;
                obj14 = obj11;
                obj5 = obj7;
            } else {
                restartGroup.skipToGroupEnd();
                i21 = $dirty;
                navigationDrawerItemColors2 = obj9;
                shape2 = anon;
                obj5 = obj8;
                composer = restartGroup;
                obj13 = obj10;
                i19 = obj;
                obj14 = obj6;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new NavigationDrawerKt.NavigationDrawerItem.3(label, selected, onClick, shape2, obj14, obj5, obj13, navigationDrawerItemColors2, i19, $changed, i12);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void PermanentDrawerSheet-afqeVBk(Modifier modifier, Shape drawerShape, long drawerContainerColor, long drawerContentColor, float drawerTonalElevation, WindowInsets windowInsets, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i10) {
        String string-2EP1pXo;
        int windowInsets2;
        int defaultsInvalid;
        int iNSTANCE;
        int permanentDrawerElevation-D9Ej5fM;
        Object $composer2;
        int $dirty;
        Object $dirty2;
        long l4;
        Object anon;
        Object obj2;
        int i4;
        long l3;
        boolean traceInProgress;
        Object str;
        int i3;
        long standardContainerColor;
        float f2;
        Object obj4;
        int changed3;
        int i8;
        int changed2;
        Object rememberedValue;
        long contentColorFor-ek8zF_U;
        int windowInsets3;
        Object obj3;
        float semantics$default;
        int i2;
        Object obj;
        int changed;
        Object obj5;
        int i;
        int i7;
        long l2;
        float f;
        Composer composer2;
        Composer composer;
        int i5;
        int i6;
        long l;
        int obj35;
        final int i51 = obj36;
        Composer restartGroup = i10.startRestartGroup(-1733353241);
        ComposerKt.sourceInformation(restartGroup, "C(PermanentDrawerSheet)P(5,3,1:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.unit.Dp,6)734@30666L22,735@30722L37,737@30881L12,740@30972L33,744@31114L30,741@31010L266:NavigationDrawer.kt#uh7d8r");
        $dirty = obj36;
        int i17 = obj37 & 1;
        if (i17 != 0) {
            $dirty |= 6;
            obj2 = modifier;
        } else {
            if (i51 & 6 == 0) {
                i4 = restartGroup.changed(modifier) ? 4 : 2;
                $dirty |= i4;
            } else {
                obj2 = modifier;
            }
        }
        int i28 = obj37 & 2;
        if (i28 != 0) {
            $dirty |= 48;
            str = drawerShape;
        } else {
            if (i51 & 48 == 0) {
                i3 = restartGroup.changed(drawerShape) ? 32 : 16;
                $dirty |= i3;
            } else {
                str = drawerShape;
            }
        }
        if (i51 & 384 == 0) {
            if (obj37 & 4 == 0) {
                changed3 = restartGroup.changed(drawerContainerColor) ? 256 : 128;
            } else {
                standardContainerColor = drawerContainerColor;
            }
            $dirty |= changed3;
        } else {
            standardContainerColor = drawerContainerColor;
        }
        if (i51 & 3072 == 0) {
            if (obj37 & 8 == 0) {
                i8 = restartGroup.changed(drawerTonalElevation) ? 2048 : 1024;
            } else {
                contentColorFor-ek8zF_U = drawerTonalElevation;
            }
            $dirty |= i8;
        } else {
            contentColorFor-ek8zF_U = drawerTonalElevation;
        }
        rememberedValue = obj37 & 16;
        if (rememberedValue != 0) {
            $dirty |= 24576;
            semantics$default = content;
        } else {
            if (i51 & 24576 == 0) {
                i2 = restartGroup.changed(content) ? 16384 : 8192;
                $dirty |= i2;
            } else {
                semantics$default = content;
            }
        }
        if (i54 &= i51 == 0) {
            if (obj37 & 32 == 0) {
                changed = restartGroup.changed($composer) ? 131072 : 65536;
            } else {
                obj = $composer;
            }
            $dirty |= changed;
        } else {
            obj = $composer;
        }
        i = 1572864;
        if (obj37 & 64 != 0) {
            $dirty |= i;
            obj5 = $changed;
        } else {
            if (i51 & i == 0) {
                i = restartGroup.changedInstance($changed) ? 1048576 : 524288;
                $dirty |= i;
            } else {
                obj5 = $changed;
            }
        }
        if ($dirty & i7 == 599186) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                i7 = -458753;
                int i19 = 6;
                if (i51 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i17 != 0) {
                            obj2 = defaultsInvalid;
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
                            $dirty &= i7;
                            obj = str;
                            obj5 = standardContainerColor;
                            l2 = contentColorFor-ek8zF_U;
                            f = semantics$default;
                            obj3 = windowInsets4;
                            windowInsets2 = -1733353241;
                        } else {
                            obj5 = standardContainerColor;
                            l2 = contentColorFor-ek8zF_U;
                            f = semantics$default;
                            obj3 = obj;
                            windowInsets2 = -1733353241;
                            obj = str;
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
                            obj5 = standardContainerColor;
                            l2 = contentColorFor-ek8zF_U;
                            f = semantics$default;
                            obj3 = obj;
                            windowInsets2 = -1733353241;
                            obj = str;
                        } else {
                            obj5 = standardContainerColor;
                            l2 = contentColorFor-ek8zF_U;
                            f = semantics$default;
                            obj3 = obj;
                            windowInsets2 = -1733353241;
                            obj = str;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(windowInsets2, $dirty, -1, "androidx.compose.material3.PermanentDrawerSheet (NavigationDrawer.kt:739)");
                }
                androidx.compose.material3.internal.Strings.Companion companion = Strings.Companion;
                int i29 = 0;
                int i30 = 0;
                string-2EP1pXo = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(R.string.navigation_menu), restartGroup, i30);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 391082081, "CC(remember):NavigationDrawer.kt#9igjgp");
                Composer composer3 = restartGroup;
                int i50 = 0;
                rememberedValue = composer3.rememberedValue();
                int i52 = 0;
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
                NavigationDrawerKt.DrawerSheet-7zSek6w(0, obj3, SemanticsModifierKt.semantics$default(obj2, i30, (Function1)anon, 1, 0), obj, obj5, i7, l2, obj18, f, $changed, restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer2 = obj2;
                obj4 = obj3;
                l4 = obj5;
                l3 = l2;
                f2 = f;
                windowInsets3 = $dirty;
                $dirty2 = obj;
            } else {
                restartGroup.skipToGroupEnd();
                windowInsets3 = $dirty;
                $dirty2 = str;
                l3 = l;
                composer = restartGroup;
                $composer2 = obj2;
                l4 = standardContainerColor;
                f2 = semantics$default;
                obj4 = obj;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            string-2EP1pXo = new NavigationDrawerKt.PermanentDrawerSheet.2($composer2, $dirty2, l4, obj2, l3, str, f2, obj4, $changed, i51, obj37);
            endRestartGroup.updateScope((Function2)string-2EP1pXo);
        }
    }

    public static final void PermanentNavigationDrawer(Function2<? super Composer, ? super Integer, Unit> drawerContent, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i6) {
        int traceInProgress;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv;
        Object materialized$iv$iv;
        int $dirty2;
        Object obj;
        int $dirty;
        Object modifier4;
        boolean $i$f$Box;
        int i3;
        int i8;
        int i5;
        boolean traceInProgress2;
        Composer composer2;
        Object valueOf2;
        Object maybeCachedBoxMeasurePolicy;
        Object str;
        Composer composer;
        Integer valueOf;
        int i7;
        int i;
        int start;
        androidx.compose.ui.Alignment.Vertical top;
        androidx.compose.ui.layout.MeasurePolicy rowMeasurePolicy;
        int i18;
        int i2;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap2;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap;
        int currentCompositeKeyHash;
        Object obj2;
        int i21;
        Modifier modifier2;
        Function0 function02;
        int i12;
        int i4;
        int i19;
        int i16;
        int i13;
        int i15;
        RowScopeInstance rowScopeInstance;
        Composer $composer2;
        int i10;
        Modifier modifier3;
        Composer composer6;
        int i17;
        int i22;
        int i9;
        int i20;
        Alignment alignment;
        int i23;
        Composer composer5;
        int i11;
        Function0 function0;
        int i14;
        BoxScopeInstance boxScopeInstance;
        int propagateMinConstraints$iv;
        Composer composer4;
        Modifier modifier5;
        Composer composer3;
        int obj48;
        androidx.compose.ui.Modifier.Companion obj50;
        materialized$iv$iv = drawerContent;
        final Object obj3 = content;
        i3 = $changed;
        traceInProgress = -276843608;
        maybeCachedBoxMeasurePolicy = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(maybeCachedBoxMeasurePolicy, "C(PermanentNavigationDrawer)P(1,2)532@21415L85:NavigationDrawer.kt#uh7d8r");
        $dirty2 = $changed;
        if (i6 & 1 != 0) {
            $dirty2 |= 6;
        } else {
            if (i3 & 6 == 0) {
                i8 = maybeCachedBoxMeasurePolicy.changedInstance(materialized$iv$iv) ? 4 : 2;
                $dirty2 |= i8;
            }
        }
        i5 = i6 & 2;
        if (i5 != 0) {
            $dirty2 |= 48;
            str = modifier;
        } else {
            if (i3 & 48 == 0) {
                i7 = maybeCachedBoxMeasurePolicy.changed(modifier) ? 32 : 16;
                $dirty2 |= i7;
            } else {
                str = modifier;
            }
        }
        if (i6 & 4 != 0) {
            $dirty2 |= 384;
        } else {
            if (i3 & 384 == 0) {
                i = maybeCachedBoxMeasurePolicy.changedInstance(obj3) ? 256 : 128;
                $dirty2 |= i;
            }
        }
        int i50 = $dirty2;
        if (i50 & 147 == 146) {
            if (!maybeCachedBoxMeasurePolicy.getSkipping()) {
                if (i5 != 0) {
                    modifier4 = Modifier.Companion;
                } else {
                    modifier4 = str;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, i50, -1, "androidx.compose.material3.PermanentNavigationDrawer (NavigationDrawer.kt:531)");
                }
                Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(modifier4, 0, 1, 0);
                int i40 = 0;
                valueOf = 0;
                ComposerKt.sourceInformationMarkerStart(maybeCachedBoxMeasurePolicy, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                i2 = 0;
                String str6 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                ComposerKt.sourceInformationMarkerStart(maybeCachedBoxMeasurePolicy, -1323940314, str6);
                int i59 = 0;
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(maybeCachedBoxMeasurePolicy, i59);
                obj50 = i59;
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(maybeCachedBoxMeasurePolicy, fillMaxSize$default);
                modifier2 = fillMaxSize$default;
                Function0 function03 = constructor;
                i21 = 0;
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
                    i10 = valueOf;
                    if (!Intrinsics.areEqual(composer9.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer9.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer = composer9;
                    }
                } else {
                    $composer2 = maybeCachedBoxMeasurePolicy;
                    i10 = valueOf;
                }
                Updater.set-impl(constructor-impl, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                valueOf2 = $composer2;
                i19 = i28;
                ComposerKt.sourceInformationMarkerStart(valueOf2, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                i49 |= 6;
                Composer composer8 = valueOf2;
                i15 = 0;
                rowScopeInstance = iNSTANCE;
                modifier3 = materializeModifier2;
                ComposerKt.sourceInformationMarkerStart(valueOf2, -882916661, "C533@21453L15,534@21477L17:NavigationDrawer.kt#uh7d8r");
                materialized$iv$iv.invoke(valueOf2, Integer.valueOf(i50 & 14));
                i16 = i30;
                ComposerKt.sourceInformationMarkerStart(valueOf2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                androidx.compose.ui.Modifier.Companion companion = Modifier.Companion;
                Alignment topStart = Alignment.Companion.getTopStart();
                i17 = i38;
                $i$f$Box = 0;
                i22 = i44;
                i20 = 0;
                alignment = topStart;
                ComposerKt.sourceInformationMarkerStart(valueOf2, -1323940314, str6);
                obj48 = currentCompositeKeyHash2;
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(valueOf2, (Modifier)companion);
                obj50 = companion;
                Function0 function04 = constructor2;
                i23 = 0;
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
                    composer4 = valueOf2;
                    if (!Intrinsics.areEqual(composer10.rememberedValue(), Integer.valueOf(obj48))) {
                        composer10.updateRememberedValue(Integer.valueOf(obj48));
                        constructor-impl2.apply(Integer.valueOf(obj48), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer2 = composer10;
                    }
                } else {
                    propagateMinConstraints$iv = $i$f$Box;
                    composer4 = valueOf2;
                }
                Updater.set-impl(constructor-impl2, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                Composer composer7 = composer4;
                i3 = 0;
                i4 = i34;
                ComposerKt.sourceInformationMarkerStart(composer7, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                i43 |= 6;
                composer5 = composer7;
                i14 = 0;
                boxScopeInstance = iNSTANCE2;
                modifier5 = materializeModifier;
                ComposerKt.sourceInformationMarkerStart(composer7, -1559720052, "C534@21483L9:NavigationDrawer.kt#uh7d8r");
                obj3.invoke(composer7, Integer.valueOf(i35 &= 14));
                ComposerKt.sourceInformationMarkerEnd(composer7);
                ComposerKt.sourceInformationMarkerEnd(composer7);
                composer4.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer4);
                ComposerKt.sourceInformationMarkerEnd(composer4);
                ComposerKt.sourceInformationMarkerEnd(composer4);
                ComposerKt.sourceInformationMarkerEnd(composer4);
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
            traceInProgress = new NavigationDrawerKt.PermanentNavigationDrawer.2(drawerContent, obj, obj3, $changed, i6);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    private static final void Scrim-Bx497Mc(boolean open, Function0<Unit> onClose, Function0<Float> fraction, long color, Composer $composer, int $changed) {
        Object closeDrawer;
        boolean traceInProgress2;
        Object anon2;
        Modifier companion;
        int $dirty;
        int i;
        int i12;
        int i5;
        int i4;
        int skipping;
        boolean traceInProgress;
        int pointerInput;
        Object anon;
        int i3;
        int i9;
        int i2;
        int i7;
        Composer composer;
        int i10;
        int rememberedValue2;
        int empty;
        int i8;
        Composer composer2;
        Object rememberedValue;
        Object companion2;
        int i6;
        int companion3;
        int i11;
        Composer.Companion companion4;
        companion = open;
        final Object obj = onClose;
        final Object obj2 = fraction;
        final long l = color;
        final int i13 = obj27;
        traceInProgress2 = 2106487387;
        Composer restartGroup = $changed.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(Scrim)P(3,2,1,0:c#ui.graphics.Color)1136@46594L30,1151@47092L39,1151@47041L90:NavigationDrawer.kt#uh7d8r");
        if (i13 & 6 == 0) {
            i = restartGroup.changed(companion) ? 4 : 2;
            $dirty |= i;
        }
        i3 = 32;
        if (i13 & 48 == 0) {
            i12 = restartGroup.changedInstance(obj) ? i3 : 16;
            $dirty |= i12;
        }
        if (i13 & 384 == 0) {
            i5 = restartGroup.changedInstance(obj2) ? 256 : 128;
            $dirty |= i5;
        }
        if (i13 & 3072 == 0) {
            i4 = restartGroup.changed(l) ? 2048 : 1024;
            $dirty |= i4;
        }
        if ($dirty & 1171 == 1170) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty, -1, "androidx.compose.material3.Scrim (NavigationDrawer.kt:1135)");
                }
                androidx.compose.material3.internal.Strings.Companion companion5 = Strings.Companion;
                int i14 = 0;
                String string-2EP1pXo = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(R.string.close_drawer), restartGroup, 0);
                restartGroup.startReplaceGroup(-1784754787);
                ComposerKt.sourceInformation(restartGroup, "1139@46712L35,1140@46800L187");
                String str3 = "CC(remember):NavigationDrawer.kt#9igjgp";
                if (companion) {
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1784753370, str3);
                    i2 = $dirty & 112 == i3 ? 1 : 0;
                    Composer composer3 = restartGroup;
                    companion3 = 0;
                    Object rememberedValue3 = composer3.rememberedValue();
                    i11 = 0;
                    if (i2 == 0) {
                        if (rememberedValue3 == Composer.Companion.getEmpty()) {
                            int i31 = 0;
                            anon = new NavigationDrawerKt.Scrim.dismissDrawer.1.1(obj, 0);
                            composer3.updateRememberedValue((Function2)anon);
                        } else {
                            anon = rememberedValue3;
                            composer2 = composer3;
                        }
                    } else {
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1784750402, str3);
                    i7 = $dirty & 112 == 32 ? 1 : 0;
                    composer = restartGroup;
                    i10 = 0;
                    rememberedValue = composer.rememberedValue();
                    i6 = 0;
                    if (changed3 |= i7 == 0) {
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            empty = 0;
                            anon2 = new NavigationDrawerKt.Scrim.dismissDrawer.2.1(string-2EP1pXo, obj);
                            composer.updateRememberedValue((Function1)anon2);
                        } else {
                            anon2 = rememberedValue;
                        }
                    } else {
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    companion = SemanticsModifierKt.semantics(SuspendingPointerInputFilterKt.pointerInput((Modifier)Modifier.Companion, obj, (Function2)anon), true, (Function1)anon2);
                } else {
                    companion = Modifier.Companion;
                }
                restartGroup.endReplaceGroup();
                int i24 = 1;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1784741206, str3);
                i9 = $dirty & 7168 == 2048 ? i24 : 0;
                rememberedValue = $dirty & 896 == 256 ? i24 : 0;
                composer = restartGroup;
                i10 = 0;
                rememberedValue2 = composer.rememberedValue();
                i8 = 0;
                if (i9 |= rememberedValue == 0) {
                    if (rememberedValue2 == Composer.Companion.getEmpty()) {
                        rememberedValue = 0;
                        companion2 = string-2EP1pXo;
                        closeDrawer = new NavigationDrawerKt.Scrim.1.1(l, obj5, obj2);
                        composer.updateRememberedValue((Function1)closeDrawer);
                    } else {
                        companion2 = string-2EP1pXo;
                        closeDrawer = rememberedValue2;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                CanvasKt.Canvas(SizeKt.fillMaxSize$default((Modifier)Modifier.Companion, 0, i24, 0).then(companion), (Function1)closeDrawer, restartGroup, 0);
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
            traceInProgress2 = new NavigationDrawerKt.Scrim.2(open, obj, obj2, l, obj5, i13);
            endRestartGroup.updateScope((Function2)traceInProgress2);
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
        int i2;
        int i;
        float f;
        float width-impl = Size.getWidth-impl($this$calculatePredictiveBackScaleX.getSize-NH-jbRc());
        if (!Float.isNaN(width-impl)) {
            naN = Float.compare(width-impl, i3) == 0 ? i : 0;
            if (naN != 0) {
            } else {
                if (drawerPredictiveBackState.getSwipeEdgeMatchesDrawer()) {
                } else {
                    i = -1;
                }
                i2 += naN;
            }
        } else {
        }
        return i2;
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
        int changed;
        int i;
        int changed2;
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
