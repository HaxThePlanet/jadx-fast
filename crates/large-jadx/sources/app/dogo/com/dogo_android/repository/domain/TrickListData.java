package app.dogo.com.dogo_android.repository.domain;

import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: TrickListData.kt */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0011\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0086\u0008\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\u0008\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0008\u0018\u00010\u0007\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0008\u0018\u00010\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\nHÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\u0008\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0008\u0018\u00010\u00072\u0008\u0008\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\n2\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\t\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0008\u0018\u00010\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013¨\u0006\u001e", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/TrickListData;", "", "dogId", "", "section", "Lapp/dogo/com/dogo_android/repository/domain/LibrarySection;", "trickList", "", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "shouldShowWorkoutUnlocked", "", "(Ljava/lang/String;Lapp/dogo/com/dogo_android/repository/domain/LibrarySection;Ljava/util/List;Z)V", "getDogId", "()Ljava/lang/String;", "getSection", "()Lapp/dogo/com/dogo_android/repository/domain/LibrarySection;", "getShouldShowWorkoutUnlocked", "()Z", "getTrickList", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class TrickListData {

    private final String dogId;
    private final LibrarySection section;
    private final boolean shouldShowWorkoutUnlocked;
    private final List<TrickItem> trickList;
    public TrickListData(String str, LibrarySection librarySection, List<TrickItem> list, boolean z) {
        n.f(str, "dogId");
        super();
        this.dogId = str;
        this.section = librarySection;
        this.trickList = list;
        this.shouldShowWorkoutUnlocked = z;
    }

    public final String getDogId() {
        return this.dogId;
    }

    public final LibrarySection getSection() {
        return this.section;
    }

    public final boolean getShouldShowWorkoutUnlocked() {
        return this.shouldShowWorkoutUnlocked;
    }

    public final List<TrickItem> getTrickList() {
        return this.trickList;
    }

    public /* synthetic */ TrickListData(String str, LibrarySection librarySection, List list, boolean z, int i, g gVar) {
        i = 0;
        i = i & 2 != 0 ? i : i;
        i = i & 4 != 0 ? i : i;
        int i2 = i & 8 != 0 ? 0 : i2;
        this(str, librarySection, list, z);
    }

    public static /* synthetic */ TrickListData copy$default(TrickListData list, String str, LibrarySection librarySection, List list2, boolean z, int i, Object object) {
        String dogId2;
        app.dogo.com.dogo_android.repository.domain.LibrarySection section2;
        List trickList2;
        boolean shouldShowWorkoutUnlocked2;
        if (i & 1 != 0) {
        }
        if (i & 2 != 0) {
        }
        if (i & 4 != 0) {
        }
        if (i & 8 != 0) {
        }
        return list.copy(dogId2, section2, trickList2, shouldShowWorkoutUnlocked2);
    }

    /* operator */ public final String component1() {
        return this.dogId;
    }

    /* operator */ public final LibrarySection component2() {
        return this.section;
    }

    /* operator */ public final List<TrickItem> component3() {
        return this.trickList;
    }

    /* operator */ public final boolean component4() {
        return this.shouldShowWorkoutUnlocked;
    }

    public final TrickListData copy(String dogId, LibrarySection section, List<TrickItem> trickList, boolean shouldShowWorkoutUnlocked) {
        n.f(dogId, "dogId");
        return new TrickListData(dogId, section, trickList, shouldShowWorkoutUnlocked);
    }

    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z6 = false;
        if (!(other instanceof TrickListData)) {
            return false;
        }
        if (!n.b(this.dogId, other.dogId)) {
            return false;
        }
        if (!n.b(this.section, other.section)) {
            return false;
        }
        if (!n.b(this.trickList, other.trickList)) {
            return false;
        }
        return this.shouldShowWorkoutUnlocked != other.shouldShowWorkoutUnlocked ? z6 : z;
    }

    public int hashCode() {
        int i;
        boolean shouldShowWorkoutUnlocked2 = true;
        i = 0;
        if (this.section == null) {
        } else {
            i = this.section.hashCode();
        }
        if (this.trickList != null) {
            i = this.trickList.hashCode();
        }
        if (this.shouldShowWorkoutUnlocked) {
            int i9 = 1;
        }
        return (this.dogId.hashCode() * 31) + i * 31 + i * 31 + shouldShowWorkoutUnlocked2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "TrickListData(dogId=";
        String str3 = ", section=";
        String str4 = ", trickList=";
        String str5 = ", shouldShowWorkoutUnlocked=";
        str = str2 + this.dogId + str3 + this.section + str4 + this.trickList + str5 + this.shouldShowWorkoutUnlocked + 41;
        return str;
    }
}
