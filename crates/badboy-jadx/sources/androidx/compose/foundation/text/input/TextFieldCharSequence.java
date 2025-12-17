package androidx.compose.foundation.text.input;

import androidx.compose.foundation.text.input.internal.ToCharArray_androidKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRange.Companion;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0002\u0008\u0008\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000c\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0019\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0000\u0008\u0000\u0018\u00002\u00020\u0001B=\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0001\u0012\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0016\u0008\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0001J\u0013\u0010\u001a\u001a\u00020\u00182\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u001bH\u0096\u0002J\u0011\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u000fH\u0096\u0002J\u0008\u0010\u001f\u001a\u00020\u000fH\u0016J\u0006\u0010 \u001a\u00020\u0018J\u0018\u0010!\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u000fH\u0016J&\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020\u000fJ\u0008\u0010+\u001a\u00020,H\u0016R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u001f\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u0011R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\u0008\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006-", d2 = {"Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "", "text", "selection", "Landroidx/compose/ui/text/TextRange;", "composition", "highlight", "Lkotlin/Pair;", "Landroidx/compose/foundation/text/input/TextHighlightType;", "(Ljava/lang/CharSequence;JLandroidx/compose/ui/text/TextRange;Lkotlin/Pair;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getComposition-MzsxiRA", "()Landroidx/compose/ui/text/TextRange;", "getHighlight", "()Lkotlin/Pair;", "length", "", "getLength", "()I", "getSelection-d9O1mEE", "()J", "J", "getText", "()Ljava/lang/CharSequence;", "contentEquals", "", "other", "equals", "", "get", "", "index", "hashCode", "shouldShowSelection", "subSequence", "startIndex", "endIndex", "toCharArray", "", "destination", "", "destinationOffset", "sourceStartIndex", "sourceEndIndex", "toString", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TextFieldCharSequence implements java.lang.CharSequence {

    public static final int $stable = 8;
    private final TextRange composition;
    private final Pair<androidx.compose.foundation.text.input.TextHighlightType, TextRange> highlight;
    private final long selection;
    private final java.lang.CharSequence text;
    static {
        final int i = 8;
    }

    private TextFieldCharSequence(java.lang.CharSequence text, long selection, TextRange composition, Pair<androidx.compose.foundation.text.input.TextHighlightType, TextRange> highlight) {
        Object text2;
        int copy$default;
        int box-impl2;
        int box-impl;
        int length;
        super();
        if (text instanceof TextFieldCharSequence) {
            text2 = obj.text;
        } else {
            text2 = text;
        }
        this.text = text2;
        box-impl2 = 0;
        this.selection = TextRangeKt.coerceIn-8ffj60Q(selection, composition, box-impl2);
        copy$default = 0;
        if (highlight != null) {
            box-impl = TextRange.box-impl(TextRangeKt.coerceIn-8ffj60Q(highlight.unbox-impl(), obj3, box-impl2));
        } else {
            box-impl = copy$default;
        }
        this.composition = box-impl;
        if (obj10 != null) {
            long unbox-impl = (TextRange)obj10.getSecond().unbox-impl();
            copy$default = Pair.copy$default(obj10, copy$default, TextRange.box-impl(TextRangeKt.coerceIn-8ffj60Q(unbox-impl, obj3, box-impl2)), 1, copy$default);
        }
        this.highlight = copy$default;
    }

    public TextFieldCharSequence(java.lang.CharSequence charSequence, long l2, TextRange textRange3, Pair pair4, int i5, DefaultConstructorMarker defaultConstructorMarker6) {
        String str;
        long l;
        int i;
        int i2;
        String obj8;
        long obj9;
        if (defaultConstructorMarker6 & 1 != 0) {
            str = obj8;
        } else {
            str = charSequence;
        }
        if (defaultConstructorMarker6 & 2 != 0) {
            l = obj9;
        } else {
            l = l2;
        }
        obj9 = 0;
        i = defaultConstructorMarker6 & 4 != 0 ? obj9 : pair4;
        i2 = defaultConstructorMarker6 & 8 != 0 ? obj9 : i5;
        super(str, l, obj3, i, i2, 0);
    }

    public TextFieldCharSequence(java.lang.CharSequence charSequence, long l2, TextRange textRange3, Pair pair4, DefaultConstructorMarker defaultConstructorMarker5) {
        super(charSequence, l2, textRange3, pair4, defaultConstructorMarker5);
    }

    @Override // java.lang.CharSequence
    public final char charAt(int index) {
        return get(index);
    }

    @Override // java.lang.CharSequence
    public final boolean contentEquals(java.lang.CharSequence other) {
        return StringsKt.contentEquals(this.text, other);
    }

    @Override // java.lang.CharSequence
    public boolean equals(Object other) {
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (other == null) {
            return i2;
        }
        Class class2 = other.getClass();
        if (getClass() != class2) {
            return i2;
        }
        Object obj = other;
        if (!TextRange.equals-impl0(this.selection, class2)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.composition, obj3.composition)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.highlight, obj4.highlight)) {
            return i2;
        }
        if (!contentEquals(obj2.text)) {
            return i2;
        }
        return i;
    }

    @Override // java.lang.CharSequence
    public char get(int index) {
        return this.text.charAt(index);
    }

    @Override // java.lang.CharSequence
    public final TextRange getComposition-MzsxiRA() {
        return this.composition;
    }

    public final Pair<androidx.compose.foundation.text.input.TextHighlightType, TextRange> getHighlight() {
        return this.highlight;
    }

    @Override // java.lang.CharSequence
    public int getLength() {
        return this.text.length();
    }

    @Override // java.lang.CharSequence
    public final long getSelection-d9O1mEE() {
        return this.selection;
    }

    @Override // java.lang.CharSequence
    public final java.lang.CharSequence getText() {
        return this.text;
    }

    @Override // java.lang.CharSequence
    public int hashCode() {
        int i;
        int i2;
        long unbox-impl;
        TextRange composition = this.composition;
        if (composition != null) {
            i = TextRange.hashCode-impl(composition.unbox-impl());
        } else {
            i = i2;
        }
        Pair highlight = this.highlight;
        if (highlight != null) {
            i2 = highlight.hashCode();
        }
        return result2 += i2;
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return getLength();
    }

    @Override // java.lang.CharSequence
    public final boolean shouldShowSelection() {
        int i;
        i = this.highlight == null ? 1 : 0;
        return i;
    }

    @Override // java.lang.CharSequence
    public java.lang.CharSequence subSequence(int startIndex, int endIndex) {
        return this.text.subSequence(startIndex, endIndex);
    }

    @Override // java.lang.CharSequence
    public final void toCharArray(char[] destination, int destinationOffset, int sourceStartIndex, int sourceEndIndex) {
        ToCharArray_androidKt.toCharArray(this.text, destination, destinationOffset, sourceStartIndex, sourceEndIndex);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.text.toString();
    }
}
