package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Alignment.Companion;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode.Companion;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0084\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000c\u001a;\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0011\u0010\t\u001a\r\u0012\u0004\u0012\u00020\u00060\n¢\u0006\u0002\u0008\u000b2\u0011\u0010\u000c\u001a\r\u0012\u0004\u0012\u00020\u00060\n¢\u0006\u0002\u0008\u000bH\u0003¢\u0006\u0002\u0010\r\u001aò\u0001\u0010\u000e\u001a\u00020\u00062\u0011\u0010\t\u001a\r\u0012\u0004\u0012\u00020\u00060\n¢\u0006\u0002\u0008\u000b2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00060\n¢\u0006\u0002\u0008\u000b2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00060\n¢\u0006\u0002\u0008\u000b2\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00142\u0019\u0008\u0002\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00060\u0016¢\u0006\u0002\u0008\u000b2\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00192\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u00192\u0008\u0008\u0002\u0010\u001d\u001a\u00020\u00192\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u001f2\u0008\u0008\u0002\u0010 \u001a\u00020\u001f2\u0008\u0008\u0002\u0010!\u001a\u00020\"2\u0008\u0008\u0002\u0010#\u001a\u00020\u00012\u0008\u0008\u0002\u0010$\u001a\u00020\u001f2\u0008\u0008\u0002\u0010%\u001a\u00020\u001f2\u0008\u0008\u0002\u0010&\u001a\u00020\u001fH\u0007ø\u0001\u0000¢\u0006\u0004\u0008'\u0010(\u001aH\u0010)\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\u00082\u0006\u0010+\u001a\u00020,2\u000e\u0008\u0002\u0010-\u001a\u0008\u0012\u0004\u0012\u00020/0.2\u0014\u0008\u0002\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\u00190\u00162\u0008\u0008\u0002\u00101\u001a\u00020\u0017H\u0007\u001a[\u00102\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00122\u0011\u00103\u001a\r\u0012\u0004\u0012\u00020\u00060\n¢\u0006\u0002\u0008\u000b2\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u0002050\u00162\u001d\u00106\u001a\u0019\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u000607¢\u0006\u0002\u0008\u000bH\u0003¢\u0006\u0002\u00108\u001a\u001c\u00109\u001a\u00020:2\n\u0010;\u001a\u0006\u0012\u0002\u0008\u00030<2\u0006\u0010=\u001a\u00020>H\u0000\u001a0\u0010?\u001a\u00020\u00062\u0006\u0010@\u001a\u00020\u001f2\u000c\u0010A\u001a\u0008\u0012\u0004\u0012\u00020\u00060\n2\u0006\u0010B\u001a\u00020\u0019H\u0003ø\u0001\u0000¢\u0006\u0004\u0008C\u0010D\u001aE\u0010E\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\u00082\u000e\u0008\u0002\u0010-\u001a\u0008\u0012\u0004\u0012\u00020/0.2\u0014\u0008\u0002\u0010F\u001a\u000e\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\u00190\u00162\u0008\u0008\u0002\u00101\u001a\u00020\u0017H\u0007¢\u0006\u0002\u0010G\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006H²\u0006\n\u0010I\u001a\u00020/X\u008a\u0084\u0002²\u0006\n\u0010J\u001a\u00020/X\u008a\u0084\u0002", d2 = {"AnimationSlideOffset", "Landroidx/compose/ui/unit/Dp;", "F", "PositionalThreshold", "VelocityThreshold", "BackLayerTransition", "", "target", "Landroidx/compose/material/BackdropValue;", "appBar", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "content", "(Landroidx/compose/material/BackdropValue;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "BackdropScaffold", "backLayerContent", "frontLayerContent", "modifier", "Landroidx/compose/ui/Modifier;", "scaffoldState", "Landroidx/compose/material/BackdropScaffoldState;", "snackbarHost", "Lkotlin/Function1;", "Landroidx/compose/material/SnackbarHostState;", "gesturesEnabled", "", "peekHeight", "headerHeight", "persistentAppBar", "stickyFrontLayer", "backLayerBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "backLayerContentColor", "frontLayerShape", "Landroidx/compose/ui/graphics/Shape;", "frontLayerElevation", "frontLayerBackgroundColor", "frontLayerContentColor", "frontLayerScrimColor", "BackdropScaffold-0hNv9B8", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/material/BackdropScaffoldState;Lkotlin/jvm/functions/Function3;ZFFZZJJLandroidx/compose/ui/graphics/Shape;FJJJLandroidx/compose/runtime/Composer;III)V", "BackdropScaffoldState", "initialValue", "density", "Landroidx/compose/ui/unit/Density;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmValueChange", "snackbarHostState", "BackdropStack", "backLayer", "calculateBackLayerConstraints", "Landroidx/compose/ui/unit/Constraints;", "frontLayer", "Lkotlin/Function2;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;I)V", "ConsumeSwipeNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "state", "Landroidx/compose/material/AnchoredDraggableState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "Scrim", "color", "onDismiss", "visible", "Scrim-3J-VO9M", "(JLkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "rememberBackdropScaffoldState", "confirmStateChange", "(Landroidx/compose/material/BackdropValue;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/material/SnackbarHostState;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/BackdropScaffoldState;", "material_release", "alpha", "animationProgress"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class BackdropScaffoldKt {

    private static final float AnimationSlideOffset;
    private static final float PositionalThreshold;
    private static final float VelocityThreshold;
    static {
        int i4 = 0;
        BackdropScaffoldKt.AnimationSlideOffset = Dp.constructor-impl((float)i);
        int i5 = 0;
        BackdropScaffoldKt.VelocityThreshold = Dp.constructor-impl((float)i2);
        int i6 = 0;
        BackdropScaffoldKt.PositionalThreshold = Dp.constructor-impl((float)i3);
    }

    private static final void BackLayerTransition(androidx.compose.material.BackdropValue target, Function2<? super Composer, ? super Integer, Unit> appBar, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        Object traceInProgress2;
        Function0 factory$iv$iv$iv;
        int materialized$iv$iv;
        int i11;
        int $dirty;
        boolean $dirty2;
        Object obj3;
        boolean traceInProgress;
        Integer $this$BackLayerTransition_u24lambda_u2411;
        int i23;
        int i2;
        int i8;
        int iNSTANCE;
        boolean currentCompositionLocalMap2;
        int i27;
        Composer composer2;
        Object currentCompositionLocalMap3;
        int i4;
        Function0 factory$iv$iv$iv2;
        Object $i$a$CacheBackdropScaffoldKt$BackLayerTransition$1$4;
        int empty;
        Object $i$a$CacheBackdropScaffoldKt$BackLayerTransition$1$5;
        boolean changed;
        Composer composer10;
        Composer composer3;
        Object maybeCachedBoxMeasurePolicy3;
        Composer restartGroup;
        Alignment topStart2;
        int i31;
        Function0 factory$iv$iv$iv3;
        Object it$iv2;
        Object it$iv;
        boolean currentCompositionLocalMap;
        int i28;
        androidx.compose.ui.layout.MeasurePolicy maybeCachedBoxMeasurePolicy;
        Composer composer7;
        Composer composer4;
        Object maybeCachedBoxMeasurePolicy2;
        Object topStart;
        int i12;
        Object propagateMinConstraints$iv2;
        int i26;
        int i20;
        int i29;
        int i3;
        int i7;
        int currentCompositeKeyHash;
        int i16;
        int i24;
        androidx.compose.ui.Modifier.Companion companion3;
        Composer composer5;
        int i30;
        int i5;
        Composer composer9;
        int i18;
        BoxScopeInstance iNSTANCE2;
        Function0 function0;
        int i14;
        int i15;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv2;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy2;
        int i;
        int i13;
        Modifier modifier3;
        Composer composer11;
        int i17;
        int companion2;
        Modifier modifier2;
        Composer.Companion companion;
        int invalid$iv;
        int i21;
        boolean invalid$iv2;
        int i19;
        Object obj;
        Composer.Companion companion4;
        Composer.Companion propagateMinConstraints$iv;
        Object obj2;
        Alignment contentAlignment$iv;
        Function0 function02;
        Modifier modifier;
        Composer composer6;
        float animationSlideOffset;
        androidx.compose.runtime.CompositionLocalMap map;
        Function0 function03;
        int i6;
        int i9;
        Composer composer;
        int i25;
        int i10;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy;
        Composer composer8;
        int i22;
        State obj64;
        traceInProgress2 = target;
        final Object obj4 = appBar;
        final Object obj5 = content;
        final int i42 = $changed;
        materialized$iv$iv = -950970976;
        restartGroup = $composer.startRestartGroup(materialized$iv$iv);
        ComposerKt.sourceInformation(restartGroup, "C(BackLayerTransition)P(2)551@22995L112,*554@23157L7,556@23203L1485:BackdropScaffold.kt#jmzs0o");
        if (i42 & 6 == 0) {
            i23 = restartGroup.changed(traceInProgress2) ? 4 : 2;
            $dirty |= i23;
        }
        if (i42 & 48 == 0) {
            i2 = restartGroup.changedInstance(obj4) ? 32 : 16;
            $dirty |= i2;
        }
        if (i42 & 384 == 0) {
            i8 = restartGroup.changedInstance(obj5) ? 256 : 128;
            $dirty |= i8;
        }
        i28 = $dirty;
        if (i28 & 147 == 146) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(materialized$iv$iv, i28, -1, "androidx.compose.material.BackLayerTransition (BackdropScaffold.kt:548)");
                }
                i11 = traceInProgress2 == BackdropValue.Revealed ? 0 : 1073741824;
                TweenSpec tweenSpec2 = new TweenSpec(0, 0, 0, 7, 0);
                State animateFloatAsState = AnimateAsStateKt.animateFloatAsState(i11, (AnimationSpec)tweenSpec2, 0, 0, 0, restartGroup, 48, 28);
                int i45 = 0;
                int i52 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                int i46 = 0;
                $this$BackLayerTransition_u24lambda_u2411 = (Density)restartGroup.consume((CompositionLocal)CompositionLocalsKt.getLocalDensity()).toPx-0680j_4(BackdropScaffoldKt.AnimationSlideOffset);
                int i53 = $i$a$WithBackdropScaffoldKt$BackLayerTransition$animationSlideOffset$1;
                String str3 = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo";
                ComposerKt.sourceInformationMarkerStart(restartGroup, 733328855, str3);
                androidx.compose.ui.Modifier.Companion companion13 = Modifier.Companion;
                topStart = Alignment.Companion.getTopStart();
                propagateMinConstraints$iv2 = 0;
                maybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(topStart, propagateMinConstraints$iv2);
                i20 = 0;
                String $changed$iv4 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, $changed$iv4);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, 0);
                currentCompositionLocalMap2 = restartGroup.getCurrentCompositionLocalMap();
                i16 = i56;
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(restartGroup, (Modifier)companion13);
                companion3 = companion13;
                Function0 function04 = constructor2;
                i24 = 0;
                i5 = i28;
                String $dirty3 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, $dirty3);
                if (!applier3 instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                restartGroup.startReusableNode();
                if (restartGroup.getInserting()) {
                    restartGroup.createNode(function04);
                } else {
                    factory$iv$iv$iv3 = function04;
                    restartGroup.useNode();
                }
                composer5 = restartGroup;
                Composer constructor-impl2 = Updater.constructor-impl(composer5);
                int i96 = 0;
                function0 = factory$iv$iv$iv3;
                Updater.set-impl(constructor-impl2, maybeCachedBoxMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i97 = 0;
                Composer composer16 = constructor-impl2;
                int i100 = 0;
                if (!composer16.getInserting()) {
                    localMap$iv$iv2 = currentCompositionLocalMap2;
                    measurePolicy2 = maybeCachedBoxMeasurePolicy3;
                    if (!Intrinsics.areEqual(composer16.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer16.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl2.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer3 = composer16;
                    }
                } else {
                    localMap$iv$iv2 = currentCompositionLocalMap2;
                    measurePolicy2 = maybeCachedBoxMeasurePolicy3;
                }
                Updater.set-impl(constructor-impl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                composer10 = composer5;
                i18 = i50;
                String $changed$iv3 = "C73@3429L9:Box.kt#2w3rfo";
                ComposerKt.sourceInformationMarkerStart(composer10, -2146769399, $changed$iv3);
                iNSTANCE2 = BoxScopeInstance.INSTANCE;
                i99 |= 6;
                Composer composer17 = composer10;
                i = 0;
                modifier3 = materializeModifier2;
                ComposerKt.sourceInformationMarkerStart(composer10, -1148278766, "C559@23267L351,566@23650L218,557@23217L694,577@24032L353,584@24417L221,574@23920L762:BackdropScaffold.kt#jmzs0o");
                i15 = i63;
                String $i$a$LayoutBoxKt$Box$1$iv = "CC(remember):BackdropScaffold.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(composer10, -452682761, $i$a$LayoutBoxKt$Box$1$iv);
                Composer composer18 = composer10;
                int i103 = 0;
                it$iv2 = composer18.rememberedValue();
                companion4 = 0;
                if (!composer10.changed(animateFloatAsState)) {
                    contentAlignment$iv = topStart;
                    if (it$iv2 == Composer.Companion.getEmpty()) {
                        int contentAlignment$iv2 = 0;
                        obj2 = it$iv2;
                        it$iv2 = new BackdropScaffoldKt.BackLayerTransition.1.1.1(animateFloatAsState);
                        composer18.updateRememberedValue((Function3)it$iv2);
                    } else {
                        obj2 = it$iv2;
                        composer7 = composer18;
                    }
                } else {
                    contentAlignment$iv = topStart;
                }
                ComposerKt.sourceInformationMarkerEnd(composer10);
                ComposerKt.sourceInformationMarkerStart(composer10, -452670638, $i$a$LayoutBoxKt$Box$1$iv);
                Composer composer15 = composer10;
                int i101 = 0;
                it$iv = composer15.rememberedValue();
                int i105 = 0;
                if (changed6 |= changed7 == 0) {
                    propagateMinConstraints$iv = propagateMinConstraints$iv2;
                    if (it$iv == Composer.Companion.getEmpty()) {
                        propagateMinConstraints$iv2 = 0;
                        obj = it$iv;
                        it$iv = new BackdropScaffoldKt.BackLayerTransition.1.2.1($this$BackLayerTransition_u24lambda_u2411, animateFloatAsState);
                        composer15.updateRememberedValue((Function1)it$iv);
                    } else {
                        obj = it$iv;
                    }
                } else {
                    propagateMinConstraints$iv = propagateMinConstraints$iv2;
                }
                ComposerKt.sourceInformationMarkerEnd(composer10);
                Modifier graphicsLayer2 = GraphicsLayerModifierKt.graphicsLayer(LayoutModifierKt.layout((Modifier)Modifier.Companion, (Function3)it$iv2), (Function1)it$iv);
                ComposerKt.sourceInformationMarkerStart(composer10, 733328855, str3);
                Alignment topStart3 = Alignment.Companion.getTopStart();
                int i102 = i73;
                int $changed$iv5 = 0;
                companion = i80;
                maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(topStart3, $changed$iv5);
                int i109 = 0;
                int i110 = $changed$iv5;
                ComposerKt.sourceInformationMarkerStart(composer10, -1323940314, $changed$iv4);
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer10, 0);
                currentCompositionLocalMap = composer10.getCurrentCompositionLocalMap();
                Alignment alignment = topStart3;
                Modifier modifier4 = graphicsLayer2;
                Function0 function06 = constructor3;
                int i112 = 0;
                ComposerKt.sourceInformationMarkerStart(composer10, -692256719, $dirty3);
                if (!applier2 instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                composer10.startReusableNode();
                if (composer10.getInserting()) {
                    composer10.createNode(function06);
                } else {
                    factory$iv$iv$iv2 = function06;
                    composer10.useNode();
                }
                function03 = factory$iv$iv$iv2;
                Composer constructor-impl = Updater.constructor-impl(composer10);
                int i113 = 0;
                Updater.set-impl(constructor-impl, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i116 = 0;
                Composer composer20 = constructor-impl;
                int i117 = 0;
                if (!composer20.getInserting()) {
                    localMap$iv$iv = currentCompositionLocalMap;
                    measurePolicy = maybeCachedBoxMeasurePolicy2;
                    if (!Intrinsics.areEqual(composer20.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                        composer20.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer4 = composer20;
                    }
                } else {
                    localMap$iv$iv = currentCompositionLocalMap;
                    measurePolicy = maybeCachedBoxMeasurePolicy2;
                }
                Updater.set-impl(constructor-impl, ComposedModifierKt.materializeModifier(composer10, graphicsLayer2), ComposeUiNode.Companion.getSetModifier());
                Composer composer12 = composer10;
                ComposerKt.sourceInformationMarkerStart(composer12, -2146769399, $changed$iv3);
                BoxScopeInstance iNSTANCE3 = BoxScopeInstance.INSTANCE;
                i115 |= 6;
                i25 = 0;
                i10 = i33;
                i22 = i75;
                Composer $i$a$LayoutBoxKt$Box$1$iv2 = composer;
                ComposerKt.sourceInformationMarkerStart($i$a$LayoutBoxKt$Box$1$iv2, 799556868, "C572@23893L8:BackdropScaffold.kt#jmzs0o");
                obj4.invoke($i$a$LayoutBoxKt$Box$1$iv2, Integer.valueOf(i34 &= 14));
                ComposerKt.sourceInformationMarkerEnd($i$a$LayoutBoxKt$Box$1$iv2);
                ComposerKt.sourceInformationMarkerEnd(composer12);
                composer10.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer10);
                ComposerKt.sourceInformationMarkerEnd(composer10);
                ComposerKt.sourceInformationMarkerEnd(composer10);
                ComposerKt.sourceInformationMarkerStart(composer10, -452658279, $i$a$LayoutBoxKt$Box$1$iv);
                changed = composer10.changed(animateFloatAsState);
                Composer composer14 = composer10;
                int i82 = 0;
                Object rememberedValue5 = composer14.rememberedValue();
                companion2 = 0;
                if (!changed) {
                    invalid$iv2 = changed;
                    if (rememberedValue5 == Composer.Companion.getEmpty()) {
                        companion = invalid$iv4;
                        $i$a$CacheBackdropScaffoldKt$BackLayerTransition$1$4 = new BackdropScaffoldKt.BackLayerTransition.1.4.1(animateFloatAsState);
                        composer14.updateRememberedValue((Function3)$i$a$CacheBackdropScaffoldKt$BackLayerTransition$1$4);
                    } else {
                        $i$a$CacheBackdropScaffoldKt$BackLayerTransition$1$4 = rememberedValue5;
                    }
                } else {
                    invalid$iv2 = changed;
                }
                ComposerKt.sourceInformationMarkerEnd(composer10);
                ComposerKt.sourceInformationMarkerStart(composer10, -452646091, $i$a$LayoutBoxKt$Box$1$iv);
                changed3 |= changed4;
                Composer composer13 = composer10;
                int i76 = 0;
                Object rememberedValue4 = composer13.rememberedValue();
                int i85 = 0;
                if (empty == 0) {
                    invalid$iv = empty;
                    if (rememberedValue4 == Composer.Companion.getEmpty()) {
                        companion2 = invalid$iv3;
                        $i$a$CacheBackdropScaffoldKt$BackLayerTransition$1$5 = new BackdropScaffoldKt.BackLayerTransition.1.5.1($this$BackLayerTransition_u24lambda_u2411, animateFloatAsState);
                        composer13.updateRememberedValue((Function1)$i$a$CacheBackdropScaffoldKt$BackLayerTransition$1$5);
                    } else {
                        $i$a$CacheBackdropScaffoldKt$BackLayerTransition$1$5 = rememberedValue4;
                    }
                } else {
                    invalid$iv = empty;
                }
                ComposerKt.sourceInformationMarkerEnd(composer10);
                Modifier graphicsLayer = GraphicsLayerModifierKt.graphicsLayer(LayoutModifierKt.layout((Modifier)Modifier.Companion, (Function3)$i$a$CacheBackdropScaffoldKt$BackLayerTransition$1$4), (Function1)$i$a$CacheBackdropScaffoldKt$BackLayerTransition$1$5);
                i4 = i93;
                restartGroup = 0;
                ComposerKt.sourceInformationMarkerStart(composer10, 733328855, str3);
                i17 = 0;
                obj64 = animateFloatAsState;
                ComposerKt.sourceInformationMarkerStart(composer10, -1323940314, $changed$iv4);
                currentCompositionLocalMap3 = composer10.getCurrentCompositionLocalMap();
                i29 = currentCompositeKeyHash2;
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer10, graphicsLayer);
                modifier2 = graphicsLayer;
                Function0 function05 = constructor;
                i7 = 0;
                ComposerKt.sourceInformationMarkerStart(composer10, -692256719, $dirty3);
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                composer10.startReusableNode();
                if (composer10.getInserting()) {
                    composer10.createNode(function05);
                } else {
                    factory$iv$iv$iv = function05;
                    composer10.useNode();
                }
                Composer constructor-impl3 = Updater.constructor-impl(composer10);
                int i95 = 0;
                function02 = factory$iv$iv$iv;
                Updater.set-impl(constructor-impl3, BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false), ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl3, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i108 = 0;
                Composer composer19 = constructor-impl3;
                int i111 = 0;
                if (!composer19.getInserting()) {
                    animationSlideOffset = $this$BackLayerTransition_u24lambda_u2411;
                    map = currentCompositionLocalMap3;
                    if (!Intrinsics.areEqual(composer19.rememberedValue(), Integer.valueOf(i29))) {
                        composer19.updateRememberedValue(Integer.valueOf(i29));
                        constructor-impl3.apply(Integer.valueOf(i29), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer2 = composer19;
                    }
                } else {
                    animationSlideOffset = $this$BackLayerTransition_u24lambda_u2411;
                    map = currentCompositionLocalMap3;
                }
                Updater.set-impl(constructor-impl3, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                $dirty2 = composer10;
                i27 = 0;
                ComposerKt.sourceInformationMarkerStart($dirty2, -2146769399, $changed$iv3);
                iNSTANCE = BoxScopeInstance.INSTANCE;
                i79 |= 6;
                composer9 = $dirty2;
                i13 = 0;
                i21 = i39;
                modifier = materializeModifier;
                ComposerKt.sourceInformationMarkerStart($dirty2, 800320739, "C590@24663L9:BackdropScaffold.kt#jmzs0o");
                obj5.invoke($dirty2, Integer.valueOf(i40 &= 14));
                ComposerKt.sourceInformationMarkerEnd($dirty2);
                ComposerKt.sourceInformationMarkerEnd($dirty2);
                composer10.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer10);
                ComposerKt.sourceInformationMarkerEnd(composer10);
                ComposerKt.sourceInformationMarkerEnd(composer10);
                ComposerKt.sourceInformationMarkerEnd(composer10);
                ComposerKt.sourceInformationMarkerEnd(composer10);
                composer5.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer5);
                ComposerKt.sourceInformationMarkerEnd(composer5);
                ComposerKt.sourceInformationMarkerEnd(composer5);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
                composer5 = restartGroup;
                i5 = i28;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer5.endRestartGroup();
        if (endRestartGroup != null) {
            materialized$iv$iv = new BackdropScaffoldKt.BackLayerTransition.2(target, obj4, obj5, i42);
            endRestartGroup.updateScope((Function2)materialized$iv$iv);
        } else {
            obj3 = target;
        }
    }

    private static final float BackLayerTransition$lambda$10(State<Float> $animationProgress$delegate) {
        int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (Number)$animationProgress$delegate.getValue().floatValue();
    }

    public static final void BackdropScaffold-0hNv9B8(Function2<? super Composer, ? super Integer, Unit> appBar, Function2<? super Composer, ? super Integer, Unit> backLayerContent, Function2<? super Composer, ? super Integer, Unit> frontLayerContent, Modifier modifier, androidx.compose.material.BackdropScaffoldState scaffoldState, Function3<? super androidx.compose.material.SnackbarHostState, ? super Composer, ? super Integer, Unit> snackbarHost, boolean gesturesEnabled, float peekHeight, float headerHeight, boolean persistentAppBar, boolean stickyFrontLayer, long backLayerBackgroundColor, long backLayerContentColor, Shape frontLayerShape, float frontLayerElevation, long frontLayerBackgroundColor, long frontLayerContentColor, long frontLayerScrimColor, Composer $composer, int $changed, int $changed1, int i22) {
        int changed9;
        int changed11;
        Object obj3;
        float f4;
        int skipping;
        int i2;
        int $dirty1;
        int defaultsInvalid;
        androidx.compose.ui.Modifier.Companion modifier4;
        int modifier3;
        long backLayerBackgroundColor2;
        float frontLayerElevation2;
        long l9;
        long $dirty14;
        Object endRestartGroup;
        Shape frontLayerShape2;
        int i17;
        Object it$iv;
        Object $i$a$CacheBackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1;
        boolean changed5;
        int changed4;
        long obj2;
        int i9;
        int iNSTANCE;
        int iNSTANCE2;
        int i21;
        int i27;
        int i4;
        int i24;
        int empty;
        androidx.compose.ui.Modifier.Companion companion;
        int $dirty2;
        Object $dirty;
        int $dirty13;
        int i3;
        int i5;
        int i10;
        androidx.compose.material.BackdropScaffoldState rememberBackdropScaffoldState;
        Object obj5;
        int i19;
        int i25;
        int i14;
        boolean z3;
        boolean z;
        long l2;
        long l10;
        long l3;
        long l7;
        long l6;
        Object snackbarHost3;
        long snackbarHost2;
        boolean z2;
        Object gesturesEnabled2;
        float f6;
        Object obj;
        float peekHeight2;
        float f;
        int $composer2;
        float f5;
        float headerHeight2;
        int i6;
        float f2;
        int persistentAppBar2;
        long persistentAppBar3;
        boolean stickyFrontLayer3;
        int stickyFrontLayer4;
        Object $dirty15;
        long l;
        Object anon;
        int changed6;
        int i13;
        int i18;
        int changed10;
        int i20;
        int $dirty12;
        androidx.compose.ui.Modifier.Companion i7;
        Shape modifier2;
        int changed8;
        int changed;
        float f3;
        int i15;
        int changed12;
        long l4;
        int backLayerContentColor2;
        int i11;
        long stickyFrontLayer2;
        int changed7;
        boolean frontLayerBackgroundColor2;
        long scaffoldState2;
        androidx.compose.material.AnchoredDraggableState anchoredDraggableState$material_release;
        int backLayerBackgroundColor3;
        long backLayerBackgroundColor4;
        int i;
        long i23;
        int i28;
        int i12;
        int surface-0d7_KjU;
        long frontLayerContentColor2;
        int frontLayerContentColor3;
        int changed2;
        int i16;
        int changed13;
        float frontLayerScrimColor2;
        int i8;
        int i26;
        int px-0680j_4;
        boolean changed3;
        Composer composer;
        long l5;
        Object obj4;
        ScopeUpdateScope scopeUpdateScope;
        long l8;
        androidx.compose.ui.Modifier.Companion obj44;
        Shape obj45;
        float obj46;
        Object obj48;
        int obj50;
        int obj51;
        androidx.compose.runtime.internal.ComposableLambda obj52;
        Composer obj53;
        int obj54;
        int obj55;
        int obj56;
        Object obj57;
        frontLayerShape2 = appBar;
        obj2 = backLayerContent;
        changed9 = obj65;
        i24 = obj66;
        empty = obj67;
        Composer restartGroup = obj64.startRestartGroup(113877443);
        ComposerKt.sourceInformation(restartGroup, "C(BackdropScaffold)P(!1,2,5,12,15,16,10,13:c#ui.unit.Dp,11:c#ui.unit.Dp,14,17,1:c#ui.graphics.Color,3:c#ui.graphics.Color,9,7:c#ui.unit.Dp,4:c#ui.graphics.Color,6:c#ui.graphics.Color,8:c#ui.graphics.Color)371@15931L40,378@16340L6,379@16391L41,380@16488L15,382@16634L6,383@16686L42,384@16789L20,387@16929L7,388@16952L47,388@16941L58,*392@17042L7,393@17116L7,395@17182L315,408@17568L100,418@17848L3899,415@17746L4001:BackdropScaffold.kt#jmzs0o");
        $dirty2 = obj65;
        $dirty13 = obj66;
        if (empty & 1 != 0) {
            $dirty2 |= 6;
        } else {
            if (changed9 & 6 == 0) {
                i19 = restartGroup.changedInstance(frontLayerShape2) ? 4 : 2;
                $dirty2 |= i19;
            }
        }
        if (empty & 2 != 0) {
            $dirty2 |= 48;
        } else {
            if (changed9 & 48 == 0) {
                i25 = restartGroup.changedInstance(obj2) ? 32 : 16;
                $dirty2 |= i25;
            }
        }
        if (empty & 4 != 0) {
            $dirty2 |= 384;
            anon = frontLayerContent;
        } else {
            if (changed9 & 384 == 0) {
                i14 = restartGroup.changedInstance(frontLayerContent) ? 256 : 128;
                $dirty2 |= i14;
            } else {
                anon = frontLayerContent;
            }
        }
        int i82 = empty & 8;
        int i97 = 2048;
        if (i82 != 0) {
            $dirty2 |= 3072;
            gesturesEnabled2 = modifier;
        } else {
            if (changed9 & 3072 == 0) {
                i15 = restartGroup.changed(modifier) ? i97 : changed6;
                $dirty2 |= i15;
            } else {
                gesturesEnabled2 = modifier;
            }
        }
        if (changed9 & 24576 == 0) {
            if (empty & 16 == 0) {
                changed7 = restartGroup.changed(scaffoldState) ? 16384 : backLayerContentColor2;
            } else {
                obj = scaffoldState;
            }
            $dirty2 |= changed7;
        } else {
            obj = scaffoldState;
        }
        frontLayerBackgroundColor2 = empty & 32;
        int i104 = 131072;
        anchoredDraggableState$material_release = 65536;
        backLayerBackgroundColor3 = 196608;
        if (frontLayerBackgroundColor2 != 0) {
            $dirty2 |= backLayerBackgroundColor3;
            $dirty15 = snackbarHost;
        } else {
            if (changed9 & backLayerBackgroundColor3 == 0) {
                i = restartGroup.changedInstance(snackbarHost) ? i104 : anchoredDraggableState$material_release;
                $dirty2 |= i;
            } else {
                $dirty15 = snackbarHost;
            }
        }
        i23 = empty & 64;
        final int i111 = 1572864;
        if (i23 != 0) {
            $dirty2 |= i111;
            stickyFrontLayer3 = gesturesEnabled;
        } else {
            if (changed9 & i111 == 0) {
                i12 = restartGroup.changed(gesturesEnabled) ? 1048576 : 524288;
                $dirty2 |= i12;
            } else {
                stickyFrontLayer3 = gesturesEnabled;
            }
        }
        if (changed9 & i105 == 0) {
            if (empty & 128 == 0) {
                changed2 = restartGroup.changed(peekHeight) ? 8388608 : 4194304;
            } else {
                f5 = peekHeight;
            }
            $dirty2 |= changed2;
        } else {
            f5 = peekHeight;
        }
        int i107 = changed9 & i106;
        if (i107 == 0) {
            if (empty & 256 == 0) {
                changed13 = restartGroup.changed(headerHeight) ? 67108864 : 33554432;
            } else {
                f2 = headerHeight;
            }
            $dirty2 |= changed13;
        } else {
            f2 = headerHeight;
        }
        int i83 = empty & 512;
        int i108 = 805306368;
        if (i83 != 0) {
            $dirty2 |= i108;
            i8 = i83;
            z3 = persistentAppBar;
        } else {
            if (changed9 & i108 == 0) {
                i8 = i83;
                i26 = restartGroup.changed(persistentAppBar) ? 536870912 : 268435456;
                $dirty2 |= i26;
            } else {
                i8 = i83;
                z3 = persistentAppBar;
            }
        }
        int i84 = empty & 1024;
        if (i84 != 0) {
            $dirty13 |= 6;
            px-0680j_4 = i84;
            z = stickyFrontLayer;
        } else {
            if (i24 & 6 == 0) {
                px-0680j_4 = i84;
                i15 = restartGroup.changed(stickyFrontLayer) ? 4 : 2;
                $dirty13 |= i15;
            } else {
                px-0680j_4 = i84;
                z = stickyFrontLayer;
            }
        }
        if (i24 & 48 == 0) {
            if (empty & 2048 == 0) {
                surface-0d7_KjU = restartGroup.changed(backLayerBackgroundColor) ? 32 : 16;
            } else {
                l2 = backLayerBackgroundColor;
            }
            $dirty13 |= surface-0d7_KjU;
        } else {
            l2 = backLayerBackgroundColor;
        }
        if (i24 & 384 == 0) {
            if (empty & 4096 == 0) {
                backLayerBackgroundColor3 = restartGroup.changed(frontLayerShape) ? 256 : 128;
            } else {
                l10 = frontLayerShape;
            }
            $dirty13 |= backLayerBackgroundColor3;
        } else {
            l10 = frontLayerShape;
        }
        if (i24 & 3072 == 0) {
            if (empty & 8192 == 0) {
                if (restartGroup.changed(frontLayerBackgroundColor)) {
                    changed6 = i97;
                }
            } else {
                obj3 = frontLayerBackgroundColor;
            }
            $dirty13 |= changed6;
        } else {
            obj3 = frontLayerBackgroundColor;
        }
        if (i24 & 24576 == 0) {
            if (empty & 16384 == 0) {
                if (restartGroup.changed(frontLayerContentColor)) {
                    backLayerContentColor2 = 16384;
                }
            } else {
                f4 = frontLayerContentColor;
            }
            $dirty13 |= backLayerContentColor2;
        } else {
            f4 = frontLayerContentColor;
        }
        if (i24 & i94 == 0) {
            if (empty & i96 == 0) {
                i13 = restartGroup.changed(frontLayerScrimColor) ? i104 : anchoredDraggableState$material_release;
            } else {
                l3 = frontLayerScrimColor;
            }
            $dirty13 |= i13;
        } else {
            l3 = frontLayerScrimColor;
        }
        if (i24 & i111 == 0) {
            if (empty & anchoredDraggableState$material_release == 0) {
                i18 = restartGroup.changed($changed) ? 1048576 : 524288;
            } else {
                l7 = $changed;
            }
            $dirty13 |= i18;
        } else {
            l7 = $changed;
        }
        if (i24 & i95 == 0) {
            if (empty & i104 == 0) {
                i20 = restartGroup.changed(i22) ? 8388608 : 4194304;
            } else {
                l6 = i22;
            }
            $dirty13 |= i20;
        } else {
            l6 = i22;
        }
        $dirty12 = $dirty13;
        if ($dirty17 &= $dirty2 == 306783378 && $dirty12 & i39 == 4793490) {
            if ($dirty12 & i39 == 4793490) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    int i98 = -29360129;
                    int i101 = -57345;
                    if (obj65 & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if (i82 != 0) {
                                modifier4 = Modifier.Companion;
                            } else {
                                modifier4 = modifier;
                            }
                            if (empty & 16 != 0) {
                                obj44 = modifier4;
                                modifier3 = 0;
                                rememberBackdropScaffoldState = BackdropScaffoldKt.rememberBackdropScaffoldState(BackdropValue.Concealed, 0, 0, 0, restartGroup, 6, 14);
                                $dirty2 &= i101;
                            } else {
                                obj44 = modifier4;
                                modifier3 = 0;
                                rememberBackdropScaffoldState = scaffoldState;
                            }
                            if (frontLayerBackgroundColor2 != 0) {
                                snackbarHost3 = ComposableSingletons.BackdropScaffoldKt.INSTANCE.getLambda-1$material_release();
                            } else {
                                snackbarHost3 = $dirty15;
                            }
                            gesturesEnabled2 = i23 != 0 ? 1 : stickyFrontLayer3;
                            if (empty & 128 != 0) {
                                peekHeight2 = BackdropScaffoldDefaults.INSTANCE.getPeekHeight-D9Ej5fM();
                                $dirty2 &= i98;
                            } else {
                                peekHeight2 = peekHeight;
                            }
                            if (empty & 256 != 0) {
                                headerHeight2 = BackdropScaffoldDefaults.INSTANCE.getHeaderHeight-D9Ej5fM();
                                $dirty2 &= f2;
                            } else {
                                headerHeight2 = headerHeight;
                            }
                            persistentAppBar2 = i8 != 0 ? 1 : persistentAppBar;
                            stickyFrontLayer4 = px-0680j_4 != 0 ? 1 : stickyFrontLayer;
                            if (empty & 2048 != 0) {
                                backLayerBackgroundColor2 = backLayerContentColor2;
                                $dirty15 = $dirty12;
                            } else {
                                backLayerBackgroundColor2 = backLayerBackgroundColor;
                                $dirty15 = $dirty12;
                            }
                            if (empty & 4096 != 0) {
                                backLayerContentColor2 = ColorsKt.contentColorFor-ek8zF_U(backLayerBackgroundColor2, frontLayerShape2, restartGroup);
                                $dirty15 &= -897;
                            } else {
                                backLayerContentColor2 = frontLayerShape;
                            }
                            if (empty & 8192 != 0) {
                                backLayerBackgroundColor4 = backLayerBackgroundColor2;
                                frontLayerShape2 = BackdropScaffoldDefaults.INSTANCE.getFrontLayerShape(restartGroup, 0);
                                $dirty15 &= -7169;
                            } else {
                                backLayerBackgroundColor4 = backLayerBackgroundColor2;
                                frontLayerShape2 = frontLayerBackgroundColor;
                            }
                            if (empty & 16384 != 0) {
                                frontLayerElevation2 = BackdropScaffoldDefaults.INSTANCE.getFrontLayerElevation-D9Ej5fM();
                                $dirty15 &= i101;
                            } else {
                                frontLayerElevation2 = frontLayerContentColor;
                            }
                            if (i59 &= empty != 0) {
                                obj46 = frontLayerElevation2;
                                $dirty15 &= i37;
                                obj45 = frontLayerShape2;
                                l9 = surface-0d7_KjU;
                            } else {
                                obj46 = frontLayerElevation2;
                                obj45 = frontLayerShape2;
                                l9 = frontLayerScrimColor;
                            }
                            if (empty & anchoredDraggableState$material_release != 0) {
                                frontLayerContentColor2 = ColorsKt.contentColorFor-ek8zF_U(l9, frontLayerShape2, restartGroup);
                                $dirty15 &= i21;
                            } else {
                                frontLayerContentColor2 = $changed;
                            }
                            if (empty & i104 != 0) {
                                i7 = obj44;
                                i27 = i36;
                                obj4 = snackbarHost3;
                                $dirty14 = backLayerBackgroundColor4;
                                l5 = frontLayerScrimColor3;
                                backLayerBackgroundColor3 = obj45;
                                frontLayerScrimColor2 = obj46;
                                frontLayerBackgroundColor2 = gesturesEnabled2;
                                snackbarHost2 = backLayerContentColor2;
                                i11 = stickyFrontLayer4;
                                stickyFrontLayer3 = l8;
                            } else {
                                i7 = obj44;
                                frontLayerScrimColor2 = obj46;
                                l5 = i22;
                                obj4 = snackbarHost3;
                                i27 = $dirty15;
                                $dirty14 = backLayerBackgroundColor4;
                                backLayerBackgroundColor3 = obj45;
                                frontLayerBackgroundColor2 = gesturesEnabled2;
                                snackbarHost2 = backLayerContentColor2;
                                i11 = stickyFrontLayer4;
                                stickyFrontLayer3 = l8;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            if (empty & 16 != 0) {
                                $dirty2 &= i101;
                            }
                            if (empty & 128 != 0) {
                                $dirty2 &= i98;
                            }
                            if (empty & 256 != 0) {
                                $dirty2 &= i2;
                            }
                            if (empty & 2048 != 0) {
                                $dirty12 &= -113;
                            }
                            if (empty & 4096 != 0) {
                                $dirty1 &= -897;
                            }
                            if (empty & 8192 != 0) {
                                $dirty1 &= -7169;
                            }
                            if (empty & 16384 != 0) {
                                $dirty1 &= i101;
                            }
                            if (i78 &= empty != 0) {
                                $dirty1 &= i5;
                            }
                            if (empty & anchoredDraggableState$material_release != 0) {
                                $dirty1 &= i10;
                            }
                            if (empty & i104 != 0) {
                                $dirty1 &= i98;
                            }
                            i7 = modifier;
                            i11 = stickyFrontLayer;
                            backLayerBackgroundColor3 = frontLayerBackgroundColor;
                            frontLayerScrimColor2 = frontLayerContentColor;
                            frontLayerContentColor2 = $changed;
                            i27 = $dirty1;
                            l5 = l6;
                            rememberBackdropScaffoldState = obj;
                            peekHeight2 = f5;
                            headerHeight2 = f2;
                            frontLayerBackgroundColor2 = stickyFrontLayer3;
                            obj4 = $dirty15;
                            persistentAppBar2 = persistentAppBar;
                            $dirty14 = backLayerBackgroundColor;
                            snackbarHost2 = frontLayerShape;
                            stickyFrontLayer3 = frontLayerScrimColor;
                        }
                    } else {
                    }
                    restartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        obj46 = $dirty14;
                        ComposerKt.traceEventStart(113877443, $dirty2, i27, "androidx.compose.material.BackdropScaffold (BackdropScaffold.kt:385)");
                    } else {
                        obj46 = $dirty14;
                    }
                    int i99 = 0;
                    obj44 = i42;
                    obj56 = i27;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    Object this_$iv = consume2;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 1348845825, "CC(remember):BackdropScaffold.kt#9igjgp");
                    if (i45 ^= 24576 > 16384) {
                        if (!restartGroup.changed(rememberBackdropScaffoldState)) {
                            i17 = $dirty2 & 24576 == 16384 ? 1 : 0;
                        } else {
                        }
                    } else {
                    }
                    Composer composer3 = restartGroup;
                    int i100 = 0;
                    it$iv = composer3.rememberedValue();
                    int i102 = 0;
                    if (i17 |= changed14 == 0) {
                        if (it$iv == Composer.Companion.getEmpty()) {
                            empty = 0;
                            obj48 = it$iv;
                            it$iv = new BackdropScaffoldKt.BackdropScaffold.1.1(rememberBackdropScaffoldState, this_$iv);
                            composer3.updateRememberedValue((Function0)it$iv);
                        } else {
                            obj48 = it$iv;
                        }
                    } else {
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    EffectsKt.SideEffect((Function0)it$iv, restartGroup, 0);
                    int i70 = 0;
                    obj57 = this_$iv;
                    obj45 = i65;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    int i47 = 0;
                    int i66 = 0;
                    obj45 = i48;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    int i49 = 0;
                    float $this$BackdropScaffold_0hNv9B8_u24lambda_u245 = (Density)restartGroup.consume((CompositionLocal)CompositionLocalsKt.getLocalDensity()).toPx-0680j_4(headerHeight2);
                    BackdropScaffoldKt.BackdropScaffold.backLayer.1 $i$a$WithBackdropScaffoldKt$BackdropScaffold$headerHeightPx$1 = new BackdropScaffoldKt.BackdropScaffold.backLayer.1(persistentAppBar2, rememberBackdropScaffoldState, appBar, obj2);
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 1348865590, "CC(remember):BackdropScaffold.kt#9igjgp");
                    changed5 = restartGroup.changed($this$BackdropScaffold_0hNv9B8_u24lambda_u245);
                    Composer composer2 = restartGroup;
                    int i68 = 0;
                    Object rememberedValue = composer2.rememberedValue();
                    int i103 = 0;
                    if (!changed5) {
                        obj45 = changed5;
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            obj48 = invalid$iv;
                            $i$a$CacheBackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1 = new BackdropScaffoldKt.BackdropScaffold.calculateBackLayerConstraints.1.1($this$BackdropScaffold_0hNv9B8_u24lambda_u245);
                            composer2.updateRememberedValue((Function1)$i$a$CacheBackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1);
                        } else {
                            $i$a$CacheBackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1 = rememberedValue;
                        }
                    } else {
                        obj45 = changed5;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    Object obj7 = rememberBackdropScaffoldState;
                    changed3 = peekHeight2;
                    i8 = headerHeight2;
                    i23 = stickyFrontLayer3;
                    anon = new BackdropScaffoldKt.BackdropScaffold.2(i7, (Function2)ComposableLambdaKt.rememberComposableLambda(461235665, true, $i$a$WithBackdropScaffoldKt$BackdropScaffold$headerHeightPx$1, restartGroup, 54), (Function1)$i$a$CacheBackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1, $this$BackdropScaffold_0hNv9B8_u24lambda_u245, i11, frontLayerBackgroundColor2, obj7, rememberBackdropScaffoldState.getAnchoredDraggableState$material_release(), backLayerBackgroundColor3, i23, i28, frontLayerContentColor2, i107, frontLayerScrimColor2, i8, (Density)restartGroup.consume((CompositionLocal)CompositionLocalsKt.getLocalDensity()).toPx-0680j_4(peekHeight2), changed3, frontLayerContent, l5, obj35, obj4);
                    obj48 = snackbarHost2;
                    obj53 = restartGroup;
                    SurfaceKt.Surface-F-jzlyU(0, 0, obj46, gesturesEnabled, obj48, headerHeight, 0, 0, (Function2)ComposableLambdaKt.rememberComposableLambda(1961515015, true, anon, restartGroup, 54), obj53);
                    composer = obj53;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    l = obj2;
                    $composer2 = persistentAppBar2;
                    companion = i7;
                    i6 = i11;
                    z2 = frontLayerBackgroundColor2;
                    modifier2 = backLayerBackgroundColor3;
                    l4 = i23;
                    stickyFrontLayer2 = frontLayerContentColor2;
                    f3 = frontLayerScrimColor2;
                    f = i8;
                    f6 = changed3;
                    obj5 = obj4;
                    i16 = obj56;
                    persistentAppBar3 = skipping;
                    frontLayerContentColor3 = $dirty2;
                    $dirty = obj7;
                    scaffoldState2 = l5;
                } else {
                    restartGroup.skipToGroupEnd();
                    companion = modifier;
                    f3 = frontLayerContentColor;
                    l4 = frontLayerScrimColor;
                    stickyFrontLayer2 = $changed;
                    frontLayerContentColor3 = $dirty2;
                    scaffoldState2 = l6;
                    $dirty = obj;
                    composer = restartGroup;
                    f6 = f5;
                    f = f2;
                    z2 = stickyFrontLayer3;
                    obj5 = $dirty15;
                    i16 = $dirty12;
                    $composer2 = persistentAppBar;
                    i6 = stickyFrontLayer;
                    persistentAppBar3 = backLayerBackgroundColor;
                    l = frontLayerShape;
                    modifier2 = frontLayerBackgroundColor;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new BackdropScaffoldKt.BackdropScaffold.3(appBar, backLayerContent, frontLayerContent, companion, $dirty, obj5, z2, f6, f, $composer2, i6, persistentAppBar3, stickyFrontLayer3, l, anon, modifier2, f3, l4, backLayerContentColor2, stickyFrontLayer2, frontLayerBackgroundColor2, scaffoldState2, anchoredDraggableState$material_release, obj65, obj66, obj67);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    public static final androidx.compose.material.BackdropScaffoldState BackdropScaffoldState(androidx.compose.material.BackdropValue initialValue, Density density, AnimationSpec<Float> animationSpec, Function1<? super androidx.compose.material.BackdropValue, Boolean> confirmValueChange, androidx.compose.material.SnackbarHostState snackbarHostState) {
        BackdropScaffoldState backdropScaffoldState = new BackdropScaffoldState(initialValue, animationSpec, confirmValueChange, snackbarHostState);
        final int i = 0;
        backdropScaffoldState.setDensity$material_release(density);
        return backdropScaffoldState;
    }

    public static androidx.compose.material.BackdropScaffoldState BackdropScaffoldState$default(androidx.compose.material.BackdropValue backdropValue, Density density2, AnimationSpec animationSpec3, Function1 function14, androidx.compose.material.SnackbarHostState snackbarHostState5, int i6, Object object7) {
        AnimationSpec obj2;
        androidx.compose.material.BackdropScaffoldKt.BackdropScaffoldState.1 obj3;
        androidx.compose.material.SnackbarHostState obj4;
        if (i6 & 4 != 0) {
            obj2 = BackdropScaffoldDefaults.INSTANCE.getAnimationSpec();
        }
        if (i6 & 8 != 0) {
            obj3 = BackdropScaffoldKt.BackdropScaffoldState.1.INSTANCE;
        }
        if (i6 &= 16 != 0) {
            obj4 = new SnackbarHostState();
        }
        return BackdropScaffoldKt.BackdropScaffoldState(backdropValue, density2, obj2, obj3, obj4);
    }

    private static final void BackdropStack(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> backLayer, Function1<? super Constraints, Constraints> calculateBackLayerConstraints, Function4<? super Constraints, ? super Float, ? super Composer, ? super Integer, Unit> frontLayer, Composer $composer, int $changed) {
        int i7;
        int traceInProgress;
        int $dirty;
        int i8;
        int i4;
        int i10;
        int i5;
        int skipping;
        boolean traceInProgress2;
        int i6;
        int i;
        int i3;
        Object modifier2;
        int rememberedValue;
        Object obj3;
        int i9;
        Object obj;
        int str;
        Object obj2;
        Object empty;
        int i2;
        Object anon;
        traceInProgress = -1248995194;
        final Composer obj13 = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(obj13, "C(BackdropStack)P(3)602@24951L890,602@24924L917:BackdropScaffold.kt#jmzs0o");
        if ($changed & 6 == 0) {
            i8 = obj13.changed(modifier) ? 4 : 2;
            $dirty |= i8;
        }
        i3 = 32;
        if ($changed & 48 == 0) {
            i4 = obj13.changedInstance(backLayer) ? i3 : 16;
            $dirty |= i4;
        }
        rememberedValue = 256;
        if ($changed & 384 == 0) {
            i10 = obj13.changedInstance(calculateBackLayerConstraints) ? rememberedValue : 128;
            $dirty |= i10;
        }
        i9 = 2048;
        if ($changed & 3072 == 0) {
            i5 = obj13.changedInstance(frontLayer) ? i9 : 1024;
            $dirty |= i5;
        }
        if ($dirty & 1171 == 1170) {
            if (!obj13.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty, -1, "androidx.compose.material.BackdropStack (BackdropScaffold.kt:601)");
                }
                ComposerKt.sourceInformationMarkerStart(obj13, -1431305978, "CC(remember):BackdropScaffold.kt#9igjgp");
                i6 = 1;
                str = 0;
                i7 = $dirty & 112 == i3 ? i6 : str;
                i = $dirty & 896 == rememberedValue ? i6 : str;
                if ($dirty & 7168 == i9) {
                } else {
                    i6 = str;
                }
                skipping = obj13;
                i3 = 0;
                rememberedValue = skipping.rememberedValue();
                i9 = 0;
                if (i13 |= i6 == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        empty = 0;
                        anon = new BackdropScaffoldKt.BackdropStack.1.1(backLayer, calculateBackLayerConstraints, frontLayer);
                        skipping.updateRememberedValue((Function2)anon);
                    } else {
                        anon = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(obj13);
                SubcomposeLayoutKt.SubcomposeLayout(modifier, (Function2)anon, obj13, $dirty & 14, str);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                obj13.skipToGroupEnd();
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = obj13.endRestartGroup();
        if (endRestartGroup != null) {
            skipping = new BackdropScaffoldKt.BackdropStack.2(modifier, backLayer, calculateBackLayerConstraints, frontLayer, $changed);
            endRestartGroup.updateScope((Function2)skipping);
        } else {
            modifier2 = modifier;
            obj3 = backLayer;
            obj = calculateBackLayerConstraints;
            obj2 = frontLayer;
            i2 = $changed;
        }
    }

    public static final NestedScrollConnection ConsumeSwipeNestedScrollConnection(androidx.compose.material.AnchoredDraggableState<?> state, Orientation orientation) {
        BackdropScaffoldKt.ConsumeSwipeNestedScrollConnection.1 anon = new BackdropScaffoldKt.ConsumeSwipeNestedScrollConnection.1(state, orientation);
        return (NestedScrollConnection)anon;
    }

    private static final void Scrim-3J-VO9M(long color, Function0<Unit> onDismiss, boolean visible, Composer $composer, int $changed) {
        int traceInProgress2;
        int $i$f$isSpecified8_81llA;
        Modifier pointerInput;
        Object it$iv;
        int $dirty;
        int i5;
        int i11;
        int i13;
        boolean skipping;
        boolean traceInProgress;
        int i8;
        int str;
        Composer cmp;
        androidx.compose.ui.Modifier.Companion companion2;
        int i2;
        Unit iNSTANCE;
        int i;
        Object rememberedValue;
        int i9;
        int i6;
        Composer i4;
        Object empty;
        int anon;
        int $dirty2;
        int i3;
        int i12;
        Object companion;
        int i10;
        int i7;
        final long l = color;
        final Object obj = visible;
        final boolean z = $composer;
        final int i17 = obj27;
        traceInProgress2 = -92141505;
        final Composer restartGroup = $changed.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(Scrim)P(0:c#ui.graphics.Color):BackdropScaffold.kt#jmzs0o");
        if (i17 & 6 == 0) {
            i5 = restartGroup.changed(l) ? 4 : 2;
            $dirty |= i5;
        }
        anon = 32;
        if (i17 & 48 == 0) {
            i11 = restartGroup.changedInstance(obj) ? anon : 16;
            $dirty |= i11;
        }
        if (i17 & 384 == 0) {
            i13 = restartGroup.changed(z) ? 256 : 128;
            $dirty |= i13;
        }
        if ($dirty & 147 == 146) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty, -1, "androidx.compose.material.Scrim (BackdropScaffold.kt:517)");
                }
                int i14 = 0;
                i2 = 1;
                rememberedValue = 0;
                $i$f$isSpecified8_81llA = Long.compare(skipping, i22) != 0 ? i2 : rememberedValue;
                if ($i$f$isSpecified8_81llA != 0) {
                    restartGroup.startReplaceGroup(478578989);
                    ComposerKt.sourceInformation(restartGroup, "519@21902L121,532@22312L62,528@22203L171");
                    i8 = z ? 1065353216 : 0;
                    TweenSpec tweenSpec3 = new TweenSpec(0, 0, 0, 7, 0);
                    i3 = rememberedValue;
                    $dirty2 = $dirty;
                    $dirty = AnimateAsStateKt.animateFloatAsState(i8, (AnimationSpec)tweenSpec3, 0, 0, 0, restartGroup, 48, 28);
                    int i18 = 0;
                    String str4 = "CC(remember):BackdropScaffold.kt#9igjgp";
                    if (z) {
                        restartGroup.startReplaceGroup(478752713);
                        ComposerKt.sourceInformation(restartGroup, "524@22109L37");
                        ComposerKt.sourceInformationMarkerStart(restartGroup, 1262370917, str4);
                        i9 = $dirty2 & 112 == anon ? empty : 0;
                        i4 = restartGroup;
                        anon = 0;
                        it$iv = i4.rememberedValue();
                        i12 = 0;
                        if (i9 == 0) {
                            if (it$iv == Composer.Companion.getEmpty()) {
                                empty = 0;
                                companion = it$iv;
                                it$iv = new BackdropScaffoldKt.Scrim.dismissModifier.1.1(obj, i18);
                                i4.updateRememberedValue((Function2)it$iv);
                            } else {
                                companion = it$iv;
                            }
                        } else {
                        }
                        ComposerKt.sourceInformationMarkerEnd(restartGroup);
                        pointerInput = SuspendingPointerInputFilterKt.pointerInput((Modifier)Modifier.Companion, Unit.INSTANCE, (Function2)it$iv);
                        restartGroup.endReplaceGroup();
                    } else {
                        restartGroup.startReplaceGroup(478845186);
                        restartGroup.endReplaceGroup();
                        pointerInput = Modifier.Companion;
                    }
                    int i30 = 1;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 1262377438, str4);
                    i = $dirty2 & 14 == 4 ? i30 : 0;
                    cmp = restartGroup;
                    i2 = 0;
                    rememberedValue = cmp.rememberedValue();
                    i6 = 0;
                    if (changed3 |= i == 0) {
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            empty = 0;
                            anon = new BackdropScaffoldKt.Scrim.1.1(l, obj2, $dirty);
                            cmp.updateRememberedValue((Function1)anon);
                        } else {
                            anon = rememberedValue;
                        }
                    } else {
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    CanvasKt.Canvas(SizeKt.fillMaxSize$default((Modifier)Modifier.Companion, 0, i30, i18).then(pointerInput), (Function1)anon, restartGroup, 0);
                    restartGroup.endReplaceGroup();
                } else {
                    $dirty2 = $dirty;
                    restartGroup.startReplaceGroup(479060450);
                    restartGroup.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
                $dirty2 = $dirty;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new BackdropScaffoldKt.Scrim.2(l, obj2, obj, z, i17);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    private static final float Scrim_3J_VO9M$lambda$7(State<Float> $alpha$delegate) {
        int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (Number)$alpha$delegate.getValue().floatValue();
    }

    public static final void access$BackLayerTransition(androidx.compose.material.BackdropValue target, Function2 appBar, Function2 content, Composer $composer, int $changed) {
        BackdropScaffoldKt.BackLayerTransition(target, appBar, content, $composer, $changed);
    }

    public static final float access$BackLayerTransition$lambda$10(State $animationProgress$delegate) {
        return BackdropScaffoldKt.BackLayerTransition$lambda$10($animationProgress$delegate);
    }

    public static final void access$BackdropStack(Modifier modifier, Function2 backLayer, Function1 calculateBackLayerConstraints, Function4 frontLayer, Composer $composer, int $changed) {
        BackdropScaffoldKt.BackdropStack(modifier, backLayer, calculateBackLayerConstraints, frontLayer, $composer, $changed);
    }

    public static final void access$Scrim-3J-VO9M(long color, Function0 onDismiss, boolean visible, Composer $composer, int $changed) {
        BackdropScaffoldKt.Scrim-3J-VO9M(color, onDismiss, visible, $composer, $changed);
    }

    public static final float access$Scrim_3J_VO9M$lambda$7(State $alpha$delegate) {
        return BackdropScaffoldKt.Scrim_3J_VO9M$lambda$7($alpha$delegate);
    }

    public static final float access$getPositionalThreshold$p() {
        return BackdropScaffoldKt.PositionalThreshold;
    }

    public static final float access$getVelocityThreshold$p() {
        return BackdropScaffoldKt.VelocityThreshold;
    }

    public static final androidx.compose.material.BackdropScaffoldState rememberBackdropScaffoldState(androidx.compose.material.BackdropValue initialValue, AnimationSpec<Float> animationSpec, Function1<? super androidx.compose.material.BackdropValue, Boolean> confirmStateChange, androidx.compose.material.SnackbarHostState snackbarHostState, Composer $composer, int $changed, int i7) {
        int animationSpec3;
        int iNSTANCE;
        int invalid$iv;
        boolean traceInProgress;
        boolean changed3;
        int i3;
        Composer str;
        int i2;
        int i6;
        Object rememberedValue;
        boolean changed2;
        int i5;
        int changed;
        int i;
        int empty2;
        Object anon2;
        Object empty;
        Object obj;
        Object snackbarHostState2;
        AnimationSpec animationSpec2;
        androidx.compose.material.BackdropScaffoldKt.rememberBackdropScaffoldState.1 anon;
        Object obj2;
        int i4;
        final Composer composer2 = $composer;
        final int i28 = $changed;
        int i8 = -862178912;
        ComposerKt.sourceInformationMarkerStart(composer2, i8, "C(rememberBackdropScaffoldState)P(2)279@10496L32,281@10588L7,292@10941L266,282@10607L600:BackdropScaffold.kt#jmzs0o");
        if (i7 & 2 != 0) {
            animationSpec2 = animationSpec3;
        } else {
            animationSpec2 = animationSpec;
        }
        if (i7 & 4 != 0) {
            anon = iNSTANCE;
        } else {
            anon = confirmStateChange;
        }
        String str3 = "CC(remember):BackdropScaffold.kt#9igjgp";
        if (i7 & 8 != 0) {
            ComposerKt.sourceInformationMarkerStart(composer2, -1082628462, str3);
            int i11 = 0;
            str = $composer;
            i6 = 0;
            rememberedValue = str.rememberedValue();
            i = 0;
            if (rememberedValue == Composer.Companion.getEmpty()) {
                empty = 0;
                snackbarHostState2 = new SnackbarHostState();
                str.updateRememberedValue(snackbarHostState2);
            } else {
                snackbarHostState2 = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            obj2 = invalid$iv;
        } else {
            obj2 = snackbarHostState;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i8, i28, -1, "androidx.compose.material.rememberBackdropScaffoldState (BackdropScaffold.kt:280)");
        }
        int i9 = 0;
        int i18 = 0;
        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        ComposerKt.sourceInformationMarkerEnd(composer2);
        Object obj3 = consume;
        ComposerKt.sourceInformationMarkerStart(composer2, -1082613988, str3);
        i2 = 0;
        int i21 = 1;
        int i24 = 4;
        if (i12 ^= 6 > i24) {
            if (!composer2.changed(initialValue)) {
                i3 = i28 & 6 == i24 ? i21 : i2;
            } else {
            }
        } else {
            obj = initialValue;
        }
        int i29 = 256;
        if (i25 ^= 384 > i29) {
            if (!composer2.changed(anon)) {
                i5 = i28 & 384 == i29 ? i21 : i2;
            } else {
            }
        } else {
        }
        empty2 = 2048;
        if (i26 ^= 3072 > empty2) {
            if (!composer2.changed(obj2)) {
                if (i28 & 3072 == empty2) {
                    i2 = i21;
                }
            } else {
            }
        } else {
        }
        Composer composer = $composer;
        int i22 = 0;
        Object rememberedValue2 = composer.rememberedValue();
        final int i30 = 0;
        if (i15 |= i2 == 0) {
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                i4 = 0;
                anon2 = new BackdropScaffoldKt.rememberBackdropScaffoldState.3.1(obj, obj3, animationSpec2, anon, obj2);
                composer.updateRememberedValue((Function0)anon2);
            } else {
                anon2 = rememberedValue2;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (BackdropScaffoldState)RememberSaveableKt.rememberSaveable(/* result */, BackdropScaffoldState.Companion.Saver(animationSpec2, anon, obj2, (Density)obj3), 0, (Function0)anon2, composer2, 0, 4);
    }
}
