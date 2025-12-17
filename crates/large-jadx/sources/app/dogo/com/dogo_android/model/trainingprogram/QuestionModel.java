package app.dogo.com.dogo_android.model.trainingprogram;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u001b\n\u0002\u0010\u000b\n\u0002\u0008\u0004\u0008\u0086\u0008\u0018\u00002\u00020\u0001Bg\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008\u0012\u000e\u0008\u0002\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u00030\n\u0012\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c\u0012\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e\u0012\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0003¢\u0006\u0002\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0008HÆ\u0003J\u000f\u0010$\u001a\u0008\u0012\u0004\u0012\u00020\u00030\nHÆ\u0003J\t\u0010%\u001a\u00020\u000cHÆ\u0003J\t\u0010&\u001a\u00020\u000eHÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003Jk\u0010(\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u000e\u0008\u0002\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u00030\n2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010)\u001a\u00020*2\u0008\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\u000cHÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u00030\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u0018R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u0018R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u001e¨\u0006.", d2 = {"Lapp/dogo/com/dogo_android/model/trainingprogram/QuestionModel;", "", "id", "", "question", "explanation", "explanationHtml", "article", "Lapp/dogo/com/dogo_android/model/trainingprogram/ArticleModel;", "answers", "", "correctAnswer", "", "updatedAt", "", "locale", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lapp/dogo/com/dogo_android/model/trainingprogram/ArticleModel;Ljava/util/List;IJLjava/lang/String;)V", "getAnswers", "()Ljava/util/List;", "getArticle", "()Lapp/dogo/com/dogo_android/model/trainingprogram/ArticleModel;", "getCorrectAnswer", "()I", "getExplanation", "()Ljava/lang/String;", "getExplanationHtml", "getId", "getLocale", "getQuestion", "getUpdatedAt", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class QuestionModel {

    private final List<String> answers;
    private final app.dogo.com.dogo_android.model.trainingprogram.ArticleModel article;
    private final int correctAnswer;
    private final String explanation;
    private final String explanationHtml;
    private final String id;
    private final String locale;
    private final String question;
    private final long updatedAt;
    public QuestionModel() {
        super(0, 0, 0, 0, 0, 0, 0, 0, obj9, 0, 511, 0);
    }

    public QuestionModel(String string, String string2, String string3, String string4, app.dogo.com.dogo_android.model.trainingprogram.ArticleModel articleModel5, List<String> list6, int i7, long l8, String string9) {
        n.f(string, "id");
        n.f(string2, "question");
        n.f(string3, "explanation");
        n.f(articleModel5, "article");
        n.f(list6, "answers");
        n.f(obj11, "locale");
        super();
        this.id = string;
        this.question = string2;
        this.explanation = string3;
        this.explanationHtml = string4;
        this.article = articleModel5;
        this.answers = list6;
        this.correctAnswer = i7;
        this.updatedAt = l8;
        this.locale = obj11;
    }

    public QuestionModel(String string, String string2, String string3, String string4, app.dogo.com.dogo_android.model.trainingprogram.ArticleModel articleModel5, List list6, int i7, long l8, String string9, int i10, g g11) {
        String str4;
        String str3;
        String str5;
        String str;
        String str2;
        app.dogo.com.dogo_android.model.trainingprogram.ArticleModel articleModel;
        app.dogo.com.dogo_android.model.trainingprogram.ArticleModel articleModel2;
        ArrayList arrayList;
        int i12;
        int i2;
        int i11;
        int i4;
        int i8;
        int i16;
        int i13;
        int i5;
        int i3;
        int i14;
        int i9;
        int i15;
        int i;
        int i6;
        int i17;
        int i18 = g11;
        str3 = "";
        str4 = i18 & 1 != 0 ? str3 : string;
        str5 = i18 & 2 != 0 ? str3 : string2;
        str = i18 & 4 != 0 ? str3 : string3;
        str2 = i18 & 8 != 0 ? str3 : string4;
        if (i18 & 16 != 0) {
            super(0, 0, 0, obj11, 0, 0, 0, 0, 0, 0, 0, 0, 2047, 0);
        } else {
            articleModel = articleModel5;
        }
        if (i18 & 32 != 0) {
            arrayList = new ArrayList();
        } else {
            arrayList = list6;
        }
        i2 = i18 & 64 != 0 ? 0 : i7;
        i4 = i18 & 128 != 0 ? 0 : l8;
        if (i18 &= 256 != 0) {
        } else {
            str3 = i10;
        }
        super(str4, str5, str, str2, articleModel, arrayList, i2, i4, i10, str3);
    }

    public static app.dogo.com.dogo_android.model.trainingprogram.QuestionModel copy$default(app.dogo.com.dogo_android.model.trainingprogram.QuestionModel questionModel, String string2, String string3, String string4, String string5, app.dogo.com.dogo_android.model.trainingprogram.ArticleModel articleModel6, List list7, int i8, long l9, String string10, int i11, Object object12) {
        String locale;
        String str;
        String question;
        String explanation;
        String explanationHtml;
        app.dogo.com.dogo_android.model.trainingprogram.ArticleModel article;
        List answers;
        int correctAnswer;
        long updatedAt;
        Object obj = questionModel;
        int i = object12;
        str = i & 1 != 0 ? obj.id : string2;
        question = i & 2 != 0 ? obj.question : string3;
        explanation = i & 4 != 0 ? obj.explanation : string4;
        explanationHtml = i & 8 != 0 ? obj.explanationHtml : string5;
        article = i & 16 != 0 ? obj.article : articleModel6;
        answers = i & 32 != 0 ? obj.answers : list7;
        correctAnswer = i & 64 != 0 ? obj.correctAnswer : i8;
        updatedAt = i & 128 != 0 ? obj.updatedAt : l9;
        locale = i &= 256 != 0 ? obj.locale : i11;
        return questionModel.copy(str, question, explanation, explanationHtml, article, answers, correctAnswer, updatedAt, string10);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.question;
    }

    public final String component3() {
        return this.explanation;
    }

    public final String component4() {
        return this.explanationHtml;
    }

    public final app.dogo.com.dogo_android.model.trainingprogram.ArticleModel component5() {
        return this.article;
    }

    public final List<String> component6() {
        return this.answers;
    }

    public final int component7() {
        return this.correctAnswer;
    }

    public final long component8() {
        return this.updatedAt;
    }

    public final String component9() {
        return this.locale;
    }

    public final app.dogo.com.dogo_android.model.trainingprogram.QuestionModel copy(String string, String string2, String string3, String string4, app.dogo.com.dogo_android.model.trainingprogram.ArticleModel articleModel5, List<String> list6, int i7, long l8, String string9) {
        n.f(string, "id");
        n.f(string2, "question");
        n.f(string3, "explanation");
        final Object obj = articleModel5;
        n.f(obj, "article");
        final Object obj2 = list6;
        n.f(obj2, "answers");
        final Object obj3 = obj22;
        n.f(obj3, "locale");
        super(string, string2, string3, string4, obj, obj2, i7, l8, obj10, obj3);
        return questionModel;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof QuestionModel) {
            return i2;
        }
        if (!n.b(this.id, object.id)) {
            return i2;
        }
        if (!n.b(this.question, object.question)) {
            return i2;
        }
        if (!n.b(this.explanation, object.explanation)) {
            return i2;
        }
        if (!n.b(this.explanationHtml, object.explanationHtml)) {
            return i2;
        }
        if (!n.b(this.article, object.article)) {
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
        if (!n.b(this.locale, object.locale)) {
            return i2;
        }
        return i;
    }

    public final List<String> getAnswers() {
        return this.answers;
    }

    public final app.dogo.com.dogo_android.model.trainingprogram.ArticleModel getArticle() {
        return this.article;
    }

    public final int getCorrectAnswer() {
        return this.correctAnswer;
    }

    public final String getExplanation() {
        return this.explanation;
    }

    public final String getExplanationHtml() {
        return this.explanationHtml;
    }

    public final String getId() {
        return this.id;
    }

    public final String getLocale() {
        return this.locale;
    }

    public final String getQuestion() {
        return this.question;
    }

    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    public int hashCode() {
        int i;
        String explanationHtml = this.explanationHtml;
        if (explanationHtml == null) {
            i = 0;
        } else {
            i = explanationHtml.hashCode();
        }
        return i17 += i25;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("QuestionModel(id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", question=");
        stringBuilder.append(this.question);
        stringBuilder.append(", explanation=");
        stringBuilder.append(this.explanation);
        stringBuilder.append(", explanationHtml=");
        stringBuilder.append(this.explanationHtml);
        stringBuilder.append(", article=");
        stringBuilder.append(this.article);
        stringBuilder.append(", answers=");
        stringBuilder.append(this.answers);
        stringBuilder.append(", correctAnswer=");
        stringBuilder.append(this.correctAnswer);
        stringBuilder.append(", updatedAt=");
        stringBuilder.append(this.updatedAt);
        stringBuilder.append(", locale=");
        stringBuilder.append(this.locale);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
