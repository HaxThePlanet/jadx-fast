package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
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
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000¤\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u000f\u001aØ\u0002\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\u00060\n2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\u0015\u0008\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\u0008\u00142\u0015\u0008\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\u0008\u00142\u0015\u0008\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\u0008\u00142\u0015\u0008\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\u0008\u00142\u0015\u0008\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\u0008\u00142\u0015\u0008\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\u0008\u00142\u0015\u0008\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\u0008\u00142\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u001d2\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u001f2\u0008\u0008\u0002\u0010 \u001a\u00020!2\u0008\u0008\u0002\u0010\"\u001a\u00020\u000e2\u0008\u0008\u0002\u0010#\u001a\u00020$2\u0008\u0008\u0002\u0010%\u001a\u00020$2\n\u0008\u0002\u0010&\u001a\u0004\u0018\u00010'2\u0008\u0008\u0002\u0010(\u001a\u00020)2\u0008\u0008\u0002\u0010*\u001a\u00020+H\u0007¢\u0006\u0002\u0010,\u001aØ\u0002\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020-2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u00060\n2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\u0015\u0008\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\u0008\u00142\u0015\u0008\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\u0008\u00142\u0015\u0008\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\u0008\u00142\u0015\u0008\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\u0008\u00142\u0015\u0008\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\u0008\u00142\u0015\u0008\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\u0008\u00142\u0015\u0008\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\u0008\u00142\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u001d2\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u001f2\u0008\u0008\u0002\u0010 \u001a\u00020!2\u0008\u0008\u0002\u0010\"\u001a\u00020\u000e2\u0008\u0008\u0002\u0010#\u001a\u00020$2\u0008\u0008\u0002\u0010%\u001a\u00020$2\n\u0008\u0002\u0010&\u001a\u0004\u0018\u00010'2\u0008\u0008\u0002\u0010(\u001a\u00020)2\u0008\u0008\u0002\u0010*\u001a\u00020+H\u0007¢\u0006\u0002\u0010.\u001aì\u0001\u0010/\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u000c2\u0011\u00100\u001a\r\u0012\u0004\u0012\u00020\u00060\u0013¢\u0006\u0002\u0008\u00142\u0013\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\u0008\u00142\u0019\u0010\u0015\u001a\u0015\u0012\u0004\u0012\u00020\u000c\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n¢\u0006\u0002\u0008\u00142\u0013\u00101\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\u0008\u00142\u0013\u00102\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\u0008\u00142\u0013\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\u0008\u00142\u0013\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\u0008\u00142\u0006\u0010\"\u001a\u00020\u000e2\u0006\u00103\u001a\u0002042\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00060\u0013¢\u0006\u0002\u0008\u00142\u0013\u00106\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\u0008\u00142\u0006\u00107\u001a\u000208H\u0001¢\u0006\u0002\u00109\u001ar\u0010:\u001a\u00020$2\u0006\u0010;\u001a\u00020$2\u0006\u0010<\u001a\u00020$2\u0006\u0010=\u001a\u00020$2\u0006\u0010>\u001a\u00020$2\u0006\u0010?\u001a\u00020$2\u0006\u0010@\u001a\u00020$2\u0006\u0010A\u001a\u00020$2\u0006\u0010B\u001a\u00020$2\u0006\u00103\u001a\u0002042\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u0002042\u0006\u00107\u001a\u000208H\u0002ø\u0001\u0000¢\u0006\u0004\u0008F\u0010G\u001aR\u0010H\u001a\u00020$2\u0006\u0010I\u001a\u00020$2\u0006\u0010J\u001a\u00020$2\u0006\u0010K\u001a\u00020$2\u0006\u0010L\u001a\u00020$2\u0006\u0010M\u001a\u00020$2\u0006\u0010N\u001a\u00020$2\u0006\u0010O\u001a\u00020$2\u0006\u0010C\u001a\u00020DH\u0002ø\u0001\u0000¢\u0006\u0004\u0008P\u0010Q\u001a\u001a\u0010R\u001a\u00020\u000c*\u00020\u000c2\u000c\u0010S\u001a\u0008\u0012\u0004\u0012\u00020U0TH\u0000\u001a\u009a\u0001\u0010V\u001a\u00020\u0006*\u00020W2\u0006\u0010X\u001a\u00020$2\u0006\u0010Y\u001a\u00020$2\u0006\u0010Z\u001a\u00020[2\u0008\u0010\\\u001a\u0004\u0018\u00010[2\u0008\u0010]\u001a\u0004\u0018\u00010[2\u0008\u0010^\u001a\u0004\u0018\u00010[2\u0008\u0010_\u001a\u0004\u0018\u00010[2\u0008\u0010`\u001a\u0004\u0018\u00010[2\u0008\u0010a\u001a\u0004\u0018\u00010[2\u0006\u0010b\u001a\u00020[2\u0008\u0010c\u001a\u0004\u0018\u00010[2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010d\u001a\u00020$2\u0006\u0010e\u001a\u00020$2\u0006\u00103\u001a\u0002042\u0006\u0010E\u001a\u000204H\u0002\u001a\u0080\u0001\u0010f\u001a\u00020\u0006*\u00020W2\u0006\u0010X\u001a\u00020$2\u0006\u0010Y\u001a\u00020$2\u0006\u0010g\u001a\u00020[2\u0008\u0010]\u001a\u0004\u0018\u00010[2\u0008\u0010^\u001a\u0004\u0018\u00010[2\u0008\u0010_\u001a\u0004\u0018\u00010[2\u0008\u0010`\u001a\u0004\u0018\u00010[2\u0008\u0010a\u001a\u0004\u0018\u00010[2\u0006\u0010b\u001a\u00020[2\u0008\u0010c\u001a\u0004\u0018\u00010[2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010E\u001a\u0002042\u0006\u00107\u001a\u000208H\u0002\u001a\u0014\u0010h\u001a\u00020$*\u00020$2\u0006\u0010i\u001a\u00020$H\u0002\"\u0016\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\u0008\u0002\u0010\u0003\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006j", d2 = {"TextFieldWithLabelVerticalPadding", "Landroidx/compose/ui/unit/Dp;", "getTextFieldWithLabelVerticalPadding", "()F", "F", "TextField", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "label", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "placeholder", "leadingIcon", "trailingIcon", "prefix", "suffix", "supportingText", "isError", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "minLines", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/TextFieldColors;", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "TextFieldLayout", "textField", "leading", "trailing", "animationProgress", "", "container", "supporting", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZFLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;II)V", "calculateHeight", "textFieldHeight", "labelHeight", "leadingHeight", "trailingHeight", "prefixHeight", "suffixHeight", "placeholderHeight", "supportingHeight", "constraints", "Landroidx/compose/ui/unit/Constraints;", "density", "calculateHeight-mKXJcVc", "(IIIIIIIIFJFLandroidx/compose/foundation/layout/PaddingValues;)I", "calculateWidth", "leadingWidth", "trailingWidth", "prefixWidth", "suffixWidth", "textFieldWidth", "labelWidth", "placeholderWidth", "calculateWidth-yeHjK3Y", "(IIIIIIIJ)I", "drawIndicatorLine", "indicatorBorder", "Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/BorderStroke;", "placeWithLabel", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "width", "totalHeight", "textfieldPlaceable", "Landroidx/compose/ui/layout/Placeable;", "labelPlaceable", "placeholderPlaceable", "leadingPlaceable", "trailingPlaceable", "prefixPlaceable", "suffixPlaceable", "containerPlaceable", "supportingPlaceable", "labelEndPosition", "textPosition", "placeWithoutLabel", "textPlaceable", "substractConstraintSafely", "from", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TextFieldKt {

    private static final float TextFieldWithLabelVerticalPadding;
    static {
        final int i2 = 0;
        TextFieldKt.TextFieldWithLabelVerticalPadding = Dp.constructor-impl((float)i);
    }

    public static final void TextField(TextFieldValue value, Function1<? super TextFieldValue, Unit> onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> label, Function2<? super Composer, ? super Integer, Unit> placeholder, Function2<? super Composer, ? super Integer, Unit> leadingIcon, Function2<? super Composer, ? super Integer, Unit> trailingIcon, Function2<? super Composer, ? super Integer, Unit> prefix, Function2<? super Composer, ? super Integer, Unit> suffix, Function2<? super Composer, ? super Integer, Unit> supportingText, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, int minLines, MutableInteractionSource interactionSource, Shape shape, androidx.compose.material3.TextFieldColors colors, Composer $composer, int $changed, int $changed1, int $changed2, int i28) {
        Object obj15;
        Object obj5;
        Object obj11;
        Object obj13;
        Object obj18;
        Object obj10;
        boolean z;
        Object obj6;
        Object obj14;
        Object obj17;
        boolean z3;
        int i29;
        int i19;
        Object obj19;
        Object obj2;
        Object obj20;
        int skipping;
        int i27;
        int i47;
        Object colors3;
        int defaultsInvalid;
        int this_$iv;
        int placeholder2;
        Composer textStyle2;
        int traceInProgress;
        int rememberedValue;
        long focused;
        int leadingIcon2;
        Object leadingIcon3;
        ScopeUpdateScope endRestartGroup;
        int trailingIcon3;
        boolean traceInProgress2;
        Object $i$a$CacheTextFieldKt$TextField$interactionSource$2;
        Object modifier4;
        boolean $composer2;
        int $dirty3;
        boolean $dirty;
        int $dirty1;
        Object $dirty12;
        int $dirty2;
        Object $dirty22;
        int i52;
        Object obj12;
        int i48;
        Object str;
        int modifier2;
        boolean l;
        int i49;
        boolean z2;
        int i44;
        int i42;
        Object obj9;
        Object textStyle4;
        int modifier3;
        int i36;
        int prefix3;
        int i57;
        int prefix4;
        int isError4;
        Object obj;
        Object label2;
        int colors2;
        Object obj3;
        VisualTransformation visualTransformation2;
        int suffix2;
        KeyboardOptions keyboardOptions2;
        int i2;
        int supportingText2;
        KeyboardActions enabled2;
        int i41;
        int i10;
        boolean visualTransformation3;
        Object visualTransformation4;
        int readOnly2;
        int changed;
        int keyboardOptions3;
        int i59;
        int i46;
        int i31;
        int changed5;
        Object isError3;
        int isError2;
        int keyboardOptions4;
        int i15;
        KeyboardActions keyboardActions3;
        int keyboardActions2;
        int i39;
        int singleLine2;
        Shape singleLine3;
        int i35;
        int maxLines2;
        androidx.compose.material3.TextFieldColors maxLines3;
        int minLines2;
        int i7;
        int i8;
        int i64;
        int changed4;
        Object interactionSource2;
        int interactionSource3;
        int i63;
        int i33;
        Object i58;
        int changed2;
        int obj7;
        int placeholder3;
        int changed3;
        int obj16;
        Composer leadingIcon4;
        int i32;
        int obj4;
        int trailingIcon2;
        int i20;
        int obj8;
        int prefix2;
        int i26;
        int i40;
        int i3;
        int i25;
        int i62;
        TextStyle textStyle3;
        int i4;
        int i53;
        int i13;
        int i11;
        int i;
        int i37;
        int i21;
        int i34;
        int i51;
        boolean changed6;
        int i23;
        int i9;
        int i55;
        int i18;
        int i43;
        int i14;
        int i24;
        int i54;
        int i65;
        int i45;
        int i16;
        int i6;
        int i5;
        int i56;
        int i50;
        int i60;
        int i61;
        int i17;
        int i12;
        int i30;
        int i38;
        int i22;
        ScopeUpdateScope scopeUpdateScope;
        int obj70;
        int obj71;
        Shape obj72;
        int i66 = $changed;
        int i86 = $changed1;
        trailingIcon3 = $changed2;
        int i95 = i28;
        Composer restartGroup = $composer.startRestartGroup(-1268528240);
        ComposerKt.sourceInformation(restartGroup, "C(TextField)P(21,11,10,1,14,19,6,12,7,20,13,17,18,3,22,5,4,16,8,9,2,15)357@19138L7,373@19934L5,374@19989L8,386@20569L1961,386@20482L2048:TextField.kt#uh7d8r");
        $dirty3 = $changed;
        $dirty1 = $changed1;
        $dirty2 = $changed2;
        if (i95 & 1 != 0) {
            $dirty3 |= 6;
            obj3 = value;
        } else {
            if (i66 & 6 == 0) {
                i52 = restartGroup.changed(value) ? 4 : 2;
                $dirty3 |= i52;
            } else {
                obj3 = value;
            }
        }
        if (i95 & 2 != 0) {
            $dirty3 |= 48;
            obj12 = onValueChange;
        } else {
            if (i66 & 48 == 0) {
                i36 = restartGroup.changedInstance(onValueChange) ? 32 : 16;
                $dirty3 |= i36;
            } else {
                obj12 = onValueChange;
            }
        }
        i57 = i95 & 4;
        int i106 = 128;
        if (i57 != 0) {
            $dirty3 |= 384;
            str = modifier;
        } else {
            if (i66 & 384 == 0) {
                i2 = restartGroup.changed(modifier) ? 256 : i106;
                $dirty3 |= i2;
            } else {
                str = modifier;
            }
        }
        supportingText2 = i95 & 8;
        changed = 1024;
        if (supportingText2 != 0) {
            $dirty3 |= 3072;
            l = enabled;
        } else {
            if (i66 & 3072 == 0) {
                i15 = restartGroup.changed(enabled) ? i41 : changed;
                $dirty3 |= i15;
            } else {
                l = enabled;
            }
        }
        int i109 = i95 & 16;
        i35 = 8192;
        if (i109 != 0) {
            $dirty3 |= 24576;
            z2 = readOnly;
        } else {
            if (i66 & 24576 == 0) {
                i7 = restartGroup.changed(readOnly) ? i39 : i35;
                $dirty3 |= i7;
            } else {
                z2 = readOnly;
            }
        }
        i8 = 196608;
        i33 = 65536;
        if (i66 & i8 == 0) {
            if (i95 & 32 == 0) {
                changed2 = restartGroup.changed(textStyle) ? 131072 : i33;
            } else {
                obj9 = textStyle;
            }
            $dirty3 |= changed2;
        } else {
            obj9 = textStyle;
        }
        int i121 = i95 & 64;
        changed3 = 1572864;
        if (i121 != 0) {
            $dirty3 |= changed3;
            obj = label;
        } else {
            if (i66 & changed3 == 0) {
                i20 = restartGroup.changedInstance(label) ? 1048576 : 524288;
                $dirty3 |= i20;
            } else {
                obj = label;
            }
        }
        int i67 = i95 & 128;
        int i122 = 12582912;
        i26 = 4194304;
        if (i67 != 0) {
            $dirty3 |= i122;
            i40 = i67;
            obj15 = placeholder;
        } else {
            if ($changed & i122 == 0) {
                i40 = i67;
                i3 = restartGroup.changedInstance(placeholder) ? 8388608 : i26;
                $dirty3 |= i3;
            } else {
                i40 = i67;
                obj15 = placeholder;
            }
        }
        int i68 = i95 & 256;
        int i124 = 100663296;
        if (i68 != 0) {
            $dirty3 |= i124;
            i25 = i68;
            obj5 = leadingIcon;
        } else {
            if ($changed & i124 == 0) {
                i25 = i68;
                i62 = restartGroup.changedInstance(leadingIcon) ? 67108864 : 33554432;
                $dirty3 |= i62;
            } else {
                i25 = i68;
                obj5 = leadingIcon;
            }
        }
        int i69 = i95 & 512;
        textStyle3 = 805306368;
        if (i69 != 0) {
            $dirty3 |= textStyle3;
            i4 = i69;
            obj11 = trailingIcon;
        } else {
            if ($changed & textStyle3 == 0) {
                i4 = i69;
                i53 = restartGroup.changedInstance(trailingIcon) ? 536870912 : 268435456;
                $dirty3 |= i53;
            } else {
                i4 = i69;
                obj11 = trailingIcon;
            }
        }
        int i70 = i95 & 1024;
        if (i70 != 0) {
            $dirty1 |= 6;
            i13 = i70;
            obj13 = prefix;
        } else {
            if (i86 & 6 == 0) {
                i13 = i70;
                i11 = restartGroup.changedInstance(prefix) ? 4 : 2;
                $dirty1 |= i11;
            } else {
                i13 = i70;
                obj13 = prefix;
            }
        }
        int i71 = i95 & 2048;
        if (i71 != 0) {
            $dirty1 |= 48;
            i = i71;
            obj18 = suffix;
        } else {
            if (i86 & 48 == 0) {
                i = i71;
                i37 = restartGroup.changedInstance(suffix) ? 32 : 16;
                $dirty1 |= i37;
            } else {
                i = i71;
                obj18 = suffix;
            }
        }
        int i72 = i95 & 4096;
        if (i72 != 0) {
            $dirty1 |= 384;
            i21 = i72;
            obj10 = supportingText;
        } else {
            i21 = i72;
            if (i86 & 384 == 0) {
                i34 = restartGroup.changedInstance(supportingText) ? 256 : i106;
                $dirty1 |= i34;
            } else {
                obj10 = supportingText;
            }
        }
        int i74 = i95 & 8192;
        if (i74 != 0) {
            $dirty1 |= 3072;
            i51 = i74;
            z = isError;
        } else {
            i51 = i74;
            if (i86 & 3072 == 0) {
                if (restartGroup.changed(isError)) {
                } else {
                    i41 = changed;
                }
                $dirty1 |= i41;
            } else {
                z = isError;
            }
        }
        int i75 = i95 & 16384;
        if (i75 != 0) {
            $dirty1 |= 24576;
            i10 = i75;
            obj6 = visualTransformation;
        } else {
            i10 = i75;
            if (i86 & 24576 == 0) {
                if (restartGroup.changed(visualTransformation)) {
                } else {
                    i39 = i35;
                }
                $dirty1 |= i39;
            } else {
                obj6 = visualTransformation;
            }
        }
        keyboardOptions3 = i95 & i107;
        if (keyboardOptions3 != 0) {
            $dirty1 |= i8;
            obj14 = keyboardOptions;
        } else {
            if (i86 & i8 == 0) {
                i39 = restartGroup.changed(keyboardOptions) ? 131072 : i33;
                $dirty1 |= i39;
            } else {
                obj14 = keyboardOptions;
            }
        }
        int i110 = i95 & i33;
        if (i110 != 0) {
            $dirty1 |= changed3;
            obj17 = keyboardActions;
        } else {
            if (i86 & changed3 == 0) {
                i35 = restartGroup.changed(keyboardActions) ? 1048576 : 524288;
                $dirty1 |= i35;
            } else {
                obj17 = keyboardActions;
            }
        }
        int i112 = i95 & i111;
        if (i112 != 0) {
            $dirty1 |= i122;
            z3 = singleLine;
        } else {
            if (i86 & i122 == 0) {
                i8 = restartGroup.changed(singleLine) ? 8388608 : i26;
                $dirty1 |= i8;
            } else {
                z3 = singleLine;
            }
        }
        if (i86 & i115 == 0) {
            if (i95 & i116 == 0) {
                i64 = restartGroup.changed(maxLines) ? 67108864 : 33554432;
            } else {
                i29 = maxLines;
            }
            $dirty1 |= i64;
        } else {
            i29 = maxLines;
        }
        interactionSource2 = i95 & i117;
        if (interactionSource2 != 0) {
            $dirty1 |= textStyle3;
            i19 = minLines;
        } else {
            if (i86 & textStyle3 == 0) {
                i33 = restartGroup.changed(minLines) ? 536870912 : 268435456;
                $dirty1 |= i33;
            } else {
                i19 = minLines;
            }
        }
        i58 = i95 & i120;
        if (i58 != 0) {
            $dirty2 |= 6;
            obj19 = interactionSource;
        } else {
            if (trailingIcon3 & 6 == 0) {
                i31 = restartGroup.changed(interactionSource) ? 4 : 2;
                $dirty2 |= i31;
            } else {
                obj19 = interactionSource;
            }
        }
        if (trailingIcon3 & 48 == 0) {
            if (i95 & i108 == 0) {
                minLines2 = restartGroup.changed(shape) ? 32 : 16;
            } else {
                obj2 = shape;
            }
            $dirty2 |= minLines2;
        } else {
            obj2 = shape;
        }
        if (trailingIcon3 & 384 == 0) {
            if (i95 & i26 == 0) {
                i32 = restartGroup.changed(colors) ? 256 : i106;
            } else {
                obj20 = colors;
            }
            $dirty2 |= i32;
        } else {
            obj20 = colors;
        }
        if ($dirty3 & suffix2 == 306783378 && i82 &= $dirty1 == 306783378 && $dirty2 & 147 == 146) {
            if (i82 &= $dirty1 == 306783378) {
                if ($dirty2 & 147 == 146) {
                    if (!restartGroup.getSkipping()) {
                        restartGroup.startDefaults();
                        if ($changed & 1 != 0) {
                            if (restartGroup.getDefaultsInvalid()) {
                                if (i57 != 0) {
                                    str = defaultsInvalid;
                                }
                                if (supportingText2 != 0) {
                                    l = defaultsInvalid;
                                }
                                if (i109 != 0) {
                                    z2 = defaultsInvalid;
                                }
                                if (i95 & 32 != 0) {
                                    i57 = 6;
                                    suffix2 = 0;
                                    ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                                    $dirty3 &= traceInProgress;
                                    obj9 = this_$iv;
                                }
                                if (i121 != 0) {
                                    obj = this_$iv;
                                }
                                placeholder2 = i40 != 0 ? 0 : placeholder;
                                leadingIcon2 = i25 != 0 ? 0 : leadingIcon;
                                trailingIcon3 = i4 != 0 ? 0 : trailingIcon;
                                prefix4 = i13 != 0 ? 0 : prefix;
                                suffix2 = i != 0 ? 0 : suffix;
                                supportingText2 = i21 != 0 ? 0 : supportingText;
                                isError2 = i51 != 0 ? 0 : isError;
                                if (i10 != 0) {
                                    visualTransformation4 = VisualTransformation.Companion.getNone();
                                } else {
                                    visualTransformation4 = visualTransformation;
                                }
                                if (keyboardOptions3 != 0) {
                                    keyboardOptions3 = KeyboardOptions.Companion.getDefault();
                                } else {
                                    keyboardOptions3 = keyboardOptions;
                                }
                                if (i110 != 0) {
                                    keyboardActions3 = KeyboardActions.Companion.getDefault();
                                } else {
                                    keyboardActions3 = keyboardActions;
                                }
                                singleLine2 = i112 != 0 ? 0 : singleLine;
                                if (i95 & i113 != 0) {
                                    maxLines2 = singleLine2 != 0 ? 1 : 0x7fffffff /* Unknown resource */;
                                    $dirty1 &= minLines2;
                                } else {
                                    maxLines2 = maxLines;
                                }
                                minLines2 = interactionSource2 != 0 ? 1 : minLines;
                                interactionSource3 = i58 != 0 ? 0 : interactionSource;
                                obj70 = placeholder2;
                                int placeholder4 = 6;
                                if (i95 & i118 != 0) {
                                    obj71 = leadingIcon2;
                                    leadingIcon3 = TextFieldDefaults.INSTANCE.getShape(restartGroup, placeholder4);
                                    $dirty2 &= -113;
                                } else {
                                    obj71 = leadingIcon2;
                                    leadingIcon3 = shape;
                                }
                                if (i95 & i26 != 0) {
                                    obj7 = obj70;
                                    obj16 = obj71;
                                    i25 = obj72;
                                    $dirty2 = i88;
                                    obj4 = trailingIcon3;
                                    obj8 = prefix4;
                                    i58 = obj;
                                    i26 = suffix2;
                                    i40 = supportingText2;
                                    prefix3 = isError2;
                                    rememberedValue = interactionSource3;
                                    label2 = colors4;
                                    colors3 = obj9;
                                    interactionSource2 = visualTransformation4;
                                    isError3 = keyboardOptions3;
                                    textStyle4 = str;
                                    visualTransformation3 = z2;
                                } else {
                                    obj7 = obj70;
                                    obj16 = obj71;
                                    i25 = obj72;
                                    obj4 = trailingIcon3;
                                    colors3 = obj9;
                                    obj8 = prefix4;
                                    i58 = obj;
                                    i26 = suffix2;
                                    i40 = supportingText2;
                                    prefix3 = isError2;
                                    rememberedValue = interactionSource3;
                                    label2 = colors;
                                    textStyle4 = str;
                                    interactionSource2 = visualTransformation4;
                                    isError3 = keyboardOptions3;
                                    visualTransformation3 = z2;
                                }
                            } else {
                                restartGroup.skipToGroupEnd();
                                if (i95 & 32 != 0) {
                                    $dirty3 &= i27;
                                }
                                if (i77 &= i95 != 0) {
                                    $dirty1 &= i47;
                                }
                                if (i78 &= i95 != 0) {
                                    $dirty2 &= -113;
                                }
                                if (i95 & i26 != 0) {
                                    obj7 = placeholder;
                                    obj16 = leadingIcon;
                                    obj4 = trailingIcon;
                                    obj8 = prefix;
                                    i26 = suffix;
                                    i40 = supportingText;
                                    prefix3 = isError;
                                    interactionSource2 = visualTransformation;
                                    isError3 = keyboardOptions;
                                    keyboardActions3 = keyboardActions;
                                    singleLine2 = singleLine;
                                    maxLines2 = maxLines;
                                    minLines2 = minLines;
                                    rememberedValue = interactionSource;
                                    i25 = shape;
                                    $dirty2 = i81;
                                    visualTransformation3 = z2;
                                    colors3 = obj9;
                                    i58 = obj;
                                    label2 = colors;
                                    textStyle4 = str;
                                } else {
                                    obj7 = placeholder;
                                    obj16 = leadingIcon;
                                    obj4 = trailingIcon;
                                    obj8 = prefix;
                                    i26 = suffix;
                                    i40 = supportingText;
                                    prefix3 = isError;
                                    interactionSource2 = visualTransformation;
                                    isError3 = keyboardOptions;
                                    keyboardActions3 = keyboardActions;
                                    singleLine2 = singleLine;
                                    maxLines2 = maxLines;
                                    minLines2 = minLines;
                                    rememberedValue = interactionSource;
                                    i25 = shape;
                                    visualTransformation3 = z2;
                                    colors3 = obj9;
                                    i58 = obj;
                                    label2 = colors;
                                    textStyle4 = str;
                                }
                            }
                        } else {
                        }
                        restartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1268528240, $dirty3, $dirty1, "androidx.compose.material3.TextField (TextField.kt:375)");
                        }
                        restartGroup.startReplaceGroup(-508241210);
                        ComposerKt.sourceInformation(restartGroup, "377@20083L39");
                        if (rememberedValue == 0) {
                            ComposerKt.sourceInformationMarkerStart(restartGroup, -508240559, "CC(remember):TextField.kt#9igjgp");
                            str = restartGroup;
                            z2 = 0;
                            obj70 = rememberedValue;
                            rememberedValue = str.rememberedValue();
                            suffix2 = 0;
                            obj71 = i93;
                            if (rememberedValue == Composer.Companion.getEmpty()) {
                                int i94 = 0;
                                str.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                            } else {
                                $i$a$CacheTextFieldKt$TextField$interactionSource$2 = rememberedValue;
                            }
                            ComposerKt.sourceInformationMarkerEnd(restartGroup);
                            i63 = $i$a$CacheTextFieldKt$TextField$interactionSource$2;
                        } else {
                            i63 = obj70;
                        }
                        restartGroup.endReplaceGroup();
                        restartGroup.startReplaceGroup(-508235100);
                        ComposerKt.sourceInformation(restartGroup, "*381@20307L25");
                        focused = colors3.getColor-0d7_KjU();
                        int i101 = 0;
                        i44 = 0;
                        i59 = Long.compare(l2, i126) != 0 ? 1 : 0;
                        if (i59 != 0) {
                        } else {
                            i44 = 0;
                            obj71 = focused;
                            focused = label2.textColor-XeAY9LY$material3_release(l, prefix3, (Boolean)FocusInteractionKt.collectIsFocusedAsState((InteractionSource)i63, restartGroup, 0).getValue().booleanValue());
                        }
                        restartGroup.endReplaceGroup();
                        textStyle3 = new TextStyle(focused, i13, 0, i21, 0, 0, 0, 0, 0, 0, obj46, 0, 0, 0, 0, obj51, 0, 0, 0, 0, 0, 0, obj58, 0, 0, 0, 0, 0, 0, 16777214, 0);
                        boolean z4 = l;
                        TextFieldKt.TextField.3 anon = new TextFieldKt.TextField.3(textStyle4, prefix3, label2, obj3, obj12, z4, visualTransformation3, colors3.merge(textStyle3), isError3, keyboardActions3, singleLine2, maxLines2, minLines2, interactionSource2, i63, i58, obj7, obj16, obj4, obj8, i26, i40, i25);
                        CompositionLocalKt.CompositionLocalProvider(TextSelectionColorsKt.getLocalTextSelectionColors().provides(label2.getTextSelectionColors()), (Function2)ComposableLambdaKt.rememberComposableLambda(-1163788208, true, anon, restartGroup, 54), restartGroup, $stable |= 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        str = textStyle4;
                        keyboardOptions2 = isError3;
                        i46 = maxLines2;
                        keyboardOptions4 = minLines2;
                        visualTransformation2 = interactionSource2;
                        i48 = obj7;
                        i49 = obj4;
                        i42 = obj8;
                        modifier3 = i26;
                        placeholder3 = $dirty3;
                        trailingIcon2 = $dirty1;
                        prefix2 = $dirty2;
                        maxLines3 = label2;
                        $dirty = visualTransformation3;
                        readOnly2 = singleLine2;
                        $dirty22 = i58;
                        singleLine3 = i25;
                        $dirty12 = colors3;
                        textStyle2 = restartGroup;
                        colors2 = prefix3;
                        $composer2 = z4;
                        enabled2 = keyboardActions3;
                        isError4 = i40;
                        keyboardActions2 = obj70;
                    } else {
                        restartGroup.skipToGroupEnd();
                        i48 = placeholder;
                        obj16 = leadingIcon;
                        isError4 = supportingText;
                        visualTransformation2 = visualTransformation;
                        keyboardOptions2 = keyboardOptions;
                        enabled2 = keyboardActions;
                        readOnly2 = singleLine;
                        i46 = maxLines;
                        keyboardOptions4 = minLines;
                        keyboardActions2 = interactionSource;
                        singleLine3 = shape;
                        maxLines3 = colors;
                        textStyle2 = restartGroup;
                        placeholder3 = $dirty3;
                        trailingIcon2 = $dirty1;
                        prefix2 = $dirty2;
                        $composer2 = l;
                        $dirty = z2;
                        $dirty12 = obj9;
                        $dirty22 = obj;
                        i49 = trailingIcon;
                        i42 = prefix;
                        modifier3 = suffix;
                        colors2 = isError;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        endRestartGroup = textStyle2.endRestartGroup();
        if (endRestartGroup != null) {
            leadingIcon4 = composer;
            textStyle2 = new TextFieldKt.TextField.4(value, onValueChange, str, $composer2, $dirty, $dirty12, $dirty22, i48, obj16, i49, i42, modifier3, isError4, colors2, visualTransformation2, keyboardOptions2, enabled2, readOnly2, i46, keyboardOptions4, keyboardActions2, singleLine3, maxLines3, $changed, $changed1, $changed2, i95);
            endRestartGroup.updateScope((Function2)textStyle2);
        } else {
            modifier4 = str;
            modifier2 = obj16;
            leadingIcon4 = textStyle2;
        }
    }

    public static final void TextField(String value, Function1<? super String, Unit> onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> label, Function2<? super Composer, ? super Integer, Unit> placeholder, Function2<? super Composer, ? super Integer, Unit> leadingIcon, Function2<? super Composer, ? super Integer, Unit> trailingIcon, Function2<? super Composer, ? super Integer, Unit> prefix, Function2<? super Composer, ? super Integer, Unit> suffix, Function2<? super Composer, ? super Integer, Unit> supportingText, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, int minLines, MutableInteractionSource interactionSource, Shape shape, androidx.compose.material3.TextFieldColors colors, Composer $composer, int $changed, int $changed1, int $changed2, int i28) {
        Object obj5;
        Object obj;
        Object obj18;
        Object obj15;
        Object obj17;
        Object obj4;
        boolean z;
        Object obj14;
        Object obj12;
        Object obj10;
        boolean z2;
        int i37;
        int i16;
        Object obj3;
        Object obj9;
        Object obj2;
        int skipping;
        int i38;
        int i46;
        Object colors2;
        int defaultsInvalid;
        int this_$iv;
        int placeholder2;
        Composer textStyle3;
        int traceInProgress;
        int rememberedValue;
        long focused;
        int leadingIcon4;
        Object leadingIcon3;
        ScopeUpdateScope endRestartGroup;
        int trailingIcon2;
        boolean traceInProgress2;
        Object $i$a$CacheTextFieldKt$TextField$interactionSource$1;
        Object modifier2;
        boolean $composer2;
        int $dirty;
        boolean $dirty3;
        int $dirty1;
        Object $dirty12;
        int $dirty2;
        Object $dirty22;
        int i10;
        Object obj16;
        int i25;
        Object str;
        int modifier3;
        boolean l;
        int i17;
        boolean z3;
        int i12;
        int i58;
        Object obj8;
        Object textStyle4;
        int modifier4;
        int i51;
        int prefix4;
        int i5;
        int prefix2;
        int isError3;
        Object obj20;
        Object label2;
        int colors3;
        Object obj11;
        VisualTransformation visualTransformation2;
        int suffix2;
        KeyboardOptions keyboardOptions2;
        int i65;
        int supportingText2;
        KeyboardActions enabled2;
        int i13;
        int i64;
        boolean visualTransformation3;
        Object visualTransformation4;
        int readOnly2;
        int changed2;
        int keyboardOptions3;
        int i18;
        int i8;
        int i26;
        int changed4;
        Object isError2;
        int isError4;
        int keyboardOptions4;
        int i62;
        KeyboardActions keyboardActions3;
        int keyboardActions2;
        int i42;
        int singleLine2;
        Shape singleLine3;
        int i41;
        int maxLines3;
        androidx.compose.material3.TextFieldColors maxLines2;
        int minLines2;
        int i2;
        int i52;
        int i7;
        int changed3;
        Object interactionSource2;
        int interactionSource3;
        int i6;
        int i61;
        Object i33;
        int changed;
        int obj19;
        int placeholder3;
        int changed6;
        int obj7;
        Composer leadingIcon2;
        int i34;
        int obj13;
        int trailingIcon3;
        int i35;
        int obj6;
        int prefix3;
        int i53;
        int i21;
        int i63;
        int i39;
        int i45;
        TextStyle textStyle2;
        int i47;
        int i30;
        int i54;
        int i60;
        int i48;
        int i49;
        int i43;
        int i11;
        int i36;
        boolean changed5;
        int i40;
        int i22;
        int i55;
        int i56;
        int i24;
        int i29;
        int i9;
        int i20;
        int i23;
        int i31;
        int i4;
        int i32;
        int i59;
        int i27;
        int i57;
        int i50;
        int i3;
        int i;
        int i14;
        int i19;
        int i44;
        int i15;
        ScopeUpdateScope scopeUpdateScope;
        int obj70;
        int obj71;
        Shape obj72;
        int i66 = $changed;
        int i86 = $changed1;
        trailingIcon2 = $changed2;
        int i95 = i28;
        Composer restartGroup = $composer.startRestartGroup(-676242365);
        ComposerKt.sourceInformation(restartGroup, "C(TextField)P(21,11,10,1,14,19,6,12,7,20,13,17,18,3,22,5,4,16,8,9,2,15)201@10573L7,217@11369L5,218@11424L8,230@12004L1956,230@11917L2043:TextField.kt#uh7d8r");
        $dirty = $changed;
        $dirty1 = $changed1;
        $dirty2 = $changed2;
        if (i95 & 1 != 0) {
            $dirty |= 6;
            obj11 = value;
        } else {
            if (i66 & 6 == 0) {
                i10 = restartGroup.changed(value) ? 4 : 2;
                $dirty |= i10;
            } else {
                obj11 = value;
            }
        }
        if (i95 & 2 != 0) {
            $dirty |= 48;
            obj16 = onValueChange;
        } else {
            if (i66 & 48 == 0) {
                i51 = restartGroup.changedInstance(onValueChange) ? 32 : 16;
                $dirty |= i51;
            } else {
                obj16 = onValueChange;
            }
        }
        i5 = i95 & 4;
        int i106 = 128;
        if (i5 != 0) {
            $dirty |= 384;
            str = modifier;
        } else {
            if (i66 & 384 == 0) {
                i65 = restartGroup.changed(modifier) ? 256 : i106;
                $dirty |= i65;
            } else {
                str = modifier;
            }
        }
        supportingText2 = i95 & 8;
        changed2 = 1024;
        if (supportingText2 != 0) {
            $dirty |= 3072;
            l = enabled;
        } else {
            if (i66 & 3072 == 0) {
                i62 = restartGroup.changed(enabled) ? i13 : changed2;
                $dirty |= i62;
            } else {
                l = enabled;
            }
        }
        int i109 = i95 & 16;
        i41 = 8192;
        if (i109 != 0) {
            $dirty |= 24576;
            z3 = readOnly;
        } else {
            if (i66 & 24576 == 0) {
                i2 = restartGroup.changed(readOnly) ? i42 : i41;
                $dirty |= i2;
            } else {
                z3 = readOnly;
            }
        }
        i52 = 196608;
        i61 = 65536;
        if (i66 & i52 == 0) {
            if (i95 & 32 == 0) {
                changed = restartGroup.changed(textStyle) ? 131072 : i61;
            } else {
                obj8 = textStyle;
            }
            $dirty |= changed;
        } else {
            obj8 = textStyle;
        }
        int i121 = i95 & 64;
        changed6 = 1572864;
        if (i121 != 0) {
            $dirty |= changed6;
            obj20 = label;
        } else {
            if (i66 & changed6 == 0) {
                i35 = restartGroup.changedInstance(label) ? 1048576 : 524288;
                $dirty |= i35;
            } else {
                obj20 = label;
            }
        }
        int i67 = i95 & 128;
        int i122 = 12582912;
        i53 = 4194304;
        if (i67 != 0) {
            $dirty |= i122;
            i21 = i67;
            obj5 = placeholder;
        } else {
            if ($changed & i122 == 0) {
                i21 = i67;
                i63 = restartGroup.changedInstance(placeholder) ? 8388608 : i53;
                $dirty |= i63;
            } else {
                i21 = i67;
                obj5 = placeholder;
            }
        }
        int i68 = i95 & 256;
        int i124 = 100663296;
        if (i68 != 0) {
            $dirty |= i124;
            i39 = i68;
            obj = leadingIcon;
        } else {
            if ($changed & i124 == 0) {
                i39 = i68;
                i45 = restartGroup.changedInstance(leadingIcon) ? 67108864 : 33554432;
                $dirty |= i45;
            } else {
                i39 = i68;
                obj = leadingIcon;
            }
        }
        int i69 = i95 & 512;
        textStyle2 = 805306368;
        if (i69 != 0) {
            $dirty |= textStyle2;
            i47 = i69;
            obj18 = trailingIcon;
        } else {
            if ($changed & textStyle2 == 0) {
                i47 = i69;
                i30 = restartGroup.changedInstance(trailingIcon) ? 536870912 : 268435456;
                $dirty |= i30;
            } else {
                i47 = i69;
                obj18 = trailingIcon;
            }
        }
        int i70 = i95 & 1024;
        if (i70 != 0) {
            $dirty1 |= 6;
            i54 = i70;
            obj15 = prefix;
        } else {
            if (i86 & 6 == 0) {
                i54 = i70;
                i60 = restartGroup.changedInstance(prefix) ? 4 : 2;
                $dirty1 |= i60;
            } else {
                i54 = i70;
                obj15 = prefix;
            }
        }
        int i71 = i95 & 2048;
        if (i71 != 0) {
            $dirty1 |= 48;
            i48 = i71;
            obj17 = suffix;
        } else {
            if (i86 & 48 == 0) {
                i48 = i71;
                i49 = restartGroup.changedInstance(suffix) ? 32 : 16;
                $dirty1 |= i49;
            } else {
                i48 = i71;
                obj17 = suffix;
            }
        }
        int i72 = i95 & 4096;
        if (i72 != 0) {
            $dirty1 |= 384;
            i43 = i72;
            obj4 = supportingText;
        } else {
            i43 = i72;
            if (i86 & 384 == 0) {
                i11 = restartGroup.changedInstance(supportingText) ? 256 : i106;
                $dirty1 |= i11;
            } else {
                obj4 = supportingText;
            }
        }
        int i74 = i95 & 8192;
        if (i74 != 0) {
            $dirty1 |= 3072;
            i36 = i74;
            z = isError;
        } else {
            i36 = i74;
            if (i86 & 3072 == 0) {
                if (restartGroup.changed(isError)) {
                } else {
                    i13 = changed2;
                }
                $dirty1 |= i13;
            } else {
                z = isError;
            }
        }
        int i75 = i95 & 16384;
        if (i75 != 0) {
            $dirty1 |= 24576;
            i64 = i75;
            obj14 = visualTransformation;
        } else {
            i64 = i75;
            if (i86 & 24576 == 0) {
                if (restartGroup.changed(visualTransformation)) {
                } else {
                    i42 = i41;
                }
                $dirty1 |= i42;
            } else {
                obj14 = visualTransformation;
            }
        }
        keyboardOptions3 = i95 & i107;
        if (keyboardOptions3 != 0) {
            $dirty1 |= i52;
            obj12 = keyboardOptions;
        } else {
            if (i86 & i52 == 0) {
                i42 = restartGroup.changed(keyboardOptions) ? 131072 : i61;
                $dirty1 |= i42;
            } else {
                obj12 = keyboardOptions;
            }
        }
        int i110 = i95 & i61;
        if (i110 != 0) {
            $dirty1 |= changed6;
            obj10 = keyboardActions;
        } else {
            if (i86 & changed6 == 0) {
                i41 = restartGroup.changed(keyboardActions) ? 1048576 : 524288;
                $dirty1 |= i41;
            } else {
                obj10 = keyboardActions;
            }
        }
        int i112 = i95 & i111;
        if (i112 != 0) {
            $dirty1 |= i122;
            z2 = singleLine;
        } else {
            if (i86 & i122 == 0) {
                i52 = restartGroup.changed(singleLine) ? 8388608 : i53;
                $dirty1 |= i52;
            } else {
                z2 = singleLine;
            }
        }
        if (i86 & i115 == 0) {
            if (i95 & i116 == 0) {
                i7 = restartGroup.changed(maxLines) ? 67108864 : 33554432;
            } else {
                i37 = maxLines;
            }
            $dirty1 |= i7;
        } else {
            i37 = maxLines;
        }
        interactionSource2 = i95 & i117;
        if (interactionSource2 != 0) {
            $dirty1 |= textStyle2;
            i16 = minLines;
        } else {
            if (i86 & textStyle2 == 0) {
                i61 = restartGroup.changed(minLines) ? 536870912 : 268435456;
                $dirty1 |= i61;
            } else {
                i16 = minLines;
            }
        }
        i33 = i95 & i120;
        if (i33 != 0) {
            $dirty2 |= 6;
            obj3 = interactionSource;
        } else {
            if (trailingIcon2 & 6 == 0) {
                i26 = restartGroup.changed(interactionSource) ? 4 : 2;
                $dirty2 |= i26;
            } else {
                obj3 = interactionSource;
            }
        }
        if (trailingIcon2 & 48 == 0) {
            if (i95 & i108 == 0) {
                minLines2 = restartGroup.changed(shape) ? 32 : 16;
            } else {
                obj9 = shape;
            }
            $dirty2 |= minLines2;
        } else {
            obj9 = shape;
        }
        if (trailingIcon2 & 384 == 0) {
            if (i95 & i53 == 0) {
                i34 = restartGroup.changed(colors) ? 256 : i106;
            } else {
                obj2 = colors;
            }
            $dirty2 |= i34;
        } else {
            obj2 = colors;
        }
        if ($dirty & suffix2 == 306783378 && i82 &= $dirty1 == 306783378 && $dirty2 & 147 == 146) {
            if (i82 &= $dirty1 == 306783378) {
                if ($dirty2 & 147 == 146) {
                    if (!restartGroup.getSkipping()) {
                        restartGroup.startDefaults();
                        if ($changed & 1 != 0) {
                            if (restartGroup.getDefaultsInvalid()) {
                                if (i5 != 0) {
                                    str = defaultsInvalid;
                                }
                                if (supportingText2 != 0) {
                                    l = defaultsInvalid;
                                }
                                if (i109 != 0) {
                                    z3 = defaultsInvalid;
                                }
                                if (i95 & 32 != 0) {
                                    i5 = 6;
                                    suffix2 = 0;
                                    ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                                    $dirty &= traceInProgress;
                                    obj8 = this_$iv;
                                }
                                if (i121 != 0) {
                                    obj20 = this_$iv;
                                }
                                placeholder2 = i21 != 0 ? 0 : placeholder;
                                leadingIcon4 = i39 != 0 ? 0 : leadingIcon;
                                trailingIcon2 = i47 != 0 ? 0 : trailingIcon;
                                prefix2 = i54 != 0 ? 0 : prefix;
                                suffix2 = i48 != 0 ? 0 : suffix;
                                supportingText2 = i43 != 0 ? 0 : supportingText;
                                isError4 = i36 != 0 ? 0 : isError;
                                if (i64 != 0) {
                                    visualTransformation4 = VisualTransformation.Companion.getNone();
                                } else {
                                    visualTransformation4 = visualTransformation;
                                }
                                if (keyboardOptions3 != 0) {
                                    keyboardOptions3 = KeyboardOptions.Companion.getDefault();
                                } else {
                                    keyboardOptions3 = keyboardOptions;
                                }
                                if (i110 != 0) {
                                    keyboardActions3 = KeyboardActions.Companion.getDefault();
                                } else {
                                    keyboardActions3 = keyboardActions;
                                }
                                singleLine2 = i112 != 0 ? 0 : singleLine;
                                if (i95 & i113 != 0) {
                                    maxLines3 = singleLine2 != 0 ? 1 : 0x7fffffff /* Unknown resource */;
                                    $dirty1 &= minLines2;
                                } else {
                                    maxLines3 = maxLines;
                                }
                                minLines2 = interactionSource2 != 0 ? 1 : minLines;
                                interactionSource3 = i33 != 0 ? 0 : interactionSource;
                                obj70 = placeholder2;
                                int placeholder4 = 6;
                                if (i95 & i118 != 0) {
                                    obj71 = leadingIcon4;
                                    leadingIcon3 = TextFieldDefaults.INSTANCE.getShape(restartGroup, placeholder4);
                                    $dirty2 &= -113;
                                } else {
                                    obj71 = leadingIcon4;
                                    leadingIcon3 = shape;
                                }
                                if (i95 & i53 != 0) {
                                    obj19 = obj70;
                                    obj7 = obj71;
                                    i39 = obj72;
                                    $dirty2 = i88;
                                    obj13 = trailingIcon2;
                                    obj6 = prefix2;
                                    i33 = obj20;
                                    i53 = suffix2;
                                    i21 = supportingText2;
                                    prefix4 = isError4;
                                    rememberedValue = interactionSource3;
                                    label2 = colors4;
                                    colors2 = obj8;
                                    interactionSource2 = visualTransformation4;
                                    isError2 = keyboardOptions3;
                                    textStyle4 = str;
                                    visualTransformation3 = z3;
                                } else {
                                    obj19 = obj70;
                                    obj7 = obj71;
                                    i39 = obj72;
                                    obj13 = trailingIcon2;
                                    colors2 = obj8;
                                    obj6 = prefix2;
                                    i33 = obj20;
                                    i53 = suffix2;
                                    i21 = supportingText2;
                                    prefix4 = isError4;
                                    rememberedValue = interactionSource3;
                                    label2 = colors;
                                    textStyle4 = str;
                                    interactionSource2 = visualTransformation4;
                                    isError2 = keyboardOptions3;
                                    visualTransformation3 = z3;
                                }
                            } else {
                                restartGroup.skipToGroupEnd();
                                if (i95 & 32 != 0) {
                                    $dirty &= i38;
                                }
                                if (i77 &= i95 != 0) {
                                    $dirty1 &= i46;
                                }
                                if (i78 &= i95 != 0) {
                                    $dirty2 &= -113;
                                }
                                if (i95 & i53 != 0) {
                                    obj19 = placeholder;
                                    obj7 = leadingIcon;
                                    obj13 = trailingIcon;
                                    obj6 = prefix;
                                    i53 = suffix;
                                    i21 = supportingText;
                                    prefix4 = isError;
                                    interactionSource2 = visualTransformation;
                                    isError2 = keyboardOptions;
                                    keyboardActions3 = keyboardActions;
                                    singleLine2 = singleLine;
                                    maxLines3 = maxLines;
                                    minLines2 = minLines;
                                    rememberedValue = interactionSource;
                                    i39 = shape;
                                    $dirty2 = i81;
                                    visualTransformation3 = z3;
                                    colors2 = obj8;
                                    i33 = obj20;
                                    label2 = colors;
                                    textStyle4 = str;
                                } else {
                                    obj19 = placeholder;
                                    obj7 = leadingIcon;
                                    obj13 = trailingIcon;
                                    obj6 = prefix;
                                    i53 = suffix;
                                    i21 = supportingText;
                                    prefix4 = isError;
                                    interactionSource2 = visualTransformation;
                                    isError2 = keyboardOptions;
                                    keyboardActions3 = keyboardActions;
                                    singleLine2 = singleLine;
                                    maxLines3 = maxLines;
                                    minLines2 = minLines;
                                    rememberedValue = interactionSource;
                                    i39 = shape;
                                    visualTransformation3 = z3;
                                    colors2 = obj8;
                                    i33 = obj20;
                                    label2 = colors;
                                    textStyle4 = str;
                                }
                            }
                        } else {
                        }
                        restartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-676242365, $dirty, $dirty1, "androidx.compose.material3.TextField (TextField.kt:219)");
                        }
                        restartGroup.startReplaceGroup(-508515290);
                        ComposerKt.sourceInformation(restartGroup, "221@11518L39");
                        if (rememberedValue == 0) {
                            ComposerKt.sourceInformationMarkerStart(restartGroup, -508514639, "CC(remember):TextField.kt#9igjgp");
                            str = restartGroup;
                            z3 = 0;
                            obj70 = rememberedValue;
                            rememberedValue = str.rememberedValue();
                            suffix2 = 0;
                            obj71 = i93;
                            if (rememberedValue == Composer.Companion.getEmpty()) {
                                int i94 = 0;
                                str.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                            } else {
                                $i$a$CacheTextFieldKt$TextField$interactionSource$1 = rememberedValue;
                            }
                            ComposerKt.sourceInformationMarkerEnd(restartGroup);
                            i6 = $i$a$CacheTextFieldKt$TextField$interactionSource$1;
                        } else {
                            i6 = obj70;
                        }
                        restartGroup.endReplaceGroup();
                        restartGroup.startReplaceGroup(-508509180);
                        ComposerKt.sourceInformation(restartGroup, "*225@11742L25");
                        focused = colors2.getColor-0d7_KjU();
                        int i101 = 0;
                        i12 = 0;
                        i18 = Long.compare(l2, i126) != 0 ? 1 : 0;
                        if (i18 != 0) {
                        } else {
                            i12 = 0;
                            obj71 = focused;
                            focused = label2.textColor-XeAY9LY$material3_release(l, prefix4, (Boolean)FocusInteractionKt.collectIsFocusedAsState((InteractionSource)i6, restartGroup, 0).getValue().booleanValue());
                        }
                        restartGroup.endReplaceGroup();
                        textStyle2 = new TextStyle(focused, i54, 0, i43, 0, 0, 0, 0, 0, 0, obj46, 0, 0, 0, 0, obj51, 0, 0, 0, 0, 0, 0, obj58, 0, 0, 0, 0, 0, 0, 16777214, 0);
                        boolean z4 = l;
                        TextFieldKt.TextField.1 anon = new TextFieldKt.TextField.1(textStyle4, prefix4, label2, obj11, obj16, z4, visualTransformation3, colors2.merge(textStyle2), isError2, keyboardActions3, singleLine2, maxLines3, minLines2, interactionSource2, i6, i33, obj19, obj7, obj13, obj6, i53, i21, i39);
                        CompositionLocalKt.CompositionLocalProvider(TextSelectionColorsKt.getLocalTextSelectionColors().provides(label2.getTextSelectionColors()), (Function2)ComposableLambdaKt.rememberComposableLambda(1859145987, true, anon, restartGroup, 54), restartGroup, $stable |= 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        str = textStyle4;
                        keyboardOptions2 = isError2;
                        i8 = maxLines3;
                        keyboardOptions4 = minLines2;
                        visualTransformation2 = interactionSource2;
                        i25 = obj19;
                        i17 = obj13;
                        i58 = obj6;
                        modifier4 = i53;
                        placeholder3 = $dirty;
                        trailingIcon3 = $dirty1;
                        prefix3 = $dirty2;
                        maxLines2 = label2;
                        $dirty3 = visualTransformation3;
                        readOnly2 = singleLine2;
                        $dirty22 = i33;
                        singleLine3 = i39;
                        $dirty12 = colors2;
                        textStyle3 = restartGroup;
                        colors3 = prefix4;
                        $composer2 = z4;
                        enabled2 = keyboardActions3;
                        isError3 = i21;
                        keyboardActions2 = obj70;
                    } else {
                        restartGroup.skipToGroupEnd();
                        i25 = placeholder;
                        obj7 = leadingIcon;
                        isError3 = supportingText;
                        visualTransformation2 = visualTransformation;
                        keyboardOptions2 = keyboardOptions;
                        enabled2 = keyboardActions;
                        readOnly2 = singleLine;
                        i8 = maxLines;
                        keyboardOptions4 = minLines;
                        keyboardActions2 = interactionSource;
                        singleLine3 = shape;
                        maxLines2 = colors;
                        textStyle3 = restartGroup;
                        placeholder3 = $dirty;
                        trailingIcon3 = $dirty1;
                        prefix3 = $dirty2;
                        $composer2 = l;
                        $dirty3 = z3;
                        $dirty12 = obj8;
                        $dirty22 = obj20;
                        i17 = trailingIcon;
                        i58 = prefix;
                        modifier4 = suffix;
                        colors3 = isError;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        endRestartGroup = textStyle3.endRestartGroup();
        if (endRestartGroup != null) {
            leadingIcon2 = composer;
            textStyle3 = new TextFieldKt.TextField.2(value, onValueChange, str, $composer2, $dirty3, $dirty12, $dirty22, i25, obj7, i17, i58, modifier4, isError3, colors3, visualTransformation2, keyboardOptions2, enabled2, readOnly2, i8, keyboardOptions4, keyboardActions2, singleLine3, maxLines2, $changed, $changed1, $changed2, i95);
            endRestartGroup.updateScope((Function2)textStyle3);
        } else {
            modifier2 = str;
            modifier3 = obj7;
            leadingIcon2 = textStyle3;
        }
    }

    public static final void TextFieldLayout(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> textField, Function2<? super Composer, ? super Integer, Unit> label, Function3<? super Modifier, ? super Composer, ? super Integer, Unit> placeholder, Function2<? super Composer, ? super Integer, Unit> leading, Function2<? super Composer, ? super Integer, Unit> trailing, Function2<? super Composer, ? super Integer, Unit> prefix, Function2<? super Composer, ? super Integer, Unit> suffix, boolean singleLine, float animationProgress, Function2<? super Composer, ? super Integer, Unit> container, Function2<? super Composer, ? super Integer, Unit> supporting, PaddingValues paddingValues, Composer $composer, int $changed, int $changed1) {
        int i19;
        int i26;
        int i6;
        int i2;
        int i17;
        int i24;
        int i5;
        boolean traceInProgress2;
        Object endRestartGroup;
        int i31;
        Object it$iv;
        Object valueOf4;
        Object valueOf6;
        Object valueOf5;
        Modifier heightIn-VpY3zN4$default;
        Integer maybeCachedBoxMeasurePolicy;
        Object valueOf7;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv2;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv5;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv4;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv;
        Object obj5;
        kotlin.jvm.functions.Function0 factory$iv$iv;
        Composer $changed$iv;
        boolean traceInProgress;
        int i27;
        int i30;
        Integer currentCompositionLocalMap;
        int valueOf2;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv3;
        Object valueOf8;
        String $composer$iv;
        Object obj2;
        Composer composer4;
        Composer composer5;
        Object currentCompositionLocalMap8;
        Integer currentCompositionLocalMap7;
        Integer currentCompositionLocalMap4;
        Integer maybeCachedBoxMeasurePolicy2;
        Integer maybeCachedBoxMeasurePolicy6;
        Object obj4;
        int $composer$iv2;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap3;
        Composer materialized$iv$iv;
        int i3;
        Object then;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv6;
        Composer composer3;
        Object currentCompositionLocalMap5;
        int materializeModifier;
        int constructor-impl;
        int iNSTANCE;
        Object obj3;
        Composer composer8;
        int valueOf3;
        Composer composer2;
        androidx.compose.ui.layout.MeasurePolicy maybeCachedBoxMeasurePolicy3;
        Object materialized$iv$iv2;
        float $this$coerceAtLeast_u2dYgX7TsA$iv;
        BoxScopeInstance maybeCachedBoxMeasurePolicy4;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv7;
        float $this$dp$iv;
        int maybeCachedBoxMeasurePolicy7;
        int iNSTANCE2;
        int valueOf;
        Composer composer6;
        Composer composer7;
        Object currentCompositionLocalMap6;
        int topStart;
        int $i$f$cache2;
        Integer currentCompositionLocalMap2;
        int maybeCachedBoxMeasurePolicy5;
        Object restartGroup;
        Composer composer;
        int valueOf9;
        Object obj;
        int $dirty12;
        Modifier modifier3;
        int $dirty1;
        int i10;
        int $dirty;
        int $dirty2;
        int i15;
        int i8;
        int i16;
        int i7;
        androidx.compose.material3.TextFieldMeasurePolicy field;
        int companion;
        int currentCompositeKeyHash2;
        int $i$f$cache;
        int i21;
        int i;
        kotlin.jvm.functions.Function0 function0;
        int i23;
        int i25;
        Composer composer9;
        int i32;
        Composer composer10;
        Modifier modifier4;
        int i22;
        androidx.compose.runtime.CompositionLocalMap localMap$iv;
        Modifier modifier2;
        int i29;
        Object layoutDirection;
        int i33;
        int i13;
        int $i$a$LayoutTextFieldKt$TextFieldLayout$1;
        kotlin.jvm.functions.Function0 currentCompositeKeyHash4;
        float f2;
        Modifier currentCompositeKeyHash5;
        float endPadding;
        float currentCompositeKeyHash;
        Composer currentCompositeKeyHash3;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv2;
        float f3;
        int i14;
        int i12;
        kotlin.jvm.functions.Function0 f;
        float constructor-impl2;
        int i11;
        int i28;
        int i9;
        int localMap$iv$iv;
        float f4;
        float measurePolicy$iv2;
        Composer composer11;
        int i20;
        int i18;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy$iv;
        androidx.compose.runtime.CompositionLocalMap map;
        Composer composer12;
        int i4;
        ScopeUpdateScope scopeUpdateScope;
        Alignment obj74;
        Object obj6 = modifier;
        $composer$iv2 = leading;
        materializeModifier = trailing;
        iNSTANCE = prefix;
        final Object obj8 = suffix;
        maybeCachedBoxMeasurePolicy3 = singleLine;
        $this$dp$iv = animationProgress;
        iNSTANCE2 = container;
        int i177 = $changed;
        int i179 = $changed1;
        restartGroup = $composer.startRestartGroup(-1830307184);
        ComposerKt.sourceInformation(restartGroup, "C(TextFieldLayout)P(4,11,2,6,3,12,7,9,8!2,10)455@23228L147,458@23423L7,459@23435L4118:TextField.kt#uh7d8r");
        obj74 = i35;
        if (i177 & 6 == 0) {
            i8 = restartGroup.changed(obj6) ? 4 : 2;
            $dirty = obj74 | i8;
        } else {
            $dirty = obj74;
        }
        if (i177 & 48 == 0) {
            i16 = restartGroup.changedInstance(textField) ? 32 : 16;
            $dirty |= i16;
        }
        if (i177 & 384 == 0) {
            i7 = restartGroup.changedInstance(label) ? 256 : 128;
            $dirty |= i7;
        }
        if (i177 & 3072 == 0) {
            i19 = restartGroup.changedInstance(placeholder) ? 2048 : 1024;
            $dirty |= i19;
        }
        if (i177 & 24576 == 0) {
            i26 = restartGroup.changedInstance($composer$iv2) ? 16384 : 8192;
            $dirty |= i26;
        }
        if (i37 &= i177 == 0) {
            i6 = restartGroup.changedInstance(materializeModifier) ? 131072 : 65536;
            $dirty |= i6;
        }
        if (i38 &= i177 == 0) {
            i2 = restartGroup.changedInstance(iNSTANCE) ? 1048576 : 524288;
            $dirty |= i2;
        }
        if (i39 &= i177 == 0) {
            i17 = restartGroup.changedInstance(obj8) ? 8388608 : 4194304;
            $dirty |= i17;
        }
        if (i40 &= i177 == 0) {
            i24 = restartGroup.changed(maybeCachedBoxMeasurePolicy3) ? 67108864 : 33554432;
            $dirty |= i24;
        }
        if (i41 &= i177 == 0) {
            i5 = restartGroup.changed($this$dp$iv) ? 536870912 : 268435456;
            $dirty |= i5;
        }
        traceInProgress2 = $dirty;
        if (i179 & 6 == 0) {
            $dirty2 = restartGroup.changedInstance(iNSTANCE2) ? 4 : 2;
            $dirty1 |= $dirty2;
        }
        if (i179 & 48 == 0) {
            i15 = restartGroup.changedInstance(supporting) ? 32 : 16;
            $dirty1 |= i15;
        }
        if (i179 & 384 == 0) {
            i15 = restartGroup.changed(paddingValues) ? 256 : 128;
            $dirty1 |= i15;
        } else {
            obj = paddingValues;
        }
        $dirty12 = $dirty1;
        if (traceInProgress2 & $dirty13 == 306783378 && $dirty12 & 147 == 146) {
            if ($dirty12 & 147 == 146) {
                if (!restartGroup.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1830307184, traceInProgress2, $dirty12, "androidx.compose.material3.TextFieldLayout (TextField.kt:453)");
                    }
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1052646361, "CC(remember):TextField.kt#9igjgp");
                    int i183 = 1;
                    i10 = traceInProgress2;
                    i27 = i86 &= traceInProgress2 == 67108864 ? i183 : 0;
                    i31 = i10 & i161 == 536870912 ? i183 : 0;
                    i30 = $dirty12 & 896 == 256 ? i183 : 0;
                    Composer composer13 = restartGroup;
                    $i$f$cache2 = 0;
                    it$iv = composer13.rememberedValue();
                    int i188 = 0;
                    if (i43 |= i30 == 0) {
                        $i$f$cache = $i$f$cache2;
                        if (it$iv == Composer.Companion.getEmpty()) {
                            $i$f$cache2 = 0;
                            companion = it$iv;
                            it$iv = new TextFieldMeasurePolicy(maybeCachedBoxMeasurePolicy3, $this$dp$iv, obj);
                            composer13.updateRememberedValue(it$iv);
                        } else {
                            companion = it$iv;
                        }
                    } else {
                        $i$f$cache = $i$f$cache2;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    int i164 = 0;
                    int i187 = 0;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    valueOf4 = restartGroup.consume((CompositionLocal)CompositionLocalsKt.getLocalLayoutDirection());
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    $changed$iv = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, $changed$iv);
                    currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, 0);
                    currentCompositionLocalMap2 = restartGroup.getCurrentCompositionLocalMap();
                    i21 = i136;
                    materialized$iv$iv2 = ComposedModifierKt.materializeModifier(restartGroup, obj6);
                    kotlin.jvm.functions.Function0 function02 = constructor2;
                    i = 0;
                    i25 = $dirty12;
                    $dirty12 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp";
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, $dirty12);
                    if (!applier5 instanceof Applier) {
                        ComposablesKt.invalidApplier();
                    }
                    restartGroup.startReusableNode();
                    if (restartGroup.getInserting()) {
                        restartGroup.createNode(function02);
                    } else {
                        factory$iv$iv = function02;
                        restartGroup.useNode();
                    }
                    function0 = factory$iv$iv;
                    Composer constructor-impl6 = Updater.constructor-impl(restartGroup);
                    int i190 = 0;
                    composer10 = restartGroup;
                    Updater.set-impl(constructor-impl6, (MeasurePolicy)(TextFieldMeasurePolicy)it$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl6, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    valueOf9 = 0;
                    Composer composer20 = constructor-impl6;
                    i22 = 0;
                    if (!composer20.getInserting()) {
                        localMap$iv = currentCompositionLocalMap2;
                        i29 = valueOf9;
                        if (!Intrinsics.areEqual(composer20.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                            composer20.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                            constructor-impl6.apply(Integer.valueOf(currentCompositeKeyHash2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer = composer20;
                        }
                    } else {
                        localMap$iv = currentCompositionLocalMap2;
                        i29 = valueOf9;
                    }
                    Updater.set-impl(constructor-impl6, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                    obj4 = composer10;
                    maybeCachedBoxMeasurePolicy5 = 0;
                    i32 = i81;
                    ComposerKt.sourceInformationMarkerStart(obj4, -1362557328, "C465@23754L11,550@26868L187:TextField.kt#uh7d8r");
                    iNSTANCE2.invoke(obj4, Integer.valueOf(i25 & 14));
                    obj4.startReplaceGroup(1341517187);
                    ComposerKt.sourceInformation(obj4, "468@23818L219");
                    restartGroup = "C73@3429L9:Box.kt#2w3rfo";
                    modifier4 = 48;
                    String str3 = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo";
                    modifier2 = materialized$iv$iv2;
                    if ($composer$iv2 != null) {
                        Modifier then4 = LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Leading").then(TextFieldImplKt.getIconDefaultSizeModifier());
                        Alignment center2 = Alignment.Companion.getCenter();
                        layoutDirection = modifier4;
                        i13 = 0;
                        $i$a$LayoutTextFieldKt$TextFieldLayout$1 = maybeCachedBoxMeasurePolicy5;
                        ComposerKt.sourceInformationMarkerStart(obj4, 733328855, str3);
                        int i175 = 0;
                        maybeCachedBoxMeasurePolicy6 = BoxKt.maybeCachedBoxMeasurePolicy(center2, i175);
                        f2 = 0;
                        currentCompositeKeyHash5 = center2;
                        ComposerKt.sourceInformationMarkerStart(obj4, -1323940314, $changed$iv);
                        endPadding = ComposablesKt.getCurrentCompositeKeyHash(obj4, 0);
                        currentCompositionLocalMap6 = obj4.getCurrentCompositionLocalMap();
                        currentCompositeKeyHash3 = i175;
                        i14 = then4;
                        kotlin.jvm.functions.Function0 function08 = constructor7;
                        localMap$iv$iv2 = 0;
                        ComposerKt.sourceInformationMarkerStart(obj4, -692256719, $dirty12);
                        if (!applier8 instanceof Applier) {
                            ComposablesKt.invalidApplier();
                        }
                        obj4.startReusableNode();
                        if (obj4.getInserting()) {
                            obj4.createNode(function08);
                        } else {
                            factory$iv$iv$iv7 = function08;
                            obj4.useNode();
                        }
                        i12 = factory$iv$iv$iv7;
                        Composer constructor-impl9 = Updater.constructor-impl(obj4);
                        int i225 = 0;
                        Updater.set-impl(constructor-impl9, maybeCachedBoxMeasurePolicy6, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(constructor-impl9, currentCompositionLocalMap6, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        int i237 = 0;
                        Composer composer23 = constructor-impl9;
                        int i238 = 0;
                        if (!composer23.getInserting()) {
                            measurePolicy$iv2 = maybeCachedBoxMeasurePolicy6;
                            composer11 = currentCompositionLocalMap6;
                            if (!Intrinsics.areEqual(composer23.rememberedValue(), Integer.valueOf(endPadding))) {
                                composer23.updateRememberedValue(Integer.valueOf(endPadding));
                                constructor-impl9.apply(Integer.valueOf(endPadding), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            } else {
                                composer7 = composer23;
                            }
                        } else {
                            measurePolicy$iv2 = maybeCachedBoxMeasurePolicy6;
                            composer11 = currentCompositionLocalMap6;
                        }
                        Updater.set-impl(constructor-impl9, ComposedModifierKt.materializeModifier(obj4, then4), ComposeUiNode.Companion.getSetModifier());
                        Composer composer19 = obj4;
                        ComposerKt.sourceInformationMarkerStart(composer19, -2146769399, restartGroup);
                        iNSTANCE2 = BoxScopeInstance.INSTANCE;
                        i227 |= 6;
                        localMap$iv$iv = 0;
                        f4 = i107;
                        i18 = i149;
                        $this$dp$iv = i9;
                        ComposerKt.sourceInformationMarkerStart($this$dp$iv, -948431736, "C472@24010L9:TextField.kt#uh7d8r");
                        $composer$iv2.invoke($this$dp$iv, Integer.valueOf(i108 &= 14));
                        ComposerKt.sourceInformationMarkerEnd($this$dp$iv);
                        ComposerKt.sourceInformationMarkerEnd(composer19);
                        obj4.endNode();
                        ComposerKt.sourceInformationMarkerEnd(obj4);
                        ComposerKt.sourceInformationMarkerEnd(obj4);
                        ComposerKt.sourceInformationMarkerEnd(obj4);
                    } else {
                        $i$a$LayoutTextFieldKt$TextFieldLayout$1 = maybeCachedBoxMeasurePolicy5;
                    }
                    obj4.endReplaceGroup();
                    obj4.startReplaceGroup(1341526310);
                    ComposerKt.sourceInformation(obj4, "476@24104L221");
                    Modifier then2 = LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Trailing").then(TextFieldImplKt.getIconDefaultSizeModifier());
                    Alignment center = Alignment.Companion.getCenter();
                    ComposerKt.sourceInformationMarkerStart(obj4, 733328855, str3);
                    valueOf = 0;
                    i13 = 0;
                    ComposerKt.sourceInformationMarkerStart(obj4, -1323940314, $changed$iv);
                    currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(obj4, 0);
                    currentCompositionLocalMap3 = obj4.getCurrentCompositionLocalMap();
                    f2 = center;
                    Modifier materializeModifier5 = ComposedModifierKt.materializeModifier(obj4, then2);
                    endPadding = then2;
                    kotlin.jvm.functions.Function0 function04 = constructor3;
                    currentCompositeKeyHash5 = 0;
                    ComposerKt.sourceInformationMarkerStart(obj4, -692256719, $dirty12);
                    if (materializeModifier != null && !applier6 instanceof Applier) {
                        then2 = LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Trailing").then(TextFieldImplKt.getIconDefaultSizeModifier());
                        center = Alignment.Companion.getCenter();
                        ComposerKt.sourceInformationMarkerStart(obj4, 733328855, str3);
                        valueOf = 0;
                        i13 = 0;
                        ComposerKt.sourceInformationMarkerStart(obj4, -1323940314, $changed$iv);
                        currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(obj4, 0);
                        currentCompositionLocalMap3 = obj4.getCurrentCompositionLocalMap();
                        f2 = center;
                        materializeModifier5 = ComposedModifierKt.materializeModifier(obj4, then2);
                        endPadding = then2;
                        function04 = constructor3;
                        currentCompositeKeyHash5 = 0;
                        ComposerKt.sourceInformationMarkerStart(obj4, -692256719, $dirty12);
                        if (!applier6 instanceof Applier) {
                            ComposablesKt.invalidApplier();
                        }
                        obj4.startReusableNode();
                        if (obj4.getInserting()) {
                            obj4.createNode(function04);
                        } else {
                            factory$iv$iv$iv3 = function04;
                            obj4.useNode();
                        }
                        currentCompositeKeyHash3 = factory$iv$iv$iv3;
                        Composer constructor-impl7 = Updater.constructor-impl(obj4);
                        int i204 = 0;
                        i11 = i146;
                        Updater.set-impl(constructor-impl7, BoxKt.maybeCachedBoxMeasurePolicy(center, valueOf), ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(constructor-impl7, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        int i211 = 0;
                        Composer composer22 = constructor-impl7;
                        int i228 = 0;
                        if (!composer22.getInserting()) {
                            localMap$iv$iv = currentCompositionLocalMap3;
                            f4 = valueOf;
                            if (!Intrinsics.areEqual(composer22.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                                composer22.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                                constructor-impl7.apply(Integer.valueOf(currentCompositeKeyHash4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            } else {
                                composer6 = composer22;
                            }
                        } else {
                            localMap$iv$iv = currentCompositionLocalMap3;
                            f4 = valueOf;
                        }
                        Updater.set-impl(constructor-impl7, materializeModifier5, ComposeUiNode.Companion.getSetModifier());
                        Composer composer18 = obj4;
                        $this$dp$iv = 0;
                        ComposerKt.sourceInformationMarkerStart(composer18, -2146769399, restartGroup);
                        iNSTANCE2 = BoxScopeInstance.INSTANCE;
                        i206 |= 6;
                        i28 = 0;
                        i9 = i95;
                        composer11 = materializeModifier5;
                        materialized$iv$iv2 = i12;
                        ComposerKt.sourceInformationMarkerStart(materialized$iv$iv2, -948147001, "C480@24297L10:TextField.kt#uh7d8r");
                        materializeModifier.invoke(materialized$iv$iv2, Integer.valueOf(i96 &= 14));
                        ComposerKt.sourceInformationMarkerEnd(materialized$iv$iv2);
                        ComposerKt.sourceInformationMarkerEnd(composer18);
                        obj4.endNode();
                        ComposerKt.sourceInformationMarkerEnd(obj4);
                        ComposerKt.sourceInformationMarkerEnd(obj4);
                        ComposerKt.sourceInformationMarkerEnd(obj4);
                    }
                    obj4.endReplaceGroup();
                    $composer$iv = PaddingKt.calculateStartPadding(obj, (LayoutDirection)valueOf4);
                    materialized$iv$iv = PaddingKt.calculateEndPadding(obj, valueOf4);
                    if (leading != null) {
                        int i148 = 0;
                        int i157 = 0;
                        iNSTANCE2 = 0;
                        $this$coerceAtLeast_u2dYgX7TsA$iv = Dp.constructor-impl(RangesKt.coerceAtLeast(Dp.constructor-impl($composer$iv - horizontalIconPadding2), Dp.constructor-impl((float)$i$f$minus5rwHm242)));
                    } else {
                        $this$coerceAtLeast_u2dYgX7TsA$iv = $composer$iv;
                    }
                    f2 = $this$coerceAtLeast_u2dYgX7TsA$iv;
                    if (materializeModifier != null) {
                        int i147 = 0;
                        int i155 = 0;
                        iNSTANCE2 = 0;
                        currentCompositeKeyHash = $this$coerceAtLeast_u2dYgX7TsA$iv;
                    } else {
                        currentCompositeKeyHash = materialized$iv$iv;
                    }
                    f = currentCompositeKeyHash;
                    obj4.startReplaceGroup(1341556924);
                    ComposerKt.sourceInformation(obj4, "501@25056L309");
                    maybeCachedBoxMeasurePolicy7 = 0;
                    if (iNSTANCE != null) {
                        layoutDirection = valueOf4;
                        int i174 = 0;
                        Modifier padding-qDBjuR0$default4 = PaddingKt.padding-qDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.heightIn-VpY3zN4$default(LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Prefix"), TextFieldImplKt.getMinTextLineHeight(), 0, 2, maybeCachedBoxMeasurePolicy7), maybeCachedBoxMeasurePolicy7, i174, 3, maybeCachedBoxMeasurePolicy7), f2, 0, TextFieldImplKt.getPrefixSuffixTextPadding(), 0, 10, 0);
                        iNSTANCE2 = i174;
                        maybeCachedBoxMeasurePolicy5 = 0;
                        ComposerKt.sourceInformationMarkerStart(obj4, 733328855, str3);
                        Alignment topStart5 = Alignment.Companion.getTopStart();
                        f4 = $composer$iv;
                        maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(topStart5, false);
                        currentCompositeKeyHash5 = 0;
                        measurePolicy$iv2 = materialized$iv$iv;
                        ComposerKt.sourceInformationMarkerStart(obj4, -1323940314, $changed$iv);
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(obj4, 0);
                        currentCompositionLocalMap5 = obj4.getCurrentCompositionLocalMap();
                        localMap$iv$iv2 = padding-qDBjuR0$default4;
                        kotlin.jvm.functions.Function0 function05 = constructor4;
                        currentCompositeKeyHash3 = 0;
                        ComposerKt.sourceInformationMarkerStart(obj4, -692256719, $dirty12);
                        if (!applier4 instanceof Applier) {
                            ComposablesKt.invalidApplier();
                        }
                        obj4.startReusableNode();
                        if (obj4.getInserting()) {
                            obj4.createNode(function05);
                        } else {
                            factory$iv$iv$iv = function05;
                            obj4.useNode();
                        }
                        i14 = factory$iv$iv$iv;
                        Composer constructor-impl5 = Updater.constructor-impl(obj4);
                        int i222 = 0;
                        composer11 = topStart5;
                        Updater.set-impl(constructor-impl5, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(constructor-impl5, currentCompositionLocalMap5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        int i236 = 0;
                        Composer composer27 = constructor-impl5;
                        int i243 = 0;
                        if (!composer27.getInserting()) {
                            measurePolicy$iv = maybeCachedBoxMeasurePolicy2;
                            map = currentCompositionLocalMap5;
                            if (!Intrinsics.areEqual(composer27.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                composer27.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                constructor-impl5.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            } else {
                                composer3 = composer27;
                            }
                        } else {
                            measurePolicy$iv = maybeCachedBoxMeasurePolicy2;
                            map = currentCompositionLocalMap5;
                        }
                        Updater.set-impl(constructor-impl5, ComposedModifierKt.materializeModifier(obj4, padding-qDBjuR0$default4), ComposeUiNode.Companion.getSetModifier());
                        Composer composer17 = obj4;
                        ComposerKt.sourceInformationMarkerStart(composer17, -2146769399, restartGroup);
                        maybeCachedBoxMeasurePolicy4 = BoxScopeInstance.INSTANCE;
                        i224 |= 6;
                        i20 = 0;
                        i18 = i74;
                        i4 = i124;
                        materialized$iv$iv = i9;
                        ComposerKt.sourceInformationMarkerStart(materialized$iv$iv, -947113399, "C507@25339L8:TextField.kt#uh7d8r");
                        iNSTANCE.invoke(materialized$iv$iv, Integer.valueOf(i75 &= 14));
                        ComposerKt.sourceInformationMarkerEnd(materialized$iv$iv);
                        ComposerKt.sourceInformationMarkerEnd(composer17);
                        obj4.endNode();
                        ComposerKt.sourceInformationMarkerEnd(obj4);
                        ComposerKt.sourceInformationMarkerEnd(obj4);
                        ComposerKt.sourceInformationMarkerEnd(obj4);
                    } else {
                        layoutDirection = valueOf4;
                        f4 = $composer$iv;
                        measurePolicy$iv2 = materialized$iv$iv;
                    }
                    obj4.endReplaceGroup();
                    obj4.startReplaceGroup(1341568890);
                    ComposerKt.sourceInformation(obj4, "511@25430L307");
                    if (obj8 != null) {
                        int i141 = 0;
                        int i121 = 0;
                        Modifier padding-qDBjuR0$default3 = PaddingKt.padding-qDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.heightIn-VpY3zN4$default(LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Suffix"), TextFieldImplKt.getMinTextLineHeight(), 0, 2, i141), i141, i121, 3, i141), TextFieldImplKt.getPrefixSuffixTextPadding(), 0, f, 0, 10, 0);
                        endPadding = f;
                        int i104 = i121;
                        ComposerKt.sourceInformationMarkerStart(obj4, 733328855, str3);
                        Alignment topStart4 = Alignment.Companion.getTopStart();
                        maybeCachedBoxMeasurePolicy5 = 0;
                        ComposerKt.sourceInformationMarkerStart(obj4, -1323940314, $changed$iv);
                        currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(obj4, 0);
                        currentCompositionLocalMap4 = obj4.getCurrentCompositionLocalMap();
                        currentCompositeKeyHash3 = i122;
                        Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(obj4, padding-qDBjuR0$default3);
                        i14 = padding-qDBjuR0$default3;
                        kotlin.jvm.functions.Function0 function07 = constructor6;
                        localMap$iv$iv2 = 0;
                        ComposerKt.sourceInformationMarkerStart(obj4, -692256719, $dirty12);
                        if (!applier3 instanceof Applier) {
                            ComposablesKt.invalidApplier();
                        }
                        obj4.startReusableNode();
                        if (obj4.getInserting()) {
                            obj4.createNode(function07);
                        } else {
                            factory$iv$iv$iv4 = function07;
                            obj4.useNode();
                        }
                        f = factory$iv$iv$iv4;
                        Composer constructor-impl4 = Updater.constructor-impl(obj4);
                        int i219 = 0;
                        composer11 = topStart4;
                        Updater.set-impl(constructor-impl4, BoxKt.maybeCachedBoxMeasurePolicy(topStart4, false), ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(constructor-impl4, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        int i235 = 0;
                        Composer composer26 = constructor-impl4;
                        int i242 = 0;
                        if (!composer26.getInserting()) {
                            measurePolicy$iv = currentCompositionLocalMap4;
                            if (!Intrinsics.areEqual(composer26.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                                composer26.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
                                constructor-impl4.apply(Integer.valueOf(currentCompositeKeyHash5), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            } else {
                                composer2 = composer26;
                            }
                        } else {
                            measurePolicy$iv = currentCompositionLocalMap4;
                        }
                        Updater.set-impl(constructor-impl4, materializeModifier4, ComposeUiNode.Companion.getSetModifier());
                        Composer composer16 = obj4;
                        materializeModifier = 0;
                        ComposerKt.sourceInformationMarkerStart(composer16, -2146769399, restartGroup);
                        iNSTANCE = BoxScopeInstance.INSTANCE;
                        i221 |= 6;
                        i20 = 0;
                        i18 = i67;
                        composer12 = materializeModifier4;
                        materialized$iv$iv = i9;
                        ComposerKt.sourceInformationMarkerStart(materialized$iv$iv, -946744375, "C517@25711L8:TextField.kt#uh7d8r");
                        obj8.invoke(materialized$iv$iv, Integer.valueOf(i68 &= 14));
                        ComposerKt.sourceInformationMarkerEnd(materialized$iv$iv);
                        ComposerKt.sourceInformationMarkerEnd(composer16);
                        obj4.endNode();
                        ComposerKt.sourceInformationMarkerEnd(obj4);
                        ComposerKt.sourceInformationMarkerEnd(obj4);
                        ComposerKt.sourceInformationMarkerEnd(obj4);
                    } else {
                        endPadding = f;
                    }
                    obj4.endReplaceGroup();
                    obj4.startReplaceGroup(1341581092);
                    ComposerKt.sourceInformation(obj4, "522@25802L574");
                    if (label != null) {
                        int i140 = 0;
                        int i118 = 0;
                        Modifier padding-qDBjuR0$default2 = PaddingKt.padding-qDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.heightIn-VpY3zN4$default(LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Label"), DpKt.lerp-Md-fbLM(TextFieldImplKt.getMinTextLineHeight(), TextFieldImplKt.getMinFocusedLabelLineHeight(), animationProgress), 0, 2, i140), i140, i118, 3, i140), f2, 0, endPadding, 0, 10, 0);
                        int i101 = i118;
                        ComposerKt.sourceInformationMarkerStart(obj4, 733328855, str3);
                        Alignment topStart3 = Alignment.Companion.getTopStart();
                        valueOf3 = 0;
                        maybeCachedBoxMeasurePolicy5 = 0;
                        ComposerKt.sourceInformationMarkerStart(obj4, -1323940314, $changed$iv);
                        currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(obj4, 0);
                        currentCompositionLocalMap7 = obj4.getCurrentCompositionLocalMap();
                        currentCompositeKeyHash3 = i119;
                        Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(obj4, padding-qDBjuR0$default2);
                        i14 = padding-qDBjuR0$default2;
                        kotlin.jvm.functions.Function0 function06 = constructor5;
                        localMap$iv$iv2 = 0;
                        ComposerKt.sourceInformationMarkerStart(obj4, -692256719, $dirty12);
                        if (!applier2 instanceof Applier) {
                            ComposablesKt.invalidApplier();
                        }
                        obj4.startReusableNode();
                        if (obj4.getInserting()) {
                            obj4.createNode(function06);
                        } else {
                            factory$iv$iv$iv5 = function06;
                            obj4.useNode();
                        }
                        f = factory$iv$iv$iv5;
                        Composer constructor-impl3 = Updater.constructor-impl(obj4);
                        int i215 = 0;
                        composer11 = topStart3;
                        Updater.set-impl(constructor-impl3, BoxKt.maybeCachedBoxMeasurePolicy(topStart3, valueOf3), ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(constructor-impl3, currentCompositionLocalMap7, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        int i233 = 0;
                        Composer composer25 = constructor-impl3;
                        int i241 = 0;
                        if (!composer25.getInserting()) {
                            measurePolicy$iv = currentCompositionLocalMap7;
                            map = valueOf3;
                            if (!Intrinsics.areEqual(composer25.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                                composer25.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
                                constructor-impl3.apply(Integer.valueOf(currentCompositeKeyHash5), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            } else {
                                composer8 = composer25;
                            }
                        } else {
                            measurePolicy$iv = currentCompositionLocalMap7;
                            map = valueOf3;
                        }
                        Updater.set-impl(constructor-impl3, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                        Composer composer15 = obj4;
                        materializeModifier = 0;
                        ComposerKt.sourceInformationMarkerStart(composer15, -2146769399, restartGroup);
                        iNSTANCE = BoxScopeInstance.INSTANCE;
                        i217 |= 6;
                        i20 = 0;
                        i18 = i61;
                        i4 = materializeModifier3;
                        materialized$iv$iv = i9;
                        ComposerKt.sourceInformationMarkerStart(materialized$iv$iv, -946109526, "C535@26351L7:TextField.kt#uh7d8r");
                        label.invoke(materialized$iv$iv, Integer.valueOf(i62 &= 14));
                        ComposerKt.sourceInformationMarkerEnd(materialized$iv$iv);
                        ComposerKt.sourceInformationMarkerEnd(composer15);
                        obj4.endNode();
                        ComposerKt.sourceInformationMarkerEnd(obj4);
                        ComposerKt.sourceInformationMarkerEnd(obj4);
                        ComposerKt.sourceInformationMarkerEnd(obj4);
                    } else {
                        obj2 = label;
                        $this$dp$iv = animationProgress;
                    }
                    obj4.endReplaceGroup();
                    int i138 = 0;
                    if (prefix == null) {
                        f3 = f2;
                    } else {
                        i3 = 0;
                        f3 = constructor-impl;
                    }
                    if (obj8 == null) {
                        constructor-impl2 = endPadding;
                    } else {
                        i3 = 0;
                        constructor-impl2 = Dp.constructor-impl((float)heightIn-VpY3zN4$default);
                    }
                    Modifier padding-qDBjuR0$default = PaddingKt.padding-qDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.heightIn-VpY3zN4$default((Modifier)Modifier.Companion, TextFieldImplKt.getMinTextLineHeight(), 0, 2, i138), i138, false, 3, i138), f3, 0, constructor-impl2, 0, 10, 0);
                    obj4.startReplaceGroup(1341611627);
                    ComposerKt.sourceInformation(obj4, "548@26778L63");
                    if (placeholder != null) {
                        placeholder.invoke(LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Hint").then(padding-qDBjuR0$default), obj4, Integer.valueOf(i127 &= 112));
                    } else {
                        obj3 = placeholder;
                    }
                    obj4.endReplaceGroup();
                    Modifier then3 = LayoutIdKt.layoutId((Modifier)Modifier.Companion, "TextField").then(padding-qDBjuR0$default);
                    int i125 = i183;
                    maybeCachedBoxMeasurePolicy3 = 384;
                    iNSTANCE2 = 0;
                    ComposerKt.sourceInformationMarkerStart(obj4, 733328855, str3);
                    modifier3 = padding-qDBjuR0$default;
                    maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), i125);
                    currentCompositeKeyHash5 = 0;
                    ComposerKt.sourceInformationMarkerStart(obj4, -1323940314, $changed$iv);
                    currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(obj4, 0);
                    currentCompositionLocalMap8 = obj4.getCurrentCompositionLocalMap();
                    localMap$iv$iv2 = i125;
                    i12 = then3;
                    kotlin.jvm.functions.Function0 function09 = constructor8;
                    i14 = 0;
                    ComposerKt.sourceInformationMarkerStart(obj4, -692256719, $dirty12);
                    if (!applier7 instanceof Applier) {
                        ComposablesKt.invalidApplier();
                    }
                    obj4.startReusableNode();
                    if (obj4.getInserting()) {
                        obj4.createNode(function09);
                    } else {
                        factory$iv$iv$iv6 = function09;
                        obj4.useNode();
                    }
                    i11 = factory$iv$iv$iv6;
                    Composer constructor-impl8 = Updater.constructor-impl(obj4);
                    int i230 = 0;
                    Updater.set-impl(constructor-impl8, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl8, currentCompositionLocalMap8, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    int i239 = 0;
                    Composer composer24 = constructor-impl8;
                    int i240 = 0;
                    if (!composer24.getInserting()) {
                        measurePolicy$iv = maybeCachedBoxMeasurePolicy;
                        map = currentCompositionLocalMap8;
                        if (!Intrinsics.areEqual(composer24.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                            composer24.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                            constructor-impl8.apply(Integer.valueOf(currentCompositeKeyHash3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer4 = composer24;
                        }
                    } else {
                        measurePolicy$iv = maybeCachedBoxMeasurePolicy;
                        map = currentCompositionLocalMap8;
                    }
                    Updater.set-impl(constructor-impl8, ComposedModifierKt.materializeModifier(obj4, then3), ComposeUiNode.Companion.getSetModifier());
                    Composer composer14 = obj4;
                    ComposerKt.sourceInformationMarkerStart(composer14, -2146769399, restartGroup);
                    iNSTANCE = BoxScopeInstance.INSTANCE;
                    i232 |= 6;
                    i20 = 0;
                    i18 = i48;
                    i4 = i115;
                    $composer$iv2 = composer11;
                    ComposerKt.sourceInformationMarkerStart($composer$iv2, -945435834, "C554@27030L11:TextField.kt#uh7d8r");
                    textField.invoke($composer$iv2, Integer.valueOf(i49 &= 14));
                    ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                    ComposerKt.sourceInformationMarkerEnd(composer14);
                    obj4.endNode();
                    ComposerKt.sourceInformationMarkerEnd(obj4);
                    ComposerKt.sourceInformationMarkerEnd(obj4);
                    ComposerKt.sourceInformationMarkerEnd(obj4);
                    obj4.startReplaceGroup(1341622624);
                    ComposerKt.sourceInformation(obj4, "559@27167L317");
                    if (supporting != null) {
                        int i139 = 0;
                        Modifier padding = PaddingKt.padding(SizeKt.wrapContentHeight$default(SizeKt.heightIn-VpY3zN4$default(LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Supporting"), TextFieldImplKt.getMinSupportingTextLineHeight(), 0, 2, i139), i139, false, 3, i139), TextFieldDefaults.supportingTextPadding-a9UjIt4$material3_release$default(TextFieldDefaults.INSTANCE, 0, 0, 0, 0, 15, 0));
                        $composer$iv2 = i185;
                        materializeModifier = 0;
                        ComposerKt.sourceInformationMarkerStart(obj4, 733328855, str3);
                        Alignment topStart2 = Alignment.Companion.getTopStart();
                        topStart = 0;
                        obj74 = topStart2;
                        ComposerKt.sourceInformationMarkerStart(obj4, -1323940314, $changed$iv);
                        currentCompositionLocalMap = obj4.getCurrentCompositionLocalMap();
                        i15 = currentCompositeKeyHash6;
                        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(obj4, padding);
                        modifier4 = padding;
                        kotlin.jvm.functions.Function0 function03 = constructor;
                        companion = 0;
                        ComposerKt.sourceInformationMarkerStart(obj4, -692256719, $dirty12);
                        if (!applier instanceof Applier) {
                            ComposablesKt.invalidApplier();
                        }
                        obj4.startReusableNode();
                        if (obj4.getInserting()) {
                            obj4.createNode(function03);
                        } else {
                            factory$iv$iv$iv2 = function03;
                            obj4.useNode();
                        }
                        Composer constructor-impl10 = Updater.constructor-impl(obj4);
                        int i189 = 0;
                        currentCompositeKeyHash4 = factory$iv$iv$iv2;
                        Updater.set-impl(constructor-impl10, BoxKt.maybeCachedBoxMeasurePolicy(topStart2, false), ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(constructor-impl10, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        int i192 = 0;
                        Composer composer21 = constructor-impl10;
                        int i198 = 0;
                        if (!composer21.getInserting()) {
                            localMap$iv$iv2 = currentCompositionLocalMap;
                            if (!Intrinsics.areEqual(composer21.rememberedValue(), Integer.valueOf(i15))) {
                                composer21.updateRememberedValue(Integer.valueOf(i15));
                                constructor-impl10.apply(Integer.valueOf(i15), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            } else {
                                composer5 = composer21;
                            }
                        } else {
                            localMap$iv$iv2 = currentCompositionLocalMap;
                        }
                        Updater.set-impl(constructor-impl10, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                        $changed$iv = obj4;
                        valueOf2 = 0;
                        ComposerKt.sourceInformationMarkerStart($changed$iv, -2146769399, restartGroup);
                        restartGroup = BoxScopeInstance.INSTANCE;
                        i182 |= 6;
                        composer9 = $changed$iv;
                        i22 = 0;
                        i33 = i55;
                        currentCompositeKeyHash5 = materializeModifier2;
                        ComposerKt.sourceInformationMarkerStart($changed$iv, -945015195, "C565@27454L12:TextField.kt#uh7d8r");
                        supporting.invoke($changed$iv, Integer.valueOf(i56 &= 14));
                        ComposerKt.sourceInformationMarkerEnd($changed$iv);
                        ComposerKt.sourceInformationMarkerEnd($changed$iv);
                        obj4.endNode();
                        ComposerKt.sourceInformationMarkerEnd(obj4);
                        ComposerKt.sourceInformationMarkerEnd(obj4);
                        ComposerKt.sourceInformationMarkerEnd(obj4);
                    } else {
                        obj5 = supporting;
                    }
                    obj4.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd(obj4);
                    composer10.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer10);
                    ComposerKt.sourceInformationMarkerEnd(composer10);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    restartGroup.skipToGroupEnd();
                    obj5 = supporting;
                    i10 = traceInProgress2;
                    composer10 = restartGroup;
                    i25 = $dirty12;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer10.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new TextFieldKt.TextFieldLayout.2(modifier, textField, label, placeholder, leading, trailing, prefix, obj8, singleLine, $this$dp$iv, container, obj5, obj, $changed, $changed1);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    public static final int access$calculateHeight-mKXJcVc(int textFieldHeight, int labelHeight, int leadingHeight, int trailingHeight, int prefixHeight, int suffixHeight, int placeholderHeight, int supportingHeight, float animationProgress, long constraints, float density, PaddingValues paddingValues) {
        return TextFieldKt.calculateHeight-mKXJcVc(textFieldHeight, labelHeight, leadingHeight, trailingHeight, prefixHeight, suffixHeight, placeholderHeight, supportingHeight, animationProgress, constraints, density, paddingValues);
    }

    public static final int access$calculateWidth-yeHjK3Y(int leadingWidth, int trailingWidth, int prefixWidth, int suffixWidth, int textFieldWidth, int labelWidth, int placeholderWidth, long constraints) {
        return TextFieldKt.calculateWidth-yeHjK3Y(leadingWidth, trailingWidth, prefixWidth, suffixWidth, textFieldWidth, labelWidth, placeholderWidth, constraints);
    }

    public static final void access$placeWithLabel(Placeable.PlacementScope $receiver, int width, int totalHeight, Placeable textfieldPlaceable, Placeable labelPlaceable, Placeable placeholderPlaceable, Placeable leadingPlaceable, Placeable trailingPlaceable, Placeable prefixPlaceable, Placeable suffixPlaceable, Placeable containerPlaceable, Placeable supportingPlaceable, boolean singleLine, int labelEndPosition, int textPosition, float animationProgress, float density) {
        TextFieldKt.placeWithLabel($receiver, width, totalHeight, textfieldPlaceable, labelPlaceable, placeholderPlaceable, leadingPlaceable, trailingPlaceable, prefixPlaceable, suffixPlaceable, containerPlaceable, supportingPlaceable, singleLine, labelEndPosition, textPosition, animationProgress, density);
    }

    public static final void access$placeWithoutLabel(Placeable.PlacementScope $receiver, int width, int totalHeight, Placeable textPlaceable, Placeable placeholderPlaceable, Placeable leadingPlaceable, Placeable trailingPlaceable, Placeable prefixPlaceable, Placeable suffixPlaceable, Placeable containerPlaceable, Placeable supportingPlaceable, boolean singleLine, float density, PaddingValues paddingValues) {
        TextFieldKt.placeWithoutLabel($receiver, width, totalHeight, textPlaceable, placeholderPlaceable, leadingPlaceable, trailingPlaceable, prefixPlaceable, suffixPlaceable, containerPlaceable, supportingPlaceable, singleLine, density, paddingValues);
    }

    public static final int access$substractConstraintSafely(int $receiver, int from) {
        return TextFieldKt.substractConstraintSafely($receiver, from);
    }

    private static final int calculateHeight-mKXJcVc(int textFieldHeight, int labelHeight, int leadingHeight, int trailingHeight, int prefixHeight, int suffixHeight, int placeholderHeight, int supportingHeight, float animationProgress, long constraints, float density, PaddingValues paddingValues) {
        int i3;
        int lerp;
        int i2;
        int i4;
        int i;
        final float f = animationProgress;
        int i5 = 0;
        i3 = labelHeight > 0 ? 1 : i5;
        i2 = 0;
        arg0$iv *= paddingValues;
        if (i3 != 0) {
            i4 = 0;
            lerp = MathHelpersKt.lerp(arg0$iv3 *= paddingValues, arg0$iv2, f);
        } else {
            lerp = arg0$iv2;
        }
        final int i12 = trailingHeight;
        return Math.max(Constraints.getMinHeight-impl(constraints), i10 += supportingHeight);
    }

    private static final int calculateWidth-yeHjK3Y(int leadingWidth, int trailingWidth, int prefixWidth, int suffixWidth, int textFieldWidth, int labelWidth, int placeholderWidth, long constraints) {
        final int i = prefixWidth + suffixWidth;
        return Math.max(i6 += trailingWidth, Constraints.getMinWidth-impl(constraints));
    }

    public static final Modifier drawIndicatorLine(Modifier $this$drawIndicatorLine, State<BorderStroke> indicatorBorder) {
        TextFieldKt.drawIndicatorLine.1 anon = new TextFieldKt.drawIndicatorLine.1(indicatorBorder);
        return DrawModifierKt.drawWithContent($this$drawIndicatorLine, (Function1)anon);
    }

    public static final float getTextFieldWithLabelVerticalPadding() {
        return TextFieldKt.TextFieldWithLabelVerticalPadding;
    }

    private static final void placeWithLabel(Placeable.PlacementScope $this$placeWithLabel, int width, int totalHeight, Placeable textfieldPlaceable, Placeable labelPlaceable, Placeable placeholderPlaceable, Placeable leadingPlaceable, Placeable trailingPlaceable, Placeable prefixPlaceable, Placeable suffixPlaceable, Placeable containerPlaceable, Placeable supportingPlaceable, boolean singleLine, int labelEndPosition, int textPosition, float animationProgress, float density) {
        Alignment.Vertical centerVertically;
        int textHorizontalPosition;
        Placeable.PlacementScope roundToInt;
        int centerVertically2;
        int zero-nOcc-ac;
        long roundToInt2;
        Placeable.PlacementScope placementScope;
        Placeable.PlacementScope placementScope2;
        Placeable placeable;
        Placeable placeable2;
        int widthOrZero;
        int i2;
        int align2;
        int align;
        int height;
        int i3;
        int i4;
        int i5;
        int i6;
        int i;
        int i7;
        Placeable.PlacementScope.place-70tqf50$default($this$placeWithLabel, containerPlaceable, IntOffset.Companion.getZero-nOcc-ac(), obj4, 0, 2);
        int i8 = totalHeight - heightOrZero;
        if (leadingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, leadingPlaceable, 0, Alignment.Companion.getCenterVertically().align(leadingPlaceable.getHeight(), i8), 0, 4, 0);
        }
        if (labelPlaceable != null) {
            placeable = labelPlaceable;
            centerVertically = 0;
            if (singleLine) {
                roundToInt = Alignment.Companion.getCenterVertically().align(placeable.getHeight(), i8);
            } else {
                roundToInt = MathKt.roundToInt(textFieldPadding *= density);
            }
            Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, placeable, TextFieldImplKt.widthOrZero(leadingPlaceable), roundToInt - roundToInt2, 0, 4, 0);
        }
        if (prefixPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, prefixPlaceable, TextFieldImplKt.widthOrZero(leadingPlaceable), textPosition, 0, 4, 0);
        }
        i2 = widthOrZero2 + centerVertically2;
        Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, textfieldPlaceable, i2, textPosition, 0, 4, 0);
        if (placeholderPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, placeholderPlaceable, i2, textPosition, 0, 4, 0);
            textHorizontalPosition = i2;
        } else {
            textHorizontalPosition = i2;
        }
        if (suffixPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, suffixPlaceable, centerVertically2 - zero-nOcc-ac, textPosition, 0, 4, 0);
        }
        if (trailingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, trailingPlaceable, width - width2, Alignment.Companion.getCenterVertically().align(trailingPlaceable.getHeight(), i8), 0, 4, 0);
        }
        if (supportingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, supportingPlaceable, 0, i8, 0, 4, 0);
        } else {
            height = i8;
        }
    }

    private static final void placeWithoutLabel(Placeable.PlacementScope $this$placeWithoutLabel, int width, int totalHeight, Placeable textPlaceable, Placeable placeholderPlaceable, Placeable leadingPlaceable, Placeable trailingPlaceable, Placeable prefixPlaceable, Placeable suffixPlaceable, Placeable containerPlaceable, Placeable supportingPlaceable, boolean singleLine, float density, PaddingValues paddingValues) {
        int centerVertically;
        int widthOrZero;
        Placeable placeable2;
        int height2;
        int i9;
        Placeable placeWithoutLabel$calculateVerticalPosition;
        int height;
        int widthOrZero2;
        int i10;
        int placeWithoutLabel$calculateVerticalPosition2;
        int placeWithoutLabel$calculateVerticalPosition3;
        int i6;
        int i;
        int i5;
        int textHorizontalPosition;
        int i4;
        Placeable.PlacementScope placementScope;
        Placeable placeable;
        int i7;
        int align;
        int i8;
        int i2;
        int i3;
        placeable2 = placeholderPlaceable;
        Placeable placeable3 = prefixPlaceable;
        final Placeable placeable4 = suffixPlaceable;
        final boolean z = singleLine;
        Placeable.PlacementScope.place-70tqf50$default($this$placeWithoutLabel, containerPlaceable, IntOffset.Companion.getZero-nOcc-ac(), obj14, 0, 2);
        int i15 = totalHeight - heightOrZero;
        int roundToInt = MathKt.roundToInt(topPadding-D9Ej5fM *= density);
        if (leadingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithoutLabel, leadingPlaceable, 0, Alignment.Companion.getCenterVertically().align(leadingPlaceable.getHeight(), i15), 0, 4, 0);
        }
        if (placeable3 != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithoutLabel, placeable3, TextFieldImplKt.widthOrZero(leadingPlaceable), TextFieldKt.placeWithoutLabel$calculateVerticalPosition(z, i15, roundToInt, placeable3), 0, 4, 0);
        }
        placeWithoutLabel$calculateVerticalPosition = textPlaceable;
        i10 = i12;
        Placeable.PlacementScope.placeRelative$default($this$placeWithoutLabel, placeWithoutLabel$calculateVerticalPosition, i10, TextFieldKt.placeWithoutLabel$calculateVerticalPosition(z, i15, roundToInt, placeWithoutLabel$calculateVerticalPosition), 0, 4, 0);
        i9 = i10;
        if (placeable2 != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithoutLabel, placeable2, i9, TextFieldKt.placeWithoutLabel$calculateVerticalPosition(z, i15, roundToInt, placeable2), 0, 4, 0);
            textHorizontalPosition = i9;
        } else {
            textHorizontalPosition = i9;
        }
        if (placeable4 != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithoutLabel, placeable4, i11 - width3, TextFieldKt.placeWithoutLabel$calculateVerticalPosition(z, i15, roundToInt, placeable4), 0, 4, 0);
        }
        if (trailingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithoutLabel, trailingPlaceable, width - width2, Alignment.Companion.getCenterVertically().align(trailingPlaceable.getHeight(), i15), 0, 4, 0);
        }
        if (supportingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithoutLabel, supportingPlaceable, 0, i15, 0, 4, 0);
        } else {
            height = i15;
        }
    }

    private static final int placeWithoutLabel$calculateVerticalPosition(boolean $singleLine, int height, int topPadding, Placeable placeable) {
        int align;
        int height2;
        if ($singleLine) {
            align = Alignment.Companion.getCenterVertically().align(placeable.getHeight(), height);
        } else {
            align = topPadding;
        }
        return align;
    }

    private static final int substractConstraintSafely(int $this$substractConstraintSafely, int from) {
        if ($this$substractConstraintSafely == Integer.MAX_VALUE) {
            return $this$substractConstraintSafely;
        }
        return $this$substractConstraintSafely - from;
    }
}
