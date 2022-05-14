package com.taskagile.domain.application.commands;

import com.taskagile.domain.model.card.CardId;
import lombok.Getter;

@Getter
public class AddCardCommentCommand extends UserCommand {

    private final CardId cardId;
    private final String comment;

    public AddCardCommentCommand(CardId cardId, String comment) {
        this.cardId = cardId;
        this.comment = comment;
    }

}
