package ru.javarush.november.aleev.quest.service;

import ru.javarush.november.aleev.quest.entity.Question;
import ru.javarush.november.aleev.quest.repository.QuestionRepository;
import ru.javarush.november.aleev.quest.repository.Repository;

import java.util.Collection;
import java.util.stream.Collectors;

public enum QuestionService {
    INSTANCE;

    private final Repository<Question> questionRepository = QuestionRepository.get();

//    public Collection<Question> getAll(){
//        return questionRepository.getAll().collect(Collectors.toList());
//    }
    public Question get(Long id){
        return questionRepository.get(id);
    }
}
