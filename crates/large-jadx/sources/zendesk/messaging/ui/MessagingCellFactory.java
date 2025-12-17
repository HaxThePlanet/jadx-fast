package zendesk.messaging.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.squareup.picasso.t;
import f.g.e.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import zendesk.messaging.AgentDetails;
import zendesk.messaging.AttachmentSettings;
import zendesk.messaging.Engine.TransferOptionDescription;
import zendesk.messaging.EventFactory;
import zendesk.messaging.EventListener;
import zendesk.messaging.MessagingItem;
import zendesk.messaging.MessagingItem.Action;
import zendesk.messaging.MessagingItem.ActionResponse;
import zendesk.messaging.MessagingItem.ArticlesResponse;
import zendesk.messaging.MessagingItem.ArticlesResponse.ArticleSuggestion;
import zendesk.messaging.MessagingItem.FileQuery;
import zendesk.messaging.MessagingItem.FileResponse;
import zendesk.messaging.MessagingItem.ImageQuery;
import zendesk.messaging.MessagingItem.ImageResponse;
import zendesk.messaging.MessagingItem.Option;
import zendesk.messaging.MessagingItem.OptionsResponse;
import zendesk.messaging.MessagingItem.Query;
import zendesk.messaging.MessagingItem.Response;
import zendesk.messaging.MessagingItem.SystemMessage;
import zendesk.messaging.MessagingItem.TextQuery;
import zendesk.messaging.MessagingItem.TextResponse;
import zendesk.messaging.MessagingItem.TransferResponse;
import zendesk.messaging.R.layout;
import zendesk.messaging.components.DateProvider;

/* loaded from: classes3.dex */
public class MessagingCellFactory {

    private static final AgentDetails DEFAULT_TYPING_INDICATOR_LABEL_STATE;
    static final String TYPING_INDICATOR_ID;
    private final zendesk.messaging.ui.AvatarStateFactory avatarStateFactory;
    private final zendesk.messaging.ui.AvatarStateRenderer avatarStateRenderer;
    private final zendesk.messaging.ui.MessagingCellPropsFactory cellPropsFactory;
    private final DateProvider dateProvider;
    private final EventFactory eventFactory;
    private final EventListener eventListener;
    private final boolean multilineResponseOptionsEnabled;

    static class MessageActionAdapter implements zendesk.messaging.ui.MessageActionListener {

        private final EventFactory eventFactory;
        private final EventListener eventListener;
        private final MessagingItem.Query messagingItem;
        MessageActionAdapter(EventListener eventListener, MessagingItem.Query messagingItem$Query2, EventFactory eventFactory3) {
            super();
            this.eventListener = eventListener;
            this.messagingItem = query2;
            this.eventFactory = eventFactory3;
        }

        @Override // zendesk.messaging.ui.MessageActionListener
        public void copy(String string) {
            this.eventListener.onEvent(this.eventFactory.copyQueryClick(this.messagingItem));
        }

        @Override // zendesk.messaging.ui.MessageActionListener
        public void delete(String string) {
            this.eventListener.onEvent(this.eventFactory.deleteQueryClick(this.messagingItem));
        }

        @Override // zendesk.messaging.ui.MessageActionListener
        public void retry(String string) {
            EventListener eventListener;
            EventFactory eventFactory;
            zendesk.messaging.Event obj3;
            obj3 = this.messagingItem;
            if (obj3 instanceof MessagingItem.FileQuery != null) {
                this.eventListener.onEvent(this.eventFactory.retrySendAttachmentClick((MessagingItem.FileQuery)obj3));
            } else {
                this.eventListener.onEvent(this.eventFactory.retryQueryClick(obj3));
            }
        }
    }

    private static class TypingItem extends MessagingItem.Response {
        private TypingItem(Date date, String string2, AgentDetails agentDetails3) {
            super(date, string2, agentDetails3);
        }

