package d.i.a;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public abstract class c extends d.i.a.a {

    private int A;
    private int B;
    private LayoutInflater C;
    @Deprecated
    public c(Context context, int i2, Cursor cursor3, boolean z4) {
        super(context, cursor3, z4);
        this.B = i2;
        this.A = i2;
        this.C = (LayoutInflater)context.getSystemService("layout_inflater");
    }

    @Override // d.i.a.a
    public View g(Context context, Cursor cursor2, ViewGroup viewGroup3) {
        return this.C.inflate(this.B, viewGroup3, false);
    }

    @Override // d.i.a.a
    public View h(Context context, Cursor cursor2, ViewGroup viewGroup3) {
        return this.C.inflate(this.A, viewGroup3, false);
    }
}
