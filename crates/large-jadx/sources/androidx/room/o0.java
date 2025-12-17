package androidx.room;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.CancellationSignal;
import android.util.Pair;
import d.s.a.g;
import d.s.a.j;
import d.s.a.k;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
final class o0 implements g {

    private final g a;
    private final androidx.room.u0.f b;
    private final Executor c;
    o0(g g, androidx.room.u0.f u0$f2, Executor executor3) {
        super();
        this.a = g;
        this.b = f2;
        this.c = executor3;
    }

    private void E() {
        this.b.a("TRANSACTION SUCCESSFUL", Collections.emptyList());
    }

    private void a() {
        this.b.a("BEGIN EXCLUSIVE TRANSACTION", Collections.emptyList());
    }

    private void e() {
        this.b.a("BEGIN DEFERRED TRANSACTION", Collections.emptyList());
    }

    private void i() {
        this.b.a("END TRANSACTION", Collections.emptyList());
    }

    private void k(String string) {
        ArrayList arrayList = new ArrayList(0);
        this.b.a(string, arrayList);
    }

    private void n(String string) {
        this.b.a(string, Collections.emptyList());
    }

    private void q(j j, androidx.room.r0 r02) {
        this.b.a(j.a(), r02.a());
    }

    private void w(j j, androidx.room.r0 r02) {
        this.b.a(j.a(), r02.a());
    }

    @Override // d.s.a.g
    public void C(String string) {
        m mVar = new m(this, string);
        this.c.execute(mVar);
        this.a.C(string);
    }

    @Override // d.s.a.g
    public void F() {
        E();
    }

    @Override // d.s.a.g
    public boolean F1() {
        return this.a.F1();
    }

    @Override // d.s.a.g
    public Cursor H0(String string) {
        o oVar = new o(this, string);
        this.c.execute(oVar);
        return this.a.H0(string);
    }

    @Override // d.s.a.g
    public k O(String string) {
        s0 s0Var = new s0(this.a.O(string), this.b, string, this.c);
        return s0Var;
    }

    @Override // d.s.a.g
    public long P0(String string, int i2, ContentValues contentValues3) {
        return this.a.P0(string, i2, contentValues3);
    }

    @Override // d.s.a.g
    public void beginTransaction() {
        q qVar = new q(this);
        this.c.execute(qVar);
        this.a.beginTransaction();
    }

    @Override // d.s.a.g
    public void c() {
        a();
    }

    @Override // d.s.a.g
    public void close() {
        this.a.close();
    }

    @Override // d.s.a.g
    public void endTransaction() {
        j jVar = new j(this);
        this.c.execute(jVar);
        this.a.endTransaction();
    }

    @Override // d.s.a.g
    public void f() {
        e();
    }

    @Override // d.s.a.g
    public Cursor f0(j j, CancellationSignal cancellationSignal2) {
        r0 obj4 = new r0();
        j.c(obj4);
        p pVar = new p(this, j, obj4);
        this.c.execute(pVar);
        return this.a.j1(j);
    }

    @Override // d.s.a.g
    public String getPath() {
        return this.a.getPath();
    }

    @Override // d.s.a.g
    public boolean isOpen() {
        return this.a.isOpen();
    }

    @Override // d.s.a.g
    public void j() {
        i();
    }

    @Override // d.s.a.g
    public Cursor j1(j j) {
        r0 r0Var = new r0();
        j.c(r0Var);
        n nVar = new n(this, j, r0Var);
        this.c.execute(nVar);
        return this.a.j1(j);
    }

    @Override // d.s.a.g
    public void m(String string) {
        k(string);
    }

    @Override // d.s.a.g
    public void o(String string) {
        n(string);
    }

    @Override // d.s.a.g
    public boolean q1() {
        return this.a.q1();
    }

    @Override // d.s.a.g
    public void r(j j, androidx.room.r0 r02) {
        q(j, r02);
    }

    @Override // d.s.a.g
    public void setTransactionSuccessful() {
        l lVar = new l(this);
        this.c.execute(lVar);
        this.a.setTransactionSuccessful();
    }

    @Override // d.s.a.g
    public void setVersion(int i) {
        this.a.setVersion(i);
    }

    @Override // d.s.a.g
    public void x(j j, androidx.room.r0 r02) {
        w(j, r02);
    }

    @Override // d.s.a.g
    public void x0() {
        k kVar = new k(this);
        this.c.execute(kVar);
        this.a.x0();
    }

    @Override // d.s.a.g
    public int y0(String string, int i2, ContentValues contentValues3, String string4, Object[] object5Arr5) {
        return this.a.y0(string, i2, contentValues3, string4, object5Arr5);
    }

    public List<Pair<String, String>> z() {
        return this.a.z();
    }
}
