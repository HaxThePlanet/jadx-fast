package app.dogo.com.dogo_android.s.b;

import app.dogo.android.persistencedb.room.entity.DogLocalEntity;
import i.b.l0.n;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class x0 implements n {

    public final /* synthetic */ DogLocalEntity a;
    public final /* synthetic */ p1 b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String v;
    public /* synthetic */ x0(DogLocalEntity dogLocalEntity, p1 p1Var, String str, String str2) {
        super();
        this.a = dogLocalEntity;
        this.b = p1Var;
        this.c = str;
        this.v = str2;
    }

    public final Object apply(Object object) {
        return UserRepository.i(this.a, this.b, this.c, this.v, object);
    }
}
