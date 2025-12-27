package app.dogo.com.dogo_android.s.b;

import java.util.Comparator;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class d implements Comparator {

    public final /* synthetic */ String a;
    public /* synthetic */ d(String str) {
        super();
        this.a = str;
    }

    @Override // java.util.Comparator
    public final int compare(Object object, Object object2) {
        return BreedRepository.c(this.a, object, object2);
    }
}
