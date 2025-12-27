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

/* compiled from: CursorAdapter.java */
/* loaded from: classes.dex */
public abstract class a extends BaseAdapter implements Filterable, b.a {

    protected boolean a;
    protected boolean b;
    protected Cursor c;
    protected Context v;
    protected int w;
    protected a.a x;
    protected DataSetObserver y;
    protected b z;

    private class a extends ContentObserver {

        final /* synthetic */ a a;
        a() {
            this.a = aVar;
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            this.a.i();
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }
    }

    private class b extends DataSetObserver {

        final /* synthetic */ a a;
        b() {
            this.a = aVar;
            super();
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            this.a.a = true;
            this.a.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            this.a.a = false;
            this.a.notifyDataSetInvalidated();
        }
    }
    public a(Context context, Cursor cursor, boolean z) {
        int i = 1;
        super();
        z = z ? 1 : 2;
        f(context, cursor, (z ? 1 : 2));
    }

    @Override // android.widget.BaseAdapter
    public void a(Cursor cursor) {
        final Cursor cursor2 = j(cursor);
        if (cursor2 != null) {
            cursor2.close();
        }
    }

    @Override // android.widget.BaseAdapter
    public Cursor b() {
        return this.c;
    }

    @Override // android.widget.BaseAdapter
    void f(Context context, Cursor cursor, int i) {
        boolean z = false;
        int columnIndexOrThrow = -1;
        d.i.a.a.b bVar = null;
        int i2;
        z = false;
        i = 1;
        if ((i & 1) == i) {
            i2 = i | 2;
            this.b = true;
        } else {
            this.b = false;
        }
        if (cursor != null) {
        }
        this.c = cursor;
        this.a = z;
        this.v = context;
        if (z) {
            columnIndexOrThrow = cursor.getColumnIndexOrThrow("_id");
        } else {
            columnIndexOrThrow = -1;
        }
        this.w = columnIndexOrThrow;
        int i5 = 2;
        if ((i2 & i5) == i5) {
            this.x = new a.a(this);
            this.y = new a.b(this);
        } else {
            d.i.a.a.a aVar3 = null;
            this.x = aVar3;
            this.y = aVar3;
        }
        if (z && this.x != null) {
            cursor.registerContentObserver(this.x);
            if (this.y != null) {
                cursor.registerDataSetObserver(this.y);
            }
        }
    }

    @Override // android.widget.BaseAdapter
    public int getCount() {
        if (this.a && this.c != null) {
            return this.c.getCount();
        }
        return 0;
    }

    @Override // android.widget.BaseAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (this.a) {
            this.c.moveToPosition(i);
            if (view == null) {
                view = g(this.v, this.c, viewGroup);
            }
            e(view, this.v, this.c);
            return view;
        }
        return null;
    }

    @Override // android.widget.BaseAdapter
    public Filter getFilter() {
        if (this.z == null) {
            this.z = new b(this);
        }
        return this.z;
    }

    @Override // android.widget.BaseAdapter
    public Object getItem(int i) {
        if (this.a && this.c != null) {
            this.c.moveToPosition(i);
            return this.c;
        }
        return null;
    }

    @Override // android.widget.BaseAdapter
    public long getItemId(int i) {
        if (this.a && this.c != null && this.c.moveToPosition(i)) {
            return this.c.getLong(this.w);
        }
        return 0;
    }

    @Override // android.widget.BaseAdapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.a) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        } else {
            if (!this.c.moveToPosition(i)) {
                StringBuilder stringBuilder = new StringBuilder();
                String str = "couldn't move cursor to position ";
                i = str + i;
                throw new IllegalStateException(i);
            } else {
                if (view == null) {
                    view = h(this.v, this.c, viewGroup);
                }
                e(view, this.v, this.c);
                return view;
            }
        }
    }

    @Override // android.widget.BaseAdapter
    protected void i() {
        if (this.b && this.c != null && !this.c.isClosed()) {
            this.a = this.c.requery();
        }
    }

    @Override // android.widget.BaseAdapter
    public Cursor j(Cursor cursor) {
        DataSetObserver dataSetObserver;
        if (cursor == this.c) {
            return null;
        }
        if (this.c != null && this.x != null) {
            this.c.unregisterContentObserver(this.x);
            if (this.y != null) {
                this.c.unregisterDataSetObserver(this.y);
            }
        }
        this.c = cursor;
        if (cursor != null) {
            if (this.x != null) {
                cursor.registerContentObserver(this.x);
            }
            if (this.y != null) {
                cursor.registerDataSetObserver(this.y);
            }
            this.w = cursor.getColumnIndexOrThrow("_id");
            boolean z = true;
            this.a = z;
            notifyDataSetChanged();
        } else {
            this.w = -1;
            z = false;
            this.a = z;
            notifyDataSetInvalidated();
        }
        return this.c;
    }

    @Override // android.widget.BaseAdapter
    public abstract java.lang.CharSequence c(Cursor cursor);

    @Override // android.widget.BaseAdapter
    public abstract void e(View view, Context context, Cursor cursor);

    @Override // android.widget.BaseAdapter
    public abstract View g(Context context, Cursor cursor, ViewGroup viewGroup);

    @Override // android.widget.BaseAdapter
    public abstract View h(Context context, Cursor cursor, ViewGroup viewGroup);
}
