package zendesk.messaging;

import android.content.Context;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes3.dex */
class MessagingEventSerializer {

    private static final int ARTICLE_OPENED_FORMATTER;
    private static final int ARTICLE_SUGGESTIONS_MESSAGE;
    private static final int DEFAULT_VISITOR_NAME;
    private static final int MESSAGE_FAILED_TO_SEND_WARNING;
    private static final int TRANSFER_OPTION_SELECTION_FORMATTER;
    private final Context context;
    private final zendesk.messaging.TimestampFactory timestampFactory;
    static {
        MessagingEventSerializer.DEFAULT_VISITOR_NAME = R.string.zui_message_log_default_visitor_name;
        MessagingEventSerializer.ARTICLE_SUGGESTIONS_MESSAGE = R.string.zui_message_log_article_suggestion_message;
        MessagingEventSerializer.ARTICLE_OPENED_FORMATTER = R.string.zui_message_log_article_opened_formatter;
        MessagingEventSerializer.TRANSFER_OPTION_SELECTION_FORMATTER = R.string.zui_message_log_transfer_option_selection_formatter;
        MessagingEventSerializer.MESSAGE_FAILED_TO_SEND_WARNING = R.string.zui_message_log_message_failed_to_send;
    }

    MessagingEventSerializer(Context context, zendesk.messaging.TimestampFactory timestampFactory2) {
        super();
        this.context = context;
        this.timestampFactory = timestampFactory2;
    }

    private String formatQuery(zendesk.messaging.MessagingItem.Query messagingItem$Query, String string2) {
        Object fAILED;
        int mESSAGE_FAILED_TO_SEND_WARNING;
        String obj6;
        if (query.getStatus() == MessagingItem.Query.Status.FAILED) {
            obj6 = new StringBuilder();
            obj6.append(this.context.getString(MessagingEventSerializer.MESSAGE_FAILED_TO_SEND_WARNING));
            obj6.append(" ");
            obj6 = obj6.toString();
        } else {
            obj6 = "";
        }
        Object[] arr = new Object[4];
        return String.format(Locale.US, "%s %s%s: %s", formatTimestamp(query.getTimestamp()), obj6, this.context.getString(MessagingEventSerializer.DEFAULT_VISITOR_NAME), string2);
    }

    private String formatResponse(zendesk.messaging.MessagingItem.Response messagingItem$Response, String string2) {
        Object[] arr = new Object[3];
        return String.format(Locale.US, "%s %s: %s", formatTimestamp(response.getTimestamp()), getAgentUserName(response.getAgentDetails()), string2);
    }

    private String formatResponseWithOptions(zendesk.messaging.MessagingItem.Response messagingItem$Response, String string2, List<String> list3) {
        String str;
        Object obj5;
        StringBuilder stringBuilder = new StringBuilder(string2);
        Iterator obj4 = list3.iterator();
        for (String obj5 : obj4) {
            stringBuilder.append("\n");
            stringBuilder.append("\t* ");
            stringBuilder.append(obj5);
        }
        return formatResponse(response, stringBuilder.toString());
    }

    private String formatTimestamp(Date date) {
        return this.timestampFactory.createTimestamp(date);
    }

    private String getAgentUserName(zendesk.messaging.AgentDetails agentDetails) {
        boolean obj3;
        StringBuilder stringBuilder = new StringBuilder(agentDetails.getAgentName());
        if (agentDetails.isBot()) {
            stringBuilder.append(" [bot]");
        }
        return stringBuilder.toString();
    }

    private String serializeArticleResponse(zendesk.messaging.MessagingItem.ArticlesResponse messagingItem$ArticlesResponse) {
        int articleUrl;
        List articleSuggestions = articlesResponse.getArticleSuggestions();
        ArrayList arrayList = new ArrayList(articleSuggestions.size());
        Iterator iterator = articleSuggestions.iterator();
        for (MessagingItem.ArticlesResponse.ArticleSuggestion next2 : iterator) {
            arrayList.add(next2.getArticleUrl());
        }
        return formatResponseWithOptions(articlesResponse, this.context.getString(MessagingEventSerializer.ARTICLE_SUGGESTIONS_MESSAGE), arrayList);
    }

    private String serializeArticleSuggestionSelectionEvent(zendesk.messaging.Event.ArticleSuggestionClicked event$ArticleSuggestionClicked) {
        final int i2 = 2;
        final Object[] arr2 = new Object[i2];
        final int i3 = 0;
        arr2[i3] = this.context.getString(MessagingEventSerializer.DEFAULT_VISITOR_NAME);
        int i = 1;
        arr2[i] = articleSuggestionClicked.getArticleSuggestion().getArticleUrl();
        Object[] arr = new Object[i2];
        arr[i3] = formatTimestamp(articleSuggestionClicked.getTimestamp());
        arr[i] = this.context.getString(MessagingEventSerializer.ARTICLE_OPENED_FORMATTER, arr2);
        return String.format(Locale.US, "%s %s", arr);
    }

