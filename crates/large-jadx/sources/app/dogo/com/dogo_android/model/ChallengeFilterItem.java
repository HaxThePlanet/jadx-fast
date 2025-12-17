package app.dogo.com.dogo_android.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0008\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\"\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001:\u0001\u0014B\u000f\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u001d\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\u0008J\u0011\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0007H\u0086\u0002J\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0013R\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u000c\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000eR\u0014\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015", d2 = {"Lapp/dogo/com/dogo_android/model/ChallengeFilterItem;", "Ljava/io/Serializable;", "filterType", "Lapp/dogo/com/dogo_android/model/ChallengeFilterItem$FilterTypes;", "(Lapp/dogo/com/dogo_android/model/ChallengeFilterItem$FilterTypes;)V", "values", "Ljava/util/HashSet;", "", "(Lapp/dogo/com/dogo_android/model/ChallengeFilterItem$FilterTypes;Ljava/util/HashSet;)V", "<set-?>", "getFilterType", "()Lapp/dogo/com/dogo_android/model/ChallengeFilterItem$FilterTypes;", "id", "getId", "()Ljava/lang/String;", "contains", "", "s", "getValues", "", "FilterTypes", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ChallengeFilterItem implements Serializable {

    private app.dogo.com.dogo_android.model.ChallengeFilterItem.FilterTypes filterType;
    private HashSet<String> values;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\n\u0008\u0086\u0001\u0018\u0000 \u000c2\u0008\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000cB\u000f\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\"\u0004\u0008\u0007\u0010\u0008j\u0002\u0008\tj\u0002\u0008\nj\u0002\u0008\u000b¨\u0006\r", d2 = {"Lapp/dogo/com/dogo_android/model/ChallengeFilterItem$FilterTypes;", "", "id", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "LATEST_ENTRIES_24", "LATEST_7_DAYS", "FEATURED", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static enum FilterTypes {

        LATEST_ENTRIES_24("latest_24"),
        LATEST_7_DAYS("latest_24"),
        FEATURED("latest_24");

        private String id;
        private static final app.dogo.com.dogo_android.model.ChallengeFilterItem.FilterTypes[] $values() {
            app.dogo.com.dogo_android.model.ChallengeFilterItem.FilterTypes[] arr = new ChallengeFilterItem.FilterTypes[3];
            return arr;
        }

        public static final Set<app.dogo.com.dogo_android.model.ChallengeFilterItem.FilterTypes> getPossibleFilters() {
            return ChallengeFilterItem.FilterTypes.Companion.getPossibleFilters();
        }

        public static final app.dogo.com.dogo_android.model.ChallengeFilterItem.FilterTypes parseFilterType(String string) {
            return ChallengeFilterItem.FilterTypes.Companion.parseFilterType(string);
        }

        @Override // java.lang.Enum
        public final String getId() {
            return this.id;
        }

        @Override // java.lang.Enum
        public final void setId(String string) {
            n.f(string, "<set-?>");
            this.id = string;
        }
    }
    public ChallengeFilterItem(app.dogo.com.dogo_android.model.ChallengeFilterItem.FilterTypes challengeFilterItem$FilterTypes) {
        n.f(filterTypes, "filterType");
        super();
        HashSet hashSet = new HashSet();
        this.values = hashSet;
        this.filterType = filterTypes;
    }

    public ChallengeFilterItem(app.dogo.com.dogo_android.model.ChallengeFilterItem.FilterTypes challengeFilterItem$FilterTypes, HashSet<String> hashSet2) {
        n.f(filterTypes, "filterType");
        n.f(hashSet2, "values");
        super();
        HashSet hashSet = new HashSet();
        this.values = hashSet;
        this.filterType = filterTypes;
        this.values = hashSet2;
    }

    @Override // java.io.Serializable
    public final boolean contains(String string) {
        n.f(string, "s");
        return this.values.contains(string);
    }

    @Override // java.io.Serializable
    public final app.dogo.com.dogo_android.model.ChallengeFilterItem.FilterTypes getFilterType() {
        return this.filterType;
    }

    @Override // java.io.Serializable
    public final String getId() {
        return this.filterType.getId();
    }

    public final Set<String> getValues() {
        return this.values;
    }
}
