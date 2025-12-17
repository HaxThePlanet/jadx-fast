package zendesk.support.guide;

import android.content.Context;
import android.content.Intent;
import f.g.c.a;
import f.g.e.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import o.a.a;
import o.a.b;
import zendesk.messaging.Engine;
import zendesk.messaging.EngineListRegistry;

/* loaded from: classes3.dex */
public class HelpCenterConfiguration implements a {

    private final List<Long> categoryIds;
    private final boolean collapseCategories;
    private List<a> configurations;
    private final boolean contactUsButtonVisibility;
    private final String engineRegistryId;
    private final String[] labelNames;
    private final List<Long> sectionIds;
    private final boolean showConversationsMenuButton;

    public static class Builder {

        private List<Long> categoryIds;
        private boolean collapseCategories = false;
        private List<a> configurations;
        private boolean contactUsButtonVisible = true;
        private List<Engine> engines;
        private String[] labelNames;
        private List<Long> sectionIds;
        private boolean showConversationsMenuButton = true;
        public Builder() {
            super();
            this.categoryIds = Collections.emptyList();
            this.sectionIds = Collections.emptyList();
            this.labelNames = new String[0];
            this.engines = Collections.emptyList();
            int i2 = 1;
            ArrayList arrayList = new ArrayList();
            this.configurations = arrayList;
        }

        static List access$000(zendesk.support.guide.HelpCenterConfiguration.Builder helpCenterConfiguration$Builder) {
            return builder.categoryIds;
        }

        static List access$100(zendesk.support.guide.HelpCenterConfiguration.Builder helpCenterConfiguration$Builder) {
            return builder.sectionIds;
        }

        static String[] access$200(zendesk.support.guide.HelpCenterConfiguration.Builder helpCenterConfiguration$Builder) {
            return builder.labelNames;
        }

        static boolean access$300(zendesk.support.guide.HelpCenterConfiguration.Builder helpCenterConfiguration$Builder) {
            return builder.contactUsButtonVisible;
        }

        static boolean access$400(zendesk.support.guide.HelpCenterConfiguration.Builder helpCenterConfiguration$Builder) {
            return builder.collapseCategories;
        }

        static boolean access$500(zendesk.support.guide.HelpCenterConfiguration.Builder helpCenterConfiguration$Builder) {
            return builder.showConversationsMenuButton;
        }

        static List access$600(zendesk.support.guide.HelpCenterConfiguration.Builder helpCenterConfiguration$Builder) {
            return builder.configurations;
        }

        private void setConfigurations(List<a> list) {
            Object retrieveEngineList;
            Class<zendesk.support.guide.HelpCenterConfiguration> obj;
            a obj3;
            this.configurations = list;
            obj3 = b.h().e(list, HelpCenterConfiguration.class);
            if ((HelpCenterConfiguration)obj3 != null) {
                this.contactUsButtonVisible = HelpCenterConfiguration.access$700((HelpCenterConfiguration)obj3);
                this.categoryIds = HelpCenterConfiguration.access$800(obj3);
                this.sectionIds = HelpCenterConfiguration.access$900(obj3);
                this.collapseCategories = HelpCenterConfiguration.access$1000(obj3);
                this.labelNames = HelpCenterConfiguration.access$1100(obj3);
                this.engines = EngineListRegistry.INSTANCE.retrieveEngineList(HelpCenterConfiguration.access$1200(obj3));
                this.showConversationsMenuButton = HelpCenterConfiguration.access$1300(obj3);
            }
        }

        public a config() {
            HelpCenterConfiguration helpCenterConfiguration = new HelpCenterConfiguration(this, EngineListRegistry.INSTANCE.register(this.engines), 0);
            return helpCenterConfiguration;
        }

        public Intent intent(Context context, List<a> list2) {
            setConfigurations(list2);
            Intent obj3 = new Intent(context, HelpCenterActivity.class);
            b.h().c(obj3, config());
            return obj3;
        }

        public Intent intent(Context context, a... a2Arr2) {
            return intent(context, Arrays.asList(a2Arr2));
        }

        public void show(Context context, List<a> list2) {
            context.startActivity(intent(context, list2));
        }

        public void show(Context context, a... a2Arr2) {
            context.startActivity(intent(context, a2Arr2));
        }

        public zendesk.support.guide.HelpCenterConfiguration.Builder withArticlesForCategoryIds(List<Long> list) {
            int emptyList;
            String str;
            String str2;
            if (this.sectionIds.size() > 0) {
                a.k("HelpCenterActivity", "Builder: sections have already been specified. Removing section IDs to set category IDs.", new Object[0]);
                this.sectionIds = Collections.emptyList();
            }
            this.categoryIds = a.c(list);
            return this;
        }

        public zendesk.support.guide.HelpCenterConfiguration.Builder withArticlesForCategoryIds(Long... longArr) {
            return withArticlesForCategoryIds(Arrays.asList(longArr));
        }

