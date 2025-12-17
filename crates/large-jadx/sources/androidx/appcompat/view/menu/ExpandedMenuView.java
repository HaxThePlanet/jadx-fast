package androidx.appcompat.view.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.widget.t0;

/* loaded from: classes.dex */
public final class ExpandedMenuView extends ListView implements androidx.appcompat.view.menu.g.b, androidx.appcompat.view.menu.n, AdapterView.OnItemClickListener {

    private static final int[] c;
    private androidx.appcompat.view.menu.g a;
    private int b;
    static {
        int[] iArr = new int[2];
        iArr = new int[]{16842964, 16843049};
        ExpandedMenuView.c = iArr;
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, 16842868);
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet2, int i3) {
        boolean obj4;
        super(context, attributeSet2);
        setOnItemClickListener(this);
        final int i = 0;
        final t0 obj3 = t0.v(context, attributeSet2, ExpandedMenuView.c, i3, i);
        if (obj3.s(i)) {
            setBackgroundDrawable(obj3.g(i));
        }
        obj4 = 1;
        if (obj3.s(obj4)) {
            setDivider(obj3.g(obj4));
        }
        obj3.w();
    }

    @Override // android.widget.ListView
    public boolean a(androidx.appcompat.view.menu.i i) {
        return this.a.N(i, 0);
    }

    @Override // android.widget.ListView
    public void b(androidx.appcompat.view.menu.g g) {
        this.a = g;
    }

    @Override // android.widget.ListView
    public int getWindowAnimations() {
        return this.b;
    }

    @Override // android.widget.ListView
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // android.widget.ListView
    public void onItemClick(AdapterView adapterView, View view2, int i3, long l4) {
        a((i)getAdapter().getItem(i3));
    }
}
