package app.dogo.com.dogo_android.repository.domain;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0011\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0008\u0018\u00002\u00020\u0001B1\u0012\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0006\u0010\u0013\u001a\u00020\nJ\u000f\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0008HÆ\u0003J\t\u0010\u0017\u001a\u00020\nHÆ\u0003J9\u0010\u0018\u001a\u00020\u00002\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00032\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\n2\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0017\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\t\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\u0010R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012¨\u0006\u001f", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/ProgramExamList;", "", "examList", "", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExam;", "programExamSummary", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExamSummary;", "dogProfile", "Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "isDogPremium", "", "(Ljava/util/List;Lapp/dogo/com/dogo_android/repository/domain/ProgramExamSummary;Lapp/dogo/com/dogo_android/repository/domain/DogProfile;Z)V", "getDogProfile", "()Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "getExamList", "()Ljava/util/List;", "()Z", "getProgramExamSummary", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramExamSummary;", "allExamsViewedByUser", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ProgramExamList {

    private final app.dogo.com.dogo_android.repository.domain.DogProfile dogProfile;
    private final List<app.dogo.com.dogo_android.repository.domain.ProgramExam> examList;
    private final boolean isDogPremium;
    private final app.dogo.com.dogo_android.repository.domain.ProgramExamSummary programExamSummary;
    public ProgramExamList(List<app.dogo.com.dogo_android.repository.domain.ProgramExam> list, app.dogo.com.dogo_android.repository.domain.ProgramExamSummary programExamSummary2, app.dogo.com.dogo_android.repository.domain.DogProfile dogProfile3, boolean z4) {
        n.f(list, "examList");
        n.f(dogProfile3, "dogProfile");
        super();
        this.examList = list;
        this.programExamSummary = programExamSummary2;
        this.dogProfile = dogProfile3;
        this.isDogPremium = z4;
    }

    public ProgramExamList(List list, app.dogo.com.dogo_android.repository.domain.ProgramExamSummary programExamSummary2, app.dogo.com.dogo_android.repository.domain.DogProfile dogProfile3, boolean z4, int i5, g g6) {
        List obj1;
        int obj2;
        if (i5 & 1 != 0) {
            obj1 = p.g();
        }
        obj2 = i5 &= 2 != 0 ? 0 : obj2;
        super(obj1, obj2, dogProfile3, z4);
    }

    public static app.dogo.com.dogo_android.repository.domain.ProgramExamList copy$default(app.dogo.com.dogo_android.repository.domain.ProgramExamList programExamList, List list2, app.dogo.com.dogo_android.repository.domain.ProgramExamSummary programExamSummary3, app.dogo.com.dogo_android.repository.domain.DogProfile dogProfile4, boolean z5, int i6, Object object7) {
        List obj1;
        app.dogo.com.dogo_android.repository.domain.ProgramExamSummary obj2;
        app.dogo.com.dogo_android.repository.domain.DogProfile obj3;
        boolean obj4;
        if (i6 & 1 != 0) {
            obj1 = programExamList.examList;
        }
        if (i6 & 2 != 0) {
            obj2 = programExamList.programExamSummary;
        }
        if (i6 & 4 != 0) {
            obj3 = programExamList.dogProfile;
        }
        if (i6 &= 8 != 0) {
            obj4 = programExamList.isDogPremium;
        }
        return programExamList.copy(obj1, obj2, obj3, obj4);
    }

    public final boolean allExamsViewedByUser() {
        Object examList;
        boolean empty;
        int i;
        Boolean tRUE;
        examList = this.examList;
        i = 1;
        if (examList instanceof Collection != null && examList.isEmpty()) {
            if (examList.isEmpty()) {
            } else {
                examList = examList.iterator();
                while (examList.hasNext()) {
                    if (n.b((ProgramExam)examList.next().getHasNewUpdates(), Boolean.TRUE)) {
                        break;
                    } else {
                    }
                }
            }
        } else {
        }
        return i;
    }

    public final List<app.dogo.com.dogo_android.repository.domain.ProgramExam> component1() {
        return this.examList;
    }

    public final app.dogo.com.dogo_android.repository.domain.ProgramExamSummary component2() {
        return this.programExamSummary;
    }

    public final app.dogo.com.dogo_android.repository.domain.DogProfile component3() {
        return this.dogProfile;
    }

    public final boolean component4() {
        return this.isDogPremium;
    }

    public final app.dogo.com.dogo_android.repository.domain.ProgramExamList copy(List<app.dogo.com.dogo_android.repository.domain.ProgramExam> list, app.dogo.com.dogo_android.repository.domain.ProgramExamSummary programExamSummary2, app.dogo.com.dogo_android.repository.domain.DogProfile dogProfile3, boolean z4) {
        n.f(list, "examList");
        n.f(dogProfile3, "dogProfile");
        ProgramExamList programExamList = new ProgramExamList(list, programExamSummary2, dogProfile3, z4);
        return programExamList;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (object instanceof ProgramExamList == null) {
            return i2;
        }
        if (!n.b(this.examList, object.examList)) {
            return i2;
        }
        if (!n.b(this.programExamSummary, object.programExamSummary)) {
            return i2;
        }
        if (n.b(this.dogProfile, object.dogProfile) == null) {
            return i2;
        }
        if (this.isDogPremium != object.isDogPremium) {
            return i2;
        }
        return i;
    }

    public final app.dogo.com.dogo_android.repository.domain.DogProfile getDogProfile() {
        return this.dogProfile;
    }

    public final List<app.dogo.com.dogo_android.repository.domain.ProgramExam> getExamList() {
        return this.examList;
    }

    public final app.dogo.com.dogo_android.repository.domain.ProgramExamSummary getProgramExamSummary() {
        return this.programExamSummary;
    }

    public int hashCode() {
        int i;
        boolean isDogPremium;
        app.dogo.com.dogo_android.repository.domain.ProgramExamSummary programExamSummary = this.programExamSummary;
        if (programExamSummary == null) {
            i = 0;
        } else {
            i = programExamSummary.hashCode();
        }
        if (this.isDogPremium) {
            isDogPremium = 1;
        }
        return i7 += isDogPremium;
    }

    public final boolean isDogPremium() {
        return this.isDogPremium;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ProgramExamList(examList=");
        stringBuilder.append(this.examList);
        stringBuilder.append(", programExamSummary=");
        stringBuilder.append(this.programExamSummary);
        stringBuilder.append(", dogProfile=");
        stringBuilder.append(this.dogProfile);
        stringBuilder.append(", isDogPremium=");
        stringBuilder.append(this.isDogPremium);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
