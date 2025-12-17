package androidx.compose.ui.text.android;

import android.text.Layout.Alignment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0000\u0008À\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0008R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t", d2 = {"Landroidx/compose/ui/text/android/TextAlignmentAdapter;", "", "()V", "ALIGN_LEFT_FRAMEWORK", "Landroid/text/Layout$Alignment;", "ALIGN_RIGHT_FRAMEWORK", "get", "value", "", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TextAlignmentAdapter {

    public static final int $stable;
    private static final Layout.Alignment ALIGN_LEFT_FRAMEWORK;
    private static final Layout.Alignment ALIGN_RIGHT_FRAMEWORK;
    public static final androidx.compose.ui.text.android.TextAlignmentAdapter INSTANCE;
    static {
        Layout.Alignment alignLeft;
        Layout.Alignment alignRight;
        int i;
        Layout.Alignment alignment;
        boolean equal;
        String str;
        TextAlignmentAdapter textAlignmentAdapter = new TextAlignmentAdapter();
        TextAlignmentAdapter.INSTANCE = textAlignmentAdapter;
        Layout.Alignment[] values = Layout.Alignment.values();
        alignLeft = Layout.Alignment.ALIGN_NORMAL;
        alignRight = Layout.Alignment.ALIGN_NORMAL;
        i = 0;
        while (i < values.length) {
            alignment = values[i];
            if (Intrinsics.areEqual(alignment.name(), "ALIGN_LEFT")) {
            } else {
            }
            if (Intrinsics.areEqual(alignment.name(), "ALIGN_RIGHT")) {
            }
            i++;
            alignRight = alignment;
            alignLeft = alignment;
        }
        TextAlignmentAdapter.ALIGN_LEFT_FRAMEWORK = alignLeft;
        TextAlignmentAdapter.ALIGN_RIGHT_FRAMEWORK = alignRight;
    }

    public final Layout.Alignment get(int value) {
        Layout.Alignment aLIGN_LEFT_FRAMEWORK;
        switch (value) {
            case 0:
                aLIGN_LEFT_FRAMEWORK = Layout.Alignment.ALIGN_NORMAL;
                break;
            case 1:
                aLIGN_LEFT_FRAMEWORK = Layout.Alignment.ALIGN_OPPOSITE;
                break;
            case 2:
                aLIGN_LEFT_FRAMEWORK = Layout.Alignment.ALIGN_CENTER;
                break;
            case 3:
                aLIGN_LEFT_FRAMEWORK = TextAlignmentAdapter.ALIGN_LEFT_FRAMEWORK;
                break;
            case 4:
                aLIGN_LEFT_FRAMEWORK = TextAlignmentAdapter.ALIGN_RIGHT_FRAMEWORK;
                break;
            default:
                aLIGN_LEFT_FRAMEWORK = Layout.Alignment.ALIGN_NORMAL;
        }
        return aLIGN_LEFT_FRAMEWORK;
    }
}
