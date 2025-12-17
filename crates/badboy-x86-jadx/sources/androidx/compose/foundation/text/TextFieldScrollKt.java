package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Rect.Companion;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000R\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a6\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0002\u001a4\u0010\u000c\u001a\u00020\r*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u000e\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0015H\u0000\u001a*\u0010\u0017\u001a\u00020\r*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\n\u0008\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0008\u0008\u0002\u0010\u001a\u001a\u00020\nH\u0000¨\u0006\u001b", d2 = {"getCursorRectInScroller", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/Density;", "cursorOffset", "", "transformedText", "Landroidx/compose/ui/text/input/TransformedText;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "rtl", "", "textFieldWidth", "textFieldScroll", "Landroidx/compose/ui/Modifier;", "scrollerPosition", "Landroidx/compose/foundation/text/TextFieldScrollerPosition;", "textFieldValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "textLayoutResultProvider", "Lkotlin/Function0;", "Landroidx/compose/foundation/text/TextLayoutResultProxy;", "textFieldScrollable", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "enabled", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TextFieldScrollKt {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int ordinal;
            int ordinal2;
            int[] iArr = new int[values.length];
            iArr[Orientation.Vertical.ordinal()] = 1;
            iArr[Orientation.Horizontal.ordinal()] = 2;
            TextFieldScrollKt.WhenMappings.$EnumSwitchMapping$0 = iArr;
        }
    }
    public static final Rect access$getCursorRectInScroller(Density $receiver, int cursorOffset, TransformedText transformedText, TextLayoutResult textLayoutResult, boolean rtl, int textFieldWidth) {
        return TextFieldScrollKt.getCursorRectInScroller($receiver, cursorOffset, transformedText, textLayoutResult, rtl, textFieldWidth);
    }

    private static final Rect getCursorRectInScroller(Density $this$getCursorRectInScroller, int cursorOffset, TransformedText transformedText, TextLayoutResult textLayoutResult, boolean rtl, int textFieldWidth) {
        Rect cursorRect;
        float left;
        float f;
        int i2;
        int i;
        if (textLayoutResult != null) {
            if (textLayoutResult.getCursorRect(transformedText.getOffsetMapping().originalToTransformed(cursorOffset)) == null) {
                cursorRect = Rect.Companion.getZero();
            }
        } else {
        }
        final Rect rect = cursorRect;
        int roundToPx-0680j_4 = $this$getCursorRectInScroller.roundToPx-0680j_4(TextFieldCursorKt.getDefaultCursorThickness());
        if (rtl) {
            i3 -= f;
        } else {
            left = rect.getLeft();
        }
        if (rtl) {
            i = i2;
        } else {
            i = i2;
        }
        return Rect.copy$default(rect, left, 0, i, 0, 10, 0);
    }

    public static final Modifier textFieldScroll(Modifier $this$textFieldScroll, androidx.compose.foundation.text.TextFieldScrollerPosition scrollerPosition, TextFieldValue textFieldValue, VisualTransformation visualTransformation, Function0<androidx.compose.foundation.text.TextLayoutResultProxy> textLayoutResultProvider) {
        Object verticalScrollLayoutModifier;
        int offsetToFollow-5zc-tL8 = scrollerPosition.getOffsetToFollow-5zc-tL8(textFieldValue.getSelection-d9O1mEE());
        scrollerPosition.setPreviousSelection-5zc-tL8(textFieldValue.getSelection-d9O1mEE());
        TransformedText filterWithValidation = ValidatingOffsetMappingKt.filterWithValidation(visualTransformation, textFieldValue.getAnnotatedString());
        switch (i) {
            case 1:
                verticalScrollLayoutModifier = new VerticalScrollLayoutModifier(scrollerPosition, offsetToFollow-5zc-tL8, filterWithValidation, textLayoutResultProvider);
                break;
            case 2:
                verticalScrollLayoutModifier = new HorizontalScrollLayoutModifier(scrollerPosition, offsetToFollow-5zc-tL8, filterWithValidation, textLayoutResultProvider);
                break;
            default:
                NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException;
        }
        return ClipKt.clipToBounds($this$textFieldScroll).then((Modifier)verticalScrollLayoutModifier);
    }

    public static final Modifier textFieldScrollable(Modifier $this$textFieldScrollable, androidx.compose.foundation.text.TextFieldScrollerPosition scrollerPosition, MutableInteractionSource interactionSource, boolean enabled) {
        kotlin.jvm.functions.Function1 noInspectorInfo;
        int i = 0;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            noInspectorInfo = new TextFieldScrollKt.textFieldScrollable$$inlined.debugInspectorInfo.1(scrollerPosition, interactionSource, enabled);
        } else {
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        TextFieldScrollKt.textFieldScrollable.2 $i$f$debugInspectorInfo = new TextFieldScrollKt.textFieldScrollable.2(scrollerPosition, enabled, interactionSource);
        return ComposedModifierKt.composed($this$textFieldScrollable, noInspectorInfo, (Function3)$i$f$debugInspectorInfo);
    }

    public static Modifier textFieldScrollable$default(Modifier modifier, androidx.compose.foundation.text.TextFieldScrollerPosition textFieldScrollerPosition2, MutableInteractionSource mutableInteractionSource3, boolean z4, int i5, Object object6) {
        int obj2;
        int obj3;
        if (i5 & 2 != 0) {
            obj2 = 0;
        }
        if (i5 &= 4 != 0) {
            obj3 = 1;
        }
        return TextFieldScrollKt.textFieldScrollable(modifier, textFieldScrollerPosition2, obj2, obj3);
    }
}
