package zendesk.support;

import f.g.e.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class TicketField {

    private String description;
    private long id;
    private String regexpForValidation;
    private List<zendesk.support.TicketFieldOption> ticketFieldOptions;
    private List<zendesk.support.TicketFieldSystemOption> ticketFieldSystemOptions;
    private String title;
    private String titleInPortal;
    private zendesk.support.TicketFieldType type;
    TicketField(long l, zendesk.support.TicketFieldType ticketFieldType2, String string3, String string4, String string5, String string6, List<zendesk.support.TicketFieldOption> list7, List<zendesk.support.TicketFieldSystemOption> list8) {
        super();
        this.id = l;
        this.type = string3;
        this.title = string4;
        this.titleInPortal = string5;
        this.description = string6;
        this.regexpForValidation = list7;
        this.ticketFieldOptions = list8;
        this.ticketFieldSystemOptions = obj9;
    }

    static zendesk.support.TicketField create(zendesk.support.RawTicketField rawTicketField) {
        zendesk.support.TicketFieldType unknown;
        zendesk.support.TicketFieldOption create;
        boolean create2;
        ArrayList arrayList = new ArrayList();
        Iterator iterator = rawTicketField.getCustomFieldOptions().iterator();
        for (RawTicketFieldOption next3 : iterator) {
            arrayList.add(TicketFieldOption.create(next3));
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator iterator2 = rawTicketField.getSystemFieldOptions().iterator();
        for (RawTicketFieldSystemOption next2 : iterator2) {
            arrayList2.add(TicketFieldSystemOption.create(next2));
        }
        if (rawTicketField.getType() != null) {
            unknown = rawTicketField.getType();
        } else {
            unknown = TicketFieldType.Unknown;
        }
        super(rawTicketField.getId(), obj2, unknown, rawTicketField.getTitle(), rawTicketField.getTitleInPortal(), rawTicketField.getDescription(), rawTicketField.getRegexpForValidation(), arrayList, arrayList2);
        return ticketField;
    }

    public String getDescription() {
        return this.description;
    }

    public long getId() {
        return this.id;
    }

    public String getRegexpForValidation() {
        return this.regexpForValidation;
    }

    public List<zendesk.support.TicketFieldOption> getTicketFieldOptions() {
        return a.c(this.ticketFieldOptions);
    }

    public List<zendesk.support.TicketFieldSystemOption> getTicketFieldSystemOptions() {
        return a.c(this.ticketFieldSystemOptions);
    }

    public String getTitle() {
        return this.title;
    }

    public String getTitleInPortal() {
        return this.titleInPortal;
    }

    public zendesk.support.TicketFieldType getType() {
        return this.type;
    }
}
