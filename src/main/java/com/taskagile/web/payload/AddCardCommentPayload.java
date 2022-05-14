package com.taskagile.web.payload;

import com.taskagile.domain.application.commands.AddCardCommentCommand;
import com.taskagile.domain.model.card.CardId;
import lombok.Setter;

@Setter
public class AddCardCommentPayload {

    private String comment;

    public AddCardCommentCommand toCommand(CardId cardId) {
        return new AddCardCommentCommand(cardId, comment);
    }

}
