package d.p.b;

import android.content.Context;
import d.h.k.b;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public class b<D>  {

    int a;
    d.p.b.b.b<D> b;
    d.p.b.b.a<D> c;
    boolean d = false;
    boolean e = false;
    boolean f = true;
    boolean g = false;
    boolean h = false;

    public interface a {
        public abstract void a(d.p.b.b<D> b);
    }

    public interface b {
        public abstract void a(d.p.b.b<D> b, D d2);
    }
    public b(Context context) {
        super();
        final int i = 0;
        final int i2 = 1;
        context.getApplicationContext();
    }

    public void a() {
        this.e = true;
        j();
    }

    public boolean b() {
        return k();
    }

    public void c() {
        this.h = false;
    }

    public String d(D d) {
        StringBuilder stringBuilder = new StringBuilder(64);
        b.a(d, stringBuilder);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void e() {
        final d.p.b.b.a aVar = this.c;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public void f(D d) {
        final d.p.b.b.b bVar = this.b;
        if (bVar != null) {
            bVar.a(this, d);
        }
    }

    @Deprecated
    public void g(String string, FileDescriptor fileDescriptor2, PrintWriter printWriter3, String[] string4Arr4) {
        boolean obj1;
        boolean obj2;
        printWriter3.print(string);
        printWriter3.print("mId=");
        printWriter3.print(this.a);
        printWriter3.print(" mListener=");
        printWriter3.println(this.b);
        if (!this.d && !this.g) {
            if (!this.g) {
                if (this.h) {
                    printWriter3.print(string);
                    printWriter3.print("mStarted=");
                    printWriter3.print(this.d);
                    printWriter3.print(" mContentChanged=");
                    printWriter3.print(this.g);
                    printWriter3.print(" mProcessingChange=");
                    printWriter3.println(this.h);
                }
            } else {
            }
        } else {
        }
        if (!this.e) {
            if (this.f) {
                printWriter3.print(string);
                printWriter3.print("mAbandoned=");
                printWriter3.print(this.e);
                printWriter3.print(" mReset=");
                printWriter3.println(this.f);
            }
        } else {
        }
    }

    public void h() {
        m();
    }

    public boolean i() {
        return this.e;
    }

    protected void j() {
    }

    protected boolean k() {
        throw 0;
    }

    public void l() {
        boolean z;
        if (this.d) {
            h();
        } else {
            this.g = true;
        }
    }

    protected void m() {
    }

    protected void n() {
    }

    protected void o() {
        throw 0;
    }

    protected void p() {
    }

    public void q(int i, d.p.b.b.b<D> b$b2) {
        if (this.b != null) {
        } else {
            this.b = b2;
            this.a = i;
        }
        IllegalStateException obj2 = new IllegalStateException("There is already a listener registered");
        throw obj2;
    }

    public void r() {
        n();
        this.f = true;
        int i2 = 0;
        this.d = i2;
        this.e = i2;
        this.g = i2;
        this.h = i2;
    }

    public void s() {
        if (this.h) {
            l();
        }
    }

    public final void t() {
        this.d = true;
        int i2 = 0;
        this.f = i2;
        this.e = i2;
        o();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        b.a(this, stringBuilder);
        stringBuilder.append(" id=");
        stringBuilder.append(this.a);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void u() {
        this.d = false;
        p();
    }

    public void v(d.p.b.b.b<D> b$b) {
        d.p.b.b.b bVar = this.b;
        if (bVar == null) {
        } else {
            if (bVar != b) {
            } else {
                this.b = 0;
            }
            IllegalArgumentException obj2 = new IllegalArgumentException("Attempting to unregister the wrong listener");
            throw obj2;
        }
        obj2 = new IllegalStateException("No listener register");
        throw obj2;
    }
}
