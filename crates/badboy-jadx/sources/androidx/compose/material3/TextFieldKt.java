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
        Object obj19;
        Object obj4;
        Object obj10;
        Object obj16;
        Object obj20;
        boolean z3;
        Object obj17;
        Object obj11;
        Object obj9;
        boolean z;
        int i38;
        int i54;
        Object obj5;
        Object obj13;
        Object obj6;
        int skipping;
        int i62;
        int i61;
        Object colors3;
        int defaultsInvalid;
        int this_$iv;
        int placeholder2;
        Composer textStyle4;
        int traceInProgress2;
        int rememberedValue;
        long focused;
        int leadingIcon2;
        Object leadingIcon3;
        ScopeUpdateScope endRestartGroup;
        int trailingIcon3;
        boolean traceInProgress;
        Object $i$a$CacheTextFieldKt$TextField$interactionSource$2;
        Object modifier3;
        boolean $composer2;
        int $dirty;
        boolean $dirty3;
        int $dirty1;
        Object $dirty12;
        int $dirty22;
        Object $dirty2;
        int i32;
        Object obj;
        int i43;
        Object str;
        int modifier2;
        boolean l;
        int i10;
        boolean z2;
        int i36;
        int i18;
        Object obj8;
        Object textStyle2;
        int modifier4;
        int i37;
        int prefix4;
        int i11;
        int prefix3;
        int isError3;
        Object obj12;
        Object label2;
        int colors2;
        Object obj3;
        VisualTransformation visualTransformation3;
        int suffix2;
        KeyboardOptions keyboardOptions2;
        int i33;
        int supportingText2;
        KeyboardActions enabled2;
        int i58;
        int i31;
        boolean visualTransformation2;
        Object visualTransformation4;
        int readOnly2;
        int changed6;
        int keyboardOptions3;
        int i34;
        int i14;
        int i44;
        int changed;
        Object isError4;
        int isError2;
        int keyboardOptions4;
        int i39;
        KeyboardActions keyboardActions3;
        int keyboardActions2;
        int i63;
        int singleLine3;
        Shape singleLine2;
        int i7;
        int maxLines2;
        androidx.compose.material3.TextFieldColors maxLines3;
        int minLines2;
        int i51;
        int i9;
        int i25;
        int changed2;
        Object interactionSource2;
        int interactionSource3;
        int i24;
        int i29;
        Object i52;
        int changed5;
        int obj2;
        int placeholder3;
        int changed3;
        int obj14;
        Composer leadingIcon4;
        int i4;
        int obj15;
        int trailingIcon2;
        int i59;
        int obj18;
        int prefix2;
        int i30;
        int i46;
        int i21;
        int i40;
        int i35;
        TextStyle textStyle3;
        int i19;
        int i42;
        int i17;
        int i60;
        int i;
        int i57;
        int i26;
        int i27;
        int i41;
        boolean changed4;
        int i2;
        int i16;
        int i6;
        int i5;
        int i64;
        int i12;
        int i55;
        int i8;
        int i13;
        int i65;
        int i20;
        int i23;
        int i15;
        int i50;
        int i49;
        int i56;
        int i47;
        int i53;
        int i48;
        int i45;
        int i22;
        int i3;
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
        $dirty = $changed;
        $dirty1 = $changed1;
        $dirty22 = $changed2;
        if (i95 & 1 != 0) {
            $dirty |= 6;
            obj3 = value;
        } else {
            if (i66 & 6 == 0) {
                i32 = restartGroup.changed(value) ? 4 : 2;
                $dirty |= i32;
            } else {
                obj3 = value;
            }
        }
        if (i95 & 2 != 0) {
            $dirty |= 48;
            obj = onValueChange;
        } else {
            if (i66 & 48 == 0) {
                i37 = restartGroup.changedInstance(onValueChange) ? 32 : 16;
                $dirty |= i37;
            } else {
                obj = onValueChange;
            }
        }
        i11 = i95 & 4;
        int i106 = 128;
        if (i11 != 0) {
            $dirty |= 384;
            str = modifier;
        } else {
            if (i66 & 384 == 0) {
                i33 = restartGroup.changed(modifier) ? 256 : i106;
                $dirty |= i33;
            } else {
                str = modifier;
            }
        }
        supportingText2 = i95 & 8;
        changed6 = 1024;
        if (supportingText2 != 0) {
            $dirty |= 3072;
            l = enabled;
        } else {
            if (i66 & 3072 == 0) {
                i39 = restartGroup.changed(enabled) ? i58 : changed6;
                $dirty |= i39;
            } else {
                l = enabled;
            }
        }
        int i109 = i95 & 16;
        i7 = 8192;
        if (i109 != 0) {
            $dirty |= 24576;
            z2 = readOnly;
        } else {
            if (i66 & 24576 == 0) {
                i51 = restartGroup.changed(readOnly) ? i63 : i7;
                $dirty |= i51;
            } else {
                z2 = readOnly;
            }
        }
        i9 = 196608;
        i29 = 65536;
        if (i66 & i9 == 0) {
            if (i95 & 32 == 0) {
                changed5 = restartGroup.changed(textStyle) ? 131072 : i29;
            } else {
                obj8 = textStyle;
            }
            $dirty |= changed5;
        } else {
            obj8 = textStyle;
        }
        int i121 = i95 & 64;
        changed3 = 1572864;
        if (i121 != 0) {
            $dirty |= changed3;
            obj12 = label;
        } else {
            if (i66 & changed3 == 0) {
                i59 = restartGroup.changedInstance(label) ? 1048576 : 524288;
                $dirty |= i59;
            } else {
                obj12 = label;
            }
        }
        int i67 = i95 & 128;
        int i122 = 12582912;
        i30 = 4194304;
        if (i67 != 0) {
            $dirty |= i122;
            i46 = i67;
            obj7 = placeholder;
        } else {
            if ($changed & i122 == 0) {
                i46 = i67;
                i21 = restartGroup.changedInstance(placeholder) ? 8388608 : i30;
                $dirty |= i21;
            } else {
                i46 = i67;
                obj7 = placeholder;
            }
        }
        int i68 = i95 & 256;
        int i124 = 100663296;
        if (i68 != 0) {
            $dirty |= i124;
            i40 = i68;
            obj19 = leadingIcon;
        } else {
            if ($changed & i124 == 0) {
                i40 = i68;
                i35 = restartGroup.changedInstance(leadingIcon) ? 67108864 : 33554432;
                $dirty |= i35;
            } else {
                i40 = i68;
                obj19 = leadingIcon;
            }
        }
        int i69 = i95 & 512;
        textStyle3 = 805306368;
        if (i69 != 0) {
            $dirty |= textStyle3;
            i19 = i69;
            obj4 = trailingIcon;
        } else {
            if ($changed & textStyle3 == 0) {
                i19 = i69;
                i42 = restartGroup.changedInstance(trailingIcon) ? 536870912 : 268435456;
                $dirty |= i42;
            } else {
                i19 = i69;
                obj4 = trailingIcon;
            }
        }
        int i70 = i95 & 1024;
        if (i70 != 0) {
            $dirty1 |= 6;
            i17 = i70;
            obj10 = prefix;
        } else {
            if (i86 & 6 == 0) {
                i17 = i70;
                i60 = restartGroup.changedInstance(prefix) ? 4 : 2;
                $dirty1 |= i60;
            } else {
                i17 = i70;
                obj10 = prefix;
            }
        }
        int i71 = i95 & 2048;
        if (i71 != 0) {
            $dirty1 |= 48;
            i = i71;
            obj16 = suffix;
        } else {
            if (i86 & 48 == 0) {
                i = i71;
                i57 = restartGroup.changedInstance(suffix) ? 32 : 16;
                $dirty1 |= i57;
            } else {
                i = i71;
                obj16 = suffix;
            }
        }
        int i72 = i95 & 4096;
        if (i72 != 0) {
            $dirty1 |= 384;
            i26 = i72;
            obj20 = supportingText;
        } else {
            i26 = i72;
            if (i86 & 384 == 0) {
                i27 = restartGroup.changedInstance(supportingText) ? 256 : i106;
                $dirty1 |= i27;
            } else {
                obj20 = supportingText;
            }
        }
        int i74 = i95 & 8192;
        if (i74 != 0) {
            $dirty1 |= 3072;
            i41 = i74;
            z3 = isError;
        } else {
            i41 = i74;
            if (i86 & 3072 == 0) {
                if (restartGroup.changed(isError)) {
                } else {
                    i58 = changed6;
                }
                $dirty1 |= i58;
            } else {
                z3 = isError;
            }
        }
        int i75 = i95 & 16384;
        if (i75 != 0) {
            $dirty1 |= 24576;
            i31 = i75;
            obj17 = visualTransformation;
        } else {
            i31 = i75;
            if (i86 & 24576 == 0) {
                if (restartGroup.changed(visualTransformation)) {
                } else {
                    i63 = i7;
                }
                $dirty1 |= i63;
            } else {
                obj17 = visualTransformation;
            }
        }
        keyboardOptions3 = i95 & i107;
        if (keyboardOptions3 != 0) {
            $dirty1 |= i9;
            obj11 = keyboardOptions;
        } else {
            if (i86 & i9 == 0) {
                i63 = restartGroup.changed(keyboardOptions) ? 131072 : i29;
                $dirty1 |= i63;
            } else {
                obj11 = keyboardOptions;
            }
        }
        int i110 = i95 & i29;
        if (i110 != 0) {
            $dirty1 |= changed3;
            obj9 = keyboardActions;
        } else {
            if (i86 & changed3 == 0) {
                i7 = restartGroup.changed(keyboardActions) ? 1048576 : 524288;
                $dirty1 |= i7;
            } else {
                obj9 = keyboardActions;
            }
        }
        int i112 = i95 & i111;
        if (i112 != 0) {
            $dirty1 |= i122;
            z = singleLine;
        } else {
            if (i86 & i122 == 0) {
                i9 = restartGroup.changed(singleLine) ? 8388608 : i30;
                $dirty1 |= i9;
            } else {
                z = singleLine;
            }
        }
        if (i86 & i115 == 0) {
            if (i95 & i116 == 0) {
                i25 = restartGroup.changed(maxLines) ? 67108864 : 33554432;
            } else {
                i38 = maxLines;
            }
            $dirty1 |= i25;
        } else {
            i38 = maxLines;
        }
        interactionSource2 = i95 & i117;
        if (interactionSource2 != 0) {
            $dirty1 |= textStyle3;
            i54 = minLines;
        } else {
            if (i86 & textStyle3 == 0) {
                i29 = restartGroup.changed(minLines) ? 536870912 : 268435456;
                $dirty1 |= i29;
            } else {
                i54 = minLines;
            }
        }
        i52 = i95 & i120;
        if (i52 != 0) {
            $dirty22 |= 6;
            obj5 = interactionSource;
        } else {
            if (trailingIcon3 & 6 == 0) {
                i44 = restartGroup.changed(interactionSource) ? 4 : 2;
                $dirty22 |= i44;
            } else {
                obj5 = interactionSource;
            }
        }
        if (trailingIcon3 & 48 == 0) {
            if (i95 & i108 == 0) {
                minLines2 = restartGroup.changed(shape) ? 32 : 16;
            } else {
                obj13 = shape;
            }
            $dirty22 |= minLines2;
        } else {
            obj13 = shape;
        }
        if (trailingIcon3 & 384 == 0) {
            if (i95 & i30 == 0) {
                i4 = restartGroup.changed(colors) ? 256 : i106;
            } else {
                obj6 = colors;
            }
            $dirty22 |= i4;
        } else {
            obj6 = colors;
        }
        if ($dirty & suffix2 == 306783378 && i82 &= $dirty1 == 306783378 && $dirty22 & 147 == 146) {
            if (i82 &= $dirty1 == 306783378) {
                if ($dirty22 & 147 == 146) {
                    if (!restartGroup.getSkipping()) {
                        restartGroup.startDefaults();
                        if ($changed & 1 != 0) {
                            if (restartGroup.getDefaultsInvalid()) {
                                if (i11 != 0) {
                                    str = defaultsInvalid;
                                }
                                if (supportingText2 != 0) {
                                    l = defaultsInvalid;
                                }
                                if (i109 != 0) {
                                    z2 = defaultsInvalid;
                                }
                                if (i95 & 32 != 0) {
                                    i11 = 6;
                                    suffix2 = 0;
                                    ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                                    $dirty &= traceInProgress2;
                                    obj8 = this_$iv;
                                }
                                if (i121 != 0) {
                                    obj12 = this_$iv;
                                }
                                placeholder2 = i46 != 0 ? 0 : placeholder;
                                leadingIcon2 = i40 != 0 ? 0 : leadingIcon;
                                trailingIcon3 = i19 != 0 ? 0 : trailingIcon;
                                prefix3 = i17 != 0 ? 0 : prefix;
                                suffix2 = i != 0 ? 0 : suffix;
                                supportingText2 = i26 != 0 ? 0 : supportingText;
                                isError2 = i41 != 0 ? 0 : isError;
                                if (i31 != 0) {
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
                                    $dirty1 &= minLines2;
                                } else {
                                    maxLines2 = maxLines;
                                }
                                minLines2 = interactionSource2 != 0 ? 1 : minLines;
                                interactionSource3 = i52 != 0 ? 0 : interactionSource;
                                obj70 = placeholder2;
                                int placeholder4 = 6;
                                if (i95 & i118 != 0) {
                                    obj71 = leadingIcon2;
                                    leadingIcon3 = TextFieldDefaults.INSTANCE.getShape(restartGroup, placeholder4);
                                    $dirty22 &= -113;
                                } else {
                                    obj71 = leadingIcon2;
                                    leadingIcon3 = shape;
                                }
                                if (i95 & i30 != 0) {
                                    obj2 = obj70;
                                    obj14 = obj71;
                                    i40 = obj72;
                                    $dirty22 = i88;
                                    obj15 = trailingIcon3;
                                    obj18 = prefix3;
                                    i52 = obj12;
                                    i30 = suffix2;
                                    i46 = supportingText2;
                                    prefix4 = isError2;
                                    rememberedValue = interactionSource3;
                                    label2 = colors4;
                                    colors3 = obj8;
                                    interactionSource2 = visualTransformation4;
                                    isError4 = keyboardOptions3;
                                    textStyle2 = str;
                                    visualTransformation2 = z2;
                                } else {
                                    obj2 = obj70;
                                    obj14 = obj71;
                                    i40 = obj72;
                                    obj15 = trailingIcon3;
                                    colors3 = obj8;
                                    obj18 = prefix3;
                                    i52 = obj12;
                                    i30 = suffix2;
                                    i46 = supportingText2;
                                    prefix4 = isError2;
                                    rememberedValue = interactionSource3;
                                    label2 = colors;
                                    textStyle2 = str;
                                    interactionSource2 = visualTransformation4;
                                    isError4 = keyboardOptions3;
                                    visualTransformation2 = z2;
                                }
                            } else {
                                restartGroup.skipToGroupEnd();
                                if (i95 & 32 != 0) {
                                    $dirty &= i62;
                                }
                                if (i77 &= i95 != 0) {
                                    $dirty1 &= i61;
                                }
                                if (i78 &= i95 != 0) {
                                    $dirty22 &= -113;
                                }
                                if (i95 & i30 != 0) {
                                    obj2 = placeholder;
                                    obj14 = leadingIcon;
                                    obj15 = trailingIcon;
                                    obj18 = prefix;
                                    i30 = suffix;
                                    i46 = supportingText;
                                    prefix4 = isError;
                                    interactionSource2 = visualTransformation;
                                    isError4 = keyboardOptions;
                                    keyboardActions3 = keyboardActions;
                                    singleLine3 = singleLine;
                                    maxLines2 = maxLines;
                                    minLines2 = minLines;
                                    rememberedValue = interactionSource;
                                    i40 = shape;
                                    $dirty22 = i81;
                                    visualTransformation2 = z2;
                                    colors3 = obj8;
                                    i52 = obj12;
                                    label2 = colors;
                                    textStyle2 = str;
                                } else {
                                    obj2 = placeholder;
                                    obj14 = leadingIcon;
                                    obj15 = trailingIcon;
                                    obj18 = prefix;
                                    i30 = suffix;
                                    i46 = supportingText;
                                    prefix4 = isError;
                                    interactionSource2 = visualTransformation;
                                    isError4 = keyboardOptions;
                                    keyboardActions3 = keyboardActions;
                                    singleLine3 = singleLine;
                                    maxLines2 = maxLines;
                                    minLines2 = minLines;
                                    rememberedValue = interactionSource;
                                    i40 = shape;
                                    visualTransformation2 = z2;
                                    colors3 = obj8;
                                    i52 = obj12;
                                    label2 = colors;
                                    textStyle2 = str;
                                }
                            }
                        } else {
                        }
                        restartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1268528240, $dirty, $dirty1, "androidx.compose.material3.TextField (TextField.kt:375)");
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
                            i24 = $i$a$CacheTextFieldKt$TextField$interactionSource$2;
                        } else {
                            i24 = obj70;
                        }
                        restartGroup.endReplaceGroup();
                        restartGroup.startReplaceGroup(-508235100);
                        ComposerKt.sourceInformation(restartGroup, "*381@20307L25");
                        focused = colors3.getColor-0d7_KjU();
                        int i101 = 0;
                        i36 = 0;
                        i34 = Long.compare(l2, i126) != 0 ? 1 : 0;
                        if (i34 != 0) {
                        } else {
                            i36 = 0;
                            obj71 = focused;
                            focused = label2.textColor-XeAY9LY$material3_release(l, prefix4, (Boolean)FocusInteractionKt.collectIsFocusedAsState((InteractionSource)i24, restartGroup, 0).getValue().booleanValue());
                        }
                        restartGroup.endReplaceGroup();
                        textStyle3 = new TextStyle(focused, i17, 0, i26, 0, 0, 0, 0, 0, 0, obj46, 0, 0, 0, 0, obj51, 0, 0, 0, 0, 0, 0, obj58, 0, 0, 0, 0, 0, 0, 16777214, 0);
                        boolean z4 = l;
                        TextFieldKt.TextField.3 anon = new TextFieldKt.TextField.3(textStyle2, prefix4, label2, obj3, obj, z4, visualTransformation2, colors3.merge(textStyle3), isError4, keyboardActions3, singleLine3, maxLines2, minLines2, interactionSource2, i24, i52, obj2, obj14, obj15, obj18, i30, i46, i40);
                        CompositionLocalKt.CompositionLocalProvider(TextSelectionColorsKt.getLocalTextSelectionColors().provides(label2.getTextSelectionColors()), (Function2)ComposableLambdaKt.rememberComposableLambda(-1163788208, true, anon, restartGroup, 54), restartGroup, $stable |= 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        str = textStyle2;
                        keyboardOptions2 = isError4;
                        i14 = maxLines2;
                        keyboardOptions4 = minLines2;
                        visualTransformation3 = interactionSource2;
                        i43 = obj2;
                        i10 = obj15;
                        i18 = obj18;
                        modifier4 = i30;
                        placeholder3 = $dirty;
                        trailingIcon2 = $dirty1;
                        prefix2 = $dirty22;
                        maxLines3 = label2;
                        $dirty3 = visualTransformation2;
                        readOnly2 = singleLine3;
                        $dirty2 = i52;
                        singleLine2 = i40;
                        $dirty12 = colors3;
                        textStyle4 = restartGroup;
                        colors2 = prefix4;
                        $composer2 = z4;
                        enabled2 = keyboardActions3;
                        isError3 = i46;
                        keyboardActions2 = obj70;
                    } else {
                        restartGroup.skipToGroupEnd();
                        i43 = placeholder;
                        obj14 = leadingIcon;
                        isError3 = supportingText;
                        visualTransformation3 = visualTransformation;
                        keyboardOptions2 = keyboardOptions;
                        enabled2 = keyboardActions;
                        readOnly2 = singleLine;
                        i14 = maxLines;
                        keyboardOptions4 = minLines;
                        keyboardActions2 = interactionSource;
                        singleLine2 = shape;
                        maxLines3 = colors;
                        textStyle4 = restartGroup;
                        placeholder3 = $dirty;
                        trailingIcon2 = $dirty1;
                        prefix2 = $dirty22;
                        $composer2 = l;
                        $dirty3 = z2;
                        $dirty12 = obj8;
                        $dirty2 = obj12;
                        i10 = trailingIcon;
                        i18 = prefix;
                        modifier4 = suffix;
                        colors2 = isError;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        endRestartGroup = textStyle4.endRestartGroup();
        if (endRestartGroup != null) {
            leadingIcon4 = composer;
            textStyle4 = new TextFieldKt.TextField.4(value, onValueChange, str, $composer2, $dirty3, $dirty12, $dirty2, i43, obj14, i10, i18, modifier4, isError3, colors2, visualTransformation3, keyboardOptions2, enabled2, readOnly2, i14, keyboardOptions4, keyboardActions2, singleLine2, maxLines3, $changed, $changed1, $changed2, i95);
            endRestartGroup.updateScope((Function2)textStyle4);
        } else {
            modifier3 = str;
            modifier2 = obj14;
            leadingIcon4 = textStyle4;
        }
    }

    public static final void TextField(String value, Function1<? super String, Unit> onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> label, Function2<? super Composer, ? super Integer, Unit> placeholder, Function2<? super Composer, ? super Integer, Unit> leadingIcon, Function2<? super Composer, ? super Integer, Unit> trailingIcon, Function2<? super Composer, ? super Integer, Unit> prefix, Function2<? super Composer, ? super Integer, Unit> suffix, Function2<? super Composer, ? super Integer, Unit> supportingText, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, int minLines, MutableInteractionSource interactionSource, Shape shape, androidx.compose.material3.TextFieldColors colors, Composer $composer, int $changed, int $changed1, int $changed2, int i28) {
        Object obj17;
        Object obj7;
        Object obj13;
        Object obj8;
        Object obj15;
        Object obj4;
        boolean z;
        Object obj20;
        Object obj18;
        Object obj12;
        boolean z3;
        int i13;
        int i4;
        Object obj2;
        Object obj11;
        Object obj10;
        int skipping;
        int i36;
        int i58;
        Object colors2;
        int defaultsInvalid;
        int this_$iv;
        int placeholder2;
        Composer textStyle2;
        int traceInProgress;
        int rememberedValue;
        long focused;
        int leadingIcon4;
        Object leadingIcon3;
        ScopeUpdateScope endRestartGroup;
        int trailingIcon3;
        boolean traceInProgress2;
        Object $i$a$CacheTextFieldKt$TextField$interactionSource$1;
        Object modifier2;
        boolean $composer2;
        int $dirty;
        boolean $dirty3;
        int $dirty12;
        Object $dirty1;
        int $dirty22;
        Object $dirty2;
        int i56;
        Object obj5;
        int i12;
        Object str;
        int modifier4;
        boolean l;
        int i42;
        boolean z2;
        int i9;
        int i15;
        Object obj3;
        Object textStyle4;
        int modifier3;
        int i29;
        int prefix4;
        int i48;
        int prefix2;
        int isError4;
        Object obj16;
        Object label2;
        int colors3;
        Object obj9;
        VisualTransformation visualTransformation4;
        int suffix2;
        KeyboardOptions keyboardOptions2;
        int i50;
        int supportingText2;
        KeyboardActions enabled2;
        int i41;
        int i57;
        boolean visualTransformation2;
        Object visualTransformation3;
        int readOnly2;
        int changed3;
        int keyboardOptions3;
        int i18;
        int i59;
        int i21;
        int changed6;
        Object isError2;
        int isError3;
        int keyboardOptions4;
        int i65;
        KeyboardActions keyboardActions2;
        int keyboardActions3;
        int i43;
        int singleLine3;
        Shape singleLine2;
        int i10;
        int maxLines2;
        androidx.compose.material3.TextFieldColors maxLines3;
        int minLines2;
        int i16;
        int i23;
        int i14;
        int changed2;
        Object interactionSource2;
        int interactionSource3;
        int i26;
        int i24;
        Object i2;
        int changed4;
        int obj;
        int placeholder3;
        int changed;
        int obj19;
        Composer leadingIcon2;
        int i11;
        int obj14;
        int trailingIcon2;
        int i64;
        int obj6;
        int prefix3;
        int i63;
        int i60;
        int i61;
        int i33;
        int i30;
        TextStyle textStyle3;
        int i38;
        int i35;
        int i7;
        int i31;
        int i62;
        int i44;
        int i49;
        int i34;
        int i55;
        boolean changed5;
        int i8;
        int i;
        int i5;
        int i20;
        int i32;
        int i54;
        int i52;
        int i45;
        int i39;
        int i46;
        int i3;
        int i51;
        int i37;
        int i47;
        int i17;
        int i25;
        int i53;
        int i40;
        int i27;
        int i6;
        int i22;
        int i19;
        ScopeUpdateScope scopeUpdateScope;
        int obj70;
        int obj71;
        Shape obj72;
        int i66 = $changed;
        int i86 = $changed1;
        trailingIcon3 = $changed2;
        int i95 = i28;
        Composer restartGroup = $composer.startRestartGroup(-676242365);
        ComposerKt.sourceInformation(restartGroup, "C(TextField)P(21,11,10,1,14,19,6,12,7,20,13,17,18,3,22,5,4,16,8,9,2,15)201@10573L7,217@11369L5,218@11424L8,230@12004L1956,230@11917L2043:TextField.kt#uh7d8r");
        $dirty = $changed;
        $dirty12 = $changed1;
        $dirty22 = $changed2;
        if (i95 & 1 != 0) {
            $dirty |= 6;
            obj9 = value;
        } else {
            if (i66 & 6 == 0) {
                i56 = restartGroup.changed(value) ? 4 : 2;
                $dirty |= i56;
            } else {
                obj9 = value;
            }
        }
        if (i95 & 2 != 0) {
            $dirty |= 48;
            obj5 = onValueChange;
        } else {
            if (i66 & 48 == 0) {
                i29 = restartGroup.changedInstance(onValueChange) ? 32 : 16;
                $dirty |= i29;
            } else {
                obj5 = onValueChange;
            }
        }
        i48 = i95 & 4;
        int i106 = 128;
        if (i48 != 0) {
            $dirty |= 384;
            str = modifier;
        } else {
            if (i66 & 384 == 0) {
                i50 = restartGroup.changed(modifier) ? 256 : i106;
                $dirty |= i50;
            } else {
                str = modifier;
            }
        }
        supportingText2 = i95 & 8;
        changed3 = 1024;
        if (supportingText2 != 0) {
            $dirty |= 3072;
            l = enabled;
        } else {
            if (i66 & 3072 == 0) {
                i65 = restartGroup.changed(enabled) ? i41 : changed3;
                $dirty |= i65;
            } else {
                l = enabled;
            }
        }
        int i109 = i95 & 16;
        i10 = 8192;
        if (i109 != 0) {
            $dirty |= 24576;
            z2 = readOnly;
        } else {
            if (i66 & 24576 == 0) {
                i16 = restartGroup.changed(readOnly) ? i43 : i10;
                $dirty |= i16;
            } else {
                z2 = readOnly;
            }
        }
        i23 = 196608;
        i24 = 65536;
        if (i66 & i23 == 0) {
            if (i95 & 32 == 0) {
                changed4 = restartGroup.changed(textStyle) ? 131072 : i24;
            } else {
                obj3 = textStyle;
            }
            $dirty |= changed4;
        } else {
            obj3 = textStyle;
        }
        int i121 = i95 & 64;
        changed = 1572864;
        if (i121 != 0) {
            $dirty |= changed;
            obj16 = label;
        } else {
            if (i66 & changed == 0) {
                i64 = restartGroup.changedInstance(label) ? 1048576 : 524288;
                $dirty |= i64;
            } else {
                obj16 = label;
            }
        }
        int i67 = i95 & 128;
        int i122 = 12582912;
        i63 = 4194304;
        if (i67 != 0) {
            $dirty |= i122;
            i60 = i67;
            obj17 = placeholder;
        } else {
            if ($changed & i122 == 0) {
                i60 = i67;
                i61 = restartGroup.changedInstance(placeholder) ? 8388608 : i63;
                $dirty |= i61;
            } else {
                i60 = i67;
                obj17 = placeholder;
            }
        }
        int i68 = i95 & 256;
        int i124 = 100663296;
        if (i68 != 0) {
            $dirty |= i124;
            i33 = i68;
            obj7 = leadingIcon;
        } else {
            if ($changed & i124 == 0) {
                i33 = i68;
                i30 = restartGroup.changedInstance(leadingIcon) ? 67108864 : 33554432;
                $dirty |= i30;
            } else {
                i33 = i68;
                obj7 = leadingIcon;
            }
        }
        int i69 = i95 & 512;
        textStyle3 = 805306368;
        if (i69 != 0) {
            $dirty |= textStyle3;
            i38 = i69;
            obj13 = trailingIcon;
        } else {
            if ($changed & textStyle3 == 0) {
                i38 = i69;
                i35 = restartGroup.changedInstance(trailingIcon) ? 536870912 : 268435456;
                $dirty |= i35;
            } else {
                i38 = i69;
                obj13 = trailingIcon;
            }
        }
        int i70 = i95 & 1024;
        if (i70 != 0) {
            $dirty12 |= 6;
            i7 = i70;
            obj8 = prefix;
        } else {
            if (i86 & 6 == 0) {
                i7 = i70;
                i31 = restartGroup.changedInstance(prefix) ? 4 : 2;
                $dirty12 |= i31;
            } else {
                i7 = i70;
                obj8 = prefix;
            }
        }
        int i71 = i95 & 2048;
        if (i71 != 0) {
            $dirty12 |= 48;
            i62 = i71;
            obj15 = suffix;
        } else {
            if (i86 & 48 == 0) {
                i62 = i71;
                i44 = restartGroup.changedInstance(suffix) ? 32 : 16;
                $dirty12 |= i44;
            } else {
                i62 = i71;
                obj15 = suffix;
            }
        }
        int i72 = i95 & 4096;
        if (i72 != 0) {
            $dirty12 |= 384;
            i49 = i72;
            obj4 = supportingText;
        } else {
            i49 = i72;
            if (i86 & 384 == 0) {
                i34 = restartGroup.changedInstance(supportingText) ? 256 : i106;
                $dirty12 |= i34;
            } else {
                obj4 = supportingText;
            }
        }
        int i74 = i95 & 8192;
        if (i74 != 0) {
            $dirty12 |= 3072;
            i55 = i74;
            z = isError;
        } else {
            i55 = i74;
            if (i86 & 3072 == 0) {
                if (restartGroup.changed(isError)) {
                } else {
                    i41 = changed3;
                }
                $dirty12 |= i41;
            } else {
                z = isError;
            }
        }
        int i75 = i95 & 16384;
        if (i75 != 0) {
            $dirty12 |= 24576;
            i57 = i75;
            obj20 = visualTransformation;
        } else {
            i57 = i75;
            if (i86 & 24576 == 0) {
                if (restartGroup.changed(visualTransformation)) {
                } else {
                    i43 = i10;
                }
                $dirty12 |= i43;
            } else {
                obj20 = visualTransformation;
            }
        }
        keyboardOptions3 = i95 & i107;
        if (keyboardOptions3 != 0) {
            $dirty12 |= i23;
            obj18 = keyboardOptions;
        } else {
            if (i86 & i23 == 0) {
                i43 = restartGroup.changed(keyboardOptions) ? 131072 : i24;
                $dirty12 |= i43;
            } else {
                obj18 = keyboardOptions;
            }
        }
        int i110 = i95 & i24;
        if (i110 != 0) {
            $dirty12 |= changed;
            obj12 = keyboardActions;
        } else {
            if (i86 & changed == 0) {
                i10 = restartGroup.changed(keyboardActions) ? 1048576 : 524288;
                $dirty12 |= i10;
            } else {
                obj12 = keyboardActions;
            }
        }
        int i112 = i95 & i111;
        if (i112 != 0) {
            $dirty12 |= i122;
            z3 = singleLine;
        } else {
            if (i86 & i122 == 0) {
                i23 = restartGroup.changed(singleLine) ? 8388608 : i63;
                $dirty12 |= i23;
            } else {
                z3 = singleLine;
            }
        }
        if (i86 & i115 == 0) {
            if (i95 & i116 == 0) {
                i14 = restartGroup.changed(maxLines) ? 67108864 : 33554432;
            } else {
                i13 = maxLines;
            }
            $dirty12 |= i14;
        } else {
            i13 = maxLines;
        }
        interactionSource2 = i95 & i117;
        if (interactionSource2 != 0) {
            $dirty12 |= textStyle3;
            i4 = minLines;
        } else {
            if (i86 & textStyle3 == 0) {
                i24 = restartGroup.changed(minLines) ? 536870912 : 268435456;
                $dirty12 |= i24;
            } else {
                i4 = minLines;
            }
        }
        i2 = i95 & i120;
        if (i2 != 0) {
            $dirty22 |= 6;
            obj2 = interactionSource;
        } else {
            if (trailingIcon3 & 6 == 0) {
                i21 = restartGroup.changed(interactionSource) ? 4 : 2;
                $dirty22 |= i21;
            } else {
                obj2 = interactionSource;
            }
        }
        if (trailingIcon3 & 48 == 0) {
            if (i95 & i108 == 0) {
                minLines2 = restartGroup.changed(shape) ? 32 : 16;
            } else {
                obj11 = shape;
            }
            $dirty22 |= minLines2;
        } else {
            obj11 = shape;
        }
        if (trailingIcon3 & 384 == 0) {
            if (i95 & i63 == 0) {
                i11 = restartGroup.changed(colors) ? 256 : i106;
            } else {
                obj10 = colors;
            }
            $dirty22 |= i11;
        } else {
            obj10 = colors;
        }
        if ($dirty & suffix2 == 306783378 && i82 &= $dirty12 == 306783378 && $dirty22 & 147 == 146) {
            if (i82 &= $dirty12 == 306783378) {
                if ($dirty22 & 147 == 146) {
                    if (!restartGroup.getSkipping()) {
                        restartGroup.startDefaults();
                        if ($changed & 1 != 0) {
                            if (restartGroup.getDefaultsInvalid()) {
                                if (i48 != 0) {
                                    str = defaultsInvalid;
                                }
                                if (supportingText2 != 0) {
                                    l = defaultsInvalid;
                                }
                                if (i109 != 0) {
                                    z2 = defaultsInvalid;
                                }
                                if (i95 & 32 != 0) {
                                    i48 = 6;
                                    suffix2 = 0;
                                    ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                                    $dirty &= traceInProgress;
                                    obj3 = this_$iv;
                                }
                                if (i121 != 0) {
                                    obj16 = this_$iv;
                                }
                                placeholder2 = i60 != 0 ? 0 : placeholder;
                                leadingIcon4 = i33 != 0 ? 0 : leadingIcon;
                                trailingIcon3 = i38 != 0 ? 0 : trailingIcon;
                                prefix2 = i7 != 0 ? 0 : prefix;
                                suffix2 = i62 != 0 ? 0 : suffix;
                                supportingText2 = i49 != 0 ? 0 : supportingText;
                                isError3 = i55 != 0 ? 0 : isError;
                                if (i57 != 0) {
                                    visualTransformation3 = VisualTransformation.Companion.getNone();
                                } else {
                                    visualTransformation3 = visualTransformation;
                                }
                                if (keyboardOptions3 != 0) {
                                    keyboardOptions3 = KeyboardOptions.Companion.getDefault();
                                } else {
                                    keyboardOptions3 = keyboardOptions;
                                }
                                if (i110 != 0) {
                                    keyboardActions2 = KeyboardActions.Companion.getDefault();
                                } else {
                                    keyboardActions2 = keyboardActions;
                                }
                                singleLine3 = i112 != 0 ? 0 : singleLine;
                                if (i95 & i113 != 0) {
                                    maxLines2 = singleLine3 != 0 ? 1 : 0x7fffffff /* Unknown resource */;
                                    $dirty12 &= minLines2;
                                } else {
                                    maxLines2 = maxLines;
                                }
                                minLines2 = interactionSource2 != 0 ? 1 : minLines;
                                interactionSource3 = i2 != 0 ? 0 : interactionSource;
                                obj70 = placeholder2;
                                int placeholder4 = 6;
                                if (i95 & i118 != 0) {
                                    obj71 = leadingIcon4;
                                    leadingIcon3 = TextFieldDefaults.INSTANCE.getShape(restartGroup, placeholder4);
                                    $dirty22 &= -113;
                                } else {
                                    obj71 = leadingIcon4;
                                    leadingIcon3 = shape;
                                }
                                if (i95 & i63 != 0) {
                                    obj = obj70;
                                    obj19 = obj71;
                                    i33 = obj72;
                                    $dirty22 = i88;
                                    obj14 = trailingIcon3;
                                    obj6 = prefix2;
                                    i2 = obj16;
                                    i63 = suffix2;
                                    i60 = supportingText2;
                                    prefix4 = isError3;
                                    rememberedValue = interactionSource3;
                                    label2 = colors4;
                                    colors2 = obj3;
                                    interactionSource2 = visualTransformation3;
                                    isError2 = keyboardOptions3;
                                    textStyle4 = str;
                                    visualTransformation2 = z2;
                                } else {
                                    obj = obj70;
                                    obj19 = obj71;
                                    i33 = obj72;
                                    obj14 = trailingIcon3;
                                    colors2 = obj3;
                                    obj6 = prefix2;
                                    i2 = obj16;
                                    i63 = suffix2;
                                    i60 = supportingText2;
                                    prefix4 = isError3;
                                    rememberedValue = interactionSource3;
                                    label2 = colors;
                                    textStyle4 = str;
                                    interactionSource2 = visualTransformation3;
                                    isError2 = keyboardOptions3;
                                    visualTransformation2 = z2;
                                }
                            } else {
                                restartGroup.skipToGroupEnd();
                                if (i95 & 32 != 0) {
                                    $dirty &= i36;
                                }
                                if (i77 &= i95 != 0) {
                                    $dirty12 &= i58;
                                }
                                if (i78 &= i95 != 0) {
                                    $dirty22 &= -113;
                                }
                                if (i95 & i63 != 0) {
                                    obj = placeholder;
                                    obj19 = leadingIcon;
                                    obj14 = trailingIcon;
                                    obj6 = prefix;
                                    i63 = suffix;
                                    i60 = supportingText;
                                    prefix4 = isError;
                                    interactionSource2 = visualTransformation;
                                    isError2 = keyboardOptions;
                                    keyboardActions2 = keyboardActions;
                                    singleLine3 = singleLine;
                                    maxLines2 = maxLines;
                                    minLines2 = minLines;
                                    rememberedValue = interactionSource;
                                    i33 = shape;
                                    $dirty22 = i81;
                                    visualTransformation2 = z2;
                                    colors2 = obj3;
                                    i2 = obj16;
                                    label2 = colors;
                                    textStyle4 = str;
                                } else {
                                    obj = placeholder;
                                    obj19 = leadingIcon;
                                    obj14 = trailingIcon;
                                    obj6 = prefix;
                                    i63 = suffix;
                                    i60 = supportingText;
                                    prefix4 = isError;
                                    interactionSource2 = visualTransformation;
                                    isError2 = keyboardOptions;
                                    keyboardActions2 = keyboardActions;
                                    singleLine3 = singleLine;
                                    maxLines2 = maxLines;
                                    minLines2 = minLines;
                                    rememberedValue = interactionSource;
                                    i33 = shape;
                                    visualTransformation2 = z2;
                                    colors2 = obj3;
                                    i2 = obj16;
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
                                $i$a$CacheTextFieldKt$TextField$interactionSource$1 = rememberedValue;
                            }
                            ComposerKt.sourceInformationMarkerEnd(restartGroup);
                            i26 = $i$a$CacheTextFieldKt$TextField$interactionSource$1;
                        } else {
                            i26 = obj70;
                        }
                        restartGroup.endReplaceGroup();
                        restartGroup.startReplaceGroup(-508509180);
                        ComposerKt.sourceInformation(restartGroup, "*225@11742L25");
                        focused = colors2.getColor-0d7_KjU();
                        int i101 = 0;
                        i9 = 0;
                        i18 = Long.compare(l2, i126) != 0 ? 1 : 0;
                        if (i18 != 0) {
                        } else {
                            i9 = 0;
                            obj71 = focused;
                            focused = label2.textColor-XeAY9LY$material3_release(l, prefix4, (Boolean)FocusInteractionKt.collectIsFocusedAsState((InteractionSource)i26, restartGroup, 0).getValue().booleanValue());
                        }
                        restartGroup.endReplaceGroup();
                        textStyle3 = new TextStyle(focused, i7, 0, i49, 0, 0, 0, 0, 0, 0, obj46, 0, 0, 0, 0, obj51, 0, 0, 0, 0, 0, 0, obj58, 0, 0, 0, 0, 0, 0, 16777214, 0);
                        boolean z4 = l;
                        TextFieldKt.TextField.1 anon = new TextFieldKt.TextField.1(textStyle4, prefix4, label2, obj9, obj5, z4, visualTransformation2, colors2.merge(textStyle3), isError2, keyboardActions2, singleLine3, maxLines2, minLines2, interactionSource2, i26, i2, obj, obj19, obj14, obj6, i63, i60, i33);
                        CompositionLocalKt.CompositionLocalProvider(TextSelectionColorsKt.getLocalTextSelectionColors().provides(label2.getTextSelectionColors()), (Function2)ComposableLambdaKt.rememberComposableLambda(1859145987, true, anon, restartGroup, 54), restartGroup, $stable |= 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        str = textStyle4;
                        keyboardOptions2 = isError2;
                        i59 = maxLines2;
                        keyboardOptions4 = minLines2;
                        visualTransformation4 = interactionSource2;
                        i12 = obj;
                        i42 = obj14;
                        i15 = obj6;
                        modifier3 = i63;
                        placeholder3 = $dirty;
                        trailingIcon2 = $dirty12;
                        prefix3 = $dirty22;
                        maxLines3 = label2;
                        $dirty3 = visualTransformation2;
                        readOnly2 = singleLine3;
                        $dirty2 = i2;
                        singleLine2 = i33;
                        $dirty1 = colors2;
                        textStyle2 = restartGroup;
                        colors3 = prefix4;
                        $composer2 = z4;
                        enabled2 = keyboardActions2;
                        isError4 = i60;
                        keyboardActions3 = obj70;
                    } else {
                        restartGroup.skipToGroupEnd();
                        i12 = placeholder;
                        obj19 = leadingIcon;
                        isError4 = supportingText;
                        visualTransformation4 = visualTransformation;
                        keyboardOptions2 = keyboardOptions;
                        enabled2 = keyboardActions;
                        readOnly2 = singleLine;
                        i59 = maxLines;
                        keyboardOptions4 = minLines;
                        keyboardActions3 = interactionSource;
                        singleLine2 = shape;
                        maxLines3 = colors;
                        textStyle2 = restartGroup;
                        placeholder3 = $dirty;
                        trailingIcon2 = $dirty12;
                        prefix3 = $dirty22;
                        $composer2 = l;
                        $dirty3 = z2;
                        $dirty1 = obj3;
                        $dirty2 = obj16;
                        i42 = trailingIcon;
                        i15 = prefix;
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
            textStyle2 = new TextFieldKt.TextField.2(value, onValueChange, str, $composer2, $dirty3, $dirty1, $dirty2, i12, obj19, i42, i15, modifier3, isError4, colors3, visualTransformation4, keyboardOptions2, enabled2, readOnly2, i59, keyboardOptions4, keyboardActions3, singleLine2, maxLines3, $changed, $changed1, $changed2, i95);
            endRestartGroup.updateScope((Function2)textStyle2);
        } else {
            modifier2 = str;
            modifier4 = obj19;
            leadingIcon2 = textStyle2;
        }
    }

    public static final void TextFieldLayout(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> textField, Function2<? super Composer, ? super Integer, Unit> label, Function3<? super Modifier, ? super Composer, ? super Integer, Unit> placeholder, Function2<? super Composer, ? super Integer, Unit> leading, Function2<? super Composer, ? super Integer, Unit> trailing, Function2<? super Composer, ? super Integer, Unit> prefix, Function2<? super Composer, ? super Integer, Unit> suffix, boolean singleLine, float animationProgress, Function2<? super Composer, ? super Integer, Unit> container, Function2<? super Composer, ? super Integer, Unit> supporting, PaddingValues paddingValues, Composer $composer, int $changed, int $changed1) {
        int i11;
        int i;
        int i28;
        int i23;
        int i18;
        int i6;
        int i19;
        boolean traceInProgress;
        Object endRestartGroup;
        int i12;
        Object it$iv;
        Object valueOf9;
        Object valueOf2;
        Object valueOf7;
        Modifier heightIn-VpY3zN4$default;
        Integer maybeCachedBoxMeasurePolicy6;
        Object valueOf;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv7;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv4;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv5;
        Object obj5;
        kotlin.jvm.functions.Function0 factory$iv$iv;
        Composer $changed$iv;
        boolean traceInProgress2;
        int i26;
        int i10;
        Integer currentCompositionLocalMap5;
        int valueOf8;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv3;
        Object valueOf5;
        String $composer$iv;
        Object obj4;
        Composer composer7;
        Composer composer8;
        Object currentCompositionLocalMap6;
        Integer currentCompositionLocalMap3;
        Integer currentCompositionLocalMap7;
        Integer maybeCachedBoxMeasurePolicy2;
        Integer maybeCachedBoxMeasurePolicy7;
        Object obj;
        int $composer$iv2;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap8;
        Composer materialized$iv$iv2;
        int i14;
        Object then;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv2;
        Composer composer2;
        Object currentCompositionLocalMap4;
        int materializeModifier;
        int constructor-impl2;
        int iNSTANCE2;
        Object obj3;
        Composer composer11;
        int valueOf3;
        Composer composer5;
        androidx.compose.ui.layout.MeasurePolicy maybeCachedBoxMeasurePolicy4;
        Object materialized$iv$iv;
        float $this$coerceAtLeast_u2dYgX7TsA$iv;
        BoxScopeInstance maybeCachedBoxMeasurePolicy3;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv6;
        float $this$dp$iv;
        int maybeCachedBoxMeasurePolicy5;
        int iNSTANCE;
        int valueOf6;
        Composer composer12;
        Composer composer10;
        Object currentCompositionLocalMap;
        int topStart;
        int $i$f$cache;
        Integer currentCompositionLocalMap2;
        int maybeCachedBoxMeasurePolicy;
        Object restartGroup;
        Composer composer4;
        int valueOf4;
        Object obj2;
        int $dirty12;
        Modifier modifier4;
        int $dirty1;
        int i30;
        int $dirty2;
        int $dirty;
        int i24;
        int i17;
        int i2;
        int i32;
        androidx.compose.material3.TextFieldMeasurePolicy field;
        int companion;
        int currentCompositeKeyHash2;
        int $i$f$cache2;
        int i15;
        int i25;
        kotlin.jvm.functions.Function0 function0;
        int i20;
        int i16;
        Composer composer;
        int i5;
        Composer composer9;
        Modifier modifier3;
        int i21;
        androidx.compose.runtime.CompositionLocalMap localMap$iv;
        Modifier modifier2;
        int i9;
        Object layoutDirection;
        int i33;
        int i22;
        int $i$a$LayoutTextFieldKt$TextFieldLayout$1;
        kotlin.jvm.functions.Function0 currentCompositeKeyHash5;
        float f4;
        Modifier currentCompositeKeyHash;
        float endPadding;
        float currentCompositeKeyHash4;
        Composer currentCompositeKeyHash3;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv;
        float f3;
        int i27;
        int i31;
        kotlin.jvm.functions.Function0 f;
        float constructor-impl;
        int i29;
        int i13;
        int i8;
        int localMap$iv$iv2;
        float f2;
        float measurePolicy$iv2;
        Composer composer6;
        int i3;
        int i7;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy$iv;
        androidx.compose.runtime.CompositionLocalMap map;
        Composer composer3;
        int i4;
        ScopeUpdateScope scopeUpdateScope;
        Alignment obj74;
        Object obj6 = modifier;
        $composer$iv2 = leading;
        materializeModifier = trailing;
        iNSTANCE2 = prefix;
        final Object obj8 = suffix;
        maybeCachedBoxMeasurePolicy4 = singleLine;
        $this$dp$iv = animationProgress;
        iNSTANCE = container;
        int i177 = $changed;
        int i179 = $changed1;
        restartGroup = $composer.startRestartGroup(-1830307184);
        ComposerKt.sourceInformation(restartGroup, "C(TextFieldLayout)P(4,11,2,6,3,12,7,9,8!2,10)455@23228L147,458@23423L7,459@23435L4118:TextField.kt#uh7d8r");
        obj74 = i35;
        if (i177 & 6 == 0) {
            i17 = restartGroup.changed(obj6) ? 4 : 2;
            $dirty2 = obj74 | i17;
        } else {
            $dirty2 = obj74;
        }
        if (i177 & 48 == 0) {
            i2 = restartGroup.changedInstance(textField) ? 32 : 16;
            $dirty2 |= i2;
        }
        if (i177 & 384 == 0) {
            i32 = restartGroup.changedInstance(label) ? 256 : 128;
            $dirty2 |= i32;
        }
        if (i177 & 3072 == 0) {
            i11 = restartGroup.changedInstance(placeholder) ? 2048 : 1024;
            $dirty2 |= i11;
        }
        if (i177 & 24576 == 0) {
            i = restartGroup.changedInstance($composer$iv2) ? 16384 : 8192;
            $dirty2 |= i;
        }
        if (i37 &= i177 == 0) {
            i28 = restartGroup.changedInstance(materializeModifier) ? 131072 : 65536;
            $dirty2 |= i28;
        }
        if (i38 &= i177 == 0) {
            i23 = restartGroup.changedInstance(iNSTANCE2) ? 1048576 : 524288;
            $dirty2 |= i23;
        }
        if (i39 &= i177 == 0) {
            i18 = restartGroup.changedInstance(obj8) ? 8388608 : 4194304;
            $dirty2 |= i18;
        }
        if (i40 &= i177 == 0) {
            i6 = restartGroup.changed(maybeCachedBoxMeasurePolicy4) ? 67108864 : 33554432;
            $dirty2 |= i6;
        }
        if (i41 &= i177 == 0) {
            i19 = restartGroup.changed($this$dp$iv) ? 536870912 : 268435456;
            $dirty2 |= i19;
        }
        traceInProgress = $dirty2;
        if (i179 & 6 == 0) {
            $dirty = restartGroup.changedInstance(iNSTANCE) ? 4 : 2;
            $dirty1 |= $dirty;
        }
        if (i179 & 48 == 0) {
            i24 = restartGroup.changedInstance(supporting) ? 32 : 16;
            $dirty1 |= i24;
        }
        if (i179 & 384 == 0) {
            i24 = restartGroup.changed(paddingValues) ? 256 : 128;
            $dirty1 |= i24;
        } else {
            obj2 = paddingValues;
        }
        $dirty12 = $dirty1;
        if (traceInProgress & $dirty13 == 306783378 && $dirty12 & 147 == 146) {
            if ($dirty12 & 147 == 146) {
                if (!restartGroup.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1830307184, traceInProgress, $dirty12, "androidx.compose.material3.TextFieldLayout (TextField.kt:453)");
                    }
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1052646361, "CC(remember):TextField.kt#9igjgp");
                    int i183 = 1;
                    i30 = traceInProgress;
                    i26 = i86 &= traceInProgress == 67108864 ? i183 : 0;
                    i12 = i30 & i161 == 536870912 ? i183 : 0;
                    i10 = $dirty12 & 896 == 256 ? i183 : 0;
                    Composer composer13 = restartGroup;
                    $i$f$cache = 0;
                    it$iv = composer13.rememberedValue();
                    int i188 = 0;
                    if (i43 |= i10 == 0) {
                        $i$f$cache2 = $i$f$cache;
                        if (it$iv == Composer.Companion.getEmpty()) {
                            $i$f$cache = 0;
                            companion = it$iv;
                            it$iv = new TextFieldMeasurePolicy(maybeCachedBoxMeasurePolicy4, $this$dp$iv, obj2);
                            composer13.updateRememberedValue(it$iv);
                        } else {
                            companion = it$iv;
                        }
                    } else {
                        $i$f$cache2 = $i$f$cache;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    int i164 = 0;
                    int i187 = 0;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    valueOf9 = restartGroup.consume((CompositionLocal)CompositionLocalsKt.getLocalLayoutDirection());
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    $changed$iv = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, $changed$iv);
                    currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, 0);
                    currentCompositionLocalMap2 = restartGroup.getCurrentCompositionLocalMap();
                    i15 = i136;
                    materialized$iv$iv = ComposedModifierKt.materializeModifier(restartGroup, obj6);
                    kotlin.jvm.functions.Function0 function02 = constructor2;
                    i25 = 0;
                    i16 = $dirty12;
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
                    composer9 = restartGroup;
                    Updater.set-impl(constructor-impl6, (MeasurePolicy)(TextFieldMeasurePolicy)it$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl6, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    valueOf4 = 0;
                    Composer composer20 = constructor-impl6;
                    i21 = 0;
                    if (!composer20.getInserting()) {
                        localMap$iv = currentCompositionLocalMap2;
                        i9 = valueOf4;
                        if (!Intrinsics.areEqual(composer20.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                            composer20.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                            constructor-impl6.apply(Integer.valueOf(currentCompositeKeyHash2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer4 = composer20;
                        }
                    } else {
                        localMap$iv = currentCompositionLocalMap2;
                        i9 = valueOf4;
                    }
                    Updater.set-impl(constructor-impl6, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                    obj = composer9;
                    maybeCachedBoxMeasurePolicy = 0;
                    i5 = i81;
                    ComposerKt.sourceInformationMarkerStart(obj, -1362557328, "C465@23754L11,550@26868L187:TextField.kt#uh7d8r");
                    iNSTANCE.invoke(obj, Integer.valueOf(i16 & 14));
                    obj.startReplaceGroup(1341517187);
                    ComposerKt.sourceInformation(obj, "468@23818L219");
                    restartGroup = "C73@3429L9:Box.kt#2w3rfo";
                    modifier3 = 48;
                    String str3 = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo";
                    modifier2 = materialized$iv$iv;
                    if ($composer$iv2 != null) {
                        Modifier then4 = LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Leading").then(TextFieldImplKt.getIconDefaultSizeModifier());
                        Alignment center2 = Alignment.Companion.getCenter();
                        layoutDirection = modifier3;
                        i22 = 0;
                        $i$a$LayoutTextFieldKt$TextFieldLayout$1 = maybeCachedBoxMeasurePolicy;
                        ComposerKt.sourceInformationMarkerStart(obj, 733328855, str3);
                        int i175 = 0;
                        maybeCachedBoxMeasurePolicy7 = BoxKt.maybeCachedBoxMeasurePolicy(center2, i175);
                        f4 = 0;
                        currentCompositeKeyHash = center2;
                        ComposerKt.sourceInformationMarkerStart(obj, -1323940314, $changed$iv);
                        endPadding = ComposablesKt.getCurrentCompositeKeyHash(obj, 0);
                        currentCompositionLocalMap = obj.getCurrentCompositionLocalMap();
                        currentCompositeKeyHash3 = i175;
                        i27 = then4;
                        kotlin.jvm.functions.Function0 function08 = constructor7;
                        localMap$iv$iv = 0;
                        ComposerKt.sourceInformationMarkerStart(obj, -692256719, $dirty12);
                        if (!applier8 instanceof Applier) {
                            ComposablesKt.invalidApplier();
                        }
                        obj.startReusableNode();
                        if (obj.getInserting()) {
                            obj.createNode(function08);
                        } else {
                            factory$iv$iv$iv6 = function08;
                            obj.useNode();
                        }
                        i31 = factory$iv$iv$iv6;
                        Composer constructor-impl9 = Updater.constructor-impl(obj);
                        int i225 = 0;
                        Updater.set-impl(constructor-impl9, maybeCachedBoxMeasurePolicy7, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(constructor-impl9, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        int i237 = 0;
                        Composer composer23 = constructor-impl9;
                        int i238 = 0;
                        if (!composer23.getInserting()) {
                            measurePolicy$iv2 = maybeCachedBoxMeasurePolicy7;
                            composer6 = currentCompositionLocalMap;
                            if (!Intrinsics.areEqual(composer23.rememberedValue(), Integer.valueOf(endPadding))) {
                                composer23.updateRememberedValue(Integer.valueOf(endPadding));
                                constructor-impl9.apply(Integer.valueOf(endPadding), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            } else {
                                composer10 = composer23;
                            }
                        } else {
                            measurePolicy$iv2 = maybeCachedBoxMeasurePolicy7;
                            composer6 = currentCompositionLocalMap;
                        }
                        Updater.set-impl(constructor-impl9, ComposedModifierKt.materializeModifier(obj, then4), ComposeUiNode.Companion.getSetModifier());
                        Composer composer19 = obj;
                        ComposerKt.sourceInformationMarkerStart(composer19, -2146769399, restartGroup);
                        iNSTANCE = BoxScopeInstance.INSTANCE;
                        i227 |= 6;
                        localMap$iv$iv2 = 0;
                        f2 = i107;
                        i7 = i149;
                        $this$dp$iv = i8;
                        ComposerKt.sourceInformationMarkerStart($this$dp$iv, -948431736, "C472@24010L9:TextField.kt#uh7d8r");
                        $composer$iv2.invoke($this$dp$iv, Integer.valueOf(i108 &= 14));
                        ComposerKt.sourceInformationMarkerEnd($this$dp$iv);
                        ComposerKt.sourceInformationMarkerEnd(composer19);
                        obj.endNode();
                        ComposerKt.sourceInformationMarkerEnd(obj);
                        ComposerKt.sourceInformationMarkerEnd(obj);
                        ComposerKt.sourceInformationMarkerEnd(obj);
                    } else {
                        $i$a$LayoutTextFieldKt$TextFieldLayout$1 = maybeCachedBoxMeasurePolicy;
                    }
                    obj.endReplaceGroup();
                    obj.startReplaceGroup(1341526310);
                    ComposerKt.sourceInformation(obj, "476@24104L221");
                    Modifier then2 = LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Trailing").then(TextFieldImplKt.getIconDefaultSizeModifier());
                    Alignment center = Alignment.Companion.getCenter();
                    ComposerKt.sourceInformationMarkerStart(obj, 733328855, str3);
                    valueOf6 = 0;
                    i22 = 0;
                    ComposerKt.sourceInformationMarkerStart(obj, -1323940314, $changed$iv);
                    currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(obj, 0);
                    currentCompositionLocalMap8 = obj.getCurrentCompositionLocalMap();
                    f4 = center;
                    Modifier materializeModifier5 = ComposedModifierKt.materializeModifier(obj, then2);
                    endPadding = then2;
                    kotlin.jvm.functions.Function0 function04 = constructor3;
                    currentCompositeKeyHash = 0;
                    ComposerKt.sourceInformationMarkerStart(obj, -692256719, $dirty12);
                    if (materializeModifier != null && !applier6 instanceof Applier) {
                        then2 = LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Trailing").then(TextFieldImplKt.getIconDefaultSizeModifier());
                        center = Alignment.Companion.getCenter();
                        ComposerKt.sourceInformationMarkerStart(obj, 733328855, str3);
                        valueOf6 = 0;
                        i22 = 0;
                        ComposerKt.sourceInformationMarkerStart(obj, -1323940314, $changed$iv);
                        currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(obj, 0);
                        currentCompositionLocalMap8 = obj.getCurrentCompositionLocalMap();
                        f4 = center;
                        materializeModifier5 = ComposedModifierKt.materializeModifier(obj, then2);
                        endPadding = then2;
                        function04 = constructor3;
                        currentCompositeKeyHash = 0;
                        ComposerKt.sourceInformationMarkerStart(obj, -692256719, $dirty12);
                        if (!applier6 instanceof Applier) {
                            ComposablesKt.invalidApplier();
                        }
                        obj.startReusableNode();
                        if (obj.getInserting()) {
                            obj.createNode(function04);
                        } else {
                            factory$iv$iv$iv3 = function04;
                            obj.useNode();
                        }
                        currentCompositeKeyHash3 = factory$iv$iv$iv3;
                        Composer constructor-impl7 = Updater.constructor-impl(obj);
                        int i204 = 0;
                        i29 = i146;
                        Updater.set-impl(constructor-impl7, BoxKt.maybeCachedBoxMeasurePolicy(center, valueOf6), ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(constructor-impl7, currentCompositionLocalMap8, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        int i211 = 0;
                        Composer composer22 = constructor-impl7;
                        int i228 = 0;
                        if (!composer22.getInserting()) {
                            localMap$iv$iv2 = currentCompositionLocalMap8;
                            f2 = valueOf6;
                            if (!Intrinsics.areEqual(composer22.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                                composer22.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
                                constructor-impl7.apply(Integer.valueOf(currentCompositeKeyHash5), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            } else {
                                composer12 = composer22;
                            }
                        } else {
                            localMap$iv$iv2 = currentCompositionLocalMap8;
                            f2 = valueOf6;
                        }
                        Updater.set-impl(constructor-impl7, materializeModifier5, ComposeUiNode.Companion.getSetModifier());
                        Composer composer18 = obj;
                        $this$dp$iv = 0;
                        ComposerKt.sourceInformationMarkerStart(composer18, -2146769399, restartGroup);
                        iNSTANCE = BoxScopeInstance.INSTANCE;
                        i206 |= 6;
                        i13 = 0;
                        i8 = i95;
                        composer6 = materializeModifier5;
                        materialized$iv$iv = i31;
                        ComposerKt.sourceInformationMarkerStart(materialized$iv$iv, -948147001, "C480@24297L10:TextField.kt#uh7d8r");
                        materializeModifier.invoke(materialized$iv$iv, Integer.valueOf(i96 &= 14));
                        ComposerKt.sourceInformationMarkerEnd(materialized$iv$iv);
                        ComposerKt.sourceInformationMarkerEnd(composer18);
                        obj.endNode();
                        ComposerKt.sourceInformationMarkerEnd(obj);
                        ComposerKt.sourceInformationMarkerEnd(obj);
                        ComposerKt.sourceInformationMarkerEnd(obj);
                    }
                    obj.endReplaceGroup();
                    $composer$iv = PaddingKt.calculateStartPadding(obj2, (LayoutDirection)valueOf9);
                    materialized$iv$iv2 = PaddingKt.calculateEndPadding(obj2, valueOf9);
                    if (leading != null) {
                        int i148 = 0;
                        int i157 = 0;
                        iNSTANCE = 0;
                        $this$coerceAtLeast_u2dYgX7TsA$iv = Dp.constructor-impl(RangesKt.coerceAtLeast(Dp.constructor-impl($composer$iv - horizontalIconPadding2), Dp.constructor-impl((float)$i$f$minus5rwHm242)));
                    } else {
                        $this$coerceAtLeast_u2dYgX7TsA$iv = $composer$iv;
                    }
                    f4 = $this$coerceAtLeast_u2dYgX7TsA$iv;
                    if (materializeModifier != null) {
                        int i147 = 0;
                        int i155 = 0;
                        iNSTANCE = 0;
                        currentCompositeKeyHash4 = $this$coerceAtLeast_u2dYgX7TsA$iv;
                    } else {
                        currentCompositeKeyHash4 = materialized$iv$iv2;
                    }
                    f = currentCompositeKeyHash4;
                    obj.startReplaceGroup(1341556924);
                    ComposerKt.sourceInformation(obj, "501@25056L309");
                    maybeCachedBoxMeasurePolicy5 = 0;
                    if (iNSTANCE2 != null) {
                        layoutDirection = valueOf9;
                        int i174 = 0;
                        Modifier padding-qDBjuR0$default4 = PaddingKt.padding-qDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.heightIn-VpY3zN4$default(LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Prefix"), TextFieldImplKt.getMinTextLineHeight(), 0, 2, maybeCachedBoxMeasurePolicy5), maybeCachedBoxMeasurePolicy5, i174, 3, maybeCachedBoxMeasurePolicy5), f4, 0, TextFieldImplKt.getPrefixSuffixTextPadding(), 0, 10, 0);
                        iNSTANCE = i174;
                        maybeCachedBoxMeasurePolicy = 0;
                        ComposerKt.sourceInformationMarkerStart(obj, 733328855, str3);
                        Alignment topStart5 = Alignment.Companion.getTopStart();
                        f2 = $composer$iv;
                        maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(topStart5, false);
                        currentCompositeKeyHash = 0;
                        measurePolicy$iv2 = materialized$iv$iv2;
                        ComposerKt.sourceInformationMarkerStart(obj, -1323940314, $changed$iv);
                        currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(obj, 0);
                        currentCompositionLocalMap4 = obj.getCurrentCompositionLocalMap();
                        localMap$iv$iv = padding-qDBjuR0$default4;
                        kotlin.jvm.functions.Function0 function05 = constructor4;
                        currentCompositeKeyHash3 = 0;
                        ComposerKt.sourceInformationMarkerStart(obj, -692256719, $dirty12);
                        if (!applier4 instanceof Applier) {
                            ComposablesKt.invalidApplier();
                        }
                        obj.startReusableNode();
                        if (obj.getInserting()) {
                            obj.createNode(function05);
                        } else {
                            factory$iv$iv$iv5 = function05;
                            obj.useNode();
                        }
                        i27 = factory$iv$iv$iv5;
                        Composer constructor-impl5 = Updater.constructor-impl(obj);
                        int i222 = 0;
                        composer6 = topStart5;
                        Updater.set-impl(constructor-impl5, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(constructor-impl5, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        int i236 = 0;
                        Composer composer27 = constructor-impl5;
                        int i243 = 0;
                        if (!composer27.getInserting()) {
                            measurePolicy$iv = maybeCachedBoxMeasurePolicy2;
                            map = currentCompositionLocalMap4;
                            if (!Intrinsics.areEqual(composer27.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                                composer27.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                                constructor-impl5.apply(Integer.valueOf(currentCompositeKeyHash4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            } else {
                                composer2 = composer27;
                            }
                        } else {
                            measurePolicy$iv = maybeCachedBoxMeasurePolicy2;
                            map = currentCompositionLocalMap4;
                        }
                        Updater.set-impl(constructor-impl5, ComposedModifierKt.materializeModifier(obj, padding-qDBjuR0$default4), ComposeUiNode.Companion.getSetModifier());
                        Composer composer17 = obj;
                        ComposerKt.sourceInformationMarkerStart(composer17, -2146769399, restartGroup);
                        maybeCachedBoxMeasurePolicy3 = BoxScopeInstance.INSTANCE;
                        i224 |= 6;
                        i3 = 0;
                        i7 = i74;
                        i4 = i124;
                        materialized$iv$iv2 = i8;
                        ComposerKt.sourceInformationMarkerStart(materialized$iv$iv2, -947113399, "C507@25339L8:TextField.kt#uh7d8r");
                        iNSTANCE2.invoke(materialized$iv$iv2, Integer.valueOf(i75 &= 14));
                        ComposerKt.sourceInformationMarkerEnd(materialized$iv$iv2);
                        ComposerKt.sourceInformationMarkerEnd(composer17);
                        obj.endNode();
                        ComposerKt.sourceInformationMarkerEnd(obj);
                        ComposerKt.sourceInformationMarkerEnd(obj);
                        ComposerKt.sourceInformationMarkerEnd(obj);
                    } else {
                        layoutDirection = valueOf9;
                        f2 = $composer$iv;
                        measurePolicy$iv2 = materialized$iv$iv2;
                    }
                    obj.endReplaceGroup();
                    obj.startReplaceGroup(1341568890);
                    ComposerKt.sourceInformation(obj, "511@25430L307");
                    if (obj8 != null) {
                        int i141 = 0;
                        int i121 = 0;
                        Modifier padding-qDBjuR0$default3 = PaddingKt.padding-qDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.heightIn-VpY3zN4$default(LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Suffix"), TextFieldImplKt.getMinTextLineHeight(), 0, 2, i141), i141, i121, 3, i141), TextFieldImplKt.getPrefixSuffixTextPadding(), 0, f, 0, 10, 0);
                        endPadding = f;
                        int i104 = i121;
                        ComposerKt.sourceInformationMarkerStart(obj, 733328855, str3);
                        Alignment topStart4 = Alignment.Companion.getTopStart();
                        maybeCachedBoxMeasurePolicy = 0;
                        ComposerKt.sourceInformationMarkerStart(obj, -1323940314, $changed$iv);
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(obj, 0);
                        currentCompositionLocalMap7 = obj.getCurrentCompositionLocalMap();
                        currentCompositeKeyHash3 = i122;
                        Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(obj, padding-qDBjuR0$default3);
                        i27 = padding-qDBjuR0$default3;
                        kotlin.jvm.functions.Function0 function07 = constructor6;
                        localMap$iv$iv = 0;
                        ComposerKt.sourceInformationMarkerStart(obj, -692256719, $dirty12);
                        if (!applier3 instanceof Applier) {
                            ComposablesKt.invalidApplier();
                        }
                        obj.startReusableNode();
                        if (obj.getInserting()) {
                            obj.createNode(function07);
                        } else {
                            factory$iv$iv$iv4 = function07;
                            obj.useNode();
                        }
                        f = factory$iv$iv$iv4;
                        Composer constructor-impl4 = Updater.constructor-impl(obj);
                        int i219 = 0;
                        composer6 = topStart4;
                        Updater.set-impl(constructor-impl4, BoxKt.maybeCachedBoxMeasurePolicy(topStart4, false), ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(constructor-impl4, currentCompositionLocalMap7, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        int i235 = 0;
                        Composer composer26 = constructor-impl4;
                        int i242 = 0;
                        if (!composer26.getInserting()) {
                            measurePolicy$iv = currentCompositionLocalMap7;
                            if (!Intrinsics.areEqual(composer26.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                composer26.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                constructor-impl4.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            } else {
                                composer5 = composer26;
                            }
                        } else {
                            measurePolicy$iv = currentCompositionLocalMap7;
                        }
                        Updater.set-impl(constructor-impl4, materializeModifier4, ComposeUiNode.Companion.getSetModifier());
                        Composer composer16 = obj;
                        materializeModifier = 0;
                        ComposerKt.sourceInformationMarkerStart(composer16, -2146769399, restartGroup);
                        iNSTANCE2 = BoxScopeInstance.INSTANCE;
                        i221 |= 6;
                        i3 = 0;
                        i7 = i67;
                        composer3 = materializeModifier4;
                        materialized$iv$iv2 = i8;
                        ComposerKt.sourceInformationMarkerStart(materialized$iv$iv2, -946744375, "C517@25711L8:TextField.kt#uh7d8r");
                        obj8.invoke(materialized$iv$iv2, Integer.valueOf(i68 &= 14));
                        ComposerKt.sourceInformationMarkerEnd(materialized$iv$iv2);
                        ComposerKt.sourceInformationMarkerEnd(composer16);
                        obj.endNode();
                        ComposerKt.sourceInformationMarkerEnd(obj);
                        ComposerKt.sourceInformationMarkerEnd(obj);
                        ComposerKt.sourceInformationMarkerEnd(obj);
                    } else {
                        endPadding = f;
                    }
                    obj.endReplaceGroup();
                    obj.startReplaceGroup(1341581092);
                    ComposerKt.sourceInformation(obj, "522@25802L574");
                    if (label != null) {
                        int i140 = 0;
                        int i118 = 0;
                        Modifier padding-qDBjuR0$default2 = PaddingKt.padding-qDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.heightIn-VpY3zN4$default(LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Label"), DpKt.lerp-Md-fbLM(TextFieldImplKt.getMinTextLineHeight(), TextFieldImplKt.getMinFocusedLabelLineHeight(), animationProgress), 0, 2, i140), i140, i118, 3, i140), f4, 0, endPadding, 0, 10, 0);
                        int i101 = i118;
                        ComposerKt.sourceInformationMarkerStart(obj, 733328855, str3);
                        Alignment topStart3 = Alignment.Companion.getTopStart();
                        valueOf3 = 0;
                        maybeCachedBoxMeasurePolicy = 0;
                        ComposerKt.sourceInformationMarkerStart(obj, -1323940314, $changed$iv);
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(obj, 0);
                        currentCompositionLocalMap3 = obj.getCurrentCompositionLocalMap();
                        currentCompositeKeyHash3 = i119;
                        Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(obj, padding-qDBjuR0$default2);
                        i27 = padding-qDBjuR0$default2;
                        kotlin.jvm.functions.Function0 function06 = constructor5;
                        localMap$iv$iv = 0;
                        ComposerKt.sourceInformationMarkerStart(obj, -692256719, $dirty12);
                        if (!applier2 instanceof Applier) {
                            ComposablesKt.invalidApplier();
                        }
                        obj.startReusableNode();
                        if (obj.getInserting()) {
                            obj.createNode(function06);
                        } else {
                            factory$iv$iv$iv = function06;
                            obj.useNode();
                        }
                        f = factory$iv$iv$iv;
                        Composer constructor-impl3 = Updater.constructor-impl(obj);
                        int i215 = 0;
                        composer6 = topStart3;
                        Updater.set-impl(constructor-impl3, BoxKt.maybeCachedBoxMeasurePolicy(topStart3, valueOf3), ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(constructor-impl3, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        int i233 = 0;
                        Composer composer25 = constructor-impl3;
                        int i241 = 0;
                        if (!composer25.getInserting()) {
                            measurePolicy$iv = currentCompositionLocalMap3;
                            map = valueOf3;
                            if (!Intrinsics.areEqual(composer25.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                composer25.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                constructor-impl3.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            } else {
                                composer11 = composer25;
                            }
                        } else {
                            measurePolicy$iv = currentCompositionLocalMap3;
                            map = valueOf3;
                        }
                        Updater.set-impl(constructor-impl3, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                        Composer composer15 = obj;
                        materializeModifier = 0;
                        ComposerKt.sourceInformationMarkerStart(composer15, -2146769399, restartGroup);
                        iNSTANCE2 = BoxScopeInstance.INSTANCE;
                        i217 |= 6;
                        i3 = 0;
                        i7 = i61;
                        i4 = materializeModifier3;
                        materialized$iv$iv2 = i8;
                        ComposerKt.sourceInformationMarkerStart(materialized$iv$iv2, -946109526, "C535@26351L7:TextField.kt#uh7d8r");
                        label.invoke(materialized$iv$iv2, Integer.valueOf(i62 &= 14));
                        ComposerKt.sourceInformationMarkerEnd(materialized$iv$iv2);
                        ComposerKt.sourceInformationMarkerEnd(composer15);
                        obj.endNode();
                        ComposerKt.sourceInformationMarkerEnd(obj);
                        ComposerKt.sourceInformationMarkerEnd(obj);
                        ComposerKt.sourceInformationMarkerEnd(obj);
                    } else {
                        obj4 = label;
                        $this$dp$iv = animationProgress;
                    }
                    obj.endReplaceGroup();
                    int i138 = 0;
                    if (prefix == null) {
                        f3 = f4;
                    } else {
                        i14 = 0;
                        f3 = constructor-impl2;
                    }
                    if (obj8 == null) {
                        constructor-impl = endPadding;
                    } else {
                        i14 = 0;
                        constructor-impl = Dp.constructor-impl((float)heightIn-VpY3zN4$default);
                    }
                    Modifier padding-qDBjuR0$default = PaddingKt.padding-qDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.heightIn-VpY3zN4$default((Modifier)Modifier.Companion, TextFieldImplKt.getMinTextLineHeight(), 0, 2, i138), i138, false, 3, i138), f3, 0, constructor-impl, 0, 10, 0);
                    obj.startReplaceGroup(1341611627);
                    ComposerKt.sourceInformation(obj, "548@26778L63");
                    if (placeholder != null) {
                        placeholder.invoke(LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Hint").then(padding-qDBjuR0$default), obj, Integer.valueOf(i127 &= 112));
                    } else {
                        obj3 = placeholder;
                    }
                    obj.endReplaceGroup();
                    Modifier then3 = LayoutIdKt.layoutId((Modifier)Modifier.Companion, "TextField").then(padding-qDBjuR0$default);
                    int i125 = i183;
                    maybeCachedBoxMeasurePolicy4 = 384;
                    iNSTANCE = 0;
                    ComposerKt.sourceInformationMarkerStart(obj, 733328855, str3);
                    modifier4 = padding-qDBjuR0$default;
                    maybeCachedBoxMeasurePolicy6 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), i125);
                    currentCompositeKeyHash = 0;
                    ComposerKt.sourceInformationMarkerStart(obj, -1323940314, $changed$iv);
                    currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(obj, 0);
                    currentCompositionLocalMap6 = obj.getCurrentCompositionLocalMap();
                    localMap$iv$iv = i125;
                    i31 = then3;
                    kotlin.jvm.functions.Function0 function09 = constructor8;
                    i27 = 0;
                    ComposerKt.sourceInformationMarkerStart(obj, -692256719, $dirty12);
                    if (!applier7 instanceof Applier) {
                        ComposablesKt.invalidApplier();
                    }
                    obj.startReusableNode();
                    if (obj.getInserting()) {
                        obj.createNode(function09);
                    } else {
                        factory$iv$iv$iv2 = function09;
                        obj.useNode();
                    }
                    i29 = factory$iv$iv$iv2;
                    Composer constructor-impl8 = Updater.constructor-impl(obj);
                    int i230 = 0;
                    Updater.set-impl(constructor-impl8, maybeCachedBoxMeasurePolicy6, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl8, currentCompositionLocalMap6, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    int i239 = 0;
                    Composer composer24 = constructor-impl8;
                    int i240 = 0;
                    if (!composer24.getInserting()) {
                        measurePolicy$iv = maybeCachedBoxMeasurePolicy6;
                        map = currentCompositionLocalMap6;
                        if (!Intrinsics.areEqual(composer24.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                            composer24.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                            constructor-impl8.apply(Integer.valueOf(currentCompositeKeyHash3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer7 = composer24;
                        }
                    } else {
                        measurePolicy$iv = maybeCachedBoxMeasurePolicy6;
                        map = currentCompositionLocalMap6;
                    }
                    Updater.set-impl(constructor-impl8, ComposedModifierKt.materializeModifier(obj, then3), ComposeUiNode.Companion.getSetModifier());
                    Composer composer14 = obj;
                    ComposerKt.sourceInformationMarkerStart(composer14, -2146769399, restartGroup);
                    iNSTANCE2 = BoxScopeInstance.INSTANCE;
                    i232 |= 6;
                    i3 = 0;
                    i7 = i48;
                    i4 = i115;
                    $composer$iv2 = composer6;
                    ComposerKt.sourceInformationMarkerStart($composer$iv2, -945435834, "C554@27030L11:TextField.kt#uh7d8r");
                    textField.invoke($composer$iv2, Integer.valueOf(i49 &= 14));
                    ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                    ComposerKt.sourceInformationMarkerEnd(composer14);
                    obj.endNode();
                    ComposerKt.sourceInformationMarkerEnd(obj);
                    ComposerKt.sourceInformationMarkerEnd(obj);
                    ComposerKt.sourceInformationMarkerEnd(obj);
                    obj.startReplaceGroup(1341622624);
                    ComposerKt.sourceInformation(obj, "559@27167L317");
                    if (supporting != null) {
                        int i139 = 0;
                        Modifier padding = PaddingKt.padding(SizeKt.wrapContentHeight$default(SizeKt.heightIn-VpY3zN4$default(LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Supporting"), TextFieldImplKt.getMinSupportingTextLineHeight(), 0, 2, i139), i139, false, 3, i139), TextFieldDefaults.supportingTextPadding-a9UjIt4$material3_release$default(TextFieldDefaults.INSTANCE, 0, 0, 0, 0, 15, 0));
                        $composer$iv2 = i185;
                        materializeModifier = 0;
                        ComposerKt.sourceInformationMarkerStart(obj, 733328855, str3);
                        Alignment topStart2 = Alignment.Companion.getTopStart();
                        topStart = 0;
                        obj74 = topStart2;
                        ComposerKt.sourceInformationMarkerStart(obj, -1323940314, $changed$iv);
                        currentCompositionLocalMap5 = obj.getCurrentCompositionLocalMap();
                        i24 = currentCompositeKeyHash6;
                        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(obj, padding);
                        modifier3 = padding;
                        kotlin.jvm.functions.Function0 function03 = constructor;
                        companion = 0;
                        ComposerKt.sourceInformationMarkerStart(obj, -692256719, $dirty12);
                        if (!applier instanceof Applier) {
                            ComposablesKt.invalidApplier();
                        }
                        obj.startReusableNode();
                        if (obj.getInserting()) {
                            obj.createNode(function03);
                        } else {
                            factory$iv$iv$iv7 = function03;
                            obj.useNode();
                        }
                        Composer constructor-impl10 = Updater.constructor-impl(obj);
                        int i189 = 0;
                        currentCompositeKeyHash5 = factory$iv$iv$iv7;
                        Updater.set-impl(constructor-impl10, BoxKt.maybeCachedBoxMeasurePolicy(topStart2, false), ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(constructor-impl10, currentCompositionLocalMap5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        int i192 = 0;
                        Composer composer21 = constructor-impl10;
                        int i198 = 0;
                        if (!composer21.getInserting()) {
                            localMap$iv$iv = currentCompositionLocalMap5;
                            if (!Intrinsics.areEqual(composer21.rememberedValue(), Integer.valueOf(i24))) {
                                composer21.updateRememberedValue(Integer.valueOf(i24));
                                constructor-impl10.apply(Integer.valueOf(i24), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            } else {
                                composer8 = composer21;
                            }
                        } else {
                            localMap$iv$iv = currentCompositionLocalMap5;
                        }
                        Updater.set-impl(constructor-impl10, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                        $changed$iv = obj;
                        valueOf8 = 0;
                        ComposerKt.sourceInformationMarkerStart($changed$iv, -2146769399, restartGroup);
                        restartGroup = BoxScopeInstance.INSTANCE;
                        i182 |= 6;
                        composer = $changed$iv;
                        i21 = 0;
                        i33 = i55;
                        currentCompositeKeyHash = materializeModifier2;
                        ComposerKt.sourceInformationMarkerStart($changed$iv, -945015195, "C565@27454L12:TextField.kt#uh7d8r");
                        supporting.invoke($changed$iv, Integer.valueOf(i56 &= 14));
                        ComposerKt.sourceInformationMarkerEnd($changed$iv);
                        ComposerKt.sourceInformationMarkerEnd($changed$iv);
                        obj.endNode();
                        ComposerKt.sourceInformationMarkerEnd(obj);
                        ComposerKt.sourceInformationMarkerEnd(obj);
                        ComposerKt.sourceInformationMarkerEnd(obj);
                    } else {
                        obj5 = supporting;
                    }
                    obj.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd(obj);
                    composer9.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer9);
                    ComposerKt.sourceInformationMarkerEnd(composer9);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    restartGroup.skipToGroupEnd();
                    obj5 = supporting;
                    i30 = traceInProgress;
                    composer9 = restartGroup;
                    i16 = $dirty12;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer9.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new TextFieldKt.TextFieldLayout.2(modifier, textField, label, placeholder, leading, trailing, prefix, obj8, singleLine, $this$dp$iv, container, obj5, obj2, $changed, $changed1);
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
        int i2;
        int i4;
        final float f = animationProgress;
        int i5 = 0;
        i = labelHeight > 0 ? 1 : i5;
        i3 = 0;
        arg0$iv *= paddingValues;
        if (i != 0) {
            i2 = 0;
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
        Alignment.Vertical centerVertically2;
        int textHorizontalPosition;
        Placeable.PlacementScope roundToInt2;
        int centerVertically;
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
        int i3;
        int i2;
        int i4;
        int i6;
        int i7;
        int i;
        Placeable.PlacementScope.place-70tqf50$default($this$placeWithLabel, containerPlaceable, IntOffset.Companion.getZero-nOcc-ac(), obj4, 0, 2);
        int i8 = totalHeight - heightOrZero;
        if (leadingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, leadingPlaceable, 0, Alignment.Companion.getCenterVertically().align(leadingPlaceable.getHeight(), i8), 0, 4, 0);
        }
        if (labelPlaceable != null) {
            placeable2 = labelPlaceable;
            centerVertically2 = 0;
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
        i5 = widthOrZero2 + centerVertically;
        Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, textfieldPlaceable, i5, textPosition, 0, 4, 0);
        if (placeholderPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, placeholderPlaceable, i5, textPosition, 0, 4, 0);
            textHorizontalPosition = i5;
        } else {
            textHorizontalPosition = i5;
        }
        if (suffixPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, suffixPlaceable, centerVertically - zero-nOcc-ac, textPosition, 0, 4, 0);
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
        int widthOrZero2;
        Placeable placeable;
        int height;
        int i5;
        Placeable placeWithoutLabel$calculateVerticalPosition2;
        int height2;
        int widthOrZero;
        int i;
        int placeWithoutLabel$calculateVerticalPosition3;
        int placeWithoutLabel$calculateVerticalPosition;
        int i6;
        int i10;
        int i3;
        int textHorizontalPosition;
        int i9;
        Placeable.PlacementScope placementScope;
        Placeable placeable2;
        int i7;
        int align;
        int i8;
        int i4;
        int i2;
        placeable = placeholderPlaceable;
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
        placeWithoutLabel$calculateVerticalPosition2 = textPlaceable;
        i = i12;
        Placeable.PlacementScope.placeRelative$default($this$placeWithoutLabel, placeWithoutLabel$calculateVerticalPosition2, i, TextFieldKt.placeWithoutLabel$calculateVerticalPosition(z, i15, roundToInt, placeWithoutLabel$calculateVerticalPosition2), 0, 4, 0);
        i5 = i;
        if (placeable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithoutLabel, placeable, i5, TextFieldKt.placeWithoutLabel$calculateVerticalPosition(z, i15, roundToInt, placeable), 0, 4, 0);
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
            height2 = i15;
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