        TypingItem(Date date, String string2, AgentDetails agentDetails3, zendesk.messaging.ui.MessagingCellFactory.1 messagingCellFactory$14) {
            super(date, string2, agentDetails3);
        }
    }
    static {
        MessagingCellFactory.TYPING_INDICATOR_ID = UUID.randomUUID().toString();
        final String str = "";
        AgentDetails agentDetails = new AgentDetails(str, str, 0);
        MessagingCellFactory.DEFAULT_TYPING_INDICATOR_LABEL_STATE = agentDetails;
    }

    MessagingCellFactory(zendesk.messaging.ui.MessagingCellPropsFactory messagingCellPropsFactory, DateProvider dateProvider2, EventListener eventListener3, EventFactory eventFactory4, zendesk.messaging.ui.AvatarStateRenderer avatarStateRenderer5, zendesk.messaging.ui.AvatarStateFactory avatarStateFactory6, boolean z7) {
        super();
        this.cellPropsFactory = messagingCellPropsFactory;
        this.dateProvider = dateProvider2;
        this.eventListener = eventListener3;
        this.eventFactory = eventFactory4;
        this.avatarStateRenderer = avatarStateRenderer5;
        this.avatarStateFactory = avatarStateFactory6;
        this.multilineResponseOptionsEnabled = z7;
    }

    private static zendesk.messaging.ui.MessagingCell<zendesk.messaging.ui.ActionOptionsView.State, zendesk.messaging.ui.ActionOptionsView> createActionOptionsCell(MessagingItem.ActionResponse messagingItem$ActionResponse, zendesk.messaging.ui.MessagingCellProps messagingCellProps2, EventListener eventListener3, EventFactory eventFactory4, zendesk.messaging.ui.AvatarStateFactory avatarStateFactory5, zendesk.messaging.ui.AvatarStateRenderer avatarStateRenderer6) {
        Object next;
        zendesk.messaging.ui.ActionOptionsView.ActionOptionState actionOptionState;
        String displayName;
        zendesk.messaging.ui.MessagingCellFactory.3 anon;
        ArrayList arrayList = new ArrayList();
        Iterator iterator = actionResponse.getActions().iterator();
        for (MessagingItem.Action next : iterator) {
            anon = new MessagingCellFactory.3(eventListener3, eventFactory4, next);
            actionOptionState = new ActionOptionsView.ActionOptionState(next.getDisplayName(), anon);
            arrayList.add(actionOptionState);
        }
        super(actionResponse.getMessage(), actionResponse.getAgentDetails().getAgentName(), actionResponse.getAgentDetails().isBot(), messagingCellProps2, arrayList, 1, avatarStateFactory5.createAvatarState(actionResponse.getAgentDetails()), avatarStateRenderer6);
        MessagingCell obj10 = new MessagingCell(actionResponse.getId(), obj11, R.layout.zui_cell_action_options, ActionOptionsView.class);
        return obj10;
    }

    private static zendesk.messaging.ui.MessagingCell<zendesk.messaging.ui.ActionOptionsView.State, zendesk.messaging.ui.ActionOptionsView> createActionOptionsCell(MessagingItem.TransferResponse messagingItem$TransferResponse, zendesk.messaging.ui.MessagingCellProps messagingCellProps2, EventListener eventListener3, EventFactory eventFactory4, zendesk.messaging.ui.AvatarStateFactory avatarStateFactory5, zendesk.messaging.ui.AvatarStateRenderer avatarStateRenderer6) {
        Object next;
        zendesk.messaging.ui.ActionOptionsView.ActionOptionState actionOptionState;
        String displayName;
        zendesk.messaging.ui.MessagingCellFactory.2 anon;
        ArrayList arrayList = new ArrayList();
        Iterator iterator = transferResponse.getEngineOptions().iterator();
        for (Engine.TransferOptionDescription next : iterator) {
            anon = new MessagingCellFactory.2(eventListener3, eventFactory4, next);
            actionOptionState = new ActionOptionsView.ActionOptionState(next.getDisplayName(), anon);
            arrayList.add(actionOptionState);
        }
        super(transferResponse.getMessage(), transferResponse.getAgentDetails().getAgentName(), transferResponse.getAgentDetails().isBot(), messagingCellProps2, arrayList, transferResponse.isEnabled(), avatarStateFactory5.createAvatarState(transferResponse.getAgentDetails()), avatarStateRenderer6);
        MessagingCell obj10 = new MessagingCell(transferResponse.getId(), obj11, R.layout.zui_cell_action_options, ActionOptionsView.class);
        return obj10;
    }

