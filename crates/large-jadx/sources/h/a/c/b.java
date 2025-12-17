package h.a.c;

import android.animation.Animator;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import androidx.recyclerview.widget.StaggeredGridLayoutManager.c;
import androidx.recyclerview.widget.l;
import d.h.l.u;
import h.a.b.b;
import h.a.b.b.p;
import h.a.b.b.q;
import h.a.b.e;
import h.a.b.g.a.b;
import h.a.b.h.f;
import h.a.b.i.a;
import h.a.b.i.b;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class b extends h.a.c.a implements View.OnClickListener, View.OnLongClickListener, View.OnTouchListener, a.b {

    private boolean alreadySelected;
    protected int mActionState;
    protected final b mAdapter;
    private boolean mLongClickSkipped;
    public b(View view, b b2) {
        super(view, b2, 0);
    }

    public b(View view, b b2, boolean z3) {
        Object obj1;
        super(view, b2, z3);
        obj1 = 0;
        this.mLongClickSkipped = obj1;
        this.alreadySelected = obj1;
        this.mActionState = obj1;
        this.mAdapter = b2;
        if (b2.s0 != null) {
            getContentView().setOnClickListener(this);
        }
        if (b2.t0 != null) {
            getContentView().setOnLongClickListener(this);
        }
    }

    @Override // h.a.c.a
    public float getActivationElevation() {
        return 0;
    }

    @Override // h.a.c.a
    public View getFrontView() {
        return this.itemView;
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
    public final boolean isDraggable() {
        f draggable;
        int i;
        draggable = this.mAdapter.O0(getFlexibleAdapterPosition());
        if (draggable != null && draggable.isDraggable()) {
            i = draggable.isDraggable() ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // h.a.c.a
    public final boolean isSwipeable() {
        f swipeable;
        int i;
        swipeable = this.mAdapter.O0(getFlexibleAdapterPosition());
        if (swipeable != null && swipeable.isSwipeable()) {
            i = swipeable.isSwipeable() ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // h.a.c.a
    public void onActionStateChanged(int i, int i2) {
        Object[] arr;
        String str;
        boolean obj6;
        boolean obj7;
        this.mActionState = i2;
        this.alreadySelected = this.mAdapter.r(i);
        arr = new Object[3];
        final int i6 = 0;
        arr[i6] = Integer.valueOf(i);
        final int i7 = 1;
        arr[i7] = a.b(this.mAdapter.m());
        str = i2 == i7 ? "Swipe(1)" : "Drag(2)";
        final int i8 = 2;
        arr[i8] = str;
        b.m("onActionStateChanged position=%s mode=%s actionState=%s", arr);
        if (i2 == i8) {
            if (!this.alreadySelected) {
                if (!this.mLongClickSkipped) {
                    if (this.mAdapter.m() == i8) {
                        if (!shouldAddSelectionInActionMode()) {
                            obj7 = this.mAdapter;
                            if (this.mAdapter.m() != i8 && obj7.t0 != null && obj7.q(i)) {
                                obj7 = this.mAdapter;
                                if (obj7.t0 != null) {
                                    if (obj7.q(i)) {
                                        obj7 = new Object[i8];
                                        obj7[i6] = Integer.valueOf(i);
                                        obj7[i7] = Integer.valueOf(this.mAdapter.m());
                                        b.m("onLongClick on position %s mode=%s", obj7);
                                        obj7.t0.a(i);
                                        this.alreadySelected = i7;
                                    }
                                }
                            }
                        } else {
                        }
                    }
                } else {
                }
                if (!this.alreadySelected) {
                    this.mAdapter.v(i);
                }
            }
            if (!getContentView().isActivated()) {
                toggleActivation();
            }
        } else {
            if (i2 == i7 && shouldActivateViewWhileSwiping() && !this.alreadySelected) {
                if (shouldActivateViewWhileSwiping()) {
                    if (!this.alreadySelected) {
                        this.mAdapter.v(i);
                        toggleActivation();
                    }
                }
            }
        }
    }

    @Override // h.a.c.a
    public void onClick(View view) {
        b.p mActionState;
        String str2;
        String str;
        View obj5;
        final int flexibleAdapterPosition = getFlexibleAdapterPosition();
        if (!this.mAdapter.p1(flexibleAdapterPosition)) {
        }
        Object[] arr = new Object[2];
        b.m("onClick on position %s mode=%s", Integer.valueOf(flexibleAdapterPosition), a.b(this.mAdapter.m()));
        if (mAdapter2.s0 != null && this.mActionState == 0 && mAdapter3.s0.x(view, flexibleAdapterPosition)) {
            if (this.mActionState == 0) {
                arr = new Object[2];
                b.m("onClick on position %s mode=%s", Integer.valueOf(flexibleAdapterPosition), a.b(this.mAdapter.m()));
                if (mAdapter3.s0.x(view, flexibleAdapterPosition)) {
                    toggleActivation();
                }
            }
        }
    }

    @Override // h.a.c.a
    public void onItemReleased(int i) {
        boolean addSelectionInActionMode;
        boolean activateViewWhileSwiping;
        boolean alreadySelected;
        String str;
        String str2;
        int obj6;
        Object[] arr = new Object[3];
        final int i5 = 0;
        arr[i5] = Integer.valueOf(i);
        final int i6 = 1;
        arr[i6] = a.b(this.mAdapter.m());
        str = this.mActionState == i6 ? "Swipe(1)" : "Drag(2)";
        final int i7 = 2;
        arr[i7] = str;
        b.m("onItemReleased position=%s mode=%s actionState=%s", arr);
        if (!this.alreadySelected) {
            if (shouldAddSelectionInActionMode() && this.mAdapter.m() == i7) {
                if (this.mAdapter.m() == i7) {
                    Object[] arr2 = new Object[i7];
                    arr2[i5] = Integer.valueOf(i);
                    arr2[i6] = Integer.valueOf(this.mAdapter.m());
                    b.m("onLongClick for ActionMode on position %s mode=%s", arr2);
                    b.q qVar = mAdapter2.t0;
                    if (qVar != null) {
                        qVar.a(i);
                    }
                    if (this.mAdapter.r(i)) {
                        toggleActivation();
                    }
                } else {
                    if (shouldActivateViewWhileSwiping() && getContentView().isActivated()) {
                        if (getContentView().isActivated()) {
                            this.mAdapter.v(i);
                            toggleActivation();
                        } else {
                            this.mAdapter.v(i);
                            if (this.mActionState == i7 && getContentView().isActivated()) {
                                this.mAdapter.v(i);
                                if (getContentView().isActivated()) {
                                    toggleActivation();
                                }
                            }
                        }
                    } else {
                    }
                }
            } else {
            }
        }
        this.mLongClickSkipped = i5;
        this.mActionState = i5;
    }

    @Override // h.a.c.a
    public boolean onLongClick(View view) {
        b mAdapter;
        final int obj5 = getFlexibleAdapterPosition();
        int i2 = 0;
        if (!this.mAdapter.p1(obj5)) {
            return i2;
        }
        mAdapter = this.mAdapter;
        final int i4 = 1;
        if (mAdapter.t0 != null && !mAdapter.q1()) {
            if (!mAdapter.q1()) {
                Object[] arr = new Object[2];
                arr[i2] = Integer.valueOf(obj5);
                arr[i4] = a.b(this.mAdapter.m());
                b.m("onLongClick on position %s mode=%s", arr);
                mAdapter3.t0.a(obj5);
                toggleActivation();
                return i4;
            }
        }
        this.mLongClickSkipped = i4;
        return i2;
    }

    @Override // h.a.c.a
    public boolean onTouch(View view, MotionEvent motionEvent2) {
        boolean draggable;
        int obj4;
        obj4 = getFlexibleAdapterPosition();
        final int i2 = 0;
        if (this.mAdapter.p1(obj4)) {
            if (!isDraggable()) {
            } else {
                Object[] arr = new Object[2];
                arr[i2] = Integer.valueOf(obj4);
                arr[1] = a.b(this.mAdapter.m());
                b.m("onTouch with DragHandleView on position %s mode=%s", arr);
                if (motionEvent2.getActionMasked() == 0 && this.mAdapter.n1()) {
                    if (this.mAdapter.n1()) {
                        this.mAdapter.P0().B(this);
                    }
                }
            }
            return i2;
        }
        b.n("Can't start drag: Item is not enabled or draggable!", new Object[i2]);
        return i2;
    }

    public void scrollAnimators(List<Animator> list, int i2, boolean z3) {
    }

    @Override // h.a.c.a
    protected void setDragHandleView(View view) {
        if (view != null) {
            view.setOnTouchListener(this);
        }
    }

    @Override // h.a.c.a
    public void setFullSpan(boolean z) {
        boolean layoutParams;
        if (layoutParams2 instanceof StaggeredGridLayoutManager.c) {
            (StaggeredGridLayoutManager.c)this.itemView.getLayoutParams().f(z);
        }
    }

    @Override // h.a.c.a
    protected boolean shouldActivateViewWhileSwiping() {
        return 0;
    }

    @Override // h.a.c.a
    protected boolean shouldAddSelectionInActionMode() {
        return 0;
    }

    @Override // h.a.c.a
    public void toggleActivation() {
        int flexibleAdapterPosition;
        boolean activated;
        int activationElevation;
        boolean contentView;
        flexibleAdapterPosition = getFlexibleAdapterPosition();
        if (!this.mAdapter.q(flexibleAdapterPosition)) {
        }
        activationElevation = this.mAdapter.r(flexibleAdapterPosition);
        if (getContentView().isActivated()) {
            if (activationElevation) {
                getContentView().setActivated(activationElevation);
                if (!getContentView().isActivated() && activationElevation && this.mAdapter.W0() == flexibleAdapterPosition) {
                    if (activationElevation) {
                        getContentView().setActivated(activationElevation);
                        if (this.mAdapter.W0() == flexibleAdapterPosition) {
                            this.mAdapter.u0();
                        }
                        activationElevation = 0;
                        if (getContentView().isActivated() && Float.compare(activationElevation3, activationElevation) > 0) {
                            if (Float.compare(activationElevation3, activationElevation) > 0) {
                                u.s0(this.itemView, getActivationElevation());
                            } else {
                                if (Float.compare(activationElevation2, activationElevation) > 0) {
                                    u.s0(this.itemView, activationElevation);
                                }
                            }
                        } else {
                        }
                    }
                }
            } else {
            }
        } else {
        }
    }
}
