package com.taskagile.domain.model.attachment.events;

import com.taskagile.domain.common.event.TriggeredBy;
import com.taskagile.domain.model.attachment.Attachment;
import com.taskagile.domain.model.attachment.AttachmentId;
import com.taskagile.domain.model.card.Card;
import com.taskagile.domain.model.card.events.CardDomainEvent;
import lombok.Getter;

@Getter
public class CardAttachmentAddedEvent extends CardDomainEvent {

    private static final long serialVersionUID = -7962885726212050836L;

    private final String cardTitle;
    private final AttachmentId attachmentId;
    private final String fileName;

    public CardAttachmentAddedEvent(Card card, Attachment attachment, TriggeredBy triggeredBy) {
        super(card.getId(), card.getTitle(), card.getBoardId(), triggeredBy);
        this.cardTitle = card.getTitle();
        this.attachmentId = attachment.getId();
        this.fileName = attachment.getFileName();
    }

    @Override
    public String toString() {
        return "CardAttachmentAddedEvent{" +
                "cardId=" + getCardId() +
                ", cardTitle='" + cardTitle + '\'' +
                ", attachmentId=" + attachmentId +
                ", fileName='" + fileName + '\'' +
                '}';
    }

}
