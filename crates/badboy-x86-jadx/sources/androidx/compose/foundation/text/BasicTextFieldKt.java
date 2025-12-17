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
        boolean traceInProgress;
        Object endRestartGroup;
        int scrollState2;
        int defaultsInvalid;
        boolean enabled2;
        Object obj9;
        Object obj6;
        Object obj5;
        Object obj;
        Object obj11;
        Object obj7;
        boolean changedInstance;
        Object obj12;
        int i4;
        int readOnly2;
        Object obj4;
        int i12;
        boolean traceInProgress2;
        boolean z3;
        Object default;
        boolean z;
        Object $composer2;
        int $dirty2;
        Object $dirty;
        int $dirty12;
        Object $dirty1;
        boolean $dirty13;
        Object obj3;
        int readOnly3;
        int i14;
        boolean z2;
        Object inputTransformation2;
        Object inputTransformation3;
        boolean companion;
        int textStyle3;
        Object onKeyboardAction3;
        int onKeyboardAction2;
        int i5;
        int keyboardOptions2;
        Object lineLimits3;
        TextFieldLineLimits lineLimits2;
        Object obj2;
        Object onKeyboardAction4;
        int onTextLayout2;
        int onTextLayout3;
        Object obj10;
        int lineLimits4;
        TextFieldLineLimits textStyle2;
        Object obj8;
        int onTextLayout4;
        int i15;
        Object interactionSource3;
        int interactionSource2;
        int i29;
        int decorator4;
        int decorator2;
        int changed;
        int cursorBrush2;
        int i2;
        int outputTransformation2;
        int i13;
        int decorator3;
        int i7;
        int i22;
        int i26;
        int i27;
        int i10;
        Composer composer;
        int i20;
        int i25;
        int i11;
        int i9;
        int i;
        int i23;
        int changed2;
        int i28;
        int i30;
        int i18;
        int i17;
        int i3;
        int i6;
        int i21;
        int i16;
        int i8;
        int i24;
        boolean changed3;
        ScopeUpdateScope scopeUpdateScope;
        boolean obj37;
        int obj38;
        Object obj13 = decorator;
        int i35 = $changed;
        i12 = $changed1;
        int i61 = i19;
        Composer restartGroup = $composer.startRestartGroup(469439921);
        ComposerKt.sourceInformation(restartGroup, "C(BasicTextField)P(13,7,2,11,3,14,5,8,6,9,4!1,10)184@10988L21,188@11134L610:BasicTextField.kt#423gt5");
        $dirty2 = $changed;
        $dirty12 = $changed1;
        if (i61 & 1 != 0) {
            $dirty2 |= 6;
            obj3 = state;
        } else {
            if (i35 & 6 == 0) {
                i5 = restartGroup.changed(state) ? 4 : 2;
                $dirty2 |= i5;
            } else {
                obj3 = state;
            }
        }
        int i89 = i61 & 2;
        if (i89 != 0) {
            $dirty2 |= 48;
            obj8 = modifier;
        } else {
            if (i35 & 48 == 0) {
                i15 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i15;
            } else {
                obj8 = modifier;
            }
        }
        int i92 = i61 & 4;
        changed = 128;
        if (i92 != 0) {
            $dirty2 |= 384;
            z2 = enabled;
        } else {
            if (i35 & 384 == 0) {
                i2 = restartGroup.changed(enabled) ? i29 : changed;
                $dirty2 |= i2;
            } else {
                z2 = enabled;
            }
        }
        outputTransformation2 = i61 & 8;
        i22 = 1024;
        if (outputTransformation2 != 0) {
            $dirty2 |= 3072;
            companion = readOnly;
        } else {
            if (i35 & 3072 == 0) {
                i10 = restartGroup.changed(readOnly) ? i13 : i22;
                $dirty2 |= i10;
            } else {
                companion = readOnly;
            }
        }
        int i96 = i61 & 16;
        i25 = 16384;
        if (i96 != 0) {
            $dirty2 |= 24576;
            obj2 = inputTransformation;
        } else {
            if (i35 & 24576 == 0) {
                i = restartGroup.changed(inputTransformation) ? i25 : i20;
                $dirty2 |= i;
            } else {
                obj2 = inputTransformation;
            }
        }
        int i97 = i61 & 32;
        changed2 = 196608;
        if (i97 != 0) {
            $dirty2 |= changed2;
            obj10 = textStyle;
        } else {
            if (i35 & changed2 == 0) {
                i28 = restartGroup.changed(textStyle) ? 131072 : 65536;
                $dirty2 |= i28;
            } else {
                obj10 = textStyle;
            }
        }
        int i98 = i61 & 64;
        i30 = 1572864;
        if (i98 != 0) {
            $dirty2 |= i30;
            default = keyboardOptions;
        } else {
            if (i35 & i30 == 0) {
                i18 = restartGroup.changed(keyboardOptions) ? 1048576 : 524288;
                $dirty2 |= i18;
            } else {
                default = keyboardOptions;
            }
        }
        int i36 = i61 & 128;
        int i99 = 12582912;
        if (i36 != 0) {
            $dirty2 |= i99;
            i17 = i36;
            obj9 = onKeyboardAction;
        } else {
            if ($changed & i99 == 0) {
                i17 = i36;
                i3 = restartGroup.changed(onKeyboardAction) ? 8388608 : 4194304;
                $dirty2 |= i3;
            } else {
                i17 = i36;
                obj9 = onKeyboardAction;
            }
        }
        int i37 = i61 & 256;
        int i101 = 100663296;
        if (i37 != 0) {
            $dirty2 |= i101;
            i6 = i37;
            obj6 = lineLimits;
        } else {
            if ($changed & i101 == 0) {
                i6 = i37;
                i21 = restartGroup.changed(lineLimits) ? 67108864 : 33554432;
                $dirty2 |= i21;
            } else {
                i6 = i37;
                obj6 = lineLimits;
            }
        }
        int i38 = i61 & 512;
        int i103 = 805306368;
        if (i38 != 0) {
            $dirty2 |= i103;
            i16 = i38;
            obj5 = onTextLayout;
        } else {
            if ($changed & i103 == 0) {
                i16 = i38;
                i8 = restartGroup.changedInstance(onTextLayout) ? 536870912 : 268435456;
                $dirty2 |= i8;
            } else {
                i16 = i38;
                obj5 = onTextLayout;
            }
        }
        int i39 = i61 & 1024;
        if (i39 != 0) {
            $dirty12 |= 6;
            i24 = i39;
            obj = interactionSource;
        } else {
            if (i12 & 6 == 0) {
                i24 = i39;
                i26 = restartGroup.changed(interactionSource) ? 4 : 2;
                $dirty12 |= i26;
            } else {
                i24 = i39;
                obj = interactionSource;
            }
        }
        int i40 = i61 & 2048;
        if (i40 != 0) {
            $dirty12 |= 48;
            i27 = i40;
            obj11 = cursorBrush;
        } else {
            if (i12 & 48 == 0) {
                i27 = i40;
                i11 = restartGroup.changed(cursorBrush) ? 32 : 16;
                $dirty12 |= i11;
            } else {
                i27 = i40;
                obj11 = cursorBrush;
            }
        }
        int i41 = i61 & 4096;
        if (i41 != 0) {
            $dirty12 |= 384;
            i9 = i41;
            obj7 = outputTransformation;
        } else {
            i9 = i41;
            if (i12 & 384 == 0) {
                if (restartGroup.changed(outputTransformation)) {
                } else {
                    i29 = changed;
                }
                $dirty12 |= i29;
            } else {
                obj7 = outputTransformation;
            }
        }
        changedInstance = i61 & 8192;
        if (changedInstance != null) {
            $dirty12 |= 3072;
            decorator4 = changedInstance;
        } else {
            decorator4 = changedInstance;
            if (i12 & 3072 == 0) {
                if (i12 & 4096 == 0) {
                    changedInstance = restartGroup.changed(obj13);
                } else {
                    changedInstance = restartGroup.changedInstance(obj13);
                }
                if (changedInstance != null) {
                } else {
                    i13 = i22;
                }
                $dirty12 |= i13;
            }
        }
        if (i12 & 24576 == 0) {
            if (i61 & 16384 == 0) {
                if (restartGroup.changed(scrollState)) {
                    i20 = i25;
                }
            } else {
                obj12 = scrollState;
            }
            $dirty12 |= i20;
        } else {
            obj12 = scrollState;
        }
        if ($dirty2 & cursorBrush2 == 306783378 && $dirty12 & 9363 == 9362) {
            if ($dirty12 & 9363 == 9362) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    if ($changed & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if (i89 != 0) {
                                obj8 = defaultsInvalid;
                            }
                            enabled2 = i92 != 0 ? 1 : z2;
                            readOnly2 = outputTransformation2 != 0 ? 0 : companion;
                            inputTransformation3 = i96 != 0 ? 0 : obj2;
                            if (i97 != 0) {
                                obj10 = companion;
                            }
                            if (i98 != 0) {
                                default = KeyboardOptions.Companion.getDefault();
                            }
                            onKeyboardAction2 = i17 != 0 ? 0 : onKeyboardAction;
                            if (i6 != 0) {
                                lineLimits2 = TextFieldLineLimits.Companion.getDefault();
                            } else {
                                lineLimits2 = lineLimits;
                            }
                            onTextLayout3 = i16 != 0 ? 0 : onTextLayout;
                            interactionSource2 = i24 != 0 ? 0 : interactionSource;
                            if (i27 != 0) {
                                cursorBrush2 = BasicTextFieldDefaults.INSTANCE.getCursorBrush();
                            } else {
                                cursorBrush2 = cursorBrush;
                            }
                            outputTransformation2 = i9 != 0 ? 0 : outputTransformation;
                            decorator2 = decorator4 != 0 ? 0 : decorator;
                            obj37 = enabled2;
                            if (i61 & 16384 != 0) {
                                i45 &= $dirty12;
                                $dirty13 = obj37;
                                i14 = obj38;
                                i22 = rememberScrollState;
                                scrollState2 = onTextLayout3;
                                i7 = decorator2;
                                decorator4 = cursorBrush2;
                                onTextLayout2 = onKeyboardAction2;
                                onKeyboardAction3 = obj10;
                                textStyle2 = lineLimits2;
                                lineLimits3 = default;
                            } else {
                                i14 = obj38;
                                i22 = scrollState;
                                i4 = $dirty12;
                                scrollState2 = onTextLayout3;
                                i7 = decorator2;
                                decorator4 = cursorBrush2;
                                $dirty13 = obj37;
                                onTextLayout2 = onKeyboardAction2;
                                onKeyboardAction3 = obj10;
                                textStyle2 = lineLimits2;
                                lineLimits3 = default;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            if (i61 & 16384 != 0) {
                                interactionSource2 = interactionSource;
                                decorator4 = cursorBrush;
                                outputTransformation2 = outputTransformation;
                                i7 = decorator;
                                i22 = scrollState;
                                i4 = i34;
                                lineLimits3 = default;
                                $dirty13 = z2;
                                i14 = companion;
                                inputTransformation3 = obj2;
                                onKeyboardAction3 = obj10;
                                onTextLayout2 = onKeyboardAction;
                                textStyle2 = lineLimits;
                                scrollState2 = onTextLayout;
                            } else {
                                scrollState2 = onTextLayout;
                                interactionSource2 = interactionSource;
                                decorator4 = cursorBrush;
                                outputTransformation2 = outputTransformation;
                                i7 = decorator;
                                i22 = scrollState;
                                lineLimits3 = default;
                                i4 = $dirty12;
                                $dirty13 = z2;
                                i14 = companion;
                                inputTransformation3 = obj2;
                                onKeyboardAction3 = obj10;
                                onTextLayout2 = onKeyboardAction;
                                textStyle2 = lineLimits;
                            }
                        }
                    } else {
                    }
                    restartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(469439921, $dirty2, i4, "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:187)");
                    }
                    i23 = $dirty2;
                    Object $dirty3 = obj8;
                    int modifier2 = scrollState2;
                    BasicTextFieldKt.BasicTextField(state, $dirty3, $dirty13, i14, inputTransformation3, onKeyboardAction3, lineLimits3, onTextLayout2, textStyle2, modifier2, interactionSource2, decorator4, 0, outputTransformation2, i7, i22, false, restartGroup, i55 | i77, i60 | i84, 65536);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj4 = $dirty3;
                    z3 = $dirty13;
                    z = i14;
                    $composer2 = inputTransformation3;
                    $dirty = onKeyboardAction3;
                    $dirty1 = lineLimits3;
                    readOnly3 = onTextLayout2;
                    inputTransformation2 = textStyle2;
                    textStyle3 = modifier2;
                    keyboardOptions2 = interactionSource2;
                    onKeyboardAction4 = decorator4;
                    lineLimits4 = outputTransformation2;
                    onTextLayout4 = i7;
                    interactionSource3 = i22;
                    decorator3 = i4;
                } else {
                    restartGroup.skipToGroupEnd();
                    readOnly3 = onKeyboardAction;
                    keyboardOptions2 = interactionSource;
                    interactionSource3 = scrollState;
                    composer = restartGroup;
                    i23 = $dirty2;
                    decorator3 = $dirty12;
                    z3 = z2;
                    $composer2 = obj2;
                    $dirty = obj10;
                    obj4 = obj8;
                    inputTransformation2 = lineLimits;
                    onKeyboardAction4 = cursorBrush;
                    lineLimits4 = outputTransformation;
                    onTextLayout4 = decorator;
                    $dirty1 = default;
                    z = companion;
                    textStyle3 = onTextLayout;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new BasicTextFieldKt.BasicTextField.1(state, obj4, z3, z, $composer2, $dirty, $dirty1, readOnly3, inputTransformation2, textStyle3, keyboardOptions2, onKeyboardAction4, lineLimits4, onTextLayout4, interactionSource3, $changed, $changed1, i19);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    public static final void BasicTextField(TextFieldState state, Modifier modifier, boolean enabled, boolean readOnly, InputTransformation inputTransformation, TextStyle textStyle, androidx.compose.foundation.text.KeyboardOptions keyboardOptions, KeyboardActionHandler onKeyboardAction, TextFieldLineLimits lineLimits, Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> onTextLayout, MutableInteractionSource interactionSource, Brush cursorBrush, CodepointTransformation codepointTransformation, OutputTransformation outputTransformation, TextFieldDecorator decorator, ScrollState scrollState, boolean isPassword, Composer $composer, int $changed, int $changed1, int i21) {
        boolean z4;
        int skipping;
        int defaultsInvalid;
        boolean readOnly2;
        int i51;
        int i18;
        Object obj11;
        Object invalid$iv;
        Object directDragGestureInitiator;
        Function0 factory$iv$iv$iv;
        boolean changed3;
        int $dirty2;
        Object obj14;
        Object obj12;
        Object $this$cache$iv;
        Object traceInProgress;
        ScopeUpdateScope endRestartGroup;
        Object obj8;
        Object obj9;
        Object obj10;
        Object obj15;
        Object obj7;
        Object obj3;
        Object obj;
        int i44;
        Object obj5;
        int i26;
        int windowInfo;
        Orientation horizontal;
        Integer currentCompositionLocalMap;
        Object obj2;
        boolean changedInstance;
        Object currentTextToolbar;
        boolean z3;
        Composer composer;
        int valueOf;
        boolean z6;
        Object $composer3;
        int $dirty;
        Object $dirty4;
        int $dirty12;
        int $dirty13;
        int i39;
        int i27;
        int i2;
        int i52;
        Object it$iv;
        TextFieldSelectionState transformedState;
        Object $dirty1;
        int i16;
        int default;
        Object keyboardOptions2;
        int i36;
        Object obj13;
        int onKeyboardAction2;
        TextFieldLineLimits field3;
        boolean i19;
        Object lineLimits2;
        Object rememberedValue;
        int i53;
        Object obj4;
        int textStyle2;
        int i17;
        int i43;
        int i40;
        int i37;
        int i14;
        boolean z2;
        boolean traceInProgress2;
        Object density;
        int empty;
        SolidColor enabled2;
        Object obj16;
        int modifier2;
        int i45;
        int onTextLayout2;
        int i49;
        Object obj6;
        int inputTransformation2;
        int i25;
        int i38;
        int codepointTransformation2;
        ScrollState codepointTransformation3;
        int i10;
        int interactionSource2;
        int interactionSource3;
        int i20;
        Object $dirty3;
        int i3;
        int i7;
        int outputTransformation2;
        int i46;
        int i4;
        Object cursorBrush2;
        int i9;
        Composer $composer2;
        Object companion2;
        int i34;
        androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.2.1 field;
        int i28;
        int decorator2;
        Object iNSTANCE;
        int companion;
        int changed;
        int textLayoutState;
        int i50;
        int i5;
        int i8;
        int i11;
        int i;
        Function0 i22;
        int i33;
        int i42;
        int anon;
        int i41;
        int i29;
        int i24;
        int i30;
        int i32;
        int i23;
        int i31;
        int i35;
        boolean changed2;
        int booleanValue;
        boolean windowFocused;
        boolean booleanValue2;
        TransformedTextFieldState field2;
        TextFieldSelectionState textFieldSelectionState;
        TextFieldSelectionState field4;
        SolidColor solidColor;
        boolean z7;
        boolean z5;
        boolean z;
        ScrollState scrollState2;
        Orientation orientation2;
        boolean equal;
        int i6;
        Modifier focusable;
        ScrollState scrollState3;
        Orientation orientation;
        int i15;
        boolean reverseDirection;
        int i47;
        int i12;
        int i13;
        int i48;
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
        traceInProgress = state;
        Object obj17 = decorator;
        int i66 = $changed;
        int i84 = $changed1;
        int i90 = i21;
        Composer restartGroup = $composer.startRestartGroup(965149429);
        ComposerKt.sourceInformation(restartGroup, "C(BasicTextField)P(15,9,3,13,4,16,7,10,8,11,5,1!1,12!1,14)234@12943L21,239@13149L7,240@13204L7,241@13249L7,247@13619L25,248@13693L25,251@13806L797,271@14801L48,273@14885L357,284@15295L7,285@15359L7,286@15413L7,287@15436L520,287@15425L531,303@16004L83,303@15962L125,342@17504L3096:BasicTextField.kt#423gt5");
        $dirty = $changed;
        $dirty12 = $changed1;
        if (i90 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (i66 & 6 == 0) {
                i16 = restartGroup.changed(traceInProgress) ? 4 : 2;
                $dirty |= i16;
            }
        }
        default = i90 & 2;
        if (default != 0) {
            $dirty |= 48;
            obj16 = modifier;
        } else {
            if (i66 & 48 == 0) {
                i45 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i45;
            } else {
                obj16 = modifier;
            }
        }
        onTextLayout2 = i90 & 4;
        if (onTextLayout2 != 0) {
            $dirty |= 384;
            z2 = enabled;
        } else {
            if (i66 & 384 == 0) {
                i10 = restartGroup.changed(enabled) ? 256 : 128;
                $dirty |= i10;
            } else {
                z2 = enabled;
            }
        }
        int i149 = i90 & 8;
        if (i149 != 0) {
            $dirty |= 3072;
            i19 = readOnly;
        } else {
            if (i66 & 3072 == 0) {
                i4 = restartGroup.changed(readOnly) ? 2048 : i20;
                $dirty |= i4;
            } else {
                i19 = readOnly;
            }
        }
        cursorBrush2 = i90 & 16;
        if (cursorBrush2 != 0) {
            $dirty |= 24576;
            obj6 = inputTransformation;
        } else {
            if (i66 & 24576 == 0) {
                i28 = restartGroup.changed(inputTransformation) ? 16384 : 8192;
                $dirty |= i28;
            } else {
                obj6 = inputTransformation;
            }
        }
        decorator2 = i90 & 32;
        changed = 196608;
        if (decorator2 != 0) {
            $dirty |= changed;
            obj4 = textStyle;
        } else {
            if (i66 & changed == 0) {
                i8 = restartGroup.changed(textStyle) ? 131072 : 65536;
                $dirty |= i8;
            } else {
                obj4 = textStyle;
            }
        }
        i11 = i90 & 64;
        i = 1572864;
        if (i11 != 0) {
            $dirty |= i;
            obj13 = keyboardOptions;
        } else {
            if (i66 & i == 0) {
                i42 = restartGroup.changed(keyboardOptions) ? 1048576 : 524288;
                $dirty |= i42;
            } else {
                obj13 = keyboardOptions;
            }
        }
        int i67 = i90 & 128;
        int i165 = 12582912;
        if (i67 != 0) {
            $dirty |= i165;
            anon = i67;
            obj8 = onKeyboardAction;
        } else {
            if ($changed & i165 == 0) {
                anon = i67;
                i41 = restartGroup.changed(onKeyboardAction) ? 8388608 : 4194304;
                $dirty |= i41;
            } else {
                anon = i67;
                obj8 = onKeyboardAction;
            }
        }
        int i68 = i90 & 256;
        int i167 = 100663296;
        if (i68 != 0) {
            $dirty |= i167;
            i29 = i68;
            obj9 = lineLimits;
        } else {
            if ($changed & i167 == 0) {
                i29 = i68;
                i24 = restartGroup.changed(lineLimits) ? 67108864 : 33554432;
                $dirty |= i24;
            } else {
                i29 = i68;
                obj9 = lineLimits;
            }
        }
        int i69 = i90 & 512;
        int i169 = 805306368;
        if (i69 != 0) {
            $dirty |= i169;
            i30 = i69;
            obj10 = onTextLayout;
        } else {
            if ($changed & i169 == 0) {
                i30 = i69;
                i32 = restartGroup.changedInstance(onTextLayout) ? 536870912 : 268435456;
                $dirty |= i32;
            } else {
                i30 = i69;
                obj10 = onTextLayout;
            }
        }
        int i70 = i90 & 1024;
        if (i70 != 0) {
            $dirty12 |= 6;
            i23 = i70;
            obj15 = interactionSource;
        } else {
            if (i84 & 6 == 0) {
                i23 = i70;
                i31 = restartGroup.changed(interactionSource) ? 4 : 2;
                $dirty12 |= i31;
            } else {
                i23 = i70;
                obj15 = interactionSource;
            }
        }
        int i71 = i90 & 2048;
        if (i71 != 0) {
            $dirty12 |= 48;
            i35 = i71;
            obj7 = cursorBrush;
        } else {
            if (i84 & 48 == 0) {
                i35 = i71;
                i25 = restartGroup.changed(cursorBrush) ? 32 : 16;
                $dirty12 |= i25;
            } else {
                i35 = i71;
                obj7 = cursorBrush;
            }
        }
        int i72 = i90 & 4096;
        if (i72 != 0) {
            $dirty12 |= 384;
            i38 = i72;
            obj3 = codepointTransformation;
        } else {
            i38 = i72;
            if (i84 & 384 == 0) {
                i7 = restartGroup.changed(codepointTransformation) ? 256 : 128;
                $dirty12 |= i7;
            } else {
                obj3 = codepointTransformation;
            }
        }
        int i74 = i90 & 8192;
        if (i74 != 0) {
            $dirty12 |= 3072;
            outputTransformation2 = i74;
            obj = outputTransformation;
        } else {
            outputTransformation2 = i74;
            if (i84 & 3072 == 0) {
                if (restartGroup.changed(outputTransformation)) {
                    i20 = 2048;
                }
                $dirty12 |= i20;
            } else {
                obj = outputTransformation;
            }
        }
        i44 = i90 & 16384;
        $dirty3 = 32768;
        if (i44 != 0) {
            $dirty12 |= 24576;
            booleanValue = i44;
        } else {
            booleanValue = i44;
            if (i84 & 24576 == 0) {
                if (i84 & $dirty3 == 0) {
                    changedInstance = restartGroup.changed(obj17);
                } else {
                    changedInstance = restartGroup.changedInstance(obj17);
                }
                i44 = changedInstance != null ? 16384 : 8192;
                $dirty12 |= i44;
            }
        }
        if (i84 & changed == 0) {
            if (i90 & $dirty3 == 0) {
                changed = restartGroup.changed(scrollState) ? 131072 : 65536;
            } else {
                obj5 = scrollState;
            }
            $dirty12 |= changed;
        } else {
            obj5 = scrollState;
        }
        textLayoutState = i90 & i163;
        if (textLayoutState != 0) {
            $dirty12 |= i;
            z4 = isPassword;
        } else {
            if (i84 & i == 0) {
                i = restartGroup.changed(isPassword) ? 1048576 : 524288;
                $dirty12 |= i;
            } else {
                z4 = isPassword;
            }
        }
        if ($dirty & i22 == 306783378 && i62 &= $dirty12 == 599186) {
            if (i62 &= $dirty12 == 599186) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    if ($changed & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if (default != 0) {
                                obj16 = defaultsInvalid;
                            }
                            if (onTextLayout2 != 0) {
                                z2 = defaultsInvalid;
                            }
                            readOnly2 = i149 != 0 ? 0 : i19;
                            if (cursorBrush2 != 0) {
                                obj6 = default;
                            }
                            if (decorator2 != 0) {
                                obj4 = default;
                            }
                            if (i11 != 0) {
                                keyboardOptions2 = KeyboardOptions.Companion.getDefault();
                            } else {
                                keyboardOptions2 = obj13;
                            }
                            onKeyboardAction2 = anon != 0 ? 0 : onKeyboardAction;
                            if (i29 != 0) {
                                lineLimits2 = TextFieldLineLimits.Companion.getDefault();
                            } else {
                                lineLimits2 = lineLimits;
                            }
                            onTextLayout2 = i30 != 0 ? 0 : onTextLayout;
                            interactionSource2 = i23 != 0 ? 0 : interactionSource;
                            if (i35 != 0) {
                                cursorBrush2 = BasicTextFieldDefaults.INSTANCE.getCursorBrush();
                            } else {
                                cursorBrush2 = cursorBrush;
                            }
                            codepointTransformation2 = i38 != 0 ? 0 : codepointTransformation;
                            outputTransformation2 = outputTransformation2 != 0 ? 0 : outputTransformation;
                            decorator2 = booleanValue != 0 ? 0 : decorator;
                            if (i90 & $dirty3 != 0) {
                                obj58 = readOnly2;
                                int readOnly3 = 0;
                                $dirty3 = ScrollKt.rememberScrollState(readOnly3, restartGroup, readOnly3, 1);
                                $dirty12 &= readOnly2;
                            } else {
                                obj58 = readOnly2;
                                $dirty3 = scrollState;
                            }
                            if (textLayoutState != 0) {
                                z = obj58;
                                i35 = obj4;
                                z7 = z2;
                                i6 = onTextLayout2;
                                scrollState2 = $dirty3;
                                solidColor = cursorBrush2;
                                i29 = decorator2;
                                textStyle2 = $dirty12;
                                $dirty13 = i54;
                                i18 = outputTransformation2;
                            } else {
                                z = obj58;
                                i35 = obj4;
                                z7 = z2;
                                i6 = onTextLayout2;
                                scrollState2 = $dirty3;
                                i18 = outputTransformation2;
                                solidColor = cursorBrush2;
                                i29 = decorator2;
                                textStyle2 = $dirty12;
                                $dirty13 = isPassword;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            if (i90 & $dirty3 != 0) {
                                $dirty12 &= i51;
                            }
                            i6 = onTextLayout;
                            interactionSource2 = interactionSource;
                            solidColor = cursorBrush;
                            codepointTransformation2 = codepointTransformation;
                            i18 = outputTransformation;
                            i29 = decorator;
                            scrollState2 = scrollState;
                            keyboardOptions2 = obj13;
                            z = i19;
                            i35 = obj4;
                            z7 = z2;
                            onKeyboardAction2 = onKeyboardAction;
                            lineLimits2 = lineLimits;
                            textStyle2 = $dirty12;
                            $dirty13 = isPassword;
                        }
                    } else {
                    }
                    restartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(965149429, $dirty, textStyle2, "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:238)");
                    }
                    int i147 = 0;
                    int i151 = 0;
                    int i78 = 2023513938;
                    String str2 = "CC:CompositionLocal.kt#9igjgp";
                    ComposerKt.sourceInformationMarkerStart(restartGroup, i78, str2);
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    Object this_$iv4 = consume5;
                    int i152 = 0;
                    int i161 = 0;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, i78, str2);
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    i3 = 0;
                    i9 = 0;
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
                        i3 = 0;
                        obj59 = i81;
                        Object rememberedValue5 = obj58.rememberedValue();
                        i9 = 0;
                        obj65 = $dirty13;
                        if (rememberedValue5 == Composer.Companion.getEmpty()) {
                            int i109 = 0;
                            obj60 = rememberedValue5;
                            obj58.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                        } else {
                            windowInfo = obj58;
                            i39 = obj60;
                        }
                        ComposerKt.sourceInformationMarkerEnd(restartGroup);
                        restartGroup.endReplaceGroup();
                    } else {
                        obj69 = this_$iv;
                        obj65 = $dirty13;
                        restartGroup.startReplaceGroup(-1243799582);
                        restartGroup.endReplaceGroup();
                        i39 = interactionSource2;
                    }
                    int i173 = i39;
                    horizontal = equal ? Orientation.Horizontal : Orientation.Vertical;
                    Orientation orientation3 = orientation4;
                    int keyboardOptions4 = 0;
                    booleanValue = (Boolean)FocusInteractionKt.collectIsFocusedAsState((InteractionSource)i173, restartGroup, keyboardOptions4).getValue().booleanValue();
                    windowFocused = obj69.isWindowFocused();
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1243786909, str3);
                    i27 = $dirty & 14 == 4 ? 1 : 0;
                    i2 = textStyle2 & 896 == 256 ? 1 : 0;
                    i52 = textStyle2 & 7168 == 2048 ? 1 : 0;
                    Composer composer5 = restartGroup;
                    int i153 = 0;
                    it$iv = composer5.rememberedValue();
                    int i162 = 0;
                    if (obj58 | i52 == 0) {
                        obj71 = onKeyboardAction2;
                        if (it$iv == Composer.Companion.getEmpty()) {
                            if (codepointTransformation2 == 0) {
                                textLayoutState = iNSTANCE;
                                i11 = 0;
                                if (equal) {
                                } else {
                                    iNSTANCE = 0;
                                }
                            } else {
                                iNSTANCE = codepointTransformation2;
                            }
                            obj60 = it$iv;
                            obj61 = onKeyboardAction3;
                            it$iv = new TransformedTextFieldState(traceInProgress, obj6, iNSTANCE, i18);
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
                    int i154 = 0;
                    Object rememberedValue2 = composer6.rememberedValue();
                    companion = 0;
                    if (!restartGroup.changed((TransformedTextFieldState)it$iv)) {
                        if (rememberedValue2 == Composer.Companion.getEmpty()) {
                            int i65 = 0;
                            textLayoutState = new TextLayoutState();
                            composer6.updateRememberedValue(textLayoutState);
                        } else {
                            obj14 = rememberedValue2;
                        }
                    } else {
                    }
                    i23 = obj14;
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1243752821, str3);
                    changed3 = restartGroup.changed(it$iv);
                    Composer composer2 = restartGroup;
                    int i114 = 0;
                    Object rememberedValue6 = composer2.rememberedValue();
                    int i155 = 0;
                    if (!changed3) {
                        obj67 = changed3;
                        if (rememberedValue6 == Composer.Companion.getEmpty()) {
                            int invalid$iv2 = 0;
                            if (booleanValue && windowFocused) {
                                textLayoutState = windowFocused ? 1 : 0;
                            } else {
                            }
                            obj61 = this_$iv4;
                            obj58 = textFieldSelectionState3;
                            super(it$iv, (TextLayoutState)i23, obj61, z7, z, textLayoutState, obj65);
                            obj11 = obj61;
                            decorator2 = obj65;
                            composer2.updateRememberedValue(obj58);
                        } else {
                            decorator2 = obj65;
                            obj11 = this_$iv4;
                            density = rememberedValue6;
                        }
                    } else {
                        obj67 = changed3;
                    }
                    $this$cache$iv = density;
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    int i138 = 0;
                    obj58 = i115;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, str2);
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    Object this_$iv2 = consume3;
                    int i139 = 0;
                    int i156 = 0;
                    i30 = lineLimits2;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, str2);
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    Object this_$iv3 = consume4;
                    int i140 = 0;
                    int i157 = 0;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, str2);
                    Object consume = restartGroup.consume((CompositionLocal)CompositionLocalsKt.getLocalTextToolbar());
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1243735026, str3);
                    i17 = i129 &= $dirty == 16384 ? 1 : 0;
                    i43 = $dirty & 896 == 256 ? 1 : 0;
                    i40 = $dirty & 7168 == 2048 ? 1 : 0;
                    i37 = i50 & i133 == 1048576 ? 1 : 0;
                    Composer composer7 = restartGroup;
                    empty = 0;
                    obj61 = obj11;
                    Object rememberedValue3 = composer7.rememberedValue();
                    int i158 = 0;
                    if (i125 |= i37 == 0) {
                        if (rememberedValue3 == Composer.Companion.getEmpty()) {
                            int textFieldSelectionState2 = 0;
                            obj65 = obj61;
                            obj64 = consume;
                            obj59 = it$iv;
                            obj58 = anon2;
                            obj61 = textFieldSelectionState;
                            super(obj59, obj6, obj61, this_$iv2, this_$iv3, obj64, obj65, z7, z, decorator2);
                            field2 = obj59;
                            transformedState = obj61;
                            companion2 = obj64;
                            currentTextToolbar = obj65;
                            composer7.updateRememberedValue((Function0)obj58);
                        } else {
                            obj12 = rememberedValue3;
                            companion2 = consume;
                            field2 = it$iv;
                            transformedState = textFieldSelectionState;
                            currentTextToolbar = obj61;
                        }
                    } else {
                        textFieldSelectionState = $this$cache$iv;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    EffectsKt.SideEffect((Function0)obj12, restartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1243717287, str3);
                    boolean changedInstance2 = restartGroup.changedInstance(transformedState);
                    Composer composer3 = restartGroup;
                    int i92 = 0;
                    rememberedValue = composer3.rememberedValue();
                    int i135 = 0;
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
                    obj63 = z7;
                    obj68 = i173;
                    super(field2, i23, obj61, obj6, obj63, z, obj65, obj66, equal, obj68);
                    field4 = obj61;
                    boolean z9 = obj63;
                    valueOf = obj66;
                    int i106 = obj68;
                    if (z9 && field4.getDirectDragGestureInitiator() == TextFieldSelectionState.InputType.None) {
                        i15 = field4.getDirectDragGestureInitiator() == TextFieldSelectionState.InputType.None ? 1 : 0;
                    } else {
                    }
                    int i127 = 0;
                    orientation = orientation3;
                    Modifier pointerHoverIcon$default = PointerIconKt.pointerHoverIcon$default(ScrollableKt.scrollable$default(FocusableKt.focusable(obj16.then((Modifier)textFieldDecoratorModifier), z9, i106), (ScrollableState)scrollState2, orientation, i15, ScrollableDefaults.INSTANCE.reverseDirection((LayoutDirection)restartGroup.consume((CompositionLocal)CompositionLocalsKt.getLocalLayoutDirection()), orientation3, i127), 0, i106, 16, 0), TextPointerIcon_androidKt.getTextPointerIcon(), i127, 2, 0);
                    int i79 = 1;
                    int i108 = 384;
                    int i128 = 0;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    Alignment topStart = Alignment.Companion.getTopStart();
                    i46 = 0;
                    obj58 = topStart;
                    obj59 = i79;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    currentCompositionLocalMap = restartGroup.getCurrentCompositionLocalMap();
                    obj60 = currentCompositeKeyHash;
                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(restartGroup, pointerHoverIcon$default);
                    obj61 = pointerHoverIcon$default;
                    obj62 = constructor;
                    field = 0;
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
                    int i164 = 0;
                    i22 = factory$iv$iv$iv;
                    Updater.set-impl(constructor-impl, BoxKt.maybeCachedBoxMeasurePolicy(topStart, i79), ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    i11 = 0;
                    obj62 = constructor-impl;
                    i33 = 0;
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
                    obj62 = i61;
                    ComposerKt.sourceInformationMarkerStart(composer4, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                    obj66 = composer4;
                    i5 = 0;
                    obj67 = iNSTANCE3;
                    obj68 = materializeModifier;
                    ComposerKt.sourceInformationMarkerStart(composer4, 1236622543, "C343@17621L2973,343@17571L3023:BasicTextField.kt#423gt5");
                    anon = new BasicTextFieldKt.BasicTextField.4.1(i29, i30, i23, i35, booleanValue, windowFocused, (Boolean)HoverInteractionKt.collectIsHoveredAsState((InteractionSource)i173, restartGroup, keyboardOptions4).getValue().booleanValue(), field2, field4, solidColor, z9, z, scrollState2, orientation, equal, i6);
                    obj66 = i85;
                    obj73 = i96;
                    obj74 = restartGroup;
                    ContextMenu_androidKt.ContextMenuArea(field4, z9, (Function2)ComposableLambdaKt.rememberComposableLambda(-673241599, true, anon, composer4, 54), composer4, i88 |= 384);
                    ComposerKt.sourceInformationMarkerEnd(composer4);
                    ComposerKt.sourceInformationMarkerEnd(composer4);
                    obj74.endNode();
                    ComposerKt.sourceInformationMarkerEnd(obj74);
                    ComposerKt.sourceInformationMarkerEnd(obj74);
                    ComposerKt.sourceInformationMarkerEnd(obj74);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $dirty1 = obj70;
                    i36 = obj71;
                    $dirty2 = $dirty;
                    z3 = z9;
                    obj2 = obj16;
                    $composer3 = obj6;
                    modifier2 = codepointTransformation2;
                    i14 = interactionSource2;
                    i49 = cursorBrush2;
                    interactionSource3 = decorator2;
                    inputTransformation2 = i29;
                    field3 = i30;
                    $dirty4 = i35;
                    enabled2 = solidColor;
                    z6 = z;
                    codepointTransformation3 = scrollState2;
                    i53 = i6;
                } else {
                    restartGroup.skipToGroupEnd();
                    i36 = onKeyboardAction;
                    i49 = outputTransformation;
                    codepointTransformation3 = scrollState;
                    interactionSource3 = isPassword;
                    obj74 = restartGroup;
                    $dirty2 = $dirty;
                    i50 = $dirty12;
                    $dirty1 = obj13;
                    z6 = i19;
                    $dirty4 = obj4;
                    z3 = z2;
                    obj2 = obj16;
                    $composer3 = obj6;
                    field3 = lineLimits;
                    i53 = onTextLayout;
                    i14 = interactionSource;
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
            i34 = i160;
            $dirty2 = new BasicTextFieldKt.BasicTextField.5(state, obj2, z3, z6, $composer3, $dirty4, $dirty1, i36, field3, i53, i14, enabled2, modifier2, i49, inputTransformation2, codepointTransformation3, interactionSource3, $changed, $changed1, i21);
            endRestartGroup.updateScope((Function2)$dirty2);
        } else {
            $composer2 = obj74;
            i34 = $dirty2;
        }
    }

    public static final void BasicTextField(TextFieldValue value, Function1<? super TextFieldValue, Unit> onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, androidx.compose.foundation.text.KeyboardOptions keyboardOptions, androidx.compose.foundation.text.KeyboardActions keyboardActions, boolean singleLine, int maxLines, int minLines, VisualTransformation visualTransformation, Function1<? super TextLayoutResult, Unit> onTextLayout, MutableInteractionSource interactionSource, Brush cursorBrush, Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> decorationBox, Composer $composer, int $changed, int $changed1, int i20) {
        boolean traceInProgress2;
        Object endRestartGroup;
        Object obj4;
        boolean z;
        int i17;
        int i33;
        Object obj8;
        Object obj5;
        Object obj3;
        Object obj11;
        Object obj6;
        Object skipping;
        Object modifier2;
        int i31;
        Object it$iv;
        int defaultsInvalid;
        Object modifier3;
        Object modifier4;
        int i7;
        Object textStyle3;
        int solidColor;
        Object obj;
        int i8;
        boolean visualTransformation3;
        Object keyboardOptions4;
        int black-0d7_KjU;
        Object default;
        boolean onTextLayout4;
        int i28;
        Object $composer2;
        int $dirty2;
        Object cursorBrush3;
        int $dirty;
        int $dirty12;
        Object $dirty1;
        int i14;
        int i15;
        int i22;
        SolidColor singleLine2;
        int cursorBrush2;
        int companion2;
        int singleLine3;
        Object obj7;
        int i34;
        int maxLines3;
        int maxLines2;
        int i27;
        int minLines2;
        boolean traceInProgress;
        boolean z2;
        VisualTransformation keyboardActions2;
        Object enabled3;
        Object obj2;
        androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.10 enabled2;
        boolean keyboardOptions2;
        boolean obj10;
        int readOnly2;
        Object obj9;
        SolidColor decorationBox2;
        Object textStyle2;
        int i24;
        Function3 function3;
        Object visualTransformation2;
        int i2;
        int modifier5;
        int i12;
        boolean changed3;
        int i23;
        int i26;
        int onTextLayout3;
        Object onTextLayout2;
        int i25;
        int interactionSource2;
        int interactionSource3;
        int changedInstance2;
        int i29;
        int i4;
        int i19;
        int i9;
        int i18;
        int i3;
        int companion;
        int keyboardOptions3;
        Composer composer;
        int changed;
        int i13;
        int i30;
        int i;
        int i21;
        int i5;
        int i16;
        int i6;
        int changed2;
        int i10;
        int i11;
        int i32;
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
                i14 = restartGroup.changed(traceInProgress2) ? 4 : 2;
                $dirty2 |= i14;
            }
        }
        if (black-0d7_KjU & 2 != 0) {
            $dirty2 |= 48;
        } else {
            if (i39 & 48 == 0) {
                i15 = restartGroup.changedInstance(obj4) ? 32 : 16;
                $dirty2 |= i15;
            }
        }
        companion2 = black-0d7_KjU & 4;
        if (companion2 != 0) {
            $dirty2 |= 384;
            obj7 = modifier;
        } else {
            if (i39 & 384 == 0) {
                i24 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty2 |= i24;
            } else {
                obj7 = modifier;
            }
        }
        int i89 = black-0d7_KjU & 8;
        changed3 = 1024;
        if (i89 != 0) {
            $dirty2 |= 3072;
            z2 = enabled;
        } else {
            if (i39 & 3072 == 0) {
                i25 = restartGroup.changed(enabled) ? i2 : changed3;
                $dirty2 |= i25;
            } else {
                z2 = enabled;
            }
        }
        interactionSource2 = black-0d7_KjU & 16;
        int i92 = 8192;
        if (interactionSource2 != 0) {
            $dirty2 |= 24576;
            obj10 = readOnly;
        } else {
            if (i39 & 24576 == 0) {
                i3 = restartGroup.changed(readOnly) ? changedInstance2 : i92;
                $dirty2 |= i3;
            } else {
                obj10 = readOnly;
            }
        }
        companion = black-0d7_KjU & 32;
        int i99 = 196608;
        if (companion != 0) {
            $dirty2 |= i99;
            obj9 = textStyle;
        } else {
            if (i39 & i99 == 0) {
                i13 = restartGroup.changed(textStyle) ? 131072 : keyboardOptions3;
                $dirty2 |= i13;
            } else {
                obj9 = textStyle;
            }
        }
        int i100 = black-0d7_KjU & 64;
        i30 = 1572864;
        if (i100 != 0) {
            $dirty2 |= i30;
            obj2 = keyboardOptions;
        } else {
            if (i39 & i30 == 0) {
                i = restartGroup.changed(keyboardOptions) ? 1048576 : 524288;
                $dirty2 |= i;
            } else {
                obj2 = keyboardOptions;
            }
        }
        minLines2 = black-0d7_KjU & 128;
        i21 = 12582912;
        if (minLines2 != 0) {
            $dirty2 |= i21;
            default = keyboardActions;
        } else {
            if (i39 & i21 == 0) {
                i5 = restartGroup.changed(keyboardActions) ? 8388608 : 4194304;
                $dirty2 |= i5;
            } else {
                default = keyboardActions;
            }
        }
        int i40 = black-0d7_KjU & 256;
        int i101 = 100663296;
        if (i40 != 0) {
            $dirty2 |= i101;
            i16 = i40;
            z = singleLine;
        } else {
            if ($changed & i101 == 0) {
                i16 = i40;
                i6 = restartGroup.changed(singleLine) ? 67108864 : 33554432;
                $dirty2 |= i6;
            } else {
                i16 = i40;
                z = singleLine;
            }
        }
        if ($changed & i103 == 0) {
            if (black-0d7_KjU & 512 == 0) {
                changed2 = restartGroup.changed(maxLines) ? 536870912 : 268435456;
            } else {
                i17 = maxLines;
            }
            $dirty2 |= changed2;
        } else {
            i17 = maxLines;
        }
        int i42 = black-0d7_KjU & 1024;
        if (i42 != 0) {
            $dirty12 |= 6;
            i10 = i42;
            i33 = minLines;
        } else {
            if (i55 & 6 == 0) {
                i10 = i42;
                i11 = restartGroup.changed(minLines) ? 4 : 2;
                $dirty12 |= i11;
            } else {
                i10 = i42;
                i33 = minLines;
            }
        }
        int i43 = black-0d7_KjU & 2048;
        if (i43 != 0) {
            $dirty12 |= 48;
            i32 = i43;
            obj8 = visualTransformation;
        } else {
            if (i55 & 48 == 0) {
                i32 = i43;
                i26 = restartGroup.changed(visualTransformation) ? 32 : 16;
                $dirty12 |= i26;
            } else {
                i32 = i43;
                obj8 = visualTransformation;
            }
        }
        int i44 = black-0d7_KjU & 4096;
        if (i44 != 0) {
            $dirty12 |= 384;
            onTextLayout3 = i44;
            obj5 = onTextLayout;
        } else {
            onTextLayout3 = i44;
            if (i55 & 384 == 0) {
                i19 = restartGroup.changedInstance(onTextLayout) ? 256 : 128;
                $dirty12 |= i19;
            } else {
                obj5 = onTextLayout;
            }
        }
        int i46 = black-0d7_KjU & 8192;
        if (i46 != 0) {
            $dirty12 |= 3072;
            i9 = i46;
            obj3 = interactionSource;
        } else {
            i9 = i46;
            if (i55 & 3072 == 0) {
                if (restartGroup.changed(interactionSource)) {
                } else {
                    i2 = changed3;
                }
                $dirty12 |= i2;
            } else {
                obj3 = interactionSource;
            }
        }
        int i47 = black-0d7_KjU & 16384;
        if (i47 != 0) {
            $dirty12 |= 24576;
            modifier5 = i47;
            obj11 = cursorBrush;
        } else {
            modifier5 = i47;
            if (i55 & 24576 == 0) {
                if (restartGroup.changed(cursorBrush)) {
                } else {
                    changedInstance2 = i92;
                }
                $dirty12 |= changedInstance2;
            } else {
                obj11 = cursorBrush;
            }
        }
        i23 = black-0d7_KjU & i90;
        if (i23 != 0) {
            $dirty12 |= i99;
            obj6 = decorationBox;
        } else {
            if (i55 & i99 == 0) {
                if (restartGroup.changedInstance(decorationBox)) {
                    keyboardOptions3 = 131072;
                }
                $dirty12 |= keyboardOptions3;
            } else {
                obj6 = decorationBox;
            }
        }
        if ($dirty2 & i29 == 306783378 && i53 &= $dirty12 == 74898) {
            if (i53 &= $dirty12 == 74898) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    if ($changed & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if (companion2 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = obj7;
                            }
                            if (i89 != 0) {
                                z2 = companion2;
                            }
                            if (interactionSource2 != 0) {
                                obj10 = companion2;
                            }
                            if (companion != 0) {
                                obj9 = companion2;
                            }
                            if (i100 != 0) {
                                obj2 = companion2;
                            }
                            if (minLines2 != 0) {
                                default = KeyboardActions.Companion.getDefault();
                            }
                            singleLine3 = i16 != 0 ? 0 : singleLine;
                            if (black-0d7_KjU & 512 != 0) {
                                maxLines2 = singleLine3 != 0 ? 1 : 0x7fffffff /* Unknown resource */;
                                $dirty2 &= minLines2;
                            } else {
                                maxLines2 = maxLines;
                            }
                            minLines2 = i10 != 0 ? 1 : minLines;
                            if (i32 != 0) {
                                visualTransformation2 = VisualTransformation.Companion.getNone();
                            } else {
                                visualTransformation2 = visualTransformation;
                            }
                            if (onTextLayout3 != 0) {
                                onTextLayout2 = BasicTextFieldKt.BasicTextField.10.INSTANCE;
                            } else {
                                onTextLayout2 = onTextLayout;
                            }
                            interactionSource3 = i9 != 0 ? 0 : interactionSource;
                            if (modifier5 != 0) {
                                obj39 = default;
                                modifier5 = modifier3;
                                solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), default, 0);
                                modifier4 = solidColor;
                            } else {
                                modifier5 = modifier3;
                                obj39 = default;
                                modifier4 = cursorBrush;
                            }
                            if (i23 != 0) {
                                textStyle2 = lambda-2$foundation_release;
                                obj = obj13;
                                maxLines3 = $dirty2;
                                $dirty = interactionSource3;
                                interactionSource2 = i83;
                                i28 = singleLine3;
                                i29 = minLines2;
                                keyboardOptions4 = obj2;
                                singleLine2 = modifier4;
                                keyboardOptions2 = z2;
                                modifier2 = modifier5;
                                enabled3 = obj39;
                            } else {
                                maxLines3 = $dirty2;
                                $dirty = interactionSource3;
                                interactionSource2 = decorationBox3;
                                i28 = singleLine3;
                                i29 = minLines2;
                                keyboardOptions4 = obj2;
                                obj = obj9;
                                textStyle2 = decorationBox;
                                singleLine2 = modifier4;
                                keyboardOptions2 = z2;
                                modifier2 = modifier5;
                                enabled3 = obj39;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            if (black-0d7_KjU & 512 != 0) {
                                $dirty2 &= i7;
                            }
                            interactionSource2 = maxLines;
                            i29 = minLines;
                            visualTransformation2 = visualTransformation;
                            onTextLayout2 = onTextLayout;
                            singleLine2 = cursorBrush;
                            modifier2 = obj7;
                            keyboardOptions4 = obj2;
                            obj = obj9;
                            textStyle2 = decorationBox;
                            maxLines3 = $dirty2;
                            keyboardOptions2 = z2;
                            $dirty = interactionSource;
                            enabled3 = default;
                            i28 = singleLine;
                        }
                    } else {
                    }
                    restartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        obj39 = modifier2;
                        ComposerKt.traceEventStart(1804514146, maxLines3, $dirty12, "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:763)");
                    } else {
                        obj39 = modifier2;
                    }
                    i12 = i28 != 0 ? 1 : i29;
                    SolidColor interactionSource4 = singleLine2;
                    cursorBrush2 = i28 != 0 ? 1 : interactionSource2;
                    obj40 = i49;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1242950400, "CC(remember):BasicTextField.kt#9igjgp");
                    i31 = maxLines3 & 14 == 4 ? 1 : 0;
                    i8 = maxLines3 & 112 == 32 ? 1 : 0;
                    Composer composer2 = restartGroup;
                    int i93 = 0;
                    it$iv = composer2.rememberedValue();
                    int i98 = 0;
                    if (obj42 | i8 == 0) {
                        keyboardOptions3 = keyboardOptions4;
                        if (it$iv == Composer.Companion.getEmpty()) {
                            keyboardOptions4 = 0;
                            obj43 = it$iv;
                            it$iv = new BasicTextFieldKt.BasicTextField.11.1(traceInProgress2, obj4);
                            composer2.updateRememberedValue((Function1)it$iv);
                        } else {
                            obj43 = it$iv;
                        }
                    } else {
                        keyboardOptions3 = keyboardOptions4;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.10 singleLine5 = onTextLayout2;
                    i4 = obj40;
                    i18 = maxLines3;
                    VisualTransformation singleLine4 = visualTransformation2;
                    skipping = obj39;
                    Composer visualTransformation4 = restartGroup;
                    int $composer3 = i91;
                    Object obj12 = obj41;
                    CoreTextFieldKt.CoreTextField(value, (Function1)it$iv, skipping, obj12, singleLine4, singleLine5, $composer3, interactionSource4, i28 ^ 1, cursorBrush2, i12, keyboardOptions4.toImeOptions$foundation_release(i28), enabled3, keyboardOptions2, obj10, textStyle2, visualTransformation4, i63 |= i75, i37 |= i81, 0);
                    composer = visualTransformation4;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $composer2 = obj12;
                    $dirty1 = enabled3;
                    function3 = textStyle2;
                    i34 = interactionSource2;
                    i27 = i29;
                    i22 = companion;
                    textStyle3 = skipping;
                    keyboardActions2 = singleLine4;
                    decorationBox2 = interactionSource4;
                    visualTransformation3 = keyboardOptions2;
                    cursorBrush3 = keyboardOptions3;
                    enabled2 = singleLine5;
                    onTextLayout4 = obj10;
                    readOnly2 = i23;
                } else {
                    restartGroup.skipToGroupEnd();
                    i22 = singleLine;
                    i27 = minLines;
                    function3 = decorationBox;
                    composer = restartGroup;
                    i18 = $dirty2;
                    i4 = $dirty12;
                    textStyle3 = obj7;
                    visualTransformation3 = z2;
                    cursorBrush3 = obj2;
                    $composer2 = obj9;
                    i34 = maxLines;
                    keyboardActions2 = visualTransformation;
                    enabled2 = onTextLayout;
                    decorationBox2 = cursorBrush;
                    $dirty1 = default;
                    onTextLayout4 = obj10;
                    readOnly2 = interactionSource;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new BasicTextFieldKt.BasicTextField.12(value, onValueChange, textStyle3, visualTransformation3, onTextLayout4, $composer2, cursorBrush3, $dirty1, i22, i34, i27, keyboardActions2, enabled2, readOnly2, decorationBox2, function3, $changed, $changed1, i20);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    public static final void BasicTextField(TextFieldValue value, Function1 onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, androidx.compose.foundation.text.KeyboardOptions keyboardOptions, androidx.compose.foundation.text.KeyboardActions keyboardActions, boolean singleLine, int maxLines, VisualTransformation visualTransformation, Function1 onTextLayout, MutableInteractionSource interactionSource, Brush cursorBrush, Function3 decorationBox, Composer $composer, int $changed, int $changed1, int i19) {
        boolean z;
        int i7;
        Object obj4;
        Object obj9;
        Object obj7;
        Object obj11;
        Object obj;
        int traceInProgress;
        Object modifier3;
        Object modifier4;
        boolean traceInProgress2;
        Object endRestartGroup;
        int i25;
        boolean enabled3;
        int black-0d7_KjU;
        Object iNSTANCE;
        Object obj13;
        boolean $composer2;
        int $dirty2;
        boolean $dirty;
        int $dirty1;
        Object modifier2;
        Object obj2;
        Object enabled2;
        Object obj6;
        boolean readOnly2;
        Object readOnly3;
        boolean obj12;
        Object textStyle2;
        int textStyle3;
        int i20;
        Object obj14;
        int keyboardOptions2;
        boolean default;
        Object obj5;
        VisualTransformation keyboardActions2;
        Object obj8;
        int i23;
        androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.16 singleLine2;
        int i8;
        int i28;
        Object maxLines2;
        Object obj10;
        SolidColor solidColor;
        Object obj3;
        Function3 visualTransformation2;
        int i31;
        Object i9;
        int i29;
        int i24;
        int changedInstance2;
        int i4;
        int i15;
        int i3;
        int i5;
        int companion;
        Composer composer;
        int i12;
        int i11;
        int i21;
        int i32;
        int i10;
        int i;
        int changed;
        int i2;
        int i30;
        int i16;
        int changed2;
        int i17;
        int i22;
        int i18;
        int i26;
        int i6;
        int i27;
        int i13;
        int i14;
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
            obj2 = value;
        } else {
            if (i33 & 6 == 0) {
                i20 = restartGroup.changed(value) ? 4 : 2;
                $dirty2 |= i20;
            } else {
                obj2 = value;
            }
        }
        if (black-0d7_KjU & 2 != 0) {
            $dirty2 |= 48;
            obj14 = onValueChange;
        } else {
            if (i33 & 48 == 0) {
                i8 = restartGroup.changedInstance(onValueChange) ? 32 : 16;
                $dirty2 |= i8;
            } else {
                obj14 = onValueChange;
            }
        }
        int i94 = black-0d7_KjU & 4;
        if (i94 != 0) {
            $dirty2 |= 384;
            obj6 = modifier;
        } else {
            if (i33 & 384 == 0) {
                i31 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty2 |= i31;
            } else {
                obj6 = modifier;
            }
        }
        i9 = black-0d7_KjU & 8;
        changedInstance2 = 1024;
        if (i9 != 0) {
            $dirty2 |= 3072;
            obj12 = enabled;
        } else {
            if (i33 & 3072 == 0) {
                i5 = restartGroup.changed(enabled) ? i29 : changedInstance2;
                $dirty2 |= i5;
            } else {
                obj12 = enabled;
            }
        }
        companion = black-0d7_KjU & 16;
        i11 = 8192;
        if (companion != 0) {
            $dirty2 |= 24576;
            default = readOnly;
        } else {
            if (i33 & 24576 == 0) {
                i10 = restartGroup.changed(readOnly) ? i12 : i11;
                $dirty2 |= i10;
            } else {
                default = readOnly;
            }
        }
        int i97 = black-0d7_KjU & 32;
        changed = 196608;
        if (i97 != 0) {
            $dirty2 |= changed;
            obj8 = textStyle;
        } else {
            if (i33 & changed == 0) {
                i16 = restartGroup.changed(textStyle) ? 131072 : 65536;
                $dirty2 |= i16;
            } else {
                obj8 = textStyle;
            }
        }
        int i98 = black-0d7_KjU & 64;
        changed2 = 1572864;
        if (i98 != 0) {
            $dirty2 |= changed2;
            obj10 = keyboardOptions;
        } else {
            if (i33 & changed2 == 0) {
                i17 = restartGroup.changed(keyboardOptions) ? 1048576 : 524288;
                $dirty2 |= i17;
            } else {
                obj10 = keyboardOptions;
            }
        }
        int i95 = black-0d7_KjU & 128;
        i22 = 12582912;
        if (i95 != 0) {
            $dirty2 |= i22;
            iNSTANCE = keyboardActions;
        } else {
            if (i33 & i22 == 0) {
                i18 = restartGroup.changed(keyboardActions) ? 8388608 : 4194304;
                $dirty2 |= i18;
            } else {
                iNSTANCE = keyboardActions;
            }
        }
        int i34 = black-0d7_KjU & 256;
        int i99 = 100663296;
        if (i34 != 0) {
            $dirty2 |= i99;
            i26 = i34;
            z = singleLine;
        } else {
            if ($changed & i99 == 0) {
                i26 = i34;
                i6 = restartGroup.changed(singleLine) ? 67108864 : 33554432;
                $dirty2 |= i6;
            } else {
                i26 = i34;
                z = singleLine;
            }
        }
        int i35 = black-0d7_KjU & 512;
        int i101 = 805306368;
        if (i35 != 0) {
            $dirty2 |= i101;
            i27 = i35;
            i7 = maxLines;
        } else {
            if ($changed & i101 == 0) {
                i27 = i35;
                i13 = restartGroup.changed(maxLines) ? 536870912 : 268435456;
                $dirty2 |= i13;
            } else {
                i27 = i35;
                i7 = maxLines;
            }
        }
        int i36 = black-0d7_KjU & 1024;
        if (i36 != 0) {
            $dirty1 |= 6;
            i14 = i36;
            obj4 = visualTransformation;
        } else {
            if (i60 & 6 == 0) {
                i14 = i36;
                i15 = restartGroup.changed(visualTransformation) ? 4 : 2;
                $dirty1 |= i15;
            } else {
                i14 = i36;
                obj4 = visualTransformation;
            }
        }
        int i37 = black-0d7_KjU & 2048;
        if (i37 != 0) {
            $dirty1 |= 48;
            i3 = i37;
            obj9 = onTextLayout;
        } else {
            if (i60 & 48 == 0) {
                i3 = i37;
                i21 = restartGroup.changedInstance(onTextLayout) ? 32 : 16;
                $dirty1 |= i21;
            } else {
                i3 = i37;
                obj9 = onTextLayout;
            }
        }
        int i38 = black-0d7_KjU & 4096;
        if (i38 != 0) {
            $dirty1 |= 384;
            i32 = i38;
            obj7 = interactionSource;
        } else {
            i32 = i38;
            if (i60 & 384 == 0) {
                changed2 = restartGroup.changed(interactionSource) ? 256 : 128;
                $dirty1 |= changed2;
            } else {
                obj7 = interactionSource;
            }
        }
        int i40 = black-0d7_KjU & 8192;
        if (i40 != 0) {
            $dirty1 |= 3072;
            i2 = i40;
            obj11 = cursorBrush;
        } else {
            i2 = i40;
            if (i60 & 3072 == 0) {
                if (restartGroup.changed(cursorBrush)) {
                } else {
                    i29 = changedInstance2;
                }
                $dirty1 |= i29;
            } else {
                obj11 = cursorBrush;
            }
        }
        int i41 = black-0d7_KjU & 16384;
        if (i41 != 0) {
            $dirty1 |= 24576;
            i24 = i41;
            obj = decorationBox;
        } else {
            i24 = i41;
            if (i60 & 24576 == 0) {
                if (restartGroup.changedInstance(decorationBox)) {
                } else {
                    i12 = i11;
                }
                $dirty1 |= i12;
            } else {
                obj = decorationBox;
            }
        }
        if ($dirty2 & i4 == 306783378 && $dirty1 & 9363 == 9362) {
            if ($dirty1 & 9363 == 9362) {
                if (!restartGroup.getSkipping()) {
                    if (i94 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = obj6;
                    }
                    enabled3 = i9 != 0 ? 1 : obj12;
                    readOnly2 = companion != 0 ? 0 : default;
                    if (i97 != 0) {
                        textStyle2 = TextStyle.Companion.getDefault();
                    } else {
                        textStyle2 = obj8;
                    }
                    if (i98 != 0) {
                        obj10 = default;
                    }
                    if (i95 != 0) {
                        obj5 = iNSTANCE;
                    } else {
                        obj5 = iNSTANCE;
                    }
                    i23 = i26 != 0 ? iNSTANCE : singleLine;
                    i28 = i27 != 0 ? iNSTANCE : maxLines;
                    if (i14 != 0) {
                        obj3 = iNSTANCE;
                    } else {
                        obj3 = visualTransformation;
                    }
                    if (i3 != 0) {
                        i9 = iNSTANCE;
                    } else {
                        i9 = onTextLayout;
                    }
                    if (i32 != 0) {
                        obj37 = modifier3;
                        ComposerKt.sourceInformationMarkerStart(restartGroup, -1242857875, "CC(remember):BasicTextField.kt#9igjgp");
                        iNSTANCE = restartGroup;
                        i4 = 0;
                        obj38 = i57;
                        Object rememberedValue = iNSTANCE.rememberedValue();
                        i3 = 0;
                        obj50 = enabled3;
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            int i83 = 0;
                            iNSTANCE.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                        } else {
                            enabled3 = rememberedValue;
                        }
                        modifier4 = enabled3;
                        ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    } else {
                        obj37 = modifier3;
                        obj50 = enabled3;
                        modifier4 = interactionSource;
                    }
                    if (i2 != 0) {
                        iNSTANCE = Color.Companion;
                        obj38 = modifier4;
                        enabled3 = new SolidColor(iNSTANCE.getBlack-0d7_KjU(), iNSTANCE, 0);
                        i4 = modifier4;
                    } else {
                        obj38 = modifier4;
                        i4 = cursorBrush;
                    }
                    if (i24 != 0) {
                        i3 = modifier4;
                    } else {
                        i3 = decorationBox;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-560482651, $dirty2, $dirty1, "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:847)");
                    }
                    Object obj16 = obj10;
                    i24 = obj38;
                    i30 = $dirty2;
                    i = $dirty1;
                    Object $dirty12 = obj37;
                    boolean z3 = obj50;
                    BasicTextFieldKt.BasicTextField(obj2, onValueChange, $dirty12, z3, readOnly2, textStyle2, obj16, obj5, i23, i28, 1, obj3, i9, i24, i4, i3, restartGroup, i50 | i75, i56 | i25, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj13 = $dirty12;
                    $composer2 = z3;
                    $dirty = readOnly2;
                    modifier2 = textStyle2;
                    enabled2 = obj16;
                    readOnly3 = obj5;
                    textStyle3 = i23;
                    keyboardOptions2 = i28;
                    keyboardActions2 = obj3;
                    singleLine2 = i9;
                    maxLines2 = i24;
                    solidColor = i4;
                    visualTransformation2 = i3;
                } else {
                    restartGroup.skipToGroupEnd();
                    readOnly3 = iNSTANCE;
                    obj13 = obj15;
                    keyboardOptions2 = maxLines;
                    maxLines2 = interactionSource;
                    visualTransformation2 = decorationBox;
                    composer = restartGroup;
                    i30 = $dirty2;
                    i = $dirty1;
                    $composer2 = obj12;
                    $dirty = default;
                    modifier2 = obj8;
                    enabled2 = obj10;
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
            endRestartGroup = new BasicTextFieldKt.BasicTextField.18(value, onValueChange, obj13, $composer2, $dirty, modifier2, enabled2, readOnly3, textStyle3, keyboardOptions2, keyboardActions2, singleLine2, maxLines2, solidColor, visualTransformation2, $changed, $changed1, i19);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    public static final void BasicTextField(String value, Function1<? super String, Unit> onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, androidx.compose.foundation.text.KeyboardOptions keyboardOptions, androidx.compose.foundation.text.KeyboardActions keyboardActions, boolean singleLine, int maxLines, int minLines, VisualTransformation visualTransformation, Function1<? super TextLayoutResult, Unit> onTextLayout, MutableInteractionSource interactionSource, Brush cursorBrush, Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> decorationBox, Composer $composer, int $changed, int $changed1, int i20) {
        boolean z;
        int i18;
        int i6;
        Object i;
        Object obj8;
        Object obj7;
        Object obj;
        Object obj4;
        int skipping;
        int defaultsInvalid;
        boolean enabled3;
        Object enabled2;
        int i25;
        Object cursorBrush2;
        int i4;
        Object it$iv2;
        Object endRestartGroup;
        int traceInProgress;
        int singleLine2;
        int black-0d7_KjU;
        int i21;
        Object mutableStateOf$default;
        Object textFieldValueState$delegate;
        int i36;
        Composer $this$cache$iv;
        Object mutableStateOf$default2;
        Object copy-3r_uNRQ$default;
        boolean z2;
        boolean $composer2;
        int $dirty;
        Object $dirty2;
        int $dirty1;
        Object $dirty13;
        int i32;
        int i35;
        int default;
        Object keyboardActions3;
        Object keyboardActions2;
        Object it$iv;
        int invalid$iv;
        int i5;
        Object modifier2;
        int singleLine4;
        Object singleLine3;
        Composer composer;
        int textStyle2;
        Object obj9;
        int maxLines3;
        VisualTransformation maxLines2;
        int visualTransformation2;
        boolean z4;
        int minLines2;
        androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.6 minLines3;
        int onTextLayout4;
        Object obj2;
        int keyboardOptions2;
        VisualTransformation interactionSource2;
        boolean obj3;
        SolidColor readOnly3;
        androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.6 cursorBrush3;
        Object obj5;
        int textStyle3;
        int i28;
        Object obj6;
        boolean traceInProgress2;
        SolidColor solidColor;
        int i2;
        VisualTransformation visualTransformation3;
        int i3;
        Function3 function3;
        int i15;
        int imeOptions$foundation_release;
        boolean changed2;
        Object i16;
        int i33;
        androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.6 onTextLayout2;
        boolean onTextLayout3;
        int i24;
        boolean z3;
        int readOnly2;
        int interactionSource3;
        Function3 interactionSource4;
        int i7;
        int i22;
        int i8;
        Composer $dirty12;
        int i19;
        int i26;
        int companion2;
        int companion;
        int changed3;
        int i23;
        Object i31;
        int singleLine5;
        int i9;
        int i10;
        int i11;
        int i34;
        int i12;
        int i13;
        int changed;
        int i14;
        int i17;
        int i27;
        int i29;
        int i30;
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
        $dirty = $changed;
        $dirty1 = $changed1;
        if (i59 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (i37 & 6 == 0) {
                i32 = restartGroup.changed(value) ? 4 : 2;
                $dirty |= i32;
            }
        }
        if (i59 & 2 != 0) {
            $dirty |= 48;
        } else {
            if (i37 & 48 == 0) {
                i35 = restartGroup.changedInstance(obj11) ? 32 : 16;
                $dirty |= i35;
            }
        }
        default = i59 & 4;
        if (default != 0) {
            $dirty |= 384;
            obj6 = modifier;
        } else {
            if (i37 & 384 == 0) {
                i2 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty |= i2;
            } else {
                obj6 = modifier;
            }
        }
        visualTransformation3 = i59 & 8;
        changed2 = 1024;
        if (visualTransformation3 != 0) {
            $dirty |= 3072;
            z4 = enabled;
        } else {
            if (i37 & 3072 == 0) {
                i33 = restartGroup.changed(enabled) ? i15 : changed2;
                $dirty |= i33;
            } else {
                z4 = enabled;
            }
        }
        onTextLayout3 = i59 & 16;
        interactionSource4 = 8192;
        if (onTextLayout3 != 0) {
            $dirty |= 24576;
            obj3 = readOnly;
        } else {
            if (i37 & 24576 == 0) {
                i19 = restartGroup.changed(readOnly) ? i24 : interactionSource4;
                $dirty |= i19;
            } else {
                obj3 = readOnly;
            }
        }
        i26 = i59 & 32;
        companion = 196608;
        if (i26 != 0) {
            $dirty |= companion;
            obj5 = textStyle;
        } else {
            if (i37 & companion == 0) {
                i23 = restartGroup.changed(textStyle) ? 131072 : 65536;
                $dirty |= i23;
            } else {
                obj5 = textStyle;
            }
        }
        i31 = i59 & 64;
        singleLine5 = 1572864;
        if (i31 != 0) {
            $dirty |= singleLine5;
            obj2 = keyboardOptions;
        } else {
            if (i37 & singleLine5 == 0) {
                i9 = restartGroup.changed(keyboardOptions) ? 1048576 : 524288;
                $dirty |= i9;
            } else {
                obj2 = keyboardOptions;
            }
        }
        int i67 = i59 & 128;
        i11 = 12582912;
        if (i67 != 0) {
            $dirty |= i11;
            obj9 = keyboardActions;
        } else {
            if (i37 & i11 == 0) {
                i34 = restartGroup.changed(keyboardActions) ? 8388608 : 4194304;
                $dirty |= i34;
            } else {
                obj9 = keyboardActions;
            }
        }
        int i38 = i59 & 256;
        int i113 = 100663296;
        if (i38 != 0) {
            $dirty |= i113;
            i12 = i38;
            z = singleLine;
        } else {
            if ($changed & i113 == 0) {
                i12 = i38;
                i13 = restartGroup.changed(singleLine) ? 67108864 : 33554432;
                $dirty |= i13;
            } else {
                i12 = i38;
                z = singleLine;
            }
        }
        if ($changed & i115 == 0) {
            if (i59 & 512 == 0) {
                changed = restartGroup.changed(maxLines) ? 536870912 : 268435456;
            } else {
                i18 = maxLines;
            }
            $dirty |= changed;
        } else {
            i18 = maxLines;
        }
        int i40 = i59 & 1024;
        if (i40 != 0) {
            $dirty1 |= 6;
            i14 = i40;
            i6 = minLines;
        } else {
            if (black-0d7_KjU & 6 == 0) {
                i14 = i40;
                i17 = restartGroup.changed(minLines) ? 4 : 2;
                $dirty1 |= i17;
            } else {
                i14 = i40;
                i6 = minLines;
            }
        }
        int i41 = i59 & 2048;
        if (i41 != 0) {
            $dirty1 |= 48;
            i27 = i41;
            i = visualTransformation;
        } else {
            if (black-0d7_KjU & 48 == 0) {
                i27 = i41;
                i29 = restartGroup.changed(visualTransformation) ? 32 : 16;
                $dirty1 |= i29;
            } else {
                i27 = i41;
                i = visualTransformation;
            }
        }
        int i42 = i59 & 4096;
        if (i42 != 0) {
            $dirty1 |= 384;
            i30 = i42;
            obj8 = onTextLayout;
        } else {
            i30 = i42;
            if (black-0d7_KjU & 384 == 0) {
                i7 = restartGroup.changedInstance(onTextLayout) ? 256 : 128;
                $dirty1 |= i7;
            } else {
                obj8 = onTextLayout;
            }
        }
        int i44 = i59 & 8192;
        if (i44 != 0) {
            $dirty1 |= 3072;
            i22 = i44;
            obj7 = interactionSource;
        } else {
            i22 = i44;
            if (black-0d7_KjU & 3072 == 0) {
                if (restartGroup.changed(interactionSource)) {
                } else {
                    i15 = changed2;
                }
                $dirty1 |= i15;
            } else {
                obj7 = interactionSource;
            }
        }
        int i45 = i59 & 16384;
        if (i45 != 0) {
            $dirty1 |= 24576;
            imeOptions$foundation_release = i45;
            obj = cursorBrush;
        } else {
            imeOptions$foundation_release = i45;
            if (black-0d7_KjU & 24576 == 0) {
                if (restartGroup.changed(cursorBrush)) {
                } else {
                    i24 = interactionSource4;
                }
                $dirty1 |= i24;
            } else {
                obj = cursorBrush;
            }
        }
        i16 = i59 & i109;
        if (i16 != 0) {
            $dirty1 |= companion;
            obj4 = decorationBox;
        } else {
            if (black-0d7_KjU & companion == 0) {
                i24 = restartGroup.changedInstance(decorationBox) ? 131072 : 65536;
                $dirty1 |= i24;
            } else {
                obj4 = decorationBox;
            }
        }
        if ($dirty & i110 == 306783378 && i48 &= $dirty1 == 74898) {
            if (i48 &= $dirty1 == 74898) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    int i111 = 1;
                    if ($changed & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if (default != 0) {
                                obj6 = defaultsInvalid;
                            }
                            enabled3 = visualTransformation3 != 0 ? 1 : z4;
                            if (onTextLayout3 != 0) {
                                obj3 = default;
                            }
                            if (i26 != 0) {
                                obj5 = default;
                            }
                            if (i31 != 0) {
                                obj2 = default;
                            }
                            if (i67 != 0) {
                                keyboardActions3 = KeyboardActions.Companion.getDefault();
                            } else {
                                keyboardActions3 = obj9;
                            }
                            singleLine4 = i12 != 0 ? 0 : singleLine;
                            if (i59 & 512 != 0) {
                                maxLines3 = singleLine4 != 0 ? i111 : 0x7fffffff /* Unknown resource */;
                                $dirty &= z4;
                            } else {
                                maxLines3 = maxLines;
                            }
                            minLines2 = i14 != 0 ? 1 : minLines;
                            if (i27 != 0) {
                                visualTransformation3 = VisualTransformation.Companion.getNone();
                            } else {
                                visualTransformation3 = visualTransformation;
                            }
                            if (i30 != 0) {
                                onTextLayout2 = BasicTextFieldKt.BasicTextField.6.INSTANCE;
                            } else {
                                onTextLayout2 = onTextLayout;
                            }
                            interactionSource3 = i22 != 0 ? 0 : interactionSource;
                            if (imeOptions$foundation_release != 0) {
                                obj38 = enabled3;
                                traceInProgress = new SolidColor(Color.Companion.getBlack-0d7_KjU(), i59, 0);
                                enabled2 = traceInProgress;
                            } else {
                                obj38 = enabled3;
                                enabled2 = cursorBrush;
                            }
                            if (i16 != 0) {
                                readOnly3 = enabled2;
                                cursorBrush2 = obj2;
                                keyboardOptions2 = interactionSource3;
                                interactionSource4 = lambda-1$foundation_release;
                                singleLine2 = singleLine4;
                                singleLine3 = obj5;
                                textStyle3 = i111;
                                z3 = z5;
                                i16 = keyboardActions3;
                                i21 = maxLines3;
                                i36 = minLines2;
                                keyboardActions2 = obj6;
                                maxLines2 = visualTransformation3;
                                minLines3 = onTextLayout2;
                                onTextLayout3 = obj38;
                            } else {
                                i16 = keyboardActions3;
                                singleLine2 = singleLine4;
                                i21 = maxLines3;
                                i36 = minLines2;
                                singleLine3 = obj5;
                                keyboardActions2 = obj6;
                                maxLines2 = visualTransformation3;
                                minLines3 = onTextLayout2;
                                textStyle3 = i111;
                                onTextLayout3 = obj38;
                                z3 = obj3;
                                readOnly3 = enabled2;
                                cursorBrush2 = obj2;
                                keyboardOptions2 = interactionSource3;
                                interactionSource4 = decorationBox;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            if (i59 & 512 != 0) {
                                $dirty &= i25;
                            }
                            singleLine2 = singleLine;
                            i21 = maxLines;
                            i36 = minLines;
                            interactionSource4 = decorationBox;
                            i16 = obj9;
                            onTextLayout3 = z4;
                            cursorBrush2 = obj2;
                            singleLine3 = obj5;
                            keyboardActions2 = obj6;
                            textStyle3 = i111;
                            maxLines2 = visualTransformation;
                            minLines3 = onTextLayout;
                            keyboardOptions2 = interactionSource;
                            z3 = obj3;
                            readOnly3 = cursorBrush;
                        }
                    } else {
                    }
                    restartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(945255183, $dirty, $dirty1, "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:611)");
                    }
                    String str3 = "CC(remember):BasicTextField.kt#9igjgp";
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1243232097, str3);
                    int i89 = 0;
                    obj46 = restartGroup;
                    int i102 = 0;
                    obj47 = i21;
                    mutableStateOf$default = obj46.rememberedValue();
                    int i106 = 0;
                    obj48 = i36;
                    if (mutableStateOf$default == Composer.Companion.getEmpty()) {
                        obj38 = textFieldValue2;
                        super(value, 0, textStyle, 0, 6, 0);
                        obj38 = obj39;
                        obj39 = i61;
                        i8 = $dirty1;
                        int i62 = 0;
                        obj46.updateRememberedValue(SnapshotStateKt.mutableStateOf$default(obj38, i62, 2, i62));
                    } else {
                        $this$cache$iv = obj46;
                        obj38 = mutableStateOf$default;
                        i8 = $dirty1;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    obj39 = value;
                    copy-3r_uNRQ$default = TextFieldValue.copy-3r_uNRQ$default(BasicTextFieldKt.BasicTextField$lambda$21((MutableState)mutableStateOf$default), obj39, 0, textStyle, 0, 6);
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1243220642, str3);
                    obj38 = restartGroup;
                    int i104 = 0;
                    it$iv = obj38.rememberedValue();
                    int i107 = 0;
                    if (!restartGroup.changed(copy-3r_uNRQ$default)) {
                        obj40 = singleLine3;
                        if (it$iv == Composer.Companion.getEmpty()) {
                            int textStyle4 = 0;
                            obj41 = it$iv;
                            it$iv = new BasicTextFieldKt.BasicTextField.7.1(copy-3r_uNRQ$default, mutableStateOf$default);
                            obj38.updateRememberedValue((Function0)it$iv);
                        } else {
                            composer = obj38;
                            obj41 = it$iv;
                        }
                    } else {
                        obj40 = singleLine3;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    int i68 = 0;
                    EffectsKt.SideEffect((Function0)it$iv, restartGroup, i68);
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1243203633, str3);
                    invalid$iv = $dirty & 14 == 4 ? 1 : i68;
                    Composer composer3 = restartGroup;
                    int i105 = 0;
                    Object rememberedValue = composer3.rememberedValue();
                    int i108 = 0;
                    if (invalid$iv == 0) {
                        obj41 = copy-3r_uNRQ$default;
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            obj42 = textFieldValue;
                            obj43 = invalid$iv;
                            int i60 = 0;
                            composer3.updateRememberedValue(SnapshotStateKt.mutableStateOf$default(obj39, i60, 2, i60));
                        } else {
                            obj43 = invalid$iv;
                            mutableStateOf$default2 = rememberedValue;
                        }
                    } else {
                        obj41 = copy-3r_uNRQ$default;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    i3 = singleLine2 != 0 ? 1 : obj48;
                    i5 = singleLine2 != 0 ? 1 : obj47;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1243199525, str3);
                    i4 = $dirty & 112 == 32 ? 1 : 0;
                    Composer composer2 = restartGroup;
                    int i95 = 0;
                    it$iv2 = composer2.rememberedValue();
                    int i112 = 0;
                    if (i4 |= changed5 == 0) {
                        singleLine5 = singleLine2;
                        if (it$iv2 == Composer.Companion.getEmpty()) {
                            singleLine2 = 0;
                            obj42 = it$iv2;
                            it$iv2 = new BasicTextFieldKt.BasicTextField.8.1(obj11, mutableStateOf$default, mutableStateOf$default2);
                            composer2.updateRememberedValue((Function1)it$iv2);
                        } else {
                            obj42 = it$iv2;
                        }
                    } else {
                        singleLine5 = singleLine2;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    Object obj14 = obj40;
                    i10 = i8;
                    Object obj13 = obj39;
                    CoreTextFieldKt.CoreTextField(obj41, (Function1)it$iv2, obj13, obj14, maxLines2, minLines3, keyboardOptions2, readOnly3, singleLine2 ^ 1, i5, i3, cursorBrush2.toImeOptions$foundation_release(singleLine2), i16, onTextLayout3, z3, interactionSource4, restartGroup, i54 | i79, i58 | i84, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    textFieldValueState$delegate = obj13;
                    $dirty2 = obj14;
                    i28 = keyboardOptions2;
                    solidColor = readOnly3;
                    modifier2 = i16;
                    z2 = onTextLayout3;
                    $composer2 = z3;
                    function3 = interactionSource4;
                    $dirty13 = i31;
                    textStyle2 = singleLine5;
                    readOnly2 = skipping;
                    interactionSource2 = maxLines2;
                    cursorBrush3 = minLines3;
                    visualTransformation2 = obj47;
                    onTextLayout4 = obj48;
                } else {
                    restartGroup.skipToGroupEnd();
                    textStyle2 = singleLine;
                    function3 = decorationBox;
                    $dirty12 = restartGroup;
                    readOnly2 = $dirty;
                    i10 = $dirty1;
                    modifier2 = obj9;
                    z2 = z4;
                    $dirty13 = obj2;
                    $composer2 = obj3;
                    $dirty2 = obj5;
                    textFieldValueState$delegate = obj6;
                    visualTransformation2 = maxLines;
                    onTextLayout4 = minLines;
                    interactionSource2 = visualTransformation;
                    cursorBrush3 = onTextLayout;
                    i28 = interactionSource;
                    solidColor = cursorBrush;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = $dirty12.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new BasicTextFieldKt.BasicTextField.9(value, obj11, textFieldValueState$delegate, z2, $composer2, $dirty2, $dirty13, modifier2, textStyle2, visualTransformation2, onTextLayout4, interactionSource2, cursorBrush3, i28, solidColor, function3, $changed, $changed1, i20);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    public static final void BasicTextField(String value, Function1 onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, androidx.compose.foundation.text.KeyboardOptions keyboardOptions, androidx.compose.foundation.text.KeyboardActions keyboardActions, boolean singleLine, int maxLines, VisualTransformation visualTransformation, Function1 onTextLayout, MutableInteractionSource interactionSource, Brush cursorBrush, Function3 decorationBox, Composer $composer, int $changed, int $changed1, int i19) {
        boolean z;
        int i;
        Object obj;
        Object obj13;
        Object obj4;
        Object obj12;
        Object obj14;
        int traceInProgress;
        Object modifier3;
        Object modifier2;
        boolean traceInProgress2;
        Object endRestartGroup;
        int i15;
        boolean enabled3;
        int black-0d7_KjU;
        Object iNSTANCE;
        Object obj5;
        boolean $composer2;
        int $dirty2;
        boolean $dirty;
        int $dirty1;
        Object modifier4;
        Object obj9;
        Object enabled2;
        Object obj10;
        boolean readOnly2;
        Object readOnly3;
        boolean obj6;
        Object textStyle3;
        int textStyle2;
        int i30;
        Object obj11;
        int keyboardOptions2;
        boolean default;
        Object obj8;
        VisualTransformation keyboardActions2;
        Object obj7;
        int i20;
        androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.13 singleLine2;
        int i17;
        int i2;
        Object maxLines2;
        Object obj2;
        SolidColor solidColor;
        Object obj3;
        Function3 visualTransformation2;
        int i12;
        Object i10;
        int i3;
        int i31;
        int changedInstance2;
        int i18;
        int i6;
        int i11;
        int i32;
        int companion;
        Composer composer;
        int i8;
        int i21;
        int i24;
        int i25;
        int i16;
        int i29;
        int changed;
        int i5;
        int i7;
        int i14;
        int changed2;
        int i23;
        int i26;
        int i4;
        int i13;
        int i9;
        int i27;
        int i28;
        int i22;
        boolean changedInstance;
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
            obj9 = value;
        } else {
            if (i33 & 6 == 0) {
                i30 = restartGroup.changed(value) ? 4 : 2;
                $dirty2 |= i30;
            } else {
                obj9 = value;
            }
        }
        if (black-0d7_KjU & 2 != 0) {
            $dirty2 |= 48;
            obj11 = onValueChange;
        } else {
            if (i33 & 48 == 0) {
                i17 = restartGroup.changedInstance(onValueChange) ? 32 : 16;
                $dirty2 |= i17;
            } else {
                obj11 = onValueChange;
            }
        }
        int i94 = black-0d7_KjU & 4;
        if (i94 != 0) {
            $dirty2 |= 384;
            obj10 = modifier;
        } else {
            if (i33 & 384 == 0) {
                i12 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty2 |= i12;
            } else {
                obj10 = modifier;
            }
        }
        i10 = black-0d7_KjU & 8;
        changedInstance2 = 1024;
        if (i10 != 0) {
            $dirty2 |= 3072;
            obj6 = enabled;
        } else {
            if (i33 & 3072 == 0) {
                i32 = restartGroup.changed(enabled) ? i3 : changedInstance2;
                $dirty2 |= i32;
            } else {
                obj6 = enabled;
            }
        }
        companion = black-0d7_KjU & 16;
        i21 = 8192;
        if (companion != 0) {
            $dirty2 |= 24576;
            default = readOnly;
        } else {
            if (i33 & 24576 == 0) {
                i16 = restartGroup.changed(readOnly) ? i8 : i21;
                $dirty2 |= i16;
            } else {
                default = readOnly;
            }
        }
        int i97 = black-0d7_KjU & 32;
        changed = 196608;
        if (i97 != 0) {
            $dirty2 |= changed;
            obj7 = textStyle;
        } else {
            if (i33 & changed == 0) {
                i14 = restartGroup.changed(textStyle) ? 131072 : 65536;
                $dirty2 |= i14;
            } else {
                obj7 = textStyle;
            }
        }
        int i98 = black-0d7_KjU & 64;
        changed2 = 1572864;
        if (i98 != 0) {
            $dirty2 |= changed2;
            obj2 = keyboardOptions;
        } else {
            if (i33 & changed2 == 0) {
                i23 = restartGroup.changed(keyboardOptions) ? 1048576 : 524288;
                $dirty2 |= i23;
            } else {
                obj2 = keyboardOptions;
            }
        }
        int i95 = black-0d7_KjU & 128;
        i26 = 12582912;
        if (i95 != 0) {
            $dirty2 |= i26;
            iNSTANCE = keyboardActions;
        } else {
            if (i33 & i26 == 0) {
                i4 = restartGroup.changed(keyboardActions) ? 8388608 : 4194304;
                $dirty2 |= i4;
            } else {
                iNSTANCE = keyboardActions;
            }
        }
        int i34 = black-0d7_KjU & 256;
        int i99 = 100663296;
        if (i34 != 0) {
            $dirty2 |= i99;
            i13 = i34;
            z = singleLine;
        } else {
            if ($changed & i99 == 0) {
                i13 = i34;
                i9 = restartGroup.changed(singleLine) ? 67108864 : 33554432;
                $dirty2 |= i9;
            } else {
                i13 = i34;
                z = singleLine;
            }
        }
        int i35 = black-0d7_KjU & 512;
        int i101 = 805306368;
        if (i35 != 0) {
            $dirty2 |= i101;
            i27 = i35;
            i = maxLines;
        } else {
            if ($changed & i101 == 0) {
                i27 = i35;
                i28 = restartGroup.changed(maxLines) ? 536870912 : 268435456;
                $dirty2 |= i28;
            } else {
                i27 = i35;
                i = maxLines;
            }
        }
        int i36 = black-0d7_KjU & 1024;
        if (i36 != 0) {
            $dirty1 |= 6;
            i22 = i36;
            obj = visualTransformation;
        } else {
            if (i60 & 6 == 0) {
                i22 = i36;
                i6 = restartGroup.changed(visualTransformation) ? 4 : 2;
                $dirty1 |= i6;
            } else {
                i22 = i36;
                obj = visualTransformation;
            }
        }
        int i37 = black-0d7_KjU & 2048;
        if (i37 != 0) {
            $dirty1 |= 48;
            i11 = i37;
            obj13 = onTextLayout;
        } else {
            if (i60 & 48 == 0) {
                i11 = i37;
                i24 = restartGroup.changedInstance(onTextLayout) ? 32 : 16;
                $dirty1 |= i24;
            } else {
                i11 = i37;
                obj13 = onTextLayout;
            }
        }
        int i38 = black-0d7_KjU & 4096;
        if (i38 != 0) {
            $dirty1 |= 384;
            i25 = i38;
            obj4 = interactionSource;
        } else {
            i25 = i38;
            if (i60 & 384 == 0) {
                changed2 = restartGroup.changed(interactionSource) ? 256 : 128;
                $dirty1 |= changed2;
            } else {
                obj4 = interactionSource;
            }
        }
        int i40 = black-0d7_KjU & 8192;
        if (i40 != 0) {
            $dirty1 |= 3072;
            i5 = i40;
            obj12 = cursorBrush;
        } else {
            i5 = i40;
            if (i60 & 3072 == 0) {
                if (restartGroup.changed(cursorBrush)) {
                } else {
                    i3 = changedInstance2;
                }
                $dirty1 |= i3;
            } else {
                obj12 = cursorBrush;
            }
        }
        int i41 = black-0d7_KjU & 16384;
        if (i41 != 0) {
            $dirty1 |= 24576;
            i31 = i41;
            obj14 = decorationBox;
        } else {
            i31 = i41;
            if (i60 & 24576 == 0) {
                if (restartGroup.changedInstance(decorationBox)) {
                } else {
                    i8 = i21;
                }
                $dirty1 |= i8;
            } else {
                obj14 = decorationBox;
            }
        }
        if ($dirty2 & i18 == 306783378 && $dirty1 & 9363 == 9362) {
            if ($dirty1 & 9363 == 9362) {
                if (!restartGroup.getSkipping()) {
                    if (i94 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = obj10;
                    }
                    enabled3 = i10 != 0 ? 1 : obj6;
                    readOnly2 = companion != 0 ? 0 : default;
                    if (i97 != 0) {
                        textStyle3 = TextStyle.Companion.getDefault();
                    } else {
                        textStyle3 = obj7;
                    }
                    if (i98 != 0) {
                        obj2 = default;
                    }
                    if (i95 != 0) {
                        obj8 = iNSTANCE;
                    } else {
                        obj8 = iNSTANCE;
                    }
                    i20 = i13 != 0 ? iNSTANCE : singleLine;
                    i2 = i27 != 0 ? iNSTANCE : maxLines;
                    if (i22 != 0) {
                        obj3 = iNSTANCE;
                    } else {
                        obj3 = visualTransformation;
                    }
                    if (i11 != 0) {
                        i10 = iNSTANCE;
                    } else {
                        i10 = onTextLayout;
                    }
                    if (i25 != 0) {
                        obj37 = modifier3;
                        ComposerKt.sourceInformationMarkerStart(restartGroup, -1242906675, "CC(remember):BasicTextField.kt#9igjgp");
                        iNSTANCE = restartGroup;
                        i18 = 0;
                        obj38 = i57;
                        Object rememberedValue = iNSTANCE.rememberedValue();
                        i11 = 0;
                        obj50 = enabled3;
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            int i83 = 0;
                            iNSTANCE.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                        } else {
                            enabled3 = rememberedValue;
                        }
                        modifier2 = enabled3;
                        ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    } else {
                        obj37 = modifier3;
                        obj50 = enabled3;
                        modifier2 = interactionSource;
                    }
                    if (i5 != 0) {
                        iNSTANCE = Color.Companion;
                        obj38 = modifier2;
                        enabled3 = new SolidColor(iNSTANCE.getBlack-0d7_KjU(), iNSTANCE, 0);
                        i18 = modifier2;
                    } else {
                        obj38 = modifier2;
                        i18 = cursorBrush;
                    }
                    if (i31 != 0) {
                        i11 = modifier2;
                    } else {
                        i11 = decorationBox;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-454732590, $dirty2, $dirty1, "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:807)");
                    }
                    Object obj16 = obj2;
                    i31 = obj38;
                    i7 = $dirty2;
                    i29 = $dirty1;
                    Object $dirty12 = obj37;
                    boolean z3 = obj50;
                    BasicTextFieldKt.BasicTextField(obj9, onValueChange, $dirty12, z3, readOnly2, textStyle3, obj16, obj8, i20, i2, 1, obj3, i10, i31, i18, i11, restartGroup, i50 | i75, i56 | i15, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj5 = $dirty12;
                    $composer2 = z3;
                    $dirty = readOnly2;
                    modifier4 = textStyle3;
                    enabled2 = obj16;
                    readOnly3 = obj8;
                    textStyle2 = i20;
                    keyboardOptions2 = i2;
                    keyboardActions2 = obj3;
                    singleLine2 = i10;
                    maxLines2 = i31;
                    solidColor = i18;
                    visualTransformation2 = i11;
                } else {
                    restartGroup.skipToGroupEnd();
                    readOnly3 = iNSTANCE;
                    obj5 = obj15;
                    keyboardOptions2 = maxLines;
                    maxLines2 = interactionSource;
                    visualTransformation2 = decorationBox;
                    composer = restartGroup;
                    i7 = $dirty2;
                    i29 = $dirty1;
                    $composer2 = obj6;
                    $dirty = default;
                    modifier4 = obj7;
                    enabled2 = obj2;
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
            endRestartGroup = new BasicTextFieldKt.BasicTextField.15(value, onValueChange, obj5, $composer2, $dirty, modifier4, enabled2, readOnly3, textStyle2, keyboardOptions2, keyboardActions2, singleLine2, maxLines2, solidColor, visualTransformation2, $changed, $changed1, i19);
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
        int i3;
        int traceInProgress;
        boolean traceInProgress2;
        Object obj;
        int pointerInput;
        long minTouchTargetSizeForHandles;
        int rememberedValue;
        int i2;
        Object derivedStateOf;
        androidx.compose.foundation.text.BasicTextFieldKt.TextFieldCursorHandle.cursorHandleState.2.1 empty;
        Object anon;
        Object anon2;
        int i;
        int obj13;
        invalid$iv = 1991581797;
        final Composer restartGroup = $composer.startRestartGroup(invalid$iv);
        ComposerKt.sourceInformation(restartGroup, "C(TextFieldCursorHandle)416@20789L124:BasicTextField.kt#423gt5");
        pointerInput = 2;
        if ($changed & 6 == 0) {
            i3 = restartGroup.changedInstance(selectionState) ? 4 : pointerInput;
            obj13 |= i3;
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
                i2 = 0;
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    int i10 = 0;
                    empty = new BasicTextFieldKt.TextFieldCursorHandle.cursorHandleState.2.1(selectionState);
                    composer.updateRememberedValue(SnapshotStateKt.derivedStateOf((Function0)empty));
                } else {
                    derivedStateOf = rememberedValue;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (BasicTextFieldKt.TextFieldCursorHandle$lambda$9((State)derivedStateOf).getVisible()) {
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
                            anon = new BasicTextFieldKt.TextFieldCursorHandle.1.1(selectionState);
                            composer2.updateRememberedValue((OffsetProvider)anon);
                        } else {
                            anon = rememberedValue2;
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
                            anon2 = new BasicTextFieldKt.TextFieldCursorHandle.2.1(selectionState, 0);
                            composer3.updateRememberedValue((Function2)anon2);
                        } else {
                            anon2 = rememberedValue3;
                        }
                    } else {
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    AndroidCursorHandle_androidKt.CursorHandle-USBMPiE((OffsetProvider)anon, SuspendingPointerInputFilterKt.pointerInput((Modifier)Modifier.Companion, selectionState, (Function2)anon2), BasicTextFieldKt.MinTouchTargetSizeForHandles, 0, restartGroup, 384);
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
            traceInProgress = new BasicTextFieldKt.TextFieldCursorHandle.3(selectionState, $changed);
            endRestartGroup.updateScope((Function2)traceInProgress);
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
        int $dirty2;
        int $dirty;
        boolean traceInProgress2;
        Object invalid$iv;
        Object visible;
        int str;
        int i2;
        Object rememberedValue;
        Object rememberedValue2;
        boolean handlesCrossed2;
        boolean handlesCrossed;
        Object minTouchTargetSizeForHandles;
        Object minTouchTargetSizeForHandles2;
        androidx.compose.foundation.text.BasicTextFieldKt.TextFieldSelectionHandles.startHandleState.2.1 empty3;
        Object anon2;
        Modifier pointerInput;
        Object anon;
        int i;
        int i3;
        Object empty;
        Object empty2;
        State startHandleState$delegate;
        Object endHandleState$delegate;
        final Object obj = selectionState;
        final int i4 = $changed;
        traceInProgress = 2025287684;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(TextFieldSelectionHandles)442@21589L149,465@22467L150:BasicTextField.kt#423gt5");
        rememberedValue2 = 2;
        if (i4 & 6 == 0) {
            str = restartGroup.changedInstance(obj) ? 4 : rememberedValue2;
            $dirty2 |= str;
        }
        final int i25 = $dirty2;
        if (i25 & 3 == rememberedValue2) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, i25, -1, "androidx.compose.foundation.text.TextFieldSelectionHandles (BasicTextField.kt:440)");
                }
                empty = "CC(remember):BasicTextField.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1983345958, empty);
                int i6 = 0;
                Composer composer = restartGroup;
                i2 = 0;
                rememberedValue = composer.rememberedValue();
                handlesCrossed2 = 0;
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    int i15 = 0;
                    empty3 = new BasicTextFieldKt.TextFieldSelectionHandles.startHandleState.2.1(obj);
                    composer.updateRememberedValue(SnapshotStateKt.derivedStateOf((Function0)empty3));
                } else {
                    minTouchTargetSizeForHandles = rememberedValue;
                }
                State invalid$iv3 = minTouchTargetSizeForHandles;
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (BasicTextFieldKt.TextFieldSelectionHandles$lambda$13((State)invalid$iv3).getVisible()) {
                    restartGroup.startReplaceGroup(-1353986043);
                    ComposerKt.sourceInformation(restartGroup, "449@21829L167,457@22207L86,448@21783L584");
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1983338260, empty);
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
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1983326245, empty);
                    empty3 = restartGroup;
                    int i21 = 0;
                    Object rememberedValue5 = empty3.rememberedValue();
                    int i23 = 0;
                    if (!restartGroup.changedInstance(obj)) {
                        if (rememberedValue5 == Composer.Companion.getEmpty()) {
                            empty2 = 0;
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
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1983317861, empty);
                int i8 = 0;
                Composer composer2 = restartGroup;
                str = 0;
                rememberedValue2 = composer2.rememberedValue();
                handlesCrossed = 0;
                if (rememberedValue2 == Composer.Companion.getEmpty()) {
                    int i18 = 0;
                    empty3 = new BasicTextFieldKt.TextFieldSelectionHandles.endHandleState.2.1(obj);
                    composer2.updateRememberedValue(SnapshotStateKt.derivedStateOf((Function0)empty3));
                } else {
                    minTouchTargetSizeForHandles2 = rememberedValue2;
                }
                invalid$iv2 = minTouchTargetSizeForHandles2;
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (BasicTextFieldKt.TextFieldSelectionHandles$lambda$17((State)invalid$iv2).getVisible()) {
                    restartGroup.startReplaceGroup(-1353116090);
                    ComposerKt.sourceInformation(restartGroup, "472@22706L168,480@23082L87,471@22660L583");
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1983310195, empty);
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
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1983298244, empty);
                    empty3 = restartGroup;
                    int i22 = 0;
                    Object rememberedValue6 = empty3.rememberedValue();
                    int i24 = 0;
                    if (!restartGroup.changedInstance(obj)) {
                        if (rememberedValue6 == Composer.Companion.getEmpty()) {
                            empty = 0;
                            endHandleState$delegate = invalid$iv2;
                            empty2 = new BasicTextFieldKt.TextFieldSelectionHandles.4.1(obj, 0);
                            empty3.updateRememberedValue((Function2)empty2);
                        } else {
                            endHandleState$delegate = invalid$iv2;
                            empty2 = rememberedValue6;
                        }
                    } else {
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    AndroidSelectionHandles_androidKt.SelectionHandle-pzduO1o((OffsetProvider)anon, false, BasicTextFieldKt.TextFieldSelectionHandles$lambda$17(invalid$iv2).getDirection(), BasicTextFieldKt.TextFieldSelectionHandles$lambda$17(invalid$iv2).getHandlesCrossed(), BasicTextFieldKt.MinTouchTargetSizeForHandles, empty3, SuspendingPointerInputFilterKt.pointerInput((Modifier)Modifier.Companion, obj, (Function2)empty2), restartGroup, 24624);
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
            $dirty = new BasicTextFieldKt.TextFieldSelectionHandles.5(obj, i4);
            endRestartGroup.updateScope((Function2)$dirty);
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
