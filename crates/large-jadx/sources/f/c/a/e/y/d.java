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

/* compiled from: NavigationBarPresenter.java */
/* loaded from: classes2.dex */
public class d implements m {

    private g a;
    private c b;
    private boolean c = false;
    private int v;

    static class a implements Parcelable {

        public static final Parcelable.Creator<d.a> CREATOR = new d$a$a<>();
        int a;
        f b;

        a() {
            super();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.a);
            parcel.writeParcelable(this.b, 0);
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
    }
    public d() {
        super();
    }

    public void a(int i) {
        this.v = i;
    }

    public void b(c cVar) {
        this.b = cVar;
    }

    public void d(boolean z) {
        if (this.c) {
            return;
        }
        if (z) {
            this.b.d();
        } else {
            this.b.l();
        }
    }

    public int getId() {
        return this.v;
    }

    public void i(Context context, g gVar) {
        this.a = gVar;
        this.b.b(gVar);
    }

    public void j(Parcelable parcelable) {
        z = parcelable instanceof d.a;
        if (parcelable instanceof d.a) {
            this.b.k(parcelable.a);
            this.b.setBadgeDrawables(b.b(this.b.getContext(), parcelable.b));
        }
    }

    public void k(boolean z) {
        this.c = z;
    }

    public Parcelable m() {
        final f.c.a.e.y.d.a aVar = new d.a();
        aVar.a = this.b.getSelectedItemId();
        aVar.b = b.c(this.b.getBadgeDrawables());
        return aVar;
    }

    public void c(g gVar, boolean z) {
    }

    public boolean e() {
        return false;
    }

    public boolean f(g gVar, i iVar) {
        return false;
    }

    public boolean g(g gVar, i iVar) {
        return false;
    }

    public boolean l(r rVar) {
        return false;
    }
}
