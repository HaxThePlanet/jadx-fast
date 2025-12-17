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
        Object obj7;
        Object obj10;
        Object obj2;
        Object obj4;
        Object obj15;
        Object obj19;
        boolean z;
        Object obj8;
        Object obj;
        Object obj12;
        boolean z2;
        int i3;
        int i18;
        Object obj6;
        Object obj3;
        Object obj14;
        int skipping;
        int i54;
        int i37;
        Object colors2;
        int defaultsInvalid;
        int this_$iv;
        int placeholder2;
        Composer textStyle2;
        int traceInProgress;
        int rememberedValue;
        long focused;
        int leadingIcon3;
        Object leadingIcon4;
        ScopeUpdateScope endRestartGroup;
        int trailingIcon2;
        boolean traceInProgress2;
        Object str2;
        Object modifier2;
        boolean $composer2;
        int $dirty3;
        boolean $dirty;
        int $dirty1;
        Object $dirty12;
        int $dirty22;
        Object $dirty2;
        int i12;
        Object obj17;
        int i63;
        Object str;
        int modifier4;
        boolean l;
        int i51;
        boolean z3;
        int i25;
        int i64;
        Object obj5;
        Object textStyle4;
        int modifier3;
        int i60;
        int prefix2;
        int i13;
        int prefix4;
        int isError4;
        Object obj9;
        Object label2;
        int colors3;
        Object obj20;
        VisualTransformation visualTransformation2;
        int suffix2;
        KeyboardOptions keyboardOptions2;
        int i59;
        int supportingText2;
        KeyboardActions enabled2;
        int i14;
        int i;
        boolean visualTransformation4;
        Object visualTransformation3;
        int readOnly2;
        int changed2;
        int keyboardOptions4;
        int i5;
        int i2;
        int i48;
        int changed3;
        Object isError2;
        int isError3;
        int keyboardOptions3;
        int i29;
        KeyboardActions keyboardActions3;
        int keyboardActions2;
        int i27;
        int singleLine2;
        Shape singleLine3;
        int i6;
        int maxLines3;
        androidx.compose.material3.TextFieldColors maxLines2;
        int minLines2;
        int i53;
        int i9;
        int i15;
        int changed5;
        Object interactionSource2;
        int interactionSource3;
        int i50;
        int i17;
        Object i36;
        int changed4;
        int obj13;
        int placeholder3;
        int changed;
        int obj18;
        Composer leadingIcon2;
        int i45;
        int obj11;
        int trailingIcon3;
        int i39;
        int obj16;
        int prefix3;
        int i33;
        int i34;
        int i26;
        int i46;
        int i61;
        TextStyle textStyle3;
        int i4;
        int i31;
        int i10;
        int i55;
        int i65;
        int i56;
        int i57;
        int i7;
        int i52;
        boolean changed6;
        int i32;
        int i24;
        int i47;
        int i43;
        int i35;
        int i16;
        int i21;
        int i62;
        int i8;
        int i19;
        int i38;
        int i30;
        int i11;
        int i22;
        int i49;
        int i23;
        int i58;
        int i40;
        int i20;
        int i41;
        int i42;
        int i44;
        ScopeUpdateScope scopeUpdateScope;
        int obj70;
        int obj71;
        Shape obj72;
        int i66 = $changed;
        int i86 = $changed1;
        trailingIcon2 = $changed2;
        int i95 = i28;
        Composer restartGroup = $composer.startRestartGroup(-1268528240);
        ComposerKt.sourceInformation(restartGroup, "C(TextField)P(21,11,10,1,14,19,6,12,7,20,13,17,18,3,22,5,4,16,8,9,2,15)357@19138L7,373@19934L5,374@19989L8,386@20569L1961,386@20482L2048:TextField.kt#uh7d8r");
        $dirty3 = $changed;
        $dirty1 = $changed1;
        $dirty22 = $changed2;
        if (i95 & 1 != 0) {
            $dirty3 |= 6;
            obj20 = value;
        } else {
            if (i66 & 6 == 0) {
                i12 = restartGroup.changed(value) ? 4 : 2;
                $dirty3 |= i12;
            } else {
                obj20 = value;
            }
        }
        if (i95 & 2 != 0) {
            $dirty3 |= 48;
            obj17 = onValueChange;
        } else {
            if (i66 & 48 == 0) {
                i60 = restartGroup.changedInstance(onValueChange) ? 32 : 16;
                $dirty3 |= i60;
            } else {
                obj17 = onValueChange;
            }
        }
        i13 = i95 & 4;
        int i106 = 128;
        if (i13 != 0) {
            $dirty3 |= 384;
            str = modifier;
        } else {
            if (i66 & 384 == 0) {
                i59 = restartGroup.changed(modifier) ? 256 : i106;
                $dirty3 |= i59;
            } else {
                str = modifier;
            }
        }
        supportingText2 = i95 & 8;
        changed2 = 1024;
        if (supportingText2 != 0) {
            $dirty3 |= 3072;
            l = enabled;
        } else {
            if (i66 & 3072 == 0) {
                i29 = restartGroup.changed(enabled) ? i14 : changed2;
                $dirty3 |= i29;
            } else {
                l = enabled;
            }
        }
        int i109 = i95 & 16;
        i6 = 8192;
        if (i109 != 0) {
            $dirty3 |= 24576;
            z3 = readOnly;
        } else {
            if (i66 & 24576 == 0) {
                i53 = restartGroup.changed(readOnly) ? i27 : i6;
                $dirty3 |= i53;
            } else {
                z3 = readOnly;
            }
        }
        i9 = 196608;
        i17 = 65536;
        if (i66 & i9 == 0) {
            if (i95 & 32 == 0) {
                changed4 = restartGroup.changed(textStyle) ? 131072 : i17;
            } else {
                obj5 = textStyle;
            }
            $dirty3 |= changed4;
        } else {
            obj5 = textStyle;
        }
        int i121 = i95 & 64;
        changed = 1572864;
        if (i121 != 0) {
            $dirty3 |= changed;
            obj9 = label;
        } else {
            if (i66 & changed == 0) {
                i39 = restartGroup.changedInstance(label) ? 1048576 : 524288;
                $dirty3 |= i39;
            } else {
                obj9 = label;
            }
        }
        int i67 = i95 & 128;
        int i122 = 12582912;
        i33 = 4194304;
        if (i67 != 0) {
            $dirty3 |= i122;
            i34 = i67;
            obj7 = placeholder;
        } else {
            if ($changed & i122 == 0) {
                i34 = i67;
                i26 = restartGroup.changedInstance(placeholder) ? 8388608 : i33;
                $dirty3 |= i26;
            } else {
                i34 = i67;
                obj7 = placeholder;
            }
        }
        int i68 = i95 & 256;
        int i124 = 100663296;
        if (i68 != 0) {
            $dirty3 |= i124;
            i46 = i68;
            obj10 = leadingIcon;
        } else {
            if ($changed & i124 == 0) {
                i46 = i68;
                i61 = restartGroup.changedInstance(leadingIcon) ? 67108864 : 33554432;
                $dirty3 |= i61;
            } else {
                i46 = i68;
                obj10 = leadingIcon;
            }
        }
        int i69 = i95 & 512;
        textStyle3 = 805306368;
        if (i69 != 0) {
            $dirty3 |= textStyle3;
            i4 = i69;
            obj2 = trailingIcon;
        } else {
            if ($changed & textStyle3 == 0) {
                i4 = i69;
                i31 = restartGroup.changedInstance(trailingIcon) ? 536870912 : 268435456;
                $dirty3 |= i31;
            } else {
                i4 = i69;
                obj2 = trailingIcon;
            }
        }
        int i70 = i95 & 1024;
        if (i70 != 0) {
            $dirty1 |= 6;
            i10 = i70;
            obj4 = prefix;
        } else {
            if (i86 & 6 == 0) {
                i10 = i70;
                i55 = restartGroup.changedInstance(prefix) ? 4 : 2;
                $dirty1 |= i55;
            } else {
                i10 = i70;
                obj4 = prefix;
            }
        }
        int i71 = i95 & 2048;
        if (i71 != 0) {
            $dirty1 |= 48;
            i65 = i71;
            obj15 = suffix;
        } else {
            if (i86 & 48 == 0) {
                i65 = i71;
                i56 = restartGroup.changedInstance(suffix) ? 32 : 16;
                $dirty1 |= i56;
            } else {
                i65 = i71;
                obj15 = suffix;
            }
        }
        int i72 = i95 & 4096;
        if (i72 != 0) {
            $dirty1 |= 384;
            i57 = i72;
            obj19 = supportingText;
        } else {
            i57 = i72;
            if (i86 & 384 == 0) {
                i7 = restartGroup.changedInstance(supportingText) ? 256 : i106;
                $dirty1 |= i7;
            } else {
                obj19 = supportingText;
            }
        }
        int i74 = i95 & 8192;
        if (i74 != 0) {
            $dirty1 |= 3072;
            i52 = i74;
            z = isError;
        } else {
            i52 = i74;
            if (i86 & 3072 == 0) {
                if (restartGroup.changed(isError)) {
                } else {
                    i14 = changed2;
                }
                $dirty1 |= i14;
            } else {
                z = isError;
            }
        }
        int i75 = i95 & 16384;
        if (i75 != 0) {
            $dirty1 |= 24576;
            i = i75;
            obj8 = visualTransformation;
        } else {
            i = i75;
            if (i86 & 24576 == 0) {
                if (restartGroup.changed(visualTransformation)) {
                } else {
                    i27 = i6;
                }
                $dirty1 |= i27;
            } else {
                obj8 = visualTransformation;
            }
        }
        keyboardOptions4 = i95 & i107;
        if (keyboardOptions4 != 0) {
            $dirty1 |= i9;
            obj = keyboardOptions;
        } else {
            if (i86 & i9 == 0) {
                i27 = restartGroup.changed(keyboardOptions) ? 131072 : i17;
                $dirty1 |= i27;
            } else {
                obj = keyboardOptions;
            }
        }
        int i110 = i95 & i17;
        if (i110 != 0) {
            $dirty1 |= changed;
            obj12 = keyboardActions;
        } else {
            if (i86 & changed == 0) {
                i6 = restartGroup.changed(keyboardActions) ? 1048576 : 524288;
                $dirty1 |= i6;
            } else {
                obj12 = keyboardActions;
            }
        }
        int i112 = i95 & i111;
        if (i112 != 0) {
            $dirty1 |= i122;
            z2 = singleLine;
        } else {
            if (i86 & i122 == 0) {
                i9 = restartGroup.changed(singleLine) ? 8388608 : i33;
                $dirty1 |= i9;
            } else {
                z2 = singleLine;
            }
        }
        if (i86 & i115 == 0) {
            if (i95 & i116 == 0) {
                i15 = restartGroup.changed(maxLines) ? 67108864 : 33554432;
            } else {
                i3 = maxLines;
            }
            $dirty1 |= i15;
        } else {
            i3 = maxLines;
        }
        interactionSource2 = i95 & i117;
        if (interactionSource2 != 0) {
            $dirty1 |= textStyle3;
            i18 = minLines;
        } else {
            if (i86 & textStyle3 == 0) {
                i17 = restartGroup.changed(minLines) ? 536870912 : 268435456;
                $dirty1 |= i17;
            } else {
                i18 = minLines;
            }
        }
        i36 = i95 & i120;
        if (i36 != 0) {
            $dirty22 |= 6;
            obj6 = interactionSource;
        } else {
            if (trailingIcon2 & 6 == 0) {
                i48 = restartGroup.changed(interactionSource) ? 4 : 2;
                $dirty22 |= i48;
            } else {
                obj6 = interactionSource;
            }
        }
        if (trailingIcon2 & 48 == 0) {
            if (i95 & i108 == 0) {
                minLines2 = restartGroup.changed(shape) ? 32 : 16;
            } else {
                obj3 = shape;
            }
            $dirty22 |= minLines2;
        } else {
            obj3 = shape;
        }
        if (trailingIcon2 & 384 == 0) {
            if (i95 & i33 == 0) {
                i45 = restartGroup.changed(colors) ? 256 : i106;
            } else {
                obj14 = colors;
            }
            $dirty22 |= i45;
        } else {
            obj14 = colors;
        }
        if ($dirty3 & suffix2 == 306783378 && i82 &= $dirty1 == 306783378 && $dirty22 & 147 == 146) {
            if (i82 &= $dirty1 == 306783378) {
                if ($dirty22 & 147 == 146) {
                    if (!restartGroup.getSkipping()) {
                        restartGroup.startDefaults();
                        if ($changed & 1 != 0) {
                            if (restartGroup.getDefaultsInvalid()) {
                                if (i13 != 0) {
                                    str = defaultsInvalid;
                                }
                                if (supportingText2 != 0) {
                                    l = defaultsInvalid;
                                }
                                if (i109 != 0) {
                                    z3 = defaultsInvalid;
                                }
                                if (i95 & 32 != 0) {
                                    i13 = 6;
                                    suffix2 = 0;
                                    ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                                    $dirty3 &= traceInProgress;
                                    obj5 = this_$iv;
                                }
                                if (i121 != 0) {
                                    obj9 = this_$iv;
                                }
                                placeholder2 = i34 != 0 ? 0 : placeholder;
                                leadingIcon3 = i46 != 0 ? 0 : leadingIcon;
                                trailingIcon2 = i4 != 0 ? 0 : trailingIcon;
                                prefix4 = i10 != 0 ? 0 : prefix;
                                suffix2 = i65 != 0 ? 0 : suffix;
                                supportingText2 = i57 != 0 ? 0 : supportingText;
                                isError3 = i52 != 0 ? 0 : isError;
                                if (i != 0) {
                                    visualTransformation3 = VisualTransformation.Companion.getNone();
                                } else {
                                    visualTransformation3 = visualTransformation;
                                }
                                if (keyboardOptions4 != 0) {
                                    keyboardOptions4 = KeyboardOptions.Companion.getDefault();
                                } else {
                                    keyboardOptions4 = keyboardOptions;
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
                                interactionSource3 = i36 != 0 ? 0 : interactionSource;
                                obj70 = placeholder2;
                                int placeholder4 = 6;
                                if (i95 & i118 != 0) {
                                    obj71 = leadingIcon3;
                                    leadingIcon4 = TextFieldDefaults.INSTANCE.getShape(restartGroup, placeholder4);
                                    $dirty22 &= -113;
                                } else {
                                    obj71 = leadingIcon3;
                                    leadingIcon4 = shape;
                                }
                                if (i95 & i33 != 0) {
                                    obj13 = obj70;
                                    obj18 = obj71;
                                    i46 = obj72;
                                    $dirty22 = i88;
                                    obj11 = trailingIcon2;
                                    obj16 = prefix4;
                                    i36 = obj9;
                                    i33 = suffix2;
                                    i34 = supportingText2;
                                    prefix2 = isError3;
                                    rememberedValue = interactionSource3;
                                    label2 = colors4;
                                    colors2 = obj5;
                                    interactionSource2 = visualTransformation3;
                                    isError2 = keyboardOptions4;
                                    textStyle4 = str;
                                    visualTransformation4 = z3;
                                } else {
                                    obj13 = obj70;
                                    obj18 = obj71;
                                    i46 = obj72;
                                    obj11 = trailingIcon2;
                                    colors2 = obj5;
                                    obj16 = prefix4;
                                    i36 = obj9;
                                    i33 = suffix2;
                                    i34 = supportingText2;
                                    prefix2 = isError3;
                                    rememberedValue = interactionSource3;
                                    label2 = colors;
                                    textStyle4 = str;
                                    interactionSource2 = visualTransformation3;
                                    isError2 = keyboardOptions4;
                                    visualTransformation4 = z3;
                                }
                            } else {
                                restartGroup.skipToGroupEnd();
                                if (i95 & 32 != 0) {
                                    $dirty3 &= i54;
                                }
                                if (i77 &= i95 != 0) {
                                    $dirty1 &= i37;
                                }
                                if (i78 &= i95 != 0) {
                                    $dirty22 &= -113;
                                }
                                if (i95 & i33 != 0) {
                                    obj13 = placeholder;
                                    obj18 = leadingIcon;
                                    obj11 = trailingIcon;
                                    obj16 = prefix;
                                    i33 = suffix;
                                    i34 = supportingText;
                                    prefix2 = isError;
                                    interactionSource2 = visualTransformation;
                                    isError2 = keyboardOptions;
                                    keyboardActions3 = keyboardActions;
                                    singleLine2 = singleLine;
                                    maxLines3 = maxLines;
                                    minLines2 = minLines;
                                    rememberedValue = interactionSource;
                                    i46 = shape;
                                    $dirty22 = i81;
                                    visualTransformation4 = z3;
                                    colors2 = obj5;
                                    i36 = obj9;
                                    label2 = colors;
                                    textStyle4 = str;
                                } else {
                                    obj13 = placeholder;
                                    obj18 = leadingIcon;
                                    obj11 = trailingIcon;
                                    obj16 = prefix;
                                    i33 = suffix;
                                    i34 = supportingText;
                                    prefix2 = isError;
                                    interactionSource2 = visualTransformation;
                                    isError2 = keyboardOptions;
                                    keyboardActions3 = keyboardActions;
                                    singleLine2 = singleLine;
                                    maxLines3 = maxLines;
                                    minLines2 = minLines;
                                    rememberedValue = interactionSource;
                                    i46 = shape;
                                    visualTransformation4 = z3;
                                    colors2 = obj5;
                                    i36 = obj9;
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
                            z3 = 0;
                            obj70 = rememberedValue;
                            rememberedValue = str.rememberedValue();
                            suffix2 = 0;
                            obj71 = i93;
                            if (rememberedValue == Composer.Companion.getEmpty()) {
                                int i94 = 0;
                                str.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                            } else {
                                str2 = rememberedValue;
                            }
                            ComposerKt.sourceInformationMarkerEnd(restartGroup);
                            i50 = str2;
                        } else {
                            i50 = obj70;
                        }
                        restartGroup.endReplaceGroup();
                        restartGroup.startReplaceGroup(-508235100);
                        ComposerKt.sourceInformation(restartGroup, "*381@20307L25");
                        focused = colors2.getColor-0d7_KjU();
                        int i101 = 0;
                        i25 = 0;
                        i5 = Long.compare(l2, i126) != 0 ? 1 : 0;
                        if (i5 != 0) {
                        } else {
                            i25 = 0;
                            obj71 = focused;
                            focused = label2.textColor-XeAY9LY$material3_release(l, prefix2, (Boolean)FocusInteractionKt.collectIsFocusedAsState((InteractionSource)i50, restartGroup, 0).getValue().booleanValue());
                        }
                        restartGroup.endReplaceGroup();
                        textStyle3 = new TextStyle(focused, i10, 0, i57, 0, 0, 0, 0, 0, 0, obj46, 0, 0, 0, 0, obj51, 0, 0, 0, 0, 0, 0, obj58, 0, 0, 0, 0, 0, 0, 16777214, 0);
                        boolean z4 = l;
                        TextFieldKt.TextField.3 anon = new TextFieldKt.TextField.3(textStyle4, prefix2, label2, obj20, obj17, z4, visualTransformation4, colors2.merge(textStyle3), isError2, keyboardActions3, singleLine2, maxLines3, minLines2, interactionSource2, i50, i36, obj13, obj18, obj11, obj16, i33, i34, i46);
                        CompositionLocalKt.CompositionLocalProvider(TextSelectionColorsKt.getLocalTextSelectionColors().provides(label2.getTextSelectionColors()), (Function2)ComposableLambdaKt.rememberComposableLambda(-1163788208, true, anon, restartGroup, 54), restartGroup, $stable |= 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        str = textStyle4;
                        keyboardOptions2 = isError2;
                        i2 = maxLines3;
                        keyboardOptions3 = minLines2;
                        visualTransformation2 = interactionSource2;
                        i63 = obj13;
                        i51 = obj11;
                        i64 = obj16;
                        modifier3 = i33;
                        placeholder3 = $dirty3;
                        trailingIcon3 = $dirty1;
                        prefix3 = $dirty22;
                        maxLines2 = label2;
                        $dirty = visualTransformation4;
                        readOnly2 = singleLine2;
                        $dirty2 = i36;
                        singleLine3 = i46;
                        $dirty12 = colors2;
                        textStyle2 = restartGroup;
                        colors3 = prefix2;
                        $composer2 = z4;
                        enabled2 = keyboardActions3;
                        isError4 = i34;
                        keyboardActions2 = obj70;
                    } else {
                        restartGroup.skipToGroupEnd();
                        i63 = placeholder;
                        obj18 = leadingIcon;
                        isError4 = supportingText;
                        visualTransformation2 = visualTransformation;
                        keyboardOptions2 = keyboardOptions;
                        enabled2 = keyboardActions;
                        readOnly2 = singleLine;
                        i2 = maxLines;
                        keyboardOptions3 = minLines;
                        keyboardActions2 = interactionSource;
                        singleLine3 = shape;
                        maxLines2 = colors;
                        textStyle2 = restartGroup;
                        placeholder3 = $dirty3;
                        trailingIcon3 = $dirty1;
                        prefix3 = $dirty22;
                        $composer2 = l;
                        $dirty = z3;
                        $dirty12 = obj5;
                        $dirty2 = obj9;
                        i51 = trailingIcon;
                        i64 = prefix;
                        modifier3 = suffix;
                        colors3 = isError;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        endRestartGroup = textStyle2.endRestartGroup();
        if (endRestartGroup != null) {
            leadingIcon2 = composer;
            textStyle2 = new TextFieldKt.TextField.4(value, onValueChange, str, $composer2, $dirty, $dirty12, $dirty2, i63, obj18, i51, i64, modifier3, isError4, colors3, visualTransformation2, keyboardOptions2, enabled2, readOnly2, i2, keyboardOptions3, keyboardActions2, singleLine3, maxLines2, $changed, $changed1, $changed2, i95);
            endRestartGroup.updateScope((Function2)textStyle2);
        } else {
            modifier2 = str;
            modifier4 = obj18;
            leadingIcon2 = textStyle2;
        }
    }

    public static final void TextField(String value, Function1<? super String, Unit> onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> label, Function2<? super Composer, ? super Integer, Unit> placeholder, Function2<? super Composer, ? super Integer, Unit> leadingIcon, Function2<? super Composer, ? super Integer, Unit> trailingIcon, Function2<? super Composer, ? super Integer, Unit> prefix, Function2<? super Composer, ? super Integer, Unit> suffix, Function2<? super Composer, ? super Integer, Unit> supportingText, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, int minLines, MutableInteractionSource interactionSource, Shape shape, androidx.compose.material3.TextFieldColors colors, Composer $composer, int $changed, int $changed1, int $changed2, int i28) {
        Object obj6;
        Object obj10;
        Object obj4;
        Object obj11;
        Object obj13;
        Object obj16;
        boolean z;
        Object obj5;
        Object obj3;
        Object obj20;
        boolean z3;
        int i43;
        int i57;
        Object obj9;
        Object obj;
        Object obj15;
        int skipping;
        int i24;
        int i30;
        Object colors3;
        int defaultsInvalid;
        int this_$iv;
        int placeholder3;
        Composer textStyle3;
        int traceInProgress;
        int rememberedValue;
        long focused;
        int leadingIcon3;
        Object leadingIcon4;
        ScopeUpdateScope endRestartGroup;
        int trailingIcon2;
        boolean traceInProgress2;
        Object str2;
        Object modifier3;
        boolean $composer2;
        int $dirty;
        boolean $dirty3;
        int $dirty12;
        Object $dirty1;
        int $dirty2;
        Object $dirty22;
        int i18;
        Object obj7;
        int i53;
        Object str;
        int modifier2;
        boolean l;
        int i42;
        boolean z2;
        int i45;
        int i64;
        Object obj12;
        Object textStyle4;
        int modifier4;
        int i56;
        int prefix4;
        int i41;
        int prefix3;
        int isError4;
        Object obj18;
        Object label2;
        int colors2;
        Object obj8;
        VisualTransformation visualTransformation3;
        int suffix2;
        KeyboardOptions keyboardOptions4;
        int i31;
        int supportingText2;
        KeyboardActions enabled2;
        int i16;
        int i8;
        boolean visualTransformation2;
        Object visualTransformation4;
        int readOnly2;
        int changed5;
        int keyboardOptions3;
        int i19;
        int i5;
        int i10;
        int changed3;
        Object isError3;
        int isError2;
        int keyboardOptions2;
        int i34;
        KeyboardActions keyboardActions3;
        int keyboardActions2;
        int i50;
        int singleLine3;
        Shape singleLine2;
        int i63;
        int maxLines2;
        androidx.compose.material3.TextFieldColors maxLines3;
        int minLines2;
        int i21;
        int i20;
        int i6;
        int changed2;
        Object interactionSource3;
        int interactionSource2;
        int i59;
        int i62;
        Object i37;
        int changed6;
        int obj19;
        int placeholder2;
        int changed4;
        int obj14;
        Composer leadingIcon2;
        int i7;
        int obj2;
        int trailingIcon3;
        int i38;
        int obj17;
        int prefix2;
        int i48;
        int i3;
        int i35;
        int i25;
        int i39;
        TextStyle textStyle2;
        int i54;
        int i32;
        int i65;
        int i;
        int i36;
        int i12;
        int i55;
        int i17;
        int i47;
        boolean changed;
        int i51;
        int i26;
        int i23;
        int i49;
        int i15;
        int i27;
        int i52;
        int i13;
        int i22;
        int i46;
        int i4;
        int i40;
        int i61;
        int i58;
        int i9;
        int i11;
        int i60;
        int i2;
        int i44;
        int i33;
        int i14;
        int i29;
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
        $dirty12 = $changed1;
        $dirty2 = $changed2;
        if (i95 & 1 != 0) {
            $dirty |= 6;
            obj8 = value;
        } else {
            if (i66 & 6 == 0) {
                i18 = restartGroup.changed(value) ? 4 : 2;
                $dirty |= i18;
            } else {
                obj8 = value;
            }
        }
        if (i95 & 2 != 0) {
            $dirty |= 48;
            obj7 = onValueChange;
        } else {
            if (i66 & 48 == 0) {
                i56 = restartGroup.changedInstance(onValueChange) ? 32 : 16;
                $dirty |= i56;
            } else {
                obj7 = onValueChange;
            }
        }
        i41 = i95 & 4;
        int i106 = 128;
        if (i41 != 0) {
            $dirty |= 384;
            str = modifier;
        } else {
            if (i66 & 384 == 0) {
                i31 = restartGroup.changed(modifier) ? 256 : i106;
                $dirty |= i31;
            } else {
                str = modifier;
            }
        }
        supportingText2 = i95 & 8;
        changed5 = 1024;
        if (supportingText2 != 0) {
            $dirty |= 3072;
            l = enabled;
        } else {
            if (i66 & 3072 == 0) {
                i34 = restartGroup.changed(enabled) ? i16 : changed5;
                $dirty |= i34;
            } else {
                l = enabled;
            }
        }
        int i109 = i95 & 16;
        i63 = 8192;
        if (i109 != 0) {
            $dirty |= 24576;
            z2 = readOnly;
        } else {
            if (i66 & 24576 == 0) {
                i21 = restartGroup.changed(readOnly) ? i50 : i63;
                $dirty |= i21;
            } else {
                z2 = readOnly;
            }
        }
        i20 = 196608;
        i62 = 65536;
        if (i66 & i20 == 0) {
            if (i95 & 32 == 0) {
                changed6 = restartGroup.changed(textStyle) ? 131072 : i62;
            } else {
                obj12 = textStyle;
            }
            $dirty |= changed6;
        } else {
            obj12 = textStyle;
        }
        int i121 = i95 & 64;
        changed4 = 1572864;
        if (i121 != 0) {
            $dirty |= changed4;
            obj18 = label;
        } else {
            if (i66 & changed4 == 0) {
                i38 = restartGroup.changedInstance(label) ? 1048576 : 524288;
                $dirty |= i38;
            } else {
                obj18 = label;
            }
        }
        int i67 = i95 & 128;
        int i122 = 12582912;
        i48 = 4194304;
        if (i67 != 0) {
            $dirty |= i122;
            i3 = i67;
            obj6 = placeholder;
        } else {
            if ($changed & i122 == 0) {
                i3 = i67;
                i35 = restartGroup.changedInstance(placeholder) ? 8388608 : i48;
                $dirty |= i35;
            } else {
                i3 = i67;
                obj6 = placeholder;
            }
        }
        int i68 = i95 & 256;
        int i124 = 100663296;
        if (i68 != 0) {
            $dirty |= i124;
            i25 = i68;
            obj10 = leadingIcon;
        } else {
            if ($changed & i124 == 0) {
                i25 = i68;
                i39 = restartGroup.changedInstance(leadingIcon) ? 67108864 : 33554432;
                $dirty |= i39;
            } else {
                i25 = i68;
                obj10 = leadingIcon;
            }
        }
        int i69 = i95 & 512;
        textStyle2 = 805306368;
        if (i69 != 0) {
            $dirty |= textStyle2;
            i54 = i69;
            obj4 = trailingIcon;
        } else {
            if ($changed & textStyle2 == 0) {
                i54 = i69;
                i32 = restartGroup.changedInstance(trailingIcon) ? 536870912 : 268435456;
                $dirty |= i32;
            } else {
                i54 = i69;
                obj4 = trailingIcon;
            }
        }
        int i70 = i95 & 1024;
        if (i70 != 0) {
            $dirty12 |= 6;
            i65 = i70;
            obj11 = prefix;
        } else {
            if (i86 & 6 == 0) {
                i65 = i70;
                i = restartGroup.changedInstance(prefix) ? 4 : 2;
                $dirty12 |= i;
            } else {
                i65 = i70;
                obj11 = prefix;
            }
        }
        int i71 = i95 & 2048;
        if (i71 != 0) {
            $dirty12 |= 48;
            i36 = i71;
            obj13 = suffix;
        } else {
            if (i86 & 48 == 0) {
                i36 = i71;
                i12 = restartGroup.changedInstance(suffix) ? 32 : 16;
                $dirty12 |= i12;
            } else {
                i36 = i71;
                obj13 = suffix;
            }
        }
        int i72 = i95 & 4096;
        if (i72 != 0) {
            $dirty12 |= 384;
            i55 = i72;
            obj16 = supportingText;
        } else {
            i55 = i72;
            if (i86 & 384 == 0) {
                i17 = restartGroup.changedInstance(supportingText) ? 256 : i106;
                $dirty12 |= i17;
            } else {
                obj16 = supportingText;
            }
        }
        int i74 = i95 & 8192;
        if (i74 != 0) {
            $dirty12 |= 3072;
            i47 = i74;
            z = isError;
        } else {
            i47 = i74;
            if (i86 & 3072 == 0) {
                if (restartGroup.changed(isError)) {
                } else {
                    i16 = changed5;
                }
                $dirty12 |= i16;
            } else {
                z = isError;
            }
        }
        int i75 = i95 & 16384;
        if (i75 != 0) {
            $dirty12 |= 24576;
            i8 = i75;
            obj5 = visualTransformation;
        } else {
            i8 = i75;
            if (i86 & 24576 == 0) {
                if (restartGroup.changed(visualTransformation)) {
                } else {
                    i50 = i63;
                }
                $dirty12 |= i50;
            } else {
                obj5 = visualTransformation;
            }
        }
        keyboardOptions3 = i95 & i107;
        if (keyboardOptions3 != 0) {
            $dirty12 |= i20;
            obj3 = keyboardOptions;
        } else {
            if (i86 & i20 == 0) {
                i50 = restartGroup.changed(keyboardOptions) ? 131072 : i62;
                $dirty12 |= i50;
            } else {
                obj3 = keyboardOptions;
            }
        }
        int i110 = i95 & i62;
        if (i110 != 0) {
            $dirty12 |= changed4;
            obj20 = keyboardActions;
        } else {
            if (i86 & changed4 == 0) {
                i63 = restartGroup.changed(keyboardActions) ? 1048576 : 524288;
                $dirty12 |= i63;
            } else {
                obj20 = keyboardActions;
            }
        }
        int i112 = i95 & i111;
        if (i112 != 0) {
            $dirty12 |= i122;
            z3 = singleLine;
        } else {
            if (i86 & i122 == 0) {
                i20 = restartGroup.changed(singleLine) ? 8388608 : i48;
                $dirty12 |= i20;
            } else {
                z3 = singleLine;
            }
        }
        if (i86 & i115 == 0) {
            if (i95 & i116 == 0) {
                i6 = restartGroup.changed(maxLines) ? 67108864 : 33554432;
            } else {
                i43 = maxLines;
            }
            $dirty12 |= i6;
        } else {
            i43 = maxLines;
        }
        interactionSource3 = i95 & i117;
        if (interactionSource3 != 0) {
            $dirty12 |= textStyle2;
            i57 = minLines;
        } else {
            if (i86 & textStyle2 == 0) {
                i62 = restartGroup.changed(minLines) ? 536870912 : 268435456;
                $dirty12 |= i62;
            } else {
                i57 = minLines;
            }
        }
        i37 = i95 & i120;
        if (i37 != 0) {
            $dirty2 |= 6;
            obj9 = interactionSource;
        } else {
            if (trailingIcon2 & 6 == 0) {
                i10 = restartGroup.changed(interactionSource) ? 4 : 2;
                $dirty2 |= i10;
            } else {
                obj9 = interactionSource;
            }
        }
        if (trailingIcon2 & 48 == 0) {
            if (i95 & i108 == 0) {
                minLines2 = restartGroup.changed(shape) ? 32 : 16;
            } else {
                obj = shape;
            }
            $dirty2 |= minLines2;
        } else {
            obj = shape;
        }
        if (trailingIcon2 & 384 == 0) {
            if (i95 & i48 == 0) {
                i7 = restartGroup.changed(colors) ? 256 : i106;
            } else {
                obj15 = colors;
            }
            $dirty2 |= i7;
        } else {
            obj15 = colors;
        }
        if ($dirty & suffix2 == 306783378 && i82 &= $dirty12 == 306783378 && $dirty2 & 147 == 146) {
            if (i82 &= $dirty12 == 306783378) {
                if ($dirty2 & 147 == 146) {
                    if (!restartGroup.getSkipping()) {
                        restartGroup.startDefaults();
                        if ($changed & 1 != 0) {
                            if (restartGroup.getDefaultsInvalid()) {
                                if (i41 != 0) {
                                    str = defaultsInvalid;
                                }
                                if (supportingText2 != 0) {
                                    l = defaultsInvalid;
                                }
                                if (i109 != 0) {
                                    z2 = defaultsInvalid;
                                }
                                if (i95 & 32 != 0) {
                                    i41 = 6;
                                    suffix2 = 0;
                                    ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                                    $dirty &= traceInProgress;
                                    obj12 = this_$iv;
                                }
                                if (i121 != 0) {
                                    obj18 = this_$iv;
                                }
                                placeholder3 = i3 != 0 ? 0 : placeholder;
                                leadingIcon3 = i25 != 0 ? 0 : leadingIcon;
                                trailingIcon2 = i54 != 0 ? 0 : trailingIcon;
                                prefix3 = i65 != 0 ? 0 : prefix;
                                suffix2 = i36 != 0 ? 0 : suffix;
                                supportingText2 = i55 != 0 ? 0 : supportingText;
                                isError2 = i47 != 0 ? 0 : isError;
                                if (i8 != 0) {
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
                                singleLine3 = i112 != 0 ? 0 : singleLine;
                                if (i95 & i113 != 0) {
                                    maxLines2 = singleLine3 != 0 ? 1 : 0x7fffffff /* Unknown resource */;
                                    $dirty12 &= minLines2;
                                } else {
                                    maxLines2 = maxLines;
                                }
                                minLines2 = interactionSource3 != 0 ? 1 : minLines;
                                interactionSource2 = i37 != 0 ? 0 : interactionSource;
                                obj70 = placeholder3;
                                int placeholder4 = 6;
                                if (i95 & i118 != 0) {
                                    obj71 = leadingIcon3;
                                    leadingIcon4 = TextFieldDefaults.INSTANCE.getShape(restartGroup, placeholder4);
                                    $dirty2 &= -113;
                                } else {
                                    obj71 = leadingIcon3;
                                    leadingIcon4 = shape;
                                }
                                if (i95 & i48 != 0) {
                                    obj19 = obj70;
                                    obj14 = obj71;
                                    i25 = obj72;
                                    $dirty2 = i88;
                                    obj2 = trailingIcon2;
                                    obj17 = prefix3;
                                    i37 = obj18;
                                    i48 = suffix2;
                                    i3 = supportingText2;
                                    prefix4 = isError2;
                                    rememberedValue = interactionSource2;
                                    label2 = colors4;
                                    colors3 = obj12;
                                    interactionSource3 = visualTransformation4;
                                    isError3 = keyboardOptions3;
                                    textStyle4 = str;
                                    visualTransformation2 = z2;
                                } else {
                                    obj19 = obj70;
                                    obj14 = obj71;
                                    i25 = obj72;
                                    obj2 = trailingIcon2;
                                    colors3 = obj12;
                                    obj17 = prefix3;
                                    i37 = obj18;
                                    i48 = suffix2;
                                    i3 = supportingText2;
                                    prefix4 = isError2;
                                    rememberedValue = interactionSource2;
                                    label2 = colors;
                                    textStyle4 = str;
                                    interactionSource3 = visualTransformation4;
                                    isError3 = keyboardOptions3;
                                    visualTransformation2 = z2;
                                }
                            } else {
                                restartGroup.skipToGroupEnd();
                                if (i95 & 32 != 0) {
                                    $dirty &= i24;
                                }
                                if (i77 &= i95 != 0) {
                                    $dirty12 &= i30;
                                }
                                if (i78 &= i95 != 0) {
                                    $dirty2 &= -113;
                                }
                                if (i95 & i48 != 0) {
                                    obj19 = placeholder;
                                    obj14 = leadingIcon;
                                    obj2 = trailingIcon;
                                    obj17 = prefix;
                                    i48 = suffix;
                                    i3 = supportingText;
                                    prefix4 = isError;
                                    interactionSource3 = visualTransformation;
                                    isError3 = keyboardOptions;
                                    keyboardActions3 = keyboardActions;
                                    singleLine3 = singleLine;
                                    maxLines2 = maxLines;
                                    minLines2 = minLines;
                                    rememberedValue = interactionSource;
                                    i25 = shape;
                                    $dirty2 = i81;
                                    visualTransformation2 = z2;
                                    colors3 = obj12;
                                    i37 = obj18;
                                    label2 = colors;
                                    textStyle4 = str;
                                } else {
                                    obj19 = placeholder;
                                    obj14 = leadingIcon;
                                    obj2 = trailingIcon;
                                    obj17 = prefix;
                                    i48 = suffix;
                                    i3 = supportingText;
                                    prefix4 = isError;
                                    interactionSource3 = visualTransformation;
                                    isError3 = keyboardOptions;
                                    keyboardActions3 = keyboardActions;
                                    singleLine3 = singleLine;
                                    maxLines2 = maxLines;
                                    minLines2 = minLines;
                                    rememberedValue = interactionSource;
                                    i25 = shape;
                                    visualTransformation2 = z2;
                                    colors3 = obj12;
                                    i37 = obj18;
                                    label2 = colors;
                                    textStyle4 = str;
                                }
                            }
                        } else {
                        }
                        restartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-676242365, $dirty, $dirty12, "androidx.compose.material3.TextField (TextField.kt:219)");
                        }
                        restartGroup.startReplaceGroup(-508515290);
                        ComposerKt.sourceInformation(restartGroup, "221@11518L39");
                        if (rememberedValue == 0) {
                            ComposerKt.sourceInformationMarkerStart(restartGroup, -508514639, "CC(remember):TextField.kt#9igjgp");
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
                                str2 = rememberedValue;
                            }
                            ComposerKt.sourceInformationMarkerEnd(restartGroup);
                            i59 = str2;
                        } else {
                            i59 = obj70;
                        }
                        restartGroup.endReplaceGroup();
                        restartGroup.startReplaceGroup(-508509180);
                        ComposerKt.sourceInformation(restartGroup, "*225@11742L25");
                        focused = colors3.getColor-0d7_KjU();
                        int i101 = 0;
                        i45 = 0;
                        i19 = Long.compare(l2, i126) != 0 ? 1 : 0;
                        if (i19 != 0) {
                        } else {
                            i45 = 0;
                            obj71 = focused;
                            focused = label2.textColor-XeAY9LY$material3_release(l, prefix4, (Boolean)FocusInteractionKt.collectIsFocusedAsState((InteractionSource)i59, restartGroup, 0).getValue().booleanValue());
                        }
                        restartGroup.endReplaceGroup();
                        textStyle2 = new TextStyle(focused, i65, 0, i55, 0, 0, 0, 0, 0, 0, obj46, 0, 0, 0, 0, obj51, 0, 0, 0, 0, 0, 0, obj58, 0, 0, 0, 0, 0, 0, 16777214, 0);
                        boolean z4 = l;
                        TextFieldKt.TextField.1 anon = new TextFieldKt.TextField.1(textStyle4, prefix4, label2, obj8, obj7, z4, visualTransformation2, colors3.merge(textStyle2), isError3, keyboardActions3, singleLine3, maxLines2, minLines2, interactionSource3, i59, i37, obj19, obj14, obj2, obj17, i48, i3, i25);
                        CompositionLocalKt.CompositionLocalProvider(TextSelectionColorsKt.getLocalTextSelectionColors().provides(label2.getTextSelectionColors()), (Function2)ComposableLambdaKt.rememberComposableLambda(1859145987, true, anon, restartGroup, 54), restartGroup, $stable |= 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        str = textStyle4;
                        keyboardOptions4 = isError3;
                        i5 = maxLines2;
                        keyboardOptions2 = minLines2;
                        visualTransformation3 = interactionSource3;
                        i53 = obj19;
                        i42 = obj2;
                        i64 = obj17;
                        modifier4 = i48;
                        placeholder2 = $dirty;
                        trailingIcon3 = $dirty12;
                        prefix2 = $dirty2;
                        maxLines3 = label2;
                        $dirty3 = visualTransformation2;
                        readOnly2 = singleLine3;
                        $dirty22 = i37;
                        singleLine2 = i25;
                        $dirty1 = colors3;
                        textStyle3 = restartGroup;
                        colors2 = prefix4;
                        $composer2 = z4;
                        enabled2 = keyboardActions3;
                        isError4 = i3;
                        keyboardActions2 = obj70;
                    } else {
                        restartGroup.skipToGroupEnd();
                        i53 = placeholder;
                        obj14 = leadingIcon;
                        isError4 = supportingText;
                        visualTransformation3 = visualTransformation;
                        keyboardOptions4 = keyboardOptions;
                        enabled2 = keyboardActions;
                        readOnly2 = singleLine;
                        i5 = maxLines;
                        keyboardOptions2 = minLines;
                        keyboardActions2 = interactionSource;
                        singleLine2 = shape;
                        maxLines3 = colors;
                        textStyle3 = restartGroup;
                        placeholder2 = $dirty;
                        trailingIcon3 = $dirty12;
                        prefix2 = $dirty2;
                        $composer2 = l;
                        $dirty3 = z2;
                        $dirty1 = obj12;
                        $dirty22 = obj18;
                        i42 = trailingIcon;
                        i64 = prefix;
                        modifier4 = suffix;
                        colors2 = isError;
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
            textStyle3 = new TextFieldKt.TextField.2(value, onValueChange, str, $composer2, $dirty3, $dirty1, $dirty22, i53, obj14, i42, i64, modifier4, isError4, colors2, visualTransformation3, keyboardOptions4, enabled2, readOnly2, i5, keyboardOptions2, keyboardActions2, singleLine2, maxLines3, $changed, $changed1, $changed2, i95);
            endRestartGroup.updateScope((Function2)textStyle3);
        } else {
            modifier3 = str;
            modifier2 = obj14;
            leadingIcon2 = textStyle3;
        }
    }

    public static final void TextFieldLayout(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> textField, Function2<? super Composer, ? super Integer, Unit> label, Function3<? super Modifier, ? super Composer, ? super Integer, Unit> placeholder, Function2<? super Composer, ? super Integer, Unit> leading, Function2<? super Composer, ? super Integer, Unit> trailing, Function2<? super Composer, ? super Integer, Unit> prefix, Function2<? super Composer, ? super Integer, Unit> suffix, boolean singleLine, float animationProgress, Function2<? super Composer, ? super Integer, Unit> container, Function2<? super Composer, ? super Integer, Unit> supporting, PaddingValues paddingValues, Composer $composer, int $changed, int $changed1) {
        int i26;
        int i11;
        int i8;
        int i16;
        int i22;
        int i5;
        int i33;
        boolean traceInProgress;
        Object endRestartGroup;
        int i19;
        Object it$iv;
        Object valueOf7;
        Object valueOf4;
        Object valueOf8;
        Modifier heightIn-VpY3zN4$default;
        Integer maybeCachedBoxMeasurePolicy2;
        Object valueOf3;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv5;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv7;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv2;
        Object obj2;
        kotlin.jvm.functions.Function0 factory$iv$iv;
        Composer $changed$iv;
        boolean traceInProgress2;
        int i2;
        int i17;
        Integer currentCompositionLocalMap2;
        int valueOf2;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv4;
        Object valueOf6;
        String $composer$iv;
        Object obj;
        Composer composer6;
        Composer composer;
        Object currentCompositionLocalMap;
        Integer currentCompositionLocalMap8;
        Integer currentCompositionLocalMap7;
        Integer maybeCachedBoxMeasurePolicy4;
        Integer maybeCachedBoxMeasurePolicy6;
        Object obj4;
        int $composer$iv2;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap6;
        Composer materialized$iv$iv;
        int i28;
        Object then;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv6;
        Composer composer8;
        Object currentCompositionLocalMap4;
        int materializeModifier;
        int constructor-impl;
        int iNSTANCE;
        Object obj5;
        Composer composer9;
        int valueOf;
        Composer composer11;
        androidx.compose.ui.layout.MeasurePolicy maybeCachedBoxMeasurePolicy7;
        Object materialized$iv$iv2;
        float $this$coerceAtLeast_u2dYgX7TsA$iv;
        BoxScopeInstance maybeCachedBoxMeasurePolicy3;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv3;
        float $this$dp$iv;
        int maybeCachedBoxMeasurePolicy;
        int iNSTANCE2;
        int valueOf5;
        Composer composer3;
        Composer composer10;
        Object currentCompositionLocalMap5;
        int topStart;
        int $i$f$cache;
        Integer currentCompositionLocalMap3;
        int maybeCachedBoxMeasurePolicy5;
        Object restartGroup;
        Composer composer7;
        int valueOf9;
        Object obj3;
        int $dirty12;
        Modifier modifier3;
        int $dirty1;
        int i3;
        int $dirty2;
        int $dirty;
        int i31;
        int i21;
        int i23;
        int i12;
        androidx.compose.material3.TextFieldMeasurePolicy field;
        int companion;
        int currentCompositeKeyHash4;
        int $i$f$cache2;
        int i34;
        int i6;
        kotlin.jvm.functions.Function0 function0;
        int i14;
        int i30;
        Composer composer2;
        int i10;
        Composer composer5;
        Modifier modifier4;
        int i24;
        androidx.compose.runtime.CompositionLocalMap localMap$iv;
        Modifier modifier2;
        int i20;
        Object layoutDirection;
        int i29;
        int i4;
        int i25;
        kotlin.jvm.functions.Function0 currentCompositeKeyHash2;
        float f4;
        Modifier currentCompositeKeyHash5;
        float endPadding;
        float currentCompositeKeyHash3;
        Composer currentCompositeKeyHash;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv;
        float f;
        int i13;
        int i7;
        kotlin.jvm.functions.Function0 f2;
        float constructor-impl2;
        int i18;
        int i9;
        int i15;
        int localMap$iv$iv2;
        float f3;
        float measurePolicy$iv;
        Composer composer4;
        int i32;
        int i;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy$iv2;
        androidx.compose.runtime.CompositionLocalMap map;
        Composer composer12;
        int i27;
        ScopeUpdateScope scopeUpdateScope;
        Alignment obj74;
        Object obj6 = modifier;
        $composer$iv2 = leading;
        materializeModifier = trailing;
        iNSTANCE = prefix;
        final Object obj8 = suffix;
        maybeCachedBoxMeasurePolicy7 = singleLine;
        $this$dp$iv = animationProgress;
        iNSTANCE2 = container;
        int i181 = $changed;
        int i183 = $changed1;
        restartGroup = $composer.startRestartGroup(-1830307184);
        ComposerKt.sourceInformation(restartGroup, "C(TextFieldLayout)P(4,11,2,6,3,12,7,9,8!2,10)455@23228L147,458@23423L7,459@23435L4118:TextField.kt#uh7d8r");
        obj74 = i36;
        if (i181 & 6 == 0) {
            i21 = restartGroup.changed(obj6) ? 4 : 2;
            $dirty2 = obj74 | i21;
        } else {
            $dirty2 = obj74;
        }
        if (i181 & 48 == 0) {
            i23 = restartGroup.changedInstance(textField) ? 32 : 16;
            $dirty2 |= i23;
        }
        if (i181 & 384 == 0) {
            i12 = restartGroup.changedInstance(label) ? 256 : 128;
            $dirty2 |= i12;
        }
        if (i181 & 3072 == 0) {
            i26 = restartGroup.changedInstance(placeholder) ? 2048 : 1024;
            $dirty2 |= i26;
        }
        if (i181 & 24576 == 0) {
            i11 = restartGroup.changedInstance($composer$iv2) ? 16384 : 8192;
            $dirty2 |= i11;
        }
        if (i38 &= i181 == 0) {
            i8 = restartGroup.changedInstance(materializeModifier) ? 131072 : 65536;
            $dirty2 |= i8;
        }
        if (i39 &= i181 == 0) {
            i16 = restartGroup.changedInstance(iNSTANCE) ? 1048576 : 524288;
            $dirty2 |= i16;
        }
        if (i40 &= i181 == 0) {
            i22 = restartGroup.changedInstance(obj8) ? 8388608 : 4194304;
            $dirty2 |= i22;
        }
        if (i41 &= i181 == 0) {
            i5 = restartGroup.changed(maybeCachedBoxMeasurePolicy7) ? 67108864 : 33554432;
            $dirty2 |= i5;
        }
        if (i42 &= i181 == 0) {
            i33 = restartGroup.changed($this$dp$iv) ? 536870912 : 268435456;
            $dirty2 |= i33;
        }
        traceInProgress = $dirty2;
        if (i183 & 6 == 0) {
            $dirty = restartGroup.changedInstance(iNSTANCE2) ? 4 : 2;
            $dirty1 |= $dirty;
        }
        if (i183 & 48 == 0) {
            i31 = restartGroup.changedInstance(supporting) ? 32 : 16;
            $dirty1 |= i31;
        }
        if (i183 & 384 == 0) {
            i31 = restartGroup.changed(paddingValues) ? 256 : 128;
            $dirty1 |= i31;
        } else {
            obj3 = paddingValues;
        }
        $dirty12 = $dirty1;
        if (traceInProgress & $dirty13 == 306783378 && $dirty12 & 147 == 146) {
            if ($dirty12 & 147 == 146) {
                if (!restartGroup.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1830307184, traceInProgress, $dirty12, "androidx.compose.material3.TextFieldLayout (TextField.kt:453)");
                    }
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1052646361, "CC(remember):TextField.kt#9igjgp");
                    int i187 = 1;
                    i3 = traceInProgress;
                    i2 = i87 &= traceInProgress == 67108864 ? i187 : 0;
                    i19 = i3 & i164 == 536870912 ? i187 : 0;
                    i17 = $dirty12 & 896 == 256 ? i187 : 0;
                    Composer composer13 = restartGroup;
                    $i$f$cache = 0;
                    it$iv = composer13.rememberedValue();
                    int i192 = 0;
                    if (i44 |= i17 == 0) {
                        $i$f$cache2 = $i$f$cache;
                        if (it$iv == Composer.Companion.getEmpty()) {
                            $i$f$cache = 0;
                            companion = it$iv;
                            it$iv = new TextFieldMeasurePolicy(maybeCachedBoxMeasurePolicy7, $this$dp$iv, obj3);
                            composer13.updateRememberedValue(it$iv);
                        } else {
                            companion = it$iv;
                        }
                    } else {
                        $i$f$cache2 = $i$f$cache;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    int i167 = 0;
                    int i191 = 0;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    valueOf7 = restartGroup.consume((CompositionLocal)CompositionLocalsKt.getLocalLayoutDirection());
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    $changed$iv = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, $changed$iv);
                    currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, 0);
                    currentCompositionLocalMap3 = restartGroup.getCurrentCompositionLocalMap();
                    i34 = i137;
                    materialized$iv$iv2 = ComposedModifierKt.materializeModifier(restartGroup, obj6);
                    kotlin.jvm.functions.Function0 function02 = constructor2;
                    i6 = 0;
                    i30 = $dirty12;
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
                    int i194 = 0;
                    composer5 = restartGroup;
                    Updater.set-impl(constructor-impl6, (MeasurePolicy)(TextFieldMeasurePolicy)it$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl6, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    valueOf9 = 0;
                    Composer composer20 = constructor-impl6;
                    i24 = 0;
                    if (!composer20.getInserting()) {
                        localMap$iv = currentCompositionLocalMap3;
                        i20 = valueOf9;
                        if (!Intrinsics.areEqual(composer20.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                            composer20.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                            constructor-impl6.apply(Integer.valueOf(currentCompositeKeyHash4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer7 = composer20;
                        }
                    } else {
                        localMap$iv = currentCompositionLocalMap3;
                        i20 = valueOf9;
                    }
                    Updater.set-impl(constructor-impl6, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                    obj4 = composer5;
                    maybeCachedBoxMeasurePolicy5 = 0;
                    i10 = i82;
                    ComposerKt.sourceInformationMarkerStart(obj4, -1362557328, "C465@23754L11,550@26868L187:TextField.kt#uh7d8r");
                    iNSTANCE2.invoke(obj4, Integer.valueOf(i30 & 14));
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
                        i4 = 0;
                        i25 = maybeCachedBoxMeasurePolicy5;
                        ComposerKt.sourceInformationMarkerStart(obj4, 733328855, str3);
                        int i179 = 0;
                        maybeCachedBoxMeasurePolicy6 = BoxKt.maybeCachedBoxMeasurePolicy(center2, i179);
                        f4 = 0;
                        currentCompositeKeyHash5 = center2;
                        ComposerKt.sourceInformationMarkerStart(obj4, -1323940314, $changed$iv);
                        endPadding = ComposablesKt.getCurrentCompositeKeyHash(obj4, 0);
                        currentCompositionLocalMap5 = obj4.getCurrentCompositionLocalMap();
                        currentCompositeKeyHash = i179;
                        i13 = then4;
                        kotlin.jvm.functions.Function0 function08 = constructor7;
                        localMap$iv$iv = 0;
                        ComposerKt.sourceInformationMarkerStart(obj4, -692256719, $dirty12);
                        if (!applier8 instanceof Applier) {
                            ComposablesKt.invalidApplier();
                        }
                        obj4.startReusableNode();
                        if (obj4.getInserting()) {
                            obj4.createNode(function08);
                        } else {
                            factory$iv$iv$iv3 = function08;
                            obj4.useNode();
                        }
                        i7 = factory$iv$iv$iv3;
                        Composer constructor-impl9 = Updater.constructor-impl(obj4);
                        int i229 = 0;
                        Updater.set-impl(constructor-impl9, maybeCachedBoxMeasurePolicy6, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(constructor-impl9, currentCompositionLocalMap5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        int i241 = 0;
                        Composer composer23 = constructor-impl9;
                        int i242 = 0;
                        if (!composer23.getInserting()) {
                            measurePolicy$iv = maybeCachedBoxMeasurePolicy6;
                            composer4 = currentCompositionLocalMap5;
                            if (!Intrinsics.areEqual(composer23.rememberedValue(), Integer.valueOf(endPadding))) {
                                composer23.updateRememberedValue(Integer.valueOf(endPadding));
                                constructor-impl9.apply(Integer.valueOf(endPadding), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            } else {
                                composer10 = composer23;
                            }
                        } else {
                            measurePolicy$iv = maybeCachedBoxMeasurePolicy6;
                            composer4 = currentCompositionLocalMap5;
                        }
                        Updater.set-impl(constructor-impl9, ComposedModifierKt.materializeModifier(obj4, then4), ComposeUiNode.Companion.getSetModifier());
                        Composer composer19 = obj4;
                        ComposerKt.sourceInformationMarkerStart(composer19, -2146769399, restartGroup);
                        iNSTANCE2 = BoxScopeInstance.INSTANCE;
                        i231 |= 6;
                        localMap$iv$iv2 = 0;
                        f3 = i108;
                        i = i152;
                        $this$dp$iv = i15;
                        ComposerKt.sourceInformationMarkerStart($this$dp$iv, -948431736, "C472@24010L9:TextField.kt#uh7d8r");
                        $composer$iv2.invoke($this$dp$iv, Integer.valueOf(i109 &= 14));
                        ComposerKt.sourceInformationMarkerEnd($this$dp$iv);
                        ComposerKt.sourceInformationMarkerEnd(composer19);
                        obj4.endNode();
                        ComposerKt.sourceInformationMarkerEnd(obj4);
                        ComposerKt.sourceInformationMarkerEnd(obj4);
                        ComposerKt.sourceInformationMarkerEnd(obj4);
                    } else {
                        i25 = maybeCachedBoxMeasurePolicy5;
                    }
                    obj4.endReplaceGroup();
                    obj4.startReplaceGroup(1341526310);
                    ComposerKt.sourceInformation(obj4, "476@24104L221");
                    Modifier then2 = LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Trailing").then(TextFieldImplKt.getIconDefaultSizeModifier());
                    Alignment center = Alignment.Companion.getCenter();
                    ComposerKt.sourceInformationMarkerStart(obj4, 733328855, str3);
                    valueOf5 = 0;
                    i4 = 0;
                    ComposerKt.sourceInformationMarkerStart(obj4, -1323940314, $changed$iv);
                    currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(obj4, 0);
                    currentCompositionLocalMap6 = obj4.getCurrentCompositionLocalMap();
                    f4 = center;
                    Modifier materializeModifier5 = ComposedModifierKt.materializeModifier(obj4, then2);
                    endPadding = then2;
                    kotlin.jvm.functions.Function0 function04 = constructor3;
                    currentCompositeKeyHash5 = 0;
                    ComposerKt.sourceInformationMarkerStart(obj4, -692256719, $dirty12);
                    if (materializeModifier != null && !applier6 instanceof Applier) {
                        then2 = LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Trailing").then(TextFieldImplKt.getIconDefaultSizeModifier());
                        center = Alignment.Companion.getCenter();
                        ComposerKt.sourceInformationMarkerStart(obj4, 733328855, str3);
                        valueOf5 = 0;
                        i4 = 0;
                        ComposerKt.sourceInformationMarkerStart(obj4, -1323940314, $changed$iv);
                        currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(obj4, 0);
                        currentCompositionLocalMap6 = obj4.getCurrentCompositionLocalMap();
                        f4 = center;
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
                            factory$iv$iv$iv4 = function04;
                            obj4.useNode();
                        }
                        currentCompositeKeyHash = factory$iv$iv$iv4;
                        Composer constructor-impl7 = Updater.constructor-impl(obj4);
                        int i208 = 0;
                        i18 = i147;
                        Updater.set-impl(constructor-impl7, BoxKt.maybeCachedBoxMeasurePolicy(center, valueOf5), ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(constructor-impl7, currentCompositionLocalMap6, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        int i215 = 0;
                        Composer composer22 = constructor-impl7;
                        int i232 = 0;
                        if (!composer22.getInserting()) {
                            localMap$iv$iv2 = currentCompositionLocalMap6;
                            f3 = valueOf5;
                            if (!Intrinsics.areEqual(composer22.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                composer22.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                constructor-impl7.apply(Integer.valueOf(currentCompositeKeyHash2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            } else {
                                composer3 = composer22;
                            }
                        } else {
                            localMap$iv$iv2 = currentCompositionLocalMap6;
                            f3 = valueOf5;
                        }
                        Updater.set-impl(constructor-impl7, materializeModifier5, ComposeUiNode.Companion.getSetModifier());
                        Composer composer18 = obj4;
                        $this$dp$iv = 0;
                        ComposerKt.sourceInformationMarkerStart(composer18, -2146769399, restartGroup);
                        iNSTANCE2 = BoxScopeInstance.INSTANCE;
                        i210 |= 6;
                        i9 = 0;
                        i15 = i96;
                        composer4 = materializeModifier5;
                        materialized$iv$iv2 = i7;
                        ComposerKt.sourceInformationMarkerStart(materialized$iv$iv2, -948147001, "C480@24297L10:TextField.kt#uh7d8r");
                        materializeModifier.invoke(materialized$iv$iv2, Integer.valueOf(i97 &= 14));
                        ComposerKt.sourceInformationMarkerEnd(materialized$iv$iv2);
                        ComposerKt.sourceInformationMarkerEnd(composer18);
                        obj4.endNode();
                        ComposerKt.sourceInformationMarkerEnd(obj4);
                        ComposerKt.sourceInformationMarkerEnd(obj4);
                        ComposerKt.sourceInformationMarkerEnd(obj4);
                    }
                    obj4.endReplaceGroup();
                    $composer$iv = PaddingKt.calculateStartPadding(obj3, (LayoutDirection)valueOf7);
                    materialized$iv$iv = PaddingKt.calculateEndPadding(obj3, valueOf7);
                    if (leading != null) {
                        int i150 = 0;
                        int i160 = 0;
                        iNSTANCE2 = 0;
                        $this$coerceAtLeast_u2dYgX7TsA$iv = Dp.constructor-impl(RangesKt.coerceAtLeast(Dp.constructor-impl($composer$iv - horizontalIconPadding2), Dp.constructor-impl((float)i151)));
                    } else {
                        $this$coerceAtLeast_u2dYgX7TsA$iv = $composer$iv;
                    }
                    f4 = $this$coerceAtLeast_u2dYgX7TsA$iv;
                    if (materializeModifier != null) {
                        int i148 = 0;
                        int i158 = 0;
                        iNSTANCE2 = 0;
                        currentCompositeKeyHash3 = $this$coerceAtLeast_u2dYgX7TsA$iv;
                    } else {
                        currentCompositeKeyHash3 = materialized$iv$iv;
                    }
                    f2 = currentCompositeKeyHash3;
                    obj4.startReplaceGroup(1341556924);
                    ComposerKt.sourceInformation(obj4, "501@25056L309");
                    maybeCachedBoxMeasurePolicy = 0;
                    if (iNSTANCE != null) {
                        layoutDirection = valueOf7;
                        int i177 = 0;
                        Modifier padding-qDBjuR0$default4 = PaddingKt.padding-qDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.heightIn-VpY3zN4$default(LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Prefix"), TextFieldImplKt.getMinTextLineHeight(), 0, 2, maybeCachedBoxMeasurePolicy), maybeCachedBoxMeasurePolicy, i177, 3, maybeCachedBoxMeasurePolicy), f4, 0, TextFieldImplKt.getPrefixSuffixTextPadding(), 0, 10, 0);
                        iNSTANCE2 = i177;
                        maybeCachedBoxMeasurePolicy5 = 0;
                        ComposerKt.sourceInformationMarkerStart(obj4, 733328855, str3);
                        Alignment topStart5 = Alignment.Companion.getTopStart();
                        f3 = $composer$iv;
                        maybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(topStart5, false);
                        currentCompositeKeyHash5 = 0;
                        measurePolicy$iv = materialized$iv$iv;
                        ComposerKt.sourceInformationMarkerStart(obj4, -1323940314, $changed$iv);
                        currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(obj4, 0);
                        currentCompositionLocalMap4 = obj4.getCurrentCompositionLocalMap();
                        localMap$iv$iv = padding-qDBjuR0$default4;
                        kotlin.jvm.functions.Function0 function05 = constructor4;
                        currentCompositeKeyHash = 0;
                        ComposerKt.sourceInformationMarkerStart(obj4, -692256719, $dirty12);
                        if (!applier4 instanceof Applier) {
                            ComposablesKt.invalidApplier();
                        }
                        obj4.startReusableNode();
                        if (obj4.getInserting()) {
                            obj4.createNode(function05);
                        } else {
                            factory$iv$iv$iv2 = function05;
                            obj4.useNode();
                        }
                        i13 = factory$iv$iv$iv2;
                        Composer constructor-impl5 = Updater.constructor-impl(obj4);
                        int i226 = 0;
                        composer4 = topStart5;
                        Updater.set-impl(constructor-impl5, maybeCachedBoxMeasurePolicy4, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(constructor-impl5, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        int i240 = 0;
                        Composer composer27 = constructor-impl5;
                        int i247 = 0;
                        if (!composer27.getInserting()) {
                            measurePolicy$iv2 = maybeCachedBoxMeasurePolicy4;
                            map = currentCompositionLocalMap4;
                            if (!Intrinsics.areEqual(composer27.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                composer27.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                constructor-impl5.apply(Integer.valueOf(currentCompositeKeyHash3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            } else {
                                composer8 = composer27;
                            }
                        } else {
                            measurePolicy$iv2 = maybeCachedBoxMeasurePolicy4;
                            map = currentCompositionLocalMap4;
                        }
                        Updater.set-impl(constructor-impl5, ComposedModifierKt.materializeModifier(obj4, padding-qDBjuR0$default4), ComposeUiNode.Companion.getSetModifier());
                        Composer composer17 = obj4;
                        ComposerKt.sourceInformationMarkerStart(composer17, -2146769399, restartGroup);
                        maybeCachedBoxMeasurePolicy3 = BoxScopeInstance.INSTANCE;
                        i228 |= 6;
                        i32 = 0;
                        i = i75;
                        i27 = i125;
                        materialized$iv$iv = i15;
                        ComposerKt.sourceInformationMarkerStart(materialized$iv$iv, -947113399, "C507@25339L8:TextField.kt#uh7d8r");
                        iNSTANCE.invoke(materialized$iv$iv, Integer.valueOf(i76 &= 14));
                        ComposerKt.sourceInformationMarkerEnd(materialized$iv$iv);
                        ComposerKt.sourceInformationMarkerEnd(composer17);
                        obj4.endNode();
                        ComposerKt.sourceInformationMarkerEnd(obj4);
                        ComposerKt.sourceInformationMarkerEnd(obj4);
                        ComposerKt.sourceInformationMarkerEnd(obj4);
                    } else {
                        layoutDirection = valueOf7;
                        f3 = $composer$iv;
                        measurePolicy$iv = materialized$iv$iv;
                    }
                    obj4.endReplaceGroup();
                    obj4.startReplaceGroup(1341568890);
                    ComposerKt.sourceInformation(obj4, "511@25430L307");
                    if (obj8 != null) {
                        int i142 = 0;
                        int i122 = 0;
                        Modifier padding-qDBjuR0$default3 = PaddingKt.padding-qDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.heightIn-VpY3zN4$default(LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Suffix"), TextFieldImplKt.getMinTextLineHeight(), 0, 2, i142), i142, i122, 3, i142), TextFieldImplKt.getPrefixSuffixTextPadding(), 0, f2, 0, 10, 0);
                        endPadding = f2;
                        int i105 = i122;
                        ComposerKt.sourceInformationMarkerStart(obj4, 733328855, str3);
                        Alignment topStart4 = Alignment.Companion.getTopStart();
                        maybeCachedBoxMeasurePolicy5 = 0;
                        ComposerKt.sourceInformationMarkerStart(obj4, -1323940314, $changed$iv);
                        currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(obj4, 0);
                        currentCompositionLocalMap7 = obj4.getCurrentCompositionLocalMap();
                        currentCompositeKeyHash = i123;
                        Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(obj4, padding-qDBjuR0$default3);
                        i13 = padding-qDBjuR0$default3;
                        kotlin.jvm.functions.Function0 function07 = constructor6;
                        localMap$iv$iv = 0;
                        ComposerKt.sourceInformationMarkerStart(obj4, -692256719, $dirty12);
                        if (!applier3 instanceof Applier) {
                            ComposablesKt.invalidApplier();
                        }
                        obj4.startReusableNode();
                        if (obj4.getInserting()) {
                            obj4.createNode(function07);
                        } else {
                            factory$iv$iv$iv = function07;
                            obj4.useNode();
                        }
                        f2 = factory$iv$iv$iv;
                        Composer constructor-impl4 = Updater.constructor-impl(obj4);
                        int i223 = 0;
                        composer4 = topStart4;
                        Updater.set-impl(constructor-impl4, BoxKt.maybeCachedBoxMeasurePolicy(topStart4, false), ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(constructor-impl4, currentCompositionLocalMap7, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        int i239 = 0;
                        Composer composer26 = constructor-impl4;
                        int i246 = 0;
                        if (!composer26.getInserting()) {
                            measurePolicy$iv2 = currentCompositionLocalMap7;
                            if (!Intrinsics.areEqual(composer26.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                                composer26.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
                                constructor-impl4.apply(Integer.valueOf(currentCompositeKeyHash5), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            } else {
                                composer11 = composer26;
                            }
                        } else {
                            measurePolicy$iv2 = currentCompositionLocalMap7;
                        }
                        Updater.set-impl(constructor-impl4, materializeModifier4, ComposeUiNode.Companion.getSetModifier());
                        Composer composer16 = obj4;
                        materializeModifier = 0;
                        ComposerKt.sourceInformationMarkerStart(composer16, -2146769399, restartGroup);
                        iNSTANCE = BoxScopeInstance.INSTANCE;
                        i225 |= 6;
                        i32 = 0;
                        i = i68;
                        composer12 = materializeModifier4;
                        materialized$iv$iv = i15;
                        ComposerKt.sourceInformationMarkerStart(materialized$iv$iv, -946744375, "C517@25711L8:TextField.kt#uh7d8r");
                        obj8.invoke(materialized$iv$iv, Integer.valueOf(i69 &= 14));
                        ComposerKt.sourceInformationMarkerEnd(materialized$iv$iv);
                        ComposerKt.sourceInformationMarkerEnd(composer16);
                        obj4.endNode();
                        ComposerKt.sourceInformationMarkerEnd(obj4);
                        ComposerKt.sourceInformationMarkerEnd(obj4);
                        ComposerKt.sourceInformationMarkerEnd(obj4);
                    } else {
                        endPadding = f2;
                    }
                    obj4.endReplaceGroup();
                    obj4.startReplaceGroup(1341581092);
                    ComposerKt.sourceInformation(obj4, "522@25802L574");
                    if (label != null) {
                        int i141 = 0;
                        int i119 = 0;
                        Modifier padding-qDBjuR0$default2 = PaddingKt.padding-qDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.heightIn-VpY3zN4$default(LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Label"), DpKt.lerp-Md-fbLM(TextFieldImplKt.getMinTextLineHeight(), TextFieldImplKt.getMinFocusedLabelLineHeight(), animationProgress), 0, 2, i141), i141, i119, 3, i141), f4, 0, endPadding, 0, 10, 0);
                        int i102 = i119;
                        ComposerKt.sourceInformationMarkerStart(obj4, 733328855, str3);
                        Alignment topStart3 = Alignment.Companion.getTopStart();
                        valueOf = 0;
                        maybeCachedBoxMeasurePolicy5 = 0;
                        ComposerKt.sourceInformationMarkerStart(obj4, -1323940314, $changed$iv);
                        currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(obj4, 0);
                        currentCompositionLocalMap8 = obj4.getCurrentCompositionLocalMap();
                        currentCompositeKeyHash = i120;
                        Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(obj4, padding-qDBjuR0$default2);
                        i13 = padding-qDBjuR0$default2;
                        kotlin.jvm.functions.Function0 function06 = constructor5;
                        localMap$iv$iv = 0;
                        ComposerKt.sourceInformationMarkerStart(obj4, -692256719, $dirty12);
                        if (!applier2 instanceof Applier) {
                            ComposablesKt.invalidApplier();
                        }
                        obj4.startReusableNode();
                        if (obj4.getInserting()) {
                            obj4.createNode(function06);
                        } else {
                            factory$iv$iv$iv7 = function06;
                            obj4.useNode();
                        }
                        f2 = factory$iv$iv$iv7;
                        Composer constructor-impl3 = Updater.constructor-impl(obj4);
                        int i219 = 0;
                        composer4 = topStart3;
                        Updater.set-impl(constructor-impl3, BoxKt.maybeCachedBoxMeasurePolicy(topStart3, valueOf), ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(constructor-impl3, currentCompositionLocalMap8, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        int i237 = 0;
                        Composer composer25 = constructor-impl3;
                        int i245 = 0;
                        if (!composer25.getInserting()) {
                            measurePolicy$iv2 = currentCompositionLocalMap8;
                            map = valueOf;
                            if (!Intrinsics.areEqual(composer25.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                                composer25.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
                                constructor-impl3.apply(Integer.valueOf(currentCompositeKeyHash5), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            } else {
                                composer9 = composer25;
                            }
                        } else {
                            measurePolicy$iv2 = currentCompositionLocalMap8;
                            map = valueOf;
                        }
                        Updater.set-impl(constructor-impl3, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                        Composer composer15 = obj4;
                        materializeModifier = 0;
                        ComposerKt.sourceInformationMarkerStart(composer15, -2146769399, restartGroup);
                        iNSTANCE = BoxScopeInstance.INSTANCE;
                        i221 |= 6;
                        i32 = 0;
                        i = i62;
                        i27 = materializeModifier3;
                        materialized$iv$iv = i15;
                        ComposerKt.sourceInformationMarkerStart(materialized$iv$iv, -946109526, "C535@26351L7:TextField.kt#uh7d8r");
                        label.invoke(materialized$iv$iv, Integer.valueOf(i63 &= 14));
                        ComposerKt.sourceInformationMarkerEnd(materialized$iv$iv);
                        ComposerKt.sourceInformationMarkerEnd(composer15);
                        obj4.endNode();
                        ComposerKt.sourceInformationMarkerEnd(obj4);
                        ComposerKt.sourceInformationMarkerEnd(obj4);
                        ComposerKt.sourceInformationMarkerEnd(obj4);
                    } else {
                        obj = label;
                        $this$dp$iv = animationProgress;
                    }
                    obj4.endReplaceGroup();
                    int i139 = 0;
                    if (prefix == null) {
                        f = f4;
                    } else {
                        i28 = 0;
                        f = constructor-impl;
                    }
                    if (obj8 == null) {
                        constructor-impl2 = endPadding;
                    } else {
                        i28 = 0;
                        constructor-impl2 = Dp.constructor-impl((float)heightIn-VpY3zN4$default);
                    }
                    Modifier padding-qDBjuR0$default = PaddingKt.padding-qDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.heightIn-VpY3zN4$default((Modifier)Modifier.Companion, TextFieldImplKt.getMinTextLineHeight(), 0, 2, i139), i139, false, 3, i139), f, 0, constructor-impl2, 0, 10, 0);
                    obj4.startReplaceGroup(1341611627);
                    ComposerKt.sourceInformation(obj4, "548@26778L63");
                    if (placeholder != null) {
                        placeholder.invoke(LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Hint").then(padding-qDBjuR0$default), obj4, Integer.valueOf(i128 &= 112));
                    } else {
                        obj5 = placeholder;
                    }
                    obj4.endReplaceGroup();
                    Modifier then3 = LayoutIdKt.layoutId((Modifier)Modifier.Companion, "TextField").then(padding-qDBjuR0$default);
                    int i126 = i187;
                    maybeCachedBoxMeasurePolicy7 = 384;
                    iNSTANCE2 = 0;
                    ComposerKt.sourceInformationMarkerStart(obj4, 733328855, str3);
                    modifier3 = padding-qDBjuR0$default;
                    maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), i126);
                    currentCompositeKeyHash5 = 0;
                    ComposerKt.sourceInformationMarkerStart(obj4, -1323940314, $changed$iv);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(obj4, 0);
                    currentCompositionLocalMap = obj4.getCurrentCompositionLocalMap();
                    localMap$iv$iv = i126;
                    i7 = then3;
                    kotlin.jvm.functions.Function0 function09 = constructor8;
                    i13 = 0;
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
                    i18 = factory$iv$iv$iv6;
                    Composer constructor-impl8 = Updater.constructor-impl(obj4);
                    int i234 = 0;
                    Updater.set-impl(constructor-impl8, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl8, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    int i243 = 0;
                    Composer composer24 = constructor-impl8;
                    int i244 = 0;
                    if (!composer24.getInserting()) {
                        measurePolicy$iv2 = maybeCachedBoxMeasurePolicy2;
                        map = currentCompositionLocalMap;
                        if (!Intrinsics.areEqual(composer24.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            composer24.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            constructor-impl8.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer6 = composer24;
                        }
                    } else {
                        measurePolicy$iv2 = maybeCachedBoxMeasurePolicy2;
                        map = currentCompositionLocalMap;
                    }
                    Updater.set-impl(constructor-impl8, ComposedModifierKt.materializeModifier(obj4, then3), ComposeUiNode.Companion.getSetModifier());
                    Composer composer14 = obj4;
                    ComposerKt.sourceInformationMarkerStart(composer14, -2146769399, restartGroup);
                    iNSTANCE = BoxScopeInstance.INSTANCE;
                    i236 |= 6;
                    i32 = 0;
                    i = i49;
                    i27 = i116;
                    $composer$iv2 = composer4;
                    ComposerKt.sourceInformationMarkerStart($composer$iv2, -945435834, "C554@27030L11:TextField.kt#uh7d8r");
                    textField.invoke($composer$iv2, Integer.valueOf(i50 &= 14));
                    ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                    ComposerKt.sourceInformationMarkerEnd(composer14);
                    obj4.endNode();
                    ComposerKt.sourceInformationMarkerEnd(obj4);
                    ComposerKt.sourceInformationMarkerEnd(obj4);
                    ComposerKt.sourceInformationMarkerEnd(obj4);
                    obj4.startReplaceGroup(1341622624);
                    ComposerKt.sourceInformation(obj4, "559@27167L317");
                    if (supporting != null) {
                        int i140 = 0;
                        Modifier padding = PaddingKt.padding(SizeKt.wrapContentHeight$default(SizeKt.heightIn-VpY3zN4$default(LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Supporting"), TextFieldImplKt.getMinSupportingTextLineHeight(), 0, 2, i140), i140, false, 3, i140), TextFieldDefaults.supportingTextPadding-a9UjIt4$material3_release$default(TextFieldDefaults.INSTANCE, 0, 0, 0, 0, 15, 0));
                        $composer$iv2 = i189;
                        materializeModifier = 0;
                        ComposerKt.sourceInformationMarkerStart(obj4, 733328855, str3);
                        Alignment topStart2 = Alignment.Companion.getTopStart();
                        topStart = 0;
                        obj74 = topStart2;
                        ComposerKt.sourceInformationMarkerStart(obj4, -1323940314, $changed$iv);
                        currentCompositionLocalMap2 = obj4.getCurrentCompositionLocalMap();
                        i31 = currentCompositeKeyHash6;
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
                            factory$iv$iv$iv5 = function03;
                            obj4.useNode();
                        }
                        Composer constructor-impl10 = Updater.constructor-impl(obj4);
                        int i193 = 0;
                        currentCompositeKeyHash2 = factory$iv$iv$iv5;
                        Updater.set-impl(constructor-impl10, BoxKt.maybeCachedBoxMeasurePolicy(topStart2, false), ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(constructor-impl10, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        int i196 = 0;
                        Composer composer21 = constructor-impl10;
                        int i202 = 0;
                        if (!composer21.getInserting()) {
                            localMap$iv$iv = currentCompositionLocalMap2;
                            if (!Intrinsics.areEqual(composer21.rememberedValue(), Integer.valueOf(i31))) {
                                composer21.updateRememberedValue(Integer.valueOf(i31));
                                constructor-impl10.apply(Integer.valueOf(i31), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            } else {
                                composer = composer21;
                            }
                        } else {
                            localMap$iv$iv = currentCompositionLocalMap2;
                        }
                        Updater.set-impl(constructor-impl10, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                        $changed$iv = obj4;
                        valueOf2 = 0;
                        ComposerKt.sourceInformationMarkerStart($changed$iv, -2146769399, restartGroup);
                        restartGroup = BoxScopeInstance.INSTANCE;
                        i186 |= 6;
                        composer2 = $changed$iv;
                        i24 = 0;
                        i29 = i56;
                        currentCompositeKeyHash5 = materializeModifier2;
                        ComposerKt.sourceInformationMarkerStart($changed$iv, -945015195, "C565@27454L12:TextField.kt#uh7d8r");
                        supporting.invoke($changed$iv, Integer.valueOf(i57 &= 14));
                        ComposerKt.sourceInformationMarkerEnd($changed$iv);
                        ComposerKt.sourceInformationMarkerEnd($changed$iv);
                        obj4.endNode();
                        ComposerKt.sourceInformationMarkerEnd(obj4);
                        ComposerKt.sourceInformationMarkerEnd(obj4);
                        ComposerKt.sourceInformationMarkerEnd(obj4);
                    } else {
                        obj2 = supporting;
                    }
                    obj4.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd(obj4);
                    composer5.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer5);
                    ComposerKt.sourceInformationMarkerEnd(composer5);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    restartGroup.skipToGroupEnd();
                    obj2 = supporting;
                    i3 = traceInProgress;
                    composer5 = restartGroup;
                    i30 = $dirty12;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer5.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new TextFieldKt.TextFieldLayout.2(modifier, textField, label, placeholder, leading, trailing, prefix, obj8, singleLine, $this$dp$iv, container, obj2, obj3, $changed, $changed1);
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
        int i;
        int lerp;
        int i3;
        int i4;
        int i2;
        final float f = animationProgress;
        int i5 = 0;
        i = labelHeight > 0 ? 1 : i5;
        i3 = 0;
        arg0$iv *= paddingValues;
        if (i != 0) {
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
        Placeable.PlacementScope roundToInt2;
        int centerVertically2;
        int zero-nOcc-ac;
        long roundToInt;
        Placeable.PlacementScope placementScope2;
        Placeable.PlacementScope placementScope;
        Placeable placeable2;
        Placeable placeable;
        int widthOrZero;
        int i5;
        int align2;
        int align;
        int height;
        int i;
        int i2;
        int i3;
        int i6;
        int i4;
        int i7;
        Placeable.PlacementScope.place-70tqf50$default($this$placeWithLabel, containerPlaceable, IntOffset.Companion.getZero-nOcc-ac(), obj4, 0, 2);
        int i8 = totalHeight - heightOrZero;
        if (leadingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, leadingPlaceable, 0, Alignment.Companion.getCenterVertically().align(leadingPlaceable.getHeight(), i8), 0, 4, 0);
        }
        if (labelPlaceable != null) {
            placeable2 = labelPlaceable;
            centerVertically = 0;
            if (singleLine) {
                roundToInt2 = Alignment.Companion.getCenterVertically().align(placeable2.getHeight(), i8);
            } else {
                roundToInt2 = MathKt.roundToInt(textFieldPadding *= density);
            }
            Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, placeable2, TextFieldImplKt.widthOrZero(leadingPlaceable), roundToInt2 - roundToInt, 0, 4, 0);
        }
        if (prefixPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, prefixPlaceable, TextFieldImplKt.widthOrZero(leadingPlaceable), textPosition, 0, 4, 0);
        }
        i5 = widthOrZero2 + centerVertically2;
        Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, textfieldPlaceable, i5, textPosition, 0, 4, 0);
        if (placeholderPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, placeholderPlaceable, i5, textPosition, 0, 4, 0);
            textHorizontalPosition = i5;
        } else {
            textHorizontalPosition = i5;
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
        int i5;
        Placeable placeWithoutLabel$calculateVerticalPosition;
        int height;
        int widthOrZero2;
        int i6;
        int placeWithoutLabel$calculateVerticalPosition2;
        int placeWithoutLabel$calculateVerticalPosition3;
        int i;
        int i7;
        int i2;
        int textHorizontalPosition;
        int i8;
        Placeable.PlacementScope placementScope;
        Placeable placeable;
        int i9;
        int align;
        int i10;
        int i3;
        int i4;
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
        i6 = i12;
        Placeable.PlacementScope.placeRelative$default($this$placeWithoutLabel, placeWithoutLabel$calculateVerticalPosition, i6, TextFieldKt.placeWithoutLabel$calculateVerticalPosition(z, i15, roundToInt, placeWithoutLabel$calculateVerticalPosition), 0, 4, 0);
        i5 = i6;
        if (placeable2 != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithoutLabel, placeable2, i5, TextFieldKt.placeWithoutLabel$calculateVerticalPosition(z, i15, roundToInt, placeable2), 0, 4, 0);
            textHorizontalPosition = i5;
        } else {
            textHorizontalPosition = i5;
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
