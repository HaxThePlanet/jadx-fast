package app.dogo.com.dogo_android.repository.domain;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.y.p;

/* compiled from: ProgramExamList.kt */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0011\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0008\u0018\u00002\u00020\u0001B1\u0012\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0006\u0010\u0013\u001a\u00020\nJ\u000f\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0008HÆ\u0003J\t\u0010\u0017\u001a\u00020\nHÆ\u0003J9\u0010\u0018\u001a\u00020\u00002\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00032\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\n2\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0017\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\t\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\u0010R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012¨\u0006\u001f", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/ProgramExamList;", "", "examList", "", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExam;", "programExamSummary", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExamSummary;", "dogProfile", "Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "isDogPremium", "", "(Ljava/util/List;Lapp/dogo/com/dogo_android/repository/domain/ProgramExamSummary;Lapp/dogo/com/dogo_android/repository/domain/DogProfile;Z)V", "getDogProfile", "()Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "getExamList", "()Ljava/util/List;", "()Z", "getProgramExamSummary", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramExamSummary;", "allExamsViewedByUser", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class ProgramExamList {

    private final DogProfile dogProfile;
    private final List<ProgramExam> examList;
    private final boolean isDogPremium;
    private final ProgramExamSummary programExamSummary;
    public ProgramExamList(List<ProgramExam> list, ProgramExamSummary programExamSummary, DogProfile dogProfile, boolean z) {
        n.f(list, "examList");
        n.f(dogProfile, "dogProfile");
        super();
        this.examList = list;
        this.programExamSummary = programExamSummary;
        this.dogProfile = dogProfile;
        this.isDogPremium = z;
    }

    public final boolean allExamsViewedByUser() {
        boolean hasNext;
        boolean z = true;
        Boolean tRUE2;
        hasNext = examList2 instanceof Collection;
        int i = 1;
        if (!(examList2 instanceof Collection) || !this.examList.isEmpty()) {
            Iterator it = this.examList.iterator();
            while (it.hasNext()) {
                if (n.b((ProgramExam)it.next().getHasNewUpdates(), Boolean.TRUE)) {
                    int i2 = 0;
                }
            }
        }
        return z;
    }

    public final DogProfile getDogProfile() {
        return this.dogProfile;
    }

    public final List<ProgramExam> getExamList() {
        return this.examList;
    }

    public final ProgramExamSummary getProgramExamSummary() {
        return this.programExamSummary;
    }

    public final boolean isDogPremium() {
        return this.isDogPremium;
    }

    public /* synthetic */ ProgramExamList(List list, ProgramExamSummary programExamSummary, DogProfile dogProfile, boolean z, int i, g gVar) {
        List list2;
        if (i & 1 != 0) {
            list2 = p.g();
        }
        i = i & 2 != 0 ? 0 : i;
        this(list2, programExamSummary, dogProfile, z);
    }

    public static /* synthetic */ ProgramExamList copy$default(ProgramExamList list, List list2, ProgramExamSummary programExamSummary, DogProfile dogProfile, boolean z, int i, Object object) {
        List examList2;
        app.dogo.com.dogo_android.repository.domain.ProgramExamSummary programExamSummary2;
        app.dogo.com.dogo_android.repository.domain.DogProfile dogProfile2;
        boolean isDogPremium2;
        if (i & 1 != 0) {
        }
        if (i & 2 != 0) {
        }
        if (i & 4 != 0) {
        }
        if (i & 8 != 0) {
        }
        return list.copy(examList2, programExamSummary2, dogProfile2, isDogPremium2);
    }

    /* operator */ public final List<ProgramExam> component1() {
        return this.examList;
    }

    /* operator */ public final ProgramExamSummary component2() {
        return this.programExamSummary;
    }

    /* operator */ public final DogProfile component3() {
        return this.dogProfile;
    }

    /* operator */ public final boolean component4() {
        return this.isDogPremium;
    }

    public final ProgramExamList copy(List<ProgramExam> examList, ProgramExamSummary programExamSummary, DogProfile dogProfile, boolean isDogPremium) {
        n.f(examList, "examList");
        n.f(dogProfile, "dogProfile");
        return new ProgramExamList(examList, programExamSummary, dogProfile, isDogPremium);
    }

    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z6 = false;
        if (!(other instanceof ProgramExamList)) {
            return false;
        }
        if (!n.b(this.examList, other.examList)) {
            return false;
        }
        if (!n.b(this.programExamSummary, other.programExamSummary)) {
            return false;
        }
        if (n.b(this.dogProfile, other.dogProfile) == null) {
            return false;
        }
        return this.isDogPremium != other.isDogPremium ? z6 : z;
    }

    public int hashCode() {
        int i = 0;
        boolean isDogPremium2 = true;
        if (this.programExamSummary == null) {
            i = 0;
        } else {
            i = this.programExamSummary.hashCode();
        }
        if (this.isDogPremium) {
            int i10 = 1;
        }
        return (this.examList.hashCode() * 31) + i * 31 + this.dogProfile.hashCode() * 31 + isDogPremium2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "ProgramExamList(examList=";
        String str3 = ", programExamSummary=";
        String str4 = ", dogProfile=";
        String str5 = ", isDogPremium=";
        str = str2 + this.examList + str3 + this.programExamSummary + str4 + this.dogProfile + str5 + this.isDogPremium + 41;
        return str;
    }
}
