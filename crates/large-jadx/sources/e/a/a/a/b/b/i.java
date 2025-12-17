package e.a.a.a.b.b;

import app.dogo.android.persistencedb.room.entity.TrickProgressEntity.TrickKnowledgeRateData;
import i.b.l0.n;

/* loaded from: classes.dex */
public final class i implements n {

    public final e.a.a.a.b.b.o0 a;
    public final TrickProgressEntity.TrickKnowledgeRateData b;
    public i(e.a.a.a.b.b.o0 o0, TrickProgressEntity.TrickKnowledgeRateData trickProgressEntity$TrickKnowledgeRateData2) {
        super();
        this.a = o0;
        this.b = trickKnowledgeRateData2;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        return o0.a.f(this.a, this.b, (Boolean)object);
    }
}