    private static zendesk.messaging.ui.MessagingCell<zendesk.messaging.ui.AgentFileCellView.State, zendesk.messaging.ui.AgentFileCellView> createAgentFileCell(MessagingItem.FileResponse messagingItem$FileResponse, zendesk.messaging.ui.MessagingCellProps messagingCellProps2, zendesk.messaging.ui.AvatarStateFactory avatarStateFactory3, zendesk.messaging.ui.AvatarStateRenderer avatarStateRenderer4) {
        super(fileResponse.getAttachment(), messagingCellProps2, fileResponse.getAgentDetails().getAgentName(), fileResponse.getAgentDetails().isBot(), avatarStateFactory3.createAvatarState(fileResponse.getAgentDetails()), avatarStateRenderer4);
        MessagingCell obj9 = new MessagingCell(fileResponse.getId(), state, R.layout.zui_cell_agent_file_view, AgentFileCellView.class);
        return obj9;
    }

    private static zendesk.messaging.ui.MessagingCell<zendesk.messaging.ui.AgentImageCellView.State, zendesk.messaging.ui.AgentImageCellView> createAgentImageCell(MessagingItem.ImageResponse messagingItem$ImageResponse, zendesk.messaging.ui.MessagingCellProps messagingCellProps2, t t3, zendesk.messaging.ui.AvatarStateFactory avatarStateFactory4, zendesk.messaging.ui.AvatarStateRenderer avatarStateRenderer5) {
        super(t3, messagingCellProps2, imageResponse.getAttachment(), imageResponse.getAgentDetails().getAgentName(), imageResponse.getAgentDetails().isBot(), avatarStateFactory4.createAvatarState(imageResponse.getAgentDetails()), avatarStateRenderer5);
        MessagingCell obj10 = new MessagingCell(imageResponse.getId(), state, R.layout.zui_cell_agent_image_view, AgentImageCellView.class);
        return obj10;
    }

    private static zendesk.messaging.ui.ArticlesResponseView.ArticleSuggestionViewState createArticleSuggestionViewState(MessagingItem.ArticlesResponse.ArticleSuggestion messagingItem$ArticlesResponse$ArticleSuggestion, EventListener eventListener2, EventFactory eventFactory3) {
        MessagingCellFactory.1 anon = new MessagingCellFactory.1(eventListener2, eventFactory3, articleSuggestion);
        ArticlesResponseView.ArticleSuggestionViewState articleSuggestionViewState = new ArticlesResponseView.ArticleSuggestionViewState(articleSuggestion.getTitle(), articleSuggestion.getSnippet(), anon);
        return articleSuggestionViewState;
    }

    private static List<zendesk.messaging.ui.ArticlesResponseView.ArticleSuggestionViewState> createArticleSuggestionViewStates(List<MessagingItem.ArticlesResponse.ArticleSuggestion> list, EventListener eventListener2, EventFactory eventFactory3) {
        int articleSuggestionViewState;
        ArrayList arrayList = new ArrayList(list.size());
        final Iterator obj2 = list.iterator();
        for (MessagingItem.ArticlesResponse.ArticleSuggestion next2 : obj2) {
            arrayList.add(MessagingCellFactory.createArticleSuggestionViewState(next2, eventListener2, eventFactory3));
        }
        return arrayList;
    }

