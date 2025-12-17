package app.dogo.com.dogo_android.s.b;

import java.util.Comparator;

/* loaded from: classes.dex */
public final class d implements Comparator {

    public final String a;
    public d(String string) {
        super();
        this.a = string;
    }

    @Override // java.util.Comparator
    public final int compare(Object object, Object object2) {
        return z0.g(this.a, (DogBreed)object, (DogBreed)object2);
    }
}
