package blog.sirico.Blog;

import java.util.*;


public class Posts implements Iterable<Post> {
    private List<Post> posts;
    private XML xml;

    public Posts(String filename){
        xml = new XML(filename);
        posts = xml.getPosts();
    }
    
    public void addPost(Post post){
        posts.add(post);
        xml.addPost(post);
    }

    public List<Post> getPosts(){
        return posts;
    }


    public Post getPost(String id){
        for(Post post : posts){
            if(post.getId().equals(id)){
                return post;
            }
        }
        return null;
    }
    
    public void addView(String id){
        Post post = getPost(id);
        if(post != null){
            post.addView();
            xml.addView(id);
        }
    }

    public void addComment(String id, Comment comment) {
        Post post = getPost(id);
        if(post != null){
            post.addComment(comment);
            xml.addComment(id, comment);
        }
    }

    @Override
    public Iterator<Post> iterator() {
        return posts.iterator();
    }

}
