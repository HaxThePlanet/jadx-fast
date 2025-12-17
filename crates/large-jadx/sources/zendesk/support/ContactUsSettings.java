package zendesk.support;

import f.g.e.a;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
class ContactUsSettings {

    private static zendesk.support.ContactUsSettings DEFAULT;
    private List<String> tags;
    static {
        ContactUsSettings contactUsSettings = new ContactUsSettings(Collections.emptyList());
        ContactUsSettings.DEFAULT = contactUsSettings;
    }

    ContactUsSettings(List<String> list) {
        super();
        this.tags = list;
    }

    static zendesk.support.ContactUsSettings defaultSettings() {
        return ContactUsSettings.DEFAULT;
    }

    public List<String> getTags() {
        return a.c(this.tags);
    }
}
