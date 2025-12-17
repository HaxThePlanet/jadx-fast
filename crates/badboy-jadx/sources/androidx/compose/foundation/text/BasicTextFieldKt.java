package androidx.compose.foundation.text;

import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.HoverInteractionKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.KeyboardActionHandler;
import androidx.compose.foundation.text.input.OutputTransformation;
import androidx.compose.foundation.text.input.TextFieldDecorator;
import androidx.compose.foundation.text.input.TextFieldLineLimits;
import androidx.compose.foundation.text.input.TextFieldLineLimits.Companion;
import androidx.compose.foundation.text.input.TextFieldLineLimits.SingleLine;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.internal.CodepointTransformation;
import androidx.compose.foundation.text.input.internal.SingleLineCodepointTransformation;
import androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifier;
import androidx.compose.foundation.text.input.internal.TextLayoutState;
import androidx.compose.foundation.text.input.internal.TransformedTextFieldState;
import androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.InputType;
import androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Alignment.Companion;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.input.pointer.PointerIconKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode.Companion;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.WindowInfo;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyle.Companion;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.input.VisualTransformation.Companion;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000Ê\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u001aÛ\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000c2\n\u0008\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00132\n\u0008\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u001728\u0008\u0002\u0010\u0018\u001a2\u0012\u0004\u0012\u00020\u001a\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001b¢\u0006\u000c\u0008\u001d\u0012\u0008\u0008\u001e\u0012\u0004\u0008\u0008(\u001f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0019¢\u0006\u0002\u0008 2\n\u0008\u0002\u0010!\u001a\u0004\u0018\u00010\"2\u0008\u0008\u0002\u0010#\u001a\u00020$2\n\u0008\u0002\u0010%\u001a\u0004\u0018\u00010&2\n\u0008\u0002\u0010'\u001a\u0004\u0018\u00010\u00012\u0008\u0008\u0002\u0010(\u001a\u00020)H\u0007¢\u0006\u0002\u0010*\u001añ\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000c2\n\u0008\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00132\n\u0008\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u001728\u0008\u0002\u0010\u0018\u001a2\u0012\u0004\u0012\u00020\u001a\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001b¢\u0006\u000c\u0008\u001d\u0012\u0008\u0008\u001e\u0012\u0004\u0008\u0008(\u001f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0019¢\u0006\u0002\u0008 2\n\u0008\u0002\u0010!\u001a\u0004\u0018\u00010\"2\u0008\u0008\u0002\u0010#\u001a\u00020$2\n\u0008\u0002\u0010+\u001a\u0004\u0018\u00010,2\n\u0008\u0002\u0010%\u001a\u0004\u0018\u00010&2\n\u0008\u0002\u0010'\u001a\u0004\u0018\u00010\u00012\u0008\u0008\u0002\u0010(\u001a\u00020)2\u0008\u0008\u0002\u0010-\u001a\u00020\u000cH\u0001¢\u0006\u0002\u0010.\u001aâ\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010/\u001a\u0002002\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u0006022\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00132\u0008\u0008\u0002\u00103\u001a\u0002042\u0008\u0008\u0002\u00105\u001a\u00020\u000c2\u0008\u0008\u0002\u00106\u001a\u0002072\u0008\u0008\u0002\u00108\u001a\u0002092\u0014\u0008\u0002\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u0006022\u0008\u0008\u0002\u0010!\u001a\u00020\"2\u0008\u0008\u0002\u0010#\u001a\u00020$23\u0008\u0002\u0010:\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00060\u001b¢\u0006\u0002\u0008;¢\u0006\u000c\u0008\u001d\u0012\u0008\u0008\u001e\u0012\u0004\u0008\u0008(<\u0012\u0004\u0012\u00020\u000602¢\u0006\u0002\u0008;H\u0007¢\u0006\u0002\u0010=\u001aî\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010/\u001a\u0002002\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u0006022\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00132\u0008\u0008\u0002\u00103\u001a\u0002042\u0008\u0008\u0002\u00105\u001a\u00020\u000c2\u0008\u0008\u0002\u00106\u001a\u0002072\u0008\u0008\u0002\u0010>\u001a\u0002072\u0008\u0008\u0002\u00108\u001a\u0002092\u0014\u0008\u0002\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u0006022\n\u0008\u0002\u0010!\u001a\u0004\u0018\u00010\"2\u0008\u0008\u0002\u0010#\u001a\u00020$23\u0008\u0002\u0010:\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00060\u001b¢\u0006\u0002\u0008;¢\u0006\u000c\u0008\u001d\u0012\u0008\u0008\u001e\u0012\u0004\u0008\u0008(<\u0012\u0004\u0012\u00020\u000602¢\u0006\u0002\u0008;H\u0007¢\u0006\u0002\u0010?\u001aâ\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010/\u001a\u00020@2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020\u0006022\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00132\u0008\u0008\u0002\u00103\u001a\u0002042\u0008\u0008\u0002\u00105\u001a\u00020\u000c2\u0008\u0008\u0002\u00106\u001a\u0002072\u0008\u0008\u0002\u00108\u001a\u0002092\u0014\u0008\u0002\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u0006022\u0008\u0008\u0002\u0010!\u001a\u00020\"2\u0008\u0008\u0002\u0010#\u001a\u00020$23\u0008\u0002\u0010:\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00060\u001b¢\u0006\u0002\u0008;¢\u0006\u000c\u0008\u001d\u0012\u0008\u0008\u001e\u0012\u0004\u0008\u0008(<\u0012\u0004\u0012\u00020\u000602¢\u0006\u0002\u0008;H\u0007¢\u0006\u0002\u0010A\u001aî\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010/\u001a\u00020@2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020\u0006022\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00132\u0008\u0008\u0002\u00103\u001a\u0002042\u0008\u0008\u0002\u00105\u001a\u00020\u000c2\u0008\u0008\u0002\u00106\u001a\u0002072\u0008\u0008\u0002\u0010>\u001a\u0002072\u0008\u0008\u0002\u00108\u001a\u0002092\u0014\u0008\u0002\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u0006022\n\u0008\u0002\u0010!\u001a\u0004\u0018\u00010\"2\u0008\u0008\u0002\u0010#\u001a\u00020$23\u0008\u0002\u0010:\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00060\u001b¢\u0006\u0002\u0008;¢\u0006\u000c\u0008\u001d\u0012\u0008\u0008\u001e\u0012\u0004\u0008\u0008(<\u0012\u0004\u0012\u00020\u000602¢\u0006\u0002\u0008;H\u0007¢\u0006\u0002\u0010B\u001a\u0015\u0010C\u001a\u00020\u00062\u0006\u0010D\u001a\u00020EH\u0001¢\u0006\u0002\u0010F\u001a\u0015\u0010G\u001a\u00020\u00062\u0006\u0010D\u001a\u00020EH\u0001¢\u0006\u0002\u0010F\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004¨\u0006H²\u0006\n\u0010I\u001a\u00020JX\u008a\u0084\u0002²\u0006\n\u0010K\u001a\u00020JX\u008a\u0084\u0002²\u0006\n\u0010L\u001a\u00020JX\u008a\u0084\u0002²\u0006\n\u0010M\u001a\u000200X\u008a\u008e\u0002²\u0006\n\u0010N\u001a\u00020@X\u008a\u008e\u0002", d2 = {"DefaultTextFieldDecorator", "Landroidx/compose/foundation/text/input/TextFieldDecorator;", "MinTouchTargetSizeForHandles", "Landroidx/compose/ui/unit/DpSize;", "J", "BasicTextField", "", "state", "Landroidx/compose/foundation/text/input/TextFieldState;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "inputTransformation", "Landroidx/compose/foundation/text/input/InputTransformation;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "onKeyboardAction", "Landroidx/compose/foundation/text/input/KeyboardActionHandler;", "lineLimits", "Landroidx/compose/foundation/text/input/TextFieldLineLimits;", "onTextLayout", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/Function0;", "Landroidx/compose/ui/text/TextLayoutResult;", "Lkotlin/ParameterName;", "name", "getResult", "Lkotlin/ExtensionFunctionType;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "outputTransformation", "Landroidx/compose/foundation/text/input/OutputTransformation;", "decorator", "scrollState", "Landroidx/compose/foundation/ScrollState;", "(Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/foundation/text/input/InputTransformation;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/input/KeyboardActionHandler;Landroidx/compose/foundation/text/input/TextFieldLineLimits;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/foundation/text/input/OutputTransformation;Landroidx/compose/foundation/text/input/TextFieldDecorator;Landroidx/compose/foundation/ScrollState;Landroidx/compose/runtime/Composer;III)V", "codepointTransformation", "Landroidx/compose/foundation/text/input/internal/CodepointTransformation;", "isPassword", "(Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/foundation/text/input/InputTransformation;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/input/KeyboardActionHandler;Landroidx/compose/foundation/text/input/TextFieldLineLimits;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/foundation/text/input/internal/CodepointTransformation;Landroidx/compose/foundation/text/input/OutputTransformation;Landroidx/compose/foundation/text/input/TextFieldDecorator;Landroidx/compose/foundation/ScrollState;ZLandroidx/compose/runtime/Composer;III)V", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "decorationBox", "Landroidx/compose/runtime/Composable;", "innerTextField", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "minLines", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "TextFieldCursorHandle", "selectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "(Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Landroidx/compose/runtime/Composer;I)V", "TextFieldSelectionHandles", "foundation_release", "cursorHandleState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldHandleState;", "startHandleState", "endHandleState", "textFieldValueState", "lastTextValue"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class BasicTextFieldKt {

    private static final TextFieldDecorator DefaultTextFieldDecorator;
    private static final long MinTouchTargetSizeForHandles;
    static {
        BasicTextFieldKt.DefaultTextFieldDecorator = (TextFieldDecorator)BasicTextFieldKt.DefaultTextFieldDecorator.1.INSTANCE;
        int i2 = 0;
        int i3 = 0;
        BasicTextFieldKt.MinTouchTargetSizeForHandles = DpKt.DpSize-YgX7TsA(Dp.constructor-impl((float)i), Dp.constructor-impl((float)$i$f$getDp));
    }

    public static final void BasicTextField(TextFieldState state, Modifier modifier, boolean enabled, boolean readOnly, InputTransformation inputTransformation, TextStyle textStyle, androidx.compose.foundation.text.KeyboardOptions keyboardOptions, KeyboardActionHandler onKeyboardAction, TextFieldLineLimits lineLimits, Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> onTextLayout, MutableInteractionSource interactionSource, Brush cursorBrush, OutputTransformation outputTransformation, TextFieldDecorator decorator, ScrollState scrollState, Composer $composer, int $changed, int $changed1, int i19) {
        boolean traceInProgress2;
        Object endRestartGroup;
        int scrollState2;
        int defaultsInvalid;
        boolean enabled2;
        Object obj12;
        Object obj7;
        Object obj6;
        Object obj10;
        Object obj9;
        Object obj11;
        boolean changedInstance;
        Object obj5;
        int i;
        int readOnly2;
        Object obj;
        int i10;
        boolean traceInProgress;
        boolean z;
        Object default;
        boolean z2;
        Object $composer2;
        int $dirty;
        Object $dirty2;
        int $dirty12;
        Object $dirty13;
        boolean $dirty1;
        Object obj2;
        int readOnly3;
        int i11;
        boolean z3;
        Object inputTransformation2;
        Object inputTransformation3;
        boolean companion;
        int textStyle3;
        Object onKeyboardAction4;
        int onKeyboardAction3;
        int i16;
        int keyboardOptions2;
        Object lineLimits4;
        TextFieldLineLimits lineLimits2;
        Object obj3;
        Object onKeyboardAction2;
        int onTextLayout3;
        int onTextLayout2;
        Object obj4;
        int lineLimits3;
        TextFieldLineLimits textStyle2;
        Object obj8;
        int onTextLayout4;
        int i22;
        Object interactionSource3;
        int interactionSource2;
        int i21;
        int decorator2;
        int decorator4;
        int changed2;
        int cursorBrush2;
        int i29;
        int outputTransformation2;
        int i26;
        int decorator3;
        int i12;
        int i4;
        int i18;
        int i9;
        int i20;
        Composer composer;
        int i8;
        int i14;
        int i27;
        int i30;
        int i23;
        int i3;
        int changed3;
        int i28;
        int i13;
        int i5;
        int i2;
        int i17;
        int i7;
        int i15;
        int i6;
        int i24;
        int i25;
        boolean changed;
        ScopeUpdateScope scopeUpdateScope;
        boolean obj37;
        int obj38;
        Object obj13 = decorator;
        int i35 = $changed;
        i10 = $changed1;
        int i61 = i19;
        Composer restartGroup = $composer.startRestartGroup(469439921);
        ComposerKt.sourceInformation(restartGroup, "C(BasicTextField)P(13,7,2,11,3,14,5,8,6,9,4!1,10)184@10988L21,188@11134L610:BasicTextField.kt#423gt5");
        $dirty = $changed;
        $dirty12 = $changed1;
        if (i61 & 1 != 0) {
            $dirty |= 6;
            obj2 = state;
        } else {
            if (i35 & 6 == 0) {
                i16 = restartGroup.changed(state) ? 4 : 2;
                $dirty |= i16;
            } else {
                obj2 = state;
            }
        }
        int i89 = i61 & 2;
        if (i89 != 0) {
            $dirty |= 48;
            obj8 = modifier;
        } else {
            if (i35 & 48 == 0) {
                i22 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i22;
            } else {
                obj8 = modifier;
            }
        }
        int i92 = i61 & 4;
        changed2 = 128;
        if (i92 != 0) {
            $dirty |= 384;
            z3 = enabled;
        } else {
            if (i35 & 384 == 0) {
                i29 = restartGroup.changed(enabled) ? i21 : changed2;
                $dirty |= i29;
            } else {
                z3 = enabled;
            }
        }
        outputTransformation2 = i61 & 8;
        i4 = 1024;
        if (outputTransformation2 != 0) {
            $dirty |= 3072;
            companion = readOnly;
        } else {
            if (i35 & 3072 == 0) {
                i20 = restartGroup.changed(readOnly) ? i26 : i4;
                $dirty |= i20;
            } else {
                companion = readOnly;
            }
        }
        int i96 = i61 & 16;
        i14 = 16384;
        if (i96 != 0) {
            $dirty |= 24576;
            obj3 = inputTransformation;
        } else {
            if (i35 & 24576 == 0) {
                i23 = restartGroup.changed(inputTransformation) ? i14 : i8;
                $dirty |= i23;
            } else {
                obj3 = inputTransformation;
            }
        }
        int i97 = i61 & 32;
        changed3 = 196608;
        if (i97 != 0) {
            $dirty |= changed3;
            obj4 = textStyle;
        } else {
            if (i35 & changed3 == 0) {
                i28 = restartGroup.changed(textStyle) ? 131072 : 65536;
                $dirty |= i28;
            } else {
                obj4 = textStyle;
            }
        }
        int i98 = i61 & 64;
        i13 = 1572864;
        if (i98 != 0) {
            $dirty |= i13;
            default = keyboardOptions;
        } else {
            if (i35 & i13 == 0) {
                i5 = restartGroup.changed(keyboardOptions) ? 1048576 : 524288;
                $dirty |= i5;
            } else {
                default = keyboardOptions;
            }
        }
        int i36 = i61 & 128;
        int i99 = 12582912;
        if (i36 != 0) {
            $dirty |= i99;
            i2 = i36;
            obj12 = onKeyboardAction;
        } else {
            if ($changed & i99 == 0) {
                i2 = i36;
                i17 = restartGroup.changed(onKeyboardAction) ? 8388608 : 4194304;
                $dirty |= i17;
            } else {
                i2 = i36;
                obj12 = onKeyboardAction;
            }
        }
        int i37 = i61 & 256;
        int i101 = 100663296;
        if (i37 != 0) {
            $dirty |= i101;
            i7 = i37;
            obj7 = lineLimits;
        } else {
            if ($changed & i101 == 0) {
                i7 = i37;
                i15 = restartGroup.changed(lineLimits) ? 67108864 : 33554432;
                $dirty |= i15;
            } else {
                i7 = i37;
                obj7 = lineLimits;
            }
        }
        int i38 = i61 & 512;
        int i103 = 805306368;
        if (i38 != 0) {
            $dirty |= i103;
            i6 = i38;
            obj6 = onTextLayout;
        } else {
            if ($changed & i103 == 0) {
                i6 = i38;
                i24 = restartGroup.changedInstance(onTextLayout) ? 536870912 : 268435456;
                $dirty |= i24;
            } else {
                i6 = i38;
                obj6 = onTextLayout;
            }
        }
        int i39 = i61 & 1024;
        if (i39 != 0) {
            $dirty12 |= 6;
            i25 = i39;
            obj10 = interactionSource;
        } else {
            if (i10 & 6 == 0) {
                i25 = i39;
                i18 = restartGroup.changed(interactionSource) ? 4 : 2;
                $dirty12 |= i18;
            } else {
                i25 = i39;
                obj10 = interactionSource;
            }
        }
        int i40 = i61 & 2048;
        if (i40 != 0) {
            $dirty12 |= 48;
            i9 = i40;
            obj9 = cursorBrush;
        } else {
            if (i10 & 48 == 0) {
                i9 = i40;
                i27 = restartGroup.changed(cursorBrush) ? 32 : 16;
                $dirty12 |= i27;
            } else {
                i9 = i40;
                obj9 = cursorBrush;
            }
        }
        int i41 = i61 & 4096;
        if (i41 != 0) {
            $dirty12 |= 384;
            i30 = i41;
            obj11 = outputTransformation;
        } else {
            i30 = i41;
            if (i10 & 384 == 0) {
                if (restartGroup.changed(outputTransformation)) {
                } else {
                    i21 = changed2;
                }
                $dirty12 |= i21;
            } else {
                obj11 = outputTransformation;
            }
        }
        changedInstance = i61 & 8192;
        if (changedInstance != null) {
            $dirty12 |= 3072;
            decorator2 = changedInstance;
        } else {
            decorator2 = changedInstance;
            if (i10 & 3072 == 0) {
                if (i10 & 4096 == 0) {
                    changedInstance = restartGroup.changed(obj13);
                } else {
                    changedInstance = restartGroup.changedInstance(obj13);
                }
                if (changedInstance != null) {
                } else {
                    i26 = i4;
                }
                $dirty12 |= i26;
            }
        }
        if (i10 & 24576 == 0) {
            if (i61 & 16384 == 0) {
                if (restartGroup.changed(scrollState)) {
                    i8 = i14;
                }
            } else {
                obj5 = scrollState;
            }
            $dirty12 |= i8;
        } else {
            obj5 = scrollState;
        }
        if ($dirty & cursorBrush2 == 306783378 && $dirty12 & 9363 == 9362) {
            if ($dirty12 & 9363 == 9362) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    if ($changed & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if (i89 != 0) {
                                obj8 = defaultsInvalid;
                            }
                            enabled2 = i92 != 0 ? 1 : z3;
                            readOnly2 = outputTransformation2 != 0 ? 0 : companion;
                            inputTransformation3 = i96 != 0 ? 0 : obj3;
                            if (i97 != 0) {
                                obj4 = companion;
                            }
                            if (i98 != 0) {
                                default = KeyboardOptions.Companion.getDefault();
                            }
                            onKeyboardAction3 = i2 != 0 ? 0 : onKeyboardAction;
                            if (i7 != 0) {
                                lineLimits2 = TextFieldLineLimits.Companion.getDefault();
                            } else {
                                lineLimits2 = lineLimits;
                            }
                            onTextLayout2 = i6 != 0 ? 0 : onTextLayout;
                            interactionSource2 = i25 != 0 ? 0 : interactionSource;
                            if (i9 != 0) {
                                cursorBrush2 = BasicTextFieldDefaults.INSTANCE.getCursorBrush();
                            } else {
                                cursorBrush2 = cursorBrush;
                            }
                            outputTransformation2 = i30 != 0 ? 0 : outputTransformation;
                            decorator4 = decorator2 != 0 ? 0 : decorator;
                            obj37 = enabled2;
                            if (i61 & 16384 != 0) {
                                i45 &= $dirty12;
                                $dirty1 = obj37;
                                i11 = obj38;
                                i4 = rememberScrollState;
                                scrollState2 = onTextLayout2;
                                i12 = decorator4;
                                decorator2 = cursorBrush2;
                                onTextLayout3 = onKeyboardAction3;
                                onKeyboardAction4 = obj4;
                                textStyle2 = lineLimits2;
                                lineLimits4 = default;
                            } else {
                                i11 = obj38;
                                i4 = scrollState;
                                i = $dirty12;
                                scrollState2 = onTextLayout2;
                                i12 = decorator4;
                                decorator2 = cursorBrush2;
                                $dirty1 = obj37;
                                onTextLayout3 = onKeyboardAction3;
                                onKeyboardAction4 = obj4;
                                textStyle2 = lineLimits2;
                                lineLimits4 = default;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            if (i61 & 16384 != 0) {
                                interactionSource2 = interactionSource;
                                decorator2 = cursorBrush;
                                outputTransformation2 = outputTransformation;
                                i12 = decorator;
                                i4 = scrollState;
                                i = i34;
                                lineLimits4 = default;
                                $dirty1 = z3;
                                i11 = companion;
                                inputTransformation3 = obj3;
                                onKeyboardAction4 = obj4;
                                onTextLayout3 = onKeyboardAction;
                                textStyle2 = lineLimits;
                                scrollState2 = onTextLayout;
                            } else {
                                scrollState2 = onTextLayout;
                                interactionSource2 = interactionSource;
                                decorator2 = cursorBrush;
                                outputTransformation2 = outputTransformation;
                                i12 = decorator;
                                i4 = scrollState;
                                lineLimits4 = default;
                                i = $dirty12;
                                $dirty1 = z3;
                                i11 = companion;
                                inputTransformation3 = obj3;
                                onKeyboardAction4 = obj4;
                                onTextLayout3 = onKeyboardAction;
                                textStyle2 = lineLimits;
                            }
                        }
                    } else {
                    }
                    restartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(469439921, $dirty, i, "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:187)");
                    }
                    i3 = $dirty;
                    Object $dirty3 = obj8;
                    int modifier2 = scrollState2;
                    BasicTextFieldKt.BasicTextField(state, $dirty3, $dirty1, i11, inputTransformation3, onKeyboardAction4, lineLimits4, onTextLayout3, textStyle2, modifier2, interactionSource2, decorator2, 0, outputTransformation2, i12, i4, false, restartGroup, i55 | i77, i60 | i84, 65536);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj = $dirty3;
                    z = $dirty1;
                    z2 = i11;
                    $composer2 = inputTransformation3;
                    $dirty2 = onKeyboardAction4;
                    $dirty13 = lineLimits4;
                    readOnly3 = onTextLayout3;
                    inputTransformation2 = textStyle2;
                    textStyle3 = modifier2;
                    keyboardOptions2 = interactionSource2;
                    onKeyboardAction2 = decorator2;
                    lineLimits3 = outputTransformation2;
                    onTextLayout4 = i12;
                    interactionSource3 = i4;
                    decorator3 = i;
                } else {
                    restartGroup.skipToGroupEnd();
                    readOnly3 = onKeyboardAction;
                    keyboardOptions2 = interactionSource;
                    interactionSource3 = scrollState;
                    composer = restartGroup;
                    i3 = $dirty;
                    decorator3 = $dirty12;
                    z = z3;
                    $composer2 = obj3;
                    $dirty2 = obj4;
                    obj = obj8;
                    inputTransformation2 = lineLimits;
                    onKeyboardAction2 = cursorBrush;
                    lineLimits3 = outputTransformation;
                    onTextLayout4 = decorator;
                    $dirty13 = default;
                    z2 = companion;
                    textStyle3 = onTextLayout;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new BasicTextFieldKt.BasicTextField.1(state, obj, z, z2, $composer2, $dirty2, $dirty13, readOnly3, inputTransformation2, textStyle3, keyboardOptions2, onKeyboardAction2, lineLimits3, onTextLayout4, interactionSource3, $changed, $changed1, i19);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    public static final void BasicTextField(TextFieldState state, Modifier modifier, boolean enabled, boolean readOnly, InputTransformation inputTransformation, TextStyle textStyle, androidx.compose.foundation.text.KeyboardOptions keyboardOptions, KeyboardActionHandler onKeyboardAction, TextFieldLineLimits lineLimits, Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> onTextLayout, MutableInteractionSource interactionSource, Brush cursorBrush, CodepointTransformation codepointTransformation, OutputTransformation outputTransformation, TextFieldDecorator decorator, ScrollState scrollState, boolean isPassword, Composer $composer, int $changed, int $changed1, int i21) {
        boolean z5;
        int skipping;
        int defaultsInvalid;
        boolean readOnly2;
        int i13;
        int i42;
        Object $i$a$CacheBasicTextFieldKt$BasicTextField$textFieldSelectionState$1;
        Object invalid$iv;
        Object directDragGestureInitiator;
        Function0 factory$iv$iv$iv;
        boolean changed2;
        int $dirty3;
        Object $i$a$CacheBasicTextFieldKt$BasicTextField$textLayoutState$1;
        Object $i$a$CacheBasicTextFieldKt$BasicTextField$2;
        Object $this$cache$iv;
        Object traceInProgress2;
        ScopeUpdateScope endRestartGroup;
        Object obj10;
        Object obj5;
        Object obj6;
        Object obj2;
        Object obj7;
        Object obj;
        Object obj11;
        int i20;
        Object obj9;
        int i26;
        int windowInfo;
        Orientation horizontal;
        Integer currentCompositionLocalMap;
        Object obj4;
        boolean changedInstance;
        Object currentTextToolbar;
        boolean z7;
        Composer composer;
        int valueOf;
        boolean z3;
        Object $composer3;
        int $dirty2;
        Object $dirty4;
        int $dirty12;
        int $dirty1;
        int $i$a$CacheBasicTextFieldKt$BasicTextField$interactionSource$1;
        int i44;
        int i7;
        int i45;
        Object it$iv;
        TextFieldSelectionState transformedState;
        Object $dirty13;
        int i49;
        int default;
        Object keyboardOptions2;
        int i34;
        Object obj12;
        int onKeyboardAction2;
        TextFieldLineLimits field;
        boolean i2;
        Object lineLimits2;
        Object rememberedValue;
        int i16;
        Object obj13;
        int textStyle2;
        int i5;
        int i27;
        int i43;
        int i36;
        int i47;
        boolean z6;
        boolean traceInProgress;
        Object density;
        int empty;
        SolidColor enabled2;
        Object obj3;
        int modifier2;
        int i33;
        int onTextLayout2;
        int i18;
        Object obj8;
        int inputTransformation2;
        int i28;
        int i15;
        int codepointTransformation2;
        ScrollState codepointTransformation3;
        int i30;
        int interactionSource2;
        int interactionSource3;
        int i31;
        Object $dirty;
        int i32;
        int i50;
        int outputTransformation2;
        int i11;
        int i35;
        Object cursorBrush2;
        int i29;
        Composer $composer2;
        Object companion2;
        int i;
        androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.2.1 field2;
        int i37;
        int decorator2;
        Object iNSTANCE;
        int companion;
        int changed;
        int textLayoutState;
        int i3;
        int i12;
        int i10;
        int i46;
        int i38;
        Function0 i23;
        int i25;
        int i22;
        int anon;
        int i41;
        int i39;
        int i17;
        int i4;
        int i14;
        int i9;
        int i8;
        int i52;
        boolean changed3;
        int booleanValue2;
        boolean windowFocused;
        boolean booleanValue;
        TransformedTextFieldState field4;
        TextFieldSelectionState textFieldSelectionState;
        TextFieldSelectionState field3;
        SolidColor solidColor;
        boolean z;
        boolean z2;
        boolean z4;
        ScrollState scrollState2;
        Orientation orientation;
        boolean equal;
        int i6;
        Modifier focusable;
        ScrollState scrollState3;
        Orientation orientation2;
        int i48;
        boolean reverseDirection;
        int i40;
        int i19;
        int i24;
        int i51;
        ScopeUpdateScope scopeUpdateScope;
        boolean obj58;
        int obj59;
        Object obj60;
        int obj61;
        boolean obj62;
        boolean obj63;
        int obj64;
        int obj65;
        boolean obj66;
        boolean obj67;
        int obj68;
        Object obj69;
        Object obj70;
        int obj71;
        Composer obj72;
        int obj73;
        Composer obj74;
        traceInProgress2 = state;
        Object obj14 = decorator;
        int i65 = $changed;
        int i83 = $changed1;
        int i88 = i21;
        Composer restartGroup = $composer.startRestartGroup(965149429);
        ComposerKt.sourceInformation(restartGroup, "C(BasicTextField)P(15,9,3,13,4,16,7,10,8,11,5,1!1,12!1,14)234@12943L21,239@13149L7,240@13204L7,241@13249L7,247@13619L25,248@13693L25,251@13806L797,271@14801L48,273@14885L357,284@15295L7,285@15359L7,286@15413L7,287@15436L520,287@15425L531,303@16004L83,303@15962L125,342@17504L3096:BasicTextField.kt#423gt5");
        $dirty2 = $changed;
        $dirty12 = $changed1;
        if (i88 & 1 != 0) {
            $dirty2 |= 6;
        } else {
            if (i65 & 6 == 0) {
                i49 = restartGroup.changed(traceInProgress2) ? 4 : 2;
                $dirty2 |= i49;
            }
        }
        default = i88 & 2;
        if (default != 0) {
            $dirty2 |= 48;
            obj3 = modifier;
        } else {
            if (i65 & 48 == 0) {
                i33 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i33;
            } else {
                obj3 = modifier;
            }
        }
        onTextLayout2 = i88 & 4;
        if (onTextLayout2 != 0) {
            $dirty2 |= 384;
            z6 = enabled;
        } else {
            if (i65 & 384 == 0) {
                i30 = restartGroup.changed(enabled) ? 256 : 128;
                $dirty2 |= i30;
            } else {
                z6 = enabled;
            }
        }
        int i147 = i88 & 8;
        if (i147 != 0) {
            $dirty2 |= 3072;
            i2 = readOnly;
        } else {
            if (i65 & 3072 == 0) {
                i35 = restartGroup.changed(readOnly) ? 2048 : i31;
                $dirty2 |= i35;
            } else {
                i2 = readOnly;
            }
        }
        cursorBrush2 = i88 & 16;
        if (cursorBrush2 != 0) {
            $dirty2 |= 24576;
            obj8 = inputTransformation;
        } else {
            if (i65 & 24576 == 0) {
                i37 = restartGroup.changed(inputTransformation) ? 16384 : 8192;
                $dirty2 |= i37;
            } else {
                obj8 = inputTransformation;
            }
        }
        decorator2 = i88 & 32;
        changed = 196608;
        if (decorator2 != 0) {
            $dirty2 |= changed;
            obj13 = textStyle;
        } else {
            if (i65 & changed == 0) {
                i10 = restartGroup.changed(textStyle) ? 131072 : 65536;
                $dirty2 |= i10;
            } else {
                obj13 = textStyle;
            }
        }
        i46 = i88 & 64;
        i38 = 1572864;
        if (i46 != 0) {
            $dirty2 |= i38;
            obj12 = keyboardOptions;
        } else {
            if (i65 & i38 == 0) {
                i22 = restartGroup.changed(keyboardOptions) ? 1048576 : 524288;
                $dirty2 |= i22;
            } else {
                obj12 = keyboardOptions;
            }
        }
        int i66 = i88 & 128;
        int i163 = 12582912;
        if (i66 != 0) {
            $dirty2 |= i163;
            anon = i66;
            obj10 = onKeyboardAction;
        } else {
            if ($changed & i163 == 0) {
                anon = i66;
                i41 = restartGroup.changed(onKeyboardAction) ? 8388608 : 4194304;
                $dirty2 |= i41;
            } else {
                anon = i66;
                obj10 = onKeyboardAction;
            }
        }
        int i67 = i88 & 256;
        int i165 = 100663296;
        if (i67 != 0) {
            $dirty2 |= i165;
            i39 = i67;
            obj5 = lineLimits;
        } else {
            if ($changed & i165 == 0) {
                i39 = i67;
                i17 = restartGroup.changed(lineLimits) ? 67108864 : 33554432;
                $dirty2 |= i17;
            } else {
                i39 = i67;
                obj5 = lineLimits;
            }
        }
        int i68 = i88 & 512;
        int i167 = 805306368;
        if (i68 != 0) {
            $dirty2 |= i167;
            i4 = i68;
            obj6 = onTextLayout;
        } else {
            if ($changed & i167 == 0) {
                i4 = i68;
                i14 = restartGroup.changedInstance(onTextLayout) ? 536870912 : 268435456;
                $dirty2 |= i14;
            } else {
                i4 = i68;
                obj6 = onTextLayout;
            }
        }
        int i69 = i88 & 1024;
        if (i69 != 0) {
            $dirty12 |= 6;
            i9 = i69;
            obj2 = interactionSource;
        } else {
            if (i83 & 6 == 0) {
                i9 = i69;
                i8 = restartGroup.changed(interactionSource) ? 4 : 2;
                $dirty12 |= i8;
            } else {
                i9 = i69;
                obj2 = interactionSource;
            }
        }
        int i70 = i88 & 2048;
        if (i70 != 0) {
            $dirty12 |= 48;
            i52 = i70;
            obj7 = cursorBrush;
        } else {
            if (i83 & 48 == 0) {
                i52 = i70;
                i28 = restartGroup.changed(cursorBrush) ? 32 : 16;
                $dirty12 |= i28;
            } else {
                i52 = i70;
                obj7 = cursorBrush;
            }
        }
        int i71 = i88 & 4096;
        if (i71 != 0) {
            $dirty12 |= 384;
            i15 = i71;
            obj = codepointTransformation;
        } else {
            i15 = i71;
            if (i83 & 384 == 0) {
                i50 = restartGroup.changed(codepointTransformation) ? 256 : 128;
                $dirty12 |= i50;
            } else {
                obj = codepointTransformation;
            }
        }
        int i73 = i88 & 8192;
        if (i73 != 0) {
            $dirty12 |= 3072;
            outputTransformation2 = i73;
            obj11 = outputTransformation;
        } else {
            outputTransformation2 = i73;
            if (i83 & 3072 == 0) {
                if (restartGroup.changed(outputTransformation)) {
                    i31 = 2048;
                }
                $dirty12 |= i31;
            } else {
                obj11 = outputTransformation;
            }
        }
        i20 = i88 & 16384;
        $dirty = 32768;
        if (i20 != 0) {
            $dirty12 |= 24576;
            booleanValue2 = i20;
        } else {
            booleanValue2 = i20;
            if (i83 & 24576 == 0) {
                if (i83 & $dirty == 0) {
                    changedInstance = restartGroup.changed(obj14);
                } else {
                    changedInstance = restartGroup.changedInstance(obj14);
                }
                i20 = changedInstance != null ? 16384 : 8192;
                $dirty12 |= i20;
            }
        }
        if (i83 & changed == 0) {
            if (i88 & $dirty == 0) {
                changed = restartGroup.changed(scrollState) ? 131072 : 65536;
            } else {
                obj9 = scrollState;
            }
            $dirty12 |= changed;
        } else {
            obj9 = scrollState;
        }
        textLayoutState = i88 & i161;
        if (textLayoutState != 0) {
            $dirty12 |= i38;
            z5 = isPassword;
        } else {
            if (i83 & i38 == 0) {
                i38 = restartGroup.changed(isPassword) ? 1048576 : 524288;
                $dirty12 |= i38;
            } else {
                z5 = isPassword;
            }
        }
        if ($dirty2 & i23 == 306783378 && i61 &= $dirty12 == 599186) {
            if (i61 &= $dirty12 == 599186) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    if ($changed & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if (default != 0) {
                                obj3 = defaultsInvalid;
                            }
                            if (onTextLayout2 != 0) {
                                z6 = defaultsInvalid;
                            }
                            readOnly2 = i147 != 0 ? 0 : i2;
                            if (cursorBrush2 != 0) {
                                obj8 = default;
                            }
                            if (decorator2 != 0) {
                                obj13 = default;
                            }
                            if (i46 != 0) {
                                keyboardOptions2 = KeyboardOptions.Companion.getDefault();
                            } else {
                                keyboardOptions2 = obj12;
                            }
                            onKeyboardAction2 = anon != 0 ? 0 : onKeyboardAction;
                            if (i39 != 0) {
                                lineLimits2 = TextFieldLineLimits.Companion.getDefault();
                            } else {
                                lineLimits2 = lineLimits;
                            }
                            onTextLayout2 = i4 != 0 ? 0 : onTextLayout;
                            interactionSource2 = i9 != 0 ? 0 : interactionSource;
                            if (i52 != 0) {
                                cursorBrush2 = BasicTextFieldDefaults.INSTANCE.getCursorBrush();
                            } else {
                                cursorBrush2 = cursorBrush;
                            }
                            codepointTransformation2 = i15 != 0 ? 0 : codepointTransformation;
                            outputTransformation2 = outputTransformation2 != 0 ? 0 : outputTransformation;
                            decorator2 = booleanValue2 != 0 ? 0 : decorator;
                            if (i88 & $dirty != 0) {
                                obj58 = readOnly2;
                                int readOnly3 = 0;
                                $dirty = ScrollKt.rememberScrollState(readOnly3, restartGroup, readOnly3, 1);
                                $dirty12 &= readOnly2;
                            } else {
                                obj58 = readOnly2;
                                $dirty = scrollState;
                            }
                            if (textLayoutState != 0) {
                                z4 = obj58;
                                i52 = obj13;
                                z = z6;
                                i6 = onTextLayout2;
                                scrollState2 = $dirty;
                                solidColor = cursorBrush2;
                                i39 = decorator2;
                                textStyle2 = $dirty12;
                                $dirty1 = i53;
                                i42 = outputTransformation2;
                            } else {
                                z4 = obj58;
                                i52 = obj13;
                                z = z6;
                                i6 = onTextLayout2;
                                scrollState2 = $dirty;
                                i42 = outputTransformation2;
                                solidColor = cursorBrush2;
                                i39 = decorator2;
                                textStyle2 = $dirty12;
                                $dirty1 = isPassword;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            if (i88 & $dirty != 0) {
                                $dirty12 &= i13;
                            }
                            i6 = onTextLayout;
                            interactionSource2 = interactionSource;
                            solidColor = cursorBrush;
                            codepointTransformation2 = codepointTransformation;
                            i42 = outputTransformation;
                            i39 = decorator;
                            scrollState2 = scrollState;
                            keyboardOptions2 = obj12;
                            z4 = i2;
                            i52 = obj13;
                            z = z6;
                            onKeyboardAction2 = onKeyboardAction;
                            lineLimits2 = lineLimits;
                            textStyle2 = $dirty12;
                            $dirty1 = isPassword;
                        }
                    } else {
                    }
                    restartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(965149429, $dirty2, textStyle2, "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:238)");
                    }
                    int i145 = 0;
                    int i149 = 0;
                    int i77 = 2023513938;
                    String str2 = "CC:CompositionLocal.kt#9igjgp";
                    ComposerKt.sourceInformationMarkerStart(restartGroup, i77, str2);
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    Object this_$iv4 = consume5;
                    int i150 = 0;
                    int i159 = 0;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, i77, str2);
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    i32 = 0;
                    i29 = 0;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, str2);
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    Object this_$iv = consume2;
                    equal = Intrinsics.areEqual(lineLimits2, TextFieldLineLimits.SingleLine.INSTANCE);
                    String str3 = "CC(remember):BasicTextField.kt#9igjgp";
                    if (interactionSource2 == 0) {
                        obj69 = this_$iv;
                        restartGroup.startReplaceGroup(96938805);
                        ComposerKt.sourceInformation(restartGroup, "245@13454L39");
                        ComposerKt.sourceInformationMarkerStart(restartGroup, -1243798931, str3);
                        obj58 = restartGroup;
                        i32 = 0;
                        obj59 = i80;
                        Object rememberedValue5 = obj58.rememberedValue();
                        i29 = 0;
                        obj65 = $dirty1;
                        if (rememberedValue5 == Composer.Companion.getEmpty()) {
                            int i107 = 0;
                            obj60 = rememberedValue5;
                            obj58.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                        } else {
                            windowInfo = obj58;
                            $i$a$CacheBasicTextFieldKt$BasicTextField$interactionSource$1 = obj60;
                        }
                        ComposerKt.sourceInformationMarkerEnd(restartGroup);
                        restartGroup.endReplaceGroup();
                    } else {
                        obj69 = this_$iv;
                        obj65 = $dirty1;
                        restartGroup.startReplaceGroup(-1243799582);
                        restartGroup.endReplaceGroup();
                        $i$a$CacheBasicTextFieldKt$BasicTextField$interactionSource$1 = interactionSource2;
                    }
                    int i171 = $i$a$CacheBasicTextFieldKt$BasicTextField$interactionSource$1;
                    horizontal = equal ? Orientation.Horizontal : Orientation.Vertical;
                    Orientation orientation3 = orientation4;
                    int keyboardOptions4 = 0;
                    booleanValue2 = (Boolean)FocusInteractionKt.collectIsFocusedAsState((InteractionSource)i171, restartGroup, keyboardOptions4).getValue().booleanValue();
                    windowFocused = obj69.isWindowFocused();
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1243786909, str3);
                    i44 = $dirty2 & 14 == 4 ? 1 : 0;
                    i7 = textStyle2 & 896 == 256 ? 1 : 0;
                    i45 = textStyle2 & 7168 == 2048 ? 1 : 0;
                    Composer composer5 = restartGroup;
                    int i151 = 0;
                    it$iv = composer5.rememberedValue();
                    int i160 = 0;
                    if (obj58 | i45 == 0) {
                        obj71 = onKeyboardAction2;
                        if (it$iv == Composer.Companion.getEmpty()) {
                            if (codepointTransformation2 == 0) {
                                textLayoutState = iNSTANCE;
                                i46 = 0;
                                if (equal) {
                                } else {
                                    iNSTANCE = 0;
                                }
                            } else {
                                iNSTANCE = codepointTransformation2;
                            }
                            obj60 = it$iv;
                            obj61 = onKeyboardAction3;
                            it$iv = new TransformedTextFieldState(traceInProgress2, obj8, iNSTANCE, i42);
                            composer5.updateRememberedValue(it$iv);
                        } else {
                            obj60 = it$iv;
                        }
                    } else {
                        obj71 = onKeyboardAction2;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1243755818, str3);
                    Composer composer6 = restartGroup;
                    int i152 = 0;
                    Object rememberedValue2 = composer6.rememberedValue();
                    companion = 0;
                    if (!restartGroup.changed((TransformedTextFieldState)it$iv)) {
                        if (rememberedValue2 == Composer.Companion.getEmpty()) {
                            int i64 = 0;
                            textLayoutState = new TextLayoutState();
                            composer6.updateRememberedValue(textLayoutState);
                        } else {
                            $i$a$CacheBasicTextFieldKt$BasicTextField$textLayoutState$1 = rememberedValue2;
                        }
                    } else {
                    }
                    i9 = $i$a$CacheBasicTextFieldKt$BasicTextField$textLayoutState$1;
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1243752821, str3);
                    changed2 = restartGroup.changed(it$iv);
                    Composer composer2 = restartGroup;
                    int i112 = 0;
                    Object rememberedValue6 = composer2.rememberedValue();
                    int i153 = 0;
                    if (!changed2) {
                        obj67 = changed2;
                        if (rememberedValue6 == Composer.Companion.getEmpty()) {
                            int invalid$iv2 = 0;
                            if (booleanValue2 && windowFocused) {
                                textLayoutState = windowFocused ? 1 : 0;
                            } else {
                            }
                            obj61 = this_$iv4;
                            obj58 = textFieldSelectionState3;
                            super(it$iv, (TextLayoutState)i9, obj61, z, z4, textLayoutState, obj65);
                            $i$a$CacheBasicTextFieldKt$BasicTextField$textFieldSelectionState$1 = obj61;
                            decorator2 = obj65;
                            composer2.updateRememberedValue(obj58);
                        } else {
                            decorator2 = obj65;
                            $i$a$CacheBasicTextFieldKt$BasicTextField$textFieldSelectionState$1 = this_$iv4;
                            density = rememberedValue6;
                        }
                    } else {
                        obj67 = changed2;
                    }
                    $this$cache$iv = density;
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    int i136 = 0;
                    obj58 = i113;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, str2);
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    Object this_$iv2 = consume3;
                    int i137 = 0;
                    int i154 = 0;
                    i4 = lineLimits2;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, str2);
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    Object this_$iv3 = consume4;
                    int i138 = 0;
                    int i155 = 0;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, str2);
                    Object consume = restartGroup.consume((CompositionLocal)CompositionLocalsKt.getLocalTextToolbar());
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1243735026, str3);
                    i5 = i127 &= $dirty2 == 16384 ? 1 : 0;
                    i27 = $dirty2 & 896 == 256 ? 1 : 0;
                    i43 = $dirty2 & 7168 == 2048 ? 1 : 0;
                    i36 = i3 & i131 == 1048576 ? 1 : 0;
                    Composer composer7 = restartGroup;
                    empty = 0;
                    obj61 = $i$a$CacheBasicTextFieldKt$BasicTextField$textFieldSelectionState$1;
                    Object rememberedValue3 = composer7.rememberedValue();
                    int i156 = 0;
                    if (i123 |= i36 == 0) {
                        if (rememberedValue3 == Composer.Companion.getEmpty()) {
                            int textFieldSelectionState2 = 0;
                            obj65 = obj61;
                            obj64 = consume;
                            obj59 = it$iv;
                            obj58 = anon2;
                            obj61 = textFieldSelectionState;
                            super(obj59, obj8, obj61, this_$iv2, this_$iv3, obj64, obj65, z, z4, decorator2);
                            field4 = obj59;
                            transformedState = obj61;
                            companion2 = obj64;
                            currentTextToolbar = obj65;
                            composer7.updateRememberedValue((Function0)obj58);
                        } else {
                            $i$a$CacheBasicTextFieldKt$BasicTextField$2 = rememberedValue3;
                            companion2 = consume;
                            field4 = it$iv;
                            transformedState = textFieldSelectionState;
                            currentTextToolbar = obj61;
                        }
                    } else {
                        textFieldSelectionState = $this$cache$iv;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    EffectsKt.SideEffect((Function0)$i$a$CacheBasicTextFieldKt$BasicTextField$2, restartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1243717287, str3);
                    boolean changedInstance2 = restartGroup.changedInstance(transformedState);
                    Composer composer3 = restartGroup;
                    int i90 = 0;
                    rememberedValue = composer3.rememberedValue();
                    int i133 = 0;
                    if (!changedInstance2) {
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            empty = 0;
                            obj58 = changedInstance2;
                            invalid$iv = new BasicTextFieldKt.BasicTextField.3.1(transformedState);
                            composer3.updateRememberedValue((Function1)invalid$iv);
                        } else {
                            obj58 = changedInstance2;
                            invalid$iv = rememberedValue;
                        }
                    } else {
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    EffectsKt.DisposableEffect(transformedState, (Function1)invalid$iv, restartGroup, 0);
                    obj65 = obj70;
                    obj66 = obj71;
                    obj61 = transformedState;
                    obj63 = z;
                    obj68 = i171;
                    super(field4, i9, obj61, obj8, obj63, z4, obj65, obj66, equal, obj68);
                    field3 = obj61;
                    boolean z9 = obj63;
                    valueOf = obj66;
                    int i104 = obj68;
                    if (z9 && field3.getDirectDragGestureInitiator() == TextFieldSelectionState.InputType.None) {
                        i48 = field3.getDirectDragGestureInitiator() == TextFieldSelectionState.InputType.None ? 1 : 0;
                    } else {
                    }
                    int i125 = 0;
                    orientation2 = orientation3;
                    Modifier pointerHoverIcon$default = PointerIconKt.pointerHoverIcon$default(ScrollableKt.scrollable$default(FocusableKt.focusable(obj3.then((Modifier)textFieldDecoratorModifier), z9, i104), (ScrollableState)scrollState2, orientation2, i48, ScrollableDefaults.INSTANCE.reverseDirection((LayoutDirection)restartGroup.consume((CompositionLocal)CompositionLocalsKt.getLocalLayoutDirection()), orientation3, i125), 0, i104, 16, 0), TextPointerIcon_androidKt.getTextPointerIcon(), i125, 2, 0);
                    int i78 = 1;
                    int i106 = 384;
                    int i126 = 0;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    Alignment topStart = Alignment.Companion.getTopStart();
                    i11 = 0;
                    obj58 = topStart;
                    obj59 = i78;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    currentCompositionLocalMap = restartGroup.getCurrentCompositionLocalMap();
                    obj60 = currentCompositeKeyHash;
                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(restartGroup, pointerHoverIcon$default);
                    obj61 = pointerHoverIcon$default;
                    obj62 = constructor;
                    field2 = 0;
                    obj65 = currentTextToolbar;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                    if (!applier instanceof Applier) {
                        ComposablesKt.invalidApplier();
                    }
                    restartGroup.startReusableNode();
                    if (restartGroup.getInserting()) {
                        restartGroup.createNode(obj62);
                    } else {
                        factory$iv$iv$iv = obj62;
                        restartGroup.useNode();
                    }
                    Composer constructor-impl = Updater.constructor-impl(restartGroup);
                    int i162 = 0;
                    i23 = factory$iv$iv$iv;
                    Updater.set-impl(constructor-impl, BoxKt.maybeCachedBoxMeasurePolicy(topStart, i78), ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    i46 = 0;
                    obj62 = constructor-impl;
                    i25 = 0;
                    if (!obj62.getInserting()) {
                        obj64 = currentCompositionLocalMap;
                        obj71 = valueOf;
                        if (!Intrinsics.areEqual(obj62.rememberedValue(), Integer.valueOf(obj60))) {
                            obj62.updateRememberedValue(Integer.valueOf(obj60));
                            constructor-impl.apply(Integer.valueOf(obj60), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer = obj62;
                        }
                    } else {
                        obj64 = currentCompositionLocalMap;
                        obj71 = valueOf;
                    }
                    Updater.set-impl(constructor-impl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                    Composer composer4 = restartGroup;
                    obj62 = i60;
                    ComposerKt.sourceInformationMarkerStart(composer4, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                    obj66 = composer4;
                    i12 = 0;
                    obj67 = iNSTANCE3;
                    obj68 = materializeModifier;
                    ComposerKt.sourceInformationMarkerStart(composer4, 1236622543, "C343@17621L2973,343@17571L3023:BasicTextField.kt#423gt5");
                    anon = new BasicTextFieldKt.BasicTextField.4.1(i39, i4, i9, i52, booleanValue2, windowFocused, (Boolean)HoverInteractionKt.collectIsHoveredAsState((InteractionSource)i171, restartGroup, keyboardOptions4).getValue().booleanValue(), field4, field3, solidColor, z9, z4, scrollState2, orientation2, equal, i6);
                    obj66 = i84;
                    obj73 = i94;
                    obj74 = restartGroup;
                    ContextMenu_androidKt.ContextMenuArea(field3, z9, (Function2)ComposableLambdaKt.rememberComposableLambda(-673241599, true, anon, composer4, 54), composer4, i86 |= 384);
                    ComposerKt.sourceInformationMarkerEnd(composer4);
                    ComposerKt.sourceInformationMarkerEnd(composer4);
                    obj74.endNode();
                    ComposerKt.sourceInformationMarkerEnd(obj74);
                    ComposerKt.sourceInformationMarkerEnd(obj74);
                    ComposerKt.sourceInformationMarkerEnd(obj74);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $dirty13 = obj70;
                    i34 = obj71;
                    $dirty3 = $dirty2;
                    z7 = z9;
                    obj4 = obj3;
                    $composer3 = obj8;
                    modifier2 = codepointTransformation2;
                    i47 = interactionSource2;
                    i18 = cursorBrush2;
                    interactionSource3 = decorator2;
                    inputTransformation2 = i39;
                    field = i4;
                    $dirty4 = i52;
                    enabled2 = solidColor;
                    z3 = z4;
                    codepointTransformation3 = scrollState2;
                    i16 = i6;
                } else {
                    restartGroup.skipToGroupEnd();
                    i34 = onKeyboardAction;
                    i18 = outputTransformation;
                    codepointTransformation3 = scrollState;
                    interactionSource3 = isPassword;
                    obj74 = restartGroup;
                    $dirty3 = $dirty2;
                    i3 = $dirty12;
                    $dirty13 = obj12;
                    z3 = i2;
                    $dirty4 = obj13;
                    z7 = z6;
                    obj4 = obj3;
                    $composer3 = obj8;
                    field = lineLimits;
                    i16 = onTextLayout;
                    i47 = interactionSource;
                    enabled2 = cursorBrush;
                    modifier2 = codepointTransformation;
                    inputTransformation2 = decorator;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = obj74.endRestartGroup();
        if (endRestartGroup != null) {
            $composer2 = obj74;
            i = i158;
            $dirty3 = new BasicTextFieldKt.BasicTextField.5(state, obj4, z7, z3, $composer3, $dirty4, $dirty13, i34, field, i16, i47, enabled2, modifier2, i18, inputTransformation2, codepointTransformation3, interactionSource3, $changed, $changed1, i21);
            endRestartGroup.updateScope((Function2)$dirty3);
        } else {
            $composer2 = obj74;
            i = $dirty3;
        }
    }

    public static final void BasicTextField(TextFieldValue value, Function1<? super TextFieldValue, Unit> onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, androidx.compose.foundation.text.KeyboardOptions keyboardOptions, androidx.compose.foundation.text.KeyboardActions keyboardActions, boolean singleLine, int maxLines, int minLines, VisualTransformation visualTransformation, Function1<? super TextLayoutResult, Unit> onTextLayout, MutableInteractionSource interactionSource, Brush cursorBrush, Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> decorationBox, Composer $composer, int $changed, int $changed1, int i20) {
        boolean traceInProgress2;
        Object endRestartGroup;
        Object obj4;
        boolean z2;
        int i7;
        int i4;
        Object obj10;
        Object obj11;
        Object obj5;
        Object obj;
        Object obj9;
        Object skipping;
        Object modifier3;
        int i19;
        Object it$iv;
        int defaultsInvalid;
        Object modifier5;
        Object modifier2;
        int i33;
        Object textStyle2;
        int solidColor;
        Object obj2;
        int i11;
        boolean visualTransformation3;
        Object keyboardOptions3;
        int black-0d7_KjU;
        Object default;
        boolean onTextLayout3;
        int i10;
        Object $composer2;
        int $dirty2;
        Object cursorBrush3;
        int $dirty;
        int $dirty12;
        Object $dirty1;
        int i12;
        int i26;
        int i2;
        SolidColor singleLine3;
        int cursorBrush2;
        int companion;
        int singleLine2;
        Object obj6;
        int i3;
        int maxLines2;
        int maxLines3;
        int i27;
        int minLines2;
        boolean traceInProgress;
        boolean z;
        VisualTransformation keyboardActions2;
        Object enabled2;
        Object obj8;
        androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.10 enabled3;
        boolean keyboardOptions4;
        boolean obj7;
        int readOnly2;
        Object obj3;
        SolidColor decorationBox2;
        Object textStyle3;
        int i15;
        Function3 function3;
        Object visualTransformation2;
        int i28;
        int modifier4;
        int i13;
        boolean changed2;
        int i32;
        int i9;
        int onTextLayout4;
        Object onTextLayout2;
        int i16;
        int interactionSource3;
        int interactionSource2;
        int changedInstance2;
        int i;
        int i17;
        int i22;
        int i21;
        int i30;
        int i31;
        int companion2;
        int keyboardOptions2;
        Composer composer;
        int changed;
        int i5;
        int i18;
        int i24;
        int i29;
        int i34;
        int i23;
        int i14;
        int changed3;
        int i6;
        int i8;
        int i25;
        boolean changedInstance;
        ScopeUpdateScope scopeUpdateScope;
        Object obj39;
        int obj40;
        Object obj41;
        int obj42;
        Object obj43;
        traceInProgress2 = value;
        obj4 = onValueChange;
        int i39 = $changed;
        int i55 = $changed1;
        black-0d7_KjU = i20;
        Composer restartGroup = $composer.startRestartGroup(1804514146);
        ComposerKt.sourceInformation(restartGroup, "C(BasicTextField)P(14,10,8,2,11,13,5,4,12,6,7,15,9,3)766@39969L90,764@39907L740:BasicTextField.kt#423gt5");
        $dirty2 = $changed;
        $dirty12 = $changed1;
        if (black-0d7_KjU & 1 != 0) {
            $dirty2 |= 6;
        } else {
            if (i39 & 6 == 0) {
                i12 = restartGroup.changed(traceInProgress2) ? 4 : 2;
                $dirty2 |= i12;
            }
        }
        if (black-0d7_KjU & 2 != 0) {
            $dirty2 |= 48;
        } else {
            if (i39 & 48 == 0) {
                i26 = restartGroup.changedInstance(obj4) ? 32 : 16;
                $dirty2 |= i26;
            }
        }
        companion = black-0d7_KjU & 4;
        if (companion != 0) {
            $dirty2 |= 384;
            obj6 = modifier;
        } else {
            if (i39 & 384 == 0) {
                i15 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty2 |= i15;
            } else {
                obj6 = modifier;
            }
        }
        int i89 = black-0d7_KjU & 8;
        changed2 = 1024;
        if (i89 != 0) {
            $dirty2 |= 3072;
            z = enabled;
        } else {
            if (i39 & 3072 == 0) {
                i16 = restartGroup.changed(enabled) ? i28 : changed2;
                $dirty2 |= i16;
            } else {
                z = enabled;
            }
        }
        interactionSource3 = black-0d7_KjU & 16;
        int i92 = 8192;
        if (interactionSource3 != 0) {
            $dirty2 |= 24576;
            obj7 = readOnly;
        } else {
            if (i39 & 24576 == 0) {
                i31 = restartGroup.changed(readOnly) ? changedInstance2 : i92;
                $dirty2 |= i31;
            } else {
                obj7 = readOnly;
            }
        }
        companion2 = black-0d7_KjU & 32;
        int i99 = 196608;
        if (companion2 != 0) {
            $dirty2 |= i99;
            obj3 = textStyle;
        } else {
            if (i39 & i99 == 0) {
                i5 = restartGroup.changed(textStyle) ? 131072 : keyboardOptions2;
                $dirty2 |= i5;
            } else {
                obj3 = textStyle;
            }
        }
        int i100 = black-0d7_KjU & 64;
        i18 = 1572864;
        if (i100 != 0) {
            $dirty2 |= i18;
            obj8 = keyboardOptions;
        } else {
            if (i39 & i18 == 0) {
                i24 = restartGroup.changed(keyboardOptions) ? 1048576 : 524288;
                $dirty2 |= i24;
            } else {
                obj8 = keyboardOptions;
            }
        }
        minLines2 = black-0d7_KjU & 128;
        i29 = 12582912;
        if (minLines2 != 0) {
            $dirty2 |= i29;
            default = keyboardActions;
        } else {
            if (i39 & i29 == 0) {
                i34 = restartGroup.changed(keyboardActions) ? 8388608 : 4194304;
                $dirty2 |= i34;
            } else {
                default = keyboardActions;
            }
        }
        int i40 = black-0d7_KjU & 256;
        int i101 = 100663296;
        if (i40 != 0) {
            $dirty2 |= i101;
            i23 = i40;
            z2 = singleLine;
        } else {
            if ($changed & i101 == 0) {
                i23 = i40;
                i14 = restartGroup.changed(singleLine) ? 67108864 : 33554432;
                $dirty2 |= i14;
            } else {
                i23 = i40;
                z2 = singleLine;
            }
        }
        if ($changed & i103 == 0) {
            if (black-0d7_KjU & 512 == 0) {
                changed3 = restartGroup.changed(maxLines) ? 536870912 : 268435456;
            } else {
                i7 = maxLines;
            }
            $dirty2 |= changed3;
        } else {
            i7 = maxLines;
        }
        int i42 = black-0d7_KjU & 1024;
        if (i42 != 0) {
            $dirty12 |= 6;
            i6 = i42;
            i4 = minLines;
        } else {
            if (i55 & 6 == 0) {
                i6 = i42;
                i8 = restartGroup.changed(minLines) ? 4 : 2;
                $dirty12 |= i8;
            } else {
                i6 = i42;
                i4 = minLines;
            }
        }
        int i43 = black-0d7_KjU & 2048;
        if (i43 != 0) {
            $dirty12 |= 48;
            i25 = i43;
            obj10 = visualTransformation;
        } else {
            if (i55 & 48 == 0) {
                i25 = i43;
                i9 = restartGroup.changed(visualTransformation) ? 32 : 16;
                $dirty12 |= i9;
            } else {
                i25 = i43;
                obj10 = visualTransformation;
            }
        }
        int i44 = black-0d7_KjU & 4096;
        if (i44 != 0) {
            $dirty12 |= 384;
            onTextLayout4 = i44;
            obj11 = onTextLayout;
        } else {
            onTextLayout4 = i44;
            if (i55 & 384 == 0) {
                i22 = restartGroup.changedInstance(onTextLayout) ? 256 : 128;
                $dirty12 |= i22;
            } else {
                obj11 = onTextLayout;
            }
        }
        int i46 = black-0d7_KjU & 8192;
        if (i46 != 0) {
            $dirty12 |= 3072;
            i21 = i46;
            obj5 = interactionSource;
        } else {
            i21 = i46;
            if (i55 & 3072 == 0) {
                if (restartGroup.changed(interactionSource)) {
                } else {
                    i28 = changed2;
                }
                $dirty12 |= i28;
            } else {
                obj5 = interactionSource;
            }
        }
        int i47 = black-0d7_KjU & 16384;
        if (i47 != 0) {
            $dirty12 |= 24576;
            modifier4 = i47;
            obj = cursorBrush;
        } else {
            modifier4 = i47;
            if (i55 & 24576 == 0) {
                if (restartGroup.changed(cursorBrush)) {
                } else {
                    changedInstance2 = i92;
                }
                $dirty12 |= changedInstance2;
            } else {
                obj = cursorBrush;
            }
        }
        i32 = black-0d7_KjU & i90;
        if (i32 != 0) {
            $dirty12 |= i99;
            obj9 = decorationBox;
        } else {
            if (i55 & i99 == 0) {
                if (restartGroup.changedInstance(decorationBox)) {
                    keyboardOptions2 = 131072;
                }
                $dirty12 |= keyboardOptions2;
            } else {
                obj9 = decorationBox;
            }
        }
        if ($dirty2 & i == 306783378 && i53 &= $dirty12 == 74898) {
            if (i53 &= $dirty12 == 74898) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    if ($changed & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if (companion != 0) {
                                modifier5 = Modifier.Companion;
                            } else {
                                modifier5 = obj6;
                            }
                            if (i89 != 0) {
                                z = companion;
                            }
                            if (interactionSource3 != 0) {
                                obj7 = companion;
                            }
                            if (companion2 != 0) {
                                obj3 = companion;
                            }
                            if (i100 != 0) {
                                obj8 = companion;
                            }
                            if (minLines2 != 0) {
                                default = KeyboardActions.Companion.getDefault();
                            }
                            singleLine2 = i23 != 0 ? 0 : singleLine;
                            if (black-0d7_KjU & 512 != 0) {
                                maxLines3 = singleLine2 != 0 ? 1 : 0x7fffffff /* Unknown resource */;
                                $dirty2 &= minLines2;
                            } else {
                                maxLines3 = maxLines;
                            }
                            minLines2 = i6 != 0 ? 1 : minLines;
                            if (i25 != 0) {
                                visualTransformation2 = VisualTransformation.Companion.getNone();
                            } else {
                                visualTransformation2 = visualTransformation;
                            }
                            if (onTextLayout4 != 0) {
                                onTextLayout2 = BasicTextFieldKt.BasicTextField.10.INSTANCE;
                            } else {
                                onTextLayout2 = onTextLayout;
                            }
                            interactionSource2 = i21 != 0 ? 0 : interactionSource;
                            if (modifier4 != 0) {
                                obj39 = default;
                                modifier4 = modifier5;
                                solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), default, 0);
                                modifier2 = solidColor;
                            } else {
                                modifier4 = modifier5;
                                obj39 = default;
                                modifier2 = cursorBrush;
                            }
                            if (i32 != 0) {
                                textStyle3 = lambda-2$foundation_release;
                                obj2 = obj13;
                                maxLines2 = $dirty2;
                                $dirty = interactionSource2;
                                interactionSource3 = i83;
                                i10 = singleLine2;
                                i = minLines2;
                                keyboardOptions3 = obj8;
                                singleLine3 = modifier2;
                                keyboardOptions4 = z;
                                modifier3 = modifier4;
                                enabled2 = obj39;
                            } else {
                                maxLines2 = $dirty2;
                                $dirty = interactionSource2;
                                interactionSource3 = decorationBox3;
                                i10 = singleLine2;
                                i = minLines2;
                                keyboardOptions3 = obj8;
                                obj2 = obj3;
                                textStyle3 = decorationBox;
                                singleLine3 = modifier2;
                                keyboardOptions4 = z;
                                modifier3 = modifier4;
                                enabled2 = obj39;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            if (black-0d7_KjU & 512 != 0) {
                                $dirty2 &= i33;
                            }
                            interactionSource3 = maxLines;
                            i = minLines;
                            visualTransformation2 = visualTransformation;
                            onTextLayout2 = onTextLayout;
                            singleLine3 = cursorBrush;
                            modifier3 = obj6;
                            keyboardOptions3 = obj8;
                            obj2 = obj3;
                            textStyle3 = decorationBox;
                            maxLines2 = $dirty2;
                            keyboardOptions4 = z;
                            $dirty = interactionSource;
                            enabled2 = default;
                            i10 = singleLine;
                        }
                    } else {
                    }
                    restartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        obj39 = modifier3;
                        ComposerKt.traceEventStart(1804514146, maxLines2, $dirty12, "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:763)");
                    } else {
                        obj39 = modifier3;
                    }
                    i13 = i10 != 0 ? 1 : i;
                    SolidColor interactionSource4 = singleLine3;
                    cursorBrush2 = i10 != 0 ? 1 : interactionSource3;
                    obj40 = i49;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1242950400, "CC(remember):BasicTextField.kt#9igjgp");
                    i19 = maxLines2 & 14 == 4 ? 1 : 0;
                    i11 = maxLines2 & 112 == 32 ? 1 : 0;
                    Composer composer2 = restartGroup;
                    int i93 = 0;
                    it$iv = composer2.rememberedValue();
                    int i98 = 0;
                    if (obj42 | i11 == 0) {
                        keyboardOptions2 = keyboardOptions3;
                        if (it$iv == Composer.Companion.getEmpty()) {
                            keyboardOptions3 = 0;
                            obj43 = it$iv;
                            it$iv = new BasicTextFieldKt.BasicTextField.11.1(traceInProgress2, obj4);
                            composer2.updateRememberedValue((Function1)it$iv);
                        } else {
                            obj43 = it$iv;
                        }
                    } else {
                        keyboardOptions2 = keyboardOptions3;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.10 singleLine5 = onTextLayout2;
                    i17 = obj40;
                    i30 = maxLines2;
                    VisualTransformation singleLine4 = visualTransformation2;
                    skipping = obj39;
                    Composer visualTransformation4 = restartGroup;
                    int $composer3 = i91;
                    Object obj12 = obj41;
                    CoreTextFieldKt.CoreTextField(value, (Function1)it$iv, skipping, obj12, singleLine4, singleLine5, $composer3, interactionSource4, i10 ^ 1, cursorBrush2, i13, keyboardOptions3.toImeOptions$foundation_release(i10), enabled2, keyboardOptions4, obj7, textStyle3, visualTransformation4, i63 |= i75, i37 |= i81, 0);
                    composer = visualTransformation4;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $composer2 = obj12;
                    $dirty1 = enabled2;
                    function3 = textStyle3;
                    i3 = interactionSource3;
                    i27 = i;
                    i2 = companion2;
                    textStyle2 = skipping;
                    keyboardActions2 = singleLine4;
                    decorationBox2 = interactionSource4;
                    visualTransformation3 = keyboardOptions4;
                    cursorBrush3 = keyboardOptions2;
                    enabled3 = singleLine5;
                    onTextLayout3 = obj7;
                    readOnly2 = i32;
                } else {
                    restartGroup.skipToGroupEnd();
                    i2 = singleLine;
                    i27 = minLines;
                    function3 = decorationBox;
                    composer = restartGroup;
                    i30 = $dirty2;
                    i17 = $dirty12;
                    textStyle2 = obj6;
                    visualTransformation3 = z;
                    cursorBrush3 = obj8;
                    $composer2 = obj3;
                    i3 = maxLines;
                    keyboardActions2 = visualTransformation;
                    enabled3 = onTextLayout;
                    decorationBox2 = cursorBrush;
                    $dirty1 = default;
                    onTextLayout3 = obj7;
                    readOnly2 = interactionSource;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new BasicTextFieldKt.BasicTextField.12(value, onValueChange, textStyle2, visualTransformation3, onTextLayout3, $composer2, cursorBrush3, $dirty1, i2, i3, i27, keyboardActions2, enabled3, readOnly2, decorationBox2, function3, $changed, $changed1, i20);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    public static final void BasicTextField(TextFieldValue value, Function1 onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, androidx.compose.foundation.text.KeyboardOptions keyboardOptions, androidx.compose.foundation.text.KeyboardActions keyboardActions, boolean singleLine, int maxLines, VisualTransformation visualTransformation, Function1 onTextLayout, MutableInteractionSource interactionSource, Brush cursorBrush, Function3 decorationBox, Composer $composer, int $changed, int $changed1, int i19) {
        boolean z;
        int i22;
        Object obj10;
        Object obj13;
        Object obj9;
        Object obj14;
        Object obj11;
        int traceInProgress;
        Object modifier2;
        Object modifier3;
        boolean traceInProgress2;
        Object endRestartGroup;
        int i15;
        boolean $i$a$CacheBasicTextFieldKt$BasicTextField$17;
        int black-0d7_KjU;
        Object iNSTANCE;
        Object obj6;
        boolean $composer2;
        int $dirty2;
        boolean $dirty;
        int $dirty1;
        Object modifier4;
        Object obj7;
        Object enabled2;
        Object obj8;
        boolean readOnly3;
        Object readOnly2;
        boolean obj;
        Object textStyle2;
        int textStyle3;
        int i16;
        Object obj12;
        int keyboardOptions2;
        boolean default;
        Object obj5;
        VisualTransformation keyboardActions2;
        Object obj3;
        int i29;
        androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.16 singleLine2;
        int i4;
        int i23;
        Object maxLines2;
        Object obj4;
        SolidColor solidColor;
        Object obj2;
        Function3 visualTransformation2;
        int i26;
        Object i6;
        int i32;
        int i12;
        int changedInstance2;
        int i30;
        int i10;
        int i24;
        int i11;
        int companion;
        Composer composer;
        int i5;
        int i18;
        int i25;
        int i31;
        int i2;
        int i;
        int changed2;
        int i8;
        int i28;
        int i20;
        int changed;
        int i13;
        int i14;
        int i21;
        int i3;
        int i7;
        int i17;
        int i27;
        int i9;
        boolean changedInstance;
        ScopeUpdateScope scopeUpdateScope;
        Object obj37;
        int obj38;
        boolean obj50;
        int i33 = $changed;
        int i60 = $changed1;
        black-0d7_KjU = i19;
        Composer restartGroup = $composer.startRestartGroup(-560482651);
        ComposerKt.sourceInformation(restartGroup, "C(BasicTextField)P(13,9,7,2,10,12,5,4,11,6,14,8,3)843@42862L39,848@43102L579:BasicTextField.kt#423gt5");
        $dirty2 = $changed;
        $dirty1 = $changed1;
        if (black-0d7_KjU & 1 != 0) {
            $dirty2 |= 6;
            obj7 = value;
        } else {
            if (i33 & 6 == 0) {
                i16 = restartGroup.changed(value) ? 4 : 2;
                $dirty2 |= i16;
            } else {
                obj7 = value;
            }
        }
        if (black-0d7_KjU & 2 != 0) {
            $dirty2 |= 48;
            obj12 = onValueChange;
        } else {
            if (i33 & 48 == 0) {
                i4 = restartGroup.changedInstance(onValueChange) ? 32 : 16;
                $dirty2 |= i4;
            } else {
                obj12 = onValueChange;
            }
        }
        int i94 = black-0d7_KjU & 4;
        if (i94 != 0) {
            $dirty2 |= 384;
            obj8 = modifier;
        } else {
            if (i33 & 384 == 0) {
                i26 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty2 |= i26;
            } else {
                obj8 = modifier;
            }
        }
        i6 = black-0d7_KjU & 8;
        changedInstance2 = 1024;
        if (i6 != 0) {
            $dirty2 |= 3072;
            obj = enabled;
        } else {
            if (i33 & 3072 == 0) {
                i11 = restartGroup.changed(enabled) ? i32 : changedInstance2;
                $dirty2 |= i11;
            } else {
                obj = enabled;
            }
        }
        companion = black-0d7_KjU & 16;
        i18 = 8192;
        if (companion != 0) {
            $dirty2 |= 24576;
            default = readOnly;
        } else {
            if (i33 & 24576 == 0) {
                i2 = restartGroup.changed(readOnly) ? i5 : i18;
                $dirty2 |= i2;
            } else {
                default = readOnly;
            }
        }
        int i97 = black-0d7_KjU & 32;
        changed2 = 196608;
        if (i97 != 0) {
            $dirty2 |= changed2;
            obj3 = textStyle;
        } else {
            if (i33 & changed2 == 0) {
                i20 = restartGroup.changed(textStyle) ? 131072 : 65536;
                $dirty2 |= i20;
            } else {
                obj3 = textStyle;
            }
        }
        int i98 = black-0d7_KjU & 64;
        changed = 1572864;
        if (i98 != 0) {
            $dirty2 |= changed;
            obj4 = keyboardOptions;
        } else {
            if (i33 & changed == 0) {
                i13 = restartGroup.changed(keyboardOptions) ? 1048576 : 524288;
                $dirty2 |= i13;
            } else {
                obj4 = keyboardOptions;
            }
        }
        int i95 = black-0d7_KjU & 128;
        i14 = 12582912;
        if (i95 != 0) {
            $dirty2 |= i14;
            iNSTANCE = keyboardActions;
        } else {
            if (i33 & i14 == 0) {
                i21 = restartGroup.changed(keyboardActions) ? 8388608 : 4194304;
                $dirty2 |= i21;
            } else {
                iNSTANCE = keyboardActions;
            }
        }
        int i34 = black-0d7_KjU & 256;
        int i99 = 100663296;
        if (i34 != 0) {
            $dirty2 |= i99;
            i3 = i34;
            z = singleLine;
        } else {
            if ($changed & i99 == 0) {
                i3 = i34;
                i7 = restartGroup.changed(singleLine) ? 67108864 : 33554432;
                $dirty2 |= i7;
            } else {
                i3 = i34;
                z = singleLine;
            }
        }
        int i35 = black-0d7_KjU & 512;
        int i101 = 805306368;
        if (i35 != 0) {
            $dirty2 |= i101;
            i17 = i35;
            i22 = maxLines;
        } else {
            if ($changed & i101 == 0) {
                i17 = i35;
                i27 = restartGroup.changed(maxLines) ? 536870912 : 268435456;
                $dirty2 |= i27;
            } else {
                i17 = i35;
                i22 = maxLines;
            }
        }
        int i36 = black-0d7_KjU & 1024;
        if (i36 != 0) {
            $dirty1 |= 6;
            i9 = i36;
            obj10 = visualTransformation;
        } else {
            if (i60 & 6 == 0) {
                i9 = i36;
                i10 = restartGroup.changed(visualTransformation) ? 4 : 2;
                $dirty1 |= i10;
            } else {
                i9 = i36;
                obj10 = visualTransformation;
            }
        }
        int i37 = black-0d7_KjU & 2048;
        if (i37 != 0) {
            $dirty1 |= 48;
            i24 = i37;
            obj13 = onTextLayout;
        } else {
            if (i60 & 48 == 0) {
                i24 = i37;
                i25 = restartGroup.changedInstance(onTextLayout) ? 32 : 16;
                $dirty1 |= i25;
            } else {
                i24 = i37;
                obj13 = onTextLayout;
            }
        }
        int i38 = black-0d7_KjU & 4096;
        if (i38 != 0) {
            $dirty1 |= 384;
            i31 = i38;
            obj9 = interactionSource;
        } else {
            i31 = i38;
            if (i60 & 384 == 0) {
                changed = restartGroup.changed(interactionSource) ? 256 : 128;
                $dirty1 |= changed;
            } else {
                obj9 = interactionSource;
            }
        }
        int i40 = black-0d7_KjU & 8192;
        if (i40 != 0) {
            $dirty1 |= 3072;
            i8 = i40;
            obj14 = cursorBrush;
        } else {
            i8 = i40;
            if (i60 & 3072 == 0) {
                if (restartGroup.changed(cursorBrush)) {
                } else {
                    i32 = changedInstance2;
                }
                $dirty1 |= i32;
            } else {
                obj14 = cursorBrush;
            }
        }
        int i41 = black-0d7_KjU & 16384;
        if (i41 != 0) {
            $dirty1 |= 24576;
            i12 = i41;
            obj11 = decorationBox;
        } else {
            i12 = i41;
            if (i60 & 24576 == 0) {
                if (restartGroup.changedInstance(decorationBox)) {
                } else {
                    i5 = i18;
                }
                $dirty1 |= i5;
            } else {
                obj11 = decorationBox;
            }
        }
        if ($dirty2 & i30 == 306783378 && $dirty1 & 9363 == 9362) {
            if ($dirty1 & 9363 == 9362) {
                if (!restartGroup.getSkipping()) {
                    if (i94 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = obj8;
                    }
                    $i$a$CacheBasicTextFieldKt$BasicTextField$17 = i6 != 0 ? 1 : obj;
                    readOnly3 = companion != 0 ? 0 : default;
                    if (i97 != 0) {
                        textStyle2 = TextStyle.Companion.getDefault();
                    } else {
                        textStyle2 = obj3;
                    }
                    if (i98 != 0) {
                        obj4 = default;
                    }
                    if (i95 != 0) {
                        obj5 = iNSTANCE;
                    } else {
                        obj5 = iNSTANCE;
                    }
                    i29 = i3 != 0 ? iNSTANCE : singleLine;
                    i23 = i17 != 0 ? iNSTANCE : maxLines;
                    if (i9 != 0) {
                        obj2 = iNSTANCE;
                    } else {
                        obj2 = visualTransformation;
                    }
                    if (i24 != 0) {
                        i6 = iNSTANCE;
                    } else {
                        i6 = onTextLayout;
                    }
                    if (i31 != 0) {
                        obj37 = modifier2;
                        ComposerKt.sourceInformationMarkerStart(restartGroup, -1242857875, "CC(remember):BasicTextField.kt#9igjgp");
                        iNSTANCE = restartGroup;
                        i30 = 0;
                        obj38 = i57;
                        Object rememberedValue = iNSTANCE.rememberedValue();
                        i24 = 0;
                        obj50 = $i$a$CacheBasicTextFieldKt$BasicTextField$17;
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            int i83 = 0;
                            iNSTANCE.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                        } else {
                            $i$a$CacheBasicTextFieldKt$BasicTextField$17 = rememberedValue;
                        }
                        modifier3 = $i$a$CacheBasicTextFieldKt$BasicTextField$17;
                        ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    } else {
                        obj37 = modifier2;
                        obj50 = $i$a$CacheBasicTextFieldKt$BasicTextField$17;
                        modifier3 = interactionSource;
                    }
                    if (i8 != 0) {
                        iNSTANCE = Color.Companion;
                        obj38 = modifier3;
                        $i$a$CacheBasicTextFieldKt$BasicTextField$17 = new SolidColor(iNSTANCE.getBlack-0d7_KjU(), iNSTANCE, 0);
                        i30 = modifier3;
                    } else {
                        obj38 = modifier3;
                        i30 = cursorBrush;
                    }
                    if (i12 != 0) {
                        i24 = modifier3;
                    } else {
                        i24 = decorationBox;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-560482651, $dirty2, $dirty1, "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:847)");
                    }
                    Object obj16 = obj4;
                    i12 = obj38;
                    i28 = $dirty2;
                    i = $dirty1;
                    Object $dirty12 = obj37;
                    boolean z3 = obj50;
                    BasicTextFieldKt.BasicTextField(obj7, onValueChange, $dirty12, z3, readOnly3, textStyle2, obj16, obj5, i29, i23, 1, obj2, i6, i12, i30, i24, restartGroup, i50 | i75, i56 | i15, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj6 = $dirty12;
                    $composer2 = z3;
                    $dirty = readOnly3;
                    modifier4 = textStyle2;
                    enabled2 = obj16;
                    readOnly2 = obj5;
                    textStyle3 = i29;
                    keyboardOptions2 = i23;
                    keyboardActions2 = obj2;
                    singleLine2 = i6;
                    maxLines2 = i12;
                    solidColor = i30;
                    visualTransformation2 = i24;
                } else {
                    restartGroup.skipToGroupEnd();
                    readOnly2 = iNSTANCE;
                    obj6 = obj15;
                    keyboardOptions2 = maxLines;
                    maxLines2 = interactionSource;
                    visualTransformation2 = decorationBox;
                    composer = restartGroup;
                    i28 = $dirty2;
                    i = $dirty1;
                    $composer2 = obj;
                    $dirty = default;
                    modifier4 = obj3;
                    enabled2 = obj4;
                    textStyle3 = singleLine;
                    keyboardActions2 = visualTransformation;
                    singleLine2 = onTextLayout;
                    solidColor = cursorBrush;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new BasicTextFieldKt.BasicTextField.18(value, onValueChange, obj6, $composer2, $dirty, modifier4, enabled2, readOnly2, textStyle3, keyboardOptions2, keyboardActions2, singleLine2, maxLines2, solidColor, visualTransformation2, $changed, $changed1, i19);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    public static final void BasicTextField(String value, Function1<? super String, Unit> onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, androidx.compose.foundation.text.KeyboardOptions keyboardOptions, androidx.compose.foundation.text.KeyboardActions keyboardActions, boolean singleLine, int maxLines, int minLines, VisualTransformation visualTransformation, Function1<? super TextLayoutResult, Unit> onTextLayout, MutableInteractionSource interactionSource, Brush cursorBrush, Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> decorationBox, Composer $composer, int $changed, int $changed1, int i20) {
        boolean z;
        int i3;
        int i19;
        Object i30;
        Object obj6;
        Object obj5;
        Object obj7;
        Object obj4;
        int skipping;
        int defaultsInvalid;
        boolean enabled2;
        Object enabled3;
        int i4;
        Object cursorBrush3;
        int i15;
        Object it$iv;
        Object endRestartGroup;
        int traceInProgress;
        int singleLine5;
        int black-0d7_KjU;
        int i29;
        Object mutableStateOf$default;
        Object textFieldValueState$delegate;
        int i18;
        Composer $this$cache$iv;
        Object mutableStateOf$default2;
        Object copy-3r_uNRQ$default;
        boolean z4;
        boolean $composer2;
        int $dirty2;
        Object $dirty;
        int $dirty12;
        Object $dirty1;
        int i27;
        int i5;
        int default;
        Object keyboardActions2;
        Object keyboardActions3;
        Object it$iv2;
        int invalid$iv;
        int i16;
        Object modifier2;
        int singleLine4;
        Object singleLine3;
        Composer composer;
        int textStyle3;
        Object obj9;
        int maxLines2;
        VisualTransformation maxLines3;
        int visualTransformation2;
        boolean z2;
        int minLines3;
        androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.6 minLines2;
        int onTextLayout2;
        Object obj2;
        int keyboardOptions2;
        VisualTransformation interactionSource4;
        boolean obj8;
        SolidColor readOnly3;
        androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.6 cursorBrush2;
        Object obj;
        int textStyle2;
        int i6;
        Object obj3;
        boolean traceInProgress2;
        SolidColor solidColor;
        int i24;
        VisualTransformation visualTransformation3;
        int i35;
        Function3 function3;
        int i11;
        int imeOptions$foundation_release;
        boolean changed3;
        Object i12;
        int i7;
        androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.6 onTextLayout4;
        boolean onTextLayout3;
        int i36;
        boolean z3;
        int readOnly2;
        int interactionSource2;
        Function3 interactionSource3;
        int i31;
        int i21;
        int i13;
        Composer $dirty13;
        int i33;
        int i;
        int companion;
        int companion2;
        int changed;
        int i8;
        Object i22;
        int singleLine2;
        int i14;
        int i28;
        int i23;
        int i25;
        int i26;
        int i34;
        int changed2;
        int i9;
        int i2;
        int i17;
        int i32;
        int i10;
        boolean changedInstance;
        ScopeUpdateScope scopeUpdateScope;
        boolean obj38;
        int obj39;
        int obj40;
        Object obj41;
        int obj42;
        int obj43;
        int obj44;
        Composer obj46;
        int obj47;
        int obj48;
        final Object obj11 = onValueChange;
        int i37 = $changed;
        black-0d7_KjU = $changed1;
        int i59 = i20;
        Composer restartGroup = $composer.startRestartGroup(945255183);
        ComposerKt.sourceInformation(restartGroup, "C(BasicTextField)P(14,10,8,2,11,13,5,4,12,6,7,15,9,3)614@31167L57,620@31520L216,620@31509L227,629@32057L41,633@32175L373,631@32104L1032:BasicTextField.kt#423gt5");
        $dirty2 = $changed;
        $dirty12 = $changed1;
        if (i59 & 1 != 0) {
            $dirty2 |= 6;
        } else {
            if (i37 & 6 == 0) {
                i27 = restartGroup.changed(value) ? 4 : 2;
                $dirty2 |= i27;
            }
        }
        if (i59 & 2 != 0) {
            $dirty2 |= 48;
        } else {
            if (i37 & 48 == 0) {
                i5 = restartGroup.changedInstance(obj11) ? 32 : 16;
                $dirty2 |= i5;
            }
        }
        default = i59 & 4;
        if (default != 0) {
            $dirty2 |= 384;
            obj3 = modifier;
        } else {
            if (i37 & 384 == 0) {
                i24 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty2 |= i24;
            } else {
                obj3 = modifier;
            }
        }
        visualTransformation3 = i59 & 8;
        changed3 = 1024;
        if (visualTransformation3 != 0) {
            $dirty2 |= 3072;
            z2 = enabled;
        } else {
            if (i37 & 3072 == 0) {
                i7 = restartGroup.changed(enabled) ? i11 : changed3;
                $dirty2 |= i7;
            } else {
                z2 = enabled;
            }
        }
        onTextLayout3 = i59 & 16;
        interactionSource3 = 8192;
        if (onTextLayout3 != 0) {
            $dirty2 |= 24576;
            obj8 = readOnly;
        } else {
            if (i37 & 24576 == 0) {
                i33 = restartGroup.changed(readOnly) ? i36 : interactionSource3;
                $dirty2 |= i33;
            } else {
                obj8 = readOnly;
            }
        }
        i = i59 & 32;
        companion2 = 196608;
        if (i != 0) {
            $dirty2 |= companion2;
            obj = textStyle;
        } else {
            if (i37 & companion2 == 0) {
                i8 = restartGroup.changed(textStyle) ? 131072 : 65536;
                $dirty2 |= i8;
            } else {
                obj = textStyle;
            }
        }
        i22 = i59 & 64;
        singleLine2 = 1572864;
        if (i22 != 0) {
            $dirty2 |= singleLine2;
            obj2 = keyboardOptions;
        } else {
            if (i37 & singleLine2 == 0) {
                i14 = restartGroup.changed(keyboardOptions) ? 1048576 : 524288;
                $dirty2 |= i14;
            } else {
                obj2 = keyboardOptions;
            }
        }
        int i65 = i59 & 128;
        i23 = 12582912;
        if (i65 != 0) {
            $dirty2 |= i23;
            obj9 = keyboardActions;
        } else {
            if (i37 & i23 == 0) {
                i25 = restartGroup.changed(keyboardActions) ? 8388608 : 4194304;
                $dirty2 |= i25;
            } else {
                obj9 = keyboardActions;
            }
        }
        int i38 = i59 & 256;
        int i111 = 100663296;
        if (i38 != 0) {
            $dirty2 |= i111;
            i26 = i38;
            z = singleLine;
        } else {
            if ($changed & i111 == 0) {
                i26 = i38;
                i34 = restartGroup.changed(singleLine) ? 67108864 : 33554432;
                $dirty2 |= i34;
            } else {
                i26 = i38;
                z = singleLine;
            }
        }
        if ($changed & i113 == 0) {
            if (i59 & 512 == 0) {
                changed2 = restartGroup.changed(maxLines) ? 536870912 : 268435456;
            } else {
                i3 = maxLines;
            }
            $dirty2 |= changed2;
        } else {
            i3 = maxLines;
        }
        int i40 = i59 & 1024;
        if (i40 != 0) {
            $dirty12 |= 6;
            i9 = i40;
            i19 = minLines;
        } else {
            if (black-0d7_KjU & 6 == 0) {
                i9 = i40;
                i2 = restartGroup.changed(minLines) ? 4 : 2;
                $dirty12 |= i2;
            } else {
                i9 = i40;
                i19 = minLines;
            }
        }
        int i41 = i59 & 2048;
        if (i41 != 0) {
            $dirty12 |= 48;
            i17 = i41;
            i30 = visualTransformation;
        } else {
            if (black-0d7_KjU & 48 == 0) {
                i17 = i41;
                i32 = restartGroup.changed(visualTransformation) ? 32 : 16;
                $dirty12 |= i32;
            } else {
                i17 = i41;
                i30 = visualTransformation;
            }
        }
        int i42 = i59 & 4096;
        if (i42 != 0) {
            $dirty12 |= 384;
            i10 = i42;
            obj6 = onTextLayout;
        } else {
            i10 = i42;
            if (black-0d7_KjU & 384 == 0) {
                i31 = restartGroup.changedInstance(onTextLayout) ? 256 : 128;
                $dirty12 |= i31;
            } else {
                obj6 = onTextLayout;
            }
        }
        int i44 = i59 & 8192;
        if (i44 != 0) {
            $dirty12 |= 3072;
            i21 = i44;
            obj5 = interactionSource;
        } else {
            i21 = i44;
            if (black-0d7_KjU & 3072 == 0) {
                if (restartGroup.changed(interactionSource)) {
                } else {
                    i11 = changed3;
                }
                $dirty12 |= i11;
            } else {
                obj5 = interactionSource;
            }
        }
        int i45 = i59 & 16384;
        if (i45 != 0) {
            $dirty12 |= 24576;
            imeOptions$foundation_release = i45;
            obj7 = cursorBrush;
        } else {
            imeOptions$foundation_release = i45;
            if (black-0d7_KjU & 24576 == 0) {
                if (restartGroup.changed(cursorBrush)) {
                } else {
                    i36 = interactionSource3;
                }
                $dirty12 |= i36;
            } else {
                obj7 = cursorBrush;
            }
        }
        i12 = i59 & i107;
        if (i12 != 0) {
            $dirty12 |= companion2;
            obj4 = decorationBox;
        } else {
            if (black-0d7_KjU & companion2 == 0) {
                i36 = restartGroup.changedInstance(decorationBox) ? 131072 : 65536;
                $dirty12 |= i36;
            } else {
                obj4 = decorationBox;
            }
        }
        if ($dirty2 & i108 == 306783378 && i48 &= $dirty12 == 74898) {
            if (i48 &= $dirty12 == 74898) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    int i109 = 1;
                    if ($changed & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if (default != 0) {
                                obj3 = defaultsInvalid;
                            }
                            enabled2 = visualTransformation3 != 0 ? 1 : z2;
                            if (onTextLayout3 != 0) {
                                obj8 = default;
                            }
                            if (i != 0) {
                                obj = default;
                            }
                            if (i22 != 0) {
                                obj2 = default;
                            }
                            if (i65 != 0) {
                                keyboardActions2 = KeyboardActions.Companion.getDefault();
                            } else {
                                keyboardActions2 = obj9;
                            }
                            singleLine4 = i26 != 0 ? 0 : singleLine;
                            if (i59 & 512 != 0) {
                                maxLines2 = singleLine4 != 0 ? i109 : 0x7fffffff /* Unknown resource */;
                                $dirty2 &= z2;
                            } else {
                                maxLines2 = maxLines;
                            }
                            minLines3 = i9 != 0 ? 1 : minLines;
                            if (i17 != 0) {
                                visualTransformation3 = VisualTransformation.Companion.getNone();
                            } else {
                                visualTransformation3 = visualTransformation;
                            }
                            if (i10 != 0) {
                                onTextLayout4 = BasicTextFieldKt.BasicTextField.6.INSTANCE;
                            } else {
                                onTextLayout4 = onTextLayout;
                            }
                            interactionSource2 = i21 != 0 ? 0 : interactionSource;
                            if (imeOptions$foundation_release != 0) {
                                obj38 = enabled2;
                                traceInProgress = new SolidColor(Color.Companion.getBlack-0d7_KjU(), i59, 0);
                                enabled3 = traceInProgress;
                            } else {
                                obj38 = enabled2;
                                enabled3 = cursorBrush;
                            }
                            if (i12 != 0) {
                                readOnly3 = enabled3;
                                cursorBrush3 = obj2;
                                keyboardOptions2 = interactionSource2;
                                interactionSource3 = lambda-1$foundation_release;
                                singleLine5 = singleLine4;
                                singleLine3 = obj;
                                textStyle2 = i109;
                                z3 = z5;
                                i12 = keyboardActions2;
                                i29 = maxLines2;
                                i18 = minLines3;
                                keyboardActions3 = obj3;
                                maxLines3 = visualTransformation3;
                                minLines2 = onTextLayout4;
                                onTextLayout3 = obj38;
                            } else {
                                i12 = keyboardActions2;
                                singleLine5 = singleLine4;
                                i29 = maxLines2;
                                i18 = minLines3;
                                singleLine3 = obj;
                                keyboardActions3 = obj3;
                                maxLines3 = visualTransformation3;
                                minLines2 = onTextLayout4;
                                textStyle2 = i109;
                                onTextLayout3 = obj38;
                                z3 = obj8;
                                readOnly3 = enabled3;
                                cursorBrush3 = obj2;
                                keyboardOptions2 = interactionSource2;
                                interactionSource3 = decorationBox;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            if (i59 & 512 != 0) {
                                $dirty2 &= i4;
                            }
                            singleLine5 = singleLine;
                            i29 = maxLines;
                            i18 = minLines;
                            interactionSource3 = decorationBox;
                            i12 = obj9;
                            onTextLayout3 = z2;
                            cursorBrush3 = obj2;
                            singleLine3 = obj;
                            keyboardActions3 = obj3;
                            textStyle2 = i109;
                            maxLines3 = visualTransformation;
                            minLines2 = onTextLayout;
                            keyboardOptions2 = interactionSource;
                            z3 = obj8;
                            readOnly3 = cursorBrush;
                        }
                    } else {
                    }
                    restartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(945255183, $dirty2, $dirty12, "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:611)");
                    }
                    String str3 = "CC(remember):BasicTextField.kt#9igjgp";
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1243232097, str3);
                    int i87 = 0;
                    obj46 = restartGroup;
                    int i100 = 0;
                    obj47 = i29;
                    mutableStateOf$default = obj46.rememberedValue();
                    int i104 = 0;
                    obj48 = i18;
                    if (mutableStateOf$default == Composer.Companion.getEmpty()) {
                        obj38 = textFieldValue2;
                        super(value, 0, textStyle, 0, 6, 0);
                        obj38 = obj39;
                        obj39 = i60;
                        i13 = $dirty12;
                        int $i$a$CacheBasicTextFieldKt$BasicTextField$textFieldValueState$2 = 0;
                        obj46.updateRememberedValue(SnapshotStateKt.mutableStateOf$default(obj38, $i$a$CacheBasicTextFieldKt$BasicTextField$textFieldValueState$2, 2, $i$a$CacheBasicTextFieldKt$BasicTextField$textFieldValueState$2));
                    } else {
                        $this$cache$iv = obj46;
                        obj38 = mutableStateOf$default;
                        i13 = $dirty12;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    obj39 = value;
                    copy-3r_uNRQ$default = TextFieldValue.copy-3r_uNRQ$default(BasicTextFieldKt.BasicTextField$lambda$21((MutableState)mutableStateOf$default), obj39, 0, textStyle, 0, 6);
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1243220642, str3);
                    obj38 = restartGroup;
                    int i102 = 0;
                    it$iv2 = obj38.rememberedValue();
                    int i105 = 0;
                    if (!restartGroup.changed(copy-3r_uNRQ$default)) {
                        obj40 = singleLine3;
                        if (it$iv2 == Composer.Companion.getEmpty()) {
                            int textStyle4 = 0;
                            obj41 = it$iv2;
                            it$iv2 = new BasicTextFieldKt.BasicTextField.7.1(copy-3r_uNRQ$default, mutableStateOf$default);
                            obj38.updateRememberedValue((Function0)it$iv2);
                        } else {
                            composer = obj38;
                            obj41 = it$iv2;
                        }
                    } else {
                        obj40 = singleLine3;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    int i66 = 0;
                    EffectsKt.SideEffect((Function0)it$iv2, restartGroup, i66);
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1243203633, str3);
                    invalid$iv = $dirty2 & 14 == 4 ? 1 : i66;
                    Composer composer3 = restartGroup;
                    int i103 = 0;
                    Object rememberedValue = composer3.rememberedValue();
                    int i106 = 0;
                    if (invalid$iv == 0) {
                        obj41 = copy-3r_uNRQ$default;
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            obj42 = textFieldValue;
                            obj43 = invalid$iv;
                            int $i$a$CacheBasicTextFieldKt$BasicTextField$lastTextValue$2 = 0;
                            composer3.updateRememberedValue(SnapshotStateKt.mutableStateOf$default(obj39, $i$a$CacheBasicTextFieldKt$BasicTextField$lastTextValue$2, 2, $i$a$CacheBasicTextFieldKt$BasicTextField$lastTextValue$2));
                        } else {
                            obj43 = invalid$iv;
                            mutableStateOf$default2 = rememberedValue;
                        }
                    } else {
                        obj41 = copy-3r_uNRQ$default;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    i35 = singleLine5 != 0 ? 1 : obj48;
                    i16 = singleLine5 != 0 ? 1 : obj47;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1243199525, str3);
                    i15 = $dirty2 & 112 == 32 ? 1 : 0;
                    Composer composer2 = restartGroup;
                    int i93 = 0;
                    it$iv = composer2.rememberedValue();
                    int i110 = 0;
                    if (i15 |= changed5 == 0) {
                        singleLine2 = singleLine5;
                        if (it$iv == Composer.Companion.getEmpty()) {
                            singleLine5 = 0;
                            obj42 = it$iv;
                            it$iv = new BasicTextFieldKt.BasicTextField.8.1(obj11, mutableStateOf$default, mutableStateOf$default2);
                            composer2.updateRememberedValue((Function1)it$iv);
                        } else {
                            obj42 = it$iv;
                        }
                    } else {
                        singleLine2 = singleLine5;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    Object obj14 = obj40;
                    i28 = i13;
                    Object obj13 = obj39;
                    CoreTextFieldKt.CoreTextField(obj41, (Function1)it$iv, obj13, obj14, maxLines3, minLines2, keyboardOptions2, readOnly3, singleLine5 ^ 1, i16, i35, cursorBrush3.toImeOptions$foundation_release(singleLine5), i12, onTextLayout3, z3, interactionSource3, restartGroup, i54 | i77, i58 | i82, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    textFieldValueState$delegate = obj13;
                    $dirty = obj14;
                    i6 = keyboardOptions2;
                    solidColor = readOnly3;
                    modifier2 = i12;
                    z4 = onTextLayout3;
                    $composer2 = z3;
                    function3 = interactionSource3;
                    $dirty1 = i22;
                    textStyle3 = singleLine2;
                    readOnly2 = skipping;
                    interactionSource4 = maxLines3;
                    cursorBrush2 = minLines2;
                    visualTransformation2 = obj47;
                    onTextLayout2 = obj48;
                } else {
                    restartGroup.skipToGroupEnd();
                    textStyle3 = singleLine;
                    function3 = decorationBox;
                    $dirty13 = restartGroup;
                    readOnly2 = $dirty2;
                    i28 = $dirty12;
                    modifier2 = obj9;
                    z4 = z2;
                    $dirty1 = obj2;
                    $composer2 = obj8;
                    $dirty = obj;
                    textFieldValueState$delegate = obj3;
                    visualTransformation2 = maxLines;
                    onTextLayout2 = minLines;
                    interactionSource4 = visualTransformation;
                    cursorBrush2 = onTextLayout;
                    i6 = interactionSource;
                    solidColor = cursorBrush;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = $dirty13.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new BasicTextFieldKt.BasicTextField.9(value, obj11, textFieldValueState$delegate, z4, $composer2, $dirty, $dirty1, modifier2, textStyle3, visualTransformation2, onTextLayout2, interactionSource4, cursorBrush2, i6, solidColor, function3, $changed, $changed1, i20);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    public static final void BasicTextField(String value, Function1 onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, androidx.compose.foundation.text.KeyboardOptions keyboardOptions, androidx.compose.foundation.text.KeyboardActions keyboardActions, boolean singleLine, int maxLines, VisualTransformation visualTransformation, Function1 onTextLayout, MutableInteractionSource interactionSource, Brush cursorBrush, Function3 decorationBox, Composer $composer, int $changed, int $changed1, int i19) {
        boolean z;
        int i6;
        Object obj9;
        Object obj13;
        Object obj4;
        Object obj5;
        Object obj12;
        int traceInProgress2;
        Object modifier3;
        Object modifier4;
        boolean traceInProgress;
        Object endRestartGroup;
        int i10;
        boolean $i$a$CacheBasicTextFieldKt$BasicTextField$14;
        int black-0d7_KjU;
        Object iNSTANCE;
        Object obj14;
        boolean $composer2;
        int $dirty2;
        boolean $dirty;
        int $dirty1;
        Object modifier2;
        Object obj6;
        Object enabled2;
        Object obj10;
        boolean readOnly3;
        Object readOnly2;
        boolean obj7;
        Object textStyle3;
        int textStyle2;
        int i16;
        Object obj;
        int keyboardOptions2;
        boolean default;
        Object obj3;
        VisualTransformation keyboardActions2;
        Object obj8;
        int i27;
        androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.13 singleLine2;
        int i9;
        int i30;
        Object maxLines2;
        Object obj11;
        SolidColor solidColor;
        Object obj2;
        Function3 visualTransformation2;
        int i25;
        Object i12;
        int i7;
        int i26;
        int changedInstance;
        int i24;
        int i32;
        int i15;
        int i11;
        int companion;
        Composer composer;
        int i5;
        int i13;
        int i22;
        int i;
        int i4;
        int i29;
        int changed2;
        int i23;
        int i28;
        int i14;
        int changed;
        int i18;
        int i2;
        int i17;
        int i31;
        int i20;
        int i3;
        int i8;
        int i21;
        boolean changedInstance2;
        ScopeUpdateScope scopeUpdateScope;
        Object obj37;
        int obj38;
        boolean obj50;
        int i33 = $changed;
        int i60 = $changed1;
        black-0d7_KjU = i19;
        Composer restartGroup = $composer.startRestartGroup(-454732590);
        ComposerKt.sourceInformation(restartGroup, "C(BasicTextField)P(13,9,7,2,10,12,5,4,11,6,14,8,3)803@41337L39,808@41577L579:BasicTextField.kt#423gt5");
        $dirty2 = $changed;
        $dirty1 = $changed1;
        if (black-0d7_KjU & 1 != 0) {
            $dirty2 |= 6;
            obj6 = value;
        } else {
            if (i33 & 6 == 0) {
                i16 = restartGroup.changed(value) ? 4 : 2;
                $dirty2 |= i16;
            } else {
                obj6 = value;
            }
        }
        if (black-0d7_KjU & 2 != 0) {
            $dirty2 |= 48;
            obj = onValueChange;
        } else {
            if (i33 & 48 == 0) {
                i9 = restartGroup.changedInstance(onValueChange) ? 32 : 16;
                $dirty2 |= i9;
            } else {
                obj = onValueChange;
            }
        }
        int i94 = black-0d7_KjU & 4;
        if (i94 != 0) {
            $dirty2 |= 384;
            obj10 = modifier;
        } else {
            if (i33 & 384 == 0) {
                i25 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty2 |= i25;
            } else {
                obj10 = modifier;
            }
        }
        i12 = black-0d7_KjU & 8;
        changedInstance = 1024;
        if (i12 != 0) {
            $dirty2 |= 3072;
            obj7 = enabled;
        } else {
            if (i33 & 3072 == 0) {
                i11 = restartGroup.changed(enabled) ? i7 : changedInstance;
                $dirty2 |= i11;
            } else {
                obj7 = enabled;
            }
        }
        companion = black-0d7_KjU & 16;
        i13 = 8192;
        if (companion != 0) {
            $dirty2 |= 24576;
            default = readOnly;
        } else {
            if (i33 & 24576 == 0) {
                i4 = restartGroup.changed(readOnly) ? i5 : i13;
                $dirty2 |= i4;
            } else {
                default = readOnly;
            }
        }
        int i97 = black-0d7_KjU & 32;
        changed2 = 196608;
        if (i97 != 0) {
            $dirty2 |= changed2;
            obj8 = textStyle;
        } else {
            if (i33 & changed2 == 0) {
                i14 = restartGroup.changed(textStyle) ? 131072 : 65536;
                $dirty2 |= i14;
            } else {
                obj8 = textStyle;
            }
        }
        int i98 = black-0d7_KjU & 64;
        changed = 1572864;
        if (i98 != 0) {
            $dirty2 |= changed;
            obj11 = keyboardOptions;
        } else {
            if (i33 & changed == 0) {
                i18 = restartGroup.changed(keyboardOptions) ? 1048576 : 524288;
                $dirty2 |= i18;
            } else {
                obj11 = keyboardOptions;
            }
        }
        int i95 = black-0d7_KjU & 128;
        i2 = 12582912;
        if (i95 != 0) {
            $dirty2 |= i2;
            iNSTANCE = keyboardActions;
        } else {
            if (i33 & i2 == 0) {
                i17 = restartGroup.changed(keyboardActions) ? 8388608 : 4194304;
                $dirty2 |= i17;
            } else {
                iNSTANCE = keyboardActions;
            }
        }
        int i34 = black-0d7_KjU & 256;
        int i99 = 100663296;
        if (i34 != 0) {
            $dirty2 |= i99;
            i31 = i34;
            z = singleLine;
        } else {
            if ($changed & i99 == 0) {
                i31 = i34;
                i20 = restartGroup.changed(singleLine) ? 67108864 : 33554432;
                $dirty2 |= i20;
            } else {
                i31 = i34;
                z = singleLine;
            }
        }
        int i35 = black-0d7_KjU & 512;
        int i101 = 805306368;
        if (i35 != 0) {
            $dirty2 |= i101;
            i3 = i35;
            i6 = maxLines;
        } else {
            if ($changed & i101 == 0) {
                i3 = i35;
                i8 = restartGroup.changed(maxLines) ? 536870912 : 268435456;
                $dirty2 |= i8;
            } else {
                i3 = i35;
                i6 = maxLines;
            }
        }
        int i36 = black-0d7_KjU & 1024;
        if (i36 != 0) {
            $dirty1 |= 6;
            i21 = i36;
            obj9 = visualTransformation;
        } else {
            if (i60 & 6 == 0) {
                i21 = i36;
                i32 = restartGroup.changed(visualTransformation) ? 4 : 2;
                $dirty1 |= i32;
            } else {
                i21 = i36;
                obj9 = visualTransformation;
            }
        }
        int i37 = black-0d7_KjU & 2048;
        if (i37 != 0) {
            $dirty1 |= 48;
            i15 = i37;
            obj13 = onTextLayout;
        } else {
            if (i60 & 48 == 0) {
                i15 = i37;
                i22 = restartGroup.changedInstance(onTextLayout) ? 32 : 16;
                $dirty1 |= i22;
            } else {
                i15 = i37;
                obj13 = onTextLayout;
            }
        }
        int i38 = black-0d7_KjU & 4096;
        if (i38 != 0) {
            $dirty1 |= 384;
            i = i38;
            obj4 = interactionSource;
        } else {
            i = i38;
            if (i60 & 384 == 0) {
                changed = restartGroup.changed(interactionSource) ? 256 : 128;
                $dirty1 |= changed;
            } else {
                obj4 = interactionSource;
            }
        }
        int i40 = black-0d7_KjU & 8192;
        if (i40 != 0) {
            $dirty1 |= 3072;
            i23 = i40;
            obj5 = cursorBrush;
        } else {
            i23 = i40;
            if (i60 & 3072 == 0) {
                if (restartGroup.changed(cursorBrush)) {
                } else {
                    i7 = changedInstance;
                }
                $dirty1 |= i7;
            } else {
                obj5 = cursorBrush;
            }
        }
        int i41 = black-0d7_KjU & 16384;
        if (i41 != 0) {
            $dirty1 |= 24576;
            i26 = i41;
            obj12 = decorationBox;
        } else {
            i26 = i41;
            if (i60 & 24576 == 0) {
                if (restartGroup.changedInstance(decorationBox)) {
                } else {
                    i5 = i13;
                }
                $dirty1 |= i5;
            } else {
                obj12 = decorationBox;
            }
        }
        if ($dirty2 & i24 == 306783378 && $dirty1 & 9363 == 9362) {
            if ($dirty1 & 9363 == 9362) {
                if (!restartGroup.getSkipping()) {
                    if (i94 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = obj10;
                    }
                    $i$a$CacheBasicTextFieldKt$BasicTextField$14 = i12 != 0 ? 1 : obj7;
                    readOnly3 = companion != 0 ? 0 : default;
                    if (i97 != 0) {
                        textStyle3 = TextStyle.Companion.getDefault();
                    } else {
                        textStyle3 = obj8;
                    }
                    if (i98 != 0) {
                        obj11 = default;
                    }
                    if (i95 != 0) {
                        obj3 = iNSTANCE;
                    } else {
                        obj3 = iNSTANCE;
                    }
                    i27 = i31 != 0 ? iNSTANCE : singleLine;
                    i30 = i3 != 0 ? iNSTANCE : maxLines;
                    if (i21 != 0) {
                        obj2 = iNSTANCE;
                    } else {
                        obj2 = visualTransformation;
                    }
                    if (i15 != 0) {
                        i12 = iNSTANCE;
                    } else {
                        i12 = onTextLayout;
                    }
                    if (i != 0) {
                        obj37 = modifier3;
                        ComposerKt.sourceInformationMarkerStart(restartGroup, -1242906675, "CC(remember):BasicTextField.kt#9igjgp");
                        iNSTANCE = restartGroup;
                        i24 = 0;
                        obj38 = i57;
                        Object rememberedValue = iNSTANCE.rememberedValue();
                        i15 = 0;
                        obj50 = $i$a$CacheBasicTextFieldKt$BasicTextField$14;
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            int i83 = 0;
                            iNSTANCE.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                        } else {
                            $i$a$CacheBasicTextFieldKt$BasicTextField$14 = rememberedValue;
                        }
                        modifier4 = $i$a$CacheBasicTextFieldKt$BasicTextField$14;
                        ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    } else {
                        obj37 = modifier3;
                        obj50 = $i$a$CacheBasicTextFieldKt$BasicTextField$14;
                        modifier4 = interactionSource;
                    }
                    if (i23 != 0) {
                        iNSTANCE = Color.Companion;
                        obj38 = modifier4;
                        $i$a$CacheBasicTextFieldKt$BasicTextField$14 = new SolidColor(iNSTANCE.getBlack-0d7_KjU(), iNSTANCE, 0);
                        i24 = modifier4;
                    } else {
                        obj38 = modifier4;
                        i24 = cursorBrush;
                    }
                    if (i26 != 0) {
                        i15 = modifier4;
                    } else {
                        i15 = decorationBox;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-454732590, $dirty2, $dirty1, "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:807)");
                    }
                    Object obj16 = obj11;
                    i26 = obj38;
                    i28 = $dirty2;
                    i29 = $dirty1;
                    Object $dirty12 = obj37;
                    boolean z3 = obj50;
                    BasicTextFieldKt.BasicTextField(obj6, onValueChange, $dirty12, z3, readOnly3, textStyle3, obj16, obj3, i27, i30, 1, obj2, i12, i26, i24, i15, restartGroup, i50 | i75, i56 | i10, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj14 = $dirty12;
                    $composer2 = z3;
                    $dirty = readOnly3;
                    modifier2 = textStyle3;
                    enabled2 = obj16;
                    readOnly2 = obj3;
                    textStyle2 = i27;
                    keyboardOptions2 = i30;
                    keyboardActions2 = obj2;
                    singleLine2 = i12;
                    maxLines2 = i26;
                    solidColor = i24;
                    visualTransformation2 = i15;
                } else {
                    restartGroup.skipToGroupEnd();
                    readOnly2 = iNSTANCE;
                    obj14 = obj15;
                    keyboardOptions2 = maxLines;
                    maxLines2 = interactionSource;
                    visualTransformation2 = decorationBox;
                    composer = restartGroup;
                    i28 = $dirty2;
                    i29 = $dirty1;
                    $composer2 = obj7;
                    $dirty = default;
                    modifier2 = obj8;
                    enabled2 = obj11;
                    textStyle2 = singleLine;
                    keyboardActions2 = visualTransformation;
                    singleLine2 = onTextLayout;
                    solidColor = cursorBrush;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new BasicTextFieldKt.BasicTextField.15(value, onValueChange, obj14, $composer2, $dirty, modifier2, enabled2, readOnly2, textStyle2, keyboardOptions2, keyboardActions2, singleLine2, maxLines2, solidColor, visualTransformation2, $changed, $changed1, i19);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    private static final TextFieldValue BasicTextField$lambda$21(MutableState<TextFieldValue> $textFieldValueState$delegate) {
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (TextFieldValue)(State)$textFieldValueState$delegate.getValue();
    }

    private static final void BasicTextField$lambda$22(MutableState<TextFieldValue> $textFieldValueState$delegate, TextFieldValue value) {
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        $textFieldValueState$delegate.setValue(value);
    }

    private static final String BasicTextField$lambda$25(MutableState<String> $lastTextValue$delegate) {
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (String)(State)$lastTextValue$delegate.getValue();
    }

    private static final void BasicTextField$lambda$26(MutableState<String> $lastTextValue$delegate, String value) {
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        $lastTextValue$delegate.setValue(value);
    }

    public static final void TextFieldCursorHandle(TextFieldSelectionState selectionState, Composer $composer, int $changed) {
        int invalid$iv;
        int i2;
        int traceInProgress2;
        boolean traceInProgress;
        Object obj;
        int pointerInput;
        long minTouchTargetSizeForHandles;
        int rememberedValue;
        int i3;
        Object $i$a$CacheBasicTextFieldKt$TextFieldCursorHandle$cursorHandleState$2;
        androidx.compose.foundation.text.BasicTextFieldKt.TextFieldCursorHandle.cursorHandleState.2.1 empty;
        Object anon2;
        Object anon;
        int i;
        int obj13;
        invalid$iv = 1991581797;
        final Composer restartGroup = $composer.startRestartGroup(invalid$iv);
        ComposerKt.sourceInformation(restartGroup, "C(TextFieldCursorHandle)416@20789L124:BasicTextField.kt#423gt5");
        pointerInput = 2;
        if ($changed & 6 == 0) {
            i2 = restartGroup.changedInstance(selectionState) ? 4 : pointerInput;
            obj13 |= i2;
        }
        if (obj13 & 3 == pointerInput) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(invalid$iv, obj13, -1, "androidx.compose.foundation.text.TextFieldCursorHandle (BasicTextField.kt:414)");
                }
                String str = "CC(remember):BasicTextField.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -425876736, str);
                int i5 = 0;
                Composer composer = restartGroup;
                minTouchTargetSizeForHandles = 0;
                rememberedValue = composer.rememberedValue();
                i3 = 0;
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    int i10 = 0;
                    empty = new BasicTextFieldKt.TextFieldCursorHandle.cursorHandleState.2.1(selectionState);
                    composer.updateRememberedValue(SnapshotStateKt.derivedStateOf((Function0)empty));
                } else {
                    $i$a$CacheBasicTextFieldKt$TextFieldCursorHandle$cursorHandleState$2 = rememberedValue;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (BasicTextFieldKt.TextFieldCursorHandle$lambda$9((State)$i$a$CacheBasicTextFieldKt$TextFieldCursorHandle$cursorHandleState$2).getVisible()) {
                    restartGroup.startReplaceGroup(-317108348);
                    ComposerKt.sourceInformation(restartGroup, "423@21002L142,429@21224L87,422@20959L426");
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -425869902, str);
                    Composer composer2 = restartGroup;
                    int i9 = 0;
                    Object rememberedValue2 = composer2.rememberedValue();
                    int i11 = 0;
                    if (!restartGroup.changedInstance(selectionState)) {
                        if (rememberedValue2 == Composer.Companion.getEmpty()) {
                            empty = 0;
                            anon2 = new BasicTextFieldKt.TextFieldCursorHandle.1.1(selectionState);
                            composer2.updateRememberedValue((OffsetProvider)anon2);
                        } else {
                            anon2 = rememberedValue2;
                        }
                    } else {
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -425862853, str);
                    Composer composer3 = restartGroup;
                    Object rememberedValue3 = composer3.rememberedValue();
                    int i12 = 0;
                    if (!restartGroup.changedInstance(selectionState)) {
                        if (rememberedValue3 == Composer.Companion.getEmpty()) {
                            empty = 0;
                            anon = new BasicTextFieldKt.TextFieldCursorHandle.2.1(selectionState, 0);
                            composer3.updateRememberedValue((Function2)anon);
                        } else {
                            anon = rememberedValue3;
                        }
                    } else {
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    AndroidCursorHandle_androidKt.CursorHandle-USBMPiE((OffsetProvider)anon2, SuspendingPointerInputFilterKt.pointerInput((Modifier)Modifier.Companion, selectionState, (Function2)anon), BasicTextFieldKt.MinTouchTargetSizeForHandles, 0, restartGroup, 384);
                    restartGroup.endReplaceGroup();
                } else {
                    restartGroup.startReplaceGroup(-316683586);
                    restartGroup.endReplaceGroup();
                }
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
            traceInProgress2 = new BasicTextFieldKt.TextFieldCursorHandle.3(selectionState, $changed);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    private static final TextFieldHandleState TextFieldCursorHandle$lambda$9(State<TextFieldHandleState> $cursorHandleState$delegate) {
        int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (TextFieldHandleState)$cursorHandleState$delegate.getValue();
    }

    public static final void TextFieldSelectionHandles(TextFieldSelectionState selectionState, Composer $composer, int $changed) {
        Object startHandleState$delegate2;
        State invalid$iv2;
        int traceInProgress;
        int $dirty;
        int $dirty2;
        boolean traceInProgress2;
        Object invalid$iv;
        Object visible;
        int str;
        int i;
        Object rememberedValue2;
        Object rememberedValue;
        boolean handlesCrossed;
        boolean handlesCrossed2;
        Object $i$a$CacheBasicTextFieldKt$TextFieldSelectionHandles$startHandleState$2;
        Object $i$a$CacheBasicTextFieldKt$TextFieldSelectionHandles$endHandleState$2;
        androidx.compose.foundation.text.BasicTextFieldKt.TextFieldSelectionHandles.startHandleState.2.1 empty3;
        Object anon2;
        Modifier pointerInput;
        Object anon;
        int i2;
        int i3;
        Object empty2;
        Object empty;
        State startHandleState$delegate;
        Object endHandleState$delegate;
        final Object obj = selectionState;
        final int i4 = $changed;
        traceInProgress = 2025287684;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(TextFieldSelectionHandles)442@21589L149,465@22467L150:BasicTextField.kt#423gt5");
        rememberedValue = 2;
        if (i4 & 6 == 0) {
            str = restartGroup.changedInstance(obj) ? 4 : rememberedValue;
            $dirty |= str;
        }
        final int i25 = $dirty;
        if (i25 & 3 == rememberedValue) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, i25, -1, "androidx.compose.foundation.text.TextFieldSelectionHandles (BasicTextField.kt:440)");
                }
                empty2 = "CC(remember):BasicTextField.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1983345958, empty2);
                int i6 = 0;
                Composer composer = restartGroup;
                i = 0;
                rememberedValue2 = composer.rememberedValue();
                handlesCrossed = 0;
                if (rememberedValue2 == Composer.Companion.getEmpty()) {
                    int i15 = 0;
                    empty3 = new BasicTextFieldKt.TextFieldSelectionHandles.startHandleState.2.1(obj);
                    composer.updateRememberedValue(SnapshotStateKt.derivedStateOf((Function0)empty3));
                } else {
                    $i$a$CacheBasicTextFieldKt$TextFieldSelectionHandles$startHandleState$2 = rememberedValue2;
                }
                State invalid$iv3 = $i$a$CacheBasicTextFieldKt$TextFieldSelectionHandles$startHandleState$2;
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (BasicTextFieldKt.TextFieldSelectionHandles$lambda$13((State)invalid$iv3).getVisible()) {
                    restartGroup.startReplaceGroup(-1353986043);
                    ComposerKt.sourceInformation(restartGroup, "449@21829L167,457@22207L86,448@21783L584");
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1983338260, empty2);
                    Composer composer3 = restartGroup;
                    int i13 = 0;
                    Object rememberedValue3 = composer3.rememberedValue();
                    int i16 = 0;
                    if (!restartGroup.changedInstance(obj)) {
                        if (rememberedValue3 == Composer.Companion.getEmpty()) {
                            empty3 = 0;
                            anon2 = new BasicTextFieldKt.TextFieldSelectionHandles.1.1(obj);
                            composer3.updateRememberedValue((OffsetProvider)anon2);
                        } else {
                            anon2 = rememberedValue3;
                        }
                    } else {
                    }
                    invalid$iv = anon2;
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1983326245, empty2);
                    empty3 = restartGroup;
                    int i21 = 0;
                    Object rememberedValue5 = empty3.rememberedValue();
                    int i23 = 0;
                    if (!restartGroup.changedInstance(obj)) {
                        if (rememberedValue5 == Composer.Companion.getEmpty()) {
                            empty = 0;
                            startHandleState$delegate = invalid$iv3;
                            endHandleState$delegate = invalid$iv;
                            startHandleState$delegate2 = new BasicTextFieldKt.TextFieldSelectionHandles.2.1(obj, 0);
                            empty3.updateRememberedValue((Function2)startHandleState$delegate2);
                        } else {
                            startHandleState$delegate = invalid$iv3;
                            endHandleState$delegate = invalid$iv;
                            startHandleState$delegate2 = rememberedValue5;
                        }
                    } else {
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    AndroidSelectionHandles_androidKt.SelectionHandle-pzduO1o(endHandleState$delegate, true, BasicTextFieldKt.TextFieldSelectionHandles$lambda$13(invalid$iv3).getDirection(), BasicTextFieldKt.TextFieldSelectionHandles$lambda$13(invalid$iv3).getHandlesCrossed(), BasicTextFieldKt.MinTouchTargetSizeForHandles, empty3, SuspendingPointerInputFilterKt.pointerInput((Modifier)Modifier.Companion, obj, (Function2)startHandleState$delegate2), restartGroup, 24624);
                    restartGroup.endReplaceGroup();
                } else {
                    startHandleState$delegate = invalid$iv3;
                    restartGroup.startReplaceGroup(-1353409443);
                    restartGroup.endReplaceGroup();
                }
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1983317861, empty2);
                int i8 = 0;
                Composer composer2 = restartGroup;
                str = 0;
                rememberedValue = composer2.rememberedValue();
                handlesCrossed2 = 0;
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    int i18 = 0;
                    empty3 = new BasicTextFieldKt.TextFieldSelectionHandles.endHandleState.2.1(obj);
                    composer2.updateRememberedValue(SnapshotStateKt.derivedStateOf((Function0)empty3));
                } else {
                    $i$a$CacheBasicTextFieldKt$TextFieldSelectionHandles$endHandleState$2 = rememberedValue;
                }
                invalid$iv2 = $i$a$CacheBasicTextFieldKt$TextFieldSelectionHandles$endHandleState$2;
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (BasicTextFieldKt.TextFieldSelectionHandles$lambda$17((State)invalid$iv2).getVisible()) {
                    restartGroup.startReplaceGroup(-1353116090);
                    ComposerKt.sourceInformation(restartGroup, "472@22706L168,480@23082L87,471@22660L583");
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1983310195, empty2);
                    Composer composer4 = restartGroup;
                    int i14 = 0;
                    Object rememberedValue4 = composer4.rememberedValue();
                    int i19 = 0;
                    if (!restartGroup.changedInstance(obj)) {
                        if (rememberedValue4 == Composer.Companion.getEmpty()) {
                            empty3 = 0;
                            anon = new BasicTextFieldKt.TextFieldSelectionHandles.3.1(obj);
                            composer4.updateRememberedValue((OffsetProvider)anon);
                        } else {
                            anon = rememberedValue4;
                        }
                    } else {
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1983298244, empty2);
                    empty3 = restartGroup;
                    int i22 = 0;
                    Object rememberedValue6 = empty3.rememberedValue();
                    int i24 = 0;
                    if (!restartGroup.changedInstance(obj)) {
                        if (rememberedValue6 == Composer.Companion.getEmpty()) {
                            empty2 = 0;
                            endHandleState$delegate = invalid$iv2;
                            empty = new BasicTextFieldKt.TextFieldSelectionHandles.4.1(obj, 0);
                            empty3.updateRememberedValue((Function2)empty);
                        } else {
                            endHandleState$delegate = invalid$iv2;
                            empty = rememberedValue6;
                        }
                    } else {
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    AndroidSelectionHandles_androidKt.SelectionHandle-pzduO1o((OffsetProvider)anon, false, BasicTextFieldKt.TextFieldSelectionHandles$lambda$17(invalid$iv2).getDirection(), BasicTextFieldKt.TextFieldSelectionHandles$lambda$17(invalid$iv2).getHandlesCrossed(), BasicTextFieldKt.MinTouchTargetSizeForHandles, empty3, SuspendingPointerInputFilterKt.pointerInput((Modifier)Modifier.Companion, obj, (Function2)empty), restartGroup, 24624);
                    restartGroup.endReplaceGroup();
                } else {
                    endHandleState$delegate = invalid$iv2;
                    restartGroup.startReplaceGroup(-1352540451);
                    restartGroup.endReplaceGroup();
                }
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
            $dirty2 = new BasicTextFieldKt.TextFieldSelectionHandles.5(obj, i4);
            endRestartGroup.updateScope((Function2)$dirty2);
        }
    }

    private static final TextFieldHandleState TextFieldSelectionHandles$lambda$13(State<TextFieldHandleState> $startHandleState$delegate) {
        int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (TextFieldHandleState)$startHandleState$delegate.getValue();
    }

    private static final TextFieldHandleState TextFieldSelectionHandles$lambda$17(State<TextFieldHandleState> $endHandleState$delegate) {
        int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (TextFieldHandleState)$endHandleState$delegate.getValue();
    }

    public static final TextFieldValue access$BasicTextField$lambda$21(MutableState $textFieldValueState$delegate) {
        return BasicTextFieldKt.BasicTextField$lambda$21($textFieldValueState$delegate);
    }

    public static final void access$BasicTextField$lambda$22(MutableState $textFieldValueState$delegate, TextFieldValue value) {
        BasicTextFieldKt.BasicTextField$lambda$22($textFieldValueState$delegate, value);
    }

    public static final String access$BasicTextField$lambda$25(MutableState $lastTextValue$delegate) {
        return BasicTextFieldKt.BasicTextField$lambda$25($lastTextValue$delegate);
    }

    public static final void access$BasicTextField$lambda$26(MutableState $lastTextValue$delegate, String value) {
        BasicTextFieldKt.BasicTextField$lambda$26($lastTextValue$delegate, value);
    }

    public static final TextFieldDecorator access$getDefaultTextFieldDecorator$p() {
        return BasicTextFieldKt.DefaultTextFieldDecorator;
    }
}
