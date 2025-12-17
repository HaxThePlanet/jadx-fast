package androidx.compose.material3;

import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardActions.Companion;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.KeyboardOptions.Companion;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material3.internal.TextFieldImplKt;
import androidx.compose.material3.tokens.TypeScaleTokens;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Alignment.Companion;
import androidx.compose.ui.Alignment.Vertical;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.Placeable.PlacementScope;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode.Companion;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.input.VisualTransformation.Companion;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffset.Companion;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000°\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0010\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001aØ\u0002\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\u000c\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t0\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00142\u0015\u0008\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\u0008\u00172\u0015\u0008\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\u0008\u00172\u0015\u0008\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\u0008\u00172\u0015\u0008\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\u0008\u00172\u0015\u0008\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\u0008\u00172\u0015\u0008\u0002\u0010\u001c\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\u0008\u00172\u0015\u0008\u0002\u0010\u001d\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\u0008\u00172\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u001f\u001a\u00020 2\u0008\u0008\u0002\u0010!\u001a\u00020\"2\u0008\u0008\u0002\u0010#\u001a\u00020$2\u0008\u0008\u0002\u0010%\u001a\u00020\u00112\u0008\u0008\u0002\u0010&\u001a\u00020'2\u0008\u0008\u0002\u0010(\u001a\u00020'2\n\u0008\u0002\u0010)\u001a\u0004\u0018\u00010*2\u0008\u0008\u0002\u0010+\u001a\u00020,2\u0008\u0008\u0002\u0010-\u001a\u00020.H\u0007¢\u0006\u0002\u0010/\u001aØ\u0002\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u0002002\u0012\u0010\u000c\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\t0\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00142\u0015\u0008\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\u0008\u00172\u0015\u0008\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\u0008\u00172\u0015\u0008\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\u0008\u00172\u0015\u0008\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\u0008\u00172\u0015\u0008\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\u0008\u00172\u0015\u0008\u0002\u0010\u001c\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\u0008\u00172\u0015\u0008\u0002\u0010\u001d\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\u0008\u00172\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u001f\u001a\u00020 2\u0008\u0008\u0002\u0010!\u001a\u00020\"2\u0008\u0008\u0002\u0010#\u001a\u00020$2\u0008\u0008\u0002\u0010%\u001a\u00020\u00112\u0008\u0008\u0002\u0010&\u001a\u00020'2\u0008\u0008\u0002\u0010(\u001a\u00020'2\n\u0008\u0002\u0010)\u001a\u0004\u0018\u00010*2\u0008\u0008\u0002\u0010+\u001a\u00020,2\u0008\u0008\u0002\u0010-\u001a\u00020.H\u0007¢\u0006\u0002\u00101\u001a\u0080\u0002\u00102\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0011\u00103\u001a\r\u0012\u0004\u0012\u00020\t0\u0016¢\u0006\u0002\u0008\u00172\u0019\u0010\u0018\u001a\u0015\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\r¢\u0006\u0002\u0008\u00172\u0013\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\u0008\u00172\u0013\u00104\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\u0008\u00172\u0013\u00105\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\u0008\u00172\u0013\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\u0008\u00172\u0013\u0010\u001c\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\u0008\u00172\u0006\u0010%\u001a\u00020\u00112\u0006\u00106\u001a\u0002072\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020\t0\r2\u0011\u0010:\u001a\r\u0012\u0004\u0012\u00020\t0\u0016¢\u0006\u0002\u0008\u00172\u0013\u0010;\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\u0008\u00172\u0006\u0010<\u001a\u00020=H\u0001¢\u0006\u0002\u0010>\u001ar\u0010?\u001a\u00020'2\u0006\u0010@\u001a\u00020'2\u0006\u0010A\u001a\u00020'2\u0006\u0010B\u001a\u00020'2\u0006\u0010C\u001a\u00020'2\u0006\u0010D\u001a\u00020'2\u0006\u0010E\u001a\u00020'2\u0006\u0010F\u001a\u00020'2\u0006\u0010G\u001a\u00020'2\u0006\u00106\u001a\u0002072\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u0002072\u0006\u0010<\u001a\u00020=H\u0002ø\u0001\u0000¢\u0006\u0004\u0008K\u0010L\u001aj\u0010M\u001a\u00020'2\u0006\u0010N\u001a\u00020'2\u0006\u0010O\u001a\u00020'2\u0006\u0010P\u001a\u00020'2\u0006\u0010Q\u001a\u00020'2\u0006\u0010R\u001a\u00020'2\u0006\u0010S\u001a\u00020'2\u0006\u0010T\u001a\u00020'2\u0006\u00106\u001a\u0002072\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u0002072\u0006\u0010<\u001a\u00020=H\u0002ø\u0001\u0000¢\u0006\u0004\u0008U\u0010V\u001a\"\u0010W\u001a\u00020\u000f*\u00020\u000f2\u000c\u0010X\u001a\u0008\u0012\u0004\u0012\u0002090\u00162\u0006\u0010<\u001a\u00020=H\u0000\u001a\u009a\u0001\u0010Y\u001a\u00020\t*\u00020Z2\u0006\u0010[\u001a\u00020'2\u0006\u0010\\\u001a\u00020'2\u0008\u0010]\u001a\u0004\u0018\u00010^2\u0008\u0010_\u001a\u0004\u0018\u00010^2\u0008\u0010`\u001a\u0004\u0018\u00010^2\u0008\u0010a\u001a\u0004\u0018\u00010^2\u0006\u0010b\u001a\u00020^2\u0008\u0010c\u001a\u0004\u0018\u00010^2\u0008\u0010d\u001a\u0004\u0018\u00010^2\u0006\u0010e\u001a\u00020^2\u0008\u0010f\u001a\u0004\u0018\u00010^2\u0006\u00106\u001a\u0002072\u0006\u0010%\u001a\u00020\u00112\u0006\u0010J\u001a\u0002072\u0006\u0010g\u001a\u00020h2\u0006\u0010<\u001a\u00020=H\u0002\u001a\u0014\u0010i\u001a\u00020'*\u00020'2\u0006\u0010j\u001a\u00020'H\u0002\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0016\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006k", d2 = {"OutlinedTextFieldInnerPadding", "Landroidx/compose/ui/unit/Dp;", "F", "OutlinedTextFieldTopPadding", "Landroidx/compose/ui/unit/TextUnit;", "getOutlinedTextFieldTopPadding", "()J", "J", "OutlinedTextField", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "label", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "placeholder", "leadingIcon", "trailingIcon", "prefix", "suffix", "supportingText", "isError", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "minLines", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/TextFieldColors;", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "OutlinedTextFieldLayout", "textField", "leading", "trailing", "animationProgress", "", "onLabelMeasured", "Landroidx/compose/ui/geometry/Size;", "container", "supporting", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZFLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;II)V", "calculateHeight", "leadingHeight", "trailingHeight", "prefixHeight", "suffixHeight", "textFieldHeight", "labelHeight", "placeholderHeight", "supportingHeight", "constraints", "Landroidx/compose/ui/unit/Constraints;", "density", "calculateHeight-mKXJcVc", "(IIIIIIIIFJFLandroidx/compose/foundation/layout/PaddingValues;)I", "calculateWidth", "leadingPlaceableWidth", "trailingPlaceableWidth", "prefixPlaceableWidth", "suffixPlaceableWidth", "textFieldPlaceableWidth", "labelPlaceableWidth", "placeholderPlaceableWidth", "calculateWidth-DHJA7U0", "(IIIIIIIFJFLandroidx/compose/foundation/layout/PaddingValues;)I", "outlineCutout", "labelSize", "place", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "totalHeight", "width", "leadingPlaceable", "Landroidx/compose/ui/layout/Placeable;", "trailingPlaceable", "prefixPlaceable", "suffixPlaceable", "textFieldPlaceable", "labelPlaceable", "placeholderPlaceable", "containerPlaceable", "supportingPlaceable", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "substractConstraintSafely", "from", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class OutlinedTextFieldKt {

    private static final float OutlinedTextFieldInnerPadding;
    private static final long OutlinedTextFieldTopPadding;
    static {
        final int i2 = 0;
        OutlinedTextFieldKt.OutlinedTextFieldInnerPadding = Dp.constructor-impl((float)i);
        long bodySmallLineHeight-XSAIIZE = TypeScaleTokens.INSTANCE.getBodySmallLineHeight-XSAIIZE();
        final int i4 = 0;
        TextUnitKt.checkArithmetic--R2X_6o(bodySmallLineHeight-XSAIIZE);
        OutlinedTextFieldKt.OutlinedTextFieldTopPadding = TextUnitKt.pack(TextUnit.getRawType-impl(bodySmallLineHeight-XSAIIZE), obj5);
    }

    public static final void OutlinedTextField(TextFieldValue value, Function1<? super TextFieldValue, Unit> onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> label, Function2<? super Composer, ? super Integer, Unit> placeholder, Function2<? super Composer, ? super Integer, Unit> leadingIcon, Function2<? super Composer, ? super Integer, Unit> trailingIcon, Function2<? super Composer, ? super Integer, Unit> prefix, Function2<? super Composer, ? super Integer, Unit> suffix, Function2<? super Composer, ? super Integer, Unit> supportingText, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, int minLines, MutableInteractionSource interactionSource, Shape shape, androidx.compose.material3.TextFieldColors colors, Composer $composer, int $changed, int $changed1, int $changed2, int i28) {
        Object obj2;
        Object obj17;
        Object obj10;
        Object obj3;
        Object obj15;
        Object obj4;
        boolean z3;
        Object obj19;
        Object obj5;
        Object obj14;
        boolean z2;
        int i62;
        int i68;
        Object obj;
        Object obj18;
        Object obj11;
        int skipping;
        int i4;
        int i63;
        Object colors2;
        int defaultsInvalid;
        int this_$iv;
        int placeholder2;
        Composer $composer4;
        int rememberComposableLambda;
        int rememberedValue;
        int leadingIcon2;
        Object leadingIcon4;
        ScopeUpdateScope endRestartGroup;
        Object trailingIcon3;
        int $composer2;
        int trailingIcon2;
        int i37;
        int i52;
        Object obj7;
        boolean $composer3;
        int $dirty3;
        boolean $dirty;
        int $dirty12;
        Object $dirty1;
        int $dirty2;
        Object $dirty22;
        Object obj8;
        int i41;
        Object obj9;
        boolean traceInProgress;
        String str;
        int booleanValue;
        int i22;
        boolean obj21;
        int i58;
        int i60;
        Object obj16;
        int i56;
        boolean z;
        Object readOnly3;
        int modifier2;
        Object obj6;
        Object textStyle3;
        int label3;
        int i8;
        int prefix2;
        int i24;
        Object obj20;
        int label2;
        VisualTransformation isError4;
        int suffix2;
        long $this$takeOrElse_u2dDxMtmZc$iv;
        KeyboardOptions colors3;
        int i69;
        int supportingText2;
        KeyboardActions keyboardActions3;
        int i39;
        int visualTransformation2;
        long textColor-XeAY9LY$material3_release;
        int i57;
        int changed6;
        int keyboardOptions2;
        int enabled2;
        int i47;
        int changed4;
        boolean isError2;
        int isError3;
        int readOnly2;
        int i44;
        int keyboardActions4;
        int mergedTextStyle;
        int i48;
        Object singleLine2;
        int singleLine3;
        Shape keyboardOptions3;
        int i14;
        Object maxLines3;
        int maxLines2;
        androidx.compose.material3.TextFieldColors keyboardActions2;
        int minLines2;
        int minLines3;
        int i53;
        int i18;
        int i16;
        int changed5;
        int interactionSource2;
        int interactionSource3;
        int i38;
        int i10;
        Object i36;
        int changed3;
        int i23;
        int i5;
        int changed;
        int obj12;
        int placeholder3;
        int i49;
        int obj13;
        int leadingIcon3;
        int i19;
        int i17;
        Composer $composer5;
        int i46;
        int i59;
        int i54;
        int i11;
        int i15;
        Object i29;
        int textStyle2;
        int i26;
        int i65;
        int i7;
        int i45;
        int i64;
        int i51;
        int i61;
        int i6;
        boolean changed2;
        int i25;
        int i27;
        int i35;
        int i13;
        int i33;
        int i2;
        int i34;
        int i21;
        int i;
        int i43;
        int i32;
        int i50;
        int i30;
        int i55;
        int i9;
        int i12;
        int i20;
        int i66;
        int i67;
        int i3;
        int i31;
        int i42;
        int i40;
        ScopeUpdateScope scopeUpdateScope;
        int obj71;
        int obj72;
        Shape obj73;
        int i70 = $changed;
        int i90 = $changed1;
        $composer2 = $changed2;
        i37 = i28;
        Composer restartGroup = $composer.startRestartGroup(-1570442800);
        ComposerKt.sourceInformation(restartGroup, "C(OutlinedTextField)P(21,11,10,1,14,19,6,12,7,20,13,17,18,3,22,5,4,16,8,9,2,15)350@19364L7,366@20168L5,367@20231L8,379@20751L7,381@20851L2858,381@20764L2945:OutlinedTextField.kt#uh7d8r");
        $dirty3 = $changed;
        $dirty12 = $changed1;
        $dirty2 = $changed2;
        if (i37 & 1 != 0) {
            $dirty3 |= 6;
            obj8 = value;
        } else {
            if (i70 & 6 == 0) {
                i60 = restartGroup.changed(value) ? 4 : 2;
                $dirty3 |= i60;
            } else {
                obj8 = value;
            }
        }
        if (i37 & 2 != 0) {
            $dirty3 |= 48;
            obj16 = onValueChange;
        } else {
            if (i70 & 48 == 0) {
                i8 = restartGroup.changedInstance(onValueChange) ? 32 : 16;
                $dirty3 |= i8;
            } else {
                obj16 = onValueChange;
            }
        }
        prefix2 = i37 & 4;
        int i113 = 128;
        if (prefix2 != 0) {
            $dirty3 |= 384;
            obj9 = modifier;
        } else {
            if (i70 & 384 == 0) {
                i69 = restartGroup.changed(modifier) ? 256 : i113;
                $dirty3 |= i69;
            } else {
                obj9 = modifier;
            }
        }
        supportingText2 = i37 & 8;
        changed6 = 1024;
        if (supportingText2 != 0) {
            $dirty3 |= 3072;
            obj21 = enabled;
        } else {
            if (i70 & 3072 == 0) {
                i44 = restartGroup.changed(enabled) ? i39 : changed6;
                $dirty3 |= i44;
            } else {
                obj21 = enabled;
            }
        }
        keyboardActions4 = i37 & 16;
        i14 = 8192;
        if (keyboardActions4 != 0) {
            $dirty3 |= 24576;
            z = readOnly;
        } else {
            if (i70 & 24576 == 0) {
                i53 = restartGroup.changed(readOnly) ? i48 : i14;
                $dirty3 |= i53;
            } else {
                z = readOnly;
            }
        }
        i18 = 196608;
        i10 = 65536;
        if (i70 & i18 == 0) {
            if (i37 & 32 == 0) {
                changed3 = restartGroup.changed(textStyle) ? 131072 : i10;
            } else {
                obj6 = textStyle;
            }
            $dirty3 |= changed3;
        } else {
            obj6 = textStyle;
        }
        int i128 = i37 & 64;
        changed = 1572864;
        if (i128 != 0) {
            $dirty3 |= changed;
            obj20 = label;
        } else {
            if (i70 & changed == 0) {
                i19 = restartGroup.changedInstance(label) ? 1048576 : 524288;
                $dirty3 |= i19;
            } else {
                obj20 = label;
            }
        }
        int i71 = i37 & 128;
        i17 = 12582912;
        i46 = 4194304;
        if (i71 != 0) {
            $dirty3 |= i17;
            i59 = i71;
            obj2 = placeholder;
        } else {
            if ($changed & i17 == 0) {
                i59 = i71;
                i54 = restartGroup.changedInstance(placeholder) ? 8388608 : i46;
                $dirty3 |= i54;
            } else {
                i59 = i71;
                obj2 = placeholder;
            }
        }
        int i72 = i37 & 256;
        int i130 = 100663296;
        if (i72 != 0) {
            $dirty3 |= i130;
            i11 = i72;
            obj17 = leadingIcon;
        } else {
            if ($changed & i130 == 0) {
                i11 = i72;
                i15 = restartGroup.changedInstance(leadingIcon) ? 67108864 : 33554432;
                $dirty3 |= i15;
            } else {
                i11 = i72;
                obj17 = leadingIcon;
            }
        }
        int i73 = i37 & 512;
        i29 = 805306368;
        if (i73 != 0) {
            $dirty3 |= i29;
            textStyle2 = i73;
            obj10 = trailingIcon;
        } else {
            if ($changed & i29 == 0) {
                textStyle2 = i73;
                i26 = restartGroup.changedInstance(trailingIcon) ? 536870912 : 268435456;
                $dirty3 |= i26;
            } else {
                textStyle2 = i73;
                obj10 = trailingIcon;
            }
        }
        int i74 = i37 & 1024;
        if (i74 != 0) {
            $dirty12 |= 6;
            i65 = i74;
            obj3 = prefix;
        } else {
            if (i90 & 6 == 0) {
                i65 = i74;
                i7 = restartGroup.changedInstance(prefix) ? 4 : 2;
                $dirty12 |= i7;
            } else {
                i65 = i74;
                obj3 = prefix;
            }
        }
        int i75 = i37 & 2048;
        if (i75 != 0) {
            $dirty12 |= 48;
            i45 = i75;
            obj15 = suffix;
        } else {
            if (i90 & 48 == 0) {
                i45 = i75;
                i64 = restartGroup.changedInstance(suffix) ? 32 : 16;
                $dirty12 |= i64;
            } else {
                i45 = i75;
                obj15 = suffix;
            }
        }
        int i76 = i37 & 4096;
        if (i76 != 0) {
            $dirty12 |= 384;
            i51 = i76;
            obj4 = supportingText;
        } else {
            i51 = i76;
            if (i90 & 384 == 0) {
                i61 = restartGroup.changedInstance(supportingText) ? 256 : i113;
                $dirty12 |= i61;
            } else {
                obj4 = supportingText;
            }
        }
        int i78 = i37 & 8192;
        if (i78 != 0) {
            $dirty12 |= 3072;
            i6 = i78;
            z3 = isError;
        } else {
            i6 = i78;
            if (i90 & 3072 == 0) {
                if (restartGroup.changed(isError)) {
                } else {
                    i39 = changed6;
                }
                $dirty12 |= i39;
            } else {
                z3 = isError;
            }
        }
        int i79 = i37 & 16384;
        if (i79 != 0) {
            $dirty12 |= 24576;
            visualTransformation2 = i79;
            obj19 = visualTransformation;
        } else {
            visualTransformation2 = i79;
            if (i90 & 24576 == 0) {
                if (restartGroup.changed(visualTransformation)) {
                } else {
                    i48 = i14;
                }
                $dirty12 |= i48;
            } else {
                obj19 = visualTransformation;
            }
        }
        keyboardOptions2 = i37 & i114;
        if (keyboardOptions2 != 0) {
            $dirty12 |= i18;
            obj5 = keyboardOptions;
        } else {
            if (i90 & i18 == 0) {
                i48 = restartGroup.changed(keyboardOptions) ? 131072 : i10;
                $dirty12 |= i48;
            } else {
                obj5 = keyboardOptions;
            }
        }
        int i116 = i37 & i10;
        if (i116 != 0) {
            $dirty12 |= changed;
            obj14 = keyboardActions;
        } else {
            if (i90 & changed == 0) {
                i14 = restartGroup.changed(keyboardActions) ? 1048576 : 524288;
                $dirty12 |= i14;
            } else {
                obj14 = keyboardActions;
            }
        }
        int i118 = i37 & i117;
        if (i118 != 0) {
            $dirty12 |= i17;
            z2 = singleLine;
        } else {
            if (i90 & i17 == 0) {
                i18 = restartGroup.changed(singleLine) ? 8388608 : i46;
                $dirty12 |= i18;
            } else {
                z2 = singleLine;
            }
        }
        if (i90 & i121 == 0) {
            if (i37 & i122 == 0) {
                i16 = restartGroup.changed(maxLines) ? 67108864 : 33554432;
            } else {
                i62 = maxLines;
            }
            $dirty12 |= i16;
        } else {
            i62 = maxLines;
        }
        interactionSource2 = i37 & i123;
        if (interactionSource2 != 0) {
            $dirty12 |= i29;
            i68 = minLines;
        } else {
            if (i90 & i29 == 0) {
                i10 = restartGroup.changed(minLines) ? 536870912 : 268435456;
                $dirty12 |= i10;
            } else {
                i68 = minLines;
            }
        }
        i36 = i37 & i127;
        if (i36 != 0) {
            $dirty2 |= 6;
            obj = interactionSource;
        } else {
            if ($composer2 & 6 == 0) {
                i47 = restartGroup.changed(interactionSource) ? 4 : 2;
                $dirty2 |= i47;
            } else {
                obj = interactionSource;
            }
        }
        if ($composer2 & 48 == 0) {
            if (i37 & i115 == 0) {
                minLines2 = restartGroup.changed(shape) ? 32 : 16;
            } else {
                obj18 = shape;
            }
            $dirty2 |= minLines2;
        } else {
            obj18 = shape;
        }
        if ($composer2 & 384 == 0) {
            if (i37 & i46 == 0) {
                i49 = restartGroup.changed(colors) ? 256 : i113;
            } else {
                obj11 = colors;
            }
            $dirty2 |= i49;
        } else {
            obj11 = colors;
        }
        if ($dirty3 & suffix2 == 306783378 && i86 &= $dirty12 == 306783378 && $dirty2 & 147 == 146) {
            if (i86 &= $dirty12 == 306783378) {
                if ($dirty2 & 147 == 146) {
                    if (!restartGroup.getSkipping()) {
                        restartGroup.startDefaults();
                        if ($changed & 1 != 0) {
                            if (restartGroup.getDefaultsInvalid()) {
                                if (prefix2 != 0) {
                                    obj9 = defaultsInvalid;
                                }
                                if (supportingText2 != 0) {
                                    obj21 = defaultsInvalid;
                                }
                                if (keyboardActions4 != 0) {
                                    z = defaultsInvalid;
                                }
                                if (i37 & 32 != 0) {
                                    prefix2 = 6;
                                    suffix2 = 0;
                                    ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                                    $dirty3 &= rememberComposableLambda;
                                    obj6 = this_$iv;
                                }
                                if (i128 != 0) {
                                    obj20 = this_$iv;
                                }
                                placeholder2 = i59 != 0 ? 0 : placeholder;
                                leadingIcon2 = i11 != 0 ? 0 : leadingIcon;
                                trailingIcon2 = textStyle2 != 0 ? 0 : trailingIcon;
                                prefix2 = i65 != 0 ? 0 : prefix;
                                suffix2 = i45 != 0 ? 0 : suffix;
                                supportingText2 = i51 != 0 ? 0 : supportingText;
                                isError3 = i6 != 0 ? 0 : isError;
                                if (visualTransformation2 != 0) {
                                    visualTransformation2 = VisualTransformation.Companion.getNone();
                                } else {
                                    visualTransformation2 = visualTransformation;
                                }
                                if (keyboardOptions2 != 0) {
                                    keyboardOptions2 = KeyboardOptions.Companion.getDefault();
                                } else {
                                    keyboardOptions2 = keyboardOptions;
                                }
                                if (i116 != 0) {
                                    keyboardActions4 = KeyboardActions.Companion.getDefault();
                                } else {
                                    keyboardActions4 = keyboardActions;
                                }
                                singleLine3 = i118 != 0 ? 0 : singleLine;
                                if (i37 & i119 != 0) {
                                    maxLines2 = singleLine3 != 0 ? 1 : 0x7fffffff /* Unknown resource */;
                                    $dirty12 &= minLines2;
                                } else {
                                    maxLines2 = maxLines;
                                }
                                minLines3 = interactionSource2 != 0 ? 1 : minLines;
                                interactionSource3 = i36 != 0 ? 0 : interactionSource;
                                obj71 = placeholder2;
                                int placeholder4 = 6;
                                if (i37 & i124 != 0) {
                                    obj72 = leadingIcon2;
                                    leadingIcon4 = OutlinedTextFieldDefaults.INSTANCE.getShape(restartGroup, placeholder4);
                                    $dirty2 &= -113;
                                } else {
                                    obj72 = leadingIcon2;
                                    leadingIcon4 = shape;
                                }
                                if (i37 & i46 != 0) {
                                    obj12 = obj71;
                                    obj13 = obj72;
                                    i29 = obj73;
                                    $dirty2 = i94;
                                    i17 = trailingIcon2;
                                    i46 = prefix2;
                                    i59 = suffix2;
                                    i11 = supportingText2;
                                    i36 = visualTransformation2;
                                    i38 = minLines3;
                                    rememberedValue = interactionSource3;
                                    trailingIcon3 = colors4;
                                    colors2 = obj6;
                                    textStyle3 = obj20;
                                    label2 = isError3;
                                    minLines2 = singleLine3;
                                    interactionSource2 = maxLines2;
                                    isError2 = z;
                                    singleLine2 = keyboardOptions2;
                                    maxLines3 = keyboardActions4;
                                    readOnly3 = obj9;
                                } else {
                                    obj12 = obj71;
                                    obj13 = obj72;
                                    i29 = obj73;
                                    i17 = trailingIcon2;
                                    colors2 = obj6;
                                    i46 = prefix2;
                                    textStyle3 = obj20;
                                    i59 = suffix2;
                                    i11 = supportingText2;
                                    i36 = visualTransformation2;
                                    label2 = isError3;
                                    i38 = minLines3;
                                    rememberedValue = interactionSource3;
                                    trailingIcon3 = colors;
                                    isError2 = z;
                                    minLines2 = singleLine3;
                                    interactionSource2 = maxLines2;
                                    readOnly3 = obj9;
                                    singleLine2 = keyboardOptions2;
                                    maxLines3 = keyboardActions4;
                                }
                            } else {
                                restartGroup.skipToGroupEnd();
                                if (i37 & 32 != 0) {
                                    $dirty3 &= i4;
                                }
                                if (i81 &= i37 != 0) {
                                    $dirty12 &= i63;
                                }
                                if (i82 &= i37 != 0) {
                                    $dirty2 &= -113;
                                }
                                if (i37 & i46 != 0) {
                                    obj12 = placeholder;
                                    obj13 = leadingIcon;
                                    i17 = trailingIcon;
                                    i46 = prefix;
                                    i59 = suffix;
                                    i11 = supportingText;
                                    i36 = visualTransformation;
                                    singleLine2 = keyboardOptions;
                                    maxLines3 = keyboardActions;
                                    minLines2 = singleLine;
                                    interactionSource2 = maxLines;
                                    i38 = minLines;
                                    rememberedValue = interactionSource;
                                    i29 = shape;
                                    trailingIcon3 = colors;
                                    $dirty2 = i85;
                                    isError2 = z;
                                    colors2 = obj6;
                                    textStyle3 = obj20;
                                    label2 = isError;
                                    readOnly3 = obj9;
                                } else {
                                    obj12 = placeholder;
                                    obj13 = leadingIcon;
                                    i17 = trailingIcon;
                                    i46 = prefix;
                                    i59 = suffix;
                                    i11 = supportingText;
                                    i36 = visualTransformation;
                                    singleLine2 = keyboardOptions;
                                    maxLines3 = keyboardActions;
                                    minLines2 = singleLine;
                                    interactionSource2 = maxLines;
                                    i38 = minLines;
                                    rememberedValue = interactionSource;
                                    i29 = shape;
                                    trailingIcon3 = colors;
                                    isError2 = z;
                                    colors2 = obj6;
                                    textStyle3 = obj20;
                                    label2 = isError;
                                    readOnly3 = obj9;
                                }
                            }
                        } else {
                        }
                        restartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1570442800, $dirty3, $dirty12, "androidx.compose.material3.OutlinedTextField (OutlinedTextField.kt:368)");
                        }
                        restartGroup.startReplaceGroup(30368324);
                        ComposerKt.sourceInformation(restartGroup, "370@20325L39");
                        if (rememberedValue == 0) {
                            ComposerKt.sourceInformationMarkerStart(restartGroup, 30368975, "CC(remember):OutlinedTextField.kt#9igjgp");
                            str = 0;
                            prefix2 = restartGroup;
                            suffix2 = 0;
                            obj71 = rememberedValue;
                            rememberedValue = prefix2.rememberedValue();
                            supportingText2 = 0;
                            if (rememberedValue == Composer.Companion.getEmpty()) {
                                int i99 = 0;
                                prefix2.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                            } else {
                                i37 = rememberedValue;
                            }
                            ComposerKt.sourceInformationMarkerEnd(restartGroup);
                            i23 = i37;
                        } else {
                            i23 = obj71;
                        }
                        restartGroup.endReplaceGroup();
                        restartGroup.startReplaceGroup(30374434);
                        ComposerKt.sourceInformation(restartGroup, "*374@20549L25");
                        int i92 = 0;
                        i52 = 0;
                        booleanValue = Long.compare(textColor-XeAY9LY$material3_release, i133) != 0 ? 1 : 0;
                        if (booleanValue != 0) {
                        } else {
                            i52 = 0;
                            $this$takeOrElse_u2dDxMtmZc$iv = textColor-XeAY9LY$material3_release;
                        }
                        restartGroup.endReplaceGroup();
                        textStyle2 = new TextStyle($this$takeOrElse_u2dDxMtmZc$iv, i45, 0, i6, 0, 0, 0, 0, 0, 0, obj47, 0, 0, 0, 0, obj52, 0, 0, 0, 0, 0, 0, obj59, 0, 0, 0, 0, 0, 0, 16777214, 0);
                        int i97 = 0;
                        int i105 = 0;
                        ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        ComposerKt.sourceInformationMarkerEnd(restartGroup);
                        androidx.compose.material3.TextFieldColors field2 = trailingIcon3;
                        boolean z4 = obj21;
                        OutlinedTextFieldKt.OutlinedTextField.3 anon = new OutlinedTextFieldKt.OutlinedTextField.3(readOnly3, textStyle3, (Density)restartGroup.consume((CompositionLocal)CompositionLocalsKt.getLocalDensity()), label2, field2, obj8, onValueChange, z4, isError2, colors2.merge(textStyle2), singleLine2, maxLines3, minLines2, interactionSource2, i38, i36, i23, obj12, obj13, i17, i46, i59, i11, i29);
                        CompositionLocalKt.CompositionLocalProvider(TextSelectionColorsKt.getLocalTextSelectionColors().provides(trailingIcon3.getTextSelectionColors()), (Function2)ComposableLambdaKt.rememberComposableLambda(1830921872, true, anon, restartGroup, 54), restartGroup, $stable |= 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mergedTextStyle = obj71;
                        $composer4 = restartGroup;
                        i5 = $dirty3;
                        obj7 = readOnly3;
                        i24 = label2;
                        $composer3 = z4;
                        $dirty = isError2;
                        keyboardActions3 = maxLines3;
                        i57 = minLines2;
                        enabled2 = interactionSource2;
                        readOnly2 = i38;
                        isError4 = i36;
                        i41 = obj12;
                        i22 = obj13;
                        i58 = i17;
                        i56 = i46;
                        modifier2 = i59;
                        placeholder3 = $dirty12;
                        leadingIcon3 = $dirty2;
                        $dirty22 = textStyle3;
                        keyboardActions2 = field2;
                        colors3 = singleLine2;
                        label3 = i11;
                        keyboardOptions3 = i29;
                        $dirty1 = obj72;
                    } else {
                        restartGroup.skipToGroupEnd();
                        i41 = placeholder;
                        i56 = prefix;
                        i24 = isError;
                        colors3 = keyboardOptions;
                        keyboardActions3 = keyboardActions;
                        i57 = singleLine;
                        enabled2 = maxLines;
                        readOnly2 = minLines;
                        mergedTextStyle = interactionSource;
                        keyboardOptions3 = shape;
                        keyboardActions2 = colors;
                        $composer4 = restartGroup;
                        i5 = $dirty3;
                        placeholder3 = $dirty12;
                        leadingIcon3 = $dirty2;
                        obj7 = obj9;
                        $composer3 = obj21;
                        $dirty = z;
                        $dirty1 = obj6;
                        $dirty22 = obj20;
                        i22 = leadingIcon;
                        i58 = trailingIcon;
                        modifier2 = suffix;
                        label3 = supportingText;
                        isError4 = visualTransformation;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        endRestartGroup = $composer4.endRestartGroup();
        if (endRestartGroup != null) {
            $composer5 = composer;
            $composer4 = new OutlinedTextFieldKt.OutlinedTextField.4(value, onValueChange, obj7, $composer3, $dirty, $dirty1, $dirty22, i41, i22, i58, i56, modifier2, label3, i24, isError4, colors3, keyboardActions3, i57, enabled2, readOnly2, mergedTextStyle, keyboardOptions3, keyboardActions2, $changed, $changed1, $changed2, i28);
            endRestartGroup.updateScope((Function2)$composer4);
        } else {
            $composer5 = $composer4;
        }
    }

    public static final void OutlinedTextField(String value, Function1<? super String, Unit> onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> label, Function2<? super Composer, ? super Integer, Unit> placeholder, Function2<? super Composer, ? super Integer, Unit> leadingIcon, Function2<? super Composer, ? super Integer, Unit> trailingIcon, Function2<? super Composer, ? super Integer, Unit> prefix, Function2<? super Composer, ? super Integer, Unit> suffix, Function2<? super Composer, ? super Integer, Unit> supportingText, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, int minLines, MutableInteractionSource interactionSource, Shape shape, androidx.compose.material3.TextFieldColors colors, Composer $composer, int $changed, int $changed1, int $changed2, int i28) {
        Object obj2;
        Object obj10;
        Object obj;
        Object obj17;
        Object obj13;
        Object obj11;
        boolean z;
        Object obj16;
        Object obj3;
        Object obj7;
        boolean z2;
        int i14;
        int i22;
        Object obj5;
        Object obj18;
        Object obj20;
        int skipping;
        int i46;
        int i;
        Object colors3;
        int defaultsInvalid;
        int this_$iv;
        int placeholder3;
        Composer $composer4;
        int rememberComposableLambda;
        int rememberedValue;
        int leadingIcon3;
        Object leadingIcon2;
        ScopeUpdateScope endRestartGroup;
        Object trailingIcon2;
        int $composer2;
        int trailingIcon3;
        int i50;
        int i66;
        Object obj6;
        boolean $composer5;
        int $dirty;
        boolean $dirty3;
        int $dirty12;
        Object $dirty1;
        int $dirty2;
        Object $dirty22;
        Object obj19;
        int i13;
        Object obj15;
        boolean traceInProgress;
        String str;
        int booleanValue;
        int i65;
        boolean obj8;
        int i4;
        int i16;
        Object obj12;
        int i10;
        boolean z3;
        Object readOnly3;
        int modifier2;
        Object obj4;
        Object textStyle2;
        int label3;
        int i68;
        int prefix2;
        int i49;
        Object obj9;
        int label2;
        VisualTransformation isError4;
        int suffix2;
        long $this$takeOrElse_u2dDxMtmZc$iv;
        KeyboardOptions colors2;
        int i33;
        int supportingText2;
        KeyboardActions keyboardActions3;
        int i48;
        int visualTransformation2;
        long textColor-XeAY9LY$material3_release;
        int i3;
        int changed6;
        int keyboardOptions3;
        int enabled2;
        int i18;
        int changed2;
        boolean isError2;
        int isError3;
        int readOnly2;
        int i37;
        int keyboardActions4;
        int mergedTextStyle;
        int i59;
        Object singleLine2;
        int singleLine3;
        Shape keyboardOptions2;
        int i11;
        Object maxLines3;
        int maxLines2;
        androidx.compose.material3.TextFieldColors keyboardActions2;
        int minLines3;
        int minLines2;
        int i6;
        int i38;
        int i8;
        int changed4;
        int interactionSource3;
        int interactionSource2;
        int i39;
        int i51;
        Object i52;
        int changed;
        int i44;
        int i30;
        int changed5;
        int obj21;
        int placeholder2;
        int i67;
        int obj14;
        int leadingIcon4;
        int i12;
        int i9;
        Composer $composer3;
        int i45;
        int i42;
        int i47;
        int i55;
        int i26;
        Object i53;
        int textStyle3;
        int i56;
        int i54;
        int i35;
        int i60;
        int i36;
        int i57;
        int i63;
        int i5;
        boolean changed3;
        int i34;
        int i15;
        int i43;
        int i61;
        int i23;
        int i19;
        int i58;
        int i41;
        int i69;
        int i31;
        int i20;
        int i40;
        int i27;
        int i29;
        int i21;
        int i32;
        int i64;
        int i17;
        int i24;
        int i2;
        int i25;
        int i7;
        int i62;
        ScopeUpdateScope scopeUpdateScope;
        int obj71;
        int obj72;
        Shape obj73;
        int i70 = $changed;
        int i90 = $changed1;
        $composer2 = $changed2;
        i50 = i28;
        Composer restartGroup = $composer.startRestartGroup(-1922450045);
        ComposerKt.sourceInformation(restartGroup, "C(OutlinedTextField)P(21,11,10,1,14,19,6,12,7,20,13,17,18,3,22,5,4,16,8,9,2,15)175@9821L7,191@10625L5,192@10688L8,204@11208L7,206@11308L2853,206@11221L2940:OutlinedTextField.kt#uh7d8r");
        $dirty = $changed;
        $dirty12 = $changed1;
        $dirty2 = $changed2;
        if (i50 & 1 != 0) {
            $dirty |= 6;
            obj19 = value;
        } else {
            if (i70 & 6 == 0) {
                i16 = restartGroup.changed(value) ? 4 : 2;
                $dirty |= i16;
            } else {
                obj19 = value;
            }
        }
        if (i50 & 2 != 0) {
            $dirty |= 48;
            obj12 = onValueChange;
        } else {
            if (i70 & 48 == 0) {
                i68 = restartGroup.changedInstance(onValueChange) ? 32 : 16;
                $dirty |= i68;
            } else {
                obj12 = onValueChange;
            }
        }
        prefix2 = i50 & 4;
        int i113 = 128;
        if (prefix2 != 0) {
            $dirty |= 384;
            obj15 = modifier;
        } else {
            if (i70 & 384 == 0) {
                i33 = restartGroup.changed(modifier) ? 256 : i113;
                $dirty |= i33;
            } else {
                obj15 = modifier;
            }
        }
        supportingText2 = i50 & 8;
        changed6 = 1024;
        if (supportingText2 != 0) {
            $dirty |= 3072;
            obj8 = enabled;
        } else {
            if (i70 & 3072 == 0) {
                i37 = restartGroup.changed(enabled) ? i48 : changed6;
                $dirty |= i37;
            } else {
                obj8 = enabled;
            }
        }
        keyboardActions4 = i50 & 16;
        i11 = 8192;
        if (keyboardActions4 != 0) {
            $dirty |= 24576;
            z3 = readOnly;
        } else {
            if (i70 & 24576 == 0) {
                i6 = restartGroup.changed(readOnly) ? i59 : i11;
                $dirty |= i6;
            } else {
                z3 = readOnly;
            }
        }
        i38 = 196608;
        i51 = 65536;
        if (i70 & i38 == 0) {
            if (i50 & 32 == 0) {
                changed = restartGroup.changed(textStyle) ? 131072 : i51;
            } else {
                obj4 = textStyle;
            }
            $dirty |= changed;
        } else {
            obj4 = textStyle;
        }
        int i128 = i50 & 64;
        changed5 = 1572864;
        if (i128 != 0) {
            $dirty |= changed5;
            obj9 = label;
        } else {
            if (i70 & changed5 == 0) {
                i12 = restartGroup.changedInstance(label) ? 1048576 : 524288;
                $dirty |= i12;
            } else {
                obj9 = label;
            }
        }
        int i71 = i50 & 128;
        i9 = 12582912;
        i45 = 4194304;
        if (i71 != 0) {
            $dirty |= i9;
            i42 = i71;
            obj2 = placeholder;
        } else {
            if ($changed & i9 == 0) {
                i42 = i71;
                i47 = restartGroup.changedInstance(placeholder) ? 8388608 : i45;
                $dirty |= i47;
            } else {
                i42 = i71;
                obj2 = placeholder;
            }
        }
        int i72 = i50 & 256;
        int i130 = 100663296;
        if (i72 != 0) {
            $dirty |= i130;
            i55 = i72;
            obj10 = leadingIcon;
        } else {
            if ($changed & i130 == 0) {
                i55 = i72;
                i26 = restartGroup.changedInstance(leadingIcon) ? 67108864 : 33554432;
                $dirty |= i26;
            } else {
                i55 = i72;
                obj10 = leadingIcon;
            }
        }
        int i73 = i50 & 512;
        i53 = 805306368;
        if (i73 != 0) {
            $dirty |= i53;
            textStyle3 = i73;
            obj = trailingIcon;
        } else {
            if ($changed & i53 == 0) {
                textStyle3 = i73;
                i56 = restartGroup.changedInstance(trailingIcon) ? 536870912 : 268435456;
                $dirty |= i56;
            } else {
                textStyle3 = i73;
                obj = trailingIcon;
            }
        }
        int i74 = i50 & 1024;
        if (i74 != 0) {
            $dirty12 |= 6;
            i54 = i74;
            obj17 = prefix;
        } else {
            if (i90 & 6 == 0) {
                i54 = i74;
                i35 = restartGroup.changedInstance(prefix) ? 4 : 2;
                $dirty12 |= i35;
            } else {
                i54 = i74;
                obj17 = prefix;
            }
        }
        int i75 = i50 & 2048;
        if (i75 != 0) {
            $dirty12 |= 48;
            i60 = i75;
            obj13 = suffix;
        } else {
            if (i90 & 48 == 0) {
                i60 = i75;
                i36 = restartGroup.changedInstance(suffix) ? 32 : 16;
                $dirty12 |= i36;
            } else {
                i60 = i75;
                obj13 = suffix;
            }
        }
        int i76 = i50 & 4096;
        if (i76 != 0) {
            $dirty12 |= 384;
            i57 = i76;
            obj11 = supportingText;
        } else {
            i57 = i76;
            if (i90 & 384 == 0) {
                i63 = restartGroup.changedInstance(supportingText) ? 256 : i113;
                $dirty12 |= i63;
            } else {
                obj11 = supportingText;
            }
        }
        int i78 = i50 & 8192;
        if (i78 != 0) {
            $dirty12 |= 3072;
            i5 = i78;
            z = isError;
        } else {
            i5 = i78;
            if (i90 & 3072 == 0) {
                if (restartGroup.changed(isError)) {
                } else {
                    i48 = changed6;
                }
                $dirty12 |= i48;
            } else {
                z = isError;
            }
        }
        int i79 = i50 & 16384;
        if (i79 != 0) {
            $dirty12 |= 24576;
            visualTransformation2 = i79;
            obj16 = visualTransformation;
        } else {
            visualTransformation2 = i79;
            if (i90 & 24576 == 0) {
                if (restartGroup.changed(visualTransformation)) {
                } else {
                    i59 = i11;
                }
                $dirty12 |= i59;
            } else {
                obj16 = visualTransformation;
            }
        }
        keyboardOptions3 = i50 & i114;
        if (keyboardOptions3 != 0) {
            $dirty12 |= i38;
            obj3 = keyboardOptions;
        } else {
            if (i90 & i38 == 0) {
                i59 = restartGroup.changed(keyboardOptions) ? 131072 : i51;
                $dirty12 |= i59;
            } else {
                obj3 = keyboardOptions;
            }
        }
        int i116 = i50 & i51;
        if (i116 != 0) {
            $dirty12 |= changed5;
            obj7 = keyboardActions;
        } else {
            if (i90 & changed5 == 0) {
                i11 = restartGroup.changed(keyboardActions) ? 1048576 : 524288;
                $dirty12 |= i11;
            } else {
                obj7 = keyboardActions;
            }
        }
        int i118 = i50 & i117;
        if (i118 != 0) {
            $dirty12 |= i9;
            z2 = singleLine;
        } else {
            if (i90 & i9 == 0) {
                i38 = restartGroup.changed(singleLine) ? 8388608 : i45;
                $dirty12 |= i38;
            } else {
                z2 = singleLine;
            }
        }
        if (i90 & i121 == 0) {
            if (i50 & i122 == 0) {
                i8 = restartGroup.changed(maxLines) ? 67108864 : 33554432;
            } else {
                i14 = maxLines;
            }
            $dirty12 |= i8;
        } else {
            i14 = maxLines;
        }
        interactionSource3 = i50 & i123;
        if (interactionSource3 != 0) {
            $dirty12 |= i53;
            i22 = minLines;
        } else {
            if (i90 & i53 == 0) {
                i51 = restartGroup.changed(minLines) ? 536870912 : 268435456;
                $dirty12 |= i51;
            } else {
                i22 = minLines;
            }
        }
        i52 = i50 & i127;
        if (i52 != 0) {
            $dirty2 |= 6;
            obj5 = interactionSource;
        } else {
            if ($composer2 & 6 == 0) {
                i18 = restartGroup.changed(interactionSource) ? 4 : 2;
                $dirty2 |= i18;
            } else {
                obj5 = interactionSource;
            }
        }
        if ($composer2 & 48 == 0) {
            if (i50 & i115 == 0) {
                minLines3 = restartGroup.changed(shape) ? 32 : 16;
            } else {
                obj18 = shape;
            }
            $dirty2 |= minLines3;
        } else {
            obj18 = shape;
        }
        if ($composer2 & 384 == 0) {
            if (i50 & i45 == 0) {
                i67 = restartGroup.changed(colors) ? 256 : i113;
            } else {
                obj20 = colors;
            }
            $dirty2 |= i67;
        } else {
            obj20 = colors;
        }
        if ($dirty & suffix2 == 306783378 && i86 &= $dirty12 == 306783378 && $dirty2 & 147 == 146) {
            if (i86 &= $dirty12 == 306783378) {
                if ($dirty2 & 147 == 146) {
                    if (!restartGroup.getSkipping()) {
                        restartGroup.startDefaults();
                        if ($changed & 1 != 0) {
                            if (restartGroup.getDefaultsInvalid()) {
                                if (prefix2 != 0) {
                                    obj15 = defaultsInvalid;
                                }
                                if (supportingText2 != 0) {
                                    obj8 = defaultsInvalid;
                                }
                                if (keyboardActions4 != 0) {
                                    z3 = defaultsInvalid;
                                }
                                if (i50 & 32 != 0) {
                                    prefix2 = 6;
                                    suffix2 = 0;
                                    ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                                    $dirty &= rememberComposableLambda;
                                    obj4 = this_$iv;
                                }
                                if (i128 != 0) {
                                    obj9 = this_$iv;
                                }
                                placeholder3 = i42 != 0 ? 0 : placeholder;
                                leadingIcon3 = i55 != 0 ? 0 : leadingIcon;
                                trailingIcon3 = textStyle3 != 0 ? 0 : trailingIcon;
                                prefix2 = i54 != 0 ? 0 : prefix;
                                suffix2 = i60 != 0 ? 0 : suffix;
                                supportingText2 = i57 != 0 ? 0 : supportingText;
                                isError3 = i5 != 0 ? 0 : isError;
                                if (visualTransformation2 != 0) {
                                    visualTransformation2 = VisualTransformation.Companion.getNone();
                                } else {
                                    visualTransformation2 = visualTransformation;
                                }
                                if (keyboardOptions3 != 0) {
                                    keyboardOptions3 = KeyboardOptions.Companion.getDefault();
                                } else {
                                    keyboardOptions3 = keyboardOptions;
                                }
                                if (i116 != 0) {
                                    keyboardActions4 = KeyboardActions.Companion.getDefault();
                                } else {
                                    keyboardActions4 = keyboardActions;
                                }
                                singleLine3 = i118 != 0 ? 0 : singleLine;
                                if (i50 & i119 != 0) {
                                    maxLines2 = singleLine3 != 0 ? 1 : 0x7fffffff /* Unknown resource */;
                                    $dirty12 &= minLines3;
                                } else {
                                    maxLines2 = maxLines;
                                }
                                minLines2 = interactionSource3 != 0 ? 1 : minLines;
                                interactionSource2 = i52 != 0 ? 0 : interactionSource;
                                obj71 = placeholder3;
                                int placeholder4 = 6;
                                if (i50 & i124 != 0) {
                                    obj72 = leadingIcon3;
                                    leadingIcon2 = OutlinedTextFieldDefaults.INSTANCE.getShape(restartGroup, placeholder4);
                                    $dirty2 &= -113;
                                } else {
                                    obj72 = leadingIcon3;
                                    leadingIcon2 = shape;
                                }
                                if (i50 & i45 != 0) {
                                    obj21 = obj71;
                                    obj14 = obj72;
                                    i53 = obj73;
                                    $dirty2 = i94;
                                    i9 = trailingIcon3;
                                    i45 = prefix2;
                                    i42 = suffix2;
                                    i55 = supportingText2;
                                    i52 = visualTransformation2;
                                    i39 = minLines2;
                                    rememberedValue = interactionSource2;
                                    trailingIcon2 = colors4;
                                    colors3 = obj4;
                                    textStyle2 = obj9;
                                    label2 = isError3;
                                    minLines3 = singleLine3;
                                    interactionSource3 = maxLines2;
                                    isError2 = z3;
                                    singleLine2 = keyboardOptions3;
                                    maxLines3 = keyboardActions4;
                                    readOnly3 = obj15;
                                } else {
                                    obj21 = obj71;
                                    obj14 = obj72;
                                    i53 = obj73;
                                    i9 = trailingIcon3;
                                    colors3 = obj4;
                                    i45 = prefix2;
                                    textStyle2 = obj9;
                                    i42 = suffix2;
                                    i55 = supportingText2;
                                    i52 = visualTransformation2;
                                    label2 = isError3;
                                    i39 = minLines2;
                                    rememberedValue = interactionSource2;
                                    trailingIcon2 = colors;
                                    isError2 = z3;
                                    minLines3 = singleLine3;
                                    interactionSource3 = maxLines2;
                                    readOnly3 = obj15;
                                    singleLine2 = keyboardOptions3;
                                    maxLines3 = keyboardActions4;
                                }
                            } else {
                                restartGroup.skipToGroupEnd();
                                if (i50 & 32 != 0) {
                                    $dirty &= i46;
                                }
                                if (i81 &= i50 != 0) {
                                    $dirty12 &= i;
                                }
                                if (i82 &= i50 != 0) {
                                    $dirty2 &= -113;
                                }
                                if (i50 & i45 != 0) {
                                    obj21 = placeholder;
                                    obj14 = leadingIcon;
                                    i9 = trailingIcon;
                                    i45 = prefix;
                                    i42 = suffix;
                                    i55 = supportingText;
                                    i52 = visualTransformation;
                                    singleLine2 = keyboardOptions;
                                    maxLines3 = keyboardActions;
                                    minLines3 = singleLine;
                                    interactionSource3 = maxLines;
                                    i39 = minLines;
                                    rememberedValue = interactionSource;
                                    i53 = shape;
                                    trailingIcon2 = colors;
                                    $dirty2 = i85;
                                    isError2 = z3;
                                    colors3 = obj4;
                                    textStyle2 = obj9;
                                    label2 = isError;
                                    readOnly3 = obj15;
                                } else {
                                    obj21 = placeholder;
                                    obj14 = leadingIcon;
                                    i9 = trailingIcon;
                                    i45 = prefix;
                                    i42 = suffix;
                                    i55 = supportingText;
                                    i52 = visualTransformation;
                                    singleLine2 = keyboardOptions;
                                    maxLines3 = keyboardActions;
                                    minLines3 = singleLine;
                                    interactionSource3 = maxLines;
                                    i39 = minLines;
                                    rememberedValue = interactionSource;
                                    i53 = shape;
                                    trailingIcon2 = colors;
                                    isError2 = z3;
                                    colors3 = obj4;
                                    textStyle2 = obj9;
                                    label2 = isError;
                                    readOnly3 = obj15;
                                }
                            }
                        } else {
                        }
                        restartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1922450045, $dirty, $dirty12, "androidx.compose.material3.OutlinedTextField (OutlinedTextField.kt:193)");
                        }
                        restartGroup.startReplaceGroup(30062948);
                        ComposerKt.sourceInformation(restartGroup, "195@10782L39");
                        if (rememberedValue == 0) {
                            ComposerKt.sourceInformationMarkerStart(restartGroup, 30063599, "CC(remember):OutlinedTextField.kt#9igjgp");
                            str = 0;
                            prefix2 = restartGroup;
                            suffix2 = 0;
                            obj71 = rememberedValue;
                            rememberedValue = prefix2.rememberedValue();
                            supportingText2 = 0;
                            if (rememberedValue == Composer.Companion.getEmpty()) {
                                int i99 = 0;
                                prefix2.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                            } else {
                                i50 = rememberedValue;
                            }
                            ComposerKt.sourceInformationMarkerEnd(restartGroup);
                            i44 = i50;
                        } else {
                            i44 = obj71;
                        }
                        restartGroup.endReplaceGroup();
                        restartGroup.startReplaceGroup(30069058);
                        ComposerKt.sourceInformation(restartGroup, "*199@11006L25");
                        int i92 = 0;
                        i66 = 0;
                        booleanValue = Long.compare(textColor-XeAY9LY$material3_release, i133) != 0 ? 1 : 0;
                        if (booleanValue != 0) {
                        } else {
                            i66 = 0;
                            $this$takeOrElse_u2dDxMtmZc$iv = textColor-XeAY9LY$material3_release;
                        }
                        restartGroup.endReplaceGroup();
                        textStyle3 = new TextStyle($this$takeOrElse_u2dDxMtmZc$iv, i60, 0, i5, 0, 0, 0, 0, 0, 0, obj47, 0, 0, 0, 0, obj52, 0, 0, 0, 0, 0, 0, obj59, 0, 0, 0, 0, 0, 0, 16777214, 0);
                        int i97 = 0;
                        int i105 = 0;
                        ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        ComposerKt.sourceInformationMarkerEnd(restartGroup);
                        androidx.compose.material3.TextFieldColors field = trailingIcon2;
                        boolean z4 = obj8;
                        OutlinedTextFieldKt.OutlinedTextField.1 anon = new OutlinedTextFieldKt.OutlinedTextField.1(readOnly3, textStyle2, (Density)restartGroup.consume((CompositionLocal)CompositionLocalsKt.getLocalDensity()), label2, field, obj19, onValueChange, z4, isError2, colors3.merge(textStyle3), singleLine2, maxLines3, minLines3, interactionSource3, i39, i52, i44, obj21, obj14, i9, i45, i42, i55, i53);
                        CompositionLocalKt.CompositionLocalProvider(TextSelectionColorsKt.getLocalTextSelectionColors().provides(trailingIcon2.getTextSelectionColors()), (Function2)ComposableLambdaKt.rememberComposableLambda(-1886965181, true, anon, restartGroup, 54), restartGroup, $stable |= 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mergedTextStyle = obj71;
                        $composer4 = restartGroup;
                        i30 = $dirty;
                        obj6 = readOnly3;
                        i49 = label2;
                        $composer5 = z4;
                        $dirty3 = isError2;
                        keyboardActions3 = maxLines3;
                        i3 = minLines3;
                        enabled2 = interactionSource3;
                        readOnly2 = i39;
                        isError4 = i52;
                        i13 = obj21;
                        i65 = obj14;
                        i4 = i9;
                        i10 = i45;
                        modifier2 = i42;
                        placeholder2 = $dirty12;
                        leadingIcon4 = $dirty2;
                        $dirty22 = textStyle2;
                        keyboardActions2 = field;
                        colors2 = singleLine2;
                        label3 = i55;
                        keyboardOptions2 = i53;
                        $dirty1 = obj72;
                    } else {
                        restartGroup.skipToGroupEnd();
                        i13 = placeholder;
                        i10 = prefix;
                        i49 = isError;
                        colors2 = keyboardOptions;
                        keyboardActions3 = keyboardActions;
                        i3 = singleLine;
                        enabled2 = maxLines;
                        readOnly2 = minLines;
                        mergedTextStyle = interactionSource;
                        keyboardOptions2 = shape;
                        keyboardActions2 = colors;
                        $composer4 = restartGroup;
                        i30 = $dirty;
                        placeholder2 = $dirty12;
                        leadingIcon4 = $dirty2;
                        obj6 = obj15;
                        $composer5 = obj8;
                        $dirty3 = z3;
                        $dirty1 = obj4;
                        $dirty22 = obj9;
                        i65 = leadingIcon;
                        i4 = trailingIcon;
                        modifier2 = suffix;
                        label3 = supportingText;
                        isError4 = visualTransformation;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        endRestartGroup = $composer4.endRestartGroup();
        if (endRestartGroup != null) {
            $composer3 = composer;
            $composer4 = new OutlinedTextFieldKt.OutlinedTextField.2(value, onValueChange, obj6, $composer5, $dirty3, $dirty1, $dirty22, i13, i65, i4, i10, modifier2, label3, i49, isError4, colors2, keyboardActions3, i3, enabled2, readOnly2, mergedTextStyle, keyboardOptions2, keyboardActions2, $changed, $changed1, $changed2, i28);
            endRestartGroup.updateScope((Function2)$composer4);
        } else {
            $composer3 = $composer4;
        }
    }

    public static final void OutlinedTextFieldLayout(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> textField, Function3<? super Modifier, ? super Composer, ? super Integer, Unit> placeholder, Function2<? super Composer, ? super Integer, Unit> label, Function2<? super Composer, ? super Integer, Unit> leading, Function2<? super Composer, ? super Integer, Unit> trailing, Function2<? super Composer, ? super Integer, Unit> prefix, Function2<? super Composer, ? super Integer, Unit> suffix, boolean singleLine, float animationProgress, Function1<? super Size, Unit> onLabelMeasured, Function2<? super Composer, ? super Integer, Unit> container, Function2<? super Composer, ? super Integer, Unit> supporting, PaddingValues paddingValues, Composer $composer, int $changed, int $changed1) {
        int traceInProgress2;
        Object endRestartGroup;
        int i31;
        Object it$iv;
        Object valueOf2;
        Function0 factory$iv$iv$iv3;
        Object valueOf4;
        int heightIn-VpY3zN4$default;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap4;
        Object valueOf;
        Object valueOf6;
        Function0 factory$iv$iv$iv4;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv5;
        Object obj4;
        Function0 factory$iv$iv;
        boolean valueOf10;
        boolean traceInProgress;
        int i21;
        int i19;
        int i25;
        Integer currentCompositionLocalMap6;
        Object valueOf9;
        Function0 factory$iv$iv$iv6;
        Object valueOf8;
        String $composer$iv;
        boolean currentCompositionLocalMap3;
        int i8;
        Object then;
        Function0 factory$iv$iv$iv7;
        Composer composer11;
        Integer currentCompositionLocalMap;
        boolean maybeCachedBoxMeasurePolicy3;
        int $i$f$Layout;
        int $i$f$cache;
        Object $composer$iv2;
        Integer currentCompositionLocalMap2;
        Composer materialized$iv$iv;
        float constructor-impl2;
        Composer composer;
        Object currentCompositionLocalMap5;
        Object materializeModifier;
        Object obj2;
        Object iNSTANCE;
        Composer composer5;
        int valueOf7;
        Composer composer9;
        Composer composer2;
        Object topStart;
        boolean maybeCachedBoxMeasurePolicy;
        Object materialized$iv$iv2;
        float $this$coerceAtLeast_u2dYgX7TsA$iv;
        float $this$coerceAtLeast_u2dYgX7TsA$iv2;
        float constructor-impl;
        Function0 factory$iv$iv$iv2;
        float $this$dp$iv;
        int maybeCachedBoxMeasurePolicy5;
        Integer maybeCachedBoxMeasurePolicy2;
        Object iNSTANCE2;
        Object maybeCachedBoxMeasurePolicy4;
        Composer composer3;
        int valueOf5;
        int i17;
        Composer composer8;
        Object currentCompositionLocalMap7;
        Composer restartGroup;
        Modifier maybeCachedBoxMeasurePolicy6;
        int i9;
        int i13;
        int i29;
        int i14;
        int i16;
        int i15;
        int i26;
        int str;
        Composer composer10;
        int valueOf3;
        Object obj6;
        Object obj3;
        int $dirty12;
        int $dirty1;
        int $dirty;
        int $dirty2;
        int i2;
        int i27;
        int i10;
        int i33;
        int i22;
        androidx.compose.material3.OutlinedTextFieldMeasurePolicy field;
        int companion;
        Object obj5;
        Modifier $i$f$cache2;
        int currentCompositeKeyHash3;
        int i32;
        Function0 function0;
        int i;
        Composer composer4;
        int i18;
        Composer composer12;
        int companion2;
        int i5;
        int i28;
        androidx.compose.runtime.CompositionLocalMap localMap$iv;
        Modifier modifier2;
        int i3;
        int i23;
        Function0 function03;
        int layoutDirection;
        int i30;
        int currentCompositeKeyHash;
        int i11;
        Object obj;
        int currentCompositeKeyHash4;
        float f;
        int $composer2;
        Composer $composer3;
        int i24;
        int currentCompositeKeyHash2;
        float f2;
        Modifier modifier3;
        Function0 function02;
        int i12;
        int i7;
        Composer composer7;
        int localMap$iv$iv3;
        int i6;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy$iv;
        androidx.compose.runtime.CompositionLocalMap map;
        Object iNSTANCE3;
        int localMap$iv$iv;
        androidx.compose.ui.layout.MeasurePolicy localMap$iv$iv2;
        androidx.compose.runtime.CompositionLocalMap map2;
        Composer composer6;
        int i20;
        int i4;
        ScopeUpdateScope scopeUpdateScope;
        int obj76;
        Object obj7 = modifier;
        $composer$iv2 = leading;
        materializeModifier = trailing;
        iNSTANCE = prefix;
        final Object obj11 = suffix;
        maybeCachedBoxMeasurePolicy = singleLine;
        $this$dp$iv = animationProgress;
        iNSTANCE2 = onLabelMeasured;
        maybeCachedBoxMeasurePolicy4 = container;
        int i186 = $changed;
        int i34 = $changed1;
        restartGroup = $composer.startRestartGroup(1408290209);
        ComposerKt.sourceInformation(restartGroup, "C(OutlinedTextFieldLayout)P(4,12,7,2,3,13,8,10,9!1,5!1,11)470@24558L267,478@24873L7,479@24885L3739:OutlinedTextField.kt#uh7d8r");
        obj76 = i176;
        if (i186 & 6 == 0) {
            i27 = restartGroup.changed(obj7) ? 4 : 2;
            $dirty = obj76 | i27;
        } else {
            $dirty = obj76;
        }
        if (i186 & 48 == 0) {
            i33 = restartGroup.changedInstance(textField) ? 32 : 16;
            $dirty |= i33;
        }
        if (i186 & 384 == 0) {
            i9 = restartGroup.changedInstance(placeholder) ? 256 : 128;
            $dirty |= i9;
        }
        if (i186 & 3072 == 0) {
            i22 = restartGroup.changedInstance(label) ? 2048 : 1024;
            $dirty |= i22;
        }
        if (i186 & 24576 == 0) {
            i13 = restartGroup.changedInstance($composer$iv2) ? 16384 : 8192;
            $dirty |= i13;
        }
        if (i178 &= i186 == 0) {
            i29 = restartGroup.changedInstance(materializeModifier) ? 131072 : 65536;
            $dirty |= i29;
        }
        if (i179 &= i186 == 0) {
            i14 = restartGroup.changedInstance(iNSTANCE) ? 1048576 : 524288;
            $dirty |= i14;
        }
        if (i180 &= i186 == 0) {
            i16 = restartGroup.changedInstance(obj11) ? 8388608 : 4194304;
            $dirty |= i16;
        }
        if (i181 &= i186 == 0) {
            i15 = restartGroup.changed(maybeCachedBoxMeasurePolicy) ? 67108864 : 33554432;
            $dirty |= i15;
        }
        if (i182 &= i186 == 0) {
            i26 = restartGroup.changed($this$dp$iv) ? 536870912 : 268435456;
            $dirty |= i26;
        }
        str = $dirty;
        if (i34 & 6 == 0) {
            $dirty2 = restartGroup.changedInstance(iNSTANCE2) ? 4 : 2;
            $dirty12 |= $dirty2;
        }
        if (i34 & 48 == 0) {
            i2 = restartGroup.changedInstance(maybeCachedBoxMeasurePolicy4) ? 32 : 16;
            $dirty12 |= i2;
        }
        if (i34 & 384 == 0) {
            i2 = restartGroup.changedInstance(supporting) ? 256 : 128;
            $dirty12 |= i2;
        } else {
            obj6 = supporting;
        }
        if (i34 & 3072 == 0) {
            i2 = restartGroup.changed(paddingValues) ? 2048 : 1024;
            $dirty12 |= i2;
        } else {
            obj3 = paddingValues;
        }
        traceInProgress2 = $dirty12;
        if (str & $dirty1 == 306783378 && traceInProgress2 & 1171 == 1170) {
            if (traceInProgress2 & 1171 == 1170) {
                if (!restartGroup.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1408290209, str, traceInProgress2, "androidx.compose.material3.OutlinedTextFieldLayout (OutlinedTextField.kt:468)");
                    }
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 602705309, "CC(remember):OutlinedTextField.kt#9igjgp");
                    int i189 = 1;
                    i21 = traceInProgress2 & 14 == 4 ? i189 : 0;
                    i19 = i109 &= str == 67108864 ? i189 : 0;
                    i25 = i111 &= str == 536870912 ? i189 : 0;
                    i10 = traceInProgress2;
                    i31 = traceInProgress2 & 7168 == 2048 ? i189 : 0;
                    Composer composer13 = restartGroup;
                    $i$f$cache = 0;
                    it$iv = composer13.rememberedValue();
                    int i196 = 0;
                    if (i31 |= i83 == 0) {
                        $i$f$cache2 = $i$f$cache;
                        if (it$iv == Composer.Companion.getEmpty()) {
                            $i$f$cache = 0;
                            obj5 = it$iv;
                            it$iv = new OutlinedTextFieldMeasurePolicy(iNSTANCE2, maybeCachedBoxMeasurePolicy, $this$dp$iv, obj3);
                            composer13.updateRememberedValue(it$iv);
                        } else {
                            obj5 = it$iv;
                        }
                    } else {
                        $i$f$cache2 = $i$f$cache;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    int i195 = 0;
                    int i197 = i114;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    valueOf2 = restartGroup.consume((CompositionLocal)CompositionLocalsKt.getLocalLayoutDirection());
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    companion = i115;
                    $i$f$Layout = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, $i$f$Layout);
                    currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, 0);
                    currentCompositionLocalMap6 = restartGroup.getCurrentCompositionLocalMap();
                    materialized$iv$iv2 = ComposedModifierKt.materializeModifier(restartGroup, obj7);
                    Function0 function04 = constructor2;
                    i32 = 0;
                    iNSTANCE2 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp";
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, iNSTANCE2);
                    if (!applier5 instanceof Applier) {
                        ComposablesKt.invalidApplier();
                    }
                    restartGroup.startReusableNode();
                    if (restartGroup.getInserting()) {
                        restartGroup.createNode(function04);
                    } else {
                        factory$iv$iv = function04;
                        restartGroup.useNode();
                    }
                    function0 = factory$iv$iv;
                    Composer constructor-impl6 = Updater.constructor-impl(restartGroup);
                    int i199 = 0;
                    composer12 = restartGroup;
                    i5 = str;
                    Updater.set-impl(constructor-impl6, (MeasurePolicy)(OutlinedTextFieldMeasurePolicy)it$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl6, currentCompositionLocalMap6, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    valueOf3 = 0;
                    Composer composer20 = constructor-impl6;
                    i28 = 0;
                    if (!composer20.getInserting()) {
                        localMap$iv = currentCompositionLocalMap6;
                        i3 = valueOf3;
                        if (!Intrinsics.areEqual(composer20.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                            composer20.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                            constructor-impl6.apply(Integer.valueOf(currentCompositeKeyHash3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer10 = composer20;
                        }
                    } else {
                        localMap$iv = currentCompositionLocalMap6;
                        i3 = valueOf3;
                    }
                    Updater.set-impl(constructor-impl6, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                    valueOf10 = composer12;
                    maybeCachedBoxMeasurePolicy6 = 0;
                    i18 = i73;
                    ComposerKt.sourceInformationMarkerStart(valueOf10, -828374317, "C482@24954L11,550@27430L186:OutlinedTextField.kt#uh7d8r");
                    maybeCachedBoxMeasurePolicy4.invoke(valueOf10, Integer.valueOf(i74 &= 14));
                    valueOf10.startReplaceGroup(250370369);
                    ComposerKt.sourceInformation(valueOf10, "485@25018L219");
                    str = "C73@3429L9:Box.kt#2w3rfo";
                    companion2 = 48;
                    String str3 = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo";
                    modifier2 = materialized$iv$iv2;
                    if ($composer$iv2 != null) {
                        Modifier then4 = LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Leading").then(TextFieldImplKt.getIconDefaultSizeModifier());
                        Alignment center2 = Alignment.Companion.getCenter();
                        i23 = companion2;
                        layoutDirection = 0;
                        i30 = maybeCachedBoxMeasurePolicy6;
                        ComposerKt.sourceInformationMarkerStart(valueOf10, 733328855, str3);
                        int i174 = 0;
                        maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center2, i174);
                        i11 = 0;
                        obj = center2;
                        ComposerKt.sourceInformationMarkerStart(valueOf10, -1323940314, $i$f$Layout);
                        currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(valueOf10, 0);
                        currentCompositionLocalMap7 = valueOf10.getCurrentCompositionLocalMap();
                        $composer2 = i174;
                        modifier3 = then4;
                        Function0 function010 = constructor7;
                        currentCompositeKeyHash2 = 0;
                        ComposerKt.sourceInformationMarkerStart(valueOf10, -692256719, iNSTANCE2);
                        if (!applier8 instanceof Applier) {
                            ComposablesKt.invalidApplier();
                        }
                        valueOf10.startReusableNode();
                        if (valueOf10.getInserting()) {
                            valueOf10.createNode(function010);
                        } else {
                            factory$iv$iv$iv2 = function010;
                            valueOf10.useNode();
                        }
                        function02 = factory$iv$iv$iv2;
                        Composer constructor-impl9 = Updater.constructor-impl(valueOf10);
                        int i221 = 0;
                        Updater.set-impl(constructor-impl9, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(constructor-impl9, currentCompositionLocalMap7, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        int i225 = 0;
                        Composer composer23 = constructor-impl9;
                        int i241 = 0;
                        if (!composer23.getInserting()) {
                            measurePolicy$iv = maybeCachedBoxMeasurePolicy2;
                            map = currentCompositionLocalMap7;
                            if (!Intrinsics.areEqual(composer23.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                                composer23.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                                constructor-impl9.apply(Integer.valueOf(currentCompositeKeyHash4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            } else {
                                composer8 = composer23;
                            }
                        } else {
                            measurePolicy$iv = maybeCachedBoxMeasurePolicy2;
                            map = currentCompositionLocalMap7;
                        }
                        Updater.set-impl(constructor-impl9, ComposedModifierKt.materializeModifier(valueOf10, then4), ComposeUiNode.Companion.getSetModifier());
                        Composer composer19 = valueOf10;
                        ComposerKt.sourceInformationMarkerStart(composer19, -2146769399, str);
                        maybeCachedBoxMeasurePolicy4 = BoxScopeInstance.INSTANCE;
                        i223 |= 6;
                        localMap$iv$iv3 = 0;
                        i6 = i105;
                        localMap$iv$iv = i152;
                        $this$dp$iv = composer7;
                        ComposerKt.sourceInformationMarkerStart($this$dp$iv, -367907446, "C489@25210L9:OutlinedTextField.kt#uh7d8r");
                        $composer$iv2.invoke($this$dp$iv, Integer.valueOf(i106 &= 14));
                        ComposerKt.sourceInformationMarkerEnd($this$dp$iv);
                        ComposerKt.sourceInformationMarkerEnd(composer19);
                        valueOf10.endNode();
                        ComposerKt.sourceInformationMarkerEnd(valueOf10);
                        ComposerKt.sourceInformationMarkerEnd(valueOf10);
                        ComposerKt.sourceInformationMarkerEnd(valueOf10);
                    } else {
                        i30 = maybeCachedBoxMeasurePolicy6;
                    }
                    valueOf10.endReplaceGroup();
                    valueOf10.startReplaceGroup(250379492);
                    ComposerKt.sourceInformation(valueOf10, "493@25304L221");
                    Modifier then2 = LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Trailing").then(TextFieldImplKt.getIconDefaultSizeModifier());
                    Alignment center = Alignment.Companion.getCenter();
                    ComposerKt.sourceInformationMarkerStart(valueOf10, 733328855, str3);
                    valueOf5 = 0;
                    layoutDirection = 0;
                    ComposerKt.sourceInformationMarkerStart(valueOf10, -1323940314, $i$f$Layout);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(valueOf10, 0);
                    currentCompositionLocalMap2 = valueOf10.getCurrentCompositionLocalMap();
                    i11 = center;
                    Modifier materializeModifier6 = ComposedModifierKt.materializeModifier(valueOf10, then2);
                    currentCompositeKeyHash4 = then2;
                    Function0 function06 = constructor3;
                    obj = 0;
                    ComposerKt.sourceInformationMarkerStart(valueOf10, -692256719, iNSTANCE2);
                    if (materializeModifier != null && !applier6 instanceof Applier) {
                        then2 = LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Trailing").then(TextFieldImplKt.getIconDefaultSizeModifier());
                        center = Alignment.Companion.getCenter();
                        ComposerKt.sourceInformationMarkerStart(valueOf10, 733328855, str3);
                        valueOf5 = 0;
                        layoutDirection = 0;
                        ComposerKt.sourceInformationMarkerStart(valueOf10, -1323940314, $i$f$Layout);
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(valueOf10, 0);
                        currentCompositionLocalMap2 = valueOf10.getCurrentCompositionLocalMap();
                        i11 = center;
                        materializeModifier6 = ComposedModifierKt.materializeModifier(valueOf10, then2);
                        currentCompositeKeyHash4 = then2;
                        function06 = constructor3;
                        obj = 0;
                        ComposerKt.sourceInformationMarkerStart(valueOf10, -692256719, iNSTANCE2);
                        if (!applier6 instanceof Applier) {
                            ComposablesKt.invalidApplier();
                        }
                        valueOf10.startReusableNode();
                        if (valueOf10.getInserting()) {
                            valueOf10.createNode(function06);
                        } else {
                            factory$iv$iv$iv6 = function06;
                            valueOf10.useNode();
                        }
                        $composer2 = factory$iv$iv$iv6;
                        Composer constructor-impl7 = Updater.constructor-impl(valueOf10);
                        int i210 = 0;
                        i12 = i146;
                        Updater.set-impl(constructor-impl7, BoxKt.maybeCachedBoxMeasurePolicy(center, valueOf5), ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(constructor-impl7, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        int i216 = 0;
                        Composer composer22 = constructor-impl7;
                        int i224 = 0;
                        if (!composer22.getInserting()) {
                            localMap$iv$iv3 = currentCompositionLocalMap2;
                            i6 = valueOf5;
                            if (!Intrinsics.areEqual(composer22.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                composer22.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                constructor-impl7.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            } else {
                                composer3 = composer22;
                            }
                        } else {
                            localMap$iv$iv3 = currentCompositionLocalMap2;
                            i6 = valueOf5;
                        }
                        Updater.set-impl(constructor-impl7, materializeModifier6, ComposeUiNode.Companion.getSetModifier());
                        Composer composer18 = valueOf10;
                        $this$dp$iv = 0;
                        ComposerKt.sourceInformationMarkerStart(composer18, -2146769399, str);
                        maybeCachedBoxMeasurePolicy4 = BoxScopeInstance.INSTANCE;
                        i212 |= 6;
                        i7 = 0;
                        composer7 = i91;
                        map = materializeModifier6;
                        materialized$iv$iv2 = function02;
                        ComposerKt.sourceInformationMarkerStart(materialized$iv$iv2, -367622711, "C497@25497L10:OutlinedTextField.kt#uh7d8r");
                        materializeModifier.invoke(materialized$iv$iv2, Integer.valueOf(i92 &= 14));
                        ComposerKt.sourceInformationMarkerEnd(materialized$iv$iv2);
                        ComposerKt.sourceInformationMarkerEnd(composer18);
                        valueOf10.endNode();
                        ComposerKt.sourceInformationMarkerEnd(valueOf10);
                        ComposerKt.sourceInformationMarkerEnd(valueOf10);
                        ComposerKt.sourceInformationMarkerEnd(valueOf10);
                    }
                    valueOf10.endReplaceGroup();
                    $composer$iv = PaddingKt.calculateStartPadding(obj3, (LayoutDirection)valueOf2);
                    materialized$iv$iv = PaddingKt.calculateEndPadding(obj3, valueOf2);
                    if (leading != null) {
                        int i147 = 0;
                        int i156 = 0;
                        maybeCachedBoxMeasurePolicy4 = 0;
                        $this$coerceAtLeast_u2dYgX7TsA$iv = Dp.constructor-impl(RangesKt.coerceAtLeast(Dp.constructor-impl($composer$iv - horizontalIconPadding), Dp.constructor-impl((float)i148)));
                    } else {
                        $this$coerceAtLeast_u2dYgX7TsA$iv = $composer$iv;
                    }
                    i11 = $this$coerceAtLeast_u2dYgX7TsA$iv;
                    if (materializeModifier != null) {
                        int i150 = 0;
                        int i162 = 0;
                        maybeCachedBoxMeasurePolicy4 = 0;
                        $this$coerceAtLeast_u2dYgX7TsA$iv2 = Dp.constructor-impl(RangesKt.coerceAtLeast(Dp.constructor-impl(materialized$iv$iv - horizontalIconPadding2), Dp.constructor-impl((float)i151)));
                    } else {
                        $this$coerceAtLeast_u2dYgX7TsA$iv2 = materialized$iv$iv;
                    }
                    valueOf10.startReplaceGroup(250410106);
                    ComposerKt.sourceInformation(valueOf10, "518@26256L309");
                    i17 = 0;
                    if (iNSTANCE != null) {
                        layoutDirection = valueOf2;
                        i7 = $composer$iv;
                        int i102 = 0;
                        Modifier padding-qDBjuR0$default3 = PaddingKt.padding-qDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.heightIn-VpY3zN4$default(LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Prefix"), TextFieldImplKt.getMinTextLineHeight(), 0, 2, i17), i17, i102, 3, i17), i11, 0, TextFieldImplKt.getPrefixSuffixTextPadding(), 0, 10, 0);
                        maybeCachedBoxMeasurePolicy5 = i102;
                        ComposerKt.sourceInformationMarkerStart(valueOf10, 733328855, str3);
                        obj = i103;
                        maybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                        $composer2 = 0;
                        composer7 = materialized$iv$iv;
                        ComposerKt.sourceInformationMarkerStart(valueOf10, -1323940314, $i$f$Layout);
                        currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(valueOf10, 0);
                        currentCompositionLocalMap5 = valueOf10.getCurrentCompositionLocalMap();
                        function02 = padding-qDBjuR0$default3;
                        Function0 function011 = constructor8;
                        modifier3 = 0;
                        ComposerKt.sourceInformationMarkerStart(valueOf10, -692256719, iNSTANCE2);
                        if (!applier4 instanceof Applier) {
                            ComposablesKt.invalidApplier();
                        }
                        valueOf10.startReusableNode();
                        if (valueOf10.getInserting()) {
                            valueOf10.createNode(function011);
                        } else {
                            factory$iv$iv$iv5 = function011;
                            valueOf10.useNode();
                        }
                        i12 = factory$iv$iv$iv5;
                        Composer constructor-impl5 = Updater.constructor-impl(valueOf10);
                        int i238 = 0;
                        map = $this$coerceAtLeast_u2dYgX7TsA$iv2;
                        Updater.set-impl(constructor-impl5, maybeCachedBoxMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(constructor-impl5, currentCompositionLocalMap5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        int i242 = 0;
                        Composer composer27 = constructor-impl5;
                        int i246 = 0;
                        if (!composer27.getInserting()) {
                            localMap$iv$iv2 = maybeCachedBoxMeasurePolicy3;
                            map2 = currentCompositionLocalMap5;
                            if (!Intrinsics.areEqual(composer27.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                composer27.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                constructor-impl5.apply(Integer.valueOf(currentCompositeKeyHash2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            } else {
                                composer = composer27;
                            }
                        } else {
                            localMap$iv$iv2 = maybeCachedBoxMeasurePolicy3;
                            map2 = currentCompositionLocalMap5;
                        }
                        Updater.set-impl(constructor-impl5, ComposedModifierKt.materializeModifier(valueOf10, padding-qDBjuR0$default3), ComposeUiNode.Companion.getSetModifier());
                        Composer composer17 = valueOf10;
                        ComposerKt.sourceInformationMarkerStart(composer17, -2146769399, str);
                        $this$coerceAtLeast_u2dYgX7TsA$iv2 = BoxScopeInstance.INSTANCE;
                        i240 |= 6;
                        iNSTANCE3 = 0;
                        localMap$iv$iv = i66;
                        i20 = i129;
                        materialized$iv$iv = measurePolicy$iv;
                        ComposerKt.sourceInformationMarkerStart(materialized$iv$iv, -366589109, "C524@26539L8:OutlinedTextField.kt#uh7d8r");
                        iNSTANCE.invoke(materialized$iv$iv, Integer.valueOf(i67 &= 14));
                        ComposerKt.sourceInformationMarkerEnd(materialized$iv$iv);
                        ComposerKt.sourceInformationMarkerEnd(composer17);
                        valueOf10.endNode();
                        ComposerKt.sourceInformationMarkerEnd(valueOf10);
                        ComposerKt.sourceInformationMarkerEnd(valueOf10);
                        ComposerKt.sourceInformationMarkerEnd(valueOf10);
                    } else {
                        layoutDirection = valueOf2;
                        i7 = $composer$iv;
                        composer7 = materialized$iv$iv;
                        map = $this$coerceAtLeast_u2dYgX7TsA$iv2;
                    }
                    valueOf10.endReplaceGroup();
                    valueOf10.startReplaceGroup(250422072);
                    ComposerKt.sourceInformation(valueOf10, "528@26630L307");
                    int i140 = 0;
                    int i119 = 0;
                    Modifier padding-qDBjuR0$default = PaddingKt.padding-qDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.heightIn-VpY3zN4$default(LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Suffix"), TextFieldImplKt.getMinTextLineHeight(), 0, 2, i140), i140, i119, 3, i140), TextFieldImplKt.getPrefixSuffixTextPadding(), 0, map, 0, 10, 0);
                    int i95 = i119;
                    ComposerKt.sourceInformationMarkerStart(valueOf10, 733328855, str3);
                    Alignment topStart3 = Alignment.Companion.getTopStart();
                    maybeCachedBoxMeasurePolicy6 = 0;
                    ComposerKt.sourceInformationMarkerStart(valueOf10, -1323940314, $i$f$Layout);
                    currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(valueOf10, 0);
                    currentCompositionLocalMap3 = valueOf10.getCurrentCompositionLocalMap();
                    $composer2 = i120;
                    Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(valueOf10, padding-qDBjuR0$default);
                    modifier3 = padding-qDBjuR0$default;
                    Function0 function07 = constructor4;
                    currentCompositeKeyHash2 = 0;
                    ComposerKt.sourceInformationMarkerStart(valueOf10, -692256719, iNSTANCE2);
                    if (obj11 != null && !applier instanceof Applier) {
                        i140 = 0;
                        i119 = 0;
                        padding-qDBjuR0$default = PaddingKt.padding-qDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.heightIn-VpY3zN4$default(LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Suffix"), TextFieldImplKt.getMinTextLineHeight(), 0, 2, i140), i140, i119, 3, i140), TextFieldImplKt.getPrefixSuffixTextPadding(), 0, map, 0, 10, 0);
                        i95 = i119;
                        ComposerKt.sourceInformationMarkerStart(valueOf10, 733328855, str3);
                        topStart3 = Alignment.Companion.getTopStart();
                        maybeCachedBoxMeasurePolicy6 = 0;
                        ComposerKt.sourceInformationMarkerStart(valueOf10, -1323940314, $i$f$Layout);
                        currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(valueOf10, 0);
                        currentCompositionLocalMap3 = valueOf10.getCurrentCompositionLocalMap();
                        $composer2 = i120;
                        materializeModifier3 = ComposedModifierKt.materializeModifier(valueOf10, padding-qDBjuR0$default);
                        modifier3 = padding-qDBjuR0$default;
                        function07 = constructor4;
                        currentCompositeKeyHash2 = 0;
                        ComposerKt.sourceInformationMarkerStart(valueOf10, -692256719, iNSTANCE2);
                        if (!applier instanceof Applier) {
                            ComposablesKt.invalidApplier();
                        }
                        valueOf10.startReusableNode();
                        if (valueOf10.getInserting()) {
                            valueOf10.createNode(function07);
                        } else {
                            factory$iv$iv$iv3 = function07;
                            valueOf10.useNode();
                        }
                        function02 = factory$iv$iv$iv3;
                        Composer constructor-impl3 = Updater.constructor-impl(valueOf10);
                        int i226 = 0;
                        measurePolicy$iv = topStart3;
                        Updater.set-impl(constructor-impl3, BoxKt.maybeCachedBoxMeasurePolicy(topStart3, false), ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(constructor-impl3, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        int i235 = 0;
                        Composer composer25 = constructor-impl3;
                        int i244 = 0;
                        if (!composer25.getInserting()) {
                            localMap$iv$iv2 = currentCompositionLocalMap3;
                            if (!Intrinsics.areEqual(composer25.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                                composer25.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                                constructor-impl3.apply(Integer.valueOf(currentCompositeKeyHash4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            } else {
                                composer5 = composer25;
                            }
                        } else {
                            localMap$iv$iv2 = currentCompositionLocalMap3;
                        }
                        Updater.set-impl(constructor-impl3, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                        Composer composer14 = valueOf10;
                        materializeModifier = 0;
                        ComposerKt.sourceInformationMarkerStart(composer14, -2146769399, str);
                        iNSTANCE = BoxScopeInstance.INSTANCE;
                        i228 |= 6;
                        iNSTANCE3 = 0;
                        localMap$iv$iv = i40;
                        composer6 = materializeModifier3;
                        materialized$iv$iv = i6;
                        ComposerKt.sourceInformationMarkerStart(materialized$iv$iv, -366220085, "C534@26911L8:OutlinedTextField.kt#uh7d8r");
                        obj11.invoke(materialized$iv$iv, Integer.valueOf(i41 &= 14));
                        ComposerKt.sourceInformationMarkerEnd(materialized$iv$iv);
                        ComposerKt.sourceInformationMarkerEnd(composer14);
                        valueOf10.endNode();
                        ComposerKt.sourceInformationMarkerEnd(valueOf10);
                        ComposerKt.sourceInformationMarkerEnd(valueOf10);
                        ComposerKt.sourceInformationMarkerEnd(valueOf10);
                    }
                    valueOf10.endReplaceGroup();
                    constructor-impl = 0;
                    if (prefix == null) {
                        f = i11;
                    } else {
                        i8 = 0;
                        f = constructor-impl2;
                    }
                    if (obj11 == null) {
                        f2 = map;
                    } else {
                        i8 = 0;
                        f2 = constructor-impl;
                    }
                    Modifier padding-qDBjuR0$default2 = PaddingKt.padding-qDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.heightIn-VpY3zN4$default((Modifier)Modifier.Companion, TextFieldImplKt.getMinTextLineHeight(), 0, 2, constructor-impl), constructor-impl, false, 3, constructor-impl), f, 0, f2, 0, 10, 0);
                    valueOf10.startReplaceGroup(250444361);
                    ComposerKt.sourceInformation(valueOf10, "547@27339L63");
                    if (placeholder != null) {
                        placeholder.invoke(LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Hint").then(padding-qDBjuR0$default2), valueOf10, Integer.valueOf(i122 &= 112));
                    } else {
                        obj2 = placeholder;
                    }
                    valueOf10.endReplaceGroup();
                    Modifier then3 = LayoutIdKt.layoutId((Modifier)Modifier.Companion, "TextField").then(padding-qDBjuR0$default2);
                    int i124 = 384;
                    valueOf7 = i189;
                    maybeCachedBoxMeasurePolicy = 0;
                    ComposerKt.sourceInformationMarkerStart(valueOf10, 733328855, str3);
                    $dirty1 = 0;
                    obj = padding-qDBjuR0$default2;
                    ComposerKt.sourceInformationMarkerStart(valueOf10, -1323940314, $i$f$Layout);
                    currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(valueOf10, 0);
                    currentCompositionLocalMap4 = valueOf10.getCurrentCompositionLocalMap();
                    Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(valueOf10, then3);
                    modifier3 = then3;
                    Function0 function08 = constructor5;
                    currentCompositeKeyHash2 = 0;
                    ComposerKt.sourceInformationMarkerStart(valueOf10, -692256719, iNSTANCE2);
                    if (!applier7 instanceof Applier) {
                        ComposablesKt.invalidApplier();
                    }
                    valueOf10.startReusableNode();
                    if (valueOf10.getInserting()) {
                        valueOf10.createNode(function08);
                    } else {
                        factory$iv$iv$iv7 = function08;
                        valueOf10.useNode();
                    }
                    function02 = factory$iv$iv$iv7;
                    Composer constructor-impl8 = Updater.constructor-impl(valueOf10);
                    int i229 = 0;
                    Updater.set-impl(constructor-impl8, BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), valueOf7), ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl8, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    int i236 = 0;
                    Composer composer24 = constructor-impl8;
                    int i243 = 0;
                    if (!composer24.getInserting()) {
                        localMap$iv$iv = currentCompositionLocalMap4;
                        localMap$iv$iv2 = valueOf7;
                        if (!Intrinsics.areEqual(composer24.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                            composer24.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                            constructor-impl8.apply(Integer.valueOf(currentCompositeKeyHash4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer9 = composer24;
                        }
                    } else {
                        localMap$iv$iv = currentCompositionLocalMap4;
                        localMap$iv$iv2 = valueOf7;
                    }
                    Updater.set-impl(constructor-impl8, materializeModifier4, ComposeUiNode.Companion.getSetModifier());
                    Composer composer15 = valueOf10;
                    materializeModifier = 0;
                    ComposerKt.sourceInformationMarkerStart(composer15, -2146769399, str);
                    iNSTANCE = BoxScopeInstance.INSTANCE;
                    i231 |= 6;
                    measurePolicy$iv = 0;
                    iNSTANCE3 = i45;
                    composer6 = materializeModifier4;
                    $composer$iv2 = i6;
                    ComposerKt.sourceInformationMarkerStart($composer$iv2, -365545432, "C554@27591L11:OutlinedTextField.kt#uh7d8r");
                    textField.invoke($composer$iv2, Integer.valueOf(i46 &= 14));
                    ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                    ComposerKt.sourceInformationMarkerEnd(composer15);
                    valueOf10.endNode();
                    ComposerKt.sourceInformationMarkerEnd(valueOf10);
                    ComposerKt.sourceInformationMarkerEnd(valueOf10);
                    ComposerKt.sourceInformationMarkerEnd(valueOf10);
                    valueOf10.startReplaceGroup(250455481);
                    ComposerKt.sourceInformation(valueOf10, "558@27667L501");
                    if (label != null) {
                        int i142 = 0;
                        int i160 = 0;
                        Modifier layoutId3 = LayoutIdKt.layoutId(SizeKt.wrapContentHeight$default(SizeKt.heightIn-VpY3zN4$default((Modifier)Modifier.Companion, DpKt.lerp-Md-fbLM(TextFieldImplKt.getMinTextLineHeight(), TextFieldImplKt.getMinFocusedLabelLineHeight(), animationProgress), 0, 2, i142), i142, i160, 3, i142), "Label");
                        int i127 = i160;
                        ComposerKt.sourceInformationMarkerStart(valueOf10, 733328855, str3);
                        topStart = Alignment.Companion.getTopStart();
                        $dirty1 = 0;
                        ComposerKt.sourceInformationMarkerStart(valueOf10, -1323940314, $i$f$Layout);
                        currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(valueOf10, 0);
                        currentCompositionLocalMap = valueOf10.getCurrentCompositionLocalMap();
                        Modifier materializeModifier5 = ComposedModifierKt.materializeModifier(valueOf10, layoutId3);
                        modifier3 = layoutId3;
                        Function0 function09 = constructor6;
                        currentCompositeKeyHash2 = 0;
                        ComposerKt.sourceInformationMarkerStart(valueOf10, -692256719, iNSTANCE2);
                        if (!applier3 instanceof Applier) {
                            ComposablesKt.invalidApplier();
                        }
                        valueOf10.startReusableNode();
                        if (valueOf10.getInserting()) {
                            valueOf10.createNode(function09);
                        } else {
                            factory$iv$iv$iv = function09;
                            valueOf10.useNode();
                        }
                        function02 = factory$iv$iv$iv;
                        Composer constructor-impl4 = Updater.constructor-impl(valueOf10);
                        int i232 = 0;
                        measurePolicy$iv = i134;
                        Updater.set-impl(constructor-impl4, BoxKt.maybeCachedBoxMeasurePolicy(topStart, false), ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(constructor-impl4, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        int i237 = 0;
                        Composer composer26 = constructor-impl4;
                        int i245 = 0;
                        if (!composer26.getInserting()) {
                            localMap$iv$iv2 = currentCompositionLocalMap;
                            map2 = topStart;
                            if (!Intrinsics.areEqual(composer26.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                                composer26.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                                constructor-impl4.apply(Integer.valueOf(currentCompositeKeyHash4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            } else {
                                composer2 = composer26;
                            }
                        } else {
                            localMap$iv$iv2 = currentCompositionLocalMap;
                            map2 = topStart;
                        }
                        Updater.set-impl(constructor-impl4, materializeModifier5, ComposeUiNode.Companion.getSetModifier());
                        Composer composer16 = valueOf10;
                        materializeModifier = 0;
                        ComposerKt.sourceInformationMarkerStart(composer16, -2146769399, str);
                        iNSTANCE = BoxScopeInstance.INSTANCE;
                        i234 |= 6;
                        iNSTANCE3 = 0;
                        localMap$iv$iv = i59;
                        i20 = materializeModifier5;
                        $composer$iv2 = i6;
                        ComposerKt.sourceInformationMarkerStart($composer$iv2, -364997972, "C570@28143L7:OutlinedTextField.kt#uh7d8r");
                        label.invoke($composer$iv2, Integer.valueOf(i60 &= 14));
                        ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                        ComposerKt.sourceInformationMarkerEnd(composer16);
                        valueOf10.endNode();
                        ComposerKt.sourceInformationMarkerEnd(valueOf10);
                        ComposerKt.sourceInformationMarkerEnd(valueOf10);
                        ComposerKt.sourceInformationMarkerEnd(valueOf10);
                    } else {
                        valueOf9 = label;
                        $this$dp$iv = animationProgress;
                    }
                    valueOf10.endReplaceGroup();
                    valueOf10.startReplaceGroup(250473414);
                    ComposerKt.sourceInformation(valueOf10, "575@28238L317");
                    if (supporting != null) {
                        int i141 = 0;
                        Modifier padding = PaddingKt.padding(SizeKt.wrapContentHeight$default(SizeKt.heightIn-VpY3zN4$default(LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Supporting"), TextFieldImplKt.getMinSupportingTextLineHeight(), 0, 2, i141), i141, false, 3, i141), TextFieldDefaults.supportingTextPadding-a9UjIt4$material3_release$default(TextFieldDefaults.INSTANCE, 0, 0, 0, 0, 15, 0));
                        $composer$iv2 = i191;
                        materializeModifier = 0;
                        ComposerKt.sourceInformationMarkerStart(valueOf10, 733328855, str3);
                        Alignment topStart2 = Alignment.Companion.getTopStart();
                        restartGroup = 0;
                        obj76 = topStart2;
                        ComposerKt.sourceInformationMarkerStart(valueOf10, -1323940314, $i$f$Layout);
                        $dirty1 = currentCompositeKeyHash5;
                        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(valueOf10, padding);
                        $i$f$cache2 = padding;
                        Function0 function05 = constructor;
                        i2 = 0;
                        ComposerKt.sourceInformationMarkerStart(valueOf10, -692256719, iNSTANCE2);
                        if (!applier2 instanceof Applier) {
                            ComposablesKt.invalidApplier();
                        }
                        valueOf10.startReusableNode();
                        if (valueOf10.getInserting()) {
                            valueOf10.createNode(function05);
                        } else {
                            factory$iv$iv$iv4 = function05;
                            valueOf10.useNode();
                        }
                        Composer constructor-impl10 = Updater.constructor-impl(valueOf10);
                        int i198 = 0;
                        function03 = factory$iv$iv$iv4;
                        Updater.set-impl(constructor-impl10, BoxKt.maybeCachedBoxMeasurePolicy(topStart2, false), ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(constructor-impl10, valueOf10.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        int i200 = 0;
                        Composer composer21 = constructor-impl10;
                        int i204 = 0;
                        if (!composer21.getInserting()) {
                            $composer2 = valueOf10;
                            if (!Intrinsics.areEqual(composer21.rememberedValue(), Integer.valueOf($dirty1))) {
                                composer21.updateRememberedValue(Integer.valueOf($dirty1));
                                constructor-impl10.apply(Integer.valueOf($dirty1), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            } else {
                                composer11 = composer21;
                            }
                        } else {
                            $composer2 = valueOf10;
                        }
                        Updater.set-impl(constructor-impl10, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                        valueOf10 = $composer2;
                        valueOf9 = 0;
                        ComposerKt.sourceInformationMarkerStart(valueOf10, -2146769399, str);
                        iNSTANCE2 = BoxScopeInstance.INSTANCE;
                        i185 |= 6;
                        composer4 = valueOf10;
                        companion2 = 0;
                        i28 = i53;
                        currentCompositeKeyHash = materializeModifier2;
                        ComposerKt.sourceInformationMarkerStart(valueOf10, -364618873, "C581@28525L12:OutlinedTextField.kt#uh7d8r");
                        supporting.invoke(valueOf10, Integer.valueOf(i54 &= 14));
                        ComposerKt.sourceInformationMarkerEnd(valueOf10);
                        ComposerKt.sourceInformationMarkerEnd(valueOf10);
                        $composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                    } else {
                        obj4 = supporting;
                        $composer2 = valueOf10;
                    }
                    $composer2.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    composer12.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer12);
                    ComposerKt.sourceInformationMarkerEnd(composer12);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    restartGroup.skipToGroupEnd();
                    obj4 = supporting;
                    i10 = traceInProgress2;
                    composer12 = restartGroup;
                    i5 = str;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer12.endRestartGroup();
        if (endRestartGroup != null) {
            $composer3 = composer12;
            endRestartGroup = new OutlinedTextFieldKt.OutlinedTextFieldLayout.2(modifier, textField, placeholder, label, leading, trailing, prefix, obj11, singleLine, $this$dp$iv, onLabelMeasured, container, obj4, obj3, $changed, $changed1);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        } else {
            $composer3 = composer12;
        }
    }

    public static final int access$calculateHeight-mKXJcVc(int leadingHeight, int trailingHeight, int prefixHeight, int suffixHeight, int textFieldHeight, int labelHeight, int placeholderHeight, int supportingHeight, float animationProgress, long constraints, float density, PaddingValues paddingValues) {
        return OutlinedTextFieldKt.calculateHeight-mKXJcVc(leadingHeight, trailingHeight, prefixHeight, suffixHeight, textFieldHeight, labelHeight, placeholderHeight, supportingHeight, animationProgress, constraints, density, paddingValues);
    }

    public static final int access$calculateWidth-DHJA7U0(int leadingPlaceableWidth, int trailingPlaceableWidth, int prefixPlaceableWidth, int suffixPlaceableWidth, int textFieldPlaceableWidth, int labelPlaceableWidth, int placeholderPlaceableWidth, float animationProgress, long constraints, float density, PaddingValues paddingValues) {
        return OutlinedTextFieldKt.calculateWidth-DHJA7U0(leadingPlaceableWidth, trailingPlaceableWidth, prefixPlaceableWidth, suffixPlaceableWidth, textFieldPlaceableWidth, labelPlaceableWidth, placeholderPlaceableWidth, animationProgress, constraints, density, paddingValues);
    }

    public static final float access$getOutlinedTextFieldInnerPadding$p() {
        return OutlinedTextFieldKt.OutlinedTextFieldInnerPadding;
    }

    public static final void access$place(Placeable.PlacementScope $receiver, int totalHeight, int width, Placeable leadingPlaceable, Placeable trailingPlaceable, Placeable prefixPlaceable, Placeable suffixPlaceable, Placeable textFieldPlaceable, Placeable labelPlaceable, Placeable placeholderPlaceable, Placeable containerPlaceable, Placeable supportingPlaceable, float animationProgress, boolean singleLine, float density, LayoutDirection layoutDirection, PaddingValues paddingValues) {
        OutlinedTextFieldKt.place($receiver, totalHeight, width, leadingPlaceable, trailingPlaceable, prefixPlaceable, suffixPlaceable, textFieldPlaceable, labelPlaceable, placeholderPlaceable, containerPlaceable, supportingPlaceable, animationProgress, singleLine, density, layoutDirection, paddingValues);
    }

    public static final int access$substractConstraintSafely(int $receiver, int from) {
        return OutlinedTextFieldKt.substractConstraintSafely($receiver, from);
    }

    private static final int calculateHeight-mKXJcVc(int leadingHeight, int trailingHeight, int prefixHeight, int suffixHeight, int textFieldHeight, int labelHeight, int placeholderHeight, int supportingHeight, float animationProgress, long constraints, float density, PaddingValues paddingValues) {
        final int i = labelHeight;
        final float f = animationProgress;
        final Object obj = suffixHeight;
        topPadding-D9Ej5fM *= paddingValues;
        return Math.max(Constraints.getMinHeight-impl(constraints), i12 += supportingHeight);
    }

    private static final int calculateWidth-DHJA7U0(int leadingPlaceableWidth, int trailingPlaceableWidth, int prefixPlaceableWidth, int suffixPlaceableWidth, int textFieldPlaceableWidth, int labelPlaceableWidth, int placeholderPlaceableWidth, float animationProgress, long constraints, float density, PaddingValues paddingValues) {
        final float f = animationProgress;
        final Object obj = obj20;
        final int i = prefixPlaceableWidth + suffixPlaceableWidth;
        int i12 = 0;
        return Math.max(i6 += trailingPlaceableWidth, Math.max(MathKt.roundToInt(i10 *= f), Constraints.getMinWidth-impl(constraints)));
    }

    public static final long getOutlinedTextFieldTopPadding() {
        return OutlinedTextFieldKt.OutlinedTextFieldTopPadding;
    }

    public static final Modifier outlineCutout(Modifier $this$outlineCutout, Function0<Size> labelSize, PaddingValues paddingValues) {
        OutlinedTextFieldKt.outlineCutout.1 anon = new OutlinedTextFieldKt.outlineCutout.1(labelSize, paddingValues);
        return DrawModifierKt.drawWithContent($this$outlineCutout, (Function1)anon);
    }

    private static final void place(Placeable.PlacementScope $this$place, int totalHeight, int width, Placeable leadingPlaceable, Placeable trailingPlaceable, Placeable prefixPlaceable, Placeable suffixPlaceable, Placeable textFieldPlaceable, Placeable labelPlaceable, Placeable placeholderPlaceable, Placeable containerPlaceable, Placeable supportingPlaceable, float animationProgress, boolean singleLine, float density, LayoutDirection layoutDirection, PaddingValues paddingValues) {
        float horizontalIconPadding;
        Placeable.PlacementScope placementScope2;
        Placeable placeable2;
        int widthOrZero;
        int i3;
        int place$calculateVerticalPosition2;
        int i4;
        int place$calculateVerticalPosition;
        int height;
        int i2;
        int i10;
        int i;
        int i11;
        int i9;
        int i12;
        int textHorizontalPosition;
        Placeable.PlacementScope placementScope;
        Placeable placeable;
        int i7;
        int align;
        int i5;
        int i8;
        int i6;
        Placeable placeable3 = prefixPlaceable;
        final Placeable placeable4 = suffixPlaceable;
        final Placeable placeable5 = labelPlaceable;
        Placeable placeable6 = placeholderPlaceable;
        final float f3 = animationProgress;
        final boolean z = singleLine;
        Placeable.PlacementScope.place-70tqf50$default($this$place, containerPlaceable, IntOffset.Companion.getZero-nOcc-ac(), obj15, 0, 2);
        int i20 = totalHeight - heightOrZero;
        int roundToInt2 = MathKt.roundToInt(topPadding-D9Ej5fM *= density);
        if (leadingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$place, leadingPlaceable, 0, Alignment.Companion.getCenterVertically().align(leadingPlaceable.getHeight(), i20), 0, 4, 0);
        }
        if (placeable5 != null) {
            placeable = labelPlaceable;
            horizontalIconPadding = 0;
            if (z) {
                widthOrZero = Alignment.Companion.getCenterVertically().align(placeable.getHeight(), i20);
            } else {
                widthOrZero = roundToInt2;
            }
            if (leadingPlaceable == null) {
                i4 = 0;
            } else {
                i18 *= i2;
            }
            Placeable.PlacementScope.placeRelative$default($this$place, placeable, place$calculateVerticalPosition2 + i22, MathHelpersKt.lerp(widthOrZero, -i16, f3), 0, 4, 0);
        }
        if (placeable3 != null) {
            Placeable.PlacementScope.placeRelative$default($this$place, placeable3, TextFieldImplKt.widthOrZero(leadingPlaceable), OutlinedTextFieldKt.place$calculateVerticalPosition(z, i20, roundToInt2, placeable5, placeable3), 0, 4, 0);
        }
        i3 = widthOrZero2 + widthOrZero4;
        placeable2 = textFieldPlaceable;
        Placeable.PlacementScope.placeRelative$default($this$place, placeable2, i3, OutlinedTextFieldKt.place$calculateVerticalPosition(z, i20, roundToInt2, placeable5, placeable2), 0, 4, 0);
        if (placeable6 != null) {
            Placeable.PlacementScope.placeRelative$default($this$place, placeable6, i3, OutlinedTextFieldKt.place$calculateVerticalPosition(z, i20, roundToInt2, placeable5, placeable6), 0, 4, 0);
            textHorizontalPosition = i3;
        } else {
            textHorizontalPosition = i3;
        }
        if (placeable4 != null) {
            Placeable.PlacementScope.placeRelative$default($this$place, placeable4, i15 - width3, OutlinedTextFieldKt.place$calculateVerticalPosition(z, i20, roundToInt2, placeable5, placeable4), 0, 4, 0);
        }
        if (trailingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$place, trailingPlaceable, width - width2, Alignment.Companion.getCenterVertically().align(trailingPlaceable.getHeight(), i20), 0, 4, 0);
        }
        if (supportingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$place, supportingPlaceable, 0, i20, 0, 4, 0);
        } else {
            height = i20;
        }
    }

    private static final int place$calculateVerticalPosition(boolean $singleLine, int height, int topPadding, Placeable $labelPlaceable, Placeable placeable) {
        int align;
        int height2;
        if ($singleLine) {
            align = Alignment.Companion.getCenterVertically().align(placeable.getHeight(), height);
        } else {
            align = topPadding;
        }
        return Math.max(align, heightOrZero /= 2);
    }

    private static final int substractConstraintSafely(int $this$substractConstraintSafely, int from) {
        if ($this$substractConstraintSafely == Integer.MAX_VALUE) {
            return $this$substractConstraintSafely;
        }
        return $this$substractConstraintSafely - from;
    }
}
