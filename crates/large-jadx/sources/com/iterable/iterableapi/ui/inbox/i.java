package com.iterable.iterableapi.ui.inbox;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.content.a;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.l.f;
import androidx.recyclerview.widget.l.i;
import com.iterable.iterableapi.j1.b;
import com.iterable.iterableapi.z;

/* loaded from: classes2.dex */
public class i extends l.i {

    private final Drawable f;
    private final com.iterable.iterableapi.ui.inbox.b g;
    private final ColorDrawable h;
    public i(Context context, com.iterable.iterableapi.ui.inbox.b b2) {
        super(0, 4);
        this.g = b2;
        this.f = a.f(context, b.a);
        ColorDrawable obj3 = new ColorDrawable(-65536);
        this.h = obj3;
    }

    @Override // androidx.recyclerview.widget.l$i
    public void C(RecyclerView.e0 recyclerView$e0, int i2) {
        this.g.h(e0.getAdapterPosition(), z.INBOX_SWIPE);
    }

    @Override // androidx.recyclerview.widget.l$i
    public void v(Canvas canvas, RecyclerView recyclerView2, RecyclerView.e0 recyclerView$e03, float f4, float f5, int i6, boolean z7) {
        super.v(canvas, recyclerView2, e03, f4, f5, i6, z7);
        View obj3 = e03.itemView;
        int obj5 = (int)f4;
        this.h.setBounds(obj6 += obj5, obj3.getTop(), obj3.getRight(), obj3.getBottom());
        obj4 += obj6;
        this.f.setBounds(obj7 -= obj8, obj4, obj8 -= intrinsicWidth, obj6 += obj4);
        this.h.setBounds(obj6 += obj5, obj3.getTop(), obj3.getRight(), obj3.getBottom());
        this.h.draw(canvas);
        this.f.draw(canvas);
    }

    @Override // androidx.recyclerview.widget.l$i
    public boolean z(RecyclerView recyclerView, RecyclerView.e0 recyclerView$e02, RecyclerView.e0 recyclerView$e03) {
        return 0;
    }
}
