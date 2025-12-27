package h.a.c;

import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.p;
import d.h.l.u;
import h.a.b.b;
import h.a.b.e;

/* compiled from: ContentViewHolder.java */
/* loaded from: classes2.dex */
abstract class a extends RecyclerView.e0 {

    private View contentView;
    private int mBackupPosition = -1;
    a(View view, b bVar, boolean z) {
        View view2;
        android.view.ViewGroup.LayoutParams layoutParams;
        int cmp;
        if (z) {
            FrameLayout frameLayout = new FrameLayout(view.getContext());
        } else {
            view2 = view;
        }
        super(view2);
        int i = -1;
        if (z) {
            this.itemView.setLayoutParams(bVar.n().getLayoutManager().c0(view.getLayoutParams()));
            (FrameLayout)this.itemView.addView(view);
            float f = u.w(view);
            if (f > 0) {
                u.o0(this.itemView, view.getBackground());
                u.s0(this.itemView, f);
            }
            this.contentView = view;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$e0
    public View getContentView() {
        View contentView2;
        if (this.contentView == null) {
        }
        return contentView2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$e0
    public final int getFlexibleAdapterPosition() {
        int adapterPosition;
        if (getAdapterPosition() == -1) {
        }
        return adapterPosition;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$e0
    public void setBackupPosition(int i) {
        this.mBackupPosition = i;
    }
}
