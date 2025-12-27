package h.a.c;

import android.animation.Animator;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.StaggeredGridLayoutManager.c;
import androidx.recyclerview.widget.l;
import d.h.l.u;
import h.a.b.b.p;
import h.a.b.b.q;
import h.a.b.e;
import h.a.b.g.a.b;
import h.a.b.h.f;
import h.a.b.i.a;
import java.util.List;

/* compiled from: FlexibleViewHolder.java */
/* loaded from: classes2.dex */
public abstract class b extends a implements View.OnClickListener, View.OnLongClickListener, View.OnTouchListener, a.b {

    private boolean alreadySelected;
    protected int mActionState;
    protected final h.a.b.b mAdapter;
    private boolean mLongClickSkipped;
    public b(View view, h.a.b.b bVar) {
        this(view, bVar, false);
    }

    @Override // h.a.c.a
    public View getFrontView() {
        return this.itemView;
    }

    @Override // h.a.c.a
    public final boolean isDraggable() {
        boolean z = false;
        f fVar = this.mAdapter.O0(getFlexibleAdapterPosition());
        int r0 = fVar != null && fVar.isDraggable() ? 1 : 0;
        return (fVar != null && fVar.isDraggable() ? 1 : 0);
    }

    @Override // h.a.c.a
    public final boolean isSwipeable() {
        boolean z = false;
        f fVar = this.mAdapter.O0(getFlexibleAdapterPosition());
        int r0 = fVar != null && fVar.isSwipeable() ? 1 : 0;
        return (fVar != null && fVar.isSwipeable() ? 1 : 0);
    }

    @Override // h.a.c.a
    public void onActionStateChanged(int i, int i2) {
        Object[] arr;
        String str;
        boolean activateViewWhileSwiping;
        this.mActionState = i2;
        this.alreadySelected = this.mAdapter.r(i);
        arr = new Object[3];
        final int i7 = 0;
        arr[i7] = Integer.valueOf(i);
        final int i8 = 1;
        arr[i8] = a.b(this.mAdapter.m());
        String r1 = i2 == i8 ? "Swipe(1)" : "Drag(2)";
        final int i9 = 2;
        arr[i9] = (i2 == i8 ? "Swipe(1)" : "Drag(2)");
        b.m((i2 == i8 ? "Swipe(1)" : "Drag(2)"), arr);
        if (i2 == i9) {
            if (!this.alreadySelected) {
                if (!this.mLongClickSkipped) {
                    if (this.mAdapter.m() == i9) {
                        if (!shouldAddSelectionInActionMode()) {
                            if (this.mAdapter.m() != i9 && mAdapter26.t0 != null && this.mAdapter.q(i)) {
                                Object[] arr2 = new Object[i9];
                                b.m("onLongClick on position %s mode=%s", Integer.valueOf(i), Integer.valueOf(this.mAdapter.m()));
                                this.mAdapter.t0.a(i);
                                this.alreadySelected = true;
                            }
                        }
                    }
                }
                if (!this.alreadySelected) {
                    this.mAdapter.v(i);
                }
            }
            if (!getContentView().isActivated()) {
                toggleActivation();
            }
        } else {
            if (this.mLongClickSkipped == i8 && this.shouldActivateViewWhileSwiping() && !this.alreadySelected) {
                this.mAdapter.v(i);
                toggleActivation();
            }
        }
    }

    @Override // h.a.c.a
    public void onClick(View view) {
        final int flexibleAdapterPosition = getFlexibleAdapterPosition();
        if (!this.mAdapter.p1(flexibleAdapterPosition)) {
            return;
        }
        if (this.mAdapter.s0 != null && this.mActionState == 0) {
            Object[] arr = new Object[2];
            str = "onClick on position %s mode=%s";
            b.m(str, Integer.valueOf(flexibleAdapterPosition), a.b(this.mAdapter.m()));
            if (this.mAdapter.s0.x(view, flexibleAdapterPosition)) {
                toggleActivation();
            }
        }
    }

