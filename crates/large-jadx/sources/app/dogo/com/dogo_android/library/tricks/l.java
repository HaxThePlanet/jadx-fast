package app.dogo.com.dogo_android.n.m;

import app.dogo.com.dogo_android.repository.domain.LibrarySection;
import i.b.l0.n;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class l implements n {

    public final /* synthetic */ String a;
    public final /* synthetic */ LibrarySection b;
    public /* synthetic */ l(String str, LibrarySection librarySection) {
        super();
        this.a = str;
        this.b = librarySection;
    }

    public final Object apply(Object object) {
        return TrickListViewModel.H(this.a, this.b, object);
    }
}