    private static zendesk.messaging.ui.MessagingCell<zendesk.messaging.ui.ArticlesResponseView.State, zendesk.messaging.ui.ArticlesResponseView> createArticlesResponseCell(MessagingItem.ArticlesResponse messagingItem$ArticlesResponse, zendesk.messaging.ui.MessagingCellProps messagingCellProps2, EventListener eventListener3, EventFactory eventFactory4, zendesk.messaging.ui.AvatarStateFactory avatarStateFactory5, zendesk.messaging.ui.AvatarStateRenderer avatarStateRenderer6) {
        super(articlesResponse.getAgentDetails().getAgentName(), articlesResponse.getAgentDetails().isBot(), messagingCellProps2, MessagingCellFactory.createArticleSuggestionViewStates(articlesResponse.getArticleSuggestions(), eventListener3, eventFactory4), avatarStateFactory5.createAvatarState(articlesResponse.getAgentDetails()), avatarStateRenderer6);
        MessagingCell obj9 = new MessagingCell(articlesResponse.getId(), state, R.layout.zui_cell_articles_response, ArticlesResponseView.class);
        return obj9;
    }

    private static zendesk.messaging.ui.MessagingCell createCell(MessagingItem messagingItem, zendesk.messaging.ui.MessagingCellProps messagingCellProps2, t t3, AttachmentSettings attachmentSettings4, zendesk.messaging.ui.AvatarStateRenderer avatarStateRenderer5, zendesk.messaging.ui.AvatarStateFactory avatarStateFactory6, EventListener eventListener7, EventFactory eventFactory8, boolean z9) {
        if (messagingItem instanceof MessagingItem.Query) {
            return MessagingCellFactory.createQueryCell(messagingItem, messagingCellProps2, t3, attachmentSettings4, eventListener7, eventFactory8);
        }
        if (messagingItem instanceof MessagingItem.Response != null) {
            return MessagingCellFactory.createResponseCell((MessagingItem.Response)messagingItem, messagingCellProps2, t3, eventListener7, eventFactory8, avatarStateRenderer5, avatarStateFactory6);
        }
        if (messagingItem instanceof MessagingItem.OptionsResponse != null) {
            return MessagingCellFactory.createResponseOptionsCell((MessagingItem.OptionsResponse)messagingItem, messagingCellProps2, eventListener7, eventFactory8, z9);
        }
        if (messagingItem instanceof MessagingItem.SystemMessage) {
            return MessagingCellFactory.createSystemMessageCell((MessagingItem.SystemMessage)messagingItem, messagingCellProps2);
        }
        return null;
    }

    private static zendesk.messaging.ui.MessagingCell<zendesk.messaging.ui.EndUserCellFileState, zendesk.messaging.ui.EndUserFileCellView> createFileQueryCell(MessagingItem.FileQuery messagingItem$FileQuery, zendesk.messaging.ui.MessagingCellProps messagingCellProps2, AttachmentSettings attachmentSettings3, EventListener eventListener4, EventFactory eventFactory5) {
        MessagingCellFactory.MessageActionAdapter messageActionAdapter = new MessagingCellFactory.MessageActionAdapter(eventListener4, fileQuery, eventFactory5);
        super(fileQuery.getId(), messagingCellProps2, fileQuery.getStatus(), messageActionAdapter, fileQuery.getAttachment(), fileQuery.getFailureReason(), attachmentSettings3);
        MessagingCell obj10 = new MessagingCell(fileQuery.getId(), endUserCellFileState2, R.layout.zui_cell_end_user_file_view, EndUserFileCellView.class);
        return obj10;
    }

