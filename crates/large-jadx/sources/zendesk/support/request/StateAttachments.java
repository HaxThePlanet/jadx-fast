package zendesk.support.request;

import f.g.e.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import o.b.o;

/* loaded from: classes3.dex */
class StateAttachments implements Serializable {

    private final Set<zendesk.support.request.StateRequestAttachment> allSelectedAttachments;
    private final List<zendesk.support.request.StateRequestAttachment> selectedAttachments;

    public static class Builder {

        private Set<zendesk.support.request.StateRequestAttachment> attachmentNotSelectedButVisible;
        private List<zendesk.support.request.StateRequestAttachment> selectedAttachments;
        private Builder(zendesk.support.request.StateAttachments stateAttachments) {
            super();
            this.selectedAttachments = a.c(stateAttachments.getSelectedAttachments());
            StateAttachments.UriComparator uriComparator = new StateAttachments.UriComparator();
            TreeSet treeSet = new TreeSet(uriComparator);
            this.attachmentNotSelectedButVisible = treeSet;
            treeSet.addAll(stateAttachments.getAllSelectedAttachments());
        }

        Builder(zendesk.support.request.StateAttachments stateAttachments, zendesk.support.request.StateAttachments.1 stateAttachments$12) {
            super(stateAttachments);
        }

        zendesk.support.request.StateAttachments.Builder addAllSelectedAttachments(List<zendesk.support.request.StateRequestAttachment> list) {
            Collections.reverse(list);
            this.attachmentNotSelectedButVisible.addAll(list);
            return this;
        }

        zendesk.support.request.StateAttachments build() {
            StateAttachments stateAttachments = new StateAttachments(this.selectedAttachments, this.attachmentNotSelectedButVisible);
            return stateAttachments;
        }

        zendesk.support.request.StateAttachments.Builder setSelectedAttachments(List<zendesk.support.request.StateRequestAttachment> list) {
            this.selectedAttachments = a.c(list);
            return this;
        }
    }

    static class UriComparator implements Comparator<zendesk.support.request.StateRequestAttachment>, Serializable {
        @Override // java.util.Comparator
        public int compare(Object object, Object object2) {
            return compare((StateRequestAttachment)object, (StateRequestAttachment)object2);
        }

        @Override // java.util.Comparator
        public int compare(zendesk.support.request.StateRequestAttachment stateRequestAttachment, zendesk.support.request.StateRequestAttachment stateRequestAttachment2) {
            return stateRequestAttachment.getLocalUri().compareTo(stateRequestAttachment2.getLocalUri());
        }
    }
    StateAttachments() {
        super();
        ArrayList arrayList = new ArrayList();
        this.selectedAttachments = arrayList;
        StateAttachments.UriComparator uriComparator = new StateAttachments.UriComparator();
        TreeSet treeSet = new TreeSet(uriComparator);
        this.allSelectedAttachments = treeSet;
    }

    StateAttachments(List<zendesk.support.request.StateRequestAttachment> list, Set<zendesk.support.request.StateRequestAttachment> set2) {
        super();
        this.selectedAttachments = list;
        this.allSelectedAttachments = set2;
    }

    static zendesk.support.request.StateAttachments fromState(o o) {
        Object obj1 = o.c(StateAttachments.class.getSimpleName());
        if (obj1 instanceof StateAttachments) {
            return (StateAttachments)obj1;
        }
        obj1 = new StateAttachments();
        return obj1;
    }

    Set<zendesk.support.request.StateRequestAttachment> getAllSelectedAttachments() {
        return this.allSelectedAttachments;
    }

    List<zendesk.support.request.StateRequestAttachment> getSelectedAttachments() {
        return this.selectedAttachments;
    }

    @Override // java.io.Serializable
    zendesk.support.request.StateAttachments.Builder newBuilder() {
        StateAttachments.Builder builder = new StateAttachments.Builder(this, 0);
        return builder;
    }

    @Override // java.io.Serializable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Attachments{selectedAttachments=");
        stringBuilder.append(this.selectedAttachments);
        stringBuilder.append(", allSelectedAttachments=");
        stringBuilder.append(this.allSelectedAttachments);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
