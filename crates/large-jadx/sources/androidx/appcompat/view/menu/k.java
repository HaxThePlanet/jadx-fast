package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;

/* loaded from: classes.dex */
abstract class k implements androidx.appcompat.view.menu.p, androidx.appcompat.view.menu.m, AdapterView.OnItemClickListener {

    private Rect a;
    protected static androidx.appcompat.view.menu.f A(ListAdapter listAdapter) {
        if (listAdapter instanceof HeaderViewListAdapter != null) {
            return (f)(HeaderViewListAdapter)listAdapter.getWrappedAdapter();
        }
        return (f)listAdapter;
    }

    protected static int q(ListAdapter listAdapter, ViewGroup viewGroup2, Context context3, int i4) {
        int i2;
        int i;
        int i3;
        int view;
        int measuredWidth;
        FrameLayout obj10;
        i2 = 0;
        final int i5 = 0;
        i3 = i;
        view = i5;
        while (i2 < listAdapter.getCount()) {
            int itemViewType = listAdapter.getItemViewType(i2);
            if (itemViewType != i3) {
            }
            if (obj10 == null) {
            }
            view = listAdapter.getView(i2, view, obj10);
            view.measure(View.MeasureSpec.makeMeasureSpec(i2, i2), View.MeasureSpec.makeMeasureSpec(i2, i2));
            measuredWidth = view.getMeasuredWidth();
            if (measuredWidth > i) {
            }
            i2++;
            i = measuredWidth;
            obj10 = new FrameLayout(context3);
            view = i5;
            i3 = itemViewType;
        }
        return i;
    }

    protected static boolean z(androidx.appcompat.view.menu.g g) {
        int i2;
        int i;
        MenuItem item;
        boolean visible;
        i = i2;
        while (i < g.size()) {
            item = g.getItem(i);
            if (item.isVisible()) {
                break;
            } else {
            }
            i++;
            if (item.getIcon() != null) {
                break;
            } else {
            }
        }
        return i2;
    }

    @Override // androidx.appcompat.view.menu.p
    public boolean f(androidx.appcompat.view.menu.g g, androidx.appcompat.view.menu.i i2) {
        return 0;
    }

    @Override // androidx.appcompat.view.menu.p
    public boolean g(androidx.appcompat.view.menu.g g, androidx.appcompat.view.menu.i i2) {
        return 0;
    }

    @Override // androidx.appcompat.view.menu.p
    public int getId() {
        return 0;
    }

    @Override // androidx.appcompat.view.menu.p
    public void i(Context context, androidx.appcompat.view.menu.g g2) {
    }

    @Override // androidx.appcompat.view.menu.p
    public abstract void n(androidx.appcompat.view.menu.g g);

    @Override // androidx.appcompat.view.menu.p
    protected boolean o() {
        return 1;
    }

    public void onItemClick(AdapterView<?> adapterView, View view2, int i3, long l4) {
        int obj3;
        android.widget.Adapter obj1 = adapterView.getAdapter();
        obj3 = o() ? 0 : 4;
        obj2.a.O((MenuItem)obj1.getItem(i3), this, obj3);
    }

    @Override // androidx.appcompat.view.menu.p
    public Rect p() {
        return this.a;
    }

    @Override // androidx.appcompat.view.menu.p
    public abstract void r(View view);

    @Override // androidx.appcompat.view.menu.p
    public void s(Rect rect) {
        this.a = rect;
    }

    @Override // androidx.appcompat.view.menu.p
    public abstract void t(boolean z);

    @Override // androidx.appcompat.view.menu.p
    public abstract void u(int i);

    @Override // androidx.appcompat.view.menu.p
    public abstract void v(int i);

    @Override // androidx.appcompat.view.menu.p
    public abstract void w(PopupWindow.OnDismissListener popupWindow$OnDismissListener);

    @Override // androidx.appcompat.view.menu.p
    public abstract void x(boolean z);

    @Override // androidx.appcompat.view.menu.p
    public abstract void y(int i);
}
