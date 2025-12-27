package app.dogo.android.persistencedb.room.entity;

import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: OnboardingAnswerEntity.kt */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0011\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u000bR\u0011\u0010\u0008\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010¨\u0006\u001d", d2 = {"Lapp/dogo/android/persistencedb/room/entity/OnboardingAnswerEntity;", "", "answerId", "", "text", "updatedAt", "", "locale", "locale_answerId", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;)V", "getAnswerId", "()Ljava/lang/String;", "getLocale", "getLocale_answerId", "getText", "getUpdatedAt", "()J", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class OnboardingAnswerEntity {

    private final String answerId;
    private final String locale;
    private final String locale_answerId;
    private final String text;
    private final long updatedAt;
    public OnboardingAnswerEntity(String str, String str2, long j, String str3, String str4) {
        n.f(str, "answerId");
        n.f(str2, "text");
        n.f(str3, "locale");
        n.f(str4, "locale_answerId");
        super();
        this.answerId = str;
        this.text = str2;
        this.updatedAt = j;
        this.locale = str3;
        this.locale_answerId = str4;
    }

    public final String getAnswerId() {
        return this.answerId;
    }

    public final String getLocale() {
        return this.locale;
    }

    public final String getLocale_answerId() {
        return this.locale_answerId;
    }

    public final String getText() {
        return this.text;
    }

    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    public /* synthetic */ OnboardingAnswerEntity(String str, String str2, long j, String str3, String str4, int i, g gVar) {
        String i62;
        i = i & 16;
        if (i & 16 != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            char c = '_';
            i62 = str3 + c + str;
        }
        this(str, str2, j, str7, str3, i62);
    }

    public static /* synthetic */ OnboardingAnswerEntity copy$default(OnboardingAnswerEntity onboardingAnswerEntity, String str, String str2, long j, String str3, String str4, int i, Object object) {
        String str22;
        String str32;
        long j42;
        String str62;
        String i72;
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
        return onboardingAnswerEntity.copy(str22, str32, j42, str62, i72);
    }

    /* operator */ public final String component1() {
        return this.answerId;
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

    /* operator */ public final String component5() {
        return this.locale_answerId;
    }

    public final OnboardingAnswerEntity copy(String answerId, String text, long updatedAt, String locale, String locale_answerId) {
        n.f(answerId, "answerId");
        n.f(text, "text");
        n.f(locale, "locale");
        n.f(locale_answerId, "locale_answerId");
        OnboardingAnswerEntity onboardingAnswerEntity = new OnboardingAnswerEntity(answerId, text, updatedAt, str5, locale, locale_answerId);
        return onboardingAnswerEntity;
    }

    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z6 = false;
        if (!(other instanceof OnboardingAnswerEntity)) {
            return false;
        }
        if (!n.b(this.answerId, other.answerId)) {
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
        return !n.b(this.locale_answerId, other.locale_answerId) ? z6 : z;
    }

    public int hashCode() {
        return (this.answerId.hashCode() * 31) + this.text.hashCode() * 31 + Long.hashCode(this.updatedAt) * 31 + this.locale.hashCode() * 31 + this.locale_answerId.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "OnboardingAnswerEntity(answerId=";
        String str3 = ", text=";
        String str4 = ", updatedAt=";
        String str5 = ", locale=";
        String str6 = ", locale_answerId=";
        str = str2 + this.answerId + str3 + this.text + str4 + this.updatedAt + str5 + this.locale + str6 + this.locale_answerId + 41;
        return str;
    }
}
