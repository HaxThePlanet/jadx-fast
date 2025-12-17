package androidx.compose.ui.text.style;

import androidx.compose.ui.util.ListUtilsKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u000f\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u0000H\u0086\u0002J\u0013\u0010\n\u001a\u00020\u00082\u0008\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0008\u0010\u000b\u001a\u00020\u0003H\u0016J\u0011\u0010\u000c\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0000H\u0086\u0002J\u0008\u0010\u000e\u001a\u00020\u000fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0011", d2 = {"Landroidx/compose/ui/text/style/TextDecoration;", "", "mask", "", "(I)V", "getMask", "()I", "contains", "", "other", "equals", "hashCode", "plus", "decoration", "toString", "", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TextDecoration {

    public static final int $stable;
    public static final androidx.compose.ui.text.style.TextDecoration.Companion Companion;
    private static final androidx.compose.ui.text.style.TextDecoration LineThrough;
    private static final androidx.compose.ui.text.style.TextDecoration None;
    private static final androidx.compose.ui.text.style.TextDecoration Underline;
    private final int mask;

    @Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0010 \n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u000e\u001a\u00020\u00042\u000c\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0010R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0005\u0010\u0002\u001a\u0004\u0008\u0006\u0010\u0007R\u001c\u0010\u0008\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\t\u0010\u0002\u001a\u0004\u0008\n\u0010\u0007R\u001c\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u000c\u0010\u0002\u001a\u0004\u0008\r\u0010\u0007¨\u0006\u0011", d2 = {"Landroidx/compose/ui/text/style/TextDecoration$Companion;", "", "()V", "LineThrough", "Landroidx/compose/ui/text/style/TextDecoration;", "getLineThrough$annotations", "getLineThrough", "()Landroidx/compose/ui/text/style/TextDecoration;", "None", "getNone$annotations", "getNone", "Underline", "getUnderline$annotations", "getUnderline", "combine", "decorations", "", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public static void getLineThrough$annotations() {
        }

        public static void getNone$annotations() {
        }

        public static void getUnderline$annotations() {
        }

        public final androidx.compose.ui.text.style.TextDecoration combine(List<androidx.compose.ui.text.style.TextDecoration> decorations) {
            Integer accumulator$iv;
            int index$iv$iv;
            Object obj2;
            Object obj;
            int i2;
            Integer valueOf;
            int intValue;
            int i;
            int mask;
            final int i4 = 0;
            int i5 = 0;
            accumulator$iv = valueOf2;
            final Object obj4 = obj3;
            final int i6 = 0;
            index$iv$iv = 0;
            while (index$iv$iv < obj4.size()) {
                i2 = 0;
                i = 0;
                accumulator$iv = valueOf;
                index$iv$iv++;
            }
            TextDecoration textDecoration = new TextDecoration((Number)accumulator$iv.intValue());
            return textDecoration;
        }

        public final androidx.compose.ui.text.style.TextDecoration getLineThrough() {
            return TextDecoration.access$getLineThrough$cp();
        }

        public final androidx.compose.ui.text.style.TextDecoration getNone() {
            return TextDecoration.access$getNone$cp();
        }

        public final androidx.compose.ui.text.style.TextDecoration getUnderline() {
            return TextDecoration.access$getUnderline$cp();
        }
    }
    static {
        TextDecoration.Companion companion = new TextDecoration.Companion(0);
        TextDecoration.Companion = companion;
        TextDecoration textDecoration = new TextDecoration(0);
        TextDecoration.None = textDecoration;
        TextDecoration textDecoration2 = new TextDecoration(1);
        TextDecoration.Underline = textDecoration2;
        TextDecoration textDecoration3 = new TextDecoration(2);
        TextDecoration.LineThrough = textDecoration3;
    }

    public TextDecoration(int mask) {
        super();
        this.mask = mask;
    }

    public static final androidx.compose.ui.text.style.TextDecoration access$getLineThrough$cp() {
        return TextDecoration.LineThrough;
    }

    public static final androidx.compose.ui.text.style.TextDecoration access$getNone$cp() {
        return TextDecoration.None;
    }

    public static final androidx.compose.ui.text.style.TextDecoration access$getUnderline$cp() {
        return TextDecoration.Underline;
    }

    public final boolean contains(androidx.compose.ui.text.style.TextDecoration other) {
        int i;
        i = mask |= mask2 == this.mask ? 1 : 0;
        return i;
    }

    public boolean equals(Object other) {
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (!other instanceof TextDecoration) {
            return i2;
        }
        if (this.mask != obj.mask) {
            return i2;
        }
        return i;
    }

    public final int getMask() {
        return this.mask;
    }

    public int hashCode() {
        return this.mask;
    }

    public final androidx.compose.ui.text.style.TextDecoration plus(androidx.compose.ui.text.style.TextDecoration decoration) {
        TextDecoration textDecoration = new TextDecoration(mask |= mask2);
        return textDecoration;
    }

    public String toString() {
        int str2;
        int str;
        if (this.mask == 0) {
            return "TextDecoration.None";
        }
        ArrayList arrayList = new ArrayList();
        final ArrayList list = arrayList;
        if (mask2 &= mask4 != 0) {
            (List)list.add("Underline");
        }
        if (mask3 &= mask5 != 0) {
            list.add("LineThrough");
        }
        if (list.size() == 1) {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("TextDecoration.").append((String)list.get(0)).toString();
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        return stringBuilder2.append("TextDecoration[").append(ListUtilsKt.fastJoinToString$default(list, (CharSequence)", ", 0, 0, 0, 0, 0, 62, 0)).append(']').toString();
    }
}
