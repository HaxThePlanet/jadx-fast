package app.dogo.com.dogo_android.repository.domain;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u000e\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0008\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000c\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\u0008R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u0008¨\u0006\u0015", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/SettingsResults;", "", "premium", "", "canResubscribe", "hasZendeskRequestHistory", "(ZZZ)V", "getCanResubscribe", "()Z", "getHasZendeskRequestHistory", "getPremium", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SettingsResults {

    private final boolean canResubscribe;
    private final boolean hasZendeskRequestHistory;
    private final boolean premium;
    public SettingsResults(boolean z, boolean z2, boolean z3) {
        super();
        this.premium = z;
        this.canResubscribe = z2;
        this.hasZendeskRequestHistory = z3;
    }

    public static app.dogo.com.dogo_android.repository.domain.SettingsResults copy$default(app.dogo.com.dogo_android.repository.domain.SettingsResults settingsResults, boolean z2, boolean z3, boolean z4, int i5, Object object6) {
        boolean obj1;
        boolean obj2;
        boolean obj3;
        if (i5 & 1 != 0) {
            obj1 = settingsResults.premium;
        }
        if (i5 & 2 != 0) {
            obj2 = settingsResults.canResubscribe;
        }
        if (i5 &= 4 != 0) {
            obj3 = settingsResults.hasZendeskRequestHistory;
        }
        return settingsResults.copy(obj1, obj2, obj3);
    }

    public final boolean component1() {
        return this.premium;
    }

    public final boolean component2() {
        return this.canResubscribe;
    }

    public final boolean component3() {
        return this.hasZendeskRequestHistory;
    }

    public final app.dogo.com.dogo_android.repository.domain.SettingsResults copy(boolean z, boolean z2, boolean z3) {
        SettingsResults settingsResults = new SettingsResults(z, z2, z3);
        return settingsResults;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof SettingsResults) {
            return i2;
        }
        if (this.premium != object.premium) {
            return i2;
        }
        if (this.canResubscribe != object.canResubscribe) {
            return i2;
        }
        if (this.hasZendeskRequestHistory != object.hasZendeskRequestHistory) {
            return i2;
        }
        return i;
    }

    public final boolean getCanResubscribe() {
        return this.canResubscribe;
    }

    public final boolean getHasZendeskRequestHistory() {
        return this.hasZendeskRequestHistory;
    }

    public final boolean getPremium() {
        return this.premium;
    }

    public int hashCode() {
        boolean premium;
        boolean i;
        boolean canResubscribe;
        i = 1;
        if (this.premium) {
            premium = i;
        }
        if (this.canResubscribe) {
            canResubscribe = i;
        }
        boolean hasZendeskRequestHistory = this.hasZendeskRequestHistory;
        if (hasZendeskRequestHistory) {
        } else {
            i = hasZendeskRequestHistory;
        }
        return i4 += i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SettingsResults(premium=");
        stringBuilder.append(this.premium);
        stringBuilder.append(", canResubscribe=");
        stringBuilder.append(this.canResubscribe);
        stringBuilder.append(", hasZendeskRequestHistory=");
        stringBuilder.append(this.hasZendeskRequestHistory);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
