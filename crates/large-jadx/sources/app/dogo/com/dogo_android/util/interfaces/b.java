package app.dogo.com.dogo_android.util.k0;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class b implements TextView.OnEditorActionListener {

    public final /* synthetic */ d a;
    public /* synthetic */ b(d dVar) {
        super();
        this.a = dVar;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        return this.a.e(textView, i, keyEvent);
    }
}
