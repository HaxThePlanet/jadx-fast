package androidx.compose.material3.internal;

import androidx.compose.animation.ColorVectorConverterKt;
import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.ContentColorKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextFieldKt;
import androidx.compose.material3.Typography;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.Size.Companion;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.graphics.ColorProducer;
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
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.FloatCompanionObject;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000º\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0010\u0008\n\u0002\u0008\u000f\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a \u0002\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u00012\u0011\u00102\u001a\r\u0012\u0004\u0012\u00020.03¢\u0006\u0002\u000842\u0006\u00105\u001a\u0002062\u0013\u00107\u001a\u000f\u0012\u0004\u0012\u00020.\u0018\u000103¢\u0006\u0002\u000842\u0015\u0008\u0002\u00108\u001a\u000f\u0012\u0004\u0012\u00020.\u0018\u000103¢\u0006\u0002\u000842\u0015\u0008\u0002\u00109\u001a\u000f\u0012\u0004\u0012\u00020.\u0018\u000103¢\u0006\u0002\u000842\u0015\u0008\u0002\u0010:\u001a\u000f\u0012\u0004\u0012\u00020.\u0018\u000103¢\u0006\u0002\u000842\u0015\u0008\u0002\u0010;\u001a\u000f\u0012\u0004\u0012\u00020.\u0018\u000103¢\u0006\u0002\u000842\u0015\u0008\u0002\u0010<\u001a\u000f\u0012\u0004\u0012\u00020.\u0018\u000103¢\u0006\u0002\u000842\u0015\u0008\u0002\u0010=\u001a\u000f\u0012\u0004\u0012\u00020.\u0018\u000103¢\u0006\u0002\u000842\u0008\u0008\u0002\u0010>\u001a\u00020?2\u0008\u0008\u0002\u0010@\u001a\u00020?2\u0008\u0008\u0002\u0010A\u001a\u00020?2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020G2\u0011\u0010H\u001a\r\u0012\u0004\u0012\u00020.03¢\u0006\u0002\u00084H\u0001¢\u0006\u0002\u0010I\u001a-\u0010J\u001a\u00020.2\u0006\u0010K\u001a\u00020L2\u0011\u0010M\u001a\r\u0012\u0004\u0012\u00020.03¢\u0006\u0002\u00084H\u0003ø\u0001\u0000¢\u0006\u0004\u0008N\u0010O\u001a5\u0010J\u001a\u00020.2\u0006\u0010K\u001a\u00020L2\u0006\u0010P\u001a\u00020Q2\u0011\u0010M\u001a\r\u0012\u0004\u0012\u00020.03¢\u0006\u0002\u00084H\u0003ø\u0001\u0000¢\u0006\u0004\u0008R\u0010S\u001a×\u0001\u0010T\u001a\u00020.2\u0006\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020L2\u0006\u0010X\u001a\u00020L2\u0006\u0010Y\u001a\u00020L2\u0006\u0010Z\u001a\u00020?2\u0099\u0001\u0010M\u001a\u0094\u0001\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020]0\\¢\u0006\u000c\u0008^\u0012\u0008\u0008_\u0012\u0004\u0008\u0008(`\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020L0\\¢\u0006\u000c\u0008^\u0012\u0008\u0008_\u0012\u0004\u0008\u0008(a\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020L0\\¢\u0006\u000c\u0008^\u0012\u0008\u0008_\u0012\u0004\u0008\u0008(b\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020]0\\¢\u0006\u000c\u0008^\u0012\u0008\u0008_\u0012\u0004\u0008\u0008(c\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020]0\\¢\u0006\u000c\u0008^\u0012\u0008\u0008_\u0012\u0004\u0008\u0008(d\u0012\u0004\u0012\u00020.0[¢\u0006\u0002\u00084H\u0083\u0008ø\u0001\u0000¢\u0006\u0004\u0008e\u0010f\u001aH\u0010g\u001a\u0008\u0012\u0004\u0012\u00020h0\\2\u0006\u0010@\u001a\u00020?2\u0006\u0010A\u001a\u00020?2\u0006\u0010i\u001a\u00020?2\u0006\u0010F\u001a\u00020G2\u0006\u0010j\u001a\u00020\u00032\u0006\u0010k\u001a\u00020\u0003H\u0001ø\u0001\u0000¢\u0006\u0004\u0008l\u0010m\u001a\u0012\u0010n\u001a\u00020\u00142\u0008\u0010o\u001a\u0004\u0018\u00010pH\u0000\u001a\u0012\u0010q\u001a\u00020\u00142\u0008\u0010o\u001a\u0004\u0018\u00010pH\u0000\u001a\u001c\u0010r\u001a\u00020\u0008*\u00020\u00082\u0006\u0010A\u001a\u00020?2\u0006\u0010s\u001a\u00020\u0001H\u0000\u001a\u001c\u0010t\u001a\u00020\u0008*\u00020\u00082\u0006\u0010u\u001a\u00020v2\u0006\u0010w\u001a\u00020xH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\u0008\u0004\u0010\u0005\"\u0014\u0010\u0007\u001a\u00020\u0008X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000c\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010\r\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\u0008\u000e\u0010\u0005\"\u0016\u0010\u000f\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\u0008\u0010\u0010\u0005\"\u0016\u0010\u0011\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\u0008\u0012\u0010\u0005\"\u000e\u0010\u0013\u001a\u00020\u0014X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0014X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0018\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\u0008\u0019\u0010\u0005\"\u000e\u0010\u001a\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010\u001c\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\u0008\u001d\u0010\u0005\"\u000e\u0010\u001e\u001a\u00020\u0014X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001f\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010 \u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\u0008!\u0010\u0005\"\u000e\u0010\"\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010#\u001a\u00020$X\u0080\u0004¢\u0006\n\n\u0002\u0010'\u001a\u0004\u0008%\u0010&\"\u001a\u0010(\u001a\u0004\u0018\u00010)*\u00020*8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008+\u0010,\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006y²\u0006\n\u0010z\u001a\u00020?X\u008a\u0084\u0002²\u0006\n\u0010{\u001a\u00020?X\u008a\u0084\u0002", d2 = {"ContainerId", "", "HorizontalIconPadding", "Landroidx/compose/ui/unit/Dp;", "getHorizontalIconPadding", "()F", "F", "IconDefaultSizeModifier", "Landroidx/compose/ui/Modifier;", "getIconDefaultSizeModifier", "()Landroidx/compose/ui/Modifier;", "LabelId", "LeadingId", "MinFocusedLabelLineHeight", "getMinFocusedLabelLineHeight", "MinSupportingTextLineHeight", "getMinSupportingTextLineHeight", "MinTextLineHeight", "getMinTextLineHeight", "PlaceholderAnimationDelayOrDuration", "", "PlaceholderAnimationDuration", "PlaceholderId", "PrefixId", "PrefixSuffixTextPadding", "getPrefixSuffixTextPadding", "SuffixId", "SupportingId", "SupportingTopPadding", "getSupportingTopPadding", "TextFieldAnimationDuration", "TextFieldId", "TextFieldPadding", "getTextFieldPadding", "TrailingId", "ZeroConstraints", "Landroidx/compose/ui/unit/Constraints;", "getZeroConstraints", "()J", "J", "layoutId", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "getLayoutId", "(Landroidx/compose/ui/layout/IntrinsicMeasurable;)Ljava/lang/Object;", "CommonDecorationBox", "", "type", "Landroidx/compose/material3/internal/TextFieldType;", "value", "innerTextField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "label", "placeholder", "leadingIcon", "trailingIcon", "prefix", "suffix", "supportingText", "singleLine", "", "enabled", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "colors", "Landroidx/compose/material3/TextFieldColors;", "container", "(Landroidx/compose/material3/internal/TextFieldType;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/material3/TextFieldColors;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "Decoration", "contentColor", "Landroidx/compose/ui/graphics/Color;", "content", "Decoration-Iv8Zu3U", "(JLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "Decoration-3J-VO9M", "(JLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "TextFieldTransitionScope", "inputState", "Landroidx/compose/material3/internal/InputPhase;", "focusedLabelTextStyleColor", "unfocusedLabelTextStyleColor", "labelColor", "showLabel", "Lkotlin/Function5;", "Landroidx/compose/runtime/State;", "", "Lkotlin/ParameterName;", "name", "labelProgress", "labelTextStyleColor", "labelContentColor", "placeholderOpacity", "prefixSuffixOpacity", "TextFieldTransitionScope-Jy8F4Js", "(Landroidx/compose/material3/internal/InputPhase;JJJZLkotlin/jvm/functions/Function7;Landroidx/compose/runtime/Composer;I)V", "animateBorderStrokeAsState", "Landroidx/compose/foundation/BorderStroke;", "focused", "focusedBorderThickness", "unfocusedBorderThickness", "animateBorderStrokeAsState-NuRrP5Q", "(ZZZLandroidx/compose/material3/TextFieldColors;FFLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "heightOrZero", "placeable", "Landroidx/compose/ui/layout/Placeable;", "widthOrZero", "defaultErrorSemantics", "defaultErrorMessage", "textFieldBackground", "color", "Landroidx/compose/ui/graphics/ColorProducer;", "shape", "Landroidx/compose/ui/graphics/Shape;", "material3_release", "showPlaceholder", "showPrefixSuffix"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TextFieldImplKt {

    public static final String ContainerId = "Container";
    private static final float HorizontalIconPadding = 0f;
    private static final Modifier IconDefaultSizeModifier = null;
    public static final String LabelId = "Label";
    public static final String LeadingId = "Leading";
    private static final float MinFocusedLabelLineHeight = 0f;
    private static final float MinSupportingTextLineHeight = 0f;
    private static final float MinTextLineHeight = 0f;
    private static final int PlaceholderAnimationDelayOrDuration = 67;
    private static final int PlaceholderAnimationDuration = 83;
    public static final String PlaceholderId = "Hint";
    public static final String PrefixId = "Prefix";
    private static final float PrefixSuffixTextPadding = 0f;
    public static final String SuffixId = "Suffix";
    public static final String SupportingId = "Supporting";
    private static final float SupportingTopPadding = 0f;
    public static final int TextFieldAnimationDuration = 150;
    public static final String TextFieldId = "TextField";
    private static final float TextFieldPadding = 0f;
    public static final String TrailingId = "Trailing";
    private static final long ZeroConstraints;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        public static final int[] $EnumSwitchMapping$1;
        static {
            int i;
            int ordinal2;
            int ordinal3;
            int ordinal4;
            int ordinal;
            int[] iArr = new int[values.length];
            i = 1;
            iArr[TextFieldType.Filled.ordinal()] = i;
            int i2 = 2;
            iArr[TextFieldType.Outlined.ordinal()] = i2;
            TextFieldImplKt.WhenMappings.$EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[values2.length];
            iArr2[InputPhase.Focused.ordinal()] = i;
            iArr2[InputPhase.UnfocusedEmpty.ordinal()] = i2;
            try {
                iArr2[InputPhase.UnfocusedNotEmpty.ordinal()] = 3;
                TextFieldImplKt.WhenMappings.$EnumSwitchMapping$1 = iArr2;
            } catch (java.lang.NoSuchFieldError e) {
            }
        }
    }
    static {
        int i = 0;
        TextFieldImplKt.ZeroConstraints = ConstraintsKt.Constraints(i, i, i, i);
        int i9 = 0;
        TextFieldImplKt.TextFieldPadding = Dp.constructor-impl((float)i2);
        int i10 = 0;
        TextFieldImplKt.HorizontalIconPadding = Dp.constructor-impl((float)i3);
        int i11 = 0;
        TextFieldImplKt.SupportingTopPadding = Dp.constructor-impl((float)i4);
        int i12 = 0;
        TextFieldImplKt.PrefixSuffixTextPadding = Dp.constructor-impl((float)i5);
        int i13 = 0;
        TextFieldImplKt.MinTextLineHeight = Dp.constructor-impl((float)i6);
        int i14 = 0;
        TextFieldImplKt.MinFocusedLabelLineHeight = Dp.constructor-impl((float)i7);
        int i15 = 0;
        TextFieldImplKt.MinSupportingTextLineHeight = Dp.constructor-impl((float)i8);
        int i17 = 0;
        int i18 = 0;
        TextFieldImplKt.IconDefaultSizeModifier = SizeKt.defaultMinSize-VpY3zN4((Modifier)Modifier.Companion, Dp.constructor-impl((float)i16), Dp.constructor-impl((float)$i$f$getDp));
    }

    public static final void CommonDecorationBox(androidx.compose.material3.internal.TextFieldType type, String value, Function2<? super Composer, ? super Integer, Unit> innerTextField, VisualTransformation visualTransformation, Function2<? super Composer, ? super Integer, Unit> label, Function2<? super Composer, ? super Integer, Unit> placeholder, Function2<? super Composer, ? super Integer, Unit> leadingIcon, Function2<? super Composer, ? super Integer, Unit> trailingIcon, Function2<? super Composer, ? super Integer, Unit> prefix, Function2<? super Composer, ? super Integer, Unit> suffix, Function2<? super Composer, ? super Integer, Unit> supportingText, boolean singleLine, boolean enabled, boolean isError, InteractionSource interactionSource, PaddingValues contentPadding, TextFieldColors colors, Function2<? super Composer, ? super Integer, Unit> container, Composer $composer, int $changed, int $changed1, int i22) {
        Object anon;
        Object traceInProgress2;
        Composer composer2;
        Object endRestartGroup;
        Object labelSize;
        Object invalid$iv;
        Object obj7;
        Object obj2;
        Object obj4;
        Object obj6;
        Object obj8;
        Object obj10;
        Object obj5;
        boolean z3;
        boolean z2;
        boolean z;
        int i;
        int i5;
        int i7;
        int i49;
        int i13;
        boolean traceInProgress7;
        Object rememberComposableLambda2;
        int enabled2;
        Object iNSTANCE;
        int i43;
        Object rememberedValue3;
        int showPlaceholder$delegate;
        Object rememberedValue2;
        int decoratedPrefix;
        androidx.compose.runtime.internal.ComposableLambda leadingIconColor;
        androidx.compose.runtime.internal.ComposableLambda trailingIconColor;
        int decoratedPrefix2;
        int $i$f$cache;
        boolean equals-impl0;
        int rememberComposableLambda;
        int placeholder2;
        int placeholder3;
        int i36;
        Object initialValue$iv$iv$iv;
        int i54;
        boolean traceInProgress3;
        int i35;
        boolean traceInProgress5;
        int i26;
        boolean traceInProgress4;
        int i32;
        boolean traceInProgress;
        Object rememberedValue;
        Object it$iv5;
        Object rememberedValue4;
        Object it$iv2;
        int labelProgress;
        Object empty;
        String placeholderAlpha;
        Object empty2;
        Object anon2;
        Object it$iv6;
        int i9;
        int isError2;
        int i11;
        int i2;
        int i53;
        Object it$iv7;
        Object it$iv;
        Object it$iv8;
        Object it$iv3;
        int bodyLarge;
        Composer bodyLarge3;
        Composer bodyLarge2;
        int it2;
        int it;
        int str3;
        int $composer2;
        int $dirty3;
        Object filter;
        androidx.compose.material3.internal.InputPhase unfocusedNotEmpty;
        boolean traceInProgress9;
        TextStyle labelTextStyleColor;
        int i20;
        int $dirty2;
        int $dirty1;
        int i37;
        int leadingIcon2;
        int str2;
        int i46;
        Object obj3;
        long unspecified-0d7_KjU;
        long $this$CommonDecorationBox_u24lambda_u242;
        int i44;
        Object it$iv4;
        Object label$iv$iv;
        Object $changed$iv$iv;
        Object label$iv$iv2;
        long l5;
        int invalid$iv$iv$iv;
        long l10;
        Object $this$animateColor$iv$iv;
        int invalid$iv$iv$iv2;
        int i17;
        int i21;
        Object str4;
        Transition $this$animateFloat$iv$iv2;
        Composer $composer$iv9;
        Transition $this$animateFloat$iv$iv;
        Composer $composer$iv4;
        int i56;
        Transition $this$animateColor$iv$iv2;
        Transition $this$animateValue$iv$iv$iv2;
        Composer $composer$iv2;
        int $i$f$animateColor;
        Transition $this$animateValue$iv$iv$iv;
        Object state3;
        State prefixSuffixAlpha;
        Object empty3;
        int i45;
        int i47;
        Object obj9;
        int i38;
        int i52;
        int i12;
        int i48;
        int trailingIcon2;
        int trailingIcon3;
        int i3;
        int prefix2;
        int i34;
        int i29;
        int suffix2;
        Object obj;
        int i8;
        int traceInProgress6;
        int i14;
        int decoratedPlaceholder;
        int i25;
        int decoratedLeading;
        int i6;
        int i28;
        int i23;
        int i40;
        Color.Companion companion2;
        long $this$CommonDecorationBox_u24lambda_u244;
        int i4;
        int i41;
        int i50;
        int i33;
        int invalid$iv2;
        int $this$isSpecified$iv$iv2;
        int borderContainerWithId;
        Composer $composer$iv5;
        int colorSpace;
        int $this$isSpecified$iv$iv;
        Composer $composer$iv7;
        int anon3;
        int cmp;
        int i39;
        Transition companion;
        int cmp2;
        Composer $composer$iv;
        Composer $composer$iv8;
        Object traceInProgress8;
        int i10;
        int i27;
        int leadingIcon3;
        int i30;
        int $dirty;
        String str;
        int placeholder4;
        long l9;
        long l7;
        int i19;
        int i15;
        Typography typography;
        int i42;
        Transition transition;
        androidx.compose.material3.internal.InputPhase inputPhase;
        long focusedLabelTextStyleColor$iv;
        State state;
        State state5;
        Composer composer;
        State state4;
        Transition transition2;
        State state7;
        Transition transition3;
        Composer $composer$iv6;
        long l6;
        Composer $composer$iv3;
        int i24;
        State state8;
        int i16;
        int i55;
        State state6;
        State state2;
        float f;
        long l;
        int i18;
        long l4;
        Object showPrefixSuffix$delegate;
        TextStyle bodyLarge4;
        int i31;
        long l3;
        long l8;
        int i51;
        long l2;
        ScopeUpdateScope scopeUpdateScope;
        AnnotatedString obj84;
        Object obj85;
        int obj86;
        int obj87;
        int obj88;
        int obj89;
        int obj90;
        State obj91;
        Object obj92;
        int obj97;
        decoratedPrefix2 = visualTransformation;
        final Object obj14 = interactionSource;
        traceInProgress2 = contentPadding;
        labelSize = colors;
        obj7 = container;
        int i66 = $changed;
        int i142 = $changed1;
        i11 = i22;
        Composer restartGroup = $composer.startRestartGroup(1514469103);
        ComposerKt.sourceInformation(restartGroup, "C(CommonDecorationBox)P(15,16,4,17,7,9,8,14,10,12,13,11,3,6,5,2)98@4054L121,104@4251L25,114@4594L10,121@4911L7503:TextFieldImpl.kt#mqatfk");
        $dirty3 = $changed;
        $dirty1 = $changed1;
        if (i11 & 1 != 0) {
            $dirty3 |= 6;
            obj3 = type;
        } else {
            if (i66 & 6 == 0) {
                i21 = restartGroup.changed(type) ? 4 : 2;
                $dirty3 |= i21;
            } else {
                obj3 = type;
            }
        }
        if (i11 & 2 != 0) {
            $dirty3 |= 48;
            str4 = value;
        } else {
            if (i66 & 48 == 0) {
                i47 = restartGroup.changed(value) ? 32 : 16;
                $dirty3 |= i47;
            } else {
                str4 = value;
            }
        }
        if (i11 & 4 != 0) {
            $dirty3 |= 384;
            obj9 = innerTextField;
        } else {
            if (i66 & 384 == 0) {
                i52 = restartGroup.changedInstance(innerTextField) ? 256 : 128;
                $dirty3 |= i52;
            } else {
                obj9 = innerTextField;
            }
        }
        if (i11 & 8 != 0) {
            $dirty3 |= 3072;
        } else {
            if (i66 & 3072 == 0) {
                i12 = restartGroup.changed(decoratedPrefix2) ? 2048 : 1024;
                $dirty3 |= i12;
            }
        }
        if (i11 & 16 != 0) {
            $dirty3 |= 24576;
        } else {
            if (i66 & 24576 == 0) {
                i48 = restartGroup.changedInstance(label) ? 16384 : 8192;
                $dirty3 |= i48;
            }
        }
        int i277 = i11 & 32;
        i3 = 196608;
        if (i277 != 0) {
            $dirty3 |= i3;
            obj2 = placeholder;
        } else {
            if (i66 & i3 == 0) {
                i3 = restartGroup.changedInstance(placeholder) ? 131072 : 65536;
                $dirty3 |= i3;
            } else {
                obj2 = placeholder;
            }
        }
        prefix2 = i11 & 64;
        i29 = 1572864;
        if (prefix2 != 0) {
            $dirty3 |= i29;
            obj4 = leadingIcon;
        } else {
            if ($changed & i29 == 0) {
                i29 = restartGroup.changedInstance(leadingIcon) ? 1048576 : 524288;
                $dirty3 |= i29;
            } else {
                obj4 = leadingIcon;
            }
        }
        int i67 = i11 & 128;
        int i278 = 12582912;
        if (i67 != 0) {
            $dirty3 |= i278;
            suffix2 = i67;
            obj6 = trailingIcon;
        } else {
            if ($changed & i278 == 0) {
                suffix2 = i67;
                i8 = restartGroup.changedInstance(trailingIcon) ? 8388608 : 4194304;
                $dirty3 |= i8;
            } else {
                suffix2 = i67;
                obj6 = trailingIcon;
            }
        }
        int i68 = i11 & 256;
        int i281 = 100663296;
        if (i68 != 0) {
            $dirty3 |= i281;
            traceInProgress6 = i68;
            obj8 = prefix;
        } else {
            if ($changed & i281 == 0) {
                traceInProgress6 = i68;
                i14 = restartGroup.changedInstance(prefix) ? 67108864 : 33554432;
                $dirty3 |= i14;
            } else {
                traceInProgress6 = i68;
                obj8 = prefix;
            }
        }
        int i69 = i11 & 512;
        int i283 = 805306368;
        if (i69 != 0) {
            $dirty3 |= i283;
            decoratedPlaceholder = i69;
            obj10 = suffix;
        } else {
            if ($changed & i283 == 0) {
                decoratedPlaceholder = i69;
                i25 = restartGroup.changedInstance(suffix) ? 536870912 : 268435456;
                $dirty3 |= i25;
            } else {
                decoratedPlaceholder = i69;
                obj10 = suffix;
            }
        }
        int i70 = i11 & 1024;
        if (i70 != 0) {
            $dirty1 |= 6;
            decoratedLeading = i70;
            obj5 = supportingText;
        } else {
            if (i142 & 6 == 0) {
                decoratedLeading = i70;
                i6 = restartGroup.changedInstance(supportingText) ? 4 : 2;
                $dirty1 |= i6;
            } else {
                decoratedLeading = i70;
                obj5 = supportingText;
            }
        }
        int i71 = i11 & 2048;
        if (i71 != 0) {
            $dirty1 |= 48;
            i28 = i71;
            z3 = singleLine;
        } else {
            if (i142 & 48 == 0) {
                i28 = i71;
                i23 = restartGroup.changed(singleLine) ? 32 : 16;
                $dirty1 |= i23;
            } else {
                i28 = i71;
                z3 = singleLine;
            }
        }
        int i72 = i11 & 4096;
        if (i72 != 0) {
            $dirty1 |= 384;
            i40 = i72;
            z2 = enabled;
        } else {
            i40 = i72;
            if (i142 & 384 == 0) {
                i4 = restartGroup.changed(enabled) ? 256 : 128;
                $dirty1 |= i4;
            } else {
                z2 = enabled;
            }
        }
        int i74 = i11 & 8192;
        if (i74 != 0) {
            $dirty1 |= 3072;
            i41 = i74;
            z = isError;
        } else {
            i41 = i74;
            if (i142 & 3072 == 0) {
                i50 = restartGroup.changed(isError) ? 2048 : 1024;
                $dirty1 |= i50;
            } else {
                z = isError;
            }
        }
        if (i11 & 16384 != 0) {
            $dirty1 |= 24576;
        } else {
            if (i142 & 24576 == 0) {
                i = restartGroup.changed(obj14) ? 16384 : 8192;
                $dirty1 |= i;
            }
        }
        if (i75 &= i11 != 0) {
            i5 = 196608;
            $dirty1 |= i5;
        } else {
        }
        if (i77 &= i11 != 0) {
            i7 = 1572864;
            $dirty1 |= i7;
        } else {
        }
        if (i79 &= i11 != 0) {
            i49 = 12582912;
            $dirty1 |= i49;
        } else {
        }
        iNSTANCE = $dirty1;
        if ($dirty13 &= $dirty3 == 306783378 && i141 &= iNSTANCE == 4793490) {
            if (i141 &= iNSTANCE == 4793490) {
                if (!restartGroup.getSkipping()) {
                    placeholder2 = i277 != 0 ? 0 : placeholder;
                    leadingIcon2 = prefix2 != 0 ? 0 : leadingIcon;
                    trailingIcon2 = suffix2 != 0 ? 0 : trailingIcon;
                    prefix2 = traceInProgress6 != 0 ? 0 : prefix;
                    suffix2 = decoratedPlaceholder != 0 ? 0 : suffix;
                    i27 = decoratedLeading != 0 ? traceInProgress6 : supportingText;
                    i50 = i28 != 0 ? traceInProgress6 : singleLine;
                    if (i40 != 0) {
                        obj97 = placeholder2;
                        placeholder3 = traceInProgress6;
                    } else {
                        obj97 = placeholder2;
                        placeholder3 = enabled;
                    }
                    i9 = i41 != 0 ? traceInProgress6 : isError;
                    if (ComposerKt.isTraceInProgress()) {
                        leadingIcon3 = leadingIcon2;
                        ComposerKt.traceEventStart(1514469103, $dirty3, iNSTANCE, "androidx.compose.material3.internal.CommonDecorationBox (TextFieldImpl.kt:96)");
                    } else {
                        leadingIcon3 = leadingIcon2;
                    }
                    str2 = "CC(remember):TextFieldImpl.kt#9igjgp";
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 318599163, str2);
                    i30 = iNSTANCE;
                    obj92 = 0;
                    i13 = $dirty3 & 112 == 32 ? 1 : obj92;
                    i2 = $dirty3 & 7168 == 2048 ? 1 : obj92;
                    Composer composer4 = restartGroup;
                    int i190 = 0;
                    Object rememberedValue5 = composer4.rememberedValue();
                    int i285 = 0;
                    if (i13 |= i2 == 0) {
                        $dirty = $dirty3;
                        if (rememberedValue5 == Composer.Companion.getEmpty()) {
                            int $dirty4 = 0;
                            obj84 = decoratedLeading;
                            super(str4, 0, 0, 6, 0);
                            composer4.updateRememberedValue(decoratedPrefix2.filter(obj84));
                        } else {
                            filter = rememberedValue5;
                        }
                    } else {
                        $dirty = $dirty3;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    String text2 = (TransformedText)filter.getText().getText();
                    boolean booleanValue = (Boolean)FocusInteractionKt.collectIsFocusedAsState(obj14, restartGroup, i146 &= 14).getValue().booleanValue();
                    if (booleanValue) {
                        unfocusedNotEmpty = InputPhase.Focused;
                    } else {
                        i20 = (CharSequence)text2.length() == 0 ? 1 : obj92;
                        unfocusedNotEmpty = i20 != 0 ? InputPhase.UnfocusedEmpty : InputPhase.UnfocusedNotEmpty;
                    }
                    int i94 = 6;
                    Typography typography2 = MaterialTheme.INSTANCE.getTypography(restartGroup, i94);
                    TextStyle bodyLarge5 = typography2.getBodyLarge();
                    TextStyle bodySmall = typography2.getBodySmall();
                    int i288 = i94;
                    l9 = labelColor-XeAY9LY$material3_release;
                    if (Color.equals-impl0(bodyLarge5.getColor-0d7_KjU(), placeholder3)) {
                        if (Color.equals-impl0(bodySmall.getColor-0d7_KjU(), placeholder3)) {
                            if (!Color.equals-impl0(bodyLarge5.getColor-0d7_KjU(), placeholder3) && Color.equals-impl0(bodySmall.getColor-0d7_KjU(), placeholder3)) {
                                i43 = Color.equals-impl0(bodySmall.getColor-0d7_KjU(), placeholder3) ? 1 : obj92;
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                    int i99 = 0;
                    if (i43 != 0) {
                        companion2 = $this$CommonDecorationBox_u24lambda_u242;
                        i33 = 0;
                        $this$isSpecified$iv$iv = 0;
                        $this$isSpecified$iv$iv2 = Long.compare(l11, i315) != 0 ? 1 : obj92;
                        if ($this$isSpecified$iv$iv2 != 0) {
                            $this$CommonDecorationBox_u24lambda_u242 = companion2;
                        } else {
                            $this$isSpecified$iv$iv2 = 0;
                            $this$CommonDecorationBox_u24lambda_u242 = l9;
                        }
                    }
                    int i100 = 0;
                    if (i43 != 0) {
                        i33 = $this$CommonDecorationBox_u24lambda_u244;
                        borderContainerWithId = 0;
                        i39 = 0;
                        $this$isSpecified$iv$iv = Long.compare(l12, i325) != 0 ? 1 : obj92;
                        if ($this$isSpecified$iv$iv != 0) {
                            $this$CommonDecorationBox_u24lambda_u244 = i33;
                        } else {
                            $this$isSpecified$iv$iv = 0;
                            $this$CommonDecorationBox_u24lambda_u244 = l9;
                        }
                    }
                    i36 = label != null ? 1 : obj92;
                    l7 = $this$CommonDecorationBox_u24lambda_u244;
                    i19 = obj92;
                    i15 = 0;
                    typography = typography2;
                    int i290 = i43;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1087703202, "CC(TextFieldTransitionScope)P(2,1:c#ui.graphics.Color,5:c#ui.graphics.Color,3:c#ui.graphics.Color,4)349@14528L59,352@14632L334,364@15016L1126,394@16193L363,406@16607L318,418@17028L197,424@17231L150:TextFieldImpl.kt#mqatfk");
                    i42 = i36;
                    Transition transition4 = TransitionKt.updateTransition(unfocusedNotEmpty, "TextFieldInputState", restartGroup, i82 |= 48, obj92);
                    int i291 = 384;
                    int i292 = i291;
                    int i310 = 0;
                    transition = transition4;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1338768149, "CC(animateFloat)P(2)1966@80444L78:Transition.kt#pdpnli");
                    obj88 = vectorConverter;
                    int i316 = 57344;
                    int i317 = 0;
                    int i322 = i87;
                    obj84 = transition5;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -142660079, "CC(animateValue)P(3,2)1883@77007L32,1884@77062L31,1885@77118L23,1887@77154L89:Transition.kt#pdpnli");
                    obj85 = restartGroup;
                    int i326 = 0;
                    inputPhase = unfocusedNotEmpty;
                    Composer inputState = obj85;
                    inputState.startReplaceGroup(-2036730335);
                    String str6 = "C:TextFieldImpl.kt#mqatfk";
                    ComposerKt.sourceInformation(inputState, str6);
                    if (ComposerKt.isTraceInProgress()) {
                        focusedLabelTextStyleColor$iv = $this$CommonDecorationBox_u24lambda_u242;
                        ComposerKt.traceEventStart(-2036730335, i107 &= 112, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:356)");
                    } else {
                        focusedLabelTextStyleColor$iv = $this$CommonDecorationBox_u24lambda_u242;
                    }
                    int i330 = 1065353216;
                    switch (i191) {
                        case 1:
                            i44 = i330;
                            break;
                        case 2:
                            i44 = 0;
                            break;
                        case 3:
                            i44 = i330;
                            break;
                        default:
                            NoWhenBranchMatchedException noWhenBranchMatchedException6 = new NoWhenBranchMatchedException();
                            throw noWhenBranchMatchedException6;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj85.endReplaceGroup();
                    it$iv4 = obj84.getTargetState();
                    int i328 = 0;
                    initialValue$iv$iv$iv = obj85;
                    initialValue$iv$iv$iv.startReplaceGroup(-2036730335);
                    ComposerKt.sourceInformation(initialValue$iv$iv$iv, str6);
                    if (ComposerKt.isTraceInProgress()) {
                        obj85 = initialValue$iv$iv$iv;
                        obj87 = it$iv4;
                        ComposerKt.traceEventStart(-2036730335, i327 & 112, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:356)");
                    } else {
                        obj85 = initialValue$iv$iv$iv;
                        obj87 = it$iv4;
                    }
                    switch (i109) {
                        case 1:
                            i54 = i330;
                            break;
                        case 2:
                            i54 = 0;
                            break;
                        case 3:
                            i54 = i330;
                            break;
                        default:
                            NoWhenBranchMatchedException noWhenBranchMatchedException5 = new NoWhenBranchMatchedException();
                            throw noWhenBranchMatchedException5;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj85.endReplaceGroup();
                    i10 = 458752;
                    obj85 = obj86;
                    obj86 = valueOf2;
                    obj90 = restartGroup;
                    obj87 = invoke5;
                    Transition transition9 = obj84;
                    Float num6 = obj85;
                    Float num5 = obj86;
                    Object obj17 = obj87;
                    androidx.compose.animation.core.TwoWayConverter twoWayConverter = obj88;
                    Composer composer6 = obj90;
                    ComposerKt.sourceInformationMarkerEnd(composer6);
                    ComposerKt.sourceInformationMarkerEnd(composer6);
                    $this$animateFloat$iv$iv2 = transition;
                    int i293 = 0;
                    int i299 = i149;
                    ComposerKt.sourceInformationMarkerStart(composer6, -1338768149, "CC(animateFloat)P(2)1966@80444L78:Transition.kt#pdpnli");
                    obj88 = vectorConverter2;
                    int i302 = 0;
                    int i311 = i113;
                    obj84 = transition6;
                    ComposerKt.sourceInformationMarkerStart(composer6, -142660079, "CC(animateValue)P(3,2)1883@77007L32,1884@77062L31,1885@77118L23,1887@77154L89:Transition.kt#pdpnli");
                    int i318 = 0;
                    obj89 = str15;
                    label$iv$iv = obj85;
                    label$iv$iv.startReplaceGroup(1435837472);
                    ComposerKt.sourceInformation(label$iv$iv, str6);
                    if (ComposerKt.isTraceInProgress()) {
                        $composer$iv = label$iv$iv;
                        transition2 = $this$animateFloat$iv$iv2;
                        ComposerKt.traceEventStart(1435837472, i155 &= 112, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:386)");
                    } else {
                        $composer$iv = label$iv$iv;
                        transition2 = $this$animateFloat$iv$iv2;
                    }
                    switch (i114) {
                        case 1:
                            i35 = i330;
                            break;
                        case 2:
                            i35 = 0;
                            i35 = i330;
                            break;
                        case 3:
                            i35 = 0;
                            break;
                        default:
                            NoWhenBranchMatchedException noWhenBranchMatchedException4 = new NoWhenBranchMatchedException();
                            throw noWhenBranchMatchedException4;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $composer$iv.endReplaceGroup();
                    it$iv7 = obj84.getTargetState();
                    $composer$iv9 = composer6;
                    int i319 = 0;
                    obj85 = valueOf3;
                    $composer$iv9.startReplaceGroup(1435837472);
                    ComposerKt.sourceInformation($composer$iv9, str6);
                    if (ComposerKt.isTraceInProgress()) {
                        obj86 = it$iv7;
                        obj87 = $composer$iv9;
                        ComposerKt.traceEventStart(1435837472, i197 &= 112, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:386)");
                    } else {
                        obj86 = it$iv7;
                        obj87 = $composer$iv9;
                    }
                    switch (i115) {
                        case 1:
                            i26 = i330;
                            break;
                        case 2:
                            i26 = 0;
                            i26 = i330;
                            break;
                        case 3:
                            i26 = 0;
                            break;
                        default:
                            NoWhenBranchMatchedException noWhenBranchMatchedException3 = new NoWhenBranchMatchedException();
                            throw noWhenBranchMatchedException3;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj87.endReplaceGroup();
                    obj86 = valueOf4;
                    obj87 = invoke2;
                    Float num = obj85;
                    Float num3 = obj86;
                    Object obj16 = obj87;
                    androidx.compose.animation.core.TwoWayConverter twoWayConverter3 = obj88;
                    String str18 = obj89;
                    ComposerKt.sourceInformationMarkerEnd(composer6);
                    ComposerKt.sourceInformationMarkerEnd(composer6);
                    int i204 = i291;
                    $this$animateFloat$iv$iv = transition;
                    int i294 = 0;
                    obj89 = str10;
                    ComposerKt.sourceInformationMarkerStart(composer6, -1338768149, "CC(animateFloat)P(2)1966@80444L78:Transition.kt#pdpnli");
                    obj88 = vectorConverter3;
                    int i300 = 0;
                    int i303 = i119;
                    obj84 = transition7;
                    ComposerKt.sourceInformationMarkerStart(composer6, -142660079, "CC(animateValue)P(3,2)1883@77007L32,1884@77062L31,1885@77118L23,1887@77154L89:Transition.kt#pdpnli");
                    int i312 = 0;
                    int i320 = i204;
                    $changed$iv$iv = obj85;
                    $changed$iv$iv.startReplaceGroup(1128033978);
                    ComposerKt.sourceInformation($changed$iv$iv, str6);
                    if (ComposerKt.isTraceInProgress()) {
                        $composer$iv8 = $changed$iv$iv;
                        transition3 = $this$animateFloat$iv$iv;
                        ComposerKt.traceEventStart(1128033978, i162 &= 112, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:398)");
                    } else {
                        $composer$iv8 = $changed$iv$iv;
                        transition3 = $this$animateFloat$iv$iv;
                    }
                    switch (i120) {
                        case 1:
                            i32 = i330;
                            break;
                        case 2:
                            i32 = 0;
                            i32 = i330;
                            break;
                        case 3:
                            i32 = i330;
                            break;
                        default:
                            NoWhenBranchMatchedException noWhenBranchMatchedException2 = new NoWhenBranchMatchedException();
                            throw noWhenBranchMatchedException2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $composer$iv8.endReplaceGroup();
                    it$iv = obj84.getTargetState();
                    $composer$iv4 = composer6;
                    int i313 = 0;
                    obj85 = valueOf5;
                    $composer$iv4.startReplaceGroup(1128033978);
                    ComposerKt.sourceInformation($composer$iv4, str6);
                    if (ComposerKt.isTraceInProgress()) {
                        obj86 = it$iv;
                        obj87 = $composer$iv4;
                        ComposerKt.traceEventStart(1128033978, i205 &= 112, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:398)");
                    } else {
                        obj86 = it$iv;
                        obj87 = $composer$iv4;
                    }
                    switch (i121) {
                        case 1:
                            i56 = i330;
                            break;
                        case 2:
                            i56 = 0;
                            i56 = i330;
                            break;
                        case 3:
                            i56 = i330;
                            break;
                        default:
                            NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                            throw noWhenBranchMatchedException;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj87.endReplaceGroup();
                    obj86 = valueOf6;
                    obj87 = invoke3;
                    Transition transition13 = obj84;
                    Float num2 = obj85;
                    Float num4 = obj86;
                    Object obj15 = obj87;
                    androidx.compose.animation.core.TwoWayConverter twoWayConverter2 = obj88;
                    String str19 = obj89;
                    ComposerKt.sourceInformationMarkerEnd(composer6);
                    ComposerKt.sourceInformationMarkerEnd(composer6);
                    $this$animateColor$iv$iv2 = transition;
                    int i295 = 0;
                    int i301 = i164;
                    ComposerKt.sourceInformationMarkerStart(composer6, -1939694975, "CC(animateColor)P(2)68@3220L31,69@3287L70,73@3370L70:Transition.kt#xbi5r1");
                    int i304 = 0;
                    int it$iv12 = -107432127;
                    obj89 = str16;
                    label$iv$iv2 = obj84;
                    label$iv$iv2.startReplaceGroup(it$iv12);
                    ComposerKt.sourceInformation(label$iv$iv2, str6);
                    if (ComposerKt.isTraceInProgress()) {
                        $composer$iv7 = label$iv$iv2;
                        companion = $this$animateColor$iv$iv2;
                        ComposerKt.traceEventStart(it$iv12, i165 &= 112, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:410)");
                    } else {
                        $composer$iv7 = label$iv$iv2;
                        companion = $this$animateColor$iv$iv2;
                    }
                    int i251 = 1;
                    l5 = TextFieldImplKt.WhenMappings.$EnumSwitchMapping$1[(InputPhase)$this$animateColor$iv$iv2.getTargetState().ordinal()] == i251 ? focusedLabelTextStyleColor$iv : l7;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $composer$iv7.endReplaceGroup();
                    androidx.compose.ui.graphics.colorspace.ColorSpace colorSpace-impl = Color.getColorSpace-impl(l5);
                    ComposerKt.sourceInformationMarkerStart(composer6, 1918408083, "CC(remember):Transition.kt#9igjgp");
                    invalid$iv$iv$iv = composer6.changed(colorSpace-impl);
                    Composer composer8 = composer6;
                    int i305 = 0;
                    rememberedValue = composer8.rememberedValue();
                    int i314 = 0;
                    if (!invalid$iv$iv$iv) {
                        obj85 = invalid$iv$iv$iv;
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            invalid$iv$iv$iv = 0;
                            obj86 = rememberedValue;
                            composer8.updateRememberedValue((TwoWayConverter)ColorVectorConverterKt.getVectorConverter(Color.Companion).invoke(colorSpace-impl));
                        } else {
                            obj86 = rememberedValue;
                        }
                    } else {
                        obj85 = invalid$iv$iv$iv;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer6);
                    i216 |= i257;
                    $this$animateValue$iv$iv$iv2 = companion;
                    int i306 = 0;
                    obj88 = rememberedValue;
                    androidx.compose.ui.graphics.colorspace.ColorSpace colorSpace2 = colorSpace-impl;
                    ComposerKt.sourceInformationMarkerStart(composer6, -142660079, "CC(animateValue)P(3,2)1883@77007L32,1884@77062L31,1885@77118L23,1887@77154L89:Transition.kt#pdpnli");
                    int i323 = 0;
                    int i331 = i217;
                    int $changed$iv$iv$iv4 = -107432127;
                    it$iv5 = obj85;
                    it$iv5.startReplaceGroup($changed$iv$iv$iv4);
                    ComposerKt.sourceInformation(it$iv5, str6);
                    if (ComposerKt.isTraceInProgress()) {
                        $composer$iv6 = it$iv5;
                        obj85 = $this$animateValue$iv$iv$iv2;
                        ComposerKt.traceEventStart($changed$iv$iv$iv4, i167 &= 112, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:410)");
                    } else {
                        $composer$iv6 = it$iv5;
                        obj85 = $this$animateValue$iv$iv$iv2;
                    }
                    int i258 = 1;
                    l10 = TextFieldImplKt.WhenMappings.$EnumSwitchMapping$1[(InputPhase)$this$animateValue$iv$iv$iv2.getCurrentState().ordinal()] == i258 ? focusedLabelTextStyleColor$iv : l7;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $composer$iv6.endReplaceGroup();
                    it$iv8 = obj85.getTargetState();
                    $composer$iv2 = composer6;
                    int i324 = 0;
                    int initialValue$iv$iv$iv4 = -107432127;
                    $composer$iv2.startReplaceGroup(initialValue$iv$iv$iv4);
                    ComposerKt.sourceInformation($composer$iv2, str6);
                    if (ComposerKt.isTraceInProgress()) {
                        obj84 = it$iv8;
                        obj87 = $composer$iv2;
                        ComposerKt.traceEventStart(initialValue$iv$iv$iv4, i218 &= 112, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:410)");
                    } else {
                        obj84 = it$iv8;
                        obj87 = $composer$iv2;
                    }
                    l6 = TextFieldImplKt.WhenMappings.$EnumSwitchMapping$1[obj84.ordinal()] == 1 ? focusedLabelTextStyleColor$iv : l7;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj87.endReplaceGroup();
                    obj84 = obj85;
                    obj85 = obj86;
                    obj86 = box-impl4;
                    obj87 = invoke4;
                    Transition transition11 = obj84;
                    Color color3 = obj85;
                    Color color4 = obj86;
                    Object obj18 = obj87;
                    Object obj13 = obj88;
                    String str17 = obj89;
                    ComposerKt.sourceInformationMarkerEnd(composer6);
                    ComposerKt.sourceInformationMarkerEnd(composer6);
                    Transition transition10 = transition;
                    $i$f$animateColor = 0;
                    obj89 = str11;
                    ComposerKt.sourceInformationMarkerStart(composer6, -1939694975, "CC(animateColor)P(2)68@3220L31,69@3287L70,73@3370L70:Transition.kt#xbi5r1");
                    int i296 = 0;
                    obj85 = targetState2;
                    int it$iv13 = 1023351670;
                    $this$animateColor$iv$iv = obj84;
                    $this$animateColor$iv$iv.startReplaceGroup(it$iv13);
                    ComposerKt.sourceInformation($this$animateColor$iv$iv, str6);
                    if (ComposerKt.isTraceInProgress()) {
                        $composer$iv5 = $this$animateColor$iv$iv;
                        anon3 = $i$f$animateColor;
                        ComposerKt.traceEventStart(it$iv13, i169 &= 112, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:421)");
                    } else {
                        $composer$iv5 = $this$animateColor$iv$iv;
                        anon3 = $i$f$animateColor;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $composer$iv5.endReplaceGroup();
                    androidx.compose.ui.graphics.colorspace.ColorSpace colorSpace-impl2 = Color.getColorSpace-impl(l9);
                    ComposerKt.sourceInformationMarkerStart(composer6, 1918408083, "CC(remember):Transition.kt#9igjgp");
                    invalid$iv$iv$iv2 = composer6.changed(colorSpace-impl2);
                    Composer composer9 = composer6;
                    int i297 = 0;
                    rememberedValue4 = composer9.rememberedValue();
                    int i307 = 0;
                    if (!invalid$iv$iv$iv2) {
                        obj85 = invalid$iv$iv$iv2;
                        if (rememberedValue4 == Composer.Companion.getEmpty()) {
                            invalid$iv$iv$iv2 = 0;
                            obj86 = rememberedValue4;
                            composer9.updateRememberedValue((TwoWayConverter)ColorVectorConverterKt.getVectorConverter(Color.Companion).invoke(colorSpace-impl2));
                        } else {
                            obj86 = rememberedValue4;
                        }
                    } else {
                        obj85 = invalid$iv$iv$iv2;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer6);
                    i228 |= i269;
                    $this$animateValue$iv$iv$iv = $this$isSpecified$iv$iv2;
                    int i298 = 0;
                    obj88 = rememberedValue4;
                    colorSpace = colorSpace-impl2;
                    ComposerKt.sourceInformationMarkerStart(composer6, -142660079, "CC(animateValue)P(3,2)1883@77007L32,1884@77062L31,1885@77118L23,1887@77154L89:Transition.kt#pdpnli");
                    int i321 = 0;
                    obj86 = currentState5;
                    cmp2 = i229;
                    int $changed$iv$iv$iv5 = 1023351670;
                    it$iv2 = obj85;
                    it$iv2.startReplaceGroup($changed$iv$iv$iv5);
                    ComposerKt.sourceInformation(it$iv2, str6);
                    if (ComposerKt.isTraceInProgress()) {
                        $composer$iv3 = it$iv2;
                        obj85 = $this$animateValue$iv$iv$iv;
                        ComposerKt.traceEventStart($changed$iv$iv$iv5, i171 &= 112, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:421)");
                    } else {
                        $composer$iv3 = it$iv2;
                        obj85 = $this$animateValue$iv$iv$iv;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $composer$iv3.endReplaceGroup();
                    it$iv3 = obj85.getTargetState();
                    Composer composer10 = composer6;
                    i39 = 0;
                    int initialValue$iv$iv$iv5 = 1023351670;
                    composer10.startReplaceGroup(initialValue$iv$iv$iv5);
                    ComposerKt.sourceInformation(composer10, str6);
                    if (ComposerKt.isTraceInProgress()) {
                        obj84 = it$iv3;
                        ComposerKt.traceEventStart(initialValue$iv$iv$iv5, i230 &= 112, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:421)");
                    } else {
                        obj84 = it$iv3;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer10.endReplaceGroup();
                    obj84 = obj85;
                    obj85 = obj86;
                    obj86 = box-impl2;
                    obj87 = invoke;
                    obj90 = composer6;
                    State transitionAnimation = TransitionKt.createTransitionAnimation(obj84, obj85, obj86, obj87, obj88, obj89, obj90, i176 |= i235);
                    Transition transition8 = obj84;
                    Color color = obj85;
                    Color color2 = obj86;
                    cmp = obj87;
                    Object obj12 = obj88;
                    String str12 = obj89;
                    composer = obj90;
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    labelProgress = state4;
                    bodyLarge = transitionAnimation;
                    State state11 = state5;
                    Composer composer7 = composer;
                    state3 = state7;
                    State state13 = state;
                    i24 = 0;
                    state8 = transitionAnimation;
                    i16 = i95;
                    ComposerKt.sourceInformationMarkerStart(composer7, -571896332, "CP(1,2)155@6472L107,172@7259L108:TextFieldImpl.kt#mqatfk");
                    float floatValue = (Number)labelProgress.getValue().floatValue();
                    composer7.startReplaceGroup(-156998101);
                    ComposerKt.sourceInformation(composer7, "*138@5668L506");
                    if (label == null) {
                        obj91 = labelProgress;
                        state6 = bodyLarge;
                        state2 = state11;
                        obj85 = bodyLarge5;
                        labelTextStyleColor = bodySmall;
                        i55 = i290;
                        f = floatValue;
                        decoratedPlaceholder = 0;
                    } else {
                        colorSpace = 0;
                        obj88 = bodyLarge;
                        obj91 = state11;
                        obj85 = bodyLarge5;
                        obj86 = bodySmall;
                        obj90 = i290;
                        obj87 = floatValue;
                        obj89 = $this$isSpecified$iv$iv2;
                        obj84 = anon3;
                        super(obj85, obj86, obj87, obj88, obj89, obj90, obj91);
                        TextStyle textStyle3 = obj85;
                        labelTextStyleColor = obj86;
                        f = obj87;
                        state6 = obj88;
                        Function2 function2 = obj89;
                        i55 = obj90;
                        state2 = obj91;
                        obj91 = labelProgress;
                        decoratedPlaceholder = rememberComposableLambda2;
                    }
                    composer7.endReplaceGroup();
                    enabled2 = i329;
                    long placeholderColor-XeAY9LY$material3_release = labelSize.placeholderColor-XeAY9LY$material3_release(enabled2, i9, booleanValue);
                    ComposerKt.sourceInformationMarkerStart(composer7, -156971732, str2);
                    bodyLarge3 = composer7;
                    int i286 = 0;
                    rememberedValue3 = bodyLarge3.rememberedValue();
                    int i308 = 0;
                    obj84 = i125;
                    if (rememberedValue3 == Composer.Companion.getEmpty()) {
                        obj86 = rememberedValue3;
                        obj87 = i140;
                        empty = new TextFieldImplKt.CommonDecorationBox.3.showPlaceholder.2.1(state3);
                        bodyLarge3.updateRememberedValue(SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), (Function0)empty));
                    } else {
                        obj86 = rememberedValue3;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer7);
                    composer7.startReplaceGroup(-156965270);
                    ComposerKt.sourceInformation(composer7, "160@6765L362");
                    if (obj97 != null) {
                        placeholderAlpha = (CharSequence)text2.length() == 0 ? 1 : 0;
                        if (placeholderAlpha != 0 && TextFieldImplKt.CommonDecorationBox$lambda$15$lambda$7((State)rememberedValue3)) {
                            if (TextFieldImplKt.CommonDecorationBox$lambda$15$lambda$7(rememberedValue3)) {
                                obj88 = obj85;
                                obj89 = obj97;
                                obj84 = anon8;
                                obj85 = state3;
                                obj86 = placeholderColor-XeAY9LY$material3_release;
                                super(obj85, obj86, obj87, obj88, obj89);
                                l = obj86;
                                placeholder4 = obj89;
                                obj92 = rememberedValue3;
                                obj97 = state9;
                                obj85 = textStyle2;
                                showPlaceholder$delegate = ComposableLambdaKt.rememberComposableLambda(-660524084, true, obj84, composer7, 54);
                            } else {
                                placeholder4 = obj97;
                                obj92 = rememberedValue3;
                                obj97 = state3;
                                l = placeholderColor-XeAY9LY$material3_release;
                                showPlaceholder$delegate = 0;
                            }
                        } else {
                        }
                    } else {
                    }
                    composer7.endReplaceGroup();
                    long prefixColor-XeAY9LY$material3_release = labelSize.prefixColor-XeAY9LY$material3_release(enabled2, i9, booleanValue);
                    ComposerKt.sourceInformationMarkerStart(composer7, -156946547, str2);
                    bodyLarge2 = composer7;
                    int i270 = 0;
                    decoratedLeading = showPlaceholder$delegate;
                    rememberedValue2 = bodyLarge2.rememberedValue();
                    int i309 = 0;
                    obj84 = i128;
                    if (rememberedValue2 == Composer.Companion.getEmpty()) {
                        obj86 = rememberedValue2;
                        obj87 = i139;
                        obj88 = i270;
                        empty2 = new TextFieldImplKt.CommonDecorationBox.3.showPrefixSuffix.2.1(state13);
                        bodyLarge2.updateRememberedValue(SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), (Function0)empty2));
                    } else {
                        obj86 = rememberedValue2;
                        obj88 = i270;
                        prefixSuffixAlpha = state13;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer7);
                    composer7.startReplaceGroup(-156940524);
                    ComposerKt.sourceInformation(composer7, "177@7507L341");
                    if (prefix2 != 0 && TextFieldImplKt.CommonDecorationBox$lambda$15$lambda$9((State)rememberedValue2)) {
                        if (TextFieldImplKt.CommonDecorationBox$lambda$15$lambda$9(rememberedValue2)) {
                            obj88 = obj85;
                            obj89 = prefix2;
                            obj86 = prefixColor-XeAY9LY$material3_release;
                            super(prefixSuffixAlpha, obj86, obj87, obj88, obj89);
                            l4 = obj86;
                            i18 = obj89;
                            showPrefixSuffix$delegate = rememberedValue2;
                            obj85 = textStyle;
                            obj84 = prefixSuffixAlpha;
                            decoratedPrefix = ComposableLambdaKt.rememberComposableLambda(274398694, true, anon2, composer7, 54);
                        } else {
                            showPrefixSuffix$delegate = rememberedValue2;
                            obj84 = prefixSuffixAlpha;
                            i18 = prefix2;
                            l4 = prefixColor-XeAY9LY$material3_release;
                            decoratedPrefix = 0;
                        }
                    } else {
                    }
                    composer7.endReplaceGroup();
                    long suffixColor-XeAY9LY$material3_release = labelSize.suffixColor-XeAY9LY$material3_release(enabled2, i9, booleanValue);
                    composer7.startReplaceGroup(-156921964);
                    ComposerKt.sourceInformation(composer7, "191@8087L341");
                    if (suffix2 != 0 && TextFieldImplKt.CommonDecorationBox$lambda$15$lambda$9(showPrefixSuffix$delegate)) {
                        if (TextFieldImplKt.CommonDecorationBox$lambda$15$lambda$9(showPrefixSuffix$delegate)) {
                            obj88 = obj85;
                            obj89 = suffix2;
                            obj86 = suffixColor-XeAY9LY$material3_release;
                            obj85 = obj84;
                            super(obj85, obj86, obj87, obj88, obj89);
                            State state12 = obj85;
                            l3 = obj86;
                            bodyLarge4 = obj88;
                            i31 = obj89;
                            obj84 = decoratedPrefix;
                            i41 = rememberComposableLambda;
                        } else {
                            bodyLarge4 = obj85;
                            i31 = suffix2;
                            l3 = suffixColor-XeAY9LY$material3_release;
                            obj85 = obj84;
                            obj84 = decoratedPrefix;
                            i41 = 0;
                        }
                    } else {
                    }
                    composer7.endReplaceGroup();
                    long leadingIconColor-XeAY9LY$material3_release = labelSize.leadingIconColor-XeAY9LY$material3_release(enabled2, i9, booleanValue);
                    composer7.startReplaceGroup(-156902962);
                    ComposerKt.sourceInformation(composer7, "*205@8655L61");
                    if (leadingIcon3 == 0) {
                        obj87 = leadingIconColor-XeAY9LY$material3_release;
                        leadingIconColor = 0;
                    } else {
                        int i185 = leadingIcon3;
                        obj86 = i273;
                        prefixSuffixAlpha = new TextFieldImplKt.CommonDecorationBox.3.decoratedLeading.1.1(leadingIconColor-XeAY9LY$material3_release, rememberComposableLambda, i185);
                        obj87 = leadingIconColor-XeAY9LY$material3_release;
                        obj89 = i185;
                        leadingIconColor = ComposableLambdaKt.rememberComposableLambda(-130107406, true, prefixSuffixAlpha, composer7, 54);
                    }
                    composer7.endReplaceGroup();
                    obj86 = leadingIconColor;
                    long trailingIconColor-XeAY9LY$material3_release = labelSize.trailingIconColor-XeAY9LY$material3_release(enabled2, i9, booleanValue);
                    composer7.startReplaceGroup(-156893937);
                    ComposerKt.sourceInformation(composer7, "*211@8937L62");
                    if (trailingIcon2 == 0) {
                        l8 = trailingIconColor-XeAY9LY$material3_release;
                        trailingIconColor = 0;
                    } else {
                        int i184 = trailingIcon2;
                        obj89 = i272;
                        prefixSuffixAlpha = new TextFieldImplKt.CommonDecorationBox.3.decoratedTrailing.1.1(trailingIconColor-XeAY9LY$material3_release, rememberComposableLambda, i184);
                        l8 = trailingIconColor-XeAY9LY$material3_release;
                        prefix2 = i184;
                        trailingIconColor = ComposableLambdaKt.rememberComposableLambda(2079816678, true, prefixSuffixAlpha, composer7, 54);
                    }
                    composer7.endReplaceGroup();
                    obj89 = trailingIconColor;
                    decoratedPrefix2 = labelSize.supportingTextColor-XeAY9LY$material3_release(enabled2, i9, booleanValue);
                    composer7.startReplaceGroup(-156884470);
                    ComposerKt.sourceInformation(composer7, "*217@9228L217");
                    if (i27 == 0) {
                        i51 = enabled2;
                        l2 = decoratedPrefix2;
                        borderContainerWithId = 0;
                    } else {
                        prefixSuffixAlpha = 0;
                        TextFieldImplKt.CommonDecorationBox.3.decoratedSupporting.1.1 anon4 = new TextFieldImplKt.CommonDecorationBox.3.decoratedSupporting.1.1(decoratedPrefix2, rememberComposableLambda, labelTextStyleColor, i27);
                        i51 = enabled2;
                        l2 = decoratedPrefix2;
                        borderContainerWithId = labelSize;
                    }
                    composer7.endReplaceGroup();
                    switch (i63) {
                        case 1:
                            composer2 = composer7;
                            composer2.startReplaceGroup(-568105095);
                            ComposerKt.sourceInformation(composer2, "228@9583L167,234@9768L769");
                            TextFieldImplKt.CommonDecorationBox.3.containerWithId.1 anon6 = new TextFieldImplKt.CommonDecorationBox.3.containerWithId.1(obj7);
                            traceInProgress6 = decoratedPlaceholder;
                            int decoratedLabel = decoratedLeading;
                            TextFieldKt.TextFieldLayout((Modifier)Modifier.Companion, innerTextField, traceInProgress6, decoratedLabel, obj86, obj89, obj84, i41, i50, f, (Function2)ComposableLambdaKt.rememberComposableLambda(1750327932, true, anon6, composer2, 54), borderContainerWithId, contentPadding, composer2, i137 | str3, rememberComposableLambda | 6);
                            decoratedLeading = decoratedLabel;
                            decoratedPlaceholder = traceInProgress6;
                            composer2.endReplaceGroup();
                            iNSTANCE = Unit.INSTANCE;
                            break;
                        case 2:
                            composer7.startReplaceGroup(-567018607);
                            ComposerKt.sourceInformation(composer7, "253@10659L38,254@10766L314,275@11639L463,264@11098L1286");
                            ComposerKt.sourceInformationMarkerStart(composer7, -156837817, str2);
                            int i65 = 0;
                            Composer composer3 = composer7;
                            $i$f$cache = 0;
                            it$iv6 = composer3.rememberedValue();
                            int i181 = 0;
                            empty3 = 0;
                            invalid$iv2 = i65;
                            i34 = $i$f$cache;
                            obj = it$iv6;
                            it$iv6 = 0;
                            composer3.updateRememberedValue(SnapshotStateKt.mutableStateOf$default(Size.box-impl(Size.Companion.getZero-NH-jbRc()), it$iv6, 2, it$iv6));
                            invalid$iv2 = i65;
                            i34 = $i$f$cache;
                            invalid$iv = obj;
                            ComposerKt.sourceInformationMarkerEnd(composer7);
                            TextFieldImplKt.CommonDecorationBox.3.borderContainerWithId.1 anon5 = new TextFieldImplKt.CommonDecorationBox.3.borderContainerWithId.1((MutableState)invalid$iv, traceInProgress2, obj7);
                            ComposerKt.sourceInformationMarkerStart(composer7, -156806032, str2);
                            float f2 = f;
                            Composer composer5 = composer7;
                            str2 = 0;
                            prefixSuffixAlpha = composer5.rememberedValue();
                            int i279 = 0;
                            anon = prefixSuffixAlpha;
                            obj90 = i62;
                            anon = new TextFieldImplKt.CommonDecorationBox.3.1.1(f2, invalid$iv);
                            composer5.updateRememberedValue((Function1)anon);
                            ComposerKt.sourceInformationMarkerEnd(composer7);
                            i40 = obj84;
                            i28 = obj89;
                            i39 = composer7;
                            traceInProgress6 = decoratedLeading;
                            $this$isSpecified$iv$iv = borderContainerWithId;
                            androidx.compose.runtime.internal.ComposableLambda decoratedPlaceholder2 = obj86;
                            OutlinedTextFieldKt.OutlinedTextFieldLayout((Modifier)Modifier.Companion, obj9, traceInProgress6, decoratedPlaceholder, decoratedPlaceholder2, i28, i40, i41, i50, f2, (Function1)anon, (Function2)ComposableLambdaKt.rememberComposableLambda(157291737, true, anon5, composer7, 54), $this$isSpecified$iv$iv, contentPadding, i39, i59 | i133, i61 | 48);
                            labelSize = decoratedPlaceholder2;
                            iNSTANCE = i28;
                            decoratedPrefix2 = i40;
                            borderContainerWithId = $this$isSpecified$iv$iv;
                            decoratedLeading = traceInProgress6;
                            i39.endReplaceGroup();
                            rememberComposableLambda = Unit.INSTANCE;
                            break;
                        default:
                            i40 = obj84;
                            labelSize = obj86;
                            i28 = obj89;
                            composer2 = composer7;
                            i33 = f;
                            composer2.startReplaceGroup(-565271199);
                            composer2.endReplaceGroup();
                            iNSTANCE = Unit.INSTANCE;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $composer2 = trailingIcon2;
                    i45 = i50;
                    i17 = i27;
                    i53 = leadingIcon3;
                    $dirty2 = i18;
                    i46 = i31;
                    i38 = i51;
                    trailingIcon3 = i9;
                    isError2 = placeholder4;
                    endRestartGroup = composer.endRestartGroup();
                    if (endRestartGroup != null) {
                        endRestartGroup = new TextFieldImplKt.CommonDecorationBox.4(type, value, innerTextField, visualTransformation, label, isError2, i53, $composer2, $dirty2, i46, i17, i45, i38, trailingIcon3, obj14, contentPadding, colors, obj7, $changed, $changed1, i22);
                        endRestartGroup.updateScope((Function2)endRestartGroup);
                    }
                }
                restartGroup.skipToGroupEnd();
                isError2 = placeholder;
                i53 = leadingIcon;
                i46 = suffix;
                i17 = supportingText;
                i45 = singleLine;
                i38 = enabled;
                trailingIcon3 = isError;
                i30 = iNSTANCE;
                composer = restartGroup;
                $dirty = $dirty3;
                $composer2 = trailingIcon;
                $dirty2 = prefix;
            } else {
            }
        } else {
        }
    }

    private static final boolean CommonDecorationBox$lambda$15$lambda$7(State<Boolean> $showPlaceholder$delegate) {
        int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (Boolean)$showPlaceholder$delegate.getValue().booleanValue();
    }

    private static final boolean CommonDecorationBox$lambda$15$lambda$9(State<Boolean> $showPrefixSuffix$delegate) {
        int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (Boolean)$showPrefixSuffix$delegate.getValue().booleanValue();
    }

    private static final void Decoration-3J-VO9M(long contentColor, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        int traceInProgress2;
        int $dirty2;
        int $dirty;
        boolean traceInProgress;
        int i2;
        int i3;
        int i4;
        int str;
        Object obj3;
        Object obj4;
        long l;
        Object obj;
        Object obj2;
        int i;
        final int i8 = obj18;
        traceInProgress2 = 1208685580;
        final Composer restartGroup = $changed.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(Decoration)P(1:c#ui.graphics.Color,2)298@12599L62:TextFieldImpl.kt#mqatfk");
        if (i8 & 6 == 0) {
            i2 = restartGroup.changed(contentColor) ? 4 : 2;
            $dirty2 |= i2;
        }
        if (i8 & 48 == 0) {
            i3 = restartGroup.changed(content) ? 32 : 16;
            $dirty2 |= i3;
        }
        if (i8 & 384 == 0) {
            i4 = restartGroup.changedInstance($composer) ? 256 : 128;
            $dirty2 |= i4;
        } else {
            obj4 = $composer;
        }
        final int i9 = $dirty2;
        if (i9 & 147 == 146) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, i9, -1, "androidx.compose.material3.internal.Decoration (TextFieldImpl.kt:298)");
                }
                ProvideContentColorTextStyleKt.ProvideContentColorTextStyle-3J-VO9M(contentColor, obj7, content, obj4, restartGroup);
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
            traceInProgress2 = new TextFieldImplKt.Decoration.1(contentColor, str, content, $composer, i8);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    private static final void Decoration-Iv8Zu3U(long contentColor, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        int traceInProgress;
        int $dirty;
        int i2;
        int i;
        int skipping;
        boolean traceInProgress2;
        int str;
        traceInProgress = 660142980;
        final Composer obj7 = $changed.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(obj7, "C(Decoration)P(1:c#ui.graphics.Color)303@12806L84:TextFieldImpl.kt#mqatfk");
        if (obj8 & 6 == 0) {
            i2 = obj7.changed(contentColor) ? 4 : 2;
            $dirty |= i2;
        }
        if (obj8 & 48 == 0) {
            i = obj7.changedInstance($composer) ? 32 : 16;
            $dirty |= i;
        }
        if ($dirty & 19 == 18) {
            if (!obj7.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty, -1, "androidx.compose.material3.internal.Decoration (TextFieldImpl.kt:303)");
                }
                CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.box-impl(contentColor)), $composer, obj7, $stable |= str);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                obj7.skipToGroupEnd();
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = obj7.endRestartGroup();
        if (endRestartGroup != null) {
            skipping = new TextFieldImplKt.Decoration.2(contentColor, content, $composer, obj8);
            endRestartGroup.updateScope((Function2)skipping);
        }
    }

    private static final void TextFieldTransitionScope-Jy8F4Js(androidx.compose.material3.internal.InputPhase inputState, long focusedLabelTextStyleColor, long unfocusedLabelTextStyleColor, long labelColor, boolean showLabel, Function7<? super State<Float>, ? super State<Color>, ? super State<Color>, ? super State<Float>, ? super State<Float>, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        Object $this$animateValue$iv$iv4;
        int i3;
        Object it10;
        int i6;
        Object $this$animateValue$iv$iv3;
        int i;
        Object it3;
        int i4;
        Float initialValue$iv$iv2;
        String str2;
        Float initialValue$iv$iv4;
        Object it4;
        int i2;
        Object initialValue$iv$iv3;
        Object it11;
        Object colorSpace$iv;
        void obj5;
        void obj6;
        Object it12;
        Object it15;
        Object invoke;
        Object it;
        Object invoke2;
        Object $this$animateValue$iv$iv;
        Object it9;
        boolean changed;
        boolean changed2;
        String str3;
        Composer $composer3;
        Composer $composer4;
        Transition $this$animateValue$iv$iv6;
        Composer $composer2;
        Object it6;
        Object $i$f$cache;
        boolean traceInProgress;
        Object it8;
        Object it5;
        Object it2;
        Object it7;
        Object it16;
        Float num;
        Object it13;
        Composer composer;
        Composer composer3;
        Transition $this$animateValue$iv$iv7;
        Transition $this$animateValue$iv$iv2;
        Object companion2;
        Object companion;
        String str4;
        Object it14;
        Object obj14;
        boolean invalid$iv$iv;
        boolean invalid$iv$iv2;
        int i5;
        int color;
        Transition $this$animateValue$iv$iv5;
        Object obj3;
        String str;
        Composer composer2;
        Float initialValue$iv$iv;
        Composer $composer5;
        Object obj2;
        Float num2;
        Object obj;
        Transition transition;
        Composer composer7 = obj40;
        ComposerKt.sourceInformationMarkerStart(composer7, -1087703202, "CC(TextFieldTransitionScope)P(2,1:c#ui.graphics.Color,5:c#ui.graphics.Color,3:c#ui.graphics.Color,4)349@14528L59,352@14632L334,364@15016L1126,394@16193L363,406@16607L318,418@17028L197,424@17231L150:TextFieldImpl.kt#mqatfk");
        final Transition transition5 = TransitionKt.updateTransition(inputState, "TextFieldInputState", composer7, i8 |= 48, 0);
        int i166 = 384;
        int i169 = i166;
        int i170 = 0;
        int i10 = -1338768149;
        ComposerKt.sourceInformationMarkerStart(composer7, i10, "CC(animateFloat)P(2)1966@80444L78:Transition.kt#pdpnli");
        final int i172 = 57344;
        int i77 = i10;
        $this$animateValue$iv$iv4 = transition6;
        int i173 = i31;
        int i177 = 0;
        str3 = "CC(animateValue)P(3,2)1883@77007L32,1884@77062L31,1885@77118L23,1887@77154L89:Transition.kt#pdpnli";
        ComposerKt.sourceInformationMarkerStart(composer7, -142660079, str3);
        int i186 = 0;
        final int i194 = i166;
        Composer composer15 = composer16;
        composer15.startReplaceGroup(-2036730335);
        String str10 = "C:TextFieldImpl.kt#mqatfk";
        ComposerKt.sourceInformation(composer15, str10);
        final int i196 = i159;
        if (ComposerKt.isTraceInProgress()) {
            $this$animateValue$iv$iv7 = $this$animateValue$iv$iv4;
            str4 = str3;
            ComposerKt.traceEventStart(-2036730335, i182 & 112, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:356)");
        } else {
            $this$animateValue$iv$iv7 = $this$animateValue$iv$iv4;
            str4 = str3;
        }
        i5 = 0;
        int i200 = 1065353216;
        switch (i11) {
            case 1:
                i3 = i200;
                break;
            case 2:
                i3 = i5;
                break;
            case 3:
                i3 = i200;
                break;
            default:
                NoWhenBranchMatchedException noWhenBranchMatchedException4 = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException4;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer15.endReplaceGroup();
        initialValue$iv$iv2 = Float.valueOf(i3);
        it10 = $this$animateValue$iv$iv7.getTargetState();
        Composer composer9 = obj40;
        int i167 = 0;
        int i161 = -2036730335;
        composer9.startReplaceGroup(i161);
        ComposerKt.sourceInformation(composer9, str10);
        if (ComposerKt.isTraceInProgress()) {
            it8 = it10;
            num = initialValue$iv$iv2;
            ComposerKt.traceEventStart(i161, i100 &= 112, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:356)");
        } else {
            it8 = it10;
            num = initialValue$iv$iv2;
        }
        switch (i12) {
            case 1:
                i6 = i200;
                break;
            case 2:
                i6 = i5;
                break;
            case 3:
                i6 = i200;
                break;
            default:
                NoWhenBranchMatchedException noWhenBranchMatchedException3 = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException3;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer9.endReplaceGroup();
        int i162 = 458752;
        int i183 = i162;
        ComposerKt.sourceInformationMarkerEnd(composer7);
        ComposerKt.sourceInformationMarkerEnd(composer7);
        int i171 = i194;
        int i174 = 0;
        ComposerKt.sourceInformationMarkerStart(composer7, -1338768149, "CC(animateFloat)P(2)1966@80444L78:Transition.kt#pdpnli");
        int i178 = i15 | i41;
        $this$animateValue$iv$iv3 = transition7;
        int i184 = 0;
        str2 = str22;
        ComposerKt.sourceInformationMarkerStart(composer7, -142660079, str2);
        Composer composer10 = obj40;
        int i187 = 0;
        int i164 = 1435837472;
        composer10.startReplaceGroup(i164);
        String str21 = str23;
        ComposerKt.sourceInformation(composer10, str21);
        if (ComposerKt.isTraceInProgress()) {
            $this$animateValue$iv$iv2 = $this$animateValue$iv$iv3;
            str = str2;
            ComposerKt.traceEventStart(i164, i104 &= 112, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:386)");
        } else {
            $this$animateValue$iv$iv2 = $this$animateValue$iv$iv3;
            str = str2;
        }
        switch (i16) {
            case 1:
                i = i200;
                break;
            case 2:
                i = i5;
                i = i200;
                break;
            case 3:
                i = i5;
                break;
            default:
                NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer10.endReplaceGroup();
        initialValue$iv$iv4 = Float.valueOf(i);
        it3 = $this$animateValue$iv$iv2.getTargetState();
        Composer composer4 = obj40;
        int i143 = 0;
        composer4.startReplaceGroup(i164);
        ComposerKt.sourceInformation(composer4, str21);
        if (ComposerKt.isTraceInProgress()) {
            it13 = it3;
            num2 = initialValue$iv$iv4;
            ComposerKt.traceEventStart(i164, i79 &= 112, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:386)");
        } else {
            it13 = it3;
            num2 = initialValue$iv$iv4;
        }
        switch (i17) {
            case 1:
                i4 = i200;
                break;
            case 2:
                i4 = i5;
                i4 = i200;
                break;
            case 3:
                i4 = i5;
                break;
            default:
                NoWhenBranchMatchedException noWhenBranchMatchedException2 = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException2;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer4.endReplaceGroup();
        String str20 = str;
        ComposerKt.sourceInformationMarkerEnd(composer7);
        ComposerKt.sourceInformationMarkerEnd(composer7);
        int i175 = i194;
        int i179 = 0;
        ComposerKt.sourceInformationMarkerStart(composer7, -1338768149, "CC(animateFloat)P(2)1966@80444L78:Transition.kt#pdpnli");
        int i185 = i22 | i53;
        Transition transition3 = transition8;
        int i188 = 0;
        ComposerKt.sourceInformationMarkerStart(composer7, -142660079, str20);
        it4 = transition3.getCurrentState();
        $composer3 = obj40;
        int i145 = 0;
        companion2 = transition3;
        int $this$animateValue$iv$iv10 = 1128033978;
        $composer3.startReplaceGroup($this$animateValue$iv$iv10);
        ComposerKt.sourceInformation($composer3, str21);
        if (ComposerKt.isTraceInProgress()) {
            it14 = it4;
            composer2 = $composer3;
            ComposerKt.traceEventStart($this$animateValue$iv$iv10, i82 &= 112, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:398)");
        } else {
            it14 = it4;
            composer2 = $composer3;
        }
        switch (i55) {
            case 1:
                i2 = i200;
                break;
            case 2:
                i2 = i5;
                i2 = i200;
                break;
            case 3:
                i2 = i200;
                break;
            default:
                NoWhenBranchMatchedException noWhenBranchMatchedException6 = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException6;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer2.endReplaceGroup();
        initialValue$iv$iv3 = Float.valueOf(i2);
        it15 = companion2.getTargetState();
        Composer composer11 = obj40;
        int i197 = 0;
        composer11.startReplaceGroup($this$animateValue$iv$iv10);
        ComposerKt.sourceInformation(composer11, str21);
        if (ComposerKt.isTraceInProgress()) {
            initialValue$iv$iv = initialValue$iv$iv3;
            obj = it15;
            ComposerKt.traceEventStart($this$animateValue$iv$iv10, i106 &= 112, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:398)");
        } else {
            initialValue$iv$iv = initialValue$iv$iv3;
            obj = it15;
        }
        switch (i23) {
            case 1:
                i5 = i200;
                break;
            case 2:
                i5 = i200;
                break;
            case 3:
                i5 = i200;
                break;
            default:
                NoWhenBranchMatchedException noWhenBranchMatchedException5 = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException5;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer11.endReplaceGroup();
        ComposerKt.sourceInformationMarkerEnd(composer7);
        ComposerKt.sourceInformationMarkerEnd(composer7);
        androidx.compose.material3.internal.TextFieldImplKt.TextFieldTransitionScope.labelTextStyleColor.1 iNSTANCE6 = TextFieldImplKt.TextFieldTransitionScope.labelTextStyleColor.1.INSTANCE;
        Transition transition9 = transition5;
        int i176 = i194;
        int i180 = 0;
        ComposerKt.sourceInformationMarkerStart(composer7, -1939694975, "CC(animateColor)P(2)68@3220L31,69@3287L70,73@3370L70:Transition.kt#xbi5r1");
        it11 = transition9.getTargetState();
        $composer4 = obj40;
        int i130 = 0;
        int i147 = -107432127;
        $composer4.startReplaceGroup(i147);
        ComposerKt.sourceInformation($composer4, str21);
        if (ComposerKt.isTraceInProgress()) {
            it5 = it11;
            composer = $composer4;
            ComposerKt.traceEventStart(i147, i84 &= 112, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:410)");
        } else {
            it5 = it11;
            composer = $composer4;
        }
        obj14 = TextFieldImplKt.WhenMappings.$EnumSwitchMapping$1[it5.ordinal()] == 1 ? focusedLabelTextStyleColor : labelColor;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        androidx.compose.ui.graphics.colorspace.ColorSpace colorSpace-impl = Color.getColorSpace-impl(obj14);
        ComposerKt.sourceInformationMarkerStart(composer7, 1918408083, "CC(remember):Transition.kt#9igjgp");
        changed2 = composer7.changed(colorSpace-impl);
        Composer composer5 = obj40;
        int i131 = 0;
        Object rememberedValue = composer5.rememberedValue();
        int i189 = 0;
        if (!changed2) {
            invalid$iv$iv = changed2;
            if (rememberedValue == Composer.Companion.getEmpty()) {
                i5 = invalid$iv$iv4;
                composer5.updateRememberedValue((TwoWayConverter)ColorVectorConverterKt.getVectorConverter(Color.Companion).invoke(colorSpace-impl));
            } else {
                invoke = rememberedValue;
            }
        } else {
            invalid$iv$iv = changed2;
        }
        $i$f$cache = invoke;
        ComposerKt.sourceInformationMarkerEnd(composer7);
        $this$animateValue$iv$iv6 = transition9;
        int i190 = i90;
        companion = 0;
        ComposerKt.sourceInformationMarkerStart(composer7, -142660079, str20);
        int i199 = 0;
        androidx.compose.ui.graphics.colorspace.ColorSpace colorSpace2 = colorSpace-impl;
        colorSpace$iv = composer17;
        int it21 = -107432127;
        colorSpace$iv.startReplaceGroup(it21);
        ComposerKt.sourceInformation(colorSpace$iv, str21);
        if (ComposerKt.isTraceInProgress()) {
            $composer5 = colorSpace$iv;
            transition = $this$animateValue$iv$iv6;
            ComposerKt.traceEventStart(it21, i148 &= 112, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:410)");
        } else {
            $composer5 = colorSpace$iv;
            transition = $this$animateValue$iv$iv6;
        }
        int i92 = 1;
        obj5 = TextFieldImplKt.WhenMappings.$EnumSwitchMapping$1[(InputPhase)$this$animateValue$iv$iv6.getCurrentState().ordinal()] == i92 ? focusedLabelTextStyleColor : labelColor;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer5.endReplaceGroup();
        it = transition.getTargetState();
        Composer composer12 = obj40;
        int i198 = 0;
        int initialValue$iv$iv5 = -107432127;
        composer12.startReplaceGroup(initialValue$iv$iv5);
        ComposerKt.sourceInformation(composer12, str21);
        if (ComposerKt.isTraceInProgress()) {
            it2 = it;
            obj2 = $i$f$cache;
            ComposerKt.traceEventStart(initialValue$iv$iv5, i115 &= 112, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:410)");
        } else {
            it2 = it;
            obj2 = $i$f$cache;
        }
        int i93 = 1;
        obj6 = TextFieldImplKt.WhenMappings.$EnumSwitchMapping$1[it2.ordinal()] == i93 ? focusedLabelTextStyleColor : labelColor;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer12.endReplaceGroup();
        androidx.compose.material3.internal.TextFieldImplKt.TextFieldTransitionScope.labelTextStyleColor.1 field5 = iNSTANCE6;
        ComposerKt.sourceInformationMarkerEnd(composer7);
        ComposerKt.sourceInformationMarkerEnd(composer7);
        androidx.compose.material3.internal.TextFieldImplKt.TextFieldTransitionScope.labelContentColor.1 iNSTANCE7 = TextFieldImplKt.TextFieldTransitionScope.labelContentColor.1.INSTANCE;
        Transition transition10 = transition5;
        int i181 = 0;
        ComposerKt.sourceInformationMarkerStart(composer7, -1939694975, "CC(animateColor)P(2)68@3220L31,69@3287L70,73@3370L70:Transition.kt#xbi5r1");
        it12 = transition10.getTargetState();
        $composer2 = obj40;
        int i136 = 0;
        int i151 = 1023351670;
        $composer2.startReplaceGroup(i151);
        ComposerKt.sourceInformation($composer2, str21);
        if (ComposerKt.isTraceInProgress()) {
            it7 = it12;
            composer3 = $composer2;
            ComposerKt.traceEventStart(i151, i94 &= 112, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:421)");
        } else {
            it7 = it12;
            composer3 = $composer2;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer3.endReplaceGroup();
        androidx.compose.ui.graphics.colorspace.ColorSpace colorSpace-impl2 = Color.getColorSpace-impl(content);
        ComposerKt.sourceInformationMarkerStart(composer7, 1918408083, "CC(remember):Transition.kt#9igjgp");
        changed = composer7.changed(colorSpace-impl2);
        Composer composer6 = obj40;
        int i137 = 0;
        Object rememberedValue2 = composer6.rememberedValue();
        int i191 = 0;
        if (!changed) {
            invalid$iv$iv2 = changed;
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                color = invalid$iv$iv3;
                composer6.updateRememberedValue((TwoWayConverter)ColorVectorConverterKt.getVectorConverter(Color.Companion).invoke(colorSpace-impl2));
            } else {
                invoke2 = rememberedValue2;
            }
        } else {
            invalid$iv$iv2 = changed;
        }
        ComposerKt.sourceInformationMarkerEnd(composer7);
        int i192 = i99 | i124;
        $this$animateValue$iv$iv = transition10;
        int i195 = 0;
        ComposerKt.sourceInformationMarkerStart(composer7, -142660079, str20);
        it6 = $this$animateValue$iv$iv.getCurrentState();
        Composer composer14 = obj40;
        int i193 = 0;
        androidx.compose.ui.graphics.colorspace.ColorSpace colorSpace = colorSpace-impl2;
        int colorSpace$iv2 = 1023351670;
        composer14.startReplaceGroup(colorSpace$iv2);
        ComposerKt.sourceInformation(composer14, str21);
        if (ComposerKt.isTraceInProgress()) {
            $this$animateValue$iv$iv5 = $this$animateValue$iv$iv;
            obj3 = it6;
            ComposerKt.traceEventStart(colorSpace$iv2, i152 &= 112, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:421)");
        } else {
            $this$animateValue$iv$iv5 = $this$animateValue$iv$iv;
            obj3 = it6;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer14.endReplaceGroup();
        it9 = $this$animateValue$iv$iv5.getTargetState();
        Composer composer13 = obj40;
        int i165 = 0;
        int initialValue$iv$iv6 = 1023351670;
        composer13.startReplaceGroup(initialValue$iv$iv6);
        ComposerKt.sourceInformation(composer13, str21);
        if (ComposerKt.isTraceInProgress()) {
            it16 = it9;
            ComposerKt.traceEventStart(initialValue$iv$iv6, i126 &= 112, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:421)");
        } else {
            it16 = it9;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer13.endReplaceGroup();
        androidx.compose.material3.internal.TextFieldImplKt.TextFieldTransitionScope.labelContentColor.1 field = iNSTANCE7;
        ComposerKt.sourceInformationMarkerEnd(obj40);
        ComposerKt.sourceInformationMarkerEnd(obj40);
        State state5 = state8;
        obj39.invoke(TransitionKt.createTransitionAnimation($this$animateValue$iv$iv7, num, Float.valueOf(i6), (FiniteAnimationSpec)(Function3)TextFieldImplKt.TextFieldTransitionScope.labelProgress.1.INSTANCE.invoke($this$animateValue$iv$iv7.getSegment(), composer7, Integer.valueOf(i102 &= 112)), VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), "LabelProgress", composer7, i141 |= i35), TransitionKt.createTransitionAnimation(transition, Color.box-impl(obj5), Color.box-impl(obj6), (FiniteAnimationSpec)(Function3)iNSTANCE6.invoke(transition.getSegment(), composer7, Integer.valueOf(i117 &= 112)), obj2, "LabelTextStyleColor", composer7, i67 | i135), TransitionKt.createTransitionAnimation($this$animateValue$iv$iv5, Color.box-impl(content), Color.box-impl(content), (FiniteAnimationSpec)(Function3)iNSTANCE7.invoke($this$animateValue$iv$iv5.getSegment(), composer7, Integer.valueOf(i128 &= 112)), (TwoWayConverter)invoke2, "LabelContentColor", composer7, i157 |= i70), state5, TransitionKt.createTransitionAnimation(companion2, initialValue$iv$iv, Float.valueOf(i5), (FiniteAnimationSpec)(Function3)TextFieldImplKt.TextFieldTransitionScope.prefixSuffixOpacity.1.INSTANCE.invoke(companion2.getSegment(), composer7, Integer.valueOf(i56 &= 112)), VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), "PrefixSuffixOpacity", composer7, i25 | i61), obj40, Integer.valueOf(obj41 & i183));
        State state = state5;
        ComposerKt.sourceInformationMarkerEnd(obj40);
    }

    public static final void access$Decoration-3J-VO9M(long contentColor, TextStyle textStyle, Function2 content, Composer $composer, int $changed) {
        TextFieldImplKt.Decoration-3J-VO9M(contentColor, textStyle, content, $composer, $changed);
    }

    public static final void access$Decoration-Iv8Zu3U(long contentColor, Function2 content, Composer $composer, int $changed) {
        TextFieldImplKt.Decoration-Iv8Zu3U(contentColor, content, $composer, $changed);
    }

    public static final State<BorderStroke> animateBorderStrokeAsState-NuRrP5Q(boolean enabled, boolean isError, boolean focused, TextFieldColors colors, float focusedBorderThickness, float unfocusedBorderThickness, Composer $composer, int $changed) {
        long indicatorColor-XeAY9LY$material3_release;
        State targetThickness;
        float f;
        boolean traceInProgress;
        int tween$default;
        String str;
        State animateColorAsState-euL9pac;
        int i;
        Composer composer;
        Composer composer2;
        int i2;
        int i3;
        int i4;
        long targetColor;
        final boolean z = enabled;
        final boolean z2 = focused;
        composer = $composer;
        final int i14 = $changed;
        int i5 = 2047013045;
        ComposerKt.sourceInformationMarkerStart(composer, i5, "C(animateBorderStrokeAsState)P(1,4,2!1,3:c#ui.unit.Dp,5:c#ui.unit.Dp)458@18252L73:TextFieldImpl.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i5, i14, -1, "androidx.compose.material3.internal.animateBorderStrokeAsState (TextFieldImpl.kt:441)");
        }
        indicatorColor-XeAY9LY$material3_release = colors.indicatorColor-XeAY9LY$material3_release(z, isError, z2);
        final int i16 = 150;
        final int i17 = 0;
        int i10 = 0;
        if (z) {
            composer.startReplaceGroup(1023053998);
            ComposerKt.sourceInformation(composer, "445@17754L84");
            i4 = i13;
            composer2 = $composer;
            animateColorAsState-euL9pac = SingleValueAnimationKt.animateColorAsState-euL9pac(indicatorColor-XeAY9LY$material3_release, traceInProgress, (AnimationSpec)AnimationSpecKt.tween$default(i16, i10, i17, 6, i17), 0, 0, composer2, 48);
            targetColor = indicatorColor-XeAY9LY$material3_release;
            composer2.endReplaceGroup();
        } else {
            composer.startReplaceGroup(1023165505);
            ComposerKt.sourceInformation(composer, "447@17868L33");
            animateColorAsState-euL9pac = SnapshotStateKt.rememberUpdatedState(Color.box-impl(indicatorColor-XeAY9LY$material3_release), composer, i10);
            composer.endReplaceGroup();
        }
        if (z) {
            composer.startReplaceGroup(1023269417);
            ComposerKt.sourceInformation(composer, "453@18068L85");
            f = z2 ? focusedBorderThickness : unfocusedBorderThickness;
            targetThickness = AnimateAsStateKt.animateDpAsState-AjpBEmI(f, (AnimationSpec)AnimationSpecKt.tween$default(i16, i4, i17, 6, i17), 0, 0, composer, 48, 12);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(1023478388);
            ComposerKt.sourceInformation(composer, "455@18183L46");
            targetThickness = SnapshotStateKt.rememberUpdatedState(Dp.box-impl(unfocusedBorderThickness), composer, i8 &= 14);
            composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return SnapshotStateKt.rememberUpdatedState(BorderStrokeKt.BorderStroke-cXLIe8U((Dp)targetThickness.getValue().unbox-impl(), (Color)animateColorAsState-euL9pac.getValue().unbox-impl()), composer, i4);
    }

    public static final Modifier defaultErrorSemantics(Modifier $this$defaultErrorSemantics, boolean isError, String defaultErrorMessage) {
        Modifier semantics$default;
        int i;
        int i3;
        int i2;
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

    public static final float getMinFocusedLabelLineHeight() {
        return TextFieldImplKt.MinFocusedLabelLineHeight;
    }

    public static final float getMinSupportingTextLineHeight() {
        return TextFieldImplKt.MinSupportingTextLineHeight;
    }

    public static final float getMinTextLineHeight() {
        return TextFieldImplKt.MinTextLineHeight;
    }

    public static final float getPrefixSuffixTextPadding() {
        return TextFieldImplKt.PrefixSuffixTextPadding;
    }

    public static final float getSupportingTopPadding() {
        return TextFieldImplKt.SupportingTopPadding;
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

    public static final Modifier textFieldBackground(Modifier $this$textFieldBackground, ColorProducer color, Shape shape) {
        TextFieldImplKt.textFieldBackground.1 anon = new TextFieldImplKt.textFieldBackground.1(shape, color);
        return DrawModifierKt.drawWithCache($this$textFieldBackground, (Function1)anon);
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
