package zendesk.support;

import f.g.e.a;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
final class RequestDataList {

    final List<zendesk.support.RequestData> requestDataList;
    RequestDataList(List<zendesk.support.RequestData> list) {
        super();
        ArrayList arrayList = new ArrayList(0);
        this.requestDataList = arrayList;
        if (a.i(list)) {
            arrayList.addAll(list);
        }
    }

    public boolean equals(Object object) {
        Class<zendesk.support.RequestDataList> obj;
        Class class;
        if (this == object) {
            return 1;
        }
        if (object != null && RequestDataList.class != object.getClass()) {
            if (RequestDataList.class != object.getClass()) {
            }
            return this.requestDataList.equals(object.requestDataList);
        }
        return 0;
    }

    public int hashCode() {
        return this.requestDataList.hashCode();
    }
}
