//package com.example.blog.repository;
//
//import com.example.blog.model.Posteo;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Repository
//public class PosteoRepository implements IposteoRepository {
//    public final List<Posteo> posteos = new ArrayList<>();
//
//    public PosteoRepository(){
//        posteos.add(new Posteo(1L, "Tips para aprender a cocinar", "Flor Ortiz" ));
//        posteos.add(new Posteo(2L, "Trucos para cocinar delicioso", "Lina Sandoval" ));
//    }
//
//    @Override
//    public List<Posteo> findAll() {
//        return posteos;
//    }
//
//    @Override
//    public Posteo findById(Long id) {
//        for(Posteo posteo : posteos){
//            if(posteo.getId().equals(id)){
//                return posteo;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public void save(Posteo posteo) {
//        posteos.add(posteo);
//    }
//}
