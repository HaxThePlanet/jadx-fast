package androidx.compose.ui.text.style;

import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0019\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J$\u0010\n\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\u0008\u000b\u0010\u000cJ\u0013\u0010\r\u001a\u00020\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0008\u0010\u0010\u001a\u00020\u0011H\u0016J\u0008\u0010\u0012\u001a\u00020\u0013H\u0016R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0008\u001a\u0004\u0008\u0006\u0010\u0007R\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0008\u001a\u0004\u0008\t\u0010\u0007\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0015", d2 = {"Landroidx/compose/ui/text/style/TextIndent;", "", "firstLine", "Landroidx/compose/ui/unit/TextUnit;", "restLine", "(JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getFirstLine-XSAIIZE", "()J", "J", "getRestLine-XSAIIZE", "copy", "copy-NB67dxo", "(JJ)Landroidx/compose/ui/text/style/TextIndent;", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TextIndent {

    public static final int $stable;
    public static final androidx.compose.ui.text.style.TextIndent.Companion Companion;
    private static final androidx.compose.ui.text.style.TextIndent None;
    private final long firstLine;
    private final long restLine;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0005\u0010\u0002\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"Landroidx/compose/ui/text/style/TextIndent$Companion;", "", "()V", "None", "Landroidx/compose/ui/text/style/TextIndent;", "getNone$annotations", "getNone", "()Landroidx/compose/ui/text/style/TextIndent;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public static void getNone$annotations() {
        }

        public final androidx.compose.ui.text.style.TextIndent getNone() {
            return TextIndent.access$getNone$cp();
        }
    }
    static {
        TextIndent.Companion companion = new TextIndent.Companion(0);
        TextIndent.Companion = companion;
        TextIndent textIndent = new TextIndent(0, obj4, 0, obj6, 3, 0);
        TextIndent.None = textIndent;
    }

    private TextIndent(long firstLine, long restLine) {
        super();
        this.firstLine = firstLine;
        this.restLine = obj3;
    }

    public TextIndent(long l, long l2, int i3, DefaultConstructorMarker defaultConstructorMarker4) {
        long l3;
        long l4;
        long obj8;
        long obj10;
        final int i = 0;
        if (obj12 & 1 != 0) {
            l3 = obj8;
        } else {
            l3 = l;
        }
        if (obj12 & 2 != 0) {
            l4 = obj10;
        } else {
            l4 = i3;
        }
        super(l3, obj3, l4, obj5, 0);
    }

    public TextIndent(long l, long l2, DefaultConstructorMarker defaultConstructorMarker3) {
        super(l, l2, defaultConstructorMarker3, obj4);
    }

    public static final androidx.compose.ui.text.style.TextIndent access$getNone$cp() {
        return TextIndent.None;
    }

    public static androidx.compose.ui.text.style.TextIndent copy-NB67dxo$default(androidx.compose.ui.text.style.TextIndent textIndent, long l2, long l3, int i4, Object object5) {
        long obj1;
        long obj3;
        if (obj5 & 1 != 0) {
            obj1 = textIndent.firstLine;
        }
        if (obj5 &= 2 != 0) {
            obj3 = textIndent.restLine;
        }
        return textIndent.copy-NB67dxo(obj1, l3);
    }

    public final androidx.compose.ui.text.style.TextIndent copy-NB67dxo(long firstLine, long restLine) {
        TextIndent textIndent = new TextIndent(firstLine, obj2, obj9, obj4, 0);
        return textIndent;
    }

    public boolean equals(Object other) {
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (!other instanceof TextIndent) {
            return i2;
        }
        if (!TextUnit.equals-impl0(this.firstLine, obj4)) {
            return i2;
        }
        if (!TextUnit.equals-impl0(this.restLine, obj4)) {
            return i2;
        }
        return i;
    }

    public final long getFirstLine-XSAIIZE() {
        return this.firstLine;
    }

    public final long getRestLine-XSAIIZE() {
        return this.restLine;
    }

    public int hashCode() {
        return i2 += i4;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("TextIndent(firstLine=").append(TextUnit.toString-impl(this.firstLine)).append(", restLine=").append(TextUnit.toString-impl(this.restLine)).append(')').toString();
    }
}
