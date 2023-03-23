package ru.javarush.november.aleev.quest.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class Answer extends AbstractEntity{
    Long id;
    String text;
    Boolean isCorrect;
    Long questionId;
    Long nextQuestionId;

}
