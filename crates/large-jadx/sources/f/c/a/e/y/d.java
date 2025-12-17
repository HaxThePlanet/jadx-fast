package f.c.a.e.y;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.r;
import com.google.android.material.internal.f;
import f.c.a.e.n.b;

/* loaded from: classes2.dex */
public class d implements m {

    private g a;
    private f.c.a.e.y.c b;
    private boolean c = false;
    private int v;

    static class a implements Parcelable {

        public static final Parcelable.Creator<f.c.a.e.y.d.a> CREATOR;
        int a;
        f b;
        static {
            d.a.a aVar = new d.a.a();
            d.a.CREATOR = aVar;
        }

        a(Parcel parcel) {
            super();
            this.a = parcel.readInt();
            this.b = (f)parcel.readParcelable(d.a.class.getClassLoader());
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.a);
            parcel.writeParcelable(this.b, 0);
        }
    }
    public d() {
        super();
        final int i = 0;
    }

    @Override // androidx.appcompat.view.menu.m
    public void a(int i) {
        this.v = i;
    }

    @Override // androidx.appcompat.view.menu.m
    public void b(f.c.a.e.y.c c) {
        this.b = c;
    }

    @Override // androidx.appcompat.view.menu.m
    public void c(g g, boolean z2) {
    }

    @Override // androidx.appcompat.view.menu.m
    public void d(boolean z) {
        f.c.a.e.y.c obj2;
        if (this.c) {
        }
        if (z) {
            this.b.d();
        } else {
            this.b.l();
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean e() {
        return 0;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean f(g g, i i2) {
        return 0;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean g(g g, i i2) {
        return 0;
    }

    @Override // androidx.appcompat.view.menu.m
    public int getId() {
        return this.v;
    }

    @Override // androidx.appcompat.view.menu.m
    public void i(Context context, g g2) {
        this.a = g2;
        this.b.b(g2);
    }

    @Override // androidx.appcompat.view.menu.m
    public void j(Parcelable parcelable) {
        boolean z;
        int i;
        Object obj3;
        if (parcelable instanceof d.a) {
            this.b.k(parcelable.a);
            this.b.setBadgeDrawables(b.b(this.b.getContext(), parcelable.b));
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public void k(boolean z) {
        this.c = z;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean l(r r) {
        return 0;
    }

    @Override // androidx.appcompat.view.menu.m
    public Parcelable m() {
        d.a aVar = new d.a();
        aVar.a = this.b.getSelectedItemId();
        aVar.b = b.c(this.b.getBadgeDrawables());
        return aVar;
    }
}
