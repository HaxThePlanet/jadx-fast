package androidx.compose.ui.text.input;

import androidx.compose.ui.text.AnnotatedString;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000c\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\u0008\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0007\u001a\u00020\u00082\u0008\u0010\t\u001a\u0004\u0018\u00010\nH\u0096\u0002J\u0010\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0008\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0011", d2 = {"Landroidx/compose/ui/text/input/PasswordVisualTransformation;", "Landroidx/compose/ui/text/input/VisualTransformation;", "mask", "", "(C)V", "getMask", "()C", "equals", "", "other", "", "filter", "Landroidx/compose/ui/text/input/TransformedText;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "hashCode", "", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PasswordVisualTransformation implements androidx.compose.ui.text.input.VisualTransformation {

    public static final int $stable;
    private final char mask;
    static {
    }

    public PasswordVisualTransformation() {
        super(0, 1, 0);
    }

    public PasswordVisualTransformation(char mask) {
        super();
        this.mask = mask;
    }

    public PasswordVisualTransformation(char c, int i2, DefaultConstructorMarker defaultConstructorMarker3) {
        int obj1;
        obj1 = i2 &= 1 != 0 ? 8226 : obj1;
        super(obj1);
    }

    @Override // androidx.compose.ui.text.input.VisualTransformation
    public boolean equals(Object other) {
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (!other instanceof PasswordVisualTransformation) {
            return i2;
        }
        if (this.mask != obj.mask) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.ui.text.input.VisualTransformation
    public androidx.compose.ui.text.input.TransformedText filter(AnnotatedString text) {
        AnnotatedString annotatedString = new AnnotatedString(StringsKt.repeat((CharSequence)String.valueOf(this.mask), text.getText().length()), 0, 0, 6, 0);
        TransformedText transformedText = new TransformedText(annotatedString, OffsetMapping.Companion.getIdentity());
        return transformedText;
    }

    @Override // androidx.compose.ui.text.input.VisualTransformation
    public final char getMask() {
        return this.mask;
    }

    @Override // androidx.compose.ui.text.input.VisualTransformation
    public int hashCode() {
        return Character.hashCode(this.mask);
    }
}
