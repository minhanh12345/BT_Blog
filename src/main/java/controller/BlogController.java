package controller;

import model.Blog;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.BlogService;

import java.util.ArrayList;

@Controller
public class BlogController {
    ArrayList<Blog> list = new ArrayList<>();
    @Autowired
    BlogService blogService;

    @GetMapping("/show")
    public ModelAndView show() {
        ModelAndView modelAndView = new ModelAndView("show");
        list = blogService.findAll();
        modelAndView.addObject("listBlog", list);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView create() {
        return new ModelAndView("create");
    }

    @PostMapping("/create")
    public ModelAndView createBlog(@ModelAttribute Blog blog) {
        blogService.save(blog);
        return new ModelAndView("redirect:/show");
    }

    @GetMapping("/edit")
    public ModelAndView edit(@RequestParam int index) {
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("blog", blogService.findAll().get(index));
        return modelAndView;
    }
    @PostMapping("/edit")
    public ModelAndView editBlog(@ModelAttribute Blog blog){
        blogService.edit(blog);
        return new ModelAndView("redirect:/show");
    }
    @GetMapping("/delete")
    public ModelAndView delete(@RequestParam int index){
        blogService.delete(blogService.findAll().get(index));
        return new ModelAndView("redirect:/show");
    }
    @GetMapping("/view")
    public ModelAndView view(@RequestParam int index){
        ModelAndView modelAndView=new ModelAndView("view");
        modelAndView.addObject("blog",blogService.findAll().get(index));
        return modelAndView;
    }

}
