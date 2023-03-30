package ru.javarush.november.aleev.quest.entity;

import lombok.*;

@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class Answer extends AbstractEntity{
    Long id;
    String text;
    Boolean correct;
    Long questionId;
    Long nextQuestionId;

}
