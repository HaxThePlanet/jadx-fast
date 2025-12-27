package app.dogo.com.dogo_android.repository.domain;

import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: RecentlyViewedTricks.kt */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u000b\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0008\u0018\u00002\u00020\u0001B#\u0012\u0010\u0008\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\tJ,\u0010\u000f\u001a\u00020\u00002\u0010\u0008\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\n\u001a\u0004\u0008\u0008\u0010\tR\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u0017", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/RecentlyViewedTricks;", "", "trickList", "", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "scrollPosition", "", "(Ljava/util/List;Ljava/lang/Integer;)V", "getScrollPosition", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTrickList", "()Ljava/util/List;", "component1", "component2", "copy", "(Ljava/util/List;Ljava/lang/Integer;)Lapp/dogo/com/dogo_android/repository/domain/RecentlyViewedTricks;", "equals", "", "other", "hashCode", "toString", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class RecentlyViewedTricks {

    private final Integer scrollPosition;
    private final List<TrickItem> trickList;
    public RecentlyViewedTricks(List<TrickItem> list, Integer integer) {
        super();
        this.trickList = list;
        this.scrollPosition = integer;
    }

    public final Integer getScrollPosition() {
        return this.scrollPosition;
    }

    public final List<TrickItem> getTrickList() {
        return this.trickList;
    }

    public /* synthetic */ RecentlyViewedTricks(List list, Integer integer, int i, g gVar) {
        List list2;
        Integer num;
        i = 0;
        i = i & 1 != 0 ? i : i;
        i = i & 2 != 0 ? i : i;
        this(list2, num);
    }

    public RecentlyViewedTricks() {
        final List list = null;
        this(list, list, 3, list);
    }

    public static /* synthetic */ RecentlyViewedTricks copy$default(RecentlyViewedTricks recentlyViewedTricks, List list, Integer integer, int i, Object object) {
        List trickList2;
        Integer scrollPosition2;
        if (i & 1 != 0) {
        }
        if (i & 2 != 0) {
        }
        return recentlyViewedTricks.copy(trickList2, scrollPosition2);
    }

    /* operator */ public final List<TrickItem> component1() {
        return this.trickList;
    }

    /* operator */ public final Integer component2() {
        return this.scrollPosition;
    }

    public final RecentlyViewedTricks copy(List<TrickItem> trickList, Integer scrollPosition) {
        return new RecentlyViewedTricks(trickList, scrollPosition);
    }

    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z4 = false;
        if (!(other instanceof RecentlyViewedTricks)) {
            return false;
        }
        if (!n.b(this.trickList, other.trickList)) {
            return false;
        }
        return !n.b(this.scrollPosition, other.scrollPosition) ? z4 : z;
    }

    public int hashCode() {
        int i;
        i = 0;
        if (this.trickList == null) {
        } else {
            i = this.trickList.hashCode();
        }
        if (this.scrollPosition != null) {
            i = this.scrollPosition.hashCode();
        }
        return (i * 31) + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "RecentlyViewedTricks(trickList=";
        String str3 = ", scrollPosition=";
        str = str2 + this.trickList + str3 + this.scrollPosition + 41;
        return str;
    }
}
