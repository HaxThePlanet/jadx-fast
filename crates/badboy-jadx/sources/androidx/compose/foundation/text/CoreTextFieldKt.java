package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.relocation.BringIntoViewRequester;
import androidx.compose.foundation.relocation.BringIntoViewRequesterKt;
import androidx.compose.foundation.text.handwriting.StylusHandwritingKt;
import androidx.compose.foundation.text.input.internal.LegacyAdaptingPlatformTextInputModifierNodeKt;
import androidx.compose.foundation.text.input.internal.LegacyPlatformTextInputServiceAdapter_androidKt;
import androidx.compose.foundation.text.selection.SelectionGesturesKt;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.foundation.text.selection.TextFieldSelectionManagerKt;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.Snapshot.Companion;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Alignment.Companion;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.pointer.PointerIconKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode.Companion;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.platform.WindowInfo;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyle.Companion;
import androidx.compose.ui.text.input.EditProcessor;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.ImeOptions.Companion;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.input.VisualTransformation.Companion;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u009a\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u001aî\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0014\u0008\u0002\u0010\u000c\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u00052\n\u0008\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00152\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u00152\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u00182\u0008\u0008\u0002\u0010\u0019\u001a\u00020\u001a2\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u001323\u0008\u0002\u0010\u001d\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\u0008\u001f¢\u0006\u000c\u0008 \u0012\u0008\u0008!\u0012\u0004\u0008\u0008(\"\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\u0008\u001fH\u0001¢\u0006\u0002\u0010#\u001a0\u0010$\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010%\u001a\u00020&2\u0011\u0010'\u001a\r\u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\u0008\u001fH\u0003¢\u0006\u0002\u0010(\u001a\u001d\u0010)\u001a\u00020\u00012\u0006\u0010%\u001a\u00020&2\u0006\u0010*\u001a\u00020\u0013H\u0003¢\u0006\u0002\u0010+\u001a\u0015\u0010,\u001a\u00020\u00012\u0006\u0010%\u001a\u00020&H\u0001¢\u0006\u0002\u0010-\u001a\u0010\u0010.\u001a\u00020\u00012\u0006\u0010/\u001a\u000200H\u0002\u001a \u00101\u001a\u00020\u00012\u0006\u0010/\u001a\u0002002\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00102\u001a\u000203H\u0002\u001a0\u00104\u001a\u00020\u00012\u0006\u00105\u001a\u0002062\u0006\u0010/\u001a\u0002002\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u00102\u001a\u000203H\u0002\u001a \u00107\u001a\u00020\u00012\u0006\u0010/\u001a\u0002002\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u0013H\u0002\u001a2\u0010;\u001a\u00020\u0001*\u00020<2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\r2\u0006\u00102\u001a\u000203H\u0080@¢\u0006\u0002\u0010@\u001a\u001c\u0010A\u001a\u00020\u0007*\u00020\u00072\u0006\u0010/\u001a\u0002002\u0006\u0010%\u001a\u00020&H\u0002¨\u0006B²\u0006\n\u0010C\u001a\u00020\u0013X\u008a\u0084\u0002", d2 = {"CoreTextField", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "onTextLayout", "Landroidx/compose/ui/text/TextLayoutResult;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "softWrap", "", "maxLines", "", "minLines", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "enabled", "readOnly", "decorationBox", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ParameterName;", "name", "innerTextField", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;ZIILandroidx/compose/ui/text/input/ImeOptions;Landroidx/compose/foundation/text/KeyboardActions;ZZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "CoreTextFieldRootBox", "manager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "content", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "SelectionToolbarAndHandles", "show", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;ZLandroidx/compose/runtime/Composer;I)V", "TextFieldCursorHandle", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Landroidx/compose/runtime/Composer;I)V", "endInputSession", "state", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "notifyFocusedRect", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "startInputSession", "textInputService", "Landroidx/compose/ui/text/input/TextInputService;", "tapToFocus", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "allowKeyboard", "bringSelectionEndIntoView", "Landroidx/compose/foundation/relocation/BringIntoViewRequester;", "textDelegate", "Landroidx/compose/foundation/text/TextDelegate;", "textLayoutResult", "(Landroidx/compose/foundation/relocation/BringIntoViewRequester;Landroidx/compose/ui/text/input/TextFieldValue;Landroidx/compose/foundation/text/TextDelegate;Landroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/text/input/OffsetMapping;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "previewKeyEventToDeselectOnBack", "foundation_release", "writeable"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CoreTextFieldKt {
    public static final void CoreTextField(TextFieldValue value, Function1<? super TextFieldValue, Unit> onValueChange, Modifier modifier, TextStyle textStyle, VisualTransformation visualTransformation, Function1<? super TextLayoutResult, Unit> onTextLayout, MutableInteractionSource interactionSource, Brush cursorBrush, boolean softWrap, int maxLines, int minLines, ImeOptions imeOptions, androidx.compose.foundation.text.KeyboardActions keyboardActions, boolean enabled, boolean readOnly, Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> decorationBox, Composer $composer, int $changed, int $changed1, int i20) {
        Object obj14;
        boolean z2;
        int i33;
        int i35;
        Object obj3;
        Object obj17;
        boolean z;
        boolean z3;
        Object obj9;
        int traceInProgress;
        int defaultsInvalid;
        Object visualTransformation5;
        Object visualTransformation2;
        Object it$iv2;
        Object compositionCoroutineScope;
        Object $i$a$CacheCoreTextFieldKt$CoreTextField$bringIntoViewRequester$1;
        Object endRestartGroup;
        Object $i$a$CacheCoreTextFieldKt$CoreTextField$undoManager$1;
        Object $i$a$CacheEffectsKt$rememberCoroutineScope$wrapper$1$iv;
        int it$iv13;
        int i8;
        int changed5;
        Composer bringIntoViewRequester;
        int i28;
        Object onTextLayout3;
        Object onTextLayout2;
        Object it$iv15;
        Object $i$a$CacheCoreTextFieldKt$CoreTextField$focusModifier$1;
        int i18;
        int writeable$delegate;
        Object it$iv8;
        androidx.compose.foundation.text.LegacyTextFieldState it$iv9;
        int i22;
        int i51;
        Object it$iv;
        Object it$iv7;
        int i52;
        int i14;
        int $i$a$CacheCoreTextFieldKt$CoreTextField$semanticsModifier$1;
        Object empty3;
        Object obj;
        Object it$iv10;
        int i43;
        int i41;
        Object filterWithValidation;
        Object it$iv4;
        Object focusManager;
        int i56;
        int i57;
        int i44;
        int changed3;
        int i59;
        Object minLines4;
        int $dirty;
        Composer it$iv5;
        Object $i$a$CacheCoreTextFieldKt$CoreTextField$2;
        int i16;
        int i45;
        Object $this$cache$iv3;
        Object maxLines2;
        int $dirty1;
        androidx.compose.foundation.text.KeyboardActions $dirty12;
        Object $i$a$CacheCoreTextFieldKt$CoreTextField$focusRequester$1;
        Composer it$iv11;
        Composer composer3;
        Object it$iv14;
        Object $this$cache$iv2;
        Object decorationBox2;
        int i40;
        Object str2;
        int i36;
        Composer composer5;
        Modifier windowFocused2;
        Modifier textFieldMagnifier;
        int empty;
        int changed2;
        Object obj12;
        Object obj16;
        Object interactionSource2;
        int i37;
        int i53;
        int i21;
        int i10;
        int windowFocused;
        int changed;
        SolidColor visualTransformation4;
        SolidColor cursorBrush2;
        Object $i$a$CacheCoreTextFieldKt$CoreTextField$legacyTextInputServiceAdapter$1;
        Object it$iv3;
        TextFieldValue textInputService;
        Object $i$a$CacheCoreTextFieldKt$CoreTextField$onPositionedModifier$1;
        int i7;
        Object $i$f$cache4;
        Object it$iv6;
        int changed4;
        int i31;
        Object unspecified-0d7_KjU;
        int softWrap2;
        Composer $this$cache$iv;
        Object unbox-impl;
        Object offsetMapping;
        int i54;
        int i39;
        Object obj11;
        int maxLines4;
        Composer composer2;
        OffsetMapping state;
        int $i$a$CacheCoreTextFieldKt$CoreTextField$pointerModifier$2;
        Object it$iv12;
        Composer composer4;
        int i;
        int i2;
        Object $i$f$cache5;
        int i27;
        Object onGloballyPositioned;
        boolean changed7;
        int onPositionedModifier;
        int i61;
        int i9;
        int minLines2;
        Object empty2;
        int i29;
        Object $i$f$cache3;
        Object $i$f$cache;
        int i11;
        Object windowInfo;
        Object manager3;
        ImeOptions imeOptions3;
        Object i38;
        androidx.compose.foundation.text.LegacyTextFieldState bringIntoViewRequester2;
        Object state2;
        int $i$f$cache2;
        androidx.compose.foundation.text.LegacyTextFieldState manager;
        ImeOptions state3;
        androidx.compose.foundation.text.KeyboardActions keyboardActions4;
        Object obj18;
        int modifier2;
        Object enabled3;
        OffsetMapping manager2;
        int i50;
        int i3;
        ImeOptions imeOptions2;
        androidx.compose.foundation.text.LegacyTextFieldState imeOptions4;
        int i17;
        int i30;
        int i46;
        int enabled4;
        int enabled2;
        Function3 readOnly3;
        int i6;
        Object keyboardActions3;
        Object keyboardActions2;
        Modifier offsetMapping2;
        Object decorationBoxModifier;
        int i25;
        int readOnly2;
        int i60;
        int showHandleAndMagnifier;
        int i55;
        Object decorationBox3;
        Object decorationBox4;
        int i42;
        int i49;
        androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.pointerModifier.2.1 companion5;
        int i24;
        int companion4;
        int $composer3;
        int i26;
        int i19;
        int minLines3;
        Object focusRequester;
        int i32;
        int backgroundColor-0d7_KjU;
        int i13;
        int i12;
        int i58;
        int changed8;
        int i4;
        int singleLine;
        boolean changed6;
        int i47;
        int i23;
        ImeOptions i48;
        Orientation horizontal;
        Orientation orientation;
        androidx.compose.runtime.RecomposeScope scrollerPosition;
        int invalid$iv2;
        SolidColor solidColor;
        Object obj7;
        Modifier visualTransformation3;
        Object obj8;
        Composer $composer2;
        Object composition-MzsxiRA;
        Object obj2;
        Object obj5;
        Object maxLines3;
        int maxLines5;
        Object legacyTextInputServiceAdapter;
        Object obj6;
        Object companion3;
        Object obj4;
        Object interactionSource3;
        Composer.Companion companion7;
        int i34;
        Composer.Companion companion8;
        int i5;
        Object obj15;
        TransformedText companion6;
        boolean invalid$iv;
        Object $i$a$RememberCoroutineScopeEffectsKt$rememberCoroutineScope$1;
        kotlinx.coroutines.CoroutineScope coroutineScope;
        Object obj19;
        Modifier density;
        Object obj20;
        int i15;
        AnnotatedString str;
        Object obj10;
        Modifier textStyle2;
        int bringIntoViewRequester3;
        Object obj13;
        int companion;
        androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.2.1 field;
        Composer.Companion companion2;
        Composer composer;
        Modifier modifier3;
        ScopeUpdateScope scopeUpdateScope;
        int obj59;
        Object obj60;
        Object obj61;
        int obj62;
        int obj63;
        int obj64;
        int obj65;
        Object obj66;
        Object obj67;
        int obj68;
        int obj69;
        int obj70;
        androidx.compose.foundation.text.KeyboardActions obj71;
        Modifier obj72;
        int obj73;
        Object obj23 = value;
        int i62 = $changed;
        int i93 = $changed1;
        int i112 = i20;
        Composer restartGroup = $composer.startRestartGroup(-958708118);
        ComposerKt.sourceInformation(restartGroup, "C(CoreTextField)P(14,10,8,13,15,9,4!1,12,6,7,3,5,2,11)221@12329L29,222@12399L58,223@12503L72,228@12633L7,229@12694L7,230@12762L7,231@12827L7,232@12872L7,233@12941L7,241@13250L42,238@13157L135,244@13333L269,257@13907L21,258@13945L403,287@14747L26,290@14833L51,296@15136L7,297@15187L7,298@15244L7,303@15385L24,304@15443L37,311@15672L1487,352@17266L42,353@17334L970,353@17313L991,379@18375L28,380@18467L907,408@19636L516,425@20215L1473,462@21825L6646,616@28696L60,616@28670L86,620@28791L458,620@28762L487,647@29739L1132,694@31923L4765,694@31870L4818:CoreTextField.kt#423gt5");
        $dirty = $changed;
        $dirty1 = $changed1;
        if (i112 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (i62 & 6 == 0) {
                i40 = restartGroup.changed(obj23) ? 4 : 2;
                $dirty |= i40;
            }
        }
        if (i112 & 2 != 0) {
            $dirty |= 48;
            str2 = onValueChange;
        } else {
            if (i62 & 48 == 0) {
                i61 = restartGroup.changedInstance(onValueChange) ? 32 : 16;
                $dirty |= i61;
            } else {
                str2 = onValueChange;
            }
        }
        i9 = i112 & 4;
        if (i9 != 0) {
            $dirty |= 384;
            obj18 = modifier;
        } else {
            if (i62 & 384 == 0) {
                i3 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty |= i3;
            } else {
                obj18 = modifier;
            }
        }
        int i206 = i112 & 8;
        if (i206 != 0) {
            $dirty |= 3072;
            i38 = textStyle;
        } else {
            if (i62 & 3072 == 0) {
                i6 = restartGroup.changed(textStyle) ? 2048 : 1024;
                $dirty |= i6;
            } else {
                i38 = textStyle;
            }
        }
        keyboardActions2 = i112 & 16;
        if (keyboardActions2 != 0) {
            $dirty |= 24576;
            obj11 = visualTransformation;
        } else {
            if (i62 & 24576 == 0) {
                i25 = restartGroup.changed(visualTransformation) ? 16384 : 8192;
                $dirty |= i25;
            } else {
                obj11 = visualTransformation;
            }
        }
        readOnly2 = i112 & 32;
        i55 = 196608;
        if (readOnly2 != 0) {
            $dirty |= i55;
            unspecified-0d7_KjU = onTextLayout;
        } else {
            if (i62 & i55 == 0) {
                i49 = restartGroup.changedInstance(onTextLayout) ? 131072 : 65536;
                $dirty |= i49;
            } else {
                unspecified-0d7_KjU = onTextLayout;
            }
        }
        int i221 = i112 & 64;
        companion4 = 1572864;
        if (i221 != 0) {
            $dirty |= companion4;
            obj16 = interactionSource;
        } else {
            if (i62 & companion4 == 0) {
                $composer3 = restartGroup.changed(interactionSource) ? 1048576 : 524288;
                $dirty |= $composer3;
            } else {
                obj16 = interactionSource;
            }
        }
        int i154 = i112 & 128;
        i19 = 12582912;
        if (i154 != 0) {
            $dirty |= i19;
            obj14 = cursorBrush;
        } else {
            if (i62 & i19 == 0) {
                i19 = restartGroup.changed(cursorBrush) ? 8388608 : 4194304;
                $dirty |= i19;
            } else {
                obj14 = cursorBrush;
            }
        }
        int i63 = i112 & 256;
        int i231 = 100663296;
        if (i63 != 0) {
            $dirty |= i231;
            minLines3 = i63;
            z2 = softWrap;
        } else {
            if ($changed & i231 == 0) {
                minLines3 = i63;
                i32 = restartGroup.changed(softWrap) ? 67108864 : 33554432;
                $dirty |= i32;
            } else {
                minLines3 = i63;
                z2 = softWrap;
            }
        }
        int i64 = i112 & 512;
        int i234 = 805306368;
        if (i64 != 0) {
            $dirty |= i234;
            backgroundColor-0d7_KjU = i64;
            i33 = maxLines;
        } else {
            if ($changed & i234 == 0) {
                backgroundColor-0d7_KjU = i64;
                i13 = restartGroup.changed(maxLines) ? 536870912 : 268435456;
                $dirty |= i13;
            } else {
                backgroundColor-0d7_KjU = i64;
                i33 = maxLines;
            }
        }
        int i65 = i112 & 1024;
        if (i65 != 0) {
            $dirty1 |= 6;
            i12 = i65;
            i35 = minLines;
        } else {
            if (i93 & 6 == 0) {
                i12 = i65;
                i58 = restartGroup.changed(minLines) ? 4 : 2;
                $dirty1 |= i58;
            } else {
                i12 = i65;
                i35 = minLines;
            }
        }
        if (i93 & 48 == 0) {
            if (i112 & 2048 == 0) {
                changed8 = restartGroup.changed(imeOptions) ? 32 : 16;
            } else {
                obj3 = imeOptions;
            }
            $dirty1 |= changed8;
        } else {
            obj3 = imeOptions;
        }
        int i66 = i112 & 4096;
        if (i66 != 0) {
            $dirty1 |= 384;
            i4 = i66;
            obj17 = keyboardActions;
        } else {
            i4 = i66;
            if (i93 & 384 == 0) {
                i30 = restartGroup.changed(keyboardActions) ? 256 : 128;
                $dirty1 |= i30;
            } else {
                obj17 = keyboardActions;
            }
        }
        int i68 = i112 & 8192;
        if (i68 != 0) {
            $dirty1 |= 3072;
            i46 = i68;
            z = enabled;
        } else {
            i46 = i68;
            if (i93 & 3072 == 0) {
                changed6 = restartGroup.changed(enabled) ? 2048 : 1024;
                $dirty1 |= changed6;
            } else {
                z = enabled;
            }
        }
        int i69 = i112 & 16384;
        if (i69 != 0) {
            $dirty1 |= 24576;
            i47 = i69;
            z3 = readOnly;
        } else {
            i47 = i69;
            if (i93 & 24576 == 0) {
                i23 = restartGroup.changed(readOnly) ? 16384 : 8192;
                $dirty1 |= i23;
            } else {
                z3 = readOnly;
            }
        }
        i48 = i112 & i240;
        if (i48 != 0) {
            $dirty1 |= i55;
            obj9 = decorationBox;
        } else {
            if (i93 & i55 == 0) {
                i55 = restartGroup.changedInstance(decorationBox) ? 131072 : 65536;
                $dirty1 |= i55;
            } else {
                obj9 = decorationBox;
            }
        }
        if ($dirty & decorationBox4 == 306783378 && i78 &= $dirty1 == 74898) {
            if (i78 &= $dirty1 == 74898) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    if ($changed & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if (i9 != 0) {
                                obj18 = defaultsInvalid;
                            }
                            if (i206 != 0) {
                                i38 = defaultsInvalid;
                            }
                            if (keyboardActions2 != 0) {
                                visualTransformation5 = VisualTransformation.Companion.getNone();
                            } else {
                                visualTransformation5 = obj11;
                            }
                            if (readOnly2 != 0) {
                                onTextLayout3 = CoreTextFieldKt.CoreTextField.1.INSTANCE;
                            } else {
                                onTextLayout3 = unspecified-0d7_KjU;
                            }
                            if (i221 != 0) {
                                obj16 = 0;
                            }
                            if (i154 != 0) {
                                cursorBrush2 = new SolidColor(Color.Companion.getUnspecified-0d7_KjU(), obj11, 0);
                            } else {
                                cursorBrush2 = cursorBrush;
                            }
                            softWrap2 = minLines3 != 0 ? 1 : softWrap;
                            maxLines4 = backgroundColor-0d7_KjU != 0 ? 0x7fffffff /* Unknown resource */ : maxLines;
                            minLines2 = i12 != 0 ? 1 : minLines;
                            if (i112 & 2048 != 0) {
                                imeOptions2 = ImeOptions.Companion.getDefault();
                                $dirty1 &= -113;
                            } else {
                                imeOptions2 = imeOptions;
                            }
                            if (i4 != 0) {
                                keyboardActions3 = KeyboardActions.Companion.getDefault();
                            } else {
                                keyboardActions3 = keyboardActions;
                            }
                            enabled4 = i46 != 0 ? 1 : enabled;
                            readOnly2 = i47 != 0 ? 0 : readOnly;
                            if (i48 != 0) {
                                decorationBox3 = ComposableSingletons.CoreTextFieldKt.INSTANCE.getLambda-1$foundation_release();
                                i52 = $dirty1;
                                $dirty12 = keyboardActions3;
                                keyboardActions2 = onTextLayout3;
                                onTextLayout2 = obj16;
                                interactionSource2 = visualTransformation5;
                                visualTransformation2 = obj18;
                                modifier2 = enabled4;
                                enabled2 = readOnly2;
                            } else {
                                decorationBox3 = decorationBox;
                                i52 = $dirty1;
                                $dirty12 = keyboardActions3;
                                keyboardActions2 = onTextLayout3;
                                onTextLayout2 = obj16;
                                interactionSource2 = visualTransformation5;
                                visualTransformation2 = obj18;
                                modifier2 = enabled4;
                                enabled2 = readOnly2;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            if (i112 & 2048 != 0) {
                                $dirty1 &= -113;
                            }
                            cursorBrush2 = cursorBrush;
                            minLines2 = minLines;
                            imeOptions2 = imeOptions;
                            enabled2 = readOnly;
                            decorationBox3 = decorationBox;
                            i52 = $dirty1;
                            onTextLayout2 = obj16;
                            keyboardActions2 = unspecified-0d7_KjU;
                            interactionSource2 = obj11;
                            visualTransformation2 = obj18;
                            softWrap2 = softWrap;
                            maxLines4 = maxLines;
                            $dirty12 = keyboardActions;
                            modifier2 = enabled;
                        }
                    } else {
                    }
                    restartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        obj71 = $dirty12;
                        ComposerKt.traceEventStart(-958708118, $dirty, i52, "androidx.compose.foundation.text.CoreTextField (CoreTextField.kt:220)");
                    } else {
                        obj71 = $dirty12;
                    }
                    String str4 = "CC(remember):CoreTextField.kt#9igjgp";
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1705356604, str4);
                    obj59 = restartGroup;
                    int i210 = 0;
                    obj73 = $dirty;
                    Object rememberedValue6 = obj59.rememberedValue();
                    int i222 = 0;
                    obj60 = i142;
                    if (rememberedValue6 == Composer.Companion.getEmpty()) {
                        int i146 = 0;
                        focusRequester = new FocusRequester();
                        obj61 = rememberedValue6;
                        obj59.updateRememberedValue(focusRequester);
                    } else {
                        it$iv5 = obj59;
                        $i$a$CacheCoreTextFieldKt$CoreTextField$focusRequester$1 = obj61;
                    }
                    $this$cache$iv3 = $i$a$CacheCoreTextFieldKt$CoreTextField$focusRequester$1;
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1705354335, str4);
                    obj59 = restartGroup;
                    int i211 = 0;
                    obj60 = i144;
                    Object rememberedValue7 = obj59.rememberedValue();
                    int i223 = 0;
                    if (rememberedValue7 == Composer.Companion.getEmpty()) {
                        int i167 = 0;
                        obj61 = rememberedValue7;
                        obj59.updateRememberedValue(LegacyPlatformTextInputServiceAdapter_androidKt.createLegacyPlatformTextInputServiceAdapter());
                    } else {
                        it$iv11 = obj59;
                        $i$a$CacheCoreTextFieldKt$CoreTextField$legacyTextInputServiceAdapter$1 = obj61;
                    }
                    $this$cache$iv2 = $i$a$CacheCoreTextFieldKt$CoreTextField$legacyTextInputServiceAdapter$1;
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1705350993, str4);
                    obj59 = restartGroup;
                    int i212 = 0;
                    obj60 = i156;
                    it$iv3 = obj59.rememberedValue();
                    int i224 = 0;
                    obj66 = softWrap2;
                    if (it$iv3 == Composer.Companion.getEmpty()) {
                        obj61 = it$iv3;
                        obj62 = i169;
                        it$iv3 = new TextInputService((PlatformTextInputService)(LegacyPlatformTextInputServiceAdapter)$this$cache$iv2);
                        obj59.updateRememberedValue(it$iv3);
                    } else {
                        $this$cache$iv = obj59;
                        obj61 = it$iv3;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    int i213 = 0;
                    int i225 = 0;
                    obj67 = i38;
                    String textStyle4 = "CC:CompositionLocal.kt#9igjgp";
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, textStyle4);
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    int i214 = 0;
                    int i236 = 0;
                    obj68 = this_$iv;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, textStyle4);
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    int i215 = 6;
                    int i237 = 0;
                    obj69 = consume4;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, textStyle4);
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    int i216 = 0;
                    obj59 = i179;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, textStyle4);
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    int i217 = 0;
                    int i239 = 0;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, textStyle4);
                    unbox-impl = restartGroup.consume((CompositionLocal)CompositionLocalsKt.getLocalWindowInfo());
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    int i218 = 0;
                    singleLine = 0;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, textStyle4);
                    Object consume = restartGroup.consume((CompositionLocal)CompositionLocalsKt.getLocalSoftwareKeyboardController());
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    int i180 = 1;
                    if (maxLines4 == i180 && obj66 == null && imeOptions2.getSingleLine()) {
                        if (obj66 == null) {
                            i4 = imeOptions2.getSingleLine() ? i180 : 0;
                        } else {
                        }
                    } else {
                    }
                    horizontal = i4 != 0 ? Orientation.Horizontal : Orientation.Vertical;
                    Orientation orientation4 = horizontal;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1705327119, str4);
                    Orientation orientation2 = orientation4;
                    obj59 = restartGroup;
                    int i243 = 0;
                    Composer composer23 = restartGroup;
                    it$iv10 = obj59.rememberedValue();
                    composition-MzsxiRA = 0;
                    if (!restartGroup.changed(orientation2)) {
                        legacyTextInputServiceAdapter = $this$cache$iv2;
                        if (it$iv10 == Composer.Companion.getEmpty()) {
                            int legacyTextInputServiceAdapter2 = 0;
                            obj60 = it$iv10;
                            it$iv10 = new CoreTextFieldKt.CoreTextField.scrollerPosition.1.1(orientation2);
                            obj59.updateRememberedValue((Function0)it$iv10);
                        } else {
                            composer3 = obj59;
                            obj60 = it$iv10;
                        }
                    } else {
                        legacyTextInputServiceAdapter = $this$cache$iv2;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer23);
                    obj63 = composer23;
                    Composer composer13 = obj63;
                    orientation = orientation2;
                    ComposerKt.sourceInformationMarkerStart(composer13, -1705324236, str4);
                    Object obj34 = rememberSaveable;
                    i43 = obj73 & 14 == 4 ? 1 : 0;
                    int i242 = 57344;
                    i41 = obj73 & i242 == 16384 ? 1 : 0;
                    Composer composer16 = composer13;
                    int i245 = 0;
                    filterWithValidation = composer16.rememberedValue();
                    int i257 = 0;
                    if (obj59 | i41 == 0) {
                        maxLines5 = maxLines4;
                        if (filterWithValidation == Composer.Companion.getEmpty()) {
                            maxLines4 = 0;
                            obj60 = filterWithValidation;
                            filterWithValidation = ValidatingOffsetMappingKt.filterWithValidation(interactionSource2, obj23.getAnnotatedString());
                            composition-MzsxiRA = obj23.getComposition-MzsxiRA();
                            if (composition-MzsxiRA != null) {
                                companion3 = unbox-impl;
                                obj61 = maxLines4;
                                composition-MzsxiRA = 0;
                                interactionSource3 = onTextLayout2;
                                if (TextFieldDelegate.Companion.applyCompositionDecoration-72CqOWE(composition-MzsxiRA.unbox-impl(), maxLines4) == null) {
                                    onTextLayout2 = filterWithValidation;
                                }
                            } else {
                                interactionSource3 = onTextLayout2;
                                companion3 = unbox-impl;
                                obj61 = maxLines4;
                            }
                            composer16.updateRememberedValue(onTextLayout2);
                        } else {
                            interactionSource3 = onTextLayout2;
                            onTextLayout2 = obj60;
                            companion3 = unbox-impl;
                        }
                    } else {
                        maxLines5 = maxLines4;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer13);
                    OffsetMapping offsetMapping3 = onTextLayout2.getOffsetMapping();
                    androidx.compose.runtime.RecomposeScope currentRecomposeScope = ComposablesKt.getCurrentRecomposeScope(composer13, 0);
                    ComposerKt.sourceInformationMarkerStart(composer13, -1705304518, str4);
                    changed7 = composer13.changed((SoftwareKeyboardController)consume);
                    Composer composer22 = composer13;
                    int i258 = 0;
                    obj60 = text;
                    it$iv4 = composer22.rememberedValue();
                    int i260 = 0;
                    if (!changed7) {
                        invalid$iv = changed7;
                        if (it$iv4 == Composer.Companion.getEmpty()) {
                            obj15 = it$iv4;
                            obj64 = obj66;
                            obj61 = obj67;
                            obj66 = obj68;
                            obj67 = obj69;
                            obj59 = textDelegate;
                            super(obj60, obj61, 0, 0, obj64, 0, obj66, obj67, 0, 300, 0);
                            obj59 = i264;
                            str = obj60;
                            obj10 = obj61;
                            i15 = obj64;
                            obj19 = obj66;
                            obj20 = obj67;
                            it$iv4 = new LegacyTextFieldState(obj59, currentRecomposeScope, consume);
                            composer22.updateRememberedValue(it$iv4);
                        } else {
                            str = obj60;
                            i15 = obj66;
                            obj10 = obj67;
                            obj19 = obj68;
                            obj20 = obj69;
                            obj15 = it$iv4;
                            composer2 = composer22;
                        }
                    } else {
                        invalid$iv = changed7;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer13);
                    obj67 = obj71;
                    obj59 = it$iv4;
                    obj68 = obj32;
                    obj62 = obj10;
                    obj59.update-fnh65Uc(obj23.getAnnotatedString(), str, obj62, i15, obj19, obj20, onValueChange, obj67, obj68, (TextSelectionColors)restartGroup.consume((CompositionLocal)TextSelectionColorsKt.getLocalTextSelectionColors()).getBackgroundColor-0d7_KjU());
                    androidx.compose.foundation.text.LegacyTextFieldState field4 = obj59;
                    focusManager = obj68;
                    field4.getProcessor().reset(obj23, field4.getInputSession());
                    ComposerKt.sourceInformationMarkerStart(composer13, -1705279231, str4);
                    Composer composer17 = composer13;
                    int i246 = 0;
                    obj59 = i72;
                    it$iv2 = composer17.rememberedValue();
                    int i259 = 0;
                    if (it$iv2 == Composer.Companion.getEmpty()) {
                        obj60 = it$iv2;
                        obj61 = i92;
                        companion6 = onTextLayout2;
                        obj2 = focusManager;
                        it$iv2 = new UndoManager(0, 1, 0);
                        composer17.updateRememberedValue(it$iv2);
                    } else {
                        obj60 = it$iv2;
                        companion6 = onTextLayout2;
                        obj2 = focusManager;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer13);
                    obj60 = value;
                    UndoManager.snapshotIfNeeded$default((UndoManager)it$iv2, obj60, 0, obj62, 2);
                    ComposerKt.sourceInformationMarkerStart(composer13, -1705276454, str4);
                    Composer composer7 = composer13;
                    obj59 = i96;
                    it$iv15 = composer7.rememberedValue();
                    int i248 = 0;
                    obj60 = i184;
                    if (it$iv15 == Composer.Companion.getEmpty()) {
                        empty2 = 0;
                        obj61 = it$iv15;
                        it$iv15 = new TextFieldSelectionManager(it$iv2);
                        composer7.updateRememberedValue(it$iv15);
                    } else {
                        obj61 = it$iv15;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer13);
                    (TextFieldSelectionManager)it$iv15.setOffsetMapping$foundation_release(offsetMapping3);
                    it$iv15.setVisualTransformation$foundation_release(interactionSource2);
                    it$iv15.setOnValueChange$foundation_release(field4.getOnValueChange());
                    it$iv15.setState$foundation_release(field4);
                    it$iv15.setValue$foundation_release(obj60);
                    int i185 = 0;
                    int i249 = 0;
                    ComposerKt.sourceInformationMarkerStart(composer13, 2023513938, textStyle4);
                    ComposerKt.sourceInformationMarkerEnd(composer13);
                    it$iv15.setClipboardManager$foundation_release((ClipboardManager)composer13.consume((CompositionLocal)CompositionLocalsKt.getLocalClipboardManager()));
                    int i122 = 0;
                    int i186 = 0;
                    ComposerKt.sourceInformationMarkerStart(composer13, 2023513938, textStyle4);
                    ComposerKt.sourceInformationMarkerEnd(composer13);
                    it$iv15.setTextToolbar((TextToolbar)composer13.consume((CompositionLocal)CompositionLocalsKt.getLocalTextToolbar()));
                    int i84 = 0;
                    int i123 = 0;
                    ComposerKt.sourceInformationMarkerStart(composer13, 2023513938, textStyle4);
                    ComposerKt.sourceInformationMarkerEnd(composer13);
                    it$iv15.setHapticFeedBack((HapticFeedback)composer13.consume((CompositionLocal)CompositionLocalsKt.getLocalHapticFeedback()));
                    it$iv15.setFocusRequester((FocusRequester)$this$cache$iv3);
                    it$iv15.setEditable(enabled2 ^ 1);
                    it$iv15.setEnabled(modifier2);
                    ComposerKt.sourceInformationMarkerStart(composer13, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerStart(composer13, -954363344, "CC(remember):Effects.kt#9igjgp");
                    int i189 = 0;
                    Composer composer20 = composer13;
                    int i226 = 0;
                    obj59 = i74;
                    compositionCoroutineScope = composer20.rememberedValue();
                    int i250 = 0;
                    obj60 = i85;
                    if (compositionCoroutineScope == Composer.Companion.getEmpty()) {
                        int i263 = 0;
                        obj61 = compositionCoroutineScope;
                        obj62 = i91;
                        $i$a$CacheEffectsKt$rememberCoroutineScope$wrapper$1$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope((CoroutineContext)EmptyCoroutineContext.INSTANCE, composer13));
                        composer20.updateRememberedValue($i$a$CacheEffectsKt$rememberCoroutineScope$wrapper$1$iv);
                    } else {
                        $i$a$CacheEffectsKt$rememberCoroutineScope$wrapper$1$iv = obj61;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer13);
                    kotlinx.coroutines.CoroutineScope coroutineScope2 = (CompositionScopedCoroutineScopeCanceller)$i$a$CacheEffectsKt$rememberCoroutineScope$wrapper$1$iv.getCoroutineScope();
                    ComposerKt.sourceInformationMarkerEnd(composer13);
                    ComposerKt.sourceInformationMarkerStart(composer13, -1705256948, str4);
                    Composer composer9 = composer13;
                    int i190 = 0;
                    Object rememberedValue8 = composer9.rememberedValue();
                    int i227 = 0;
                    obj59 = i76;
                    if (rememberedValue8 == Composer.Companion.getEmpty()) {
                        int i77 = 0;
                        composer9.updateRememberedValue(BringIntoViewRequesterKt.BringIntoViewRequester());
                    } else {
                        $i$a$CacheCoreTextFieldKt$CoreTextField$bringIntoViewRequester$1 = rememberedValue8;
                    }
                    Object obj30 = $i$a$CacheCoreTextFieldKt$CoreTextField$bringIntoViewRequester$1;
                    ComposerKt.sourceInformationMarkerEnd(composer13);
                    ComposerKt.sourceInformationMarkerStart(composer13, -1705248170, str4);
                    i56 = i52 & 7168 == 2048 ? 1 : 0;
                    i57 = i52 & i242 == 16384 ? 1 : 0;
                    i44 = obj73 & 14 == 4 ? 1 : 0;
                    if (i194 ^= 48 > 32) {
                        if (!composer13.changed(imeOptions2)) {
                            i59 = i52 & 48 == 32 ? 1 : 0;
                        } else {
                        }
                    } else {
                    }
                    Composer composer18 = composer13;
                    int i228 = 0;
                    obj68 = coroutineScope2;
                    Object rememberedValue = composer18.rememberedValue();
                    int i251 = 0;
                    if (i136 |= changedInstance18 == 0) {
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            int manager5 = 0;
                            obj64 = value;
                            obj63 = it$iv3;
                            obj66 = offsetMapping3;
                            obj60 = field4;
                            obj69 = obj30;
                            obj61 = modifier2;
                            obj59 = anon4;
                            super(obj60, obj61, enabled2, obj63, obj64, imeOptions2, obj66, obj67, obj68, obj69);
                            bringIntoViewRequester2 = obj60;
                            offsetMapping = obj63;
                            textInputService = obj64;
                            state = obj66;
                            enabled3 = obj67;
                            coroutineScope = obj68;
                            obj13 = obj69;
                            obj59 = rememberedValue;
                            it$iv13 = obj61;
                            composer18.updateRememberedValue((Function1)obj59);
                        } else {
                            coroutineScope = obj68;
                            $i$a$CacheCoreTextFieldKt$CoreTextField$focusModifier$1 = obj59;
                            obj13 = obj30;
                            it$iv13 = modifier2;
                            enabled3 = obj67;
                            bringIntoViewRequester2 = field4;
                            state = offsetMapping3;
                            offsetMapping = it$iv3;
                            textInputService = value;
                        }
                    } else {
                        obj67 = it$iv15;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer13);
                    Object obj24 = interactionSource3;
                    Modifier textFieldFocusModifier = TextFieldGestureModifiersKt.textFieldFocusModifier((Modifier)Modifier.Companion, it$iv13, $this$cache$iv3, obj24, (Function1)$i$a$CacheCoreTextFieldKt$CoreTextField$focusModifier$1);
                    if (it$iv13 != 0 && enabled2 == 0) {
                        i18 = enabled2 == 0 ? 1 : 0;
                    } else {
                    }
                    State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Boolean.valueOf(i18), composer13, 0);
                    companion5 = it$iv13;
                    ComposerKt.sourceInformationMarkerStart(composer13, -1705195503, str4);
                    obj61 = rememberUpdatedState;
                    if (i252 ^ 48 > 32) {
                        if (!composer13.changed(imeOptions2)) {
                            i8 = i52 & 48 == 32 ? 1 : 0;
                        } else {
                        }
                    } else {
                    }
                    Composer composer6 = composer13;
                    int i253 = 0;
                    Object rememberedValue2 = composer6.rememberedValue();
                    companion7 = 0;
                    if (obj59 | i8 == 0) {
                        obj69 = $this$cache$iv3;
                        if (rememberedValue2 == Composer.Companion.getEmpty()) {
                            int focusRequester2 = 0;
                            obj59 = anon5;
                            super(bringIntoViewRequester2, obj61, offsetMapping, enabled3, imeOptions2, 0);
                            companion = obj61;
                            composer6.updateRememberedValue((Function2)obj59);
                        } else {
                            companion = obj61;
                            $i$a$CacheCoreTextFieldKt$CoreTextField$2 = rememberedValue2;
                        }
                    } else {
                        obj69 = $this$cache$iv3;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer13);
                    EffectsKt.LaunchedEffect(Unit.INSTANCE, (Function2)$i$a$CacheCoreTextFieldKt$CoreTextField$2, composer13, 6);
                    ComposerKt.sourceInformationMarkerStart(composer13, -1705163133, str4);
                    Composer composer10 = composer13;
                    $i$f$cache3 = 0;
                    it$iv8 = composer10.rememberedValue();
                    int i254 = 0;
                    if (!composer13.changedInstance(bringIntoViewRequester2)) {
                        obj60 = $i$f$cache3;
                        if (it$iv8 == Composer.Companion.getEmpty()) {
                            $i$f$cache3 = 0;
                            obj61 = it$iv8;
                            it$iv8 = new CoreTextFieldKt.CoreTextField.pointerModifier.1.1(bringIntoViewRequester2);
                            composer10.updateRememberedValue((Function1)it$iv8);
                        } else {
                            obj61 = it$iv8;
                        }
                    } else {
                        obj60 = $i$f$cache3;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer13);
                    ComposerKt.sourceInformationMarkerStart(composer13, -1705159310, str4);
                    i16 = i52 & i242 == 16384 ? 1 : 0;
                    i45 = i52 & 7168 == 2048 ? 1 : 0;
                    Composer composer11 = composer13;
                    int i198 = 0;
                    Object rememberedValue3 = composer11.rememberedValue();
                    int i255 = 0;
                    if (i101 |= changedInstance5 == 0) {
                        if (rememberedValue3 == Composer.Companion.getEmpty()) {
                            obj61 = obj69;
                            obj60 = bringIntoViewRequester2;
                            obj64 = enabled3;
                            obj63 = companion5;
                            obj59 = anon3;
                            super(obj60, obj61, enabled2, obj63, obj64, obj65);
                            state2 = obj61;
                            obj67 = obj64;
                            manager2 = obj65;
                            obj59 = rememberedValue3;
                            it$iv9 = obj60;
                            obj60 = offsetMapping4;
                            $i$a$CacheCoreTextFieldKt$CoreTextField$pointerModifier$2 = obj63;
                            obj61 = i198;
                            composer11.updateRememberedValue((Function1)obj59);
                        } else {
                            obj61 = i198;
                            obj67 = enabled3;
                            $i$a$CacheCoreTextFieldKt$CoreTextField$pointerModifier$2 = companion5;
                            manager2 = obj65;
                            $i$f$cache = obj59;
                            it$iv9 = bringIntoViewRequester2;
                            state2 = obj69;
                        }
                    } else {
                        obj65 = state;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer13);
                    obj61 = $i$a$CacheCoreTextFieldKt$CoreTextField$pointerModifier$2;
                    obj69 = state2;
                    Modifier pointerHoverIcon$default = PointerIconKt.pointerHoverIcon$default(SelectionGesturesKt.selectionGestureInput(TextFieldPressGestureFilterKt.tapPressTextFieldModifier(SelectionGesturesKt.updateSelectionTouchMode((Modifier)Modifier.Companion, (Function1)it$iv8), obj24, $i$a$CacheCoreTextFieldKt$CoreTextField$pointerModifier$2, (Function1)$i$f$cache), obj67.getMouseSelectionObserver$foundation_release(), obj67.getTouchSelectionObserver$foundation_release()), TextPointerIcon_androidKt.getTextPointerIcon(), false, 2, 0);
                    ComposerKt.sourceInformationMarkerStart(composer13, -1705122293, str4);
                    i11 = obj73 & 14 == 4 ? 1 : 0;
                    Composer composer19 = composer13;
                    $i$f$cache2 = 0;
                    it$iv12 = composer19.rememberedValue();
                    int i208 = 0;
                    if (i173 |= changedInstance19 == 0) {
                        obj60 = $i$f$cache2;
                        if (it$iv12 == Composer.Companion.getEmpty()) {
                            $i$f$cache2 = 0;
                            obj62 = it$iv12;
                            it$iv12 = new CoreTextFieldKt.CoreTextField.drawModifier.1.1(it$iv9, textInputService, manager2);
                            composer19.updateRememberedValue((Function1)it$iv12);
                        } else {
                            obj62 = it$iv12;
                        }
                    } else {
                        obj60 = $i$f$cache2;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer13);
                    ComposerKt.sourceInformationMarkerStart(composer13, -1705102808, str4);
                    obj59 = it$iv9;
                    i22 = i52 & 7168 == 2048 ? 1 : 0;
                    Object obj29 = companion3;
                    Object obj31 = obj67;
                    i51 = obj73 & 14 == 4 ? 1 : 0;
                    Composer composer12 = composer13;
                    int i229 = 0;
                    Object rememberedValue4 = composer12.rememberedValue();
                    int i256 = 0;
                    if (i107 |= changedInstance6 == 0) {
                        if (rememberedValue4 == Composer.Companion.getEmpty()) {
                            int i166 = 0;
                            obj60 = obj59;
                            obj62 = obj29;
                            obj63 = obj31;
                            obj59 = anon2;
                            super(obj60, obj61, obj62, obj63, value, manager2);
                            manager = obj60;
                            i34 = obj61;
                            obj4 = obj62;
                            windowInfo = obj63;
                            composer12.updateRememberedValue((Function1)obj59);
                        } else {
                            i34 = obj61;
                            $i$a$CacheCoreTextFieldKt$CoreTextField$onPositionedModifier$1 = rememberedValue4;
                            obj4 = obj29;
                            windowInfo = obj31;
                            manager = obj59;
                        }
                    } else {
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer13);
                    onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned((Modifier)Modifier.Companion, (Function1)$i$a$CacheCoreTextFieldKt$CoreTextField$onPositionedModifier$1);
                    boolean z4 = interactionSource2 instanceof PasswordVisualTransformation;
                    ComposerKt.sourceInformationMarkerStart(composer13, -1705046115, str4);
                    i37 = obj73 & 14 == 4 ? 1 : 0;
                    i24 = i52;
                    i14 = i52 & 7168 == 2048 ? 1 : 0;
                    i53 = i24 & i242 == 16384 ? 1 : 0;
                    if (i152 ^= 48 > 32) {
                        if (!composer13.changed(imeOptions2)) {
                            i21 = i24 & 48 == 32 ? 1 : 0;
                        } else {
                        }
                    } else {
                    }
                    i118 |= i21;
                    Composer composer14 = composer13;
                    int i160 = 0;
                    obj63 = z4;
                    Object rememberedValue5 = composer14.rememberedValue();
                    int i220 = 0;
                    if (empty3 == 0) {
                        invalid$iv2 = empty3;
                        if (rememberedValue5 == Composer.Companion.getEmpty()) {
                            obj68 = windowInfo;
                            obj66 = manager;
                            obj65 = imeOptions2;
                            obj59 = anon;
                            obj62 = i34;
                            super(companion6, value, obj62, obj63, enabled2, obj65, obj66, manager2, obj68, obj69);
                            companion4 = obj63;
                            state3 = obj65;
                            imeOptions4 = obj66;
                            manager3 = obj69;
                            obj59 = rememberedValue5;
                            obj60 = invalid$iv3;
                            $i$a$CacheCoreTextFieldKt$CoreTextField$semanticsModifier$1 = obj62;
                            it$iv = obj68;
                            obj61 = i160;
                            composer14.updateRememberedValue((Function1)obj59);
                        } else {
                            imeOptions4 = manager;
                            state3 = obj59;
                            companion4 = obj63;
                            obj61 = i160;
                            $i$a$CacheCoreTextFieldKt$CoreTextField$semanticsModifier$1 = i34;
                            $i$f$cache4 = obj59;
                            it$iv = windowInfo;
                            manager3 = obj69;
                        }
                    } else {
                        invalid$iv2 = empty3;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer13);
                    Modifier semantics = SemanticsModifierKt.semantics((Modifier)Modifier.Companion, true, (Function1)$i$f$cache4);
                    if ($i$a$CacheCoreTextFieldKt$CoreTextField$semanticsModifier$1 != 0 && enabled2 == 0 && obj4.isWindowFocused() && !imeOptions4.hasHighlight()) {
                        if (enabled2 == 0) {
                            if (obj4.isWindowFocused()) {
                                i10 = !imeOptions4.hasHighlight() ? 1 : 0;
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                    obj61 = value;
                    obj63 = obj72;
                    obj64 = i10;
                    i42 = obj64;
                    ComposerKt.sourceInformationMarkerStart(composer13, -1704832829, str4);
                    obj59 = composer13;
                    companion8 = 0;
                    it$iv6 = obj59.rememberedValue();
                    int i269 = 0;
                    if (!composer13.changedInstance(it$iv)) {
                        obj72 = onGloballyPositioned;
                        if (it$iv6 == Composer.Companion.getEmpty()) {
                            int onPositionedModifier2 = 0;
                            obj61 = it$iv6;
                            it$iv6 = new CoreTextFieldKt.CoreTextField.3.1(it$iv);
                            obj59.updateRememberedValue((Function1)it$iv6);
                        } else {
                            composer4 = obj59;
                            obj61 = it$iv6;
                        }
                    } else {
                        obj72 = onGloballyPositioned;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer13);
                    EffectsKt.DisposableEffect(it$iv, (Function1)it$iv6, composer13, 0);
                    ComposerKt.sourceInformationMarkerStart(composer13, -1704829391, str4);
                    i = obj73 & 14 == 4 ? 1 : 0;
                    if (i163 ^= 48 > 32) {
                        if (!composer13.changed(state3)) {
                            i2 = i24 & 48 == 32 ? 1 : 0;
                        } else {
                        }
                    } else {
                    }
                    Composer composer15 = composer13;
                    $i$f$cache5 = 0;
                    it$iv7 = composer15.rememberedValue();
                    int i230 = 0;
                    if (i109 |= i2 == 0) {
                        obj60 = $i$f$cache5;
                        if (it$iv7 == Composer.Companion.getEmpty()) {
                            $i$f$cache5 = 0;
                            obj61 = it$iv7;
                            it$iv7 = new CoreTextFieldKt.CoreTextField.4.1(imeOptions4, offsetMapping, obj61, state3);
                            composer15.updateRememberedValue((Function1)it$iv7);
                        } else {
                            obj61 = it$iv7;
                        }
                    } else {
                        obj60 = $i$f$cache5;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer13);
                    EffectsKt.DisposableEffect(state3, (Function1)it$iv7, composer13, i164 &= 14);
                    int i153 = maxLines5;
                    int i111 = 1;
                    i26 = i153 == i111 ? i111 : 0;
                    obj61 = obj67;
                    Modifier textFieldKeyInput-2WJ9YEU = TextFieldKeyInputKt.textFieldKeyInput-2WJ9YEU((Modifier)Modifier.Companion, imeOptions4, obj61, value, imeOptions4.getOnValueChange(), enabled2 ^ 1, i26, manager2, it$iv2, state3.getImeAction-eUduSuo());
                    Object obj28 = obj61;
                    ComposerKt.sourceInformationMarkerStart(composer13, -1704798381, str4);
                    if (i168 ^= 48 > 32) {
                        if (!composer13.changed(state3)) {
                            i36 = i24 & 48 == 32 ? 1 : 0;
                        } else {
                        }
                    } else {
                    }
                    Object obj27 = legacyTextInputServiceAdapter;
                    i148 |= changedInstance23;
                    obj59 = composer13;
                    int i209 = 0;
                    Composer composer21 = composer13;
                    it$iv14 = obj59.rememberedValue();
                    int i262 = 0;
                    if (empty == 0) {
                        obj60 = empty;
                        if (it$iv14 == Composer.Companion.getEmpty()) {
                            int invalid$iv4 = 0;
                            obj61 = it$iv14;
                            it$iv14 = new CoreTextFieldKt.CoreTextField.stylusHandwritingModifier.1.1(imeOptions4, manager3, state3, obj27);
                            obj59.updateRememberedValue((Function0)it$iv14);
                        } else {
                            composer5 = obj59;
                            obj61 = it$iv14;
                        }
                    } else {
                        obj60 = empty;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer21);
                    Modifier stylusHandwriting = StylusHandwritingKt.stylusHandwriting((Modifier)Modifier.Companion, CoreTextFieldKt.CoreTextField$lambda$11(companion), (Function0)it$iv14);
                    Object obj25 = obj33;
                    Object obj26 = obj2;
                    CoreTextFieldKt.CoreTextField.decorationBoxModifier.1 scrollerPosition2 = new CoreTextFieldKt.CoreTextField.decorationBoxModifier.1(imeOptions4);
                    if ($i$a$CacheCoreTextFieldKt$CoreTextField$semanticsModifier$1 != 0 && imeOptions4.getHasFocus() && imeOptions4.isInTouchMode() && obj4.isWindowFocused()) {
                        if (imeOptions4.getHasFocus()) {
                            if (imeOptions4.isInTouchMode()) {
                                i60 = obj4.isWindowFocused() ? 1 : 0;
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                    if (i60 != 0) {
                        textFieldMagnifier = TextFieldSelectionManager_androidKt.textFieldMagnifier((Modifier)Modifier.Companion, obj28);
                    } else {
                        textFieldMagnifier = Modifier.Companion;
                    }
                    obj5 = obj26;
                    obj6 = obj27;
                    Modifier legacyTextInputServiceAdapter3 = modifier7;
                    int interactionSource5 = i232;
                    Object modifier6 = obj34;
                    Object focusManager2 = obj35;
                    Object enabled6 = obj10;
                    Object imeOptions5 = obj13;
                    visualTransformation3 = obj59;
                    $composer3 = obj63;
                    minLines3 = obj70;
                    scrollerPosition = obj71;
                    bringIntoViewRequester3 = stylusHandwriting;
                    density = semantics;
                    textStyle2 = textFieldKeyInput-2WJ9YEU;
                    OffsetMapping drawModifier3 = manager2;
                    androidx.compose.foundation.text.LegacyTextFieldState stylusHandwritingModifier = imeOptions4;
                    int semanticsModifier = i261;
                    showHandleAndMagnifier = obj73;
                    maxLines3 = pointerHoverIcon$default;
                    Object offsetMapping5 = obj28;
                    Function3 pointerModifier = decorationBox3;
                    decorationBox4 = manager3;
                    androidx.compose.ui.Modifier.Companion focusRequester3 = textFieldMagnifier;
                    CoreTextFieldKt.CoreTextField.5 decorationBoxModifier2 = new CoreTextFieldKt.CoreTextField.5(pointerModifier, stylusHandwritingModifier, enabled6, interactionSource5, semanticsModifier, modifier6, value, focusManager2, TextFieldCursorKt.cursor((Modifier)Modifier.Companion, imeOptions4, obj61, manager2, obj63, obj64), legacyTextInputServiceAdapter3, obj72, focusRequester3, imeOptions5, offsetMapping5, i60, enabled2, keyboardActions2, drawModifier3, obj19);
                    androidx.compose.foundation.text.LegacyTextFieldState bringIntoViewRequester4 = field2;
                    androidx.compose.ui.Modifier.Companion companion17 = focusRequester3;
                    OffsetMapping manager7 = drawModifier3;
                    offsetMapping2 = legacyTextInputServiceAdapter3;
                    obj59 = obj22;
                    obj69 = decorationBox5;
                    bringIntoViewRequester = composer;
                    CoreTextFieldKt.CoreTextFieldRootBox(OnGloballyPositionedModifierKt.onGloballyPositioned(TextFieldScrollKt.textFieldScrollable(CoreTextFieldKt.previewKeyEventToDeselectOnBack(TextFieldFocusModifier_androidKt.interceptDPadAndMoveFocus(LegacyAdaptingPlatformTextInputModifierNodeKt.legacyTextInputAdapter(obj25, obj27, imeOptions4, obj28).then(stylusHandwriting).then(textFieldFocusModifier), imeOptions4, obj26), imeOptions4, obj28).then(textFieldKeyInput-2WJ9YEU), obj34, obj24, $i$a$CacheCoreTextFieldKt$CoreTextField$semanticsModifier$1).then(pointerHoverIcon$default).then(semantics), (Function1)scrollerPosition2), offsetMapping5, (Function2)ComposableLambdaKt.rememberComposableLambda(-374338080, true, decorationBoxModifier2, bringIntoViewRequester, 54), bringIntoViewRequester, 384);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    onPositionedModifier = interactionSource5;
                    i39 = semanticsModifier;
                    maxLines2 = focusManager2;
                    i17 = enabled2;
                    keyboardActions4 = i47;
                    imeOptions3 = i48;
                    visualTransformation4 = solidColor;
                    obj12 = obj7;
                    i50 = i5;
                    i31 = i15;
                    obj = field;
                    minLines4 = obj67;
                    readOnly3 = scrollerPosition5;
                    decorationBox2 = keyboardActions2;
                } else {
                    restartGroup.skipToGroupEnd();
                    i31 = softWrap;
                    imeOptions3 = imeOptions;
                    i17 = readOnly;
                    readOnly3 = decorationBox;
                    bringIntoViewRequester = restartGroup;
                    showHandleAndMagnifier = $dirty;
                    i24 = $dirty1;
                    obj12 = obj16;
                    decorationBox2 = unspecified-0d7_KjU;
                    maxLines2 = obj11;
                    minLines4 = i38;
                    obj = obj18;
                    visualTransformation4 = cursorBrush;
                    i39 = maxLines;
                    onPositionedModifier = minLines;
                    keyboardActions4 = keyboardActions;
                    i50 = enabled;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = bringIntoViewRequester.endRestartGroup();
        if (endRestartGroup != null) {
            $composer2 = bringIntoViewRequester;
            endRestartGroup = new CoreTextFieldKt.CoreTextField.6(value, onValueChange, obj, minLines4, maxLines2, decorationBox2, obj12, visualTransformation4, i31, i39, onPositionedModifier, imeOptions3, keyboardActions4, i50, i17, readOnly3, $changed, $changed1, i20);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        } else {
            $composer2 = bringIntoViewRequester;
        }
    }

    private static final boolean CoreTextField$lambda$11(State<Boolean> $writeable$delegate) {
        int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (Boolean)$writeable$delegate.getValue().booleanValue();
    }

    private static final void CoreTextFieldRootBox(Modifier modifier, TextFieldSelectionManager manager, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        int traceInProgress;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv;
        Composer restartGroup;
        int $dirty;
        int i8;
        int i3;
        int i;
        boolean skipping;
        boolean traceInProgress2;
        Integer valueOf;
        Composer composer2;
        int str;
        Alignment topStart;
        androidx.compose.ui.layout.MeasurePolicy maybeCachedBoxMeasurePolicy;
        int i12;
        int i9;
        int currentCompositeKeyHash;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap;
        Modifier materializeModifier;
        int i11;
        int i10;
        int i6;
        int i7;
        Composer composer3;
        kotlin.jvm.functions.Function0 function0;
        int i4;
        BoxScopeInstance boxScopeInstance;
        Composer $composer2;
        int i5;
        Composer composer;
        int i2;
        int obj31;
        final Object obj = modifier;
        final Object obj2 = manager;
        final Object obj3 = content;
        final int i13 = $changed;
        traceInProgress = -20551815;
        restartGroup = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(CoreTextFieldRootBox)P(2,1)802@36846L95:CoreTextField.kt#423gt5");
        if (i13 & 6 == 0) {
            i8 = restartGroup.changed(obj) ? 4 : 2;
            $dirty |= i8;
        }
        if (i13 & 48 == 0) {
            i3 = restartGroup.changedInstance(obj2) ? 32 : 16;
            $dirty |= i3;
        }
        if (i13 & 384 == 0) {
            i = restartGroup.changedInstance(obj3) ? 256 : 128;
            $dirty |= i;
        }
        if ($dirty & 147 == 146) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty, -1, "androidx.compose.foundation.text.CoreTextFieldRootBox (CoreTextField.kt:801)");
                }
                int i14 = 1;
                i25 |= 384;
                str = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                i9 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, 0);
                obj31 = i14;
                kotlin.jvm.functions.Function0 function02 = constructor;
                i11 = 0;
                i7 = $dirty;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                restartGroup.startReusableNode();
                if (restartGroup.getInserting()) {
                    restartGroup.createNode(function02);
                } else {
                    factory$iv$iv$iv = function02;
                    restartGroup.useNode();
                }
                Composer constructor-impl = Updater.constructor-impl(restartGroup);
                int i33 = 0;
                function0 = factory$iv$iv$iv;
                Updater.set-impl(constructor-impl, BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), i14), ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, restartGroup.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i34 = 0;
                Composer composer5 = constructor-impl;
                int i35 = 0;
                if (!composer5.getInserting()) {
                    $composer2 = restartGroup;
                    i5 = valueOf;
                    if (!Intrinsics.areEqual(composer5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer2 = composer5;
                    }
                } else {
                    $composer2 = restartGroup;
                    i5 = valueOf;
                }
                Updater.set-impl(constructor-impl, ComposedModifierKt.materializeModifier(restartGroup, obj), ComposeUiNode.Companion.getSetModifier());
                Composer composer4 = $composer2;
                i10 = i18;
                ComposerKt.sourceInformationMarkerStart(composer4, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                i28 |= 6;
                i4 = 0;
                boxScopeInstance = iNSTANCE;
                i2 = i24;
                $dirty = composer3;
                ComposerKt.sourceInformationMarkerStart($dirty, -1183915871, "C803@36902L33:CoreTextField.kt#423gt5");
                ContextMenu_androidKt.ContextMenuArea(obj2, obj3, $dirty, i20 |= restartGroup);
                ComposerKt.sourceInformationMarkerEnd($dirty);
                ComposerKt.sourceInformationMarkerEnd(composer4);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
                $composer2 = restartGroup;
                i7 = $dirty;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            restartGroup = new CoreTextFieldKt.CoreTextFieldRootBox.2(obj, obj2, obj3, i13);
            endRestartGroup.updateScope((Function2)restartGroup);
        }
    }

    private static final void SelectionToolbarAndHandles(TextFieldSelectionManager manager, boolean show, Composer $composer, int $changed) {
        int traceInProgress;
        int $dirty;
        int i4;
        int i6;
        int skipping;
        boolean traceInProgress2;
        int textFieldState;
        int originalToTransformed;
        androidx.compose.foundation.text.LegacyTextFieldState state$foundation_release;
        int i7;
        int i2;
        TextLayoutResult originalToTransformed2;
        int i;
        int layoutResultStale;
        long bidiRunDirection;
        boolean showSelectionHandleEnd;
        int i5;
        int i3;
        androidx.compose.foundation.text.LegacyTextFieldState showSelectionHandleStart;
        traceInProgress = 626339208;
        final Composer obj14 = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(obj14, "C(SelectionToolbarAndHandles):CoreTextField.kt#423gt5");
        if ($changed & 6 == 0) {
            i4 = obj14.changedInstance(manager) ? 4 : 2;
            $dirty |= i4;
        }
        if ($changed & 48 == 0) {
            i6 = obj14.changed(show) ? 32 : 16;
            $dirty |= i6;
        }
        if ($dirty & 19 == 18) {
            if (!obj14.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty, -1, "androidx.compose.foundation.text.SelectionToolbarAndHandles (CoreTextField.kt:1146)");
                }
                Object obj = manager;
                skipping = 0;
                if (show) {
                    obj14.startReplaceGroup(-1286242594);
                    String str2 = "";
                    ComposerKt.sourceInformation(obj14, str2);
                    state$foundation_release = obj.getState$foundation_release();
                    i7 = 0;
                    i2 = 1;
                    state$foundation_release = state$foundation_release.getLayoutResult();
                    state$foundation_release = state$foundation_release.getValue();
                    if (state$foundation_release != null && state$foundation_release != null && state$foundation_release != null) {
                        state$foundation_release = state$foundation_release.getLayoutResult();
                        if (state$foundation_release != null) {
                            state$foundation_release = state$foundation_release.getValue();
                            if (state$foundation_release != null) {
                                originalToTransformed2 = state$foundation_release;
                                i = 0;
                                androidx.compose.foundation.text.LegacyTextFieldState state$foundation_release2 = obj.getState$foundation_release();
                                if (state$foundation_release2 != null) {
                                    layoutResultStale = state$foundation_release2.isLayoutResultStale();
                                } else {
                                    layoutResultStale = i2;
                                }
                                if (layoutResultStale == 0) {
                                    i7 = state$foundation_release;
                                }
                            }
                        }
                    }
                    if (i7 == 0) {
                        obj14.startReplaceGroup(-1285984396);
                    } else {
                        obj14.startReplaceGroup(-1285984395);
                        ComposerKt.sourceInformation(obj14, str2);
                        state$foundation_release = 0;
                        i = 0;
                        if (!TextRange.getCollapsed-impl(obj.getValue$foundation_release().getSelection-d9O1mEE())) {
                            obj14.startReplaceGroup(-1680616096);
                            ComposerKt.sourceInformation(obj14, str2);
                            showSelectionHandleStart = manager.getState$foundation_release();
                            if (showSelectionHandleStart != null && showSelectionHandleStart.getShowSelectionHandleStart() == i2) {
                                i5 = showSelectionHandleStart.getShowSelectionHandleStart() == i2 ? i2 : i;
                            } else {
                            }
                            if (i5 != 0) {
                                obj14.startReplaceGroup(-1680216289);
                                ComposerKt.sourceInformation(obj14, "1158@51449L203");
                                TextFieldSelectionManagerKt.TextFieldSelectionHandle(i2, i7.getBidiRunDirection(obj.getOffsetMapping$foundation_release().originalToTransformed(TextRange.getStart-impl(obj.getValue$foundation_release().getSelection-d9O1mEE()))), manager, obj14, i18 |= 6);
                                obj14.endReplaceGroup();
                            } else {
                                obj14.startReplaceGroup(-1679975078);
                                obj14.endReplaceGroup();
                            }
                            showSelectionHandleEnd = manager.getState$foundation_release();
                            if (showSelectionHandleEnd != null && showSelectionHandleEnd.getShowSelectionHandleEnd() == i2) {
                                if (showSelectionHandleEnd.getShowSelectionHandleEnd() == i2) {
                                } else {
                                    i2 = i;
                                }
                            } else {
                            }
                            if (i2 != 0) {
                                obj14.startReplaceGroup(-1679895904);
                                ComposerKt.sourceInformation(obj14, "1165@51772L202");
                                TextFieldSelectionManagerKt.TextFieldSelectionHandle(i, i7.getBidiRunDirection(Math.max(originalToTransformed2 + -1, i)), manager, obj14, i12 |= 6);
                                obj14.endReplaceGroup();
                            } else {
                                obj14.startReplaceGroup(-1679655654);
                                obj14.endReplaceGroup();
                            }
                            obj14.endReplaceGroup();
                        } else {
                            obj14.startReplaceGroup(-1679637798);
                            obj14.endReplaceGroup();
                        }
                        textFieldState = obj.getState$foundation_release();
                        i2 = 0;
                        if (textFieldState != null && obj.isTextChanged$foundation_release()) {
                            i2 = 0;
                            if (obj.isTextChanged$foundation_release()) {
                                textFieldState.setShowFloatingToolbar(i);
                            }
                            if (textFieldState.getHasFocus()) {
                                if (textFieldState.getShowFloatingToolbar()) {
                                    obj.showSelectionToolbar$foundation_release();
                                } else {
                                    obj.hideSelectionToolbar$foundation_release();
                                }
                            }
                            textFieldState = Unit.INSTANCE;
                        }
                    }
                    obj14.endReplaceGroup();
                    obj14.endReplaceGroup();
                } else {
                    obj14.startReplaceGroup(651305535);
                    obj14.endReplaceGroup();
                    obj.hideSelectionToolbar$foundation_release();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                obj14.skipToGroupEnd();
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = obj14.endRestartGroup();
        if (endRestartGroup != null) {
            skipping = new CoreTextFieldKt.SelectionToolbarAndHandles.2(manager, show, $changed);
            endRestartGroup.updateScope((Function2)skipping);
        }
    }

    public static final void TextFieldCursorHandle(TextFieldSelectionManager manager, Composer $composer, int $changed) {
        int i3;
        int invalid$iv;
        AnnotatedString transformedText$foundation_release;
        androidx.compose.foundation.text.LegacyTextFieldState showCursorHandle;
        int traceInProgress;
        int $dirty;
        int $dirty2;
        boolean traceInProgress2;
        Object anon3;
        Object anon;
        int $i$a$CacheCoreTextFieldKt$TextFieldCursorHandle$2;
        int i5;
        int i6;
        int i;
        int i2;
        long cursorPosition-tuRUvjQ$foundation_release;
        Object empty3;
        Object $i$a$CacheCoreTextFieldKt$TextFieldCursorHandle$observer$1;
        Object empty;
        Object anon2;
        int empty2;
        Object companion;
        int i4;
        final Object obj = manager;
        final int i7 = $changed;
        traceInProgress = -1436003720;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(TextFieldCursorHandle):CoreTextField.kt#423gt5");
        i5 = 2;
        if (i7 & 6 == 0) {
            $i$a$CacheCoreTextFieldKt$TextFieldCursorHandle$2 = restartGroup.changedInstance(obj) ? 4 : i5;
            $dirty |= $i$a$CacheCoreTextFieldKt$TextFieldCursorHandle$2;
        }
        final int i23 = $dirty;
        if (i23 & 3 == i5) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, i23, -1, "androidx.compose.foundation.text.TextFieldCursorHandle (CoreTextField.kt:1189)");
                }
                showCursorHandle = obj.getState$foundation_release();
                $dirty2 = 1;
                if (showCursorHandle != null && showCursorHandle.getShowCursorHandle() == $dirty2) {
                    i3 = showCursorHandle.getShowCursorHandle() == $dirty2 ? $dirty2 : 0;
                } else {
                }
                if (i3 != 0) {
                    transformedText$foundation_release = obj.getTransformedText$foundation_release();
                    if (transformedText$foundation_release != null) {
                        transformedText$foundation_release = (CharSequence)transformedText$foundation_release.length() > 0 ? $dirty2 : 0;
                        i3 = transformedText$foundation_release == $dirty2 ? $dirty2 : 0;
                    } else {
                    }
                    if (i3 != 0) {
                        restartGroup.startReplaceGroup(-285446808);
                        ComposerKt.sourceInformation(restartGroup, "1191@52866L50,1192@52979L7,1194@53039L12,1196@53125L601,1208@53754L309,1193@52996L1077");
                        String str3 = "CC(remember):CoreTextField.kt#9igjgp";
                        ComposerKt.sourceInformationMarkerStart(restartGroup, -424850346, str3);
                        Composer composer2 = restartGroup;
                        int i16 = 0;
                        Object rememberedValue2 = composer2.rememberedValue();
                        int i24 = 0;
                        if (!restartGroup.changed(obj)) {
                            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                                int i26 = 0;
                                composer2.updateRememberedValue(obj.cursorDragObserver$foundation_release());
                            } else {
                                $i$a$CacheCoreTextFieldKt$TextFieldCursorHandle$observer$1 = rememberedValue2;
                            }
                        } else {
                        }
                        invalid$iv = $i$a$CacheCoreTextFieldKt$TextFieldCursorHandle$observer$1;
                        ComposerKt.sourceInformationMarkerEnd(restartGroup);
                        int i17 = 0;
                        int i20 = 0;
                        empty3 = "CC:CompositionLocal.kt#9igjgp";
                        ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, empty3);
                        ComposerKt.sourceInformationMarkerEnd(restartGroup);
                        cursorPosition-tuRUvjQ$foundation_release = obj.getCursorPosition-tuRUvjQ$foundation_release((Density)restartGroup.consume((CompositionLocal)CompositionLocalsKt.getLocalDensity()));
                        ComposerKt.sourceInformationMarkerStart(restartGroup, -424844848, str3);
                        Composer composer3 = restartGroup;
                        int i21 = 0;
                        Object rememberedValue3 = composer3.rememberedValue();
                        int i27 = 0;
                        if (!restartGroup.changed(cursorPosition-tuRUvjQ$foundation_release)) {
                            if (rememberedValue3 == Composer.Companion.getEmpty()) {
                                empty2 = 0;
                                anon3 = new CoreTextFieldKt.TextFieldCursorHandle.1.1(cursorPosition-tuRUvjQ$foundation_release, empty3);
                                composer3.updateRememberedValue((OffsetProvider)anon3);
                            } else {
                                anon3 = rememberedValue3;
                            }
                        } else {
                        }
                        ComposerKt.sourceInformationMarkerEnd(restartGroup);
                        ComposerKt.sourceInformationMarkerStart(restartGroup, -424841507, str3);
                        Composer composer4 = restartGroup;
                        empty = 0;
                        Object rememberedValue4 = composer4.rememberedValue();
                        empty2 = 0;
                        if (changedInstance2 |= changedInstance3 == 0) {
                            if (rememberedValue4 == Composer.Companion.getEmpty()) {
                                companion = anon3;
                                i4 = i12;
                                anon = new CoreTextFieldKt.TextFieldCursorHandle.2.1(invalid$iv, obj, 0);
                                composer4.updateRememberedValue((Function2)anon);
                            } else {
                                companion = anon3;
                                anon = rememberedValue4;
                            }
                        } else {
                        }
                        ComposerKt.sourceInformationMarkerEnd(restartGroup);
                        ComposerKt.sourceInformationMarkerStart(restartGroup, -424821671, str3);
                        Composer composer = restartGroup;
                        int i15 = 0;
                        Object rememberedValue = composer.rememberedValue();
                        int i22 = 0;
                        if (!restartGroup.changed(cursorPosition-tuRUvjQ$foundation_release)) {
                            if (rememberedValue == Composer.Companion.getEmpty()) {
                                empty = 0;
                                anon2 = new CoreTextFieldKt.TextFieldCursorHandle.3.1(cursorPosition-tuRUvjQ$foundation_release, empty3);
                                composer.updateRememberedValue((Function1)anon2);
                            } else {
                                anon2 = rememberedValue;
                            }
                        } else {
                        }
                        ComposerKt.sourceInformationMarkerEnd(restartGroup);
                        i6 = 0;
                        AndroidCursorHandle_androidKt.CursorHandle-USBMPiE(companion, SemanticsModifierKt.semantics$default(SuspendingPointerInputFilterKt.pointerInput((Modifier)Modifier.Companion, invalid$iv, (Function2)anon), i6, (Function1)anon2, 1, 0), 0, i6, restartGroup, 0);
                        restartGroup.endReplaceGroup();
                    } else {
                        restartGroup.startReplaceGroup(-284257090);
                        restartGroup.endReplaceGroup();
                    }
                } else {
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
            $dirty2 = new CoreTextFieldKt.TextFieldCursorHandle.4(obj, i7);
            endRestartGroup.updateScope((Function2)$dirty2);
        }
    }

    public static final boolean access$CoreTextField$lambda$11(State $writeable$delegate) {
        return CoreTextFieldKt.CoreTextField$lambda$11($writeable$delegate);
    }

    public static final void access$CoreTextFieldRootBox(Modifier modifier, TextFieldSelectionManager manager, Function2 content, Composer $composer, int $changed) {
        CoreTextFieldKt.CoreTextFieldRootBox(modifier, manager, content, $composer, $changed);
    }

    public static final void access$SelectionToolbarAndHandles(TextFieldSelectionManager manager, boolean show, Composer $composer, int $changed) {
        CoreTextFieldKt.SelectionToolbarAndHandles(manager, show, $composer, $changed);
    }

    public static final void access$endInputSession(androidx.compose.foundation.text.LegacyTextFieldState state) {
        CoreTextFieldKt.endInputSession(state);
    }

    public static final void access$notifyFocusedRect(androidx.compose.foundation.text.LegacyTextFieldState state, TextFieldValue value, OffsetMapping offsetMapping) {
        CoreTextFieldKt.notifyFocusedRect(state, value, offsetMapping);
    }

    public static final void access$startInputSession(TextInputService textInputService, androidx.compose.foundation.text.LegacyTextFieldState state, TextFieldValue value, ImeOptions imeOptions, OffsetMapping offsetMapping) {
        CoreTextFieldKt.startInputSession(textInputService, state, value, imeOptions, offsetMapping);
    }

    public static final void access$tapToFocus(androidx.compose.foundation.text.LegacyTextFieldState state, FocusRequester focusRequester, boolean allowKeyboard) {
        CoreTextFieldKt.tapToFocus(state, focusRequester, allowKeyboard);
    }

    public static final Object bringSelectionEndIntoView(BringIntoViewRequester $this$bringSelectionEndIntoView, TextFieldValue value, androidx.compose.foundation.text.TextDelegate textDelegate, TextLayoutResult textLayoutResult, OffsetMapping offsetMapping, Continuation<? super Unit> $completion) {
        Rect defaultSize;
        TextStyle style;
        Rect rect;
        float f;
        int i;
        int i2;
        int i4;
        int i3;
        int originalToTransformed = offsetMapping.originalToTransformed(TextRange.getMax-impl(value.getSelection-d9O1mEE()));
        if (originalToTransformed < textLayoutResult.getLayoutInput().getText().length()) {
            defaultSize = textLayoutResult.getBoundingBox(originalToTransformed);
        } else {
            if (originalToTransformed != 0) {
                defaultSize = textLayoutResult.getBoundingBox(originalToTransformed + -1);
            } else {
                style = textDelegate.getStyle();
                i = 0;
                rect = new Rect(i, i, 1065353216, (float)height-impl);
                defaultSize = rect;
            }
        }
        Object bringIntoView = $this$bringSelectionEndIntoView.bringIntoView(defaultSize, $completion);
        if (bringIntoView == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return bringIntoView;
        }
        return Unit.INSTANCE;
    }

    private static final void endInputSession(androidx.compose.foundation.text.LegacyTextFieldState state) {
        int i;
        androidx.compose.foundation.text.TextFieldDelegate.Companion companion;
        EditProcessor processor;
        Function1 onValueChange;
        androidx.compose.ui.text.input.TextInputSession inputSession = state.getInputSession();
        if (inputSession != null) {
            i = 0;
            TextFieldDelegate.Companion.onBlur$foundation_release(inputSession, state.getProcessor(), state.getOnValueChange());
        }
        state.setInputSession(0);
    }

    private static final void notifyFocusedRect(androidx.compose.foundation.text.LegacyTextFieldState state, TextFieldValue value, OffsetMapping offsetMapping) {
        int readObserver;
        androidx.compose.ui.text.input.TextInputSession inputSession;
        androidx.compose.ui.layout.LayoutCoordinates layoutCoordinates;
        androidx.compose.ui.text.input.TextInputSession textInputSession;
        final Snapshot.Companion companion = Snapshot.Companion;
        final int i2 = 0;
        final Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        if (currentThreadSnapshot != null) {
            readObserver = currentThreadSnapshot.getReadObserver();
        } else {
            readObserver = 0;
        }
        final int i3 = readObserver;
        final Snapshot currentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
        int i = 0;
        final androidx.compose.foundation.text.TextLayoutResultProxy layoutResult = state.getLayoutResult();
        if (layoutResult == null) {
            companion.restoreNonObservable(currentThreadSnapshot, currentNonObservable, i3);
        } else {
        }
        TextFieldDelegate.Companion.notifyFocusedRect$foundation_release(value, state.getTextDelegate(), layoutResult.getValue(), layoutCoordinates, textInputSession, state.getHasFocus(), offsetMapping);
        Unit $i$a$WithoutReadObservationCoreTextFieldKt$notifyFocusedRect$1 = Unit.INSTANCE;
        companion.restoreNonObservable(currentThreadSnapshot, currentNonObservable, i3);
    }

    private static final Modifier previewKeyEventToDeselectOnBack(Modifier $this$previewKeyEventToDeselectOnBack, androidx.compose.foundation.text.LegacyTextFieldState state, TextFieldSelectionManager manager) {
        CoreTextFieldKt.previewKeyEventToDeselectOnBack.1 anon = new CoreTextFieldKt.previewKeyEventToDeselectOnBack.1(state, manager);
        return KeyInputModifierKt.onPreviewKeyEvent($this$previewKeyEventToDeselectOnBack, (Function1)anon);
    }

    private static final void startInputSession(TextInputService textInputService, androidx.compose.foundation.text.LegacyTextFieldState state, TextFieldValue value, ImeOptions imeOptions, OffsetMapping offsetMapping) {
        final TextFieldValue field = value;
        state.setInputSession(TextFieldDelegate.Companion.onFocus$foundation_release(textInputService, field, state.getProcessor(), imeOptions, state.getOnValueChange(), state.getOnImeActionPerformed()));
        CoreTextFieldKt.notifyFocusedRect(state, field, offsetMapping);
    }

    private static final void tapToFocus(androidx.compose.foundation.text.LegacyTextFieldState state, FocusRequester focusRequester, boolean allowKeyboard) {
        boolean keyboardController;
        if (!state.getHasFocus()) {
            focusRequester.requestFocus();
        } else {
            keyboardController = state.getKeyboardController();
            if (allowKeyboard && keyboardController != null) {
                keyboardController = state.getKeyboardController();
                if (keyboardController != null) {
                    keyboardController.show();
                }
            }
        }
    }
}
