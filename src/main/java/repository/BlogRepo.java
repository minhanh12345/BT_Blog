package repository;

import model.Blog;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.ArrayList;

public class BlogRepo implements IBlogRepo {
    @Autowired
    EntityManager entityManager;

    @Override
    public Blog save(Blog blog) {
        EntityTransaction txn = entityManager.getTransaction();
        txn.begin();
        entityManager.persist(blog);
        txn.commit();
        return blog;
    }

    @Override
    public ArrayList<Blog> findAll() {
        String query = "Select c from Blog as c";
        TypedQuery<Blog> query1 = entityManager.createQuery(query, Blog.class);
        return (ArrayList<Blog>) query1.getResultList();
    }

    @Override
    public void delete(Blog blog) {
        EntityTransaction txn = entityManager.getTransaction();
        txn.begin();
        entityManager.remove(blog);
        txn.commit();
    }

    @Override
    public void edit(Blog blog) {
        EntityTransaction txn = entityManager.getTransaction();
        txn.begin();
        entityManager.merge(blog);
        txn.commit();
    }
}
