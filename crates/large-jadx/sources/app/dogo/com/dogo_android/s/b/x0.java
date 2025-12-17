package app.dogo.com.dogo_android.s.b;

import app.dogo.android.persistencedb.room.entity.DogLocalEntity;
import i.b.l0.n;

/* loaded from: classes.dex */
public final class x0 implements n {

    public final DogLocalEntity a;
    public final app.dogo.com.dogo_android.s.b.p1 b;
    public final String c;
    public final String v;
    public x0(DogLocalEntity dogLocalEntity, app.dogo.com.dogo_android.s.b.p1 p12, String string3, String string4) {
        super();
        this.a = dogLocalEntity;
        this.b = p12;
        this.c = string3;
        this.v = string4;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        return p1.a0(this.a, this.b, this.c, this.v, (Boolean)object);
    }
}
