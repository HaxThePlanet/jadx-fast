package h.a.c;

import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.p;
import d.h.l.u;
import h.a.b.b;
import h.a.b.e;

/* loaded from: classes2.dex */
abstract class a extends RecyclerView.e0 {

    private View contentView;
    private int mBackupPosition = -1;
    a(View view, b b2, boolean z3) {
        Object frameLayout;
        int layoutParams;
        android.content.Context context;
        float obj4;
        int obj5;
        if (z3 != 0) {
            frameLayout = new FrameLayout(view.getContext());
        } else {
            frameLayout = view;
        }
        super(frameLayout);
        layoutParams = -1;
        this.itemView.setLayoutParams(b2.n().getLayoutManager().c0(view.getLayoutParams()));
        (FrameLayout)this.itemView.addView(view);
        obj4 = u.w(view);
        if (z3 != 0 && Float.compare(obj4, obj5) > 0) {
            this.itemView.setLayoutParams(b2.n().getLayoutManager().c0(view.getLayoutParams()));
            (FrameLayout)this.itemView.addView(view);
            obj4 = u.w(view);
            if (Float.compare(obj4, obj5) > 0) {
                u.o0(this.itemView, view.getBackground());
                u.s0(this.itemView, obj4);
            }
            this.contentView = view;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$e0
    public View getContentView() {
        View contentView;
        if (this.contentView != null) {
        } else {
            contentView = this.itemView;
        }
        return contentView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$e0
    public final int getFlexibleAdapterPosition() {
        int adapterPosition;
        if (getAdapterPosition() == -1) {
            adapterPosition = this.mBackupPosition;
        }
        return adapterPosition;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$e0
    public void setBackupPosition(int i) {
        this.mBackupPosition = i;
    }
}
