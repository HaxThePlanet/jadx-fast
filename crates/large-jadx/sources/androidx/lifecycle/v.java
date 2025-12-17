package androidx.lifecycle;

import d.b.a.b.b;
import java.util.Iterator;
import java.util.Map.Entry;

/* loaded from: classes.dex */
public class v<T>  extends androidx.lifecycle.x<T> {

    private b<androidx.lifecycle.LiveData<?>, androidx.lifecycle.v.a<?>> a;

    private static class a implements androidx.lifecycle.y<V> {

        final androidx.lifecycle.LiveData<V> a;
        final androidx.lifecycle.y<? super V> b;
        int c = -1;
        a(androidx.lifecycle.LiveData<V> liveData, androidx.lifecycle.y<? super V> y2) {
            super();
            final int i = -1;
            this.a = liveData;
            this.b = y2;
        }

        @Override // androidx.lifecycle.y
        void a() {
            this.a.observeForever(this);
        }

        @Override // androidx.lifecycle.y
        void b() {
            this.a.removeObserver(this);
        }

        public void onChanged(V v) {
            int i;
            if (this.c != this.a.getVersion()) {
                this.c = this.a.getVersion();
                this.b.onChanged(v);
            }
        }
    }
    public v() {
        super();
        b bVar = new b();
        this.a = bVar;
    }

    public <S> void b(androidx.lifecycle.LiveData<S> liveData, androidx.lifecycle.y<? super S> y2) {
        Object bVar;
        v.a aVar = new v.a(liveData, y2);
        Object obj3 = this.a.l(liveData, aVar);
        if ((v.a)obj3 != null) {
            if (obj3.b != y2) {
            } else {
            }
            obj3 = new IllegalArgumentException("This source was already added with the different observer");
            throw obj3;
        }
        if ((v.a)obj3 != null) {
        }
        if (hasActiveObservers()) {
            aVar.a();
        }
    }

    @Override // androidx.lifecycle.x
    protected void onActive() {
        Object value;
        Iterator iterator = this.a.iterator();
        for (Map.Entry next2 : iterator) {
            (v.a)next2.getValue().a();
        }
    }

    @Override // androidx.lifecycle.x
    protected void onInactive() {
        Object value;
        Iterator iterator = this.a.iterator();
        for (Map.Entry next2 : iterator) {
            (v.a)next2.getValue().b();
        }
    }
}
