package d.i.a;

import android.database.Cursor;
import android.widget.Filter;
import android.widget.Filter.FilterResults;

/* compiled from: CursorFilter.java */
/* loaded from: classes.dex */
class b extends Filter {

    b.a a;

    interface a {
        void a(Cursor cursor);

        Cursor b();

        java.lang.CharSequence c(Cursor cursor);

        Cursor d(java.lang.CharSequence charSequence);
    }
    b(b.a aVar) {
        super();
        this.a = aVar;
    }

    @Override // android.widget.Filter
    public java.lang.CharSequence convertResultToString(Object object) {
        return this.a.c(object);
    }

    @Override // android.widget.Filter
    protected Filter.FilterResults performFiltering(java.lang.CharSequence charSequence) {
        Cursor cursor = this.a.d(charSequence);
        Filter.FilterResults filterResults = new Filter.FilterResults();
        if (cursor != null) {
            filterResults.count = cursor.getCount();
            filterResults.values = cursor;
        } else {
            filterResults.count = 0;
            filterResults.values = null;
        }
        return filterResults;
    }

    @Override // android.widget.Filter
    protected void publishResults(java.lang.CharSequence charSequence, Filter.FilterResults filterResults) {
        if (filterResults.values != null && filterResults.values != this.a.b()) {
            this.a.a(values2);
        }
    }
}
