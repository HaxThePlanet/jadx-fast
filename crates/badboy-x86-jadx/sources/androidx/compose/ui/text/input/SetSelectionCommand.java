package androidx.compose.ui.text.input;

import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0008\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000cH\u0016J\u0013\u0010\r\u001a\u00020\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\u0008\u0010\u0011\u001a\u00020\u0003H\u0016J\u0008\u0010\u0012\u001a\u00020\u0013H\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0007¨\u0006\u0014", d2 = {"Landroidx/compose/ui/text/input/SetSelectionCommand;", "Landroidx/compose/ui/text/input/EditCommand;", "start", "", "end", "(II)V", "getEnd", "()I", "getStart", "applyTo", "", "buffer", "Landroidx/compose/ui/text/input/EditingBuffer;", "equals", "", "other", "", "hashCode", "toString", "", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SetSelectionCommand implements androidx.compose.ui.text.input.EditCommand {

    public static final int $stable;
    private final int end;
    private final int start;
    static {
    }

    public SetSelectionCommand(int start, int end) {
        super();
        this.start = start;
        this.end = end;
    }

    @Override // androidx.compose.ui.text.input.EditCommand
    public void applyTo(androidx.compose.ui.text.input.EditingBuffer buffer) {
        final int i = 0;
        int coerceIn = RangesKt.coerceIn(this.start, i, buffer.getLength$ui_text_release());
        int coerceIn2 = RangesKt.coerceIn(this.end, i, buffer.getLength$ui_text_release());
        if (coerceIn < coerceIn2) {
            buffer.setSelection$ui_text_release(coerceIn, coerceIn2);
        } else {
            buffer.setSelection$ui_text_release(coerceIn2, coerceIn);
        }
    }

    @Override // androidx.compose.ui.text.input.EditCommand
    public boolean equals(Object other) {
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (!other instanceof SetSelectionCommand) {
            return i2;
        }
        if (this.start != obj.start) {
            return i2;
        }
        if (this.end != obj2.end) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.ui.text.input.EditCommand
    public final int getEnd() {
        return this.end;
    }

    @Override // androidx.compose.ui.text.input.EditCommand
    public final int getStart() {
        return this.start;
    }

    @Override // androidx.compose.ui.text.input.EditCommand
    public int hashCode() {
        return i += end;
    }

    @Override // androidx.compose.ui.text.input.EditCommand
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("SetSelectionCommand(start=").append(this.start).append(", end=").append(this.end).append(')').toString();
    }
}
