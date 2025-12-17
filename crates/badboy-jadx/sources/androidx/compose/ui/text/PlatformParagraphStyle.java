package androidx.compose.ui.text;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0011\u0008\u0016\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u001b\u0008\u0016\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u0011\u0008\u0016\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0008B\u0007\u0008\u0016¢\u0006\u0002\u0010\tJ\u0013\u0010\u0010\u001a\u00020\u00032\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0008\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00002\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0000J\u0008\u0010\u0015\u001a\u00020\u0016H\u0016R\u0019\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000c\u001a\u0004\u0008\n\u0010\u000bR\u0019\u0010\u0002\u001a\u00020\u00038F¢\u0006\u000e\n\u0000\u0012\u0004\u0008\r\u0010\t\u001a\u0004\u0008\u000e\u0010\u000f\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0018", d2 = {"Landroidx/compose/ui/text/PlatformParagraphStyle;", "", "includeFontPadding", "", "(Z)V", "emojiSupportMatch", "Landroidx/compose/ui/text/EmojiSupportMatch;", "(IZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "(ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "()V", "getEmojiSupportMatch-_3YsG6Y", "()I", "I", "getIncludeFontPadding$annotations", "getIncludeFontPadding", "()Z", "equals", "other", "hashCode", "", "merge", "toString", "", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PlatformParagraphStyle {

    public static final int $stable;
    public static final androidx.compose.ui.text.PlatformParagraphStyle.Companion Companion;
    private static final androidx.compose.ui.text.PlatformParagraphStyle Default;
    private final int emojiSupportMatch;
    private final boolean includeFontPadding;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Landroidx/compose/ui/text/PlatformParagraphStyle$Companion;", "", "()V", "Default", "Landroidx/compose/ui/text/PlatformParagraphStyle;", "getDefault", "()Landroidx/compose/ui/text/PlatformParagraphStyle;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final androidx.compose.ui.text.PlatformParagraphStyle getDefault() {
            return PlatformParagraphStyle.access$getDefault$cp();
        }
    }
    static {
        PlatformParagraphStyle.Companion companion = new PlatformParagraphStyle.Companion(0);
        PlatformParagraphStyle.Companion = companion;
        PlatformParagraphStyle platformParagraphStyle = new PlatformParagraphStyle();
        PlatformParagraphStyle.Default = platformParagraphStyle;
    }

    public PlatformParagraphStyle() {
        super(EmojiSupportMatch.Companion.getDefault-_3YsG6Y(), 0, 0);
    }

    private PlatformParagraphStyle(int emojiSupportMatch) {
        super();
        this.includeFontPadding = false;
        this.emojiSupportMatch = emojiSupportMatch;
    }

    public PlatformParagraphStyle(int i, int i2, DefaultConstructorMarker defaultConstructorMarker3) {
        int obj1;
        if (i2 &= 1 != 0) {
            obj1 = EmojiSupportMatch.Companion.getDefault-_3YsG6Y();
        }
        super(obj1, 0);
    }

    public PlatformParagraphStyle(int i, DefaultConstructorMarker defaultConstructorMarker2) {
        super(i);
    }

    private PlatformParagraphStyle(int emojiSupportMatch, boolean includeFontPadding) {
        super();
        this.includeFontPadding = includeFontPadding;
        this.emojiSupportMatch = emojiSupportMatch;
    }

    public PlatformParagraphStyle(int i, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker4) {
        int obj1;
        int obj2;
        if (i3 & 1 != 0) {
            obj1 = EmojiSupportMatch.Companion.getDefault-_3YsG6Y();
        }
        obj2 = i3 &= 2 != 0 ? 0 : obj2;
        super(obj1, obj2, 0);
    }

    public PlatformParagraphStyle(int i, boolean z2, DefaultConstructorMarker defaultConstructorMarker3) {
        super(i, z2);
    }

    public PlatformParagraphStyle(boolean includeFontPadding) {
        super();
        this.includeFontPadding = includeFontPadding;
        this.emojiSupportMatch = EmojiSupportMatch.Companion.getDefault-_3YsG6Y();
    }

    public PlatformParagraphStyle(boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker3) {
        int obj1;
        obj1 = i2 &= 1 != 0 ? 0 : obj1;
        super(obj1);
    }

    public static final androidx.compose.ui.text.PlatformParagraphStyle access$getDefault$cp() {
        return PlatformParagraphStyle.Default;
    }

    public static void getIncludeFontPadding$annotations() {
    }

    public boolean equals(Object other) {
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (!other instanceof PlatformParagraphStyle) {
            return i2;
        }
        if (this.includeFontPadding != obj.includeFontPadding) {
            return i2;
        }
        if (!EmojiSupportMatch.equals-impl0(this.emojiSupportMatch, obj2.emojiSupportMatch)) {
            return i2;
        }
        return i;
    }

    public final int getEmojiSupportMatch-_3YsG6Y() {
        return this.emojiSupportMatch;
    }

    public final boolean getIncludeFontPadding() {
        return this.includeFontPadding;
    }

    public int hashCode() {
        return i2 += i4;
    }

    public final androidx.compose.ui.text.PlatformParagraphStyle merge(androidx.compose.ui.text.PlatformParagraphStyle other) {
        if (other == null) {
            return this;
        }
        return other;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("PlatformParagraphStyle(includeFontPadding=").append(this.includeFontPadding).append(", emojiSupportMatch=").append(EmojiSupportMatch.toString-impl(this.emojiSupportMatch)).append(')').toString();
    }
}
