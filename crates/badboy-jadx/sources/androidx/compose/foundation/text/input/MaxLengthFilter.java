package androidx.compose.foundation.text.input;

import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0082\u0008\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0005\u001a\u00020\u0003HÂ\u0003J\u0013\u0010\u0006\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0007\u001a\u00020\u00082\u0008\u0010\t\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÖ\u0001J\u0008\u0010\u000c\u001a\u00020\rH\u0016J\u000c\u0010\u000e\u001a\u00020\u000f*\u00020\u0010H\u0016J\u000c\u0010\u0011\u001a\u00020\u000f*\u00020\u0012H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013", d2 = {"Landroidx/compose/foundation/text/input/MaxLengthFilter;", "Landroidx/compose/foundation/text/input/InputTransformation;", "maxLength", "", "(I)V", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "applySemantics", "", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "transformInput", "Landroidx/compose/foundation/text/input/TextFieldBuffer;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class MaxLengthFilter implements androidx.compose.foundation.text.input.InputTransformation {

    private final int maxLength;
    public MaxLengthFilter(int maxLength) {
        int i;
        super();
        this.maxLength = maxLength;
        i = this.maxLength >= 0 ? 1 : 0;
        if (i == 0) {
        } else {
        }
        int i2 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("maxLength must be at least zero, was ").append(this.maxLength).toString().toString());
        throw illegalArgumentException;
    }

    private final int component1() {
        return this.maxLength;
    }

    public static androidx.compose.foundation.text.input.MaxLengthFilter copy$default(androidx.compose.foundation.text.input.MaxLengthFilter maxLengthFilter, int i2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = maxLengthFilter.maxLength;
        }
        return maxLengthFilter.copy(obj1);
    }

    @Override // androidx.compose.foundation.text.input.InputTransformation
    public void applySemantics(SemanticsPropertyReceiver $this$applySemantics) {
        SemanticsPropertiesKt.setMaxTextLength($this$applySemantics, this.maxLength);
    }

    @Override // androidx.compose.foundation.text.input.InputTransformation
    public final androidx.compose.foundation.text.input.MaxLengthFilter copy(int i) {
        MaxLengthFilter maxLengthFilter = new MaxLengthFilter(i);
        return maxLengthFilter;
    }

    @Override // androidx.compose.foundation.text.input.InputTransformation
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof MaxLengthFilter) {
            return i2;
        }
        if (this.maxLength != obj.maxLength) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.foundation.text.input.InputTransformation
    public int hashCode() {
        return Integer.hashCode(this.maxLength);
    }

    @Override // androidx.compose.foundation.text.input.InputTransformation
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("InputTransformation.maxLength(").append(this.maxLength).append(')').toString();
    }

    @Override // androidx.compose.foundation.text.input.InputTransformation
    public void transformInput(androidx.compose.foundation.text.input.TextFieldBuffer $this$transformInput) {
        if ($this$transformInput.getLength() > this.maxLength) {
            $this$transformInput.revertAllChanges();
        }
    }
}
