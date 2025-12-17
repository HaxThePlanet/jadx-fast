package zendesk.support;

import f.g.e.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class User implements Serializable {

    private boolean agent;
    private Long id;
    private String name;
    private Long organizationId;
    private zendesk.support.Attachment photo;
    private List<String> tags;
    private Map<String, String> userFields;
    public User() {
        super();
        Long valueOf = Long.valueOf(-1);
        this.id = valueOf;
        this.name = "";
        this.photo = 0;
        this.agent = false;
        this.organizationId = valueOf;
        ArrayList arrayList = new ArrayList();
        this.tags = arrayList;
        HashMap hashMap = new HashMap();
        this.userFields = hashMap;
    }

    public User(Long long, String string2, zendesk.support.Attachment attachment3, boolean z4, Long long5, List<String> list6, Map<String, String> map7) {
        super();
        this.id = long;
        this.name = string2;
        this.photo = attachment3;
        this.agent = z4;
        this.organizationId = long5;
        this.tags = list6;
        this.userFields = map7;
    }

    @Override // java.io.Serializable
    public boolean equals(Object object) {
        boolean equals4;
        boolean equals2;
        zendesk.support.Attachment equals3;
        boolean organizationId;
        List equals;
        Class class2;
        Long organizationId2;
        Class class;
        if (this == object) {
            return 1;
        }
        final int i = 0;
        if (object != null) {
            if (getClass() != object.getClass()) {
            } else {
                if (this.agent != object.agent) {
                    return i;
                }
                Long num = this.id;
                if (num != null) {
                    if (!num.equals(object.id)) {
                        return i;
                    }
                } else {
                    if (object.id != null) {
                    }
                }
                zendesk.support.Attachment photo = this.photo;
                if (photo != null) {
                    if (!photo.equals(object.photo)) {
                        return i;
                    }
                } else {
                    if (object.photo != null) {
                    }
                }
                Long organizationId3 = this.organizationId;
                if (organizationId3 != null) {
                    if (!organizationId3.equals(object.organizationId)) {
                        return i;
                    }
                } else {
                    if (object.organizationId != null) {
                    }
                }
                List tags = this.tags;
                if (tags != null) {
                    if (!tags.equals(object.tags)) {
                        return i;
                    }
                } else {
                    if (object.tags != null) {
                    }
                }
                Map userFields = this.userFields;
                final Map obj5 = object.userFields;
                if (userFields != null) {
                    equals4 = userFields.equals(obj5);
                } else {
                    if (obj5 == null) {
                    } else {
                        equals4 = i;
                    }
                }
            }
            return equals4;
        }
        return i;
    }

    @Override // java.io.Serializable
    public Long getId() {
        return this.id;
    }

    @Override // java.io.Serializable
    public String getName() {
        return this.name;
    }

    @Override // java.io.Serializable
    public Long getOrganizationId() {
        return this.organizationId;
    }

    @Override // java.io.Serializable
    public zendesk.support.Attachment getPhoto() {
        return this.photo;
    }

    public List<String> getTags() {
        return a.c(this.tags);
    }

    public Map<String, String> getUserFields() {
        return a.d(this.userFields);
    }

    @Override // java.io.Serializable
    public int hashCode() {
        int i;
        int i5;
        int i2;
        int i3;
        int i4;
        Long num = this.id;
        i5 = 0;
        if (num != null) {
            i = num.hashCode();
        } else {
            i = i5;
        }
        zendesk.support.Attachment photo = this.photo;
        if (photo != null) {
            i2 = photo.hashCode();
        } else {
            i2 = i5;
        }
        Long organizationId = this.organizationId;
        if (organizationId != null) {
            i3 = organizationId.hashCode();
        } else {
            i3 = i5;
        }
        List tags = this.tags;
        if (tags != null) {
            i4 = tags.hashCode();
        } else {
            i4 = i5;
        }
        Map userFields = this.userFields;
        if (userFields != null) {
            i5 = userFields.hashCode();
        }
        return i14 += i5;
    }

    @Override // java.io.Serializable
    public boolean isAgent() {
        return this.agent;
    }
}
