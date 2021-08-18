package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int Blog_id;
    private String Blog_tieude;
    private String Blog_tomtat;
    private String Blog_noidung;

    public Blog() {
    }

    public Blog(int blog_id, String blog_tieude, String blog_tomtat, String blog_noidung) {
        Blog_id = blog_id;
        Blog_tieude = blog_tieude;
        Blog_tomtat = blog_tomtat;
        Blog_noidung = blog_noidung;
    }

    public int getBlog_id() {
        return Blog_id;
    }

    public void setBlog_id(int blog_id) {
        Blog_id = blog_id;
    }

    public String getBlog_tieude() {
        return Blog_tieude;
    }

    public void setBlog_tieude(String blog_tieude) {
        Blog_tieude = blog_tieude;
    }

    public String getBlog_tomtat() {
        return Blog_tomtat;
    }

    public void setBlog_tomtat(String blog_tomtat) {
        Blog_tomtat = blog_tomtat;
    }

    public String getBlog_noidung() {
        return Blog_noidung;
    }

    public void setBlog_noidung(String blog_noidung) {
        Blog_noidung = blog_noidung;
    }
}
