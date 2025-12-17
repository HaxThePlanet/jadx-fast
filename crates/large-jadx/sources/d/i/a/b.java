package d.i.a;

import android.database.Cursor;
import android.widget.Filter;
import android.widget.Filter.FilterResults;

/* loaded from: classes.dex */
class b extends Filter {

    d.i.a.b.a a;

    interface a {
        public abstract void a(Cursor cursor);

        public abstract Cursor b();

        public abstract java.lang.CharSequence c(Cursor cursor);

        public abstract Cursor d(java.lang.CharSequence charSequence);
    }
    b(d.i.a.b.a b$a) {
        super();
        this.a = a;
    }

    @Override // android.widget.Filter
    public java.lang.CharSequence convertResultToString(Object object) {
        return this.a.c((Cursor)object);
    }

    @Override // android.widget.Filter
    protected Filter.FilterResults performFiltering(java.lang.CharSequence charSequence) {
        int count;
        Cursor obj3;
        obj3 = this.a.d(charSequence);
        Filter.FilterResults filterResults = new Filter.FilterResults();
        if (obj3 != null) {
            filterResults.count = obj3.getCount();
            filterResults.values = obj3;
        } else {
            filterResults.count = 0;
            filterResults.values = 0;
        }
        return filterResults;
    }

    @Override // android.widget.Filter
    protected void publishResults(java.lang.CharSequence charSequence, Filter.FilterResults filter$FilterResults2) {
        Object obj1;
        final Object obj2 = filterResults2.values;
        if (obj2 != null && obj2 != this.a.b()) {
            if (obj2 != this.a.b()) {
                this.a.a((Cursor)obj2);
            }
        }
    }
}
