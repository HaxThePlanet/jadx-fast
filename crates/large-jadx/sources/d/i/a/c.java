package d.i.a;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: ResourceCursorAdapter.java */
/* loaded from: classes.dex */
public abstract class c extends a {

    private int A;
    private int B;
    private LayoutInflater C;
    @Deprecated
    public c(Context context, int i, Cursor cursor, boolean z) {
        super(context, cursor, z);
        this.B = i;
        this.A = i;
        this.C = (LayoutInflater)context.getSystemService("layout_inflater");
    }

    @Override // d.i.a.a
    public View g(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.C.inflate(this.B, viewGroup, false);
    }

    @Override // d.i.a.a
    public View h(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.C.inflate(this.A, viewGroup, false);
    }
}
