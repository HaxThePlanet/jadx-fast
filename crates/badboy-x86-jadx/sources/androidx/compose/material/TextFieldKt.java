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
        Object obj11;
        Object obj7;
        boolean z6;
        Object obj5;
        Object obj16;
        Object obj17;
        boolean z2;
        int i42;
        int i47;
        Object obj18;
        Object obj20;
        int $dirty16;
        Object $dirty15;
        Object $dirty12;
        Object endRestartGroup;
        int skipping;
        int $dirty4;
        int $dirty2;
        int $dirty17;
        int defaultsInvalid;
        Object modifier2;
        int i94;
        boolean traceInProgress;
        int $composer2;
        int i33;
        Object $composer3;
        int $dirty;
        int $dirty3;
        int i40;
        int i91;
        Object textFieldColors-dx8h9Zs;
        int default;
        int $dirty1;
        boolean z;
        int $dirty13;
        Object $dirty14;
        Composer composer;
        boolean z7;
        Object obj3;
        int i18;
        Object obj9;
        boolean field3;
        int i70;
        int i37;
        int textFieldShape;
        Object enabled2;
        boolean z4;
        Object readOnly2;
        int i101;
        Object obj19;
        boolean traceInProgress2;
        int value2;
        int i60;
        Object obj4;
        KeyboardOptions i95;
        int keyboardOptions3;
        Object visualTransformation3;
        Object shape3;
        int keyboardActions2;
        int i80;
        int field2;
        int i71;
        VisualTransformation singleLine2;
        int obj13;
        int i34;
        KeyboardOptions maxLines2;
        Object obj21;
        int obj8;
        KeyboardActions minLines2;
        Object obj15;
        int visualTransformation2;
        int i96;
        int i8;
        int i75;
        int i58;
        int i2;
        int i22;
        int changed;
        int i51;
        int changed3;
        int i79;
        long $this$takeOrElse_u2dDxMtmZc$iv;
        int i39;
        int i21;
        int companion;
        Shape shape2;
        int i72;
        int i26;
        long unbox-impl;
        Object field;
        int i66;
        int i46;
        int i23;
        int i4;
        int i25;
        int changed4;
        int i19;
        int i38;
        int i56;
        int i69;
        int i86;
        int $dirty18;
        int i62;
        int changed7;
        int changed2;
        int i59;
        int i28;
        int changed5;
        int i74;
        int i35;
        int i61;
        int i43;
        int i20;
        int i65;
        int i97;
        int i41;
        int i98;
        boolean changed6;
        int i63;
        int i55;
        int i48;
        int i45;
        int i89;
        int i6;
        int i3;
        int i64;
        int i81;
        int i5;
        int i85;
        int i92;
        int i52;
        Composer composer3;
        Composer composer2;
        int i83;
        int i67;
        int i32;
        int i16;
        boolean z5;
        boolean z3;
        Object obj12;
        int i73;
        Object obj2;
        Object obj14;
        int i78;
        int obj;
        int obj6;
        int i11;
        VisualTransformation i9;
        KeyboardOptions keyboardOptions2;
        int i90;
        int i88;
        int i15;
        int modifier3;
        Shape obj10;
        int i36;
        int i29;
        TextStyle textStyle2;
        long l;
        int i13;
        int i93;
        int i54;
        int i53;
        int i27;
        int i49;
        int i76;
        int i84;
        int i68;
        int i44;
        int i7;
        int i31;
        int i17;
        int i77;
        int i10;
        int i82;
        int i57;
        int i99;
        int i50;
        int i30;
        int i100;
        int i12;
        int i87;
        int i14;
        int i102;
        ScopeUpdateScope scopeUpdateScope;
        int i;
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
        int i103 = $changed;
        int i115 = $changed1;
        traceInProgress = i24;
        Composer restartGroup = $composer.startRestartGroup(-359119489);
        ComposerKt.sourceInformation(restartGroup, "C(TextField)P(18,11,10,1,13,16,6,12,7,17,3,19,5,4,15,8,9,2,14)356@17778L7,369@18422L14,370@18486L17,385@19110L38,394@19477L20,402@19819L724,381@18927L1622:TextField.kt#jmzs0o");
        $dirty = $changed;
        $dirty13 = $changed1;
        if (traceInProgress & 1 != 0) {
            $dirty |= 6;
            obj3 = value;
        } else {
            if (i103 & 6 == 0) {
                i101 = restartGroup.changed(value) ? 4 : 2;
                $dirty |= i101;
            } else {
                obj3 = value;
            }
        }
        if (traceInProgress & 2 != 0) {
            $dirty |= 48;
            obj19 = onValueChange;
        } else {
            if (i103 & 48 == 0) {
                i80 = restartGroup.changedInstance(onValueChange) ? 32 : 16;
                $dirty |= i80;
            } else {
                obj19 = onValueChange;
            }
        }
        i71 = traceInProgress & 4;
        if (i71 != 0) {
            $dirty |= 384;
            obj15 = modifier;
        } else {
            if (i103 & 384 == 0) {
                i96 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty |= i96;
            } else {
                obj15 = modifier;
            }
        }
        i8 = traceInProgress & 8;
        changed = 1024;
        if (i8 != 0) {
            $dirty |= 3072;
            field3 = enabled;
        } else {
            if (i103 & 3072 == 0) {
                i21 = restartGroup.changed(enabled) ? i58 : changed;
                $dirty |= i21;
            } else {
                field3 = enabled;
            }
        }
        companion = traceInProgress & 16;
        if (companion != 0) {
            $dirty |= 24576;
            z4 = readOnly;
        } else {
            if (i103 & 24576 == 0) {
                i23 = restartGroup.changed(readOnly) ? 16384 : i72;
                $dirty |= i23;
            } else {
                z4 = readOnly;
            }
        }
        if (i103 & i211 == 0) {
            if (traceInProgress & 32 == 0) {
                changed4 = restartGroup.changed(textStyle) ? 131072 : 65536;
            } else {
                obj4 = textStyle;
            }
            $dirty |= changed4;
        } else {
            obj4 = textStyle;
        }
        i19 = traceInProgress & 64;
        i38 = 1572864;
        i59 = 524288;
        if (i19 != 0) {
            $dirty |= i38;
            visualTransformation3 = label;
        } else {
            if (i103 & i38 == 0) {
                i74 = restartGroup.changedInstance(label) ? 1048576 : i59;
                $dirty |= i74;
            } else {
                visualTransformation3 = label;
            }
        }
        i34 = traceInProgress & 128;
        i35 = 12582912;
        if (i34 != 0) {
            $dirty |= i35;
            obj21 = placeholder;
        } else {
            if (i103 & i35 == 0) {
                i43 = restartGroup.changedInstance(placeholder) ? 8388608 : 4194304;
                $dirty |= i43;
            } else {
                obj21 = placeholder;
            }
        }
        int i104 = traceInProgress & 256;
        int i220 = 100663296;
        if (i104 != 0) {
            $dirty |= i220;
            i20 = i104;
            obj11 = leadingIcon;
        } else {
            if ($changed & i220 == 0) {
                i20 = i104;
                i65 = restartGroup.changedInstance(leadingIcon) ? 67108864 : 33554432;
                $dirty |= i65;
            } else {
                i20 = i104;
                obj11 = leadingIcon;
            }
        }
        int i105 = traceInProgress & 512;
        int i222 = 805306368;
        if (i105 != 0) {
            $dirty |= i222;
            i97 = i105;
            obj7 = trailingIcon;
        } else {
            if ($changed & i222 == 0) {
                i97 = i105;
                i41 = restartGroup.changedInstance(trailingIcon) ? 536870912 : 268435456;
                $dirty |= i41;
            } else {
                i97 = i105;
                obj7 = trailingIcon;
            }
        }
        int i106 = traceInProgress & 1024;
        if (i106 != 0) {
            $dirty13 |= 6;
            i98 = i106;
            z6 = isError;
        } else {
            if (i115 & 6 == 0) {
                i98 = i106;
                i66 = restartGroup.changed(isError) ? 4 : 2;
                $dirty13 |= i66;
            } else {
                i98 = i106;
                z6 = isError;
            }
        }
        int i107 = traceInProgress & 2048;
        if (i107 != 0) {
            $dirty13 |= 48;
            i46 = i107;
            obj5 = visualTransformation;
        } else {
            if (i115 & 48 == 0) {
                i46 = i107;
                changed5 = restartGroup.changed(visualTransformation) ? 32 : 16;
                $dirty13 |= changed5;
            } else {
                i46 = i107;
                obj5 = visualTransformation;
            }
        }
        int i108 = traceInProgress & 4096;
        if (i108 != 0) {
            $dirty13 |= 384;
            i25 = i108;
            obj16 = keyboardOptions;
        } else {
            i25 = i108;
            if (i115 & 384 == 0) {
                i74 = restartGroup.changed(keyboardOptions) ? 256 : 128;
                $dirty13 |= i74;
            } else {
                obj16 = keyboardOptions;
            }
        }
        if (i115 & 3072 == 0) {
            if (traceInProgress & 8192 == 0) {
                if (restartGroup.changed(keyboardActions)) {
                } else {
                    i58 = changed;
                }
            } else {
                obj17 = keyboardActions;
            }
            $dirty13 |= i58;
        } else {
            obj17 = keyboardActions;
        }
        int i111 = traceInProgress & 16384;
        if (i111 != 0) {
            $dirty13 |= 24576;
            i2 = i111;
            z2 = singleLine;
        } else {
            i2 = i111;
            if (i115 & 24576 == 0) {
                if (restartGroup.changed(singleLine)) {
                    i72 = 16384;
                }
                $dirty13 |= i72;
            } else {
                z2 = singleLine;
            }
        }
        if (i115 & i201 == 0) {
            if (traceInProgress & i202 == 0) {
                i51 = restartGroup.changed(maxLines) ? 131072 : 65536;
            } else {
                i42 = maxLines;
            }
            $dirty13 |= i51;
        } else {
            i42 = maxLines;
        }
        i79 = traceInProgress & i203;
        if (i79 != 0) {
            $dirty13 |= i38;
            i47 = minLines;
        } else {
            if (i115 & i38 == 0) {
                i72 = restartGroup.changed(minLines) ? 1048576 : i59;
                $dirty13 |= i72;
            } else {
                i47 = minLines;
            }
        }
        i26 = traceInProgress & i207;
        if (i26 != 0) {
            $dirty13 |= i35;
            obj18 = interactionSource;
        } else {
            if (i115 & i35 == 0) {
                i38 = restartGroup.changed(interactionSource) ? 8388608 : 4194304;
                $dirty13 |= i38;
            } else {
                obj18 = interactionSource;
            }
        }
        if (i115 & i214 == 0) {
            if (traceInProgress & i216 == 0) {
                i56 = restartGroup.changed(shape) ? 67108864 : 33554432;
            } else {
                obj20 = shape;
            }
            $dirty13 |= i56;
        } else {
            obj20 = shape;
        }
        if (i115 & i215 == 0) {
            if (traceInProgress & i59 == 0) {
                obj124 = $dirty13;
                i62 = restartGroup.changed(colors) ? 536870912 : 268435456;
            } else {
                obj124 = $dirty13;
                $dirty14 = colors;
            }
            $dirty16 = i69;
        } else {
            $dirty14 = colors;
            $dirty16 = obj124;
        }
        obj124 = $dirty;
        if ($dirty & i86 == 306783378 && i129 &= $dirty16 == 306783378) {
            if (i129 &= $dirty16 == 306783378) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    default = -458753;
                    int i161 = 6;
                    int i164 = 1;
                    if ($changed & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if (i71 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = obj15;
                            }
                            z5 = i8 != 0 ? field3 : field3;
                            z3 = companion != 0 ? field3 : z4;
                            if (traceInProgress & 32 != 0) {
                                z4 = 6;
                                i71 = 0;
                                ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                                obj12 = default;
                                i73 = i70;
                            } else {
                                i8 = default;
                                i73 = obj124;
                                obj12 = obj4;
                            }
                            obj2 = i19 != 0 ? default : visualTransformation3;
                            obj14 = i34 != 0 ? default : obj21;
                            i78 = i20 != 0 ? default : leadingIcon;
                            obj = i97 != 0 ? default : trailingIcon;
                            obj6 = i98 != 0 ? default : isError;
                            if (i46 != 0) {
                                i9 = default;
                            } else {
                                i9 = visualTransformation;
                            }
                            if (i25 != 0) {
                                keyboardOptions2 = default;
                            } else {
                                keyboardOptions2 = keyboardOptions;
                            }
                            if (traceInProgress & 8192 != 0) {
                                super(0, 0, 0, 0, 0, 0, 63, 0);
                                $dirty1 = $dirty19;
                                $dirty12 = i;
                            } else {
                                $dirty1 = $dirty16;
                                $dirty12 = keyboardActions;
                            }
                            i90 = i2 != 0 ? i70 : singleLine;
                            if (i168 &= traceInProgress != 0) {
                                i37 = i90 != 0 ? i164 : 0x7fffffff /* Unknown resource */;
                                $dirty1 &= i8;
                                i88 = i37;
                            } else {
                                i88 = maxLines;
                            }
                            i15 = i79 != 0 ? i37 : minLines;
                            modifier3 = i26 != 0 ? i37 : interactionSource;
                            if (i169 &= traceInProgress != 0) {
                                obj10 = textFieldShape;
                                i36 = $dirty1;
                            } else {
                                obj10 = shape;
                                i36 = $dirty1;
                            }
                            if (traceInProgress & i59 != 0) {
                                int i173 = i164;
                                int i180 = i170;
                                int i186 = i180;
                                int i189 = i181;
                                i8 = i189;
                                i79 = i8;
                                i26 = i79;
                                i25 = i26;
                                i86 = i25;
                                changed5 = i86;
                                i35 = changed5;
                                i20 = i35;
                                i98 = i20;
                                i63 = i98;
                                i48 = i63;
                                i89 = i48;
                                i3 = i89;
                                i81 = i3;
                                i85 = i81;
                                i52 = i85;
                                i29 = i235;
                                composer3 = restartGroup;
                                $composer2 = i;
                                textFieldColors-dx8h9Zs = TextFieldDefaults.INSTANCE.textFieldColors-dx8h9Zs(0, i164, 0, i173, 0, i180, 0, i186, 0, i189, 0, i8, 0, i79, 0, i26, 0, i25, 0, i86, 0, changed5, 0, i35, 0, i20);
                                composer = composer3;
                                shape3 = $dirty12;
                                obj15 = modifier2;
                                $dirty2 = i166;
                                field3 = z5;
                                z4 = z3;
                                $dirty15 = obj12;
                                i18 = i73;
                                i95 = keyboardOptions2;
                                field2 = i90;
                                obj13 = i88;
                                obj8 = i15;
                            } else {
                                composer = restartGroup;
                                $composer2 = i;
                                textFieldColors-dx8h9Zs = colors;
                                shape3 = $dirty12;
                                obj15 = modifier2;
                                field3 = z5;
                                z4 = z3;
                                $dirty15 = obj12;
                                i18 = i73;
                                i95 = keyboardOptions2;
                                field2 = i90;
                                obj13 = i88;
                                obj8 = i15;
                                $dirty2 = i36;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            $dirty4 = traceInProgress & 32 != 0 ? obj124 & default : obj124;
                            if (traceInProgress & 8192 != 0) {
                                $dirty16 &= -7169;
                            }
                            if (i184 &= traceInProgress != 0) {
                                $dirty16 &= default;
                            }
                            if (i157 &= traceInProgress != 0) {
                                $dirty16 &= i40;
                            }
                            if (traceInProgress & i59 != 0) {
                                $dirty16 &= i91;
                            }
                            composer = restartGroup;
                            $composer2 = i158;
                            i78 = leadingIcon;
                            obj = trailingIcon;
                            obj6 = isError;
                            i9 = visualTransformation;
                            field2 = singleLine;
                            obj13 = maxLines;
                            modifier3 = interactionSource;
                            obj10 = shape;
                            textFieldColors-dx8h9Zs = colors;
                            i18 = $dirty4;
                            obj2 = visualTransformation3;
                            obj14 = obj21;
                            shape3 = keyboardActions;
                            obj8 = minLines;
                            $dirty2 = $dirty16;
                            $dirty15 = obj4;
                            i95 = keyboardOptions;
                        }
                    } else {
                    }
                    composer.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-359119489, i18, $dirty2, "androidx.compose.material.TextField (TextField.kt:371)");
                    }
                    if (modifier3 == 0) {
                        composer.startReplaceGroup(-1665951468);
                        ComposerKt.sourceInformation(composer, "373@18589L39");
                        ComposerKt.sourceInformationMarkerStart(composer, -53740370, "CC(remember):TextField.kt#9igjgp");
                        $composer2 = 0;
                        traceInProgress2 = composer;
                        i8 = 0;
                        $dirty18 = $dirty2;
                        $dirty17 = traceInProgress2.rememberedValue();
                        i79 = 0;
                        if ($dirty17 == Composer.Companion.getEmpty()) {
                            int i147 = 0;
                            traceInProgress2.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                        } else {
                            i94 = $dirty17;
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        composer.endReplaceGroup();
                    } else {
                        $dirty18 = $dirty2;
                        composer.startReplaceGroup(-53741021);
                        composer.endReplaceGroup();
                        i94 = modifier3;
                    }
                    composer.startReplaceGroup(-53735263);
                    ComposerKt.sourceInformation(composer, "*376@18776L18");
                    int i118 = 0;
                    i33 = 0;
                    value2 = Long.compare(unbox-impl, i212) != 0 ? 1 : 0;
                    if (value2 != null) {
                    } else {
                        i33 = 0;
                        $this$takeOrElse_u2dDxMtmZc$iv = unbox-impl;
                    }
                    composer.endReplaceGroup();
                    textStyle2 = new TextStyle($this$takeOrElse_u2dDxMtmZc$iv, obj72, 0, obj74, 0, 0, 0, 0, 0, 0, obj81, 0, 0, 0, 0, obj86, 0, 0, 0, 0, 0, 0, obj93, 0, 0, 0, 0, 0, 0, 16777214, 0);
                    obj108 = field3;
                    obj107 = obj15;
                    obj109 = obj6;
                    Object obj22 = obj107;
                    int i190 = obj109;
                    obj111 = i94;
                    SolidColor solidColor = new SolidColor((Color)textFieldColors-dx8h9Zs.cursorColor(i190, composer, i130 |= i196).getValue().unbox-impl(), obj22, 0);
                    obj106 = anon;
                    obj118 = textFieldColors-dx8h9Zs;
                    obj112 = i190;
                    obj110 = i9;
                    super(value, obj108, field2, obj110, obj111, obj112, obj2, obj14, i78, obj, obj10, obj118);
                    VisualTransformation visualTransformation5 = obj110;
                    Composer composer4 = composer;
                    BasicTextFieldKt.BasicTextField(value, onValueChange, SizeKt.defaultMinSize-VpY3zN4(TextFieldImplKt.defaultErrorSemantics(TextFieldDefaults.indicatorLine-gv0btCI$default(TextFieldDefaults.INSTANCE, obj107, obj108, obj109, (InteractionSource)i94, textFieldColors-dx8h9Zs, 0, 0, 48, 0), i190, Strings_androidKt.getString-4foXLRw(Strings.Companion.getDefaultErrorMessage-UdPEhr4(), composer, 6)), TextFieldDefaults.INSTANCE.getMinWidth-D9Ej5fM(), TextFieldDefaults.INSTANCE.getMinHeight-D9Ej5fM()), field3, z4, $dirty15.merge(textStyle2), i95, shape3, field2, obj13, obj8, visualTransformation5, 0, obj111, (Brush)solidColor, (Function3)ComposableLambdaKt.rememberComposableLambda(-126640971, true, obj106, composer, 54), composer4, i125 | i144, i128 | i146, 4096);
                    composer2 = composer4;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    visualTransformation2 = field2;
                    singleLine2 = visualTransformation4;
                    obj9 = obj119;
                    $composer3 = obj120;
                    field = $dirty16;
                    i28 = skipping;
                    z = field3;
                    z7 = z4;
                    i75 = obj13;
                    i22 = obj8;
                    enabled2 = obj2;
                    readOnly2 = obj14;
                    i60 = i78;
                    i39 = modifier3;
                    shape2 = obj10;
                    maxLines2 = i95;
                    minLines2 = shape3;
                    keyboardOptions3 = obj;
                    keyboardActions2 = i11;
                } else {
                    restartGroup.skipToGroupEnd();
                    i60 = leadingIcon;
                    singleLine2 = visualTransformation;
                    maxLines2 = keyboardOptions;
                    i75 = maxLines;
                    i22 = minLines;
                    i39 = interactionSource;
                    shape2 = shape;
                    i28 = obj124;
                    $dirty18 = $dirty16;
                    composer2 = restartGroup;
                    field = $dirty14;
                    z = field3;
                    z7 = z4;
                    obj9 = obj4;
                    enabled2 = visualTransformation3;
                    readOnly2 = obj21;
                    $composer3 = obj15;
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
            endRestartGroup = new TextFieldKt.TextField.6(value, onValueChange, $composer3, z, z7, obj9, enabled2, readOnly2, i60, keyboardOptions3, keyboardActions2, singleLine2, maxLines2, minLines2, visualTransformation2, i75, i22, i39, shape2, field, $changed, $changed1, i24);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    public static final void TextField(TextFieldValue value, Function1 onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2 label, Function2 placeholder, Function2 leadingIcon, Function2 trailingIcon, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, MutableInteractionSource interactionSource, Shape shape, androidx.compose.material.TextFieldColors colors, Composer $composer, int $changed, int $changed1, int i23) {
        Object obj5;
        Object obj16;
        boolean z2;
        Object obj13;
        Object obj10;
        Object obj14;
        boolean z6;
        int i50;
        Object obj4;
        Object obj12;
        int keyboardActions3;
        Object $dirty1;
        Object endRestartGroup;
        int modifier3;
        int defaultsInvalid;
        Object modifier4;
        int i7;
        int i46;
        int i25;
        int i30;
        Object textFieldColors-dx8h9Zs;
        boolean traceInProgress;
        Object $composer2;
        int $dirty2;
        int $dirty;
        int $dirty12;
        int this_$iv;
        int $dirty15;
        boolean z4;
        int $dirty14;
        Object $dirty13;
        boolean z3;
        Object obj20;
        Object obj15;
        Object modifier2;
        boolean invalid$iv;
        int textFieldShape;
        Object enabled2;
        boolean z7;
        Object readOnly2;
        int i42;
        Object obj19;
        Object obj21;
        int textStyle2;
        Object obj;
        Object obj6;
        int label2;
        Object rememberedValue;
        Object obj11;
        int placeholder2;
        int i20;
        int i51;
        int consume;
        VisualTransformation leadingIcon2;
        int i56;
        int i37;
        KeyboardOptions trailingIcon2;
        Object obj22;
        int i;
        KeyboardActions isError2;
        Object str;
        VisualTransformation visualTransformation3;
        int visualTransformation2;
        int i22;
        KeyboardOptions keyboardOptions3;
        int keyboardOptions2;
        int i5;
        int i48;
        KeyboardActions keyboardActions4;
        Object keyboardActions2;
        int changed6;
        int i19;
        Shape singleLine2;
        int i31;
        int i27;
        Object maxLines2;
        int i24;
        int i34;
        int i11;
        int i49;
        int i10;
        int changed;
        int i18;
        Object i21;
        int changed3;
        int i41;
        int i17;
        int i33;
        Object obj7;
        int colors2;
        int i14;
        int i40;
        int i35;
        int i15;
        int i16;
        int changed5;
        int i3;
        int changed2;
        int i4;
        int i58;
        int i55;
        int i8;
        int i6;
        int i32;
        int i43;
        int i39;
        boolean changed4;
        int i47;
        int i26;
        int i57;
        int i45;
        int i38;
        Composer $composer3;
        int i53;
        int i36;
        int i2;
        int i13;
        boolean z;
        boolean z5;
        Object obj18;
        int i54;
        Object obj9;
        Object obj17;
        int i29;
        int i12;
        int i44;
        Object obj8;
        KeyboardOptions keyboardOptions4;
        int i52;
        int i28;
        Object obj2;
        Object obj3;
        int i9;
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
        int i59 = $changed;
        int i70 = $changed1;
        i30 = i23;
        textFieldColors-dx8h9Zs = $composer.startRestartGroup(-1576622884);
        ComposerKt.sourceInformation(textFieldColors-dx8h9Zs, "C(TextField)P(17,10,9,1,12,15,6,11,7,16,3,18,5,4,14,8,2,13)434@20918L7,445@21472L39,446@21550L14,447@21614L17,449@21640L408:TextField.kt#jmzs0o");
        $dirty2 = $changed;
        $dirty14 = $changed1;
        if (i30 & 1 != 0) {
            $dirty2 |= 6;
            obj20 = value;
        } else {
            if (i59 & 6 == 0) {
                i42 = textFieldColors-dx8h9Zs.changed(value) ? 4 : 2;
                $dirty2 |= i42;
            } else {
                obj20 = value;
            }
        }
        if (i30 & 2 != 0) {
            $dirty2 |= 48;
            obj19 = onValueChange;
        } else {
            if (i59 & 48 == 0) {
                i20 = textFieldColors-dx8h9Zs.changedInstance(onValueChange) ? 32 : 16;
                $dirty2 |= i20;
            } else {
                obj19 = onValueChange;
            }
        }
        consume = i30 & 4;
        if (consume != 0) {
            $dirty2 |= 384;
            str = modifier;
        } else {
            if (i59 & 384 == 0) {
                i22 = textFieldColors-dx8h9Zs.changed(modifier) ? 256 : 128;
                $dirty2 |= i22;
            } else {
                str = modifier;
            }
        }
        int i144 = i30 & 8;
        changed6 = 1024;
        if (i144 != 0) {
            $dirty2 |= 3072;
            invalid$iv = enabled;
        } else {
            if (i59 & 3072 == 0) {
                i31 = textFieldColors-dx8h9Zs.changed(enabled) ? i5 : changed6;
                $dirty2 |= i31;
            } else {
                invalid$iv = enabled;
            }
        }
        int i148 = i30 & 16;
        i11 = 8192;
        if (i148 != 0) {
            $dirty2 |= 24576;
            z7 = readOnly;
        } else {
            if (i59 & 24576 == 0) {
                i33 = textFieldColors-dx8h9Zs.changed(readOnly) ? i24 : i11;
                $dirty2 |= i33;
            } else {
                z7 = readOnly;
            }
        }
        int i152 = 196608;
        i15 = 65536;
        i16 = 131072;
        if (i59 & i152 == 0) {
            if (i30 & 32 == 0) {
                changed5 = textFieldColors-dx8h9Zs.changed(textStyle) ? i16 : i15;
            } else {
                obj = textStyle;
            }
            $dirty2 |= changed5;
        } else {
            obj = textStyle;
        }
        i3 = i30 & 64;
        final int i161 = 1572864;
        if (i3 != 0) {
            $dirty2 |= i161;
            rememberedValue = label;
        } else {
            if (i59 & i161 == 0) {
                i4 = textFieldColors-dx8h9Zs.changedInstance(label) ? 1048576 : 524288;
                $dirty2 |= i4;
            } else {
                rememberedValue = label;
            }
        }
        i37 = i30 & 128;
        final int i155 = 12582912;
        if (i37 != 0) {
            $dirty2 |= i155;
            obj22 = placeholder;
        } else {
            if (i59 & i155 == 0) {
                i55 = textFieldColors-dx8h9Zs.changedInstance(placeholder) ? 8388608 : 4194304;
                $dirty2 |= i55;
            } else {
                obj22 = placeholder;
            }
        }
        int i60 = i30 & 256;
        int i156 = 100663296;
        if (i60 != 0) {
            $dirty2 |= i156;
            i8 = i60;
            obj5 = leadingIcon;
        } else {
            if ($changed & i156 == 0) {
                i8 = i60;
                i6 = textFieldColors-dx8h9Zs.changedInstance(leadingIcon) ? 67108864 : 33554432;
                $dirty2 |= i6;
            } else {
                i8 = i60;
                obj5 = leadingIcon;
            }
        }
        int i61 = i30 & 512;
        int i158 = 805306368;
        if (i61 != 0) {
            $dirty2 |= i158;
            i32 = i61;
            obj16 = trailingIcon;
        } else {
            if ($changed & i158 == 0) {
                i32 = i61;
                i43 = textFieldColors-dx8h9Zs.changedInstance(trailingIcon) ? 536870912 : 268435456;
                $dirty2 |= i43;
            } else {
                i32 = i61;
                obj16 = trailingIcon;
            }
        }
        int i62 = i30 & 1024;
        if (i62 != 0) {
            $dirty14 |= 6;
            i39 = i62;
            z2 = isError;
        } else {
            if (i70 & 6 == 0) {
                i39 = i62;
                i41 = textFieldColors-dx8h9Zs.changed(isError) ? 4 : 2;
                $dirty14 |= i41;
            } else {
                i39 = i62;
                z2 = isError;
            }
        }
        int i63 = i30 & 2048;
        if (i63 != 0) {
            $dirty14 |= 48;
            i17 = i63;
            obj13 = visualTransformation;
        } else {
            if (i70 & 48 == 0) {
                i17 = i63;
                changed2 = textFieldColors-dx8h9Zs.changed(visualTransformation) ? 32 : 16;
                $dirty14 |= changed2;
            } else {
                i17 = i63;
                obj13 = visualTransformation;
            }
        }
        int i64 = i30 & 4096;
        if (i64 != 0) {
            $dirty14 |= 384;
            i40 = i64;
            obj10 = keyboardOptions;
        } else {
            i40 = i64;
            if (i70 & 384 == 0) {
                i4 = textFieldColors-dx8h9Zs.changed(keyboardOptions) ? 256 : 128;
                $dirty14 |= i4;
            } else {
                obj10 = keyboardOptions;
            }
        }
        if (i70 & 3072 == 0) {
            if (i30 & 8192 == 0) {
                if (textFieldColors-dx8h9Zs.changed(keyboardActions)) {
                } else {
                    i5 = changed6;
                }
            } else {
                obj14 = keyboardActions;
            }
            $dirty14 |= i5;
        } else {
            obj14 = keyboardActions;
        }
        int i67 = i30 & 16384;
        if (i67 != 0) {
            $dirty14 |= 24576;
            i48 = i67;
            z6 = singleLine;
        } else {
            i48 = i67;
            if (i70 & 24576 == 0) {
                if (textFieldColors-dx8h9Zs.changed(singleLine)) {
                } else {
                    i24 = i11;
                }
                $dirty14 |= i24;
            } else {
                z6 = singleLine;
            }
        }
        int i147 = i30 & i146;
        if (i147 != 0) {
            $dirty14 |= i152;
            i50 = maxLines;
        } else {
            if (i70 & i152 == 0) {
                i24 = textFieldColors-dx8h9Zs.changed(maxLines) ? i16 : i15;
                $dirty14 |= i24;
            } else {
                i50 = maxLines;
            }
        }
        i34 = i30 & i15;
        if (i34 != 0) {
            $dirty14 |= i161;
            obj4 = interactionSource;
        } else {
            if (i70 & i161 == 0) {
                i11 = textFieldColors-dx8h9Zs.changed(interactionSource) ? 1048576 : 524288;
                $dirty14 |= i11;
            } else {
                obj4 = interactionSource;
            }
        }
        if (i70 & i155 == 0) {
            if (i30 & i16 == 0) {
                i49 = textFieldColors-dx8h9Zs.changed(shape) ? 8388608 : 4194304;
            } else {
                obj12 = shape;
            }
            $dirty14 |= i49;
        } else {
            obj12 = shape;
        }
        int i153 = 262144;
        if (i70 & i156 == 0) {
            if (i30 & i153 == 0) {
                obj90 = $dirty14;
                i10 = textFieldColors-dx8h9Zs.changed(colors) ? 67108864 : 33554432;
            } else {
                obj90 = $dirty14;
                $dirty13 = colors;
            }
            keyboardActions3 = i18;
        } else {
            $dirty13 = colors;
            keyboardActions3 = obj90;
        }
        obj90 = $dirty2;
        if ($dirty2 & i21 == 306783378 && i72 &= keyboardActions3 == 38347922) {
            if (i72 &= keyboardActions3 == 38347922) {
                if (!textFieldColors-dx8h9Zs.getSkipping()) {
                    textFieldColors-dx8h9Zs.startDefaults();
                    if ($changed & 1 != 0) {
                        if (textFieldColors-dx8h9Zs.getDefaultsInvalid()) {
                            if (consume != 0) {
                                modifier4 = Modifier.Companion;
                            } else {
                                modifier4 = str;
                            }
                            z = i144 != 0 ? $dirty : invalid$iv;
                            z5 = i148 != 0 ? $dirty : z7;
                            if (i30 & 32 != 0) {
                                int i130 = 6;
                                z7 = 0;
                                ComposerKt.sourceInformationMarkerStart(textFieldColors-dx8h9Zs, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                ComposerKt.sourceInformationMarkerEnd(textFieldColors-dx8h9Zs);
                                obj18 = this_$iv;
                                i54 = invalid$iv;
                            } else {
                                i54 = obj90;
                                obj18 = obj;
                            }
                            obj9 = i3 != 0 ? this_$iv : rememberedValue;
                            obj17 = i37 != 0 ? this_$iv : obj22;
                            i29 = i8 != 0 ? this_$iv : leadingIcon;
                            i12 = i32 != 0 ? this_$iv : trailingIcon;
                            i44 = i39 != 0 ? this_$iv : isError;
                            if (i17 != 0) {
                                obj8 = this_$iv;
                            } else {
                                obj8 = visualTransformation;
                            }
                            if (i40 != 0) {
                                keyboardOptions4 = this_$iv;
                            } else {
                                keyboardOptions4 = keyboardOptions;
                            }
                            if (i30 & 8192 != 0) {
                                super(0, 0, 0, 0, 0, 0, 63, 0);
                                $dirty15 = $dirty16;
                                $dirty1 = keyboardActions5;
                            } else {
                                $dirty15 = keyboardActions3;
                                $dirty1 = keyboardActions;
                            }
                            i52 = i48 != 0 ? invalid$iv : singleLine;
                            i28 = i147 != 0 ? invalid$iv : maxLines;
                            if (i34 != 0) {
                                ComposerKt.sourceInformationMarkerStart(textFieldColors-dx8h9Zs, -53648114, "CC(remember):TextField.kt#9igjgp");
                                int i129 = 0;
                                z7 = textFieldColors-dx8h9Zs;
                                obj = 0;
                                rememberedValue = z7.rememberedValue();
                                consume = 0;
                                if (rememberedValue == Composer.Companion.getEmpty()) {
                                    int i141 = 0;
                                    z7.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                                } else {
                                    i37 = rememberedValue;
                                }
                                ComposerKt.sourceInformationMarkerEnd(textFieldColors-dx8h9Zs);
                                obj2 = invalid$iv;
                            } else {
                                obj2 = interactionSource;
                            }
                            if (i30 & i16 != 0) {
                                obj3 = textFieldShape;
                                i9 = $dirty15;
                            } else {
                                obj3 = shape;
                                i9 = $dirty15;
                            }
                            if (i30 & i153 != 0) {
                                keyboardActions4 = $dirty1;
                                obj15 = modifier4;
                                obj7 = textFieldColors-dx8h9Zs;
                                keyboardActions3 = $dirty12;
                                invalid$iv = z;
                                z7 = z5;
                                obj21 = obj18;
                                modifier3 = i54;
                                obj6 = obj9;
                                obj11 = obj17;
                                i51 = i29;
                                i56 = i12;
                                i = i44;
                                visualTransformation3 = obj8;
                                keyboardOptions3 = keyboardOptions4;
                                i19 = i52;
                                i27 = i28;
                                i21 = obj2;
                                i17 = obj3;
                            } else {
                                $composer3 = textFieldColors-dx8h9Zs;
                                obj7 = colors;
                                keyboardActions4 = $dirty1;
                                obj15 = modifier4;
                                invalid$iv = z;
                                z7 = z5;
                                obj21 = obj18;
                                modifier3 = i54;
                                obj6 = obj9;
                                obj11 = obj17;
                                i51 = i29;
                                i56 = i12;
                                i = i44;
                                visualTransformation3 = obj8;
                                keyboardOptions3 = keyboardOptions4;
                                i19 = i52;
                                i27 = i28;
                                i21 = obj2;
                                i17 = obj3;
                                keyboardActions3 = i9;
                            }
                        } else {
                            textFieldColors-dx8h9Zs.skipToGroupEnd();
                            $dirty12 = i30 & 32 != 0 ? obj90 & i7 : obj90;
                            if (i30 & 8192 != 0) {
                                keyboardActions3 &= -7169;
                            }
                            if (i30 & i16 != 0) {
                                keyboardActions3 &= i46;
                            }
                            if (i30 & i153 != 0) {
                                keyboardActions3 &= i25;
                            }
                            i51 = leadingIcon;
                            i56 = trailingIcon;
                            keyboardOptions3 = keyboardOptions;
                            keyboardActions4 = keyboardActions;
                            i19 = singleLine;
                            i27 = maxLines;
                            i21 = interactionSource;
                            i17 = shape;
                            $composer3 = textFieldColors-dx8h9Zs;
                            modifier3 = $dirty12;
                            obj7 = $dirty13;
                            obj21 = obj;
                            obj6 = rememberedValue;
                            obj11 = obj22;
                            obj15 = str;
                            i = isError;
                            visualTransformation3 = visualTransformation;
                        }
                    } else {
                    }
                    $composer3.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1576622884, modifier3, keyboardActions3, "androidx.compose.material.TextField (TextField.kt:448)");
                    }
                    TextFieldKt.TextField(value, onValueChange, obj15, invalid$iv, z7, obj21, obj6, obj11, i51, i56, i, visualTransformation3, keyboardOptions3, keyboardActions4, i19, i27, 1, i21, i17, obj7, $composer3, i82 | i106, i91 | i119, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i35 = modifier3;
                    $composer2 = obj15;
                    z4 = invalid$iv;
                    z3 = z7;
                    modifier2 = obj21;
                    enabled2 = obj6;
                    readOnly2 = obj11;
                    textStyle2 = i51;
                    label2 = i56;
                    placeholder2 = i;
                    leadingIcon2 = visualTransformation3;
                    trailingIcon2 = keyboardOptions3;
                    isError2 = keyboardActions4;
                    visualTransformation2 = i19;
                    keyboardOptions2 = i27;
                    keyboardActions2 = i21;
                    singleLine2 = i17;
                    maxLines2 = obj7;
                    colors2 = keyboardActions3;
                } else {
                    textFieldColors-dx8h9Zs.skipToGroupEnd();
                    textStyle2 = leadingIcon;
                    leadingIcon2 = visualTransformation;
                    trailingIcon2 = keyboardOptions;
                    keyboardOptions2 = maxLines;
                    keyboardActions2 = interactionSource;
                    singleLine2 = shape;
                    i35 = obj90;
                    $composer3 = textFieldColors-dx8h9Zs;
                    maxLines2 = $dirty13;
                    z4 = invalid$iv;
                    z3 = z7;
                    modifier2 = obj;
                    enabled2 = rememberedValue;
                    readOnly2 = obj22;
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
            endRestartGroup = new TextFieldKt.TextField.8(value, onValueChange, $composer2, z4, z3, modifier2, enabled2, readOnly2, textStyle2, label2, placeholder2, leadingIcon2, trailingIcon2, isError2, visualTransformation2, keyboardOptions2, keyboardActions2, singleLine2, maxLines2, $changed, $changed1, i30);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    public static final void TextField(String value, Function1<? super String, Unit> onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> label, Function2<? super Composer, ? super Integer, Unit> placeholder, Function2<? super Composer, ? super Integer, Unit> leadingIcon, Function2<? super Composer, ? super Integer, Unit> trailingIcon, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, int minLines, MutableInteractionSource interactionSource, Shape shape, androidx.compose.material.TextFieldColors colors, Composer $composer, int $changed, int $changed1, int i24) {
        Object obj11;
        Object obj14;
        boolean z6;
        Object obj10;
        Object obj15;
        Object obj18;
        boolean z2;
        int i74;
        int i32;
        Object obj6;
        Object obj21;
        int $dirty14;
        Object $dirty12;
        Object $dirty15;
        Object endRestartGroup;
        int skipping;
        int $dirty4;
        int $dirty3;
        int $dirty13;
        int defaultsInvalid;
        Object modifier3;
        int i76;
        boolean traceInProgress2;
        int $composer2;
        int i80;
        Object $composer3;
        int $dirty;
        int $dirty2;
        int i39;
        int i98;
        Object textFieldColors-dx8h9Zs;
        int default;
        int $dirty18;
        boolean z5;
        int $dirty1;
        Object $dirty16;
        Composer composer;
        boolean z7;
        Object obj2;
        int i58;
        Object obj4;
        boolean str;
        int i102;
        int i92;
        int textFieldShape;
        Object enabled2;
        boolean z;
        Object readOnly2;
        int i81;
        Object obj12;
        boolean traceInProgress;
        int value2;
        int i78;
        Object obj5;
        KeyboardOptions i90;
        int keyboardOptions2;
        Object visualTransformation2;
        Object shape3;
        int keyboardActions2;
        int i46;
        int field2;
        int i101;
        VisualTransformation singleLine2;
        int obj16;
        int i83;
        KeyboardOptions maxLines2;
        Object obj13;
        int obj3;
        KeyboardActions minLines2;
        Object obj9;
        int visualTransformation3;
        int i61;
        int i54;
        int i51;
        int i97;
        int i7;
        int i99;
        int changed3;
        int i8;
        int changed2;
        int i47;
        long $this$takeOrElse_u2dDxMtmZc$iv;
        int i3;
        int i77;
        int companion;
        Shape shape2;
        int i94;
        int i52;
        long unbox-impl;
        Object field;
        int i71;
        int i19;
        int i26;
        int i42;
        int i34;
        int changed7;
        int i86;
        int i59;
        int i18;
        int i16;
        int i87;
        int $dirty17;
        int i20;
        int changed;
        int changed5;
        int i4;
        int i57;
        int changed6;
        int i60;
        int i9;
        int i27;
        int i5;
        int i33;
        int i73;
        int i93;
        int i40;
        int i30;
        boolean changed4;
        int i36;
        int i2;
        int i23;
        int i96;
        int i37;
        int i35;
        int i88;
        int i100;
        int i68;
        int i95;
        int i70;
        int i84;
        int i;
        Composer composer2;
        Composer composer3;
        int i67;
        int i10;
        int i25;
        int i85;
        boolean z3;
        boolean z4;
        Object obj17;
        int i29;
        Object obj20;
        Object obj;
        int i53;
        int obj8;
        int obj7;
        int i62;
        VisualTransformation i38;
        KeyboardOptions keyboardOptions3;
        int i6;
        int i11;
        int i63;
        int modifier2;
        Shape obj19;
        int i43;
        int i44;
        TextStyle textStyle2;
        long l;
        int i28;
        int i50;
        int i72;
        int i12;
        int i13;
        int i49;
        int i75;
        int i14;
        int i31;
        int i79;
        int i65;
        int i69;
        int i82;
        int i45;
        int i15;
        int i17;
        int i91;
        int i21;
        int i41;
        int i48;
        int i66;
        int i55;
        int i64;
        int i89;
        int i56;
        ScopeUpdateScope scopeUpdateScope;
        int i22;
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
        int i103 = $changed;
        int i115 = $changed1;
        traceInProgress2 = i24;
        Composer restartGroup = $composer.startRestartGroup(-1504264404);
        ComposerKt.sourceInformation(restartGroup, "C(TextField)P(18,11,10,1,13,16,6,12,7,17,3,19,5,4,15,8,9,2,14)165@8582L7,178@9226L14,179@9290L17,194@9914L38,203@10281L20,211@10623L719,190@9731L1617:TextField.kt#jmzs0o");
        $dirty = $changed;
        $dirty1 = $changed1;
        if (traceInProgress2 & 1 != 0) {
            $dirty |= 6;
            obj2 = value;
        } else {
            if (i103 & 6 == 0) {
                i81 = restartGroup.changed(value) ? 4 : 2;
                $dirty |= i81;
            } else {
                obj2 = value;
            }
        }
        if (traceInProgress2 & 2 != 0) {
            $dirty |= 48;
            obj12 = onValueChange;
        } else {
            if (i103 & 48 == 0) {
                i46 = restartGroup.changedInstance(onValueChange) ? 32 : 16;
                $dirty |= i46;
            } else {
                obj12 = onValueChange;
            }
        }
        i101 = traceInProgress2 & 4;
        if (i101 != 0) {
            $dirty |= 384;
            obj9 = modifier;
        } else {
            if (i103 & 384 == 0) {
                i61 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty |= i61;
            } else {
                obj9 = modifier;
            }
        }
        i54 = traceInProgress2 & 8;
        changed3 = 1024;
        if (i54 != 0) {
            $dirty |= 3072;
            str = enabled;
        } else {
            if (i103 & 3072 == 0) {
                i77 = restartGroup.changed(enabled) ? i97 : changed3;
                $dirty |= i77;
            } else {
                str = enabled;
            }
        }
        companion = traceInProgress2 & 16;
        if (companion != 0) {
            $dirty |= 24576;
            z = readOnly;
        } else {
            if (i103 & 24576 == 0) {
                i26 = restartGroup.changed(readOnly) ? 16384 : i94;
                $dirty |= i26;
            } else {
                z = readOnly;
            }
        }
        if (i103 & i211 == 0) {
            if (traceInProgress2 & 32 == 0) {
                changed7 = restartGroup.changed(textStyle) ? 131072 : 65536;
            } else {
                obj5 = textStyle;
            }
            $dirty |= changed7;
        } else {
            obj5 = textStyle;
        }
        i86 = traceInProgress2 & 64;
        i59 = 1572864;
        i4 = 524288;
        if (i86 != 0) {
            $dirty |= i59;
            visualTransformation2 = label;
        } else {
            if (i103 & i59 == 0) {
                i60 = restartGroup.changedInstance(label) ? 1048576 : i4;
                $dirty |= i60;
            } else {
                visualTransformation2 = label;
            }
        }
        i83 = traceInProgress2 & 128;
        i9 = 12582912;
        if (i83 != 0) {
            $dirty |= i9;
            obj13 = placeholder;
        } else {
            if (i103 & i9 == 0) {
                i5 = restartGroup.changedInstance(placeholder) ? 8388608 : 4194304;
                $dirty |= i5;
            } else {
                obj13 = placeholder;
            }
        }
        int i104 = traceInProgress2 & 256;
        int i220 = 100663296;
        if (i104 != 0) {
            $dirty |= i220;
            i33 = i104;
            obj11 = leadingIcon;
        } else {
            if ($changed & i220 == 0) {
                i33 = i104;
                i73 = restartGroup.changedInstance(leadingIcon) ? 67108864 : 33554432;
                $dirty |= i73;
            } else {
                i33 = i104;
                obj11 = leadingIcon;
            }
        }
        int i105 = traceInProgress2 & 512;
        int i222 = 805306368;
        if (i105 != 0) {
            $dirty |= i222;
            i93 = i105;
            obj14 = trailingIcon;
        } else {
            if ($changed & i222 == 0) {
                i93 = i105;
                i40 = restartGroup.changedInstance(trailingIcon) ? 536870912 : 268435456;
                $dirty |= i40;
            } else {
                i93 = i105;
                obj14 = trailingIcon;
            }
        }
        int i106 = traceInProgress2 & 1024;
        if (i106 != 0) {
            $dirty1 |= 6;
            i30 = i106;
            z6 = isError;
        } else {
            if (i115 & 6 == 0) {
                i30 = i106;
                i71 = restartGroup.changed(isError) ? 4 : 2;
                $dirty1 |= i71;
            } else {
                i30 = i106;
                z6 = isError;
            }
        }
        int i107 = traceInProgress2 & 2048;
        if (i107 != 0) {
            $dirty1 |= 48;
            i19 = i107;
            obj10 = visualTransformation;
        } else {
            if (i115 & 48 == 0) {
                i19 = i107;
                changed6 = restartGroup.changed(visualTransformation) ? 32 : 16;
                $dirty1 |= changed6;
            } else {
                i19 = i107;
                obj10 = visualTransformation;
            }
        }
        int i108 = traceInProgress2 & 4096;
        if (i108 != 0) {
            $dirty1 |= 384;
            i34 = i108;
            obj15 = keyboardOptions;
        } else {
            i34 = i108;
            if (i115 & 384 == 0) {
                i60 = restartGroup.changed(keyboardOptions) ? 256 : 128;
                $dirty1 |= i60;
            } else {
                obj15 = keyboardOptions;
            }
        }
        if (i115 & 3072 == 0) {
            if (traceInProgress2 & 8192 == 0) {
                if (restartGroup.changed(keyboardActions)) {
                } else {
                    i97 = changed3;
                }
            } else {
                obj18 = keyboardActions;
            }
            $dirty1 |= i97;
        } else {
            obj18 = keyboardActions;
        }
        int i111 = traceInProgress2 & 16384;
        if (i111 != 0) {
            $dirty1 |= 24576;
            i7 = i111;
            z2 = singleLine;
        } else {
            i7 = i111;
            if (i115 & 24576 == 0) {
                if (restartGroup.changed(singleLine)) {
                    i94 = 16384;
                }
                $dirty1 |= i94;
            } else {
                z2 = singleLine;
            }
        }
        if (i115 & i201 == 0) {
            if (traceInProgress2 & i202 == 0) {
                i8 = restartGroup.changed(maxLines) ? 131072 : 65536;
            } else {
                i74 = maxLines;
            }
            $dirty1 |= i8;
        } else {
            i74 = maxLines;
        }
        i47 = traceInProgress2 & i203;
        if (i47 != 0) {
            $dirty1 |= i59;
            i32 = minLines;
        } else {
            if (i115 & i59 == 0) {
                i94 = restartGroup.changed(minLines) ? 1048576 : i4;
                $dirty1 |= i94;
            } else {
                i32 = minLines;
            }
        }
        i52 = traceInProgress2 & i207;
        if (i52 != 0) {
            $dirty1 |= i9;
            obj6 = interactionSource;
        } else {
            if (i115 & i9 == 0) {
                i59 = restartGroup.changed(interactionSource) ? 8388608 : 4194304;
                $dirty1 |= i59;
            } else {
                obj6 = interactionSource;
            }
        }
        if (i115 & i214 == 0) {
            if (traceInProgress2 & i216 == 0) {
                i18 = restartGroup.changed(shape) ? 67108864 : 33554432;
            } else {
                obj21 = shape;
            }
            $dirty1 |= i18;
        } else {
            obj21 = shape;
        }
        if (i115 & i215 == 0) {
            if (traceInProgress2 & i4 == 0) {
                obj124 = $dirty1;
                i20 = restartGroup.changed(colors) ? 536870912 : 268435456;
            } else {
                obj124 = $dirty1;
                $dirty16 = colors;
            }
            $dirty14 = i16;
        } else {
            $dirty16 = colors;
            $dirty14 = obj124;
        }
        obj124 = $dirty;
        if ($dirty & i87 == 306783378 && i129 &= $dirty14 == 306783378) {
            if (i129 &= $dirty14 == 306783378) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    default = -458753;
                    int i161 = 6;
                    int i164 = 1;
                    if ($changed & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if (i101 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = obj9;
                            }
                            z3 = i54 != 0 ? str : str;
                            z4 = companion != 0 ? str : z;
                            if (traceInProgress2 & 32 != 0) {
                                z = 6;
                                i101 = 0;
                                ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                                obj17 = default;
                                i29 = i102;
                            } else {
                                i54 = default;
                                i29 = obj124;
                                obj17 = obj5;
                            }
                            obj20 = i86 != 0 ? default : visualTransformation2;
                            obj = i83 != 0 ? default : obj13;
                            i53 = i33 != 0 ? default : leadingIcon;
                            obj8 = i93 != 0 ? default : trailingIcon;
                            obj7 = i30 != 0 ? default : isError;
                            if (i19 != 0) {
                                i38 = default;
                            } else {
                                i38 = visualTransformation;
                            }
                            if (i34 != 0) {
                                keyboardOptions3 = default;
                            } else {
                                keyboardOptions3 = keyboardOptions;
                            }
                            if (traceInProgress2 & 8192 != 0) {
                                super(0, 0, 0, 0, 0, 0, 63, 0);
                                $dirty18 = $dirty19;
                                $dirty15 = i22;
                            } else {
                                $dirty18 = $dirty14;
                                $dirty15 = keyboardActions;
                            }
                            i6 = i7 != 0 ? i102 : singleLine;
                            if (i168 &= traceInProgress2 != 0) {
                                i92 = i6 != 0 ? i164 : 0x7fffffff /* Unknown resource */;
                                $dirty18 &= i54;
                                i11 = i92;
                            } else {
                                i11 = maxLines;
                            }
                            i63 = i47 != 0 ? i92 : minLines;
                            modifier2 = i52 != 0 ? i92 : interactionSource;
                            if (i169 &= traceInProgress2 != 0) {
                                obj19 = textFieldShape;
                                i43 = $dirty18;
                            } else {
                                obj19 = shape;
                                i43 = $dirty18;
                            }
                            if (traceInProgress2 & i4 != 0) {
                                int i173 = i164;
                                int i180 = i170;
                                int i186 = i180;
                                int i189 = i181;
                                i54 = i189;
                                i47 = i54;
                                i52 = i47;
                                i34 = i52;
                                i87 = i34;
                                changed6 = i87;
                                i9 = changed6;
                                i33 = i9;
                                i30 = i33;
                                i36 = i30;
                                i23 = i36;
                                i37 = i23;
                                i88 = i37;
                                i68 = i88;
                                i70 = i68;
                                i = i70;
                                i44 = i235;
                                composer2 = restartGroup;
                                $composer2 = i22;
                                textFieldColors-dx8h9Zs = TextFieldDefaults.INSTANCE.textFieldColors-dx8h9Zs(0, i164, 0, i173, 0, i180, 0, i186, 0, i189, 0, i54, 0, i47, 0, i52, 0, i34, 0, i87, 0, changed6, 0, i9, 0, i33);
                                composer = composer2;
                                shape3 = $dirty15;
                                obj9 = modifier3;
                                $dirty3 = i166;
                                str = z3;
                                z = z4;
                                $dirty12 = obj17;
                                i58 = i29;
                                i90 = keyboardOptions3;
                                field2 = i6;
                                obj16 = i11;
                                obj3 = i63;
                            } else {
                                composer = restartGroup;
                                $composer2 = i22;
                                textFieldColors-dx8h9Zs = colors;
                                shape3 = $dirty15;
                                obj9 = modifier3;
                                str = z3;
                                z = z4;
                                $dirty12 = obj17;
                                i58 = i29;
                                i90 = keyboardOptions3;
                                field2 = i6;
                                obj16 = i11;
                                obj3 = i63;
                                $dirty3 = i43;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            $dirty4 = traceInProgress2 & 32 != 0 ? obj124 & default : obj124;
                            if (traceInProgress2 & 8192 != 0) {
                                $dirty14 &= -7169;
                            }
                            if (i184 &= traceInProgress2 != 0) {
                                $dirty14 &= default;
                            }
                            if (i157 &= traceInProgress2 != 0) {
                                $dirty14 &= i39;
                            }
                            if (traceInProgress2 & i4 != 0) {
                                $dirty14 &= i98;
                            }
                            composer = restartGroup;
                            $composer2 = i158;
                            i53 = leadingIcon;
                            obj8 = trailingIcon;
                            obj7 = isError;
                            i38 = visualTransformation;
                            field2 = singleLine;
                            obj16 = maxLines;
                            modifier2 = interactionSource;
                            obj19 = shape;
                            textFieldColors-dx8h9Zs = colors;
                            i58 = $dirty4;
                            obj20 = visualTransformation2;
                            obj = obj13;
                            shape3 = keyboardActions;
                            obj3 = minLines;
                            $dirty3 = $dirty14;
                            $dirty12 = obj5;
                            i90 = keyboardOptions;
                        }
                    } else {
                    }
                    composer.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1504264404, i58, $dirty3, "androidx.compose.material.TextField (TextField.kt:180)");
                    }
                    if (modifier2 == 0) {
                        composer.startReplaceGroup(-1675073900);
                        ComposerKt.sourceInformation(composer, "182@9393L39");
                        ComposerKt.sourceInformationMarkerStart(composer, -54034642, "CC(remember):TextField.kt#9igjgp");
                        $composer2 = 0;
                        traceInProgress = composer;
                        i54 = 0;
                        $dirty17 = $dirty3;
                        $dirty13 = traceInProgress.rememberedValue();
                        i47 = 0;
                        if ($dirty13 == Composer.Companion.getEmpty()) {
                            int i147 = 0;
                            traceInProgress.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                        } else {
                            i76 = $dirty13;
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        composer.endReplaceGroup();
                    } else {
                        $dirty17 = $dirty3;
                        composer.startReplaceGroup(-54035293);
                        composer.endReplaceGroup();
                        i76 = modifier2;
                    }
                    composer.startReplaceGroup(-54029535);
                    ComposerKt.sourceInformation(composer, "*185@9580L18");
                    int i118 = 0;
                    i80 = 0;
                    value2 = Long.compare(unbox-impl, i212) != 0 ? 1 : 0;
                    if (value2 != null) {
                    } else {
                        i80 = 0;
                        $this$takeOrElse_u2dDxMtmZc$iv = unbox-impl;
                    }
                    composer.endReplaceGroup();
                    textStyle2 = new TextStyle($this$takeOrElse_u2dDxMtmZc$iv, obj72, 0, obj74, 0, 0, 0, 0, 0, 0, obj81, 0, 0, 0, 0, obj86, 0, 0, 0, 0, 0, 0, obj93, 0, 0, 0, 0, 0, 0, 16777214, 0);
                    obj108 = str;
                    obj107 = obj9;
                    obj109 = obj7;
                    Object obj22 = obj107;
                    int i190 = obj109;
                    obj111 = i76;
                    SolidColor solidColor = new SolidColor((Color)textFieldColors-dx8h9Zs.cursorColor(i190, composer, i130 |= i196).getValue().unbox-impl(), obj22, 0);
                    obj106 = anon;
                    obj118 = textFieldColors-dx8h9Zs;
                    obj112 = i190;
                    obj110 = i38;
                    super(value, obj108, field2, obj110, obj111, obj112, obj20, obj, i53, obj8, obj19, obj118);
                    VisualTransformation visualTransformation5 = obj110;
                    Composer composer4 = composer;
                    BasicTextFieldKt.BasicTextField(value, onValueChange, SizeKt.defaultMinSize-VpY3zN4(TextFieldImplKt.defaultErrorSemantics(TextFieldDefaults.indicatorLine-gv0btCI$default(TextFieldDefaults.INSTANCE, obj107, obj108, obj109, (InteractionSource)i76, textFieldColors-dx8h9Zs, 0, 0, 48, 0), i190, Strings_androidKt.getString-4foXLRw(Strings.Companion.getDefaultErrorMessage-UdPEhr4(), composer, 6)), TextFieldDefaults.INSTANCE.getMinWidth-D9Ej5fM(), TextFieldDefaults.INSTANCE.getMinHeight-D9Ej5fM()), str, z, $dirty12.merge(textStyle2), i90, shape3, field2, obj16, obj3, visualTransformation5, 0, obj111, (Brush)solidColor, (Function3)ComposableLambdaKt.rememberComposableLambda(989834338, true, obj106, composer, 54), composer4, i125 | i144, i128 | i146, 4096);
                    composer3 = composer4;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    visualTransformation3 = field2;
                    singleLine2 = visualTransformation4;
                    obj4 = obj119;
                    $composer3 = obj120;
                    field = $dirty14;
                    i57 = skipping;
                    z5 = str;
                    z7 = z;
                    i51 = obj16;
                    i99 = obj3;
                    enabled2 = obj20;
                    readOnly2 = obj;
                    i78 = i53;
                    i3 = modifier2;
                    shape2 = obj19;
                    maxLines2 = i90;
                    minLines2 = shape3;
                    keyboardOptions2 = obj8;
                    keyboardActions2 = i62;
                } else {
                    restartGroup.skipToGroupEnd();
                    i78 = leadingIcon;
                    singleLine2 = visualTransformation;
                    maxLines2 = keyboardOptions;
                    i51 = maxLines;
                    i99 = minLines;
                    i3 = interactionSource;
                    shape2 = shape;
                    i57 = obj124;
                    $dirty17 = $dirty14;
                    composer3 = restartGroup;
                    field = $dirty16;
                    z5 = str;
                    z7 = z;
                    obj4 = obj5;
                    enabled2 = visualTransformation2;
                    readOnly2 = obj13;
                    $composer3 = obj9;
                    keyboardOptions2 = trailingIcon;
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
            endRestartGroup = new TextFieldKt.TextField.2(value, onValueChange, $composer3, z5, z7, obj4, enabled2, readOnly2, i78, keyboardOptions2, keyboardActions2, singleLine2, maxLines2, minLines2, visualTransformation3, i51, i99, i3, shape2, field, $changed, $changed1, i24);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    public static final void TextField(String value, Function1 onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2 label, Function2 placeholder, Function2 leadingIcon, Function2 trailingIcon, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, MutableInteractionSource interactionSource, Shape shape, androidx.compose.material.TextFieldColors colors, Composer $composer, int $changed, int $changed1, int i23) {
        Object obj21;
        Object obj;
        boolean z;
        Object obj14;
        Object obj2;
        Object obj8;
        boolean z6;
        int i33;
        Object obj20;
        Object obj3;
        int keyboardActions3;
        Object $dirty12;
        Object endRestartGroup;
        int modifier3;
        int defaultsInvalid;
        Object modifier4;
        int i48;
        int i53;
        int i49;
        int i20;
        Object textFieldColors-dx8h9Zs;
        boolean traceInProgress;
        Object $composer3;
        int $dirty2;
        int $dirty;
        int $dirty13;
        int this_$iv;
        int $dirty14;
        boolean z3;
        int $dirty15;
        Object $dirty1;
        boolean z5;
        Object obj17;
        Object obj11;
        Object modifier2;
        boolean invalid$iv;
        int copy$default;
        Object enabled2;
        boolean z7;
        Object readOnly2;
        int i3;
        Object obj12;
        Object obj13;
        int textStyle2;
        Object zeroCornerSize;
        Object obj18;
        int label2;
        Object rememberedValue;
        Object obj10;
        int placeholder2;
        int i41;
        int i5;
        int consume;
        VisualTransformation leadingIcon2;
        int i54;
        int i22;
        KeyboardOptions trailingIcon2;
        Object obj6;
        int i26;
        KeyboardActions isError2;
        Object str;
        VisualTransformation visualTransformation2;
        int visualTransformation3;
        int i45;
        KeyboardOptions keyboardOptions4;
        int keyboardOptions3;
        int i50;
        int i39;
        KeyboardActions keyboardActions4;
        Object keyboardActions2;
        int changed6;
        int i13;
        CornerBasedShape singleLine2;
        int i34;
        int i2;
        Object maxLines2;
        int i57;
        int i8;
        int i44;
        int i;
        int i40;
        int changed3;
        int i25;
        Object i15;
        int changed5;
        int i43;
        int i46;
        int i52;
        Object obj5;
        int colors2;
        int i17;
        int i51;
        int i47;
        int i42;
        int i36;
        int changed;
        int i21;
        int changed2;
        int i11;
        int i29;
        int i30;
        int i27;
        int i24;
        int i6;
        int i55;
        int i28;
        boolean changed4;
        int i58;
        int i18;
        int i14;
        int i4;
        int i37;
        Composer $composer2;
        int i16;
        int i12;
        int i56;
        int i38;
        boolean z2;
        boolean z4;
        Object obj15;
        int i7;
        Object obj16;
        Object obj4;
        int i35;
        int i31;
        int i10;
        Object obj19;
        KeyboardOptions keyboardOptions2;
        int i19;
        int i32;
        Object obj7;
        Object obj9;
        int i9;
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
        int i59 = $changed;
        int i70 = $changed1;
        i20 = i23;
        textFieldColors-dx8h9Zs = $composer.startRestartGroup(-1690895095);
        ComposerKt.sourceInformation(textFieldColors-dx8h9Zs, "C(TextField)P(17,10,9,1,12,15,6,11,7,16,3,18,5,4,14,8,2,13)243@11701L7,254@12255L39,256@12337L6,257@12462L17,259@12488L408:TextField.kt#jmzs0o");
        $dirty2 = $changed;
        $dirty15 = $changed1;
        if (i20 & 1 != 0) {
            $dirty2 |= 6;
            obj17 = value;
        } else {
            if (i59 & 6 == 0) {
                i3 = textFieldColors-dx8h9Zs.changed(value) ? 4 : 2;
                $dirty2 |= i3;
            } else {
                obj17 = value;
            }
        }
        if (i20 & 2 != 0) {
            $dirty2 |= 48;
            obj12 = onValueChange;
        } else {
            if (i59 & 48 == 0) {
                i41 = textFieldColors-dx8h9Zs.changedInstance(onValueChange) ? 32 : 16;
                $dirty2 |= i41;
            } else {
                obj12 = onValueChange;
            }
        }
        consume = i20 & 4;
        if (consume != 0) {
            $dirty2 |= 384;
            str = modifier;
        } else {
            if (i59 & 384 == 0) {
                i45 = textFieldColors-dx8h9Zs.changed(modifier) ? 256 : 128;
                $dirty2 |= i45;
            } else {
                str = modifier;
            }
        }
        int i144 = i20 & 8;
        changed6 = 1024;
        if (i144 != 0) {
            $dirty2 |= 3072;
            invalid$iv = enabled;
        } else {
            if (i59 & 3072 == 0) {
                i34 = textFieldColors-dx8h9Zs.changed(enabled) ? i50 : changed6;
                $dirty2 |= i34;
            } else {
                invalid$iv = enabled;
            }
        }
        int i148 = i20 & 16;
        i44 = 8192;
        if (i148 != 0) {
            $dirty2 |= 24576;
            z7 = readOnly;
        } else {
            if (i59 & 24576 == 0) {
                i52 = textFieldColors-dx8h9Zs.changed(readOnly) ? i57 : i44;
                $dirty2 |= i52;
            } else {
                z7 = readOnly;
            }
        }
        int i152 = 196608;
        i42 = 65536;
        i36 = 131072;
        if (i59 & i152 == 0) {
            if (i20 & 32 == 0) {
                changed = textFieldColors-dx8h9Zs.changed(textStyle) ? i36 : i42;
            } else {
                zeroCornerSize = textStyle;
            }
            $dirty2 |= changed;
        } else {
            zeroCornerSize = textStyle;
        }
        i21 = i20 & 64;
        final int i161 = 1572864;
        if (i21 != 0) {
            $dirty2 |= i161;
            rememberedValue = label;
        } else {
            if (i59 & i161 == 0) {
                i11 = textFieldColors-dx8h9Zs.changedInstance(label) ? 1048576 : 524288;
                $dirty2 |= i11;
            } else {
                rememberedValue = label;
            }
        }
        i22 = i20 & 128;
        final int i155 = 12582912;
        if (i22 != 0) {
            $dirty2 |= i155;
            obj6 = placeholder;
        } else {
            if (i59 & i155 == 0) {
                i30 = textFieldColors-dx8h9Zs.changedInstance(placeholder) ? 8388608 : 4194304;
                $dirty2 |= i30;
            } else {
                obj6 = placeholder;
            }
        }
        int i60 = i20 & 256;
        int i156 = 100663296;
        if (i60 != 0) {
            $dirty2 |= i156;
            i27 = i60;
            obj21 = leadingIcon;
        } else {
            if ($changed & i156 == 0) {
                i27 = i60;
                i24 = textFieldColors-dx8h9Zs.changedInstance(leadingIcon) ? 67108864 : 33554432;
                $dirty2 |= i24;
            } else {
                i27 = i60;
                obj21 = leadingIcon;
            }
        }
        int i61 = i20 & 512;
        int i158 = 805306368;
        if (i61 != 0) {
            $dirty2 |= i158;
            i6 = i61;
            obj = trailingIcon;
        } else {
            if ($changed & i158 == 0) {
                i6 = i61;
                i55 = textFieldColors-dx8h9Zs.changedInstance(trailingIcon) ? 536870912 : 268435456;
                $dirty2 |= i55;
            } else {
                i6 = i61;
                obj = trailingIcon;
            }
        }
        int i62 = i20 & 1024;
        if (i62 != 0) {
            $dirty15 |= 6;
            i28 = i62;
            z = isError;
        } else {
            if (i70 & 6 == 0) {
                i28 = i62;
                i43 = textFieldColors-dx8h9Zs.changed(isError) ? 4 : 2;
                $dirty15 |= i43;
            } else {
                i28 = i62;
                z = isError;
            }
        }
        int i63 = i20 & 2048;
        if (i63 != 0) {
            $dirty15 |= 48;
            i46 = i63;
            obj14 = visualTransformation;
        } else {
            if (i70 & 48 == 0) {
                i46 = i63;
                changed2 = textFieldColors-dx8h9Zs.changed(visualTransformation) ? 32 : 16;
                $dirty15 |= changed2;
            } else {
                i46 = i63;
                obj14 = visualTransformation;
            }
        }
        int i64 = i20 & 4096;
        if (i64 != 0) {
            $dirty15 |= 384;
            i51 = i64;
            obj2 = keyboardOptions;
        } else {
            i51 = i64;
            if (i70 & 384 == 0) {
                i11 = textFieldColors-dx8h9Zs.changed(keyboardOptions) ? 256 : 128;
                $dirty15 |= i11;
            } else {
                obj2 = keyboardOptions;
            }
        }
        if (i70 & 3072 == 0) {
            if (i20 & 8192 == 0) {
                if (textFieldColors-dx8h9Zs.changed(keyboardActions)) {
                } else {
                    i50 = changed6;
                }
            } else {
                obj8 = keyboardActions;
            }
            $dirty15 |= i50;
        } else {
            obj8 = keyboardActions;
        }
        int i67 = i20 & 16384;
        if (i67 != 0) {
            $dirty15 |= 24576;
            i39 = i67;
            z6 = singleLine;
        } else {
            i39 = i67;
            if (i70 & 24576 == 0) {
                if (textFieldColors-dx8h9Zs.changed(singleLine)) {
                } else {
                    i57 = i44;
                }
                $dirty15 |= i57;
            } else {
                z6 = singleLine;
            }
        }
        int i147 = i20 & i146;
        if (i147 != 0) {
            $dirty15 |= i152;
            i33 = maxLines;
        } else {
            if (i70 & i152 == 0) {
                i57 = textFieldColors-dx8h9Zs.changed(maxLines) ? i36 : i42;
                $dirty15 |= i57;
            } else {
                i33 = maxLines;
            }
        }
        i8 = i20 & i42;
        if (i8 != 0) {
            $dirty15 |= i161;
            obj20 = interactionSource;
        } else {
            if (i70 & i161 == 0) {
                i44 = textFieldColors-dx8h9Zs.changed(interactionSource) ? 1048576 : 524288;
                $dirty15 |= i44;
            } else {
                obj20 = interactionSource;
            }
        }
        if (i70 & i155 == 0) {
            if (i20 & i36 == 0) {
                i = textFieldColors-dx8h9Zs.changed(shape) ? 8388608 : 4194304;
            } else {
                obj3 = shape;
            }
            $dirty15 |= i;
        } else {
            obj3 = shape;
        }
        int i153 = 262144;
        if (i70 & i156 == 0) {
            if (i20 & i153 == 0) {
                obj90 = $dirty15;
                i40 = textFieldColors-dx8h9Zs.changed(colors) ? 67108864 : 33554432;
            } else {
                obj90 = $dirty15;
                $dirty1 = colors;
            }
            keyboardActions3 = i25;
        } else {
            $dirty1 = colors;
            keyboardActions3 = obj90;
        }
        obj90 = $dirty2;
        if ($dirty2 & i15 == 306783378 && i72 &= keyboardActions3 == 38347922) {
            if (i72 &= keyboardActions3 == 38347922) {
                if (!textFieldColors-dx8h9Zs.getSkipping()) {
                    textFieldColors-dx8h9Zs.startDefaults();
                    if ($changed & 1 != 0) {
                        if (textFieldColors-dx8h9Zs.getDefaultsInvalid()) {
                            if (consume != 0) {
                                modifier4 = Modifier.Companion;
                            } else {
                                modifier4 = str;
                            }
                            z2 = i144 != 0 ? $dirty : invalid$iv;
                            z4 = i148 != 0 ? $dirty : z7;
                            if (i20 & 32 != 0) {
                                int i130 = 6;
                                z7 = 0;
                                ComposerKt.sourceInformationMarkerStart(textFieldColors-dx8h9Zs, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                ComposerKt.sourceInformationMarkerEnd(textFieldColors-dx8h9Zs);
                                obj15 = this_$iv;
                                i7 = invalid$iv;
                            } else {
                                i7 = obj90;
                                obj15 = zeroCornerSize;
                            }
                            obj16 = i21 != 0 ? this_$iv : rememberedValue;
                            obj4 = i22 != 0 ? this_$iv : obj6;
                            i35 = i27 != 0 ? this_$iv : leadingIcon;
                            i31 = i6 != 0 ? this_$iv : trailingIcon;
                            i10 = i28 != 0 ? this_$iv : isError;
                            if (i46 != 0) {
                                obj19 = this_$iv;
                            } else {
                                obj19 = visualTransformation;
                            }
                            if (i51 != 0) {
                                keyboardOptions2 = this_$iv;
                            } else {
                                keyboardOptions2 = keyboardOptions;
                            }
                            if (i20 & 8192 != 0) {
                                super(0, 0, 0, 0, 0, 0, 63, 0);
                                $dirty14 = $dirty16;
                                $dirty12 = keyboardActions5;
                            } else {
                                $dirty14 = keyboardActions3;
                                $dirty12 = keyboardActions;
                            }
                            i19 = i39 != 0 ? invalid$iv : singleLine;
                            i32 = i147 != 0 ? invalid$iv : maxLines;
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(textFieldColors-dx8h9Zs, -53943058, "CC(remember):TextField.kt#9igjgp");
                                int i129 = 0;
                                z7 = textFieldColors-dx8h9Zs;
                                zeroCornerSize = 0;
                                rememberedValue = z7.rememberedValue();
                                consume = 0;
                                if (rememberedValue == Composer.Companion.getEmpty()) {
                                    int i141 = 0;
                                    z7.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                                } else {
                                    i22 = rememberedValue;
                                }
                                ComposerKt.sourceInformationMarkerEnd(textFieldColors-dx8h9Zs);
                                obj7 = invalid$iv;
                            } else {
                                obj7 = interactionSource;
                            }
                            if (i20 & i36 != 0) {
                                obj9 = copy$default;
                                i9 = $dirty14;
                            } else {
                                obj9 = shape;
                                i9 = $dirty14;
                            }
                            if (i20 & i153 != 0) {
                                keyboardActions4 = $dirty12;
                                obj11 = modifier4;
                                obj5 = textFieldColors-dx8h9Zs;
                                keyboardActions3 = $dirty13;
                                invalid$iv = z2;
                                z7 = z4;
                                obj13 = obj15;
                                modifier3 = i7;
                                obj18 = obj16;
                                obj10 = obj4;
                                i5 = i35;
                                i54 = i31;
                                i26 = i10;
                                visualTransformation2 = obj19;
                                keyboardOptions4 = keyboardOptions2;
                                i13 = i19;
                                i2 = i32;
                                i15 = obj7;
                                i46 = obj9;
                            } else {
                                $composer2 = textFieldColors-dx8h9Zs;
                                obj5 = colors;
                                keyboardActions4 = $dirty12;
                                obj11 = modifier4;
                                invalid$iv = z2;
                                z7 = z4;
                                obj13 = obj15;
                                modifier3 = i7;
                                obj18 = obj16;
                                obj10 = obj4;
                                i5 = i35;
                                i54 = i31;
                                i26 = i10;
                                visualTransformation2 = obj19;
                                keyboardOptions4 = keyboardOptions2;
                                i13 = i19;
                                i2 = i32;
                                i15 = obj7;
                                i46 = obj9;
                                keyboardActions3 = i9;
                            }
                        } else {
                            textFieldColors-dx8h9Zs.skipToGroupEnd();
                            $dirty13 = i20 & 32 != 0 ? obj90 & i48 : obj90;
                            if (i20 & 8192 != 0) {
                                keyboardActions3 &= -7169;
                            }
                            if (i20 & i36 != 0) {
                                keyboardActions3 &= i53;
                            }
                            if (i20 & i153 != 0) {
                                keyboardActions3 &= i49;
                            }
                            i5 = leadingIcon;
                            i54 = trailingIcon;
                            keyboardOptions4 = keyboardOptions;
                            keyboardActions4 = keyboardActions;
                            i13 = singleLine;
                            i2 = maxLines;
                            i15 = interactionSource;
                            i46 = shape;
                            $composer2 = textFieldColors-dx8h9Zs;
                            modifier3 = $dirty13;
                            obj5 = $dirty1;
                            obj13 = zeroCornerSize;
                            obj18 = rememberedValue;
                            obj10 = obj6;
                            obj11 = str;
                            i26 = isError;
                            visualTransformation2 = visualTransformation;
                        }
                    } else {
                    }
                    $composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1690895095, modifier3, keyboardActions3, "androidx.compose.material.TextField (TextField.kt:258)");
                    }
                    TextFieldKt.TextField(value, onValueChange, obj11, invalid$iv, z7, obj13, obj18, obj10, i5, i54, i26, visualTransformation2, keyboardOptions4, keyboardActions4, i13, i2, 1, i15, i46, obj5, $composer2, i82 | i106, i91 | i119, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i47 = modifier3;
                    $composer3 = obj11;
                    z3 = invalid$iv;
                    z5 = z7;
                    modifier2 = obj13;
                    enabled2 = obj18;
                    readOnly2 = obj10;
                    textStyle2 = i5;
                    label2 = i54;
                    placeholder2 = i26;
                    leadingIcon2 = visualTransformation2;
                    trailingIcon2 = keyboardOptions4;
                    isError2 = keyboardActions4;
                    visualTransformation3 = i13;
                    keyboardOptions3 = i2;
                    keyboardActions2 = i15;
                    singleLine2 = i46;
                    maxLines2 = obj5;
                    colors2 = keyboardActions3;
                } else {
                    textFieldColors-dx8h9Zs.skipToGroupEnd();
                    textStyle2 = leadingIcon;
                    leadingIcon2 = visualTransformation;
                    trailingIcon2 = keyboardOptions;
                    keyboardOptions3 = maxLines;
                    keyboardActions2 = interactionSource;
                    singleLine2 = shape;
                    i47 = obj90;
                    $composer2 = textFieldColors-dx8h9Zs;
                    maxLines2 = $dirty1;
                    z3 = invalid$iv;
                    z5 = z7;
                    modifier2 = zeroCornerSize;
                    enabled2 = rememberedValue;
                    readOnly2 = obj6;
                    $composer3 = str;
                    label2 = trailingIcon;
                    placeholder2 = isError;
                    isError2 = keyboardActions;
                    visualTransformation3 = singleLine;
                    colors2 = keyboardActions3;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new TextFieldKt.TextField.4(value, onValueChange, $composer3, z3, z5, modifier2, enabled2, readOnly2, textStyle2, label2, placeholder2, leadingIcon2, trailingIcon2, isError2, visualTransformation3, keyboardOptions3, keyboardActions2, singleLine2, maxLines2, $changed, $changed1, i20);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    public static final void TextFieldLayout(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> textField, Function2<? super Composer, ? super Integer, Unit> label, Function3<? super Modifier, ? super Composer, ? super Integer, Unit> placeholder, Function2<? super Composer, ? super Integer, Unit> leading, Function2<? super Composer, ? super Integer, Unit> trailing, boolean singleLine, float animationProgress, PaddingValues paddingValues, Composer $composer, int $changed) {
        int i4;
        Object textFieldMeasurePolicy;
        Integer layoutDirection2;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv2;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap5;
        Object empty;
        boolean traceInProgress;
        kotlin.jvm.functions.Function0 factory$iv$iv;
        Object obj3;
        Integer valueOf3;
        Integer valueOf;
        String materialized$iv$iv2;
        int valueOf4;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv;
        Object obj;
        Object valueOf2;
        Composer composer8;
        Object obj4;
        Object maybeCachedBoxMeasurePolicy3;
        Composer composer2;
        Object $composer$iv;
        int endPadding;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv4;
        boolean currentCompositionLocalMap2;
        Object maybeCachedBoxMeasurePolicy2;
        Object materialized$iv$iv;
        androidx.compose.ui.Modifier.Companion $this$coerceAtLeast_u2dYgX7TsA$iv;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv3;
        Modifier padding-qDBjuR0$default;
        BoxScopeInstance iNSTANCE;
        Composer i22;
        boolean valueOf5;
        Composer $this$dp$iv;
        int then;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap4;
        int restartGroup;
        int $dirty;
        Composer composer7;
        int i10;
        int i23;
        int i24;
        int i21;
        int i3;
        int i12;
        int i6;
        int i32;
        int i16;
        int skipping;
        boolean traceInProgress2;
        int i8;
        int i25;
        Modifier materializeModifier;
        Composer composer4;
        Integer valueOf6;
        Object currentCompositionLocalMap3;
        Object maybeCachedBoxMeasurePolicy;
        Composer composer;
        int currentCompositeKeyHash;
        int currentCompositionLocalMap;
        Object obj2;
        int i19;
        Composer.Companion companion2;
        int invalid$iv;
        int currentCompositeKeyHash3;
        int i13;
        int i26;
        kotlin.jvm.functions.Function0 function02;
        int i11;
        Composer composer9;
        int i5;
        Object layoutDirection;
        Composer composer5;
        int i27;
        int i28;
        Modifier modifier3;
        int i29;
        int i30;
        int i15;
        int i2;
        int i9;
        int i14;
        androidx.compose.runtime.CompositionLocalMap map;
        int currentCompositeKeyHash2;
        int companion;
        int i31;
        float f;
        Alignment alignment;
        int currentCompositeKeyHash4;
        int $changed$iv;
        float f2;
        int i;
        int i20;
        Modifier modifier2;
        kotlin.jvm.functions.Function0 function0;
        int i17;
        int i7;
        Composer composer6;
        int localMap$iv$iv3;
        int localMap$iv$iv;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv2;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy;
        Composer composer3;
        int i18;
        Alignment obj63;
        Object obj5 = modifier;
        obj = textField;
        valueOf2 = label;
        obj4 = placeholder;
        $composer$iv = leading;
        maybeCachedBoxMeasurePolicy2 = trailing;
        padding-qDBjuR0$default = singleLine;
        iNSTANCE = animationProgress;
        final Object obj6 = paddingValues;
        i22 = $changed;
        traceInProgress = -2112507061;
        restartGroup = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(TextFieldLayout)P(3,7,1,5,2,8,6)489@22578L139,492@22765L7,493@22777L1853:TextField.kt#jmzs0o");
        if (i22 & 6 == 0) {
            i10 = restartGroup.changed(obj5) ? 4 : 2;
            $dirty |= i10;
        }
        if (i22 & 48 == 0) {
            i23 = restartGroup.changedInstance(obj) ? 32 : 16;
            $dirty |= i23;
        }
        if (i22 & 384 == 0) {
            i24 = restartGroup.changedInstance(valueOf2) ? 256 : 128;
            $dirty |= i24;
        }
        if (i22 & 3072 == 0) {
            i21 = restartGroup.changedInstance(obj4) ? 2048 : 1024;
            $dirty |= i21;
        }
        if (i22 & 24576 == 0) {
            i3 = restartGroup.changedInstance($composer$iv) ? 16384 : 8192;
            $dirty |= i3;
        }
        if (i88 &= i22 == 0) {
            i12 = restartGroup.changedInstance(maybeCachedBoxMeasurePolicy2) ? 131072 : 65536;
            $dirty |= i12;
        }
        currentCompositeKeyHash = 1048576;
        if (i89 &= i22 == 0) {
            i6 = restartGroup.changed(padding-qDBjuR0$default) ? currentCompositeKeyHash : 524288;
            $dirty |= i6;
        }
        if (i90 &= i22 == 0) {
            i32 = restartGroup.changed(iNSTANCE) ? 8388608 : 4194304;
            $dirty |= i32;
        }
        if (i91 &= i22 == 0) {
            i16 = restartGroup.changed(obj6) ? 67108864 : 33554432;
            $dirty |= i16;
        }
        if (i92 &= $dirty == 38347922) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty, -1, "androidx.compose.material.TextFieldLayout (TextField.kt:488)");
                }
                ComposerKt.sourceInformationMarkerStart(restartGroup, -73227460, "CC(remember):TextField.kt#9igjgp");
                i4 = i34 &= $dirty == currentCompositeKeyHash ? 1 : 0;
                int i118 = 1;
                i8 = i106 &= $dirty == 8388608 ? i118 : 0;
                i25 = i94 &= $dirty == 67108864 ? i118 : 0;
                i36 |= i25;
                Composer composer12 = restartGroup;
                int i109 = 0;
                Object rememberedValue6 = composer12.rememberedValue();
                int i117 = 0;
                if (empty == 0) {
                    invalid$iv = empty;
                    if (rememberedValue6 == Composer.Companion.getEmpty()) {
                        companion2 = invalid$iv2;
                        textFieldMeasurePolicy = new TextFieldMeasurePolicy(padding-qDBjuR0$default, iNSTANCE, obj6);
                        composer12.updateRememberedValue(textFieldMeasurePolicy);
                    } else {
                        textFieldMeasurePolicy = rememberedValue6;
                    }
                } else {
                    invalid$iv = empty;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                int i110 = 0;
                int i116 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume = restartGroup.consume((CompositionLocal)CompositionLocalsKt.getLocalLayoutDirection());
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                materializeModifier = 0;
                String str16 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, str16);
                currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, 0);
                currentCompositionLocalMap3 = restartGroup.getCurrentCompositionLocalMap();
                materialized$iv$iv = ComposedModifierKt.materializeModifier(restartGroup, obj5);
                kotlin.jvm.functions.Function0 function03 = constructor2;
                i26 = 0;
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
                int i120 = 0;
                composer5 = restartGroup;
                Updater.set-impl(constructor-impl, (MeasurePolicy)(TextFieldMeasurePolicy)textFieldMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                valueOf5 = 0;
                Composer composer13 = constructor-impl;
                int i122 = 0;
                if (!composer13.getInserting()) {
                    i28 = valueOf5;
                    i29 = $dirty;
                    if (!Intrinsics.areEqual(composer13.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                        composer13.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer7 = composer13;
                    }
                } else {
                    i28 = valueOf5;
                    i29 = $dirty;
                }
                Updater.set-impl(constructor-impl, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                i22 = composer5;
                $this$dp$iv = 0;
                i5 = i52;
                ComposerKt.sourceInformationMarkerStart(i22, 69567154, "C535@24392L183:TextField.kt#jmzs0o");
                String str12 = "C73@3429L9:Box.kt#2w3rfo";
                int i121 = 48;
                String str = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo";
                modifier3 = materialized$iv$iv;
                if ($composer$iv != null) {
                    i22.startReplaceGroup(69542167);
                    ComposerKt.sourceInformation(i22, "497@22885L219");
                    i15 = $this$dp$iv;
                    Modifier then4 = LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Leading").then(TextFieldImplKt.getIconDefaultSizeModifier());
                    Alignment center2 = Alignment.Companion.getCenter();
                    i2 = i121;
                    i9 = 0;
                    i14 = materializeModifier;
                    ComposerKt.sourceInformationMarkerStart(i22, 733328855, str);
                    int i105 = 0;
                    map = currentCompositionLocalMap3;
                    maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center2, i105);
                    i31 = 0;
                    alignment = center2;
                    ComposerKt.sourceInformationMarkerStart(i22, -1323940314, str16);
                    $changed$iv = ComposablesKt.getCurrentCompositeKeyHash(i22, 0);
                    currentCompositionLocalMap4 = i22.getCurrentCompositionLocalMap();
                    i = i105;
                    modifier2 = then4;
                    kotlin.jvm.functions.Function0 function07 = constructor5;
                    i20 = 0;
                    ComposerKt.sourceInformationMarkerStart(i22, -692256719, str7);
                    if (!applier5 instanceof Applier) {
                        ComposablesKt.invalidApplier();
                    }
                    i22.startReusableNode();
                    if (i22.getInserting()) {
                        i22.createNode(function07);
                    } else {
                        factory$iv$iv$iv3 = function07;
                        i22.useNode();
                    }
                    function0 = factory$iv$iv$iv3;
                    Composer constructor-impl4 = Updater.constructor-impl(i22);
                    int i137 = 0;
                    Updater.set-impl(constructor-impl4, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl4, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    int i141 = 0;
                    Composer composer17 = constructor-impl4;
                    int i143 = 0;
                    if (!composer17.getInserting()) {
                        localMap$iv$iv2 = currentCompositionLocalMap4;
                        measurePolicy = maybeCachedBoxMeasurePolicy;
                        if (!Intrinsics.areEqual(composer17.rememberedValue(), Integer.valueOf($changed$iv))) {
                            composer17.updateRememberedValue(Integer.valueOf($changed$iv));
                            constructor-impl4.apply(Integer.valueOf($changed$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer = composer17;
                        }
                    } else {
                        localMap$iv$iv2 = currentCompositionLocalMap4;
                        measurePolicy = maybeCachedBoxMeasurePolicy;
                    }
                    Updater.set-impl(constructor-impl4, ComposedModifierKt.materializeModifier(i22, then4), ComposeUiNode.Companion.getSetModifier());
                    Composer composer11 = i22;
                    ComposerKt.sourceInformationMarkerStart(composer11, -2146769399, str12);
                    currentCompositionLocalMap3 = BoxScopeInstance.INSTANCE;
                    i139 |= 6;
                    localMap$iv$iv3 = 0;
                    localMap$iv$iv = i61;
                    i18 = i84;
                    $this$dp$iv = composer6;
                    ComposerKt.sourceInformationMarkerStart($this$dp$iv, -1924262037, "C501@23077L9:TextField.kt#jmzs0o");
                    $composer$iv.invoke($this$dp$iv, Integer.valueOf(i62 &= 14));
                    ComposerKt.sourceInformationMarkerEnd($this$dp$iv);
                    ComposerKt.sourceInformationMarkerEnd(composer11);
                    i22.endNode();
                    ComposerKt.sourceInformationMarkerEnd(i22);
                    ComposerKt.sourceInformationMarkerEnd(i22);
                    ComposerKt.sourceInformationMarkerEnd(i22);
                    i22.endReplaceGroup();
                } else {
                    i15 = $this$dp$iv;
                    i14 = materializeModifier;
                    map = currentCompositionLocalMap3;
                    i22.startReplaceGroup(69783378);
                    i22.endReplaceGroup();
                }
                if (maybeCachedBoxMeasurePolicy2 != null) {
                    i22.startReplaceGroup(69825941);
                    ComposerKt.sourceInformation(i22, "505@23171L221");
                    Modifier then3 = LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Trailing").then(TextFieldImplKt.getIconDefaultSizeModifier());
                    Alignment center = Alignment.Companion.getCenter();
                    ComposerKt.sourceInformationMarkerStart(i22, 733328855, str);
                    valueOf6 = 0;
                    i9 = 0;
                    ComposerKt.sourceInformationMarkerStart(i22, -1323940314, str16);
                    currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(i22, 0);
                    currentCompositionLocalMap2 = i22.getCurrentCompositionLocalMap();
                    i31 = center;
                    Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(i22, then3);
                    $changed$iv = then3;
                    kotlin.jvm.functions.Function0 function05 = constructor3;
                    alignment = 0;
                    ComposerKt.sourceInformationMarkerStart(i22, -692256719, str7);
                    if (!applier3 instanceof Applier) {
                        ComposablesKt.invalidApplier();
                    }
                    i22.startReusableNode();
                    if (i22.getInserting()) {
                        i22.createNode(function05);
                    } else {
                        factory$iv$iv$iv = function05;
                        i22.useNode();
                    }
                    i = factory$iv$iv$iv;
                    Composer constructor-impl2 = Updater.constructor-impl(i22);
                    int i129 = 0;
                    i17 = i82;
                    Updater.set-impl(constructor-impl2, BoxKt.maybeCachedBoxMeasurePolicy(center, valueOf6), ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    int i132 = 0;
                    Composer composer15 = constructor-impl2;
                    int i140 = 0;
                    if (!composer15.getInserting()) {
                        localMap$iv$iv3 = currentCompositionLocalMap2;
                        localMap$iv$iv = valueOf6;
                        if (!Intrinsics.areEqual(composer15.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                            composer15.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                            constructor-impl2.apply(Integer.valueOf(currentCompositeKeyHash2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer4 = composer15;
                        }
                    } else {
                        localMap$iv$iv3 = currentCompositionLocalMap2;
                        localMap$iv$iv = valueOf6;
                    }
                    Updater.set-impl(constructor-impl2, materializeModifier4, ComposeUiNode.Companion.getSetModifier());
                    Composer composer10 = i22;
                    $this$dp$iv = 0;
                    ComposerKt.sourceInformationMarkerStart(composer10, -2146769399, str12);
                    materializeModifier = BoxScopeInstance.INSTANCE;
                    i131 |= 6;
                    i7 = 0;
                    composer6 = i57;
                    measurePolicy = materializeModifier4;
                    materialized$iv$iv = function0;
                    ComposerKt.sourceInformationMarkerStart(materialized$iv$iv, -1923977302, "C509@23364L10:TextField.kt#jmzs0o");
                    maybeCachedBoxMeasurePolicy2.invoke(materialized$iv$iv, Integer.valueOf(i58 &= 14));
                    ComposerKt.sourceInformationMarkerEnd(materialized$iv$iv);
                    ComposerKt.sourceInformationMarkerEnd(composer10);
                    i22.endNode();
                    ComposerKt.sourceInformationMarkerEnd(i22);
                    ComposerKt.sourceInformationMarkerEnd(i22);
                    ComposerKt.sourceInformationMarkerEnd(i22);
                    i22.endReplaceGroup();
                } else {
                    i22.startReplaceGroup(70069074);
                    i22.endReplaceGroup();
                }
                materialized$iv$iv2 = PaddingKt.calculateStartPadding(obj6, (LayoutDirection)consume);
                endPadding = PaddingKt.calculateEndPadding(obj6, consume);
                if (leading != null) {
                    int i80 = 0;
                    int i102 = 0;
                    materializeModifier = 0;
                    f = $this$coerceAtLeast_u2dYgX7TsA$iv;
                } else {
                    f = materialized$iv$iv2;
                }
                if (maybeCachedBoxMeasurePolicy2 != null) {
                    int i78 = 0;
                    int i100 = 0;
                    materializeModifier = 0;
                    f2 = $this$coerceAtLeast_u2dYgX7TsA$iv;
                } else {
                    f2 = endPadding;
                }
                padding-qDBjuR0$default = PaddingKt.padding-qDBjuR0$default((Modifier)Modifier.Companion, f, 0, f2, 0, 10, 0);
                if (obj4 != null) {
                    i22.startReplaceGroup(70826807);
                    ComposerKt.sourceInformation(i22, "530@24185L59");
                    obj4.invoke(LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Hint").then(padding-qDBjuR0$default), i22, Integer.valueOf(i96 &= 112));
                    i22.endReplaceGroup();
                } else {
                    i22.startReplaceGroup(70914258);
                    i22.endReplaceGroup();
                }
                if (valueOf2 != null) {
                    i22.startReplaceGroup(70948761);
                    ComposerKt.sourceInformation(i22, "533@24308L57");
                    materializeModifier = 0;
                    currentCompositionLocalMap3 = 0;
                    layoutDirection = consume;
                    ComposerKt.sourceInformationMarkerStart(i22, 733328855, str);
                    Alignment topStart = Alignment.Companion.getTopStart();
                    i2 = materialized$iv$iv2;
                    int startTextFieldPadding = 0;
                    maybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(topStart, startTextFieldPadding);
                    companion = 0;
                    f = topStart;
                    ComposerKt.sourceInformationMarkerStart(i22, -1323940314, str16);
                    currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(i22, 0);
                    currentCompositionLocalMap5 = i22.getCurrentCompositionLocalMap();
                    f2 = startTextFieldPadding;
                    Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(i22, LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Label").then(padding-qDBjuR0$default));
                    i20 = endPadding;
                    kotlin.jvm.functions.Function0 function06 = constructor4;
                    i = 0;
                    ComposerKt.sourceInformationMarkerStart(i22, -692256719, str7);
                    if (!applier4 instanceof Applier) {
                        ComposablesKt.invalidApplier();
                    }
                    i22.startReusableNode();
                    if (i22.getInserting()) {
                        i22.createNode(function06);
                    } else {
                        factory$iv$iv$iv4 = function06;
                        i22.useNode();
                    }
                    modifier2 = factory$iv$iv$iv4;
                    Composer constructor-impl3 = Updater.constructor-impl(i22);
                    int i133 = 0;
                    Updater.set-impl(constructor-impl3, maybeCachedBoxMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl3, currentCompositionLocalMap5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    int i136 = 0;
                    Composer composer16 = constructor-impl3;
                    int i142 = 0;
                    if (!composer16.getInserting()) {
                        localMap$iv$iv = currentCompositionLocalMap5;
                        localMap$iv$iv2 = maybeCachedBoxMeasurePolicy3;
                        if (!Intrinsics.areEqual(composer16.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                            composer16.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                            constructor-impl3.apply(Integer.valueOf(currentCompositeKeyHash4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer2 = composer16;
                        }
                    } else {
                        localMap$iv$iv = currentCompositionLocalMap5;
                        localMap$iv$iv2 = maybeCachedBoxMeasurePolicy3;
                    }
                    Updater.set-impl(constructor-impl3, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                    obj4 = i22;
                    endPadding = 0;
                    ComposerKt.sourceInformationMarkerStart(obj4, -2146769399, str12);
                    maybeCachedBoxMeasurePolicy2 = BoxScopeInstance.INSTANCE;
                    i135 |= 6;
                    i7 = obj4;
                    composer6 = 0;
                    localMap$iv$iv3 = i45;
                    measurePolicy = materializeModifier3;
                    ComposerKt.sourceInformationMarkerStart(obj4, -1922993331, "C533@24356L7:TextField.kt#jmzs0o");
                    valueOf2.invoke(obj4, Integer.valueOf(i46 &= 14));
                    ComposerKt.sourceInformationMarkerEnd(obj4);
                    ComposerKt.sourceInformationMarkerEnd(obj4);
                    i22.endNode();
                    ComposerKt.sourceInformationMarkerEnd(i22);
                    ComposerKt.sourceInformationMarkerEnd(i22);
                    ComposerKt.sourceInformationMarkerEnd(i22);
                    i22.endReplaceGroup();
                } else {
                    layoutDirection = consume;
                    i2 = materialized$iv$iv2;
                    i20 = endPadding;
                    i22.startReplaceGroup(71034290);
                    i22.endReplaceGroup();
                }
                Modifier then2 = LayoutIdKt.layoutId((Modifier)Modifier.Companion, "TextField").then(padding-qDBjuR0$default);
                valueOf4 = 384;
                $composer$iv = 0;
                ComposerKt.sourceInformationMarkerStart(i22, 733328855, str);
                Alignment topStart2 = Alignment.Companion.getTopStart();
                skipping = 0;
                ComposerKt.sourceInformationMarkerStart(i22, -1323940314, str16);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(i22, 0);
                obj63 = topStart2;
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(i22, then2);
                companion2 = then2;
                kotlin.jvm.functions.Function0 function04 = constructor;
                i19 = 0;
                ComposerKt.sourceInformationMarkerStart(i22, -692256719, str7);
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                i22.startReusableNode();
                if (i22.getInserting()) {
                    i22.createNode(function04);
                } else {
                    factory$iv$iv$iv2 = function04;
                    i22.useNode();
                }
                Composer constructor-impl5 = Updater.constructor-impl(i22);
                int i119 = 0;
                currentCompositeKeyHash2 = factory$iv$iv$iv2;
                Updater.set-impl(constructor-impl5, BoxKt.maybeCachedBoxMeasurePolicy(topStart2, i118), ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl5, i22.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i123 = 0;
                Composer composer14 = constructor-impl5;
                int i127 = 0;
                if (!composer14.getInserting()) {
                    $changed$iv = valueOf4;
                    if (!Intrinsics.areEqual(composer14.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer14.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl5.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer8 = composer14;
                    }
                } else {
                    $changed$iv = valueOf4;
                }
                Updater.set-impl(constructor-impl5, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                obj = i22;
                valueOf2 = 0;
                ComposerKt.sourceInformationMarkerStart(obj, -2146769399, str12);
                iNSTANCE = BoxScopeInstance.INSTANCE;
                i87 |= 6;
                composer9 = obj;
                i27 = 0;
                i30 = i40;
                i31 = materializeModifier2;
                ComposerKt.sourceInformationMarkerStart(obj, -1922800759, "C539@24550L11:TextField.kt#jmzs0o");
                textField.invoke(obj, Integer.valueOf(i41 &= 14));
                ComposerKt.sourceInformationMarkerEnd(obj);
                ComposerKt.sourceInformationMarkerEnd(obj);
                i22.endNode();
                ComposerKt.sourceInformationMarkerEnd(i22);
                ComposerKt.sourceInformationMarkerEnd(i22);
                ComposerKt.sourceInformationMarkerEnd(i22);
                ComposerKt.sourceInformationMarkerEnd(i22);
                composer5.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer5);
                ComposerKt.sourceInformationMarkerEnd(composer5);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
                obj3 = obj;
                composer5 = restartGroup;
                i29 = $dirty;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer5.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new TextFieldKt.TextFieldLayout.2(modifier, obj3, label, placeholder, leading, trailing, singleLine, animationProgress, obj6, $changed);
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
        int i11;
        int align2;
        int i8;
        int i5;
        int i10;
        Placeable.PlacementScope placementScope;
        Placeable.PlacementScope placementScope2;
        Placeable placeable2;
        Placeable placeable;
        int widthOrZero2;
        int widthOrZero;
        int align;
        int i7;
        int i3;
        int i2;
        int i;
        int i6;
        int i4;
        int i9;
        final int i12 = height;
        if (leadingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, leadingPlaceable, 0, Alignment.Companion.getCenterVertically().align(leadingPlaceable.getHeight(), i12), 0, 4, 0);
        }
        if (trailingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, trailingPlaceable, width - width2, Alignment.Companion.getCenterVertically().align(trailingPlaceable.getHeight(), i12), 0, 4, 0);
        }
        if (labelPlaceable != null) {
            placeable2 = labelPlaceable;
            centerVertically = 0;
            if (singleLine) {
                roundToInt2 = Alignment.Companion.getCenterVertically().align(placeable2.getHeight(), i12);
            } else {
                roundToInt2 = MathKt.roundToInt(textFieldPadding *= density);
            }
            Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, placeable2, TextFieldImplKt.widthOrZero(leadingPlaceable), roundToInt2 - roundToInt, 0, 4, 0);
        }
        Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, textfieldPlaceable, TextFieldImplKt.widthOrZero(leadingPlaceable), textPosition, 0, 4, 0);
        if (placeholderPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, placeholderPlaceable, TextFieldImplKt.widthOrZero(leadingPlaceable), textPosition, 0, 4, 0);
        }
    }

    private static final void placeWithoutLabel(Placeable.PlacementScope $this$placeWithoutLabel, int width, int height, Placeable textPlaceable, Placeable placeholderPlaceable, Placeable leadingPlaceable, Placeable trailingPlaceable, boolean singleLine, float density, PaddingValues paddingValues) {
        Alignment.Vertical centerVertically;
        int height3;
        Placeable.PlacementScope align3;
        Placeable height2;
        int i6;
        int align;
        int i10;
        int i;
        int i2;
        Placeable.PlacementScope placementScope;
        Placeable.PlacementScope placementScope2;
        Placeable placeable2;
        Placeable placeable;
        int i4;
        int widthOrZero;
        int align2;
        int i11;
        int i5;
        int i8;
        int i7;
        int i9;
        int i12;
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
            i11 = centerVertically;
        } else {
            i11 = roundToInt;
        }
        Placeable.PlacementScope.placeRelative$default($this$placeWithoutLabel, textPlaceable, TextFieldImplKt.widthOrZero(leadingPlaceable), i11, 0, 4, 0);
        int i15 = i11;
        if (placeholderPlaceable != null) {
            height3 = 0;
            if (singleLine) {
                i11 = align3;
            } else {
                i11 = roundToInt;
            }
            Placeable.PlacementScope.placeRelative$default($this$placeWithoutLabel, placeholderPlaceable, TextFieldImplKt.widthOrZero(leadingPlaceable), i11, 0, 4, 0);
        }
    }

    private static final int substractConstraintSafely(int $this$substractConstraintSafely, int from) {
        if ($this$substractConstraintSafely == Integer.MAX_VALUE) {
            return $this$substractConstraintSafely;
        }
        return $this$substractConstraintSafely - from;
    }
}