    private String serializeEndUserQuery(zendesk.messaging.MessagingItem.Query messagingItem$Query) {
        if (query instanceof MessagingItem.TextQuery) {
            return formatQuery(query, (MessagingItem.TextQuery)query.getMessage());
        }
        if (query instanceof MessagingItem.ImageQuery) {
            return formatQuery(query, (MessagingItem.ImageQuery)query.getRemotePath());
        }
        if (query instanceof MessagingItem.FileQuery != null) {
            return formatQuery(query, (MessagingItem.FileQuery)query.getRemotePath());
        }
        return "";
    }

    private String serializeEngineSelectionEvent(zendesk.messaging.Event.EngineSelection event$EngineSelection) {
        final int i2 = 2;
        final Object[] arr2 = new Object[i2];
        final int i3 = 0;
        arr2[i3] = this.context.getString(MessagingEventSerializer.DEFAULT_VISITOR_NAME);
        int i = 1;
        arr2[i] = engineSelection.getSelectedEngine().getDisplayName();
        Object[] arr = new Object[i2];
        arr[i3] = formatTimestamp(engineSelection.getTimestamp());
        arr[i] = this.context.getString(MessagingEventSerializer.TRANSFER_OPTION_SELECTION_FORMATTER, arr2);
        return String.format(Locale.US, "%s %s", arr);
    }

    private String serializeEvent(zendesk.messaging.Event event) {
        if (event instanceof Event.ArticleSuggestionClicked) {
            return serializeArticleSuggestionSelectionEvent((Event.ArticleSuggestionClicked)event);
        }
        if (event instanceof Event.EngineSelection) {
            return serializeEngineSelectionEvent((Event.EngineSelection)event);
        }
        return "";
    }

    private String serializeFileResponse(zendesk.messaging.MessagingItem.FileResponse messagingItem$FileResponse) {
        return formatResponse(fileResponse, fileResponse.getRemotePath());
    }

    private String serializeImageResponse(zendesk.messaging.MessagingItem.ImageResponse messagingItem$ImageResponse) {
        return formatResponse(imageResponse, imageResponse.getRemotePath());
    }

    private String serializeMessagingItem(zendesk.messaging.MessagingItem messagingItem) {
        if (messagingItem instanceof MessagingItem.Response != null) {
            return serializeResponse((MessagingItem.Response)messagingItem);
        }
        if (messagingItem instanceof MessagingItem.Query) {
            return serializeEndUserQuery((MessagingItem.Query)messagingItem);
        }
        return "";
    }

    private String serializeResponse(zendesk.messaging.MessagingItem.Response messagingItem$Response) {
        if (response instanceof MessagingItem.TextResponse != null) {
            return serializeTextResponse((MessagingItem.TextResponse)response);
        }
        if (response instanceof MessagingItem.ImageResponse != null) {
            return serializeImageResponse((MessagingItem.ImageResponse)response);
        }
        if (response instanceof MessagingItem.FileResponse != null) {
            return serializeFileResponse((MessagingItem.FileResponse)response);
        }
        if (response instanceof MessagingItem.ArticlesResponse != null) {
            return serializeArticleResponse((MessagingItem.ArticlesResponse)response);
        }
        if (response instanceof MessagingItem.TransferResponse != null) {
            return serializeTransferOptionsResponse((MessagingItem.TransferResponse)response);
        }
        return "";
    }

    private String serializeTextResponse(zendesk.messaging.MessagingItem.TextResponse messagingItem$TextResponse) {
        return formatResponse(textResponse, textResponse.getMessage());
    }

    private String serializeTransferOptionsResponse(zendesk.messaging.MessagingItem.TransferResponse messagingItem$TransferResponse) {
        int displayName;
        List engineOptions = transferResponse.getEngineOptions();
        ArrayList arrayList = new ArrayList(engineOptions.size());
        Iterator iterator = engineOptions.iterator();
        for (Engine.TransferOptionDescription next2 : iterator) {
            arrayList.add(next2.getDisplayName());
        }
        return formatResponseWithOptions(transferResponse, transferResponse.getMessage(), arrayList);
    }

    String serialize(zendesk.messaging.MessagingEvent messagingEvent) {
        if (messagingEvent instanceof Event) {
            return serializeEvent((Event)messagingEvent);
        }
        if (messagingEvent instanceof MessagingItem) {
            return serializeMessagingItem((MessagingItem)messagingEvent);
        }
        return "";
    }
}
