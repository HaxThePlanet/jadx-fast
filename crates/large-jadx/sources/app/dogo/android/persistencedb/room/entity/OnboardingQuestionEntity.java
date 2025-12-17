package app.dogo.android.persistencedb.room.entity;

import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0008\u0013\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u000c\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\u00030\t\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u00020\u00030\tHÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003JK\u0010\u001b\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00032\u000e\u0008\u0002\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\u00030\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\u00030\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014¨\u0006\"", d2 = {"Lapp/dogo/android/persistencedb/room/entity/OnboardingQuestionEntity;", "", "questionId", "", "text", "updatedAt", "", "locale", "childOrderList", "", "locale_questionId", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getChildOrderList", "()Ljava/util/List;", "getLocale", "()Ljava/lang/String;", "getLocale_questionId", "getQuestionId", "getText", "getUpdatedAt", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class OnboardingQuestionEntity {

    private final List<String> childOrderList;
    private final String locale;
    private final String locale_questionId;
    private final String questionId;
    private final String text;
    private final long updatedAt;
    public OnboardingQuestionEntity(String string, String string2, long l3, String string4, List<String> list5, String string6) {
        n.f(string, "questionId");
        n.f(string2, "text");
        n.f(list5, "locale");
        n.f(string6, "childOrderList");
        n.f(obj8, "locale_questionId");
        super();
        this.questionId = string;
        this.text = string2;
        this.updatedAt = l3;
        this.locale = list5;
        this.childOrderList = string6;
        this.locale_questionId = obj8;
    }

    public OnboardingQuestionEntity(String string, String string2, long l3, String string4, List list5, String string6, int i7, g g8) {
        String string3;
        int i;
        String str;
        String str3;
        String str2;
        if (g8 & 32 != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            str3 = list5;
            stringBuilder.append(list5);
            stringBuilder.append('_');
            str = string;
            stringBuilder.append(string);
            str2 = string3;
        } else {
            str = string;
            str3 = list5;
            str2 = i7;
        }
        super(string, string2, l3, obj5, list5, string6, str2);
    }

    public static app.dogo.android.persistencedb.room.entity.OnboardingQuestionEntity copy$default(app.dogo.android.persistencedb.room.entity.OnboardingQuestionEntity onboardingQuestionEntity, String string2, String string3, long l4, String string5, List list6, String string7, int i8, Object object9) {
        String obj6;
        String obj7;
        long obj8;
        String obj10;
        List obj11;
        String obj12;
        if (object9 & 1 != 0) {
            obj6 = onboardingQuestionEntity.questionId;
        }
        if (object9 & 2 != 0) {
            obj7 = onboardingQuestionEntity.text;
        }
        if (object9 & 4 != 0) {
            obj8 = onboardingQuestionEntity.updatedAt;
        }
        if (object9 & 8 != 0) {
            obj10 = onboardingQuestionEntity.locale;
        }
        if (object9 & 16 != 0) {
            obj11 = onboardingQuestionEntity.childOrderList;
        }
        if (object9 & 32 != 0) {
            obj12 = onboardingQuestionEntity.locale_questionId;
        }
        return onboardingQuestionEntity.copy(obj6, obj7, obj8, obj11, obj10, obj11);
    }

    public final String component1() {
        return this.questionId;
    }

    public final String component2() {
        return this.text;
    }

    public final long component3() {
        return this.updatedAt;
    }

    public final String component4() {
        return this.locale;
    }

    public final List<String> component5() {
        return this.childOrderList;
    }

    public final String component6() {
        return this.locale_questionId;
    }

    public final app.dogo.android.persistencedb.room.entity.OnboardingQuestionEntity copy(String string, String string2, long l3, String string4, List<String> list5, String string6) {
        n.f(string, "questionId");
        n.f(string2, "text");
        n.f(list5, "locale");
        n.f(string6, "childOrderList");
        final Object obj = obj16;
        n.f(obj, "locale_questionId");
        super(string, string2, l3, obj5, list5, string6, obj);
        return onboardingQuestionEntity;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof OnboardingQuestionEntity) {
            return i2;
        }
        if (!n.b(this.questionId, object.questionId)) {
            return i2;
        }
        if (!n.b(this.text, object.text)) {
            return i2;
        }
        if (Long.compare(updatedAt, updatedAt2) != 0) {
            return i2;
        }
        if (!n.b(this.locale, object.locale)) {
            return i2;
        }
        if (!n.b(this.childOrderList, object.childOrderList)) {
            return i2;
        }
        if (!n.b(this.locale_questionId, object.locale_questionId)) {
            return i2;
        }
        return i;
    }

    public final List<String> getChildOrderList() {
        return this.childOrderList;
    }

    public final String getLocale() {
        return this.locale;
    }

    public final String getLocale_questionId() {
        return this.locale_questionId;
    }

    public final String getQuestionId() {
        return this.questionId;
    }

    public final String getText() {
        return this.text;
    }

    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    public int hashCode() {
        return i10 += i16;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("OnboardingQuestionEntity(questionId=");
        stringBuilder.append(this.questionId);
        stringBuilder.append(", text=");
        stringBuilder.append(this.text);
        stringBuilder.append(", updatedAt=");
        stringBuilder.append(this.updatedAt);
        stringBuilder.append(", locale=");
        stringBuilder.append(this.locale);
        stringBuilder.append(", childOrderList=");
        stringBuilder.append(this.childOrderList);
        stringBuilder.append(", locale_questionId=");
        stringBuilder.append(this.locale_questionId);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
