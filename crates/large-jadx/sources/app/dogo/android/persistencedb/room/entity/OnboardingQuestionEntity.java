package app.dogo.android.persistencedb.room.entity;

import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: OnboardingQuestionEntity.kt */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0008\u0013\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u000c\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\u00030\t\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u00020\u00030\tHÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003JK\u0010\u001b\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00032\u000e\u0008\u0002\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\u00030\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\u00030\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014¨\u0006\"", d2 = {"Lapp/dogo/android/persistencedb/room/entity/OnboardingQuestionEntity;", "", "questionId", "", "text", "updatedAt", "", "locale", "childOrderList", "", "locale_questionId", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getChildOrderList", "()Ljava/util/List;", "getLocale", "()Ljava/lang/String;", "getLocale_questionId", "getQuestionId", "getText", "getUpdatedAt", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class OnboardingQuestionEntity {

    private final List<String> childOrderList;
    private final String locale;
    private final String locale_questionId;
    private final String questionId;
    private final String text;
    private final long updatedAt;
    public OnboardingQuestionEntity(String str, String str2, long j, String str3, List<String> list, String str4) {
        n.f(str, "questionId");
        n.f(str2, "text");
        n.f(str3, "locale");
        n.f(list, "childOrderList");
        n.f(str4, "locale_questionId");
        super();
        this.questionId = str;
        this.text = str2;
        this.updatedAt = j;
        this.locale = str3;
        this.childOrderList = list;
        this.locale_questionId = str4;
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

    public /* synthetic */ OnboardingQuestionEntity(String str, String str2, long j, String str3, List list, String str4, int i, g gVar) {
        String i72;
        if (i & 32 != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            list52 = str3;
            char c = '_';
            str3 = str;
            i72 = str3 + c + str;
        } else {
            str3 = str;
            list52 = str3;
            i72 = str4;
        }
        this(str, str2, j, str7, str3, list, i72);
    }

    public static /* synthetic */ OnboardingQuestionEntity copy$default(OnboardingQuestionEntity onboardingQuestionEntity, String str, String str2, long j, String str3, List list, String str4, int i, Object object) {
        String str22;
        String str32;
        long j42;
        String list62;
        Object str72;
        String i82;
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
        if (i & 32 != 0) {
        }
        return onboardingQuestionEntity.copy(str22, str32, j42, list62, str72, i82);
    }

    /* operator */ public final String component1() {
        return this.questionId;
    }

    /* operator */ public final String component2() {
        return this.text;
    }

    /* operator */ public final long component3() {
        return this.updatedAt;
    }

    /* operator */ public final String component4() {
        return this.locale;
    }

    /* operator */ public final List<String> component5() {
        return this.childOrderList;
    }

    /* operator */ public final String component6() {
        return this.locale_questionId;
    }

    public final OnboardingQuestionEntity copy(String questionId, String text, long updatedAt, String locale, List<String> childOrderList, String locale_questionId) {
        n.f(questionId, "questionId");
        n.f(text, "text");
        n.f(locale, "locale");
        n.f(childOrderList, "childOrderList");
        final Object obj = locale_questionId;
        n.f(obj, "locale_questionId");
        OnboardingQuestionEntity onboardingQuestionEntity = new OnboardingQuestionEntity(questionId, text, updatedAt, str6, locale, childOrderList, obj);
        return onboardingQuestionEntity;
    }

    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z7 = false;
        if (!(other instanceof OnboardingQuestionEntity)) {
            return false;
        }
        if (!n.b(this.questionId, other.questionId)) {
            return false;
        }
        if (!n.b(this.text, other.text)) {
            return false;
        }
        if (this.updatedAt != other.updatedAt) {
            return false;
        }
        if (!n.b(this.locale, other.locale)) {
            return false;
        }
        if (!n.b(this.childOrderList, other.childOrderList)) {
            return false;
        }
        return !n.b(this.locale_questionId, other.locale_questionId) ? z7 : z;
    }

    public int hashCode() {
        return (this.questionId.hashCode() * 31) + this.text.hashCode() * 31 + Long.hashCode(this.updatedAt) * 31 + this.locale.hashCode() * 31 + this.childOrderList.hashCode() * 31 + this.locale_questionId.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "OnboardingQuestionEntity(questionId=";
        String str3 = ", text=";
        String str4 = ", updatedAt=";
        String str5 = ", locale=";
        String str6 = ", childOrderList=";
        String str7 = ", locale_questionId=";
        str = str2 + this.questionId + str3 + this.text + str4 + this.updatedAt + str5 + this.locale + str6 + this.childOrderList + str7 + this.locale_questionId + 41;
        return str;
    }
}
