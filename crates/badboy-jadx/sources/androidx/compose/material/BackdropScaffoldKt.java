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
        Object traceInProgress;
        Function0 factory$iv$iv$iv2;
        int materialized$iv$iv;
        int i3;
        int $dirty;
        boolean $dirty2;
        Object obj2;
        boolean traceInProgress2;
        Integer $this$BackLayerTransition_u24lambda_u2411;
        int i13;
        int i16;
        int i21;
        int iNSTANCE2;
        boolean currentCompositionLocalMap2;
        int i25;
        Composer composer2;
        Object currentCompositionLocalMap3;
        int i15;
        Function0 factory$iv$iv$iv3;
        Object $i$a$CacheBackdropScaffoldKt$BackLayerTransition$1$4;
        int empty;
        Object $i$a$CacheBackdropScaffoldKt$BackLayerTransition$1$5;
        boolean changed;
        Composer composer7;
        Composer composer8;
        Object maybeCachedBoxMeasurePolicy3;
        Composer restartGroup;
        Alignment topStart;
        int i8;
        Function0 factory$iv$iv$iv;
        Object it$iv2;
        Object it$iv;
        boolean currentCompositionLocalMap;
        int i20;
        androidx.compose.ui.layout.MeasurePolicy maybeCachedBoxMeasurePolicy2;
        Composer composer;
        Composer composer10;
        Object maybeCachedBoxMeasurePolicy;
        Object topStart2;
        int i28;
        Object propagateMinConstraints$iv2;
        int i23;
        int i29;
        int i26;
        int i18;
        int i5;
        int currentCompositeKeyHash;
        int i2;
        int i;
        androidx.compose.ui.Modifier.Companion companion2;
        Composer composer9;
        int i7;
        int i27;
        Composer composer11;
        int i19;
        BoxScopeInstance iNSTANCE;
        Function0 function03;
        int i4;
        int i24;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy2;
        int i11;
        int i31;
        Modifier modifier2;
        Composer composer4;
        int i17;
        int companion4;
        Modifier modifier;
        Composer.Companion companion3;
        int invalid$iv;
        int i12;
        boolean invalid$iv2;
        int i30;
        Object obj3;
        Composer.Companion companion;
        Composer.Companion propagateMinConstraints$iv;
        Object obj;
        Alignment contentAlignment$iv;
        Function0 function02;
        Modifier modifier3;
        Composer composer5;
        float animationSlideOffset;
        androidx.compose.runtime.CompositionLocalMap map;
        Function0 function0;
        int i9;
        int i22;
        Composer composer3;
        int i14;
        int i6;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv2;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy;
        Composer composer6;
        int i10;
        State obj64;
        traceInProgress = target;
        final Object obj4 = appBar;
        final Object obj5 = content;
        final int i42 = $changed;
        materialized$iv$iv = -950970976;
        restartGroup = $composer.startRestartGroup(materialized$iv$iv);
        ComposerKt.sourceInformation(restartGroup, "C(BackLayerTransition)P(2)551@22995L112,*554@23157L7,556@23203L1485:BackdropScaffold.kt#jmzs0o");
        if (i42 & 6 == 0) {
            i13 = restartGroup.changed(traceInProgress) ? 4 : 2;
            $dirty |= i13;
        }
        if (i42 & 48 == 0) {
            i16 = restartGroup.changedInstance(obj4) ? 32 : 16;
            $dirty |= i16;
        }
        if (i42 & 384 == 0) {
            i21 = restartGroup.changedInstance(obj5) ? 256 : 128;
            $dirty |= i21;
        }
        i20 = $dirty;
        if (i20 & 147 == 146) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(materialized$iv$iv, i20, -1, "androidx.compose.material.BackLayerTransition (BackdropScaffold.kt:548)");
                }
                i3 = traceInProgress == BackdropValue.Revealed ? 0 : 1073741824;
                TweenSpec tweenSpec2 = new TweenSpec(0, 0, 0, 7, 0);
                State animateFloatAsState = AnimateAsStateKt.animateFloatAsState(i3, (AnimationSpec)tweenSpec2, 0, 0, 0, restartGroup, 48, 28);
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
                topStart2 = Alignment.Companion.getTopStart();
                propagateMinConstraints$iv2 = 0;
                maybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(topStart2, propagateMinConstraints$iv2);
                i29 = 0;
                String $changed$iv4 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, $changed$iv4);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, 0);
                currentCompositionLocalMap2 = restartGroup.getCurrentCompositionLocalMap();
                i2 = i56;
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(restartGroup, (Modifier)companion13);
                companion2 = companion13;
                Function0 function04 = constructor2;
                i = 0;
                i27 = i20;
                String $dirty3 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, $dirty3);
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
                composer9 = restartGroup;
                Composer constructor-impl2 = Updater.constructor-impl(composer9);
                int i96 = 0;
                function03 = factory$iv$iv$iv;
                Updater.set-impl(constructor-impl2, maybeCachedBoxMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i97 = 0;
                Composer composer16 = constructor-impl2;
                int i100 = 0;
                if (!composer16.getInserting()) {
                    localMap$iv$iv = currentCompositionLocalMap2;
                    measurePolicy2 = maybeCachedBoxMeasurePolicy3;
                    if (!Intrinsics.areEqual(composer16.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer16.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl2.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer8 = composer16;
                    }
                } else {
                    localMap$iv$iv = currentCompositionLocalMap2;
                    measurePolicy2 = maybeCachedBoxMeasurePolicy3;
                }
                Updater.set-impl(constructor-impl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                composer7 = composer9;
                i19 = i50;
                String $changed$iv3 = "C73@3429L9:Box.kt#2w3rfo";
                ComposerKt.sourceInformationMarkerStart(composer7, -2146769399, $changed$iv3);
                iNSTANCE = BoxScopeInstance.INSTANCE;
                i99 |= 6;
                Composer composer17 = composer7;
                i11 = 0;
                modifier2 = materializeModifier2;
                ComposerKt.sourceInformationMarkerStart(composer7, -1148278766, "C559@23267L351,566@23650L218,557@23217L694,577@24032L353,584@24417L221,574@23920L762:BackdropScaffold.kt#jmzs0o");
                i24 = i63;
                String $i$a$LayoutBoxKt$Box$1$iv = "CC(remember):BackdropScaffold.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(composer7, -452682761, $i$a$LayoutBoxKt$Box$1$iv);
                Composer composer18 = composer7;
                int i103 = 0;
                it$iv2 = composer18.rememberedValue();
                companion = 0;
                if (!composer7.changed(animateFloatAsState)) {
                    contentAlignment$iv = topStart2;
                    if (it$iv2 == Composer.Companion.getEmpty()) {
                        int contentAlignment$iv2 = 0;
                        obj = it$iv2;
                        it$iv2 = new BackdropScaffoldKt.BackLayerTransition.1.1.1(animateFloatAsState);
                        composer18.updateRememberedValue((Function3)it$iv2);
                    } else {
                        obj = it$iv2;
                        composer = composer18;
                    }
                } else {
                    contentAlignment$iv = topStart2;
                }
                ComposerKt.sourceInformationMarkerEnd(composer7);
                ComposerKt.sourceInformationMarkerStart(composer7, -452670638, $i$a$LayoutBoxKt$Box$1$iv);
                Composer composer15 = composer7;
                int i101 = 0;
                it$iv = composer15.rememberedValue();
                int i105 = 0;
                if (changed6 |= changed7 == 0) {
                    propagateMinConstraints$iv = propagateMinConstraints$iv2;
                    if (it$iv == Composer.Companion.getEmpty()) {
                        propagateMinConstraints$iv2 = 0;
                        obj3 = it$iv;
                        it$iv = new BackdropScaffoldKt.BackLayerTransition.1.2.1($this$BackLayerTransition_u24lambda_u2411, animateFloatAsState);
                        composer15.updateRememberedValue((Function1)it$iv);
                    } else {
                        obj3 = it$iv;
                    }
                } else {
                    propagateMinConstraints$iv = propagateMinConstraints$iv2;
                }
                ComposerKt.sourceInformationMarkerEnd(composer7);
                Modifier graphicsLayer2 = GraphicsLayerModifierKt.graphicsLayer(LayoutModifierKt.layout((Modifier)Modifier.Companion, (Function3)it$iv2), (Function1)it$iv);
                ComposerKt.sourceInformationMarkerStart(composer7, 733328855, str3);
                Alignment topStart3 = Alignment.Companion.getTopStart();
                int i102 = i73;
                int $changed$iv5 = 0;
                companion3 = i80;
                maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(topStart3, $changed$iv5);
                int i109 = 0;
                int i110 = $changed$iv5;
                ComposerKt.sourceInformationMarkerStart(composer7, -1323940314, $changed$iv4);
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer7, 0);
                currentCompositionLocalMap = composer7.getCurrentCompositionLocalMap();
                Alignment alignment = topStart3;
                Modifier modifier4 = graphicsLayer2;
                Function0 function06 = constructor3;
                int i112 = 0;
                ComposerKt.sourceInformationMarkerStart(composer7, -692256719, $dirty3);
                if (!applier2 instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                composer7.startReusableNode();
                if (composer7.getInserting()) {
                    composer7.createNode(function06);
                } else {
                    factory$iv$iv$iv3 = function06;
                    composer7.useNode();
                }
                function0 = factory$iv$iv$iv3;
                Composer constructor-impl = Updater.constructor-impl(composer7);
                int i113 = 0;
                Updater.set-impl(constructor-impl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i116 = 0;
                Composer composer20 = constructor-impl;
                int i117 = 0;
                if (!composer20.getInserting()) {
                    localMap$iv$iv2 = currentCompositionLocalMap;
                    measurePolicy = maybeCachedBoxMeasurePolicy;
                    if (!Intrinsics.areEqual(composer20.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                        composer20.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer10 = composer20;
                    }
                } else {
                    localMap$iv$iv2 = currentCompositionLocalMap;
                    measurePolicy = maybeCachedBoxMeasurePolicy;
                }
                Updater.set-impl(constructor-impl, ComposedModifierKt.materializeModifier(composer7, graphicsLayer2), ComposeUiNode.Companion.getSetModifier());
                Composer composer12 = composer7;
                ComposerKt.sourceInformationMarkerStart(composer12, -2146769399, $changed$iv3);
                BoxScopeInstance iNSTANCE3 = BoxScopeInstance.INSTANCE;
                i115 |= 6;
                i14 = 0;
                i6 = i33;
                i10 = i75;
                Composer $i$a$LayoutBoxKt$Box$1$iv2 = composer3;
                ComposerKt.sourceInformationMarkerStart($i$a$LayoutBoxKt$Box$1$iv2, 799556868, "C572@23893L8:BackdropScaffold.kt#jmzs0o");
                obj4.invoke($i$a$LayoutBoxKt$Box$1$iv2, Integer.valueOf(i34 &= 14));
                ComposerKt.sourceInformationMarkerEnd($i$a$LayoutBoxKt$Box$1$iv2);
                ComposerKt.sourceInformationMarkerEnd(composer12);
                composer7.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer7);
                ComposerKt.sourceInformationMarkerEnd(composer7);
                ComposerKt.sourceInformationMarkerEnd(composer7);
                ComposerKt.sourceInformationMarkerStart(composer7, -452658279, $i$a$LayoutBoxKt$Box$1$iv);
                changed = composer7.changed(animateFloatAsState);
                Composer composer14 = composer7;
                int i82 = 0;
                Object rememberedValue5 = composer14.rememberedValue();
                companion4 = 0;
                if (!changed) {
                    invalid$iv2 = changed;
                    if (rememberedValue5 == Composer.Companion.getEmpty()) {
                        companion3 = invalid$iv4;
                        $i$a$CacheBackdropScaffoldKt$BackLayerTransition$1$4 = new BackdropScaffoldKt.BackLayerTransition.1.4.1(animateFloatAsState);
                        composer14.updateRememberedValue((Function3)$i$a$CacheBackdropScaffoldKt$BackLayerTransition$1$4);
                    } else {
                        $i$a$CacheBackdropScaffoldKt$BackLayerTransition$1$4 = rememberedValue5;
                    }
                } else {
                    invalid$iv2 = changed;
                }
                ComposerKt.sourceInformationMarkerEnd(composer7);
                ComposerKt.sourceInformationMarkerStart(composer7, -452646091, $i$a$LayoutBoxKt$Box$1$iv);
                changed3 |= changed4;
                Composer composer13 = composer7;
                int i76 = 0;
                Object rememberedValue4 = composer13.rememberedValue();
                int i85 = 0;
                if (empty == 0) {
                    invalid$iv = empty;
                    if (rememberedValue4 == Composer.Companion.getEmpty()) {
                        companion4 = invalid$iv3;
                        $i$a$CacheBackdropScaffoldKt$BackLayerTransition$1$5 = new BackdropScaffoldKt.BackLayerTransition.1.5.1($this$BackLayerTransition_u24lambda_u2411, animateFloatAsState);
                        composer13.updateRememberedValue((Function1)$i$a$CacheBackdropScaffoldKt$BackLayerTransition$1$5);
                    } else {
                        $i$a$CacheBackdropScaffoldKt$BackLayerTransition$1$5 = rememberedValue4;
                    }
                } else {
                    invalid$iv = empty;
                }
                ComposerKt.sourceInformationMarkerEnd(composer7);
                Modifier graphicsLayer = GraphicsLayerModifierKt.graphicsLayer(LayoutModifierKt.layout((Modifier)Modifier.Companion, (Function3)$i$a$CacheBackdropScaffoldKt$BackLayerTransition$1$4), (Function1)$i$a$CacheBackdropScaffoldKt$BackLayerTransition$1$5);
                i15 = i93;
                restartGroup = 0;
                ComposerKt.sourceInformationMarkerStart(composer7, 733328855, str3);
                i17 = 0;
                obj64 = animateFloatAsState;
                ComposerKt.sourceInformationMarkerStart(composer7, -1323940314, $changed$iv4);
                currentCompositionLocalMap3 = composer7.getCurrentCompositionLocalMap();
                i26 = currentCompositeKeyHash2;
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer7, graphicsLayer);
                modifier = graphicsLayer;
                Function0 function05 = constructor;
                i5 = 0;
                ComposerKt.sourceInformationMarkerStart(composer7, -692256719, $dirty3);
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                composer7.startReusableNode();
                if (composer7.getInserting()) {
                    composer7.createNode(function05);
                } else {
                    factory$iv$iv$iv2 = function05;
                    composer7.useNode();
                }
                Composer constructor-impl3 = Updater.constructor-impl(composer7);
                int i95 = 0;
                function02 = factory$iv$iv$iv2;
                Updater.set-impl(constructor-impl3, BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false), ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl3, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i108 = 0;
                Composer composer19 = constructor-impl3;
                int i111 = 0;
                if (!composer19.getInserting()) {
                    animationSlideOffset = $this$BackLayerTransition_u24lambda_u2411;
                    map = currentCompositionLocalMap3;
                    if (!Intrinsics.areEqual(composer19.rememberedValue(), Integer.valueOf(i26))) {
                        composer19.updateRememberedValue(Integer.valueOf(i26));
                        constructor-impl3.apply(Integer.valueOf(i26), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer2 = composer19;
                    }
                } else {
                    animationSlideOffset = $this$BackLayerTransition_u24lambda_u2411;
                    map = currentCompositionLocalMap3;
                }
                Updater.set-impl(constructor-impl3, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                $dirty2 = composer7;
                i25 = 0;
                ComposerKt.sourceInformationMarkerStart($dirty2, -2146769399, $changed$iv3);
                iNSTANCE2 = BoxScopeInstance.INSTANCE;
                i79 |= 6;
                composer11 = $dirty2;
                i31 = 0;
                i12 = i39;
                modifier3 = materializeModifier;
                ComposerKt.sourceInformationMarkerStart($dirty2, 800320739, "C590@24663L9:BackdropScaffold.kt#jmzs0o");
                obj5.invoke($dirty2, Integer.valueOf(i40 &= 14));
                ComposerKt.sourceInformationMarkerEnd($dirty2);
                ComposerKt.sourceInformationMarkerEnd($dirty2);
                composer7.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer7);
                ComposerKt.sourceInformationMarkerEnd(composer7);
                ComposerKt.sourceInformationMarkerEnd(composer7);
                ComposerKt.sourceInformationMarkerEnd(composer7);
                ComposerKt.sourceInformationMarkerEnd(composer7);
                composer9.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer9);
                ComposerKt.sourceInformationMarkerEnd(composer9);
                ComposerKt.sourceInformationMarkerEnd(composer9);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
                composer9 = restartGroup;
                i27 = i20;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer9.endRestartGroup();
        if (endRestartGroup != null) {
            materialized$iv$iv = new BackdropScaffoldKt.BackLayerTransition.2(target, obj4, obj5, i42);
            endRestartGroup.updateScope((Function2)materialized$iv$iv);
        } else {
            obj2 = target;
        }
    }

    private static final float BackLayerTransition$lambda$10(State<Float> $animationProgress$delegate) {
        int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (Number)$animationProgress$delegate.getValue().floatValue();
    }

    public static final void BackdropScaffold-0hNv9B8(Function2<? super Composer, ? super Integer, Unit> appBar, Function2<? super Composer, ? super Integer, Unit> backLayerContent, Function2<? super Composer, ? super Integer, Unit> frontLayerContent, Modifier modifier, androidx.compose.material.BackdropScaffoldState scaffoldState, Function3<? super androidx.compose.material.SnackbarHostState, ? super Composer, ? super Integer, Unit> snackbarHost, boolean gesturesEnabled, float peekHeight, float headerHeight, boolean persistentAppBar, boolean stickyFrontLayer, long backLayerBackgroundColor, long backLayerContentColor, Shape frontLayerShape, float frontLayerElevation, long frontLayerBackgroundColor, long frontLayerContentColor, long frontLayerScrimColor, Composer $composer, int $changed, int $changed1, int i22) {
        int changed5;
        int changed6;
        Object obj3;
        float f2;
        int skipping;
        int i7;
        int $dirty1;
        int defaultsInvalid;
        androidx.compose.ui.Modifier.Companion modifier3;
        int modifier4;
        long backLayerBackgroundColor2;
        float frontLayerElevation2;
        long l2;
        long $dirty12;
        Object endRestartGroup;
        Shape frontLayerShape2;
        int i15;
        Object it$iv;
        Object $i$a$CacheBackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1;
        boolean changed12;
        int changed10;
        long obj5;
        int i23;
        int iNSTANCE;
        int iNSTANCE2;
        int i27;
        int i26;
        int i17;
        int i;
        int empty;
        androidx.compose.ui.Modifier.Companion companion;
        int $dirty2;
        Object $dirty;
        int $dirty14;
        int i2;
        int i25;
        int i4;
        androidx.compose.material.BackdropScaffoldState rememberBackdropScaffoldState;
        Object obj4;
        int i21;
        int i12;
        int i6;
        boolean z2;
        boolean z3;
        long l;
        long l4;
        long l8;
        long l10;
        long l5;
        Object snackbarHost2;
        long snackbarHost3;
        boolean z;
        Object gesturesEnabled2;
        float f4;
        Object obj2;
        float peekHeight2;
        float f3;
        int $composer2;
        float f5;
        float headerHeight2;
        int i8;
        float f;
        int persistentAppBar3;
        long persistentAppBar2;
        boolean stickyFrontLayer2;
        int stickyFrontLayer3;
        Object $dirty13;
        long l3;
        Object anon;
        int changed8;
        int i11;
        int i9;
        int changed9;
        int i5;
        int $dirty15;
        androidx.compose.ui.Modifier.Companion i14;
        Shape modifier2;
        int changed3;
        int changed2;
        float f6;
        int i10;
        int changed7;
        long l7;
        int backLayerContentColor2;
        int i28;
        long stickyFrontLayer4;
        int changed13;
        boolean frontLayerBackgroundColor2;
        long scaffoldState2;
        androidx.compose.material.AnchoredDraggableState anchoredDraggableState$material_release;
        int backLayerBackgroundColor3;
        long backLayerBackgroundColor4;
        int i16;
        long i13;
        int i18;
        int i19;
        int surface-0d7_KjU;
        long frontLayerContentColor3;
        int frontLayerContentColor2;
        int changed;
        int i20;
        int changed4;
        float frontLayerScrimColor2;
        int i3;
        int i24;
        int px-0680j_4;
        boolean changed11;
        Composer composer;
        long l6;
        Object obj;
        ScopeUpdateScope scopeUpdateScope;
        long l9;
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
        obj5 = backLayerContent;
        changed5 = obj65;
        i = obj66;
        empty = obj67;
        Composer restartGroup = obj64.startRestartGroup(113877443);
        ComposerKt.sourceInformation(restartGroup, "C(BackdropScaffold)P(!1,2,5,12,15,16,10,13:c#ui.unit.Dp,11:c#ui.unit.Dp,14,17,1:c#ui.graphics.Color,3:c#ui.graphics.Color,9,7:c#ui.unit.Dp,4:c#ui.graphics.Color,6:c#ui.graphics.Color,8:c#ui.graphics.Color)371@15931L40,378@16340L6,379@16391L41,380@16488L15,382@16634L6,383@16686L42,384@16789L20,387@16929L7,388@16952L47,388@16941L58,*392@17042L7,393@17116L7,395@17182L315,408@17568L100,418@17848L3899,415@17746L4001:BackdropScaffold.kt#jmzs0o");
        $dirty2 = obj65;
        $dirty14 = obj66;
        if (empty & 1 != 0) {
            $dirty2 |= 6;
        } else {
            if (changed5 & 6 == 0) {
                i21 = restartGroup.changedInstance(frontLayerShape2) ? 4 : 2;
                $dirty2 |= i21;
            }
        }
        if (empty & 2 != 0) {
            $dirty2 |= 48;
        } else {
            if (changed5 & 48 == 0) {
                i12 = restartGroup.changedInstance(obj5) ? 32 : 16;
                $dirty2 |= i12;
            }
        }
        if (empty & 4 != 0) {
            $dirty2 |= 384;
            anon = frontLayerContent;
        } else {
            if (changed5 & 384 == 0) {
                i6 = restartGroup.changedInstance(frontLayerContent) ? 256 : 128;
                $dirty2 |= i6;
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
            if (changed5 & 3072 == 0) {
                i10 = restartGroup.changed(modifier) ? i97 : changed8;
                $dirty2 |= i10;
            } else {
                gesturesEnabled2 = modifier;
            }
        }
        if (changed5 & 24576 == 0) {
            if (empty & 16 == 0) {
                changed13 = restartGroup.changed(scaffoldState) ? 16384 : backLayerContentColor2;
            } else {
                obj2 = scaffoldState;
            }
            $dirty2 |= changed13;
        } else {
            obj2 = scaffoldState;
        }
        frontLayerBackgroundColor2 = empty & 32;
        int i104 = 131072;
        anchoredDraggableState$material_release = 65536;
        backLayerBackgroundColor3 = 196608;
        if (frontLayerBackgroundColor2 != 0) {
            $dirty2 |= backLayerBackgroundColor3;
            $dirty13 = snackbarHost;
        } else {
            if (changed5 & backLayerBackgroundColor3 == 0) {
                i16 = restartGroup.changedInstance(snackbarHost) ? i104 : anchoredDraggableState$material_release;
                $dirty2 |= i16;
            } else {
                $dirty13 = snackbarHost;
            }
        }
        i13 = empty & 64;
        final int i111 = 1572864;
        if (i13 != 0) {
            $dirty2 |= i111;
            stickyFrontLayer2 = gesturesEnabled;
        } else {
            if (changed5 & i111 == 0) {
                i19 = restartGroup.changed(gesturesEnabled) ? 1048576 : 524288;
                $dirty2 |= i19;
            } else {
                stickyFrontLayer2 = gesturesEnabled;
            }
        }
        if (changed5 & i105 == 0) {
            if (empty & 128 == 0) {
                changed = restartGroup.changed(peekHeight) ? 8388608 : 4194304;
            } else {
                f5 = peekHeight;
            }
            $dirty2 |= changed;
        } else {
            f5 = peekHeight;
        }
        int i107 = changed5 & i106;
        if (i107 == 0) {
            if (empty & 256 == 0) {
                changed4 = restartGroup.changed(headerHeight) ? 67108864 : 33554432;
            } else {
                f = headerHeight;
            }
            $dirty2 |= changed4;
        } else {
            f = headerHeight;
        }
        int i83 = empty & 512;
        int i108 = 805306368;
        if (i83 != 0) {
            $dirty2 |= i108;
            i3 = i83;
            z2 = persistentAppBar;
        } else {
            if (changed5 & i108 == 0) {
                i3 = i83;
                i24 = restartGroup.changed(persistentAppBar) ? 536870912 : 268435456;
                $dirty2 |= i24;
            } else {
                i3 = i83;
                z2 = persistentAppBar;
            }
        }
        int i84 = empty & 1024;
        if (i84 != 0) {
            $dirty14 |= 6;
            px-0680j_4 = i84;
            z3 = stickyFrontLayer;
        } else {
            if (i & 6 == 0) {
                px-0680j_4 = i84;
                i10 = restartGroup.changed(stickyFrontLayer) ? 4 : 2;
                $dirty14 |= i10;
            } else {
                px-0680j_4 = i84;
                z3 = stickyFrontLayer;
            }
        }
        if (i & 48 == 0) {
            if (empty & 2048 == 0) {
                surface-0d7_KjU = restartGroup.changed(backLayerBackgroundColor) ? 32 : 16;
            } else {
                l = backLayerBackgroundColor;
            }
            $dirty14 |= surface-0d7_KjU;
        } else {
            l = backLayerBackgroundColor;
        }
        if (i & 384 == 0) {
            if (empty & 4096 == 0) {
                backLayerBackgroundColor3 = restartGroup.changed(frontLayerShape) ? 256 : 128;
            } else {
                l4 = frontLayerShape;
            }
            $dirty14 |= backLayerBackgroundColor3;
        } else {
            l4 = frontLayerShape;
        }
        if (i & 3072 == 0) {
            if (empty & 8192 == 0) {
                if (restartGroup.changed(frontLayerBackgroundColor)) {
                    changed8 = i97;
                }
            } else {
                obj3 = frontLayerBackgroundColor;
            }
            $dirty14 |= changed8;
        } else {
            obj3 = frontLayerBackgroundColor;
        }
        if (i & 24576 == 0) {
            if (empty & 16384 == 0) {
                if (restartGroup.changed(frontLayerContentColor)) {
                    backLayerContentColor2 = 16384;
                }
            } else {
                f2 = frontLayerContentColor;
            }
            $dirty14 |= backLayerContentColor2;
        } else {
            f2 = frontLayerContentColor;
        }
        if (i & i94 == 0) {
            if (empty & i96 == 0) {
                i11 = restartGroup.changed(frontLayerScrimColor) ? i104 : anchoredDraggableState$material_release;
            } else {
                l8 = frontLayerScrimColor;
            }
            $dirty14 |= i11;
        } else {
            l8 = frontLayerScrimColor;
        }
        if (i & i111 == 0) {
            if (empty & anchoredDraggableState$material_release == 0) {
                i9 = restartGroup.changed($changed) ? 1048576 : 524288;
            } else {
                l10 = $changed;
            }
            $dirty14 |= i9;
        } else {
            l10 = $changed;
        }
        if (i & i95 == 0) {
            if (empty & i104 == 0) {
                i5 = restartGroup.changed(i22) ? 8388608 : 4194304;
            } else {
                l5 = i22;
            }
            $dirty14 |= i5;
        } else {
            l5 = i22;
        }
        $dirty15 = $dirty14;
        if ($dirty17 &= $dirty2 == 306783378 && $dirty15 & i39 == 4793490) {
            if ($dirty15 & i39 == 4793490) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    int i98 = -29360129;
                    int i101 = -57345;
                    if (obj65 & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if (i82 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier;
                            }
                            if (empty & 16 != 0) {
                                obj44 = modifier3;
                                modifier4 = 0;
                                rememberBackdropScaffoldState = BackdropScaffoldKt.rememberBackdropScaffoldState(BackdropValue.Concealed, 0, 0, 0, restartGroup, 6, 14);
                                $dirty2 &= i101;
                            } else {
                                obj44 = modifier3;
                                modifier4 = 0;
                                rememberBackdropScaffoldState = scaffoldState;
                            }
                            if (frontLayerBackgroundColor2 != 0) {
                                snackbarHost2 = ComposableSingletons.BackdropScaffoldKt.INSTANCE.getLambda-1$material_release();
                            } else {
                                snackbarHost2 = $dirty13;
                            }
                            gesturesEnabled2 = i13 != 0 ? 1 : stickyFrontLayer2;
                            if (empty & 128 != 0) {
                                peekHeight2 = BackdropScaffoldDefaults.INSTANCE.getPeekHeight-D9Ej5fM();
                                $dirty2 &= i98;
                            } else {
                                peekHeight2 = peekHeight;
                            }
                            if (empty & 256 != 0) {
                                headerHeight2 = BackdropScaffoldDefaults.INSTANCE.getHeaderHeight-D9Ej5fM();
                                $dirty2 &= f;
                            } else {
                                headerHeight2 = headerHeight;
                            }
                            persistentAppBar3 = i3 != 0 ? 1 : persistentAppBar;
                            stickyFrontLayer3 = px-0680j_4 != 0 ? 1 : stickyFrontLayer;
                            if (empty & 2048 != 0) {
                                backLayerBackgroundColor2 = backLayerContentColor2;
                                $dirty13 = $dirty15;
                            } else {
                                backLayerBackgroundColor2 = backLayerBackgroundColor;
                                $dirty13 = $dirty15;
                            }
                            if (empty & 4096 != 0) {
                                backLayerContentColor2 = ColorsKt.contentColorFor-ek8zF_U(backLayerBackgroundColor2, frontLayerShape2, restartGroup);
                                $dirty13 &= -897;
                            } else {
                                backLayerContentColor2 = frontLayerShape;
                            }
                            if (empty & 8192 != 0) {
                                backLayerBackgroundColor4 = backLayerBackgroundColor2;
                                frontLayerShape2 = BackdropScaffoldDefaults.INSTANCE.getFrontLayerShape(restartGroup, 0);
                                $dirty13 &= -7169;
                            } else {
                                backLayerBackgroundColor4 = backLayerBackgroundColor2;
                                frontLayerShape2 = frontLayerBackgroundColor;
                            }
                            if (empty & 16384 != 0) {
                                frontLayerElevation2 = BackdropScaffoldDefaults.INSTANCE.getFrontLayerElevation-D9Ej5fM();
                                $dirty13 &= i101;
                            } else {
                                frontLayerElevation2 = frontLayerContentColor;
                            }
                            if (i59 &= empty != 0) {
                                obj46 = frontLayerElevation2;
                                $dirty13 &= i37;
                                obj45 = frontLayerShape2;
                                l2 = surface-0d7_KjU;
                            } else {
                                obj46 = frontLayerElevation2;
                                obj45 = frontLayerShape2;
                                l2 = frontLayerScrimColor;
                            }
                            if (empty & anchoredDraggableState$material_release != 0) {
                                frontLayerContentColor3 = ColorsKt.contentColorFor-ek8zF_U(l2, frontLayerShape2, restartGroup);
                                $dirty13 &= i27;
                            } else {
                                frontLayerContentColor3 = $changed;
                            }
                            if (empty & i104 != 0) {
                                i14 = obj44;
                                i26 = i36;
                                obj = snackbarHost2;
                                $dirty12 = backLayerBackgroundColor4;
                                l6 = frontLayerScrimColor3;
                                backLayerBackgroundColor3 = obj45;
                                frontLayerScrimColor2 = obj46;
                                frontLayerBackgroundColor2 = gesturesEnabled2;
                                snackbarHost3 = backLayerContentColor2;
                                i28 = stickyFrontLayer3;
                                stickyFrontLayer2 = l9;
                            } else {
                                i14 = obj44;
                                frontLayerScrimColor2 = obj46;
                                l6 = i22;
                                obj = snackbarHost2;
                                i26 = $dirty13;
                                $dirty12 = backLayerBackgroundColor4;
                                backLayerBackgroundColor3 = obj45;
                                frontLayerBackgroundColor2 = gesturesEnabled2;
                                snackbarHost3 = backLayerContentColor2;
                                i28 = stickyFrontLayer3;
                                stickyFrontLayer2 = l9;
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
                                $dirty2 &= i7;
                            }
                            if (empty & 2048 != 0) {
                                $dirty15 &= -113;
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
                                $dirty1 &= i25;
                            }
                            if (empty & anchoredDraggableState$material_release != 0) {
                                $dirty1 &= i4;
                            }
                            if (empty & i104 != 0) {
                                $dirty1 &= i98;
                            }
                            i14 = modifier;
                            i28 = stickyFrontLayer;
                            backLayerBackgroundColor3 = frontLayerBackgroundColor;
                            frontLayerScrimColor2 = frontLayerContentColor;
                            frontLayerContentColor3 = $changed;
                            i26 = $dirty1;
                            l6 = l5;
                            rememberBackdropScaffoldState = obj2;
                            peekHeight2 = f5;
                            headerHeight2 = f;
                            frontLayerBackgroundColor2 = stickyFrontLayer2;
                            obj = $dirty13;
                            persistentAppBar3 = persistentAppBar;
                            $dirty12 = backLayerBackgroundColor;
                            snackbarHost3 = frontLayerShape;
                            stickyFrontLayer2 = frontLayerScrimColor;
                        }
                    } else {
                    }
                    restartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        obj46 = $dirty12;
                        ComposerKt.traceEventStart(113877443, $dirty2, i26, "androidx.compose.material.BackdropScaffold (BackdropScaffold.kt:385)");
                    } else {
                        obj46 = $dirty12;
                    }
                    int i99 = 0;
                    obj44 = i42;
                    obj56 = i26;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    Object this_$iv = consume2;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 1348845825, "CC(remember):BackdropScaffold.kt#9igjgp");
                    if (i45 ^= 24576 > 16384) {
                        if (!restartGroup.changed(rememberBackdropScaffoldState)) {
                            i15 = $dirty2 & 24576 == 16384 ? 1 : 0;
                        } else {
                        }
                    } else {
                    }
                    Composer composer3 = restartGroup;
                    int i100 = 0;
                    it$iv = composer3.rememberedValue();
                    int i102 = 0;
                    if (i15 |= changed14 == 0) {
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
                    BackdropScaffoldKt.BackdropScaffold.backLayer.1 $i$a$WithBackdropScaffoldKt$BackdropScaffold$headerHeightPx$1 = new BackdropScaffoldKt.BackdropScaffold.backLayer.1(persistentAppBar3, rememberBackdropScaffoldState, appBar, obj5);
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 1348865590, "CC(remember):BackdropScaffold.kt#9igjgp");
                    changed12 = restartGroup.changed($this$BackdropScaffold_0hNv9B8_u24lambda_u245);
                    Composer composer2 = restartGroup;
                    int i68 = 0;
                    Object rememberedValue = composer2.rememberedValue();
                    int i103 = 0;
                    if (!changed12) {
                        obj45 = changed12;
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            obj48 = invalid$iv;
                            $i$a$CacheBackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1 = new BackdropScaffoldKt.BackdropScaffold.calculateBackLayerConstraints.1.1($this$BackdropScaffold_0hNv9B8_u24lambda_u245);
                            composer2.updateRememberedValue((Function1)$i$a$CacheBackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1);
                        } else {
                            $i$a$CacheBackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1 = rememberedValue;
                        }
                    } else {
                        obj45 = changed12;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    Object obj7 = rememberBackdropScaffoldState;
                    changed11 = peekHeight2;
                    i3 = headerHeight2;
                    i13 = stickyFrontLayer2;
                    anon = new BackdropScaffoldKt.BackdropScaffold.2(i14, (Function2)ComposableLambdaKt.rememberComposableLambda(461235665, true, $i$a$WithBackdropScaffoldKt$BackdropScaffold$headerHeightPx$1, restartGroup, 54), (Function1)$i$a$CacheBackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1, $this$BackdropScaffold_0hNv9B8_u24lambda_u245, i28, frontLayerBackgroundColor2, obj7, rememberBackdropScaffoldState.getAnchoredDraggableState$material_release(), backLayerBackgroundColor3, i13, i18, frontLayerContentColor3, i107, frontLayerScrimColor2, i3, (Density)restartGroup.consume((CompositionLocal)CompositionLocalsKt.getLocalDensity()).toPx-0680j_4(peekHeight2), changed11, frontLayerContent, l6, obj35, obj);
                    obj48 = snackbarHost3;
                    obj53 = restartGroup;
                    SurfaceKt.Surface-F-jzlyU(0, 0, obj46, gesturesEnabled, obj48, headerHeight, 0, 0, (Function2)ComposableLambdaKt.rememberComposableLambda(1961515015, true, anon, restartGroup, 54), obj53);
                    composer = obj53;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    l3 = obj5;
                    $composer2 = persistentAppBar3;
                    companion = i14;
                    i8 = i28;
                    z = frontLayerBackgroundColor2;
                    modifier2 = backLayerBackgroundColor3;
                    l7 = i13;
                    stickyFrontLayer4 = frontLayerContentColor3;
                    f6 = frontLayerScrimColor2;
                    f3 = i3;
                    f4 = changed11;
                    obj4 = obj;
                    i20 = obj56;
                    persistentAppBar2 = skipping;
                    frontLayerContentColor2 = $dirty2;
                    $dirty = obj7;
                    scaffoldState2 = l6;
                } else {
                    restartGroup.skipToGroupEnd();
                    companion = modifier;
                    f6 = frontLayerContentColor;
                    l7 = frontLayerScrimColor;
                    stickyFrontLayer4 = $changed;
                    frontLayerContentColor2 = $dirty2;
                    scaffoldState2 = l5;
                    $dirty = obj2;
                    composer = restartGroup;
                    f4 = f5;
                    f3 = f;
                    z = stickyFrontLayer2;
                    obj4 = $dirty13;
                    i20 = $dirty15;
                    $composer2 = persistentAppBar;
                    i8 = stickyFrontLayer;
                    persistentAppBar2 = backLayerBackgroundColor;
                    l3 = frontLayerShape;
                    modifier2 = frontLayerBackgroundColor;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new BackdropScaffoldKt.BackdropScaffold.3(appBar, backLayerContent, frontLayerContent, companion, $dirty, obj4, z, f4, f3, $composer2, i8, persistentAppBar2, stickyFrontLayer2, l3, anon, modifier2, f6, l7, backLayerContentColor2, stickyFrontLayer4, frontLayerBackgroundColor2, scaffoldState2, anchoredDraggableState$material_release, obj65, obj66, obj67);
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
        int traceInProgress2;
        int $dirty;
        int i4;
        int i3;
        int i10;
        int i2;
        int skipping;
        boolean traceInProgress;
        int i9;
        int i5;
        int i;
        Object modifier2;
        int rememberedValue;
        Object obj3;
        int i8;
        Object obj2;
        int str;
        Object obj;
        Object empty;
        int i6;
        Object anon;
        traceInProgress2 = -1248995194;
        final Composer obj13 = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(obj13, "C(BackdropStack)P(3)602@24951L890,602@24924L917:BackdropScaffold.kt#jmzs0o");
        if ($changed & 6 == 0) {
            i4 = obj13.changed(modifier) ? 4 : 2;
            $dirty |= i4;
        }
        i = 32;
        if ($changed & 48 == 0) {
            i3 = obj13.changedInstance(backLayer) ? i : 16;
            $dirty |= i3;
        }
        rememberedValue = 256;
        if ($changed & 384 == 0) {
            i10 = obj13.changedInstance(calculateBackLayerConstraints) ? rememberedValue : 128;
            $dirty |= i10;
        }
        i8 = 2048;
        if ($changed & 3072 == 0) {
            i2 = obj13.changedInstance(frontLayer) ? i8 : 1024;
            $dirty |= i2;
        }
        if ($dirty & 1171 == 1170) {
            if (!obj13.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty, -1, "androidx.compose.material.BackdropStack (BackdropScaffold.kt:601)");
                }
                ComposerKt.sourceInformationMarkerStart(obj13, -1431305978, "CC(remember):BackdropScaffold.kt#9igjgp");
                i9 = 1;
                str = 0;
                i7 = $dirty & 112 == i ? i9 : str;
                i5 = $dirty & 896 == rememberedValue ? i9 : str;
                if ($dirty & 7168 == i8) {
                } else {
                    i9 = str;
                }
                skipping = obj13;
                i = 0;
                rememberedValue = skipping.rememberedValue();
                i8 = 0;
                if (i13 |= i9 == 0) {
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
            obj2 = calculateBackLayerConstraints;
            obj = frontLayer;
            i6 = $changed;
        }
    }

    public static final NestedScrollConnection ConsumeSwipeNestedScrollConnection(androidx.compose.material.AnchoredDraggableState<?> state, Orientation orientation) {
        BackdropScaffoldKt.ConsumeSwipeNestedScrollConnection.1 anon = new BackdropScaffoldKt.ConsumeSwipeNestedScrollConnection.1(state, orientation);
        return (NestedScrollConnection)anon;
    }

    private static final void Scrim-3J-VO9M(long color, Function0<Unit> onDismiss, boolean visible, Composer $composer, int $changed) {
        int traceInProgress;
        int $i$f$isSpecified8_81llA;
        Modifier pointerInput;
        Object it$iv;
        int $dirty;
        int i4;
        int i9;
        int i13;
        boolean skipping;
        boolean traceInProgress2;
        int i3;
        int str;
        Composer cmp;
        androidx.compose.ui.Modifier.Companion companion2;
        int i;
        Unit iNSTANCE;
        int i7;
        Object rememberedValue;
        int i6;
        int i2;
        Composer i11;
        Object empty;
        int anon;
        int $dirty2;
        int i12;
        int i5;
        Object companion;
        int i10;
        int i8;
        final long l = color;
        final Object obj = visible;
        final boolean z = $composer;
        final int i17 = obj27;
        traceInProgress = -92141505;
        final Composer restartGroup = $changed.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(Scrim)P(0:c#ui.graphics.Color):BackdropScaffold.kt#jmzs0o");
        if (i17 & 6 == 0) {
            i4 = restartGroup.changed(l) ? 4 : 2;
            $dirty |= i4;
        }
        anon = 32;
        if (i17 & 48 == 0) {
            i9 = restartGroup.changedInstance(obj) ? anon : 16;
            $dirty |= i9;
        }
        if (i17 & 384 == 0) {
            i13 = restartGroup.changed(z) ? 256 : 128;
            $dirty |= i13;
        }
        if ($dirty & 147 == 146) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty, -1, "androidx.compose.material.Scrim (BackdropScaffold.kt:517)");
                }
                int i14 = 0;
                i = 1;
                rememberedValue = 0;
                $i$f$isSpecified8_81llA = Long.compare(skipping, i22) != 0 ? i : rememberedValue;
                if ($i$f$isSpecified8_81llA != 0) {
                    restartGroup.startReplaceGroup(478578989);
                    ComposerKt.sourceInformation(restartGroup, "519@21902L121,532@22312L62,528@22203L171");
                    i3 = z ? 1065353216 : 0;
                    TweenSpec tweenSpec3 = new TweenSpec(0, 0, 0, 7, 0);
                    i12 = rememberedValue;
                    $dirty2 = $dirty;
                    $dirty = AnimateAsStateKt.animateFloatAsState(i3, (AnimationSpec)tweenSpec3, 0, 0, 0, restartGroup, 48, 28);
                    int i18 = 0;
                    String str4 = "CC(remember):BackdropScaffold.kt#9igjgp";
                    if (z) {
                        restartGroup.startReplaceGroup(478752713);
                        ComposerKt.sourceInformation(restartGroup, "524@22109L37");
                        ComposerKt.sourceInformationMarkerStart(restartGroup, 1262370917, str4);
                        i6 = $dirty2 & 112 == anon ? empty : 0;
                        i11 = restartGroup;
                        anon = 0;
                        it$iv = i11.rememberedValue();
                        i5 = 0;
                        if (i6 == 0) {
                            if (it$iv == Composer.Companion.getEmpty()) {
                                empty = 0;
                                companion = it$iv;
                                it$iv = new BackdropScaffoldKt.Scrim.dismissModifier.1.1(obj, i18);
                                i11.updateRememberedValue((Function2)it$iv);
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
                    i7 = $dirty2 & 14 == 4 ? i30 : 0;
                    cmp = restartGroup;
                    i = 0;
                    rememberedValue = cmp.rememberedValue();
                    i2 = 0;
                    if (changed3 |= i7 == 0) {
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
            traceInProgress = new BackdropScaffoldKt.Scrim.2(l, obj2, obj, z, i17);
            endRestartGroup.updateScope((Function2)traceInProgress);
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
        int i2;
        Composer str;
        int i;
        int i5;
        Object rememberedValue;
        boolean changed;
        int i4;
        int changed2;
        int i3;
        int empty;
        Object anon;
        Object empty2;
        Object obj;
        Object snackbarHostState2;
        AnimationSpec animationSpec2;
        androidx.compose.material.BackdropScaffoldKt.rememberBackdropScaffoldState.1 anon2;
        Object obj2;
        int i6;
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
            anon2 = iNSTANCE;
        } else {
            anon2 = confirmStateChange;
        }
        String str3 = "CC(remember):BackdropScaffold.kt#9igjgp";
        if (i7 & 8 != 0) {
            ComposerKt.sourceInformationMarkerStart(composer2, -1082628462, str3);
            int i11 = 0;
            str = $composer;
            i5 = 0;
            rememberedValue = str.rememberedValue();
            i3 = 0;
            if (rememberedValue == Composer.Companion.getEmpty()) {
                empty2 = 0;
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
        i = 0;
        int i21 = 1;
        int i24 = 4;
        if (i12 ^= 6 > i24) {
            if (!composer2.changed(initialValue)) {
                i2 = i28 & 6 == i24 ? i21 : i;
            } else {
            }
        } else {
            obj = initialValue;
        }
        int i29 = 256;
        if (i25 ^= 384 > i29) {
            if (!composer2.changed(anon2)) {
                i4 = i28 & 384 == i29 ? i21 : i;
            } else {
            }
        } else {
        }
        empty = 2048;
        if (i26 ^= 3072 > empty) {
            if (!composer2.changed(obj2)) {
                if (i28 & 3072 == empty) {
                    i = i21;
                }
            } else {
            }
        } else {
        }
        Composer composer = $composer;
        int i22 = 0;
        Object rememberedValue2 = composer.rememberedValue();
        final int i30 = 0;
        if (i15 |= i == 0) {
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                i6 = 0;
                anon = new BackdropScaffoldKt.rememberBackdropScaffoldState.3.1(obj, obj3, animationSpec2, anon2, obj2);
                composer.updateRememberedValue((Function0)anon);
            } else {
                anon = rememberedValue2;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (BackdropScaffoldState)RememberSaveableKt.rememberSaveable(/* result */, BackdropScaffoldState.Companion.Saver(animationSpec2, anon2, obj2, (Density)obj3), 0, (Function0)anon, composer2, 0, 4);
    }
}
