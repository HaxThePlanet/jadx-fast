package androidx.lifecycle;

/* loaded from: classes.dex */
class CompositeGeneratedAdaptersObserver implements androidx.lifecycle.n {

    private final androidx.lifecycle.h[] a;
    CompositeGeneratedAdaptersObserver(androidx.lifecycle.h[] hArr) {
        super();
        this.a = hArr;
    }

    @Override // androidx.lifecycle.n
    public void c(androidx.lifecycle.q q, androidx.lifecycle.j.b j$b2) {
        int i2;
        int i;
        androidx.lifecycle.h hVar;
        w wVar = new w();
        androidx.lifecycle.h[] objArr = this.a;
        i2 = 0;
        i = i2;
        while (i < objArr.length) {
            objArr[i].callMethods(q, b2, i2, wVar);
            i++;
        }
        androidx.lifecycle.h[] objArr2 = this.a;
        while (i2 < objArr2.length) {
            objArr2[i2].callMethods(q, b2, true, wVar);
            i2++;
        }
    }
}
