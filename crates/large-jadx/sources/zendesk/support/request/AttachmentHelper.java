package zendesk.support.request;

import android.content.res.Resources;
import androidx.appcompat.app.d;
import f.g.d.b;
import f.g.e.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import zendesk.belvedere.b;
import zendesk.belvedere.b.b;
import zendesk.belvedere.s;

/* loaded from: classes3.dex */
class AttachmentHelper {

    private List<zendesk.support.request.StateRequestAttachment> additionalAttachments;
    private long maxFileSize = -1;
    private List<zendesk.support.request.StateRequestAttachment> selectedAttachments;
    private final int[] touchableItems;
    AttachmentHelper(int... iArr) {
        super();
        final int i = -1;
        this.touchableItems = iArr;
        ArrayList obj3 = new ArrayList();
        this.selectedAttachments = obj3;
        obj3 = new ArrayList();
        this.additionalAttachments = obj3;
    }

    private List<s> requestAttachmentsToMediaResult(List<zendesk.support.request.StateRequestAttachment> list) {
        int convert;
        ArrayList arrayList = new ArrayList(list.size());
        final Iterator obj3 = list.iterator();
        for (StateRequestAttachment next2 : obj3) {
            arrayList.add(StateRequestAttachment.convert(next2));
        }
        return arrayList;
    }

    List<zendesk.support.request.StateRequestAttachment> getSelectedAttachments() {
        return a.c(this.selectedAttachments);
    }

    void showImagePicker(d d) {
        int length;
        final b.b bVar = b.a(d);
        bVar.h();
        bVar.i("*/*", true);
        bVar.m(requestAttachmentsToMediaResult(this.selectedAttachments));
        bVar.k(d.getResources().getBoolean(b.a));
        bVar.j(requestAttachmentsToMediaResult(this.additionalAttachments));
        int[] touchableItems = this.touchableItems;
        if (touchableItems != null && touchableItems.length > 0) {
            if (touchableItems.length > 0) {
                bVar.n(touchableItems);
            }
        }
        long maxFileSize = this.maxFileSize;
        if (Long.compare(maxFileSize, i2) > 0) {
            bVar.l(maxFileSize);
        }
        bVar.g(d);
    }

    void updateAttachments(Collection<zendesk.support.request.StateRequestAttachment> collection, Collection<zendesk.support.request.StateRequestAttachment> collection2) {
        ArrayList arrayList = new ArrayList(collection);
        this.selectedAttachments = a.c(arrayList);
        ArrayList obj2 = new ArrayList(collection2);
        this.additionalAttachments = a.c(obj2);
    }

    void updateMaxFileSize(long l) {
        this.maxFileSize = l;
    }
}
