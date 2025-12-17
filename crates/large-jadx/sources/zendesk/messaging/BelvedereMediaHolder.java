package zendesk.messaging;

import java.util.ArrayList;
import java.util.List;
import zendesk.belvedere.s;

/* loaded from: classes3.dex */
public class BelvedereMediaHolder {

    private List<s> selectedMedia;
    public BelvedereMediaHolder() {
        super();
        ArrayList arrayList = new ArrayList();
        this.selectedMedia = arrayList;
    }

    public void addAll(List<s> list) {
        ArrayList arrayList = new ArrayList(list);
        this.selectedMedia.addAll(0, arrayList);
    }

    public void clear() {
        this.selectedMedia.clear();
    }

    public List<s> getSelectedMedia() {
        ArrayList arrayList = new ArrayList(this.selectedMedia);
        return arrayList;
    }

    public int getSelectedMediaCount() {
        return this.selectedMedia.size();
    }

    public void removeAll(List<s> list) {
        ArrayList arrayList = new ArrayList(list);
        this.selectedMedia.removeAll(arrayList);
    }
}
