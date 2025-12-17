package androidx.compose.foundation.text.input;

import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.ui.text.StringKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.KeyboardCapitalization;
import androidx.compose.ui.text.input.KeyboardCapitalization.Companion;
import androidx.compose.ui.text.intl.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0082\u0008\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\t\u001a\u00020\u0003HÂ\u0003J\u0013\u0010\n\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\u000c2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0008\u0010\u0011\u001a\u00020\u0012H\u0016J\u000c\u0010\u0013\u001a\u00020\u0014*\u00020\u0015H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016", d2 = {"Landroidx/compose/foundation/text/input/AllCapsTransformation;", "Landroidx/compose/foundation/text/input/InputTransformation;", "locale", "Landroidx/compose/ui/text/intl/Locale;", "(Landroidx/compose/ui/text/intl/Locale;)V", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "getKeyboardOptions", "()Landroidx/compose/foundation/text/KeyboardOptions;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "transformInput", "", "Landroidx/compose/foundation/text/input/TextFieldBuffer;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class AllCapsTransformation implements androidx.compose.foundation.text.input.InputTransformation {

    private final KeyboardOptions keyboardOptions;
    private final Locale locale;
    public AllCapsTransformation(Locale locale) {
        super();
        this.locale = locale;
        KeyboardOptions keyboardOptions = new KeyboardOptions(KeyboardCapitalization.Companion.getCharacters-IUNYP9k(), 0, 0, 0, 0, 0, 0, 126, 0);
        this.keyboardOptions = keyboardOptions;
    }

    private final Locale component1() {
        return this.locale;
    }

    public static androidx.compose.foundation.text.input.AllCapsTransformation copy$default(androidx.compose.foundation.text.input.AllCapsTransformation allCapsTransformation, Locale locale2, int i3, Object object4) {
        Locale obj1;
        if (i3 &= 1 != 0) {
            obj1 = allCapsTransformation.locale;
        }
        return allCapsTransformation.copy(obj1);
    }

    @Override // androidx.compose.foundation.text.input.InputTransformation
    public final androidx.compose.foundation.text.input.AllCapsTransformation copy(Locale locale) {
        AllCapsTransformation allCapsTransformation = new AllCapsTransformation(locale);
        return allCapsTransformation;
    }

    @Override // androidx.compose.foundation.text.input.InputTransformation
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof AllCapsTransformation) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.locale, obj.locale)) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.foundation.text.input.InputTransformation
    public KeyboardOptions getKeyboardOptions() {
        return this.keyboardOptions;
    }

    @Override // androidx.compose.foundation.text.input.InputTransformation
    public int hashCode() {
        return this.locale.hashCode();
    }

    @Override // androidx.compose.foundation.text.input.InputTransformation
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("InputTransformation.allCaps(locale=").append(this.locale).append(')').toString();
    }

    @Override // androidx.compose.foundation.text.input.InputTransformation
    public void transformInput(androidx.compose.foundation.text.input.TextFieldBuffer $this$transformInput) {
        int i$iv;
        long range--jx7JFs;
        int i;
        boolean collapsed-impl;
        int max-impl;
        String upperCase;
        Locale locale;
        final androidx.compose.foundation.text.input.TextFieldBuffer.ChangeList changes = $this$transformInput.getChanges();
        final int i2 = 0;
        i$iv = 0;
        while (i$iv < changes.getChangeCount()) {
            range--jx7JFs = changes.getRange--jx7JFs(i$iv);
            changes.getOriginalRange--jx7JFs(i$iv);
            i = 0;
            if (!TextRange.getCollapsed-impl(range--jx7JFs)) {
            }
            i$iv++;
            $this$transformInput.replace(TextRange.getMin-impl(range--jx7JFs), TextRange.getMax-impl(range--jx7JFs), (CharSequence)StringKt.toUpperCase(TextRangeKt.substring-FDrldGo($this$transformInput.asCharSequence(), range--jx7JFs), this.locale));
        }
    }
}
