package com.quizWeb.demo.Service;
import com.quizWeb.demo.Model.OptionModel;
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

    public void setOption(OptionModel option, Long questionId) {

        Question question= questionRepo.findById(questionId)
                .orElseThrow(() -> new RuntimeException("Question not found"));
        option.setQuestion(question);
        optionRepo.save(option);

    }

    public List<OptionModel> getAllOptions() {
        return optionRepo.findAll();
    }

    public OptionModel getOption(Long id) {
        return optionRepo.findById(id).get();
    }

    public OptionModel editOption(Long id, OptionModel option) {
        OptionModel currentOption = optionRepo.findById(id).get();
        currentOption.setOptionText(option.getOptionText());
        currentOption.setIsCorrect(option.getIsCorrect());
        return optionRepo.save(currentOption);
    }

    public OptionModel deleteOption(Long id) {
        OptionModel option = optionRepo.findById(id).get();
        optionRepo.deleteById(id);
        return option;
    }
}
