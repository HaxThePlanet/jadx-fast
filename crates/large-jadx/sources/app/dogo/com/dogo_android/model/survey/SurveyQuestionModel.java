package app.dogo.com.dogo_android.model.survey;

import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.y.p;

/* compiled from: SurveyQuestionModel.kt */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0002\u0008\u0010\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0086\u0008\u0018\u00002\u00020\u0001B=\u0012\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u000f\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\nHÆ\u0003JA\u0010\u0019\u001a\u00020\u00002\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00062\u0008\u0008\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0006HÖ\u0001R\u0017\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u000fR\u0011\u0010\u0008\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u000fR\u0011\u0010\t\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013¨\u0006 ", d2 = {"Lapp/dogo/com/dogo_android/model/survey/SurveyQuestionModel;", "", "answers", "", "Lapp/dogo/com/dogo_android/model/survey/SurveyAnswerModel;", "id", "", "locale", "text", "updatedAt", "", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getAnswers", "()Ljava/util/List;", "getId", "()Ljava/lang/String;", "getLocale", "getText", "getUpdatedAt", "()J", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class SurveyQuestionModel {

    private final List<SurveyAnswerModel> answers;
    private final String id;
    private final String locale;
    private final String text;
    private final long updatedAt;
    public SurveyQuestionModel(List<SurveyAnswerModel> list, String str, String str2, String str3, long j) {
        n.f(list, "answers");
        n.f(str, "id");
        n.f(str2, "locale");
        n.f(str3, "text");
        super();
        this.answers = list;
        this.id = str;
        this.locale = str2;
        this.text = str3;
        this.updatedAt = j;
    }

    public final List<SurveyAnswerModel> getAnswers() {
        return this.answers;
    }

    public final String getId() {
        return this.id;
    }

    public final String getLocale() {
        return this.locale;
    }

    public final String getText() {
        return this.text;
    }

    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    public /* synthetic */ SurveyQuestionModel(List list, String str, String str2, String str3, long j, int i, g gVar) {
        String str42;
        List list2;
        int j52 = 0;
        if (i & 1 != 0) {
            list2 = p.g();
        }
        str42 = "";
        gVar = i & 2 != 0 ? str42 : str;
        String r1 = i & 4 != 0 ? str42 : str2;
        if (i & 8 == 0) {
            str42 = str3;
        }
        j52 = i & 16 != 0 ? 0 : j52;
        this(list2, str42, str42, str42, j52, str42);
    }

    public SurveyQuestionModel() {
        this(null, null, null, null, 0L, i6, 31, 0);
    }

    public static /* synthetic */ SurveyQuestionModel copy$default(SurveyQuestionModel surveyQuestionModel, List list, String str, String str2, String str3, long j, int i, Object object) {
        List list22;
        String str32;
        String str42;
        String str52;
        long j62;
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
        return surveyQuestionModel.copy(list22, str32, str42, str52, j62);
    }

    /* operator */ public final List<SurveyAnswerModel> component1() {
        return this.answers;
    }

    /* operator */ public final String component2() {
        return this.id;
    }

    /* operator */ public final String component3() {
        return this.locale;
    }

    /* operator */ public final String component4() {
        return this.text;
    }

    /* operator */ public final long component5() {
        return this.updatedAt;
    }

    public final SurveyQuestionModel copy(List<SurveyAnswerModel> answers, String id, String locale, String text, long updatedAt) {
        n.f(answers, "answers");
        n.f(id, "id");
        n.f(locale, "locale");
        n.f(text, "text");
        SurveyQuestionModel surveyQuestionModel = new SurveyQuestionModel(answers, id, locale, text, updatedAt, obj);
        return surveyQuestionModel;
    }

    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z7 = false;
        if (!(other instanceof SurveyQuestionModel)) {
            return false;
        }
        if (!n.b(this.answers, other.answers)) {
            return false;
        }
        if (!n.b(this.id, other.id)) {
            return false;
        }
        if (!n.b(this.locale, other.locale)) {
            return false;
        }
        if (!n.b(this.text, other.text)) {
            return false;
        }
        return this.updatedAt != other.updatedAt ? z7 : z;
    }

    public int hashCode() {
        return (this.answers.hashCode() * 31) + this.id.hashCode() * 31 + this.locale.hashCode() * 31 + this.text.hashCode() * 31 + Long.hashCode(this.updatedAt);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "SurveyQuestionModel(answers=";
        String str3 = ", id=";
        String str4 = ", locale=";
        String str5 = ", text=";
        String str6 = ", updatedAt=";
        str = str2 + this.answers + str3 + this.id + str4 + this.locale + str5 + this.text + str6 + this.updatedAt + 41;
        return str;
    }
}
