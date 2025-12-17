package androidx.core.app;

import android.app.Dialog;
import android.view.View;

/* loaded from: classes5.dex */
public class DialogCompat {

    static class Api28Impl {
        static <T> T requireViewById(Dialog dialog, int id) {
            return dialog.requireViewById(id);
        }
    }
    public static View requireViewById(Dialog dialog, int id) {
        return (View)DialogCompat.Api28Impl.requireViewById(dialog, id);
    }
}
