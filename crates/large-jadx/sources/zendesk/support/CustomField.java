package zendesk.support;

import f.g.c.a;
import f.g.e.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class CustomField implements Serializable {

    private static final String LOG_TAG = "CustomField";
    private Long id;
    private Object value;
    public CustomField(Long long, Object object2) {
        super();
        this.id = long;
        this.value = object2;
    }

    @Override // java.io.Serializable
    public Long getId() {
        return this.id;
    }

    @Deprecated
    public String getValue() {
        Object value = this.value;
        if (value instanceof String != null) {
            return (String)value;
        }
        if (value instanceof Boolean) {
            return String.valueOf(value);
        }
        a.k("CustomField", "Custom Field Value is of a type other than String or Boolean. Is this a multi-select field?", new Object[0]);
        return null;
    }

    @Override // java.io.Serializable
    public Boolean getValueBoolean() {
        Object value = this.value;
        final int i2 = 0;
        if (value == null) {
            return i2;
        }
        if (value instanceof Boolean) {
            return (Boolean)value;
        }
        a.k("CustomField", "Custom field value is not a boolean", new Object[0]);
        return i2;
    }

    public List<String> getValueList() {
        int valueOf;
        boolean z;
        Object value = this.value;
        int i2 = 0;
        if (value == null) {
            return i2;
        }
        if (value instanceof List != null && a.i((List)value)) {
            if (a.i((List)value)) {
                ArrayList arrayList = new ArrayList(value.size());
                Iterator iterator = value.iterator();
                for (Object next2 : iterator) {
                    arrayList.add(String.valueOf(next2));
                }
                return arrayList;
            }
        }
        a.k("CustomField", "Custom field value is not a list.", new Object[0]);
        return i2;
    }

    @Override // java.io.Serializable
    public Object getValueObject() {
        return this.value;
    }

    @Override // java.io.Serializable
    public String getValueString() {
        Object value = this.value;
        final int i2 = 0;
        if (value == null) {
            return i2;
        }
        if (value instanceof String != null) {
            return (String)value;
        }
        a.k("CustomField", "Custom field value is not a string", new Object[0]);
        return i2;
    }
}
