package d.p.b;

import android.content.Context;
import d.h.k.b;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: Loader.java */
/* loaded from: classes.dex */
public class b<D> {

    int a;
    b.b<D> b;
    b.a<D> c;
    boolean d = false;
    boolean e = false;
    boolean f = true;
    boolean g = false;
    boolean h = false;

    public interface a<D> {
        void a(b<D> bVar);
    }

    public interface b<D> {
        void a(b<D> bVar, D d);
    }
    public b(Context context) {
        super();
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
        final StringBuilder stringBuilder = new StringBuilder(64);
        b.a(d, stringBuilder);
        String str = "}";
        str2 = 64 + str;
        return str2;
    }

    public void e() {
        if (this.c != null) {
            this.c.a(this);
        }
    }

    public void f(D d) {
        if (this.b != null) {
            this.b.a(this, d);
        }
    }

    @Deprecated
    public void g(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        boolean z3;
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.a);
        printWriter.print(" mListener=");
        printWriter.println(this.b);
        if (this.d || !this.g || this.h) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.d);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.g);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.h);
        }
        if (this.e || this.f) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.e);
            printWriter.print(" mReset=");
            printWriter.println(this.f);
        }
    }

    public void h() {
        m();
    }

    public boolean i() {
        return this.e;
    }

    public void l() {
        if (this.d) {
            h();
        } else {
            boolean z = true;
            this.g = z;
        }
    }

    public void q(int i, b.b<D> bVar) {
        if (this.b != null) {
            throw new IllegalStateException("There is already a listener registered");
        } else {
            this.b = bVar;
            this.a = i;
            return;
        }
    }

    public void r() {
        n();
        this.f = true;
        boolean z = false;
        this.d = z;
        this.e = z;
        this.g = z;
        this.h = z;
    }

    public void s() {
        if (this.h) {
            l();
        }
    }

    public final void t() {
        this.d = true;
        boolean z = false;
        this.f = z;
        this.e = z;
        o();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        b.a(this, stringBuilder);
        String str2 = " id=";
        String str3 = "}";
        str = 64 + str2 + this.a + str3;
        return str;
    }

    public void u() {
        this.d = false;
        p();
    }

    public void v(b.b<D> bVar) {
        if (this.b == null) {
            throw new IllegalStateException("No listener register");
        } else {
            if (this.b != bVar) {
                throw new IllegalArgumentException("Attempting to unregister the wrong listener");
            } else {
                this.b = null;
                return;
            }
        }
    }

    protected void j() {
    }

    protected boolean k() {
        /* Dexterity WARN: Type inference failed for thrown value */
        throw (Throwable) 0;
    }

    protected void m() {
    }

    protected void n() {
    }

    protected void o() {
        /* Dexterity WARN: Type inference failed for thrown value */
        throw (Throwable) 0;
    }

    protected void p() {
    }
}
