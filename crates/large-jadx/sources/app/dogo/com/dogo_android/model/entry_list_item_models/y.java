package app.dogo.com.dogo_android.model.entry_list_item_models;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import app.dogo.com.dogo_android.h.sk;

/* loaded from: classes.dex */
public final class y implements View.OnKeyListener {

    public final sk a;
    public final EditText b;
    public y(sk sk, EditText editText2) {
        super();
        this.a = sk;
        this.b = editText2;
    }

    @Override // android.view.View$OnKeyListener
    public final boolean onKey(View view, int i2, KeyEvent keyEvent3) {
        return EntryViewHolder.c(this.a, this.b, view, i2, keyEvent3);
    }
}
