package io.thirdplanet.demo_data.domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public
class Game{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id ;
    String title ;
    String developer ;

    public void setId(Long id){
        this.id = id ;
    }
    public Long getId(){
        return id ;
    } 


    public void setTitle(String title){
        this.title = title ;
    }
    public String getTitle(){
        return title ;
    }


    public void setDeveloper(String developer){
        this.developer = developer ;
    }
    public String getAuthor(){
        return developer ;
    }
}