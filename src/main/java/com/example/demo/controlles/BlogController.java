package com.example.demo.controlles;

import com.example.demo.models.Post;
import com.example.demo.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class BlogController {

    @Autowired // анотация для создания переменной, которая ссылается на репозиторий в нашем случае(PostRepository)
    private PostRepository postRepository;

    @GetMapping("/blog")
    public String blogMain(Model model){
        Iterable<Post> posts = postRepository.findAll(); //Iterable массив данных, в котором будут содержаться полностью все значения полученные из определённое таблички данных
        //findAll вытянит все данные из таблички Post
        model.addAttribute("posts", posts); // будем передавать все найденные посты, по имени ("posts"), а в качестве значения массив со всеми поставми как бы тоже posts
        return "blog-main";
    }

    @GetMapping("/sign")
    public String singIN(Model model){
        return "sign_inn";
    }

    @GetMapping("/blog/add")
    public String blogAdd(Model model){
        return "blog-add";
    }

    @PostMapping("/blog/add")
    public String blogPostAdd(@RequestParam String title, @RequestParam String anons, @RequestParam String full_text, Model model){ //@RequestParam получаем все значения из формочки (добавить статью)
        Post post = new Post(title, anons, full_text); // Экземпляр класса Post
        postRepository.save(post);
        return "redirect:/blog";
    }

    @GetMapping("/blog/{id}")
    public String blogDetails(@PathVariable(value = "id") long id, Model model){ //{id} Чтобы брать динамическое значение из url адреса, нужна аннотация @PathVariable()
        if(!postRepository.existsById(id)) { // existsById() True, если запись по определённому id была найдена. False - иначе
            return "redirect:/blog";
        }
        Optional<Post> post = postRepository.findById(id);
        ArrayList<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);

        return "blog-details";
    }
    @GetMapping("/blog/{id}/edit")
    public String blogEdit(@PathVariable(value = "id") long id, Model model){ //{id} Чтобы брать динамическое значение из url адреса, нужна аннотация @PathVariable()
        if(!postRepository.existsById(id)) { // existsById() True, если запись по определённому id была найдена. False - иначе
            return "redirect:/blog";
        }
        Optional<Post> post = postRepository.findById(id);
        ArrayList<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return "blog-edit";
    }

    @PostMapping("/blog/{id}/edit")
    public String blogPostUpdate(@PathVariable(value = "id") long id, @RequestParam String title, @RequestParam String anons, @RequestParam String full_text, Model model){ //@RequestParam получаем все значения из формочки (добавить статью)
        Post post = postRepository.findById(id).orElseThrow();
        post.setTitle(title);
        post.setAnons(anons);
        post.setFull_text(full_text);
        postRepository.save(post);
        return "redirect:/blog";
    }
    @PostMapping("/blog/{id}/remove")
    public String blogPostDelete(@PathVariable(value = "id") long id, Model model){ //@RequestParam получаем все значения из формочки (добавить статью)
        Post post = postRepository.findById(id).orElseThrow(); // находим определённый пост
        postRepository.delete(post);
        return "redirect:/blog";
    }
}
