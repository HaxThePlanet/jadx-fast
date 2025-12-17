package androidx.compose.material;

import androidx.compose.animation.ColorVectorConverterKt;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.FloatCompanionObject;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0008Â\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J²\u0001\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u00082\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00080\u000b¢\u0006\u0002\u0008\u000c2\u0006\u0010\r\u001a\u00020\u000e2e\u0010\u000f\u001aa\u0012\u0013\u0012\u00110\u0011¢\u0006\u000c\u0008\u0012\u0012\u0008\u0008\u0013\u0012\u0004\u0008\u0008(\u0014\u0012\u0013\u0012\u00110\u0008¢\u0006\u000c\u0008\u0012\u0012\u0008\u0008\u0013\u0012\u0004\u0008\u0008(\u0015\u0012\u0013\u0012\u00110\u0008¢\u0006\u000c\u0008\u0012\u0012\u0008\u0008\u0013\u0012\u0004\u0008\u0008(\u0016\u0012\u0013\u0012\u00110\u0011¢\u0006\u000c\u0008\u0012\u0012\u0008\u0008\u0013\u0012\u0004\u0008\u0008(\u0017\u0012\u0004\u0012\u00020\u00040\u0010¢\u0006\u0002\u0008\u000cH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0018\u0010\u0019\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u001a²\u0006\n\u0010\u0014\u001a\u00020\u0011X\u008a\u0084\u0002²\u0006\n\u0010\u0017\u001a\u00020\u0011X\u008a\u0084\u0002²\u0006\n\u0010\u0015\u001a\u00020\u0008X\u008a\u0084\u0002²\u0006\n\u0010\u0016\u001a\u00020\u0008X\u008a\u0084\u0002", d2 = {"Landroidx/compose/material/TextFieldTransitionScope;", "", "()V", "Transition", "", "inputState", "Landroidx/compose/material/InputPhase;", "focusedTextStyleColor", "Landroidx/compose/ui/graphics/Color;", "unfocusedTextStyleColor", "contentColor", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composable;", "showLabel", "", "content", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "labelProgress", "labelTextStyleColor", "labelContentColor", "placeholderOpacity", "Transition-DTcfvLk", "(Landroidx/compose/material/InputPhase;JJLkotlin/jvm/functions/Function3;ZLkotlin/jvm/functions/Function6;Landroidx/compose/runtime/Composer;I)V", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class TextFieldTransitionScope {

    public static final androidx.compose.material.TextFieldTransitionScope INSTANCE;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int ordinal;
            int ordinal2;
            int ordinal3;
            int[] iArr = new int[values.length];
            iArr[InputPhase.Focused.ordinal()] = 1;
            iArr[InputPhase.UnfocusedEmpty.ordinal()] = 2;
            iArr[InputPhase.UnfocusedNotEmpty.ordinal()] = 3;
            TextFieldTransitionScope.WhenMappings.$EnumSwitchMapping$0 = iArr;
        }
    }
    static {
        TextFieldTransitionScope textFieldTransitionScope = new TextFieldTransitionScope();
        TextFieldTransitionScope.INSTANCE = textFieldTransitionScope;
    }

    private static final float Transition_DTcfvLk$lambda$1(State<Float> $labelProgress$delegate) {
        int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (Number)$labelProgress$delegate.getValue().floatValue();
    }

    private static final float Transition_DTcfvLk$lambda$3(State<Float> $placeholderOpacity$delegate) {
        int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (Number)$placeholderOpacity$delegate.getValue().floatValue();
    }

    private static final long Transition_DTcfvLk$lambda$5(State<Color> $labelTextStyleColor$delegate) {
        int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (Color)$labelTextStyleColor$delegate.getValue().unbox-impl();
    }

    private static final long Transition_DTcfvLk$lambda$6(State<Color> $labelContentColor$delegate) {
        int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (Color)$labelContentColor$delegate.getValue().unbox-impl();
    }

    public final void Transition-DTcfvLk(androidx.compose.material.InputPhase inputState, long focusedTextStyleColor, long unfocusedTextStyleColor, Function3<? super androidx.compose.material.InputPhase, ? super Composer, ? super Integer, Color> contentColor, boolean showLabel, Function6<? super Float, ? super Color, ? super Color, ? super Float, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        boolean traceInProgress3;
        Object invoke;
        Object transitionAnimation;
        boolean traceInProgress;
        Object transitionAnimation2;
        Object $composer6;
        int i13;
        Object it;
        int i19;
        Object iNSTANCE;
        int $dirty2;
        int i;
        long l3;
        int $composer4;
        Object initialValue$iv$iv;
        int i11;
        State placeholderOpacity$delegate;
        int i2;
        Object $composer2;
        int i7;
        Object it2;
        int i18;
        int i5;
        int i16;
        int i10;
        int i4;
        int skipping;
        boolean traceInProgress2;
        State transitionSpec$iv;
        Transition $this$animateColor$iv;
        Object typeConverter$iv2;
        int empty;
        Object obj;
        long l4;
        Float valueOf2;
        Color box-impl2;
        Color box-impl;
        Float valueOf;
        Composer composer3;
        Composer $composer3;
        Integer $composer7;
        Object it3;
        Float initialValue$iv$iv2;
        Object companion2;
        int i3;
        int i8;
        int i14;
        int i9;
        State placeholderOpacity$delegate2;
        Composer composer;
        Transition transition;
        int i17;
        Object companion;
        int i15;
        int $dirty;
        Composer composer2;
        int i6;
        Transition transition2;
        Composer $composer5;
        long l2;
        long l;
        int i12;
        State state;
        Object obj2;
        androidx.compose.ui.graphics.colorspace.ColorSpace colorSpace;
        Object typeConverter$iv;
        long l5;
        Float num;
        State obj46;
        iNSTANCE = inputState;
        final Object obj3 = content;
        final boolean z = $composer;
        final int i75 = obj47;
        traceInProgress = 1988729962;
        transitionAnimation2 = obj46.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(transitionAnimation2, "C(Transition)P(3,2:c#ui.graphics.Color,5:c#ui.graphics.Color,1,4)276@11175L59,278@11276L325,289@11648L1101,317@12797L299,327@13142L186,333@13338L140:TextFieldImpl.kt#jmzs0o");
        if (i75 & 6 == 0) {
            i = transitionAnimation2.changed(iNSTANCE) ? 4 : 2;
            $dirty2 |= i;
        }
        if (i75 & 48 == 0) {
            i18 = transitionAnimation2.changed(focusedTextStyleColor) ? 32 : 16;
            $dirty2 |= i18;
        } else {
            l3 = focusedTextStyleColor;
        }
        if (i75 & 384 == 0) {
            i5 = transitionAnimation2.changed(contentColor) ? 256 : 128;
            $dirty2 |= i5;
        } else {
            l4 = contentColor;
        }
        if (i75 & 3072 == 0) {
            i16 = transitionAnimation2.changedInstance(obj3) ? 2048 : 1024;
            $dirty2 |= i16;
        }
        if (i75 & 24576 == 0) {
            i10 = transitionAnimation2.changed(z) ? 16384 : 8192;
            $dirty2 |= i10;
        }
        if (i65 &= i75 == 0) {
            i4 = transitionAnimation2.changedInstance($changed) ? 131072 : 65536;
            $dirty2 |= i4;
        } else {
            obj = $changed;
        }
        if (i66 &= $dirty2 == 74898) {
            if (!transitionAnimation2.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty2, -1, "androidx.compose.material.TextFieldTransitionScope.Transition (TextFieldImpl.kt:272)");
                }
                Transition transition3 = TransitionKt.updateTransition(iNSTANCE, "TextFieldInputState", transitionAnimation2, i20 |= 48, 0);
                int i160 = i118;
                int i162 = 0;
                ComposerKt.sourceInformationMarkerStart(transitionAnimation2, -1338768149, "CC(animateFloat)P(2)1966@80444L78:Transition.kt#pdpnli");
                int i164 = 57344;
                Transition transition5 = transition8;
                int i165 = i107;
                int i167 = 0;
                String str6 = "CC(animateValue)P(3,2)1883@77007L32,1884@77062L31,1885@77118L23,1887@77154L89:Transition.kt#pdpnli";
                ComposerKt.sourceInformationMarkerStart(transitionAnimation2, -142660079, str6);
                int i168 = 0;
                transition2 = transition3;
                $composer6 = composer16;
                $composer6.startReplaceGroup(-1158004136);
                String str = "C:TextFieldImpl.kt#jmzs0o";
                ComposerKt.sourceInformation($composer6, str);
                if (ComposerKt.isTraceInProgress()) {
                    $composer5 = $composer6;
                    ComposerKt.traceEventStart(-1158004136, i156 & 112, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:282)");
                } else {
                    $composer5 = $composer6;
                }
                switch (i33) {
                    case 1:
                        i13 = 1065353216;
                        break;
                    case 2:
                        i13 = 0;
                        break;
                    case 3:
                        i13 = 1065353216;
                        break;
                    default:
                        NoWhenBranchMatchedException noWhenBranchMatchedException4 = new NoWhenBranchMatchedException();
                        throw noWhenBranchMatchedException4;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer5.endReplaceGroup();
                it = transition5.getTargetState();
                int i169 = 0;
                Composer composer4 = composer17;
                int i54 = -1158004136;
                composer4.startReplaceGroup(i54);
                ComposerKt.sourceInformation(composer4, str);
                if (ComposerKt.isTraceInProgress()) {
                    it3 = it;
                    composer2 = composer4;
                    ComposerKt.traceEventStart(i54, i124 &= 112, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:282)");
                } else {
                    it3 = it;
                    composer2 = composer4;
                    $composer4 = -1;
                }
                switch (i34) {
                    case 1:
                        i19 = 1065353216;
                        break;
                    case 2:
                        i19 = 0;
                        break;
                    case 3:
                        i19 = 1065353216;
                        break;
                    default:
                        NoWhenBranchMatchedException noWhenBranchMatchedException3 = new NoWhenBranchMatchedException();
                        throw noWhenBranchMatchedException3;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer2.endReplaceGroup();
                Object obj4 = invoke6;
                i6 = 458752;
                Composer composer11 = transitionAnimation2;
                int i57 = $composer4;
                String $composer8 = str6;
                int i38 = 384;
                Float num2 = valueOf5;
                Transition targetValue$iv$iv3 = transition5;
                Composer $this$animateValue$iv$iv = composer11;
                Object $composer12 = obj4;
                Float animationSpec$iv$iv = num;
                ComposerKt.sourceInformationMarkerEnd($this$animateValue$iv$iv);
                ComposerKt.sourceInformationMarkerEnd($this$animateValue$iv$iv);
                transitionSpec$iv = transitionAnimation3;
                androidx.compose.material.TextFieldTransitionScope.Transition.placeholderOpacity.2 iNSTANCE4 = TextFieldTransitionScope.Transition.placeholderOpacity.2.INSTANCE;
                int i161 = i38;
                int i163 = 0;
                ComposerKt.sourceInformationMarkerStart($this$animateValue$iv$iv, -1338768149, "CC(animateFloat)P(2)1966@80444L78:Transition.kt#pdpnli");
                int i166 = i111 | i133;
                Transition transition7 = transition9;
                companion = 0;
                ComposerKt.sourceInformationMarkerStart($this$animateValue$iv$iv, -142660079, $composer8);
                obj46 = i38;
                int i158 = 0;
                int i35 = -1376159017;
                $composer2 = composer12;
                $composer2.startReplaceGroup(i35);
                ComposerKt.sourceInformation($composer2, str);
                if (ComposerKt.isTraceInProgress()) {
                    $composer3 = $composer2;
                    state = transitionSpec$iv;
                    ComposerKt.traceEventStart(i35, i145 & 112, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:310)");
                } else {
                    $composer3 = $composer2;
                    state = transitionSpec$iv;
                }
                switch (i58) {
                    case 1:
                        i7 = 1065353216;
                        break;
                    case 2:
                        i7 = 0;
                        i7 = 1065353216;
                        break;
                    case 3:
                        i7 = 0;
                        break;
                    default:
                        NoWhenBranchMatchedException noWhenBranchMatchedException2 = new NoWhenBranchMatchedException();
                        throw noWhenBranchMatchedException2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer3.endReplaceGroup();
                initialValue$iv$iv = Float.valueOf(i7);
                it2 = transition7.getTargetState();
                Composer composer9 = $this$animateValue$iv$iv;
                int i146 = 0;
                composer9.startReplaceGroup(i35);
                ComposerKt.sourceInformation(composer9, str);
                if (ComposerKt.isTraceInProgress()) {
                    initialValue$iv$iv2 = initialValue$iv$iv;
                    obj2 = it2;
                    ComposerKt.traceEventStart(i35, i68 &= 112, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:310)");
                } else {
                    initialValue$iv$iv2 = initialValue$iv$iv;
                    obj2 = it2;
                }
                switch (i36) {
                    case 1:
                        i11 = 1065353216;
                        break;
                    case 2:
                        i11 = 0;
                        i11 = 1065353216;
                        break;
                    case 3:
                        i11 = 0;
                        break;
                    default:
                        NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                        throw noWhenBranchMatchedException;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer9.endReplaceGroup();
                Composer composer13 = $this$animateValue$iv$iv;
                androidx.compose.material.TextFieldTransitionScope.Transition.placeholderOpacity.2 targetValue$iv$iv2 = iNSTANCE4;
                placeholderOpacity$delegate = TransitionKt.createTransitionAnimation(transition7, initialValue$iv$iv2, Float.valueOf(i11), (FiniteAnimationSpec)(Function3)iNSTANCE4.invoke(transition7.getSegment(), $this$animateValue$iv$iv, Integer.valueOf(i59 &= 112)), VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), "PlaceholderOpacity", composer13, i41 |= i64);
                i2 = composer13;
                ComposerKt.sourceInformationMarkerEnd(i2);
                ComposerKt.sourceInformationMarkerEnd(i2);
                $this$animateColor$iv = transition2;
                int i159 = obj46;
                i14 = 0;
                ComposerKt.sourceInformationMarkerStart(i2, -1939694975, "CC(animateColor)P(2)68@3220L31,69@3287L70,73@3370L70:Transition.kt#xbi5r1");
                Composer composer6 = i2;
                int i134 = 0;
                composer6.startReplaceGroup(-1490209928);
                ComposerKt.sourceInformation(composer6, str);
                String str11 = "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:321)";
                if (ComposerKt.isTraceInProgress()) {
                    placeholderOpacity$delegate2 = placeholderOpacity$delegate;
                    transition = $this$animateColor$iv;
                    ComposerKt.traceEventStart(-1490209928, i84 &= 112, -1, str11);
                } else {
                    placeholderOpacity$delegate2 = placeholderOpacity$delegate;
                    transition = $this$animateColor$iv;
                }
                l = TextFieldTransitionScope.WhenMappings.$EnumSwitchMapping$0[(InputPhase)$this$animateColor$iv.getTargetState().ordinal()] == 1 ? focusedTextStyleColor : contentColor;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer6.endReplaceGroup();
                androidx.compose.ui.graphics.colorspace.ColorSpace colorSpace-impl = Color.getColorSpace-impl(l);
                ComposerKt.sourceInformationMarkerStart(i2, 1918408083, "CC(remember):Transition.kt#9igjgp");
                Composer composer5 = i2;
                int i112 = 0;
                Object rememberedValue = composer5.rememberedValue();
                int i147 = 0;
                if (!i2.changed(colorSpace-impl)) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        i12 = i74;
                        composer5.updateRememberedValue((TwoWayConverter)ColorVectorConverterKt.getVectorConverter(Color.Companion).invoke(colorSpace-impl));
                    } else {
                        typeConverter$iv2 = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(i2);
                i15 = i80 | i91;
                Transition transition6 = transition;
                i12 = 0;
                ComposerKt.sourceInformationMarkerStart(i2, -142660079, $composer8);
                Composer composer10 = i2;
                int i148 = 0;
                colorSpace = colorSpace-impl;
                int colorSpace$iv = -1490209928;
                composer10.startReplaceGroup(colorSpace$iv);
                ComposerKt.sourceInformation(composer10, str);
                if (ComposerKt.isTraceInProgress()) {
                    typeConverter$iv = typeConverter$iv2;
                    ComposerKt.traceEventStart(colorSpace$iv, i113 &= 112, -1, str11);
                } else {
                    typeConverter$iv = typeConverter$iv2;
                }
                l5 = TextFieldTransitionScope.WhenMappings.$EnumSwitchMapping$0[(InputPhase)transition6.getCurrentState().ordinal()] == 1 ? focusedTextStyleColor : contentColor;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer10.endReplaceGroup();
                Composer composer7 = i2;
                int i135 = 0;
                int it5 = -1490209928;
                composer7.startReplaceGroup(it5);
                ComposerKt.sourceInformation(composer7, str);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(it5, i71 &= 112, -1, str11);
                }
                l2 = TextFieldTransitionScope.WhenMappings.$EnumSwitchMapping$0[(InputPhase)transition6.getTargetState().ordinal()] == 1 ? focusedTextStyleColor : contentColor;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer7.endReplaceGroup();
                transitionAnimation = TransitionKt.createTransitionAnimation(transition6, Color.box-impl(l5), Color.box-impl(l2), (FiniteAnimationSpec)(Function3)TextFieldTransitionScope.Transition.labelTextStyleColor.2.INSTANCE.invoke(transition6.getSegment(), i2, Integer.valueOf(i46 &= 112)), typeConverter$iv, "LabelTextStyleColor", i2, i24 | i51);
                ComposerKt.sourceInformationMarkerEnd(i2);
                ComposerKt.sourceInformationMarkerEnd(i2);
                i52 |= i73;
                skipping = transition2;
                i8 = 0;
                ComposerKt.sourceInformationMarkerStart(i2, -1939694975, "CC(animateColor)P(2)68@3220L31,69@3287L70,73@3370L70:Transition.kt#xbi5r1");
                Integer valueOf10 = Integer.valueOf(i93 &= 112);
                androidx.compose.ui.graphics.colorspace.ColorSpace colorSpace-impl2 = Color.getColorSpace-impl((Color)obj3.invoke(skipping.getTargetState(), i2, valueOf10).unbox-impl());
                ComposerKt.sourceInformationMarkerStart(i2, 1918408083, "CC(remember):Transition.kt#9igjgp");
                Composer composer8 = i2;
                int i136 = 0;
                Object rememberedValue2 = composer8.rememberedValue();
                int i149 = 0;
                if (!i2.changed(colorSpace-impl2)) {
                    obj46 = transitionAnimation;
                    if (rememberedValue2 == Composer.Companion.getEmpty()) {
                        i14 = labelTextStyleColor$delegate;
                        composer8.updateRememberedValue((TwoWayConverter)ColorVectorConverterKt.getVectorConverter(Color.Companion).invoke(colorSpace-impl2));
                    } else {
                        invoke = rememberedValue2;
                    }
                } else {
                    obj46 = transitionAnimation;
                }
                ComposerKt.sourceInformationMarkerEnd(i2);
                i27 |= i101;
                Transition colorSpace$iv2 = skipping;
                i9 = 0;
                ComposerKt.sourceInformationMarkerStart(i2, -142660079, $composer8);
                i17 = i28;
                Composer composer15 = i2;
                androidx.compose.ui.graphics.colorspace.ColorSpace colorSpace2 = colorSpace3;
                ComposerKt.sourceInformationMarkerEnd(composer15);
                ComposerKt.sourceInformationMarkerEnd(composer15);
                composer3 = composer15;
                obj.invoke(Float.valueOf(TextFieldTransitionScope.Transition_DTcfvLk$lambda$1(state)), Color.box-impl(TextFieldTransitionScope.Transition_DTcfvLk$lambda$5(obj46)), Color.box-impl(TextFieldTransitionScope.Transition_DTcfvLk$lambda$6(TransitionKt.createTransitionAnimation(colorSpace$iv2, obj3.invoke(colorSpace$iv2.getCurrentState(), i2, Integer.valueOf(i116 &= 112)), obj3.invoke(colorSpace$iv2.getTargetState(), i2, Integer.valueOf(i137 &= 112)), (FiniteAnimationSpec)(Function3)TextFieldTransitionScope.Transition.labelContentColor.2.INSTANCE.invoke(colorSpace$iv2.getSegment(), i2, Integer.valueOf(i150 &= 112)), (TwoWayConverter)invoke, "LabelContentColor", composer15, i30 | i155))), Float.valueOf(TextFieldTransitionScope.Transition_DTcfvLk$lambda$3(placeholderOpacity$delegate2)), composer3, Integer.valueOf(i31 &= i164));
                composer = composer3;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
                if (endRestartGroup != null) {
                    $dirty = $dirty2;
                    traceInProgress = new TextFieldTransitionScope.Transition.1(this, inputState, focusedTextStyleColor, l3, contentColor, skipping, obj3, z, $changed, i75);
                    endRestartGroup.updateScope((Function2)traceInProgress);
                } else {
                    $dirty = $dirty2;
                }
            }
            transitionAnimation2.skipToGroupEnd();
            composer = transitionAnimation2;
        } else {
        }
    }
}
