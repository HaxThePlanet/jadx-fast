package app.dogo.com.dogo_android.repository.domain;

import kotlin.Metadata;

/* compiled from: SettingsResults.kt */
@Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u000e\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0008\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000c\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\u0008R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u0008¨\u0006\u0015", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/SettingsResults;", "", "premium", "", "canResubscribe", "hasZendeskRequestHistory", "(ZZZ)V", "getCanResubscribe", "()Z", "getHasZendeskRequestHistory", "getPremium", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class SettingsResults {

    private final boolean canResubscribe;
    private final boolean hasZendeskRequestHistory;
    private final boolean premium;
    public SettingsResults(boolean z, boolean z2, boolean z3) {
        super();
        this.premium = z;
        this.canResubscribe = z2;
        this.hasZendeskRequestHistory = z3;
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

    public static /* synthetic */ SettingsResults copy$default(SettingsResults set, boolean z, boolean z2, boolean z3, int i, Object object) {
        boolean premium2;
        boolean canResubscribe2;
        boolean hasZendeskRequestHistory2;
        if (i & 1 != 0) {
        }
        if (i & 2 != 0) {
        }
        if (i & 4 != 0) {
        }
        return set.copy(premium2, canResubscribe2, hasZendeskRequestHistory2);
    }

    /* operator */ public final boolean component1() {
        return this.premium;
    }

    /* operator */ public final boolean component2() {
        return this.canResubscribe;
    }

    /* operator */ public final boolean component3() {
        return this.hasZendeskRequestHistory;
    }

    public final SettingsResults copy(boolean premium, boolean canResubscribe, boolean hasZendeskRequestHistory) {
        return new SettingsResults(premium, canResubscribe, hasZendeskRequestHistory);
    }

    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z3 = false;
        if (!(other instanceof SettingsResults)) {
            return false;
        }
        if (this.premium != other.premium) {
            return false;
        }
        if (this.canResubscribe != other.canResubscribe) {
            return false;
        }
        return this.hasZendeskRequestHistory != other.hasZendeskRequestHistory ? z3 : z;
    }

    public int hashCode() {
        boolean premium2;
        boolean hasZendeskRequestHistory2 = true;
        boolean canResubscribe2;
        int i = 1;
        if (this.premium) {
        }
        if (this.canResubscribe) {
        }
        if (!(this.hasZendeskRequestHistory)) {
        }
        return (premium2 * 31) + canResubscribe2 * 31 + hasZendeskRequestHistory2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "SettingsResults(premium=";
        String str3 = ", canResubscribe=";
        String str4 = ", hasZendeskRequestHistory=";
        str = str2 + this.premium + str3 + this.canResubscribe + str4 + this.hasZendeskRequestHistory + 41;
        return str;
    }
}
