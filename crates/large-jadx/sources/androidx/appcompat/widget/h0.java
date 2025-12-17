package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.ListMenuItemView;
import androidx.appcompat.view.menu.f;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.i;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class h0 extends androidx.appcompat.widget.f0 implements androidx.appcompat.widget.g0 {

    private static Method b0;
    private androidx.appcompat.widget.g0 a0;

    public static class a extends androidx.appcompat.widget.b0 {

        final int G;
        final int H;
        private androidx.appcompat.widget.g0 I;
        private MenuItem J;
        public a(Context context, boolean z2) {
            Configuration obj4;
            int obj5;
            super(context, z2);
            final int i = 21;
            final int i2 = 22;
            if (Build.VERSION.SDK_INT >= 17 && 1 == context.getResources().getConfiguration().getLayoutDirection()) {
                if (1 == obj4.getLayoutDirection()) {
                    this.G = i;
                    this.H = i2;
                } else {
                    this.G = i2;
                    this.H = i;
                }
            } else {
            }
        }

        @Override // androidx.appcompat.widget.b0
        public boolean onHoverEvent(MotionEvent motionEvent) {
            Object wrappedAdapter;
            Object obj;
            int headersCount;
            int i;
            int pointToPosition;
            int i2;
            if (this.I != null) {
                wrappedAdapter = getAdapter();
                if (wrappedAdapter instanceof HeaderViewListAdapter != null) {
                    headersCount = (HeaderViewListAdapter)wrappedAdapter.getHeadersCount();
                    wrappedAdapter = wrappedAdapter.getWrappedAdapter();
                } else {
                    headersCount = 0;
                }
                i = 0;
                pointToPosition = pointToPosition((int)f, (int)f2);
                pointToPosition -= headersCount;
                if (motionEvent.getAction() != 10 && pointToPosition != -1 && pointToPosition >= 0 && pointToPosition < wrappedAdapter.getCount()) {
                    pointToPosition = pointToPosition((int)f, (int)f2);
                    if (pointToPosition != -1) {
                        pointToPosition -= headersCount;
                        if (pointToPosition >= 0) {
                            if (pointToPosition < wrappedAdapter.getCount()) {
                                i = wrappedAdapter.c(pointToPosition);
                            }
                        }
                    }
                }
                obj = this.J;
                wrappedAdapter = wrappedAdapter.b();
                if (obj != i && obj != null) {
                    wrappedAdapter = wrappedAdapter.b();
                    if (obj != null) {
                        this.I.h(wrappedAdapter, obj);
                    }
                    this.J = i;
                    if (i != 0) {
                        this.I.e(wrappedAdapter, i);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }

        @Override // androidx.appcompat.widget.b0
        public boolean onKeyDown(int i, KeyEvent keyEvent2) {
            android.view.View selectedView;
            int selectedItemId;
            boolean obj5;
            selectedView = getSelectedView();
            final int i2 = 1;
            if (selectedView != null && i == this.G && (ListMenuItemView)selectedView.isEnabled() && selectedView.getItemData().hasSubMenu()) {
                if (i == this.G) {
                    if (selectedView.isEnabled()) {
                        if (selectedView.getItemData().hasSubMenu()) {
                            performItemClick(selectedView, getSelectedItemPosition(), getSelectedItemId());
                        }
                    }
                    return i2;
                }
            }
            if (selectedView != null && i == this.H) {
                if (i == this.H) {
                    setSelection(-1);
                    (f)getAdapter().b().e(false);
                    return i2;
                }
            }
            return super.onKeyDown(i, keyEvent2);
        }

        @Override // androidx.appcompat.widget.b0
        public void setHoverListener(androidx.appcompat.widget.g0 g0) {
            this.I = g0;
        }

        @Override // androidx.appcompat.widget.b0
        public void setSelector(Drawable drawable) {
            super.setSelector(drawable);
        }
    }
    static {
        int declaredMethod;
        int str;
        Class[] arr;
        int i;
        Class tYPE;
        try {
            if (Build.VERSION.SDK_INT <= 28) {
            }
            arr = new Class[1];
            h0.b0 = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    public h0(Context context, AttributeSet attributeSet2, int i3, int i4) {
        super(context, attributeSet2, i3, i4);
    }

    @Override // androidx.appcompat.widget.f0
    public void R(Object object) {
        int sDK_INT;
        if (Build.VERSION.SDK_INT >= 23) {
            this.W.setEnterTransition((Transition)object);
        }
    }

    @Override // androidx.appcompat.widget.f0
    public void S(Object object) {
        int sDK_INT;
        if (Build.VERSION.SDK_INT >= 23) {
            this.W.setExitTransition((Transition)object);
        }
    }

    @Override // androidx.appcompat.widget.f0
    public void T(androidx.appcompat.widget.g0 g0) {
        this.a0 = g0;
    }

    @Override // androidx.appcompat.widget.f0
    public void U(boolean z) {
        Object obj;
        int i2;
        Object[] arr;
        int i;
        boolean obj5;
        if (Build.VERSION.SDK_INT <= 28) {
            obj = h0.b0;
            if (obj != null) {
                arr = new Object[1];
                obj.invoke(this.W, Boolean.valueOf(z));
            }
        } else {
            this.W.setTouchModal(z);
        }
    }

    @Override // androidx.appcompat.widget.f0
    public void e(g g, MenuItem menuItem2) {
        final androidx.appcompat.widget.g0 g0Var = this.a0;
        if (g0Var != null) {
            g0Var.e(g, menuItem2);
        }
    }

    @Override // androidx.appcompat.widget.f0
    public void h(g g, MenuItem menuItem2) {
        final androidx.appcompat.widget.g0 g0Var = this.a0;
        if (g0Var != null) {
            g0Var.h(g, menuItem2);
        }
    }

    @Override // androidx.appcompat.widget.f0
    androidx.appcompat.widget.b0 s(Context context, boolean z2) {
        h0.a aVar = new h0.a(context, z2);
        aVar.setHoverListener(this);
        return aVar;
    }
}
