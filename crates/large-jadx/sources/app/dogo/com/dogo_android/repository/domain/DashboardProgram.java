package app.dogo.com.dogo_android.repository.domain;

import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0012\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008\u0086\u0008\u0018\u00002\u00020\u0001:\u0001$B=\u0012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010\u001b\u001a\u00020\u000bHÆ\u0003JC\u0010\u001c\u001a\u00020\u00002\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\u0008\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0013\u0010\u0008\u001a\u0004\u0018\u00010\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016¨\u0006%", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/DashboardProgram;", "", "lessonItem", "Lapp/dogo/com/dogo_android/repository/domain/ProgramLessonItem;", "programDescriptionItem", "Lapp/dogo/com/dogo_android/repository/domain/ProgramDescriptionItem;", "programExamSummary", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExamSummary;", "programCompletionSummary", "Lapp/dogo/com/dogo_android/repository/domain/ProgramCompletionSummary;", "type", "Lapp/dogo/com/dogo_android/repository/domain/DashboardProgram$CardType;", "(Lapp/dogo/com/dogo_android/repository/domain/ProgramLessonItem;Lapp/dogo/com/dogo_android/repository/domain/ProgramDescriptionItem;Lapp/dogo/com/dogo_android/repository/domain/ProgramExamSummary;Lapp/dogo/com/dogo_android/repository/domain/ProgramCompletionSummary;Lapp/dogo/com/dogo_android/repository/domain/DashboardProgram$CardType;)V", "getLessonItem", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramLessonItem;", "getProgramCompletionSummary", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramCompletionSummary;", "getProgramDescriptionItem", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramDescriptionItem;", "getProgramExamSummary", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramExamSummary;", "getType", "()Lapp/dogo/com/dogo_android/repository/domain/DashboardProgram$CardType;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "", "CardType", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DashboardProgram {

    private final app.dogo.com.dogo_android.repository.domain.ProgramLessonItem lessonItem;
    private final app.dogo.com.dogo_android.repository.domain.ProgramCompletionSummary programCompletionSummary;
    private final app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem programDescriptionItem;
    private final app.dogo.com.dogo_android.repository.domain.ProgramExamSummary programExamSummary;
    private final app.dogo.com.dogo_android.repository.domain.DashboardProgram.CardType type;

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0007\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004j\u0002\u0008\u0005j\u0002\u0008\u0006j\u0002\u0008\u0007¨\u0006\u0008", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/DashboardProgram$CardType;", "", "(Ljava/lang/String;I)V", "RECOMMENDED_PROGRAM", "QUESTIONNAIRE", "LESSON", "PROGRAM_COMPLETED", "RECOMMENDED_PROGRAM_V2", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static enum CardType {

        RECOMMENDED_PROGRAM,
        QUESTIONNAIRE,
        LESSON,
        PROGRAM_COMPLETED,
        RECOMMENDED_PROGRAM_V2;
        private static final app.dogo.com.dogo_android.repository.domain.DashboardProgram.CardType[] $values() {
            app.dogo.com.dogo_android.repository.domain.DashboardProgram.CardType[] arr = new DashboardProgram.CardType[5];
            return arr;
        }
    }
    public DashboardProgram(app.dogo.com.dogo_android.repository.domain.ProgramLessonItem programLessonItem, app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem programDescriptionItem2, app.dogo.com.dogo_android.repository.domain.ProgramExamSummary programExamSummary3, app.dogo.com.dogo_android.repository.domain.ProgramCompletionSummary programCompletionSummary4, app.dogo.com.dogo_android.repository.domain.DashboardProgram.CardType dashboardProgram$CardType5) {
        n.f(cardType5, "type");
        super();
        this.lessonItem = programLessonItem;
        this.programDescriptionItem = programDescriptionItem2;
        this.programExamSummary = programExamSummary3;
        this.programCompletionSummary = programCompletionSummary4;
        this.type = cardType5;
    }

    public DashboardProgram(app.dogo.com.dogo_android.repository.domain.ProgramLessonItem programLessonItem, app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem programDescriptionItem2, app.dogo.com.dogo_android.repository.domain.ProgramExamSummary programExamSummary3, app.dogo.com.dogo_android.repository.domain.ProgramCompletionSummary programCompletionSummary4, app.dogo.com.dogo_android.repository.domain.DashboardProgram.CardType dashboardProgram$CardType5, int i6, g g7) {
        int i;
        int i3;
        int i4;
        int i2;
        final int i5 = 0;
        i = i6 & 1 != 0 ? i5 : programLessonItem;
        i3 = i6 & 2 != 0 ? i5 : programDescriptionItem2;
        i4 = i6 & 4 != 0 ? i5 : programExamSummary3;
        i2 = i6 & 8 != 0 ? i5 : programCompletionSummary4;
        super(i, i3, i4, i2, cardType5);
    }

    public static app.dogo.com.dogo_android.repository.domain.DashboardProgram copy$default(app.dogo.com.dogo_android.repository.domain.DashboardProgram dashboardProgram, app.dogo.com.dogo_android.repository.domain.ProgramLessonItem programLessonItem2, app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem programDescriptionItem3, app.dogo.com.dogo_android.repository.domain.ProgramExamSummary programExamSummary4, app.dogo.com.dogo_android.repository.domain.ProgramCompletionSummary programCompletionSummary5, app.dogo.com.dogo_android.repository.domain.DashboardProgram.CardType dashboardProgram$CardType6, int i7, Object object8) {
        app.dogo.com.dogo_android.repository.domain.ProgramLessonItem obj4;
        app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem obj5;
        app.dogo.com.dogo_android.repository.domain.ProgramExamSummary obj6;
        app.dogo.com.dogo_android.repository.domain.ProgramCompletionSummary obj7;
        app.dogo.com.dogo_android.repository.domain.DashboardProgram.CardType obj8;
        if (i7 & 1 != 0) {
            obj4 = dashboardProgram.lessonItem;
        }
        if (i7 & 2 != 0) {
            obj5 = dashboardProgram.programDescriptionItem;
        }
        if (i7 & 4 != 0) {
            obj6 = dashboardProgram.programExamSummary;
        }
        if (i7 & 8 != 0) {
            obj7 = dashboardProgram.programCompletionSummary;
        }
        if (i7 & 16 != 0) {
            obj8 = dashboardProgram.type;
        }
        return dashboardProgram.copy(obj4, obj5, obj6, obj7, obj8);
    }

    public final app.dogo.com.dogo_android.repository.domain.ProgramLessonItem component1() {
        return this.lessonItem;
    }

    public final app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem component2() {
        return this.programDescriptionItem;
    }

    public final app.dogo.com.dogo_android.repository.domain.ProgramExamSummary component3() {
        return this.programExamSummary;
    }

    public final app.dogo.com.dogo_android.repository.domain.ProgramCompletionSummary component4() {
        return this.programCompletionSummary;
    }

    public final app.dogo.com.dogo_android.repository.domain.DashboardProgram.CardType component5() {
        return this.type;
    }

    public final app.dogo.com.dogo_android.repository.domain.DashboardProgram copy(app.dogo.com.dogo_android.repository.domain.ProgramLessonItem programLessonItem, app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem programDescriptionItem2, app.dogo.com.dogo_android.repository.domain.ProgramExamSummary programExamSummary3, app.dogo.com.dogo_android.repository.domain.ProgramCompletionSummary programCompletionSummary4, app.dogo.com.dogo_android.repository.domain.DashboardProgram.CardType dashboardProgram$CardType5) {
        n.f(cardType5, "type");
        super(programLessonItem, programDescriptionItem2, programExamSummary3, programCompletionSummary4, cardType5);
        return dashboardProgram;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof DashboardProgram) {
            return i2;
        }
        if (!n.b(this.lessonItem, object.lessonItem)) {
            return i2;
        }
        if (!n.b(this.programDescriptionItem, object.programDescriptionItem)) {
            return i2;
        }
        if (!n.b(this.programExamSummary, object.programExamSummary)) {
            return i2;
        }
        if (!n.b(this.programCompletionSummary, object.programCompletionSummary)) {
            return i2;
        }
        if (this.type != object.type) {
            return i2;
        }
        return i;
    }

    public final app.dogo.com.dogo_android.repository.domain.ProgramLessonItem getLessonItem() {
        return this.lessonItem;
    }

    public final app.dogo.com.dogo_android.repository.domain.ProgramCompletionSummary getProgramCompletionSummary() {
        return this.programCompletionSummary;
    }

    public final app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem getProgramDescriptionItem() {
        return this.programDescriptionItem;
    }

    public final app.dogo.com.dogo_android.repository.domain.ProgramExamSummary getProgramExamSummary() {
        return this.programExamSummary;
    }

    public final app.dogo.com.dogo_android.repository.domain.DashboardProgram.CardType getType() {
        return this.type;
    }

    public int hashCode() {
        int i;
        int i3;
        int i4;
        int i2;
        app.dogo.com.dogo_android.repository.domain.ProgramLessonItem lessonItem = this.lessonItem;
        i3 = 0;
        if (lessonItem == null) {
            i = i3;
        } else {
            i = lessonItem.hashCode();
        }
        app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem programDescriptionItem = this.programDescriptionItem;
        if (programDescriptionItem == null) {
            i4 = i3;
        } else {
            i4 = programDescriptionItem.hashCode();
        }
        app.dogo.com.dogo_android.repository.domain.ProgramExamSummary programExamSummary = this.programExamSummary;
        if (programExamSummary == null) {
            i2 = i3;
        } else {
            i2 = programExamSummary.hashCode();
        }
        app.dogo.com.dogo_android.repository.domain.ProgramCompletionSummary programCompletionSummary = this.programCompletionSummary;
        if (programCompletionSummary == null) {
        } else {
            i3 = programCompletionSummary.hashCode();
        }
        return i11 += i13;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DashboardProgram(lessonItem=");
        stringBuilder.append(this.lessonItem);
        stringBuilder.append(", programDescriptionItem=");
        stringBuilder.append(this.programDescriptionItem);
        stringBuilder.append(", programExamSummary=");
        stringBuilder.append(this.programExamSummary);
        stringBuilder.append(", programCompletionSummary=");
        stringBuilder.append(this.programCompletionSummary);
        stringBuilder.append(", type=");
        stringBuilder.append(this.type);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
