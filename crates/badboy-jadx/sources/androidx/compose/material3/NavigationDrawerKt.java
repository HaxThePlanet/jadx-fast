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
        Object obj6;
        Object obj;
        int traceInProgress;
        int windowInsets2;
        boolean traceInProgress2;
        int defaultsInvalid;
        int iNSTANCE;
        int dismissibleDrawerElevation-D9Ej5fM;
        int $dirty;
        Object $dirty2;
        int i7;
        int str;
        Object obj2;
        Object obj7;
        long l3;
        int i6;
        int i5;
        Object obj8;
        long l2;
        int i2;
        long standardContainerColor;
        float f3;
        int changed;
        long contentColorFor-ek8zF_U;
        WindowInsets windowInsets3;
        int i4;
        int changed2;
        int i9;
        float f;
        int i8;
        int i3;
        int changed3;
        int i;
        androidx.compose.material3.NavigationDrawerKt.DismissibleDrawerSheet.2 anon;
        Object obj3;
        Object obj4;
        Object obj9;
        long l;
        long l4;
        float f2;
        Object obj5;
        final Object obj10 = drawerState;
        final int i29 = obj38;
        final int i30 = obj39;
        final Composer restartGroup = i11.startRestartGroup(1473549901);
        ComposerKt.sourceInformation(restartGroup, "C(DismissibleDrawerSheet)P(4,6,3,1:c#ui.graphics.Color,2:c#ui.graphics.Color,5:c#ui.unit.Dp,7)694@28867L22,695@28923L37,697@29084L12,700@29195L299,700@29154L340:NavigationDrawer.kt#uh7d8r");
        $dirty = obj38;
        if (i30 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (i29 & 6 == 0) {
                i7 = restartGroup.changed(obj10) ? 4 : 2;
                $dirty |= i7;
            }
        }
        int i17 = i30 & 2;
        if (i17 != 0) {
            $dirty |= 48;
            obj7 = modifier;
        } else {
            if (i29 & 48 == 0) {
                i6 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i6;
            } else {
                obj7 = modifier;
            }
        }
        i5 = i30 & 4;
        if (i5 != 0) {
            $dirty |= 384;
            obj8 = drawerShape;
        } else {
            if (i29 & 384 == 0) {
                i2 = restartGroup.changed(drawerShape) ? 256 : 128;
                $dirty |= i2;
            } else {
                obj8 = drawerShape;
            }
        }
        if (i29 & 3072 == 0) {
            if (i30 & 8 == 0) {
                changed = restartGroup.changed(drawerContainerColor) ? 2048 : 1024;
            } else {
                standardContainerColor = drawerContainerColor;
            }
            $dirty |= changed;
        } else {
            standardContainerColor = drawerContainerColor;
        }
        if (i29 & 24576 == 0) {
            if (i30 & 16 == 0) {
                changed2 = restartGroup.changed(drawerTonalElevation) ? 16384 : 8192;
            } else {
                contentColorFor-ek8zF_U = drawerTonalElevation;
            }
            $dirty |= changed2;
        } else {
            contentColorFor-ek8zF_U = drawerTonalElevation;
        }
        int i31 = i30 & 32;
        int i32 = 196608;
        if (i31 != 0) {
            $dirty |= i32;
            f = content;
        } else {
            if (i32 &= i29 == 0) {
                i8 = restartGroup.changed(content) ? 131072 : 65536;
                $dirty |= i8;
            } else {
                f = content;
            }
        }
        if (i29 & i34 == 0) {
            if (i30 & 64 == 0) {
                changed3 = restartGroup.changed($composer) ? 1048576 : 524288;
            } else {
                obj6 = $composer;
            }
            $dirty |= changed3;
        } else {
            obj6 = $composer;
        }
        i = 12582912;
        if (i30 & 128 != 0) {
            $dirty |= i;
            obj = $changed;
        } else {
            if (i29 & i == 0) {
                i = restartGroup.changedInstance($changed) ? 8388608 : 4194304;
                $dirty |= i;
            } else {
                obj = $changed;
            }
        }
        if ($dirty & anon == 4793490) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                str = -3670017;
                int i35 = -57345;
                if (i29 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i17 != 0) {
                            obj7 = defaultsInvalid;
                        }
                        if (i5 != 0) {
                            obj8 = defaultsInvalid;
                        }
                        i5 = 6;
                        if (i30 & 8 != 0) {
                            standardContainerColor = DrawerDefaults.INSTANCE.getStandardContainerColor(restartGroup, i5);
                            $dirty &= -7169;
                        }
                        if (i30 & 16 != 0) {
                            contentColorFor-ek8zF_U = ColorSchemeKt.contentColorFor-ek8zF_U(standardContainerColor, obj8, restartGroup);
                            $dirty &= i35;
                        }
                        if (i31 != 0) {
                            f = dismissibleDrawerElevation-D9Ej5fM;
                        }
                        if (i30 & 64 != 0) {
                            $dirty &= str;
                            obj3 = windowInsets2;
                            obj4 = obj7;
                            obj9 = obj8;
                            l = standardContainerColor;
                            l4 = contentColorFor-ek8zF_U;
                            f2 = f;
                        } else {
                            obj3 = $composer;
                            obj4 = obj7;
                            obj9 = obj8;
                            l = standardContainerColor;
                            l4 = contentColorFor-ek8zF_U;
                            f2 = f;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i30 & 8 != 0) {
                            $dirty &= -7169;
                        }
                        if (i30 & 16 != 0) {
                            $dirty &= i35;
                        }
                        if (i30 & 64 != 0) {
                            obj3 = $composer;
                            $dirty = windowInsets2;
                            obj4 = obj7;
                            obj9 = obj8;
                            l = standardContainerColor;
                            l4 = contentColorFor-ek8zF_U;
                            f2 = f;
                        } else {
                            obj3 = $composer;
                            obj4 = obj7;
                            obj9 = obj8;
                            l = standardContainerColor;
                            l4 = contentColorFor-ek8zF_U;
                            f2 = f;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1473549901, $dirty, -1, "androidx.compose.material3.DismissibleDrawerSheet (NavigationDrawer.kt:699)");
                }
                anon = new NavigationDrawerKt.DismissibleDrawerSheet.2(obj3, obj4, obj9, l, obj22, l4, obj24, f2, $changed);
                NavigationDrawer_androidKt.DrawerPredictiveBackHandler(obj10, (Function3)ComposableLambdaKt.rememberComposableLambda(-807955710, true, anon, restartGroup, 54), restartGroup, i20 |= 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i9 = $dirty;
                windowInsets3 = obj3;
                $dirty2 = obj4;
                obj2 = obj9;
                l3 = l;
                l2 = l4;
                f3 = f2;
            } else {
                restartGroup.skipToGroupEnd();
                i9 = $dirty;
                $dirty2 = obj7;
                obj2 = obj8;
                l3 = standardContainerColor;
                l2 = contentColorFor-ek8zF_U;
                f3 = f;
                windowInsets3 = $composer;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new NavigationDrawerKt.DismissibleDrawerSheet.3(obj10, $dirty2, obj2, l3, i5, l2, standardContainerColor, f3, windowInsets3, $changed, i29, i30);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void DismissibleDrawerSheet-afqeVBk(Modifier modifier, Shape drawerShape, long drawerContainerColor, long drawerContentColor, float drawerTonalElevation, WindowInsets windowInsets, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i10) {
        boolean traceInProgress;
        int windowInsets3;
        int defaultsInvalid;
        int iNSTANCE;
        int dismissibleDrawerElevation-D9Ej5fM;
        Object $composer2;
        int $dirty;
        Object $dirty2;
        long l2;
        Object obj2;
        boolean traceInProgress2;
        int i9;
        long l4;
        int str;
        Object obj5;
        int i6;
        long standardContainerColor;
        float f;
        Object obj4;
        int changed3;
        int i4;
        int changed2;
        int i7;
        long contentColorFor-ek8zF_U;
        int windowInsets2;
        Object obj;
        float drawerTonalElevation2;
        int i3;
        Object obj6;
        int changed;
        Object obj3;
        int i2;
        int i;
        long l3;
        float f2;
        Composer composer2;
        Composer composer;
        int i8;
        int i5;
        long l;
        final int i48 = obj36;
        Composer restartGroup = i10.startRestartGroup(-588600583);
        ComposerKt.sourceInformation(restartGroup, "C(DismissibleDrawerSheet)P(5,3,1:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.unit.Dp,6)650@26887L22,651@26943L37,653@27104L12,656@27174L225:NavigationDrawer.kt#uh7d8r");
        $dirty = obj36;
        int i26 = obj37 & 1;
        if (i26 != 0) {
            $dirty |= 6;
            obj2 = modifier;
        } else {
            if (i48 & 6 == 0) {
                i9 = restartGroup.changed(modifier) ? 4 : 2;
                $dirty |= i9;
            } else {
                obj2 = modifier;
            }
        }
        str = obj37 & 2;
        if (str != null) {
            $dirty |= 48;
            obj5 = drawerShape;
        } else {
            if (i48 & 48 == 0) {
                i6 = restartGroup.changed(drawerShape) ? 32 : 16;
                $dirty |= i6;
            } else {
                obj5 = drawerShape;
            }
        }
        if (i48 & 384 == 0) {
            if (obj37 & 4 == 0) {
                changed3 = restartGroup.changed(drawerContainerColor) ? 256 : 128;
            } else {
                standardContainerColor = drawerContainerColor;
            }
            $dirty |= changed3;
        } else {
            standardContainerColor = drawerContainerColor;
        }
        if (i48 & 3072 == 0) {
            if (obj37 & 8 == 0) {
                i4 = restartGroup.changed(drawerTonalElevation) ? 2048 : 1024;
            } else {
                contentColorFor-ek8zF_U = drawerTonalElevation;
            }
            $dirty |= i4;
        } else {
            contentColorFor-ek8zF_U = drawerTonalElevation;
        }
        i7 = obj37 & 16;
        if (i7 != 0) {
            $dirty |= 24576;
            drawerTonalElevation2 = content;
        } else {
            if (i48 & 24576 == 0) {
                i3 = restartGroup.changed(content) ? 16384 : 8192;
                $dirty |= i3;
            } else {
                drawerTonalElevation2 = content;
            }
        }
        if (i50 &= i48 == 0) {
            if (obj37 & 32 == 0) {
                changed = restartGroup.changed($composer) ? 131072 : 65536;
            } else {
                obj6 = $composer;
            }
            $dirty |= changed;
        } else {
            obj6 = $composer;
        }
        i2 = 1572864;
        if (obj37 & 64 != 0) {
            $dirty |= i2;
            obj3 = $changed;
        } else {
            if (i48 & i2 == 0) {
                i2 = restartGroup.changedInstance($changed) ? 1048576 : 524288;
                $dirty |= i2;
            } else {
                obj3 = $changed;
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
                            obj2 = defaultsInvalid;
                        }
                        if (str != null) {
                            obj5 = defaultsInvalid;
                        }
                        if (obj37 & 4 != 0) {
                            standardContainerColor = DrawerDefaults.INSTANCE.getStandardContainerColor(restartGroup, i28);
                            $dirty &= -897;
                        }
                        if (obj37 & 8 != 0) {
                            contentColorFor-ek8zF_U = ColorSchemeKt.contentColorFor-ek8zF_U(standardContainerColor, obj8, restartGroup);
                            $dirty &= -7169;
                        }
                        if (i7 != 0) {
                            drawerTonalElevation2 = dismissibleDrawerElevation-D9Ej5fM;
                        }
                        if (obj37 & 32 != 0) {
                            $dirty &= i;
                            obj6 = obj5;
                            obj3 = standardContainerColor;
                            l3 = contentColorFor-ek8zF_U;
                            f2 = drawerTonalElevation2;
                            obj = windowInsets4;
                            drawerTonalElevation2 = obj2;
                            windowInsets3 = -588600583;
                        } else {
                            obj3 = standardContainerColor;
                            l3 = contentColorFor-ek8zF_U;
                            f2 = drawerTonalElevation2;
                            obj = obj6;
                            windowInsets3 = -588600583;
                            drawerTonalElevation2 = obj2;
                            obj6 = obj5;
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
                            obj3 = standardContainerColor;
                            l3 = contentColorFor-ek8zF_U;
                            f2 = drawerTonalElevation2;
                            obj = obj6;
                            windowInsets3 = -588600583;
                            drawerTonalElevation2 = obj2;
                            obj6 = obj5;
                        } else {
                            obj3 = standardContainerColor;
                            l3 = contentColorFor-ek8zF_U;
                            f2 = drawerTonalElevation2;
                            obj = obj6;
                            windowInsets3 = -588600583;
                            drawerTonalElevation2 = obj2;
                            obj6 = obj5;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(windowInsets3, $dirty, -1, "androidx.compose.material3.DismissibleDrawerSheet (NavigationDrawer.kt:655)");
                }
                NavigationDrawerKt.DrawerSheet-7zSek6w(0, obj, drawerTonalElevation2, obj6, obj3, i, l3, obj18, f2, $changed, restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj4 = obj;
                $composer2 = drawerTonalElevation2;
                l2 = obj3;
                l4 = l3;
                f = f2;
                windowInsets2 = $dirty;
                $dirty2 = obj6;
            } else {
                restartGroup.skipToGroupEnd();
                windowInsets2 = $dirty;
                $dirty2 = obj5;
                l4 = l;
                composer = restartGroup;
                $composer2 = obj2;
                l2 = standardContainerColor;
                f = drawerTonalElevation2;
                obj4 = obj6;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new NavigationDrawerKt.DismissibleDrawerSheet.1($composer2, $dirty2, l2, obj2, l4, obj5, f, obj4, $changed, i48, obj37);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void DismissibleNavigationDrawer(Function2<? super Composer, ? super Integer, Unit> drawerContent, Modifier modifier, androidx.compose.material3.DrawerState drawerState, boolean gesturesEnabled, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i8) {
        boolean traceInProgress2;
        Integer currentCompositionLocalMap4;
        Function0 factory$iv$iv$iv;
        Object obj6;
        Function0 factory$iv$iv$iv2;
        int $dirty;
        Object $dirty2;
        Object it$iv;
        Integer maybeCachedBoxMeasurePolicy2;
        boolean valueOf;
        int i24;
        Object obj5;
        Object modifier4;
        boolean traceInProgress;
        int changed;
        int i10;
        int invalid$iv2;
        Composer composer3;
        Composer composer2;
        Object valueOf3;
        Object currentCompositionLocalMap;
        boolean z2;
        Object mutableStateOf$default;
        Object compositionCoroutineScope;
        Object iNSTANCE;
        int i25;
        Object compositionScopedCoroutineScopeCanceller;
        Object rememberDrawerState;
        int i37;
        Function0 factory$iv$iv$iv3;
        int i17;
        Object it$iv2;
        Composer composer7;
        int changed4;
        boolean changed3;
        int i19;
        Object obj3;
        int valueOf2;
        int empty;
        Integer currentCompositionLocalMap2;
        int changed2;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap3;
        int i16;
        boolean maybeCachedBoxMeasurePolicy3;
        Composer composer5;
        int i42;
        Function0 factory$iv$iv;
        int i18;
        Object maybeCachedBoxMeasurePolicy;
        int i7;
        int i32;
        int skipping;
        int defaultsInvalid;
        Modifier materializeModifier;
        Object anon2;
        int materialized$iv$iv;
        int i30;
        Object empty2;
        Object obj4;
        int i13;
        Composer.Companion companion2;
        int i6;
        Object $i$a$RememberCoroutineScopeEffectsKt$rememberCoroutineScope$1;
        boolean z;
        int i39;
        int i34;
        int i41;
        int i12;
        int i9;
        int i5;
        int i11;
        int currentCompositeKeyHash2;
        Alignment alignment;
        int i29;
        Modifier modifier2;
        Function0 function03;
        int i2;
        int i35;
        Modifier modifier3;
        int i22;
        BoxScopeInstance iNSTANCE2;
        int i15;
        int i14;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy;
        int i20;
        int i;
        Composer composer8;
        int i26;
        Object obj7;
        int currentCompositeKeyHash;
        int companion;
        Object obj;
        Modifier materialized$iv$iv2;
        int i31;
        androidx.compose.ui.Modifier.Companion companion4;
        Composer composer9;
        int i3;
        int i40;
        int i4;
        Function0 function0;
        int i38;
        Function0 function02;
        Object obj2;
        int companion5;
        androidx.compose.runtime.CompositionLocalMap localMap$iv;
        androidx.compose.material3.NavigationDrawerKt.DismissibleNavigationDrawer.2.2.1 anon;
        Composer composer4;
        int invalid$iv;
        int i27;
        int $i$f$Box;
        androidx.compose.ui.Modifier.Companion companion3;
        Function0 function04;
        int i33;
        int i21;
        Composer composer6;
        kotlinx.coroutines.CoroutineScope coroutineScope;
        int i36;
        int i23;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy$iv;
        androidx.compose.runtime.CompositionLocalMap map;
        Composer composer;
        int i28;
        int obj76;
        String obj77;
        Object obj78;
        Composer obj80;
        Object obj8 = drawerContent;
        iNSTANCE = content;
        i25 = $changed;
        traceInProgress2 = 398812198;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(DismissibleNavigationDrawer)P(1,4,2,3)434@17575L39,438@17723L34,439@17789L7,440@17812L33,440@17801L44,442@17863L24,443@17913L33,445@17985L7,446@18020L2358:NavigationDrawer.kt#uh7d8r");
        $dirty = $changed;
        int i69 = 2;
        if (i8 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (i25 & 6 == 0) {
                i24 = restartGroup.changedInstance(obj8) ? 4 : i69;
                $dirty |= i24;
            }
        }
        int i62 = i8 & 2;
        if (i62 != 0) {
            $dirty |= 48;
            rememberDrawerState = modifier;
        } else {
            if (i25 & 48 == 0) {
                i19 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i19;
            } else {
                rememberDrawerState = modifier;
            }
        }
        if (i25 & 384 == 0) {
            if (i8 & 4 == 0) {
                changed2 = restartGroup.changed(drawerState) ? 256 : 128;
            } else {
                obj3 = drawerState;
            }
            $dirty |= changed2;
        } else {
            obj3 = drawerState;
        }
        currentCompositionLocalMap3 = i8 & 8;
        if (currentCompositionLocalMap3 != 0) {
            $dirty |= 3072;
            maybeCachedBoxMeasurePolicy3 = gesturesEnabled;
        } else {
            if (i25 & 3072 == 0) {
                i7 = restartGroup.changed(gesturesEnabled) ? 2048 : 1024;
                $dirty |= i7;
            } else {
                maybeCachedBoxMeasurePolicy3 = gesturesEnabled;
            }
        }
        if (i8 & 16 != 0) {
            $dirty |= 24576;
        } else {
            if (i25 & 24576 == 0) {
                i32 = restartGroup.changedInstance(iNSTANCE) ? 16384 : 8192;
                $dirty |= i32;
            }
        }
        if ($dirty & 9363 == 9362) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i120 = 0;
                int i123 = 6;
                if (i25 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i62 != 0) {
                            modifier4 = Modifier.Companion;
                        } else {
                            modifier4 = rememberDrawerState;
                        }
                        if (i8 & 4 != 0) {
                            $dirty &= -897;
                            obj3 = rememberDrawerState;
                        }
                        if (currentCompositionLocalMap3 != 0) {
                            obj4 = modifier4;
                            z = rememberDrawerState;
                        } else {
                            obj4 = modifier4;
                            z = maybeCachedBoxMeasurePolicy3;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i8 & 4 != 0) {
                            $dirty &= -897;
                        }
                        obj4 = rememberDrawerState;
                        z = maybeCachedBoxMeasurePolicy3;
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
                    empty2 = 0;
                    composer13.updateRememberedValue(SnapshotStateKt.mutableStateOf$default(false, i120, i69, i120));
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
                    if (!restartGroup.changed(obj3)) {
                        i37 = $dirty & 384 == 256 ? 1 : obj76;
                    } else {
                    }
                } else {
                }
                Composer composer15 = restartGroup;
                int i102 = 0;
                Object rememberedValue6 = composer15.rememberedValue();
                int i124 = 0;
                if (i37 |= changed7 == 0) {
                    if (rememberedValue6 == Composer.Companion.getEmpty()) {
                        empty = 0;
                        anon2 = new NavigationDrawerKt.DismissibleNavigationDrawer.1.1(obj3, this_$iv);
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
                    i39 = i72;
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
                i39 = restartGroup.consume((CompositionLocal)CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl ? 1 : 0;
                Modifier anchoredDraggable$default = AnchoredDraggableKt.anchoredDraggable$default(obj4, obj3.getAnchoredDraggableState$material3_release(), Orientation.Horizontal, z, i39, 0, 16, 0);
                int i100 = i92;
                String str7 = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo";
                ComposerKt.sourceInformationMarkerStart(restartGroup, 733328855, str7);
                Alignment topStart3 = Alignment.Companion.getTopStart();
                int i125 = 0;
                maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(topStart3, i125);
                i34 = 0;
                i41 = i93;
                String $changed$iv5 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, $changed$iv5);
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, 0);
                currentCompositionLocalMap2 = restartGroup.getCurrentCompositionLocalMap();
                alignment = topStart3;
                materialized$iv$iv = ComposedModifierKt.materializeModifier(restartGroup, anchoredDraggable$default);
                modifier2 = anchoredDraggable$default;
                Function0 function06 = constructor2;
                i29 = 0;
                i35 = i125;
                String propagateMinConstraints$iv2 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, propagateMinConstraints$iv2);
                if (!applier3 instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                restartGroup.startReusableNode();
                if (restartGroup.getInserting()) {
                    restartGroup.createNode(function06);
                } else {
                    factory$iv$iv$iv3 = function06;
                    restartGroup.useNode();
                }
                function03 = factory$iv$iv$iv3;
                Composer constructor-impl2 = Updater.constructor-impl(restartGroup);
                int i141 = 0;
                Updater.set-impl(constructor-impl2, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i142 = 0;
                Composer composer20 = constructor-impl2;
                int i145 = 0;
                if (!composer20.getInserting()) {
                    localMap$iv$iv = currentCompositionLocalMap2;
                    measurePolicy = maybeCachedBoxMeasurePolicy;
                    if (!Intrinsics.areEqual(composer20.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        composer20.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        constructor-impl2.apply(Integer.valueOf(currentCompositeKeyHash2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer5 = composer20;
                    }
                } else {
                    localMap$iv$iv = currentCompositionLocalMap2;
                    measurePolicy = maybeCachedBoxMeasurePolicy;
                }
                Updater.set-impl(constructor-impl2, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                Composer composer14 = restartGroup;
                i22 = i74;
                String $changed$iv4 = "C73@3429L9:Box.kt#2w3rfo";
                ComposerKt.sourceInformationMarkerStart(composer14, -2146769399, $changed$iv4);
                iNSTANCE2 = BoxScopeInstance.INSTANCE;
                i144 |= 6;
                i20 = 0;
                i26 = i95;
                Composer $i$a$LayoutBoxKt$Box$1$iv2 = composer21;
                ComposerKt.sourceInformationMarkerStart($i$a$LayoutBoxKt$Box$1$iv2, -1218087217, "C477@19117L1255,454@18269L2103:NavigationDrawer.kt#uh7d8r");
                ComposerKt.sourceInformationMarkerStart($i$a$LayoutBoxKt$Box$1$iv2, 99280484, str2);
                if (i87 ^= 384 > 256) {
                    if (!restartGroup.changed(obj3)) {
                        i17 = $dirty & 384 == 256 ? 1 : 0;
                    } else {
                    }
                } else {
                }
                Composer composer17 = $i$a$LayoutBoxKt$Box$1$iv2;
                int i146 = 0;
                it$iv2 = composer17.rememberedValue();
                int i148 = 0;
                if (i17 == 0) {
                    materialized$iv$iv2 = materialized$iv$iv;
                    if (it$iv2 == Composer.Companion.getEmpty()) {
                        materialized$iv$iv = 0;
                        obj = it$iv2;
                        it$iv2 = new NavigationDrawerKt.DismissibleNavigationDrawer.2.2.1(obj3, (MutableState)invalid$iv3);
                        composer17.updateRememberedValue((MeasurePolicy)it$iv2);
                    } else {
                        obj = it$iv2;
                    }
                } else {
                    materialized$iv$iv2 = materialized$iv$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($i$a$LayoutBoxKt$Box$1$iv2);
                i14 = 0;
                ComposerKt.sourceInformationMarkerStart($i$a$LayoutBoxKt$Box$1$iv2, -1323940314, $changed$iv5);
                androidx.compose.ui.Modifier.Companion companion18 = Modifier.Companion;
                obj7 = invalid$iv3;
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($i$a$LayoutBoxKt$Box$1$iv2, 0);
                currentCompositionLocalMap4 = $i$a$LayoutBoxKt$Box$1$iv2.getCurrentCompositionLocalMap();
                companion4 = companion18;
                Function0 function07 = constructor3;
                i31 = 0;
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
                composer9 = $i$a$LayoutBoxKt$Box$1$iv2;
                Composer constructor-impl3 = Updater.constructor-impl(composer9);
                int i149 = 0;
                function0 = factory$iv$iv;
                Updater.set-impl(constructor-impl3, (MeasurePolicy)it$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl3, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i150 = 0;
                Composer composer22 = constructor-impl3;
                companion5 = 0;
                if (!composer22.getInserting()) {
                    localMap$iv = currentCompositionLocalMap4;
                    anon = it$iv2;
                    if (!Intrinsics.areEqual(composer22.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer22.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl3.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer7 = composer22;
                    }
                } else {
                    localMap$iv = currentCompositionLocalMap4;
                    anon = it$iv2;
                }
                Updater.set-impl(constructor-impl3, ComposedModifierKt.materializeModifier($i$a$LayoutBoxKt$Box$1$iv2, (Modifier)companion18), ComposeUiNode.Companion.getSetModifier());
                rememberDrawerState = composer9;
                valueOf2 = 0;
                i40 = i46;
                ComposerKt.sourceInformationMarkerStart(rememberDrawerState, 285475168, "C457@18361L623,456@18317L741,475@19075L17:NavigationDrawer.kt#uh7d8r");
                ComposerKt.sourceInformationMarkerStart(rememberDrawerState, -1376263189, str2);
                if (i115 ^= 384 > 256) {
                    if (!restartGroup.changed(obj3)) {
                        i10 = $dirty & 384 == 256 ? 1 : 0;
                    } else {
                    }
                } else {
                }
                i63 |= changedInstance2;
                Composer composer18 = rememberDrawerState;
                int i135 = 0;
                i4 = $dirty;
                it$iv = composer18.rememberedValue();
                int i151 = 0;
                if (invalid$iv2 == 0) {
                    invalid$iv = invalid$iv2;
                    if (it$iv == Composer.Companion.getEmpty()) {
                        invalid$iv2 = 0;
                        obj2 = it$iv;
                        it$iv = new NavigationDrawerKt.DismissibleNavigationDrawer.2.1.1.1(string-2EP1pXo, obj3, coroutineScope2);
                        composer18.updateRememberedValue((Function1)it$iv);
                    } else {
                        obj2 = it$iv;
                    }
                } else {
                    invalid$iv = invalid$iv2;
                }
                ComposerKt.sourceInformationMarkerEnd(rememberDrawerState);
                obj77 = string-2EP1pXo;
                int i116 = 0;
                Modifier semantics$default = SemanticsModifierKt.semantics$default((Modifier)Modifier.Companion, i116, (Function1)it$iv, 1, 0);
                ComposerKt.sourceInformationMarkerStart(rememberDrawerState, 733328855, str7);
                Alignment topStart = Alignment.Companion.getTopStart();
                int i136 = i61;
                maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(topStart, false);
                int i152 = 0;
                int i153 = i65;
                ComposerKt.sourceInformationMarkerStart(rememberDrawerState, -1323940314, $changed$iv5);
                int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(rememberDrawerState, 0);
                currentCompositionLocalMap = rememberDrawerState.getCurrentCompositionLocalMap();
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
                    factory$iv$iv$iv = function08;
                    rememberDrawerState.useNode();
                }
                function04 = factory$iv$iv$iv;
                Composer constructor-impl = Updater.constructor-impl(rememberDrawerState);
                int i155 = 0;
                coroutineScope = coroutineScope2;
                Updater.set-impl(constructor-impl, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i158 = 0;
                Composer composer24 = constructor-impl;
                int i159 = 0;
                if (!composer24.getInserting()) {
                    measurePolicy$iv = maybeCachedBoxMeasurePolicy2;
                    map = currentCompositionLocalMap;
                    if (!Intrinsics.areEqual(composer24.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                        composer24.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer3 = composer24;
                    }
                } else {
                    measurePolicy$iv = maybeCachedBoxMeasurePolicy2;
                    map = currentCompositionLocalMap;
                }
                Updater.set-impl(constructor-impl, ComposedModifierKt.materializeModifier(rememberDrawerState, semantics$default), ComposeUiNode.Companion.getSetModifier());
                Composer composer11 = rememberDrawerState;
                ComposerKt.sourceInformationMarkerStart(composer11, -2146769399, $changed$iv4);
                BoxScopeInstance iNSTANCE3 = BoxScopeInstance.INSTANCE;
                i157 |= 6;
                i36 = 0;
                i23 = i50;
                i28 = i67;
                Composer $i$a$LayoutBoxKt$Box$1$iv = composer6;
                ComposerKt.sourceInformationMarkerStart($i$a$LayoutBoxKt$Box$1$iv, 590398649, "C473@19025L15:NavigationDrawer.kt#uh7d8r");
                obj8.invoke($i$a$LayoutBoxKt$Box$1$iv, Integer.valueOf(i4 & 14));
                ComposerKt.sourceInformationMarkerEnd($i$a$LayoutBoxKt$Box$1$iv);
                ComposerKt.sourceInformationMarkerEnd(composer11);
                rememberDrawerState.endNode();
                ComposerKt.sourceInformationMarkerEnd(rememberDrawerState);
                ComposerKt.sourceInformationMarkerEnd(rememberDrawerState);
                ComposerKt.sourceInformationMarkerEnd(rememberDrawerState);
                int i52 = propagateMinConstraints$iv;
                valueOf = 0;
                ComposerKt.sourceInformationMarkerStart(rememberDrawerState, 733328855, str7);
                valueOf3 = Modifier.Companion;
                i13 = 0;
                ComposerKt.sourceInformationMarkerStart(rememberDrawerState, -1323940314, $changed$iv5);
                obj76 = currentCompositeKeyHash3;
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(rememberDrawerState, (Modifier)valueOf3);
                Function0 function05 = constructor;
                i5 = 0;
                ComposerKt.sourceInformationMarkerStart(rememberDrawerState, -692256719, propagateMinConstraints$iv2);
                if (!applier2 instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                rememberDrawerState.startReusableNode();
                if (rememberDrawerState.getInserting()) {
                    rememberDrawerState.createNode(function05);
                } else {
                    factory$iv$iv$iv2 = function05;
                    rememberDrawerState.useNode();
                }
                Composer constructor-impl4 = Updater.constructor-impl(rememberDrawerState);
                int i139 = 0;
                function02 = factory$iv$iv$iv2;
                Updater.set-impl(constructor-impl4, BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false), ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl4, rememberDrawerState.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i140 = 0;
                Composer composer23 = constructor-impl4;
                i27 = 0;
                if (!composer23.getInserting()) {
                    $i$f$Box = valueOf;
                    companion3 = valueOf3;
                    if (!Intrinsics.areEqual(composer23.rememberedValue(), Integer.valueOf(obj76))) {
                        composer23.updateRememberedValue(Integer.valueOf(obj76));
                        constructor-impl4.apply(Integer.valueOf(obj76), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer2 = composer23;
                    }
                } else {
                    $i$f$Box = valueOf;
                    companion3 = valueOf3;
                }
                Updater.set-impl(constructor-impl4, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                Composer composer12 = rememberDrawerState;
                int i68 = 0;
                ComposerKt.sourceInformationMarkerStart(composer12, -2146769399, $changed$iv4);
                iNSTANCE = BoxScopeInstance.INSTANCE;
                i128 |= 6;
                obj80 = composer12;
                i11 = 0;
                modifier3 = materializeModifier2;
                i = i60;
                ComposerKt.sourceInformationMarkerStart(composer12, 590454015, "C475@19081L9:NavigationDrawer.kt#uh7d8r");
                content.invoke(composer12, Integer.valueOf(i54 &= 14));
                ComposerKt.sourceInformationMarkerEnd(composer12);
                ComposerKt.sourceInformationMarkerEnd(composer12);
                rememberDrawerState.endNode();
                ComposerKt.sourceInformationMarkerEnd(rememberDrawerState);
                ComposerKt.sourceInformationMarkerEnd(rememberDrawerState);
                ComposerKt.sourceInformationMarkerEnd(rememberDrawerState);
                ComposerKt.sourceInformationMarkerEnd(rememberDrawerState);
                composer9.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer9);
                ComposerKt.sourceInformationMarkerEnd(composer9);
                ComposerKt.sourceInformationMarkerEnd(composer9);
                ComposerKt.sourceInformationMarkerEnd(composer14);
                restartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $dirty2 = obj4;
                z2 = z;
                obj5 = obj3;
            } else {
                restartGroup.skipToGroupEnd();
                i4 = $dirty;
                obj6 = iNSTANCE;
                $dirty2 = rememberDrawerState;
                z2 = maybeCachedBoxMeasurePolicy3;
                obj5 = obj3;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new NavigationDrawerKt.DismissibleNavigationDrawer.3(drawerContent, $dirty2, obj5, z2, obj6, $changed, i8);
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
        int i8;
        int traceInProgress2;
        int defaultsInvalid;
        int iNSTANCE;
        int i;
        int i9;
        boolean traceInProgress;
        int i12;
        int i16;
        Object $composer2;
        int $dirty;
        Object $dirty2;
        int i18;
        int i7;
        int str;
        long l2;
        Object obj2;
        int i10;
        Modifier predictiveBackDrawerContainer;
        long l3;
        Object obj;
        int i2;
        int i6;
        int changed;
        int i15;
        float modifier2;
        long standardContainerColor;
        int i3;
        Object obj3;
        int changed2;
        long i17;
        int i13;
        long drawerContentColor2;
        float f;
        int i4;
        int i19;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        Composer composer;
        int i14;
        int i5;
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
                i18 = restartGroup.changed(obj4) ? 4 : 2;
                $dirty |= i18;
            }
        }
        if (i49 & 2 != 0) {
            $dirty |= 48;
        } else {
            if (i48 & 48 == 0) {
                i7 = restartGroup.changed(obj5) ? 32 : 16;
                $dirty |= i7;
            }
        }
        str = i49 & 4;
        if (str != null) {
            $dirty |= 384;
            obj2 = modifier;
        } else {
            if (i48 & 384 == 0) {
                i10 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty |= i10;
            } else {
                obj2 = modifier;
            }
        }
        int i43 = i49 & 8;
        if (i43 != 0) {
            $dirty |= 3072;
            obj = drawerShape;
        } else {
            if (i48 & 3072 == 0) {
                i2 = restartGroup.changed(drawerShape) ? 2048 : 1024;
                $dirty |= i2;
            } else {
                obj = drawerShape;
            }
        }
        if (i48 & 24576 == 0) {
            if (i49 & 16 == 0) {
                i6 = restartGroup.changed(drawerContainerColor) ? 16384 : 8192;
            } else {
                standardContainerColor = drawerContainerColor;
            }
            $dirty |= i6;
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
        i17 = i49 & 64;
        i13 = 1572864;
        if (i17 != 0) {
            $dirty |= i13;
            modifier2 = $composer;
        } else {
            if (i48 & i13 == 0) {
                i13 = restartGroup.changed($composer) ? 1048576 : 524288;
                $dirty |= i13;
            } else {
                modifier2 = $composer;
            }
        }
        int i32 = 12582912;
        if (i49 & 128 != 0) {
            $dirty |= i32;
        } else {
            if (i48 & i32 == 0) {
                i8 = restartGroup.changedInstance(obj8) ? 8388608 : 4194304;
                $dirty |= i8;
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
                            obj2 = defaultsInvalid;
                        }
                        if (i43 != 0) {
                            obj = defaultsInvalid;
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
                        if (i17 != 0) {
                            f = permanentDrawerElevation-D9Ej5fM;
                            i9 = i51;
                            i17 = standardContainerColor;
                            obj3 = obj;
                        } else {
                            f = modifier2;
                            i9 = i51;
                            i17 = standardContainerColor;
                            obj3 = obj;
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
                            i9 = i51;
                            i17 = standardContainerColor;
                            obj3 = obj;
                        } else {
                            drawerContentColor2 = drawerTonalElevation;
                            f = modifier2;
                            i9 = i51;
                            i17 = standardContainerColor;
                            obj3 = obj;
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
                i12 = restartGroup.consume((CompositionLocal)CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl ? i40 : 0;
                if (drawerPredictiveBackState != null) {
                    predictiveBackDrawerContainer = NavigationDrawerKt.predictiveBackDrawerContainer((Modifier)Modifier.Companion, drawerPredictiveBackState, i12);
                } else {
                    obj = drawerPredictiveBackState;
                    predictiveBackDrawerContainer = Modifier.Companion;
                }
                i19 = 0;
                obj28 = obj2;
                NavigationDrawerKt.DrawerSheet.1 anon = new NavigationDrawerKt.DrawerSheet.1(obj, i12, obj5, obj8);
                obj29 = i12;
                SurfaceKt.Surface-T9BRK9s(SizeKt.fillMaxHeight$default(SizeKt.sizeIn-qDBjuR0$default(obj28, NavigationDrawerKt.MinimumDrawerWidth, 0, DrawerDefaults.INSTANCE.getMaximumDrawerWidth-D9Ej5fM(), 0, 10, i19).then(predictiveBackDrawerContainer), 0, i40, 0), obj3, i17, i51, drawerContentColor2, obj18, f, 0, i19, (Function2)ComposableLambdaKt.rememberComposableLambda(669057502, i40, anon, restartGroup, 54), restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i3 = $dirty;
                $composer2 = obj7;
                $dirty2 = obj3;
                l2 = i17;
                l3 = drawerContentColor2;
                modifier2 = f;
            } else {
                restartGroup.skipToGroupEnd();
                composer = restartGroup;
                $composer2 = obj2;
                l2 = standardContainerColor;
                i3 = $dirty;
                $dirty2 = obj;
                l3 = drawerTonalElevation;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new NavigationDrawerKt.DrawerSheet.2(drawerPredictiveBackState, obj5, $composer2, $dirty2, l2, obj2, l3, obj, modifier2, obj8, i48, i49);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void ModalDrawerSheet-Snr_uVM(androidx.compose.material3.DrawerState drawerState, Modifier modifier, Shape drawerShape, long drawerContainerColor, long drawerContentColor, float drawerTonalElevation, WindowInsets windowInsets, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i11) {
        Object obj9;
        int traceInProgress;
        int windowInsets2;
        boolean traceInProgress2;
        int defaultsInvalid;
        int shape;
        int drawerShape2;
        int modalDrawerElevation-D9Ej5fM;
        int $dirty2;
        Object $dirty;
        int i3;
        int str;
        Object obj;
        Object obj3;
        long l3;
        int i4;
        Object obj2;
        int changed4;
        long modalContainerColor;
        long l;
        int changed3;
        long contentColorFor-ek8zF_U;
        float f3;
        Object obj5;
        int changed2;
        int i5;
        float f4;
        int i;
        int i6;
        Object obj8;
        int changed;
        int i2;
        androidx.compose.material3.NavigationDrawerKt.ModalDrawerSheet.2 anon;
        Object obj7;
        Object obj10;
        Object obj6;
        long l2;
        long l4;
        float f2;
        Object obj4;
        float f;
        int obj38;
        final Object obj11 = drawerState;
        final int i28 = obj39;
        final int i29 = obj40;
        final Composer restartGroup = i11.startRestartGroup(1513027356);
        ComposerKt.sourceInformation(restartGroup, "C(ModalDrawerSheet)P(4,6,3,1:c#ui.graphics.Color,2:c#ui.graphics.Color,5:c#ui.unit.Dp,7)605@24793L5,606@24849L19,607@24902L37,609@25057L12,612@25168L299,612@25127L340:NavigationDrawer.kt#uh7d8r");
        $dirty2 = obj39;
        if (i29 & 1 != 0) {
            $dirty2 |= 6;
        } else {
            if (i28 & 6 == 0) {
                i3 = restartGroup.changed(obj11) ? 4 : 2;
                $dirty2 |= i3;
            }
        }
        int i15 = i29 & 2;
        if (i15 != 0) {
            $dirty2 |= 48;
            obj3 = modifier;
        } else {
            if (i28 & 48 == 0) {
                i4 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i4;
            } else {
                obj3 = modifier;
            }
        }
        if (i28 & 384 == 0) {
            if (i29 & 4 == 0) {
                changed4 = restartGroup.changed(drawerShape) ? 256 : 128;
            } else {
                obj2 = drawerShape;
            }
            $dirty2 |= changed4;
        } else {
            obj2 = drawerShape;
        }
        if (i28 & 3072 == 0) {
            if (i29 & 8 == 0) {
                changed3 = restartGroup.changed(drawerContainerColor) ? 2048 : 1024;
            } else {
                modalContainerColor = drawerContainerColor;
            }
            $dirty2 |= changed3;
        } else {
            modalContainerColor = drawerContainerColor;
        }
        if (i28 & 24576 == 0) {
            if (i29 & 16 == 0) {
                changed2 = restartGroup.changed(drawerTonalElevation) ? 16384 : 8192;
            } else {
                contentColorFor-ek8zF_U = drawerTonalElevation;
            }
            $dirty2 |= changed2;
        } else {
            contentColorFor-ek8zF_U = drawerTonalElevation;
        }
        i5 = i29 & 32;
        int i30 = 196608;
        if (i5 != 0) {
            $dirty2 |= i30;
            f4 = content;
        } else {
            if (i30 &= i28 == 0) {
                i6 = restartGroup.changed(content) ? 131072 : 65536;
                $dirty2 |= i6;
            } else {
                f4 = content;
            }
        }
        if (i32 &= i28 == 0) {
            if (i29 & 64 == 0) {
                changed = restartGroup.changed($composer) ? 1048576 : 524288;
            } else {
                obj8 = $composer;
            }
            $dirty2 |= changed;
        } else {
            obj8 = $composer;
        }
        i2 = 12582912;
        if (i29 & 128 != 0) {
            $dirty2 |= i2;
            obj9 = $changed;
        } else {
            if (i28 & i2 == 0) {
                i2 = restartGroup.changedInstance($changed) ? 8388608 : 4194304;
                $dirty2 |= i2;
            } else {
                obj9 = $changed;
            }
        }
        if ($dirty2 & anon == 4793490) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                str = -3670017;
                int i35 = -57345;
                if (i28 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i15 != 0) {
                            obj3 = defaultsInvalid;
                        }
                        str = 6;
                        if (i29 & 4 != 0) {
                            $dirty2 &= -897;
                            obj2 = shape;
                        }
                        if (i29 & 8 != 0) {
                            modalContainerColor = DrawerDefaults.INSTANCE.getModalContainerColor(restartGroup, str);
                            $dirty2 &= -7169;
                        }
                        if (i29 & 16 != 0) {
                            contentColorFor-ek8zF_U = ColorSchemeKt.contentColorFor-ek8zF_U(modalContainerColor, obj7, restartGroup);
                            $dirty2 &= i35;
                        }
                        if (i5 != 0) {
                            f4 = modalDrawerElevation-D9Ej5fM;
                        }
                        if (i29 & 64 != 0) {
                            $dirty2 &= obj38;
                            obj7 = windowInsets2;
                            obj10 = obj3;
                            obj6 = obj2;
                            l2 = modalContainerColor;
                            l4 = contentColorFor-ek8zF_U;
                            f2 = f4;
                        } else {
                            obj10 = obj3;
                            obj6 = obj2;
                            l2 = modalContainerColor;
                            l4 = contentColorFor-ek8zF_U;
                            f2 = f4;
                            obj7 = obj8;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i29 & 4 != 0) {
                            $dirty2 &= -897;
                        }
                        if (i29 & 8 != 0) {
                            $dirty2 &= -7169;
                        }
                        if (i29 & 16 != 0) {
                            $dirty2 &= i35;
                        }
                        if (i29 & 64 != 0) {
                            $dirty2 = windowInsets2;
                            obj10 = obj3;
                            obj6 = obj2;
                            l2 = modalContainerColor;
                            l4 = contentColorFor-ek8zF_U;
                            f2 = f4;
                            obj7 = obj8;
                        } else {
                            obj10 = obj3;
                            obj6 = obj2;
                            l2 = modalContainerColor;
                            l4 = contentColorFor-ek8zF_U;
                            f2 = f4;
                            obj7 = obj8;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1513027356, $dirty2, -1, "androidx.compose.material3.ModalDrawerSheet (NavigationDrawer.kt:611)");
                }
                anon = new NavigationDrawerKt.ModalDrawerSheet.2(obj7, obj10, obj6, l2, obj22, l4, obj24, f2, $changed);
                NavigationDrawer_androidKt.DrawerPredictiveBackHandler(obj11, (Function3)ComposableLambdaKt.rememberComposableLambda(1552342929, true, anon, restartGroup, 54), restartGroup, i18 |= 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i = $dirty2;
                obj5 = obj7;
                $dirty = obj10;
                obj = obj6;
                l3 = l2;
                l = l4;
                f3 = f2;
            } else {
                restartGroup.skipToGroupEnd();
                obj = obj2;
                i = $dirty2;
                $dirty = obj3;
                l3 = modalContainerColor;
                l = contentColorFor-ek8zF_U;
                f3 = f;
                obj5 = obj8;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new NavigationDrawerKt.ModalDrawerSheet.3(obj11, $dirty, obj, l3, obj2, l, obj7, f3, obj5, $changed, i28, i29);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void ModalDrawerSheet-afqeVBk(Modifier modifier, Shape drawerShape, long drawerContainerColor, long drawerContentColor, float drawerTonalElevation, WindowInsets windowInsets, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i10) {
        int traceInProgress;
        int windowInsets2;
        int defaultsInvalid;
        int shape;
        int drawerShape2;
        int modalDrawerElevation-D9Ej5fM;
        Object $composer2;
        int $dirty;
        Object $dirty2;
        int i5;
        long l2;
        Object obj4;
        boolean traceInProgress2;
        int i4;
        Object str;
        long l;
        int changed;
        long modalContainerColor;
        float f2;
        int changed3;
        long contentColorFor-ek8zF_U;
        Object obj;
        int i;
        int changed2;
        int i2;
        float f3;
        Object drawerTonalElevation2;
        int windowInsets3;
        int i3;
        Object obj2;
        int changed4;
        Object obj3;
        int i8;
        long i6;
        long l3;
        float f;
        Composer composer2;
        Composer composer;
        int i7;
        int i9;
        int obj33;
        final int i51 = obj34;
        Composer restartGroup = i10.startRestartGroup(1001163336);
        ComposerKt.sourceInformation(restartGroup, "C(ModalDrawerSheet)P(5,3,1:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.unit.Dp,6)561@22840L5,562@22896L19,563@22949L37,565@23104L12,568@23174L225:NavigationDrawer.kt#uh7d8r");
        $dirty = obj34;
        int i26 = obj35 & 1;
        if (i26 != 0) {
            $dirty |= 6;
            obj4 = modifier;
        } else {
            if (i51 & 6 == 0) {
                i4 = restartGroup.changed(modifier) ? 4 : 2;
                $dirty |= i4;
            } else {
                obj4 = modifier;
            }
        }
        if (i51 & 48 == 0) {
            if (obj35 & 2 == 0) {
                changed = restartGroup.changed(drawerShape) ? 32 : 16;
            } else {
                str = drawerShape;
            }
            $dirty |= changed;
        } else {
            str = drawerShape;
        }
        if (i51 & 384 == 0) {
            if (obj35 & 4 == 0) {
                changed3 = restartGroup.changed(drawerContainerColor) ? 256 : 128;
            } else {
                modalContainerColor = drawerContainerColor;
            }
            $dirty |= changed3;
        } else {
            modalContainerColor = drawerContainerColor;
        }
        if (i51 & 3072 == 0) {
            if (obj35 & 8 == 0) {
                changed2 = restartGroup.changed(drawerTonalElevation) ? 2048 : 1024;
            } else {
                contentColorFor-ek8zF_U = drawerTonalElevation;
            }
            $dirty |= changed2;
        } else {
            contentColorFor-ek8zF_U = drawerTonalElevation;
        }
        i2 = obj35 & 16;
        if (i2 != 0) {
            $dirty |= 24576;
            f3 = content;
        } else {
            if (i51 & 24576 == 0) {
                i3 = restartGroup.changed(content) ? 16384 : 8192;
                $dirty |= i3;
            } else {
                f3 = content;
            }
        }
        if (i53 &= i51 == 0) {
            if (obj35 & 32 == 0) {
                changed4 = restartGroup.changed($composer) ? 131072 : 65536;
            } else {
                obj2 = $composer;
            }
            $dirty |= changed4;
        } else {
            obj2 = $composer;
        }
        i8 = 1572864;
        if (obj35 & 64 != 0) {
            $dirty |= i8;
            obj3 = $changed;
        } else {
            if (i51 & i8 == 0) {
                i8 = restartGroup.changedInstance($changed) ? 1048576 : 524288;
                $dirty |= i8;
            } else {
                obj3 = $changed;
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
                            obj4 = defaultsInvalid;
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
                        if (i2 != 0) {
                            f3 = modalDrawerElevation-D9Ej5fM;
                        }
                        if (obj35 & 32 != 0) {
                            $dirty &= obj33;
                            obj2 = obj4;
                            obj3 = str;
                            l3 = contentColorFor-ek8zF_U;
                            f = f3;
                            i5 = 1001163336;
                            drawerTonalElevation2 = windowInsets4;
                            windowInsets2 = i59;
                            i6 = modalContainerColor;
                        } else {
                            obj3 = str;
                            l3 = contentColorFor-ek8zF_U;
                            f = f3;
                            drawerTonalElevation2 = obj2;
                            windowInsets2 = i59;
                            i5 = 1001163336;
                            obj2 = obj4;
                            i6 = modalContainerColor;
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
                            obj3 = str;
                            l3 = contentColorFor-ek8zF_U;
                            f = f3;
                            drawerTonalElevation2 = obj2;
                            windowInsets2 = i59;
                            i5 = 1001163336;
                            obj2 = obj4;
                            i6 = modalContainerColor;
                        } else {
                            obj3 = str;
                            l3 = contentColorFor-ek8zF_U;
                            f = f3;
                            drawerTonalElevation2 = obj2;
                            windowInsets2 = i59;
                            i5 = 1001163336;
                            obj2 = obj4;
                            i6 = modalContainerColor;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i5, $dirty, -1, "androidx.compose.material3.ModalDrawerSheet (NavigationDrawer.kt:567)");
                }
                NavigationDrawerKt.DrawerSheet-7zSek6w(0, drawerTonalElevation2, obj2, obj3, i6, obj16, l3, obj18, f, $changed, restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj = drawerTonalElevation2;
                $composer2 = obj2;
                l2 = i6;
                l = l3;
                f2 = f;
                windowInsets3 = $dirty;
                $dirty2 = obj3;
            } else {
                restartGroup.skipToGroupEnd();
                composer = restartGroup;
                $composer2 = obj4;
                l2 = modalContainerColor;
                f2 = f3;
                windowInsets3 = $dirty;
                $dirty2 = str;
                l = contentColorFor-ek8zF_U;
                obj = obj2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new NavigationDrawerKt.ModalDrawerSheet.1($composer2, $dirty2, l2, obj4, l, modalContainerColor, f2, obj, $changed, i51, obj35);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void ModalNavigationDrawer-FHprtrg(Function2<? super Composer, ? super Integer, Unit> drawerContent, Modifier modifier, androidx.compose.material3.DrawerState drawerState, boolean gesturesEnabled, long scrimColor, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i9) {
        Object composer$iv;
        Function0 factory$iv$iv$iv2;
        int i10;
        Object $i$a$CacheNavigationDrawerKt$ModalNavigationDrawer$2$2;
        Object $i$a$CacheNavigationDrawerKt$ModalNavigationDrawer$2$3;
        Object $i$a$CacheNavigationDrawerKt$ModalNavigationDrawer$2$6;
        Object semantics$default;
        Object empty;
        int empty3;
        boolean traceInProgress;
        boolean currentCompositionLocalMap;
        int changed5;
        int i27;
        int i30;
        int empty6;
        Object $i$a$CacheNavigationDrawerKt$ModalNavigationDrawer$2$4;
        Object navigationMenu;
        Function0 factory$iv$iv;
        int changed2;
        int changed8;
        Object obj3;
        int $dirty2;
        Object $dirty;
        int i21;
        Object modifier4;
        Integer currentCompositionLocalMap2;
        Object obj8;
        int compositionCoroutineScope;
        Composer composer3;
        Object coroutineScope2;
        boolean z2;
        Object obj7;
        int rememberDrawerState;
        boolean traceInProgress2;
        Object empty4;
        Function0 factory$iv$iv$iv;
        Object it$iv;
        int i22;
        int changed6;
        long l3;
        int i12;
        Object obj4;
        Object empty2;
        int i36;
        Object mutableStateOf$default;
        int i23;
        int changed3;
        int i7;
        int $i$a$CacheNavigationDrawerKt$ModalNavigationDrawer$minValue$2;
        int defaultsInvalid;
        Object $i$a$CacheNavigationDrawerKt$ModalNavigationDrawer$anchorsInitialized$2;
        boolean changed;
        int changed4;
        int currentCompositeKeyHash;
        boolean obj;
        int i38;
        long scrimColor2;
        int i15;
        Object $i$a$CacheNavigationDrawerKt$ModalNavigationDrawer$1;
        Object empty5;
        int changed9;
        boolean z;
        int changed7;
        int i28;
        int i37;
        Composer composer5;
        Composer composer;
        int i13;
        int i;
        int i11;
        int i20;
        Object maybeCachedBoxMeasurePolicy2;
        Object maybeCachedBoxMeasurePolicy;
        Modifier materializeModifier;
        int i24;
        int companion6;
        Object obj2;
        Composer.Companion companion5;
        int i17;
        boolean z3;
        int i25;
        Object $i$a$RememberCoroutineScopeEffectsKt$rememberCoroutineScope$1;
        int i14;
        int companion2;
        int i31;
        int companion;
        Composer.Companion companion3;
        int i16;
        int invalid$iv;
        int invalid$iv2;
        Object obj5;
        int i18;
        int invalid$iv3;
        long l;
        long l2;
        Function0 function03;
        int i6;
        kotlinx.coroutines.CoroutineScope coroutineScope;
        Alignment alignment;
        int i8;
        int currentCompositeKeyHash2;
        Modifier modifier3;
        Function0 function02;
        int i32;
        int i26;
        Object obj6;
        String str;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv2;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy;
        int i5;
        int i33;
        BoxScopeInstance boxScopeInstance;
        Modifier modifier2;
        Composer composer2;
        int i34;
        int i29;
        int currentCompositeKeyHash3;
        int i3;
        int i2;
        androidx.compose.ui.Modifier.Companion companion4;
        Function0 function0;
        int i19;
        int i35;
        Composer composer6;
        String str2;
        int i4;
        BoxScopeInstance boxScopeInstance2;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy2;
        Composer composer4;
        Modifier modifier5;
        Composer obj63;
        int obj64;
        Composer obj65;
        int obj66;
        int obj67;
        int obj69;
        empty2 = $composer;
        i7 = i9;
        final Composer restartGroup = $changed.startRestartGroup(-1169303680);
        ComposerKt.sourceInformation(restartGroup, "C(ModalNavigationDrawer)P(1,4,2,3,5:c#ui.graphics.Color)316@12708L39,318@12825L10,321@12893L24,322@12943L33,323@13008L7,324@13046L34,325@13101L45,328@13185L33,328@13174L44,330@13257L7,331@13292L3053:NavigationDrawer.kt#uh7d8r");
        $dirty2 = i9;
        int i74 = 2;
        if (obj71 & 1 != 0) {
            $dirty2 |= 6;
        } else {
            if (i7 & 6 == 0) {
                i21 = restartGroup.changedInstance(drawerContent) ? 4 : i74;
                $dirty2 |= i21;
            }
        }
        int i69 = obj71 & 2;
        if (i69 != 0) {
            $dirty2 |= 48;
            obj7 = modifier;
        } else {
            if (i7 & 48 == 0) {
                i12 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i12;
            } else {
                obj7 = modifier;
            }
        }
        if (i7 & 384 == 0) {
            if (obj71 & 4 == 0) {
                changed4 = restartGroup.changed(drawerState) ? 256 : 128;
            } else {
                obj4 = drawerState;
            }
            $dirty2 |= changed4;
        } else {
            obj4 = drawerState;
        }
        currentCompositeKeyHash = obj71 & 8;
        if (currentCompositeKeyHash != 0) {
            $dirty2 |= 3072;
            obj = gesturesEnabled;
        } else {
            if (i7 & 3072 == 0) {
                i38 = restartGroup.changed(gesturesEnabled) ? 2048 : 1024;
                $dirty2 |= i38;
            } else {
                obj = gesturesEnabled;
            }
        }
        if (i7 & 24576 == 0) {
            if (obj71 & 16 == 0) {
                changed7 = restartGroup.changed(scrimColor) ? 16384 : 8192;
            } else {
                scrimColor2 = scrimColor;
            }
            $dirty2 |= changed7;
        } else {
            scrimColor2 = scrimColor;
        }
        if (obj71 & 32 != 0) {
            i28 = 196608;
            $dirty2 |= i28;
        } else {
        }
        if (i124 &= $dirty2 == 74898) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i39 = 6;
                if (i7 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i69 != 0) {
                            modifier4 = Modifier.Companion;
                        } else {
                            modifier4 = obj7;
                        }
                        if (obj71 & 4 != 0) {
                            $dirty2 &= -897;
                            obj4 = rememberDrawerState;
                        }
                        if (currentCompositeKeyHash != 0) {
                            obj = rememberDrawerState;
                        }
                        if (obj71 & 16 != 0) {
                            scrimColor2 = DrawerDefaults.INSTANCE.getScrimColor(restartGroup, i39);
                            $dirty2 &= obj7;
                            z3 = obj;
                        } else {
                            z3 = obj;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (obj71 & 4 != 0) {
                            $dirty2 &= -897;
                        }
                        if (obj71 & 16 != 0) {
                            $dirty2 &= i73;
                            modifier4 = obj7;
                            z3 = obj;
                        } else {
                            modifier4 = obj7;
                            z3 = obj;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1169303680, $dirty2, -1, "androidx.compose.material3.ModalNavigationDrawer (NavigationDrawer.kt:320)");
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
                    empty4 = 0;
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
                    l2 = scrimColor2;
                    scrimColor2 = 0;
                    composer16.updateRememberedValue(SnapshotStateKt.mutableStateOf$default(false, scrimColor2, 2, scrimColor2));
                } else {
                    obj65 = mutableStateOf$default;
                    l2 = scrimColor2;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerStart(restartGroup, -2145779460, str7);
                changed = restartGroup.changed((Density)this_$iv2);
                Composer composer17 = restartGroup;
                int i114 = 0;
                Object rememberedValue7 = composer17.rememberedValue();
                int i127 = 0;
                if (!changed) {
                    obj64 = changed;
                    if (rememberedValue7 == Composer.Companion.getEmpty()) {
                        int invalid$iv7 = 0;
                        composer17.updateRememberedValue(PrimitiveSnapshotStateKt.mutableFloatStateOf(0));
                    } else {
                        $i$a$CacheNavigationDrawerKt$ModalNavigationDrawer$minValue$2 = rememberedValue7;
                    }
                } else {
                    obj64 = changed;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                obj = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -2145776784, str7);
                if (i116 ^= 384 > 256) {
                    if (!restartGroup.changed(obj4)) {
                        i15 = $dirty2 & 384 == 256 ? 1 : 0;
                    } else {
                    }
                } else {
                }
                i15 |= changed15;
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
                i14 = restartGroup.consume((CompositionLocal)CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl ? 1 : 0;
                Modifier anchoredDraggable$default = AnchoredDraggableKt.anchoredDraggable$default(SizeKt.fillMaxSize$default(modifier4, 0, 1, 0), obj4.getAnchoredDraggableState$material3_release(), Orientation.Horizontal, z3, i14, 0, 16, 0);
                z = z3;
                companion6 = 0;
                obj66 = i118;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                Alignment topStart2 = Alignment.Companion.getTopStart();
                int i119 = 0;
                obj67 = i129;
                maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(topStart2, i119);
                i25 = 0;
                alignment = topStart2;
                i8 = i119;
                String propagateMinConstraints$iv = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, propagateMinConstraints$iv);
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, 0);
                currentCompositionLocalMap2 = restartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(restartGroup, anchoredDraggable$default);
                modifier3 = anchoredDraggable$default;
                Function0 function04 = constructor;
                i32 = 0;
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
                function02 = factory$iv$iv$iv;
                Composer constructor-impl3 = Updater.constructor-impl(restartGroup);
                int i152 = 0;
                Updater.set-impl(constructor-impl3, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl3, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i157 = 0;
                Composer composer20 = constructor-impl3;
                int i163 = 0;
                if (!composer20.getInserting()) {
                    localMap$iv$iv2 = currentCompositionLocalMap2;
                    measurePolicy = maybeCachedBoxMeasurePolicy;
                    if (!Intrinsics.areEqual(composer20.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        composer20.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        constructor-impl3.apply(Integer.valueOf(currentCompositeKeyHash2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer5 = composer20;
                    }
                } else {
                    localMap$iv$iv2 = currentCompositionLocalMap2;
                    measurePolicy = maybeCachedBoxMeasurePolicy;
                }
                Updater.set-impl(constructor-impl3, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                Composer composer11 = restartGroup;
                i5 = i41;
                ComposerKt.sourceInformationMarkerStart(composer11, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                Composer composer19 = composer11;
                i33 = 0;
                boxScopeInstance = iNSTANCE;
                modifier2 = materializeModifier2;
                ComposerKt.sourceInformationMarkerStart(composer11, -1884917117, "C341@13601L17,344@13695L268,352@13988L70,342@13627L473,358@14209L245,364@14486L623,379@15121L1218,355@14109L2230:NavigationDrawer.kt#uh7d8r");
                int i153 = i42;
                companion = i58;
                ComposerKt.sourceInformationMarkerStart(composer11, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                androidx.compose.ui.Modifier.Companion companion10 = Modifier.Companion;
                Alignment topStart = Alignment.Companion.getTopStart();
                i34 = i81;
                int $i$a$LayoutBoxKt$Box$1$iv = 0;
                i29 = i133;
                maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(topStart, $i$a$LayoutBoxKt$Box$1$iv);
                int i164 = 0;
                Alignment alignment2 = topStart;
                ComposerKt.sourceInformationMarkerStart(composer11, -1323940314, propagateMinConstraints$iv);
                currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer11, 0);
                currentCompositionLocalMap = composer11.getCurrentCompositionLocalMap();
                i3 = $i$a$LayoutBoxKt$Box$1$iv;
                Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer11, (Modifier)companion10);
                companion4 = companion10;
                Function0 function05 = constructor3;
                i2 = 0;
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
                function0 = factory$iv$iv$iv2;
                Composer constructor-impl = Updater.constructor-impl(composer11);
                int i166 = 0;
                Updater.set-impl(constructor-impl, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i167 = 0;
                Composer composer22 = constructor-impl;
                int i168 = 0;
                if (!composer22.getInserting()) {
                    localMap$iv$iv = currentCompositionLocalMap;
                    measurePolicy2 = maybeCachedBoxMeasurePolicy2;
                    if (!Intrinsics.areEqual(composer22.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                        composer22.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer = composer22;
                    }
                } else {
                    localMap$iv$iv = currentCompositionLocalMap;
                    measurePolicy2 = maybeCachedBoxMeasurePolicy2;
                }
                Updater.set-impl(constructor-impl, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                Composer composer8 = composer11;
                int i93 = 0;
                i35 = i46;
                ComposerKt.sourceInformationMarkerStart(composer8, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                i136 |= 6;
                i4 = 0;
                boxScopeInstance2 = iNSTANCE2;
                modifier5 = materializeModifier3;
                Composer materialized$iv$iv2 = composer6;
                ComposerKt.sourceInformationMarkerStart(materialized$iv$iv2, 2020094509, "C341@13607L9:NavigationDrawer.kt#uh7d8r");
                empty2.invoke(materialized$iv$iv2, Integer.valueOf(i47 &= 14));
                ComposerKt.sourceInformationMarkerEnd(materialized$iv$iv2);
                ComposerKt.sourceInformationMarkerEnd(composer8);
                composer11.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer11);
                ComposerKt.sourceInformationMarkerEnd(composer11);
                ComposerKt.sourceInformationMarkerEnd(composer11);
                ComposerKt.sourceInformationMarkerStart(composer11, -2139013222, str7);
                i10 = $dirty2 & 7168 == 2048 ? 1 : 0;
                if (i61 ^= 384 > 256) {
                    if (!restartGroup.changed(obj4)) {
                        i27 = $dirty2 & 384 == 256 ? 1 : 0;
                    } else {
                    }
                } else {
                }
                i51 |= changedInstance;
                Composer composer9 = composer11;
                int i82 = 0;
                Object rememberedValue4 = composer9.rememberedValue();
                int i138 = 0;
                if (empty3 == 0) {
                    invalid$iv = empty3;
                    if (rememberedValue4 == Composer.Companion.getEmpty()) {
                        companion = invalid$iv5;
                        $i$a$CacheNavigationDrawerKt$ModalNavigationDrawer$2$2 = new NavigationDrawerKt.ModalNavigationDrawer.2.2.1(z, obj4, coroutineScope2);
                        composer9.updateRememberedValue((Function0)$i$a$CacheNavigationDrawerKt$ModalNavigationDrawer$2$2);
                    } else {
                        $i$a$CacheNavigationDrawerKt$ModalNavigationDrawer$2$2 = rememberedValue4;
                    }
                } else {
                    invalid$iv = empty3;
                }
                ComposerKt.sourceInformationMarkerEnd(composer11);
                ComposerKt.sourceInformationMarkerStart(composer11, -2139004044, str7);
                if (i62 ^= 384 > 256) {
                    if (!restartGroup.changed(obj4)) {
                        i30 = $dirty2 & 384 == 256 ? 1 : 0;
                    } else {
                    }
                } else {
                }
                changed10 |= i30;
                Composer composer10 = composer11;
                int i83 = 0;
                Object rememberedValue5 = composer10.rememberedValue();
                int i139 = 0;
                if (empty == 0) {
                    invalid$iv3 = empty;
                    if (rememberedValue5 == Composer.Companion.getEmpty()) {
                        invalid$iv = invalid$iv4;
                        $i$a$CacheNavigationDrawerKt$ModalNavigationDrawer$2$3 = new NavigationDrawerKt.ModalNavigationDrawer.2.3.1(obj, obj4, $i$a$CacheNavigationDrawerKt$ModalNavigationDrawer$minValue$2);
                        composer10.updateRememberedValue((Function0)$i$a$CacheNavigationDrawerKt$ModalNavigationDrawer$2$3);
                    } else {
                        $i$a$CacheNavigationDrawerKt$ModalNavigationDrawer$2$3 = rememberedValue5;
                    }
                } else {
                    invalid$iv3 = empty;
                }
                ComposerKt.sourceInformationMarkerEnd(composer11);
                l = l2;
                NavigationDrawerKt.Scrim-Bx497Mc(obj4.isOpen(), (Function0)$i$a$CacheNavigationDrawerKt$ModalNavigationDrawer$2$2, (Function0)$i$a$CacheNavigationDrawerKt$ModalNavigationDrawer$2$3, l, l2, composer11);
                ComposerKt.sourceInformationMarkerStart(composer11, -2138996797, str7);
                if (i64 ^= 384 > 256) {
                    if (!restartGroup.changed(obj4)) {
                        empty6 = $dirty2 & 384 == 256 ? 1 : 0;
                    } else {
                    }
                } else {
                }
                Composer composer12 = composer11;
                int i94 = 0;
                Object rememberedValue10 = composer12.rememberedValue();
                int i154 = 0;
                if (empty6 == 0) {
                    invalid$iv2 = empty6;
                    if (rememberedValue10 == Composer.Companion.getEmpty()) {
                        companion3 = invalid$iv6;
                        $i$a$CacheNavigationDrawerKt$ModalNavigationDrawer$2$4 = new NavigationDrawerKt.ModalNavigationDrawer.2.4.1(obj4);
                        composer12.updateRememberedValue((Function1)$i$a$CacheNavigationDrawerKt$ModalNavigationDrawer$2$4);
                    } else {
                        $i$a$CacheNavigationDrawerKt$ModalNavigationDrawer$2$4 = rememberedValue10;
                    }
                } else {
                    invalid$iv2 = empty6;
                }
                ComposerKt.sourceInformationMarkerEnd(composer11);
                ComposerKt.sourceInformationMarkerStart(composer11, -2138987555, str7);
                String str4 = str9;
                if (i95 ^= 384 > 256) {
                    if (!restartGroup.changed(obj4)) {
                        i23 = $dirty2 & 384 == 256 ? 1 : 0;
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
                        empty2 = 0;
                        obj5 = it$iv;
                        it$iv = new NavigationDrawerKt.ModalNavigationDrawer.2.5.1(str4, obj4, coroutineScope2);
                        composer14.updateRememberedValue((Function1)it$iv);
                    } else {
                        obj5 = it$iv;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(composer11);
                int i141 = 1;
                semantics$default = SemanticsModifierKt.semantics$default(OffsetKt.offset((Modifier)Modifier.Companion, (Function1)$i$a$CacheNavigationDrawerKt$ModalNavigationDrawer$2$4), false, (Function1)it$iv, i141, 0);
                ComposerKt.sourceInformationMarkerStart(composer11, -2138966640, str7);
                if (i87 ^= 384 > 256) {
                    if (!restartGroup.changed(obj4)) {
                        i22 = $dirty2 & 384 == 256 ? i141 : 0;
                    } else {
                    }
                } else {
                }
                Composer composer13 = composer11;
                int i97 = 0;
                Object rememberedValue6 = composer13.rememberedValue();
                int i142 = 0;
                if (i22 |= changed13 == 0) {
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
                i7 = 0;
                ComposerKt.sourceInformationMarkerStart(composer11, -1323940314, propagateMinConstraints$iv);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer11, 0);
                obj6 = navigationMenu;
                obj63 = constructor2;
                i24 = 0;
                i31 = $dirty2;
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
                i16 = 0;
                function03 = factory$iv$iv;
                Updater.set-impl(constructor-impl2, (MeasurePolicy)$i$a$CacheNavigationDrawerKt$ModalNavigationDrawer$2$6, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl2, composer11.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                i18 = 0;
                obj63 = constructor-impl2;
                i6 = 0;
                if (!obj63.getInserting()) {
                    obj69 = $i$a$CacheNavigationDrawerKt$ModalNavigationDrawer$2$6;
                    coroutineScope = coroutineScope2;
                    if (!Intrinsics.areEqual(obj63.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        obj63.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl2.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer3 = obj63;
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
                obj8 = obj4;
                z2 = z;
                $dirty = obj2;
                l3 = l;
            } else {
                restartGroup.skipToGroupEnd();
                i31 = $dirty2;
                $dirty = obj7;
                obj8 = obj4;
                z2 = obj;
                l3 = scrimColor2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new NavigationDrawerKt.ModalNavigationDrawer.3(obj3, $dirty, obj8, z2, l3, obj4, $composer, i9, obj71);
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
        int modifier2;
        int defaultsInvalid;
        Object modifier3;
        Modifier i11;
        int i7;
        int i16;
        int $dirty2;
        Object obj11;
        Object colors2;
        Object shape2;
        Object obj5;
        Object obj12;
        int i8;
        Object obj2;
        Object obj4;
        Object obj14;
        int i21;
        int i6;
        Object obj;
        boolean traceInProgress2;
        Object obj3;
        int i9;
        int value;
        Object navigationDrawerItemColors;
        Object anon;
        int i10;
        int i3;
        int i19;
        Object obj8;
        int i13;
        int i4;
        Object obj10;
        Composer restartGroup;
        int i14;
        Object obj6;
        int changed2;
        int changed;
        int i17;
        int i;
        int i5;
        androidx.compose.material3.NavigationDrawerItemColors navigationDrawerItemColors2;
        int i2;
        Composer composer2;
        Composer composer;
        int i15;
        int i20;
        Object obj9;
        Object obj7;
        Object obj13;
        int $dirty;
        int i18;
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
        $dirty2 = $changed;
        if (i11 & 1 != 0) {
            $dirty2 |= 6;
            obj5 = label;
        } else {
            if (i27 & 6 == 0) {
                i21 = restartGroup.changedInstance(label) ? 4 : 2;
                $dirty2 |= i21;
            } else {
                obj5 = label;
            }
        }
        if (i11 & 2 != 0) {
            $dirty2 |= 48;
        } else {
            if (i27 & 48 == 0) {
                i6 = restartGroup.changed(traceInProgress) ? 32 : 16;
                $dirty2 |= i6;
            }
        }
        if (i11 & 4 != 0) {
            $dirty2 |= 384;
            obj = onClick;
        } else {
            if (i27 & 384 == 0) {
                i9 = restartGroup.changedInstance(onClick) ? 256 : 128;
                $dirty2 |= i9;
            } else {
                obj = onClick;
            }
        }
        value = i11 & 8;
        if (value != null) {
            $dirty2 |= 3072;
            anon = modifier;
        } else {
            if (i27 & 3072 == 0) {
                i3 = restartGroup.changed(modifier) ? 2048 : 1024;
                $dirty2 |= i3;
            } else {
                anon = modifier;
            }
        }
        i19 = i11 & 16;
        if (i19 != 0) {
            $dirty2 |= 24576;
            obj8 = icon;
        } else {
            if (i27 & 24576 == 0) {
                i13 = restartGroup.changedInstance(icon) ? 16384 : 8192;
                $dirty2 |= i13;
            } else {
                obj8 = icon;
            }
        }
        i4 = i11 & 32;
        int i61 = 196608;
        if (i4 != 0) {
            $dirty2 |= i61;
            obj10 = badge;
        } else {
            if (i61 &= i27 == 0) {
                i14 = restartGroup.changedInstance(badge) ? 131072 : 65536;
                $dirty2 |= i14;
            } else {
                obj10 = badge;
            }
        }
        if (i63 &= i27 == 0) {
            if (i11 & 64 == 0) {
                changed2 = restartGroup.changed(shape) ? 1048576 : 524288;
            } else {
                obj6 = shape;
            }
            $dirty2 |= changed2;
        } else {
            obj6 = shape;
        }
        if (i27 & i66 == 0) {
            if (i11 & 128 == 0) {
                changed = restartGroup.changed(colors) ? 8388608 : 4194304;
            } else {
                obj4 = colors;
            }
            $dirty2 |= changed;
        } else {
            obj4 = colors;
        }
        int i32 = i11 & 256;
        i17 = 100663296;
        if (i32 != 0) {
            $dirty2 |= i17;
            obj12 = interactionSource;
        } else {
            if (i27 & i17 == 0) {
                i17 = restartGroup.changed(interactionSource) ? 67108864 : 33554432;
                $dirty2 |= i17;
            } else {
                obj12 = interactionSource;
            }
        }
        if ($dirty2 & i == 38347922) {
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
                        obj9 = i19 != 0 ? value : obj8;
                        obj7 = i4 != 0 ? value : obj10;
                        if (i11 & 64 != 0) {
                            obj13 = value;
                            $dirty = $dirty2;
                        } else {
                            obj13 = obj6;
                            $dirty = $dirty2;
                        }
                        if (i11 & 128 != 0) {
                            composer2 = restartGroup;
                            i7 = 2;
                            obj11 = NavigationDrawerItemDefaults.INSTANCE.colors-oq7We08(0, obj4, 0, value, 0, i19, 0, i4, 0, restartGroup, 0);
                            restartGroup = composer2;
                            $dirty &= obj38;
                        } else {
                            i7 = 2;
                            obj11 = colors;
                        }
                        if (i32 != 0) {
                            obj4 = obj11;
                            i4 = i37;
                            colors2 = obj13;
                            i8 = $dirty;
                        } else {
                            i4 = interactionSource;
                            obj4 = obj11;
                            colors2 = obj13;
                            i8 = $dirty;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i11 & 64 != 0) {
                            $dirty2 &= i67;
                        }
                        if (i11 & 128 != 0) {
                            i4 = obj12;
                            obj9 = obj8;
                            obj7 = obj10;
                            colors2 = obj6;
                            i7 = 2;
                            i8 = i30;
                            modifier3 = anon;
                        } else {
                            i4 = obj12;
                            modifier3 = anon;
                            obj9 = obj8;
                            obj7 = obj10;
                            i7 = 2;
                            i8 = $dirty2;
                            colors2 = obj6;
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
                obj34 = obj4;
                obj32 = anon3;
                super(obj9, obj34, traceInProgress, obj7, label);
                i42 &= i55;
                i18 = i8;
                SurfaceKt.Surface-d85dljk(selected, onClick, SizeKt.fillMaxWidth$default(SizeKt.heightIn-VpY3zN4$default(SemanticsModifierKt.semantics$default(modifier3, false, (Function1)NavigationDrawerKt.NavigationDrawerItem.1.INSTANCE, i54, i57), NavigationDrawerTokens.INSTANCE.getActiveIndicatorHeight-D9Ej5fM(), i60, i7, i57), i60, i54, i57), false, colors2, (Color)obj4.containerColor(traceInProgress, restartGroup, i47 |= i52).getValue().unbox-impl(), i43, 0, i52, 0, 0, 0, i4, (Function2)ComposableLambdaKt.rememberComposableLambda(191488423, i54, obj32, restartGroup, 54), restartGroup, i24 | i43);
                composer = restartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj3 = colors2;
                i10 = i4;
                navigationDrawerItemColors = navigationDrawerItemColors2;
                shape2 = i2;
                obj2 = obj9;
                obj14 = obj7;
            } else {
                restartGroup.skipToGroupEnd();
                i18 = $dirty2;
                navigationDrawerItemColors = obj4;
                shape2 = anon;
                obj14 = obj10;
                composer = restartGroup;
                obj3 = obj6;
                i10 = obj12;
                obj2 = obj8;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new NavigationDrawerKt.NavigationDrawerItem.3(label, selected, onClick, shape2, obj2, obj14, obj3, navigationDrawerItemColors, i10, $changed, i12);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void PermanentDrawerSheet-afqeVBk(Modifier modifier, Shape drawerShape, long drawerContainerColor, long drawerContentColor, float drawerTonalElevation, WindowInsets windowInsets, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i10) {
        String string-2EP1pXo;
        int windowInsets3;
        int defaultsInvalid;
        int iNSTANCE;
        int permanentDrawerElevation-D9Ej5fM;
        Object $composer2;
        int $dirty2;
        Object $dirty;
        long l3;
        Object anon;
        Object obj3;
        int i;
        long l2;
        boolean traceInProgress;
        Object str;
        int i7;
        long standardContainerColor;
        float f2;
        Object obj5;
        int changed3;
        int i6;
        int changed;
        Object rememberedValue;
        long contentColorFor-ek8zF_U;
        int windowInsets2;
        Object obj;
        float semantics$default;
        int i2;
        Object obj2;
        int changed2;
        Object obj4;
        int i5;
        int i3;
        long l;
        float f;
        Composer composer;
        Composer composer2;
        int i8;
        int i4;
        long l4;
        int obj35;
        final int i50 = obj36;
        Composer restartGroup = i10.startRestartGroup(-1733353241);
        ComposerKt.sourceInformation(restartGroup, "C(PermanentDrawerSheet)P(5,3,1:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.unit.Dp,6)734@30666L22,735@30722L37,737@30881L12,740@30972L33,744@31114L30,741@31010L266:NavigationDrawer.kt#uh7d8r");
        $dirty2 = obj36;
        int i17 = obj37 & 1;
        if (i17 != 0) {
            $dirty2 |= 6;
            obj3 = modifier;
        } else {
            if (i50 & 6 == 0) {
                i = restartGroup.changed(modifier) ? 4 : 2;
                $dirty2 |= i;
            } else {
                obj3 = modifier;
            }
        }
        int i28 = obj37 & 2;
        if (i28 != 0) {
            $dirty2 |= 48;
            str = drawerShape;
        } else {
            if (i50 & 48 == 0) {
                i7 = restartGroup.changed(drawerShape) ? 32 : 16;
                $dirty2 |= i7;
            } else {
                str = drawerShape;
            }
        }
        if (i50 & 384 == 0) {
            if (obj37 & 4 == 0) {
                changed3 = restartGroup.changed(drawerContainerColor) ? 256 : 128;
            } else {
                standardContainerColor = drawerContainerColor;
            }
            $dirty2 |= changed3;
        } else {
            standardContainerColor = drawerContainerColor;
        }
        if (i50 & 3072 == 0) {
            if (obj37 & 8 == 0) {
                i6 = restartGroup.changed(drawerTonalElevation) ? 2048 : 1024;
            } else {
                contentColorFor-ek8zF_U = drawerTonalElevation;
            }
            $dirty2 |= i6;
        } else {
            contentColorFor-ek8zF_U = drawerTonalElevation;
        }
        rememberedValue = obj37 & 16;
        if (rememberedValue != 0) {
            $dirty2 |= 24576;
            semantics$default = content;
        } else {
            if (i50 & 24576 == 0) {
                i2 = restartGroup.changed(content) ? 16384 : 8192;
                $dirty2 |= i2;
            } else {
                semantics$default = content;
            }
        }
        if (i53 &= i50 == 0) {
            if (obj37 & 32 == 0) {
                changed2 = restartGroup.changed($composer) ? 131072 : 65536;
            } else {
                obj2 = $composer;
            }
            $dirty2 |= changed2;
        } else {
            obj2 = $composer;
        }
        i5 = 1572864;
        if (obj37 & 64 != 0) {
            $dirty2 |= i5;
            obj4 = $changed;
        } else {
            if (i50 & i5 == 0) {
                i5 = restartGroup.changedInstance($changed) ? 1048576 : 524288;
                $dirty2 |= i5;
            } else {
                obj4 = $changed;
            }
        }
        if ($dirty2 & i3 == 599186) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                i3 = -458753;
                int i19 = 6;
                if (i50 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i17 != 0) {
                            obj3 = defaultsInvalid;
                        }
                        if (i28 != 0) {
                            str = defaultsInvalid;
                        }
                        if (obj37 & 4 != 0) {
                            standardContainerColor = DrawerDefaults.INSTANCE.getStandardContainerColor(restartGroup, i19);
                            $dirty2 &= -897;
                        }
                        if (obj37 & 8 != 0) {
                            contentColorFor-ek8zF_U = ColorSchemeKt.contentColorFor-ek8zF_U(standardContainerColor, obj8, restartGroup);
                            $dirty2 &= -7169;
                        }
                        if (rememberedValue != 0) {
                            semantics$default = permanentDrawerElevation-D9Ej5fM;
                        }
                        if (obj37 & 32 != 0) {
                            $dirty2 &= i3;
                            obj2 = str;
                            obj4 = standardContainerColor;
                            l = contentColorFor-ek8zF_U;
                            f = semantics$default;
                            obj = windowInsets4;
                            windowInsets3 = -1733353241;
                        } else {
                            obj4 = standardContainerColor;
                            l = contentColorFor-ek8zF_U;
                            f = semantics$default;
                            obj = obj2;
                            windowInsets3 = -1733353241;
                            obj2 = str;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (obj37 & 4 != 0) {
                            $dirty2 &= -897;
                        }
                        if (obj37 & 8 != 0) {
                            $dirty2 &= -7169;
                        }
                        if (obj37 & 32 != 0) {
                            $dirty2 = i14;
                            obj4 = standardContainerColor;
                            l = contentColorFor-ek8zF_U;
                            f = semantics$default;
                            obj = obj2;
                            windowInsets3 = -1733353241;
                            obj2 = str;
                        } else {
                            obj4 = standardContainerColor;
                            l = contentColorFor-ek8zF_U;
                            f = semantics$default;
                            obj = obj2;
                            windowInsets3 = -1733353241;
                            obj2 = str;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(windowInsets3, $dirty2, -1, "androidx.compose.material3.PermanentDrawerSheet (NavigationDrawer.kt:739)");
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
                NavigationDrawerKt.DrawerSheet-7zSek6w(0, obj, SemanticsModifierKt.semantics$default(obj3, $i$f$getNavigationMenu8iCLdWM, (Function1)anon, 1, 0), obj2, obj4, i3, l, obj18, f, $changed, restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer2 = obj3;
                obj5 = obj;
                l3 = obj4;
                l2 = l;
                f2 = f;
                windowInsets2 = $dirty2;
                $dirty = obj2;
            } else {
                restartGroup.skipToGroupEnd();
                windowInsets2 = $dirty2;
                $dirty = str;
                l2 = l4;
                composer2 = restartGroup;
                $composer2 = obj3;
                l3 = standardContainerColor;
                f2 = semantics$default;
                obj5 = obj2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            string-2EP1pXo = new NavigationDrawerKt.PermanentDrawerSheet.2($composer2, $dirty, l3, obj3, l2, str, f2, obj5, $changed, i50, obj37);
            endRestartGroup.updateScope((Function2)string-2EP1pXo);
        }
    }

    public static final void PermanentNavigationDrawer(Function2<? super Composer, ? super Integer, Unit> drawerContent, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i6) {
        int traceInProgress2;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv;
        Object materialized$iv$iv;
        int $dirty;
        Object obj2;
        int $dirty2;
        Object modifier3;
        boolean $i$f$Box;
        int i4;
        int i;
        int i12;
        boolean traceInProgress;
        Composer composer2;
        Object valueOf2;
        Object maybeCachedBoxMeasurePolicy;
        Object str;
        Composer composer6;
        Integer valueOf;
        int i20;
        int i16;
        int start;
        androidx.compose.ui.Alignment.Vertical top;
        androidx.compose.ui.layout.MeasurePolicy rowMeasurePolicy;
        int i21;
        int i10;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap2;
        int currentCompositeKeyHash;
        Object obj;
        int i17;
        Modifier modifier2;
        Function0 function02;
        int i19;
        int i11;
        int i18;
        int i14;
        int i8;
        int i9;
        RowScopeInstance rowScopeInstance;
        Composer $composer2;
        int i13;
        Modifier modifier5;
        Composer composer4;
        int i2;
        int i5;
        int i3;
        int i22;
        Alignment alignment;
        int i23;
        Composer composer5;
        int i15;
        Function0 function0;
        int i7;
        BoxScopeInstance boxScopeInstance;
        int propagateMinConstraints$iv;
        Composer composer;
        Modifier modifier4;
        Composer composer3;
        int obj48;
        androidx.compose.ui.Modifier.Companion obj50;
        materialized$iv$iv = drawerContent;
        final Object obj3 = content;
        i4 = $changed;
        traceInProgress2 = -276843608;
        maybeCachedBoxMeasurePolicy = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(maybeCachedBoxMeasurePolicy, "C(PermanentNavigationDrawer)P(1,2)532@21415L85:NavigationDrawer.kt#uh7d8r");
        $dirty = $changed;
        if (i6 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (i4 & 6 == 0) {
                i = maybeCachedBoxMeasurePolicy.changedInstance(materialized$iv$iv) ? 4 : 2;
                $dirty |= i;
            }
        }
        i12 = i6 & 2;
        if (i12 != 0) {
            $dirty |= 48;
            str = modifier;
        } else {
            if (i4 & 48 == 0) {
                i20 = maybeCachedBoxMeasurePolicy.changed(modifier) ? 32 : 16;
                $dirty |= i20;
            } else {
                str = modifier;
            }
        }
        if (i6 & 4 != 0) {
            $dirty |= 384;
        } else {
            if (i4 & 384 == 0) {
                i16 = maybeCachedBoxMeasurePolicy.changedInstance(obj3) ? 256 : 128;
                $dirty |= i16;
            }
        }
        int i50 = $dirty;
        if (i50 & 147 == 146) {
            if (!maybeCachedBoxMeasurePolicy.getSkipping()) {
                if (i12 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = str;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, i50, -1, "androidx.compose.material3.PermanentNavigationDrawer (NavigationDrawer.kt:531)");
                }
                Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(modifier3, 0, 1, 0);
                int i40 = 0;
                valueOf = 0;
                ComposerKt.sourceInformationMarkerStart(maybeCachedBoxMeasurePolicy, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                i10 = 0;
                String str6 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                ComposerKt.sourceInformationMarkerStart(maybeCachedBoxMeasurePolicy, -1323940314, str6);
                int i59 = 0;
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(maybeCachedBoxMeasurePolicy, i59);
                obj50 = i59;
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(maybeCachedBoxMeasurePolicy, fillMaxSize$default);
                modifier2 = fillMaxSize$default;
                Function0 function03 = constructor;
                i17 = 0;
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
                i18 = i28;
                ComposerKt.sourceInformationMarkerStart(valueOf2, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                i49 |= 6;
                Composer composer8 = valueOf2;
                i9 = 0;
                rowScopeInstance = iNSTANCE;
                modifier5 = materializeModifier2;
                ComposerKt.sourceInformationMarkerStart(valueOf2, -882916661, "C533@21453L15,534@21477L17:NavigationDrawer.kt#uh7d8r");
                materialized$iv$iv.invoke(valueOf2, Integer.valueOf(i50 & 14));
                i14 = i30;
                ComposerKt.sourceInformationMarkerStart(valueOf2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                androidx.compose.ui.Modifier.Companion companion = Modifier.Companion;
                Alignment topStart = Alignment.Companion.getTopStart();
                i2 = i38;
                $i$f$Box = 0;
                i5 = i44;
                i22 = 0;
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
                    composer = valueOf2;
                    if (!Intrinsics.areEqual(composer10.rememberedValue(), Integer.valueOf(obj48))) {
                        composer10.updateRememberedValue(Integer.valueOf(obj48));
                        constructor-impl2.apply(Integer.valueOf(obj48), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer2 = composer10;
                    }
                } else {
                    propagateMinConstraints$iv = $i$f$Box;
                    composer = valueOf2;
                }
                Updater.set-impl(constructor-impl2, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                Composer composer7 = composer;
                i4 = 0;
                i11 = i34;
                ComposerKt.sourceInformationMarkerStart(composer7, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                i43 |= 6;
                composer5 = composer7;
                i7 = 0;
                boxScopeInstance = iNSTANCE2;
                modifier4 = materializeModifier;
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
                obj2 = obj;
            } else {
                maybeCachedBoxMeasurePolicy.skipToGroupEnd();
                $composer2 = maybeCachedBoxMeasurePolicy;
                obj2 = str;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new NavigationDrawerKt.PermanentNavigationDrawer.2(drawerContent, obj2, obj3, $changed, i6);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    private static final void Scrim-Bx497Mc(boolean open, Function0<Unit> onClose, Function0<Float> fraction, long color, Composer $composer, int $changed) {
        Object closeDrawer;
        boolean traceInProgress;
        Object anon2;
        Modifier companion4;
        int $dirty;
        int i8;
        int i;
        int i4;
        int i11;
        int skipping;
        boolean traceInProgress2;
        int $i$f$getCloseDrawer8iCLdWM;
        Object anon;
        int i2;
        int i12;
        int i9;
        int i10;
        Composer composer2;
        int i3;
        int rememberedValue;
        int empty;
        int i6;
        Composer composer;
        Object rememberedValue2;
        Object companion3;
        int i5;
        int companion;
        int i7;
        Composer.Companion companion2;
        companion4 = open;
        final Object obj = onClose;
        final Object obj2 = fraction;
        final long l = color;
        final int i13 = obj27;
        traceInProgress = 2106487387;
        Composer restartGroup = $changed.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(Scrim)P(3,2,1,0:c#ui.graphics.Color)1136@46594L30,1151@47092L39,1151@47041L90:NavigationDrawer.kt#uh7d8r");
        if (i13 & 6 == 0) {
            i8 = restartGroup.changed(companion4) ? 4 : 2;
            $dirty |= i8;
        }
        i2 = 32;
        if (i13 & 48 == 0) {
            i = restartGroup.changedInstance(obj) ? i2 : 16;
            $dirty |= i;
        }
        if (i13 & 384 == 0) {
            i4 = restartGroup.changedInstance(obj2) ? 256 : 128;
            $dirty |= i4;
        }
        if (i13 & 3072 == 0) {
            i11 = restartGroup.changed(l) ? 2048 : 1024;
            $dirty |= i11;
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
                if (companion4) {
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1784753370, str3);
                    i9 = $dirty & 112 == i2 ? 1 : 0;
                    Composer composer3 = restartGroup;
                    companion = 0;
                    Object rememberedValue3 = composer3.rememberedValue();
                    i7 = 0;
                    if (i9 == 0) {
                        if (rememberedValue3 == Composer.Companion.getEmpty()) {
                            int i31 = 0;
                            anon = new NavigationDrawerKt.Scrim.dismissDrawer.1.1(obj, 0);
                            composer3.updateRememberedValue((Function2)anon);
                        } else {
                            anon = rememberedValue3;
                            composer = composer3;
                        }
                    } else {
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1784750402, str3);
                    i10 = $dirty & 112 == 32 ? 1 : 0;
                    composer2 = restartGroup;
                    i3 = 0;
                    rememberedValue2 = composer2.rememberedValue();
                    i5 = 0;
                    if (changed3 |= i10 == 0) {
                        if (rememberedValue2 == Composer.Companion.getEmpty()) {
                            empty = 0;
                            anon2 = new NavigationDrawerKt.Scrim.dismissDrawer.2.1(string-2EP1pXo, obj);
                            composer2.updateRememberedValue((Function1)anon2);
                        } else {
                            anon2 = rememberedValue2;
                        }
                    } else {
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    companion4 = SemanticsModifierKt.semantics(SuspendingPointerInputFilterKt.pointerInput((Modifier)Modifier.Companion, obj, (Function2)anon), true, (Function1)anon2);
                } else {
                    companion4 = Modifier.Companion;
                }
                restartGroup.endReplaceGroup();
                int i24 = 1;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1784741206, str3);
                i12 = $dirty & 7168 == 2048 ? i24 : 0;
                rememberedValue2 = $dirty & 896 == 256 ? i24 : 0;
                composer2 = restartGroup;
                i3 = 0;
                rememberedValue = composer2.rememberedValue();
                i6 = 0;
                if (i12 |= rememberedValue2 == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        rememberedValue2 = 0;
                        companion3 = string-2EP1pXo;
                        closeDrawer = new NavigationDrawerKt.Scrim.1.1(l, obj5, obj2);
                        composer2.updateRememberedValue((Function1)closeDrawer);
                    } else {
                        companion3 = string-2EP1pXo;
                        closeDrawer = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                CanvasKt.Canvas(SizeKt.fillMaxSize$default((Modifier)Modifier.Companion, 0, i24, 0).then(companion4), (Function1)closeDrawer, restartGroup, 0);
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
