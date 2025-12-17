package androidx.compose.foundation.text.input.internal.undo;

import androidx.compose.foundation.text.UndoManager_jvmKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.text.TextRange;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0000\u0018\u0000 #2\u00020\u0001:\u0001#BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\u0008\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b\u0012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r¢\u0006\u0002\u0010\u000eR\u0011\u0010\u000c\u001a\u00020\r¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016R\u0019\u0010\t\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\u0008\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u001bR\u0019\u0010\u0007\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\u0008\u001c\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u001bR\u0011\u0010\u001e\u001a\u00020\u001f¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010!R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008\"\u0010\u0018\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006$", d2 = {"Landroidx/compose/foundation/text/input/internal/undo/TextUndoOperation;", "", "index", "", "preText", "", "postText", "preSelection", "Landroidx/compose/ui/text/TextRange;", "postSelection", "timeInMillis", "", "canMerge", "", "(ILjava/lang/String;Ljava/lang/String;JJJZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCanMerge", "()Z", "deletionType", "Landroidx/compose/foundation/text/input/internal/undo/TextDeleteType;", "getDeletionType", "()Landroidx/compose/foundation/text/input/internal/undo/TextDeleteType;", "getIndex", "()I", "getPostSelection-d9O1mEE", "()J", "J", "getPostText", "()Ljava/lang/String;", "getPreSelection-d9O1mEE", "getPreText", "textEditType", "Landroidx/compose/foundation/text/input/internal/undo/TextEditType;", "getTextEditType", "()Landroidx/compose/foundation/text/input/internal/undo/TextEditType;", "getTimeInMillis", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TextUndoOperation {

    public static final int $stable;
    public static final androidx.compose.foundation.text.input.internal.undo.TextUndoOperation.Companion Companion;
    private static final Saver<androidx.compose.foundation.text.input.internal.undo.TextUndoOperation, Object> Saver;
    private final boolean canMerge;
    private final int index;
    private final long postSelection;
    private final String postText;
    private final long preSelection;
    private final String preText;
    private final androidx.compose.foundation.text.input.internal.undo.TextEditType textEditType;
    private final long timeInMillis;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"Landroidx/compose/foundation/text/input/internal/undo/TextUndoOperation$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/text/input/internal/undo/TextUndoOperation;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final Saver<androidx.compose.foundation.text.input.internal.undo.TextUndoOperation, Object> getSaver() {
            return TextUndoOperation.access$getSaver$cp();
        }
    }
    static {
        TextUndoOperation.Companion companion = new TextUndoOperation.Companion(0);
        TextUndoOperation.Companion = companion;
        TextUndoOperation.Companion.Saver.1 anon = new TextUndoOperation.Companion.Saver.1();
        TextUndoOperation.Saver = (Saver)anon;
    }

    private TextUndoOperation(int index, String preText, String postText, long preSelection, long postSelection, long timeInMillis, boolean canMerge) {
        int i2;
        int i;
        androidx.compose.foundation.text.input.internal.undo.TextEditType replace;
        int length;
        int i3;
        super();
        this.index = index;
        this.preText = preText;
        this.postText = postText;
        this.preSelection = preSelection;
        this.postSelection = timeInMillis;
        this.timeInMillis = obj11;
        this.canMerge = obj13;
        i3 = 1;
        final int i4 = 0;
        i2 = (CharSequence)this.preText.length() == 0 ? i3 : i4;
        if (i2 != 0) {
            i2 = (CharSequence)this.postText.length() == 0 ? i3 : i4;
            if (i2 != 0) {
            } else {
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Either pre or post text must not be empty");
            throw illegalArgumentException;
        }
        i = (CharSequence)this.preText.length() == 0 ? i3 : i4;
        if (i != 0) {
            i = (CharSequence)this.postText.length() > 0 ? i3 : i4;
            if (i != 0) {
                replace = TextEditType.Insert;
            } else {
                length = (CharSequence)this.preText.length() > 0 ? i3 : i4;
                if (length != 0) {
                    if ((CharSequence)this.postText.length() == 0) {
                    } else {
                        i3 = i4;
                    }
                    replace = i3 != 0 ? TextEditType.Delete : TextEditType.Replace;
                } else {
                }
            }
        } else {
        }
        this.textEditType = replace;
    }

    public TextUndoOperation(int i, String string2, String string3, long l4, long l5, long l6, boolean z7, int i8, DefaultConstructorMarker defaultConstructorMarker9) {
        long timeNowMillis;
        int i2;
        long l;
        int i3;
        if (obj25 & 32 != 0) {
            l = timeNowMillis;
        } else {
            l = i8;
        }
        i3 = obj25 & 64 != 0 ? i2 : obj24;
        super(i, string2, string3, l4, obj7, l6, obj9, l, obj11, i3, 0);
    }

    public TextUndoOperation(int i, String string2, String string3, long l4, long l5, long l6, boolean z7, DefaultConstructorMarker defaultConstructorMarker8) {
        super(i, string2, string3, l4, l5, l6, z7, defaultConstructorMarker8, obj9, obj10);
    }

    public static final Saver access$getSaver$cp() {
        return TextUndoOperation.Saver;
    }

    public final boolean getCanMerge() {
        return this.canMerge;
    }

    public final androidx.compose.foundation.text.input.internal.undo.TextDeleteType getDeletionType() {
        int start-impl;
        androidx.compose.foundation.text.input.internal.undo.TextDeleteType start;
        int start-impl2;
        androidx.compose.foundation.text.input.internal.undo.TextEditType delete = TextEditType.Delete;
        if (this.textEditType != delete) {
            return TextDeleteType.NotByUser;
        }
        if (!TextRange.getCollapsed-impl(this.postSelection)) {
            return TextDeleteType.NotByUser;
        }
        if (TextRange.getCollapsed-impl(this.preSelection)) {
            start = TextRange.getStart-impl(this.preSelection) > TextRange.getStart-impl(this.postSelection) ? TextDeleteType.Start : TextDeleteType.End;
            return start;
        }
        start-impl2 = TextRange.getStart-impl(this.postSelection);
        if (TextRange.getStart-impl(this.preSelection) == start-impl2 && TextRange.getStart-impl(this.preSelection) == this.index) {
            if (TextRange.getStart-impl(this.preSelection) == this.index) {
                return TextDeleteType.Inner;
            }
        }
        return TextDeleteType.NotByUser;
    }

    public final int getIndex() {
        return this.index;
    }

    public final long getPostSelection-d9O1mEE() {
        return this.postSelection;
    }

    public final String getPostText() {
        return this.postText;
    }

    public final long getPreSelection-d9O1mEE() {
        return this.preSelection;
    }

    public final String getPreText() {
        return this.preText;
    }

    public final androidx.compose.foundation.text.input.internal.undo.TextEditType getTextEditType() {
        return this.textEditType;
    }

    public final long getTimeInMillis() {
        return this.timeInMillis;
    }
}
