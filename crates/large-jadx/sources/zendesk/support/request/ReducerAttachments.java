package zendesk.support.request;

import android.widget.FrameLayout.LayoutParams;
import f.g.c.a;
import f.g.e.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import o.b.a;
import o.b.n;
import zendesk.belvedere.s;

/* loaded from: classes3.dex */
class ReducerAttachments extends n<zendesk.support.request.StateAttachments> {

    private static final String LOG_FORMAT_ATTACHMENT_DROPPED = "Cannot add attachment %s. Size is %d, max attachment size is %d.";
    private static final String LOG_MESSAGE_ATTACHMENTS_DISABLED = "Cannot add attachments, they are disabled in your Zendesk settings.";
    @Override // o.b.n
    public Object getInitialState() {
        return getInitialState();
    }

    @Override // o.b.n
    public zendesk.support.request.StateAttachments getInitialState() {
        StateAttachments stateAttachments = new StateAttachments();
        return stateAttachments;
    }

    @Override // o.b.n
    public Object reduce(Object object, a a2) {
        return reduce((StateAttachments)object, a2);
    }

    public zendesk.support.request.StateAttachments reduce(zendesk.support.request.StateAttachments stateAttachments, a<?> a2) {
        boolean actionType;
        String convert;
        boolean attachmentsEnabled;
        int next;
        int contains;
        int i;
        Object[] cmp;
        char size;
        actionType.hashCode();
        next = 3;
        contains = 2;
        final int i3 = 1;
        final int i4 = 0;
        i = -1;
        switch (actionType) {
            case "ATTACHMENTS_SELECTED":
                i = i4;
                break;
            case "ATTACHMENTS_DESELECTED":
                i = i3;
                break;
            case "LOAD_SETTINGS_SUCCESS":
                i = contains;
                break;
            case "START_CONFIG":
                i = next;
                break;
            case "CLEAR_ATTACHMENTS":
                i = 4;
                break;
            default:
        }
        switch (i) {
            case 0:
                ArrayList arrayList = new ArrayList();
                Iterator obj14 = (List)a2.getData().iterator();
                arrayList.add(StateRequestAttachment.convert((s)obj14.next()));
                obj14 = new List[contains];
                obj14[i4] = arrayList;
                obj14[i3] = stateAttachments.getSelectedAttachments();
                return stateAttachments.newBuilder().addAllSelectedAttachments(arrayList).setSelectedAttachments(a.b(obj14)).build();
            case 1:
                HashSet hashSet = new HashSet();
                obj14 = (List)a2.getData().iterator();
                hashSet.add((s)obj14.next().k());
                obj14 = new ArrayList();
                Iterator iterator = stateAttachments.getSelectedAttachments().iterator();
                next = iterator.next();
                obj14.add(next);
                return stateAttachments.newBuilder().setSelectedAttachments(obj14).build();
            case 2:
                obj14 = a2.getData();
                ArrayList arrayList2 = new ArrayList();
                String str = "RequestActivity";
                final long maxAttachmentSize = obj14.getMaxAttachmentSize();
                obj14 = stateAttachments.getSelectedAttachments().iterator();
                attachmentsEnabled = obj14.next();
                cmp = new Object[next];
                cmp[i4] = attachmentsEnabled.getName();
                cmp[i3] = Long.valueOf(attachmentsEnabled.getSize());
                cmp[contains] = Long.valueOf(maxAttachmentSize);
                a.b(str, "Cannot add attachment %s. Size is %d, max attachment size is %d.", cmp);
                arrayList2.add(attachmentsEnabled);
                return stateAttachments.newBuilder().setSelectedAttachments(arrayList2).build();
                a.k(str, "Cannot add attachments, they are disabled in your Zendesk settings.", new Object[i4]);
                StateAttachments obj13 = new StateAttachments();
                return obj13;
            case 3:
                obj14 = (RequestConfiguration)a2.getData().getFiles();
                return stateAttachments.newBuilder().addAllSelectedAttachments(obj14).setSelectedAttachments(obj14).build();
            case 4:
                obj13 = new StateAttachments();
                return obj13;
            default:
                return null;
        }
    }
}
