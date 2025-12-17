package app.dogo.com.dogo_android.n.m;

import app.dogo.com.dogo_android.repository.domain.LibrarySection;
import i.b.l0.n;

/* loaded from: classes.dex */
public final class g implements n {

    public final app.dogo.com.dogo_android.n.m.r a;
    public final LibrarySection b;
    public g(app.dogo.com.dogo_android.n.m.r r, LibrarySection librarySection2) {
        super();
        this.a = r;
        this.b = librarySection2;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        return r.v(this.a, this.b, (String)object);
    }
}