    private static zendesk.messaging.ui.MessagingCell<zendesk.messaging.ui.EndUserCellImageState, zendesk.messaging.ui.EndUserImageCellView> createImageQueryCell(MessagingItem.ImageQuery messagingItem$ImageQuery, zendesk.messaging.ui.MessagingCellProps messagingCellProps2, t t3, AttachmentSettings attachmentSettings4, EventListener eventListener5, EventFactory eventFactory6) {
        MessagingCellFactory.MessageActionAdapter messageActionAdapter = new MessagingCellFactory.MessageActionAdapter(eventListener5, imageQuery, eventFactory6);
        super(imageQuery.getId(), messagingCellProps2, imageQuery.getStatus(), messageActionAdapter, imageQuery.getAttachment(), imageQuery.getFailureReason(), attachmentSettings4, t3);
        MessagingCell obj11 = new MessagingCell(imageQuery.getId(), endUserCellImageState2, R.layout.zui_cell_end_user_image_view, EndUserImageCellView.class);
        return obj11;
    }

    private static zendesk.messaging.ui.MessagingCell<zendesk.messaging.ui.EndUserCellImageState, zendesk.messaging.ui.EndUserImageCellView> createImageQueryCellForFile(MessagingItem.ImageQuery messagingItem$ImageQuery, zendesk.messaging.ui.MessagingCellProps messagingCellProps2, t t3, AttachmentSettings attachmentSettings4, EventListener eventListener5, EventFactory eventFactory6) {
        return MessagingCellFactory.createImageQueryCell(imageQuery, messagingCellProps2, t3, attachmentSettings4, eventListener5, eventFactory6);
    }

    private static zendesk.messaging.ui.MessagingCell createQueryCell(MessagingItem messagingItem, zendesk.messaging.ui.MessagingCellProps messagingCellProps2, t t3, AttachmentSettings attachmentSettings4, EventListener eventListener5, EventFactory eventFactory6) {
        if (messagingItem instanceof MessagingItem.TextQuery) {
            return MessagingCellFactory.createTextQueryCell((MessagingItem.TextQuery)messagingItem, messagingCellProps2, eventListener5, eventFactory6);
        }
        if (messagingItem instanceof MessagingItem.ImageQuery) {
            return MessagingCellFactory.createImageQueryCellForFile((MessagingItem.ImageQuery)messagingItem, messagingCellProps2, t3, attachmentSettings4, eventListener5, eventFactory6);
        }
        if (messagingItem instanceof MessagingItem.FileQuery != null) {
            return MessagingCellFactory.createFileQueryCell((MessagingItem.FileQuery)messagingItem, messagingCellProps2, attachmentSettings4, eventListener5, eventFactory6);
        }
        return null;
    }

    private static zendesk.messaging.ui.MessagingCell createResponseCell(MessagingItem.Response messagingItem$Response, zendesk.messaging.ui.MessagingCellProps messagingCellProps2, t t3, EventListener eventListener4, EventFactory eventFactory5, zendesk.messaging.ui.AvatarStateRenderer avatarStateRenderer6, zendesk.messaging.ui.AvatarStateFactory avatarStateFactory7) {
        if (response instanceof MessagingItem.ArticlesResponse != null) {
            return MessagingCellFactory.createArticlesResponseCell((MessagingItem.ArticlesResponse)response, messagingCellProps2, eventListener4, eventFactory5, avatarStateFactory7, avatarStateRenderer6);
        }
        if (response instanceof MessagingItem.TransferResponse != null) {
            return MessagingCellFactory.createActionOptionsCell((MessagingItem.TransferResponse)response, messagingCellProps2, eventListener4, eventFactory5, avatarStateFactory7, avatarStateRenderer6);
        }
        if (response instanceof MessagingItem.ActionResponse != null) {
            return MessagingCellFactory.createActionOptionsCell((MessagingItem.ActionResponse)response, messagingCellProps2, eventListener4, eventFactory5, avatarStateFactory7, avatarStateRenderer6);
        }
        if (response instanceof MessagingItem.ImageResponse != null) {
            return MessagingCellFactory.createAgentImageCell((MessagingItem.ImageResponse)response, messagingCellProps2, t3, avatarStateFactory7, avatarStateRenderer6);
        }
        if (response instanceof MessagingItem.FileResponse != null) {
            return MessagingCellFactory.createAgentFileCell((MessagingItem.FileResponse)response, messagingCellProps2, avatarStateFactory7, avatarStateRenderer6);
        }
        if (response instanceof MessagingCellFactory.TypingItem) {
            return MessagingCellFactory.createTypingIndicatorCell((MessagingCellFactory.TypingItem)response, messagingCellProps2, avatarStateRenderer6, avatarStateFactory7);
        }
        if (response instanceof MessagingItem.TextResponse != null) {
            return MessagingCellFactory.createTextResponseCell((MessagingItem.TextResponse)response, messagingCellProps2, avatarStateRenderer6, avatarStateFactory7);
        }
        return null;
    }

