package zendesk.core;

import f.g.e.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class User {

    private final boolean agent = false;
    private final Long id;
    private final String name;
    private final zendesk.core.Attachment photo = null;
    private final List<String> tags;
    private final Map<String, String> userFields;
    public User() {
        super();
        this.id = Long.valueOf(-1);
        this.name = "";
        int i2 = 0;
        int i3 = 0;
        ArrayList arrayList = new ArrayList();
        this.tags = arrayList;
        HashMap hashMap = new HashMap();
        this.userFields = hashMap;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getPhoto() {
        zendesk.core.Attachment photo = this.photo;
        if (photo == null) {
            return null;
        }
        return photo.getContentUrl();
    }

    public List<String> getTags() {
        return a.c(this.tags);
    }

    public Map<String, String> getUserFields() {
        return a.d(this.userFields);
    }

    public boolean isAgent() {
        return this.agent;
    }
}
