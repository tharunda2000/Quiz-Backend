package com.quizWeb.demo.Controller;


import com.quizWeb.demo.Model.OptionModel;
import com.quizWeb.demo.Service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OptionController {
    @Autowired
    OptionService optionService;

    @PostMapping("/option")
    public OptionModel setOption(@RequestBody OptionModel option, @RequestParam Long questionId){
        return optionService.setOption(option,questionId);
    }

    @GetMapping("/options")
    public List<OptionModel> getAllOptions(){
        return optionService.getAllOptions();
    }

    @GetMapping("/option/{id}")
    public OptionModel getOption(@PathVariable Long id){
        return optionService.getOption(id);
    }

    @PutMapping("/option/{id}")
    public OptionModel editOption(@PathVariable Long id,@RequestBody OptionModel option){
        return optionService.editOption(id,option);
    }

    @DeleteMapping("/option/{id}")
    public OptionModel deleteOption(@PathVariable Long id){
        return optionService.deleteOption(id);

    }
}
