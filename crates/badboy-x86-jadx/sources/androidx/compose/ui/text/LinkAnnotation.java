package androidx.compose.ui.text;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008'\u0018\u00002\u00020\u0001:\u0002\u000b\u000cB\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u0008X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\t\u0010\n¨\u0006\r", d2 = {"Landroidx/compose/ui/text/LinkAnnotation;", "", "()V", "linkInteractionListener", "Landroidx/compose/ui/text/LinkInteractionListener;", "getLinkInteractionListener", "()Landroidx/compose/ui/text/LinkInteractionListener;", "styles", "Landroidx/compose/ui/text/TextLinkStyles;", "getStyles", "()Landroidx/compose/ui/text/TextLinkStyles;", "Clickable", "Url", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class LinkAnnotation {

    public static final int $stable;

    @Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0008J\u0013\u0010\u000f\u001a\u00020\u00102\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\u0008\u0010\u0013\u001a\u00020\u0014H\u0016J\u0008\u0010\u0015\u001a\u00020\u0003H\u0016R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000e¨\u0006\u0016", d2 = {"Landroidx/compose/ui/text/LinkAnnotation$Clickable;", "Landroidx/compose/ui/text/LinkAnnotation;", "tag", "", "styles", "Landroidx/compose/ui/text/TextLinkStyles;", "linkInteractionListener", "Landroidx/compose/ui/text/LinkInteractionListener;", "(Ljava/lang/String;Landroidx/compose/ui/text/TextLinkStyles;Landroidx/compose/ui/text/LinkInteractionListener;)V", "getLinkInteractionListener", "()Landroidx/compose/ui/text/LinkInteractionListener;", "getStyles", "()Landroidx/compose/ui/text/TextLinkStyles;", "getTag", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "", "toString", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Clickable extends androidx.compose.ui.text.LinkAnnotation {

        public static final int $stable = 8;
        private final androidx.compose.ui.text.LinkInteractionListener linkInteractionListener;
        private final androidx.compose.ui.text.TextLinkStyles styles;
        private final String tag;
        static {
            final int i = 8;
        }

        public Clickable(String tag, androidx.compose.ui.text.TextLinkStyles styles, androidx.compose.ui.text.LinkInteractionListener linkInteractionListener) {
            super(0);
            this.tag = tag;
            this.styles = styles;
            this.linkInteractionListener = linkInteractionListener;
        }

        public Clickable(String string, androidx.compose.ui.text.TextLinkStyles textLinkStyles2, androidx.compose.ui.text.LinkInteractionListener linkInteractionListener3, int i4, DefaultConstructorMarker defaultConstructorMarker5) {
            int obj2;
            obj2 = i4 &= 2 != 0 ? 0 : obj2;
            super(string, obj2, linkInteractionListener3);
        }

        @Override // androidx.compose.ui.text.LinkAnnotation
        public boolean equals(Object other) {
            final int i = 1;
            if (this == other) {
                return i;
            }
            final int i2 = 0;
            if (!other instanceof LinkAnnotation.Clickable) {
                return i2;
            }
            if (!Intrinsics.areEqual(this.tag, obj.tag)) {
                return i2;
            }
            if (!Intrinsics.areEqual(getStyles(), (LinkAnnotation.Clickable)other.getStyles())) {
                return i2;
            }
            if (!Intrinsics.areEqual(getLinkInteractionListener(), (LinkAnnotation.Clickable)other.getLinkInteractionListener())) {
                return i2;
            }
            return i;
        }

        @Override // androidx.compose.ui.text.LinkAnnotation
        public androidx.compose.ui.text.LinkInteractionListener getLinkInteractionListener() {
            return this.linkInteractionListener;
        }

        @Override // androidx.compose.ui.text.LinkAnnotation
        public androidx.compose.ui.text.TextLinkStyles getStyles() {
            return this.styles;
        }

        @Override // androidx.compose.ui.text.LinkAnnotation
        public final String getTag() {
            return this.tag;
        }

        @Override // androidx.compose.ui.text.LinkAnnotation
        public int hashCode() {
            int i;
            int i2;
            androidx.compose.ui.text.TextLinkStyles styles = getStyles();
            if (styles != null) {
                i = styles.hashCode();
            } else {
                i = i2;
            }
            androidx.compose.ui.text.LinkInteractionListener linkInteractionListener = getLinkInteractionListener();
            if (linkInteractionListener != null) {
                i2 = linkInteractionListener.hashCode();
            }
            return result += i2;
        }

        @Override // androidx.compose.ui.text.LinkAnnotation
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("LinkAnnotation.Clickable(tag=").append(this.tag).append(')').toString();
        }
    }

    @Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0008J\u0013\u0010\u000f\u001a\u00020\u00102\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\u0008\u0010\u0013\u001a\u00020\u0014H\u0016J\u0008\u0010\u0015\u001a\u00020\u0003H\u0016R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000e¨\u0006\u0016", d2 = {"Landroidx/compose/ui/text/LinkAnnotation$Url;", "Landroidx/compose/ui/text/LinkAnnotation;", "url", "", "styles", "Landroidx/compose/ui/text/TextLinkStyles;", "linkInteractionListener", "Landroidx/compose/ui/text/LinkInteractionListener;", "(Ljava/lang/String;Landroidx/compose/ui/text/TextLinkStyles;Landroidx/compose/ui/text/LinkInteractionListener;)V", "getLinkInteractionListener", "()Landroidx/compose/ui/text/LinkInteractionListener;", "getStyles", "()Landroidx/compose/ui/text/TextLinkStyles;", "getUrl", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "", "toString", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Url extends androidx.compose.ui.text.LinkAnnotation {

        public static final int $stable = 8;
        private final androidx.compose.ui.text.LinkInteractionListener linkInteractionListener;
        private final androidx.compose.ui.text.TextLinkStyles styles;
        private final String url;
        static {
            final int i = 8;
        }

        public Url(String url, androidx.compose.ui.text.TextLinkStyles styles, androidx.compose.ui.text.LinkInteractionListener linkInteractionListener) {
            super(0);
            this.url = url;
            this.styles = styles;
            this.linkInteractionListener = linkInteractionListener;
        }

        public Url(String string, androidx.compose.ui.text.TextLinkStyles textLinkStyles2, androidx.compose.ui.text.LinkInteractionListener linkInteractionListener3, int i4, DefaultConstructorMarker defaultConstructorMarker5) {
            int obj3;
            int obj4;
            final int i = 0;
            obj3 = i4 & 2 != 0 ? i : obj3;
            obj4 = i4 &= 4 != 0 ? i : obj4;
            super(string, obj3, obj4);
        }

        @Override // androidx.compose.ui.text.LinkAnnotation
        public boolean equals(Object other) {
            final int i = 1;
            if (this == other) {
                return i;
            }
            final int i2 = 0;
            if (!other instanceof LinkAnnotation.Url) {
                return i2;
            }
            if (!Intrinsics.areEqual(this.url, obj.url)) {
                return i2;
            }
            if (!Intrinsics.areEqual(getStyles(), (LinkAnnotation.Url)other.getStyles())) {
                return i2;
            }
            if (!Intrinsics.areEqual(getLinkInteractionListener(), (LinkAnnotation.Url)other.getLinkInteractionListener())) {
                return i2;
            }
            return i;
        }

        @Override // androidx.compose.ui.text.LinkAnnotation
        public androidx.compose.ui.text.LinkInteractionListener getLinkInteractionListener() {
            return this.linkInteractionListener;
        }

        @Override // androidx.compose.ui.text.LinkAnnotation
        public androidx.compose.ui.text.TextLinkStyles getStyles() {
            return this.styles;
        }

        @Override // androidx.compose.ui.text.LinkAnnotation
        public final String getUrl() {
            return this.url;
        }

        @Override // androidx.compose.ui.text.LinkAnnotation
        public int hashCode() {
            int i;
            int i2;
            androidx.compose.ui.text.TextLinkStyles styles = getStyles();
            if (styles != null) {
                i = styles.hashCode();
            } else {
                i = i2;
            }
            androidx.compose.ui.text.LinkInteractionListener linkInteractionListener = getLinkInteractionListener();
            if (linkInteractionListener != null) {
                i2 = linkInteractionListener.hashCode();
            }
            return result += i2;
        }

        @Override // androidx.compose.ui.text.LinkAnnotation
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("LinkAnnotation.Url(url=").append(this.url).append(')').toString();
        }
    }
    static {
    }

    public LinkAnnotation(DefaultConstructorMarker defaultConstructorMarker) {
        super();
    }

    public abstract androidx.compose.ui.text.LinkInteractionListener getLinkInteractionListener();

    public abstract androidx.compose.ui.text.TextLinkStyles getStyles();
}
