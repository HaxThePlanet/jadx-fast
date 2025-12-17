package androidx.compose.ui.platform;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Context;
import androidx.compose.ui.text.AnnotatedString;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\u0008\u0000\u0018\u00002\u00020\u0001B\u000f\u0008\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\u0008\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\n\u0010\u000c\u001a\u0004\u0018\u00010\rH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0008\u0010\u0010\u001a\u00020\u0011H\u0016J\u0012\u0010\u0012\u001a\u00020\u00132\u0008\u0010\u0014\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u000fH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0008\u001a\u00060\u0006j\u0002`\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000b¨\u0006\u0017", d2 = {"Landroidx/compose/ui/platform/AndroidClipboardManager;", "Landroidx/compose/ui/platform/ClipboardManager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "clipboardManager", "Landroid/content/ClipboardManager;", "(Landroid/content/ClipboardManager;)V", "nativeClipboard", "Landroidx/compose/ui/platform/NativeClipboard;", "getNativeClipboard", "()Landroid/content/ClipboardManager;", "getClip", "Landroidx/compose/ui/platform/ClipEntry;", "getText", "Landroidx/compose/ui/text/AnnotatedString;", "hasText", "", "setClip", "", "clipEntry", "setText", "annotatedString", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AndroidClipboardManager implements androidx.compose.ui.platform.ClipboardManager {

    public static final int $stable = 8;
    private final ClipboardManager clipboardManager;
    static {
        final int i = 8;
    }

    public AndroidClipboardManager(ClipboardManager clipboardManager) {
        super();
        this.clipboardManager = clipboardManager;
    }

    public AndroidClipboardManager(Context context) {
        Object systemService = context.getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        super((ClipboardManager)systemService);
    }

    @Override // androidx.compose.ui.platform.ClipboardManager
    public androidx.compose.ui.platform.ClipEntry getClip() {
        int i;
        androidx.compose.ui.platform.ClipEntry clipEntry;
        ClipData primaryClip = this.clipboardManager.getPrimaryClip();
        if (primaryClip != null) {
            i = 0;
            clipEntry = new ClipEntry(primaryClip);
        } else {
            clipEntry = 0;
        }
        return clipEntry;
    }

    @Override // androidx.compose.ui.platform.ClipboardManager
    public ClipboardManager getNativeClipboard() {
        return this.clipboardManager;
    }

    @Override // androidx.compose.ui.platform.ClipboardManager
    public AnnotatedString getText() {
        int convertToAnnotatedString;
        int i;
        ClipData.Item itemCount;
        ClipData primaryClip = this.clipboardManager.getPrimaryClip();
        convertToAnnotatedString = 0;
        if (primaryClip != null) {
            i = 0;
            if (primaryClip.getItemCount() > 0) {
                itemCount = primaryClip.getItemAt(0);
                if (itemCount != null) {
                    convertToAnnotatedString = itemCount.getText();
                }
                convertToAnnotatedString = AndroidClipboardManager_androidKt.convertToAnnotatedString(convertToAnnotatedString);
            } else {
            }
        }
        return convertToAnnotatedString;
    }

    @Override // androidx.compose.ui.platform.ClipboardManager
    public boolean hasText() {
        boolean mimeType;
        String str;
        ClipDescription primaryClipDescription = this.clipboardManager.getPrimaryClipDescription();
        if (primaryClipDescription != null) {
            mimeType = primaryClipDescription.hasMimeType("text/*");
        } else {
            mimeType = 0;
        }
        return mimeType;
    }

    @Override // androidx.compose.ui.platform.ClipboardManager
    public void setClip(androidx.compose.ui.platform.ClipEntry clipEntry) {
        ClipboardManager clipboardManager;
        ClipData clipData;
        if (clipEntry == null) {
            Api28ClipboardManagerClipClear.clearPrimaryClip(this.clipboardManager);
        } else {
            this.clipboardManager.setPrimaryClip(clipEntry.getClipData());
        }
    }

    @Override // androidx.compose.ui.platform.ClipboardManager
    public void setText(AnnotatedString annotatedString) {
        this.clipboardManager.setPrimaryClip(ClipData.newPlainText((CharSequence)"plain text", AndroidClipboardManager_androidKt.convertToCharSequence(annotatedString)));
    }
}