    private static zendesk.messaging.ui.MessagingCell<zendesk.messaging.ui.ResponseOptionsViewState, ?> createResponseOptionsCell(MessagingItem.OptionsResponse messagingItem$OptionsResponse, zendesk.messaging.ui.MessagingCellProps messagingCellProps2, EventListener eventListener3, EventFactory eventFactory4, boolean z5) {
        MessagingCellFactory.4 anon = new MessagingCellFactory.4(eventListener3, eventFactory4, optionsResponse);
        ResponseOptionsViewState responseOptionsViewState = new ResponseOptionsViewState(optionsResponse.getOptions(), anon, messagingCellProps2);
        if (z5) {
            MessagingCell obj4 = new MessagingCell(optionsResponse.getId(), responseOptionsViewState, R.layout.zui_cell_response_options_stacked, StackedResponseOptionsView.class);
            return obj4;
        }
        obj4 = new MessagingCell(optionsResponse.getId(), responseOptionsViewState, R.layout.zui_cell_response_options, ResponseOptionsView.class);
        return obj4;
    }

    private static zendesk.messaging.ui.MessagingCell<zendesk.messaging.ui.SystemMessageView.State, zendesk.messaging.ui.SystemMessageView> createSystemMessageCell(MessagingItem.SystemMessage messagingItem$SystemMessage, zendesk.messaging.ui.MessagingCellProps messagingCellProps2) {
        SystemMessageView.State state = new SystemMessageView.State(messagingCellProps2, systemMessage.getSystemMessage());
        MessagingCell obj4 = new MessagingCell(systemMessage.getId(), state, R.layout.zui_cell_system_message, SystemMessageView.class);
        return obj4;
    }

    private static zendesk.messaging.ui.MessagingCell<zendesk.messaging.ui.EndUserCellMessageState, zendesk.messaging.ui.EndUserMessageView> createTextQueryCell(MessagingItem.TextQuery messagingItem$TextQuery, zendesk.messaging.ui.MessagingCellProps messagingCellProps2, EventListener eventListener3, EventFactory eventFactory4) {
        MessagingCellFactory.MessageActionAdapter messageActionAdapter = new MessagingCellFactory.MessageActionAdapter(eventListener3, textQuery, eventFactory4);
        super(textQuery.getId(), messagingCellProps2, textQuery.getStatus(), messageActionAdapter, textQuery.getMessage());
        MessagingCell obj8 = new MessagingCell(textQuery.getId(), endUserCellMessageState2, R.layout.zui_cell_end_user_message, EndUserMessageView.class);
        return obj8;
    }

