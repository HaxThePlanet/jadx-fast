package zendesk.support;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes3.dex */
public class ArticleItem implements zendesk.support.HelpItem {

    private Long id;
    private String name;
    @SerializedName("section_id")
    private Long sectionId;
    public ArticleItem(Long long, Long long2, String string3) {
        super();
        this.id = long;
        this.sectionId = long2;
        this.name = string3;
    }

    @Override // zendesk.support.HelpItem
    public boolean equals(Object object) {
        boolean equals2;
        boolean equals;
        Class class2;
        Object class;
        if (this == object) {
            return 1;
        }
        final int i = 0;
        if (object != null) {
            if (getClass() != object.getClass()) {
            } else {
                Long num = this.id;
                if (num != null) {
                    if (!num.equals(object.id)) {
                        return i;
                    }
                } else {
                    if (object.id != null) {
                    }
                }
                Long sectionId = this.sectionId;
                final Long obj5 = object.sectionId;
                if (sectionId != null) {
                    equals2 = sectionId.equals(obj5);
                } else {
                    if (obj5 == null) {
                    } else {
                        equals2 = i;
                    }
                }
            }
            return equals2;
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
        return this.sectionId;
    }

    @Override // zendesk.support.HelpItem
    public int getViewType() {
        return 3;
    }

    @Override // zendesk.support.HelpItem
    public int hashCode() {
        int i;
        int i2;
        Long num = this.id;
        if (num != null) {
            i = num.hashCode();
        } else {
            i = i2;
        }
        final Long sectionId = this.sectionId;
        if (sectionId != null) {
            i2 = sectionId.hashCode();
        }
        return i3 += i2;
    }
}
