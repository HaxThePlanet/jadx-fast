package app.dogo.com.dogo_android.model.survey;

import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0002\u0008\u0010\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0086\u0008\u0018\u00002\u00020\u0001B=\u0012\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u000f\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\nHÆ\u0003JA\u0010\u0019\u001a\u00020\u00002\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00062\u0008\u0008\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0006HÖ\u0001R\u0017\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u000fR\u0011\u0010\u0008\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u000fR\u0011\u0010\t\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013¨\u0006 ", d2 = {"Lapp/dogo/com/dogo_android/model/survey/SurveyQuestionModel;", "", "answers", "", "Lapp/dogo/com/dogo_android/model/survey/SurveyAnswerModel;", "id", "", "locale", "text", "updatedAt", "", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getAnswers", "()Ljava/util/List;", "getId", "()Ljava/lang/String;", "getLocale", "getText", "getUpdatedAt", "()J", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SurveyQuestionModel {

    private final List<app.dogo.com.dogo_android.model.survey.SurveyAnswerModel> answers;
    private final String id;
    private final String locale;
    private final String text;
    private final long updatedAt;
    public SurveyQuestionModel() {
        super(0, 0, 0, 0, 0, obj6, 31, 0);
    }

    public SurveyQuestionModel(List<app.dogo.com.dogo_android.model.survey.SurveyAnswerModel> list, String string2, String string3, String string4, long l5) {
        n.f(list, "answers");
        n.f(string2, "id");
        n.f(string3, "locale");
        n.f(string4, "text");
        super();
        this.answers = list;
        this.id = string2;
        this.locale = string3;
        this.text = string4;
        this.updatedAt = l5;
    }

    public SurveyQuestionModel(List list, String string2, String string3, String string4, long l5, int i6, g g7) {
        String str;
        String str2;
        List obj5;
        int obj9;
        String obj12;
        if (g7 & 1 != 0) {
            obj5 = p.g();
        }
        str = "";
        obj12 = g7 & 2 != 0 ? str : string2;
        str2 = g7 & 4 != 0 ? str : string3;
        if (g7 & 8 != 0) {
        } else {
            str = string4;
        }
        obj9 = g7 & 16 != 0 ? 0 : obj9;
        super(obj5, obj12, str2, str, obj9, obj12);
    }

    public static app.dogo.com.dogo_android.model.survey.SurveyQuestionModel copy$default(app.dogo.com.dogo_android.model.survey.SurveyQuestionModel surveyQuestionModel, List list2, String string3, String string4, String string5, long l6, int i7, Object object8) {
        List obj5;
        String obj6;
        String obj7;
        String obj8;
        long obj9;
        if (object8 & 1 != 0) {
            obj5 = surveyQuestionModel.answers;
        }
        if (object8 & 2 != 0) {
            obj6 = surveyQuestionModel.id;
        }
        String obj12 = obj6;
        if (object8 & 4 != 0) {
            obj7 = surveyQuestionModel.locale;
        }
        if (object8 & 8 != 0) {
            obj8 = surveyQuestionModel.text;
        }
        if (object8 & 16 != 0) {
            obj9 = surveyQuestionModel.updatedAt;
        }
        return surveyQuestionModel.copy(obj5, obj12, obj7, obj8, obj9);
    }

    public final List<app.dogo.com.dogo_android.model.survey.SurveyAnswerModel> component1() {
        return this.answers;
    }

    public final String component2() {
        return this.id;
    }

    public final String component3() {
        return this.locale;
    }

    public final String component4() {
        return this.text;
    }

    public final long component5() {
        return this.updatedAt;
    }

    public final app.dogo.com.dogo_android.model.survey.SurveyQuestionModel copy(List<app.dogo.com.dogo_android.model.survey.SurveyAnswerModel> list, String string2, String string3, String string4, long l5) {
        n.f(list, "answers");
        n.f(string2, "id");
        n.f(string3, "locale");
        n.f(string4, "text");
        super(list, string2, string3, string4, l5, obj7);
        return surveyQuestionModel;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof SurveyQuestionModel) {
            return i2;
        }
        if (!n.b(this.answers, object.answers)) {
            return i2;
        }
        if (!n.b(this.id, object.id)) {
            return i2;
        }
        if (!n.b(this.locale, object.locale)) {
            return i2;
        }
        if (!n.b(this.text, object.text)) {
            return i2;
        }
        if (Long.compare(updatedAt, updatedAt2) != 0) {
            return i2;
        }
        return i;
    }

    public final List<app.dogo.com.dogo_android.model.survey.SurveyAnswerModel> getAnswers() {
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

    public int hashCode() {
        return i8 += i13;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SurveyQuestionModel(answers=");
        stringBuilder.append(this.answers);
        stringBuilder.append(", id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", locale=");
        stringBuilder.append(this.locale);
        stringBuilder.append(", text=");
        stringBuilder.append(this.text);
        stringBuilder.append(", updatedAt=");
        stringBuilder.append(this.updatedAt);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
