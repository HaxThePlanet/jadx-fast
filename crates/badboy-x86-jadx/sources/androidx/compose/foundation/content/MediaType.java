package androidx.compose.foundation.content;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u0008\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0007\u001a\u00020\u00082\u0008\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0008\u0010\n\u001a\u00020\u000bH\u0016J\u0008\u0010\u000c\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u000e", d2 = {"Landroidx/compose/foundation/content/MediaType;", "", "representation", "", "(Ljava/lang/String;)V", "getRepresentation", "()Ljava/lang/String;", "equals", "", "other", "hashCode", "", "toString", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MediaType {

    public static final int $stable;
    private static final androidx.compose.foundation.content.MediaType All;
    public static final androidx.compose.foundation.content.MediaType.Companion Companion;
    private static final androidx.compose.foundation.content.MediaType HtmlText;
    private static final androidx.compose.foundation.content.MediaType Image;
    private static final androidx.compose.foundation.content.MediaType PlainText;
    private static final androidx.compose.foundation.content.MediaType Text;
    private final String representation;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000b\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u0006¨\u0006\u000f", d2 = {"Landroidx/compose/foundation/content/MediaType$Companion;", "", "()V", "All", "Landroidx/compose/foundation/content/MediaType;", "getAll", "()Landroidx/compose/foundation/content/MediaType;", "HtmlText", "getHtmlText", "Image", "getImage", "PlainText", "getPlainText", "Text", "getText", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final androidx.compose.foundation.content.MediaType getAll() {
            return MediaType.access$getAll$cp();
        }

        public final androidx.compose.foundation.content.MediaType getHtmlText() {
            return MediaType.access$getHtmlText$cp();
        }

        public final androidx.compose.foundation.content.MediaType getImage() {
            return MediaType.access$getImage$cp();
        }

        public final androidx.compose.foundation.content.MediaType getPlainText() {
            return MediaType.access$getPlainText$cp();
        }

        public final androidx.compose.foundation.content.MediaType getText() {
            return MediaType.access$getText$cp();
        }
    }
    static {
        MediaType.Companion companion = new MediaType.Companion(0);
        MediaType.Companion = companion;
        MediaType mediaType = new MediaType("text/*");
        MediaType.Text = mediaType;
        MediaType mediaType2 = new MediaType("text/plain");
        MediaType.PlainText = mediaType2;
        MediaType mediaType3 = new MediaType("text/html");
        MediaType.HtmlText = mediaType3;
        MediaType mediaType4 = new MediaType("image/*");
        MediaType.Image = mediaType4;
        MediaType mediaType5 = new MediaType("*/*");
        MediaType.All = mediaType5;
    }

    public MediaType(String representation) {
        super();
        this.representation = representation;
    }

    public static final androidx.compose.foundation.content.MediaType access$getAll$cp() {
        return MediaType.All;
    }

    public static final androidx.compose.foundation.content.MediaType access$getHtmlText$cp() {
        return MediaType.HtmlText;
    }

    public static final androidx.compose.foundation.content.MediaType access$getImage$cp() {
        return MediaType.Image;
    }

    public static final androidx.compose.foundation.content.MediaType access$getPlainText$cp() {
        return MediaType.PlainText;
    }

    public static final androidx.compose.foundation.content.MediaType access$getText$cp() {
        return MediaType.Text;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return 1;
        }
        if (!other instanceof MediaType) {
            return 0;
        }
        return Intrinsics.areEqual(this.representation, obj.representation);
    }

    public final String getRepresentation() {
        return this.representation;
    }

    public int hashCode() {
        return this.representation.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("MediaType(representation='").append(this.representation).append("')").toString();
    }
}
