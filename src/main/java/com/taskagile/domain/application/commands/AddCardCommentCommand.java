package com.taskagile.domain.application.commands;

import com.taskagile.domain.model.card.CardId;
import com.taskagile.domain.model.user.UserId;
import lombok.Getter;

@Getter
public class AddCardCommentCommand {

    private final UserId userId;
    private final CardId cardId;
    private final String comment;

    public AddCardCommentCommand(CardId cardId, String comment, UserId userId) {
        this.userId = userId;
        this.cardId = cardId;
        this.comment = comment;
    }

}