    private static zendesk.messaging.ui.MessagingCell<zendesk.messaging.ui.AgentMessageView.State, zendesk.messaging.ui.AgentMessageView> createTextResponseCell(MessagingItem.TextResponse messagingItem$TextResponse, zendesk.messaging.ui.MessagingCellProps messagingCellProps2, zendesk.messaging.ui.AvatarStateRenderer avatarStateRenderer3, zendesk.messaging.ui.AvatarStateFactory avatarStateFactory4) {
        super(messagingCellProps2, textResponse.getMessage(), textResponse.getAgentDetails().getAgentName(), textResponse.getAgentDetails().isBot(), avatarStateFactory4.createAvatarState(textResponse.getAgentDetails()), avatarStateRenderer3);
        MessagingCell obj9 = new MessagingCell(textResponse.getId(), state, R.layout.zui_cell_agent_message_view, AgentMessageView.class);
        return obj9;
    }

    private static zendesk.messaging.ui.MessagingCell<zendesk.messaging.ui.TypingIndicatorView.State, zendesk.messaging.ui.TypingIndicatorView> createTypingIndicatorCell(zendesk.messaging.ui.MessagingCellFactory.TypingItem messagingCellFactory$TypingItem, zendesk.messaging.ui.MessagingCellProps messagingCellProps2, zendesk.messaging.ui.AvatarStateRenderer avatarStateRenderer3, zendesk.messaging.ui.AvatarStateFactory avatarStateFactory4) {
        super(messagingCellProps2, typingItem.getAgentDetails().getAgentName(), typingItem.getAgentDetails().isBot(), avatarStateFactory4.createAvatarState(typingItem.getAgentDetails()), avatarStateRenderer3);
        MessagingCell obj7 = new MessagingCell(MessagingCellFactory.TYPING_INDICATOR_ID, state, R.layout.zui_cell_typing_indicator, TypingIndicatorView.class);
        return obj7;
    }

    List<zendesk.messaging.ui.MessagingCell> createCells(List<MessagingItem> list, zendesk.messaging.ui.MessagingState.TypingState messagingState$TypingState2, t t3, AttachmentSettings attachmentSettings4) {
        AgentDetails dEFAULT_TYPING_INDICATOR_LABEL_STATE;
        zendesk.messaging.ui.MessagingCellFactory.TypingItem typingItem;
        Date date;
        int i2;
        String tYPING_INDICATOR_ID;
        int i;
        Object obj;
        t tVar;
        AttachmentSettings set;
        zendesk.messaging.ui.AvatarStateRenderer avatarStateRenderer;
        zendesk.messaging.ui.AvatarStateFactory avatarStateFactory;
        EventListener eventListener;
        EventFactory eventFactory;
        boolean multilineResponseOptionsEnabled;
        final Object obj2 = this;
        if (list == null) {
            return Collections.emptyList();
        }
        List list2 = a.c(list);
        if (typingState2 != null && typingState2.isTyping()) {
            if (typingState2.isTyping()) {
                if (typingState2.getAgentDetails() != null) {
                    dEFAULT_TYPING_INDICATOR_LABEL_STATE = typingState2.getAgentDetails();
                } else {
                    dEFAULT_TYPING_INDICATOR_LABEL_STATE = MessagingCellFactory.DEFAULT_TYPING_INDICATOR_LABEL_STATE;
                }
                typingItem = new MessagingCellFactory.TypingItem(obj2.dateProvider.now(), MessagingCellFactory.TYPING_INDICATOR_ID, dEFAULT_TYPING_INDICATOR_LABEL_STATE, 0);
                list2.add(typingItem);
            }
        }
        ArrayList arrayList = new ArrayList(list2.size());
        i2 = 0;
        while (i2 < list2.size()) {
            tYPING_INDICATOR_ID = MessagingCellFactory.createCell((MessagingItem)list2.get(i2), (MessagingCellProps)obj2.cellPropsFactory.create(list2).get(i2), t3, attachmentSettings4, obj2.avatarStateRenderer, obj2.avatarStateFactory, obj2.eventListener, obj2.eventFactory, obj2.multilineResponseOptionsEnabled);
            if (tYPING_INDICATOR_ID != null) {
            }
            i2++;
            arrayList.add(tYPING_INDICATOR_ID);
        }
        return arrayList;
    }
}
