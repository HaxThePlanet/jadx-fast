package androidx.compose.ui.text;

import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008\u0001\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0007\u001a\u00020\u00082\u0008\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0008\u0010\n\u001a\u00020\u000bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u000c", d2 = {"Landroidx/compose/ui/text/CacheTextLayoutInput;", "", "textLayoutInput", "Landroidx/compose/ui/text/TextLayoutInput;", "(Landroidx/compose/ui/text/TextLayoutInput;)V", "getTextLayoutInput", "()Landroidx/compose/ui/text/TextLayoutInput;", "equals", "", "other", "hashCode", "", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CacheTextLayoutInput {

    public static final int $stable;
    private final androidx.compose.ui.text.TextLayoutInput textLayoutInput;
    static {
    }

    public CacheTextLayoutInput(androidx.compose.ui.text.TextLayoutInput textLayoutInput) {
        super();
        this.textLayoutInput = textLayoutInput;
    }

    public boolean equals(Object other) {
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (!other instanceof CacheTextLayoutInput) {
            return i2;
        }
        androidx.compose.ui.text.TextLayoutInput textLayoutInput = this.textLayoutInput;
        final int i3 = 0;
        if (!Intrinsics.areEqual(textLayoutInput.getText(), obj.textLayoutInput.getText())) {
            return i2;
        }
        if (!textLayoutInput.getStyle().hasSameLayoutAffectingAttributes(obj2.textLayoutInput.getStyle())) {
            return i2;
        }
        if (!Intrinsics.areEqual(textLayoutInput.getPlaceholders(), obj3.textLayoutInput.getPlaceholders())) {
            return i2;
        }
        if (textLayoutInput.getMaxLines() != obj4.textLayoutInput.getMaxLines()) {
            return i2;
        }
        if (textLayoutInput.getSoftWrap() != obj5.textLayoutInput.getSoftWrap()) {
            return i2;
        }
        if (!TextOverflow.equals-impl0(textLayoutInput.getOverflow-gIe3tQ8(), obj6.textLayoutInput.getOverflow-gIe3tQ8())) {
            return i2;
        }
        if (!Intrinsics.areEqual(textLayoutInput.getDensity(), obj7.textLayoutInput.getDensity())) {
            return i2;
        }
        if (textLayoutInput.getLayoutDirection() != obj8.textLayoutInput.getLayoutDirection()) {
            return i2;
        }
        androidx.compose.ui.text.font.FontFamily.Resolver fontFamilyResolver2 = obj9.textLayoutInput.getFontFamilyResolver();
        if (textLayoutInput.getFontFamilyResolver() != fontFamilyResolver2) {
            return i2;
        }
        int maxWidth-impl2 = Constraints.getMaxWidth-impl(obj10.textLayoutInput.getConstraints-msEJaDk());
        if (Constraints.getMaxWidth-impl(textLayoutInput.getConstraints-msEJaDk()) != maxWidth-impl2) {
            return i2;
        }
        if (Constraints.getMaxHeight-impl(textLayoutInput.getConstraints-msEJaDk()) != Constraints.getMaxHeight-impl(obj11.textLayoutInput.getConstraints-msEJaDk())) {
            return i2;
        }
        return i;
    }

    public final androidx.compose.ui.text.TextLayoutInput getTextLayoutInput() {
        return this.textLayoutInput;
    }

    public int hashCode() {
        final androidx.compose.ui.text.TextLayoutInput textLayoutInput = this.textLayoutInput;
        final int i = 0;
        return result5 += i22;
    }
}
