package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Rect.Companion;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.CommitTextCommand;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.OffsetMapping.Companion;
import androidx.compose.ui.text.input.SetSelectionCommand;
import androidx.compose.ui.text.input.TextFieldValue;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0000\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ)\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\u0019\u0010\u0014\u001a\u0015\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0015¢\u0006\u0002\u0008\u0016J\u0006\u0010\u0017\u001a\u00020\u0000J\u0006\u0010\u0018\u001a\u00020\u0000J\u0014\u0010\u0019\u001a\u00020\u001a*\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001aH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u000c¨\u0006\u001c", d2 = {"Landroidx/compose/foundation/text/selection/TextFieldPreparedSelection;", "Landroidx/compose/foundation/text/selection/BaseTextPreparedSelection;", "currentValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "layoutResultProxy", "Landroidx/compose/foundation/text/TextLayoutResultProxy;", "state", "Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;", "(Landroidx/compose/ui/text/input/TextFieldValue;Landroidx/compose/ui/text/input/OffsetMapping;Landroidx/compose/foundation/text/TextLayoutResultProxy;Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;)V", "getCurrentValue", "()Landroidx/compose/ui/text/input/TextFieldValue;", "getLayoutResultProxy", "()Landroidx/compose/foundation/text/TextLayoutResultProxy;", "value", "getValue", "deleteIfSelectedOr", "", "Landroidx/compose/ui/text/input/EditCommand;", "or", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "moveCursorDownByPage", "moveCursorUpByPage", "jumpByPagesOffset", "", "pagesAmount", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TextFieldPreparedSelection extends androidx.compose.foundation.text.selection.BaseTextPreparedSelection<androidx.compose.foundation.text.selection.TextFieldPreparedSelection> {

    public static final int $stable = 8;
    private final TextFieldValue currentValue;
    private final TextLayoutResultProxy layoutResultProxy;
    static {
        final int i = 8;
    }

    public TextFieldPreparedSelection(TextFieldValue currentValue, OffsetMapping offsetMapping, TextLayoutResultProxy layoutResultProxy, androidx.compose.foundation.text.selection.TextPreparedSelectionState state) {
        TextLayoutResult value;
        if (layoutResultProxy != null) {
            value = layoutResultProxy.getValue();
        } else {
            value = 0;
        }
        Object obj = this;
        super(currentValue.getAnnotatedString(), currentValue.getSelection-d9O1mEE(), obj3, value, offsetMapping, state, 0);
        obj.currentValue = currentValue;
        obj.layoutResultProxy = layoutResultProxy;
    }

    public TextFieldPreparedSelection(TextFieldValue textFieldValue, OffsetMapping offsetMapping2, TextLayoutResultProxy textLayoutResultProxy3, androidx.compose.foundation.text.selection.TextPreparedSelectionState textPreparedSelectionState4, int i5, DefaultConstructorMarker defaultConstructorMarker6) {
        OffsetMapping obj2;
        androidx.compose.foundation.text.selection.TextPreparedSelectionState obj4;
        if (i5 & 2 != 0) {
            obj2 = OffsetMapping.Companion.getIdentity();
        }
        if (i5 &= 8 != 0) {
            obj4 = new TextPreparedSelectionState();
        }
        super(textFieldValue, obj2, textLayoutResultProxy3, obj4);
    }

    private final int jumpByPagesOffset(TextLayoutResultProxy $this$jumpByPagesOffset, int pagesAmount) {
        Object innerTextFieldCoordinates;
        int i;
        LayoutCoordinates decorationBoxCoordinates;
        int localBoundingBoxOf$default;
        int i2;
        int i3;
        innerTextFieldCoordinates = $this$jumpByPagesOffset.getInnerTextFieldCoordinates();
        if (innerTextFieldCoordinates != null) {
            i = 0;
            decorationBoxCoordinates = $this$jumpByPagesOffset.getDecorationBoxCoordinates();
            if (decorationBoxCoordinates != null) {
                localBoundingBoxOf$default = LayoutCoordinates.localBoundingBoxOf$default(decorationBoxCoordinates, innerTextFieldCoordinates, false, 2, 0);
            }
            if (localBoundingBoxOf$default == 0) {
                localBoundingBoxOf$default = Rect.Companion.getZero();
            }
        } else {
        }
        Rect cursorRect = $this$jumpByPagesOffset.getValue().getCursorRect(getOffsetMapping().originalToTransformed(TextRange.getEnd-impl(this.currentValue.getSelection-d9O1mEE())));
        return getOffsetMapping().transformedToOriginal($this$jumpByPagesOffset.getValue().getOffsetForPosition-k-4lQ0M(OffsetKt.Offset(cursorRect.getLeft(), top += i5)));
    }

    public final List<EditCommand> deleteIfSelectedOr(Function1<? super androidx.compose.foundation.text.selection.TextFieldPreparedSelection, ? extends EditCommand> or) {
        int it;
        long setSelectionCommand;
        int i;
        int min-impl;
        if (TextRange.getCollapsed-impl(getSelection-d9O1mEE())) {
            Object invoke = or.invoke(this);
            if ((EditCommand)invoke != null) {
                setSelectionCommand = 0;
                it = CollectionsKt.listOf((EditCommand)invoke);
            } else {
                it = 0;
            }
        } else {
            EditCommand[] arr = new EditCommand[2];
            int i3 = 0;
            CommitTextCommand commitTextCommand = new CommitTextCommand("", i3);
            arr[i3] = commitTextCommand;
            setSelectionCommand = new SetSelectionCommand(TextRange.getMin-impl(getSelection-d9O1mEE()), TextRange.getMin-impl(getSelection-d9O1mEE()));
            arr[1] = setSelectionCommand;
            it = CollectionsKt.listOf(arr);
        }
        return it;
    }

    @Override // androidx.compose.foundation.text.selection.BaseTextPreparedSelection
    public final TextFieldValue getCurrentValue() {
        return this.currentValue;
    }

    @Override // androidx.compose.foundation.text.selection.BaseTextPreparedSelection
    public final TextLayoutResultProxy getLayoutResultProxy() {
        return this.layoutResultProxy;
    }

    @Override // androidx.compose.foundation.text.selection.BaseTextPreparedSelection
    public final TextFieldValue getValue() {
        return TextFieldValue.copy-3r_uNRQ$default(this.currentValue, getAnnotatedString(), getSelection-d9O1mEE(), obj3, 0, 4);
    }

    @Override // androidx.compose.foundation.text.selection.BaseTextPreparedSelection
    public final androidx.compose.foundation.text.selection.TextFieldPreparedSelection moveCursorDownByPage() {
        int i2;
        int jumpByPagesOffset;
        int i;
        TextLayoutResultProxy layoutResultProxy;
        final int i3 = 0;
        final Object obj2 = this;
        final int i4 = 0;
        jumpByPagesOffset = 1;
        i2 = (CharSequence)(BaseTextPreparedSelection)this.getText$foundation_release().length() > 0 ? jumpByPagesOffset : 0;
        i2 = obj2;
        i = 0;
        layoutResultProxy = i2.layoutResultProxy;
        if (i2 != 0 && layoutResultProxy != null) {
            i2 = obj2;
            i = 0;
            layoutResultProxy = i2.layoutResultProxy;
            if (layoutResultProxy != null) {
                layoutResultProxy = 0;
                i2.setCursor((TextFieldPreparedSelection)(TextFieldPreparedSelection)i2.jumpByPagesOffset(layoutResultProxy, jumpByPagesOffset));
            }
        }
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return (TextFieldPreparedSelection)(BaseTextPreparedSelection)obj2;
    }

    @Override // androidx.compose.foundation.text.selection.BaseTextPreparedSelection
    public final androidx.compose.foundation.text.selection.TextFieldPreparedSelection moveCursorUpByPage() {
        int i3;
        int i;
        TextLayoutResultProxy layoutResultProxy;
        int i2;
        final int i4 = 0;
        final Object obj2 = this;
        final int i5 = 0;
        i3 = (CharSequence)(BaseTextPreparedSelection)this.getText$foundation_release().length() > 0 ? 1 : 0;
        i3 = obj2;
        i = 0;
        layoutResultProxy = i3.layoutResultProxy;
        if (i3 != 0 && layoutResultProxy != null) {
            i3 = obj2;
            i = 0;
            layoutResultProxy = i3.layoutResultProxy;
            if (layoutResultProxy != null) {
                i2 = 0;
                i3.setCursor((TextFieldPreparedSelection)(TextFieldPreparedSelection)i3.jumpByPagesOffset(layoutResultProxy, -1));
            }
        }
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return (TextFieldPreparedSelection)(BaseTextPreparedSelection)obj2;
    }
}
