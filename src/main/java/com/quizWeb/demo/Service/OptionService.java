package com.quizWeb.demo.Service;

import com.quizWeb.demo.Model.Option;
import com.quizWeb.demo.Model.Question;
import com.quizWeb.demo.Repository.OptionRepository;
import com.quizWeb.demo.Repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionService {
    
    @Autowired
    OptionRepository optionRepo;
    @Autowired
    QuestionRepository questionRepo;

    public void setOption(Option option, Long questionId) {

        Question question= questionRepo.findById(questionId)
                .orElseThrow(() -> new RuntimeException("Question not found"));
        option.setQuestion(question);
        optionRepo.save(option);

    }

    public List<Option> getAllOptions() {
        return optionRepo.findAll();
    }

    public Option getOption(Long id) {
        return optionRepo.findById(id).get();
    }

    public Option editOption(Long id, Option option) {
        Option currentOption = optionRepo.findById(id).get();
        currentOption.setOption(option.getOption());
        currentOption.setIsCorrect(option.getIsCorrect());
        return optionRepo.save(currentOption);
    }

    public Option deleteOption(Long id) {
        Option option = optionRepo.findById(id).get();
        optionRepo.deleteById(id);
        return option;
    }
}
