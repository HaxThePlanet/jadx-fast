package zendesk.messaging;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import f.g.e.g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import o.a.a;
import o.a.b;

/* loaded from: classes3.dex */
public class MessagingConfiguration implements a {

    private zendesk.messaging.AgentDetails botAgentDetails;
    private final int botAvatarDrawable;
    private final String botLabelString;
    private final int botLabelStringRes;
    private final List<a> configurations;
    private final String engineRegistryKey;
    private final boolean multilineResponseOptionsEnabled;
    private final String toolbarTitle;
    private final int toolbarTitleRes;

    public static class Builder {

        private int botAvatarDrawable = 0;
        private String botLabelString;
        private int botLabelStringRes;
        private List<a> configurations;
        private List<zendesk.messaging.Engine> engines;
        private boolean multilineResponseOptionsEnabled = false;
        private String toolbarTitle;
        private int toolbarTitleRes;
        public Builder() {
            super();
            ArrayList arrayList = new ArrayList();
            this.configurations = arrayList;
            ArrayList arrayList2 = new ArrayList();
            this.engines = arrayList2;
            this.toolbarTitleRes = R.string.zui_toolbar_title;
            this.botLabelStringRes = R.string.zui_default_bot_name;
            int i = 0;
            int zui_avatar_bot_default = R.drawable.zui_avatar_bot_default;
        }

        static List access$000(zendesk.messaging.MessagingConfiguration.Builder messagingConfiguration$Builder) {
            return builder.configurations;
        }

        static String access$100(zendesk.messaging.MessagingConfiguration.Builder messagingConfiguration$Builder) {
            return builder.toolbarTitle;
        }

        static int access$200(zendesk.messaging.MessagingConfiguration.Builder messagingConfiguration$Builder) {
            return builder.toolbarTitleRes;
        }

        static String access$300(zendesk.messaging.MessagingConfiguration.Builder messagingConfiguration$Builder) {
            return builder.botLabelString;
        }

        static int access$400(zendesk.messaging.MessagingConfiguration.Builder messagingConfiguration$Builder) {
            return builder.botLabelStringRes;
        }

        static int access$500(zendesk.messaging.MessagingConfiguration.Builder messagingConfiguration$Builder) {
            return builder.botAvatarDrawable;
        }

        static boolean access$600(zendesk.messaging.MessagingConfiguration.Builder messagingConfiguration$Builder) {
            return builder.multilineResponseOptionsEnabled;
        }

        public a config(Context context) {
            MessagingConfiguration messagingConfiguration = new MessagingConfiguration(this, EngineListRegistry.INSTANCE.register(this.engines), 0);
            return messagingConfiguration;
        }

        public Intent intent(Context context, List<a> list2) {
            this.configurations = list2;
            Intent intent = new Intent(context, MessagingActivity.class);
            b.h().c(intent, config(context));
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

        public zendesk.messaging.MessagingConfiguration.Builder withEngines(List<zendesk.messaging.Engine> list) {
            this.engines = list;
            return this;
        }

        public zendesk.messaging.MessagingConfiguration.Builder withEngines(zendesk.messaging.Engine... engineArr) {
            this.engines = Arrays.asList(engineArr);
            return this;
        }
    }
    private MessagingConfiguration(zendesk.messaging.MessagingConfiguration.Builder messagingConfiguration$Builder, String string2) {
        super();
        this.configurations = MessagingConfiguration.Builder.access$000(builder);
        this.engineRegistryKey = string2;
        this.toolbarTitle = MessagingConfiguration.Builder.access$100(builder);
        this.toolbarTitleRes = MessagingConfiguration.Builder.access$200(builder);
        this.botLabelString = MessagingConfiguration.Builder.access$300(builder);
        this.botLabelStringRes = MessagingConfiguration.Builder.access$400(builder);
        this.botAvatarDrawable = MessagingConfiguration.Builder.access$500(builder);
        this.multilineResponseOptionsEnabled = MessagingConfiguration.Builder.access$600(builder);
    }

    MessagingConfiguration(zendesk.messaging.MessagingConfiguration.Builder messagingConfiguration$Builder, String string2, zendesk.messaging.MessagingConfiguration.1 messagingConfiguration$13) {
        super(builder, string2);
    }

    private String getBotLabelString(Resources resources) {
        boolean botLabelStringRes;
        String obj2;
        if (g.c(this.botLabelString)) {
            obj2 = this.botLabelString;
        } else {
            obj2 = resources.getString(this.botLabelStringRes);
        }
        return obj2;
    }

    @Override // o.a.a
    zendesk.messaging.AgentDetails getBotAgentDetails(Resources resources) {
        zendesk.messaging.AgentDetails botAgentDetails;
        int i;
        Integer valueOf;
        String str;
        Object obj5;
        if (this.botAgentDetails == null) {
            botAgentDetails = new AgentDetails(getBotLabelString(resources), "ANSWER_BOT", 1, Integer.valueOf(this.botAvatarDrawable));
            this.botAgentDetails = botAgentDetails;
        }
        return this.botAgentDetails;
    }

    public List<a> getConfigurations() {
        return b.h().a(this.configurations, this);
    }

    List<zendesk.messaging.Engine> getEngines() {
        return EngineListRegistry.INSTANCE.retrieveEngineList(this.engineRegistryKey);
    }

    @Override // o.a.a
    String getToolbarTitle(Resources resources) {
        boolean toolbarTitleRes;
        String obj2;
        if (g.c(this.toolbarTitle)) {
            obj2 = this.toolbarTitle;
        } else {
            obj2 = resources.getString(this.toolbarTitleRes);
        }
        return obj2;
    }

    @Override // o.a.a
    boolean isMultilineResponseOptionsEnabled() {
        return this.multilineResponseOptionsEnabled;
    }
}
