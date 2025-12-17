package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class f extends BaseAdapter {

    androidx.appcompat.view.menu.g a;
    private int b = -1;
    private boolean c;
    private final boolean v;
    private final LayoutInflater w;
    private final int x;
    public f(androidx.appcompat.view.menu.g g, LayoutInflater layoutInflater2, boolean z3, int i4) {
        super();
        final int i = -1;
        this.v = z3;
        this.w = layoutInflater2;
        this.a = g;
        this.x = i4;
        a();
    }

    @Override // android.widget.BaseAdapter
    void a() {
        ArrayList list;
        int size;
        int i;
        Object obj;
        androidx.appcompat.view.menu.i iVar = this.a.x();
        if (iVar != null) {
            list = this.a.B();
            i = 0;
            while (i < list.size()) {
                i++;
            }
        }
        this.b = -1;
    }

    @Override // android.widget.BaseAdapter
    public androidx.appcompat.view.menu.g b() {
        return this.a;
    }

    @Override // android.widget.BaseAdapter
    public androidx.appcompat.view.menu.i c(int i) {
        ArrayList list;
        int obj3;
        if (this.v) {
            list = this.a.B();
        } else {
            list = this.a.G();
        }
        final int i2 = this.b;
        if (i2 >= 0 && i >= i2) {
            if (i >= i2) {
                i++;
            }
        }
        return (i)list.get(obj3);
    }

    @Override // android.widget.BaseAdapter
    public void d(boolean z) {
        this.c = z;
    }

    @Override // android.widget.BaseAdapter
    public int getCount() {
        ArrayList list;
        if (this.v) {
            list = this.a.B();
        } else {
            list = this.a.G();
        }
        if (this.b < 0) {
            return list.size();
        }
        return size--;
    }

    @Override // android.widget.BaseAdapter
    public Object getItem(int i) {
        return c(i);
    }

    @Override // android.widget.BaseAdapter
    public long getItemId(int i) {
        return (long)i;
    }

    @Override // android.widget.BaseAdapter
    public View getView(int i, View view2, ViewGroup viewGroup3) {
        int i2;
        int groupId;
        View obj7;
        int obj8;
        final int i3 = 0;
        if (view2 == null) {
            obj7 = this.w.inflate(this.x, viewGroup3, i3);
        }
        obj8 = c(i).getGroupId();
        int i4 = i + -1;
        if (i4 >= 0) {
            groupId = c(i4).getGroupId();
        } else {
            groupId = obj8;
        }
        final View view = obj7;
        final int i5 = 1;
        if (this.a.H() && obj8 != groupId) {
            obj8 = obj8 != groupId ? i5 : i3;
        } else {
        }
        (ListMenuItemView)view.setGroupDividerEnabled(obj8);
        if (this.c) {
            view.setForceShowIcon(i5);
        }
        (n.a)obj7.h(c(i), i3);
        return obj7;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
