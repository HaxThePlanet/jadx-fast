package androidx.compose.ui.text;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0007\u0018\u00002\u00020\u0001B\u001b\u0008\u0016\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u0011\u0008\u0016\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\tB\u000f\u0008\u0016\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ\u0013\u0010\u0011\u001a\u00020\u00082\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0008\u0010\u0013\u001a\u00020\u0014H\u0016J\u0008\u0010\u0015\u001a\u00020\u0016H\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010¨\u0006\u0017", d2 = {"Landroidx/compose/ui/text/PlatformTextStyle;", "", "spanStyle", "Landroidx/compose/ui/text/PlatformSpanStyle;", "paragraphStyle", "Landroidx/compose/ui/text/PlatformParagraphStyle;", "(Landroidx/compose/ui/text/PlatformSpanStyle;Landroidx/compose/ui/text/PlatformParagraphStyle;)V", "includeFontPadding", "", "(Z)V", "emojiSupportMatch", "Landroidx/compose/ui/text/EmojiSupportMatch;", "(ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getParagraphStyle", "()Landroidx/compose/ui/text/PlatformParagraphStyle;", "getSpanStyle", "()Landroidx/compose/ui/text/PlatformSpanStyle;", "equals", "other", "hashCode", "", "toString", "", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PlatformTextStyle {

    public static final int $stable;
    private final androidx.compose.ui.text.PlatformParagraphStyle paragraphStyle;
    private final androidx.compose.ui.text.PlatformSpanStyle spanStyle;
    static {
    }

    private PlatformTextStyle(int emojiSupportMatch) {
        final int i = 0;
        PlatformParagraphStyle platformParagraphStyle = new PlatformParagraphStyle(emojiSupportMatch, i);
        super(i, platformParagraphStyle);
    }

    public PlatformTextStyle(int i, DefaultConstructorMarker defaultConstructorMarker2) {
        super(i);
    }

    public PlatformTextStyle(androidx.compose.ui.text.PlatformSpanStyle spanStyle, androidx.compose.ui.text.PlatformParagraphStyle paragraphStyle) {
        super();
        this.spanStyle = spanStyle;
        this.paragraphStyle = paragraphStyle;
    }

    public PlatformTextStyle(boolean includeFontPadding) {
        PlatformParagraphStyle platformParagraphStyle = new PlatformParagraphStyle(includeFontPadding);
        super(0, platformParagraphStyle);
    }

    public PlatformTextStyle(boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker3) {
        int obj1;
        obj1 = i2 &= 1 != 0 ? 0 : obj1;
        super(obj1);
    }

    public boolean equals(Object other) {
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (!other instanceof PlatformTextStyle) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.paragraphStyle, obj.paragraphStyle)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.spanStyle, obj2.spanStyle)) {
            return i2;
        }
        return i;
    }

    public final androidx.compose.ui.text.PlatformParagraphStyle getParagraphStyle() {
        return this.paragraphStyle;
    }

    public final androidx.compose.ui.text.PlatformSpanStyle getSpanStyle() {
        return this.spanStyle;
    }

    public int hashCode() {
        int i;
        int i2;
        androidx.compose.ui.text.PlatformSpanStyle spanStyle = this.spanStyle;
        if (spanStyle != null) {
            i = spanStyle.hashCode();
        } else {
            i = i2;
        }
        final androidx.compose.ui.text.PlatformParagraphStyle paragraphStyle = this.paragraphStyle;
        if (paragraphStyle != null) {
            i2 = paragraphStyle.hashCode();
        }
        return i3 += i2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("PlatformTextStyle(spanStyle=").append(this.spanStyle).append(", paragraphSyle=").append(this.paragraphStyle).append(')').toString();
    }
}
