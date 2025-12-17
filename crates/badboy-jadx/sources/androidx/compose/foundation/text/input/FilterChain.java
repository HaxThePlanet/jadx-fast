package androidx.compose.foundation.text.input;

import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0002\u0010\u0004J\u0013\u0010\t\u001a\u00020\n2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000cH\u0096\u0002J\u0008\u0010\r\u001a\u00020\u000eH\u0016J\u0008\u0010\u000f\u001a\u00020\u0010H\u0016J\u000c\u0010\u0011\u001a\u00020\u0012*\u00020\u0013H\u0016J\u000c\u0010\u0014\u001a\u00020\u0012*\u00020\u0015H\u0016R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u000e\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016", d2 = {"Landroidx/compose/foundation/text/input/FilterChain;", "Landroidx/compose/foundation/text/input/InputTransformation;", "first", "second", "(Landroidx/compose/foundation/text/input/InputTransformation;Landroidx/compose/foundation/text/input/InputTransformation;)V", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "getKeyboardOptions", "()Landroidx/compose/foundation/text/KeyboardOptions;", "equals", "", "other", "", "hashCode", "", "toString", "", "applySemantics", "", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "transformInput", "Landroidx/compose/foundation/text/input/TextFieldBuffer;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class FilterChain implements androidx.compose.foundation.text.input.InputTransformation {

    private final androidx.compose.foundation.text.input.InputTransformation first;
    private final androidx.compose.foundation.text.input.InputTransformation second;
    public FilterChain(androidx.compose.foundation.text.input.InputTransformation first, androidx.compose.foundation.text.input.InputTransformation second) {
        super();
        this.first = first;
        this.second = second;
    }

    @Override // androidx.compose.foundation.text.input.InputTransformation
    public void applySemantics(SemanticsPropertyReceiver $this$applySemantics) {
        int i = 0;
        this.first.applySemantics($this$applySemantics);
        int i2 = 0;
        this.second.applySemantics($this$applySemantics);
    }

    @Override // androidx.compose.foundation.text.input.InputTransformation
    public boolean equals(Object other) {
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (other == null) {
            return i2;
        }
        if (getClass() != other.getClass()) {
            return i2;
        }
        Object obj = other;
        if (!Intrinsics.areEqual(this.first, obj2.first)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.second, obj3.second)) {
            return i2;
        }
        if (!Intrinsics.areEqual(getKeyboardOptions(), (FilterChain)other.getKeyboardOptions())) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.foundation.text.input.InputTransformation
    public KeyboardOptions getKeyboardOptions() {
        KeyboardOptions fillUnspecifiedValuesWith$foundation_release;
        KeyboardOptions keyboardOptions;
        fillUnspecifiedValuesWith$foundation_release = this.second.getKeyboardOptions();
        if (fillUnspecifiedValuesWith$foundation_release != null) {
            if (fillUnspecifiedValuesWith$foundation_release.fillUnspecifiedValuesWith$foundation_release(this.first.getKeyboardOptions()) == null) {
                fillUnspecifiedValuesWith$foundation_release = this.first.getKeyboardOptions();
            }
        } else {
        }
        return fillUnspecifiedValuesWith$foundation_release;
    }

    @Override // androidx.compose.foundation.text.input.InputTransformation
    public int hashCode() {
        int i;
        KeyboardOptions keyboardOptions = getKeyboardOptions();
        if (keyboardOptions != null) {
            i = keyboardOptions.hashCode();
        } else {
            i = 0;
        }
        return result += i;
    }

    @Override // androidx.compose.foundation.text.input.InputTransformation
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(this.first).append(".then(").append(this.second).append(')').toString();
    }

    @Override // androidx.compose.foundation.text.input.InputTransformation
    public void transformInput(androidx.compose.foundation.text.input.TextFieldBuffer $this$transformInput) {
        int i = 0;
        this.first.transformInput($this$transformInput);
        int i2 = 0;
        this.second.transformInput($this$transformInput);
    }
}
