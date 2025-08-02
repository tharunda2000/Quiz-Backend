package com.quizWeb.demo.Controller;

import com.quizWeb.demo.Model.Option;
import com.quizWeb.demo.Service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OptionController {
    @Autowired
    OptionService optionService;

    @PostMapping("/option")
    public void setOption(@RequestBody Option option,@RequestParam Long questionId){
        optionService.setOption(option,questionId);
    }

    @GetMapping("/options")
    public List<Option> getAllOptions(){
        return optionService.getAllOptions();
    }

    @GetMapping("/option/{id}")
    public Option getOption(@PathVariable Long id){
        return optionService.getOption(id);
    }

    @PutMapping("/option/{id}")
    public Option editOption(@PathVariable Long id,@RequestBody Option option){
        return optionService.editOption(id,option);
    }

    @DeleteMapping("/option/{id}")
    public Option deleteOption(Long id){
        return optionService.deleteOption(id);

    }
}
