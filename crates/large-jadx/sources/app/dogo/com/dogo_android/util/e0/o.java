package app.dogo.com.dogo_android.util.e0;

import androidx.databinding.c;
import androidx.databinding.h;
import androidx.databinding.h.a;
import androidx.databinding.j;

/* loaded from: classes.dex */
public abstract class o implements h {

    private final j registry;
    public o() {
        super();
        j jVar = new j();
        this.registry = jVar;
    }

    @Override // androidx.databinding.h
    public void addOnPropertyChangedCallback(h.a h$a) {
        this.registry.a(a);
    }

    @Override // androidx.databinding.h
    public void notifyChange(int i) {
        this.registry.m(this, i);
    }

    @Override // androidx.databinding.h
    public void notifyChangeAll() {
        this.registry.d(this, 0, 0);
    }

    @Override // androidx.databinding.h
    public void notifyModelChange() {
        notifyChangeAll();
    }

    @Override // androidx.databinding.h
    public void removeOnPropertyChangedCallback(h.a h$a) {
        this.registry.j(a);
    }
}
