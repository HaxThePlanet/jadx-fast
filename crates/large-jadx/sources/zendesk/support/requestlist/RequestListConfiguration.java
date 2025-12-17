package zendesk.support.requestlist;

import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import o.a.a;
import o.a.c;

/* loaded from: classes3.dex */
public class RequestListConfiguration implements a {

    private final List<a> configurations;
    private final boolean contactUsButtonVisible;

    public static class Builder {

        private List<a> configurations;
        private boolean contactUsButtonVisible = true;
        public Builder() {
            super();
            ArrayList arrayList = new ArrayList();
            this.configurations = arrayList;
            int i = 1;
        }

        static boolean access$000(zendesk.support.requestlist.RequestListConfiguration.Builder requestListConfiguration$Builder) {
            return builder.contactUsButtonVisible;
        }

        static List access$100(zendesk.support.requestlist.RequestListConfiguration.Builder requestListConfiguration$Builder) {
            return builder.configurations;
        }

        private void setConfigurations(List<a> list) {
            this.configurations = list;
        }

        public a config() {
            RequestListConfiguration requestListConfiguration = new RequestListConfiguration(this, 0);
            return requestListConfiguration;
        }

        public Intent intent(Context context, List<a> list2) {
            setConfigurations(list2);
            Intent intent = new Intent(context, RequestListActivity.class);
            c.c(intent, config());
            return intent;
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

        public zendesk.support.requestlist.RequestListConfiguration.Builder withContactUsButtonVisible(boolean z) {
            this.contactUsButtonVisible = z;
            return this;
        }
    }
    private RequestListConfiguration(zendesk.support.requestlist.RequestListConfiguration.Builder requestListConfiguration$Builder) {
        super();
        this.contactUsButtonVisible = RequestListConfiguration.Builder.access$000(builder);
        this.configurations = RequestListConfiguration.Builder.access$100(builder);
    }

    RequestListConfiguration(zendesk.support.requestlist.RequestListConfiguration.Builder requestListConfiguration$Builder, zendesk.support.requestlist.RequestListConfiguration.1 requestListConfiguration$12) {
        super(builder);
    }

    public List<a> getConfigurations() {
        return c.a(this.configurations, this);
    }

    @Override // o.a.a
    boolean isContactUsButtonVisible() {
        return this.contactUsButtonVisible;
    }
}
