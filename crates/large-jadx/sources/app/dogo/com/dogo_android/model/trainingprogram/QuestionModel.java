package app.dogo.com.dogo_android.model.trainingprogram;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: QuestionModel.kt */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u001b\n\u0002\u0010\u000b\n\u0002\u0008\u0004\u0008\u0086\u0008\u0018\u00002\u00020\u0001Bg\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008\u0012\u000e\u0008\u0002\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u00030\n\u0012\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c\u0012\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e\u0012\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0003¢\u0006\u0002\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0008HÆ\u0003J\u000f\u0010$\u001a\u0008\u0012\u0004\u0012\u00020\u00030\nHÆ\u0003J\t\u0010%\u001a\u00020\u000cHÆ\u0003J\t\u0010&\u001a\u00020\u000eHÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003Jk\u0010(\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u000e\u0008\u0002\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u00030\n2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010)\u001a\u00020*2\u0008\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\u000cHÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u00030\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u0018R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u0018R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u001e¨\u0006.", d2 = {"Lapp/dogo/com/dogo_android/model/trainingprogram/QuestionModel;", "", "id", "", "question", "explanation", "explanationHtml", "article", "Lapp/dogo/com/dogo_android/model/trainingprogram/ArticleModel;", "answers", "", "correctAnswer", "", "updatedAt", "", "locale", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lapp/dogo/com/dogo_android/model/trainingprogram/ArticleModel;Ljava/util/List;IJLjava/lang/String;)V", "getAnswers", "()Ljava/util/List;", "getArticle", "()Lapp/dogo/com/dogo_android/model/trainingprogram/ArticleModel;", "getCorrectAnswer", "()I", "getExplanation", "()Ljava/lang/String;", "getExplanationHtml", "getId", "getLocale", "getQuestion", "getUpdatedAt", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class QuestionModel {

    private final List<String> answers;
    private final ArticleModel article;
    private final int correctAnswer;
    private final String explanation;
    private final String explanationHtml;
    private final String id;
    private final String locale;
    private final String question;
    private final long updatedAt;
    public QuestionModel(String str, String str2, String str3, String str4, ArticleModel articleModel, List<String> list, int i, long j, String str5) {
        n.f(str, "id");
        n.f(str2, "question");
        n.f(str3, "explanation");
        n.f(articleModel, "article");
        n.f(list, "answers");
        n.f(str5, "locale");
        super();
        this.id = str;
        this.question = str2;
        this.explanation = str3;
        this.explanationHtml = str4;
        this.article = articleModel;
        this.answers = list;
        this.correctAnswer = i;
        this.updatedAt = j;
        this.locale = str5;
    }

    public final List<String> getAnswers() {
        return this.answers;
    }

    public final ArticleModel getArticle() {
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

    public /* synthetic */ QuestionModel(String str, String str2, String str3, String str4, ArticleModel articleModel, List list, int i, long j, String str5, int i2, g gVar) {
        app.dogo.com.dogo_android.model.trainingprogram.ArticleModel articleModel52;
        ArrayList list62;
        int i72 = 0;
        int j82 = 0;
        int gVar112 = i2;
        str5 = "";
        String r1 = gVar112 & 1 != 0 ? str5 : str;
        String r3 = gVar112 & 2 != 0 ? str5 : str2;
        String r4 = gVar112 & 4 != 0 ? str5 : str3;
        String r5 = gVar112 & 8 != 0 ? str5 : str4;
        if (gVar112 & 16 != 0) {
            String str6 = null;
            String str7 = null;
            long l = 0L;
            String str8 = null;
            i = 0;
            Integer num = null;
            String str10 = null;
            String str11 = null;
            list = null;
            String str12 = null;
            i2 = 0;
            gVar = 2047;
            int i3 = 0;
            super(str6, str7, l, str13, str8, i, num, str10, str11, list, str12, i2, gVar, i3);
        } else {
            articleModel52 = articleModel;
        }
        ArrayList r7 = gVar112 & 32 != 0 ? new ArrayList() : list;
        int r8 = gVar112 & 64 != 0 ? 0 : i;
        int r9 = gVar112 & 128 != 0 ? 0 : j;
        if (gVar112 & 256 == 0) {
        }
        this(str5, str5, str5, str5, articleModel52, list62, i72, j82, str5, str5);
    }

    public QuestionModel() {
        this(null, null, null, null, null, null, 0, 0L, str, 0, 511, 0);
    }

    public static /* synthetic */ QuestionModel copy$default(QuestionModel questionModel, String str, String str2, String str3, String str4, ArticleModel articleModel, List list, int i, long j, String str5, int i2, Object object) {
        String i112;
        String str22;
        String str32;
        String str42;
        String str52;
        app.dogo.com.dogo_android.model.trainingprogram.ArticleModel articleModel62;
        List list72;
        int i82;
        long j92;
        Object questionModel2 = questionModel;
        int object122 = i2;
        String r2 = object122 & 1 != 0 ? questionModel2.id : str;
        String r3 = object122 & 2 != 0 ? questionModel2.question : str2;
        String r4 = object122 & 4 != 0 ? questionModel2.explanation : str3;
        String r5 = object122 & 8 != 0 ? questionModel2.explanationHtml : str4;
        app.dogo.com.dogo_android.model.trainingprogram.ArticleModel r6 = object122 & 16 != 0 ? questionModel2.article : articleModel;
        List r7 = object122 & 32 != 0 ? questionModel2.answers : list;
        int r8 = object122 & 64 != 0 ? questionModel2.correctAnswer : i;
        long r9 = object122 & 128 != 0 ? questionModel2.updatedAt : j;
        String r1 = object122 & 256 != 0 ? questionModel2.locale : str5;
        return questionModel.copy(str22, str32, str42, str52, articleModel62, list72, i82, j92, r20, (object122 & 256 != 0 ? questionModel2.locale : str5));
    }

    /* operator */ public final String component1() {
        return this.id;
    }

    /* operator */ public final String component2() {
        return this.question;
    }

    /* operator */ public final String component3() {
        return this.explanation;
    }

    /* operator */ public final String component4() {
        return this.explanationHtml;
    }

    /* operator */ public final ArticleModel component5() {
        return this.article;
    }

    /* operator */ public final List<String> component6() {
        return this.answers;
    }

    /* operator */ public final int component7() {
        return this.correctAnswer;
    }

    /* operator */ public final long component8() {
        return this.updatedAt;
    }

    /* operator */ public final String component9() {
        return this.locale;
    }

    public final QuestionModel copy(String id, String question, String explanation, String explanationHtml, ArticleModel article, List<String> answers, int correctAnswer, long updatedAt, String locale) {
        n.f(id, "id");
        n.f(question, "question");
        n.f(explanation, "explanation");
        final Object article2 = article;
        n.f(article2, "article");
        final Object answers2 = answers;
        n.f(answers2, "answers");
        final Object obj = locale;
        n.f(obj, "locale");
        QuestionModel questionModel = new QuestionModel(id, question, explanation, explanationHtml, article2, answers2, correctAnswer, updatedAt, str7, obj);
        return questionModel;
    }

    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z9 = false;
        if (!(other instanceof QuestionModel)) {
            return false;
        }
        if (!n.b(this.id, other.id)) {
            return false;
        }
        if (!n.b(this.question, other.question)) {
            return false;
        }
        if (!n.b(this.explanation, other.explanation)) {
            return false;
        }
        if (!n.b(this.explanationHtml, other.explanationHtml)) {
            return false;
        }
        if (!n.b(this.article, other.article)) {
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
        return !n.b(this.locale, other.locale) ? z9 : z;
    }

    public int hashCode() {
        int i = 0;
        if (this.explanationHtml == null) {
            i = 0;
        } else {
            i = this.explanationHtml.hashCode();
        }
        return (this.id.hashCode() * 31) + this.question.hashCode() * 31 + this.explanation.hashCode() * 31 + i * 31 + this.article.hashCode() * 31 + this.answers.hashCode() * 31 + Integer.hashCode(this.correctAnswer) * 31 + Long.hashCode(this.updatedAt) * 31 + this.locale.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "QuestionModel(id=";
        String str3 = ", question=";
        String str4 = ", explanation=";
        String str5 = ", explanationHtml=";
        String str6 = ", article=";
        String str7 = ", answers=";
        String str8 = ", correctAnswer=";
        String str9 = ", updatedAt=";
        String str10 = ", locale=";
        str = str2 + this.id + str3 + this.question + str4 + this.explanation + str5 + this.explanationHtml + str6 + this.article + str7 + this.answers + str8 + this.correctAnswer + str9 + this.updatedAt + str10 + this.locale + 41;
        return str;
    }
}
