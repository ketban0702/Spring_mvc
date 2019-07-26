package controller;

import model.MyDictionary;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

/**
 * @author Minh_Nguyen on  7/16/2019
 * @Project DictionaryController
 * @Email:
 */
@Controller
public class DictionaryController {
    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String Search(){
        return "home";
    }
    @RequestMapping(value = "/home",method = RequestMethod.POST)
    public String Search(@RequestParam String inputWord, Model model){
        HashMap<String,String> list=new HashMap<>();
        list.put("hello","Xin chào");
        list.put("one","Một");
        list.put("two"," Hai");
        list.put("three"," Ba");
        String result=list.get(inputWord);
        //if(result !=null){
            //model.addAttribute("word",result);
        //}else
        //    model.addAttribute("word","Khong co");
        MyDictionary dic= new MyDictionary();
        dic.setInputName(inputWord);
        dic.setResult(result!=null? result:"Khong co");
        model.addAttribute("dic",dic);
        return "home";
    }
}
