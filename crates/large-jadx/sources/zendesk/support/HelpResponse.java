package zendesk.support;

import com.google.gson.annotations.SerializedName;
import f.g.e.a;
import java.util.List;

/* loaded from: classes3.dex */
class HelpResponse {

    private List<zendesk.support.CategoryItem> categories;
    @SerializedName("category_count")
    private int categoryCount;
    public List<zendesk.support.CategoryItem> getCategories() {
        return a.c(this.categories);
    }

    public int getCategoryCount() {
        return this.categoryCount;
    }
}
