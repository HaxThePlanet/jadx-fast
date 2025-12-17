package androidx.compose.ui.text.input;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRange.Companion;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u000f\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u0008\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB'\u0008\u0016\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007B#\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\nJ0\u0010\u0014\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005ø\u0001\u0000¢\u0006\u0004\u0008\u0015\u0010\u0016J.\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005ø\u0001\u0000¢\u0006\u0004\u0008\u0015\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0008\u0010\u001b\u001a\u00020\u001cH\u0016J\u0008\u0010\u001d\u001a\u00020\u0003H\u0016R\u0011\u0010\u0008\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0019\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\u0008\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0012\u0010\u0013\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u001f", d2 = {"Landroidx/compose/ui/text/input/TextFieldValue;", "", "text", "", "selection", "Landroidx/compose/ui/text/TextRange;", "composition", "(Ljava/lang/String;JLandroidx/compose/ui/text/TextRange;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "annotatedString", "Landroidx/compose/ui/text/AnnotatedString;", "(Landroidx/compose/ui/text/AnnotatedString;JLandroidx/compose/ui/text/TextRange;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAnnotatedString", "()Landroidx/compose/ui/text/AnnotatedString;", "getComposition-MzsxiRA", "()Landroidx/compose/ui/text/TextRange;", "getSelection-d9O1mEE", "()J", "J", "getText", "()Ljava/lang/String;", "copy", "copy-3r_uNRQ", "(Landroidx/compose/ui/text/AnnotatedString;JLandroidx/compose/ui/text/TextRange;)Landroidx/compose/ui/text/input/TextFieldValue;", "(Ljava/lang/String;JLandroidx/compose/ui/text/TextRange;)Landroidx/compose/ui/text/input/TextFieldValue;", "equals", "", "other", "hashCode", "", "toString", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TextFieldValue {

    public static final int $stable;
    public static final androidx.compose.ui.text.input.TextFieldValue.Companion Companion;
    private static final Saver<androidx.compose.ui.text.input.TextFieldValue, Object> Saver;
    private final AnnotatedString annotatedString;
    private final TextRange composition;
    private final long selection;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"Landroidx/compose/ui/text/input/TextFieldValue$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/text/input/TextFieldValue;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final Saver<androidx.compose.ui.text.input.TextFieldValue, Object> getSaver() {
            return TextFieldValue.access$getSaver$cp();
        }
    }
    static {
        TextFieldValue.Companion companion = new TextFieldValue.Companion(0);
        TextFieldValue.Companion = companion;
        TextFieldValue.Saver = SaverKt.Saver((Function2)TextFieldValue.Companion.Saver.1.INSTANCE, (Function1)TextFieldValue.Companion.Saver.2.INSTANCE);
    }

    private TextFieldValue(AnnotatedString annotatedString, long selection, TextRange composition) {
        TextRange box-impl;
        long coerceIn-8ffj60Q;
        super();
        this.annotatedString = annotatedString;
        final int i = 0;
        this.selection = TextRangeKt.coerceIn-8ffj60Q(selection, composition, i);
        if (obj8 != null) {
            box-impl = TextRange.box-impl(TextRangeKt.coerceIn-8ffj60Q(obj8.unbox-impl(), obj3, i));
        } else {
            box-impl = 0;
        }
        this.composition = box-impl;
    }

    public TextFieldValue(AnnotatedString annotatedString, long l2, TextRange textRange3, int i4, DefaultConstructorMarker defaultConstructorMarker5) {
        long l;
        int i;
        long obj8;
        int obj10;
        if (defaultConstructorMarker5 & 2 != 0) {
            l = obj8;
        } else {
            l = l2;
        }
        i = defaultConstructorMarker5 & 4 != 0 ? obj10 : i4;
        super(annotatedString, l, obj3, i, 0);
    }

    public TextFieldValue(AnnotatedString annotatedString, long l2, TextRange textRange3, DefaultConstructorMarker defaultConstructorMarker4) {
        super(annotatedString, l2, textRange3, defaultConstructorMarker4);
    }

    private TextFieldValue(String text, long selection, TextRange composition) {
        final int i4 = 0;
        final int i2 = 0;
        AnnotatedString annotatedString = new AnnotatedString(text, 0, i2, 6, i4);
        super(annotatedString, selection, i2, obj10, i4);
    }

    public TextFieldValue(String string, long l2, TextRange textRange3, int i4, DefaultConstructorMarker defaultConstructorMarker5) {
        String str;
        long l;
        int i;
        String obj7;
        long obj8;
        int obj10;
        str = defaultConstructorMarker5 & 1 != 0 ? obj7 : string;
        if (defaultConstructorMarker5 & 2 != 0) {
            l = obj8;
        } else {
            l = l2;
        }
        i = defaultConstructorMarker5 & 4 != 0 ? obj10 : i4;
        super(str, l, obj3, i, 0);
    }

    public TextFieldValue(String string, long l2, TextRange textRange3, DefaultConstructorMarker defaultConstructorMarker4) {
        super(string, l2, textRange3, defaultConstructorMarker4);
    }

    public static final Saver access$getSaver$cp() {
        return TextFieldValue.Saver;
    }

    public static androidx.compose.ui.text.input.TextFieldValue copy-3r_uNRQ$default(androidx.compose.ui.text.input.TextFieldValue textFieldValue, AnnotatedString annotatedString2, long l3, TextRange textRange4, int i5, Object object6) {
        AnnotatedString obj1;
        long obj2;
        TextRange obj4;
        if (object6 & 1 != 0) {
            obj1 = textFieldValue.annotatedString;
        }
        if (object6 & 2 != 0) {
            obj2 = textFieldValue.selection;
        }
        if (object6 &= 4 != 0) {
            obj4 = textFieldValue.composition;
        }
        return textFieldValue.copy-3r_uNRQ(obj1, obj2, textRange4);
    }

    public static androidx.compose.ui.text.input.TextFieldValue copy-3r_uNRQ$default(androidx.compose.ui.text.input.TextFieldValue textFieldValue, String string2, long l3, TextRange textRange4, int i5, Object object6) {
        long obj2;
        TextRange obj4;
        if (object6 & 2 != 0) {
            obj2 = textFieldValue.selection;
        }
        if (object6 &= 4 != 0) {
            obj4 = textFieldValue.composition;
        }
        return textFieldValue.copy-3r_uNRQ(string2, obj2, textRange4);
    }

    public final androidx.compose.ui.text.input.TextFieldValue copy-3r_uNRQ(AnnotatedString annotatedString, long selection, TextRange composition) {
        TextFieldValue textFieldValue = new TextFieldValue(annotatedString, selection, obj3, obj10, 0);
        return textFieldValue;
    }

    public final androidx.compose.ui.text.input.TextFieldValue copy-3r_uNRQ(String text, long selection, TextRange composition) {
        final int i = 0;
        AnnotatedString annotatedString = new AnnotatedString(text, i, 0, 6, 0);
        TextFieldValue textFieldValue = new TextFieldValue(annotatedString, selection, i, obj11, 0);
        return textFieldValue;
    }

    public boolean equals(Object other) {
        int i;
        boolean equal;
        AnnotatedString annotatedString;
        if (this == other) {
            return 1;
        }
        final int i2 = 0;
        if (!other instanceof TextFieldValue) {
            return i2;
        }
        if (TextRange.equals-impl0(this.selection, obj4) && Intrinsics.areEqual(this.composition, obj2.composition) && Intrinsics.areEqual(this.annotatedString, obj3.annotatedString)) {
            if (Intrinsics.areEqual(this.composition, obj2.composition)) {
                if (Intrinsics.areEqual(this.annotatedString, obj3.annotatedString)) {
                } else {
                    i = i2;
                }
            } else {
            }
        } else {
        }
        return i;
    }

    public final AnnotatedString getAnnotatedString() {
        return this.annotatedString;
    }

    public final TextRange getComposition-MzsxiRA() {
        return this.composition;
    }

    public final long getSelection-d9O1mEE() {
        return this.selection;
    }

    public final String getText() {
        return this.annotatedString.getText();
    }

    public int hashCode() {
        int i;
        TextRange composition = this.composition;
        if (composition != null) {
            i = TextRange.hashCode-impl(composition.unbox-impl());
        } else {
            i = 0;
        }
        return result += i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("TextFieldValue(text='").append(this.annotatedString).append("', selection=").append(TextRange.toString-impl(this.selection)).append(", composition=").append(this.composition).append(')').toString();
    }
}
