package ru.javarush.november.aleev.quest.service;

import ru.javarush.november.aleev.quest.entity.Answer;
import ru.javarush.november.aleev.quest.repository.AnswerRepository;
import ru.javarush.november.aleev.quest.repository.Repository;

import java.util.Collection;
import java.util.stream.Collectors;

public enum AnswerService {
    INSTANCE;

    private final Repository<Answer> answerRepository = AnswerRepository.get();

//    public Collection<Answer> getAll(){
//        return answerRepository.getAll().collect(Collectors.toList());
//    }

    public Answer get(Long id){
        return answerRepository.get(id);
    }
}
