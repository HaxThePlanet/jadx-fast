package androidx.compose.material;

import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.LayoutIdParentData;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0098\u0001\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u001aÙ\u0001\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u000c2\u0011\u0010$\u001a\r\u0012\u0004\u0012\u00020 0%¢\u0006\u0002\u0008&2\u0006\u0010'\u001a\u00020(2\u0013\u0010)\u001a\u000f\u0012\u0004\u0012\u00020 \u0018\u00010%¢\u0006\u0002\u0008&2\u0013\u0010*\u001a\u000f\u0012\u0004\u0012\u00020 \u0018\u00010%¢\u0006\u0002\u0008&2\u0013\u0010+\u001a\u000f\u0012\u0004\u0012\u00020 \u0018\u00010%¢\u0006\u0002\u0008&2\u0013\u0010,\u001a\u000f\u0012\u0004\u0012\u00020 \u0018\u00010%¢\u0006\u0002\u0008&2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020.2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u0002082\u0013\u00109\u001a\u000f\u0012\u0004\u0012\u00020 \u0018\u00010%¢\u0006\u0002\u0008&H\u0001¢\u0006\u0002\u0010:\u001aT\u0010;\u001a\u00020 2\u0006\u0010<\u001a\u00020=2\n\u0008\u0002\u0010>\u001a\u0004\u0018\u00010?2\n\u0008\u0002\u0010@\u001a\u0004\u0018\u00010A2 \u0010B\u001a\u001c\u0012\u0004\u0012\u00020 0%¢\u0006\u0002\u0008&¢\u0006\u000c\u0008C\u0012\u0008\u0008D\u0012\u0004\u0008\u0003\u0010\u0000H\u0001ø\u0001\u0000¢\u0006\u0004\u0008E\u0010F\u001a\u0012\u0010G\u001a\u00020\u00012\u0008\u0010H\u001a\u0004\u0018\u00010IH\u0000\u001a\u0012\u0010J\u001a\u00020\u00012\u0008\u0010H\u001a\u0004\u0018\u00010IH\u0000\u001a\u001c\u0010K\u001a\u00020\u0008*\u00020\u00082\u0006\u00100\u001a\u00020.2\u0006\u0010L\u001a\u00020\u000cH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\u0008\u0004\u0010\u0005\"\u0014\u0010\u0007\u001a\u00020\u0008X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n\"\u000e\u0010\u000b\u001a\u00020\u000cX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u000cX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u000cX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u000cX\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0012\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\u0008\u0013\u0010\u0005\"\u000e\u0010\u0014\u001a\u00020\u000cX\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0015\u001a\u00020\u0016X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\u0008\u0017\u0010\u0018\"\u001a\u0010\u001a\u001a\u0004\u0018\u00010\u001b*\u00020\u001c8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u001d\u0010\u001e\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006M", d2 = {"AnimationDuration", "", "HorizontalIconPadding", "Landroidx/compose/ui/unit/Dp;", "getHorizontalIconPadding", "()F", "F", "IconDefaultSizeModifier", "Landroidx/compose/ui/Modifier;", "getIconDefaultSizeModifier", "()Landroidx/compose/ui/Modifier;", "LabelId", "", "LeadingId", "PlaceholderAnimationDelayOrDuration", "PlaceholderAnimationDuration", "PlaceholderId", "TextFieldId", "TextFieldPadding", "getTextFieldPadding", "TrailingId", "ZeroConstraints", "Landroidx/compose/ui/unit/Constraints;", "getZeroConstraints", "()J", "J", "layoutId", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "getLayoutId", "(Landroidx/compose/ui/layout/IntrinsicMeasurable;)Ljava/lang/Object;", "CommonDecorationBox", "", "type", "Landroidx/compose/material/TextFieldType;", "value", "innerTextField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "label", "placeholder", "leadingIcon", "trailingIcon", "singleLine", "", "enabled", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material/TextFieldColors;", "border", "(Landroidx/compose/material/TextFieldType;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Decoration", "contentColor", "Landroidx/compose/ui/graphics/Color;", "typography", "Landroidx/compose/ui/text/TextStyle;", "contentAlpha", "", "content", "Landroidx/compose/runtime/ComposableOpenTarget;", "index", "Decoration-euL9pac", "(JLandroidx/compose/ui/text/TextStyle;Ljava/lang/Float;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "heightOrZero", "placeable", "Landroidx/compose/ui/layout/Placeable;", "widthOrZero", "defaultErrorSemantics", "defaultErrorMessage", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TextFieldImplKt {

    public static final int AnimationDuration = 150;
    private static final float HorizontalIconPadding = 0f;
    private static final Modifier IconDefaultSizeModifier = null;
    public static final String LabelId = "Label";
    public static final String LeadingId = "Leading";
    private static final int PlaceholderAnimationDelayOrDuration = 67;
    private static final int PlaceholderAnimationDuration = 83;
    public static final String PlaceholderId = "Hint";
    public static final String TextFieldId = "TextField";
    private static final float TextFieldPadding = 0f;
    public static final String TrailingId = "Trailing";
    private static final long ZeroConstraints;
    static {
        int i = 0;
        TextFieldImplKt.ZeroConstraints = ConstraintsKt.Constraints(i, i, i, i);
        int i4 = 0;
        TextFieldImplKt.TextFieldPadding = Dp.constructor-impl((float)i2);
        int i5 = 0;
        TextFieldImplKt.HorizontalIconPadding = Dp.constructor-impl((float)i3);
        int i7 = 0;
        int i8 = 0;
        TextFieldImplKt.IconDefaultSizeModifier = SizeKt.defaultMinSize-VpY3zN4((Modifier)Modifier.Companion, Dp.constructor-impl((float)i6), Dp.constructor-impl((float)$i$f$getDp));
    }

    public static final void CommonDecorationBox(androidx.compose.material.TextFieldType type, String value, Function2<? super Composer, ? super Integer, Unit> innerTextField, VisualTransformation visualTransformation, Function2<? super Composer, ? super Integer, Unit> label, Function2<? super Composer, ? super Integer, Unit> placeholder, Function2<? super Composer, ? super Integer, Unit> leadingIcon, Function2<? super Composer, ? super Integer, Unit> trailingIcon, boolean singleLine, boolean enabled, boolean isError, InteractionSource interactionSource, PaddingValues contentPadding, Shape shape, androidx.compose.material.TextFieldColors colors, Function2<? super Composer, ? super Integer, Unit> border, Composer $composer, int $changed, int $changed1) {
        Object obj4;
        boolean z;
        Object obj;
        Object obj11;
        int changed2;
        Object obj8;
        int traceInProgress2;
        boolean traceInProgress;
        int i18;
        int i19;
        int typography;
        int invoke;
        int i23;
        Object endRestartGroup;
        int i21;
        boolean equals-impl0;
        Object empty;
        Object filter;
        int i15;
        androidx.compose.material.InputPhase unfocusedNotEmpty;
        int i7;
        Object restartGroup;
        long unspecified-0d7_KjU;
        Object rememberComposableLambda;
        Object obj3;
        int $dirty;
        int $dirty1;
        Object obj6;
        int i22;
        int i13;
        Object obj9;
        boolean z3;
        androidx.compose.material.TextFieldImplKt.CommonDecorationBox.labelColor.1 z2;
        int obj10;
        Object obj2;
        int i17;
        Object obj5;
        int obj7;
        int changedInstance;
        Object i3;
        int i4;
        int changed;
        Object annotatedString;
        int $this$takeOrElse_u2dDxMtmZc$iv2;
        int i2;
        int companion;
        Composer composer;
        int i14;
        int cmp;
        int i16;
        int subtitle1;
        TextStyle caption;
        int i;
        int i5;
        int unbox-impl;
        int i10;
        int i6;
        androidx.compose.material.Typography typography2;
        int i12;
        int i11;
        int i8;
        int i9;
        int $this$takeOrElse_u2dDxMtmZc$iv;
        androidx.compose.material.TextFieldTransitionScope field;
        long unbox-impl2;
        int i20;
        ScopeUpdateScope scopeUpdateScope;
        rememberComposableLambda = visualTransformation;
        obj3 = label;
        z3 = enabled;
        z2 = isError;
        obj10 = interactionSource;
        obj7 = colors;
        int i24 = $changed;
        int i34 = $changed1;
        restartGroup = $composer.startRestartGroup(341783750);
        ComposerKt.sourceInformation(restartGroup, "C(CommonDecorationBox)P(13,14,4,15,7,9,8,12,11,3,6,5,2,10,1)82@3152L105,86@3307L25,103@3917L10,120@4754L4202,110@4252L4704:TextFieldImpl.kt#jmzs0o");
        if (i24 & 6 == 0) {
            i17 = restartGroup.changed(type) ? 4 : 2;
            $dirty |= i17;
        } else {
            obj6 = type;
        }
        if (i24 & 48 == 0) {
            i4 = restartGroup.changed(value) ? 32 : changedInstance;
            $dirty |= i4;
        } else {
            obj5 = value;
        }
        i2 = 128;
        if (i24 & 384 == 0) {
            i14 = restartGroup.changedInstance(innerTextField) ? $this$takeOrElse_u2dDxMtmZc$iv2 : i2;
            $dirty |= i14;
        } else {
            obj2 = innerTextField;
        }
        if (i24 & 3072 == 0) {
            i22 = restartGroup.changed(rememberComposableLambda) ? 2048 : cmp;
            $dirty |= i22;
        }
        caption = 8192;
        if (i24 & 24576 == 0) {
            i13 = restartGroup.changedInstance(obj3) ? subtitle1 : caption;
            $dirty |= i13;
        }
        int i49 = 196608;
        int i60 = 65536;
        if (i24 & i49 == 0) {
            i = i49;
            i6 = restartGroup.changedInstance(placeholder) ? unbox-impl : i60;
            $dirty |= i6;
        } else {
            i = i49;
            obj9 = placeholder;
        }
        if (i24 & i61 == 0) {
            i12 = restartGroup.changedInstance(leadingIcon) ? 1048576 : 524288;
            $dirty |= i12;
        } else {
            empty = leadingIcon;
        }
        if (i24 & i62 == 0) {
            i11 = restartGroup.changedInstance(trailingIcon) ? 8388608 : 4194304;
            $dirty |= i11;
        } else {
            obj4 = trailingIcon;
        }
        if ($changed & i63 == 0) {
            i8 = restartGroup.changed(singleLine) ? 67108864 : 33554432;
            $dirty |= i8;
        } else {
            z = singleLine;
        }
        if ($changed & i64 == 0) {
            i9 = restartGroup.changed(z3) ? 536870912 : 268435456;
            $dirty |= i9;
        }
        if (i34 & 6 == 0) {
            i4 = restartGroup.changed(z2) ? 4 : 2;
            $dirty1 |= i4;
        }
        if (i34 & 48 == 0 && restartGroup.changed(obj10)) {
            if (restartGroup.changed(obj10)) {
                changedInstance = 32;
            }
            $dirty1 |= changedInstance;
        }
        if (i34 & 384 == 0) {
            if (restartGroup.changed(contentPadding)) {
            } else {
                $this$takeOrElse_u2dDxMtmZc$iv2 = i2;
            }
            $dirty1 |= $this$takeOrElse_u2dDxMtmZc$iv2;
        } else {
            obj = contentPadding;
        }
        if (i34 & 3072 == 0) {
            if (restartGroup.changed(shape)) {
                cmp = 2048;
            }
            $dirty1 |= cmp;
        } else {
            obj11 = shape;
        }
        if (i34 & 24576 == 0) {
            if (restartGroup.changed(obj7)) {
            } else {
                subtitle1 = caption;
            }
            $dirty1 |= subtitle1;
        }
        if (i34 & i == 0) {
            if (restartGroup.changedInstance(border)) {
            } else {
                unbox-impl = i60;
            }
            $dirty1 |= unbox-impl;
        } else {
            obj8 = border;
        }
        if ($dirty & i3 == 306783378 && i33 &= $dirty1 == 74898) {
            if (i33 &= $dirty1 == 74898) {
                if (!restartGroup.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(341783750, $dirty, $dirty1, "androidx.compose.material.CommonDecorationBox (TextFieldImpl.kt:81)");
                    }
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 1578828051, "CC(remember):TextFieldImpl.kt#9igjgp");
                    int i52 = 0;
                    i18 = $dirty & 112 == 32 ? 1 : i52;
                    i19 = $dirty & 7168 == 2048 ? 1 : i52;
                    Composer composer2 = restartGroup;
                    int i55 = 0;
                    Object rememberedValue = composer2.rememberedValue();
                    int i58 = 0;
                    if (annotatedString | i19 == 0) {
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            int i42 = 0;
                            annotatedString = new AnnotatedString(obj5, 0, 0, 6, 0);
                            composer2.updateRememberedValue(rememberComposableLambda.filter(annotatedString));
                        } else {
                            filter = rememberedValue;
                        }
                    } else {
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    String text2 = (TransformedText)filter.getText().getText();
                    boolean booleanValue = (Boolean)FocusInteractionKt.collectIsFocusedAsState(obj10, restartGroup, i37 &= 14).getValue().booleanValue();
                    if (booleanValue) {
                        unfocusedNotEmpty = InputPhase.Focused;
                    } else {
                        i15 = (CharSequence)text2.length() == 0 ? 1 : i52;
                        unfocusedNotEmpty = i15 != 0 ? InputPhase.UnfocusedEmpty : InputPhase.UnfocusedNotEmpty;
                    }
                    TextFieldImplKt.CommonDecorationBox.labelColor.1 anon2 = new TextFieldImplKt.CommonDecorationBox.labelColor.1(obj7, z3, z2, obj10);
                    i16 = booleanValue;
                    androidx.compose.material.Typography typography3 = MaterialTheme.INSTANCE.getTypography(restartGroup, 6);
                    subtitle1 = typography3.getSubtitle1();
                    caption = typography3.getCaption();
                    androidx.compose.material.InputPhase inputPhase = unfocusedNotEmpty;
                    if (Color.equals-impl0(subtitle1.getColor-0d7_KjU(), unfocusedNotEmpty)) {
                        if (Color.equals-impl0(caption.getColor-0d7_KjU(), unfocusedNotEmpty)) {
                            if (!Color.equals-impl0(subtitle1.getColor-0d7_KjU(), unfocusedNotEmpty) && Color.equals-impl0(caption.getColor-0d7_KjU(), unfocusedNotEmpty)) {
                                i14 = Color.equals-impl0(caption.getColor-0d7_KjU(), unfocusedNotEmpty) ? 1 : i52;
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                    androidx.compose.material.TextFieldTransitionScope iNSTANCE2 = TextFieldTransitionScope.INSTANCE;
                    restartGroup.startReplaceGroup(1578865765);
                    ComposerKt.sourceInformation(restartGroup, "*112@4348L10");
                    long color-0d7_KjU5 = MaterialTheme.INSTANCE.getTypography(restartGroup, 6).getCaption().getColor-0d7_KjU();
                    i7 = 0;
                    unbox-impl = 16;
                    if (i14 != 0) {
                        typography2 = typography3;
                        restartGroup.startReplaceGroup(-1572851052);
                        ComposerKt.sourceInformation(restartGroup, "*113@4440L22");
                        int i53 = 0;
                        companion = Long.compare(l, unbox-impl) != 0 ? 1 : i52;
                        if (companion != 0) {
                            field = iNSTANCE2;
                            i21 = inputPhase;
                        } else {
                            companion = 0;
                            cmp = typography;
                            field = iNSTANCE2;
                            $this$takeOrElse_u2dDxMtmZc$iv = unbox-impl2;
                        }
                        restartGroup.endReplaceGroup();
                    } else {
                        typography2 = typography3;
                        field = iNSTANCE2;
                        i21 = inputPhase;
                        restartGroup.startReplaceGroup(780548205);
                        restartGroup.endReplaceGroup();
                        $this$takeOrElse_u2dDxMtmZc$iv = color-0d7_KjU5;
                    }
                    restartGroup.endReplaceGroup();
                    restartGroup.startReplaceGroup(1578871879);
                    ComposerKt.sourceInformation(restartGroup, "*115@4539L10");
                    long color-0d7_KjU6 = MaterialTheme.INSTANCE.getTypography(restartGroup, 6).getSubtitle1().getColor-0d7_KjU();
                    invoke = 0;
                    if (i14 != 0) {
                        restartGroup.startReplaceGroup(-1572659596);
                        ComposerKt.sourceInformation(restartGroup, "*116@4633L22");
                        i7 = 0;
                        int i54 = 0;
                        cmp = Long.compare(unbox-impl2, unbox-impl) != 0 ? 1 : i52;
                        if (cmp != 0) {
                            i5 = invoke;
                        } else {
                            cmp = 0;
                            i5 = invoke;
                            $this$takeOrElse_u2dDxMtmZc$iv2 = unbox-impl;
                        }
                        restartGroup.endReplaceGroup();
                        i = $this$takeOrElse_u2dDxMtmZc$iv2;
                    } else {
                        int i59 = invoke;
                        restartGroup.startReplaceGroup(780554381);
                        restartGroup.endReplaceGroup();
                        i = color-0d7_KjU6;
                    }
                    restartGroup.endReplaceGroup();
                    i23 = label != null ? 1 : i52;
                    i20 = $dirty;
                    i10 = $dirty1;
                    obj6 = str8;
                    TextFieldImplKt.CommonDecorationBox.3 anon = new TextFieldImplKt.CommonDecorationBox.3(label, obj9, obj6, obj7, z3, z2, obj10, leadingIcon, trailingIcon, shape, obj6, obj2, singleLine, contentPadding, i14, border);
                    changed = obj6;
                    obj5 = restartGroup;
                    field.Transition-DTcfvLk(i21, $this$takeOrElse_u2dDxMtmZc$iv, obj6, i, z3, anon2, i23, (Function6)ComposableLambdaKt.rememberComposableLambda(225557475, true, anon, restartGroup, 54));
                    composer = obj5;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    restartGroup.skipToGroupEnd();
                    composer = restartGroup;
                    i20 = $dirty;
                    i10 = $dirty1;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new TextFieldImplKt.CommonDecorationBox.4(type, value, innerTextField, visualTransformation, label, placeholder, leadingIcon, trailingIcon, singleLine, enabled, isError, interactionSource, contentPadding, shape, colors, border, $changed, $changed1);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    public static final void Decoration-euL9pac(long contentColor, TextStyle typography, Float contentAlpha, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i7) {
        int rememberComposableLambda;
        int $dirty;
        boolean $dirty2;
        int i4;
        int traceInProgress2;
        boolean traceInProgress;
        int valueOf;
        int i;
        Object obj3;
        int str;
        int i6;
        Object obj2;
        Object obj;
        int i2;
        int i3;
        int i5;
        Object obj12;
        final int i16 = i7;
        rememberComposableLambda = -399493340;
        final Composer restartGroup = $changed.startRestartGroup(rememberComposableLambda);
        ComposerKt.sourceInformation(restartGroup, "C(Decoration)P(2:c#ui.graphics.Color,3,1)230@9338L492:TextFieldImpl.kt#jmzs0o");
        $dirty = i7;
        if (obj17 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (i16 & 6 == 0) {
                i4 = restartGroup.changed(contentColor) ? 4 : 2;
                $dirty |= i4;
            }
        }
        traceInProgress2 = obj17 & 2;
        if (traceInProgress2 != 0) {
            $dirty |= 48;
        } else {
            if (i16 & 48 == 0) {
                i = restartGroup.changed(contentAlpha) ? 32 : 16;
                $dirty |= i;
            }
        }
        str = obj17 & 4;
        if (str != null) {
            $dirty |= 384;
        } else {
            if (i16 & 384 == 0) {
                i2 = restartGroup.changed(content) ? 256 : 128;
                $dirty |= i2;
            }
        }
        if (obj17 & 8 != 0) {
            $dirty |= 3072;
        } else {
            if (i16 & 3072 == 0) {
                i3 = restartGroup.changedInstance($composer) ? 2048 : 1024;
                $dirty |= i3;
            }
        }
        final int i17 = $dirty;
        if (i17 & 1171 == 1170) {
            if (!restartGroup.getSkipping()) {
                if (traceInProgress2 != 0) {
                    obj12 = 0;
                }
                $dirty2 = str != null ? 0 : content;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(rememberComposableLambda, i17, -1, "androidx.compose.material.Decoration (TextFieldImpl.kt:229)");
                }
                TextFieldImplKt.Decoration.colorAndEmphasis.1 anon = new TextFieldImplKt.Decoration.colorAndEmphasis.1(contentColor, typography, $dirty2, $composer);
                rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(494684590, true, anon, restartGroup, 54);
                if (obj12 != null) {
                    restartGroup.startReplaceGroup(2115969060);
                    ComposerKt.sourceInformation(restartGroup, "245@9859L46");
                    TextKt.ProvideTextStyle(obj12, (Function2)rememberComposableLambda, restartGroup, i11 |= 48);
                } else {
                    restartGroup.startReplaceGroup(2115970696);
                    ComposerKt.sourceInformation(restartGroup, "245@9911L18");
                    rememberComposableLambda.invoke(restartGroup, 6);
                }
                restartGroup.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj2 = $dirty2;
                obj3 = obj12;
            } else {
                restartGroup.skipToGroupEnd();
                obj2 = content;
                obj3 = contentAlpha;
            }
        } else {
        }
        obj12 = restartGroup.endRestartGroup();
        if (obj12 != null) {
            rememberComposableLambda = new TextFieldImplKt.Decoration.1(contentColor, traceInProgress2, obj3, obj2, $composer, i16, obj17);
            obj12.updateScope((Function2)rememberComposableLambda);
        }
    }

    public static final Modifier defaultErrorSemantics(Modifier $this$defaultErrorSemantics, boolean isError, String defaultErrorMessage) {
        Modifier semantics$default;
        int i2;
        int i;
        int i3;
        if (isError != null) {
            TextFieldImplKt.defaultErrorSemantics.1 anon = new TextFieldImplKt.defaultErrorSemantics.1(defaultErrorMessage);
            semantics$default = SemanticsModifierKt.semantics$default($this$defaultErrorSemantics, false, (Function1)anon, 1, 0);
        } else {
            semantics$default = $this$defaultErrorSemantics;
        }
        return semantics$default;
    }

    public static final float getHorizontalIconPadding() {
        return TextFieldImplKt.HorizontalIconPadding;
    }

    public static final Modifier getIconDefaultSizeModifier() {
        return TextFieldImplKt.IconDefaultSizeModifier;
    }

    public static final Object getLayoutId(IntrinsicMeasurable $this$layoutId) {
        Object parentData;
        int layoutId;
        if (parentData instanceof LayoutIdParentData != null) {
        } else {
            parentData = layoutId;
        }
        if (parentData != null) {
            layoutId = parentData.getLayoutId();
        }
        return layoutId;
    }

    public static final float getTextFieldPadding() {
        return TextFieldImplKt.TextFieldPadding;
    }

    public static final long getZeroConstraints() {
        return TextFieldImplKt.ZeroConstraints;
    }

    public static final int heightOrZero(Placeable placeable) {
        int height;
        if (placeable != null) {
            height = placeable.getHeight();
        } else {
            height = 0;
        }
        return height;
    }

    public static final int widthOrZero(Placeable placeable) {
        int width;
        if (placeable != null) {
            width = placeable.getWidth();
        } else {
            width = 0;
        }
        return width;
    }
}
