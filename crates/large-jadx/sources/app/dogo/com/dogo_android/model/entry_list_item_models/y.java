package app.dogo.com.dogo_android.model.entry_list_item_models;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import app.dogo.com.dogo_android.h.sk;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class y implements View.OnKeyListener {

    public final /* synthetic */ sk a;
    public final /* synthetic */ EditText b;
    public /* synthetic */ y(sk skVar, EditText editText) {
        super();
        this.a = skVar;
        this.b = editText;
    }

    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        return EntryViewHolder.c(this.a, this.b, view, i, keyEvent);
    }
}
