package androidx.compose.foundation.text.input;

import androidx.compose.foundation.text.UndoManagerKt;
import androidx.compose.foundation.text.input.internal.undo.TextDeleteType;
import androidx.compose.foundation.text.input.internal.undo.TextEditType;
import androidx.compose.foundation.text.input.internal.undo.TextUndoOperation;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0004*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0000\u001a.\u0010\u0008\u001a\u00020\t*\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000c2\u0006\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u0003H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010\u0002\u001a\u00020\u0003*\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0002\u0010\u0005¨\u0006\u0011", d2 = {"TEXT_UNDO_CAPACITY", "", "isNewLineInsert", "", "Landroidx/compose/foundation/text/input/internal/undo/TextUndoOperation;", "(Landroidx/compose/foundation/text/input/internal/undo/TextUndoOperation;)Z", "merge", "next", "recordChanges", "", "Landroidx/compose/foundation/text/input/TextUndoManager;", "pre", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "post", "changes", "Landroidx/compose/foundation/text/input/TextFieldBuffer$ChangeList;", "allowMerge", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TextUndoManagerKt {

    private static final int TEXT_UNDO_CAPACITY = 100;
    private static final boolean isNewLineInsert(TextUndoOperation $this$isNewLineInsert) {
        int i;
        boolean equal;
        String str;
        if (!Intrinsics.areEqual($this$isNewLineInsert.getPostText(), "\n")) {
            if (Intrinsics.areEqual($this$isNewLineInsert.getPostText(), "\r\n")) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    public static final TextUndoOperation merge(TextUndoOperation $this$merge, TextUndoOperation next) {
        boolean canMerge;
        boolean newLineInsert;
        TextEditType textEditType;
        TextEditType textEditType2;
        int cmp;
        TextEditType insert;
        TextEditType deletionType;
        long timeInMillis2;
        int length;
        long timeInMillis;
        int i = 0;
        if ($this$merge.getCanMerge()) {
            if (!next.getCanMerge()) {
            } else {
                if (Long.compare(timeInMillis2, timeInMillis) >= 0) {
                    if (Long.compare(timeInMillis2, timeInMillis) >= 0) {
                    } else {
                        if (!TextUndoManagerKt.isNewLineInsert($this$merge)) {
                            if (TextUndoManagerKt.isNewLineInsert(next)) {
                            } else {
                                if ($this$merge.getTextEditType() != next.getTextEditType()) {
                                    return i;
                                }
                                if ($this$merge.getTextEditType() == TextEditType.Insert && index2 += length2 == next.getIndex()) {
                                    if (index2 += length2 == next.getIndex()) {
                                        StringBuilder stringBuilder3 = new StringBuilder();
                                        TextUndoOperation textUndoOperation3 = new TextUndoOperation($this$merge.getIndex(), "", stringBuilder3.append($this$merge.getPostText()).append(next.getPostText()).toString(), $this$merge.getPreSelection-d9O1mEE(), obj8, next.getPostSelection-d9O1mEE(), obj10, $this$merge.getTimeInMillis(), obj12, 0, 64, 0);
                                        return textUndoOperation3;
                                    }
                                }
                                if ($this$merge.getTextEditType() == TextEditType.Delete && $this$merge.getDeletionType() == next.getDeletionType()) {
                                    if ($this$merge.getDeletionType() == next.getDeletionType()) {
                                        if ($this$merge.getDeletionType() != TextDeleteType.Start) {
                                            if ($this$merge.getDeletionType() == TextDeleteType.End && $this$merge.getIndex() == index3 += length) {
                                                if ($this$merge.getIndex() == index3 += length) {
                                                    StringBuilder stringBuilder2 = new StringBuilder();
                                                    TextUndoOperation textUndoOperation2 = new TextUndoOperation(next.getIndex(), stringBuilder2.append(next.getPreText()).append($this$merge.getPreText()).toString(), "", $this$merge.getPreSelection-d9O1mEE(), obj8, next.getPostSelection-d9O1mEE(), obj10, $this$merge.getTimeInMillis(), obj12, 0, 64, 0);
                                                    return textUndoOperation2;
                                                }
                                                if ($this$merge.getIndex() == next.getIndex()) {
                                                    StringBuilder stringBuilder = new StringBuilder();
                                                    TextUndoOperation textUndoOperation = new TextUndoOperation($this$merge.getIndex(), stringBuilder.append($this$merge.getPreText()).append(next.getPreText()).toString(), "", $this$merge.getPreSelection-d9O1mEE(), obj8, next.getPostSelection-d9O1mEE(), obj10, $this$merge.getTimeInMillis(), obj12, 0, 64, 0);
                                                    return textUndoOperation;
                                                }
                                            }
                                        } else {
                                        }
                                    }
                                }
                            }
                            return i;
                        }
                    }
                    return i;
                }
            }
            return i;
        }
        return i;
    }

    public static final void recordChanges(androidx.compose.foundation.text.input.TextUndoManager $this$recordChanges, androidx.compose.foundation.text.input.TextFieldCharSequence pre, androidx.compose.foundation.text.input.TextFieldCharSequence post, androidx.compose.foundation.text.input.TextFieldBuffer.ChangeList changes, boolean allowMerge) {
        int changeCount;
        int originalRange--jx7JFs;
        TextUndoOperation textUndoOperation;
        int range--jx7JFs;
        String string;
        Object textUndoOperation2;
        long selection-d9O1mEE;
        long substring-FDrldGo;
        long selection-d9O1mEE2;
        boolean selection-d9O1mEE3;
        int i5;
        kotlin.jvm.internal.DefaultConstructorMarker selection-d9O1mEE4;
        int i3;
        int i;
        int i2;
        Object obj3;
        int i4;
        int i6;
        final Object obj = $this$recordChanges;
        final Object obj2 = changes;
        originalRange--jx7JFs = 1;
        if (obj2.getChangeCount() > originalRange--jx7JFs) {
            textUndoOperation = new TextUndoOperation(0, pre.toString(), post.toString(), pre.getSelection-d9O1mEE(), obj9, post.getSelection-d9O1mEE(), obj11, 0, obj13, 0, 32, 0);
            obj.record(textUndoOperation);
        } else {
            if (obj2.getChangeCount() == originalRange--jx7JFs) {
                int i7 = 0;
                originalRange--jx7JFs = obj2.getOriginalRange--jx7JFs(i7);
                range--jx7JFs = obj2.getRange--jx7JFs(i7);
                if (TextRange.getCollapsed-impl(originalRange--jx7JFs)) {
                    if (!TextRange.getCollapsed-impl(range--jx7JFs)) {
                        textUndoOperation2 = new TextUndoOperation(TextRange.getMin-impl(originalRange--jx7JFs), TextRangeKt.substring-FDrldGo((CharSequence)pre, originalRange--jx7JFs), TextRangeKt.substring-FDrldGo((CharSequence)post, range--jx7JFs), pre.getSelection-d9O1mEE(), obj12, post.getSelection-d9O1mEE(), obj14, 0, obj16, allowMerge, 32, 0);
                        obj.record(textUndoOperation2);
                    }
                } else {
                }
            }
        }
    }

    public static void recordChanges$default(androidx.compose.foundation.text.input.TextUndoManager textUndoManager, androidx.compose.foundation.text.input.TextFieldCharSequence textFieldCharSequence2, androidx.compose.foundation.text.input.TextFieldCharSequence textFieldCharSequence3, androidx.compose.foundation.text.input.TextFieldBuffer.ChangeList textFieldBuffer$ChangeList4, boolean z5, int i6, Object object7) {
        int obj4;
        if (i6 &= 8 != 0) {
            obj4 = 1;
        }
        TextUndoManagerKt.recordChanges(textUndoManager, textFieldCharSequence2, textFieldCharSequence3, changeList4, obj4);
    }
}
