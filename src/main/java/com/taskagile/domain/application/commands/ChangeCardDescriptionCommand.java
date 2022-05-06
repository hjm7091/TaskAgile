package com.taskagile.domain.application.commands;

import com.taskagile.domain.model.card.CardId;
import lombok.Getter;

@Getter
public class ChangeCardDescriptionCommand {

    private final CardId cardId;
    private final String description;

    public ChangeCardDescriptionCommand(CardId cardId, String description) {
        this.cardId = cardId;
        this.description = description;
    }

}
