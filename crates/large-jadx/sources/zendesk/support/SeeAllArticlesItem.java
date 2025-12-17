package zendesk.support;

/* loaded from: classes3.dex */
public class SeeAllArticlesItem implements zendesk.support.HelpItem {

    private boolean isLoading;
    private zendesk.support.SectionItem section;
    public SeeAllArticlesItem(zendesk.support.SectionItem sectionItem) {
        super();
        this.section = sectionItem;
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
                zendesk.support.SectionItem section = this.section;
                final zendesk.support.SectionItem obj5 = object.section;
                if (section != null) {
                    equals = section.equals(obj5);
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
        return this.section.getId();
    }

    @Override // zendesk.support.HelpItem
    public String getName() {
        return "";
    }

    @Override // zendesk.support.HelpItem
    public Long getParentId() {
        return this.section.getParentId();
    }

    @Override // zendesk.support.HelpItem
    public zendesk.support.SectionItem getSection() {
        return this.section;
    }

    @Override // zendesk.support.HelpItem
    public int getViewType() {
        return 4;
    }

    @Override // zendesk.support.HelpItem
    public int hashCode() {
        int i;
        zendesk.support.SectionItem section = this.section;
        if (section != null) {
            i = section.hashCode();
        } else {
            i = 0;
        }
        return i;
    }

    @Override // zendesk.support.HelpItem
    public boolean isLoading() {
        return this.isLoading;
    }

    @Override // zendesk.support.HelpItem
    public void setLoading(boolean z) {
        this.isLoading = z;
    }
}
