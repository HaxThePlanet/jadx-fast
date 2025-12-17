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
        Object obj5;
        Object obj8;
        Object obj3;
        Object obj4;
        Object obj21;
        Object obj17;
        boolean z3;
        Object obj20;
        Object obj15;
        Object obj11;
        boolean z;
        int i62;
        int i50;
        Object obj19;
        Object obj12;
        Object obj6;
        int skipping;
        int i68;
        int i60;
        Object colors2;
        int defaultsInvalid;
        int this_$iv;
        int placeholder2;
        Composer $composer4;
        int rememberComposableLambda;
        int rememberedValue;
        int leadingIcon4;
        Object leadingIcon3;
        ScopeUpdateScope endRestartGroup;
        Object trailingIcon3;
        int $composer2;
        int trailingIcon2;
        int $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2;
        int i40;
        Object obj18;
        boolean $composer5;
        int $dirty;
        boolean $dirty3;
        int $dirty12;
        Object $dirty1;
        int $dirty22;
        Object $dirty2;
        Object obj9;
        int i65;
        Object obj13;
        boolean traceInProgress;
        String str;
        int booleanValue;
        int i39;
        boolean obj;
        int i44;
        int i45;
        Object obj7;
        int i37;
        boolean z2;
        Object readOnly2;
        int modifier2;
        Object obj14;
        Object textStyle2;
        int label2;
        int i48;
        int prefix2;
        int i15;
        Object obj16;
        int label3;
        VisualTransformation isError2;
        int suffix2;
        long $this$takeOrElse_u2dDxMtmZc$iv;
        KeyboardOptions colors3;
        int i34;
        int supportingText2;
        KeyboardActions keyboardActions2;
        int i8;
        int visualTransformation2;
        long textColor-XeAY9LY$material3_release;
        int i61;
        int changed5;
        int keyboardOptions3;
        int enabled2;
        int i33;
        int changed6;
        boolean isError4;
        int isError3;
        int readOnly3;
        int i55;
        int keyboardActions3;
        int mergedTextStyle;
        int i66;
        Object singleLine3;
        int singleLine2;
        Shape keyboardOptions2;
        int i19;
        Object maxLines2;
        int maxLines3;
        androidx.compose.material3.TextFieldColors keyboardActions4;
        int minLines3;
        int minLines2;
        int i67;
        int i53;
        int i20;
        int changed4;
        int interactionSource2;
        int interactionSource3;
        int i24;
        int i29;
        Object i2;
        int changed2;
        int i64;
        int i10;
        int changed3;
        int obj2;
        int placeholder3;
        int i54;
        int obj10;
        int leadingIcon2;
        int i11;
        int i13;
        Composer $composer3;
        int i26;
        int i5;
        int i35;
        int i22;
        int i;
        Object i30;
        int textStyle3;
        int i41;
        int i56;
        int i38;
        int i46;
        int i14;
        int i6;
        int i25;
        int i43;
        boolean changed;
        int i57;
        int i3;
        int i16;
        int i32;
        int i7;
        int i17;
        int i58;
        int i49;
        int i27;
        int i4;
        int i9;
        int i42;
        int i47;
        int i23;
        int i52;
        int i63;
        int i59;
        int i21;
        int i36;
        int i31;
        int i18;
        int i12;
        int i51;
        ScopeUpdateScope scopeUpdateScope;
        int obj71;
        int obj72;
        Shape obj73;
        int i69 = $changed;
        int i89 = $changed1;
        $composer2 = $changed2;
        $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2 = i28;
        Composer restartGroup = $composer.startRestartGroup(-1570442800);
        ComposerKt.sourceInformation(restartGroup, "C(OutlinedTextField)P(21,11,10,1,14,19,6,12,7,20,13,17,18,3,22,5,4,16,8,9,2,15)350@19364L7,366@20168L5,367@20231L8,379@20751L7,381@20851L2858,381@20764L2945:OutlinedTextField.kt#uh7d8r");
        $dirty = $changed;
        $dirty12 = $changed1;
        $dirty22 = $changed2;
        if ($i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2 & 1 != 0) {
            $dirty |= 6;
            obj9 = value;
        } else {
            if (i69 & 6 == 0) {
                i45 = restartGroup.changed(value) ? 4 : 2;
                $dirty |= i45;
            } else {
                obj9 = value;
            }
        }
        if ($i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2 & 2 != 0) {
            $dirty |= 48;
            obj7 = onValueChange;
        } else {
            if (i69 & 48 == 0) {
                i48 = restartGroup.changedInstance(onValueChange) ? 32 : 16;
                $dirty |= i48;
            } else {
                obj7 = onValueChange;
            }
        }
        prefix2 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2 & 4;
        int i112 = 128;
        if (prefix2 != 0) {
            $dirty |= 384;
            obj13 = modifier;
        } else {
            if (i69 & 384 == 0) {
                i34 = restartGroup.changed(modifier) ? 256 : i112;
                $dirty |= i34;
            } else {
                obj13 = modifier;
            }
        }
        supportingText2 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2 & 8;
        changed5 = 1024;
        if (supportingText2 != 0) {
            $dirty |= 3072;
            obj = enabled;
        } else {
            if (i69 & 3072 == 0) {
                i55 = restartGroup.changed(enabled) ? i8 : changed5;
                $dirty |= i55;
            } else {
                obj = enabled;
            }
        }
        keyboardActions3 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2 & 16;
        i19 = 8192;
        if (keyboardActions3 != 0) {
            $dirty |= 24576;
            z2 = readOnly;
        } else {
            if (i69 & 24576 == 0) {
                i67 = restartGroup.changed(readOnly) ? i66 : i19;
                $dirty |= i67;
            } else {
                z2 = readOnly;
            }
        }
        i53 = 196608;
        i29 = 65536;
        if (i69 & i53 == 0) {
            if ($i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2 & 32 == 0) {
                changed2 = restartGroup.changed(textStyle) ? 131072 : i29;
            } else {
                obj14 = textStyle;
            }
            $dirty |= changed2;
        } else {
            obj14 = textStyle;
        }
        int i127 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2 & 64;
        changed3 = 1572864;
        if (i127 != 0) {
            $dirty |= changed3;
            obj16 = label;
        } else {
            if (i69 & changed3 == 0) {
                i11 = restartGroup.changedInstance(label) ? 1048576 : 524288;
                $dirty |= i11;
            } else {
                obj16 = label;
            }
        }
        int i70 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2 & 128;
        i13 = 12582912;
        i26 = 4194304;
        if (i70 != 0) {
            $dirty |= i13;
            i5 = i70;
            obj5 = placeholder;
        } else {
            if ($changed & i13 == 0) {
                i5 = i70;
                i35 = restartGroup.changedInstance(placeholder) ? 8388608 : i26;
                $dirty |= i35;
            } else {
                i5 = i70;
                obj5 = placeholder;
            }
        }
        int i71 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2 & 256;
        int i129 = 100663296;
        if (i71 != 0) {
            $dirty |= i129;
            i22 = i71;
            obj8 = leadingIcon;
        } else {
            if ($changed & i129 == 0) {
                i22 = i71;
                i = restartGroup.changedInstance(leadingIcon) ? 67108864 : 33554432;
                $dirty |= i;
            } else {
                i22 = i71;
                obj8 = leadingIcon;
            }
        }
        int i72 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2 & 512;
        i30 = 805306368;
        if (i72 != 0) {
            $dirty |= i30;
            textStyle3 = i72;
            obj3 = trailingIcon;
        } else {
            if ($changed & i30 == 0) {
                textStyle3 = i72;
                i41 = restartGroup.changedInstance(trailingIcon) ? 536870912 : 268435456;
                $dirty |= i41;
            } else {
                textStyle3 = i72;
                obj3 = trailingIcon;
            }
        }
        int i73 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2 & 1024;
        if (i73 != 0) {
            $dirty12 |= 6;
            i56 = i73;
            obj4 = prefix;
        } else {
            if (i89 & 6 == 0) {
                i56 = i73;
                i38 = restartGroup.changedInstance(prefix) ? 4 : 2;
                $dirty12 |= i38;
            } else {
                i56 = i73;
                obj4 = prefix;
            }
        }
        int i74 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2 & 2048;
        if (i74 != 0) {
            $dirty12 |= 48;
            i46 = i74;
            obj21 = suffix;
        } else {
            if (i89 & 48 == 0) {
                i46 = i74;
                i14 = restartGroup.changedInstance(suffix) ? 32 : 16;
                $dirty12 |= i14;
            } else {
                i46 = i74;
                obj21 = suffix;
            }
        }
        int i75 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2 & 4096;
        if (i75 != 0) {
            $dirty12 |= 384;
            i6 = i75;
            obj17 = supportingText;
        } else {
            i6 = i75;
            if (i89 & 384 == 0) {
                i25 = restartGroup.changedInstance(supportingText) ? 256 : i112;
                $dirty12 |= i25;
            } else {
                obj17 = supportingText;
            }
        }
        int i77 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2 & 8192;
        if (i77 != 0) {
            $dirty12 |= 3072;
            i43 = i77;
            z3 = isError;
        } else {
            i43 = i77;
            if (i89 & 3072 == 0) {
                if (restartGroup.changed(isError)) {
                } else {
                    i8 = changed5;
                }
                $dirty12 |= i8;
            } else {
                z3 = isError;
            }
        }
        int i78 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2 & 16384;
        if (i78 != 0) {
            $dirty12 |= 24576;
            visualTransformation2 = i78;
            obj20 = visualTransformation;
        } else {
            visualTransformation2 = i78;
            if (i89 & 24576 == 0) {
                if (restartGroup.changed(visualTransformation)) {
                } else {
                    i66 = i19;
                }
                $dirty12 |= i66;
            } else {
                obj20 = visualTransformation;
            }
        }
        keyboardOptions3 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2 & i113;
        if (keyboardOptions3 != 0) {
            $dirty12 |= i53;
            obj15 = keyboardOptions;
        } else {
            if (i89 & i53 == 0) {
                i66 = restartGroup.changed(keyboardOptions) ? 131072 : i29;
                $dirty12 |= i66;
            } else {
                obj15 = keyboardOptions;
            }
        }
        int i115 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2 & i29;
        if (i115 != 0) {
            $dirty12 |= changed3;
            obj11 = keyboardActions;
        } else {
            if (i89 & changed3 == 0) {
                i19 = restartGroup.changed(keyboardActions) ? 1048576 : 524288;
                $dirty12 |= i19;
            } else {
                obj11 = keyboardActions;
            }
        }
        int i117 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2 & i116;
        if (i117 != 0) {
            $dirty12 |= i13;
            z = singleLine;
        } else {
            if (i89 & i13 == 0) {
                i53 = restartGroup.changed(singleLine) ? 8388608 : i26;
                $dirty12 |= i53;
            } else {
                z = singleLine;
            }
        }
        if (i89 & i120 == 0) {
            if ($i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2 & i121 == 0) {
                i20 = restartGroup.changed(maxLines) ? 67108864 : 33554432;
            } else {
                i62 = maxLines;
            }
            $dirty12 |= i20;
        } else {
            i62 = maxLines;
        }
        interactionSource2 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2 & i122;
        if (interactionSource2 != 0) {
            $dirty12 |= i30;
            i50 = minLines;
        } else {
            if (i89 & i30 == 0) {
                i29 = restartGroup.changed(minLines) ? 536870912 : 268435456;
                $dirty12 |= i29;
            } else {
                i50 = minLines;
            }
        }
        i2 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2 & i126;
        if (i2 != 0) {
            $dirty22 |= 6;
            obj19 = interactionSource;
        } else {
            if ($composer2 & 6 == 0) {
                i33 = restartGroup.changed(interactionSource) ? 4 : 2;
                $dirty22 |= i33;
            } else {
                obj19 = interactionSource;
            }
        }
        if ($composer2 & 48 == 0) {
            if ($i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2 & i114 == 0) {
                minLines3 = restartGroup.changed(shape) ? 32 : 16;
            } else {
                obj12 = shape;
            }
            $dirty22 |= minLines3;
        } else {
            obj12 = shape;
        }
        if ($composer2 & 384 == 0) {
            if ($i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2 & i26 == 0) {
                i54 = restartGroup.changed(colors) ? 256 : i112;
            } else {
                obj6 = colors;
            }
            $dirty22 |= i54;
        } else {
            obj6 = colors;
        }
        if ($dirty & suffix2 == 306783378 && i85 &= $dirty12 == 306783378 && $dirty22 & 147 == 146) {
            if (i85 &= $dirty12 == 306783378) {
                if ($dirty22 & 147 == 146) {
                    if (!restartGroup.getSkipping()) {
                        restartGroup.startDefaults();
                        if ($changed & 1 != 0) {
                            if (restartGroup.getDefaultsInvalid()) {
                                if (prefix2 != 0) {
                                    obj13 = defaultsInvalid;
                                }
                                if (supportingText2 != 0) {
                                    obj = defaultsInvalid;
                                }
                                if (keyboardActions3 != 0) {
                                    z2 = defaultsInvalid;
                                }
                                if ($i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2 & 32 != 0) {
                                    prefix2 = 6;
                                    suffix2 = 0;
                                    ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                                    $dirty &= rememberComposableLambda;
                                    obj14 = this_$iv;
                                }
                                if (i127 != 0) {
                                    obj16 = this_$iv;
                                }
                                placeholder2 = i5 != 0 ? 0 : placeholder;
                                leadingIcon4 = i22 != 0 ? 0 : leadingIcon;
                                trailingIcon2 = textStyle3 != 0 ? 0 : trailingIcon;
                                prefix2 = i56 != 0 ? 0 : prefix;
                                suffix2 = i46 != 0 ? 0 : suffix;
                                supportingText2 = i6 != 0 ? 0 : supportingText;
                                isError3 = i43 != 0 ? 0 : isError;
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
                                singleLine2 = i117 != 0 ? 0 : singleLine;
                                if ($i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2 & i118 != 0) {
                                    maxLines3 = singleLine2 != 0 ? 1 : 0x7fffffff /* Unknown resource */;
                                    $dirty12 &= minLines3;
                                } else {
                                    maxLines3 = maxLines;
                                }
                                minLines2 = interactionSource2 != 0 ? 1 : minLines;
                                interactionSource3 = i2 != 0 ? 0 : interactionSource;
                                obj71 = placeholder2;
                                int placeholder4 = 6;
                                if ($i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2 & i123 != 0) {
                                    obj72 = leadingIcon4;
                                    leadingIcon3 = OutlinedTextFieldDefaults.INSTANCE.getShape(restartGroup, placeholder4);
                                    $dirty22 &= -113;
                                } else {
                                    obj72 = leadingIcon4;
                                    leadingIcon3 = shape;
                                }
                                if ($i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2 & i26 != 0) {
                                    obj2 = obj71;
                                    obj10 = obj72;
                                    i30 = obj73;
                                    $dirty22 = i93;
                                    i13 = trailingIcon2;
                                    i26 = prefix2;
                                    i5 = suffix2;
                                    i22 = supportingText2;
                                    i2 = visualTransformation2;
                                    i24 = minLines2;
                                    rememberedValue = interactionSource3;
                                    trailingIcon3 = colors4;
                                    colors2 = obj14;
                                    textStyle2 = obj16;
                                    label3 = isError3;
                                    minLines3 = singleLine2;
                                    interactionSource2 = maxLines3;
                                    isError4 = z2;
                                    singleLine3 = keyboardOptions3;
                                    maxLines2 = keyboardActions3;
                                    readOnly2 = obj13;
                                } else {
                                    obj2 = obj71;
                                    obj10 = obj72;
                                    i30 = obj73;
                                    i13 = trailingIcon2;
                                    colors2 = obj14;
                                    i26 = prefix2;
                                    textStyle2 = obj16;
                                    i5 = suffix2;
                                    i22 = supportingText2;
                                    i2 = visualTransformation2;
                                    label3 = isError3;
                                    i24 = minLines2;
                                    rememberedValue = interactionSource3;
                                    trailingIcon3 = colors;
                                    isError4 = z2;
                                    minLines3 = singleLine2;
                                    interactionSource2 = maxLines3;
                                    readOnly2 = obj13;
                                    singleLine3 = keyboardOptions3;
                                    maxLines2 = keyboardActions3;
                                }
                            } else {
                                restartGroup.skipToGroupEnd();
                                if ($i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2 & 32 != 0) {
                                    $dirty &= i68;
                                }
                                if (i80 &= $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2 != 0) {
                                    $dirty12 &= i60;
                                }
                                if (i81 &= $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2 != 0) {
                                    $dirty22 &= -113;
                                }
                                if ($i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2 & i26 != 0) {
                                    obj2 = placeholder;
                                    obj10 = leadingIcon;
                                    i13 = trailingIcon;
                                    i26 = prefix;
                                    i5 = suffix;
                                    i22 = supportingText;
                                    i2 = visualTransformation;
                                    singleLine3 = keyboardOptions;
                                    maxLines2 = keyboardActions;
                                    minLines3 = singleLine;
                                    interactionSource2 = maxLines;
                                    i24 = minLines;
                                    rememberedValue = interactionSource;
                                    i30 = shape;
                                    trailingIcon3 = colors;
                                    $dirty22 = i84;
                                    isError4 = z2;
                                    colors2 = obj14;
                                    textStyle2 = obj16;
                                    label3 = isError;
                                    readOnly2 = obj13;
                                } else {
                                    obj2 = placeholder;
                                    obj10 = leadingIcon;
                                    i13 = trailingIcon;
                                    i26 = prefix;
                                    i5 = suffix;
                                    i22 = supportingText;
                                    i2 = visualTransformation;
                                    singleLine3 = keyboardOptions;
                                    maxLines2 = keyboardActions;
                                    minLines3 = singleLine;
                                    interactionSource2 = maxLines;
                                    i24 = minLines;
                                    rememberedValue = interactionSource;
                                    i30 = shape;
                                    trailingIcon3 = colors;
                                    isError4 = z2;
                                    colors2 = obj14;
                                    textStyle2 = obj16;
                                    label3 = isError;
                                    readOnly2 = obj13;
                                }
                            }
                        } else {
                        }
                        restartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1570442800, $dirty, $dirty12, "androidx.compose.material3.OutlinedTextField (OutlinedTextField.kt:368)");
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
                            i64 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$2;
                        } else {
                            i64 = obj71;
                        }
                        restartGroup.endReplaceGroup();
                        restartGroup.startReplaceGroup(30374434);
                        ComposerKt.sourceInformation(restartGroup, "*374@20549L25");
                        int i91 = 0;
                        i40 = 0;
                        booleanValue = Long.compare(textColor-XeAY9LY$material3_release, i132) != 0 ? 1 : 0;
                        if (booleanValue != 0) {
                        } else {
                            i40 = 0;
                            $this$takeOrElse_u2dDxMtmZc$iv = textColor-XeAY9LY$material3_release;
                        }
                        restartGroup.endReplaceGroup();
                        textStyle3 = new TextStyle($this$takeOrElse_u2dDxMtmZc$iv, i46, 0, i43, 0, 0, 0, 0, 0, 0, obj47, 0, 0, 0, 0, obj52, 0, 0, 0, 0, 0, 0, obj59, 0, 0, 0, 0, 0, 0, 16777214, 0);
                        int i96 = 0;
                        int i104 = 0;
                        ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        ComposerKt.sourceInformationMarkerEnd(restartGroup);
                        androidx.compose.material3.TextFieldColors field2 = trailingIcon3;
                        boolean z4 = obj;
                        OutlinedTextFieldKt.OutlinedTextField.3 anon = new OutlinedTextFieldKt.OutlinedTextField.3(readOnly2, textStyle2, (Density)restartGroup.consume((CompositionLocal)CompositionLocalsKt.getLocalDensity()), label3, field2, obj9, onValueChange, z4, isError4, colors2.merge(textStyle3), singleLine3, maxLines2, minLines3, interactionSource2, i24, i2, i64, obj2, obj10, i13, i26, i5, i22, i30);
                        CompositionLocalKt.CompositionLocalProvider(TextSelectionColorsKt.getLocalTextSelectionColors().provides(trailingIcon3.getTextSelectionColors()), (Function2)ComposableLambdaKt.rememberComposableLambda(1830921872, true, anon, restartGroup, 54), restartGroup, $stable |= 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mergedTextStyle = obj71;
                        $composer4 = restartGroup;
                        i10 = $dirty;
                        obj18 = readOnly2;
                        i15 = label3;
                        $composer5 = z4;
                        $dirty3 = isError4;
                        keyboardActions2 = maxLines2;
                        i61 = minLines3;
                        enabled2 = interactionSource2;
                        readOnly3 = i24;
                        isError2 = i2;
                        i65 = obj2;
                        i39 = obj10;
                        i44 = i13;
                        i37 = i26;
                        modifier2 = i5;
                        placeholder3 = $dirty12;
                        leadingIcon2 = $dirty22;
                        $dirty2 = textStyle2;
                        keyboardActions4 = field2;
                        colors3 = singleLine3;
                        label2 = i22;
                        keyboardOptions2 = i30;
                        $dirty1 = obj72;
                    } else {
                        restartGroup.skipToGroupEnd();
                        i65 = placeholder;
                        i37 = prefix;
                        i15 = isError;
                        colors3 = keyboardOptions;
                        keyboardActions2 = keyboardActions;
                        i61 = singleLine;
                        enabled2 = maxLines;
                        readOnly3 = minLines;
                        mergedTextStyle = interactionSource;
                        keyboardOptions2 = shape;
                        keyboardActions4 = colors;
                        $composer4 = restartGroup;
                        i10 = $dirty;
                        placeholder3 = $dirty12;
                        leadingIcon2 = $dirty22;
                        obj18 = obj13;
                        $composer5 = obj;
                        $dirty3 = z2;
                        $dirty1 = obj14;
                        $dirty2 = obj16;
                        i39 = leadingIcon;
                        i44 = trailingIcon;
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
        endRestartGroup = $composer4.endRestartGroup();
        if (endRestartGroup != null) {
            $composer3 = composer;
            $composer4 = new OutlinedTextFieldKt.OutlinedTextField.4(value, onValueChange, obj18, $composer5, $dirty3, $dirty1, $dirty2, i65, i39, i44, i37, modifier2, label2, i15, isError2, colors3, keyboardActions2, i61, enabled2, readOnly3, mergedTextStyle, keyboardOptions2, keyboardActions4, $changed, $changed1, $changed2, i28);
            endRestartGroup.updateScope((Function2)$composer4);
        } else {
            $composer3 = $composer4;
        }
    }

    public static final void OutlinedTextField(String value, Function1<? super String, Unit> onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> label, Function2<? super Composer, ? super Integer, Unit> placeholder, Function2<? super Composer, ? super Integer, Unit> leadingIcon, Function2<? super Composer, ? super Integer, Unit> trailingIcon, Function2<? super Composer, ? super Integer, Unit> prefix, Function2<? super Composer, ? super Integer, Unit> suffix, Function2<? super Composer, ? super Integer, Unit> supportingText, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, int minLines, MutableInteractionSource interactionSource, Shape shape, androidx.compose.material3.TextFieldColors colors, Composer $composer, int $changed, int $changed1, int $changed2, int i28) {
        Object obj3;
        Object obj11;
        Object obj5;
        Object obj15;
        Object obj6;
        Object obj18;
        boolean z3;
        Object obj19;
        Object obj17;
        Object obj12;
        boolean z2;
        int i25;
        int i51;
        Object obj7;
        Object obj;
        Object obj4;
        int skipping;
        int i35;
        int i40;
        Object colors3;
        int defaultsInvalid;
        int this_$iv;
        int placeholder3;
        Composer $composer4;
        int rememberComposableLambda;
        int rememberedValue;
        int leadingIcon4;
        Object leadingIcon2;
        ScopeUpdateScope endRestartGroup;
        Object trailingIcon2;
        int $composer5;
        int trailingIcon3;
        int $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$1;
        int i55;
        Object obj10;
        boolean $composer3;
        int $dirty;
        boolean $dirty3;
        int $dirty1;
        Object $dirty12;
        int $dirty2;
        Object $dirty22;
        Object obj13;
        int i29;
        Object obj14;
        boolean traceInProgress;
        String str;
        int booleanValue;
        int i57;
        boolean obj21;
        int i30;
        int i3;
        Object obj2;
        int i14;
        boolean z;
        Object readOnly3;
        int modifier2;
        Object obj20;
        Object textStyle2;
        int label3;
        int i12;
        int prefix2;
        int i20;
        Object obj8;
        int label2;
        VisualTransformation isError4;
        int suffix2;
        long $this$takeOrElse_u2dDxMtmZc$iv;
        KeyboardOptions colors2;
        int i33;
        int supportingText2;
        KeyboardActions keyboardActions4;
        int i54;
        int visualTransformation2;
        long textColor-XeAY9LY$material3_release;
        int i38;
        int changed3;
        int keyboardOptions2;
        int enabled2;
        int i21;
        int changed;
        boolean isError2;
        int isError3;
        int readOnly2;
        int i43;
        int keyboardActions2;
        int mergedTextStyle;
        int i34;
        Object singleLine3;
        int singleLine2;
        Shape keyboardOptions3;
        int i10;
        Object maxLines3;
        int maxLines2;
        androidx.compose.material3.TextFieldColors keyboardActions3;
        int minLines2;
        int minLines3;
        int i48;
        int i24;
        int i67;
        int changed4;
        int interactionSource2;
        int interactionSource3;
        int i53;
        int i63;
        Object i26;
        int changed5;
        int i56;
        int i27;
        int changed6;
        int obj16;
        int placeholder2;
        int i22;
        int obj9;
        int leadingIcon3;
        int i18;
        int i64;
        Composer $composer2;
        int i36;
        int i13;
        int i45;
        int i61;
        int i6;
        Object i11;
        int textStyle3;
        int i65;
        int i15;
        int i44;
        int i;
        int i8;
        int i23;
        int i58;
        int i46;
        boolean changed2;
        int i68;
        int i7;
        int i4;
        int i59;
        int i17;
        int i42;
        int i19;
        int i39;
        int i66;
        int i60;
        int i62;
        int i52;
        int i5;
        int i37;
        int i49;
        int i31;
        int i32;
        int i47;
        int i9;
        int i41;
        int i50;
        int i16;
        int i2;
        ScopeUpdateScope scopeUpdateScope;
        int obj71;
        int obj72;
        Shape obj73;
        int i69 = $changed;
        int i89 = $changed1;
        $composer5 = $changed2;
        $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$1 = i28;
        Composer restartGroup = $composer.startRestartGroup(-1922450045);
        ComposerKt.sourceInformation(restartGroup, "C(OutlinedTextField)P(21,11,10,1,14,19,6,12,7,20,13,17,18,3,22,5,4,16,8,9,2,15)175@9821L7,191@10625L5,192@10688L8,204@11208L7,206@11308L2853,206@11221L2940:OutlinedTextField.kt#uh7d8r");
        $dirty = $changed;
        $dirty1 = $changed1;
        $dirty2 = $changed2;
        if ($i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$1 & 1 != 0) {
            $dirty |= 6;
            obj13 = value;
        } else {
            if (i69 & 6 == 0) {
                i3 = restartGroup.changed(value) ? 4 : 2;
                $dirty |= i3;
            } else {
                obj13 = value;
            }
        }
        if ($i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$1 & 2 != 0) {
            $dirty |= 48;
            obj2 = onValueChange;
        } else {
            if (i69 & 48 == 0) {
                i12 = restartGroup.changedInstance(onValueChange) ? 32 : 16;
                $dirty |= i12;
            } else {
                obj2 = onValueChange;
            }
        }
        prefix2 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$1 & 4;
        int i112 = 128;
        if (prefix2 != 0) {
            $dirty |= 384;
            obj14 = modifier;
        } else {
            if (i69 & 384 == 0) {
                i33 = restartGroup.changed(modifier) ? 256 : i112;
                $dirty |= i33;
            } else {
                obj14 = modifier;
            }
        }
        supportingText2 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$1 & 8;
        changed3 = 1024;
        if (supportingText2 != 0) {
            $dirty |= 3072;
            obj21 = enabled;
        } else {
            if (i69 & 3072 == 0) {
                i43 = restartGroup.changed(enabled) ? i54 : changed3;
                $dirty |= i43;
            } else {
                obj21 = enabled;
            }
        }
        keyboardActions2 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$1 & 16;
        i10 = 8192;
        if (keyboardActions2 != 0) {
            $dirty |= 24576;
            z = readOnly;
        } else {
            if (i69 & 24576 == 0) {
                i48 = restartGroup.changed(readOnly) ? i34 : i10;
                $dirty |= i48;
            } else {
                z = readOnly;
            }
        }
        i24 = 196608;
        i63 = 65536;
        if (i69 & i24 == 0) {
            if ($i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$1 & 32 == 0) {
                changed5 = restartGroup.changed(textStyle) ? 131072 : i63;
            } else {
                obj20 = textStyle;
            }
            $dirty |= changed5;
        } else {
            obj20 = textStyle;
        }
        int i127 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$1 & 64;
        changed6 = 1572864;
        if (i127 != 0) {
            $dirty |= changed6;
            obj8 = label;
        } else {
            if (i69 & changed6 == 0) {
                i18 = restartGroup.changedInstance(label) ? 1048576 : 524288;
                $dirty |= i18;
            } else {
                obj8 = label;
            }
        }
        int i70 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$1 & 128;
        i64 = 12582912;
        i36 = 4194304;
        if (i70 != 0) {
            $dirty |= i64;
            i13 = i70;
            obj3 = placeholder;
        } else {
            if ($changed & i64 == 0) {
                i13 = i70;
                i45 = restartGroup.changedInstance(placeholder) ? 8388608 : i36;
                $dirty |= i45;
            } else {
                i13 = i70;
                obj3 = placeholder;
            }
        }
        int i71 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$1 & 256;
        int i129 = 100663296;
        if (i71 != 0) {
            $dirty |= i129;
            i61 = i71;
            obj11 = leadingIcon;
        } else {
            if ($changed & i129 == 0) {
                i61 = i71;
                i6 = restartGroup.changedInstance(leadingIcon) ? 67108864 : 33554432;
                $dirty |= i6;
            } else {
                i61 = i71;
                obj11 = leadingIcon;
            }
        }
        int i72 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$1 & 512;
        i11 = 805306368;
        if (i72 != 0) {
            $dirty |= i11;
            textStyle3 = i72;
            obj5 = trailingIcon;
        } else {
            if ($changed & i11 == 0) {
                textStyle3 = i72;
                i65 = restartGroup.changedInstance(trailingIcon) ? 536870912 : 268435456;
                $dirty |= i65;
            } else {
                textStyle3 = i72;
                obj5 = trailingIcon;
            }
        }
        int i73 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$1 & 1024;
        if (i73 != 0) {
            $dirty1 |= 6;
            i15 = i73;
            obj15 = prefix;
        } else {
            if (i89 & 6 == 0) {
                i15 = i73;
                i44 = restartGroup.changedInstance(prefix) ? 4 : 2;
                $dirty1 |= i44;
            } else {
                i15 = i73;
                obj15 = prefix;
            }
        }
        int i74 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$1 & 2048;
        if (i74 != 0) {
            $dirty1 |= 48;
            i = i74;
            obj6 = suffix;
        } else {
            if (i89 & 48 == 0) {
                i = i74;
                i8 = restartGroup.changedInstance(suffix) ? 32 : 16;
                $dirty1 |= i8;
            } else {
                i = i74;
                obj6 = suffix;
            }
        }
        int i75 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$1 & 4096;
        if (i75 != 0) {
            $dirty1 |= 384;
            i23 = i75;
            obj18 = supportingText;
        } else {
            i23 = i75;
            if (i89 & 384 == 0) {
                i58 = restartGroup.changedInstance(supportingText) ? 256 : i112;
                $dirty1 |= i58;
            } else {
                obj18 = supportingText;
            }
        }
        int i77 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$1 & 8192;
        if (i77 != 0) {
            $dirty1 |= 3072;
            i46 = i77;
            z3 = isError;
        } else {
            i46 = i77;
            if (i89 & 3072 == 0) {
                if (restartGroup.changed(isError)) {
                } else {
                    i54 = changed3;
                }
                $dirty1 |= i54;
            } else {
                z3 = isError;
            }
        }
        int i78 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$1 & 16384;
        if (i78 != 0) {
            $dirty1 |= 24576;
            visualTransformation2 = i78;
            obj19 = visualTransformation;
        } else {
            visualTransformation2 = i78;
            if (i89 & 24576 == 0) {
                if (restartGroup.changed(visualTransformation)) {
                } else {
                    i34 = i10;
                }
                $dirty1 |= i34;
            } else {
                obj19 = visualTransformation;
            }
        }
        keyboardOptions2 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$1 & i113;
        if (keyboardOptions2 != 0) {
            $dirty1 |= i24;
            obj17 = keyboardOptions;
        } else {
            if (i89 & i24 == 0) {
                i34 = restartGroup.changed(keyboardOptions) ? 131072 : i63;
                $dirty1 |= i34;
            } else {
                obj17 = keyboardOptions;
            }
        }
        int i115 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$1 & i63;
        if (i115 != 0) {
            $dirty1 |= changed6;
            obj12 = keyboardActions;
        } else {
            if (i89 & changed6 == 0) {
                i10 = restartGroup.changed(keyboardActions) ? 1048576 : 524288;
                $dirty1 |= i10;
            } else {
                obj12 = keyboardActions;
            }
        }
        int i117 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$1 & i116;
        if (i117 != 0) {
            $dirty1 |= i64;
            z2 = singleLine;
        } else {
            if (i89 & i64 == 0) {
                i24 = restartGroup.changed(singleLine) ? 8388608 : i36;
                $dirty1 |= i24;
            } else {
                z2 = singleLine;
            }
        }
        if (i89 & i120 == 0) {
            if ($i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$1 & i121 == 0) {
                i67 = restartGroup.changed(maxLines) ? 67108864 : 33554432;
            } else {
                i25 = maxLines;
            }
            $dirty1 |= i67;
        } else {
            i25 = maxLines;
        }
        interactionSource2 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$1 & i122;
        if (interactionSource2 != 0) {
            $dirty1 |= i11;
            i51 = minLines;
        } else {
            if (i89 & i11 == 0) {
                i63 = restartGroup.changed(minLines) ? 536870912 : 268435456;
                $dirty1 |= i63;
            } else {
                i51 = minLines;
            }
        }
        i26 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$1 & i126;
        if (i26 != 0) {
            $dirty2 |= 6;
            obj7 = interactionSource;
        } else {
            if ($composer5 & 6 == 0) {
                i21 = restartGroup.changed(interactionSource) ? 4 : 2;
                $dirty2 |= i21;
            } else {
                obj7 = interactionSource;
            }
        }
        if ($composer5 & 48 == 0) {
            if ($i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$1 & i114 == 0) {
                minLines2 = restartGroup.changed(shape) ? 32 : 16;
            } else {
                obj = shape;
            }
            $dirty2 |= minLines2;
        } else {
            obj = shape;
        }
        if ($composer5 & 384 == 0) {
            if ($i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$1 & i36 == 0) {
                i22 = restartGroup.changed(colors) ? 256 : i112;
            } else {
                obj4 = colors;
            }
            $dirty2 |= i22;
        } else {
            obj4 = colors;
        }
        if ($dirty & suffix2 == 306783378 && i85 &= $dirty1 == 306783378 && $dirty2 & 147 == 146) {
            if (i85 &= $dirty1 == 306783378) {
                if ($dirty2 & 147 == 146) {
                    if (!restartGroup.getSkipping()) {
                        restartGroup.startDefaults();
                        if ($changed & 1 != 0) {
                            if (restartGroup.getDefaultsInvalid()) {
                                if (prefix2 != 0) {
                                    obj14 = defaultsInvalid;
                                }
                                if (supportingText2 != 0) {
                                    obj21 = defaultsInvalid;
                                }
                                if (keyboardActions2 != 0) {
                                    z = defaultsInvalid;
                                }
                                if ($i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$1 & 32 != 0) {
                                    prefix2 = 6;
                                    suffix2 = 0;
                                    ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                                    $dirty &= rememberComposableLambda;
                                    obj20 = this_$iv;
                                }
                                if (i127 != 0) {
                                    obj8 = this_$iv;
                                }
                                placeholder3 = i13 != 0 ? 0 : placeholder;
                                leadingIcon4 = i61 != 0 ? 0 : leadingIcon;
                                trailingIcon3 = textStyle3 != 0 ? 0 : trailingIcon;
                                prefix2 = i15 != 0 ? 0 : prefix;
                                suffix2 = i != 0 ? 0 : suffix;
                                supportingText2 = i23 != 0 ? 0 : supportingText;
                                isError3 = i46 != 0 ? 0 : isError;
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
                                    keyboardActions2 = KeyboardActions.Companion.getDefault();
                                } else {
                                    keyboardActions2 = keyboardActions;
                                }
                                singleLine2 = i117 != 0 ? 0 : singleLine;
                                if ($i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$1 & i118 != 0) {
                                    maxLines2 = singleLine2 != 0 ? 1 : 0x7fffffff /* Unknown resource */;
                                    $dirty1 &= minLines2;
                                } else {
                                    maxLines2 = maxLines;
                                }
                                minLines3 = interactionSource2 != 0 ? 1 : minLines;
                                interactionSource3 = i26 != 0 ? 0 : interactionSource;
                                obj71 = placeholder3;
                                int placeholder4 = 6;
                                if ($i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$1 & i123 != 0) {
                                    obj72 = leadingIcon4;
                                    leadingIcon2 = OutlinedTextFieldDefaults.INSTANCE.getShape(restartGroup, placeholder4);
                                    $dirty2 &= -113;
                                } else {
                                    obj72 = leadingIcon4;
                                    leadingIcon2 = shape;
                                }
                                if ($i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$1 & i36 != 0) {
                                    obj16 = obj71;
                                    obj9 = obj72;
                                    i11 = obj73;
                                    $dirty2 = i93;
                                    i64 = trailingIcon3;
                                    i36 = prefix2;
                                    i13 = suffix2;
                                    i61 = supportingText2;
                                    i26 = visualTransformation2;
                                    i53 = minLines3;
                                    rememberedValue = interactionSource3;
                                    trailingIcon2 = colors4;
                                    colors3 = obj20;
                                    textStyle2 = obj8;
                                    label2 = isError3;
                                    minLines2 = singleLine2;
                                    interactionSource2 = maxLines2;
                                    isError2 = z;
                                    singleLine3 = keyboardOptions2;
                                    maxLines3 = keyboardActions2;
                                    readOnly3 = obj14;
                                } else {
                                    obj16 = obj71;
                                    obj9 = obj72;
                                    i11 = obj73;
                                    i64 = trailingIcon3;
                                    colors3 = obj20;
                                    i36 = prefix2;
                                    textStyle2 = obj8;
                                    i13 = suffix2;
                                    i61 = supportingText2;
                                    i26 = visualTransformation2;
                                    label2 = isError3;
                                    i53 = minLines3;
                                    rememberedValue = interactionSource3;
                                    trailingIcon2 = colors;
                                    isError2 = z;
                                    minLines2 = singleLine2;
                                    interactionSource2 = maxLines2;
                                    readOnly3 = obj14;
                                    singleLine3 = keyboardOptions2;
                                    maxLines3 = keyboardActions2;
                                }
                            } else {
                                restartGroup.skipToGroupEnd();
                                if ($i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$1 & 32 != 0) {
                                    $dirty &= i35;
                                }
                                if (i80 &= $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$1 != 0) {
                                    $dirty1 &= i40;
                                }
                                if (i81 &= $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$1 != 0) {
                                    $dirty2 &= -113;
                                }
                                if ($i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$1 & i36 != 0) {
                                    obj16 = placeholder;
                                    obj9 = leadingIcon;
                                    i64 = trailingIcon;
                                    i36 = prefix;
                                    i13 = suffix;
                                    i61 = supportingText;
                                    i26 = visualTransformation;
                                    singleLine3 = keyboardOptions;
                                    maxLines3 = keyboardActions;
                                    minLines2 = singleLine;
                                    interactionSource2 = maxLines;
                                    i53 = minLines;
                                    rememberedValue = interactionSource;
                                    i11 = shape;
                                    trailingIcon2 = colors;
                                    $dirty2 = i84;
                                    isError2 = z;
                                    colors3 = obj20;
                                    textStyle2 = obj8;
                                    label2 = isError;
                                    readOnly3 = obj14;
                                } else {
                                    obj16 = placeholder;
                                    obj9 = leadingIcon;
                                    i64 = trailingIcon;
                                    i36 = prefix;
                                    i13 = suffix;
                                    i61 = supportingText;
                                    i26 = visualTransformation;
                                    singleLine3 = keyboardOptions;
                                    maxLines3 = keyboardActions;
                                    minLines2 = singleLine;
                                    interactionSource2 = maxLines;
                                    i53 = minLines;
                                    rememberedValue = interactionSource;
                                    i11 = shape;
                                    trailingIcon2 = colors;
                                    isError2 = z;
                                    colors3 = obj20;
                                    textStyle2 = obj8;
                                    label2 = isError;
                                    readOnly3 = obj14;
                                }
                            }
                        } else {
                        }
                        restartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1922450045, $dirty, $dirty1, "androidx.compose.material3.OutlinedTextField (OutlinedTextField.kt:193)");
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
                            i56 = $i$a$CacheOutlinedTextFieldKt$OutlinedTextField$interactionSource$1;
                        } else {
                            i56 = obj71;
                        }
                        restartGroup.endReplaceGroup();
                        restartGroup.startReplaceGroup(30069058);
                        ComposerKt.sourceInformation(restartGroup, "*199@11006L25");
                        int i91 = 0;
                        i55 = 0;
                        booleanValue = Long.compare(textColor-XeAY9LY$material3_release, i132) != 0 ? 1 : 0;
                        if (booleanValue != 0) {
                        } else {
                            i55 = 0;
                            $this$takeOrElse_u2dDxMtmZc$iv = textColor-XeAY9LY$material3_release;
                        }
                        restartGroup.endReplaceGroup();
                        textStyle3 = new TextStyle($this$takeOrElse_u2dDxMtmZc$iv, i, 0, i46, 0, 0, 0, 0, 0, 0, obj47, 0, 0, 0, 0, obj52, 0, 0, 0, 0, 0, 0, obj59, 0, 0, 0, 0, 0, 0, 16777214, 0);
                        int i96 = 0;
                        int i104 = 0;
                        ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        ComposerKt.sourceInformationMarkerEnd(restartGroup);
                        androidx.compose.material3.TextFieldColors field = trailingIcon2;
                        boolean z4 = obj21;
                        OutlinedTextFieldKt.OutlinedTextField.1 anon = new OutlinedTextFieldKt.OutlinedTextField.1(readOnly3, textStyle2, (Density)restartGroup.consume((CompositionLocal)CompositionLocalsKt.getLocalDensity()), label2, field, obj13, onValueChange, z4, isError2, colors3.merge(textStyle3), singleLine3, maxLines3, minLines2, interactionSource2, i53, i26, i56, obj16, obj9, i64, i36, i13, i61, i11);
                        CompositionLocalKt.CompositionLocalProvider(TextSelectionColorsKt.getLocalTextSelectionColors().provides(trailingIcon2.getTextSelectionColors()), (Function2)ComposableLambdaKt.rememberComposableLambda(-1886965181, true, anon, restartGroup, 54), restartGroup, $stable |= 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mergedTextStyle = obj71;
                        $composer4 = restartGroup;
                        i27 = $dirty;
                        obj10 = readOnly3;
                        i20 = label2;
                        $composer3 = z4;
                        $dirty3 = isError2;
                        keyboardActions4 = maxLines3;
                        i38 = minLines2;
                        enabled2 = interactionSource2;
                        readOnly2 = i53;
                        isError4 = i26;
                        i29 = obj16;
                        i57 = obj9;
                        i30 = i64;
                        i14 = i36;
                        modifier2 = i13;
                        placeholder2 = $dirty1;
                        leadingIcon3 = $dirty2;
                        $dirty22 = textStyle2;
                        keyboardActions3 = field;
                        colors2 = singleLine3;
                        label3 = i61;
                        keyboardOptions3 = i11;
                        $dirty12 = obj72;
                    } else {
                        restartGroup.skipToGroupEnd();
                        i29 = placeholder;
                        i14 = prefix;
                        i20 = isError;
                        colors2 = keyboardOptions;
                        keyboardActions4 = keyboardActions;
                        i38 = singleLine;
                        enabled2 = maxLines;
                        readOnly2 = minLines;
                        mergedTextStyle = interactionSource;
                        keyboardOptions3 = shape;
                        keyboardActions3 = colors;
                        $composer4 = restartGroup;
                        i27 = $dirty;
                        placeholder2 = $dirty1;
                        leadingIcon3 = $dirty2;
                        obj10 = obj14;
                        $composer3 = obj21;
                        $dirty3 = z;
                        $dirty12 = obj20;
                        $dirty22 = obj8;
                        i57 = leadingIcon;
                        i30 = trailingIcon;
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
            $composer2 = composer;
            $composer4 = new OutlinedTextFieldKt.OutlinedTextField.2(value, onValueChange, obj10, $composer3, $dirty3, $dirty12, $dirty22, i29, i57, i30, i14, modifier2, label3, i20, isError4, colors2, keyboardActions4, i38, enabled2, readOnly2, mergedTextStyle, keyboardOptions3, keyboardActions3, $changed, $changed1, $changed2, i28);
            endRestartGroup.updateScope((Function2)$composer4);
        } else {
            $composer2 = $composer4;
        }
    }

    public static final void OutlinedTextFieldLayout(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> textField, Function3<? super Modifier, ? super Composer, ? super Integer, Unit> placeholder, Function2<? super Composer, ? super Integer, Unit> label, Function2<? super Composer, ? super Integer, Unit> leading, Function2<? super Composer, ? super Integer, Unit> trailing, Function2<? super Composer, ? super Integer, Unit> prefix, Function2<? super Composer, ? super Integer, Unit> suffix, boolean singleLine, float animationProgress, Function1<? super Size, Unit> onLabelMeasured, Function2<? super Composer, ? super Integer, Unit> container, Function2<? super Composer, ? super Integer, Unit> supporting, PaddingValues paddingValues, Composer $composer, int $changed, int $changed1) {
        int traceInProgress2;
        Object endRestartGroup;
        int i5;
        Object it$iv;
        Object valueOf3;
        Function0 factory$iv$iv$iv4;
        Object valueOf6;
        int heightIn-VpY3zN4$default;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap4;
        Object valueOf9;
        Object valueOf7;
        Function0 factory$iv$iv$iv6;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv7;
        Object obj4;
        Function0 factory$iv$iv;
        boolean valueOf8;
        boolean traceInProgress;
        int i20;
        int i27;
        int i28;
        Integer currentCompositionLocalMap6;
        Object valueOf5;
        Function0 factory$iv$iv$iv2;
        Object valueOf10;
        String $composer$iv2;
        boolean currentCompositionLocalMap2;
        int i2;
        Object then;
        Function0 factory$iv$iv$iv5;
        Composer composer3;
        Integer currentCompositionLocalMap7;
        boolean maybeCachedBoxMeasurePolicy5;
        int $i$f$Layout;
        int $i$f$cache2;
        Object $composer$iv;
        Integer currentCompositionLocalMap;
        Composer materialized$iv$iv;
        float constructor-impl2;
        Composer composer11;
        Object currentCompositionLocalMap3;
        Object materializeModifier;
        Object obj2;
        Object iNSTANCE;
        Composer composer6;
        int valueOf4;
        Composer composer4;
        Composer composer10;
        Object topStart;
        boolean maybeCachedBoxMeasurePolicy4;
        Object materialized$iv$iv2;
        float $this$coerceAtLeast_u2dYgX7TsA$iv2;
        float $this$coerceAtLeast_u2dYgX7TsA$iv;
        float constructor-impl;
        Function0 factory$iv$iv$iv3;
        float $this$dp$iv;
        int maybeCachedBoxMeasurePolicy3;
        Integer maybeCachedBoxMeasurePolicy;
        Object iNSTANCE3;
        Object maybeCachedBoxMeasurePolicy2;
        Composer composer5;
        int valueOf2;
        int i23;
        Composer composer2;
        Object currentCompositionLocalMap5;
        Composer restartGroup;
        Modifier maybeCachedBoxMeasurePolicy6;
        int i7;
        int i3;
        int i26;
        int i32;
        int i6;
        int i9;
        int i16;
        int str;
        Composer composer;
        int valueOf;
        Object obj5;
        Object obj3;
        int $dirty12;
        int $dirty1;
        int $dirty2;
        int $dirty;
        int i29;
        int i31;
        int i13;
        int i12;
        int i;
        androidx.compose.material3.OutlinedTextFieldMeasurePolicy field;
        int companion2;
        Object obj;
        Modifier $i$f$cache;
        int currentCompositeKeyHash2;
        int i24;
        Function0 function0;
        int i22;
        Composer composer8;
        int i8;
        Composer composer9;
        int companion;
        int i21;
        int i11;
        androidx.compose.runtime.CompositionLocalMap localMap$iv;
        Modifier modifier2;
        int i15;
        int i10;
        Function0 function02;
        int layoutDirection;
        int $i$a$LayoutOutlinedTextFieldKt$OutlinedTextFieldLayout$1;
        int currentCompositeKeyHash3;
        int i19;
        Object obj6;
        int currentCompositeKeyHash4;
        float f2;
        int $composer3;
        Composer $composer2;
        int i25;
        int currentCompositeKeyHash;
        float f;
        Modifier modifier3;
        Function0 function03;
        int i4;
        int i30;
        Composer composer12;
        int localMap$iv$iv3;
        int i17;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy$iv;
        androidx.compose.runtime.CompositionLocalMap map;
        Object iNSTANCE2;
        int localMap$iv$iv;
        androidx.compose.ui.layout.MeasurePolicy localMap$iv$iv2;
        androidx.compose.runtime.CompositionLocalMap map2;
        Composer composer7;
        int i18;
        int i14;
        ScopeUpdateScope scopeUpdateScope;
        int obj76;
        Object obj7 = modifier;
        $composer$iv = leading;
        materializeModifier = trailing;
        iNSTANCE = prefix;
        final Object obj11 = suffix;
        maybeCachedBoxMeasurePolicy4 = singleLine;
        $this$dp$iv = animationProgress;
        iNSTANCE3 = onLabelMeasured;
        maybeCachedBoxMeasurePolicy2 = container;
        int i182 = $changed;
        int i33 = $changed1;
        restartGroup = $composer.startRestartGroup(1408290209);
        ComposerKt.sourceInformation(restartGroup, "C(OutlinedTextFieldLayout)P(4,12,7,2,3,13,8,10,9!1,5!1,11)470@24558L267,478@24873L7,479@24885L3739:OutlinedTextField.kt#uh7d8r");
        obj76 = i172;
        if (i182 & 6 == 0) {
            i31 = restartGroup.changed(obj7) ? 4 : 2;
            $dirty2 = obj76 | i31;
        } else {
            $dirty2 = obj76;
        }
        if (i182 & 48 == 0) {
            i12 = restartGroup.changedInstance(textField) ? 32 : 16;
            $dirty2 |= i12;
        }
        if (i182 & 384 == 0) {
            i7 = restartGroup.changedInstance(placeholder) ? 256 : 128;
            $dirty2 |= i7;
        }
        if (i182 & 3072 == 0) {
            i = restartGroup.changedInstance(label) ? 2048 : 1024;
            $dirty2 |= i;
        }
        if (i182 & 24576 == 0) {
            i3 = restartGroup.changedInstance($composer$iv) ? 16384 : 8192;
            $dirty2 |= i3;
        }
        if (i174 &= i182 == 0) {
            i26 = restartGroup.changedInstance(materializeModifier) ? 131072 : 65536;
            $dirty2 |= i26;
        }
        if (i175 &= i182 == 0) {
            i32 = restartGroup.changedInstance(iNSTANCE) ? 1048576 : 524288;
            $dirty2 |= i32;
        }
        if (i176 &= i182 == 0) {
            i6 = restartGroup.changedInstance(obj11) ? 8388608 : 4194304;
            $dirty2 |= i6;
        }
        if (i177 &= i182 == 0) {
            i9 = restartGroup.changed(maybeCachedBoxMeasurePolicy4) ? 67108864 : 33554432;
            $dirty2 |= i9;
        }
        if (i178 &= i182 == 0) {
            i16 = restartGroup.changed($this$dp$iv) ? 536870912 : 268435456;
            $dirty2 |= i16;
        }
        str = $dirty2;
        if (i33 & 6 == 0) {
            $dirty = restartGroup.changedInstance(iNSTANCE3) ? 4 : 2;
            $dirty12 |= $dirty;
        }
        if (i33 & 48 == 0) {
            i29 = restartGroup.changedInstance(maybeCachedBoxMeasurePolicy2) ? 32 : 16;
            $dirty12 |= i29;
        }
        if (i33 & 384 == 0) {
            i29 = restartGroup.changedInstance(supporting) ? 256 : 128;
            $dirty12 |= i29;
        } else {
            obj5 = supporting;
        }
        if (i33 & 3072 == 0) {
            i29 = restartGroup.changed(paddingValues) ? 2048 : 1024;
            $dirty12 |= i29;
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
                    int i185 = 1;
                    i20 = traceInProgress2 & 14 == 4 ? i185 : 0;
                    i27 = i108 &= str == 67108864 ? i185 : 0;
                    i28 = i110 &= str == 536870912 ? i185 : 0;
                    i13 = traceInProgress2;
                    i5 = traceInProgress2 & 7168 == 2048 ? i185 : 0;
                    Composer composer13 = restartGroup;
                    $i$f$cache2 = 0;
                    it$iv = composer13.rememberedValue();
                    int i192 = 0;
                    if (i5 |= i82 == 0) {
                        $i$f$cache = $i$f$cache2;
                        if (it$iv == Composer.Companion.getEmpty()) {
                            $i$f$cache2 = 0;
                            obj = it$iv;
                            it$iv = new OutlinedTextFieldMeasurePolicy(iNSTANCE3, maybeCachedBoxMeasurePolicy4, $this$dp$iv, obj3);
                            composer13.updateRememberedValue(it$iv);
                        } else {
                            obj = it$iv;
                        }
                    } else {
                        $i$f$cache = $i$f$cache2;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    int i191 = 0;
                    int i193 = i113;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    valueOf3 = restartGroup.consume((CompositionLocal)CompositionLocalsKt.getLocalLayoutDirection());
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    companion2 = i114;
                    $i$f$Layout = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, $i$f$Layout);
                    currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, 0);
                    currentCompositionLocalMap6 = restartGroup.getCurrentCompositionLocalMap();
                    materialized$iv$iv2 = ComposedModifierKt.materializeModifier(restartGroup, obj7);
                    Function0 function04 = constructor2;
                    i24 = 0;
                    iNSTANCE3 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp";
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, iNSTANCE3);
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
                    int i195 = 0;
                    composer9 = restartGroup;
                    i21 = str;
                    Updater.set-impl(constructor-impl6, (MeasurePolicy)(OutlinedTextFieldMeasurePolicy)it$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl6, currentCompositionLocalMap6, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    valueOf = 0;
                    Composer composer20 = constructor-impl6;
                    i11 = 0;
                    if (!composer20.getInserting()) {
                        localMap$iv = currentCompositionLocalMap6;
                        i15 = valueOf;
                        if (!Intrinsics.areEqual(composer20.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                            composer20.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                            constructor-impl6.apply(Integer.valueOf(currentCompositeKeyHash2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer = composer20;
                        }
                    } else {
                        localMap$iv = currentCompositionLocalMap6;
                        i15 = valueOf;
                    }
                    Updater.set-impl(constructor-impl6, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                    valueOf8 = composer9;
                    maybeCachedBoxMeasurePolicy6 = 0;
                    i8 = i72;
                    ComposerKt.sourceInformationMarkerStart(valueOf8, -828374317, "C482@24954L11,550@27430L186:OutlinedTextField.kt#uh7d8r");
                    maybeCachedBoxMeasurePolicy2.invoke(valueOf8, Integer.valueOf(i73 &= 14));
                    valueOf8.startReplaceGroup(250370369);
                    ComposerKt.sourceInformation(valueOf8, "485@25018L219");
                    str = "C73@3429L9:Box.kt#2w3rfo";
                    companion = 48;
                    String str3 = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo";
                    modifier2 = materialized$iv$iv2;
                    if ($composer$iv != null) {
                        Modifier then4 = LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Leading").then(TextFieldImplKt.getIconDefaultSizeModifier());
                        Alignment center2 = Alignment.Companion.getCenter();
                        i10 = companion;
                        layoutDirection = 0;
                        $i$a$LayoutOutlinedTextFieldKt$OutlinedTextFieldLayout$1 = maybeCachedBoxMeasurePolicy6;
                        ComposerKt.sourceInformationMarkerStart(valueOf8, 733328855, str3);
                        int i170 = 0;
                        maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center2, i170);
                        i19 = 0;
                        obj6 = center2;
                        ComposerKt.sourceInformationMarkerStart(valueOf8, -1323940314, $i$f$Layout);
                        currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(valueOf8, 0);
                        currentCompositionLocalMap5 = valueOf8.getCurrentCompositionLocalMap();
                        $composer3 = i170;
                        modifier3 = then4;
                        Function0 function010 = constructor7;
                        currentCompositeKeyHash = 0;
                        ComposerKt.sourceInformationMarkerStart(valueOf8, -692256719, iNSTANCE3);
                        if (!applier8 instanceof Applier) {
                            ComposablesKt.invalidApplier();
                        }
                        valueOf8.startReusableNode();
                        if (valueOf8.getInserting()) {
                            valueOf8.createNode(function010);
                        } else {
                            factory$iv$iv$iv3 = function010;
                            valueOf8.useNode();
                        }
                        function03 = factory$iv$iv$iv3;
                        Composer constructor-impl9 = Updater.constructor-impl(valueOf8);
                        int i217 = 0;
                        Updater.set-impl(constructor-impl9, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(constructor-impl9, currentCompositionLocalMap5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        int i221 = 0;
                        Composer composer23 = constructor-impl9;
                        int i237 = 0;
                        if (!composer23.getInserting()) {
                            measurePolicy$iv = maybeCachedBoxMeasurePolicy;
                            map = currentCompositionLocalMap5;
                            if (!Intrinsics.areEqual(composer23.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                                composer23.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                                constructor-impl9.apply(Integer.valueOf(currentCompositeKeyHash4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            } else {
                                composer2 = composer23;
                            }
                        } else {
                            measurePolicy$iv = maybeCachedBoxMeasurePolicy;
                            map = currentCompositionLocalMap5;
                        }
                        Updater.set-impl(constructor-impl9, ComposedModifierKt.materializeModifier(valueOf8, then4), ComposeUiNode.Companion.getSetModifier());
                        Composer composer19 = valueOf8;
                        ComposerKt.sourceInformationMarkerStart(composer19, -2146769399, str);
                        maybeCachedBoxMeasurePolicy2 = BoxScopeInstance.INSTANCE;
                        i219 |= 6;
                        localMap$iv$iv3 = 0;
                        i17 = i104;
                        localMap$iv$iv = i149;
                        $this$dp$iv = composer12;
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
                    valueOf2 = 0;
                    layoutDirection = 0;
                    ComposerKt.sourceInformationMarkerStart(valueOf8, -1323940314, $i$f$Layout);
                    currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(valueOf8, 0);
                    currentCompositionLocalMap = valueOf8.getCurrentCompositionLocalMap();
                    i19 = center;
                    Modifier materializeModifier6 = ComposedModifierKt.materializeModifier(valueOf8, then2);
                    currentCompositeKeyHash4 = then2;
                    Function0 function06 = constructor3;
                    obj6 = 0;
                    ComposerKt.sourceInformationMarkerStart(valueOf8, -692256719, iNSTANCE3);
                    if (materializeModifier != null && !applier6 instanceof Applier) {
                        then2 = LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Trailing").then(TextFieldImplKt.getIconDefaultSizeModifier());
                        center = Alignment.Companion.getCenter();
                        ComposerKt.sourceInformationMarkerStart(valueOf8, 733328855, str3);
                        valueOf2 = 0;
                        layoutDirection = 0;
                        ComposerKt.sourceInformationMarkerStart(valueOf8, -1323940314, $i$f$Layout);
                        currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(valueOf8, 0);
                        currentCompositionLocalMap = valueOf8.getCurrentCompositionLocalMap();
                        i19 = center;
                        materializeModifier6 = ComposedModifierKt.materializeModifier(valueOf8, then2);
                        currentCompositeKeyHash4 = then2;
                        function06 = constructor3;
                        obj6 = 0;
                        ComposerKt.sourceInformationMarkerStart(valueOf8, -692256719, iNSTANCE3);
                        if (!applier6 instanceof Applier) {
                            ComposablesKt.invalidApplier();
                        }
                        valueOf8.startReusableNode();
                        if (valueOf8.getInserting()) {
                            valueOf8.createNode(function06);
                        } else {
                            factory$iv$iv$iv2 = function06;
                            valueOf8.useNode();
                        }
                        $composer3 = factory$iv$iv$iv2;
                        Composer constructor-impl7 = Updater.constructor-impl(valueOf8);
                        int i206 = 0;
                        i4 = i145;
                        Updater.set-impl(constructor-impl7, BoxKt.maybeCachedBoxMeasurePolicy(center, valueOf2), ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(constructor-impl7, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        int i212 = 0;
                        Composer composer22 = constructor-impl7;
                        int i220 = 0;
                        if (!composer22.getInserting()) {
                            localMap$iv$iv3 = currentCompositionLocalMap;
                            i17 = valueOf2;
                            if (!Intrinsics.areEqual(composer22.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                composer22.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                constructor-impl7.apply(Integer.valueOf(currentCompositeKeyHash3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            } else {
                                composer5 = composer22;
                            }
                        } else {
                            localMap$iv$iv3 = currentCompositionLocalMap;
                            i17 = valueOf2;
                        }
                        Updater.set-impl(constructor-impl7, materializeModifier6, ComposeUiNode.Companion.getSetModifier());
                        Composer composer18 = valueOf8;
                        $this$dp$iv = 0;
                        ComposerKt.sourceInformationMarkerStart(composer18, -2146769399, str);
                        maybeCachedBoxMeasurePolicy2 = BoxScopeInstance.INSTANCE;
                        i208 |= 6;
                        i30 = 0;
                        composer12 = i90;
                        map = materializeModifier6;
                        materialized$iv$iv2 = function03;
                        ComposerKt.sourceInformationMarkerStart(materialized$iv$iv2, -367622711, "C497@25497L10:OutlinedTextField.kt#uh7d8r");
                        materializeModifier.invoke(materialized$iv$iv2, Integer.valueOf(i91 &= 14));
                        ComposerKt.sourceInformationMarkerEnd(materialized$iv$iv2);
                        ComposerKt.sourceInformationMarkerEnd(composer18);
                        valueOf8.endNode();
                        ComposerKt.sourceInformationMarkerEnd(valueOf8);
                        ComposerKt.sourceInformationMarkerEnd(valueOf8);
                        ComposerKt.sourceInformationMarkerEnd(valueOf8);
                    }
                    valueOf8.endReplaceGroup();
                    $composer$iv2 = PaddingKt.calculateStartPadding(obj3, (LayoutDirection)valueOf3);
                    materialized$iv$iv = PaddingKt.calculateEndPadding(obj3, valueOf3);
                    if (leading != null) {
                        int i146 = 0;
                        int i153 = 0;
                        maybeCachedBoxMeasurePolicy2 = 0;
                        $this$coerceAtLeast_u2dYgX7TsA$iv2 = Dp.constructor-impl(RangesKt.coerceAtLeast(Dp.constructor-impl($composer$iv2 - horizontalIconPadding), Dp.constructor-impl((float)$i$f$minus5rwHm24)));
                    } else {
                        $this$coerceAtLeast_u2dYgX7TsA$iv2 = $composer$iv2;
                    }
                    i19 = $this$coerceAtLeast_u2dYgX7TsA$iv2;
                    if (materializeModifier != null) {
                        int i148 = 0;
                        int i159 = 0;
                        maybeCachedBoxMeasurePolicy2 = 0;
                        $this$coerceAtLeast_u2dYgX7TsA$iv = Dp.constructor-impl(RangesKt.coerceAtLeast(Dp.constructor-impl(materialized$iv$iv - horizontalIconPadding2), Dp.constructor-impl((float)$i$f$minus5rwHm242)));
                    } else {
                        $this$coerceAtLeast_u2dYgX7TsA$iv = materialized$iv$iv;
                    }
                    valueOf8.startReplaceGroup(250410106);
                    ComposerKt.sourceInformation(valueOf8, "518@26256L309");
                    i23 = 0;
                    if (iNSTANCE != null) {
                        layoutDirection = valueOf3;
                        i30 = $composer$iv2;
                        int i101 = 0;
                        Modifier padding-qDBjuR0$default3 = PaddingKt.padding-qDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.heightIn-VpY3zN4$default(LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Prefix"), TextFieldImplKt.getMinTextLineHeight(), 0, 2, i23), i23, i101, 3, i23), i19, 0, TextFieldImplKt.getPrefixSuffixTextPadding(), 0, 10, 0);
                        maybeCachedBoxMeasurePolicy3 = i101;
                        ComposerKt.sourceInformationMarkerStart(valueOf8, 733328855, str3);
                        obj6 = i102;
                        maybeCachedBoxMeasurePolicy5 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                        $composer3 = 0;
                        composer12 = materialized$iv$iv;
                        ComposerKt.sourceInformationMarkerStart(valueOf8, -1323940314, $i$f$Layout);
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(valueOf8, 0);
                        currentCompositionLocalMap3 = valueOf8.getCurrentCompositionLocalMap();
                        function03 = padding-qDBjuR0$default3;
                        Function0 function011 = constructor8;
                        modifier3 = 0;
                        ComposerKt.sourceInformationMarkerStart(valueOf8, -692256719, iNSTANCE3);
                        if (!applier4 instanceof Applier) {
                            ComposablesKt.invalidApplier();
                        }
                        valueOf8.startReusableNode();
                        if (valueOf8.getInserting()) {
                            valueOf8.createNode(function011);
                        } else {
                            factory$iv$iv$iv7 = function011;
                            valueOf8.useNode();
                        }
                        i4 = factory$iv$iv$iv7;
                        Composer constructor-impl5 = Updater.constructor-impl(valueOf8);
                        int i234 = 0;
                        map = $this$coerceAtLeast_u2dYgX7TsA$iv;
                        Updater.set-impl(constructor-impl5, maybeCachedBoxMeasurePolicy5, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(constructor-impl5, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        int i238 = 0;
                        Composer composer27 = constructor-impl5;
                        int i242 = 0;
                        if (!composer27.getInserting()) {
                            localMap$iv$iv2 = maybeCachedBoxMeasurePolicy5;
                            map2 = currentCompositionLocalMap3;
                            if (!Intrinsics.areEqual(composer27.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                composer27.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                constructor-impl5.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            } else {
                                composer11 = composer27;
                            }
                        } else {
                            localMap$iv$iv2 = maybeCachedBoxMeasurePolicy5;
                            map2 = currentCompositionLocalMap3;
                        }
                        Updater.set-impl(constructor-impl5, ComposedModifierKt.materializeModifier(valueOf8, padding-qDBjuR0$default3), ComposeUiNode.Companion.getSetModifier());
                        Composer composer17 = valueOf8;
                        ComposerKt.sourceInformationMarkerStart(composer17, -2146769399, str);
                        $this$coerceAtLeast_u2dYgX7TsA$iv = BoxScopeInstance.INSTANCE;
                        i236 |= 6;
                        iNSTANCE2 = 0;
                        localMap$iv$iv = i65;
                        i18 = i128;
                        materialized$iv$iv = measurePolicy$iv;
                        ComposerKt.sourceInformationMarkerStart(materialized$iv$iv, -366589109, "C524@26539L8:OutlinedTextField.kt#uh7d8r");
                        iNSTANCE.invoke(materialized$iv$iv, Integer.valueOf(i66 &= 14));
                        ComposerKt.sourceInformationMarkerEnd(materialized$iv$iv);
                        ComposerKt.sourceInformationMarkerEnd(composer17);
                        valueOf8.endNode();
                        ComposerKt.sourceInformationMarkerEnd(valueOf8);
                        ComposerKt.sourceInformationMarkerEnd(valueOf8);
                        ComposerKt.sourceInformationMarkerEnd(valueOf8);
                    } else {
                        layoutDirection = valueOf3;
                        i30 = $composer$iv2;
                        composer12 = materialized$iv$iv;
                        map = $this$coerceAtLeast_u2dYgX7TsA$iv;
                    }
                    valueOf8.endReplaceGroup();
                    valueOf8.startReplaceGroup(250422072);
                    ComposerKt.sourceInformation(valueOf8, "528@26630L307");
                    int i139 = 0;
                    int i118 = 0;
                    Modifier padding-qDBjuR0$default = PaddingKt.padding-qDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.heightIn-VpY3zN4$default(LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Suffix"), TextFieldImplKt.getMinTextLineHeight(), 0, 2, i139), i139, i118, 3, i139), TextFieldImplKt.getPrefixSuffixTextPadding(), 0, map, 0, 10, 0);
                    int i94 = i118;
                    ComposerKt.sourceInformationMarkerStart(valueOf8, 733328855, str3);
                    Alignment topStart3 = Alignment.Companion.getTopStart();
                    maybeCachedBoxMeasurePolicy6 = 0;
                    ComposerKt.sourceInformationMarkerStart(valueOf8, -1323940314, $i$f$Layout);
                    currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(valueOf8, 0);
                    currentCompositionLocalMap2 = valueOf8.getCurrentCompositionLocalMap();
                    $composer3 = i119;
                    Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(valueOf8, padding-qDBjuR0$default);
                    modifier3 = padding-qDBjuR0$default;
                    Function0 function07 = constructor4;
                    currentCompositeKeyHash = 0;
                    ComposerKt.sourceInformationMarkerStart(valueOf8, -692256719, iNSTANCE3);
                    if (obj11 != null && !applier instanceof Applier) {
                        i139 = 0;
                        i118 = 0;
                        padding-qDBjuR0$default = PaddingKt.padding-qDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.heightIn-VpY3zN4$default(LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Suffix"), TextFieldImplKt.getMinTextLineHeight(), 0, 2, i139), i139, i118, 3, i139), TextFieldImplKt.getPrefixSuffixTextPadding(), 0, map, 0, 10, 0);
                        i94 = i118;
                        ComposerKt.sourceInformationMarkerStart(valueOf8, 733328855, str3);
                        topStart3 = Alignment.Companion.getTopStart();
                        maybeCachedBoxMeasurePolicy6 = 0;
                        ComposerKt.sourceInformationMarkerStart(valueOf8, -1323940314, $i$f$Layout);
                        currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(valueOf8, 0);
                        currentCompositionLocalMap2 = valueOf8.getCurrentCompositionLocalMap();
                        $composer3 = i119;
                        materializeModifier3 = ComposedModifierKt.materializeModifier(valueOf8, padding-qDBjuR0$default);
                        modifier3 = padding-qDBjuR0$default;
                        function07 = constructor4;
                        currentCompositeKeyHash = 0;
                        ComposerKt.sourceInformationMarkerStart(valueOf8, -692256719, iNSTANCE3);
                        if (!applier instanceof Applier) {
                            ComposablesKt.invalidApplier();
                        }
                        valueOf8.startReusableNode();
                        if (valueOf8.getInserting()) {
                            valueOf8.createNode(function07);
                        } else {
                            factory$iv$iv$iv4 = function07;
                            valueOf8.useNode();
                        }
                        function03 = factory$iv$iv$iv4;
                        Composer constructor-impl3 = Updater.constructor-impl(valueOf8);
                        int i222 = 0;
                        measurePolicy$iv = topStart3;
                        Updater.set-impl(constructor-impl3, BoxKt.maybeCachedBoxMeasurePolicy(topStart3, false), ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(constructor-impl3, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        int i231 = 0;
                        Composer composer25 = constructor-impl3;
                        int i240 = 0;
                        if (!composer25.getInserting()) {
                            localMap$iv$iv2 = currentCompositionLocalMap2;
                            if (!Intrinsics.areEqual(composer25.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                                composer25.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                                constructor-impl3.apply(Integer.valueOf(currentCompositeKeyHash4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            } else {
                                composer6 = composer25;
                            }
                        } else {
                            localMap$iv$iv2 = currentCompositionLocalMap2;
                        }
                        Updater.set-impl(constructor-impl3, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                        Composer composer14 = valueOf8;
                        materializeModifier = 0;
                        ComposerKt.sourceInformationMarkerStart(composer14, -2146769399, str);
                        iNSTANCE = BoxScopeInstance.INSTANCE;
                        i224 |= 6;
                        iNSTANCE2 = 0;
                        localMap$iv$iv = i39;
                        composer7 = materializeModifier3;
                        materialized$iv$iv = i17;
                        ComposerKt.sourceInformationMarkerStart(materialized$iv$iv, -366220085, "C534@26911L8:OutlinedTextField.kt#uh7d8r");
                        obj11.invoke(materialized$iv$iv, Integer.valueOf(i40 &= 14));
                        ComposerKt.sourceInformationMarkerEnd(materialized$iv$iv);
                        ComposerKt.sourceInformationMarkerEnd(composer14);
                        valueOf8.endNode();
                        ComposerKt.sourceInformationMarkerEnd(valueOf8);
                        ComposerKt.sourceInformationMarkerEnd(valueOf8);
                        ComposerKt.sourceInformationMarkerEnd(valueOf8);
                    }
                    valueOf8.endReplaceGroup();
                    constructor-impl = 0;
                    if (prefix == null) {
                        f2 = i19;
                    } else {
                        i2 = 0;
                        f2 = constructor-impl2;
                    }
                    if (obj11 == null) {
                        f = map;
                    } else {
                        i2 = 0;
                        f = constructor-impl;
                    }
                    Modifier padding-qDBjuR0$default2 = PaddingKt.padding-qDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.heightIn-VpY3zN4$default((Modifier)Modifier.Companion, TextFieldImplKt.getMinTextLineHeight(), 0, 2, constructor-impl), constructor-impl, false, 3, constructor-impl), f2, 0, f, 0, 10, 0);
                    valueOf8.startReplaceGroup(250444361);
                    ComposerKt.sourceInformation(valueOf8, "547@27339L63");
                    if (placeholder != null) {
                        placeholder.invoke(LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Hint").then(padding-qDBjuR0$default2), valueOf8, Integer.valueOf(i121 &= 112));
                    } else {
                        obj2 = placeholder;
                    }
                    valueOf8.endReplaceGroup();
                    Modifier then3 = LayoutIdKt.layoutId((Modifier)Modifier.Companion, "TextField").then(padding-qDBjuR0$default2);
                    int i123 = 384;
                    valueOf4 = i185;
                    maybeCachedBoxMeasurePolicy4 = 0;
                    ComposerKt.sourceInformationMarkerStart(valueOf8, 733328855, str3);
                    $dirty1 = 0;
                    obj6 = padding-qDBjuR0$default2;
                    ComposerKt.sourceInformationMarkerStart(valueOf8, -1323940314, $i$f$Layout);
                    currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(valueOf8, 0);
                    currentCompositionLocalMap4 = valueOf8.getCurrentCompositionLocalMap();
                    Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(valueOf8, then3);
                    modifier3 = then3;
                    Function0 function08 = constructor5;
                    currentCompositeKeyHash = 0;
                    ComposerKt.sourceInformationMarkerStart(valueOf8, -692256719, iNSTANCE3);
                    if (!applier7 instanceof Applier) {
                        ComposablesKt.invalidApplier();
                    }
                    valueOf8.startReusableNode();
                    if (valueOf8.getInserting()) {
                        valueOf8.createNode(function08);
                    } else {
                        factory$iv$iv$iv5 = function08;
                        valueOf8.useNode();
                    }
                    function03 = factory$iv$iv$iv5;
                    Composer constructor-impl8 = Updater.constructor-impl(valueOf8);
                    int i225 = 0;
                    Updater.set-impl(constructor-impl8, BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), valueOf4), ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl8, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    int i232 = 0;
                    Composer composer24 = constructor-impl8;
                    int i239 = 0;
                    if (!composer24.getInserting()) {
                        localMap$iv$iv = currentCompositionLocalMap4;
                        localMap$iv$iv2 = valueOf4;
                        if (!Intrinsics.areEqual(composer24.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                            composer24.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                            constructor-impl8.apply(Integer.valueOf(currentCompositeKeyHash4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer4 = composer24;
                        }
                    } else {
                        localMap$iv$iv = currentCompositionLocalMap4;
                        localMap$iv$iv2 = valueOf4;
                    }
                    Updater.set-impl(constructor-impl8, materializeModifier4, ComposeUiNode.Companion.getSetModifier());
                    Composer composer15 = valueOf8;
                    materializeModifier = 0;
                    ComposerKt.sourceInformationMarkerStart(composer15, -2146769399, str);
                    iNSTANCE = BoxScopeInstance.INSTANCE;
                    i227 |= 6;
                    measurePolicy$iv = 0;
                    iNSTANCE2 = i44;
                    composer7 = materializeModifier4;
                    $composer$iv = i17;
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
                        $dirty1 = 0;
                        ComposerKt.sourceInformationMarkerStart(valueOf8, -1323940314, $i$f$Layout);
                        currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(valueOf8, 0);
                        currentCompositionLocalMap7 = valueOf8.getCurrentCompositionLocalMap();
                        Modifier materializeModifier5 = ComposedModifierKt.materializeModifier(valueOf8, layoutId3);
                        modifier3 = layoutId3;
                        Function0 function09 = constructor6;
                        currentCompositeKeyHash = 0;
                        ComposerKt.sourceInformationMarkerStart(valueOf8, -692256719, iNSTANCE3);
                        if (!applier3 instanceof Applier) {
                            ComposablesKt.invalidApplier();
                        }
                        valueOf8.startReusableNode();
                        if (valueOf8.getInserting()) {
                            valueOf8.createNode(function09);
                        } else {
                            factory$iv$iv$iv = function09;
                            valueOf8.useNode();
                        }
                        function03 = factory$iv$iv$iv;
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
                            map2 = topStart;
                            if (!Intrinsics.areEqual(composer26.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                                composer26.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                                constructor-impl4.apply(Integer.valueOf(currentCompositeKeyHash4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            } else {
                                composer10 = composer26;
                            }
                        } else {
                            localMap$iv$iv2 = currentCompositionLocalMap7;
                            map2 = topStart;
                        }
                        Updater.set-impl(constructor-impl4, materializeModifier5, ComposeUiNode.Companion.getSetModifier());
                        Composer composer16 = valueOf8;
                        materializeModifier = 0;
                        ComposerKt.sourceInformationMarkerStart(composer16, -2146769399, str);
                        iNSTANCE = BoxScopeInstance.INSTANCE;
                        i230 |= 6;
                        iNSTANCE2 = 0;
                        localMap$iv$iv = i58;
                        i18 = materializeModifier5;
                        $composer$iv = i17;
                        ComposerKt.sourceInformationMarkerStart($composer$iv, -364997972, "C570@28143L7:OutlinedTextField.kt#uh7d8r");
                        label.invoke($composer$iv, Integer.valueOf(i59 &= 14));
                        ComposerKt.sourceInformationMarkerEnd($composer$iv);
                        ComposerKt.sourceInformationMarkerEnd(composer16);
                        valueOf8.endNode();
                        ComposerKt.sourceInformationMarkerEnd(valueOf8);
                        ComposerKt.sourceInformationMarkerEnd(valueOf8);
                        ComposerKt.sourceInformationMarkerEnd(valueOf8);
                    } else {
                        valueOf5 = label;
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
                        $dirty1 = currentCompositeKeyHash5;
                        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(valueOf8, padding);
                        $i$f$cache = padding;
                        Function0 function05 = constructor;
                        i29 = 0;
                        ComposerKt.sourceInformationMarkerStart(valueOf8, -692256719, iNSTANCE3);
                        if (!applier2 instanceof Applier) {
                            ComposablesKt.invalidApplier();
                        }
                        valueOf8.startReusableNode();
                        if (valueOf8.getInserting()) {
                            valueOf8.createNode(function05);
                        } else {
                            factory$iv$iv$iv6 = function05;
                            valueOf8.useNode();
                        }
                        Composer constructor-impl10 = Updater.constructor-impl(valueOf8);
                        int i194 = 0;
                        function02 = factory$iv$iv$iv6;
                        Updater.set-impl(constructor-impl10, BoxKt.maybeCachedBoxMeasurePolicy(topStart2, false), ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(constructor-impl10, valueOf8.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        int i196 = 0;
                        Composer composer21 = constructor-impl10;
                        int i200 = 0;
                        if (!composer21.getInserting()) {
                            $composer3 = valueOf8;
                            if (!Intrinsics.areEqual(composer21.rememberedValue(), Integer.valueOf($dirty1))) {
                                composer21.updateRememberedValue(Integer.valueOf($dirty1));
                                constructor-impl10.apply(Integer.valueOf($dirty1), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            } else {
                                composer3 = composer21;
                            }
                        } else {
                            $composer3 = valueOf8;
                        }
                        Updater.set-impl(constructor-impl10, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                        valueOf8 = $composer3;
                        valueOf5 = 0;
                        ComposerKt.sourceInformationMarkerStart(valueOf8, -2146769399, str);
                        iNSTANCE3 = BoxScopeInstance.INSTANCE;
                        i181 |= 6;
                        composer8 = valueOf8;
                        companion = 0;
                        i11 = i52;
                        currentCompositeKeyHash3 = materializeModifier2;
                        ComposerKt.sourceInformationMarkerStart(valueOf8, -364618873, "C581@28525L12:OutlinedTextField.kt#uh7d8r");
                        supporting.invoke(valueOf8, Integer.valueOf(i53 &= 14));
                        ComposerKt.sourceInformationMarkerEnd(valueOf8);
                        ComposerKt.sourceInformationMarkerEnd(valueOf8);
                        $composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                    } else {
                        obj4 = supporting;
                        $composer3 = valueOf8;
                    }
                    $composer3.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    composer9.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer9);
                    ComposerKt.sourceInformationMarkerEnd(composer9);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    restartGroup.skipToGroupEnd();
                    obj4 = supporting;
                    i13 = traceInProgress2;
                    composer9 = restartGroup;
                    i21 = str;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer9.endRestartGroup();
        if (endRestartGroup != null) {
            $composer2 = composer9;
            endRestartGroup = new OutlinedTextFieldKt.OutlinedTextFieldLayout.2(modifier, textField, placeholder, label, leading, trailing, prefix, obj11, singleLine, $this$dp$iv, onLabelMeasured, container, obj4, obj3, $changed, $changed1);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        } else {
            $composer2 = composer9;
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
        int i9;
        int place$calculateVerticalPosition2;
        int i11;
        int place$calculateVerticalPosition;
        int height;
        int i10;
        int i;
        int i4;
        int i6;
        int i12;
        int i2;
        int textHorizontalPosition;
        Placeable.PlacementScope placementScope;
        Placeable placeable;
        int i7;
        int align;
        int i5;
        int i8;
        int i3;
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
                i11 = 0;
            } else {
                i18 *= i10;
            }
            Placeable.PlacementScope.placeRelative$default($this$place, placeable, place$calculateVerticalPosition2 + i22, MathHelpersKt.lerp(widthOrZero, -i16, f3), 0, 4, 0);
        }
        if (placeable3 != null) {
            Placeable.PlacementScope.placeRelative$default($this$place, placeable3, TextFieldImplKt.widthOrZero(leadingPlaceable), OutlinedTextFieldKt.place$calculateVerticalPosition(z, i20, roundToInt2, placeable5, placeable3), 0, 4, 0);
        }
        i9 = widthOrZero2 + widthOrZero4;
        placeable2 = textFieldPlaceable;
        Placeable.PlacementScope.placeRelative$default($this$place, placeable2, i9, OutlinedTextFieldKt.place$calculateVerticalPosition(z, i20, roundToInt2, placeable5, placeable2), 0, 4, 0);
        if (placeable6 != null) {
            Placeable.PlacementScope.placeRelative$default($this$place, placeable6, i9, OutlinedTextFieldKt.place$calculateVerticalPosition(z, i20, roundToInt2, placeable5, placeable6), 0, 4, 0);
            textHorizontalPosition = i9;
        } else {
            textHorizontalPosition = i9;
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
