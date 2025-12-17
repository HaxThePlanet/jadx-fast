package app.dogo.com.dogo_android.util.k0;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

/* loaded from: classes.dex */
public final class b implements TextView.OnEditorActionListener {

    public final app.dogo.com.dogo_android.util.k0.d a;
    public b(app.dogo.com.dogo_android.util.k0.d d) {
        super();
        this.a = d;
    }

    @Override // android.widget.TextView$OnEditorActionListener
    public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent3) {
        return this.a.e(textView, i2, keyEvent3);
    }
}
