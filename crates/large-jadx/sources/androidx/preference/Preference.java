package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.core.content.e.g;
import java.util.List;

/* loaded from: classes.dex */
public class Preference implements Comparable<androidx.preference.Preference> {

    private String A;
    private boolean B;
    private boolean C;
    private boolean D;
    private Object E;
    private boolean F;
    private boolean G;
    private boolean H;
    private androidx.preference.Preference.a I;
    private List<androidx.preference.Preference> J;
    private androidx.preference.Preference.c K;
    private Context a;
    private androidx.preference.b b;
    private androidx.preference.a c;
    private androidx.preference.Preference.b v;
    private int w;
    private java.lang.CharSequence x;
    private java.lang.CharSequence y;
    private String z;

    interface a {
        public abstract void a(androidx.preference.Preference preference);
    }

    public interface b {
        public abstract boolean a(androidx.preference.Preference preference, Object object2);
    }

    public interface c {
        public abstract java.lang.CharSequence a(T t);
    }
    public Preference(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, g.a(context, c.g, 16842894));
    }

    public Preference(Context context, AttributeSet attributeSet2, int i3) {
        super(context, attributeSet2, i3, 0);
    }

    public Preference(Context context, AttributeSet attributeSet2, int i3, int i4) {
        Object obj6;
        boolean obj7;
        super();
        final int i = Integer.MAX_VALUE;
        this.w = i;
        final int i2 = 1;
        this.B = i2;
        this.C = i2;
        this.D = i2;
        this.F = i2;
        this.G = i2;
        this.a = context;
        final TypedArray obj5 = context.obtainStyledAttributes(attributeSet2, f.H, i3, i4);
        final int obj8 = 0;
        g.n(obj5, f.f0, f.I, obj8);
        this.z = g.o(obj5, f.i0, f.O);
        this.x = g.p(obj5, f.q0, f.M);
        this.y = g.p(obj5, f.p0, f.P);
        this.w = g.d(obj5, f.k0, f.Q, i);
        this.A = g.o(obj5, f.e0, f.V);
        g.n(obj5, f.j0, f.L, d.a);
        g.n(obj5, f.r0, f.R, obj8);
        this.B = g.b(obj5, f.d0, f.K, i2);
        this.C = g.b(obj5, f.m0, f.N, i2);
        this.D = g.b(obj5, f.l0, f.J, i2);
        g.o(obj5, f.b0, f.S);
        obj6 = f.Y;
        g.b(obj5, obj6, obj6, this.C);
        obj6 = f.Z;
        g.b(obj5, obj6, obj6, this.C);
        obj6 = f.a0;
        if (obj5.hasValue(obj6)) {
            this.E = u(obj5, obj6);
        } else {
            obj6 = f.T;
            if (obj5.hasValue(obj6)) {
                this.E = u(obj5, obj6);
            }
        }
        g.b(obj5, f.n0, f.U, i2);
        obj6 = f.o0;
        obj7 = obj5.hasValue(obj6);
        this.H = obj7;
        if (obj7 != null) {
            g.b(obj5, obj6, f.W, i2);
        }
        g.b(obj5, f.g0, f.X, obj8);
        obj6 = f.h0;
        g.b(obj5, obj6, obj6, i2);
        obj6 = f.c0;
        g.b(obj5, obj6, obj6, obj8);
        obj5.recycle();
    }

    @Override // java.lang.Comparable
    public boolean a(Object object) {
        int obj2;
        final androidx.preference.Preference.b bVar = this.v;
        if (bVar != null) {
            if (bVar.a(this, object)) {
                obj2 = 1;
            } else {
                obj2 = 0;
            }
        } else {
        }
        return obj2;
    }

    @Override // java.lang.Comparable
    public int c(androidx.preference.Preference preference) {
        int i = this.w;
        int i3 = preference.w;
        if (i != i3) {
            return i -= i3;
        }
        java.lang.CharSequence charSequence = this.x;
        java.lang.CharSequence charSequence2 = preference.x;
        if (charSequence == charSequence2) {
            return 0;
        }
        if (charSequence == null) {
            return 1;
        }
        if (charSequence2 == null) {
            return -1;
        }
        return charSequence.toString().compareToIgnoreCase(preference.x.toString());
    }

    @Override // java.lang.Comparable
    public int compareTo(Object object) {
        return c((Preference)object);
    }

    @Override // java.lang.Comparable
    public Context e() {
        return this.a;
    }

    @Override // java.lang.Comparable
    StringBuilder f() {
        int length;
        StringBuilder stringBuilder = new StringBuilder();
        java.lang.CharSequence charSequence = n();
        final int i = 32;
        if (!TextUtils.isEmpty(charSequence)) {
            stringBuilder.append(charSequence);
            stringBuilder.append(i);
        }
        java.lang.CharSequence charSequence2 = k();
        if (!TextUtils.isEmpty(charSequence2)) {
            stringBuilder.append(charSequence2);
            stringBuilder.append(i);
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.setLength(length2--);
        }
        return stringBuilder;
    }

    @Override // java.lang.Comparable
    protected boolean i(boolean z) {
        if (!z()) {
            return z;
        }
        androidx.preference.a aVar = j();
        if (aVar == null) {
        } else {
            return aVar.a(this.z, z);
        }
        this.b.c();
        throw 0;
    }

    @Override // java.lang.Comparable
    public androidx.preference.a j() {
        androidx.preference.a aVar = this.c;
        if (aVar != null) {
            return aVar;
        }
        androidx.preference.b bVar = this.b;
        if (bVar != null) {
            return bVar.b();
        }
        return null;
    }

    @Override // java.lang.Comparable
    public java.lang.CharSequence k() {
        if (m() != null) {
            return m().a(this);
        }
        return this.y;
    }

    @Override // java.lang.Comparable
    public final androidx.preference.Preference.c m() {
        return this.K;
    }

    @Override // java.lang.Comparable
    public java.lang.CharSequence n() {
        return this.x;
    }

    @Override // java.lang.Comparable
    public boolean o() {
        return empty ^= 1;
    }

    @Override // java.lang.Comparable
    public boolean p() {
        int i;
        boolean z;
        if (this.B && this.F && this.G) {
            if (this.F) {
                i = this.G ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // java.lang.Comparable
    public boolean q() {
        return this.D;
    }

    @Override // java.lang.Comparable
    protected void r() {
        final androidx.preference.Preference.a aVar = this.I;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    @Override // java.lang.Comparable
    public void s(boolean z) {
        int i;
        Object obj;
        final List list = this.J;
        if (list == null) {
        }
        i = 0;
        while (i < list.size()) {
            (Preference)list.get(i).t(this, z);
            i++;
        }
    }

    @Override // java.lang.Comparable
    public void t(androidx.preference.Preference preference, boolean z2) {
        boolean obj1;
        if (this.F == z2) {
            this.F = z2 ^ 1;
            s(y());
            r();
        }
    }

    @Override // java.lang.Comparable
    public String toString() {
        return f().toString();
    }

    @Override // java.lang.Comparable
    protected Object u(TypedArray typedArray, int i2) {
        return null;
    }

    @Override // java.lang.Comparable
    public void v(androidx.preference.Preference preference, boolean z2) {
        boolean obj1;
        if (this.G == z2) {
            this.G = z2 ^ 1;
            s(y());
            r();
        }
    }

    @Override // java.lang.Comparable
    protected boolean w(boolean z) {
        if (!z()) {
            return 0;
        }
        final int i2 = 1;
        if (z == i(z ^ 1)) {
            return i2;
        }
        androidx.preference.a aVar = j();
        if (aVar == null) {
        } else {
            aVar.b(this.z, z);
            return i2;
        }
        this.b.a();
        throw 0;
    }

    @Override // java.lang.Comparable
    public final void x(androidx.preference.Preference.c preference$c) {
        this.K = c;
        r();
    }

    @Override // java.lang.Comparable
    public boolean y() {
        return z ^= 1;
    }

    @Override // java.lang.Comparable
    protected boolean z() {
        int i;
        androidx.preference.b bVar;
        if (this.b != null && q() && o()) {
            if (q()) {
                i = o() ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }
}
