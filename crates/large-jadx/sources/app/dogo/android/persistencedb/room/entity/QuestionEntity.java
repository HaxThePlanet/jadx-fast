package app.dogo.android.persistencedb.room.entity;

import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0016\n\u0002\u0010\u000b\n\u0002\u0008\u0004\u0008\u0087\u0008\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J\t\u0010\u001e\u001a\u00020\u000bHÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003JU\u0010 \u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u000e\u0008\u0002\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u0003HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\u0008\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\tHÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\u0008\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u0011\u0010\u000c\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0013R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018¨\u0006&", d2 = {"Lapp/dogo/android/persistencedb/room/entity/QuestionEntity;", "", "questionId", "", "locale", "question", "answers", "", "correctAnswer", "", "updatedAt", "", "locale_questionId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;IJLjava/lang/String;)V", "getAnswers", "()Ljava/util/List;", "getCorrectAnswer", "()I", "getLocale", "()Ljava/lang/String;", "getLocale_questionId", "getQuestion", "getQuestionId", "getUpdatedAt", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class QuestionEntity {

    private final List<String> answers;
    private final int correctAnswer;
    private final String locale;
    private final String locale_questionId;
    private final String question;
    private final String questionId;
    private final long updatedAt;
    public QuestionEntity(String string, String string2, String string3, List<String> list4, int i5, long l6, String string7) {
        n.f(string, "questionId");
        n.f(string2, "locale");
        n.f(string3, "question");
        n.f(list4, "answers");
        n.f(obj9, "locale_questionId");
        super();
        this.questionId = string;
        this.locale = string2;
        this.question = string3;
        this.answers = list4;
        this.correctAnswer = i5;
        this.updatedAt = l6;
        this.locale_questionId = obj9;
    }

    public QuestionEntity(String string, String string2, String string3, List list4, int i5, long l6, String string7, int i8, g g9) {
        String string4;
        int i;
        String str3;
        String str;
        String str2;
        if (g9 & 64 != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            str = string2;
            stringBuilder.append(string2);
            stringBuilder.append('_');
            str3 = string;
            stringBuilder.append(string);
            str2 = string4;
        } else {
            str3 = string;
            str = string2;
            str2 = i8;
        }
        super(string, string2, string3, list4, i5, l6, obj8, str2);
    }

    public static app.dogo.android.persistencedb.room.entity.QuestionEntity copy$default(app.dogo.android.persistencedb.room.entity.QuestionEntity questionEntity, String string2, String string3, String string4, List list5, int i6, long l7, String string8, int i9, Object object10) {
        String questionId;
        String locale;
        String question;
        List answers;
        int correctAnswer;
        long updatedAt;
        String locale_questionId;
        Object obj = questionEntity;
        questionId = object10 & 1 != 0 ? obj.questionId : string2;
        locale = object10 & 2 != 0 ? obj.locale : string3;
        question = object10 & 4 != 0 ? obj.question : string4;
        answers = object10 & 8 != 0 ? obj.answers : list5;
        correctAnswer = object10 & 16 != 0 ? obj.correctAnswer : i6;
        updatedAt = object10 & 32 != 0 ? obj.updatedAt : l7;
        locale_questionId = object10 & 64 != 0 ? obj.locale_questionId : i9;
        return questionEntity.copy(questionId, locale, question, answers, correctAnswer, updatedAt, string8);
    }

    public final String component1() {
        return this.questionId;
    }

    public final String component2() {
        return this.locale;
    }

    public final String component3() {
        return this.question;
    }

    public final List<String> component4() {
        return this.answers;
    }

    public final int component5() {
        return this.correctAnswer;
    }

    public final long component6() {
        return this.updatedAt;
    }

    public final String component7() {
        return this.locale_questionId;
    }

    public final app.dogo.android.persistencedb.room.entity.QuestionEntity copy(String string, String string2, String string3, List<String> list4, int i5, long l6, String string7) {
        n.f(string, "questionId");
        n.f(string2, "locale");
        n.f(string3, "question");
        n.f(list4, "answers");
        final Object obj = obj18;
        n.f(obj, "locale_questionId");
        super(string, string2, string3, list4, i5, l6, obj8, obj);
        return questionEntity;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof QuestionEntity) {
            return i2;
        }
        if (!n.b(this.questionId, object.questionId)) {
            return i2;
        }
        if (!n.b(this.locale, object.locale)) {
            return i2;
        }
        if (!n.b(this.question, object.question)) {
            return i2;
        }
        if (!n.b(this.answers, object.answers)) {
            return i2;
        }
        if (this.correctAnswer != object.correctAnswer) {
            return i2;
        }
        if (Long.compare(updatedAt, updatedAt2) != 0) {
            return i2;
        }
        if (!n.b(this.locale_questionId, object.locale_questionId)) {
            return i2;
        }
        return i;
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

    public int hashCode() {
        return i12 += i19;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("QuestionEntity(questionId=");
        stringBuilder.append(this.questionId);
        stringBuilder.append(", locale=");
        stringBuilder.append(this.locale);
        stringBuilder.append(", question=");
        stringBuilder.append(this.question);
        stringBuilder.append(", answers=");
        stringBuilder.append(this.answers);
        stringBuilder.append(", correctAnswer=");
        stringBuilder.append(this.correctAnswer);
        stringBuilder.append(", updatedAt=");
        stringBuilder.append(this.updatedAt);
        stringBuilder.append(", locale_questionId=");
        stringBuilder.append(this.locale_questionId);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