    @Override // h.a.c.a
    public void onItemReleased(int i) {
        String str;
        Object[] arr = new Object[3];
        final int i6 = 0;
        arr[i6] = Integer.valueOf(i);
        final int i7 = 1;
        arr[i7] = a.b(this.mAdapter.m());
        String r1 = this.mActionState == i7 ? "Swipe(1)" : "Drag(2)";
        final int i8 = 2;
        arr[i8] = (this.mActionState == i7 ? "Swipe(1)" : "Drag(2)");
        str2 = "onItemReleased position=%s mode=%s actionState=%s";
        b.m((this.mActionState == i7 ? "Swipe(1)" : "Drag(2)"), arr);
        if (!this.alreadySelected && this.shouldAddSelectionInActionMode()) {
            if (this.mAdapter.m() == i8) {
                Object[] arr2 = new Object[i8];
                str2 = "onLongClick for ActionMode on position %s mode=%s";
                b.m(str2, Integer.valueOf(i), Integer.valueOf(this.mAdapter.m()));
                if (this.mAdapter.t0 != null) {
                    this.mAdapter.t0.a(i);
                }
                if (this.mAdapter.r(i)) {
                    toggleActivation();
                }
            } else {
                if (shouldActivateViewWhileSwiping()) {
                    if (getContentView().isActivated()) {
                        this.mAdapter.v(i);
                        toggleActivation();
                    } else {
                        if (this.mActionState == i8) {
                            this.mAdapter.v(i);
                            if (getContentView().isActivated()) {
                                toggleActivation();
                            }
                        }
                    }
                }
            }
        }
        this.mLongClickSkipped = false;
        this.mActionState = i6;
    }

    @Override // h.a.c.a
    public boolean onLongClick(View view) {
        final int flexibleAdapterPosition = getFlexibleAdapterPosition();
        int i2 = 0;
        if (!this.mAdapter.p1(flexibleAdapterPosition)) {
            return false;
        }
        final int i4 = 1;
        if (mAdapter2.t0 != null && !this.mAdapter.q1()) {
            Object[] arr = new Object[2];
            arr[i2] = Integer.valueOf(flexibleAdapterPosition);
            arr[i4] = a.b(this.mAdapter.m());
            b.m("onLongClick on position %s mode=%s", arr);
            this.mAdapter.t0.a(flexibleAdapterPosition);
            toggleActivation();
            return true;
        }
        this.mLongClickSkipped = true;
        return false;
    }

    @Override // h.a.c.a
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int flexibleAdapterPosition = getFlexibleAdapterPosition();
        final int i2 = 0;
        b.n("Can't start drag: Item is not enabled or draggable!", new Object[i2]);
        return false;
    }

    @Override // h.a.c.a
    protected void setDragHandleView(View view) {
        if (view != null) {
            view.setOnTouchListener(this);
        }
    }

    @Override // h.a.c.a
    public void setFullSpan(boolean z) {
        z2 = this.itemView.getLayoutParams() instanceof StaggeredGridLayoutManager.c;
        if (this.itemView.getLayoutParams() instanceof StaggeredGridLayoutManager.c) {
            (StaggeredGridLayoutManager.c)this.itemView.getLayoutParams().f(z);
        }
    }

    @Override // h.a.c.a
    public void toggleActivation() {
        int flexibleAdapterPosition = getFlexibleAdapterPosition();
        if (!this.mAdapter.q(flexibleAdapterPosition)) {
            return;
        }
        boolean z2 = this.mAdapter.r(flexibleAdapterPosition);
        if (!getContentView().isActivated() || z2) {
            if (!getContentView().isActivated() && z2) {
                getContentView().setActivated(z2);
                if (this.mAdapter.W0() == flexibleAdapterPosition) {
                    this.mAdapter.u0();
                }
                float activationElevation = 0.0f;
                if (getContentView().isActivated()) {
                    float activationElevation3 = getActivationElevation();
                    if (activationElevation3 > 0.0f) {
                        u.s0(this.itemView, getActivationElevation());
                    } else {
                        float activationElevation2 = getActivationElevation();
                        if (activationElevation2 > 0.0f) {
                            u.s0(this.itemView, 0.0f);
                        }
                    }
                }
            }
        }
    }

    public b(View view, h.a.b.b bVar, boolean z) {
        super(view, bVar, z);
        z = false;
        this.mLongClickSkipped = z;
        this.alreadySelected = z;
        this.mActionState = z;
        this.mAdapter = bVar;
        if (bVar.s0 != null) {
            getContentView().setOnClickListener(this);
        }
        if (bVar.t0 != null) {
            getContentView().setOnLongClickListener(this);
        }
    }

    @Override // h.a.c.a
    public float getActivationElevation() {
        return 0;
    }

    @Override // h.a.c.a
    public View getRearLeftView() {
        return null;
    }

    @Override // h.a.c.a
    public View getRearRightView() {
        return null;
    }

    @Override // h.a.c.a
    public void scrollAnimators(List<Animator> list, int i, boolean z) {
    }

    @Override // h.a.c.a
    protected boolean shouldActivateViewWhileSwiping() {
        return false;
    }

    @Override // h.a.c.a
    protected boolean shouldAddSelectionInActionMode() {
        return false;
    }
}
