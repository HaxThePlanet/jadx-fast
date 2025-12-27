package app.dogo.com.dogo_android.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: ChallengeFilterItem.kt */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0008\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\"\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001:\u0001\u0014B\u000f\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u001d\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\u0008J\u0011\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0007H\u0086\u0002J\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0013R\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u000c\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000eR\u0014\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015", d2 = {"Lapp/dogo/com/dogo_android/model/ChallengeFilterItem;", "Ljava/io/Serializable;", "filterType", "Lapp/dogo/com/dogo_android/model/ChallengeFilterItem$FilterTypes;", "(Lapp/dogo/com/dogo_android/model/ChallengeFilterItem$FilterTypes;)V", "values", "Ljava/util/HashSet;", "", "(Lapp/dogo/com/dogo_android/model/ChallengeFilterItem$FilterTypes;Ljava/util/HashSet;)V", "<set-?>", "getFilterType", "()Lapp/dogo/com/dogo_android/model/ChallengeFilterItem$FilterTypes;", "id", "getId", "()Ljava/lang/String;", "contains", "", "s", "getValues", "", "FilterTypes", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class ChallengeFilterItem implements Serializable {

    private ChallengeFilterItem.FilterTypes filterType;
    private HashSet<String> values = new HashSet<>();

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\n\u0008\u0086\u0001\u0018\u0000 \u000c2\u0008\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000cB\u000f\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\"\u0004\u0008\u0007\u0010\u0008j\u0002\u0008\tj\u0002\u0008\nj\u0002\u0008\u000b¨\u0006\r", d2 = {"Lapp/dogo/com/dogo_android/model/ChallengeFilterItem$FilterTypes;", "", "id", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "LATEST_ENTRIES_24", "LATEST_7_DAYS", "FEATURED", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum FilterTypes {

        FEATURED,
        LATEST_7_DAYS,
        LATEST_ENTRIES_24;

        private String id;
        @Override // java.lang.Enum
        public final String getId() {
            return this.id;
        }

        @Override // java.lang.Enum
        public final void setId(String str) {
            n.f(str, "<set-?>");
            this.id = str;
        }

        private static final /* synthetic */ ChallengeFilterItem.FilterTypes[] $values() {
            app.dogo.com.dogo_android.model.ChallengeFilterItem.FilterTypes[] arr = new ChallengeFilterItem.FilterTypes[3];
            return new ChallengeFilterItem.FilterTypes[] { ChallengeFilterItem_FilterTypes.LATEST_ENTRIES_24, ChallengeFilterItem_FilterTypes.LATEST_7_DAYS, ChallengeFilterItem_FilterTypes.FEATURED };
        }

        public static final Set<ChallengeFilterItem.FilterTypes> getPossibleFilters() {
            return ChallengeFilterItem_FilterTypes.INSTANCE.getPossibleFilters();
        }

        public static final ChallengeFilterItem.FilterTypes parseFilterType(String str) {
            return ChallengeFilterItem_FilterTypes.INSTANCE.parseFilterType(str);
        }
    }
    public ChallengeFilterItem(ChallengeFilterItem.FilterTypes filterTypes) {
        n.f(filterTypes, "filterType");
        super();
        HashSet hashSet = new HashSet();
        this.filterType = filterTypes;
    }

    /* operator */ public final boolean contains(String s) {
        n.f(s, "s");
        return this.values.contains(s);
    }

    public final ChallengeFilterItem.FilterTypes getFilterType() {
        return this.filterType;
    }

    public final String getId() {
        return this.filterType.getId();
    }

    public final Set<String> getValues() {
        return this.values;
    }

    public ChallengeFilterItem(ChallengeFilterItem.FilterTypes filterTypes, HashSet<String> hashSet) {
        n.f(filterTypes, "filterType");
        n.f(hashSet, "values");
        super();
        hashSet = new HashSet();
        this.filterType = filterTypes;
        this.values = hashSet;
    }
}
