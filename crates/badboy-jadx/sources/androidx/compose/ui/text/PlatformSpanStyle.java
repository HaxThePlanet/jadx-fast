package androidx.compose.ui.text;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0008\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u0008\u001a\u00020\u00002\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0000J\u0008\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000c", d2 = {"Landroidx/compose/ui/text/PlatformSpanStyle;", "", "()V", "equals", "", "other", "hashCode", "", "merge", "toString", "", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PlatformSpanStyle {

    public static final int $stable;
    public static final androidx.compose.ui.text.PlatformSpanStyle.Companion Companion;
    private static final androidx.compose.ui.text.PlatformSpanStyle Default;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Landroidx/compose/ui/text/PlatformSpanStyle$Companion;", "", "()V", "Default", "Landroidx/compose/ui/text/PlatformSpanStyle;", "getDefault", "()Landroidx/compose/ui/text/PlatformSpanStyle;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final androidx.compose.ui.text.PlatformSpanStyle getDefault() {
            return PlatformSpanStyle.access$getDefault$cp();
        }
    }
    static {
        PlatformSpanStyle.Companion companion = new PlatformSpanStyle.Companion(0);
        PlatformSpanStyle.Companion = companion;
        PlatformSpanStyle platformSpanStyle = new PlatformSpanStyle();
        PlatformSpanStyle.Default = platformSpanStyle;
    }

    public static final androidx.compose.ui.text.PlatformSpanStyle access$getDefault$cp() {
        return PlatformSpanStyle.Default;
    }

    public boolean equals(Object other) {
        int i = 1;
        if (this == other) {
            return i;
        }
        if (!other instanceof PlatformSpanStyle) {
            return 0;
        }
        return i;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public final androidx.compose.ui.text.PlatformSpanStyle merge(androidx.compose.ui.text.PlatformSpanStyle other) {
        return this;
    }

    public String toString() {
        return "PlatformSpanStyle()";
    }
}
