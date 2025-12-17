package androidx.compose.ui.platform.coreshims;

import android.view.autofill.AutofillId;

/* loaded from: classes.dex */
public class AutofillIdCompat {

    private final Object mWrappedObj;
    private AutofillIdCompat(AutofillId obj) {
        super();
        this.mWrappedObj = obj;
    }

    public static androidx.compose.ui.platform.coreshims.AutofillIdCompat toAutofillIdCompat(AutofillId autofillId) {
        AutofillIdCompat autofillIdCompat = new AutofillIdCompat(autofillId);
        return autofillIdCompat;
    }

    public AutofillId toAutofillId() {
        return (AutofillId)this.mWrappedObj;
    }
}
