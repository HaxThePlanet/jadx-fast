package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.CornerSizeKt;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.KeyboardOptions.Companion;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
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
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u009e\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u000b\u001a\u0087\u0002\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000c\u0012\u0004\u0012\u00020\n0\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00152\u0015\u0008\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\u0008\u00182\u0015\u0008\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\u0008\u00182\u0015\u0008\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\u0008\u00182\u0015\u0008\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\u0008\u00182\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u001d\u001a\u00020\u001e2\u0008\u0008\u0002\u0010\u001f\u001a\u00020 2\u0008\u0008\u0002\u0010!\u001a\u00020\"2\u0008\u0008\u0002\u0010#\u001a\u00020\u00122\u0008\u0008\u0002\u0010$\u001a\u00020%2\u0008\u0008\u0002\u0010&\u001a\u00020'2\u0008\u0008\u0002\u0010(\u001a\u00020)2\u0008\u0008\u0002\u0010*\u001a\u00020+H\u0007¢\u0006\u0002\u0010,\u001a\u0093\u0002\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000c\u0012\u0004\u0012\u00020\n0\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00152\u0015\u0008\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\u0008\u00182\u0015\u0008\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\u0008\u00182\u0015\u0008\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\u0008\u00182\u0015\u0008\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\u0008\u00182\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u001d\u001a\u00020\u001e2\u0008\u0008\u0002\u0010\u001f\u001a\u00020 2\u0008\u0008\u0002\u0010!\u001a\u00020\"2\u0008\u0008\u0002\u0010#\u001a\u00020\u00122\u0008\u0008\u0002\u0010$\u001a\u00020%2\u0008\u0008\u0002\u0010-\u001a\u00020%2\n\u0008\u0002\u0010&\u001a\u0004\u0018\u00010'2\u0008\u0008\u0002\u0010(\u001a\u00020)2\u0008\u0008\u0002\u0010*\u001a\u00020+H\u0007¢\u0006\u0002\u0010.\u001a\u0087\u0002\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020/2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\n0\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00152\u0015\u0008\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\u0008\u00182\u0015\u0008\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\u0008\u00182\u0015\u0008\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\u0008\u00182\u0015\u0008\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\u0008\u00182\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u001d\u001a\u00020\u001e2\u0008\u0008\u0002\u0010\u001f\u001a\u00020 2\u0008\u0008\u0002\u0010!\u001a\u00020\"2\u0008\u0008\u0002\u0010#\u001a\u00020\u00122\u0008\u0008\u0002\u0010$\u001a\u00020%2\u0008\u0008\u0002\u0010&\u001a\u00020'2\u0008\u0008\u0002\u0010(\u001a\u00020)2\u0008\u0008\u0002\u0010*\u001a\u00020+H\u0007¢\u0006\u0002\u00100\u001a\u0093\u0002\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020/2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\n0\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00152\u0015\u0008\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\u0008\u00182\u0015\u0008\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\u0008\u00182\u0015\u0008\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\u0008\u00182\u0015\u0008\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\u0008\u00182\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u001d\u001a\u00020\u001e2\u0008\u0008\u0002\u0010\u001f\u001a\u00020 2\u0008\u0008\u0002\u0010!\u001a\u00020\"2\u0008\u0008\u0002\u0010#\u001a\u00020\u00122\u0008\u0008\u0002\u0010$\u001a\u00020%2\u0008\u0008\u0002\u0010-\u001a\u00020%2\n\u0008\u0002\u0010&\u001a\u0004\u0018\u00010'2\u0008\u0008\u0002\u0010(\u001a\u00020)2\u0008\u0008\u0002\u0010*\u001a\u00020+H\u0007¢\u0006\u0002\u00101\u001a\u009a\u0001\u00102\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0011\u00103\u001a\r\u0012\u0004\u0012\u00020\n0\u0017¢\u0006\u0002\u0008\u00182\u0013\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\u0008\u00182\u0019\u0010\u0019\u001a\u0015\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\n\u0018\u00010\u000e¢\u0006\u0002\u0008\u00182\u0013\u00104\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\u0008\u00182\u0013\u00105\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\u0008\u00182\u0006\u0010#\u001a\u00020\u00122\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000209H\u0001¢\u0006\u0002\u0010:\u001aZ\u0010;\u001a\u00020%2\u0006\u0010<\u001a\u00020%2\u0006\u0010=\u001a\u00020\u00122\u0006\u0010>\u001a\u00020%2\u0006\u0010?\u001a\u00020%2\u0006\u0010@\u001a\u00020%2\u0006\u0010A\u001a\u00020%2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u0002072\u0006\u00108\u001a\u000209H\u0002ø\u0001\u0000¢\u0006\u0004\u0008E\u0010F\u001aB\u0010G\u001a\u00020%2\u0006\u0010H\u001a\u00020%2\u0006\u0010I\u001a\u00020%2\u0006\u0010J\u001a\u00020%2\u0006\u0010K\u001a\u00020%2\u0006\u0010L\u001a\u00020%2\u0006\u0010B\u001a\u00020CH\u0002ø\u0001\u0000¢\u0006\u0004\u0008M\u0010N\u001a\u0014\u0010O\u001a\u00020\u0010*\u00020\u00102\u0006\u0010P\u001a\u00020QH\u0000\u001at\u0010R\u001a\u00020\n*\u00020S2\u0006\u0010T\u001a\u00020%2\u0006\u0010U\u001a\u00020%2\u0006\u0010V\u001a\u00020W2\u0008\u0010X\u001a\u0004\u0018\u00010W2\u0008\u0010Y\u001a\u0004\u0018\u00010W2\u0008\u0010Z\u001a\u0004\u0018\u00010W2\u0008\u0010[\u001a\u0004\u0018\u00010W2\u0006\u0010#\u001a\u00020\u00122\u0006\u0010\\\u001a\u00020%2\u0006\u0010]\u001a\u00020%2\u0006\u00106\u001a\u0002072\u0006\u0010D\u001a\u000207H\u0002\u001aZ\u0010^\u001a\u00020\n*\u00020S2\u0006\u0010T\u001a\u00020%2\u0006\u0010U\u001a\u00020%2\u0006\u0010_\u001a\u00020W2\u0008\u0010Y\u001a\u0004\u0018\u00010W2\u0008\u0010Z\u001a\u0004\u0018\u00010W2\u0008\u0010[\u001a\u0004\u0018\u00010W2\u0006\u0010#\u001a\u00020\u00122\u0006\u0010D\u001a\u0002072\u0006\u00108\u001a\u000209H\u0002\u001a\u0014\u0010`\u001a\u00020%*\u00020%2\u0006\u0010a\u001a\u00020%H\u0002\"\u0016\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\u0008\u0002\u0010\u0003\"\u0016\u0010\u0005\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\u0008\u0006\u0010\u0003\"\u0016\u0010\u0007\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\u0008\u0008\u0010\u0003\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006b", d2 = {"FirstBaselineOffset", "Landroidx/compose/ui/unit/Dp;", "getFirstBaselineOffset", "()F", "F", "TextFieldBottomPadding", "getTextFieldBottomPadding", "TextFieldTopPadding", "getTextFieldTopPadding", "TextField", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "label", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "placeholder", "leadingIcon", "trailingIcon", "isError", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material/TextFieldColors;", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "minLines", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "TextFieldLayout", "textField", "leading", "trailing", "animationProgress", "", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)V", "calculateHeight", "textFieldHeight", "hasLabel", "labelBaseline", "leadingHeight", "trailingHeight", "placeholderHeight", "constraints", "Landroidx/compose/ui/unit/Constraints;", "density", "calculateHeight-O3s9Psw", "(IZIIIIJFLandroidx/compose/foundation/layout/PaddingValues;)I", "calculateWidth", "leadingWidth", "trailingWidth", "textFieldWidth", "labelWidth", "placeholderWidth", "calculateWidth-VsPV1Ek", "(IIIIIJ)I", "drawIndicatorLine", "indicatorBorder", "Landroidx/compose/foundation/BorderStroke;", "placeWithLabel", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "width", "height", "textfieldPlaceable", "Landroidx/compose/ui/layout/Placeable;", "labelPlaceable", "placeholderPlaceable", "leadingPlaceable", "trailingPlaceable", "labelEndPosition", "textPosition", "placeWithoutLabel", "textPlaceable", "substractConstraintSafely", "from", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TextFieldKt {

    private static final float FirstBaselineOffset;
    private static final float TextFieldBottomPadding;
    private static final float TextFieldTopPadding;
    static {
        int i4 = 0;
        TextFieldKt.FirstBaselineOffset = Dp.constructor-impl((float)i);
        int i5 = 0;
        TextFieldKt.TextFieldBottomPadding = Dp.constructor-impl((float)i2);
        int i6 = 0;
        TextFieldKt.TextFieldTopPadding = Dp.constructor-impl((float)i3);
    }

    public static final void TextField(TextFieldValue value, Function1<? super TextFieldValue, Unit> onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> label, Function2<? super Composer, ? super Integer, Unit> placeholder, Function2<? super Composer, ? super Integer, Unit> leadingIcon, Function2<? super Composer, ? super Integer, Unit> trailingIcon, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, int minLines, MutableInteractionSource interactionSource, Shape shape, androidx.compose.material.TextFieldColors colors, Composer $composer, int $changed, int $changed1, int i24) {
        Object obj4;
        Object obj8;
        boolean z7;
        Object obj6;
        Object obj9;
        Object obj17;
        boolean z4;
        int i63;
        int i21;
        Object obj21;
        Object obj14;
        int $dirty1;
        Object $dirty15;
        Object $dirty14;
        Object endRestartGroup;
        int skipping;
        int $dirty4;
        int $dirty;
        int $dirty16;
        int defaultsInvalid;
        Object modifier2;
        int $i$a$CacheTextFieldKt$TextField$interactionSource$2;
        boolean traceInProgress2;
        int $composer3;
        int i44;
        Object $composer2;
        int $dirty2;
        int $dirty3;
        int i38;
        int i86;
        Object textFieldColors-dx8h9Zs;
        int default;
        int $dirty17;
        boolean z6;
        int $dirty13;
        Object $dirty18;
        Composer composer;
        boolean z2;
        Object obj2;
        int i87;
        Object obj18;
        boolean field3;
        int i61;
        int i88;
        int textFieldShape;
        Object enabled2;
        boolean z3;
        Object readOnly2;
        int i;
        Object obj13;
        boolean traceInProgress;
        int value2;
        int i66;
        Object obj12;
        KeyboardOptions i73;
        int keyboardOptions3;
        Object visualTransformation2;
        Object shape3;
        int keyboardActions2;
        int i28;
        int field;
        int i18;
        VisualTransformation singleLine2;
        int obj19;
        int i46;
        KeyboardOptions maxLines2;
        Object obj;
        int obj15;
        KeyboardActions minLines2;
        Object obj20;
        int visualTransformation3;
        int i14;
        int i68;
        int i72;
        int i83;
        int i36;
        int i43;
        int changed;
        int i82;
        int changed7;
        int i58;
        long $this$takeOrElse_u2dDxMtmZc$iv;
        int i26;
        int i76;
        int companion;
        Shape shape2;
        int i89;
        int i6;
        long unbox-impl;
        Object field2;
        int i23;
        int i7;
        int i56;
        int i97;
        int i32;
        int changed6;
        int i25;
        int i51;
        int i15;
        int i39;
        int i65;
        int $dirty12;
        int i37;
        int changed4;
        int changed3;
        int i22;
        int i90;
        int changed2;
        int i52;
        int i84;
        int i75;
        int i71;
        int i100;
        int i101;
        int i69;
        int i5;
        int i92;
        boolean changed5;
        int i8;
        int i99;
        int i67;
        int i74;
        int i41;
        int i9;
        int i2;
        int i10;
        int i16;
        int i79;
        int i85;
        int i33;
        int i70;
        Composer composer2;
        Composer composer3;
        int i13;
        int i3;
        int i47;
        int i77;
        boolean z;
        boolean z5;
        Object obj16;
        int i62;
        Object obj5;
        Object obj10;
        int i91;
        int obj11;
        int obj7;
        int i19;
        VisualTransformation i53;
        KeyboardOptions keyboardOptions2;
        int i35;
        int i57;
        int i17;
        int modifier3;
        Shape obj3;
        int i93;
        int i98;
        TextStyle textStyle2;
        long l;
        int i54;
        int i59;
        int i64;
        int i60;
        int i94;
        int i48;
        int i42;
        int i81;
        int i50;
        int i31;
        int i55;
        int i45;
        int i20;
        int i11;
        int i95;
        int i27;
        int i78;
        int i12;
        int i30;
        int i4;
        int i80;
        int i29;
        int i49;
        int i40;
        int i34;
        ScopeUpdateScope scopeUpdateScope;
        int i96;
        Object obj106;
        int obj107;
        int obj108;
        int obj109;
        int obj110;
        int obj111;
        int obj112;
        int obj113;
        int obj114;
        int obj115;
        int obj116;
        Shape obj117;
        androidx.compose.material.TextFieldColors obj118;
        Object obj119;
        Object obj120;
        Modifier obj121;
        int obj124;
        int i102 = $changed;
        int i114 = $changed1;
        traceInProgress2 = i24;
        Composer restartGroup = $composer.startRestartGroup(-359119489);
        ComposerKt.sourceInformation(restartGroup, "C(TextField)P(18,11,10,1,13,16,6,12,7,17,3,19,5,4,15,8,9,2,14)356@17778L7,369@18422L14,370@18486L17,385@19110L38,394@19477L20,402@19819L724,381@18927L1622:TextField.kt#jmzs0o");
        $dirty2 = $changed;
        $dirty13 = $changed1;
        if (traceInProgress2 & 1 != 0) {
            $dirty2 |= 6;
            obj2 = value;
        } else {
            if (i102 & 6 == 0) {
                i = restartGroup.changed(value) ? 4 : 2;
                $dirty2 |= i;
            } else {
                obj2 = value;
            }
        }
        if (traceInProgress2 & 2 != 0) {
            $dirty2 |= 48;
            obj13 = onValueChange;
        } else {
            if (i102 & 48 == 0) {
                i28 = restartGroup.changedInstance(onValueChange) ? 32 : 16;
                $dirty2 |= i28;
            } else {
                obj13 = onValueChange;
            }
        }
        i18 = traceInProgress2 & 4;
        if (i18 != 0) {
            $dirty2 |= 384;
            obj20 = modifier;
        } else {
            if (i102 & 384 == 0) {
                i14 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty2 |= i14;
            } else {
                obj20 = modifier;
            }
        }
        i68 = traceInProgress2 & 8;
        changed = 1024;
        if (i68 != 0) {
            $dirty2 |= 3072;
            field3 = enabled;
        } else {
            if (i102 & 3072 == 0) {
                i76 = restartGroup.changed(enabled) ? i83 : changed;
                $dirty2 |= i76;
            } else {
                field3 = enabled;
            }
        }
        companion = traceInProgress2 & 16;
        if (companion != 0) {
            $dirty2 |= 24576;
            z3 = readOnly;
        } else {
            if (i102 & 24576 == 0) {
                i56 = restartGroup.changed(readOnly) ? 16384 : i89;
                $dirty2 |= i56;
            } else {
                z3 = readOnly;
            }
        }
        if (i102 & i210 == 0) {
            if (traceInProgress2 & 32 == 0) {
                changed6 = restartGroup.changed(textStyle) ? 131072 : 65536;
            } else {
                obj12 = textStyle;
            }
            $dirty2 |= changed6;
        } else {
            obj12 = textStyle;
        }
        i25 = traceInProgress2 & 64;
        i51 = 1572864;
        i22 = 524288;
        if (i25 != 0) {
            $dirty2 |= i51;
            visualTransformation2 = label;
        } else {
            if (i102 & i51 == 0) {
                i52 = restartGroup.changedInstance(label) ? 1048576 : i22;
                $dirty2 |= i52;
            } else {
                visualTransformation2 = label;
            }
        }
        i46 = traceInProgress2 & 128;
        i84 = 12582912;
        if (i46 != 0) {
            $dirty2 |= i84;
            obj = placeholder;
        } else {
            if (i102 & i84 == 0) {
                i71 = restartGroup.changedInstance(placeholder) ? 8388608 : 4194304;
                $dirty2 |= i71;
            } else {
                obj = placeholder;
            }
        }
        int i103 = traceInProgress2 & 256;
        int i219 = 100663296;
        if (i103 != 0) {
            $dirty2 |= i219;
            i100 = i103;
            obj4 = leadingIcon;
        } else {
            if ($changed & i219 == 0) {
                i100 = i103;
                i101 = restartGroup.changedInstance(leadingIcon) ? 67108864 : 33554432;
                $dirty2 |= i101;
            } else {
                i100 = i103;
                obj4 = leadingIcon;
            }
        }
        int i104 = traceInProgress2 & 512;
        int i221 = 805306368;
        if (i104 != 0) {
            $dirty2 |= i221;
            i69 = i104;
            obj8 = trailingIcon;
        } else {
            if ($changed & i221 == 0) {
                i69 = i104;
                i5 = restartGroup.changedInstance(trailingIcon) ? 536870912 : 268435456;
                $dirty2 |= i5;
            } else {
                i69 = i104;
                obj8 = trailingIcon;
            }
        }
        int i105 = traceInProgress2 & 1024;
        if (i105 != 0) {
            $dirty13 |= 6;
            i92 = i105;
            z7 = isError;
        } else {
            if (i114 & 6 == 0) {
                i92 = i105;
                i23 = restartGroup.changed(isError) ? 4 : 2;
                $dirty13 |= i23;
            } else {
                i92 = i105;
                z7 = isError;
            }
        }
        int i106 = traceInProgress2 & 2048;
        if (i106 != 0) {
            $dirty13 |= 48;
            i7 = i106;
            obj6 = visualTransformation;
        } else {
            if (i114 & 48 == 0) {
                i7 = i106;
                changed2 = restartGroup.changed(visualTransformation) ? 32 : 16;
                $dirty13 |= changed2;
            } else {
                i7 = i106;
                obj6 = visualTransformation;
            }
        }
        int i107 = traceInProgress2 & 4096;
        if (i107 != 0) {
            $dirty13 |= 384;
            i32 = i107;
            obj9 = keyboardOptions;
        } else {
            i32 = i107;
            if (i114 & 384 == 0) {
                i52 = restartGroup.changed(keyboardOptions) ? 256 : 128;
                $dirty13 |= i52;
            } else {
                obj9 = keyboardOptions;
            }
        }
        if (i114 & 3072 == 0) {
            if (traceInProgress2 & 8192 == 0) {
                if (restartGroup.changed(keyboardActions)) {
                } else {
                    i83 = changed;
                }
            } else {
                obj17 = keyboardActions;
            }
            $dirty13 |= i83;
        } else {
            obj17 = keyboardActions;
        }
        int i110 = traceInProgress2 & 16384;
        if (i110 != 0) {
            $dirty13 |= 24576;
            i36 = i110;
            z4 = singleLine;
        } else {
            i36 = i110;
            if (i114 & 24576 == 0) {
                if (restartGroup.changed(singleLine)) {
                    i89 = 16384;
                }
                $dirty13 |= i89;
            } else {
                z4 = singleLine;
            }
        }
        if (i114 & i200 == 0) {
            if (traceInProgress2 & i201 == 0) {
                i82 = restartGroup.changed(maxLines) ? 131072 : 65536;
            } else {
                i63 = maxLines;
            }
            $dirty13 |= i82;
        } else {
            i63 = maxLines;
        }
        i58 = traceInProgress2 & i202;
        if (i58 != 0) {
            $dirty13 |= i51;
            i21 = minLines;
        } else {
            if (i114 & i51 == 0) {
                i89 = restartGroup.changed(minLines) ? 1048576 : i22;
                $dirty13 |= i89;
            } else {
                i21 = minLines;
            }
        }
        i6 = traceInProgress2 & i206;
        if (i6 != 0) {
            $dirty13 |= i84;
            obj21 = interactionSource;
        } else {
            if (i114 & i84 == 0) {
                i51 = restartGroup.changed(interactionSource) ? 8388608 : 4194304;
                $dirty13 |= i51;
            } else {
                obj21 = interactionSource;
            }
        }
        if (i114 & i213 == 0) {
            if (traceInProgress2 & i215 == 0) {
                i15 = restartGroup.changed(shape) ? 67108864 : 33554432;
            } else {
                obj14 = shape;
            }
            $dirty13 |= i15;
        } else {
            obj14 = shape;
        }
        if (i114 & i214 == 0) {
            if (traceInProgress2 & i22 == 0) {
                obj124 = $dirty13;
                i37 = restartGroup.changed(colors) ? 536870912 : 268435456;
            } else {
                obj124 = $dirty13;
                $dirty18 = colors;
            }
            $dirty1 = i39;
        } else {
            $dirty18 = colors;
            $dirty1 = obj124;
        }
        obj124 = $dirty2;
        if ($dirty2 & i65 == 306783378 && i128 &= $dirty1 == 306783378) {
            if (i128 &= $dirty1 == 306783378) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    default = -458753;
                    int i160 = 6;
                    int i163 = 1;
                    if ($changed & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if (i18 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = obj20;
                            }
                            z = i68 != 0 ? field3 : field3;
                            z5 = companion != 0 ? field3 : z3;
                            if (traceInProgress2 & 32 != 0) {
                                z3 = 6;
                                i18 = 0;
                                ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                                obj16 = default;
                                i62 = i61;
                            } else {
                                i68 = default;
                                i62 = obj124;
                                obj16 = obj12;
                            }
                            obj5 = i25 != 0 ? default : visualTransformation2;
                            obj10 = i46 != 0 ? default : obj;
                            i91 = i100 != 0 ? default : leadingIcon;
                            obj11 = i69 != 0 ? default : trailingIcon;
                            obj7 = i92 != 0 ? default : isError;
                            if (i7 != 0) {
                                i53 = default;
                            } else {
                                i53 = visualTransformation;
                            }
                            if (i32 != 0) {
                                keyboardOptions2 = default;
                            } else {
                                keyboardOptions2 = keyboardOptions;
                            }
                            if (traceInProgress2 & 8192 != 0) {
                                super(0, 0, 0, 0, 0, 0, 63, 0);
                                $dirty17 = $dirty19;
                                $dirty14 = i96;
                            } else {
                                $dirty17 = $dirty1;
                                $dirty14 = keyboardActions;
                            }
                            i35 = i36 != 0 ? i61 : singleLine;
                            if (i167 &= traceInProgress2 != 0) {
                                i88 = i35 != 0 ? i163 : 0x7fffffff /* Unknown resource */;
                                $dirty17 &= i68;
                                i57 = i88;
                            } else {
                                i57 = maxLines;
                            }
                            i17 = i58 != 0 ? i88 : minLines;
                            modifier3 = i6 != 0 ? i88 : interactionSource;
                            if (i168 &= traceInProgress2 != 0) {
                                obj3 = textFieldShape;
                                i93 = $dirty17;
                            } else {
                                obj3 = shape;
                                i93 = $dirty17;
                            }
                            if (traceInProgress2 & i22 != 0) {
                                int i172 = i163;
                                int i179 = i169;
                                int i185 = i179;
                                int i188 = i180;
                                i68 = i188;
                                i58 = i68;
                                i6 = i58;
                                i32 = i6;
                                i65 = i32;
                                changed2 = i65;
                                i84 = changed2;
                                i100 = i84;
                                i92 = i100;
                                i8 = i92;
                                i67 = i8;
                                i41 = i67;
                                i2 = i41;
                                i16 = i2;
                                i85 = i16;
                                i70 = i85;
                                i98 = i234;
                                composer2 = restartGroup;
                                $composer3 = i96;
                                textFieldColors-dx8h9Zs = TextFieldDefaults.INSTANCE.textFieldColors-dx8h9Zs(0, i163, 0, i172, 0, i179, 0, i185, 0, i188, 0, i68, 0, i58, 0, i6, 0, i32, 0, i65, 0, changed2, 0, i84, 0, i100);
                                composer = composer2;
                                shape3 = $dirty14;
                                obj20 = modifier2;
                                $dirty = i165;
                                field3 = z;
                                z3 = z5;
                                $dirty15 = obj16;
                                i87 = i62;
                                i73 = keyboardOptions2;
                                field = i35;
                                obj19 = i57;
                                obj15 = i17;
                            } else {
                                composer = restartGroup;
                                $composer3 = i96;
                                textFieldColors-dx8h9Zs = colors;
                                shape3 = $dirty14;
                                obj20 = modifier2;
                                field3 = z;
                                z3 = z5;
                                $dirty15 = obj16;
                                i87 = i62;
                                i73 = keyboardOptions2;
                                field = i35;
                                obj19 = i57;
                                obj15 = i17;
                                $dirty = i93;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            $dirty4 = traceInProgress2 & 32 != 0 ? obj124 & default : obj124;
                            if (traceInProgress2 & 8192 != 0) {
                                $dirty1 &= -7169;
                            }
                            if (i183 &= traceInProgress2 != 0) {
                                $dirty1 &= default;
                            }
                            if (i156 &= traceInProgress2 != 0) {
                                $dirty1 &= i38;
                            }
                            if (traceInProgress2 & i22 != 0) {
                                $dirty1 &= i86;
                            }
                            composer = restartGroup;
                            $composer3 = i157;
                            i91 = leadingIcon;
                            obj11 = trailingIcon;
                            obj7 = isError;
                            i53 = visualTransformation;
                            field = singleLine;
                            obj19 = maxLines;
                            modifier3 = interactionSource;
                            obj3 = shape;
                            textFieldColors-dx8h9Zs = colors;
                            i87 = $dirty4;
                            obj5 = visualTransformation2;
                            obj10 = obj;
                            shape3 = keyboardActions;
                            obj15 = minLines;
                            $dirty = $dirty1;
                            $dirty15 = obj12;
                            i73 = keyboardOptions;
                        }
                    } else {
                    }
                    composer.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-359119489, i87, $dirty, "androidx.compose.material.TextField (TextField.kt:371)");
                    }
                    if (modifier3 == 0) {
                        composer.startReplaceGroup(-1665951468);
                        ComposerKt.sourceInformation(composer, "373@18589L39");
                        ComposerKt.sourceInformationMarkerStart(composer, -53740370, "CC(remember):TextField.kt#9igjgp");
                        $composer3 = 0;
                        traceInProgress = composer;
                        i68 = 0;
                        $dirty12 = $dirty;
                        $dirty16 = traceInProgress.rememberedValue();
                        i58 = 0;
                        if ($dirty16 == Composer.Companion.getEmpty()) {
                            int i146 = 0;
                            traceInProgress.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                        } else {
                            $i$a$CacheTextFieldKt$TextField$interactionSource$2 = $dirty16;
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        composer.endReplaceGroup();
                    } else {
                        $dirty12 = $dirty;
                        composer.startReplaceGroup(-53741021);
                        composer.endReplaceGroup();
                        $i$a$CacheTextFieldKt$TextField$interactionSource$2 = modifier3;
                    }
                    composer.startReplaceGroup(-53735263);
                    ComposerKt.sourceInformation(composer, "*376@18776L18");
                    int i117 = 0;
                    i44 = 0;
                    value2 = Long.compare(unbox-impl, i211) != 0 ? 1 : 0;
                    if (value2 != null) {
                    } else {
                        i44 = 0;
                        $this$takeOrElse_u2dDxMtmZc$iv = unbox-impl;
                    }
                    composer.endReplaceGroup();
                    textStyle2 = new TextStyle($this$takeOrElse_u2dDxMtmZc$iv, obj72, 0, obj74, 0, 0, 0, 0, 0, 0, obj81, 0, 0, 0, 0, obj86, 0, 0, 0, 0, 0, 0, obj93, 0, 0, 0, 0, 0, 0, 16777214, 0);
                    obj108 = field3;
                    obj107 = obj20;
                    obj109 = obj7;
                    Object obj22 = obj107;
                    int i189 = obj109;
                    obj111 = $i$a$CacheTextFieldKt$TextField$interactionSource$2;
                    SolidColor solidColor = new SolidColor((Color)textFieldColors-dx8h9Zs.cursorColor(i189, composer, i129 |= i195).getValue().unbox-impl(), obj22, 0);
                    obj106 = anon;
                    obj118 = textFieldColors-dx8h9Zs;
                    obj112 = i189;
                    obj110 = i53;
                    super(value, obj108, field, obj110, obj111, obj112, obj5, obj10, i91, obj11, obj3, obj118);
                    VisualTransformation visualTransformation5 = obj110;
                    Composer composer4 = composer;
                    BasicTextFieldKt.BasicTextField(value, onValueChange, SizeKt.defaultMinSize-VpY3zN4(TextFieldImplKt.defaultErrorSemantics(TextFieldDefaults.indicatorLine-gv0btCI$default(TextFieldDefaults.INSTANCE, obj107, obj108, obj109, (InteractionSource)$i$a$CacheTextFieldKt$TextField$interactionSource$2, textFieldColors-dx8h9Zs, 0, 0, 48, 0), i189, Strings_androidKt.getString-4foXLRw(Strings.Companion.getDefaultErrorMessage-UdPEhr4(), composer, 6)), TextFieldDefaults.INSTANCE.getMinWidth-D9Ej5fM(), TextFieldDefaults.INSTANCE.getMinHeight-D9Ej5fM()), field3, z3, $dirty15.merge(textStyle2), i73, shape3, field, obj19, obj15, visualTransformation5, 0, obj111, (Brush)solidColor, (Function3)ComposableLambdaKt.rememberComposableLambda(-126640971, true, obj106, composer, 54), composer4, i124 | i143, i127 | i145, 4096);
                    composer3 = composer4;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    visualTransformation3 = field;
                    singleLine2 = visualTransformation4;
                    obj18 = obj119;
                    $composer2 = obj120;
                    field2 = $dirty1;
                    i90 = skipping;
                    z6 = field3;
                    z2 = z3;
                    i72 = obj19;
                    i43 = obj15;
                    enabled2 = obj5;
                    readOnly2 = obj10;
                    i66 = i91;
                    i26 = modifier3;
                    shape2 = obj3;
                    maxLines2 = i73;
                    minLines2 = shape3;
                    keyboardOptions3 = obj11;
                    keyboardActions2 = i19;
                } else {
                    restartGroup.skipToGroupEnd();
                    i66 = leadingIcon;
                    singleLine2 = visualTransformation;
                    maxLines2 = keyboardOptions;
                    i72 = maxLines;
                    i43 = minLines;
                    i26 = interactionSource;
                    shape2 = shape;
                    i90 = obj124;
                    $dirty12 = $dirty1;
                    composer3 = restartGroup;
                    field2 = $dirty18;
                    z6 = field3;
                    z2 = z3;
                    obj18 = obj12;
                    enabled2 = visualTransformation2;
                    readOnly2 = obj;
                    $composer2 = obj20;
                    keyboardOptions3 = trailingIcon;
                    keyboardActions2 = isError;
                    minLines2 = keyboardActions;
                    visualTransformation3 = singleLine;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer3.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new TextFieldKt.TextField.6(value, onValueChange, $composer2, z6, z2, obj18, enabled2, readOnly2, i66, keyboardOptions3, keyboardActions2, singleLine2, maxLines2, minLines2, visualTransformation3, i72, i43, i26, shape2, field2, $changed, $changed1, i24);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    public static final void TextField(TextFieldValue value, Function1 onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2 label, Function2 placeholder, Function2 leadingIcon, Function2 trailingIcon, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, MutableInteractionSource interactionSource, Shape shape, androidx.compose.material.TextFieldColors colors, Composer $composer, int $changed, int $changed1, int i23) {
        Object obj;
        Object obj4;
        boolean z6;
        Object obj5;
        Object obj17;
        Object obj7;
        boolean z4;
        int i42;
        Object obj6;
        Object obj14;
        int keyboardActions4;
        Object $dirty1;
        Object endRestartGroup;
        int modifier2;
        int defaultsInvalid;
        Object modifier3;
        int i14;
        int i34;
        int i43;
        int i;
        Object textFieldColors-dx8h9Zs;
        boolean traceInProgress;
        Object $composer3;
        int $dirty;
        int $dirty2;
        int $dirty15;
        int this_$iv;
        int $dirty13;
        boolean z2;
        int $dirty12;
        Object $dirty14;
        boolean z3;
        Object obj10;
        Object obj8;
        Object modifier4;
        boolean invalid$iv;
        int textFieldShape;
        Object enabled2;
        boolean z;
        Object readOnly2;
        int i31;
        Object obj11;
        Object obj19;
        int textStyle2;
        Object obj13;
        Object obj2;
        int label2;
        Object rememberedValue;
        Object obj12;
        int placeholder2;
        int i22;
        int i46;
        int consume;
        VisualTransformation leadingIcon2;
        int i27;
        int $i$a$CacheTextFieldKt$TextField$7;
        KeyboardOptions trailingIcon2;
        Object obj9;
        int i39;
        KeyboardActions isError2;
        Object str;
        VisualTransformation visualTransformation2;
        int visualTransformation3;
        int i18;
        KeyboardOptions keyboardOptions3;
        int keyboardOptions4;
        int i49;
        int i28;
        KeyboardActions keyboardActions3;
        Object keyboardActions2;
        int changed5;
        int i40;
        Shape singleLine2;
        int i35;
        int i26;
        Object maxLines2;
        int i19;
        int i9;
        int i45;
        int i5;
        int i41;
        int changed2;
        int i20;
        Object i8;
        int changed6;
        int i11;
        int i15;
        int i7;
        Object obj18;
        int colors2;
        int i44;
        int i54;
        int i4;
        int i56;
        int i24;
        int changed;
        int i29;
        int changed3;
        int i53;
        int i6;
        int i55;
        int i47;
        int i36;
        int i17;
        int i30;
        int i25;
        boolean changed4;
        int i3;
        int i50;
        int i13;
        int i38;
        int i21;
        Composer $composer2;
        int i16;
        int i10;
        int i57;
        int i37;
        boolean z5;
        boolean z7;
        Object obj20;
        int i52;
        Object obj15;
        Object obj21;
        int i32;
        int i2;
        int i48;
        Object obj3;
        KeyboardOptions keyboardOptions2;
        int i51;
        int i33;
        Object obj16;
        Object obj22;
        int i12;
        ScopeUpdateScope scopeUpdateScope;
        KeyboardActions keyboardActions5;
        KeyboardActions obj73;
        int obj74;
        int obj75;
        int obj76;
        int obj77;
        int obj78;
        int obj79;
        int obj80;
        int obj81;
        int obj90;
        int i58 = $changed;
        int i69 = $changed1;
        i = i23;
        textFieldColors-dx8h9Zs = $composer.startRestartGroup(-1576622884);
        ComposerKt.sourceInformation(textFieldColors-dx8h9Zs, "C(TextField)P(17,10,9,1,12,15,6,11,7,16,3,18,5,4,14,8,2,13)434@20918L7,445@21472L39,446@21550L14,447@21614L17,449@21640L408:TextField.kt#jmzs0o");
        $dirty = $changed;
        $dirty12 = $changed1;
        if (i & 1 != 0) {
            $dirty |= 6;
            obj10 = value;
        } else {
            if (i58 & 6 == 0) {
                i31 = textFieldColors-dx8h9Zs.changed(value) ? 4 : 2;
                $dirty |= i31;
            } else {
                obj10 = value;
            }
        }
        if (i & 2 != 0) {
            $dirty |= 48;
            obj11 = onValueChange;
        } else {
            if (i58 & 48 == 0) {
                i22 = textFieldColors-dx8h9Zs.changedInstance(onValueChange) ? 32 : 16;
                $dirty |= i22;
            } else {
                obj11 = onValueChange;
            }
        }
        consume = i & 4;
        if (consume != 0) {
            $dirty |= 384;
            str = modifier;
        } else {
            if (i58 & 384 == 0) {
                i18 = textFieldColors-dx8h9Zs.changed(modifier) ? 256 : 128;
                $dirty |= i18;
            } else {
                str = modifier;
            }
        }
        int i143 = i & 8;
        changed5 = 1024;
        if (i143 != 0) {
            $dirty |= 3072;
            invalid$iv = enabled;
        } else {
            if (i58 & 3072 == 0) {
                i35 = textFieldColors-dx8h9Zs.changed(enabled) ? i49 : changed5;
                $dirty |= i35;
            } else {
                invalid$iv = enabled;
            }
        }
        int i147 = i & 16;
        i45 = 8192;
        if (i147 != 0) {
            $dirty |= 24576;
            z = readOnly;
        } else {
            if (i58 & 24576 == 0) {
                i7 = textFieldColors-dx8h9Zs.changed(readOnly) ? i19 : i45;
                $dirty |= i7;
            } else {
                z = readOnly;
            }
        }
        int i151 = 196608;
        i56 = 65536;
        i24 = 131072;
        if (i58 & i151 == 0) {
            if (i & 32 == 0) {
                changed = textFieldColors-dx8h9Zs.changed(textStyle) ? i24 : i56;
            } else {
                obj13 = textStyle;
            }
            $dirty |= changed;
        } else {
            obj13 = textStyle;
        }
        i29 = i & 64;
        final int i160 = 1572864;
        if (i29 != 0) {
            $dirty |= i160;
            rememberedValue = label;
        } else {
            if (i58 & i160 == 0) {
                i53 = textFieldColors-dx8h9Zs.changedInstance(label) ? 1048576 : 524288;
                $dirty |= i53;
            } else {
                rememberedValue = label;
            }
        }
        $i$a$CacheTextFieldKt$TextField$7 = i & 128;
        final int i154 = 12582912;
        if ($i$a$CacheTextFieldKt$TextField$7 != 0) {
            $dirty |= i154;
            obj9 = placeholder;
        } else {
            if (i58 & i154 == 0) {
                i55 = textFieldColors-dx8h9Zs.changedInstance(placeholder) ? 8388608 : 4194304;
                $dirty |= i55;
            } else {
                obj9 = placeholder;
            }
        }
        int i59 = i & 256;
        int i155 = 100663296;
        if (i59 != 0) {
            $dirty |= i155;
            i47 = i59;
            obj = leadingIcon;
        } else {
            if ($changed & i155 == 0) {
                i47 = i59;
                i36 = textFieldColors-dx8h9Zs.changedInstance(leadingIcon) ? 67108864 : 33554432;
                $dirty |= i36;
            } else {
                i47 = i59;
                obj = leadingIcon;
            }
        }
        int i60 = i & 512;
        int i157 = 805306368;
        if (i60 != 0) {
            $dirty |= i157;
            i17 = i60;
            obj4 = trailingIcon;
        } else {
            if ($changed & i157 == 0) {
                i17 = i60;
                i30 = textFieldColors-dx8h9Zs.changedInstance(trailingIcon) ? 536870912 : 268435456;
                $dirty |= i30;
            } else {
                i17 = i60;
                obj4 = trailingIcon;
            }
        }
        int i61 = i & 1024;
        if (i61 != 0) {
            $dirty12 |= 6;
            i25 = i61;
            z6 = isError;
        } else {
            if (i69 & 6 == 0) {
                i25 = i61;
                i11 = textFieldColors-dx8h9Zs.changed(isError) ? 4 : 2;
                $dirty12 |= i11;
            } else {
                i25 = i61;
                z6 = isError;
            }
        }
        int i62 = i & 2048;
        if (i62 != 0) {
            $dirty12 |= 48;
            i15 = i62;
            obj5 = visualTransformation;
        } else {
            if (i69 & 48 == 0) {
                i15 = i62;
                changed3 = textFieldColors-dx8h9Zs.changed(visualTransformation) ? 32 : 16;
                $dirty12 |= changed3;
            } else {
                i15 = i62;
                obj5 = visualTransformation;
            }
        }
        int i63 = i & 4096;
        if (i63 != 0) {
            $dirty12 |= 384;
            i54 = i63;
            obj17 = keyboardOptions;
        } else {
            i54 = i63;
            if (i69 & 384 == 0) {
                i53 = textFieldColors-dx8h9Zs.changed(keyboardOptions) ? 256 : 128;
                $dirty12 |= i53;
            } else {
                obj17 = keyboardOptions;
            }
        }
        if (i69 & 3072 == 0) {
            if (i & 8192 == 0) {
                if (textFieldColors-dx8h9Zs.changed(keyboardActions)) {
                } else {
                    i49 = changed5;
                }
            } else {
                obj7 = keyboardActions;
            }
            $dirty12 |= i49;
        } else {
            obj7 = keyboardActions;
        }
        int i66 = i & 16384;
        if (i66 != 0) {
            $dirty12 |= 24576;
            i28 = i66;
            z4 = singleLine;
        } else {
            i28 = i66;
            if (i69 & 24576 == 0) {
                if (textFieldColors-dx8h9Zs.changed(singleLine)) {
                } else {
                    i19 = i45;
                }
                $dirty12 |= i19;
            } else {
                z4 = singleLine;
            }
        }
        int i146 = i & i145;
        if (i146 != 0) {
            $dirty12 |= i151;
            i42 = maxLines;
        } else {
            if (i69 & i151 == 0) {
                i19 = textFieldColors-dx8h9Zs.changed(maxLines) ? i24 : i56;
                $dirty12 |= i19;
            } else {
                i42 = maxLines;
            }
        }
        i9 = i & i56;
        if (i9 != 0) {
            $dirty12 |= i160;
            obj6 = interactionSource;
        } else {
            if (i69 & i160 == 0) {
                i45 = textFieldColors-dx8h9Zs.changed(interactionSource) ? 1048576 : 524288;
                $dirty12 |= i45;
            } else {
                obj6 = interactionSource;
            }
        }
        if (i69 & i154 == 0) {
            if (i & i24 == 0) {
                i5 = textFieldColors-dx8h9Zs.changed(shape) ? 8388608 : 4194304;
            } else {
                obj14 = shape;
            }
            $dirty12 |= i5;
        } else {
            obj14 = shape;
        }
        int i152 = 262144;
        if (i69 & i155 == 0) {
            if (i & i152 == 0) {
                obj90 = $dirty12;
                i41 = textFieldColors-dx8h9Zs.changed(colors) ? 67108864 : 33554432;
            } else {
                obj90 = $dirty12;
                $dirty14 = colors;
            }
            keyboardActions4 = i20;
        } else {
            $dirty14 = colors;
            keyboardActions4 = obj90;
        }
        obj90 = $dirty;
        if ($dirty & i8 == 306783378 && i71 &= keyboardActions4 == 38347922) {
            if (i71 &= keyboardActions4 == 38347922) {
                if (!textFieldColors-dx8h9Zs.getSkipping()) {
                    textFieldColors-dx8h9Zs.startDefaults();
                    if ($changed & 1 != 0) {
                        if (textFieldColors-dx8h9Zs.getDefaultsInvalid()) {
                            if (consume != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = str;
                            }
                            z5 = i143 != 0 ? $dirty2 : invalid$iv;
                            z7 = i147 != 0 ? $dirty2 : z;
                            if (i & 32 != 0) {
                                int i129 = 6;
                                z = 0;
                                ComposerKt.sourceInformationMarkerStart(textFieldColors-dx8h9Zs, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                ComposerKt.sourceInformationMarkerEnd(textFieldColors-dx8h9Zs);
                                obj20 = this_$iv;
                                i52 = invalid$iv;
                            } else {
                                i52 = obj90;
                                obj20 = obj13;
                            }
                            obj15 = i29 != 0 ? this_$iv : rememberedValue;
                            obj21 = $i$a$CacheTextFieldKt$TextField$7 != 0 ? this_$iv : obj9;
                            i32 = i47 != 0 ? this_$iv : leadingIcon;
                            i2 = i17 != 0 ? this_$iv : trailingIcon;
                            i48 = i25 != 0 ? this_$iv : isError;
                            if (i15 != 0) {
                                obj3 = this_$iv;
                            } else {
                                obj3 = visualTransformation;
                            }
                            if (i54 != 0) {
                                keyboardOptions2 = this_$iv;
                            } else {
                                keyboardOptions2 = keyboardOptions;
                            }
                            if (i & 8192 != 0) {
                                super(0, 0, 0, 0, 0, 0, 63, 0);
                                $dirty13 = $dirty16;
                                $dirty1 = keyboardActions5;
                            } else {
                                $dirty13 = keyboardActions4;
                                $dirty1 = keyboardActions;
                            }
                            i51 = i28 != 0 ? invalid$iv : singleLine;
                            i33 = i146 != 0 ? invalid$iv : maxLines;
                            if (i9 != 0) {
                                ComposerKt.sourceInformationMarkerStart(textFieldColors-dx8h9Zs, -53648114, "CC(remember):TextField.kt#9igjgp");
                                int i128 = 0;
                                z = textFieldColors-dx8h9Zs;
                                obj13 = 0;
                                rememberedValue = z.rememberedValue();
                                consume = 0;
                                if (rememberedValue == Composer.Companion.getEmpty()) {
                                    int i140 = 0;
                                    z.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                                } else {
                                    $i$a$CacheTextFieldKt$TextField$7 = rememberedValue;
                                }
                                ComposerKt.sourceInformationMarkerEnd(textFieldColors-dx8h9Zs);
                                obj16 = invalid$iv;
                            } else {
                                obj16 = interactionSource;
                            }
                            if (i & i24 != 0) {
                                obj22 = textFieldShape;
                                i12 = $dirty13;
                            } else {
                                obj22 = shape;
                                i12 = $dirty13;
                            }
                            if (i & i152 != 0) {
                                keyboardActions3 = $dirty1;
                                obj8 = modifier3;
                                obj18 = textFieldColors-dx8h9Zs;
                                keyboardActions4 = $dirty15;
                                invalid$iv = z5;
                                z = z7;
                                obj19 = obj20;
                                modifier2 = i52;
                                obj2 = obj15;
                                obj12 = obj21;
                                i46 = i32;
                                i27 = i2;
                                i39 = i48;
                                visualTransformation2 = obj3;
                                keyboardOptions3 = keyboardOptions2;
                                i40 = i51;
                                i26 = i33;
                                i8 = obj16;
                                i15 = obj22;
                            } else {
                                $composer2 = textFieldColors-dx8h9Zs;
                                obj18 = colors;
                                keyboardActions3 = $dirty1;
                                obj8 = modifier3;
                                invalid$iv = z5;
                                z = z7;
                                obj19 = obj20;
                                modifier2 = i52;
                                obj2 = obj15;
                                obj12 = obj21;
                                i46 = i32;
                                i27 = i2;
                                i39 = i48;
                                visualTransformation2 = obj3;
                                keyboardOptions3 = keyboardOptions2;
                                i40 = i51;
                                i26 = i33;
                                i8 = obj16;
                                i15 = obj22;
                                keyboardActions4 = i12;
                            }
                        } else {
                            textFieldColors-dx8h9Zs.skipToGroupEnd();
                            $dirty15 = i & 32 != 0 ? obj90 & i14 : obj90;
                            if (i & 8192 != 0) {
                                keyboardActions4 &= -7169;
                            }
                            if (i & i24 != 0) {
                                keyboardActions4 &= i34;
                            }
                            if (i & i152 != 0) {
                                keyboardActions4 &= i43;
                            }
                            i46 = leadingIcon;
                            i27 = trailingIcon;
                            keyboardOptions3 = keyboardOptions;
                            keyboardActions3 = keyboardActions;
                            i40 = singleLine;
                            i26 = maxLines;
                            i8 = interactionSource;
                            i15 = shape;
                            $composer2 = textFieldColors-dx8h9Zs;
                            modifier2 = $dirty15;
                            obj18 = $dirty14;
                            obj19 = obj13;
                            obj2 = rememberedValue;
                            obj12 = obj9;
                            obj8 = str;
                            i39 = isError;
                            visualTransformation2 = visualTransformation;
                        }
                    } else {
                    }
                    $composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1576622884, modifier2, keyboardActions4, "androidx.compose.material.TextField (TextField.kt:448)");
                    }
                    TextFieldKt.TextField(value, onValueChange, obj8, invalid$iv, z, obj19, obj2, obj12, i46, i27, i39, visualTransformation2, keyboardOptions3, keyboardActions3, i40, i26, 1, i8, i15, obj18, $composer2, i81 | i105, i90 | i118, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i4 = modifier2;
                    $composer3 = obj8;
                    z2 = invalid$iv;
                    z3 = z;
                    modifier4 = obj19;
                    enabled2 = obj2;
                    readOnly2 = obj12;
                    textStyle2 = i46;
                    label2 = i27;
                    placeholder2 = i39;
                    leadingIcon2 = visualTransformation2;
                    trailingIcon2 = keyboardOptions3;
                    isError2 = keyboardActions3;
                    visualTransformation3 = i40;
                    keyboardOptions4 = i26;
                    keyboardActions2 = i8;
                    singleLine2 = i15;
                    maxLines2 = obj18;
                    colors2 = keyboardActions4;
                } else {
                    textFieldColors-dx8h9Zs.skipToGroupEnd();
                    textStyle2 = leadingIcon;
                    leadingIcon2 = visualTransformation;
                    trailingIcon2 = keyboardOptions;
                    keyboardOptions4 = maxLines;
                    keyboardActions2 = interactionSource;
                    singleLine2 = shape;
                    i4 = obj90;
                    $composer2 = textFieldColors-dx8h9Zs;
                    maxLines2 = $dirty14;
                    z2 = invalid$iv;
                    z3 = z;
                    modifier4 = obj13;
                    enabled2 = rememberedValue;
                    readOnly2 = obj9;
                    $composer3 = str;
                    label2 = trailingIcon;
                    placeholder2 = isError;
                    isError2 = keyboardActions;
                    visualTransformation3 = singleLine;
                    colors2 = keyboardActions4;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new TextFieldKt.TextField.8(value, onValueChange, $composer3, z2, z3, modifier4, enabled2, readOnly2, textStyle2, label2, placeholder2, leadingIcon2, trailingIcon2, isError2, visualTransformation3, keyboardOptions4, keyboardActions2, singleLine2, maxLines2, $changed, $changed1, i);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    public static final void TextField(String value, Function1<? super String, Unit> onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> label, Function2<? super Composer, ? super Integer, Unit> placeholder, Function2<? super Composer, ? super Integer, Unit> leadingIcon, Function2<? super Composer, ? super Integer, Unit> trailingIcon, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, int minLines, MutableInteractionSource interactionSource, Shape shape, androidx.compose.material.TextFieldColors colors, Composer $composer, int $changed, int $changed1, int i24) {
        Object obj7;
        Object obj13;
        boolean z;
        Object obj11;
        Object obj3;
        Object obj18;
        boolean z3;
        int i47;
        int i18;
        Object obj21;
        Object obj16;
        int $dirty18;
        Object $dirty16;
        Object $dirty14;
        Object endRestartGroup;
        int skipping;
        int $dirty4;
        int $dirty;
        int $dirty13;
        int defaultsInvalid;
        Object modifier2;
        int $i$a$CacheTextFieldKt$TextField$interactionSource$1;
        boolean traceInProgress;
        int $composer3;
        int i49;
        Object $composer2;
        int $dirty2;
        int $dirty3;
        int i54;
        int i55;
        Object textFieldColors-dx8h9Zs;
        int default;
        int $dirty15;
        boolean z4;
        int $dirty1;
        Object $dirty17;
        Composer composer3;
        boolean z7;
        Object obj5;
        int i95;
        Object obj15;
        boolean str;
        int i3;
        int i70;
        int textFieldShape;
        Object enabled2;
        boolean z2;
        Object readOnly2;
        int i11;
        Object obj12;
        boolean traceInProgress2;
        int value2;
        int i93;
        Object obj4;
        KeyboardOptions i59;
        int keyboardOptions2;
        Object visualTransformation2;
        Object shape2;
        int keyboardActions2;
        int i72;
        int field;
        int i27;
        VisualTransformation singleLine2;
        int obj;
        int i28;
        KeyboardOptions maxLines2;
        Object obj10;
        int obj20;
        KeyboardActions minLines2;
        Object obj14;
        int visualTransformation3;
        int i57;
        int i10;
        int i100;
        int i36;
        int i29;
        int i76;
        int changed6;
        int i16;
        int changed5;
        int i5;
        long $this$takeOrElse_u2dDxMtmZc$iv;
        int i99;
        int i96;
        int companion;
        Shape shape3;
        int i90;
        int i42;
        long unbox-impl;
        Object field2;
        int i31;
        int i48;
        int i75;
        int i84;
        int i81;
        int changed2;
        int i4;
        int i33;
        int i44;
        int i66;
        int i61;
        int $dirty12;
        int i62;
        int changed3;
        int changed4;
        int i64;
        int i6;
        int changed;
        int i83;
        int i80;
        int i58;
        int i78;
        int i34;
        int i17;
        int i85;
        int i82;
        int i101;
        boolean changed7;
        int i46;
        int i69;
        int i60;
        int i32;
        int i63;
        int i8;
        int i89;
        int i94;
        int i37;
        int i87;
        int i71;
        int i88;
        int i45;
        Composer composer2;
        Composer composer;
        int i23;
        int i67;
        int i12;
        int i35;
        boolean z6;
        boolean z5;
        Object obj9;
        int i79;
        Object obj6;
        Object obj17;
        int i73;
        int obj8;
        int obj19;
        int i51;
        VisualTransformation i53;
        KeyboardOptions keyboardOptions3;
        int i21;
        int i;
        int i13;
        int modifier3;
        Shape obj2;
        int i50;
        int i15;
        TextStyle textStyle2;
        long l;
        int i98;
        int i97;
        int i14;
        int i38;
        int i19;
        int i9;
        int i41;
        int i56;
        int i68;
        int i65;
        int i25;
        int i39;
        int i40;
        int i30;
        int i92;
        int i74;
        int i22;
        int i7;
        int i43;
        int i86;
        int i91;
        int i26;
        int i77;
        int i2;
        int i20;
        ScopeUpdateScope scopeUpdateScope;
        int i52;
        Object obj106;
        int obj107;
        int obj108;
        int obj109;
        int obj110;
        int obj111;
        int obj112;
        int obj113;
        int obj114;
        int obj115;
        int obj116;
        Shape obj117;
        androidx.compose.material.TextFieldColors obj118;
        Object obj119;
        Object obj120;
        Modifier obj121;
        int obj124;
        int i102 = $changed;
        int i114 = $changed1;
        traceInProgress = i24;
        Composer restartGroup = $composer.startRestartGroup(-1504264404);
        ComposerKt.sourceInformation(restartGroup, "C(TextField)P(18,11,10,1,13,16,6,12,7,17,3,19,5,4,15,8,9,2,14)165@8582L7,178@9226L14,179@9290L17,194@9914L38,203@10281L20,211@10623L719,190@9731L1617:TextField.kt#jmzs0o");
        $dirty2 = $changed;
        $dirty1 = $changed1;
        if (traceInProgress & 1 != 0) {
            $dirty2 |= 6;
            obj5 = value;
        } else {
            if (i102 & 6 == 0) {
                i11 = restartGroup.changed(value) ? 4 : 2;
                $dirty2 |= i11;
            } else {
                obj5 = value;
            }
        }
        if (traceInProgress & 2 != 0) {
            $dirty2 |= 48;
            obj12 = onValueChange;
        } else {
            if (i102 & 48 == 0) {
                i72 = restartGroup.changedInstance(onValueChange) ? 32 : 16;
                $dirty2 |= i72;
            } else {
                obj12 = onValueChange;
            }
        }
        i27 = traceInProgress & 4;
        if (i27 != 0) {
            $dirty2 |= 384;
            obj14 = modifier;
        } else {
            if (i102 & 384 == 0) {
                i57 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty2 |= i57;
            } else {
                obj14 = modifier;
            }
        }
        i10 = traceInProgress & 8;
        changed6 = 1024;
        if (i10 != 0) {
            $dirty2 |= 3072;
            str = enabled;
        } else {
            if (i102 & 3072 == 0) {
                i96 = restartGroup.changed(enabled) ? i36 : changed6;
                $dirty2 |= i96;
            } else {
                str = enabled;
            }
        }
        companion = traceInProgress & 16;
        if (companion != 0) {
            $dirty2 |= 24576;
            z2 = readOnly;
        } else {
            if (i102 & 24576 == 0) {
                i75 = restartGroup.changed(readOnly) ? 16384 : i90;
                $dirty2 |= i75;
            } else {
                z2 = readOnly;
            }
        }
        if (i102 & i210 == 0) {
            if (traceInProgress & 32 == 0) {
                changed2 = restartGroup.changed(textStyle) ? 131072 : 65536;
            } else {
                obj4 = textStyle;
            }
            $dirty2 |= changed2;
        } else {
            obj4 = textStyle;
        }
        i4 = traceInProgress & 64;
        i33 = 1572864;
        i64 = 524288;
        if (i4 != 0) {
            $dirty2 |= i33;
            visualTransformation2 = label;
        } else {
            if (i102 & i33 == 0) {
                i83 = restartGroup.changedInstance(label) ? 1048576 : i64;
                $dirty2 |= i83;
            } else {
                visualTransformation2 = label;
            }
        }
        i28 = traceInProgress & 128;
        i80 = 12582912;
        if (i28 != 0) {
            $dirty2 |= i80;
            obj10 = placeholder;
        } else {
            if (i102 & i80 == 0) {
                i78 = restartGroup.changedInstance(placeholder) ? 8388608 : 4194304;
                $dirty2 |= i78;
            } else {
                obj10 = placeholder;
            }
        }
        int i103 = traceInProgress & 256;
        int i219 = 100663296;
        if (i103 != 0) {
            $dirty2 |= i219;
            i34 = i103;
            obj7 = leadingIcon;
        } else {
            if ($changed & i219 == 0) {
                i34 = i103;
                i17 = restartGroup.changedInstance(leadingIcon) ? 67108864 : 33554432;
                $dirty2 |= i17;
            } else {
                i34 = i103;
                obj7 = leadingIcon;
            }
        }
        int i104 = traceInProgress & 512;
        int i221 = 805306368;
        if (i104 != 0) {
            $dirty2 |= i221;
            i85 = i104;
            obj13 = trailingIcon;
        } else {
            if ($changed & i221 == 0) {
                i85 = i104;
                i82 = restartGroup.changedInstance(trailingIcon) ? 536870912 : 268435456;
                $dirty2 |= i82;
            } else {
                i85 = i104;
                obj13 = trailingIcon;
            }
        }
        int i105 = traceInProgress & 1024;
        if (i105 != 0) {
            $dirty1 |= 6;
            i101 = i105;
            z = isError;
        } else {
            if (i114 & 6 == 0) {
                i101 = i105;
                i31 = restartGroup.changed(isError) ? 4 : 2;
                $dirty1 |= i31;
            } else {
                i101 = i105;
                z = isError;
            }
        }
        int i106 = traceInProgress & 2048;
        if (i106 != 0) {
            $dirty1 |= 48;
            i48 = i106;
            obj11 = visualTransformation;
        } else {
            if (i114 & 48 == 0) {
                i48 = i106;
                changed = restartGroup.changed(visualTransformation) ? 32 : 16;
                $dirty1 |= changed;
            } else {
                i48 = i106;
                obj11 = visualTransformation;
            }
        }
        int i107 = traceInProgress & 4096;
        if (i107 != 0) {
            $dirty1 |= 384;
            i81 = i107;
            obj3 = keyboardOptions;
        } else {
            i81 = i107;
            if (i114 & 384 == 0) {
                i83 = restartGroup.changed(keyboardOptions) ? 256 : 128;
                $dirty1 |= i83;
            } else {
                obj3 = keyboardOptions;
            }
        }
        if (i114 & 3072 == 0) {
            if (traceInProgress & 8192 == 0) {
                if (restartGroup.changed(keyboardActions)) {
                } else {
                    i36 = changed6;
                }
            } else {
                obj18 = keyboardActions;
            }
            $dirty1 |= i36;
        } else {
            obj18 = keyboardActions;
        }
        int i110 = traceInProgress & 16384;
        if (i110 != 0) {
            $dirty1 |= 24576;
            i29 = i110;
            z3 = singleLine;
        } else {
            i29 = i110;
            if (i114 & 24576 == 0) {
                if (restartGroup.changed(singleLine)) {
                    i90 = 16384;
                }
                $dirty1 |= i90;
            } else {
                z3 = singleLine;
            }
        }
        if (i114 & i200 == 0) {
            if (traceInProgress & i201 == 0) {
                i16 = restartGroup.changed(maxLines) ? 131072 : 65536;
            } else {
                i47 = maxLines;
            }
            $dirty1 |= i16;
        } else {
            i47 = maxLines;
        }
        i5 = traceInProgress & i202;
        if (i5 != 0) {
            $dirty1 |= i33;
            i18 = minLines;
        } else {
            if (i114 & i33 == 0) {
                i90 = restartGroup.changed(minLines) ? 1048576 : i64;
                $dirty1 |= i90;
            } else {
                i18 = minLines;
            }
        }
        i42 = traceInProgress & i206;
        if (i42 != 0) {
            $dirty1 |= i80;
            obj21 = interactionSource;
        } else {
            if (i114 & i80 == 0) {
                i33 = restartGroup.changed(interactionSource) ? 8388608 : 4194304;
                $dirty1 |= i33;
            } else {
                obj21 = interactionSource;
            }
        }
        if (i114 & i213 == 0) {
            if (traceInProgress & i215 == 0) {
                i44 = restartGroup.changed(shape) ? 67108864 : 33554432;
            } else {
                obj16 = shape;
            }
            $dirty1 |= i44;
        } else {
            obj16 = shape;
        }
        if (i114 & i214 == 0) {
            if (traceInProgress & i64 == 0) {
                obj124 = $dirty1;
                i62 = restartGroup.changed(colors) ? 536870912 : 268435456;
            } else {
                obj124 = $dirty1;
                $dirty17 = colors;
            }
            $dirty18 = i66;
        } else {
            $dirty17 = colors;
            $dirty18 = obj124;
        }
        obj124 = $dirty2;
        if ($dirty2 & i61 == 306783378 && i128 &= $dirty18 == 306783378) {
            if (i128 &= $dirty18 == 306783378) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    default = -458753;
                    int i160 = 6;
                    int i163 = 1;
                    if ($changed & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if (i27 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = obj14;
                            }
                            z6 = i10 != 0 ? str : str;
                            z5 = companion != 0 ? str : z2;
                            if (traceInProgress & 32 != 0) {
                                z2 = 6;
                                i27 = 0;
                                ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                                obj9 = default;
                                i79 = i3;
                            } else {
                                i10 = default;
                                i79 = obj124;
                                obj9 = obj4;
                            }
                            obj6 = i4 != 0 ? default : visualTransformation2;
                            obj17 = i28 != 0 ? default : obj10;
                            i73 = i34 != 0 ? default : leadingIcon;
                            obj8 = i85 != 0 ? default : trailingIcon;
                            obj19 = i101 != 0 ? default : isError;
                            if (i48 != 0) {
                                i53 = default;
                            } else {
                                i53 = visualTransformation;
                            }
                            if (i81 != 0) {
                                keyboardOptions3 = default;
                            } else {
                                keyboardOptions3 = keyboardOptions;
                            }
                            if (traceInProgress & 8192 != 0) {
                                super(0, 0, 0, 0, 0, 0, 63, 0);
                                $dirty15 = $dirty19;
                                $dirty14 = i52;
                            } else {
                                $dirty15 = $dirty18;
                                $dirty14 = keyboardActions;
                            }
                            i21 = i29 != 0 ? i3 : singleLine;
                            if (i167 &= traceInProgress != 0) {
                                i70 = i21 != 0 ? i163 : 0x7fffffff /* Unknown resource */;
                                $dirty15 &= i10;
                                i = i70;
                            } else {
                                i = maxLines;
                            }
                            i13 = i5 != 0 ? i70 : minLines;
                            modifier3 = i42 != 0 ? i70 : interactionSource;
                            if (i168 &= traceInProgress != 0) {
                                obj2 = textFieldShape;
                                i50 = $dirty15;
                            } else {
                                obj2 = shape;
                                i50 = $dirty15;
                            }
                            if (traceInProgress & i64 != 0) {
                                int i172 = i163;
                                int i179 = i169;
                                int i185 = i179;
                                int i188 = i180;
                                i10 = i188;
                                i5 = i10;
                                i42 = i5;
                                i81 = i42;
                                i61 = i81;
                                changed = i61;
                                i80 = changed;
                                i34 = i80;
                                i101 = i34;
                                i46 = i101;
                                i60 = i46;
                                i63 = i60;
                                i89 = i63;
                                i37 = i89;
                                i71 = i37;
                                i45 = i71;
                                i15 = i234;
                                composer2 = restartGroup;
                                $composer3 = i52;
                                textFieldColors-dx8h9Zs = TextFieldDefaults.INSTANCE.textFieldColors-dx8h9Zs(0, i163, 0, i172, 0, i179, 0, i185, 0, i188, 0, i10, 0, i5, 0, i42, 0, i81, 0, i61, 0, changed, 0, i80, 0, i34);
                                composer3 = composer2;
                                shape2 = $dirty14;
                                obj14 = modifier2;
                                $dirty = i165;
                                str = z6;
                                z2 = z5;
                                $dirty16 = obj9;
                                i95 = i79;
                                i59 = keyboardOptions3;
                                field = i21;
                                obj = i;
                                obj20 = i13;
                            } else {
                                composer3 = restartGroup;
                                $composer3 = i52;
                                textFieldColors-dx8h9Zs = colors;
                                shape2 = $dirty14;
                                obj14 = modifier2;
                                str = z6;
                                z2 = z5;
                                $dirty16 = obj9;
                                i95 = i79;
                                i59 = keyboardOptions3;
                                field = i21;
                                obj = i;
                                obj20 = i13;
                                $dirty = i50;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            $dirty4 = traceInProgress & 32 != 0 ? obj124 & default : obj124;
                            if (traceInProgress & 8192 != 0) {
                                $dirty18 &= -7169;
                            }
                            if (i183 &= traceInProgress != 0) {
                                $dirty18 &= default;
                            }
                            if (i156 &= traceInProgress != 0) {
                                $dirty18 &= i54;
                            }
                            if (traceInProgress & i64 != 0) {
                                $dirty18 &= i55;
                            }
                            composer3 = restartGroup;
                            $composer3 = i157;
                            i73 = leadingIcon;
                            obj8 = trailingIcon;
                            obj19 = isError;
                            i53 = visualTransformation;
                            field = singleLine;
                            obj = maxLines;
                            modifier3 = interactionSource;
                            obj2 = shape;
                            textFieldColors-dx8h9Zs = colors;
                            i95 = $dirty4;
                            obj6 = visualTransformation2;
                            obj17 = obj10;
                            shape2 = keyboardActions;
                            obj20 = minLines;
                            $dirty = $dirty18;
                            $dirty16 = obj4;
                            i59 = keyboardOptions;
                        }
                    } else {
                    }
                    composer3.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1504264404, i95, $dirty, "androidx.compose.material.TextField (TextField.kt:180)");
                    }
                    if (modifier3 == 0) {
                        composer3.startReplaceGroup(-1675073900);
                        ComposerKt.sourceInformation(composer3, "182@9393L39");
                        ComposerKt.sourceInformationMarkerStart(composer3, -54034642, "CC(remember):TextField.kt#9igjgp");
                        $composer3 = 0;
                        traceInProgress2 = composer3;
                        i10 = 0;
                        $dirty12 = $dirty;
                        $dirty13 = traceInProgress2.rememberedValue();
                        i5 = 0;
                        if ($dirty13 == Composer.Companion.getEmpty()) {
                            int i146 = 0;
                            traceInProgress2.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                        } else {
                            $i$a$CacheTextFieldKt$TextField$interactionSource$1 = $dirty13;
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endReplaceGroup();
                    } else {
                        $dirty12 = $dirty;
                        composer3.startReplaceGroup(-54035293);
                        composer3.endReplaceGroup();
                        $i$a$CacheTextFieldKt$TextField$interactionSource$1 = modifier3;
                    }
                    composer3.startReplaceGroup(-54029535);
                    ComposerKt.sourceInformation(composer3, "*185@9580L18");
                    int i117 = 0;
                    i49 = 0;
                    value2 = Long.compare(unbox-impl, i211) != 0 ? 1 : 0;
                    if (value2 != null) {
                    } else {
                        i49 = 0;
                        $this$takeOrElse_u2dDxMtmZc$iv = unbox-impl;
                    }
                    composer3.endReplaceGroup();
                    textStyle2 = new TextStyle($this$takeOrElse_u2dDxMtmZc$iv, obj72, 0, obj74, 0, 0, 0, 0, 0, 0, obj81, 0, 0, 0, 0, obj86, 0, 0, 0, 0, 0, 0, obj93, 0, 0, 0, 0, 0, 0, 16777214, 0);
                    obj108 = str;
                    obj107 = obj14;
                    obj109 = obj19;
                    Object obj22 = obj107;
                    int i189 = obj109;
                    obj111 = $i$a$CacheTextFieldKt$TextField$interactionSource$1;
                    SolidColor solidColor = new SolidColor((Color)textFieldColors-dx8h9Zs.cursorColor(i189, composer3, i129 |= i195).getValue().unbox-impl(), obj22, 0);
                    obj106 = anon;
                    obj118 = textFieldColors-dx8h9Zs;
                    obj112 = i189;
                    obj110 = i53;
                    super(value, obj108, field, obj110, obj111, obj112, obj6, obj17, i73, obj8, obj2, obj118);
                    VisualTransformation visualTransformation5 = obj110;
                    Composer composer4 = composer3;
                    BasicTextFieldKt.BasicTextField(value, onValueChange, SizeKt.defaultMinSize-VpY3zN4(TextFieldImplKt.defaultErrorSemantics(TextFieldDefaults.indicatorLine-gv0btCI$default(TextFieldDefaults.INSTANCE, obj107, obj108, obj109, (InteractionSource)$i$a$CacheTextFieldKt$TextField$interactionSource$1, textFieldColors-dx8h9Zs, 0, 0, 48, 0), i189, Strings_androidKt.getString-4foXLRw(Strings.Companion.getDefaultErrorMessage-UdPEhr4(), composer3, 6)), TextFieldDefaults.INSTANCE.getMinWidth-D9Ej5fM(), TextFieldDefaults.INSTANCE.getMinHeight-D9Ej5fM()), str, z2, $dirty16.merge(textStyle2), i59, shape2, field, obj, obj20, visualTransformation5, 0, obj111, (Brush)solidColor, (Function3)ComposableLambdaKt.rememberComposableLambda(989834338, true, obj106, composer3, 54), composer4, i124 | i143, i127 | i145, 4096);
                    composer = composer4;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    visualTransformation3 = field;
                    singleLine2 = visualTransformation4;
                    obj15 = obj119;
                    $composer2 = obj120;
                    field2 = $dirty18;
                    i6 = skipping;
                    z4 = str;
                    z7 = z2;
                    i100 = obj;
                    i76 = obj20;
                    enabled2 = obj6;
                    readOnly2 = obj17;
                    i93 = i73;
                    i99 = modifier3;
                    shape3 = obj2;
                    maxLines2 = i59;
                    minLines2 = shape2;
                    keyboardOptions2 = obj8;
                    keyboardActions2 = i51;
                } else {
                    restartGroup.skipToGroupEnd();
                    i93 = leadingIcon;
                    singleLine2 = visualTransformation;
                    maxLines2 = keyboardOptions;
                    i100 = maxLines;
                    i76 = minLines;
                    i99 = interactionSource;
                    shape3 = shape;
                    i6 = obj124;
                    $dirty12 = $dirty18;
                    composer = restartGroup;
                    field2 = $dirty17;
                    z4 = str;
                    z7 = z2;
                    obj15 = obj4;
                    enabled2 = visualTransformation2;
                    readOnly2 = obj10;
                    $composer2 = obj14;
                    keyboardOptions2 = trailingIcon;
                    keyboardActions2 = isError;
                    minLines2 = keyboardActions;
                    visualTransformation3 = singleLine;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new TextFieldKt.TextField.2(value, onValueChange, $composer2, z4, z7, obj15, enabled2, readOnly2, i93, keyboardOptions2, keyboardActions2, singleLine2, maxLines2, minLines2, visualTransformation3, i100, i76, i99, shape3, field2, $changed, $changed1, i24);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    public static final void TextField(String value, Function1 onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2 label, Function2 placeholder, Function2 leadingIcon, Function2 trailingIcon, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, MutableInteractionSource interactionSource, Shape shape, androidx.compose.material.TextFieldColors colors, Composer $composer, int $changed, int $changed1, int i23) {
        Object obj14;
        Object obj;
        boolean z3;
        Object obj10;
        Object obj16;
        Object obj4;
        boolean z;
        int i20;
        Object obj15;
        Object obj6;
        int keyboardActions3;
        Object $dirty14;
        Object endRestartGroup;
        int modifier2;
        int defaultsInvalid;
        Object modifier3;
        int i56;
        int i46;
        int i29;
        int i35;
        Object textFieldColors-dx8h9Zs;
        boolean traceInProgress;
        Object $composer2;
        int $dirty;
        int $dirty2;
        int $dirty12;
        int this_$iv;
        int $dirty13;
        boolean z7;
        int $dirty15;
        Object $dirty1;
        boolean z6;
        Object obj7;
        Object obj11;
        Object modifier4;
        boolean invalid$iv;
        int copy$default;
        Object enabled2;
        boolean z5;
        Object readOnly2;
        int i25;
        Object obj9;
        Object obj13;
        int textStyle2;
        Object zeroCornerSize;
        Object obj5;
        int label2;
        Object rememberedValue;
        Object obj20;
        int placeholder2;
        int i28;
        int i16;
        int consume;
        VisualTransformation leadingIcon2;
        int i11;
        int $i$a$CacheTextFieldKt$TextField$3;
        KeyboardOptions trailingIcon2;
        Object obj3;
        int i22;
        KeyboardActions isError2;
        Object str;
        VisualTransformation visualTransformation3;
        int visualTransformation2;
        int i6;
        KeyboardOptions keyboardOptions2;
        int keyboardOptions3;
        int i57;
        int i55;
        KeyboardActions keyboardActions4;
        Object keyboardActions2;
        int changed2;
        int i41;
        CornerBasedShape singleLine2;
        int i30;
        int i18;
        Object maxLines2;
        int i2;
        int i36;
        int i27;
        int i47;
        int i53;
        int changed5;
        int i26;
        Object i15;
        int changed4;
        int i49;
        int i21;
        int i14;
        Object obj19;
        int colors2;
        int i17;
        int i50;
        int i24;
        int i9;
        int i32;
        int changed6;
        int i31;
        int changed3;
        int i52;
        int i3;
        int i4;
        int i37;
        int i19;
        int i;
        int i44;
        int i7;
        boolean changed;
        int i38;
        int i54;
        int i33;
        int i48;
        int i40;
        Composer $composer3;
        int i10;
        int i34;
        int i42;
        int i12;
        boolean z2;
        boolean z4;
        Object obj8;
        int i8;
        Object obj12;
        Object obj18;
        int i39;
        int i5;
        int i43;
        Object obj21;
        KeyboardOptions keyboardOptions4;
        int i51;
        int i13;
        Object obj2;
        Object obj17;
        int i45;
        ScopeUpdateScope scopeUpdateScope;
        KeyboardActions keyboardActions5;
        Object obj73;
        int obj74;
        int obj75;
        int obj76;
        int obj77;
        int obj78;
        int obj79;
        int obj80;
        int obj81;
        int obj90;
        int i58 = $changed;
        int i69 = $changed1;
        i35 = i23;
        textFieldColors-dx8h9Zs = $composer.startRestartGroup(-1690895095);
        ComposerKt.sourceInformation(textFieldColors-dx8h9Zs, "C(TextField)P(17,10,9,1,12,15,6,11,7,16,3,18,5,4,14,8,2,13)243@11701L7,254@12255L39,256@12337L6,257@12462L17,259@12488L408:TextField.kt#jmzs0o");
        $dirty = $changed;
        $dirty15 = $changed1;
        if (i35 & 1 != 0) {
            $dirty |= 6;
            obj7 = value;
        } else {
            if (i58 & 6 == 0) {
                i25 = textFieldColors-dx8h9Zs.changed(value) ? 4 : 2;
                $dirty |= i25;
            } else {
                obj7 = value;
            }
        }
        if (i35 & 2 != 0) {
            $dirty |= 48;
            obj9 = onValueChange;
        } else {
            if (i58 & 48 == 0) {
                i28 = textFieldColors-dx8h9Zs.changedInstance(onValueChange) ? 32 : 16;
                $dirty |= i28;
            } else {
                obj9 = onValueChange;
            }
        }
        consume = i35 & 4;
        if (consume != 0) {
            $dirty |= 384;
            str = modifier;
        } else {
            if (i58 & 384 == 0) {
                i6 = textFieldColors-dx8h9Zs.changed(modifier) ? 256 : 128;
                $dirty |= i6;
            } else {
                str = modifier;
            }
        }
        int i143 = i35 & 8;
        changed2 = 1024;
        if (i143 != 0) {
            $dirty |= 3072;
            invalid$iv = enabled;
        } else {
            if (i58 & 3072 == 0) {
                i30 = textFieldColors-dx8h9Zs.changed(enabled) ? i57 : changed2;
                $dirty |= i30;
            } else {
                invalid$iv = enabled;
            }
        }
        int i147 = i35 & 16;
        i27 = 8192;
        if (i147 != 0) {
            $dirty |= 24576;
            z5 = readOnly;
        } else {
            if (i58 & 24576 == 0) {
                i14 = textFieldColors-dx8h9Zs.changed(readOnly) ? i2 : i27;
                $dirty |= i14;
            } else {
                z5 = readOnly;
            }
        }
        int i151 = 196608;
        i9 = 65536;
        i32 = 131072;
        if (i58 & i151 == 0) {
            if (i35 & 32 == 0) {
                changed6 = textFieldColors-dx8h9Zs.changed(textStyle) ? i32 : i9;
            } else {
                zeroCornerSize = textStyle;
            }
            $dirty |= changed6;
        } else {
            zeroCornerSize = textStyle;
        }
        i31 = i35 & 64;
        final int i160 = 1572864;
        if (i31 != 0) {
            $dirty |= i160;
            rememberedValue = label;
        } else {
            if (i58 & i160 == 0) {
                i52 = textFieldColors-dx8h9Zs.changedInstance(label) ? 1048576 : 524288;
                $dirty |= i52;
            } else {
                rememberedValue = label;
            }
        }
        $i$a$CacheTextFieldKt$TextField$3 = i35 & 128;
        final int i154 = 12582912;
        if ($i$a$CacheTextFieldKt$TextField$3 != 0) {
            $dirty |= i154;
            obj3 = placeholder;
        } else {
            if (i58 & i154 == 0) {
                i4 = textFieldColors-dx8h9Zs.changedInstance(placeholder) ? 8388608 : 4194304;
                $dirty |= i4;
            } else {
                obj3 = placeholder;
            }
        }
        int i59 = i35 & 256;
        int i155 = 100663296;
        if (i59 != 0) {
            $dirty |= i155;
            i37 = i59;
            obj14 = leadingIcon;
        } else {
            if ($changed & i155 == 0) {
                i37 = i59;
                i19 = textFieldColors-dx8h9Zs.changedInstance(leadingIcon) ? 67108864 : 33554432;
                $dirty |= i19;
            } else {
                i37 = i59;
                obj14 = leadingIcon;
            }
        }
        int i60 = i35 & 512;
        int i157 = 805306368;
        if (i60 != 0) {
            $dirty |= i157;
            i = i60;
            obj = trailingIcon;
        } else {
            if ($changed & i157 == 0) {
                i = i60;
                i44 = textFieldColors-dx8h9Zs.changedInstance(trailingIcon) ? 536870912 : 268435456;
                $dirty |= i44;
            } else {
                i = i60;
                obj = trailingIcon;
            }
        }
        int i61 = i35 & 1024;
        if (i61 != 0) {
            $dirty15 |= 6;
            i7 = i61;
            z3 = isError;
        } else {
            if (i69 & 6 == 0) {
                i7 = i61;
                i49 = textFieldColors-dx8h9Zs.changed(isError) ? 4 : 2;
                $dirty15 |= i49;
            } else {
                i7 = i61;
                z3 = isError;
            }
        }
        int i62 = i35 & 2048;
        if (i62 != 0) {
            $dirty15 |= 48;
            i21 = i62;
            obj10 = visualTransformation;
        } else {
            if (i69 & 48 == 0) {
                i21 = i62;
                changed3 = textFieldColors-dx8h9Zs.changed(visualTransformation) ? 32 : 16;
                $dirty15 |= changed3;
            } else {
                i21 = i62;
                obj10 = visualTransformation;
            }
        }
        int i63 = i35 & 4096;
        if (i63 != 0) {
            $dirty15 |= 384;
            i50 = i63;
            obj16 = keyboardOptions;
        } else {
            i50 = i63;
            if (i69 & 384 == 0) {
                i52 = textFieldColors-dx8h9Zs.changed(keyboardOptions) ? 256 : 128;
                $dirty15 |= i52;
            } else {
                obj16 = keyboardOptions;
            }
        }
        if (i69 & 3072 == 0) {
            if (i35 & 8192 == 0) {
                if (textFieldColors-dx8h9Zs.changed(keyboardActions)) {
                } else {
                    i57 = changed2;
                }
            } else {
                obj4 = keyboardActions;
            }
            $dirty15 |= i57;
        } else {
            obj4 = keyboardActions;
        }
        int i66 = i35 & 16384;
        if (i66 != 0) {
            $dirty15 |= 24576;
            i55 = i66;
            z = singleLine;
        } else {
            i55 = i66;
            if (i69 & 24576 == 0) {
                if (textFieldColors-dx8h9Zs.changed(singleLine)) {
                } else {
                    i2 = i27;
                }
                $dirty15 |= i2;
            } else {
                z = singleLine;
            }
        }
        int i146 = i35 & i145;
        if (i146 != 0) {
            $dirty15 |= i151;
            i20 = maxLines;
        } else {
            if (i69 & i151 == 0) {
                i2 = textFieldColors-dx8h9Zs.changed(maxLines) ? i32 : i9;
                $dirty15 |= i2;
            } else {
                i20 = maxLines;
            }
        }
        i36 = i35 & i9;
        if (i36 != 0) {
            $dirty15 |= i160;
            obj15 = interactionSource;
        } else {
            if (i69 & i160 == 0) {
                i27 = textFieldColors-dx8h9Zs.changed(interactionSource) ? 1048576 : 524288;
                $dirty15 |= i27;
            } else {
                obj15 = interactionSource;
            }
        }
        if (i69 & i154 == 0) {
            if (i35 & i32 == 0) {
                i47 = textFieldColors-dx8h9Zs.changed(shape) ? 8388608 : 4194304;
            } else {
                obj6 = shape;
            }
            $dirty15 |= i47;
        } else {
            obj6 = shape;
        }
        int i152 = 262144;
        if (i69 & i155 == 0) {
            if (i35 & i152 == 0) {
                obj90 = $dirty15;
                i53 = textFieldColors-dx8h9Zs.changed(colors) ? 67108864 : 33554432;
            } else {
                obj90 = $dirty15;
                $dirty1 = colors;
            }
            keyboardActions3 = i26;
        } else {
            $dirty1 = colors;
            keyboardActions3 = obj90;
        }
        obj90 = $dirty;
        if ($dirty & i15 == 306783378 && i71 &= keyboardActions3 == 38347922) {
            if (i71 &= keyboardActions3 == 38347922) {
                if (!textFieldColors-dx8h9Zs.getSkipping()) {
                    textFieldColors-dx8h9Zs.startDefaults();
                    if ($changed & 1 != 0) {
                        if (textFieldColors-dx8h9Zs.getDefaultsInvalid()) {
                            if (consume != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = str;
                            }
                            z2 = i143 != 0 ? $dirty2 : invalid$iv;
                            z4 = i147 != 0 ? $dirty2 : z5;
                            if (i35 & 32 != 0) {
                                int i129 = 6;
                                z5 = 0;
                                ComposerKt.sourceInformationMarkerStart(textFieldColors-dx8h9Zs, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                ComposerKt.sourceInformationMarkerEnd(textFieldColors-dx8h9Zs);
                                obj8 = this_$iv;
                                i8 = invalid$iv;
                            } else {
                                i8 = obj90;
                                obj8 = zeroCornerSize;
                            }
                            obj12 = i31 != 0 ? this_$iv : rememberedValue;
                            obj18 = $i$a$CacheTextFieldKt$TextField$3 != 0 ? this_$iv : obj3;
                            i39 = i37 != 0 ? this_$iv : leadingIcon;
                            i5 = i != 0 ? this_$iv : trailingIcon;
                            i43 = i7 != 0 ? this_$iv : isError;
                            if (i21 != 0) {
                                obj21 = this_$iv;
                            } else {
                                obj21 = visualTransformation;
                            }
                            if (i50 != 0) {
                                keyboardOptions4 = this_$iv;
                            } else {
                                keyboardOptions4 = keyboardOptions;
                            }
                            if (i35 & 8192 != 0) {
                                super(0, 0, 0, 0, 0, 0, 63, 0);
                                $dirty13 = $dirty16;
                                $dirty14 = keyboardActions5;
                            } else {
                                $dirty13 = keyboardActions3;
                                $dirty14 = keyboardActions;
                            }
                            i51 = i55 != 0 ? invalid$iv : singleLine;
                            i13 = i146 != 0 ? invalid$iv : maxLines;
                            if (i36 != 0) {
                                ComposerKt.sourceInformationMarkerStart(textFieldColors-dx8h9Zs, -53943058, "CC(remember):TextField.kt#9igjgp");
                                int i128 = 0;
                                z5 = textFieldColors-dx8h9Zs;
                                zeroCornerSize = 0;
                                rememberedValue = z5.rememberedValue();
                                consume = 0;
                                if (rememberedValue == Composer.Companion.getEmpty()) {
                                    int i140 = 0;
                                    z5.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                                } else {
                                    $i$a$CacheTextFieldKt$TextField$3 = rememberedValue;
                                }
                                ComposerKt.sourceInformationMarkerEnd(textFieldColors-dx8h9Zs);
                                obj2 = invalid$iv;
                            } else {
                                obj2 = interactionSource;
                            }
                            if (i35 & i32 != 0) {
                                obj17 = copy$default;
                                i45 = $dirty13;
                            } else {
                                obj17 = shape;
                                i45 = $dirty13;
                            }
                            if (i35 & i152 != 0) {
                                keyboardActions4 = $dirty14;
                                obj11 = modifier3;
                                obj19 = textFieldColors-dx8h9Zs;
                                keyboardActions3 = $dirty12;
                                invalid$iv = z2;
                                z5 = z4;
                                obj13 = obj8;
                                modifier2 = i8;
                                obj5 = obj12;
                                obj20 = obj18;
                                i16 = i39;
                                i11 = i5;
                                i22 = i43;
                                visualTransformation3 = obj21;
                                keyboardOptions2 = keyboardOptions4;
                                i41 = i51;
                                i18 = i13;
                                i15 = obj2;
                                i21 = obj17;
                            } else {
                                $composer3 = textFieldColors-dx8h9Zs;
                                obj19 = colors;
                                keyboardActions4 = $dirty14;
                                obj11 = modifier3;
                                invalid$iv = z2;
                                z5 = z4;
                                obj13 = obj8;
                                modifier2 = i8;
                                obj5 = obj12;
                                obj20 = obj18;
                                i16 = i39;
                                i11 = i5;
                                i22 = i43;
                                visualTransformation3 = obj21;
                                keyboardOptions2 = keyboardOptions4;
                                i41 = i51;
                                i18 = i13;
                                i15 = obj2;
                                i21 = obj17;
                                keyboardActions3 = i45;
                            }
                        } else {
                            textFieldColors-dx8h9Zs.skipToGroupEnd();
                            $dirty12 = i35 & 32 != 0 ? obj90 & i56 : obj90;
                            if (i35 & 8192 != 0) {
                                keyboardActions3 &= -7169;
                            }
                            if (i35 & i32 != 0) {
                                keyboardActions3 &= i46;
                            }
                            if (i35 & i152 != 0) {
                                keyboardActions3 &= i29;
                            }
                            i16 = leadingIcon;
                            i11 = trailingIcon;
                            keyboardOptions2 = keyboardOptions;
                            keyboardActions4 = keyboardActions;
                            i41 = singleLine;
                            i18 = maxLines;
                            i15 = interactionSource;
                            i21 = shape;
                            $composer3 = textFieldColors-dx8h9Zs;
                            modifier2 = $dirty12;
                            obj19 = $dirty1;
                            obj13 = zeroCornerSize;
                            obj5 = rememberedValue;
                            obj20 = obj3;
                            obj11 = str;
                            i22 = isError;
                            visualTransformation3 = visualTransformation;
                        }
                    } else {
                    }
                    $composer3.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1690895095, modifier2, keyboardActions3, "androidx.compose.material.TextField (TextField.kt:258)");
                    }
                    TextFieldKt.TextField(value, onValueChange, obj11, invalid$iv, z5, obj13, obj5, obj20, i16, i11, i22, visualTransformation3, keyboardOptions2, keyboardActions4, i41, i18, 1, i15, i21, obj19, $composer3, i81 | i105, i90 | i118, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i24 = modifier2;
                    $composer2 = obj11;
                    z7 = invalid$iv;
                    z6 = z5;
                    modifier4 = obj13;
                    enabled2 = obj5;
                    readOnly2 = obj20;
                    textStyle2 = i16;
                    label2 = i11;
                    placeholder2 = i22;
                    leadingIcon2 = visualTransformation3;
                    trailingIcon2 = keyboardOptions2;
                    isError2 = keyboardActions4;
                    visualTransformation2 = i41;
                    keyboardOptions3 = i18;
                    keyboardActions2 = i15;
                    singleLine2 = i21;
                    maxLines2 = obj19;
                    colors2 = keyboardActions3;
                } else {
                    textFieldColors-dx8h9Zs.skipToGroupEnd();
                    textStyle2 = leadingIcon;
                    leadingIcon2 = visualTransformation;
                    trailingIcon2 = keyboardOptions;
                    keyboardOptions3 = maxLines;
                    keyboardActions2 = interactionSource;
                    singleLine2 = shape;
                    i24 = obj90;
                    $composer3 = textFieldColors-dx8h9Zs;
                    maxLines2 = $dirty1;
                    z7 = invalid$iv;
                    z6 = z5;
                    modifier4 = zeroCornerSize;
                    enabled2 = rememberedValue;
                    readOnly2 = obj3;
                    $composer2 = str;
                    label2 = trailingIcon;
                    placeholder2 = isError;
                    isError2 = keyboardActions;
                    visualTransformation2 = singleLine;
                    colors2 = keyboardActions3;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = $composer3.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new TextFieldKt.TextField.4(value, onValueChange, $composer2, z7, z6, modifier4, enabled2, readOnly2, textStyle2, label2, placeholder2, leadingIcon2, trailingIcon2, isError2, visualTransformation2, keyboardOptions3, keyboardActions2, singleLine2, maxLines2, $changed, $changed1, i35);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    public static final void TextFieldLayout(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> textField, Function2<? super Composer, ? super Integer, Unit> label, Function3<? super Modifier, ? super Composer, ? super Integer, Unit> placeholder, Function2<? super Composer, ? super Integer, Unit> leading, Function2<? super Composer, ? super Integer, Unit> trailing, boolean singleLine, float animationProgress, PaddingValues paddingValues, Composer $composer, int $changed) {
        int i24;
        Object $i$a$CacheTextFieldKt$TextFieldLayout$measurePolicy$1;
        Integer layoutDirection;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap4;
        Object empty;
        boolean traceInProgress;
        kotlin.jvm.functions.Function0 factory$iv$iv;
        Object obj4;
        Integer valueOf5;
        Integer valueOf4;
        String materialized$iv$iv;
        int valueOf2;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv3;
        Object obj3;
        Object valueOf;
        Composer composer;
        Object obj;
        Object maybeCachedBoxMeasurePolicy2;
        Composer composer7;
        Object $composer$iv;
        int endPadding;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv2;
        boolean currentCompositionLocalMap5;
        Object maybeCachedBoxMeasurePolicy;
        Object materialized$iv$iv2;
        androidx.compose.ui.Modifier.Companion $this$coerceAtLeast_u2dYgX7TsA$iv;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv4;
        Modifier padding-qDBjuR0$default;
        BoxScopeInstance iNSTANCE;
        Composer i30;
        boolean valueOf3;
        Composer $this$dp$iv;
        int then;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap;
        int restartGroup;
        int $dirty;
        Composer composer2;
        int i20;
        int i6;
        int i8;
        int i;
        int i26;
        int i22;
        int i14;
        int i10;
        int i29;
        int skipping;
        boolean traceInProgress2;
        int i7;
        int i17;
        Modifier materializeModifier;
        Composer composer3;
        Integer valueOf6;
        Object currentCompositionLocalMap2;
        Object maybeCachedBoxMeasurePolicy3;
        Composer composer6;
        int currentCompositeKeyHash3;
        int currentCompositionLocalMap3;
        Object obj2;
        int i21;
        Composer.Companion companion;
        int invalid$iv;
        int currentCompositeKeyHash4;
        int i15;
        int i25;
        kotlin.jvm.functions.Function0 function02;
        int i28;
        Composer composer9;
        int i2;
        Object layoutDirection2;
        Composer composer5;
        int i12;
        int $i$f$setImpl;
        Modifier modifier3;
        int i9;
        int i18;
        int $i$a$LayoutTextFieldKt$TextFieldLayout$1;
        int i13;
        int i5;
        int i23;
        androidx.compose.runtime.CompositionLocalMap map;
        int currentCompositeKeyHash;
        int companion2;
        int i19;
        float f;
        Alignment alignment;
        int currentCompositeKeyHash2;
        int $changed$iv;
        float f2;
        int i16;
        int i4;
        Modifier modifier2;
        kotlin.jvm.functions.Function0 function0;
        int i11;
        int i27;
        Composer composer4;
        int localMap$iv$iv;
        int localMap$iv$iv3;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv2;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy;
        Composer composer8;
        int i3;
        Alignment obj63;
        Object obj5 = modifier;
        obj3 = textField;
        valueOf = label;
        obj = placeholder;
        $composer$iv = leading;
        maybeCachedBoxMeasurePolicy = trailing;
        padding-qDBjuR0$default = singleLine;
        iNSTANCE = animationProgress;
        final Object obj6 = paddingValues;
        i30 = $changed;
        traceInProgress = -2112507061;
        restartGroup = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(TextFieldLayout)P(3,7,1,5,2,8,6)489@22578L139,492@22765L7,493@22777L1853:TextField.kt#jmzs0o");
        if (i30 & 6 == 0) {
            i20 = restartGroup.changed(obj5) ? 4 : 2;
            $dirty |= i20;
        }
        if (i30 & 48 == 0) {
            i6 = restartGroup.changedInstance(obj3) ? 32 : 16;
            $dirty |= i6;
        }
        if (i30 & 384 == 0) {
            i8 = restartGroup.changedInstance(valueOf) ? 256 : 128;
            $dirty |= i8;
        }
        if (i30 & 3072 == 0) {
            i = restartGroup.changedInstance(obj) ? 2048 : 1024;
            $dirty |= i;
        }
        if (i30 & 24576 == 0) {
            i26 = restartGroup.changedInstance($composer$iv) ? 16384 : 8192;
            $dirty |= i26;
        }
        if (i84 &= i30 == 0) {
            i22 = restartGroup.changedInstance(maybeCachedBoxMeasurePolicy) ? 131072 : 65536;
            $dirty |= i22;
        }
        currentCompositeKeyHash3 = 1048576;
        if (i85 &= i30 == 0) {
            i14 = restartGroup.changed(padding-qDBjuR0$default) ? currentCompositeKeyHash3 : 524288;
            $dirty |= i14;
        }
        if (i86 &= i30 == 0) {
            i10 = restartGroup.changed(iNSTANCE) ? 8388608 : 4194304;
            $dirty |= i10;
        }
        if (i87 &= i30 == 0) {
            i29 = restartGroup.changed(obj6) ? 67108864 : 33554432;
            $dirty |= i29;
        }
        if (i88 &= $dirty == 38347922) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty, -1, "androidx.compose.material.TextFieldLayout (TextField.kt:488)");
                }
                ComposerKt.sourceInformationMarkerStart(restartGroup, -73227460, "CC(remember):TextField.kt#9igjgp");
                i24 = i32 &= $dirty == currentCompositeKeyHash3 ? 1 : 0;
                int i114 = 1;
                i7 = i102 &= $dirty == 8388608 ? i114 : 0;
                i17 = i90 &= $dirty == 67108864 ? i114 : 0;
                i34 |= i17;
                Composer composer12 = restartGroup;
                int i105 = 0;
                Object rememberedValue6 = composer12.rememberedValue();
                int i113 = 0;
                if (empty == 0) {
                    invalid$iv = empty;
                    if (rememberedValue6 == Composer.Companion.getEmpty()) {
                        companion = invalid$iv2;
                        $i$a$CacheTextFieldKt$TextFieldLayout$measurePolicy$1 = new TextFieldMeasurePolicy(padding-qDBjuR0$default, iNSTANCE, obj6);
                        composer12.updateRememberedValue($i$a$CacheTextFieldKt$TextFieldLayout$measurePolicy$1);
                    } else {
                        $i$a$CacheTextFieldKt$TextFieldLayout$measurePolicy$1 = rememberedValue6;
                    }
                } else {
                    invalid$iv = empty;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                int i106 = 0;
                int i112 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume = restartGroup.consume((CompositionLocal)CompositionLocalsKt.getLocalLayoutDirection());
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                materializeModifier = 0;
                String str15 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, str15);
                currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, 0);
                currentCompositionLocalMap2 = restartGroup.getCurrentCompositionLocalMap();
                materialized$iv$iv2 = ComposedModifierKt.materializeModifier(restartGroup, obj5);
                kotlin.jvm.functions.Function0 function03 = constructor2;
                i25 = 0;
                String str7 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, str7);
                if (!applier2 instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                restartGroup.startReusableNode();
                if (restartGroup.getInserting()) {
                    restartGroup.createNode(function03);
                } else {
                    factory$iv$iv = function03;
                    restartGroup.useNode();
                }
                function02 = factory$iv$iv;
                Composer constructor-impl = Updater.constructor-impl(restartGroup);
                int i116 = 0;
                composer5 = restartGroup;
                Updater.set-impl(constructor-impl, (MeasurePolicy)(TextFieldMeasurePolicy)$i$a$CacheTextFieldKt$TextFieldLayout$measurePolicy$1, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                valueOf3 = 0;
                Composer composer13 = constructor-impl;
                int i118 = 0;
                if (!composer13.getInserting()) {
                    $i$f$setImpl = valueOf3;
                    i9 = $dirty;
                    if (!Intrinsics.areEqual(composer13.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                        composer13.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer2 = composer13;
                    }
                } else {
                    $i$f$setImpl = valueOf3;
                    i9 = $dirty;
                }
                Updater.set-impl(constructor-impl, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                i30 = composer5;
                $this$dp$iv = 0;
                i2 = i50;
                ComposerKt.sourceInformationMarkerStart(i30, 69567154, "C535@24392L183:TextField.kt#jmzs0o");
                String str11 = "C73@3429L9:Box.kt#2w3rfo";
                int i117 = 48;
                String str = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo";
                modifier3 = materialized$iv$iv2;
                if ($composer$iv != null) {
                    i30.startReplaceGroup(69542167);
                    ComposerKt.sourceInformation(i30, "497@22885L219");
                    $i$a$LayoutTextFieldKt$TextFieldLayout$1 = $this$dp$iv;
                    Modifier then4 = LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Leading").then(TextFieldImplKt.getIconDefaultSizeModifier());
                    Alignment center2 = Alignment.Companion.getCenter();
                    i13 = i117;
                    i5 = 0;
                    i23 = materializeModifier;
                    ComposerKt.sourceInformationMarkerStart(i30, 733328855, str);
                    int i101 = 0;
                    map = currentCompositionLocalMap2;
                    maybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(center2, i101);
                    i19 = 0;
                    alignment = center2;
                    ComposerKt.sourceInformationMarkerStart(i30, -1323940314, str15);
                    $changed$iv = ComposablesKt.getCurrentCompositeKeyHash(i30, 0);
                    currentCompositionLocalMap = i30.getCurrentCompositionLocalMap();
                    i16 = i101;
                    modifier2 = then4;
                    kotlin.jvm.functions.Function0 function07 = constructor5;
                    i4 = 0;
                    ComposerKt.sourceInformationMarkerStart(i30, -692256719, str7);
                    if (!applier5 instanceof Applier) {
                        ComposablesKt.invalidApplier();
                    }
                    i30.startReusableNode();
                    if (i30.getInserting()) {
                        i30.createNode(function07);
                    } else {
                        factory$iv$iv$iv4 = function07;
                        i30.useNode();
                    }
                    function0 = factory$iv$iv$iv4;
                    Composer constructor-impl4 = Updater.constructor-impl(i30);
                    int i133 = 0;
                    Updater.set-impl(constructor-impl4, maybeCachedBoxMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl4, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    int i137 = 0;
                    Composer composer17 = constructor-impl4;
                    int i139 = 0;
                    if (!composer17.getInserting()) {
                        localMap$iv$iv2 = currentCompositionLocalMap;
                        measurePolicy = maybeCachedBoxMeasurePolicy3;
                        if (!Intrinsics.areEqual(composer17.rememberedValue(), Integer.valueOf($changed$iv))) {
                            composer17.updateRememberedValue(Integer.valueOf($changed$iv));
                            constructor-impl4.apply(Integer.valueOf($changed$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer6 = composer17;
                        }
                    } else {
                        localMap$iv$iv2 = currentCompositionLocalMap;
                        measurePolicy = maybeCachedBoxMeasurePolicy3;
                    }
                    Updater.set-impl(constructor-impl4, ComposedModifierKt.materializeModifier(i30, then4), ComposeUiNode.Companion.getSetModifier());
                    Composer composer11 = i30;
                    ComposerKt.sourceInformationMarkerStart(composer11, -2146769399, str11);
                    currentCompositionLocalMap2 = BoxScopeInstance.INSTANCE;
                    i135 |= 6;
                    localMap$iv$iv = 0;
                    localMap$iv$iv3 = i59;
                    i3 = i80;
                    $this$dp$iv = composer4;
                    ComposerKt.sourceInformationMarkerStart($this$dp$iv, -1924262037, "C501@23077L9:TextField.kt#jmzs0o");
                    $composer$iv.invoke($this$dp$iv, Integer.valueOf(i60 &= 14));
                    ComposerKt.sourceInformationMarkerEnd($this$dp$iv);
                    ComposerKt.sourceInformationMarkerEnd(composer11);
                    i30.endNode();
                    ComposerKt.sourceInformationMarkerEnd(i30);
                    ComposerKt.sourceInformationMarkerEnd(i30);
                    ComposerKt.sourceInformationMarkerEnd(i30);
                    i30.endReplaceGroup();
                } else {
                    $i$a$LayoutTextFieldKt$TextFieldLayout$1 = $this$dp$iv;
                    i23 = materializeModifier;
                    map = currentCompositionLocalMap2;
                    i30.startReplaceGroup(69783378);
                    i30.endReplaceGroup();
                }
                if (maybeCachedBoxMeasurePolicy != null) {
                    i30.startReplaceGroup(69825941);
                    ComposerKt.sourceInformation(i30, "505@23171L221");
                    Modifier then3 = LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Trailing").then(TextFieldImplKt.getIconDefaultSizeModifier());
                    Alignment center = Alignment.Companion.getCenter();
                    ComposerKt.sourceInformationMarkerStart(i30, 733328855, str);
                    valueOf6 = 0;
                    i5 = 0;
                    ComposerKt.sourceInformationMarkerStart(i30, -1323940314, str15);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(i30, 0);
                    currentCompositionLocalMap5 = i30.getCurrentCompositionLocalMap();
                    i19 = center;
                    Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(i30, then3);
                    $changed$iv = then3;
                    kotlin.jvm.functions.Function0 function05 = constructor3;
                    alignment = 0;
                    ComposerKt.sourceInformationMarkerStart(i30, -692256719, str7);
                    if (!applier3 instanceof Applier) {
                        ComposablesKt.invalidApplier();
                    }
                    i30.startReusableNode();
                    if (i30.getInserting()) {
                        i30.createNode(function05);
                    } else {
                        factory$iv$iv$iv3 = function05;
                        i30.useNode();
                    }
                    i16 = factory$iv$iv$iv3;
                    Composer constructor-impl2 = Updater.constructor-impl(i30);
                    int i125 = 0;
                    i11 = i78;
                    Updater.set-impl(constructor-impl2, BoxKt.maybeCachedBoxMeasurePolicy(center, valueOf6), ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl2, currentCompositionLocalMap5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    int i128 = 0;
                    Composer composer15 = constructor-impl2;
                    int i136 = 0;
                    if (!composer15.getInserting()) {
                        localMap$iv$iv = currentCompositionLocalMap5;
                        localMap$iv$iv3 = valueOf6;
                        if (!Intrinsics.areEqual(composer15.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            composer15.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            constructor-impl2.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer3 = composer15;
                        }
                    } else {
                        localMap$iv$iv = currentCompositionLocalMap5;
                        localMap$iv$iv3 = valueOf6;
                    }
                    Updater.set-impl(constructor-impl2, materializeModifier4, ComposeUiNode.Companion.getSetModifier());
                    Composer composer10 = i30;
                    $this$dp$iv = 0;
                    ComposerKt.sourceInformationMarkerStart(composer10, -2146769399, str11);
                    materializeModifier = BoxScopeInstance.INSTANCE;
                    i127 |= 6;
                    i27 = 0;
                    composer4 = i55;
                    measurePolicy = materializeModifier4;
                    materialized$iv$iv2 = function0;
                    ComposerKt.sourceInformationMarkerStart(materialized$iv$iv2, -1923977302, "C509@23364L10:TextField.kt#jmzs0o");
                    maybeCachedBoxMeasurePolicy.invoke(materialized$iv$iv2, Integer.valueOf(i56 &= 14));
                    ComposerKt.sourceInformationMarkerEnd(materialized$iv$iv2);
                    ComposerKt.sourceInformationMarkerEnd(composer10);
                    i30.endNode();
                    ComposerKt.sourceInformationMarkerEnd(i30);
                    ComposerKt.sourceInformationMarkerEnd(i30);
                    ComposerKt.sourceInformationMarkerEnd(i30);
                    i30.endReplaceGroup();
                } else {
                    i30.startReplaceGroup(70069074);
                    i30.endReplaceGroup();
                }
                materialized$iv$iv = PaddingKt.calculateStartPadding(obj6, (LayoutDirection)consume);
                endPadding = PaddingKt.calculateEndPadding(obj6, consume);
                if (leading != null) {
                    int i77 = 0;
                    int i98 = 0;
                    materializeModifier = 0;
                    f = $this$coerceAtLeast_u2dYgX7TsA$iv;
                } else {
                    f = materialized$iv$iv;
                }
                if (maybeCachedBoxMeasurePolicy != null) {
                    int i76 = 0;
                    int i96 = 0;
                    materializeModifier = 0;
                    f2 = $this$coerceAtLeast_u2dYgX7TsA$iv;
                } else {
                    f2 = endPadding;
                }
                padding-qDBjuR0$default = PaddingKt.padding-qDBjuR0$default((Modifier)Modifier.Companion, f, 0, f2, 0, 10, 0);
                if (obj != null) {
                    i30.startReplaceGroup(70826807);
                    ComposerKt.sourceInformation(i30, "530@24185L59");
                    obj.invoke(LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Hint").then(padding-qDBjuR0$default), i30, Integer.valueOf(i92 &= 112));
                    i30.endReplaceGroup();
                } else {
                    i30.startReplaceGroup(70914258);
                    i30.endReplaceGroup();
                }
                if (valueOf != null) {
                    i30.startReplaceGroup(70948761);
                    ComposerKt.sourceInformation(i30, "533@24308L57");
                    materializeModifier = 0;
                    currentCompositionLocalMap2 = 0;
                    layoutDirection2 = consume;
                    ComposerKt.sourceInformationMarkerStart(i30, 733328855, str);
                    Alignment topStart = Alignment.Companion.getTopStart();
                    i13 = materialized$iv$iv;
                    int startTextFieldPadding = 0;
                    maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(topStart, startTextFieldPadding);
                    companion2 = 0;
                    f = topStart;
                    ComposerKt.sourceInformationMarkerStart(i30, -1323940314, str15);
                    currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(i30, 0);
                    currentCompositionLocalMap4 = i30.getCurrentCompositionLocalMap();
                    f2 = startTextFieldPadding;
                    Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(i30, LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Label").then(padding-qDBjuR0$default));
                    i4 = endPadding;
                    kotlin.jvm.functions.Function0 function06 = constructor4;
                    i16 = 0;
                    ComposerKt.sourceInformationMarkerStart(i30, -692256719, str7);
                    if (!applier4 instanceof Applier) {
                        ComposablesKt.invalidApplier();
                    }
                    i30.startReusableNode();
                    if (i30.getInserting()) {
                        i30.createNode(function06);
                    } else {
                        factory$iv$iv$iv2 = function06;
                        i30.useNode();
                    }
                    modifier2 = factory$iv$iv$iv2;
                    Composer constructor-impl3 = Updater.constructor-impl(i30);
                    int i129 = 0;
                    Updater.set-impl(constructor-impl3, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl3, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    int i132 = 0;
                    Composer composer16 = constructor-impl3;
                    int i138 = 0;
                    if (!composer16.getInserting()) {
                        localMap$iv$iv3 = currentCompositionLocalMap4;
                        localMap$iv$iv2 = maybeCachedBoxMeasurePolicy2;
                        if (!Intrinsics.areEqual(composer16.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                            composer16.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                            constructor-impl3.apply(Integer.valueOf(currentCompositeKeyHash2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer7 = composer16;
                        }
                    } else {
                        localMap$iv$iv3 = currentCompositionLocalMap4;
                        localMap$iv$iv2 = maybeCachedBoxMeasurePolicy2;
                    }
                    Updater.set-impl(constructor-impl3, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                    obj = i30;
                    endPadding = 0;
                    ComposerKt.sourceInformationMarkerStart(obj, -2146769399, str11);
                    maybeCachedBoxMeasurePolicy = BoxScopeInstance.INSTANCE;
                    i131 |= 6;
                    i27 = obj;
                    composer4 = 0;
                    localMap$iv$iv = i43;
                    measurePolicy = materializeModifier3;
                    ComposerKt.sourceInformationMarkerStart(obj, -1922993331, "C533@24356L7:TextField.kt#jmzs0o");
                    valueOf.invoke(obj, Integer.valueOf(i44 &= 14));
                    ComposerKt.sourceInformationMarkerEnd(obj);
                    ComposerKt.sourceInformationMarkerEnd(obj);
                    i30.endNode();
                    ComposerKt.sourceInformationMarkerEnd(i30);
                    ComposerKt.sourceInformationMarkerEnd(i30);
                    ComposerKt.sourceInformationMarkerEnd(i30);
                    i30.endReplaceGroup();
                } else {
                    layoutDirection2 = consume;
                    i13 = materialized$iv$iv;
                    i4 = endPadding;
                    i30.startReplaceGroup(71034290);
                    i30.endReplaceGroup();
                }
                Modifier then2 = LayoutIdKt.layoutId((Modifier)Modifier.Companion, "TextField").then(padding-qDBjuR0$default);
                valueOf2 = 384;
                $composer$iv = 0;
                ComposerKt.sourceInformationMarkerStart(i30, 733328855, str);
                Alignment topStart2 = Alignment.Companion.getTopStart();
                skipping = 0;
                ComposerKt.sourceInformationMarkerStart(i30, -1323940314, str15);
                currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(i30, 0);
                obj63 = topStart2;
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(i30, then2);
                companion = then2;
                kotlin.jvm.functions.Function0 function04 = constructor;
                i21 = 0;
                ComposerKt.sourceInformationMarkerStart(i30, -692256719, str7);
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                i30.startReusableNode();
                if (i30.getInserting()) {
                    i30.createNode(function04);
                } else {
                    factory$iv$iv$iv = function04;
                    i30.useNode();
                }
                Composer constructor-impl5 = Updater.constructor-impl(i30);
                int i115 = 0;
                currentCompositeKeyHash = factory$iv$iv$iv;
                Updater.set-impl(constructor-impl5, BoxKt.maybeCachedBoxMeasurePolicy(topStart2, i114), ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl5, i30.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i119 = 0;
                Composer composer14 = constructor-impl5;
                int i123 = 0;
                if (!composer14.getInserting()) {
                    $changed$iv = valueOf2;
                    if (!Intrinsics.areEqual(composer14.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                        composer14.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        constructor-impl5.apply(Integer.valueOf(currentCompositeKeyHash3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer = composer14;
                    }
                } else {
                    $changed$iv = valueOf2;
                }
                Updater.set-impl(constructor-impl5, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                obj3 = i30;
                valueOf = 0;
                ComposerKt.sourceInformationMarkerStart(obj3, -2146769399, str11);
                iNSTANCE = BoxScopeInstance.INSTANCE;
                i83 |= 6;
                composer9 = obj3;
                i12 = 0;
                i18 = i38;
                i19 = materializeModifier2;
                ComposerKt.sourceInformationMarkerStart(obj3, -1922800759, "C539@24550L11:TextField.kt#jmzs0o");
                textField.invoke(obj3, Integer.valueOf(i39 &= 14));
                ComposerKt.sourceInformationMarkerEnd(obj3);
                ComposerKt.sourceInformationMarkerEnd(obj3);
                i30.endNode();
                ComposerKt.sourceInformationMarkerEnd(i30);
                ComposerKt.sourceInformationMarkerEnd(i30);
                ComposerKt.sourceInformationMarkerEnd(i30);
                ComposerKt.sourceInformationMarkerEnd(i30);
                composer5.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer5);
                ComposerKt.sourceInformationMarkerEnd(composer5);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
                obj4 = obj3;
                composer5 = restartGroup;
                i9 = $dirty;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer5.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new TextFieldKt.TextFieldLayout.2(modifier, obj4, label, placeholder, leading, trailing, singleLine, animationProgress, obj6, $changed);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final int access$calculateHeight-O3s9Psw(int textFieldHeight, boolean hasLabel, int labelBaseline, int leadingHeight, int trailingHeight, int placeholderHeight, long constraints, float density, PaddingValues paddingValues) {
        return TextFieldKt.calculateHeight-O3s9Psw(textFieldHeight, hasLabel, labelBaseline, leadingHeight, trailingHeight, placeholderHeight, constraints, density, paddingValues);
    }

    public static final int access$calculateWidth-VsPV1Ek(int leadingWidth, int trailingWidth, int textFieldWidth, int labelWidth, int placeholderWidth, long constraints) {
        return TextFieldKt.calculateWidth-VsPV1Ek(leadingWidth, trailingWidth, textFieldWidth, labelWidth, placeholderWidth, constraints);
    }

    public static final void access$placeWithLabel(Placeable.PlacementScope $receiver, int width, int height, Placeable textfieldPlaceable, Placeable labelPlaceable, Placeable placeholderPlaceable, Placeable leadingPlaceable, Placeable trailingPlaceable, boolean singleLine, int labelEndPosition, int textPosition, float animationProgress, float density) {
        TextFieldKt.placeWithLabel($receiver, width, height, textfieldPlaceable, labelPlaceable, placeholderPlaceable, leadingPlaceable, trailingPlaceable, singleLine, labelEndPosition, textPosition, animationProgress, density);
    }

    public static final void access$placeWithoutLabel(Placeable.PlacementScope $receiver, int width, int height, Placeable textPlaceable, Placeable placeholderPlaceable, Placeable leadingPlaceable, Placeable trailingPlaceable, boolean singleLine, float density, PaddingValues paddingValues) {
        TextFieldKt.placeWithoutLabel($receiver, width, height, textPlaceable, placeholderPlaceable, leadingPlaceable, trailingPlaceable, singleLine, density, paddingValues);
    }

    public static final int access$substractConstraintSafely(int $receiver, int from) {
        return TextFieldKt.substractConstraintSafely($receiver, from);
    }

    private static final int calculateHeight-O3s9Psw(int textFieldHeight, boolean hasLabel, int labelBaseline, int leadingHeight, int trailingHeight, int placeholderHeight, long constraints, float density, PaddingValues paddingValues) {
        int i;
        float f;
        bottomPadding-D9Ej5fM *= paddingValues;
        final int i5 = Math.max(textFieldHeight, placeholderHeight);
        if (hasLabel) {
            i7 += i4;
        } else {
            i8 += i4;
        }
        return Math.max(MathKt.roundToInt(i), Math.max(Math.max(leadingHeight, trailingHeight), Constraints.getMinHeight-impl(constraints)));
    }

    private static final int calculateWidth-VsPV1Ek(int leadingWidth, int trailingWidth, int textFieldWidth, int labelWidth, int placeholderWidth, long constraints) {
        return Math.max(i3 += trailingWidth, Constraints.getMinWidth-impl(constraints));
    }

    public static final Modifier drawIndicatorLine(Modifier $this$drawIndicatorLine, BorderStroke indicatorBorder) {
        TextFieldKt.drawIndicatorLine.1 anon = new TextFieldKt.drawIndicatorLine.1(indicatorBorder.getWidth-D9Ej5fM(), indicatorBorder);
        return DrawModifierKt.drawWithContent($this$drawIndicatorLine, (Function1)anon);
    }

    public static final float getFirstBaselineOffset() {
        return TextFieldKt.FirstBaselineOffset;
    }

    public static final float getTextFieldBottomPadding() {
        return TextFieldKt.TextFieldBottomPadding;
    }

    public static final float getTextFieldTopPadding() {
        return TextFieldKt.TextFieldTopPadding;
    }

    private static final void placeWithLabel(Placeable.PlacementScope $this$placeWithLabel, int width, int height, Placeable textfieldPlaceable, Placeable labelPlaceable, Placeable placeholderPlaceable, Placeable leadingPlaceable, Placeable trailingPlaceable, boolean singleLine, int labelEndPosition, int textPosition, float animationProgress, float density) {
        Alignment.Vertical centerVertically;
        int roundToInt2;
        Placeable.PlacementScope height2;
        Placeable roundToInt;
        int i7;
        int align;
        int i11;
        int i8;
        int i4;
        Placeable.PlacementScope placementScope;
        Placeable.PlacementScope placementScope2;
        Placeable placeable;
        Placeable placeable2;
        int widthOrZero;
        int widthOrZero2;
        int align2;
        int i3;
        int i5;
        int i9;
        int i2;
        int i;
        int i10;
        int i6;
        final int i12 = height;
        if (leadingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, leadingPlaceable, 0, Alignment.Companion.getCenterVertically().align(leadingPlaceable.getHeight(), i12), 0, 4, 0);
        }
        if (trailingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, trailingPlaceable, width - width2, Alignment.Companion.getCenterVertically().align(trailingPlaceable.getHeight(), i12), 0, 4, 0);
        }
        if (labelPlaceable != null) {
            placeable = labelPlaceable;
            centerVertically = 0;
            if (singleLine) {
                roundToInt2 = Alignment.Companion.getCenterVertically().align(placeable.getHeight(), i12);
            } else {
                roundToInt2 = MathKt.roundToInt(textFieldPadding *= density);
            }
            Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, placeable, TextFieldImplKt.widthOrZero(leadingPlaceable), roundToInt2 - roundToInt, 0, 4, 0);
        }
        Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, textfieldPlaceable, TextFieldImplKt.widthOrZero(leadingPlaceable), textPosition, 0, 4, 0);
        if (placeholderPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, placeholderPlaceable, TextFieldImplKt.widthOrZero(leadingPlaceable), textPosition, 0, 4, 0);
        }
    }

    private static final void placeWithoutLabel(Placeable.PlacementScope $this$placeWithoutLabel, int width, int height, Placeable textPlaceable, Placeable placeholderPlaceable, Placeable leadingPlaceable, Placeable trailingPlaceable, boolean singleLine, float density, PaddingValues paddingValues) {
        Alignment.Vertical centerVertically;
        int height2;
        Placeable.PlacementScope align2;
        Placeable height3;
        int i11;
        int align3;
        int i;
        int i8;
        int i5;
        Placeable.PlacementScope placementScope;
        Placeable.PlacementScope placementScope2;
        Placeable placeable2;
        Placeable placeable;
        int i6;
        int widthOrZero;
        int align;
        int i3;
        int i12;
        int i7;
        int i9;
        int i4;
        int i10;
        int i2;
        final int i13 = height;
        int roundToInt = MathKt.roundToInt(topPadding-D9Ej5fM *= density);
        if (leadingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithoutLabel, leadingPlaceable, 0, Alignment.Companion.getCenterVertically().align(leadingPlaceable.getHeight(), i13), 0, 4, 0);
        }
        if (trailingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithoutLabel, trailingPlaceable, width - width2, Alignment.Companion.getCenterVertically().align(trailingPlaceable.getHeight(), i13), 0, 4, 0);
        }
        if (singleLine) {
            i3 = centerVertically;
        } else {
            i3 = roundToInt;
        }
        Placeable.PlacementScope.placeRelative$default($this$placeWithoutLabel, textPlaceable, TextFieldImplKt.widthOrZero(leadingPlaceable), i3, 0, 4, 0);
        int i15 = i3;
        if (placeholderPlaceable != null) {
            height2 = 0;
            if (singleLine) {
                i3 = align2;
            } else {
                i3 = roundToInt;
            }
            Placeable.PlacementScope.placeRelative$default($this$placeWithoutLabel, placeholderPlaceable, TextFieldImplKt.widthOrZero(leadingPlaceable), i3, 0, 4, 0);
        }
    }

    private static final int substractConstraintSafely(int $this$substractConstraintSafely, int from) {
        if ($this$substractConstraintSafely == Integer.MAX_VALUE) {
            return $this$substractConstraintSafely;
        }
        return $this$substractConstraintSafely - from;
    }
}
