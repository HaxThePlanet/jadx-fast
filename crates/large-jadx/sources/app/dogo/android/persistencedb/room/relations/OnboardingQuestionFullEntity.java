package e.a.a.a.b.d;

import app.dogo.android.persistencedb.room.entity.OnboardingAnswerEntity;
import app.dogo.android.persistencedb.room.entity.OnboardingQuestionEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: OnboardingQuestionFullEntity.kt */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0008\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u000c\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u000e\u0008\u0002\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u001c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000b¨\u0006\u0016", d2 = {"Lapp/dogo/android/persistencedb/room/relations/OnboardingQuestionFullEntity;", "", "question", "Lapp/dogo/android/persistencedb/room/entity/OnboardingQuestionEntity;", "answers", "", "Lapp/dogo/android/persistencedb/room/entity/OnboardingAnswerEntity;", "(Lapp/dogo/android/persistencedb/room/entity/OnboardingQuestionEntity;Ljava/util/List;)V", "getAnswers", "()Ljava/util/List;", "getQuestion", "()Lapp/dogo/android/persistencedb/room/entity/OnboardingQuestionEntity;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: d, reason: from kotlin metadata */
public final /* data */ class OnboardingQuestionFullEntity {

    private final OnboardingQuestionEntity a;
    private final List<OnboardingAnswerEntity> b;
    public d(OnboardingQuestionEntity onboardingQuestionEntity, List<OnboardingAnswerEntity> list) {
        n.f(onboardingQuestionEntity, "question");
        n.f(list, "answers");
        super();
        this.a = onboardingQuestionEntity;
        this.b = list;
    }

    /* renamed from: a, reason: from kotlin metadata */
    /* operator */ public final List<OnboardingAnswerEntity> component1() {
        return this.b;
    }

    public final OnboardingQuestionEntity b() {
        return this.a;
    }

    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z4 = false;
        if (!(other instanceof OnboardingQuestionFullEntity)) {
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
        String str2 = "OnboardingQuestionFullEntity(question=";
        String str3 = ", answers=";
        str = str2 + this.a + str3 + this.b + 41;
        return str;
    }
}
