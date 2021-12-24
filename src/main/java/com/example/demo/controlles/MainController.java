package com.example.demo.controlles;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller //Класс отвечающий за все переходы на сайте
public class MainController {

    @GetMapping("/") //Указываем какой именно url адресс мы обрабатываем (/ - главная страница) (обработка главной страницы) при переходе на главную страницу у нас будет вызываться функция ниже
    public String home(Model model) { // эта функция будет вызываться при переходе на главную страницу (Model model - один обязательный параметр, который всегда принимается)
        model.addAttribute("title", "Главная страница"); // тут мы указываем параметр title(тут любой может быть) и передаём текст о том, что это главная страница,
        // он будет передан в шаблон
        return "home"; //вызываем определённый html шаблон (home.html)
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("title", "Cтраница про нас");
        return "about";
    }

}