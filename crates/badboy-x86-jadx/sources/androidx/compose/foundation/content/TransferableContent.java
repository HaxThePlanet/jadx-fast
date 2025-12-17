package androidx.compose.foundation.content;

import androidx.compose.ui.platform.ClipEntry;
import androidx.compose.ui.platform.ClipMetadata;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000c\u0008\u0007\u0018\u00002\u00020\u0001:\u0001\u0014B+\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0013\u0010\u0008\u001a\u0004\u0018\u00010\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u0019\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\u0008\u0011\u0010\u0012\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0015", d2 = {"Landroidx/compose/foundation/content/TransferableContent;", "", "clipEntry", "Landroidx/compose/ui/platform/ClipEntry;", "clipMetadata", "Landroidx/compose/ui/platform/ClipMetadata;", "source", "Landroidx/compose/foundation/content/TransferableContent$Source;", "platformTransferableContent", "Landroidx/compose/foundation/content/PlatformTransferableContent;", "(Landroidx/compose/ui/platform/ClipEntry;Landroidx/compose/ui/platform/ClipMetadata;ILandroidx/compose/foundation/content/PlatformTransferableContent;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getClipEntry", "()Landroidx/compose/ui/platform/ClipEntry;", "getClipMetadata", "()Landroidx/compose/ui/platform/ClipMetadata;", "getPlatformTransferableContent", "()Landroidx/compose/foundation/content/PlatformTransferableContent;", "getSource-kB6V9T0", "()I", "I", "Source", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TransferableContent {

    public static final int $stable = 8;
    private final ClipEntry clipEntry;
    private final ClipMetadata clipMetadata;
    private final androidx.compose.foundation.content.PlatformTransferableContent platformTransferableContent;
    private final int source;

    @Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0008\u0087@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\u0008\u0010\u0008\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\u0008\u000c\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\u0008\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012", d2 = {"Landroidx/compose/foundation/content/TransferableContent$Source;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @JvmInline
    public static final class Source {

        private static final int Clipboard;
        public static final androidx.compose.foundation.content.TransferableContent.Source.Companion Companion;
        private static final int DragAndDrop;
        private static final int Keyboard;
        private final int value;
        static {
            TransferableContent.Source.Companion companion = new TransferableContent.Source.Companion(0);
            TransferableContent.Source.Companion = companion;
            TransferableContent.Source.Keyboard = TransferableContent.Source.constructor-impl(0);
            TransferableContent.Source.DragAndDrop = TransferableContent.Source.constructor-impl(1);
            TransferableContent.Source.Clipboard = TransferableContent.Source.constructor-impl(2);
        }

        private Source(int value) {
            super();
            this.value = value;
        }

        public static final int access$getClipboard$cp() {
            return TransferableContent.Source.Clipboard;
        }

        public static final int access$getDragAndDrop$cp() {
            return TransferableContent.Source.DragAndDrop;
        }

        public static final int access$getKeyboard$cp() {
            return TransferableContent.Source.Keyboard;
        }

        public static final androidx.compose.foundation.content.TransferableContent.Source box-impl(int i) {
            TransferableContent.Source source = new TransferableContent.Source(i);
            return source;
        }

        public static int constructor-impl(int i) {
            return i;
        }

        public static boolean equals-impl(int i, Object object2) {
            final int i3 = 0;
            if (!object2 instanceof TransferableContent.Source) {
                return i3;
            }
            if (i != (TransferableContent.Source)object2.unbox-impl()) {
                return i3;
            }
            return 1;
        }

        public static final boolean equals-impl0(int i, int i2) {
            int i3;
            i3 = i == i2 ? 1 : 0;
            return i3;
        }

        public static int hashCode-impl(int i) {
            return Integer.hashCode(i);
        }

        public static String toString-impl(int arg0) {
            String string;
            int i;
            if (TransferableContent.Source.equals-impl0(arg0, TransferableContent.Source.Keyboard)) {
                string = "Source.Keyboard";
            } else {
                if (TransferableContent.Source.equals-impl0(arg0, TransferableContent.Source.DragAndDrop)) {
                    string = "Source.DragAndDrop";
                } else {
                    if (TransferableContent.Source.equals-impl0(arg0, TransferableContent.Source.Clipboard)) {
                        string = "Source.Clipboard";
                    } else {
                        StringBuilder stringBuilder = new StringBuilder();
                        string = stringBuilder.append("Invalid (").append(arg0).append(')').toString();
                    }
                }
            }
            return string;
        }

        public boolean equals(Object object) {
            return TransferableContent.Source.equals-impl(this.value, object);
        }

        public int hashCode() {
            return TransferableContent.Source.hashCode-impl(this.value);
        }

        public String toString() {
            return TransferableContent.Source.toString-impl(this.value);
        }

        public final int unbox-impl() {
            return this.value;
        }
    }
    static {
        final int i = 8;
    }

    private TransferableContent(ClipEntry clipEntry, ClipMetadata clipMetadata, int source, androidx.compose.foundation.content.PlatformTransferableContent platformTransferableContent) {
        super();
        this.clipEntry = clipEntry;
        this.clipMetadata = clipMetadata;
        this.source = source;
        this.platformTransferableContent = platformTransferableContent;
    }

    public TransferableContent(ClipEntry clipEntry, ClipMetadata clipMetadata2, int i3, androidx.compose.foundation.content.PlatformTransferableContent platformTransferableContent4, int i5, DefaultConstructorMarker defaultConstructorMarker6) {
        int i;
        int obj10;
        i = i5 &= 8 != 0 ? obj10 : platformTransferableContent4;
        super(clipEntry, clipMetadata2, i3, i, 0);
    }

    public TransferableContent(ClipEntry clipEntry, ClipMetadata clipMetadata2, int i3, androidx.compose.foundation.content.PlatformTransferableContent platformTransferableContent4, DefaultConstructorMarker defaultConstructorMarker5) {
        super(clipEntry, clipMetadata2, i3, platformTransferableContent4);
    }

    public final ClipEntry getClipEntry() {
        return this.clipEntry;
    }

    public final ClipMetadata getClipMetadata() {
        return this.clipMetadata;
    }

    public final androidx.compose.foundation.content.PlatformTransferableContent getPlatformTransferableContent() {
        return this.platformTransferableContent;
    }

    public final int getSource-kB6V9T0() {
        return this.source;
    }
}
