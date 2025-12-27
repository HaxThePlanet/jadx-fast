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

/* compiled from: IterableInboxTouchHelper.java */
/* loaded from: classes2.dex */
public class i extends l.i {

    private final Drawable f;
    private final b g;
    private final ColorDrawable h = new ColorDrawable(-65536);
    public i(Context context, b bVar) {
        super(0, 4);
        this.g = bVar;
        this.f = a.f(context, b.a);
        ColorDrawable colorDrawable = new ColorDrawable(-65536);
    }

    @Override // androidx.recyclerview.widget.l$i
    public void C(RecyclerView.e0 e0Var, int i) {
        this.g.h(e0Var.getAdapterPosition(), z.INBOX_SWIPE);
    }

    @Override // androidx.recyclerview.widget.l$i
    public void v(Canvas canvas, RecyclerView recyclerView, RecyclerView.e0 e0Var, float f, float f2, int i, boolean z) {
        super.v(canvas, recyclerView, e0Var, f, f2, i, z);
        int i2 = (int)f;
        this.h.setBounds(e0Var.itemView.getRight() + i2, e0Var.itemView.getTop(), e0Var.itemView.getRight(), e0Var.itemView.getBottom());
        i = e0Var.itemView.getTop() + (e0Var.itemView.getHeight() - this.f.getIntrinsicHeight()) / 2;
        this.f.setBounds(e0Var.itemView.getRight() - (this.f.getIntrinsicWidth() * 2), i, e0Var.itemView.getRight() - this.f.getIntrinsicWidth(), this.f.getIntrinsicHeight() + i);
        this.h.setBounds(e0Var.itemView.getRight() + i2, e0Var.itemView.getTop(), e0Var.itemView.getRight(), e0Var.itemView.getBottom());
        this.h.draw(canvas);
        this.f.draw(canvas);
    }

    @Override // androidx.recyclerview.widget.l$i
    public boolean z(RecyclerView recyclerView, RecyclerView.e0 e0Var, RecyclerView.e0 e0Var2) {
        return false;
    }
}
