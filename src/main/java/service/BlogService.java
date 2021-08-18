package service;

import model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import repository.IBlogRepo;

import java.util.ArrayList;

public class BlogService implements IBlogRepo {
    @Autowired
    IBlogRepo iBlogRepo;


    @Override
    public Blog save(Blog blog) {
        return iBlogRepo.save(blog);
    }

    @Override
    public ArrayList<Blog> findAll() {
        return iBlogRepo.findAll();
    }

    @Override
    public void delete(Blog blog) {
        iBlogRepo.delete(blog);
    }

    @Override
    public void edit(Blog blog) {
        iBlogRepo.edit(blog);
    }
}
