package zendesk.messaging.ui;

import java.util.List;
import zendesk.messaging.MessagingItem.Option;

/* loaded from: classes3.dex */
class ResponseOptionsViewState {

    private final zendesk.messaging.ui.ResponseOptionHandler listener;
    private final List<MessagingItem.Option> options;
    private final zendesk.messaging.ui.MessagingCellProps props;
    ResponseOptionsViewState(List<MessagingItem.Option> list, zendesk.messaging.ui.ResponseOptionHandler responseOptionHandler2, zendesk.messaging.ui.MessagingCellProps messagingCellProps3) {
        super();
        this.options = list;
        this.listener = responseOptionHandler2;
        this.props = messagingCellProps3;
    }

    zendesk.messaging.ui.ResponseOptionHandler getListener() {
        return this.listener;
    }

    List<MessagingItem.Option> getOptions() {
        return this.options;
    }

    zendesk.messaging.ui.MessagingCellProps getProps() {
        return this.props;
    }
}
