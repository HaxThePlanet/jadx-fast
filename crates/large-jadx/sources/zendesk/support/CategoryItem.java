package zendesk.support;

import com.google.gson.annotations.SerializedName;
import f.g.e.a;
import java.util.List;

/* loaded from: classes3.dex */
public class CategoryItem implements zendesk.support.HelpItem {

    private boolean expanded = true;
    @SerializedName("id")
    private Long id;
    @SerializedName("name")
    private String name;
    @SerializedName("section_count")
    private int sectionCount;
    private List<zendesk.support.SectionItem> sections;
    public CategoryItem() {
        super();
        final int i = 1;
    }

    @Override // zendesk.support.HelpItem
    public boolean equals(Object object) {
        int equals;
        Class class2;
        Class class;
        if (this == object) {
            return 1;
        }
        final int i = 0;
        if (object != null) {
            if (getClass() != object.getClass()) {
            } else {
                Long num = this.id;
                final Long obj5 = object.id;
                if (num != null) {
                    equals = num.equals(obj5);
                } else {
                    if (obj5 == null) {
                    } else {
                        equals = i;
                    }
                }
            }
            return equals;
        }
        return i;
    }

    @Override // zendesk.support.HelpItem
    public Long getId() {
        return this.id;
    }

    @Override // zendesk.support.HelpItem
    public String getName() {
        String name;
        if (this.name == null) {
            name = "";
        }
        return name;
    }

    @Override // zendesk.support.HelpItem
    public Long getParentId() {
        return null;
    }

    public List<zendesk.support.SectionItem> getSections() {
        return a.c(this.sections);
    }

    @Override // zendesk.support.HelpItem
    public int getViewType() {
        return 1;
    }

    @Override // zendesk.support.HelpItem
    public int hashCode() {
        int i;
        Long num = this.id;
        if (num != null) {
            i = num.hashCode();
        } else {
            i = 0;
        }
        return i;
    }

    @Override // zendesk.support.HelpItem
    public boolean isExpanded() {
        return this.expanded;
    }

    @Override // zendesk.support.HelpItem
    public boolean setExpanded(boolean z) {
        this.expanded = z;
        return z;
    }

    public void setSections(List<zendesk.support.SectionItem> list) {
        this.sections = a.c(list);
    }
}