        public zendesk.support.guide.HelpCenterConfiguration.Builder withArticlesForSectionIds(List<Long> list) {
            int emptyList;
            String str2;
            String str;
            if (this.categoryIds.size() > 0) {
                a.k("HelpCenterActivity", "Builder: categories have already been specified. Removing category IDs to set section IDs.", new Object[0]);
                this.categoryIds = Collections.emptyList();
            }
            this.sectionIds = a.c(list);
            return this;
        }

        public zendesk.support.guide.HelpCenterConfiguration.Builder withArticlesForSectionIds(Long... longArr) {
            return withArticlesForSectionIds(Arrays.asList(longArr));
        }

        public zendesk.support.guide.HelpCenterConfiguration.Builder withCategoriesCollapsed(boolean z) {
            this.collapseCategories = z;
            return this;
        }

        public zendesk.support.guide.HelpCenterConfiguration.Builder withContactUsButtonVisible(boolean z) {
            this.contactUsButtonVisible = z;
            return this;
        }

        public zendesk.support.guide.HelpCenterConfiguration.Builder withEngines(List<Engine> list) {
            this.engines = list;
            return this;
        }

        public zendesk.support.guide.HelpCenterConfiguration.Builder withEngines(Engine... engineArr) {
            return withEngines(Arrays.asList(engineArr));
        }

        public zendesk.support.guide.HelpCenterConfiguration.Builder withLabelNames(List<String> list) {
            return withLabelNames((String[])list.toArray(new String[0]));
        }

        public zendesk.support.guide.HelpCenterConfiguration.Builder withLabelNames(String... stringArr) {
            if (a.j(stringArr)) {
                this.labelNames = stringArr;
            }
            return this;
        }

        public zendesk.support.guide.HelpCenterConfiguration.Builder withShowConversationsMenuButton(boolean z) {
            this.showConversationsMenuButton = z;
            return this;
        }
    }
    private HelpCenterConfiguration(zendesk.support.guide.HelpCenterConfiguration.Builder helpCenterConfiguration$Builder, String string2) {
        super();
        this.categoryIds = HelpCenterConfiguration.Builder.access$000(builder);
        this.sectionIds = HelpCenterConfiguration.Builder.access$100(builder);
        this.labelNames = HelpCenterConfiguration.Builder.access$200(builder);
        this.contactUsButtonVisibility = HelpCenterConfiguration.Builder.access$300(builder);
        this.collapseCategories = HelpCenterConfiguration.Builder.access$400(builder);
        this.showConversationsMenuButton = HelpCenterConfiguration.Builder.access$500(builder);
        this.configurations = HelpCenterConfiguration.Builder.access$600(builder);
        this.engineRegistryId = string2;
    }

    HelpCenterConfiguration(zendesk.support.guide.HelpCenterConfiguration.Builder helpCenterConfiguration$Builder, String string2, zendesk.support.guide.HelpCenterConfiguration.1 helpCenterConfiguration$13) {
        super(builder, string2);
    }

    static boolean access$1000(zendesk.support.guide.HelpCenterConfiguration helpCenterConfiguration) {
        return helpCenterConfiguration.collapseCategories;
    }

    static String[] access$1100(zendesk.support.guide.HelpCenterConfiguration helpCenterConfiguration) {
        return helpCenterConfiguration.labelNames;
    }

    static String access$1200(zendesk.support.guide.HelpCenterConfiguration helpCenterConfiguration) {
        return helpCenterConfiguration.engineRegistryId;
    }

    static boolean access$1300(zendesk.support.guide.HelpCenterConfiguration helpCenterConfiguration) {
        return helpCenterConfiguration.showConversationsMenuButton;
    }

    static boolean access$700(zendesk.support.guide.HelpCenterConfiguration helpCenterConfiguration) {
        return helpCenterConfiguration.contactUsButtonVisibility;
    }

    static List access$800(zendesk.support.guide.HelpCenterConfiguration helpCenterConfiguration) {
        return helpCenterConfiguration.categoryIds;
    }

    static List access$900(zendesk.support.guide.HelpCenterConfiguration helpCenterConfiguration) {
        return helpCenterConfiguration.sectionIds;
    }

    public List<Long> getCategoryIds() {
        return this.categoryIds;
    }

    public List<a> getConfigurations() {
        return b.h().a(this.configurations, this);
    }

    public List<Engine> getEngines() {
        return EngineListRegistry.INSTANCE.retrieveEngineList(this.engineRegistryId);
    }

    @Override // o.a.a
    public String[] getLabelNames() {
        return this.labelNames;
    }

    public List<Long> getSectionIds() {
        return this.sectionIds;
    }

    @Override // o.a.a
    public boolean isCollapseCategories() {
        return this.collapseCategories;
    }

    @Override // o.a.a
    public boolean isContactUsButtonVisible() {
        return this.contactUsButtonVisibility;
    }

    @Override // o.a.a
    public boolean isShowConversationsMenuButton() {
        return this.showConversationsMenuButton;
    }
}
