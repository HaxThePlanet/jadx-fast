package app.dogo.com.dogo_android.repository.domain;

import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: DashboardProgram.kt */
@Metadata(d1 = "\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0012\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008\u0086\u0008\u0018\u00002\u00020\u0001:\u0001$B=\u0012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010\u001b\u001a\u00020\u000bHÆ\u0003JC\u0010\u001c\u001a\u00020\u00002\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\u0008\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0013\u0010\u0008\u001a\u0004\u0018\u00010\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016¨\u0006%", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/DashboardProgram;", "", "lessonItem", "Lapp/dogo/com/dogo_android/repository/domain/ProgramLessonItem;", "programDescriptionItem", "Lapp/dogo/com/dogo_android/repository/domain/ProgramDescriptionItem;", "programExamSummary", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExamSummary;", "programCompletionSummary", "Lapp/dogo/com/dogo_android/repository/domain/ProgramCompletionSummary;", "type", "Lapp/dogo/com/dogo_android/repository/domain/DashboardProgram$CardType;", "(Lapp/dogo/com/dogo_android/repository/domain/ProgramLessonItem;Lapp/dogo/com/dogo_android/repository/domain/ProgramDescriptionItem;Lapp/dogo/com/dogo_android/repository/domain/ProgramExamSummary;Lapp/dogo/com/dogo_android/repository/domain/ProgramCompletionSummary;Lapp/dogo/com/dogo_android/repository/domain/DashboardProgram$CardType;)V", "getLessonItem", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramLessonItem;", "getProgramCompletionSummary", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramCompletionSummary;", "getProgramDescriptionItem", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramDescriptionItem;", "getProgramExamSummary", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramExamSummary;", "getType", "()Lapp/dogo/com/dogo_android/repository/domain/DashboardProgram$CardType;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "", "CardType", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class DashboardProgram {

    private final ProgramLessonItem lessonItem;
    private final ProgramCompletionSummary programCompletionSummary;
    private final ProgramDescriptionItem programDescriptionItem;
    private final ProgramExamSummary programExamSummary;
    private final DashboardProgram.CardType type;

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0007\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004j\u0002\u0008\u0005j\u0002\u0008\u0006j\u0002\u0008\u0007¨\u0006\u0008", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/DashboardProgram$CardType;", "", "(Ljava/lang/String;I)V", "RECOMMENDED_PROGRAM", "QUESTIONNAIRE", "LESSON", "PROGRAM_COMPLETED", "RECOMMENDED_PROGRAM_V2", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum CardType {

        LESSON,
        PROGRAM_COMPLETED,
        QUESTIONNAIRE,
        RECOMMENDED_PROGRAM,
        RECOMMENDED_PROGRAM_V2;
        private static final /* synthetic */ DashboardProgram.CardType[] $values() {
            app.dogo.com.dogo_android.repository.domain.DashboardProgram.CardType[] arr = new DashboardProgram.CardType[5];
            return new DashboardProgram.CardType[] { DashboardProgram_CardType.RECOMMENDED_PROGRAM, DashboardProgram_CardType.QUESTIONNAIRE, DashboardProgram_CardType.LESSON, DashboardProgram_CardType.PROGRAM_COMPLETED, DashboardProgram_CardType.RECOMMENDED_PROGRAM_V2 };
        }
    }
    public DashboardProgram(ProgramLessonItem programLessonItem, ProgramDescriptionItem programDescriptionItem, ProgramExamSummary programExamSummary, ProgramCompletionSummary programCompletionSummary, DashboardProgram.CardType cardType) {
        n.f(cardType, "type");
        super();
        this.lessonItem = programLessonItem;
        this.programDescriptionItem = programDescriptionItem;
        this.programExamSummary = programExamSummary;
        this.programCompletionSummary = programCompletionSummary;
        this.type = cardType;
    }

    public final ProgramLessonItem getLessonItem() {
        return this.lessonItem;
    }

    public final ProgramCompletionSummary getProgramCompletionSummary() {
        return this.programCompletionSummary;
    }

    public final ProgramDescriptionItem getProgramDescriptionItem() {
        return this.programDescriptionItem;
    }

    public final ProgramExamSummary getProgramExamSummary() {
        return this.programExamSummary;
    }

    public final DashboardProgram.CardType getType() {
        return this.type;
    }

    public /* synthetic */ DashboardProgram(ProgramLessonItem programLessonItem, ProgramDescriptionItem programDescriptionItem, ProgramExamSummary programExamSummary, ProgramCompletionSummary programCompletionSummary, DashboardProgram.CardType cardType, int i, g gVar) {
        app.dogo.com.dogo_android.repository.domain.ProgramLessonItem programLessonItem2;
        app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem programDescriptionItem22;
        app.dogo.com.dogo_android.repository.domain.ProgramExamSummary programExamSummary32;
        app.dogo.com.dogo_android.repository.domain.ProgramCompletionSummary programCompletionSummary42;
        i = 0;
        int r2 = i & 1 != 0 ? i : programLessonItem;
        int r3 = i & 2 != 0 ? i : programDescriptionItem;
        int r4 = i & 4 != 0 ? i : programExamSummary;
        int r5 = i & 8 != 0 ? i : programCompletionSummary;
        this(programLessonItem2, programDescriptionItem22, programExamSummary32, (i & 8 != 0 ? i : programCompletionSummary), cardType);
    }

    public static /* synthetic */ DashboardProgram copy$default(DashboardProgram dashboardProgram, ProgramLessonItem programLessonItem, ProgramDescriptionItem programDescriptionItem, ProgramExamSummary programExamSummary, ProgramCompletionSummary programCompletionSummary, DashboardProgram.CardType cardType, int i, Object object) {
        app.dogo.com.dogo_android.repository.domain.ProgramLessonItem programLessonItem22;
        app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem object82;
        app.dogo.com.dogo_android.repository.domain.ProgramExamSummary programExamSummary42;
        app.dogo.com.dogo_android.repository.domain.ProgramCompletionSummary programCompletionSummary52;
        app.dogo.com.dogo_android.repository.domain.DashboardProgram.CardType cardType62;
        if (i & 1 != 0) {
        }
        if (i & 2 != 0) {
        }
        if (i & 4 != 0) {
        }
        if (i & 8 != 0) {
        }
        if (i & 16 != 0) {
        }
        return dashboardProgram.copy(programLessonItem22, object82, programExamSummary42, programCompletionSummary52, cardType62);
    }

    /* operator */ public final ProgramLessonItem component1() {
        return this.lessonItem;
    }

    /* operator */ public final ProgramDescriptionItem component2() {
        return this.programDescriptionItem;
    }

    /* operator */ public final ProgramExamSummary component3() {
        return this.programExamSummary;
    }

    /* operator */ public final ProgramCompletionSummary component4() {
        return this.programCompletionSummary;
    }

    /* operator */ public final DashboardProgram.CardType component5() {
        return this.type;
    }

    public final DashboardProgram copy(ProgramLessonItem lessonItem, ProgramDescriptionItem programDescriptionItem, ProgramExamSummary programExamSummary, ProgramCompletionSummary programCompletionSummary, DashboardProgram.CardType type) {
        n.f(type, "type");
        DashboardProgram dashboardProgram = new DashboardProgram(lessonItem, programDescriptionItem, programExamSummary, programCompletionSummary, type);
        return dashboardProgram;
    }

    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z7 = false;
        if (!(other instanceof DashboardProgram)) {
            return false;
        }
        if (!n.b(this.lessonItem, other.lessonItem)) {
            return false;
        }
        if (!n.b(this.programDescriptionItem, other.programDescriptionItem)) {
            return false;
        }
        if (!n.b(this.programExamSummary, other.programExamSummary)) {
            return false;
        }
        if (!n.b(this.programCompletionSummary, other.programCompletionSummary)) {
            return false;
        }
        return this.type != other.type ? z7 : z;
    }

    public int hashCode() {
        int i;
        i = 0;
        if (this.lessonItem == null) {
        } else {
            i = this.lessonItem.hashCode();
        }
        if (this.programDescriptionItem == null) {
        } else {
            i = this.programDescriptionItem.hashCode();
        }
        if (this.programExamSummary == null) {
        } else {
            i = this.programExamSummary.hashCode();
        }
        if (this.programCompletionSummary != null) {
            i = this.programCompletionSummary.hashCode();
        }
        return (i * 31) + i * 31 + i * 31 + i * 31 + this.type.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "DashboardProgram(lessonItem=";
        String str3 = ", programDescriptionItem=";
        String str4 = ", programExamSummary=";
        String str5 = ", programCompletionSummary=";
        String str6 = ", type=";
        str = str2 + this.lessonItem + str3 + this.programDescriptionItem + str4 + this.programExamSummary + str5 + this.programCompletionSummary + str6 + this.type + 41;
        return str;
    }
}
