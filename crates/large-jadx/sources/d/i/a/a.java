package d.i.a;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;

/* loaded from: classes.dex */
public abstract class a extends BaseAdapter implements Filterable, d.i.a.b.a {

    protected boolean a;
    protected boolean b;
    protected Cursor c;
    protected Context v;
    protected int w;
    protected d.i.a.a.a x;
    protected DataSetObserver y;
    protected d.i.a.b z;

    private class a extends ContentObserver {

        final d.i.a.a a;
        a(d.i.a.a a) {
            this.a = a;
            Handler obj1 = new Handler();
            super(obj1);
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return 1;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            this.a.i();
        }
    }

    private class b extends DataSetObserver {

        final d.i.a.a a;
        b(d.i.a.a a) {
            this.a = a;
            super();
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            final d.i.a.a aVar = this.a;
            aVar.a = true;
            aVar.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            final d.i.a.a aVar = this.a;
            aVar.a = false;
            aVar.notifyDataSetInvalidated();
        }
    }
    public a(Context context, Cursor cursor2, boolean z3) {
        int obj3;
        super();
        obj3 = z3 ? 1 : 2;
        f(context, cursor2, obj3);
    }

    @Override // android.widget.BaseAdapter
    public void a(Cursor cursor) {
        final Cursor obj1 = j(cursor);
        if (obj1 != null) {
            obj1.close();
        }
    }

    @Override // android.widget.BaseAdapter
    public Cursor b() {
        return this.c;
    }

    @Override // android.widget.BaseAdapter
    public abstract java.lang.CharSequence c(Cursor cursor);

    @Override // android.widget.BaseAdapter
    public abstract void e(View view, Context context2, Cursor cursor3);

    @Override // android.widget.BaseAdapter
    void f(Context context, Cursor cursor2, int i3) {
        int i;
        int obj4;
        int obj6;
        final int i4 = 1;
        if (i3 & 1 == i4) {
            i3 |= 2;
            this.b = i4;
        } else {
            this.b = false;
        }
        if (cursor2 != null) {
            i = i4;
        }
        this.c = cursor2;
        this.a = i;
        this.v = context;
        if (i != 0) {
            obj4 = cursor2.getColumnIndexOrThrow("_id");
        } else {
            obj4 = -1;
        }
        this.w = obj4;
        obj4 = 2;
        if (obj6 &= obj4 == obj4) {
            obj4 = new a.a(this);
            this.x = obj4;
            obj4 = new a.b(this);
            this.y = obj4;
        } else {
            obj4 = 0;
            this.x = obj4;
            this.y = obj4;
        }
        obj4 = this.x;
        if (i != 0 && obj4 != null) {
            obj4 = this.x;
            if (obj4 != null) {
                cursor2.registerContentObserver(obj4);
            }
            obj4 = this.y;
            if (obj4 != null) {
                cursor2.registerDataSetObserver(obj4);
            }
        }
    }

    @Override // android.widget.BaseAdapter
    public abstract View g(Context context, Cursor cursor2, ViewGroup viewGroup3);

    @Override // android.widget.BaseAdapter
    public int getCount() {
        boolean z;
        z = this.c;
        if (this.a && z != null) {
            z = this.c;
            if (z != null) {
                return z.getCount();
            }
        }
        return 0;
    }

    @Override // android.widget.BaseAdapter
    public View getDropDownView(int i, View view2, ViewGroup viewGroup3) {
        int obj2;
        View obj3;
        this.c.moveToPosition(i);
        if (this.a && view2 == null) {
            this.c.moveToPosition(i);
            if (view2 == null) {
                obj3 = g(this.v, this.c, viewGroup3);
            }
            e(obj3, this.v, this.c);
            return obj3;
        }
        return null;
    }

    @Override // android.widget.BaseAdapter
    public Filter getFilter() {
        d.i.a.b bVar;
        if (this.z == null) {
            bVar = new b(this);
            this.z = bVar;
        }
        return this.z;
    }

    @Override // android.widget.BaseAdapter
    public Object getItem(int i) {
        boolean z;
        z = this.c;
        if (this.a && z != null) {
            z = this.c;
            if (z != null) {
                z.moveToPosition(i);
                return this.c;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter
    public long getItemId(int i) {
        boolean z;
        int obj4;
        z = this.c;
        if (this.a && z != null && z.moveToPosition(i)) {
            z = this.c;
            if (z != null) {
                if (z.moveToPosition(i)) {
                    return this.c.getLong(this.w);
                }
            }
        }
        return 0;
    }

    @Override // android.widget.BaseAdapter
    public View getView(int i, View view2, ViewGroup viewGroup3) {
        int obj2;
        View obj3;
        if (!this.a) {
        } else {
            if (!this.c.moveToPosition(i)) {
            } else {
                if (view2 == null) {
                    obj3 = h(this.v, this.c, viewGroup3);
                }
                e(obj3, this.v, this.c);
                return obj3;
            }
            StringBuilder obj4 = new StringBuilder();
            obj4.append("couldn't move cursor to position ");
            obj4.append(i);
            obj3 = new IllegalStateException(obj4.toString());
            throw obj3;
        }
        obj2 = new IllegalStateException("this should only be called when the cursor is valid");
        throw obj2;
    }

    @Override // android.widget.BaseAdapter
    public abstract View h(Context context, Cursor cursor2, ViewGroup viewGroup3);

    @Override // android.widget.BaseAdapter
    protected void i() {
        boolean requery;
        requery = this.c;
        if (this.b && requery != null && !requery.isClosed()) {
            requery = this.c;
            if (requery != null) {
                if (!requery.isClosed()) {
                    this.a = this.c.requery();
                }
            }
        }
    }

    @Override // android.widget.BaseAdapter
    public Cursor j(Cursor cursor) {
        DataSetObserver str;
        int obj3;
        final Cursor cursor2 = this.c;
        if (cursor == cursor2) {
            return null;
        }
        d.i.a.a.a aVar = this.x;
        if (cursor2 != null && aVar != null) {
            aVar = this.x;
            if (aVar != null) {
                cursor2.unregisterContentObserver(aVar);
            }
            str = this.y;
            if (str != null) {
                cursor2.unregisterDataSetObserver(str);
            }
        }
        this.c = cursor;
        if (cursor != null) {
            d.i.a.a.a aVar2 = this.x;
            if (aVar2 != null) {
                cursor.registerContentObserver(aVar2);
            }
            DataSetObserver set = this.y;
            if (set != null) {
                cursor.registerDataSetObserver(set);
            }
            this.w = cursor.getColumnIndexOrThrow("_id");
            this.a = true;
            notifyDataSetChanged();
        } else {
            this.w = -1;
            this.a = false;
            notifyDataSetInvalidated();
        }
        return cursor2;
    }
}
