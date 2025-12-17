package androidx.compose.foundation.text.input.internal;

import android.os.Bundle;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputContentInfo;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008Ã\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000cH\u0007¨\u0006\r", d2 = {"Landroidx/compose/foundation/text/input/internal/Api25CommitContentImpl;", "", "()V", "commitContent", "", "inputConnection", "Landroid/view/inputmethod/InputConnection;", "inputContentInfo", "Landroid/view/inputmethod/InputContentInfo;", "flags", "", "opts", "Landroid/os/Bundle;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class Api25CommitContentImpl {

    public static final androidx.compose.foundation.text.input.internal.Api25CommitContentImpl INSTANCE;
    static {
        Api25CommitContentImpl api25CommitContentImpl = new Api25CommitContentImpl();
        Api25CommitContentImpl.INSTANCE = api25CommitContentImpl;
    }

    public final boolean commitContent(InputConnection inputConnection, InputContentInfo inputContentInfo, int flags, Bundle opts) {
        return inputConnection.commitContent(inputContentInfo, flags, opts);
    }
}
