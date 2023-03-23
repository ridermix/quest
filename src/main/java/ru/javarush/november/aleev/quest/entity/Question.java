package ru.javarush.november.aleev.quest.entity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Collection;

@Data
@EqualsAndHashCode
@Builder
public class Question extends AbstractEntity{
    Long id;
    String text;
    Long questId;
    Long correctQuestionId;
    Long incorrectQuestionId;
    Collection<Answer> answers;
}
