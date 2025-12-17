package zendesk.core;

import java.util.Map;

/* loaded from: classes3.dex */
public class UserAction {

    private String action;
    private String category;
    private String channel;
    private String label;
    private Map<String, Object> value;
    private String version;
    public UserAction(String string, String string2, String string3, String string4) {
        super();
        this.version = string;
        this.channel = string2;
        this.category = string3;
        this.action = string4;
    }

    public UserAction(String string, String string2, String string3, String string4, String string5, Map<String, Object> map6) {
        super();
        this.version = string;
        this.channel = string2;
        this.category = string3;
        this.action = string4;
        this.label = string5;
        this.value = map6;
    }

    public String getAction() {
        return this.action;
    }

    public String getCategory() {
        return this.category;
    }

    public String getChannel() {
        return this.channel;
    }

    public String getLabel() {
        return this.label;
    }

    public Map<String, Object> getValue() {
        return this.value;
    }

    public String getVersion() {
        return this.version;
    }
}
