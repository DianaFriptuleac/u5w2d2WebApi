package dianafriptuleac.u5w2d2WebApi.services;

import dianafriptuleac.u5w2d2WebApi.entities.BlogPost;
import dianafriptuleac.u5w2d2WebApi.exceptions.NotFoundException;
import dianafriptuleac.u5w2d2WebApi.payloads.NewBlogPostPayload;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class BlogPostService {
    private List<BlogPost> blogPostList = new ArrayList<>();

    //Trova la lista
    public List<BlogPost> findAll() {
        return this.blogPostList;
    }

    // Salva un nuovo BlogPost alla lista
    public BlogPost saveBlogPost(NewBlogPostPayload body) {
        Random random = new Random();
        BlogPost newBlogPost = new BlogPost(body.getTitolo(), body.getContenuto(),
                body.getCategoria(), body.getTempoDiLettura());
        newBlogPost.setId(random.nextInt(1, 5000));
        newBlogPost.setCover("newCover");
        this.blogPostList.add(newBlogPost);
        return newBlogPost;
    }

    //Trova un blogPost per ID
    public BlogPost findById(long blogPostId) {
        return this.blogPostList.stream().filter(blogPost ->
                blogPost.getId() == blogPostId).findFirst().orElseThrow(() ->
                new NotFoundException(blogPostId));
    }

    //Trova per id and update
    public BlogPost findByIdAndUpdate(long blogPostId, NewBlogPostPayload body) {
        return this.blogPostList.stream().filter(blogPost -> blogPost.getId() == blogPostId).findFirst().map(blogPost ->
        {
            blogPost.setTitolo(body.getTitolo());
            blogPost.setContenuto(body.getContenuto());
            blogPost.setCategoria(body.getCategoria());
            blogPost.setTempoDiLettura(body.getTempoDiLettura());
            return blogPost;
        }).orElseThrow(() -> new NotFoundException(blogPostId));
    }

    //Trovo per id e cancello
    public void findByIdAndDelete(long blogPostId) {
        BlogPost blogPostDelete = this.blogPostList.stream().filter(blogPost -> blogPost.getId() == blogPostId).
                findFirst().orElseThrow(() -> new NotFoundException(blogPostId));
        this.blogPostList.remove(blogPostDelete);
    }
}
