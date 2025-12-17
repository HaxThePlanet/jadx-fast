package androidx.core.view.autofill;

import android.view.autofill.AutofillId;

/* loaded from: classes5.dex */
public class AutofillIdCompat {

    private final Object mWrappedObj;
    private AutofillIdCompat(AutofillId obj) {
        super();
        this.mWrappedObj = obj;
    }

    public static androidx.core.view.autofill.AutofillIdCompat toAutofillIdCompat(AutofillId autofillId) {
        AutofillIdCompat autofillIdCompat = new AutofillIdCompat(autofillId);
        return autofillIdCompat;
    }

    public AutofillId toAutofillId() {
        return (AutofillId)this.mWrappedObj;
    }
}
