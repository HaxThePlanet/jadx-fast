package app.dogo.android.persistencedb.room.entity;

import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: QuestionEntity.kt */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0016\n\u0002\u0010\u000b\n\u0002\u0008\u0004\u0008\u0087\u0008\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J\t\u0010\u001e\u001a\u00020\u000bHÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003JU\u0010 \u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u000e\u0008\u0002\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u0003HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\u0008\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\tHÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\u0008\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u0011\u0010\u000c\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0013R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018¨\u0006&", d2 = {"Lapp/dogo/android/persistencedb/room/entity/QuestionEntity;", "", "questionId", "", "locale", "question", "answers", "", "correctAnswer", "", "updatedAt", "", "locale_questionId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;IJLjava/lang/String;)V", "getAnswers", "()Ljava/util/List;", "getCorrectAnswer", "()I", "getLocale", "()Ljava/lang/String;", "getLocale_questionId", "getQuestion", "getQuestionId", "getUpdatedAt", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class QuestionEntity {

    private final List<String> answers;
    private final int correctAnswer;
    private final String locale;
    private final String locale_questionId;
    private final String question;
    private final String questionId;
    private final long updatedAt;
    public QuestionEntity(String str, String str2, String str3, List<String> list, int i, long j, String str4) {
        n.f(str, "questionId");
        n.f(str2, "locale");
        n.f(str3, "question");
        n.f(list, "answers");
        n.f(str4, "locale_questionId");
        super();
        this.questionId = str;
        this.locale = str2;
        this.question = str3;
        this.answers = list;
        this.correctAnswer = i;
        this.updatedAt = j;
        this.locale_questionId = str4;
    }

    public final List<String> getAnswers() {
        return this.answers;
    }

    public final int getCorrectAnswer() {
        return this.correctAnswer;
    }

    public final String getLocale() {
        return this.locale;
    }

    public final String getLocale_questionId() {
        return this.locale_questionId;
    }

    public final String getQuestion() {
        return this.question;
    }

    public final String getQuestionId() {
        return this.questionId;
    }

    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    public /* synthetic */ QuestionEntity(String str, String str2, String str3, List list, int i, long j, String str4, int i2, g gVar) {
        String i82;
        if (i2 & 64 != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            str22 = str2;
            char c = '_';
            str4 = str;
            i82 = str2 + c + str;
        } else {
            str4 = str;
            str22 = str2;
            i82 = str4;
        }
        this(str, str2, str3, list, i, j, str6, i82);
    }

    public static /* synthetic */ QuestionEntity copy$default(QuestionEntity questionEntity, String str, String str2, String str3, List list, int i, long j, String str4, int i2, Object object) {
        String str22;
        String str32;
        String str42;
        List list52;
        int i62;
        long j72;
        String i92;
        Object questionEntity2 = questionEntity;
        String r1 = i2 & 1 != 0 ? questionEntity2.questionId : str;
        String r2 = i2 & 2 != 0 ? questionEntity2.locale : str2;
        String r3 = i2 & 4 != 0 ? questionEntity2.question : str3;
        List r4 = i2 & 8 != 0 ? questionEntity2.answers : list;
        int r5 = i2 & 16 != 0 ? questionEntity2.correctAnswer : i;
        long r6 = i2 & 32 != 0 ? questionEntity2.updatedAt : j;
        String r8 = i2 & 64 != 0 ? questionEntity2.locale_questionId : str4;
        return questionEntity.copy(str22, str32, str42, list52, i62, j72, r16, (i2 & 64 != 0 ? questionEntity2.locale_questionId : str4));
    }

    /* operator */ public final String component1() {
        return this.questionId;
    }

    /* operator */ public final String component2() {
        return this.locale;
    }

    /* operator */ public final String component3() {
        return this.question;
    }

    /* operator */ public final List<String> component4() {
        return this.answers;
    }

    /* operator */ public final int component5() {
        return this.correctAnswer;
    }

    /* operator */ public final long component6() {
        return this.updatedAt;
    }

    /* operator */ public final String component7() {
        return this.locale_questionId;
    }

    public final QuestionEntity copy(String questionId, String locale, String question, List<String> answers, int correctAnswer, long updatedAt, String locale_questionId) {
        n.f(questionId, "questionId");
        n.f(locale, "locale");
        n.f(question, "question");
        n.f(answers, "answers");
        final Object obj = locale_questionId;
        n.f(obj, "locale_questionId");
        QuestionEntity questionEntity = new QuestionEntity(questionId, locale, question, answers, correctAnswer, updatedAt, str6, obj);
        return questionEntity;
    }

    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z7 = false;
        if (!(other instanceof QuestionEntity)) {
            return false;
        }
        if (!n.b(this.questionId, other.questionId)) {
            return false;
        }
        if (!n.b(this.locale, other.locale)) {
            return false;
        }
        if (!n.b(this.question, other.question)) {
            return false;
        }
        if (!n.b(this.answers, other.answers)) {
            return false;
        }
        if (this.correctAnswer != other.correctAnswer) {
            return false;
        }
        if (this.updatedAt != other.updatedAt) {
            return false;
        }
        return !n.b(this.locale_questionId, other.locale_questionId) ? z7 : z;
    }

    public int hashCode() {
        return (this.questionId.hashCode() * 31) + this.locale.hashCode() * 31 + this.question.hashCode() * 31 + this.answers.hashCode() * 31 + Integer.hashCode(this.correctAnswer) * 31 + Long.hashCode(this.updatedAt) * 31 + this.locale_questionId.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "QuestionEntity(questionId=";
        String str3 = ", locale=";
        String str4 = ", question=";
        String str5 = ", answers=";
        String str6 = ", correctAnswer=";
        String str7 = ", updatedAt=";
        String str8 = ", locale_questionId=";
        str = str2 + this.questionId + str3 + this.locale + str4 + this.question + str5 + this.answers + str6 + this.correctAnswer + str7 + this.updatedAt + str8 + this.locale_questionId + 41;
        return str;
    }
}
