package zendesk.support.request;

import f.g.e.g;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import zendesk.support.CustomField;

/* loaded from: classes3.dex */
class StateRequestTicketForm implements Serializable {

    static final long NO_ID = -1L;
    private final long id;
    private final Map<Long, String> ticketFields;
    public StateRequestTicketForm(long l, List<CustomField> list2) {
        super();
        this.id = l;
        this.ticketFields = StateRequestTicketForm.fieldsToMap(obj3);
    }

    StateRequestTicketForm(List<CustomField> list) {
        super(-1, obj1, list);
    }

    private static Map<Long, String> fieldsToMap(List<CustomField> list) {
        int valueString;
        boolean z;
        HashMap hashMap = new HashMap(list.size());
        final Iterator obj3 = list.iterator();
        while (obj3.hasNext()) {
            valueString = obj3.next();
            if (valueString != null && g.c((CustomField)valueString.getValueString())) {
            }
            if (g.c(valueString.getValueString())) {
            }
            hashMap.put(valueString.getId(), valueString.getValueString());
        }
        return hashMap;
    }

    private static List<CustomField> mapToFields(Map<Long, String> map) {
        int value;
        CustomField customField;
        Object key;
        ArrayList arrayList = new ArrayList(map.size());
        Iterator obj4 = map.entrySet().iterator();
        for (Map.Entry next2 : obj4) {
            customField = new CustomField((Long)next2.getKey(), next2.getValue());
            arrayList.add(customField);
        }
        return arrayList;
    }

    @Override // java.io.Serializable
    long getId() {
        return this.id;
    }

    Map<Long, String> getTicketFields() {
        return this.ticketFields;
    }

    List<CustomField> getTicketFieldsForApi() {
        return StateRequestTicketForm.mapToFields(this.ticketFields);
    }
}
