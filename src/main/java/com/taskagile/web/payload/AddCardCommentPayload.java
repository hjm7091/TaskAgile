package com.taskagile.web.payload;

import com.taskagile.domain.application.commands.AddCardCommentCommand;
import com.taskagile.domain.model.card.CardId;
import com.taskagile.domain.model.user.UserId;
import lombok.Setter;

@Setter
public class AddCardCommentPayload {

    private String comment;

    public AddCardCommentCommand toCommand(CardId cardId, UserId userId) {
        return new AddCardCommentCommand(cardId, comment, userId);
    }

}
