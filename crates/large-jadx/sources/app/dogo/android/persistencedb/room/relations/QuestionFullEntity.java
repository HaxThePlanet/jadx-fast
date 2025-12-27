package e.a.a.a.b.d;

import app.dogo.android.persistencedb.room.entity.QuestionEntity;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: QuestionFullEntity.kt */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0008\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000c\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u0015", d2 = {"Lapp/dogo/android/persistencedb/room/relations/QuestionFullEntity;", "", "question", "Lapp/dogo/android/persistencedb/room/entity/QuestionEntity;", "article", "Lapp/dogo/android/persistencedb/room/relations/ArticleFullEntity;", "(Lapp/dogo/android/persistencedb/room/entity/QuestionEntity;Lapp/dogo/android/persistencedb/room/relations/ArticleFullEntity;)V", "getArticle", "()Lapp/dogo/android/persistencedb/room/relations/ArticleFullEntity;", "getQuestion", "()Lapp/dogo/android/persistencedb/room/entity/QuestionEntity;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: f, reason: from kotlin metadata */
public final /* data */ class QuestionFullEntity {

    private final QuestionEntity a;
    private final a b;
    public f(QuestionEntity questionEntity, a aVar) {
        n.f(questionEntity, "question");
        n.f(aVar, "article");
        super();
        this.a = questionEntity;
        this.b = aVar;
    }

    /* renamed from: a, reason: from kotlin metadata */
    /* operator */ public final a component1() {
        return this.b;
    }

    public final QuestionEntity b() {
        return this.a;
    }

    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z4 = false;
        if (!(other instanceof QuestionFullEntity)) {
            return false;
        }
        if (!n.b(this.a, other.a)) {
            return false;
        }
        return !n.b(this.b, other.b) ? z4 : z;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "QuestionFullEntity(question=";
        String str3 = ", article=";
        str = str2 + this.a + str3 + this.b + 41;
        return str;
    }
}
