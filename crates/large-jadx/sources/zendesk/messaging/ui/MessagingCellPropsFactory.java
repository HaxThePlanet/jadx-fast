package zendesk.messaging.ui;

import android.content.res.Resources;
import f.g.e.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import zendesk.messaging.AgentDetails;
import zendesk.messaging.MessagingItem;
import zendesk.messaging.MessagingItem.Response;
import zendesk.messaging.R.dimen;

/* loaded from: classes3.dex */
public class MessagingCellPropsFactory {

    private final int defaultSpacing;
    private final int groupSpacing;

    private static enum InteractionType {

        QUERY,
        RESPONSE,
        NONE;
    }
    public MessagingCellPropsFactory(Resources resources) {
        super();
        this.defaultSpacing = resources.getDimensionPixelSize(R.dimen.zui_cell_vertical_spacing_default);
        this.groupSpacing = resources.getDimensionPixelSize(R.dimen.zui_cell_vertical_spacing_group);
    }

    private static zendesk.messaging.ui.MessagingCellPropsFactory.InteractionType classifyInteraction(MessagingItem messagingItem) {
        Object obj1;
        if (messagingItem instanceof MessagingItem.Response != null) {
            return MessagingCellPropsFactory.InteractionType.RESPONSE;
        }
        if (!messagingItem instanceof MessagingItem.Query && messagingItem instanceof MessagingItem.OptionsResponse != null) {
            if (messagingItem instanceof MessagingItem.OptionsResponse != null) {
            }
            return MessagingCellPropsFactory.InteractionType.NONE;
        }
        return MessagingCellPropsFactory.InteractionType.QUERY;
    }

    private zendesk.messaging.ui.MessagingCellProps generateCellProps(MessagingItem messagingItem, MessagingItem messagingItem2, MessagingItem messagingItem3) {
        MessagingCellProps messagingCellProps = new MessagingCellProps(labelVisibility(messagingItem2, messagingItem), cellSpacing(messagingItem2, messagingItem3), avatarVisibility(messagingItem2, messagingItem3));
        return messagingCellProps;
    }

    int avatarVisibility(MessagingItem messagingItem, MessagingItem messagingItem2) {
        boolean z;
        zendesk.messaging.ui.MessagingCellPropsFactory.InteractionType classifyInteraction = MessagingCellPropsFactory.classifyInteraction(messagingItem);
        final int i2 = 4;
        if (classifyInteraction == MessagingCellPropsFactory.InteractionType.QUERY) {
            return i2;
        }
        int i = 0;
        if (messagingItem2 == null) {
            return i;
        }
        if (classifyInteraction != MessagingCellPropsFactory.classifyInteraction(messagingItem2)) {
            return i;
        }
        if (messagingItem instanceof MessagingItem.Response != null && messagingItem2 instanceof MessagingItem.Response != null && (MessagingItem.Response)messagingItem.getAgentDetails().getAgentId().equals((MessagingItem.Response)messagingItem2.getAgentDetails().getAgentId())) {
            if (messagingItem2 instanceof MessagingItem.Response != null) {
                if ((MessagingItem.Response)messagingItem.getAgentDetails().getAgentId().equals((MessagingItem.Response)messagingItem2.getAgentDetails().getAgentId())) {
                    return i2;
                }
                return i;
            }
        }
        return i2;
    }

    int cellSpacing(MessagingItem messagingItem, MessagingItem messagingItem2) {
        if (messagingItem2 == null) {
            return this.defaultSpacing;
        }
        if (messagingItem2 instanceof MessagingItem.SystemMessage) {
            return this.groupSpacing;
        }
        if (MessagingCellPropsFactory.classifyInteraction(messagingItem) == MessagingCellPropsFactory.classifyInteraction(messagingItem2)) {
            return this.groupSpacing;
        }
        return this.defaultSpacing;
    }

    public List<zendesk.messaging.ui.MessagingCellProps> create(List<MessagingItem> list) {
        int i3;
        zendesk.messaging.ui.MessagingCellProps cellProps;
        int i2;
        int i;
        Object obj;
        int size;
        if (a.g(list)) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(list.size());
        i3 = 0;
        while (i3 < list.size()) {
            if (i3 > 0) {
            } else {
            }
            i = i2;
            i3++;
            if (i3 < list.size()) {
            }
            arrayList.add(generateCellProps(i, (MessagingItem)list.get(i3), i2));
            i2 = list.get(i3);
            i = list.get(i3 + -1);
        }
        return arrayList;
    }

    int labelVisibility(MessagingItem messagingItem, MessagingItem messagingItem2) {
        boolean z;
        MessagingItem obj4;
        Object obj5;
        zendesk.messaging.ui.MessagingCellPropsFactory.InteractionType classifyInteraction = MessagingCellPropsFactory.classifyInteraction(messagingItem);
        final int i2 = 0;
        if (classifyInteraction != MessagingCellPropsFactory.InteractionType.QUERY) {
            if (messagingItem2 == null) {
            } else {
                if (classifyInteraction != MessagingCellPropsFactory.classifyInteraction(messagingItem2)) {
                    return i2;
                }
                if (messagingItem instanceof MessagingItem.Response != null && messagingItem2 instanceof MessagingItem.Response != null && !(MessagingItem.Response)messagingItem.getAgentDetails().getAgentId().equals((MessagingItem.Response)messagingItem2.getAgentDetails().getAgentId())) {
                    if (messagingItem2 instanceof MessagingItem.Response != null) {
                        if (!(MessagingItem.Response)messagingItem.getAgentDetails().getAgentId().equals((MessagingItem.Response)messagingItem2.getAgentDetails().getAgentId())) {
                            return i2;
                        }
                    }
                }
            }
            return 8;
        }
        return i2;
    }
}
