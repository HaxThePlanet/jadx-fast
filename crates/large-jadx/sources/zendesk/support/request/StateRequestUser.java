package zendesk.support.request;

import f.g.e.g;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import zendesk.support.Attachment;
import zendesk.support.User;

/* loaded from: classes3.dex */
class StateRequestUser implements Serializable {

    private final String avatar;
    private final long id;
    private final boolean isAgent;
    private final String name;
    StateRequestUser(String string, String string2, boolean z3, long l4) {
        super();
        this.name = string;
        this.avatar = string2;
        this.isAgent = z3;
        this.id = l4;
    }

    static boolean containsAgent(List<zendesk.support.request.StateRequestUser> list) {
        boolean agent;
        Iterator obj1 = list.iterator();
        for (StateRequestUser next2 : obj1) {
        }
        return 0;
    }

    static List<zendesk.support.request.StateRequestUser> convert(List<User> list) {
        int size;
        Object stateRequestUser;
        String contentUrl;
        zendesk.support.request.StateRequestUser request;
        String name;
        String str;
        boolean agent;
        long longValue;
        ArrayList arrayList = new ArrayList(list.size());
        final Iterator obj9 = list.iterator();
        while (obj9.hasNext()) {
            size = obj9.next();
            if ((User)size.getId() != null) {
            }
            Attachment photo = size.getPhoto();
            if (photo != null && g.c(photo.getContentUrl())) {
            } else {
            }
            contentUrl = "";
            super(size.getName(), contentUrl, size.isAgent(), size.getId().longValue(), obj8);
            arrayList.add(stateRequestUser);
            if (g.c(photo.getContentUrl())) {
            } else {
            }
            contentUrl = photo.getContentUrl();
        }
        return arrayList;
    }

    @Override // java.io.Serializable
    String getAvatar() {
        return this.avatar;
    }

    @Override // java.io.Serializable
    long getId() {
        return this.id;
    }

    @Override // java.io.Serializable
    String getName() {
        return this.name;
    }

    @Override // java.io.Serializable
    boolean isAgent() {
        return this.isAgent;
    }
}
