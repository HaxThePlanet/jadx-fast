package e.a.a.a.b.b;

import app.dogo.android.persistencedb.room.entity.TrickProgressEntity.TrickKnowledgeViewData;
import i.b.l0.n;

/* loaded from: classes.dex */
public final class j implements n {

    public final e.a.a.a.b.b.o0 a;
    public final TrickProgressEntity.TrickKnowledgeViewData b;
    public j(e.a.a.a.b.b.o0 o0, TrickProgressEntity.TrickKnowledgeViewData trickProgressEntity$TrickKnowledgeViewData2) {
        super();
        this.a = o0;
        this.b = trickKnowledgeViewData2;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        return o0.a.g(this.a, this.b, (Boolean)object);
    }
}
