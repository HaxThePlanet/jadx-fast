package androidx.compose.material;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Alignment.Companion;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.graphics.TransformOriginKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode.Companion;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntRect;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0007\n\u0000\u001aY\u0010\u000f\u001a\u00020\u00102\u000c\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00130\u00122\u000c\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0017\u001a\u00020\u00182\u0008\u0008\u0002\u0010\u0019\u001a\u00020\u001a2\u001c\u0010\u001b\u001a\u0018\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00100\u001c¢\u0006\u0002\u0008\u001e¢\u0006\u0002\u0008\u001fH\u0001¢\u0006\u0002\u0010 \u001ac\u0010!\u001a\u00020\u00102\u000c\u0010\"\u001a\u0008\u0012\u0004\u0012\u00020\u00100#2\u0008\u0008\u0002\u0010\u0019\u001a\u00020\u001a2\u0008\u0008\u0002\u0010$\u001a\u00020\u00132\u0008\u0008\u0002\u0010%\u001a\u00020&2\n\u0008\u0002\u0010'\u001a\u0004\u0018\u00010(2\u001c\u0010\u001b\u001a\u0018\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00100\u001c¢\u0006\u0002\u0008\u001e¢\u0006\u0002\u0008\u001fH\u0001¢\u0006\u0002\u0010*\u001a\u001d\u0010+\u001a\u00020\u00162\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-H\u0000¢\u0006\u0002\u0010/\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0016\u0010\u0006\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\u0008\u0007\u0010\u0008\"\u000e\u0010\t\u001a\u00020\nX\u0080T¢\u0006\u0002\n\u0000\"\u0010\u0010\u000b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0016\u0010\u000c\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\u0008\r\u0010\u0008\"\u000e\u0010\u000e\u001a\u00020\nX\u0080T¢\u0006\u0002\n\u0000¨\u00060²\u0006\n\u00101\u001a\u000202X\u008a\u0084\u0002²\u0006\n\u00103\u001a\u000202X\u008a\u0084\u0002", d2 = {"DropdownMenuItemDefaultMaxWidth", "Landroidx/compose/ui/unit/Dp;", "F", "DropdownMenuItemDefaultMinHeight", "DropdownMenuItemDefaultMinWidth", "DropdownMenuItemHorizontalPadding", "DropdownMenuVerticalPadding", "getDropdownMenuVerticalPadding", "()F", "InTransitionDuration", "", "MenuElevation", "MenuVerticalMargin", "getMenuVerticalMargin", "OutTransitionDuration", "DropdownMenuContent", "", "expandedStates", "Landroidx/compose/animation/core/MutableTransitionState;", "", "transformOriginState", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/ui/graphics/TransformOrigin;", "scrollState", "Landroidx/compose/foundation/ScrollState;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/animation/core/MutableTransitionState;Landroidx/compose/runtime/MutableState;Landroidx/compose/foundation/ScrollState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DropdownMenuItemContent", "onClick", "Lkotlin/Function0;", "enabled", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "Landroidx/compose/foundation/layout/RowScope;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "calculateTransformOrigin", "parentBounds", "Landroidx/compose/ui/unit/IntRect;", "menuBounds", "(Landroidx/compose/ui/unit/IntRect;Landroidx/compose/ui/unit/IntRect;)J", "material_release", "scale", "", "alpha"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class MenuKt {

    private static final float DropdownMenuItemDefaultMaxWidth = 0f;
    private static final float DropdownMenuItemDefaultMinHeight = 0f;
    private static final float DropdownMenuItemDefaultMinWidth = 0f;
    private static final float DropdownMenuItemHorizontalPadding = 0f;
    private static final float DropdownMenuVerticalPadding = 0f;
    public static final int InTransitionDuration = 120;
    private static final float MenuElevation = 0f;
    private static final float MenuVerticalMargin = 0f;
    public static final int OutTransitionDuration = 75;
    static {
        int i8 = 0;
        MenuKt.MenuElevation = Dp.constructor-impl((float)i);
        int i9 = 0;
        MenuKt.MenuVerticalMargin = Dp.constructor-impl((float)i2);
        int i10 = 0;
        MenuKt.DropdownMenuItemHorizontalPadding = Dp.constructor-impl((float)i3);
        int i11 = 0;
        MenuKt.DropdownMenuVerticalPadding = Dp.constructor-impl((float)i4);
        int i12 = 0;
        MenuKt.DropdownMenuItemDefaultMinWidth = Dp.constructor-impl((float)i5);
        int i13 = 0;
        MenuKt.DropdownMenuItemDefaultMaxWidth = Dp.constructor-impl((float)i6);
        int i14 = 0;
        MenuKt.DropdownMenuItemDefaultMinHeight = Dp.constructor-impl((float)i7);
    }

    public static final void DropdownMenuContent(MutableTransitionState<Boolean> expandedStates, MutableState<TransformOrigin> transformOriginState, ScrollState scrollState, Modifier modifier, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i8) {
        Object transition;
        int i7;
        State transitionSpec$iv;
        Object obj;
        int i11;
        Object initialValue$iv$iv;
        int $dirty2;
        int it3;
        boolean traceInProgress;
        Object $dirty;
        int transitionAnimation;
        int i10;
        boolean it;
        int i16;
        int i14;
        int i9;
        int graphicsLayer;
        boolean traceInProgress3;
        boolean changedInstance;
        Object z2;
        boolean it2;
        int i2;
        int i3;
        int i13;
        int skipping;
        int i17;
        int i19;
        int i6;
        Composer restartGroup;
        int empty;
        float menuElevation;
        Object anon;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        Composer composer2;
        int i4;
        int i;
        int i21;
        int i15;
        int i5;
        int i18;
        Transition transition3;
        Composer $composer2;
        int i20;
        Composer composer;
        int i12;
        boolean z;
        boolean traceInProgress2;
        Transition transition2;
        Float obj31;
        obj = expandedStates;
        final Object obj3 = transformOriginState;
        final Object obj4 = scrollState;
        final Object obj6 = content;
        transitionAnimation = $changed;
        transitionSpec$iv = 435109845;
        restartGroup = $composer.startRestartGroup(transitionSpec$iv);
        ComposerKt.sourceInformation(restartGroup, "C(DropdownMenuContent)P(1,4,3,2)66@2778L50,68@2858L666,94@3554L477,114@4084L153,121@4279L248,113@4036L491:Menu.kt#jmzs0o");
        $dirty2 = $changed;
        if (i8 & 1 != 0) {
            $dirty2 |= 6;
        } else {
            if (transitionAnimation & 6 == 0) {
                if (transitionAnimation & 8 == 0) {
                    changedInstance = restartGroup.changed(obj);
                } else {
                    changedInstance = restartGroup.changedInstance(obj);
                }
                i16 = changedInstance != null ? 4 : 2;
                $dirty2 |= i16;
            }
        }
        if (i8 & 2 != 0) {
            $dirty2 |= 48;
        } else {
            if (transitionAnimation & 48 == 0) {
                i14 = restartGroup.changed(obj3) ? 32 : 16;
                $dirty2 |= i14;
            }
        }
        if (i8 & 4 != 0) {
            $dirty2 |= 384;
        } else {
            if (transitionAnimation & 384 == 0) {
                i9 = restartGroup.changed(obj4) ? 256 : 128;
                $dirty2 |= i9;
            }
        }
        graphicsLayer = i8 & 8;
        if (graphicsLayer != 0) {
            $dirty2 |= 3072;
            z2 = modifier;
        } else {
            if (transitionAnimation & 3072 == 0) {
                i3 = restartGroup.changed(modifier) ? 2048 : 1024;
                $dirty2 |= i3;
            } else {
                z2 = modifier;
            }
        }
        if (i8 & 16 != 0) {
            $dirty2 |= 24576;
        } else {
            if (transitionAnimation & 24576 == 0) {
                i13 = restartGroup.changedInstance(obj6) ? 16384 : 8192;
                $dirty2 |= i13;
            }
        }
        if ($dirty2 & 9363 == 9362) {
            if (!restartGroup.getSkipping()) {
                if (graphicsLayer != 0) {
                    z2 = graphicsLayer;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(transitionSpec$iv, $dirty2, -1, "androidx.compose.material.DropdownMenuContent (Menu.kt:64)");
                }
                Transition rememberTransition = TransitionKt.rememberTransition((TransitionState)obj, "DropDownMenu", restartGroup, i28 |= i52, 0);
                androidx.compose.material.MenuKt.DropdownMenuContent.scale.2 iNSTANCE = MenuKt.DropdownMenuContent.scale.2.INSTANCE;
                int i91 = 0;
                int i93 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1338768149, "CC(animateFloat)P(2)1966@80444L78:Transition.kt#pdpnli");
                i21 = 57344;
                Transition transition5 = transition6;
                int i95 = i58;
                int i96 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -142660079, "CC(animateValue)P(3,2)1883@77007L32,1884@77062L31,1885@77118L23,1887@77154L89:Transition.kt#pdpnli");
                int i97 = 0;
                transition = obj31;
                transition.startReplaceGroup(1652594929);
                String str4 = "C:Menu.kt#jmzs0o";
                ComposerKt.sourceInformation(transition, str4);
                if (ComposerKt.isTraceInProgress()) {
                    $composer2 = transition;
                    i12 = $dirty2;
                    ComposerKt.traceEventStart(1652594929, i82 &= 112, -1, "androidx.compose.material.DropdownMenuContent.<anonymous> (Menu.kt:85)");
                } else {
                    $composer2 = transition;
                    i12 = $dirty2;
                }
                i11 = (Boolean)transition5.getCurrentState().booleanValue() ? 1065353216 : 1061997773;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer2.endReplaceGroup();
                initialValue$iv$iv = Float.valueOf(i11);
                boolean booleanValue = (Boolean)transition5.getTargetState().booleanValue();
                Composer composer6 = restartGroup;
                int i98 = 0;
                int i22 = 1652594929;
                composer6.startReplaceGroup(i22);
                ComposerKt.sourceInformation(composer6, str4);
                if (ComposerKt.isTraceInProgress()) {
                    obj31 = initialValue$iv$iv;
                    z = booleanValue;
                    ComposerKt.traceEventStart(i22, i60 &= 112, -1, "androidx.compose.material.DropdownMenuContent.<anonymous> (Menu.kt:85)");
                } else {
                    obj31 = initialValue$iv$iv;
                    z = booleanValue;
                    it3 = -1;
                }
                i7 = z ? 1065353216 : 1061997773;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer6.endReplaceGroup();
                int i88 = it3;
                String str2 = str4;
                androidx.compose.material.MenuKt.DropdownMenuContent.scale.2 targetValue$iv$iv = iNSTANCE;
                obj = z2;
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                transitionSpec$iv = transitionAnimation2;
                androidx.compose.material.MenuKt.DropdownMenuContent.alpha.2 iNSTANCE2 = MenuKt.DropdownMenuContent.alpha.2.INSTANCE;
                int i92 = 0;
                int i94 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1338768149, "CC(animateFloat)P(2)1966@80444L78:Transition.kt#pdpnli");
                Transition transition4 = transition7;
                i15 = i39;
                i5 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -142660079, "CC(animateValue)P(3,2)1883@77007L32,1884@77062L31,1885@77118L23,1887@77154L89:Transition.kt#pdpnli");
                it2 = (Boolean)transition4.getCurrentState().booleanValue();
                Composer composer4 = restartGroup;
                int i100 = 0;
                int i89 = 388050693;
                composer4.startReplaceGroup(i89);
                ComposerKt.sourceInformation(composer4, str2);
                if (ComposerKt.isTraceInProgress()) {
                    obj31 = it2;
                    ComposerKt.traceEventStart(i89, i64 &= 112, -1, "androidx.compose.material.DropdownMenuContent.<anonymous> (Menu.kt:105)");
                } else {
                    obj31 = it2;
                }
                i10 = obj31 != null ? 1065353216 : 0;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer4.endReplaceGroup();
                it = (Boolean)transition4.getTargetState().booleanValue();
                Composer composer5 = restartGroup;
                i18 = 0;
                composer5.startReplaceGroup(i89);
                ComposerKt.sourceInformation(composer5, str2);
                if (ComposerKt.isTraceInProgress()) {
                    obj31 = it;
                    ComposerKt.traceEventStart(i89, i66 &= 112, -1, "androidx.compose.material.DropdownMenuContent.<anonymous> (Menu.kt:105)");
                } else {
                    obj31 = it;
                }
                i20 = obj31 != null ? 1065353216 : traceInProgress;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer5.endReplaceGroup();
                androidx.compose.material.MenuKt.DropdownMenuContent.alpha.2 targetValue$iv$iv2 = iNSTANCE2;
                transitionAnimation = TransitionKt.createTransitionAnimation(transition4, Float.valueOf(i10), Float.valueOf(i20), (FiniteAnimationSpec)(Function3)iNSTANCE2.invoke(transition4.getSegment(), restartGroup, Integer.valueOf(i68 &= 112)), VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), "FloatAnimation", restartGroup, i81 |= i27);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 668225020, "CC(remember):Menu.kt#9igjgp");
                int i51 = 1;
                i2 = i12 & 112 == 32 ? i51 : 0;
                Composer composer3 = restartGroup;
                int i71 = 0;
                Object rememberedValue = composer3.rememberedValue();
                if (i31 |= i2 == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        empty = 0;
                        anon = new MenuKt.DropdownMenuContent.1.1(obj3, transitionSpec$iv, transitionAnimation);
                        composer3.updateRememberedValue((Function1)anon);
                    } else {
                        anon = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                MenuKt.DropdownMenuContent.2 anon2 = new MenuKt.DropdownMenuContent.2(obj, obj4, obj6);
                i17 = 895555282;
                composer2 = composer;
                CardKt.Card-F-jzlyU(GraphicsLayerModifierKt.graphicsLayer((Modifier)Modifier.Companion, (Function1)anon), 0, 0, i17, 0, 0, 0, MenuKt.MenuElevation, (Function2)ComposableLambdaKt.rememberComposableLambda(i17, i51, anon2, restartGroup, 54), composer2);
                restartGroup = composer2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $dirty = obj;
            } else {
                restartGroup.skipToGroupEnd();
                i12 = $dirty2;
                $dirty = z2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            transitionSpec$iv = new MenuKt.DropdownMenuContent.3(expandedStates, obj3, obj4, $dirty, obj6, $changed, i8);
            endRestartGroup.updateScope((Function2)transitionSpec$iv);
        }
    }

    private static final float DropdownMenuContent$lambda$1(State<Float> $scale$delegate) {
        int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (Number)$scale$delegate.getValue().floatValue();
    }

    private static final float DropdownMenuContent$lambda$3(State<Float> $alpha$delegate) {
        int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (Number)$alpha$delegate.getValue().floatValue();
    }

    public static final void DropdownMenuItemContent(Function0<Unit> onClick, Modifier modifier, boolean enabled, PaddingValues contentPadding, MutableInteractionSource interactionSource, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i9) {
        int traceInProgress;
        Function0 factory$iv$iv$iv;
        int $dirty;
        Object obj;
        Object obj2;
        int i2;
        boolean z2;
        Object modifier2;
        int valueOf;
        Object obj3;
        Object obj7;
        Object contentPadding2;
        Composer composer;
        int i14;
        Object obj5;
        Object interactionSource2;
        boolean z;
        boolean traceInProgress2;
        int i15;
        int str;
        Object start;
        int $dirty2;
        int i;
        int rowMeasurePolicy;
        Object obj4;
        int i11;
        int i5;
        boolean skipping;
        int i10;
        int i6;
        boolean z3;
        int i12;
        int i4;
        androidx.compose.material.Typography typography;
        androidx.compose.ui.Alignment.Vertical vertical;
        int i8;
        RowScopeInstance rowScopeInstance;
        int i3;
        Modifier modifier3;
        int $changed$iv;
        Object obj6;
        Composer composer2;
        int i7;
        int i13;
        androidx.compose.runtime.CompositionLocalMap map;
        int obj33;
        Object obj34;
        Object obj35;
        int obj37;
        final Object obj9 = content;
        final int i37 = $changed;
        traceInProgress = 87134531;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(DropdownMenuItemContent)P(5,4,2,1,3)148@5150L36,142@4939L1012:Menu.kt#jmzs0o");
        $dirty = $changed;
        if (i9 & 1 != 0) {
            $dirty |= 6;
            obj = onClick;
        } else {
            if (i37 & 6 == 0) {
                i2 = restartGroup.changedInstance(onClick) ? 4 : 2;
                $dirty |= i2;
            } else {
                obj = onClick;
            }
        }
        int i26 = i9 & 2;
        if (i26 != 0) {
            $dirty |= 48;
            obj3 = modifier;
        } else {
            if (i37 & 48 == 0) {
                i14 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i14;
            } else {
                obj3 = modifier;
            }
        }
        int i34 = i9 & 4;
        if (i34 != 0) {
            $dirty |= 384;
            z = enabled;
        } else {
            if (i37 & 384 == 0) {
                i15 = restartGroup.changed(enabled) ? 256 : 128;
                $dirty |= i15;
            } else {
                z = enabled;
            }
        }
        str = i9 & 8;
        if (str != null) {
            $dirty |= 3072;
            start = contentPadding;
        } else {
            if (i37 & 3072 == 0) {
                i = restartGroup.changed(contentPadding) ? 2048 : 1024;
                $dirty |= i;
            } else {
                start = contentPadding;
            }
        }
        rowMeasurePolicy = i9 & 16;
        if (rowMeasurePolicy != 0) {
            $dirty |= 24576;
            obj4 = interactionSource;
        } else {
            if (i37 & 24576 == 0) {
                i11 = restartGroup.changed(interactionSource) ? 16384 : 8192;
                $dirty |= i11;
            } else {
                obj4 = interactionSource;
            }
        }
        int i51 = 196608;
        if (i9 & 32 != 0) {
            $dirty |= i51;
        } else {
            if (i37 & i51 == 0) {
                i5 = restartGroup.changedInstance(obj9) ? 131072 : 65536;
                $dirty |= i5;
            }
        }
        if (i49 &= $dirty == 74898) {
            if (!restartGroup.getSkipping()) {
                if (i26 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = obj3;
                }
                z3 = i34 != 0 ? obj3 : z;
                if (str != null) {
                    contentPadding2 = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                } else {
                    contentPadding2 = start;
                }
                interactionSource2 = rowMeasurePolicy != 0 ? 0 : obj4;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty, -1, "androidx.compose.material.DropdownMenuItemContent (Menu.kt:140)");
                }
                int i62 = 0;
                obj4 = modifier2;
                skipping = interactionSource2;
                z = z3;
                Modifier padding = PaddingKt.padding(SizeKt.sizeIn-qDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.clickable-O2vRcR0$default(obj4, skipping, RippleKt.rippleOrFallbackImplementation-9IZ8Weo(true, 0, 0, rowMeasurePolicy, restartGroup, 6), z3, 0, 0, obj, 24, i62), 0, 1, 0), MenuKt.DropdownMenuItemDefaultMinWidth, MenuKt.DropdownMenuItemDefaultMinHeight, MenuKt.DropdownMenuItemDefaultMaxWidth, 0, 8, i62), contentPadding2);
                androidx.compose.ui.Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                valueOf = 384;
                str = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                i6 = 0;
                obj37 = $dirty;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap = restartGroup.getCurrentCompositionLocalMap();
                obj33 = currentCompositeKeyHash;
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(restartGroup, padding);
                obj34 = padding;
                obj35 = constructor;
                i12 = 0;
                vertical = centerVertically;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                restartGroup.startReusableNode();
                if (restartGroup.getInserting()) {
                    restartGroup.createNode(obj35);
                } else {
                    factory$iv$iv$iv = obj35;
                    restartGroup.useNode();
                }
                Composer constructor-impl = Updater.constructor-impl(restartGroup);
                int i63 = 0;
                obj35 = factory$iv$iv$iv;
                Updater.set-impl(constructor-impl, RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, restartGroup, i45 |= i53), ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i64 = 0;
                Composer composer5 = constructor-impl;
                int i65 = 0;
                if (!composer5.getInserting()) {
                    $changed$iv = valueOf;
                    obj6 = contentPadding2;
                    if (!Intrinsics.areEqual(composer5.rememberedValue(), Integer.valueOf(obj33))) {
                        composer5.updateRememberedValue(Integer.valueOf(obj33));
                        constructor-impl.apply(Integer.valueOf(obj33), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer = composer5;
                    }
                } else {
                    $changed$iv = valueOf;
                    obj6 = contentPadding2;
                }
                Updater.set-impl(constructor-impl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                Composer composer3 = restartGroup;
                i8 = i20;
                ComposerKt.sourceInformationMarkerStart(composer3, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                RowScopeInstance iNSTANCE = RowScopeInstance.INSTANCE;
                i3 = 0;
                modifier3 = materializeModifier;
                i7 = i28;
                Composer $i$a$LayoutRowKt$Row$1$iv = composer4;
                ComposerKt.sourceInformationMarkerStart($i$a$LayoutRowKt$Row$1$iv, 1774663871, "C160@5667L10,161@5725L220,161@5686L259:Menu.kt#jmzs0o");
                androidx.compose.material.Typography typography2 = MaterialTheme.INSTANCE.getTypography($i$a$LayoutRowKt$Row$1$iv, 6);
                typography = typography2;
                MenuKt.DropdownMenuItemContent.1.1 typography3 = new MenuKt.DropdownMenuItemContent.1.1(z, obj9, (RowScope)iNSTANCE);
                rowScopeInstance = iNSTANCE;
                i13 = i33;
                map = currentCompositionLocalMap;
                TextKt.ProvideTextStyle(typography2.getSubtitle1(), (Function2)ComposableLambdaKt.rememberComposableLambda(1190489496, true, typography3, $i$a$LayoutRowKt$Row$1$iv, 54), $i$a$LayoutRowKt$Row$1$iv, 48);
                ComposerKt.sourceInformationMarkerEnd($i$a$LayoutRowKt$Row$1$iv);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                restartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj2 = obj4;
                obj5 = skipping;
                obj7 = obj6;
                z2 = z;
            } else {
                restartGroup.skipToGroupEnd();
                obj37 = $dirty;
                obj2 = obj3;
                obj7 = start;
                obj5 = obj4;
                z2 = z;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty2 = obj37;
            traceInProgress = new MenuKt.DropdownMenuItemContent.2(onClick, obj2, z2, obj7, obj5, obj9, i37, i9);
            endRestartGroup.updateScope((Function2)traceInProgress);
        } else {
            $dirty2 = obj37;
        }
    }

    public static final float access$DropdownMenuContent$lambda$1(State $scale$delegate) {
        return MenuKt.DropdownMenuContent$lambda$1($scale$delegate);
    }

    public static final float access$DropdownMenuContent$lambda$3(State $alpha$delegate) {
        return MenuKt.DropdownMenuContent$lambda$3($alpha$delegate);
    }

    public static final float access$getDropdownMenuItemHorizontalPadding$p() {
        return MenuKt.DropdownMenuItemHorizontalPadding;
    }

    public static final long calculateTransformOrigin(IntRect parentBounds, IntRect menuBounds) {
        int right;
        int bottom;
        int i3;
        int i;
        int i2;
        float f;
        int bottom2;
        i2 = 0;
        if (menuBounds.getLeft() >= parentBounds.getRight()) {
            i3 = i2;
        } else {
            if (menuBounds.getRight() <= parentBounds.getLeft()) {
                i3 = i;
            } else {
                if (menuBounds.getWidth() == 0) {
                    i3 = i2;
                } else {
                    f2 /= f;
                }
            }
        }
        if (menuBounds.getTop() >= parentBounds.getBottom()) {
            i = i2;
        } else {
            if (menuBounds.getBottom() <= parentBounds.getTop()) {
            } else {
                if (menuBounds.getHeight() == 0) {
                    i = i2;
                } else {
                    f3 /= i2;
                }
            }
        }
        return TransformOriginKt.TransformOrigin(i3, i);
    }

    public static final float getDropdownMenuVerticalPadding() {
        return MenuKt.DropdownMenuVerticalPadding;
    }

    public static final float getMenuVerticalMargin() {
        return MenuKt.MenuVerticalMargin;
    }
}
