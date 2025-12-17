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
        Object obj2;
        Object obj;
        Object obj4;
        Object obj3;
        Object obj7;
        Object obj10;
        boolean changedInstance;
        Object obj6;
        int i10;
        int readOnly3;
        Object obj11;
        int i8;
        boolean traceInProgress;
        boolean z;
        Object default;
        boolean z3;
        Object $composer2;
        int $dirty;
        Object $dirty2;
        int $dirty12;
        Object $dirty1;
        boolean $dirty13;
        Object obj9;
        int readOnly2;
        int i17;
        boolean z2;
        Object inputTransformation2;
        Object inputTransformation3;
        boolean companion;
        int textStyle3;
        Object onKeyboardAction2;
        int onKeyboardAction3;
        int i21;
        int keyboardOptions2;
        Object lineLimits2;
        TextFieldLineLimits lineLimits4;
        Object obj5;
        Object onKeyboardAction4;
        int onTextLayout2;
        int onTextLayout3;
        Object obj12;
        int lineLimits3;
        TextFieldLineLimits textStyle2;
        Object obj8;
        int onTextLayout4;
        int i11;
        Object interactionSource2;
        int interactionSource3;
        int i16;
        int decorator4;
        int decorator2;
        int changed3;
        int cursorBrush2;
        int i29;
        int outputTransformation2;
        int i12;
        int decorator3;
        int i22;
        int i26;
        int i18;
        int i23;
        int i27;
        Composer composer;
        int i2;
        int i14;
        int i;
        int i6;
        int i13;
        int i3;
        int changed2;
        int i15;
        int i4;
        int i28;
        int i9;
        int i20;
        int i5;
        int i7;
        int i25;
        int i24;
        int i30;
        boolean changed;
        ScopeUpdateScope scopeUpdateScope;
        boolean obj37;
        int obj38;
        Object obj13 = decorator;
        int i35 = $changed;
        i8 = $changed1;
        int i61 = i19;
        Composer restartGroup = $composer.startRestartGroup(469439921);
        ComposerKt.sourceInformation(restartGroup, "C(BasicTextField)P(13,7,2,11,3,14,5,8,6,9,4!1,10)184@10988L21,188@11134L610:BasicTextField.kt#423gt5");
        $dirty = $changed;
        $dirty12 = $changed1;
        if (i61 & 1 != 0) {
            $dirty |= 6;
            obj9 = state;
        } else {
            if (i35 & 6 == 0) {
                i21 = restartGroup.changed(state) ? 4 : 2;
                $dirty |= i21;
            } else {
                obj9 = state;
            }
        }
        int i89 = i61 & 2;
        if (i89 != 0) {
            $dirty |= 48;
            obj8 = modifier;
        } else {
            if (i35 & 48 == 0) {
                i11 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i11;
            } else {
                obj8 = modifier;
            }
        }
        int i92 = i61 & 4;
        changed3 = 128;
        if (i92 != 0) {
            $dirty |= 384;
            z2 = enabled;
        } else {
            if (i35 & 384 == 0) {
                i29 = restartGroup.changed(enabled) ? i16 : changed3;
                $dirty |= i29;
            } else {
                z2 = enabled;
            }
        }
        outputTransformation2 = i61 & 8;
        i26 = 1024;
        if (outputTransformation2 != 0) {
            $dirty |= 3072;
            companion = readOnly;
        } else {
            if (i35 & 3072 == 0) {
                i27 = restartGroup.changed(readOnly) ? i12 : i26;
                $dirty |= i27;
            } else {
                companion = readOnly;
            }
        }
        int i96 = i61 & 16;
        i14 = 16384;
        if (i96 != 0) {
            $dirty |= 24576;
            obj5 = inputTransformation;
        } else {
            if (i35 & 24576 == 0) {
                i13 = restartGroup.changed(inputTransformation) ? i14 : i2;
                $dirty |= i13;
            } else {
                obj5 = inputTransformation;
            }
        }
        int i97 = i61 & 32;
        changed2 = 196608;
        if (i97 != 0) {
            $dirty |= changed2;
            obj12 = textStyle;
        } else {
            if (i35 & changed2 == 0) {
                i15 = restartGroup.changed(textStyle) ? 131072 : 65536;
                $dirty |= i15;
            } else {
                obj12 = textStyle;
            }
        }
        int i98 = i61 & 64;
        i4 = 1572864;
        if (i98 != 0) {
            $dirty |= i4;
            default = keyboardOptions;
        } else {
            if (i35 & i4 == 0) {
                i28 = restartGroup.changed(keyboardOptions) ? 1048576 : 524288;
                $dirty |= i28;
            } else {
                default = keyboardOptions;
            }
        }
        int i36 = i61 & 128;
        int i99 = 12582912;
        if (i36 != 0) {
            $dirty |= i99;
            i9 = i36;
            obj2 = onKeyboardAction;
        } else {
            if ($changed & i99 == 0) {
                i9 = i36;
                i20 = restartGroup.changed(onKeyboardAction) ? 8388608 : 4194304;
                $dirty |= i20;
            } else {
                i9 = i36;
                obj2 = onKeyboardAction;
            }
        }
        int i37 = i61 & 256;
        int i101 = 100663296;
        if (i37 != 0) {
            $dirty |= i101;
            i5 = i37;
            obj = lineLimits;
        } else {
            if ($changed & i101 == 0) {
                i5 = i37;
                i7 = restartGroup.changed(lineLimits) ? 67108864 : 33554432;
                $dirty |= i7;
            } else {
                i5 = i37;
                obj = lineLimits;
            }
        }
        int i38 = i61 & 512;
        int i103 = 805306368;
        if (i38 != 0) {
            $dirty |= i103;
            i25 = i38;
            obj4 = onTextLayout;
        } else {
            if ($changed & i103 == 0) {
                i25 = i38;
                i24 = restartGroup.changedInstance(onTextLayout) ? 536870912 : 268435456;
                $dirty |= i24;
            } else {
                i25 = i38;
                obj4 = onTextLayout;
            }
        }
        int i39 = i61 & 1024;
        if (i39 != 0) {
            $dirty12 |= 6;
            i30 = i39;
            obj3 = interactionSource;
        } else {
            if (i8 & 6 == 0) {
                i30 = i39;
                i18 = restartGroup.changed(interactionSource) ? 4 : 2;
                $dirty12 |= i18;
            } else {
                i30 = i39;
                obj3 = interactionSource;
            }
        }
        int i40 = i61 & 2048;
        if (i40 != 0) {
            $dirty12 |= 48;
            i23 = i40;
            obj7 = cursorBrush;
        } else {
            if (i8 & 48 == 0) {
                i23 = i40;
                i = restartGroup.changed(cursorBrush) ? 32 : 16;
                $dirty12 |= i;
            } else {
                i23 = i40;
                obj7 = cursorBrush;
            }
        }
        int i41 = i61 & 4096;
        if (i41 != 0) {
            $dirty12 |= 384;
            i6 = i41;
            obj10 = outputTransformation;
        } else {
            i6 = i41;
            if (i8 & 384 == 0) {
                if (restartGroup.changed(outputTransformation)) {
                } else {
                    i16 = changed3;
                }
                $dirty12 |= i16;
            } else {
                obj10 = outputTransformation;
            }
        }
        changedInstance = i61 & 8192;
        if (changedInstance != null) {
            $dirty12 |= 3072;
            decorator4 = changedInstance;
        } else {
            decorator4 = changedInstance;
            if (i8 & 3072 == 0) {
                if (i8 & 4096 == 0) {
                    changedInstance = restartGroup.changed(obj13);
                } else {
                    changedInstance = restartGroup.changedInstance(obj13);
                }
                if (changedInstance != null) {
                } else {
                    i12 = i26;
                }
                $dirty12 |= i12;
            }
        }
        if (i8 & 24576 == 0) {
            if (i61 & 16384 == 0) {
                if (restartGroup.changed(scrollState)) {
                    i2 = i14;
                }
            } else {
                obj6 = scrollState;
            }
            $dirty12 |= i2;
        } else {
            obj6 = scrollState;
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
                            enabled2 = i92 != 0 ? 1 : z2;
                            readOnly3 = outputTransformation2 != 0 ? 0 : companion;
                            inputTransformation3 = i96 != 0 ? 0 : obj5;
                            if (i97 != 0) {
                                obj12 = companion;
                            }
                            if (i98 != 0) {
                                default = KeyboardOptions.Companion.getDefault();
                            }
                            onKeyboardAction3 = i9 != 0 ? 0 : onKeyboardAction;
                            if (i5 != 0) {
                                lineLimits4 = TextFieldLineLimits.Companion.getDefault();
                            } else {
                                lineLimits4 = lineLimits;
                            }
                            onTextLayout3 = i25 != 0 ? 0 : onTextLayout;
                            interactionSource3 = i30 != 0 ? 0 : interactionSource;
                            if (i23 != 0) {
                                cursorBrush2 = BasicTextFieldDefaults.INSTANCE.getCursorBrush();
                            } else {
                                cursorBrush2 = cursorBrush;
                            }
                            outputTransformation2 = i6 != 0 ? 0 : outputTransformation;
                            decorator2 = decorator4 != 0 ? 0 : decorator;
                            obj37 = enabled2;
                            if (i61 & 16384 != 0) {
                                i45 &= $dirty12;
                                $dirty13 = obj37;
                                i17 = obj38;
                                i26 = rememberScrollState;
                                scrollState2 = onTextLayout3;
                                i22 = decorator2;
                                decorator4 = cursorBrush2;
                                onTextLayout2 = onKeyboardAction3;
                                onKeyboardAction2 = obj12;
                                textStyle2 = lineLimits4;
                                lineLimits2 = default;
                            } else {
                                i17 = obj38;
                                i26 = scrollState;
                                i10 = $dirty12;
                                scrollState2 = onTextLayout3;
                                i22 = decorator2;
                                decorator4 = cursorBrush2;
                                $dirty13 = obj37;
                                onTextLayout2 = onKeyboardAction3;
                                onKeyboardAction2 = obj12;
                                textStyle2 = lineLimits4;
                                lineLimits2 = default;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            if (i61 & 16384 != 0) {
                                interactionSource3 = interactionSource;
                                decorator4 = cursorBrush;
                                outputTransformation2 = outputTransformation;
                                i22 = decorator;
                                i26 = scrollState;
                                i10 = i34;
                                lineLimits2 = default;
                                $dirty13 = z2;
                                i17 = companion;
                                inputTransformation3 = obj5;
                                onKeyboardAction2 = obj12;
                                onTextLayout2 = onKeyboardAction;
                                textStyle2 = lineLimits;
                                scrollState2 = onTextLayout;
                            } else {
                                scrollState2 = onTextLayout;
                                interactionSource3 = interactionSource;
                                decorator4 = cursorBrush;
                                outputTransformation2 = outputTransformation;
                                i22 = decorator;
                                i26 = scrollState;
                                lineLimits2 = default;
                                i10 = $dirty12;
                                $dirty13 = z2;
                                i17 = companion;
                                inputTransformation3 = obj5;
                                onKeyboardAction2 = obj12;
                                onTextLayout2 = onKeyboardAction;
                                textStyle2 = lineLimits;
                            }
                        }
                    } else {
                    }
                    restartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(469439921, $dirty, i10, "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:187)");
                    }
                    i3 = $dirty;
                    Object $dirty3 = obj8;
                    int modifier2 = scrollState2;
                    BasicTextFieldKt.BasicTextField(state, $dirty3, $dirty13, i17, inputTransformation3, onKeyboardAction2, lineLimits2, onTextLayout2, textStyle2, modifier2, interactionSource3, decorator4, 0, outputTransformation2, i22, i26, false, restartGroup, i55 | i77, i60 | i84, 65536);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj11 = $dirty3;
                    z = $dirty13;
                    z3 = i17;
                    $composer2 = inputTransformation3;
                    $dirty2 = onKeyboardAction2;
                    $dirty1 = lineLimits2;
                    readOnly2 = onTextLayout2;
                    inputTransformation2 = textStyle2;
                    textStyle3 = modifier2;
                    keyboardOptions2 = interactionSource3;
                    onKeyboardAction4 = decorator4;
                    lineLimits3 = outputTransformation2;
                    onTextLayout4 = i22;
                    interactionSource2 = i26;
                    decorator3 = i10;
                } else {
                    restartGroup.skipToGroupEnd();
                    readOnly2 = onKeyboardAction;
                    keyboardOptions2 = interactionSource;
                    interactionSource2 = scrollState;
                    composer = restartGroup;
                    i3 = $dirty;
                    decorator3 = $dirty12;
                    z = z2;
                    $composer2 = obj5;
                    $dirty2 = obj12;
                    obj11 = obj8;
                    inputTransformation2 = lineLimits;
                    onKeyboardAction4 = cursorBrush;
                    lineLimits3 = outputTransformation;
                    onTextLayout4 = decorator;
                    $dirty1 = default;
                    z3 = companion;
                    textStyle3 = onTextLayout;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new BasicTextFieldKt.BasicTextField.1(state, obj11, z, z3, $composer2, $dirty2, $dirty1, readOnly2, inputTransformation2, textStyle3, keyboardOptions2, onKeyboardAction4, lineLimits3, onTextLayout4, interactionSource2, $changed, $changed1, i19);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    public static final void BasicTextField(TextFieldState state, Modifier modifier, boolean enabled, boolean readOnly, InputTransformation inputTransformation, TextStyle textStyle, androidx.compose.foundation.text.KeyboardOptions keyboardOptions, KeyboardActionHandler onKeyboardAction, TextFieldLineLimits lineLimits, Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> onTextLayout, MutableInteractionSource interactionSource, Brush cursorBrush, CodepointTransformation codepointTransformation, OutputTransformation outputTransformation, TextFieldDecorator decorator, ScrollState scrollState, boolean isPassword, Composer $composer, int $changed, int $changed1, int i21) {
        boolean z6;
        int skipping;
        int defaultsInvalid;
        boolean readOnly2;
        int i10;
        int i16;
        Object $i$a$CacheBasicTextFieldKt$BasicTextField$textFieldSelectionState$1;
        Object invalid$iv;
        Object directDragGestureInitiator;
        Function0 factory$iv$iv$iv;
        boolean changed3;
        int $dirty4;
        Object $i$a$CacheBasicTextFieldKt$BasicTextField$textLayoutState$1;
        Object $i$a$CacheBasicTextFieldKt$BasicTextField$2;
        Object $this$cache$iv;
        Object traceInProgress2;
        ScopeUpdateScope endRestartGroup;
        Object obj3;
        Object obj4;
        Object obj13;
        Object obj;
        Object obj7;
        Object obj5;
        Object obj12;
        int i35;
        Object obj2;
        int i6;
        int windowInfo;
        Orientation horizontal;
        Integer currentCompositionLocalMap;
        Object obj11;
        boolean changedInstance;
        Object currentTextToolbar;
        boolean z3;
        Composer composer;
        int valueOf;
        boolean z7;
        Object $composer2;
        int $dirty2;
        Object $dirty;
        int $dirty13;
        int $dirty1;
        int $i$a$CacheBasicTextFieldKt$BasicTextField$interactionSource$1;
        int i49;
        int i30;
        int i13;
        Object it$iv;
        TextFieldSelectionState transformedState;
        Object $dirty12;
        int i33;
        int default;
        Object keyboardOptions2;
        int i40;
        Object obj8;
        int onKeyboardAction2;
        TextFieldLineLimits field3;
        boolean i5;
        Object lineLimits2;
        Object rememberedValue;
        int i29;
        Object obj9;
        int textStyle2;
        int i26;
        int i7;
        int i42;
        int i8;
        int i11;
        boolean z2;
        boolean traceInProgress;
        Object density;
        int empty;
        SolidColor enabled2;
        Object obj6;
        int modifier2;
        int i45;
        int onTextLayout2;
        int i36;
        Object obj10;
        int inputTransformation2;
        int i51;
        int i39;
        int codepointTransformation2;
        ScrollState codepointTransformation3;
        int i18;
        int interactionSource3;
        int interactionSource2;
        int i20;
        Object $dirty3;
        int i27;
        int i17;
        int outputTransformation2;
        int i32;
        int i3;
        Object cursorBrush2;
        int i9;
        Composer $composer3;
        Object companion2;
        int i44;
        androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.2.1 field4;
        int i52;
        int decorator2;
        Object iNSTANCE;
        int companion;
        int changed2;
        int textLayoutState;
        int i22;
        int i19;
        int i48;
        int i43;
        int i50;
        Function0 i23;
        int i14;
        int i38;
        int anon;
        int i15;
        int i12;
        int i2;
        int i37;
        int i41;
        int i25;
        int i4;
        int i28;
        boolean changed;
        int booleanValue2;
        boolean windowFocused;
        boolean booleanValue;
        TransformedTextFieldState field2;
        TextFieldSelectionState textFieldSelectionState;
        TextFieldSelectionState field;
        SolidColor solidColor;
        boolean z4;
        boolean z;
        boolean z5;
        ScrollState scrollState3;
        Orientation orientation;
        boolean equal;
        int i31;
        Modifier focusable;
        ScrollState scrollState2;
        Orientation orientation2;
        int i46;
        boolean reverseDirection;
        int i;
        int i47;
        int i34;
        int i24;
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
        $dirty13 = $changed1;
        if (i88 & 1 != 0) {
            $dirty2 |= 6;
        } else {
            if (i65 & 6 == 0) {
                i33 = restartGroup.changed(traceInProgress2) ? 4 : 2;
                $dirty2 |= i33;
            }
        }
        default = i88 & 2;
        if (default != 0) {
            $dirty2 |= 48;
            obj6 = modifier;
        } else {
            if (i65 & 48 == 0) {
                i45 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i45;
            } else {
                obj6 = modifier;
            }
        }
        onTextLayout2 = i88 & 4;
        if (onTextLayout2 != 0) {
            $dirty2 |= 384;
            z2 = enabled;
        } else {
            if (i65 & 384 == 0) {
                i18 = restartGroup.changed(enabled) ? 256 : 128;
                $dirty2 |= i18;
            } else {
                z2 = enabled;
            }
        }
        int i147 = i88 & 8;
        if (i147 != 0) {
            $dirty2 |= 3072;
            i5 = readOnly;
        } else {
            if (i65 & 3072 == 0) {
                i3 = restartGroup.changed(readOnly) ? 2048 : i20;
                $dirty2 |= i3;
            } else {
                i5 = readOnly;
            }
        }
        cursorBrush2 = i88 & 16;
        if (cursorBrush2 != 0) {
            $dirty2 |= 24576;
            obj10 = inputTransformation;
        } else {
            if (i65 & 24576 == 0) {
                i52 = restartGroup.changed(inputTransformation) ? 16384 : 8192;
                $dirty2 |= i52;
            } else {
                obj10 = inputTransformation;
            }
        }
        decorator2 = i88 & 32;
        changed2 = 196608;
        if (decorator2 != 0) {
            $dirty2 |= changed2;
            obj9 = textStyle;
        } else {
            if (i65 & changed2 == 0) {
                i48 = restartGroup.changed(textStyle) ? 131072 : 65536;
                $dirty2 |= i48;
            } else {
                obj9 = textStyle;
            }
        }
        i43 = i88 & 64;
        i50 = 1572864;
        if (i43 != 0) {
            $dirty2 |= i50;
            obj8 = keyboardOptions;
        } else {
            if (i65 & i50 == 0) {
                i38 = restartGroup.changed(keyboardOptions) ? 1048576 : 524288;
                $dirty2 |= i38;
            } else {
                obj8 = keyboardOptions;
            }
        }
        int i66 = i88 & 128;
        int i163 = 12582912;
        if (i66 != 0) {
            $dirty2 |= i163;
            anon = i66;
            obj3 = onKeyboardAction;
        } else {
            if ($changed & i163 == 0) {
                anon = i66;
                i15 = restartGroup.changed(onKeyboardAction) ? 8388608 : 4194304;
                $dirty2 |= i15;
            } else {
                anon = i66;
                obj3 = onKeyboardAction;
            }
        }
        int i67 = i88 & 256;
        int i165 = 100663296;
        if (i67 != 0) {
            $dirty2 |= i165;
            i12 = i67;
            obj4 = lineLimits;
        } else {
            if ($changed & i165 == 0) {
                i12 = i67;
                i2 = restartGroup.changed(lineLimits) ? 67108864 : 33554432;
                $dirty2 |= i2;
            } else {
                i12 = i67;
                obj4 = lineLimits;
            }
        }
        int i68 = i88 & 512;
        int i167 = 805306368;
        if (i68 != 0) {
            $dirty2 |= i167;
            i37 = i68;
            obj13 = onTextLayout;
        } else {
            if ($changed & i167 == 0) {
                i37 = i68;
                i41 = restartGroup.changedInstance(onTextLayout) ? 536870912 : 268435456;
                $dirty2 |= i41;
            } else {
                i37 = i68;
                obj13 = onTextLayout;
            }
        }
        int i69 = i88 & 1024;
        if (i69 != 0) {
            $dirty13 |= 6;
            i25 = i69;
            obj = interactionSource;
        } else {
            if (i83 & 6 == 0) {
                i25 = i69;
                i4 = restartGroup.changed(interactionSource) ? 4 : 2;
                $dirty13 |= i4;
            } else {
                i25 = i69;
                obj = interactionSource;
            }
        }
        int i70 = i88 & 2048;
        if (i70 != 0) {
            $dirty13 |= 48;
            i28 = i70;
            obj7 = cursorBrush;
        } else {
            if (i83 & 48 == 0) {
                i28 = i70;
                i51 = restartGroup.changed(cursorBrush) ? 32 : 16;
                $dirty13 |= i51;
            } else {
                i28 = i70;
                obj7 = cursorBrush;
            }
        }
        int i71 = i88 & 4096;
        if (i71 != 0) {
            $dirty13 |= 384;
            i39 = i71;
            obj5 = codepointTransformation;
        } else {
            i39 = i71;
            if (i83 & 384 == 0) {
                i17 = restartGroup.changed(codepointTransformation) ? 256 : 128;
                $dirty13 |= i17;
            } else {
                obj5 = codepointTransformation;
            }
        }
        int i73 = i88 & 8192;
        if (i73 != 0) {
            $dirty13 |= 3072;
            outputTransformation2 = i73;
            obj12 = outputTransformation;
        } else {
            outputTransformation2 = i73;
            if (i83 & 3072 == 0) {
                if (restartGroup.changed(outputTransformation)) {
                    i20 = 2048;
                }
                $dirty13 |= i20;
            } else {
                obj12 = outputTransformation;
            }
        }
        i35 = i88 & 16384;
        $dirty3 = 32768;
        if (i35 != 0) {
            $dirty13 |= 24576;
            booleanValue2 = i35;
        } else {
            booleanValue2 = i35;
            if (i83 & 24576 == 0) {
                if (i83 & $dirty3 == 0) {
                    changedInstance = restartGroup.changed(obj14);
                } else {
                    changedInstance = restartGroup.changedInstance(obj14);
                }
                i35 = changedInstance != null ? 16384 : 8192;
                $dirty13 |= i35;
            }
        }
        if (i83 & changed2 == 0) {
            if (i88 & $dirty3 == 0) {
                changed2 = restartGroup.changed(scrollState) ? 131072 : 65536;
            } else {
                obj2 = scrollState;
            }
            $dirty13 |= changed2;
        } else {
            obj2 = scrollState;
        }
        textLayoutState = i88 & i161;
        if (textLayoutState != 0) {
            $dirty13 |= i50;
            z6 = isPassword;
        } else {
            if (i83 & i50 == 0) {
                i50 = restartGroup.changed(isPassword) ? 1048576 : 524288;
                $dirty13 |= i50;
            } else {
                z6 = isPassword;
            }
        }
        if ($dirty2 & i23 == 306783378 && i61 &= $dirty13 == 599186) {
            if (i61 &= $dirty13 == 599186) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    if ($changed & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if (default != 0) {
                                obj6 = defaultsInvalid;
                            }
                            if (onTextLayout2 != 0) {
                                z2 = defaultsInvalid;
                            }
                            readOnly2 = i147 != 0 ? 0 : i5;
                            if (cursorBrush2 != 0) {
                                obj10 = default;
                            }
                            if (decorator2 != 0) {
                                obj9 = default;
                            }
                            if (i43 != 0) {
                                keyboardOptions2 = KeyboardOptions.Companion.getDefault();
                            } else {
                                keyboardOptions2 = obj8;
                            }
                            onKeyboardAction2 = anon != 0 ? 0 : onKeyboardAction;
                            if (i12 != 0) {
                                lineLimits2 = TextFieldLineLimits.Companion.getDefault();
                            } else {
                                lineLimits2 = lineLimits;
                            }
                            onTextLayout2 = i37 != 0 ? 0 : onTextLayout;
                            interactionSource3 = i25 != 0 ? 0 : interactionSource;
                            if (i28 != 0) {
                                cursorBrush2 = BasicTextFieldDefaults.INSTANCE.getCursorBrush();
                            } else {
                                cursorBrush2 = cursorBrush;
                            }
                            codepointTransformation2 = i39 != 0 ? 0 : codepointTransformation;
                            outputTransformation2 = outputTransformation2 != 0 ? 0 : outputTransformation;
                            decorator2 = booleanValue2 != 0 ? 0 : decorator;
                            if (i88 & $dirty3 != 0) {
                                obj58 = readOnly2;
                                int readOnly3 = 0;
                                $dirty3 = ScrollKt.rememberScrollState(readOnly3, restartGroup, readOnly3, 1);
                                $dirty13 &= readOnly2;
                            } else {
                                obj58 = readOnly2;
                                $dirty3 = scrollState;
                            }
                            if (textLayoutState != 0) {
                                z5 = obj58;
                                i28 = obj9;
                                z4 = z2;
                                i31 = onTextLayout2;
                                scrollState3 = $dirty3;
                                solidColor = cursorBrush2;
                                i12 = decorator2;
                                textStyle2 = $dirty13;
                                $dirty1 = i53;
                                i16 = outputTransformation2;
                            } else {
                                z5 = obj58;
                                i28 = obj9;
                                z4 = z2;
                                i31 = onTextLayout2;
                                scrollState3 = $dirty3;
                                i16 = outputTransformation2;
                                solidColor = cursorBrush2;
                                i12 = decorator2;
                                textStyle2 = $dirty13;
                                $dirty1 = isPassword;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            if (i88 & $dirty3 != 0) {
                                $dirty13 &= i10;
                            }
                            i31 = onTextLayout;
                            interactionSource3 = interactionSource;
                            solidColor = cursorBrush;
                            codepointTransformation2 = codepointTransformation;
                            i16 = outputTransformation;
                            i12 = decorator;
                            scrollState3 = scrollState;
                            keyboardOptions2 = obj8;
                            z5 = i5;
                            i28 = obj9;
                            z4 = z2;
                            onKeyboardAction2 = onKeyboardAction;
                            lineLimits2 = lineLimits;
                            textStyle2 = $dirty13;
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
                    i27 = 0;
                    i9 = 0;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, str2);
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    Object this_$iv = consume2;
                    equal = Intrinsics.areEqual(lineLimits2, TextFieldLineLimits.SingleLine.INSTANCE);
                    String str3 = "CC(remember):BasicTextField.kt#9igjgp";
                    if (interactionSource3 == 0) {
                        obj69 = this_$iv;
                        restartGroup.startReplaceGroup(96938805);
                        ComposerKt.sourceInformation(restartGroup, "245@13454L39");
                        ComposerKt.sourceInformationMarkerStart(restartGroup, -1243798931, str3);
                        obj58 = restartGroup;
                        i27 = 0;
                        obj59 = i80;
                        Object rememberedValue5 = obj58.rememberedValue();
                        i9 = 0;
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
                        $i$a$CacheBasicTextFieldKt$BasicTextField$interactionSource$1 = interactionSource3;
                    }
                    int i171 = $i$a$CacheBasicTextFieldKt$BasicTextField$interactionSource$1;
                    horizontal = equal ? Orientation.Horizontal : Orientation.Vertical;
                    Orientation orientation3 = orientation4;
                    int keyboardOptions4 = 0;
                    booleanValue2 = (Boolean)FocusInteractionKt.collectIsFocusedAsState((InteractionSource)i171, restartGroup, keyboardOptions4).getValue().booleanValue();
                    windowFocused = obj69.isWindowFocused();
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1243786909, str3);
                    i49 = $dirty2 & 14 == 4 ? 1 : 0;
                    i30 = textStyle2 & 896 == 256 ? 1 : 0;
                    i13 = textStyle2 & 7168 == 2048 ? 1 : 0;
                    Composer composer5 = restartGroup;
                    int i151 = 0;
                    it$iv = composer5.rememberedValue();
                    int i160 = 0;
                    if (obj58 | i13 == 0) {
                        obj71 = onKeyboardAction2;
                        if (it$iv == Composer.Companion.getEmpty()) {
                            if (codepointTransformation2 == 0) {
                                textLayoutState = iNSTANCE;
                                i43 = 0;
                                if (equal) {
                                } else {
                                    iNSTANCE = 0;
                                }
                            } else {
                                iNSTANCE = codepointTransformation2;
                            }
                            obj60 = it$iv;
                            obj61 = onKeyboardAction3;
                            it$iv = new TransformedTextFieldState(traceInProgress2, obj10, iNSTANCE, i16);
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
                    i25 = $i$a$CacheBasicTextFieldKt$BasicTextField$textLayoutState$1;
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1243752821, str3);
                    changed3 = restartGroup.changed(it$iv);
                    Composer composer2 = restartGroup;
                    int i112 = 0;
                    Object rememberedValue6 = composer2.rememberedValue();
                    int i153 = 0;
                    if (!changed3) {
                        obj67 = changed3;
                        if (rememberedValue6 == Composer.Companion.getEmpty()) {
                            int invalid$iv2 = 0;
                            if (booleanValue2 && windowFocused) {
                                textLayoutState = windowFocused ? 1 : 0;
                            } else {
                            }
                            obj61 = this_$iv4;
                            obj58 = textFieldSelectionState3;
                            super(it$iv, (TextLayoutState)i25, obj61, z4, z5, textLayoutState, obj65);
                            $i$a$CacheBasicTextFieldKt$BasicTextField$textFieldSelectionState$1 = obj61;
                            decorator2 = obj65;
                            composer2.updateRememberedValue(obj58);
                        } else {
                            decorator2 = obj65;
                            $i$a$CacheBasicTextFieldKt$BasicTextField$textFieldSelectionState$1 = this_$iv4;
                            density = rememberedValue6;
                        }
                    } else {
                        obj67 = changed3;
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
                    i37 = lineLimits2;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, str2);
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    Object this_$iv3 = consume4;
                    int i138 = 0;
                    int i155 = 0;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, str2);
                    Object consume = restartGroup.consume((CompositionLocal)CompositionLocalsKt.getLocalTextToolbar());
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1243735026, str3);
                    i26 = i127 &= $dirty2 == 16384 ? 1 : 0;
                    i7 = $dirty2 & 896 == 256 ? 1 : 0;
                    i42 = $dirty2 & 7168 == 2048 ? 1 : 0;
                    i8 = i22 & i131 == 1048576 ? 1 : 0;
                    Composer composer7 = restartGroup;
                    empty = 0;
                    obj61 = $i$a$CacheBasicTextFieldKt$BasicTextField$textFieldSelectionState$1;
                    Object rememberedValue3 = composer7.rememberedValue();
                    int i156 = 0;
                    if (i123 |= i8 == 0) {
                        if (rememberedValue3 == Composer.Companion.getEmpty()) {
                            int textFieldSelectionState2 = 0;
                            obj65 = obj61;
                            obj64 = consume;
                            obj59 = it$iv;
                            obj58 = anon2;
                            obj61 = textFieldSelectionState;
                            super(obj59, obj10, obj61, this_$iv2, this_$iv3, obj64, obj65, z4, z5, decorator2);
                            field2 = obj59;
                            transformedState = obj61;
                            companion2 = obj64;
                            currentTextToolbar = obj65;
                            composer7.updateRememberedValue((Function0)obj58);
                        } else {
                            $i$a$CacheBasicTextFieldKt$BasicTextField$2 = rememberedValue3;
                            companion2 = consume;
                            field2 = it$iv;
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
                    obj63 = z4;
                    obj68 = i171;
                    super(field2, i25, obj61, obj10, obj63, z5, obj65, obj66, equal, obj68);
                    field = obj61;
                    boolean z9 = obj63;
                    valueOf = obj66;
                    int i104 = obj68;
                    if (z9 && field.getDirectDragGestureInitiator() == TextFieldSelectionState.InputType.None) {
                        i46 = field.getDirectDragGestureInitiator() == TextFieldSelectionState.InputType.None ? 1 : 0;
                    } else {
                    }
                    int i125 = 0;
                    orientation2 = orientation3;
                    Modifier pointerHoverIcon$default = PointerIconKt.pointerHoverIcon$default(ScrollableKt.scrollable$default(FocusableKt.focusable(obj6.then((Modifier)textFieldDecoratorModifier), z9, i104), (ScrollableState)scrollState3, orientation2, i46, ScrollableDefaults.INSTANCE.reverseDirection((LayoutDirection)restartGroup.consume((CompositionLocal)CompositionLocalsKt.getLocalLayoutDirection()), orientation3, i125), 0, i104, 16, 0), TextPointerIcon_androidKt.getTextPointerIcon(), i125, 2, 0);
                    int i78 = 1;
                    int i106 = 384;
                    int i126 = 0;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    Alignment topStart = Alignment.Companion.getTopStart();
                    i32 = 0;
                    obj58 = topStart;
                    obj59 = i78;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    currentCompositionLocalMap = restartGroup.getCurrentCompositionLocalMap();
                    obj60 = currentCompositeKeyHash;
                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(restartGroup, pointerHoverIcon$default);
                    obj61 = pointerHoverIcon$default;
                    obj62 = constructor;
                    field4 = 0;
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
                    i43 = 0;
                    obj62 = constructor-impl;
                    i14 = 0;
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
                    i19 = 0;
                    obj67 = iNSTANCE3;
                    obj68 = materializeModifier;
                    ComposerKt.sourceInformationMarkerStart(composer4, 1236622543, "C343@17621L2973,343@17571L3023:BasicTextField.kt#423gt5");
                    anon = new BasicTextFieldKt.BasicTextField.4.1(i12, i37, i25, i28, booleanValue2, windowFocused, (Boolean)HoverInteractionKt.collectIsHoveredAsState((InteractionSource)i171, restartGroup, keyboardOptions4).getValue().booleanValue(), field2, field, solidColor, z9, z5, scrollState3, orientation2, equal, i31);
                    obj66 = i84;
                    obj73 = i94;
                    obj74 = restartGroup;
                    ContextMenu_androidKt.ContextMenuArea(field, z9, (Function2)ComposableLambdaKt.rememberComposableLambda(-673241599, true, anon, composer4, 54), composer4, i86 |= 384);
                    ComposerKt.sourceInformationMarkerEnd(composer4);
                    ComposerKt.sourceInformationMarkerEnd(composer4);
                    obj74.endNode();
                    ComposerKt.sourceInformationMarkerEnd(obj74);
                    ComposerKt.sourceInformationMarkerEnd(obj74);
                    ComposerKt.sourceInformationMarkerEnd(obj74);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $dirty12 = obj70;
                    i40 = obj71;
                    $dirty4 = $dirty2;
                    z3 = z9;
                    obj11 = obj6;
                    $composer2 = obj10;
                    modifier2 = codepointTransformation2;
                    i11 = interactionSource3;
                    i36 = cursorBrush2;
                    interactionSource2 = decorator2;
                    inputTransformation2 = i12;
                    field3 = i37;
                    $dirty = i28;
                    enabled2 = solidColor;
                    z7 = z5;
                    codepointTransformation3 = scrollState3;
                    i29 = i31;
                } else {
                    restartGroup.skipToGroupEnd();
                    i40 = onKeyboardAction;
                    i36 = outputTransformation;
                    codepointTransformation3 = scrollState;
                    interactionSource2 = isPassword;
                    obj74 = restartGroup;
                    $dirty4 = $dirty2;
                    i22 = $dirty13;
                    $dirty12 = obj8;
                    z7 = i5;
                    $dirty = obj9;
                    z3 = z2;
                    obj11 = obj6;
                    $composer2 = obj10;
                    field3 = lineLimits;
                    i29 = onTextLayout;
                    i11 = interactionSource;
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
            $composer3 = obj74;
            i44 = i158;
            $dirty4 = new BasicTextFieldKt.BasicTextField.5(state, obj11, z3, z7, $composer2, $dirty, $dirty12, i40, field3, i29, i11, enabled2, modifier2, i36, inputTransformation2, codepointTransformation3, interactionSource2, $changed, $changed1, i21);
            endRestartGroup.updateScope((Function2)$dirty4);
        } else {
            $composer3 = obj74;
            i44 = $dirty4;
        }
    }

    public static final void BasicTextField(TextFieldValue value, Function1<? super TextFieldValue, Unit> onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, androidx.compose.foundation.text.KeyboardOptions keyboardOptions, androidx.compose.foundation.text.KeyboardActions keyboardActions, boolean singleLine, int maxLines, int minLines, VisualTransformation visualTransformation, Function1<? super TextLayoutResult, Unit> onTextLayout, MutableInteractionSource interactionSource, Brush cursorBrush, Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> decorationBox, Composer $composer, int $changed, int $changed1, int i20) {
        boolean traceInProgress2;
        Object endRestartGroup;
        Object obj8;
        boolean z2;
        int i24;
        int i16;
        Object obj;
        Object obj11;
        Object obj5;
        Object obj2;
        Object obj6;
        Object skipping;
        Object modifier2;
        int i13;
        Object it$iv;
        int defaultsInvalid;
        Object modifier5;
        Object modifier3;
        int i11;
        Object textStyle2;
        int solidColor;
        Object obj4;
        int i34;
        boolean visualTransformation3;
        Object keyboardOptions2;
        int black-0d7_KjU;
        Object default;
        boolean onTextLayout2;
        int i30;
        Object $composer2;
        int $dirty;
        Object cursorBrush3;
        int $dirty2;
        int $dirty1;
        Object $dirty12;
        int i7;
        int i3;
        int i5;
        SolidColor singleLine2;
        int cursorBrush2;
        int companion2;
        int singleLine3;
        Object obj3;
        int i8;
        int maxLines2;
        int maxLines3;
        int i15;
        int minLines2;
        boolean traceInProgress;
        boolean z;
        VisualTransformation keyboardActions2;
        Object enabled3;
        Object obj10;
        androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.10 enabled2;
        boolean keyboardOptions4;
        boolean obj9;
        int readOnly2;
        Object obj7;
        SolidColor decorationBox2;
        Object textStyle3;
        int i12;
        Function3 function3;
        Object visualTransformation2;
        int i29;
        int modifier4;
        int i25;
        boolean changed2;
        int i18;
        int i32;
        int onTextLayout3;
        Object onTextLayout4;
        int i31;
        int interactionSource3;
        int interactionSource2;
        int changedInstance;
        int i23;
        int i4;
        int i2;
        int i26;
        int i19;
        int i27;
        int companion;
        int keyboardOptions3;
        Composer composer;
        int changed;
        int i9;
        int i14;
        int i17;
        int i;
        int i21;
        int i22;
        int i6;
        int changed3;
        int i33;
        int i28;
        int i10;
        boolean changedInstance2;
        ScopeUpdateScope scopeUpdateScope;
        Object obj39;
        int obj40;
        Object obj41;
        int obj42;
        Object obj43;
        traceInProgress2 = value;
        obj8 = onValueChange;
        int i39 = $changed;
        int i55 = $changed1;
        black-0d7_KjU = i20;
        Composer restartGroup = $composer.startRestartGroup(1804514146);
        ComposerKt.sourceInformation(restartGroup, "C(BasicTextField)P(14,10,8,2,11,13,5,4,12,6,7,15,9,3)766@39969L90,764@39907L740:BasicTextField.kt#423gt5");
        $dirty = $changed;
        $dirty1 = $changed1;
        if (black-0d7_KjU & 1 != 0) {
            $dirty |= 6;
        } else {
            if (i39 & 6 == 0) {
                i7 = restartGroup.changed(traceInProgress2) ? 4 : 2;
                $dirty |= i7;
            }
        }
        if (black-0d7_KjU & 2 != 0) {
            $dirty |= 48;
        } else {
            if (i39 & 48 == 0) {
                i3 = restartGroup.changedInstance(obj8) ? 32 : 16;
                $dirty |= i3;
            }
        }
        companion2 = black-0d7_KjU & 4;
        if (companion2 != 0) {
            $dirty |= 384;
            obj3 = modifier;
        } else {
            if (i39 & 384 == 0) {
                i12 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty |= i12;
            } else {
                obj3 = modifier;
            }
        }
        int i89 = black-0d7_KjU & 8;
        changed2 = 1024;
        if (i89 != 0) {
            $dirty |= 3072;
            z = enabled;
        } else {
            if (i39 & 3072 == 0) {
                i31 = restartGroup.changed(enabled) ? i29 : changed2;
                $dirty |= i31;
            } else {
                z = enabled;
            }
        }
        interactionSource3 = black-0d7_KjU & 16;
        int i92 = 8192;
        if (interactionSource3 != 0) {
            $dirty |= 24576;
            obj9 = readOnly;
        } else {
            if (i39 & 24576 == 0) {
                i27 = restartGroup.changed(readOnly) ? changedInstance : i92;
                $dirty |= i27;
            } else {
                obj9 = readOnly;
            }
        }
        companion = black-0d7_KjU & 32;
        int i99 = 196608;
        if (companion != 0) {
            $dirty |= i99;
            obj7 = textStyle;
        } else {
            if (i39 & i99 == 0) {
                i9 = restartGroup.changed(textStyle) ? 131072 : keyboardOptions3;
                $dirty |= i9;
            } else {
                obj7 = textStyle;
            }
        }
        int i100 = black-0d7_KjU & 64;
        i14 = 1572864;
        if (i100 != 0) {
            $dirty |= i14;
            obj10 = keyboardOptions;
        } else {
            if (i39 & i14 == 0) {
                i17 = restartGroup.changed(keyboardOptions) ? 1048576 : 524288;
                $dirty |= i17;
            } else {
                obj10 = keyboardOptions;
            }
        }
        minLines2 = black-0d7_KjU & 128;
        i = 12582912;
        if (minLines2 != 0) {
            $dirty |= i;
            default = keyboardActions;
        } else {
            if (i39 & i == 0) {
                i21 = restartGroup.changed(keyboardActions) ? 8388608 : 4194304;
                $dirty |= i21;
            } else {
                default = keyboardActions;
            }
        }
        int i40 = black-0d7_KjU & 256;
        int i101 = 100663296;
        if (i40 != 0) {
            $dirty |= i101;
            i22 = i40;
            z2 = singleLine;
        } else {
            if ($changed & i101 == 0) {
                i22 = i40;
                i6 = restartGroup.changed(singleLine) ? 67108864 : 33554432;
                $dirty |= i6;
            } else {
                i22 = i40;
                z2 = singleLine;
            }
        }
        if ($changed & i103 == 0) {
            if (black-0d7_KjU & 512 == 0) {
                changed3 = restartGroup.changed(maxLines) ? 536870912 : 268435456;
            } else {
                i24 = maxLines;
            }
            $dirty |= changed3;
        } else {
            i24 = maxLines;
        }
        int i42 = black-0d7_KjU & 1024;
        if (i42 != 0) {
            $dirty1 |= 6;
            i33 = i42;
            i16 = minLines;
        } else {
            if (i55 & 6 == 0) {
                i33 = i42;
                i28 = restartGroup.changed(minLines) ? 4 : 2;
                $dirty1 |= i28;
            } else {
                i33 = i42;
                i16 = minLines;
            }
        }
        int i43 = black-0d7_KjU & 2048;
        if (i43 != 0) {
            $dirty1 |= 48;
            i10 = i43;
            obj = visualTransformation;
        } else {
            if (i55 & 48 == 0) {
                i10 = i43;
                i32 = restartGroup.changed(visualTransformation) ? 32 : 16;
                $dirty1 |= i32;
            } else {
                i10 = i43;
                obj = visualTransformation;
            }
        }
        int i44 = black-0d7_KjU & 4096;
        if (i44 != 0) {
            $dirty1 |= 384;
            onTextLayout3 = i44;
            obj11 = onTextLayout;
        } else {
            onTextLayout3 = i44;
            if (i55 & 384 == 0) {
                i2 = restartGroup.changedInstance(onTextLayout) ? 256 : 128;
                $dirty1 |= i2;
            } else {
                obj11 = onTextLayout;
            }
        }
        int i46 = black-0d7_KjU & 8192;
        if (i46 != 0) {
            $dirty1 |= 3072;
            i26 = i46;
            obj5 = interactionSource;
        } else {
            i26 = i46;
            if (i55 & 3072 == 0) {
                if (restartGroup.changed(interactionSource)) {
                } else {
                    i29 = changed2;
                }
                $dirty1 |= i29;
            } else {
                obj5 = interactionSource;
            }
        }
        int i47 = black-0d7_KjU & 16384;
        if (i47 != 0) {
            $dirty1 |= 24576;
            modifier4 = i47;
            obj2 = cursorBrush;
        } else {
            modifier4 = i47;
            if (i55 & 24576 == 0) {
                if (restartGroup.changed(cursorBrush)) {
                } else {
                    changedInstance = i92;
                }
                $dirty1 |= changedInstance;
            } else {
                obj2 = cursorBrush;
            }
        }
        i18 = black-0d7_KjU & i90;
        if (i18 != 0) {
            $dirty1 |= i99;
            obj6 = decorationBox;
        } else {
            if (i55 & i99 == 0) {
                if (restartGroup.changedInstance(decorationBox)) {
                    keyboardOptions3 = 131072;
                }
                $dirty1 |= keyboardOptions3;
            } else {
                obj6 = decorationBox;
            }
        }
        if ($dirty & i23 == 306783378 && i53 &= $dirty1 == 74898) {
            if (i53 &= $dirty1 == 74898) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    if ($changed & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if (companion2 != 0) {
                                modifier5 = Modifier.Companion;
                            } else {
                                modifier5 = obj3;
                            }
                            if (i89 != 0) {
                                z = companion2;
                            }
                            if (interactionSource3 != 0) {
                                obj9 = companion2;
                            }
                            if (companion != 0) {
                                obj7 = companion2;
                            }
                            if (i100 != 0) {
                                obj10 = companion2;
                            }
                            if (minLines2 != 0) {
                                default = KeyboardActions.Companion.getDefault();
                            }
                            singleLine3 = i22 != 0 ? 0 : singleLine;
                            if (black-0d7_KjU & 512 != 0) {
                                maxLines3 = singleLine3 != 0 ? 1 : 0x7fffffff /* Unknown resource */;
                                $dirty &= minLines2;
                            } else {
                                maxLines3 = maxLines;
                            }
                            minLines2 = i33 != 0 ? 1 : minLines;
                            if (i10 != 0) {
                                visualTransformation2 = VisualTransformation.Companion.getNone();
                            } else {
                                visualTransformation2 = visualTransformation;
                            }
                            if (onTextLayout3 != 0) {
                                onTextLayout4 = BasicTextFieldKt.BasicTextField.10.INSTANCE;
                            } else {
                                onTextLayout4 = onTextLayout;
                            }
                            interactionSource2 = i26 != 0 ? 0 : interactionSource;
                            if (modifier4 != 0) {
                                obj39 = default;
                                modifier4 = modifier5;
                                solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), default, 0);
                                modifier3 = solidColor;
                            } else {
                                modifier4 = modifier5;
                                obj39 = default;
                                modifier3 = cursorBrush;
                            }
                            if (i18 != 0) {
                                textStyle3 = lambda-2$foundation_release;
                                obj4 = obj13;
                                maxLines2 = $dirty;
                                $dirty2 = interactionSource2;
                                interactionSource3 = i83;
                                i30 = singleLine3;
                                i23 = minLines2;
                                keyboardOptions2 = obj10;
                                singleLine2 = modifier3;
                                keyboardOptions4 = z;
                                modifier2 = modifier4;
                                enabled3 = obj39;
                            } else {
                                maxLines2 = $dirty;
                                $dirty2 = interactionSource2;
                                interactionSource3 = decorationBox3;
                                i30 = singleLine3;
                                i23 = minLines2;
                                keyboardOptions2 = obj10;
                                obj4 = obj7;
                                textStyle3 = decorationBox;
                                singleLine2 = modifier3;
                                keyboardOptions4 = z;
                                modifier2 = modifier4;
                                enabled3 = obj39;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            if (black-0d7_KjU & 512 != 0) {
                                $dirty &= i11;
                            }
                            interactionSource3 = maxLines;
                            i23 = minLines;
                            visualTransformation2 = visualTransformation;
                            onTextLayout4 = onTextLayout;
                            singleLine2 = cursorBrush;
                            modifier2 = obj3;
                            keyboardOptions2 = obj10;
                            obj4 = obj7;
                            textStyle3 = decorationBox;
                            maxLines2 = $dirty;
                            keyboardOptions4 = z;
                            $dirty2 = interactionSource;
                            enabled3 = default;
                            i30 = singleLine;
                        }
                    } else {
                    }
                    restartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        obj39 = modifier2;
                        ComposerKt.traceEventStart(1804514146, maxLines2, $dirty1, "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:763)");
                    } else {
                        obj39 = modifier2;
                    }
                    i25 = i30 != 0 ? 1 : i23;
                    SolidColor interactionSource4 = singleLine2;
                    cursorBrush2 = i30 != 0 ? 1 : interactionSource3;
                    obj40 = i49;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1242950400, "CC(remember):BasicTextField.kt#9igjgp");
                    i13 = maxLines2 & 14 == 4 ? 1 : 0;
                    i34 = maxLines2 & 112 == 32 ? 1 : 0;
                    Composer composer2 = restartGroup;
                    int i93 = 0;
                    it$iv = composer2.rememberedValue();
                    int i98 = 0;
                    if (obj42 | i34 == 0) {
                        keyboardOptions3 = keyboardOptions2;
                        if (it$iv == Composer.Companion.getEmpty()) {
                            keyboardOptions2 = 0;
                            obj43 = it$iv;
                            it$iv = new BasicTextFieldKt.BasicTextField.11.1(traceInProgress2, obj8);
                            composer2.updateRememberedValue((Function1)it$iv);
                        } else {
                            obj43 = it$iv;
                        }
                    } else {
                        keyboardOptions3 = keyboardOptions2;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.10 singleLine5 = onTextLayout4;
                    i4 = obj40;
                    i19 = maxLines2;
                    VisualTransformation singleLine4 = visualTransformation2;
                    skipping = obj39;
                    Composer visualTransformation4 = restartGroup;
                    int $composer3 = i91;
                    Object obj12 = obj41;
                    CoreTextFieldKt.CoreTextField(value, (Function1)it$iv, skipping, obj12, singleLine4, singleLine5, $composer3, interactionSource4, i30 ^ 1, cursorBrush2, i25, keyboardOptions2.toImeOptions$foundation_release(i30), enabled3, keyboardOptions4, obj9, textStyle3, visualTransformation4, i63 |= i75, i37 |= i81, 0);
                    composer = visualTransformation4;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $composer2 = obj12;
                    $dirty12 = enabled3;
                    function3 = textStyle3;
                    i8 = interactionSource3;
                    i15 = i23;
                    i5 = companion;
                    textStyle2 = skipping;
                    keyboardActions2 = singleLine4;
                    decorationBox2 = interactionSource4;
                    visualTransformation3 = keyboardOptions4;
                    cursorBrush3 = keyboardOptions3;
                    enabled2 = singleLine5;
                    onTextLayout2 = obj9;
                    readOnly2 = i18;
                } else {
                    restartGroup.skipToGroupEnd();
                    i5 = singleLine;
                    i15 = minLines;
                    function3 = decorationBox;
                    composer = restartGroup;
                    i19 = $dirty;
                    i4 = $dirty1;
                    textStyle2 = obj3;
                    visualTransformation3 = z;
                    cursorBrush3 = obj10;
                    $composer2 = obj7;
                    i8 = maxLines;
                    keyboardActions2 = visualTransformation;
                    enabled2 = onTextLayout;
                    decorationBox2 = cursorBrush;
                    $dirty12 = default;
                    onTextLayout2 = obj9;
                    readOnly2 = interactionSource;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new BasicTextFieldKt.BasicTextField.12(value, onValueChange, textStyle2, visualTransformation3, onTextLayout2, $composer2, cursorBrush3, $dirty12, i5, i8, i15, keyboardActions2, enabled2, readOnly2, decorationBox2, function3, $changed, $changed1, i20);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    public static final void BasicTextField(TextFieldValue value, Function1 onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, androidx.compose.foundation.text.KeyboardOptions keyboardOptions, androidx.compose.foundation.text.KeyboardActions keyboardActions, boolean singleLine, int maxLines, VisualTransformation visualTransformation, Function1 onTextLayout, MutableInteractionSource interactionSource, Brush cursorBrush, Function3 decorationBox, Composer $composer, int $changed, int $changed1, int i19) {
        boolean z;
        int i8;
        Object obj13;
        Object obj;
        Object obj10;
        Object obj14;
        Object obj7;
        int traceInProgress2;
        Object modifier3;
        Object modifier4;
        boolean traceInProgress;
        Object endRestartGroup;
        int i18;
        boolean $i$a$CacheBasicTextFieldKt$BasicTextField$17;
        int black-0d7_KjU;
        Object iNSTANCE;
        Object obj3;
        boolean $composer2;
        int $dirty;
        boolean $dirty2;
        int $dirty1;
        Object modifier2;
        Object obj2;
        Object enabled2;
        Object obj4;
        boolean readOnly2;
        Object readOnly3;
        boolean obj5;
        Object textStyle3;
        int textStyle2;
        int i14;
        Object obj9;
        int keyboardOptions2;
        boolean default;
        Object obj6;
        VisualTransformation keyboardActions2;
        Object obj11;
        int i22;
        androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.16 singleLine2;
        int i15;
        int i6;
        Object maxLines2;
        Object obj12;
        SolidColor solidColor;
        Object obj8;
        Function3 visualTransformation2;
        int i17;
        Object i31;
        int i10;
        int i25;
        int changedInstance;
        int i4;
        int i11;
        int i12;
        int i5;
        int companion;
        Composer composer;
        int i27;
        int i23;
        int i21;
        int i28;
        int i;
        int i16;
        int changed2;
        int i26;
        int i7;
        int i32;
        int changed;
        int i9;
        int i3;
        int i24;
        int i29;
        int i20;
        int i30;
        int i13;
        int i2;
        boolean changedInstance2;
        ScopeUpdateScope scopeUpdateScope;
        Object obj37;
        int obj38;
        boolean obj50;
        int i33 = $changed;
        int i60 = $changed1;
        black-0d7_KjU = i19;
        Composer restartGroup = $composer.startRestartGroup(-560482651);
        ComposerKt.sourceInformation(restartGroup, "C(BasicTextField)P(13,9,7,2,10,12,5,4,11,6,14,8,3)843@42862L39,848@43102L579:BasicTextField.kt#423gt5");
        $dirty = $changed;
        $dirty1 = $changed1;
        if (black-0d7_KjU & 1 != 0) {
            $dirty |= 6;
            obj2 = value;
        } else {
            if (i33 & 6 == 0) {
                i14 = restartGroup.changed(value) ? 4 : 2;
                $dirty |= i14;
            } else {
                obj2 = value;
            }
        }
        if (black-0d7_KjU & 2 != 0) {
            $dirty |= 48;
            obj9 = onValueChange;
        } else {
            if (i33 & 48 == 0) {
                i15 = restartGroup.changedInstance(onValueChange) ? 32 : 16;
                $dirty |= i15;
            } else {
                obj9 = onValueChange;
            }
        }
        int i94 = black-0d7_KjU & 4;
        if (i94 != 0) {
            $dirty |= 384;
            obj4 = modifier;
        } else {
            if (i33 & 384 == 0) {
                i17 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty |= i17;
            } else {
                obj4 = modifier;
            }
        }
        i31 = black-0d7_KjU & 8;
        changedInstance = 1024;
        if (i31 != 0) {
            $dirty |= 3072;
            obj5 = enabled;
        } else {
            if (i33 & 3072 == 0) {
                i5 = restartGroup.changed(enabled) ? i10 : changedInstance;
                $dirty |= i5;
            } else {
                obj5 = enabled;
            }
        }
        companion = black-0d7_KjU & 16;
        i23 = 8192;
        if (companion != 0) {
            $dirty |= 24576;
            default = readOnly;
        } else {
            if (i33 & 24576 == 0) {
                i = restartGroup.changed(readOnly) ? i27 : i23;
                $dirty |= i;
            } else {
                default = readOnly;
            }
        }
        int i97 = black-0d7_KjU & 32;
        changed2 = 196608;
        if (i97 != 0) {
            $dirty |= changed2;
            obj11 = textStyle;
        } else {
            if (i33 & changed2 == 0) {
                i32 = restartGroup.changed(textStyle) ? 131072 : 65536;
                $dirty |= i32;
            } else {
                obj11 = textStyle;
            }
        }
        int i98 = black-0d7_KjU & 64;
        changed = 1572864;
        if (i98 != 0) {
            $dirty |= changed;
            obj12 = keyboardOptions;
        } else {
            if (i33 & changed == 0) {
                i9 = restartGroup.changed(keyboardOptions) ? 1048576 : 524288;
                $dirty |= i9;
            } else {
                obj12 = keyboardOptions;
            }
        }
        int i95 = black-0d7_KjU & 128;
        i3 = 12582912;
        if (i95 != 0) {
            $dirty |= i3;
            iNSTANCE = keyboardActions;
        } else {
            if (i33 & i3 == 0) {
                i24 = restartGroup.changed(keyboardActions) ? 8388608 : 4194304;
                $dirty |= i24;
            } else {
                iNSTANCE = keyboardActions;
            }
        }
        int i34 = black-0d7_KjU & 256;
        int i99 = 100663296;
        if (i34 != 0) {
            $dirty |= i99;
            i29 = i34;
            z = singleLine;
        } else {
            if ($changed & i99 == 0) {
                i29 = i34;
                i20 = restartGroup.changed(singleLine) ? 67108864 : 33554432;
                $dirty |= i20;
            } else {
                i29 = i34;
                z = singleLine;
            }
        }
        int i35 = black-0d7_KjU & 512;
        int i101 = 805306368;
        if (i35 != 0) {
            $dirty |= i101;
            i30 = i35;
            i8 = maxLines;
        } else {
            if ($changed & i101 == 0) {
                i30 = i35;
                i13 = restartGroup.changed(maxLines) ? 536870912 : 268435456;
                $dirty |= i13;
            } else {
                i30 = i35;
                i8 = maxLines;
            }
        }
        int i36 = black-0d7_KjU & 1024;
        if (i36 != 0) {
            $dirty1 |= 6;
            i2 = i36;
            obj13 = visualTransformation;
        } else {
            if (i60 & 6 == 0) {
                i2 = i36;
                i11 = restartGroup.changed(visualTransformation) ? 4 : 2;
                $dirty1 |= i11;
            } else {
                i2 = i36;
                obj13 = visualTransformation;
            }
        }
        int i37 = black-0d7_KjU & 2048;
        if (i37 != 0) {
            $dirty1 |= 48;
            i12 = i37;
            obj = onTextLayout;
        } else {
            if (i60 & 48 == 0) {
                i12 = i37;
                i21 = restartGroup.changedInstance(onTextLayout) ? 32 : 16;
                $dirty1 |= i21;
            } else {
                i12 = i37;
                obj = onTextLayout;
            }
        }
        int i38 = black-0d7_KjU & 4096;
        if (i38 != 0) {
            $dirty1 |= 384;
            i28 = i38;
            obj10 = interactionSource;
        } else {
            i28 = i38;
            if (i60 & 384 == 0) {
                changed = restartGroup.changed(interactionSource) ? 256 : 128;
                $dirty1 |= changed;
            } else {
                obj10 = interactionSource;
            }
        }
        int i40 = black-0d7_KjU & 8192;
        if (i40 != 0) {
            $dirty1 |= 3072;
            i26 = i40;
            obj14 = cursorBrush;
        } else {
            i26 = i40;
            if (i60 & 3072 == 0) {
                if (restartGroup.changed(cursorBrush)) {
                } else {
                    i10 = changedInstance;
                }
                $dirty1 |= i10;
            } else {
                obj14 = cursorBrush;
            }
        }
        int i41 = black-0d7_KjU & 16384;
        if (i41 != 0) {
            $dirty1 |= 24576;
            i25 = i41;
            obj7 = decorationBox;
        } else {
            i25 = i41;
            if (i60 & 24576 == 0) {
                if (restartGroup.changedInstance(decorationBox)) {
                } else {
                    i27 = i23;
                }
                $dirty1 |= i27;
            } else {
                obj7 = decorationBox;
            }
        }
        if ($dirty & i4 == 306783378 && $dirty1 & 9363 == 9362) {
            if ($dirty1 & 9363 == 9362) {
                if (!restartGroup.getSkipping()) {
                    if (i94 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = obj4;
                    }
                    $i$a$CacheBasicTextFieldKt$BasicTextField$17 = i31 != 0 ? 1 : obj5;
                    readOnly2 = companion != 0 ? 0 : default;
                    if (i97 != 0) {
                        textStyle3 = TextStyle.Companion.getDefault();
                    } else {
                        textStyle3 = obj11;
                    }
                    if (i98 != 0) {
                        obj12 = default;
                    }
                    if (i95 != 0) {
                        obj6 = iNSTANCE;
                    } else {
                        obj6 = iNSTANCE;
                    }
                    i22 = i29 != 0 ? iNSTANCE : singleLine;
                    i6 = i30 != 0 ? iNSTANCE : maxLines;
                    if (i2 != 0) {
                        obj8 = iNSTANCE;
                    } else {
                        obj8 = visualTransformation;
                    }
                    if (i12 != 0) {
                        i31 = iNSTANCE;
                    } else {
                        i31 = onTextLayout;
                    }
                    if (i28 != 0) {
                        obj37 = modifier3;
                        ComposerKt.sourceInformationMarkerStart(restartGroup, -1242857875, "CC(remember):BasicTextField.kt#9igjgp");
                        iNSTANCE = restartGroup;
                        i4 = 0;
                        obj38 = i57;
                        Object rememberedValue = iNSTANCE.rememberedValue();
                        i12 = 0;
                        obj50 = $i$a$CacheBasicTextFieldKt$BasicTextField$17;
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            int i83 = 0;
                            iNSTANCE.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                        } else {
                            $i$a$CacheBasicTextFieldKt$BasicTextField$17 = rememberedValue;
                        }
                        modifier4 = $i$a$CacheBasicTextFieldKt$BasicTextField$17;
                        ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    } else {
                        obj37 = modifier3;
                        obj50 = $i$a$CacheBasicTextFieldKt$BasicTextField$17;
                        modifier4 = interactionSource;
                    }
                    if (i26 != 0) {
                        iNSTANCE = Color.Companion;
                        obj38 = modifier4;
                        $i$a$CacheBasicTextFieldKt$BasicTextField$17 = new SolidColor(iNSTANCE.getBlack-0d7_KjU(), iNSTANCE, 0);
                        i4 = modifier4;
                    } else {
                        obj38 = modifier4;
                        i4 = cursorBrush;
                    }
                    if (i25 != 0) {
                        i12 = modifier4;
                    } else {
                        i12 = decorationBox;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-560482651, $dirty, $dirty1, "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:847)");
                    }
                    Object obj16 = obj12;
                    i25 = obj38;
                    i7 = $dirty;
                    i16 = $dirty1;
                    Object $dirty12 = obj37;
                    boolean z3 = obj50;
                    BasicTextFieldKt.BasicTextField(obj2, onValueChange, $dirty12, z3, readOnly2, textStyle3, obj16, obj6, i22, i6, 1, obj8, i31, i25, i4, i12, restartGroup, i50 | i75, i56 | i18, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj3 = $dirty12;
                    $composer2 = z3;
                    $dirty2 = readOnly2;
                    modifier2 = textStyle3;
                    enabled2 = obj16;
                    readOnly3 = obj6;
                    textStyle2 = i22;
                    keyboardOptions2 = i6;
                    keyboardActions2 = obj8;
                    singleLine2 = i31;
                    maxLines2 = i25;
                    solidColor = i4;
                    visualTransformation2 = i12;
                } else {
                    restartGroup.skipToGroupEnd();
                    readOnly3 = iNSTANCE;
                    obj3 = obj15;
                    keyboardOptions2 = maxLines;
                    maxLines2 = interactionSource;
                    visualTransformation2 = decorationBox;
                    composer = restartGroup;
                    i7 = $dirty;
                    i16 = $dirty1;
                    $composer2 = obj5;
                    $dirty2 = default;
                    modifier2 = obj11;
                    enabled2 = obj12;
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
            endRestartGroup = new BasicTextFieldKt.BasicTextField.18(value, onValueChange, obj3, $composer2, $dirty2, modifier2, enabled2, readOnly3, textStyle2, keyboardOptions2, keyboardActions2, singleLine2, maxLines2, solidColor, visualTransformation2, $changed, $changed1, i19);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    public static final void BasicTextField(String value, Function1<? super String, Unit> onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, androidx.compose.foundation.text.KeyboardOptions keyboardOptions, androidx.compose.foundation.text.KeyboardActions keyboardActions, boolean singleLine, int maxLines, int minLines, VisualTransformation visualTransformation, Function1<? super TextLayoutResult, Unit> onTextLayout, MutableInteractionSource interactionSource, Brush cursorBrush, Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> decorationBox, Composer $composer, int $changed, int $changed1, int i20) {
        boolean z4;
        int i19;
        int i10;
        Object i14;
        Object obj4;
        Object obj7;
        Object obj8;
        Object obj6;
        int skipping;
        int defaultsInvalid;
        boolean enabled2;
        Object enabled3;
        int i24;
        Object cursorBrush3;
        int i3;
        Object it$iv;
        Object endRestartGroup;
        int traceInProgress;
        int singleLine4;
        int black-0d7_KjU;
        int i;
        Object mutableStateOf$default2;
        Object textFieldValueState$delegate;
        int i32;
        Composer $this$cache$iv;
        Object mutableStateOf$default;
        Object copy-3r_uNRQ$default;
        boolean z;
        boolean $composer2;
        int $dirty;
        Object $dirty2;
        int $dirty12;
        Object $dirty13;
        int i6;
        int i16;
        int default;
        Object keyboardActions2;
        Object keyboardActions3;
        Object it$iv2;
        int invalid$iv;
        int i17;
        Object modifier2;
        int singleLine2;
        Object singleLine3;
        Composer composer;
        int textStyle2;
        Object obj2;
        int maxLines2;
        VisualTransformation maxLines3;
        int visualTransformation2;
        boolean z2;
        int minLines3;
        androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.6 minLines2;
        int onTextLayout3;
        Object obj5;
        int keyboardOptions2;
        VisualTransformation interactionSource4;
        boolean obj3;
        SolidColor readOnly2;
        androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.6 cursorBrush2;
        Object obj9;
        int textStyle3;
        int i4;
        Object obj;
        boolean traceInProgress2;
        SolidColor solidColor;
        int i18;
        VisualTransformation visualTransformation3;
        int i15;
        Function3 function3;
        int i7;
        int imeOptions$foundation_release;
        boolean changed;
        Object i2;
        int i5;
        androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.6 onTextLayout4;
        boolean onTextLayout2;
        int i35;
        boolean z3;
        int readOnly3;
        int interactionSource3;
        Function3 interactionSource2;
        int i8;
        int i30;
        int i25;
        Composer $dirty1;
        int i21;
        int i22;
        int companion;
        int companion2;
        int changed3;
        int i23;
        Object i33;
        int singleLine5;
        int i28;
        int i29;
        int i31;
        int i34;
        int i26;
        int i9;
        int changed2;
        int i11;
        int i36;
        int i12;
        int i13;
        int i27;
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
        $dirty12 = $changed1;
        if (i59 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (i37 & 6 == 0) {
                i6 = restartGroup.changed(value) ? 4 : 2;
                $dirty |= i6;
            }
        }
        if (i59 & 2 != 0) {
            $dirty |= 48;
        } else {
            if (i37 & 48 == 0) {
                i16 = restartGroup.changedInstance(obj11) ? 32 : 16;
                $dirty |= i16;
            }
        }
        default = i59 & 4;
        if (default != 0) {
            $dirty |= 384;
            obj = modifier;
        } else {
            if (i37 & 384 == 0) {
                i18 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty |= i18;
            } else {
                obj = modifier;
            }
        }
        visualTransformation3 = i59 & 8;
        changed = 1024;
        if (visualTransformation3 != 0) {
            $dirty |= 3072;
            z2 = enabled;
        } else {
            if (i37 & 3072 == 0) {
                i5 = restartGroup.changed(enabled) ? i7 : changed;
                $dirty |= i5;
            } else {
                z2 = enabled;
            }
        }
        onTextLayout2 = i59 & 16;
        interactionSource2 = 8192;
        if (onTextLayout2 != 0) {
            $dirty |= 24576;
            obj3 = readOnly;
        } else {
            if (i37 & 24576 == 0) {
                i21 = restartGroup.changed(readOnly) ? i35 : interactionSource2;
                $dirty |= i21;
            } else {
                obj3 = readOnly;
            }
        }
        i22 = i59 & 32;
        companion2 = 196608;
        if (i22 != 0) {
            $dirty |= companion2;
            obj9 = textStyle;
        } else {
            if (i37 & companion2 == 0) {
                i23 = restartGroup.changed(textStyle) ? 131072 : 65536;
                $dirty |= i23;
            } else {
                obj9 = textStyle;
            }
        }
        i33 = i59 & 64;
        singleLine5 = 1572864;
        if (i33 != 0) {
            $dirty |= singleLine5;
            obj5 = keyboardOptions;
        } else {
            if (i37 & singleLine5 == 0) {
                i28 = restartGroup.changed(keyboardOptions) ? 1048576 : 524288;
                $dirty |= i28;
            } else {
                obj5 = keyboardOptions;
            }
        }
        int i65 = i59 & 128;
        i31 = 12582912;
        if (i65 != 0) {
            $dirty |= i31;
            obj2 = keyboardActions;
        } else {
            if (i37 & i31 == 0) {
                i34 = restartGroup.changed(keyboardActions) ? 8388608 : 4194304;
                $dirty |= i34;
            } else {
                obj2 = keyboardActions;
            }
        }
        int i38 = i59 & 256;
        int i111 = 100663296;
        if (i38 != 0) {
            $dirty |= i111;
            i26 = i38;
            z4 = singleLine;
        } else {
            if ($changed & i111 == 0) {
                i26 = i38;
                i9 = restartGroup.changed(singleLine) ? 67108864 : 33554432;
                $dirty |= i9;
            } else {
                i26 = i38;
                z4 = singleLine;
            }
        }
        if ($changed & i113 == 0) {
            if (i59 & 512 == 0) {
                changed2 = restartGroup.changed(maxLines) ? 536870912 : 268435456;
            } else {
                i19 = maxLines;
            }
            $dirty |= changed2;
        } else {
            i19 = maxLines;
        }
        int i40 = i59 & 1024;
        if (i40 != 0) {
            $dirty12 |= 6;
            i11 = i40;
            i10 = minLines;
        } else {
            if (black-0d7_KjU & 6 == 0) {
                i11 = i40;
                i36 = restartGroup.changed(minLines) ? 4 : 2;
                $dirty12 |= i36;
            } else {
                i11 = i40;
                i10 = minLines;
            }
        }
        int i41 = i59 & 2048;
        if (i41 != 0) {
            $dirty12 |= 48;
            i12 = i41;
            i14 = visualTransformation;
        } else {
            if (black-0d7_KjU & 48 == 0) {
                i12 = i41;
                i13 = restartGroup.changed(visualTransformation) ? 32 : 16;
                $dirty12 |= i13;
            } else {
                i12 = i41;
                i14 = visualTransformation;
            }
        }
        int i42 = i59 & 4096;
        if (i42 != 0) {
            $dirty12 |= 384;
            i27 = i42;
            obj4 = onTextLayout;
        } else {
            i27 = i42;
            if (black-0d7_KjU & 384 == 0) {
                i8 = restartGroup.changedInstance(onTextLayout) ? 256 : 128;
                $dirty12 |= i8;
            } else {
                obj4 = onTextLayout;
            }
        }
        int i44 = i59 & 8192;
        if (i44 != 0) {
            $dirty12 |= 3072;
            i30 = i44;
            obj7 = interactionSource;
        } else {
            i30 = i44;
            if (black-0d7_KjU & 3072 == 0) {
                if (restartGroup.changed(interactionSource)) {
                } else {
                    i7 = changed;
                }
                $dirty12 |= i7;
            } else {
                obj7 = interactionSource;
            }
        }
        int i45 = i59 & 16384;
        if (i45 != 0) {
            $dirty12 |= 24576;
            imeOptions$foundation_release = i45;
            obj8 = cursorBrush;
        } else {
            imeOptions$foundation_release = i45;
            if (black-0d7_KjU & 24576 == 0) {
                if (restartGroup.changed(cursorBrush)) {
                } else {
                    i35 = interactionSource2;
                }
                $dirty12 |= i35;
            } else {
                obj8 = cursorBrush;
            }
        }
        i2 = i59 & i107;
        if (i2 != 0) {
            $dirty12 |= companion2;
            obj6 = decorationBox;
        } else {
            if (black-0d7_KjU & companion2 == 0) {
                i35 = restartGroup.changedInstance(decorationBox) ? 131072 : 65536;
                $dirty12 |= i35;
            } else {
                obj6 = decorationBox;
            }
        }
        if ($dirty & i108 == 306783378 && i48 &= $dirty12 == 74898) {
            if (i48 &= $dirty12 == 74898) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    int i109 = 1;
                    if ($changed & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if (default != 0) {
                                obj = defaultsInvalid;
                            }
                            enabled2 = visualTransformation3 != 0 ? 1 : z2;
                            if (onTextLayout2 != 0) {
                                obj3 = default;
                            }
                            if (i22 != 0) {
                                obj9 = default;
                            }
                            if (i33 != 0) {
                                obj5 = default;
                            }
                            if (i65 != 0) {
                                keyboardActions2 = KeyboardActions.Companion.getDefault();
                            } else {
                                keyboardActions2 = obj2;
                            }
                            singleLine2 = i26 != 0 ? 0 : singleLine;
                            if (i59 & 512 != 0) {
                                maxLines2 = singleLine2 != 0 ? i109 : 0x7fffffff /* Unknown resource */;
                                $dirty &= z2;
                            } else {
                                maxLines2 = maxLines;
                            }
                            minLines3 = i11 != 0 ? 1 : minLines;
                            if (i12 != 0) {
                                visualTransformation3 = VisualTransformation.Companion.getNone();
                            } else {
                                visualTransformation3 = visualTransformation;
                            }
                            if (i27 != 0) {
                                onTextLayout4 = BasicTextFieldKt.BasicTextField.6.INSTANCE;
                            } else {
                                onTextLayout4 = onTextLayout;
                            }
                            interactionSource3 = i30 != 0 ? 0 : interactionSource;
                            if (imeOptions$foundation_release != 0) {
                                obj38 = enabled2;
                                traceInProgress = new SolidColor(Color.Companion.getBlack-0d7_KjU(), i59, 0);
                                enabled3 = traceInProgress;
                            } else {
                                obj38 = enabled2;
                                enabled3 = cursorBrush;
                            }
                            if (i2 != 0) {
                                readOnly2 = enabled3;
                                cursorBrush3 = obj5;
                                keyboardOptions2 = interactionSource3;
                                interactionSource2 = lambda-1$foundation_release;
                                singleLine4 = singleLine2;
                                singleLine3 = obj9;
                                textStyle3 = i109;
                                z3 = z5;
                                i2 = keyboardActions2;
                                i = maxLines2;
                                i32 = minLines3;
                                keyboardActions3 = obj;
                                maxLines3 = visualTransformation3;
                                minLines2 = onTextLayout4;
                                onTextLayout2 = obj38;
                            } else {
                                i2 = keyboardActions2;
                                singleLine4 = singleLine2;
                                i = maxLines2;
                                i32 = minLines3;
                                singleLine3 = obj9;
                                keyboardActions3 = obj;
                                maxLines3 = visualTransformation3;
                                minLines2 = onTextLayout4;
                                textStyle3 = i109;
                                onTextLayout2 = obj38;
                                z3 = obj3;
                                readOnly2 = enabled3;
                                cursorBrush3 = obj5;
                                keyboardOptions2 = interactionSource3;
                                interactionSource2 = decorationBox;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            if (i59 & 512 != 0) {
                                $dirty &= i24;
                            }
                            singleLine4 = singleLine;
                            i = maxLines;
                            i32 = minLines;
                            interactionSource2 = decorationBox;
                            i2 = obj2;
                            onTextLayout2 = z2;
                            cursorBrush3 = obj5;
                            singleLine3 = obj9;
                            keyboardActions3 = obj;
                            textStyle3 = i109;
                            maxLines3 = visualTransformation;
                            minLines2 = onTextLayout;
                            keyboardOptions2 = interactionSource;
                            z3 = obj3;
                            readOnly2 = cursorBrush;
                        }
                    } else {
                    }
                    restartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(945255183, $dirty, $dirty12, "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:611)");
                    }
                    String str3 = "CC(remember):BasicTextField.kt#9igjgp";
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1243232097, str3);
                    int i87 = 0;
                    obj46 = restartGroup;
                    int i100 = 0;
                    obj47 = i;
                    mutableStateOf$default2 = obj46.rememberedValue();
                    int i104 = 0;
                    obj48 = i32;
                    if (mutableStateOf$default2 == Composer.Companion.getEmpty()) {
                        obj38 = textFieldValue2;
                        super(value, 0, textStyle, 0, 6, 0);
                        obj38 = obj39;
                        obj39 = i60;
                        i25 = $dirty12;
                        int $i$a$CacheBasicTextFieldKt$BasicTextField$textFieldValueState$2 = 0;
                        obj46.updateRememberedValue(SnapshotStateKt.mutableStateOf$default(obj38, $i$a$CacheBasicTextFieldKt$BasicTextField$textFieldValueState$2, 2, $i$a$CacheBasicTextFieldKt$BasicTextField$textFieldValueState$2));
                    } else {
                        $this$cache$iv = obj46;
                        obj38 = mutableStateOf$default2;
                        i25 = $dirty12;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    obj39 = value;
                    copy-3r_uNRQ$default = TextFieldValue.copy-3r_uNRQ$default(BasicTextFieldKt.BasicTextField$lambda$21((MutableState)mutableStateOf$default2), obj39, 0, textStyle, 0, 6);
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
                            it$iv2 = new BasicTextFieldKt.BasicTextField.7.1(copy-3r_uNRQ$default, mutableStateOf$default2);
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
                    invalid$iv = $dirty & 14 == 4 ? 1 : i66;
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
                            mutableStateOf$default = rememberedValue;
                        }
                    } else {
                        obj41 = copy-3r_uNRQ$default;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    i15 = singleLine4 != 0 ? 1 : obj48;
                    i17 = singleLine4 != 0 ? 1 : obj47;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1243199525, str3);
                    i3 = $dirty & 112 == 32 ? 1 : 0;
                    Composer composer2 = restartGroup;
                    int i93 = 0;
                    it$iv = composer2.rememberedValue();
                    int i110 = 0;
                    if (i3 |= changed5 == 0) {
                        singleLine5 = singleLine4;
                        if (it$iv == Composer.Companion.getEmpty()) {
                            singleLine4 = 0;
                            obj42 = it$iv;
                            it$iv = new BasicTextFieldKt.BasicTextField.8.1(obj11, mutableStateOf$default2, mutableStateOf$default);
                            composer2.updateRememberedValue((Function1)it$iv);
                        } else {
                            obj42 = it$iv;
                        }
                    } else {
                        singleLine5 = singleLine4;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    Object obj14 = obj40;
                    i29 = i25;
                    Object obj13 = obj39;
                    CoreTextFieldKt.CoreTextField(obj41, (Function1)it$iv, obj13, obj14, maxLines3, minLines2, keyboardOptions2, readOnly2, singleLine4 ^ 1, i17, i15, cursorBrush3.toImeOptions$foundation_release(singleLine4), i2, onTextLayout2, z3, interactionSource2, restartGroup, i54 | i77, i58 | i82, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    textFieldValueState$delegate = obj13;
                    $dirty2 = obj14;
                    i4 = keyboardOptions2;
                    solidColor = readOnly2;
                    modifier2 = i2;
                    z = onTextLayout2;
                    $composer2 = z3;
                    function3 = interactionSource2;
                    $dirty13 = i33;
                    textStyle2 = singleLine5;
                    readOnly3 = skipping;
                    interactionSource4 = maxLines3;
                    cursorBrush2 = minLines2;
                    visualTransformation2 = obj47;
                    onTextLayout3 = obj48;
                } else {
                    restartGroup.skipToGroupEnd();
                    textStyle2 = singleLine;
                    function3 = decorationBox;
                    $dirty1 = restartGroup;
                    readOnly3 = $dirty;
                    i29 = $dirty12;
                    modifier2 = obj2;
                    z = z2;
                    $dirty13 = obj5;
                    $composer2 = obj3;
                    $dirty2 = obj9;
                    textFieldValueState$delegate = obj;
                    visualTransformation2 = maxLines;
                    onTextLayout3 = minLines;
                    interactionSource4 = visualTransformation;
                    cursorBrush2 = onTextLayout;
                    i4 = interactionSource;
                    solidColor = cursorBrush;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = $dirty1.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new BasicTextFieldKt.BasicTextField.9(value, obj11, textFieldValueState$delegate, z, $composer2, $dirty2, $dirty13, modifier2, textStyle2, visualTransformation2, onTextLayout3, interactionSource4, cursorBrush2, i4, solidColor, function3, $changed, $changed1, i20);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    public static final void BasicTextField(String value, Function1 onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, androidx.compose.foundation.text.KeyboardOptions keyboardOptions, androidx.compose.foundation.text.KeyboardActions keyboardActions, boolean singleLine, int maxLines, VisualTransformation visualTransformation, Function1 onTextLayout, MutableInteractionSource interactionSource, Brush cursorBrush, Function3 decorationBox, Composer $composer, int $changed, int $changed1, int i19) {
        boolean z;
        int i13;
        Object obj9;
        Object obj8;
        Object obj;
        Object obj2;
        Object obj3;
        int traceInProgress2;
        Object modifier2;
        Object modifier4;
        boolean traceInProgress;
        Object endRestartGroup;
        int i30;
        boolean $i$a$CacheBasicTextFieldKt$BasicTextField$14;
        int black-0d7_KjU;
        Object iNSTANCE;
        Object obj7;
        boolean $composer2;
        int $dirty;
        boolean $dirty2;
        int $dirty1;
        Object modifier3;
        Object obj6;
        Object enabled2;
        Object obj12;
        boolean readOnly2;
        Object readOnly3;
        boolean obj10;
        Object textStyle3;
        int textStyle2;
        int i28;
        Object obj13;
        int keyboardOptions2;
        boolean default;
        Object obj14;
        VisualTransformation keyboardActions2;
        Object obj5;
        int i;
        androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.13 singleLine2;
        int i20;
        int i23;
        Object maxLines2;
        Object obj11;
        SolidColor solidColor;
        Object obj4;
        Function3 visualTransformation2;
        int i32;
        Object i6;
        int i5;
        int i24;
        int changedInstance2;
        int i17;
        int i21;
        int i11;
        int i2;
        int companion;
        Composer composer;
        int i3;
        int i31;
        int i26;
        int i12;
        int i7;
        int i10;
        int changed2;
        int i22;
        int i18;
        int i14;
        int changed;
        int i8;
        int i4;
        int i16;
        int i15;
        int i25;
        int i9;
        int i29;
        int i27;
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
        $dirty = $changed;
        $dirty1 = $changed1;
        if (black-0d7_KjU & 1 != 0) {
            $dirty |= 6;
            obj6 = value;
        } else {
            if (i33 & 6 == 0) {
                i28 = restartGroup.changed(value) ? 4 : 2;
                $dirty |= i28;
            } else {
                obj6 = value;
            }
        }
        if (black-0d7_KjU & 2 != 0) {
            $dirty |= 48;
            obj13 = onValueChange;
        } else {
            if (i33 & 48 == 0) {
                i20 = restartGroup.changedInstance(onValueChange) ? 32 : 16;
                $dirty |= i20;
            } else {
                obj13 = onValueChange;
            }
        }
        int i94 = black-0d7_KjU & 4;
        if (i94 != 0) {
            $dirty |= 384;
            obj12 = modifier;
        } else {
            if (i33 & 384 == 0) {
                i32 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty |= i32;
            } else {
                obj12 = modifier;
            }
        }
        i6 = black-0d7_KjU & 8;
        changedInstance2 = 1024;
        if (i6 != 0) {
            $dirty |= 3072;
            obj10 = enabled;
        } else {
            if (i33 & 3072 == 0) {
                i2 = restartGroup.changed(enabled) ? i5 : changedInstance2;
                $dirty |= i2;
            } else {
                obj10 = enabled;
            }
        }
        companion = black-0d7_KjU & 16;
        i31 = 8192;
        if (companion != 0) {
            $dirty |= 24576;
            default = readOnly;
        } else {
            if (i33 & 24576 == 0) {
                i7 = restartGroup.changed(readOnly) ? i3 : i31;
                $dirty |= i7;
            } else {
                default = readOnly;
            }
        }
        int i97 = black-0d7_KjU & 32;
        changed2 = 196608;
        if (i97 != 0) {
            $dirty |= changed2;
            obj5 = textStyle;
        } else {
            if (i33 & changed2 == 0) {
                i14 = restartGroup.changed(textStyle) ? 131072 : 65536;
                $dirty |= i14;
            } else {
                obj5 = textStyle;
            }
        }
        int i98 = black-0d7_KjU & 64;
        changed = 1572864;
        if (i98 != 0) {
            $dirty |= changed;
            obj11 = keyboardOptions;
        } else {
            if (i33 & changed == 0) {
                i8 = restartGroup.changed(keyboardOptions) ? 1048576 : 524288;
                $dirty |= i8;
            } else {
                obj11 = keyboardOptions;
            }
        }
        int i95 = black-0d7_KjU & 128;
        i4 = 12582912;
        if (i95 != 0) {
            $dirty |= i4;
            iNSTANCE = keyboardActions;
        } else {
            if (i33 & i4 == 0) {
                i16 = restartGroup.changed(keyboardActions) ? 8388608 : 4194304;
                $dirty |= i16;
            } else {
                iNSTANCE = keyboardActions;
            }
        }
        int i34 = black-0d7_KjU & 256;
        int i99 = 100663296;
        if (i34 != 0) {
            $dirty |= i99;
            i15 = i34;
            z = singleLine;
        } else {
            if ($changed & i99 == 0) {
                i15 = i34;
                i25 = restartGroup.changed(singleLine) ? 67108864 : 33554432;
                $dirty |= i25;
            } else {
                i15 = i34;
                z = singleLine;
            }
        }
        int i35 = black-0d7_KjU & 512;
        int i101 = 805306368;
        if (i35 != 0) {
            $dirty |= i101;
            i9 = i35;
            i13 = maxLines;
        } else {
            if ($changed & i101 == 0) {
                i9 = i35;
                i29 = restartGroup.changed(maxLines) ? 536870912 : 268435456;
                $dirty |= i29;
            } else {
                i9 = i35;
                i13 = maxLines;
            }
        }
        int i36 = black-0d7_KjU & 1024;
        if (i36 != 0) {
            $dirty1 |= 6;
            i27 = i36;
            obj9 = visualTransformation;
        } else {
            if (i60 & 6 == 0) {
                i27 = i36;
                i21 = restartGroup.changed(visualTransformation) ? 4 : 2;
                $dirty1 |= i21;
            } else {
                i27 = i36;
                obj9 = visualTransformation;
            }
        }
        int i37 = black-0d7_KjU & 2048;
        if (i37 != 0) {
            $dirty1 |= 48;
            i11 = i37;
            obj8 = onTextLayout;
        } else {
            if (i60 & 48 == 0) {
                i11 = i37;
                i26 = restartGroup.changedInstance(onTextLayout) ? 32 : 16;
                $dirty1 |= i26;
            } else {
                i11 = i37;
                obj8 = onTextLayout;
            }
        }
        int i38 = black-0d7_KjU & 4096;
        if (i38 != 0) {
            $dirty1 |= 384;
            i12 = i38;
            obj = interactionSource;
        } else {
            i12 = i38;
            if (i60 & 384 == 0) {
                changed = restartGroup.changed(interactionSource) ? 256 : 128;
                $dirty1 |= changed;
            } else {
                obj = interactionSource;
            }
        }
        int i40 = black-0d7_KjU & 8192;
        if (i40 != 0) {
            $dirty1 |= 3072;
            i22 = i40;
            obj2 = cursorBrush;
        } else {
            i22 = i40;
            if (i60 & 3072 == 0) {
                if (restartGroup.changed(cursorBrush)) {
                } else {
                    i5 = changedInstance2;
                }
                $dirty1 |= i5;
            } else {
                obj2 = cursorBrush;
            }
        }
        int i41 = black-0d7_KjU & 16384;
        if (i41 != 0) {
            $dirty1 |= 24576;
            i24 = i41;
            obj3 = decorationBox;
        } else {
            i24 = i41;
            if (i60 & 24576 == 0) {
                if (restartGroup.changedInstance(decorationBox)) {
                } else {
                    i3 = i31;
                }
                $dirty1 |= i3;
            } else {
                obj3 = decorationBox;
            }
        }
        if ($dirty & i17 == 306783378 && $dirty1 & 9363 == 9362) {
            if ($dirty1 & 9363 == 9362) {
                if (!restartGroup.getSkipping()) {
                    if (i94 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = obj12;
                    }
                    $i$a$CacheBasicTextFieldKt$BasicTextField$14 = i6 != 0 ? 1 : obj10;
                    readOnly2 = companion != 0 ? 0 : default;
                    if (i97 != 0) {
                        textStyle3 = TextStyle.Companion.getDefault();
                    } else {
                        textStyle3 = obj5;
                    }
                    if (i98 != 0) {
                        obj11 = default;
                    }
                    if (i95 != 0) {
                        obj14 = iNSTANCE;
                    } else {
                        obj14 = iNSTANCE;
                    }
                    i = i15 != 0 ? iNSTANCE : singleLine;
                    i23 = i9 != 0 ? iNSTANCE : maxLines;
                    if (i27 != 0) {
                        obj4 = iNSTANCE;
                    } else {
                        obj4 = visualTransformation;
                    }
                    if (i11 != 0) {
                        i6 = iNSTANCE;
                    } else {
                        i6 = onTextLayout;
                    }
                    if (i12 != 0) {
                        obj37 = modifier2;
                        ComposerKt.sourceInformationMarkerStart(restartGroup, -1242906675, "CC(remember):BasicTextField.kt#9igjgp");
                        iNSTANCE = restartGroup;
                        i17 = 0;
                        obj38 = i57;
                        Object rememberedValue = iNSTANCE.rememberedValue();
                        i11 = 0;
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
                        obj37 = modifier2;
                        obj50 = $i$a$CacheBasicTextFieldKt$BasicTextField$14;
                        modifier4 = interactionSource;
                    }
                    if (i22 != 0) {
                        iNSTANCE = Color.Companion;
                        obj38 = modifier4;
                        $i$a$CacheBasicTextFieldKt$BasicTextField$14 = new SolidColor(iNSTANCE.getBlack-0d7_KjU(), iNSTANCE, 0);
                        i17 = modifier4;
                    } else {
                        obj38 = modifier4;
                        i17 = cursorBrush;
                    }
                    if (i24 != 0) {
                        i11 = modifier4;
                    } else {
                        i11 = decorationBox;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-454732590, $dirty, $dirty1, "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:807)");
                    }
                    Object obj16 = obj11;
                    i24 = obj38;
                    i18 = $dirty;
                    i10 = $dirty1;
                    Object $dirty12 = obj37;
                    boolean z3 = obj50;
                    BasicTextFieldKt.BasicTextField(obj6, onValueChange, $dirty12, z3, readOnly2, textStyle3, obj16, obj14, i, i23, 1, obj4, i6, i24, i17, i11, restartGroup, i50 | i75, i56 | i30, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj7 = $dirty12;
                    $composer2 = z3;
                    $dirty2 = readOnly2;
                    modifier3 = textStyle3;
                    enabled2 = obj16;
                    readOnly3 = obj14;
                    textStyle2 = i;
                    keyboardOptions2 = i23;
                    keyboardActions2 = obj4;
                    singleLine2 = i6;
                    maxLines2 = i24;
                    solidColor = i17;
                    visualTransformation2 = i11;
                } else {
                    restartGroup.skipToGroupEnd();
                    readOnly3 = iNSTANCE;
                    obj7 = obj15;
                    keyboardOptions2 = maxLines;
                    maxLines2 = interactionSource;
                    visualTransformation2 = decorationBox;
                    composer = restartGroup;
                    i18 = $dirty;
                    i10 = $dirty1;
                    $composer2 = obj10;
                    $dirty2 = default;
                    modifier3 = obj5;
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
            endRestartGroup = new BasicTextFieldKt.BasicTextField.15(value, onValueChange, obj7, $composer2, $dirty2, modifier3, enabled2, readOnly3, textStyle2, keyboardOptions2, keyboardActions2, singleLine2, maxLines2, solidColor, visualTransformation2, $changed, $changed1, i19);
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
        int i;
        int traceInProgress2;
        boolean traceInProgress;
        Object obj;
        int pointerInput;
        long minTouchTargetSizeForHandles;
        int rememberedValue;
        int i2;
        Object $i$a$CacheBasicTextFieldKt$TextFieldCursorHandle$cursorHandleState$2;
        androidx.compose.foundation.text.BasicTextFieldKt.TextFieldCursorHandle.cursorHandleState.2.1 empty;
        Object anon;
        Object anon2;
        int i3;
        int obj13;
        invalid$iv = 1991581797;
        final Composer restartGroup = $composer.startRestartGroup(invalid$iv);
        ComposerKt.sourceInformation(restartGroup, "C(TextFieldCursorHandle)416@20789L124:BasicTextField.kt#423gt5");
        pointerInput = 2;
        if ($changed & 6 == 0) {
            i = restartGroup.changedInstance(selectionState) ? 4 : pointerInput;
            obj13 |= i;
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
        State invalid$iv;
        int traceInProgress;
        int $dirty2;
        int $dirty;
        boolean traceInProgress2;
        Object invalid$iv2;
        Object visible;
        int str;
        int i2;
        Object rememberedValue2;
        Object rememberedValue;
        boolean handlesCrossed2;
        boolean handlesCrossed;
        Object $i$a$CacheBasicTextFieldKt$TextFieldSelectionHandles$startHandleState$2;
        Object $i$a$CacheBasicTextFieldKt$TextFieldSelectionHandles$endHandleState$2;
        androidx.compose.foundation.text.BasicTextFieldKt.TextFieldSelectionHandles.startHandleState.2.1 empty3;
        Object anon2;
        Modifier pointerInput;
        Object anon;
        int i3;
        int i;
        Object empty;
        Object empty2;
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
            $dirty2 |= str;
        }
        final int i25 = $dirty2;
        if (i25 & 3 == rememberedValue) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, i25, -1, "androidx.compose.foundation.text.TextFieldSelectionHandles (BasicTextField.kt:440)");
                }
                empty = "CC(remember):BasicTextField.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1983345958, empty);
                int i6 = 0;
                Composer composer = restartGroup;
                i2 = 0;
                rememberedValue2 = composer.rememberedValue();
                handlesCrossed2 = 0;
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
                    invalid$iv2 = anon2;
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
                            endHandleState$delegate = invalid$iv2;
                            startHandleState$delegate2 = new BasicTextFieldKt.TextFieldSelectionHandles.2.1(obj, 0);
                            empty3.updateRememberedValue((Function2)startHandleState$delegate2);
                        } else {
                            startHandleState$delegate = invalid$iv3;
                            endHandleState$delegate = invalid$iv2;
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
                rememberedValue = composer2.rememberedValue();
                handlesCrossed = 0;
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    int i18 = 0;
                    empty3 = new BasicTextFieldKt.TextFieldSelectionHandles.endHandleState.2.1(obj);
                    composer2.updateRememberedValue(SnapshotStateKt.derivedStateOf((Function0)empty3));
                } else {
                    $i$a$CacheBasicTextFieldKt$TextFieldSelectionHandles$endHandleState$2 = rememberedValue;
                }
                invalid$iv = $i$a$CacheBasicTextFieldKt$TextFieldSelectionHandles$endHandleState$2;
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (BasicTextFieldKt.TextFieldSelectionHandles$lambda$17((State)invalid$iv).getVisible()) {
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
                            endHandleState$delegate = invalid$iv;
                            empty2 = new BasicTextFieldKt.TextFieldSelectionHandles.4.1(obj, 0);
                            empty3.updateRememberedValue((Function2)empty2);
                        } else {
                            endHandleState$delegate = invalid$iv;
                            empty2 = rememberedValue6;
                        }
                    } else {
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    AndroidSelectionHandles_androidKt.SelectionHandle-pzduO1o((OffsetProvider)anon, false, BasicTextFieldKt.TextFieldSelectionHandles$lambda$17(invalid$iv).getDirection(), BasicTextFieldKt.TextFieldSelectionHandles$lambda$17(invalid$iv).getHandlesCrossed(), BasicTextFieldKt.MinTouchTargetSizeForHandles, empty3, SuspendingPointerInputFilterKt.pointerInput((Modifier)Modifier.Companion, obj, (Function2)empty2), restartGroup, 24624);
                    restartGroup.endReplaceGroup();
                } else {
                    endHandleState$delegate = invalid$iv;
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
