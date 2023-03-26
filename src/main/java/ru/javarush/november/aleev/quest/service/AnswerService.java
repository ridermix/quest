package ru.javarush.november.aleev.quest.service;

import ru.javarush.november.aleev.quest.entity.Answer;
import ru.javarush.november.aleev.quest.repository.AnswerRepository;
import ru.javarush.november.aleev.quest.repository.Repository;

public enum AnswerService {
    INSTANCE;

    private final Repository<Answer> answerRepository = AnswerRepository.get();

    public Answer get(Long id){
        return answerRepository.get(id);
    }
}
