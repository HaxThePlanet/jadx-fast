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
        Object obj5;
        boolean z7;
        Object obj18;
        Object obj2;
        Object obj19;
        boolean z5;
        int i48;
        int i52;
        Object obj15;
        Object obj8;
        int $dirty15;
        Object $dirty17;
        Object $dirty1;
        Object endRestartGroup;
        int skipping;
        int $dirty;
        int $dirty3;
        int $dirty16;
        int defaultsInvalid;
        Object modifier2;
        int $i$a$CacheTextFieldKt$TextField$interactionSource$2;
        boolean traceInProgress;
        int $composer2;
        int i77;
        Object $composer3;
        int $dirty2;
        int $dirty4;
        int i49;
        int i16;
        Object textFieldColors-dx8h9Zs;
        int default;
        int $dirty14;
        boolean z3;
        int $dirty12;
        Object $dirty13;
        Composer composer;
        boolean z;
        Object obj;
        int i64;
        Object obj14;
        boolean field2;
        int i101;
        int i94;
        int textFieldShape;
        Object enabled2;
        boolean z4;
        Object readOnly2;
        int i62;
        Object obj11;
        boolean traceInProgress2;
        int value2;
        int i80;
        Object obj10;
        KeyboardOptions i34;
        int keyboardOptions3;
        Object visualTransformation3;
        Object shape3;
        int keyboardActions2;
        int i56;
        int field3;
        int i65;
        VisualTransformation singleLine2;
        int obj12;
        int i17;
        KeyboardOptions maxLines2;
        Object obj9;
        int obj20;
        KeyboardActions minLines2;
        Object obj17;
        int visualTransformation2;
        int i38;
        int i35;
        int i41;
        int i81;
        int i6;
        int i61;
        int changed2;
        int i53;
        int changed6;
        int i15;
        long $this$takeOrElse_u2dDxMtmZc$iv;
        int i40;
        int i42;
        int companion;
        Shape shape2;
        int i78;
        int i29;
        long unbox-impl;
        Object field;
        int i;
        int i82;
        int i37;
        int i50;
        int i8;
        int changed7;
        int i66;
        int i7;
        int i10;
        int i72;
        int i30;
        int $dirty18;
        int i22;
        int changed;
        int changed4;
        int i63;
        int i67;
        int changed3;
        int i3;
        int i68;
        int i54;
        int i69;
        int i85;
        int i18;
        int i70;
        int i76;
        int i79;
        boolean changed5;
        int i93;
        int i55;
        int i96;
        int i27;
        int i90;
        int i43;
        int i83;
        int i44;
        int i26;
        int i31;
        int i84;
        int i25;
        int i86;
        Composer composer3;
        Composer composer2;
        int i89;
        int i45;
        int i9;
        int i4;
        boolean z6;
        boolean z2;
        Object obj7;
        int i71;
        Object obj6;
        Object obj13;
        int i95;
        int obj21;
        int obj16;
        int i32;
        VisualTransformation i73;
        KeyboardOptions keyboardOptions2;
        int i87;
        int i33;
        int i88;
        int modifier3;
        Shape obj3;
        int i11;
        int i13;
        TextStyle textStyle2;
        long l;
        int i57;
        int i60;
        int i51;
        int i14;
        int i99;
        int i19;
        int i2;
        int i12;
        int i100;
        int i91;
        int i58;
        int i28;
        int i74;
        int i23;
        int i21;
        int i39;
        int i97;
        int i46;
        int i75;
        int i20;
        int i5;
        int i98;
        int i47;
        int i92;
        int i59;
        ScopeUpdateScope scopeUpdateScope;
        int i36;
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
        Composer restartGroup = $composer.startRestartGroup(-359119489);
        ComposerKt.sourceInformation(restartGroup, "C(TextField)P(18,11,10,1,13,16,6,12,7,17,3,19,5,4,15,8,9,2,14)356@17778L7,369@18422L14,370@18486L17,385@19110L38,394@19477L20,402@19819L724,381@18927L1622:TextField.kt#jmzs0o");
        $dirty2 = $changed;
        $dirty12 = $changed1;
        if (traceInProgress & 1 != 0) {
            $dirty2 |= 6;
            obj = value;
        } else {
            if (i102 & 6 == 0) {
                i62 = restartGroup.changed(value) ? 4 : 2;
                $dirty2 |= i62;
            } else {
                obj = value;
            }
        }
        if (traceInProgress & 2 != 0) {
            $dirty2 |= 48;
            obj11 = onValueChange;
        } else {
            if (i102 & 48 == 0) {
                i56 = restartGroup.changedInstance(onValueChange) ? 32 : 16;
                $dirty2 |= i56;
            } else {
                obj11 = onValueChange;
            }
        }
        i65 = traceInProgress & 4;
        if (i65 != 0) {
            $dirty2 |= 384;
            obj17 = modifier;
        } else {
            if (i102 & 384 == 0) {
                i38 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty2 |= i38;
            } else {
                obj17 = modifier;
            }
        }
        i35 = traceInProgress & 8;
        changed2 = 1024;
        if (i35 != 0) {
            $dirty2 |= 3072;
            field2 = enabled;
        } else {
            if (i102 & 3072 == 0) {
                i42 = restartGroup.changed(enabled) ? i81 : changed2;
                $dirty2 |= i42;
            } else {
                field2 = enabled;
            }
        }
        companion = traceInProgress & 16;
        if (companion != 0) {
            $dirty2 |= 24576;
            z4 = readOnly;
        } else {
            if (i102 & 24576 == 0) {
                i37 = restartGroup.changed(readOnly) ? 16384 : i78;
                $dirty2 |= i37;
            } else {
                z4 = readOnly;
            }
        }
        if (i102 & i210 == 0) {
            if (traceInProgress & 32 == 0) {
                changed7 = restartGroup.changed(textStyle) ? 131072 : 65536;
            } else {
                obj10 = textStyle;
            }
            $dirty2 |= changed7;
        } else {
            obj10 = textStyle;
        }
        i66 = traceInProgress & 64;
        i7 = 1572864;
        i63 = 524288;
        if (i66 != 0) {
            $dirty2 |= i7;
            visualTransformation3 = label;
        } else {
            if (i102 & i7 == 0) {
                i3 = restartGroup.changedInstance(label) ? 1048576 : i63;
                $dirty2 |= i3;
            } else {
                visualTransformation3 = label;
            }
        }
        i17 = traceInProgress & 128;
        i68 = 12582912;
        if (i17 != 0) {
            $dirty2 |= i68;
            obj9 = placeholder;
        } else {
            if (i102 & i68 == 0) {
                i69 = restartGroup.changedInstance(placeholder) ? 8388608 : 4194304;
                $dirty2 |= i69;
            } else {
                obj9 = placeholder;
            }
        }
        int i103 = traceInProgress & 256;
        int i219 = 100663296;
        if (i103 != 0) {
            $dirty2 |= i219;
            i85 = i103;
            obj4 = leadingIcon;
        } else {
            if ($changed & i219 == 0) {
                i85 = i103;
                i18 = restartGroup.changedInstance(leadingIcon) ? 67108864 : 33554432;
                $dirty2 |= i18;
            } else {
                i85 = i103;
                obj4 = leadingIcon;
            }
        }
        int i104 = traceInProgress & 512;
        int i221 = 805306368;
        if (i104 != 0) {
            $dirty2 |= i221;
            i70 = i104;
            obj5 = trailingIcon;
        } else {
            if ($changed & i221 == 0) {
                i70 = i104;
                i76 = restartGroup.changedInstance(trailingIcon) ? 536870912 : 268435456;
                $dirty2 |= i76;
            } else {
                i70 = i104;
                obj5 = trailingIcon;
            }
        }
        int i105 = traceInProgress & 1024;
        if (i105 != 0) {
            $dirty12 |= 6;
            i79 = i105;
            z7 = isError;
        } else {
            if (i114 & 6 == 0) {
                i79 = i105;
                i = restartGroup.changed(isError) ? 4 : 2;
                $dirty12 |= i;
            } else {
                i79 = i105;
                z7 = isError;
            }
        }
        int i106 = traceInProgress & 2048;
        if (i106 != 0) {
            $dirty12 |= 48;
            i82 = i106;
            obj18 = visualTransformation;
        } else {
            if (i114 & 48 == 0) {
                i82 = i106;
                changed3 = restartGroup.changed(visualTransformation) ? 32 : 16;
                $dirty12 |= changed3;
            } else {
                i82 = i106;
                obj18 = visualTransformation;
            }
        }
        int i107 = traceInProgress & 4096;
        if (i107 != 0) {
            $dirty12 |= 384;
            i8 = i107;
            obj2 = keyboardOptions;
        } else {
            i8 = i107;
            if (i114 & 384 == 0) {
                i3 = restartGroup.changed(keyboardOptions) ? 256 : 128;
                $dirty12 |= i3;
            } else {
                obj2 = keyboardOptions;
            }
        }
        if (i114 & 3072 == 0) {
            if (traceInProgress & 8192 == 0) {
                if (restartGroup.changed(keyboardActions)) {
                } else {
                    i81 = changed2;
                }
            } else {
                obj19 = keyboardActions;
            }
            $dirty12 |= i81;
        } else {
            obj19 = keyboardActions;
        }
        int i110 = traceInProgress & 16384;
        if (i110 != 0) {
            $dirty12 |= 24576;
            i6 = i110;
            z5 = singleLine;
        } else {
            i6 = i110;
            if (i114 & 24576 == 0) {
                if (restartGroup.changed(singleLine)) {
                    i78 = 16384;
                }
                $dirty12 |= i78;
            } else {
                z5 = singleLine;
            }
        }
        if (i114 & i200 == 0) {
            if (traceInProgress & i201 == 0) {
                i53 = restartGroup.changed(maxLines) ? 131072 : 65536;
            } else {
                i48 = maxLines;
            }
            $dirty12 |= i53;
        } else {
            i48 = maxLines;
        }
        i15 = traceInProgress & i202;
        if (i15 != 0) {
            $dirty12 |= i7;
            i52 = minLines;
        } else {
            if (i114 & i7 == 0) {
                i78 = restartGroup.changed(minLines) ? 1048576 : i63;
                $dirty12 |= i78;
            } else {
                i52 = minLines;
            }
        }
        i29 = traceInProgress & i206;
        if (i29 != 0) {
            $dirty12 |= i68;
            obj15 = interactionSource;
        } else {
            if (i114 & i68 == 0) {
                i7 = restartGroup.changed(interactionSource) ? 8388608 : 4194304;
                $dirty12 |= i7;
            } else {
                obj15 = interactionSource;
            }
        }
        if (i114 & i213 == 0) {
            if (traceInProgress & i215 == 0) {
                i10 = restartGroup.changed(shape) ? 67108864 : 33554432;
            } else {
                obj8 = shape;
            }
            $dirty12 |= i10;
        } else {
            obj8 = shape;
        }
        if (i114 & i214 == 0) {
            if (traceInProgress & i63 == 0) {
                obj124 = $dirty12;
                i22 = restartGroup.changed(colors) ? 536870912 : 268435456;
            } else {
                obj124 = $dirty12;
                $dirty13 = colors;
            }
            $dirty15 = i72;
        } else {
            $dirty13 = colors;
            $dirty15 = obj124;
        }
        obj124 = $dirty2;
        if ($dirty2 & i30 == 306783378 && i128 &= $dirty15 == 306783378) {
            if (i128 &= $dirty15 == 306783378) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    default = -458753;
                    int i160 = 6;
                    int i163 = 1;
                    if ($changed & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if (i65 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = obj17;
                            }
                            z6 = i35 != 0 ? field2 : field2;
                            z2 = companion != 0 ? field2 : z4;
                            if (traceInProgress & 32 != 0) {
                                z4 = 6;
                                i65 = 0;
                                ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                                obj7 = default;
                                i71 = i101;
                            } else {
                                i35 = default;
                                i71 = obj124;
                                obj7 = obj10;
                            }
                            obj6 = i66 != 0 ? default : visualTransformation3;
                            obj13 = i17 != 0 ? default : obj9;
                            i95 = i85 != 0 ? default : leadingIcon;
                            obj21 = i70 != 0 ? default : trailingIcon;
                            obj16 = i79 != 0 ? default : isError;
                            if (i82 != 0) {
                                i73 = default;
                            } else {
                                i73 = visualTransformation;
                            }
                            if (i8 != 0) {
                                keyboardOptions2 = default;
                            } else {
                                keyboardOptions2 = keyboardOptions;
                            }
                            if (traceInProgress & 8192 != 0) {
                                super(0, 0, 0, 0, 0, 0, 63, 0);
                                $dirty14 = $dirty19;
                                $dirty1 = i36;
                            } else {
                                $dirty14 = $dirty15;
                                $dirty1 = keyboardActions;
                            }
                            i87 = i6 != 0 ? i101 : singleLine;
                            if (i167 &= traceInProgress != 0) {
                                i94 = i87 != 0 ? i163 : 0x7fffffff /* Unknown resource */;
                                $dirty14 &= i35;
                                i33 = i94;
                            } else {
                                i33 = maxLines;
                            }
                            i88 = i15 != 0 ? i94 : minLines;
                            modifier3 = i29 != 0 ? i94 : interactionSource;
                            if (i168 &= traceInProgress != 0) {
                                obj3 = textFieldShape;
                                i11 = $dirty14;
                            } else {
                                obj3 = shape;
                                i11 = $dirty14;
                            }
                            if (traceInProgress & i63 != 0) {
                                int i172 = i163;
                                int i179 = i169;
                                int i185 = i179;
                                int i188 = i180;
                                i35 = i188;
                                i15 = i35;
                                i29 = i15;
                                i8 = i29;
                                i30 = i8;
                                changed3 = i30;
                                i68 = changed3;
                                i85 = i68;
                                i79 = i85;
                                i93 = i79;
                                i96 = i93;
                                i90 = i96;
                                i83 = i90;
                                i26 = i83;
                                i84 = i26;
                                i86 = i84;
                                i13 = i234;
                                composer3 = restartGroup;
                                $composer2 = i36;
                                textFieldColors-dx8h9Zs = TextFieldDefaults.INSTANCE.textFieldColors-dx8h9Zs(0, i163, 0, i172, 0, i179, 0, i185, 0, i188, 0, i35, 0, i15, 0, i29, 0, i8, 0, i30, 0, changed3, 0, i68, 0, i85);
                                composer = composer3;
                                shape3 = $dirty1;
                                obj17 = modifier2;
                                $dirty3 = i165;
                                field2 = z6;
                                z4 = z2;
                                $dirty17 = obj7;
                                i64 = i71;
                                i34 = keyboardOptions2;
                                field3 = i87;
                                obj12 = i33;
                                obj20 = i88;
                            } else {
                                composer = restartGroup;
                                $composer2 = i36;
                                textFieldColors-dx8h9Zs = colors;
                                shape3 = $dirty1;
                                obj17 = modifier2;
                                field2 = z6;
                                z4 = z2;
                                $dirty17 = obj7;
                                i64 = i71;
                                i34 = keyboardOptions2;
                                field3 = i87;
                                obj12 = i33;
                                obj20 = i88;
                                $dirty3 = i11;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            $dirty = traceInProgress & 32 != 0 ? obj124 & default : obj124;
                            if (traceInProgress & 8192 != 0) {
                                $dirty15 &= -7169;
                            }
                            if (i183 &= traceInProgress != 0) {
                                $dirty15 &= default;
                            }
                            if (i156 &= traceInProgress != 0) {
                                $dirty15 &= i49;
                            }
                            if (traceInProgress & i63 != 0) {
                                $dirty15 &= i16;
                            }
                            composer = restartGroup;
                            $composer2 = i157;
                            i95 = leadingIcon;
                            obj21 = trailingIcon;
                            obj16 = isError;
                            i73 = visualTransformation;
                            field3 = singleLine;
                            obj12 = maxLines;
                            modifier3 = interactionSource;
                            obj3 = shape;
                            textFieldColors-dx8h9Zs = colors;
                            i64 = $dirty;
                            obj6 = visualTransformation3;
                            obj13 = obj9;
                            shape3 = keyboardActions;
                            obj20 = minLines;
                            $dirty3 = $dirty15;
                            $dirty17 = obj10;
                            i34 = keyboardOptions;
                        }
                    } else {
                    }
                    composer.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-359119489, i64, $dirty3, "androidx.compose.material.TextField (TextField.kt:371)");
                    }
                    if (modifier3 == 0) {
                        composer.startReplaceGroup(-1665951468);
                        ComposerKt.sourceInformation(composer, "373@18589L39");
                        ComposerKt.sourceInformationMarkerStart(composer, -53740370, "CC(remember):TextField.kt#9igjgp");
                        $composer2 = 0;
                        traceInProgress2 = composer;
                        i35 = 0;
                        $dirty18 = $dirty3;
                        $dirty16 = traceInProgress2.rememberedValue();
                        i15 = 0;
                        if ($dirty16 == Composer.Companion.getEmpty()) {
                            int i146 = 0;
                            traceInProgress2.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                        } else {
                            $i$a$CacheTextFieldKt$TextField$interactionSource$2 = $dirty16;
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        composer.endReplaceGroup();
                    } else {
                        $dirty18 = $dirty3;
                        composer.startReplaceGroup(-53741021);
                        composer.endReplaceGroup();
                        $i$a$CacheTextFieldKt$TextField$interactionSource$2 = modifier3;
                    }
                    composer.startReplaceGroup(-53735263);
                    ComposerKt.sourceInformation(composer, "*376@18776L18");
                    int i117 = 0;
                    i77 = 0;
                    value2 = Long.compare(unbox-impl, i211) != 0 ? 1 : 0;
                    if (value2 != null) {
                    } else {
                        i77 = 0;
                        $this$takeOrElse_u2dDxMtmZc$iv = unbox-impl;
                    }
                    composer.endReplaceGroup();
                    textStyle2 = new TextStyle($this$takeOrElse_u2dDxMtmZc$iv, obj72, 0, obj74, 0, 0, 0, 0, 0, 0, obj81, 0, 0, 0, 0, obj86, 0, 0, 0, 0, 0, 0, obj93, 0, 0, 0, 0, 0, 0, 16777214, 0);
                    obj108 = field2;
                    obj107 = obj17;
                    obj109 = obj16;
                    Object obj22 = obj107;
                    int i189 = obj109;
                    obj111 = $i$a$CacheTextFieldKt$TextField$interactionSource$2;
                    SolidColor solidColor = new SolidColor((Color)textFieldColors-dx8h9Zs.cursorColor(i189, composer, i129 |= i195).getValue().unbox-impl(), obj22, 0);
                    obj106 = anon;
                    obj118 = textFieldColors-dx8h9Zs;
                    obj112 = i189;
                    obj110 = i73;
                    super(value, obj108, field3, obj110, obj111, obj112, obj6, obj13, i95, obj21, obj3, obj118);
                    VisualTransformation visualTransformation5 = obj110;
                    Composer composer4 = composer;
                    BasicTextFieldKt.BasicTextField(value, onValueChange, SizeKt.defaultMinSize-VpY3zN4(TextFieldImplKt.defaultErrorSemantics(TextFieldDefaults.indicatorLine-gv0btCI$default(TextFieldDefaults.INSTANCE, obj107, obj108, obj109, (InteractionSource)$i$a$CacheTextFieldKt$TextField$interactionSource$2, textFieldColors-dx8h9Zs, 0, 0, 48, 0), i189, Strings_androidKt.getString-4foXLRw(Strings.Companion.getDefaultErrorMessage-UdPEhr4(), composer, 6)), TextFieldDefaults.INSTANCE.getMinWidth-D9Ej5fM(), TextFieldDefaults.INSTANCE.getMinHeight-D9Ej5fM()), field2, z4, $dirty17.merge(textStyle2), i34, shape3, field3, obj12, obj20, visualTransformation5, 0, obj111, (Brush)solidColor, (Function3)ComposableLambdaKt.rememberComposableLambda(-126640971, true, obj106, composer, 54), composer4, i124 | i143, i127 | i145, 4096);
                    composer2 = composer4;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    visualTransformation2 = field3;
                    singleLine2 = visualTransformation4;
                    obj14 = obj119;
                    $composer3 = obj120;
                    field = $dirty15;
                    i67 = skipping;
                    z3 = field2;
                    z = z4;
                    i41 = obj12;
                    i61 = obj20;
                    enabled2 = obj6;
                    readOnly2 = obj13;
                    i80 = i95;
                    i40 = modifier3;
                    shape2 = obj3;
                    maxLines2 = i34;
                    minLines2 = shape3;
                    keyboardOptions3 = obj21;
                    keyboardActions2 = i32;
                } else {
                    restartGroup.skipToGroupEnd();
                    i80 = leadingIcon;
                    singleLine2 = visualTransformation;
                    maxLines2 = keyboardOptions;
                    i41 = maxLines;
                    i61 = minLines;
                    i40 = interactionSource;
                    shape2 = shape;
                    i67 = obj124;
                    $dirty18 = $dirty15;
                    composer2 = restartGroup;
                    field = $dirty13;
                    z3 = field2;
                    z = z4;
                    obj14 = obj10;
                    enabled2 = visualTransformation3;
                    readOnly2 = obj9;
                    $composer3 = obj17;
                    keyboardOptions3 = trailingIcon;
                    keyboardActions2 = isError;
                    minLines2 = keyboardActions;
                    visualTransformation2 = singleLine;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new TextFieldKt.TextField.6(value, onValueChange, $composer3, z3, z, obj14, enabled2, readOnly2, i80, keyboardOptions3, keyboardActions2, singleLine2, maxLines2, minLines2, visualTransformation2, i41, i61, i40, shape2, field, $changed, $changed1, i24);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    public static final void TextField(TextFieldValue value, Function1 onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2 label, Function2 placeholder, Function2 leadingIcon, Function2 trailingIcon, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, MutableInteractionSource interactionSource, Shape shape, androidx.compose.material.TextFieldColors colors, Composer $composer, int $changed, int $changed1, int i23) {
        Object obj10;
        Object obj20;
        boolean z3;
        Object obj6;
        Object obj21;
        Object obj9;
        boolean z;
        int i17;
        Object obj7;
        Object obj11;
        int keyboardActions2;
        Object $dirty14;
        Object endRestartGroup;
        int modifier2;
        int defaultsInvalid;
        Object modifier3;
        int i37;
        int i31;
        int i13;
        int i45;
        Object textFieldColors-dx8h9Zs;
        boolean traceInProgress;
        Object $composer2;
        int $dirty;
        int $dirty2;
        int $dirty13;
        int this_$iv;
        int $dirty12;
        boolean z4;
        int $dirty15;
        Object $dirty1;
        boolean z6;
        Object obj2;
        Object obj3;
        Object modifier4;
        boolean invalid$iv;
        int textFieldShape;
        Object enabled2;
        boolean z2;
        Object readOnly2;
        int i32;
        Object obj17;
        Object obj5;
        int textStyle2;
        Object obj8;
        Object obj16;
        int label2;
        Object rememberedValue;
        Object obj19;
        int placeholder2;
        int i12;
        int i22;
        int consume;
        VisualTransformation leadingIcon2;
        int i6;
        int $i$a$CacheTextFieldKt$TextField$7;
        KeyboardOptions trailingIcon2;
        Object obj15;
        int i56;
        KeyboardActions isError2;
        Object str;
        VisualTransformation visualTransformation3;
        int visualTransformation2;
        int i51;
        KeyboardOptions keyboardOptions2;
        int keyboardOptions3;
        int i46;
        int i;
        KeyboardActions keyboardActions3;
        Object keyboardActions4;
        int changed4;
        int i11;
        Shape singleLine2;
        int i42;
        int i8;
        Object maxLines2;
        int i15;
        int i24;
        int i26;
        int i53;
        int i9;
        int changed6;
        int i48;
        Object i20;
        int changed;
        int i18;
        int i40;
        int i44;
        Object obj22;
        int colors2;
        int i33;
        int i50;
        int i16;
        int i4;
        int i52;
        int changed3;
        int i57;
        int changed5;
        int i38;
        int i7;
        int i3;
        int i49;
        int i14;
        int i43;
        int i28;
        int i29;
        boolean changed2;
        int i35;
        int i54;
        int i21;
        int i10;
        int i30;
        Composer $composer3;
        int i47;
        int i2;
        int i25;
        int i5;
        boolean z7;
        boolean z5;
        Object obj13;
        int i36;
        Object obj12;
        Object obj;
        int i39;
        int i27;
        int i34;
        Object obj4;
        KeyboardOptions keyboardOptions4;
        int i19;
        int i55;
        Object obj14;
        Object obj18;
        int i41;
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
        i45 = i23;
        textFieldColors-dx8h9Zs = $composer.startRestartGroup(-1576622884);
        ComposerKt.sourceInformation(textFieldColors-dx8h9Zs, "C(TextField)P(17,10,9,1,12,15,6,11,7,16,3,18,5,4,14,8,2,13)434@20918L7,445@21472L39,446@21550L14,447@21614L17,449@21640L408:TextField.kt#jmzs0o");
        $dirty = $changed;
        $dirty15 = $changed1;
        if (i45 & 1 != 0) {
            $dirty |= 6;
            obj2 = value;
        } else {
            if (i58 & 6 == 0) {
                i32 = textFieldColors-dx8h9Zs.changed(value) ? 4 : 2;
                $dirty |= i32;
            } else {
                obj2 = value;
            }
        }
        if (i45 & 2 != 0) {
            $dirty |= 48;
            obj17 = onValueChange;
        } else {
            if (i58 & 48 == 0) {
                i12 = textFieldColors-dx8h9Zs.changedInstance(onValueChange) ? 32 : 16;
                $dirty |= i12;
            } else {
                obj17 = onValueChange;
            }
        }
        consume = i45 & 4;
        if (consume != 0) {
            $dirty |= 384;
            str = modifier;
        } else {
            if (i58 & 384 == 0) {
                i51 = textFieldColors-dx8h9Zs.changed(modifier) ? 256 : 128;
                $dirty |= i51;
            } else {
                str = modifier;
            }
        }
        int i143 = i45 & 8;
        changed4 = 1024;
        if (i143 != 0) {
            $dirty |= 3072;
            invalid$iv = enabled;
        } else {
            if (i58 & 3072 == 0) {
                i42 = textFieldColors-dx8h9Zs.changed(enabled) ? i46 : changed4;
                $dirty |= i42;
            } else {
                invalid$iv = enabled;
            }
        }
        int i147 = i45 & 16;
        i26 = 8192;
        if (i147 != 0) {
            $dirty |= 24576;
            z2 = readOnly;
        } else {
            if (i58 & 24576 == 0) {
                i44 = textFieldColors-dx8h9Zs.changed(readOnly) ? i15 : i26;
                $dirty |= i44;
            } else {
                z2 = readOnly;
            }
        }
        int i151 = 196608;
        i4 = 65536;
        i52 = 131072;
        if (i58 & i151 == 0) {
            if (i45 & 32 == 0) {
                changed3 = textFieldColors-dx8h9Zs.changed(textStyle) ? i52 : i4;
            } else {
                obj8 = textStyle;
            }
            $dirty |= changed3;
        } else {
            obj8 = textStyle;
        }
        i57 = i45 & 64;
        final int i160 = 1572864;
        if (i57 != 0) {
            $dirty |= i160;
            rememberedValue = label;
        } else {
            if (i58 & i160 == 0) {
                i38 = textFieldColors-dx8h9Zs.changedInstance(label) ? 1048576 : 524288;
                $dirty |= i38;
            } else {
                rememberedValue = label;
            }
        }
        $i$a$CacheTextFieldKt$TextField$7 = i45 & 128;
        final int i154 = 12582912;
        if ($i$a$CacheTextFieldKt$TextField$7 != 0) {
            $dirty |= i154;
            obj15 = placeholder;
        } else {
            if (i58 & i154 == 0) {
                i3 = textFieldColors-dx8h9Zs.changedInstance(placeholder) ? 8388608 : 4194304;
                $dirty |= i3;
            } else {
                obj15 = placeholder;
            }
        }
        int i59 = i45 & 256;
        int i155 = 100663296;
        if (i59 != 0) {
            $dirty |= i155;
            i49 = i59;
            obj10 = leadingIcon;
        } else {
            if ($changed & i155 == 0) {
                i49 = i59;
                i14 = textFieldColors-dx8h9Zs.changedInstance(leadingIcon) ? 67108864 : 33554432;
                $dirty |= i14;
            } else {
                i49 = i59;
                obj10 = leadingIcon;
            }
        }
        int i60 = i45 & 512;
        int i157 = 805306368;
        if (i60 != 0) {
            $dirty |= i157;
            i43 = i60;
            obj20 = trailingIcon;
        } else {
            if ($changed & i157 == 0) {
                i43 = i60;
                i28 = textFieldColors-dx8h9Zs.changedInstance(trailingIcon) ? 536870912 : 268435456;
                $dirty |= i28;
            } else {
                i43 = i60;
                obj20 = trailingIcon;
            }
        }
        int i61 = i45 & 1024;
        if (i61 != 0) {
            $dirty15 |= 6;
            i29 = i61;
            z3 = isError;
        } else {
            if (i69 & 6 == 0) {
                i29 = i61;
                i18 = textFieldColors-dx8h9Zs.changed(isError) ? 4 : 2;
                $dirty15 |= i18;
            } else {
                i29 = i61;
                z3 = isError;
            }
        }
        int i62 = i45 & 2048;
        if (i62 != 0) {
            $dirty15 |= 48;
            i40 = i62;
            obj6 = visualTransformation;
        } else {
            if (i69 & 48 == 0) {
                i40 = i62;
                changed5 = textFieldColors-dx8h9Zs.changed(visualTransformation) ? 32 : 16;
                $dirty15 |= changed5;
            } else {
                i40 = i62;
                obj6 = visualTransformation;
            }
        }
        int i63 = i45 & 4096;
        if (i63 != 0) {
            $dirty15 |= 384;
            i50 = i63;
            obj21 = keyboardOptions;
        } else {
            i50 = i63;
            if (i69 & 384 == 0) {
                i38 = textFieldColors-dx8h9Zs.changed(keyboardOptions) ? 256 : 128;
                $dirty15 |= i38;
            } else {
                obj21 = keyboardOptions;
            }
        }
        if (i69 & 3072 == 0) {
            if (i45 & 8192 == 0) {
                if (textFieldColors-dx8h9Zs.changed(keyboardActions)) {
                } else {
                    i46 = changed4;
                }
            } else {
                obj9 = keyboardActions;
            }
            $dirty15 |= i46;
        } else {
            obj9 = keyboardActions;
        }
        int i66 = i45 & 16384;
        if (i66 != 0) {
            $dirty15 |= 24576;
            i = i66;
            z = singleLine;
        } else {
            i = i66;
            if (i69 & 24576 == 0) {
                if (textFieldColors-dx8h9Zs.changed(singleLine)) {
                } else {
                    i15 = i26;
                }
                $dirty15 |= i15;
            } else {
                z = singleLine;
            }
        }
        int i146 = i45 & i145;
        if (i146 != 0) {
            $dirty15 |= i151;
            i17 = maxLines;
        } else {
            if (i69 & i151 == 0) {
                i15 = textFieldColors-dx8h9Zs.changed(maxLines) ? i52 : i4;
                $dirty15 |= i15;
            } else {
                i17 = maxLines;
            }
        }
        i24 = i45 & i4;
        if (i24 != 0) {
            $dirty15 |= i160;
            obj7 = interactionSource;
        } else {
            if (i69 & i160 == 0) {
                i26 = textFieldColors-dx8h9Zs.changed(interactionSource) ? 1048576 : 524288;
                $dirty15 |= i26;
            } else {
                obj7 = interactionSource;
            }
        }
        if (i69 & i154 == 0) {
            if (i45 & i52 == 0) {
                i53 = textFieldColors-dx8h9Zs.changed(shape) ? 8388608 : 4194304;
            } else {
                obj11 = shape;
            }
            $dirty15 |= i53;
        } else {
            obj11 = shape;
        }
        int i152 = 262144;
        if (i69 & i155 == 0) {
            if (i45 & i152 == 0) {
                obj90 = $dirty15;
                i9 = textFieldColors-dx8h9Zs.changed(colors) ? 67108864 : 33554432;
            } else {
                obj90 = $dirty15;
                $dirty1 = colors;
            }
            keyboardActions2 = i48;
        } else {
            $dirty1 = colors;
            keyboardActions2 = obj90;
        }
        obj90 = $dirty;
        if ($dirty & i20 == 306783378 && i71 &= keyboardActions2 == 38347922) {
            if (i71 &= keyboardActions2 == 38347922) {
                if (!textFieldColors-dx8h9Zs.getSkipping()) {
                    textFieldColors-dx8h9Zs.startDefaults();
                    if ($changed & 1 != 0) {
                        if (textFieldColors-dx8h9Zs.getDefaultsInvalid()) {
                            if (consume != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = str;
                            }
                            z7 = i143 != 0 ? $dirty2 : invalid$iv;
                            z5 = i147 != 0 ? $dirty2 : z2;
                            if (i45 & 32 != 0) {
                                int i129 = 6;
                                z2 = 0;
                                ComposerKt.sourceInformationMarkerStart(textFieldColors-dx8h9Zs, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                ComposerKt.sourceInformationMarkerEnd(textFieldColors-dx8h9Zs);
                                obj13 = this_$iv;
                                i36 = invalid$iv;
                            } else {
                                i36 = obj90;
                                obj13 = obj8;
                            }
                            obj12 = i57 != 0 ? this_$iv : rememberedValue;
                            obj = $i$a$CacheTextFieldKt$TextField$7 != 0 ? this_$iv : obj15;
                            i39 = i49 != 0 ? this_$iv : leadingIcon;
                            i27 = i43 != 0 ? this_$iv : trailingIcon;
                            i34 = i29 != 0 ? this_$iv : isError;
                            if (i40 != 0) {
                                obj4 = this_$iv;
                            } else {
                                obj4 = visualTransformation;
                            }
                            if (i50 != 0) {
                                keyboardOptions4 = this_$iv;
                            } else {
                                keyboardOptions4 = keyboardOptions;
                            }
                            if (i45 & 8192 != 0) {
                                super(0, 0, 0, 0, 0, 0, 63, 0);
                                $dirty12 = $dirty16;
                                $dirty14 = keyboardActions5;
                            } else {
                                $dirty12 = keyboardActions2;
                                $dirty14 = keyboardActions;
                            }
                            i19 = i != 0 ? invalid$iv : singleLine;
                            i55 = i146 != 0 ? invalid$iv : maxLines;
                            if (i24 != 0) {
                                ComposerKt.sourceInformationMarkerStart(textFieldColors-dx8h9Zs, -53648114, "CC(remember):TextField.kt#9igjgp");
                                int i128 = 0;
                                z2 = textFieldColors-dx8h9Zs;
                                obj8 = 0;
                                rememberedValue = z2.rememberedValue();
                                consume = 0;
                                if (rememberedValue == Composer.Companion.getEmpty()) {
                                    int i140 = 0;
                                    z2.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                                } else {
                                    $i$a$CacheTextFieldKt$TextField$7 = rememberedValue;
                                }
                                ComposerKt.sourceInformationMarkerEnd(textFieldColors-dx8h9Zs);
                                obj14 = invalid$iv;
                            } else {
                                obj14 = interactionSource;
                            }
                            if (i45 & i52 != 0) {
                                obj18 = textFieldShape;
                                i41 = $dirty12;
                            } else {
                                obj18 = shape;
                                i41 = $dirty12;
                            }
                            if (i45 & i152 != 0) {
                                keyboardActions3 = $dirty14;
                                obj3 = modifier3;
                                obj22 = textFieldColors-dx8h9Zs;
                                keyboardActions2 = $dirty13;
                                invalid$iv = z7;
                                z2 = z5;
                                obj5 = obj13;
                                modifier2 = i36;
                                obj16 = obj12;
                                obj19 = obj;
                                i22 = i39;
                                i6 = i27;
                                i56 = i34;
                                visualTransformation3 = obj4;
                                keyboardOptions2 = keyboardOptions4;
                                i11 = i19;
                                i8 = i55;
                                i20 = obj14;
                                i40 = obj18;
                            } else {
                                $composer3 = textFieldColors-dx8h9Zs;
                                obj22 = colors;
                                keyboardActions3 = $dirty14;
                                obj3 = modifier3;
                                invalid$iv = z7;
                                z2 = z5;
                                obj5 = obj13;
                                modifier2 = i36;
                                obj16 = obj12;
                                obj19 = obj;
                                i22 = i39;
                                i6 = i27;
                                i56 = i34;
                                visualTransformation3 = obj4;
                                keyboardOptions2 = keyboardOptions4;
                                i11 = i19;
                                i8 = i55;
                                i20 = obj14;
                                i40 = obj18;
                                keyboardActions2 = i41;
                            }
                        } else {
                            textFieldColors-dx8h9Zs.skipToGroupEnd();
                            $dirty13 = i45 & 32 != 0 ? obj90 & i37 : obj90;
                            if (i45 & 8192 != 0) {
                                keyboardActions2 &= -7169;
                            }
                            if (i45 & i52 != 0) {
                                keyboardActions2 &= i31;
                            }
                            if (i45 & i152 != 0) {
                                keyboardActions2 &= i13;
                            }
                            i22 = leadingIcon;
                            i6 = trailingIcon;
                            keyboardOptions2 = keyboardOptions;
                            keyboardActions3 = keyboardActions;
                            i11 = singleLine;
                            i8 = maxLines;
                            i20 = interactionSource;
                            i40 = shape;
                            $composer3 = textFieldColors-dx8h9Zs;
                            modifier2 = $dirty13;
                            obj22 = $dirty1;
                            obj5 = obj8;
                            obj16 = rememberedValue;
                            obj19 = obj15;
                            obj3 = str;
                            i56 = isError;
                            visualTransformation3 = visualTransformation;
                        }
                    } else {
                    }
                    $composer3.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1576622884, modifier2, keyboardActions2, "androidx.compose.material.TextField (TextField.kt:448)");
                    }
                    TextFieldKt.TextField(value, onValueChange, obj3, invalid$iv, z2, obj5, obj16, obj19, i22, i6, i56, visualTransformation3, keyboardOptions2, keyboardActions3, i11, i8, 1, i20, i40, obj22, $composer3, i81 | i105, i90 | i118, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i16 = modifier2;
                    $composer2 = obj3;
                    z4 = invalid$iv;
                    z6 = z2;
                    modifier4 = obj5;
                    enabled2 = obj16;
                    readOnly2 = obj19;
                    textStyle2 = i22;
                    label2 = i6;
                    placeholder2 = i56;
                    leadingIcon2 = visualTransformation3;
                    trailingIcon2 = keyboardOptions2;
                    isError2 = keyboardActions3;
                    visualTransformation2 = i11;
                    keyboardOptions3 = i8;
                    keyboardActions4 = i20;
                    singleLine2 = i40;
                    maxLines2 = obj22;
                    colors2 = keyboardActions2;
                } else {
                    textFieldColors-dx8h9Zs.skipToGroupEnd();
                    textStyle2 = leadingIcon;
                    leadingIcon2 = visualTransformation;
                    trailingIcon2 = keyboardOptions;
                    keyboardOptions3 = maxLines;
                    keyboardActions4 = interactionSource;
                    singleLine2 = shape;
                    i16 = obj90;
                    $composer3 = textFieldColors-dx8h9Zs;
                    maxLines2 = $dirty1;
                    z4 = invalid$iv;
                    z6 = z2;
                    modifier4 = obj8;
                    enabled2 = rememberedValue;
                    readOnly2 = obj15;
                    $composer2 = str;
                    label2 = trailingIcon;
                    placeholder2 = isError;
                    isError2 = keyboardActions;
                    visualTransformation2 = singleLine;
                    colors2 = keyboardActions2;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = $composer3.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new TextFieldKt.TextField.8(value, onValueChange, $composer2, z4, z6, modifier4, enabled2, readOnly2, textStyle2, label2, placeholder2, leadingIcon2, trailingIcon2, isError2, visualTransformation2, keyboardOptions3, keyboardActions4, singleLine2, maxLines2, $changed, $changed1, i45);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    public static final void TextField(String value, Function1<? super String, Unit> onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> label, Function2<? super Composer, ? super Integer, Unit> placeholder, Function2<? super Composer, ? super Integer, Unit> leadingIcon, Function2<? super Composer, ? super Integer, Unit> trailingIcon, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, int minLines, MutableInteractionSource interactionSource, Shape shape, androidx.compose.material.TextFieldColors colors, Composer $composer, int $changed, int $changed1, int i24) {
        Object obj13;
        Object obj17;
        boolean z2;
        Object obj10;
        Object obj2;
        Object obj18;
        boolean z;
        int i75;
        int i71;
        Object obj3;
        Object obj15;
        int $dirty14;
        Object $dirty18;
        Object $dirty16;
        Object endRestartGroup;
        int skipping;
        int $dirty4;
        int $dirty2;
        int $dirty1;
        int defaultsInvalid;
        Object modifier3;
        int $i$a$CacheTextFieldKt$TextField$interactionSource$1;
        boolean traceInProgress;
        int $composer3;
        int i22;
        Object $composer2;
        int $dirty;
        int $dirty3;
        int i10;
        int i16;
        Object textFieldColors-dx8h9Zs;
        int default;
        int $dirty12;
        boolean z3;
        int $dirty15;
        Object $dirty17;
        Composer composer3;
        boolean z4;
        Object obj8;
        int i61;
        Object obj16;
        boolean str;
        int i67;
        int i73;
        int textFieldShape;
        Object enabled2;
        boolean z7;
        Object readOnly2;
        int i11;
        Object obj4;
        boolean traceInProgress2;
        int value2;
        int i77;
        Object obj11;
        KeyboardOptions i62;
        int keyboardOptions3;
        Object visualTransformation3;
        Object shape3;
        int keyboardActions2;
        int i78;
        int field;
        int i99;
        VisualTransformation singleLine2;
        int obj14;
        int i3;
        KeyboardOptions maxLines2;
        Object obj20;
        int obj12;
        KeyboardActions minLines2;
        Object obj5;
        int visualTransformation2;
        int i85;
        int i23;
        int i4;
        int i29;
        int i63;
        int i60;
        int changed7;
        int i50;
        int changed6;
        int i81;
        long $this$takeOrElse_u2dDxMtmZc$iv;
        int i31;
        int i66;
        int companion;
        Shape shape2;
        int i39;
        int i82;
        long unbox-impl;
        Object field2;
        int i58;
        int i46;
        int i90;
        int i7;
        int i69;
        int changed3;
        int i101;
        int i91;
        int i13;
        int i14;
        int i52;
        int $dirty13;
        int i55;
        int changed5;
        int changed2;
        int i44;
        int i19;
        int changed4;
        int i70;
        int i92;
        int i83;
        int i88;
        int i38;
        int i53;
        int i64;
        int i25;
        int i72;
        boolean changed;
        int i6;
        int i5;
        int i41;
        int i33;
        int i94;
        int i17;
        int i42;
        int i9;
        int i40;
        int i15;
        int i27;
        int i65;
        int i89;
        Composer composer2;
        Composer composer;
        int i74;
        int i79;
        int i30;
        int i48;
        boolean z5;
        boolean z6;
        Object obj7;
        int i54;
        Object obj6;
        Object obj21;
        int i47;
        int obj19;
        int obj9;
        int i;
        VisualTransformation i68;
        KeyboardOptions keyboardOptions2;
        int i87;
        int i93;
        int i76;
        int modifier2;
        Shape obj;
        int i18;
        int i2;
        TextStyle textStyle2;
        long l;
        int i57;
        int i86;
        int i8;
        int i49;
        int i84;
        int i97;
        int i34;
        int i43;
        int i95;
        int i51;
        int i80;
        int i32;
        int i35;
        int i100;
        int i20;
        int i45;
        int i28;
        int i26;
        int i12;
        int i56;
        int i21;
        int i37;
        int i59;
        int i98;
        int i36;
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
        traceInProgress = i24;
        Composer restartGroup = $composer.startRestartGroup(-1504264404);
        ComposerKt.sourceInformation(restartGroup, "C(TextField)P(18,11,10,1,13,16,6,12,7,17,3,19,5,4,15,8,9,2,14)165@8582L7,178@9226L14,179@9290L17,194@9914L38,203@10281L20,211@10623L719,190@9731L1617:TextField.kt#jmzs0o");
        $dirty = $changed;
        $dirty15 = $changed1;
        if (traceInProgress & 1 != 0) {
            $dirty |= 6;
            obj8 = value;
        } else {
            if (i102 & 6 == 0) {
                i11 = restartGroup.changed(value) ? 4 : 2;
                $dirty |= i11;
            } else {
                obj8 = value;
            }
        }
        if (traceInProgress & 2 != 0) {
            $dirty |= 48;
            obj4 = onValueChange;
        } else {
            if (i102 & 48 == 0) {
                i78 = restartGroup.changedInstance(onValueChange) ? 32 : 16;
                $dirty |= i78;
            } else {
                obj4 = onValueChange;
            }
        }
        i99 = traceInProgress & 4;
        if (i99 != 0) {
            $dirty |= 384;
            obj5 = modifier;
        } else {
            if (i102 & 384 == 0) {
                i85 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty |= i85;
            } else {
                obj5 = modifier;
            }
        }
        i23 = traceInProgress & 8;
        changed7 = 1024;
        if (i23 != 0) {
            $dirty |= 3072;
            str = enabled;
        } else {
            if (i102 & 3072 == 0) {
                i66 = restartGroup.changed(enabled) ? i29 : changed7;
                $dirty |= i66;
            } else {
                str = enabled;
            }
        }
        companion = traceInProgress & 16;
        if (companion != 0) {
            $dirty |= 24576;
            z7 = readOnly;
        } else {
            if (i102 & 24576 == 0) {
                i90 = restartGroup.changed(readOnly) ? 16384 : i39;
                $dirty |= i90;
            } else {
                z7 = readOnly;
            }
        }
        if (i102 & i210 == 0) {
            if (traceInProgress & 32 == 0) {
                changed3 = restartGroup.changed(textStyle) ? 131072 : 65536;
            } else {
                obj11 = textStyle;
            }
            $dirty |= changed3;
        } else {
            obj11 = textStyle;
        }
        i101 = traceInProgress & 64;
        i91 = 1572864;
        i44 = 524288;
        if (i101 != 0) {
            $dirty |= i91;
            visualTransformation3 = label;
        } else {
            if (i102 & i91 == 0) {
                i70 = restartGroup.changedInstance(label) ? 1048576 : i44;
                $dirty |= i70;
            } else {
                visualTransformation3 = label;
            }
        }
        i3 = traceInProgress & 128;
        i92 = 12582912;
        if (i3 != 0) {
            $dirty |= i92;
            obj20 = placeholder;
        } else {
            if (i102 & i92 == 0) {
                i88 = restartGroup.changedInstance(placeholder) ? 8388608 : 4194304;
                $dirty |= i88;
            } else {
                obj20 = placeholder;
            }
        }
        int i103 = traceInProgress & 256;
        int i219 = 100663296;
        if (i103 != 0) {
            $dirty |= i219;
            i38 = i103;
            obj13 = leadingIcon;
        } else {
            if ($changed & i219 == 0) {
                i38 = i103;
                i53 = restartGroup.changedInstance(leadingIcon) ? 67108864 : 33554432;
                $dirty |= i53;
            } else {
                i38 = i103;
                obj13 = leadingIcon;
            }
        }
        int i104 = traceInProgress & 512;
        int i221 = 805306368;
        if (i104 != 0) {
            $dirty |= i221;
            i64 = i104;
            obj17 = trailingIcon;
        } else {
            if ($changed & i221 == 0) {
                i64 = i104;
                i25 = restartGroup.changedInstance(trailingIcon) ? 536870912 : 268435456;
                $dirty |= i25;
            } else {
                i64 = i104;
                obj17 = trailingIcon;
            }
        }
        int i105 = traceInProgress & 1024;
        if (i105 != 0) {
            $dirty15 |= 6;
            i72 = i105;
            z2 = isError;
        } else {
            if (i114 & 6 == 0) {
                i72 = i105;
                i58 = restartGroup.changed(isError) ? 4 : 2;
                $dirty15 |= i58;
            } else {
                i72 = i105;
                z2 = isError;
            }
        }
        int i106 = traceInProgress & 2048;
        if (i106 != 0) {
            $dirty15 |= 48;
            i46 = i106;
            obj10 = visualTransformation;
        } else {
            if (i114 & 48 == 0) {
                i46 = i106;
                changed4 = restartGroup.changed(visualTransformation) ? 32 : 16;
                $dirty15 |= changed4;
            } else {
                i46 = i106;
                obj10 = visualTransformation;
            }
        }
        int i107 = traceInProgress & 4096;
        if (i107 != 0) {
            $dirty15 |= 384;
            i69 = i107;
            obj2 = keyboardOptions;
        } else {
            i69 = i107;
            if (i114 & 384 == 0) {
                i70 = restartGroup.changed(keyboardOptions) ? 256 : 128;
                $dirty15 |= i70;
            } else {
                obj2 = keyboardOptions;
            }
        }
        if (i114 & 3072 == 0) {
            if (traceInProgress & 8192 == 0) {
                if (restartGroup.changed(keyboardActions)) {
                } else {
                    i29 = changed7;
                }
            } else {
                obj18 = keyboardActions;
            }
            $dirty15 |= i29;
        } else {
            obj18 = keyboardActions;
        }
        int i110 = traceInProgress & 16384;
        if (i110 != 0) {
            $dirty15 |= 24576;
            i63 = i110;
            z = singleLine;
        } else {
            i63 = i110;
            if (i114 & 24576 == 0) {
                if (restartGroup.changed(singleLine)) {
                    i39 = 16384;
                }
                $dirty15 |= i39;
            } else {
                z = singleLine;
            }
        }
        if (i114 & i200 == 0) {
            if (traceInProgress & i201 == 0) {
                i50 = restartGroup.changed(maxLines) ? 131072 : 65536;
            } else {
                i75 = maxLines;
            }
            $dirty15 |= i50;
        } else {
            i75 = maxLines;
        }
        i81 = traceInProgress & i202;
        if (i81 != 0) {
            $dirty15 |= i91;
            i71 = minLines;
        } else {
            if (i114 & i91 == 0) {
                i39 = restartGroup.changed(minLines) ? 1048576 : i44;
                $dirty15 |= i39;
            } else {
                i71 = minLines;
            }
        }
        i82 = traceInProgress & i206;
        if (i82 != 0) {
            $dirty15 |= i92;
            obj3 = interactionSource;
        } else {
            if (i114 & i92 == 0) {
                i91 = restartGroup.changed(interactionSource) ? 8388608 : 4194304;
                $dirty15 |= i91;
            } else {
                obj3 = interactionSource;
            }
        }
        if (i114 & i213 == 0) {
            if (traceInProgress & i215 == 0) {
                i13 = restartGroup.changed(shape) ? 67108864 : 33554432;
            } else {
                obj15 = shape;
            }
            $dirty15 |= i13;
        } else {
            obj15 = shape;
        }
        if (i114 & i214 == 0) {
            if (traceInProgress & i44 == 0) {
                obj124 = $dirty15;
                i55 = restartGroup.changed(colors) ? 536870912 : 268435456;
            } else {
                obj124 = $dirty15;
                $dirty17 = colors;
            }
            $dirty14 = i14;
        } else {
            $dirty17 = colors;
            $dirty14 = obj124;
        }
        obj124 = $dirty;
        if ($dirty & i52 == 306783378 && i128 &= $dirty14 == 306783378) {
            if (i128 &= $dirty14 == 306783378) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    default = -458753;
                    int i160 = 6;
                    int i163 = 1;
                    if ($changed & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if (i99 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = obj5;
                            }
                            z5 = i23 != 0 ? str : str;
                            z6 = companion != 0 ? str : z7;
                            if (traceInProgress & 32 != 0) {
                                z7 = 6;
                                i99 = 0;
                                ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                                obj7 = default;
                                i54 = i67;
                            } else {
                                i23 = default;
                                i54 = obj124;
                                obj7 = obj11;
                            }
                            obj6 = i101 != 0 ? default : visualTransformation3;
                            obj21 = i3 != 0 ? default : obj20;
                            i47 = i38 != 0 ? default : leadingIcon;
                            obj19 = i64 != 0 ? default : trailingIcon;
                            obj9 = i72 != 0 ? default : isError;
                            if (i46 != 0) {
                                i68 = default;
                            } else {
                                i68 = visualTransformation;
                            }
                            if (i69 != 0) {
                                keyboardOptions2 = default;
                            } else {
                                keyboardOptions2 = keyboardOptions;
                            }
                            if (traceInProgress & 8192 != 0) {
                                super(0, 0, 0, 0, 0, 0, 63, 0);
                                $dirty12 = $dirty19;
                                $dirty16 = i96;
                            } else {
                                $dirty12 = $dirty14;
                                $dirty16 = keyboardActions;
                            }
                            i87 = i63 != 0 ? i67 : singleLine;
                            if (i167 &= traceInProgress != 0) {
                                i73 = i87 != 0 ? i163 : 0x7fffffff /* Unknown resource */;
                                $dirty12 &= i23;
                                i93 = i73;
                            } else {
                                i93 = maxLines;
                            }
                            i76 = i81 != 0 ? i73 : minLines;
                            modifier2 = i82 != 0 ? i73 : interactionSource;
                            if (i168 &= traceInProgress != 0) {
                                obj = textFieldShape;
                                i18 = $dirty12;
                            } else {
                                obj = shape;
                                i18 = $dirty12;
                            }
                            if (traceInProgress & i44 != 0) {
                                int i172 = i163;
                                int i179 = i169;
                                int i185 = i179;
                                int i188 = i180;
                                i23 = i188;
                                i81 = i23;
                                i82 = i81;
                                i69 = i82;
                                i52 = i69;
                                changed4 = i52;
                                i92 = changed4;
                                i38 = i92;
                                i72 = i38;
                                i6 = i72;
                                i41 = i6;
                                i94 = i41;
                                i42 = i94;
                                i40 = i42;
                                i27 = i40;
                                i89 = i27;
                                i2 = i234;
                                composer2 = restartGroup;
                                $composer3 = i96;
                                textFieldColors-dx8h9Zs = TextFieldDefaults.INSTANCE.textFieldColors-dx8h9Zs(0, i163, 0, i172, 0, i179, 0, i185, 0, i188, 0, i23, 0, i81, 0, i82, 0, i69, 0, i52, 0, changed4, 0, i92, 0, i38);
                                composer3 = composer2;
                                shape3 = $dirty16;
                                obj5 = modifier3;
                                $dirty2 = i165;
                                str = z5;
                                z7 = z6;
                                $dirty18 = obj7;
                                i61 = i54;
                                i62 = keyboardOptions2;
                                field = i87;
                                obj14 = i93;
                                obj12 = i76;
                            } else {
                                composer3 = restartGroup;
                                $composer3 = i96;
                                textFieldColors-dx8h9Zs = colors;
                                shape3 = $dirty16;
                                obj5 = modifier3;
                                str = z5;
                                z7 = z6;
                                $dirty18 = obj7;
                                i61 = i54;
                                i62 = keyboardOptions2;
                                field = i87;
                                obj14 = i93;
                                obj12 = i76;
                                $dirty2 = i18;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            $dirty4 = traceInProgress & 32 != 0 ? obj124 & default : obj124;
                            if (traceInProgress & 8192 != 0) {
                                $dirty14 &= -7169;
                            }
                            if (i183 &= traceInProgress != 0) {
                                $dirty14 &= default;
                            }
                            if (i156 &= traceInProgress != 0) {
                                $dirty14 &= i10;
                            }
                            if (traceInProgress & i44 != 0) {
                                $dirty14 &= i16;
                            }
                            composer3 = restartGroup;
                            $composer3 = i157;
                            i47 = leadingIcon;
                            obj19 = trailingIcon;
                            obj9 = isError;
                            i68 = visualTransformation;
                            field = singleLine;
                            obj14 = maxLines;
                            modifier2 = interactionSource;
                            obj = shape;
                            textFieldColors-dx8h9Zs = colors;
                            i61 = $dirty4;
                            obj6 = visualTransformation3;
                            obj21 = obj20;
                            shape3 = keyboardActions;
                            obj12 = minLines;
                            $dirty2 = $dirty14;
                            $dirty18 = obj11;
                            i62 = keyboardOptions;
                        }
                    } else {
                    }
                    composer3.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1504264404, i61, $dirty2, "androidx.compose.material.TextField (TextField.kt:180)");
                    }
                    if (modifier2 == 0) {
                        composer3.startReplaceGroup(-1675073900);
                        ComposerKt.sourceInformation(composer3, "182@9393L39");
                        ComposerKt.sourceInformationMarkerStart(composer3, -54034642, "CC(remember):TextField.kt#9igjgp");
                        $composer3 = 0;
                        traceInProgress2 = composer3;
                        i23 = 0;
                        $dirty13 = $dirty2;
                        $dirty1 = traceInProgress2.rememberedValue();
                        i81 = 0;
                        if ($dirty1 == Composer.Companion.getEmpty()) {
                            int i146 = 0;
                            traceInProgress2.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                        } else {
                            $i$a$CacheTextFieldKt$TextField$interactionSource$1 = $dirty1;
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endReplaceGroup();
                    } else {
                        $dirty13 = $dirty2;
                        composer3.startReplaceGroup(-54035293);
                        composer3.endReplaceGroup();
                        $i$a$CacheTextFieldKt$TextField$interactionSource$1 = modifier2;
                    }
                    composer3.startReplaceGroup(-54029535);
                    ComposerKt.sourceInformation(composer3, "*185@9580L18");
                    int i117 = 0;
                    i22 = 0;
                    value2 = Long.compare(unbox-impl, i211) != 0 ? 1 : 0;
                    if (value2 != null) {
                    } else {
                        i22 = 0;
                        $this$takeOrElse_u2dDxMtmZc$iv = unbox-impl;
                    }
                    composer3.endReplaceGroup();
                    textStyle2 = new TextStyle($this$takeOrElse_u2dDxMtmZc$iv, obj72, 0, obj74, 0, 0, 0, 0, 0, 0, obj81, 0, 0, 0, 0, obj86, 0, 0, 0, 0, 0, 0, obj93, 0, 0, 0, 0, 0, 0, 16777214, 0);
                    obj108 = str;
                    obj107 = obj5;
                    obj109 = obj9;
                    Object obj22 = obj107;
                    int i189 = obj109;
                    obj111 = $i$a$CacheTextFieldKt$TextField$interactionSource$1;
                    SolidColor solidColor = new SolidColor((Color)textFieldColors-dx8h9Zs.cursorColor(i189, composer3, i129 |= i195).getValue().unbox-impl(), obj22, 0);
                    obj106 = anon;
                    obj118 = textFieldColors-dx8h9Zs;
                    obj112 = i189;
                    obj110 = i68;
                    super(value, obj108, field, obj110, obj111, obj112, obj6, obj21, i47, obj19, obj, obj118);
                    VisualTransformation visualTransformation5 = obj110;
                    Composer composer4 = composer3;
                    BasicTextFieldKt.BasicTextField(value, onValueChange, SizeKt.defaultMinSize-VpY3zN4(TextFieldImplKt.defaultErrorSemantics(TextFieldDefaults.indicatorLine-gv0btCI$default(TextFieldDefaults.INSTANCE, obj107, obj108, obj109, (InteractionSource)$i$a$CacheTextFieldKt$TextField$interactionSource$1, textFieldColors-dx8h9Zs, 0, 0, 48, 0), i189, Strings_androidKt.getString-4foXLRw(Strings.Companion.getDefaultErrorMessage-UdPEhr4(), composer3, 6)), TextFieldDefaults.INSTANCE.getMinWidth-D9Ej5fM(), TextFieldDefaults.INSTANCE.getMinHeight-D9Ej5fM()), str, z7, $dirty18.merge(textStyle2), i62, shape3, field, obj14, obj12, visualTransformation5, 0, obj111, (Brush)solidColor, (Function3)ComposableLambdaKt.rememberComposableLambda(989834338, true, obj106, composer3, 54), composer4, i124 | i143, i127 | i145, 4096);
                    composer = composer4;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    visualTransformation2 = field;
                    singleLine2 = visualTransformation4;
                    obj16 = obj119;
                    $composer2 = obj120;
                    field2 = $dirty14;
                    i19 = skipping;
                    z3 = str;
                    z4 = z7;
                    i4 = obj14;
                    i60 = obj12;
                    enabled2 = obj6;
                    readOnly2 = obj21;
                    i77 = i47;
                    i31 = modifier2;
                    shape2 = obj;
                    maxLines2 = i62;
                    minLines2 = shape3;
                    keyboardOptions3 = obj19;
                    keyboardActions2 = i;
                } else {
                    restartGroup.skipToGroupEnd();
                    i77 = leadingIcon;
                    singleLine2 = visualTransformation;
                    maxLines2 = keyboardOptions;
                    i4 = maxLines;
                    i60 = minLines;
                    i31 = interactionSource;
                    shape2 = shape;
                    i19 = obj124;
                    $dirty13 = $dirty14;
                    composer = restartGroup;
                    field2 = $dirty17;
                    z3 = str;
                    z4 = z7;
                    obj16 = obj11;
                    enabled2 = visualTransformation3;
                    readOnly2 = obj20;
                    $composer2 = obj5;
                    keyboardOptions3 = trailingIcon;
                    keyboardActions2 = isError;
                    minLines2 = keyboardActions;
                    visualTransformation2 = singleLine;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new TextFieldKt.TextField.2(value, onValueChange, $composer2, z3, z4, obj16, enabled2, readOnly2, i77, keyboardOptions3, keyboardActions2, singleLine2, maxLines2, minLines2, visualTransformation2, i4, i60, i31, shape2, field2, $changed, $changed1, i24);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    public static final void TextField(String value, Function1 onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2 label, Function2 placeholder, Function2 leadingIcon, Function2 trailingIcon, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, MutableInteractionSource interactionSource, Shape shape, androidx.compose.material.TextFieldColors colors, Composer $composer, int $changed, int $changed1, int i23) {
        Object obj2;
        Object obj12;
        boolean z2;
        Object obj7;
        Object obj21;
        Object obj10;
        boolean z7;
        int i47;
        Object obj14;
        Object obj19;
        int keyboardActions3;
        Object $dirty14;
        Object endRestartGroup;
        int modifier3;
        int defaultsInvalid;
        Object modifier2;
        int i32;
        int i20;
        int i35;
        int i40;
        Object textFieldColors-dx8h9Zs;
        boolean traceInProgress;
        Object $composer3;
        int $dirty;
        int $dirty2;
        int $dirty15;
        int this_$iv;
        int $dirty1;
        boolean z;
        int $dirty13;
        Object $dirty12;
        boolean z4;
        Object obj18;
        Object obj6;
        Object modifier4;
        boolean invalid$iv;
        int copy$default;
        Object enabled2;
        boolean z6;
        Object readOnly2;
        int i11;
        Object obj9;
        Object obj15;
        int textStyle2;
        Object zeroCornerSize;
        Object obj8;
        int label2;
        Object rememberedValue;
        Object obj17;
        int placeholder2;
        int i4;
        int i;
        int consume;
        VisualTransformation leadingIcon2;
        int i14;
        int $i$a$CacheTextFieldKt$TextField$3;
        KeyboardOptions trailingIcon2;
        Object obj13;
        int i38;
        KeyboardActions isError2;
        Object str;
        VisualTransformation visualTransformation3;
        int visualTransformation2;
        int i55;
        KeyboardOptions keyboardOptions2;
        int keyboardOptions3;
        int i9;
        int i56;
        KeyboardActions keyboardActions5;
        Object keyboardActions2;
        int changed;
        int i28;
        CornerBasedShape singleLine2;
        int i37;
        int i54;
        Object maxLines2;
        int i42;
        int i16;
        int i27;
        int i43;
        int i44;
        int changed2;
        int i3;
        Object i21;
        int changed3;
        int i25;
        int i45;
        int i6;
        Object obj4;
        int colors2;
        int i31;
        int i8;
        int i7;
        int i5;
        int i24;
        int changed4;
        int i33;
        int changed5;
        int i12;
        int i50;
        int i57;
        int i51;
        int i2;
        int i52;
        int i39;
        int i13;
        boolean changed6;
        int i36;
        int i46;
        int i17;
        int i41;
        int i53;
        Composer $composer2;
        int i48;
        int i29;
        int i26;
        int i15;
        boolean z3;
        boolean z5;
        Object obj20;
        int i30;
        Object obj3;
        Object obj;
        int i18;
        int i10;
        int i19;
        Object obj16;
        KeyboardOptions keyboardOptions4;
        int i34;
        int i22;
        Object obj11;
        Object obj5;
        int i49;
        ScopeUpdateScope scopeUpdateScope;
        KeyboardActions keyboardActions4;
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
        i40 = i23;
        textFieldColors-dx8h9Zs = $composer.startRestartGroup(-1690895095);
        ComposerKt.sourceInformation(textFieldColors-dx8h9Zs, "C(TextField)P(17,10,9,1,12,15,6,11,7,16,3,18,5,4,14,8,2,13)243@11701L7,254@12255L39,256@12337L6,257@12462L17,259@12488L408:TextField.kt#jmzs0o");
        $dirty = $changed;
        $dirty13 = $changed1;
        if (i40 & 1 != 0) {
            $dirty |= 6;
            obj18 = value;
        } else {
            if (i58 & 6 == 0) {
                i11 = textFieldColors-dx8h9Zs.changed(value) ? 4 : 2;
                $dirty |= i11;
            } else {
                obj18 = value;
            }
        }
        if (i40 & 2 != 0) {
            $dirty |= 48;
            obj9 = onValueChange;
        } else {
            if (i58 & 48 == 0) {
                i4 = textFieldColors-dx8h9Zs.changedInstance(onValueChange) ? 32 : 16;
                $dirty |= i4;
            } else {
                obj9 = onValueChange;
            }
        }
        consume = i40 & 4;
        if (consume != 0) {
            $dirty |= 384;
            str = modifier;
        } else {
            if (i58 & 384 == 0) {
                i55 = textFieldColors-dx8h9Zs.changed(modifier) ? 256 : 128;
                $dirty |= i55;
            } else {
                str = modifier;
            }
        }
        int i143 = i40 & 8;
        changed = 1024;
        if (i143 != 0) {
            $dirty |= 3072;
            invalid$iv = enabled;
        } else {
            if (i58 & 3072 == 0) {
                i37 = textFieldColors-dx8h9Zs.changed(enabled) ? i9 : changed;
                $dirty |= i37;
            } else {
                invalid$iv = enabled;
            }
        }
        int i147 = i40 & 16;
        i27 = 8192;
        if (i147 != 0) {
            $dirty |= 24576;
            z6 = readOnly;
        } else {
            if (i58 & 24576 == 0) {
                i6 = textFieldColors-dx8h9Zs.changed(readOnly) ? i42 : i27;
                $dirty |= i6;
            } else {
                z6 = readOnly;
            }
        }
        int i151 = 196608;
        i5 = 65536;
        i24 = 131072;
        if (i58 & i151 == 0) {
            if (i40 & 32 == 0) {
                changed4 = textFieldColors-dx8h9Zs.changed(textStyle) ? i24 : i5;
            } else {
                zeroCornerSize = textStyle;
            }
            $dirty |= changed4;
        } else {
            zeroCornerSize = textStyle;
        }
        i33 = i40 & 64;
        final int i160 = 1572864;
        if (i33 != 0) {
            $dirty |= i160;
            rememberedValue = label;
        } else {
            if (i58 & i160 == 0) {
                i12 = textFieldColors-dx8h9Zs.changedInstance(label) ? 1048576 : 524288;
                $dirty |= i12;
            } else {
                rememberedValue = label;
            }
        }
        $i$a$CacheTextFieldKt$TextField$3 = i40 & 128;
        final int i154 = 12582912;
        if ($i$a$CacheTextFieldKt$TextField$3 != 0) {
            $dirty |= i154;
            obj13 = placeholder;
        } else {
            if (i58 & i154 == 0) {
                i57 = textFieldColors-dx8h9Zs.changedInstance(placeholder) ? 8388608 : 4194304;
                $dirty |= i57;
            } else {
                obj13 = placeholder;
            }
        }
        int i59 = i40 & 256;
        int i155 = 100663296;
        if (i59 != 0) {
            $dirty |= i155;
            i51 = i59;
            obj2 = leadingIcon;
        } else {
            if ($changed & i155 == 0) {
                i51 = i59;
                i2 = textFieldColors-dx8h9Zs.changedInstance(leadingIcon) ? 67108864 : 33554432;
                $dirty |= i2;
            } else {
                i51 = i59;
                obj2 = leadingIcon;
            }
        }
        int i60 = i40 & 512;
        int i157 = 805306368;
        if (i60 != 0) {
            $dirty |= i157;
            i52 = i60;
            obj12 = trailingIcon;
        } else {
            if ($changed & i157 == 0) {
                i52 = i60;
                i39 = textFieldColors-dx8h9Zs.changedInstance(trailingIcon) ? 536870912 : 268435456;
                $dirty |= i39;
            } else {
                i52 = i60;
                obj12 = trailingIcon;
            }
        }
        int i61 = i40 & 1024;
        if (i61 != 0) {
            $dirty13 |= 6;
            i13 = i61;
            z2 = isError;
        } else {
            if (i69 & 6 == 0) {
                i13 = i61;
                i25 = textFieldColors-dx8h9Zs.changed(isError) ? 4 : 2;
                $dirty13 |= i25;
            } else {
                i13 = i61;
                z2 = isError;
            }
        }
        int i62 = i40 & 2048;
        if (i62 != 0) {
            $dirty13 |= 48;
            i45 = i62;
            obj7 = visualTransformation;
        } else {
            if (i69 & 48 == 0) {
                i45 = i62;
                changed5 = textFieldColors-dx8h9Zs.changed(visualTransformation) ? 32 : 16;
                $dirty13 |= changed5;
            } else {
                i45 = i62;
                obj7 = visualTransformation;
            }
        }
        int i63 = i40 & 4096;
        if (i63 != 0) {
            $dirty13 |= 384;
            i8 = i63;
            obj21 = keyboardOptions;
        } else {
            i8 = i63;
            if (i69 & 384 == 0) {
                i12 = textFieldColors-dx8h9Zs.changed(keyboardOptions) ? 256 : 128;
                $dirty13 |= i12;
            } else {
                obj21 = keyboardOptions;
            }
        }
        if (i69 & 3072 == 0) {
            if (i40 & 8192 == 0) {
                if (textFieldColors-dx8h9Zs.changed(keyboardActions)) {
                } else {
                    i9 = changed;
                }
            } else {
                obj10 = keyboardActions;
            }
            $dirty13 |= i9;
        } else {
            obj10 = keyboardActions;
        }
        int i66 = i40 & 16384;
        if (i66 != 0) {
            $dirty13 |= 24576;
            i56 = i66;
            z7 = singleLine;
        } else {
            i56 = i66;
            if (i69 & 24576 == 0) {
                if (textFieldColors-dx8h9Zs.changed(singleLine)) {
                } else {
                    i42 = i27;
                }
                $dirty13 |= i42;
            } else {
                z7 = singleLine;
            }
        }
        int i146 = i40 & i145;
        if (i146 != 0) {
            $dirty13 |= i151;
            i47 = maxLines;
        } else {
            if (i69 & i151 == 0) {
                i42 = textFieldColors-dx8h9Zs.changed(maxLines) ? i24 : i5;
                $dirty13 |= i42;
            } else {
                i47 = maxLines;
            }
        }
        i16 = i40 & i5;
        if (i16 != 0) {
            $dirty13 |= i160;
            obj14 = interactionSource;
        } else {
            if (i69 & i160 == 0) {
                i27 = textFieldColors-dx8h9Zs.changed(interactionSource) ? 1048576 : 524288;
                $dirty13 |= i27;
            } else {
                obj14 = interactionSource;
            }
        }
        if (i69 & i154 == 0) {
            if (i40 & i24 == 0) {
                i43 = textFieldColors-dx8h9Zs.changed(shape) ? 8388608 : 4194304;
            } else {
                obj19 = shape;
            }
            $dirty13 |= i43;
        } else {
            obj19 = shape;
        }
        int i152 = 262144;
        if (i69 & i155 == 0) {
            if (i40 & i152 == 0) {
                obj90 = $dirty13;
                i44 = textFieldColors-dx8h9Zs.changed(colors) ? 67108864 : 33554432;
            } else {
                obj90 = $dirty13;
                $dirty12 = colors;
            }
            keyboardActions3 = i3;
        } else {
            $dirty12 = colors;
            keyboardActions3 = obj90;
        }
        obj90 = $dirty;
        if ($dirty & i21 == 306783378 && i71 &= keyboardActions3 == 38347922) {
            if (i71 &= keyboardActions3 == 38347922) {
                if (!textFieldColors-dx8h9Zs.getSkipping()) {
                    textFieldColors-dx8h9Zs.startDefaults();
                    if ($changed & 1 != 0) {
                        if (textFieldColors-dx8h9Zs.getDefaultsInvalid()) {
                            if (consume != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = str;
                            }
                            z3 = i143 != 0 ? $dirty2 : invalid$iv;
                            z5 = i147 != 0 ? $dirty2 : z6;
                            if (i40 & 32 != 0) {
                                int i129 = 6;
                                z6 = 0;
                                ComposerKt.sourceInformationMarkerStart(textFieldColors-dx8h9Zs, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                ComposerKt.sourceInformationMarkerEnd(textFieldColors-dx8h9Zs);
                                obj20 = this_$iv;
                                i30 = invalid$iv;
                            } else {
                                i30 = obj90;
                                obj20 = zeroCornerSize;
                            }
                            obj3 = i33 != 0 ? this_$iv : rememberedValue;
                            obj = $i$a$CacheTextFieldKt$TextField$3 != 0 ? this_$iv : obj13;
                            i18 = i51 != 0 ? this_$iv : leadingIcon;
                            i10 = i52 != 0 ? this_$iv : trailingIcon;
                            i19 = i13 != 0 ? this_$iv : isError;
                            if (i45 != 0) {
                                obj16 = this_$iv;
                            } else {
                                obj16 = visualTransformation;
                            }
                            if (i8 != 0) {
                                keyboardOptions4 = this_$iv;
                            } else {
                                keyboardOptions4 = keyboardOptions;
                            }
                            if (i40 & 8192 != 0) {
                                super(0, 0, 0, 0, 0, 0, 63, 0);
                                $dirty1 = $dirty16;
                                $dirty14 = keyboardActions4;
                            } else {
                                $dirty1 = keyboardActions3;
                                $dirty14 = keyboardActions;
                            }
                            i34 = i56 != 0 ? invalid$iv : singleLine;
                            i22 = i146 != 0 ? invalid$iv : maxLines;
                            if (i16 != 0) {
                                ComposerKt.sourceInformationMarkerStart(textFieldColors-dx8h9Zs, -53943058, "CC(remember):TextField.kt#9igjgp");
                                int i128 = 0;
                                z6 = textFieldColors-dx8h9Zs;
                                zeroCornerSize = 0;
                                rememberedValue = z6.rememberedValue();
                                consume = 0;
                                if (rememberedValue == Composer.Companion.getEmpty()) {
                                    int i140 = 0;
                                    z6.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                                } else {
                                    $i$a$CacheTextFieldKt$TextField$3 = rememberedValue;
                                }
                                ComposerKt.sourceInformationMarkerEnd(textFieldColors-dx8h9Zs);
                                obj11 = invalid$iv;
                            } else {
                                obj11 = interactionSource;
                            }
                            if (i40 & i24 != 0) {
                                obj5 = copy$default;
                                i49 = $dirty1;
                            } else {
                                obj5 = shape;
                                i49 = $dirty1;
                            }
                            if (i40 & i152 != 0) {
                                keyboardActions5 = $dirty14;
                                obj6 = modifier2;
                                obj4 = textFieldColors-dx8h9Zs;
                                keyboardActions3 = $dirty15;
                                invalid$iv = z3;
                                z6 = z5;
                                obj15 = obj20;
                                modifier3 = i30;
                                obj8 = obj3;
                                obj17 = obj;
                                i = i18;
                                i14 = i10;
                                i38 = i19;
                                visualTransformation3 = obj16;
                                keyboardOptions2 = keyboardOptions4;
                                i28 = i34;
                                i54 = i22;
                                i21 = obj11;
                                i45 = obj5;
                            } else {
                                $composer2 = textFieldColors-dx8h9Zs;
                                obj4 = colors;
                                keyboardActions5 = $dirty14;
                                obj6 = modifier2;
                                invalid$iv = z3;
                                z6 = z5;
                                obj15 = obj20;
                                modifier3 = i30;
                                obj8 = obj3;
                                obj17 = obj;
                                i = i18;
                                i14 = i10;
                                i38 = i19;
                                visualTransformation3 = obj16;
                                keyboardOptions2 = keyboardOptions4;
                                i28 = i34;
                                i54 = i22;
                                i21 = obj11;
                                i45 = obj5;
                                keyboardActions3 = i49;
                            }
                        } else {
                            textFieldColors-dx8h9Zs.skipToGroupEnd();
                            $dirty15 = i40 & 32 != 0 ? obj90 & i32 : obj90;
                            if (i40 & 8192 != 0) {
                                keyboardActions3 &= -7169;
                            }
                            if (i40 & i24 != 0) {
                                keyboardActions3 &= i20;
                            }
                            if (i40 & i152 != 0) {
                                keyboardActions3 &= i35;
                            }
                            i = leadingIcon;
                            i14 = trailingIcon;
                            keyboardOptions2 = keyboardOptions;
                            keyboardActions5 = keyboardActions;
                            i28 = singleLine;
                            i54 = maxLines;
                            i21 = interactionSource;
                            i45 = shape;
                            $composer2 = textFieldColors-dx8h9Zs;
                            modifier3 = $dirty15;
                            obj4 = $dirty12;
                            obj15 = zeroCornerSize;
                            obj8 = rememberedValue;
                            obj17 = obj13;
                            obj6 = str;
                            i38 = isError;
                            visualTransformation3 = visualTransformation;
                        }
                    } else {
                    }
                    $composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1690895095, modifier3, keyboardActions3, "androidx.compose.material.TextField (TextField.kt:258)");
                    }
                    TextFieldKt.TextField(value, onValueChange, obj6, invalid$iv, z6, obj15, obj8, obj17, i, i14, i38, visualTransformation3, keyboardOptions2, keyboardActions5, i28, i54, 1, i21, i45, obj4, $composer2, i81 | i105, i90 | i118, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i7 = modifier3;
                    $composer3 = obj6;
                    z = invalid$iv;
                    z4 = z6;
                    modifier4 = obj15;
                    enabled2 = obj8;
                    readOnly2 = obj17;
                    textStyle2 = i;
                    label2 = i14;
                    placeholder2 = i38;
                    leadingIcon2 = visualTransformation3;
                    trailingIcon2 = keyboardOptions2;
                    isError2 = keyboardActions5;
                    visualTransformation2 = i28;
                    keyboardOptions3 = i54;
                    keyboardActions2 = i21;
                    singleLine2 = i45;
                    maxLines2 = obj4;
                    colors2 = keyboardActions3;
                } else {
                    textFieldColors-dx8h9Zs.skipToGroupEnd();
                    textStyle2 = leadingIcon;
                    leadingIcon2 = visualTransformation;
                    trailingIcon2 = keyboardOptions;
                    keyboardOptions3 = maxLines;
                    keyboardActions2 = interactionSource;
                    singleLine2 = shape;
                    i7 = obj90;
                    $composer2 = textFieldColors-dx8h9Zs;
                    maxLines2 = $dirty12;
                    z = invalid$iv;
                    z4 = z6;
                    modifier4 = zeroCornerSize;
                    enabled2 = rememberedValue;
                    readOnly2 = obj13;
                    $composer3 = str;
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
        endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new TextFieldKt.TextField.4(value, onValueChange, $composer3, z, z4, modifier4, enabled2, readOnly2, textStyle2, label2, placeholder2, leadingIcon2, trailingIcon2, isError2, visualTransformation2, keyboardOptions3, keyboardActions2, singleLine2, maxLines2, $changed, $changed1, i40);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    public static final void TextFieldLayout(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> textField, Function2<? super Composer, ? super Integer, Unit> label, Function3<? super Modifier, ? super Composer, ? super Integer, Unit> placeholder, Function2<? super Composer, ? super Integer, Unit> leading, Function2<? super Composer, ? super Integer, Unit> trailing, boolean singleLine, float animationProgress, PaddingValues paddingValues, Composer $composer, int $changed) {
        int i12;
        Object $i$a$CacheTextFieldKt$TextFieldLayout$measurePolicy$1;
        Integer layoutDirection;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv2;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap3;
        Object empty;
        boolean traceInProgress2;
        kotlin.jvm.functions.Function0 factory$iv$iv;
        Object obj2;
        Integer valueOf4;
        Integer valueOf3;
        String materialized$iv$iv;
        int valueOf2;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv4;
        Object obj4;
        Object valueOf6;
        Composer composer4;
        Object obj;
        Object maybeCachedBoxMeasurePolicy3;
        Composer composer9;
        Object $composer$iv;
        int endPadding;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv3;
        boolean currentCompositionLocalMap;
        Object maybeCachedBoxMeasurePolicy2;
        Object materialized$iv$iv2;
        androidx.compose.ui.Modifier.Companion $this$coerceAtLeast_u2dYgX7TsA$iv;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv;
        Modifier padding-qDBjuR0$default;
        BoxScopeInstance iNSTANCE;
        Composer i3;
        boolean valueOf5;
        Composer $this$dp$iv;
        int then;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap5;
        int restartGroup;
        int $dirty;
        Composer composer8;
        int i6;
        int i23;
        int i19;
        int i14;
        int i16;
        int i;
        int i4;
        int i11;
        int i27;
        int skipping;
        boolean traceInProgress;
        int i15;
        int i13;
        Modifier materializeModifier;
        Composer composer5;
        Integer valueOf;
        Object currentCompositionLocalMap2;
        Object maybeCachedBoxMeasurePolicy;
        Composer composer;
        int currentCompositeKeyHash3;
        int currentCompositionLocalMap4;
        Object obj3;
        int i5;
        Composer.Companion companion2;
        int invalid$iv;
        int currentCompositeKeyHash4;
        int i28;
        int i7;
        kotlin.jvm.functions.Function0 function02;
        int i29;
        Composer composer3;
        int i26;
        Object layoutDirection2;
        Composer composer7;
        int i25;
        int $i$f$setImpl;
        Modifier modifier2;
        int i2;
        int i21;
        int $i$a$LayoutTextFieldKt$TextFieldLayout$1;
        int i22;
        int i17;
        int i24;
        androidx.compose.runtime.CompositionLocalMap map;
        int currentCompositeKeyHash2;
        int companion;
        int i8;
        float f;
        Alignment alignment;
        int currentCompositeKeyHash;
        int $changed$iv;
        float f2;
        int i18;
        int i9;
        Modifier modifier3;
        kotlin.jvm.functions.Function0 function0;
        int i10;
        int i20;
        Composer composer6;
        int localMap$iv$iv;
        int localMap$iv$iv2;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv3;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy;
        Composer composer2;
        int i30;
        Alignment obj63;
        Object obj5 = modifier;
        obj4 = textField;
        valueOf6 = label;
        obj = placeholder;
        $composer$iv = leading;
        maybeCachedBoxMeasurePolicy2 = trailing;
        padding-qDBjuR0$default = singleLine;
        iNSTANCE = animationProgress;
        final Object obj6 = paddingValues;
        i3 = $changed;
        traceInProgress2 = -2112507061;
        restartGroup = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(TextFieldLayout)P(3,7,1,5,2,8,6)489@22578L139,492@22765L7,493@22777L1853:TextField.kt#jmzs0o");
        if (i3 & 6 == 0) {
            i6 = restartGroup.changed(obj5) ? 4 : 2;
            $dirty |= i6;
        }
        if (i3 & 48 == 0) {
            i23 = restartGroup.changedInstance(obj4) ? 32 : 16;
            $dirty |= i23;
        }
        if (i3 & 384 == 0) {
            i19 = restartGroup.changedInstance(valueOf6) ? 256 : 128;
            $dirty |= i19;
        }
        if (i3 & 3072 == 0) {
            i14 = restartGroup.changedInstance(obj) ? 2048 : 1024;
            $dirty |= i14;
        }
        if (i3 & 24576 == 0) {
            i16 = restartGroup.changedInstance($composer$iv) ? 16384 : 8192;
            $dirty |= i16;
        }
        if (i84 &= i3 == 0) {
            i = restartGroup.changedInstance(maybeCachedBoxMeasurePolicy2) ? 131072 : 65536;
            $dirty |= i;
        }
        currentCompositeKeyHash3 = 1048576;
        if (i85 &= i3 == 0) {
            i4 = restartGroup.changed(padding-qDBjuR0$default) ? currentCompositeKeyHash3 : 524288;
            $dirty |= i4;
        }
        if (i86 &= i3 == 0) {
            i11 = restartGroup.changed(iNSTANCE) ? 8388608 : 4194304;
            $dirty |= i11;
        }
        if (i87 &= i3 == 0) {
            i27 = restartGroup.changed(obj6) ? 67108864 : 33554432;
            $dirty |= i27;
        }
        if (i88 &= $dirty == 38347922) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty, -1, "androidx.compose.material.TextFieldLayout (TextField.kt:488)");
                }
                ComposerKt.sourceInformationMarkerStart(restartGroup, -73227460, "CC(remember):TextField.kt#9igjgp");
                i12 = i32 &= $dirty == currentCompositeKeyHash3 ? 1 : 0;
                int i114 = 1;
                i15 = i102 &= $dirty == 8388608 ? i114 : 0;
                i13 = i90 &= $dirty == 67108864 ? i114 : 0;
                i34 |= i13;
                Composer composer12 = restartGroup;
                int i105 = 0;
                Object rememberedValue6 = composer12.rememberedValue();
                int i113 = 0;
                if (empty == 0) {
                    invalid$iv = empty;
                    if (rememberedValue6 == Composer.Companion.getEmpty()) {
                        companion2 = invalid$iv2;
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
                i7 = 0;
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
                composer7 = restartGroup;
                Updater.set-impl(constructor-impl, (MeasurePolicy)(TextFieldMeasurePolicy)$i$a$CacheTextFieldKt$TextFieldLayout$measurePolicy$1, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                valueOf5 = 0;
                Composer composer13 = constructor-impl;
                int i118 = 0;
                if (!composer13.getInserting()) {
                    $i$f$setImpl = valueOf5;
                    i2 = $dirty;
                    if (!Intrinsics.areEqual(composer13.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                        composer13.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer8 = composer13;
                    }
                } else {
                    $i$f$setImpl = valueOf5;
                    i2 = $dirty;
                }
                Updater.set-impl(constructor-impl, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                i3 = composer7;
                $this$dp$iv = 0;
                i26 = i50;
                ComposerKt.sourceInformationMarkerStart(i3, 69567154, "C535@24392L183:TextField.kt#jmzs0o");
                String str11 = "C73@3429L9:Box.kt#2w3rfo";
                int i117 = 48;
                String str = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo";
                modifier2 = materialized$iv$iv2;
                if ($composer$iv != null) {
                    i3.startReplaceGroup(69542167);
                    ComposerKt.sourceInformation(i3, "497@22885L219");
                    $i$a$LayoutTextFieldKt$TextFieldLayout$1 = $this$dp$iv;
                    Modifier then4 = LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Leading").then(TextFieldImplKt.getIconDefaultSizeModifier());
                    Alignment center2 = Alignment.Companion.getCenter();
                    i22 = i117;
                    i17 = 0;
                    i24 = materializeModifier;
                    ComposerKt.sourceInformationMarkerStart(i3, 733328855, str);
                    int i101 = 0;
                    map = currentCompositionLocalMap2;
                    maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center2, i101);
                    i8 = 0;
                    alignment = center2;
                    ComposerKt.sourceInformationMarkerStart(i3, -1323940314, str15);
                    $changed$iv = ComposablesKt.getCurrentCompositeKeyHash(i3, 0);
                    currentCompositionLocalMap5 = i3.getCurrentCompositionLocalMap();
                    i18 = i101;
                    modifier3 = then4;
                    kotlin.jvm.functions.Function0 function07 = constructor5;
                    i9 = 0;
                    ComposerKt.sourceInformationMarkerStart(i3, -692256719, str7);
                    if (!applier5 instanceof Applier) {
                        ComposablesKt.invalidApplier();
                    }
                    i3.startReusableNode();
                    if (i3.getInserting()) {
                        i3.createNode(function07);
                    } else {
                        factory$iv$iv$iv = function07;
                        i3.useNode();
                    }
                    function0 = factory$iv$iv$iv;
                    Composer constructor-impl4 = Updater.constructor-impl(i3);
                    int i133 = 0;
                    Updater.set-impl(constructor-impl4, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl4, currentCompositionLocalMap5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    int i137 = 0;
                    Composer composer17 = constructor-impl4;
                    int i139 = 0;
                    if (!composer17.getInserting()) {
                        localMap$iv$iv3 = currentCompositionLocalMap5;
                        measurePolicy = maybeCachedBoxMeasurePolicy;
                        if (!Intrinsics.areEqual(composer17.rememberedValue(), Integer.valueOf($changed$iv))) {
                            composer17.updateRememberedValue(Integer.valueOf($changed$iv));
                            constructor-impl4.apply(Integer.valueOf($changed$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer = composer17;
                        }
                    } else {
                        localMap$iv$iv3 = currentCompositionLocalMap5;
                        measurePolicy = maybeCachedBoxMeasurePolicy;
                    }
                    Updater.set-impl(constructor-impl4, ComposedModifierKt.materializeModifier(i3, then4), ComposeUiNode.Companion.getSetModifier());
                    Composer composer11 = i3;
                    ComposerKt.sourceInformationMarkerStart(composer11, -2146769399, str11);
                    currentCompositionLocalMap2 = BoxScopeInstance.INSTANCE;
                    i135 |= 6;
                    localMap$iv$iv = 0;
                    localMap$iv$iv2 = i59;
                    i30 = i80;
                    $this$dp$iv = composer6;
                    ComposerKt.sourceInformationMarkerStart($this$dp$iv, -1924262037, "C501@23077L9:TextField.kt#jmzs0o");
                    $composer$iv.invoke($this$dp$iv, Integer.valueOf(i60 &= 14));
                    ComposerKt.sourceInformationMarkerEnd($this$dp$iv);
                    ComposerKt.sourceInformationMarkerEnd(composer11);
                    i3.endNode();
                    ComposerKt.sourceInformationMarkerEnd(i3);
                    ComposerKt.sourceInformationMarkerEnd(i3);
                    ComposerKt.sourceInformationMarkerEnd(i3);
                    i3.endReplaceGroup();
                } else {
                    $i$a$LayoutTextFieldKt$TextFieldLayout$1 = $this$dp$iv;
                    i24 = materializeModifier;
                    map = currentCompositionLocalMap2;
                    i3.startReplaceGroup(69783378);
                    i3.endReplaceGroup();
                }
                if (maybeCachedBoxMeasurePolicy2 != null) {
                    i3.startReplaceGroup(69825941);
                    ComposerKt.sourceInformation(i3, "505@23171L221");
                    Modifier then3 = LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Trailing").then(TextFieldImplKt.getIconDefaultSizeModifier());
                    Alignment center = Alignment.Companion.getCenter();
                    ComposerKt.sourceInformationMarkerStart(i3, 733328855, str);
                    valueOf = 0;
                    i17 = 0;
                    ComposerKt.sourceInformationMarkerStart(i3, -1323940314, str15);
                    currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(i3, 0);
                    currentCompositionLocalMap = i3.getCurrentCompositionLocalMap();
                    i8 = center;
                    Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(i3, then3);
                    $changed$iv = then3;
                    kotlin.jvm.functions.Function0 function05 = constructor3;
                    alignment = 0;
                    ComposerKt.sourceInformationMarkerStart(i3, -692256719, str7);
                    if (!applier3 instanceof Applier) {
                        ComposablesKt.invalidApplier();
                    }
                    i3.startReusableNode();
                    if (i3.getInserting()) {
                        i3.createNode(function05);
                    } else {
                        factory$iv$iv$iv4 = function05;
                        i3.useNode();
                    }
                    i18 = factory$iv$iv$iv4;
                    Composer constructor-impl2 = Updater.constructor-impl(i3);
                    int i125 = 0;
                    i10 = i78;
                    Updater.set-impl(constructor-impl2, BoxKt.maybeCachedBoxMeasurePolicy(center, valueOf), ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    int i128 = 0;
                    Composer composer15 = constructor-impl2;
                    int i136 = 0;
                    if (!composer15.getInserting()) {
                        localMap$iv$iv = currentCompositionLocalMap;
                        localMap$iv$iv2 = valueOf;
                        if (!Intrinsics.areEqual(composer15.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                            composer15.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                            constructor-impl2.apply(Integer.valueOf(currentCompositeKeyHash2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer5 = composer15;
                        }
                    } else {
                        localMap$iv$iv = currentCompositionLocalMap;
                        localMap$iv$iv2 = valueOf;
                    }
                    Updater.set-impl(constructor-impl2, materializeModifier4, ComposeUiNode.Companion.getSetModifier());
                    Composer composer10 = i3;
                    $this$dp$iv = 0;
                    ComposerKt.sourceInformationMarkerStart(composer10, -2146769399, str11);
                    materializeModifier = BoxScopeInstance.INSTANCE;
                    i127 |= 6;
                    i20 = 0;
                    composer6 = i55;
                    measurePolicy = materializeModifier4;
                    materialized$iv$iv2 = function0;
                    ComposerKt.sourceInformationMarkerStart(materialized$iv$iv2, -1923977302, "C509@23364L10:TextField.kt#jmzs0o");
                    maybeCachedBoxMeasurePolicy2.invoke(materialized$iv$iv2, Integer.valueOf(i56 &= 14));
                    ComposerKt.sourceInformationMarkerEnd(materialized$iv$iv2);
                    ComposerKt.sourceInformationMarkerEnd(composer10);
                    i3.endNode();
                    ComposerKt.sourceInformationMarkerEnd(i3);
                    ComposerKt.sourceInformationMarkerEnd(i3);
                    ComposerKt.sourceInformationMarkerEnd(i3);
                    i3.endReplaceGroup();
                } else {
                    i3.startReplaceGroup(70069074);
                    i3.endReplaceGroup();
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
                if (maybeCachedBoxMeasurePolicy2 != null) {
                    int i76 = 0;
                    int i96 = 0;
                    materializeModifier = 0;
                    f2 = $this$coerceAtLeast_u2dYgX7TsA$iv;
                } else {
                    f2 = endPadding;
                }
                padding-qDBjuR0$default = PaddingKt.padding-qDBjuR0$default((Modifier)Modifier.Companion, f, 0, f2, 0, 10, 0);
                if (obj != null) {
                    i3.startReplaceGroup(70826807);
                    ComposerKt.sourceInformation(i3, "530@24185L59");
                    obj.invoke(LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Hint").then(padding-qDBjuR0$default), i3, Integer.valueOf(i92 &= 112));
                    i3.endReplaceGroup();
                } else {
                    i3.startReplaceGroup(70914258);
                    i3.endReplaceGroup();
                }
                if (valueOf6 != null) {
                    i3.startReplaceGroup(70948761);
                    ComposerKt.sourceInformation(i3, "533@24308L57");
                    materializeModifier = 0;
                    currentCompositionLocalMap2 = 0;
                    layoutDirection2 = consume;
                    ComposerKt.sourceInformationMarkerStart(i3, 733328855, str);
                    Alignment topStart = Alignment.Companion.getTopStart();
                    i22 = materialized$iv$iv;
                    int startTextFieldPadding = 0;
                    maybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(topStart, startTextFieldPadding);
                    companion = 0;
                    f = topStart;
                    ComposerKt.sourceInformationMarkerStart(i3, -1323940314, str15);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(i3, 0);
                    currentCompositionLocalMap3 = i3.getCurrentCompositionLocalMap();
                    f2 = startTextFieldPadding;
                    Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(i3, LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Label").then(padding-qDBjuR0$default));
                    i9 = endPadding;
                    kotlin.jvm.functions.Function0 function06 = constructor4;
                    i18 = 0;
                    ComposerKt.sourceInformationMarkerStart(i3, -692256719, str7);
                    if (!applier4 instanceof Applier) {
                        ComposablesKt.invalidApplier();
                    }
                    i3.startReusableNode();
                    if (i3.getInserting()) {
                        i3.createNode(function06);
                    } else {
                        factory$iv$iv$iv3 = function06;
                        i3.useNode();
                    }
                    modifier3 = factory$iv$iv$iv3;
                    Composer constructor-impl3 = Updater.constructor-impl(i3);
                    int i129 = 0;
                    Updater.set-impl(constructor-impl3, maybeCachedBoxMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl3, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    int i132 = 0;
                    Composer composer16 = constructor-impl3;
                    int i138 = 0;
                    if (!composer16.getInserting()) {
                        localMap$iv$iv2 = currentCompositionLocalMap3;
                        localMap$iv$iv3 = maybeCachedBoxMeasurePolicy3;
                        if (!Intrinsics.areEqual(composer16.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            composer16.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            constructor-impl3.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer9 = composer16;
                        }
                    } else {
                        localMap$iv$iv2 = currentCompositionLocalMap3;
                        localMap$iv$iv3 = maybeCachedBoxMeasurePolicy3;
                    }
                    Updater.set-impl(constructor-impl3, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                    obj = i3;
                    endPadding = 0;
                    ComposerKt.sourceInformationMarkerStart(obj, -2146769399, str11);
                    maybeCachedBoxMeasurePolicy2 = BoxScopeInstance.INSTANCE;
                    i131 |= 6;
                    i20 = obj;
                    composer6 = 0;
                    localMap$iv$iv = i43;
                    measurePolicy = materializeModifier3;
                    ComposerKt.sourceInformationMarkerStart(obj, -1922993331, "C533@24356L7:TextField.kt#jmzs0o");
                    valueOf6.invoke(obj, Integer.valueOf(i44 &= 14));
                    ComposerKt.sourceInformationMarkerEnd(obj);
                    ComposerKt.sourceInformationMarkerEnd(obj);
                    i3.endNode();
                    ComposerKt.sourceInformationMarkerEnd(i3);
                    ComposerKt.sourceInformationMarkerEnd(i3);
                    ComposerKt.sourceInformationMarkerEnd(i3);
                    i3.endReplaceGroup();
                } else {
                    layoutDirection2 = consume;
                    i22 = materialized$iv$iv;
                    i9 = endPadding;
                    i3.startReplaceGroup(71034290);
                    i3.endReplaceGroup();
                }
                Modifier then2 = LayoutIdKt.layoutId((Modifier)Modifier.Companion, "TextField").then(padding-qDBjuR0$default);
                valueOf2 = 384;
                $composer$iv = 0;
                ComposerKt.sourceInformationMarkerStart(i3, 733328855, str);
                Alignment topStart2 = Alignment.Companion.getTopStart();
                skipping = 0;
                ComposerKt.sourceInformationMarkerStart(i3, -1323940314, str15);
                currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(i3, 0);
                obj63 = topStart2;
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(i3, then2);
                companion2 = then2;
                kotlin.jvm.functions.Function0 function04 = constructor;
                i5 = 0;
                ComposerKt.sourceInformationMarkerStart(i3, -692256719, str7);
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                i3.startReusableNode();
                if (i3.getInserting()) {
                    i3.createNode(function04);
                } else {
                    factory$iv$iv$iv2 = function04;
                    i3.useNode();
                }
                Composer constructor-impl5 = Updater.constructor-impl(i3);
                int i115 = 0;
                currentCompositeKeyHash2 = factory$iv$iv$iv2;
                Updater.set-impl(constructor-impl5, BoxKt.maybeCachedBoxMeasurePolicy(topStart2, i114), ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl5, i3.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i119 = 0;
                Composer composer14 = constructor-impl5;
                int i123 = 0;
                if (!composer14.getInserting()) {
                    $changed$iv = valueOf2;
                    if (!Intrinsics.areEqual(composer14.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                        composer14.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        constructor-impl5.apply(Integer.valueOf(currentCompositeKeyHash3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer4 = composer14;
                    }
                } else {
                    $changed$iv = valueOf2;
                }
                Updater.set-impl(constructor-impl5, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                obj4 = i3;
                valueOf6 = 0;
                ComposerKt.sourceInformationMarkerStart(obj4, -2146769399, str11);
                iNSTANCE = BoxScopeInstance.INSTANCE;
                i83 |= 6;
                composer3 = obj4;
                i25 = 0;
                i21 = i38;
                i8 = materializeModifier2;
                ComposerKt.sourceInformationMarkerStart(obj4, -1922800759, "C539@24550L11:TextField.kt#jmzs0o");
                textField.invoke(obj4, Integer.valueOf(i39 &= 14));
                ComposerKt.sourceInformationMarkerEnd(obj4);
                ComposerKt.sourceInformationMarkerEnd(obj4);
                i3.endNode();
                ComposerKt.sourceInformationMarkerEnd(i3);
                ComposerKt.sourceInformationMarkerEnd(i3);
                ComposerKt.sourceInformationMarkerEnd(i3);
                ComposerKt.sourceInformationMarkerEnd(i3);
                composer7.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer7);
                ComposerKt.sourceInformationMarkerEnd(composer7);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
                obj2 = obj4;
                composer7 = restartGroup;
                i2 = $dirty;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer7.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new TextFieldKt.TextFieldLayout.2(modifier, obj2, label, placeholder, leading, trailing, singleLine, animationProgress, obj6, $changed);
            endRestartGroup.updateScope((Function2)traceInProgress2);
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
        int i2;
        int align;
        int i4;
        int i8;
        int i3;
        Placeable.PlacementScope placementScope;
        Placeable.PlacementScope placementScope2;
        Placeable placeable;
        Placeable placeable2;
        int widthOrZero2;
        int widthOrZero;
        int align2;
        int i10;
        int i11;
        int i;
        int i7;
        int i5;
        int i9;
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
        int height3;
        Placeable.PlacementScope align;
        Placeable height2;
        int i5;
        int align2;
        int i;
        int i6;
        int i4;
        Placeable.PlacementScope placementScope2;
        Placeable.PlacementScope placementScope;
        Placeable placeable2;
        Placeable placeable;
        int i2;
        int widthOrZero;
        int align3;
        int i7;
        int i10;
        int i8;
        int i11;
        int i12;
        int i9;
        int i3;
        final int i13 = height;
        int roundToInt = MathKt.roundToInt(topPadding-D9Ej5fM *= density);
        if (leadingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithoutLabel, leadingPlaceable, 0, Alignment.Companion.getCenterVertically().align(leadingPlaceable.getHeight(), i13), 0, 4, 0);
        }
        if (trailingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithoutLabel, trailingPlaceable, width - width2, Alignment.Companion.getCenterVertically().align(trailingPlaceable.getHeight(), i13), 0, 4, 0);
        }
        if (singleLine) {
            i7 = centerVertically;
        } else {
            i7 = roundToInt;
        }
        Placeable.PlacementScope.placeRelative$default($this$placeWithoutLabel, textPlaceable, TextFieldImplKt.widthOrZero(leadingPlaceable), i7, 0, 4, 0);
        int i15 = i7;
        if (placeholderPlaceable != null) {
            height3 = 0;
            if (singleLine) {
                i7 = align;
            } else {
                i7 = roundToInt;
            }
            Placeable.PlacementScope.placeRelative$default($this$placeWithoutLabel, placeholderPlaceable, TextFieldImplKt.widthOrZero(leadingPlaceable), i7, 0, 4, 0);
        }
    }

    private static final int substractConstraintSafely(int $this$substractConstraintSafely, int from) {
        if ($this$substractConstraintSafely == Integer.MAX_VALUE) {
            return $this$substractConstraintSafely;
        }
        return $this$substractConstraintSafely - from;
    }
}
