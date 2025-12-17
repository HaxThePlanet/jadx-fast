package d.h.l.e0;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* loaded from: classes.dex */
public final class a extends ClickableSpan {

    private final int a;
    private final d.h.l.e0.c b;
    private final int c;
    public a(int i, d.h.l.e0.c c2, int i3) {
        super();
        this.a = i;
        this.b = c2;
        this.c = i3;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        Bundle obj3 = new Bundle();
        obj3.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.a);
        this.b.N(this.c, obj3);
    }
}
