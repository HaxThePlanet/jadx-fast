package app.dogo.com.dogo_android.n.m;

import app.dogo.com.dogo_android.repository.domain.LibrarySection;
import i.b.l0.n;

/* loaded from: classes.dex */
public final class l implements n {

    public final String a;
    public final LibrarySection b;
    public l(String string, LibrarySection librarySection2) {
        super();
        this.a = string;
        this.b = librarySection2;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        return r.A(this.a, this.b, (Boolean)object);
    }
}
