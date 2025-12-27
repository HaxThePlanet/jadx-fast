package app.dogo.com.dogo_android.util.e0;

import androidx.databinding.c;
import androidx.databinding.h;
import androidx.databinding.h.a;
import androidx.databinding.j;

/* compiled from: BaseFlexibleItemObservable.java */
/* loaded from: classes.dex */
public abstract class o implements h {

    private final j registry = new j();
    public o() {
        super();
        final j jVar = new j();
    }

    public void addOnPropertyChangedCallback(h.a aVar) {
        this.registry.a(aVar);
    }

    public void notifyChange(int i) {
        this.registry.m(this, i);
    }

    public void notifyChangeAll() {
        this.registry.d(this, 0, null);
    }

    public void notifyModelChange() {
        notifyChangeAll();
    }

    public void removeOnPropertyChangedCallback(h.a aVar) {
        this.registry.j(aVar);
    }
}
