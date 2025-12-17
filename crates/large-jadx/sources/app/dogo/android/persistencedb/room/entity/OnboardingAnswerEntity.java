package app.dogo.android.persistencedb.room.entity;

import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0011\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u000bR\u0011\u0010\u0008\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010¨\u0006\u001d", d2 = {"Lapp/dogo/android/persistencedb/room/entity/OnboardingAnswerEntity;", "", "answerId", "", "text", "updatedAt", "", "locale", "locale_answerId", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;)V", "getAnswerId", "()Ljava/lang/String;", "getLocale", "getLocale_answerId", "getText", "getUpdatedAt", "()J", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class OnboardingAnswerEntity {

    private final String answerId;
    private final String locale;
    private final String locale_answerId;
    private final String text;
    private final long updatedAt;
    public OnboardingAnswerEntity(String string, String string2, long l3, String string4, String string5) {
        n.f(string, "answerId");
        n.f(string2, "text");
        n.f(string5, "locale");
        n.f(obj7, "locale_answerId");
        super();
        this.answerId = string;
        this.text = string2;
        this.updatedAt = l3;
        this.locale = string5;
        this.locale_answerId = obj7;
    }

    public OnboardingAnswerEntity(String string, String string2, long l3, String string4, String string5, int i6, g g7) {
        String obj13;
        int obj14;
        if (g7 &= 16 != 0) {
            obj13 = new StringBuilder();
            obj13.append(string5);
            obj13.append('_');
            obj13.append(string);
            obj13 = obj13.toString();
        }
        super(string, string2, l3, obj4, string5, obj13);
    }

    public static app.dogo.android.persistencedb.room.entity.OnboardingAnswerEntity copy$default(app.dogo.android.persistencedb.room.entity.OnboardingAnswerEntity onboardingAnswerEntity, String string2, String string3, long l4, String string5, String string6, int i7, Object object8) {
        String obj5;
        String obj6;
        long obj7;
        String obj9;
        String obj10;
        if (object8 & 1 != 0) {
            obj5 = onboardingAnswerEntity.answerId;
        }
        if (object8 & 2 != 0) {
            obj6 = onboardingAnswerEntity.text;
        }
        if (object8 & 4 != 0) {
            obj7 = onboardingAnswerEntity.updatedAt;
        }
        if (object8 & 8 != 0) {
            obj9 = onboardingAnswerEntity.locale;
        }
        if (object8 & 16 != 0) {
            obj10 = onboardingAnswerEntity.locale_answerId;
        }
        return onboardingAnswerEntity.copy(obj5, obj6, obj7, obj10, obj9);
    }

    public final String component1() {
        return this.answerId;
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

    public final String component5() {
        return this.locale_answerId;
    }

    public final app.dogo.android.persistencedb.room.entity.OnboardingAnswerEntity copy(String string, String string2, long l3, String string4, String string5) {
        n.f(string, "answerId");
        n.f(string2, "text");
        n.f(string5, "locale");
        n.f(obj14, "locale_answerId");
        super(string, string2, l3, obj5, string5, obj14);
        return onboardingAnswerEntity;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof OnboardingAnswerEntity) {
            return i2;
        }
        if (!n.b(this.answerId, object.answerId)) {
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
        if (!n.b(this.locale_answerId, object.locale_answerId)) {
            return i2;
        }
        return i;
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

    public int hashCode() {
        return i8 += i13;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("OnboardingAnswerEntity(answerId=");
        stringBuilder.append(this.answerId);
        stringBuilder.append(", text=");
        stringBuilder.append(this.text);
        stringBuilder.append(", updatedAt=");
        stringBuilder.append(this.updatedAt);
        stringBuilder.append(", locale=");
        stringBuilder.append(this.locale);
        stringBuilder.append(", locale_answerId=");
        stringBuilder.append(this.locale_answerId);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
