package com.taskagile.domain.application.commands;

import com.taskagile.domain.model.card.CardId;
import lombok.Getter;

@Getter
public class ChangeCardTitleCommand extends UserCommand {

    private final CardId cardId;
    private final String title;

    public ChangeCardTitleCommand(CardId cardId, String title) {
        this.cardId = cardId;
        this.title = title;
    }

}
