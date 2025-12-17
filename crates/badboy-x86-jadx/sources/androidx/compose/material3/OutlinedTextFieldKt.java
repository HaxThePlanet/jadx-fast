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
        Object obj14;
        Object obj3;
        Object obj;
        Object obj16;
        Object obj4;
        Object obj12;
        boolean z;
        Object obj6;
        Object obj17;
        Object obj18;
        boolean z3;
        int i2;
        int i63;
        Object obj5;
        Object obj21;
        Object obj9;
        int skipping;
        int i59;
        int i6;
        Object colors2;
        int defaultsInvalid;
        int this_$iv;
        int placeholder3;
        Composer $composer2;
        int rememberComposableLambda;
        int rememberedValue;
        int leadingIcon2;
        Object leadingIcon3;
        ScopeUpdateScope endRestartGroup;
        Object trailingIcon2;
        int $composer5;
        int trailingIcon3;
        int $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2;
        int i58;
        Object obj10;
        boolean $composer3;
        int $dirty3;
        boolean $dirty;
        int $dirty1;
        Object $dirty12;
        int $dirty2;
        Object $dirty22;
        Object obj13;
        int i23;
        Object obj8;
        boolean traceInProgress;
        String str;
        int booleanValue;
        int i33;
        boolean obj20;
        int i34;
        int i15;
        Object obj19;
        int i61;
        boolean z2;
        Object readOnly3;
        int modifier2;
        Object obj11;
        Object textStyle3;
        int label2;
        int i43;
        int prefix2;
        int i20;
        Object obj15;
        int label3;
        VisualTransformation isError2;
        int suffix2;
        long $this$takeOrElse_u2dDxMtmZc$iv;
        KeyboardOptions colors3;
        int i46;
        int supportingText2;
        KeyboardActions keyboardActions2;
        int i11;
        int visualTransformation2;
        long textColor-XeAY9LY$material3_release;
        int i37;
        int changed5;
        int keyboardOptions2;
        int enabled2;
        int i44;
        int changed6;
        boolean isError3;
        int isError4;
        int readOnly2;
        int i39;
        int keyboardActions4;
        int mergedTextStyle;
        int i66;
        Object singleLine2;
        int singleLine3;
        Shape keyboardOptions3;
        int i30;
        Object maxLines2;
        int maxLines3;
        androidx.compose.material3.TextFieldColors keyboardActions3;
        int minLines3;
        int minLines2;
        int i35;
        int i41;
        int i67;
        int changed;
        int interactionSource3;
        int interactionSource2;
        int i48;
        int i68;
        Object i14;
        int changed4;
        int i3;
        int i17;
        int changed3;
        int obj2;
        int placeholder2;
        int i13;
        int obj7;
        int leadingIcon4;
        int i57;
        int i55;
        Composer $composer4;
        int i9;
        int i38;
        int i7;
        int i24;
        int i5;
        Object i32;
        int textStyle2;
        int i52;
        int i60;
        int i50;
        int i25;
        int i12;
        int i16;
        int i29;
        int i53;
        boolean changed2;
        int i8;
        int i62;
        int i18;
        int i26;
        int i27;
        int i19;
        int i;
        int i31;
        int i36;
        int i51;
        int i45;
        int i56;
        int i10;
        int i40;
        int i42;
        int i21;
        int i54;
        int i49;
        int i47;
        int i4;
        int i64;
        int i22;
        int i65;
        ScopeUpdateScope scopeUpdateScope;
        int obj71;
        int obj72;
        Shape obj73;
        int i69 = $changed;
        int i89 = $changed1;
        $composer5 = $changed2;
        $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2 = i28;
        Composer restartGroup = $composer.startRestartGroup(-1570442800);
        ComposerKt.sourceInformation(restartGroup, "C(OutlinedTextField)P(21,11,10,1,14,19,6,12,7,20,13,17,18,3,22,5,4,16,8,9,2,15)350@19364L7,366@20168L5,367@20231L8,379@20751L7,381@20851L2858,381@20764L2945:OutlinedTextField.kt#uh7d8r");
        $dirty3 = $changed;
        $dirty1 = $changed1;
        $dirty2 = $changed2;
        if ($i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2 & 1 != 0) {
            $dirty3 |= 6;
            obj13 = value;
        } else {
            if (i69 & 6 == 0) {
                i15 = restartGroup.changed(value) ? 4 : 2;
                $dirty3 |= i15;
            } else {
                obj13 = value;
            }
        }
        if ($i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2 & 2 != 0) {
            $dirty3 |= 48;
            obj19 = onValueChange;
        } else {
            if (i69 & 48 == 0) {
                i43 = restartGroup.changedInstance(onValueChange) ? 32 : 16;
                $dirty3 |= i43;
            } else {
                obj19 = onValueChange;
            }
        }
        prefix2 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2 & 4;
        int i112 = 128;
        if (prefix2 != 0) {
            $dirty3 |= 384;
            obj8 = modifier;
        } else {
            if (i69 & 384 == 0) {
                i46 = restartGroup.changed(modifier) ? 256 : i112;
                $dirty3 |= i46;
            } else {
                obj8 = modifier;
            }
        }
        supportingText2 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2 & 8;
        changed5 = 1024;
        if (supportingText2 != 0) {
            $dirty3 |= 3072;
            obj20 = enabled;
        } else {
            if (i69 & 3072 == 0) {
                i39 = restartGroup.changed(enabled) ? i11 : changed5;
                $dirty3 |= i39;
            } else {
                obj20 = enabled;
            }
        }
        keyboardActions4 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2 & 16;
        i30 = 8192;
        if (keyboardActions4 != 0) {
            $dirty3 |= 24576;
            z2 = readOnly;
        } else {
            if (i69 & 24576 == 0) {
                i35 = restartGroup.changed(readOnly) ? i66 : i30;
                $dirty3 |= i35;
            } else {
                z2 = readOnly;
            }
        }
        i41 = 196608;
        i68 = 65536;
        if (i69 & i41 == 0) {
            if ($i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2 & 32 == 0) {
                changed4 = restartGroup.changed(textStyle) ? 131072 : i68;
            } else {
                obj11 = textStyle;
            }
            $dirty3 |= changed4;
        } else {
            obj11 = textStyle;
        }
        int i127 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2 & 64;
        changed3 = 1572864;
        if (i127 != 0) {
            $dirty3 |= changed3;
            obj15 = label;
        } else {
            if (i69 & changed3 == 0) {
                i57 = restartGroup.changedInstance(label) ? 1048576 : 524288;
                $dirty3 |= i57;
            } else {
                obj15 = label;
            }
        }
        int i70 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2 & 128;
        i55 = 12582912;
        i9 = 4194304;
        if (i70 != 0) {
            $dirty3 |= i55;
            i38 = i70;
            obj14 = placeholder;
        } else {
            if ($changed & i55 == 0) {
                i38 = i70;
                i7 = restartGroup.changedInstance(placeholder) ? 8388608 : i9;
                $dirty3 |= i7;
            } else {
                i38 = i70;
                obj14 = placeholder;
            }
        }
        int i71 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2 & 256;
        int i129 = 100663296;
        if (i71 != 0) {
            $dirty3 |= i129;
            i24 = i71;
            obj3 = leadingIcon;
        } else {
            if ($changed & i129 == 0) {
                i24 = i71;
                i5 = restartGroup.changedInstance(leadingIcon) ? 67108864 : 33554432;
                $dirty3 |= i5;
            } else {
                i24 = i71;
                obj3 = leadingIcon;
            }
        }
        int i72 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2 & 512;
        i32 = 805306368;
        if (i72 != 0) {
            $dirty3 |= i32;
            textStyle2 = i72;
            obj = trailingIcon;
        } else {
            if ($changed & i32 == 0) {
                textStyle2 = i72;
                i52 = restartGroup.changedInstance(trailingIcon) ? 536870912 : 268435456;
                $dirty3 |= i52;
            } else {
                textStyle2 = i72;
                obj = trailingIcon;
            }
        }
        int i73 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2 & 1024;
        if (i73 != 0) {
            $dirty1 |= 6;
            i60 = i73;
            obj16 = prefix;
        } else {
            if (i89 & 6 == 0) {
                i60 = i73;
                i50 = restartGroup.changedInstance(prefix) ? 4 : 2;
                $dirty1 |= i50;
            } else {
                i60 = i73;
                obj16 = prefix;
            }
        }
        int i74 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2 & 2048;
        if (i74 != 0) {
            $dirty1 |= 48;
            i25 = i74;
            obj4 = suffix;
        } else {
            if (i89 & 48 == 0) {
                i25 = i74;
                i12 = restartGroup.changedInstance(suffix) ? 32 : 16;
                $dirty1 |= i12;
            } else {
                i25 = i74;
                obj4 = suffix;
            }
        }
        int i75 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2 & 4096;
        if (i75 != 0) {
            $dirty1 |= 384;
            i16 = i75;
            obj12 = supportingText;
        } else {
            i16 = i75;
            if (i89 & 384 == 0) {
                i29 = restartGroup.changedInstance(supportingText) ? 256 : i112;
                $dirty1 |= i29;
            } else {
                obj12 = supportingText;
            }
        }
        int i77 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2 & 8192;
        if (i77 != 0) {
            $dirty1 |= 3072;
            i53 = i77;
            z = isError;
        } else {
            i53 = i77;
            if (i89 & 3072 == 0) {
                if (restartGroup.changed(isError)) {
                } else {
                    i11 = changed5;
                }
                $dirty1 |= i11;
            } else {
                z = isError;
            }
        }
        int i78 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2 & 16384;
        if (i78 != 0) {
            $dirty1 |= 24576;
            visualTransformation2 = i78;
            obj6 = visualTransformation;
        } else {
            visualTransformation2 = i78;
            if (i89 & 24576 == 0) {
                if (restartGroup.changed(visualTransformation)) {
                } else {
                    i66 = i30;
                }
                $dirty1 |= i66;
            } else {
                obj6 = visualTransformation;
            }
        }
        keyboardOptions2 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2 & i113;
        if (keyboardOptions2 != 0) {
            $dirty1 |= i41;
            obj17 = keyboardOptions;
        } else {
            if (i89 & i41 == 0) {
                i66 = restartGroup.changed(keyboardOptions) ? 131072 : i68;
                $dirty1 |= i66;
            } else {
                obj17 = keyboardOptions;
            }
        }
        int i115 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2 & i68;
        if (i115 != 0) {
            $dirty1 |= changed3;
            obj18 = keyboardActions;
        } else {
            if (i89 & changed3 == 0) {
                i30 = restartGroup.changed(keyboardActions) ? 1048576 : 524288;
                $dirty1 |= i30;
            } else {
                obj18 = keyboardActions;
            }
        }
        int i117 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2 & i116;
        if (i117 != 0) {
            $dirty1 |= i55;
            z3 = singleLine;
        } else {
            if (i89 & i55 == 0) {
                i41 = restartGroup.changed(singleLine) ? 8388608 : i9;
                $dirty1 |= i41;
            } else {
                z3 = singleLine;
            }
        }
        if (i89 & i120 == 0) {
            if ($i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2 & i121 == 0) {
                i67 = restartGroup.changed(maxLines) ? 67108864 : 33554432;
            } else {
                i2 = maxLines;
            }
            $dirty1 |= i67;
        } else {
            i2 = maxLines;
        }
        interactionSource3 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2 & i122;
        if (interactionSource3 != 0) {
            $dirty1 |= i32;
            i63 = minLines;
        } else {
            if (i89 & i32 == 0) {
                i68 = restartGroup.changed(minLines) ? 536870912 : 268435456;
                $dirty1 |= i68;
            } else {
                i63 = minLines;
            }
        }
        i14 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2 & i126;
        if (i14 != 0) {
            $dirty2 |= 6;
            obj5 = interactionSource;
        } else {
            if ($composer5 & 6 == 0) {
                i44 = restartGroup.changed(interactionSource) ? 4 : 2;
                $dirty2 |= i44;
            } else {
                obj5 = interactionSource;
            }
        }
        if ($composer5 & 48 == 0) {
            if ($i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2 & i114 == 0) {
                minLines3 = restartGroup.changed(shape) ? 32 : 16;
            } else {
                obj21 = shape;
            }
            $dirty2 |= minLines3;
        } else {
            obj21 = shape;
        }
        if ($composer5 & 384 == 0) {
            if ($i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2 & i9 == 0) {
                i13 = restartGroup.changed(colors) ? 256 : i112;
            } else {
                obj9 = colors;
            }
            $dirty2 |= i13;
        } else {
            obj9 = colors;
        }
        if ($dirty3 & suffix2 == 306783378 && i85 &= $dirty1 == 306783378 && $dirty2 & 147 == 146) {
            if (i85 &= $dirty1 == 306783378) {
                if ($dirty2 & 147 == 146) {
                    if (!restartGroup.getSkipping()) {
                        restartGroup.startDefaults();
                        if ($changed & 1 != 0) {
                            if (restartGroup.getDefaultsInvalid()) {
                                if (prefix2 != 0) {
                                    obj8 = defaultsInvalid;
                                }
                                if (supportingText2 != 0) {
                                    obj20 = defaultsInvalid;
                                }
                                if (keyboardActions4 != 0) {
                                    z2 = defaultsInvalid;
                                }
                                if ($i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2 & 32 != 0) {
                                    prefix2 = 6;
                                    suffix2 = 0;
                                    ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                                    $dirty3 &= rememberComposableLambda;
                                    obj11 = this_$iv;
                                }
                                if (i127 != 0) {
                                    obj15 = this_$iv;
                                }
                                placeholder3 = i38 != 0 ? 0 : placeholder;
                                leadingIcon2 = i24 != 0 ? 0 : leadingIcon;
                                trailingIcon3 = textStyle2 != 0 ? 0 : trailingIcon;
                                prefix2 = i60 != 0 ? 0 : prefix;
                                suffix2 = i25 != 0 ? 0 : suffix;
                                supportingText2 = i16 != 0 ? 0 : supportingText;
                                isError4 = i53 != 0 ? 0 : isError;
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
                                if (i115 != 0) {
                                    keyboardActions4 = KeyboardActions.Companion.getDefault();
                                } else {
                                    keyboardActions4 = keyboardActions;
                                }
                                singleLine3 = i117 != 0 ? 0 : singleLine;
                                if ($i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2 & i118 != 0) {
                                    maxLines3 = singleLine3 != 0 ? 1 : 0x7fffffff /* Unknown resource */;
                                    $dirty1 &= minLines3;
                                } else {
                                    maxLines3 = maxLines;
                                }
                                minLines2 = interactionSource3 != 0 ? 1 : minLines;
                                interactionSource2 = i14 != 0 ? 0 : interactionSource;
                                obj71 = placeholder3;
                                int placeholder4 = 6;
                                if ($i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2 & i123 != 0) {
                                    obj72 = leadingIcon2;
                                    leadingIcon3 = OutlinedTextFieldDefaults.INSTANCE.getShape(restartGroup, placeholder4);
                                    $dirty2 &= -113;
                                } else {
                                    obj72 = leadingIcon2;
                                    leadingIcon3 = shape;
                                }
                                if ($i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2 & i9 != 0) {
                                    obj2 = obj71;
                                    obj7 = obj72;
                                    i32 = obj73;
                                    $dirty2 = i93;
                                    i55 = trailingIcon3;
                                    i9 = prefix2;
                                    i38 = suffix2;
                                    i24 = supportingText2;
                                    i14 = visualTransformation2;
                                    i48 = minLines2;
                                    rememberedValue = interactionSource2;
                                    trailingIcon2 = colors4;
                                    colors2 = obj11;
                                    textStyle3 = obj15;
                                    label3 = isError4;
                                    minLines3 = singleLine3;
                                    interactionSource3 = maxLines3;
                                    isError3 = z2;
                                    singleLine2 = keyboardOptions2;
                                    maxLines2 = keyboardActions4;
                                    readOnly3 = obj8;
                                } else {
                                    obj2 = obj71;
                                    obj7 = obj72;
                                    i32 = obj73;
                                    i55 = trailingIcon3;
                                    colors2 = obj11;
                                    i9 = prefix2;
                                    textStyle3 = obj15;
                                    i38 = suffix2;
                                    i24 = supportingText2;
                                    i14 = visualTransformation2;
                                    label3 = isError4;
                                    i48 = minLines2;
                                    rememberedValue = interactionSource2;
                                    trailingIcon2 = colors;
                                    isError3 = z2;
                                    minLines3 = singleLine3;
                                    interactionSource3 = maxLines3;
                                    readOnly3 = obj8;
                                    singleLine2 = keyboardOptions2;
                                    maxLines2 = keyboardActions4;
                                }
                            } else {
                                restartGroup.skipToGroupEnd();
                                if ($i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2 & 32 != 0) {
                                    $dirty3 &= i59;
                                }
                                if (i80 &= $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2 != 0) {
                                    $dirty1 &= i6;
                                }
                                if (i81 &= $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2 != 0) {
                                    $dirty2 &= -113;
                                }
                                if ($i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2 & i9 != 0) {
                                    obj2 = placeholder;
                                    obj7 = leadingIcon;
                                    i55 = trailingIcon;
                                    i9 = prefix;
                                    i38 = suffix;
                                    i24 = supportingText;
                                    i14 = visualTransformation;
                                    singleLine2 = keyboardOptions;
                                    maxLines2 = keyboardActions;
                                    minLines3 = singleLine;
                                    interactionSource3 = maxLines;
                                    i48 = minLines;
                                    rememberedValue = interactionSource;
                                    i32 = shape;
                                    trailingIcon2 = colors;
                                    $dirty2 = i84;
                                    isError3 = z2;
                                    colors2 = obj11;
                                    textStyle3 = obj15;
                                    label3 = isError;
                                    readOnly3 = obj8;
                                } else {
                                    obj2 = placeholder;
                                    obj7 = leadingIcon;
                                    i55 = trailingIcon;
                                    i9 = prefix;
                                    i38 = suffix;
                                    i24 = supportingText;
                                    i14 = visualTransformation;
                                    singleLine2 = keyboardOptions;
                                    maxLines2 = keyboardActions;
                                    minLines3 = singleLine;
                                    interactionSource3 = maxLines;
                                    i48 = minLines;
                                    rememberedValue = interactionSource;
                                    i32 = shape;
                                    trailingIcon2 = colors;
                                    isError3 = z2;
                                    colors2 = obj11;
                                    textStyle3 = obj15;
                                    label3 = isError;
                                    readOnly3 = obj8;
                                }
                            }
                        } else {
                        }
                        restartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1570442800, $dirty3, $dirty1, "androidx.compose.material3.OutlinedTextField (OutlinedTextField.kt:368)");
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
                                int i98 = 0;
                                prefix2.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                            } else {
                                $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2 = rememberedValue;
                            }
                            ComposerKt.sourceInformationMarkerEnd(restartGroup);
                            i3 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2;
                        } else {
                            i3 = obj71;
                        }
                        restartGroup.endReplaceGroup();
                        restartGroup.startReplaceGroup(30374434);
                        ComposerKt.sourceInformation(restartGroup, "*374@20549L25");
                        int i91 = 0;
                        i58 = 0;
                        booleanValue = Long.compare(textColor-XeAY9LY$material3_release, i132) != 0 ? 1 : 0;
                        if (booleanValue != 0) {
                        } else {
                            i58 = 0;
                            $this$takeOrElse_u2dDxMtmZc$iv = textColor-XeAY9LY$material3_release;
                        }
                        restartGroup.endReplaceGroup();
                        textStyle2 = new TextStyle($this$takeOrElse_u2dDxMtmZc$iv, i25, 0, i53, 0, 0, 0, 0, 0, 0, obj47, 0, 0, 0, 0, obj52, 0, 0, 0, 0, 0, 0, obj59, 0, 0, 0, 0, 0, 0, 16777214, 0);
                        int i96 = 0;
                        int i104 = 0;
                        ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        ComposerKt.sourceInformationMarkerEnd(restartGroup);
                        androidx.compose.material3.TextFieldColors field2 = trailingIcon2;
                        boolean z4 = obj20;
                        OutlinedTextFieldKt.OutlinedTextField.3 anon = new OutlinedTextFieldKt.OutlinedTextField.3(readOnly3, textStyle3, (Density)restartGroup.consume((CompositionLocal)CompositionLocalsKt.getLocalDensity()), label3, field2, obj13, onValueChange, z4, isError3, colors2.merge(textStyle2), singleLine2, maxLines2, minLines3, interactionSource3, i48, i14, i3, obj2, obj7, i55, i9, i38, i24, i32);
                        CompositionLocalKt.CompositionLocalProvider(TextSelectionColorsKt.getLocalTextSelectionColors().provides(trailingIcon2.getTextSelectionColors()), (Function2)ComposableLambdaKt.rememberComposableLambda(1830921872, true, anon, restartGroup, 54), restartGroup, $stable |= 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mergedTextStyle = obj71;
                        $composer2 = restartGroup;
                        i17 = $dirty3;
                        obj10 = readOnly3;
                        i20 = label3;
                        $composer3 = z4;
                        $dirty = isError3;
                        keyboardActions2 = maxLines2;
                        i37 = minLines3;
                        enabled2 = interactionSource3;
                        readOnly2 = i48;
                        isError2 = i14;
                        i23 = obj2;
                        i33 = obj7;
                        i34 = i55;
                        i61 = i9;
                        modifier2 = i38;
                        placeholder2 = $dirty1;
                        leadingIcon4 = $dirty2;
                        $dirty22 = textStyle3;
                        keyboardActions3 = field2;
                        colors3 = singleLine2;
                        label2 = i24;
                        keyboardOptions3 = i32;
                        $dirty12 = obj72;
                    } else {
                        restartGroup.skipToGroupEnd();
                        i23 = placeholder;
                        i61 = prefix;
                        i20 = isError;
                        colors3 = keyboardOptions;
                        keyboardActions2 = keyboardActions;
                        i37 = singleLine;
                        enabled2 = maxLines;
                        readOnly2 = minLines;
                        mergedTextStyle = interactionSource;
                        keyboardOptions3 = shape;
                        keyboardActions3 = colors;
                        $composer2 = restartGroup;
                        i17 = $dirty3;
                        placeholder2 = $dirty1;
                        leadingIcon4 = $dirty2;
                        obj10 = obj8;
                        $composer3 = obj20;
                        $dirty = z2;
                        $dirty12 = obj11;
                        $dirty22 = obj15;
                        i33 = leadingIcon;
                        i34 = trailingIcon;
                        modifier2 = suffix;
                        label2 = supportingText;
                        isError2 = visualTransformation;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            $composer4 = composer;
            $composer2 = new OutlinedTextFieldKt.OutlinedTextField.4(value, onValueChange, obj10, $composer3, $dirty, $dirty12, $dirty22, i23, i33, i34, i61, modifier2, label2, i20, isError2, colors3, keyboardActions2, i37, enabled2, readOnly2, mergedTextStyle, keyboardOptions3, keyboardActions3, $changed, $changed1, $changed2, i28);
            endRestartGroup.updateScope((Function2)$composer2);
        } else {
            $composer4 = $composer2;
        }
    }

    public static final void OutlinedTextField(String value, Function1<? super String, Unit> onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> label, Function2<? super Composer, ? super Integer, Unit> placeholder, Function2<? super Composer, ? super Integer, Unit> leadingIcon, Function2<? super Composer, ? super Integer, Unit> trailingIcon, Function2<? super Composer, ? super Integer, Unit> prefix, Function2<? super Composer, ? super Integer, Unit> suffix, Function2<? super Composer, ? super Integer, Unit> supportingText, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, int minLines, MutableInteractionSource interactionSource, Shape shape, androidx.compose.material3.TextFieldColors colors, Composer $composer, int $changed, int $changed1, int $changed2, int i28) {
        Object obj8;
        Object obj21;
        Object obj9;
        Object obj19;
        Object obj10;
        Object obj;
        boolean z3;
        Object obj7;
        Object obj5;
        Object obj4;
        boolean z2;
        int i35;
        int i19;
        Object obj15;
        Object obj2;
        Object obj20;
        int skipping;
        int i39;
        int i27;
        Object colors2;
        int defaultsInvalid;
        int this_$iv;
        int placeholder2;
        Composer $composer3;
        int rememberComposableLambda;
        int rememberedValue;
        int leadingIcon3;
        Object leadingIcon4;
        ScopeUpdateScope endRestartGroup;
        Object trailingIcon2;
        int $composer4;
        int trailingIcon3;
        int $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$1;
        int i31;
        Object obj16;
        boolean $composer5;
        int $dirty2;
        boolean $dirty;
        int $dirty1;
        Object $dirty12;
        int $dirty22;
        Object $dirty23;
        Object obj13;
        int i41;
        Object obj11;
        boolean traceInProgress;
        String str;
        int booleanValue;
        int i24;
        boolean obj17;
        int i12;
        int i9;
        Object obj3;
        int i5;
        boolean z;
        Object readOnly2;
        int modifier2;
        Object obj12;
        Object textStyle3;
        int label2;
        int i13;
        int prefix2;
        int i52;
        Object obj6;
        int label3;
        VisualTransformation isError2;
        int suffix2;
        long $this$takeOrElse_u2dDxMtmZc$iv;
        KeyboardOptions colors3;
        int i6;
        int supportingText2;
        KeyboardActions keyboardActions4;
        int i53;
        int visualTransformation2;
        long textColor-XeAY9LY$material3_release;
        int i26;
        int changed3;
        int keyboardOptions3;
        int enabled2;
        int i45;
        int changed2;
        boolean isError3;
        int isError4;
        int readOnly3;
        int i11;
        int keyboardActions3;
        int mergedTextStyle;
        int i51;
        Object singleLine2;
        int singleLine3;
        Shape keyboardOptions2;
        int i65;
        Object maxLines2;
        int maxLines3;
        androidx.compose.material3.TextFieldColors keyboardActions2;
        int minLines2;
        int minLines3;
        int i3;
        int i59;
        int i67;
        int changed6;
        int interactionSource3;
        int interactionSource2;
        int i46;
        int i14;
        Object i62;
        int changed;
        int i29;
        int i47;
        int changed4;
        int obj18;
        int placeholder3;
        int i15;
        int obj14;
        int leadingIcon2;
        int i7;
        int i33;
        Composer $composer2;
        int i2;
        int i;
        int i36;
        int i22;
        int i54;
        Object i64;
        int textStyle2;
        int i48;
        int i30;
        int i61;
        int i20;
        int i42;
        int i4;
        int i16;
        int i21;
        boolean changed5;
        int i8;
        int i25;
        int i17;
        int i63;
        int i34;
        int i58;
        int i49;
        int i18;
        int i55;
        int i68;
        int i40;
        int i37;
        int i57;
        int i43;
        int i56;
        int i10;
        int i38;
        int i23;
        int i44;
        int i32;
        int i66;
        int i60;
        int i50;
        ScopeUpdateScope scopeUpdateScope;
        int obj71;
        int obj72;
        Shape obj73;
        int i69 = $changed;
        int i89 = $changed1;
        $composer4 = $changed2;
        $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$1 = i28;
        Composer restartGroup = $composer.startRestartGroup(-1922450045);
        ComposerKt.sourceInformation(restartGroup, "C(OutlinedTextField)P(21,11,10,1,14,19,6,12,7,20,13,17,18,3,22,5,4,16,8,9,2,15)175@9821L7,191@10625L5,192@10688L8,204@11208L7,206@11308L2853,206@11221L2940:OutlinedTextField.kt#uh7d8r");
        $dirty2 = $changed;
        $dirty1 = $changed1;
        $dirty22 = $changed2;
        if ($i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$1 & 1 != 0) {
            $dirty2 |= 6;
            obj13 = value;
        } else {
            if (i69 & 6 == 0) {
                i9 = restartGroup.changed(value) ? 4 : 2;
                $dirty2 |= i9;
            } else {
                obj13 = value;
            }
        }
        if ($i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$1 & 2 != 0) {
            $dirty2 |= 48;
            obj3 = onValueChange;
        } else {
            if (i69 & 48 == 0) {
                i13 = restartGroup.changedInstance(onValueChange) ? 32 : 16;
                $dirty2 |= i13;
            } else {
                obj3 = onValueChange;
            }
        }
        prefix2 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$1 & 4;
        int i112 = 128;
        if (prefix2 != 0) {
            $dirty2 |= 384;
            obj11 = modifier;
        } else {
            if (i69 & 384 == 0) {
                i6 = restartGroup.changed(modifier) ? 256 : i112;
                $dirty2 |= i6;
            } else {
                obj11 = modifier;
            }
        }
        supportingText2 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$1 & 8;
        changed3 = 1024;
        if (supportingText2 != 0) {
            $dirty2 |= 3072;
            obj17 = enabled;
        } else {
            if (i69 & 3072 == 0) {
                i11 = restartGroup.changed(enabled) ? i53 : changed3;
                $dirty2 |= i11;
            } else {
                obj17 = enabled;
            }
        }
        keyboardActions3 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$1 & 16;
        i65 = 8192;
        if (keyboardActions3 != 0) {
            $dirty2 |= 24576;
            z = readOnly;
        } else {
            if (i69 & 24576 == 0) {
                i3 = restartGroup.changed(readOnly) ? i51 : i65;
                $dirty2 |= i3;
            } else {
                z = readOnly;
            }
        }
        i59 = 196608;
        i14 = 65536;
        if (i69 & i59 == 0) {
            if ($i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$1 & 32 == 0) {
                changed = restartGroup.changed(textStyle) ? 131072 : i14;
            } else {
                obj12 = textStyle;
            }
            $dirty2 |= changed;
        } else {
            obj12 = textStyle;
        }
        int i127 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$1 & 64;
        changed4 = 1572864;
        if (i127 != 0) {
            $dirty2 |= changed4;
            obj6 = label;
        } else {
            if (i69 & changed4 == 0) {
                i7 = restartGroup.changedInstance(label) ? 1048576 : 524288;
                $dirty2 |= i7;
            } else {
                obj6 = label;
            }
        }
        int i70 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$1 & 128;
        i33 = 12582912;
        i2 = 4194304;
        if (i70 != 0) {
            $dirty2 |= i33;
            i = i70;
            obj8 = placeholder;
        } else {
            if ($changed & i33 == 0) {
                i = i70;
                i36 = restartGroup.changedInstance(placeholder) ? 8388608 : i2;
                $dirty2 |= i36;
            } else {
                i = i70;
                obj8 = placeholder;
            }
        }
        int i71 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$1 & 256;
        int i129 = 100663296;
        if (i71 != 0) {
            $dirty2 |= i129;
            i22 = i71;
            obj21 = leadingIcon;
        } else {
            if ($changed & i129 == 0) {
                i22 = i71;
                i54 = restartGroup.changedInstance(leadingIcon) ? 67108864 : 33554432;
                $dirty2 |= i54;
            } else {
                i22 = i71;
                obj21 = leadingIcon;
            }
        }
        int i72 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$1 & 512;
        i64 = 805306368;
        if (i72 != 0) {
            $dirty2 |= i64;
            textStyle2 = i72;
            obj9 = trailingIcon;
        } else {
            if ($changed & i64 == 0) {
                textStyle2 = i72;
                i48 = restartGroup.changedInstance(trailingIcon) ? 536870912 : 268435456;
                $dirty2 |= i48;
            } else {
                textStyle2 = i72;
                obj9 = trailingIcon;
            }
        }
        int i73 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$1 & 1024;
        if (i73 != 0) {
            $dirty1 |= 6;
            i30 = i73;
            obj19 = prefix;
        } else {
            if (i89 & 6 == 0) {
                i30 = i73;
                i61 = restartGroup.changedInstance(prefix) ? 4 : 2;
                $dirty1 |= i61;
            } else {
                i30 = i73;
                obj19 = prefix;
            }
        }
        int i74 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$1 & 2048;
        if (i74 != 0) {
            $dirty1 |= 48;
            i20 = i74;
            obj10 = suffix;
        } else {
            if (i89 & 48 == 0) {
                i20 = i74;
                i42 = restartGroup.changedInstance(suffix) ? 32 : 16;
                $dirty1 |= i42;
            } else {
                i20 = i74;
                obj10 = suffix;
            }
        }
        int i75 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$1 & 4096;
        if (i75 != 0) {
            $dirty1 |= 384;
            i4 = i75;
            obj = supportingText;
        } else {
            i4 = i75;
            if (i89 & 384 == 0) {
                i16 = restartGroup.changedInstance(supportingText) ? 256 : i112;
                $dirty1 |= i16;
            } else {
                obj = supportingText;
            }
        }
        int i77 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$1 & 8192;
        if (i77 != 0) {
            $dirty1 |= 3072;
            i21 = i77;
            z3 = isError;
        } else {
            i21 = i77;
            if (i89 & 3072 == 0) {
                if (restartGroup.changed(isError)) {
                } else {
                    i53 = changed3;
                }
                $dirty1 |= i53;
            } else {
                z3 = isError;
            }
        }
        int i78 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$1 & 16384;
        if (i78 != 0) {
            $dirty1 |= 24576;
            visualTransformation2 = i78;
            obj7 = visualTransformation;
        } else {
            visualTransformation2 = i78;
            if (i89 & 24576 == 0) {
                if (restartGroup.changed(visualTransformation)) {
                } else {
                    i51 = i65;
                }
                $dirty1 |= i51;
            } else {
                obj7 = visualTransformation;
            }
        }
        keyboardOptions3 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$1 & i113;
        if (keyboardOptions3 != 0) {
            $dirty1 |= i59;
            obj5 = keyboardOptions;
        } else {
            if (i89 & i59 == 0) {
                i51 = restartGroup.changed(keyboardOptions) ? 131072 : i14;
                $dirty1 |= i51;
            } else {
                obj5 = keyboardOptions;
            }
        }
        int i115 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$1 & i14;
        if (i115 != 0) {
            $dirty1 |= changed4;
            obj4 = keyboardActions;
        } else {
            if (i89 & changed4 == 0) {
                i65 = restartGroup.changed(keyboardActions) ? 1048576 : 524288;
                $dirty1 |= i65;
            } else {
                obj4 = keyboardActions;
            }
        }
        int i117 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$1 & i116;
        if (i117 != 0) {
            $dirty1 |= i33;
            z2 = singleLine;
        } else {
            if (i89 & i33 == 0) {
                i59 = restartGroup.changed(singleLine) ? 8388608 : i2;
                $dirty1 |= i59;
            } else {
                z2 = singleLine;
            }
        }
        if (i89 & i120 == 0) {
            if ($i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$1 & i121 == 0) {
                i67 = restartGroup.changed(maxLines) ? 67108864 : 33554432;
            } else {
                i35 = maxLines;
            }
            $dirty1 |= i67;
        } else {
            i35 = maxLines;
        }
        interactionSource3 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$1 & i122;
        if (interactionSource3 != 0) {
            $dirty1 |= i64;
            i19 = minLines;
        } else {
            if (i89 & i64 == 0) {
                i14 = restartGroup.changed(minLines) ? 536870912 : 268435456;
                $dirty1 |= i14;
            } else {
                i19 = minLines;
            }
        }
        i62 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$1 & i126;
        if (i62 != 0) {
            $dirty22 |= 6;
            obj15 = interactionSource;
        } else {
            if ($composer4 & 6 == 0) {
                i45 = restartGroup.changed(interactionSource) ? 4 : 2;
                $dirty22 |= i45;
            } else {
                obj15 = interactionSource;
            }
        }
        if ($composer4 & 48 == 0) {
            if ($i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$1 & i114 == 0) {
                minLines2 = restartGroup.changed(shape) ? 32 : 16;
            } else {
                obj2 = shape;
            }
            $dirty22 |= minLines2;
        } else {
            obj2 = shape;
        }
        if ($composer4 & 384 == 0) {
            if ($i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$1 & i2 == 0) {
                i15 = restartGroup.changed(colors) ? 256 : i112;
            } else {
                obj20 = colors;
            }
            $dirty22 |= i15;
        } else {
            obj20 = colors;
        }
        if ($dirty2 & suffix2 == 306783378 && i85 &= $dirty1 == 306783378 && $dirty22 & 147 == 146) {
            if (i85 &= $dirty1 == 306783378) {
                if ($dirty22 & 147 == 146) {
                    if (!restartGroup.getSkipping()) {
                        restartGroup.startDefaults();
                        if ($changed & 1 != 0) {
                            if (restartGroup.getDefaultsInvalid()) {
                                if (prefix2 != 0) {
                                    obj11 = defaultsInvalid;
                                }
                                if (supportingText2 != 0) {
                                    obj17 = defaultsInvalid;
                                }
                                if (keyboardActions3 != 0) {
                                    z = defaultsInvalid;
                                }
                                if ($i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$1 & 32 != 0) {
                                    prefix2 = 6;
                                    suffix2 = 0;
                                    ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                                    $dirty2 &= rememberComposableLambda;
                                    obj12 = this_$iv;
                                }
                                if (i127 != 0) {
                                    obj6 = this_$iv;
                                }
                                placeholder2 = i != 0 ? 0 : placeholder;
                                leadingIcon3 = i22 != 0 ? 0 : leadingIcon;
                                trailingIcon3 = textStyle2 != 0 ? 0 : trailingIcon;
                                prefix2 = i30 != 0 ? 0 : prefix;
                                suffix2 = i20 != 0 ? 0 : suffix;
                                supportingText2 = i4 != 0 ? 0 : supportingText;
                                isError4 = i21 != 0 ? 0 : isError;
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
                                if (i115 != 0) {
                                    keyboardActions3 = KeyboardActions.Companion.getDefault();
                                } else {
                                    keyboardActions3 = keyboardActions;
                                }
                                singleLine3 = i117 != 0 ? 0 : singleLine;
                                if ($i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$1 & i118 != 0) {
                                    maxLines3 = singleLine3 != 0 ? 1 : 0x7fffffff /* Unknown resource */;
                                    $dirty1 &= minLines2;
                                } else {
                                    maxLines3 = maxLines;
                                }
                                minLines3 = interactionSource3 != 0 ? 1 : minLines;
                                interactionSource2 = i62 != 0 ? 0 : interactionSource;
                                obj71 = placeholder2;
                                int placeholder4 = 6;
                                if ($i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$1 & i123 != 0) {
                                    obj72 = leadingIcon3;
                                    leadingIcon4 = OutlinedTextFieldDefaults.INSTANCE.getShape(restartGroup, placeholder4);
                                    $dirty22 &= -113;
                                } else {
                                    obj72 = leadingIcon3;
                                    leadingIcon4 = shape;
                                }
                                if ($i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$1 & i2 != 0) {
                                    obj18 = obj71;
                                    obj14 = obj72;
                                    i64 = obj73;
                                    $dirty22 = i93;
                                    i33 = trailingIcon3;
                                    i2 = prefix2;
                                    i = suffix2;
                                    i22 = supportingText2;
                                    i62 = visualTransformation2;
                                    i46 = minLines3;
                                    rememberedValue = interactionSource2;
                                    trailingIcon2 = colors4;
                                    colors2 = obj12;
                                    textStyle3 = obj6;
                                    label3 = isError4;
                                    minLines2 = singleLine3;
                                    interactionSource3 = maxLines3;
                                    isError3 = z;
                                    singleLine2 = keyboardOptions3;
                                    maxLines2 = keyboardActions3;
                                    readOnly2 = obj11;
                                } else {
                                    obj18 = obj71;
                                    obj14 = obj72;
                                    i64 = obj73;
                                    i33 = trailingIcon3;
                                    colors2 = obj12;
                                    i2 = prefix2;
                                    textStyle3 = obj6;
                                    i = suffix2;
                                    i22 = supportingText2;
                                    i62 = visualTransformation2;
                                    label3 = isError4;
                                    i46 = minLines3;
                                    rememberedValue = interactionSource2;
                                    trailingIcon2 = colors;
                                    isError3 = z;
                                    minLines2 = singleLine3;
                                    interactionSource3 = maxLines3;
                                    readOnly2 = obj11;
                                    singleLine2 = keyboardOptions3;
                                    maxLines2 = keyboardActions3;
                                }
                            } else {
                                restartGroup.skipToGroupEnd();
                                if ($i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$1 & 32 != 0) {
                                    $dirty2 &= i39;
                                }
                                if (i80 &= $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$1 != 0) {
                                    $dirty1 &= i27;
                                }
                                if (i81 &= $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$1 != 0) {
                                    $dirty22 &= -113;
                                }
                                if ($i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$1 & i2 != 0) {
                                    obj18 = placeholder;
                                    obj14 = leadingIcon;
                                    i33 = trailingIcon;
                                    i2 = prefix;
                                    i = suffix;
                                    i22 = supportingText;
                                    i62 = visualTransformation;
                                    singleLine2 = keyboardOptions;
                                    maxLines2 = keyboardActions;
                                    minLines2 = singleLine;
                                    interactionSource3 = maxLines;
                                    i46 = minLines;
                                    rememberedValue = interactionSource;
                                    i64 = shape;
                                    trailingIcon2 = colors;
                                    $dirty22 = i84;
                                    isError3 = z;
                                    colors2 = obj12;
                                    textStyle3 = obj6;
                                    label3 = isError;
                                    readOnly2 = obj11;
                                } else {
                                    obj18 = placeholder;
                                    obj14 = leadingIcon;
                                    i33 = trailingIcon;
                                    i2 = prefix;
                                    i = suffix;
                                    i22 = supportingText;
                                    i62 = visualTransformation;
                                    singleLine2 = keyboardOptions;
                                    maxLines2 = keyboardActions;
                                    minLines2 = singleLine;
                                    interactionSource3 = maxLines;
                                    i46 = minLines;
                                    rememberedValue = interactionSource;
                                    i64 = shape;
                                    trailingIcon2 = colors;
                                    isError3 = z;
                                    colors2 = obj12;
                                    textStyle3 = obj6;
                                    label3 = isError;
                                    readOnly2 = obj11;
                                }
                            }
                        } else {
                        }
                        restartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1922450045, $dirty2, $dirty1, "androidx.compose.material3.OutlinedTextField (OutlinedTextField.kt:193)");
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
                                int i98 = 0;
                                prefix2.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                            } else {
                                $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$1 = rememberedValue;
                            }
                            ComposerKt.sourceInformationMarkerEnd(restartGroup);
                            i29 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$1;
                        } else {
                            i29 = obj71;
                        }
                        restartGroup.endReplaceGroup();
                        restartGroup.startReplaceGroup(30069058);
                        ComposerKt.sourceInformation(restartGroup, "*199@11006L25");
                        int i91 = 0;
                        i31 = 0;
                        booleanValue = Long.compare(textColor-XeAY9LY$material3_release, i132) != 0 ? 1 : 0;
                        if (booleanValue != 0) {
                        } else {
                            i31 = 0;
                            $this$takeOrElse_u2dDxMtmZc$iv = textColor-XeAY9LY$material3_release;
                        }
                        restartGroup.endReplaceGroup();
                        textStyle2 = new TextStyle($this$takeOrElse_u2dDxMtmZc$iv, i20, 0, i21, 0, 0, 0, 0, 0, 0, obj47, 0, 0, 0, 0, obj52, 0, 0, 0, 0, 0, 0, obj59, 0, 0, 0, 0, 0, 0, 16777214, 0);
                        int i96 = 0;
                        int i104 = 0;
                        ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        ComposerKt.sourceInformationMarkerEnd(restartGroup);
                        androidx.compose.material3.TextFieldColors field = trailingIcon2;
                        boolean z4 = obj17;
                        OutlinedTextFieldKt.OutlinedTextField.1 anon = new OutlinedTextFieldKt.OutlinedTextField.1(readOnly2, textStyle3, (Density)restartGroup.consume((CompositionLocal)CompositionLocalsKt.getLocalDensity()), label3, field, obj13, onValueChange, z4, isError3, colors2.merge(textStyle2), singleLine2, maxLines2, minLines2, interactionSource3, i46, i62, i29, obj18, obj14, i33, i2, i, i22, i64);
                        CompositionLocalKt.CompositionLocalProvider(TextSelectionColorsKt.getLocalTextSelectionColors().provides(trailingIcon2.getTextSelectionColors()), (Function2)ComposableLambdaKt.rememberComposableLambda(-1886965181, true, anon, restartGroup, 54), restartGroup, $stable |= 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mergedTextStyle = obj71;
                        $composer3 = restartGroup;
                        i47 = $dirty2;
                        obj16 = readOnly2;
                        i52 = label3;
                        $composer5 = z4;
                        $dirty = isError3;
                        keyboardActions4 = maxLines2;
                        i26 = minLines2;
                        enabled2 = interactionSource3;
                        readOnly3 = i46;
                        isError2 = i62;
                        i41 = obj18;
                        i24 = obj14;
                        i12 = i33;
                        i5 = i2;
                        modifier2 = i;
                        placeholder3 = $dirty1;
                        leadingIcon2 = $dirty22;
                        $dirty23 = textStyle3;
                        keyboardActions2 = field;
                        colors3 = singleLine2;
                        label2 = i22;
                        keyboardOptions2 = i64;
                        $dirty12 = obj72;
                    } else {
                        restartGroup.skipToGroupEnd();
                        i41 = placeholder;
                        i5 = prefix;
                        i52 = isError;
                        colors3 = keyboardOptions;
                        keyboardActions4 = keyboardActions;
                        i26 = singleLine;
                        enabled2 = maxLines;
                        readOnly3 = minLines;
                        mergedTextStyle = interactionSource;
                        keyboardOptions2 = shape;
                        keyboardActions2 = colors;
                        $composer3 = restartGroup;
                        i47 = $dirty2;
                        placeholder3 = $dirty1;
                        leadingIcon2 = $dirty22;
                        obj16 = obj11;
                        $composer5 = obj17;
                        $dirty = z;
                        $dirty12 = obj12;
                        $dirty23 = obj6;
                        i24 = leadingIcon;
                        i12 = trailingIcon;
                        modifier2 = suffix;
                        label2 = supportingText;
                        isError2 = visualTransformation;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        endRestartGroup = $composer3.endRestartGroup();
        if (endRestartGroup != null) {
            $composer2 = composer;
            $composer3 = new OutlinedTextFieldKt.OutlinedTextField.2(value, onValueChange, obj16, $composer5, $dirty, $dirty12, $dirty23, i41, i24, i12, i5, modifier2, label2, i52, isError2, colors3, keyboardActions4, i26, enabled2, readOnly3, mergedTextStyle, keyboardOptions2, keyboardActions2, $changed, $changed1, $changed2, i28);
            endRestartGroup.updateScope((Function2)$composer3);
        } else {
            $composer2 = $composer3;
        }
    }

    public static final void OutlinedTextFieldLayout(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> textField, Function3<? super Modifier, ? super Composer, ? super Integer, Unit> placeholder, Function2<? super Composer, ? super Integer, Unit> label, Function2<? super Composer, ? super Integer, Unit> leading, Function2<? super Composer, ? super Integer, Unit> trailing, Function2<? super Composer, ? super Integer, Unit> prefix, Function2<? super Composer, ? super Integer, Unit> suffix, boolean singleLine, float animationProgress, Function1<? super Size, Unit> onLabelMeasured, Function2<? super Composer, ? super Integer, Unit> container, Function2<? super Composer, ? super Integer, Unit> supporting, PaddingValues paddingValues, Composer $composer, int $changed, int $changed1) {
        int traceInProgress2;
        Object endRestartGroup;
        int i18;
        Object it$iv;
        Object valueOf7;
        Function0 factory$iv$iv$iv6;
        Object valueOf9;
        int heightIn-VpY3zN4$default;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap;
        Object valueOf;
        Object valueOf5;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv5;
        Function0 factory$iv$iv$iv;
        Object obj5;
        Function0 factory$iv$iv;
        boolean valueOf8;
        boolean traceInProgress;
        int i11;
        int i5;
        int i6;
        Integer currentCompositionLocalMap2;
        Object valueOf6;
        Function0 factory$iv$iv$iv4;
        Object valueOf10;
        String $composer$iv2;
        boolean currentCompositionLocalMap6;
        int i19;
        Object then;
        Function0 factory$iv$iv$iv3;
        Composer composer;
        Integer currentCompositionLocalMap7;
        boolean maybeCachedBoxMeasurePolicy3;
        int $i$f$Layout;
        int $i$f$cache;
        Object $composer$iv;
        Integer currentCompositionLocalMap4;
        Composer materialized$iv$iv2;
        float constructor-impl2;
        Composer composer8;
        Object currentCompositionLocalMap3;
        Object materializeModifier;
        Object obj4;
        Object iNSTANCE3;
        Composer composer5;
        int valueOf2;
        Composer composer11;
        Composer composer10;
        Object topStart;
        boolean maybeCachedBoxMeasurePolicy;
        Object materialized$iv$iv;
        float $this$coerceAtLeast_u2dYgX7TsA$iv2;
        float $this$coerceAtLeast_u2dYgX7TsA$iv;
        float constructor-impl;
        Function0 factory$iv$iv$iv7;
        float $this$dp$iv;
        int maybeCachedBoxMeasurePolicy2;
        Integer maybeCachedBoxMeasurePolicy4;
        Object iNSTANCE;
        Object maybeCachedBoxMeasurePolicy5;
        Composer composer12;
        int valueOf4;
        int i20;
        Composer composer7;
        Object currentCompositionLocalMap5;
        Composer restartGroup;
        Modifier maybeCachedBoxMeasurePolicy6;
        int i31;
        int i15;
        int i32;
        int i7;
        int i21;
        int i22;
        int i27;
        int str;
        Composer composer9;
        int valueOf3;
        Object obj6;
        Object obj3;
        int $dirty1;
        int $dirty12;
        int $dirty2;
        int $dirty;
        int i29;
        int i2;
        int i13;
        int i30;
        int i17;
        androidx.compose.material3.OutlinedTextFieldMeasurePolicy field;
        int companion;
        Object obj;
        Modifier $i$f$cache2;
        int currentCompositeKeyHash2;
        int i16;
        Function0 function02;
        int i28;
        Composer composer2;
        int i24;
        Composer composer4;
        int companion2;
        int i23;
        int i25;
        androidx.compose.runtime.CompositionLocalMap localMap$iv;
        Modifier modifier2;
        int i26;
        int i4;
        Function0 function03;
        int layoutDirection;
        int $i$a$LayoutOutlinedTextFieldKt$OutlinedTextFieldLayout$1;
        int currentCompositeKeyHash4;
        int i3;
        Object obj2;
        int currentCompositeKeyHash;
        float f2;
        int $composer2;
        Composer $composer3;
        int i12;
        int currentCompositeKeyHash3;
        float f;
        Modifier modifier3;
        Function0 function0;
        int i10;
        int i14;
        Composer composer3;
        int localMap$iv$iv;
        int i8;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy$iv;
        androidx.compose.runtime.CompositionLocalMap map2;
        Object iNSTANCE2;
        int localMap$iv$iv3;
        androidx.compose.ui.layout.MeasurePolicy localMap$iv$iv2;
        androidx.compose.runtime.CompositionLocalMap map;
        Composer composer6;
        int i9;
        int i;
        ScopeUpdateScope scopeUpdateScope;
        int obj76;
        Object obj7 = modifier;
        $composer$iv = leading;
        materializeModifier = trailing;
        iNSTANCE3 = prefix;
        final Object obj11 = suffix;
        maybeCachedBoxMeasurePolicy = singleLine;
        $this$dp$iv = animationProgress;
        iNSTANCE = onLabelMeasured;
        maybeCachedBoxMeasurePolicy5 = container;
        int i182 = $changed;
        int i33 = $changed1;
        restartGroup = $composer.startRestartGroup(1408290209);
        ComposerKt.sourceInformation(restartGroup, "C(OutlinedTextFieldLayout)P(4,12,7,2,3,13,8,10,9!1,5!1,11)470@24558L267,478@24873L7,479@24885L3739:OutlinedTextField.kt#uh7d8r");
        obj76 = i172;
        if (i182 & 6 == 0) {
            i2 = restartGroup.changed(obj7) ? 4 : 2;
            $dirty2 = obj76 | i2;
        } else {
            $dirty2 = obj76;
        }
        if (i182 & 48 == 0) {
            i30 = restartGroup.changedInstance(textField) ? 32 : 16;
            $dirty2 |= i30;
        }
        if (i182 & 384 == 0) {
            i31 = restartGroup.changedInstance(placeholder) ? 256 : 128;
            $dirty2 |= i31;
        }
        if (i182 & 3072 == 0) {
            i17 = restartGroup.changedInstance(label) ? 2048 : 1024;
            $dirty2 |= i17;
        }
        if (i182 & 24576 == 0) {
            i15 = restartGroup.changedInstance($composer$iv) ? 16384 : 8192;
            $dirty2 |= i15;
        }
        if (i174 &= i182 == 0) {
            i32 = restartGroup.changedInstance(materializeModifier) ? 131072 : 65536;
            $dirty2 |= i32;
        }
        if (i175 &= i182 == 0) {
            i7 = restartGroup.changedInstance(iNSTANCE3) ? 1048576 : 524288;
            $dirty2 |= i7;
        }
        if (i176 &= i182 == 0) {
            i21 = restartGroup.changedInstance(obj11) ? 8388608 : 4194304;
            $dirty2 |= i21;
        }
        if (i177 &= i182 == 0) {
            i22 = restartGroup.changed(maybeCachedBoxMeasurePolicy) ? 67108864 : 33554432;
            $dirty2 |= i22;
        }
        if (i178 &= i182 == 0) {
            i27 = restartGroup.changed($this$dp$iv) ? 536870912 : 268435456;
            $dirty2 |= i27;
        }
        str = $dirty2;
        if (i33 & 6 == 0) {
            $dirty = restartGroup.changedInstance(iNSTANCE) ? 4 : 2;
            $dirty1 |= $dirty;
        }
        if (i33 & 48 == 0) {
            i29 = restartGroup.changedInstance(maybeCachedBoxMeasurePolicy5) ? 32 : 16;
            $dirty1 |= i29;
        }
        if (i33 & 384 == 0) {
            i29 = restartGroup.changedInstance(supporting) ? 256 : 128;
            $dirty1 |= i29;
        } else {
            obj6 = supporting;
        }
        if (i33 & 3072 == 0) {
            i29 = restartGroup.changed(paddingValues) ? 2048 : 1024;
            $dirty1 |= i29;
        } else {
            obj3 = paddingValues;
        }
        traceInProgress2 = $dirty1;
        if (str & $dirty12 == 306783378 && traceInProgress2 & 1171 == 1170) {
            if (traceInProgress2 & 1171 == 1170) {
                if (!restartGroup.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1408290209, str, traceInProgress2, "androidx.compose.material3.OutlinedTextFieldLayout (OutlinedTextField.kt:468)");
                    }
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 602705309, "CC(remember):OutlinedTextField.kt#9igjgp");
                    int i185 = 1;
                    i11 = traceInProgress2 & 14 == 4 ? i185 : 0;
                    i5 = i108 &= str == 67108864 ? i185 : 0;
                    i6 = i110 &= str == 536870912 ? i185 : 0;
                    i13 = traceInProgress2;
                    i18 = traceInProgress2 & 7168 == 2048 ? i185 : 0;
                    Composer composer13 = restartGroup;
                    $i$f$cache = 0;
                    it$iv = composer13.rememberedValue();
                    int i192 = 0;
                    if (i18 |= i82 == 0) {
                        $i$f$cache2 = $i$f$cache;
                        if (it$iv == Composer.Companion.getEmpty()) {
                            $i$f$cache = 0;
                            obj = it$iv;
                            it$iv = new OutlinedTextFieldMeasurePolicy(iNSTANCE, maybeCachedBoxMeasurePolicy, $this$dp$iv, obj3);
                            composer13.updateRememberedValue(it$iv);
                        } else {
                            obj = it$iv;
                        }
                    } else {
                        $i$f$cache2 = $i$f$cache;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    int i191 = 0;
                    int i193 = i113;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    valueOf7 = restartGroup.consume((CompositionLocal)CompositionLocalsKt.getLocalLayoutDirection());
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    companion = i114;
                    $i$f$Layout = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, $i$f$Layout);
                    currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, 0);
                    currentCompositionLocalMap2 = restartGroup.getCurrentCompositionLocalMap();
                    materialized$iv$iv = ComposedModifierKt.materializeModifier(restartGroup, obj7);
                    Function0 function04 = constructor2;
                    i16 = 0;
                    iNSTANCE = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp";
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, iNSTANCE);
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
                    function02 = factory$iv$iv;
                    Composer constructor-impl6 = Updater.constructor-impl(restartGroup);
                    int i195 = 0;
                    composer4 = restartGroup;
                    i23 = str;
                    Updater.set-impl(constructor-impl6, (MeasurePolicy)(OutlinedTextFieldMeasurePolicy)it$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl6, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    valueOf3 = 0;
                    Composer composer20 = constructor-impl6;
                    i25 = 0;
                    if (!composer20.getInserting()) {
                        localMap$iv = currentCompositionLocalMap2;
                        i26 = valueOf3;
                        if (!Intrinsics.areEqual(composer20.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                            composer20.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                            constructor-impl6.apply(Integer.valueOf(currentCompositeKeyHash2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer9 = composer20;
                        }
                    } else {
                        localMap$iv = currentCompositionLocalMap2;
                        i26 = valueOf3;
                    }
                    Updater.set-impl(constructor-impl6, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                    valueOf8 = composer4;
                    maybeCachedBoxMeasurePolicy6 = 0;
                    i24 = i72;
                    ComposerKt.sourceInformationMarkerStart(valueOf8, -828374317, "C482@24954L11,550@27430L186:OutlinedTextField.kt#uh7d8r");
                    maybeCachedBoxMeasurePolicy5.invoke(valueOf8, Integer.valueOf(i73 &= 14));
                    valueOf8.startReplaceGroup(250370369);
                    ComposerKt.sourceInformation(valueOf8, "485@25018L219");
                    str = "C73@3429L9:Box.kt#2w3rfo";
                    companion2 = 48;
                    String str3 = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo";
                    modifier2 = materialized$iv$iv;
                    if ($composer$iv != null) {
                        Modifier then4 = LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Leading").then(TextFieldImplKt.getIconDefaultSizeModifier());
                        Alignment center2 = Alignment.Companion.getCenter();
                        i4 = companion2;
                        layoutDirection = 0;
                        $i$a$LayoutOutlinedTextFieldKt$OutlinedTextFieldLayout$1 = maybeCachedBoxMeasurePolicy6;
                        ComposerKt.sourceInformationMarkerStart(valueOf8, 733328855, str3);
                        int i170 = 0;
                        maybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(center2, i170);
                        i3 = 0;
                        obj2 = center2;
                        ComposerKt.sourceInformationMarkerStart(valueOf8, -1323940314, $i$f$Layout);
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(valueOf8, 0);
                        currentCompositionLocalMap5 = valueOf8.getCurrentCompositionLocalMap();
                        $composer2 = i170;
                        modifier3 = then4;
                        Function0 function010 = constructor7;
                        currentCompositeKeyHash3 = 0;
                        ComposerKt.sourceInformationMarkerStart(valueOf8, -692256719, iNSTANCE);
                        if (!applier8 instanceof Applier) {
                            ComposablesKt.invalidApplier();
                        }
                        valueOf8.startReusableNode();
                        if (valueOf8.getInserting()) {
                            valueOf8.createNode(function010);
                        } else {
                            factory$iv$iv$iv7 = function010;
                            valueOf8.useNode();
                        }
                        function0 = factory$iv$iv$iv7;
                        Composer constructor-impl9 = Updater.constructor-impl(valueOf8);
                        int i217 = 0;
                        Updater.set-impl(constructor-impl9, maybeCachedBoxMeasurePolicy4, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(constructor-impl9, currentCompositionLocalMap5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        int i221 = 0;
                        Composer composer23 = constructor-impl9;
                        int i237 = 0;
                        if (!composer23.getInserting()) {
                            measurePolicy$iv = maybeCachedBoxMeasurePolicy4;
                            map2 = currentCompositionLocalMap5;
                            if (!Intrinsics.areEqual(composer23.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                composer23.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                constructor-impl9.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            } else {
                                composer7 = composer23;
                            }
                        } else {
                            measurePolicy$iv = maybeCachedBoxMeasurePolicy4;
                            map2 = currentCompositionLocalMap5;
                        }
                        Updater.set-impl(constructor-impl9, ComposedModifierKt.materializeModifier(valueOf8, then4), ComposeUiNode.Companion.getSetModifier());
                        Composer composer19 = valueOf8;
                        ComposerKt.sourceInformationMarkerStart(composer19, -2146769399, str);
                        maybeCachedBoxMeasurePolicy5 = BoxScopeInstance.INSTANCE;
                        i219 |= 6;
                        localMap$iv$iv = 0;
                        i8 = i104;
                        localMap$iv$iv3 = i149;
                        $this$dp$iv = composer3;
                        ComposerKt.sourceInformationMarkerStart($this$dp$iv, -367907446, "C489@25210L9:OutlinedTextField.kt#uh7d8r");
                        $composer$iv.invoke($this$dp$iv, Integer.valueOf(i105 &= 14));
                        ComposerKt.sourceInformationMarkerEnd($this$dp$iv);
                        ComposerKt.sourceInformationMarkerEnd(composer19);
                        valueOf8.endNode();
                        ComposerKt.sourceInformationMarkerEnd(valueOf8);
                        ComposerKt.sourceInformationMarkerEnd(valueOf8);
                        ComposerKt.sourceInformationMarkerEnd(valueOf8);
                    } else {
                        $i$a$LayoutOutlinedTextFieldKt$OutlinedTextFieldLayout$1 = maybeCachedBoxMeasurePolicy6;
                    }
                    valueOf8.endReplaceGroup();
                    valueOf8.startReplaceGroup(250379492);
                    ComposerKt.sourceInformation(valueOf8, "493@25304L221");
                    Modifier then2 = LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Trailing").then(TextFieldImplKt.getIconDefaultSizeModifier());
                    Alignment center = Alignment.Companion.getCenter();
                    ComposerKt.sourceInformationMarkerStart(valueOf8, 733328855, str3);
                    valueOf4 = 0;
                    layoutDirection = 0;
                    ComposerKt.sourceInformationMarkerStart(valueOf8, -1323940314, $i$f$Layout);
                    currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(valueOf8, 0);
                    currentCompositionLocalMap4 = valueOf8.getCurrentCompositionLocalMap();
                    i3 = center;
                    Modifier materializeModifier6 = ComposedModifierKt.materializeModifier(valueOf8, then2);
                    currentCompositeKeyHash = then2;
                    Function0 function06 = constructor3;
                    obj2 = 0;
                    ComposerKt.sourceInformationMarkerStart(valueOf8, -692256719, iNSTANCE);
                    if (materializeModifier != null && !applier6 instanceof Applier) {
                        then2 = LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Trailing").then(TextFieldImplKt.getIconDefaultSizeModifier());
                        center = Alignment.Companion.getCenter();
                        ComposerKt.sourceInformationMarkerStart(valueOf8, 733328855, str3);
                        valueOf4 = 0;
                        layoutDirection = 0;
                        ComposerKt.sourceInformationMarkerStart(valueOf8, -1323940314, $i$f$Layout);
                        currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(valueOf8, 0);
                        currentCompositionLocalMap4 = valueOf8.getCurrentCompositionLocalMap();
                        i3 = center;
                        materializeModifier6 = ComposedModifierKt.materializeModifier(valueOf8, then2);
                        currentCompositeKeyHash = then2;
                        function06 = constructor3;
                        obj2 = 0;
                        ComposerKt.sourceInformationMarkerStart(valueOf8, -692256719, iNSTANCE);
                        if (!applier6 instanceof Applier) {
                            ComposablesKt.invalidApplier();
                        }
                        valueOf8.startReusableNode();
                        if (valueOf8.getInserting()) {
                            valueOf8.createNode(function06);
                        } else {
                            factory$iv$iv$iv4 = function06;
                            valueOf8.useNode();
                        }
                        $composer2 = factory$iv$iv$iv4;
                        Composer constructor-impl7 = Updater.constructor-impl(valueOf8);
                        int i206 = 0;
                        i10 = i145;
                        Updater.set-impl(constructor-impl7, BoxKt.maybeCachedBoxMeasurePolicy(center, valueOf4), ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(constructor-impl7, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        int i212 = 0;
                        Composer composer22 = constructor-impl7;
                        int i220 = 0;
                        if (!composer22.getInserting()) {
                            localMap$iv$iv = currentCompositionLocalMap4;
                            i8 = valueOf4;
                            if (!Intrinsics.areEqual(composer22.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                                composer22.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                                constructor-impl7.apply(Integer.valueOf(currentCompositeKeyHash4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            } else {
                                composer12 = composer22;
                            }
                        } else {
                            localMap$iv$iv = currentCompositionLocalMap4;
                            i8 = valueOf4;
                        }
                        Updater.set-impl(constructor-impl7, materializeModifier6, ComposeUiNode.Companion.getSetModifier());
                        Composer composer18 = valueOf8;
                        $this$dp$iv = 0;
                        ComposerKt.sourceInformationMarkerStart(composer18, -2146769399, str);
                        maybeCachedBoxMeasurePolicy5 = BoxScopeInstance.INSTANCE;
                        i208 |= 6;
                        i14 = 0;
                        composer3 = i90;
                        map2 = materializeModifier6;
                        materialized$iv$iv = function0;
                        ComposerKt.sourceInformationMarkerStart(materialized$iv$iv, -367622711, "C497@25497L10:OutlinedTextField.kt#uh7d8r");
                        materializeModifier.invoke(materialized$iv$iv, Integer.valueOf(i91 &= 14));
                        ComposerKt.sourceInformationMarkerEnd(materialized$iv$iv);
                        ComposerKt.sourceInformationMarkerEnd(composer18);
                        valueOf8.endNode();
                        ComposerKt.sourceInformationMarkerEnd(valueOf8);
                        ComposerKt.sourceInformationMarkerEnd(valueOf8);
                        ComposerKt.sourceInformationMarkerEnd(valueOf8);
                    }
                    valueOf8.endReplaceGroup();
                    $composer$iv2 = PaddingKt.calculateStartPadding(obj3, (LayoutDirection)valueOf7);
                    materialized$iv$iv2 = PaddingKt.calculateEndPadding(obj3, valueOf7);
                    if (leading != null) {
                        int i146 = 0;
                        int i153 = 0;
                        maybeCachedBoxMeasurePolicy5 = 0;
                        $this$coerceAtLeast_u2dYgX7TsA$iv2 = Dp.constructor-impl(RangesKt.coerceAtLeast(Dp.constructor-impl($composer$iv2 - horizontalIconPadding), Dp.constructor-impl((float)$i$f$minus5rwHm24)));
                    } else {
                        $this$coerceAtLeast_u2dYgX7TsA$iv2 = $composer$iv2;
                    }
                    i3 = $this$coerceAtLeast_u2dYgX7TsA$iv2;
                    if (materializeModifier != null) {
                        int i148 = 0;
                        int i159 = 0;
                        maybeCachedBoxMeasurePolicy5 = 0;
                        $this$coerceAtLeast_u2dYgX7TsA$iv = Dp.constructor-impl(RangesKt.coerceAtLeast(Dp.constructor-impl(materialized$iv$iv2 - horizontalIconPadding2), Dp.constructor-impl((float)$i$f$minus5rwHm242)));
                    } else {
                        $this$coerceAtLeast_u2dYgX7TsA$iv = materialized$iv$iv2;
                    }
                    valueOf8.startReplaceGroup(250410106);
                    ComposerKt.sourceInformation(valueOf8, "518@26256L309");
                    i20 = 0;
                    if (iNSTANCE3 != null) {
                        layoutDirection = valueOf7;
                        i14 = $composer$iv2;
                        int i101 = 0;
                        Modifier padding-qDBjuR0$default3 = PaddingKt.padding-qDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.heightIn-VpY3zN4$default(LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Prefix"), TextFieldImplKt.getMinTextLineHeight(), 0, 2, i20), i20, i101, 3, i20), i3, 0, TextFieldImplKt.getPrefixSuffixTextPadding(), 0, 10, 0);
                        maybeCachedBoxMeasurePolicy2 = i101;
                        ComposerKt.sourceInformationMarkerStart(valueOf8, 733328855, str3);
                        obj2 = i102;
                        maybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                        $composer2 = 0;
                        composer3 = materialized$iv$iv2;
                        ComposerKt.sourceInformationMarkerStart(valueOf8, -1323940314, $i$f$Layout);
                        currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(valueOf8, 0);
                        currentCompositionLocalMap3 = valueOf8.getCurrentCompositionLocalMap();
                        function0 = padding-qDBjuR0$default3;
                        Function0 function011 = constructor8;
                        modifier3 = 0;
                        ComposerKt.sourceInformationMarkerStart(valueOf8, -692256719, iNSTANCE);
                        if (!applier4 instanceof Applier) {
                            ComposablesKt.invalidApplier();
                        }
                        valueOf8.startReusableNode();
                        if (valueOf8.getInserting()) {
                            valueOf8.createNode(function011);
                        } else {
                            factory$iv$iv$iv = function011;
                            valueOf8.useNode();
                        }
                        i10 = factory$iv$iv$iv;
                        Composer constructor-impl5 = Updater.constructor-impl(valueOf8);
                        int i234 = 0;
                        map2 = $this$coerceAtLeast_u2dYgX7TsA$iv;
                        Updater.set-impl(constructor-impl5, maybeCachedBoxMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(constructor-impl5, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        int i238 = 0;
                        Composer composer27 = constructor-impl5;
                        int i242 = 0;
                        if (!composer27.getInserting()) {
                            localMap$iv$iv2 = maybeCachedBoxMeasurePolicy3;
                            map = currentCompositionLocalMap3;
                            if (!Intrinsics.areEqual(composer27.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                composer27.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                constructor-impl5.apply(Integer.valueOf(currentCompositeKeyHash3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            } else {
                                composer8 = composer27;
                            }
                        } else {
                            localMap$iv$iv2 = maybeCachedBoxMeasurePolicy3;
                            map = currentCompositionLocalMap3;
                        }
                        Updater.set-impl(constructor-impl5, ComposedModifierKt.materializeModifier(valueOf8, padding-qDBjuR0$default3), ComposeUiNode.Companion.getSetModifier());
                        Composer composer17 = valueOf8;
                        ComposerKt.sourceInformationMarkerStart(composer17, -2146769399, str);
                        $this$coerceAtLeast_u2dYgX7TsA$iv = BoxScopeInstance.INSTANCE;
                        i236 |= 6;
                        iNSTANCE2 = 0;
                        localMap$iv$iv3 = i65;
                        i9 = i128;
                        materialized$iv$iv2 = measurePolicy$iv;
                        ComposerKt.sourceInformationMarkerStart(materialized$iv$iv2, -366589109, "C524@26539L8:OutlinedTextField.kt#uh7d8r");
                        iNSTANCE3.invoke(materialized$iv$iv2, Integer.valueOf(i66 &= 14));
                        ComposerKt.sourceInformationMarkerEnd(materialized$iv$iv2);
                        ComposerKt.sourceInformationMarkerEnd(composer17);
                        valueOf8.endNode();
                        ComposerKt.sourceInformationMarkerEnd(valueOf8);
                        ComposerKt.sourceInformationMarkerEnd(valueOf8);
                        ComposerKt.sourceInformationMarkerEnd(valueOf8);
                    } else {
                        layoutDirection = valueOf7;
                        i14 = $composer$iv2;
                        composer3 = materialized$iv$iv2;
                        map2 = $this$coerceAtLeast_u2dYgX7TsA$iv;
                    }
                    valueOf8.endReplaceGroup();
                    valueOf8.startReplaceGroup(250422072);
                    ComposerKt.sourceInformation(valueOf8, "528@26630L307");
                    int i139 = 0;
                    int i118 = 0;
                    Modifier padding-qDBjuR0$default = PaddingKt.padding-qDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.heightIn-VpY3zN4$default(LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Suffix"), TextFieldImplKt.getMinTextLineHeight(), 0, 2, i139), i139, i118, 3, i139), TextFieldImplKt.getPrefixSuffixTextPadding(), 0, map2, 0, 10, 0);
                    int i94 = i118;
                    ComposerKt.sourceInformationMarkerStart(valueOf8, 733328855, str3);
                    Alignment topStart3 = Alignment.Companion.getTopStart();
                    maybeCachedBoxMeasurePolicy6 = 0;
                    ComposerKt.sourceInformationMarkerStart(valueOf8, -1323940314, $i$f$Layout);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(valueOf8, 0);
                    currentCompositionLocalMap6 = valueOf8.getCurrentCompositionLocalMap();
                    $composer2 = i119;
                    Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(valueOf8, padding-qDBjuR0$default);
                    modifier3 = padding-qDBjuR0$default;
                    Function0 function07 = constructor4;
                    currentCompositeKeyHash3 = 0;
                    ComposerKt.sourceInformationMarkerStart(valueOf8, -692256719, iNSTANCE);
                    if (obj11 != null && !applier instanceof Applier) {
                        i139 = 0;
                        i118 = 0;
                        padding-qDBjuR0$default = PaddingKt.padding-qDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.heightIn-VpY3zN4$default(LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Suffix"), TextFieldImplKt.getMinTextLineHeight(), 0, 2, i139), i139, i118, 3, i139), TextFieldImplKt.getPrefixSuffixTextPadding(), 0, map2, 0, 10, 0);
                        i94 = i118;
                        ComposerKt.sourceInformationMarkerStart(valueOf8, 733328855, str3);
                        topStart3 = Alignment.Companion.getTopStart();
                        maybeCachedBoxMeasurePolicy6 = 0;
                        ComposerKt.sourceInformationMarkerStart(valueOf8, -1323940314, $i$f$Layout);
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(valueOf8, 0);
                        currentCompositionLocalMap6 = valueOf8.getCurrentCompositionLocalMap();
                        $composer2 = i119;
                        materializeModifier3 = ComposedModifierKt.materializeModifier(valueOf8, padding-qDBjuR0$default);
                        modifier3 = padding-qDBjuR0$default;
                        function07 = constructor4;
                        currentCompositeKeyHash3 = 0;
                        ComposerKt.sourceInformationMarkerStart(valueOf8, -692256719, iNSTANCE);
                        if (!applier instanceof Applier) {
                            ComposablesKt.invalidApplier();
                        }
                        valueOf8.startReusableNode();
                        if (valueOf8.getInserting()) {
                            valueOf8.createNode(function07);
                        } else {
                            factory$iv$iv$iv6 = function07;
                            valueOf8.useNode();
                        }
                        function0 = factory$iv$iv$iv6;
                        Composer constructor-impl3 = Updater.constructor-impl(valueOf8);
                        int i222 = 0;
                        measurePolicy$iv = topStart3;
                        Updater.set-impl(constructor-impl3, BoxKt.maybeCachedBoxMeasurePolicy(topStart3, false), ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(constructor-impl3, currentCompositionLocalMap6, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        int i231 = 0;
                        Composer composer25 = constructor-impl3;
                        int i240 = 0;
                        if (!composer25.getInserting()) {
                            localMap$iv$iv2 = currentCompositionLocalMap6;
                            if (!Intrinsics.areEqual(composer25.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                composer25.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                constructor-impl3.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            } else {
                                composer5 = composer25;
                            }
                        } else {
                            localMap$iv$iv2 = currentCompositionLocalMap6;
                        }
                        Updater.set-impl(constructor-impl3, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                        Composer composer14 = valueOf8;
                        materializeModifier = 0;
                        ComposerKt.sourceInformationMarkerStart(composer14, -2146769399, str);
                        iNSTANCE3 = BoxScopeInstance.INSTANCE;
                        i224 |= 6;
                        iNSTANCE2 = 0;
                        localMap$iv$iv3 = i39;
                        composer6 = materializeModifier3;
                        materialized$iv$iv2 = i8;
                        ComposerKt.sourceInformationMarkerStart(materialized$iv$iv2, -366220085, "C534@26911L8:OutlinedTextField.kt#uh7d8r");
                        obj11.invoke(materialized$iv$iv2, Integer.valueOf(i40 &= 14));
                        ComposerKt.sourceInformationMarkerEnd(materialized$iv$iv2);
                        ComposerKt.sourceInformationMarkerEnd(composer14);
                        valueOf8.endNode();
                        ComposerKt.sourceInformationMarkerEnd(valueOf8);
                        ComposerKt.sourceInformationMarkerEnd(valueOf8);
                        ComposerKt.sourceInformationMarkerEnd(valueOf8);
                    }
                    valueOf8.endReplaceGroup();
                    constructor-impl = 0;
                    if (prefix == null) {
                        f2 = i3;
                    } else {
                        i19 = 0;
                        f2 = constructor-impl2;
                    }
                    if (obj11 == null) {
                        f = map2;
                    } else {
                        i19 = 0;
                        f = constructor-impl;
                    }
                    Modifier padding-qDBjuR0$default2 = PaddingKt.padding-qDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.heightIn-VpY3zN4$default((Modifier)Modifier.Companion, TextFieldImplKt.getMinTextLineHeight(), 0, 2, constructor-impl), constructor-impl, false, 3, constructor-impl), f2, 0, f, 0, 10, 0);
                    valueOf8.startReplaceGroup(250444361);
                    ComposerKt.sourceInformation(valueOf8, "547@27339L63");
                    if (placeholder != null) {
                        placeholder.invoke(LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Hint").then(padding-qDBjuR0$default2), valueOf8, Integer.valueOf(i121 &= 112));
                    } else {
                        obj4 = placeholder;
                    }
                    valueOf8.endReplaceGroup();
                    Modifier then3 = LayoutIdKt.layoutId((Modifier)Modifier.Companion, "TextField").then(padding-qDBjuR0$default2);
                    int i123 = 384;
                    valueOf2 = i185;
                    maybeCachedBoxMeasurePolicy = 0;
                    ComposerKt.sourceInformationMarkerStart(valueOf8, 733328855, str3);
                    $dirty12 = 0;
                    obj2 = padding-qDBjuR0$default2;
                    ComposerKt.sourceInformationMarkerStart(valueOf8, -1323940314, $i$f$Layout);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(valueOf8, 0);
                    currentCompositionLocalMap = valueOf8.getCurrentCompositionLocalMap();
                    Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(valueOf8, then3);
                    modifier3 = then3;
                    Function0 function08 = constructor5;
                    currentCompositeKeyHash3 = 0;
                    ComposerKt.sourceInformationMarkerStart(valueOf8, -692256719, iNSTANCE);
                    if (!applier7 instanceof Applier) {
                        ComposablesKt.invalidApplier();
                    }
                    valueOf8.startReusableNode();
                    if (valueOf8.getInserting()) {
                        valueOf8.createNode(function08);
                    } else {
                        factory$iv$iv$iv3 = function08;
                        valueOf8.useNode();
                    }
                    function0 = factory$iv$iv$iv3;
                    Composer constructor-impl8 = Updater.constructor-impl(valueOf8);
                    int i225 = 0;
                    Updater.set-impl(constructor-impl8, BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), valueOf2), ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl8, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    int i232 = 0;
                    Composer composer24 = constructor-impl8;
                    int i239 = 0;
                    if (!composer24.getInserting()) {
                        localMap$iv$iv3 = currentCompositionLocalMap;
                        localMap$iv$iv2 = valueOf2;
                        if (!Intrinsics.areEqual(composer24.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            composer24.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            constructor-impl8.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer11 = composer24;
                        }
                    } else {
                        localMap$iv$iv3 = currentCompositionLocalMap;
                        localMap$iv$iv2 = valueOf2;
                    }
                    Updater.set-impl(constructor-impl8, materializeModifier4, ComposeUiNode.Companion.getSetModifier());
                    Composer composer15 = valueOf8;
                    materializeModifier = 0;
                    ComposerKt.sourceInformationMarkerStart(composer15, -2146769399, str);
                    iNSTANCE3 = BoxScopeInstance.INSTANCE;
                    i227 |= 6;
                    measurePolicy$iv = 0;
                    iNSTANCE2 = i44;
                    composer6 = materializeModifier4;
                    $composer$iv = i8;
                    ComposerKt.sourceInformationMarkerStart($composer$iv, -365545432, "C554@27591L11:OutlinedTextField.kt#uh7d8r");
                    textField.invoke($composer$iv, Integer.valueOf(i45 &= 14));
                    ComposerKt.sourceInformationMarkerEnd($composer$iv);
                    ComposerKt.sourceInformationMarkerEnd(composer15);
                    valueOf8.endNode();
                    ComposerKt.sourceInformationMarkerEnd(valueOf8);
                    ComposerKt.sourceInformationMarkerEnd(valueOf8);
                    ComposerKt.sourceInformationMarkerEnd(valueOf8);
                    valueOf8.startReplaceGroup(250455481);
                    ComposerKt.sourceInformation(valueOf8, "558@27667L501");
                    if (label != null) {
                        int i141 = 0;
                        int i157 = 0;
                        Modifier layoutId3 = LayoutIdKt.layoutId(SizeKt.wrapContentHeight$default(SizeKt.heightIn-VpY3zN4$default((Modifier)Modifier.Companion, DpKt.lerp-Md-fbLM(TextFieldImplKt.getMinTextLineHeight(), TextFieldImplKt.getMinFocusedLabelLineHeight(), animationProgress), 0, 2, i141), i141, i157, 3, i141), "Label");
                        int i126 = i157;
                        ComposerKt.sourceInformationMarkerStart(valueOf8, 733328855, str3);
                        topStart = Alignment.Companion.getTopStart();
                        $dirty12 = 0;
                        ComposerKt.sourceInformationMarkerStart(valueOf8, -1323940314, $i$f$Layout);
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(valueOf8, 0);
                        currentCompositionLocalMap7 = valueOf8.getCurrentCompositionLocalMap();
                        Modifier materializeModifier5 = ComposedModifierKt.materializeModifier(valueOf8, layoutId3);
                        modifier3 = layoutId3;
                        Function0 function09 = constructor6;
                        currentCompositeKeyHash3 = 0;
                        ComposerKt.sourceInformationMarkerStart(valueOf8, -692256719, iNSTANCE);
                        if (!applier3 instanceof Applier) {
                            ComposablesKt.invalidApplier();
                        }
                        valueOf8.startReusableNode();
                        if (valueOf8.getInserting()) {
                            valueOf8.createNode(function09);
                        } else {
                            factory$iv$iv$iv5 = function09;
                            valueOf8.useNode();
                        }
                        function0 = factory$iv$iv$iv5;
                        Composer constructor-impl4 = Updater.constructor-impl(valueOf8);
                        int i228 = 0;
                        measurePolicy$iv = i133;
                        Updater.set-impl(constructor-impl4, BoxKt.maybeCachedBoxMeasurePolicy(topStart, false), ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(constructor-impl4, currentCompositionLocalMap7, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        int i233 = 0;
                        Composer composer26 = constructor-impl4;
                        int i241 = 0;
                        if (!composer26.getInserting()) {
                            localMap$iv$iv2 = currentCompositionLocalMap7;
                            map = topStart;
                            if (!Intrinsics.areEqual(composer26.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                composer26.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                constructor-impl4.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            } else {
                                composer10 = composer26;
                            }
                        } else {
                            localMap$iv$iv2 = currentCompositionLocalMap7;
                            map = topStart;
                        }
                        Updater.set-impl(constructor-impl4, materializeModifier5, ComposeUiNode.Companion.getSetModifier());
                        Composer composer16 = valueOf8;
                        materializeModifier = 0;
                        ComposerKt.sourceInformationMarkerStart(composer16, -2146769399, str);
                        iNSTANCE3 = BoxScopeInstance.INSTANCE;
                        i230 |= 6;
                        iNSTANCE2 = 0;
                        localMap$iv$iv3 = i58;
                        i9 = materializeModifier5;
                        $composer$iv = i8;
                        ComposerKt.sourceInformationMarkerStart($composer$iv, -364997972, "C570@28143L7:OutlinedTextField.kt#uh7d8r");
                        label.invoke($composer$iv, Integer.valueOf(i59 &= 14));
                        ComposerKt.sourceInformationMarkerEnd($composer$iv);
                        ComposerKt.sourceInformationMarkerEnd(composer16);
                        valueOf8.endNode();
                        ComposerKt.sourceInformationMarkerEnd(valueOf8);
                        ComposerKt.sourceInformationMarkerEnd(valueOf8);
                        ComposerKt.sourceInformationMarkerEnd(valueOf8);
                    } else {
                        valueOf6 = label;
                        $this$dp$iv = animationProgress;
                    }
                    valueOf8.endReplaceGroup();
                    valueOf8.startReplaceGroup(250473414);
                    ComposerKt.sourceInformation(valueOf8, "575@28238L317");
                    if (supporting != null) {
                        int i140 = 0;
                        Modifier padding = PaddingKt.padding(SizeKt.wrapContentHeight$default(SizeKt.heightIn-VpY3zN4$default(LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Supporting"), TextFieldImplKt.getMinSupportingTextLineHeight(), 0, 2, i140), i140, false, 3, i140), TextFieldDefaults.supportingTextPadding-a9UjIt4$material3_release$default(TextFieldDefaults.INSTANCE, 0, 0, 0, 0, 15, 0));
                        $composer$iv = i187;
                        materializeModifier = 0;
                        ComposerKt.sourceInformationMarkerStart(valueOf8, 733328855, str3);
                        Alignment topStart2 = Alignment.Companion.getTopStart();
                        restartGroup = 0;
                        obj76 = topStart2;
                        ComposerKt.sourceInformationMarkerStart(valueOf8, -1323940314, $i$f$Layout);
                        $dirty12 = currentCompositeKeyHash5;
                        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(valueOf8, padding);
                        $i$f$cache2 = padding;
                        Function0 function05 = constructor;
                        i29 = 0;
                        ComposerKt.sourceInformationMarkerStart(valueOf8, -692256719, iNSTANCE);
                        if (!applier2 instanceof Applier) {
                            ComposablesKt.invalidApplier();
                        }
                        valueOf8.startReusableNode();
                        if (valueOf8.getInserting()) {
                            valueOf8.createNode(function05);
                        } else {
                            factory$iv$iv$iv2 = function05;
                            valueOf8.useNode();
                        }
                        Composer constructor-impl10 = Updater.constructor-impl(valueOf8);
                        int i194 = 0;
                        function03 = factory$iv$iv$iv2;
                        Updater.set-impl(constructor-impl10, BoxKt.maybeCachedBoxMeasurePolicy(topStart2, false), ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(constructor-impl10, valueOf8.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        int i196 = 0;
                        Composer composer21 = constructor-impl10;
                        int i200 = 0;
                        if (!composer21.getInserting()) {
                            $composer2 = valueOf8;
                            if (!Intrinsics.areEqual(composer21.rememberedValue(), Integer.valueOf($dirty12))) {
                                composer21.updateRememberedValue(Integer.valueOf($dirty12));
                                constructor-impl10.apply(Integer.valueOf($dirty12), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            } else {
                                composer = composer21;
                            }
                        } else {
                            $composer2 = valueOf8;
                        }
                        Updater.set-impl(constructor-impl10, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                        valueOf8 = $composer2;
                        valueOf6 = 0;
                        ComposerKt.sourceInformationMarkerStart(valueOf8, -2146769399, str);
                        iNSTANCE = BoxScopeInstance.INSTANCE;
                        i181 |= 6;
                        composer2 = valueOf8;
                        companion2 = 0;
                        i25 = i52;
                        currentCompositeKeyHash4 = materializeModifier2;
                        ComposerKt.sourceInformationMarkerStart(valueOf8, -364618873, "C581@28525L12:OutlinedTextField.kt#uh7d8r");
                        supporting.invoke(valueOf8, Integer.valueOf(i53 &= 14));
                        ComposerKt.sourceInformationMarkerEnd(valueOf8);
                        ComposerKt.sourceInformationMarkerEnd(valueOf8);
                        $composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                    } else {
                        obj5 = supporting;
                        $composer2 = valueOf8;
                    }
                    $composer2.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    composer4.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer4);
                    ComposerKt.sourceInformationMarkerEnd(composer4);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    restartGroup.skipToGroupEnd();
                    obj5 = supporting;
                    i13 = traceInProgress2;
                    composer4 = restartGroup;
                    i23 = str;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer4.endRestartGroup();
        if (endRestartGroup != null) {
            $composer3 = composer4;
            endRestartGroup = new OutlinedTextFieldKt.OutlinedTextFieldLayout.2(modifier, textField, placeholder, label, leading, trailing, prefix, obj11, singleLine, $this$dp$iv, onLabelMeasured, container, obj5, obj3, $changed, $changed1);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        } else {
            $composer3 = composer4;
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
        Placeable.PlacementScope placementScope;
        Placeable placeable;
        int widthOrZero;
        int i4;
        int place$calculateVerticalPosition;
        int i3;
        int place$calculateVerticalPosition2;
        int height;
        int i6;
        int i11;
        int i12;
        int i2;
        int i10;
        int i9;
        int textHorizontalPosition;
        Placeable.PlacementScope placementScope2;
        Placeable placeable2;
        int i8;
        int align;
        int i7;
        int i;
        int i5;
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
            placeable2 = labelPlaceable;
            horizontalIconPadding = 0;
            if (z) {
                widthOrZero = Alignment.Companion.getCenterVertically().align(placeable2.getHeight(), i20);
            } else {
                widthOrZero = roundToInt2;
            }
            if (leadingPlaceable == null) {
                i3 = 0;
            } else {
                i18 *= i6;
            }
            Placeable.PlacementScope.placeRelative$default($this$place, placeable2, place$calculateVerticalPosition + i22, MathHelpersKt.lerp(widthOrZero, -i16, f3), 0, 4, 0);
        }
        if (placeable3 != null) {
            Placeable.PlacementScope.placeRelative$default($this$place, placeable3, TextFieldImplKt.widthOrZero(leadingPlaceable), OutlinedTextFieldKt.place$calculateVerticalPosition(z, i20, roundToInt2, placeable5, placeable3), 0, 4, 0);
        }
        i4 = widthOrZero2 + widthOrZero4;
        placeable = textFieldPlaceable;
        Placeable.PlacementScope.placeRelative$default($this$place, placeable, i4, OutlinedTextFieldKt.place$calculateVerticalPosition(z, i20, roundToInt2, placeable5, placeable), 0, 4, 0);
        if (placeable6 != null) {
            Placeable.PlacementScope.placeRelative$default($this$place, placeable6, i4, OutlinedTextFieldKt.place$calculateVerticalPosition(z, i20, roundToInt2, placeable5, placeable6), 0, 4, 0);
            textHorizontalPosition = i4;
        } else {
            textHorizontalPosition = i4;
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
